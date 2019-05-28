package com.tencent.mm.pluginsdk.i;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public Context context;
    public int fVl;
    private boolean faH = false;
    public int fileSize;
    public String filename;
    public MediaRecorder owh;
    public a qBs;
    public g vfT;
    public int vfU = 0;
    private final int vfV = 5;
    private a vfW = new a(Looper.getMainLooper());

    static class a extends Handler {
        boolean faH = false;
        int hzv = 0;

        public a(Looper looper) {
            super(looper);
        }

        @TargetApi(8)
        public final void handleMessage(Message message) {
            AppMethodBeat.i(27464);
            Camera camera = (Camera) message.obj;
            Parameters parameters = camera.getParameters();
            int zoom = parameters.getZoom() + this.hzv;
            if (this.faH) {
                if (zoom >= parameters.getMaxZoom() / 2) {
                    zoom = parameters.getMaxZoom() / 2;
                } else {
                    sendMessageDelayed(Message.obtain(this, 4353, 0, 0, message.obj), 20);
                }
            } else if (zoom <= 0) {
                zoom = 0;
            } else {
                sendMessageDelayed(Message.obtain(this, 4353, 0, 0, message.obj), 20);
            }
            parameters.setZoom(zoom);
            camera.setParameters(parameters);
            AppMethodBeat.o(27464);
        }
    }

    public b() {
        AppMethodBeat.i(27465);
        AppMethodBeat.o(27465);
    }

    @TargetApi(9)
    public final void setOrientationHint(final int i) {
        AppMethodBeat.i(27466);
        com.tencent.mm.compatible.a.a.a(9, new com.tencent.mm.compatible.a.a.a() {
            public final void run() {
                AppMethodBeat.i(27463);
                if (b.this.owh != null) {
                    b.this.owh.setOrientationHint(i);
                }
                AppMethodBeat.o(27463);
            }
        });
        AppMethodBeat.o(27466);
    }

    public final int b(Activity activity, boolean z) {
        AppMethodBeat.i(27467);
        this.context = activity;
        int a = this.vfT.a(activity, this.qBs, z);
        if (a != 0) {
            AppMethodBeat.o(27467);
            return a;
        }
        AppMethodBeat.o(27467);
        return 0;
    }

    public final int diG() {
        AppMethodBeat.i(27468);
        this.vfT.bPl();
        AppMethodBeat.o(27468);
        return 0;
    }

    public final int b(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(27469);
        int b = this.vfT.b(surfaceHolder);
        AppMethodBeat.o(27469);
        return b;
    }

    public final int getPreviewWidth() {
        AppMethodBeat.i(27470);
        if (this.vfT.erH.etv == null) {
            AppMethodBeat.o(27470);
            return 0;
        }
        int i = this.vfT.erH.etv.getParameters().getPreviewSize().width;
        AppMethodBeat.o(27470);
        return i;
    }

    public final int getPreviewHeight() {
        AppMethodBeat.i(27471);
        if (this.vfT.erH.etv == null) {
            AppMethodBeat.o(27471);
            return 0;
        }
        int i = this.vfT.erH.etv.getParameters().getPreviewSize().height;
        AppMethodBeat.o(27471);
        return i;
    }
}
