package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import p000a.p005f.p006a.C17126b;
import p000a.p010i.p011b.p012a.p015c.p018b.C17157ap;
import p000a.p010i.p011b.p012a.p015c.p018b.C17157ap.C17158a;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p044k.C17299b;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C25239y;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.b.c.ah */
public final class C31634ah extends C41403e {
    private final C17126b<C46867w, Void> Bjt = null;
    private final List<C46867w> Bju = new ArrayList(1);
    private boolean initialized = false;

    /* renamed from: a */
    public static C36955ar m51154a(C31642l c31642l, C0026g c0026g, C0163ba c0163ba, C37022f c37022f, int i) {
        AppMethodBeat.m2504i(119609);
        C31634ah a = C31634ah.m51155a(c31642l, c0026g, false, c0163ba, c37022f, i, C41398am.BeR);
        a.mo51626L(C41434a.m72275G(c31642l).dXN());
        a.setInitialized();
        AppMethodBeat.m2505o(119609);
        return a;
    }

    /* renamed from: a */
    public static C31634ah m51155a(C31642l c31642l, C0026g c0026g, boolean z, C0163ba c0163ba, C37022f c37022f, int i, C41398am c41398am) {
        AppMethodBeat.m2504i(119610);
        C31634ah a = C31634ah.m51156a(c31642l, c0026g, z, c0163ba, c37022f, i, c41398am, C17158a.BeT);
        AppMethodBeat.m2505o(119610);
        return a;
    }

    /* renamed from: a */
    private static C31634ah m51156a(C31642l c31642l, C0026g c0026g, boolean z, C0163ba c0163ba, C37022f c37022f, int i, C41398am c41398am, C17157ap c17157ap) {
        AppMethodBeat.m2504i(119611);
        C31634ah c31634ah = new C31634ah(c31642l, c0026g, z, c0163ba, c37022f, i, c41398am, c17157ap);
        AppMethodBeat.m2505o(119611);
        return c31634ah;
    }

    private C31634ah(C31642l c31642l, C0026g c0026g, boolean z, C0163ba c0163ba, C37022f c37022f, int i, C41398am c41398am, C17157ap c17157ap) {
        super(C17299b.BIH, c31642l, c0026g, c37022f, c0163ba, z, i, c41398am, c17157ap);
        AppMethodBeat.m2504i(119612);
        AppMethodBeat.m2505o(119612);
    }

    private void eaN() {
        AppMethodBeat.m2504i(119613);
        if (this.initialized) {
            IllegalStateException illegalStateException = new IllegalStateException("Type parameter descriptor is already initialized: " + eaO());
            AppMethodBeat.m2505o(119613);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(119613);
    }

    private String eaO() {
        AppMethodBeat.m2504i(119614);
        String str = this.BgZ + " declared in " + C8203d.m14486n(dXW());
        AppMethodBeat.m2505o(119614);
        return str;
    }

    public final void setInitialized() {
        AppMethodBeat.m2504i(119615);
        eaN();
        this.initialized = true;
        AppMethodBeat.m2505o(119615);
    }

    /* renamed from: L */
    public final void mo51626L(C46867w c46867w) {
        AppMethodBeat.m2504i(119616);
        eaN();
        m51153M(c46867w);
        AppMethodBeat.m2505o(119616);
    }

    /* renamed from: M */
    private void m51153M(C46867w c46867w) {
        AppMethodBeat.m2504i(119617);
        if (C25239y.m39807an(c46867w)) {
            AppMethodBeat.m2505o(119617);
            return;
        }
        this.Bju.add(c46867w);
        AppMethodBeat.m2505o(119617);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: J */
    public final void mo101J(C46867w c46867w) {
        AppMethodBeat.m2504i(119618);
        if (this.Bjt == null) {
            AppMethodBeat.m2505o(119618);
            return;
        }
        this.Bjt.mo50am(c46867w);
        AppMethodBeat.m2505o(119618);
    }

    /* Access modifiers changed, original: protected|final */
    public final List<C46867w> eaq() {
        AppMethodBeat.m2504i(119619);
        if (this.initialized) {
            List list = this.Bju;
            AppMethodBeat.m2505o(119619);
            return list;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Type parameter descriptor is not initialized: " + eaO());
        AppMethodBeat.m2505o(119619);
        throw illegalStateException;
    }
}
