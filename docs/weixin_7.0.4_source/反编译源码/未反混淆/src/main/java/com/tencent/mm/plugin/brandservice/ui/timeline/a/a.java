package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class a extends e {
    public LinearLayout jOP;
    public LinearLayout jOQ;

    public final void a(View view, com.tencent.mm.plugin.brandservice.ui.timeline.a aVar) {
        AppMethodBeat.i(14235);
        super.a(view, aVar);
        AppMethodBeat.o(14235);
    }

    public final void aWH() {
        AppMethodBeat.i(14236);
        if (this.jOR == null) {
            AppMethodBeat.o(14236);
            return;
        }
        this.ejo = (ImageView) this.jOR.findViewById(R.id.qk);
        this.jPp = (TextView) this.jOR.findViewById(R.id.a76);
        this.enf = (TextView) this.jOR.findViewById(R.id.la);
        this.jPo = this.jOR.findViewById(R.id.a75);
        this.jOP = (LinearLayout) this.jOR.findViewById(R.id.a85);
        this.jOQ = (LinearLayout) this.jOR.findViewById(R.id.a84);
        AppMethodBeat.o(14236);
    }
}
