package com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b;

import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.b.l */
public final class C46904l extends C41531v {
    public TextView gnf;
    public LinearLayout kuD;
    public ProgressBar kuE;

    private C46904l(View view) {
        super(view);
        AppMethodBeat.m2504i(54325);
        this.kuD = (LinearLayout) view.findViewById(2131822738);
        this.gnf = (TextView) view.findViewById(2131822740);
        this.kuE = (ProgressBar) view.findViewById(2131822739);
        AppMethodBeat.m2505o(54325);
    }

    /* renamed from: m */
    public static C41531v m89273m(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(54326);
        C46904l c46904l = new C46904l(LayoutInflater.from(viewGroup.getContext()).inflate(2130969131, viewGroup, false));
        AppMethodBeat.m2505o(54326);
        return c46904l;
    }
}
