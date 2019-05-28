package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class al<K, O> {
    private int maxSize;
    Map<K, b<O>> qMs = null;
    private a qMt = null;

    public class b<OO> {
        public OO obj;
        public Long qMv;

        public b(OO oo) {
            AppMethodBeat.i(36567);
            this.obj = oo;
            cob();
            AppMethodBeat.o(36567);
        }

        public final void cob() {
            AppMethodBeat.i(36568);
            this.qMv = Long.valueOf(System.currentTimeMillis());
            AppMethodBeat.o(36568);
        }
    }

    public interface a {
        boolean cn(Object obj);
    }

    public al(int i, a aVar) {
        AppMethodBeat.i(36569);
        this.maxSize = i;
        this.qMs = new HashMap();
        this.qMt = aVar;
        AppMethodBeat.o(36569);
    }

    public final void coa() {
        AppMethodBeat.i(36570);
        if (this.qMs.size() > this.maxSize) {
            ArrayList arrayList = new ArrayList(this.qMs.entrySet());
            Collections.sort(arrayList, new Comparator<Entry<K, b<O>>>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    AppMethodBeat.i(36566);
                    int compareTo = ((b) ((Entry) obj).getValue()).qMv.compareTo(((b) ((Entry) obj2).getValue()).qMv);
                    AppMethodBeat.o(36566);
                    return compareTo;
                }
            });
            int size = this.qMs.size() - this.maxSize;
            if (size > 0) {
                Iterator it = arrayList.iterator();
                while (true) {
                    int i = size;
                    if (!it.hasNext()) {
                        break;
                    }
                    Entry entry = (Entry) it.next();
                    if (this.qMt.cn(entry.getKey())) {
                        ab.d("MicroMsg.SnsLRUMap", " remove targetKey: " + entry.getKey());
                        size = i - 1;
                    } else {
                        size = i;
                    }
                    if (size <= 0) {
                        break;
                    }
                }
            } else {
                AppMethodBeat.o(36570);
                return;
            }
        }
        AppMethodBeat.o(36570);
    }
}
