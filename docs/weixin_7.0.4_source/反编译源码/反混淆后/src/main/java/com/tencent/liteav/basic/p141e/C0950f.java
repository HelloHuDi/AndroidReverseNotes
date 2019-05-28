package com.tencent.liteav.basic.p141e;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.ActUtil;
import javax.microedition.khronos.egl.EGLContext;

/* renamed from: com.tencent.liteav.basic.e.f */
public class C0950f extends Handler {
    /* renamed from: a */
    public int f1072a = 720;
    /* renamed from: b */
    public int f1073b = ActUtil.HEIGHT;
    /* renamed from: c */
    public Surface f1074c = null;
    /* renamed from: d */
    public EGLContext f1075d = null;
    /* renamed from: e */
    protected C32141b f1076e = null;
    /* renamed from: f */
    private C0949a f1077f = null;

    /* renamed from: com.tencent.liteav.basic.e.f$a */
    interface C0949a {
        /* renamed from: c */
        void mo3822c();

        /* renamed from: d */
        void mo3823d();

        /* renamed from: e */
        void mo3824e();
    }

    /* renamed from: a */
    public static void m2144a(final Handler handler, final HandlerThread handlerThread) {
        AppMethodBeat.m2504i(66228);
        if (handler == null || handlerThread == null) {
            AppMethodBeat.m2505o(66228);
            return;
        }
        Message message = new Message();
        message.what = 101;
        message.obj = new Runnable() {

            /* renamed from: com.tencent.liteav.basic.e.f$1$1 */
            class C09521 implements Runnable {
                C09521() {
                }

                public void run() {
                    AppMethodBeat.m2504i(66207);
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                    if (handlerThread != null) {
                        if (VERSION.SDK_INT >= 18) {
                            handlerThread.quitSafely();
                            AppMethodBeat.m2505o(66207);
                            return;
                        }
                        handlerThread.quit();
                    }
                    AppMethodBeat.m2505o(66207);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(66210);
                new Handler(Looper.getMainLooper()).post(new C09521());
                AppMethodBeat.m2505o(66210);
            }
        };
        handler.sendMessage(message);
        AppMethodBeat.m2505o(66228);
    }

    public C0950f(Looper looper) {
        super(looper);
    }

    /* renamed from: a */
    public void mo3826a(C0949a c0949a) {
        this.f1077f = c0949a;
    }

    /* renamed from: a */
    public EGLContext mo3825a() {
        AppMethodBeat.m2504i(66229);
        if (this.f1076e != null) {
            EGLContext c = this.f1076e.mo52724c();
            AppMethodBeat.m2505o(66229);
            return c;
        }
        AppMethodBeat.m2505o(66229);
        return null;
    }

    /* renamed from: b */
    public Surface mo3827b() {
        return this.f1074c;
    }

    /* renamed from: c */
    public void mo3828c() {
        AppMethodBeat.m2504i(66230);
        if (this.f1076e != null) {
            this.f1076e.mo52722a();
        }
        AppMethodBeat.m2505o(66230);
    }

    public void handleMessage(Message message) {
        AppMethodBeat.m2504i(66231);
        if (message == null) {
            AppMethodBeat.m2505o(66231);
            return;
        }
        switch (message.what) {
            case 100:
                m2145a(message);
                break;
            case 101:
                m2146b(message);
                break;
            case 102:
                try {
                    m2147c(message);
                    break;
                } catch (Exception e) {
                    break;
                }
        }
        if (!(message == null || message.obj == null)) {
            ((Runnable) message.obj).run();
        }
        AppMethodBeat.m2505o(66231);
    }

    /* renamed from: a */
    private void m2145a(Message message) {
        AppMethodBeat.m2504i(66232);
        if (!m2148d()) {
            m2149e();
        }
        AppMethodBeat.m2505o(66232);
    }

    /* renamed from: b */
    private void m2146b(Message message) {
        AppMethodBeat.m2504i(66233);
        m2149e();
        AppMethodBeat.m2505o(66233);
    }

    /* renamed from: c */
    private void m2147c(Message message) {
        AppMethodBeat.m2504i(66234);
        try {
            if (this.f1077f != null) {
                this.f1077f.mo3823d();
            }
            AppMethodBeat.m2505o(66234);
        } catch (Exception e) {
            TXCLog.m15676e("TXGLThreadHandler", "onMsgRend Exception " + e.getMessage());
            AppMethodBeat.m2505o(66234);
        }
    }

    /* renamed from: d */
    private boolean m2148d() {
        AppMethodBeat.m2504i(66235);
        TXCLog.m15675d("TXGLThreadHandler", String.format("init egl size[%d/%d]", new Object[]{Integer.valueOf(this.f1072a), Integer.valueOf(this.f1073b)}));
        this.f1076e = C32141b.m52280a(null, this.f1075d, this.f1074c, this.f1072a, this.f1073b);
        if (this.f1076e == null) {
            AppMethodBeat.m2505o(66235);
            return false;
        }
        if (this.f1077f != null) {
            this.f1077f.mo3822c();
        }
        AppMethodBeat.m2505o(66235);
        return true;
    }

    /* renamed from: e */
    private void m2149e() {
        AppMethodBeat.m2504i(66236);
        if (this.f1077f != null) {
            this.f1077f.mo3824e();
        }
        if (this.f1076e != null) {
            this.f1076e.mo52723b();
            this.f1076e = null;
        }
        this.f1074c = null;
        AppMethodBeat.m2505o(66236);
    }
}
