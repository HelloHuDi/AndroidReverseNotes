package com.tencent.p177mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C18523a;
import com.tencent.p177mm.kernel.api.bucket.C26346d;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.model.C1812ai;
import com.tencent.p177mm.model.C1813aj;
import com.tencent.p177mm.model.C42194e;
import com.tencent.p177mm.model.C6673bz;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.modelmulti.C45450m;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p201az.C25850i;
import com.tencent.p177mm.p201az.C37500n;
import com.tencent.p177mm.p201az.C9062a;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p217ci.C32467c;
import com.tencent.p177mm.plugin.chatroom.C38785a;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C12525c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C12526d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21279r.C21278a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21280t;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C28493i;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C28494k;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3468b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C39367q;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.zero.C44038c;
import com.tencent.p177mm.plugin.zero.PluginZero;
import com.tencent.p177mm.plugin.zero.p591a.C44035d;
import com.tencent.p177mm.plugin.zero.p591a.C46481f;
import com.tencent.p177mm.plugin.zero.tasks.C35782b;
import com.tencent.p177mm.protocal.protobuf.bbv;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C15433al;
import com.tencent.p177mm.storage.C23513cb;
import com.tencent.p177mm.storage.C35997bc;
import com.tencent.p177mm.storage.C35998bg;
import com.tencent.p177mm.storage.C40624aj;
import com.tencent.p177mm.storage.C46621ao;
import com.tencent.p177mm.storage.C46622bu;
import com.tencent.p177mm.storage.C7572bj;
import com.tencent.p177mm.storage.C7573br;
import com.tencent.p177mm.storage.C7579x;
import com.tencent.p177mm.storage.C7618aw;
import com.tencent.p177mm.storage.C7619ay;
import com.tencent.p177mm.storage.C7621bw;
import com.tencent.p177mm.vending.p636b.C7358b;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation */
public class PluginMessengerFoundation extends C7597f implements C18523a, C9562c, C26346d, C1813aj, C6983p {
    private C42194e flI = new C42194e();
    private C34534d oqr;
    private C12530e oqs;
    private C6673bz oqt = new C6673bz();
    private C38785a oqu = new C38785a();
    private C1813aj oqv;
    private C3468b rWZ;

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation$13 */
    class C1252113 implements C1366d {
        C1252113() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C40624aj.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation$14 */
    class C1252214 implements C1366d {
        C1252214() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C25850i.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation$16 */
    class C1252316 implements C1366d {
        C1252316() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C7573br.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation$1 */
    class C212741 implements C32467c<C46481f> {
        C212741() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(1046);
            C12531f c12531f = new C12531f();
            AppMethodBeat.m2505o(1046);
            return c12531f;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation$3 */
    class C212753 implements C1366d {
        C212753() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C35998bg.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation$8 */
    class C212768 implements C1366d {
        C212768() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C7579x.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation$9 */
    class C212779 implements C1366d {
        C212779() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C35997bc.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation$12 */
    class C2849012 implements C1366d {
        C2849012() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C7572bj.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation$15 */
    class C2849115 implements C1366d {
        C2849115() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C15433al.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation$2 */
    class C284922 implements C1366d {
        C284922() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C46621ao.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation$11 */
    class C3935911 implements C28493i {
        C3935911() {
        }

        /* renamed from: a */
        public final C1198b mo46464a(C1197a c1197a, C21280t c21280t) {
            AppMethodBeat.m2504i(1049);
            C1198b a = C39372c.m67145a(c1197a, c21280t);
            AppMethodBeat.m2505o(1049);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation$6 */
    class C393606 implements C1366d {
        C393606() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C7619ay.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation$4 */
    class C393614 implements C1366d {
        C393614() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C46622bu.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation$5 */
    class C393625 implements C1366d {
        C393625() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C23513cb.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation$10 */
    class C3936310 implements C12526d {
        C3936310() {
        }

        /* renamed from: a */
        public final void mo24449a(bbv bbv, String str) {
            AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_SHAKA_ADD2_12);
            C39368a.m67138a(bbv, str, null, true, false);
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_SHAKA_ADD2_12);
        }

        /* renamed from: a */
        public final C7358b mo24448a(C12525c c12525c) {
            AppMethodBeat.m2504i(1048);
            C7358b a = C39368a.m67137a(c12525c);
            AppMethodBeat.m2505o(1048);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation$17 */
    class C3936417 implements C1366d {
        C3936417() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C7621bw.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation$7 */
    class C393657 implements C1366d {
        C393657() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C7618aw.fnj;
        }
    }

    public PluginMessengerFoundation() {
        AppMethodBeat.m2504i(1050);
        AppMethodBeat.m2505o(1050);
    }

    public void installed() {
        AppMethodBeat.m2504i(1051);
        alias(C6983p.class);
        AppMethodBeat.m2505o(1051);
    }

    public void dependency() {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_SHAKA_ADD2_17);
        dependsOn(PluginZero.class);
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_SHAKA_ADD2_17);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_SHAKA_ADD2_18);
        C4990ab.m7417i("MicroMsg.TAG", "init thread pool[%s] current tid[%d] priority[%d] process[%s]", C7305d.xDG, Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(Thread.currentThread().getPriority()), ((C6624h) C1720g.m3533RM().mo5224Rn()).eHT);
        C44038c.vaf = new C212741();
        C39368a c39368a = new C39368a();
        C21278a.m32647a(2, c39368a);
        C21278a.m32647a(17, c39368a);
        C21278a.m32647a(4, c39368a);
        C21278a.m32647a(7, new C46072b());
        C39372c c39372c = new C39372c();
        C21278a.m32647a(5, c39372c);
        C21278a.m32647a(8, c39372c);
        C21278a.m32647a(9, c39372c);
        C21278a.m32647a(1, new C28496g());
        C1720g.m3532RL().mo5219a(C39367q.class, new C6625e(new C45450m()));
        C1720g.m3530M(C44035d.class);
        if (c1681g.mo5181SG()) {
            new C35782b().before(this);
            C1720g.m3542a(C12526d.class, new C3936310());
            C1720g.m3542a(C28493i.class, new C3935911());
            C1720g.m3542a(C6822c.class, this.oqu);
        }
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_SHAKA_ADD2_18);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(1054);
        if (c1681g.mo5181SG()) {
            this.oqr = new C34534d();
            C1720g.m3543a(C6982j.class, new C6625e(this.oqr));
            this.oqs = new C12530e();
            C1720g.m3543a(C28494k.class, new C6625e(this.oqs));
        }
        AppMethodBeat.m2505o(1054);
    }

