package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b.C46140d;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoAllMessagePreference */
public class NewBizInfoAllMessagePreference extends Preference {
    private MMActivity crP;
    private TextView gne;
    private TextView nDX;
    C46140d ppN;
    private LinearLayout ppR;

    public NewBizInfoAllMessagePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(23842);
        this.crP = (MMActivity) context;
        AppMethodBeat.m2505o(23842);
    }

    public NewBizInfoAllMessagePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23843);
        this.crP = (MMActivity) context;
        AppMethodBeat.m2505o(23843);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23844);
        this.ppR = (LinearLayout) view.findViewById(2131822967);
        this.gne = (TextView) view.findViewById(2131822968);
        this.nDX = (TextView) view.findViewById(2131822969);
        if (this.ppN == null || !this.ppN.cbN()) {
            this.ppR.setVisibility(8);
            AppMethodBeat.m2505o(23844);
            return;
        }
        this.ppR.setVisibility(0);
        this.gne.setText(this.crP.getString(C25738R.string.au9));
        this.nDX.setText(this.ppN.field_allArticleWording);
        AppMethodBeat.m2505o(23844);
    }
}
