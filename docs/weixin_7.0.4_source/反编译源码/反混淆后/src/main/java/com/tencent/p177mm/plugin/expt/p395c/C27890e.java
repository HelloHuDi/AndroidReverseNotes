package com.tencent.p177mm.plugin.expt.p395c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.p230g.p232b.p233a.C26295w;
import com.tencent.p177mm.plugin.expt.hellhound.C11755a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.expt.p394a.C43014c.C38982a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* renamed from: com.tencent.mm.plugin.expt.c.e */
public final class C27890e {
    private static C27890e lOg;

    /* renamed from: com.tencent.mm.plugin.expt.c.e$2 */
    class C205952 implements Comparator<C26295w> {
        C205952() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return (int) (((C26295w) obj).cWT - ((C26295w) obj2).cWT);
        }
    }

    private C27890e() {
    }

    public static C27890e brf() {
        AppMethodBeat.m2504i(73555);
        if (lOg == null) {
            lOg = new C27890e();
        }
        C27890e c27890e = lOg;
        AppMethodBeat.m2505o(73555);
        return c27890e;
    }

    /* renamed from: a */
    public final void mo45791a(C26295w c26295w) {
        AppMethodBeat.m2504i(73556);
        if (c26295w == null) {
            AppMethodBeat.m2505o(73556);
            return;
        }
        int i = (int) c26295w.cWS;
        if (i == C38982a.MMAppMgr_Activated.value || i == C38982a.MMAppMgr_Deactivated.value) {
            m44334a(C11745a.clicfg_weixin_mm_app_mgr, c26295w);
            if (C45899a.bqW()) {
                c26295w.ajK();
            }
        }
        if (i == C38982a.MMLifeCall_OnResume.value || i == C38982a.MMLifeCall_OnPause.value) {
            m44334a(C11745a.clicfg_weixin_mm_life_call, c26295w);
            if (C45899a.bqX()) {
                c26295w.ajK();
            }
        }
        if ((i == C38982a.MMActivity_Back2Front.value || i == C38982a.MMActivity_Front2Back.value) && C11755a.bqj() && C11755a.bqk()) {
            m44334a(C11745a.clicfg_weixin_mm_hell_hound, c26295w);
            if (C45899a.bqY()) {
                c26295w.ajK();
            }
        }
        AppMethodBeat.m2505o(73556);
    }

    /* renamed from: a */
    private void m44334a(C11745a c11745a, C26295w c26295w) {
        AppMethodBeat.m2504i(73557);
        if (C4996ah.bqo()) {
            long yz = C5046bo.m7588yz();
            int b = C45899a.m85091b(c11745a);
            if (b <= 0) {
                AppMethodBeat.m2505o(73557);
                return;
            }
            C5018as bra = C27890e.bra();
            if (bra == null) {
                AppMethodBeat.m2505o(73557);
                return;
            }
            String str = bra.getString(c11745a.name(), "") + "|" + c26295w.mo44067eU(";");
            long j = bra.getLong(c11745a.name() + "_rpttime", 0);
            if ((str.length() >= b || C5046bo.m7549fp(j) > 3600) && c26295w.cWS % 2 == 0) {
                bra.putLong(c11745a.name() + "_rpttime", C5046bo.anT());
                bra.putString(c11745a.name(), "");
                C7060h.pYm.mo8374X(16562, str);
                if (c11745a == C11745a.clicfg_weixin_mm_hell_hound) {
                    m44333KZ(str);
                }
            } else {
                bra.putString(c11745a.name(), str);
            }
            C4990ab.m7419v("MicroMsg.MMPageReporter", "handle merge cost[%d]", Long.valueOf(C5046bo.m7525az(yz)));
            AppMethodBeat.m2505o(73557);
            return;
        }
        AppMethodBeat.m2505o(73557);
    }

    private static C5018as bra() {
        AppMethodBeat.m2504i(73558);
        int Ra = C1668a.m3396Ra();
        if (Ra == 0) {
            AppMethodBeat.m2505o(73558);
            return null;
        }
        C5018as amF = C5018as.amF(Ra + "_WxPageFlowMerge");
        AppMethodBeat.m2505o(73558);
        return amF;
    }

    /* renamed from: KZ */
    private void m44333KZ(final String str) {
        AppMethodBeat.m2504i(73559);
        C7305d.post(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:45:0x011c  */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x011c  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                Throwable e;
                AppMethodBeat.m2504i(73554);
                C27890e c27890e = C27890e.this;
                String str = str;
                if (!C5046bo.isNullOrNil(str)) {
                    long yz = C5046bo.m7588yz();
                    String[] split = str.split("\\|");
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : split) {
                        if (!C5046bo.isNullOrNil(str2)) {
                            C26295w c26295w = new C26295w(str2.replace(';', ','));
                            if (c26295w.cWT > 0 && c26295w.cWS > 0) {
                                arrayList.add(c26295w);
                            }
                        }
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    int i = 0;
                    if (!arrayList.isEmpty()) {
                        Collections.sort(arrayList, new C205952());
                        try {
                            int size = arrayList.size();
                            C26295w c26295w2 = null;
                            long j = 0;
                            int i2 = 0;
                            int i3 = 0;
                            while (i2 < size) {
                                try {
                                    long j2;
                                    C26295w c26295w3 = (C26295w) arrayList.get(i2);
                                    if (i2 + 1 < size) {
                                        c26295w2 = (C26295w) arrayList.get(i2 + 1);
                                    }
                                    if (!(c26295w3 == null || c26295w2 == null)) {
                                        if (c26295w3.cWS == 7 && c26295w2.cWS == 8 && c26295w3.cWT < c26295w2.cWT && c26295w3.cWc == c26295w2.cWc) {
                                            j = j > 0 ? c26295w3.cWT - j : 0;
                                            stringBuffer.append(String.format("{\"tbe\":%d.\"ten\":%d.\"in\":%d.\"inbg\":%d}", new Object[]{Long.valueOf(c26295w3.cWT), Long.valueOf(c26295w2.cWT), Long.valueOf(c26295w2.cWT - c26295w3.cWT), Long.valueOf(j)})).append(";");
                                            j = c26295w2.cWT;
                                            i3++;
                                            i2 += 2;
                                        } else if (c26295w3.cWS == 8) {
                                            j2 = c26295w3.cWT;
                                            i2++;
                                            j = j2;
                                        }
                                    }
                                    j2 = j;
                                    i2++;
                                    j = j2;
                                } catch (Exception e2) {
                                    e = e2;
                                    i = i3;
                                    C4990ab.printErrStackTrace("MicroMsg.MMPageReporter", e, "reportWeixinAppTime error", new Object[0]);
                                    if (!C5046bo.isNullOrNil(stringBuffer.toString())) {
                                    }
                                    C4990ab.m7417i("MicroMsg.MMPageReporter", "reportWeixinAppTime cost[%d] count[%d]", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(i));
                                    AppMethodBeat.m2505o(73554);
                                }
                            }
                            i = i3;
                        } catch (Exception e3) {
                            e = e3;
                            C4990ab.printErrStackTrace("MicroMsg.MMPageReporter", e, "reportWeixinAppTime error", new Object[0]);
                            if (C5046bo.isNullOrNil(stringBuffer.toString())) {
                            }
                            C4990ab.m7417i("MicroMsg.MMPageReporter", "reportWeixinAppTime cost[%d] count[%d]", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(i));
                            AppMethodBeat.m2505o(73554);
                        }
                    }
                    if (C5046bo.isNullOrNil(stringBuffer.toString())) {
                        C7060h.pYm.mo8381e(16563, stringBuffer.toString(), Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(i));
                        C4990ab.m7417i("MicroMsg.MMPageReporter", "reportWeixinAppTime [%s]", r3);
                    }
                    C4990ab.m7417i("MicroMsg.MMPageReporter", "reportWeixinAppTime cost[%d] count[%d]", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(i));
                }
                AppMethodBeat.m2505o(73554);
            }
        }, "report_weixin_app_time");
        AppMethodBeat.m2505o(73559);
    }
}
