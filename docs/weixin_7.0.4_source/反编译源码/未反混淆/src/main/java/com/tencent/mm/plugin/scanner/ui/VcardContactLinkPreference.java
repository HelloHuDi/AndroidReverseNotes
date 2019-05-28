package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.ui.base.preference.KeyValuePreference;

public class VcardContactLinkPreference extends KeyValuePreference {
    public VcardContactLinkPreference(Context context) {
        super(context);
    }

    public VcardContactLinkPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VcardContactLinkPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(81343);
        View onCreateView = super.onCreateView(viewGroup);
        AppMethodBeat.o(81343);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(81344);
        super.onBindView(view);
        ((TextView) view.findViewById(16908304)).setTextColor(a.i(this.mContext, R.color.l4));
        AppMethodBeat.o(81344);
    }
}
