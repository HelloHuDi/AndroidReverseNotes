package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.h;
import com.tencent.mm.storage.j;
import com.tencent.mm.storage.l;
import com.tencent.mm.storage.n;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.p;
import com.tencent.mm.storage.z;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c {
    public static HashMap<Integer, d> eaA;
    public br fkd;
    public bq fke;
    h fkf;
    com.tencent.mm.model.b.c fkg;
    com.tencent.mm.model.b.d fkh;
    j fki;
    n fkj;
    l fkk;
    com.tencent.mm.model.b.b fkl;

    public interface a {
        void cx(boolean z);
    }

    static class b implements Runnable {
        String cKf;
        String fkn;

        public b(String str, String str2) {
            this.cKf = str;
            this.fkn = str2;
        }

        public final void run() {
            AppMethodBeat.i(16204);
            if (bo.isNullOrNil(this.cKf) || bo.isNullOrNil(this.fkn)) {
                AppMethodBeat.o(16204);
                return;
            }
            ab.d("MicroMsg.AccountStorage", "MoveDataFiles :" + this.cKf + " to :" + this.fkn);
            if (!f.Mn()) {
                AppMethodBeat.o(16204);
            } else if (this.fkn.substring(0, e.eSn.length()).equals(e.eSn)) {
                com.tencent.mm.vfs.e.it(this.cKf + "image/", this.fkn + "image/");
                com.tencent.mm.vfs.e.it(this.cKf + "image2/", this.fkn + "image2/");
                com.tencent.mm.vfs.e.it(this.cKf + "video/", this.fkn + "video/");
                com.tencent.mm.vfs.e.it(this.cKf + "voice/", this.fkn + "voice/");
                com.tencent.mm.vfs.e.it(this.cKf + "voice2/", this.fkn + "voice2/");
                com.tencent.mm.vfs.e.it(this.cKf + "package/", this.fkn + "package/");
                com.tencent.mm.vfs.e.it(this.cKf + "emoji/", this.fkn + "emoji/");
                com.tencent.mm.vfs.e.it(this.cKf + "mailapp/", this.fkn + "mailapp/");
                com.tencent.mm.vfs.e.it(this.cKf + "brandicon/", this.fkn + "brandicon/");
                AppMethodBeat.o(16204);
            } else {
                AppMethodBeat.o(16204);
            }
        }
    }

    public c() {
        AppMethodBeat.i(16205);
        g.RQ();
        com.tencent.mm.kernel.e RP = g.RP();
        RP.eJJ.aD(new com.tencent.mm.cd.h.a() {
            public final void RF() {
                AppMethodBeat.i(16199);
                g.RQ();
                if (g.RK()) {
                    m aks = q.aks();
                    if (aks != null) {
                        ab.i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: ".concat(String.valueOf(aks)));
                        long currentTimeMillis = System.currentTimeMillis();
                        aks.fTM.pl(true);
                        ab.i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    }
                }
                AppMethodBeat.o(16199);
            }

            public final void RG() {
            }

            public final void RH() {
            }
        });
        com.tencent.mm.kernel.a.c.Sa().add(new com.tencent.mm.kernel.api.b() {
            public final List<String> collectStoragePaths() {
                AppMethodBeat.i(16200);
                LinkedList linkedList = new LinkedList();
                Collections.addAll(linkedList, new String[]{"image/shakeTranImg/", "emoji/", "locallog", "mailapp/", "mailapp/", "voice2/", "video/", "attachment/"});
                AppMethodBeat.o(16200);
                return linkedList;
            }
        });
        com.tencent.mm.kernel.a.c.Sa().add(new com.tencent.mm.kernel.api.f() {
            public final void RV() {
                AppMethodBeat.i(16201);
                aw.ZJ();
                AppMethodBeat.o(16201);
            }

            public final void lM(String str) {
                AppMethodBeat.i(16202);
                if (f.Mn()) {
                    g.RQ();
                    if (g.RP().eJL.equals(e.eSn)) {
                        g.RQ();
                        com.tencent.mm.sdk.g.d.post(new b(g.RP().cachePath, str), "AccountStorage_moveDataFiles");
                    }
                }
                AppMethodBeat.o(16202);
            }
        });
        AppMethodBeat.o(16205);
    }

    public static int QF() {
        AppMethodBeat.i(16206);
        g.RQ();
        g.RN();
        int QF = com.tencent.mm.kernel.a.QF();
        AppMethodBeat.o(16206);
        return QF;
    }

    public static String XH() {
        AppMethodBeat.i(16207);
        g.RQ();
        String str = g.RP().eJL;
        AppMethodBeat.o(16207);
        return str;
    }

    public static void RA() {
        AppMethodBeat.i(16208);
        g.RQ();
        g.RP().RA();
        AppMethodBeat.o(16208);
    }

    public static boolean isSDCardAvailable() {
        AppMethodBeat.i(16209);
        g.RQ();
        boolean isSDCardAvailable = g.RP().isSDCardAvailable();
        AppMethodBeat.o(16209);
        return isSDCardAvailable;
    }

    public static String Rs() {
        AppMethodBeat.i(16210);
        g.RQ();
        String Rs = g.RP().Rs();
        AppMethodBeat.o(16210);
        return Rs;
    }

    public static void closeDB() {
        AppMethodBeat.i(16211);
        g.RQ();
        g.RP().jC(null);
        AppMethodBeat.o(16211);
    }

    public static void a(as asVar) {
        AppMethodBeat.i(16212);
        g.RQ();
        com.tencent.mm.kernel.a RN = g.RN();
        ab.i("MMKernel.CoreAccount", "UserStatusChange: add %s", asVar);
        synchronized (RN.eIX) {
            try {
                if (!RN.eIX.contains(asVar)) {
                    RN.eIX.add(asVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(16212);
            }
        }
    }

    public static void b(as asVar) {
        AppMethodBeat.i(16213);
        g.RQ();
        com.tencent.mm.kernel.a RN = g.RN();
        ab.i("MMKernel.CoreAccount", "UserStatusChange: remove %s", asVar);
        synchronized (RN.eIX) {
            try {
                RN.eIX.remove(asVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(16213);
            }
        }
    }

    public static void QV() {
        AppMethodBeat.i(16214);
        g.RQ();
        g.RN().QV();
        AppMethodBeat.o(16214);
    }

    public static boolean XI() {
        AppMethodBeat.i(16215);
        g.RQ();
        boolean jP = com.tencent.mm.kernel.a.jP(g.RN().eIV);
        AppMethodBeat.o(16215);
        return jP;
    }

    public static int XJ() {
        AppMethodBeat.i(16216);
        g.RQ();
        int i = g.RN().eIW;
        AppMethodBeat.o(16216);
        return i;
    }

    public static com.tencent.mm.cd.h Ru() {
        AppMethodBeat.i(16217);
        g.RQ();
        com.tencent.mm.cd.h hVar = g.RP().eJN;
        AppMethodBeat.o(16217);
        return hVar;
    }

    public static com.tencent.mm.cd.h XK() {
        AppMethodBeat.i(16218);
        g.RQ();
        com.tencent.mm.cd.h hVar = g.RP().eJO;
        AppMethodBeat.o(16218);
        return hVar;
    }

    public static SharedPreferences lK(String str) {
        AppMethodBeat.i(16219);
        g.RQ();
        SharedPreferences lK = g.RP().lK(str);
        AppMethodBeat.o(16219);
        return lK;
    }

    public static z Ry() {
        AppMethodBeat.i(16220);
        g.RQ();
        z Ry = g.RP().Ry();
        AppMethodBeat.o(16220);
        return Ry;
    }

    public static i XL() {
        AppMethodBeat.i(16221);
        i XL = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XL();
        AppMethodBeat.o(16221);
        return XL;
    }

    public static bd XM() {
        AppMethodBeat.i(16222);
        bd XM = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM();
        AppMethodBeat.o(16222);
        return XM;
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.m XN() {
        AppMethodBeat.i(16223);
        com.tencent.mm.plugin.messenger.foundation.a.a.m XN = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XN();
        AppMethodBeat.o(16223);
        return XN;
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.h XO() {
        AppMethodBeat.i(16224);
        com.tencent.mm.plugin.messenger.foundation.a.a.h bOr = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr();
        AppMethodBeat.o(16224);
        return bOr;
    }

    public static o XP() {
        AppMethodBeat.i(16225);
        o XP = ((com.tencent.mm.aj.o) g.K(com.tencent.mm.aj.o.class)).XP();
        AppMethodBeat.o(16225);
        return XP;
    }

    public static p XQ() {
        AppMethodBeat.i(16226);
        p XQ = ((com.tencent.mm.aj.o) g.K(com.tencent.mm.aj.o.class)).XQ();
        AppMethodBeat.o(16226);
        return XQ;
    }

    public static be XR() {
        AppMethodBeat.i(16227);
        be XR = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR();
        AppMethodBeat.o(16227);
        return XR;
    }

    public static com.tencent.mm.plugin.downloader.f.b XS() {
        AppMethodBeat.i(16228);
        com.tencent.mm.plugin.downloader.f.b XS = ((com.tencent.mm.plugin.downloader.a.d) g.K(com.tencent.mm.plugin.downloader.a.d.class)).XS();
        AppMethodBeat.o(16228);
        return XS;
    }

    public static bh XT() {
        AppMethodBeat.i(16229);
        bh XT = ((com.tencent.mm.plugin.m.a.a) g.K(com.tencent.mm.plugin.m.a.a.class)).XT();
        AppMethodBeat.o(16229);
        return XT;
    }

    public static k XU() {
        AppMethodBeat.i(16230);
        k XU = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XU();
        AppMethodBeat.o(16230);
        return XU;
    }

    public static ag XV() {
        AppMethodBeat.i(16231);
        g.RQ();
        g.RN().QU();
        ag XV = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV();
        AppMethodBeat.o(16231);
        return XV;
    }

    public static String XW() {
        AppMethodBeat.i(16232);
        String XW = com.tencent.mm.plugin.i.c.XW();
        AppMethodBeat.o(16232);
        return XW;
    }

    public static String XX() {
        AppMethodBeat.i(16233);
        String XX = com.tencent.mm.plugin.i.c.XX();
        AppMethodBeat.o(16233);
        return XX;
    }

    public static String XY() {
        AppMethodBeat.i(16234);
        String XY = com.tencent.mm.modelvoice.q.XY();
        AppMethodBeat.o(16234);
        return XY;
    }

    public static String XZ() {
        AppMethodBeat.i(16235);
        String XZ = com.tencent.mm.plugin.record.b.XZ();
        AppMethodBeat.o(16235);
        return XZ;
    }

    public static String Ya() {
        AppMethodBeat.i(16236);
        String Ya = aa.Ya();
        AppMethodBeat.o(16236);
        return Ya;
    }

    public static String Yb() {
        AppMethodBeat.i(16237);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().eJM).append("emoji/").toString();
        AppMethodBeat.o(16237);
        return stringBuilder2;
    }

    public static String getAccVideoPath() {
        AppMethodBeat.i(16238);
        com.tencent.mm.modelvideo.o.alk();
        String accVideoPath = com.tencent.mm.modelvideo.o.getAccVideoPath();
        AppMethodBeat.o(16238);
        return accVideoPath;
    }

    public static String Yc() {
        AppMethodBeat.i(16239);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().eJM).append("image/shakeTranImg/").toString();
        AppMethodBeat.o(16239);
        return stringBuilder2;
    }

    public static String Yd() {
        AppMethodBeat.i(16240);
        String Yd = com.tencent.mm.plugin.h.a.Yd();
        AppMethodBeat.o(16240);
        return Yd;
    }

    public static String Ye() {
        AppMethodBeat.i(16241);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().eJM).append("attachment/").toString();
        AppMethodBeat.o(16241);
        return stringBuilder2;
    }

    public static String Yf() {
        AppMethodBeat.i(16242);
        String Yf = ((com.tencent.mm.aj.o) g.K(com.tencent.mm.aj.o.class)).Yf();
        AppMethodBeat.o(16242);
        return Yf;
    }

    public static String Yg() {
        AppMethodBeat.i(16243);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().eJM).append("record/").toString();
        AppMethodBeat.o(16243);
        return stringBuilder2;
    }

    public static String getAccSnsPath() {
        AppMethodBeat.i(16244);
        String accSnsPath = ((com.tencent.mm.plugin.sns.b.b) g.M(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath();
        AppMethodBeat.o(16244);
        return accSnsPath;
    }

    public static String getAccSnsTmpPath() {
        AppMethodBeat.i(16245);
        String accSnsTmpPath = ((com.tencent.mm.plugin.sns.b.b) g.M(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath();
        AppMethodBeat.o(16245);
        return accSnsTmpPath;
    }

    public static String Yh() {
        AppMethodBeat.i(16246);
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        String stringBuilder2 = stringBuilder.append(getAccPath()).append("voiceremind/").toString();
        AppMethodBeat.o(16246);
        return stringBuilder2;
    }

    public static String Yi() {
        AppMethodBeat.i(16247);
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        String stringBuilder2 = stringBuilder.append(getAccPath()).append("wenote/").toString();
        AppMethodBeat.o(16247);
        return stringBuilder2;
    }

    public static String Rv() {
        AppMethodBeat.i(16248);
        g.RQ();
        String Rv = g.RP().Rv();
        AppMethodBeat.o(16248);
        return Rv;
    }

    public static String Rw() {
        AppMethodBeat.i(16249);
        g.RQ();
        String Rw = g.RP().Rw();
        AppMethodBeat.o(16249);
        return Rw;
    }

    public static String Rt() {
        AppMethodBeat.i(16250);
        g.RQ();
        String str = g.RP().cachePath;
        AppMethodBeat.o(16250);
        return str;
    }

    public static String getAccPath() {
        AppMethodBeat.i(16251);
        g.RQ();
        String str = g.RP().eJM;
        AppMethodBeat.o(16251);
        return str;
    }

    public final void Yj() {
        AppMethodBeat.i(16252);
        StringBuilder stringBuilder = new StringBuilder("mm");
        g.RQ();
        g.RN();
        String x = com.tencent.mm.a.g.x(stringBuilder.append(com.tencent.mm.kernel.a.QF()).toString().getBytes());
        String str = ac.eSj + x + "/";
        String str2 = e.eSn + x + "/";
        String[] a = new com.tencent.mm.vfs.b(str).a(new com.tencent.mm.vfs.i() {
            public final boolean ml(String str) {
                AppMethodBeat.i(16203);
                if (str.equals("EnMicroMsg.db") || str.startsWith("EnMicroMsg.dberr") || str.equals("FTS5IndexMicroMsg_encrypt.db")) {
                    AppMethodBeat.o(16203);
                    return true;
                }
                AppMethodBeat.o(16203);
                return false;
            }
        });
        if (a == null) {
            AppMethodBeat.o(16252);
            return;
        }
        for (String str3 : a) {
            String str4 = str2 + str3 + ".dump";
            com.tencent.mm.vfs.e.deleteFile(str4);
            com.tencent.mm.vfs.e.y(str + str3, str4);
            ab.i("MicroMsg.AccountStorage", "Exported: ".concat(String.valueOf(str4)));
        }
        AppMethodBeat.o(16252);
    }

    public static void iy(int i) {
        AppMethodBeat.i(16253);
        q.kt(i);
        if ((i & 16) != 0) {
            bf.a("medianote", null);
            aw.ZK();
            XR().aoX("medianote");
        }
        AppMethodBeat.o(16253);
    }

    static {
        AppMethodBeat.i(16262);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("BOTTLE_MESSAGE_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return au.fnj;
            }
        });
        eaA.put(Integer.valueOf("APPBRAND_MESSAGE_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return h.fnj;
            }
        });
        eaA.put(Integer.valueOf("BackupMoveTime".hashCode()), new d() {
            public final String[] Af() {
                return j.fnj;
            }
        });
        eaA.put(Integer.valueOf("BackupTempMoveTime".hashCode()), new d() {
            public final String[] Af() {
                return n.fnj;
            }
        });
        eaA.put(Integer.valueOf("BackupRecoverMsgListDataId".hashCode()), new d() {
            public final String[] Af() {
                return l.fnj;
            }
        });
        AppMethodBeat.o(16262);
    }

    public final com.tencent.mm.model.b.c Yk() {
        AppMethodBeat.i(16254);
        g.RQ();
        g.RN().QU();
        com.tencent.mm.model.b.c cVar = this.fkg;
        AppMethodBeat.o(16254);
        return cVar;
    }

    public final com.tencent.mm.model.b.d Yl() {
        AppMethodBeat.i(16255);
        g.RQ();
        g.RN().QU();
        com.tencent.mm.model.b.d dVar = this.fkh;
        AppMethodBeat.o(16255);
        return dVar;
    }

    public final com.tencent.mm.model.b.b Ym() {
        AppMethodBeat.i(16256);
        g.RQ();
        g.RN().QU();
        com.tencent.mm.model.b.b bVar = this.fkl;
        AppMethodBeat.o(16256);
        return bVar;
    }

    public static com.tencent.mm.storage.g Yn() {
        AppMethodBeat.i(16257);
        g.RQ();
        g.RN().QU();
        com.tencent.mm.storage.g Yn = com.tencent.mm.plugin.c.a.ask().Yn();
        AppMethodBeat.o(16257);
        return Yn;
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.c Yo() {
        AppMethodBeat.i(16258);
        g.RQ();
        g.RN().QU();
        com.tencent.mm.plugin.messenger.foundation.a.a.c Yo = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Yo();
        AppMethodBeat.o(16258);
        return Yo;
    }

    public final j Yp() {
        AppMethodBeat.i(16259);
        g.RQ();
        g.RN().QU();
        j jVar = this.fki;
        AppMethodBeat.o(16259);
        return jVar;
    }

    public final n Yq() {
        AppMethodBeat.i(16260);
        g.RQ();
        g.RN().QU();
        n nVar = this.fkj;
        AppMethodBeat.o(16260);
        return nVar;
    }

    public final l Yr() {
        AppMethodBeat.i(16261);
        g.RQ();
        g.RN().QU();
        l lVar = this.fkk;
        AppMethodBeat.o(16261);
        return lVar;
    }
}
