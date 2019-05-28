package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C31214a;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b.C8063a;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C41396ak;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.C44877n;
import p000a.p010i.p011b.p012a.p015c.p018b.C44879w;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a.C8037a;
import p000a.p010i.p011b.p012a.p015c.p018b.C8051ay;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t.C8084a;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C36952i;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.p040a.C0129b;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C25227au;
import p000a.p010i.p011b.p012a.p015c.p045l.C41454k;
import p000a.p010i.p011b.p012a.p015c.p045l.C44922as;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p048n.C37067h;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.b.c.p */
public abstract class C36961p extends C17168k implements C8083t {
    public List<C36955ar> BeK;
    public List<C41399au> BhM;
    public C46867w BhN;
    private C41396ak BhO;
    protected C41396ak BhP;
    public C25082az BhQ = C8051ay.Bfe;
    public boolean BhR = false;
    public boolean BhS = false;
    public boolean BhT = false;
    public boolean BhU = false;
    public boolean BhV = false;
    boolean BhW = false;
    boolean BhX = false;
    boolean BhY = false;
    public boolean BhZ = false;
    public boolean Bhu = false;
    protected C44879w Bhv;
    private boolean Bia = true;
    private boolean Bib = false;
    private Collection<? extends C8083t> Bic = null;
    private volatile C31214a<Collection<C8083t>> Bid = null;
    private final C8083t Bie;
    protected final C8063a Bif;
    private C8083t Big = null;
    protected Map<C8037a<?>, Object> Bih = null;

    /* renamed from: a.i.b.a.c.b.c.p$a */
    public class C24612a implements C8084a<C8083t> {
        protected C37022f BgZ;
        protected C41396ak BhP = this.Bij.BhP;
        boolean BhX = this.Bij.BhX;
        boolean BhY = this.Bij.BhY;
        protected C8083t Bie = null;
        protected C8063a Bif;
        Map<C8037a<?>, Object> Bih = new LinkedHashMap();
        final /* synthetic */ C36961p Bij;
        protected C44922as Bik;
        protected C31642l Bil;
        protected C44879w Bim;
        protected C25082az Bin;
        protected List<C41399au> Bio;
        protected C41396ak Bip;
        protected C46867w Biq;
        protected boolean Bir = true;
        protected boolean Bis = false;
        protected boolean Bit = false;
        protected boolean Biu = false;
        List<C36955ar> Biv = null;
        C0026g Biw = null;
        public Boolean Bix = null;
        protected boolean Biy = false;

        public C24612a(C44922as c44922as, C31642l c31642l, C44879w c44879w, C25082az c25082az, C8063a c8063a, List<C41399au> list, C41396ak c41396ak, C46867w c46867w, C37022f c37022f) {
            this.Bij = c44922as;
            AppMethodBeat.m2504i(119460);
            this.Bik = c31642l;
            this.Bil = c44879w;
            this.Bim = c25082az;
            this.Bin = c8063a;
            this.Bif = list;
            this.Bio = c41396ak;
            this.Bip = c46867w;
            this.Biq = c37022f;
            this.BgZ = null;
            AppMethodBeat.m2505o(119460);
        }

        /* renamed from: fT */
        public final C24612a mo41455fT(List<C41399au> list) {
            this.Bio = list;
            return this;
        }

        /* renamed from: h */
        public final C24612a mo41456h(C25085b c25085b) {
            this.Bie = (C8083t) c25085b;
            return this;
        }

        public final C8083t dZC() {
            AppMethodBeat.m2504i(119461);
            C8083t a = this.Bij.mo58964a(this);
            AppMethodBeat.m2505o(119461);
            return a;
        }

        public final C24612a eax() {
            this.Biy = true;
            return this;
        }

        public final /* bridge */ /* synthetic */ C8084a dZB() {
            this.BhY = true;
            return this;
        }

        public final /* bridge */ /* synthetic */ C8084a dZA() {
            this.BhX = true;
            return this;
        }

        public final /* bridge */ /* synthetic */ C8084a dZz() {
            this.Biu = true;
            return this;
        }

        public final /* bridge */ /* synthetic */ C8084a dZy() {
            this.Bit = true;
            return this;
        }

        public final /* bridge */ /* synthetic */ C8084a dZx() {
            this.Bis = true;
            return this;
        }

