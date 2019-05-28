package com.tencent.mm.plugin.expt.hellhound.core.v2.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class b implements InvocationHandler {
    static boolean lME = true;
    static int lMF = 0;
    Object lMB;
    private Method lMC;
    private d lMD;

    @SuppressLint({"PrivateApi"})
    b(d dVar) {
        AppMethodBeat.i(73392);
        this.lMD = dVar;
        try {
            this.lMC = a.bqr().getDeclaredMethod("getActivity", new Class[]{IBinder.class});
            this.lMC.setAccessible(true);
            AppMethodBeat.o(73392);
        } catch (Exception e) {
            ab.printErrStackTrace("ActivityHijack", e, "ActivityHijack", new Object[0]);
            h.pYm.a(932, 2, 1, false);
            AppMethodBeat.o(73392);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x013d A:{Catch:{ Exception -> 0x016b }} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0190 A:{Catch:{ Exception -> 0x01de }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        AppMethodBeat.i(73393);
        String name = method.getName();
        try {
            Object c;
            if ("moveActivityTaskToBack".equals(name)) {
                boolean booleanValue;
                Activity o = o(objArr);
                for (Object c2 : objArr) {
                    if (c2 != null && (c2 instanceof Boolean)) {
                        booleanValue = ((Boolean) c2).booleanValue();
                        break;
                    }
                }
                booleanValue = false;
                this.lMD.a(o, booleanValue);
            } else if ("finishActivity".equals(name)) {
                this.lMD.F(o(objArr));
            } else if ("getIntentForIntentSender".equals(name)) {
                c2 = c(method, objArr);
                AppMethodBeat.o(73393);
                return c2;
            }
            try {
                c2 = method.invoke(this.lMB, objArr);
                AppMethodBeat.o(73393);
                return c2;
            } catch (Exception e) {
                ab.printErrStackTrace("ActivityHijack", e, "AHijack.invoke-new", new Object[0]);
                h.pYm.a(932, 63, 1, false);
                if ("isTopOfTask".equals(name)) {
                    Boolean bool;
                    try {
                        bool = (Boolean) method.invoke(this.lMB, objArr);
                        lME = bool.booleanValue();
                        ab.d("ActivityHijack", "AHijack:isTopOfTask: " + lME);
                        AppMethodBeat.o(73393);
                        return bool;
                    } catch (Exception e2) {
                        ab.printErrStackTrace("ActivityHijack", e2, "AHijack:isTopOfTask-e1 crash", new Object[0]);
                        h.pYm.a(932, 80, 1, false);
                        try {
                            Activity o2 = o(objArr);
                            if (o2 != null) {
                                Method declaredMethod = Activity.class.getDeclaredMethod("isTopOfTask", new Class[0]);
                                declaredMethod.setAccessible(true);
                                bool = (Boolean) declaredMethod.invoke(o2, new Object[0]);
                                lME = bool.booleanValue();
                                AppMethodBeat.o(73393);
                                return bool;
                            }
                        } catch (Exception e22) {
                            ab.printErrStackTrace("ActivityHijack", e22, "AHijack:isTopOfTask-e2 crash", new Object[0]);
                            h.pYm.a(932, 85, 1, false);
                            lME = true;
                        }
                        if ("startActivity".equals(name)) {
                            Integer num = (Integer) method.invoke(this.lMB, objArr);
                            lMF = num.intValue();
                            ab.d("ActivityHijack", "AHijack:startActivityRet: " + lMF);
                            AppMethodBeat.o(73393);
                            return num;
                        }
                        if ("broadcastIntent".equals(name)) {
                            h.pYm.a(932, 64, 1, false);
                            ab.i("ActivityHijack", "handleSonyBroadcastIntent Build.MODEL / Build.BRAND: " + Build.MODEL + " / " + Build.BRAND);
                            Intent n = n(objArr);
                            if (n == null) {
                                ab.d("ActivityHijack", "handleSonyBroadcastIntent intent == null");
                                c2 = method.invoke(this.lMB, objArr);
                                AppMethodBeat.o(73393);
                                return c2;
                            }
                            String action = n.getAction();
                            ab.d("ActivityHijack", "handleSonyBroadcastIntent action = ".concat(String.valueOf(action)));
                            if ("com.sonymobile.media.AUDIO_MODE_CHANGED_ACTION".equals(action)) {
                                ab.e("ActivityHijack", "Sony-Phone, What the fuck !!!");
                                c2 = Integer.valueOf(0);
                                AppMethodBeat.o(73393);
                                return c2;
                            }
                            c2 = method.invoke(this.lMB, objArr);
                            AppMethodBeat.o(73393);
                            return c2;
                        }
                        c2 = method.invoke(this.lMB, objArr);
                        AppMethodBeat.o(73393);
                        return c2;
                    }
                }
                try {
                    if ("startActivity".equals(name)) {
                    }
                } catch (Exception e222) {
                    ab.printErrStackTrace("ActivityHijack", e222, "AHijack:startActivity crash-3", new Object[0]);
                    h.pYm.a(932, 86, 1, false);
                    lMF = 0;
                }
                try {
                    if ("broadcastIntent".equals(name)) {
                    }
                } catch (Exception e2222) {
                    ab.printErrStackTrace("ActivityHijack", e2222, "AHijack.broadcastIntent", new Object[0]);
                    h.pYm.a(932, 65, 1, false);
                }
                c2 = method.invoke(this.lMB, objArr);
                AppMethodBeat.o(73393);
                return c2;
            }
        } catch (Exception e22222) {
            ab.printErrStackTrace("ActivityHijack", e22222, "AHijack.invoke-method", new Object[0]);
            h.pYm.a(932, 0, 1, false);
        }
    }

    private Intent c(Method method, Object[] objArr) {
        Intent intent;
        AppMethodBeat.i(73394);
        try {
            Object invoke = method.invoke(this.lMB, objArr);
            if (invoke instanceof Intent) {
                intent = (Intent) invoke;
                AppMethodBeat.o(73394);
                return intent;
            }
        } catch (Exception e) {
            ab.i("ActivityHijack", "AHijack: getIntentForIntentSender: %s", bo.dpG());
            h.pYm.a(932, 96, 1, false);
        }
        h.pYm.a(932, 97, 1, false);
        intent = new Intent();
        AppMethodBeat.o(73394);
        return intent;
    }

    private static Intent n(Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        int i = 0;
        while (i < objArr.length) {
            if (objArr[i] != null && (objArr[i] instanceof Intent)) {
                return (Intent) objArr[i];
            }
            i++;
        }
        return null;
    }

    private Activity o(Object[] objArr) {
        int i = 0;
        AppMethodBeat.i(73395);
        if (objArr == null || objArr.length <= 0) {
            AppMethodBeat.o(73395);
            return null;
        }
        IBinder iBinder;
        while (i < objArr.length) {
            if (objArr[i] != null && (objArr[i] instanceof IBinder)) {
                iBinder = (IBinder) objArr[i];
                break;
            }
            i++;
        }
        iBinder = null;
        if (iBinder == null) {
            AppMethodBeat.o(73395);
            return null;
        }
        Activity activity;
        try {
            Object bqq = a.bqq();
            activity = (Activity) this.lMC.invoke(bqq, new Object[]{iBinder});
        } catch (Exception e) {
            activity = null;
        }
        AppMethodBeat.o(73395);
        return activity;
    }
}
