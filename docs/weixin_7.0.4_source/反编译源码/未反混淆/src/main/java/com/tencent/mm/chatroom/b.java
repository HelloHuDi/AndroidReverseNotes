package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.chatroom.b.a;
import com.tencent.mm.chatroom.c.f;
import com.tencent.mm.chatroom.c.g;
import com.tencent.mm.chatroom.c.h;
import com.tencent.mm.chatroom.c.k;
import com.tencent.mm.chatroom.c.n;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.g.a.km;
import com.tencent.mm.g.a.kq;
import com.tencent.mm.g.a.ss;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.view.d;
import java.util.HashMap;

public class b implements at {
    private static a egR;
    private c<kj> egL = new c<kj>() {
        public final /* bridge */ /* synthetic */ com.tencent.mm.sdk.b.b a(int i, m mVar, com.tencent.mm.sdk.b.b bVar) {
            return (kj) bVar;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(103875);
            kj kjVar = (kj) bVar;
            if (kjVar.cFR.cFT) {
                c.k(kjVar);
                AppMethodBeat.o(103875);
            } else {
                l(kjVar);
                AppMethodBeat.o(103875);
            }
            return false;
        }

        public final /* synthetic */ m b(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(103874);
            f fVar = new f(((kj) bVar).cFR.cFS);
            AppMethodBeat.o(103874);
            return fVar;
        }

        public final int Jy() {
            return 181;
        }
    };
    private c<km> egM = new c<km>() {
        public final /* bridge */ /* synthetic */ com.tencent.mm.sdk.b.b a(int i, m mVar, com.tencent.mm.sdk.b.b bVar) {
            return (km) bVar;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(103877);
            km kmVar = (km) bVar;
            if (kmVar.cGi.cFT) {
                c.k(kmVar);
                AppMethodBeat.o(103877);
            } else {
                l(kmVar);
                AppMethodBeat.o(103877);
            }
            return false;
        }

        public final /* synthetic */ m b(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(103876);
            km kmVar = (km) bVar;
            k kVar = new k(kmVar.cGi.chatroomName, kmVar.cGi.cGj);
            AppMethodBeat.o(103876);
            return kVar;
        }

        public final int Jy() {
            return 551;
        }
    };
    private c<kl> egN = new c<kl>() {
        public final /* bridge */ /* synthetic */ com.tencent.mm.sdk.b.b a(int i, m mVar, com.tencent.mm.sdk.b.b bVar) {
            kl klVar = (kl) bVar;
            klVar.cGg.errCode = i;
            return klVar;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(103879);
            kl klVar = (kl) bVar;
            if (klVar.cGf.cFT) {
                c.k(klVar);
                AppMethodBeat.o(103879);
            } else {
                l(klVar);
                AppMethodBeat.o(103879);
            }
            return false;
        }

        public final /* synthetic */ m b(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(103878);
            kl klVar = (kl) bVar;
            h hVar = new h(klVar.cGf.chatroomName, klVar.cGf.cGh, klVar.cGf.scene);
            AppMethodBeat.o(103878);
            return hVar;
        }

        public final int Jy() {
            return 179;
        }
    };
    private c<kq> egO = new c<kq>() {
        public final /* bridge */ /* synthetic */ com.tencent.mm.sdk.b.b a(int i, m mVar, com.tencent.mm.sdk.b.b bVar) {
            kq kqVar = (kq) bVar;
            kqVar.cGz.errCode = i;
            return kqVar;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(103881);
            kq kqVar = (kq) bVar;
            if (kqVar.cGy.cFT) {
                c.k(kqVar);
                AppMethodBeat.o(103881);
            } else {
                l(kqVar);
                AppMethodBeat.o(103881);
            }
            return false;
        }

        public final /* synthetic */ m b(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(103880);
            kq kqVar = (kq) bVar;
            n nVar = new n(kqVar.cGy.cGA, kqVar.cGy.chatroomName);
            AppMethodBeat.o(103880);
            return nVar;
        }

        public final int Jy() {
            return 700;
        }
    };
    private c<kk> egP = new c<kk>() {
        public final /* bridge */ /* synthetic */ com.tencent.mm.sdk.b.b a(int i, m mVar, com.tencent.mm.sdk.b.b bVar) {
            kk kkVar = (kk) bVar;
            g gVar = (g) mVar;
            kkVar.cFV.cFY = gVar.cFY;
            kkVar.cFV.cFZ = gVar.cFZ;
            kkVar.cFV.cGa = gVar.cGa;
            kkVar.cFV.cGb = gVar.ehk;
            kkVar.cFV.cGe = gVar.cGe;
            kkVar.cFV.cGc = gVar.cGc;
            kkVar.cFV.cGd = gVar.cGd;
            return kkVar;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(103883);
            kk kkVar = (kk) bVar;
            if (kkVar.cFU.cFT) {
                c.k(kkVar);
                AppMethodBeat.o(103883);
            } else {
                l(kkVar);
                AppMethodBeat.o(103883);
            }
            return false;
        }

        public final /* synthetic */ m b(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(103882);
            kk kkVar = (kk) bVar;
            g gVar = new g(kkVar.cFU.cFW, kkVar.cFU.cFX);
            AppMethodBeat.o(103882);
            return gVar;
        }

        public final int Jy() {
            return d.MIC_AVROUND_BLUR;
        }
    };
    private com.tencent.mm.sdk.b.c egQ = new com.tencent.mm.sdk.b.c<ss>() {
        {
            AppMethodBeat.i(103884);
            this.xxI = ss.class.getName().hashCode();
            AppMethodBeat.o(103884);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(103885);
            ss ssVar = (ss) bVar;
            if (ssVar.cOR.cOS.equals(kj.class.getName())) {
                if (ssVar.cOR.czE == 1) {
                    b.this.egL.dgW();
                } else {
                    b.this.egL.bIW();
                }
            } else if (ssVar.cOR.cOS.equals(km.class.getName())) {
                if (ssVar.cOR.czE == 1) {
                    b.this.egM.dgW();
                } else {
                    b.this.egM.bIW();
                }
            } else if (ssVar.cOR.cOS.equals(kk.class.getName())) {
                if (ssVar.cOR.czE == 1) {
                    b.this.egP.dgW();
                } else {
                    b.this.egP.bIW();
                }
            } else if (ssVar.cOR.cOS.equals(kl.class.getName())) {
                if (ssVar.cOR.czE == 1) {
                    b.this.egN.dgW();
                } else {
                    b.this.egN.bIW();
                }
            } else if (ssVar.cOR.cOS.equals(kq.class.getName())) {
                if (ssVar.cOR.czE == 1) {
                    b.this.egO.dgW();
                } else {
                    b.this.egO.bIW();
                }
            }
            AppMethodBeat.o(103885);
            return false;
        }
    };

