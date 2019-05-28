package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.preference.KeyValuePreference;

/* renamed from: com.tencent.mm.plugin.scanner.ui.VcardContactLinkPreference */
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
        AppMethodBeat.m2504i(81343);
        View onCreateView = super.onCreateView(viewGroup);
        AppMethodBeat.m2505o(81343);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(81344);
        super.onBindView(view);
        ((TextView) view.findViewById(16908304)).setTextColor(C1338a.m2872i(this.mContext, C25738R.color.f11902l4));
        AppMethodBeat.m2505o(81344);
    }
}
