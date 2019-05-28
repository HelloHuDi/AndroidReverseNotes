package com.tencent.toybrick.p680c;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.toybrick.p1578f.C41100a;

/* renamed from: com.tencent.toybrick.c.g */
public abstract class C44830g<S extends C44830g, T extends C41100a> extends C44559f<S, T> implements Comparable<C44830g> {
    public boolean AGG;
    private int[] AGH;
    /* renamed from: IT */
    CharSequence f17612IT;
    public int btQ;

    /* renamed from: com.tencent.toybrick.c.g$a */
    public enum C36553a {
        RED_NEW,
        RED_DOT,
        RED_NUM,
        NONE;

        static {
            AppMethodBeat.m2505o(113220);
        }
    }

    /* renamed from: com.tencent.toybrick.c.g$b */
    public enum C36554b {
        NORMAL,
        HINT;

        static {
            AppMethodBeat.m2505o(113223);
        }
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.btQ - ((C44830g) obj).btQ;
    }

    public C36554b dSy() {
        return C36554b.NORMAL;
    }

    /* renamed from: fz */
    public final int[] mo72038fz(View view) {
        View findViewById = view.findViewById(16908310);
        this.AGH[0] = findViewById == null ? (int) this.AGA.getResources().getDimension(C25738R.dimen.f9796fy) : findViewById.getLeft();
        this.AGH[1] = (int) this.AGA.getResources().getDimension(C25738R.dimen.f9796fy);
        return this.AGH;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C44830g)) {
            return false;
        }
        C44830g c44830g = (C44830g) obj;
        if (c44830g.AGC != null && c44830g.AGC.equals(this.AGC) && c44830g.f17612IT != null && c44830g.f17612IT.equals(this.f17612IT) && c44830g.AGG == this.AGG && c44830g.isVisible == this.isVisible && c44830g.AGD == this.AGD) {
            return true;
        }
        return false;
    }
}
