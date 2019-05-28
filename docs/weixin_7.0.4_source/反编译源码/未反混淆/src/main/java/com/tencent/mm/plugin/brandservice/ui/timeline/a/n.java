package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class n extends c {
    public ImageView jOY;
    public TextView jPY;
    public MMNeat7extView jPi;

    public final void a(View view, a aVar) {
        AppMethodBeat.i(14277);
        super.a(view, aVar);
        if (this.jOR != null) {
            AppMethodBeat.o(14277);
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.a7t);
        if (viewStub == null) {
            AppMethodBeat.o(14277);
            return;
        }
        viewStub.inflate();
        this.jOR = view.findViewById(R.id.a8x);
        this.jPn = view.findViewById(R.id.a8y);
        aWI();
        this.jPi = (MMNeat7extView) this.jOR.findViewById(R.id.qm);
        this.jPY = (TextView) this.jOR.findViewById(R.id.a8w);
        this.jOY = (ImageView) this.jOR.findViewById(R.id.a8z);
        AppMethodBeat.o(14277);
    }
}
