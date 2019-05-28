package com.tencent.p177mm.plugin.collect.p368ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30387b;
import com.tencent.p177mm.plugin.collect.model.C20266s;
import com.tencent.p177mm.plugin.collect.model.C2833m;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.C22657a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;

/* renamed from: com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI */
public class CollectCreateQRCodeUI extends WalletBaseUI {
    private String eeO = "";
    private WalletFormView kGa;
    private TextView kGb;

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI$1 */
    class C276931 implements OnMenuItemClickListener {
        C276931() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(41230);
            CollectCreateQRCodeUI.this.setResult(0);
            CollectCreateQRCodeUI.this.finish();
            AppMethodBeat.m2505o(41230);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI$2 */
    class C338712 implements TextWatcher {
        C338712() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(41231);
            if (editable.toString().startsWith(".")) {
                editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            String obj = editable.toString();
            int indexOf = obj.indexOf(".");
            int length = obj.length();
            if (indexOf >= 0 && length - indexOf > 2) {
                editable.delete(indexOf + 3, length);
            }
            AppMethodBeat.m2505o(41231);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI$4 */
    class C338724 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI$4$1 */
        class C338731 implements C30387b {
            C338731() {
            }

            /* renamed from: s */
            public final boolean mo4760s(CharSequence charSequence) {
                AppMethodBeat.m2504i(41233);
                if (C5046bo.isNullOrNil(charSequence.toString())) {
                    CollectCreateQRCodeUI.this.eeO = "";
                    CollectCreateQRCodeUI.m55437c(CollectCreateQRCodeUI.this);
                } else {
                    CollectCreateQRCodeUI.this.eeO = charSequence.toString();
                    CollectCreateQRCodeUI.m55437c(CollectCreateQRCodeUI.this);
                }
                AppMethodBeat.m2505o(41233);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI$4$2 */
        class C338742 implements DialogInterface.OnClickListener {

            /* renamed from: com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI$4$2$1 */
            class C338751 implements Runnable {
                C338751() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(41234);
                    CollectCreateQRCodeUI.this.aqX();
                    AppMethodBeat.m2505o(41234);
                }
            }

            C338742() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(41235);
                C5004al.m7442n(new C338751(), 500);
                AppMethodBeat.m2505o(41235);
            }
        }

        C338724() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41236);
            CollectCreateQRCodeUI.this.aoB();
            C22657a.m34348a(CollectCreateQRCodeUI.this, CollectCreateQRCodeUI.this.getString(C25738R.string.arr), CollectCreateQRCodeUI.this.eeO, "", 32, new C338731(), new C338742());
            AppMethodBeat.m2505o(41236);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI$3 */
    class C338773 implements OnClickListener {
        C338773() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41232);
            double d = C5046bo.getDouble(CollectCreateQRCodeUI.this.kGa.getText(), 0.0d);
            C1720g.m3537RQ();
            C4990ab.m7417i("MicroMsg.CollectCreateQRCodeUI", "wallet region: %s", Integer.valueOf(((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue()));
            if (!CollectCreateQRCodeUI.this.kGa.asa()) {
                C23639t.makeText(CollectCreateQRCodeUI.this.mController.ylL, C25738R.string.f9y, 0).show();
                AppMethodBeat.m2505o(41232);
            } else if (d < 0.01d) {
                C23639t.makeText(CollectCreateQRCodeUI.this.mController.ylL, C25738R.string.dnj, 0).show();
                AppMethodBeat.m2505o(41232);
            } else if (r0 == 8) {
                CollectCreateQRCodeUI.this.mo39970a(new C2833m(Math.round(d * 100.0d), CollectCreateQRCodeUI.this.eeO, C1853r.m3825YG()), true, false);
                AppMethodBeat.m2505o(41232);
            } else {
                CollectCreateQRCodeUI.this.mo39970a(new C20266s(d, "1", CollectCreateQRCodeUI.this.eeO), true, true);
                AppMethodBeat.m2505o(41232);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI$6 */
    class C338786 implements DialogInterface.OnClickListener {
        C338786() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41238);
        super.onCreate(bundle);
        mo39992nf(1335);
        initView();
        AppMethodBeat.m2505o(41238);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41239);
        super.onDestroy();
        mo39993ng(1335);
        AppMethodBeat.m2505o(41239);
    }

    public final void initView() {
        AppMethodBeat.m2504i(41240);
        setMMTitle((int) C25738R.string.arq);
        setBackBtn(new C276931());
        this.kGa = (WalletFormView) findViewById(2131822842);
        C30890a.m49301f(this.kGa);
        String stringExtra = getIntent().getStringExtra("key_currency_unit");
        if (C5046bo.isNullOrNil(stringExtra)) {
            this.kGa.getTitleTv().setText(C44423ae.dOd());
        } else {
            this.kGa.getTitleTv().setText(stringExtra);
        }
        this.kGa.mo64594a(new C338712());
        mo39989e(this.kGa, 2, false);
        ((Button) findViewById(2131822846)).setOnClickListener(new C338773());
        this.kGb = (TextView) findViewById(2131822845);
        this.kGb.setOnClickListener(new C338724());
        AppMethodBeat.m2505o(41240);
    }

    public final int getLayoutId() {
        return 2130969159;
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41241);
        Intent intent;
        if (c1207m instanceof C20266s) {
            if (i == 0 && i2 == 0) {
                C20266s c20266s = (C20266s) c1207m;
                intent = new Intent();
                intent.putExtra("ftf_pay_url", c20266s.kCI);
                intent.putExtra("ftf_fixed_fee", c20266s.kCJ);
                intent.putExtra("ftf_fixed_fee_type", c20266s.cuZ);
                intent.putExtra("ftf_fixed_desc", c20266s.desc);
                setResult(-1, intent);
                finish();
                AppMethodBeat.m2505o(41241);
                return true;
            }
        } else if (c1207m instanceof C2833m) {
            final C2833m c2833m = (C2833m) c1207m;
            if (i != 0 || i2 != 0) {
                C4990ab.m7413e("MicroMsg.CollectCreateQRCodeUI", "net error: %s", c2833m);
            } else if (c2833m.kCl == 0) {
                intent = new Intent();
                intent.putExtra("ftf_pay_url", c2833m.kCn);
                intent.putExtra("ftf_fixed_fee", ((double) c2833m.cSh) / 100.0d);
                intent.putExtra("ftf_fixed_desc", c2833m.desc);
                intent.putExtra("key_currency_unit", c2833m.kCw);
                setResult(-1, intent);
                finish();
                AppMethodBeat.m2505o(41241);
                return true;
            } else if (c2833m.kCo == 0) {
                C30379h.m48461b(this.mController.ylL, c2833m.kCm, c2833m.kCp, false);
                AppMethodBeat.m2505o(41241);
                return true;
            } else if (c2833m.kCo == 1) {
                if (!(C5046bo.isNullOrNil(c2833m.kCq) || C5046bo.isNullOrNil(c2833m.kCr))) {
                    C30379h.m48466d(this.mController.ylL, c2833m.kCm, c2833m.kCp, c2833m.kCr, c2833m.kCq, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(41237);
                            if (!C5046bo.isNullOrNil(c2833m.kCs)) {
                                C4990ab.m7417i("MicroMsg.CollectCreateQRCodeUI", "goto h5: %s", c2833m.kCs);
                                C36391e.m60016n(CollectCreateQRCodeUI.this.mController.ylL, c2833m.kCs, true);
                            }
                            AppMethodBeat.m2505o(41237);
                        }
                    }, new C338786());
                }
                AppMethodBeat.m2505o(41241);
                return true;
            }
        }
        AppMethodBeat.m2505o(41241);
        return false;
    }

