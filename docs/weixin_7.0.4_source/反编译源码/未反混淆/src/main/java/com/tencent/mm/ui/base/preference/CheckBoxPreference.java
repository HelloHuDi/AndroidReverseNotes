package com.tencent.mm.ui.base.preference;

import android.content.Context;
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
    public boolean uOT;

    public CheckBoxPreference(Context context) {
        this(context, null);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107135);
        this.uOT = false;
        this.ttE = -1;
        this.ttF = "";
        this.ttG = 8;
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(107135);
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(107136);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.ag_, viewGroup2);
        this.mView = onCreateView;
        View view = this.mView;
        AppMethodBeat.o(107136);
        return view;
    }

    public void onBindView(View view) {
        AppMethodBeat.i(107137);
        super.onBindView(view);
        NW(8);
        this.ixT = (MMSwitchBtn) view.findViewById(R.id.js);
        this.ixT.setSwitchListener(new a() {
            public final void di(boolean z) {
                AppMethodBeat.i(107134);
                CheckBoxPreference.this.callChangeListener(Boolean.valueOf(z));
                AppMethodBeat.o(107134);
            }
        });
        this.ixT.setCheck(this.uOT);
        if (!isEnabled()) {
            this.ixT.setEnabled(false);
            ((TextView) view.findViewById(16908310)).setTextColor(view.getResources().getColor(R.color.mh));
            ((TextView) view.findViewById(16908304)).setTextColor(view.getResources().getColor(R.color.mh));
        }
        this.ttD = (TextView) view.findViewById(R.id.dam);
        ds(this.ttF, this.ttE);
        Hm(this.ttG);
        AppMethodBeat.o(107137);
    }

    public final boolean isChecked() {
        if (this.ixT != null) {
            return this.ixT.zMU;
        }
        return this.uOT;
    }

    public final void qg(boolean z) {
        AppMethodBeat.i(107138);
        if (this.ixT != null) {
            this.uOT = z;
            this.ixT.setCheck(z);
        }
        AppMethodBeat.o(107138);
    }

    public void ds(String str, int i) {
        AppMethodBeat.i(107139);
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
        AppMethodBeat.o(107139);
    }

    public void Hm(int i) {
        AppMethodBeat.i(107140);
        this.ttG = i;
        if (this.ttD != null) {
            this.ttD.setVisibility(this.ttG);
        }
        AppMethodBeat.o(107140);
    }
}
