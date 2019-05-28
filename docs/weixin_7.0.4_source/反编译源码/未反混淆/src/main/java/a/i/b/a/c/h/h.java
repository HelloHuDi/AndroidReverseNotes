package a.i.b.a.c.h;

import a.a.i;
import a.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public enum h {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true);
    
    public static final Set<h> BCu = null;
    public static final Set<h> BCv = null;
    public static final a BCw = null;
    private final boolean BCt;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    private h(boolean z) {
        this.BCt = z;
    }

    static {
        BCw = new a();
        h[] values = values();
        Collection arrayList = new ArrayList();
        int length = values.length;
        int i;
        while (i < length) {
            h hVar = values[i];
            if (hVar.BCt) {
                arrayList.add(hVar);
            }
            i++;
        }
        BCu = t.o((List) arrayList);
        BCv = i.R(values());
        AppMethodBeat.o(121848);
    }
}
