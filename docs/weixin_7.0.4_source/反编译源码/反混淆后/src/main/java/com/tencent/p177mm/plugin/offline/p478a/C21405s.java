package com.tencent.p177mm.plugin.offline.p478a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C9489us;
import com.tencent.p177mm.plugin.offline.C34645g;
import com.tencent.p177mm.plugin.offline.C7007k;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.offline.a.s */
public final class C21405s {
    private List<WeakReference<C3562a>> kaD = new ArrayList();
    public ArrayList<Long> oVR = new ArrayList();
    public C7004b oYL = null;
    private HashSet<String> oYM = new HashSet();

    /* renamed from: com.tencent.mm.plugin.offline.a.s$a */
    public interface C3562a {
        /* renamed from: a */
        boolean mo8122a(C3563c c3563c);
    }

    /* renamed from: com.tencent.mm.plugin.offline.a.s$c */
    public class C3563c {
        public int oYS;
    }

    /* renamed from: com.tencent.mm.plugin.offline.a.s$b */
    public class C7004b extends C3563c {
        public String oYP;
        public String oYQ;
        public String oYR;

        public C7004b() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.a.s$h */
    public class C21406h {
        public String cRb;
        public String cRc;
        public String cRd;
        public String cRe;
        public String cRf;
        public boolean oZd;

