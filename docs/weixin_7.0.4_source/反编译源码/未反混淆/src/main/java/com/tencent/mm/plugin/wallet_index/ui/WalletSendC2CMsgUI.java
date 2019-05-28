package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.wallet_index.c.h;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class WalletSendC2CMsgUI extends WalletBaseUI {
    private int gOW;
    private Map<String, String> tSo = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48307);
        super.onCreate(bundle);
        AM(8);
        this.gOW = getIntent().getIntExtra("key_scene", 0);
        ab.i("MicroMsg.WalletSendC2CMsgUI", "scene:" + this.gOW);
        if (this.gOW == 0) {
            nf(580);
            if (getIntent() == null) {
                ab.e("MicroMsg.WalletSendC2CMsgUI", "func[doCheckPayNetscene] intent null");
                setResult(-1000);
                finish();
                AppMethodBeat.o(48307);
                return;
            }
            a(new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 6, "getSendC2CMessageRequest", getIntent().getIntExtra("pay_channel", 0)), true, false);
            AppMethodBeat.o(48307);
        } else if (adk(null)) {
            AppMethodBeat.o(48307);
        } else {
            ab.d("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
            setResult(-1000);
            finish();
            AppMethodBeat.o(48307);
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(48308);
        super.onDestroy();
        ng(580);
        AppMethodBeat.o(48308);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        boolean z = false;
        AppMethodBeat.i(48309);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
                int i3;
                ab.i("MicroMsg.WalletSendC2CMsgUI", "Check jsapi suc & Go Select Contact");
                f.akr(((com.tencent.mm.plugin.wallet_core.c.a) mVar).cOS());
                ab.i("MicroMsg.WalletSendC2CMsgUI", "doCallSelectConversationUI");
                Map cTb = cTb();
                if (cTb != null && cTb.containsKey("togroup") && AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(cTb.get("togroup"))) {
                    z = true;
                }
                Intent intent = new Intent();
                if (z) {
                    i3 = 7;
                } else {
                    i3 = 3;
                }
                intent.putExtra("select_is_ret", true);
                intent.putExtra("Select_Conv_Type", i3);
                d.b((Context) this, ".ui.transmit.SelectConversationUI", intent, 1);
                AppMethodBeat.o(48309);
                return true;
            } else if (mVar instanceof h) {
                ab.i("MicroMsg.WalletSendC2CMsgUI", "Send c2c msg suc");
                if (this.gOW == 1) {
                    com.tencent.mm.ui.base.h.bQ(this, getString(R.string.ft5));
                } else {
                    com.tencent.mm.ui.base.h.bQ(this, getString(R.string.cbn));
                    setResult(-1);
                }
                finish();
                AppMethodBeat.o(48309);
                return true;
            }
        } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
            ab.e("MicroMsg.WalletSendC2CMsgUI", "Check jsapi fail");
            setResult(-1000);
            finish();
            AppMethodBeat.o(48309);
            return true;
        } else if (mVar instanceof h) {
            if (this.gOW == 1) {
                com.tencent.mm.ui.base.h.bQ(this, str);
            } else {
                setResult(-1000);
            }
            finish();
            AppMethodBeat.o(48309);
            return true;
        } else {
            setResult(-1000);
            finish();
        }
        AppMethodBeat.o(48309);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(48310);
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            ab.d("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            ab.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        if (i != 1) {
            ab.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(i)));
            AppMethodBeat.o(48310);
        } else if (i2 != -1 || intent == null) {
            ab.e("MicroMsg.WalletSendC2CMsgUI", "cancel select contact fail");
            setResult(0);
            finish();
            AppMethodBeat.o(48310);
        } else {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            ab.d("MicroMsg.WalletSendC2CMsgUI", "Select user , " + bo.nullAsNil(stringExtra));
            if (adk(stringExtra)) {
                AppMethodBeat.o(48310);
                return;
            }
            ab.e("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
            setResult(-1000);
            finish();
            AppMethodBeat.o(48310);
        }
    }

    public final int getLayoutId() {
        return -1;
    }

    private boolean adk(String str) {
        String stringExtra;
        String stringExtra2;
        String encode;
        String stringExtra3;
        String stringExtra4;
        String stringExtra5;
        String str2;
        Object obj;
        AppMethodBeat.i(48311);
        if (this.gOW == 1) {
            str = getIntent().getStringExtra("key_receiver");
            stringExtra = getIntent().getStringExtra("key_sender_des");
            stringExtra2 = getIntent().getStringExtra("key_receiver_des");
            encode = URLEncoder.encode(getIntent().getStringExtra("key_url"));
            String stringExtra6 = getIntent().getStringExtra("key_templateid");
            stringExtra3 = getIntent().getStringExtra("key_sceneid");
            stringExtra4 = getIntent().getStringExtra("key_receivertitle");
            stringExtra5 = getIntent().getStringExtra("key_sendertitle");
            str2 = stringExtra6;
            obj = str;
        } else {
            Map cTb = cTb();
            String obj2;
            if (cTb == null || bo.isNullOrNil(str)) {
                stringExtra3 = null;
                str2 = null;
                encode = null;
                stringExtra2 = null;
                stringExtra = null;
                stringExtra5 = null;
                stringExtra4 = null;
                obj2 = str;
            } else {
                stringExtra4 = URLDecoder.decode(bo.nullAsNil((String) cTb.get("receivertitle")));
                stringExtra5 = URLDecoder.decode(bo.nullAsNil((String) cTb.get("sendertitle")));
                stringExtra = URLDecoder.decode(bo.nullAsNil((String) cTb.get("senderdes")));
                stringExtra2 = URLDecoder.decode(bo.nullAsNil((String) cTb.get("receiverdes")));
                encode = bo.nullAsNil((String) cTb.get("url"));
                str2 = URLDecoder.decode(bo.nullAsNil((String) cTb.get("templateid")));
                stringExtra3 = URLDecoder.decode(bo.nullAsNil((String) cTb.get("senceid")));
                obj2 = str;
            }
        }
        if (bo.isNullOrNil(encode) || bo.isNullOrNil(str2)) {
            ab.w("MicroMsg.WalletSendC2CMsgUI", "url = " + bo.isNullOrNil(encode) + "templateId=" + bo.isNullOrNil(str2));
            AppMethodBeat.o(48311);
            return false;
        }
        ab.d("MicroMsg.WalletSendC2CMsgUI", "send c2c msg to".concat(String.valueOf(obj2)));
        a(new h(obj2, stringExtra4, stringExtra5, str2, stringExtra, stringExtra2, encode, stringExtra3), true, true);
        AppMethodBeat.o(48311);
        return true;
    }

    private Map<String, String> cTb() {
        AppMethodBeat.i(48312);
        if (this.tSo == null) {
            String stringExtra = getIntent().getStringExtra("packageExt");
            ab.d("MicroMsg.WalletSendC2CMsgUI", "func[getPackageData] packageExt: ".concat(String.valueOf(stringExtra)));
            if (!bo.isNullOrNil(stringExtra)) {
                String[] split = stringExtra.split("&");
                this.tSo = new HashMap();
                if (split != null && split.length > 0) {
                    for (int i = 0; i < split.length; i++) {
                        if (!bo.isNullOrNil(split[i])) {
                            String[] split2 = split[i].split("=");
                            if (split2.length == 2 && !bo.isNullOrNil(split2[0])) {
                                this.tSo.put(split2[0], split2[1]);
                            }
                        }
                    }
                }
            }
        }
        Map map = this.tSo;
        AppMethodBeat.o(48312);
        return map;
    }
}
