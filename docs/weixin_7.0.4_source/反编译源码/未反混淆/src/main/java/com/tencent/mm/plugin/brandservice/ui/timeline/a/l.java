package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class l extends c {
    public View jPU;
    public MMNeat7extView jPi;

    public final void a(View view, a aVar) {
        AppMethodBeat.i(14274);
        super.a(view, aVar);
        if (this.jOR != null) {
            AppMethodBeat.o(14274);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.a7v);
        if (viewStub == null) {
            AppMethodBeat.o(14274);
            return;
        }
        viewStub.inflate();
        this.jOR = view.findViewById(R.id.a8o);
        this.jPn = view.findViewById(R.id.a8p);
        aWI();
        this.jPU = view.findViewById(R.id.dd);
        this.jPi = (MMNeat7extView) this.jOR.findViewById(R.id.qm);
        AppMethodBeat.o(14274);
    }
}
