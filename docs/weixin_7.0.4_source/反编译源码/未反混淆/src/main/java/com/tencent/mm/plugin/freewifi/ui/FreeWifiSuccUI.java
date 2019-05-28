package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.e;
import com.tencent.ttpic.FilterEnum4Shaka;

public class FreeWifiSuccUI extends MMActivity implements f {
    private String cBb;
    private String csB;
    private Button ixU;
    private CheckBox koj;
    private String mAa;
    private View mAf;
    private TextView mAg;
    private View mAh;
    private TextView mAi;
    private View mAj;
    private int mAk;
    private boolean mAl = false;
    private boolean mAm = false;
    private String mwH;
    private TextView mzS;
    private int mzZ;
    private String signature;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21089);
        super.onCreate(bundle);
        this.csB = getIntent().getStringExtra("free_wifi_appid");
        this.mwH = getIntent().getStringExtra("free_wifi_app_nickname");
        this.cBb = getIntent().getStringExtra("free_wifi_app_username");
        this.mzZ = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
        this.mAa = getIntent().getStringExtra("free_wifi_finish_url");
        this.mAk = getIntent().getIntExtra(e.yfW, 0);
        this.signature = getIntent().getStringExtra("free_wifi_signature");
        ab.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", this.csB, this.mwH, this.cBb, Integer.valueOf(this.mzZ), this.mAa, this.signature);
        a byo = k.byo();
        String Mz = m.Mz("MicroMsg.FreeWifi.FreeWifiSuccUI");
        byo.ssid = at.gE(ah.getContext());
        byo.bssid = at.gF(ah.getContext());
        byo.cuI = Mz;
        byo.cuH = getIntent().getStringExtra("free_wifi_ap_key");
        byo.mud = this.csB;
        byo.kBq = m.V(getIntent());
        byo.mue = m.X(getIntent());
        byo.muf = b.GetBackPage.muQ;
        byo.mug = b.GetBackPage.name;
        byo.cIb = m.Y(getIntent());
        byo.muh = this.cBb;
        byo.byq().byp();
        AppMethodBeat.o(21089);
    }

    public void onResume() {
        AppMethodBeat.i(21090);
        super.onResume();
        initView();
        AppMethodBeat.o(21090);
    }

    public void finish() {
        AppMethodBeat.i(21091);
        super.finish();
        bzT();
        AppMethodBeat.o(21091);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(21092);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            finish();
            AppMethodBeat.o(21092);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(21092);
        return onKeyDown;
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(21093);
        ab.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        aw.Rg().b(1703, (f) this);
        AppMethodBeat.o(21093);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return R.layout.a0u;
    }

    public final void initView() {
        AppMethodBeat.i(21094);
        setMMTitle((int) R.string.c0t);
        pP(false);
        this.mAf = findViewById(R.id.bwn);
        this.mAg = (TextView) findViewById(R.id.bwp);
        this.koj = (CheckBox) findViewById(R.id.bwq);
        this.mAh = findViewById(R.id.bwr);
        this.mAi = (TextView) findViewById(R.id.bws);
        this.mAj = findViewById(R.id.bwt);
        this.mzS = (TextView) findViewById(R.id.bwu);
        this.ixU = (Button) findViewById(R.id.bww);
        this.ixU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21085);
                FreeWifiSuccUI.this.finish();
                FreeWifiSuccUI.a(FreeWifiSuccUI.this);
                AppMethodBeat.o(21085);
            }
        });
        if (bo.isNullOrNil(this.csB) || bo.isNullOrNil(this.cBb) || bo.isNullOrNil(this.mwH)) {
            this.mAf.setVisibility(8);
            this.mAh.setVisibility(8);
            this.mAj.setVisibility(8);
        } else if (t.mZ(this.cBb) && t.mY(this.cBb)) {
            l.a(d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), true);
            this.mAf.setVisibility(8);
            this.mAh.setVisibility(8);
            this.mAj.setVisibility(0);
            this.mzS.setText(this.mwH);
            this.mAj.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(21086);
                    if (!bo.isNullOrNil(FreeWifiSuccUI.this.cBb)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", FreeWifiSuccUI.this.cBb);
                        com.tencent.mm.bp.d.b(FreeWifiSuccUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                    }
                    AppMethodBeat.o(21086);
                }
            });
        } else {
            l.a(d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), false);
            this.mAj.setVisibility(8);
            this.mAf.setVisibility(0);
            if (bo.isNullOrNil(this.signature)) {
                this.mAh.setVisibility(8);
                findViewById(R.id.bwo).setBackgroundColor(getResources().getColor(R.color.a69));
            } else {
                this.mAh.setVisibility(0);
                this.mAi.setText(this.signature);
            }
            this.mAg.setText(getString(R.string.c09, new Object[]{this.mwH}));
            if (this.mAk == 1) {
                this.koj.setChecked(true);
                this.mAl = true;
            } else {
                this.koj.setChecked(false);
                this.mAl = false;
            }
            this.koj.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AppMethodBeat.i(21087);
                    if (z) {
                        FreeWifiSuccUI.this.mAl = true;
                        AppMethodBeat.o(21087);
                        return;
                    }
                    FreeWifiSuccUI.this.mAl = false;
                    AppMethodBeat.o(21087);
                }
            });
        }
        if (m.Y(getIntent()) == 10) {
            final String str = q.eth.etR;
            if (!(m.isEmpty(str) || m.isEmpty(q.bB(this.mController.ylL)))) {
                Button button = (Button) findViewById(R.id.bwx);
                button.setText(String.format(getString(R.string.c0s), new Object[]{q.bB(this.mController.ylL)}));
                button.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(21088);
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        com.tencent.mm.bp.d.b(FreeWifiSuccUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        AppMethodBeat.o(21088);
                    }
                });
                button.setVisibility(0);
            }
        }
        AppMethodBeat.o(21094);
    }

    private void bzT() {
        AppMethodBeat.i(21095);
        if (this.mAm) {
            AppMethodBeat.o(21095);
            return;
        }
        this.mAm = true;
        if (!(!this.mAl || bo.isNullOrNil(this.csB) || (t.mZ(this.cBb) && t.mY(this.cBb)))) {
            aw.Rg().a(1703, (f) this);
            aw.Rg().a(new i(this.csB, getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_channel_id", 0), m.V(getIntent())), 0);
        }
        l.b(d.byN(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), this.mAl);
        AppMethodBeat.o(21095);
    }

    static /* synthetic */ void a(FreeWifiSuccUI freeWifiSuccUI) {
        AppMethodBeat.i(21096);
        freeWifiSuccUI.bzT();
        a byo = k.byo();
        String Mz = m.Mz("MicroMsg.FreeWifi.FreeWifiSuccUI");
        byo.ssid = at.gE(ah.getContext());
        byo.bssid = at.gF(ah.getContext());
        byo.cuI = Mz;
        byo.cuH = m.Z(freeWifiSuccUI.getIntent());
        byo.mud = freeWifiSuccUI.csB;
        byo.kBq = m.V(freeWifiSuccUI.getIntent());
        byo.mue = m.X(freeWifiSuccUI.getIntent());
        byo.muf = b.BackpageFinished.muQ;
        byo.mug = b.BackpageFinished.name;
        byo.cIb = m.Y(freeWifiSuccUI.getIntent());
        byo.muh = freeWifiSuccUI.cBb;
        byo.byq().byp();
        if (freeWifiSuccUI.mzZ != 1 || bo.isNullOrNil(freeWifiSuccUI.mAa)) {
            if (!(freeWifiSuccUI.mzZ == 0 || freeWifiSuccUI.mzZ != 3 || bo.isNullOrNil(freeWifiSuccUI.mAa))) {
                ((com.tencent.mm.plugin.appbrand.service.f) g.K(com.tencent.mm.plugin.appbrand.service.f.class)).b(freeWifiSuccUI, freeWifiSuccUI.mAa, FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL, null);
                ab.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "jump to wxa after connect wifi success, url is : %s", freeWifiSuccUI.mAa);
            }
            AppMethodBeat.o(21096);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", Uri.parse(freeWifiSuccUI.mAa).buildUpon().appendQueryParameter("lang", aa.g(freeWifiSuccUI.getSharedPreferences(ah.doA(), 0))).build().toString());
        intent.putExtra("show_bottom", false);
        intent.putExtra("stastic_scene", 7);
        intent.putExtra("neverBlockLocalRequest", true);
        com.tencent.mm.bp.d.b((Context) freeWifiSuccUI, "webview", ".ui.tools.WebViewUI", intent);
        ab.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "jump to ad page after connect wifi success, url is : %s", intent.getStringExtra("rawUrl"));
        AppMethodBeat.o(21096);
    }
}
