package com.tencent.p177mm.plugin.wallet.bind.p553ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet.bind.C41325a;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletUnbindBankCardProxyUI */
public class WalletUnbindBankCardProxyUI extends WalletBaseUI {
    private String tmv;
    private Bankcard tmw;
    private Map<String, String> tmx;

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletUnbindBankCardProxyUI$1 */
    class C225271 implements C30857a {
        C225271() {
        }

        /* renamed from: n */
        public final Intent mo7785n(int i, Bundle bundle) {
            AppMethodBeat.m2504i(45830);
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
            AppMethodBeat.m2505o(45830);
            return null;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        Bankcard bankcard = null;
        AppMethodBeat.m2504i(45831);
        super.onCreate(bundle);
        Intent intent = getIntent();
        setResult(0);
        if (intent != null) {
            this.tmv = intent.getStringExtra("packageExt");
            if (C5046bo.isNullOrNil(this.tmv)) {
                C4990ab.m7412e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param error");
                setResult(1);
                finish();
                AppMethodBeat.m2505o(45831);
                return;
            }
            Map hashMap;
            String str = this.tmv;
            if (!C5046bo.isNullOrNil(str)) {
                String[] split = str.split("&");
                hashMap = new HashMap();
                if (split != null && split.length > 0) {
                    for (String str2 : split) {
                        String str22;
                        if (!C5046bo.isNullOrNil(str22)) {
                            int indexOf = str22.indexOf("=");
                            String substring = str22.substring(0, indexOf);
                            str22 = str22.substring(indexOf + 1, str22.length());
                            if (!(C5046bo.isNullOrNil(substring) || C5046bo.isNullOrNil(str22))) {
                                hashMap.put(substring, str22);
                            }
                        }
                    }
                    this.tmx = hashMap;
                    if (this.tmx.containsKey("bank_type") || !this.tmx.containsKey("bind_serial")) {
                        C4990ab.m7412e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param:package error.package==" + this.tmv);
                        setResult(1);
                        finish();
                        AppMethodBeat.m2505o(45831);
                        return;
                    }
                    Cursor a = C14241r.cPG().bSd.mo10104a("select * from WalletBankcard where bindSerial = '" + ((String) this.tmx.get("bind_serial")) + "'", null, 2);
                    if (a.moveToNext()) {
                        bankcard = new Bankcard();
                        bankcard.mo8995d(a);
                    }
                    a.close();
                    this.tmw = bankcard;
                    if (this.tmw == null) {
                        C4990ab.m7412e("MicorMsg.WalletUnbindBankCardProxyUI", "can not found bankcard");
                        setResult(0);
                        finish();
                        AppMethodBeat.m2505o(45831);
                        return;
                    }
                    intent.putExtra("key_is_show_detail", false);
                    intent.putExtra("key_bankcard", this.tmw);
                    intent.putExtra("scene", 1);
                    C24143a.m37106a((Activity) this, C41325a.class, intent.getExtras(), new C225271());
                    AppMethodBeat.m2505o(45831);
                    return;
                }
            }
            hashMap = null;
            this.tmx = hashMap;
            if (this.tmx.containsKey("bank_type")) {
            }
            C4990ab.m7412e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param:package error.package==" + this.tmv);
            setResult(1);
            finish();
            AppMethodBeat.m2505o(45831);
            return;
        }
        C4990ab.m7412e("MicorMsg.WalletUnbindBankCardProxyUI", "intent is null");
        finish();
        AppMethodBeat.m2505o(45831);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(45832);
        finish();
        AppMethodBeat.m2505o(45832);
    }
}
