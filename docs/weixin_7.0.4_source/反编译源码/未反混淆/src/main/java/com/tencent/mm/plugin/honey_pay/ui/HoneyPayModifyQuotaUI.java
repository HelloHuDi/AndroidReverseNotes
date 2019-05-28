package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.RoundingMode;

public class HoneyPayModifyQuotaUI extends HoneyPayBaseUI {
    private long nrO;
    private long nrP;
    private String nra;
    private WalletFormView nsI;
    private Button nsJ;
    private TextView nsn;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41916);
        super.onCreate(bundle);
        this.nrO = getIntent().getLongExtra("key_max_credit_line", 0);
        this.nrP = getIntent().getLongExtra("key_min_credit_line", 0);
        this.nra = getIntent().getStringExtra("key_card_no");
        initView();
        setMMTitle((int) R.string.ccu);
        AppMethodBeat.o(41916);
    }

    public final void initView() {
        AppMethodBeat.i(41917);
        this.nsI = (WalletFormView) findViewById(R.id.cgg);
        this.nsJ = (Button) findViewById(R.id.cgh);
        this.nsn = (TextView) findViewById(R.id.cgi);
        this.nsI.dOP();
        this.nsI.getTitleTv().setText(ae.dOd());
        e(this.nsI, 2, false);
        this.nsI.a(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(41913);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
                HoneyPayModifyQuotaUI.a(HoneyPayModifyQuotaUI.this);
                AppMethodBeat.o(41913);
            }
        });
        this.nsJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41914);
                if (HoneyPayModifyQuotaUI.a(HoneyPayModifyQuotaUI.this)) {
                    HoneyPayModifyQuotaUI.b(HoneyPayModifyQuotaUI.this);
                    HoneyPayModifyQuotaUI.this.aoB();
                }
                AppMethodBeat.o(41914);
            }
        });
        this.nsI.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(41915);
                HoneyPayModifyQuotaUI.this.nsI.f(HoneyPayModifyQuotaUI.this);
                AppMethodBeat.o(41915);
            }
        }, 100);
        AppMethodBeat.o(41917);
    }

    public void onDestroy() {
        AppMethodBeat.i(41918);
        super.onDestroy();
        AppMethodBeat.o(41918);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(41919);
        if (i == 1 && i2 == -1 && intent.getBooleanExtra("key_modify_create_line_succ", false)) {
            setResult(-1, intent);
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(41919);
    }

    public final int getLayoutId() {
        return R.layout.a76;
    }

    private void hZ(boolean z) {
        AppMethodBeat.i(41920);
        if (!z || this.nsn.isShown()) {
            if (!z && this.nsn.isShown()) {
                this.nsn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.c1));
                this.nsn.setVisibility(8);
            }
            AppMethodBeat.o(41920);
            return;
        }
        String str = ae.dOd() + e.a(this.nrP, "100", 2, RoundingMode.HALF_UP).toString();
        this.nsn.setText(getString(R.string.cct, new Object[]{str}));
        this.nsn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bh));
        this.nsn.setVisibility(0);
        AppMethodBeat.o(41920);
    }

    private void ia(boolean z) {
        AppMethodBeat.i(41921);
        if (!z || this.nsn.isShown()) {
            if (!z && this.nsn.isShown()) {
                this.nsn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.c1));
                this.nsn.setVisibility(8);
            }
            AppMethodBeat.o(41921);
            return;
        }
        String str = ae.dOd() + e.a(this.nrO, "100", 2, RoundingMode.HALF_UP);
        this.nsn.setText(getString(R.string.ccp, new Object[]{str}));
        this.nsn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bh));
        this.nsn.setVisibility(0);
        AppMethodBeat.o(41921);
    }

    private void ib(boolean z) {
        AppMethodBeat.i(41922);
        this.nsJ.setEnabled(z);
        AppMethodBeat.o(41922);
    }

    static /* synthetic */ boolean a(HoneyPayModifyQuotaUI honeyPayModifyQuotaUI) {
        AppMethodBeat.i(41923);
        if (bo.isNullOrNil(honeyPayModifyQuotaUI.nsI.getText())) {
            honeyPayModifyQuotaUI.ia(false);
            honeyPayModifyQuotaUI.hZ(false);
            honeyPayModifyQuotaUI.ib(false);
            AppMethodBeat.o(41923);
            return false;
        }
        int iy = e.iy(honeyPayModifyQuotaUI.nsI.getText(), "100");
        ab.d(honeyPayModifyQuotaUI.TAG, "current fen: %s", Integer.valueOf(iy));
        if (((long) iy) < honeyPayModifyQuotaUI.nrP) {
            honeyPayModifyQuotaUI.hZ(true);
            honeyPayModifyQuotaUI.ib(false);
            AppMethodBeat.o(41923);
            return false;
        } else if (((long) iy) > honeyPayModifyQuotaUI.nrO) {
            honeyPayModifyQuotaUI.ia(true);
            honeyPayModifyQuotaUI.ib(false);
            AppMethodBeat.o(41923);
            return false;
        } else if (iy == 0) {
            honeyPayModifyQuotaUI.ib(false);
            AppMethodBeat.o(41923);
            return false;
        } else {
            honeyPayModifyQuotaUI.ia(false);
            honeyPayModifyQuotaUI.hZ(false);
            honeyPayModifyQuotaUI.ib(true);
            AppMethodBeat.o(41923);
            return true;
        }
    }

    static /* synthetic */ void b(HoneyPayModifyQuotaUI honeyPayModifyQuotaUI) {
        AppMethodBeat.i(41924);
        ab.i(honeyPayModifyQuotaUI.TAG, "go to check pwd ui");
        long iz = e.iz(honeyPayModifyQuotaUI.nsI.getText(), "100");
        Intent intent = new Intent(honeyPayModifyQuotaUI, HoneyPayCheckPwdUI.class);
        intent.putExtra("key_scene", 2);
        intent.putExtra("key_credit_line", iz);
        intent.putExtra("key_card_no", honeyPayModifyQuotaUI.nra);
        honeyPayModifyQuotaUI.startActivityForResult(intent, 1);
        AppMethodBeat.o(41924);
    }
}
