package com.tencent.p177mm.compatible.p221e;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p844d.C9238a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.compatible.e.t */
public final class C41938t {
    private static final AtomicInteger ett = new AtomicInteger(0);
    private static final AtomicInteger etu = new AtomicInteger(0);
    public Camera etv;

    static {
        AppMethodBeat.m2504i(93007);
        AppMethodBeat.m2505o(93007);
    }

    public C41938t(Camera camera) {
        AppMethodBeat.m2504i(92992);
        this.etv = camera;
        if (camera != null) {
            ett.incrementAndGet();
            C4990ab.m7409c("MicroMsg.MCamera", "init MCamera, initCount:%s, releaseCount:%s", ett, etu);
            if (ett.get() - etu.get() > 1) {
                C4990ab.m7417i("MicroMsg.MCamera", "MCamera leak, do report, current process:%s", C4996ah.getProcessName());
                C9238a c9238a = C9238a.epB;
                C9238a.m16771eU(61);
                if (C4996ah.bqo()) {
                    c9238a = C9238a.epB;
                    C9238a.m16771eU(62);
                } else if (C4996ah.doF()) {
                    c9238a = C9238a.epB;
                    C9238a.m16771eU(63);
                } else if (C4996ah.isAppBrandProcess()) {
                    c9238a = C9238a.epB;
                    C9238a.m16771eU(64);
                }
                ett.set(0);
                etu.set(0);
            }
            AppMethodBeat.m2505o(92992);
            return;
        }
        C4990ab.m7409c("MicroMsg.MCamera", "init MCamera with null camera!!!", new Object[0]);
        AppMethodBeat.m2505o(92992);
    }

    public final Parameters getParameters() {
        AppMethodBeat.m2504i(92993);
        if (this.etv != null) {
            Parameters parameters = this.etv.getParameters();
            AppMethodBeat.m2505o(92993);
            return parameters;
        }
        AppMethodBeat.m2505o(92993);
        return null;
    }

    public final void setParameters(Parameters parameters) {
        AppMethodBeat.m2504i(92994);
        if (this.etv != null) {
            this.etv.setParameters(parameters);
        }
        AppMethodBeat.m2505o(92994);
    }

    public final void setPreviewDisplay(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(92995);
        if (this.etv != null) {
            this.etv.setPreviewDisplay(surfaceHolder);
        }
        AppMethodBeat.m2505o(92995);
    }

    public final void setPreviewTexture(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(92996);
        if (this.etv != null) {
            this.etv.setPreviewTexture(surfaceTexture);
        }
        AppMethodBeat.m2505o(92996);
    }

    public final void startPreview() {
        AppMethodBeat.m2504i(92997);
        if (this.etv != null) {
            this.etv.startPreview();
        }
        AppMethodBeat.m2505o(92997);
    }

    public final void setDisplayOrientation(int i) {
        AppMethodBeat.m2504i(92998);
        if (this.etv != null) {
            this.etv.setDisplayOrientation(i);
        }
        AppMethodBeat.m2505o(92998);
    }

    public final void stopPreview() {
        AppMethodBeat.m2504i(92999);
        if (this.etv != null) {
            this.etv.stopPreview();
        }
        AppMethodBeat.m2505o(92999);
    }

    public final void autoFocus(AutoFocusCallback autoFocusCallback) {
        AppMethodBeat.m2504i(93000);
        if (this.etv != null) {
            this.etv.autoFocus(autoFocusCallback);
        }
        AppMethodBeat.m2505o(93000);
    }

    public final void setOneShotPreviewCallback(PreviewCallback previewCallback) {
        AppMethodBeat.m2504i(93001);
        if (this.etv != null) {
            this.etv.setOneShotPreviewCallback(previewCallback);
        }
        AppMethodBeat.m2505o(93001);
    }

    public final void cancelAutoFocus() {
        AppMethodBeat.m2504i(93002);
        if (this.etv != null) {
            this.etv.cancelAutoFocus();
        }
        AppMethodBeat.m2505o(93002);
    }

    public final void release() {
        AppMethodBeat.m2504i(93003);
        if (this.etv != null) {
            this.etv.release();
            etu.incrementAndGet();
            C4990ab.m7409c("MicroMsg.MCamera", "release MCamera, initCount: %s, releaseCount: %s", ett, etu);
        }
        AppMethodBeat.m2505o(93003);
    }

    public final void setPreviewCallback(PreviewCallback previewCallback) {
        AppMethodBeat.m2504i(93004);
        if (this.etv != null) {
            this.etv.setPreviewCallback(previewCallback);
        }
        AppMethodBeat.m2505o(93004);
    }

    public final void setPreviewCallbackWithBuffer(PreviewCallback previewCallback) {
        AppMethodBeat.m2504i(93005);
        if (this.etv != null) {
            this.etv.setPreviewCallbackWithBuffer(previewCallback);
        }
        AppMethodBeat.m2505o(93005);
    }

    public final void addCallbackBuffer(byte[] bArr) {
        AppMethodBeat.m2504i(93006);
        if (this.etv != null) {
            this.etv.addCallbackBuffer(bArr);
        }
        AppMethodBeat.m2505o(93006);
    }
}
