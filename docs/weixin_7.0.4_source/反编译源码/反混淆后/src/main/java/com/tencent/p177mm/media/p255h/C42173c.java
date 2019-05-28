package com.tencent.p177mm.media.p255h;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p255h.p256b.C1786a;
import com.tencent.p177mm.media.p255h.p256b.C6628b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/media/render/MixRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "textureCropRect", "Landroid/graphics/Rect;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "render", "", "bitmap", "Landroid/graphics/Bitmap;", "setBlendBitmap", "setTextureCropRect", "rect", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.h.c */
public final class C42173c extends C37897a {
    private final String TAG;
    public Rect eZd;

    public /* synthetic */ C42173c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9 = 1;
        if ((i7 & 16) != 0) {
            i8 = 1;
        } else {
            i8 = i5;
        }
        if ((i7 & 32) == 0) {
            i9 = i6;
        }
        this(i, i2, i3, i4, i8, i9);
        AppMethodBeat.m2504i(13091);
        AppMethodBeat.m2505o(13091);
    }

    private C42173c(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5, i6);
        this.TAG = "MicroMsg.MixRenderer";
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Vc */
    public final C1786a mo20940Vc() {
        AppMethodBeat.m2504i(13087);
        C6628b c6628b = new C6628b(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType, (byte) 0);
        c6628b.eZd = this.eZd;
        C1786a c1786a = c6628b;
        AppMethodBeat.m2505o(13087);
        return c1786a;
    }

    /* renamed from: t */
    public final void mo67717t(Bitmap bitmap) {
        AppMethodBeat.m2504i(13090);
        if (bitmap != null) {
            m74359s(bitmap);
        }
        mo60640Vd();
        AppMethodBeat.m2505o(13090);
    }

    /* renamed from: Vd */
    public final void mo60640Vd() {
        AppMethodBeat.m2504i(13088);
        SurfaceTexture surfaceTexture = this.bsb;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
        input(this.eYN);
        super.mo60640Vd();
        AppMethodBeat.m2505o(13088);
    }

    /* renamed from: s */
    private final void m74359s(Bitmap bitmap) {
        AppMethodBeat.m2504i(13089);
        if (this.eYL instanceof C6628b) {
            C1786a c1786a = this.eYL;
            if (c1786a == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
                AppMethodBeat.m2505o(13089);
                throw c44941v;
            }
            C6628b c6628b = (C6628b) c1786a;
            C25052j.m39376p(bitmap, "bitmap");
            c6628b.eZt = bitmap;
            AppMethodBeat.m2505o(13089);
            return;
        }
        C4990ab.m7412e(this.TAG, "data don't match textureRender ");
        AppMethodBeat.m2505o(13089);
    }
}
