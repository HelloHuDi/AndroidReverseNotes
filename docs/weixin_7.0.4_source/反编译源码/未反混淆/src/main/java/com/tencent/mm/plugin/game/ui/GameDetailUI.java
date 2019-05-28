package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameDetailUI extends MMBaseActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111839);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("game_app_id");
        com.tencent.mm.plugin.game.model.a.a cm = com.tencent.mm.plugin.game.model.a.cm(stringExtra, getIntent().getIntExtra("game_report_from_scene", 0));
        if (cm.bJt != 2 || bo.isNullOrNil(cm.url)) {
            int bEb = e.bEb();
            if (bEb == 2) {
                c.m(this, stringExtra, 0);
            } else if (bEb == 1) {
                c.g(this, getIntent().getExtras());
            } else {
                String gQ = bo.gQ(this);
                if (bo.isNullOrNil(gQ) || gQ.toLowerCase().equals("cn")) {
                    c.m(this, stringExtra, 0);
                } else {
                    c.g(this, getIntent().getExtras());
                }
            }
        } else {
            c.t(getBaseContext(), cm.url, "game_center_detail");
        }
        finish();
        AppMethodBeat.o(111839);
    }
}
