package com.bumptech.glide.c.b.b;

import android.util.Log;
import com.bumptech.glide.a.a;
import com.bumptech.glide.a.a.d;
import com.bumptech.glide.c.b.b.a.b;
import com.bumptech.glide.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public final class e implements a {
    private final j aDe;
    private final c aDf = new c();
    private a aDg;
    private final long axz;
    private final File directory;

    @Deprecated
    e(File file, long j) {
        AppMethodBeat.i(91981);
        this.directory = file;
        this.axz = j;
        this.aDe = new j();
        AppMethodBeat.o(91981);
    }

    private synchronized a mX() {
        a aVar;
        AppMethodBeat.i(91982);
        if (this.aDg == null) {
            this.aDg = a.a(this.directory, this.axz);
        }
        aVar = this.aDg;
        AppMethodBeat.o(91982);
        return aVar;
    }

    public final File a(h hVar) {
        AppMethodBeat.i(91983);
        String c = this.aDe.c(hVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            new StringBuilder("Get: Obtained: ").append(c).append(" for for Key: ").append(hVar);
        }
        File file = null;
        try {
            d X = mX().X(c);
            if (X != null) {
                file = X.files[0];
            }
        } catch (IOException e) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
        }
        AppMethodBeat.o(91983);
        return file;
    }

    public final void a(h hVar, b bVar) {
        a aVar;
        AppMethodBeat.i(91984);
        String c = this.aDe.c(hVar);
        c cVar = this.aDf;
        synchronized (cVar) {
            try {
                aVar = (a) cVar.aCX.get(c);
                if (aVar == null) {
                    aVar = cVar.aCY.mV();
                    cVar.aCX.put(c, aVar);
                }
                aVar.aDa++;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(91984);
            }
        }
        aVar.aCZ.lock();
        a.b Y;
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                new StringBuilder("Put: Obtained: ").append(c).append(" for for Key: ").append(hVar);
            }
            a mX = mX();
            if (mX.X(c) != null) {
                this.aDf.release(c);
                return;
            }
            Y = mX.Y(c);
            if (Y == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Had two simultaneous puts for: ".concat(String.valueOf(c)));
                AppMethodBeat.o(91984);
                throw illegalStateException;
            }
            if (bVar.m(Y.lP())) {
                a.a(a.this, Y, true);
                Y.axK = true;
            }
            Y.lQ();
            this.aDf.release(c);
            AppMethodBeat.o(91984);
        } catch (IOException e) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
        } catch (Throwable th) {
            this.aDf.release(c);
            AppMethodBeat.o(91984);
        }
    }
}
