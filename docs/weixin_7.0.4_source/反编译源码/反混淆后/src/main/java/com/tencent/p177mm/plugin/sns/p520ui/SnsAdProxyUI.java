package com.tencent.p177mm.plugin.sns.p520ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdProxyUI */
public class SnsAdProxyUI extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(38732);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            C45124d.m82927e("MicroMsg.SnsAdBlankUI", "intent null!");
            finish();
            AppMethodBeat.m2505o(38732);
            return;
        }
        String stringExtra = intent.getStringExtra("username");
        String stringExtra2 = intent.getStringExtra("url");
        String stringExtra3 = intent.getStringExtra("sceneNote");
        C32628se c32628se = new C32628se();
        c32628se.cOf.userName = stringExtra;
        c32628se.cOf.cOh = stringExtra2;
        c32628se.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHEN;
        c32628se.cOf.cst = stringExtra3;
        c32628se.cOf.context = this;
        C4879a.xxA.mo10055m(c32628se);
        finish();
        AppMethodBeat.m2505o(38732);
    }
}
