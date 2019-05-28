package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.model.C40259aq.C22886o;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.webview.model.b */
public final class C46424b {
    public volatile C5004al ulH = new C5004al("WebviewWorkerThread");
    C40259aq ulI;

    /* renamed from: com.tencent.mm.plugin.webview.model.b$1 */
    public class C356131 implements Runnable {
        final /* synthetic */ String ulJ;
        final /* synthetic */ C46434d ulK;

        public C356131(String str, C46434d c46434d) {
            this.ulJ = str;
            this.ulK = c46434d;
        }

        public final void run() {
            AppMethodBeat.m2504i(6568);
            Map z = C5049br.m7595z(this.ulJ, "DNSAdvanceRelateDomain");
            LinkedList linkedList = new LinkedList();
            if (z != null && z.size() > 0) {
                String str;
                int i;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= z.size()) {
                        break;
                    }
                    str = (String) z.get(".DNSAdvanceRelateDomain.RelateDomain" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".$domain");
                    if (C5046bo.isNullOrNil(str)) {
                        C4990ab.m7417i("MicroMsg.DNSPreGetOptimize", "now break for main domain i = %d", Integer.valueOf(i3));
                        break;
                    }
                    if (!linkedList.contains(str)) {
                        linkedList.add(str);
                    }
                    i2 = i3 + 1;
                }
                i2 = 0;
                while (true) {
                    i = i2;
                    String str2 = (String) z.get(".DNSAdvanceRelateDomain.RelateDomain" + (i == 0 ? "" : Integer.valueOf(i)) + ".Relate");
                    str = (String) z.get(".DNSAdvanceRelateDomain.RelateDomain.Relate" + (i == 0 ? "" : Integer.valueOf(i)));
                    if (C5046bo.isNullOrNil(str2) && C5046bo.isNullOrNil(str)) {
                        break;
                    }
                    if (!(C5046bo.isNullOrNil(str2) || linkedList.contains(str2))) {
                        linkedList.add(str2);
                    }
                    if (!(C5046bo.isNullOrNil(str) || linkedList.contains(str))) {
                        linkedList.add(str);
                    }
                    i2 = i + 1;
                }
                C4990ab.m7417i("MicroMsg.DNSPreGetOptimize", "now break for releated domain j = %d", Integer.valueOf(i));
                C22886o cXT = C46424b.this.ulI.cXT();
                try {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        long currentTimeMillis;
                        str = (String) it.next();
                        long currentTimeMillis2 = System.currentTimeMillis();
                        InetAddress inetAddress = null;
                        try {
                            inetAddress = InetAddress.getByName(str);
                            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                            C4990ab.m7417i("MicroMsg.DNSPreGetOptimize", "get dns for domain : %s, cost time : %d", str, Long.valueOf(currentTimeMillis));
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.DNSPreGetOptimize", "get dns failed : %s", e.getMessage());
                            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                        }
                        cXT.iBv = currentTimeMillis;
                        cXT.url = str;
                        if (inetAddress != null) {
                            cXT.cxT = true;
                        } else {
                            cXT.cxT = false;
                        }
                        C46434d c46434d = this.ulK;
                        if (c46434d != null) {
                            C4990ab.m7417i("MicroMsg.WebviewReporter", "WebviewPreGetDNSReporter, netType = %d, costTime = %d, url = %s, isSuccess = %s", Integer.valueOf(C40259aq.aEn()), Long.valueOf(cXT.iBv), cXT.url, Boolean.valueOf(cXT.cxT));
                            String str3 = cXT.uni;
                            Object[] objArr = new Object[11];
                            objArr[0] = Integer.valueOf(1);
                            objArr[1] = Long.valueOf(cXT.iBv);
                            objArr[2] = Integer.valueOf(C5023at.getNetType(C4996ah.getContext()));
                            if (cXT.url == null) {
                                str = cXT.url;
                            } else {
                                str = cXT.url.replace(",", "!");
                            }
                            objArr[3] = str;
                            objArr[4] = Integer.valueOf(0);
                            objArr[5] = Integer.valueOf(0);
                            objArr[6] = Integer.valueOf(0);
                            objArr[7] = Integer.valueOf(C40259aq.umY);
                            objArr[8] = Integer.valueOf(C40259aq.umZ);
                            objArr[9] = Integer.valueOf(cXT.cSQ);
                            objArr[10] = cXT.uni;
                            C40259aq.m69040b(c46434d, str3, objArr);
                            if (!cXT.cxT) {
                                C7060h.pYm.mo8378a(32, 12, 1, true);
                            }
                            C7060h.pYm.mo8378a(32, 1, 1, true);
                            C7060h.pYm.mo8378a(32, 5, cXT.iBv, true);
                        }
                    }
                    AppMethodBeat.m2505o(6568);
                    return;
                } catch (Exception e2) {
                    C4990ab.m7413e("MicroMsg.DNSPreGetOptimize", "get dns failed 2 : %s", e2.getMessage());
                }
            }
            AppMethodBeat.m2505o(6568);
        }
    }

    public C46424b(C40259aq c40259aq) {
        AppMethodBeat.m2504i(6569);
        this.ulI = c40259aq;
        AppMethodBeat.m2505o(6569);
    }

    public final C5004al aNS() {
        AppMethodBeat.m2504i(6570);
        if (this.ulH == null) {
            this.ulH = new C5004al("WebviewWorkerThread");
        }
        C5004al c5004al = this.ulH;
        AppMethodBeat.m2505o(6570);
        return c5004al;
    }
}
