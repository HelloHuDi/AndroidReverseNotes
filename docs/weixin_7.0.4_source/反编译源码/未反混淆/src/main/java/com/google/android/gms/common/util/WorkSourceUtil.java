package com.google.android.gms.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkSourceUtil {
    public static final String TAG = "WorkSourceUtil";
    private static final int zzaam = Process.myUid();
    private static final Method zzaan = zzdf();
    private static final Method zzaao = zzdg();
    private static final Method zzaap = zzdh();
    private static final Method zzaaq = zzdi();
    private static final Method zzaar = zzdj();
    private static final Method zzaas = zzdk();
    private static final Method zzaat = zzdl();

    static {
        AppMethodBeat.i(90297);
        AppMethodBeat.o(90297);
    }

    private WorkSourceUtil() {
    }

    public static void add(WorkSource workSource, int i, String str) {
        AppMethodBeat.i(90282);
        if (zzaao != null) {
            if (str == null) {
                str = "";
            }
            try {
                zzaao.invoke(workSource, new Object[]{Integer.valueOf(i), str});
                AppMethodBeat.o(90282);
                return;
            } catch (Exception e) {
                Log.wtf(TAG, "Unable to assign blame through WorkSource", e);
                AppMethodBeat.o(90282);
                return;
            }
        }
        if (zzaan != null) {
            try {
                zzaan.invoke(workSource, new Object[]{Integer.valueOf(i)});
                AppMethodBeat.o(90282);
                return;
            } catch (Exception e2) {
                Log.wtf(TAG, "Unable to assign blame through WorkSource", e2);
            }
        }
        AppMethodBeat.o(90282);
    }

    public static WorkSource fromPackage(Context context, String str) {
        AppMethodBeat.i(90281);
        if (context == null || context.getPackageManager() == null || str == null) {
            AppMethodBeat.o(90281);
            return null;
        }
        String str2;
        String valueOf;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                str2 = "Could not get applicationInfo from package: ";
                valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    str2.concat(valueOf);
                } else {
                    valueOf = new String(str2);
                }
                AppMethodBeat.o(90281);
                return null;
            }
            WorkSource fromUidAndPackage = fromUidAndPackage(applicationInfo.uid, str);
            AppMethodBeat.o(90281);
            return fromUidAndPackage;
        } catch (NameNotFoundException e) {
            str2 = "Could not find package: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2.concat(valueOf);
            } else {
                valueOf = new String(str2);
            }
            AppMethodBeat.o(90281);
            return null;
        }
    }

    public static WorkSource fromPackageAndModuleExperimentalPi(Context context, String str, String str2) {
        WorkSource workSource = null;
        AppMethodBeat.i(90283);
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            AppMethodBeat.o(90283);
        } else {
            int zzc = zzc(context, str);
            if (zzc < 0) {
                AppMethodBeat.o(90283);
            } else {
                workSource = new WorkSource();
                if (zzaas == null || zzaat == null) {
                    add(workSource, zzc, str);
                } else {
                    try {
                        Object invoke = zzaas.invoke(workSource, new Object[0]);
                        if (zzc != zzaam) {
                            zzaat.invoke(invoke, new Object[]{Integer.valueOf(zzc), str});
                        }
                        zzaat.invoke(invoke, new Object[]{Integer.valueOf(zzaam), str2});
                    } catch (Exception e) {
                    }
                }
                AppMethodBeat.o(90283);
            }
        }
        return workSource;
    }

    public static WorkSource fromUidAndPackage(int i, String str) {
        AppMethodBeat.i(90280);
        WorkSource workSource = new WorkSource();
        add(workSource, i, str);
        AppMethodBeat.o(90280);
        return workSource;
    }

    public static int get(WorkSource workSource, int i) {
        AppMethodBeat.i(90285);
        if (zzaaq != null) {
            try {
                int intValue = ((Integer) zzaaq.invoke(workSource, new Object[]{Integer.valueOf(i)})).intValue();
                AppMethodBeat.o(90285);
                return intValue;
            } catch (Exception e) {
                Log.wtf(TAG, "Unable to assign blame through WorkSource", e);
            }
        }
        AppMethodBeat.o(90285);
        return 0;
    }

    public static String getName(WorkSource workSource, int i) {
        AppMethodBeat.i(90286);
        if (zzaar != null) {
            try {
                String str = (String) zzaar.invoke(workSource, new Object[]{Integer.valueOf(i)});
                AppMethodBeat.o(90286);
                return str;
            } catch (Exception e) {
                Log.wtf(TAG, "Unable to assign blame through WorkSource", e);
            }
        }
        AppMethodBeat.o(90286);
        return null;
    }

    public static List<String> getNames(WorkSource workSource) {
        int i = 0;
        AppMethodBeat.i(90287);
        int size = workSource == null ? 0 : size(workSource);
        if (size == 0) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(90287);
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        while (i < size) {
            String name = getName(workSource, i);
            if (!Strings.isEmptyOrWhitespace(name)) {
                arrayList.add(name);
            }
            i++;
        }
        AppMethodBeat.o(90287);
        return arrayList;
    }

    public static boolean hasWorkSourcePermission(Context context) {
        AppMethodBeat.i(90288);
        if (context == null) {
            AppMethodBeat.o(90288);
            return false;
        } else if (context.getPackageManager() == null) {
            AppMethodBeat.o(90288);
            return false;
        } else if (Wrappers.packageManager(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0) {
            AppMethodBeat.o(90288);
            return true;
        } else {
            AppMethodBeat.o(90288);
            return false;
        }
    }

    public static int size(WorkSource workSource) {
        AppMethodBeat.i(90284);
        if (zzaap != null) {
            try {
                int intValue = ((Integer) zzaap.invoke(workSource, new Object[0])).intValue();
                AppMethodBeat.o(90284);
                return intValue;
            } catch (Exception e) {
                Log.wtf(TAG, "Unable to assign blame through WorkSource", e);
            }
        }
        AppMethodBeat.o(90284);
        return 0;
    }

    private static int zzc(Context context, String str) {
        AppMethodBeat.i(90289);
        String str2;
        String valueOf;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                str2 = "Could not get applicationInfo from package: ";
                valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    str2.concat(valueOf);
                } else {
                    valueOf = new String(str2);
                }
                AppMethodBeat.o(90289);
                return -1;
            }
            int i = applicationInfo.uid;
            AppMethodBeat.o(90289);
            return i;
        } catch (NameNotFoundException e) {
            str2 = "Could not find package: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2.concat(valueOf);
            } else {
                valueOf = new String(str2);
            }
            AppMethodBeat.o(90289);
            return -1;
        }
    }

    private static Method zzdf() {
        AppMethodBeat.i(90290);
        Method method = null;
        try {
            method = WorkSource.class.getMethod("add", new Class[]{Integer.TYPE});
        } catch (Exception e) {
        }
        AppMethodBeat.o(90290);
        return method;
    }

    private static Method zzdg() {
        AppMethodBeat.i(90291);
        Method method = null;
        if (PlatformVersion.isAtLeastJellyBeanMR2()) {
            try {
                method = WorkSource.class.getMethod("add", new Class[]{Integer.TYPE, String.class});
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(90291);
        return method;
    }

    private static Method zzdh() {
        AppMethodBeat.i(90292);
        Method method = null;
        try {
            method = WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e) {
        }
        AppMethodBeat.o(90292);
        return method;
    }

    private static Method zzdi() {
        AppMethodBeat.i(90293);
        Method method = null;
        try {
            method = WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception e) {
        }
        AppMethodBeat.o(90293);
        return method;
    }

    private static Method zzdj() {
        AppMethodBeat.i(90294);
        Method method = null;
        if (PlatformVersion.isAtLeastJellyBeanMR2()) {
            try {
                method = WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(90294);
        return method;
    }

    private static final Method zzdk() {
        AppMethodBeat.i(90295);
        Method method = null;
        if (PlatformVersion.isAtLeastP()) {
            try {
                method = WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(90295);
        return method;
    }

    @SuppressLint({"PrivateApi"})
    private static final Method zzdl() {
        AppMethodBeat.i(90296);
        Method method = null;
        if (PlatformVersion.isAtLeastP()) {
            try {
                method = Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", new Class[]{Integer.TYPE, String.class});
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(90296);
        return method;
    }
}