    public String toString() {
        return "plugin-messenger-foundation";
    }

    public HashMap<Integer, C1366d> collectDatabaseFactory() {
        AppMethodBeat.m2504i(1055);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("MESSAGE_TABLE".hashCode()), new C2849012());
        hashMap.put(Integer.valueOf("CONTACT_TABLE".hashCode()), new C1252113());
        hashMap.put(Integer.valueOf("OPLOG_TABLE".hashCode()), new C1252214());
        hashMap.put(Integer.valueOf("CONVERSATION_TABLE".hashCode()), new C2849115());
        hashMap.put(Integer.valueOf("ROLEINFO_TABLE".hashCode()), new C1252316());
        hashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new C3936417());
        hashMap.put(Integer.valueOf("DeletedConversationInfo".hashCode()), new C284922());
        hashMap.put(Integer.valueOf("LBSVERIFYMESSAGE_TABLE".hashCode()), new C212753());
        hashMap.put(Integer.valueOf("SHAKEVERIFYMESSAGE_TABLE".hashCode()), new C393614());
        hashMap.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new C393625());
        hashMap.put(Integer.valueOf("FMESSAGE_MSGINFO_TABLE".hashCode()), new C393606());
        hashMap.put(Integer.valueOf("FMESSAGE_CONVERSATION_TABLE".hashCode()), new C393657());
        hashMap.put(Integer.valueOf("CHATROOM_MSGSEQ_TABLE".hashCode()), new C212768());
        hashMap.put(Integer.valueOf("GetSysCmdMsgInfo".hashCode()), new C212779());
        AppMethodBeat.m2505o(1055);
        return hashMap;
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(1056);
        C1200d.m2636a(Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK), this.flI);
        C1200d.m2636a(Integer.valueOf(1), this.flI);
        C1200d.m2636a(Integer.valueOf(10001), this.oqt);
        C1200d.m2636a(Integer.valueOf(10002), this.oqt);
        AppMethodBeat.m2505o(1056);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_SHAKA_ADD2_22);
        C1200d.m2637b(Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK), this.flI);
        C1200d.m2637b(Integer.valueOf(1), this.flI);
        C1200d.m2637b(Integer.valueOf(10001), this.oqt);
        C1200d.m2637b(Integer.valueOf(10002), this.oqt);
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_SHAKA_ADD2_22);
    }

    public void onDataBaseOpened(C7480h c7480h, C7480h c7480h2) {
        AppMethodBeat.m2504i(1058);
        C7485q.m12926Yx();
        C34534d c34534d = this.oqr;
        C7480h c7480h3 = C1720g.m3536RP().eJN;
        C1720g.m3536RP();
        c34534d.oqf = new C37500n(new C25850i(c7480h3));
        c34534d.oqg = new C9062a();
        c34534d.oqb = new C40624aj(c7480h3);
        c34534d.oqc = new C7621bw(c7480h3);
        c34534d.oqe = new C15433al(c7480h3);
        c34534d.oqd = new C7572bj(c7480h3, c34534d.oqb, c34534d.oqe);
        c34534d.oqh = new C7573br(c7480h3);
        c34534d.oqi = new C46621ao(c7480h3);
        c34534d.oqj = new C7619ay(c7480h3);
        c34534d.oqk = new C7618aw(c7480h3);
        c34534d.oql = new C35998bg(c7480h3);
        c34534d.oqm = new C46622bu(c7480h3);
        c34534d.oqn = new C23513cb(c7480h3);
        c34534d.oqo = new C7579x(c7480h3);
        c34534d.oqp = new C35997bc(c7480h3);
        AppMethodBeat.m2505o(1058);
    }

    public void onDataBaseClosed(C7480h c7480h, C7480h c7480h2) {
    }

    public C6673bz getSysCmdMsgExtension() {
        return this.oqt;
    }

    public void setIDataTransferFactoryDelegate(C1813aj c1813aj) {
        this.oqv = c1813aj;
    }

    public List<C1812ai> getDataTransferList() {
        AppMethodBeat.m2504i(1059);
        if (this.oqv != null) {
            List dataTransferList = this.oqv.getDataTransferList();
            if (dataTransferList.size() > 8) {
                Assert.assertTrue("Do not add more IDataTransfer from mIDataTransferFactoryDelegate!!!!!!!!!!!", false);
            }
            AppMethodBeat.m2505o(1059);
            return dataTransferList;
        }
        List<C1812ai> arrayList = new ArrayList();
        AppMethodBeat.m2505o(1059);
        return arrayList;
    }

    public void setBizTimeLineCallback(C3468b c3468b) {
        this.rWZ = c3468b;
    }

    public C3468b getBizTimeLineCallback() {
        return this.rWZ;
    }
}
