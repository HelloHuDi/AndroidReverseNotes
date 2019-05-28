package com.tencent.liteav.basic.e;

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

public class f extends Handler {
    public int a = 720;
    public int b = ActUtil.HEIGHT;
    public Surface c = null;
    public EGLContext d = null;
    protected b e = null;
    private a f = null;

    interface a {
        void c();

        void d();

        void e();
    }

    public static void a(final Handler handler, final HandlerThread handlerThread) {
        AppMethodBeat.i(66228);
        if (handler == null || handlerThread == null) {
            AppMethodBeat.o(66228);
            return;
        }
        Message message = new Message();
        message.what = 101;
        message.obj = new Runnable() {
            public final void run() {
                AppMethodBeat.i(66210);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        AppMethodBeat.i(66207);
                        if (handler != null) {
                            handler.removeCallbacksAndMessages(null);
                        }
                        if (handlerThread != null) {
                            if (VERSION.SDK_INT >= 18) {
                                handlerThread.quitSafely();
                                AppMethodBeat.o(66207);
                                return;
                            }
                            handlerThread.quit();
                        }
                        AppMethodBeat.o(66207);
                    }
                });
                AppMethodBeat.o(66210);
            }
        };
        handler.sendMessage(message);
        AppMethodBeat.o(66228);
    }

    public f(Looper looper) {
        super(looper);
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public EGLContext a() {
        AppMethodBeat.i(66229);
        if (this.e != null) {
            EGLContext c = this.e.c();
            AppMethodBeat.o(66229);
            return c;
        }
        AppMethodBeat.o(66229);
        return null;
    }

    public Surface b() {
        return this.c;
    }

    public void c() {
        AppMethodBeat.i(66230);
        if (this.e != null) {
            this.e.a();
        }
        AppMethodBeat.o(66230);
    }

    public void handleMessage(Message message) {
        AppMethodBeat.i(66231);
        if (message == null) {
            AppMethodBeat.o(66231);
            return;
        }
        switch (message.what) {
            case 100:
                a(message);
                break;
            case 101:
                b(message);
                break;
            case 102:
                try {
                    c(message);
                    break;
                } catch (Exception e) {
                    break;
                }
        }
        if (!(message == null || message.obj == null)) {
            ((Runnable) message.obj).run();
        }
        AppMethodBeat.o(66231);
    }

    private void a(Message message) {
        AppMethodBeat.i(66232);
        if (!d()) {
            e();
        }
        AppMethodBeat.o(66232);
    }

    private void b(Message message) {
        AppMethodBeat.i(66233);
        e();
        AppMethodBeat.o(66233);
    }

    private void c(Message message) {
        AppMethodBeat.i(66234);
        try {
            if (this.f != null) {
                this.f.d();
            }
            AppMethodBeat.o(66234);
        } catch (Exception e) {
            TXCLog.e("TXGLThreadHandler", "onMsgRend Exception " + e.getMessage());
            AppMethodBeat.o(66234);
        }
    }

    private boolean d() {
        AppMethodBeat.i(66235);
        TXCLog.d("TXGLThreadHandler", String.format("init egl size[%d/%d]", new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b)}));
        this.e = b.a(null, this.d, this.c, this.a, this.b);
        if (this.e == null) {
            AppMethodBeat.o(66235);
            return false;
        }
        if (this.f != null) {
            this.f.c();
        }
        AppMethodBeat.o(66235);
        return true;
    }

    private void e() {
        AppMethodBeat.i(66236);
        if (this.f != null) {
            this.f.e();
        }
        if (this.e != null) {
            this.e.b();
            this.e = null;
        }
        this.c = null;
        AppMethodBeat.o(66236);
    }
}
