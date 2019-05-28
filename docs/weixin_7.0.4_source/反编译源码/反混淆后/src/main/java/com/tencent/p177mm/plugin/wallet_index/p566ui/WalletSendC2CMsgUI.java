package com.tencent.p177mm.plugin.wallet_index.p566ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22558a;
import com.tencent.p177mm.plugin.wallet_index.p564c.C40150h;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletSendC2CMsgUI */
public class WalletSendC2CMsgUI extends WalletBaseUI {
    private int gOW;
    private Map<String, String> tSo = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48307);
        super.onCreate(bundle);
        mo9439AM(8);
        this.gOW = getIntent().getIntExtra("key_scene", 0);
        C4990ab.m7416i("MicroMsg.WalletSendC2CMsgUI", "scene:" + this.gOW);
        if (this.gOW == 0) {
            mo39992nf(580);
            if (getIntent() == null) {
                C4990ab.m7412e("MicroMsg.WalletSendC2CMsgUI", "func[doCheckPayNetscene] intent null");
                setResult(-1000);
                finish();
                AppMethodBeat.m2505o(48307);
                return;
            }
            mo39970a(new C22558a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 6, "getSendC2CMessageRequest", getIntent().getIntExtra("pay_channel", 0)), true, false);
            AppMethodBeat.m2505o(48307);
        } else if (adk(null)) {
            AppMethodBeat.m2505o(48307);
        } else {
            C4990ab.m7410d("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
            setResult(-1000);
            finish();
            AppMethodBeat.m2505o(48307);
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(48308);
        super.onDestroy();
        mo39993ng(580);
        AppMethodBeat.m2505o(48308);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        boolean z = false;
        AppMethodBeat.m2504i(48309);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C22558a) {
                int i3;
                C4990ab.m7416i("MicroMsg.WalletSendC2CMsgUI", "Check jsapi suc & Go Select Contact");
                C46512f.akr(((C22558a) c1207m).cOS());
                C4990ab.m7416i("MicroMsg.WalletSendC2CMsgUI", "doCallSelectConversationUI");
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
                C25985d.m41466b((Context) this, ".ui.transmit.SelectConversationUI", intent, 1);
                AppMethodBeat.m2505o(48309);
                return true;
            } else if (c1207m instanceof C40150h) {
                C4990ab.m7416i("MicroMsg.WalletSendC2CMsgUI", "Send c2c msg suc");
                if (this.gOW == 1) {
                    C30379h.m48465bQ(this, getString(C25738R.string.ft5));
                } else {
                    C30379h.m48465bQ(this, getString(C25738R.string.cbn));
                    setResult(-1);
                }
                finish();
                AppMethodBeat.m2505o(48309);
                return true;
            }
        } else if (c1207m instanceof C22558a) {
            C4990ab.m7412e("MicroMsg.WalletSendC2CMsgUI", "Check jsapi fail");
            setResult(-1000);
            finish();
            AppMethodBeat.m2505o(48309);
            return true;
        } else if (c1207m instanceof C40150h) {
            if (this.gOW == 1) {
                C30379h.m48465bQ(this, str);
            } else {
                setResult(-1000);
            }
            finish();
            AppMethodBeat.m2505o(48309);
            return true;
        } else {
            setResult(-1000);
            finish();
        }
        AppMethodBeat.m2505o(48309);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(48310);
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            C4990ab.m7410d("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            C4990ab.m7412e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        if (i != 1) {
            C4990ab.m7412e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(48310);
        } else if (i2 != -1 || intent == null) {
            C4990ab.m7412e("MicroMsg.WalletSendC2CMsgUI", "cancel select contact fail");
            setResult(0);
            finish();
            AppMethodBeat.m2505o(48310);
        } else {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            C4990ab.m7410d("MicroMsg.WalletSendC2CMsgUI", "Select user , " + C5046bo.nullAsNil(stringExtra));
            if (adk(stringExtra)) {
                AppMethodBeat.m2505o(48310);
                return;
            }
            C4990ab.m7412e("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
            setResult(-1000);
            finish();
            AppMethodBeat.m2505o(48310);
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
        AppMethodBeat.m2504i(48311);
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
            if (cTb == null || C5046bo.isNullOrNil(str)) {
                stringExtra3 = null;
                str2 = null;
                encode = null;
                stringExtra2 = null;
                stringExtra = null;
                stringExtra5 = null;
                stringExtra4 = null;
                obj2 = str;
            } else {
                stringExtra4 = URLDecoder.decode(C5046bo.nullAsNil((String) cTb.get("receivertitle")));
                stringExtra5 = URLDecoder.decode(C5046bo.nullAsNil((String) cTb.get("sendertitle")));
                stringExtra = URLDecoder.decode(C5046bo.nullAsNil((String) cTb.get("senderdes")));
                stringExtra2 = URLDecoder.decode(C5046bo.nullAsNil((String) cTb.get("receiverdes")));
                encode = C5046bo.nullAsNil((String) cTb.get("url"));
                str2 = URLDecoder.decode(C5046bo.nullAsNil((String) cTb.get("templateid")));
                stringExtra3 = URLDecoder.decode(C5046bo.nullAsNil((String) cTb.get("senceid")));
                obj2 = str;
            }
        }
        if (C5046bo.isNullOrNil(encode) || C5046bo.isNullOrNil(str2)) {
            C4990ab.m7420w("MicroMsg.WalletSendC2CMsgUI", "url = " + C5046bo.isNullOrNil(encode) + "templateId=" + C5046bo.isNullOrNil(str2));
            AppMethodBeat.m2505o(48311);
            return false;
        }
        C4990ab.m7410d("MicroMsg.WalletSendC2CMsgUI", "send c2c msg to".concat(String.valueOf(obj2)));
        mo39970a(new C40150h(obj2, stringExtra4, stringExtra5, str2, stringExtra, stringExtra2, encode, stringExtra3), true, true);
        AppMethodBeat.m2505o(48311);
        return true;
    }

    private Map<String, String> cTb() {
        AppMethodBeat.m2504i(48312);
        if (this.tSo == null) {
            String stringExtra = getIntent().getStringExtra("packageExt");
            C4990ab.m7410d("MicroMsg.WalletSendC2CMsgUI", "func[getPackageData] packageExt: ".concat(String.valueOf(stringExtra)));
            if (!C5046bo.isNullOrNil(stringExtra)) {
                String[] split = stringExtra.split("&");
                this.tSo = new HashMap();
                if (split != null && split.length > 0) {
                    for (int i = 0; i < split.length; i++) {
                        if (!C5046bo.isNullOrNil(split[i])) {
                            String[] split2 = split[i].split("=");
                            if (split2.length == 2 && !C5046bo.isNullOrNil(split2[0])) {
                                this.tSo.put(split2[0], split2[1]);
                            }
                        }
                    }
                }
            }
        }
        Map map = this.tSo;
        AppMethodBeat.m2505o(48312);
        return map;
    }
}
