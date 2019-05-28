package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a.b;

@a(3)
public class WalletIdCardCheckUI extends WalletBaseUI implements OnEditorActionListener, WalletFormView.a {
    private WalletFormView trX;
    private TextView trY;
    private TextView trZ;
    private Button tsa;
    private int tsb = 1;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.b3s;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46325);
        super.onCreate(bundle);
        setMMTitle((int) R.string.fmo);
        nf(1580);
        initView();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(46322);
                ab.i("Micromsg.WalletIdCardCheckUI", "onbackbtn click");
                WalletIdCardCheckUI.this.finish();
                AppMethodBeat.o(46322);
                return false;
            }
        });
        AppMethodBeat.o(46325);
    }

    public final void bLz() {
        AppMethodBeat.i(46326);
        ab.d("Micromsg.WalletIdCardCheckUI", "check pwd ");
        this.Ahr.bLz();
        AppMethodBeat.o(46326);
    }

    public void onResume() {
        AppMethodBeat.i(46327);
        super.onResume();
        AppMethodBeat.o(46327);
    }

    public void onPause() {
        AppMethodBeat.i(46328);
        super.onPause();
        AppMethodBeat.o(46328);
    }

    public void onDestroy() {
        AppMethodBeat.i(46329);
        super.onDestroy();
        ng(1580);
        AppMethodBeat.o(46329);
    }

    public final void initView() {
        AppMethodBeat.i(46330);
        this.trX = (WalletFormView) findViewById(R.id.f90);
        this.trZ = (TextView) findViewById(R.id.f99);
        this.trY = (TextView) findViewById(R.id.f8y);
        this.trX.setOnInputValidChangeListener(this);
        this.trX.setOnEditorActionListener(this);
        this.trZ.setVisibility(4);
        this.tsa = (Button) findViewById(R.id.f9s);
        com.tencent.mm.wallet_core.ui.formview.a.d(this.trX);
        e(this.trX, 1, false);
        this.tsa.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(46323);
                if (WalletIdCardCheckUI.a(WalletIdCardCheckUI.this)) {
                    bj bjVar = new bj();
                    bjVar.cVT = 1;
                    bjVar.dcm = 1;
                    bjVar.ajK();
                    h.pYm.e(13731, Integer.valueOf(2));
                    WalletIdCardCheckUI.this.a(new n(WalletIdCardCheckUI.this.trX.getText(), WalletIdCardCheckUI.this.tsb, r.cPI().bhp()), true, true);
                }
                AppMethodBeat.o(46323);
            }
        });
        this.tsb = r.cPI().cQq();
        String cQr = r.cPI().cQr();
        ab.i("Micromsg.WalletIdCardCheckUI", "mIdentityType %d %s", Integer.valueOf(this.tsb), cQr);
        if (bo.isNullOrNil(cQr)) {
            cQr = r.cPQ().Z(this, this.tsb);
        }
        a(this.trX, this.tsb);
        this.trX.setTitleText(cQr);
        this.trX.cey();
        Hj(this.tsb);
        cQr = r.cPI().bhp();
        this.trX.setHint(getString(R.string.fmg, new Object[]{e.atw(cQr)}));
        AppMethodBeat.o(46330);
    }

    private void Hj(int i) {
        AppMethodBeat.i(46331);
        if (i == 1) {
            e(this.trX, 1, false);
            AppMethodBeat.o(46331);
            return;
        }
        e(this.trX, 1, true);
        AppMethodBeat.o(46331);
    }

    private static void a(WalletFormView walletFormView, int i) {
        AppMethodBeat.i(46332);
        b logicDelegate = walletFormView.getLogicDelegate();
        if (logicDelegate instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) logicDelegate).QT(i);
        }
        AppMethodBeat.o(46332);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(46333);
        if (this.nTi == null || !this.nTi.isShown()) {
            boolean onKeyUp = super.onKeyUp(i, keyEvent);
            AppMethodBeat.o(46333);
            return onKeyUp;
        }
        this.nTi.setVisibility(8);
        AppMethodBeat.o(46333);
        return true;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final boolean i(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46334);
        ab.d("Micromsg.WalletIdCardCheckUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0 && (mVar instanceof n)) {
            bj bjVar = new bj();
            bjVar.cVT = 1;
            bjVar.dcm = 2;
            bjVar.ajK();
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fmj), "", getString(R.string.ffp), false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(46324);
                    WalletIdCardCheckUI.this.setResult(-1);
                    WalletIdCardCheckUI.this.finish();
                    AppMethodBeat.o(46324);
                }
            });
        }
        AppMethodBeat.o(46334);
        return true;
    }

    public final void hY(boolean z) {
        AppMethodBeat.i(46335);
        this.trZ.setVisibility(4);
        AppMethodBeat.o(46335);
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }

    static /* synthetic */ boolean a(WalletIdCardCheckUI walletIdCardCheckUI) {
        AppMethodBeat.i(46336);
        boolean z = true;
        if (!walletIdCardCheckUI.trX.fx(walletIdCardCheckUI.trZ)) {
            walletIdCardCheckUI.trZ.setText(R.string.fbg);
            walletIdCardCheckUI.trZ.setTextColor(walletIdCardCheckUI.getResources().getColor(R.color.xy));
            z = false;
        }
        if (z) {
            walletIdCardCheckUI.trZ.setVisibility(4);
        } else {
            walletIdCardCheckUI.trZ.setVisibility(0);
        }
        AppMethodBeat.o(46336);
        return z;
    }
}
