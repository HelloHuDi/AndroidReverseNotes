package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class l extends v {
    public TextView gnf;
    public LinearLayout kuD;
    public ProgressBar kuE;

    private l(View view) {
        super(view);
        AppMethodBeat.i(54325);
        this.kuD = (LinearLayout) view.findViewById(R.id.ava);
        this.gnf = (TextView) view.findViewById(R.id.avc);
        this.kuE = (ProgressBar) view.findViewById(R.id.avb);
        AppMethodBeat.o(54325);
    }

    public static v m(ViewGroup viewGroup) {
        AppMethodBeat.i(54326);
        l lVar = new l(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.o9, viewGroup, false));
        AppMethodBeat.o(54326);
        return lVar;
    }
}
