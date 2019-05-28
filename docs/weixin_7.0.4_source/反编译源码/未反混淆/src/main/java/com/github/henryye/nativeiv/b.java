package com.github.henryye.nativeiv;

import android.graphics.Bitmap.Config;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

public final class b {
    private static final Object aLS = new Object();
    public BitmapType aLT = null;
    public IBitmap aLU = new a();
    public com.github.henryye.nativeiv.a.a aLV;
    public a aLW;

    static class b implements IBitmap<NativeBitmapStruct> {
        b() {
        }

        public final /* bridge */ /* synthetic */ Object provide() {
            return null;
        }

        public final BitmapType getType() {
            return BitmapType.Native;
        }

        public final long getDecodeTime() {
            return 0;
        }

        public final void recycle() {
        }

        public final void decodeInputStream(InputStream inputStream, Config config, c cVar) {
            AppMethodBeat.i(115746);
            if (inputStream == null) {
                IOException iOException = new IOException("Null input stream");
                AppMethodBeat.o(115746);
                throw iOException;
            }
            AppMethodBeat.o(115746);
        }
    }

    static class a implements IBitmap<Object> {
        a() {
        }

        public final BitmapType getType() {
            return BitmapType.Undefined;
        }

        public final void decodeInputStream(InputStream inputStream, Config config, c cVar) {
            AppMethodBeat.i(115745);
            IOException iOException = new IOException("Stub");
            AppMethodBeat.o(115745);
            throw iOException;
        }

        public final long getDecodeTime() {
            return 0;
        }

        public final Object provide() {
            return null;
        }

        public final void recycle() {
        }
    }

    static {
        AppMethodBeat.i(115749);
        AppMethodBeat.o(115749);
    }

    public b(a aVar) {
        AppMethodBeat.i(115747);
        this.aLW = aVar;
        AppMethodBeat.o(115747);
    }

    /* Access modifiers changed, original: final */
    public final BitmapType pA() {
        AppMethodBeat.i(115748);
        BitmapType type;
        if (this.aLU != null) {
            type = this.aLU.getType();
            AppMethodBeat.o(115748);
            return type;
        }
        type = BitmapType.Undefined;
        AppMethodBeat.o(115748);
        return type;
    }
}
