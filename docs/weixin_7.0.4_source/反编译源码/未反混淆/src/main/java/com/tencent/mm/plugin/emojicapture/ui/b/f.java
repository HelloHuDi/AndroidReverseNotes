package com.tencent.mm.plugin.emojicapture.ui.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.h.b.e;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0003J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0006\u0010\u0012\u001a\u00020\rJ\b\u0010\u0013\u001a\u00020\rH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRGBRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcYuvToRgb;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "emojiFilterRender", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiFilterRenderer;", "changeSticker", "", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "getEmojiProcessOutputTexture", "release", "releaseFilterProcess", "renderImpl", "plugin-emojicapture_release"})
public final class f extends e {
    public final h loL = new h();

    public f(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5, i6);
        AppMethodBeat.i(3174);
        AppMethodBeat.o(3174);
    }

    public final void Vf() {
        AppMethodBeat.i(3172);
        this.loL.boi();
        this.loL.updateSize(this.eYY, this.eYZ);
        this.loL.a(this.eZW, this.eYS, this.eYW, this.eYX, this.eYR);
        AppMethodBeat.o(3172);
    }

    public final void release() {
        AppMethodBeat.i(3173);
        super.release();
        this.loL.destroy();
        AppMethodBeat.o(3173);
    }
}
