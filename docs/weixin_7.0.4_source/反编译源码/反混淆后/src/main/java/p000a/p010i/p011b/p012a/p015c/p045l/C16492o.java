package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.p001a.C17115v;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;

/* renamed from: a.i.b.a.c.l.o */
public class C16492o extends C8235ad {
    private final boolean BEI;
    private final C17313an BJm;
    private final List<C41446ap> BeP;
    private final C31746h BiC;

    public C16492o(C17313an c17313an, C31746h c31746h, byte b) {
        this(c17313an, c31746h);
    }

    /* renamed from: b */
    public final /* synthetic */ C41447az mo18029b(C0026g c0026g) {
        AppMethodBeat.m2504i(122533);
        C41447az d = mo18030d(c0026g);
        AppMethodBeat.m2505o(122533);
        return d;
    }

    /* renamed from: rK */
    public /* synthetic */ C41447az mo18032rK(boolean z) {
        AppMethodBeat.m2504i(122535);
        C41447az rL = mo18033rL(z);
        AppMethodBeat.m2505o(122535);
        return rL;
    }

    public final C17313an ejw() {
        return this.BJm;
    }

    public final C31746h dXR() {
        return this.BiC;
    }

    public final List<C41446ap> ejt() {
        return this.BeP;
    }

    public final boolean eci() {
        return this.BEI;
    }

    public C16492o(C17313an c17313an, C31746h c31746h, List<? extends C41446ap> list, boolean z) {
        C25052j.m39376p(c17313an, "constructor");
        C25052j.m39376p(c31746h, "memberScope");
        C25052j.m39376p(list, "arguments");
        AppMethodBeat.m2504i(122536);
        this.BJm = c17313an;
        this.BiC = c31746h;
        this.BeP = list;
        this.BEI = z;
        AppMethodBeat.m2505o(122536);
    }

    public final C0026g dYn() {
        AppMethodBeat.m2504i(122530);
        C0027a c0027a = C0026g.BfJ;
        C0026g eai = C0027a.eai();
        AppMethodBeat.m2505o(122530);
        return eai;
    }

    public String toString() {
        String str;
        AppMethodBeat.m2504i(122531);
        StringBuilder append = new StringBuilder().append(this.BJm.toString());
        if (this.BeP.isEmpty()) {
            str = "";
        } else {
            str = C25035t.m39321a(this.BeP, ", ", "<", ">", -1, "...", null);
        }
        str = append.append(str).toString();
        AppMethodBeat.m2505o(122531);
        return str;
    }

    /* renamed from: d */
    public final C8235ad mo18030d(C0026g c0026g) {
        AppMethodBeat.m2504i(122532);
        C25052j.m39376p(c0026g, "newAnnotations");
        C8235ad c8235ad = this;
        AppMethodBeat.m2505o(122532);
        return c8235ad;
    }

    /* renamed from: rL */
    public C8235ad mo18033rL(boolean z) {
        AppMethodBeat.m2504i(122534);
        C8235ad c16492o = new C16492o(this.BJm, this.BiC, this.BeP, z);
        AppMethodBeat.m2505o(122534);
        return c16492o;
    }

    private /* synthetic */ C16492o(C17313an c17313an, C31746h c31746h) {
        this(c17313an, c31746h, C17115v.AUP, false);
        AppMethodBeat.m2504i(122537);
        AppMethodBeat.m2505o(122537);
    }
}
