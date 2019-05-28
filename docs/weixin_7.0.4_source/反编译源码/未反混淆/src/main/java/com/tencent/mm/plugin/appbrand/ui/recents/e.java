package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class e {
    public final View apJ;
    ThreeDotsLoadingView iNB = ((ThreeDotsLoadingView) this.apJ.findViewById(R.id.ue));
    View iNC = this.apJ.findViewById(R.id.uh);
    private View iND = this.apJ.findViewById(R.id.uf);

    public final void eJ(boolean z) {
        AppMethodBeat.i(133413);
        if (z) {
            if (this.iNB != null) {
                this.iNB.setVisibility(0);
                this.iNB.dKS();
            }
            if (this.iND != null) {
                this.iND.setVisibility(8);
                AppMethodBeat.o(133413);
                return;
            }
        }
        if (this.iNB != null) {
            this.iNB.dKT();
            this.iNB.setVisibility(8);
        }
        if (this.iND != null) {
            this.iND.setVisibility(0);
        }
        AppMethodBeat.o(133413);
    }

    public e(Context context, ViewGroup viewGroup) {
        AppMethodBeat.i(133414);
        this.apJ = LayoutInflater.from(context).inflate(R.layout.cz, viewGroup, false);
        AppMethodBeat.o(133414);
    }

    public final void onDetached() {
        this.iNB = null;
        this.iND = null;
    }

    public final View aNi() {
        return this.apJ;
    }

    public final void aNr() {
        AppMethodBeat.i(133415);
        if (this.iNC != null) {
            this.iNC.setBackgroundResource(R.color.a3p);
        }
        AppMethodBeat.o(133415);
    }
}
