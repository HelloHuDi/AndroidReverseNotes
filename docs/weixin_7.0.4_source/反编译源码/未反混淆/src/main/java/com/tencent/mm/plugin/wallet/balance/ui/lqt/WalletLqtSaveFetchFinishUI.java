package com.tencent.mm.plugin.wallet.balance.ui.lqt;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;

@a(19)
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b4u;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onBackPressed() {
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45642);
        this.yll = true;
        super.onCreate(bundle);
        xE(-1);
        this.mController.hideTitleView();
        enableBackMenu(false);
        this.kEk = (ViewGroup) findViewById(R.id.dq5);
        this.tkc = (TextView) findViewById(R.id.fbq);
        this.tkd = (WalletTextView) findViewById(R.id.fbs);
        this.oDB = (Button) findViewById(R.id.fbv);
        this.tke = (TextView) findViewById(R.id.fbt);
        this.tkf = (TextView) findViewById(R.id.fbw);
        this.tkh = (CdnImageView) findViewById(R.id.fbx);
        this.tki = (TextView) findViewById(R.id.fby);
        this.tkj = (TextView) findViewById(R.id.fbz);
        this.tkk = (LinearLayout) findViewById(R.id.rm);
        int intExtra = getIntent().getIntExtra("key_mode", 1);
        double doubleExtra = getIntent().getDoubleExtra("key_amount", 0.0d);
        String stringExtra = getIntent().getStringExtra("profile_date_wording");
        CharSequence stringExtra2 = getIntent().getStringExtra("profile_upgrade_wording");
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_guide_cell");
        if (byteArrayExtra != null) {
            try {
                this.tkg = (ase) new ase().parseFrom(byteArrayExtra);
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishUI", e, "", new Object[0]);
            }
        }
        if (intExtra == 1) {
            this.tkc.setText(getString(R.string.fjw));
            setMMTitle(getString(R.string.fjw));
        } else if (intExtra == 2) {
            this.tkc.setText(getString(R.string.fip));
            setMMTitle(getString(R.string.fip));
        }
        this.tkd.setText(e.F(doubleExtra));
        this.oDB.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45638);
                WalletLqtSaveFetchFinishUI.this.finish();
                AppMethodBeat.o(45638);
            }
        });
        if (!bo.isNullOrNil(stringExtra)) {
            this.tke.setText(stringExtra);
            this.tke.setVisibility(0);
        }
        if (!bo.isNullOrNil(stringExtra2)) {
            this.tkf.setText(j.e((Context) this, stringExtra2, (int) this.tkf.getTextSize()));
            this.tkf.setClickable(true);
            this.tkf.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m());
            this.tkf.setVisibility(0);
        }
        if (this.tkg != null) {
            if (!bo.isNullOrNil(this.tkg.cIY)) {
                this.tkh.setUrl(this.tkg.cIY);
            }
            this.tki.setText(this.tkg.title);
            this.tkj.setText(this.tkg.desc);
            this.tkk.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(45639);
                    if ("wxpay://lqt/planindex".equals(WalletLqtSaveFetchFinishUI.this.tkg.url)) {
                        WalletLqtSaveFetchFinishUI.this.startActivity(new Intent(WalletLqtSaveFetchFinishUI.this.mController.ylL, WalletLqtPlanHomeUI.class));
                        AppMethodBeat.o(45639);
                    } else if ("wxpay://lqt/preaddplan".equals(WalletLqtSaveFetchFinishUI.this.tkg.url)) {
                        Intent intent = new Intent(WalletLqtSaveFetchFinishUI.this.mController.ylL, WalletLqtPlanAddUI.class);
                        intent.putExtra("key_mode", 3);
                        WalletLqtSaveFetchFinishUI.this.startActivity(intent);
                        AppMethodBeat.o(45639);
                    } else {
                        ab.w("MicroMsg.WalletLqtSaveFetchFinishUI", "unknown url: %s", WalletLqtSaveFetchFinishUI.this.tkg.url);
                        AppMethodBeat.o(45639);
                    }
                }
            });
            this.tkk.setVisibility(0);
            getWindow().getDecorView().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(45640);
                    LinearLayout linearLayout = (LinearLayout) WalletLqtSaveFetchFinishUI.this.findViewById(R.id.fbu);
                    LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new LayoutParams(-1, -2);
                    }
                    layoutParams.removeRule(12);
                    linearLayout.setLayoutParams(layoutParams);
                    AppMethodBeat.o(45640);
                }
            });
            AppMethodBeat.o(45642);
            return;
        }
        this.tkk.setVisibility(8);
        getWindow().getDecorView().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(45641);
                LinearLayout linearLayout = (LinearLayout) WalletLqtSaveFetchFinishUI.this.findViewById(R.id.fbu);
                LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LayoutParams(-1, -2);
                }
                layoutParams.addRule(12);
                linearLayout.setLayoutParams(layoutParams);
                AppMethodBeat.o(45641);
            }
        });
        AppMethodBeat.o(45642);
    }

    public final void AM(int i) {
        AppMethodBeat.i(45643);
        this.mController.contentView.setVisibility(i);
        AppMethodBeat.o(45643);
    }
}
