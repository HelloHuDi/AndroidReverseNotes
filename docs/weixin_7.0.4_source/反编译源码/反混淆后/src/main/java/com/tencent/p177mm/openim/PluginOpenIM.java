package com.tencent.p177mm.openim;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1669a;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C1811ah;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.p1210a.C37974a;
import com.tencent.p177mm.openim.p716b.C26515t;
import com.tencent.p177mm.openim.p716b.C32879j;
import com.tencent.p177mm.openim.p716b.C45466r;
import com.tencent.p177mm.openim.p876d.C45468p;
import com.tencent.p177mm.openim.p877e.C18741f;
import com.tencent.p177mm.openim.p877e.C42247d;
import com.tencent.p177mm.openim.p877e.C45469b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C32597lx;
import com.tencent.p177mm.p230g.p231a.C32598ly;
import com.tencent.p177mm.p230g.p231a.C6492hx;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C38317l;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.openim.PluginOpenIM */
public class PluginOpenIM extends C7597f implements C1669a, C9562c {
    public static HashMap<Integer, C1366d> eaA;
    private C1202f fur = new C265103();
    private C4884c geL = new C265131();
    private C4884c geM = new C187332();
    private C42247d geN;
    private C45469b geO;
    private C18741f geP;

    /* renamed from: com.tencent.mm.openim.PluginOpenIM$4 */
    static class C97664 implements C1366d {
        C97664() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C45469b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.openim.PluginOpenIM$2 */
    class C187332 extends C4884c<C6492hx> {
        C187332() {
            AppMethodBeat.m2504i(78822);
            this.xxI = C6492hx.class.getName().hashCode();
            AppMethodBeat.m2505o(78822);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(78823);
            String str = ((C6492hx) c4883b).cCQ.userName;
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(new C32879j(str), 0);
            AppMethodBeat.m2505o(78823);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.openim.PluginOpenIM$3 */
    class C265103 implements C1202f {
        C265103() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(78824);
            if (c1207m instanceof C32879j) {
                C32879j c32879j = (C32879j) c1207m;
                C32598ly c32598ly = new C32598ly();
                c32598ly.cHM.cHN = c32879j.cHN;
                C4879a.xxA.mo10055m(c32598ly);
            }
            AppMethodBeat.m2505o(78824);
        }
    }

    /* renamed from: com.tencent.mm.openim.PluginOpenIM$5 */
    static class C265115 implements C1366d {
        C265115() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C42247d.fnj;
        }
    }

    /* renamed from: com.tencent.mm.openim.PluginOpenIM$6 */
    static class C265126 implements C1366d {
        C265126() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C18741f.fnj;
        }
    }

    /* renamed from: com.tencent.mm.openim.PluginOpenIM$1 */
    class C265131 extends C4884c<C32597lx> {
        C265131() {
            AppMethodBeat.m2504i(78820);
            this.xxI = C32597lx.class.getName().hashCode();
            AppMethodBeat.m2505o(78820);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(78821);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(new C45466r(), 0);
            AppMethodBeat.m2505o(78821);
            return true;
        }
    }

    public PluginOpenIM() {
        AppMethodBeat.m2504i(78825);
        AppMethodBeat.m2505o(78825);
    }

    public C42247d getAppIdInfoStg() {
        AppMethodBeat.m2504i(78826);
        C1720g.m3534RN().mo5159QU();
        if (this.geO == null) {
            C1720g.m3537RQ();
            this.geN = new C42247d(C1720g.m3536RP().eJN);
        }
        C42247d c42247d = this.geN;
        AppMethodBeat.m2505o(78826);
        return c42247d;
    }

    public C45469b getAccTypeInfoStg() {
        AppMethodBeat.m2504i(78827);
        C1720g.m3534RN().mo5159QU();
        if (this.geO == null) {
            C1720g.m3537RQ();
            this.geO = new C45469b(C1720g.m3536RP().eJN);
        }
        C45469b c45469b = this.geO;
        AppMethodBeat.m2505o(78827);
        return c45469b;
    }

    public C18741f getWordingInfoStg() {
        AppMethodBeat.m2504i(78828);
        C1720g.m3534RN().mo5159QU();
        if (this.geP == null) {
            C1720g.m3537RQ();
            this.geP = new C18741f(C1720g.m3536RP().eJN);
        }
        C18741f c18741f = this.geP;
        AppMethodBeat.m2505o(78828);
        return c18741f;
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(78829);
        C4990ab.m7416i("MicroMsg.PluginOpenIM", "onAccountInitialized");
        C4879a.xxA.mo10051b(this.geL);
        this.geM.dnU();
        C1720g.m3537RQ();
        C1720g.m3542a(C32873b.class, new C26515t());
        C1720g.m3537RQ();
        C1720g.m3542a(C37974a.class, new C45468p());
        C1855t.m3880a((C1811ah) C1720g.m3528K(C37974a.class));
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a((int) C38317l.CTRL_INDEX, (C1202f) C1720g.m3528K(C32873b.class));
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(913, this.fur);
        AppMethodBeat.m2505o(78829);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(78830);
        C4990ab.m7416i("MicroMsg.PluginOpenIM", "onAccountRelease");
        C4879a.xxA.mo10053d(this.geL);
        this.geM.dead();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b((int) C38317l.CTRL_INDEX, (C1202f) C1720g.m3528K(C32873b.class));
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(913, this.fur);
        AppMethodBeat.m2505o(78830);
    }

    public void execute(C1681g c1681g) {
    }

    public void configure(C1681g c1681g) {
    }

    static {
        AppMethodBeat.m2504i(78831);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("OpenIMAccTypeInfo_TABLE".hashCode()), new C97664());
        eaA.put(Integer.valueOf("OpenIMAppIdInfo_TABLE".hashCode()), new C265115());
        eaA.put(Integer.valueOf("OpenIMWordingInfo_TABLE".hashCode()), new C265126());
        AppMethodBeat.m2505o(78831);
    }

    public HashMap<Integer, C1366d> collectDatabaseFactory() {
        return eaA;
    }
}
