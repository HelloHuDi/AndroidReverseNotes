package com.tencent.p177mm.plugin.appbrand.appstorage;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
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
import java.util.Locale;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import org.apache.commons.p1431a.C36638b;

@Deprecated
/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager */
public final class AppBrandLocalMediaObjectManager {
    public static final String gXo;
    private static final Collection<C19075a> gXp;
    private static final AppBrandLocalMediaObject iTX = new C190793();

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager$a */
    interface C19075a {
        /* renamed from: B */
        C5710a mo34303B(String str, String str2, String str3);

        /* renamed from: bw */
        AppBrandLocalMediaObject mo34304bw(String str, String str2);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager$b */
    static final class C19076b implements C19075a {
        private C19076b() {
        }

        /* synthetic */ C19076b(byte b) {
            this();
        }

        public final String toString() {
            return "V2MediaObjectInfoHandler";
        }

        /* renamed from: bw */
        public final AppBrandLocalMediaObject mo34304bw(String str, String str2) {
            String str3 = null;
            AppMethodBeat.m2504i(105344);
            if (str2.startsWith("store_") || str2.startsWith("tmp_")) {
                String awJ = C36638b.awJ(str2);
                String replaceFirst = str2.replaceFirst("store_", "").replaceFirst("tmp_", "");
                if (!C5046bo.isNullOrNil(awJ)) {
                    replaceFirst = replaceFirst.replaceFirst(".".concat(String.valueOf(awJ)), "");
                }
                Object arP;
                if (C5046bo.isNullOrNil(replaceFirst)) {
                    arP = AppBrandLocalMediaObjectManager.iTX;
                    AppMethodBeat.m2505o(105344);
                    return arP;
                }
                try {
                    str3 = AppBrandLocalMediaObjectManager.m29648bu(replaceFirst, str);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "retrieveMediaObject, decrypt exp ", new Object[0]);
                }
                if (C5046bo.isNullOrNil(str3)) {
                    C4990ab.m7410d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
                    arP = AppBrandLocalMediaObjectManager.iTX;
                    AppMethodBeat.m2505o(105344);
                    return arP;
                }
                String[] split = str3.split("\\|");
                if (split == null || split.length != 2) {
                    arP = AppBrandLocalMediaObjectManager.iTX;
                    AppMethodBeat.m2505o(105344);
                    return arP;
                }
                str3 = str2.startsWith("store_") ? "store_" : "tmp_";
                String str4 = AppBrandLocalMediaObjectManager.m29655xZ(str) + str3 + replaceFirst;
                long j = C5046bo.getLong(split[0], 0);
                String str5 = split[1];
                if (str5.equalsIgnoreCase(awJ)) {
                    try {
                        if (j != AppBrandLocalMediaObjectManager.m29656ya(str4)) {
                            C4990ab.m7413e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s), appId(%s)", Long.valueOf(AppBrandLocalMediaObjectManager.m29656ya(str4)), Long.valueOf(j), str2, str);
                            arP = AppBrandLocalMediaObjectManager.iTX;
                            AppMethodBeat.m2505o(105344);
                            return arP;
                        }
                        AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject();
                        appBrandLocalMediaObject.czD = "wxfile://".concat(String.valueOf(str2));
                        appBrandLocalMediaObject.fnQ = str4;
                        appBrandLocalMediaObject.mimeType = C44216b.anI(str5);
                        appBrandLocalMediaObject.gXl = str3.equalsIgnoreCase("store_");
                        File file = new File(appBrandLocalMediaObject.fnQ);
                        appBrandLocalMediaObject.gXm = file.lastModified();
                        appBrandLocalMediaObject.gjQ = file.length();
                        AppMethodBeat.m2505o(105344);
                        return appBrandLocalMediaObject;
                    } catch (IOException e2) {
                        C4990ab.m7413e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", C5046bo.m7574l(e2));
                        arP = AppBrandLocalMediaObjectManager.iTX;
                        AppMethodBeat.m2505o(105344);
                        return arP;
                    }
                }
                arP = AppBrandLocalMediaObjectManager.iTX;
                AppMethodBeat.m2505o(105344);
                return arP;
            }
            AppMethodBeat.m2505o(105344);
            return str3;
        }

