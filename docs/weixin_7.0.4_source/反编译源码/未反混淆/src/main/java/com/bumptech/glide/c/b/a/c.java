package com.bumptech.glide.c.b.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

final class c implements l {
    private final b aCq = new b();
    private final h<a, Bitmap> aCr = new h();

    static class b extends d<a> {
        b() {
        }

        /* Access modifiers changed, original: final */
        public final a g(int i, int i2, Config config) {
            AppMethodBeat.i(91900);
            a aVar = (a) mS();
            aVar.f(i, i2, config);
            AppMethodBeat.o(91900);
            return aVar;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ m mR() {
            AppMethodBeat.i(91901);
            a aVar = new a(this);
            AppMethodBeat.o(91901);
            return aVar;
        }
    }

    static class a implements m {
        private final b aCs;
        private Config aCt;
        private int height;
        private int width;

        public a(b bVar) {
            this.aCs = bVar;
        }

        public final void f(int i, int i2, Config config) {
            this.width = i;
            this.height = i2;
            this.aCt = config;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.width == aVar.width && this.height == aVar.height && this.aCt == aVar.aCt) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(91897);
            int hashCode = (this.aCt != null ? this.aCt.hashCode() : 0) + (((this.width * 31) + this.height) * 31);
            AppMethodBeat.o(91897);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(91898);
            String e = c.e(this.width, this.height, this.aCt);
            AppMethodBeat.o(91898);
            return e;
        }

        public final void mQ() {
            AppMethodBeat.i(91899);
            this.aCs.a(this);
            AppMethodBeat.o(91899);
        }
    }

    c() {
        AppMethodBeat.i(91902);
        AppMethodBeat.o(91902);
    }

    public final void g(Bitmap bitmap) {
        AppMethodBeat.i(91903);
        this.aCr.a(this.aCq.g(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
        AppMethodBeat.o(91903);
    }

    public final Bitmap c(int i, int i2, Config config) {
        AppMethodBeat.i(91904);
        Bitmap bitmap = (Bitmap) this.aCr.b(this.aCq.g(i, i2, config));
        AppMethodBeat.o(91904);
        return bitmap;
    }

    public final Bitmap mP() {
        AppMethodBeat.i(91905);
        Bitmap bitmap = (Bitmap) this.aCr.removeLast();
        AppMethodBeat.o(91905);
        return bitmap;
    }

    public final String d(int i, int i2, Config config) {
        AppMethodBeat.i(91907);
        String e = e(i, i2, config);
        AppMethodBeat.o(91907);
        return e;
    }

    public final int i(Bitmap bitmap) {
        AppMethodBeat.i(91908);
        int k = j.k(bitmap);
        AppMethodBeat.o(91908);
        return k;
    }

    public final String toString() {
        AppMethodBeat.i(91909);
        String str = "AttributeStrategy:\n  " + this.aCr;
        AppMethodBeat.o(91909);
        return str;
    }

    static String e(int i, int i2, Config config) {
        AppMethodBeat.i(91910);
        String str = "[" + i + VideoMaterialUtil.CRAZYFACE_X + i2 + "], " + config;
        AppMethodBeat.o(91910);
        return str;
    }

    public final String h(Bitmap bitmap) {
        AppMethodBeat.i(91906);
        String e = e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        AppMethodBeat.o(91906);
        return e;
    }
}
