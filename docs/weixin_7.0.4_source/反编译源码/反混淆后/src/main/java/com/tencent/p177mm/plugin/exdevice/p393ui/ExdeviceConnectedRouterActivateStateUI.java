package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.exdevice.p1545a.C38927b;
import com.tencent.p177mm.plugin.exdevice.p1609c.p1610a.C42984a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI */
public class ExdeviceConnectedRouterActivateStateUI extends MMActivity {
    private String appId;
    private String ceI;
    private String cws;
    private final int lAu = 90000;
    private ExdeviceConnectedRouterStateView lAv;
    private TextView lAw;
    private TextView lAx;
    private C38927b<C42984a> lAy = new C205601();
    private String lqT;
    private String ssid;

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI$1 */
    class C205601 implements C38927b<C42984a> {
        C205601() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo23473a(final int i, final int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(19918);
            try {
                C4990ab.m7411d("MicroMsg.ConnectedRouterActivateStateUi", "onNetSceneEndCallback, errType(%s), errCode(%s), errMsg(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (ExdeviceConnectedRouterActivateStateUI.this.isFinishing()) {
                    C4990ab.m7416i("MicroMsg.ConnectedRouterActivateStateUi", "ExdeviceConnectedRouter destroyed.");
                    AppMethodBeat.m2505o(19918);
                    return;
                }
                ExdeviceConnectedRouterActivateStateUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(19917);
                        if (i2 == 0 && (i == 0 || i == 4)) {
                            ExdeviceConnectedRouterActivateStateUI.this.mo45775uQ(2);
                            AppMethodBeat.m2505o(19917);
                        } else if (i != 4) {
                            ExdeviceConnectedRouterActivateStateUI.this.mo45775uQ(4);
                            AppMethodBeat.m2505o(19917);
                        } else if (i2 == 90000) {
                            ExdeviceConnectedRouterActivateStateUI.this.mo45775uQ(3);
                            AppMethodBeat.m2505o(19917);
                        } else {
                            ExdeviceConnectedRouterActivateStateUI.this.mo45775uQ(5);
                            AppMethodBeat.m2505o(19917);
                        }
                    }
                });
                AppMethodBeat.m2505o(19918);
            } catch (Exception e) {
                C4990ab.m7410d("MicroMsg.ConnectedRouterActivateStateUi", e.toString());
                AppMethodBeat.m2505o(19918);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI$3 */
    class C278793 implements OnMenuItemClickListener {
        C278793() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(19920);
            ExdeviceConnectedRouterActivateStateUI.m44327a(ExdeviceConnectedRouterActivateStateUI.this);
            AppMethodBeat.m2505o(19920);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI$2 */
    class C278802 implements OnMenuItemClickListener {
        C278802() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(19919);
            ExdeviceConnectedRouterActivateStateUI.m44327a(ExdeviceConnectedRouterActivateStateUI.this);
            AppMethodBeat.m2505o(19919);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ExdeviceConnectedRouterActivateStateUI() {
        AppMethodBeat.m2504i(19921);
        AppMethodBeat.m2505o(19921);
    }

    /* renamed from: a */
    static /* synthetic */ void m44327a(ExdeviceConnectedRouterActivateStateUI exdeviceConnectedRouterActivateStateUI) {
        AppMethodBeat.m2504i(19928);
        exdeviceConnectedRouterActivateStateUI.bpI();
        AppMethodBeat.m2505o(19928);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(19922);
        super.onCreate(bundle);
        C4990ab.m7410d("MicroMsg.ConnectedRouterActivateStateUi", "create activity");
        setMMTitle((int) C25738R.string.bg2);
        setBackBtn(new C278802());
        this.lAv = (ExdeviceConnectedRouterStateView) findViewById(2131823649);
        this.lAw = (TextView) findViewById(2131823650);
        this.lAx = (TextView) findViewById(2131823651);
        try {
            Uri parse = Uri.parse(getIntent().getStringExtra("key_connected_router"));
            this.ceI = parse.getQueryParameter("deviceid");
            this.cws = parse.getQueryParameter("devicetype");
            this.lqT = parse.getQueryParameter(ClientInfoTable.TABLE_NAME);
            this.appId = parse.getQueryParameter("appid");
            if (C5046bo.isNullOrNil(this.ceI) || C5046bo.isNullOrNil(this.cws) || C5046bo.isNullOrNil(this.lqT) || C5046bo.isNullOrNil(this.appId)) {
                C4990ab.m7413e("MicroMsg.ConnectedRouterActivateStateUi", "loss param %s", parse.toString());
                finish();
            }
            this.ssid = parse.getQueryParameter("ssid");
            C4990ab.m7411d("MicroMsg.ConnectedRouterActivateStateUi", "uri: %s, deviceid: %s, devicetype: %s, clientinfo: %s. ssid: %s", parse.toString(), this.ceI, this.cws, this.lqT, this.ssid);
            if (this.ssid == null) {
                this.ssid = "";
            }
        } catch (Exception e) {
            C4990ab.m7410d("MicroMsg.ConnectedRouterActivateStateUi", e.toString());
        }
        mo45775uQ(1);
        C9638aw.m17182Rg().mo14541a(new C42984a(this.ceI, this.cws, this.lqT, this.appId, this.lAy), 0);
        AppMethodBeat.m2505o(19922);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onResume() {
        AppMethodBeat.m2504i(19923);
        super.onResume();
        AppMethodBeat.m2505o(19923);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: uQ */
    public final void mo45775uQ(int i) {
        AppMethodBeat.m2504i(19924);
        this.lAv.setOnClickListener(null);
        C4990ab.m7411d("MicroMsg.ConnectedRouterActivateStateUi", "Current connection state : %d", Integer.valueOf(i));
        switch (i) {
            case 1:
                this.lAv.setImageResource(C1318a.connected_router_state_normal);
                this.lAv.setState(1);
                this.lAw.setText(C25738R.string.bfw);
                break;
            case 2:
                this.lAv.setImageResource(C1318a.connected_router_state_succ);
                this.lAv.setState(2);
                this.lAw.setText(getString(C25738R.string.bg0, new Object[]{this.ssid}));
                addTextOptionMenu(0, getString(C25738R.string.bfv), new C278793());
                AppMethodBeat.m2505o(19924);
                return;
            case 3:
                this.lAv.setImageResource(C1318a.connected_router_state_error);
                this.lAv.setState(3);
                this.lAv.lAB = 2;
                this.lAw.setText(C25738R.string.bfx);
                this.lAx.setText(getString(C25738R.string.bfy, new Object[]{this.ssid}));
                AppMethodBeat.m2505o(19924);
                return;
            case 4:
                this.lAv.setImageResource(C1318a.connected_router_state_error);
                this.lAv.setState(3);
                this.lAv.lAB = 2;
                this.lAw.setText(C25738R.string.bfx);
                this.lAx.setText(getString(C25738R.string.bfz));
                AppMethodBeat.m2505o(19924);
                return;
            case 5:
                this.lAv.setImageResource(C1318a.connected_router_state_error);
                this.lAv.setState(3);
                this.lAv.lAB = 2;
                this.lAw.setText(C25738R.string.bfx);
                this.lAx.setText(getString(C25738R.string.bg1));
                AppMethodBeat.m2505o(19924);
                return;
        }
        AppMethodBeat.m2505o(19924);
    }

    public final int getLayoutId() {
        return 2130969417;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(19925);
        super.onDestroy();
        AppMethodBeat.m2505o(19925);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(19926);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            bpI();
            AppMethodBeat.m2505o(19926);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(19926);
        return onKeyDown;
    }

    private void bpI() {
        AppMethodBeat.m2504i(19927);
        finish();
        Intent intent = new Intent();
        intent.putExtra("From_fail_notify", true);
        C4990ab.m7410d("MicroMsg.ConnectedRouterActivateStateUi", "startMainUI");
        C25985d.m41473f(this, "com.tencent.mm.ui.LauncherUI", intent);
        AppMethodBeat.m2505o(19927);
    }
}
