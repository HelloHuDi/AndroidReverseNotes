package com.tencent.d.d.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class d {

    public static class a {
        public int Atj;
        public String Atk;
        public String name = "";
        public int pid;
        public int uid;

        a(int i, int i2, String str, int i3, String str2) {
            this.pid = i;
            this.Atj = i2;
            this.name = str;
            this.uid = i3;
            this.Atk = str2;
        }

        public final String toString() {
            AppMethodBeat.i(114522);
            String str = "PID=" + this.pid + " PPID=" + this.Atj + " NAME=" + this.name + " UID=" + this.uid + " CONTEXT=" + this.Atk;
            AppMethodBeat.o(114522);
            return str;
        }
    }

    public static List<a> dQo() {
        AppMethodBeat.i(114523);
        ArrayList arrayList = new ArrayList();
        String[] list = new File("/proc").list();
        if (list == null) {
            AppMethodBeat.o(114523);
        } else {
            for (CharSequence charSequence : list) {
                if (!TextUtils.isEmpty(charSequence)) {
                    try {
                        char charAt = charSequence.charAt(0);
                        if (charAt <= '9' && charAt >= '0') {
                            a Rc = Rc(Integer.parseInt(charSequence));
                            if (Rc != null) {
                                arrayList.add(Rc);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
            AppMethodBeat.o(114523);
        }
        return arrayList;
    }

    private static String Rb(int i) {
        AppMethodBeat.i(114524);
        String str;
        try {
            str = "";
            byte[] eO = a.eO(String.format(Locale.ENGLISH, "/proc/%d/cmdline", new Object[]{Integer.valueOf(i)}), 100);
            if (eO != null) {
                str = new String(eO, 0, a(eO, 0, 0));
            }
            if (TextUtils.isEmpty(str)) {
                eO = a.eO(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[]{Integer.valueOf(i)}), 150);
                if (eO != null) {
                    int a = a(eO, 7, 10);
                    if (a == 0) {
                        str = "";
                        AppMethodBeat.o(114524);
                        return str;
                    }
                    str = new String(eO, 6, a - 6);
                }
            }
            AppMethodBeat.o(114524);
            return str;
        } catch (Throwable th) {
            str = "";
            AppMethodBeat.o(114524);
            return str;
        }
    }

    private static int a(byte[] bArr, int i, char c) {
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
    private static a Rc(int i) {
        String Rb;
        String trim;
        AppMethodBeat.i(114525);
        int a;
        try {
            Rb = Rb(i);
            int i2;
            try {
                int parseInt;
                byte[] eO = a.eO(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[]{Integer.valueOf(i)}), 150);
                if (eO != null) {
                    a = a(eO, 7, 10);
                    if (a != 0) {
                        a = a(eO, a(eO, a(eO, a + 1, 10) + 1, 10) + 1, 10);
                        if (a != 0) {
                            i2 = a + 7;
                            int a2 = a(eO, a + 1, 10);
                            if (a2 != 0) {
                                a = Integer.parseInt(new String(eO, i2, a2 - i2));
                                try {
                                    i2 = a(eO, a2 + 1, 10);
                                    if (i2 != 0) {
                                        i2 += 6;
                                        parseInt = Integer.parseInt(new String(eO, i2, a(eO, i2 + 1, 9) - i2));
                                    } else {
                                        parseInt = -1;
                                    }
                                    i2 = parseInt;
                                } catch (Exception e) {
                                    i2 = -1;
                                    trim = new String(a.atR(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                                    if (Rb != null) {
                                    }
                                    AppMethodBeat.o(114525);
                                    return null;
                                }
                                trim = new String(a.atR(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                                if (Rb != null || a == -1 || i2 == -1) {
                                    AppMethodBeat.o(114525);
                                    return null;
                                }
                                a aVar = new a(i, a, Rb, i2, trim);
                                AppMethodBeat.o(114525);
                                return aVar;
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
                trim = new String(a.atR(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                if (Rb != null) {
                }
                AppMethodBeat.o(114525);
                return null;
            }
        } catch (Exception e3) {
            a = -1;
            Rb = null;
        }
        try {
            trim = new String(a.atR(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
        } catch (Exception e4) {
            trim = null;
        }
        if (Rb != null) {
        }
        AppMethodBeat.o(114525);
        return null;
    }
}
