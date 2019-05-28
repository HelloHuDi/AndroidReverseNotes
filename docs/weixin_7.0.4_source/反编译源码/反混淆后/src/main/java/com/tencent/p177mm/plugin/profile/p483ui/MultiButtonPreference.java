package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.profile.ui.MultiButtonPreference */
public class MultiButtonPreference extends Preference {
    private String pnJ;
    public String pnK;
    private String pnL;
    private OnClickListener pnM;
    public OnClickListener pnN;
    private OnClickListener pnO;

    public MultiButtonPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23649);
        setLayoutResource(2130970409);
        AppMethodBeat.m2505o(23649);
    }

    public MultiButtonPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(23650);
        setLayoutResource(2130970409);
        AppMethodBeat.m2505o(23650);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23651);
        super.onBindView(view);
        Button button = (Button) view.findViewById(2131826658);
        View findViewById = view.findViewById(2131826659);
        Button button2 = (Button) view.findViewById(2131826660);
        View findViewById2 = view.findViewById(2131826661);
        Button button3 = (Button) view.findViewById(2131826662);
        view.setBackgroundColor(0);
        if (C5046bo.isNullOrNil(this.pnJ)) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
            button.setText(this.pnJ);
        }
        if (C5046bo.isNullOrNil(this.pnK)) {
            findViewById.setVisibility(8);
            button2.setVisibility(8);
        } else {
            if (C5046bo.isNullOrNil(this.pnJ)) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
            button2.setVisibility(0);
            button2.setText(this.pnK);
        }
        if (C5046bo.isNullOrNil(this.pnL)) {
            findViewById2.setVisibility(8);
            button3.setVisibility(8);
        } else {
            if (C5046bo.isNullOrNil(this.pnK)) {
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
        AppMethodBeat.m2505o(23651);
    }

    /* renamed from: a */
    public final void mo62464a(String str, OnClickListener onClickListener) {
        this.pnJ = str;
        this.pnM = onClickListener;
    }
}
