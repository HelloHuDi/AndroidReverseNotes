package com.bumptech.glide.c.b;

import com.bumptech.glide.c.a.d.a;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.List;

final class b implements a<Object>, e {
    private File aAa;
    private final List<h> azS;
    private final f<?> azT;
    private final e.a azU;
    private int azV;
    private h azW;
    private List<n<File, ?>> azX;
    private int azY;
    private volatile n.a<?> azZ;

    b(f<?> fVar, e.a aVar) {
        this(fVar.mp(), fVar, aVar);
        AppMethodBeat.i(91752);
        AppMethodBeat.o(91752);
    }

    b(List<h> list, f<?> fVar, e.a aVar) {
        this.azV = -1;
        this.azS = list;
        this.azT = fVar;
        this.azU = aVar;
    }

    public final boolean mk() {
        boolean z = false;
        AppMethodBeat.i(91753);
        while (true) {
            if (this.azX == null || !ml()) {
                this.azV++;
                if (this.azV >= this.azS.size()) {
                    AppMethodBeat.o(91753);
                    break;
                }
                h hVar = (h) this.azS.get(this.azV);
                this.aAa = this.azT.mn().a(new c(hVar, this.azT.aAb));
                if (this.aAa != null) {
                    this.azW = hVar;
                    this.azX = this.azT.n(this.aAa);
                    this.azY = 0;
                }
            } else {
                this.azZ = null;
                while (!z && ml()) {
                    boolean z2;
                    List list = this.azX;
                    int i = this.azY;
                    this.azY = i + 1;
                    this.azZ = ((n) list.get(i)).b(this.aAa, this.azT.width, this.azT.height, this.azT.aAd);
                    if (this.azZ == null || !this.azT.l(this.azZ.aEq.mg())) {
                        z2 = z;
                    } else {
                        z2 = true;
                        this.azZ.aEq.a(this.azT.aAk, this);
                    }
                    z = z2;
                }
                AppMethodBeat.o(91753);
            }
        }
        return z;
    }

    private boolean ml() {
        AppMethodBeat.i(91754);
        if (this.azY < this.azX.size()) {
            AppMethodBeat.o(91754);
            return true;
        }
        AppMethodBeat.o(91754);
        return false;
    }

    public final void cancel() {
        AppMethodBeat.i(91755);
        n.a aVar = this.azZ;
        if (aVar != null) {
            aVar.aEq.cancel();
        }
        AppMethodBeat.o(91755);
    }

    public final void S(Object obj) {
        AppMethodBeat.i(91756);
        this.azU.a(this.azW, obj, this.azZ.aEq, com.bumptech.glide.c.a.DATA_DISK_CACHE, this.azW);
        AppMethodBeat.o(91756);
    }

    public final void b(Exception exception) {
        AppMethodBeat.i(91757);
        this.azU.a(this.azW, exception, this.azZ.aEq, com.bumptech.glide.c.a.DATA_DISK_CACHE);
        AppMethodBeat.o(91757);
    }
}
