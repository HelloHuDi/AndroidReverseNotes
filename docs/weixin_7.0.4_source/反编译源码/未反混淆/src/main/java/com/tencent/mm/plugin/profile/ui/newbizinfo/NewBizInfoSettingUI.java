package com.tencent.mm.plugin.profile.ui.newbizinfo;

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
import com.tencent.mm.R;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.k;
import com.tencent.mm.aj.o;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.protocal.protobuf.bbo;
import com.tencent.mm.protocal.protobuf.bxk;
import com.tencent.mm.protocal.protobuf.byj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.smtt.sdk.WebView;

public class NewBizInfoSettingUI extends MMPreference {
    private f ehK;
    private ad ehM;
    private SharedPreferences ehZ = null;
    private boolean eif;
    private b fuY;
    private bxk fwz;
    private int gwP;
    private boolean isDeleteCancel = false;
    private d pkW;
    c pmG = null;
    private p tipDialog = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(NewBizInfoSettingUI newBizInfoSettingUI, d dVar, boolean z) {
        AppMethodBeat.i(23929);
        newBizInfoSettingUI.a(dVar, z);
        AppMethodBeat.o(23929);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(23920);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        xE(a.ppL);
        setMMTitle((int) R.string.av2);
        ta(WebView.NIGHT_MODE_COLOR);
        dyb();
        pO(false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(23912);
                NewBizInfoSettingUI.this.finish();
                AppMethodBeat.o(23912);
                return true;
            }
        }, R.raw.actionbar_icon_dark_back);
        String nullAsNil = bo.nullAsNil(getIntent().getStringExtra("Contact_User"));
        aw.ZK();
        this.ehM = com.tencent.mm.model.c.XM().aoO(nullAsNil);
        this.pkW = com.tencent.mm.aj.f.qX(nullAsNil);
        String str = "MicroMsg.mmui.MMPreference";
        String str2 = "user:%s contact:%b, bizInfo:%b";
        Object[] objArr = new Object[3];
        objArr[0] = nullAsNil;
        objArr[1] = Boolean.valueOf(this.ehM != null);
        if (this.pkW != null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        this.gwP = getIntent().getIntExtra("Contact_Scene", 9);
        initView();
        jT(true);
        AppMethodBeat.o(23920);
    }

    public void onDestroy() {
        AppMethodBeat.i(23921);
        super.onDestroy();
        jT(false);
        AppMethodBeat.o(23921);
    }

    public final void initView() {
        AppMethodBeat.i(23922);
        if (this.pkW != null) {
            this.fuY = this.pkW.cJ(false);
        }
        if (this.pkW == null) {
            this.ehK.ce("contact_is_mute", true);
        } else if (this.pkW.adM()) {
            this.ehK.ce("contact_is_mute", false);
        } else {
            this.ehK.ce("contact_is_mute", true);
        }
        this.eif = this.ehM.DX();
        jO(this.eif);
        ab.d("MicroMsg.mmui.MMPreference", "KIsardDevice(%b)", Boolean.valueOf(getIntent().getBooleanExtra("KIsHardDevice", false)));
        CheckBoxPreference checkBoxPreference;
        if (getIntent() == null || !getIntent().getBooleanExtra("KIsHardDevice", false)) {
            if (!a.jh(this.ehM.field_type)) {
                ab.w("MicroMsg.mmui.MMPreference", "%s is not my contact", this.ehM.field_username);
                caU();
                if (Bd(this.gwP)) {
                    if (this.pkW == null) {
                        ab.e("MicroMsg.mmui.MMPreference", "bizinfo is null in temp session");
                        AppMethodBeat.o(23922);
                        return;
                    }
                    ((CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo")).uOT = this.pkW.adH();
                    this.ehK.ce("contact_info_subscribe_bizinfo", false);
                }
            } else if (this.pkW != null) {
                ((CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo")).uOT = this.pkW.adH();
                if (this.pkW.adH()) {
                    if (this.fuY == null && this.pkW != null) {
                        this.fuY = this.pkW.cJ(false);
                    }
                    if (this.fuY != null && this.fuY.aeb() && com.tencent.mm.bp.d.afj("brandservice")) {
                        this.ehK.ce("contact_info_template_recv", false);
                    } else {
                        this.ehK.ce("contact_info_template_recv", true);
                    }
                } else {
                    this.ehK.ce("contact_info_template_recv", true);
                }
                checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_locate");
                if (this.pkW.cJ(false).adL()) {
                    checkBoxPreference.uOT = this.pkW.adI();
                    AppMethodBeat.o(23922);
                    return;
                }
                this.ehK.ce("contact_info_locate", true);
                checkBoxPreference.uOT = this.pkW.adI();
                AppMethodBeat.o(23922);
                return;
            }
            AppMethodBeat.o(23922);
            return;
        }
        ab.d("MicroMsg.mmui.MMPreference", "Hard device biz...");
        ab.d("MicroMsg.mmui.MMPreference", "contact.isContact()(%b), isHardDeviceBound(%b)", Boolean.valueOf(a.jh(this.ehM.field_type)), Boolean.valueOf(caW()));
        if (!a.jh(this.ehM.field_type) || !r0) {
            ab.w("MicroMsg.mmui.MMPreference", "%s is not my hard biz contact", this.ehM.field_username);
            caU();
            if (Bd(this.gwP)) {
                if (this.pkW == null) {
                    ab.e("MicroMsg.mmui.MMPreference", "bizinfo is null in temp session");
                    AppMethodBeat.o(23922);
                    return;
                }
                ((CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo")).uOT = this.pkW.adH();
                this.ehK.ce("contact_info_subscribe_bizinfo", false);
            }
            AppMethodBeat.o(23922);
        } else if (this.pkW != null) {
            ((CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo")).uOT = this.pkW.adH();
            checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_locate");
            if (this.pkW.cJ(false).adL()) {
                checkBoxPreference.uOT = this.pkW.adI();
            } else {
                this.ehK.ce("contact_info_locate", true);
                checkBoxPreference.uOT = this.pkW.adI();
            }
            if (this.pkW.adH()) {
                if (this.fuY == null && this.pkW != null) {
                    this.fuY = this.pkW.cJ(false);
                }
                if (this.fuY != null && this.fuY.aeb() && com.tencent.mm.bp.d.afj("brandservice")) {
                    this.ehK.ce("contact_info_template_recv", false);
                    AppMethodBeat.o(23922);
                    return;
                }
                this.ehK.ce("contact_info_template_recv", true);
                AppMethodBeat.o(23922);
                return;
            }
            this.ehK.ce("contact_info_template_recv", true);
            AppMethodBeat.o(23922);
        } else {
            this.ehK.ce("contact_info_subscribe_bizinfo", true);
            this.ehK.ce("contact_info_locate", true);
            this.ehK.ce("contact_info_template_recv", true);
            AppMethodBeat.o(23922);
        }
    }

    private void caU() {
        AppMethodBeat.i(23923);
        if (this.ehM == null || !a.jh(this.ehM.field_type) || t.nl(this.ehM.field_username) || t.nQ(this.ehM.field_username)) {
            this.ehK.ce("contact_is_mute", true);
            if (this.ehM == null || a.jh(this.ehM.field_type) || !Bd(this.gwP)) {
                this.ehK.ce("contact_info_expose_btn", true);
            } else {
                this.ehK.ce("contact_info_expose_btn", false);
            }
        } else if (this.pkW == null || !this.pkW.adM()) {
            this.ehK.ce("contact_is_mute", true);
        } else {
            this.ehK.ce("contact_is_mute", false);
        }
        this.ehK.ce("contact_info_verifyuser_weibo", true);
        this.ehK.ce("contact_info_subscribe_bizinfo", true);
        this.ehK.ce("contact_info_template_recv", true);
        this.ehK.ce("contact_info_locate", true);
        AppMethodBeat.o(23923);
    }

    private boolean caW() {
        AppMethodBeat.i(23924);
        if (getIntent() == null) {
            AppMethodBeat.o(23924);
            return false;
        }
        String stringExtra = getIntent().getStringExtra("device_id");
        String stringExtra2 = getIntent().getStringExtra("device_type");
        dg dgVar = new dg();
        dgVar.cwu.ceI = stringExtra;
        dgVar.cwu.cws = stringExtra2;
        com.tencent.mm.sdk.b.a.xxA.m(dgVar);
        boolean z = dgVar.cwv.cww;
        AppMethodBeat.o(23924);
        return z;
    }

    private void a(d dVar, boolean z) {
        AppMethodBeat.i(23925);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("contact_info_locate");
        bbo bbo = new bbo();
        bbo.gvb = dVar.field_brandFlag;
        bbo.jBB = this.ehM.field_username;
        if (Bd(this.gwP)) {
            aw.ZK();
            com.tencent.mm.model.c.XL().c(new j.a(58, bbo));
        } else {
            aw.ZK();
            com.tencent.mm.model.c.XL().c(new j.a(47, bbo));
        }
        z.aeR().c(dVar, new String[0]);
        checkBoxPreference.uOT = dVar.adH();
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.uOT = dVar.adI();
        }
        if (z) {
            initView();
            this.ehK.notifyDataSetChanged();
        }
        AppMethodBeat.o(23925);
    }

    private void jO(boolean z) {
        AppMethodBeat.i(23926);
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
        AppMethodBeat.o(23926);
    }

    private static boolean Bd(int i) {
        if (i == 81 || i == 92 || i == 93 || i == 94) {
            return true;
        }
        return false;
    }

    public final int JC() {
        return R.xml.b7;
    }

    private void jT(boolean z) {
        AppMethodBeat.i(23928);
        if (this.ehM == null) {
            AppMethodBeat.o(23928);
            return;
        }
        if (this.pkW != null && this.pkW.adM()) {
            byj byj = new byj();
            byj.wXG = this.ehM.DX() ? 1 : 0;
            byj.Scene = getIntent().getIntExtra("key_start_biz_profile_setting_from_scene", 0);
            z.afc();
            k.a(this.ehM.field_username, byj, z ? 15 : 16);
        }
        AppMethodBeat.o(23928);
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        AppMethodBeat.i(23927);
        String str = preference.mKey;
        ab.i("MicroMsg.mmui.MMPreference", str + " item has been clicked!");
        if ("contact_info_locate".endsWith(str)) {
            final d dVar = this.pkW;
            if (dVar == null) {
                AppMethodBeat.o(23927);
                return true;
            }
            if (dVar.adI()) {
                dVar.field_brandFlag &= -5;
            } else {
                this.pmG = h.a((Context) this, getString(R.string.ak4, new Object[]{this.ehM.Oj()}), getString(R.string.tz), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(23913);
                        dVar.field_hadAlert = 1;
                        dVar.field_brandFlag |= 4;
                        NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, dVar, true);
                        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(NewBizInfoSettingUI.this.ehM.field_username, 906);
                        AppMethodBeat.o(23913);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(23914);
                        dVar.field_hadAlert = 1;
                        NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, dVar, false);
                        AppMethodBeat.o(23914);
                    }
                });
            }
            a(dVar, false);
            if (((CheckBoxPreference) fVar.aqO("contact_info_locate")).isChecked()) {
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(this.ehM.field_username, 905);
            } else {
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(this.ehM.field_username, 907);
            }
        }
        if ("contact_info_expose_btn".equals(str)) {
            if (!(this.ehM == null || bo.isNullOrNil(this.ehM.field_username))) {
                intent = new Intent();
                intent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[]{this.ehM.field_username}));
                intent.putExtra("showShare", false);
                com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
            }
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(this.ehM.field_username, 908);
        }
        if ("contact_info_add_shortcut_btn".equals(str)) {
            ab.d("MicroMsg.mmui.MMPreference", "dealAddShortcut, username = " + this.ehM.field_username);
            com.tencent.mm.plugin.base.model.b.aa(this, this.ehM.field_username);
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(23919);
                    if (NewBizInfoSettingUI.this.isFinishing()) {
                        AppMethodBeat.o(23919);
                        return;
                    }
                    com.tencent.mm.plugin.base.model.b.Z(NewBizInfoSettingUI.this, NewBizInfoSettingUI.this.ehM.field_username);
                    com.tencent.mm.plugin.base.model.b.x(NewBizInfoSettingUI.this);
                    AppMethodBeat.o(23919);
                }
            }, 1000);
        }
        if ("contact_info_clear_msg".equals(str)) {
            if (this.pkW != null && this.pkW.adM()) {
                this.fwz = new bxk();
                this.fwz.wXv = 0;
                ak aoZ = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().aoZ(this.ehM.field_username);
                if (aoZ != null) {
                    this.fwz.wXt = aoZ.field_unReadCount;
                }
                bi Rb = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Rb(this.ehM.field_username);
                if (Rb != null) {
                    this.fwz.wXu = Rb.getType();
                    if (this.fwz.wXt > 0) {
                        this.fwz.wXs = ((int) (System.currentTimeMillis() - Rb.field_createTime)) / 1000;
                    }
                }
            }
            h.d(this, getString(R.string.auc), "", getString(R.string.aub), getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(23915);
                    NewBizInfoSettingUI.b(NewBizInfoSettingUI.this);
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(NewBizInfoSettingUI.this.ehM.field_username, 910);
                    NewBizInfoSettingUI.c(NewBizInfoSettingUI.this);
                    AppMethodBeat.o(23915);
                }
            }, null);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(this.ehM.field_username, 909);
        }
        if ("contact_is_mute".endsWith(str)) {
            this.eif = !this.eif;
            if (this.eif) {
                t.o(this.ehM);
            } else {
                t.p(this.ehM);
            }
            jO(this.eif);
        }
        if ("contact_info_template_recv".equals(str)) {
            intent = new Intent();
            intent.putExtra("enterprise_biz_name", this.pkW.field_username);
            com.tencent.mm.bp.d.b((Context) this, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", intent);
        }
        if ("contact_info_subscribe_bizinfo".endsWith(str)) {
            d dVar2 = this.pkW;
            if (dVar2 == null) {
                AppMethodBeat.o(23927);
                return true;
            }
            int i;
            if (dVar2.adH()) {
                dVar2.field_brandFlag |= 1;
                if (this.fuY == null && dVar2 != null) {
                    this.fuY = dVar2.cJ(false);
                }
                if (this.fuY != null && this.fuY.aeb() && com.tencent.mm.bp.d.afj("brandservice")) {
                    fVar.ce("contact_info_template_recv", false);
                } else {
                    fVar.ce("contact_info_template_recv", true);
                }
            } else {
                dVar2.field_brandFlag &= -2;
                fVar.ce("contact_info_template_recv", true);
            }
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
            Object[] objArr = new Object[4];
            objArr[0] = dVar2.field_username;
            objArr[1] = Integer.valueOf(1);
            if (dVar2.adH()) {
                i = 3;
            } else {
                i = 4;
            }
            objArr[2] = Integer.valueOf(i);
            objArr[3] = Integer.valueOf(0);
            hVar.e(13307, objArr);
            a(dVar2, false);
            if (((CheckBoxPreference) fVar.aqO("contact_info_subscribe_bizinfo")).isChecked()) {
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(this.ehM.field_username, 901);
            } else {
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(this.ehM.field_username, 902);
            }
        }
        AppMethodBeat.o(23927);
        return false;
    }

    static /* synthetic */ void b(NewBizInfoSettingUI newBizInfoSettingUI) {
        AppMethodBeat.i(23930);
        final boolean z = newBizInfoSettingUI.pkW != null && newBizInfoSettingUI.pkW.adN();
        final String str = newBizInfoSettingUI.ehM.field_username;
        aw.ZK();
        bi Ra = com.tencent.mm.model.c.XO().Ra(str);
        aw.ZK();
        com.tencent.mm.model.c.XL().c(new com.tencent.mm.az.d(str, Ra.field_msgSvrId));
        newBizInfoSettingUI.isDeleteCancel = false;
        newBizInfoSettingUI.getString(R.string.tz);
        newBizInfoSettingUI.tipDialog = h.b((Context) newBizInfoSettingUI, newBizInfoSettingUI.getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(23916);
                NewBizInfoSettingUI.this.isDeleteCancel = true;
                AppMethodBeat.o(23916);
            }
        });
        bf.a(str, new bf.a() {
            public final boolean JU() {
                AppMethodBeat.i(23917);
                boolean e = NewBizInfoSettingUI.this.isDeleteCancel;
                AppMethodBeat.o(23917);
                return e;
            }

            public final void JV() {
                AppMethodBeat.i(23918);
                if (NewBizInfoSettingUI.this.tipDialog != null) {
                    NewBizInfoSettingUI.this.tipDialog.dismiss();
                    NewBizInfoSettingUI.this.tipDialog = null;
                }
                if (z) {
                    g.K(o.class);
                    com.tencent.mm.storage.p.aok(str);
                }
                AppMethodBeat.o(23918);
            }
        });
        z.aeX().QS(str);
        AppMethodBeat.o(23930);
    }

    static /* synthetic */ void c(NewBizInfoSettingUI newBizInfoSettingUI) {
        AppMethodBeat.i(23931);
        if (!(newBizInfoSettingUI.ehM == null || newBizInfoSettingUI.pkW == null || !newBizInfoSettingUI.pkW.adM())) {
            z.afc();
            k.a(newBizInfoSettingUI.ehM.field_username, 17, 0, 0.0f, 0.0f, 0, null, 0, newBizInfoSettingUI.fwz, null);
        }
        AppMethodBeat.o(23931);
    }
}
