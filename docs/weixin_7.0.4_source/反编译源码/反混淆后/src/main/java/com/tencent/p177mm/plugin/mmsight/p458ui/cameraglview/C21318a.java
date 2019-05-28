package com.tencent.p177mm.plugin.mmsight.p458ui.cameraglview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.model.C39387f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.mmsight.ui.cameraglview.a */
public final class C21318a {
    public C39387f fcA = new C213191();
    MMSightCameraGLSurfaceView oDD;

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.cameraglview.a$1 */
    class C213191 implements C39387f {
        C213191() {
        }

        /* renamed from: O */
        public final boolean mo14870O(byte[] bArr) {
            AppMethodBeat.m2504i(55309);
            if (C21318a.this.oDD != null) {
                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = C21318a.this.oDD;
                if (bArr == null || mMSightCameraGLSurfaceView.oDF == null || mMSightCameraGLSurfaceView.oDF.gLv) {
                    C4990ab.m7418v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
                } else {
                    mMSightCameraGLSurfaceView.oDF.mo55103b(bArr, mMSightCameraGLSurfaceView.gLw, mMSightCameraGLSurfaceView.gLx, mMSightCameraGLSurfaceView.fcf, false);
                    mMSightCameraGLSurfaceView.requestRender();
                }
            }
            AppMethodBeat.m2505o(55309);
            return false;
        }
    }

    /* renamed from: a */
    public final void mo36739a(byte[] bArr, boolean z, int i) {
        AppMethodBeat.m2504i(55310);
        if (this.oDD != null) {
            this.oDD.mo55094f(bArr, i, z);
        }
        AppMethodBeat.m2505o(55310);
    }

    public C21318a(MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView) {
        AppMethodBeat.m2504i(55311);
        this.oDD = mMSightCameraGLSurfaceView;
        AppMethodBeat.m2505o(55311);
    }

    /* renamed from: ab */
    public final void mo36740ab(int i, int i2, int i3) {
        AppMethodBeat.m2504i(55312);
        C4990ab.m7410d("MicroMsg.MMSightCameraDrawController", "cameraPreviewWidth: " + i + " cameraPreviewHeight : " + i2 + " rotate : " + i3);
        if (this.oDD != null) {
            int i4 = (i3 == 0 || i3 == 180) ? i : i2;
            if (i3 == 0 || i3 == 180) {
                i = i2;
            }
            this.oDD.mo55093ab(i4, i, i3);
        }
        AppMethodBeat.m2505o(55312);
    }

    /* renamed from: WB */
    public final void mo36738WB() {
        AppMethodBeat.m2504i(55313);
        if (this.oDD != null) {
            this.oDD.mo55092WB();
        }
        AppMethodBeat.m2505o(55313);
    }
}
