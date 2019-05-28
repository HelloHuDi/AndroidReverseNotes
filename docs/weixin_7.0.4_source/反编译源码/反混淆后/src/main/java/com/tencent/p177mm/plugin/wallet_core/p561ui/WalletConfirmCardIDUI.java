package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.p177mm.plugin.wallet_core.p749c.C14225t;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p649c.C30862w;
import com.tencent.p177mm.wallet_core.p649c.C36379x;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.bankcard.TenpaySegmentEditText;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI */
public class WalletConfirmCardIDUI extends WalletBaseUI {
    private Button nhX;
    private TenpaySegmentEditText tHx;
    private boolean tHy = true;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI$1 */
    class C226051 implements OnMenuItemClickListener {
        C226051() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(47365);
            C36379x.dNV();
            WalletConfirmCardIDUI.this.finish();
            AppMethodBeat.m2505o(47365);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI$2 */
    class C226062 implements OnClickListener {
        C226062() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47366);
            if (!(WalletConfirmCardIDUI.this.nTi.isShown() || WalletConfirmCardIDUI.this.tHy)) {
                WalletConfirmCardIDUI.this.nTi.setVisibility(0);
                WalletConfirmCardIDUI.this.mKeyboard.setVisibility(0);
            }
            WalletConfirmCardIDUI.this.tHy = false;
            AppMethodBeat.m2505o(47366);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI$4 */
    class C248974 implements OnClickListener {
        C248974() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47368);
            WalletConfirmCardIDUI.this.aoB();
            AppMethodBeat.m2505o(47368);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130971084;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47369);
        super.onCreate(bundle);
        initView();
        setBackBtn(new C226051());
        AppMethodBeat.m2505o(47369);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(47370);
        super.onDestroy();
        AppMethodBeat.m2505o(47370);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47372);
        Bundle bundle = new Bundle();
        boolean z = this.mBundle.getBoolean("key_is_reset_with_new_card", false);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C14225t) {
                C14225t c14225t = (C14225t) c1207m;
                bundle.putBoolean("key_need_area", c14225t.cOU());
                bundle.putBoolean("key_need_profession", c14225t.cOV());
                bundle.putParcelableArray("key_profession_list", c14225t.tur);
                bundle.putBoolean("key_need_country", c14225t.tus == 1);
                bundle.putStringArray("key_country_excludes", c14225t.tut);
                if (c14225t.tun == null) {
                    bundle.putBoolean("key_is_reset_with_new_card", z);
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.tHx.getEncryptDataWithHash(false));
                    C24143a.m37116j(this, bundle);
                } else if (c14225t.tun.tyC && c14225t.tun.isError()) {
                    C30379h.m48467g(this, C25738R.string.f_1, C25738R.string.f9238tz);
                    AppMethodBeat.m2505o(47372);
                    return true;
                } else {
                    bundle.putBoolean("key_is_reset_with_new_card", z);
                    bundle.putString("bank_name", c14225t.tun.nuL);
                    bundle.putParcelable("elemt_query", c14225t.tun);
                    bundle.putString("key_card_id", this.tHx.getEncryptDataWithHash(false));
                    C24143a.m37116j(this, bundle);
                    AppMethodBeat.m2505o(47372);
                    return true;
                }
            }
        } else if (i2 == 1 && (c1207m instanceof C14225t)) {
            bundle.putString("bank_name", "");
            bundle.putBoolean("key_is_reset_with_new_card", z);
            bundle.putParcelable("elemt_query", new ElementQuery());
            bundle.putString("key_card_id", this.tHx.getEncryptDataWithHash(false));
            C24143a.m37116j(this, bundle);
            AppMethodBeat.m2505o(47372);
            return true;
        }
        AppMethodBeat.m2505o(47372);
        return false;
    }

    private void cRB() {
        AppMethodBeat.m2504i(47373);
        this.mKeyboard = (MyKeyboardWindow) findViewById(2131822357);
        this.nTi = findViewById(2131822356);
        View findViewById = findViewById(2131822358);
        if (this.mKeyboard == null || this.nTi == null) {
            AppMethodBeat.m2505o(47373);
            return;
        }
        findViewById.setOnClickListener(new C248974());
        AppMethodBeat.m2505o(47373);
    }

    public final void initView() {
        AppMethodBeat.m2504i(47371);
        String string = this.mBundle.getString("key_bankcard_id");
        String string2 = this.mBundle.getString("key_bankcard_des");
        Bitmap bitmap = (Bitmap) this.mBundle.getParcelable("key_bankcard_cropimg");
        if (TextUtils.isEmpty(string)) {
            C4990ab.m7412e("MicroMsg.WalletConfirmCardIDUI", "cardID is empty");
            finish();
            AppMethodBeat.m2505o(47371);
        } else if (bitmap == null) {
            C4990ab.m7412e("MicroMsg.WalletConfirmCardIDUI", "cardID bitmap is null");
            finish();
            AppMethodBeat.m2505o(47371);
        } else {
            setMMTitle((int) C25738R.string.fdo);
            this.nhX = (Button) findViewById(2131822846);
            this.tHx = (TenpaySegmentEditText) findViewById(2131828760);
            this.tHx.setText(string, string2);
            this.mKeyboard = (MyKeyboardWindow) findViewById(2131822357);
            this.nTi = findViewById(2131822356);
            ((ImageView) findViewById(2131828759)).setImageBitmap(bitmap);
            this.tHx.setKeyboard(this.mKeyboard);
            this.mKeyboard.setXMode(0);
            ((InputMethodManager) this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(this.tHx.getWindowToken(), 0);
            this.nTi.setVisibility(8);
            this.tHx.setOnClickListener(new C226062());
            final String str = this.tHx.get3DesEncrptData();
            this.nhX.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(47367);
                    String str = WalletConfirmCardIDUI.this.tHx.get3DesEncrptData();
                    if (str == null || !str.equals(str)) {
                        C7060h.pYm.mo8381e(11353, Integer.valueOf(0), Integer.valueOf(2));
                    } else {
                        C7060h.pYm.mo8381e(11353, Integer.valueOf(0), Integer.valueOf(1));
                    }
                    WalletConfirmCardIDUI.m38891g(WalletConfirmCardIDUI.this);
                    AppMethodBeat.m2505o(47367);
                }
            });
            cRB();
            this.tHx.setFocusable(false);
            this.tHx.setFocusableInTouchMode(true);
            AppMethodBeat.m2505o(47371);
        }
    }

    /* renamed from: g */
    static /* synthetic */ void m38891g(WalletConfirmCardIDUI walletConfirmCardIDUI) {
        AppMethodBeat.m2504i(47374);
        TenpaySegmentEditText.setSalt(C30862w.dNR());
        walletConfirmCardIDUI.mo39970a(new C14225t(walletConfirmCardIDUI.cNH(), walletConfirmCardIDUI.tHx.getEncryptDataWithHash(false), (PayInfo) walletConfirmCardIDUI.mBundle.getParcelable("key_pay_info"), walletConfirmCardIDUI.mBundle.getInt("entry_scene", -1)), true, true);
        AppMethodBeat.m2505o(47374);
    }
}
