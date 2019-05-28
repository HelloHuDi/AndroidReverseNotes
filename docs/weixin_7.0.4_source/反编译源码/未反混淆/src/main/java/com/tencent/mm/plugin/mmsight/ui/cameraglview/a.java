package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public f fcA = new f() {
        public final boolean O(byte[] bArr) {
            AppMethodBeat.i(55309);
            if (a.this.oDD != null) {
                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = a.this.oDD;
                if (bArr == null || mMSightCameraGLSurfaceView.oDF == null || mMSightCameraGLSurfaceView.oDF.gLv) {
                    ab.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
                } else {
                    mMSightCameraGLSurfaceView.oDF.b(bArr, mMSightCameraGLSurfaceView.gLw, mMSightCameraGLSurfaceView.gLx, mMSightCameraGLSurfaceView.fcf, false);
                    mMSightCameraGLSurfaceView.requestRender();
                }
            }
            AppMethodBeat.o(55309);
            return false;
        }
    };
    MMSightCameraGLSurfaceView oDD;

    public final void a(byte[] bArr, boolean z, int i) {
        AppMethodBeat.i(55310);
        if (this.oDD != null) {
            this.oDD.f(bArr, i, z);
        }
        AppMethodBeat.o(55310);
    }

    public a(MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView) {
        AppMethodBeat.i(55311);
        this.oDD = mMSightCameraGLSurfaceView;
        AppMethodBeat.o(55311);
    }

    public final void ab(int i, int i2, int i3) {
        AppMethodBeat.i(55312);
        ab.d("MicroMsg.MMSightCameraDrawController", "cameraPreviewWidth: " + i + " cameraPreviewHeight : " + i2 + " rotate : " + i3);
        if (this.oDD != null) {
            int i4 = (i3 == 0 || i3 == 180) ? i : i2;
            if (i3 == 0 || i3 == 180) {
                i = i2;
            }
            this.oDD.ab(i4, i, i3);
        }
        AppMethodBeat.o(55312);
    }

    public final void WB() {
        AppMethodBeat.i(55313);
        if (this.oDD != null) {
            this.oDD.WB();
        }
        AppMethodBeat.o(55313);
    }
}
