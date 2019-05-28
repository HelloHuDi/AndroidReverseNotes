package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Debug;
import android.os.DropBoxManager;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.Utility;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

public final class CrashUtils {
    private static final String[] zzzc = new String[]{"android.", "com.android.", "dalvik.", "java.", "javax."};
    private static DropBoxManager zzzd = null;
    private static boolean zzze = false;
    private static boolean zzzf;
    private static boolean zzzg;
    private static int zzzh = -1;
    @GuardedBy("CrashUtils.class")
    private static int zzzi = 0;
    @GuardedBy("CrashUtils.class")
    private static int zzzj = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorDialogData {
        public static final int AVG_CRASH_FREQ = 2;
        public static final int BINDER_CRASH = 268435456;
        public static final int DYNAMITE_CRASH = 536870912;
        public static final int FORCED_SHUSHED_BY_WRAPPER = 4;
        public static final int NONE = 0;
        public static final int POPUP_FREQ = 1;
        public static final int SUPPRESSED = 1073741824;
    }

    public static boolean addDynamiteErrorToDropBox(Context context, Throwable th) {
        AppMethodBeat.m2504i(90135);
        boolean addErrorToDropBoxInternal = addErrorToDropBoxInternal(context, th, 536870912);
        AppMethodBeat.m2505o(90135);
        return addErrorToDropBoxInternal;
    }

    @Deprecated
    public static boolean addErrorToDropBox(Context context, Throwable th) {
        AppMethodBeat.m2504i(90136);
        boolean addDynamiteErrorToDropBox = addDynamiteErrorToDropBox(context, th);
        AppMethodBeat.m2505o(90136);
        return addDynamiteErrorToDropBox;
    }

    public static boolean addErrorToDropBoxInternal(Context context, String str, String str2, int i) {
        AppMethodBeat.m2504i(90138);
        boolean zza = zza(context, str, str2, i, null);
        AppMethodBeat.m2505o(90138);
        return zza;
    }

    public static boolean addErrorToDropBoxInternal(Context context, Throwable th, int i) {
        boolean zzdb;
        boolean z = false;
        AppMethodBeat.m2504i(90137);
        try {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(th);
            if (isPackageSide()) {
                if (!zzdb()) {
                    th = zza(th);
                    if (th == null) {
                        AppMethodBeat.m2505o(90137);
                    }
                }
                z = zza(context, Log.getStackTraceString(th), ProcessUtils.getMyProcessName(), i, th);
                AppMethodBeat.m2505o(90137);
            } else {
                AppMethodBeat.m2505o(90137);
            }
        } catch (Exception e) {
            try {
                zzdb = zzdb();
            } catch (Exception e2) {
                zzdb = z;
            }
            if (zzdb) {
                AppMethodBeat.m2505o(90137);
                throw e;
            }
            AppMethodBeat.m2505o(90137);
        }
        return z;
    }

    private static boolean isPackageSide() {
        return zzze ? zzzf : false;
    }

