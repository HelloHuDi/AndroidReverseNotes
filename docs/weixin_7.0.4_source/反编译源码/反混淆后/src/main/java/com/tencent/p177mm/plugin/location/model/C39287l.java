package com.tencent.p177mm.plugin.location.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C42194e;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.modelsimple.C45453u;
import com.tencent.p177mm.p1376bv.p1377a.C32428a.C25995a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p203bg.C32337g;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C32525bn;
import com.tencent.p177mm.p230g.p231a.C32580jh;
import com.tencent.p177mm.p230g.p231a.C37735ie;
import com.tencent.p177mm.p230g.p231a.C42034pc;
import com.tencent.p177mm.p230g.p231a.C42062sz;
import com.tencent.p177mm.p230g.p231a.C45322ez;
import com.tencent.p177mm.p230g.p231a.C45335jj;
import com.tencent.p177mm.p230g.p231a.C9359gl;
import com.tencent.p177mm.p837bh.C25859d;
import com.tencent.p177mm.plugin.location.model.C12375a.C12376a;
import com.tencent.p177mm.plugin.location.p446ui.impl.C39293d;
import com.tencent.p177mm.plugin.location.p734a.C6958a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.p443k.C12329c.C3329a;
import com.tencent.p177mm.pluginsdk.location.C14865a;
import com.tencent.p177mm.pluginsdk.location.C14866b;
import com.tencent.p177mm.protocal.protobuf.bug;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5136b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.location.model.l */
public class C39287l implements C1816at {
    private C1837a nKA = new C123796();
    private C21173c nKh = new C21173c();
    private C12380a nKi = new C12380a();
    private C28364b nKj = new C28364b();
    private C12376a nKk;
    private int nKl = 0;
    private C42194e nKm = new C46044b();
    private C42194e nKn = new C44749n();
    private C28366o nKo = null;
    private C21175p nKp = null;
    private C28360i nKq = null;
    private C43243m nKr = null;
    private C39293d nKs = new C39293d();
    private C46046k nKt = null;
    private C21172j nKu = null;
    private C1202f nKv = new C392851();
    private C4884c nKw = new C392882();
    private C4884c nKx = new C392863();
    private C4884c nKy = new C283634();
    private C4884c nKz = new C123785();

