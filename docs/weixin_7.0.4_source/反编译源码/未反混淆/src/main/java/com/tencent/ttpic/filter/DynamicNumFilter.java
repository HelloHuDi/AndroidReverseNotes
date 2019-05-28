package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.filter.m.b;
import com.tencent.filter.m.d;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.j;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.TRIGGERED_STATUS;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.PlayerUtil;
import com.tencent.ttpic.util.PlayerUtil.Player;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoPrefsUtil;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicNumFilter extends NormalVideoFilter {
    private static final String TAG = NormalVideoFilter.class.getSimpleName();
    private Point canvasCenter;
    private long frameStartTime;
    private PointF mAnchor;
    private float mAngle;
    private Map<String, Point> mBitSizeMap;
    private float[] mFaceAngles;
    private List<PointF> mFacePoints;
    private boolean mIsUnitExists;
    private int mLastBitIndex;
    private Map<String, Integer> mLastImageIndexMap;
    private int mNum;
    private Player mPlayer;
    protected k mTextureParam;
    private long mTimestamp;
    protected int playCount;
    protected boolean triggered;

    static {
        AppMethodBeat.i(82172);
        AppMethodBeat.o(82172);
    }

    public DynamicNumFilter(StickerItem stickerItem, String str) {
        super(stickerItem, str);
        AppMethodBeat.i(82159);
        this.triggered = false;
        this.playCount = 0;
        this.mAnchor = new PointF();
        this.mNum = -1;
        this.mLastImageIndexMap = new HashMap();
        this.mBitSizeMap = new HashMap();
        this.mLastBitIndex = -1;
        this.mIsUnitExists = false;
        this.mNum = -1;
        AppMethodBeat.o(82159);
    }

    public void initParams() {
        AppMethodBeat.i(82160);
        addParam(new i("texNeedTransform", 1));
        addParam(new b("canvasSize", 0.0f, 0.0f));
        addParam(new b("texAnchor", 0.0f, 0.0f));
        addParam(new f("texScale", 1.0f));
        addParam(new d("texRotate", 0.0f, 0.0f, 0.0f));
        addParam(new f("positionRotate", 0.0f));
        addParam(new i("blendMode", this.item.blendMode));
        addParam(new j("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0f, 4.0f, 10.0f)));
        AppMethodBeat.o(82160);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(82161);
        super.updateVideoSize(i, i2, d);
        this.canvasCenter = new Point(i / 2, i2 / 2);
        addParam(new b("canvasSize", (float) i, (float) i2));
        AppMethodBeat.o(82161);
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.i(82162);
        updatePlayer(updateActionTriggered(pTDetectInfo) == TRIGGERED_STATUS.FIRST_TRIGGERED);
        if (needClearTexture()) {
            clearTextureParam();
            this.triggered = false;
            this.playCount = 0;
            this.mTimestamp = -1;
            this.mNum = -1;
            AppMethodBeat.o(82162);
            return;
        }
        this.mTimestamp = pTDetectInfo.timestamp;
        updatePositions(pTDetectInfo.facePoints, pTDetectInfo.faceAngles, pTDetectInfo.phoneAngle);
        AppMethodBeat.o(82162);
    }

    /* Access modifiers changed, original: protected */
    public boolean needClearTexture() {
        return this.item.triggerType != PTExpression.ALWAYS.value && (!this.triggered || (this.item.playCount != 0 && this.playCount >= this.item.playCount));
    }

    public void clearTextureParam() {
        AppMethodBeat.i(82163);
        if (this.mTextureParam != null) {
            this.mTextureParam.clear();
            this.mTextureParam = null;
        }
        setPositions(GlUtil.EMPTY_POSITIONS);
        AppMethodBeat.o(82163);
    }

    /* Access modifiers changed, original: protected */
    public void updatePositions(List<PointF> list, float[] fArr, float f) {
        AppMethodBeat.i(82164);
        if (BaseUtils.isEmpty(list) || fArr == null || fArr.length < 3) {
            clearTextureParam();
            this.mFacePoints = null;
            this.mFaceAngles = null;
            this.mAngle = 0.0f;
            this.mNum = -1;
            AppMethodBeat.o(82164);
            return;
        }
        this.mFacePoints = list;
        this.mFaceAngles = fArr;
        this.mAngle = f;
        AppMethodBeat.o(82164);
    }

    private void updateTextureParam(String str, int i, long j, int i2) {
        AppMethodBeat.i(82165);
        String str2 = str + "_" + (i == -1 ? VideoMaterialUtil.CRAZYFACE_X : Integer.valueOf(i));
        int max = (int) (((double) (j - this.frameStartTime)) / Math.max(this.item.frameDuration, 1.0d));
        if (max >= this.item.frames * (this.playCount + 1) && !VideoPrefsUtil.getMaterialMute()) {
            this.playCount++;
            PlayerUtil.startPlayer(this.mPlayer, true);
        }
        int max2 = max % Math.max(this.item.frames, 1);
        if (i2 == this.mLastBitIndex && this.mLastImageIndexMap.containsKey(str2) && max2 == ((Integer) this.mLastImageIndexMap.get(str2)).intValue() && this.mTextureParam != null) {
            AppMethodBeat.o(82165);
            return;
        }
        Bitmap nextFrame = getNextFrame(str, i, max2);
        if (!BitmapUtils.isLegal(nextFrame) || needClearTexture()) {
            clearTextureParam();
            AppMethodBeat.o(82165);
            return;
        }
        if (i == -1) {
            this.mIsUnitExists = true;
        }
        if (!this.mBitSizeMap.containsKey(str2)) {
            this.mBitSizeMap.put(str2, new Point(nextFrame.getWidth(), nextFrame.getHeight()));
        }
        try {
            if (this.mTextureParam != null) {
                this.mTextureParam.m(nextFrame);
            } else {
                this.mTextureParam = new k("inputImageTexture2", nextFrame, 33986, false);
                this.mTextureParam.initialParams(getProgramIds());
                addParam(this.mTextureParam);
            }
        } catch (Exception e) {
            com.tencent.util.i.m(this, e.getMessage());
        }
        this.mLastImageIndexMap.put(str + "_" + (i == -1 ? VideoMaterialUtil.CRAZYFACE_X : Integer.valueOf(i)), Integer.valueOf(max2));
        AppMethodBeat.o(82165);
    }

    private Bitmap getNextFrame(String str, int i, int i2) {
        AppMethodBeat.i(82166);
        Bitmap loadImage = VideoMemoryManager.getInstance().loadImage(str, str + "_" + i2 + "_" + (i == -1 ? VideoMaterialUtil.CRAZYFACE_X : Integer.valueOf(i)) + ".png");
        if (BitmapUtils.isLegal(loadImage)) {
            AppMethodBeat.o(82166);
            return loadImage;
        }
        loadImage = loadFromAssetsOrFile(str, i, i2);
        AppMethodBeat.o(82166);
        return loadImage;
    }

    private Bitmap loadFromAssetsOrFile(String str, int i, int i2) {
        AppMethodBeat.i(82167);
        String str2 = this.dataPath + File.separator + str + File.separator + str + "_" + i2 + "_" + (i == -1 ? VideoMaterialUtil.CRAZYFACE_X : Integer.valueOf(i)) + ".png";
        Bitmap decodeSampledBitmapFromAssets;
        if (this.dataPath.startsWith("assets://")) {
            decodeSampledBitmapFromAssets = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(str2), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
            AppMethodBeat.o(82167);
            return decodeSampledBitmapFromAssets;
        }
        decodeSampledBitmapFromAssets = BitmapUtils.decodeSampledBitmapFromFile(str2, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
        AppMethodBeat.o(82167);
        return decodeSampledBitmapFromAssets;
    }

    private void updateNumPosition(String str, int i, int i2) {
        Point point;
        AppMethodBeat.i(82168);
        PointF pointF = (PointF) this.mFacePoints.get(this.item.alignFacePoints.length == 1 ? this.item.alignFacePoints[0] : this.item.alignFacePoints[1]);
        PointF pointF2 = new PointF((((PointF) this.mFacePoints.get(this.item.alignFacePoints[0])).x + pointF.x) / 2.0f, (pointF.y + pointF.y) / 2.0f);
        pointF2.x = (float) (((double) pointF2.x) * (1.0d / this.mFaceDetScale));
        pointF2.y = (float) (((double) pointF2.y) * (1.0d / this.mFaceDetScale));
        if (this.mBitSizeMap.containsKey(str)) {
            point = (Point) this.mBitSizeMap.get(str);
        } else {
            point = new Point(this.item.width, this.item.height);
        }
        int i3 = (int) (((((double) point.x) * 1.0d) / ((double) point.y)) * ((double) this.item.height));
        float f = ((float) ((this.item.width - (i2 * i3)) / 2)) + ((pointF2.x - ((float) this.item.anchorPoint[0])) + ((float) (((i2 - i) - 1) * i3)));
        float f2 = (((float) this.height) - pointF2.y) + ((float) this.item.anchorPoint[1]);
        setPositions(AlgoUtils.calPositions(f, f2, ((float) i3) + f, f2 - ((float) this.item.height), this.width, this.height));
        addParam(new b("texAnchor", pointF2.x - ((float) this.canvasCenter.x), ((float) this.canvasCenter.y) - pointF2.y));
        this.mAnchor.x = pointF2.x - ((float) this.canvasCenter.x);
        this.mAnchor.y = ((float) this.canvasCenter.y) - pointF2.y;
        pointF = new PointF(((PointF) this.mFacePoints.get(this.item.scalePivots[0])).x, ((PointF) this.mFacePoints.get(this.item.scalePivots[0])).y);
        pointF.x = (float) (((double) pointF.x) * (1.0d / this.mFaceDetScale));
        pointF.y = (float) (((double) pointF.y) * (1.0d / this.mFaceDetScale));
        PointF pointF3 = new PointF(((PointF) this.mFacePoints.get(this.item.scalePivots[1])).x, ((PointF) this.mFacePoints.get(this.item.scalePivots[1])).y);
        pointF3.x = (float) (((double) pointF3.x) * (1.0d / this.mFaceDetScale));
        pointF3.y = (float) (((double) pointF3.y) * (1.0d / this.mFaceDetScale));
        addParam(new f("texScale", (float) (Math.sqrt(Math.pow((double) (pointF.y - pointF3.y), 2.0d) + Math.pow((double) (pointF.x - pointF3.x), 2.0d)) / ((double) this.item.scaleFactor))));
        if (this.item.support3D == 1) {
            addParam(new d("texRotate", this.mFaceAngles[0], this.mFaceAngles[1], this.mFaceAngles[2] - this.item.angle));
        } else {
            addParam(new d("texRotate", 0.0f, 0.0f, this.mFaceAngles[2] - this.item.angle));
        }
        addParam(new f("positionRotate", -this.mAngle));
        AppMethodBeat.o(82168);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.i(82169);
        if (BaseUtils.isEmpty(this.mFacePoints) || this.mFaceAngles == null || this.mFaceAngles.length < 3 || this.mNum < 0) {
            AppMethodBeat.o(82169);
        } else {
            int totalBit = getTotalBit(this.mNum);
            updateTextureParam(this.item.id, -1, this.mTimestamp, 0);
            if (this.mIsUnitExists) {
                totalBit++;
                updateNumPosition(this.item.id + "_x", 0, totalBit);
                OnDrawFrameGLSL();
                super.renderTexture(i, i2, i3);
                this.mLastBitIndex = 0;
            }
            int i5;
            if (this.mNum < 10) {
                if (this.mIsUnitExists) {
                    i4 = 1;
                }
                updateTextureParam(this.item.id, this.mNum, this.mTimestamp, i4);
                updateNumPosition(this.item.id + "_" + this.mNum, i4, totalBit);
                OnDrawFrameGLSL();
                super.renderTexture(i, i2, i3);
                this.mLastBitIndex = i4;
            } else if (10 > this.mNum || this.mNum >= 100) {
                if (this.mIsUnitExists) {
                    i4 = 1;
                }
                i5 = this.mNum % 10;
                updateTextureParam(this.item.id, i5, this.mTimestamp, i4);
                updateNumPosition(this.item.id + "_" + i5, i4, totalBit);
                OnDrawFrameGLSL();
                super.renderTexture(i, i2, i3);
                this.mLastBitIndex = i4;
                i4++;
                i5 = (this.mNum / 10) % 10;
                updateTextureParam(this.item.id, i5, this.mTimestamp, i4);
                updateNumPosition(this.item.id + "_" + i5, i4, totalBit);
                OnDrawFrameGLSL();
                super.renderTexture(i, i2, i3);
                this.mLastBitIndex = i4;
                i4++;
                i5 = this.mNum / 100;
                updateTextureParam(this.item.id, i5, this.mTimestamp, i4);
                updateNumPosition(this.item.id + "_" + i5, i4, totalBit);
                OnDrawFrameGLSL();
                super.renderTexture(i, i2, i3);
                this.mLastBitIndex = i4;
            } else {
                if (this.mIsUnitExists) {
                    i4 = 1;
                }
                i5 = this.mNum % 10;
                updateTextureParam(this.item.id, i5, this.mTimestamp, i4);
                updateNumPosition(this.item.id + "_" + i5, i4, totalBit);
                OnDrawFrameGLSL();
                super.renderTexture(i, i2, i3);
                this.mLastBitIndex = i4;
                i4++;
                i5 = this.mNum / 10;
                updateTextureParam(this.item.id, i5, this.mTimestamp, i4);
                updateNumPosition(this.item.id + "_" + i5, i4, totalBit);
                OnDrawFrameGLSL();
                super.renderTexture(i, i2, i3);
                this.mLastBitIndex = i4;
            }
            AppMethodBeat.o(82169);
        }
        return true;
    }

    private int getTotalBit(int i) {
        int i2 = 0;
        while (i > 0) {
            i /= 10;
            i2++;
        }
        return i2;
    }

    public void setStickerItem(StickerItem stickerItem) {
        this.item = stickerItem;
    }

    public void destroy() {
        AppMethodBeat.i(82170);
        clearGLSLSelf();
        PlayerUtil.destroyPlayer(this.mPlayer);
        AppMethodBeat.o(82170);
    }

    public void destroyAudio() {
        AppMethodBeat.i(82171);
        PlayerUtil.destroyPlayer(this.mPlayer);
        this.mPlayer = null;
        AppMethodBeat.o(82171);
    }

    public float getFrameDuration(long j) {
        if (this.triggered) {
            return (float) (((double) (j - this.frameStartTime)) / 1000.0d);
        }
        return 0.0f;
    }

    public void setNum(int i) {
        this.mNum = i;
    }

    public boolean isRenderReady() {
        return this.mNum >= 0;
    }
}
