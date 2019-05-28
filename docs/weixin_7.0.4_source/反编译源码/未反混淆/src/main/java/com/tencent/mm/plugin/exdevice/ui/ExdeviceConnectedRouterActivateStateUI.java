package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.c.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;

public class ExdeviceConnectedRouterActivateStateUI extends MMActivity {
    private String appId;
    private String ceI;
    private String cws;
    private final int lAu = 90000;
    private ExdeviceConnectedRouterStateView lAv;
    private TextView lAw;
    private TextView lAx;
    private b<a> lAy = new b<a>() {
        public final /* synthetic */ void a(final int i, final int i2, String str, m mVar) {
            AppMethodBeat.i(19918);
            try {
                ab.d("MicroMsg.ConnectedRouterActivateStateUi", "onNetSceneEndCallback, errType(%s), errCode(%s), errMsg(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (ExdeviceConnectedRouterActivateStateUI.this.isFinishing()) {
                    ab.i("MicroMsg.ConnectedRouterActivateStateUi", "ExdeviceConnectedRouter destroyed.");
                    AppMethodBeat.o(19918);
                    return;
                }
                ExdeviceConnectedRouterActivateStateUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(19917);
                        if (i2 == 0 && (i == 0 || i == 4)) {
                            ExdeviceConnectedRouterActivateStateUI.this.uQ(2);
                            AppMethodBeat.o(19917);
                        } else if (i != 4) {
                            ExdeviceConnectedRouterActivateStateUI.this.uQ(4);
                            AppMethodBeat.o(19917);
                        } else if (i2 == 90000) {
                            ExdeviceConnectedRouterActivateStateUI.this.uQ(3);
                            AppMethodBeat.o(19917);
                        } else {
                            ExdeviceConnectedRouterActivateStateUI.this.uQ(5);
                            AppMethodBeat.o(19917);
                        }
                    }
                });
                AppMethodBeat.o(19918);
            } catch (Exception e) {
                ab.d("MicroMsg.ConnectedRouterActivateStateUi", e.toString());
                AppMethodBeat.o(19918);
            }
        }
    };
    private String lqT;
    private String ssid;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ExdeviceConnectedRouterActivateStateUI() {
        AppMethodBeat.i(19921);
        AppMethodBeat.o(19921);
    }

    static /* synthetic */ void a(ExdeviceConnectedRouterActivateStateUI exdeviceConnectedRouterActivateStateUI) {
        AppMethodBeat.i(19928);
        exdeviceConnectedRouterActivateStateUI.bpI();
        AppMethodBeat.o(19928);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(19922);
        super.onCreate(bundle);
        ab.d("MicroMsg.ConnectedRouterActivateStateUi", "create activity");
        setMMTitle((int) R.string.bg2);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(19919);
                ExdeviceConnectedRouterActivateStateUI.a(ExdeviceConnectedRouterActivateStateUI.this);
                AppMethodBeat.o(19919);
                return true;
            }
        });
        this.lAv = (ExdeviceConnectedRouterStateView) findViewById(R.id.bix);
        this.lAw = (TextView) findViewById(R.id.biy);
        this.lAx = (TextView) findViewById(R.id.biz);
        try {
            Uri parse = Uri.parse(getIntent().getStringExtra("key_connected_router"));
            this.ceI = parse.getQueryParameter("deviceid");
            this.cws = parse.getQueryParameter("devicetype");
            this.lqT = parse.getQueryParameter(ClientInfoTable.TABLE_NAME);
            this.appId = parse.getQueryParameter("appid");
            if (bo.isNullOrNil(this.ceI) || bo.isNullOrNil(this.cws) || bo.isNullOrNil(this.lqT) || bo.isNullOrNil(this.appId)) {
                ab.e("MicroMsg.ConnectedRouterActivateStateUi", "loss param %s", parse.toString());
                finish();
            }
            this.ssid = parse.getQueryParameter("ssid");
            ab.d("MicroMsg.ConnectedRouterActivateStateUi", "uri: %s, deviceid: %s, devicetype: %s, clientinfo: %s. ssid: %s", parse.toString(), this.ceI, this.cws, this.lqT, this.ssid);
            if (this.ssid == null) {
                this.ssid = "";
            }
        } catch (Exception e) {
            ab.d("MicroMsg.ConnectedRouterActivateStateUi", e.toString());
        }
        uQ(1);
        aw.Rg().a(new a(this.ceI, this.cws, this.lqT, this.appId, this.lAy), 0);
        AppMethodBeat.o(19922);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onResume() {
        AppMethodBeat.i(19923);
        super.onResume();
        AppMethodBeat.o(19923);
    }

    /* Access modifiers changed, original: protected|final */
    public final void uQ(int i) {
        AppMethodBeat.i(19924);
        this.lAv.setOnClickListener(null);
        ab.d("MicroMsg.ConnectedRouterActivateStateUi", "Current connection state : %d", Integer.valueOf(i));
        switch (i) {
            case 1:
                this.lAv.setImageResource(R.raw.connected_router_state_normal);
                this.lAv.setState(1);
                this.lAw.setText(R.string.bfw);
                break;
            case 2:
                this.lAv.setImageResource(R.raw.connected_router_state_succ);
                this.lAv.setState(2);
                this.lAw.setText(getString(R.string.bg0, new Object[]{this.ssid}));
                addTextOptionMenu(0, getString(R.string.bfv), new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(19920);
                        ExdeviceConnectedRouterActivateStateUI.a(ExdeviceConnectedRouterActivateStateUI.this);
                        AppMethodBeat.o(19920);
                        return true;
                    }
                });
                AppMethodBeat.o(19924);
                return;
            case 3:
                this.lAv.setImageResource(R.raw.connected_router_state_error);
                this.lAv.setState(3);
                this.lAv.lAB = 2;
                this.lAw.setText(R.string.bfx);
                this.lAx.setText(getString(R.string.bfy, new Object[]{this.ssid}));
                AppMethodBeat.o(19924);
                return;
            case 4:
                this.lAv.setImageResource(R.raw.connected_router_state_error);
                this.lAv.setState(3);
                this.lAv.lAB = 2;
                this.lAw.setText(R.string.bfx);
                this.lAx.setText(getString(R.string.bfz));
                AppMethodBeat.o(19924);
                return;
            case 5:
                this.lAv.setImageResource(R.raw.connected_router_state_error);
                this.lAv.setState(3);
                this.lAv.lAB = 2;
                this.lAw.setText(R.string.bfx);
                this.lAx.setText(getString(R.string.bg1));
                AppMethodBeat.o(19924);
                return;
        }
        AppMethodBeat.o(19924);
    }

    public final int getLayoutId() {
        return R.layout.vz;
    }

    public void onDestroy() {
        AppMethodBeat.i(19925);
        super.onDestroy();
        AppMethodBeat.o(19925);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(19926);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            bpI();
            AppMethodBeat.o(19926);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(19926);
        return onKeyDown;
    }

    private void bpI() {
        AppMethodBeat.i(19927);
        finish();
        Intent intent = new Intent();
        intent.putExtra("From_fail_notify", true);
        ab.d("MicroMsg.ConnectedRouterActivateStateUi", "startMainUI");
        d.f(this, "com.tencent.mm.ui.LauncherUI", intent);
        AppMethodBeat.o(19927);
    }
}
