package com.tencent.p177mm.plugin.honey_pay.p435ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import java.math.RoundingMode;

/* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayModifyQuotaUI */
public class HoneyPayModifyQuotaUI extends HoneyPayBaseUI {
    private long nrO;
    private long nrP;
    private String nra;
    private WalletFormView nsI;
    private Button nsJ;
    private TextView nsn;

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayModifyQuotaUI$3 */
    class C122363 implements Runnable {
        C122363() {
        }

        public final void run() {
            AppMethodBeat.m2504i(41915);
            HoneyPayModifyQuotaUI.this.nsI.mo64601f(HoneyPayModifyQuotaUI.this);
            AppMethodBeat.m2505o(41915);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayModifyQuotaUI$1 */
    class C122371 implements TextWatcher {
        C122371() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(41913);
            if (editable.toString().startsWith(".")) {
                editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            String obj = editable.toString();
            int indexOf = obj.indexOf(".");
            int length = obj.length();
            if (indexOf >= 0 && length - indexOf > 2) {
                editable.delete(indexOf + 3, length);
            }
            HoneyPayModifyQuotaUI.m20161a(HoneyPayModifyQuotaUI.this);
            AppMethodBeat.m2505o(41913);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayModifyQuotaUI$2 */
    class C122382 implements OnClickListener {
        C122382() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41914);
            if (HoneyPayModifyQuotaUI.m20161a(HoneyPayModifyQuotaUI.this)) {
                HoneyPayModifyQuotaUI.m20162b(HoneyPayModifyQuotaUI.this);
                HoneyPayModifyQuotaUI.this.aoB();
            }
            AppMethodBeat.m2505o(41914);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41916);
        super.onCreate(bundle);
        this.nrO = getIntent().getLongExtra("key_max_credit_line", 0);
        this.nrP = getIntent().getLongExtra("key_min_credit_line", 0);
        this.nra = getIntent().getStringExtra("key_card_no");
        initView();
        setMMTitle((int) C25738R.string.ccu);
        AppMethodBeat.m2505o(41916);
    }

    public final void initView() {
        AppMethodBeat.m2504i(41917);
        this.nsI = (WalletFormView) findViewById(2131824927);
        this.nsJ = (Button) findViewById(2131824928);
        this.nsn = (TextView) findViewById(2131824929);
        this.nsI.dOP();
        this.nsI.getTitleTv().setText(C44423ae.dOd());
        mo39989e(this.nsI, 2, false);
        this.nsI.mo64594a(new C122371());
        this.nsJ.setOnClickListener(new C122382());
        this.nsI.postDelayed(new C122363(), 100);
        AppMethodBeat.m2505o(41917);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41918);
        super.onDestroy();
        AppMethodBeat.m2505o(41918);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(41919);
        if (i == 1 && i2 == -1 && intent.getBooleanExtra("key_modify_create_line_succ", false)) {
            setResult(-1, intent);
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(41919);
    }

    public final int getLayoutId() {
        return 2130969833;
    }

    /* renamed from: hZ */
    private void m20164hZ(boolean z) {
        AppMethodBeat.m2504i(41920);
        if (!z || this.nsn.isShown()) {
            if (!z && this.nsn.isShown()) {
                this.nsn.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8359c1));
                this.nsn.setVisibility(8);
            }
            AppMethodBeat.m2505o(41920);
            return;
        }
        String str = C44423ae.dOd() + C36391e.m59981a(this.nrP, "100", 2, RoundingMode.HALF_UP).toString();
        this.nsn.setText(getString(C25738R.string.cct, new Object[]{str}));
        this.nsn.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8343bh));
        this.nsn.setVisibility(0);
        AppMethodBeat.m2505o(41920);
    }

    /* renamed from: ia */
    private void m20165ia(boolean z) {
        AppMethodBeat.m2504i(41921);
        if (!z || this.nsn.isShown()) {
            if (!z && this.nsn.isShown()) {
                this.nsn.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8359c1));
                this.nsn.setVisibility(8);
            }
            AppMethodBeat.m2505o(41921);
            return;
        }
        String str = C44423ae.dOd() + C36391e.m59981a(this.nrO, "100", 2, RoundingMode.HALF_UP);
        this.nsn.setText(getString(C25738R.string.ccp, new Object[]{str}));
        this.nsn.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8343bh));
        this.nsn.setVisibility(0);
        AppMethodBeat.m2505o(41921);
    }

    /* renamed from: ib */
    private void m20166ib(boolean z) {
        AppMethodBeat.m2504i(41922);
        this.nsJ.setEnabled(z);
        AppMethodBeat.m2505o(41922);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m20161a(HoneyPayModifyQuotaUI honeyPayModifyQuotaUI) {
        AppMethodBeat.m2504i(41923);
        if (C5046bo.isNullOrNil(honeyPayModifyQuotaUI.nsI.getText())) {
            honeyPayModifyQuotaUI.m20165ia(false);
            honeyPayModifyQuotaUI.m20164hZ(false);
            honeyPayModifyQuotaUI.m20166ib(false);
            AppMethodBeat.m2505o(41923);
            return false;
        }
        int iy = C36391e.m60012iy(honeyPayModifyQuotaUI.nsI.getText(), "100");
        C4990ab.m7411d(honeyPayModifyQuotaUI.TAG, "current fen: %s", Integer.valueOf(iy));
        if (((long) iy) < honeyPayModifyQuotaUI.nrP) {
            honeyPayModifyQuotaUI.m20164hZ(true);
            honeyPayModifyQuotaUI.m20166ib(false);
            AppMethodBeat.m2505o(41923);
            return false;
        } else if (((long) iy) > honeyPayModifyQuotaUI.nrO) {
            honeyPayModifyQuotaUI.m20165ia(true);
            honeyPayModifyQuotaUI.m20166ib(false);
            AppMethodBeat.m2505o(41923);
            return false;
        } else if (iy == 0) {
            honeyPayModifyQuotaUI.m20166ib(false);
            AppMethodBeat.m2505o(41923);
            return false;
        } else {
            honeyPayModifyQuotaUI.m20165ia(false);
            honeyPayModifyQuotaUI.m20164hZ(false);
            honeyPayModifyQuotaUI.m20166ib(true);
            AppMethodBeat.m2505o(41923);
            return true;
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m20162b(HoneyPayModifyQuotaUI honeyPayModifyQuotaUI) {
        AppMethodBeat.m2504i(41924);
        C4990ab.m7416i(honeyPayModifyQuotaUI.TAG, "go to check pwd ui");
        long iz = C36391e.m60013iz(honeyPayModifyQuotaUI.nsI.getText(), "100");
        Intent intent = new Intent(honeyPayModifyQuotaUI, HoneyPayCheckPwdUI.class);
        intent.putExtra("key_scene", 2);
        intent.putExtra("key_credit_line", iz);
        intent.putExtra("key_card_no", honeyPayModifyQuotaUI.nra);
        honeyPayModifyQuotaUI.startActivityForResult(intent, 1);
        AppMethodBeat.m2505o(41924);
    }
}
