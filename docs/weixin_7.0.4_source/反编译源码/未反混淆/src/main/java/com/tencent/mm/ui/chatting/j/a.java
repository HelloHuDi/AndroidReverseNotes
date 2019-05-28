package com.tencent.mm.ui.chatting.j;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static final a yZE = new a();
    public int[] yZF = new int[]{0, 0, 0, 0, 0};

    /* renamed from: com.tencent.mm.ui.chatting.j.a$1 */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] yZG = new int[com.tencent.mm.ui.chatting.f.d.a.values().length];

        static {
            AppMethodBeat.i(32664);
            try {
                yZG[com.tencent.mm.ui.chatting.f.d.a.ACTION_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                yZG[com.tencent.mm.ui.chatting.f.d.a.ACTION_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                yZG[com.tencent.mm.ui.chatting.f.d.a.ACTION_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                yZG[com.tencent.mm.ui.chatting.f.d.a.ACTION_POSITION.ordinal()] = 4;
                AppMethodBeat.o(32664);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.o(32664);
            }
        }
    }

    public a() {
        AppMethodBeat.i(32665);
        AppMethodBeat.o(32665);
    }

    static {
        AppMethodBeat.i(32666);
        AppMethodBeat.o(32666);
    }
}
