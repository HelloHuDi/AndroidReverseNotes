package com.tencent.p177mm.plugin.wallet.p559ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;

/* renamed from: com.tencent.mm.plugin.wallet.ui.CheckBoxWithTipIconPreference */
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
        AppMethodBeat.m2504i(46448);
        this.ttE = -1;
        this.ttF = "";
        this.ttG = 8;
        setLayoutResource(2130970208);
        AppMethodBeat.m2505o(46448);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(46449);
        super.onBindView(view);
        this.ttD = (TextView) view.findViewById(2131826079);
        mo9404ds(this.ttF, this.ttE);
        mo9403Hm(this.ttG);
        AppMethodBeat.m2505o(46449);
    }

    /* renamed from: ds */
    public final void mo9404ds(String str, int i) {
        AppMethodBeat.m2504i(46450);
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
        AppMethodBeat.m2505o(46450);
    }

    /* renamed from: Hm */
    public final void mo9403Hm(int i) {
        AppMethodBeat.m2504i(46451);
        this.ttG = i;
        if (this.ttD != null) {
            this.ttD.setVisibility(i);
        }
        AppMethodBeat.m2505o(46451);
    }
}
