package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i {
    public Typeface bTq = null;
    public boolean bTr = false;
    public a bTs;
    public float fontSize = 14.0f;
    public float strokeWidth = 0.0f;

    public enum a {
        NORMAL(0),
        BOLD(1),
        ITALIC(2),
        BOLD_ITALIC(3);
        
        int bTx;

        static {
            AppMethodBeat.o(115951);
        }

        private a(int i) {
            this.bTx = i;
        }

        public static a i(boolean z, boolean z2) {
            if (z && z2) {
                return BOLD_ITALIC;
            }
            if (z) {
                return ITALIC;
            }
            if (z2) {
                return BOLD;
            }
            return NORMAL;
        }
    }

    i(a aVar) {
        this.bTs = aVar;
    }

    public final String toString() {
        AppMethodBeat.i(115952);
        String str = "MBFontStyle[" + this.fontSize + "][" + this.strokeWidth + "]";
        AppMethodBeat.o(115952);
        return str;
    }
}