    public b() {
        AppMethodBeat.i(103886);
        AppMethodBeat.o(103886);
    }

    private static b Jv() {
        AppMethodBeat.i(103887);
        b bVar = (b) q.Y(b.class);
        AppMethodBeat.o(103887);
        return bVar;
    }

    private static a Jw() {
        AppMethodBeat.i(103888);
        com.tencent.mm.kernel.g.RN().QU();
        Jv();
        if (egR == null) {
            Jv();
            egR = new a();
        }
        Jv();
        a aVar = egR;
        AppMethodBeat.o(103888);
        return aVar;
    }

    public final HashMap<Integer, com.tencent.mm.cd.h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(103889);
        com.tencent.mm.roomsdk.a.b.a("@chatroom", new a());
        com.tencent.mm.sdk.b.a.xxA.c(this.egQ);
        com.tencent.mm.sdk.b.a.xxA.c(this.egL);
        com.tencent.mm.sdk.b.a.xxA.c(this.egP);
        com.tencent.mm.sdk.b.a.xxA.c(this.egM);
        com.tencent.mm.sdk.b.a.xxA.c(this.egN);
        com.tencent.mm.sdk.b.a.xxA.c(this.egO);
        com.tencent.mm.plugin.messenger.a.e.b Jw = Jw();
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApplication", Jw.ehc, true);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApproval", Jw.ehc, true);
        ((e) com.tencent.mm.kernel.g.K(e.class)).a("link_admin_explain", Jw);
        AppMethodBeat.o(103889);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(103890);
        com.tencent.mm.sdk.b.a.xxA.d(this.egQ);
        com.tencent.mm.sdk.b.a.xxA.d(this.egL);
        com.tencent.mm.sdk.b.a.xxA.d(this.egP);
        com.tencent.mm.sdk.b.a.xxA.d(this.egM);
        com.tencent.mm.sdk.b.a.xxA.d(this.egN);
        com.tencent.mm.sdk.b.a.xxA.d(this.egO);
        a Jw = Jw();
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApplication", Jw.ehc, true);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApproval", Jw.ehc, true);
        ((e) com.tencent.mm.kernel.g.K(e.class)).QB("link_admin_explain");
        AppMethodBeat.o(103890);
    }
}
