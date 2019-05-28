package com.tencent.toybrick.c;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.toybrick.c.g.b;
import com.tencent.toybrick.f.a;

public final class e extends g<e, a> {
    public static final int AFW = R.layout.axh;
    private int AGz;

    public final int getLayoutResource() {
        return AFW;
    }

    public final b dSy() {
        return b.HINT;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(113215);
        if (this.AGz == 0) {
            this.AGz = (int) this.AGA.getResources().getDimension(R.dimen.g7);
        }
        aVar.apJ.setLayoutParams(new LayoutParams(-1, this.AGz));
        AppMethodBeat.o(113215);
    }

    public final a fy(View view) {
        AppMethodBeat.i(113216);
        a aVar = new a(view);
        AppMethodBeat.o(113216);
        return aVar;
    }
}
