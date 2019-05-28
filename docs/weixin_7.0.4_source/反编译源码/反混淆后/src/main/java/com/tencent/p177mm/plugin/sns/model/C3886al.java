package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.sns.model.al */
public final class C3886al<K, O> {
    private int maxSize;
    Map<K, C3885b<O>> qMs = null;
    private C3888a qMt = null;

    /* renamed from: com.tencent.mm.plugin.sns.model.al$b */
    public class C3885b<OO> {
        public OO obj;
        public Long qMv;

        public C3885b(OO oo) {
            AppMethodBeat.m2504i(36567);
            this.obj = oo;
            cob();
            AppMethodBeat.m2505o(36567);
        }

        public final void cob() {
            AppMethodBeat.m2504i(36568);
            this.qMv = Long.valueOf(System.currentTimeMillis());
            AppMethodBeat.m2505o(36568);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.al$1 */
    class C38871 implements Comparator<Entry<K, C3885b<O>>> {
        C38871() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(36566);
            int compareTo = ((C3885b) ((Entry) obj).getValue()).qMv.compareTo(((C3885b) ((Entry) obj2).getValue()).qMv);
            AppMethodBeat.m2505o(36566);
            return compareTo;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.al$a */
    public interface C3888a {
        /* renamed from: cn */
        boolean mo8612cn(Object obj);
    }

    public C3886al(int i, C3888a c3888a) {
        AppMethodBeat.m2504i(36569);
        this.maxSize = i;
        this.qMs = new HashMap();
        this.qMt = c3888a;
        AppMethodBeat.m2505o(36569);
    }

    public final void coa() {
        AppMethodBeat.m2504i(36570);
        if (this.qMs.size() > this.maxSize) {
            ArrayList arrayList = new ArrayList(this.qMs.entrySet());
            Collections.sort(arrayList, new C38871());
            int size = this.qMs.size() - this.maxSize;
            if (size > 0) {
                Iterator it = arrayList.iterator();
                while (true) {
                    int i = size;
                    if (!it.hasNext()) {
                        break;
                    }
                    Entry entry = (Entry) it.next();
                    if (this.qMt.mo8612cn(entry.getKey())) {
                        C4990ab.m7410d("MicroMsg.SnsLRUMap", " remove targetKey: " + entry.getKey());
                        size = i - 1;
                    } else {
                        size = i;
                    }
                    if (size <= 0) {
                        break;
                    }
                }
            } else {
                AppMethodBeat.m2505o(36570);
                return;
            }
        }
        AppMethodBeat.m2505o(36570);
    }
}
