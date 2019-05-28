package com.tencent.p177mm.plugin.address.p276ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.address.model.RcptItem;

/* renamed from: com.tencent.mm.plugin.address.ui.RcptPreference */
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
        AppMethodBeat.m2504i(16929);
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(16929);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(16930);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130970163, viewGroup2);
        AppMethodBeat.m2505o(16930);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(16931);
        super.onBindView(view);
        if (this.gKN == null) {
            AppMethodBeat.m2505o(16931);
            return;
        }
        ((TextView) view.findViewById(2131826048)).setText(this.gKN.name);
        View findViewById = view.findViewById(16908312);
        if (findViewById == null) {
            AppMethodBeat.m2505o(16931);
        } else if (this.gKN.gIP) {
            findViewById.setVisibility(0);
            AppMethodBeat.m2505o(16931);
        } else {
            findViewById.setVisibility(8);
            AppMethodBeat.m2505o(16931);
        }
    }
}
