package com.bumptech.glide.c.b;

import android.util.Log;
import com.bumptech.glide.c.a.d.a;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.d;
import com.bumptech.glide.h;
import com.bumptech.glide.h.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class y implements a<Object>, e, e.a {
    private int aCm;
    private b aCn;
    private Object aCo;
    private c aCp;
    private final f<?> azT;
    private final e.a azU;
    private volatile n.a<?> azZ;

    y(f<?> fVar, e.a aVar) {
        this.azT = fVar;
        this.azU = aVar;
    }

    public final boolean mk() {
        Object obj;
        AppMethodBeat.i(91890);
        if (this.aCo != null) {
            obj = this.aCo;
            this.aCo = null;
            long ok = e.ok();
            try {
                d u = this.azT.awi.awj.awN.u(obj.getClass());
                if (u != null) {
                    d dVar = new d(u, obj, this.azT.aAd);
                    this.aCp = new c(this.azZ.azW, this.azT.aAb);
                    this.azT.mn().a(this.aCp, dVar);
                    if (Log.isLoggable("SourceGenerator", 2)) {
                        new StringBuilder("Finished encoding source to cache, key: ").append(this.aCp).append(", data: ").append(obj).append(", encoder: ").append(u).append(", duration: ").append(e.q(ok));
                    }
                    this.azZ.aEq.cleanup();
                    this.aCn = new b(Collections.singletonList(this.azZ.azW), this.azT, this);
                } else {
                    h.e eVar = new h.e(obj.getClass());
                    AppMethodBeat.o(91890);
                    throw eVar;
                }
            } catch (Throwable th) {
                this.azZ.aEq.cleanup();
                AppMethodBeat.o(91890);
            }
        }
        if (this.aCn == null || !this.aCn.mk()) {
            this.aCn = null;
            this.azZ = null;
            boolean z = false;
            while (!z) {
                if (this.aCm < this.azT.mo().size()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    break;
                }
                List mo = this.azT.mo();
                int i = this.aCm;
                this.aCm = i + 1;
                this.azZ = (n.a) mo.get(i);
                if (this.azZ != null && (this.azT.aAl.a(this.azZ.aEq.mh()) || this.azT.l(this.azZ.aEq.mg()))) {
                    this.azZ.aEq.a(this.azT.aAk, this);
                    z = true;
                }
            }
            AppMethodBeat.o(91890);
            return z;
        }
        AppMethodBeat.o(91890);
        return true;
    }

    public final void cancel() {
        AppMethodBeat.i(91891);
        n.a aVar = this.azZ;
        if (aVar != null) {
            aVar.aEq.cancel();
        }
        AppMethodBeat.o(91891);
    }

    public final void S(Object obj) {
        AppMethodBeat.i(91892);
        i iVar = this.azT.aAl;
        if (obj == null || !iVar.a(this.azZ.aEq.mh())) {
            this.azU.a(this.azZ.azW, obj, this.azZ.aEq, this.azZ.aEq.mh(), this.aCp);
            AppMethodBeat.o(91892);
            return;
        }
        this.aCo = obj;
        this.azU.mm();
        AppMethodBeat.o(91892);
    }

    public final void b(Exception exception) {
        AppMethodBeat.i(91893);
        this.azU.a(this.aCp, exception, this.azZ.aEq, this.azZ.aEq.mh());
        AppMethodBeat.o(91893);
    }

    public final void mm() {
        AppMethodBeat.i(91894);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(91894);
        throw unsupportedOperationException;
    }

    public final void a(com.bumptech.glide.c.h hVar, Object obj, com.bumptech.glide.c.a.d<?> dVar, com.bumptech.glide.c.a aVar, com.bumptech.glide.c.h hVar2) {
        AppMethodBeat.i(91895);
        this.azU.a(hVar, obj, dVar, this.azZ.aEq.mh(), hVar);
        AppMethodBeat.o(91895);
    }

    public final void a(com.bumptech.glide.c.h hVar, Exception exception, com.bumptech.glide.c.a.d<?> dVar, com.bumptech.glide.c.a aVar) {
        AppMethodBeat.i(91896);
        this.azU.a(hVar, exception, dVar, this.azZ.aEq.mh());
        AppMethodBeat.o(91896);
    }
}
