package com.tencent.mm.media.widget.camerarecordview.b;

import a.f.b.j;
import a.l;
import a.v;
import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0015\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u001c\u001a\u00020\u001aR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "", "ctx", "Landroid/content/Context;", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Landroid/content/Context;Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "currentDisplayRotation", "", "orientationChangeListener", "com/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1;", "checkContext", "", "enableFit", "", "enable", "release", "Companion", "plugin-mediaeditor_release"})
public final class a {
    public static final a fca = new a();
    public Context context;
    com.tencent.mm.media.widget.a.b faw;
    private int fbY;
    public b fbZ;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1", "Landroid/view/OrientationEventListener;", "onOrientationChanged", "", "orientation", "", "plugin-mediaeditor_release"})
    public static final class b extends OrientationEventListener {
        final /* synthetic */ a fcb;
        final /* synthetic */ com.tencent.mm.media.widget.camerarecordview.c.a fcc;

        b(com.tencent.mm.media.widget.camerarecordview.c.a aVar, Context context, int i) {
            this.fcb = aVar;
            this.fcc = context;
            super(i, 3);
        }

        public final void onOrientationChanged(int i) {
            AppMethodBeat.i(13262);
            if (a.a(this.fcb)) {
                Context context = this.fcb.context;
                if (context == null) {
                    v vVar = new v("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(13262);
                    throw vVar;
                }
                WindowManager windowManager = ((Activity) context).getWindowManager();
                j.o(windowManager, "(context as Activity).windowManager");
                Display defaultDisplay = windowManager.getDefaultDisplay();
                j.o(defaultDisplay, "(context as Activity).windowManager.defaultDisplay");
                int rotation = defaultDisplay.getRotation();
                if (rotation == this.fcb.fbY) {
                    AppMethodBeat.o(13262);
                    return;
                }
                ab.i("MicroMsg.PreviewOrientationFit", "last rotation :" + this.fcb.fbY + " ,current rotation:" + rotation);
                this.fcb.fbY = rotation;
                switch (rotation) {
                    case 0:
                        rotation = 0;
                        break;
                    case 1:
                        rotation = 90;
                        break;
                    case 2:
                        rotation = 180;
                        break;
                    case 3:
                        rotation = 270;
                        break;
                    default:
                        rotation = 0;
                        break;
                }
                com.tencent.mm.media.widget.a.b bVar;
                com.tencent.mm.media.widget.camerarecordview.b bVar2;
                com.tencent.mm.media.h.a renderer;
                if (rotation == 0) {
                    bVar = this.fcb.faw;
                    if (bVar != null) {
                        com.tencent.mm.media.widget.a.b.kf(270);
                        this.fcc.getCameraPreviewView().a(bVar);
                        bVar2 = com.tencent.mm.media.widget.camerarecordview.b.fbR;
                        renderer = com.tencent.mm.media.widget.camerarecordview.b.getRenderer();
                        if (renderer != null) {
                            renderer.ka(com.tencent.mm.media.widget.a.b.Wi());
                            AppMethodBeat.o(13262);
                            return;
                        }
                        AppMethodBeat.o(13262);
                        return;
                    }
                    AppMethodBeat.o(13262);
                    return;
                }
                if (rotation == 180) {
                    bVar = this.fcb.faw;
                    if (bVar != null) {
                        com.tencent.mm.media.widget.a.b.kf(90);
                        this.fcc.getCameraPreviewView().a(bVar);
                        bVar2 = com.tencent.mm.media.widget.camerarecordview.b.fbR;
                        renderer = com.tencent.mm.media.widget.camerarecordview.b.getRenderer();
                        if (renderer != null) {
                            renderer.ka(com.tencent.mm.media.widget.a.b.Wi());
                            AppMethodBeat.o(13262);
                            return;
                        }
                        AppMethodBeat.o(13262);
                        return;
                    }
                }
                AppMethodBeat.o(13262);
                return;
            }
            AppMethodBeat.o(13262);
        }
    }

    static {
        AppMethodBeat.i(13265);
        AppMethodBeat.o(13265);
    }

    public a(Context context, com.tencent.mm.media.widget.camerarecordview.c.a aVar) {
        j.p(context, "ctx");
        j.p(aVar, "process");
        AppMethodBeat.i(13264);
        this.context = context;
        this.fbZ = new b(this, aVar, this.context);
        AppMethodBeat.o(13264);
    }

    public static final /* synthetic */ boolean a(a aVar) {
        AppMethodBeat.i(13266);
        boolean Wz = aVar.Wz();
        AppMethodBeat.o(13266);
        return Wz;
    }

    public final void a(boolean z, com.tencent.mm.media.widget.a.b bVar) {
        AppMethodBeat.i(13263);
        ab.i("MicroMsg.PreviewOrientationFit", "enable :" + z + " ,cameraConfig " + bVar);
        Context context;
        v vVar;
        if (!Wz()) {
            AppMethodBeat.o(13263);
        } else if (z) {
            this.faw = bVar;
            context = this.context;
            if (context == null) {
                vVar = new v("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(13263);
                throw vVar;
            }
            ((Activity) context).setRequestedOrientation(7);
            this.fbZ.enable();
            AppMethodBeat.o(13263);
        } else {
            context = this.context;
            if (context == null) {
                vVar = new v("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(13263);
                throw vVar;
            }
            ((Activity) context).setRequestedOrientation(1);
            this.fbZ.disable();
            this.fbY = 0;
            AppMethodBeat.o(13263);
        }
    }

    private final boolean Wz() {
        if (this.context == null) {
            return false;
        }
        return true;
    }
}
