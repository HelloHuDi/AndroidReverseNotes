package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.bk;
import com.tencent.mm.plugin.game.d.cb;
import com.tencent.mm.plugin.game.d.cd;
import com.tencent.mm.plugin.game.d.ci;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.a.a;
import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public class GameOverSeaCenterUI extends GameCenterBaseUI implements f {
    private boolean exX = true;
    private Dialog lud;
    private bk mYh;
    k neZ = new k();
    private boolean nhR;
    private String nhS = "";
    private OnClickListener nkd = new OnClickListener() {
        public final void onClick(View view) {
            int t;
            AppMethodBeat.i(112131);
            a bDM = com.tencent.mm.plugin.game.model.a.bDM();
            if (bDM.bJt == 2) {
                t = c.t(GameOverSeaCenterUI.this.mController.ylL, bDM.url, "game_center_library");
            } else {
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof String) || bo.isNullOrNil((String) tag)) {
                    Intent intent = new Intent(GameOverSeaCenterUI.this.mController.ylL, GameLibraryUI.class);
                    intent.putExtra("game_report_from_scene", 1005);
                    GameOverSeaCenterUI.this.startActivity(intent);
                    t = 6;
                } else {
                    t = c.t(GameOverSeaCenterUI.this.mController.ylL, (String) tag, "game_center_library");
                }
            }
            b.a(GameOverSeaCenterUI.this.mController.ylL, 10, 1005, 1, t, GameOverSeaCenterUI.this.mXC, null);
            AppMethodBeat.o(112131);
        }
    };
    private GameCenterListView nlA;
    private g nlB;
    private GameInfoViewForeign nlC;
    private GameMessageBubbleView nlD;
    private GameInstalledView nlE;
    private View nlF;
    private TextView nlG;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameOverSeaCenterUI() {
        AppMethodBeat.i(112135);
        AppMethodBeat.o(112135);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(112136);
        super.onCreate(bundle);
        ab.i("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI create");
        g.Rg().a(2855, (f) this);
        initView();
        c.aNS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(112129);
                byte[] NK = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCZ().NK("pb_over_sea");
                if (NK == null) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(112126);
                            if (GameOverSeaCenterUI.this.isFinishing()) {
                                AppMethodBeat.o(112126);
                                return;
                            }
                            GameOverSeaCenterUI.this.lud = c.ej(GameOverSeaCenterUI.this);
                            GameOverSeaCenterUI.this.lud.show();
                            AppMethodBeat.o(112126);
                        }
                    });
                } else {
                    final af afVar = new af(NK);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(112127);
                            try {
                                GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, afVar, 1);
                                AppMethodBeat.o(112127);
                            } catch (Exception e) {
                                ab.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", e.getMessage());
                                GameOverSeaCenterUI.this.finish();
                                AppMethodBeat.o(112127);
                            }
                        }
                    });
                }
                ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCV().init(GameOverSeaCenterUI.this);
                c.ab(e.bDR());
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(112128);
                        GameOverSeaCenterUI.this.nlE.gO(true);
                        AppMethodBeat.o(112128);
                    }
                });
                g.Rg().a(new ap(aa.dor(), e.bDR(), GameOverSeaCenterUI.this.nfw, GameOverSeaCenterUI.this.nfx, GameOverSeaCenterUI.this.nfy, GameOverSeaCenterUI.this.nfv), 0);
                e.bDW();
                com.tencent.mm.plugin.game.f.a.a.nnu.bFC();
                AppMethodBeat.o(112129);
            }
        });
        AppMethodBeat.o(112136);
    }

    public void onResume() {
        AppMethodBeat.i(112137);
        super.onResume();
        if (!this.exX) {
            if (this.nfv) {
                this.nlD.bFu();
            }
            this.nlC.bFo();
        }
        this.exX = false;
        AppMethodBeat.o(112137);
    }

    public void onDestroy() {
        AppMethodBeat.i(112138);
        ab.i("MicroMsg.GameOverSeaCenterUI", "onDestroy");
        super.onDestroy();
        com.tencent.mm.plugin.game.f.a.a.nnu.clearCache();
        g.Rg().b(2855, (f) this);
        ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCV().clearCache();
        AppMethodBeat.o(112138);
    }

    public final void initView() {
        AppMethodBeat.i(112139);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(112125);
                GameOverSeaCenterUI.this.finish();
                AppMethodBeat.o(112125);
                return true;
            }
        });
        setMMTitle((int) R.string.c8c);
        bFx();
        AppMethodBeat.o(112139);
    }

    private void bFx() {
        AppMethodBeat.i(112140);
        this.nlA = (GameCenterListView) findViewById(R.id.c26);
        this.nlA.setOnItemClickListener(this.neZ);
        this.neZ.setSourceScene(this.mXC);
        this.nlB = new g(this);
        this.nlB.setSourceScene(this.mXC);
        LayoutInflater layoutInflater = (LayoutInflater) this.mController.ylL.getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(R.layout.a30, this.nlA, false);
        this.nlC = (GameInfoViewForeign) inflate.findViewById(R.id.c2z);
        this.nlA.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.layout.a2p, this.nlA, false);
        this.nlD = (GameMessageBubbleView) inflate.findViewById(R.id.c1e);
        this.nlA.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.layout.a31, this.nlA, false);
        this.nlE = (GameInstalledView) inflate.findViewById(R.id.c33);
        this.nlA.addHeaderView(inflate);
        View inflate2 = layoutInflater.inflate(R.layout.a2u, this.nlA, false);
        this.nlA.addFooterView(inflate2);
        this.nlF = inflate2.findViewById(R.id.c29);
        this.nlF.setOnClickListener(this.nkd);
        this.nlG = (TextView) inflate2.findViewById(R.id.c2_);
        this.nlA.setAdapter(this.nlB);
        AppMethodBeat.o(112140);
    }

    public final int getLayoutId() {
        return R.layout.a2s;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(112141);
        ab.i("MicroMsg.GameOverSeaCenterUI", "errType: %d errCode: %d, scene: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(mVar.hashCode()));
        if (i == 0 && i2 == 0) {
            switch (mVar.getType()) {
                case 2855:
                    final long currentTimeMillis = System.currentTimeMillis();
                    final com.tencent.mm.bt.a aVar = ((ap) mVar).lty.fsH.fsP;
                    c.aNS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(112134);
                            if (aVar == null) {
                                GameOverSeaCenterUI.this.mYh = new bk();
                            } else {
                                GameOverSeaCenterUI.this.mYh = (bk) aVar;
                            }
                            final af afVar = new af(aVar);
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(112133);
                                    try {
                                        GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, afVar, 2);
                                    } catch (Exception e) {
                                        ab.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", e.getMessage());
                                        GameOverSeaCenterUI.this.finish();
                                    }
                                    if (GameOverSeaCenterUI.this.lud != null) {
                                        GameOverSeaCenterUI.this.lud.dismiss();
                                    }
                                    ab.i("MicroMsg.GameOverSeaCenterUI", "Server data parsing time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    AppMethodBeat.o(112133);
                                }
                            });
                            AppMethodBeat.o(112134);
                        }
                    });
                    break;
            }
            AppMethodBeat.o(112141);
            return;
        }
        if (!com.tencent.mm.plugin.game.b.a.gkF.a((Context) this, i, i2, str)) {
            Toast.makeText(this, getString(R.string.c6n, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.lud != null) {
            this.lud.cancel();
        }
        AppMethodBeat.o(112141);
    }

    static /* synthetic */ void a(GameOverSeaCenterUI gameOverSeaCenterUI, af afVar, int i) {
        AppMethodBeat.i(112142);
        if (gameOverSeaCenterUI.isFinishing()) {
            ab.w("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI hasFinished");
            AppMethodBeat.o(112142);
        } else if (afVar == null) {
            ab.e("MicroMsg.GameOverSeaCenterUI", "Null data");
            AppMethodBeat.o(112142);
        } else {
            cb cbVar;
            LinkedList linkedList;
            ci ciVar;
            if (afVar == null || afVar.bES() == null) {
                gameOverSeaCenterUI.nhS = "";
            } else {
                gameOverSeaCenterUI.nhS = afVar.bES().mZj;
            }
            if (bo.isNullOrNil(gameOverSeaCenterUI.nhS)) {
                if (gameOverSeaCenterUI.nhR) {
                    gameOverSeaCenterUI.removeOptionMenu(0);
                    gameOverSeaCenterUI.nhR = false;
                }
            } else if (!gameOverSeaCenterUI.nhR) {
                gameOverSeaCenterUI.addIconOptionMenu(0, R.raw.actionbar_setting_icon, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(112132);
                        b.a(GameOverSeaCenterUI.this.mController.ylL, 10, 1008, 1, c.ax(GameOverSeaCenterUI.this.mController.ylL, GameOverSeaCenterUI.this.nhS), GameOverSeaCenterUI.this.mXC, null);
                        AppMethodBeat.o(112132);
                        return true;
                    }
                });
                gameOverSeaCenterUI.nhR = true;
            }
            if (afVar.mYh == null || afVar.mYh.ncj == null) {
                cbVar = null;
            } else {
                cbVar = afVar.mYh.ncj.naS;
            }
            if (cbVar != null) {
                gameOverSeaCenterUI.nlC.setSourceScene(gameOverSeaCenterUI.mXC);
                gameOverSeaCenterUI.nlC.setVisibility(0);
            } else {
                gameOverSeaCenterUI.nlC.setVisibility(8);
            }
            gameOverSeaCenterUI.nlE.setSourceScene(gameOverSeaCenterUI.mXC);
            gameOverSeaCenterUI.nlE.setVersionCodes(afVar.mYk);
            GameInstalledView gameInstalledView = gameOverSeaCenterUI.nlE;
            GameInstalledView.a aVar = new GameInstalledView.a();
            if (!(afVar.mYh.ncl == null || afVar.mYh.ncl.ncQ == null)) {
                aVar.iconUrl = afVar.mYh.ncl.ncQ.mZs;
                aVar.title = afVar.mYh.ncl.ncQ.Title;
                aVar.hAh = afVar.mYh.ncl.ncQ.mZm;
            }
            gameInstalledView.setMoreGameInfo(aVar);
            GameInstalledView gameInstalledView2 = gameOverSeaCenterUI.nlE;
            LinkedList linkedList2 = new LinkedList();
            if (afVar.mYh.ncl == null || afVar.mYh.ncl.ncP == null) {
                linkedList = linkedList2;
            } else {
                Iterator it = afVar.mYh.ncl.ncP.iterator();
                while (it.hasNext()) {
                    cd cdVar = (cd) it.next();
                    if (cdVar != null) {
                        com.tencent.mm.plugin.game.model.c a = x.a(cdVar.mZk);
                        if (a != null) {
                            a.ij(cdVar.ncR);
                            linkedList2.addFirst(a);
                        }
                    }
                }
                linkedList = linkedList2;
            }
            gameInstalledView2.setInstalledGameInfo(linkedList);
            gameOverSeaCenterUI.nlE.gO(true);
            if (gameOverSeaCenterUI.nfv) {
                gameOverSeaCenterUI.nlD.bFu();
            }
            if (afVar.mYh != null) {
                ciVar = afVar.mYh.ncm;
            } else {
                ciVar = null;
            }
            if (ciVar == null || bo.isNullOrNil(ciVar.Desc) || bo.isNullOrNil(ciVar.mZj)) {
                gameOverSeaCenterUI.nlF.setVisibility(8);
            } else {
                gameOverSeaCenterUI.nlF.setVisibility(0);
                gameOverSeaCenterUI.nlG.setText(ciVar.Desc);
                gameOverSeaCenterUI.nlF.setTag(ciVar.mZj);
                gameOverSeaCenterUI.nlF.setOnClickListener(gameOverSeaCenterUI.nkd);
            }
            gameOverSeaCenterUI.nlB.wG(i);
            gameOverSeaCenterUI.nlB.Z(afVar.mYj);
            if (i == 2) {
                c.aNS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(112130);
                        ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCZ().b("pb_over_sea", GameOverSeaCenterUI.this.mYh);
                        AppMethodBeat.o(112130);
                    }
                });
            }
            AppMethodBeat.o(112142);
        }
    }
}
