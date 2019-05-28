package com.tencent.mm.plugin.appbrand.appstorage;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.s.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.m;
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

@Deprecated
public final class AppBrandLocalMediaObjectManager {
    public static final String gXo;
    private static final Collection<a> gXp;
    private static final AppBrandLocalMediaObject iTX = new AppBrandLocalMediaObject() {
        public final String toString() {
            return "AppBrandLocalMediaObject::Nil";
        }
    };

    interface a {
        com.tencent.mm.vending.j.a B(String str, String str2, String str3);

        AppBrandLocalMediaObject bw(String str, String str2);
    }

    static final class b implements a {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final String toString() {
            return "V2MediaObjectInfoHandler";
        }

        public final AppBrandLocalMediaObject bw(String str, String str2) {
            String str3 = null;
            AppMethodBeat.i(105344);
            if (str2.startsWith("store_") || str2.startsWith("tmp_")) {
                String awJ = org.apache.commons.a.b.awJ(str2);
                String replaceFirst = str2.replaceFirst("store_", "").replaceFirst("tmp_", "");
                if (!bo.isNullOrNil(awJ)) {
                    replaceFirst = replaceFirst.replaceFirst(".".concat(String.valueOf(awJ)), "");
                }
                Object arP;
                if (bo.isNullOrNil(replaceFirst)) {
                    arP = AppBrandLocalMediaObjectManager.iTX;
                    AppMethodBeat.o(105344);
                    return arP;
                }
                try {
                    str3 = AppBrandLocalMediaObjectManager.bu(replaceFirst, str);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "retrieveMediaObject, decrypt exp ", new Object[0]);
                }
                if (bo.isNullOrNil(str3)) {
                    ab.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
                    arP = AppBrandLocalMediaObjectManager.iTX;
                    AppMethodBeat.o(105344);
                    return arP;
                }
                String[] split = str3.split("\\|");
                if (split == null || split.length != 2) {
                    arP = AppBrandLocalMediaObjectManager.iTX;
                    AppMethodBeat.o(105344);
                    return arP;
                }
                str3 = str2.startsWith("store_") ? "store_" : "tmp_";
                String str4 = AppBrandLocalMediaObjectManager.xZ(str) + str3 + replaceFirst;
                long j = bo.getLong(split[0], 0);
                String str5 = split[1];
                if (str5.equalsIgnoreCase(awJ)) {
                    try {
                        if (j != AppBrandLocalMediaObjectManager.ya(str4)) {
                            ab.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s), appId(%s)", Long.valueOf(AppBrandLocalMediaObjectManager.ya(str4)), Long.valueOf(j), str2, str);
                            arP = AppBrandLocalMediaObjectManager.iTX;
                            AppMethodBeat.o(105344);
                            return arP;
                        }
                        AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject();
                        appBrandLocalMediaObject.czD = "wxfile://".concat(String.valueOf(str2));
                        appBrandLocalMediaObject.fnQ = str4;
                        appBrandLocalMediaObject.mimeType = com.tencent.mm.sdk.f.b.anI(str5);
                        appBrandLocalMediaObject.gXl = str3.equalsIgnoreCase("store_");
                        File file = new File(appBrandLocalMediaObject.fnQ);
                        appBrandLocalMediaObject.gXm = file.lastModified();
                        appBrandLocalMediaObject.gjQ = file.length();
                        AppMethodBeat.o(105344);
                        return appBrandLocalMediaObject;
                    } catch (IOException e2) {
                        ab.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", bo.l(e2));
                        arP = AppBrandLocalMediaObjectManager.iTX;
                        AppMethodBeat.o(105344);
                        return arP;
                    }
                }
                arP = AppBrandLocalMediaObjectManager.iTX;
                AppMethodBeat.o(105344);
                return arP;
            }
            AppMethodBeat.o(105344);
            return str3;
        }

        public final com.tencent.mm.vending.j.a B(String str, String str2, String str3) {
            AppMethodBeat.i(105345);
            String bc = bo.bc(str3, "unknown");
            try {
                String bv;
                Long valueOf = Long.valueOf(AppBrandLocalMediaObjectManager.ya(str2));
                try {
                    bv = AppBrandLocalMediaObjectManager.bv(String.format(Locale.US, "%d|%s", new Object[]{valueOf, bc}), str);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "attachMediaObject, enc exp = ", new Object[0]);
                    bv = null;
                }
                if (bo.isNullOrNil(bv)) {
                    AppMethodBeat.o(105345);
                    return null;
                }
                bv = "tmp_".concat(String.valueOf(bv));
                ab.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", "wxfile://" + bv + (bo.isNullOrNil(bc) ? "" : ".".concat(String.valueOf(bc))), AppBrandLocalMediaObjectManager.xZ(str) + bv);
                com.tencent.mm.vending.j.a i = com.tencent.mm.vending.j.a.i(bv, r1, bc);
                AppMethodBeat.o(105345);
                return i;
            } catch (Exception e2) {
                ab.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, get crc exp = %s", bo.l(e2));
                AppMethodBeat.o(105345);
                return null;
            }
        }
    }

    static /* synthetic */ String xZ(String str) {
        AppMethodBeat.i(105356);
        String xY = xY(str);
        AppMethodBeat.o(105356);
        return xY;
    }

    private AppBrandLocalMediaObjectManager() {
    }

    static {
        AppMethodBeat.i(105359);
        String str = e.eSn;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        gXo = str + "wxafiles/";
        LinkedList linkedList = new LinkedList();
        linkedList.add(new b());
        gXp = Collections.unmodifiableCollection(linkedList);
        AppMethodBeat.o(105359);
    }

    @Keep
    public static String genMediaFilePath(String str, String str2) {
        AppMethodBeat.i(105346);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            AppMethodBeat.o(105346);
            return null;
        }
        String str3 = xY(str) + str2;
        AppMethodBeat.o(105346);
        return str3;
    }

    public static AppBrandLocalVideoObject bs(String str, String str2) {
        AppMethodBeat.i(105349);
        AppBrandLocalVideoObject appBrandLocalVideoObject = (AppBrandLocalVideoObject) a(str, str2, AppBrandLocalVideoObject.class, "mp4", false);
        AppMethodBeat.o(105349);
        return appBrandLocalVideoObject;
    }

    private static <T extends AppBrandLocalMediaObject> T a(String str, String str2, Class<T> cls, String str3, boolean z) {
        AppMethodBeat.i(105350);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(105350);
            return null;
        } else if (com.tencent.mm.a.e.ct(str2)) {
            String awJ = org.apache.commons.a.b.awJ(str2);
            if (!bo.isNullOrNil(awJ)) {
                str3 = awJ;
            }
            com.tencent.mm.vending.j.a aVar = null;
            for (a B : gXp) {
                aVar = B.B(str, str2, str3);
                if (aVar != null) {
                    break;
                }
            }
            com.tencent.mm.vending.j.a aVar2 = aVar;
            String str4;
            if (aVar2 == null || aVar2.size() < 2) {
                str4 = "MicroMsg.AppBrand.LocalMediaObjectManager";
                String str5 = "attachCast, no handler return correct info, attach.size = %d";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(aVar2 == null ? -1 : aVar2.size());
                ab.e(str4, str5, objArr);
                AppMethodBeat.o(105350);
                return null;
            }
            try {
                T t = (AppBrandLocalMediaObject) cls.newInstance();
                t.czD = (String) aVar2.get(0);
                t.mimeType = com.tencent.mm.sdk.f.b.anI(str3);
                t.fnQ = (String) aVar2.get(1);
                if (bo.isNullOrNil(t.fnQ)) {
                    ab.e("MicroMsg.AppBrand.LocalMediaObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
                    AppMethodBeat.o(105350);
                    return null;
                }
                int i;
                t.eov = bo.bc((String) aVar2.get(3), bo.bc(str3, "unknown"));
                str4 = t.fnQ;
                if (z && i.bx(str2, str4)) {
                    i = 1;
                } else {
                    if (!z) {
                        if (m.copyFile(str2, str4)) {
                            i = 1;
                        }
                    }
                    i = 0;
                }
                if (i != 0) {
                    File file = new File(t.fnQ);
                    t.gjQ = file.length();
                    t.gXm = file.lastModified();
                    AppMethodBeat.o(105350);
                    return t;
                }
                AppMethodBeat.o(105350);
                return null;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager", e, "", new Object[0]);
            }
        } else {
            AppMethodBeat.o(105350);
            return null;
        }
    }

    public static AppBrandLocalMediaObject j(String str, String str2, boolean z) {
        AppMethodBeat.i(105351);
        AppBrandLocalMediaObject c = c(str, str2, null, z);
        AppMethodBeat.o(105351);
        return c;
    }

    public static AppBrandLocalMediaObject c(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(105352);
        AppBrandLocalMediaObject a = a(str, str2, AppBrandLocalMediaObject.class, str3, z);
        AppMethodBeat.o(105352);
        return a;
    }

    @Deprecated
    public static AppBrandLocalMediaObject bt(String str, String str2) {
        AppMethodBeat.i(105354);
        if (bo.isNullOrNil(str2) || !str2.startsWith("wxfile://") || bo.isNullOrNil(str)) {
            ab.e("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, invalid args, localId(%s), appId(%s) ", str2, str);
            AppMethodBeat.o(105354);
            return null;
        }
        AppBrandLocalMediaObject bw;
        String substring = str2.substring(9);
        AppBrandLocalMediaObject appBrandLocalMediaObject = null;
        for (a bw2 : gXp) {
            bw = bw2.bw(str, substring);
            if (bw != null) {
                ab.i("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, handled by %s, result = %s", bw2.toString(), bw);
                break;
            }
            appBrandLocalMediaObject = bw;
        }
        bw = appBrandLocalMediaObject;
        if (iTX == bw) {
            AppMethodBeat.o(105354);
            return null;
        }
        AppMethodBeat.o(105354);
        return bw;
    }

    public static long xW(String str) {
        File[] listFiles;
        long j = 0;
        AppMethodBeat.i(105347);
        File file = new File(xY(str));
        if (file.exists() && file.isDirectory()) {
            listFiles = file.listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    AppMethodBeat.i(105343);
                    if (!file.exists() || file.isDirectory() || bo.isNullOrNil(file.getName()) || !file.getName().startsWith("tmp_")) {
                        AppMethodBeat.o(105343);
                        return false;
                    }
                    AppMethodBeat.o(105343);
                    return true;
                }
            });
        } else {
            listFiles = null;
        }
        if (listFiles == null || listFiles.length <= 0) {
            AppMethodBeat.o(105347);
        } else {
            for (File length : listFiles) {
                j += length.length();
            }
            AppMethodBeat.o(105347);
        }
        return j;
    }

    public static long xX(String str) {
        File[] listFiles;
        long j = 0;
        AppMethodBeat.i(105348);
        File file = new File(xY(str));
        if (file.exists() && file.isDirectory()) {
            listFiles = file.listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    AppMethodBeat.i(105342);
                    if (!file.exists() || file.isDirectory() || bo.isNullOrNil(file.getName()) || !file.getName().startsWith("store_")) {
                        AppMethodBeat.o(105342);
                        return false;
                    }
                    AppMethodBeat.o(105342);
                    return true;
                }
            });
        } else {
            listFiles = null;
        }
        if (listFiles == null || listFiles.length <= 0) {
            AppMethodBeat.o(105348);
        } else {
            for (File length : listFiles) {
                j += length.length();
            }
            AppMethodBeat.o(105348);
        }
        return j;
    }

    private static String xY(String str) {
        AppMethodBeat.i(105353);
        String str2 = gXo + str + "/";
        j.aih(str2);
        try {
            new File(str2, ".nomedia").createNewFile();
        } catch (Exception e) {
        }
        AppMethodBeat.o(105353);
        return str2;
    }

    static /* synthetic */ String bu(String str, String str2) {
        AppMethodBeat.i(105355);
        byte[] decrypt = new v().decrypt(bo.anf(str), str2.getBytes());
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(105355);
            return null;
        }
        String str3 = new String(decrypt);
        AppMethodBeat.o(105355);
        return str3;
    }

    static /* synthetic */ long ya(String str) {
        AppMethodBeat.i(105357);
        FileInputStream fileInputStream = new FileInputStream(str);
        CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        do {
        } while (checkedInputStream.read(new byte[2048]) >= 0);
        long value = checkedInputStream.getChecksum().getValue();
        bo.b(checkedInputStream);
        bo.b(fileInputStream);
        AppMethodBeat.o(105357);
        return value;
    }

    static /* synthetic */ String bv(String str, String str2) {
        AppMethodBeat.i(105358);
        String cd = bo.cd(new v().encrypt(str.getBytes(), str2.getBytes()));
        AppMethodBeat.o(105358);
        return cd;
    }
}
