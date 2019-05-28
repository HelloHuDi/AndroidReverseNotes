package com.tencent.p177mm.pluginsdk.p1082i;

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
import com.tencent.p177mm.compatible.p1597a.C41933a;
import com.tencent.p177mm.compatible.p1597a.C41933a.C41932a;

/* renamed from: com.tencent.mm.pluginsdk.i.b */
public final class C30048b {
    public Context context;
    public int fVl;
    private boolean faH = false;
    public int fileSize;
    public String filename;
    public MediaRecorder owh;
    public C40435a qBs;
    public C44054g vfT;
    public int vfU = 0;
    private final int vfV = 5;
    private C14861a vfW = new C14861a(Looper.getMainLooper());

    /* renamed from: com.tencent.mm.pluginsdk.i.b$a */
    static class C14861a extends Handler {
        boolean faH = false;
        int hzv = 0;

        public C14861a(Looper looper) {
            super(looper);
        }

        @TargetApi(8)
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(27464);
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
            AppMethodBeat.m2505o(27464);
        }
    }

    public C30048b() {
        AppMethodBeat.m2504i(27465);
        AppMethodBeat.m2505o(27465);
    }

    @TargetApi(9)
    public final void setOrientationHint(final int i) {
        AppMethodBeat.m2504i(27466);
        C41933a.m74069a(9, new C41932a() {
            public final void run() {
                AppMethodBeat.m2504i(27463);
                if (C30048b.this.owh != null) {
                    C30048b.this.owh.setOrientationHint(i);
                }
                AppMethodBeat.m2505o(27463);
            }
        });
        AppMethodBeat.m2505o(27466);
    }

    /* renamed from: b */
    public final int mo48270b(Activity activity, boolean z) {
        AppMethodBeat.m2504i(27467);
        this.context = activity;
        int a = this.vfT.mo69742a(activity, this.qBs, z);
        if (a != 0) {
            AppMethodBeat.m2505o(27467);
            return a;
        }
        AppMethodBeat.m2505o(27467);
        return 0;
    }

    public final int diG() {
        AppMethodBeat.m2504i(27468);
        this.vfT.bPl();
        AppMethodBeat.m2505o(27468);
        return 0;
    }

    /* renamed from: b */
    public final int mo48271b(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(27469);
        int b = this.vfT.mo69743b(surfaceHolder);
        AppMethodBeat.m2505o(27469);
        return b;
    }

    public final int getPreviewWidth() {
        AppMethodBeat.m2504i(27470);
        if (this.vfT.erH.etv == null) {
            AppMethodBeat.m2505o(27470);
            return 0;
        }
        int i = this.vfT.erH.etv.getParameters().getPreviewSize().width;
        AppMethodBeat.m2505o(27470);
        return i;
    }

    public final int getPreviewHeight() {
        AppMethodBeat.m2504i(27471);
        if (this.vfT.erH.etv == null) {
            AppMethodBeat.m2505o(27471);
            return 0;
        }
        int i = this.vfT.erH.etv.getParameters().getPreviewSize().height;
        AppMethodBeat.m2505o(27471);
        return i;
    }
}
