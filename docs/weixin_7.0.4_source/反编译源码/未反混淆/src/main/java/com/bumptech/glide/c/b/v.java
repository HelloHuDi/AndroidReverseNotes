package com.bumptech.glide.c.b;

import com.bumptech.glide.c.a.d.a;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.List;

final class v implements a<Object>, e {
    private File aAa;
    private int aCg = -1;
    private w aCh;
    private final f<?> azT;
    private final e.a azU;
    private int azV;
    private h azW;
    private List<n<File, ?>> azX;
    private int azY;
    private volatile n.a<?> azZ;

    v(f<?> fVar, e.a aVar) {
        this.azT = fVar;
        this.azU = aVar;
    }

    public final boolean mk() {
        AppMethodBeat.i(91877);
        List mp = this.azT.mp();
        if (mp.isEmpty()) {
            AppMethodBeat.o(91877);
            return false;
        }
        f fVar = this.azT;
        List b = fVar.awi.awj.b(fVar.axb.getClass(), fVar.aAf, fVar.awY);
        if (b.isEmpty() && File.class.equals(this.azT.awY)) {
            AppMethodBeat.o(91877);
            return false;
        }
        while (true) {
            if (this.azX == null || !ml()) {
                this.aCg++;
                if (this.aCg >= b.size()) {
                    this.azV++;
                    if (this.azV >= mp.size()) {
                        AppMethodBeat.o(91877);
                        return false;
                    }
                    this.aCg = 0;
                }
                h hVar = (h) mp.get(this.azV);
                Class cls = (Class) b.get(this.aCg);
                this.aCh = new w(this.azT.awi.awk, hVar, this.azT.aAb, this.azT.width, this.azT.height, this.azT.n(cls), cls, this.azT.aAd);
                this.aAa = this.azT.mn().a(this.aCh);
                if (this.aAa != null) {
                    this.azW = hVar;
                    this.azX = this.azT.n(this.aAa);
                    this.azY = 0;
                }
            } else {
                this.azZ = null;
                boolean z = false;
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
                AppMethodBeat.o(91877);
                return z;
            }
        }
    }

    private boolean ml() {
        AppMethodBeat.i(91878);
        if (this.azY < this.azX.size()) {
            AppMethodBeat.o(91878);
            return true;
        }
        AppMethodBeat.o(91878);
        return false;
    }

    public final void cancel() {
        AppMethodBeat.i(91879);
        n.a aVar = this.azZ;
        if (aVar != null) {
            aVar.aEq.cancel();
        }
        AppMethodBeat.o(91879);
    }

    public final void S(Object obj) {
        AppMethodBeat.i(91880);
        this.azU.a(this.azW, obj, this.azZ.aEq, com.bumptech.glide.c.a.RESOURCE_DISK_CACHE, this.aCh);
        AppMethodBeat.o(91880);
    }

    public final void b(Exception exception) {
        AppMethodBeat.i(91881);
        this.azU.a(this.aCh, exception, this.azZ.aEq, com.bumptech.glide.c.a.RESOURCE_DISK_CACHE);
        AppMethodBeat.o(91881);
    }
}
