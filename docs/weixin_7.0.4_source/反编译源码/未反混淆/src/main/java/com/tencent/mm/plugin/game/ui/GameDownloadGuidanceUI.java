package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.p;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.ab;
import com.tencent.mm.plugin.game.model.ao;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public class GameDownloadGuidanceUI extends GameCenterBaseUI implements f {
    private Dialog lud;
    private bi mXT;
    private LinearLayout mpt;
    private TextView nhO;
    private TextView nhP;
    private TextView nhQ;
    private boolean nhR;
    private String nhS = "";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111887);
        super.onCreate(bundle);
        g.Rg().a(2586, (f) this);
        initView();
        c.aNS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(111882);
                byte[] NK = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCZ().NK("pb_download_guidance");
                if (NK == null) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(111880);
                            if (GameDownloadGuidanceUI.this.isFinishing()) {
                                AppMethodBeat.o(111880);
                                return;
                            }
                            GameDownloadGuidanceUI.this.lud = c.ej(GameDownloadGuidanceUI.this);
                            GameDownloadGuidanceUI.this.lud.show();
                            AppMethodBeat.o(111880);
                        }
                    });
                } else {
                    final ab abVar = new ab(NK);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(111881);
                            try {
                                GameDownloadGuidanceUI.this.a(abVar, 1);
                                AppMethodBeat.o(111881);
                            } catch (Exception e) {
                                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", e.getMessage());
                                GameDownloadGuidanceUI.this.finish();
                                AppMethodBeat.o(111881);
                            }
                        }
                    });
                }
                g.Rg().a(new ao(aa.dor(), e.bDR(), GameDownloadGuidanceUI.this.nfw, GameDownloadGuidanceUI.this.nfx, GameDownloadGuidanceUI.this.nfy, GameDownloadGuidanceUI.this.nfv), 0);
                e.bDW();
                a.nnu.bFC();
                AppMethodBeat.o(111882);
            }
        });
        AppMethodBeat.o(111887);
    }

    public void onDestroy() {
        AppMethodBeat.i(111888);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.GameDownloadGuidanceUI", "onDestroy");
        super.onDestroy();
        a.nnu.clearCache();
        g.Rg().b(2586, (f) this);
        ((b) g.K(b.class)).bCV().clearCache();
        AppMethodBeat.o(111888);
    }

    public final void initView() {
        AppMethodBeat.i(111889);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(111879);
                GameDownloadGuidanceUI.this.finish();
                AppMethodBeat.o(111879);
                return true;
            }
        });
        setMMTitle((int) R.string.c8c);
        this.mpt = (LinearLayout) findViewById(R.id.nc);
        this.nhO = (TextView) findViewById(R.id.c6f);
        this.nhP = (TextView) findViewById(R.id.c6g);
        this.nhQ = (TextView) findViewById(R.id.c6h);
        AppMethodBeat.o(111889);
    }

    public final void a(ab abVar, int i) {
        AppMethodBeat.i(111890);
        if (isFinishing()) {
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI hasFinished");
            AppMethodBeat.o(111890);
        } else if (abVar == null || abVar.bEJ() == null) {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.GameDownloadGuidanceUI", "Null data");
            AppMethodBeat.o(111890);
        } else {
            if (abVar == null || abVar.bEK() == null) {
                this.nhS = "";
            } else {
                this.nhS = abVar.bEK().mZj;
            }
            if (bo.isNullOrNil(this.nhS)) {
                if (this.nhR) {
                    removeOptionMenu(0);
                    this.nhR = false;
                }
            } else if (!this.nhR) {
                addIconOptionMenu(0, R.raw.actionbar_setting_icon, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(111884);
                        com.tencent.mm.plugin.game.e.b.a(GameDownloadGuidanceUI.this.mController.ylL, 10, 1008, 1, c.ax(GameDownloadGuidanceUI.this.mController.ylL, GameDownloadGuidanceUI.this.nhS), GameDownloadGuidanceUI.this.mXC, null);
                        AppMethodBeat.o(111884);
                        return true;
                    }
                });
                this.nhR = true;
            }
            this.mpt.setVisibility(0);
            p bEJ = abVar.bEJ();
            if (bo.isNullOrNil(bEJ.mZZ)) {
                this.nhO.setVisibility(8);
            } else {
                this.nhO.setText(bEJ.mZZ);
                this.nhO.setVisibility(0);
            }
            if (bo.isNullOrNil(bEJ.naa)) {
                this.nhP.setVisibility(8);
            } else {
                this.nhP.setText(bEJ.naa);
                this.nhP.setVisibility(0);
            }
            if (bo.isNullOrNil(bEJ.nab)) {
                this.nhQ.setVisibility(8);
            } else {
                this.nhQ.setText(bEJ.nab);
                this.nhQ.setVisibility(0);
            }
            if (i == 2) {
                c.aNS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(111883);
                        ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCZ().b("pb_over_sea", GameDownloadGuidanceUI.this.mXT);
                        AppMethodBeat.o(111883);
                    }
                });
            }
            AppMethodBeat.o(111890);
        }
    }

    public final int getLayoutId() {
        return R.layout.a46;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(111891);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.GameDownloadGuidanceUI", "errType: %d errCode: %d, scene: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(mVar.hashCode()));
        if (i == 0 && i2 == 0) {
            switch (mVar.getType()) {
                case 2586:
                    final long currentTimeMillis = System.currentTimeMillis();
                    final com.tencent.mm.bt.a aVar = ((ao) mVar).lty.fsH.fsP;
                    c.aNS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(111886);
                            if (aVar == null) {
                                GameDownloadGuidanceUI.this.mXT = new bi();
                            } else {
                                GameDownloadGuidanceUI.this.mXT = (bi) aVar;
                            }
                            final ab abVar = new ab(aVar);
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(111885);
                                    try {
                                        GameDownloadGuidanceUI.this.a(abVar, 2);
                                    } catch (Exception e) {
                                        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", e.getMessage());
                                        GameDownloadGuidanceUI.this.finish();
                                    }
                                    if (GameDownloadGuidanceUI.this.lud != null) {
                                        GameDownloadGuidanceUI.this.lud.dismiss();
                                    }
                                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.GameDownloadGuidanceUI", "Server data parsing time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    AppMethodBeat.o(111885);
                                }
                            });
                            AppMethodBeat.o(111886);
                        }
                    });
                    break;
            }
            AppMethodBeat.o(111891);
            return;
        }
        if (!com.tencent.mm.plugin.game.b.a.gkF.a((Context) this, i, i2, str)) {
            Toast.makeText(this, getString(R.string.c6n, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.lud != null) {
            this.lud.cancel();
        }
        AppMethodBeat.o(111891);
    }
}
