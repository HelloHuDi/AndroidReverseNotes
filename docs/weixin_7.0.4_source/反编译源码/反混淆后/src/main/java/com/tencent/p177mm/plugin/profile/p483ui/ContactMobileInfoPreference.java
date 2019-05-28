package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.profile.ui.ContactMobileInfoPreference */
public class ContactMobileInfoPreference extends Preference {
    private String gDV;
    private TextView iDT;
    private String mTitle;
    private TextView plD;

    public ContactMobileInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ContactMobileInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23395);
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(23395);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(23396);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130970156, viewGroup2);
        AppMethodBeat.m2505o(23396);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23397);
        this.iDT = (TextView) view.findViewById(2131820678);
        this.plD = (TextView) view.findViewById(2131820792);
        if (this.iDT != null) {
            this.iDT.setText(this.mTitle);
        }
        if (this.plD != null) {
            this.plD.setText(this.gDV);
        }
        super.onBindView(view);
        AppMethodBeat.m2505o(23397);
    }
}
