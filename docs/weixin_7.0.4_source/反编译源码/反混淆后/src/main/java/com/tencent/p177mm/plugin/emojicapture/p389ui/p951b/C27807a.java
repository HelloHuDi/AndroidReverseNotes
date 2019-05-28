package com.tencent.p177mm.plugin.emojicapture.p389ui.p951b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p255h.p256b.C6629c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0014\u001a\u00020\u0003J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0006\u0010\u0016\u001a\u00020\u0011J\b\u0010\u0017\u001a\u00020\u0011H\u0014R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureCropTopRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcExternalTexture;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "emojiFilterRender", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiFilterRenderer;", "firstRender", "", "changeSticker", "", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "getEmojiProcessOutputTexture", "release", "releaseFilterProcess", "renderImpl", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.b.a */
public final class C27807a extends C6629c {
    private final String TAG = "MicroMsg.EmojiCaptureCropTopRenderProc";
    public final C45873h loL = new C45873h();
    private boolean loM = true;

    public C27807a(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5, i6);
        AppMethodBeat.m2504i(3143);
        this.loL.boi();
        AppMethodBeat.m2505o(3143);
    }

    /* renamed from: Vf */
    public final void mo5334Vf() {
        AppMethodBeat.m2504i(3141);
        if (this.loM) {
            C4990ab.m7416i(this.TAG, "first frame start render");
        }
        this.loL.boi();
        this.loL.updateSize(this.eYY, this.eYZ);
        this.loL.mo73692b(this.eYN, this.eYS, this.eYW, this.eYX, this.eYR);
        if (this.loM) {
            C4990ab.m7416i(this.TAG, "first frame render");
            this.loM = false;
        }
        AppMethodBeat.m2505o(3141);
    }

    public final void release() {
        AppMethodBeat.m2504i(3142);
        super.release();
        this.loL.destroy();
        AppMethodBeat.m2505o(3142);
    }
}
