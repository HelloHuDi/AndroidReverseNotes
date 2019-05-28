package a.i.b.a.c.m;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class c {
    public final boolean cxT;

    public static final class c extends c {
        public static final c BLu = new c();

        static {
            AppMethodBeat.i(122851);
            AppMethodBeat.o(122851);
        }

        private c() {
            super(true, (byte) 0);
        }
    }

    public static final class a extends c {
        public static final a BLt = new a();

        static {
            AppMethodBeat.i(122849);
            AppMethodBeat.o(122849);
        }

        private a() {
            super(false, (byte) 0);
        }
    }

    public static final class b extends c {
        private final String error;

        public b(String str) {
            j.p(str, "error");
            super(false, (byte) 0);
            AppMethodBeat.i(122850);
            this.error = str;
            AppMethodBeat.o(122850);
        }
    }

    private c(boolean z) {
        this.cxT = z;
    }

    public /* synthetic */ c(boolean z, byte b) {
        this(z);
    }
}
