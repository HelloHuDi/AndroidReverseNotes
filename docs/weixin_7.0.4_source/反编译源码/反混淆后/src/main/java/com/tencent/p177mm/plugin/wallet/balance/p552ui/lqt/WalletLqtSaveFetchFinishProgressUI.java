package com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.WalletBalanceFetchResultItemView;
import com.tencent.p177mm.protocal.protobuf.bqq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressUI */
public class WalletLqtSaveFetchFinishProgressUI extends WalletBaseUI {
    private LinearLayout nsy;
    private ImageView pNb;
    private ImageView pNc;
    private ImageView pNd;
    private TextView pNe;
    private TextView pNf;
    private TextView pNg;
    private TextView pNh;
    private TextView pNi;
    private TextView pNj;
    private bqq tka;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressUI$2 */
    class C43462 implements OnClickListener {
        C43462() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45635);
            WalletLqtSaveFetchFinishProgressUI.this.finish();
            AppMethodBeat.m2505o(45635);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressUI$1 */
    class C225131 implements OnMenuItemClickListener {
        C225131() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(45634);
            WalletLqtSaveFetchFinishProgressUI.this.finish();
            AppMethodBeat.m2505o(45634);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        String format;
        AppMethodBeat.m2504i(45636);
        super.onCreate(bundle);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_redeem_res");
        this.tka = new bqq();
        try {
            this.tka.parseFrom(byteArrayExtra);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishProgressUI", e, "parse redeemFundRes error!", new Object[0]);
            finish();
        }
        String str = "MicroMsg.WalletLqtSaveFetchFinishProgressUI";
        String str2 = "onCreate, redeemRes: %s";
        Object[] objArr = new Object[1];
        if (this.tka != null) {
            format = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", new Object[]{Integer.valueOf(this.tka.status), this.tka.wSY, this.tka.wSZ, Integer.valueOf(this.tka.wOi), this.tka.nuL, this.tka.pck, this.tka.wTa});
        } else {
            format = "";
        }
        objArr[0] = format;
        C4990ab.m7417i(str, str2, objArr);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(C25738R.color.a69)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(2131821128);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(C25738R.color.f12085rt));
            }
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(C25738R.color.f11782h4));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(C8415j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(C25738R.color.a69));
            if (VERSION.SDK_INT >= 23) {
                getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }
        this.mController.contentView.setFitsSystemWindows(true);
        initView();
        showHomeBtn(false);
        enableBackMenu(false);
        mo17427pP(false);
        setMMTitle((int) C25738R.string.fii);
        setBackBtn(new C225131());
        AppMethodBeat.m2505o(45636);
    }

    public final void initView() {
        AppMethodBeat.m2504i(45637);
        this.pNb = (ImageView) findViewById(2131821647);
        this.pNc = (ImageView) findViewById(2131821651);
        this.pNd = (ImageView) findViewById(2131821655);
        this.pNb.setImageResource(C25738R.drawable.f6404d3);
        this.pNc.setScaleType(ScaleType.CENTER_CROP);
        this.pNc.setImageResource(C1318a.remittance_wait);
        this.pNd.setImageResource(C25738R.drawable.f6405d4);
        this.pNe = (TextView) findViewById(2131821648);
        this.pNf = (TextView) findViewById(2131821652);
        this.pNg = (TextView) findViewById(2131821656);
        this.pNe.setText(C25738R.string.fit);
        this.pNf.setText(this.tka.wSY);
        this.pNf.setTextColor(getResources().getColor(C25738R.color.f12212w4));
        this.pNg.setText(C25738R.string.f8y);
        this.pNh = (TextView) findViewById(2131821649);
        this.pNi = (TextView) findViewById(2131821653);
        this.pNj = (TextView) findViewById(2131821657);
        this.pNh.setVisibility(8);
        this.pNi.setText(this.tka.wSZ);
        this.pNi.setVisibility(0);
        this.pNj.setVisibility(8);
        this.nsy = (LinearLayout) findViewById(2131821660);
        this.nsy.setBackgroundResource(C25738R.drawable.f6403d2);
        WalletBalanceFetchResultItemView walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView((Context) this, true);
        walletBalanceFetchResultItemView.mo69468b(C25738R.string.fjn, C36391e.m59972G((double) (((float) this.tka.wOi) / 100.0f)));
        this.nsy.addView(walletBalanceFetchResultItemView);
        if (!C5046bo.isNullOrNil(this.tka.nuL)) {
            CharSequence charSequence = this.tka.nuL;
            if (!C5046bo.isNullOrNil(this.tka.pck)) {
                charSequence = charSequence + " " + getString(C25738R.string.foc) + this.tka.pck;
            }
            WalletBalanceFetchResultItemView walletBalanceFetchResultItemView2 = new WalletBalanceFetchResultItemView(this);
            walletBalanceFetchResultItemView2.mo69468b(C25738R.string.fih, charSequence);
            this.nsy.addView(walletBalanceFetchResultItemView2);
        }
        if (!C5046bo.isNullOrNil(this.tka.wTa)) {
            walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView(this);
            walletBalanceFetchResultItemView.mo69468b(C25738R.string.fid, this.tka.wTa);
            this.nsy.addView(walletBalanceFetchResultItemView);
        }
        ((Button) findViewById(2131821663)).setOnClickListener(new C43462());
        findViewById(2131821658).setVisibility(8);
        findViewById(2131821661).setVisibility(8);
        AppMethodBeat.m2505o(45637);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130968816;
    }
}
