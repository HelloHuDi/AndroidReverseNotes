package com.tencent.p177mm.plugin.wallet.pwd.p558ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32632si;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C22541p;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C35450e;
import com.tencent.p177mm.plugin.wallet_core.p749c.C29619r;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView.C30883a;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletLockCheckPwdUI */
public class WalletLockCheckPwdUI extends WalletBaseUI {
    /* renamed from: JU */
    private String f15069JU;
    private TextView iDT;
    private TextView kiF;
    private C29619r tlb;
    private EditHintPasswdView tsd;
    private int tse = -1;

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletLockCheckPwdUI$1 */
    class C354621 implements OnMenuItemClickListener {
        C354621() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(46337);
            C4990ab.m7416i("MicroMsg.WalletLockCheckPwdUI", "alvinluo cancel by BackBtn");
            WalletLockCheckPwdUI.m58212a(WalletLockCheckPwdUI.this);
            AppMethodBeat.m2505o(46337);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletLockCheckPwdUI$2 */
    class C354632 implements OnClickListener {
        C354632() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46338);
            C4990ab.m7416i("MicroMsg.WalletLockCheckPwdUI", "alvinluo cancel by BackBtn");
            WalletLockCheckPwdUI.m58212a(WalletLockCheckPwdUI.this);
            AppMethodBeat.m2505o(46338);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletLockCheckPwdUI$3 */
    class C354643 implements C30883a {
        C354643() {
        }

        /* renamed from: hY */
        public final void mo9438hY(boolean z) {
            int i = -1;
            AppMethodBeat.m2504i(46339);
            if (z) {
                if (WalletLockCheckPwdUI.this.f15069JU == null) {
                    AppMethodBeat.m2505o(46339);
                    return;
                } else if (WalletLockCheckPwdUI.this.f15069JU.equals("action.close_wallet_lock")) {
                    WalletLockCheckPwdUI.m58214c(WalletLockCheckPwdUI.this);
                    AppMethodBeat.m2505o(46339);
                    return;
                } else if (WalletLockCheckPwdUI.this.f15069JU.equals("action.verify_paypwd")) {
                    if (WalletLockCheckPwdUI.this.tse == 1) {
                        i = 6;
                    } else if (WalletLockCheckPwdUI.this.tse == 2) {
                        i = 8;
                    }
                    WalletLockCheckPwdUI.this.tlb = new C29619r(WalletLockCheckPwdUI.this.tsd.getText(), i, WalletLockCheckPwdUI.this.cNH());
                    WalletLockCheckPwdUI.this.mo39970a(WalletLockCheckPwdUI.this.tlb, true, false);
                    AppMethodBeat.m2505o(46339);
                    return;
                } else if (WalletLockCheckPwdUI.this.f15069JU.equals("action.touchlock_verify_by_paypwd")) {
                    WalletLockCheckPwdUI.this.mo39970a(new C22541p(WalletLockCheckPwdUI.this.tsd.getText()), true, false);
                    AppMethodBeat.m2505o(46339);
                    return;
                } else if (WalletLockCheckPwdUI.this.f15069JU.equals("action.touchlock_need_verify_paypwd")) {
                    if (WalletLockCheckPwdUI.this.tse == 2) {
                        i = 8;
                    }
                    WalletLockCheckPwdUI.this.tlb = new C29619r(WalletLockCheckPwdUI.this.tsd.getText(), i, WalletLockCheckPwdUI.this.cNH());
                    WalletLockCheckPwdUI.this.mo39970a(WalletLockCheckPwdUI.this.tlb, true, false);
                }
            }
            AppMethodBeat.m2505o(46339);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m58212a(WalletLockCheckPwdUI walletLockCheckPwdUI) {
        AppMethodBeat.m2504i(46348);
        walletLockCheckPwdUI.m58210Hk(4);
        AppMethodBeat.m2505o(46348);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46340);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.tse = getIntent().getIntExtra("key_wallet_lock_type", -1);
        this.f15069JU = getIntent().getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
        C4990ab.m7419v("MicroMsg.WalletLockCheckPwdUI", "alvinluo wallet lock type: %d, action: %s", Integer.valueOf(this.tse), this.f15069JU);
        this.tsd = (EditHintPasswdView) findViewById(2131824902);
        this.iDT = (TextView) findViewById(2131824899);
        this.kiF = (TextView) findViewById(2131828754);
        String stringExtra = getIntent().getStringExtra("key_wallet_lock_input_new_fp_tips");
        if (this.tse == 2) {
            this.iDT.setText(C25738R.string.fwe);
            if (this.f15069JU.equals("action.touchlock_need_verify_paypwd") && !C5046bo.isNullOrNil(stringExtra)) {
                this.kiF.setText(stringExtra);
            }
        } else if (this.tse == 1) {
            this.iDT.setText(C25738R.string.fwf);
        }
        this.tsd.setOnInputValidListener(new C354643());
        mo39989e(this.tsd, 0, false);
        setBackBtn(new C354621());
        findViewById(2131828753).setOnClickListener(new C354632());
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(C8415j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(C25738R.color.a69));
            if (VERSION.SDK_INT >= 23) {
                window.getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }
        this.mController.contentView.setFitsSystemWindows(true);
        AppMethodBeat.m2505o(46340);
    }

