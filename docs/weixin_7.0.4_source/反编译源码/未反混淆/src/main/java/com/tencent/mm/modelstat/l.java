package com.tencent.mm.modelstat;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.q;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.bp.d;
import com.tencent.mm.cf.c;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.network.a.b.a;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import java.io.File;
import java.util.Map;

public final class l extends a implements e {
    public static long b(File file, long j) {
        AppMethodBeat.i(78748);
        long j2 = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                long b;
                if (listFiles[i].isDirectory()) {
                    b = b(listFiles[i], j);
                } else {
                    if (listFiles[i].length() > j) {
                        ab.i("MicroMsg.NetStatMsgExtension", "getFolderSize filesize:%s [%s]", Long.valueOf(listFiles[i].length()), listFiles[i].getPath());
                    }
                    b = listFiles[i].length();
                }
                j2 += b;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.NetStatMsgExtension", "getFolderSize :%s", bo.l(e));
        }
        AppMethodBeat.o(78748);
        return j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0356  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final b b(e.a aVar) {
        AppMethodBeat.i(78749);
        if (g.RN().QY()) {
            String str = aVar.eAB.vED.wVI;
            ab.d("MicroMsg.NetStatMsgExtension", "onPreAddMessage %s", str);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(78749);
            } else {
                ab.i("MicroMsg.NetStatMsgExtension", "get ipxx cmd=%s", str);
                Map z = br.z(str, "cmd");
                String str2;
                if (z == null) {
                    Map z2 = br.z(str, "ClearCache");
                    if (z2 != null) {
                        long j = bo.getLong((String) z2.get(".ClearCache.androidCacheMask"), 0);
                        str2 = (String) z2.get(".ClearCache.message");
                        Intent intent = new Intent();
                        intent.putExtra("key_mask", j);
                        intent.putExtra("key_message", str2);
                        d.f(ah.getContext(), ".ui.ClearCacheUI", intent);
                    }
                } else {
                    int i = bo.getInt((String) z.get(".cmd.trace.$code"), -1);
                    if (i <= 0) {
                        int i2 = bo.getInt((String) z.get(".cmd.hprof.$type"), -1);
                        if (i2 > 0) {
                            ab.d("MicroMsg.NetStatMsgExtension", "hprof type: %d", Integer.valueOf(i2));
                            c.MK(i2);
                            AppMethodBeat.o(78749);
                        } else {
                            if ("android".equalsIgnoreCase((String) z.get(".cmd.prconfig.$os"))) {
                                com.tencent.mm.sdk.b.b ipVar = new ip();
                                ipVar.cDI.cDJ = (String) z.get(".cmd.prconfig.xml.$url");
                                ipVar.cDI.cDK = (String) z.get(".cmd.prconfig.xml.$signature");
                                ipVar.cDI.cDL = (String) z.get(".cmd.prconfig.$url");
                                ipVar.cDI.cDM = (String) z.get(".cmd.prconfig.$signature");
                                com.tencent.mm.sdk.b.a.xxA.a(ipVar, Looper.myLooper());
                                AppMethodBeat.o(78749);
                            } else {
                                File file;
                                i2 = bo.getInt((String) z.get(".cmd.clearfile.$fb"), -1);
                                final long j2;
                                if (i2 == 1) {
                                    j2 = (long) bo.getInt((String) z.get(".cmd.clearfile.$ps"), 1048576);
                                    g.RS().aa(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(78743);
                                            long anU = bo.anU();
                                            long b = l.b(new File(g.RP().cachePath), j2);
                                            ab.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(b), g.RP().cachePath);
                                            b = l.b(new File(g.RP().eJL), j2);
                                            ab.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(b), g.RP().eJL);
                                            b = l.b(new File(g.RP().eJL), j2);
                                            ab.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(b), g.RP().eJL);
                                            b = l.b(new File(g.RP().eJM), j2);
                                            ab.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(b), g.RP().eJM);
                                            b = l.b(new File(ac.eSj), j2);
                                            ab.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(b), ac.eSj);
                                            ab.i("MicroMsg.NetStatMsgExtension", "clearfile finish %s", Long.valueOf(bo.anU() - anU));
                                            AppMethodBeat.o(78743);
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
                                    ab.i(str3, str4, objArr);
                                    com.tencent.mm.a.e.deleteFile(str2);
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
                                    ab.i(str5, str6, objArr2);
                                } else if (i2 == 3) {
                                    ab.i("MicroMsg.NetStatMsgExtension", "running  clearfile start:" + g.RP().Rv() + ".tem");
                                    com.tencent.mm.a.e.deleteFile(g.RP().Rv() + ".tem");
                                    com.tencent.mm.a.e.deleteFile(g.RP().Rw() + ".tem");
                                    ab.i("MicroMsg.NetStatMsgExtension", "running  clearfile end:" + g.RP().Rv() + ".tem");
                                }
                                final int i3 = bo.getInt((String) z.get(".cmd.updzh.$pt"), -1);
                                str2 = (String) z.get(".cmd.updzh.$pd");
                                ab.d("MicroMsg.NetStatMsgExtension", "StackReportUploader pt:%d pd:%s", Integer.valueOf(i3), str2);
                                if (i3 > 0 && !bo.isNullOrNil(str2)) {
                                    g.RS().aa(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(78744);
                                            switch (i3) {
                                                case 1:
                                                    ad.a(g.RP().eJM + str2, r.Yz(), false, true);
                                                    AppMethodBeat.o(78744);
                                                    return;
                                                case 2:
                                                    ad.a(g.RP().cachePath + str2, r.Yz(), false, true);
                                                    AppMethodBeat.o(78744);
                                                    return;
                                                case 3:
                                                    ad.a(str2, r.Yz(), false, true);
                                                    break;
                                            }
                                            AppMethodBeat.o(78744);
                                        }

                                        public final String toString() {
                                            AppMethodBeat.i(78745);
                                            String str = super.toString() + "|onPreAddMessage";
                                            AppMethodBeat.o(78745);
                                            return str;
                                        }
                                    });
                                }
                                i = bo.getInt((String) z.get(".cmd.uploadx5log.type"), -1);
                                if (i > 0) {
                                    ab.i("MicroMsg.UploadX5Log", "upload, date %s,process %s,type %d", (String) z.get(".cmd.uploadx5log.date"), (String) z.get(".cmd.uploadx5log.process"), Integer.valueOf(i));
                                    if (i != 1) {
                                        str2 = com.tencent.mm.loader.j.b.eSl + "/Android/data/com.tencent.mm/files/tbslog/tbslog.txt";
                                        file = new File(str2);
                                        if (file.exists()) {
                                        }
                                    } else if (bo.isNullOrNil(str2) || bo.isNullOrNil(r1)) {
                                        ab.w("MicroMsg.UploadX5Log", "date or process is null,date %s,process %s", str2, r1);
                                    } else {
                                        str2 = String.format("%s/tencent/tbs_live_log/com.tencent.mm/com.tencent.mm_%s_%s.livelog", new Object[]{com.tencent.mm.loader.j.b.eSl, r1, str2});
                                        file = new File(str2);
                                        if (file.exists()) {
                                            ab.i("MicroMsg.UploadX5Log", "upload file not exists");
                                        } else {
                                            str2 = q.b(file, false, str2 + ".zip");
                                            if (str2 == null) {
                                                ab.i("MicroMsg.UploadX5Log", "zipPath is null");
                                            } else {
                                                file = new File(str2);
                                                if (file.exists()) {
                                                    com.tencent.mm.ci.g.da(file).h(new com.tencent.mm.modelstat.a.b.AnonymousClass1(i));
                                                } else {
                                                    ab.i("MicroMsg.UploadX5Log", "upload zip file not exists");
                                                }
                                            }
                                        }
                                    }
                                    AppMethodBeat.o(78749);
                                }
                            }
                        }
                    } else if (i == 6) {
                        com.tencent.mm.sdk.b.a.xxA.m(new ub());
                        AppMethodBeat.o(78749);
                    } else {
                        com.tencent.mm.cf.d.dvV().c(new com.tencent.mm.cf.d.a((String) z.get(".cmd.trace.$class"), i, bo.getInt((String) z.get(".cmd.trace.$size"), 0), bo.getInt((String) z.get(".cmd.trace.$type"), 0)));
                        AppMethodBeat.o(78749);
                    }
                }
                ab.dot();
                g.Rg().ftA.qs(str);
                try {
                    Thread.sleep(50, 0);
                } catch (Exception e) {
                }
                LogLogic.initIPxxLogInfo();
                MMProtocalJni.setProtocalJniLogLevel(new Xlog().getLogLevel());
                AppMethodBeat.o(78749);
            }
        } else {
            ab.e("MicroMsg.NetStatMsgExtension", "skip ipxx stat while account not set");
            AppMethodBeat.o(78749);
        }
        return null;
    }

    public final void a(int i, int i2, String str, int i3, String str2, boolean z) {
        AppMethodBeat.i(78750);
        final int i4 = i;
        final int i5 = i2;
        final String str3 = str;
        final int i6 = i3;
        final String str4 = str2;
        final boolean z2 = z;
        g.RS().m(new Runnable() {
            public final void run() {
                AppMethodBeat.i(78746);
                l.c(i4, i5, i6, z2);
                AppMethodBeat.o(78746);
            }

            public final String toString() {
                AppMethodBeat.i(78747);
                String str = super.toString() + "|report";
                AppMethodBeat.o(78747);
                return str;
            }
        }, 3000);
        AppMethodBeat.o(78750);
    }

    public final void u(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(78751);
        if (!g.RN().QY()) {
            AppMethodBeat.o(78751);
        } else if (g.RQ().eKi.eKC) {
            ab.i("MicroMsg.NetStatMsgExtension", "reportNetFlow wifi[%d, %d] mobile[%d, %d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            if (i <= 0) {
                i = 0;
            }
            if (i2 <= 0) {
                i2 = 0;
            }
            n.I(i, i2, 0);
            if (i3 <= 0) {
                i3 = 0;
            }
            if (i4 <= 0) {
                i4 = 0;
            }
            n.J(i3, i4, 0);
            AppMethodBeat.o(78751);
        } else {
            ab.i("MicroMsg.NetStatMsgExtension", "kernel has not startup");
            AppMethodBeat.o(78751);
        }
    }

    public static void c(int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(78752);
        if (g.RN().QY()) {
            switch (i) {
                case 4:
                    ab.d("MicroMsg.NetStatMsgExtension", "recv bytes flow:".concat(String.valueOf(i3)));
                    if (z) {
                        n.I(i3, 0, i2);
                        AppMethodBeat.o(78752);
                        return;
                    }
                    n.J(i3, 0, i2);
                    AppMethodBeat.o(78752);
                    return;
                case 5:
                    ab.d("MicroMsg.NetStatMsgExtension", "send bytes flow:".concat(String.valueOf(i3)));
                    if (z) {
                        n.I(0, i3, i2);
                        AppMethodBeat.o(78752);
                        return;
                    }
                    n.J(0, i3, i2);
                    AppMethodBeat.o(78752);
                    return;
                case 8:
                    aj.amA("dns_failed_report");
                    break;
            }
            AppMethodBeat.o(78752);
            return;
        }
        AppMethodBeat.o(78752);
    }

    public final void a(e.c cVar) {
    }
}
