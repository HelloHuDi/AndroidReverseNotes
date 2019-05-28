package com.tencent.mm.plugin.game.ui.tab;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameTabBridgeUI extends GameCenterActivity {
    private BroadcastReceiver nnj = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(112240);
            if (!(intent == null || !"com.tencent.mm.ACTION_EXIT".equals(intent.getAction()) || GameTabBridgeUI.this == null || GameTabBridgeUI.this.isFinishing())) {
                ab.i("MicroMsg.GameTabBridgeUI", "GameTabBridgeUI exit!");
                GameTabBridgeUI.this.finish();
            }
            AppMethodBeat.o(112240);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameTabBridgeUI() {
        AppMethodBeat.i(112241);
        AppMethodBeat.o(112241);
    }

    static /* synthetic */ void a(GameTabBridgeUI gameTabBridgeUI) {
        AppMethodBeat.i(112249);
        gameTabBridgeUI.goBack();
        AppMethodBeat.o(112249);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(112242);
        super.onCreate(bundle);
        ab.i("MicroMsg.GameTabBridgeUI", "%s create", getClass().getSimpleName());
        GameTabWidget.nnp = hashCode();
        initView();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_EXIT");
        registerReceiver(this.nnj, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
        final Intent intent = getIntent();
        GameTabData gameTabData = (GameTabData) intent.getParcelableExtra("tab_data");
        String stringExtra = intent.getStringExtra("tab_key");
        GameTabWidget gameTabWidget = (GameTabWidget) findViewById(R.id.c0k);
        a aVar = new a(this);
        gameTabWidget.setAdapter(aVar);
        aVar.a(gameTabData, stringExtra);
        intent.setComponent((ComponentName) intent.getParcelableExtra("next_tab_component"));
        final long currentTimeMillis = System.currentTimeMillis();
        ToolsProcessIPCService.a(null, GameTabWidget.a.class, new c<Bundle>() {
            public final /* synthetic */ void ao(Object obj) {
                AppMethodBeat.i(112238);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(112237);
                        ab.i("MicroMsg.GameTabBridgeUI", "load tools process, web page load time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        if (GameTabWidget.nnp == GameTabBridgeUI.this.hashCode()) {
                            GameTabWidget.a(GameTabBridgeUI.this, intent, false, true, true, false);
                            AppMethodBeat.o(112237);
                            return;
                        }
                        ab.i("MicroMsg.GameTabBridgeUI", "GameTabWidget.mHashCode(%d) != hashCode(%d), dont need turn page!", Integer.valueOf(GameTabWidget.nnp), Integer.valueOf(GameTabBridgeUI.this.hashCode()));
                        AppMethodBeat.o(112237);
                    }
                });
                AppMethodBeat.o(112238);
            }
        });
        AppMethodBeat.o(112242);
    }

    public final void initView() {
        AppMethodBeat.i(112243);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(112239);
                GameTabBridgeUI.a(GameTabBridgeUI.this);
                AppMethodBeat.o(112239);
                return true;
            }
        });
        setMMTitle((int) R.string.c8c);
        AppMethodBeat.o(112243);
    }

    public void onResume() {
        AppMethodBeat.i(112244);
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(112244);
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
        return R.layout.a2d;
    }

    public void onDestroy() {
        AppMethodBeat.i(112245);
        super.onDestroy();
        unregisterReceiver(this.nnj);
        AppMethodBeat.o(112245);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(112246);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(112246);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(112246);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(112247);
        ab.i("MicroMsg.GameTabBridgeUI", "GameTabHomeUI goBack!");
        bFA();
        sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), WXApp.WXAPP_BROADCAST_PERMISSION);
        AppMethodBeat.o(112247);
    }

    private void bFA() {
        AppMethodBeat.i(112248);
        if (bo.nullAsNil(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            d.f(this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(R.anim.db, R.anim.dg);
            ab.i("MicroMsg.GameTabBridgeUI", "back to FindMoreFriendsUI");
        }
        AppMethodBeat.o(112248);
    }
}