    public void onResume() {
        AppMethodBeat.m2504i(46341);
        super.onResume();
        if (this.tsd != null) {
            this.tsd.cey();
        }
        AppMethodBeat.m2505o(46341);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(46342);
        C4990ab.m7416i("MicroMsg.WalletLockCheckPwdUI", "alvinluo onBackPressed");
        m58210Hk(4);
        AppMethodBeat.m2505o(46342);
    }

    public final boolean bwQ() {
        return true;
    }

    public final int getLayoutId() {
        return 2130971083;
    }

    /* renamed from: wU */
    public final void mo8137wU(int i) {
        AppMethodBeat.m2504i(46343);
        super.mo8137wU(i);
        this.tsd.cey();
        AppMethodBeat.m2505o(46343);
    }

    /* renamed from: Hk */
    private void m58210Hk(int i) {
        AppMethodBeat.m2504i(46344);
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i);
        setResult(-1, intent);
        finish();
        AppMethodBeat.m2505o(46344);
    }

    /* renamed from: E */
    private void m58209E(int i, String str, String str2) {
        AppMethodBeat.m2504i(46345);
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i);
        intent.putExtra("key_token", str);
        intent.putExtra("key_type", str2);
        setResult(-1, intent);
        finish();
        AppMethodBeat.m2505o(46345);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46346);
        C4990ab.m7417i("MicroMsg.WalletLockCheckPwdUI", "alvinluo WalletLockCheckPwdUI errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (c1207m instanceof C29619r) {
            C29619r c29619r = (C29619r) c1207m;
            if (i == 0 && i2 == 0) {
                if ("next_action.switch_on_pattern".equals(getIntent().getStringExtra("next_action"))) {
                    C4990ab.m7416i("MicroMsg.WalletLockCheckPwdUI", "alvinluo start to open wallet lock after check pwd");
                    Intent intent = new Intent();
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.switch_on_pattern");
                    intent.putExtra("next_action", "next_action.switch_on_pattern");
                    intent.putExtra("token", c29619r.token);
                    intent.putExtra("type", c29619r.tuh);
                    intent.putExtra("key_wallet_lock_type", this.tse);
                    intent.setPackage(C4996ah.getPackageName());
                    if (this.tse == 2) {
                        intent.putExtra("key_pay_passwd", this.tsd.getText());
                    }
                    C32632si c32632si = new C32632si();
                    c32632si.cOC.cOE = intent;
                    c32632si.cOC.czX = this;
                    c32632si.cOC.requestCode = 1;
                    C4879a.xxA.mo10055m(c32632si);
                } else {
                    m58209E(0, c29619r.token, c29619r.tuh);
                }
                AppMethodBeat.m2505o(46346);
                return true;
            } else if (i == 1000 && i2 == 3) {
                m58209E(-1, null, null);
                AppMethodBeat.m2505o(46346);
                return true;
            }
        } else if (c1207m instanceof C22541p) {
            if (i == 0 && i2 == 0) {
                m58210Hk(0);
            } else {
                m58210Hk(-1);
            }
            AppMethodBeat.m2505o(46346);
            return true;
        } else if (c1207m instanceof C35450e) {
            if (i == 0 && i2 == 0) {
                m58210Hk(0);
            } else {
                m58210Hk(-1);
            }
        }
        AppMethodBeat.m2505o(46346);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        AppMethodBeat.m2504i(46347);
        String str = "MicroMsg.WalletLockCheckPwdUI";
        String str2 = "alvinluo WalletLockCheckPwdUI onActivityResult requestCode: %d, resultCode: %d, data == null: %b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (intent != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        C4990ab.m7419v(str, str2, objArr);
        setResult(i2, intent);
        finish();
        AppMethodBeat.m2505o(46347);
    }

    /* renamed from: c */
    static /* synthetic */ void m58214c(WalletLockCheckPwdUI walletLockCheckPwdUI) {
        AppMethodBeat.m2504i(46349);
        walletLockCheckPwdUI.mo39970a(new C35450e(walletLockCheckPwdUI.tsd.getText()), true, false);
        AppMethodBeat.m2505o(46349);
    }
}
