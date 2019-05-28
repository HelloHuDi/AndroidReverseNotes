package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.d.k;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.Iterator;
import java.util.LinkedList;

@a(3)
public class CardViewEntranceUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.hx;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88664);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            ab.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI onCreate() intent == null");
            setResult(0, intent);
            finish();
            AppMethodBeat.o(88664);
            return;
        }
        int intExtra = intent.getIntExtra("key_from_scene", 50);
        ab.i("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI doRediect() handle data");
        String stringExtra = intent.getStringExtra("card_list");
        ab.d("MicroMsg.CardViewEntranceUI", "appid: %s", intent.getStringExtra("key_app_id"));
        if (TextUtils.isEmpty(stringExtra)) {
            ab.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI oncreate card_list is empty");
            setResult(0, intent);
            finish();
            AppMethodBeat.o(88664);
            return;
        }
        LinkedList bR = k.bR(stringExtra, intExtra);
        if (bR == null || bR.size() == 0) {
            ab.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI oncreate tempList size is empty");
            setResult(0, intent);
            finish();
            AppMethodBeat.o(88664);
            return;
        }
        Iterator it = bR.iterator();
        while (it.hasNext()) {
            ((oj) it.next()).csB = r4;
        }
        Intent intent2 = new Intent();
        if (bR.size() == 1) {
            intent2.putExtra("card_list", stringExtra);
            intent2.putExtra("key_from_scene", 50);
            intent2.putExtra("key_previous_scene", intExtra);
            if (!bo.isNullOrNil(intent.getStringExtra("key_template_id"))) {
                intent2.putExtra("key_template_id", intent.getStringExtra("key_template_id"));
            }
            intent2.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
            intent2.setClass(this, CardDetailUI.class);
            startActivity(intent2);
        } else {
            intent2.putExtra("view_type", 0);
            intent2.putExtra("card_list", stringExtra);
            intent2.putExtra("key_previous_scene", intExtra);
            if (!bo.isNullOrNil(intent.getStringExtra("key_template_id"))) {
                intent2.putExtra("key_template_id", intent.getStringExtra("key_template_id"));
            }
            intent2.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
            intent2.setClass(this, CardViewUI.class);
            startActivity(intent2);
        }
        ab.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI onCreate() parameter is ok");
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(88664);
    }
}
