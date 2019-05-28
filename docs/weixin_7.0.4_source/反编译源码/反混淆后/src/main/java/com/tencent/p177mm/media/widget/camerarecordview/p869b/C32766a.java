package com.tencent.p177mm.media.widget.camerarecordview.p869b;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p255h.C37897a;
import com.tencent.p177mm.media.widget.camerarecordview.C26393b;
import com.tencent.p177mm.media.widget.camerarecordview.p1465c.C32768a;
import com.tencent.p177mm.media.widget.p868a.C32765b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0015\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u001c\u001a\u00020\u001aR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "", "ctx", "Landroid/content/Context;", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Landroid/content/Context;Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "currentDisplayRotation", "", "orientationChangeListener", "com/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1;", "checkContext", "", "enableFit", "", "enable", "release", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.widget.camerarecordview.b.a */
public final class C32766a {
    public static final C9621a fca = new C9621a();
    public Context context;
    C32765b faw;
    private int fbY;
    public C32767b fbZ;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.b.a$a */
    public static final class C9621a {
        private C9621a() {
        }

        public /* synthetic */ C9621a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1", "Landroid/view/OrientationEventListener;", "onOrientationChanged", "", "orientation", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.b.a$b */
    public static final class C32767b extends OrientationEventListener {
        final /* synthetic */ C32766a fcb;
        final /* synthetic */ C32768a fcc;

        C32767b(C32768a c32768a, Context context, int i) {
            this.fcb = c32768a;
            this.fcc = context;
            super(i, 3);
        }

        public final void onOrientationChanged(int i) {
            AppMethodBeat.m2504i(13262);
            if (C32766a.m53515a(this.fcb)) {
                Context context = this.fcb.context;
                if (context == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.m2505o(13262);
                    throw c44941v;
                }
                WindowManager windowManager = ((Activity) context).getWindowManager();
                C25052j.m39375o(windowManager, "(context as Activity).windowManager");
                Display defaultDisplay = windowManager.getDefaultDisplay();
                C25052j.m39375o(defaultDisplay, "(context as Activity).windowManager.defaultDisplay");
                int rotation = defaultDisplay.getRotation();
                if (rotation == this.fcb.fbY) {
                    AppMethodBeat.m2505o(13262);
                    return;
                }
                C4990ab.m7416i("MicroMsg.PreviewOrientationFit", "last rotation :" + this.fcb.fbY + " ,current rotation:" + rotation);
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
                C32765b c32765b;
                C26393b c26393b;
                C37897a renderer;
                if (rotation == 0) {
                    c32765b = this.fcb.faw;
                    if (c32765b != null) {
                        C32765b.m53510kf(270);
                        this.fcc.getCameraPreviewView().mo5342a(c32765b);
                        c26393b = C26393b.fbR;
                        renderer = C26393b.getRenderer();
                        if (renderer != null) {
                            renderer.mo60646ka(C32765b.m53502Wi());
                            AppMethodBeat.m2505o(13262);
                            return;
                        }
                        AppMethodBeat.m2505o(13262);
                        return;
                    }
                    AppMethodBeat.m2505o(13262);
                    return;
                }
                if (rotation == 180) {
                    c32765b = this.fcb.faw;
                    if (c32765b != null) {
                        C32765b.m53510kf(90);
                        this.fcc.getCameraPreviewView().mo5342a(c32765b);
                        c26393b = C26393b.fbR;
                        renderer = C26393b.getRenderer();
                        if (renderer != null) {
                            renderer.mo60646ka(C32765b.m53502Wi());
                            AppMethodBeat.m2505o(13262);
                            return;
                        }
                        AppMethodBeat.m2505o(13262);
                        return;
                    }
                }
                AppMethodBeat.m2505o(13262);
                return;
            }
            AppMethodBeat.m2505o(13262);
        }
    }

    static {
        AppMethodBeat.m2504i(13265);
        AppMethodBeat.m2505o(13265);
    }

    public C32766a(Context context, C32768a c32768a) {
        C25052j.m39376p(context, "ctx");
        C25052j.m39376p(c32768a, "process");
        AppMethodBeat.m2504i(13264);
        this.context = context;
        this.fbZ = new C32767b(this, c32768a, this.context);
        AppMethodBeat.m2505o(13264);
    }

    /* renamed from: a */
    public static final /* synthetic */ boolean m53515a(C32766a c32766a) {
        AppMethodBeat.m2504i(13266);
        boolean Wz = c32766a.m53513Wz();
        AppMethodBeat.m2505o(13266);
        return Wz;
    }

    /* renamed from: a */
    public final void mo53311a(boolean z, C32765b c32765b) {
        AppMethodBeat.m2504i(13263);
        C4990ab.m7416i("MicroMsg.PreviewOrientationFit", "enable :" + z + " ,cameraConfig " + c32765b);
        Context context;
        C44941v c44941v;
        if (!m53513Wz()) {
            AppMethodBeat.m2505o(13263);
        } else if (z) {
            this.faw = c32765b;
            context = this.context;
            if (context == null) {
                c44941v = new C44941v("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.m2505o(13263);
                throw c44941v;
            }
            ((Activity) context).setRequestedOrientation(7);
            this.fbZ.enable();
            AppMethodBeat.m2505o(13263);
        } else {
            context = this.context;
            if (context == null) {
                c44941v = new C44941v("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.m2505o(13263);
                throw c44941v;
            }
            ((Activity) context).setRequestedOrientation(1);
            this.fbZ.disable();
            this.fbY = 0;
            AppMethodBeat.m2505o(13263);
        }
    }

    /* renamed from: Wz */
    private final boolean m53513Wz() {
        if (this.context == null) {
            return false;
        }
        return true;
    }
}
