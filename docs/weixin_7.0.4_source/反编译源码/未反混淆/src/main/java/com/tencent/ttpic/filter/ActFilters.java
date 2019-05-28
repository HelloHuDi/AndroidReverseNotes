package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.CameraActItem;
import com.tencent.ttpic.model.CanvasItem;
import com.tencent.ttpic.model.CaptureActItem;
import com.tencent.ttpic.model.FaceExpression;
import com.tencent.ttpic.model.FrameSourceItem;
import com.tencent.ttpic.model.Rect;
import com.tencent.ttpic.model.SingleScoreActItem;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.model.StarActItem;
import com.tencent.ttpic.model.TotalScoreActItem;
import com.tencent.ttpic.model.VideoActItem;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.ActUtil.FRAME_SOURCE_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.PlayerUtil;
import com.tencent.ttpic.util.PlayerUtil.Player;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoPrefsUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActFilters {
    private static final String TAG = ActFilters.class.getSimpleName();
    private static Comparator<CanvasItem> actItemComparator = new Comparator<CanvasItem>() {
        public final int compare(CanvasItem canvasItem, CanvasItem canvasItem2) {
            return canvasItem.zIndex - canvasItem2.zIndex;
        }
    };
    private String dataPath;
    private long duration;
    private FaceExpression faceExpression;
    private long lastUpdateIndex = Long.MAX_VALUE;
    private boolean mAudioPause;
    private h mCanvasFrame = new h();
    private FrameBaseFilter mCopyFilter = new FrameBaseFilter();
    private Player mPlayer;
    private FrameVideoFilter mVideoFilter = new FrameVideoFilter();
    private Map<Integer, FrameSourceItem> sourceItems;
    private long startUpdateTime = -1;

    static {
        AppMethodBeat.i(81947);
        AppMethodBeat.o(81947);
    }

    public ActFilters(FaceExpression faceExpression, String str) {
        AppMethodBeat.i(81935);
        this.faceExpression = faceExpression;
        this.duration = (long) Math.max(faceExpression.frameDuration * ((double) faceExpression.frames), 1.0d);
        this.dataPath = str;
        initFrameSourceItems(faceExpression);
        AppMethodBeat.o(81935);
    }

    private void initFrameSourceItems(FaceExpression faceExpression) {
        AppMethodBeat.i(81936);
        if (faceExpression.canvasSize == null) {
            faceExpression.canvasSize = new SizeI(720, ActUtil.HEIGHT);
        }
        if (faceExpression.canvasSize.width * faceExpression.canvasSize.height <= 0) {
            faceExpression.canvasSize = new SizeI(720, ActUtil.HEIGHT);
        }
        this.sourceItems = new HashMap();
        this.sourceItems.put(Integer.valueOf(FRAME_SOURCE_TYPE.CAMERA.value), new CameraActItem(this.mCopyFilter));
        this.sourceItems.put(Integer.valueOf(FRAME_SOURCE_TYPE.VIDEO.value), new VideoActItem(this.dataPath + File.separator + ActUtil.EXPRESSION + File.separator + faceExpression.videoID, this.mVideoFilter));
        CaptureActItem captureActItem = new CaptureActItem(faceExpression.expressionList, this.dataPath, faceExpression.scoreImageID, this.mCopyFilter);
        this.sourceItems.put(Integer.valueOf(FRAME_SOURCE_TYPE.CAPTURE.value), captureActItem);
        this.sourceItems.put(Integer.valueOf(FRAME_SOURCE_TYPE.STAR_IMAGE.value), new StarActItem(faceExpression.expressionList, this.dataPath, this.mCopyFilter));
        this.sourceItems.put(Integer.valueOf(FRAME_SOURCE_TYPE.TOTAL_SCORE.value), new TotalScoreActItem(captureActItem, this.mCopyFilter));
        this.sourceItems.put(Integer.valueOf(FRAME_SOURCE_TYPE.SINGEL_SCORE.value), new SingleScoreActItem(captureActItem, this.mCopyFilter));
        AppMethodBeat.o(81936);
    }

    public h updateAndRender(h hVar, long j, List<List<PointF>> list, List<float[]> list2, int i) {
        int i2;
        AppMethodBeat.i(81937);
        if (this.startUpdateTime <= 0) {
            this.startUpdateTime = j;
        }
        if (VideoPrefsUtil.getMaterialMute() || this.mAudioPause) {
            destroyAudio();
        } else if (this.mPlayer == null) {
            createAudioPlayer();
            PlayerUtil.seekPlayer(this.mPlayer, (int) ((j - this.startUpdateTime) % this.duration));
        } else {
            PlayerUtil.startPlayer(this.mPlayer, false);
        }
        int i3 = (int) (((double) ((j - this.startUpdateTime) % this.duration)) / this.faceExpression.frameDuration);
        if (((long) i3) < this.lastUpdateIndex) {
            reset(j);
            i2 = 0;
        } else {
            i2 = i3;
        }
        this.lastUpdateIndex = (long) i2;
        for (FrameSourceItem update : this.sourceItems.values()) {
            update.update(hVar, (long) i2, list, list2, i);
        }
        this.mCanvasFrame.a(-1, this.mCanvasFrame.width, this.mCanvasFrame.height, 0.0d);
        render((long) i2);
        float[] calPositions = AlgoUtils.calPositions(new Rect(0, 0, hVar.width, hVar.height), this.mCanvasFrame.width, this.mCanvasFrame.height, hVar.width, hVar.height, this.faceExpression.canvasResizeMode);
        float[] calTexCords = AlgoUtils.calTexCords(new Rect(0, 0, hVar.width, hVar.height), this.mCanvasFrame.width, this.mCanvasFrame.height, this.faceExpression.canvasResizeMode);
        if (needResize(calPositions, calTexCords)) {
            BenchUtil.benchStart(TAG + "[resize]");
            this.mCopyFilter.setPositions(calPositions);
            this.mCopyFilter.setTexCords(calTexCords);
            this.mCopyFilter.RenderProcess(this.mCanvasFrame.texture[0], hVar.width, hVar.height, -1, 0.0d, hVar);
            BenchUtil.benchEnd(TAG + "[resize]");
            AppMethodBeat.o(81937);
            return hVar;
        }
        hVar = this.mCanvasFrame;
        AppMethodBeat.o(81937);
        return hVar;
    }

    private void render(long j) {
        AppMethodBeat.i(81938);
        List canvasItems = getCanvasItems(this.faceExpression.canvasItemList, j);
        Collections.sort(canvasItems, actItemComparator);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < canvasItems.size()) {
                CanvasItem canvasItem = (CanvasItem) canvasItems.get(i2);
                ((FrameSourceItem) this.sourceItems.get(Integer.valueOf(canvasItem.type))).draw(this.mCanvasFrame, canvasItem, j);
                i = i2 + 1;
            } else {
                AppMethodBeat.o(81938);
                return;
            }
        }
    }

    public void reset(long j) {
        AppMethodBeat.i(81939);
        this.startUpdateTime = j;
        this.lastUpdateIndex = Long.MAX_VALUE;
        for (FrameSourceItem reset : this.sourceItems.values()) {
            reset.reset();
        }
        createAudioPlayer();
        PlayerUtil.startPlayer(this.mPlayer, true);
        AppMethodBeat.o(81939);
    }

    public void reset() {
        this.startUpdateTime = -1;
    }

    private List<CanvasItem> getCanvasItems(List<CanvasItem> list, long j) {
        AppMethodBeat.i(81940);
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            AppMethodBeat.o(81940);
            return arrayList;
        }
        for (CanvasItem canvasItem : list) {
            if (((long) canvasItem.startTime) <= j && j <= ((long) canvasItem.endTime)) {
                arrayList.add(canvasItem);
            }
        }
        AppMethodBeat.o(81940);
        return arrayList;
    }

    private boolean needResize(float[] fArr, float[] fArr2) {
        AppMethodBeat.i(81941);
        if (Float.compare(fArr[0], -1.0f) == 0 && Float.compare(fArr[1], -1.0f) == 0 && Float.compare(fArr2[0], 0.0f) == 0 && Float.compare(fArr2[1], 0.0f) == 0) {
            AppMethodBeat.o(81941);
            return false;
        }
        AppMethodBeat.o(81941);
        return true;
    }

    public Map<Integer, FrameSourceItem> getSourceItems() {
        return this.sourceItems;
    }

    public void setSourceItems(Map<Integer, FrameSourceItem> map) {
        this.sourceItems = map;
    }

    public void clear() {
        AppMethodBeat.i(81942);
        this.mCopyFilter.clearGLSLSelf();
        this.mVideoFilter.clearGLSLSelf();
        this.mCanvasFrame.clear();
        for (FrameSourceItem clear : this.sourceItems.values()) {
            clear.clear();
        }
        AppMethodBeat.o(81942);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(81943);
        this.mCopyFilter.ApplyGLSLFilter();
        this.mVideoFilter.ApplyGLSLFilter();
        for (FrameSourceItem init : this.sourceItems.values()) {
            init.init();
        }
        this.mCanvasFrame.a(-1, this.faceExpression.canvasSize.width, this.faceExpression.canvasSize.height, 0.0d);
        AppMethodBeat.o(81943);
    }

    private void createAudioPlayer() {
        AppMethodBeat.i(81944);
        String str = this.dataPath + File.separator + ActUtil.EXPRESSION + File.separator + this.faceExpression.audioID;
        if (!(TextUtils.isEmpty(str) || this.mPlayer != null || VideoPrefsUtil.getMaterialMute())) {
            this.mPlayer = PlayerUtil.createPlayer(VideoGlobalContext.getContext(), str, false);
        }
        AppMethodBeat.o(81944);
    }

    public void destroyAudio() {
        AppMethodBeat.i(81945);
        PlayerUtil.destroyPlayer(this.mPlayer);
        this.mPlayer = null;
        AppMethodBeat.o(81945);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(81946);
        this.mCopyFilter.setRenderMode(i);
        this.mVideoFilter.setRenderMode(i);
        AppMethodBeat.o(81946);
    }

    public void setAudioPause(boolean z) {
        this.mAudioPause = z;
    }
}
