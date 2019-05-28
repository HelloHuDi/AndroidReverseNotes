package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.List;

public class ThinBodyFilter extends VideoFilterBase {
    private static final int BODY_POINTS_NUM = 59;
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ThinBodyFragmentShader.dat");
    public static final String TAG = ThinBodyFilter.class.getSimpleName();
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ThinBodyVertexShader.dat");
    private static final int[] leftIndexs = new int[]{13, 14, 15, 16, 17};
    private static final int[] rightIndexs = new int[]{45, 44, 43, 42, 41};
    private int currentIdx;
    private boolean hasSeenValid;
    private long lastValidTime;
    private boolean mEnable = false;
    private ThinBodyParameters params;
    private PointF[] pointsNormalized = new PointF[59];
    private ThinBodyParameters[] previousParams;
    private boolean[] previousValidFrames;
    private ThinBodyParameters previousValidParams;
    private boolean showMark = false;
    private ThinBodyParameters smoothedParams;
    private int smoothedWithinFrames;
    private float strength;
    private long validDuration;

    class ThinBodyParameters {
        public float middleLine;
        public float strength;
        public float waistWidth;
        public float y0;
        public float y1;
        public float y2;

        public ThinBodyParameters(float f, float f2, float f3, float f4, float f5, float f6) {
            this.waistWidth = f;
            this.middleLine = f2;
            this.strength = f3;
            this.y0 = f4;
            this.y1 = f5;
            this.y2 = f6;
        }

        public void reset() {
            this.y0 = 0.0f;
            this.y1 = 0.0f;
            this.y2 = 0.0f;
            this.middleLine = 0.0f;
            this.waistWidth = 0.0f;
        }

        public ThinBodyParameters copy() {
            AppMethodBeat.i(82974);
            ThinBodyParameters thinBodyParameters = new ThinBodyParameters(this.waistWidth, this.middleLine, this.strength, this.y0, this.y1, this.y2);
            AppMethodBeat.o(82974);
            return thinBodyParameters;
        }
    }

    static {
        AppMethodBeat.i(82987);
        AppMethodBeat.o(82987);
    }

    public ThinBodyFilter() {
        int i;
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.i(82975);
        initParams();
        for (i = 0; i < this.pointsNormalized.length; i++) {
            this.pointsNormalized[i] = new PointF();
        }
        this.smoothedWithinFrames = 2;
        this.currentIdx = 0;
        this.validDuration = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
        this.hasSeenValid = false;
        if (this.previousValidFrames == null) {
            this.previousValidFrames = new boolean[this.smoothedWithinFrames];
            for (i = 0; i < this.smoothedWithinFrames; i++) {
                this.previousValidFrames[i] = false;
            }
        }
        if (this.params == null) {
            this.params = new ThinBodyParameters();
        }
        if (this.previousParams == null) {
            this.previousParams = new ThinBodyParameters[this.smoothedWithinFrames];
            for (i = 0; i < this.smoothedWithinFrames; i++) {
                this.previousParams[i] = new ThinBodyParameters();
            }
        }
        if (this.smoothedParams == null) {
            this.smoothedParams = new ThinBodyParameters();
        }
        this.smoothedParams.reset();
        int i2 = 0;
        for (i = 0; i < this.smoothedWithinFrames; i++) {
            if (this.previousValidFrames[i]) {
                i2++;
                ThinBodyParameters thinBodyParameters = this.previousParams[i];
                ThinBodyParameters thinBodyParameters2 = this.smoothedParams;
                thinBodyParameters2.y0 += thinBodyParameters.y0;
                thinBodyParameters2 = this.smoothedParams;
                thinBodyParameters2.y1 += thinBodyParameters.y1;
                thinBodyParameters2 = this.smoothedParams;
                thinBodyParameters2.y2 += thinBodyParameters.y2;
                thinBodyParameters2 = this.smoothedParams;
                thinBodyParameters2.middleLine += thinBodyParameters.middleLine;
                thinBodyParameters2 = this.smoothedParams;
                thinBodyParameters2.waistWidth = thinBodyParameters.waistWidth + thinBodyParameters2.waistWidth;
            }
        }
        if (i2 > 0) {
            ThinBodyParameters thinBodyParameters3 = this.smoothedParams;
            thinBodyParameters3.y0 /= (float) i2;
            thinBodyParameters3 = this.smoothedParams;
            thinBodyParameters3.y1 /= (float) i2;
            thinBodyParameters3 = this.smoothedParams;
            thinBodyParameters3.y2 /= (float) i2;
            thinBodyParameters3 = this.smoothedParams;
            thinBodyParameters3.middleLine /= (float) i2;
            thinBodyParameters3 = this.smoothedParams;
            thinBodyParameters3.waistWidth /= (float) i2;
        }
        AppMethodBeat.o(82975);
    }

    public void initParams() {
        AppMethodBeat.i(82976);
        addParam(new i("showMark", this.showMark ? 1 : 0));
        addParam(new f("y0", 0.25f));
        addParam(new f("y1", 0.5f));
        addParam(new f("y2", 0.7f));
        addParam(new f("middleLine", 0.0f));
        addParam(new f("waistWidth", 0.0f));
        addParam(new f("strength", 0.0f));
        addParam(new f("factor", 0.16f));
        AppMethodBeat.o(82976);
    }

    public void setWaistWidth(float f) {
        float f2 = 0.0f;
        AppMethodBeat.i(82977);
        ThinBodyParameters thinBodyParameters = this.params;
        if (f >= 0.0f) {
            f2 = f;
        }
        thinBodyParameters.waistWidth = f2;
        ThinBodyParameters thinBodyParameters2 = this.params;
        if (f > 1.0f) {
            f = 1.0f;
        }
        thinBodyParameters2.waistWidth = f;
        addParam(new f("waistWidth", this.params.waistWidth));
        AppMethodBeat.o(82977);
    }

