package com.tencent.mm.compatible.e;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.atomic.AtomicInteger;

public final class t {
    private static final AtomicInteger ett = new AtomicInteger(0);
    private static final AtomicInteger etu = new AtomicInteger(0);
    public Camera etv;

    static {
        AppMethodBeat.i(93007);
        AppMethodBeat.o(93007);
    }

    public t(Camera camera) {
        AppMethodBeat.i(92992);
        this.etv = camera;
        if (camera != null) {
            ett.incrementAndGet();
            ab.c("MicroMsg.MCamera", "init MCamera, initCount:%s, releaseCount:%s", ett, etu);
            if (ett.get() - etu.get() > 1) {
                ab.i("MicroMsg.MCamera", "MCamera leak, do report, current process:%s", ah.getProcessName());
                a aVar = a.epB;
                a.eU(61);
                if (ah.bqo()) {
                    aVar = a.epB;
                    a.eU(62);
                } else if (ah.doF()) {
                    aVar = a.epB;
                    a.eU(63);
                } else if (ah.isAppBrandProcess()) {
                    aVar = a.epB;
                    a.eU(64);
                }
                ett.set(0);
                etu.set(0);
            }
            AppMethodBeat.o(92992);
            return;
        }
        ab.c("MicroMsg.MCamera", "init MCamera with null camera!!!", new Object[0]);
        AppMethodBeat.o(92992);
    }

    public final Parameters getParameters() {
        AppMethodBeat.i(92993);
        if (this.etv != null) {
            Parameters parameters = this.etv.getParameters();
            AppMethodBeat.o(92993);
            return parameters;
        }
        AppMethodBeat.o(92993);
        return null;
    }

    public final void setParameters(Parameters parameters) {
        AppMethodBeat.i(92994);
        if (this.etv != null) {
            this.etv.setParameters(parameters);
        }
        AppMethodBeat.o(92994);
    }

    public final void setPreviewDisplay(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(92995);
        if (this.etv != null) {
            this.etv.setPreviewDisplay(surfaceHolder);
        }
        AppMethodBeat.o(92995);
    }

    public final void setPreviewTexture(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(92996);
        if (this.etv != null) {
            this.etv.setPreviewTexture(surfaceTexture);
        }
        AppMethodBeat.o(92996);
    }

    public final void startPreview() {
        AppMethodBeat.i(92997);
        if (this.etv != null) {
            this.etv.startPreview();
        }
        AppMethodBeat.o(92997);
    }

    public final void setDisplayOrientation(int i) {
        AppMethodBeat.i(92998);
        if (this.etv != null) {
            this.etv.setDisplayOrientation(i);
        }
        AppMethodBeat.o(92998);
    }

    public final void stopPreview() {
        AppMethodBeat.i(92999);
        if (this.etv != null) {
            this.etv.stopPreview();
        }
        AppMethodBeat.o(92999);
    }

    public final void autoFocus(AutoFocusCallback autoFocusCallback) {
        AppMethodBeat.i(93000);
        if (this.etv != null) {
            this.etv.autoFocus(autoFocusCallback);
        }
        AppMethodBeat.o(93000);
    }

    public final void setOneShotPreviewCallback(PreviewCallback previewCallback) {
        AppMethodBeat.i(93001);
        if (this.etv != null) {
            this.etv.setOneShotPreviewCallback(previewCallback);
        }
        AppMethodBeat.o(93001);
    }

    public final void cancelAutoFocus() {
        AppMethodBeat.i(93002);
        if (this.etv != null) {
            this.etv.cancelAutoFocus();
        }
        AppMethodBeat.o(93002);
    }

    public final void release() {
        AppMethodBeat.i(93003);
        if (this.etv != null) {
            this.etv.release();
            etu.incrementAndGet();
            ab.c("MicroMsg.MCamera", "release MCamera, initCount: %s, releaseCount: %s", ett, etu);
        }
        AppMethodBeat.o(93003);
    }

    public final void setPreviewCallback(PreviewCallback previewCallback) {
        AppMethodBeat.i(93004);
        if (this.etv != null) {
            this.etv.setPreviewCallback(previewCallback);
        }
        AppMethodBeat.o(93004);
    }

    public final void setPreviewCallbackWithBuffer(PreviewCallback previewCallback) {
        AppMethodBeat.i(93005);
        if (this.etv != null) {
            this.etv.setPreviewCallbackWithBuffer(previewCallback);
        }
        AppMethodBeat.o(93005);
    }

    public final void addCallbackBuffer(byte[] bArr) {
        AppMethodBeat.i(93006);
        if (this.etv != null) {
            this.etv.addCallbackBuffer(bArr);
        }
        AppMethodBeat.o(93006);
    }
}