    /* renamed from: com.tencent.mm.plugin.location.model.l$5 */
    class C123785 extends C4884c<C32525bn> {
        C123785() {
            AppMethodBeat.m2504i(113350);
            this.xxI = C32525bn.class.getName().hashCode();
            AppMethodBeat.m2505o(113350);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(113351);
            C14865a bJx = C39287l.bJx();
            C4990ab.m7416i("MicroMsg.StaticMapMsgLogic", "clean task");
            bJx.nJU.clear();
            bJx.nJY.clear();
            bJx.nJZ.clear();
            bJx.nJW.clear();
            bJx.nJX.clear();
            bJx.nKa.clear();
            bJx.nJV.clear();
            C39287l.bJw().mo73940b(bJx);
            C39287l.bJw().mo73940b(bJx);
            AppMethodBeat.m2505o(113351);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.model.l$6 */
    class C123796 implements C1837a {
        C123796() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(113352);
            new C44749n().mo4453b(c1197a);
            AppMethodBeat.m2505o(113352);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.model.l$a */
    static final class C12380a extends C4884c<C9359gl> {
        private C12380a() {
            AppMethodBeat.m2504i(113353);
            this.xxI = C9359gl.class.getName().hashCode();
            AppMethodBeat.m2505o(113353);
        }

        /* synthetic */ C12380a(byte b) {
            this();
            AppMethodBeat.m2504i(113355);
            this.xxI = C9359gl.class.getName().hashCode();
            AppMethodBeat.m2505o(113355);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(113354);
            C9359gl c9359gl = (C9359gl) c4883b;
            if (c9359gl instanceof C9359gl) {
                C39287l.m66957X(c9359gl.cBd.csG);
                AppMethodBeat.m2505o(113354);
                return true;
            }
            AppMethodBeat.m2505o(113354);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.model.l$c */
    static final class C21173c extends C4884c<C45335jj> {
        /* renamed from: UO */
        private volatile boolean f4388UO;

        private C21173c() {
            AppMethodBeat.m2504i(113359);
            this.f4388UO = false;
            this.xxI = C45335jj.class.getName().hashCode();
            AppMethodBeat.m2505o(113359);
        }

        /* synthetic */ C21173c(byte b) {
            this();
            AppMethodBeat.m2504i(113361);
            this.xxI = C45335jj.class.getName().hashCode();
            AppMethodBeat.m2505o(113361);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(113360);
            C45335jj c45335jj = (C45335jj) c4883b;
            if (c45335jj instanceof C45335jj) {
                C4990ab.m7410d("MicroMsg.SubCoreLocation", "e.data.eventType : " + c45335jj.cEF.cEA);
                switch (c45335jj.cEF.cEA) {
                    case 0:
                        C39287l.bJv().nJC = new HashSet();
                        this.f4388UO = true;
                        break;
                    case 1:
                        if (!this.f4388UO) {
                            c45335jj.cEG.cBp = "err_not_started";
                            break;
                        }
                        String[] W = C39287l.bJv().mo24226W(c45335jj.cEF.csG);
                        c45335jj.cEG.cBp = W[0];
                        c45335jj.cEG.cEI = W[1];
                        break;
                    case 2:
                        if (this.f4388UO) {
                            C39287l.bJv().bJq();
                            break;
                        }
                        break;
                }
                AppMethodBeat.m2505o(113360);
                return true;
            }
            AppMethodBeat.m2505o(113360);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.model.l$4 */
    class C283634 extends C4884c<C37735ie> {
        C283634() {
            AppMethodBeat.m2504i(113348);
            this.xxI = C37735ie.class.getName().hashCode();
            AppMethodBeat.m2505o(113348);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(113349);
            C37735ie c37735ie = (C37735ie) c4883b;
            C21172j bJx = C39287l.bJx();
            C7620bi c7620bi = c37735ie.cDf.csG;
            ImageView imageView = c37735ie.cDf.cDh;
            ProgressBar progressBar = c37735ie.cDf.cDj;
            ImageView imageView2 = c37735ie.cDf.cDi;
            int i = c37735ie.cDf.cDk;
            int i2 = c37735ie.cDf.f16122w;
            int i3 = c37735ie.cDf.f16121h;
            String str = c7620bi.field_content;
            if (!C5046bo.isNullOrNil(str)) {
                boolean z;
                String trim;
                C5136b Ro;
                bJx.f4387w = i2;
                bJx.f4386h = i3;
                if (bJx.f4387w <= 0 || bJx.f4386h <= 0) {
                    bJx.f4387w = 300;
                    bJx.f4386h = 300;
                }
                if (c7620bi.field_isSend == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (C1855t.m3896kH(c7620bi.field_talker) && z) {
                    int ox = C1829bf.m3761ox(str);
                    if (ox != -1) {
                        trim = str.substring(ox + 1).trim();
                        Ro = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15261Ro(trim);
                        if (c7620bi.dJB != 5 || bJx.nKa.contains(Long.valueOf(c7620bi.field_msgId))) {
                            C4990ab.m7417i("MicroMsg.StaticMapMsgLogic", "this has die %d errCount %d", Long.valueOf(c7620bi.field_msgId), Integer.valueOf(c7620bi.dJB));
                            imageView2.setVisibility(0);
                            progressBar.setVisibility(8);
                        } else {
                            C14866b c14866b = new C14866b(c7620bi.field_msgId, (float) Ro.nJu, (float) Ro.nJv, (int) (((double) Ro.cED) * 1.1d), 0);
                            progressBar.setVisibility(0);
                            imageView2.setVisibility(8);
                            C46046k bJw = C39287l.bJw();
                            bJw.f17898w = i2;
                            bJw.f17897h = i3;
                            if (bJw.f17898w <= 0 || bJw.f17897h <= 0) {
                                bJw.f17898w = 300;
                                bJw.f17897h = 300;
                            }
                            String b = C46046k.m85709b(c14866b);
                            if (C5730e.m8628ct(b)) {
                                if (!C1720g.m3531RK()) {
                                    b = "";
                                }
                            } else if (bJw.nKc == null || !bJw.nKc.toString().equals(c14866b.toString())) {
                                Iterator it = bJw.nKb.iterator();
                                while (it.hasNext()) {
                                    if (c14866b.toString().equals(((C14866b) it.next()).toString())) {
                                        C4990ab.m7416i("MicroMsg.StaticMapServer", "has add queue");
                                        bJw.agx();
                                        b = "";
                                        break;
                                    }
                                }
                                bJw.nKb.add(c14866b);
                                C4990ab.m7417i("MicroMsg.StaticMapServer", "task size %d w%d h %d", Integer.valueOf(bJw.nKb.size()), Integer.valueOf(bJw.f17898w), Integer.valueOf(bJw.f17897h));
                                bJw.agx();
                                b = "";
                            } else {
                                C4990ab.m7416i("MicroMsg.StaticMapServer", "has add queue");
                                bJw.agx();
                                b = "";
                            }
                            if (C5046bo.isNullOrNil(b) || !C5730e.m8628ct(b)) {
                                bJx.nJV.put(Long.valueOf(c14866b.itemId), Ro);
                                bJx.nJZ.put(Long.valueOf(c7620bi.field_msgId), Integer.valueOf(i));
                                bJx.nJY.put(Ro, c7620bi);
                                bJx.nJU.put(Long.valueOf(c7620bi.field_msgId), new WeakReference(imageView));
                                bJx.nJW.put(Long.valueOf(c7620bi.field_msgId), new WeakReference(progressBar));
                                bJx.nJX.put(Long.valueOf(c7620bi.field_msgId), new WeakReference(imageView2));
                                bJx.start();
                            } else {
                                C4990ab.m7411d("MicroMsg.StaticMapMsgLogic", "readloc from local %d", Integer.valueOf(i));
                                if (C1720g.m3531RK()) {
                                    Bitmap a = C32291o.ahl().mo73084a(c7620bi.field_msgId, b, i, bJx.f4387w, bJx.f4386h, z);
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
                Ro = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15261Ro(trim);
                if (c7620bi.dJB != 5) {
                }
                C4990ab.m7417i("MicroMsg.StaticMapMsgLogic", "this has die %d errCount %d", Long.valueOf(c7620bi.field_msgId), Integer.valueOf(c7620bi.dJB));
                imageView2.setVisibility(0);
                progressBar.setVisibility(8);
            }
            AppMethodBeat.m2505o(113349);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.model.l$b */
    static final class C28364b extends C4884c<C32580jh> {
        private C28364b() {
            AppMethodBeat.m2504i(113356);
            this.xxI = C32580jh.class.getName().hashCode();
            AppMethodBeat.m2505o(113356);
        }

        /* synthetic */ C28364b(byte b) {
            this();
            AppMethodBeat.m2504i(113358);
            this.xxI = C32580jh.class.getName().hashCode();
            AppMethodBeat.m2505o(113358);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(113357);
            C32580jh c32580jh = (C32580jh) c4883b;
            if (c32580jh instanceof C32580jh) {
                C4990ab.m7410d("MicroMsg.SubCoreLocation", "e.data.eventType : " + c32580jh.cEy.cEA);
                switch (c32580jh.cEy.cEA) {
                    case 0:
                        c32580jh.cEz.path = C39283e.m66952a(c32580jh.cEy.imgPath, c32580jh.cEy.filename, c32580jh.cEy.view);
                        break;
                    case 1:
                        C14866b c14866b = new C14866b(-1, c32580jh.cEy.cEB, c32580jh.cEy.cEC, c32580jh.cEy.cED, 1);
                        c32580jh.cEz.path = C46046k.m85709b(c14866b);
                        break;
                    case 2:
                        C1720g.m3540Rg().mo14541a(new C28359g(c32580jh.cEy.cEB, c32580jh.cEy.cEC, c32580jh.cEy.cED, c32580jh.cEy.width, c32580jh.cEy.height, c32580jh.cEy.filename, C4988aa.dor()), 0);
                        break;
                    case 3:
                        C28359g c28359g = (C28359g) c32580jh.cEy.cwn;
                        c32580jh.cEz.path = c28359g.nJG;
                        break;
                }
                AppMethodBeat.m2505o(113357);
                return true;
            }
            AppMethodBeat.m2505o(113357);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.model.l$1 */
    class C392851 implements C1202f {
        C392851() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(113343);
            if (i == 0 && i2 == 0) {
                C45453u c45453u = (C45453u) c1207m;
                bug ajC = c45453u.ajC();
                if (ajC.jCt == 0) {
                    C39287l.m66958o(c45453u.cvx, C45453u.m83729tu(ajC.vOt));
                }
            }
            AppMethodBeat.m2505o(113343);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.model.l$3 */
    class C392863 extends C4884c<C42034pc> {
        C392863() {
            AppMethodBeat.m2504i(113346);
            this.xxI = C42034pc.class.getName().hashCode();
            AppMethodBeat.m2505o(113346);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(113347);
            C42034pc c42034pc = (C42034pc) c4883b;
            C4990ab.m7410d("MicroMsg.SubCoreLocation", "trackEvent state " + c42034pc.cLr.active);
            if (c42034pc.cLr.active) {
                if (C39287l.bJy().bJC() && C39287l.bJy().nKO) {
                    C39287l.bJy().bJE();
                }
            } else if (C39287l.bJy().bJC()) {
                C28366o bJy = C39287l.bJy();
                C4990ab.m7410d("MicorMsg.TrackRefreshManager", "pause refresh");
                bJy.nKO = true;
                if (bJy.fwu != null) {
                    bJy.fwu.mo44208c(bJy.ecy);
                }
                if (bJy.nKF != null) {
                    bJy.nKF.mo46316b(bJy.nKU);
                }
            }
            AppMethodBeat.m2505o(113347);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.model.l$2 */
    class C392882 extends C4884c<C45322ez> {
        C392882() {
            AppMethodBeat.m2504i(113344);
            this.xxI = C45322ez.class.getName().hashCode();
            AppMethodBeat.m2505o(113344);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(113345);
            C45322ez c45322ez = (C45322ez) c4883b;
            C4990ab.m7417i("MicroMsg.SubCoreLocation", "exit track trackMgr:%s event:%s", C25859d.fUv.akN(), c45322ez.cys.username);
            C39287l.bJy().stop();
            if (!C5046bo.isNullOrNil(C25859d.fUu.akM())) {
                C39287l.bJy().mo46328xC(1);
                C42062sz c42062sz = new C42062sz();
                c42062sz.cPf.cPi = true;
                C4879a.xxA.mo10055m(c42062sz);
            }
            if (!C5046bo.isNullOrNil(c45322ez.cys.username)) {
                C6958a PQ = C39287l.bJz().mo36494PQ(c45322ez.cys.username);
                if (PQ != null) {
                    PQ.cGh.remove(C1853r.m3846Yz());
                    C39287l.bJz().mo20559a(c45322ez.cys.username, PQ.cGh, PQ.latitude, PQ.longitude, PQ.nJq, null, null);
                    if (C32337g.fUs != null) {
                        C32337g.fUs.mo4621a(c45322ez.cys.username, null, null, null, 1);
                    }
                }
            }
            AppMethodBeat.m2505o(113345);
            return false;
        }
    }

    public C39287l() {
        AppMethodBeat.m2504i(113362);
        AppMethodBeat.m2505o(113362);
    }

    private static C39287l bJu() {
        AppMethodBeat.m2504i(113363);
        C39287l c39287l = (C39287l) C7485q.m12925Y(C39287l.class);
        AppMethodBeat.m2505o(113363);
        return c39287l;
    }

    public static C12376a bJv() {
        AppMethodBeat.m2504i(113364);
        C1720g.m3534RN().mo5159QU();
        if (C39287l.bJu().nKk == null) {
            C39287l.bJu().nKk = new C12376a();
        }
        C12376a c12376a = C39287l.bJu().nKk;
        AppMethodBeat.m2505o(113364);
        return c12376a;
    }

    public static C46046k bJw() {
        AppMethodBeat.m2504i(113365);
        C1720g.m3534RN().mo5159QU();
        if (C39287l.bJu().nKt == null) {
            C39287l.bJu().nKt = new C46046k();
        }
        C46046k c46046k = C39287l.bJu().nKt;
        AppMethodBeat.m2505o(113365);
        return c46046k;
    }

    public static C21172j bJx() {
        AppMethodBeat.m2504i(113366);
        C1720g.m3534RN().mo5159QU();
        if (C39287l.bJu().nKu == null) {
            C39287l.bJu().nKu = new C21172j();
        }
        C21172j c21172j = C39287l.bJu().nKu;
        AppMethodBeat.m2505o(113366);
        return c21172j;
    }

    public static C28366o bJy() {
        AppMethodBeat.m2504i(113367);
        if (C39287l.bJu().nKo == null) {
            C39287l.bJu().nKo = new C28366o();
        }
        C28366o c28366o = C39287l.bJu().nKo;
        AppMethodBeat.m2505o(113367);
        return c28366o;
    }

    public static C21175p bJz() {
        AppMethodBeat.m2504i(113368);
        if (C39287l.bJu().nKp == null) {
            C39287l.bJu().nKp = new C21175p();
        }
        C21175p c21175p = C39287l.bJu().nKp;
        AppMethodBeat.m2505o(113368);
        return c21175p;
    }

    public static C28360i bJA() {
        AppMethodBeat.m2504i(113369);
        if (C39287l.bJu().nKq == null) {
            C39287l.bJu().nKq = new C28360i();
        }
        C28360i c28360i = C39287l.bJu().nKq;
        AppMethodBeat.m2505o(113369);
        return c28360i;
    }

    /* renamed from: X */
    public static void m66957X(C7620bi c7620bi) {
        AppMethodBeat.m2504i(113370);
        if (!(c7620bi == null || c7620bi.field_msgId == 0)) {
            C5136b apD = C5136b.apD(c7620bi.field_content);
            C1720g.m3540Rg().mo14541a(new C45453u((float) apD.nJv, (float) apD.nJu, c7620bi.field_msgId), 0);
        }
        AppMethodBeat.m2505o(113370);
    }

    public static String bJB() {
        AppMethodBeat.m2504i(113371);
        String str = C1720g.m3536RP().cachePath + "trackroom/";
        AppMethodBeat.m2505o(113371);
        return str;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(113372);
        C1200d.m2636a(Integer.valueOf(48), this.nKm);
        C1200d.m2636a(Integer.valueOf(61), this.nKn);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("trackmsg", this.nKA, true);
        C1720g.m3540Rg().mo14539a((int) v2helper.EMethodSetSpkEnhance, this.nKv);
        C4879a.xxA.mo10052c(this.nKh);
        C4879a.xxA.mo10052c(this.nKi);
        C4879a.xxA.mo10052c(this.nKw);
        C4879a.xxA.mo10052c(this.nKx);
        C4879a.xxA.mo10052c(this.nKy);
        C4879a.xxA.mo10052c(this.nKz);
        C4879a.xxA.mo10052c(this.nKj);
        C25859d.fUv = C39287l.bJy();
        C25859d.fUu = C39287l.bJz();
        if (C39287l.bJu().nKr == null) {
            C39287l.bJu().nKr = new C43243m();
        }
        C25995a.xtT = C39287l.bJu().nKr;
        C1720g.m3534RN().mo5159QU();
        if (C39287l.bJu().nKs == null) {
            C39287l.bJu().nKs = new C39293d();
        }
        C3329a.nRw = C39287l.bJu().nKs;
        AppMethodBeat.m2505o(113372);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(113373);
        if (this.nKo != null) {
            this.nKo.nKP = null;
            this.nKo.stop();
            this.nKo.mo46328xC(1);
        }
        C1200d.m2637b(Integer.valueOf(48), this.nKm);
        C1200d.m2637b(Integer.valueOf(61), this.nKn);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("trackmsg", this.nKA, true);
        C1720g.m3540Rg().mo14546b((int) v2helper.EMethodSetSpkEnhance, this.nKv);
        C4879a.xxA.mo10053d(this.nKh);
        C4879a.xxA.mo10053d(this.nKi);
        C4879a.xxA.mo10053d(this.nKw);
        C4879a.xxA.mo10053d(this.nKx);
        C4879a.xxA.mo10053d(this.nKy);
        C4879a.xxA.mo10053d(this.nKz);
        C4879a.xxA.mo10053d(this.nKj);
        if (this.nKq != null) {
            C28360i c28360i = this.nKq;
            c28360i.bJt();
            c28360i.nJM.clear();
        }
        if (this.nKt != null) {
            this.nKt.stop();
        }
        if (this.nKu != null) {
            C39287l.bJw().mo73940b(this.nKu);
        }
        AppMethodBeat.m2505o(113373);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: o */
    public static void m66958o(long j, String str) {
        AppMethodBeat.m2504i(113374);
        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j);
        if (jf.bAC()) {
            jf.mo14796jw(str);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(j, jf);
        }
        AppMethodBeat.m2505o(113374);
    }
}
