package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class RadioCheckPreference extends Preference {
    private TextView ttD;
    private int ttE;
    private String ttF;
    private int ttG;
    private boolean uOT;
    private CheckBox yBq;
    private int yBr;

    public RadioCheckPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RadioCheckPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107286);
        this.uOT = false;
        this.ttE = -1;
        this.ttF = "";
        this.ttG = 8;
        this.yBr = -1;
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(107286);
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(107287);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.layout.agb, viewGroup2);
        AppMethodBeat.o(107287);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(107288);
        super.onBindView(view);
        NW(8);
        this.yBq = (CheckBox) view.findViewById(R.id.dan);
        this.yBq.setChecked(this.uOT);
        this.ttD = (TextView) view.findViewById(R.id.dam);
        String str = this.ttF;
        int i = this.ttE;
        this.ttE = i;
        this.ttF = str;
        if (this.ttD != null) {
            if (i > 0) {
                this.ttD.setBackgroundResource(this.ttE);
            }
            if (!TextUtils.isEmpty(this.ttF)) {
                this.ttD.setText(this.ttF);
            }
        }
        this.ttG = this.ttG;
        if (this.ttD != null) {
            this.ttD.setVisibility(this.ttG);
        }
        LayoutParams layoutParams = (LayoutParams) this.yBq.getLayoutParams();
        if (-1 != this.yBr) {
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, this.yBr, layoutParams.bottomMargin);
        }
        AppMethodBeat.o(107288);
    }

    public final void qg(boolean z) {
        AppMethodBeat.i(107289);
        this.uOT = z;
        if (this.yBq != null) {
            this.yBq.setChecked(z);
        }
        AppMethodBeat.o(107289);
    }
}
