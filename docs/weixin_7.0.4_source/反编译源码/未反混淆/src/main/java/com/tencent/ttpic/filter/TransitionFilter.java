package com.tencent.ttpic.filter;

import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TransitionFilter implements ITransitionFilter {
    private TransitionAlphaFilter mAlphaFilter = new TransitionAlphaFilter();
    private TransitionBlendFilter mBlendFilter = new TransitionBlendFilter();
    private ITransitionFilter mCurrFilter;
    private TransitionMoveFilter mMoveFilter = new TransitionMoveFilter();

    public TransitionFilter() {
        AppMethodBeat.i(83055);
        AppMethodBeat.o(83055);
    }

    public void setMvPart(FabbyMvPart fabbyMvPart) {
        AppMethodBeat.i(83056);
        switch (fabbyMvPart.transitionFunction) {
            case 0:
                if (fabbyMvPart.transitionItem == null || fabbyMvPart.transitionItem.id.isEmpty()) {
                    this.mCurrFilter = null;
                    AppMethodBeat.o(83056);
                    return;
                }
                this.mBlendFilter.setItem(fabbyMvPart.transitionItem);
                this.mBlendFilter.setDuration(fabbyMvPart.transitionDuration);
                this.mBlendFilter.setEaseCurve(fabbyMvPart.transitionEase);
                this.mBlendFilter.setMaskType(fabbyMvPart.transitionMaskType);
                this.mCurrFilter = this.mBlendFilter;
                AppMethodBeat.o(83056);
                return;
            case 1:
            case 2:
            case 3:
            case 4:
                this.mMoveFilter.setDuration(fabbyMvPart.transitionDuration);
                this.mMoveFilter.setEaseCurve(fabbyMvPart.transitionEase);
                this.mMoveFilter.setMoveOrientation(fabbyMvPart.transitionFunction);
                this.mCurrFilter = this.mMoveFilter;
                AppMethodBeat.o(83056);
                return;
            case 5:
                this.mAlphaFilter.setDuration(fabbyMvPart.transitionDuration);
                this.mAlphaFilter.setEaseCurve(fabbyMvPart.transitionEase);
                this.mCurrFilter = this.mAlphaFilter;
                AppMethodBeat.o(83056);
                return;
            default:
                this.mCurrFilter = null;
                AppMethodBeat.o(83056);
                return;
        }
    }

    public void setDataPath(String str) {
        AppMethodBeat.i(83057);
        this.mBlendFilter.setDataPath(str);
        this.mMoveFilter.setDataPath(str);
        this.mAlphaFilter.setDataPath(str);
        AppMethodBeat.o(83057);
    }

    public void setLastTex(int i) {
        AppMethodBeat.i(83058);
        if (this.mCurrFilter != null) {
            this.mCurrFilter.setLastTex(i);
        }
        AppMethodBeat.o(83058);
    }

    public void updatePreview(long j) {
        AppMethodBeat.i(83059);
        if (this.mCurrFilter != null) {
            this.mCurrFilter.updatePreview(j);
        }
        AppMethodBeat.o(83059);
    }

    public void ApplyGLSLFilter(String str) {
        AppMethodBeat.i(83060);
        this.mBlendFilter.ApplyGLSLFilter();
        this.mAlphaFilter.ApplyGLSLFilter();
        this.mMoveFilter.ApplyGLSLFilter();
        setDataPath(str);
        AppMethodBeat.o(83060);
    }

    public void RenderProcess(int i, int i2, int i3, int i4, double d, h hVar) {
        AppMethodBeat.i(83061);
        if (this.mCurrFilter != null) {
            this.mCurrFilter.RenderProcess(i, i2, i3, i4, d, hVar);
        }
        AppMethodBeat.o(83061);
    }

    public void reset() {
        AppMethodBeat.i(83062);
        this.mBlendFilter.reset();
        this.mAlphaFilter.reset();
        this.mMoveFilter.reset();
        AppMethodBeat.o(83062);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(83063);
        this.mBlendFilter.setRenderMode(i);
        this.mAlphaFilter.setRenderMode(i);
        this.mMoveFilter.setRenderMode(i);
        AppMethodBeat.o(83063);
    }

    public void ClearGLSL() {
        AppMethodBeat.i(83064);
        this.mBlendFilter.ClearGLSL();
        this.mAlphaFilter.ClearGLSL();
        this.mMoveFilter.ClearGLSL();
        AppMethodBeat.o(83064);
    }

    public boolean needRender() {
        return this.mCurrFilter != null;
    }
}
