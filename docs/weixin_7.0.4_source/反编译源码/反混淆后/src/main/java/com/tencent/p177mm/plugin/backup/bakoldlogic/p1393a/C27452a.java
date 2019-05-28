package com.tencent.p177mm.plugin.backup.bakoldlogic.p1393a;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.pointers.PLong;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.btt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.a.a */
public final class C27452a {
    private static List<String> elZ = null;

    /* renamed from: Ko */
    public static List<String> m43556Ko() {
        AppMethodBeat.m2504i(17738);
        if (elZ != null) {
            List list = elZ;
            AppMethodBeat.m2505o(17738);
            return list;
        }
        elZ = new LinkedList();
        for (Object add : C1855t.fkY) {
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
        AppMethodBeat.m2505o(17738);
        return list2;
    }

    /* renamed from: Fb */
    public static String m43552Fb(String str) {
        AppMethodBeat.m2504i(17739);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(17739);
            return str2;
        }
        String x = C1178g.m2591x(str.getBytes());
        str2 = "";
        String str3 = "";
        if (x.length() > 0) {
            str2 = x.charAt(0) + "/";
        }
        if (x.length() >= 2) {
            str3 = x.charAt(1) + "/";
        }
        str2 = str2 + str3;
        AppMethodBeat.m2505o(17739);
        return str2;
    }

    public static String aUy() {
        AppMethodBeat.m2504i(17740);
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        String stringBuilder2 = stringBuilder.append(C18628c.getAccPath()).append("backup/").toString();
        AppMethodBeat.m2505o(17740);
        return stringBuilder2;
    }

    /* renamed from: Fo */
    public static void m43554Fo(String str) {
        AppMethodBeat.m2504i(17741);
        C5730e.m8643tf(str);
        C5730e.m8643tf(str + "backupItem/");
        C5730e.m8643tf(str + "backupMeida/");
        AppMethodBeat.m2505o(17741);
    }

    /* JADX WARNING: Missing block: B:9:0x00a1, code skipped:
            if (r18.startsWith(r2.getPath()) != false) goto L_0x00a3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static boolean m43559a(long j, PLong pLong, PLong pLong2, String str) {
        AppMethodBeat.m2504i(17742);
        StatFs statFs = new StatFs(C1448h.getExternalStorageDirectory().getPath());
        pLong.value = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        File dataDirectory = C1448h.getDataDirectory();
        statFs = new StatFs(dataDirectory.getPath());
        long blockCount = (long) statFs.getBlockCount();
        long availableBlocks = (long) statFs.getAvailableBlocks();
        pLong2.value = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        C4990ab.m7417i("MicroMsg.BakUtil", "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d", Long.valueOf(pLong.value), Long.valueOf(pLong2.value), Long.valueOf(j));
        if (blockCount <= 0) {
            AppMethodBeat.m2505o(17742);
            return false;
        } else if (blockCount - availableBlocks < 0) {
            AppMethodBeat.m2505o(17742);
            return false;
        } else {
            if (pLong.value != pLong2.value) {
            }
            pLong.value = 0;
            if (j > pLong2.value) {
                AppMethodBeat.m2505o(17742);
                return false;
            }
            AppMethodBeat.m2505o(17742);
            return true;
        }
    }

    /* renamed from: Fd */
    public static boolean m43553Fd(String str) {
        AppMethodBeat.m2504i(17743);
        if (str == null) {
            AppMethodBeat.m2505o(17743);
            return false;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        if (C5049br.m7595z(str, "msg") != null) {
            AppMethodBeat.m2505o(17743);
            return true;
        }
        AppMethodBeat.m2505o(17743);
        return false;
    }

    /* renamed from: Fp */
    public static String m43555Fp(String str) {
        AppMethodBeat.m2504i(17744);
        String str2;
        if (str == null || str.equals("")) {
            str2 = "";
            AppMethodBeat.m2505o(17744);
            return str2;
        }
        str2 = C27452a.aUy() + "backupMeida/" + C27452a.m43552Fb(str) + str;
        AppMethodBeat.m2505o(17744);
        return str2;
    }

    /* renamed from: c */
    public static int m43563c(C40522gu c40522gu, int i) {
        AppMethodBeat.m2504i(17745);
        int asZ;
        if (c40522gu.vJf != i) {
            if (!(c40522gu.vJc == null || c40522gu.vJb == null)) {
                Iterator it = c40522gu.vJc.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (((btt) it.next()).wVK == i) {
                        asZ = (int) C5730e.asZ(C27452a.m43555Fp(((bts) c40522gu.vJb.get(i2)).wVI));
                        AppMethodBeat.m2505o(17745);
                        return asZ;
                    }
                    i2++;
                }
            }
            AppMethodBeat.m2505o(17745);
            return 0;
        } else if (c40522gu.vJd == null) {
            AppMethodBeat.m2505o(17745);
            return 0;
        } else {
            asZ = c40522gu.vJd.getBuffer().f1226wR.length;
            AppMethodBeat.m2505o(17745);
            return asZ;
        }
    }

