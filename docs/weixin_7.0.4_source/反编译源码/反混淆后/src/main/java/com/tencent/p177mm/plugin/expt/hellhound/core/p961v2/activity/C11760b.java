package com.tencent.p177mm.plugin.expt.hellhound.core.p961v2.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.expt.hellhound.core.p1258a.C45900a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.core.v2.activity.b */
final class C11760b implements InvocationHandler {
    static boolean lME = true;
    static int lMF = 0;
    Object lMB;
    private Method lMC;
    private C34077d lMD;

    @SuppressLint({"PrivateApi"})
    C11760b(C34077d c34077d) {
        AppMethodBeat.m2504i(73392);
        this.lMD = c34077d;
        try {
            this.lMC = C45900a.bqr().getDeclaredMethod("getActivity", new Class[]{IBinder.class});
            this.lMC.setAccessible(true);
            AppMethodBeat.m2505o(73392);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("ActivityHijack", e, "ActivityHijack", new Object[0]);
            C7060h.pYm.mo8378a(932, 2, 1, false);
            AppMethodBeat.m2505o(73392);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x013d A:{Catch:{ Exception -> 0x016b }} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0190 A:{Catch:{ Exception -> 0x01de }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        AppMethodBeat.m2504i(73393);
        String name = method.getName();
        try {
            Object c;
            if ("moveActivityTaskToBack".equals(name)) {
                boolean booleanValue;
                Activity o = m19580o(objArr);
                for (Object c2 : objArr) {
                    if (c2 != null && (c2 instanceof Boolean)) {
                        booleanValue = ((Boolean) c2).booleanValue();
                        break;
                    }
                }
                booleanValue = false;
                this.lMD.mo23546a(o, booleanValue);
            } else if ("finishActivity".equals(name)) {
                this.lMD.mo23540F(m19580o(objArr));
            } else if ("getIntentForIntentSender".equals(name)) {
                c2 = m19578c(method, objArr);
                AppMethodBeat.m2505o(73393);
                return c2;
            }
            try {
                c2 = method.invoke(this.lMB, objArr);
                AppMethodBeat.m2505o(73393);
                return c2;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("ActivityHijack", e, "AHijack.invoke-new", new Object[0]);
                C7060h.pYm.mo8378a(932, 63, 1, false);
                if ("isTopOfTask".equals(name)) {
                    Boolean bool;
                    try {
                        bool = (Boolean) method.invoke(this.lMB, objArr);
                        lME = bool.booleanValue();
                        C4990ab.m7410d("ActivityHijack", "AHijack:isTopOfTask: " + lME);
                        AppMethodBeat.m2505o(73393);
                        return bool;
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace("ActivityHijack", e2, "AHijack:isTopOfTask-e1 crash", new Object[0]);
                        C7060h.pYm.mo8378a(932, 80, 1, false);
                        try {
                            Activity o2 = m19580o(objArr);
                            if (o2 != null) {
                                Method declaredMethod = Activity.class.getDeclaredMethod("isTopOfTask", new Class[0]);
                                declaredMethod.setAccessible(true);
                                bool = (Boolean) declaredMethod.invoke(o2, new Object[0]);
                                lME = bool.booleanValue();
                                AppMethodBeat.m2505o(73393);
                                return bool;
                            }
                        } catch (Exception e22) {
                            C4990ab.printErrStackTrace("ActivityHijack", e22, "AHijack:isTopOfTask-e2 crash", new Object[0]);
                            C7060h.pYm.mo8378a(932, 85, 1, false);
                            lME = true;
                        }
                        if ("startActivity".equals(name)) {
                            Integer num = (Integer) method.invoke(this.lMB, objArr);
                            lMF = num.intValue();
                            C4990ab.m7410d("ActivityHijack", "AHijack:startActivityRet: " + lMF);
                            AppMethodBeat.m2505o(73393);
                            return num;
                        }
                        if ("broadcastIntent".equals(name)) {
                            C7060h.pYm.mo8378a(932, 64, 1, false);
                            C4990ab.m7416i("ActivityHijack", "handleSonyBroadcastIntent Build.MODEL / Build.BRAND: " + Build.MODEL + " / " + Build.BRAND);
                            Intent n = C11760b.m19579n(objArr);
                            if (n == null) {
                                C4990ab.m7410d("ActivityHijack", "handleSonyBroadcastIntent intent == null");
                                c2 = method.invoke(this.lMB, objArr);
                                AppMethodBeat.m2505o(73393);
                                return c2;
                            }
                            String action = n.getAction();
                            C4990ab.m7410d("ActivityHijack", "handleSonyBroadcastIntent action = ".concat(String.valueOf(action)));
                            if ("com.sonymobile.media.AUDIO_MODE_CHANGED_ACTION".equals(action)) {
                                C4990ab.m7412e("ActivityHijack", "Sony-Phone, What the fuck !!!");
                                c2 = Integer.valueOf(0);
                                AppMethodBeat.m2505o(73393);
                                return c2;
                            }
                            c2 = method.invoke(this.lMB, objArr);
                            AppMethodBeat.m2505o(73393);
                            return c2;
                        }
                        c2 = method.invoke(this.lMB, objArr);
                        AppMethodBeat.m2505o(73393);
                        return c2;
                    }
                }
                try {
                    if ("startActivity".equals(name)) {
                    }
                } catch (Exception e222) {
                    C4990ab.printErrStackTrace("ActivityHijack", e222, "AHijack:startActivity crash-3", new Object[0]);
                    C7060h.pYm.mo8378a(932, 86, 1, false);
                    lMF = 0;
                }
                try {
                    if ("broadcastIntent".equals(name)) {
                    }
                } catch (Exception e2222) {
                    C4990ab.printErrStackTrace("ActivityHijack", e2222, "AHijack.broadcastIntent", new Object[0]);
                    C7060h.pYm.mo8378a(932, 65, 1, false);
                }
                c2 = method.invoke(this.lMB, objArr);
                AppMethodBeat.m2505o(73393);
                return c2;
            }
        } catch (Exception e22222) {
            C4990ab.printErrStackTrace("ActivityHijack", e22222, "AHijack.invoke-method", new Object[0]);
            C7060h.pYm.mo8378a(932, 0, 1, false);
        }
    }

    /* renamed from: c */
    private Intent m19578c(Method method, Object[] objArr) {
        Intent intent;
        AppMethodBeat.m2504i(73394);
        try {
            Object invoke = method.invoke(this.lMB, objArr);
            if (invoke instanceof Intent) {
                intent = (Intent) invoke;
                AppMethodBeat.m2505o(73394);
                return intent;
            }
        } catch (Exception e) {
            C4990ab.m7417i("ActivityHijack", "AHijack: getIntentForIntentSender: %s", C5046bo.dpG());
            C7060h.pYm.mo8378a(932, 96, 1, false);
        }
        C7060h.pYm.mo8378a(932, 97, 1, false);
        intent = new Intent();
        AppMethodBeat.m2505o(73394);
        return intent;
    }

    /* renamed from: n */
    private static Intent m19579n(Object[] objArr) {
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

    /* renamed from: o */
    private Activity m19580o(Object[] objArr) {
        int i = 0;
        AppMethodBeat.m2504i(73395);
        if (objArr == null || objArr.length <= 0) {
            AppMethodBeat.m2505o(73395);
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
            AppMethodBeat.m2505o(73395);
            return null;
        }
        Activity activity;
        try {
            Object bqq = C45900a.bqq();
            activity = (Activity) this.lMC.invoke(bqq, new Object[]{iBinder});
        } catch (Exception e) {
            activity = null;
        }
        AppMethodBeat.m2505o(73395);
        return activity;
    }
}
