package com.tencent.p177mm.plugin.game.p433ui.tab;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.game.model.C6936aj;
import com.tencent.p177mm.plugin.game.model.GameTabData;
import com.tencent.p177mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p433ui.GameCenterActivity;
import com.tencent.p177mm.plugin.game.p731d.C12111al;
import com.tencent.p177mm.plugin.game.p731d.C12114bg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.game.ui.tab.GameRouteUI */
public class GameRouteUI extends GameCenterActivity implements C1202f {
    private int mXC;

    /* renamed from: com.tencent.mm.plugin.game.ui.tab.GameRouteUI$1 */
    class C432101 implements OnMenuItemClickListener {
        C432101() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(112220);
            GameRouteUI.m76847a(GameRouteUI.this);
            AppMethodBeat.m2505o(112220);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m76847a(GameRouteUI gameRouteUI) {
        AppMethodBeat.m2504i(112230);
        gameRouteUI.exit();
        AppMethodBeat.m2505o(112230);
    }

    /* renamed from: a */
    static /* synthetic */ void m76848a(GameRouteUI gameRouteUI, List list) {
        AppMethodBeat.m2504i(112231);
        gameRouteUI.m76849c(list, false);
        AppMethodBeat.m2505o(112231);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.m2504i(112222);
        super.onCreate(bundle);
        initView();
        this.mXC = getIntent().getIntExtra("game_report_from_scene", 0);
        C12114bg bFz = GameRouteUI.bFz();
        if (bFz == null || C5046bo.m7548ek(bFz.naO)) {
            C1720g.m3540Rg().mo14539a(2641, (C1202f) this);
            C1720g.m3540Rg().mo14541a(new C6936aj(), 0);
            AppMethodBeat.m2505o(112222);
            return;
        }
        C4990ab.m7416i("MicroMsg.GameRouteUI", "use cache data");
        C6936aj.updateData();
        boolean booleanExtra = getIntent().getBooleanExtra("switch_country_no_anim", false);
        getIntent().removeExtra("switch_country_no_anim");
        LinkedList linkedList = bFz.naO;
        if (!booleanExtra) {
            z = true;
        }
        m76849c(linkedList, z);
        AppMethodBeat.m2505o(112222);
    }

    public final int getLayoutId() {
        return 2130969773;
    }

    public final void initView() {
        AppMethodBeat.m2504i(112223);
        setBackBtn(new C432101());
        setMMTitle((int) C25738R.string.c8c);
        AppMethodBeat.m2505o(112223);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(112224);
        C1720g.m3540Rg().mo14546b(2641, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(112224);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(112225);
        if (i == 0 && i2 == 0) {
            C4990ab.m7416i("MicroMsg.GameRouteUI", "pull gameIndexTabNav data success");
            final C12114bg bET = ((C6936aj) c1207m).bET();
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(112221);
                    C6936aj.m11461a(bET);
                    if (bET == null || C5046bo.m7548ek(bET.naO)) {
                        C4990ab.m7412e("MicroMsg.GameRouteUI", "get GameIndex4TabNavData err");
                        GameRouteUI.m76847a(GameRouteUI.this);
                        AppMethodBeat.m2505o(112221);
                        return;
                    }
                    GameRouteUI.m76848a(GameRouteUI.this, bET.naO);
                    AppMethodBeat.m2505o(112221);
                }
            });
            AppMethodBeat.m2505o(112225);
            return;
        }
        C4990ab.m7416i("MicroMsg.GameRouteUI", "pull gameIndexTabNav data fail");
        exit();
        AppMethodBeat.m2505o(112225);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(112226);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            exit();
            AppMethodBeat.m2505o(112226);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(112226);
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
        AppMethodBeat.m2504i(112227);
        if (!(isFinishing() || isDestroyed())) {
            finish();
            overridePendingTransition(C5206a.yne, C5206a.ynf);
        }
        AppMethodBeat.m2505o(112227);
    }

    /* renamed from: c */
    private void m76849c(List<C12111al> list, boolean z) {
        AppMethodBeat.m2504i(112228);
        if (isFinishing() || isDestroyed()) {
            AppMethodBeat.m2505o(112228);
            return;
        }
        GameTabData cc = GameTabData.m85472cc(list);
        if (cc == null || C5046bo.m7548ek(cc.getItemList())) {
            C4990ab.m7412e("MicroMsg.GameRouteUI", "game tab data is null");
            exit();
            AppMethodBeat.m2505o(112228);
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
                C34276a.m56205a(this, 18, tabItem3.cKG, tabItem3.mYy, null, this.mXC, C34276a.m56208kY(tabItem3.mVB));
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
            C4990ab.m7412e("MicroMsg.GameRouteUI", "game tab entry item is null");
            exit();
            AppMethodBeat.m2505o(112228);
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putParcelable("tab_data", cc);
        getIntent().putExtras(extras);
        GameTabWidget.m76851a(this, tabItem, z, true, true);
        AppMethodBeat.m2505o(112228);
    }

    private static C12114bg bFz() {
        AppMethodBeat.m2504i(112229);
        byte[] NK = ((C45983c) C1720g.m3528K(C45983c.class)).bCZ().mo54825NK("game_index4_tab_nav");
        if (C5046bo.m7540cb(NK)) {
            AppMethodBeat.m2505o(112229);
            return null;
        }
        C12114bg c12114bg;
        try {
            c12114bg = new C12114bg();
            try {
                c12114bg.parseFrom(NK);
            } catch (IOException e) {
            }
        } catch (IOException e2) {
            c12114bg = null;
        }
        AppMethodBeat.m2505o(112229);
        return c12114bg;
    }
}
