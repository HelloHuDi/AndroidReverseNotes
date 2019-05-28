package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.freewifi.d.l;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public class FreeWifiPcUI extends MMActivity {
    private String appId;
    private String cxb;
    private Button grC;
    private String mwH;
    private Button myU;
    private TextView mzS;
    private int mzT;
    private p mzU = null;
    private String mza;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(FreeWifiPcUI freeWifiPcUI) {
        AppMethodBeat.i(21069);
        freeWifiPcUI.goBack();
        AppMethodBeat.o(21069);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21066);
        super.onCreate(bundle);
        setMMTitle((int) R.string.c0t);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21061);
                FreeWifiPcUI.a(FreeWifiPcUI.this);
                AppMethodBeat.o(21061);
                return true;
            }
        });
        this.appId = getIntent().getStringExtra("free_wifi_appid");
        this.mzT = getIntent().getIntExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", 0);
        this.cxb = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET");
        this.mwH = getIntent().getStringExtra("free_wifi_app_nickname");
        this.mza = getIntent().getStringExtra("free_wifi_privacy_url");
        this.mzS = (TextView) findViewById(R.id.bwg);
        this.grC = (Button) findViewById(R.id.bwh);
        this.mzS.setText("由" + this.mwH + "提供");
        this.grC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21064);
                FreeWifiPcUI.this.grC.setClickable(false);
                final ap apVar = new ap(new a() {
                    public final boolean BI() {
                        AppMethodBeat.i(21062);
                        FreeWifiPcUI.this.mzU = h.b(FreeWifiPcUI.this.mController.ylL, FreeWifiPcUI.this.getString(R.string.ato), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        AppMethodBeat.o(21062);
                        return true;
                    }
                }, false);
                apVar.ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                k.a byo = k.byo();
                byo.muc = String.valueOf(FreeWifiPcUI.this.mzT);
                byo.mud = FreeWifiPcUI.this.appId;
                byo.kBq = FreeWifiPcUI.this.cxb;
                byo.muf = b.SetPcLoginUserInfo.muQ;
                byo.mug = b.SetPcLoginUserInfo.name;
                byo.byq().byp();
                ab.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=It starts NetSceneSetPcLoginUserInfo.shopid=%d, appid=%s, ticket=%s", m.V(FreeWifiPcUI.this.getIntent()), Integer.valueOf(m.W(FreeWifiPcUI.this.getIntent())), Integer.valueOf(FreeWifiPcUI.this.mzT), FreeWifiPcUI.this.appId, FreeWifiPcUI.this.cxb);
                new l(FreeWifiPcUI.this.appId, FreeWifiPcUI.this.mzT, FreeWifiPcUI.this.cxb).c(new f() {
                    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                        AppMethodBeat.i(21063);
                        apVar.stopTimer();
                        if (i == 0 && i2 == 0) {
                            FreeWifiPcUI.this.finish();
                        } else if (!m.eh(i, i2) || m.isEmpty(str)) {
                            FreeWifiPcUI.a(FreeWifiPcUI.this, FreeWifiPcUI.this.getString(R.string.bzy), FreeWifiPcUI.this.getString(R.string.bzz));
                        } else {
                            FreeWifiPcUI.a(FreeWifiPcUI.this, str + "(" + m.a(m.X(FreeWifiPcUI.this.getIntent()), b.SetPcLoginUserInfoReturn, i2) + ")", "");
                        }
                        k.a byo = k.byo();
                        byo.muc = String.valueOf(FreeWifiPcUI.this.mzT);
                        byo.mud = FreeWifiPcUI.this.appId;
                        byo.kBq = FreeWifiPcUI.this.cxb;
                        byo.muf = b.SetPcLoginUserInfoReturn.muQ;
                        byo.mug = b.SetPcLoginUserInfoReturn.name;
                        byo.result = i2;
                        byo.byq().byp();
                        ab.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=NetSceneSetPcLoginUserInfo returns.shopid=%d, appid=%s, ticket=%s", m.V(FreeWifiPcUI.this.getIntent()), Integer.valueOf(m.W(FreeWifiPcUI.this.getIntent())), Integer.valueOf(FreeWifiPcUI.this.mzT), FreeWifiPcUI.this.appId, FreeWifiPcUI.this.cxb);
                        AppMethodBeat.o(21063);
                    }
                });
                AppMethodBeat.o(21064);
            }
        });
        this.myU = (Button) findViewById(R.id.bwi);
        this.myU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21065);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", FreeWifiPcUI.this.mza);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                d.b(FreeWifiPcUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(21065);
            }
        });
        AppMethodBeat.o(21066);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(21067);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(21067);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(21067);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(21068);
        g.gkE.h(new Intent(), (Context) this);
        finish();
        AppMethodBeat.o(21068);
    }

    public final int getLayoutId() {
        return R.layout.a0r;
    }

    static /* synthetic */ void a(FreeWifiPcUI freeWifiPcUI, String str, String str2) {
        AppMethodBeat.i(21070);
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.putExtra("free_wifi_error_ui_error_msg_detail1", str2);
        intent.setClass(freeWifiPcUI, FreeWifiErrorUI.class);
        freeWifiPcUI.finish();
        freeWifiPcUI.startActivity(intent);
        AppMethodBeat.o(21070);
    }
}
