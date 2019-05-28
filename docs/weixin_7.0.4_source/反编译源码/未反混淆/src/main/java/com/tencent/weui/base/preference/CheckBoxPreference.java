package com.tencent.weui.base.preference;

import android.content.Context;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class CheckBoxPreference extends Preference {
    private MMSwitchBtn ixT;
    private View mView;
    private TextView ttD;
    private int ttE;
    private String ttF;
    private int ttG;
    boolean uOT;

    static /* synthetic */ boolean a(CheckBoxPreference checkBoxPreference, Object obj) {
        AppMethodBeat.i(113252);
        boolean callChangeListener = checkBoxPreference.callChangeListener(obj);
        AppMethodBeat.o(113252);
        return callChangeListener;
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(113249);
        this.uOT = false;
        this.ttE = -1;
        this.ttF = "";
        this.ttG = 8;
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(113249);
    }

    /* Access modifiers changed, original: protected */
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(113250);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        View.inflate(getContext(), R.layout.ag_, viewGroup2);
        this.mView = onCreateView;
        View view = this.mView;
        AppMethodBeat.o(113250);
        return view;
    }

    public void onBindView(View view) {
        AppMethodBeat.i(113251);
        super.onBindView(view);
        this.ixT = (MMSwitchBtn) view.findViewById(R.id.js);
        this.ixT.setSwitchListener(new a() {
            public final void di(boolean z) {
                AppMethodBeat.i(113248);
                CheckBoxPreference.a(CheckBoxPreference.this, Boolean.valueOf(z));
                AppMethodBeat.o(113248);
            }
        });
        this.ixT.setCheck(this.uOT);
        if (!isEnabled()) {
            this.ixT.setEnabled(false);
            ((TextView) view.findViewById(16908310)).setTextColor(view.getResources().getColor(R.color.h8));
        }
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
        AppMethodBeat.o(113251);
    }

    public final boolean isChecked() {
        if (this.ixT != null) {
            return this.ixT.zMU;
        }
        return this.uOT;
    }
}
