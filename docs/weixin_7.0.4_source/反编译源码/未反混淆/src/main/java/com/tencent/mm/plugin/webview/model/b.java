package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.aq.o;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class b {
    public volatile al ulH = new al("WebviewWorkerThread");
    aq ulI;

    /* renamed from: com.tencent.mm.plugin.webview.model.b$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String ulJ;
        final /* synthetic */ d ulK;

        public AnonymousClass1(String str, d dVar) {
            this.ulJ = str;
            this.ulK = dVar;
        }

        public final void run() {
            AppMethodBeat.i(6568);
            Map z = br.z(this.ulJ, "DNSAdvanceRelateDomain");
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
                    if (bo.isNullOrNil(str)) {
                        ab.i("MicroMsg.DNSPreGetOptimize", "now break for main domain i = %d", Integer.valueOf(i3));
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
                    if (bo.isNullOrNil(str2) && bo.isNullOrNil(str)) {
                        break;
                    }
                    if (!(bo.isNullOrNil(str2) || linkedList.contains(str2))) {
                        linkedList.add(str2);
                    }
                    if (!(bo.isNullOrNil(str) || linkedList.contains(str))) {
                        linkedList.add(str);
                    }
                    i2 = i + 1;
                }
                ab.i("MicroMsg.DNSPreGetOptimize", "now break for releated domain j = %d", Integer.valueOf(i));
                o cXT = b.this.ulI.cXT();
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
                            ab.i("MicroMsg.DNSPreGetOptimize", "get dns for domain : %s, cost time : %d", str, Long.valueOf(currentTimeMillis));
                        } catch (Exception e) {
                            ab.e("MicroMsg.DNSPreGetOptimize", "get dns failed : %s", e.getMessage());
                            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                        }
                        cXT.iBv = currentTimeMillis;
                        cXT.url = str;
                        if (inetAddress != null) {
                            cXT.cxT = true;
                        } else {
                            cXT.cxT = false;
                        }
                        d dVar = this.ulK;
                        if (dVar != null) {
                            ab.i("MicroMsg.WebviewReporter", "WebviewPreGetDNSReporter, netType = %d, costTime = %d, url = %s, isSuccess = %s", Integer.valueOf(aq.aEn()), Long.valueOf(cXT.iBv), cXT.url, Boolean.valueOf(cXT.cxT));
                            String str3 = cXT.uni;
                            Object[] objArr = new Object[11];
                            objArr[0] = Integer.valueOf(1);
                            objArr[1] = Long.valueOf(cXT.iBv);
                            objArr[2] = Integer.valueOf(at.getNetType(ah.getContext()));
                            if (cXT.url == null) {
                                str = cXT.url;
                            } else {
                                str = cXT.url.replace(",", "!");
                            }
                            objArr[3] = str;
                            objArr[4] = Integer.valueOf(0);
                            objArr[5] = Integer.valueOf(0);
                            objArr[6] = Integer.valueOf(0);
                            objArr[7] = Integer.valueOf(aq.umY);
                            objArr[8] = Integer.valueOf(aq.umZ);
                            objArr[9] = Integer.valueOf(cXT.cSQ);
                            objArr[10] = cXT.uni;
                            aq.b(dVar, str3, objArr);
                            if (!cXT.cxT) {
                                h.pYm.a(32, 12, 1, true);
                            }
                            h.pYm.a(32, 1, 1, true);
                            h.pYm.a(32, 5, cXT.iBv, true);
                        }
                    }
                    AppMethodBeat.o(6568);
                    return;
                } catch (Exception e2) {
                    ab.e("MicroMsg.DNSPreGetOptimize", "get dns failed 2 : %s", e2.getMessage());
                }
            }
            AppMethodBeat.o(6568);
        }
    }

    public b(aq aqVar) {
        AppMethodBeat.i(6569);
        this.ulI = aqVar;
        AppMethodBeat.o(6569);
    }

    public final al aNS() {
        AppMethodBeat.i(6570);
        if (this.ulH == null) {
            this.ulH = new al("WebviewWorkerThread");
        }
        al alVar = this.ulH;
        AppMethodBeat.o(6570);
        return alVar;
    }
}
