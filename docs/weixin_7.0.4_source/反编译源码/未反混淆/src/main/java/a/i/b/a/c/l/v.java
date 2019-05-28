package a.i.b.a.c.l;

import a.i.b.a.c.a.g;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.i.e.h;
import a.i.b.a.c.i.e.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class v implements an {
    static final /* synthetic */ boolean $assertionsDisabled = (!v.class.desiredAssertionStatus());
    public final Set<w> BJH;
    private final int aBR;

    static {
        AppMethodBeat.i(122604);
        AppMethodBeat.o(122604);
    }

    public v(Collection<w> collection) {
        AppMethodBeat.i(122598);
        if ($assertionsDisabled || !collection.isEmpty()) {
            this.BJH = new LinkedHashSet(collection);
            this.aBR = this.BJH.hashCode();
            AppMethodBeat.o(122598);
            return;
        }
        AssertionError assertionError = new AssertionError("Attempt to create an empty intersection");
        AppMethodBeat.o(122598);
        throw assertionError;
    }

    public final List<ar> getParameters() {
        AppMethodBeat.i(122599);
        List emptyList = Collections.emptyList();
        AppMethodBeat.o(122599);
        return emptyList;
    }

    public final Collection<w> eap() {
        return this.BJH;
    }

    public final h ekm() {
        AppMethodBeat.i(122600);
        h a = m.a("member scope for intersection type ".concat(String.valueOf(this)), this.BJH);
        AppMethodBeat.o(122600);
        return a;
    }

    public final boolean dYu() {
        return false;
    }

    public final a.i.b.a.c.b.h dYs() {
        return null;
    }

    public final g dZD() {
        AppMethodBeat.i(122601);
        g dZD = ((w) this.BJH.iterator().next()).ejw().dZD();
        AppMethodBeat.o(122601);
        return dZD;
    }

    public String toString() {
        AppMethodBeat.i(122602);
        Set set = this.BJH;
        StringBuilder stringBuilder = new StringBuilder("{");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            stringBuilder.append(((w) it.next()).toString());
            if (it.hasNext()) {
                stringBuilder.append(" & ");
            }
        }
        stringBuilder.append("}");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(122602);
        return stringBuilder2;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(122603);
        if (this == obj) {
            AppMethodBeat.o(122603);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(122603);
            return false;
        } else {
            v vVar = (v) obj;
            if (this.BJH == null ? vVar.BJH != null : !this.BJH.equals(vVar.BJH)) {
                AppMethodBeat.o(122603);
                return false;
            }
            AppMethodBeat.o(122603);
            return true;
        }
    }

    public int hashCode() {
        return this.aBR;
    }
}
