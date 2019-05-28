package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C25629b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.List;

public class ThinShoulderFilter extends VideoFilterBase {
    private static final int BODY_POINTS_NUM = 59;
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ThinShoulderFragmentShader.dat");
    public static final String TAG = ThinShoulderFilter.class.getSimpleName();
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ThinShoulderVertexShader.dat");
    private static final int[] leftIndexs = new int[]{13, 14, 15, 16, 17};
    private static final int[] rightIndexs = new int[]{45, 44, 43, 42, 41};
    private PointF center;
    private int currentIdx;
    private boolean hasSeenValid;
    private float height;
    private long lastValidTime;
    private boolean mEnable = false;
    private ThinShoulderParameters params;
    private PointF[] pointsNormalized = new PointF[59];
    private ThinShoulderParameters[] previousParams;
    private boolean[] previousValidFrames;
    private ThinShoulderParameters previousValidParams;
    private float prop;
    private boolean showMark = false;
    private ThinShoulderParameters smoothedParams;
    private int smoothedWithinFrames;
    private float strength;
    private long validDuration;
    private float width;

    class ThinShoulderParameters {
        private RectF rect;

        public ThinShoulderParameters() {
            AppMethodBeat.m2504i(82988);
            this.rect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
            AppMethodBeat.m2505o(82988);
        }

        public ThinShoulderParameters(RectF rectF) {
            this.rect = rectF;
        }

        public void reset() {
            AppMethodBeat.m2504i(82989);
            this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
            AppMethodBeat.m2505o(82989);
        }

        public ThinShoulderParameters copy() {
            AppMethodBeat.m2504i(82990);
            ThinShoulderParameters thinShoulderParameters = new ThinShoulderParameters(new RectF(this.rect));
            AppMethodBeat.m2505o(82990);
            return thinShoulderParameters;
        }
    }

    static {
        AppMethodBeat.m2504i(83003);
        AppMethodBeat.m2505o(83003);
    }

