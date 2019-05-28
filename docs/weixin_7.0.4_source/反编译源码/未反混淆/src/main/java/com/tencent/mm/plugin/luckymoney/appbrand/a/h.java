package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h {

    public enum a {
        RANDOM_LUCK(1),
        FIX_NORMAL(0);
        
        public final int bTx;

        static {
            AppMethodBeat.o(42001);
        }

        private a(int i) {
            this.bTx = i;
        }
    }
}
