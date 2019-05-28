package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.g;

public final class b {
    public static boolean c(Context context, String str, boolean z) {
        int i;
        AppMethodBeat.i(57744);
        while (true) {
            if ((str.equals("noop") && (!g.xyf || !g.xye)) || !l.bL(context)) {
                ab.i("MicroMsg.CoreServiceHelper", "ensure service running, type=%s ifRepeat=%s", str, Boolean.valueOf(z));
                Intent intent = new Intent(context, CoreService.class);
                intent.setFlags(268435456);
                intent.putExtra("START_TYPE", str);
                if (!c.Ij()) {
                    ab.i("MicroMsg.CoreServiceHelper", "ensureServiceInstance() startService");
                    Object i2 = null;
                    Object obj = null;
                    try {
                        context.startService(intent);
                    } catch (Exception e) {
                        ab.e("MicroMsg.CoreServiceHelper", "ensureServiceInstance() Exception = %s, Detail = %s SDK_INT = %s", e.getClass().toString(), e.getMessage(), Integer.valueOf(VERSION.SDK_INT));
                        if (e instanceof IllegalStateException) {
                            obj = 1;
                        }
                        if (d.iW(26)) {
                            as amF = as.amF("service_launch_way");
                            boolean bn = c.bn(context);
                            if (amF.getBoolean("service_first_crash", true)) {
                                ab.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=true result=%s", Boolean.valueOf(bn));
                                amF.edit().putBoolean("service_first_crash", false).commit();
                                e.pXa.a(954, 80, 1, false);
                                if (e instanceof IllegalStateException) {
                                    c.bu(false);
                                    amF.edit().putBoolean("service_IllegalStateException", true).commit();
                                    e.pXa.a(954, 81, 1, false);
                                    if (bn) {
                                        e.pXa.a(954, 82, 1, false);
                                        i2 = 1;
                                    } else {
                                        amF.edit().putBoolean("crash_not_ignore", true).commit();
                                        e.pXa.a(954, 83, 1, false);
                                        i2 = 1;
                                    }
                                } else {
                                    e.pXa.a(954, 86, 1, false);
                                    i2 = 1;
                                }
                            } else {
                                ab.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false result=%s", Boolean.valueOf(bn));
                                if (e instanceof IllegalStateException) {
                                    c.bu(false);
                                    if (amF.getBoolean("service_IllegalStateException", false)) {
                                        ab.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false service_IllegalStateException=true");
                                    } else {
                                        ab.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false service_IllegalStateException=false");
                                        amF.edit().putBoolean("service_IllegalStateException", true).commit();
                                        e.pXa.a(954, 87, 1, false);
                                        if (bn) {
                                            e.pXa.a(954, 82, 1, false);
                                            i2 = 1;
                                        } else {
                                            amF.edit().putBoolean("crash_not_ignore", true).commit();
                                            e.pXa.a(954, 83, 1, false);
                                            i2 = 1;
                                        }
                                    }
                                }
                            }
                        }
                        i2 = 1;
                    }
                    if (!d.iW(26)) {
                        break;
                    }
                    if (d.iW(26)) {
                        ab.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService crash_not_ignore=%s service_IllegalStateException=%s", Boolean.valueOf(as.amF("service_launch_way").getBoolean("crash_not_ignore", false)), Boolean.valueOf(c.bn(context)));
                        if (as.amF("service_launch_way").getBoolean("crash_not_ignore", false) && c.bn(context) && i2 == null) {
                            as.amF("service_launch_way").edit().putBoolean("crash_not_ignore", false);
                            e.pXa.a(954, 85, 1, false);
                        }
                    }
                    if (obj == null) {
                        break;
                    } else if (z) {
                        z = false;
                    } else {
                        AppMethodBeat.o(57744);
                        return false;
                    }
                }
                ab.i("MicroMsg.CoreServiceHelper", "ensureServiceInstance() bindService");
                ah.getContext().bindService(intent, new com.tencent.mm.app.e(), 1);
                break;
            }
            ab.i("MicroMsg.CoreServiceHelper", "fully exited, no need to start service");
            AppMethodBeat.o(57744);
            return false;
        }
        ab.i("MicroMsg.CoreServiceUtil", "if_26_num=%s  if_ignore_false=%s  ignore_true=%s", Boolean.valueOf(as.amF("service_launch_way").getBoolean("if_26_num", true)), Boolean.valueOf(as.amF("service_launch_way").getBoolean("if_ignore_false", true)), Boolean.valueOf(as.amF("service_launch_way").getBoolean("ignore_true", false)));
        if (d.iW(26) && as.amF("service_launch_way").getBoolean("if_26_num", true)) {
            as.amF("service_launch_way").edit().putBoolean("if_26_num", false).commit();
            e.pXa.a(954, 92, 1, false);
        }
        if (d.iW(26)) {
            if (c.bn(context)) {
                as.amF("service_launch_way").edit().putBoolean("ignore_true", true).commit();
            } else if (as.amF("service_launch_way").getBoolean("if_ignore_false", true)) {
                as.amF("service_launch_way").edit().putBoolean("if_ignore_false", false).commit();
                e.pXa.a(954, 90, 1, false);
                if (as.amF("service_launch_way").getBoolean("ignore_true", false)) {
                    e.pXa.a(954, 91, 1, false);
                }
            }
        }
        AppMethodBeat.o(57744);
        return true;
    }

    public static void bm(Context context) {
        AppMethodBeat.i(57745);
        if (c.Ij()) {
            com.tencent.mm.app.e.Bc();
            AppMethodBeat.o(57745);
            return;
        }
        try {
            context.stopService(new Intent(context, CoreService.class));
            AppMethodBeat.o(57745);
        } catch (Exception e) {
            ab.e("MicroMsg.CoreServiceHelper", "stopServiceInstance() Exception:%s", e.getMessage());
            AppMethodBeat.o(57745);
        }
    }
}