        public C21406h(Map<String, String> map) {
            AppMethodBeat.m2504i(43422);
            this.cRb = (String) map.get(".sysmsg.paymsg.guide_flag");
            this.cRc = (String) map.get(".sysmsg.paymsg.guide_wording");
            this.cRd = (String) map.get(".sysmsg.paymsg.left_button_wording");
            this.cRe = (String) map.get(".sysmsg.paymsg.right_button_wording");
            this.cRf = (String) map.get(".sysmsg.paymsg.upload_credit_url");
            this.oZd = "1".equals(map.get(".sysmsg.paymsg.guide_block"));
            AppMethodBeat.m2505o(43422);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.a.s$d */
    public class C21407d extends C3563c {
        public String cBT;

        public C21407d() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.a.s$1 */
    class C214081 implements Runnable {
        final /* synthetic */ boolean oYN = false;

        C214081() {
        }

        public final void run() {
            AppMethodBeat.m2504i(43421);
            C4990ab.m7418v("MicroMsg.WalletOfflineMsgManager", "DO NetSceneOfflineAckMsg");
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(new C12734b(this.oYN), 0);
            AppMethodBeat.m2505o(43421);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.a.s$e */
    public class C21409e extends C3563c {
        public String oYT;
        public String oYU;
        public String oYV;
        public String oYW;
        public String oYX;
        public boolean oYY = true;

        public C21409e() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.a.s$g */
    public class C21410g extends C3563c {
        public String cBT;
        /* renamed from: id */
        public String f4389id;
        public int kKC;
        public String oZb;
        public String oZc;

        public C21410g() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.a.s$f */
    public class C21411f extends C3563c {
        public C21406h cRz;
        public String oYZ;
        public Orders oZa;

        public C21411f() {
            super();
        }
    }

    public C21405s() {
        AppMethodBeat.m2504i(43423);
        String bYn = C28630a.bYn();
        if (!TextUtils.isEmpty(bYn)) {
            Map z = C5049br.m7595z(bYn, "sysmsg");
            if (z != null) {
                int i = C5046bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
                if (i >= 0 && i == 4) {
                    C4990ab.m7416i("MicroMsg.WalletOfflineMsgManager", "msg type is 4 ");
                    m32834b(m32829O(z));
                }
            }
        }
        this.oVR.clear();
        AppMethodBeat.m2505o(43423);
    }

    /* renamed from: b */
    private void m32834b(C3563c c3563c) {
        AppMethodBeat.m2504i(43424);
        if (this.kaD == null) {
            AppMethodBeat.m2505o(43424);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.kaD.size()) {
                break;
            }
            WeakReference weakReference = (WeakReference) this.kaD.get(i2);
            if (weakReference != null) {
                C3562a c3562a = (C3562a) weakReference.get();
                if (c3562a != null && c3562a.mo8122a(c3563c)) {
                    break;
                }
            }
            i = i2 + 1;
        }
        AppMethodBeat.m2505o(43424);
    }

    /* renamed from: a */
    public final void mo36866a(C3562a c3562a) {
        AppMethodBeat.m2504i(43425);
        if (this.kaD == null) {
            this.kaD = new ArrayList();
        }
        this.kaD.add(new WeakReference(c3562a));
        AppMethodBeat.m2505o(43425);
    }

    /* renamed from: b */
    public final void mo36867b(C3562a c3562a) {
        AppMethodBeat.m2504i(43426);
        if (this.kaD == null) {
            AppMethodBeat.m2505o(43426);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    C3562a c3562a2 = (C3562a) weakReference.get();
                    if (c3562a2 != null && c3562a2.equals(c3562a)) {
                        this.kaD.remove(weakReference);
                        AppMethodBeat.m2505o(43426);
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(43426);
                return;
            }
        }
    }

    /* renamed from: TW */
    public final void mo36864TW(String str) {
        AppMethodBeat.m2504i(43427);
        C28630a.m45505Um("");
        C28630a.m45507Uo("");
        C28630a.m45506Un("");
        Map z = C5049br.m7595z(str, "sysmsg");
        if (z == null) {
            AppMethodBeat.m2505o(43427);
            return;
        }
        int i = C5046bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
        int i2 = C5046bo.getInt((String) z.get(".sysmsg.paymsg.pay_cmd"), -1);
        String str2 = (String) z.get(".sysmsg.paymsg.req_key");
        C28630a.m45505Um((String) z.get(".sysmsg.paymsg.ack_key"));
        C28630a.m45493AE(i);
        C28630a.m45506Un(str2);
        int i3 = C5046bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
        C4990ab.m7416i("MicroMsg.WalletOfflineMsgManager", "msg type is ".concat(String.valueOf(i3)));
        C4990ab.m7419v("MicroMsg.WalletOfflineMsgManager", "msg type is type %d xml %s", Integer.valueOf(i3), str);
        if (i3 >= 0 && i3 == 4) {
            m32834b(m32829O(z));
            C28630a.m45496Ud(str);
            AppMethodBeat.m2505o(43427);
        } else if (i3 >= 0 && i3 == 5) {
            boolean z2;
            if (i2 == 1) {
                C4990ab.m7416i("MicroMsg.WalletOfflineMsgManager", "payCmd is PAY_CMD_OFFLINE_PAY_REFRESH_TOKEN (value is 1), refresh offline token");
                C7007k.bXg();
                C7007k.bXj().mo62419eO(4, 4);
                z2 = false;
            } else {
                z2 = true;
            }
            C3563c P = m32830P(z);
            P.oYY = z2;
            m32834b(P);
            AppMethodBeat.m2505o(43427);
        } else if (i3 >= 0 && i3 == 6) {
            str2 = (String) z.get(".sysmsg.paymsg.transid");
            C4990ab.m7416i("helios", "MSG_TYPE_ORDER trasid=".concat(String.valueOf(str2)));
            if (!C5046bo.isNullOrNil(str2)) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.TRUE);
            }
            C4990ab.m7417i("MicroMsg.WalletOfflineMsgManager", "orders xml: %s", str);
            m32834b(m32831Q(z));
            AppMethodBeat.m2505o(43427);
        } else if (i3 >= 0 && i3 == 7) {
            C14241r.cPI().mo38129Km();
            AppMethodBeat.m2505o(43427);
        } else if (i3 >= 0 && i3 == 8) {
            m32834b(m32833S(z));
            AppMethodBeat.m2505o(43427);
        } else if (i3 >= 0 && i3 == 10) {
            C7007k.bXg();
            C7007k.bXj().mo62419eO(4, 4);
            AppMethodBeat.m2505o(43427);
        } else if (i3 >= 0 && i3 == 20) {
            C9489us c9489us = new C9489us();
            c9489us.cRy.cRz = new C21406h(z);
            C4879a.xxA.mo10055m(c9489us);
            AppMethodBeat.m2505o(43427);
        } else if (i3 >= 0 && i3 == 23) {
            C3563c R = m32832R(z);
            synchronized (this.oYM) {
                try {
                    if (this.oYM.contains(R.cBT)) {
                        C4990ab.m7417i("MicroMsg.WalletOfflineMsgManager", "pass this msg %s", R.cBT);
                    } else {
                        this.oYM.add(R.cBT);
                        m32834b(R);
                        AppMethodBeat.m2505o(43427);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(43427);
                }
            }
        } else if (i3 < 0 || i3 != 24) {
            AppMethodBeat.m2505o(43427);
        } else {
            m32834b(m32828N(z));
            AppMethodBeat.m2505o(43427);
        }
    }

    /* renamed from: N */
    private C21407d m32828N(Map<String, String> map) {
        AppMethodBeat.m2504i(43428);
        C21407d c21407d = new C21407d();
        c21407d.oYS = C5046bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), -1);
        c21407d.cBT = (String) map.get(".sysmsg.paymsg.req_key");
        AppMethodBeat.m2505o(43428);
        return c21407d;
    }

    /* renamed from: O */
    private C7004b m32829O(Map<String, String> map) {
        AppMethodBeat.m2504i(43429);
        if (this.oYL == null) {
            this.oYL = new C7004b();
        }
        this.oYL.oYS = C5046bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), -1);
        this.oYL.oYP = (String) map.get(".sysmsg.paymsg.isfreeze");
        this.oYL.oYQ = (String) map.get(".sysmsg.paymsg.freezetype");
        this.oYL.oYR = (String) map.get(".sysmsg.paymsg.freezemsg");
        C7004b c7004b = this.oYL;
        AppMethodBeat.m2505o(43429);
        return c7004b;
    }

