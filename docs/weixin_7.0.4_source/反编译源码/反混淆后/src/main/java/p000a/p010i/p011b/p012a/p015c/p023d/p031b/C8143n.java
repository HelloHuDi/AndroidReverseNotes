package p000a.p010i.p011b.p012a.p015c.p023d.p031b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.p032a.C8134a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;

/* renamed from: a.i.b.a.c.d.b.n */
public interface C8143n {

    /* renamed from: a.i.b.a.c.d.b.n$d */
    public static final class C8140d {
        final C8173a BcB;
        final int BrG;

        public C8140d(C8173a c8173a, int i) {
            C25052j.m39376p(c8173a, "classId");
            AppMethodBeat.m2504i(120284);
            this.BcB = c8173a;
            this.BrG = i;
            AppMethodBeat.m2505o(120284);
        }
    }

    /* renamed from: a.i.b.a.c.d.b.n$e */
    public interface C8141e {
        /* renamed from: a */
        C8142f mo17936a(C37022f c37022f, String str);

        /* renamed from: b */
        C8146c mo17937b(C37022f c37022f, String str);
    }

    /* renamed from: a.i.b.a.c.d.b.n$f */
    public interface C8142f extends C8146c {
        /* renamed from: a */
        C8145a mo17938a(int i, C8173a c8173a, C41398am c41398am);
    }

    /* renamed from: a.i.b.a.c.d.b.n$b */
    public interface C8144b {
        /* renamed from: a */
        void mo110a(C8140d c8140d);

        /* renamed from: a */
        void mo111a(C8173a c8173a, C37022f c37022f);

        /* renamed from: dG */
        void mo113dG(Object obj);

        /* renamed from: zn */
        void mo114zn();
    }

    /* renamed from: a.i.b.a.c.d.b.n$a */
    public interface C8145a {
        /* renamed from: a */
        C8145a mo115a(C37022f c37022f, C8173a c8173a);

        /* renamed from: a */
        void mo116a(C37022f c37022f, C8140d c8140d);

        /* renamed from: a */
        void mo117a(C37022f c37022f, C8173a c8173a, C37022f c37022f2);

        /* renamed from: a */
        void mo118a(C37022f c37022f, Object obj);

        /* renamed from: o */
        C8144b mo119o(C37022f c37022f);

        /* renamed from: zn */
        void mo120zn();
    }

    /* renamed from: a.i.b.a.c.d.b.n$c */
    public interface C8146c {
        /* renamed from: a */
        C8145a mo17930a(C8173a c8173a, C41398am c41398am);

        /* renamed from: zn */
        void mo17931zn();
    }

    /* renamed from: a */
    void mo17939a(C8146c c8146c);

    /* renamed from: a */
    void mo17940a(C8141e c8141e);

    C8173a dWY();

    C8134a dXA();

    String getLocation();
}
