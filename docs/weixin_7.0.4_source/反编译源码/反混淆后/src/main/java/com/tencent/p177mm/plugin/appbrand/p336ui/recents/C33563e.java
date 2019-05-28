package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.ThreeDotsLoadingView;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.e */
public final class C33563e {
    public final View apJ;
    ThreeDotsLoadingView iNB = ((ThreeDotsLoadingView) this.apJ.findViewById(2131821325));
    View iNC = this.apJ.findViewById(2131821328);
    private View iND = this.apJ.findViewById(2131821326);

    /* renamed from: eJ */
    public final void mo54046eJ(boolean z) {
        AppMethodBeat.m2504i(133413);
        if (z) {
            if (this.iNB != null) {
                this.iNB.setVisibility(0);
                this.iNB.dKS();
            }
            if (this.iND != null) {
                this.iND.setVisibility(8);
                AppMethodBeat.m2505o(133413);
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
        AppMethodBeat.m2505o(133413);
    }

    public C33563e(Context context, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(133414);
        this.apJ = LayoutInflater.from(context).inflate(2130968712, viewGroup, false);
        AppMethodBeat.m2505o(133414);
    }

    public final void onDetached() {
        this.iNB = null;
        this.iND = null;
    }

    public final View aNi() {
        return this.apJ;
    }

    public final void aNr() {
        AppMethodBeat.m2504i(133415);
        if (this.iNC != null) {
            this.iNC.setBackgroundResource(C25738R.color.a3p);
        }
        AppMethodBeat.m2505o(133415);
    }
}
