package com.tencent.mm.plugin.backup.bakoldlogic.a;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.btt;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    private static List<String> elZ = null;

    public static List<String> Ko() {
        AppMethodBeat.i(17738);
        if (elZ != null) {
            List list = elZ;
            AppMethodBeat.o(17738);
            return list;
        }
        elZ = new LinkedList();
        for (Object add : t.fkY) {
            elZ.add(add);
        }
        elZ.add("weixin");
        elZ.add("weibo");
        elZ.add("qqmail");
        elZ.add("fmessage");
        elZ.add("tmessage");
        elZ.add("qmessage");
        elZ.add("qqsync");
        elZ.add("floatbottle");
        elZ.add("lbsapp");
        elZ.add("shakeapp");
        elZ.add("medianote");
        elZ.add("qqfriend");
        elZ.add("readerapp");
        elZ.add("newsapp");
        elZ.add("blogapp");
        elZ.add("facebookapp");
        elZ.add("masssendapp");
        elZ.add("meishiapp");
        elZ.add("feedsapp");
        elZ.add("voipapp");
        elZ.add("officialaccounts");
        elZ.add("helper_entry");
        elZ.add("pc_share");
        elZ.add("cardpackage");
        elZ.add("voicevoipapp");
        elZ.add("voiceinputapp");
        elZ.add("linkedinplugin");
        elZ.add("appbrandcustomerservicemsg");
        List<String> list2 = elZ;
        AppMethodBeat.o(17738);
        return list2;
    }

    public static String Fb(String str) {
        AppMethodBeat.i(17739);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.o(17739);
            return str2;
        }
        String x = g.x(str.getBytes());
        str2 = "";
        String str3 = "";
        if (x.length() > 0) {
            str2 = x.charAt(0) + "/";
        }
        if (x.length() >= 2) {
            str3 = x.charAt(1) + "/";
        }
        str2 = str2 + str3;
        AppMethodBeat.o(17739);
        return str2;
    }

    public static String aUy() {
        AppMethodBeat.i(17740);
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        String stringBuilder2 = stringBuilder.append(c.getAccPath()).append("backup/").toString();
        AppMethodBeat.o(17740);
        return stringBuilder2;
    }

    public static void Fo(String str) {
        AppMethodBeat.i(17741);
        e.tf(str);
        e.tf(str + "backupItem/");
        e.tf(str + "backupMeida/");
        AppMethodBeat.o(17741);
    }

    /* JADX WARNING: Missing block: B:9:0x00a1, code skipped:
            if (r18.startsWith(r2.getPath()) != false) goto L_0x00a3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(long j, PLong pLong, PLong pLong2, String str) {
        AppMethodBeat.i(17742);
        StatFs statFs = new StatFs(h.getExternalStorageDirectory().getPath());
        pLong.value = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        File dataDirectory = h.getDataDirectory();
        statFs = new StatFs(dataDirectory.getPath());
        long blockCount = (long) statFs.getBlockCount();
        long availableBlocks = (long) statFs.getAvailableBlocks();
        pLong2.value = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        ab.i("MicroMsg.BakUtil", "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d", Long.valueOf(pLong.value), Long.valueOf(pLong2.value), Long.valueOf(j));
        if (blockCount <= 0) {
            AppMethodBeat.o(17742);
            return false;
        } else if (blockCount - availableBlocks < 0) {
            AppMethodBeat.o(17742);
            return false;
        } else {
            if (pLong.value != pLong2.value) {
            }
            pLong.value = 0;
            if (j > pLong2.value) {
                AppMethodBeat.o(17742);
                return false;
            }
            AppMethodBeat.o(17742);
            return true;
        }
    }

    public static boolean Fd(String str) {
        AppMethodBeat.i(17743);
        if (str == null) {
            AppMethodBeat.o(17743);
            return false;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        if (br.z(str, "msg") != null) {
            AppMethodBeat.o(17743);
            return true;
        }
        AppMethodBeat.o(17743);
        return false;
    }

    public static String Fp(String str) {
        AppMethodBeat.i(17744);
        String str2;
        if (str == null || str.equals("")) {
            str2 = "";
            AppMethodBeat.o(17744);
            return str2;
        }
        str2 = aUy() + "backupMeida/" + Fb(str) + str;
        AppMethodBeat.o(17744);
        return str2;
    }

    public static int c(gu guVar, int i) {
        AppMethodBeat.i(17745);
        int asZ;
        if (guVar.vJf != i) {
            if (!(guVar.vJc == null || guVar.vJb == null)) {
                Iterator it = guVar.vJc.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (((btt) it.next()).wVK == i) {
                        asZ = (int) e.asZ(Fp(((bts) guVar.vJb.get(i2)).wVI));
                        AppMethodBeat.o(17745);
                        return asZ;
                    }
                    i2++;
                }
            }
            AppMethodBeat.o(17745);
            return 0;
        } else if (guVar.vJd == null) {
            AppMethodBeat.o(17745);
            return 0;
        } else {
            asZ = guVar.vJd.getBuffer().wR.length;
            AppMethodBeat.o(17745);
            return asZ;
        }
    }

    /* JADX WARNING: Missing block: B:20:0x0062, code skipped:
            if (com.tencent.mm.vfs.e.ct(Fp(r0)) == false) goto L_0x0068;
     */
    /* JADX WARNING: Missing block: B:21:0x0064, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(17746);
     */
    /* JADX WARNING: Missing block: B:22:0x0068, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(17746);
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            return r0;
     */
    /* JADX WARNING: Missing block: B:33:?, code skipped:
            return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String a(gu guVar, int i, String str) {
        AppMethodBeat.i(17746);
        String str2;
        if (guVar.vJf != i || guVar.vJd == null) {
            int i2 = 0;
            if (guVar.vJc != null && guVar.vJb != null) {
                Iterator it = guVar.vJc.iterator();
                while (true) {
                    int i3 = i2;
                    if (!it.hasNext()) {
                        break;
                    } else if (((btt) it.next()).wVK == i) {
                        str2 = ((bts) guVar.vJb.get(i3)).wVI;
                        if (!bo.isNullOrNil(str) && !str2.endsWith(str)) {
                            i2 = (i3 + 1) + 1;
                        }
                    } else {
                        i2 = i3 + 1;
                    }
                }
            }
            AppMethodBeat.o(17746);
            return null;
        }
        str2 = g.x(guVar.vJd.getBuffer().wR);
        AppMethodBeat.o(17746);
        return str2;
    }

    public static String a(gu guVar, int i) {
        AppMethodBeat.i(17747);
        String a = a(guVar, i, null);
        AppMethodBeat.o(17747);
        return a;
    }

    public static byte[] b(gu guVar, int i) {
        AppMethodBeat.i(17748);
        byte[] e;
        if (guVar.vJf != i || guVar.vJd == null) {
            if (!(guVar.vJc == null || guVar.vJb == null)) {
                Iterator it = guVar.vJc.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (((btt) it.next()).wVK == i) {
                        String Fp = Fp(((bts) guVar.vJb.get(i2)).wVI);
                        i2 = (int) e.asZ(Fp);
                        if (i2 == 0 || i2 > 1048576) {
                            ab.e("MicroMsg.BakUtil", "thumb not exist or  too big!");
                            AppMethodBeat.o(17748);
                            return null;
                        }
                        e = e.e(Fp, 0, -1);
                        AppMethodBeat.o(17748);
                        return e;
                    }
                    i2++;
                }
            }
            AppMethodBeat.o(17748);
            return null;
        }
        e = guVar.vJd.getBuffer().wR;
        AppMethodBeat.o(17748);
        return e;
    }

    public static boolean b(gu guVar, int i, String str) {
        AppMethodBeat.i(17749);
        if (guVar.vJf != i || guVar.vJd == null) {
            String a = a(guVar, i, null);
            if (bo.isNullOrNil(a)) {
                AppMethodBeat.o(17749);
                return false;
            }
            e.y(Fp(a), str);
            AppMethodBeat.o(17749);
            return true;
        }
        byte[] bArr = guVar.vJd.getBuffer().wR;
        if (bArr.length <= 0) {
            AppMethodBeat.o(17749);
            return false;
        }
        e.b(str, bArr, bArr.length);
        AppMethodBeat.o(17749);
        return true;
    }

    public static int bC(String str, int i) {
        AppMethodBeat.i(17750);
        if (!bo.isNullOrNil(str)) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.BakUtil", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(17750);
        return i;
    }

    public static boolean d(gu guVar, int i) {
        AppMethodBeat.i(17751);
        if (guVar.vJf != i || guVar.vJd == null) {
            Iterator it = guVar.vJc.iterator();
            while (it.hasNext()) {
                if (((btt) it.next()).wVK == i) {
                    AppMethodBeat.o(17751);
                    return true;
                }
            }
            AppMethodBeat.o(17751);
            return false;
        }
        AppMethodBeat.o(17751);
        return true;
    }
}