        /* renamed from: I */
        public final /* bridge */ /* synthetic */ C8084a mo17899I(C46867w c46867w) {
            this.Biq = c46867w;
            return this;
        }

        /* renamed from: fR */
        public final /* bridge */ /* synthetic */ C8084a mo17914fR(List list) {
            this.Bio = list;
            return this;
        }

        /* renamed from: e */
        public final /* bridge */ /* synthetic */ C8084a mo17913e(C37022f c37022f) {
            this.BgZ = c37022f;
            return this;
        }

        /* renamed from: rG */
        public final /* bridge */ /* synthetic */ C8084a mo17916rG(boolean z) {
            this.Bir = z;
            return this;
        }

        /* renamed from: g */
        public final /* bridge */ /* synthetic */ C8084a mo17915g(C31642l c31642l) {
            this.Bil = c31642l;
            return this;
        }
    }

    /* renamed from: a */
    public abstract C36961p mo91a(C31642l c31642l, C8083t c8083t, C8063a c8063a, C37022f c37022f, C0026g c0026g, C41398am c41398am);

    /* renamed from: a */
    public /* synthetic */ C25085b mo17863a(C31642l c31642l, C44879w c44879w, C25082az c25082az, C8063a c8063a) {
        return mo17864b(c31642l, c44879w, c25082az, c8063a, false);
    }

    protected C36961p(C31642l c31642l, C8083t c8083t, C0026g c0026g, C37022f c37022f, C8063a c8063a, C41398am c41398am) {
        super(c31642l, c0026g, c37022f, c41398am);
        if (c8083t == null) {
            c8083t = this;
        }
        this.Bie = c8083t;
        this.Bif = c8063a;
    }

    /* renamed from: a */
    public C36961p mo58963a(C41396ak c41396ak, C41396ak c41396ak2, List<? extends C36955ar> list, List<C41399au> list2, C46867w c46867w, C44879w c44879w, C25082az c25082az) {
        int i = 0;
        this.BeK = C25035t.m39352m(list);
        this.BhM = C25035t.m39352m(list2);
        this.BhN = c46867w;
        this.Bhv = c44879w;
        this.BhQ = c25082az;
        this.BhO = c41396ak;
        this.BhP = c41396ak2;
        for (int i2 = 0; i2 < list.size(); i2++) {
            C36955ar c36955ar = (C36955ar) list.get(i2);
            if (c36955ar.getIndex() != i2) {
                throw new IllegalStateException(c36955ar + " index is " + c36955ar.getIndex() + " but position is " + i2);
            }
        }
        while (i < list2.size()) {
            C41399au c41399au = (C41399au) list2.get(i);
            if (c41399au.getIndex() != i + 0) {
                throw new IllegalStateException(c41399au + "index is " + c41399au.getIndex() + " but position is " + i);
            }
            i++;
        }
        return this;
    }

    /* renamed from: rH */
    public void mo96rH(boolean z) {
        this.Bia = z;
    }

    /* renamed from: rI */
    public void mo97rI(boolean z) {
        this.Bib = z;
    }

    public final C41396ak dYQ() {
        return this.BhO;
    }

    public final C41396ak dYR() {
        return this.BhP;
    }

    public final C44879w dYd() {
        return this.Bhv;
    }

    public final C25082az dYf() {
        return this.BhQ;
    }

    public final boolean dZs() {
        if (this.BhR) {
            return true;
        }
        for (C8083t dZs : ean().dYX()) {
            if (dZs.dZs()) {
                return true;
            }
        }
        return false;
    }

    public final boolean dZt() {
        if (this.BhS) {
            return true;
        }
        for (C8083t dZt : ean().dYX()) {
            if (dZt.dZt()) {
                return true;
            }
        }
        return false;
    }

    public boolean dYm() {
        return this.Bhu;
    }

    public boolean dYj() {
        return this.BhT;
    }

    public boolean dYx() {
        return this.BhU;
    }

    public boolean dZv() {
        return this.BhZ;
    }

    public final boolean dYk() {
        return this.BhV;
    }

    public final boolean dYl() {
        return this.BhW;
    }

    /* renamed from: a */
    public <V> V mo17833a(C8037a<V> c8037a) {
        if (this.Bih == null) {
            return null;
        }
        return this.Bih.get(c8037a);
    }

