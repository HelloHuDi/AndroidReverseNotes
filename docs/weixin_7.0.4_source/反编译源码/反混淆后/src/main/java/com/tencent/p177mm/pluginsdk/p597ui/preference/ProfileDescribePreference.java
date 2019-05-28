package com.tencent.p177mm.pluginsdk.p597ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.pluginsdk.p597ui.ProfileDescribeView;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.pluginsdk.ui.preference.ProfileDescribePreference */
public class ProfileDescribePreference extends Preference {
    public C7616ad ldh;
    private View omq;
    public C7575bv pCq;
    private ProfileDescribeView vrn;

    public ProfileDescribePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ProfileDescribePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(28115);
        if (this.omq == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
            viewGroup2.removeAllViews();
            ProfileDescribeView profileDescribeView = new ProfileDescribeView(onCreateView.getContext());
            this.vrn = profileDescribeView;
            viewGroup2.addView(profileDescribeView, new LayoutParams(-1, -2));
            this.vrn.mo27223T(this.ldh);
            this.omq = onCreateView;
        }
        View view = this.omq;
        AppMethodBeat.m2505o(28115);
        return view;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(28116);
        super.onBindView(view);
        if (this.ldh == null) {
            AppMethodBeat.m2505o(28116);
            return;
        }
        this.vrn.cby();
        AppMethodBeat.m2505o(28116);
    }
}
