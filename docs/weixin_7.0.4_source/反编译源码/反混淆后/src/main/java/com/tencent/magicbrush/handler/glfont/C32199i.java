package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.magicbrush.handler.glfont.i */
public final class C32199i {
    public Typeface bTq = null;
    public boolean bTr = false;
    public C25716a bTs;
    public float fontSize = 14.0f;
    public float strokeWidth = 0.0f;

    /* renamed from: com.tencent.magicbrush.handler.glfont.i$a */
    public enum C25716a {
        NORMAL(0),
        BOLD(1),
        ITALIC(2),
        BOLD_ITALIC(3);
        
        int bTx;

        static {
            AppMethodBeat.m2505o(115951);
        }

        private C25716a(int i) {
            this.bTx = i;
        }

        /* renamed from: i */
        public static C25716a m40809i(boolean z, boolean z2) {
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

    C32199i(C25716a c25716a) {
        this.bTs = c25716a;
    }

    public final String toString() {
        AppMethodBeat.m2504i(115952);
        String str = "MBFontStyle[" + this.fontSize + "][" + this.strokeWidth + "]";
        AppMethodBeat.m2505o(115952);
        return str;
    }
}
