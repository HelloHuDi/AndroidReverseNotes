package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.Resp;
import com.tencent.mm.plugin.card.d.h;
import com.tencent.mm.plugin.card.model.e;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.protobuf.nx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@a(3)
public class CardAddEntranceUI extends MMActivity {
    private String appId;
    private int cME = 8;
    private String kiA = "";
    private String kiB;
    private int kiC = 0;
    LinkedList<nx> kip = new LinkedList();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardAddEntranceUI() {
        AppMethodBeat.i(88246);
        AppMethodBeat.o(88246);
    }

    public final int getLayoutId() {
        return R.layout.hx;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88247);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            ab.e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onCreate() intent == null");
            setResult(0);
            finish();
            AppMethodBeat.o(88247);
            return;
        }
        ab.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI doRediect() handle data");
        String stringExtra = intent.getStringExtra("key_in_card_list");
        this.cME = intent.getIntExtra("key_from_scene", 8);
        this.kiC = intent.getIntExtra("key_stastic_scene", 0);
        ab.i("MicroMsg.CardAddEntranceUI", "doRediect() from_scene:" + this.cME + "  from_origin_scene:" + this.kiC);
        this.kiA = intent.getStringExtra("key_package_name");
        String stringExtra2 = intent.getStringExtra("key_sign");
        String stringExtra3 = getIntent().getStringExtra("src_username");
        ab.i("MicroMsg.CardAddEntranceUI", "doRediect() src_username:".concat(String.valueOf(stringExtra3)));
        String stringExtra4 = getIntent().getStringExtra("js_url");
        this.appId = getIntent().getStringExtra("key_app_id");
        this.kiB = getIntent().getStringExtra("key_transaction");
        String stringExtra5 = getIntent().getStringExtra("key_consumed_card_id");
        ab.i("MicroMsg.CardAddEntranceUI", "doRediect() consumedCardId:".concat(String.valueOf(stringExtra5)));
        String stringExtra6 = getIntent().getStringExtra("key_template_id");
        ArrayList bP = h.bP(stringExtra, this.cME);
        if (bP == null || bP.size() == 0) {
            ab.e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI initView () tempList == null || tempList.size() == 0");
            setResult(0);
            finish();
            AppMethodBeat.o(88247);
            return;
        }
        this.kip.clear();
        this.kip.addAll(bP);
        Intent intent2 = new Intent();
        intent2.putExtra("key_from_scene", this.cME);
        intent2.putExtra("key_stastic_scene", this.kiC);
        if (bP.size() == 1) {
            nx nxVar = (nx) bP.get(0);
            intent2.putExtra("key_card_id", nxVar.kbU);
            intent2.putExtra("key_card_ext", nxVar.cMD);
            intent2.putExtra("src_username", stringExtra3);
            intent2.putExtra("js_url", stringExtra4);
            intent2.putExtra("key_consumed_card_id", stringExtra5);
            intent2.putExtra("key_template_id", stringExtra6);
            intent2.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
            intent2.setClass(this, CardDetailUI.class);
            startActivityForResult(intent2, 1);
            AppMethodBeat.o(88247);
            return;
        }
        intent2.putExtra("key_in_card_list", stringExtra);
        intent2.putExtra("key_package_name", this.kiA);
        intent2.putExtra("key_sign", stringExtra2);
        intent2.putExtra("src_username", stringExtra3);
        intent2.putExtra("js_url", stringExtra4);
        intent2.putExtra("key_consumed_card_id", stringExtra5);
        intent2.putExtra("key_template_id", stringExtra6);
        intent2.setClass(this, CardAcceptCardListUI.class);
        startActivityForResult(intent2, 2);
        AppMethodBeat.o(88247);
    }

    public void onDestroy() {
        AppMethodBeat.i(88248);
        super.onDestroy();
        AppMethodBeat.o(88248);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(88249);
        ab.v("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onActivityResult");
        if (i2 == -1) {
            ab.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_OK");
        } else {
            ab.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_CANCELED");
        }
        LinkedList linkedList = new LinkedList();
        Iterator it = this.kip.iterator();
        while (it.hasNext()) {
            nx nxVar = (nx) it.next();
            e eVar = new e();
            eVar.kbU = nxVar.kbU;
            eVar.cMD = nxVar.cMD;
            linkedList.add(eVar);
        }
        Intent intent2;
        if (i != 1) {
            if (i == 2) {
                ab.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_ACCEPT_CARD_LIST");
                CharSequence charSequence = "";
                if (intent != null) {
                    charSequence = intent.getStringExtra("card_list");
                }
                if (this.cME != 7 && this.cME != 16) {
                    if (this.cME != 26) {
                        switch (i2) {
                            case -1:
                                if (!TextUtils.isEmpty(charSequence)) {
                                    aq(-1, charSequence);
                                    break;
                                } else {
                                    aq(-1, h.a(linkedList, true, this.cME));
                                    break;
                                }
                            case 0:
                                if (!TextUtils.isEmpty(charSequence)) {
                                    aq(0, charSequence);
                                    break;
                                } else {
                                    aq(0, h.a(linkedList, false, this.cME));
                                    break;
                                }
                        }
                    }
                    intent2 = new Intent();
                    switch (i2) {
                        case -1:
                            if (intent != null && !TextUtils.isEmpty(charSequence)) {
                                intent.putExtra("card_list", h.bQ(charSequence, this.cME));
                                setResult(-1, intent);
                                break;
                            }
                            intent2.putExtra("card_list", h.a(linkedList, true, this.cME));
                            setResult(-1, intent2);
                            break;
                        case 0:
                            if (intent != null && !TextUtils.isEmpty(charSequence)) {
                                intent.putExtra("card_list", h.bQ(charSequence, this.cME));
                                setResult(0, intent);
                                break;
                            }
                            intent2.putExtra("card_list", h.a(linkedList, false, this.cME));
                            intent2.putExtra("result_code", 1);
                            setResult(0, intent2);
                            break;
                            break;
                    }
                }
                intent2 = new Intent();
                switch (i2) {
                    case -1:
                        if (intent != null && !TextUtils.isEmpty(charSequence)) {
                            intent.putExtra("card_list", h.bQ(charSequence, this.cME));
                            setResult(-1, intent);
                            break;
                        }
                        intent2.putExtra("card_list", h.a(linkedList, true, this.cME));
                        setResult(-1, intent2);
                        break;
                        break;
                    case 0:
                        if (intent != null && !TextUtils.isEmpty(charSequence)) {
                            intent.putExtra("card_list", h.bQ(charSequence, this.cME));
                            setResult(0, intent);
                            break;
                        }
                        intent2.putExtra("card_list", h.a(linkedList, false, this.cME));
                        intent2.putExtra("result_code", 1);
                        setResult(0, intent2);
                        break;
                }
            }
        }
        ab.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_DETAIL");
        if (this.cME != 7 && this.cME != 16) {
            if (this.cME != 26) {
                switch (i2) {
                    case -1:
                        if (intent != null && linkedList.size() > 0) {
                            ((e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                        }
                        aq(-1, h.a(linkedList, true, this.cME));
                        break;
                    case 0:
                        aq(0, h.a(linkedList, false, this.cME));
                        break;
                }
            }
            intent2 = new Intent();
            switch (i2) {
                case -1:
                    if (intent != null && linkedList.size() > 0) {
                        ((e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                    }
                    intent2.putExtra("card_list", h.a(linkedList, true, this.cME));
                    setResult(-1, intent2);
                    break;
                case 0:
                    intent2.putExtra("card_list", h.a(linkedList, false, this.cME));
                    setResult(0, intent2);
                    break;
            }
        }
        intent2 = new Intent();
        switch (i2) {
            case -1:
                if (intent != null && linkedList.size() > 0) {
                    ((e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                }
                intent2.putExtra("card_list", h.a(linkedList, true, this.cME));
                setResult(-1, intent2);
                break;
            case 0:
                intent2.putExtra("card_list", h.a(linkedList, false, this.cME));
                setResult(0, intent2);
                break;
        }
        finish();
        AppMethodBeat.o(88249);
    }

    private void aq(int i, String str) {
        AppMethodBeat.i(88250);
        Bundle bundle = new Bundle();
        bundle.putString("_wxapi_add_card_to_wx_card_list", str);
        f bT = g.bT(this.appId, true);
        Resp resp = new Resp(bundle);
        if (bT != null) {
            resp.openId = bT.field_openId;
        }
        resp.transaction = this.kiB;
        String str2 = "MicroMsg.CardAddEntranceUI";
        String str3 = "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s";
        Object[] objArr = new Object[4];
        objArr[0] = this.appId;
        objArr[1] = bT == null ? "null appinfo" : bT.field_appName;
        objArr[2] = bT == null ? "null appinfo" : bT.field_openId;
        objArr[3] = this.kiB;
        ab.i(str2, str3, objArr);
        resp.toBundle(bundle);
        ab.i("MicroMsg.CardAddEntranceUI", "setResultToSDK result:".concat(String.valueOf(i)));
        if (i == -1) {
            resp.errCode = 0;
        } else {
            resp.errCode = -2;
        }
        Args args = new Args();
        args.targetPkgName = this.kiA;
        args.bundle = bundle;
        p.at(bundle);
        p.au(bundle);
        MMessageActV2.send(ah.getContext(), args);
        AppMethodBeat.o(88250);
    }
}
