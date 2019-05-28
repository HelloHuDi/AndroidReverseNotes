package a.i.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;

public final class l extends m {
    private final q BzZ;

    static class b<K> implements Iterator<Entry<K, Object>> {
        private Iterator<Entry<K, Object>> AUT;

        public b(Iterator<Entry<K, Object>> it) {
            this.AUT = it;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(121542);
            boolean hasNext = this.AUT.hasNext();
            AppMethodBeat.o(121542);
            return hasNext;
        }

        public final void remove() {
            AppMethodBeat.i(121543);
            this.AUT.remove();
            AppMethodBeat.o(121543);
        }

        public final /* synthetic */ Object next() {
            AppMethodBeat.i(121544);
            Entry entry = (Entry) this.AUT.next();
            if (entry.getValue() instanceof l) {
                a aVar = new a(entry, (byte) 0);
                AppMethodBeat.o(121544);
                return aVar;
            }
            AppMethodBeat.o(121544);
            return entry;
        }
    }

    static class a<K> implements Entry<K, Object> {
        private Entry<K, l> BAa;

        /* synthetic */ a(Entry entry, byte b) {
            this(entry);
        }

        private a(Entry<K, l> entry) {
            this.BAa = entry;
        }

        public final K getKey() {
            AppMethodBeat.i(121539);
            Object key = this.BAa.getKey();
            AppMethodBeat.o(121539);
            return key;
        }

        public final Object getValue() {
            AppMethodBeat.i(121540);
            l lVar = (l) this.BAa.getValue();
            if (lVar == null) {
                AppMethodBeat.o(121540);
                return null;
            }
            Object eiy = lVar.eiy();
            AppMethodBeat.o(121540);
            return eiy;
        }

        public final Object setValue(Object obj) {
            AppMethodBeat.i(121541);
            if (obj instanceof q) {
                q e = ((l) this.BAa.getValue()).e((q) obj);
                AppMethodBeat.o(121541);
                return e;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
            AppMethodBeat.o(121541);
            throw illegalArgumentException;
        }
    }

    public final q eiy() {
        AppMethodBeat.i(121545);
        q d = d(this.BzZ);
        AppMethodBeat.o(121545);
        return d;
    }

    public final int hashCode() {
        AppMethodBeat.i(121546);
        int hashCode = eiy().hashCode();
        AppMethodBeat.o(121546);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(121547);
        boolean equals = eiy().equals(obj);
        AppMethodBeat.o(121547);
        return equals;
    }

    public final String toString() {
        AppMethodBeat.i(121548);
        String obj = eiy().toString();
        AppMethodBeat.o(121548);
        return obj;
    }
}
