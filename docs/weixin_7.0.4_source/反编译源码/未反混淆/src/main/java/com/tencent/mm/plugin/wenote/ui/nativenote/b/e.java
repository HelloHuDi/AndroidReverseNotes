package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class e extends a {
    private TextView uUr;
    private View uUs;
    public LinearLayout uUt;

    public e(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(27157);
        this.uUt = (LinearLayout) view.findViewById(R.id.dip);
        this.uUt.setVisibility(0);
        this.uUr = (TextView) view.findViewById(R.id.diq);
        this.uUs = view.findViewById(R.id.dir);
        AppMethodBeat.o(27157);
    }

    public final void a(c cVar, int i, int i2) {
        AppMethodBeat.i(27158);
        if (cVar.getType() != -3) {
            AppMethodBeat.o(27158);
        } else if (this.uSJ.uQI == 3) {
            this.uUt.setVisibility(8);
            AppMethodBeat.o(27158);
        } else {
            this.uUt.setVisibility(0);
            com.tencent.mm.plugin.wenote.model.a.e eVar = (com.tencent.mm.plugin.wenote.model.a.e) cVar;
            if (eVar.uOe <= 0) {
                AppMethodBeat.o(27158);
                return;
            }
            Object obj;
            Context context = this.uUr.getContext();
            long j = eVar.uOe;
            if (j < 3600000) {
                obj = "";
            } else {
                obj = DateFormat.format(context.getString(R.string.bpk), j);
            }
            this.uUr.setText(this.uUr.getContext().getString(R.string.d83) + " " + obj);
            AppMethodBeat.o(27158);
        }
    }

    public final int dfW() {
        return -3;
    }
}
