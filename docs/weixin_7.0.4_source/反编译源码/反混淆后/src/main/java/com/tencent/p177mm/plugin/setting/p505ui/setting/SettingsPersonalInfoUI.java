package com.tencent.p177mm.plugin.setting.p505ui.setting;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C37439m;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C45369ta;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.plugin.setting.model.C21738g;
import com.tencent.p177mm.plugin.setting.p505ui.widget.HeadImgNewPreference;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI */
public class SettingsPersonalInfoUI extends MMPreference implements C1202f, C4937b {
    private C15541f ehK;
    private boolean gqB;
    private C21738g qog;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI$4 */
    class C217754 implements Runnable {
        C217754() {
        }

        public final void run() {
            AppMethodBeat.m2504i(127368);
            C45369ta c45369ta = new C45369ta();
            c45369ta.cPk.cPm = true;
            C4879a.xxA.mo10055m(c45369ta);
            AppMethodBeat.m2505o(127368);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI$1 */
    class C217771 implements OnMenuItemClickListener {
        C217771() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127365);
            SettingsPersonalInfoUI.this.aqX();
            SettingsPersonalInfoUI.this.finish();
            AppMethodBeat.m2505o(127365);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI$2 */
    class C217782 implements OnClickListener {
        C217782() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127366);
            SettingsPersonalInfoUI.this.mController.ylL.startActivity(new Intent(SettingsPersonalInfoUI.this, PreviewHdHeadImg.class));
            AppMethodBeat.m2505o(127366);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI$3 */
    class C217793 implements Runnable {
        C217793() {
        }

        public final void run() {
            AppMethodBeat.m2504i(127367);
            C45369ta c45369ta = new C45369ta();
            c45369ta.cPk.cPm = true;
            C4879a.xxA.mo10055m(c45369ta);
            AppMethodBeat.m2505o(127367);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m33309a(SettingsPersonalInfoUI settingsPersonalInfoUI) {
        AppMethodBeat.m2504i(127380);
        settingsPersonalInfoUI.ciY();
        AppMethodBeat.m2505o(127380);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8557c5;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127370);
        super.onCreate(bundle);
        initView();
        if (getIntent().getBooleanExtra("intent_set_avatar", false)) {
            this.gqB = getIntent().getBooleanExtra("KEnterFromBanner", false);
            C24679a.gkF.mo38870o(this);
        }
        C1720g.m3540Rg().mo14539a(1191, (C1202f) this);
        AppMethodBeat.m2505o(127370);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127371);
        C4990ab.m7410d("MicroMsg.SettingsPersonalInfoUI", "SettingsPersonalInfoUI.onDestroy()");
        if (C1720g.m3531RK()) {
            C1720g.m3536RP().mo5239Ry().mo10121b(this);
        }
        if (this.qog != null) {
            C1720g.m3540Rg().mo14547c(this.qog);
        }
        C1720g.m3540Rg().mo14546b(1191, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(127371);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127372);
        setMMTitle((int) C25738R.string.e9w);
        C1720g.m3536RP().mo5239Ry().mo10118a(this);
        this.ehK = this.yCw;
        setBackBtn(new C217771());
        AppMethodBeat.m2505o(127372);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127373);
        ciI();
        ciY();
        CharSequence charSequence = (String) C1720g.m3536RP().mo5239Ry().get(4, null);
        if (charSequence != null && charSequence.length() > 0) {
            this.ehK.aqO("settings_name").setSummary(C44089j.m79292b((Context) this, charSequence));
        }
        this.ehK.mo27715ce("settings_address", C5046bo.m7558gT(this));
        if (C5046bo.m7546e(Boolean.valueOf(C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_ABOUT_INVOICE_ENTRANCE_BOOLEAN, false)))) {
            this.ehK.mo27715ce("settings_invoice", false);
        } else {
            this.ehK.mo27715ce("settings_invoice", true);
            this.qog = new C21738g();
            C1720g.m3540Rg().mo14541a(this.qog, 0);
        }
        super.onResume();
        AppMethodBeat.m2505o(127373);
    }

    private void ciI() {
        AppMethodBeat.m2504i(127375);
        Preference aqO = this.ehK.aqO("settings_username");
        CharSequence YA = C1853r.m3819YA();
        CharSequence Yz = C1853r.m3846Yz();
        if (C5046bo.isNullOrNil(YA)) {
            if (C7616ad.aoA(Yz)) {
                aqO.setSummary(getString(C25738R.string.e9q));
            } else {
                aqO.setSummary(Yz);
            }
            if (!C7616ad.aoB(C1853r.m3846Yz())) {
                aqO.mo39406NW(8);
                AppMethodBeat.m2505o(127375);
                return;
            }
        }
        aqO.setSummary(YA);
        aqO.mo39406NW(8);
        AppMethodBeat.m2505o(127375);
    }

