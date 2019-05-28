package com.tencent.ttpic.filter;

import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem;

public class WatermarkDynamicFilter extends DynamicStickerFilter {
    public WatermarkDynamicFilter(StickerItem stickerItem, String str) {
        super(stickerItem, str);
    }

    /* Access modifiers changed, original: protected */
    public void updateTextureParam(int i, long j) {
        AppMethodBeat.i(83185);
        if (this.item.wmGroup != null) {
            this.item.wmGroup.updateTexture(j);
            this.isImageReady = true;
            addParam(new n("inputImageTexture2", this.item.wmGroup.getTexture(), 33986));
            AppMethodBeat.o(83185);
            return;
        }
        this.isImageReady = false;
        clearTextureParam();
        AppMethodBeat.o(83185);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(83186);
        super.ApplyGLSLFilter();
        if (this.item.wmGroup != null) {
            this.item.wmGroup.init();
        }
        AppMethodBeat.o(83186);
    }

    public void clearGLSLSelf() {
        AppMethodBeat.i(83187);
        super.clearGLSLSelf();
        if (this.item.wmGroup != null) {
            this.item.wmGroup.clear();
        }
        AppMethodBeat.o(83187);
    }

    public void reset() {
        AppMethodBeat.i(83188);
        this.item.wmGroup.reset();
        super.reset();
        AppMethodBeat.o(83188);
    }
}
