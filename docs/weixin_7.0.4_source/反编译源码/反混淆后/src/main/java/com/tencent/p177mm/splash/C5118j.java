package com.tencent.p177mm.splash;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.splash.j */
final class C5118j implements Callback {
    public static int xHf = 100;
    public static int xHg = 113;
    public static int xHh = 114;
    public static int xHi = 115;
    public static int xHj = 116;
    public static int xHk = 121;
    public static int xHl = 122;
    public static int xHm = 126;
    public static int xHn = 145;
    private static boolean xHo = false;
    private static Runnable xHp;
    private static boolean xHr = false;
    private Context mContext;
    Callback oUK;
    private boolean xHq = false;

    public C5118j(Context context, Callback callback) {
        this.mContext = context;
        this.oUK = callback;
    }

    /* renamed from: av */
    public static void m7784av(Runnable runnable) {
        xHo = true;
        xHp = runnable;
    }

    public static boolean dro() {
        return xHr;
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.m2504i(114884);
        if (this.xHq) {
            C5115h.m7780g("WxSplash.SplashHackHandlerCallback", "found a infinite call loop", new Object[0]);
            AppMethodBeat.m2505o(114884);
            return true;
        }
        xHr = false;
        C5115h.m7780g("WxSplash.SplashHackHandlerCallback", "before handleMessage %s, splash %s, pending early %s", Integer.valueOf(message.what), Boolean.valueOf(C5115h.dra()), Boolean.valueOf(C5115h.drb()));
        if (xHo && message.what == 987654321) {
            if (xHp != null) {
                C5115h.m7780g("WxSplash.SplashHackHandlerCallback", "verify hack received.", new Object[0]);
                xHp.run();
            }
            AppMethodBeat.m2505o(114884);
            return true;
        }
        if (C5115h.dra() && !C5115h.drb()) {
            C5115h.m7780g("WxSplash.SplashHackHandlerCallback", "handleMessage %s, splash %s", Integer.valueOf(message.what), Boolean.valueOf(C5115h.dra()));
            if (message.what == xHg || message.what == xHh || message.what == xHi || message.what == xHj || message.what == xHk || message.what == xHl || message.what == xHn) {
                Message obtain = Message.obtain();
                obtain.copyFrom(message);
                C5115h.xGD.add(obtain);
                if (C5115h.xGI != null) {
                    C5115h.xGI.mo4571BO();
                }
                AppMethodBeat.m2505o(114884);
                return true;
            }
        }
        if (message.what == xHm || (VERSION.SDK_INT == 28 && message.what == 160)) {
            if (C5115h.xGJ.size() > 0) {
                xHr = true;
            }
            C5115h.m7780g("WxSplash.SplashHackHandlerCallback", "received a RELAUNCH_ACTIVITY message, with %s splash activity", Integer.valueOf(C5115h.xGJ.size()));
            Object obj = message.obj;
            if (C1443d.m3069iX(25)) {
                try {
                    if (C5120l.xHA == null) {
                        Field declaredField = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("mPreserveWindow");
                        declaredField.setAccessible(true);
                        C5120l.xHA = declaredField;
                    }
                    C5115h.m7780g("WxSplash.SplashHackHandlerCallback", "preserveWindow is %s, will set false", Boolean.valueOf(((Boolean) C5120l.xHA.get(obj)).booleanValue()));
                    C5120l.xHA.set(obj, Boolean.FALSE);
                } catch (Exception e) {
                    C5115h.m7773a(e, "");
                }
            }
        }
        if (this.oUK != null) {
            this.xHq = true;
            boolean handleMessage = this.oUK.handleMessage(message);
            this.xHq = false;
            AppMethodBeat.m2505o(114884);
            return handleMessage;
        }
        AppMethodBeat.m2505o(114884);
        return false;
    }
}