    public final boolean dZr() {
        return this.BhX;
    }

    /* renamed from: k */
    public void mo41960k(Collection<? extends C25085b> collection) {
        this.Bic = collection;
        for (C8083t dZu : this.Bic) {
            if (dZu.dZu()) {
                this.BhY = true;
                return;
            }
        }
    }

    public final List<C36955ar> dYS() {
        return this.BeK;
    }

    public final List<C41399au> dYV() {
        return this.BhM;
    }

    public boolean eaw() {
        return this.Bia;
    }

    public boolean dYW() {
        return this.Bib;
    }

    public C46867w dYT() {
        return this.BhN;
    }

    /* renamed from: dZp */
    public C8083t ean() {
        return this.Bie == this ? this : this.Bie.dZp();
    }

    public final C8063a dYZ() {
        return this.Bif;
    }

    public final boolean dZu() {
        return this.BhY;
    }

    public C8084a<? extends C8083t> dZw() {
        return mo58966h(C25227au.BJW);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: h */
    public final C24612a mo58966h(C25227au c25227au) {
        return new C24612a(this, c25227au.Bik, dXW(), this.Bhv, this.BhQ, this.Bif, this.BhM, this.BhO, dYT());
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public C8083t mo58964a(C24612a c24612a) {
        C41398am dYo;
        List list;
        boolean[] zArr = new boolean[1];
        C0026g a = c24612a.Biw != null ? C36952i.m61732a(dYn(), c24612a.Biw) : dYn();
        C31642l c31642l = c24612a.Bil;
        C8083t c8083t = c24612a.Bie;
        C8063a c8063a = c24612a.Bif;
        C37022f c37022f = c24612a.BgZ;
        boolean z = c24612a.Bit;
        C8083t c8083t2 = c24612a.Bie;
        if (z) {
            if (c8083t2 == null) {
                c8083t2 = ean();
            }
            dYo = c8083t2.dYo();
        } else {
            dYo = C41398am.BeR;
        }
        c8083t2 = mo91a(c31642l, c8083t, c8063a, c37022f, a, dYo);
        if (c24612a.Biv == null) {
            list = this.BeK;
        } else {
            list = c24612a.Biv;
        }
        zArr[0] = (!list.isEmpty() ? 1 : 0) | zArr[0];
        ArrayList arrayList = new ArrayList(list.size());
        final C25227au a2 = C41454k.m72329a(list, c24612a.Bik, c8083t2, arrayList, zArr);
        if (a2 == null) {
            return null;
        }
        C31633ac c31633ac;
        C41396ak c41396ak;
        if (c24612a.Bip != null) {
            C46867w c = a2.mo42080c(c24612a.Bip.dZS(), C0163ba.IN_VARIANCE);
            if (c == null) {
                return null;
            }
            C31633ac c31633ac2 = new C31633ac(c8083t2, new C0129b(c8083t2, c, c24612a.Bip.dZO()), c24612a.Bip.dYn());
            zArr[0] = (c != c24612a.Bip.dZS() ? 1 : 0) | zArr[0];
            c31633ac = c31633ac2;
        } else {
            c31633ac = null;
        }
        if (c24612a.BhP != null) {
            C41396ak e = c24612a.BhP.mo31269e(a2);
            if (e == null) {
                return null;
            }
            zArr[0] = (e != c24612a.BhP ? 1 : 0) | zArr[0];
            c41396ak = e;
        } else {
            c41396ak = null;
        }
        List a3 = C36961p.m61735a(c8083t2, c24612a.Bio, a2, c24612a.Biu, c24612a.Bit, zArr);
        if (a3 == null) {
            return null;
        }
        C46867w c2 = a2.mo42080c(c24612a.Biq, C0163ba.OUT_VARIANCE);
        if (c2 == null) {
            return null;
        }
        zArr[0] = (c2 != c24612a.Biq ? 1 : 0) | zArr[0];
        if (!zArr[0] && c24612a.Biy) {
            return this;
        }
        c8083t2.mo58963a(c31633ac, c41396ak, arrayList, a3, c2, c24612a.Bim, c24612a.Bin);
        c8083t2.BhR = this.BhR;
        c8083t2.BhS = this.BhS;
        c8083t2.Bhu = this.Bhu;
        c8083t2.BhT = this.BhT;
        c8083t2.BhU = this.BhU;
        c8083t2.BhZ = this.BhZ;
        c8083t2.BhV = this.BhV;
        c8083t2.BhW = this.BhW;
        c8083t2.mo96rH(this.Bia);
        c8083t2.BhX = c24612a.BhX;
        c8083t2.BhY = c24612a.BhY;
        c8083t2.mo97rI(c24612a.Bix != null ? c24612a.Bix.booleanValue() : this.Bib);
        if (!(c24612a.Bih.isEmpty() && this.Bih == null)) {
            Map map = c24612a.Bih;
            if (this.Bih != null) {
                for (Entry entry : this.Bih.entrySet()) {
                    if (!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map.size() == 1) {
                c8083t2.Bih = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
            } else {
                c8083t2.Bih = map;
            }
        }
        if (c24612a.Bis || this.Big != null) {
            C8083t c8083t3;
            if (this.Big != null) {
                c8083t3 = this.Big;
            } else {
                Object c8083t32 = this;
            }
            c8083t2.Big = c8083t32.mo17865c(a2);
        }
        if (c24612a.Bir && !ean().dYX().isEmpty()) {
            if (c24612a.Bik.isEmpty()) {
                C31214a c31214a = this.Bid;
                if (c31214a != null) {
                    c8083t2.Bid = c31214a;
                } else {
                    c8083t2.mo41960k(dYX());
                }
            } else {
                c8083t2.Bid = new C31214a<Collection<C8083t>>() {
                    public final /* synthetic */ Object invoke() {
                        AppMethodBeat.m2504i(119459);
                        C37067h c37067h = new C37067h();
                        for (C8083t c : C36961p.this.dYX()) {
                            c37067h.add(c.mo17865c(a2));
                        }
                        AppMethodBeat.m2505o(119459);
                        return c37067h;
                    }
                };
            }
        }
        return c8083t2;
    }

    /* renamed from: b */
    public C8083t mo17864b(C31642l c31642l, C44879w c44879w, C25082az c25082az, C8063a c8063a, boolean z) {
        return dZw().mo17915g(c31642l).mo17904a(c44879w).mo17902a(c25082az).mo17903a(c8063a).mo17916rG(z).dZC();
    }

    /* renamed from: a */
    public <R, D> R mo245a(C44877n<R, D> c44877n, D d) {
        return c44877n.mo13679a((C8083t) this, (Object) d);
    }

    /* renamed from: a */
    public static List<C41399au> m61735a(C8083t c8083t, List<C41399au> list, C25227au c25227au, boolean z, boolean z2, boolean[] zArr) {
        ArrayList arrayList = new ArrayList(list.size());
        for (C41399au c41399au : list) {
            C46867w c = c25227au.mo42080c(c41399au.dZS(), C0163ba.IN_VARIANCE);
            C46867w dZV = c41399au.dZV();
            C46867w c2 = dZV == null ? null : c25227au.mo42080c(dZV, C0163ba.IN_VARIANCE);
            if (c == null) {
                return null;
            }
            if (!((c == c41399au.dZS() && dZV == c2) || zArr == null)) {
                zArr[0] = true;
            }
            arrayList.add(new C8069ai(c8083t, z ? null : c41399au, c41399au.getIndex(), c41399au.dYn(), c41399au.dZg(), c, c41399au.dZU(), c41399au.dZX(), c41399au.dZY(), c2, z2 ? c41399au.dYo() : C41398am.BeR));
        }
        return arrayList;
    }

    public final C8083t dZq() {
        return this.Big;
    }

    /* renamed from: a */
    public final <V> void mo58965a(C8037a<V> c8037a, Object obj) {
        if (this.Bih == null) {
            this.Bih = new LinkedHashMap();
        }
        this.Bih.put(c8037a, obj);
    }

    public Collection<? extends C8083t> dYX() {
        C31214a c31214a = this.Bid;
        if (c31214a != null) {
            this.Bic = (Collection) c31214a.invoke();
            this.Bid = null;
        }
        return this.Bic != null ? this.Bic : Collections.emptyList();
    }

    /* renamed from: c */
    public C8083t mo17870f(C25227au c25227au) {
        return c25227au.Bik.isEmpty() ? this : mo58966h(c25227au).mo41456h(ean()).eax().dZC();
    }
}
