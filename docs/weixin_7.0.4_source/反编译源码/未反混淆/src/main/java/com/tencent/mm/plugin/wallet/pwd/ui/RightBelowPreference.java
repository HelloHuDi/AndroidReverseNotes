package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.SummaryBelowPreference;

public class RightBelowPreference extends SummaryBelowPreference {
    private CharSequence tqM;

    public RightBelowPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RightBelowPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(46204);
        View onCreateView = super.onCreateView(viewGroup);
        ((ViewGroup) ((ViewGroup) onCreateView.findViewById(R.id.m5)).findViewById(16908312)).addView((ViewGroup) View.inflate(this.mContext, R.layout.b5s, null));
        AppMethodBeat.o(46204);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(46205);
        super.onBindView(view);
        if (!bo.ac(this.tqM)) {
            ((TextView) view.findViewById(R.id.fg0)).setText(this.tqM);
        }
        view.findViewById(R.id.z_).setVisibility(8);
        AppMethodBeat.o(46205);
    }

    public final void L(CharSequence charSequence) {
        AppMethodBeat.i(46206);
        this.tqM = charSequence;
        notifyChanged();
        AppMethodBeat.o(46206);
    }
}
