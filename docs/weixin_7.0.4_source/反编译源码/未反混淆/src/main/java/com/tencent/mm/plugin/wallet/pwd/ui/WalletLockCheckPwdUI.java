package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.j;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.si;
import com.tencent.mm.plugin.wallet.pwd.a.e;
import com.tencent.mm.plugin.wallet.pwd.a.p;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

public class WalletLockCheckPwdUI extends WalletBaseUI {
    private String JU;
    private TextView iDT;
    private TextView kiF;
    private r tlb;
    private EditHintPasswdView tsd;
    private int tse = -1;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(WalletLockCheckPwdUI walletLockCheckPwdUI) {
        AppMethodBeat.i(46348);
        walletLockCheckPwdUI.Hk(4);
        AppMethodBeat.o(46348);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46340);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.tse = getIntent().getIntExtra("key_wallet_lock_type", -1);
        this.JU = getIntent().getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
        ab.v("MicroMsg.WalletLockCheckPwdUI", "alvinluo wallet lock type: %d, action: %s", Integer.valueOf(this.tse), this.JU);
        this.tsd = (EditHintPasswdView) findViewById(R.id.cfs);
        this.iDT = (TextView) findViewById(R.id.cfp);
        this.kiF = (TextView) findViewById(R.id.f9x);
        String stringExtra = getIntent().getStringExtra("key_wallet_lock_input_new_fp_tips");
        if (this.tse == 2) {
            this.iDT.setText(R.string.fwe);
            if (this.JU.equals("action.touchlock_need_verify_paypwd") && !bo.isNullOrNil(stringExtra)) {
                this.kiF.setText(stringExtra);
            }
        } else if (this.tse == 1) {
            this.iDT.setText(R.string.fwf);
        }
        this.tsd.setOnInputValidListener(new a() {
            public final void hY(boolean z) {
                int i = -1;
                AppMethodBeat.i(46339);
                if (z) {
                    if (WalletLockCheckPwdUI.this.JU == null) {
                        AppMethodBeat.o(46339);
                        return;
                    } else if (WalletLockCheckPwdUI.this.JU.equals("action.close_wallet_lock")) {
                        WalletLockCheckPwdUI.c(WalletLockCheckPwdUI.this);
                        AppMethodBeat.o(46339);
                        return;
                    } else if (WalletLockCheckPwdUI.this.JU.equals("action.verify_paypwd")) {
                        if (WalletLockCheckPwdUI.this.tse == 1) {
                            i = 6;
                        } else if (WalletLockCheckPwdUI.this.tse == 2) {
                            i = 8;
                        }
                        WalletLockCheckPwdUI.this.tlb = new r(WalletLockCheckPwdUI.this.tsd.getText(), i, WalletLockCheckPwdUI.this.cNH());
                        WalletLockCheckPwdUI.this.a(WalletLockCheckPwdUI.this.tlb, true, false);
                        AppMethodBeat.o(46339);
                        return;
                    } else if (WalletLockCheckPwdUI.this.JU.equals("action.touchlock_verify_by_paypwd")) {
                        WalletLockCheckPwdUI.this.a(new p(WalletLockCheckPwdUI.this.tsd.getText()), true, false);
                        AppMethodBeat.o(46339);
                        return;
                    } else if (WalletLockCheckPwdUI.this.JU.equals("action.touchlock_need_verify_paypwd")) {
                        if (WalletLockCheckPwdUI.this.tse == 2) {
                            i = 8;
                        }
                        WalletLockCheckPwdUI.this.tlb = new r(WalletLockCheckPwdUI.this.tsd.getText(), i, WalletLockCheckPwdUI.this.cNH());
                        WalletLockCheckPwdUI.this.a(WalletLockCheckPwdUI.this.tlb, true, false);
                    }
                }
                AppMethodBeat.o(46339);
            }
        });
        e(this.tsd, 0, false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(46337);
                ab.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo cancel by BackBtn");
                WalletLockCheckPwdUI.a(WalletLockCheckPwdUI.this);
                AppMethodBeat.o(46337);
                return true;
            }
        });
        findViewById(R.id.f9w).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(46338);
                ab.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo cancel by BackBtn");
                WalletLockCheckPwdUI.a(WalletLockCheckPwdUI.this);
                AppMethodBeat.o(46338);
            }
        });
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(R.color.a69));
            if (VERSION.SDK_INT >= 23) {
                window.getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }
        this.mController.contentView.setFitsSystemWindows(true);
        AppMethodBeat.o(46340);
    }

    public void onResume() {
        AppMethodBeat.i(46341);
        super.onResume();
        if (this.tsd != null) {
            this.tsd.cey();
        }
        AppMethodBeat.o(46341);
    }

    public void onBackPressed() {
        AppMethodBeat.i(46342);
        ab.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo onBackPressed");
        Hk(4);
        AppMethodBeat.o(46342);
    }

    public final boolean bwQ() {
        return true;
    }

    public final int getLayoutId() {
        return R.layout.b3u;
    }

    public final void wU(int i) {
        AppMethodBeat.i(46343);
        super.wU(i);
        this.tsd.cey();
        AppMethodBeat.o(46343);
    }

    private void Hk(int i) {
        AppMethodBeat.i(46344);
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i);
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(46344);
    }

    private void E(int i, String str, String str2) {
        AppMethodBeat.i(46345);
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i);
        intent.putExtra("key_token", str);
        intent.putExtra("key_type", str2);
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(46345);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46346);
        ab.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo WalletLockCheckPwdUI errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (mVar instanceof r) {
            r rVar = (r) mVar;
            if (i == 0 && i2 == 0) {
                if ("next_action.switch_on_pattern".equals(getIntent().getStringExtra("next_action"))) {
                    ab.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo start to open wallet lock after check pwd");
                    Intent intent = new Intent();
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.switch_on_pattern");
                    intent.putExtra("next_action", "next_action.switch_on_pattern");
                    intent.putExtra("token", rVar.token);
                    intent.putExtra("type", rVar.tuh);
                    intent.putExtra("key_wallet_lock_type", this.tse);
                    intent.setPackage(ah.getPackageName());
                    if (this.tse == 2) {
                        intent.putExtra("key_pay_passwd", this.tsd.getText());
                    }
                    si siVar = new si();
                    siVar.cOC.cOE = intent;
                    siVar.cOC.czX = this;
                    siVar.cOC.requestCode = 1;
                    com.tencent.mm.sdk.b.a.xxA.m(siVar);
                } else {
                    E(0, rVar.token, rVar.tuh);
                }
                AppMethodBeat.o(46346);
                return true;
            } else if (i == 1000 && i2 == 3) {
                E(-1, null, null);
                AppMethodBeat.o(46346);
                return true;
            }
        } else if (mVar instanceof p) {
            if (i == 0 && i2 == 0) {
                Hk(0);
            } else {
                Hk(-1);
            }
            AppMethodBeat.o(46346);
            return true;
        } else if (mVar instanceof e) {
            if (i == 0 && i2 == 0) {
                Hk(0);
            } else {
                Hk(-1);
            }
        }
        AppMethodBeat.o(46346);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        AppMethodBeat.i(46347);
        String str = "MicroMsg.WalletLockCheckPwdUI";
        String str2 = "alvinluo WalletLockCheckPwdUI onActivityResult requestCode: %d, resultCode: %d, data == null: %b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (intent != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        ab.v(str, str2, objArr);
        setResult(i2, intent);
        finish();
        AppMethodBeat.o(46347);
    }

    static /* synthetic */ void c(WalletLockCheckPwdUI walletLockCheckPwdUI) {
        AppMethodBeat.i(46349);
        walletLockCheckPwdUI.a(new e(walletLockCheckPwdUI.tsd.getText()), true, false);
        AppMethodBeat.o(46349);
    }
}
