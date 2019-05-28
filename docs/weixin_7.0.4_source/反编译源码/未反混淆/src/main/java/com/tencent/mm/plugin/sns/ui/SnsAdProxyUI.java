package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.se;
import com.tencent.mm.sdk.b.a;
import com.tencent.ttpic.FilterEnum4Shaka;

public class SnsAdProxyUI extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38732);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            d.e("MicroMsg.SnsAdBlankUI", "intent null!");
            finish();
            AppMethodBeat.o(38732);
            return;
        }
        String stringExtra = intent.getStringExtra("username");
        String stringExtra2 = intent.getStringExtra("url");
        String stringExtra3 = intent.getStringExtra("sceneNote");
        se seVar = new se();
        seVar.cOf.userName = stringExtra;
        seVar.cOf.cOh = stringExtra2;
        seVar.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHEN;
        seVar.cOf.cst = stringExtra3;
        seVar.cOf.context = this;
        a.xxA.m(seVar);
        finish();
        AppMethodBeat.o(38732);
    }
}
