package com.tencent.p177mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.app.C1246e;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1737l;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5059g;

/* renamed from: com.tencent.mm.booter.b */
public final class C1324b {
    /* renamed from: c */
    public static boolean m2837c(Context context, String str, boolean z) {
        int i;
        AppMethodBeat.m2504i(57744);
        while (true) {
            if ((str.equals("noop") && (!C5059g.xyf || !C5059g.xye)) || !C1737l.m3591bL(context)) {
                C4990ab.m7417i("MicroMsg.CoreServiceHelper", "ensure service running, type=%s ifRepeat=%s", str, Boolean.valueOf(z));
                Intent intent = new Intent(context, CoreService.class);
                intent.setFlags(268435456);
                intent.putExtra("START_TYPE", str);
                if (!C45270c.m83434Ij()) {
                    C4990ab.m7416i("MicroMsg.CoreServiceHelper", "ensureServiceInstance() startService");
                    Object i2 = null;
                    Object obj = null;
                    try {
                        context.startService(intent);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.CoreServiceHelper", "ensureServiceInstance() Exception = %s, Detail = %s SDK_INT = %s", e.getClass().toString(), e.getMessage(), Integer.valueOf(VERSION.SDK_INT));
                        if (e instanceof IllegalStateException) {
                            obj = 1;
                        }
                        if (C1443d.m3068iW(26)) {
                            C5018as amF = C5018as.amF("service_launch_way");
                            boolean bn = C45270c.m83435bn(context);
                            if (amF.getBoolean("service_first_crash", true)) {
                                C4990ab.m7417i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=true result=%s", Boolean.valueOf(bn));
                                amF.edit().putBoolean("service_first_crash", false).commit();
                                C7053e.pXa.mo8378a(954, 80, 1, false);
                                if (e instanceof IllegalStateException) {
                                    C45270c.m83436bu(false);
                                    amF.edit().putBoolean("service_IllegalStateException", true).commit();
                                    C7053e.pXa.mo8378a(954, 81, 1, false);
                                    if (bn) {
                                        C7053e.pXa.mo8378a(954, 82, 1, false);
                                        i2 = 1;
                                    } else {
                                        amF.edit().putBoolean("crash_not_ignore", true).commit();
                                        C7053e.pXa.mo8378a(954, 83, 1, false);
                                        i2 = 1;
                                    }
                                } else {
                                    C7053e.pXa.mo8378a(954, 86, 1, false);
                                    i2 = 1;
                                }
                            } else {
                                C4990ab.m7417i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false result=%s", Boolean.valueOf(bn));
                                if (e instanceof IllegalStateException) {
                                    C45270c.m83436bu(false);
                                    if (amF.getBoolean("service_IllegalStateException", false)) {
                                        C4990ab.m7416i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false service_IllegalStateException=true");
                                    } else {
                                        C4990ab.m7416i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false service_IllegalStateException=false");
                                        amF.edit().putBoolean("service_IllegalStateException", true).commit();
                                        C7053e.pXa.mo8378a(954, 87, 1, false);
                                        if (bn) {
                                            C7053e.pXa.mo8378a(954, 82, 1, false);
                                            i2 = 1;
                                        } else {
                                            amF.edit().putBoolean("crash_not_ignore", true).commit();
                                            C7053e.pXa.mo8378a(954, 83, 1, false);
                                            i2 = 1;
                                        }
                                    }
                                }
                            }
                        }
                        i2 = 1;
                    }
                    if (!C1443d.m3068iW(26)) {
                        break;
                    }
                    if (C1443d.m3068iW(26)) {
                        C4990ab.m7417i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService crash_not_ignore=%s service_IllegalStateException=%s", Boolean.valueOf(C5018as.amF("service_launch_way").getBoolean("crash_not_ignore", false)), Boolean.valueOf(C45270c.m83435bn(context)));
                        if (C5018as.amF("service_launch_way").getBoolean("crash_not_ignore", false) && C45270c.m83435bn(context) && i2 == null) {
                            C5018as.amF("service_launch_way").edit().putBoolean("crash_not_ignore", false);
                            C7053e.pXa.mo8378a(954, 85, 1, false);
                        }
                    }
                    if (obj == null) {
                        break;
                    } else if (z) {
                        z = false;
                    } else {
                        AppMethodBeat.m2505o(57744);
                        return false;
                    }
                }
                C4990ab.m7416i("MicroMsg.CoreServiceHelper", "ensureServiceInstance() bindService");
                C4996ah.getContext().bindService(intent, new C1246e(), 1);
                break;
            }
            C4990ab.m7416i("MicroMsg.CoreServiceHelper", "fully exited, no need to start service");
            AppMethodBeat.m2505o(57744);
            return false;
        }
        C4990ab.m7417i("MicroMsg.CoreServiceUtil", "if_26_num=%s  if_ignore_false=%s  ignore_true=%s", Boolean.valueOf(C5018as.amF("service_launch_way").getBoolean("if_26_num", true)), Boolean.valueOf(C5018as.amF("service_launch_way").getBoolean("if_ignore_false", true)), Boolean.valueOf(C5018as.amF("service_launch_way").getBoolean("ignore_true", false)));
        if (C1443d.m3068iW(26) && C5018as.amF("service_launch_way").getBoolean("if_26_num", true)) {
            C5018as.amF("service_launch_way").edit().putBoolean("if_26_num", false).commit();
            C7053e.pXa.mo8378a(954, 92, 1, false);
        }
        if (C1443d.m3068iW(26)) {
            if (C45270c.m83435bn(context)) {
                C5018as.amF("service_launch_way").edit().putBoolean("ignore_true", true).commit();
            } else if (C5018as.amF("service_launch_way").getBoolean("if_ignore_false", true)) {
                C5018as.amF("service_launch_way").edit().putBoolean("if_ignore_false", false).commit();
                C7053e.pXa.mo8378a(954, 90, 1, false);
                if (C5018as.amF("service_launch_way").getBoolean("ignore_true", false)) {
                    C7053e.pXa.mo8378a(954, 91, 1, false);
                }
            }
        }
        AppMethodBeat.m2505o(57744);
        return true;
    }

    /* renamed from: bm */
    public static void m2836bm(Context context) {
        AppMethodBeat.m2504i(57745);
        if (C45270c.m83434Ij()) {
            C1246e.m2684Bc();
            AppMethodBeat.m2505o(57745);
            return;
        }
        try {
            context.stopService(new Intent(context, CoreService.class));
            AppMethodBeat.m2505o(57745);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.CoreServiceHelper", "stopServiceInstance() Exception:%s", e.getMessage());
            AppMethodBeat.m2505o(57745);
        }
    }
}
