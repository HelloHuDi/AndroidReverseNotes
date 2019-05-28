package com.tencent.p177mm.compatible.p1188f;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.tencent.mm.compatible.f.a */
public final class C32472a {
    public static Boolean euv;

    /* renamed from: com.tencent.mm.compatible.f.a$b */
    public static class C18173b {
        public String euA;
        public int euy;
        SparseArray<String> euz;
        public String model;
        public String version;

        private C18173b() {
        }

        /* synthetic */ C18173b(byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.m2504i(93040);
            String format = String.format(Locale.US, "manufacture: %s, model: %s, version: %s, value: %s, chkExp: %d", new Object[]{this.euA, this.model, this.version, this.euz, Integer.valueOf(this.euy)});
            AppMethodBeat.m2505o(93040);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.compatible.f.a$a */
    public static class C26047a {
        public String ceO;
        public int euw;
        public int eux;
        public int euy;
        SparseArray<String> euz;

        private C26047a() {
        }

        /* synthetic */ C26047a(byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.m2504i(93039);
            String format = String.format(Locale.US, "pkgname: %s, minCode:%d, maxCode: %d, value: %s, chkExp: %d", new Object[]{this.ceO, Integer.valueOf(this.euw), Integer.valueOf(this.eux), this.euz, Integer.valueOf(this.euy)});
            AppMethodBeat.m2505o(93039);
            return format;
        }
    }

    /* renamed from: a */
    public static boolean m53158a(String str, String str2, PInt pInt, PBool pBool) {
        AppMethodBeat.m2504i(93041);
        if (str == null) {
            pBool.value = false;
            AppMethodBeat.m2505o(93041);
            return false;
        } else if (str2 == null) {
            pBool.value = true;
            AppMethodBeat.m2505o(93041);
            return false;
        } else if (str.equals(str2)) {
            pInt.value++;
            pBool.value = true;
            AppMethodBeat.m2505o(93041);
            return true;
        } else {
            pBool.value = false;
            AppMethodBeat.m2505o(93041);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0177 A:{SYNTHETIC, Splitter:B:52:0x0177} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0073 A:{SYNTHETIC, Splitter:B:23:0x0073} */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e3 A:{SYNTHETIC, Splitter:B:41:0x00e3} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0177 A:{SYNTHETIC, Splitter:B:52:0x0177} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m53157a(String str, List<C18173b> list, List<C26047a> list2) {
        Throwable th;
        AppMethodBeat.m2504i(93042);
        if (C1173e.m2561ct(str)) {
            String str2 = ".perm.values.";
            String str3 = "";
            String dor = C4988aa.dor();
            if (dor.equals("zh_CN")) {
                dor = "zh_CN";
            } else if (dor.equals("zh_TW") || dor.equals("zh_HK")) {
                dor = str3 + "zh_TW";
            } else {
                dor = str3 + "en";
            }
            BufferedReader bufferedReader = null;
            BufferedReader bufferedReader2;
            try {
                bufferedReader2 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        str3 = bufferedReader2.readLine();
                        if (str3 != null) {
                            String trim = str3.trim();
                            if (trim.length() != 0) {
                                Map z = C5049br.m7595z(trim, "perm");
                                if (z == null) {
                                    C4990ab.m7412e("MicroMsg.PermissionConfig", "unable to parse xml, ".concat(String.valueOf(trim)));
                                } else {
                                    str3 = (String) z.get(".perm.type");
                                    if (str3 == null) {
                                        C4990ab.m7412e("MicroMsg.PermissionConfig", "invalid config, ".concat(String.valueOf(trim)));
                                    } else if (str3.equals("1")) {
                                        C18173b c18173b = new C18173b();
                                        c18173b.euz = new SparseArray();
                                        c18173b.euA = (String) z.get(".perm.manufacture");
                                        c18173b.model = (String) z.get(".perm.model");
                                        c18173b.version = (String) z.get(".perm.version_release");
                                        c18173b.euz.append(1, z.get(str2 + dor));
                                        c18173b.euz.append(2, z.get(str2 + "camera." + dor));
                                        c18173b.euy = C5046bo.ank((String) z.get(".perm.check_exception"));
                                        list.add(c18173b);
                                    } else if (str3.equals("2")) {
                                        C26047a c26047a = new C26047a();
                                        c26047a.euz = new SparseArray();
                                        c26047a.ceO = (String) z.get(".perm.package");
                                        c26047a.euw = C5046bo.ank((String) z.get(".perm.min_versioncode"));
                                        c26047a.eux = C5046bo.ank((String) z.get(".perm.max_versioncode"));
                                        c26047a.euz.append(1, z.get(str2 + dor));
                                        c26047a.euz.append(2, z.get(str2 + "camera." + dor));
                                        c26047a.euy = C5046bo.ank((String) z.get(".perm.check_exception"));
                                        list2.add(c26047a);
                                    }
                                }
                            }
                        } else {
                            try {
                                bufferedReader2.close();
                                AppMethodBeat.m2505o(93042);
                                return;
                            } catch (IOException e) {
                                AppMethodBeat.m2505o(93042);
                                return;
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        bufferedReader = bufferedReader2;
                        try {
                            C4990ab.m7412e("MicroMsg.PermissionConfig", "file not found exception");
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    AppMethodBeat.m2505o(93042);
                                    return;
                                } catch (IOException e3) {
                                    AppMethodBeat.m2505o(93042);
                                    return;
                                }
                            }
                            AppMethodBeat.m2505o(93042);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                            }
                            AppMethodBeat.m2505o(93042);
                            throw th;
                        }
                    } catch (IOException e4) {
                        try {
                            C4990ab.m7412e("MicroMsg.PermissionConfig", "read permission config file failed");
                            if (bufferedReader2 == null) {
                                try {
                                    bufferedReader2.close();
                                    AppMethodBeat.m2505o(93042);
                                    return;
                                } catch (IOException e5) {
                                    AppMethodBeat.m2505o(93042);
                                    return;
                                }
                            }
                            AppMethodBeat.m2505o(93042);
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e6) {
                                }
                            }
                            AppMethodBeat.m2505o(93042);
                            throw th;
                        }
                    }
                }
            } catch (FileNotFoundException e7) {
                C4990ab.m7412e("MicroMsg.PermissionConfig", "file not found exception");
                if (bufferedReader != null) {
                }
                AppMethodBeat.m2505o(93042);
                return;
            } catch (IOException e8) {
                bufferedReader2 = null;
                C4990ab.m7412e("MicroMsg.PermissionConfig", "read permission config file failed");
                if (bufferedReader2 == null) {
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader2 = null;
                if (bufferedReader2 != null) {
                }
                AppMethodBeat.m2505o(93042);
                throw th;
            }
        }
        C4990ab.m7416i("MicroMsg.PermissionConfig", "file is not exists");
        AppMethodBeat.m2505o(93042);
    }
}
