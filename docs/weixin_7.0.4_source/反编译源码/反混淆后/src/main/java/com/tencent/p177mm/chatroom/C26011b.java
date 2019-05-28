package com.tencent.p177mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.chatroom.p1595b.C45283a;
import com.tencent.p177mm.chatroom.p710c.C32438g;
import com.tencent.p177mm.chatroom.p710c.C32440n;
import com.tencent.p177mm.chatroom.p710c.C37638f;
import com.tencent.p177mm.chatroom.p710c.C6399h;
import com.tencent.p177mm.chatroom.p710c.C6402k;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C26242ss;
import com.tencent.p177mm.p230g.p231a.C32583kk;
import com.tencent.p177mm.p230g.p231a.C32586kl;
import com.tencent.p177mm.p230g.p231a.C45339km;
import com.tencent.p177mm.p230g.p231a.C6505kj;
import com.tencent.p177mm.p230g.p231a.C6507kq;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e.C12517b;
import com.tencent.p177mm.pluginsdk.p1077c.C40419c;
import com.tencent.p177mm.roomsdk.p1086a.C30262b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.view.C31128d;
import java.util.HashMap;

/* renamed from: com.tencent.mm.chatroom.b */
public class C26011b implements C1816at {
    private static C45283a egR;
    private C40419c<C6505kj> egL = new C260121();
    private C40419c<C45339km> egM = new C260092();
    private C40419c<C32586kl> egN = new C181333();
    private C40419c<C6507kq> egO = new C260104();
    private C40419c<C32583kk> egP = new C181345();
    private C4884c egQ = new C260136();

