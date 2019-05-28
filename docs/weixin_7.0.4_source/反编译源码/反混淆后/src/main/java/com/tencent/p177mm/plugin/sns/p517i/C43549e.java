package com.tencent.p177mm.plugin.sns.p517i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p230g.p231a.C9333fa;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.storage.C5144y;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.i.e */
public final class C43549e {
    private static final Integer qTc = Integer.valueOf(1);
    public static C43549e qTd = new C43549e();
    public int eFs = 0;
    public C5144y ecO;
    public HashMap<String, Integer> qTe;
    public HashMap<String, String> qTf;
    public HashSet<String> qTg;
    private LinkedHashMap<Long, Object> qTh;
    private int qTi = 0;
    public int qTj = 200;
    public int qTk = 86400;
    private C4884c<C9333fa> qTl = new C219012();

    /* renamed from: com.tencent.mm.plugin.sns.i.e$2 */
    class C219012 extends C4884c<C9333fa> {
        C219012() {
            AppMethodBeat.m2504i(36881);
            this.xxI = C9333fa.class.getName().hashCode();
            AppMethodBeat.m2505o(36881);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36882);
            C43549e.m77855d(C43549e.this);
            AppMethodBeat.m2505o(36882);
            return false;
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m77855d(C43549e c43549e) {
        AppMethodBeat.m2504i(36890);
        c43549e.coF();
        AppMethodBeat.m2505o(36890);
    }

    static {
        AppMethodBeat.m2504i(36891);
        AppMethodBeat.m2505o(36891);
    }

    private C43549e() {
        AppMethodBeat.m2504i(36883);
        C5141c ll = C18624c.abi().mo17131ll("100077");
        if (ll.isValid()) {
            Map dru = ll.dru();
            this.qTj = C5046bo.getInt((String) dru.get("maxCacheFeedCount"), 200);
            this.qTk = C5046bo.getInt((String) dru.get("maxCacheSeconds"), 86400);
            this.eFs = C5046bo.getInt((String) dru.get("needUploadData"), 0);
        }
        C4990ab.m7417i("MicroMsg.SnsReportHelper", "initAbtestArg maxCacheFeedCount:%d, maxCacheSeconds:%d, needUploadData:%d", Integer.valueOf(this.qTj), Integer.valueOf(this.qTk), Integer.valueOf(this.eFs));
        coF();
        this.ecO = new C5144y(C5128ac.eSj + "snsreport.cfg");
        Object obj = this.ecO.get(3, new HashMap());
        Object obj2 = this.ecO.get(4, new HashMap());
        Object obj3 = this.ecO.get(5, new HashSet());
        Object obj4 = this.ecO.get(6, new LinkedHashMap());
        if ((obj instanceof HashMap) && (obj2 instanceof HashMap) && (obj3 instanceof HashSet) && (obj4 instanceof LinkedHashMap)) {
            this.qTe = (HashMap) obj;
            this.qTf = (HashMap) obj2;
            this.qTg = (HashSet) obj3;
            this.qTh = (LinkedHashMap) obj4;
        } else {
            C5730e.deleteFile(C5128ac.eSj + "snsreport.cfg");
            this.qTe = new HashMap();
            this.qTf = new HashMap();
            this.qTg = new HashSet();
            this.qTh = new LinkedHashMap();
        }
        C4990ab.m7411d("MicroMsg.SnsReportHelper", "obj[%d] objForAppId[%d] objForFold[%d] objForAppIdCgi[%d] ", Integer.valueOf(this.qTe.size()), Integer.valueOf(this.qTf.size()), Integer.valueOf(this.qTg.size()), Integer.valueOf(this.qTh.size()));
        C4879a.xxA.mo10051b(this.qTl);
        AppMethodBeat.m2505o(36883);
    }

    /* renamed from: bl */
    public final void mo69123bl(String str, boolean z) {
        AppMethodBeat.m2504i(36884);
        if (this.eFs == 0) {
            AppMethodBeat.m2505o(36884);
            return;
        }
        this.qTe.put(str, Integer.valueOf(this.qTe.containsKey(str) ? ((Integer) this.qTe.get(str)).intValue() + 1 : 1));
        if (z) {
            this.qTg.add(str);
        }
        AppMethodBeat.m2505o(36884);
    }

    /* renamed from: gh */
    public final void mo69126gh(String str, String str2) {
        AppMethodBeat.m2504i(36885);
        if (this.eFs == 0 || C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(36885);
            return;
        }
        this.qTf.put(str, str2);
        AppMethodBeat.m2505o(36885);
    }

    private void coF() {
        AppMethodBeat.m2504i(36886);
        this.qTi = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_real_feed_exposure_count_limit_and, 0);
        C4990ab.m7417i("MicroMsg.SnsReportHelper", "resetXExptControl maxFeedIdForCgiRecord[%d]", Integer.valueOf(this.qTi));
        AppMethodBeat.m2505o(36886);
    }

    /* renamed from: kr */
    public final synchronized void mo69127kr(long j) {
        AppMethodBeat.m2504i(36887);
        if (this.qTi > 0) {
            this.qTh.put(Long.valueOf(j), qTc);
        }
        AppMethodBeat.m2505o(36887);
    }

    public final synchronized void coG() {
        AppMethodBeat.m2504i(138380);
        if (this.qTi <= 0) {
            AppMethodBeat.m2505o(138380);
        } else {
            final LinkedHashMap linkedHashMap = (LinkedHashMap) this.qTh.clone();
            C7305d.post(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.sns.i.e$1$1 */
                class C397381 implements Runnable {
                    C397381() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(36879);
                        LinkedHashMap b = C43549e.this.qTh;
                        C43549e.this.qTh = linkedHashMap;
                        b.clear();
                        AppMethodBeat.m2505o(36879);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(36880);
                    long yz = C5046bo.m7588yz();
                    int size = linkedHashMap.size();
                    if (size >= C43549e.this.qTi) {
                        int a = size - C43549e.this.qTi;
                        Iterator it = linkedHashMap.keySet().iterator();
                        int i = 0;
                        while (it.hasNext() && i < a) {
                            it.next();
                            it.remove();
                            i++;
                        }
                        C5004al.m7441d(new C397381());
                    }
                    C43549e.this.ecO.set(6, linkedHashMap);
                    C4990ab.m7417i("MicroMsg.SnsReportHelper", "save exposure feed id for cgi [%d] oriSize[%d] cost[%d]", Integer.valueOf(linkedHashMap.size()), Integer.valueOf(size), Long.valueOf(C5046bo.m7525az(yz)));
                    AppMethodBeat.m2505o(36880);
                }
            }, "save_exposure_feed");
            AppMethodBeat.m2505o(138380);
        }
    }

    public final synchronized LinkedList<Long> coH() {
        LinkedList<Long> linkedList;
        AppMethodBeat.m2504i(138381);
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.qTh.clone();
        if (linkedHashMap.size() <= 0 || this.qTi <= 0) {
            linkedList = null;
            AppMethodBeat.m2505o(138381);
        } else {
            LinkedList<Long> linkedList2 = new LinkedList();
            int i = 0;
            for (Long addFirst : linkedHashMap.keySet()) {
                linkedList2.addFirst(addFirst);
                int i2 = i + 1;
                if (i2 > this.qTi) {
                    linkedList2.removeLast();
                }
                i = i2;
            }
            AppMethodBeat.m2505o(138381);
            linkedList = linkedList2;
        }
        return linkedList;
    }
}
