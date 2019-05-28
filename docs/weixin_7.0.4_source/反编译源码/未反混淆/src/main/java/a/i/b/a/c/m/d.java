package a.i.b.a.c.m;

import a.f.a.b;
import a.f.b.j;
import a.i.b.a.c.b.t;
import a.i.b.a.c.f.f;
import a.k.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;

public final class d {
    public final k BLv;
    public final Collection<f> BLw;
    public final b<t, String> BLx;
    public final b[] BLy;
    public final f BgZ;

    private d(f fVar, k kVar, Collection<f> collection, b<? super t, String> bVar, b... bVarArr) {
        this.BgZ = fVar;
        this.BLv = kVar;
        this.BLw = collection;
        this.BLx = bVar;
        this.BLy = bVarArr;
    }

    public d(f fVar, b[] bVarArr, b<? super t, String> bVar) {
        j.p(fVar, "name");
        j.p(bVarArr, "checks");
        j.p(bVar, "additionalChecks");
        this(fVar, null, null, bVar, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        AppMethodBeat.i(122858);
        AppMethodBeat.o(122858);
    }

    private d(k kVar, b[] bVarArr, b<? super t, String> bVar) {
        j.p(kVar, "regex");
        j.p(bVarArr, "checks");
        j.p(bVar, "additionalChecks");
        this(null, kVar, null, bVar, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        AppMethodBeat.i(122860);
        AppMethodBeat.o(122860);
    }

    public d(Collection<f> collection, b[] bVarArr, b<? super t, String> bVar) {
        j.p(collection, "nameList");
        j.p(bVarArr, "checks");
        j.p(bVar, "additionalChecks");
        this(null, null, collection, bVar, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        AppMethodBeat.i(122862);
        AppMethodBeat.o(122862);
    }
}