    /* renamed from: com.tencent.mm.chatroom.b$3 */
    class C181333 extends C40419c<C32586kl> {
        C181333() {
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ C4883b mo24700a(int i, C1207m c1207m, C4883b c4883b) {
            C32586kl c32586kl = (C32586kl) c4883b;
            c32586kl.cGg.errCode = i;
            return c32586kl;
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(103879);
            C32586kl c32586kl = (C32586kl) c4883b;
            if (c32586kl.cGf.cFT) {
                C40419c.m69325k(c32586kl);
                AppMethodBeat.m2505o(103879);
            } else {
                mo63831l(c32586kl);
                AppMethodBeat.m2505o(103879);
            }
            return false;
        }

        /* renamed from: b */
        public final /* synthetic */ C1207m mo24701b(C4883b c4883b) {
            AppMethodBeat.m2504i(103878);
            C32586kl c32586kl = (C32586kl) c4883b;
            C6399h c6399h = new C6399h(c32586kl.cGf.chatroomName, c32586kl.cGf.cGh, c32586kl.cGf.scene);
            AppMethodBeat.m2505o(103878);
            return c6399h;
        }

        /* renamed from: Jy */
        public final int mo24699Jy() {
            return 179;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.b$5 */
    class C181345 extends C40419c<C32583kk> {
        C181345() {
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ C4883b mo24700a(int i, C1207m c1207m, C4883b c4883b) {
            C32583kk c32583kk = (C32583kk) c4883b;
            C32438g c32438g = (C32438g) c1207m;
            c32583kk.cFV.cFY = c32438g.cFY;
            c32583kk.cFV.cFZ = c32438g.cFZ;
            c32583kk.cFV.cGa = c32438g.cGa;
            c32583kk.cFV.cGb = c32438g.ehk;
            c32583kk.cFV.cGe = c32438g.cGe;
            c32583kk.cFV.cGc = c32438g.cGc;
            c32583kk.cFV.cGd = c32438g.cGd;
            return c32583kk;
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(103883);
            C32583kk c32583kk = (C32583kk) c4883b;
            if (c32583kk.cFU.cFT) {
                C40419c.m69325k(c32583kk);
                AppMethodBeat.m2505o(103883);
            } else {
                mo63831l(c32583kk);
                AppMethodBeat.m2505o(103883);
            }
            return false;
        }

        /* renamed from: b */
        public final /* synthetic */ C1207m mo24701b(C4883b c4883b) {
            AppMethodBeat.m2504i(103882);
            C32583kk c32583kk = (C32583kk) c4883b;
            C32438g c32438g = new C32438g(c32583kk.cFU.cFW, c32583kk.cFU.cFX);
            AppMethodBeat.m2505o(103882);
            return c32438g;
        }

        /* renamed from: Jy */
        public final int mo24699Jy() {
            return C31128d.MIC_AVROUND_BLUR;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.b$2 */
    class C260092 extends C40419c<C45339km> {
        C260092() {
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ C4883b mo24700a(int i, C1207m c1207m, C4883b c4883b) {
            return (C45339km) c4883b;
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(103877);
            C45339km c45339km = (C45339km) c4883b;
            if (c45339km.cGi.cFT) {
                C40419c.m69325k(c45339km);
                AppMethodBeat.m2505o(103877);
            } else {
                mo63831l(c45339km);
                AppMethodBeat.m2505o(103877);
            }
            return false;
        }

        /* renamed from: b */
        public final /* synthetic */ C1207m mo24701b(C4883b c4883b) {
            AppMethodBeat.m2504i(103876);
            C45339km c45339km = (C45339km) c4883b;
            C6402k c6402k = new C6402k(c45339km.cGi.chatroomName, c45339km.cGi.cGj);
            AppMethodBeat.m2505o(103876);
            return c6402k;
        }

        /* renamed from: Jy */
        public final int mo24699Jy() {
            return 551;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.b$4 */
    class C260104 extends C40419c<C6507kq> {
        C260104() {
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ C4883b mo24700a(int i, C1207m c1207m, C4883b c4883b) {
            C6507kq c6507kq = (C6507kq) c4883b;
            c6507kq.cGz.errCode = i;
            return c6507kq;
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(103881);
            C6507kq c6507kq = (C6507kq) c4883b;
            if (c6507kq.cGy.cFT) {
                C40419c.m69325k(c6507kq);
                AppMethodBeat.m2505o(103881);
            } else {
                mo63831l(c6507kq);
                AppMethodBeat.m2505o(103881);
            }
            return false;
        }

        /* renamed from: b */
        public final /* synthetic */ C1207m mo24701b(C4883b c4883b) {
            AppMethodBeat.m2504i(103880);
            C6507kq c6507kq = (C6507kq) c4883b;
            C32440n c32440n = new C32440n(c6507kq.cGy.cGA, c6507kq.cGy.chatroomName);
            AppMethodBeat.m2505o(103880);
            return c32440n;
        }

        /* renamed from: Jy */
        public final int mo24699Jy() {
            return 700;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.b$1 */
    class C260121 extends C40419c<C6505kj> {
        C260121() {
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ C4883b mo24700a(int i, C1207m c1207m, C4883b c4883b) {
            return (C6505kj) c4883b;
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(103875);
            C6505kj c6505kj = (C6505kj) c4883b;
            if (c6505kj.cFR.cFT) {
                C40419c.m69325k(c6505kj);
                AppMethodBeat.m2505o(103875);
            } else {
                mo63831l(c6505kj);
                AppMethodBeat.m2505o(103875);
            }
            return false;
        }

        /* renamed from: b */
        public final /* synthetic */ C1207m mo24701b(C4883b c4883b) {
            AppMethodBeat.m2504i(103874);
            C37638f c37638f = new C37638f(((C6505kj) c4883b).cFR.cFS);
            AppMethodBeat.m2505o(103874);
            return c37638f;
        }

        /* renamed from: Jy */
        public final int mo24699Jy() {
            return 181;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.b$6 */
    class C260136 extends C4884c<C26242ss> {
        C260136() {
            AppMethodBeat.m2504i(103884);
            this.xxI = C26242ss.class.getName().hashCode();
            AppMethodBeat.m2505o(103884);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(103885);
            C26242ss c26242ss = (C26242ss) c4883b;
            if (c26242ss.cOR.cOS.equals(C6505kj.class.getName())) {
                if (c26242ss.cOR.czE == 1) {
                    C26011b.this.egL.dgW();
                } else {
                    C26011b.this.egL.bIW();
                }
            } else if (c26242ss.cOR.cOS.equals(C45339km.class.getName())) {
                if (c26242ss.cOR.czE == 1) {
                    C26011b.this.egM.dgW();
                } else {
                    C26011b.this.egM.bIW();
                }
            } else if (c26242ss.cOR.cOS.equals(C32583kk.class.getName())) {
                if (c26242ss.cOR.czE == 1) {
                    C26011b.this.egP.dgW();
                } else {
                    C26011b.this.egP.bIW();
                }
            } else if (c26242ss.cOR.cOS.equals(C32586kl.class.getName())) {
                if (c26242ss.cOR.czE == 1) {
                    C26011b.this.egN.dgW();
                } else {
                    C26011b.this.egN.bIW();
                }
            } else if (c26242ss.cOR.cOS.equals(C6507kq.class.getName())) {
                if (c26242ss.cOR.czE == 1) {
                    C26011b.this.egO.dgW();
                } else {
                    C26011b.this.egO.bIW();
                }
            }
            AppMethodBeat.m2505o(103885);
            return false;
        }
    }

    public C26011b() {
        AppMethodBeat.m2504i(103886);
        AppMethodBeat.m2505o(103886);
    }

    /* renamed from: Jv */
    private static C26011b m41517Jv() {
        AppMethodBeat.m2504i(103887);
        C26011b c26011b = (C26011b) C7485q.m12925Y(C26011b.class);
        AppMethodBeat.m2505o(103887);
        return c26011b;
    }

    /* renamed from: Jw */
    private static C45283a m41518Jw() {
        AppMethodBeat.m2504i(103888);
        C1720g.m3534RN().mo5159QU();
        C26011b.m41517Jv();
        if (egR == null) {
            C26011b.m41517Jv();
            egR = new C45283a();
        }
        C26011b.m41517Jv();
        C45283a c45283a = egR;
        AppMethodBeat.m2505o(103888);
        return c45283a;
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
        AppMethodBeat.m2504i(103889);
        C30262b.m48141a("@chatroom", new C9214a());
        C4879a.xxA.mo10052c(this.egQ);
        C4879a.xxA.mo10052c(this.egL);
        C4879a.xxA.mo10052c(this.egP);
        C4879a.xxA.mo10052c(this.egM);
        C4879a.xxA.mo10052c(this.egN);
        C4879a.xxA.mo10052c(this.egO);
        C12517b Jw = C26011b.m41518Jw();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("NewXmlChatRoomAccessVerifyApplication", Jw.ehc, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("NewXmlChatRoomAccessVerifyApproval", Jw.ehc, true);
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24439a("link_admin_explain", Jw);
        AppMethodBeat.m2505o(103889);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(103890);
        C4879a.xxA.mo10053d(this.egQ);
        C4879a.xxA.mo10053d(this.egL);
        C4879a.xxA.mo10053d(this.egP);
        C4879a.xxA.mo10053d(this.egM);
        C4879a.xxA.mo10053d(this.egN);
        C4879a.xxA.mo10053d(this.egO);
        C45283a Jw = C26011b.m41518Jw();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("NewXmlChatRoomAccessVerifyApplication", Jw.ehc, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("NewXmlChatRoomAccessVerifyApproval", Jw.ehc, true);
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24434QB("link_admin_explain");
        AppMethodBeat.m2505o(103890);
    }
}
