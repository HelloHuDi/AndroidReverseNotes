package p000a.p010i.p011b.p012a.p015c.p035g;

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
import p000a.p010i.p011b.p012a.p015c.p035g.C17266h.C17267a;

/* renamed from: a.i.b.a.c.g.v */
class C41428v<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private List<C37029b> BAA;
    private Map<K, V> BAB;
    private volatile C31718d BAC;
    private final int BAz;
    boolean BzD;

    /* renamed from: a.i.b.a.c.g.v$d */
    class C31718d extends AbstractSet<Entry<K, V>> {
        private C31718d() {
        }

        /* synthetic */ C31718d(C41428v c41428v, byte b) {
            this();
        }

        public final /* synthetic */ boolean add(Object obj) {
            AppMethodBeat.m2504i(121642);
            Entry entry = (Entry) obj;
            if (contains(entry)) {
                AppMethodBeat.m2505o(121642);
                return false;
            }
            C41428v.this.mo66068a((Comparable) entry.getKey(), entry.getValue());
            AppMethodBeat.m2505o(121642);
            return true;
        }

        public final Iterator<Entry<K, V>> iterator() {
            AppMethodBeat.m2504i(121637);
            C37030c c37030c = new C37030c(C41428v.this, (byte) 0);
            AppMethodBeat.m2505o(121637);
            return c37030c;
        }

        public final int size() {
            AppMethodBeat.m2504i(121638);
            int size = C41428v.this.size();
            AppMethodBeat.m2505o(121638);
            return size;
        }

        public final boolean contains(Object obj) {
            AppMethodBeat.m2504i(121639);
            Entry entry = (Entry) obj;
            Object obj2 = C41428v.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 == value || (obj2 != null && obj2.equals(value))) {
                AppMethodBeat.m2505o(121639);
                return true;
            }
            AppMethodBeat.m2505o(121639);
            return false;
        }

        public final boolean remove(Object obj) {
            AppMethodBeat.m2504i(121640);
            Entry entry = (Entry) obj;
            if (contains(entry)) {
                C41428v.this.remove(entry.getKey());
                AppMethodBeat.m2505o(121640);
                return true;
            }
            AppMethodBeat.m2505o(121640);
            return false;
        }

        public final void clear() {
            AppMethodBeat.m2504i(121641);
            C41428v.this.clear();
            AppMethodBeat.m2505o(121641);
        }
    }

    /* renamed from: a.i.b.a.c.g.v$a */
    static class C37027a {
        private static final Iterator<Object> BAD = new C370281();
        private static final Iterable<Object> BAE = new C81882();

        /* renamed from: a.i.b.a.c.g.v$a$2 */
        static class C81882 implements Iterable<Object> {
            C81882() {
            }

            public final Iterator<Object> iterator() {
                AppMethodBeat.m2504i(121624);
                Iterator eiL = C37027a.BAD;
                AppMethodBeat.m2505o(121624);
                return eiL;
            }
        }

        /* renamed from: a.i.b.a.c.g.v$a$1 */
        static class C370281 implements Iterator<Object> {
            C370281() {
            }

            public final boolean hasNext() {
                return false;
            }

            public final Object next() {
                AppMethodBeat.m2504i(121622);
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                AppMethodBeat.m2505o(121622);
                throw noSuchElementException;
            }

            public final void remove() {
                AppMethodBeat.m2504i(121623);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.m2505o(121623);
                throw unsupportedOperationException;
            }
        }

        static {
            AppMethodBeat.m2504i(121625);
            AppMethodBeat.m2505o(121625);
        }

        static <T> Iterable<T> eiK() {
            return BAE;
        }
    }

    /* renamed from: a.i.b.a.c.g.v$b */
    class C37029b implements Comparable<C37029b>, Entry<K, V> {
        final K BAF;
        private V value;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            AppMethodBeat.m2504i(121632);
            int compareTo = this.BAF.compareTo(((C37029b) obj).BAF);
            AppMethodBeat.m2505o(121632);
            return compareTo;
        }

        C37029b(C41428v c41428v, Entry<K, V> entry) {
            this((Comparable) entry.getKey(), entry.getValue());
            AppMethodBeat.m2504i(121626);
            AppMethodBeat.m2505o(121626);
        }

        C37029b(K k, V v) {
            this.BAF = k;
            this.value = v;
        }

        public final V getValue() {
            return this.value;
        }

        public final V setValue(V v) {
            AppMethodBeat.m2504i(121627);
            C41428v.m72262a(C41428v.this);
            Object obj = this.value;
            this.value = v;
            AppMethodBeat.m2505o(121627);
            return obj;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(121628);
            if (obj == this) {
                AppMethodBeat.m2505o(121628);
                return true;
            } else if (obj instanceof Entry) {
                Entry entry = (Entry) obj;
                if (C37029b.equals(this.BAF, entry.getKey()) && C37029b.equals(this.value, entry.getValue())) {
                    AppMethodBeat.m2505o(121628);
                    return true;
                }
                AppMethodBeat.m2505o(121628);
                return false;
            } else {
                AppMethodBeat.m2505o(121628);
                return false;
            }
        }

        public final int hashCode() {
            int i = 0;
            AppMethodBeat.m2504i(121629);
            int hashCode = this.BAF == null ? 0 : this.BAF.hashCode();
            if (this.value != null) {
                i = this.value.hashCode();
            }
            hashCode ^= i;
            AppMethodBeat.m2505o(121629);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.m2504i(121630);
            String valueOf = String.valueOf(String.valueOf(this.BAF));
            String valueOf2 = String.valueOf(String.valueOf(this.value));
            valueOf = new StringBuilder((valueOf.length() + 1) + valueOf2.length()).append(valueOf).append("=").append(valueOf2).toString();
            AppMethodBeat.m2505o(121630);
            return valueOf;
        }

        private static boolean equals(Object obj, Object obj2) {
            AppMethodBeat.m2504i(121631);
            if (obj != null) {
                boolean equals = obj.equals(obj2);
                AppMethodBeat.m2505o(121631);
                return equals;
            } else if (obj2 == null) {
                AppMethodBeat.m2505o(121631);
                return true;
            } else {
                AppMethodBeat.m2505o(121631);
                return false;
            }
        }

        public final /* bridge */ /* synthetic */ Object getKey() {
            return this.BAF;
        }
    }

    /* renamed from: a.i.b.a.c.g.v$c */
    class C37030c implements Iterator<Entry<K, V>> {
        private boolean BAH;
        private Iterator<Entry<K, V>> BAI;
        private int pos;

        private C37030c() {
            this.pos = -1;
        }

        /* synthetic */ C37030c(C41428v c41428v, byte b) {
            this();
        }

        public final boolean hasNext() {
            AppMethodBeat.m2504i(121633);
            if (this.pos + 1 < C41428v.this.BAA.size() || eiM().hasNext()) {
                AppMethodBeat.m2505o(121633);
                return true;
            }
            AppMethodBeat.m2505o(121633);
            return false;
        }

        public final void remove() {
            AppMethodBeat.m2504i(121634);
            if (this.BAH) {
                this.BAH = false;
                C41428v.m72262a(C41428v.this);
                if (this.pos < C41428v.this.BAA.size()) {
                    C41428v c41428v = C41428v.this;
                    int i = this.pos;
                    this.pos = i - 1;
                    C41428v.m72261a(c41428v, i);
                    AppMethodBeat.m2505o(121634);
                    return;
                }
                eiM().remove();
                AppMethodBeat.m2505o(121634);
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("remove() was called before next()");
            AppMethodBeat.m2505o(121634);
            throw illegalStateException;
        }

        private Iterator<Entry<K, V>> eiM() {
            AppMethodBeat.m2504i(121635);
            if (this.BAI == null) {
                this.BAI = C41428v.this.BAB.entrySet().iterator();
            }
            Iterator it = this.BAI;
            AppMethodBeat.m2505o(121635);
            return it;
        }

        public final /* synthetic */ Object next() {
            AppMethodBeat.m2504i(121636);
            this.BAH = true;
            int i = this.pos + 1;
            this.pos = i;
            Entry entry;
            if (i < C41428v.this.BAA.size()) {
                entry = (Entry) C41428v.this.BAA.get(this.pos);
                AppMethodBeat.m2505o(121636);
                return entry;
            }
            entry = (Entry) eiM().next();
            AppMethodBeat.m2505o(121636);
            return entry;
        }
    }

    /* synthetic */ C41428v(int i, byte b) {
        this(i);
    }

    /* renamed from: a */
    static /* synthetic */ void m72262a(C41428v c41428v) {
        AppMethodBeat.m2504i(121662);
        c41428v.eiH();
        AppMethodBeat.m2505o(121662);
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        AppMethodBeat.m2504i(121661);
        Object a = mo66068a((Comparable) obj, obj2);
        AppMethodBeat.m2505o(121661);
        return a;
    }

    /* renamed from: UE */
    static <FieldDescriptorType extends C17267a<FieldDescriptorType>> C41428v<FieldDescriptorType, Object> m72259UE(int i) {
        AppMethodBeat.m2504i(121643);
        C414291 c414291 = new C41428v<FieldDescriptorType, Object>(i) {
            public final /* synthetic */ Object put(Object obj, Object obj2) {
                AppMethodBeat.m2504i(121621);
                Object a = super.mo66068a((C17267a) obj, obj2);
                AppMethodBeat.m2505o(121621);
                return a;
            }

            public final void eii() {
                AppMethodBeat.m2504i(121620);
                if (!this.BzD) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= eiF()) {
                            break;
                        }
                        Entry UF = mo66067UF(i2);
                        if (((C17267a) UF.getKey()).eim()) {
                            UF.setValue(Collections.unmodifiableList((List) UF.getValue()));
                        }
                        i = i2 + 1;
                    }
                    for (Entry entry : eiG()) {
                        if (((C17267a) entry.getKey()).eim()) {
                            entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                        }
                    }
                }
                super.eii();
                AppMethodBeat.m2505o(121620);
            }
        };
        AppMethodBeat.m2505o(121643);
        return c414291;
    }

    private C41428v(int i) {
        AppMethodBeat.m2504i(121644);
        this.BAz = i;
        this.BAA = Collections.emptyList();
        this.BAB = Collections.emptyMap();
        AppMethodBeat.m2505o(121644);
    }

    public void eii() {
        AppMethodBeat.m2504i(121645);
        if (!this.BzD) {
            this.BAB = this.BAB.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.BAB);
            this.BzD = true;
        }
        AppMethodBeat.m2505o(121645);
    }

    public final int eiF() {
        AppMethodBeat.m2504i(121646);
        int size = this.BAA.size();
        AppMethodBeat.m2505o(121646);
        return size;
    }

    /* renamed from: UF */
    public final Entry<K, V> mo66067UF(int i) {
        AppMethodBeat.m2504i(121647);
        Entry entry = (Entry) this.BAA.get(i);
        AppMethodBeat.m2505o(121647);
        return entry;
    }

    public final Iterable<Entry<K, V>> eiG() {
        AppMethodBeat.m2504i(121648);
        if (this.BAB.isEmpty()) {
            Iterable eiK = C37027a.eiK();
            AppMethodBeat.m2505o(121648);
            return eiK;
        }
        Iterable<Entry<K, V>> entrySet = this.BAB.entrySet();
        AppMethodBeat.m2505o(121648);
        return entrySet;
    }

    public int size() {
        AppMethodBeat.m2504i(121649);
        int size = this.BAA.size() + this.BAB.size();
        AppMethodBeat.m2505o(121649);
        return size;
    }

    public boolean containsKey(Object obj) {
        AppMethodBeat.m2504i(121650);
        Comparable comparable = (Comparable) obj;
        if (m72265f(comparable) >= 0 || this.BAB.containsKey(comparable)) {
            AppMethodBeat.m2505o(121650);
            return true;
        }
        AppMethodBeat.m2505o(121650);
        return false;
    }

    public V get(Object obj) {
        AppMethodBeat.m2504i(121651);
        Comparable comparable = (Comparable) obj;
        int f = m72265f(comparable);
        if (f >= 0) {
            Object value = ((C37029b) this.BAA.get(f)).getValue();
            AppMethodBeat.m2505o(121651);
            return value;
        }
        V v = this.BAB.get(comparable);
        AppMethodBeat.m2505o(121651);
        return v;
    }

    /* renamed from: a */
    public final V mo66068a(K k, V v) {
        AppMethodBeat.m2504i(121652);
        eiH();
        int f = m72265f(k);
        if (f >= 0) {
            Object value = ((C37029b) this.BAA.get(f)).setValue(v);
            AppMethodBeat.m2505o(121652);
            return value;
        }
        eiJ();
        int i = -(f + 1);
        if (i >= this.BAz) {
            V put = eiI().put(k, v);
            AppMethodBeat.m2505o(121652);
            return put;
        }
        if (this.BAA.size() == this.BAz) {
            C37029b c37029b = (C37029b) this.BAA.remove(this.BAz - 1);
            eiI().put(c37029b.BAF, c37029b.getValue());
        }
        this.BAA.add(i, new C37029b(k, v));
        AppMethodBeat.m2505o(121652);
        return null;
    }

    public void clear() {
        AppMethodBeat.m2504i(121653);
        eiH();
        if (!this.BAA.isEmpty()) {
            this.BAA.clear();
        }
        if (!this.BAB.isEmpty()) {
            this.BAB.clear();
        }
        AppMethodBeat.m2505o(121653);
    }

    public V remove(Object obj) {
        AppMethodBeat.m2504i(121654);
        eiH();
        Comparable comparable = (Comparable) obj;
        int f = m72265f(comparable);
        if (f >= 0) {
            Object UG = m72260UG(f);
            AppMethodBeat.m2505o(121654);
            return UG;
        } else if (this.BAB.isEmpty()) {
            AppMethodBeat.m2505o(121654);
            return null;
        } else {
            V remove = this.BAB.remove(comparable);
            AppMethodBeat.m2505o(121654);
            return remove;
        }
    }

    /* renamed from: UG */
    private V m72260UG(int i) {
        AppMethodBeat.m2504i(121655);
        eiH();
        Object value = ((C37029b) this.BAA.remove(i)).getValue();
        if (!this.BAB.isEmpty()) {
            Iterator it = eiI().entrySet().iterator();
            this.BAA.add(new C37029b(this, (Entry) it.next()));
            it.remove();
        }
        AppMethodBeat.m2505o(121655);
        return value;
    }

    /* renamed from: f */
    private int m72265f(K k) {
        int compareTo;
        AppMethodBeat.m2504i(121656);
        int i = 0;
        int size = this.BAA.size() - 1;
        if (size >= 0) {
            compareTo = k.compareTo(((C37029b) this.BAA.get(size)).BAF);
            if (compareTo > 0) {
                compareTo = -(size + 2);
                AppMethodBeat.m2505o(121656);
                return compareTo;
            } else if (compareTo == 0) {
                AppMethodBeat.m2505o(121656);
                return size;
            }
        }
        int i2 = size;
        while (i <= i2) {
            size = (i + i2) / 2;
            compareTo = k.compareTo(((C37029b) this.BAA.get(size)).BAF);
            if (compareTo < 0) {
                i2 = size - 1;
            } else if (compareTo > 0) {
                i = size + 1;
            } else {
                AppMethodBeat.m2505o(121656);
                return size;
            }
        }
        compareTo = -(i + 1);
        AppMethodBeat.m2505o(121656);
        return compareTo;
    }

    public Set<Entry<K, V>> entrySet() {
        AppMethodBeat.m2504i(121657);
        if (this.BAC == null) {
            this.BAC = new C31718d(this, (byte) 0);
        }
        C31718d c31718d = this.BAC;
        AppMethodBeat.m2505o(121657);
        return c31718d;
    }

    private void eiH() {
        AppMethodBeat.m2504i(121658);
        if (this.BzD) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(121658);
            throw unsupportedOperationException;
        }
        AppMethodBeat.m2505o(121658);
    }

    private SortedMap<K, V> eiI() {
        AppMethodBeat.m2504i(121659);
        eiH();
        if (this.BAB.isEmpty() && !(this.BAB instanceof TreeMap)) {
            this.BAB = new TreeMap();
        }
        SortedMap sortedMap = (SortedMap) this.BAB;
        AppMethodBeat.m2505o(121659);
        return sortedMap;
    }

    private void eiJ() {
        AppMethodBeat.m2504i(121660);
        eiH();
        if (this.BAA.isEmpty() && !(this.BAA instanceof ArrayList)) {
            this.BAA = new ArrayList(this.BAz);
        }
        AppMethodBeat.m2505o(121660);
    }
}
