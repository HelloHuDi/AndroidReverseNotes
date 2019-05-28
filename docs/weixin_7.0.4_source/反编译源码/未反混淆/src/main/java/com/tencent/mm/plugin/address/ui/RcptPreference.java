package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.ui.base.preference.Preference;

public class RcptPreference extends Preference {
    RcptItem gKN;

    public RcptPreference(Context context) {
        this(context, null);
    }

    public RcptPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RcptPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(16929);
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(16929);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(16930);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.layout.af3, viewGroup2);
        AppMethodBeat.o(16930);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(16931);
        super.onBindView(view);
        if (this.gKN == null) {
            AppMethodBeat.o(16931);
            return;
        }
        ((TextView) view.findViewById(R.id.d_s)).setText(this.gKN.name);
        View findViewById = view.findViewById(16908312);
        if (findViewById == null) {
            AppMethodBeat.o(16931);
        } else if (this.gKN.gIP) {
            findViewById.setVisibility(0);
            AppMethodBeat.o(16931);
        } else {
            findViewById.setVisibility(8);
            AppMethodBeat.o(16931);
        }
    }
}
