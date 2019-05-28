package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.game.model.C28229n;
import com.tencent.p177mm.plugin.game.model.C39215q;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46000a.C3220a;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameCenterBaseUI */
public abstract class GameCenterBaseUI extends GameCenterActivity {
    protected int mXC = 0;
    private boolean nfA = true;
    protected boolean nfv = false;
    protected C28229n nfw;
    protected C28229n nfx;
    protected C28229n nfy;
    protected boolean nfz = false;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameCenterBaseUI$1 */
    class C282381 implements Runnable {
        C282381() {
        }

        public final void run() {
            AppMethodBeat.m2504i(111759);
            GameCenterBaseUI.m44821a(GameCenterBaseUI.this);
            if (GameCenterBaseUI.this.nfv) {
                GameCenterBaseUI.m44822b(GameCenterBaseUI.this);
                ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
                C39215q.bEp();
            }
            AppMethodBeat.m2505o(111759);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m44822b(GameCenterBaseUI gameCenterBaseUI) {
        if (gameCenterBaseUI.nfx != null && !gameCenterBaseUI.nfx.field_isHidden && !C5046bo.isNullOrNil(gameCenterBaseUI.nfx.mWG.url)) {
            gameCenterBaseUI.nfz = true;
            C28229n c28229n = gameCenterBaseUI.nfx;
            C46001c.m85452a(gameCenterBaseUI.getBaseContext(), c28229n, "game_center_h5_floatlayer");
            int i = c28229n.field_msgType;
            if (c28229n.field_msgType == 100) {
                i = c28229n.mXb;
            }
            C34277b.m56210a(gameCenterBaseUI, 10, 1006, 1, 1, 0, c28229n.field_appId, 0, i, c28229n.field_gameMsgId, c28229n.mXc, null);
            C7060h.pYm.mo8378a(858, 18, 1, false);
            gameCenterBaseUI.nfx.field_isRead = true;
            ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo10103c(gameCenterBaseUI.nfx, new String[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C1720g.m3531RK()) {
            this.mXC = getIntent().getIntExtra("game_report_from_scene", 0);
            this.nfv = getIntent().getBooleanExtra("from_find_more_friend", false);
            C46001c.aNS().mo10302aa(new C282381());
            C34277b.m56210a(this, 10, 1000, 0, 1, 0, null, this.mXC, 0, null, null, null);
            return;
        }
        C4990ab.m7412e("MicroMsg.GameCenterBaseUI", "account not ready");
        finish();
    }

    public void onResume() {
        super.onResume();
        if (C1720g.m3531RK()) {
            if (!this.nfA && C3220a.nnu.nns) {
                C3220a.nnu.nns = false;
                C4990ab.m7416i("MicroMsg.GameCenterBaseUI", "restart page from country setting");
                if (!isFinishing()) {
                    finish();
                }
                sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), WXApp.WXAPP_BROADCAST_PERMISSION);
                Intent intent = new Intent();
                intent.putExtra("game_report_from_scene", 901);
                intent.putExtra("switch_country_no_anim", true);
                C25985d.m41467b((Context) this, "game", ".ui.GameCenterUI", intent);
            }
            this.nfA = false;
            return;
        }
        C4990ab.m7412e("MicroMsg.GameCenterBaseUI", "account not ready");
    }

    public final int bFf() {
        return 10;
    }

    public final int bFg() {
        return 1000;
    }

    public final int bFh() {
        return this.mXC;
    }

    /* renamed from: a */
    static /* synthetic */ void m44821a(GameCenterBaseUI gameCenterBaseUI) {
        if (gameCenterBaseUI.nfv) {
            ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
            gameCenterBaseUI.nfw = C39215q.bEm();
            if (gameCenterBaseUI.nfw != null) {
                gameCenterBaseUI.nfw.bEl();
            }
            ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
            gameCenterBaseUI.nfx = C39215q.bEo();
            if (gameCenterBaseUI.nfx != null) {
                gameCenterBaseUI.nfx.bEl();
            }
        }
        ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
        gameCenterBaseUI.nfy = C39215q.bEq();
        if (gameCenterBaseUI.nfy != null) {
            gameCenterBaseUI.nfy.bEl();
        }
    }
}
