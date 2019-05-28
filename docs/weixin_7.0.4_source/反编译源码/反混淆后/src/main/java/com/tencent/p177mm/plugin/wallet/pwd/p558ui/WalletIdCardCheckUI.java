package com.tencent.p177mm.plugin.wallet.pwd.p558ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p232b.p233a.C42088bj;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C30860n;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a.C30895a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView.C36397a;
import com.tencent.p177mm.wallet_core.p650ui.formview.p1098a.C30889b;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI */
public class WalletIdCardCheckUI extends WalletBaseUI implements OnEditorActionListener, C36397a {
    private WalletFormView trX;
    private TextView trY;
    private TextView trZ;
    private Button tsa;
    private int tsb = 1;

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI$3 */
    class C43793 implements OnClickListener {
        C43793() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46324);
            WalletIdCardCheckUI.this.setResult(-1);
            WalletIdCardCheckUI.this.finish();
            AppMethodBeat.m2505o(46324);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI$1 */
    class C142151 implements OnMenuItemClickListener {
        C142151() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(46322);
            C4990ab.m7416i("Micromsg.WalletIdCardCheckUI", "onbackbtn click");
            WalletIdCardCheckUI.this.finish();
            AppMethodBeat.m2505o(46322);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI$2 */
    class C142162 implements View.OnClickListener {
        C142162() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46323);
            if (WalletIdCardCheckUI.m61238a(WalletIdCardCheckUI.this)) {
                C42088bj c42088bj = new C42088bj();
                c42088bj.cVT = 1;
                c42088bj.dcm = 1;
                c42088bj.ajK();
                C7060h.pYm.mo8381e(13731, Integer.valueOf(2));
                WalletIdCardCheckUI.this.mo39970a(new C30860n(WalletIdCardCheckUI.this.trX.getText(), WalletIdCardCheckUI.this.tsb, C14241r.cPI().bhp()), true, true);
            }
            AppMethodBeat.m2505o(46323);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130971081;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46325);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.fmo);
        mo39992nf(1580);
        initView();
        setBackBtn(new C142151());
        AppMethodBeat.m2505o(46325);
    }

    public final void bLz() {
        AppMethodBeat.m2504i(46326);
        C4990ab.m7410d("Micromsg.WalletIdCardCheckUI", "check pwd ");
        this.Ahr.bLz();
        AppMethodBeat.m2505o(46326);
    }

    public void onResume() {
        AppMethodBeat.m2504i(46327);
        super.onResume();
        AppMethodBeat.m2505o(46327);
    }

    public void onPause() {
        AppMethodBeat.m2504i(46328);
        super.onPause();
        AppMethodBeat.m2505o(46328);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(46329);
        super.onDestroy();
        mo39993ng(1580);
        AppMethodBeat.m2505o(46329);
    }

    public final void initView() {
        AppMethodBeat.m2504i(46330);
        this.trX = (WalletFormView) findViewById(2131828720);
        this.trZ = (TextView) findViewById(2131828729);
        this.trY = (TextView) findViewById(2131828718);
        this.trX.setOnInputValidChangeListener(this);
        this.trX.setOnEditorActionListener(this);
        this.trZ.setVisibility(4);
        this.tsa = (Button) findViewById(2131828749);
        C30890a.m49298d(this.trX);
        mo39989e(this.trX, 1, false);
        this.tsa.setOnClickListener(new C142162());
        this.tsb = C14241r.cPI().cQq();
        String cQr = C14241r.cPI().cQr();
        C4990ab.m7417i("Micromsg.WalletIdCardCheckUI", "mIdentityType %d %s", Integer.valueOf(this.tsb), cQr);
        if (C5046bo.isNullOrNil(cQr)) {
            cQr = C14241r.cPQ().mo9419Z(this, this.tsb);
        }
        WalletIdCardCheckUI.m61237a(this.trX, this.tsb);
        this.trX.setTitleText(cQr);
        this.trX.cey();
        m61236Hj(this.tsb);
        cQr = C14241r.cPI().bhp();
        this.trX.setHint(getString(C25738R.string.fmg, new Object[]{C36391e.atw(cQr)}));
        AppMethodBeat.m2505o(46330);
    }

    /* renamed from: Hj */
    private void m61236Hj(int i) {
        AppMethodBeat.m2504i(46331);
        if (i == 1) {
            mo39989e(this.trX, 1, false);
            AppMethodBeat.m2505o(46331);
            return;
        }
        mo39989e(this.trX, 1, true);
        AppMethodBeat.m2505o(46331);
    }

    /* renamed from: a */
    private static void m61237a(WalletFormView walletFormView, int i) {
        AppMethodBeat.m2504i(46332);
        C30889b logicDelegate = walletFormView.getLogicDelegate();
        if (logicDelegate instanceof C30895a) {
            ((C30895a) logicDelegate).mo49420QT(i);
        }
        AppMethodBeat.m2505o(46332);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(46333);
        if (this.nTi == null || !this.nTi.isShown()) {
            boolean onKeyUp = super.onKeyUp(i, keyEvent);
            AppMethodBeat.m2505o(46333);
            return onKeyUp;
        }
        this.nTi.setVisibility(8);
        AppMethodBeat.m2505o(46333);
        return true;
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* renamed from: i */
    public final boolean mo39991i(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46334);
        C4990ab.m7410d("Micromsg.WalletIdCardCheckUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0 && (c1207m instanceof C30860n)) {
            C42088bj c42088bj = new C42088bj();
            c42088bj.cVT = 1;
            c42088bj.dcm = 2;
            c42088bj.ajK();
            C30379h.m48447a((Context) this, getString(C25738R.string.fmj), "", getString(C25738R.string.ffp), false, new C43793());
        }
        AppMethodBeat.m2505o(46334);
        return true;
    }

    /* renamed from: hY */
    public final void mo9407hY(boolean z) {
        AppMethodBeat.m2504i(46335);
        this.trZ.setVisibility(4);
        AppMethodBeat.m2505o(46335);
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m61238a(WalletIdCardCheckUI walletIdCardCheckUI) {
        AppMethodBeat.m2504i(46336);
        boolean z = true;
        if (!walletIdCardCheckUI.trX.mo64602fx(walletIdCardCheckUI.trZ)) {
            walletIdCardCheckUI.trZ.setText(C25738R.string.fbg);
            walletIdCardCheckUI.trZ.setTextColor(walletIdCardCheckUI.getResources().getColor(C25738R.color.f12266xy));
            z = false;
        }
        if (z) {
            walletIdCardCheckUI.trZ.setVisibility(4);
        } else {
            walletIdCardCheckUI.trZ.setVisibility(0);
        }
        AppMethodBeat.m2505o(46336);
        return z;
    }
}
