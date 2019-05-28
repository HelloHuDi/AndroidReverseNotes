package com.tencent.ttpic.filter;

import com.tencent.filter.C25624m.C25627n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem;

public class WatermarkDynamicFilter extends DynamicStickerFilter {
    public WatermarkDynamicFilter(StickerItem stickerItem, String str) {
        super(stickerItem, str);
    }

    /* Access modifiers changed, original: protected */
    public void updateTextureParam(int i, long j) {
        AppMethodBeat.m2504i(83185);
        if (this.item.wmGroup != null) {
            this.item.wmGroup.updateTexture(j);
            this.isImageReady = true;
            addParam(new C25627n("inputImageTexture2", this.item.wmGroup.getTexture(), 33986));
            AppMethodBeat.m2505o(83185);
            return;
        }
        this.isImageReady = false;
        clearTextureParam();
        AppMethodBeat.m2505o(83185);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(83186);
        super.ApplyGLSLFilter();
        if (this.item.wmGroup != null) {
            this.item.wmGroup.init();
        }
        AppMethodBeat.m2505o(83186);
    }

    public void clearGLSLSelf() {
        AppMethodBeat.m2504i(83187);
        super.clearGLSLSelf();
        if (this.item.wmGroup != null) {
            this.item.wmGroup.clear();
        }
        AppMethodBeat.m2505o(83187);
    }

    public void reset() {
        AppMethodBeat.m2504i(83188);
        this.item.wmGroup.reset();
        super.reset();
        AppMethodBeat.m2505o(83188);
    }
}
