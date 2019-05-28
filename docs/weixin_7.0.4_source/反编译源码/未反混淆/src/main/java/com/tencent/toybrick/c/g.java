package com.tencent.toybrick.c;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public abstract class g<S extends g, T extends com.tencent.toybrick.f.a> extends f<S, T> implements Comparable<g> {
    public boolean AGG;
    private int[] AGH;
    CharSequence IT;
    public int btQ;

    public enum a {
        RED_NEW,
        RED_DOT,
        RED_NUM,
        NONE;

        static {
            AppMethodBeat.o(113220);
        }
    }

    public enum b {
        NORMAL,
        HINT;

        static {
            AppMethodBeat.o(113223);
        }
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.btQ - ((g) obj).btQ;
    }

    public b dSy() {
        return b.NORMAL;
    }

    public final int[] fz(View view) {
        View findViewById = view.findViewById(16908310);
        this.AGH[0] = findViewById == null ? (int) this.AGA.getResources().getDimension(R.dimen.fy) : findViewById.getLeft();
        this.AGH[1] = (int) this.AGA.getResources().getDimension(R.dimen.fy);
        return this.AGH;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (gVar.AGC != null && gVar.AGC.equals(this.AGC) && gVar.IT != null && gVar.IT.equals(this.IT) && gVar.AGG == this.AGG && gVar.isVisible == this.isVisible && gVar.AGD == this.AGD) {
            return true;
        }
        return false;
    }
}
