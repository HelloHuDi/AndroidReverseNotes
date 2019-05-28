package com.tencent.toybrick.p680c;

import android.support.p069v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.toybrick.p1578f.C41100a;
import com.tencent.toybrick.p680c.C44830g.C36554b;

/* renamed from: com.tencent.toybrick.c.e */
public final class C16331e extends C44830g<C16331e, C41100a> {
    public static final int AFW = 2130970844;
    private int AGz;

    public final int getLayoutResource() {
        return AFW;
    }

    public final C36554b dSy() {
        return C36554b.HINT;
    }

    /* renamed from: a */
    public final void mo29716a(C41100a c41100a) {
        AppMethodBeat.m2504i(113215);
        if (this.AGz == 0) {
            this.AGz = (int) this.AGA.getResources().getDimension(C25738R.dimen.f9804g7);
        }
        c41100a.apJ.setLayoutParams(new LayoutParams(-1, this.AGz));
        AppMethodBeat.m2505o(113215);
    }

    /* renamed from: fy */
    public final C41100a mo29718fy(View view) {
        AppMethodBeat.m2504i(113216);
        C41100a c41100a = new C41100a(view);
        AppMethodBeat.m2505o(113216);
        return c41100a;
    }
}
