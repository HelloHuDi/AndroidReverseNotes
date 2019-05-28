package com.tencent.p177mm.plugin.appbrand.appstorage;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.appbrand.p329s.C45689v;
import com.tencent.p177mm.sdk.p1574f.C44216b;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C40616m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p644j.C5710a;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import org.apache.commons.p1431a.C36638b;

/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager */
public final class LuggageLocalFileObjectManager {
    private static final C2061v gYh = new C101023();
    private final String gXQ;
    private final String gXR;
    private final String gXS;
    private final Collection<C10105a> gYg;

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager$3 */
    static class C101023 extends C2061v {
        C101023() {
        }

        public final String toString() {
            return "AppBrandLocalMediaObject::Nil";
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager$2 */
    class C101032 implements FileFilter {
        C101032() {
        }

        public final boolean accept(File file) {
            AppMethodBeat.m2504i(105418);
            if (!file.exists() || file.isDirectory() || C5046bo.isNullOrNil(file.getName()) || !file.getName().startsWith("tmp_")) {
                AppMethodBeat.m2505o(105418);
                return false;
            }
            AppMethodBeat.m2505o(105418);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager$1 */
    class C101041 implements FileFilter {
        C101041() {
        }

        public final boolean accept(File file) {
            AppMethodBeat.m2504i(105417);
            if (!file.exists() || file.isDirectory() || C5046bo.isNullOrNil(file.getName()) || !file.getName().startsWith("store_")) {
                AppMethodBeat.m2505o(105417);
                return false;
            }
            AppMethodBeat.m2505o(105417);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager$a */
    interface C10105a {
        /* renamed from: a */
        C2061v mo21461a(C2061v c2061v);

        /* renamed from: bC */
        C5710a mo21462bC(String str, String str2);

        /* renamed from: yq */
        C2061v mo21463yq(String str);

        /* renamed from: yr */
        C2061v mo21464yr(String str);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager$b */
    final class C10106b implements C10105a {
        private C10106b() {
        }

        /* synthetic */ C10106b(LuggageLocalFileObjectManager luggageLocalFileObjectManager, byte b) {
            this();
        }

        public final String toString() {
            return "V2MediaObjectInfoHandler";
        }

        /* renamed from: yq */
        public final C2061v mo21463yq(String str) {
            String str2 = null;
            AppMethodBeat.m2504i(105419);
            if (str.startsWith("store_") || str.startsWith("tmp_")) {
                String awJ = C36638b.awJ(str);
                String replaceFirst = str.replaceFirst("store_", "").replaceFirst("tmp_", "");
                if (!C5046bo.isNullOrNil(awJ)) {
                    replaceFirst = replaceFirst.replaceFirst(".".concat(String.valueOf(awJ)), "");
                }
                Object awV;
                if (C5046bo.isNullOrNil(replaceFirst)) {
                    awV = LuggageLocalFileObjectManager.gYh;
                    AppMethodBeat.m2505o(105419);
                    return awV;
                }
                try {
                    str2 = LuggageLocalFileObjectManager.m17698bA(replaceFirst, LuggageLocalFileObjectManager.this.gXR);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "retrieveMediaObject, decrypt exp ", new Object[0]);
                }
                if (C5046bo.isNullOrNil(str2)) {
                    C4990ab.m7410d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
                    awV = LuggageLocalFileObjectManager.gYh;
                    AppMethodBeat.m2505o(105419);
                    return awV;
                }
                String[] split = str2.split("\\|");
                if (split == null || split.length != 2) {
                    awV = LuggageLocalFileObjectManager.gYh;
                    AppMethodBeat.m2505o(105419);
                    return awV;
                }
                str2 = str.startsWith("store_") ? "store_" : "tmp_";
                String str3 = LuggageLocalFileObjectManager.m17697b(LuggageLocalFileObjectManager.this) + str2 + replaceFirst;
                long j = C5046bo.getLong(split[0], 0);
                String str4 = split[1];
                if (str4.equalsIgnoreCase(awJ)) {
                    try {
                        if (j != LuggageLocalFileObjectManager.m17701yp(str3)) {
                            C4990ab.m7413e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s)", Long.valueOf(LuggageLocalFileObjectManager.m17701yp(str3)), Long.valueOf(j), str);
                            awV = LuggageLocalFileObjectManager.gYh;
                            AppMethodBeat.m2505o(105419);
                            return awV;
                        }
                        C2061v c2061v = new C2061v();
                        c2061v.czD = LuggageLocalFileObjectManager.this.gXS + str;
                        c2061v.fnQ = str3;
                        c2061v.mimeType = C44216b.anI(str4);
                        c2061v.gXl = str2.equalsIgnoreCase("store_");
                        File file = new File(c2061v.fnQ);
                        c2061v.gXm = file.lastModified();
                        c2061v.gjQ = file.length();
                        AppMethodBeat.m2505o(105419);
                        return c2061v;
                    } catch (IOException e2) {
                        C4990ab.m7413e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", C5046bo.m7574l(e2));
                        awV = LuggageLocalFileObjectManager.gYh;
                        AppMethodBeat.m2505o(105419);
                        return awV;
                    }
                }
                awV = LuggageLocalFileObjectManager.gYh;
                AppMethodBeat.m2505o(105419);
                return awV;
            }
            AppMethodBeat.m2505o(105419);
            return str2;
        }

        /* renamed from: a */
        public final C2061v mo21461a(C2061v c2061v) {
            AppMethodBeat.m2504i(105420);
            if (c2061v == null) {
                AppMethodBeat.m2505o(105420);
                return null;
            }
            String replaceFirst = c2061v.fnQ.replaceFirst("tmp_", "store_");
            if (C38121i.m64493bx(c2061v.fnQ, replaceFirst)) {
                C2061v c2061v2 = new C2061v();
                c2061v2.fnQ = replaceFirst;
                c2061v2.czD = c2061v.czD.replaceFirst("tmp_", "store_");
                c2061v2.gjQ = c2061v.gjQ;
                c2061v2.eov = c2061v.eov;
                c2061v2.gXm = new File(c2061v2.fnQ).lastModified();
                c2061v2.mimeType = c2061v.mimeType;
                c2061v2.gXl = true;
                AppMethodBeat.m2505o(105420);
                return c2061v2;
            }
            AppMethodBeat.m2505o(105420);
            return null;
        }

        /* renamed from: bC */
        public final C5710a mo21462bC(String str, String str2) {
            AppMethodBeat.m2504i(105421);
            String bc = C5046bo.m7532bc(str2, "unknown");
            try {
                String bB;
                Long valueOf = Long.valueOf(LuggageLocalFileObjectManager.m17701yp(str));
                try {
                    bB = LuggageLocalFileObjectManager.m17699bB(String.format(Locale.US, "%d|%s", new Object[]{valueOf, bc}), LuggageLocalFileObjectManager.this.gXR);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "attachMediaObject, enc exp = ", new Object[0]);
                    bB = null;
                }
                if (C5046bo.isNullOrNil(bB)) {
                    AppMethodBeat.m2505o(105421);
                    return null;
                }
                bB = "tmp_".concat(String.valueOf(bB));
                C4990ab.m7411d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", LuggageLocalFileObjectManager.this.gXS + bB + (C5046bo.isNullOrNil(bc) ? "" : ".".concat(String.valueOf(bc))), LuggageLocalFileObjectManager.m17697b(LuggageLocalFileObjectManager.this) + bB);
                C5710a i = C5710a.m8577i(bB, r1, bc);
                AppMethodBeat.m2505o(105421);
                return i;
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, get crc exp = %s", C5046bo.m7574l(e2));
                AppMethodBeat.m2505o(105421);
                return null;
            }
        }

        /* renamed from: yr */
        public final C2061v mo21464yr(String str) {
            String bA;
            AppMethodBeat.m2504i(105422);
            String replaceFirst = str.replaceFirst("store_", "").replaceFirst("tmp_", "");
            try {
                bA = LuggageLocalFileObjectManager.m17698bA(replaceFirst, LuggageLocalFileObjectManager.this.gXR);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "retrieveMediaObjectByRealFileName, dec exp = ", new Object[0]);
                bA = null;
            }
            if (C5046bo.isNullOrNil(bA)) {
                AppMethodBeat.m2505o(105422);
                return null;
            }
            String[] split = bA.split("\\|");
            if (split == null || split.length != 2) {
                AppMethodBeat.m2505o(105422);
                return null;
            }
            bA = split[1];
            bA = LuggageLocalFileObjectManager.this.gXS + str + (C5046bo.isNullOrNil(bA) ? "" : ".".concat(String.valueOf(bA)));
            C2061v c2061v = new C2061v();
            c2061v.czD = bA;
            c2061v.fnQ = LuggageLocalFileObjectManager.m17697b(LuggageLocalFileObjectManager.this) + str;
            c2061v.eov = replaceFirst;
            c2061v.gXl = str.startsWith("store_");
            File file = new File(c2061v.fnQ);
            c2061v.gXm = file.lastModified();
            c2061v.gjQ = file.length();
            AppMethodBeat.m2505o(105422);
            return c2061v;
        }
    }

    /* renamed from: b */
    static /* synthetic */ String m17697b(LuggageLocalFileObjectManager luggageLocalFileObjectManager) {
        AppMethodBeat.m2504i(105435);
        String awU = luggageLocalFileObjectManager.awU();
        AppMethodBeat.m2505o(105435);
        return awU;
    }

    LuggageLocalFileObjectManager(String str, String str2, String str3) {
        AppMethodBeat.m2504i(105423);
        this.gXQ = new File(str).getAbsolutePath() + "/";
        this.gXR = str2;
        this.gXS = str3;
        LinkedList linkedList = new LinkedList();
        linkedList.add(new C10106b(this, (byte) 0));
        this.gYg = Collections.unmodifiableCollection(linkedList);
        AppMethodBeat.m2505o(105423);
    }

    @Keep
    public final String genMediaFilePath(String str) {
        AppMethodBeat.m2504i(105424);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(105424);
            return null;
        }
        String str2 = awU() + str;
        AppMethodBeat.m2505o(105424);
        return str2;
    }

    public final List<C2061v> awR() {
        AppMethodBeat.m2504i(105425);
        File[] awS = awS();
        if (awS == null || awS.length <= 0) {
            AppMethodBeat.m2505o(105425);
            return null;
        }
        List<C2061v> linkedList = new LinkedList();
        for (File name : awS) {
            C2061v yn = mo21456yn(name.getName());
            if (yn != null) {
                linkedList.add(yn);
            }
        }
        AppMethodBeat.m2505o(105425);
        return linkedList;
    }

    /* Access modifiers changed, original: final */
    public final File[] awS() {
        AppMethodBeat.m2504i(105426);
        File file = new File(awU());
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles(new C101041());
            AppMethodBeat.m2505o(105426);
            return listFiles;
        }
        AppMethodBeat.m2505o(105426);
        return null;
    }

