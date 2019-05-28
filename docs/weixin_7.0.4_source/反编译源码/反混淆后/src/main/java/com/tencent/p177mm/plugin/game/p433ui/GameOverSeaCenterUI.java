package com.tencent.p177mm.plugin.game.p433ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C34296ap;
import com.tencent.p177mm.plugin.game.model.C39211a;
import com.tencent.p177mm.plugin.game.model.C39211a.C3243a;
import com.tencent.p177mm.plugin.game.model.C39216x;
import com.tencent.p177mm.plugin.game.model.C41286af;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p1649b.C45984a;
import com.tencent.p177mm.plugin.game.p428f.C46000a.C3220a;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p433ui.GameInstalledView.C12185a;
import com.tencent.p177mm.plugin.game.p731d.C28189cd;
import com.tencent.p177mm.plugin.game.p731d.C34271cb;
import com.tencent.p177mm.plugin.game.p731d.C39189bk;
import com.tencent.p177mm.plugin.game.p731d.C43167ci;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI */
public class GameOverSeaCenterUI extends GameCenterBaseUI implements C1202f {
    private boolean exX = true;
    private Dialog lud;
    private C39189bk mYh;
    C21031k neZ = new C21031k();
    private boolean nhR;
    private String nhS = "";
    private OnClickListener nkd = new C343164();
    private GameCenterListView nlA;
    private C39236g nlB;
    private GameInfoViewForeign nlC;
    private GameMessageBubbleView nlD;
    private GameInstalledView nlE;
    private View nlF;
    private TextView nlG;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI$5 */
    class C210265 implements OnMenuItemClickListener {
        C210265() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(112132);
            C34277b.m56209a(GameOverSeaCenterUI.this.mController.ylL, 10, 1008, 1, C46001c.m85455ax(GameOverSeaCenterUI.this.mController.ylL, GameOverSeaCenterUI.this.nhS), GameOverSeaCenterUI.this.mXC, null);
            AppMethodBeat.m2505o(112132);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI$3 */
    class C343123 implements Runnable {
        C343123() {
        }

        public final void run() {
            AppMethodBeat.m2504i(112130);
            ((C45983c) C1720g.m3528K(C45983c.class)).bCZ().mo54826b("pb_over_sea", GameOverSeaCenterUI.this.mYh);
            AppMethodBeat.m2505o(112130);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI$1 */
    class C343131 implements OnMenuItemClickListener {
        C343131() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(112125);
            GameOverSeaCenterUI.this.finish();
            AppMethodBeat.m2505o(112125);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI$2 */
    class C343142 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI$2$1 */
        class C282551 implements Runnable {
            C282551() {
            }

            public final void run() {
                AppMethodBeat.m2504i(112126);
                if (GameOverSeaCenterUI.this.isFinishing()) {
                    AppMethodBeat.m2505o(112126);
                    return;
                }
                GameOverSeaCenterUI.this.lud = C46001c.m85459ej(GameOverSeaCenterUI.this);
                GameOverSeaCenterUI.this.lud.show();
                AppMethodBeat.m2505o(112126);
            }
        }

        /* renamed from: com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI$2$3 */
        class C343153 implements Runnable {
            C343153() {
            }

            public final void run() {
                AppMethodBeat.m2504i(112128);
                GameOverSeaCenterUI.this.nlE.mo68693gO(true);
                AppMethodBeat.m2505o(112128);
            }
        }

        C343142() {
        }

        public final void run() {
            AppMethodBeat.m2504i(112129);
            byte[] NK = ((C45983c) C1720g.m3528K(C45983c.class)).bCZ().mo54825NK("pb_over_sea");
            if (NK == null) {
                C5004al.m7441d(new C282551());
            } else {
                final C41286af c41286af = new C41286af(NK);
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(112127);
                        try {
                            GameOverSeaCenterUI.m56257a(GameOverSeaCenterUI.this, c41286af, 1);
                            AppMethodBeat.m2505o(112127);
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", e.getMessage());
                            GameOverSeaCenterUI.this.finish();
                            AppMethodBeat.m2505o(112127);
                        }
                    }
                });
            }
            ((C43156b) C1720g.m3528K(C43156b.class)).bCV().init(GameOverSeaCenterUI.this);
            C46001c.m85454ab(C20993e.bDR());
            C5004al.m7441d(new C343153());
            C1720g.m3540Rg().mo14541a(new C34296ap(C4988aa.dor(), C20993e.bDR(), GameOverSeaCenterUI.this.nfw, GameOverSeaCenterUI.this.nfx, GameOverSeaCenterUI.this.nfy, GameOverSeaCenterUI.this.nfv), 0);
            C20993e.bDW();
            C3220a.nnu.bFC();
            AppMethodBeat.m2505o(112129);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI$4 */
    class C343164 implements OnClickListener {
        C343164() {
        }

