package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C44941v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C6134i;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;

/* renamed from: a.i.b.a.c.l.ai */
public final class C37052ai {

    /* renamed from: a.i.b.a.c.l.ai$a */
    public static final class C8237a extends C25225ao {
        final /* synthetic */ List BJN;

        C8237a(List list) {
            this.BJN = list;
        }

        /* renamed from: c */
        public final C41446ap mo18037c(C17313an c17313an) {
            AppMethodBeat.m2504i(122635);
            C25052j.m39376p(c17313an, "key");
            if (this.BJN.contains(c17313an)) {
                C0036h dYs = c17313an.dYs();
                if (dYs == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                    AppMethodBeat.m2505o(122635);
                    throw c44941v;
                }
                C41446ap e = C17316av.m26823e((C36955ar) dYs);
                AppMethodBeat.m2505o(122635);
                return e;
            }
            AppMethodBeat.m2505o(122635);
            return null;
        }
    }

    /* renamed from: d */
    public static final C46867w m62005d(C36955ar c36955ar) {
        AppMethodBeat.m2504i(122636);
        C25052j.m39376p(c36955ar, "receiver$0");
        C31642l dXW = c36955ar.dXW();
        if (dXW == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassifierDescriptorWithTypeParameters");
            AppMethodBeat.m2505o(122636);
            throw c44941v;
        }
        C17313an dXY = ((C6134i) dXW).dXY();
        C25052j.m39375o(dXY, "classDescriptor.typeConstructor");
        List parameters = dXY.getParameters();
        C25052j.m39375o(parameters, "classDescriptor.typeConstructor.parameters");
        Iterable<C36955ar> iterable = parameters;
        Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
        for (C36955ar c36955ar2 : iterable) {
            C25052j.m39375o(c36955ar2, "it");
            arrayList.add(c36955ar2.dXY());
        }
        C25227au d = C25227au.m39772d((C44922as) new C8237a((List) arrayList));
        parameters = c36955ar.dWP();
        C25052j.m39375o(parameters, "this.upperBounds");
        C46867w c = d.mo42080c((C46867w) C25035t.m39337fJ(parameters), C0163ba.OUT_VARIANCE);
        if (c == null) {
            C8235ad dXN = C41434a.m72275G(c36955ar).dXN();
            C25052j.m39375o(dXN, "builtIns.defaultBound");
            c = dXN;
        }
        AppMethodBeat.m2505o(122636);
        return c;
    }
}
