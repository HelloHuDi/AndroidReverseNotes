package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b.C46140d;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoLoadingPreference */
public class NewBizInfoLoadingPreference extends Preference {
    private MMActivity crP;
    private View gbS;
    private TextView hrg;
    private boolean lyb = false;
    private C46140d ppN;
    private ProgressBar ppY;
    private boolean ppZ = false;
    private int state = 1;

    public NewBizInfoLoadingPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(23864);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.m2505o(23864);
    }

    public NewBizInfoLoadingPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23865);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.m2505o(23865);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23866);
        this.gbS = view.findViewById(2131823041);
        this.hrg = (TextView) view.findViewById(2131823043);
        this.ppY = (ProgressBar) view.findViewById(2131823042);
        this.lyb = true;
        initView();
        AppMethodBeat.m2505o(23866);
    }

    private void initView() {
        AppMethodBeat.m2504i(23867);
        if (!this.lyb) {
            AppMethodBeat.m2505o(23867);
        } else if (this.state == 1) {
            this.gbS.setVisibility(0);
            this.ppY.setVisibility(0);
            this.hrg.setVisibility(8);
            AppMethodBeat.m2505o(23867);
        } else if (this.state == 2) {
            this.gbS.setVisibility(0);
            this.hrg.setText(C44089j.m79301d(this.crP, this.ppN.field_newBanReason, (int) this.hrg.getTextSize()));
            this.hrg.setMovementMethod(LinkMovementMethod.getInstance());
            this.hrg.setVisibility(0);
            this.ppY.setVisibility(8);
            AppMethodBeat.m2505o(23867);
        } else if (this.state == 3) {
            this.gbS.setVisibility(0);
            this.hrg.setText(this.crP.getString(C25738R.string.b1u));
            this.hrg.setVisibility(0);
            this.ppY.setVisibility(8);
            AppMethodBeat.m2505o(23867);
        } else {
            this.gbS.setVisibility(8);
            AppMethodBeat.m2505o(23867);
        }
    }

    /* renamed from: a */
    public final void mo24888a(C46140d c46140d, boolean z) {
        AppMethodBeat.m2504i(23868);
        this.ppN = c46140d;
        this.ppZ = z;
        cbv();
        initView();
        AppMethodBeat.m2505o(23868);
    }

    private void cbv() {
        AppMethodBeat.m2504i(23869);
        if (this.ppN != null && this.ppN.cbP()) {
            this.state = 2;
            AppMethodBeat.m2505o(23869);
        } else if (this.ppZ) {
            this.state = 3;
            AppMethodBeat.m2505o(23869);
        } else if (this.ppN != null) {
            this.state = 0;
            AppMethodBeat.m2505o(23869);
        } else {
            this.state = 1;
            AppMethodBeat.m2505o(23869);
        }
    }
}
