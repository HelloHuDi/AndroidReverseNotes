package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.c.b.a.e;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.k;
import com.bumptech.glide.h.d;
import com.bumptech.glide.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

public final class o implements k<InputStream, Bitmap> {
    private final h aEV;
    private final b azx;

    static class a implements com.bumptech.glide.c.d.a.h.a {
        private final d aFD;
        private final m azw;

        a(m mVar, d dVar) {
            this.azw = mVar;
            this.aFD = dVar;
        }

        public final void ns() {
            AppMethodBeat.i(92261);
            this.azw.nw();
            AppMethodBeat.o(92261);
        }

        public final void a(e eVar, Bitmap bitmap) {
            AppMethodBeat.i(92262);
            IOException iOException = this.aFD.aIa;
            if (iOException != null) {
                if (bitmap != null) {
                    eVar.g(bitmap);
                }
                AppMethodBeat.o(92262);
                throw iOException;
            }
            AppMethodBeat.o(92262);
        }
    }

    public o(h hVar, b bVar) {
        this.aEV = hVar;
        this.azx = bVar;
    }

    private u<Bitmap> a(InputStream inputStream, int i, int i2, j jVar) {
        Object obj;
        AppMethodBeat.i(92263);
        if (inputStream instanceof m) {
            inputStream = (m) inputStream;
            obj = null;
        } else {
            int obj2 = 1;
            inputStream = new m(inputStream, this.azx);
        }
        d e = d.e(inputStream);
        try {
            u<Bitmap> a = this.aEV.a(new g(e), i, i2, jVar, new a(inputStream, e));
            return a;
        } finally {
            e.release();
            if (obj2 != null) {
                inputStream.release();
            }
            AppMethodBeat.o(92263);
        }
    }

    public final /* bridge */ /* synthetic */ boolean a(Object obj, j jVar) {
        return true;
    }
}
