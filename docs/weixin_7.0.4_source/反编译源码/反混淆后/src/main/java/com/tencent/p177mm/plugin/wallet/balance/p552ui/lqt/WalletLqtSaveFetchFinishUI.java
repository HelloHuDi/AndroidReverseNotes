package com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.ase;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;
import java.io.IOException;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishUI */
public class WalletLqtSaveFetchFinishUI extends WalletBaseUI {
    private ViewGroup kEk;
    private Button oDB;
    private TextView tkc;
    private WalletTextView tkd;
    private TextView tke;
    private TextView tkf;
    private ase tkg;
    private CdnImageView tkh;
    private TextView tki;
    private TextView tkj;
    private LinearLayout tkk;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishUI$3 */
    class C141473 implements Runnable {
        C141473() {
        }

        public final void run() {
            AppMethodBeat.m2504i(45640);
            LinearLayout linearLayout = (LinearLayout) WalletLqtSaveFetchFinishUI.this.findViewById(2131828862);
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -2);
            }
            layoutParams.removeRule(12);
            linearLayout.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(45640);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishUI$4 */
    class C141484 implements Runnable {
        C141484() {
        }

        public final void run() {
            AppMethodBeat.m2504i(45641);
            LinearLayout linearLayout = (LinearLayout) WalletLqtSaveFetchFinishUI.this.findViewById(2131828862);
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -2);
            }
            layoutParams.addRule(12);
            linearLayout.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(45641);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishUI$2 */
    class C354232 implements OnClickListener {
        C354232() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45639);
            if ("wxpay://lqt/planindex".equals(WalletLqtSaveFetchFinishUI.this.tkg.url)) {
                WalletLqtSaveFetchFinishUI.this.startActivity(new Intent(WalletLqtSaveFetchFinishUI.this.mController.ylL, WalletLqtPlanHomeUI.class));
                AppMethodBeat.m2505o(45639);
            } else if ("wxpay://lqt/preaddplan".equals(WalletLqtSaveFetchFinishUI.this.tkg.url)) {
                Intent intent = new Intent(WalletLqtSaveFetchFinishUI.this.mController.ylL, WalletLqtPlanAddUI.class);
                intent.putExtra("key_mode", 3);
                WalletLqtSaveFetchFinishUI.this.startActivity(intent);
                AppMethodBeat.m2505o(45639);
            } else {
                C4990ab.m7421w("MicroMsg.WalletLqtSaveFetchFinishUI", "unknown url: %s", WalletLqtSaveFetchFinishUI.this.tkg.url);
                AppMethodBeat.m2505o(45639);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishUI$1 */
    class C354241 implements OnClickListener {
        C354241() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45638);
            WalletLqtSaveFetchFinishUI.this.finish();
            AppMethodBeat.m2505o(45638);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130971120;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onBackPressed() {
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45642);
        this.yll = true;
        super.onCreate(bundle);
        mo17446xE(-1);
        this.mController.hideTitleView();
        enableBackMenu(false);
        this.kEk = (ViewGroup) findViewById(2131826653);
        this.tkc = (TextView) findViewById(2131828858);
        this.tkd = (WalletTextView) findViewById(2131828860);
        this.oDB = (Button) findViewById(2131828863);
        this.tke = (TextView) findViewById(2131828861);
        this.tkf = (TextView) findViewById(2131828864);
        this.tkh = (CdnImageView) findViewById(2131828865);
        this.tki = (TextView) findViewById(2131828866);
        this.tkj = (TextView) findViewById(2131828867);
        this.tkk = (LinearLayout) findViewById(2131821222);
        int intExtra = getIntent().getIntExtra("key_mode", 1);
        double doubleExtra = getIntent().getDoubleExtra("key_amount", 0.0d);
        String stringExtra = getIntent().getStringExtra("profile_date_wording");
        CharSequence stringExtra2 = getIntent().getStringExtra("profile_upgrade_wording");
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_guide_cell");
        if (byteArrayExtra != null) {
            try {
                this.tkg = (ase) new ase().parseFrom(byteArrayExtra);
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishUI", e, "", new Object[0]);
            }
        }
        if (intExtra == 1) {
            this.tkc.setText(getString(C25738R.string.fjw));
            setMMTitle(getString(C25738R.string.fjw));
        } else if (intExtra == 2) {
            this.tkc.setText(getString(C25738R.string.fip));
            setMMTitle(getString(C25738R.string.fip));
        }
        this.tkd.setText(C36391e.m59971F(doubleExtra));
        this.oDB.setOnClickListener(new C354241());
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.tke.setText(stringExtra);
            this.tke.setVisibility(0);
        }
        if (!C5046bo.isNullOrNil(stringExtra2)) {
            this.tkf.setText(C44089j.m79304e((Context) this, stringExtra2, (int) this.tkf.getTextSize()));
            this.tkf.setClickable(true);
            this.tkf.setOnTouchListener(new C30132m());
            this.tkf.setVisibility(0);
        }
        if (this.tkg != null) {
            if (!C5046bo.isNullOrNil(this.tkg.cIY)) {
                this.tkh.setUrl(this.tkg.cIY);
            }
            this.tki.setText(this.tkg.title);
            this.tkj.setText(this.tkg.desc);
            this.tkk.setOnClickListener(new C354232());
            this.tkk.setVisibility(0);
            getWindow().getDecorView().post(new C141473());
            AppMethodBeat.m2505o(45642);
            return;
        }
        this.tkk.setVisibility(8);
        getWindow().getDecorView().post(new C141484());
        AppMethodBeat.m2505o(45642);
    }

    /* renamed from: AM */
    public final void mo9439AM(int i) {
        AppMethodBeat.m2504i(45643);
        this.mController.contentView.setVisibility(i);
        AppMethodBeat.m2505o(45643);
    }
}
