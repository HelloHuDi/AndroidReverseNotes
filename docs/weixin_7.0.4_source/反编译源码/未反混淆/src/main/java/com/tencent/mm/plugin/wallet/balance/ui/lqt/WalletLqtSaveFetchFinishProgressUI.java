package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.j;
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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        String format;
        AppMethodBeat.i(45636);
        super.onCreate(bundle);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_redeem_res");
        this.tka = new bqq();
        try {
            this.tka.parseFrom(byteArrayExtra);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishProgressUI", e, "parse redeemFundRes error!", new Object[0]);
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
        ab.i(str, str2, objArr);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.a69)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.id.p3);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(R.color.rt));
            }
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(R.color.h4));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(R.color.a69));
            if (VERSION.SDK_INT >= 23) {
                getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }
        this.mController.contentView.setFitsSystemWindows(true);
        initView();
        showHomeBtn(false);
        enableBackMenu(false);
        pP(false);
        setMMTitle((int) R.string.fii);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(45634);
                WalletLqtSaveFetchFinishProgressUI.this.finish();
                AppMethodBeat.o(45634);
                return false;
            }
        });
        AppMethodBeat.o(45636);
    }

    public final void initView() {
        AppMethodBeat.i(45637);
        this.pNb = (ImageView) findViewById(R.id.a2s);
        this.pNc = (ImageView) findViewById(R.id.a2w);
        this.pNd = (ImageView) findViewById(R.id.a30);
        this.pNb.setImageResource(R.drawable.d3);
        this.pNc.setScaleType(ScaleType.CENTER_CROP);
        this.pNc.setImageResource(R.raw.remittance_wait);
        this.pNd.setImageResource(R.drawable.d4);
        this.pNe = (TextView) findViewById(R.id.a2t);
        this.pNf = (TextView) findViewById(R.id.a2x);
        this.pNg = (TextView) findViewById(R.id.a31);
        this.pNe.setText(R.string.fit);
        this.pNf.setText(this.tka.wSY);
        this.pNf.setTextColor(getResources().getColor(R.color.w4));
        this.pNg.setText(R.string.f8y);
        this.pNh = (TextView) findViewById(R.id.a2u);
        this.pNi = (TextView) findViewById(R.id.a2y);
        this.pNj = (TextView) findViewById(R.id.a32);
        this.pNh.setVisibility(8);
        this.pNi.setText(this.tka.wSZ);
        this.pNi.setVisibility(0);
        this.pNj.setVisibility(8);
        this.nsy = (LinearLayout) findViewById(R.id.a35);
        this.nsy.setBackgroundResource(R.drawable.d2);
        WalletBalanceFetchResultItemView walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView((Context) this, true);
        walletBalanceFetchResultItemView.b(R.string.fjn, e.G((double) (((float) this.tka.wOi) / 100.0f)));
        this.nsy.addView(walletBalanceFetchResultItemView);
        if (!bo.isNullOrNil(this.tka.nuL)) {
            CharSequence charSequence = this.tka.nuL;
            if (!bo.isNullOrNil(this.tka.pck)) {
                charSequence = charSequence + " " + getString(R.string.foc) + this.tka.pck;
            }
            WalletBalanceFetchResultItemView walletBalanceFetchResultItemView2 = new WalletBalanceFetchResultItemView(this);
            walletBalanceFetchResultItemView2.b(R.string.fih, charSequence);
            this.nsy.addView(walletBalanceFetchResultItemView2);
        }
        if (!bo.isNullOrNil(this.tka.wTa)) {
            walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView(this);
            walletBalanceFetchResultItemView.b(R.string.fid, this.tka.wTa);
            this.nsy.addView(walletBalanceFetchResultItemView);
        }
        ((Button) findViewById(R.id.a38)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45635);
                WalletLqtSaveFetchFinishProgressUI.this.finish();
                AppMethodBeat.o(45635);
            }
        });
        findViewById(R.id.a33).setVisibility(8);
        findViewById(R.id.a36).setVisibility(8);
        AppMethodBeat.o(45637);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.fs;
    }
}
