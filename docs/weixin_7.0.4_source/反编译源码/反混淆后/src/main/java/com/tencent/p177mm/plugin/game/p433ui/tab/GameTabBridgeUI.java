package com.tencent.p177mm.plugin.game.p433ui.tab;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.game.model.GameTabData;
import com.tencent.p177mm.plugin.game.p433ui.GameCenterActivity;
import com.tencent.p177mm.plugin.game.p433ui.tab.GameTabWidget.C21043a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.game.ui.tab.GameTabBridgeUI */
public class GameTabBridgeUI extends GameCenterActivity {
    private BroadcastReceiver nnj = new C210403();

    /* renamed from: com.tencent.mm.plugin.game.ui.tab.GameTabBridgeUI$2 */
    class C210392 implements OnMenuItemClickListener {
        C210392() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(112239);
            GameTabBridgeUI.m32341a(GameTabBridgeUI.this);
            AppMethodBeat.m2505o(112239);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.tab.GameTabBridgeUI$3 */
    class C210403 extends BroadcastReceiver {
        C210403() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(112240);
            if (!(intent == null || !"com.tencent.mm.ACTION_EXIT".equals(intent.getAction()) || GameTabBridgeUI.this == null || GameTabBridgeUI.this.isFinishing())) {
                C4990ab.m7416i("MicroMsg.GameTabBridgeUI", "GameTabBridgeUI exit!");
                GameTabBridgeUI.this.finish();
            }
            AppMethodBeat.m2505o(112240);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public GameTabBridgeUI() {
        AppMethodBeat.m2504i(112241);
        AppMethodBeat.m2505o(112241);
    }

    /* renamed from: a */
    static /* synthetic */ void m32341a(GameTabBridgeUI gameTabBridgeUI) {
        AppMethodBeat.m2504i(112249);
        gameTabBridgeUI.goBack();
        AppMethodBeat.m2505o(112249);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(112242);
        super.onCreate(bundle);
        C4990ab.m7417i("MicroMsg.GameTabBridgeUI", "%s create", getClass().getSimpleName());
        GameTabWidget.nnp = hashCode();
        initView();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_EXIT");
        registerReceiver(this.nnj, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
        final Intent intent = getIntent();
        GameTabData gameTabData = (GameTabData) intent.getParcelableExtra("tab_data");
        String stringExtra = intent.getStringExtra("tab_key");
        GameTabWidget gameTabWidget = (GameTabWidget) findViewById(2131824302);
        C39239a c39239a = new C39239a(this);
        gameTabWidget.setAdapter(c39239a);
        c39239a.mo62147a(gameTabData, stringExtra);
        intent.setComponent((ComponentName) intent.getParcelableExtra("next_tab_component"));
        final long currentTimeMillis = System.currentTimeMillis();
        ToolsProcessIPCService.m63913a(null, C21043a.class, new C18507c<Bundle>() {

            /* renamed from: com.tencent.mm.plugin.game.ui.tab.GameTabBridgeUI$1$1 */
            class C210421 implements Runnable {
                C210421() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(112237);
                    C4990ab.m7417i("MicroMsg.GameTabBridgeUI", "load tools process, web page load time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (GameTabWidget.nnp == GameTabBridgeUI.this.hashCode()) {
                        GameTabWidget.m76850a(GameTabBridgeUI.this, intent, false, true, true, false);
                        AppMethodBeat.m2505o(112237);
                        return;
                    }
                    C4990ab.m7417i("MicroMsg.GameTabBridgeUI", "GameTabWidget.mHashCode(%d) != hashCode(%d), dont need turn page!", Integer.valueOf(GameTabWidget.nnp), Integer.valueOf(GameTabBridgeUI.this.hashCode()));
                    AppMethodBeat.m2505o(112237);
                }
            }

            /* renamed from: ao */
            public final /* synthetic */ void mo5960ao(Object obj) {
                AppMethodBeat.m2504i(112238);
                C5004al.m7441d(new C210421());
                AppMethodBeat.m2505o(112238);
            }
        });
        AppMethodBeat.m2505o(112242);
    }

    public final void initView() {
        AppMethodBeat.m2504i(112243);
        setBackBtn(new C210392());
        setMMTitle((int) C25738R.string.c8c);
        AppMethodBeat.m2505o(112243);
    }

    public void onResume() {
        AppMethodBeat.m2504i(112244);
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.m2505o(112244);
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

    public final int getLayoutId() {
        return 2130969656;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(112245);
        super.onDestroy();
        unregisterReceiver(this.nnj);
        AppMethodBeat.m2505o(112245);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(112246);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.m2505o(112246);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(112246);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(112247);
        C4990ab.m7416i("MicroMsg.GameTabBridgeUI", "GameTabHomeUI goBack!");
        bFA();
        sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), WXApp.WXAPP_BROADCAST_PERMISSION);
        AppMethodBeat.m2505o(112247);
    }

    private void bFA() {
        AppMethodBeat.m2504i(112248);
        if (C5046bo.nullAsNil(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            C25985d.m41473f(this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(C25738R.anim.f8401db, C25738R.anim.f8404dg);
            C4990ab.m7416i("MicroMsg.GameTabBridgeUI", "back to FindMoreFriendsUI");
        }
        AppMethodBeat.m2505o(112248);
    }
}
