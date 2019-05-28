package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

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
        AppMethodBeat.i(46389);
        this.crP = (MMActivity) context;
        AppMethodBeat.o(46389);
    }

    public WalletSecuritySettingHeaderPref(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(46390);
        this.tsD = null;
        this.tsE = null;
        this.crP = (MMActivity) context;
        setLayoutResource(R.layout.b60);
        AppMethodBeat.o(46390);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(46391);
        super.onBindView(view);
        ab.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo onBindView");
        this.iOc = (TextView) view.findViewById(R.id.c6f);
        this.tsz = (TextView) view.findViewById(R.id.o7);
        this.tsA = (TextView) view.findViewById(R.id.fgw);
        this.rnN = (ImageView) view.findViewById(R.id.fgv);
        cu();
        if (!(this.tsA == null || this.tsD == null)) {
            this.tsA.setOnClickListener(this.tsD);
        }
        if (!(this.rnN == null || this.tsE == null)) {
            this.rnN.setOnClickListener(this.tsE);
        }
        AppMethodBeat.o(46391);
    }

    /* Access modifiers changed, original: final */
    public final void cu() {
        AppMethodBeat.i(46392);
        if (!(bo.isNullOrNil(this.lYc) || this.iOc == null)) {
            this.iOc.setText(this.lYc);
            this.iOc.setVisibility(0);
        }
        if (!(bo.isNullOrNil(this.tsB) || this.tsz == null)) {
            this.tsz.setText(this.tsB);
            this.tsz.setVisibility(0);
        }
        if (!(bo.isNullOrNil(this.tsC) || this.tsA == null)) {
            this.tsA.setText(this.tsC);
            this.tsA.setVisibility(0);
        }
        if (bo.isNullOrNil(this.tsC) && this.tsA != null) {
            this.tsA.setVisibility(8);
        }
        AppMethodBeat.o(46392);
    }
}
