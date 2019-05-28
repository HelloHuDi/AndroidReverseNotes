package com.tencent.p177mm.plugin.game.p433ui.tab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.game.model.GameTabData;
import com.tencent.p177mm.plugin.game.p433ui.GameCenterUI5;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.tab.GameTabHomeUI */
public class GameTabHomeUI extends GameCenterUI5 {
    private BroadcastReceiver nnj = new C122112();
    public String nnm;

    /* renamed from: com.tencent.mm.plugin.game.ui.tab.GameTabHomeUI$1 */
    class C122101 implements OnMenuItemClickListener {
        C122101() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(112250);
            GameTabHomeUI.m44842a(GameTabHomeUI.this);
            AppMethodBeat.m2505o(112250);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.tab.GameTabHomeUI$2 */
    class C122112 extends BroadcastReceiver {
        C122112() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(112251);
            if (!(intent == null || !"com.tencent.mm.ACTION_EXIT".equals(intent.getAction()) || GameTabHomeUI.this == null || GameTabHomeUI.this.isFinishing())) {
                C4990ab.m7416i("MicroMsg.GameTabHomeUI", "GameTabHomeUI exit!");
                GameTabHomeUI.this.finish();
            }
            AppMethodBeat.m2505o(112251);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public GameTabHomeUI() {
        AppMethodBeat.m2504i(112252);
        AppMethodBeat.m2505o(112252);
    }

    /* renamed from: a */
    static /* synthetic */ void m44842a(GameTabHomeUI gameTabHomeUI) {
        AppMethodBeat.m2504i(112260);
        gameTabHomeUI.goBack();
        AppMethodBeat.m2505o(112260);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(112253);
        super.onCreate(bundle);
        C4990ab.m7417i("MicroMsg.GameTabHomeUI", "%s create", getClass().getSimpleName());
        GameTabData gameTabData = (GameTabData) getIntent().getParcelableExtra("tab_data");
        this.nnm = getIntent().getStringExtra("tab_key");
        GameTabWidget gameTabWidget = (GameTabWidget) findViewById(2131824302);
        C39239a c39239a = new C39239a(this);
        gameTabWidget.setAdapter(c39239a);
        c39239a.mo62147a(gameTabData, this.nnm);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_EXIT");
        registerReceiver(this.nnj, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
        setBackBtn(new C122101());
        AppMethodBeat.m2505o(112253);
    }

    public void onResume() {
        AppMethodBeat.m2504i(112254);
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.m2505o(112254);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(112255);
        super.onNewIntent(intent);
        if (intent == null) {
            AppMethodBeat.m2505o(112255);
            return;
        }
        setIntent(intent);
        if (!C5046bo.nullAsNil(this.nnm).equals(intent.getStringExtra("tab_key"))) {
            C4990ab.m7417i("MicroMsg.GameTabHomeUI", "reload %s. current_key:%s, next_key:%s", getClass().getSimpleName(), this.nnm, intent.getStringExtra("tab_key"));
            finish();
            startActivity(intent);
        }
        overridePendingTransition(C25738R.anim.f8344bi, C25738R.anim.f8344bi);
        AppMethodBeat.m2505o(112255);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(112256);
        super.onDestroy();
        unregisterReceiver(this.nnj);
        AppMethodBeat.m2505o(112256);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(112257);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.m2505o(112257);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(112257);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(112258);
        C4990ab.m7416i("MicroMsg.GameTabHomeUI", "GameTabHomeUI goBack!");
        bFA();
        sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), WXApp.WXAPP_BROADCAST_PERMISSION);
        AppMethodBeat.m2505o(112258);
    }

    private void bFA() {
        AppMethodBeat.m2504i(112259);
        if (C5046bo.nullAsNil(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            C25985d.m41473f(this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(C25738R.anim.f8401db, C25738R.anim.f8404dg);
            C4990ab.m7416i("MicroMsg.GameTabHomeUI", "back to FindMoreFriendsUI");
        }
        AppMethodBeat.m2505o(112259);
    }
}