    /* JADX WARNING: Missing block: B:20:0x0062, code skipped:
            if (com.tencent.p177mm.vfs.C5730e.m8628ct(com.tencent.p177mm.plugin.backup.bakoldlogic.p1393a.C27452a.m43555Fp(r0)) == false) goto L_0x0068;
     */
    /* JADX WARNING: Missing block: B:21:0x0064, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(17746);
     */
    /* JADX WARNING: Missing block: B:22:0x0068, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(17746);
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            return r0;
     */
    /* JADX WARNING: Missing block: B:33:?, code skipped:
            return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static String m43558a(C40522gu c40522gu, int i, String str) {
        AppMethodBeat.m2504i(17746);
        String str2;
        if (c40522gu.vJf != i || c40522gu.vJd == null) {
            int i2 = 0;
            if (c40522gu.vJc != null && c40522gu.vJb != null) {
                Iterator it = c40522gu.vJc.iterator();
                while (true) {
                    int i3 = i2;
                    if (!it.hasNext()) {
                        break;
                    } else if (((btt) it.next()).wVK == i) {
                        str2 = ((bts) c40522gu.vJb.get(i3)).wVI;
                        if (!C5046bo.isNullOrNil(str) && !str2.endsWith(str)) {
                            i2 = (i3 + 1) + 1;
                        }
                    } else {
                        i2 = i3 + 1;
                    }
                }
            }
            AppMethodBeat.m2505o(17746);
            return null;
        }
        str2 = C1178g.m2591x(c40522gu.vJd.getBuffer().f1226wR);
        AppMethodBeat.m2505o(17746);
        return str2;
    }

    /* renamed from: a */
    public static String m43557a(C40522gu c40522gu, int i) {
        AppMethodBeat.m2504i(17747);
        String a = C27452a.m43558a(c40522gu, i, null);
        AppMethodBeat.m2505o(17747);
        return a;
    }

    /* renamed from: b */
    public static byte[] m43561b(C40522gu c40522gu, int i) {
        AppMethodBeat.m2504i(17748);
        byte[] e;
        if (c40522gu.vJf != i || c40522gu.vJd == null) {
            if (!(c40522gu.vJc == null || c40522gu.vJb == null)) {
                Iterator it = c40522gu.vJc.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (((btt) it.next()).wVK == i) {
                        String Fp = C27452a.m43555Fp(((bts) c40522gu.vJb.get(i2)).wVI);
                        i2 = (int) C5730e.asZ(Fp);
                        if (i2 == 0 || i2 > 1048576) {
                            C4990ab.m7412e("MicroMsg.BakUtil", "thumb not exist or  too big!");
                            AppMethodBeat.m2505o(17748);
                            return null;
                        }
                        e = C5730e.m8632e(Fp, 0, -1);
                        AppMethodBeat.m2505o(17748);
                        return e;
                    }
                    i2++;
                }
            }
            AppMethodBeat.m2505o(17748);
            return null;
        }
        e = c40522gu.vJd.getBuffer().f1226wR;
        AppMethodBeat.m2505o(17748);
        return e;
    }

    /* renamed from: b */
    public static boolean m43560b(C40522gu c40522gu, int i, String str) {
        AppMethodBeat.m2504i(17749);
        if (c40522gu.vJf != i || c40522gu.vJd == null) {
            String a = C27452a.m43558a(c40522gu, i, null);
            if (C5046bo.isNullOrNil(a)) {
                AppMethodBeat.m2505o(17749);
                return false;
            }
            C5730e.m8644y(C27452a.m43555Fp(a), str);
            AppMethodBeat.m2505o(17749);
            return true;
        }
        byte[] bArr = c40522gu.vJd.getBuffer().f1226wR;
        if (bArr.length <= 0) {
            AppMethodBeat.m2505o(17749);
            return false;
        }
        C5730e.m8624b(str, bArr, bArr.length);
        AppMethodBeat.m2505o(17749);
        return true;
    }

    /* renamed from: bC */
    public static int m43562bC(String str, int i) {
        AppMethodBeat.m2504i(17750);
        if (!C5046bo.isNullOrNil(str)) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.BakUtil", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(17750);
        return i;
    }

    /* renamed from: d */
    public static boolean m43564d(C40522gu c40522gu, int i) {
        AppMethodBeat.m2504i(17751);
        if (c40522gu.vJf != i || c40522gu.vJd == null) {
            Iterator it = c40522gu.vJc.iterator();
            while (it.hasNext()) {
                if (((btt) it.next()).wVK == i) {
                    AppMethodBeat.m2505o(17751);
                    return true;
                }
            }
            AppMethodBeat.m2505o(17751);
            return false;
        }
        AppMethodBeat.m2505o(17751);
        return true;
    }
}
