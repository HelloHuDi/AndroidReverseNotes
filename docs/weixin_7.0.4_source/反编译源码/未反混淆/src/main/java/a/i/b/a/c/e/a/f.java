package a.i.b.a.c.e.a;

import a.f.b.j;
import a.i.b.a.c.g.i.c;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class f {
    public static final <M extends c<M>, T> T a(c<M> cVar, a.i.b.a.c.g.i.f<M, T> fVar) {
        AppMethodBeat.i(121081);
        j.p(cVar, "receiver$0");
        j.p(fVar, ShareConstants.MEDIA_EXTENSION);
        if (cVar.c(fVar)) {
            Object e = cVar.e(fVar);
            AppMethodBeat.o(121081);
            return e;
        }
        AppMethodBeat.o(121081);
        return null;
    }

    public static final <M extends c<M>, T> T a(c<M> cVar, a.i.b.a.c.g.i.f<M, List<T>> fVar, int i) {
        AppMethodBeat.i(121082);
        j.p(cVar, "receiver$0");
        j.p(fVar, ShareConstants.MEDIA_EXTENSION);
        if (i < cVar.d(fVar)) {
            Object a = cVar.a(fVar, i);
            AppMethodBeat.o(121082);
            return a;
        }
        AppMethodBeat.o(121082);
        return null;
    }
}
