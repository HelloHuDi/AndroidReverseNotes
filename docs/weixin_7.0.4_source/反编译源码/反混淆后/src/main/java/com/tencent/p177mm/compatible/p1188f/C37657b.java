package com.tencent.p177mm.compatible.p1188f;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.lang.reflect.Method;

/* renamed from: com.tencent.mm.compatible.f.b */
public final class C37657b {
    private static Boolean euB = null;

    /* renamed from: Mi */
    public static boolean m63680Mi() {
        AppMethodBeat.m2504i(93043);
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            int i = 0;
            if (VERSION.SDK_INT == 17) {
                i = 36;
            } else if (VERSION.SDK_INT >= 19) {
                i = 27;
            }
            boolean iV = C37657b.m63685iV(i);
            AppMethodBeat.m2505o(93043);
            return iV;
        }
        AppMethodBeat.m2505o(93043);
        return true;
    }

    /* renamed from: bD */
    public static boolean m63682bD(Context context) {
        AppMethodBeat.m2504i(93044);
        if (euB == null) {
            euB = Boolean.valueOf(context == null ? false : context.getPackageManager().hasSystemFeature("org.chromium.arc.device_management"));
        }
        boolean booleanValue = euB.booleanValue();
        AppMethodBeat.m2505o(93044);
        return booleanValue;
    }

    /* renamed from: Mj */
    public static boolean m63681Mj() {
        AppMethodBeat.m2504i(93045);
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            int i = 0;
            if (VERSION.SDK_INT == 17) {
                i = 35;
            } else if (VERSION.SDK_INT >= 19) {
                i = 26;
            }
            boolean iV = C37657b.m63685iV(i);
            AppMethodBeat.m2505o(93045);
            return iV;
        }
        AppMethodBeat.m2505o(93045);
        return true;
    }

    /* renamed from: bE */
    public static void m63683bE(Context context) {
        AppMethodBeat.m2504i(93046);
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            Intent intent;
            try {
                intent = new Intent();
                intent.setClassName("com.android.settings", "com.android.settings.applications.AppsCheckReadPermission");
                context.startActivity(intent);
                AppMethodBeat.m2505o(93046);
                return;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.PermissionUtil", "unable start activity AppsCheckReadPermission");
                try {
                    intent = new Intent("android.settings.APP_OPS_SETTINGS");
                    intent.addCategory("android.intent.category.DEFAULT");
                    context.startActivity(intent);
                    AppMethodBeat.m2505o(93046);
                    return;
                } catch (Exception e2) {
                    C4990ab.m7412e("MicroMsg.PermissionUtil", "unable start activity APP_OPS_SETTINGS");
                    try {
                        intent = new Intent();
                        intent.setClassName("com.android.settings", "com.android.settings.Settings$AppControlSettingsActivity");
                        context.startActivity(intent);
                        AppMethodBeat.m2505o(93046);
                        return;
                    } catch (Exception e3) {
                        C4990ab.m7412e("MicroMsg.PermissionUtil", "unable start activity AppControlSettingsActivity");
                    }
                }
            }
        }
        AppMethodBeat.m2505o(93046);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: iV */
    private static boolean m63685iV(int i) {
        AppMethodBeat.m2504i(93047);
        if (i == 0) {
            AppMethodBeat.m2505o(93047);
            return true;
        }
        Method method;
        Object systemService = C4996ah.getContext().getSystemService("appops");
        if (systemService != null) {
            try {
                method = Class.forName("android.app.AppOpsManager").getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class});
            } catch (NoSuchMethodException e) {
                C4990ab.m7413e("MicroMsg.PermissionUtil", "onVoiceRcdStartRequest meizu NoSuchMethodException method:checkOpNoThrow! Error:%s", e.getMessage());
                method = null;
            } catch (ClassNotFoundException e2) {
                C4990ab.m7413e("MicroMsg.PermissionUtil", "ClassNotFoundException class:android.app.AppOpsManager! Error:%s", e2.getMessage());
            }
            if (method != null) {
                int intValue;
                try {
                    intValue = ((Integer) method.invoke(systemService, new Object[]{Integer.valueOf(i), Integer.valueOf(C4996ah.getContext().getApplicationInfo().uid), C4996ah.getPackageName()})).intValue();
                } catch (Exception e3) {
                    C4990ab.m7413e("MicroMsg.PermissionUtil", "invoke checkOpNoThrow Exception! Error:%s", e3.getMessage());
                    intValue = -1;
                }
                if (intValue != 0) {
                    C4990ab.m7413e("MicroMsg.PermissionUtil", "ret:%d showAlert to ask for record permission for wechat!", Integer.valueOf(intValue));
                    AppMethodBeat.m2505o(93047);
                    return false;
                }
            }
            AppMethodBeat.m2505o(93047);
            return true;
        }
        method = null;
        if (method != null) {
        }
        AppMethodBeat.m2505o(93047);
        return true;
    }

    @TargetApi(19)
    /* renamed from: bF */
    public static boolean m63684bF(Context context) {
        boolean z = true;
        AppMethodBeat.m2504i(93048);
        int i = VERSION.SDK_INT;
        boolean booleanValue;
        if (i >= 23) {
            try {
                booleanValue = ((Boolean) Settings.class.getDeclaredMethod("canDrawOverlays", new Class[]{Context.class}).invoke(null, new Object[]{context})).booleanValue();
                C4990ab.m7416i("MicroMsg.PermissionUtil", "isFloatWindowOpAllowed allowed: ".concat(String.valueOf(booleanValue)));
                AppMethodBeat.m2505o(93048);
                return booleanValue;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.PermissionUtil", "getDeclaredMethod:canDrawOverlays! Error:%s, etype:%s", e.getMessage(), e.getClass().getCanonicalName());
                AppMethodBeat.m2505o(93048);
                return true;
            }
        } else if (i >= 19) {
            Method method;
            Object systemService = C4996ah.getContext().getSystemService("appops");
            try {
                method = Class.forName("android.app.AppOpsManager").getMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class});
            } catch (NoSuchMethodException e2) {
                C4990ab.m7413e("MicroMsg.PermissionUtil", "NoSuchMethodException method:checkOp! Error:%s", e2.getMessage());
                method = null;
            } catch (ClassNotFoundException e3) {
                C4990ab.m7413e("MicroMsg.PermissionUtil", "ClassNotFoundException class:android.app.AppOpsManager! Error:%s", e3.getMessage());
                method = null;
            }
            if (method != null) {
                try {
                    if (((Integer) method.invoke(systemService, new Object[]{Integer.valueOf(24), Integer.valueOf(C4996ah.getContext().getApplicationInfo().uid), C4996ah.getPackageName()})).intValue() == 0) {
                        booleanValue = true;
                    } else {
                        booleanValue = false;
                    }
                    z = booleanValue;
                } catch (Exception e4) {
                    C4990ab.m7413e("MicroMsg.PermissionUtil", "call checkOp failed: %s etype:%s", e4.getMessage(), e4.getClass().getCanonicalName());
                }
            }
            C4990ab.m7416i("MicroMsg.PermissionUtil", "isFloatWindowOpAllowed allowed: ".concat(String.valueOf(z)));
            AppMethodBeat.m2505o(93048);
            return z;
        } else {
            AppMethodBeat.m2505o(93048);
            return true;
        }
    }
}
