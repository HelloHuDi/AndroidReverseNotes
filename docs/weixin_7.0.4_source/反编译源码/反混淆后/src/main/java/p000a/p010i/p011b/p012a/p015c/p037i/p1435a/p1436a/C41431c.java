package p000a.p010i.p011b.p012a.p015c.p037i.p1435a.p1436a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C31826o;
import p000a.C44941v;
import p000a.C8312u;
import p000a.p001a.C25034m;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p044k.C17299b;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17323h;
import p000a.p010i.p011b.p012a.p015c.p045l.C17327z;
import p000a.p010i.p011b.p012a.p015c.p045l.C41446ap;
import p000a.p010i.p011b.p012a.p015c.p045l.C44836ar;
import p000a.p010i.p011b.p012a.p015c.p045l.C44922as;
import p000a.p010i.p011b.p012a.p015c.p045l.C46866u;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;

/* renamed from: a.i.b.a.c.i.a.a.c */
public final class C41431c {

    /* renamed from: a.i.b.a.c.i.a.a.c$a */
    static final class C31738a extends C25053k implements C31214a<C46867w> {
        final /* synthetic */ C41446ap BEK;

        C31738a(C41446ap c41446ap) {
            this.BEK = c41446ap;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(122060);
            C46867w dZS = this.BEK.dZS();
            C25052j.m39375o(dZS, "this@createCapturedIfNeeded.type");
            AppMethodBeat.m2505o(122060);
            return dZS;
        }
    }

    /* renamed from: a.i.b.a.c.i.a.a.c$b */
    public static final class C31739b extends C17323h {
        final /* synthetic */ C44922as BEL;
        final /* synthetic */ boolean BEM = true;

        C31739b(C44922as c44922as, C44922as c44922as2) {
            this.BEL = c44922as;
            super(c44922as2);
        }

        public final boolean ejx() {
            return this.BEM;
        }

        /* renamed from: O */
        public final C41446ap mo31386O(C46867w c46867w) {
            C41446ap c41446ap = null;
            AppMethodBeat.m2504i(122061);
            C25052j.m39376p(c46867w, "key");
            C41446ap O = super.mo31386O(c46867w);
            if (O != null) {
                C0036h dYs = c46867w.ejw().dYs();
                if (dYs instanceof C36955ar) {
                    Object c41446ap2 = dYs;
                }
                c41446ap2 = C41431c.m72268a(O, (C36955ar) c41446ap2);
                AppMethodBeat.m2505o(122061);
                return c41446ap2;
            }
            AppMethodBeat.m2505o(122061);
            return null;
        }
    }

    /* renamed from: b */
    private static C46867w m72270b(C41446ap c41446ap) {
        AppMethodBeat.m2504i(122062);
        C25052j.m39376p(c41446ap, "typeProjection");
        C46867w c44636a = new C44636a(c41446ap);
        AppMethodBeat.m2505o(122062);
        return c44636a;
    }

    /* renamed from: ae */
    public static final boolean m72269ae(C46867w c46867w) {
        AppMethodBeat.m2504i(122063);
        C25052j.m39376p(c46867w, "receiver$0");
        boolean z = c46867w.ejw() instanceof C41430b;
        AppMethodBeat.m2505o(122063);
        return z;
    }

    /* renamed from: c */
    public static /* synthetic */ C44922as m72271c(C44922as c44922as) {
        AppMethodBeat.m2504i(122064);
        C25052j.m39376p(c44922as, "receiver$0");
        C44922as c46866u;
        if (c44922as instanceof C46866u) {
            C36955ar[] c36955arArr = ((C46866u) c44922as).BJE;
            C41446ap[] c41446apArr = ((C46866u) c44922as).BJF;
            C36955ar[] c36955arArr2 = ((C46866u) c44922as).BJE;
            C25052j.m39376p(c41446apArr, "receiver$0");
            C25052j.m39376p(c36955arArr2, FacebookRequestErrorClassification.KEY_OTHER);
            int min = Math.min(c41446apArr.length, c36955arArr2.length);
            ArrayList arrayList = new ArrayList(min);
            for (int i = 0; i < min; i++) {
                arrayList.add(C8312u.m14628I(c41446apArr[i], c36955arArr2[i]));
            }
            Iterable<C31826o> iterable = arrayList;
            Collection arrayList2 = new ArrayList(C25034m.m39318d(iterable));
            for (C31826o c31826o : iterable) {
                arrayList2.add(C41431c.m72268a((C41446ap) c31826o.first, (C36955ar) c31826o.second));
            }
            Object[] toArray = ((List) arrayList2).toArray(new C41446ap[0]);
            if (toArray == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.m2505o(122064);
                throw c44941v;
            }
            c46866u = new C46866u(c36955arArr, (C41446ap[]) toArray, true);
            AppMethodBeat.m2505o(122064);
            return c46866u;
        }
        c46866u = new C31739b(c44922as, c44922as);
        AppMethodBeat.m2505o(122064);
        return c46866u;
    }

    /* renamed from: a */
    static final C41446ap m72268a(C41446ap c41446ap, C36955ar c36955ar) {
        AppMethodBeat.m2504i(122065);
        C41446ap c44836ar;
        if (c36955ar == null || c41446ap.ekq() == C0163ba.INVARIANT) {
            AppMethodBeat.m2505o(122065);
            return c41446ap;
        } else if (c36955ar.dZh() != c41446ap.ekq()) {
            c44836ar = new C44836ar(C41431c.m72270b(c41446ap));
            AppMethodBeat.m2505o(122065);
            return c44836ar;
        } else if (c41446ap.ekp()) {
            C25212i c25212i = C17299b.BIH;
            C25052j.m39375o(c25212i, "LockBasedStorageManager.NO_LOCKS");
            c44836ar = new C44836ar(new C17327z(c25212i, new C31738a(c41446ap)));
            AppMethodBeat.m2505o(122065);
            return c44836ar;
        } else {
            c44836ar = new C44836ar(c41446ap.dZS());
            AppMethodBeat.m2505o(122065);
            return c44836ar;
        }
    }
}
