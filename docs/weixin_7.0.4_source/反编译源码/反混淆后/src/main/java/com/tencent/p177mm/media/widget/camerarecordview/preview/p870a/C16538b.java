package com.tencent.p177mm.media.widget.camerarecordview.preview.p870a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p255h.C37897a;
import com.tencent.p177mm.media.widget.camerarecordview.preview.C1791c;
import com.tencent.p177mm.plugin.mmsight.model.C39387f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/CPUPreviewController;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "frameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "drawFrame", "", "data", "", "getFrameDataCallback", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.a.b */
public final class C16538b extends C9627a {
    private final C39387f fcA = new C16539a(this);

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onFrameData"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.preview.a.b$a */
    static final class C16539a implements C39387f {
        final /* synthetic */ C16538b fcB;

        C16539a(C16538b c16538b) {
            this.fcB = c16538b;
        }

        /* renamed from: O */
        public final boolean mo14870O(byte[] bArr) {
            AppMethodBeat.m2504i(13310);
            C16538b c16538b = this.fcB;
            if (bArr != null) {
                C37897a c37897a = c16538b.eXm;
                if (c37897a != null) {
                    C37897a.m63987a(c37897a, bArr);
                }
                c16538b.fcu.requestRender();
            } else {
                C4990ab.m7418v("MicroMsg.CameraPreviewGLSurfaceView", "passing draw");
            }
            AppMethodBeat.m2505o(13310);
            return false;
        }
    }

    public C16538b(C1791c c1791c) {
        C25052j.m39376p(c1791c, "view");
        super(c1791c);
        AppMethodBeat.m2504i(13311);
        AppMethodBeat.m2505o(13311);
    }

    public final C39387f getFrameDataCallback() {
        return this.fcA;
    }
}
