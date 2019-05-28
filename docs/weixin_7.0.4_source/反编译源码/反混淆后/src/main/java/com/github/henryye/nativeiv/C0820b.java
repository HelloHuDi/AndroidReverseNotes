package com.github.henryye.nativeiv;

import android.graphics.Bitmap.Config;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.C37223c;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.github.henryye.nativeiv.p098a.C0819a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.github.henryye.nativeiv.b */
public final class C0820b {
    private static final Object aLS = new Object();
    public BitmapType aLT = null;
    public IBitmap aLU = new C0822a();
    public C0819a aLV;
    public C32016a aLW;

    /* renamed from: com.github.henryye.nativeiv.b$b */
    static class C0821b implements IBitmap<NativeBitmapStruct> {
        C0821b() {
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

        public final void decodeInputStream(InputStream inputStream, Config config, C37223c c37223c) {
            AppMethodBeat.m2504i(115746);
            if (inputStream == null) {
                IOException iOException = new IOException("Null input stream");
                AppMethodBeat.m2505o(115746);
                throw iOException;
            }
            AppMethodBeat.m2505o(115746);
        }
    }

    /* renamed from: com.github.henryye.nativeiv.b$a */
    static class C0822a implements IBitmap<Object> {
        C0822a() {
        }

        public final BitmapType getType() {
            return BitmapType.Undefined;
        }

        public final void decodeInputStream(InputStream inputStream, Config config, C37223c c37223c) {
            AppMethodBeat.m2504i(115745);
            IOException iOException = new IOException("Stub");
            AppMethodBeat.m2505o(115745);
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
        AppMethodBeat.m2504i(115749);
        AppMethodBeat.m2505o(115749);
    }

    public C0820b(C32016a c32016a) {
        AppMethodBeat.m2504i(115747);
        this.aLW = c32016a;
        AppMethodBeat.m2505o(115747);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: pA */
    public final BitmapType mo2511pA() {
        AppMethodBeat.m2504i(115748);
        BitmapType type;
        if (this.aLU != null) {
            type = this.aLU.getType();
            AppMethodBeat.m2505o(115748);
            return type;
        }
        type = BitmapType.Undefined;
        AppMethodBeat.m2505o(115748);
        return type;
    }
}
