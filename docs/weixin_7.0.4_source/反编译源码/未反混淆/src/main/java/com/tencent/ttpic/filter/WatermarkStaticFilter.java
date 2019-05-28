package com.tencent.ttpic.filter;

import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem;

public class WatermarkStaticFilter extends StaticStickerFilter {
    public WatermarkStaticFilter(StickerItem stickerItem, String str) {
        super(stickerItem, str);
    }

    /* Access modifiers changed, original: protected */
    public void updateTextureParam(int i, long j) {
        AppMethodBeat.i(83189);
        if (this.item.wmGroup != null) {
            this.item.wmGroup.updateTexture(j);
            addParam(new n("inputImageTexture2", this.item.wmGroup.getTexture(), 33986));
            this.isImageReady = true;
            AppMethodBeat.o(83189);
            return;
        }
        this.isImageReady = false;
        clearTextureParam();
        AppMethodBeat.o(83189);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(83190);
        super.ApplyGLSLFilter();
        if (this.item.wmGroup != null) {
            this.item.wmGroup.init();
        }
        AppMethodBeat.o(83190);
    }

    public void clearGLSLSelf() {
        AppMethodBeat.i(83191);
        super.clearGLSLSelf();
        if (this.item.wmGroup != null) {
            this.item.wmGroup.clear();
        }
        AppMethodBeat.o(83191);
    }

    public void reset() {
        AppMethodBeat.i(83192);
        this.item.wmGroup.reset();
        super.reset();
        AppMethodBeat.o(83192);
    }
}
