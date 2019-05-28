package p000a.p010i.p011b.p012a.p015c.p035g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: a.i.b.a.c.g.l */
public final class C44902l extends C37025m {
    private final C8185q BzZ;

    /* renamed from: a.i.b.a.c.g.l$b */
    static class C8184b<K> implements Iterator<Entry<K, Object>> {
        private Iterator<Entry<K, Object>> AUT;

        public C8184b(Iterator<Entry<K, Object>> it) {
            this.AUT = it;
        }

        public final boolean hasNext() {
            AppMethodBeat.m2504i(121542);
            boolean hasNext = this.AUT.hasNext();
            AppMethodBeat.m2505o(121542);
            return hasNext;
        }

        public final void remove() {
            AppMethodBeat.m2504i(121543);
            this.AUT.remove();
            AppMethodBeat.m2505o(121543);
        }

        public final /* synthetic */ Object next() {
            AppMethodBeat.m2504i(121544);
            Entry entry = (Entry) this.AUT.next();
            if (entry.getValue() instanceof C44902l) {
                C25160a c25160a = new C25160a(entry, (byte) 0);
                AppMethodBeat.m2505o(121544);
                return c25160a;
            }
            AppMethodBeat.m2505o(121544);
            return entry;
        }
    }

    /* renamed from: a.i.b.a.c.g.l$a */
    static class C25160a<K> implements Entry<K, Object> {
        private Entry<K, C44902l> BAa;

        /* synthetic */ C25160a(Entry entry, byte b) {
            this(entry);
        }

        private C25160a(Entry<K, C44902l> entry) {
            this.BAa = entry;
        }

        public final K getKey() {
            AppMethodBeat.m2504i(121539);
            Object key = this.BAa.getKey();
            AppMethodBeat.m2505o(121539);
            return key;
        }

        public final Object getValue() {
            AppMethodBeat.m2504i(121540);
            C44902l c44902l = (C44902l) this.BAa.getValue();
            if (c44902l == null) {
                AppMethodBeat.m2505o(121540);
                return null;
            }
            Object eiy = c44902l.eiy();
            AppMethodBeat.m2505o(121540);
            return eiy;
        }

        public final Object setValue(Object obj) {
            AppMethodBeat.m2504i(121541);
            if (obj instanceof C8185q) {
                C8185q e = ((C44902l) this.BAa.getValue()).mo59065e((C8185q) obj);
                AppMethodBeat.m2505o(121541);
                return e;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
            AppMethodBeat.m2505o(121541);
            throw illegalArgumentException;
        }
    }

    public final C8185q eiy() {
        AppMethodBeat.m2504i(121545);
        C8185q d = mo59064d(this.BzZ);
        AppMethodBeat.m2505o(121545);
        return d;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(121546);
        int hashCode = eiy().hashCode();
        AppMethodBeat.m2505o(121546);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(121547);
        boolean equals = eiy().equals(obj);
        AppMethodBeat.m2505o(121547);
        return equals;
    }

    public final String toString() {
        AppMethodBeat.m2504i(121548);
        String obj = eiy().toString();
        AppMethodBeat.m2505o(121548);
        return obj;
    }
}
