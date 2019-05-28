package com.tencent.p177mm.plugin.game.p433ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.game.report.p850a.C9541b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.game.commlib.C45985a;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C21004l;
import com.tencent.p177mm.plugin.game.model.C28229n;
import com.tencent.p177mm.plugin.game.model.C39215q;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p433ui.tab.GameRouteUI;
import com.tencent.p177mm.plugin.game.p731d.C34265ak;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import java.util.HashMap;

@C5271a(19)
@C18524i
/* renamed from: com.tencent.mm.plugin.game.ui.GameCenterUI */
public class GameCenterUI extends MMBaseActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(111781);
        super.onCreate(bundle);
        getIntent().putExtra("gamecenterui_createtime", System.currentTimeMillis());
        C4990ab.m7416i("MicroMsg.GameCenterUI", "onCreate, time: " + System.currentTimeMillis());
        if (getIntent().getBooleanExtra("game_check_float", false)) {
            int intExtra = getIntent().getIntExtra("game_sourceScene", 0);
            ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
            C28229n bEo = C39215q.bEo();
            if (bEo != null) {
                bEo.bEl();
                if (!C5046bo.isNullOrNil(bEo.mWG.url)) {
                    C46001c.m85452a(getBaseContext(), bEo, "game_center_h5_floatlayer");
                }
            }
            C21004l.m32304a(bEo, intExtra, 1);
            finish();
            AppMethodBeat.m2505o(111781);
            return;
        }
        boolean booleanExtra = getIntent().getBooleanExtra("switch_country_no_anim", false);
        C34265ak bDe = C45985a.bDe();
        if (bDe != null) {
            Intent intent;
            Bundle extras;
            switch (bDe.naz) {
                case 0:
                    m32312hS(booleanExtra);
                    break;
                case 1:
                    if (!C5046bo.isNullOrNil(bDe.mZj)) {
                        m32309Om(bDe.mZj);
                        break;
                    } else {
                        m32312hS(booleanExtra);
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
                        overridePendingTransition(C25738R.anim.f8344bi, C25738R.anim.f8344bi);
                    } else {
                        overridePendingTransition(C5206a.ync, C5206a.ynd);
                    }
                    m32311X(6, false);
                    C7060h.pYm.mo8378a(848, 5, 1, false);
                    break;
                case 3:
                    intent = new Intent(this, GameDownloadGuidanceUI.class);
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        intent.putExtras(extras);
                    }
                    startActivity(intent);
                    if (booleanExtra) {
                        overridePendingTransition(C25738R.anim.f8344bi, C25738R.anim.f8344bi);
                    } else {
                        overridePendingTransition(C5206a.ync, C5206a.ynd);
                    }
                    m32311X(6, false);
                    C7060h.pYm.mo8378a(848, 6, 1, false);
                    break;
            }
        }
        m32312hS(booleanExtra);
        finish();
        AppMethodBeat.m2505o(111781);
    }

    /* renamed from: hS */
    private void m32312hS(boolean z) {
        AppMethodBeat.m2504i(111782);
        if (C5059g.dnY()) {
            C4990ab.m7416i("MicroMsg.GameCenterUI", "GP version");
            C7060h.pYm.mo8378a(848, 13, 1, false);
        } else {
            String bFG = C46001c.bFG();
            if (!C5046bo.isNullOrNil(bFG)) {
                m32309Om(bFG);
                AppMethodBeat.m2505o(111782);
                return;
            }
        }
        m32313hT(z);
        AppMethodBeat.m2505o(111782);
    }

    /* renamed from: Om */
    private void m32309Om(String str) {
        AppMethodBeat.m2504i(111783);
        getIntent().putExtra("rawUrl", str);
        if (((C9541b) C1720g.m3528K(C9541b.class)).mo20808a(C11745a.game_luggage)) {
            m32310On(str);
        } else {
            m32311X(7, false);
            C21004l.m32302a((Activity) this, str, getIntent());
            C7060h.pYm.mo8378a(848, 3, 1, false);
        }
        C20993e.bEc();
        AppMethodBeat.m2505o(111783);
    }

    /* renamed from: On */
    private void m32310On(String str) {
        AppMethodBeat.m2504i(111784);
        m32311X(7, true);
        C21004l.m32305b(this, str, getIntent());
        C7060h.pYm.mo8378a(848, 3, 1, false);
        C7060h.pYm.mo8378a(848, 9, 1, false);
        AppMethodBeat.m2505o(111784);
    }

    /* renamed from: hT */
    private void m32313hT(boolean z) {
        AppMethodBeat.m2504i(111785);
        Intent intent = new Intent(this, GameRouteUI.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        startActivity(intent);
        if (z) {
            overridePendingTransition(C25738R.anim.f8344bi, C25738R.anim.f8344bi);
        } else {
            overridePendingTransition(C5206a.ync, C5206a.ynd);
        }
        m32311X(6, false);
        C7060h.pYm.mo8378a(848, 4, 1, false);
        AppMethodBeat.m2505o(111785);
    }

    /* renamed from: X */
    private void m32311X(int i, boolean z) {
        AppMethodBeat.m2504i(111786);
        if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
            ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
            C28229n bEm = C39215q.bEm();
            HashMap hashMap = new HashMap();
            if (z) {
                hashMap.put("luggage", "1");
            }
            if (bEm == null) {
                hashMap.put("function_type", "resource");
                hashMap.put("function_value", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                C34277b.m56209a(this, 9, 901, 1, i, 0, C34276a.m56201K(hashMap));
                AppMethodBeat.m2505o(111786);
                return;
            }
            bEm.bEl();
            int i2 = bEm.field_msgType;
            if (bEm.field_msgType == 100) {
                i2 = bEm.mXb;
            }
            hashMap.put("function_type", "resource");
            hashMap.put("function_value", String.valueOf(bEm.mWr.mXl));
            C34277b.m56210a(this, 9, 901, 1, i, 0, bEm.field_appId, 0, i2, bEm.field_gameMsgId, bEm.mXc, C34276a.m56201K(hashMap));
            ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
            C39215q.bEn();
            C7060h.pYm.mo8378a(858, 3, 1, false);
        }
        AppMethodBeat.m2505o(111786);
    }
}