    private void ciY() {
        AppMethodBeat.m2504i(127376);
        HeadImgNewPreference headImgNewPreference = (HeadImgNewPreference) this.ehK.aqO("settings_change_avatar");
        headImgNewPreference.mo25297WB(C1853r.m3846Yz());
        headImgNewPreference.qqV = new C217782();
        AppMethodBeat.m2505o(127376);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(127377);
        C4990ab.m7417i("MicroMsg.SettingsPersonalInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != -1) {
            if (i == 3 || i == 2 || i == 4) {
                new C7306ak(Looper.getMainLooper()).post(new C217793());
            }
            AppMethodBeat.m2505o(127377);
            return;
        }
        String h;
        switch (i) {
            case 2:
                if (intent == null) {
                    AppMethodBeat.m2505o(127377);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_Filter", true);
                C17884o.acd();
                intent2.putExtra("CropImage_OutputPath", C41732d.m73515D(C1853r.m3846Yz() + ".crop", true));
                intent2.putExtra("CropImage_ImgPath", null);
                C24824b.gkE.mo38891a((Activity) this, intent, intent2, C43217c.m76863XW(), 4, null);
                AppMethodBeat.m2505o(127377);
                return;
            case 3:
                h = C14987n.m23320h(getApplicationContext(), intent, C43217c.m76863XW());
                if (h == null) {
                    AppMethodBeat.m2505o(127377);
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 1);
                intent3.putExtra("CropImage_OutputPath", h);
                intent3.putExtra("CropImage_ImgPath", h);
                C24824b.gkE.mo38890a((Activity) this, intent3, 4);
                AppMethodBeat.m2505o(127377);
                return;
            case 4:
                new C7306ak(Looper.getMainLooper()).post(new C217754());
                if (intent == null) {
                    AppMethodBeat.m2505o(127377);
                    return;
                }
                h = intent.getStringExtra("CropImage_OutputPath");
                String Yz = C1853r.m3846Yz();
                C17884o.acd();
                final Bitmap qg = C41732d.m73526qg(Yz);
                if (h == null) {
                    C4990ab.m7412e("MicroMsg.SettingsPersonalInfoUI", "crop picture failed");
                    AppMethodBeat.m2505o(127377);
                    return;
                }
                C4990ab.m7417i("MicroMsg.SettingsPersonalInfoUI", "onActivityResult(CONTEXT_MENU_CROP_PICTURE)  file:%s, size:%d", h, Long.valueOf(new File(h).length()));
                new C37439m(this.mController.ylL, h).mo60330w(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(127369);
                        C4990ab.m7411d("MicroMsg.SettingsPersonalInfoUI", "updateHeadImg hasUin:%b user:%s", Boolean.valueOf(C1720g.m3531RK()), C1853r.m3846Yz());
                        if (C1720g.m3531RK()) {
                            if (qg != null) {
                                C17884o.acd();
                                PreviewHdHeadImg.m77737e(qg, C41732d.m73515D(C1853r.m3846Yz() + ".last", true));
                            }
                            C6665av.fly.mo14899ou(C41730b.m73505pX(C1853r.m3846Yz()));
                        }
                        SettingsPersonalInfoUI.m33309a(SettingsPersonalInfoUI.this);
                        if (SettingsPersonalInfoUI.this.gqB) {
                            C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(4), Integer.valueOf(4));
                        }
                        AppMethodBeat.m2505o(127369);
                    }
                });
                AppMethodBeat.m2505o(127377);
                return;
            default:
                AppMethodBeat.m2505o(127377);
                return;
        }
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(127378);
        C4990ab.m7411d("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(C5046bo.m7550g(obj, 0)), c7298n);
        if (c7298n != C1720g.m3536RP().mo5239Ry() || r0 <= 0) {
            C4990ab.m7413e("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(r0), c7298n);
            AppMethodBeat.m2505o(127378);
            return;
        }
        ciI();
        AppMethodBeat.m2505o(127378);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(127374);
        String str = preference.mKey;
        C4990ab.m7410d("MicroMsg.SettingsPersonalInfoUI", "key = ".concat(String.valueOf(str)));
        if (str.equals("settings_change_avatar")) {
            boolean o = C24679a.gkF.mo38870o(this);
            AppMethodBeat.m2505o(127374);
            return o;
        } else if (str.equals("settings_username")) {
            if (C5046bo.isNullOrNil(C1853r.m3819YA()) && C7616ad.aoB(C1853r.m3846Yz())) {
                mo17383aA(SettingsAliasUI.class);
            }
            AppMethodBeat.m2505o(127374);
            return true;
        } else if (str.equals("settings_name")) {
            Intent intent = new Intent();
            intent.setClass(this, SettingsModifyNameUI.class);
            startActivity(intent);
            AppMethodBeat.m2505o(127374);
            return true;
        } else {
            Intent intent2;
            if (str.equals("settings_qrcode")) {
                C7060h.pYm.mo8381e(11264, Integer.valueOf(2));
                this.mController.ylL.startActivity(new Intent(this, SelfQRCodeUI.class));
            } else if (str.equals("settings_more_info")) {
                startActivity(new Intent(this, SettingsPersonalMoreUI.class));
            } else if (str.equals("settings_address")) {
                intent2 = new Intent();
                intent2.putExtra("launch_from_webview", false);
                C25985d.m41472c(this.mController.ylL, "address", ".ui.WalletSelectAddrUI", intent2);
                AppMethodBeat.m2505o(127374);
                return true;
            } else if (str.equals("settings_invoice")) {
                C7060h.pYm.mo8381e(14199, Integer.valueOf(1));
                intent2 = new Intent();
                intent2.putExtra("launch_from_webview", false);
                C25985d.m41472c(this.mController.ylL, "address", ".ui.InvoiceListUI", intent2);
                AppMethodBeat.m2505o(127374);
                return true;
            }
            AppMethodBeat.m2505o(127374);
            return false;
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(127379);
        if (C5046bo.m7546e(Boolean.valueOf(C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_ABOUT_INVOICE_ENTRANCE_BOOLEAN, false)))) {
            this.ehK.mo27715ce("settings_invoice", false);
            AppMethodBeat.m2505o(127379);
            return;
        }
        this.ehK.mo27715ce("settings_invoice", true);
        AppMethodBeat.m2505o(127379);
    }
}
