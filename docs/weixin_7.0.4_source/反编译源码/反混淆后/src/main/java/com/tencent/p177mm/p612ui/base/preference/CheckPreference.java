package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.base.preference.CheckPreference */
public class CheckPreference extends Preference {
    private TextView ttD;
    private int ttE;
    private String ttF;
    private int ttG;
    public boolean uOT;
    private CheckBox yBq;
    public int yBr;

    public CheckPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107141);
        this.uOT = false;
        this.ttE = -1;
        this.ttF = "";
        this.ttG = 8;
        this.yBr = -1;
        setLayoutResource(2130970206);
        AppMethodBeat.m2505o(107141);
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107142);
        View onCreateView = super.onCreateView(viewGroup);
        AppMethodBeat.m2505o(107142);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(107143);
        super.onBindView(view);
        this.yBq = (CheckBox) view.findViewById(2131820932);
        this.yBq.setChecked(this.uOT);
        this.ttD = (TextView) view.findViewById(2131826079);
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
        AppMethodBeat.m2505o(107143);
    }
}