    /* renamed from: a */
    private <T extends C2061v> T m17695a(String str, Class<T> cls, String str2, boolean z) {
        AppMethodBeat.m2504i(105428);
        if (C1173e.m2561ct(str)) {
            String awJ = C36638b.awJ(str);
            if (!C5046bo.isNullOrNil(awJ)) {
                str2 = awJ;
            }
            C5710a c5710a = null;
            for (C10105a bC : this.gYg) {
                c5710a = bC.mo21462bC(str, str2);
                if (c5710a != null) {
                    break;
                }
            }
            C5710a c5710a2 = c5710a;
            String str3;
            if (c5710a2 == null || c5710a2.size() < 2) {
                str3 = "MicroMsg.AppBrand.LuggageLocalFileObjectManager";
                String str4 = "attachCast, no handler return correct info, attach.size = %d";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(c5710a2 == null ? -1 : c5710a2.size());
                C4990ab.m7413e(str3, str4, objArr);
                AppMethodBeat.m2505o(105428);
                return null;
            }
            try {
                T t = (C2061v) cls.newInstance();
                t.czD = (String) c5710a2.get(0);
                t.mimeType = C44216b.anI(str2);
                t.fnQ = (String) c5710a2.get(1);
                if (C5046bo.isNullOrNil(t.fnQ)) {
                    C4990ab.m7412e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
                    AppMethodBeat.m2505o(105428);
                    return null;
                }
                int i;
                t.eov = C5046bo.m7532bc((String) c5710a2.get(3), C5046bo.m7532bc(str2, "unknown"));
                str3 = t.fnQ;
                if (z && C38121i.m64493bx(str, str3)) {
                    i = 1;
                } else {
                    if (!z) {
                        if (C40616m.copyFile(str, str3)) {
                            i = 1;
                        }
                    }
                    i = 0;
                }
                if (i != 0) {
                    File file = new File(t.fnQ);
                    t.gjQ = file.length();
                    t.gXm = file.lastModified();
                    AppMethodBeat.m2505o(105428);
                    return t;
                }
                AppMethodBeat.m2505o(105428);
                return null;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.LuggageLocalFileObjectManager", e, "", new Object[0]);
            }
        } else {
            AppMethodBeat.m2505o(105428);
            return null;
        }
    }

