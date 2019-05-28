package com.tencent.mm.media.h;

import a.f.b.j;
import a.l;
import a.v;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.h.b.a;
import com.tencent.mm.media.h.b.b;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/media/render/MixRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "textureCropRect", "Landroid/graphics/Rect;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "render", "", "bitmap", "Landroid/graphics/Bitmap;", "setBlendBitmap", "setTextureCropRect", "rect", "plugin-mediaeditor_release"})
public final class c extends a {
    private final String TAG;
    public Rect eZd;

    public /* synthetic */ c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
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
        AppMethodBeat.i(13091);
        AppMethodBeat.o(13091);
    }

    private c(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5, i6);
        this.TAG = "MicroMsg.MixRenderer";
    }

    /* Access modifiers changed, original: protected|final */
    public final a Vc() {
        AppMethodBeat.i(13087);
        b bVar = new b(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType, (byte) 0);
        bVar.eZd = this.eZd;
        a aVar = bVar;
        AppMethodBeat.o(13087);
        return aVar;
    }

    public final void t(Bitmap bitmap) {
        AppMethodBeat.i(13090);
        if (bitmap != null) {
            s(bitmap);
        }
        Vd();
        AppMethodBeat.o(13090);
    }

    public final void Vd() {
        AppMethodBeat.i(13088);
        SurfaceTexture surfaceTexture = this.bsb;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
        input(this.eYN);
        super.Vd();
        AppMethodBeat.o(13088);
    }

    private final void s(Bitmap bitmap) {
        AppMethodBeat.i(13089);
        if (this.eYL instanceof b) {
            a aVar = this.eYL;
            if (aVar == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
                AppMethodBeat.o(13089);
                throw vVar;
            }
            b bVar = (b) aVar;
            j.p(bitmap, "bitmap");
            bVar.eZt = bitmap;
            AppMethodBeat.o(13089);
            return;
        }
        ab.e(this.TAG, "data don't match textureRender ");
        AppMethodBeat.o(13089);
    }
}
