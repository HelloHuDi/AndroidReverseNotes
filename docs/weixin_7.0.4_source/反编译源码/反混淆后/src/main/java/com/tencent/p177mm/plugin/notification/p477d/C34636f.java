package com.tencent.p177mm.plugin.notification.p477d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C26211ou;
import com.tencent.p177mm.p230g.p231a.C37700ck;
import com.tencent.p177mm.p230g.p231a.C37757lh;
import com.tencent.p177mm.p230g.p231a.C37779ot;
import com.tencent.p177mm.p230g.p231a.C45342li;
import com.tencent.p177mm.p230g.p231a.C9352gd;
import com.tencent.p177mm.p249m.C18559f;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.notification.p1005ui.FailSendMsgNotification;
import com.tencent.p177mm.plugin.notification.p475a.C46114a;
import com.tencent.p177mm.plugin.notification.p476c.C12729c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.notification.d.f */
public final class C34636f implements C1816at {
    private static C34636f oWl = null;
    C12729c oWm = null;
    C12729c oWn = null;
    private C46114a oWo = null;
    private boolean oWp = false;
    private C4884c oWq = new C346371();
    private C4884c oWr = new C346392();
    private C4884c oWs = new C346383();
    private C4884c oWt = new C346404();
    private C4884c oWu = new C214005();
    private C4884c oWv = new C286256();

