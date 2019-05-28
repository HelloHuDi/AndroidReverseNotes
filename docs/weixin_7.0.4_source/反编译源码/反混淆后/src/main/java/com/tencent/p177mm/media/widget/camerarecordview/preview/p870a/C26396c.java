package com.tencent.p177mm.media.widget.camerarecordview.preview.p870a;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p255h.C37897a;
import com.tencent.p177mm.media.widget.camerarecordview.preview.C1791c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/GPUPreviewController;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "TAG", "", "setRender", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.a.c */
public final class C26396c extends C9627a {
    private final String TAG = "MicroMsg.GPUPreviewController";

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.a.c$a */
    static final class C26397a extends C25053k implements C17126b<SurfaceTexture, C37091y> {
        final /* synthetic */ C26396c fcC;
        final /* synthetic */ C37897a fcz;

        C26397a(C26396c c26396c, C37897a c37897a) {
            this.fcC = c26396c;
            this.fcz = c37897a;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(13312);
            C25052j.m39376p((SurfaceTexture) obj, "it");
            this.fcz.input(this.fcz.eYN);
            this.fcC.fcu.requestRender();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13312);
            return c37091y;
        }
    }

    public C26396c(C1791c c1791c) {
        C25052j.m39376p(c1791c, "view");
        super(c1791c);
        AppMethodBeat.m2504i(13314);
        AppMethodBeat.m2505o(13314);
    }

    /* renamed from: a */
    public final void mo20948a(C37897a c37897a) {
        AppMethodBeat.m2504i(13313);
        C25052j.m39376p(c37897a, "renderer");
        super.mo20948a(c37897a);
        c37897a.eYT = new C26397a(this, c37897a);
        C4990ab.m7416i(this.TAG, "setPreviewRenderer: " + c37897a.hashCode());
        AppMethodBeat.m2505o(13313);
    }
}
