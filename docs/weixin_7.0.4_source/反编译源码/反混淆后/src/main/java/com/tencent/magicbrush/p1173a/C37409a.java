package com.tencent.magicbrush.p1173a;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.magicbrush.a.a */
public final class C37409a {
    private static C17835a bSA = new C374081();

    /* renamed from: com.tencent.magicbrush.a.a$a */
    public interface C17835a {
        /* renamed from: n */
        int mo33009n(String str, int i);

        /* renamed from: o */
        Drawable mo33010o(String str, int i);
    }

    /* renamed from: com.tencent.magicbrush.a.a$1 */
    static class C374081 implements C17835a {
        C374081() {
        }

        /* renamed from: n */
        public final int mo33009n(String str, int i) {
            return 0;
        }

        /* renamed from: o */
        public final Drawable mo33010o(String str, int i) {
            return null;
        }
    }

    static {
        AppMethodBeat.m2504i(115854);
        AppMethodBeat.m2505o(115854);
    }

    /* renamed from: a */
    public static void m63027a(C17835a c17835a) {
        bSA = c17835a;
    }

    /* renamed from: yA */
    public static C17835a m63028yA() {
        return bSA;
    }
}
