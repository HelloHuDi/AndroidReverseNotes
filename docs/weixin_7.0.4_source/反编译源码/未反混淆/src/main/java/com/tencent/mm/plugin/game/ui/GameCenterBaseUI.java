package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class GameCenterBaseUI extends GameCenterActivity {
    protected int mXC = 0;
    private boolean nfA = true;
    protected boolean nfv = false;
    protected n nfw;
    protected n nfx;
    protected n nfy;
    protected boolean nfz = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(GameCenterBaseUI gameCenterBaseUI) {
        if (gameCenterBaseUI.nfx != null && !gameCenterBaseUI.nfx.field_isHidden && !bo.isNullOrNil(gameCenterBaseUI.nfx.mWG.url)) {
            gameCenterBaseUI.nfz = true;
            n nVar = gameCenterBaseUI.nfx;
            c.a(gameCenterBaseUI.getBaseContext(), nVar, "game_center_h5_floatlayer");
            int i = nVar.field_msgType;
            if (nVar.field_msgType == 100) {
                i = nVar.mXb;
            }
            b.a(gameCenterBaseUI, 10, 1006, 1, 1, 0, nVar.field_appId, 0, i, nVar.field_gameMsgId, nVar.mXc, null);
            h.pYm.a(858, 18, 1, false);
            gameCenterBaseUI.nfx.field_isRead = true;
            ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCY().c(gameCenterBaseUI.nfx, new String[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (g.RK()) {
            this.mXC = getIntent().getIntExtra("game_report_from_scene", 0);
            this.nfv = getIntent().getBooleanExtra("from_find_more_friend", false);
            c.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(111759);
                    GameCenterBaseUI.a(GameCenterBaseUI.this);
                    if (GameCenterBaseUI.this.nfv) {
                        GameCenterBaseUI.b(GameCenterBaseUI.this);
                        ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCX();
                        q.bEp();
                    }
                    AppMethodBeat.o(111759);
                }
            });
            b.a(this, 10, 1000, 0, 1, 0, null, this.mXC, 0, null, null, null);
            return;
        }
        ab.e("MicroMsg.GameCenterBaseUI", "account not ready");
        finish();
    }

    public void onResume() {
        super.onResume();
        if (g.RK()) {
            if (!this.nfA && a.nnu.nns) {
                a.nnu.nns = false;
                ab.i("MicroMsg.GameCenterBaseUI", "restart page from country setting");
                if (!isFinishing()) {
                    finish();
                }
                sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), WXApp.WXAPP_BROADCAST_PERMISSION);
                Intent intent = new Intent();
                intent.putExtra("game_report_from_scene", 901);
                intent.putExtra("switch_country_no_anim", true);
                d.b((Context) this, "game", ".ui.GameCenterUI", intent);
            }
            this.nfA = false;
            return;
        }
        ab.e("MicroMsg.GameCenterBaseUI", "account not ready");
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

    static /* synthetic */ void a(GameCenterBaseUI gameCenterBaseUI) {
        if (gameCenterBaseUI.nfv) {
            ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCX();
            gameCenterBaseUI.nfw = q.bEm();
            if (gameCenterBaseUI.nfw != null) {
                gameCenterBaseUI.nfw.bEl();
            }
            ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCX();
            gameCenterBaseUI.nfx = q.bEo();
            if (gameCenterBaseUI.nfx != null) {
                gameCenterBaseUI.nfx.bEl();
            }
        }
        ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCX();
        gameCenterBaseUI.nfy = q.bEq();
        if (gameCenterBaseUI.nfy != null) {
            gameCenterBaseUI.nfy.bEl();
        }
    }
}
