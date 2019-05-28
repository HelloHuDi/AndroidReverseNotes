package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class m extends v {
    public final ProgressBar gtQ;
    public final View kuF;
    public final ImageView kuG;
    public final MMPinProgressBtn kuH;
    public final TextView kuI;
    public final TextView kuJ;
    public final View kuK;
    public final TextView kuL;
    public final ImageView kuM;
    public final CheckBox kuN;
    public final View kuO;
    public ImageView kuP;

    private m(View view) {
        super(view);
        AppMethodBeat.i(54329);
        this.kuF = view.findViewById(R.id.ava);
        this.kuG = (ImageView) view.findViewById(R.id.a82);
        this.kuH = (MMPinProgressBtn) view.findViewById(R.id.as0);
        this.gtQ = (ProgressBar) view.findViewById(R.id.a1n);
        this.kuK = view.findViewById(R.id.avf);
        this.kuL = (TextView) view.findViewById(R.id.avh);
        this.kuI = (TextView) view.findViewById(R.id.avd);
        this.kuJ = (TextView) view.findViewById(R.id.ave);
        this.kuM = (ImageView) view.findViewById(R.id.auj);
        this.kuN = (CheckBox) view.findViewById(R.id.a1b);
        this.kuO = view.findViewById(R.id.avi);
        this.kuP = (ImageView) view.findViewById(R.id.amv);
        this.kuG.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(54327);
                a aVar = (a) view.getTag();
                if (aVar == null) {
                    AppMethodBeat.o(54327);
                    return;
                }
                aVar.a(view, aVar);
                AppMethodBeat.o(54327);
            }
        });
        this.kuO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(54328);
                a aVar = (a) view.getTag();
                if (aVar == null) {
                    AppMethodBeat.o(54328);
                    return;
                }
                boolean z = !m.this.kuN.isChecked();
                if (aVar.isEnable()) {
                    m.this.kuN.setChecked(z);
                    aVar.a(z, aVar, m.this);
                    if (z) {
                        m.this.kuM.setVisibility(8);
                    } else {
                        m.this.kuM.setVisibility(0);
                        AppMethodBeat.o(54328);
                        return;
                    }
                }
                AppMethodBeat.o(54328);
            }
        });
        AppMethodBeat.o(54329);
    }

    public static v m(ViewGroup viewGroup) {
        AppMethodBeat.i(54330);
        m mVar = new m(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.o_, viewGroup, false));
        AppMethodBeat.o(54330);
        return mVar;
    }
}
