package com.tencent.p177mm.sdk.p603e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* renamed from: com.tencent.mm.sdk.e.a */
public final class C4894a {
    private String filePath;
    private Properties xCY;

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d A:{SYNTHETIC, Splitter:B:15:0x005d} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080 A:{SYNTHETIC, Splitter:B:23:0x0080} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C4894a(String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(52485);
        this.xCY = null;
        this.filePath = null;
        this.xCY = new Properties();
        this.filePath = str;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                this.xCY.load(fileInputStream);
                try {
                    fileInputStream.close();
                    AppMethodBeat.m2505o(52485);
                } catch (IOException e2) {
                    C4990ab.m7413e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e2.getLocalizedMessage());
                    AppMethodBeat.m2505o(52485);
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.m7413e("MicroMsg.ReadConfig", "Read File: %s Failed. [%s]", str, e.getLocalizedMessage());
                    if (fileInputStream == null) {
                        try {
                            fileInputStream.close();
                            AppMethodBeat.m2505o(52485);
                            return;
                        } catch (IOException e22) {
                            C4990ab.m7413e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e22.getLocalizedMessage());
                            AppMethodBeat.m2505o(52485);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(52485);
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            C4990ab.m7413e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e4.getLocalizedMessage());
                        }
                    }
                    AppMethodBeat.m2505o(52485);
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
            C4990ab.m7413e("MicroMsg.ReadConfig", "Read File: %s Failed. [%s]", str, e.getLocalizedMessage());
            if (fileInputStream == null) {
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            AppMethodBeat.m2505o(52485);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0079 A:{SYNTHETIC, Splitter:B:24:0x0079} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058 A:{SYNTHETIC, Splitter:B:16:0x0058} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: hV */
    public final boolean mo10097hV(String str, String str2) {
        Exception e;
        Throwable th;
        boolean z = true;
        AppMethodBeat.m2504i(52486);
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(this.filePath);
            try {
                this.xCY.setProperty(str, str2);
                this.xCY.store(fileOutputStream, "");
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    C4990ab.m7413e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e2.getLocalizedMessage());
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.m7413e("MicroMsg.ReadConfig", "Write File: %s Failed. [%s]", this.filePath, e.getLocalizedMessage());
                    if (fileOutputStream == null) {
                    }
                    AppMethodBeat.m2505o(52486);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(52486);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            C4990ab.m7413e("MicroMsg.ReadConfig", "Write File: %s Failed. [%s]", this.filePath, e.getLocalizedMessage());
            if (fileOutputStream == null) {
                try {
                    fileOutputStream.close();
                    z = false;
                } catch (IOException e22) {
                    C4990ab.m7413e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e22.getLocalizedMessage());
                    z = false;
                }
            } else {
                z = false;
            }
            AppMethodBeat.m2505o(52486);
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    C4990ab.m7413e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e5.getLocalizedMessage());
                }
            }
            AppMethodBeat.m2505o(52486);
            throw th;
        }
        AppMethodBeat.m2505o(52486);
        return z;
    }

    /* renamed from: aK */
    public final boolean mo10092aK(String str, long j) {
        AppMethodBeat.m2504i(52487);
        boolean hV = mo10097hV(str, String.valueOf(j));
        AppMethodBeat.m2505o(52487);
        return hV;
    }

    /* renamed from: ej */
    public final boolean mo10095ej(String str, int i) {
        AppMethodBeat.m2504i(52488);
        boolean hV = mo10097hV(str, String.valueOf(i));
        AppMethodBeat.m2505o(52488);
        return hV;
    }

    public final String getValue(String str) {
        AppMethodBeat.m2504i(52489);
        if (this.xCY == null || !this.xCY.containsKey(str)) {
            AppMethodBeat.m2505o(52489);
            return null;
        }
        String property = this.xCY.getProperty(str);
        AppMethodBeat.m2505o(52489);
        return property;
    }

    public final Long anD(String str) {
        Long l = null;
        AppMethodBeat.m2504i(52490);
        String value = getValue(str);
        if (value == null) {
            AppMethodBeat.m2505o(52490);
        } else {
            try {
                l = Long.valueOf(Long.parseLong(value));
                AppMethodBeat.m2505o(52490);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ReadConfig", "getLongValue ParseLong : %s Failed. [%s]", value, e.getLocalizedMessage());
                AppMethodBeat.m2505o(52490);
            }
        }
        return l;
    }

    public final Integer anE(String str) {
        Integer num = null;
        AppMethodBeat.m2504i(52491);
        String value = getValue(str);
        if (value == null) {
            AppMethodBeat.m2505o(52491);
        } else {
            try {
                num = Integer.valueOf(Integer.parseInt(value));
                AppMethodBeat.m2505o(52491);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ReadConfig", "getIntegerValue ParseInteger : %s Failed. [%s]", value, e.getLocalizedMessage());
                AppMethodBeat.m2505o(52491);
            }
        }
        return num;
    }

    public static String getValue(String str, String str2) {
        AppMethodBeat.m2504i(52492);
        String value = new C4894a(str).getValue(str2);
        AppMethodBeat.m2505o(52492);
        return value;
    }

    /* renamed from: hW */
    public static Long m7287hW(String str, String str2) {
        AppMethodBeat.m2504i(52493);
        Long anD = new C4894a(str).anD(str2);
        AppMethodBeat.m2505o(52493);
        return anD;
    }

    /* renamed from: aB */
    public static boolean m7286aB(String str, String str2, String str3) {
        AppMethodBeat.m2504i(52494);
        boolean hV = new C4894a(str).mo10097hV(str2, str3);
        AppMethodBeat.m2505o(52494);
        return hV;
    }

    /* renamed from: p */
    public static boolean m7289p(String str, String str2, long j) {
        AppMethodBeat.m2504i(52495);
        boolean aK = new C4894a(str).mo10092aK(str2, j);
        AppMethodBeat.m2505o(52495);
        return aK;
    }

    /* renamed from: hX */
    public static boolean m7288hX(String str, String str2) {
        AppMethodBeat.m2504i(52496);
        boolean ej = new C4894a(str).mo10095ej(str2, 0);
        AppMethodBeat.m2505o(52496);
        return ej;
    }
}
