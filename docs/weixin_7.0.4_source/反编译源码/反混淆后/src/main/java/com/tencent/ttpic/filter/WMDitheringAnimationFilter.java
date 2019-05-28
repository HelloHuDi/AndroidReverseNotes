package com.tencent.ttpic.filter;

import com.tencent.filter.C25624m.C25630d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.WMElement;

public class WMDitheringAnimationFilter extends WMAnimationFilterBase {
    private static final int ANIMATION_DURATION = 1000;
    private static final int ANIMATION_FRAMES = 16;
    private static final int FRAME_DURATION = 62;
    private static final String TAG = WMDitheringAnimationFilter.class.getSimpleName();

    static {
        AppMethodBeat.m2504i(83181);
        AppMethodBeat.m2505o(83181);
    }

    public WMDitheringAnimationFilter(WMElement wMElement, int i, int i2) {
        super(wMElement, i, i2, 1000);
    }

    /* Access modifiers changed, original: protected */
    public void initAnimationTimePoints() {
        AppMethodBeat.m2504i(83179);
        this.mAnimationTimePoints.add(new AnimationTimePoint(0, 0.0f));
        this.mAnimationTimePoints.add(new AnimationTimePoint(124, (float) Math.toRadians(6.0d)));
        this.mAnimationTimePoints.add(new AnimationTimePoint(248, (float) Math.toRadians(-6.0d)));
        this.mAnimationTimePoints.add(new AnimationTimePoint(372, (float) Math.toRadians(6.0d)));
        this.mAnimationTimePoints.add(new AnimationTimePoint(496, (float) Math.toRadians(-6.0d)));
        this.mAnimationTimePoints.add(new AnimationTimePoint(620, (float) Math.toRadians(0.0d)));
        this.mAnimationTimePoints.add(new AnimationTimePoint(992, (float) Math.toRadians(0.0d)));
        AppMethodBeat.m2505o(83179);
    }

    /* Access modifiers changed, original: protected */
    public void setAnimationParams() {
        AppMethodBeat.m2504i(83180);
        addParam(new C25630d("texRotate", 0.0f, 0.0f, getAnimationValue()));
        AppMethodBeat.m2505o(83180);
    }
}
