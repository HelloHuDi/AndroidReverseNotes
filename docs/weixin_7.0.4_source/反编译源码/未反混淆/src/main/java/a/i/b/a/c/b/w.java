package a.i.b.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum w {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;
    
    public static final a BeG = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static w an(boolean z, boolean z2) {
            if (z) {
                return w.ABSTRACT;
            }
            if (z2) {
                return w.OPEN;
            }
            return w.FINAL;
        }
    }

    static {
        BeG = new a();
        AppMethodBeat.o(119276);
    }
}
