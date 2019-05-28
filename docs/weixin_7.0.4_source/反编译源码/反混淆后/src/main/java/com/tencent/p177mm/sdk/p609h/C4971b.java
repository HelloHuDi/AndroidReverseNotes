package com.tencent.p177mm.sdk.p609h;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1414ab;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/* renamed from: com.tencent.mm.sdk.h.b */
public final class C4971b {
    private static Boolean evF = null;
    private static Boolean evG = null;
    private static Boolean xES = null;
    private static Boolean xET = null;
    private static Boolean xEU = null;

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0055 A:{SYNTHETIC, Splitter:B:16:0x0055} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f A:{SYNTHETIC, Splitter:B:22:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Ms */
    public static boolean m7363Ms() {
        Exception e;
        boolean booleanValue;
        Throwable th;
        AppMethodBeat.m2504i(65368);
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
                        C4990ab.m7413e("Vendor.MIUI", "e = %s, ** failed to fetch miui prop, assume we are not on miui. **", e);
                        evF = Boolean.FALSE;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        booleanValue = evF.booleanValue();
                        AppMethodBeat.m2505o(65368);
                        return booleanValue;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(65368);
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                fileInputStream = null;
                C4990ab.m7413e("Vendor.MIUI", "e = %s, ** failed to fetch miui prop, assume we are not on miui. **", e);
                evF = Boolean.FALSE;
                if (fileInputStream != null) {
                }
                booleanValue = evF.booleanValue();
                AppMethodBeat.m2505o(65368);
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
                AppMethodBeat.m2505o(65368);
                throw th;
            }
        }
        booleanValue = evF.booleanValue();
        AppMethodBeat.m2505o(65368);
        return booleanValue;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0078 A:{SYNTHETIC, Splitter:B:16:0x0078} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0082 A:{SYNTHETIC, Splitter:B:22:0x0082} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Mt */
    public static boolean m7364Mt() {
        Exception e;
        boolean booleanValue;
        Throwable th;
        AppMethodBeat.m2504i(65369);
        if (evG == null) {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    C4990ab.m7413e("Vendor.MIUI", "ro.miui.ui.version.name %s", properties.getProperty("ro.miui.ui.version.name", ""));
                    evG = Boolean.valueOf(properties.getProperty("ro.miui.ui.version.name", "").contains("V8"));
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        C4990ab.m7413e("Vendor.MIUI", "e = %s, ** failed to fetch miui prop, assume we are not on miui. **", e);
                        evG = Boolean.FALSE;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        booleanValue = evG.booleanValue();
                        AppMethodBeat.m2505o(65369);
                        return booleanValue;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(65369);
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                fileInputStream = null;
                C4990ab.m7413e("Vendor.MIUI", "e = %s, ** failed to fetch miui prop, assume we are not on miui. **", e);
                evG = Boolean.FALSE;
                if (fileInputStream != null) {
                }
                booleanValue = evG.booleanValue();
                AppMethodBeat.m2505o(65369);
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
                AppMethodBeat.m2505o(65369);
                throw th;
            }
        }
        booleanValue = evG.booleanValue();
        AppMethodBeat.m2505o(65369);
        return booleanValue;
    }

    public static boolean dqv() {
        AppMethodBeat.m2504i(65370);
        if (xES == null) {
            String str = Build.MANUFACTURER;
            C4990ab.m7417i("Vendor.MIUI", "Build.MANUFACTURER = %s", str);
            if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("Xiaomi")) {
                xES = Boolean.FALSE;
            } else if (C5046bo.isEqual(C1414ab.get("ro.miui.ui.version.code"), "8")) {
                xES = Boolean.TRUE;
            } else {
                xES = Boolean.FALSE;
            }
        }
        boolean booleanValue = xES.booleanValue();
        AppMethodBeat.m2505o(65370);
        return booleanValue;
    }

    public static boolean dqw() {
        AppMethodBeat.m2504i(65371);
        if (xET == null) {
            String str = Build.MANUFACTURER;
            C4990ab.m7417i("Vendor.MIUI", "Build.MANUFACTURER = %s", str);
            if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("Xiaomi")) {
                xET = Boolean.FALSE;
            } else {
                xET = Boolean.TRUE;
            }
        }
        boolean booleanValue = xET.booleanValue();
        AppMethodBeat.m2505o(65371);
        return booleanValue;
    }

    public static boolean dqx() {
        AppMethodBeat.m2504i(65372);
        if (xEU == null) {
            String str = Build.MANUFACTURER;
            C4990ab.m7417i("Vendor.MIUI", "Build.MANUFACTURER = %s, Build.MODEL = %s", str, Build.MODEL);
            if (TextUtils.isEmpty(str) || !str.equals("Xiaomi")) {
                xEU = Boolean.FALSE;
            } else {
                C4990ab.m7421w("Vendor.MIUI", "ifNotificationChannelSupportNativeActionJump() versionCode:%s", C4971b.getSystemProperty("ro.miui.version.code_time"));
                if (Long.valueOf(C4971b.getSystemProperty("ro.miui.version.code_time")).longValue() > Long.valueOf("1536681600").longValue()) {
                    xEU = Boolean.TRUE;
                } else {
                    xEU = Boolean.FALSE;
                }
            }
        }
        C4990ab.m7417i("Vendor.MIUI", "ifNotificationChannelSupportNativeActionJump() ifNotificationChannelSupportNativeActionJump:%s", Boolean.valueOf(xEU.booleanValue()));
        boolean booleanValue = xEU.booleanValue();
        AppMethodBeat.m2505o(65372);
        return booleanValue;
    }

    /* JADX WARNING: Missing block: B:9:0x002b, code skipped:
            if (r2 == false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    public static boolean m7365g(int i, String str, String str2, String str3) {
        boolean z = true;
        AppMethodBeat.m2504i(65373);
        if (i >= Integer.parseInt(str)) {
            if (C5046bo.isEqual(str2, "")) {
                if (C4971b.dqw()) {
                    String systemProperty = C4971b.getSystemProperty("ro.miui.version.code_time");
                    boolean z2;
                    if (C5046bo.isNullOrNil(str3)) {
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
            AppMethodBeat.m2505o(65373);
            return z;
        }
        z = false;
        AppMethodBeat.m2505o(65373);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0067 A:{SYNTHETIC, Splitter:B:15:0x0067} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085 A:{SYNTHETIC, Splitter:B:22:0x0085} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String getSystemProperty(String str) {
        IOException e;
        Throwable th;
        BufferedReader bufferedReader = null;
        AppMethodBeat.m2504i(65374);
        BufferedReader bufferedReader2;
        try {
            bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            try {
                String readLine = bufferedReader2.readLine();
                bufferedReader2.close();
                try {
                    bufferedReader2.close();
                } catch (IOException e2) {
                    C4990ab.m7417i("Vendor.MIUI", "Exception while closing InputStream : %s", e2.getMessage());
                }
                AppMethodBeat.m2505o(65374);
                return readLine;
            } catch (IOException e3) {
                e = e3;
                try {
                    C4990ab.m7417i("Vendor.MIUI", "Unable to read sysprop %s Exception:%s", str, e.getMessage());
                    if (bufferedReader2 != null) {
                    }
                    AppMethodBeat.m2505o(65374);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    AppMethodBeat.m2505o(65374);
                    throw th;
                }
            }
        } catch (IOException e4) {
            e = e4;
            bufferedReader2 = null;
            C4990ab.m7417i("Vendor.MIUI", "Unable to read sysprop %s Exception:%s", str, e.getMessage());
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e5) {
                    C4990ab.m7417i("Vendor.MIUI", "Exception while closing InputStream : %s", e5.getMessage());
                }
            }
            AppMethodBeat.m2505o(65374);
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e22) {
                    C4990ab.m7417i("Vendor.MIUI", "Exception while closing InputStream : %s", e22.getMessage());
                }
            }
            AppMethodBeat.m2505o(65374);
            throw th;
        }
    }
}
