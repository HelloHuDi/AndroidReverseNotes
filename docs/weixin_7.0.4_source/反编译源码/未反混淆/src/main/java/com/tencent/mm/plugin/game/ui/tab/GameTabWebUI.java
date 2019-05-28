package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class GameTabWebUI extends GameWebViewUI {
    private Activity activity;
    private BroadcastReceiver nnj = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(112262);
            if (!(intent == null || !"com.tencent.mm.ACTION_EXIT".equals(intent.getAction()) || GameTabWebUI.this.activity == null || GameTabWebUI.this.activity.isFinishing())) {
                ab.i("MicroMsg.GameTabWebUI", "%s exit!", GameTabWebUI.this.activity.getClass().getSimpleName());
                GameTabWebUI.this.activity.finish();
            }
            AppMethodBeat.o(112262);
        }
    };
    private String nnm;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameTabWebUI() {
        AppMethodBeat.i(112263);
        AppMethodBeat.o(112263);
    }

    static /* synthetic */ void a(GameTabWebUI gameTabWebUI) {
        AppMethodBeat.i(112270);
        gameTabWebUI.goBack();
        AppMethodBeat.o(112270);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(112264);
        super.onCreate(bundle);
        ab.i("MicroMsg.GameTabWebUI", "%s create", getClass().getSimpleName());
        this.activity = this;
        GameTabData gameTabData = (GameTabData) getIntent().getParcelableExtra("tab_data");
        this.nnm = getIntent().getStringExtra("tab_key");
        GameTabWidget gameTabWidget = new GameTabWidget(this);
        a aVar = new a(this);
        gameTabWidget.setAdapter(aVar);
        aVar.a(gameTabData, this.nnm);
        ((LinearLayout) findViewById(R.id.bhl)).addView(gameTabWidget);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_EXIT");
        registerReceiver(this.nnj, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(112261);
                GameTabWebUI.a(GameTabWebUI.this);
                AppMethodBeat.o(112261);
                return true;
            }
        });
        AppMethodBeat.o(112264);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(112265);
        super.onNewIntent(intent);
        if (intent == null) {
            AppMethodBeat.o(112265);
            return;
        }
        setIntent(intent);
        if (!bo.nullAsNil(this.nnm).equals(intent.getStringExtra("tab_key"))) {
            ab.i("MicroMsg.GameTabWebUI", "reload %s", this.activity.getClass().getSimpleName());
            finish();
            startActivity(intent);
        }
        overridePendingTransition(R.anim.bi, R.anim.bi);
        AppMethodBeat.o(112265);
    }

    public void onDestroy() {
        AppMethodBeat.i(112266);
        super.onDestroy();
        unregisterReceiver(this.nnj);
        AppMethodBeat.o(112266);
    }

    public void onBackPressed() {
        AppMethodBeat.i(112267);
        super.onBackPressed();
        goBack();
        AppMethodBeat.o(112267);
    }

    private void goBack() {
        AppMethodBeat.i(112268);
        ab.i("MicroMsg.GameTabWebUI", "%s goBack!", this.activity.getClass().getSimpleName());
        bFA();
        sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), WXApp.WXAPP_BROADCAST_PERMISSION);
        AppMethodBeat.o(112268);
    }

    private void bFA() {
        AppMethodBeat.i(112269);
        if (bo.nullAsNil(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            d.f(this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(R.anim.db, R.anim.dg);
            ab.i("MicroMsg.GameTabWebUI", "back to FindMoreFriendsUI.");
        }
        AppMethodBeat.o(112269);
    }
}