    public void setMiddleLine(float f) {
        float f2 = 0.1f;
        AppMethodBeat.i(82978);
        ThinBodyParameters thinBodyParameters = this.params;
        if (f >= 0.1f) {
            f2 = f;
        }
        thinBodyParameters.middleLine = f2;
        ThinBodyParameters thinBodyParameters2 = this.params;
        if (f > 0.9f) {
            f = 0.9f;
        }
        thinBodyParameters2.middleLine = f;
        addParam(new f("middleLine", this.params.middleLine));
        AppMethodBeat.o(82978);
    }

    public void setStrength(float f) {
        float f2 = 1.0f;
        AppMethodBeat.i(82979);
        if (f <= 1.0f) {
            f2 = f;
        }
        this.strength = f2;
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.strength = f;
        addParam(new f("strength", this.strength));
        AppMethodBeat.o(82979);
    }

    public void setY0(float f) {
        float f2 = 0.0f;
        AppMethodBeat.i(82980);
        ThinBodyParameters thinBodyParameters = this.params;
        if (f >= 0.0f) {
            f2 = f;
        }
        thinBodyParameters.y0 = f2;
        ThinBodyParameters thinBodyParameters2 = this.params;
        if (f > this.params.y1) {
            f = this.params.y1;
        }
        thinBodyParameters2.y0 = f;
        addParam(new f("y0", this.params.y0));
        AppMethodBeat.o(82980);
    }

    public void setY1(float f) {
        float f2;
        AppMethodBeat.i(82981);
        ThinBodyParameters thinBodyParameters = this.params;
        if (f > this.params.y2) {
            f2 = this.params.y2;
        } else {
            f2 = f;
        }
        thinBodyParameters.y1 = f2;
        ThinBodyParameters thinBodyParameters2 = this.params;
        if (f < this.params.y0) {
            f = this.params.y0;
        }
        thinBodyParameters2.y1 = f;
        addParam(new f("y1", this.params.y1));
        AppMethodBeat.o(82981);
    }

    public void setY2(float f) {
        float f2 = 1.0f;
        AppMethodBeat.i(82982);
        ThinBodyParameters thinBodyParameters = this.params;
        if (f <= 1.0f) {
            f2 = f;
        }
        thinBodyParameters.y2 = f2;
        ThinBodyParameters thinBodyParameters2 = this.params;
        if (f < this.params.y1) {
            f = this.params.y1;
        }
        thinBodyParameters2.y2 = f;
        addParam(new f("y2", this.params.y2));
        AppMethodBeat.o(82982);
    }

    public void setShowMark(boolean z) {
        AppMethodBeat.i(82983);
        if (this.showMark != z) {
            this.showMark = z;
            addParam(new i("showMark", z ? 1 : 0));
        }
        AppMethodBeat.o(82983);
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public boolean setupBodyPoints(List<PointF> list, int i, int i2) {
        boolean z = true;
        AppMethodBeat.i(82984);
        if (this.mEnable) {
            this.currentIdx++;
            if (this.currentIdx >= this.smoothedWithinFrames) {
                this.currentIdx = 0;
            }
            if (list != null) {
                this.hasSeenValid = true;
                normalizePoints(list, i, i2);
                calculateMiddleLineWithNormalizedPoints();
                this.previousValidFrames[this.currentIdx] = true;
                this.previousParams[this.currentIdx] = this.params.copy();
                ThinBodyParameters thinBodyParameters = this.smoothedParams;
                this.params = thinBodyParameters;
                this.previousValidParams = thinBodyParameters;
                this.lastValidTime = System.currentTimeMillis();
            } else {
                this.previousValidFrames[this.currentIdx] = false;
                if (this.hasSeenValid && System.currentTimeMillis() - this.lastValidTime < this.validDuration) {
                    this.params = this.previousValidParams;
                }
            }
            this.mEnable = z;
            z = this.mEnable;
            AppMethodBeat.o(82984);
            return z;
        }
        z = false;
        this.mEnable = z;
        z = this.mEnable;
        AppMethodBeat.o(82984);
        return z;
    }

    private void calculateMiddleLineWithNormalizedPoints() {
        AppMethodBeat.i(82985);
        int length = leftIndexs.length;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i = 0; i < length; i++) {
            PointF pointF = this.pointsNormalized[leftIndexs[i]];
            PointF pointF2 = this.pointsNormalized[rightIndexs[i]];
            f3 += (pointF.x + pointF2.x) / 2.0f;
            f2 += (pointF.y + pointF2.y) / 2.0f;
            f += pointF2.x - pointF.x;
        }
        float f4 = (this.pointsNormalized[0].y + this.pointsNormalized[58].y) / 2.0f;
        f2 /= (float) length;
        f /= (float) length;
        setMiddleLine(f3 / ((float) length));
        setY0(f4);
        setY1(f2 - (0.0f * f));
        setY2((0.4f * f) + f2);
        setWaistWidth(f);
        AppMethodBeat.o(82985);
    }

    private void normalizePoints(List<PointF> list, int i, int i2) {
        AppMethodBeat.i(82986);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(82986);
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < list.size()) {
                this.pointsNormalized[i4].x = ((PointF) list.get(i4)).x / ((float) i);
                this.pointsNormalized[i4].y = ((PointF) list.get(i4)).y / ((float) i2);
                i3 = i4 + 1;
            } else {
                AppMethodBeat.o(82986);
                return;
            }
        }
    }
}
