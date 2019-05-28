package com.tencent.mm.plugin.appbrand.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bw;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.jd;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.a.o;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.av;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.c;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.launching.z;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.j.e;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.protobuf.cga;
import com.tencent.mm.protocal.protobuf.iu;
import com.tencent.mm.protocal.v;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.XWalkEnvironment;

public final class f implements at {
    private static b gRA;
    private static volatile com.tencent.mm.plugin.appbrand.appstorage.b gRj;
    private static volatile c gRk;
    private static volatile ax gRl;
    private static volatile w gRm;
    private static volatile q gRn;
    private static volatile z gRo;
    private static volatile com.tencent.mm.plugin.appbrand.widget.f gRp;
    private static volatile i gRq;
    private static volatile a gRr;
    private static volatile m gRs;
    private static volatile com.tencent.mm.af.a.c gRt;
    private static volatile com.tencent.mm.plugin.appbrand.q.a gRu;
    private static volatile ab gRv;
    private static volatile com.tencent.mm.plugin.appbrand.game.b.a.c gRw;
    private static volatile am gRx;
    private static volatile ba gRy;
    private static com.tencent.mm.plugin.appbrand.c.c gRz;
    private k.a foI = new k.a() {
        public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
            AppMethodBeat.i(129284);
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                f.avf();
                f.avg();
                f.avh();
                f.avi();
                f.avj();
            }
            AppMethodBeat.o(129284);
        }
    };
    private final n fyJ = new n.a() {
        public final void gl(int i) {
            AppMethodBeat.i(129274);
            h.onNetworkChange();
            com.tencent.mm.plugin.appbrand.appcache.b.b.i.gWd.awv();
            AppMethodBeat.o(129274);
        }
    };
    private be.a gRB = new com.tencent.mm.plugin.appbrand.p.a();
    private com.tencent.mm.vending.b.b gRC = null;
    private final com.tencent.mm.plugin.auth.a.a gRD = new com.tencent.mm.plugin.auth.a.a() {
        public final void a(com.tencent.mm.protocal.j.f fVar, g gVar, boolean z) {
            boolean z2;
            boolean z3 = false;
            AppMethodBeat.i(129251);
            if (gVar != null && (gVar instanceof e)) {
                com.tencent.mm.plugin.appbrand.r.m.aNS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(129547);
                        j.a(j.this, 1, 0, 7, 0, true, null);
                        AppMethodBeat.o(129547);
                    }
                });
                aj.dC(true);
            }
            if (z && (fVar instanceof j.a) && fVar.vyf == 12) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                aj.dC(true);
            }
            if (((fVar instanceof d) && fVar.vyf == 1) || ((fVar instanceof j.a) && fVar.vyf == 12)) {
                z3 = true;
            }
            if (z3) {
                com.tencent.mm.plugin.appbrand.appusage.a.g.dF(true);
            }
            AppMethodBeat.o(129251);
        }

        public final void a(v.b bVar, String str, int i, String str2, String str3, int i2) {
        }
    };
    private final Set<com.tencent.mm.sdk.b.c> gRE = new HashSet();
    private final com.tencent.mm.sdk.b.c<jl> gRF = new com.tencent.mm.sdk.b.c<jl>() {
        {
            AppMethodBeat.i(129252);
            this.xxI = jl.class.getName().hashCode();
            AppMethodBeat.o(129252);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(129253);
            switch (((jl) bVar).cEK.boZ) {
                case 1:
                case 3:
                    h.pN(1);
                    break;
                default:
                    h.pN(0);
                    break;
            }
            com.tencent.mm.plugin.appbrand.dynamic.h.b.aAe();
            AppMethodBeat.o(129253);
            return true;
        }
    };
    private final com.tencent.mm.sdk.b.c<tz> gRG = new com.tencent.mm.sdk.b.c<tz>() {
        {
            AppMethodBeat.i(129254);
            this.xxI = tz.class.getName().hashCode();
            AppMethodBeat.o(129254);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            boolean z = true;
            AppMethodBeat.i(129255);
            tz tzVar = (tz) bVar;
            if (bo.isNullOrNil(tzVar.cQf.csl)) {
                AppMethodBeat.o(129255);
            } else {
                p.ayH();
                String str = tzVar.cQf.csl;
                int i = tzVar.cQf.cQh;
                if (tzVar.cQf.action != 1) {
                    z = false;
                }
                tzVar.cQg.cQi = p.k(str, i, z);
                AppMethodBeat.o(129255);
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<jz> gRH = new com.tencent.mm.sdk.b.c<jz>() {
        {
            AppMethodBeat.i(129256);
            this.xxI = jz.class.getName().hashCode();
            AppMethodBeat.o(129256);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(129257);
            ad adVar = ((jz) bVar).cFm.cFn;
            if (ad.mg(adVar.field_username)) {
                adVar.setType(0);
                r.zt(adVar.field_username);
            }
            AppMethodBeat.o(129257);
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<nk> gRI = new com.tencent.mm.sdk.b.c<nk>() {
        {
            AppMethodBeat.i(129258);
            this.xxI = nk.class.getName().hashCode();
            AppMethodBeat.o(129258);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(129259);
            bi biVar = ((nk) bVar).cJI.csG;
            if (biVar != null) {
                String str = biVar.field_talker;
                if (ad.mg(str)) {
                    int i;
                    f.xH().bG(str + "_unreadCount", String.valueOf(bo.getInt(f.xH().get(str + "_unreadCount", AppEventsConstants.EVENT_PARAM_VALUE_NO), 0) + 1));
                    ak aoZ = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().aoZ(str);
                    if (aoZ != null) {
                        i = aoZ.field_unReadCount;
                    } else {
                        i = 0;
                    }
                    com.tencent.mm.plugin.appbrand.ipc.d.bf(p.zm(str), i);
                }
            }
            AppMethodBeat.o(129259);
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<l> gRJ = new com.tencent.mm.sdk.b.c<l>() {
        {
            AppMethodBeat.i(129260);
            this.xxI = l.class.getName().hashCode();
            AppMethodBeat.o(129260);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(129261);
            l lVar = (l) bVar;
            if (!bo.isNullOrNil(lVar.csj.csl)) {
                lVar.csk.csm = bo.getInt(f.xH().get(lVar.csj.csl + "_unreadCount", AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
            }
            AppMethodBeat.o(129261);
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.p> gRK = new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.p>() {
        {
            AppMethodBeat.i(129262);
            this.xxI = com.tencent.mm.g.a.p.class.getName().hashCode();
            AppMethodBeat.o(129262);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(129263);
            com.tencent.mm.g.a.p pVar = (com.tencent.mm.g.a.p) bVar;
            if (!bo.isNullOrNil(pVar.csz.csl)) {
                String str = pVar.csz.csl;
                f.xH().bG(str + "_unreadCount", pVar.csz.csm);
                com.tencent.mm.plugin.appbrand.ipc.d.bf(p.zm(str), pVar.csz.csm);
            }
            AppMethodBeat.o(129263);
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<o> gRL = new com.tencent.mm.sdk.b.c<o>() {
        {
            AppMethodBeat.i(129264);
            this.xxI = o.class.getName().hashCode();
            AppMethodBeat.o(129264);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(129265);
            boolean hY = f.xH().gTC.hY("AppBrandCommonKVData", "update AppBrandCommonKVData set value = '0' where key like '%_unreadCount'");
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandCommonKVDataStorage", "sql:%s, updateRet : %b", "update AppBrandCommonKVData set value = '0' where key like '%_unreadCount'", Boolean.valueOf(hY));
            AppMethodBeat.o(129265);
            return true;
        }
    };
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.k> gRM = new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.k>() {
        {
            AppMethodBeat.i(129266);
            this.xxI = com.tencent.mm.g.a.k.class.getName().hashCode();
            AppMethodBeat.o(129266);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(129267);
            com.tencent.mm.g.a.k kVar = (com.tencent.mm.g.a.k) bVar;
            if (kVar == null || kVar.csh == null) {
                AppMethodBeat.o(129267);
            } else if (kVar.csh.csi) {
                AppMethodBeat.o(129267);
            } else if (com.tencent.mm.kernel.g.RN().eJb) {
                aj.dC(false);
                com.tencent.mm.plugin.appbrand.r.m.aNS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(129548);
                        if (!com.tencent.mm.kernel.g.RK()) {
                            AppMethodBeat.o(129548);
                        } else if (i.axg()) {
                            AppMethodBeat.o(129548);
                        } else {
                            j jVar = j.this;
                            t.axG();
                            j.a(jVar, 2, 0, 7, 0, true, null);
                            AppMethodBeat.o(129548);
                        }
                    }
                });
                com.tencent.mm.ci.g.da(Boolean.TRUE).i(new com.tencent.mm.plugin.appbrand.appcache.b.a.AnonymousClass2(new Runnable() {
                    public final void run() {
                        int i = 0;
                        AppMethodBeat.i(129440);
                        if (!com.tencent.mm.kernel.g.RN().eJb || f.auK() == null || f.auV() == null) {
                            AppMethodBeat.o(129440);
                            return;
                        }
                        long longValue = ((Long) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.APPBRAND_PREDOWNLOAD_CGI_PULL_LAST_TIME_IN_SECOND_LONG, Long.valueOf(0))).longValue();
                        long j = AppBrandGlobalSystemConfig.ayC().hge.hgy;
                        long anT = bo.anT();
                        if ((anT >= longValue + j ? 1 : 0) != 0) {
                            com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.APPBRAND_PREDOWNLOAD_CGI_PULL_LAST_TIME_IN_SECOND_LONG, Long.valueOf(anT));
                            List awt = a.awt();
                            if (bo.ek(awt)) {
                                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "pullIfExceedLimit, empty list");
                                AppMethodBeat.o(129440);
                                return;
                            }
                            int i2;
                            int i3 = AppBrandGlobalSystemConfig.ayC().hge.hgB;
                            int i4 = 0;
                            while (true) {
                                i2 = i;
                                if (i4 >= awt.size() / i3) {
                                    break;
                                }
                                i2 = i4 * i3;
                                i = i2 + i3;
                                aA(awt.subList(i2, i));
                                i4++;
                            }
                            if (i2 < awt.size()) {
                                aA(awt.subList(i2, awt.size()));
                            }
                            AppMethodBeat.o(129440);
                            return;
                        }
                        AppMethodBeat.o(129440);
                    }

                    private void aA(List<cga> list) {
                        AppMethodBeat.i(129441);
                        com.tencent.mm.plugin.appbrand.appcache.b.c.a aVar = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                        com.tencent.mm.plugin.appbrand.appcache.b.c.a.z(0, 0);
                        new a(list, (byte) 0).acy().h(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<iu>>() {
                            public final /* synthetic */ Object call(Object obj) {
                                AppMethodBeat.i(129439);
                                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                                int i = aVar.errType;
                                int i2 = aVar.errCode;
                                String str = aVar.aIm;
                                iu iuVar = (iu) aVar.fsy;
                                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "onCgiBack, errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                                com.tencent.mm.plugin.appbrand.appcache.b.c.a aVar2;
                                if (i != 0 || i2 != 0 || iuVar == null || iuVar.vKQ == null) {
                                    aVar2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                                    com.tencent.mm.plugin.appbrand.appcache.b.c.a.z(0, 2);
                                } else {
                                    d.aB(iuVar.vKQ);
                                    aVar2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                                    com.tencent.mm.plugin.appbrand.appcache.b.c.a.z(0, 1);
                                }
                                Void voidR = zXH;
                                AppMethodBeat.o(129439);
                                return voidR;
                            }
                        });
                        AppMethodBeat.o(129441);
                    }
                }));
                com.tencent.mm.plugin.appbrand.appcache.b.b.i.gWd.awv();
                f.E(com.tencent.mm.plugin.appbrand.appcache.b.e.e.class);
                com.tencent.mm.plugin.appbrand.appusage.a.g.dF(false);
                AppMethodBeat.o(129267);
            } else {
                AppMethodBeat.o(129267);
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.n> gRN = new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.n>() {
        {
            AppMethodBeat.i(129268);
            this.xxI = com.tencent.mm.g.a.n.class.getName().hashCode();
            AppMethodBeat.o(129268);
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(129269);
            com.tencent.mm.g.a.n nVar = (com.tencent.mm.g.a.n) bVar;
            com.tencent.mm.plugin.appbrand.report.c.a(nVar.csr.csl, nVar.csr.appId, nVar.csr.css, nVar.csr.scene, nVar.csr.cst, nVar.csr.csu, nVar.csr.action, nVar.csr.csv, nVar.csr.csw, nVar.csr.csx, nVar.csr.csy);
            AppMethodBeat.o(129269);
            return true;
        }
    };
    private final com.tencent.mm.sdk.b.c<bw> gRO = new com.tencent.mm.sdk.b.c<bw>() {
        {
            AppMethodBeat.i(129270);
            this.xxI = bw.class.getName().hashCode();
            AppMethodBeat.o(129270);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(129271);
            bw bwVar = (bw) bVar;
            if (!bo.isNullOrNil(bwVar.cuV.username) && com.tencent.mm.kernel.g.RN().eJb) {
                WxaAttributes d = f.auO().d(bwVar.cuV.username, "roundedSquareIconURL", "brandIconURL", "bigHeadURL", "appId", "nickname");
                if (d != null) {
                    String[] strArr = new String[]{d.field_roundedSquareIconURL, d.field_brandIconURL, d.field_bigHeadURL};
                    bwVar.cuW.bQQ = strArr;
                    bwVar.cuW.appId = d.field_appId;
                    bwVar.cuW.nickname = d.field_nickname;
                }
            }
            AppMethodBeat.o(129271);
            return true;
        }
    };
    private final com.tencent.mm.sdk.b.c<jd> gRP = new com.tencent.mm.sdk.b.c<jd>() {
        {
            AppMethodBeat.i(129272);
            this.xxI = jd.class.getName().hashCode();
            AppMethodBeat.o(129272);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(129273);
            AppBrandStickyBannerLogic.b.M(((jd) bVar).cEo.cEp);
            AppMethodBeat.o(129273);
            return true;
        }
    };
    private final bz.a gRQ = new av();
    private com.tencent.mm.sdk.b.c gRR = new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.d>() {
        {
            AppMethodBeat.i(129275);
            this.xxI = com.tencent.mm.g.a.d.class.getName().hashCode();
            AppMethodBeat.o(129275);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(129276);
            com.tencent.mm.g.a.d dVar = (com.tencent.mm.g.a.d) bVar;
            if (dVar == null || dVar.crQ == null) {
                AppMethodBeat.o(129276);
            } else if (dVar.crQ.crR) {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreAppBrand", "SubCoreAppBrand trigger ActivateEvent. tryPreloadNextTaskProcess (both waservice and wagame)");
                h.b(com.tencent.mm.plugin.appbrand.task.g.WASERVICE);
                h.b(com.tencent.mm.plugin.appbrand.task.g.WAGAME);
                AppMethodBeat.o(129276);
            } else {
                AppMethodBeat.o(129276);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c gRS = new com.tencent.mm.sdk.b.c<gk>() {
        {
            AppMethodBeat.i(129277);
            this.xxI = gk.class.getName().hashCode();
            AppMethodBeat.o(129277);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(129278);
            gk gkVar = (gk) bVar;
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreAppBrand", "FetchAppBrandInfoForMusicEvent callback");
            gkVar.cBa.appId = com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.ikS;
            gkVar.cBa.cBb = com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.cBb;
            gkVar.cBa.cwz = com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.cwz;
            gkVar.cBa.cBc = com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.cBc;
            AppMethodBeat.o(129278);
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c gRT = new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.d>() {
        {
            AppMethodBeat.i(129279);
            this.xxI = com.tencent.mm.g.a.d.class.getName().hashCode();
            AppMethodBeat.o(129279);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(129280);
            if (!((com.tencent.mm.g.a.d) bVar).crQ.crR) {
                ((com.tencent.mm.modelappbrand.e) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.e.class)).aby().exit();
            }
            AppMethodBeat.o(129280);
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.k> gRU = new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.k>() {
        {
            AppMethodBeat.i(129281);
            this.xxI = com.tencent.mm.g.a.k.class.getName().hashCode();
            AppMethodBeat.o(129281);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(129282);
            com.tencent.mm.g.a.k kVar = (com.tencent.mm.g.a.k) bVar;
            if (kVar != null && kVar.csh.csi) {
                if (com.tencent.mm.sdk.platformtools.at.isWifi(ah.getContext())) {
                    com.tencent.mm.sdk.g.d.f(new Runnable() {
                        /* JADX WARNING: Removed duplicated region for block: B:36:0x0129  */
                        /* JADX WARNING: Removed duplicated region for block: B:31:0x00f4  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            AppMethodBeat.i(129759);
                            List<LocalUsageInfo> a = ((af) com.tencent.mm.kernel.g.K(af.class)).a(BaseClientBuilder.API_PRIORITY_OTHER, af.a.UPATE_TIME_DESC);
                            if (a == null || a.isEmpty()) {
                                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:peroidFetchDataWhenAppEnterForground, no star apps");
                                AppMethodBeat.o(129759);
                                return;
                            }
                            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:peroidFetchDataWhenAppEnterForground, star list size:%d", Integer.valueOf(a.size()));
                            HashMap hashMap = new HashMap();
                            for (LocalUsageInfo localUsageInfo : a) {
                                if (!hashMap.containsKey(localUsageInfo.username)) {
                                    Object obj;
                                    String str = localUsageInfo.username;
                                    int i = localUsageInfo.har;
                                    a zi = p.zi(str);
                                    if (zi == null || !zi.hbW) {
                                        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "canPeriodFetchData, app(%s_v%d) can not period fetch data", str, Integer.valueOf(i));
                                        obj = null;
                                    } else if (b.aO(str, i)) {
                                        int i2 = zi.hbX;
                                        if (i2 >= 2) {
                                            long aQ = ((h) com.tencent.mm.kernel.g.K(h.class)).aQ(str, 1);
                                            if (aQ <= 0) {
                                                obj = 1;
                                            } else if (bo.anU() - aQ >= ((long) i2) * 3600000) {
                                                obj = 1;
                                            }
                                            if (obj != null) {
                                                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "canPeriodFetchData, app(%s_v%d) interval(%d) not ok", str, Integer.valueOf(i), Integer.valueOf(zi.hbX));
                                                obj = null;
                                            } else {
                                                long j;
                                                w auT = f.auT();
                                                if (bo.isNullOrNil(str)) {
                                                    j = -1;
                                                } else {
                                                    Cursor query = auT.hae.query("AppBrandLauncherLayoutItem", new String[]{"updateTime"}, String.format(Locale.US, "%s=? and %s=? and %s=?", new Object[]{"brandId", "versionType", "scene"}), new String[]{str, String.valueOf(i), "2"}, null, null, String.format(Locale.US, " %s desc ", new Object[]{"updateTime"}));
                                                    if (query == null) {
                                                        j = -1;
                                                    } else {
                                                        if (query.moveToFirst()) {
                                                            j = query.getLong(0);
                                                        } else {
                                                            j = -1;
                                                        }
                                                        query.close();
                                                    }
                                                }
                                                if (j <= 0 || bo.anU() - (j * 1000) > 604800000) {
                                                    obj = null;
                                                } else {
                                                    obj = 1;
                                                }
                                                if (obj == null) {
                                                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "canPeriodFetchData, app(%s_v%d) recently not used", str, Integer.valueOf(i));
                                                    obj = null;
                                                } else {
                                                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "canPeriodFetchData, app(%s_v%d) can period fetch data", str, Integer.valueOf(i));
                                                    obj = 1;
                                                }
                                            }
                                        }
                                        obj = null;
                                        if (obj != null) {
                                        }
                                    } else {
                                        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "canPeriodFetchData, app(%s_v%d) is not star app", str, Integer.valueOf(i));
                                        obj = null;
                                    }
                                    if (obj != null) {
                                        hashMap.put(localUsageInfo.username, localUsageInfo.appId);
                                        if (hashMap.size() >= 10) {
                                            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:peroidFetchDataWhenAppEnterForground, batch list full");
                                            break;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            if (hashMap.isEmpty()) {
                                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:peroidFetchDataWhenAppEnterForground, currently no app needs to update period data");
                                AppMethodBeat.o(129759);
                                return;
                            }
                            b.a(hashMap, new g());
                            AppMethodBeat.o(129759);
                        }
                    }, String.format(Locale.US, "AppBrandPeroidBackgroundFetchData[%s]", new Object[]{Long.valueOf(bo.anU())}));
                } else {
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "peroidFetchDataWhenAppEnterForground, not wifi network");
                }
            }
            AppMethodBeat.o(129282);
            return false;
        }
    };
    private k.a gRV = new k.a() {
        public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
            AppMethodBeat.i(129283);
            if (mVar != null && !bo.isNullOrNil(mVar.ctq) && mVar.ctq.equalsIgnoreCase("single") && mVar.hsh == 5 && mVar.obj != null && (mVar.obj instanceof s.a)) {
                String str2 = ((s.a) mVar.obj).field_username;
                int i = ((s.a) mVar.obj).field_versionType;
                if (bo.isNullOrNil(str2)) {
                    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "handleStarAppChangeEvent, username is null");
                    AppMethodBeat.o(129283);
                    return;
                }
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "handleRemoveStarAppEvent, delete star app(%s_v%d)", str2, Integer.valueOf(i));
                ((com.tencent.mm.plugin.appbrand.backgroundfetch.h) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.backgroundfetch.h.class)).ao(str2, 0);
                ((com.tencent.mm.plugin.appbrand.backgroundfetch.h) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.backgroundfetch.h.class)).ao(str2, 1);
            }
            AppMethodBeat.o(129283);
        }
    };
    private final AppBrandGuideUI.a gRW = new AppBrandGuideUI.a();

    private HashMap<Integer, com.tencent.mm.cd.h.d> auJ() {
        AppMethodBeat.i(129285);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("AppKVStorageDBCreate".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.appbrand.appstorage.b.fnj;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandWxaPkgStorageDBCreate".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return ax.gVi;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandCommonConfigStorageCreate".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return c.fjY;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandLayoutStorageCreate".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return w.fjY;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandStarAppStorageCreate".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return s.fjY;
            }
        });
        hashMap.put(Integer.valueOf("WxaAttributesTableCreate".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return q.fjY;
            }
        });
        hashMap.put(Integer.valueOf("LaunchWxaAppInfoCreate".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return new String[]{z.ihX};
            }
        });
        hashMap.put(Integer.valueOf("DynamicMsgCacheDataCreate".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.appbrand.widget.f.fjY;
            }
        });
        hashMap.put(Integer.valueOf("LaunchWxaWidgetCacheCreate".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return new String[]{i.ihX};
            }
        });
        hashMap.put(Integer.valueOf("WxaWidgetInfoStorageCreate".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return m.fjY;
            }
        });
        hashMap.put(Integer.valueOf("WxaUpdateableMsgStorageCreate".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return com.tencent.mm.af.a.c.fjY;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandCommonKVBinaryDataStorage".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.appbrand.q.a.fjY;
            }
        });
        hashMap.put(Integer.valueOf("PkgUpdateStatsStorage".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return ab.fjY;
            }
        });
        hashMap.put(Integer.valueOf("MiniGameInfoStorage".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.appbrand.game.b.a.c.fjY;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandRecommendCardStorage".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.appbrand.appusage.a.b.fjY;
            }
        });
        for (Entry entry : a.gQL.entrySet()) {
            final String[] strArr = (String[]) entry.getValue();
            hashMap.put(Integer.valueOf(((a.a) entry.getKey()).hashCode()), new com.tencent.mm.cd.h.d() {
                public final String[] Af() {
                    return strArr;
                }
            });
        }
        AppMethodBeat.o(129285);
        return hashMap;
    }

    public static a auK() {
        return gRr;
    }

    public static f auL() {
        f core;
        AppMethodBeat.i(129286);
        com.tencent.mm.plugin.appbrand.a.c cVar = (com.tencent.mm.plugin.appbrand.a.c) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.appbrand.a.c.class);
        if (cVar != null) {
            core = ((PluginAppBrand) cVar).getCore();
        } else {
            core = null;
        }
        AppMethodBeat.o(129286);
        return core;
    }

    public final a auM() {
        AppMethodBeat.i(129287);
        String str = com.tencent.mm.kernel.g.RP().cachePath + "AppBrandComm.db";
        a a;
        if (gRr == null || !str.equals(gRr.getPath())) {
            a = t.a(hashCode(), str, auJ(), true);
            gRr = a;
            AppMethodBeat.o(129287);
            return a;
        }
        a = gRr;
        AppMethodBeat.o(129287);
        return a;
    }

    public final HashMap<Integer, com.tencent.mm.cd.h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(129288);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SubCoreAppBrand", "onAccountPostReset updated %b", Boolean.valueOf(z));
        this.gRC = ((com.tencent.mm.plugin.auth.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(this.gRD);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("app_brand_global_sp", 0);
        if (sharedPreferences != null) {
            Set stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
            if (stringSet != null) {
                StringBuilder stringBuilder = new StringBuilder();
                com.tencent.mm.kernel.g.RN();
                if (stringSet.add(stringBuilder.append(com.tencent.mm.kernel.a.QF()).toString())) {
                    Editor edit = sharedPreferences.edit();
                    edit.remove("uin_set");
                    edit.commit();
                    edit.putStringSet("uin_set", stringSet);
                    edit.commit();
                }
            }
        }
        for (com.tencent.mm.sdk.b.c dnU : this.gRE) {
            dnU.dnU();
        }
        for (String a : av.gUU.keySet()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.p) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a(a, this.gRQ, true);
        }
        com.tencent.mm.plugin.appbrand.appusage.r.b.axy();
        com.tencent.mm.plugin.appbrand.appusage.v.a.axy();
        ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().c(this.gRB);
        auM();
        gRj = new com.tencent.mm.plugin.appbrand.appstorage.b(gRr);
        gRk = new c(gRr);
        gRl = new ax(gRr);
        gRm = new w(gRr);
        gRo = new z(gRr);
        gRp = new com.tencent.mm.plugin.appbrand.widget.f(gRr);
        gRq = new i(gRr);
        gRs = new m(gRr);
        gRt = new com.tencent.mm.af.a.c(gRr);
        gRu = new com.tencent.mm.plugin.appbrand.q.a(gRr);
        gRv = new ab(gRr);
        gRw = new com.tencent.mm.plugin.appbrand.game.b.a.c(gRr);
        gRx = new am();
        gRy = new ba();
        auO();
        a.a(gRr);
        com.tencent.mm.plugin.appbrand.h.setup();
        p.ayH();
        com.tencent.mm.plugin.appbrand.o.c.a.iDD.prepare();
        ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a() {
            public final boolean execute() {
                AppMethodBeat.i(129249);
                com.tencent.mm.plugin.appbrand.f.c cVar = new com.tencent.mm.plugin.appbrand.f.c();
                ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).registerIndexStorage(cVar);
                cVar.create();
                com.tencent.mm.plugin.appbrand.f.b bVar = new com.tencent.mm.plugin.appbrand.f.b();
                ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).registerNativeLogic(7, bVar);
                bVar.create();
                ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new com.tencent.mm.plugin.appbrand.f.g());
                ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new com.tencent.mm.plugin.appbrand.f.e());
                AppMethodBeat.o(129249);
                return true;
            }

            public final String getName() {
                return "InitFTSWeAppPluginTask";
            }
        });
        ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a() {
            public final boolean execute() {
                AppMethodBeat.i(129250);
                com.tencent.mm.plugin.appbrand.game.b.a aVar = new com.tencent.mm.plugin.appbrand.game.b.a();
                ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).registerIndexStorage(aVar);
                aVar.create();
                com.tencent.mm.plugin.appbrand.game.b.b bVar = new com.tencent.mm.plugin.appbrand.game.b.b();
                ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).registerNativeLogic(10, bVar);
                bVar.create();
                ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new com.tencent.mm.plugin.appbrand.game.b.f());
                ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new com.tencent.mm.plugin.appbrand.game.b.d());
                AppMethodBeat.o(129250);
                return true;
            }

            public final String getName() {
                return "InitFTSMiniGamePluginTask";
            }
        });
        com.tencent.mm.kernel.g.RO().a(this.fyJ);
        com.tencent.mm.plugin.appbrand.dynamic.g.initialize();
        com.tencent.mm.model.c.c.abi().c(this.foI);
        if (auU() != null) {
            auU().c(this.gRV);
        }
        com.tencent.mm.plugin.appbrand.config.f.init();
        AppBrandGuideUI.a aVar = this.gRW;
        AppBrandGuideUI.a.aMe().registerActivityLifecycleCallbacks(aVar);
        AppBrandStickyBannerLogic.b.d(aVar);
        aVar.iGD = false;
        AppMethodBeat.o(129288);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(129289);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SubCoreAppBrand", "onAccountRelease");
        if (this.gRC != null) {
            this.gRC.dead();
            this.gRC = null;
        }
        for (com.tencent.mm.sdk.b.c dead : this.gRE) {
            dead.dead();
        }
        com.tencent.mm.plugin.appbrand.h.release();
        for (String b : av.gUU.keySet()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.p) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b(b, this.gRQ, true);
        }
        com.tencent.mm.plugin.appbrand.appusage.r.b.unregister();
        com.tencent.mm.plugin.appbrand.appusage.v.a.unregister();
        ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().d(this.gRB);
        az.shutdown();
        gRj = null;
        gRn = null;
        gRk = null;
        gRl = null;
        gRm = null;
        gRo = null;
        gRp = null;
        gRq = null;
        gRs = null;
        gRt = null;
        gRu = null;
        gRv = null;
        gRw = null;
        gRx = null;
        gRy = null;
        a.auD();
        if (gRA != null) {
            b bVar = gRA;
            bVar.heu.clear();
            bVar.hev.clear();
            gRA = null;
        }
        gRz = null;
        if (gRr != null) {
            gRr.mJ(hashCode());
            gRr = null;
        }
        com.tencent.mm.plugin.appbrand.appusage.j.release();
        p.release();
        com.tencent.mm.plugin.appbrand.appcache.b.b.i.gWd.cleanup();
        com.tencent.mm.plugin.appbrand.o.c cVar = com.tencent.mm.plugin.appbrand.o.c.a.iDD;
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WxaFTSSearchCore", "reset");
        com.tencent.mm.sdk.b.a.xxA.d(cVar.iDz);
        com.tencent.mm.sdk.b.a.xxA.d(cVar.iDA);
        cVar.iDB.dead();
        com.tencent.mm.plugin.appbrand.s.e.aNR();
        ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(512);
        ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(7);
        ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(144);
        ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4224);
        ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(8);
        ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(10);
        ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(208);
        ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4240);
        com.tencent.mm.kernel.g.RO().b(this.fyJ);
        com.tencent.mm.plugin.appbrand.dynamic.g.release();
        com.tencent.mm.model.c.c.abi().d(this.foI);
        com.tencent.luggage.sdk.config.a.release();
        AppBrandGuideUI.a aVar = this.gRW;
        AppBrandGuideUI.a.aMe().unregisterActivityLifecycleCallbacks(aVar);
        AppBrandStickyBannerLogic.b.c(aVar);
        aVar.iGD = false;
        AppMethodBeat.o(129289);
    }

    public f() {
        AppMethodBeat.i(129290);
        this.gRE.add(this.gRM);
        this.gRE.add(new com.tencent.mm.plugin.appbrand.launching.a());
        this.gRE.add(this.gRN);
        this.gRE.add(this.gRH);
        this.gRE.add(this.gRI);
        this.gRE.add(this.gRG);
        this.gRE.add(new com.tencent.mm.plugin.appbrand.config.e());
        this.gRE.add(this.gRF);
        this.gRE.add(com.tencent.mm.plugin.appbrand.appusage.i.gZa);
        this.gRE.add(this.gRJ);
        this.gRE.add(this.gRK);
        this.gRE.add(this.gRL);
        this.gRE.add(this.gRR);
        this.gRE.add(this.gRO);
        this.gRE.add(this.gRP);
        this.gRE.add(this.gRS);
        this.gRE.add(this.gRT);
        this.gRE.add(this.gRU);
        AppMethodBeat.o(129290);
    }

    public static AppBrandGuideUI.a auN() {
        AppMethodBeat.i(129291);
        if (auL() == null) {
            AppMethodBeat.o(129291);
            return null;
        }
        AppBrandGuideUI.a aVar = auL().gRW;
        AppMethodBeat.o(129291);
        return aVar;
    }

    public static com.tencent.mm.plugin.appbrand.appstorage.b xG() {
        return gRj;
    }

    public static q auO() {
        AppMethodBeat.i(129292);
        synchronized (f.class) {
            try {
                if (!((gRn != null && gRn.ayG()) || gRr == null || gRr.dpU())) {
                    gRn = new q(gRr);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(129292);
            }
        }
        q qVar = gRn;
        return qVar;
    }

    public static z auP() {
        return gRo;
    }

    public static i auQ() {
        return gRq;
    }

    public static m auR() {
        return gRs;
    }

    public static com.tencent.mm.af.a.c auS() {
        return gRt;
    }

    public static c xH() {
        AppMethodBeat.i(129293);
        if (!(gRk != null || gRr == null || gRr.dpU())) {
            gRk = new c(gRr);
        }
        c cVar = gRk;
        AppMethodBeat.o(129293);
        return cVar;
    }

    public static w auT() {
        return gRm;
    }

    @Deprecated
    public static s auU() {
        AppMethodBeat.i(129294);
        s sVar = (s) E(s.class);
        AppMethodBeat.o(129294);
        return sVar;
    }

    public static ax auV() {
        return gRl;
    }

    public static com.tencent.mm.plugin.appbrand.widget.f auW() {
        return gRp;
    }

    public static com.tencent.mm.plugin.appbrand.c.c auX() {
        AppMethodBeat.i(129295);
        if (gRz == null) {
            gRz = new com.tencent.mm.plugin.appbrand.c.c();
        }
        com.tencent.mm.plugin.appbrand.c.c cVar = gRz;
        AppMethodBeat.o(129295);
        return cVar;
    }

    public static b auY() {
        AppMethodBeat.i(129296);
        if (gRA == null) {
            gRA = new b();
        }
        b bVar = gRA;
        AppMethodBeat.o(129296);
        return bVar;
    }

    public static com.tencent.mm.plugin.appbrand.q.a auZ() {
        return gRu;
    }

    public static ab ava() {
        return gRv;
    }

    public static com.tencent.mm.plugin.appbrand.game.b.a.c avb() {
        return gRw;
    }

    public static <T> T E(Class<T> cls) {
        AppMethodBeat.i(129297);
        if (cls == w.class) {
            w wVar = gRm;
            AppMethodBeat.o(129297);
            return wVar;
        }
        T E = a.E(cls);
        AppMethodBeat.o(129297);
        return E;
    }

    public static am avc() {
        return gRx;
    }

    public static ba avd() {
        return gRy;
    }

    public static com.tencent.mm.plugin.appbrand.backgroundfetch.d ave() {
        AppMethodBeat.i(129298);
        com.tencent.mm.plugin.appbrand.backgroundfetch.d dVar = (com.tencent.mm.plugin.appbrand.backgroundfetch.d) E(com.tencent.mm.plugin.appbrand.backgroundfetch.d.class);
        AppMethodBeat.o(129298);
        return dVar;
    }

    static /* synthetic */ void avf() {
        int i;
        AppMethodBeat.i(129299);
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100249");
        if (ll.isValid()) {
            i = bo.getInt((String) ll.dru().get("appbrand_player"), -1);
        } else {
            i = -1;
        }
        ah.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mu()).edit().putInt("appbrand_video_player", i).commit();
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreAppBrand", "check appbrand video ab test[%d]", Integer.valueOf(i));
        AppMethodBeat.o(129299);
    }

    static /* synthetic */ void avg() {
        AppMethodBeat.i(129300);
        try {
            com.tencent.xweb.m.jy(ah.getContext());
            com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100367");
            if (ll.isValid()) {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreAppBrand", "get abtest of webview core");
                Map dru = ll.dru();
                if (bo.getInt((String) dru.get("WebCoreTestFlag"), 0) == 1) {
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreAppBrand", "abtest of webview core is on");
                    int i = bo.getInt((String) dru.get("ModuleToolsType"), 2);
                    int i2 = bo.getInt((String) dru.get("ModuleAppbrandType"), 2);
                    int i3 = bo.getInt((String) dru.get("ModuleSupportType"), 2);
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreAppBrand", "moduleToolsType:" + i + ";moduleAppbrandType:" + i2 + ";moduleSupportType" + i3 + ":jsRuntimeType" + bo.getInt((String) dru.get("JsRuntimeType"), 0));
                    Editor edit = ah.getContext().getSharedPreferences("wcwebview", com.tencent.mm.compatible.util.h.Mu()).edit();
                    edit.putString("ABTestWebViewtools", WebView.d.values()[i].toString());
                    edit.putString("ABTestWebViewtoolsmp", WebView.d.values()[i].toString());
                    edit.putString("ABTestWebViewmm", WebView.d.values()[i].toString());
                    edit.putString("ABTestWebViewappbrand", WebView.d.values()[i2].toString());
                    edit.putString("ABTestWebViewsupport", WebView.d.values()[i3].toString());
                    edit.commit();
                    if (i == 1 || i2 == 1 || i3 == 1) {
                        XWalkEnvironment.setGrayValueForTest(1);
                    }
                }
            }
            AppMethodBeat.o(129300);
        } catch (Exception e) {
            AppMethodBeat.o(129300);
        }
    }

    static /* synthetic */ void avh() {
        AppMethodBeat.i(129301);
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100371");
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreAppBrand", "get abtest of XWebLocalDebug");
        if (ll.isValid()) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreAppBrand", "abtest of XWebLocalDebug is on");
            int i = bo.getInt((String) ll.dru().get("bEnableLocalDebug"), 0);
            Editor edit = ah.getContext().getSharedPreferences("wcwebview", com.tencent.mm.compatible.util.h.Mu()).edit();
            if (i == 1) {
                edit.putBoolean("m_bEnableLocalDebug", true).commit();
                AppMethodBeat.o(129301);
                return;
            }
            edit.putBoolean("m_bEnableLocalDebug", false).commit();
        }
        AppMethodBeat.o(129301);
    }

    static /* synthetic */ void avi() {
        AppMethodBeat.i(129302);
        try {
            com.tencent.xweb.m.jy(ah.getContext());
            com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100449");
            if (ll.isValid()) {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreAppBrand", "abtest of xweb command received");
                Map dru = ll.dru();
                if (bo.getInt((String) dru.get("WebCoreTestFlag"), 0) == 1) {
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreAppBrand", "WebCoreTestFlag is on");
                    String str = (String) dru.get("XWebConfigName");
                    if (str != null && str.trim().length() > 1) {
                        str = str.trim();
                        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreAppBrand", "abtest xweb config url  is ".concat(String.valueOf(str)));
                        com.tencent.mm.cj.c.iw(ah.getContext());
                        XWalkEnvironment.setTestDownLoadUrl(ah.getContext(), str);
                        com.tencent.xweb.a.a(null, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
                        edit.putLong("nLastFetchConfigTime", 0);
                        edit.putBoolean("bCanUseCellular", true);
                        edit.putLong("nTimeToUpdate", 100);
                        edit.commit();
                        ah.getContext();
                        com.tencent.mm.pluginsdk.model.v.a.Kv(5);
                    }
                    str = (String) dru.get("XWebCommand");
                    if (str != null && str.length() > 15) {
                        try {
                            new WebView(ah.getContext()).loadUrl(str);
                            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreAppBrand", "excute xwebcmd finished");
                            AppMethodBeat.o(129302);
                            return;
                        } catch (Exception e) {
                            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SubCoreAppBrand", "excute xwebcmd failed : " + e.getMessage());
                        }
                    }
                }
            }
            AppMethodBeat.o(129302);
        } catch (Exception e2) {
            AppMethodBeat.o(129302);
        }
    }

    static /* synthetic */ void avj() {
        AppMethodBeat.i(129303);
        com.tencent.mm.plugin.appbrand.appstorage.d.gXk.sg();
        AppMethodBeat.o(129303);
    }
}
