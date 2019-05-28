package com.tencent.p177mm.plugin.freewifi.p418ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.freewifi.C11966k;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11967a;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11968b;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.C39111g;
import com.tencent.p177mm.plugin.freewifi.p416d.C45951l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI */
public class FreeWifiPcUI extends MMActivity {
    private String appId;
    private String cxb;
    private Button grC;
    private String mwH;
    private Button myU;
    private TextView mzS;
    private int mzT;
    private C44275p mzU = null;
    private String mza;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI$2 */
    class C119942 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI$2$1 */
        class C69171 implements C5015a {

            /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI$2$1$1 */
            class C69181 implements OnCancelListener {
                C69181() {
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            }

            C69171() {
            }

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(21062);
                FreeWifiPcUI.this.mzU = C30379h.m48458b(FreeWifiPcUI.this.mController.ylL, FreeWifiPcUI.this.getString(C25738R.string.ato), true, new C69181());
                AppMethodBeat.m2505o(21062);
                return true;
            }
        }

        C119942() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21064);
            FreeWifiPcUI.this.grC.setClickable(false);
            final C7564ap c7564ap = new C7564ap(new C69171(), false);
            c7564ap.mo16770ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            C11967a byo = C11966k.byo();
            byo.muc = String.valueOf(FreeWifiPcUI.this.mzT);
            byo.mud = FreeWifiPcUI.this.appId;
            byo.kBq = FreeWifiPcUI.this.cxb;
            byo.muf = C11968b.SetPcLoginUserInfo.muQ;
            byo.mug = C11968b.SetPcLoginUserInfo.name;
            byo.byq().byp();
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=It starts NetSceneSetPcLoginUserInfo.shopid=%d, appid=%s, ticket=%s", C34189m.m56063V(FreeWifiPcUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(FreeWifiPcUI.this.getIntent())), Integer.valueOf(FreeWifiPcUI.this.mzT), FreeWifiPcUI.this.appId, FreeWifiPcUI.this.cxb);
            new C45951l(FreeWifiPcUI.this.appId, FreeWifiPcUI.this.mzT, FreeWifiPcUI.this.cxb).mo68619c(new C1202f() {
                public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(21063);
                    c7564ap.stopTimer();
                    if (i == 0 && i2 == 0) {
                        FreeWifiPcUI.this.finish();
                    } else if (!C34189m.m56075eh(i, i2) || C34189m.isEmpty(str)) {
                        FreeWifiPcUI.m19898a(FreeWifiPcUI.this, FreeWifiPcUI.this.getString(C25738R.string.bzy), FreeWifiPcUI.this.getString(C25738R.string.bzz));
                    } else {
                        FreeWifiPcUI.m19898a(FreeWifiPcUI.this, str + "(" + C34189m.m56068a(C34189m.m56065X(FreeWifiPcUI.this.getIntent()), C11968b.SetPcLoginUserInfoReturn, i2) + ")", "");
                    }
                    C11967a byo = C11966k.byo();
                    byo.muc = String.valueOf(FreeWifiPcUI.this.mzT);
                    byo.mud = FreeWifiPcUI.this.appId;
                    byo.kBq = FreeWifiPcUI.this.cxb;
                    byo.muf = C11968b.SetPcLoginUserInfoReturn.muQ;
                    byo.mug = C11968b.SetPcLoginUserInfoReturn.name;
                    byo.result = i2;
                    byo.byq().byp();
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=NetSceneSetPcLoginUserInfo returns.shopid=%d, appid=%s, ticket=%s", C34189m.m56063V(FreeWifiPcUI.this.getIntent()), Integer.valueOf(C34189m.m56064W(FreeWifiPcUI.this.getIntent())), Integer.valueOf(FreeWifiPcUI.this.mzT), FreeWifiPcUI.this.appId, FreeWifiPcUI.this.cxb);
                    AppMethodBeat.m2505o(21063);
                }
            });
            AppMethodBeat.m2505o(21064);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI$3 */
    class C119963 implements OnClickListener {
        C119963() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21065);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", FreeWifiPcUI.this.mza);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            C25985d.m41467b(FreeWifiPcUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(21065);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI$1 */
    class C119971 implements OnMenuItemClickListener {
        C119971() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(21061);
            FreeWifiPcUI.m19897a(FreeWifiPcUI.this);
            AppMethodBeat.m2505o(21061);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m19897a(FreeWifiPcUI freeWifiPcUI) {
        AppMethodBeat.m2504i(21069);
        freeWifiPcUI.goBack();
        AppMethodBeat.m2505o(21069);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(21066);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.c0t);
        setBackBtn(new C119971());
        this.appId = getIntent().getStringExtra("free_wifi_appid");
        this.mzT = getIntent().getIntExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", 0);
        this.cxb = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET");
        this.mwH = getIntent().getStringExtra("free_wifi_app_nickname");
        this.mza = getIntent().getStringExtra("free_wifi_privacy_url");
        this.mzS = (TextView) findViewById(2131824150);
        this.grC = (Button) findViewById(2131824151);
        this.mzS.setText("由" + this.mwH + "提供");
        this.grC.setOnClickListener(new C119942());
        this.myU = (Button) findViewById(2131824152);
        this.myU.setOnClickListener(new C119963());
        AppMethodBeat.m2505o(21066);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(21067);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.m2505o(21067);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(21067);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(21068);
        C39111g.gkE.mo38923h(new Intent(), (Context) this);
        finish();
        AppMethodBeat.m2505o(21068);
    }

    public final int getLayoutId() {
        return 2130969596;
    }

    /* renamed from: a */
    static /* synthetic */ void m19898a(FreeWifiPcUI freeWifiPcUI, String str, String str2) {
        AppMethodBeat.m2504i(21070);
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.putExtra("free_wifi_error_ui_error_msg_detail1", str2);
        intent.setClass(freeWifiPcUI, FreeWifiErrorUI.class);
        freeWifiPcUI.finish();
        freeWifiPcUI.startActivity(intent);
        AppMethodBeat.m2505o(21070);
    }
}