    /* renamed from: k */
    public final C2061v mo21455k(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(105429);
        C2061v a = m17695a(str, C2061v.class, str2, z);
        AppMethodBeat.m2505o(105429);
        return a;
    }

    /* renamed from: a */
    public final C2061v mo21450a(C2061v c2061v) {
        AppMethodBeat.m2504i(105431);
        C2061v c2061v2 = null;
        for (C10105a a : this.gYg) {
            c2061v2 = a.mo21461a(c2061v);
            if (c2061v2 != null) {
                break;
            }
        }
        AppMethodBeat.m2505o(105431);
        return c2061v2;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: yn */
    public final C2061v mo21456yn(String str) {
        C2061v c2061v = null;
        AppMethodBeat.m2504i(105432);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(105432);
        } else {
            for (C10105a yr : this.gYg) {
                c2061v = yr.mo21464yr(str);
                if (c2061v != null) {
                    break;
                }
            }
            AppMethodBeat.m2505o(105432);
        }
        return c2061v;
    }

    @Deprecated
    /* renamed from: yo */
    public final C2061v mo21457yo(String str) {
        AppMethodBeat.m2504i(105433);
        if (C5046bo.isNullOrNil(str) || !str.startsWith(this.gXS)) {
            C4990ab.m7413e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, invalid args, localId(%s)", str);
            AppMethodBeat.m2505o(105433);
            return null;
        }
        C2061v yq;
        String substring = str.substring(this.gXS.length());
        C2061v c2061v = null;
        for (C10105a yq2 : this.gYg) {
            yq = yq2.mo21463yq(substring);
            if (yq != null) {
                C4990ab.m7417i("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, handled by %s, result = %s", yq2.toString(), yq);
                break;
            }
            c2061v = yq;
        }
        yq = c2061v;
        if (gYh == yq) {
            AppMethodBeat.m2505o(105433);
            return null;
        }
        AppMethodBeat.m2505o(105433);
        return yq;
    }

