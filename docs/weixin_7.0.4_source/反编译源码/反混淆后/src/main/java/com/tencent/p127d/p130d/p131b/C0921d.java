package com.tencent.p127d.p130d.p131b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.tencent.d.d.b.d */
public final class C0921d {

    /* renamed from: com.tencent.d.d.b.d$a */
    public static class C0922a {
        public int Atj;
        public String Atk;
        public String name = "";
        public int pid;
        public int uid;

        C0922a(int i, int i2, String str, int i3, String str2) {
            this.pid = i;
            this.Atj = i2;
            this.name = str;
            this.uid = i3;
            this.Atk = str2;
        }

        public final String toString() {
            AppMethodBeat.m2504i(114522);
            String str = "PID=" + this.pid + " PPID=" + this.Atj + " NAME=" + this.name + " UID=" + this.uid + " CONTEXT=" + this.Atk;
            AppMethodBeat.m2505o(114522);
            return str;
        }
    }

    public static List<C0922a> dQo() {
        AppMethodBeat.m2504i(114523);
        ArrayList arrayList = new ArrayList();
        String[] list = new File("/proc").list();
        if (list == null) {
            AppMethodBeat.m2505o(114523);
        } else {
            for (CharSequence charSequence : list) {
                if (!TextUtils.isEmpty(charSequence)) {
                    try {
                        char charAt = charSequence.charAt(0);
                        if (charAt <= '9' && charAt >= '0') {
                            C0922a Rc = C0921d.m2092Rc(Integer.parseInt(charSequence));
                            if (Rc != null) {
                                arrayList.add(Rc);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
            AppMethodBeat.m2505o(114523);
        }
        return arrayList;
    }

    /* renamed from: Rb */
    private static String m2091Rb(int i) {
        AppMethodBeat.m2504i(114524);
        String str;
        try {
            str = "";
            byte[] eO = C37317a.m62719eO(String.format(Locale.ENGLISH, "/proc/%d/cmdline", new Object[]{Integer.valueOf(i)}), 100);
            if (eO != null) {
                str = new String(eO, 0, C0921d.m2093a(eO, 0, 0));
            }
            if (TextUtils.isEmpty(str)) {
                eO = C37317a.m62719eO(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[]{Integer.valueOf(i)}), 150);
                if (eO != null) {
                    int a = C0921d.m2093a(eO, 7, 10);
                    if (a == 0) {
                        str = "";
                        AppMethodBeat.m2505o(114524);
                        return str;
                    }
                    str = new String(eO, 6, a - 6);
                }
            }
            AppMethodBeat.m2505o(114524);
            return str;
        } catch (Throwable th) {
            str = "";
            AppMethodBeat.m2505o(114524);
            return str;
        }
    }

    /* renamed from: a */
    private static int m2093a(byte[] bArr, int i, char c) {
        int i2 = i - 1;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= bArr.length) {
                return 0;
            }
            if (i3 == bArr.length || bArr[i3] == c) {
                return i3;
            }
            i2 = i3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a2 A:{SKIP} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Rc */
    private static C0922a m2092Rc(int i) {
        String Rb;
        String trim;
        AppMethodBeat.m2504i(114525);
        int a;
        try {
            Rb = C0921d.m2091Rb(i);
            int i2;
            try {
                int parseInt;
                byte[] eO = C37317a.m62719eO(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[]{Integer.valueOf(i)}), 150);
                if (eO != null) {
                    a = C0921d.m2093a(eO, 7, 10);
                    if (a != 0) {
                        a = C0921d.m2093a(eO, C0921d.m2093a(eO, C0921d.m2093a(eO, a + 1, 10) + 1, 10) + 1, 10);
                        if (a != 0) {
                            i2 = a + 7;
                            int a2 = C0921d.m2093a(eO, a + 1, 10);
                            if (a2 != 0) {
                                a = Integer.parseInt(new String(eO, i2, a2 - i2));
                                try {
                                    i2 = C0921d.m2093a(eO, a2 + 1, 10);
                                    if (i2 != 0) {
                                        i2 += 6;
                                        parseInt = Integer.parseInt(new String(eO, i2, C0921d.m2093a(eO, i2 + 1, 9) - i2));
                                    } else {
                                        parseInt = -1;
                                    }
                                    i2 = parseInt;
                                } catch (Exception e) {
                                    i2 = -1;
                                    trim = new String(C37317a.atR(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                                    if (Rb != null) {
                                    }
                                    AppMethodBeat.m2505o(114525);
                                    return null;
                                }
                                trim = new String(C37317a.atR(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                                if (Rb != null || a == -1 || i2 == -1) {
                                    AppMethodBeat.m2505o(114525);
                                    return null;
                                }
                                C0922a c0922a = new C0922a(i, a, Rb, i2, trim);
                                AppMethodBeat.m2505o(114525);
                                return c0922a;
                            }
                        }
                    }
                }
                parseInt = -1;
                a = -1;
                i2 = parseInt;
            } catch (Exception e2) {
                a = -1;
                i2 = -1;
                trim = new String(C37317a.atR(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                if (Rb != null) {
                }
                AppMethodBeat.m2505o(114525);
                return null;
            }
        } catch (Exception e3) {
            a = -1;
            Rb = null;
        }
        try {
            trim = new String(C37317a.atR(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
        } catch (Exception e4) {
            trim = null;
        }
        if (Rb != null) {
        }
        AppMethodBeat.m2505o(114525);
        return null;
    }
}
