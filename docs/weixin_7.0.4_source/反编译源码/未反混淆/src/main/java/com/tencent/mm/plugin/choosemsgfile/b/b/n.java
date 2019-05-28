package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class n extends v {
    public final ImageView eks;
    public final TextView gne;
    public final ProgressBar gtQ;
    public final TextView gtb;
    public final TextView hrg;
    public final ImageView iyo;
    public final LinearLayout kuD;
    public final MMPinProgressBtn kuH;
    public final CheckBox kuN;
    public final ImageView kuP;
    public final View kuR;
    public final TextView timeTv;

    private n(View view) {
        super(view);
        AppMethodBeat.i(54333);
        this.kuD = (LinearLayout) view.findViewById(R.id.ava);
        this.eks = (ImageView) view.findViewById(R.id.qk);
        this.gtb = (TextView) view.findViewById(R.id.rr);
        this.timeTv = (TextView) view.findViewById(R.id.la);
        this.kuN = (CheckBox) view.findViewById(R.id.a1b);
        this.kuR = view.findViewById(R.id.avj);
        this.kuP = (ImageView) view.findViewById(R.id.amv);
        this.iyo = (ImageView) view.findViewById(R.id.rq);
        this.gne = (TextView) view.findViewById(R.id.qm);
        this.hrg = (TextView) view.findViewById(R.id.lf);
        this.kuH = (MMPinProgressBtn) view.findViewById(R.id.as0);
        this.gtQ = (ProgressBar) view.findViewById(R.id.a1n);
        this.kuD.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(54331);
                a aVar = (a) view.getTag();
                if (aVar == null) {
                    AppMethodBeat.o(54331);
                    return;
                }
                aVar.a(view, aVar);
                AppMethodBeat.o(54331);
            }
        });
        this.kuR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(54332);
                a aVar = (a) view.getTag();
                if (aVar == null) {
                    AppMethodBeat.o(54332);
                    return;
                }
                boolean z = !n.this.kuN.isChecked();
                if (aVar.isEnable()) {
                    n.this.kuN.setChecked(z);
                    aVar.a(z, aVar, n.this);
                }
                AppMethodBeat.o(54332);
            }
        });
        AppMethodBeat.o(54333);
    }

    public static v m(ViewGroup viewGroup) {
        AppMethodBeat.i(54334);
        n nVar = new n(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.oa, viewGroup, false));
        AppMethodBeat.o(54334);
        return nVar;
    }
}
