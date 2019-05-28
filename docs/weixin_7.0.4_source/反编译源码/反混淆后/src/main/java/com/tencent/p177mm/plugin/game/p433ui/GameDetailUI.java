package com.tencent.p177mm.plugin.game.p433ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C39211a;
import com.tencent.p177mm.plugin.game.model.C39211a.C3243a;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.game.ui.GameDetailUI */
public class GameDetailUI extends MMBaseActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(111839);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("game_app_id");
        C3243a cm = C39211a.m66814cm(stringExtra, getIntent().getIntExtra("game_report_from_scene", 0));
        if (cm.bJt != 2 || C5046bo.isNullOrNil(cm.url)) {
            int bEb = C20993e.bEb();
            if (bEb == 2) {
                C46001c.m85462m(this, stringExtra, 0);
            } else if (bEb == 1) {
                C46001c.m85460g(this, getIntent().getExtras());
            } else {
                String gQ = C5046bo.m7555gQ(this);
                if (C5046bo.isNullOrNil(gQ) || gQ.toLowerCase().equals("cn")) {
                    C46001c.m85462m(this, stringExtra, 0);
                } else {
                    C46001c.m85460g(this, getIntent().getExtras());
                }
            }
        } else {
            C46001c.m85464t(getBaseContext(), cm.url, "game_center_detail");
        }
        finish();
        AppMethodBeat.m2505o(111839);
    }
}
