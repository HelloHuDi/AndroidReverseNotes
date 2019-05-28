package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.profile.ui.RemarkInfoPreference */
public class RemarkInfoPreference extends Preference {
    private MMActivity crP;
    private TextView gne;
    private ImageView iyo;
    private TextView pnu;
    private boolean ppo = false;
    private String summary;
    private String title;

    public RemarkInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(23761);
        this.crP = (MMActivity) context;
        AppMethodBeat.m2505o(23761);
    }

    public RemarkInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23762);
        setLayoutResource(2130970127);
        setWidgetLayoutResource(2130970202);
        AppMethodBeat.m2505o(23762);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(23763);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130970165, viewGroup2);
        AppMethodBeat.m2505o(23763);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23764);
        this.gne = (TextView) view.findViewById(2131820678);
        this.pnu = (TextView) view.findViewById(2131821841);
        this.iyo = (ImageView) view.findViewById(2131822184);
        if (this.ppo) {
            this.iyo.setVisibility(0);
        } else {
            this.iyo.setVisibility(8);
        }
        if (this.gne != null) {
            this.gne.setText(this.title);
        }
        if (this.pnu != null) {
            this.pnu.setText(this.summary);
        }
        super.onBindView(view);
        AppMethodBeat.m2505o(23764);
    }

    public final /* synthetic */ CharSequence getSummary() {
        AppMethodBeat.m2504i(23765);
        String charSequence = this.pnu.getText().toString();
        AppMethodBeat.m2505o(23765);
        return charSequence;
    }
}
