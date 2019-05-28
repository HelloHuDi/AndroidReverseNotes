package com.tencent.mm.plugin.game.ui.tab;

import android.content.BroadcastReceiver;
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
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterUI5;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class GameTabHomeUI extends GameCenterUI5 {
    private BroadcastReceiver nnj = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(112251);
            if (!(intent == null || !"com.tencent.mm.ACTION_EXIT".equals(intent.getAction()) || GameTabHomeUI.this == null || GameTabHomeUI.this.isFinishing())) {
                ab.i("MicroMsg.GameTabHomeUI", "GameTabHomeUI exit!");
                GameTabHomeUI.this.finish();
            }
            AppMethodBeat.o(112251);
        }
    };
    public String nnm;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameTabHomeUI() {
        AppMethodBeat.i(112252);
        AppMethodBeat.o(112252);
    }

    static /* synthetic */ void a(GameTabHomeUI gameTabHomeUI) {
        AppMethodBeat.i(112260);
        gameTabHomeUI.goBack();
        AppMethodBeat.o(112260);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(112253);
        super.onCreate(bundle);
        ab.i("MicroMsg.GameTabHomeUI", "%s create", getClass().getSimpleName());
        GameTabData gameTabData = (GameTabData) getIntent().getParcelableExtra("tab_data");
        this.nnm = getIntent().getStringExtra("tab_key");
        GameTabWidget gameTabWidget = (GameTabWidget) findViewById(R.id.c0k);
        a aVar = new a(this);
        gameTabWidget.setAdapter(aVar);
        aVar.a(gameTabData, this.nnm);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_EXIT");
        registerReceiver(this.nnj, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(112250);
                GameTabHomeUI.a(GameTabHomeUI.this);
                AppMethodBeat.o(112250);
                return true;
            }
        });
        AppMethodBeat.o(112253);
    }

    public void onResume() {
        AppMethodBeat.i(112254);
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(112254);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(112255);
        super.onNewIntent(intent);
        if (intent == null) {
            AppMethodBeat.o(112255);
            return;
        }
        setIntent(intent);
        if (!bo.nullAsNil(this.nnm).equals(intent.getStringExtra("tab_key"))) {
            ab.i("MicroMsg.GameTabHomeUI", "reload %s. current_key:%s, next_key:%s", getClass().getSimpleName(), this.nnm, intent.getStringExtra("tab_key"));
            finish();
            startActivity(intent);
        }
        overridePendingTransition(R.anim.bi, R.anim.bi);
        AppMethodBeat.o(112255);
    }

    public void onDestroy() {
        AppMethodBeat.i(112256);
        super.onDestroy();
        unregisterReceiver(this.nnj);
        AppMethodBeat.o(112256);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(112257);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(112257);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(112257);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(112258);
        ab.i("MicroMsg.GameTabHomeUI", "GameTabHomeUI goBack!");
        bFA();
        sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), WXApp.WXAPP_BROADCAST_PERMISSION);
        AppMethodBeat.o(112258);
    }

    private void bFA() {
        AppMethodBeat.i(112259);
        if (bo.nullAsNil(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            d.f(this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(R.anim.db, R.anim.dg);
            ab.i("MicroMsg.GameTabHomeUI", "back to FindMoreFriendsUI");
        }
        AppMethodBeat.o(112259);
    }
}