    /* renamed from: P */
    private C21409e m32830P(Map<String, String> map) {
        AppMethodBeat.m2504i(43430);
        C21409e c21409e = new C21409e();
        c21409e.oYS = C5046bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), -1);
        c21409e.oYT = (String) map.get(".sysmsg.paymsg.cftretcode");
        c21409e.oYU = (String) map.get(".sysmsg.paymsg.cftretmsg");
        c21409e.oYV = (String) map.get(".sysmsg.paymsg.wxretcode");
        c21409e.oYW = (String) map.get(".sysmsg.paymsg.wxretmsg");
        c21409e.oYX = (String) map.get(".sysmsg.paymsg.error_detail_url");
        c21409e.oYY = true;
        AppMethodBeat.m2505o(43430);
        return c21409e;
    }

    /* renamed from: Q */
    private C21411f m32831Q(Map<String, String> map) {
        AppMethodBeat.m2504i(43431);
        C21411f c21411f = new C21411f();
        c21411f.oYS = C5046bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), -1);
        c21411f.oYZ = (String) map.get(".sysmsg.paymsg.transid");
        c21411f.oZa = C28630a.m45494T(map);
        if (c21411f.oZa.tAq.size() > 0) {
            C28630a.m45507Uo(((Commodity) c21411f.oZa.tAq.get(0)).cAa);
        }
        if (map.containsKey(".sysmsg.paymsg.real_name_info")) {
            c21411f.cRz = new C21406h(map);
        }
        AppMethodBeat.m2505o(43431);
        return c21411f;
    }

    /* renamed from: R */
    private C21407d m32832R(Map<String, String> map) {
        AppMethodBeat.m2504i(43432);
        C21407d c21407d = new C21407d();
        c21407d.oYS = C5046bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), -1);
        c21407d.cBT = (String) map.get(".sysmsg.paymsg.req_key");
        AppMethodBeat.m2505o(43432);
        return c21407d;
    }

    /* renamed from: S */
    private C21410g m32833S(Map<String, String> map) {
        AppMethodBeat.m2504i(43433);
        C21410g c21410g = new C21410g();
        c21410g.oYS = C5046bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), -1);
        c21410g.oZb = (String) map.get(".sysmsg.paymsg.good_name");
        c21410g.oZc = (String) map.get(".sysmsg.paymsg.total_fee");
        c21410g.cBT = (String) map.get(".sysmsg.paymsg.req_key");
        c21410g.f4389id = (String) map.get(".sysmsg.paymsg.id");
        String str = (String) map.get(".sysmsg.paymsg.confirm_type");
        C4990ab.m7416i("MicroMsg.WalletOfflineMsgManager", "msg confirm_type is" + c21410g.kKC);
        if (TextUtils.isEmpty(str) || !str.equals("1")) {
            c21410g.kKC = 0;
        } else {
            c21410g.kKC = 1;
        }
        AppMethodBeat.m2505o(43433);
        return c21410g;
    }

    /* renamed from: TX */
    public final void mo36865TX(String str) {
        AppMethodBeat.m2504i(43434);
        int i = C5046bo.getInt((String) C5049br.m7595z(str, "sysmsg").get(".sysmsg.paymsg.PayMsgType"), -1);
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(C34645g.oXe));
        hashSet.add(Integer.valueOf(C34645g.oXd));
        hashSet.add(Integer.valueOf(C34645g.oXf));
        hashSet.add(Integer.valueOf(C34645g.oXc));
        hashSet.add(Integer.valueOf(C34645g.oWZ));
        if (hashSet.contains(Integer.valueOf(i))) {
            C1720g.m3539RS().mo10302aa(new C214081());
        }
        AppMethodBeat.m2505o(43434);
    }
}
