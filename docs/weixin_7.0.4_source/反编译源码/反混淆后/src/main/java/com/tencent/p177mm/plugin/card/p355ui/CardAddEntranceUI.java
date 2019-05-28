package com.tencent.p177mm.plugin.card.p355ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.channel.MMessageActV2;
import com.tencent.p177mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.p177mm.opensdk.modelbiz.AddCardToWXCardPackage.Resp;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.card.model.C38744e;
import com.tencent.p177mm.plugin.card.p931d.C20135h;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.protocal.protobuf.C35941nx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.card.ui.CardAddEntranceUI */
public class CardAddEntranceUI extends MMActivity {
    private String appId;
    private int cME = 8;
    private String kiA = "";
    private String kiB;
    private int kiC = 0;
    LinkedList<C35941nx> kip = new LinkedList();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CardAddEntranceUI() {
        AppMethodBeat.m2504i(88246);
        AppMethodBeat.m2505o(88246);
    }

    public final int getLayoutId() {
        return 2130968895;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(88247);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onCreate() intent == null");
            setResult(0);
            finish();
            AppMethodBeat.m2505o(88247);
            return;
        }
        C4990ab.m7416i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI doRediect() handle data");
        String stringExtra = intent.getStringExtra("key_in_card_list");
        this.cME = intent.getIntExtra("key_from_scene", 8);
        this.kiC = intent.getIntExtra("key_stastic_scene", 0);
        C4990ab.m7416i("MicroMsg.CardAddEntranceUI", "doRediect() from_scene:" + this.cME + "  from_origin_scene:" + this.kiC);
        this.kiA = intent.getStringExtra("key_package_name");
        String stringExtra2 = intent.getStringExtra("key_sign");
        String stringExtra3 = getIntent().getStringExtra("src_username");
        C4990ab.m7416i("MicroMsg.CardAddEntranceUI", "doRediect() src_username:".concat(String.valueOf(stringExtra3)));
        String stringExtra4 = getIntent().getStringExtra("js_url");
        this.appId = getIntent().getStringExtra("key_app_id");
        this.kiB = getIntent().getStringExtra("key_transaction");
        String stringExtra5 = getIntent().getStringExtra("key_consumed_card_id");
        C4990ab.m7416i("MicroMsg.CardAddEntranceUI", "doRediect() consumedCardId:".concat(String.valueOf(stringExtra5)));
        String stringExtra6 = getIntent().getStringExtra("key_template_id");
        ArrayList bP = C20135h.m31152bP(stringExtra, this.cME);
        if (bP == null || bP.size() == 0) {
            C4990ab.m7412e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI initView () tempList == null || tempList.size() == 0");
            setResult(0);
            finish();
            AppMethodBeat.m2505o(88247);
            return;
        }
        this.kip.clear();
        this.kip.addAll(bP);
        Intent intent2 = new Intent();
        intent2.putExtra("key_from_scene", this.cME);
        intent2.putExtra("key_stastic_scene", this.kiC);
        if (bP.size() == 1) {
            C35941nx c35941nx = (C35941nx) bP.get(0);
            intent2.putExtra("key_card_id", c35941nx.kbU);
            intent2.putExtra("key_card_ext", c35941nx.cMD);
            intent2.putExtra("src_username", stringExtra3);
            intent2.putExtra("js_url", stringExtra4);
            intent2.putExtra("key_consumed_card_id", stringExtra5);
            intent2.putExtra("key_template_id", stringExtra6);
            intent2.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
            intent2.setClass(this, CardDetailUI.class);
            startActivityForResult(intent2, 1);
            AppMethodBeat.m2505o(88247);
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
        AppMethodBeat.m2505o(88247);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(88248);
        super.onDestroy();
        AppMethodBeat.m2505o(88248);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(88249);
        C4990ab.m7418v("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onActivityResult");
        if (i2 == -1) {
            C4990ab.m7416i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_OK");
        } else {
            C4990ab.m7416i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_CANCELED");
        }
        LinkedList linkedList = new LinkedList();
        Iterator it = this.kip.iterator();
        while (it.hasNext()) {
            C35941nx c35941nx = (C35941nx) it.next();
            C38744e c38744e = new C38744e();
            c38744e.kbU = c35941nx.kbU;
            c38744e.cMD = c35941nx.cMD;
            linkedList.add(c38744e);
        }
        Intent intent2;
        if (i != 1) {
            if (i == 2) {
                C4990ab.m7416i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_ACCEPT_CARD_LIST");
                CharSequence charSequence = "";
                if (intent != null) {
                    charSequence = intent.getStringExtra("card_list");
                }
                if (this.cME != 7 && this.cME != 16) {
                    if (this.cME != 26) {
                        switch (i2) {
                            case -1:
                                if (!TextUtils.isEmpty(charSequence)) {
                                    m31197aq(-1, charSequence);
                                    break;
                                } else {
                                    m31197aq(-1, C20135h.m31151a(linkedList, true, this.cME));
                                    break;
                                }
                            case 0:
                                if (!TextUtils.isEmpty(charSequence)) {
                                    m31197aq(0, charSequence);
                                    break;
                                } else {
                                    m31197aq(0, C20135h.m31151a(linkedList, false, this.cME));
                                    break;
                                }
                        }
                    }
                    intent2 = new Intent();
                    switch (i2) {
                        case -1:
                            if (intent != null && !TextUtils.isEmpty(charSequence)) {
                                intent.putExtra("card_list", C20135h.m31153bQ(charSequence, this.cME));
                                setResult(-1, intent);
                                break;
                            }
                            intent2.putExtra("card_list", C20135h.m31151a(linkedList, true, this.cME));
                            setResult(-1, intent2);
                            break;
                        case 0:
                            if (intent != null && !TextUtils.isEmpty(charSequence)) {
                                intent.putExtra("card_list", C20135h.m31153bQ(charSequence, this.cME));
                                setResult(0, intent);
                                break;
                            }
                            intent2.putExtra("card_list", C20135h.m31151a(linkedList, false, this.cME));
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
                            intent.putExtra("card_list", C20135h.m31153bQ(charSequence, this.cME));
                            setResult(-1, intent);
                            break;
                        }
                        intent2.putExtra("card_list", C20135h.m31151a(linkedList, true, this.cME));
                        setResult(-1, intent2);
                        break;
                        break;
                    case 0:
                        if (intent != null && !TextUtils.isEmpty(charSequence)) {
                            intent.putExtra("card_list", C20135h.m31153bQ(charSequence, this.cME));
                            setResult(0, intent);
                            break;
                        }
                        intent2.putExtra("card_list", C20135h.m31151a(linkedList, false, this.cME));
                        intent2.putExtra("result_code", 1);
                        setResult(0, intent2);
                        break;
                }
            }
        }
        C4990ab.m7416i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_DETAIL");
        if (this.cME != 7 && this.cME != 16) {
            if (this.cME != 26) {
                switch (i2) {
                    case -1:
                        if (intent != null && linkedList.size() > 0) {
                            ((C38744e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                        }
                        m31197aq(-1, C20135h.m31151a(linkedList, true, this.cME));
                        break;
                    case 0:
                        m31197aq(0, C20135h.m31151a(linkedList, false, this.cME));
                        break;
                }
            }
            intent2 = new Intent();
            switch (i2) {
                case -1:
                    if (intent != null && linkedList.size() > 0) {
                        ((C38744e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                    }
                    intent2.putExtra("card_list", C20135h.m31151a(linkedList, true, this.cME));
                    setResult(-1, intent2);
                    break;
                case 0:
                    intent2.putExtra("card_list", C20135h.m31151a(linkedList, false, this.cME));
                    setResult(0, intent2);
                    break;
            }
        }
        intent2 = new Intent();
        switch (i2) {
            case -1:
                if (intent != null && linkedList.size() > 0) {
                    ((C38744e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                }
                intent2.putExtra("card_list", C20135h.m31151a(linkedList, true, this.cME));
                setResult(-1, intent2);
                break;
            case 0:
                intent2.putExtra("card_list", C20135h.m31151a(linkedList, false, this.cME));
                setResult(0, intent2);
                break;
        }
        finish();
        AppMethodBeat.m2505o(88249);
    }

    /* renamed from: aq */
    private void m31197aq(int i, String str) {
        AppMethodBeat.m2504i(88250);
        Bundle bundle = new Bundle();
        bundle.putString("_wxapi_add_card_to_wx_card_list", str);
        C40439f bT = C46494g.m87739bT(this.appId, true);
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
        C4990ab.m7417i(str2, str3, objArr);
        resp.toBundle(bundle);
        C4990ab.m7416i("MicroMsg.CardAddEntranceUI", "setResultToSDK result:".concat(String.valueOf(i)));
        if (i == -1) {
            resp.errCode = 0;
        } else {
            resp.errCode = -2;
        }
        Args args = new Args();
        args.targetPkgName = this.kiA;
        args.bundle = bundle;
        C35799p.m58687at(bundle);
        C35799p.m58688au(bundle);
        MMessageActV2.send(C4996ah.getContext(), args);
        AppMethodBeat.m2505o(88250);
    }
}
