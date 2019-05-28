package com.tencent.mm.compatible.f;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class a {
    public static Boolean euv;

    public static class b {
        public String euA;
        public int euy;
        SparseArray<String> euz;
        public String model;
        public String version;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(93040);
            String format = String.format(Locale.US, "manufacture: %s, model: %s, version: %s, value: %s, chkExp: %d", new Object[]{this.euA, this.model, this.version, this.euz, Integer.valueOf(this.euy)});
            AppMethodBeat.o(93040);
            return format;
        }
    }

    public static class a {
        public String ceO;
        public int euw;
        public int eux;
        public int euy;
        SparseArray<String> euz;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(93039);
            String format = String.format(Locale.US, "pkgname: %s, minCode:%d, maxCode: %d, value: %s, chkExp: %d", new Object[]{this.ceO, Integer.valueOf(this.euw), Integer.valueOf(this.eux), this.euz, Integer.valueOf(this.euy)});
            AppMethodBeat.o(93039);
            return format;
        }
    }

    public static boolean a(String str, String str2, PInt pInt, PBool pBool) {
        AppMethodBeat.i(93041);
        if (str == null) {
            pBool.value = false;
            AppMethodBeat.o(93041);
            return false;
        } else if (str2 == null) {
            pBool.value = true;
            AppMethodBeat.o(93041);
            return false;
        } else if (str.equals(str2)) {
            pInt.value++;
            pBool.value = true;
            AppMethodBeat.o(93041);
            return true;
        } else {
            pBool.value = false;
            AppMethodBeat.o(93041);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0177 A:{SYNTHETIC, Splitter:B:52:0x0177} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0073 A:{SYNTHETIC, Splitter:B:23:0x0073} */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e3 A:{SYNTHETIC, Splitter:B:41:0x00e3} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0177 A:{SYNTHETIC, Splitter:B:52:0x0177} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(String str, List<b> list, List<a> list2) {
        Throwable th;
        AppMethodBeat.i(93042);
        if (e.ct(str)) {
            String str2 = ".perm.values.";
            String str3 = "";
            String dor = aa.dor();
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
                                Map z = br.z(trim, "perm");
                                if (z == null) {
                                    ab.e("MicroMsg.PermissionConfig", "unable to parse xml, ".concat(String.valueOf(trim)));
                                } else {
                                    str3 = (String) z.get(".perm.type");
                                    if (str3 == null) {
                                        ab.e("MicroMsg.PermissionConfig", "invalid config, ".concat(String.valueOf(trim)));
                                    } else if (str3.equals("1")) {
                                        b bVar = new b();
                                        bVar.euz = new SparseArray();
                                        bVar.euA = (String) z.get(".perm.manufacture");
                                        bVar.model = (String) z.get(".perm.model");
                                        bVar.version = (String) z.get(".perm.version_release");
                                        bVar.euz.append(1, z.get(str2 + dor));
                                        bVar.euz.append(2, z.get(str2 + "camera." + dor));
                                        bVar.euy = bo.ank((String) z.get(".perm.check_exception"));
                                        list.add(bVar);
                                    } else if (str3.equals("2")) {
                                        a aVar = new a();
                                        aVar.euz = new SparseArray();
                                        aVar.ceO = (String) z.get(".perm.package");
                                        aVar.euw = bo.ank((String) z.get(".perm.min_versioncode"));
                                        aVar.eux = bo.ank((String) z.get(".perm.max_versioncode"));
                                        aVar.euz.append(1, z.get(str2 + dor));
                                        aVar.euz.append(2, z.get(str2 + "camera." + dor));
                                        aVar.euy = bo.ank((String) z.get(".perm.check_exception"));
                                        list2.add(aVar);
                                    }
                                }
                            }
                        } else {
                            try {
                                bufferedReader2.close();
                                AppMethodBeat.o(93042);
                                return;
                            } catch (IOException e) {
                                AppMethodBeat.o(93042);
                                return;
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        bufferedReader = bufferedReader2;
                        try {
                            ab.e("MicroMsg.PermissionConfig", "file not found exception");
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    AppMethodBeat.o(93042);
                                    return;
                                } catch (IOException e3) {
                                    AppMethodBeat.o(93042);
                                    return;
                                }
                            }
                            AppMethodBeat.o(93042);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                            }
                            AppMethodBeat.o(93042);
                            throw th;
                        }
                    } catch (IOException e4) {
                        try {
                            ab.e("MicroMsg.PermissionConfig", "read permission config file failed");
                            if (bufferedReader2 == null) {
                                try {
                                    bufferedReader2.close();
                                    AppMethodBeat.o(93042);
                                    return;
                                } catch (IOException e5) {
                                    AppMethodBeat.o(93042);
                                    return;
                                }
                            }
                            AppMethodBeat.o(93042);
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e6) {
                                }
                            }
                            AppMethodBeat.o(93042);
                            throw th;
                        }
                    }
                }
            } catch (FileNotFoundException e7) {
                ab.e("MicroMsg.PermissionConfig", "file not found exception");
                if (bufferedReader != null) {
                }
                AppMethodBeat.o(93042);
                return;
            } catch (IOException e8) {
                bufferedReader2 = null;
                ab.e("MicroMsg.PermissionConfig", "read permission config file failed");
                if (bufferedReader2 == null) {
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader2 = null;
                if (bufferedReader2 != null) {
                }
                AppMethodBeat.o(93042);
                throw th;
            }
        }
        ab.i("MicroMsg.PermissionConfig", "file is not exists");
        AppMethodBeat.o(93042);
    }
}
