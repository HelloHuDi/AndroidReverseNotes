package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.model.av;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.model.g;
import com.tencent.mm.plugin.setting.ui.widget.HeadImgNewPreference;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.io.File;

public class SettingsPersonalInfoUI extends MMPreference implements f, b {
    private com.tencent.mm.ui.base.preference.f ehK;
    private boolean gqB;
    private g qog;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SettingsPersonalInfoUI settingsPersonalInfoUI) {
        AppMethodBeat.i(127380);
        settingsPersonalInfoUI.ciY();
        AppMethodBeat.o(127380);
    }

    public final int JC() {
        return R.xml.c5;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127370);
        super.onCreate(bundle);
        initView();
        if (getIntent().getBooleanExtra("intent_set_avatar", false)) {
            this.gqB = getIntent().getBooleanExtra("KEnterFromBanner", false);
            a.gkF.o(this);
        }
        com.tencent.mm.kernel.g.Rg().a(1191, (f) this);
        AppMethodBeat.o(127370);
    }

    public void onDestroy() {
        AppMethodBeat.i(127371);
        ab.d("MicroMsg.SettingsPersonalInfoUI", "SettingsPersonalInfoUI.onDestroy()");
        if (com.tencent.mm.kernel.g.RK()) {
            com.tencent.mm.kernel.g.RP().Ry().b(this);
        }
        if (this.qog != null) {
            com.tencent.mm.kernel.g.Rg().c(this.qog);
        }
        com.tencent.mm.kernel.g.Rg().b(1191, (f) this);
        super.onDestroy();
        AppMethodBeat.o(127371);
    }

    public final void initView() {
        AppMethodBeat.i(127372);
        setMMTitle((int) R.string.e9w);
        com.tencent.mm.kernel.g.RP().Ry().a(this);
        this.ehK = this.yCw;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127365);
                SettingsPersonalInfoUI.this.aqX();
                SettingsPersonalInfoUI.this.finish();
                AppMethodBeat.o(127365);
                return true;
            }
        });
        AppMethodBeat.o(127372);
    }

    public void onResume() {
        AppMethodBeat.i(127373);
        ciI();
        ciY();
        CharSequence charSequence = (String) com.tencent.mm.kernel.g.RP().Ry().get(4, null);
        if (charSequence != null && charSequence.length() > 0) {
            this.ehK.aqO("settings_name").setSummary(j.b((Context) this, charSequence));
        }
        this.ehK.ce("settings_address", bo.gT(this));
        if (bo.e(Boolean.valueOf(com.tencent.mm.kernel.g.RP().Ry().getBoolean(ac.a.USERINFO_ABOUT_INVOICE_ENTRANCE_BOOLEAN, false)))) {
            this.ehK.ce("settings_invoice", false);
        } else {
            this.ehK.ce("settings_invoice", true);
            this.qog = new g();
            com.tencent.mm.kernel.g.Rg().a(this.qog, 0);
        }
        super.onResume();
        AppMethodBeat.o(127373);
    }

    private void ciI() {
        AppMethodBeat.i(127375);
        Preference aqO = this.ehK.aqO("settings_username");
        CharSequence YA = r.YA();
        CharSequence Yz = r.Yz();
        if (bo.isNullOrNil(YA)) {
            if (ad.aoA(Yz)) {
                aqO.setSummary(getString(R.string.e9q));
            } else {
                aqO.setSummary(Yz);
            }
            if (!ad.aoB(r.Yz())) {
                aqO.NW(8);
                AppMethodBeat.o(127375);
                return;
            }
        }
        aqO.setSummary(YA);
        aqO.NW(8);
        AppMethodBeat.o(127375);
    }

    private void ciY() {
        AppMethodBeat.i(127376);
        HeadImgNewPreference headImgNewPreference = (HeadImgNewPreference) this.ehK.aqO("settings_change_avatar");
        headImgNewPreference.WB(r.Yz());
        headImgNewPreference.qqV = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(127366);
                SettingsPersonalInfoUI.this.mController.ylL.startActivity(new Intent(SettingsPersonalInfoUI.this, PreviewHdHeadImg.class));
                AppMethodBeat.o(127366);
            }
        };
        AppMethodBeat.o(127376);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(127377);
        ab.i("MicroMsg.SettingsPersonalInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != -1) {
            if (i == 3 || i == 2 || i == 4) {
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(127367);
                        ta taVar = new ta();
                        taVar.cPk.cPm = true;
                        com.tencent.mm.sdk.b.a.xxA.m(taVar);
                        AppMethodBeat.o(127367);
                    }
                });
            }
            AppMethodBeat.o(127377);
            return;
        }
        String h;
        switch (i) {
            case 2:
                if (intent == null) {
                    AppMethodBeat.o(127377);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_Filter", true);
                o.acd();
                intent2.putExtra("CropImage_OutputPath", d.D(r.Yz() + ".crop", true));
                intent2.putExtra("CropImage_ImgPath", null);
                com.tencent.mm.plugin.setting.b.gkE.a((Activity) this, intent, intent2, c.XW(), 4, null);
                AppMethodBeat.o(127377);
                return;
            case 3:
                h = n.h(getApplicationContext(), intent, c.XW());
                if (h == null) {
                    AppMethodBeat.o(127377);
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 1);
                intent3.putExtra("CropImage_OutputPath", h);
                intent3.putExtra("CropImage_ImgPath", h);
                com.tencent.mm.plugin.setting.b.gkE.a((Activity) this, intent3, 4);
                AppMethodBeat.o(127377);
                return;
            case 4:
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(127368);
                        ta taVar = new ta();
                        taVar.cPk.cPm = true;
                        com.tencent.mm.sdk.b.a.xxA.m(taVar);
                        AppMethodBeat.o(127368);
                    }
                });
                if (intent == null) {
                    AppMethodBeat.o(127377);
                    return;
                }
                h = intent.getStringExtra("CropImage_OutputPath");
                String Yz = r.Yz();
                o.acd();
                final Bitmap qg = d.qg(Yz);
                if (h == null) {
                    ab.e("MicroMsg.SettingsPersonalInfoUI", "crop picture failed");
                    AppMethodBeat.o(127377);
                    return;
                }
                ab.i("MicroMsg.SettingsPersonalInfoUI", "onActivityResult(CONTEXT_MENU_CROP_PICTURE)  file:%s, size:%d", h, Long.valueOf(new File(h).length()));
                new m(this.mController.ylL, h).w(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(127369);
                        ab.d("MicroMsg.SettingsPersonalInfoUI", "updateHeadImg hasUin:%b user:%s", Boolean.valueOf(com.tencent.mm.kernel.g.RK()), r.Yz());
                        if (com.tencent.mm.kernel.g.RK()) {
                            if (qg != null) {
                                o.acd();
                                PreviewHdHeadImg.e(qg, d.D(r.Yz() + ".last", true));
                            }
                            av.fly.ou(com.tencent.mm.ah.b.pX(r.Yz()));
                        }
                        SettingsPersonalInfoUI.a(SettingsPersonalInfoUI.this);
                        if (SettingsPersonalInfoUI.this.gqB) {
                            h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(4), Integer.valueOf(4));
                        }
                        AppMethodBeat.o(127369);
                    }
                });
                AppMethodBeat.o(127377);
                return;
            default:
                AppMethodBeat.o(127377);
                return;
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        AppMethodBeat.i(127378);
        ab.d("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(bo.g(obj, 0)), nVar);
        if (nVar != com.tencent.mm.kernel.g.RP().Ry() || r0 <= 0) {
            ab.e("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(r0), nVar);
            AppMethodBeat.o(127378);
            return;
        }
        ciI();
        AppMethodBeat.o(127378);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(127374);
        String str = preference.mKey;
        ab.d("MicroMsg.SettingsPersonalInfoUI", "key = ".concat(String.valueOf(str)));
        if (str.equals("settings_change_avatar")) {
            boolean o = a.gkF.o(this);
            AppMethodBeat.o(127374);
            return o;
        } else if (str.equals("settings_username")) {
            if (bo.isNullOrNil(r.YA()) && ad.aoB(r.Yz())) {
                aA(SettingsAliasUI.class);
            }
            AppMethodBeat.o(127374);
            return true;
        } else if (str.equals("settings_name")) {
            Intent intent = new Intent();
            intent.setClass(this, SettingsModifyNameUI.class);
            startActivity(intent);
            AppMethodBeat.o(127374);
            return true;
        } else {
            Intent intent2;
            if (str.equals("settings_qrcode")) {
                h.pYm.e(11264, Integer.valueOf(2));
                this.mController.ylL.startActivity(new Intent(this, SelfQRCodeUI.class));
            } else if (str.equals("settings_more_info")) {
                startActivity(new Intent(this, SettingsPersonalMoreUI.class));
            } else if (str.equals("settings_address")) {
                intent2 = new Intent();
                intent2.putExtra("launch_from_webview", false);
                com.tencent.mm.bp.d.c(this.mController.ylL, "address", ".ui.WalletSelectAddrUI", intent2);
                AppMethodBeat.o(127374);
                return true;
            } else if (str.equals("settings_invoice")) {
                h.pYm.e(14199, Integer.valueOf(1));
                intent2 = new Intent();
                intent2.putExtra("launch_from_webview", false);
                com.tencent.mm.bp.d.c(this.mController.ylL, "address", ".ui.InvoiceListUI", intent2);
                AppMethodBeat.o(127374);
                return true;
            }
            AppMethodBeat.o(127374);
            return false;
        }
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(127379);
        if (bo.e(Boolean.valueOf(com.tencent.mm.kernel.g.RP().Ry().getBoolean(ac.a.USERINFO_ABOUT_INVOICE_ENTRANCE_BOOLEAN, false)))) {
            this.ehK.ce("settings_invoice", false);
            AppMethodBeat.o(127379);
            return;
        }
        this.ehK.ce("settings_invoice", true);
        AppMethodBeat.o(127379);
    }
}
