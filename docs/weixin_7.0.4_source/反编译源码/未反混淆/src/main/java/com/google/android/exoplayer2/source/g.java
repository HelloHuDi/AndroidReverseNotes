package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.source.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class g implements c, i {
    private final com.google.android.exoplayer2.w.a aMW;
    private final int bgC;
    private final a bgD;
    private final String bgG;
    private com.google.android.exoplayer2.source.i.a bgz;
    private final com.google.android.exoplayer2.h.f.a bhk;
    private final h bhl;
    private final int bhm;
    private long bhn;
    private boolean bho;
    private final Handler eventHandler;
    private final Uri uri;

    public interface a {
        void onLoadError(IOException iOException);
    }

    public g(Uri uri, com.google.android.exoplayer2.h.f.a aVar, h hVar) {
        this(uri, aVar, hVar, (byte) 0);
    }

    private g(Uri uri, com.google.android.exoplayer2.h.f.a aVar, h hVar, byte b) {
        this(uri, aVar, hVar, 0);
    }

    private g(Uri uri, com.google.android.exoplayer2.h.f.a aVar, h hVar, char c) {
        AppMethodBeat.i(95506);
        this.uri = uri;
        this.bhk = aVar;
        this.bhl = hVar;
        this.bgC = -1;
        this.eventHandler = null;
        this.bgD = null;
        this.bgG = null;
        this.bhm = 1048576;
        this.aMW = new com.google.android.exoplayer2.w.a();
        AppMethodBeat.o(95506);
    }

    public final void a(f fVar, com.google.android.exoplayer2.source.i.a aVar) {
        AppMethodBeat.i(95507);
        this.bgz = aVar;
        f(-9223372036854775807L, false);
        AppMethodBeat.o(95507);
    }

    public final void rX() {
    }

    public final h a(b bVar, com.google.android.exoplayer2.h.b bVar2) {
        AppMethodBeat.i(95508);
        com.google.android.exoplayer2.i.a.checkArgument(bVar.bhq == 0);
        f fVar = new f(this.uri, this.bhk.tm(), this.bhl.ra(), this.bgC, this.eventHandler, this.bgD, this, bVar2, this.bgG, this.bhm);
        AppMethodBeat.o(95508);
        return fVar;
    }

    public final void b(h hVar) {
        AppMethodBeat.i(95509);
        f fVar = (f) hVar;
        boolean a = fVar.bgI.a(fVar);
        if (fVar.prepared && !a) {
            for (k sq : fVar.bgO) {
                sq.sq();
            }
        }
        fVar.handler.removeCallbacksAndMessages(null);
        fVar.released = true;
        AppMethodBeat.o(95509);
    }

    public final void rY() {
        this.bgz = null;
    }

    public final void e(long j, boolean z) {
        AppMethodBeat.i(95510);
        if (j == -9223372036854775807L) {
            j = this.bhn;
        }
        if (!(this.bhn == j && this.bho == z) && (this.bhn == -9223372036854775807L || j != -9223372036854775807L)) {
            f(j, z);
            AppMethodBeat.o(95510);
            return;
        }
        AppMethodBeat.o(95510);
    }

    private void f(long j, boolean z) {
        AppMethodBeat.i(95511);
        this.bhn = j;
        this.bho = z;
        this.bgz.a(new n(this.bhn, this.bho), null);
        AppMethodBeat.o(95511);
    }
}
