package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C8207m;

/* renamed from: a.i.b.a.c.l.v */
public class C37059v implements C17313an {
    static final /* synthetic */ boolean $assertionsDisabled = (!C37059v.class.desiredAssertionStatus());
    public final Set<C46867w> BJH;
    private final int aBR;

    static {
        AppMethodBeat.m2504i(122604);
        AppMethodBeat.m2505o(122604);
    }

    public C37059v(Collection<C46867w> collection) {
        AppMethodBeat.m2504i(122598);
        if ($assertionsDisabled || !collection.isEmpty()) {
            this.BJH = new LinkedHashSet(collection);
            this.aBR = this.BJH.hashCode();
            AppMethodBeat.m2505o(122598);
            return;
        }
        AssertionError assertionError = new AssertionError("Attempt to create an empty intersection");
        AppMethodBeat.m2505o(122598);
        throw assertionError;
    }

    public final List<C36955ar> getParameters() {
        AppMethodBeat.m2504i(122599);
        List emptyList = Collections.emptyList();
        AppMethodBeat.m2505o(122599);
        return emptyList;
    }

    public final Collection<C46867w> eap() {
        return this.BJH;
    }

    public final C31746h ekm() {
        AppMethodBeat.m2504i(122600);
        C31746h a = C8207m.m14504a("member scope for intersection type ".concat(String.valueOf(this)), this.BJH);
        AppMethodBeat.m2505o(122600);
        return a;
    }

    public final boolean dYu() {
        return false;
    }

    public final C0036h dYs() {
        return null;
    }

    public final C31619g dZD() {
        AppMethodBeat.m2504i(122601);
        C31619g dZD = ((C46867w) this.BJH.iterator().next()).ejw().dZD();
        AppMethodBeat.m2505o(122601);
        return dZD;
    }

    public String toString() {
        AppMethodBeat.m2504i(122602);
        Set set = this.BJH;
        StringBuilder stringBuilder = new StringBuilder("{");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            stringBuilder.append(((C46867w) it.next()).toString());
            if (it.hasNext()) {
                stringBuilder.append(" & ");
            }
        }
        stringBuilder.append("}");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(122602);
        return stringBuilder2;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(122603);
        if (this == obj) {
            AppMethodBeat.m2505o(122603);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(122603);
            return false;
        } else {
            C37059v c37059v = (C37059v) obj;
            if (this.BJH == null ? c37059v.BJH != null : !this.BJH.equals(c37059v.BJH)) {
                AppMethodBeat.m2505o(122603);
                return false;
            }
            AppMethodBeat.m2505o(122603);
            return true;
        }
    }

    public int hashCode() {
        return this.aBR;
    }
}
