package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public final class e {
    private static final Integer qTc = Integer.valueOf(1);
    public static e qTd = new e();
    public int eFs = 0;
    public y ecO;
    public HashMap<String, Integer> qTe;
    public HashMap<String, String> qTf;
    public HashSet<String> qTg;
    private LinkedHashMap<Long, Object> qTh;
    private int qTi = 0;
    public int qTj = 200;
    public int qTk = 86400;
    private c<fa> qTl = new c<fa>() {
        {
            AppMethodBeat.i(36881);
            this.xxI = fa.class.getName().hashCode();
            AppMethodBeat.o(36881);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(36882);
            e.d(e.this);
            AppMethodBeat.o(36882);
            return false;
        }
    };

    static /* synthetic */ void d(e eVar) {
        AppMethodBeat.i(36890);
        eVar.coF();
        AppMethodBeat.o(36890);
    }

    static {
        AppMethodBeat.i(36891);
        AppMethodBeat.o(36891);
    }

    private e() {
        AppMethodBeat.i(36883);
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100077");
        if (ll.isValid()) {
            Map dru = ll.dru();
            this.qTj = bo.getInt((String) dru.get("maxCacheFeedCount"), 200);
            this.qTk = bo.getInt((String) dru.get("maxCacheSeconds"), 86400);
            this.eFs = bo.getInt((String) dru.get("needUploadData"), 0);
        }
        ab.i("MicroMsg.SnsReportHelper", "initAbtestArg maxCacheFeedCount:%d, maxCacheSeconds:%d, needUploadData:%d", Integer.valueOf(this.qTj), Integer.valueOf(this.qTk), Integer.valueOf(this.eFs));
        coF();
        this.ecO = new y(ac.eSj + "snsreport.cfg");
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
            com.tencent.mm.vfs.e.deleteFile(ac.eSj + "snsreport.cfg");
            this.qTe = new HashMap();
            this.qTf = new HashMap();
            this.qTg = new HashSet();
            this.qTh = new LinkedHashMap();
        }
        ab.d("MicroMsg.SnsReportHelper", "obj[%d] objForAppId[%d] objForFold[%d] objForAppIdCgi[%d] ", Integer.valueOf(this.qTe.size()), Integer.valueOf(this.qTf.size()), Integer.valueOf(this.qTg.size()), Integer.valueOf(this.qTh.size()));
        a.xxA.b(this.qTl);
        AppMethodBeat.o(36883);
    }

    public final void bl(String str, boolean z) {
        AppMethodBeat.i(36884);
        if (this.eFs == 0) {
            AppMethodBeat.o(36884);
            return;
        }
        this.qTe.put(str, Integer.valueOf(this.qTe.containsKey(str) ? ((Integer) this.qTe.get(str)).intValue() + 1 : 1));
        if (z) {
            this.qTg.add(str);
        }
        AppMethodBeat.o(36884);
    }

    public final void gh(String str, String str2) {
        AppMethodBeat.i(36885);
        if (this.eFs == 0 || bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            AppMethodBeat.o(36885);
            return;
        }
        this.qTf.put(str, str2);
        AppMethodBeat.o(36885);
    }

    private void coF() {
        AppMethodBeat.i(36886);
        this.qTi = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_real_feed_exposure_count_limit_and, 0);
        ab.i("MicroMsg.SnsReportHelper", "resetXExptControl maxFeedIdForCgiRecord[%d]", Integer.valueOf(this.qTi));
        AppMethodBeat.o(36886);
    }

    public final synchronized void kr(long j) {
        AppMethodBeat.i(36887);
        if (this.qTi > 0) {
            this.qTh.put(Long.valueOf(j), qTc);
        }
        AppMethodBeat.o(36887);
    }

    public final synchronized void coG() {
        AppMethodBeat.i(138380);
        if (this.qTi <= 0) {
            AppMethodBeat.o(138380);
        } else {
            final LinkedHashMap linkedHashMap = (LinkedHashMap) this.qTh.clone();
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(36880);
                    long yz = bo.yz();
                    int size = linkedHashMap.size();
                    if (size >= e.this.qTi) {
                        int a = size - e.this.qTi;
                        Iterator it = linkedHashMap.keySet().iterator();
                        int i = 0;
                        while (it.hasNext() && i < a) {
                            it.next();
                            it.remove();
                            i++;
                        }
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(36879);
                                LinkedHashMap b = e.this.qTh;
                                e.this.qTh = linkedHashMap;
                                b.clear();
                                AppMethodBeat.o(36879);
                            }
                        });
                    }
                    e.this.ecO.set(6, linkedHashMap);
                    ab.i("MicroMsg.SnsReportHelper", "save exposure feed id for cgi [%d] oriSize[%d] cost[%d]", Integer.valueOf(linkedHashMap.size()), Integer.valueOf(size), Long.valueOf(bo.az(yz)));
                    AppMethodBeat.o(36880);
                }
            }, "save_exposure_feed");
            AppMethodBeat.o(138380);
        }
    }

    public final synchronized LinkedList<Long> coH() {
        LinkedList<Long> linkedList;
        AppMethodBeat.i(138381);
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.qTh.clone();
        if (linkedHashMap.size() <= 0 || this.qTi <= 0) {
            linkedList = null;
            AppMethodBeat.o(138381);
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
            AppMethodBeat.o(138381);
            linkedList = linkedList2;
        }
        return linkedList;
    }
}
