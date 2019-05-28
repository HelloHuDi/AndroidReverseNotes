package com.tencent.p177mm.plugin.card.p355ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.card.p931d.C45775k;
import com.tencent.p177mm.protocal.protobuf.C44152oj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.card.ui.CardViewEntranceUI */
public class CardViewEntranceUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130968895;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(88664);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI onCreate() intent == null");
            setResult(0, intent);
            finish();
            AppMethodBeat.m2505o(88664);
            return;
        }
        int intExtra = intent.getIntExtra("key_from_scene", 50);
        C4990ab.m7416i("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI doRediect() handle data");
        String stringExtra = intent.getStringExtra("card_list");
        C4990ab.m7411d("MicroMsg.CardViewEntranceUI", "appid: %s", intent.getStringExtra("key_app_id"));
        if (TextUtils.isEmpty(stringExtra)) {
            C4990ab.m7412e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI oncreate card_list is empty");
            setResult(0, intent);
            finish();
            AppMethodBeat.m2505o(88664);
            return;
        }
        LinkedList bR = C45775k.m84636bR(stringExtra, intExtra);
        if (bR == null || bR.size() == 0) {
            C4990ab.m7412e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI oncreate tempList size is empty");
            setResult(0, intent);
            finish();
            AppMethodBeat.m2505o(88664);
            return;
        }
        Iterator it = bR.iterator();
        while (it.hasNext()) {
            ((C44152oj) it.next()).csB = r4;
        }
        Intent intent2 = new Intent();
        if (bR.size() == 1) {
            intent2.putExtra("card_list", stringExtra);
            intent2.putExtra("key_from_scene", 50);
            intent2.putExtra("key_previous_scene", intExtra);
            if (!C5046bo.isNullOrNil(intent.getStringExtra("key_template_id"))) {
                intent2.putExtra("key_template_id", intent.getStringExtra("key_template_id"));
            }
            intent2.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
            intent2.setClass(this, CardDetailUI.class);
            startActivity(intent2);
        } else {
            intent2.putExtra("view_type", 0);
            intent2.putExtra("card_list", stringExtra);
            intent2.putExtra("key_previous_scene", intExtra);
            if (!C5046bo.isNullOrNil(intent.getStringExtra("key_template_id"))) {
                intent2.putExtra("key_template_id", intent.getStringExtra("key_template_id"));
            }
            intent2.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
            intent2.setClass(this, CardViewUI.class);
            startActivity(intent2);
        }
        C4990ab.m7412e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI onCreate() parameter is ok");
        setResult(-1, intent);
        finish();
        AppMethodBeat.m2505o(88664);
    }
}
