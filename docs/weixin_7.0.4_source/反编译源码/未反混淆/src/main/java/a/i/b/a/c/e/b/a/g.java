package a.i.b.a.c.e.b.a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class g extends a.i.b.a.c.e.a.a {
    public static final g Byu = new g(1, 1, 13);
    public static final g Byv = new g(new int[0]);
    public static final a Byw = new a();
    private final boolean Byt;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public g(int[] iArr, boolean z) {
        j.p(iArr, "versionArray");
        super(Arrays.copyOf(iArr, iArr.length));
        AppMethodBeat.i(121319);
        this.Byt = z;
        AppMethodBeat.o(121319);
    }

    public g(int... iArr) {
        j.p(iArr, "numbers");
        this(iArr, false);
        AppMethodBeat.i(121320);
        AppMethodBeat.o(121320);
    }

    static {
        AppMethodBeat.i(121321);
        AppMethodBeat.o(121321);
    }

    public final boolean ehy() {
        AppMethodBeat.i(121318);
        if (!(this.major == 1 && this.minor == 0)) {
            Object obj;
            int obj2;
            if (this.Byt) {
                a.i.b.a.c.e.a.a aVar = Byu;
                j.p(aVar, "ourVersion");
                if (this.major == 0) {
                    obj2 = (aVar.major == 0 && this.minor == aVar.minor) ? 1 : null;
                } else if (this.major != aVar.major || this.minor > aVar.minor) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
            } else if (this.major != 1 || this.minor > 4) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                AppMethodBeat.o(121318);
                return true;
            }
        }
        AppMethodBeat.o(121318);
        return false;
    }
}
