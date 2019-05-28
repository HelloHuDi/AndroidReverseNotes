package com.tencent.p177mm.plugin.game.p433ui.tab;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.game.model.GameTabData;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.GameWebViewUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.tab.GameTabWebUI */
public class GameTabWebUI extends GameWebViewUI {
    private Activity activity;
    private BroadcastReceiver nnj = new C122132();
    private String nnm;

    /* renamed from: com.tencent.mm.plugin.game.ui.tab.GameTabWebUI$1 */
    class C122121 implements OnMenuItemClickListener {
        C122121() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(112261);
            GameTabWebUI.m20134a(GameTabWebUI.this);
            AppMethodBeat.m2505o(112261);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.tab.GameTabWebUI$2 */
    class C122132 extends BroadcastReceiver {
        C122132() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(112262);
            if (!(intent == null || !"com.tencent.mm.ACTION_EXIT".equals(intent.getAction()) || GameTabWebUI.this.activity == null || GameTabWebUI.this.activity.isFinishing())) {
                C4990ab.m7417i("MicroMsg.GameTabWebUI", "%s exit!", GameTabWebUI.this.activity.getClass().getSimpleName());
                GameTabWebUI.this.activity.finish();
            }
            AppMethodBeat.m2505o(112262);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public GameTabWebUI() {
        AppMethodBeat.m2504i(112263);
        AppMethodBeat.m2505o(112263);
    }

    /* renamed from: a */
    static /* synthetic */ void m20134a(GameTabWebUI gameTabWebUI) {
        AppMethodBeat.m2504i(112270);
        gameTabWebUI.goBack();
        AppMethodBeat.m2505o(112270);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(112264);
        super.onCreate(bundle);
        C4990ab.m7417i("MicroMsg.GameTabWebUI", "%s create", getClass().getSimpleName());
        this.activity = this;
        GameTabData gameTabData = (GameTabData) getIntent().getParcelableExtra("tab_data");
        this.nnm = getIntent().getStringExtra("tab_key");
        GameTabWidget gameTabWidget = new GameTabWidget(this);
        C39239a c39239a = new C39239a(this);
        gameTabWidget.setAdapter(c39239a);
        c39239a.mo62147a(gameTabData, this.nnm);
        ((LinearLayout) findViewById(2131823600)).addView(gameTabWidget);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_EXIT");
        registerReceiver(this.nnj, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
        setBackBtn(new C122121());
        AppMethodBeat.m2505o(112264);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(112265);
        super.onNewIntent(intent);
        if (intent == null) {
            AppMethodBeat.m2505o(112265);
            return;
        }
        setIntent(intent);
        if (!C5046bo.nullAsNil(this.nnm).equals(intent.getStringExtra("tab_key"))) {
            C4990ab.m7417i("MicroMsg.GameTabWebUI", "reload %s", this.activity.getClass().getSimpleName());
            finish();
            startActivity(intent);
        }
        overridePendingTransition(C25738R.anim.f8344bi, C25738R.anim.f8344bi);
        AppMethodBeat.m2505o(112265);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(112266);
        super.onDestroy();
        unregisterReceiver(this.nnj);
        AppMethodBeat.m2505o(112266);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(112267);
        super.onBackPressed();
        goBack();
        AppMethodBeat.m2505o(112267);
    }

    private void goBack() {
        AppMethodBeat.m2504i(112268);
        C4990ab.m7417i("MicroMsg.GameTabWebUI", "%s goBack!", this.activity.getClass().getSimpleName());
        bFA();
        sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), WXApp.WXAPP_BROADCAST_PERMISSION);
        AppMethodBeat.m2505o(112268);
    }

    private void bFA() {
        AppMethodBeat.m2504i(112269);
        if (C5046bo.nullAsNil(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            C25985d.m41473f(this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(C25738R.anim.f8401db, C25738R.anim.f8404dg);
            C4990ab.m7416i("MicroMsg.GameTabWebUI", "back to FindMoreFriendsUI.");
        }
        AppMethodBeat.m2505o(112269);
    }
}