    public ThinShoulderFilter() {
        int i;
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82991);
        initParams();
        this.smoothedWithinFrames = 2;
        this.currentIdx = 0;
        this.validDuration = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
        this.hasSeenValid = false;
        for (i = 0; i < this.pointsNormalized.length; i++) {
            this.pointsNormalized[i] = new PointF();
        }
        if (this.previousValidFrames == null) {
            this.previousValidFrames = new boolean[this.smoothedWithinFrames];
            for (i = 0; i < this.smoothedWithinFrames; i++) {
                this.previousValidFrames[i] = false;
            }
        }
        if (this.params == null) {
            this.params = new ThinShoulderParameters();
        }
        if (this.previousParams == null) {
            this.previousParams = new ThinShoulderParameters[this.smoothedWithinFrames];
            for (i = 0; i < this.smoothedWithinFrames; i++) {
                this.previousParams[i] = new ThinShoulderParameters();
            }
        }
        if (this.previousValidParams == null) {
            this.previousValidParams = new ThinShoulderParameters();
        }
        if (this.smoothedParams == null) {
            this.smoothedParams = new ThinShoulderParameters();
        }
        this.smoothedParams.reset();
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        for (i = 0; i < this.smoothedWithinFrames; i++) {
            if (this.previousValidFrames[i]) {
                i2++;
                ThinShoulderParameters thinShoulderParameters = this.previousParams[i];
                f3 += thinShoulderParameters.rect.left;
                f2 += thinShoulderParameters.rect.top;
                f = (f + thinShoulderParameters.rect.right) + thinShoulderParameters.rect.bottom;
            }
        }
        if (i2 > 0) {
            this.smoothedParams.rect = new RectF(f3 / ((float) i2), f2 / ((float) i2), f / ((float) i2), 0.0f / ((float) i2));
        }
        AppMethodBeat.m2505o(82991);
    }

    public void resetState() {
        this.hasSeenValid = false;
        this.previousParams = null;
    }

    public void setStrength(float f) {
        float f2 = 1.0f;
        AppMethodBeat.m2504i(82992);
        if (f <= 1.0f) {
            f2 = f;
        }
        this.strength = f2;
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.strength = f;
        addParam(new C0933f("strength", this.strength));
        AppMethodBeat.m2505o(82992);
    }

    public void setShowMark(boolean z) {
        AppMethodBeat.m2504i(82993);
        if (this.showMark != z) {
            this.showMark = z;
            addParam(new C0935i("showMark", this.showMark ? 1 : 0));
        }
        AppMethodBeat.m2505o(82993);
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void setParams(ThinShoulderParameters thinShoulderParameters) {
        AppMethodBeat.m2504i(82994);
        setCenter(new PointF(thinShoulderParameters.rect.left, thinShoulderParameters.rect.top));
        setWidth(thinShoulderParameters.rect.right);
        setHeight(thinShoulderParameters.rect.bottom);
        AppMethodBeat.m2505o(82994);
    }

    public void setCenter(PointF pointF) {
        float f = 1.0f;
        float f2 = 0.0f;
        AppMethodBeat.m2504i(82995);
        this.center.x = pointF.x > 1.0f ? 1.0f : pointF.x;
        this.center.x = pointF.x < 0.0f ? 0.0f : pointF.x;
        PointF pointF2 = this.center;
        if (pointF.y <= 1.0f) {
            f = pointF.y;
        }
        pointF2.y = f;
        pointF2 = this.center;
        if (pointF.y >= 0.0f) {
            f2 = pointF.y;
        }
        pointF2.y = f2;
        addParam(new C25629b("center", this.center.x, this.center.y));
        AppMethodBeat.m2505o(82995);
    }

    public void setWidth(float f) {
        float f2 = 1.0f;
        AppMethodBeat.m2504i(82996);
        if (f <= 1.0f) {
            f2 = f;
        }
        this.width = f2;
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.width = f;
        addParam(new C0933f("width", this.width));
        AppMethodBeat.m2505o(82996);
    }

    public void setHeight(float f) {
        float f2 = 1.0f;
        AppMethodBeat.m2504i(82997);
        if (f <= 1.0f) {
            f2 = f;
        }
        this.height = f2;
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.height = f;
        addParam(new C0933f("height", this.height));
        AppMethodBeat.m2505o(82997);
    }

    public void setProp(float f) {
        float f2 = 2.0f;
        AppMethodBeat.m2504i(82998);
        if (f <= 2.0f) {
            f2 = f;
        }
        this.prop = f2;
        if (f < 0.5f) {
            f = 0.5f;
        }
        this.prop = f;
        addParam(new C0933f("prop", this.prop));
        AppMethodBeat.m2505o(82998);
    }

    public void initParams() {
        int i = 0;
        AppMethodBeat.m2504i(82999);
        this.center = new PointF();
        this.showMark = false;
        this.mEnable = false;
        this.prop = 0.5625f;
        String str = "showMark";
        if (this.showMark) {
            i = 1;
        }
        addParam(new C0935i(str, i));
        addParam(new C0933f("strength", 0.0f));
        addParam(new C25629b("center", 0.0f, 0.0f));
        addParam(new C0933f("width", 0.0f));
        addParam(new C0933f("height", 0.0f));
        addParam(new C0933f("prop", 0.5625f));
        AppMethodBeat.m2505o(82999);
    }

    public boolean setupBodyPoints(List<PointF> list, int i, int i2) {
        boolean z = true;
        AppMethodBeat.m2504i(83000);
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
                ThinShoulderParameters thinShoulderParameters = this.smoothedParams;
                this.params = thinShoulderParameters;
                this.previousValidParams = thinShoulderParameters;
                this.lastValidTime = System.currentTimeMillis();
            } else {
                this.previousValidFrames[this.currentIdx] = false;
                if (this.hasSeenValid && System.currentTimeMillis() - this.lastValidTime < this.validDuration) {
                    this.params = this.previousValidParams;
                }
            }
            this.mEnable = z;
            z = this.mEnable;
            AppMethodBeat.m2505o(83000);
            return z;
        }
        z = false;
        this.mEnable = z;
        z = this.mEnable;
        AppMethodBeat.m2505o(83000);
        return z;
    }

    public void calculateMiddleLineWithNormalizedPoints() {
        int i = 0;
        AppMethodBeat.m2504i(83001);
        int length = leftIndexs.length;
        PointF pointF = this.pointsNormalized[0];
        PointF pointF2 = this.pointsNormalized[58];
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i < length) {
            PointF pointF3 = this.pointsNormalized[leftIndexs[i]];
            PointF pointF4 = this.pointsNormalized[rightIndexs[i]];
            f4 += (pointF3.x + pointF4.x) / 2.0f;
            f3 += (pointF3.y + pointF4.y) / 2.0f;
            f += ((pointF3.y + pointF4.y) - pointF.y) - pointF2.y;
            i++;
            f2 = (pointF4.x - pointF3.x) + f2;
        }
        setParams(new ThinShoulderParameters(new RectF(f4 / ((float) length), (f3 / ((float) length)) - (0.05f * f), (f2 / ((float) length)) * 2.0f, f * 0.18f)));
        AppMethodBeat.m2505o(83001);
    }

    private void normalizePoints(List<PointF> list, int i, int i2) {
        AppMethodBeat.m2504i(83002);
        if (list == null || list.size() == 0) {
            AppMethodBeat.m2505o(83002);
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
                AppMethodBeat.m2505o(83002);
                return;
            }
        }
    }
}
