package com.tencent.p177mm.p612ui.base.preference;

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

/* renamed from: com.tencent.mm.ui.base.preference.RadioCheckPreference */
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
        AppMethodBeat.m2504i(107286);
        this.uOT = false;
        this.ttE = -1;
        this.ttF = "";
        this.ttG = 8;
        this.yBr = -1;
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(107286);
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107287);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130970209, viewGroup2);
        AppMethodBeat.m2505o(107287);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(107288);
        super.onBindView(view);
        mo39406NW(8);
        this.yBq = (CheckBox) view.findViewById(2131826080);
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
        AppMethodBeat.m2505o(107288);
    }

    /* renamed from: qg */
    public final void mo41847qg(boolean z) {
        AppMethodBeat.m2504i(107289);
        this.uOT = z;
        if (this.yBq != null) {
            this.yBq.setChecked(z);
        }
        AppMethodBeat.m2505o(107289);
    }
}
