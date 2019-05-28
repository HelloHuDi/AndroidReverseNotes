package com.tencent.mm.sdk.h;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public final class b {
    private static Boolean evF = null;
    private static Boolean evG = null;
    private static Boolean xES = null;
    private static Boolean xET = null;
    private static Boolean xEU = null;

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0055 A:{SYNTHETIC, Splitter:B:16:0x0055} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f A:{SYNTHETIC, Splitter:B:22:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean Ms() {
        Exception e;
        boolean booleanValue;
        Throwable th;
        AppMethodBeat.i(65368);
        if (evF == null) {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    evF = Boolean.valueOf(properties.containsKey("ro.miui.ui.version.name"));
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        ab.e("Vendor.MIUI", "e = %s, ** failed to fetch miui prop, assume we are not on miui. **", e);
                        evF = Boolean.FALSE;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        booleanValue = evF.booleanValue();
                        AppMethodBeat.o(65368);
                        return booleanValue;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(65368);
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                fileInputStream = null;
                ab.e("Vendor.MIUI", "e = %s, ** failed to fetch miui prop, assume we are not on miui. **", e);
                evF = Boolean.FALSE;
                if (fileInputStream != null) {
                }
                booleanValue = evF.booleanValue();
                AppMethodBeat.o(65368);
                return booleanValue;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e6) {
                    }
                }
                AppMethodBeat.o(65368);
                throw th;
            }
        }
        booleanValue = evF.booleanValue();
        AppMethodBeat.o(65368);
        return booleanValue;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0078 A:{SYNTHETIC, Splitter:B:16:0x0078} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0082 A:{SYNTHETIC, Splitter:B:22:0x0082} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean Mt() {
        Exception e;
        boolean booleanValue;
        Throwable th;
        AppMethodBeat.i(65369);
        if (evG == null) {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    ab.e("Vendor.MIUI", "ro.miui.ui.version.name %s", properties.getProperty("ro.miui.ui.version.name", ""));
                    evG = Boolean.valueOf(properties.getProperty("ro.miui.ui.version.name", "").contains("V8"));
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        ab.e("Vendor.MIUI", "e = %s, ** failed to fetch miui prop, assume we are not on miui. **", e);
                        evG = Boolean.FALSE;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        booleanValue = evG.booleanValue();
                        AppMethodBeat.o(65369);
                        return booleanValue;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(65369);
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                fileInputStream = null;
                ab.e("Vendor.MIUI", "e = %s, ** failed to fetch miui prop, assume we are not on miui. **", e);
                evG = Boolean.FALSE;
                if (fileInputStream != null) {
                }
                booleanValue = evG.booleanValue();
                AppMethodBeat.o(65369);
                return booleanValue;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e6) {
                    }
                }
                AppMethodBeat.o(65369);
                throw th;
            }
        }
        booleanValue = evG.booleanValue();
        AppMethodBeat.o(65369);
        return booleanValue;
    }

    public static boolean dqv() {
        AppMethodBeat.i(65370);
        if (xES == null) {
            String str = Build.MANUFACTURER;
            ab.i("Vendor.MIUI", "Build.MANUFACTURER = %s", str);
            if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("Xiaomi")) {
                xES = Boolean.FALSE;
            } else if (bo.isEqual(com.tencent.mm.compatible.e.ab.get("ro.miui.ui.version.code"), "8")) {
                xES = Boolean.TRUE;
            } else {
                xES = Boolean.FALSE;
            }
        }
        boolean booleanValue = xES.booleanValue();
        AppMethodBeat.o(65370);
        return booleanValue;
    }

    public static boolean dqw() {
        AppMethodBeat.i(65371);
        if (xET == null) {
            String str = Build.MANUFACTURER;
            ab.i("Vendor.MIUI", "Build.MANUFACTURER = %s", str);
            if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("Xiaomi")) {
                xET = Boolean.FALSE;
            } else {
                xET = Boolean.TRUE;
            }
        }
        boolean booleanValue = xET.booleanValue();
        AppMethodBeat.o(65371);
        return booleanValue;
    }

    public static boolean dqx() {
        AppMethodBeat.i(65372);
        if (xEU == null) {
            String str = Build.MANUFACTURER;
            ab.i("Vendor.MIUI", "Build.MANUFACTURER = %s, Build.MODEL = %s", str, Build.MODEL);
            if (TextUtils.isEmpty(str) || !str.equals("Xiaomi")) {
                xEU = Boolean.FALSE;
            } else {
                ab.w("Vendor.MIUI", "ifNotificationChannelSupportNativeActionJump() versionCode:%s", getSystemProperty("ro.miui.version.code_time"));
                if (Long.valueOf(getSystemProperty("ro.miui.version.code_time")).longValue() > Long.valueOf("1536681600").longValue()) {
                    xEU = Boolean.TRUE;
                } else {
                    xEU = Boolean.FALSE;
                }
            }
        }
        ab.i("Vendor.MIUI", "ifNotificationChannelSupportNativeActionJump() ifNotificationChannelSupportNativeActionJump:%s", Boolean.valueOf(xEU.booleanValue()));
        boolean booleanValue = xEU.booleanValue();
        AppMethodBeat.o(65372);
        return booleanValue;
    }

    /* JADX WARNING: Missing block: B:9:0x002b, code skipped:
            if (r2 == false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean g(int i, String str, String str2, String str3) {
        boolean z = true;
        AppMethodBeat.i(65373);
        if (i >= Integer.parseInt(str)) {
            if (bo.isEqual(str2, "")) {
                if (dqw()) {
                    String systemProperty = getSystemProperty("ro.miui.version.code_time");
                    boolean z2;
                    if (bo.isNullOrNil(str3)) {
                        z2 = true;
                    } else if (Long.valueOf(systemProperty).longValue() < Long.valueOf(str3).longValue()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
            } else if (i > Integer.parseInt(str2)) {
                z = false;
            }
            AppMethodBeat.o(65373);
            return z;
        }
        z = false;
        AppMethodBeat.o(65373);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0067 A:{SYNTHETIC, Splitter:B:15:0x0067} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085 A:{SYNTHETIC, Splitter:B:22:0x0085} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String getSystemProperty(String str) {
        IOException e;
        Throwable th;
        BufferedReader bufferedReader = null;
        AppMethodBeat.i(65374);
        BufferedReader bufferedReader2;
        try {
            bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            try {
                String readLine = bufferedReader2.readLine();
                bufferedReader2.close();
                try {
                    bufferedReader2.close();
                } catch (IOException e2) {
                    ab.i("Vendor.MIUI", "Exception while closing InputStream : %s", e2.getMessage());
                }
                AppMethodBeat.o(65374);
                return readLine;
            } catch (IOException e3) {
                e = e3;
                try {
                    ab.i("Vendor.MIUI", "Unable to read sysprop %s Exception:%s", str, e.getMessage());
                    if (bufferedReader2 != null) {
                    }
                    AppMethodBeat.o(65374);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    AppMethodBeat.o(65374);
                    throw th;
                }
            }
        } catch (IOException e4) {
            e = e4;
            bufferedReader2 = null;
            ab.i("Vendor.MIUI", "Unable to read sysprop %s Exception:%s", str, e.getMessage());
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e5) {
                    ab.i("Vendor.MIUI", "Exception while closing InputStream : %s", e5.getMessage());
                }
            }
            AppMethodBeat.o(65374);
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e22) {
                    ab.i("Vendor.MIUI", "Exception while closing InputStream : %s", e22.getMessage());
                }
            }
            AppMethodBeat.o(65374);
            throw th;
        }
    }
}
