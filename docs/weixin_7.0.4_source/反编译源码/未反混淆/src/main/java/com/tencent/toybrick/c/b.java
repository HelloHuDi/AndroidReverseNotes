package com.tencent.toybrick.c;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class b extends g<b, a> {
    public static final int AFW = R.layout.a6r;

    public class a extends com.tencent.toybrick.f.a {
        TextView AGh;

        public a(View view) {
            super(view);
            AppMethodBeat.i(113199);
            this.AGh = (TextView) view.findViewById(16908310);
            AppMethodBeat.o(113199);
        }
    }

    public final /* synthetic */ void a(com.tencent.toybrick.f.a aVar) {
        AppMethodBeat.i(113201);
        ((a) aVar).AGh.setText(this.IT);
        AppMethodBeat.o(113201);
    }

    public final int getLayoutResource() {
        return AFW;
    }

    public final com.tencent.toybrick.c.g.b dSy() {
        return com.tencent.toybrick.c.g.b.HINT;
    }

    public final /* synthetic */ com.tencent.toybrick.f.a fy(View view) {
        AppMethodBeat.i(113200);
        a aVar = new a(view);
        AppMethodBeat.o(113200);
        return aVar;
    }
}
