package a.i.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class v<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private List<b> BAA;
    private Map<K, V> BAB;
    private volatile d BAC;
    private final int BAz;
    boolean BzD;

    class d extends AbstractSet<Entry<K, V>> {
        private d() {
        }

        /* synthetic */ d(v vVar, byte b) {
            this();
        }

        public final /* synthetic */ boolean add(Object obj) {
            AppMethodBeat.i(121642);
            Entry entry = (Entry) obj;
            if (contains(entry)) {
                AppMethodBeat.o(121642);
                return false;
            }
            v.this.a((Comparable) entry.getKey(), entry.getValue());
            AppMethodBeat.o(121642);
            return true;
        }

        public final Iterator<Entry<K, V>> iterator() {
            AppMethodBeat.i(121637);
            c cVar = new c(v.this, (byte) 0);
            AppMethodBeat.o(121637);
            return cVar;
        }

        public final int size() {
            AppMethodBeat.i(121638);
            int size = v.this.size();
            AppMethodBeat.o(121638);
            return size;
        }

        public final boolean contains(Object obj) {
            AppMethodBeat.i(121639);
            Entry entry = (Entry) obj;
            Object obj2 = v.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 == value || (obj2 != null && obj2.equals(value))) {
                AppMethodBeat.o(121639);
                return true;
            }
            AppMethodBeat.o(121639);
            return false;
        }

        public final boolean remove(Object obj) {
            AppMethodBeat.i(121640);
            Entry entry = (Entry) obj;
            if (contains(entry)) {
                v.this.remove(entry.getKey());
                AppMethodBeat.o(121640);
                return true;
            }
            AppMethodBeat.o(121640);
            return false;
        }

        public final void clear() {
            AppMethodBeat.i(121641);
            v.this.clear();
            AppMethodBeat.o(121641);
        }
    }

    static class a {
        private static final Iterator<Object> BAD = new Iterator<Object>() {
            public final boolean hasNext() {
                return false;
            }

            public final Object next() {
                AppMethodBeat.i(121622);
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                AppMethodBeat.o(121622);
                throw noSuchElementException;
            }

            public final void remove() {
                AppMethodBeat.i(121623);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(121623);
                throw unsupportedOperationException;
            }
        };
        private static final Iterable<Object> BAE = new Iterable<Object>() {
            public final Iterator<Object> iterator() {
                AppMethodBeat.i(121624);
                Iterator eiL = a.BAD;
                AppMethodBeat.o(121624);
                return eiL;
            }
        };

        static {
            AppMethodBeat.i(121625);
            AppMethodBeat.o(121625);
        }

        static <T> Iterable<T> eiK() {
            return BAE;
        }
    }

    class b implements Comparable<b>, Entry<K, V> {
        final K BAF;
        private V value;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            AppMethodBeat.i(121632);
            int compareTo = this.BAF.compareTo(((b) obj).BAF);
            AppMethodBeat.o(121632);
            return compareTo;
        }

        b(v vVar, Entry<K, V> entry) {
            this((Comparable) entry.getKey(), entry.getValue());
            AppMethodBeat.i(121626);
            AppMethodBeat.o(121626);
        }

        b(K k, V v) {
            this.BAF = k;
            this.value = v;
        }

        public final V getValue() {
            return this.value;
        }

        public final V setValue(V v) {
            AppMethodBeat.i(121627);
            v.a(v.this);
            Object obj = this.value;
            this.value = v;
            AppMethodBeat.o(121627);
            return obj;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(121628);
            if (obj == this) {
                AppMethodBeat.o(121628);
                return true;
            } else if (obj instanceof Entry) {
                Entry entry = (Entry) obj;
                if (equals(this.BAF, entry.getKey()) && equals(this.value, entry.getValue())) {
                    AppMethodBeat.o(121628);
                    return true;
                }
                AppMethodBeat.o(121628);
                return false;
            } else {
                AppMethodBeat.o(121628);
                return false;
            }
        }

        public final int hashCode() {
            int i = 0;
            AppMethodBeat.i(121629);
            int hashCode = this.BAF == null ? 0 : this.BAF.hashCode();
            if (this.value != null) {
                i = this.value.hashCode();
            }
            hashCode ^= i;
            AppMethodBeat.o(121629);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(121630);
            String valueOf = String.valueOf(String.valueOf(this.BAF));
            String valueOf2 = String.valueOf(String.valueOf(this.value));
            valueOf = new StringBuilder((valueOf.length() + 1) + valueOf2.length()).append(valueOf).append("=").append(valueOf2).toString();
            AppMethodBeat.o(121630);
            return valueOf;
        }

        private static boolean equals(Object obj, Object obj2) {
            AppMethodBeat.i(121631);
            if (obj != null) {
                boolean equals = obj.equals(obj2);
                AppMethodBeat.o(121631);
                return equals;
            } else if (obj2 == null) {
                AppMethodBeat.o(121631);
                return true;
            } else {
                AppMethodBeat.o(121631);
                return false;
            }
        }

        public final /* bridge */ /* synthetic */ Object getKey() {
            return this.BAF;
        }
    }

    class c implements Iterator<Entry<K, V>> {
        private boolean BAH;
        private Iterator<Entry<K, V>> BAI;
        private int pos;

        private c() {
            this.pos = -1;
        }

        /* synthetic */ c(v vVar, byte b) {
            this();
        }

        public final boolean hasNext() {
            AppMethodBeat.i(121633);
            if (this.pos + 1 < v.this.BAA.size() || eiM().hasNext()) {
                AppMethodBeat.o(121633);
                return true;
            }
            AppMethodBeat.o(121633);
            return false;
        }

        public final void remove() {
            AppMethodBeat.i(121634);
            if (this.BAH) {
                this.BAH = false;
                v.a(v.this);
                if (this.pos < v.this.BAA.size()) {
                    v vVar = v.this;
                    int i = this.pos;
                    this.pos = i - 1;
                    v.a(vVar, i);
                    AppMethodBeat.o(121634);
                    return;
                }
                eiM().remove();
                AppMethodBeat.o(121634);
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("remove() was called before next()");
            AppMethodBeat.o(121634);
            throw illegalStateException;
        }

        private Iterator<Entry<K, V>> eiM() {
            AppMethodBeat.i(121635);
            if (this.BAI == null) {
                this.BAI = v.this.BAB.entrySet().iterator();
            }
            Iterator it = this.BAI;
            AppMethodBeat.o(121635);
            return it;
        }

        public final /* synthetic */ Object next() {
            AppMethodBeat.i(121636);
            this.BAH = true;
            int i = this.pos + 1;
            this.pos = i;
            Entry entry;
            if (i < v.this.BAA.size()) {
                entry = (Entry) v.this.BAA.get(this.pos);
                AppMethodBeat.o(121636);
                return entry;
            }
            entry = (Entry) eiM().next();
            AppMethodBeat.o(121636);
            return entry;
        }
    }

    /* synthetic */ v(int i, byte b) {
        this(i);
    }

    static /* synthetic */ void a(v vVar) {
        AppMethodBeat.i(121662);
        vVar.eiH();
        AppMethodBeat.o(121662);
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        AppMethodBeat.i(121661);
        Object a = a((Comparable) obj, obj2);
        AppMethodBeat.o(121661);
        return a;
    }

    static <FieldDescriptorType extends a.i.b.a.c.g.h.a<FieldDescriptorType>> v<FieldDescriptorType, Object> UE(int i) {
        AppMethodBeat.i(121643);
        AnonymousClass1 anonymousClass1 = new v<FieldDescriptorType, Object>(i) {
            public final /* synthetic */ Object put(Object obj, Object obj2) {
                AppMethodBeat.i(121621);
                Object a = super.a((a.i.b.a.c.g.h.a) obj, obj2);
                AppMethodBeat.o(121621);
                return a;
            }

            public final void eii() {
                AppMethodBeat.i(121620);
                if (!this.BzD) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= eiF()) {
                            break;
                        }
                        Entry UF = UF(i2);
                        if (((a.i.b.a.c.g.h.a) UF.getKey()).eim()) {
                            UF.setValue(Collections.unmodifiableList((List) UF.getValue()));
                        }
                        i = i2 + 1;
                    }
                    for (Entry entry : eiG()) {
                        if (((a.i.b.a.c.g.h.a) entry.getKey()).eim()) {
                            entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                        }
                    }
                }
                super.eii();
                AppMethodBeat.o(121620);
            }
        };
        AppMethodBeat.o(121643);
        return anonymousClass1;
    }

    private v(int i) {
        AppMethodBeat.i(121644);
        this.BAz = i;
        this.BAA = Collections.emptyList();
        this.BAB = Collections.emptyMap();
        AppMethodBeat.o(121644);
    }

    public void eii() {
        AppMethodBeat.i(121645);
        if (!this.BzD) {
            this.BAB = this.BAB.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.BAB);
            this.BzD = true;
        }
        AppMethodBeat.o(121645);
    }

    public final int eiF() {
        AppMethodBeat.i(121646);
        int size = this.BAA.size();
        AppMethodBeat.o(121646);
        return size;
    }

    public final Entry<K, V> UF(int i) {
        AppMethodBeat.i(121647);
        Entry entry = (Entry) this.BAA.get(i);
        AppMethodBeat.o(121647);
        return entry;
    }

    public final Iterable<Entry<K, V>> eiG() {
        AppMethodBeat.i(121648);
        if (this.BAB.isEmpty()) {
            Iterable eiK = a.eiK();
            AppMethodBeat.o(121648);
            return eiK;
        }
        Iterable<Entry<K, V>> entrySet = this.BAB.entrySet();
        AppMethodBeat.o(121648);
        return entrySet;
    }

    public int size() {
        AppMethodBeat.i(121649);
        int size = this.BAA.size() + this.BAB.size();
        AppMethodBeat.o(121649);
        return size;
    }

    public boolean containsKey(Object obj) {
        AppMethodBeat.i(121650);
        Comparable comparable = (Comparable) obj;
        if (f(comparable) >= 0 || this.BAB.containsKey(comparable)) {
            AppMethodBeat.o(121650);
            return true;
        }
        AppMethodBeat.o(121650);
        return false;
    }

    public V get(Object obj) {
        AppMethodBeat.i(121651);
        Comparable comparable = (Comparable) obj;
        int f = f(comparable);
        if (f >= 0) {
            Object value = ((b) this.BAA.get(f)).getValue();
            AppMethodBeat.o(121651);
            return value;
        }
        V v = this.BAB.get(comparable);
        AppMethodBeat.o(121651);
        return v;
    }

    public final V a(K k, V v) {
        AppMethodBeat.i(121652);
        eiH();
        int f = f(k);
        if (f >= 0) {
            Object value = ((b) this.BAA.get(f)).setValue(v);
            AppMethodBeat.o(121652);
            return value;
        }
        eiJ();
        int i = -(f + 1);
        if (i >= this.BAz) {
            V put = eiI().put(k, v);
            AppMethodBeat.o(121652);
            return put;
        }
        if (this.BAA.size() == this.BAz) {
            b bVar = (b) this.BAA.remove(this.BAz - 1);
            eiI().put(bVar.BAF, bVar.getValue());
        }
        this.BAA.add(i, new b(k, v));
        AppMethodBeat.o(121652);
        return null;
    }

    public void clear() {
        AppMethodBeat.i(121653);
        eiH();
        if (!this.BAA.isEmpty()) {
            this.BAA.clear();
        }
        if (!this.BAB.isEmpty()) {
            this.BAB.clear();
        }
        AppMethodBeat.o(121653);
    }

    public V remove(Object obj) {
        AppMethodBeat.i(121654);
        eiH();
        Comparable comparable = (Comparable) obj;
        int f = f(comparable);
        if (f >= 0) {
            Object UG = UG(f);
            AppMethodBeat.o(121654);
            return UG;
        } else if (this.BAB.isEmpty()) {
            AppMethodBeat.o(121654);
            return null;
        } else {
            V remove = this.BAB.remove(comparable);
            AppMethodBeat.o(121654);
            return remove;
        }
    }

    private V UG(int i) {
        AppMethodBeat.i(121655);
        eiH();
        Object value = ((b) this.BAA.remove(i)).getValue();
        if (!this.BAB.isEmpty()) {
            Iterator it = eiI().entrySet().iterator();
            this.BAA.add(new b(this, (Entry) it.next()));
            it.remove();
        }
        AppMethodBeat.o(121655);
        return value;
    }

    private int f(K k) {
        int compareTo;
        AppMethodBeat.i(121656);
        int i = 0;
        int size = this.BAA.size() - 1;
        if (size >= 0) {
            compareTo = k.compareTo(((b) this.BAA.get(size)).BAF);
            if (compareTo > 0) {
                compareTo = -(size + 2);
                AppMethodBeat.o(121656);
                return compareTo;
            } else if (compareTo == 0) {
                AppMethodBeat.o(121656);
                return size;
            }
        }
        int i2 = size;
        while (i <= i2) {
            size = (i + i2) / 2;
            compareTo = k.compareTo(((b) this.BAA.get(size)).BAF);
            if (compareTo < 0) {
                i2 = size - 1;
            } else if (compareTo > 0) {
                i = size + 1;
            } else {
                AppMethodBeat.o(121656);
                return size;
            }
        }
        compareTo = -(i + 1);
        AppMethodBeat.o(121656);
        return compareTo;
    }

    public Set<Entry<K, V>> entrySet() {
        AppMethodBeat.i(121657);
        if (this.BAC == null) {
            this.BAC = new d(this, (byte) 0);
        }
        d dVar = this.BAC;
        AppMethodBeat.o(121657);
        return dVar;
    }

    private void eiH() {
        AppMethodBeat.i(121658);
        if (this.BzD) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(121658);
            throw unsupportedOperationException;
        }
        AppMethodBeat.o(121658);
    }

    private SortedMap<K, V> eiI() {
        AppMethodBeat.i(121659);
        eiH();
        if (this.BAB.isEmpty() && !(this.BAB instanceof TreeMap)) {
            this.BAB = new TreeMap();
        }
        SortedMap sortedMap = (SortedMap) this.BAB;
        AppMethodBeat.o(121659);
        return sortedMap;
    }

    private void eiJ() {
        AppMethodBeat.i(121660);
        eiH();
        if (this.BAA.isEmpty() && !(this.BAA instanceof ArrayList)) {
            this.BAA = new ArrayList(this.BAz);
        }
        AppMethodBeat.o(121660);
    }
}