        /* renamed from: B */
        public final C5710a mo34303B(String str, String str2, String str3) {
            AppMethodBeat.m2504i(105345);
            String bc = C5046bo.m7532bc(str3, "unknown");
            try {
                String bv;
                Long valueOf = Long.valueOf(AppBrandLocalMediaObjectManager.m29656ya(str2));
                try {
                    bv = AppBrandLocalMediaObjectManager.m29649bv(String.format(Locale.US, "%d|%s", new Object[]{valueOf, bc}), str);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "attachMediaObject, enc exp = ", new Object[0]);
                    bv = null;
                }
                if (C5046bo.isNullOrNil(bv)) {
                    AppMethodBeat.m2505o(105345);
                    return null;
                }
                bv = "tmp_".concat(String.valueOf(bv));
                C4990ab.m7411d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", "wxfile://" + bv + (C5046bo.isNullOrNil(bc) ? "" : ".".concat(String.valueOf(bc))), AppBrandLocalMediaObjectManager.m29655xZ(str) + bv);
                C5710a i = C5710a.m8577i(bv, r1, bc);
                AppMethodBeat.m2505o(105345);
                return i;
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, get crc exp = %s", C5046bo.m7574l(e2));
                AppMethodBeat.m2505o(105345);
                return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager$2 */
    static class C190772 implements FileFilter {
        C190772() {
        }

        public final boolean accept(File file) {
            AppMethodBeat.m2504i(105343);
            if (!file.exists() || file.isDirectory() || C5046bo.isNullOrNil(file.getName()) || !file.getName().startsWith("tmp_")) {
                AppMethodBeat.m2505o(105343);
                return false;
            }
            AppMethodBeat.m2505o(105343);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager$1 */
    static class C190781 implements FileFilter {
        C190781() {
        }

        public final boolean accept(File file) {
            AppMethodBeat.m2504i(105342);
            if (!file.exists() || file.isDirectory() || C5046bo.isNullOrNil(file.getName()) || !file.getName().startsWith("store_")) {
                AppMethodBeat.m2505o(105342);
                return false;
            }
            AppMethodBeat.m2505o(105342);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager$3 */
    static class C190793 extends AppBrandLocalMediaObject {
        C190793() {
        }

        public final String toString() {
            return "AppBrandLocalMediaObject::Nil";
        }
    }

    /* renamed from: xZ */
    static /* synthetic */ String m29655xZ(String str) {
        AppMethodBeat.m2504i(105356);
        String xY = AppBrandLocalMediaObjectManager.m29654xY(str);
        AppMethodBeat.m2505o(105356);
        return xY;
    }

    private AppBrandLocalMediaObjectManager() {
    }

    static {
        AppMethodBeat.m2504i(105359);
        String str = C6457e.eSn;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        gXo = str + "wxafiles/";
        LinkedList linkedList = new LinkedList();
        linkedList.add(new C19076b());
        gXp = Collections.unmodifiableCollection(linkedList);
        AppMethodBeat.m2505o(105359);
    }

    @Keep
    public static String genMediaFilePath(String str, String str2) {
        AppMethodBeat.m2504i(105346);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(105346);
            return null;
        }
        String str3 = AppBrandLocalMediaObjectManager.m29654xY(str) + str2;
        AppMethodBeat.m2505o(105346);
        return str3;
    }

    /* renamed from: bs */
    public static AppBrandLocalVideoObject m29646bs(String str, String str2) {
        AppMethodBeat.m2504i(105349);
        AppBrandLocalVideoObject appBrandLocalVideoObject = (AppBrandLocalVideoObject) AppBrandLocalMediaObjectManager.m29645a(str, str2, AppBrandLocalVideoObject.class, "mp4", false);
        AppMethodBeat.m2505o(105349);
        return appBrandLocalVideoObject;
    }

    /* renamed from: a */
    private static <T extends AppBrandLocalMediaObject> T m29645a(String str, String str2, Class<T> cls, String str3, boolean z) {
        AppMethodBeat.m2504i(105350);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(105350);
            return null;
        } else if (C1173e.m2561ct(str2)) {
            String awJ = C36638b.awJ(str2);
            if (!C5046bo.isNullOrNil(awJ)) {
                str3 = awJ;
            }
            C5710a c5710a = null;
            for (C19075a B : gXp) {
                c5710a = B.mo34303B(str, str2, str3);
                if (c5710a != null) {
                    break;
                }
            }
            C5710a c5710a2 = c5710a;
            String str4;
            if (c5710a2 == null || c5710a2.size() < 2) {
                str4 = "MicroMsg.AppBrand.LocalMediaObjectManager";
                String str5 = "attachCast, no handler return correct info, attach.size = %d";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(c5710a2 == null ? -1 : c5710a2.size());
                C4990ab.m7413e(str4, str5, objArr);
                AppMethodBeat.m2505o(105350);
                return null;
            }
            try {
                T t = (AppBrandLocalMediaObject) cls.newInstance();
                t.czD = (String) c5710a2.get(0);
                t.mimeType = C44216b.anI(str3);
                t.fnQ = (String) c5710a2.get(1);
                if (C5046bo.isNullOrNil(t.fnQ)) {
                    C4990ab.m7412e("MicroMsg.AppBrand.LocalMediaObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
                    AppMethodBeat.m2505o(105350);
                    return null;
                }
                int i;
                t.eov = C5046bo.m7532bc((String) c5710a2.get(3), C5046bo.m7532bc(str3, "unknown"));
                str4 = t.fnQ;
                if (z && C38121i.m64493bx(str2, str4)) {
                    i = 1;
                } else {
                    if (!z) {
                        if (C40616m.copyFile(str2, str4)) {
                            i = 1;
                        }
                    }
                    i = 0;
                }
                if (i != 0) {
                    File file = new File(t.fnQ);
                    t.gjQ = file.length();
                    t.gXm = file.lastModified();
                    AppMethodBeat.m2505o(105350);
                    return t;
                }
                AppMethodBeat.m2505o(105350);
                return null;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager", e, "", new Object[0]);
            }
        } else {
            AppMethodBeat.m2505o(105350);
            return null;
        }
    }

    /* renamed from: j */
    public static AppBrandLocalMediaObject m29651j(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(105351);
        AppBrandLocalMediaObject c = AppBrandLocalMediaObjectManager.m29650c(str, str2, null, z);
        AppMethodBeat.m2505o(105351);
        return c;
    }

    /* renamed from: c */
    public static AppBrandLocalMediaObject m29650c(String str, String str2, String str3, boolean z) {
        AppMethodBeat.m2504i(105352);
        AppBrandLocalMediaObject a = AppBrandLocalMediaObjectManager.m29645a(str, str2, AppBrandLocalMediaObject.class, str3, z);
        AppMethodBeat.m2505o(105352);
        return a;
    }

    @Deprecated
    /* renamed from: bt */
    public static AppBrandLocalMediaObject m29647bt(String str, String str2) {
        AppMethodBeat.m2504i(105354);
        if (C5046bo.isNullOrNil(str2) || !str2.startsWith("wxfile://") || C5046bo.isNullOrNil(str)) {
            C4990ab.m7413e("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, invalid args, localId(%s), appId(%s) ", str2, str);
            AppMethodBeat.m2505o(105354);
            return null;
        }
        AppBrandLocalMediaObject bw;
        String substring = str2.substring(9);
        AppBrandLocalMediaObject appBrandLocalMediaObject = null;
        for (C19075a bw2 : gXp) {
            bw = bw2.mo34304bw(str, substring);
            if (bw != null) {
                C4990ab.m7417i("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, handled by %s, result = %s", bw2.toString(), bw);
                break;
            }
            appBrandLocalMediaObject = bw;
        }
        bw = appBrandLocalMediaObject;
        if (iTX == bw) {
            AppMethodBeat.m2505o(105354);
            return null;
        }
        AppMethodBeat.m2505o(105354);
        return bw;
    }

    /* renamed from: xW */
    public static long m29652xW(String str) {
        File[] listFiles;
        long j = 0;
        AppMethodBeat.m2504i(105347);
        File file = new File(AppBrandLocalMediaObjectManager.m29654xY(str));
        if (file.exists() && file.isDirectory()) {
            listFiles = file.listFiles(new C190772());
        } else {
            listFiles = null;
        }
        if (listFiles == null || listFiles.length <= 0) {
            AppMethodBeat.m2505o(105347);
        } else {
            for (File length : listFiles) {
                j += length.length();
            }
            AppMethodBeat.m2505o(105347);
        }
        return j;
    }

    /* renamed from: xX */
    public static long m29653xX(String str) {
        File[] listFiles;
        long j = 0;
        AppMethodBeat.m2504i(105348);
        File file = new File(AppBrandLocalMediaObjectManager.m29654xY(str));
        if (file.exists() && file.isDirectory()) {
            listFiles = file.listFiles(new C190781());
        } else {
            listFiles = null;
        }
        if (listFiles == null || listFiles.length <= 0) {
            AppMethodBeat.m2505o(105348);
        } else {
            for (File length : listFiles) {
                j += length.length();
            }
            AppMethodBeat.m2505o(105348);
        }
        return j;
    }

    /* renamed from: xY */
    private static String m29654xY(String str) {
        AppMethodBeat.m2504i(105353);
        String str2 = gXo + str + "/";
        C15428j.aih(str2);
        try {
            new File(str2, ".nomedia").createNewFile();
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(105353);
        return str2;
    }

    /* renamed from: bu */
    static /* synthetic */ String m29648bu(String str, String str2) {
        AppMethodBeat.m2504i(105355);
        byte[] decrypt = new C45689v().decrypt(C5046bo.anf(str), str2.getBytes());
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(105355);
            return null;
        }
        String str3 = new String(decrypt);
        AppMethodBeat.m2505o(105355);
        return str3;
    }

    /* renamed from: ya */
    static /* synthetic */ long m29656ya(String str) {
        AppMethodBeat.m2504i(105357);
        FileInputStream fileInputStream = new FileInputStream(str);
        CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        do {
        } while (checkedInputStream.read(new byte[2048]) >= 0);
        long value = checkedInputStream.getChecksum().getValue();
        C5046bo.m7527b(checkedInputStream);
        C5046bo.m7527b(fileInputStream);
        AppMethodBeat.m2505o(105357);
        return value;
    }

    /* renamed from: bv */
    static /* synthetic */ String m29649bv(String str, String str2) {
        AppMethodBeat.m2504i(105358);
        String cd = C5046bo.m7543cd(new C45689v().encrypt(str.getBytes(), str2.getBytes()));
        AppMethodBeat.m2505o(105358);
        return cd;
    }
}
