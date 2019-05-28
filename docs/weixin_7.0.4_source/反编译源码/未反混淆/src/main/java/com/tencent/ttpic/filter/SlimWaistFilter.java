package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.List;

public class SlimWaistFilter extends VideoFilterBase {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SlimWaistFragmentFilter.dat");
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SlimWaistVertexFilter.dat");
    private static int[] leftIndex = new int[]{13, 14, 15, 16, 17};
    private static int[] rightIndex = new int[]{41, 42, 43, 44, 45};
    private final float T0 = 0.6f;
    private int currentIdx = 0;
    private RectF mCurrentRect;
    private boolean mHasSeenValid = false;
    private long mPreviousLostTime = System.currentTimeMillis();
    private RectF mPreviousValidRect;
    private long mTimesForLostProtect = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
    private final float maxX0 = 0.68f;
    private RectF[] previousRects = new RectF[]{new RectF(0.0f, 0.0f, 0.0f, 0.0f), new RectF(0.0f, 0.0f, 0.0f, 0.0f), new RectF(0.0f, 0.0f, 0.0f, 0.0f), new RectF(0.0f, 0.0f, 0.0f, 0.0f)};
    private boolean[] previousValid = new boolean[]{false, false, false, false};
    private int smoothedWithinFrames = 2;

    static {
        AppMethodBeat.i(82869);
        AppMethodBeat.o(82869);
    }

    public SlimWaistFilter() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.i(82862);
        initParams();
        this.mCurrentRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.mPreviousValidRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        AppMethodBeat.o(82862);
    }

    public void initParams() {
        AppMethodBeat.i(82863);
        addParam(new f("t0", 0.6f));
        addParam(new f("maxPoint", 0.68f));
        addParam(new i("showMark", 0));
        addParam(new f("top", 0.32f));
        addParam(new f("bottom", 0.61f));
        addParam(new f("left", 0.38f));
        addParam(new f("right", 0.76f));
        AppMethodBeat.o(82863);
    }

    public void setStrength(float f) {
        AppMethodBeat.i(82864);
        addParam(new f("maxPoint", (0.6f * (1.0f - f)) + (0.68f * f)));
        AppMethodBeat.o(82864);
    }

    public void setStatusReset() {
        AppMethodBeat.i(82865);
        this.mHasSeenValid = false;
        this.mPreviousValidRect = null;
        this.currentIdx = 0;
        for (int i = 0; i < this.smoothedWithinFrames; i++) {
            this.previousValid[i] = false;
            this.previousRects[i].set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        AppMethodBeat.o(82865);
    }

    public boolean setWaistRectangle(List<PointF> list, int i, int i2) {
        boolean z = true;
        AppMethodBeat.i(82866);
        this.currentIdx = (this.currentIdx + 1) % this.smoothedWithinFrames;
        if (list == null || list.isEmpty()) {
            this.previousValid[this.currentIdx] = false;
            if (!this.mHasSeenValid || System.currentTimeMillis() - this.mPreviousLostTime >= this.mTimesForLostProtect) {
                z = false;
            } else {
                this.mCurrentRect = this.mPreviousValidRect;
            }
        } else {
            this.mHasSeenValid = true;
            RectF calculateRectPoints = calculateRectPoints(list, i, i2);
            this.previousValid[this.currentIdx] = true;
            this.previousRects[this.currentIdx] = calculateRectPoints;
            this.mCurrentRect = getSmoothedRect();
            this.mPreviousValidRect = getSmoothedRect();
            this.mPreviousLostTime = System.currentTimeMillis();
        }
        if (z) {
            addParam(new f("top", this.mCurrentRect.top));
            addParam(new f("bottom", this.mCurrentRect.bottom));
            addParam(new f("left", this.mCurrentRect.left));
            addParam(new f("right", this.mCurrentRect.right));
        }
        AppMethodBeat.o(82866);
        return z;
    }

    private RectF calculateRectPoints(List<PointF> list, int i, int i2) {
        float f = 0.0f;
        AppMethodBeat.i(82867);
        int length = leftIndex.length;
        PointF pointF = new PointF(0.0f, 0.0f);
        for (int i3 = 0; i3 < length; i3++) {
            pointF.x = ((((PointF) list.get(leftIndex[i3])).x + ((PointF) list.get(rightIndex[i3])).x) / 2.0f) + pointF.x;
            pointF.y = ((((PointF) list.get(leftIndex[i3])).y + ((PointF) list.get(rightIndex[i3])).y) / 2.0f) + pointF.y;
            f += ((PointF) list.get(rightIndex[i3])).x - ((PointF) list.get(leftIndex[i3])).x;
        }
        pointF.x /= (float) length;
        pointF.y /= (float) length;
        float f2 = (float) (((double) (f / ((float) length))) * 1.9d);
        float f3 = (float) (((double) f2) * 0.7d);
        RectF rectF = new RectF((pointF.x - (f2 / 2.0f)) / ((float) i), (pointF.y - (f3 / 2.0f)) / ((float) i2), ((f2 / 2.0f) + pointF.x) / ((float) i), ((f3 / 2.0f) + pointF.y) / ((float) i2));
        AppMethodBeat.o(82867);
        return rectF;
    }

    private RectF getSmoothedRect() {
        int i = 0;
        AppMethodBeat.i(82868);
        RectF rectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.smoothedWithinFrames) {
                if (this.previousValid[i2]) {
                    i = i3 + 1;
                    RectF rectF2 = this.previousRects[i2];
                    rectF.set(rectF2.left + rectF.left, rectF2.top + rectF.top, rectF2.right + rectF.right, rectF2.bottom + rectF.bottom);
                } else {
                    i = i3;
                }
                i2++;
            } else {
                rectF.set(rectF.left / ((float) i3), rectF.top / ((float) i3), rectF.right / ((float) i3), rectF.bottom / ((float) i3));
                AppMethodBeat.o(82868);
                return rectF;
            }
        }
    }
}
