package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1827a;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C16527d.C16529b;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C25767k;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.C8939o;
import com.tencent.p177mm.p201az.C45177d;
import com.tencent.p177mm.p230g.p231a.C41980dg;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.base.model.C42781b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p484c.C34739c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.bbo;
import com.tencent.p177mm.protocal.protobuf.bxk;
import com.tencent.p177mm.protocal.protobuf.byj;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C40631p;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI */
public class NewBizInfoSettingUI extends MMPreference {
    private C15541f ehK;
    private C7616ad ehM;
    private SharedPreferences ehZ = null;
    private boolean eif;
    private C16529b fuY;
    private bxk fwz;
    private int gwP;
    private boolean isDeleteCancel = false;
    private C16527d pkW;
    C5653c pmG = null;
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI$5 */
    class C128645 implements OnCancelListener {
        C128645() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(23916);
            NewBizInfoSettingUI.this.isDeleteCancel = true;
            AppMethodBeat.m2505o(23916);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI$4 */
    class C287024 implements OnClickListener {
        C287024() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23915);
            NewBizInfoSettingUI.m57043b(NewBizInfoSettingUI.this);
            C34739c.m57055cP(NewBizInfoSettingUI.this.ehM.field_username, 910);
            NewBizInfoSettingUI.m57044c(NewBizInfoSettingUI.this);
            AppMethodBeat.m2505o(23915);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI$7 */
    class C287037 implements Runnable {
        C287037() {
        }

