package com.tencent.p177mm.plugin.account;

import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C18226aw;
import com.tencent.p177mm.p230g.p231a.C42002hl;
import com.tencent.p177mm.p230g.p231a.C42041qh;
import com.tencent.p177mm.p230g.p231a.C6491hw;
import com.tencent.p177mm.p647w.C30851b;
import com.tencent.p177mm.p647w.C40925a;
import com.tencent.p177mm.p647w.p648a.C5743a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18818b;
import com.tencent.p177mm.plugin.account.friend.p272a.C18819c;
import com.tencent.p177mm.plugin.account.friend.p272a.C18820h;
import com.tencent.p177mm.plugin.account.friend.p272a.C26585an;
import com.tencent.p177mm.plugin.account.friend.p272a.C26586k;
import com.tencent.p177mm.plugin.account.friend.p272a.C32956ab;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38036o;
import com.tencent.p177mm.plugin.account.friend.p272a.C42281e;
import com.tencent.p177mm.plugin.account.friend.p272a.C42282f;
import com.tencent.p177mm.plugin.account.friend.p272a.C44692d;
import com.tencent.p177mm.plugin.account.friend.p272a.C45496ap;
import com.tencent.p177mm.plugin.account.friend.p272a.C9878ao;
import com.tencent.p177mm.plugin.account.friend.p272a.C9880q;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.protocal.protobuf.akp;
import com.tencent.p177mm.protocal.protobuf.aym;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.account.a */
public class C32923a implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C18818b gpP;
    private C18820h gpQ;
    private C26586k gpR;
    private C26585an gpS;
    private C45496ap gpT;
    private C9880q gpU;
    private C38036o gpV;
    private C44692d gpW = new C44692d();
    private LinkedList<aym> gpX = null;
    private C18819c gpY = new C18819c();
    private C42281e gpZ = new C42281e();
    private C42282f gqa = new C42282f();
    private C4884c gqb = new C265461();
    private C4884c gqc = new C329305();
    private C4884c gqd = new C329266();
    private C4884c gqe = new C329203();

    /* renamed from: com.tencent.mm.plugin.account.a$2 */
    static class C98262 implements C1366d {
        C98262() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C38036o.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.a$4 */
    class C187944 extends C28106a {
        C187944() {
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(124625);
            C40925a c40925a = new C40925a();
            ((C12029n) C1720g.m3530M(C12029n.class)).registerIndexStorage(c40925a);
            c40925a.create();
            C30851b c30851b = new C30851b();
            ((C12029n) C1720g.m3530M(C12029n.class)).registerNativeLogic(9, c30851b);
            c30851b.create();
            ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C5743a());
            AppMethodBeat.m2505o(124625);
            return true;
        }

        public final String getName() {
            return "InitFTSFriendPluginTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.a$9 */
    static class C187959 implements C1366d {
        C187959() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C26586k.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.a$1 */
    class C265461 extends C4884c<C18226aw> {
        C265461() {
            AppMethodBeat.m2504i(124621);
            this.xxI = C18226aw.class.getName().hashCode();
            AppMethodBeat.m2505o(124621);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(124622);
            C18226aw c18226aw = (C18226aw) c4883b;
            if (c18226aw instanceof C18226aw) {
                c18226aw.ctZ.csN = C38033l.apV();
            }
            AppMethodBeat.m2505o(124622);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.a$3 */
    class C329203 extends C4884c<C42041qh> {
        C329203() {
            AppMethodBeat.m2504i(124623);
            this.xxI = C42041qh.class.getName().hashCode();
            AppMethodBeat.m2505o(124623);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(124624);
            C42041qh c42041qh = (C42041qh) c4883b;
            Intent intent = c42041qh.cMw.intent;
            String str = c42041qh.cMw.username;
            if (intent == null || str == null || str.length() == 0) {
                C4990ab.m7412e("MicroMsg.AccountSyncUtil", "setLocalQQMobile fail, intent = " + intent + ", username = " + str);
            } else {
                C9878ao wj = ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73286wj(str);
                if (wj != null) {
                    intent.putExtra("Contact_Uin", wj.gwC);
                    intent.putExtra("Contact_QQNick", wj.getDisplayName());
                }
                C18817a vT = ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34089vT(str);
                if (vT != null) {
                    intent.putExtra("Contact_Mobile_MD5", vT.mo34067Aq());
                }
            }
            AppMethodBeat.m2505o(124624);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.a$12 */
    static class C3292412 implements C1366d {
        C3292412() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C9880q.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.a$10 */
    static class C3292510 implements C1366d {
        C3292510() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C26585an.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.a$6 */
    class C329266 extends C4884c<C42002hl> {
        C329266() {
            AppMethodBeat.m2504i(124628);
            this.xxI = C42002hl.class.getName().hashCode();
            AppMethodBeat.m2505o(124628);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(124629);
            C42002hl c42002hl = (C42002hl) c4883b;
            if (c42002hl instanceof C42002hl) {
                String str = c42002hl.cCl.cCn;
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.SubCoreFriend", "hy: mobile number is null");
                } else {
                    Cursor a = C32923a.getAddrUploadStg().fni.mo10104a("select addr_upload2.username from addr_upload2 where addr_upload2.moblie = ".concat(String.valueOf(str)), null, 2);
                    LinkedList linkedList = new LinkedList();
                    while (a.moveToNext()) {
                        linkedList.add(a.getString(0));
                    }
                    a.close();
                    C4990ab.m7417i("MicroMsg.SubCoreFriend", "hy: username: %s", linkedList.size() == 0 ? "" : (String) linkedList.get(0));
                    c42002hl.cCm.userName = str;
                }
            }
            AppMethodBeat.m2505o(124629);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.a$7 */
    static class C329277 implements C1366d {
        C329277() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C18818b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.a$8 */
    static class C329288 implements C1366d {
        C329288() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C18820h.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.a$11 */
    static class C3292911 implements C1366d {
        C3292911() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C45496ap.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.a$5 */
    class C329305 extends C4884c<C6491hw> {
        C329305() {
            AppMethodBeat.m2504i(124626);
            this.xxI = C6491hw.class.getName().hashCode();
            AppMethodBeat.m2505o(124626);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(124627);
            C6491hw c6491hw = (C6491hw) c4883b;
            if (c6491hw instanceof C6491hw) {
                int i = c6491hw.cCP.scene;
                C1207m c32956ab = new C32956ab();
                ((akp) c32956ab.ehh.fsG.fsP).Scene = i;
                C1720g.m3540Rg().mo14541a(c32956ab, 0);
            }
            AppMethodBeat.m2505o(124627);
            return false;
        }
    }

    public C32923a() {
        AppMethodBeat.m2504i(124630);
        AppMethodBeat.m2505o(124630);
    }

    private static synchronized C32923a aoO() {
        C32923a c32923a;
        synchronized (C32923a.class) {
            AppMethodBeat.m2504i(124631);
            c32923a = (C32923a) C7485q.m12925Y(C32923a.class);
            AppMethodBeat.m2505o(124631);
        }
        return c32923a;
    }

    public static C18818b getAddrUploadStg() {
        AppMethodBeat.m2504i(124632);
        C1720g.m3534RN().mo5159QU();
        if (C32923a.aoO().gpP == null) {
            C32923a.aoO().gpP = new C18818b(C1720g.m3536RP().eJN);
        }
        C18818b c18818b = C32923a.aoO().gpP;
        AppMethodBeat.m2505o(124632);
        return c18818b;
    }

    public static C18820h getFacebookFrdStg() {
        AppMethodBeat.m2504i(124633);
        C1720g.m3534RN().mo5159QU();
        if (C32923a.aoO().gpQ == null) {
            C32923a.aoO().gpQ = new C18820h(C1720g.m3536RP().eJN);
        }
        C18820h c18820h = C32923a.aoO().gpQ;
        AppMethodBeat.m2505o(124633);
        return c18820h;
    }

    public static C26586k getFrdExtStg() {
        AppMethodBeat.m2504i(124634);
        C1720g.m3534RN().mo5159QU();
        if (C32923a.aoO().gpR == null) {
            C32923a.aoO().gpR = new C26586k(C1720g.m3536RP().eJN);
        }
        C26586k c26586k = C32923a.aoO().gpR;
        AppMethodBeat.m2505o(124634);
        return c26586k;
    }

    public static C26585an getQQGroupStg() {
        AppMethodBeat.m2504i(124635);
        C1720g.m3534RN().mo5159QU();
        if (C32923a.aoO().gpS == null) {
            C32923a.aoO().gpS = new C26585an(C1720g.m3536RP().eJN);
        }
        C26585an c26585an = C32923a.aoO().gpS;
        AppMethodBeat.m2505o(124635);
        return c26585an;
    }

    public static C9880q getInviteFriendOpenStg() {
        AppMethodBeat.m2504i(124636);
        C1720g.m3534RN().mo5159QU();
        if (C32923a.aoO().gpU == null) {
            C32923a.aoO().gpU = new C9880q(C1720g.m3536RP().eJN);
        }
        C9880q c9880q = C32923a.aoO().gpU;
        AppMethodBeat.m2505o(124636);
        return c9880q;
    }

    public static C45496ap getQQListStg() {
        AppMethodBeat.m2504i(124637);
        C1720g.m3534RN().mo5159QU();
        if (C32923a.aoO().gpT == null) {
            C32923a.aoO().gpT = new C45496ap(C1720g.m3536RP().eJN);
        }
        C45496ap c45496ap = C32923a.aoO().gpT;
        AppMethodBeat.m2505o(124637);
        return c45496ap;
    }

    public static void setFriendData(LinkedList<aym> linkedList) {
        AppMethodBeat.m2504i(124638);
        C1720g.m3534RN().mo5159QU();
        C32923a.aoO().gpX = linkedList;
        AppMethodBeat.m2505o(124638);
    }

    public static LinkedList<aym> getFriendData() {
        AppMethodBeat.m2504i(124639);
        C1720g.m3534RN().mo5159QU();
        LinkedList linkedList = C32923a.aoO().gpX;
        AppMethodBeat.m2505o(124639);
        return linkedList;
    }

    public static void clearFriendData() {
        AppMethodBeat.m2504i(124640);
        C1720g.m3534RN().mo5159QU();
        C32923a.aoO().gpX = null;
        AppMethodBeat.m2505o(124640);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(124641);
        C4879a.xxA.mo10053d(this.gqe);
        C4879a.xxA.mo10053d(this.gqd);
        C4879a.xxA.mo10053d(this.gpY);
        C4879a.xxA.mo10053d(this.gpZ);
        C4879a.xxA.mo10053d(this.gqa);
        C4879a.xxA.mo10053d(this.gqb);
        C4879a.xxA.mo10053d(this.gqc);
        C1200d.m2637b(Integer.valueOf(42), this.gpW);
        C1200d.m2637b(Integer.valueOf(66), this.gpW);
        this.gpX = null;
        AppMethodBeat.m2505o(124641);
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    static {
        AppMethodBeat.m2504i(124644);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("ADDR_UPLOAD_TABLE".hashCode()), new C329277());
        eaA.put(Integer.valueOf("FACE_BOOK_FIREND_TABLE".hashCode()), new C329288());
        eaA.put(Integer.valueOf("FRIEND_EXT_TABLE".hashCode()), new C187959());
        eaA.put(Integer.valueOf("QQ_GROUP_TABLE".hashCode()), new C3292510());
        eaA.put(Integer.valueOf("QQ_LIST_TABLE".hashCode()), new C3292911());
        eaA.put(Integer.valueOf("INVITEFRIENDOPEN_TABLE".hashCode()), new C3292412());
        eaA.put(Integer.valueOf("GOOGLE_FRIEND_TABLE".hashCode()), new C98262());
        AppMethodBeat.m2505o(124644);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(124642);
        C1200d.m2636a(Integer.valueOf(42), this.gpW);
        C1200d.m2636a(Integer.valueOf(66), this.gpW);
        C4879a.xxA.mo10052c(this.gqe);
        C4879a.xxA.mo10052c(this.gqd);
        C4879a.xxA.mo10052c(this.gpY);
        C4879a.xxA.mo10052c(this.gpZ);
        C4879a.xxA.mo10052c(this.gqa);
        C4879a.xxA.mo10052c(this.gqb);
        C4879a.xxA.mo10052c(this.gqc);
        ((C12029n) C1720g.m3530M(C12029n.class)).getFTSTaskDaemon().mo23853a(-86016, new C187944());
        AppMethodBeat.m2505o(124642);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public static C38036o getGoogleFriendStorage() {
        AppMethodBeat.m2504i(124643);
        C1720g.m3534RN().mo5159QU();
        if (C32923a.aoO().gpV == null) {
            C32923a.aoO().gpV = new C38036o(C1720g.m3536RP().eJN);
        }
        C38036o c38036o = C32923a.aoO().gpV;
        AppMethodBeat.m2505o(124643);
        return c38036o;
    }
}
