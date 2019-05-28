package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C17157ap;
import p000a.p010i.p011b.p012a.p015c.p018b.C17157ap.C17158a;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;

/* renamed from: a.i.b.a.c.l.e */
public final class C41453e extends C44923b implements C17313an {
    private final C46865e BGx;
    private final Collection<C46867w> BiV;
    private final List<C36955ar> parameters;

    public C41453e(C46865e c46865e, List<? extends C36955ar> list, Collection<C46867w> collection, C25212i c25212i) {
        super(c25212i);
        AppMethodBeat.m2504i(122497);
        this.BGx = c46865e;
        this.parameters = Collections.unmodifiableList(new ArrayList(list));
        this.BiV = Collections.unmodifiableCollection(collection);
        AppMethodBeat.m2505o(122497);
    }

    public final List<C36955ar> getParameters() {
        return this.parameters;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122498);
        String str = C8203d.m14486n(this.BGx).ByV;
        AppMethodBeat.m2505o(122498);
        return str;
    }

    public final boolean dYu() {
        return true;
    }

    public final C46865e dYt() {
        return this.BGx;
    }

    /* Access modifiers changed, original: protected|final */
    public final Collection<C46867w> dYr() {
        return this.BiV;
    }

    /* Access modifiers changed, original: protected|final */
    public final C17157ap dYv() {
        return C17158a.BeT;
    }

    public final /* bridge */ /* synthetic */ C0036h dYs() {
        return this.BGx;
    }
}
