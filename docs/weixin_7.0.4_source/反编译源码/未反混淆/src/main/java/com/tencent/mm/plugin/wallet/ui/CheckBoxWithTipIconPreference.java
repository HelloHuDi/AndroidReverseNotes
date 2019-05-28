package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

public class CheckBoxWithTipIconPreference extends CheckBoxPreference {
    private TextView ttD;
    private int ttE;
    private String ttF;
    private int ttG;

    public CheckBoxWithTipIconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxWithTipIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(46448);
        this.ttE = -1;
        this.ttF = "";
        this.ttG = 8;
        setLayoutResource(R.layout.aga);
        AppMethodBeat.o(46448);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(46449);
        super.onBindView(view);
        this.ttD = (TextView) view.findViewById(R.id.dam);
        ds(this.ttF, this.ttE);
        Hm(this.ttG);
        AppMethodBeat.o(46449);
    }

    public final void ds(String str, int i) {
        AppMethodBeat.i(46450);
        this.ttE = i;
        this.ttF = str;
        if (this.ttD != null) {
            if (this.ttE > 0) {
                this.ttD.setBackgroundResource(this.ttE);
            }
            if (!TextUtils.isEmpty(this.ttF)) {
                this.ttD.setText(this.ttF);
            }
        }
        AppMethodBeat.o(46450);
    }

    public final void Hm(int i) {
        AppMethodBeat.i(46451);
        this.ttG = i;
        if (this.ttD != null) {
            this.ttD.setVisibility(i);
        }
        AppMethodBeat.o(46451);
    }
}
