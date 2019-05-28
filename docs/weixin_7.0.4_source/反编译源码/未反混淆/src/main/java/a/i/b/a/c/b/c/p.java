package a.i.b.a.c.b.c;

import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.a.i;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.ay;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.b;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.n;
import a.i.b.a.c.b.t;
import a.i.b.a.c.f.f;
import a.i.b.a.c.l.as;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.k;
import a.i.b.a.c.l.w;
import a.i.b.a.c.n.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class p extends k implements t {
    public List<ar> BeK;
    public List<au> BhM;
    public w BhN;
    private ak BhO;
    protected ak BhP;
    public az BhQ = ay.Bfe;
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
    protected a.i.b.a.c.b.w Bhv;
    private boolean Bia = true;
    private boolean Bib = false;
    private Collection<? extends t> Bic = null;
    private volatile a.f.a.a<Collection<t>> Bid = null;
    private final t Bie;
    protected final a.i.b.a.c.b.b.a Bif;
    private t Big = null;
    protected Map<a.i.b.a.c.b.a.a<?>, Object> Bih = null;

    public class a implements a.i.b.a.c.b.t.a<t> {
        protected f BgZ;
        protected ak BhP = this.Bij.BhP;
        boolean BhX = this.Bij.BhX;
        boolean BhY = this.Bij.BhY;
        protected t Bie = null;
        protected a.i.b.a.c.b.b.a Bif;
        Map<a.i.b.a.c.b.a.a<?>, Object> Bih = new LinkedHashMap();
        final /* synthetic */ p Bij;
        protected as Bik;
        protected l Bil;
        protected a.i.b.a.c.b.w Bim;
        protected az Bin;
        protected List<au> Bio;
        protected ak Bip;
        protected w Biq;
        protected boolean Bir = true;
        protected boolean Bis = false;
        protected boolean Bit = false;
        protected boolean Biu = false;
        List<ar> Biv = null;
        g Biw = null;
        public Boolean Bix = null;
        protected boolean Biy = false;

        public a(as asVar, l lVar, a.i.b.a.c.b.w wVar, az azVar, a.i.b.a.c.b.b.a aVar, List<au> list, ak akVar, w wVar2, f fVar) {
            this.Bij = asVar;
            AppMethodBeat.i(119460);
            this.Bik = lVar;
            this.Bil = wVar;
            this.Bim = azVar;
            this.Bin = aVar;
            this.Bif = list;
            this.Bio = akVar;
            this.Bip = wVar2;
            this.Biq = fVar;
            this.BgZ = null;
            AppMethodBeat.o(119460);
        }

        public final a fT(List<au> list) {
            this.Bio = list;
            return this;
        }

        public final a h(b bVar) {
            this.Bie = (t) bVar;
            return this;
        }

        public final t dZC() {
            AppMethodBeat.i(119461);
            t a = this.Bij.a(this);
            AppMethodBeat.o(119461);
            return a;
        }

        public final a eax() {
            this.Biy = true;
            return this;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.b.t.a dZB() {
            this.BhY = true;
            return this;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.b.t.a dZA() {
            this.BhX = true;
            return this;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.b.t.a dZz() {
            this.Biu = true;
            return this;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.b.t.a dZy() {
            this.Bit = true;
            return this;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.b.t.a dZx() {
            this.Bis = true;
            return this;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.b.t.a I(w wVar) {
            this.Biq = wVar;
            return this;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.b.t.a fR(List list) {
            this.Bio = list;
            return this;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.b.t.a e(f fVar) {
            this.BgZ = fVar;
            return this;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.b.t.a rG(boolean z) {
            this.Bir = z;
            return this;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.b.t.a g(l lVar) {
            this.Bil = lVar;
            return this;
        }
    }

    public abstract p a(l lVar, t tVar, a.i.b.a.c.b.b.a aVar, f fVar, g gVar, am amVar);

    public /* synthetic */ b a(l lVar, a.i.b.a.c.b.w wVar, az azVar, a.i.b.a.c.b.b.a aVar) {
        return b(lVar, wVar, azVar, aVar, false);
    }

    protected p(l lVar, t tVar, g gVar, f fVar, a.i.b.a.c.b.b.a aVar, am amVar) {
        super(lVar, gVar, fVar, amVar);
        if (tVar == null) {
            tVar = this;
        }
        this.Bie = tVar;
        this.Bif = aVar;
    }

    public p a(ak akVar, ak akVar2, List<? extends ar> list, List<au> list2, w wVar, a.i.b.a.c.b.w wVar2, az azVar) {
        int i = 0;
        this.BeK = a.a.t.m(list);
        this.BhM = a.a.t.m(list2);
        this.BhN = wVar;
        this.Bhv = wVar2;
        this.BhQ = azVar;
        this.BhO = akVar;
        this.BhP = akVar2;
        for (int i2 = 0; i2 < list.size(); i2++) {
            ar arVar = (ar) list.get(i2);
            if (arVar.getIndex() != i2) {
                throw new IllegalStateException(arVar + " index is " + arVar.getIndex() + " but position is " + i2);
            }
        }
        while (i < list2.size()) {
            au auVar = (au) list2.get(i);
            if (auVar.getIndex() != i + 0) {
                throw new IllegalStateException(auVar + "index is " + auVar.getIndex() + " but position is " + i);
            }
            i++;
        }
        return this;
    }

    public void rH(boolean z) {
        this.Bia = z;
    }

    public void rI(boolean z) {
        this.Bib = z;
    }

    public final ak dYQ() {
        return this.BhO;
    }

    public final ak dYR() {
        return this.BhP;
    }

    public final a.i.b.a.c.b.w dYd() {
        return this.Bhv;
    }

    public final az dYf() {
        return this.BhQ;
    }

    public final boolean dZs() {
        if (this.BhR) {
            return true;
        }
        for (t dZs : ean().dYX()) {
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
        for (t dZt : ean().dYX()) {
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

    public <V> V a(a.i.b.a.c.b.a.a<V> aVar) {
        if (this.Bih == null) {
            return null;
        }
        return this.Bih.get(aVar);
    }

    public final boolean dZr() {
        return this.BhX;
    }

    public void k(Collection<? extends b> collection) {
        this.Bic = collection;
        for (t dZu : this.Bic) {
            if (dZu.dZu()) {
                this.BhY = true;
                return;
            }
        }
    }

    public final List<ar> dYS() {
        return this.BeK;
    }

    public final List<au> dYV() {
        return this.BhM;
    }

    public boolean eaw() {
        return this.Bia;
    }

    public boolean dYW() {
        return this.Bib;
    }

    public w dYT() {
        return this.BhN;
    }

    /* renamed from: dZp */
    public t ean() {
        return this.Bie == this ? this : this.Bie.dZp();
    }

    public final a.i.b.a.c.b.b.a dYZ() {
        return this.Bif;
    }

    public final boolean dZu() {
        return this.BhY;
    }

    public a.i.b.a.c.b.t.a<? extends t> dZw() {
        return h(a.i.b.a.c.l.au.BJW);
    }

    /* Access modifiers changed, original: protected|final */
    public final a h(a.i.b.a.c.l.au auVar) {
        return new a(this, auVar.Bik, dXW(), this.Bhv, this.BhQ, this.Bif, this.BhM, this.BhO, dYT());
    }

    /* Access modifiers changed, original: protected */
    public t a(a aVar) {
        am dYo;
        List list;
        boolean[] zArr = new boolean[1];
        g a = aVar.Biw != null ? i.a(dYn(), aVar.Biw) : dYn();
        l lVar = aVar.Bil;
        t tVar = aVar.Bie;
        a.i.b.a.c.b.b.a aVar2 = aVar.Bif;
        f fVar = aVar.BgZ;
        boolean z = aVar.Bit;
        t tVar2 = aVar.Bie;
        if (z) {
            if (tVar2 == null) {
                tVar2 = ean();
            }
            dYo = tVar2.dYo();
        } else {
            dYo = am.BeR;
        }
        tVar2 = a(lVar, tVar, aVar2, fVar, a, dYo);
        if (aVar.Biv == null) {
            list = this.BeK;
        } else {
            list = aVar.Biv;
        }
        zArr[0] = (!list.isEmpty() ? 1 : 0) | zArr[0];
        ArrayList arrayList = new ArrayList(list.size());
        final a.i.b.a.c.l.au a2 = k.a(list, aVar.Bik, tVar2, arrayList, zArr);
        if (a2 == null) {
            return null;
        }
        ac acVar;
        ak akVar;
        if (aVar.Bip != null) {
            w c = a2.c(aVar.Bip.dZS(), ba.IN_VARIANCE);
            if (c == null) {
                return null;
            }
            ac acVar2 = new ac(tVar2, new a.i.b.a.c.i.e.a.b(tVar2, c, aVar.Bip.dZO()), aVar.Bip.dYn());
            zArr[0] = (c != aVar.Bip.dZS() ? 1 : 0) | zArr[0];
            acVar = acVar2;
        } else {
            acVar = null;
        }
        if (aVar.BhP != null) {
            ak e = aVar.BhP.e(a2);
            if (e == null) {
                return null;
            }
            zArr[0] = (e != aVar.BhP ? 1 : 0) | zArr[0];
            akVar = e;
        } else {
            akVar = null;
        }
        List a3 = a(tVar2, aVar.Bio, a2, aVar.Biu, aVar.Bit, zArr);
        if (a3 == null) {
            return null;
        }
        w c2 = a2.c(aVar.Biq, ba.OUT_VARIANCE);
        if (c2 == null) {
            return null;
        }
        zArr[0] = (c2 != aVar.Biq ? 1 : 0) | zArr[0];
        if (!zArr[0] && aVar.Biy) {
            return this;
        }
        tVar2.a(acVar, akVar, arrayList, a3, c2, aVar.Bim, aVar.Bin);
        tVar2.BhR = this.BhR;
        tVar2.BhS = this.BhS;
        tVar2.Bhu = this.Bhu;
        tVar2.BhT = this.BhT;
        tVar2.BhU = this.BhU;
        tVar2.BhZ = this.BhZ;
        tVar2.BhV = this.BhV;
        tVar2.BhW = this.BhW;
        tVar2.rH(this.Bia);
        tVar2.BhX = aVar.BhX;
        tVar2.BhY = aVar.BhY;
        tVar2.rI(aVar.Bix != null ? aVar.Bix.booleanValue() : this.Bib);
        if (!(aVar.Bih.isEmpty() && this.Bih == null)) {
            Map map = aVar.Bih;
            if (this.Bih != null) {
                for (Entry entry : this.Bih.entrySet()) {
                    if (!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map.size() == 1) {
                tVar2.Bih = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
            } else {
                tVar2.Bih = map;
            }
        }
        if (aVar.Bis || this.Big != null) {
            t tVar3;
            if (this.Big != null) {
                tVar3 = this.Big;
            } else {
                Object tVar32 = this;
            }
            tVar2.Big = tVar32.c(a2);
        }
        if (aVar.Bir && !ean().dYX().isEmpty()) {
            if (aVar.Bik.isEmpty()) {
                a.f.a.a aVar3 = this.Bid;
                if (aVar3 != null) {
                    tVar2.Bid = aVar3;
                } else {
                    tVar2.k(dYX());
                }
            } else {
                tVar2.Bid = new a.f.a.a<Collection<t>>() {
                    public final /* synthetic */ Object invoke() {
                        AppMethodBeat.i(119459);
                        h hVar = new h();
                        for (t c : p.this.dYX()) {
                            hVar.add(c.c(a2));
                        }
                        AppMethodBeat.o(119459);
                        return hVar;
                    }
                };
            }
        }
        return tVar2;
    }

    public t b(l lVar, a.i.b.a.c.b.w wVar, az azVar, a.i.b.a.c.b.b.a aVar, boolean z) {
        return dZw().g(lVar).a(wVar).a(azVar).a(aVar).rG(z).dZC();
    }

    public <R, D> R a(n<R, D> nVar, D d) {
        return nVar.a((t) this, (Object) d);
    }

    public static List<au> a(t tVar, List<au> list, a.i.b.a.c.l.au auVar, boolean z, boolean z2, boolean[] zArr) {
        ArrayList arrayList = new ArrayList(list.size());
        for (au auVar2 : list) {
            w c = auVar.c(auVar2.dZS(), ba.IN_VARIANCE);
            w dZV = auVar2.dZV();
            w c2 = dZV == null ? null : auVar.c(dZV, ba.IN_VARIANCE);
            if (c == null) {
                return null;
            }
            if (!((c == auVar2.dZS() && dZV == c2) || zArr == null)) {
                zArr[0] = true;
            }
            arrayList.add(new ai(tVar, z ? null : auVar2, auVar2.getIndex(), auVar2.dYn(), auVar2.dZg(), c, auVar2.dZU(), auVar2.dZX(), auVar2.dZY(), c2, z2 ? auVar2.dYo() : am.BeR));
        }
        return arrayList;
    }

    public final t dZq() {
        return this.Big;
    }

    public final <V> void a(a.i.b.a.c.b.a.a<V> aVar, Object obj) {
        if (this.Bih == null) {
            this.Bih = new LinkedHashMap();
        }
        this.Bih.put(aVar, obj);
    }

    public Collection<? extends t> dYX() {
        a.f.a.a aVar = this.Bid;
        if (aVar != null) {
            this.Bic = (Collection) aVar.invoke();
            this.Bid = null;
        }
        return this.Bic != null ? this.Bic : Collections.emptyList();
    }

    /* renamed from: c */
    public t f(a.i.b.a.c.l.au auVar) {
        return auVar.Bik.isEmpty() ? this : h(auVar).h(ean()).eax().dZC();
    }
}