    /* renamed from: com.tencent.mm.plugin.notification.d.f$5 */
    class C214005 extends C4884c<C37700ck> {
        C214005() {
            AppMethodBeat.m2504i(23181);
            this.xxI = C37700ck.class.getName().hashCode();
            AppMethodBeat.m2505o(23181);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(23182);
            C34636f.this.oWm.bWB().dismiss();
            C34636f.this.oWn.bWB().dismiss();
            C4990ab.m7416i("MicroMsg.SubCoreNotification", "dismiss all fail msg notification");
            AppMethodBeat.m2505o(23182);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.notification.d.f$6 */
    class C286256 extends C4884c<C9352gd> {
        C286256() {
            AppMethodBeat.m2504i(23183);
            this.xxI = C9352gd.class.getName().hashCode();
            AppMethodBeat.m2505o(23183);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(23184);
            C34636f.this.oWp = ((C9352gd) c4883b).cAs.csi;
            AppMethodBeat.m2505o(23184);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.notification.d.f$1 */
    class C346371 extends C4884c<C37779ot> {
        C346371() {
            AppMethodBeat.m2504i(23173);
            this.xxI = C37779ot.class.getName().hashCode();
            AppMethodBeat.m2505o(23173);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(23174);
            C34636f.this.oWm.bWu();
            AppMethodBeat.m2505o(23174);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.notification.d.f$3 */
    class C346383 extends C4884c<C37757lh> {
        C346383() {
            AppMethodBeat.m2504i(23177);
            this.xxI = C37757lh.class.getName().hashCode();
            AppMethodBeat.m2505o(23177);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(23178);
            C34636f.this.oWm.bWz();
            AppMethodBeat.m2505o(23178);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.notification.d.f$2 */
    class C346392 extends C4884c<C26211ou> {
        C346392() {
            AppMethodBeat.m2504i(23175);
            this.xxI = C26211ou.class.getName().hashCode();
            AppMethodBeat.m2505o(23175);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(23176);
            C34636f.this.oWn.bWu();
            AppMethodBeat.m2505o(23176);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.notification.d.f$4 */
    class C346404 extends C4884c<C45342li> {
        C346404() {
            AppMethodBeat.m2504i(23179);
            this.xxI = C45342li.class.getName().hashCode();
            AppMethodBeat.m2505o(23179);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(23180);
            C34636f.this.oWn.bWz();
            AppMethodBeat.m2505o(23180);
            return false;
        }
    }

    private C34636f() {
        AppMethodBeat.m2504i(23185);
        C12730b.init();
        if (this.oWn == null) {
            this.oWn = new C36795e();
        }
        if (this.oWm == null) {
            this.oWm = new C36794d();
        }
        AppMethodBeat.m2505o(23185);
    }

    /* renamed from: At */
    public static FailSendMsgNotification m56827At(int i) {
        AppMethodBeat.m2504i(23186);
        FailSendMsgNotification bWB;
        if (i == 2 && C34636f.bWP().oWn != null) {
            C4990ab.m7410d("MicroMsg.SubCoreNotification", "get sns notificaiton");
            bWB = C34636f.bWP().oWn.bWB();
            AppMethodBeat.m2505o(23186);
            return bWB;
        } else if (i != 1 || C34636f.bWP().oWm == null) {
            AppMethodBeat.m2505o(23186);
            return null;
        } else {
            C4990ab.m7410d("MicroMsg.SubCoreNotification", "get msg notificaiton");
            bWB = C34636f.bWP().oWm.bWB();
            AppMethodBeat.m2505o(23186);
            return bWB;
        }
    }

    public static C34636f bWP() {
        AppMethodBeat.m2504i(23187);
        if (oWl == null) {
            oWl = new C34636f();
            C9638aw.m17184ZE().mo73244a("plugin.notification", oWl);
        }
        C34636f c34636f = oWl;
        AppMethodBeat.m2505o(23187);
        return c34636f;
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
        AppMethodBeat.m2504i(23188);
        this.oWm.bWK();
        this.oWm.bWL();
        this.oWn.bWK();
        this.oWn.bWL();
        if (this.oWo == null) {
            this.oWo = new C46114a();
        }
        C46114a c46114a = this.oWo;
        if (C9638aw.m17179RK()) {
            C4990ab.m7410d("MicroMsg.NotificationObserver", "added");
            try {
                C9638aw.m17190ZK();
                C18628c.m29083XR().mo10121b(c46114a);
                C9638aw.m17190ZK();
                C18628c.m29083XR().mo10118a(c46114a);
                c46114a.oVn = true;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.NotificationObserver", "exception:%s", C5046bo.m7574l(e));
            }
        } else {
            C4990ab.m7412e("MicroMsg.NotificationObserver", "account not ready!");
        }
        C4879a.xxA.mo10052c(this.oWq);
        C4879a.xxA.mo10052c(this.oWr);
        C4879a.xxA.mo10052c(this.oWs);
        C4879a.xxA.mo10052c(this.oWt);
        C4879a.xxA.mo10052c(this.oWu);
        C4879a.xxA.mo10052c(this.oWv);
        C9638aw.getNotification().mo41580ik(C18559f.m28885Nr());
        C9638aw.getNotification().mo41576bw(false);
        C4990ab.m7410d("MicroMsg.SubCoreNotification", "onAccountPostReset");
        AppMethodBeat.m2505o(23188);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(23189);
        this.oWm.bWM();
        this.oWm.bWN();
        this.oWn.bWM();
        this.oWn.bWN();
        if (this.oWo != null) {
            C46114a c46114a = this.oWo;
            if (C9638aw.m17179RK()) {
                try {
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().mo10121b(c46114a);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.NotificationObserver", "exception:%s", C5046bo.m7574l(e));
                }
            }
        }
        C4879a.xxA.mo10053d(this.oWq);
        C4879a.xxA.mo10053d(this.oWr);
        C4879a.xxA.mo10053d(this.oWs);
        C4879a.xxA.mo10053d(this.oWt);
        C4879a.xxA.mo10053d(this.oWu);
        C4879a.xxA.mo10053d(this.oWv);
        C9638aw.getNotification().mo41580ik(0);
        C9638aw.getNotification().mo41576bw(true);
        C4990ab.m7410d("MicroMsg.SubCoreNotification", "onAccountRelease");
        AppMethodBeat.m2505o(23189);
    }

    public static boolean aJt() {
        AppMethodBeat.m2504i(23190);
        boolean z = C34636f.bWP().oWp;
        AppMethodBeat.m2505o(23190);
        return z;
    }

    /* renamed from: ae */
    public static ArrayList<Long> m56830ae(C7620bi c7620bi) {
        AppMethodBeat.m2504i(23191);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(23191);
            return null;
        }
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
        ArrayList bOC = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().bOC();
        ArrayList<Long> arrayList = new ArrayList();
        Iterator it = bOC.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((C7620bi) it.next()).field_msgId));
        }
        AppMethodBeat.m2505o(23191);
        return arrayList;
    }
}
