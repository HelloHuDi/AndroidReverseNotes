package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p025a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Map;
import p000a.C8312u;
import p000a.p001a.C31586ag;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C44869c;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.C0057h;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p028a.C8096e;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C17187d;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C41408a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.d.a.a.c */
public final class C0042c {
    private static final C8174b BlV = new C8174b(Target.class.getCanonicalName());
    private static final C8174b BlW = new C8174b(Retention.class.getCanonicalName());
    private static final C8174b BlX = new C8174b(Deprecated.class.getCanonicalName());
    private static final C8174b BlY = new C8174b(Documented.class.getCanonicalName());
    private static final C8174b BlZ = new C8174b("java.lang.annotation.Repeatable");
    private static final C37022f Bma;
    private static final C37022f Bmb;
    private static final C37022f Bmc;
    private static final Map<C8174b, C8174b> Bmd = C31586ag.m51049a(C8312u.m14628I(C31619g.Bag.BaQ, BlV), C8312u.m14628I(C31619g.Bag.BaT, BlW), C8312u.m14628I(C31619g.Bag.BaU, BlZ), C8312u.m14628I(C31619g.Bag.BaV, BlY));
    private static final Map<C8174b, C8174b> Bme = C31586ag.m51049a(C8312u.m14628I(BlV, C31619g.Bag.BaQ), C8312u.m14628I(BlW, C31619g.Bag.BaT), C8312u.m14628I(BlX, C31619g.Bag.BaK), C8312u.m14628I(BlZ, C31619g.Bag.BaU), C8312u.m14628I(BlY, C31619g.Bag.BaV));
    public static final C0042c Bmf = new C0042c();

    static {
        AppMethodBeat.m2504i(119758);
        C37022f avX = C37022f.avX(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        C25052j.m39375o(avX, "Name.identifier(\"message\")");
        Bma = avX;
        avX = C37022f.avX("allowedTargets");
        C25052j.m39375o(avX, "Name.identifier(\"allowedTargets\")");
        Bmb = avX;
        avX = C37022f.avX("value");
        C25052j.m39375o(avX, "Name.identifier(\"value\")");
        Bmc = avX;
        AppMethodBeat.m2505o(119758);
    }

    private C0042c() {
    }

    public static C37022f ebi() {
        return Bma;
    }

    public static C37022f ebj() {
        return Bmb;
    }

    public static C37022f ebk() {
        return Bmc;
    }

    /* renamed from: a */
    public static C44869c m39a(C41408a c41408a, C0057h c0057h) {
        AppMethodBeat.m2504i(119756);
        C25052j.m39376p(c41408a, "annotation");
        C25052j.m39376p(c0057h, "c");
        C8173a dWY = c41408a.dWY();
        C44869c c36969i;
        C8174b c8174b;
        if (C25052j.m39373j(dWY, C8173a.m14427n(BlV))) {
            c36969i = new C36969i(c41408a, c0057h);
            AppMethodBeat.m2505o(119756);
            return c36969i;
        } else if (C25052j.m39373j(dWY, C8173a.m14427n(BlW))) {
            c36969i = new C44880h(c41408a, c0057h);
            AppMethodBeat.m2505o(119756);
            return c36969i;
        } else if (C25052j.m39373j(dWY, C8173a.m14427n(BlZ))) {
            c8174b = C31619g.Bag.BaU;
            C25052j.m39375o(c8174b, "KotlinBuiltIns.FQ_NAMES.repeatable");
            c36969i = new C0040b(c0057h, c41408a, c8174b);
            AppMethodBeat.m2505o(119756);
            return c36969i;
        } else if (C25052j.m39373j(dWY, C8173a.m14427n(BlY))) {
            c8174b = C31619g.Bag.BaV;
            C25052j.m39375o(c8174b, "KotlinBuiltIns.FQ_NAMES.mustBeDocumented");
            c36969i = new C0040b(c0057h, c41408a, c8174b);
            AppMethodBeat.m2505o(119756);
            return c36969i;
        } else if (C25052j.m39373j(dWY, C8173a.m14427n(BlX))) {
            AppMethodBeat.m2505o(119756);
            return null;
        } else {
            c36969i = new C8096e(c0057h, c41408a);
            AppMethodBeat.m2505o(119756);
            return c36969i;
        }
    }

    /* renamed from: a */
    public static C44869c m40a(C8174b c8174b, C17187d c17187d, C0057h c0057h) {
        C44869c c6135e;
        AppMethodBeat.m2504i(119757);
        C25052j.m39376p(c8174b, "kotlinName");
        C25052j.m39376p(c17187d, "annotationOwner");
        C25052j.m39376p(c0057h, "c");
        if (C25052j.m39373j(c8174b, C31619g.Bag.BaK)) {
            C41408a m = c17187d.mo18057m(BlX);
            if (m != null) {
                c6135e = new C6135e(m, c0057h);
                AppMethodBeat.m2505o(119757);
                return c6135e;
            }
        }
        C8174b c8174b2 = (C8174b) Bmd.get(c8174b);
        if (c8174b2 != null) {
            C41408a m2 = c17187d.mo18057m(c8174b2);
            if (m2 != null) {
                c6135e = C0042c.m39a(m2, c0057h);
                AppMethodBeat.m2505o(119757);
                return c6135e;
            }
            AppMethodBeat.m2505o(119757);
            return null;
        }
        AppMethodBeat.m2505o(119757);
        return null;
    }
}
