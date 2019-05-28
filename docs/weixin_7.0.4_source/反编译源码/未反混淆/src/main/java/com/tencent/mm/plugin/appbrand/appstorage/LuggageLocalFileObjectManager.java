package com.tencent.mm.plugin.appbrand.appstorage;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
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
import java.util.List;
import java.util.Locale;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;

public final class LuggageLocalFileObjectManager {
    private static final v gYh = new v() {
        public final String toString() {
            return "AppBrandLocalMediaObject::Nil";
        }
    };
    private final String gXQ;
    private final String gXR;
    private final String gXS;
    private final Collection<a> gYg;

    interface a {
        v a(v vVar);

        com.tencent.mm.vending.j.a bC(String str, String str2);

        v yq(String str);

        v yr(String str);
    }

    final class b implements a {
        private b() {
        }

        /* synthetic */ b(LuggageLocalFileObjectManager luggageLocalFileObjectManager, byte b) {
            this();
        }

        public final String toString() {
            return "V2MediaObjectInfoHandler";
        }

        public final v yq(String str) {
            String str2 = null;
            AppMethodBeat.i(105419);
            if (str.startsWith("store_") || str.startsWith("tmp_")) {
                String awJ = org.apache.commons.a.b.awJ(str);
                String replaceFirst = str.replaceFirst("store_", "").replaceFirst("tmp_", "");
                if (!bo.isNullOrNil(awJ)) {
                    replaceFirst = replaceFirst.replaceFirst(".".concat(String.valueOf(awJ)), "");
                }
                Object awV;
                if (bo.isNullOrNil(replaceFirst)) {
                    awV = LuggageLocalFileObjectManager.gYh;
                    AppMethodBeat.o(105419);
                    return awV;
                }
                try {
                    str2 = LuggageLocalFileObjectManager.bA(replaceFirst, LuggageLocalFileObjectManager.this.gXR);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "retrieveMediaObject, decrypt exp ", new Object[0]);
                }
                if (bo.isNullOrNil(str2)) {
                    ab.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
                    awV = LuggageLocalFileObjectManager.gYh;
                    AppMethodBeat.o(105419);
                    return awV;
                }
                String[] split = str2.split("\\|");
                if (split == null || split.length != 2) {
                    awV = LuggageLocalFileObjectManager.gYh;
                    AppMethodBeat.o(105419);
                    return awV;
                }
                str2 = str.startsWith("store_") ? "store_" : "tmp_";
                String str3 = LuggageLocalFileObjectManager.b(LuggageLocalFileObjectManager.this) + str2 + replaceFirst;
                long j = bo.getLong(split[0], 0);
                String str4 = split[1];
                if (str4.equalsIgnoreCase(awJ)) {
                    try {
                        if (j != LuggageLocalFileObjectManager.yp(str3)) {
                            ab.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s)", Long.valueOf(LuggageLocalFileObjectManager.yp(str3)), Long.valueOf(j), str);
                            awV = LuggageLocalFileObjectManager.gYh;
                            AppMethodBeat.o(105419);
                            return awV;
                        }
                        v vVar = new v();
                        vVar.czD = LuggageLocalFileObjectManager.this.gXS + str;
                        vVar.fnQ = str3;
                        vVar.mimeType = com.tencent.mm.sdk.f.b.anI(str4);
                        vVar.gXl = str2.equalsIgnoreCase("store_");
                        File file = new File(vVar.fnQ);
                        vVar.gXm = file.lastModified();
                        vVar.gjQ = file.length();
                        AppMethodBeat.o(105419);
                        return vVar;
                    } catch (IOException e2) {
                        ab.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", bo.l(e2));
                        awV = LuggageLocalFileObjectManager.gYh;
                        AppMethodBeat.o(105419);
                        return awV;
                    }
                }
                awV = LuggageLocalFileObjectManager.gYh;
                AppMethodBeat.o(105419);
                return awV;
            }
            AppMethodBeat.o(105419);
            return str2;
        }

        public final v a(v vVar) {
            AppMethodBeat.i(105420);
            if (vVar == null) {
                AppMethodBeat.o(105420);
                return null;
            }
            String replaceFirst = vVar.fnQ.replaceFirst("tmp_", "store_");
            if (i.bx(vVar.fnQ, replaceFirst)) {
                v vVar2 = new v();
                vVar2.fnQ = replaceFirst;
                vVar2.czD = vVar.czD.replaceFirst("tmp_", "store_");
                vVar2.gjQ = vVar.gjQ;
                vVar2.eov = vVar.eov;
                vVar2.gXm = new File(vVar2.fnQ).lastModified();
                vVar2.mimeType = vVar.mimeType;
                vVar2.gXl = true;
                AppMethodBeat.o(105420);
                return vVar2;
            }
            AppMethodBeat.o(105420);
            return null;
        }

        public final com.tencent.mm.vending.j.a bC(String str, String str2) {
            AppMethodBeat.i(105421);
            String bc = bo.bc(str2, "unknown");
            try {
                String bB;
                Long valueOf = Long.valueOf(LuggageLocalFileObjectManager.yp(str));
                try {
                    bB = LuggageLocalFileObjectManager.bB(String.format(Locale.US, "%d|%s", new Object[]{valueOf, bc}), LuggageLocalFileObjectManager.this.gXR);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "attachMediaObject, enc exp = ", new Object[0]);
                    bB = null;
                }
                if (bo.isNullOrNil(bB)) {
                    AppMethodBeat.o(105421);
                    return null;
                }
                bB = "tmp_".concat(String.valueOf(bB));
                ab.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", LuggageLocalFileObjectManager.this.gXS + bB + (bo.isNullOrNil(bc) ? "" : ".".concat(String.valueOf(bc))), LuggageLocalFileObjectManager.b(LuggageLocalFileObjectManager.this) + bB);
                com.tencent.mm.vending.j.a i = com.tencent.mm.vending.j.a.i(bB, r1, bc);
                AppMethodBeat.o(105421);
                return i;
            } catch (Exception e2) {
                ab.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, get crc exp = %s", bo.l(e2));
                AppMethodBeat.o(105421);
                return null;
            }
        }

        public final v yr(String str) {
            String bA;
            AppMethodBeat.i(105422);
            String replaceFirst = str.replaceFirst("store_", "").replaceFirst("tmp_", "");
            try {
                bA = LuggageLocalFileObjectManager.bA(replaceFirst, LuggageLocalFileObjectManager.this.gXR);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "retrieveMediaObjectByRealFileName, dec exp = ", new Object[0]);
                bA = null;
            }
            if (bo.isNullOrNil(bA)) {
                AppMethodBeat.o(105422);
                return null;
            }
            String[] split = bA.split("\\|");
            if (split == null || split.length != 2) {
                AppMethodBeat.o(105422);
                return null;
            }
            bA = split[1];
            bA = LuggageLocalFileObjectManager.this.gXS + str + (bo.isNullOrNil(bA) ? "" : ".".concat(String.valueOf(bA)));
            v vVar = new v();
            vVar.czD = bA;
            vVar.fnQ = LuggageLocalFileObjectManager.b(LuggageLocalFileObjectManager.this) + str;
            vVar.eov = replaceFirst;
            vVar.gXl = str.startsWith("store_");
            File file = new File(vVar.fnQ);
            vVar.gXm = file.lastModified();
            vVar.gjQ = file.length();
            AppMethodBeat.o(105422);
            return vVar;
        }
    }

    static /* synthetic */ String b(LuggageLocalFileObjectManager luggageLocalFileObjectManager) {
        AppMethodBeat.i(105435);
        String awU = luggageLocalFileObjectManager.awU();
        AppMethodBeat.o(105435);
        return awU;
    }

    LuggageLocalFileObjectManager(String str, String str2, String str3) {
        AppMethodBeat.i(105423);
        this.gXQ = new File(str).getAbsolutePath() + "/";
        this.gXR = str2;
        this.gXS = str3;
        LinkedList linkedList = new LinkedList();
        linkedList.add(new b(this, (byte) 0));
        this.gYg = Collections.unmodifiableCollection(linkedList);
        AppMethodBeat.o(105423);
    }

    @Keep
    public final String genMediaFilePath(String str) {
        AppMethodBeat.i(105424);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(105424);
            return null;
        }
        String str2 = awU() + str;
        AppMethodBeat.o(105424);
        return str2;
    }

    public final List<v> awR() {
        AppMethodBeat.i(105425);
        File[] awS = awS();
        if (awS == null || awS.length <= 0) {
            AppMethodBeat.o(105425);
            return null;
        }
        List<v> linkedList = new LinkedList();
        for (File name : awS) {
            v yn = yn(name.getName());
            if (yn != null) {
                linkedList.add(yn);
            }
        }
        AppMethodBeat.o(105425);
        return linkedList;
    }

    /* Access modifiers changed, original: final */
    public final File[] awS() {
        AppMethodBeat.i(105426);
        File file = new File(awU());
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    AppMethodBeat.i(105417);
                    if (!file.exists() || file.isDirectory() || bo.isNullOrNil(file.getName()) || !file.getName().startsWith("store_")) {
                        AppMethodBeat.o(105417);
                        return false;
                    }
                    AppMethodBeat.o(105417);
                    return true;
                }
            });
            AppMethodBeat.o(105426);
            return listFiles;
        }
        AppMethodBeat.o(105426);
        return null;
    }

    private <T extends v> T a(String str, Class<T> cls, String str2, boolean z) {
        AppMethodBeat.i(105428);
        if (e.ct(str)) {
            String awJ = org.apache.commons.a.b.awJ(str);
            if (!bo.isNullOrNil(awJ)) {
                str2 = awJ;
            }
            com.tencent.mm.vending.j.a aVar = null;
            for (a bC : this.gYg) {
                aVar = bC.bC(str, str2);
                if (aVar != null) {
                    break;
                }
            }
            com.tencent.mm.vending.j.a aVar2 = aVar;
            String str3;
            if (aVar2 == null || aVar2.size() < 2) {
                str3 = "MicroMsg.AppBrand.LuggageLocalFileObjectManager";
                String str4 = "attachCast, no handler return correct info, attach.size = %d";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(aVar2 == null ? -1 : aVar2.size());
                ab.e(str3, str4, objArr);
                AppMethodBeat.o(105428);
                return null;
            }
            try {
                T t = (v) cls.newInstance();
                t.czD = (String) aVar2.get(0);
                t.mimeType = com.tencent.mm.sdk.f.b.anI(str2);
                t.fnQ = (String) aVar2.get(1);
                if (bo.isNullOrNil(t.fnQ)) {
                    ab.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
                    AppMethodBeat.o(105428);
                    return null;
                }
                int i;
                t.eov = bo.bc((String) aVar2.get(3), bo.bc(str2, "unknown"));
                str3 = t.fnQ;
                if (z && i.bx(str, str3)) {
                    i = 1;
                } else {
                    if (!z) {
                        if (m.copyFile(str, str3)) {
                            i = 1;
                        }
                    }
                    i = 0;
                }
                if (i != 0) {
                    File file = new File(t.fnQ);
                    t.gjQ = file.length();
                    t.gXm = file.lastModified();
                    AppMethodBeat.o(105428);
                    return t;
                }
                AppMethodBeat.o(105428);
                return null;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrand.LuggageLocalFileObjectManager", e, "", new Object[0]);
            }
        } else {
            AppMethodBeat.o(105428);
            return null;
        }
    }

    public final v k(String str, String str2, boolean z) {
        AppMethodBeat.i(105429);
        v a = a(str, v.class, str2, z);
        AppMethodBeat.o(105429);
        return a;
    }

    public final v a(v vVar) {
        AppMethodBeat.i(105431);
        v vVar2 = null;
        for (a a : this.gYg) {
            vVar2 = a.a(vVar);
            if (vVar2 != null) {
                break;
            }
        }
        AppMethodBeat.o(105431);
        return vVar2;
    }

    /* Access modifiers changed, original: final */
    public final v yn(String str) {
        v vVar = null;
        AppMethodBeat.i(105432);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(105432);
        } else {
            for (a yr : this.gYg) {
                vVar = yr.yr(str);
                if (vVar != null) {
                    break;
                }
            }
            AppMethodBeat.o(105432);
        }
        return vVar;
    }

    @Deprecated
    public final v yo(String str) {
        AppMethodBeat.i(105433);
        if (bo.isNullOrNil(str) || !str.startsWith(this.gXS)) {
            ab.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, invalid args, localId(%s)", str);
            AppMethodBeat.o(105433);
            return null;
        }
        v yq;
        String substring = str.substring(this.gXS.length());
        v vVar = null;
        for (a yq2 : this.gYg) {
            yq = yq2.yq(substring);
            if (yq != null) {
                ab.i("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, handled by %s, result = %s", yq2.toString(), yq);
                break;
            }
            vVar = yq;
        }
        yq = vVar;
        if (gYh == yq) {
            AppMethodBeat.o(105433);
            return null;
        }
        AppMethodBeat.o(105433);
        return yq;
    }

    static {
        AppMethodBeat.i(105438);
        AppMethodBeat.o(105438);
    }

    public final List<v> awT() {
        File[] listFiles;
        List<v> list = null;
        AppMethodBeat.i(105427);
        File file = new File(awU());
        if (file.exists() && file.isDirectory()) {
            listFiles = file.listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    AppMethodBeat.i(105418);
                    if (!file.exists() || file.isDirectory() || bo.isNullOrNil(file.getName()) || !file.getName().startsWith("tmp_")) {
                        AppMethodBeat.o(105418);
                        return false;
                    }
                    AppMethodBeat.o(105418);
                    return true;
                }
            });
        } else {
            listFiles = null;
        }
        if (listFiles == null || listFiles.length <= 0) {
            AppMethodBeat.o(105427);
        } else {
            list = new LinkedList();
            for (File name : listFiles) {
                v yn = yn(name.getName());
                if (yn != null) {
                    list.add(yn);
                }
            }
            AppMethodBeat.o(105427);
        }
        return list;
    }

    private String awU() {
        AppMethodBeat.i(105430);
        j.aih(this.gXQ);
        try {
            new File(this.gXQ, ".nomedia").createNewFile();
        } catch (Exception e) {
        }
        String str = this.gXQ;
        AppMethodBeat.o(105430);
        return str;
    }

    static /* synthetic */ String bA(String str, String str2) {
        AppMethodBeat.i(105434);
        byte[] decrypt = new v().decrypt(bo.anf(str), str2.getBytes());
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(105434);
            return null;
        }
        String str3 = new String(decrypt);
        AppMethodBeat.o(105434);
        return str3;
    }

    static /* synthetic */ long yp(String str) {
        AppMethodBeat.i(105436);
        FileInputStream fileInputStream = new FileInputStream(str);
        CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        do {
        } while (checkedInputStream.read(new byte[2048]) >= 0);
        long value = checkedInputStream.getChecksum().getValue();
        bo.b(checkedInputStream);
        bo.b(fileInputStream);
        AppMethodBeat.o(105436);
        return value;
    }

    static /* synthetic */ String bB(String str, String str2) {
        AppMethodBeat.i(105437);
        String cd = bo.cd(new v().encrypt(str.getBytes(), str2.getBytes()));
        AppMethodBeat.o(105437);
        return cd;
    }
}
