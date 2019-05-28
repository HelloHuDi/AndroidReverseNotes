package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.j;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.p;

@a(19)
public class BankRemitDetailUI extends BankRemitBaseUI {
    private int gqq;
    private int mState;
    private Button nsJ;
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
    private View pNk;
    private View pNl;
    private ViewGroup pNm;
    private String pNn;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44599);
        super.onCreate(bundle);
        nf(1579);
        this.pNn = getIntent().getStringExtra("key_transfer_bill_id");
        this.gqq = getIntent().getIntExtra("key_enter_scene", 0);
        ab.i("MicroMsg.BankRemitDetailUI", "billId: %s, enterScene: %s", this.pNn, Integer.valueOf(this.gqq));
        initView();
        ab.i("MicroMsg.BankRemitDetailUI", "do query detail");
        a(new l(this.pNn), true, true);
        if (this.gqq == 0) {
            showHomeBtn(false);
            enableBackMenu(false);
            setMMTitle((int) R.string.a4g);
        } else {
            showHomeBtn(true);
            enableBackMenu(true);
            setMMTitle((int) R.string.a4f);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(44594);
                ab.i("MicroMsg.BankRemitDetailUI", "back press");
                BankRemitDetailUI.this.finish();
                AppMethodBeat.o(44594);
                return false;
            }
        });
        AppMethodBeat.o(44599);
    }

    public final void initView() {
        AppMethodBeat.i(44600);
        this.pNb = (ImageView) findViewById(R.id.a2s);
        this.pNc = (ImageView) findViewById(R.id.a2w);
        this.pNd = (ImageView) findViewById(R.id.a30);
        this.pNe = (TextView) findViewById(R.id.a2t);
        this.pNf = (TextView) findViewById(R.id.a2x);
        this.pNg = (TextView) findViewById(R.id.a31);
        this.pNh = (TextView) findViewById(R.id.a2u);
        this.pNi = (TextView) findViewById(R.id.a2y);
        this.pNj = (TextView) findViewById(R.id.a32);
        this.pNk = findViewById(R.id.a2p);
        this.pNl = findViewById(R.id.a2q);
        this.nsy = (LinearLayout) findViewById(R.id.a35);
        this.pNm = (ViewGroup) findViewById(R.id.a2n);
        if (this.gqq == 1) {
            findViewById(R.id.a37).setVisibility(8);
            AppMethodBeat.o(44600);
            return;
        }
        this.nsJ = (Button) findViewById(R.id.a38);
        this.nsJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44595);
                ab.i("MicroMsg.BankRemitDetailUI", "click finish btn");
                BankRemitDetailUI.this.finish();
                AppMethodBeat.o(44595);
            }
        });
        AppMethodBeat.o(44600);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bFY() {
        AppMethodBeat.i(44601);
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
        }
        BankRemitBaseUI.Y(this);
        this.mController.contentView.setFitsSystemWindows(true);
        AppMethodBeat.o(44601);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(44602);
        if (mVar instanceof l) {
            final l lVar = (l) mVar;
            lVar.a(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44598);
                    ab.i("MicroMsg.BankRemitDetailUI", "state: %s, amount: %s, fee: %s, account: %s", Integer.valueOf(lVar.pLD.state), Integer.valueOf(lVar.pLD.nUf), Integer.valueOf(lVar.pLD.wQZ), lVar.pLD.wRa);
                    BankRemitDetailUI.this.mState = lVar.pLD.state;
                    BankRemitDetailUI.a(BankRemitDetailUI.this, lVar.pLD.state, lVar.pLD.wQY);
                    BankRemitDetailUI.a(BankRemitDetailUI.this, lVar.pLD);
                    BankRemitDetailUI.this.pNm.setVisibility(0);
                    AppMethodBeat.o(44598);
                }
            }).b(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44597);
                    ab.e("MicroMsg.BankRemitDetailUI", "detail reponse error: %s, %s", Integer.valueOf(lVar.pLD.kCl), lVar.pLD.kCm);
                    if (bo.isNullOrNil(lVar.pLD.kCm)) {
                        Toast.makeText(BankRemitDetailUI.this, R.string.a43, 1).show();
                        AppMethodBeat.o(44597);
                        return;
                    }
                    Toast.makeText(BankRemitDetailUI.this, lVar.pLD.kCm, 1).show();
                    AppMethodBeat.o(44597);
                }
            }).c(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44596);
                    ab.e("MicroMsg.BankRemitDetailUI", "net error: %s", mVar);
                    Toast.makeText(BankRemitDetailUI.this, R.string.a43, 1).show();
                    AppMethodBeat.o(44596);
                }
            });
        }
        AppMethodBeat.o(44602);
        return true;
    }

    public final int getLayoutId() {
        return R.layout.fs;
    }

    public void onDestroy() {
        AppMethodBeat.i(44603);
        super.onDestroy();
        ng(1579);
        AppMethodBeat.o(44603);
    }

    static /* synthetic */ void a(BankRemitDetailUI bankRemitDetailUI, int i, String str) {
        int i2 = 1;
        AppMethodBeat.i(44604);
        switch (i) {
            case 1:
                bankRemitDetailUI.pNc.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.pNc.setImageResource(R.raw.bank_remit_waiting);
                bankRemitDetailUI.pNi.setTextColor(bankRemitDetailUI.getResources().getColor(R.color.w4));
                bankRemitDetailUI.pNf.setText(R.string.a49);
                if (!bo.isNullOrNil(str)) {
                    bankRemitDetailUI.pNi.setText(str);
                    bankRemitDetailUI.pNi.setVisibility(0);
                    break;
                }
                break;
            case 2:
                bankRemitDetailUI.pNl.setBackground(bankRemitDetailUI.getResources().getDrawable(R.drawable.d5));
                bankRemitDetailUI.pNd.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.pNd.setImageResource(R.raw.bank_remit_success);
                bankRemitDetailUI.pNg.setTextColor(bankRemitDetailUI.getResources().getColor(R.color.w4));
                if (!bo.isNullOrNil(str)) {
                    bankRemitDetailUI.pNj.setText(str);
                    bankRemitDetailUI.pNj.setVisibility(0);
                    break;
                }
                break;
            case 3:
                bankRemitDetailUI.pNc.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.pNc.setImageResource(R.raw.bank_remit_delay);
                bankRemitDetailUI.pNf.setTextColor(bankRemitDetailUI.getResources().getColor(R.color.w4));
                bankRemitDetailUI.pNf.setText(R.string.a4a);
                if (!bo.isNullOrNil(str)) {
                    bankRemitDetailUI.pNi.setText(str);
                    bankRemitDetailUI.pNi.setVisibility(0);
                    break;
                }
                break;
            case 4:
                bankRemitDetailUI.pNc.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.pNc.setImageResource(R.raw.bank_remit_fail);
                bankRemitDetailUI.pNf.setTextColor(bankRemitDetailUI.getResources().getColor(R.color.w4));
                bankRemitDetailUI.pNf.setText(R.string.a4d);
                if (!bo.isNullOrNil(str)) {
                    bankRemitDetailUI.pNi.setText(str);
                    bankRemitDetailUI.pNi.setVisibility(0);
                    break;
                }
                break;
            case 5:
                bankRemitDetailUI.pNd.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.pNd.setImageResource(R.raw.bank_remit_fail);
                bankRemitDetailUI.pNg.setTextColor(bankRemitDetailUI.getResources().getColor(R.color.w4));
                bankRemitDetailUI.pNg.setText(R.string.a4b);
                if (!bo.isNullOrNil(str)) {
                    bankRemitDetailUI.pNj.setText(str);
                    bankRemitDetailUI.pNj.setVisibility(0);
                    break;
                }
                break;
            default:
                ab.w("MicroMsg.BankRemitDetailUI", "unknown state: %s", Integer.valueOf(bankRemitDetailUI.mState));
                i2 = 0;
                break;
        }
        if (i2 != 0) {
            bankRemitDetailUI.findViewById(R.id.a33).setVisibility(8);
        }
        AppMethodBeat.o(44604);
    }
}
