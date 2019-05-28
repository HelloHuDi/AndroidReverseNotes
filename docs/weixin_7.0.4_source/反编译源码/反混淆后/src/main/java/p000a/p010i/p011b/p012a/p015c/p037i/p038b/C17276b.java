package p000a.p010i.p011b.p012a.p015c.p037i.p038b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.C44847aa;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;

/* renamed from: a.i.b.a.c.i.b.b */
public final class C17276b extends C41432f<List<? extends C41432f<?>>> {
    private final C17126b<C25093y, C46867w> BEN;

    public C17276b(List<? extends C41432f<?>> list, C17126b<? super C25093y, ? extends C46867w> c17126b) {
        C25052j.m39376p(list, "value");
        C25052j.m39376p(c17126b, "computeType");
        super(list);
        AppMethodBeat.m2504i(122069);
        this.BEN = c17126b;
        AppMethodBeat.m2505o(122069);
    }

    /* renamed from: b */
    public final C46867w mo18011b(C25093y c25093y) {
        AppMethodBeat.m2504i(122068);
        C25052j.m39376p(c25093y, "module");
        Object am = this.BEN.mo50am(c25093y);
        C46867w c46867w = (C46867w) am;
        Object obj = (C31619g.m51123n(c46867w) || C31619g.m51124o(c46867w)) ? 1 : null;
        if (C44847aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Type should be an array, but was " + c46867w + ": " + ((List) getValue()));
            AppMethodBeat.m2505o(122068);
            throw assertionError;
        }
        C46867w c46867w2 = (C46867w) am;
        AppMethodBeat.m2505o(122068);
        return c46867w2;
    }
}