        public final void run() {
            AppMethodBeat.m2504i(23919);
            if (NewBizInfoSettingUI.this.isFinishing()) {
                AppMethodBeat.m2505o(23919);
                return;
            }
            C42781b.m75859Z(NewBizInfoSettingUI.this, NewBizInfoSettingUI.this.ehM.field_username);
            C42781b.m75871x(NewBizInfoSettingUI.this);
            AppMethodBeat.m2505o(23919);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI$1 */
    class C347351 implements OnMenuItemClickListener {
        C347351() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(23912);
            NewBizInfoSettingUI.this.finish();
            AppMethodBeat.m2505o(23912);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m57042a(NewBizInfoSettingUI newBizInfoSettingUI, C16527d c16527d, boolean z) {
        AppMethodBeat.m2504i(23929);
        newBizInfoSettingUI.m57041a(c16527d, z);
        AppMethodBeat.m2505o(23929);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.m2504i(23920);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        mo17446xE(C46139a.ppL);
        setMMTitle((int) C25738R.string.av2);
        mo17443ta(WebView.NIGHT_MODE_COLOR);
        dyb();
        mo17426pO(false);
        setBackBtn(new C347351(), C1318a.actionbar_icon_dark_back);
        String nullAsNil = C5046bo.nullAsNil(getIntent().getStringExtra("Contact_User"));
        C9638aw.m17190ZK();
        this.ehM = C18628c.m29078XM().aoO(nullAsNil);
        this.pkW = C17903f.m28104qX(nullAsNil);
        String str = "MicroMsg.mmui.MMPreference";
        String str2 = "user:%s contact:%b, bizInfo:%b";
        Object[] objArr = new Object[3];
        objArr[0] = nullAsNil;
        objArr[1] = Boolean.valueOf(this.ehM != null);
        if (this.pkW != null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        this.gwP = getIntent().getIntExtra("Contact_Scene", 9);
        initView();
        m57050jT(true);
        AppMethodBeat.m2505o(23920);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(23921);
        super.onDestroy();
        m57050jT(false);
        AppMethodBeat.m2505o(23921);
    }

    public final void initView() {
        AppMethodBeat.m2504i(23922);
        if (this.pkW != null) {
            this.fuY = this.pkW.mo30481cJ(false);
        }
        if (this.pkW == null) {
            this.ehK.mo27715ce("contact_is_mute", true);
        } else if (this.pkW.adM()) {
            this.ehK.mo27715ce("contact_is_mute", false);
        } else {
            this.ehK.mo27715ce("contact_is_mute", true);
        }
        this.eif = this.ehM.mo16673DX();
        m57049jO(this.eif);
        C4990ab.m7411d("MicroMsg.mmui.MMPreference", "KIsardDevice(%b)", Boolean.valueOf(getIntent().getBooleanExtra("KIsHardDevice", false)));
        CheckBoxPreference checkBoxPreference;
        if (getIntent() == null || !getIntent().getBooleanExtra("KIsHardDevice", false)) {
            if (!C7486a.m12942jh(this.ehM.field_type)) {
                C4990ab.m7421w("MicroMsg.mmui.MMPreference", "%s is not my contact", this.ehM.field_username);
                caU();
                if (NewBizInfoSettingUI.m57039Bd(this.gwP)) {
                    if (this.pkW == null) {
                        C4990ab.m7412e("MicroMsg.mmui.MMPreference", "bizinfo is null in temp session");
                        AppMethodBeat.m2505o(23922);
                        return;
                    }
                    ((CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo")).uOT = this.pkW.adH();
                    this.ehK.mo27715ce("contact_info_subscribe_bizinfo", false);
                }
            } else if (this.pkW != null) {
                ((CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo")).uOT = this.pkW.adH();
                if (this.pkW.adH()) {
                    if (this.fuY == null && this.pkW != null) {
                        this.fuY = this.pkW.mo30481cJ(false);
                    }
                    if (this.fuY != null && this.fuY.aeb() && C25985d.afj("brandservice")) {
                        this.ehK.mo27715ce("contact_info_template_recv", false);
                    } else {
                        this.ehK.mo27715ce("contact_info_template_recv", true);
                    }
                } else {
                    this.ehK.mo27715ce("contact_info_template_recv", true);
                }
                checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_locate");
                if (this.pkW.mo30481cJ(false).adL()) {
                    checkBoxPreference.uOT = this.pkW.adI();
                    AppMethodBeat.m2505o(23922);
                    return;
                }
                this.ehK.mo27715ce("contact_info_locate", true);
                checkBoxPreference.uOT = this.pkW.adI();
                AppMethodBeat.m2505o(23922);
                return;
            }
            AppMethodBeat.m2505o(23922);
            return;
        }
        C4990ab.m7410d("MicroMsg.mmui.MMPreference", "Hard device biz...");
        C4990ab.m7411d("MicroMsg.mmui.MMPreference", "contact.isContact()(%b), isHardDeviceBound(%b)", Boolean.valueOf(C7486a.m12942jh(this.ehM.field_type)), Boolean.valueOf(caW()));
        if (!C7486a.m12942jh(this.ehM.field_type) || !r0) {
            C4990ab.m7421w("MicroMsg.mmui.MMPreference", "%s is not my hard biz contact", this.ehM.field_username);
            caU();
            if (NewBizInfoSettingUI.m57039Bd(this.gwP)) {
                if (this.pkW == null) {
                    C4990ab.m7412e("MicroMsg.mmui.MMPreference", "bizinfo is null in temp session");
                    AppMethodBeat.m2505o(23922);
                    return;
                }
                ((CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo")).uOT = this.pkW.adH();
                this.ehK.mo27715ce("contact_info_subscribe_bizinfo", false);
            }
            AppMethodBeat.m2505o(23922);
        } else if (this.pkW != null) {
            ((CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo")).uOT = this.pkW.adH();
            checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_locate");
            if (this.pkW.mo30481cJ(false).adL()) {
                checkBoxPreference.uOT = this.pkW.adI();
            } else {
                this.ehK.mo27715ce("contact_info_locate", true);
                checkBoxPreference.uOT = this.pkW.adI();
            }
            if (this.pkW.adH()) {
                if (this.fuY == null && this.pkW != null) {
                    this.fuY = this.pkW.mo30481cJ(false);
                }
                if (this.fuY != null && this.fuY.aeb() && C25985d.afj("brandservice")) {
                    this.ehK.mo27715ce("contact_info_template_recv", false);
                    AppMethodBeat.m2505o(23922);
                    return;
                }
                this.ehK.mo27715ce("contact_info_template_recv", true);
                AppMethodBeat.m2505o(23922);
                return;
            }
            this.ehK.mo27715ce("contact_info_template_recv", true);
            AppMethodBeat.m2505o(23922);
        } else {
            this.ehK.mo27715ce("contact_info_subscribe_bizinfo", true);
            this.ehK.mo27715ce("contact_info_locate", true);
            this.ehK.mo27715ce("contact_info_template_recv", true);
            AppMethodBeat.m2505o(23922);
        }
    }

    private void caU() {
        AppMethodBeat.m2504i(23923);
        if (this.ehM == null || !C7486a.m12942jh(this.ehM.field_type) || C1855t.m3943nl(this.ehM.field_username) || C1855t.m3931nQ(this.ehM.field_username)) {
            this.ehK.mo27715ce("contact_is_mute", true);
            if (this.ehM == null || C7486a.m12942jh(this.ehM.field_type) || !NewBizInfoSettingUI.m57039Bd(this.gwP)) {
                this.ehK.mo27715ce("contact_info_expose_btn", true);
            } else {
                this.ehK.mo27715ce("contact_info_expose_btn", false);
            }
        } else if (this.pkW == null || !this.pkW.adM()) {
            this.ehK.mo27715ce("contact_is_mute", true);
        } else {
            this.ehK.mo27715ce("contact_is_mute", false);
        }
        this.ehK.mo27715ce("contact_info_verifyuser_weibo", true);
        this.ehK.mo27715ce("contact_info_subscribe_bizinfo", true);
        this.ehK.mo27715ce("contact_info_template_recv", true);
        this.ehK.mo27715ce("contact_info_locate", true);
        AppMethodBeat.m2505o(23923);
    }

    private boolean caW() {
        AppMethodBeat.m2504i(23924);
        if (getIntent() == null) {
            AppMethodBeat.m2505o(23924);
            return false;
        }
        String stringExtra = getIntent().getStringExtra("device_id");
        String stringExtra2 = getIntent().getStringExtra("device_type");
        C41980dg c41980dg = new C41980dg();
        c41980dg.cwu.ceI = stringExtra;
        c41980dg.cwu.cws = stringExtra2;
        C4879a.xxA.mo10055m(c41980dg);
        boolean z = c41980dg.cwv.cww;
        AppMethodBeat.m2505o(23924);
        return z;
    }

    /* renamed from: a */
    private void m57041a(C16527d c16527d, boolean z) {
        AppMethodBeat.m2504i(23925);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("contact_info_locate");
        bbo bbo = new bbo();
        bbo.gvb = c16527d.field_brandFlag;
        bbo.jBB = this.ehM.field_username;
        if (NewBizInfoSettingUI.m57039Bd(this.gwP)) {
            C9638aw.m17190ZK();
            C18628c.m29077XL().mo7920c(new C3465a(58, bbo));
        } else {
            C9638aw.m17190ZK();
            C18628c.m29077XL().mo7920c(new C3465a(47, bbo));
        }
        C41747z.aeR().mo10103c(c16527d, new String[0]);
        checkBoxPreference.uOT = c16527d.adH();
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.uOT = c16527d.adI();
        }
        if (z) {
            initView();
            this.ehK.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(23925);
    }

    /* renamed from: jO */
    private void m57049jO(boolean z) {
        AppMethodBeat.m2504i(23926);
        if (this.ehM != null) {
            if (this.ehZ == null) {
                this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_is_mute");
            if (z && this.pkW != null && this.pkW.adM()) {
                setTitleMuteIconVisibility(0);
                if (checkBoxPreference != null) {
                    this.ehZ.edit().putBoolean("contact_is_mute", true).commit();
                }
            } else {
                setTitleMuteIconVisibility(8);
                if (checkBoxPreference != null) {
                    this.ehZ.edit().putBoolean("contact_is_mute", false).commit();
                }
            }
            if (checkBoxPreference != null) {
                checkBoxPreference.uOT = z;
                this.ehK.notifyDataSetChanged();
            }
        }
        AppMethodBeat.m2505o(23926);
    }

    /* renamed from: Bd */
    private static boolean m57039Bd(int i) {
        if (i == 81 || i == 92 || i == 93 || i == 94) {
            return true;
        }
        return false;
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8522b7;
    }

    /* renamed from: jT */
    private void m57050jT(boolean z) {
        AppMethodBeat.m2504i(23928);
        if (this.ehM == null) {
            AppMethodBeat.m2505o(23928);
            return;
        }
        if (this.pkW != null && this.pkW.adM()) {
            byj byj = new byj();
            byj.wXG = this.ehM.mo16673DX() ? 1 : 0;
            byj.Scene = getIntent().getIntExtra("key_start_biz_profile_setting_from_scene", 0);
            C41747z.afc();
            C25767k.m40972a(this.ehM.field_username, byj, z ? 15 : 16);
        }
        AppMethodBeat.m2505o(23928);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        Intent intent;
        AppMethodBeat.m2504i(23927);
        String str = preference.mKey;
        C4990ab.m7416i("MicroMsg.mmui.MMPreference", str + " item has been clicked!");
        if ("contact_info_locate".endsWith(str)) {
            final C16527d c16527d = this.pkW;
            if (c16527d == null) {
                AppMethodBeat.m2505o(23927);
                return true;
            }
            if (c16527d.adI()) {
                c16527d.field_brandFlag &= -5;
            } else {
                this.pmG = C30379h.m48440a((Context) this, getString(C25738R.string.ak4, new Object[]{this.ehM.mo16707Oj()}), getString(C25738R.string.f9238tz), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(23913);
                        c16527d.field_hadAlert = 1;
                        c16527d.field_brandFlag |= 4;
                        NewBizInfoSettingUI.m57042a(NewBizInfoSettingUI.this, c16527d, true);
                        C34739c.m57055cP(NewBizInfoSettingUI.this.ehM.field_username, 906);
                        AppMethodBeat.m2505o(23913);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(23914);
                        c16527d.field_hadAlert = 1;
                        NewBizInfoSettingUI.m57042a(NewBizInfoSettingUI.this, c16527d, false);
                        AppMethodBeat.m2505o(23914);
                    }
                });
            }
            m57041a(c16527d, false);
            if (((CheckBoxPreference) c15541f.aqO("contact_info_locate")).isChecked()) {
                C34739c.m57055cP(this.ehM.field_username, 905);
            } else {
                C34739c.m57055cP(this.ehM.field_username, 907);
            }
        }
        if ("contact_info_expose_btn".equals(str)) {
            if (!(this.ehM == null || C5046bo.isNullOrNil(this.ehM.field_username))) {
                intent = new Intent();
                intent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[]{this.ehM.field_username}));
                intent.putExtra("showShare", false);
                C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
            }
            C34739c.m57055cP(this.ehM.field_username, 908);
        }
        if ("contact_info_add_shortcut_btn".equals(str)) {
            C4990ab.m7410d("MicroMsg.mmui.MMPreference", "dealAddShortcut, username = " + this.ehM.field_username);
            C42781b.m75863aa(this, this.ehM.field_username);
            C5004al.m7442n(new C287037(), 1000);
        }
        if ("contact_info_clear_msg".equals(str)) {
            if (this.pkW != null && this.pkW.adM()) {
                this.fwz = new bxk();
                this.fwz.wXv = 0;
                C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(this.ehM.field_username);
                if (aoZ != null) {
                    this.fwz.wXt = aoZ.field_unReadCount;
                }
                C7620bi Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(this.ehM.field_username);
                if (Rb != null) {
                    this.fwz.wXu = Rb.getType();
                    if (this.fwz.wXt > 0) {
                        this.fwz.wXs = ((int) (System.currentTimeMillis() - Rb.field_createTime)) / 1000;
                    }
                }
            }
            C30379h.m48466d(this, getString(C25738R.string.auc), "", getString(C25738R.string.aub), getString(C25738R.string.f9076or), new C287024(), null);
            C34739c.m57055cP(this.ehM.field_username, 909);
        }
        if ("contact_is_mute".endsWith(str)) {
            this.eif = !this.eif;
            if (this.eif) {
                C1855t.m3958o(this.ehM);
            } else {
                C1855t.m3959p(this.ehM);
            }
            m57049jO(this.eif);
        }
        if ("contact_info_template_recv".equals(str)) {
            intent = new Intent();
            intent.putExtra("enterprise_biz_name", this.pkW.field_username);
            C25985d.m41467b((Context) this, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", intent);
        }
        if ("contact_info_subscribe_bizinfo".endsWith(str)) {
            C16527d c16527d2 = this.pkW;
            if (c16527d2 == null) {
                AppMethodBeat.m2505o(23927);
                return true;
            }
            int i;
            if (c16527d2.adH()) {
                c16527d2.field_brandFlag |= 1;
                if (this.fuY == null && c16527d2 != null) {
                    this.fuY = c16527d2.mo30481cJ(false);
                }
                if (this.fuY != null && this.fuY.aeb() && C25985d.afj("brandservice")) {
                    c15541f.mo27715ce("contact_info_template_recv", false);
                } else {
                    c15541f.mo27715ce("contact_info_template_recv", true);
                }
            } else {
                c16527d2.field_brandFlag &= -2;
                c15541f.mo27715ce("contact_info_template_recv", true);
            }
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[4];
            objArr[0] = c16527d2.field_username;
            objArr[1] = Integer.valueOf(1);
            if (c16527d2.adH()) {
                i = 3;
            } else {
                i = 4;
            }
            objArr[2] = Integer.valueOf(i);
            objArr[3] = Integer.valueOf(0);
            c7060h.mo8381e(13307, objArr);
            m57041a(c16527d2, false);
            if (((CheckBoxPreference) c15541f.aqO("contact_info_subscribe_bizinfo")).isChecked()) {
                C34739c.m57055cP(this.ehM.field_username, 901);
            } else {
                C34739c.m57055cP(this.ehM.field_username, 902);
            }
        }
        AppMethodBeat.m2505o(23927);
        return false;
    }

    /* renamed from: b */
    static /* synthetic */ void m57043b(NewBizInfoSettingUI newBizInfoSettingUI) {
        AppMethodBeat.m2504i(23930);
        final boolean z = newBizInfoSettingUI.pkW != null && newBizInfoSettingUI.pkW.adN();
        final String str = newBizInfoSettingUI.ehM.field_username;
        C9638aw.m17190ZK();
        C7620bi Ra = C18628c.m29080XO().mo15247Ra(str);
        C9638aw.m17190ZK();
        C18628c.m29077XL().mo7920c(new C45177d(str, Ra.field_msgSvrId));
        newBizInfoSettingUI.isDeleteCancel = false;
        newBizInfoSettingUI.getString(C25738R.string.f9238tz);
        newBizInfoSettingUI.tipDialog = C30379h.m48458b((Context) newBizInfoSettingUI, newBizInfoSettingUI.getString(C25738R.string.f9260un), true, new C128645());
        C1829bf.m3741a(str, new C1827a() {
            /* renamed from: JU */
            public final boolean mo5405JU() {
                AppMethodBeat.m2504i(23917);
                boolean e = NewBizInfoSettingUI.this.isDeleteCancel;
                AppMethodBeat.m2505o(23917);
                return e;
            }

            /* renamed from: JV */
            public final void mo5406JV() {
                AppMethodBeat.m2504i(23918);
                if (NewBizInfoSettingUI.this.tipDialog != null) {
                    NewBizInfoSettingUI.this.tipDialog.dismiss();
                    NewBizInfoSettingUI.this.tipDialog = null;
                }
                if (z) {
                    C1720g.m3528K(C8939o.class);
                    C40631p.aok(str);
                }
                AppMethodBeat.m2505o(23918);
            }
        });
        C41747z.aeX().mo64098QS(str);
        AppMethodBeat.m2505o(23930);
    }

    /* renamed from: c */
    static /* synthetic */ void m57044c(NewBizInfoSettingUI newBizInfoSettingUI) {
        AppMethodBeat.m2504i(23931);
        if (!(newBizInfoSettingUI.ehM == null || newBizInfoSettingUI.pkW == null || !newBizInfoSettingUI.pkW.adM())) {
            C41747z.afc();
            C25767k.m40970a(newBizInfoSettingUI.ehM.field_username, 17, 0, 0.0f, 0.0f, 0, null, 0, newBizInfoSettingUI.fwz, null);
        }
        AppMethodBeat.m2505o(23931);
    }
}
