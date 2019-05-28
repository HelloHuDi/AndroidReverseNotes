package p000a.p010i.p011b.p012a.p015c.p018b.p019a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.ActUtil;
import java.util.Collection;
import java.util.List;
import p000a.C31826o;
import p000a.C44847aa;
import p000a.C8312u;
import p000a.p001a.C17115v;
import p000a.p001a.C31586ag;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C36966v;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C17276b;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C17281i;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C25170a;
import p000a.p010i.p011b.p012a.p015c.p037i.p038b.C25174s;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.b.a.f */
public final class C8040f {
    private static final C37022f BfC;
    private static final C37022f BfD;
    private static final C37022f BfE;
    private static final C37022f BfF;
    private static final C37022f BfG;
    private static final C8174b BfH = new C8174b("kotlin.internal.InlineOnly");

    /* renamed from: a.i.b.a.c.b.a.f$a */
    static final class C8041a extends C25053k implements C17126b<C25093y, C8235ad> {
        final /* synthetic */ C31619g BfI;

        C8041a(C31619g c31619g) {
            this.BfI = c31619g;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119323);
            C25093y c25093y = (C25093y) obj;
            C25052j.m39376p(c25093y, "module");
            C8235ad a = c25093y.dZD().mo51608a(C0163ba.INVARIANT, (C46867w) this.BfI.dXP());
            C25052j.m39375o(a, "module.builtIns.getArray…ce.INVARIANT, stringType)");
            AppMethodBeat.m2505o(119323);
            return a;
        }
    }

    /* renamed from: b */
    public static /* synthetic */ C44869c m14214b(C31619g c31619g, String str) {
        AppMethodBeat.m2504i(119324);
        String str2 = "WARNING";
        C25052j.m39376p(c31619g, "receiver$0");
        C25052j.m39376p(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        C25052j.m39376p("", "replaceWith");
        C25052j.m39376p(str2, "level");
        C8174b c8174b = C31619g.Bag.BaM;
        C25052j.m39375o(c8174b, "KotlinBuiltIns.FQ_NAMES.replaceWith");
        C46864j c46864j = new C46864j(c31619g, c8174b, C31586ag.m51049a(C8312u.m14628I(BfF, new C25174s("")), C8312u.m14628I(BfG, new C17276b(C17115v.AUP, new C8041a(c31619g)))));
        c8174b = C31619g.Bag.BaK;
        C25052j.m39375o(c8174b, "KotlinBuiltIns.FQ_NAMES.deprecated");
        C31826o[] c31826oArr = new C31826o[3];
        c31826oArr[0] = C8312u.m14628I(BfC, new C25174s(str));
        c31826oArr[1] = C8312u.m14628I(BfD, new C25170a(c46864j));
        C37022f c37022f = BfE;
        C8173a n = C8173a.m14427n(C31619g.Bag.BaL);
        C25052j.m39375o(n, "ClassId.topLevel(KotlinB…Q_NAMES.deprecationLevel)");
        C37022f avX = C37022f.avX(str2);
        C25052j.m39375o(avX, "Name.identifier(level)");
        c31826oArr[2] = C8312u.m14628I(c37022f, new C17281i(n, avX));
        C44869c c46864j2 = new C46864j(c31619g, c8174b, C31586ag.m51049a(c31826oArr));
        AppMethodBeat.m2505o(119324);
        return c46864j2;
    }

    static {
        AppMethodBeat.m2504i(119328);
        C37022f avX = C37022f.avX(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        C25052j.m39375o(avX, "Name.identifier(\"message\")");
        BfC = avX;
        avX = C37022f.avX("replaceWith");
        C25052j.m39375o(avX, "Name.identifier(\"replaceWith\")");
        BfD = avX;
        avX = C37022f.avX("level");
        C25052j.m39375o(avX, "Name.identifier(\"level\")");
        BfE = avX;
        avX = C37022f.avX(ActUtil.EXPRESSION);
        C25052j.m39375o(avX, "Name.identifier(\"expression\")");
        BfF = avX;
        avX = C37022f.avX("imports");
        C25052j.m39375o(avX, "Name.identifier(\"imports\")");
        BfG = avX;
        AppMethodBeat.m2505o(119328);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARNING: Missing block: B:11:0x0058, code skipped:
            if (p000a.p010i.p011b.p012a.p015c.p018b.p019a.C8040f.m14216f(r0) == false) goto L_0x005a;
     */
    /* JADX WARNING: Missing block: B:13:0x005b, code skipped:
            if (r0 == null) goto L_0x00e4;
     */
    /* JADX WARNING: Missing block: B:34:0x00b7, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(((p000a.p010i.p011b.p012a.p015c.p018b.C8083t) r5).dYf(), p000a.p010i.p011b.p012a.p015c.p018b.C8051ay.BeW) == false) goto L_0x00e9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static final boolean m14213a(C36966v c36966v) {
        Object obj;
        AppMethodBeat.m2504i(119325);
        C25052j.m39376p(c36966v, "receiver$0");
        C25052j.m39376p(c36966v, "receiver$0");
        if (c36966v instanceof C25085b) {
            if (!C8040f.m14215e((C25085b) c36966v)) {
                C25085b v = C8203d.m14495v((C25085b) c36966v);
                C25052j.m39375o(v, "DescriptorUtils.getDirectMember(this)");
                if (!C8040f.m14215e(v)) {
                    C25052j.m39376p(c36966v, "receiver$0");
                    if (c36966v instanceof C8083t) {
                        if (!C8040f.m14216f((C25085b) c36966v)) {
                            v = C8203d.m14495v((C25085b) c36966v);
                            C25052j.m39375o(v, "DescriptorUtils.getDirectMember(this)");
                        }
                        boolean dYj = ((C8083t) c36966v).dYj();
                        if (!C44847aa.AUz || dYj) {
                            int obj2 = 1;
                        } else {
                            Throwable assertionError = new AssertionError("Function is not inline: ".concat(String.valueOf(c36966v)));
                            AppMethodBeat.m2505o(119325);
                            throw assertionError;
                        }
                    }
                    obj2 = null;
                }
            }
            obj2 = 1;
            if (obj2 == null) {
                if ((c36966v instanceof C8083t) && ((C8083t) c36966v).dZv() && ((C8083t) c36966v).dYj()) {
                    List dYV = ((C8083t) c36966v).dYV();
                    C25052j.m39375o(dYV, "valueParameters");
                    Iterable<C41399au> iterable = dYV;
                    if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                        for (C41399au dZX : iterable) {
                            if (dZX.dZX()) {
                                obj2 = 1;
                                break;
                            }
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                    }
                }
                AppMethodBeat.m2505o(119325);
                return false;
            }
            AppMethodBeat.m2505o(119325);
            return true;
        }
        obj2 = null;
        if (obj2 == null) {
        }
        AppMethodBeat.m2505o(119325);
        return true;
    }

    /* renamed from: e */
    private static final boolean m14215e(C25085b c25085b) {
        AppMethodBeat.m2504i(119326);
        List dYS = c25085b.dYS();
        C25052j.m39375o(dYS, "typeParameters");
        Iterable<C36955ar> iterable = dYS;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (C36955ar c36955ar : iterable) {
                C25052j.m39375o(c36955ar, "it");
                if (c36955ar.dZi()) {
                    AppMethodBeat.m2505o(119326);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(119326);
        return false;
    }

    /* renamed from: f */
    private static final boolean m14216f(C25085b c25085b) {
        AppMethodBeat.m2504i(119327);
        boolean j = c25085b.dYn().mo55j(BfH);
        AppMethodBeat.m2505o(119327);
        return j;
    }
}