        public final void onClick(View view) {
            int t;
            AppMethodBeat.m2504i(112131);
            C3243a bDM = C39211a.bDM();
            if (bDM.bJt == 2) {
                t = C46001c.m85464t(GameOverSeaCenterUI.this.mController.ylL, bDM.url, "game_center_library");
            } else {
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof String) || C5046bo.isNullOrNil((String) tag)) {
                    Intent intent = new Intent(GameOverSeaCenterUI.this.mController.ylL, GameLibraryUI.class);
                    intent.putExtra("game_report_from_scene", 1005);
                    GameOverSeaCenterUI.this.startActivity(intent);
                    t = 6;
                } else {
                    t = C46001c.m85464t(GameOverSeaCenterUI.this.mController.ylL, (String) tag, "game_center_library");
                }
            }
            C34277b.m56209a(GameOverSeaCenterUI.this.mController.ylL, 10, 1005, 1, t, GameOverSeaCenterUI.this.mXC, null);
            AppMethodBeat.m2505o(112131);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public GameOverSeaCenterUI() {
        AppMethodBeat.m2504i(112135);
        AppMethodBeat.m2505o(112135);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(112136);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI create");
        C1720g.m3540Rg().mo14539a(2855, (C1202f) this);
        initView();
        C46001c.aNS().mo10302aa(new C343142());
        AppMethodBeat.m2505o(112136);
    }

    public void onResume() {
        AppMethodBeat.m2504i(112137);
        super.onResume();
        if (!this.exX) {
            if (this.nfv) {
                this.nlD.bFu();
            }
            this.nlC.bFo();
        }
        this.exX = false;
        AppMethodBeat.m2505o(112137);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(112138);
        C4990ab.m7416i("MicroMsg.GameOverSeaCenterUI", "onDestroy");
        super.onDestroy();
        C3220a.nnu.clearCache();
        C1720g.m3540Rg().mo14546b(2855, (C1202f) this);
        ((C43156b) C1720g.m3528K(C43156b.class)).bCV().clearCache();
        AppMethodBeat.m2505o(112138);
    }

    public final void initView() {
        AppMethodBeat.m2504i(112139);
        setBackBtn(new C343131());
        setMMTitle((int) C25738R.string.c8c);
        bFx();
        AppMethodBeat.m2505o(112139);
    }

    private void bFx() {
        AppMethodBeat.m2504i(112140);
        this.nlA = (GameCenterListView) findViewById(2131824361);
        this.nlA.setOnItemClickListener(this.neZ);
        this.neZ.setSourceScene(this.mXC);
        this.nlB = new C39236g(this);
        this.nlB.setSourceScene(this.mXC);
        LayoutInflater layoutInflater = (LayoutInflater) this.mController.ylL.getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(2130969679, this.nlA, false);
        this.nlC = (GameInfoViewForeign) inflate.findViewById(2131824391);
        this.nlA.addHeaderView(inflate);
        inflate = layoutInflater.inflate(2130969668, this.nlA, false);
        this.nlD = (GameMessageBubbleView) inflate.findViewById(2131824333);
        this.nlA.addHeaderView(inflate);
        inflate = layoutInflater.inflate(2130969680, this.nlA, false);
        this.nlE = (GameInstalledView) inflate.findViewById(2131824395);
        this.nlA.addHeaderView(inflate);
        View inflate2 = layoutInflater.inflate(2130969673, this.nlA, false);
        this.nlA.addFooterView(inflate2);
        this.nlF = inflate2.findViewById(2131824364);
        this.nlF.setOnClickListener(this.nkd);
        this.nlG = (TextView) inflate2.findViewById(2131824365);
        this.nlA.setAdapter(this.nlB);
        AppMethodBeat.m2505o(112140);
    }