    /* renamed from: c */
    static /* synthetic */ void m55437c(CollectCreateQRCodeUI collectCreateQRCodeUI) {
        AppMethodBeat.m2504i(41242);
        if (C5046bo.isNullOrNil(collectCreateQRCodeUI.eeO)) {
            collectCreateQRCodeUI.kGb.setTextColor(collectCreateQRCodeUI.getResources().getColor(C25738R.color.f12123t7));
            collectCreateQRCodeUI.kGb.setText(C25738R.string.arr);
            AppMethodBeat.m2505o(41242);
            return;
        }
        C46373j c46373j = new C46373j(collectCreateQRCodeUI.mController.ylL);
        SpannableString b = C44089j.m79292b((Context) collectCreateQRCodeUI, collectCreateQRCodeUI.getString(C25738R.string.ars, new Object[]{collectCreateQRCodeUI.eeO, collectCreateQRCodeUI.getString(C25738R.string.art)}));
        SpannableString spannableString = new SpannableString(b);
        spannableString.setSpan(c46373j, b.length() - r1.length(), b.length(), 33);
        collectCreateQRCodeUI.kGb.setTextColor(collectCreateQRCodeUI.getResources().getColor(C25738R.color.f12092s0));
        collectCreateQRCodeUI.kGb.setText(spannableString);
        AppMethodBeat.m2505o(41242);
    }
}
