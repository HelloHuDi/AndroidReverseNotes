package com.tencent.p177mm.plugin.wallet.pwd.p558ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingHeaderPref */
public class WalletSecuritySettingHeaderPref extends Preference {
    private MMActivity crP;
    private TextView iOc;
    String lYc;
    ImageView rnN;
    TextView tsA;
    String tsB;
    String tsC;
    OnClickListener tsD;
    OnClickListener tsE;
    private TextView tsz;

    public WalletSecuritySettingHeaderPref(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(46389);
        this.crP = (MMActivity) context;
        AppMethodBeat.m2505o(46389);
    }

    public WalletSecuritySettingHeaderPref(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(46390);
        this.tsD = null;
        this.tsE = null;
        this.crP = (MMActivity) context;
        setLayoutResource(2130971163);
        AppMethodBeat.m2505o(46390);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(46391);
        super.onBindView(view);
        C4990ab.m7418v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo onBindView");
        this.iOc = (TextView) view.findViewById(2131824519);
        this.tsz = (TextView) view.findViewById(2131821095);
        this.tsA = (TextView) view.findViewById(2131829049);
        this.rnN = (ImageView) view.findViewById(2131829048);
        mo47855cu();
        if (!(this.tsA == null || this.tsD == null)) {
            this.tsA.setOnClickListener(this.tsD);
        }
        if (!(this.rnN == null || this.tsE == null)) {
            this.rnN.setOnClickListener(this.tsE);
        }
        AppMethodBeat.m2505o(46391);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cu */
    public final void mo47855cu() {
        AppMethodBeat.m2504i(46392);
        if (!(C5046bo.isNullOrNil(this.lYc) || this.iOc == null)) {
            this.iOc.setText(this.lYc);
            this.iOc.setVisibility(0);
        }
        if (!(C5046bo.isNullOrNil(this.tsB) || this.tsz == null)) {
            this.tsz.setText(this.tsB);
            this.tsz.setVisibility(0);
        }
        if (!(C5046bo.isNullOrNil(this.tsC) || this.tsA == null)) {
            this.tsA.setText(this.tsC);
            this.tsA.setVisibility(0);
        }
        if (C5046bo.isNullOrNil(this.tsC) && this.tsA != null) {
            this.tsA.setVisibility(8);
        }
        AppMethodBeat.m2505o(46392);
    }
}
