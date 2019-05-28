package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;

public class MultiButtonPreference extends Preference {
    private String pnJ;
    public String pnK;
    private String pnL;
    private OnClickListener pnM;
    public OnClickListener pnN;
    private OnClickListener pnO;

    public MultiButtonPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23649);
        setLayoutResource(R.layout.alp);
        AppMethodBeat.o(23649);
    }

    public MultiButtonPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(23650);
        setLayoutResource(R.layout.alp);
        AppMethodBeat.o(23650);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23651);
        super.onBindView(view);
        Button button = (Button) view.findViewById(R.id.dq_);
        View findViewById = view.findViewById(R.id.dqa);
        Button button2 = (Button) view.findViewById(R.id.dqb);
        View findViewById2 = view.findViewById(R.id.dqc);
        Button button3 = (Button) view.findViewById(R.id.dqd);
        view.setBackgroundColor(0);
        if (bo.isNullOrNil(this.pnJ)) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
            button.setText(this.pnJ);
        }
        if (bo.isNullOrNil(this.pnK)) {
            findViewById.setVisibility(8);
            button2.setVisibility(8);
        } else {
            if (bo.isNullOrNil(this.pnJ)) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
            button2.setVisibility(0);
            button2.setText(this.pnK);
        }
        if (bo.isNullOrNil(this.pnL)) {
            findViewById2.setVisibility(8);
            button3.setVisibility(8);
        } else {
            if (bo.isNullOrNil(this.pnK)) {
                findViewById2.setVisibility(8);
            } else {
                findViewById2.setVisibility(0);
            }
            button3.setVisibility(0);
            button3.setText(this.pnL);
        }
        button.setOnClickListener(this.pnM);
        button2.setOnClickListener(this.pnN);
        button3.setOnClickListener(this.pnO);
        AppMethodBeat.o(23651);
    }

    public final void a(String str, OnClickListener onClickListener) {
        this.pnJ = str;
        this.pnM = onClickListener;
    }
}
