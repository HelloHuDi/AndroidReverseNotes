package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.bg.g;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.g.a.pc;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.e;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class l implements at {
    private com.tencent.mm.model.bz.a nKA = new com.tencent.mm.model.bz.a() {
        public final void a(com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(113352);
            new n().b(aVar);
            AppMethodBeat.o(113352);
        }
    };
    private c nKh = new c();
    private a nKi = new a();
    private b nKj = new b();
    private com.tencent.mm.plugin.location.model.a.a nKk;
    private int nKl = 0;
    private e nKm = new b();
    private e nKn = new n();
    private o nKo = null;
    private p nKp = null;
    private i nKq = null;
    private m nKr = null;
    private d nKs = new d();
    private k nKt = null;
    private j nKu = null;
    private f nKv = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(113343);
            if (i == 0 && i2 == 0) {
                u uVar = (u) mVar;
                bug ajC = uVar.ajC();
                if (ajC.jCt == 0) {
                    l.o(uVar.cvx, u.tu(ajC.vOt));
                }
            }
            AppMethodBeat.o(113343);
        }
    };
    private com.tencent.mm.sdk.b.c nKw = new com.tencent.mm.sdk.b.c<ez>() {
        {
            AppMethodBeat.i(113344);
            this.xxI = ez.class.getName().hashCode();
            AppMethodBeat.o(113344);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(113345);
            ez ezVar = (ez) bVar;
            ab.i("MicroMsg.SubCoreLocation", "exit track trackMgr:%s event:%s", com.tencent.mm.bh.d.fUv.akN(), ezVar.cys.username);
            l.bJy().stop();
            if (!bo.isNullOrNil(com.tencent.mm.bh.d.fUu.akM())) {
                l.bJy().xC(1);
                sz szVar = new sz();
                szVar.cPf.cPi = true;
                com.tencent.mm.sdk.b.a.xxA.m(szVar);
            }
            if (!bo.isNullOrNil(ezVar.cys.username)) {
                com.tencent.mm.plugin.location.a.a PQ = l.bJz().PQ(ezVar.cys.username);
                if (PQ != null) {
                    PQ.cGh.remove(r.Yz());
                    l.bJz().a(ezVar.cys.username, PQ.cGh, PQ.latitude, PQ.longitude, PQ.nJq, null, null);
                    if (g.fUs != null) {
                        g.fUs.a(ezVar.cys.username, null, null, null, 1);
                    }
                }
            }
            AppMethodBeat.o(113345);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c nKx = new com.tencent.mm.sdk.b.c<pc>() {
        {
            AppMethodBeat.i(113346);
            this.xxI = pc.class.getName().hashCode();
            AppMethodBeat.o(113346);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(113347);
            pc pcVar = (pc) bVar;
            ab.d("MicroMsg.SubCoreLocation", "trackEvent state " + pcVar.cLr.active);
            if (pcVar.cLr.active) {
                if (l.bJy().bJC() && l.bJy().nKO) {
                    l.bJy().bJE();
                }
            } else if (l.bJy().bJC()) {
                o bJy = l.bJy();
                ab.d("MicorMsg.TrackRefreshManager", "pause refresh");
                bJy.nKO = true;
                if (bJy.fwu != null) {
                    bJy.fwu.c(bJy.ecy);
                }
                if (bJy.nKF != null) {
                    bJy.nKF.b(bJy.nKU);
                }
            }
            AppMethodBeat.o(113347);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c nKy = new com.tencent.mm.sdk.b.c<ie>() {
        {
            AppMethodBeat.i(113348);
            this.xxI = ie.class.getName().hashCode();
            AppMethodBeat.o(113348);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(113349);
            ie ieVar = (ie) bVar;
            j bJx = l.bJx();
            bi biVar = ieVar.cDf.csG;
            ImageView imageView = ieVar.cDf.cDh;
            ProgressBar progressBar = ieVar.cDf.cDj;
            ImageView imageView2 = ieVar.cDf.cDi;
            int i = ieVar.cDf.cDk;
            int i2 = ieVar.cDf.w;
            int i3 = ieVar.cDf.h;
            String str = biVar.field_content;
            if (!bo.isNullOrNil(str)) {
                boolean z;
                String trim;
                com.tencent.mm.storage.bi.b Ro;
                bJx.w = i2;
                bJx.h = i3;
                if (bJx.w <= 0 || bJx.h <= 0) {
                    bJx.w = 300;
                    bJx.h = 300;
                }
                if (biVar.field_isSend == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (t.kH(biVar.field_talker) && z) {
                    int ox = bf.ox(str);
                    if (ox != -1) {
                        trim = str.substring(ox + 1).trim();
                        Ro = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Ro(trim);
                        if (biVar.dJB != 5 || bJx.nKa.contains(Long.valueOf(biVar.field_msgId))) {
                            ab.i("MicroMsg.StaticMapMsgLogic", "this has die %d errCount %d", Long.valueOf(biVar.field_msgId), Integer.valueOf(biVar.dJB));
                            imageView2.setVisibility(0);
                            progressBar.setVisibility(8);
                        } else {
                            com.tencent.mm.pluginsdk.location.b bVar2 = new com.tencent.mm.pluginsdk.location.b(biVar.field_msgId, (float) Ro.nJu, (float) Ro.nJv, (int) (((double) Ro.cED) * 1.1d), 0);
                            progressBar.setVisibility(0);
                            imageView2.setVisibility(8);
                            k bJw = l.bJw();
                            bJw.w = i2;
                            bJw.h = i3;
                            if (bJw.w <= 0 || bJw.h <= 0) {
                                bJw.w = 300;
                                bJw.h = 300;
                            }
                            String b = k.b(bVar2);
                            if (com.tencent.mm.vfs.e.ct(b)) {
                                if (!com.tencent.mm.kernel.g.RK()) {
                                    b = "";
                                }
                            } else if (bJw.nKc == null || !bJw.nKc.toString().equals(bVar2.toString())) {
                                Iterator it = bJw.nKb.iterator();
                                while (it.hasNext()) {
                                    if (bVar2.toString().equals(((com.tencent.mm.pluginsdk.location.b) it.next()).toString())) {
                                        ab.i("MicroMsg.StaticMapServer", "has add queue");
                                        bJw.agx();
                                        b = "";
                                        break;
                                    }
                                }
                                bJw.nKb.add(bVar2);
                                ab.i("MicroMsg.StaticMapServer", "task size %d w%d h %d", Integer.valueOf(bJw.nKb.size()), Integer.valueOf(bJw.w), Integer.valueOf(bJw.h));
                                bJw.agx();
                                b = "";
                            } else {
                                ab.i("MicroMsg.StaticMapServer", "has add queue");
                                bJw.agx();
                                b = "";
                            }
                            if (bo.isNullOrNil(b) || !com.tencent.mm.vfs.e.ct(b)) {
                                bJx.nJV.put(Long.valueOf(bVar2.itemId), Ro);
                                bJx.nJZ.put(Long.valueOf(biVar.field_msgId), Integer.valueOf(i));
                                bJx.nJY.put(Ro, biVar);
                                bJx.nJU.put(Long.valueOf(biVar.field_msgId), new WeakReference(imageView));
                                bJx.nJW.put(Long.valueOf(biVar.field_msgId), new WeakReference(progressBar));
                                bJx.nJX.put(Long.valueOf(biVar.field_msgId), new WeakReference(imageView2));
                                bJx.start();
                            } else {
                                ab.d("MicroMsg.StaticMapMsgLogic", "readloc from local %d", Integer.valueOf(i));
                                if (com.tencent.mm.kernel.g.RK()) {
                                    Bitmap a = o.ahl().a(biVar.field_msgId, b, i, bJx.w, bJx.h, z);
                                    if (!(a == null || a.isRecycled())) {
                                        imageView.setImageBitmap(a);
                                        progressBar.setVisibility(8);
                                        imageView2.setVisibility(0);
                                    }
                                }
                            }
                        }
                    }
                }
                trim = str;
                Ro = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Ro(trim);
                if (biVar.dJB != 5) {
                }
                ab.i("MicroMsg.StaticMapMsgLogic", "this has die %d errCount %d", Long.valueOf(biVar.field_msgId), Integer.valueOf(biVar.dJB));
                imageView2.setVisibility(0);
                progressBar.setVisibility(8);
            }
            AppMethodBeat.o(113349);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c nKz = new com.tencent.mm.sdk.b.c<bn>() {
        {
            AppMethodBeat.i(113350);
            this.xxI = bn.class.getName().hashCode();
            AppMethodBeat.o(113350);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(113351);
            com.tencent.mm.pluginsdk.location.a bJx = l.bJx();
            ab.i("MicroMsg.StaticMapMsgLogic", "clean task");
            bJx.nJU.clear();
            bJx.nJY.clear();
            bJx.nJZ.clear();
            bJx.nJW.clear();
            bJx.nJX.clear();
            bJx.nKa.clear();
            bJx.nJV.clear();
            l.bJw().b(bJx);
            l.bJw().b(bJx);
            AppMethodBeat.o(113351);
            return false;
        }
    };

    static final class a extends com.tencent.mm.sdk.b.c<gl> {
        private a() {
            AppMethodBeat.i(113353);
            this.xxI = gl.class.getName().hashCode();
            AppMethodBeat.o(113353);
        }

        /* synthetic */ a(byte b) {
            this();
            AppMethodBeat.i(113355);
            this.xxI = gl.class.getName().hashCode();
            AppMethodBeat.o(113355);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(113354);
            gl glVar = (gl) bVar;
            if (glVar instanceof gl) {
                l.X(glVar.cBd.csG);
                AppMethodBeat.o(113354);
                return true;
            }
            AppMethodBeat.o(113354);
            return false;
        }
    }

    static final class c extends com.tencent.mm.sdk.b.c<jj> {
        private volatile boolean UO;

        private c() {
            AppMethodBeat.i(113359);
            this.UO = false;
            this.xxI = jj.class.getName().hashCode();
            AppMethodBeat.o(113359);
        }

        /* synthetic */ c(byte b) {
            this();
            AppMethodBeat.i(113361);
            this.xxI = jj.class.getName().hashCode();
            AppMethodBeat.o(113361);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(113360);
            jj jjVar = (jj) bVar;
            if (jjVar instanceof jj) {
                ab.d("MicroMsg.SubCoreLocation", "e.data.eventType : " + jjVar.cEF.cEA);
                switch (jjVar.cEF.cEA) {
                    case 0:
                        l.bJv().nJC = new HashSet();
                        this.UO = true;
                        break;
                    case 1:
                        if (!this.UO) {
                            jjVar.cEG.cBp = "err_not_started";
                            break;
                        }
                        String[] W = l.bJv().W(jjVar.cEF.csG);
                        jjVar.cEG.cBp = W[0];
                        jjVar.cEG.cEI = W[1];
                        break;
                    case 2:
                        if (this.UO) {
                            l.bJv().bJq();
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(113360);
                return true;
            }
            AppMethodBeat.o(113360);
            return false;
        }
    }

    static final class b extends com.tencent.mm.sdk.b.c<jh> {
        private b() {
            AppMethodBeat.i(113356);
            this.xxI = jh.class.getName().hashCode();
            AppMethodBeat.o(113356);
        }

        /* synthetic */ b(byte b) {
            this();
            AppMethodBeat.i(113358);
            this.xxI = jh.class.getName().hashCode();
            AppMethodBeat.o(113358);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(113357);
            jh jhVar = (jh) bVar;
            if (jhVar instanceof jh) {
                ab.d("MicroMsg.SubCoreLocation", "e.data.eventType : " + jhVar.cEy.cEA);
                switch (jhVar.cEy.cEA) {
                    case 0:
                        jhVar.cEz.path = e.a(jhVar.cEy.imgPath, jhVar.cEy.filename, jhVar.cEy.view);
                        break;
                    case 1:
                        com.tencent.mm.pluginsdk.location.b bVar2 = new com.tencent.mm.pluginsdk.location.b(-1, jhVar.cEy.cEB, jhVar.cEy.cEC, jhVar.cEy.cED, 1);
                        jhVar.cEz.path = k.b(bVar2);
                        break;
                    case 2:
                        com.tencent.mm.kernel.g.Rg().a(new g(jhVar.cEy.cEB, jhVar.cEy.cEC, jhVar.cEy.cED, jhVar.cEy.width, jhVar.cEy.height, jhVar.cEy.filename, aa.dor()), 0);
                        break;
                    case 3:
                        g gVar = (g) jhVar.cEy.cwn;
                        jhVar.cEz.path = gVar.nJG;
                        break;
                }
                AppMethodBeat.o(113357);
                return true;
            }
            AppMethodBeat.o(113357);
            return false;
        }
    }

    public l() {
        AppMethodBeat.i(113362);
        AppMethodBeat.o(113362);
    }

    private static l bJu() {
        AppMethodBeat.i(113363);
        l lVar = (l) q.Y(l.class);
        AppMethodBeat.o(113363);
        return lVar;
    }

    public static com.tencent.mm.plugin.location.model.a.a bJv() {
        AppMethodBeat.i(113364);
        com.tencent.mm.kernel.g.RN().QU();
        if (bJu().nKk == null) {
            bJu().nKk = new com.tencent.mm.plugin.location.model.a.a();
        }
        com.tencent.mm.plugin.location.model.a.a aVar = bJu().nKk;
        AppMethodBeat.o(113364);
        return aVar;
    }

    public static k bJw() {
        AppMethodBeat.i(113365);
        com.tencent.mm.kernel.g.RN().QU();
        if (bJu().nKt == null) {
            bJu().nKt = new k();
        }
        k kVar = bJu().nKt;
        AppMethodBeat.o(113365);
        return kVar;
    }

    public static j bJx() {
        AppMethodBeat.i(113366);
        com.tencent.mm.kernel.g.RN().QU();
        if (bJu().nKu == null) {
            bJu().nKu = new j();
        }
        j jVar = bJu().nKu;
        AppMethodBeat.o(113366);
        return jVar;
    }

    public static o bJy() {
        AppMethodBeat.i(113367);
        if (bJu().nKo == null) {
            bJu().nKo = new o();
        }
        o oVar = bJu().nKo;
        AppMethodBeat.o(113367);
        return oVar;
    }

    public static p bJz() {
        AppMethodBeat.i(113368);
        if (bJu().nKp == null) {
            bJu().nKp = new p();
        }
        p pVar = bJu().nKp;
        AppMethodBeat.o(113368);
        return pVar;
    }

    public static i bJA() {
        AppMethodBeat.i(113369);
        if (bJu().nKq == null) {
            bJu().nKq = new i();
        }
        i iVar = bJu().nKq;
        AppMethodBeat.o(113369);
        return iVar;
    }

    public static void X(bi biVar) {
        AppMethodBeat.i(113370);
        if (!(biVar == null || biVar.field_msgId == 0)) {
            com.tencent.mm.storage.bi.b apD = com.tencent.mm.storage.bi.b.apD(biVar.field_content);
            com.tencent.mm.kernel.g.Rg().a(new u((float) apD.nJv, (float) apD.nJu, biVar.field_msgId), 0);
        }
        AppMethodBeat.o(113370);
    }

    public static String bJB() {
        AppMethodBeat.i(113371);
        String str = com.tencent.mm.kernel.g.RP().cachePath + "trackroom/";
        AppMethodBeat.o(113371);
        return str;
    }

    public final HashMap<Integer, h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(113372);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(48), this.nKm);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(61), this.nKn);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("trackmsg", this.nKA, true);
        com.tencent.mm.kernel.g.Rg().a((int) v2helper.EMethodSetSpkEnhance, this.nKv);
        com.tencent.mm.sdk.b.a.xxA.c(this.nKh);
        com.tencent.mm.sdk.b.a.xxA.c(this.nKi);
        com.tencent.mm.sdk.b.a.xxA.c(this.nKw);
        com.tencent.mm.sdk.b.a.xxA.c(this.nKx);
        com.tencent.mm.sdk.b.a.xxA.c(this.nKy);
        com.tencent.mm.sdk.b.a.xxA.c(this.nKz);
        com.tencent.mm.sdk.b.a.xxA.c(this.nKj);
        com.tencent.mm.bh.d.fUv = bJy();
        com.tencent.mm.bh.d.fUu = bJz();
        if (bJu().nKr == null) {
            bJu().nKr = new m();
        }
        com.tencent.mm.bv.a.a.a.xtT = bJu().nKr;
        com.tencent.mm.kernel.g.RN().QU();
        if (bJu().nKs == null) {
            bJu().nKs = new d();
        }
        com.tencent.mm.plugin.k.c.a.nRw = bJu().nKs;
        AppMethodBeat.o(113372);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(113373);
        if (this.nKo != null) {
            this.nKo.nKP = null;
            this.nKo.stop();
            this.nKo.xC(1);
        }
        com.tencent.mm.ai.e.d.b(Integer.valueOf(48), this.nKm);
        com.tencent.mm.ai.e.d.b(Integer.valueOf(61), this.nKn);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("trackmsg", this.nKA, true);
        com.tencent.mm.kernel.g.Rg().b((int) v2helper.EMethodSetSpkEnhance, this.nKv);
        com.tencent.mm.sdk.b.a.xxA.d(this.nKh);
        com.tencent.mm.sdk.b.a.xxA.d(this.nKi);
        com.tencent.mm.sdk.b.a.xxA.d(this.nKw);
        com.tencent.mm.sdk.b.a.xxA.d(this.nKx);
        com.tencent.mm.sdk.b.a.xxA.d(this.nKy);
        com.tencent.mm.sdk.b.a.xxA.d(this.nKz);
        com.tencent.mm.sdk.b.a.xxA.d(this.nKj);
        if (this.nKq != null) {
            i iVar = this.nKq;
            iVar.bJt();
            iVar.nJM.clear();
        }
        if (this.nKt != null) {
            this.nKt.stop();
        }
        if (this.nKu != null) {
            bJw().b(this.nKu);
        }
        AppMethodBeat.o(113373);
    }

    public final void bA(boolean z) {
    }

    public static void o(long j, String str) {
        AppMethodBeat.i(113374);
        bi jf = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(j);
        if (jf.bAC()) {
            jf.jw(str);
            ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().a(j, jf);
        }
        AppMethodBeat.o(113374);
    }
}
