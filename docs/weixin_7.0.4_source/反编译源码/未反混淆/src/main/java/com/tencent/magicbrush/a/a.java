package com.tencent.magicbrush.a;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static a bSA = new a() {
        public final int n(String str, int i) {
            return 0;
        }

        public final Drawable o(String str, int i) {
            return null;
        }
    };

    public interface a {
        int n(String str, int i);

        Drawable o(String str, int i);
    }

    static {
        AppMethodBeat.i(115854);
        AppMethodBeat.o(115854);
    }

    public static void a(a aVar) {
        bSA = aVar;
    }

    public static a yA() {
        return bSA;
    }
}
