package com.tencent.mm.plugin.wallet_core.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.bankcard.TenpaySegmentEditText;

public class WalletConfirmCardIDUI extends WalletBaseUI {
    private Button nhX;
    private TenpaySegmentEditText tHx;
    private boolean tHy = true;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.b3v;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47369);
        super.onCreate(bundle);
        initView();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(47365);
                x.dNV();
                WalletConfirmCardIDUI.this.finish();
                AppMethodBeat.o(47365);
                return false;
            }
        });
        AppMethodBeat.o(47369);
    }

    public void onDestroy() {
        AppMethodBeat.i(47370);
        super.onDestroy();
        AppMethodBeat.o(47370);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47372);
        Bundle bundle = new Bundle();
        boolean z = this.mBundle.getBoolean("key_is_reset_with_new_card", false);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof t) {
                t tVar = (t) mVar;
                bundle.putBoolean("key_need_area", tVar.cOU());
                bundle.putBoolean("key_need_profession", tVar.cOV());
                bundle.putParcelableArray("key_profession_list", tVar.tur);
                bundle.putBoolean("key_need_country", tVar.tus == 1);
                bundle.putStringArray("key_country_excludes", tVar.tut);
                if (tVar.tun == null) {
                    bundle.putBoolean("key_is_reset_with_new_card", z);
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.tHx.getEncryptDataWithHash(false));
                    a.j(this, bundle);
                } else if (tVar.tun.tyC && tVar.tun.isError()) {
                    h.g(this, R.string.f_1, R.string.tz);
                    AppMethodBeat.o(47372);
                    return true;
                } else {
                    bundle.putBoolean("key_is_reset_with_new_card", z);
                    bundle.putString("bank_name", tVar.tun.nuL);
                    bundle.putParcelable("elemt_query", tVar.tun);
                    bundle.putString("key_card_id", this.tHx.getEncryptDataWithHash(false));
                    a.j(this, bundle);
                    AppMethodBeat.o(47372);
                    return true;
                }
            }
        } else if (i2 == 1 && (mVar instanceof t)) {
            bundle.putString("bank_name", "");
            bundle.putBoolean("key_is_reset_with_new_card", z);
            bundle.putParcelable("elemt_query", new ElementQuery());
            bundle.putString("key_card_id", this.tHx.getEncryptDataWithHash(false));
            a.j(this, bundle);
            AppMethodBeat.o(47372);
            return true;
        }
        AppMethodBeat.o(47372);
        return false;
    }

    private void cRB() {
        AppMethodBeat.i(47373);
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.akz);
        this.nTi = findViewById(R.id.aky);
        View findViewById = findViewById(R.id.al0);
        if (this.mKeyboard == null || this.nTi == null) {
            AppMethodBeat.o(47373);
            return;
        }
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47368);
                WalletConfirmCardIDUI.this.aoB();
                AppMethodBeat.o(47368);
            }
        });
        AppMethodBeat.o(47373);
    }

    public final void initView() {
        AppMethodBeat.i(47371);
        String string = this.mBundle.getString("key_bankcard_id");
        String string2 = this.mBundle.getString("key_bankcard_des");
        Bitmap bitmap = (Bitmap) this.mBundle.getParcelable("key_bankcard_cropimg");
        if (TextUtils.isEmpty(string)) {
            ab.e("MicroMsg.WalletConfirmCardIDUI", "cardID is empty");
            finish();
            AppMethodBeat.o(47371);
        } else if (bitmap == null) {
            ab.e("MicroMsg.WalletConfirmCardIDUI", "cardID bitmap is null");
            finish();
            AppMethodBeat.o(47371);
        } else {
            setMMTitle((int) R.string.fdo);
            this.nhX = (Button) findViewById(R.id.ay8);
            this.tHx = (TenpaySegmentEditText) findViewById(R.id.f_3);
            this.tHx.setText(string, string2);
            this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.akz);
            this.nTi = findViewById(R.id.aky);
            ((ImageView) findViewById(R.id.f_2)).setImageBitmap(bitmap);
            this.tHx.setKeyboard(this.mKeyboard);
            this.mKeyboard.setXMode(0);
            ((InputMethodManager) this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(this.tHx.getWindowToken(), 0);
            this.nTi.setVisibility(8);
            this.tHx.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(47366);
                    if (!(WalletConfirmCardIDUI.this.nTi.isShown() || WalletConfirmCardIDUI.this.tHy)) {
                        WalletConfirmCardIDUI.this.nTi.setVisibility(0);
                        WalletConfirmCardIDUI.this.mKeyboard.setVisibility(0);
                    }
                    WalletConfirmCardIDUI.this.tHy = false;
                    AppMethodBeat.o(47366);
                }
            });
            final String str = this.tHx.get3DesEncrptData();
            this.nhX.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(47367);
                    String str = WalletConfirmCardIDUI.this.tHx.get3DesEncrptData();
                    if (str == null || !str.equals(str)) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(11353, Integer.valueOf(0), Integer.valueOf(2));
                    } else {
                        com.tencent.mm.plugin.report.service.h.pYm.e(11353, Integer.valueOf(0), Integer.valueOf(1));
                    }
                    WalletConfirmCardIDUI.g(WalletConfirmCardIDUI.this);
                    AppMethodBeat.o(47367);
                }
            });
            cRB();
            this.tHx.setFocusable(false);
            this.tHx.setFocusableInTouchMode(true);
            AppMethodBeat.o(47371);
        }
    }

    static /* synthetic */ void g(WalletConfirmCardIDUI walletConfirmCardIDUI) {
        AppMethodBeat.i(47374);
        TenpaySegmentEditText.setSalt(w.dNR());
        walletConfirmCardIDUI.a(new t(walletConfirmCardIDUI.cNH(), walletConfirmCardIDUI.tHx.getEncryptDataWithHash(false), (PayInfo) walletConfirmCardIDUI.mBundle.getParcelable("key_pay_info"), walletConfirmCardIDUI.mBundle.getInt("entry_scene", -1)), true, true);
        AppMethodBeat.o(47374);
    }
}
