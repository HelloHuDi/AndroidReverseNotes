package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public interface i {

    public interface a {
        void a(w wVar, Object obj);
    }

    public static final class b {
        public static final b bhp = new b(-1, -1, -1);
        public final int bhq;
        public final int bhr;
        public final int bhs;

        static {
            AppMethodBeat.i(95514);
            AppMethodBeat.o(95514);
        }

        public b(int i) {
            this(i, -1, -1);
        }

        public b(int i, int i2, int i3) {
            this.bhq = i;
            this.bhr = i2;
            this.bhs = i3;
        }

        public final b em(int i) {
            AppMethodBeat.i(95512);
            if (this.bhq == i) {
                AppMethodBeat.o(95512);
                return this;
            }
            b bVar = new b(i, this.bhr, this.bhs);
            AppMethodBeat.o(95512);
            return bVar;
        }

        public final boolean sh() {
            return this.bhr != -1;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(95513);
            if (this == obj) {
                AppMethodBeat.o(95513);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.o(95513);
                return false;
            } else {
                b bVar = (b) obj;
                if (this.bhq == bVar.bhq && this.bhr == bVar.bhr && this.bhs == bVar.bhs) {
                    AppMethodBeat.o(95513);
                    return true;
                }
                AppMethodBeat.o(95513);
                return false;
            }
        }

        public final int hashCode() {
            return ((((this.bhq + JsApiGetABTestConfig.CTRL_INDEX) * 31) + this.bhr) * 31) + this.bhs;
        }
    }

    h a(b bVar, com.google.android.exoplayer2.h.b bVar2);

    void a(f fVar, a aVar);

    void b(h hVar);

    void rX();

    void rY();
}
