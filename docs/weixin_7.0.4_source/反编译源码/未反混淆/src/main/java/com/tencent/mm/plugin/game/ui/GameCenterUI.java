package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.d.ak;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.ui.tab.GameRouteUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import java.util.HashMap;

@a(19)
@i
public class GameCenterUI extends MMBaseActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111781);
        super.onCreate(bundle);
        getIntent().putExtra("gamecenterui_createtime", System.currentTimeMillis());
        ab.i("MicroMsg.GameCenterUI", "onCreate, time: " + System.currentTimeMillis());
        if (getIntent().getBooleanExtra("game_check_float", false)) {
            int intExtra = getIntent().getIntExtra("game_sourceScene", 0);
            ((b) g.K(b.class)).bCX();
            n bEo = q.bEo();
            if (bEo != null) {
                bEo.bEl();
                if (!bo.isNullOrNil(bEo.mWG.url)) {
                    c.a(getBaseContext(), bEo, "game_center_h5_floatlayer");
                }
            }
            l.a(bEo, intExtra, 1);
            finish();
            AppMethodBeat.o(111781);
            return;
        }
        boolean booleanExtra = getIntent().getBooleanExtra("switch_country_no_anim", false);
        ak bDe = com.tencent.mm.plugin.game.commlib.a.bDe();
        if (bDe != null) {
            Intent intent;
            Bundle extras;
            switch (bDe.naz) {
                case 0:
                    hS(booleanExtra);
                    break;
                case 1:
                    if (!bo.isNullOrNil(bDe.mZj)) {
                        Om(bDe.mZj);
                        break;
                    } else {
                        hS(booleanExtra);
                        break;
                    }
                case 2:
                    intent = new Intent(this, GameOverSeaCenterUI.class);
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        intent.putExtras(extras);
                    }
                    startActivity(intent);
                    if (booleanExtra) {
                        overridePendingTransition(R.anim.bi, R.anim.bi);
                    } else {
                        overridePendingTransition(MMFragmentActivity.a.ync, MMFragmentActivity.a.ynd);
                    }
                    X(6, false);
                    h.pYm.a(848, 5, 1, false);
                    break;
                case 3:
                    intent = new Intent(this, GameDownloadGuidanceUI.class);
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        intent.putExtras(extras);
                    }
                    startActivity(intent);
                    if (booleanExtra) {
                        overridePendingTransition(R.anim.bi, R.anim.bi);
                    } else {
                        overridePendingTransition(MMFragmentActivity.a.ync, MMFragmentActivity.a.ynd);
                    }
                    X(6, false);
                    h.pYm.a(848, 6, 1, false);
                    break;
            }
        }
        hS(booleanExtra);
        finish();
        AppMethodBeat.o(111781);
    }

    private void hS(boolean z) {
        AppMethodBeat.i(111782);
        if (com.tencent.mm.sdk.platformtools.g.dnY()) {
            ab.i("MicroMsg.GameCenterUI", "GP version");
            h.pYm.a(848, 13, 1, false);
        } else {
            String bFG = c.bFG();
            if (!bo.isNullOrNil(bFG)) {
                Om(bFG);
                AppMethodBeat.o(111782);
                return;
            }
        }
        hT(z);
        AppMethodBeat.o(111782);
    }

    private void Om(String str) {
        AppMethodBeat.i(111783);
        getIntent().putExtra("rawUrl", str);
        if (((com.tencent.mm.game.report.a.b) g.K(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.a.a.a.game_luggage)) {
            On(str);
        } else {
            X(7, false);
            l.a((Activity) this, str, getIntent());
            h.pYm.a(848, 3, 1, false);
        }
        e.bEc();
        AppMethodBeat.o(111783);
    }

    private void On(String str) {
        AppMethodBeat.i(111784);
        X(7, true);
        l.b(this, str, getIntent());
        h.pYm.a(848, 3, 1, false);
        h.pYm.a(848, 9, 1, false);
        AppMethodBeat.o(111784);
    }

    private void hT(boolean z) {
        AppMethodBeat.i(111785);
        Intent intent = new Intent(this, GameRouteUI.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        startActivity(intent);
        if (z) {
            overridePendingTransition(R.anim.bi, R.anim.bi);
        } else {
            overridePendingTransition(MMFragmentActivity.a.ync, MMFragmentActivity.a.ynd);
        }
        X(6, false);
        h.pYm.a(848, 4, 1, false);
        AppMethodBeat.o(111785);
    }

    private void X(int i, boolean z) {
        AppMethodBeat.i(111786);
        if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
            ((b) g.K(b.class)).bCX();
            n bEm = q.bEm();
            HashMap hashMap = new HashMap();
            if (z) {
                hashMap.put("luggage", "1");
            }
            if (bEm == null) {
                hashMap.put("function_type", "resource");
                hashMap.put("function_value", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                com.tencent.mm.plugin.game.e.b.a(this, 9, 901, 1, i, 0, com.tencent.mm.plugin.game.e.a.K(hashMap));
                AppMethodBeat.o(111786);
                return;
            }
            bEm.bEl();
            int i2 = bEm.field_msgType;
            if (bEm.field_msgType == 100) {
                i2 = bEm.mXb;
            }
            hashMap.put("function_type", "resource");
            hashMap.put("function_value", String.valueOf(bEm.mWr.mXl));
            com.tencent.mm.plugin.game.e.b.a(this, 9, 901, 1, i, 0, bEm.field_appId, 0, i2, bEm.field_gameMsgId, bEm.mXc, com.tencent.mm.plugin.game.e.a.K(hashMap));
            ((b) g.K(b.class)).bCX();
            q.bEn();
            h.pYm.a(858, 3, 1, false);
        }
        AppMethodBeat.o(111786);
    }
}
