package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CaptureActItem extends FrameSourceItem {
    private static final String TAG = CaptureActItem.class.getSimpleName();
    private int[] captureTimes;
    private BaseFilter copyFilter = new BaseFilter(GLSLRender.bJB);
    private C41672h[] copyFrames;
    private String dataPath;
    private List<ExpressionItem> expressionList;
    private String imageId;
    private int lastCaptureIndex = -1;
    private int[] numTextures = new int[10];
    private final Random random;
    private ScoreTag[] scores;
    private List<float[]> starFaceAngles;
    private List<List<PointF>> starFacePoints;

    static class ScoreTag {
        public boolean hasShowed;
        public int score;
        public int[] texId;

        private ScoreTag() {
        }
    }

    static {
        AppMethodBeat.m2504i(83477);
        AppMethodBeat.m2505o(83477);
    }

    public CaptureActItem(List<ExpressionItem> list, String str, String str2, BaseFilter baseFilter) {
        int i = 0;
        super(baseFilter);
        AppMethodBeat.m2504i(83473);
        this.expressionList = list;
        this.dataPath = str;
        this.imageId = str2;
        this.starFacePoints = new ArrayList(list.size());
        this.starFaceAngles = new ArrayList(list.size());
        this.captureTimes = new int[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            ExpressionItem expressionItem = (ExpressionItem) list.get(i2);
            this.starFacePoints.add(expressionItem.expressionFeat);
            this.starFaceAngles.add(expressionItem.expressionAngle);
            this.captureTimes[i2] = expressionItem.expressionTime;
        }
        this.scores = new ScoreTag[list.size()];
        for (int i3 = 0; i3 < this.scores.length; i3++) {
            this.scores[i3] = new ScoreTag();
        }
        this.copyFrames = new C41672h[list.size()];
        while (i < this.copyFrames.length) {
            this.copyFrames[i] = new C41672h();
            i++;
        }
        this.random = new Random(System.currentTimeMillis());
        AppMethodBeat.m2505o(83473);
    }

    public void init() {
        int i;
        AppMethodBeat.m2504i(83474);
        this.copyFilter.ApplyGLSLFilter();
        GLES20.glGenTextures(this.numTextures.length, this.numTextures, 0);
        for (i = 0; i < 10; i++) {
            Bitmap decodeSampleBitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), this.dataPath + File.separator + ActUtil.EXPRESSION + File.separator + this.imageId + File.separator + this.imageId + "_" + i + ".png", 720, ActUtil.HEIGHT);
            if (BitmapUtils.isLegal(decodeSampleBitmap)) {
                GlUtil.loadTexture(this.numTextures[i], decodeSampleBitmap);
                decodeSampleBitmap.recycle();
            }
        }
        for (int i2 = 0; i2 < this.expressionList.size(); i2++) {
            String str = ((ExpressionItem) this.expressionList.get(i2)).scoreImageID;
            if (!TextUtils.isEmpty(str)) {
                int[] iArr = new int[10];
                GLES20.glGenTextures(10, iArr, 0);
                for (i = 0; i < 10; i++) {
                    Bitmap decodeSampleBitmap2 = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), this.dataPath + File.separator + ActUtil.EXPRESSION + File.separator + str + File.separator + str + "_" + i + ".png", 720, ActUtil.HEIGHT);
                    if (BitmapUtils.isLegal(decodeSampleBitmap2)) {
                        GlUtil.loadTexture(iArr[i], decodeSampleBitmap2);
                        decodeSampleBitmap2.recycle();
                    }
                }
                this.scores[i2].texId = iArr;
            }
        }
        AppMethodBeat.m2505o(83474);
    }

    public int getTexture(CanvasItem canvasItem, long j) {
        return this.copyFrames[canvasItem.index].texture[0];
    }

    public void clear() {
        AppMethodBeat.m2504i(83475);
        this.copyFilter.ClearGLSL();
        for (C41672h c41672h : this.copyFrames) {
            if (c41672h != null) {
                c41672h.clear();
            }
        }
        for (ScoreTag scoreTag : this.scores) {
            if (scoreTag.texId != null) {
                GLES20.glDeleteTextures(scoreTag.texId.length, scoreTag.texId, 0);
                scoreTag.texId = null;
            }
        }
        AppMethodBeat.m2505o(83475);
    }

    public void reset() {
        this.lastCaptureIndex = -1;
        for (int i = 0; i < this.scores.length; i++) {
            this.scores[i].score = 0;
            this.scores[i].hasShowed = false;
        }
    }

    public int getOrigWidth(int i) {
        if (i < 0 || i >= this.copyFrames.length) {
            return -1;
        }
        return this.copyFrames[i].width;
    }

    public int getOrigHeight(int i) {
        if (i < 0 || i >= this.copyFrames.length) {
            return -1;
        }
        return this.copyFrames[i].height;
    }

    public void update(C41672h c41672h, long j, List<List<PointF>> list, List<float[]> list2, int i) {
        AppMethodBeat.m2504i(83476);
        super.update(c41672h, j, list, list2, i);
        int captureIndex = getCaptureIndex(j);
        if (captureIndex >= 0) {
            BenchUtil.benchStart(TAG + "[update]");
            this.copyFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.copyFrames[captureIndex]);
            BenchUtil.benchEnd(TAG + "[update]");
            if (list.size() <= 0 || i != 0) {
                this.scores[captureIndex].score = this.random.nextInt(5) + 5;
            } else {
                BenchUtil.benchStart(TAG + "[calculate score]");
                this.scores[captureIndex].score = (int) ActUtil.getExpressionSimilarity((List) this.starFacePoints.get(captureIndex), (List) list.get(0), (float[]) this.starFaceAngles.get(captureIndex), (float[]) list2.get(0), ((ExpressionItem) this.expressionList.get(captureIndex)).expressionWeight);
                BenchUtil.benchEnd(TAG + "[calculate score]");
                AppMethodBeat.m2505o(83476);
                return;
            }
        }
        AppMethodBeat.m2505o(83476);
    }

    private int getCaptureIndex(long j) {
        if (this.lastCaptureIndex + 1 >= this.captureTimes.length || j < ((long) this.captureTimes[this.lastCaptureIndex + 1])) {
            return -1;
        }
        this.lastCaptureIndex++;
        return this.lastCaptureIndex;
    }

    public int getScore(CanvasItem canvasItem) {
        this.scores[canvasItem.index].hasShowed = true;
        return this.scores[canvasItem.index].score;
    }

    public int[] getScoreTexture(CanvasItem canvasItem) {
        if (this.scores[canvasItem.index].texId != null) {
            return this.scores[canvasItem.index].texId;
        }
        return this.numTextures;
    }

    public int getTotalScore() {
        int i = 0;
        for (ScoreTag scoreTag : this.scores) {
            if (scoreTag.hasShowed) {
                i += scoreTag.score;
            }
        }
        return i;
    }

    public int[] getTotalScoreTexture() {
        return this.numTextures;
    }
}
