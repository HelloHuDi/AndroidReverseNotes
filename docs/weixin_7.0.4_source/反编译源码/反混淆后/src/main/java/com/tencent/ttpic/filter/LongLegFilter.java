package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.List;

public class LongLegFilter extends VideoFilterBase {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/LongLegFragmentFilter.dat");
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/LongLegVertexFilter.dat");
    private int currentFrame;
    private boolean hasSeenValidPoints = false;
    private boolean legLineStable = false;
    private float lineMax = 1.0f;
    private float lineMin = 1.0f;
    private long previousLostWaistTime = System.currentTimeMillis();
    private long previousTimeForChangeToStable = System.currentTimeMillis();
    private long previousTimeForChangeToUnstable = System.currentTimeMillis();
    private float previousValidWaistLine;
    private float[] previousWaistLines;
    private float rangeMax = 0.1f;
    private long timesForChangeToStable = 3000;
    private long timesForChangeToUnstable = 3000;
    private long usePreviousIfWithin = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
    private final int waistLineFrames = 8;

    static {
        AppMethodBeat.m2504i(82657);
        AppMethodBeat.m2505o(82657);
    }

    public LongLegFilter() {
        int i = 0;
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82650);
        initParams();
        this.previousWaistLines = new float[8];
        while (i < 8) {
            this.previousWaistLines[i] = 1.0f;
            i++;
        }
        AppMethodBeat.m2505o(82650);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82651);
        addParam(new C0933f("y0", 0.5f));
        addParam(new C0933f("strecthRatio", 0.0f));
        addParam(new C0935i("showMark", 0));
        addParam(new C0935i("useful", 1));
        AppMethodBeat.m2505o(82651);
    }

    public void setStrength(float f) {
        AppMethodBeat.m2504i(82652);
        addParam(new C0933f("strecthRatio", 0.2f * f));
        AppMethodBeat.m2505o(82652);
    }

    public void setWaistLine(List<PointF> list, int i) {
        float f;
        AppMethodBeat.m2504i(82653);
        if (list == null || list.isEmpty()) {
            f = -1.0f;
        } else {
            f = ((((PointF) list.get(43)).y + ((PointF) list.get(15)).y) / 2.0f) / ((float) i);
        }
        setWaistLine(f);
        AppMethodBeat.m2505o(82653);
    }

    public void setWaistLine(float f) {
        AppMethodBeat.m2504i(82654);
        setWaistLine(f, true);
        AppMethodBeat.m2505o(82654);
    }

    public void setWaistLine(float f, boolean z) {
        float legLineToset;
        float f2 = 1.0f;
        AppMethodBeat.m2504i(82655);
        long currentTimeMillis = System.currentTimeMillis();
        if (f >= 0.0f) {
            this.previousValidWaistLine = f;
            this.previousLostWaistTime = currentTimeMillis;
            if (!this.hasSeenValidPoints) {
                this.hasSeenValidPoints = true;
                this.previousTimeForChangeToStable = System.currentTimeMillis();
            }
        } else if (this.legLineStable || currentTimeMillis - this.previousLostWaistTime >= this.usePreviousIfWithin) {
            f = 1.0f;
        } else {
            f = this.previousValidWaistLine;
            this.previousTimeForChangeToStable = System.currentTimeMillis();
        }
        this.previousWaistLines[getCurrentFrame()] = f;
        this.currentFrame++;
        if (z) {
            legLineToset = legLineToset(getCurrentSmoothedWaistLine());
        } else {
            legLineToset = f;
        }
        if (legLineToset <= 1.0f) {
            f2 = legLineToset;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        addParam(new C0933f("y0", f2));
        AppMethodBeat.m2505o(82655);
    }

    private float legLineToset(float f) {
        int i = 0;
        AppMethodBeat.m2504i(82656);
        if (this.hasSeenValidPoints) {
            long currentTimeMillis = System.currentTimeMillis();
            float f2;
            if (this.legLineStable) {
                f2 = (this.lineMin + this.lineMax) / 2.0f;
                if (Math.abs(f2 - f) < this.rangeMax) {
                    this.previousTimeForChangeToUnstable = currentTimeMillis;
                } else if (currentTimeMillis - this.previousTimeForChangeToUnstable >= this.timesForChangeToUnstable) {
                    this.legLineStable = false;
                    this.previousTimeForChangeToStable = currentTimeMillis;
                    this.lineMax = f;
                    this.lineMin = f;
                    while (i < 8) {
                        this.previousWaistLines[i] = f2;
                        i++;
                    }
                }
                f = f2;
            } else {
                this.lineMin = this.lineMin < f ? this.lineMin : f;
                if (this.lineMax > f) {
                    f2 = this.lineMax;
                } else {
                    f2 = f;
                }
                this.lineMax = f2;
                if (this.lineMax - this.lineMin > this.rangeMax) {
                    this.lineMax = f;
                    this.lineMin = f;
                    this.previousTimeForChangeToStable = currentTimeMillis;
                } else if (currentTimeMillis - this.previousTimeForChangeToStable >= this.timesForChangeToStable) {
                    this.legLineStable = true;
                    this.lineMin = f - (this.rangeMax / 2.0f);
                    this.lineMax = (this.rangeMax / 2.0f) + f;
                    this.previousTimeForChangeToUnstable = currentTimeMillis;
                }
            }
            AppMethodBeat.m2505o(82656);
            return f;
        }
        AppMethodBeat.m2505o(82656);
        return 1.0f;
    }

    private int getCurrentFrame() {
        if (this.currentFrame >= 8) {
            this.currentFrame = 0;
        }
        return this.currentFrame;
    }

    private float getCurrentSmoothedWaistLine() {
        float f = 0.0f;
        for (int i = 0; i < 8; i++) {
            f += this.previousWaistLines[i];
        }
        return f / 8.0f;
    }
}
