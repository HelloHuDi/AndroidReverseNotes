package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMSingelLinePanel;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.profile.ui.ContactLabelPreference */
public class ContactLabelPreference extends Preference {
    private TextView gne;
    private MMSingelLinePanel plB;
    private ArrayList<String> plC;
    private String title;

    public ContactLabelPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ContactLabelPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23392);
        this.plC = new ArrayList();
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(23392);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(23393);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130970154, viewGroup2);
        AppMethodBeat.m2505o(23393);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23394);
        this.gne = (TextView) view.findViewById(2131820678);
        this.plB = (MMSingelLinePanel) view.findViewById(2131820902);
        this.plB.setSingleLine(true);
        this.plB.yxl = false;
        this.plB.mo71963qe(false);
        if (this.gne != null) {
            this.gne.setText(this.title);
        }
        if (!(this.plB == null || this.plC == null || this.plC.size() <= 0)) {
            this.plB.mo71950a((Collection) this.plC, (List) this.plC);
        }
        super.onBindView(view);
        AppMethodBeat.m2505o(23394);
    }
}