    public static boolean isSystemClassPrefixInternal(String str) {
        AppMethodBeat.m2504i(90140);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(90140);
            return false;
        }
        for (String startsWith : zzzc) {
            if (str.startsWith(startsWith)) {
                AppMethodBeat.m2505o(90140);
                return true;
            }
        }
        AppMethodBeat.m2505o(90140);
        return false;
    }

    @VisibleForTesting
    public static synchronized void setTestVariables(DropBoxManager dropBoxManager, boolean z, boolean z2, int i) {
        synchronized (CrashUtils.class) {
            zzze = true;
            zzzd = dropBoxManager;
            zzzg = z;
            zzzf = z2;
            zzzh = i;
            zzzi = 0;
            zzzj = 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x01b2 A:{SYNTHETIC, Splitter:B:69:0x01b2} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01ad A:{Splitter:B:42:0x016b, ExcHandler: all (r0_43 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01ad A:{Splitter:B:42:0x016b, ExcHandler: all (r0_43 'th' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:66:0x01ad, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:67:0x01ae, code skipped:
            r2 = r0;
            r3 = null;
     */
    /* JADX WARNING: Missing block: B:70:?, code skipped:
            r3.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @VisibleForTesting
    private static synchronized String zza(Context context, String str, String str2, int i) {
        String str3;
        synchronized (CrashUtils.class) {
            int i2;
            AppMethodBeat.m2504i(90142);
            StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            stringBuilder.append("Process: ").append(Strings.nullToEmpty(str2)).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("Package: com.google.android.gms");
            int i3 = 12451009;
            str3 = "12.4.51 (020308-{{cl}})";
            if (zzdb()) {
                try {
                    PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0);
                    i3 = packageInfo.versionCode;
                    if (packageInfo.versionName != null) {
                        str3 = packageInfo.versionName;
                    }
                } catch (Exception e) {
                }
            }
            stringBuilder.append(" v").append(i3);
            if (!TextUtils.isEmpty(str3)) {
                if (str3.contains("(") && !str3.contains(")")) {
                    Object concat;
                    if (str3.endsWith("-")) {
                        concat = String.valueOf(str3).concat("111111111");
                    }
                    str3 = String.valueOf(concat).concat(")");
                }
                stringBuilder.append(" (").append(str3).append(")");
            }
            stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("Build: ").append(Build.FINGERPRINT).append(IOUtils.LINE_SEPARATOR_UNIX);
            if (Debug.isDebuggerConnected()) {
                stringBuilder.append("Debugger: Connected\n");
            }
            if (i != 0) {
                stringBuilder.append("DD-EDD: ").append(i).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            if (!TextUtils.isEmpty(str)) {
                stringBuilder.append(str);
            }
            if (zzdb()) {
                i2 = zzzh >= 0 ? zzzh : Secure.getInt(context.getContentResolver(), "logcat_for_system_app_crash", 0);
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
                InputStreamReader inputStreamReader;
                try {
                    Process start = new ProcessBuilder(new String[]{"/system/bin/logcat", "-v", "time", "-b", "events", "-b", "system", "-b", "main", "-b", AppMeasurement.CRASH_ORIGIN, "-t", String.valueOf(i2)}).redirectErrorStream(true).start();
                    try {
                        start.getOutputStream().close();
                    } catch (IOException e2) {
                    } catch (Throwable th) {
                    }
                    try {
                        start.getErrorStream().close();
                    } catch (IOException e3) {
                    } catch (Throwable th2) {
                    }
                    inputStreamReader = new InputStreamReader(start.getInputStream());
                    try {
                        char[] cArr = new char[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                        while (true) {
                            int read = inputStreamReader.read(cArr);
                            if (read > 0) {
                                stringBuilder.append(cArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (IOException e4) {
                                }
                            }
                        }
                        inputStreamReader.close();
                    } catch (IOException e5) {
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e6) {
                            }
                        }
                        str3 = stringBuilder.toString();
                        AppMethodBeat.m2505o(90142);
                        return str3;
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        InputStreamReader inputStreamReader2 = inputStreamReader;
                        if (inputStreamReader2 != null) {
                        }
                        AppMethodBeat.m2505o(90142);
                        throw th4;
                    }
                } catch (IOException e7) {
                    inputStreamReader = null;
                } catch (Throwable th22) {
                }
            }
            str3 = stringBuilder.toString();
            AppMethodBeat.m2505o(90142);
        }
        return str3;
    }

    @VisibleForTesting
    private static synchronized Throwable zza(Throwable th) {
        Throwable th2;
        synchronized (CrashUtils.class) {
            AppMethodBeat.m2504i(90141);
            LinkedList linkedList = new LinkedList();
            Object th3;
            while (th3 != null) {
                linkedList.push(th3);
                th3 = th3.getCause();
            }
            Throwable th4 = null;
            int i = 0;
            while (!linkedList.isEmpty()) {
                th2 = (Throwable) linkedList.pop();
                StackTraceElement[] stackTrace = th2.getStackTrace();
                ArrayList arrayList = new ArrayList();
                arrayList.add(new StackTraceElement(th2.getClass().getName(), "<filtered>", "<filtered>", 1));
                int i2 = i;
                for (Object obj : stackTrace) {
                    Object obj2;
                    String className = obj2.getClassName();
                    String fileName = obj2.getFileName();
                    i = (TextUtils.isEmpty(fileName) || !fileName.startsWith(":com.google.android.gms")) ? 0 : 1;
                    i2 |= i;
                    if (i == 0 && !isSystemClassPrefixInternal(className)) {
                        obj2 = new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1);
                    }
                    arrayList.add(obj2);
                }
                th4 = th4 == null ? new Throwable("<filtered>") : new Throwable("<filtered>", th4);
                th4.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                i = i2;
            }
            if (i == 0) {
                th2 = null;
                AppMethodBeat.m2505o(90141);
            } else {
                AppMethodBeat.m2505o(90141);
                th2 = th4;
            }
        }
        return th2;
    }

    private static synchronized boolean zza(Context context, String str, String str2, int i, Throwable th) {
        boolean z;
        synchronized (CrashUtils.class) {
            AppMethodBeat.m2504i(90139);
            Preconditions.checkNotNull(context);
            if (!isPackageSide() || Strings.isEmptyOrWhitespace(str)) {
                AppMethodBeat.m2505o(90139);
                z = false;
            } else {
                int hashCode = str.hashCode();
                int hashCode2 = th == null ? zzzj : th.hashCode();
                if (zzzi == hashCode && zzzj == hashCode2) {
                    AppMethodBeat.m2505o(90139);
                    z = false;
                } else {
                    zzzi = hashCode;
                    zzzj = hashCode2;
                    DropBoxManager dropBoxManager = zzzd != null ? zzzd : (DropBoxManager) context.getSystemService("dropbox");
                    if (dropBoxManager == null || !dropBoxManager.isTagEnabled("system_app_crash")) {
                        AppMethodBeat.m2505o(90139);
                        z = false;
                    } else {
                        dropBoxManager.addText("system_app_crash", zza(context, str, str2, i));
                        z = true;
                        AppMethodBeat.m2505o(90139);
                    }
                }
            }
        }
        return z;
    }

    private static boolean zzdb() {
        return zzze ? zzzg : false;
    }
}
