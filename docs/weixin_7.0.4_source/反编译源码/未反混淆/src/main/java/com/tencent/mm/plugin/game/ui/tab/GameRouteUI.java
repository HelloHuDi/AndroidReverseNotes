package com.tencent.mm.plugin.game.ui.tab;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.bg;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@a(19)
public class GameRouteUI extends GameCenterActivity implements f {
    private int mXC;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(GameRouteUI gameRouteUI) {
        AppMethodBeat.i(112230);
        gameRouteUI.exit();
        AppMethodBeat.o(112230);
    }

    static /* synthetic */ void a(GameRouteUI gameRouteUI, List list) {
        AppMethodBeat.i(112231);
        gameRouteUI.c(list, false);
        AppMethodBeat.o(112231);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(112222);
        super.onCreate(bundle);
        initView();
        this.mXC = getIntent().getIntExtra("game_report_from_scene", 0);
        bg bFz = bFz();
        if (bFz == null || bo.ek(bFz.naO)) {
            g.Rg().a(2641, (f) this);
            g.Rg().a(new aj(), 0);
            AppMethodBeat.o(112222);
            return;
        }
        ab.i("MicroMsg.GameRouteUI", "use cache data");
        aj.updateData();
        boolean booleanExtra = getIntent().getBooleanExtra("switch_country_no_anim", false);
        getIntent().removeExtra("switch_country_no_anim");
        LinkedList linkedList = bFz.naO;
        if (!booleanExtra) {
            z = true;
        }
        c(linkedList, z);
        AppMethodBeat.o(112222);
    }

    public final int getLayoutId() {
        return R.layout.a5j;
    }

    public final void initView() {
        AppMethodBeat.i(112223);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(112220);
                GameRouteUI.a(GameRouteUI.this);
                AppMethodBeat.o(112220);
                return true;
            }
        });
        setMMTitle((int) R.string.c8c);
        AppMethodBeat.o(112223);
    }

    public void onDestroy() {
        AppMethodBeat.i(112224);
        g.Rg().b(2641, (f) this);
        super.onDestroy();
        AppMethodBeat.o(112224);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(112225);
        if (i == 0 && i2 == 0) {
            ab.i("MicroMsg.GameRouteUI", "pull gameIndexTabNav data success");
            final bg bET = ((aj) mVar).bET();
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(112221);
                    aj.a(bET);
                    if (bET == null || bo.ek(bET.naO)) {
                        ab.e("MicroMsg.GameRouteUI", "get GameIndex4TabNavData err");
                        GameRouteUI.a(GameRouteUI.this);
                        AppMethodBeat.o(112221);
                        return;
                    }
                    GameRouteUI.a(GameRouteUI.this, bET.naO);
                    AppMethodBeat.o(112221);
                }
            });
            AppMethodBeat.o(112225);
            return;
        }
        ab.i("MicroMsg.GameRouteUI", "pull gameIndexTabNav data fail");
        exit();
        AppMethodBeat.o(112225);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(112226);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            exit();
            AppMethodBeat.o(112226);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(112226);
        return onKeyDown;
    }

    public final boolean bFe() {
        return false;
    }

    public final int bFf() {
        return 0;
    }

    public final int bFg() {
        return 0;
    }

    public final int bFh() {
        return 0;
    }

    private void exit() {
        AppMethodBeat.i(112227);
        if (!(isFinishing() || isDestroyed())) {
            finish();
            overridePendingTransition(MMFragmentActivity.a.yne, MMFragmentActivity.a.ynf);
        }
        AppMethodBeat.o(112227);
    }

    private void c(List<com.tencent.mm.plugin.game.d.al> list, boolean z) {
        AppMethodBeat.i(112228);
        if (isFinishing() || isDestroyed()) {
            AppMethodBeat.o(112228);
            return;
        }
        GameTabData cc = GameTabData.cc(list);
        if (cc == null || bo.ek(cc.getItemList())) {
            ab.e("MicroMsg.GameRouteUI", "game tab data is null");
            exit();
            AppMethodBeat.o(112228);
            return;
        }
        List itemList = cc.getItemList();
        TabItem tabItem = null;
        int i = 0;
        while (i < itemList.size()) {
            TabItem tabItem2;
            TabItem tabItem3 = (TabItem) itemList.get(i);
            if (tabItem3 != null) {
                if (tabItem3.mYq) {
                    tabItem2 = tabItem3;
                } else {
                    tabItem2 = tabItem;
                }
                com.tencent.mm.plugin.game.e.a.a(this, 18, tabItem3.cKG, tabItem3.mYy, null, this.mXC, com.tencent.mm.plugin.game.e.a.kY(tabItem3.mVB));
            } else {
                tabItem2 = tabItem;
            }
            i++;
            tabItem = tabItem2;
        }
        if (tabItem == null) {
            tabItem = (TabItem) itemList.get(0);
        }
        if (tabItem == null) {
            ab.e("MicroMsg.GameRouteUI", "game tab entry item is null");
            exit();
            AppMethodBeat.o(112228);
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putParcelable("tab_data", cc);
        getIntent().putExtras(extras);
        GameTabWidget.a(this, tabItem, z, true, true);
        AppMethodBeat.o(112228);
    }

    private static bg bFz() {
        AppMethodBeat.i(112229);
        byte[] NK = ((c) g.K(c.class)).bCZ().NK("game_index4_tab_nav");
        if (bo.cb(NK)) {
            AppMethodBeat.o(112229);
            return null;
        }
        bg bgVar;
        try {
            bgVar = new bg();
            try {
                bgVar.parseFrom(NK);
            } catch (IOException e) {
            }
        } catch (IOException e2) {
            bgVar = null;
        }
        AppMethodBeat.o(112229);
        return bgVar;
    }
}
