package com.tencent.p177mm.plugin.honey_pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p217ci.C32467c;
import com.tencent.p177mm.p217ci.C41931h;
import com.tencent.p177mm.p230g.p231a.C9424nj;
import com.tencent.p177mm.plugin.honey_pay.model.C28289c;
import com.tencent.p177mm.plugin.honey_pay.model.C34334a;
import com.tencent.p177mm.plugin.honey_pay.model.C39246b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3473o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.honey_pay.a */
public class C12223a implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C41931h<C39246b> nqt = new C41931h(new C32852());
    private C4884c<C9424nj> nqu = new C69453();
    private C3473o nqv = new C69464();

    /* renamed from: com.tencent.mm.plugin.honey_pay.a$2 */
    class C32852 implements C32467c<C39246b> {
        C32852() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(41707);
            C1720g.m3537RQ();
            C39246b c39246b = new C39246b(C1720g.m3536RP().eJN);
            AppMethodBeat.m2505o(41707);
            return c39246b;
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.a$3 */
    class C69453 extends C4884c<C9424nj> {
        C69453() {
            AppMethodBeat.m2504i(41708);
            this.xxI = C9424nj.class.getName().hashCode();
            AppMethodBeat.m2505o(41708);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(41709);
            C9424nj c9424nj = (C9424nj) c4883b;
            C4990ab.m7417i("MicroMsg.SubCoreHoneyPay", "receive honey pay msg: %s, %s", c9424nj.cJG.cJH, Long.valueOf(c9424nj.cJG.cJD));
            if (!C5046bo.isNullOrNil(c9424nj.cJG.cJH) && c9424nj.cJG.cJD > -1) {
                if (!C5046bo.isNullOrNil(c9424nj.cJG.username)) {
                    C4990ab.m7411d("MicroMsg.SubCoreHoneyPay", "need replace username: %s", c9424nj.cJG.username);
                    String z = C28289c.m44891z(c9424nj.cJG.cJh, c9424nj.cJG.username, 6);
                    if (z.equals(c9424nj.cJG.cJh)) {
                        c9424nj.cJG.cJh = null;
                    } else {
                        c9424nj.cJG.cJh = z;
                    }
                }
                C34334a c34334a = new C34334a();
                c34334a.field_msgId = c9424nj.cJG.cJD;
                c34334a.field_payMsgId = c9424nj.cJG.cJH;
                C12223a.this.bFW().mo10101b((C4925c) c34334a);
            }
            AppMethodBeat.m2505o(41709);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.a$4 */
    class C69464 implements C3473o {
        C69464() {
        }

        public final void onNewXmlReceived(String str, Map<String, String> map, C1197a c1197a) {
            AppMethodBeat.m2504i(41710);
            if (C5046bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0) == 35) {
                C4990ab.m7416i("MicroMsg.SubCoreHoneyPay", "receive honey pay newxml");
                String str2 = (String) map.get(".sysmsg.paymsg.appmsgcontent");
                String str3 = (String) map.get(".sysmsg.paymsg.fromusername");
                String str4 = (String) map.get(".sysmsg.paymsg.tousername");
                String str5 = (String) map.get(".sysmsg.paymsg.paymsgid");
                String str6 = (String) map.get(".sysmsg.paymsg.systip");
                if (!C5046bo.isNullOrNil(str2)) {
                    C4990ab.m7411d("MicroMsg.SubCoreHoneyPay", "appmsg: %s", URLDecoder.decode(str2));
                    C28289c.m44889o(str5, str2, str4, str3);
                }
                if (!C5046bo.isNullOrNil(str6)) {
                    C4990ab.m7411d("MicroMsg.SubCoreHoneyPay", "systip: %s", URLDecoder.decode(str6));
                    C28289c.m44880V(str4, str2, str3);
                }
            }
            AppMethodBeat.m2505o(41710);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.a$1 */
    static class C122241 implements C1366d {
        C122241() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C39246b.fnj;
        }
    }

    static {
        AppMethodBeat.m2504i(41716);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("HoneyPayMsgRecord".hashCode()), new C122241());
        AppMethodBeat.m2505o(41716);
    }

    public static C12223a bFV() {
        AppMethodBeat.m2504i(41711);
        C12223a c12223a = (C12223a) C7485q.m12925Y(C12223a.class);
        AppMethodBeat.m2505o(41711);
        return c12223a;
    }

    public C12223a() {
        AppMethodBeat.m2504i(41712);
        AppMethodBeat.m2505o(41712);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(41713);
        this.nqu.dnU();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14902a("paymsg", this.nqv);
        AppMethodBeat.m2505o(41713);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(41714);
        this.nqu.dead();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14905b("paymsg", this.nqv);
        AppMethodBeat.m2505o(41714);
    }

    public final C39246b bFW() {
        AppMethodBeat.m2504i(41715);
        C39246b c39246b = (C39246b) this.nqt.get();
        AppMethodBeat.m2505o(41715);
        return c39246b;
    }
}
