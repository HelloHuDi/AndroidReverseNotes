package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

@a(3)
public class WalletUnbindBankCardProxyUI extends WalletBaseUI {
    private String tmv;
    private Bankcard tmw;
    private Map<String, String> tmx;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        Bankcard bankcard = null;
        AppMethodBeat.i(45831);
        super.onCreate(bundle);
        Intent intent = getIntent();
        setResult(0);
        if (intent != null) {
            this.tmv = intent.getStringExtra("packageExt");
            if (bo.isNullOrNil(this.tmv)) {
                ab.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param error");
                setResult(1);
                finish();
                AppMethodBeat.o(45831);
                return;
            }
            Map hashMap;
            String str = this.tmv;
            if (!bo.isNullOrNil(str)) {
                String[] split = str.split("&");
                hashMap = new HashMap();
                if (split != null && split.length > 0) {
                    for (String str2 : split) {
                        String str22;
                        if (!bo.isNullOrNil(str22)) {
                            int indexOf = str22.indexOf("=");
                            String substring = str22.substring(0, indexOf);
                            str22 = str22.substring(indexOf + 1, str22.length());
                            if (!(bo.isNullOrNil(substring) || bo.isNullOrNil(str22))) {
                                hashMap.put(substring, str22);
                            }
                        }
                    }
                    this.tmx = hashMap;
                    if (this.tmx.containsKey("bank_type") || !this.tmx.containsKey("bind_serial")) {
                        ab.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param:package error.package==" + this.tmv);
                        setResult(1);
                        finish();
                        AppMethodBeat.o(45831);
                        return;
                    }
                    Cursor a = r.cPG().bSd.a("select * from WalletBankcard where bindSerial = '" + ((String) this.tmx.get("bind_serial")) + "'", null, 2);
                    if (a.moveToNext()) {
                        bankcard = new Bankcard();
                        bankcard.d(a);
                    }
                    a.close();
                    this.tmw = bankcard;
                    if (this.tmw == null) {
                        ab.e("MicorMsg.WalletUnbindBankCardProxyUI", "can not found bankcard");
                        setResult(0);
                        finish();
                        AppMethodBeat.o(45831);
                        return;
                    }
                    intent.putExtra("key_is_show_detail", false);
                    intent.putExtra("key_bankcard", this.tmw);
                    intent.putExtra("scene", 1);
                    com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.bind.a.class, intent.getExtras(), new c.a() {
                        public final Intent n(int i, Bundle bundle) {
                            AppMethodBeat.i(45830);
                            switch (i) {
                                case -1:
                                    WalletUnbindBankCardProxyUI.this.setResult(-1);
                                    break;
                                case 0:
                                    WalletUnbindBankCardProxyUI.this.setResult(0);
                                    break;
                                case 1:
                                    WalletUnbindBankCardProxyUI.this.setResult(1);
                                    break;
                            }
                            AppMethodBeat.o(45830);
                            return null;
                        }
                    });
                    AppMethodBeat.o(45831);
                    return;
                }
            }
            hashMap = null;
            this.tmx = hashMap;
            if (this.tmx.containsKey("bank_type")) {
            }
            ab.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param:package error.package==" + this.tmv);
            setResult(1);
            finish();
            AppMethodBeat.o(45831);
            return;
        }
        ab.e("MicorMsg.WalletUnbindBankCardProxyUI", "intent is null");
        finish();
        AppMethodBeat.o(45831);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(45832);
        finish();
        AppMethodBeat.o(45832);
    }
}
