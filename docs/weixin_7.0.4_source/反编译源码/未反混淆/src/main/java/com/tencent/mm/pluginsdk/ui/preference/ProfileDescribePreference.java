package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.Preference;

public class ProfileDescribePreference extends Preference {
    public ad ldh;
    private View omq;
    public bv pCq;
    private ProfileDescribeView vrn;

    public ProfileDescribePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ProfileDescribePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(28115);
        if (this.omq == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
            viewGroup2.removeAllViews();
            ProfileDescribeView profileDescribeView = new ProfileDescribeView(onCreateView.getContext());
            this.vrn = profileDescribeView;
            viewGroup2.addView(profileDescribeView, new LayoutParams(-1, -2));
            this.vrn.T(this.ldh);
            this.omq = onCreateView;
        }
        View view = this.omq;
        AppMethodBeat.o(28115);
        return view;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(28116);
        super.onBindView(view);
        if (this.ldh == null) {
            AppMethodBeat.o(28116);
            return;
        }
        this.vrn.cby();
        AppMethodBeat.o(28116);
    }
}
