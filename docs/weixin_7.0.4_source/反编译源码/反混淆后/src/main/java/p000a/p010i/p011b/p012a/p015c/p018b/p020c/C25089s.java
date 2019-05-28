package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C31643m;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C36963d;
import p000a.p010i.p011b.p012a.p015c.p018b.C36964f;
import p000a.p010i.p011b.p012a.p015c.p018b.C41396ak;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C44877n;
import p000a.p010i.p011b.p012a.p015c.p018b.C44879w;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C25178l;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p044k.C17299b;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C17316av;
import p000a.p010i.p011b.p012a.p015c.p045l.C17326x;
import p000a.p010i.p011b.p012a.p015c.p045l.C25227au;
import p000a.p010i.p011b.p012a.p015c.p045l.C41453e;
import p000a.p010i.p011b.p012a.p015c.p045l.C41454k;
import p000a.p010i.p011b.p012a.p015c.p045l.C44922as;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.b.c.s */
public final class C25089s implements C46865e {
    private C17313an Bhx;
    private final C46865e BiF;
    private final C25227au BiG;
    private C25227au BiH;
    private List<C36955ar> BiI;
    private List<C36955ar> BiJ;

    /* renamed from: a.i.b.a.c.b.c.s$1 */
    class C250901 implements C17126b<C36955ar, Boolean> {
        C250901() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            boolean z;
            AppMethodBeat.m2504i(119474);
            if (((C36955ar) obj).dZb()) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.m2505o(119474);
            return valueOf;
        }
    }

    public final /* synthetic */ C31642l dZd() {
        AppMethodBeat.m2504i(119504);
        C46865e dZm = dZm();
        AppMethodBeat.m2505o(119504);
        return dZm;
    }

    public final /* synthetic */ C0036h dZe() {
        AppMethodBeat.m2504i(119503);
        C46865e dZm = dZm();
        AppMethodBeat.m2505o(119503);
        return dZm;
    }

    public C25089s(C46865e c46865e, C25227au c25227au) {
        this.BiF = c46865e;
        this.BiG = c25227au;
    }

    private C25227au eay() {
        AppMethodBeat.m2504i(119475);
        if (this.BiH == null) {
            if (this.BiG.Bik.isEmpty()) {
                this.BiH = this.BiG;
            } else {
                List parameters = this.BiF.dXY().getParameters();
                this.BiI = new ArrayList(parameters.size());
                this.BiH = C41454k.m72328a(parameters, this.BiG.Bik, this, this.BiI);
                this.BiJ = C25035t.m39330b((Iterable) this.BiI, (C17126b) new C250901());
            }
        }
        C25227au c25227au = this.BiH;
        AppMethodBeat.m2505o(119475);
        return c25227au;
    }

    public final C17313an dXY() {
        AppMethodBeat.m2504i(119476);
        C17313an dXY = this.BiF.dXY();
        if (this.BiG.Bik.isEmpty()) {
            AppMethodBeat.m2505o(119476);
            return dXY;
        }
        if (this.Bhx == null) {
            C25227au eay = eay();
            Collection<C46867w> eap = dXY.eap();
            ArrayList arrayList = new ArrayList(eap.size());
            for (C46867w c : eap) {
                arrayList.add(eay.mo42080c(c, C0163ba.INVARIANT));
            }
            this.Bhx = new C41453e(this, this.BiI, arrayList, C17299b.BIH);
        }
        dXY = this.Bhx;
        AppMethodBeat.m2505o(119476);
        return dXY;
    }

    /* renamed from: a */
    public final C31746h mo31262a(C44922as c44922as) {
        AppMethodBeat.m2504i(119477);
        C31746h a = this.BiF.mo31262a(c44922as);
        if (this.BiG.Bik.isEmpty()) {
            AppMethodBeat.m2505o(119477);
            return a;
        }
        C25178l c25178l = new C25178l(a, eay());
        AppMethodBeat.m2505o(119477);
        return c25178l;
    }

    public final C31746h dXZ() {
        AppMethodBeat.m2504i(119478);
        C31746h dXZ = this.BiF.dXZ();
        if (this.BiG.Bik.isEmpty()) {
            AppMethodBeat.m2505o(119478);
            return dXZ;
        }
        C25178l c25178l = new C25178l(dXZ, eay());
        AppMethodBeat.m2505o(119478);
        return c25178l;
    }

    public final C31746h dXX() {
        AppMethodBeat.m2504i(119479);
        C31746h dXX = this.BiF.dXX();
        AppMethodBeat.m2505o(119479);
        return dXX;
    }

    public final C8235ad dZf() {
        AppMethodBeat.m2504i(119480);
        C8235ad a = C17326x.m26837a(dYn(), this, C17316av.m26824ga(dXY().getParameters()));
        AppMethodBeat.m2505o(119480);
        return a;
    }

    public final C41396ak dZl() {
        AppMethodBeat.m2504i(119481);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.m2505o(119481);
        throw unsupportedOperationException;
    }

    public final Collection<C36963d> dYb() {
        AppMethodBeat.m2504i(119482);
        Collection<C36963d> dYb = this.BiF.dYb();
        ArrayList arrayList = new ArrayList(dYb.size());
        for (C36963d c36963d : dYb) {
            arrayList.add(c36963d.mo58971a(this, c36963d.dYd(), c36963d.dYf(), c36963d.dYZ(), false).mo58972a(eay()));
        }
        AppMethodBeat.m2505o(119482);
        return arrayList;
    }

    public final C0026g dYn() {
        AppMethodBeat.m2504i(119483);
        C0026g dYn = this.BiF.dYn();
        AppMethodBeat.m2505o(119483);
        return dYn;
    }

    public final C37022f dZg() {
        AppMethodBeat.m2504i(119484);
        C37022f dZg = this.BiF.dZg();
        AppMethodBeat.m2505o(119484);
        return dZg;
    }

    public final C46865e dZm() {
        AppMethodBeat.m2504i(119485);
        C46865e dZm = this.BiF.dZm();
        AppMethodBeat.m2505o(119485);
        return dZm;
    }

    public final C31642l dXW() {
        AppMethodBeat.m2504i(119486);
        C31642l dXW = this.BiF.dXW();
        AppMethodBeat.m2505o(119486);
        return dXW;
    }

    public final C46865e dYa() {
        AppMethodBeat.m2504i(119487);
        C46865e dYa = this.BiF.dYa();
        AppMethodBeat.m2505o(119487);
        return dYa;
    }

    public final C36964f dYc() {
        AppMethodBeat.m2504i(119488);
        C36964f dYc = this.BiF.dYc();
        AppMethodBeat.m2505o(119488);
        return dYc;
    }

    public final C44879w dYd() {
        AppMethodBeat.m2504i(119489);
        C44879w dYd = this.BiF.dYd();
        AppMethodBeat.m2505o(119489);
        return dYd;
    }

    public final C25082az dYf() {
        AppMethodBeat.m2504i(119490);
        C25082az dYf = this.BiF.dYf();
        AppMethodBeat.m2505o(119490);
        return dYf;
    }

    public final boolean dYh() {
        AppMethodBeat.m2504i(119491);
        boolean dYh = this.BiF.dYh();
        AppMethodBeat.m2505o(119491);
        return dYh;
    }

    public final boolean dYi() {
        AppMethodBeat.m2504i(119492);
        boolean dYi = this.BiF.dYi();
        AppMethodBeat.m2505o(119492);
        return dYi;
    }

    public final boolean dYj() {
        AppMethodBeat.m2504i(119493);
        boolean dYj = this.BiF.dYj();
        AppMethodBeat.m2505o(119493);
        return dYj;
    }

    public final boolean dYm() {
        AppMethodBeat.m2504i(119494);
        boolean dYm = this.BiF.dYm();
        AppMethodBeat.m2505o(119494);
        return dYm;
    }

    public final boolean dYg() {
        AppMethodBeat.m2504i(119495);
        boolean dYg = this.BiF.dYg();
        AppMethodBeat.m2505o(119495);
        return dYg;
    }

    public final boolean dYk() {
        AppMethodBeat.m2504i(119496);
        boolean dYk = this.BiF.dYk();
        AppMethodBeat.m2505o(119496);
        return dYk;
    }

    public final boolean dYl() {
        AppMethodBeat.m2504i(119497);
        boolean dYl = this.BiF.dYl();
        AppMethodBeat.m2505o(119497);
        return dYl;
    }

    /* renamed from: a */
    public final <R, D> R mo245a(C44877n<R, D> c44877n, D d) {
        AppMethodBeat.m2504i(119498);
        Object a = c44877n.mo13677a((C46865e) this, (Object) d);
        AppMethodBeat.m2505o(119498);
        return a;
    }

    public final C31746h dZk() {
        AppMethodBeat.m2504i(119499);
        C31746h dZk = this.BiF.dZk();
        AppMethodBeat.m2505o(119499);
        return dZk;
    }

    public final C36963d dYe() {
        AppMethodBeat.m2504i(119500);
        C36963d dYe = this.BiF.dYe();
        AppMethodBeat.m2505o(119500);
        return dYe;
    }

    public final C41398am dYo() {
        return C41398am.BeR;
    }

    public final List<C36955ar> dYq() {
        AppMethodBeat.m2504i(119501);
        eay();
        List list = this.BiJ;
        AppMethodBeat.m2505o(119501);
        return list;
    }

    public final Collection<C46865e> dYp() {
        AppMethodBeat.m2504i(119502);
        Collection dYp = this.BiF.dYp();
        AppMethodBeat.m2505o(119502);
        return dYp;
    }

    /* renamed from: f */
    public final /* synthetic */ C31643m mo17870f(C25227au c25227au) {
        AppMethodBeat.m2504i(119505);
        if (c25227au.Bik.isEmpty()) {
            AppMethodBeat.m2505o(119505);
            return this;
        }
        C25089s c25089s = new C25089s(this, C25227au.m39769b(c25227au.Bik, eay().Bik));
        AppMethodBeat.m2505o(119505);
        return c25089s;
    }
}