    static {
        AppMethodBeat.m2504i(105438);
        AppMethodBeat.m2505o(105438);
    }

    public final List<C2061v> awT() {
        File[] listFiles;
        List<C2061v> list = null;
        AppMethodBeat.m2504i(105427);
        File file = new File(awU());
        if (file.exists() && file.isDirectory()) {
            listFiles = file.listFiles(new C101032());
        } else {
            listFiles = null;
        }
        if (listFiles == null || listFiles.length <= 0) {
            AppMethodBeat.m2505o(105427);
        } else {
            list = new LinkedList();
            for (File name : listFiles) {
                C2061v yn = mo21456yn(name.getName());
                if (yn != null) {
                    list.add(yn);
                }
            }
            AppMethodBeat.m2505o(105427);
        }
        return list;
    }

    private String awU() {
        AppMethodBeat.m2504i(105430);
        C15428j.aih(this.gXQ);
        try {
            new File(this.gXQ, ".nomedia").createNewFile();
        } catch (Exception e) {
        }
        String str = this.gXQ;
        AppMethodBeat.m2505o(105430);
        return str;
    }

    /* renamed from: bA */
    static /* synthetic */ String m17698bA(String str, String str2) {
        AppMethodBeat.m2504i(105434);
        byte[] decrypt = new C45689v().decrypt(C5046bo.anf(str), str2.getBytes());
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(105434);
            return null;
        }
        String str3 = new String(decrypt);
        AppMethodBeat.m2505o(105434);
        return str3;
    }

    /* renamed from: yp */
    static /* synthetic */ long m17701yp(String str) {
        AppMethodBeat.m2504i(105436);
        FileInputStream fileInputStream = new FileInputStream(str);
        CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        do {
        } while (checkedInputStream.read(new byte[2048]) >= 0);
        long value = checkedInputStream.getChecksum().getValue();
        C5046bo.m7527b(checkedInputStream);
        C5046bo.m7527b(fileInputStream);
        AppMethodBeat.m2505o(105436);
        return value;
    }

    /* renamed from: bB */
    static /* synthetic */ String m17699bB(String str, String str2) {
        AppMethodBeat.m2504i(105437);
        String cd = C5046bo.m7543cd(new C45689v().encrypt(str.getBytes(), str2.getBytes()));
        AppMethodBeat.m2505o(105437);
        return cd;
    }
}
