package com.tencent.mm.plugin.voip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.az.h;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.voip.model.i;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.ui.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.view.raw.FilterRawGet;
import com.tencent.view.raw.FilterRawGet.GetInputStream;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class b implements at {
    private static int sNe = 0;
    private r sMZ = null;
    private o sNa = new o();
    private d sNb;
    private d sNc = new d();
    private a sNd = new a();

    public class a extends c<mp> {
        public a() {
            AppMethodBeat.i(4309);
            this.xxI = mp.class.getName().hashCode();
            AppMethodBeat.o(4309);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(4310);
            if (i.Iv()) {
                boolean z;
                String str;
                if (g.RK()) {
                    g.RN();
                    if (!com.tencent.mm.kernel.a.QT()) {
                        z = true;
                        if (z && i.Iv()) {
                            str = (String) g.RP().Ry().get(77829, null);
                            if (str != null) {
                                Map abV = com.tencent.mm.plugin.voip.model.i.a.abV(str);
                                if (abV != null && abV.size() > 0) {
                                    LinkedList linkedList = new LinkedList();
                                    for (Entry entry : abV.entrySet()) {
                                        com.tencent.mm.plugin.voip.model.i.a aVar = (com.tencent.mm.plugin.voip.model.i.a) entry.getValue();
                                        if (aVar != null) {
                                            int i = aVar.hitCount;
                                            int i2 = aVar.fMk;
                                            if (i > 0 || i2 > 0) {
                                                linkedList.add(new com.tencent.mm.az.h.a(10166, ((String) entry.getKey()) + "," + i + "," + i2));
                                            }
                                            ab.d("PostTaskTenMinutesLogicState", "report PostTaskTenMinutesLogicState  name " + ((String) entry.getKey()) + " " + i + "  " + i2);
                                        }
                                    }
                                    if (!linkedList.isEmpty()) {
                                        ((j) g.K(j.class)).XL().c(new h(linkedList));
                                        g.RP().Ry().set(77829, null);
                                    }
                                }
                            }
                        }
                        g.RP().Ry().set(77828, Long.valueOf(bo.anT()));
                        ab.d("PostTaskTenMinutesLogicState", "report PostTaskTenMinutesLogicState done ");
                    }
                }
                z = false;
                str = (String) g.RP().Ry().get(77829, null);
                if (str != null) {
                }
                g.RP().Ry().set(77828, Long.valueOf(bo.anT()));
                ab.d("PostTaskTenMinutesLogicState", "report PostTaskTenMinutesLogicState done ");
            }
            AppMethodBeat.o(4310);
            return false;
        }
    }

    public b() {
        AppMethodBeat.i(4311);
        AppMethodBeat.o(4311);
    }

    static {
        AppMethodBeat.i(4317);
        com.tencent.mm.plugin.voip.video.a.c.checkLibraryInit();
        AppMethodBeat.o(4317);
    }

    private static b cIi() {
        AppMethodBeat.i(4312);
        b bVar = (b) q.Y(b.class);
        AppMethodBeat.o(4312);
        return bVar;
    }

    public static r cIj() {
        AppMethodBeat.i(4313);
        if (g.RK()) {
            if (cIi().sMZ == null) {
                cIi().sMZ = new r();
            }
            r rVar = cIi().sMZ;
            AppMethodBeat.o(4313);
            return rVar;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
        AppMethodBeat.o(4313);
        throw bVar;
    }

    public static d cIk() {
        AppMethodBeat.i(4314);
        if (g.RK()) {
            if (cIi().sNb == null) {
                cIi().sNb = new d();
            }
            d dVar = cIi().sNb;
            AppMethodBeat.o(4314);
            return dVar;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
        AppMethodBeat.o(4314);
        throw bVar;
    }

    public static int cIl() {
        return sNe;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(4315);
        if (this.sNb != null) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(4307);
                    b.this.sNb.dismiss();
                    b.this.sNb = null;
                    AppMethodBeat.o(4307);
                }
            });
        }
        e.d.b(Integer.valueOf(50), this.sNa);
        cIj();
        com.tencent.mm.sdk.b.a.xxA.d(this.sNc);
        com.tencent.mm.sdk.b.a.xxA.d(this.sNd);
        com.tencent.mm.bu.a aVar = com.tencent.mm.bu.a.xtM;
        ab.i("MicroMsg.BeautyDownloadLogic", "unInit");
        com.tencent.mm.sdk.b.a.xxA.d(aVar.fAP);
        AppMethodBeat.o(4315);
    }

    public final HashMap<Integer, com.tencent.mm.cd.h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(4316);
        e.d.a(Integer.valueOf(50), this.sNa);
        cIj();
        com.tencent.mm.sdk.b.a.xxA.c(this.sNc);
        com.tencent.mm.sdk.b.a.xxA.c(this.sNd);
        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        boolean booleanValue = ((Boolean) g.RP().Ry().get(73217, Boolean.TRUE)).booleanValue();
        boolean booleanValue2 = ((Boolean) g.RP().Ry().get(73218, Boolean.TRUE)).booleanValue();
        boolean MG = com.tencent.mm.m.a.MG();
        ab.i("MicroMsg.SubCoreVoip", "voipSound: %s, voipAudioSound: %s, msgSound: %s, hasReport: %s", Boolean.valueOf(booleanValue), Boolean.valueOf(booleanValue2), Boolean.valueOf(MG), Boolean.valueOf(((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_VOIP_MSG_SOUND_DIFF_STAT_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()));
        if (!((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_VOIP_MSG_SOUND_DIFF_STAT_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            boolean z2 = booleanValue || booleanValue2;
            if (z2 != MG) {
                if (z2 && !MG) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(500, 13, 1, false);
                } else if (!z2 && MG) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(500, 14, 1, false);
                }
            }
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_VOIP_MSG_SOUND_DIFF_STAT_BOOLEAN_SYNC, Boolean.TRUE);
        }
        au.kB(1);
        ab.i("MicroMsg.SubCoreVoip", "start init beauty download");
        com.tencent.mm.bu.a aVar = com.tencent.mm.bu.a.xtM;
        ab.i("MicroMsg.BeautyDownloadLogic", "init, downloadSoPath: %s, downloadResPath: %s", com.tencent.mm.bu.a.xtJ, com.tencent.mm.bu.a.xtK);
        com.tencent.mm.sdk.b.a.xxA.b(aVar.fAP);
        com.tencent.mm.pluginsdk.g.a.a.b.c.veg;
        com.tencent.mm.pluginsdk.g.a.a.b.Ky(56);
        if (com.tencent.mm.bu.a.agb()) {
            ab.i("MicroMsg.BeautyDownloadLogic", "init check local has resource");
            com.tencent.mm.bu.a.xtL = true;
            com.tencent.mm.plugin.report.service.h.pYm.e(15861, Integer.valueOf(0), Integer.valueOf(1));
            com.tencent.mm.plugin.report.service.h.pYm.k(914, 0, 1);
        } else {
            com.tencent.mm.plugin.report.service.h.pYm.k(914, 1, 1);
            com.tencent.mm.pluginsdk.g.a.a.b.c.veg;
            String gM = com.tencent.mm.pluginsdk.g.a.a.b.gM(56, 1);
            if (com.tencent.mm.vfs.e.ct(gM)) {
                ab.i("MicroMsg.BeautyDownloadLogic", "init, cache file %s exist, try unzip", gM);
                com.tencent.mm.plugin.report.service.h.pYm.k(914, 2, 1);
                aVar.e(gM, 56, 1, 1);
            } else {
                ab.i("MicroMsg.BeautyDownloadLogic", "init cannot find beauty resource");
                com.tencent.mm.plugin.report.service.h.pYm.e(15861, Integer.valueOf(0), Integer.valueOf(2));
            }
        }
        try {
            int initAuth = YTCommonInterface.initAuth(ah.getContext(), "rel_wechat.lic", 0, true);
            sNe = initAuth;
            ab.i("MicroMsg.SubCoreVoip", "init VideoModule initAuth: %s", Integer.valueOf(initAuth));
            if (initAuth != 0) {
                com.tencent.mm.plugin.report.service.h.pYm.k(914, 12, 1);
            }
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.SubCoreVoip", th, "init youtu sdk failed: %s", th.getMessage());
            sNe = -1;
            com.tencent.mm.plugin.report.service.h.pYm.k(914, 12, 1);
        }
        FilterRawGet.setGetInputStream(new GetInputStream() {
            public final InputStream getInputStream(String str) {
                AppMethodBeat.i(4308);
                try {
                    InputStream open = ah.getContext().getAssets().open("raw" + File.separator + str);
                    AppMethodBeat.o(4308);
                    return open;
                } catch (Exception e) {
                    ab.e("MicroMsg.SubCoreVoip", "cannot find res %s", str);
                    com.tencent.mm.plugin.report.service.h.pYm.k(914, 13, 1);
                    AppMethodBeat.o(4308);
                    return null;
                }
            }
        });
        AppMethodBeat.o(4316);
    }

    public final void bA(boolean z) {
    }
}
