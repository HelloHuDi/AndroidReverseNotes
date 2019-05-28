package com.tencent.mm.media.widget.camerarecordview.preview.a;

import a.f.a.b;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/GPUPreviewController;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "TAG", "", "setRender", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "plugin-mediaeditor_release"})
public final class c extends a {
    private final String TAG = "MicroMsg.GPUPreviewController";

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
    static final class a extends k implements b<SurfaceTexture, y> {
        final /* synthetic */ c fcC;
        final /* synthetic */ com.tencent.mm.media.h.a fcz;

        a(c cVar, com.tencent.mm.media.h.a aVar) {
            this.fcC = cVar;
            this.fcz = aVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(13312);
            j.p((SurfaceTexture) obj, "it");
            this.fcz.input(this.fcz.eYN);
            this.fcC.fcu.requestRender();
            y yVar = y.AUy;
            AppMethodBeat.o(13312);
            return yVar;
        }
    }

    public c(com.tencent.mm.media.widget.camerarecordview.preview.c cVar) {
        j.p(cVar, "view");
        super(cVar);
        AppMethodBeat.i(13314);
        AppMethodBeat.o(13314);
    }

    public final void a(com.tencent.mm.media.h.a aVar) {
        AppMethodBeat.i(13313);
        j.p(aVar, "renderer");
        super.a(aVar);
        aVar.eYT = new a(this, aVar);
        ab.i(this.TAG, "setPreviewRenderer: " + aVar.hashCode());
        AppMethodBeat.o(13313);
    }
}
