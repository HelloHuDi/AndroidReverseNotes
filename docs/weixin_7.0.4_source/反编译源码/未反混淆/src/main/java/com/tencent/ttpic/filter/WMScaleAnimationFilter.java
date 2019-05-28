package com.tencent.ttpic.filter;

import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.WMElement;

public class WMScaleAnimationFilter extends WMAnimationFilterBase {
    private static final int ANIMATION_DURATION = 1000;
    private static final int ANIMATION_FRAMES = 16;
    private static final int FRAME_DURATION = 62;
    private static final String TAG = WMScaleAnimationFilter.class.getSimpleName();

    static {
        AppMethodBeat.i(83184);
        AppMethodBeat.o(83184);
    }

    public WMScaleAnimationFilter(WMElement wMElement, int i, int i2) {
        super(wMElement, i, i2, 1000);
    }

    /* Access modifiers changed, original: protected */
    public void initAnimationTimePoints() {
        AppMethodBeat.i(83182);
        this.mAnimationTimePoints.add(new AnimationTimePoint(0, 1.0f));
        this.mAnimationTimePoints.add(new AnimationTimePoint(124, 1.03f));
        this.mAnimationTimePoints.add(new AnimationTimePoint(248, 0.97f));
        this.mAnimationTimePoints.add(new AnimationTimePoint(372, 1.03f));
        this.mAnimationTimePoints.add(new AnimationTimePoint(496, 0.97f));
        this.mAnimationTimePoints.add(new AnimationTimePoint(620, 1.0f));
        this.mAnimationTimePoints.add(new AnimationTimePoint(992, 1.0f));
        AppMethodBeat.o(83182);
    }

    /* Access modifiers changed, original: protected */
    public void setAnimationParams() {
        AppMethodBeat.i(83183);
        addParam(new f("texScale", getAnimationValue()));
        AppMethodBeat.o(83183);
    }
}
