package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
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
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.jp;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public class SecurityAccountIntroUI extends MMWizardActivity implements f {
    private String cFl;
    private ProgressDialog ehJ = null;
    private String gsF;
    private String gzO;
    private String gzP;
    private boolean gzQ = false;
    private Button gzR;
    private String jumpUrl;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void e(SecurityAccountIntroUI securityAccountIntroUI) {
        AppMethodBeat.i(69914);
        securityAccountIntroUI.aoZ();
        AppMethodBeat.o(69914);
    }

    public final int getLayoutId() {
        return R.layout.aq8;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69907);
        super.onCreate(bundle);
        this.gzO = getIntent().getStringExtra("auth_ticket");
        this.cFl = getIntent().getStringExtra("binded_mobile");
        this.gzQ = getIntent().getBooleanExtra("re_open_verify", false);
        String stringExtra = getIntent().getStringExtra("close_safe_device_style");
        ab.i("MicroMsg.SecurityAccountIntroUI", "summerphone authTicket[%s], showStyle[%s]", bo.anv(this.gzO), stringExtra);
        if (!bo.isNullOrNil(stringExtra)) {
            Map z = br.z(stringExtra, "wording");
            if (z != null) {
                this.gzP = (String) z.get(".wording.title");
                this.jumpUrl = (String) z.get(".wording.url");
                ab.i("MicroMsg.SecurityAccountIntroUI", "summerphone closeBtnText[%s], jumpUrl[%s]", this.gzP, this.jumpUrl);
            }
        }
        this.gsF = a.FP();
        initView();
        AppMethodBeat.o(69907);
    }

    public void onResume() {
        AppMethodBeat.i(69908);
        super.onResume();
        g.Rg().a(145, (f) this);
        g.Rg().a(132, (f) this);
        if (!this.gzQ) {
            StringBuilder stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",L600_100,");
            g.RN();
            a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("L600_100")).append(",1").toString());
            a.wz("L600_100");
        }
        AppMethodBeat.o(69908);
    }

    public void onPause() {
        AppMethodBeat.i(69909);
        super.onPause();
        g.Rg().b(145, (f) this);
        g.Rg().b(132, (f) this);
        if (!this.gzQ) {
            StringBuilder stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",L600_100,");
            g.RN();
            a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("L600_100")).append(",2").toString());
        }
        AppMethodBeat.o(69909);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(69910);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0) {
            aoZ();
            AppMethodBeat.o(69910);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(69910);
        return onKeyDown;
    }

    public final void initView() {
        AppMethodBeat.i(69911);
        setMMTitle((int) R.string.dws);
        findViewById(R.id.e7b).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                m xVar;
                AppMethodBeat.i(69904);
                if (SecurityAccountIntroUI.this.gzQ) {
                    xVar = new x(SecurityAccountIntroUI.this.cFl, 10, "", 0, "");
                } else {
                    xVar = new com.tencent.mm.modelfriend.a(SecurityAccountIntroUI.this.cFl, 10, "", "", SecurityAccountIntroUI.this.gzO);
                }
                g.Rg().a(xVar, 0);
                SecurityAccountIntroUI securityAccountIntroUI = SecurityAccountIntroUI.this;
                Context context = SecurityAccountIntroUI.this;
                SecurityAccountIntroUI.this.getString(R.string.tz);
                securityAccountIntroUI.ehJ = h.b(context, SecurityAccountIntroUI.this.getString(R.string.dwo), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(69903);
                        g.Rg().c(xVar);
                        AppMethodBeat.o(69903);
                    }
                });
                AppMethodBeat.o(69904);
            }
        });
        if (!this.gzQ) {
            this.gzR = (Button) findViewById(R.id.e7c);
            if (!bo.isNullOrNil(this.gzP)) {
                this.gzR.setText(this.gzP);
            }
            this.gzR.setVisibility(0);
            this.gzR.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(69905);
                    String g = aa.g(SecurityAccountIntroUI.this.getSharedPreferences(ah.doA(), 0));
                    Intent intent = new Intent();
                    if (bo.isNullOrNil(SecurityAccountIntroUI.this.jumpUrl)) {
                        intent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[]{g}));
                    } else {
                        intent.putExtra("rawUrl", SecurityAccountIntroUI.this.jumpUrl);
                    }
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("title", SecurityAccountIntroUI.this.getString(R.string.dwj));
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                    com.tencent.mm.plugin.account.a.a.gkE.i(intent, SecurityAccountIntroUI.this);
                    AppMethodBeat.o(69905);
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69906);
                SecurityAccountIntroUI.e(SecurityAccountIntroUI.this);
                AppMethodBeat.o(69906);
                return true;
            }
        });
        AppMethodBeat.o(69911);
    }

    private void aoZ() {
        AppMethodBeat.i(69912);
        a.wA(this.gsF);
        cancel();
        Ni(1);
        AppMethodBeat.o(69912);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(69913);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 0 && i2 == 0) {
            String str2;
            if (this.gzQ) {
                str2 = ((jp) ((x) mVar).ehh.fsH.fsP).vHS;
            } else {
                str2 = ((com.tencent.mm.modelfriend.a) mVar).agh();
            }
            ab.d("MicroMsg.SecurityAccountIntroUI", "duanyi test authTicket_login = " + this.gzO + "duanyi test authTicket_check = " + str2);
            Intent intent = new Intent(this, SecurityAccountVerifyUI.class);
            intent.putExtra("auth_ticket", str2);
            intent.putExtra("binded_mobile", this.cFl);
            intent.putExtra("re_open_verify", this.gzQ);
            intent.putExtra("from_source", getIntent().getIntExtra("from_source", 1));
            MMWizardActivity.J(this, intent);
            if (getIntent().getIntExtra("from_source", 1) == 3) {
                finish();
            }
            AppMethodBeat.o(69913);
            return;
        }
        int i3;
        switch (i2) {
            case -74:
                h.a((Context) this, (int) R.string.a6g, (int) R.string.tz, null);
                i3 = 1;
                break;
            case -57:
            case -1:
                Toast.makeText(this, R.string.ps, 0).show();
                i3 = 1;
                break;
            case -41:
                Toast.makeText(this, R.string.a6j, 0).show();
                i3 = 1;
                break;
            case -34:
                Toast.makeText(this, R.string.a6k, 0).show();
                i3 = 1;
                break;
            default:
                i3 = 0;
                break;
        }
        if (i3 != 0 || com.tencent.mm.plugin.account.a.a.gkF.a((Context) this, i, i2, str)) {
            AppMethodBeat.o(69913);
            return;
        }
        Toast.makeText(this, getString(R.string.dwm, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        AppMethodBeat.o(69913);
    }
}
