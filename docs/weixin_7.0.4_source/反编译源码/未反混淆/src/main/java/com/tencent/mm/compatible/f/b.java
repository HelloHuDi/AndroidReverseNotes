package com.tencent.mm.compatible.f;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.reflect.Method;

public final class b {
    private static Boolean euB = null;

    public static boolean Mi() {
        AppMethodBeat.i(93043);
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            int i = 0;
            if (VERSION.SDK_INT == 17) {
                i = 36;
            } else if (VERSION.SDK_INT >= 19) {
                i = 27;
            }
            boolean iV = iV(i);
            AppMethodBeat.o(93043);
            return iV;
        }
        AppMethodBeat.o(93043);
        return true;
    }

    public static boolean bD(Context context) {
        AppMethodBeat.i(93044);
        if (euB == null) {
            euB = Boolean.valueOf(context == null ? false : context.getPackageManager().hasSystemFeature("org.chromium.arc.device_management"));
        }
        boolean booleanValue = euB.booleanValue();
        AppMethodBeat.o(93044);
        return booleanValue;
    }

    public static boolean Mj() {
        AppMethodBeat.i(93045);
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            int i = 0;
            if (VERSION.SDK_INT == 17) {
                i = 35;
            } else if (VERSION.SDK_INT >= 19) {
                i = 26;
            }
            boolean iV = iV(i);
            AppMethodBeat.o(93045);
            return iV;
        }
        AppMethodBeat.o(93045);
        return true;
    }

    public static void bE(Context context) {
        AppMethodBeat.i(93046);
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            Intent intent;
            try {
                intent = new Intent();
                intent.setClassName("com.android.settings", "com.android.settings.applications.AppsCheckReadPermission");
                context.startActivity(intent);
                AppMethodBeat.o(93046);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.PermissionUtil", "unable start activity AppsCheckReadPermission");
                try {
                    intent = new Intent("android.settings.APP_OPS_SETTINGS");
                    intent.addCategory("android.intent.category.DEFAULT");
                    context.startActivity(intent);
                    AppMethodBeat.o(93046);
                    return;
                } catch (Exception e2) {
                    ab.e("MicroMsg.PermissionUtil", "unable start activity APP_OPS_SETTINGS");
                    try {
                        intent = new Intent();
                        intent.setClassName("com.android.settings", "com.android.settings.Settings$AppControlSettingsActivity");
                        context.startActivity(intent);
                        AppMethodBeat.o(93046);
                        return;
                    } catch (Exception e3) {
                        ab.e("MicroMsg.PermissionUtil", "unable start activity AppControlSettingsActivity");
                    }
                }
            }
        }
        AppMethodBeat.o(93046);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean iV(int i) {
        AppMethodBeat.i(93047);
        if (i == 0) {
            AppMethodBeat.o(93047);
            return true;
        }
        Method method;
        Object systemService = ah.getContext().getSystemService("appops");
        if (systemService != null) {
            try {
                method = Class.forName("android.app.AppOpsManager").getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class});
            } catch (NoSuchMethodException e) {
                ab.e("MicroMsg.PermissionUtil", "onVoiceRcdStartRequest meizu NoSuchMethodException method:checkOpNoThrow! Error:%s", e.getMessage());
                method = null;
            } catch (ClassNotFoundException e2) {
                ab.e("MicroMsg.PermissionUtil", "ClassNotFoundException class:android.app.AppOpsManager! Error:%s", e2.getMessage());
            }
            if (method != null) {
                int intValue;
                try {
                    intValue = ((Integer) method.invoke(systemService, new Object[]{Integer.valueOf(i), Integer.valueOf(ah.getContext().getApplicationInfo().uid), ah.getPackageName()})).intValue();
                } catch (Exception e3) {
                    ab.e("MicroMsg.PermissionUtil", "invoke checkOpNoThrow Exception! Error:%s", e3.getMessage());
                    intValue = -1;
                }
                if (intValue != 0) {
                    ab.e("MicroMsg.PermissionUtil", "ret:%d showAlert to ask for record permission for wechat!", Integer.valueOf(intValue));
                    AppMethodBeat.o(93047);
                    return false;
                }
            }
            AppMethodBeat.o(93047);
            return true;
        }
        method = null;
        if (method != null) {
        }
        AppMethodBeat.o(93047);
        return true;
    }

    @TargetApi(19)
    public static boolean bF(Context context) {
        boolean z = true;
        AppMethodBeat.i(93048);
        int i = VERSION.SDK_INT;
        boolean booleanValue;
        if (i >= 23) {
            try {
                booleanValue = ((Boolean) Settings.class.getDeclaredMethod("canDrawOverlays", new Class[]{Context.class}).invoke(null, new Object[]{context})).booleanValue();
                ab.i("MicroMsg.PermissionUtil", "isFloatWindowOpAllowed allowed: ".concat(String.valueOf(booleanValue)));
                AppMethodBeat.o(93048);
                return booleanValue;
            } catch (Exception e) {
                ab.e("MicroMsg.PermissionUtil", "getDeclaredMethod:canDrawOverlays! Error:%s, etype:%s", e.getMessage(), e.getClass().getCanonicalName());
                AppMethodBeat.o(93048);
                return true;
            }
        } else if (i >= 19) {
            Method method;
            Object systemService = ah.getContext().getSystemService("appops");
            try {
                method = Class.forName("android.app.AppOpsManager").getMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class});
            } catch (NoSuchMethodException e2) {
                ab.e("MicroMsg.PermissionUtil", "NoSuchMethodException method:checkOp! Error:%s", e2.getMessage());
                method = null;
            } catch (ClassNotFoundException e3) {
                ab.e("MicroMsg.PermissionUtil", "ClassNotFoundException class:android.app.AppOpsManager! Error:%s", e3.getMessage());
                method = null;
            }
            if (method != null) {
                try {
                    if (((Integer) method.invoke(systemService, new Object[]{Integer.valueOf(24), Integer.valueOf(ah.getContext().getApplicationInfo().uid), ah.getPackageName()})).intValue() == 0) {
                        booleanValue = true;
                    } else {
                        booleanValue = false;
                    }
                    z = booleanValue;
                } catch (Exception e4) {
                    ab.e("MicroMsg.PermissionUtil", "call checkOp failed: %s etype:%s", e4.getMessage(), e4.getClass().getCanonicalName());
                }
            }
            ab.i("MicroMsg.PermissionUtil", "isFloatWindowOpAllowed allowed: ".concat(String.valueOf(z)));
            AppMethodBeat.o(93048);
            return z;
        } else {
            AppMethodBeat.o(93048);
            return true;
        }
    }
}
