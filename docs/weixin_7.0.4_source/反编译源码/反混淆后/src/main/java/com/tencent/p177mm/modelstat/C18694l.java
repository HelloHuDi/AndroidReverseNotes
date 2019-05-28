package com.tencent.p177mm.modelstat;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelstat.p874a.C45455b.C264791;
import com.tencent.p177mm.network.p265a.C1889b.C1890a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C8900q;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.p215cf.C37634d;
import com.tencent.p177mm.p215cf.C37634d.C37636a;
import com.tencent.p177mm.p215cf.C45279c;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.p230g.p231a.C32649ub;
import com.tencent.p177mm.p230g.p231a.C42010ip;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C9784ad;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac;
import java.io.File;
import java.util.Map;

/* renamed from: com.tencent.mm.modelstat.l */
public final class C18694l extends C1890a implements C1201e {
    /* renamed from: b */
    public static long m29216b(File file, long j) {
        AppMethodBeat.m2504i(78748);
        long j2 = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                long b;
                if (listFiles[i].isDirectory()) {
                    b = C18694l.m29216b(listFiles[i], j);
                } else {
                    if (listFiles[i].length() > j) {
                        C4990ab.m7417i("MicroMsg.NetStatMsgExtension", "getFolderSize filesize:%s [%s]", Long.valueOf(listFiles[i].length()), listFiles[i].getPath());
                    }
                    b = listFiles[i].length();
                }
                j2 += b;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NetStatMsgExtension", "getFolderSize :%s", C5046bo.m7574l(e));
        }
        AppMethodBeat.m2505o(78748);
        return j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0356  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        AppMethodBeat.m2504i(78749);
        if (C1720g.m3534RN().mo5161QY()) {
            String str = c1197a.eAB.vED.wVI;
            C4990ab.m7411d("MicroMsg.NetStatMsgExtension", "onPreAddMessage %s", str);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(78749);
            } else {
                C4990ab.m7417i("MicroMsg.NetStatMsgExtension", "get ipxx cmd=%s", str);
                Map z = C5049br.m7595z(str, "cmd");
                String str2;
                if (z == null) {
                    Map z2 = C5049br.m7595z(str, "ClearCache");
                    if (z2 != null) {
                        long j = C5046bo.getLong((String) z2.get(".ClearCache.androidCacheMask"), 0);
                        str2 = (String) z2.get(".ClearCache.message");
                        Intent intent = new Intent();
                        intent.putExtra("key_mask", j);
                        intent.putExtra("key_message", str2);
                        C25985d.m41473f(C4996ah.getContext(), ".ui.ClearCacheUI", intent);
                    }
                } else {
                    int i = C5046bo.getInt((String) z.get(".cmd.trace.$code"), -1);
                    if (i <= 0) {
                        int i2 = C5046bo.getInt((String) z.get(".cmd.hprof.$type"), -1);
                        if (i2 > 0) {
                            C4990ab.m7411d("MicroMsg.NetStatMsgExtension", "hprof type: %d", Integer.valueOf(i2));
                            C45279c.m83487MK(i2);
                            AppMethodBeat.m2505o(78749);
                        } else {
                            if ("android".equalsIgnoreCase((String) z.get(".cmd.prconfig.$os"))) {
                                C4883b c42010ip = new C42010ip();
                                c42010ip.cDI.cDJ = (String) z.get(".cmd.prconfig.xml.$url");
                                c42010ip.cDI.cDK = (String) z.get(".cmd.prconfig.xml.$signature");
                                c42010ip.cDI.cDL = (String) z.get(".cmd.prconfig.$url");
                                c42010ip.cDI.cDM = (String) z.get(".cmd.prconfig.$signature");
                                C4879a.xxA.mo10048a(c42010ip, Looper.myLooper());
                                AppMethodBeat.m2505o(78749);
                            } else {
                                File file;
                                i2 = C5046bo.getInt((String) z.get(".cmd.clearfile.$fb"), -1);
                                final long j2;
                                if (i2 == 1) {
                                    j2 = (long) C5046bo.getInt((String) z.get(".cmd.clearfile.$ps"), 1048576);
                                    C1720g.m3539RS().mo10302aa(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.m2504i(78743);
                                            long anU = C5046bo.anU();
                                            long b = C18694l.m29216b(new File(C1720g.m3536RP().cachePath), j2);
                                            C4990ab.m7417i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(b), C1720g.m3536RP().cachePath);
                                            b = C18694l.m29216b(new File(C1720g.m3536RP().eJL), j2);
                                            C4990ab.m7417i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(b), C1720g.m3536RP().eJL);
                                            b = C18694l.m29216b(new File(C1720g.m3536RP().eJL), j2);
                                            C4990ab.m7417i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(b), C1720g.m3536RP().eJL);
                                            b = C18694l.m29216b(new File(C1720g.m3536RP().eJM), j2);
                                            C4990ab.m7417i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(b), C1720g.m3536RP().eJM);
                                            b = C18694l.m29216b(new File(C5128ac.eSj), j2);
                                            C4990ab.m7417i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(b), C5128ac.eSj);
                                            C4990ab.m7417i("MicroMsg.NetStatMsgExtension", "clearfile finish %s", Long.valueOf(C5046bo.anU() - anU));
                                            AppMethodBeat.m2505o(78743);
                                        }
                                    });
                                } else if (i2 == 2) {
                                    str2 = (String) z.get(".cmd.clearfile.$pd");
                                    file = new File(str2);
                                    String str3 = "MicroMsg.NetStatMsgExtension";
                                    String str4 = "clearfile delete :[%s] length:%s";
                                    Object[] objArr = new Object[2];
                                    objArr[0] = str2;
                                    objArr[1] = Long.valueOf(file.exists() ? file.length() : -1);
                                    C4990ab.m7417i(str3, str4, objArr);
                                    C1173e.deleteFile(str2);
                                    file = new File(str2);
                                    String str5 = "MicroMsg.NetStatMsgExtension";
                                    String str6 = "clearfile delete finish :[%s] length:%s";
                                    Object[] objArr2 = new Object[2];
                                    objArr2[0] = str2;
                                    if (file.exists()) {
                                        j2 = file.length();
                                    } else {
                                        j2 = -1;
                                    }
                                    objArr2[1] = Long.valueOf(j2);
                                    C4990ab.m7417i(str5, str6, objArr2);
                                } else if (i2 == 3) {
                                    C4990ab.m7416i("MicroMsg.NetStatMsgExtension", "running  clearfile start:" + C1720g.m3536RP().mo5237Rv() + ".tem");
                                    C1173e.deleteFile(C1720g.m3536RP().mo5237Rv() + ".tem");
                                    C1173e.deleteFile(C1720g.m3536RP().mo5238Rw() + ".tem");
                                    C4990ab.m7416i("MicroMsg.NetStatMsgExtension", "running  clearfile end:" + C1720g.m3536RP().mo5237Rv() + ".tem");
                                }
                                final int i3 = C5046bo.getInt((String) z.get(".cmd.updzh.$pt"), -1);
                                str2 = (String) z.get(".cmd.updzh.$pd");
                                C4990ab.m7411d("MicroMsg.NetStatMsgExtension", "StackReportUploader pt:%d pd:%s", Integer.valueOf(i3), str2);
                                if (i3 > 0 && !C5046bo.isNullOrNil(str2)) {
                                    C1720g.m3539RS().mo10302aa(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.m2504i(78744);
                                            switch (i3) {
                                                case 1:
                                                    C9784ad.m17421a(C1720g.m3536RP().eJM + str2, C1853r.m3846Yz(), false, true);
                                                    AppMethodBeat.m2505o(78744);
                                                    return;
                                                case 2:
                                                    C9784ad.m17421a(C1720g.m3536RP().cachePath + str2, C1853r.m3846Yz(), false, true);
                                                    AppMethodBeat.m2505o(78744);
                                                    return;
                                                case 3:
                                                    C9784ad.m17421a(str2, C1853r.m3846Yz(), false, true);
                                                    break;
                                            }
                                            AppMethodBeat.m2505o(78744);
                                        }

                                        public final String toString() {
                                            AppMethodBeat.m2504i(78745);
                                            String str = super.toString() + "|onPreAddMessage";
                                            AppMethodBeat.m2505o(78745);
                                            return str;
                                        }
                                    });
                                }
                                i = C5046bo.getInt((String) z.get(".cmd.uploadx5log.type"), -1);
                                if (i > 0) {
                                    C4990ab.m7417i("MicroMsg.UploadX5Log", "upload, date %s,process %s,type %d", (String) z.get(".cmd.uploadx5log.date"), (String) z.get(".cmd.uploadx5log.process"), Integer.valueOf(i));
                                    if (i != 1) {
                                        str2 = C1761b.eSl + "/Android/data/com.tencent.mm/files/tbslog/tbslog.txt";
                                        file = new File(str2);
                                        if (file.exists()) {
                                        }
                                    } else if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(r1)) {
                                        C4990ab.m7421w("MicroMsg.UploadX5Log", "date or process is null,date %s,process %s", str2, r1);
                                    } else {
                                        str2 = String.format("%s/tencent/tbs_live_log/com.tencent.mm/com.tencent.mm_%s_%s.livelog", new Object[]{C1761b.eSl, r1, str2});
                                        file = new File(str2);
                                        if (file.exists()) {
                                            C4990ab.m7416i("MicroMsg.UploadX5Log", "upload file not exists");
                                        } else {
                                            str2 = C8900q.m16038b(file, false, str2 + ".zip");
                                            if (str2 == null) {
                                                C4990ab.m7416i("MicroMsg.UploadX5Log", "zipPath is null");
                                            } else {
                                                file = new File(str2);
                                                if (file.exists()) {
                                                    C41930g.m74067da(file).mo60492h(new C264791(i));
                                                } else {
                                                    C4990ab.m7416i("MicroMsg.UploadX5Log", "upload zip file not exists");
                                                }
                                            }
                                        }
                                    }
                                    AppMethodBeat.m2505o(78749);
                                }
                            }
                        }
                    } else if (i == 6) {
                        C4879a.xxA.mo10055m(new C32649ub());
                        AppMethodBeat.m2505o(78749);
                    } else {
                        C37634d.dvV().mo60467c(new C37636a((String) z.get(".cmd.trace.$class"), i, C5046bo.getInt((String) z.get(".cmd.trace.$size"), 0), C5046bo.getInt((String) z.get(".cmd.trace.$type"), 0)));
                        AppMethodBeat.m2505o(78749);
                    }
                }
                C4990ab.dot();
                C1720g.m3540Rg().ftA.mo5541qs(str);
                try {
                    Thread.sleep(50, 0);
                } catch (Exception e) {
                }
                LogLogic.initIPxxLogInfo();
                MMProtocalJni.setProtocalJniLogLevel(new Xlog().getLogLevel());
                AppMethodBeat.m2505o(78749);
            }
        } else {
            C4990ab.m7412e("MicroMsg.NetStatMsgExtension", "skip ipxx stat while account not set");
            AppMethodBeat.m2505o(78749);
        }
        return null;
    }

    /* renamed from: a */
    public final void mo5474a(int i, int i2, String str, int i3, String str2, boolean z) {
        AppMethodBeat.m2504i(78750);
        final int i4 = i;
        final int i5 = i2;
        final String str3 = str;
        final int i6 = i3;
        final String str4 = str2;
        final boolean z2 = z;
        C1720g.m3539RS().mo10310m(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(78746);
                C18694l.m29217c(i4, i5, i6, z2);
                AppMethodBeat.m2505o(78746);
            }

            public final String toString() {
                AppMethodBeat.m2504i(78747);
                String str = super.toString() + "|report";
                AppMethodBeat.m2505o(78747);
                return str;
            }
        }, 3000);
        AppMethodBeat.m2505o(78750);
    }

    /* renamed from: u */
    public final void mo5475u(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(78751);
        if (!C1720g.m3534RN().mo5161QY()) {
            AppMethodBeat.m2505o(78751);
        } else if (C1720g.m3537RQ().eKi.eKC) {
            C4990ab.m7417i("MicroMsg.NetStatMsgExtension", "reportNetFlow wifi[%d, %d] mobile[%d, %d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            if (i <= 0) {
                i = 0;
            }
            if (i2 <= 0) {
                i2 = 0;
            }
            C9711n.m17283I(i, i2, 0);
            if (i3 <= 0) {
                i3 = 0;
            }
            if (i4 <= 0) {
                i4 = 0;
            }
            C9711n.m17284J(i3, i4, 0);
            AppMethodBeat.m2505o(78751);
        } else {
            C4990ab.m7416i("MicroMsg.NetStatMsgExtension", "kernel has not startup");
            AppMethodBeat.m2505o(78751);
        }
    }

    /* renamed from: c */
    public static void m29217c(int i, int i2, int i3, boolean z) {
        AppMethodBeat.m2504i(78752);
        if (C1720g.m3534RN().mo5161QY()) {
            switch (i) {
                case 4:
                    C4990ab.m7410d("MicroMsg.NetStatMsgExtension", "recv bytes flow:".concat(String.valueOf(i3)));
                    if (z) {
                        C9711n.m17283I(i3, 0, i2);
                        AppMethodBeat.m2505o(78752);
                        return;
                    }
                    C9711n.m17284J(i3, 0, i2);
                    AppMethodBeat.m2505o(78752);
                    return;
                case 5:
                    C4990ab.m7410d("MicroMsg.NetStatMsgExtension", "send bytes flow:".concat(String.valueOf(i3)));
                    if (z) {
                        C9711n.m17283I(0, i3, i2);
                        AppMethodBeat.m2505o(78752);
                        return;
                    }
                    C9711n.m17284J(0, i3, i2);
                    AppMethodBeat.m2505o(78752);
                    return;
                case 8:
                    C4997aj.amA("dns_failed_report");
                    break;
            }
            AppMethodBeat.m2505o(78752);
            return;
        }
        AppMethodBeat.m2505o(78752);
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
    }
}