    public final int getLayoutId() {
        return 2130969671;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(112141);
        C4990ab.m7417i("MicroMsg.GameOverSeaCenterUI", "errType: %d errCode: %d, scene: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(c1207m.hashCode()));
        if (i == 0 && i2 == 0) {
            switch (c1207m.getType()) {
                case 2855:
                    final long currentTimeMillis = System.currentTimeMillis();
                    final C1331a c1331a = ((C34296ap) c1207m).lty.fsH.fsP;
                    C46001c.aNS().mo10302aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(112134);
                            if (c1331a == null) {
                                GameOverSeaCenterUI.this.mYh = new C39189bk();
                            } else {
                                GameOverSeaCenterUI.this.mYh = (C39189bk) c1331a;
                            }
                            final C41286af c41286af = new C41286af(c1331a);
                            C5004al.m7441d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(112133);
                                    try {
                                        GameOverSeaCenterUI.m56257a(GameOverSeaCenterUI.this, c41286af, 2);
                                    } catch (Exception e) {
                                        C4990ab.m7413e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", e.getMessage());
                                        GameOverSeaCenterUI.this.finish();
                                    }
                                    if (GameOverSeaCenterUI.this.lud != null) {
                                        GameOverSeaCenterUI.this.lud.dismiss();
                                    }
                                    C4990ab.m7417i("MicroMsg.GameOverSeaCenterUI", "Server data parsing time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    AppMethodBeat.m2505o(112133);
                                }
                            });
                            AppMethodBeat.m2505o(112134);
                        }
                    });
                    break;
            }
            AppMethodBeat.m2505o(112141);
            return;
        }
        if (!C45984a.gkF.mo38859a((Context) this, i, i2, str)) {
            Toast.makeText(this, getString(C25738R.string.c6n, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.lud != null) {
            this.lud.cancel();
        }
        AppMethodBeat.m2505o(112141);
    }

    /* renamed from: a */
    static /* synthetic */ void m56257a(GameOverSeaCenterUI gameOverSeaCenterUI, C41286af c41286af, int i) {
        AppMethodBeat.m2504i(112142);
        if (gameOverSeaCenterUI.isFinishing()) {
            C4990ab.m7420w("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI hasFinished");
            AppMethodBeat.m2505o(112142);
        } else if (c41286af == null) {
            C4990ab.m7412e("MicroMsg.GameOverSeaCenterUI", "Null data");
            AppMethodBeat.m2505o(112142);
        } else {
            C34271cb c34271cb;
            LinkedList linkedList;
            C43167ci c43167ci;
            if (c41286af == null || c41286af.bES() == null) {
                gameOverSeaCenterUI.nhS = "";
            } else {
                gameOverSeaCenterUI.nhS = c41286af.bES().mZj;
            }
            if (C5046bo.isNullOrNil(gameOverSeaCenterUI.nhS)) {
                if (gameOverSeaCenterUI.nhR) {
                    gameOverSeaCenterUI.removeOptionMenu(0);
                    gameOverSeaCenterUI.nhR = false;
                }
            } else if (!gameOverSeaCenterUI.nhR) {
                gameOverSeaCenterUI.addIconOptionMenu(0, C1318a.actionbar_setting_icon, new C210265());
                gameOverSeaCenterUI.nhR = true;
            }
            if (c41286af.mYh == null || c41286af.mYh.ncj == null) {
                c34271cb = null;
            } else {
                c34271cb = c41286af.mYh.ncj.naS;
            }
            if (c34271cb != null) {
                gameOverSeaCenterUI.nlC.setSourceScene(gameOverSeaCenterUI.mXC);
                gameOverSeaCenterUI.nlC.setVisibility(0);
            } else {
                gameOverSeaCenterUI.nlC.setVisibility(8);
            }
            gameOverSeaCenterUI.nlE.setSourceScene(gameOverSeaCenterUI.mXC);
            gameOverSeaCenterUI.nlE.setVersionCodes(c41286af.mYk);
            GameInstalledView gameInstalledView = gameOverSeaCenterUI.nlE;
            C12185a c12185a = new C12185a();
            if (!(c41286af.mYh.ncl == null || c41286af.mYh.ncl.ncQ == null)) {
                c12185a.iconUrl = c41286af.mYh.ncl.ncQ.mZs;
                c12185a.title = c41286af.mYh.ncl.ncQ.Title;
                c12185a.hAh = c41286af.mYh.ncl.ncQ.mZm;
            }
            gameInstalledView.setMoreGameInfo(c12185a);
            GameInstalledView gameInstalledView2 = gameOverSeaCenterUI.nlE;
            LinkedList linkedList2 = new LinkedList();
            if (c41286af.mYh.ncl == null || c41286af.mYh.ncl.ncP == null) {
                linkedList = linkedList2;
            } else {
                Iterator it = c41286af.mYh.ncl.ncP.iterator();
                while (it.hasNext()) {
                    C28189cd c28189cd = (C28189cd) it.next();
                    if (c28189cd != null) {
                        C20992c a = C39216x.m66823a(c28189cd.mZk);
                        if (a != null) {
                            a.mo44078ij(c28189cd.ncR);
                            linkedList2.addFirst(a);
                        }
                    }
                }
                linkedList = linkedList2;
            }
            gameInstalledView2.setInstalledGameInfo(linkedList);
            gameOverSeaCenterUI.nlE.mo68693gO(true);
            if (gameOverSeaCenterUI.nfv) {
                gameOverSeaCenterUI.nlD.bFu();
            }
            if (c41286af.mYh != null) {
                c43167ci = c41286af.mYh.ncm;
            } else {
                c43167ci = null;
            }
            if (c43167ci == null || C5046bo.isNullOrNil(c43167ci.Desc) || C5046bo.isNullOrNil(c43167ci.mZj)) {
                gameOverSeaCenterUI.nlF.setVisibility(8);
            } else {
                gameOverSeaCenterUI.nlF.setVisibility(0);
                gameOverSeaCenterUI.nlG.setText(c43167ci.Desc);
                gameOverSeaCenterUI.nlF.setTag(c43167ci.mZj);
                gameOverSeaCenterUI.nlF.setOnClickListener(gameOverSeaCenterUI.nkd);
            }
            gameOverSeaCenterUI.nlB.mo62144wG(i);
            gameOverSeaCenterUI.nlB.mo24021Z(c41286af.mYj);
            if (i == 2) {
                C46001c.aNS().mo10302aa(new C343123());
            }
            AppMethodBeat.m2505o(112142);
        }
    }
}
