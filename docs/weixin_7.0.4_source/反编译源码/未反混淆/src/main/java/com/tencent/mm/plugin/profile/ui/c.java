package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.h.a;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.y;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.dc;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.g.a.of;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.i;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.preference.ButtonPreference;
import com.tencent.mm.protocal.protobuf.bbo;
import com.tencent.mm.protocal.protobuf.bxr;
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.protocal.protobuf.cfr;
import com.tencent.mm.protocal.protobuf.cfs;
import com.tencent.mm.protocal.protobuf.cwa;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class c implements f, a, n, com.tencent.mm.pluginsdk.b.a {
    MMActivity crP;
    com.tencent.mm.ui.base.preference.f ehK;
    ad ehM;
    private CheckBoxPreference ehV;
    private SharedPreferences ehZ;
    private boolean eif;
    private List<d.a> fuX;
    private b fuY;
    private boolean fvf;
    private String fvh;
    private int gwP;
    boolean isDeleteCancel;
    String mGZ;
    d pkW;
    private boolean pli;
    private String pln;
    private boolean pmA;
    private boolean pmB;
    boolean pmC;
    private int pmD;
    private String pmE;
    private boolean pmF;
    com.tencent.mm.ui.widget.a.c pmG;
    private Bundle pmH;
    SnsAdClick pmI;
    private String pmJ;
    private j pmx;
    private List<WxaEntryInfo> pmy;
    private uy pmz;
    p tipDialog;

    private c(MMActivity mMActivity) {
        this.pmz = null;
        this.pmA = false;
        this.pmB = false;
        this.fvf = false;
        this.pmC = false;
        this.pmD = 0;
        this.pmG = null;
        this.ehZ = null;
        this.pmI = null;
        this.pmJ = null;
        this.tipDialog = null;
        this.isDeleteCancel = false;
        this.crP = mMActivity;
    }

    public c(MMActivity mMActivity, String str, uy uyVar) {
        this(mMActivity);
        this.pln = str;
        this.pmz = uyVar;
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(23475);
        Intent intent;
        String adX;
        if (str == null) {
            AppMethodBeat.o(23475);
            return false;
        } else if (str.equals("contact_info_verifyuser_weibo")) {
            new com.tencent.mm.plugin.profile.ui.a.a(this.crP).fF(this.ehM.dug, this.ehM.field_username);
            AppMethodBeat.o(23475);
            return true;
        } else if ("contact_info_biz_go_chatting".endsWith(str)) {
            if (this.pmI != null) {
                of ofVar = new of();
                this.pmI.fPZ = 5;
                ofVar.cKy.cKz = this.pmI;
                com.tencent.mm.sdk.b.a.xxA.m(ofVar);
            }
            if (this.pkW == null || !(this.pkW.adP() || this.pkW.adR())) {
                intent = new Intent();
                if (this.crP.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
                    intent.setFlags(268435456);
                }
                if (this.pli) {
                    intent.putExtra("Chat_User", this.ehM.field_username);
                    intent.putExtra("Chat_Mode", 1);
                    this.crP.setResult(-1, intent);
                } else {
                    intent.putExtra("Chat_User", this.ehM.field_username);
                    intent.putExtra("Chat_Mode", 1);
                    intent.putExtra("finish_direct", true);
                    com.tencent.mm.plugin.profile.b.gkE.d(intent, this.crP);
                }
            } else {
                intent = new Intent();
                if (this.pkW.adR()) {
                    adX = this.pkW.adX();
                    if (bo.isNullOrNil(adX)) {
                        ab.w("MicroMsg.ContactWidgetBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
                        AppMethodBeat.o(23475);
                        return false;
                    }
                    intent.putExtra("enterprise_biz_name", adX);
                    intent.putExtra("enterprise_biz_display_name", s.mJ(adX));
                } else {
                    intent.putExtra("enterprise_biz_name", this.ehM.field_username);
                    intent.putExtra("enterprise_biz_display_name", s.mJ(this.ehM.field_username));
                }
                intent.addFlags(67108864);
                com.tencent.mm.bp.d.f(this.crP, ".ui.conversation.EnterpriseConversationUI", intent);
                this.crP.finish();
            }
            aV(5, null);
            AppMethodBeat.o(23475);
            return true;
        } else if ("contact_info_biz_add".endsWith(str)) {
            if (com.tencent.mm.model.gdpr.c.aaZ()) {
                com.tencent.mm.model.gdpr.c.a(this.crP, com.tencent.mm.model.gdpr.a.BIZ, this.ehM.field_username, new com.tencent.mm.model.gdpr.b() {
                    public final void kL(int i) {
                        AppMethodBeat.i(23460);
                        if (i == 0) {
                            c.this.caV();
                        }
                        AppMethodBeat.o(23460);
                    }
                });
            } else {
                caV();
            }
            if (this.pmD != 0) {
                h.pYm.e(11263, Integer.valueOf(this.pmD), this.ehM.field_username);
            }
            AppMethodBeat.o(23475);
            return true;
        } else if ("contact_info_biz_read_msg_online".endsWith(str)) {
            AppMethodBeat.o(23475);
            return true;
        } else if ("contact_info_stick_biz".equals(str)) {
            if (((CheckBoxPreference) this.ehK.aqO("contact_info_stick_biz")).isChecked()) {
                h.pYm.e(13307, this.ehM.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0));
                i.mn(this.ehM.field_username);
            } else {
                t.x(this.ehM.field_username, true);
                h.pYm.e(13307, this.ehM.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
            }
            AppMethodBeat.o(23475);
            return true;
        } else {
            String str2;
            String str3;
            if (!(!"contact_info_guarantee_info".equals(str) || this.fuY.aei() == null || bo.isNullOrNil(this.fuY.aei().fvZ))) {
                intent = new Intent();
                intent.putExtra("rawUrl", this.fuY.aei().fvZ);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                intent.putExtra("geta8key_scene", 3);
                com.tencent.mm.bp.d.b(this.crP, "webview", ".ui.tools.WebViewUI", intent);
            }
            if (str.startsWith("contact_info_bizinfo_external#")) {
                int i = bo.getInt(str.replace("contact_info_bizinfo_external#", ""), -1);
                if (i >= 0 && i < this.fuX.size()) {
                    d.a aVar = (d.a) this.fuX.get(i);
                    str2 = aVar.url;
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", str2);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("vertical_scroll", true);
                    intent2.putExtra("geta8key_scene", 3);
                    intent2.putExtra("KPublisherId", "brand_profile");
                    intent2.putExtra("prePublishId", "brand_profile");
                    if ((this.pmH != null && (this.gwP == 39 || this.gwP == 56 || this.gwP == 35)) || this.gwP == 87 || this.gwP == 89 || this.gwP == 85 || this.gwP == 88) {
                        ab.d("MicroMsg.ContactWidgetBizInfo", "from biz search.");
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("KFromBizSearch", true);
                        bundle.putBundle("KBizSearchExtArgs", this.pmH);
                        intent2.putExtra("jsapiargs", bundle);
                        int i2 = com.tencent.mm.n.a.jh(this.ehM.field_type) ? 7 : 6;
                        int identifier = this.crP.getResources().getIdentifier(aVar.fvb, "string", this.crP.getPackageName());
                        str3 = aVar.title;
                        if (identifier > 0) {
                            str3 = this.crP.getString(identifier);
                        }
                        aV(i2, str3);
                    }
                    com.tencent.mm.bp.d.b(this.crP, "webview", ".ui.tools.WebViewUI", intent2);
                    AppMethodBeat.o(23475);
                    return true;
                }
            }
            d dVar;
            Intent intent3;
            if ("contact_info_subscribe_bizinfo".endsWith(str) || "contact_info_show_brand".endsWith(str) || "contact_info_locate".endsWith(str)) {
                final d dVar2 = this.pkW;
                if (dVar2 == null) {
                    AppMethodBeat.o(23475);
                    return true;
                }
                boolean z;
                if ("contact_info_subscribe_bizinfo".endsWith(str)) {
                    if (!dVar2.adO()) {
                        if (dVar2.adH()) {
                            dVar2.field_brandFlag |= 1;
                            if (this.fuY == null && dVar2 != null) {
                                this.fuY = dVar2.cJ(false);
                            }
                            if (this.fuY != null && this.fuY.aeb() && com.tencent.mm.bp.d.afj("brandservice")) {
                                this.ehK.ce("contact_info_template_recv", false);
                            } else {
                                this.ehK.ce("contact_info_template_recv", true);
                            }
                        } else {
                            dVar2.field_brandFlag &= -2;
                            this.ehK.ce("contact_info_template_recv", true);
                        }
                        h hVar = h.pYm;
                        Object[] objArr = new Object[4];
                        objArr[0] = dVar2.field_username;
                        objArr[1] = Integer.valueOf(1);
                        objArr[2] = Integer.valueOf(dVar2.adH() ? 3 : 4);
                        objArr[3] = Integer.valueOf(0);
                        hVar.e(13307, objArr);
                    } else if (dVar2 != null) {
                        if (dVar2.adR()) {
                            aw.Rg().a(1363, (f) this);
                            final m cVar = new com.tencent.mm.plugin.profile.b.c(dVar2.field_username, ((CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo")).isChecked() ? 0 : 4);
                            aw.Rg().a(cVar, 0);
                            Context context = this.crP;
                            this.crP.getString(R.string.tz);
                            this.tipDialog = com.tencent.mm.ui.base.h.b(context, this.crP.getString(R.string.un), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(23470);
                                    aw.Rg().c(cVar);
                                    aw.Rg().b(1363, c.this);
                                    AppMethodBeat.o(23470);
                                }
                            });
                        } else if (dVar2.adP()) {
                            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo");
                            z.afa();
                            adX = dVar2.field_username;
                            if (checkBoxPreference.isChecked()) {
                                z = false;
                            } else {
                                z = true;
                            }
                            final y a = com.tencent.mm.aj.c.a(adX, z, this);
                            Context context2 = this.crP;
                            this.crP.getString(R.string.tz);
                            this.tipDialog = com.tencent.mm.ui.base.h.b(context2, this.crP.getString(R.string.un), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(23471);
                                    z.afa();
                                    com.tencent.mm.aj.c.a(a);
                                    AppMethodBeat.o(23471);
                                }
                            });
                        }
                    }
                } else if ("contact_info_show_brand".endsWith(str)) {
                    if ((dVar2.field_brandFlag & 2) == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        dVar2.field_brandFlag |= 2;
                    } else {
                        dVar2.field_brandFlag &= -3;
                    }
                } else if ("contact_info_locate".endsWith(str)) {
                    if (dVar2.adI()) {
                        dVar2.field_brandFlag &= -5;
                    } else {
                        this.pmG = com.tencent.mm.ui.base.h.a(this.crP, this.crP.getString(R.string.ak4, new Object[]{this.ehM.Oj()}), this.crP.getString(R.string.tz), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(23456);
                                dVar2.field_hadAlert = 1;
                                dVar2.field_brandFlag |= 4;
                                c.this.a(dVar2, true);
                                AppMethodBeat.o(23456);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(23467);
                                dVar2.field_hadAlert = 1;
                                c.this.a(dVar2, false);
                                AppMethodBeat.o(23467);
                            }
                        });
                    }
                }
                if (!(dVar2.adR() || dVar2.adP())) {
                    a(dVar2, false);
                }
                AppMethodBeat.o(23475);
                return true;
            } else if ("contact_info_verifyuser".endsWith(str)) {
                dVar = this.pkW;
                if (dVar == null) {
                    AppMethodBeat.o(23475);
                    return true;
                }
                b cJ = dVar.cJ(false);
                if (cJ == null) {
                    AppMethodBeat.o(23475);
                    return true;
                }
                str3 = null;
                if (cJ.aek() != null && !bo.isNullOrNil(cJ.aek().fvU)) {
                    str3 = cJ.aek().fvU;
                } else if (!(cJ.ael() == null || bo.isNullOrNil(cJ.ael().fwc))) {
                    str3 = cJ.ael().fwc;
                }
                if (!bo.isNullOrNil(str3)) {
                    intent3 = new Intent();
                    intent3.putExtra("rawUrl", str3);
                    intent3.putExtra("useJs", true);
                    intent3.putExtra("vertical_scroll", true);
                    intent3.putExtra("geta8key_scene", 3);
                    com.tencent.mm.bp.d.b(this.crP, "webview", ".ui.tools.WebViewUI", intent3);
                }
                AppMethodBeat.o(23475);
                return true;
            } else if ("contact_info_trademark".endsWith(str)) {
                dVar = this.pkW;
                if (dVar == null) {
                    AppMethodBeat.o(23475);
                    return true;
                }
                if (!(dVar.cJ(false) == null || bo.isNullOrNil(dVar.cJ(false).aed()))) {
                    intent3 = new Intent();
                    intent3.putExtra("rawUrl", dVar.cJ(false).aed());
                    intent3.putExtra("useJs", true);
                    intent3.putExtra("vertical_scroll", true);
                    intent3.putExtra("geta8key_scene", 3);
                    com.tencent.mm.bp.d.b(this.crP, "webview", ".ui.tools.WebViewUI", intent3);
                }
                AppMethodBeat.o(23475);
                return true;
            } else {
                if ("contact_is_mute".endsWith(str)) {
                    this.eif = !this.eif;
                    if (this.eif) {
                        t.o(this.ehM);
                    } else {
                        t.p(this.ehM);
                    }
                    jO(this.eif);
                }
                if ("enterprise_contact_info_enter".equals(str)) {
                    if (this.crP == null) {
                        ab.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise context is null");
                    } else if (this.pkW == null) {
                        ab.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise bizInfo is null");
                    } else {
                        intent = new Intent();
                        intent.putExtra("enterprise_biz_name", this.pkW.field_username);
                        intent.addFlags(67108864);
                        com.tencent.mm.bp.d.b(this.crP, "brandservice", ".ui.EnterpriseBizContactListUI", intent);
                    }
                }
                if ("contact_info_biz_disable".equals(str)) {
                    com.tencent.mm.ui.base.h.d(this.crP, this.crP.getString(R.string.bdm), "", this.crP.getString(R.string.bdl), this.crP.getString(R.string.or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(23468);
                            c.this.jN(false);
                            AppMethodBeat.o(23468);
                        }
                    }, null);
                }
                if ("contact_info_biz_enable".equals(str)) {
                    jN(true);
                }
                if ("contact_info_template_recv".equals(str)) {
                    intent = new Intent();
                    intent.putExtra("enterprise_biz_name", this.pkW.field_username);
                    com.tencent.mm.bp.d.b(this.crP, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", intent);
                }
                if ("contact_info_service_phone".equals(str)) {
                    Preference aqO = this.ehK.aqO("contact_info_service_phone");
                    if (!(aqO == null || aqO.getSummary() == null || bo.isNullOrNil(aqO.getSummary().toString()))) {
                        str2 = aqO.getSummary().toString();
                        com.tencent.mm.ui.base.h.a(this.crP, true, str2, "", this.crP.getString(R.string.avl), this.crP.getString(R.string.or), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(23463);
                                Intent intent = new Intent("android.intent.action.DIAL");
                                intent.setFlags(268435456);
                                intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str2).toString()));
                                if (bo.k(c.this.crP, intent)) {
                                    c.this.crP.startActivity(intent);
                                }
                                AppMethodBeat.o(23463);
                            }
                        }, null);
                    }
                }
                if ("contact_info_expose_btn".equals(str)) {
                    caX();
                }
                if (str.equals("biz_placed_to_the_top")) {
                    ab.d("MicroMsg.ContactWidgetBizInfo", "changePlacedTop");
                    if (this.ehZ == null) {
                        this.ehZ = this.crP.getSharedPreferences(this.crP.getPackageName() + "_preferences", 0);
                    }
                    if (this.ehM != null) {
                        if (this.ehM.Oe()) {
                            ab.d("MicroMsg.ContactWidgetBizInfo", "unSetPlaceTop:%s", this.ehM.field_username);
                            t.x(this.ehM.field_username, true);
                            this.ehZ.edit().putBoolean("biz_placed_to_the_top", false).commit();
                        } else {
                            i.mn(this.ehM.field_username);
                            ab.d("MicroMsg.ContactWidgetBizInfo", "setPlaceTop:%s", this.ehM.field_username);
                            this.ehZ.edit().putBoolean("biz_placed_to_the_top", true).commit();
                        }
                    }
                }
                AppMethodBeat.o(23475);
                return true;
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void jN(boolean z) {
        AppMethodBeat.i(23476);
        final m dVar = new com.tencent.mm.plugin.profile.b.d(this.pkW.field_username, !z);
        aw.Rg().a(1394, (f) this);
        aw.Rg().a(dVar, 0);
        Context context = this.crP;
        this.crP.getString(R.string.tz);
        this.tipDialog = com.tencent.mm.ui.base.h.b(context, this.crP.getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(23469);
                aw.Rg().c(dVar);
                aw.Rg().b(1394, c.this);
                AppMethodBeat.o(23469);
            }
        });
        AppMethodBeat.o(23476);
    }

    /* Access modifiers changed, original: final */
    public final void a(d dVar, boolean z) {
        AppMethodBeat.i(23477);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("contact_info_locate");
        bbo bbo = new bbo();
        bbo.gvb = dVar.field_brandFlag;
        bbo.jBB = this.ehM.field_username;
        if (Bd(this.gwP)) {
            aw.ZK();
            com.tencent.mm.model.c.XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(58, bbo));
        } else {
            aw.ZK();
            com.tencent.mm.model.c.XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(47, bbo));
        }
        z.aeR().c(dVar, new String[0]);
        checkBoxPreference.uOT = dVar.adH();
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.uOT = dVar.adI();
        }
        if (z) {
            caT();
        }
        AppMethodBeat.o(23477);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, ad adVar, boolean z, int i) {
        boolean z2;
        AppMethodBeat.i(23478);
        if (adVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (bo.nullAsNil(adVar.field_username).length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (fVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        this.ehK = fVar;
        this.ehM = adVar;
        this.pli = z;
        this.gwP = i;
        this.pmD = this.crP.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.pmI = (SnsAdClick) this.crP.getIntent().getParcelableExtra("KSnsAdTag");
        this.pmH = this.crP.getIntent().getBundleExtra("Contact_Ext_Args");
        this.pmJ = this.crP.getIntent().getStringExtra("key_add_contact_report_info");
        caT();
        String stringExtra = this.crP.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
        if (!bo.isNullOrNil(stringExtra)) {
            this.crP.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
            com.tencent.mm.ui.base.h.a(this.crP, stringExtra, "", this.crP.getString(R.string.s6), null);
        }
        if (adVar != null) {
            z.afd().qB(adVar.field_username);
            if (com.tencent.mm.aj.f.ra(adVar.field_username)) {
                stringExtra = adVar.field_username;
                if (com.tencent.mm.aj.f.kq(stringExtra)) {
                    z.aeZ();
                    com.tencent.mm.aj.a.h.a(stringExtra, (n) this);
                    stringExtra = com.tencent.mm.aj.f.qX(stringExtra).adX();
                    if (stringExtra != null) {
                        z.afd().qB(stringExtra);
                    }
                } else if (com.tencent.mm.aj.f.rc(stringExtra)) {
                    z.afa();
                    com.tencent.mm.aj.c.a(stringExtra, (f) this);
                    z.aeR();
                    stringExtra = e.qT(stringExtra);
                    if (stringExtra != null) {
                        z.afd().qB(stringExtra);
                    }
                }
            }
        }
        AppMethodBeat.o(23478);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:409:0x0858 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x084c  */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x0d88  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0c1a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0377  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0717  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x086a  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x08d8  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x095c  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x09b4  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0c1a  */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x0d88  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void caT() {
        d dVar;
        CheckBoxPreference checkBoxPreference;
        boolean z;
        Preference aqO;
        KeyValuePreference keyValuePreference;
        Bitmap i;
        String str;
        String str2;
        Object[] objArr;
        boolean z2;
        Drawable bitmapDrawable;
        CharSequence charSequence;
        IndexOutOfBoundsException e;
        int indexOf;
        int identifier;
        AppMethodBeat.i(23479);
        biV();
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.s);
        if (this.pmC) {
            this.ehK.ce("contact_info_time_expired", true);
        }
        d qX = com.tencent.mm.aj.f.qX(this.ehM.field_username);
        this.fuX = null;
        this.fuY = null;
        this.pmy = null;
        if ((qX == null || qX.cJ(false) == null) && this.pmz != null) {
            qX = new d();
            qX.field_username = this.ehM.field_username;
            qX.field_brandFlag = this.pmz.gvb;
            qX.field_brandIconURL = this.pmz.gve;
            qX.field_brandInfo = this.pmz.gvd;
            qX.field_extInfo = this.pmz.gvc;
            dVar = qX;
        } else {
            dVar = qX;
        }
        if (dVar != null && dVar.field_brandInfo == null && dVar.field_extInfo == null && this.pmz != null) {
            dVar.field_username = this.ehM.field_username;
            dVar.field_brandFlag = this.pmz.gvb;
            dVar.field_brandIconURL = this.pmz.gve;
            dVar.field_brandInfo = this.pmz.gvd;
            dVar.field_extInfo = this.pmz.gvc;
        }
        BizInfoHeaderPreference bizInfoHeaderPreference = (BizInfoHeaderPreference) this.ehK.aqO("contact_info_header_bizinfo");
        if (bizInfoHeaderPreference == null || bo.isNullOrNil(this.ehM.field_username)) {
            ab.w("MicroMsg.ContactWidgetBizInfo", "head pref is null");
            this.ehK.ce("contact_info_header_bizinfo", true);
        } else {
            bizInfoHeaderPreference.a(this.ehM, this.pln, dVar);
        }
        this.ehK.ce("biz_placed_to_the_top", true);
        this.ehK.ce("contact_info_biz_enable", true);
        this.ehK.ce("contact_info_biz_disable", true);
        this.ehK.ce("contact_info_stick_biz", true);
        if (dVar != null) {
            if (dVar.adQ()) {
                this.ehK.ce("contact_info_biz_add", true);
                this.ehK.ce("contact_info_expose_btn", true);
                this.ehK.ce("contact_is_mute", false);
                this.eif = this.ehM.DX();
                if (dVar.adR()) {
                    this.ehK.ce("contact_info_biz_go_chatting", true);
                    this.ehK.ce("contact_info_stick_biz", !com.tencent.mm.n.a.jh(this.ehM.field_type));
                    checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_stick_biz");
                    checkBoxPreference.uOT = this.ehM.Oe();
                    checkBoxPreference.setTitle((int) R.string.bdj);
                    caY();
                } else {
                    this.ehK.ce("contact_info_subscribe_bizinfo", true);
                    this.ehK.ce("contact_info_biz_go_chatting", true);
                    if (dVar.adH()) {
                        this.ehK.ce("contact_info_biz_enable", true);
                        this.ehK.ce("contact_info_biz_disable", false);
                        this.ehK.aqO("contact_info_biz_disable").setTitle((int) R.string.bdl);
                        this.ehK.ce("contact_is_mute", false);
                        this.ehK.ce("biz_placed_to_the_top", false);
                        this.ehV = (CheckBoxPreference) this.ehK.aqO("biz_placed_to_the_top");
                        this.ehV.setTitle((int) R.string.be1);
                        caY();
                        if (dVar.adS()) {
                            this.ehK.ce("contact_info_locate", true);
                        }
                    } else {
                        this.ehK.ce("contact_info_biz_enable", false);
                        this.ehK.ce("contact_info_biz_disable", true);
                        ((ButtonPreference) this.ehK.aqO("contact_info_biz_enable")).ed(this.crP.getResources().getString(R.string.bdn), this.crP.getResources().getColor(R.color.hi));
                        this.ehK.ce("contact_is_mute", true);
                        this.ehK.ce("biz_placed_to_the_top", true);
                        this.ehK.ce("contact_info_locate", true);
                    }
                }
                jO(this.eif);
            } else if (dVar.adP()) {
                this.ehK.ce("contact_info_locate", true);
                this.ehK.ce("contact_info_subscribe_bizinfo", false);
                this.ehK.ce("enterprise_contact_info_enter", false);
                ((ButtonPreference) this.ehK.aqO("contact_info_biz_go_chatting")).ed(this.crP.getResources().getString(R.string.bdo), this.crP.getResources().getColor(R.color.hi));
                this.ehK.ce("contact_info_stick_biz", !com.tencent.mm.n.a.jh(this.ehM.field_type));
                checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_stick_biz");
                checkBoxPreference.uOT = this.ehM.Oe();
                checkBoxPreference.setTitle((int) R.string.bdr);
                caY();
                this.ehK.ce("contact_is_mute", true);
                this.eif = this.ehM.DX();
                jO(this.eif);
                this.ehK.aqO("contact_is_mute").setSummary((int) R.string.avp);
            } else {
                com.tencent.mm.ui.base.preference.f fVar = this.ehK;
                String str3 = "contact_info_stick_biz";
                z = t.nl(this.ehM.field_username) || !com.tencent.mm.n.a.jh(this.ehM.field_type);
                fVar.ce(str3, z);
                ((CheckBoxPreference) this.ehK.aqO("contact_info_stick_biz")).uOT = this.ehM.Oe();
                this.ehK.ce("contact_is_mute", true);
                this.eif = false;
            }
            this.pkW = dVar;
            this.fuX = dVar.adY();
            this.fuY = dVar.cJ(false);
            this.pmy = this.fuY.getWxaEntryInfoList();
            if (this.fuY.adZ()) {
                this.ehK.aqO("near_field_service").setSummary((int) R.string.g0r);
            } else {
                this.ehK.ce("near_field_service", true);
            }
            if (this.fuY.aef() != null) {
                this.pmB = true;
                if (UQ(this.fuY.aef())) {
                    this.pmA = true;
                    if (!com.tencent.mm.n.a.jh(this.ehM.field_type)) {
                        ab.w("MicroMsg.ContactWidgetBizInfo", "expireTime not null, and %s is not my contact", this.ehM.field_username);
                        caU();
                        if (t.nG(this.ehM.field_username) || t.nQ(this.ehM.field_username)) {
                            caU();
                        }
                    }
                }
                this.ehK.ce("contact_info_time_expired", true);
                caU();
            } else {
                this.ehK.ce("contact_info_time_expired", true);
            }
            if (this.fuY.aec() != null && this.fuY.aec().length() > 0) {
                this.fvh = this.fuY.aec();
            }
            this.fvf = this.fuY.aea();
            if (bo.isNullOrNil(this.fuY.aep())) {
                this.ehK.ce("contact_info_service_phone", true);
            } else {
                this.ehK.ce("contact_info_service_phone", false);
                aqO = this.ehK.aqO("contact_info_service_phone");
                if (aqO != null) {
                    aqO.setSummary(this.fuY.aep());
                    aqO.ksd = this.crP.getResources().getColor(R.color.t7);
                }
            }
        } else {
            this.ehK.ce("contact_info_time_expired", true);
            ab.e("MicroMsg.ContactWidgetBizInfo", "get biz info from storage, but return null");
        }
        if (bo.isNullOrNil(this.ehM.signature)) {
            ab.w("MicroMsg.ContactWidgetBizInfo", "has not desc info");
            this.ehK.ce("contact_info_user_desc", true);
            if (!this.pmA) {
                this.ehK.ce("contact_info_time_expired", true);
            }
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_user_desc");
            if (keyValuePreference != null) {
                if (bo.nullAsNil(this.ehM.signature).trim().length() <= 0) {
                    this.ehK.ce("contact_info_user_desc", true);
                } else {
                    keyValuePreference.yCj = false;
                    keyValuePreference.ylA = this.crP.getString(R.string.aww);
                    keyValuePreference.setSummary((CharSequence) com.tencent.mm.pluginsdk.ui.e.j.b(this.crP, this.ehM.signature));
                    keyValuePreference.qi(false);
                    if (ao.a.flw != null) {
                        i = BackwardSupportUtil.b.i(ao.a.flw.ky(this.ehM.field_verifyFlag), 2.0f);
                    } else {
                        i = null;
                    }
                    str = "MicroMsg.ContactWidgetBizInfo";
                    str2 = "verify bmp is null ? %B";
                    objArr = new Object[1];
                    if (i == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr[0] = Boolean.valueOf(z2);
                    ab.i(str, str2, objArr);
                    if (i != null) {
                        bitmapDrawable = new BitmapDrawable(this.crP.getResources(), i);
                    } else {
                        bitmapDrawable = null;
                    }
                    keyValuePreference.yCr = bitmapDrawable;
                    keyValuePreference.yCp = 8;
                    keyValuePreference.NW(8);
                }
            }
        }
        if (this.fuY != null && this.fuY.aek() != null && !bo.isNullOrNil(this.fuY.aek().fvS)) {
            b.d aek = this.fuY.aek();
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_verifyuser");
            if (keyValuePreference != null) {
                Bitmap i2;
                keyValuePreference.yCj = false;
                if (bo.isNullOrNil(aek.fvT)) {
                    keyValuePreference.ylA = Bc(aek.fvR);
                } else {
                    keyValuePreference.ylA = aek.fvT;
                }
                if (ao.a.flw != null) {
                    i2 = BackwardSupportUtil.b.i(ao.a.flw.ky(this.ehM.field_verifyFlag), 2.0f);
                } else {
                    i2 = null;
                }
                if (i2 != null) {
                    bitmapDrawable = new BitmapDrawable(this.crP.getResources(), i2);
                } else {
                    bitmapDrawable = null;
                }
                str2 = "MicroMsg.ContactWidgetBizInfo";
                String str4 = "verify bmp is null ? %B";
                Object[] objArr2 = new Object[1];
                if (i2 == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr2[0] = Boolean.valueOf(z2);
                ab.i(str2, str4, objArr2);
                keyValuePreference.yCr = bitmapDrawable;
                if (aek.fvS != null) {
                    str2 = aek.fvV;
                    CharSequence b = com.tencent.mm.pluginsdk.ui.e.j.b(this.crP, aek.fvS.trim());
                    if (bo.isNullOrNil(str2)) {
                        charSequence = b;
                    } else {
                        try {
                            charSequence = new SpannableString(str2 + " " + b);
                            try {
                                charSequence.setSpan(new ForegroundColorSpan(-36352), 0, str2.length(), 17);
                            } catch (IndexOutOfBoundsException e2) {
                                e = e2;
                                ab.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", e.getMessage());
                                keyValuePreference.setSummary(charSequence);
                                if (this.fuY != null) {
                                }
                                ab.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
                                this.ehK.ce("contact_info_trademark", true);
                                if (this.fuY != null) {
                                }
                                this.ehK.ce("contact_info_privilege", true);
                                indexOf = this.ehK.indexOf("contact_info_category2");
                                if (indexOf >= 0) {
                                }
                                ab.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
                                if (!this.pmA) {
                                }
                                this.ehK.ce("contact_info_verifyuser_weibo", true);
                                if (this.fuY != null) {
                                }
                                this.ehK.ce("contact_info_reputation", true);
                                this.ehK.ce("contact_info_guarantee_info", true);
                                this.ehK.ce("contact_info_scope_of_business", true);
                                if (this.pmy != null) {
                                }
                                this.ehK.ce("contact_info_bindwxainfo", true);
                                UR(this.crP.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
                                ab.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", Boolean.valueOf(this.crP.getIntent().getBooleanExtra("KIsHardDevice", false)));
                                if (this.crP.getIntent() == null) {
                                }
                                if (com.tencent.mm.n.a.jh(this.ehM.field_type)) {
                                }
                            }
                        } catch (IndexOutOfBoundsException e3) {
                            e = e3;
                            charSequence = b;
                            ab.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", e.getMessage());
                            keyValuePreference.setSummary(charSequence);
                            if (this.fuY != null) {
                            }
                            ab.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
                            this.ehK.ce("contact_info_trademark", true);
                            if (this.fuY != null) {
                            }
                            this.ehK.ce("contact_info_privilege", true);
                            indexOf = this.ehK.indexOf("contact_info_category2");
                            if (indexOf >= 0) {
                            }
                            ab.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
                            if (this.pmA) {
                            }
                            this.ehK.ce("contact_info_verifyuser_weibo", true);
                            if (this.fuY != null) {
                            }
                            this.ehK.ce("contact_info_reputation", true);
                            this.ehK.ce("contact_info_guarantee_info", true);
                            this.ehK.ce("contact_info_scope_of_business", true);
                            if (this.pmy != null) {
                            }
                            this.ehK.ce("contact_info_bindwxainfo", true);
                            UR(this.crP.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
                            ab.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", Boolean.valueOf(this.crP.getIntent().getBooleanExtra("KIsHardDevice", false)));
                            if (this.crP.getIntent() == null) {
                            }
                            if (com.tencent.mm.n.a.jh(this.ehM.field_type)) {
                            }
                        }
                    }
                    keyValuePreference.setSummary(charSequence);
                } else {
                    ab.e("MicroMsg.ContactWidgetBizInfo", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
                }
            } else {
                this.ehK.ce("contact_info_verifyuser", true);
            }
        } else if (this.fuY == null || this.fuY.ael() == null || bo.isNullOrNil(this.fuY.ael().fwb)) {
            ab.w("MicroMsg.ContactWidgetBizInfo", "has not verify info");
            this.ehK.ce("contact_info_verifyuser", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_verifyuser");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary((CharSequence) this.fuY.ael().fwb);
            }
        }
        if (this.fuY != null || bo.isNullOrNil(this.fuY.aee())) {
            ab.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
            this.ehK.ce("contact_info_trademark", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_trademark");
            if (keyValuePreference != null) {
                keyValuePreference.yCj = false;
                if (ao.a.flw != null) {
                    i = com.tencent.mm.sdk.platformtools.d.LV(R.raw.biz_info_trademark_protection);
                } else {
                    i = null;
                }
                str = "MicroMsg.ContactWidgetBizInfo";
                str2 = "trademark bmp is null ? %B";
                objArr = new Object[1];
                if (i == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                ab.i(str, str2, objArr);
                if (i != null) {
                    bitmapDrawable = new BitmapDrawable(this.crP.getResources(), i);
                } else {
                    bitmapDrawable = null;
                }
                keyValuePreference.yCr = bitmapDrawable;
                keyValuePreference.setSummary((CharSequence) this.fuY.aee());
                ab.d("MicroMsg.ContactWidgetBizInfo", "trademark name : %s, url : %s.", this.fuY.aee(), this.fuY.aed());
            }
        }
        if (this.fuY != null || this.fuY.aeg() == null || this.fuY.aeg().size() <= 0) {
            this.ehK.ce("contact_info_privilege", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_privilege");
            keyValuePreference.qi(false);
            keyValuePreference.dAC();
            for (b.f fVar2 : this.fuY.aeg()) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this.crP, R.layout.a9b, null);
                ((ImageView) linearLayout.findViewById(R.id.aga)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.c(this.crP.getResources(), fVar2.iconUrl));
                CharSequence charSequence2 = fVar2.description;
                identifier = this.crP.getResources().getIdentifier(fVar2.fwa, "string", this.crP.getPackageName());
                if (identifier > 0) {
                    charSequence2 = this.crP.getString(identifier);
                }
                ((TextView) linearLayout.findViewById(R.id.a81)).setText(charSequence2);
                keyValuePreference.eI(linearLayout);
            }
        }
        indexOf = this.ehK.indexOf("contact_info_category2");
        if (indexOf >= 0 || this.fuX == null || this.fuX.size() <= 0) {
            ab.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
        } else {
            int size = this.fuX.size() - 1;
            while (size >= 0) {
                if (this.fuX.get(size) != null && ((!this.crP.getString(R.string.auy).equals(((d.a) this.fuX.get(size)).title) || this.fvf) && !(bo.isNullOrNil(((d.a) this.fuX.get(size)).title) && bo.isNullOrNil(((d.a) this.fuX.get(size)).fvb)))) {
                    Preference preference = new Preference(this.crP);
                    preference.setKey("contact_info_bizinfo_external#".concat(String.valueOf(size)));
                    charSequence = ((d.a) this.fuX.get(size)).title;
                    int identifier2 = this.crP.getResources().getIdentifier(((d.a) this.fuX.get(size)).fvb, "string", this.crP.getPackageName());
                    if (identifier2 > 0) {
                        charSequence = this.crP.getString(identifier2);
                    }
                    if (this.pkW.adO() && ("__mp_wording__brandinfo_history_massmsg".equals(((d.a) this.fuX.get(size)).fvb) || r1.equals(this.crP.getString(R.string.__mp_wording__brandinfo_history_massmsg)))) {
                        charSequence = this.crP.getString(R.string.bdf);
                    }
                    preference.setTitle(charSequence);
                    if (!bo.isNullOrNil(((d.a) this.fuX.get(size)).description)) {
                        preference.setSummary(((d.a) this.fuX.get(size)).description);
                    }
                    if (bo.nullAsNil(((d.a) this.fuX.get(size)).fvb).equals("__mp_wording__brandinfo_feedback")) {
                        identifier2 = this.ehK.indexOf("contact_info_scope_of_business");
                        if (identifier2 > 0) {
                            identifier = identifier2 + 1;
                            this.ehK.a(preference, identifier);
                            if (!bo.nullAsNil(((d.a) this.fuX.get(size)).fvb).equals("__mp_wording__brandinfo_biz_detail")) {
                                this.ehK.a(new PreferenceSmallCategory(this.crP), identifier);
                            }
                        }
                    }
                    identifier = indexOf;
                    this.ehK.a(preference, identifier);
                    if (!bo.nullAsNil(((d.a) this.fuX.get(size)).fvb).equals("__mp_wording__brandinfo_biz_detail")) {
                    }
                }
                size--;
            }
        }
        if (this.pmA || !t.w(this.ehM) || this.ehM.dug == null || this.ehM.dug.equals("")) {
            this.ehK.ce("contact_info_verifyuser_weibo", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_verifyuser_weibo");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary((CharSequence) bo.bc(this.ehM.field_weiboNickname, "") + this.crP.getString(R.string.eai, new Object[]{t.nP(this.ehM.dug)}));
                keyValuePreference.ksd = com.tencent.mm.bz.a.i(this.crP, R.color.t7);
                keyValuePreference.qi(false);
            }
        }
        if (this.fuY != null || this.fuY.aei() == null) {
            this.ehK.ce("contact_info_reputation", true);
            this.ehK.ce("contact_info_guarantee_info", true);
            this.ehK.ce("contact_info_scope_of_business", true);
        } else {
            BizInfoPayInfoIconPreference bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.ehK.aqO("contact_info_reputation");
            if (this.fuY.aei().fvW > 0) {
                bizInfoPayInfoIconPreference.AS(this.fuY.aei().fvW);
            } else {
                this.ehK.ce("contact_info_reputation", true);
            }
            bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.ehK.aqO("contact_info_guarantee_info");
            if (this.fuY.aei().fvY == null || this.fuY.aei().fvY.size() <= 0) {
                this.ehK.ce("contact_info_guarantee_info", true);
            } else {
                bizInfoPayInfoIconPreference.cC(this.fuY.aei().fvY);
            }
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_scope_of_business");
            if (bo.isNullOrNil(this.fuY.aei().fvX)) {
                this.ehK.ce("contact_info_scope_of_business", true);
            } else {
                keyValuePreference.setSummary((CharSequence) this.fuY.aei().fvX);
                keyValuePreference.yCp = 4;
                keyValuePreference.qi(false);
            }
        }
        if (this.pmy != null || this.pmy.size() <= 0) {
            this.ehK.ce("contact_info_bindwxainfo", true);
        } else {
            this.ehK.ce("contact_info_bindwxainfo", false);
            ((BizBindWxaInfoPreference) this.ehK.aqO("contact_info_bindwxainfo")).a(this.pkW, this.pmy);
        }
        UR(this.crP.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
        ab.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", Boolean.valueOf(this.crP.getIntent().getBooleanExtra("KIsHardDevice", false)));
        CheckBoxPreference checkBoxPreference2;
        String Oj;
        if (this.crP.getIntent() == null && this.crP.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            ab.d("MicroMsg.ContactWidgetBizInfo", "Hard device biz...");
            z = caW();
            ab.d("MicroMsg.ContactWidgetBizInfo", "contact.isContact()(%b), isHardDeviceBound(%b)", Boolean.valueOf(com.tencent.mm.n.a.jh(this.ehM.field_type)), Boolean.valueOf(z));
            if (com.tencent.mm.n.a.jh(this.ehM.field_type) && z) {
                if (dVar != null) {
                    checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo");
                    checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("contact_info_locate");
                    if (dVar.adR()) {
                        this.pmx = z.aeV().cH(z.aeV().cI(dVar.field_username));
                        if (this.pmx != null) {
                            if (this.pmx.lc(4)) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            checkBoxPreference.uOT = z2;
                        } else {
                            ab.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                        }
                    } else {
                        checkBoxPreference.uOT = dVar.adH();
                    }
                    if (dVar.adH()) {
                        if (this.fuY == null && dVar != null) {
                            this.fuY = dVar.cJ(false);
                        }
                        if (this.fuY != null && this.fuY.aeb() && com.tencent.mm.bp.d.afj("brandservice")) {
                            this.ehK.ce("contact_info_template_recv", false);
                        } else {
                            this.ehK.ce("contact_info_template_recv", true);
                        }
                    } else {
                        this.ehK.ce("contact_info_template_recv", true);
                    }
                    if (dVar.cJ(false).adL()) {
                        checkBoxPreference2.uOT = dVar.adI();
                    } else {
                        this.ehK.ce("contact_info_locate", true);
                        checkBoxPreference2.uOT = dVar.adI();
                    }
                } else {
                    this.ehK.ce("contact_info_subscribe_bizinfo", true);
                    this.ehK.ce("contact_info_locate", true);
                    this.ehK.ce("contact_info_template_recv", true);
                }
                this.ehK.ce("contact_info_biz_read_msg_online", true);
                this.ehK.ce("contact_info_biz_add", true);
                Oj = this.ehM.Oj();
                if (Oj != null) {
                    this.crP.setMMTitle(Oj);
                }
                if (t.nl(this.ehM.field_username)) {
                    ((ButtonPreference) this.ehK.aqO("contact_info_biz_go_chatting")).ed(this.crP.getResources().getString(R.string.azv), this.crP.getResources().getColor(R.color.hi));
                    this.crP.setMMTitle((int) R.string.b1v);
                }
                if (!(t.nG(this.ehM.field_username) || this.pkW == null || this.pkW.adQ())) {
                    this.crP.addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            AppMethodBeat.i(23472);
                            c.a(c.this);
                            AppMethodBeat.o(23472);
                            return true;
                        }
                    });
                }
                AppMethodBeat.o(23479);
                return;
            }
            ab.w("MicroMsg.ContactWidgetBizInfo", "%s is not my hard biz contact", this.ehM.field_username);
            caU();
            Preference aqO2 = this.ehK.aqO("contact_info_biz_add");
            ab.d("MicroMsg.ContactWidgetBizInfo", "isBizConferenceAccount(%b)", Boolean.valueOf(this.pmB));
            if (aqO2 != null) {
                if (z) {
                    aqO2.setTitle((int) R.string.auh);
                } else {
                    aqO2.setTitle((int) R.string.aua);
                }
            }
            if (Bd(this.gwP)) {
                if (dVar == null) {
                    ab.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                } else {
                    ((CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo")).uOT = dVar.adH();
                    this.ehK.ce("contact_info_subscribe_bizinfo", false);
                }
            }
            this.crP.showOptionMenu(false);
            AppMethodBeat.o(23479);
        } else if (com.tencent.mm.n.a.jh(this.ehM.field_type)) {
            if (dVar != null) {
                checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo");
                checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("contact_info_locate");
                if (dVar.adR()) {
                    checkBoxPreference.setTitle((int) R.string.bdk);
                    this.pmx = z.aeV().cH(z.aeV().cI(dVar.field_username));
                    if (this.pmx != null) {
                        if (this.pmx.lc(4)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        checkBoxPreference.uOT = z2;
                    } else {
                        ab.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                    }
                } else if (dVar.adP()) {
                    checkBoxPreference.setTitle((int) R.string.bdg);
                    if (z.afa().qG(dVar.field_username)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    checkBoxPreference.uOT = z2;
                } else {
                    checkBoxPreference.uOT = dVar.adH();
                }
                if (dVar.adH()) {
                    if (this.fuY == null && dVar != null) {
                        this.fuY = dVar.cJ(false);
                    }
                    if (this.fuY != null && this.fuY.aeb() && com.tencent.mm.bp.d.afj("brandservice")) {
                        this.ehK.ce("contact_info_template_recv", false);
                    } else {
                        this.ehK.ce("contact_info_template_recv", true);
                    }
                } else {
                    this.ehK.ce("contact_info_template_recv", true);
                }
                if (dVar.cJ(false).adL()) {
                    checkBoxPreference2.uOT = dVar.adI();
                } else {
                    this.ehK.ce("contact_info_locate", true);
                    checkBoxPreference2.uOT = dVar.adI();
                }
            } else {
                this.ehK.ce("contact_info_subscribe_bizinfo", true);
                this.ehK.ce("contact_info_locate", true);
                this.ehK.ce("contact_info_template_recv", true);
            }
            this.ehK.ce("contact_info_biz_read_msg_online", true);
            this.ehK.ce("contact_info_biz_add", true);
            Oj = this.ehM.Oj();
            if (Oj != null) {
                this.crP.setMMTitle(Oj);
            }
            if (t.nl(this.ehM.field_username)) {
                ((ButtonPreference) this.ehK.aqO("contact_info_biz_go_chatting")).ed(this.crP.getResources().getString(R.string.azv), this.crP.getResources().getColor(R.color.hi));
                this.crP.setMMTitle((int) R.string.b1v);
            }
            if (!(t.nG(this.ehM.field_username) || this.pkW == null)) {
                this.crP.addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(23473);
                        c.a(c.this);
                        AppMethodBeat.o(23473);
                        return true;
                    }
                });
            }
            AppMethodBeat.o(23479);
        } else {
            ab.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", this.ehM.field_username);
            caU();
            aqO = this.ehK.aqO("contact_info_biz_add");
            if (aqO != null && this.pmB) {
                aqO.setTitle((int) R.string.auh);
            }
            if (Bd(this.gwP)) {
                if (dVar == null) {
                    ab.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                } else {
                    ((CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo")).uOT = dVar.adH();
                    this.ehK.ce("contact_info_subscribe_bizinfo", false);
                }
            }
            this.crP.showOptionMenu(false);
            AppMethodBeat.o(23479);
        }
    }

    private String Bc(int i) {
        AppMethodBeat.i(23480);
        String string;
        switch (i) {
            case 0:
                string = this.crP.getResources().getString(R.string.b24);
                AppMethodBeat.o(23480);
                return string;
            case 1:
                string = this.crP.getResources().getString(R.string.abf);
                AppMethodBeat.o(23480);
                return string;
            case 2:
                string = this.crP.getResources().getString(R.string.abg);
                AppMethodBeat.o(23480);
                return string;
            default:
                ab.w("MicroMsg.ContactWidgetBizInfo", "getVerifyStr, error type %d", Integer.valueOf(i));
                string = this.crP.getResources().getString(R.string.aww);
                AppMethodBeat.o(23480);
                return string;
        }
    }

    private void caU() {
        AppMethodBeat.i(23481);
        if (this.ehM == null || !com.tencent.mm.n.a.jh(this.ehM.field_type) || t.nl(this.ehM.field_username) || t.nQ(this.ehM.field_username)) {
            this.ehK.ce("contact_is_mute", true);
            if (this.ehM == null || com.tencent.mm.n.a.jh(this.ehM.field_type) || !Bd(this.gwP)) {
                this.ehK.ce("contact_info_expose_btn", true);
            } else {
                this.ehK.ce("contact_info_expose_btn", false);
            }
        } else {
            this.ehK.ce("contact_is_mute", false);
        }
        this.ehK.ce("contact_info_verifyuser_weibo", true);
        this.ehK.ce("contact_info_subscribe_bizinfo", true);
        this.ehK.ce("contact_info_template_recv", true);
        this.ehK.ce("contact_info_locate", true);
        if (this.pmA) {
            this.ehK.ce("contact_info_biz_add", true);
        } else {
            this.ehK.ce("contact_info_time_expired", true);
        }
        if (this.ehM == null || !((t.nG(this.ehM.field_username) || t.nQ(this.ehM.field_username)) && com.tencent.mm.n.a.jh(this.ehM.field_type))) {
            this.ehK.ce("contact_info_biz_go_chatting", true);
        } else {
            this.ehK.ce("contact_info_biz_go_chatting", false);
        }
        if (t.nQ(this.ehM.field_username)) {
            this.ehK.ce("contact_info_user_desc", true);
        }
        AppMethodBeat.o(23481);
    }

    public final boolean biV() {
        AppMethodBeat.i(23482);
        BizInfoHeaderPreference bizInfoHeaderPreference = (BizInfoHeaderPreference) this.ehK.aqO("contact_info_header_bizinfo");
        if (bizInfoHeaderPreference != null) {
            bizInfoHeaderPreference.onDetach();
        }
        AppMethodBeat.o(23482);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(23483);
        if (this.crP == null) {
            ab.e("MicroMsg.ContactWidgetBizInfo", "null == context");
            AppMethodBeat.o(23483);
            return;
        }
        ab.i("MicroMsg.ContactWidgetBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 != -1 || intent == null) {
                    AppMethodBeat.o(23483);
                    return;
                }
                String stringExtra = intent.getStringExtra("be_send_card_name");
                String stringExtra2 = intent.getStringExtra("received_card_name");
                boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                String stringExtra3 = intent.getStringExtra("custom_send_text");
                g.bOk().q(stringExtra, stringExtra2, booleanExtra);
                g.bOk().eZ(stringExtra3, stringExtra2);
                com.tencent.mm.ui.widget.snackbar.b.i(this.crP, this.crP.getString(R.string.bvk));
                AppMethodBeat.o(23483);
                return;
            default:
                AppMethodBeat.o(23483);
                return;
        }
    }

    private static boolean UQ(String str) {
        AppMethodBeat.i(23484);
        try {
            long j = bo.getLong(str, 0);
            if (j <= 0 || j - (System.currentTimeMillis() / 1000) >= 0) {
                AppMethodBeat.o(23484);
                return false;
            }
            AppMethodBeat.o(23484);
            return true;
        } catch (Exception e) {
            AppMethodBeat.o(23484);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final void aV(int i, String str) {
        AppMethodBeat.i(23485);
        if (this.pmH == null || !(this.gwP == 39 || this.gwP == 56 || this.gwP == 35 || this.gwP == 87 || this.gwP == 88 || this.gwP == 89 || this.gwP == 85)) {
            ab.d("MicroMsg.ContactWidgetBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
            AppMethodBeat.o(23485);
        } else if (this.ehM == null) {
            ab.i("MicroMsg.ContactWidgetBizInfo", "contact is null.");
            AppMethodBeat.o(23485);
        } else {
            int i2;
            String string = this.pmH.getString("Contact_Ext_Args_Search_Id");
            String nullAsNil = bo.nullAsNil(this.pmH.getString("Contact_Ext_Args_Query_String"));
            int i3 = this.pmH.getInt("Contact_Ext_Args_Index");
            switch (this.gwP) {
                case 35:
                    i2 = 1;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.l.i.CTRL_INDEX /*85*/:
                    i2 = 5;
                    break;
                case com.tencent.view.d.MIC_COLORPENCIL /*87*/:
                    i2 = 2;
                    break;
                case 88:
                    i2 = 3;
                    break;
                case PlayerException.EXCEPTION_IN_CHECK_STATE /*89*/:
                    i2 = 4;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            String nullAsNil2 = bo.nullAsNil(this.pmH.getString("Contact_Ext_Extra_Params"));
            String str2 = nullAsNil + "," + i + "," + bo.nullAsNil(this.ehM.field_username) + "," + i3 + "," + (System.currentTimeMillis() / 1000) + "," + string + "," + i2;
            if (bo.isNullOrNil(str)) {
                str2 = str2 + ",," + nullAsNil2;
            } else {
                str2 = str2 + "," + str + "," + nullAsNil2;
            }
            ab.v("MicroMsg.ContactWidgetBizInfo", "report 10866: %s", str2);
            h.pYm.X(10866, str2);
            AppMethodBeat.o(23485);
        }
    }

    /* Access modifiers changed, original: final */
    public final void caV() {
        AppMethodBeat.i(23486);
        if (this.crP.getIntent() != null && this.crP.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            String stringExtra = this.crP.getIntent().getStringExtra("KHardDeviceBindTicket");
            if (bo.isNullOrNil(stringExtra)) {
                ab.i("MicroMsg.ContactWidgetBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
            } else if (!caW()) {
                ab.d("MicroMsg.ContactWidgetBizInfo", "IsHardDevice, bindTicket = %s", stringExtra);
                aw.Rg().a(536, (f) this);
                dc dcVar = new dc();
                dcVar.cwj.cwl = stringExtra;
                dcVar.cwj.opType = 1;
                com.tencent.mm.sdk.b.a.xxA.m(dcVar);
                final m mVar = dcVar.cwk.cwn;
                Context context = this.crP;
                this.crP.getString(R.string.tz);
                this.tipDialog = com.tencent.mm.ui.base.h.b(context, this.crP.getString(R.string.un), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(23461);
                        aw.Rg().b(536, c.this);
                        dc dcVar = new dc();
                        dcVar.cwj.opType = 2;
                        dcVar.cwj.cwn = mVar;
                        com.tencent.mm.sdk.b.a.xxA.m(dcVar);
                        AppMethodBeat.o(23461);
                    }
                });
                AppMethodBeat.o(23486);
                return;
            }
        }
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.crP, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
            /* JADX WARNING: Missing block: B:62:0x021f, code skipped:
            if (r3 == false) goto L_0x011b;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(boolean z, boolean z2, String str, String str2) {
                AppMethodBeat.i(23462);
                if (z) {
                    d qX;
                    com.tencent.mm.ui.base.h.bQ(c.this.crP, c.this.crP.getString(R.string.au5));
                    c.this.ehK.ce("contact_info_time_expired", true);
                    ad adVar = c.this.ehM;
                    if (adVar == null || bo.isNullOrNil(str)) {
                        ab.e("MicroMsg.ContactWidgetBizInfo", "respUsername == " + str + ", contact = " + adVar);
                    } else {
                        if (t.mX(adVar.field_username)) {
                            String nullAsNil = bo.nullAsNil(adVar.field_username);
                            qX = com.tencent.mm.aj.f.qX(nullAsNil);
                            if (qX != null) {
                                qX.field_username = str;
                            }
                            z.aeR().delete(nullAsNil);
                            adVar.iH(nullAsNil);
                        } else {
                            qX = null;
                        }
                        adVar.setUsername(str);
                        if (((int) adVar.ewQ) == 0) {
                            aw.ZK();
                            com.tencent.mm.model.c.XM().aa(adVar);
                        }
                        if (((int) adVar.ewQ) <= 0) {
                            ab.e("MicroMsg.ContactWidgetBizInfo", "addContact : insert contact failed");
                        } else {
                            t.q(adVar);
                            aw.ZK();
                            adVar = com.tencent.mm.model.c.XM().aoO(adVar.field_username);
                            if (qX != null) {
                                z.aeR().d(qX);
                            } else {
                                d qX2 = com.tencent.mm.aj.f.qX(adVar.field_username);
                                boolean z3;
                                if (adVar.dsf() && com.tencent.mm.aj.a.adG()) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (qX2 == null || (qX2.adJ() && !z3)) {
                                    ab.d("MicroMsg.ContactWidgetBizInfo", "shouldUpdate");
                                    ao.a.flu.ai(adVar.field_username, "");
                                    com.tencent.mm.ah.b.pY(adVar.field_username);
                                } else if (adVar.dsi() && !z3) {
                                    ab.d("MicroMsg.ContactWidgetBizInfo", "update contact, last check time=%d", Integer.valueOf(adVar.duj));
                                    ao.a.flu.ai(adVar.field_username, "");
                                    com.tencent.mm.ah.b.pY(adVar.field_username);
                                }
                            }
                        }
                    }
                    c.this.pmC = true;
                    if (c.this.pmI != null) {
                        of ofVar = new of();
                        c.this.pmI.fPZ = 4;
                        ofVar.cKy.cKz = c.this.pmI;
                        com.tencent.mm.sdk.b.a.xxA.m(ofVar);
                    }
                    qX = z.aeR().qP(c.this.ehM.field_username);
                    qX.field_status = 1;
                    if (!bo.isNullOrNil(qX.field_extInfo) || bo.isNullOrNil(qX.field_username) || c.this.pkW == null || !qX.field_username.equals(bo.nullAsNil(c.this.pkW.field_username))) {
                        z.aeR().e(qX);
                    } else {
                        z.aeR().e(c.this.pkW);
                    }
                    boolean booleanExtra = c.this.crP.getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
                    boolean booleanExtra2 = c.this.crP.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
                    Intent intent;
                    if (qX.adP()) {
                        intent = new Intent();
                        intent.putExtra("enterprise_biz_name", c.this.ehM.field_username);
                        intent.putExtra("enterprise_biz_display_name", s.mJ(c.this.ehM.field_username));
                        intent.putExtra("enterprise_from_scene", 7);
                        intent.addFlags(67108864);
                        com.tencent.mm.bp.d.f(c.this.crP, ".ui.conversation.EnterpriseConversationUI", intent);
                    } else {
                        intent = new Intent();
                        intent.putExtra("Chat_User", c.this.ehM.field_username);
                        intent.putExtra("key_has_add_contact", true);
                        intent.putExtra("finish_direct", true);
                        if (booleanExtra2) {
                            intent.addFlags(268435456);
                        }
                        com.tencent.mm.plugin.profile.b.gkE.d(intent, c.this.crP);
                        if (!booleanExtra) {
                        }
                    }
                    c.this.crP.finish();
                    c.this.aV(3, null);
                }
                AppMethodBeat.o(23462);
            }
        });
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(this.gwP));
        if (this.fvh != null) {
            aVar.vjK = this.fvh;
        }
        if (!bo.isNullOrNil(this.mGZ)) {
            aVar.mGZ = this.mGZ;
        }
        aVar.vjP = true;
        aVar.a(this.ehM.field_username, linkedList, this.pmJ);
        AppMethodBeat.o(23486);
    }

    private boolean caW() {
        AppMethodBeat.i(23487);
        if (this.crP.getIntent() == null) {
            AppMethodBeat.o(23487);
            return false;
        }
        String stringExtra = this.crP.getIntent().getStringExtra("device_id");
        String stringExtra2 = this.crP.getIntent().getStringExtra("device_type");
        dg dgVar = new dg();
        dgVar.cwu.ceI = stringExtra;
        dgVar.cwu.cws = stringExtra2;
        com.tencent.mm.sdk.b.a.xxA.m(dgVar);
        boolean z = dgVar.cwv.cww;
        AppMethodBeat.o(23487);
        return z;
    }

    /* Access modifiers changed, original: final */
    public final void caX() {
        AppMethodBeat.i(23488);
        if (this.ehM == null || bo.isNullOrNil(this.ehM.field_username)) {
            AppMethodBeat.o(23488);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[]{this.ehM.field_username}));
        intent.putExtra("showShare", false);
        com.tencent.mm.bp.d.b(this.crP, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(23488);
    }

    private void jO(boolean z) {
        AppMethodBeat.i(23489);
        if (this.ehM != null) {
            if (this.crP != null) {
                if (!z || com.tencent.mm.aj.f.kq(this.ehM.field_username)) {
                    this.crP.setTitleMuteIconVisibility(8);
                } else {
                    this.crP.setTitleMuteIconVisibility(0);
                }
            }
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_is_mute");
            if (checkBoxPreference != null) {
                checkBoxPreference.uOT = z;
            }
        }
        AppMethodBeat.o(23489);
    }

    private void UR(String str) {
        AppMethodBeat.i(23490);
        ab.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", str, Boolean.valueOf(this.pmF));
        if (this.pmF) {
            AppMethodBeat.o(23490);
            return;
        }
        this.pmE = str;
        com.tencent.mm.aj.g rh;
        IconWidgetPreference iconWidgetPreference;
        Bitmap a;
        if (this.fuY == null || !this.fuY.aeq() || this.ehM == null) {
            this.ehK.ce("contact_info_kf_worker", true);
            AppMethodBeat.o(23490);
        } else if (bo.isNullOrNil(str)) {
            rh = z.aeQ().rh(this.ehM.field_username);
            if (rh == null) {
                this.ehK.ce("contact_info_kf_worker", true);
                z.aeS().a(this);
                z.aeS().ax(this.ehM.field_username, r.Yz());
                this.pmF = true;
                AppMethodBeat.o(23490);
                return;
            }
            ab.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", rh.field_openId);
            this.ehK.ce("contact_info_kf_worker", false);
            iconWidgetPreference = (IconWidgetPreference) this.ehK.aqO("contact_info_kf_worker");
            iconWidgetPreference.setSummary((CharSequence) rh.field_nickname);
            a = com.tencent.mm.ah.b.a(rh.field_openId, false, -1);
            if (a == null) {
                c(rh);
                US(rh.field_openId);
                AppMethodBeat.o(23490);
                return;
            }
            iconWidgetPreference.O(a);
            AppMethodBeat.o(23490);
        } else {
            com.tencent.mm.aj.i aeQ = z.aeQ();
            com.tencent.mm.aj.g rg = aeQ.rg(str);
            if (rg == null || com.tencent.mm.aj.i.a(rg)) {
                z.aeS().a(this);
                z.aeS().ay(this.ehM.field_username, str);
                this.pmF = true;
            }
            if (rg == null) {
                ab.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                rh = aeQ.rh(this.ehM.field_username);
            } else {
                rh = rg;
            }
            if (rh == null) {
                this.ehK.ce("contact_info_kf_worker", true);
                AppMethodBeat.o(23490);
                return;
            }
            this.ehK.ce("contact_info_kf_worker", false);
            iconWidgetPreference = (IconWidgetPreference) this.ehK.aqO("contact_info_kf_worker");
            iconWidgetPreference.setSummary((CharSequence) rh.field_nickname);
            a = com.tencent.mm.ah.b.a(rh.field_openId, false, -1);
            if (a == null) {
                c(rh);
                US(rh.field_openId);
            } else {
                iconWidgetPreference.O(a);
            }
            ab.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", rh.field_openId, rh.field_nickname);
            AppMethodBeat.o(23490);
        }
    }

    private void US(final String str) {
        AppMethodBeat.i(23491);
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(23466);
                if (c.this.ehK == null) {
                    ab.w("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar screen is null");
                    AppMethodBeat.o(23466);
                    return;
                }
                IconWidgetPreference iconWidgetPreference = (IconWidgetPreference) c.this.ehK.aqO("contact_info_kf_worker");
                if (!(iconWidgetPreference == null || c.this.ehK == null)) {
                    Bitmap a = com.tencent.mm.ah.b.a(str, false, -1);
                    if (a != null) {
                        ab.d("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar success %s, update screen", str);
                        iconWidgetPreference.O(a);
                        c.this.ehK.notifyDataSetChanged();
                    }
                }
                AppMethodBeat.o(23466);
            }
        }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.o(23491);
    }

    private static void c(com.tencent.mm.aj.g gVar) {
        AppMethodBeat.i(23492);
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.ah.i act = o.act();
        if (act.qo(gVar.field_openId) == null) {
            com.tencent.mm.ah.h hVar = new com.tencent.mm.ah.h();
            hVar.username = gVar.field_openId;
            hVar.frV = gVar.field_headImgUrl;
            hVar.cB(false);
            hVar.dtR = 3;
            act.b(hVar);
        }
        o.acv().qa(gVar.field_openId);
        ab.d("MicroMsg.ContactWidgetBizInfo", "downloadKFAvatar, %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(23492);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        bxr bxr = null;
        AppMethodBeat.i(23493);
        ab.d("MicroMsg.ContactWidgetBizInfo", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        this.pmF = false;
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (mVar == null) {
            ab.e("MicroMsg.ContactWidgetBizInfo", "scene == null");
            AppMethodBeat.o(23493);
            return;
        }
        aw.Rg().b(mVar.getType(), (f) this);
        if (i == 0 && i2 == 0) {
            ab.d("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", Integer.valueOf(mVar.getType()));
            if (mVar.getType() == 536) {
                aw.Rg().b(536, (f) this);
                caT();
                AppMethodBeat.o(23493);
                return;
            } else if (mVar.getType() == 1363) {
                bxs bxs;
                com.tencent.mm.plugin.profile.b.c cVar = (com.tencent.mm.plugin.profile.b.c) mVar;
                if (cVar.ehh == null || cVar.ehh.fsH.fsP == null) {
                    bxs = null;
                } else {
                    bxs = (bxs) cVar.ehh.fsH.fsP;
                }
                com.tencent.mm.plugin.profile.b.c cVar2 = (com.tencent.mm.plugin.profile.b.c) mVar;
                if (!(cVar2.ehh == null || cVar2.ehh.fsG.fsP == null)) {
                    bxr = (bxr) cVar2.ehh.fsG.fsP;
                }
                if (bxs == null || bxs.vNh == null || bxs.vNh.ret != 0 || bxs.vNe == null || bo.isNullOrNil(bxs.vNe.vNc)) {
                    if (bxs == null || bxs.vNh == null) {
                        ab.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:resp == null");
                        AppMethodBeat.o(23493);
                        return;
                    }
                    ab.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:code:%s", Integer.valueOf(bxs.vNh.ret));
                    AppMethodBeat.o(23493);
                    return;
                } else if (bxs.vNe == null) {
                    ab.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd resp.user == null");
                    AppMethodBeat.o(23493);
                    return;
                } else {
                    j cH = z.aeV().cH(bxs.vNe.vNc);
                    if (cH == null) {
                        cH = new j();
                        cH.field_userId = bxs.vNe.vNc;
                    }
                    cH.field_userName = bxs.vNe.kfT;
                    cH.field_brandUserName = bxr.vNb;
                    cH.field_UserVersion = bxs.vNe.ver;
                    cH.field_headImageUrl = bxs.vNe.vMW;
                    cH.field_profileUrl = bxs.vNe.vNk;
                    cH.field_bitFlag = bxs.vNe.vMX;
                    cH.field_addMemberUrl = bxs.vNe.vNa;
                    cH.field_needToUpdate = false;
                    if (!z.aeV().b(cH)) {
                        z.aeV().a(cH);
                    }
                    AppMethodBeat.o(23493);
                    return;
                }
            } else if (mVar.getType() == 1394) {
                cfr caz = ((com.tencent.mm.plugin.profile.b.d) mVar).caz();
                cfs cay = ((com.tencent.mm.plugin.profile.b.d) mVar).cay();
                if (cay != null && cay.vNh != null && cay.vNh.ret == 0) {
                    int i3;
                    if (caz.xeS) {
                        boolean i32 = false;
                    } else {
                        i32 = 1;
                    }
                    d dVar;
                    if (i32 != 0) {
                        ak akVar;
                        dVar = this.pkW;
                        dVar.field_brandFlag &= -2;
                        a(dVar, true);
                        aw.ZK();
                        if (com.tencent.mm.model.c.XR().aoZ(dVar.field_username) == null) {
                            akVar = new ak(dVar.field_username);
                            akVar.jj(bo.nullAsNil(this.pkW.adX()));
                            aw.ZK();
                            bi Rb = com.tencent.mm.model.c.XO().Rb(dVar.field_username);
                            if (Rb != null) {
                                aw.ZK();
                                com.tencent.mm.model.c.XR().d(akVar);
                                aw.ZK();
                                com.tencent.mm.model.c.XR().aq(Rb);
                            } else {
                                akVar.dsI();
                                aw.ZK();
                                com.tencent.mm.model.c.XR().d(akVar);
                            }
                        }
                        aw.ZK();
                        if (com.tencent.mm.model.c.XR().aoZ(dVar.field_enterpriseFather) == null) {
                            akVar = new ak(dVar.field_enterpriseFather);
                            akVar.dsI();
                            aw.ZK();
                            com.tencent.mm.model.c.XR().d(akVar);
                            AppMethodBeat.o(23493);
                            return;
                        }
                        aw.ZK();
                        com.tencent.mm.model.c.XQ().aoj(dVar.field_enterpriseFather);
                        AppMethodBeat.o(23493);
                        return;
                    }
                    dVar = this.pkW;
                    dVar.field_brandFlag |= 1;
                    a(dVar, true);
                    aw.ZK();
                    com.tencent.mm.model.c.XR().aoX(dVar.field_username);
                    aw.ZK();
                    if (com.tencent.mm.model.c.XR().apl(dVar.field_enterpriseFather) <= 0) {
                        aw.ZK();
                        com.tencent.mm.model.c.XR().aoX(dVar.field_enterpriseFather);
                        AppMethodBeat.o(23493);
                        return;
                    }
                    aw.ZK();
                    com.tencent.mm.model.c.XQ().aoj(dVar.field_enterpriseFather);
                    AppMethodBeat.o(23493);
                    return;
                } else if (cay == null || cay.vNh == null) {
                    ab.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:resp == null", Integer.valueOf(mVar.getType()));
                    AppMethodBeat.o(23493);
                    return;
                } else {
                    ab.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:code:%s", Integer.valueOf(mVar.getType()), Integer.valueOf(cay.vNh.ret));
                    AppMethodBeat.o(23493);
                    return;
                }
            } else if (mVar.getType() == 1343) {
                caT();
                AppMethodBeat.o(23493);
                return;
            } else {
                if (mVar.getType() == 1228) {
                    caT();
                }
                AppMethodBeat.o(23493);
                return;
            }
        }
        ab.e("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", Integer.valueOf(mVar.getType()));
        AppMethodBeat.o(23493);
    }

    public final void e(LinkedList<cwa> linkedList) {
        AppMethodBeat.i(23494);
        z.aeS().b(this);
        if (this.ehK == null) {
            ab.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, screen is null");
            AppMethodBeat.o(23494);
        } else if (this.ehM == null) {
            ab.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, contact is null");
            AppMethodBeat.o(23494);
        } else if (linkedList == null || linkedList.size() <= 0) {
            ab.w("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, worker is null");
            AppMethodBeat.o(23494);
        } else {
            if (!bo.isNullOrNil(this.pmE)) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    cwa cwa = (cwa) it.next();
                    if (cwa.xrU != null && cwa.xrU.equals(this.pmE)) {
                        this.ehK.ce("contact_info_kf_worker", false);
                        this.ehK.aqO("contact_info_kf_worker").setSummary(cwa.wCW);
                        AppMethodBeat.o(23494);
                        return;
                    }
                }
            }
            this.ehK.ce("contact_info_kf_worker", false);
            Preference aqO = this.ehK.aqO("contact_info_kf_worker");
            if (!(aqO == null || linkedList == null || linkedList.get(0) == null)) {
                aqO.setSummary(((cwa) linkedList.get(0)).wCW);
            }
            AppMethodBeat.o(23494);
        }
    }

    public final void a(int i, m mVar) {
        AppMethodBeat.i(23495);
        if (this.pkW == null || !this.pkW.adR()) {
            AppMethodBeat.o(23495);
            return;
        }
        if (mVar.getType() == 1354) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo");
            this.pmx = z.aeV().cH(z.aeV().cI(this.pkW.field_username));
            if (this.pmx != null) {
                boolean z;
                if (this.pmx.lc(4)) {
                    z = false;
                } else {
                    z = true;
                }
                checkBoxPreference.uOT = z;
                this.ehK.notifyDataSetChanged();
                AppMethodBeat.o(23495);
                return;
            }
            ab.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null after GetBizChatMyUserInfo");
        }
        AppMethodBeat.o(23495);
    }

    public final String aeI() {
        return "MicroMsg.ContactWidgetBizInfo";
    }

    private void caY() {
        AppMethodBeat.i(23496);
        ab.d("MicroMsg.ContactWidgetBizInfo", "updatePlaceTop");
        if (this.ehZ == null) {
            this.ehZ = this.crP.getSharedPreferences(this.crP.getPackageName() + "_preferences", 0);
        }
        if (this.ehV != null) {
            if (this.ehM != null) {
                this.ehZ.edit().putBoolean("biz_placed_to_the_top", this.ehM.Oe()).commit();
            } else {
                this.ehZ.edit().putBoolean("biz_placed_to_the_top", false).commit();
            }
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(23496);
    }

    private static boolean Bd(int i) {
        if (i == 81 || i == 92 || i == 93 || i == 94) {
            return true;
        }
        return false;
    }

    static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(23497);
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(cVar.crP, 1, false);
        dVar.rBl = new com.tencent.mm.ui.base.n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(23474);
                if (c.this.pkW != null && c.this.pkW.adP()) {
                    lVar.hi(1, R.string.azw);
                    lVar.hi(3, R.string.a9n);
                    lVar.hi(4, R.string.auz);
                    lVar.hi(5, R.string.atv);
                    AppMethodBeat.o(23474);
                } else if (c.this.pkW == null || !c.this.pkW.adQ()) {
                    lVar.hi(1, R.string.azw);
                    lVar.hi(2, R.string.aub);
                    if (!t.nQ(c.this.ehM.field_username)) {
                        lVar.hi(3, R.string.a9n);
                        lVar.hi(4, R.string.auz);
                    }
                    lVar.hi(5, R.string.atv);
                    AppMethodBeat.o(23474);
                } else {
                    lVar.hi(5, R.string.atv);
                    AppMethodBeat.o(23474);
                }
            }
        };
        dVar.rBm = new com.tencent.mm.ui.base.n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(23458);
                c cVar;
                switch (menuItem.getItemId()) {
                    case 1:
                        cVar = c.this;
                        Intent intent = new Intent();
                        intent.putExtra("Select_Talker_Name", cVar.ehM.field_username);
                        intent.putExtra("Select_block_List", cVar.ehM.field_username);
                        intent.putExtra("Select_Send_Card", true);
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("mutil_select_is_ret", true);
                        com.tencent.mm.plugin.profile.b.gkE.a(intent, cVar.crP);
                        AppMethodBeat.o(23458);
                        return;
                    case 2:
                        c.this.crP.getString(R.string.bx1, new Object[]{c.this.ehM.Oj()});
                        com.tencent.mm.ui.base.h.d(c.this.crP, c.this.crP.getString(R.string.auc), "", c.this.crP.getString(R.string.aub), c.this.crP.getString(R.string.or), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(23457);
                                c cVar = c.this;
                                String str = cVar.ehM.field_username;
                                aw.ZK();
                                bi Ra = com.tencent.mm.model.c.XO().Ra(str);
                                aw.ZK();
                                com.tencent.mm.model.c.XL().c(new com.tencent.mm.az.d(str, Ra.field_msgSvrId));
                                cVar.isDeleteCancel = false;
                                Context context = cVar.crP;
                                cVar.crP.getString(R.string.tz);
                                cVar.tipDialog = com.tencent.mm.ui.base.h.b(context, cVar.crP.getString(R.string.un), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        c.this.isDeleteCancel = true;
                                    }
                                });
                                bf.a(str, new bf.a() {
                                    public final boolean JU() {
                                        return c.this.isDeleteCancel;
                                    }

                                    public final void JV() {
                                        AppMethodBeat.i(23465);
                                        if (c.this.tipDialog != null) {
                                            c.this.tipDialog.dismiss();
                                            c.this.tipDialog = null;
                                        }
                                        AppMethodBeat.o(23465);
                                    }
                                });
                                AppMethodBeat.o(23457);
                            }
                        }, null);
                        AppMethodBeat.o(23458);
                        return;
                    case 3:
                        c.this.caX();
                        AppMethodBeat.o(23458);
                        return;
                    case 4:
                        c cVar2 = c.this;
                        ((com.tencent.mm.pluginsdk.h) com.tencent.mm.kernel.g.K(com.tencent.mm.pluginsdk.h.class)).a(cVar2.pkW, cVar2.crP, cVar2.ehM, true, new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(23459);
                                c.this.aV(4, null);
                                if (c.this.crP.getIntent().getIntExtra("Kdel_from", -1) == 1) {
                                    Intent intent = new Intent();
                                    intent.addFlags(67108864);
                                    com.tencent.mm.bp.d.b(c.this.crP, "shake", ".ui.ShakeReportUI", intent);
                                }
                                AppMethodBeat.o(23459);
                            }
                        });
                        AppMethodBeat.o(23458);
                        return;
                    case 5:
                        cVar = c.this;
                        ab.d("MicroMsg.ContactWidgetBizInfo", "dealAddShortcut, username = " + cVar.ehM.field_username);
                        com.tencent.mm.plugin.base.model.b.aa(cVar.crP, cVar.ehM.field_username);
                        al.n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(23464);
                                if (c.this.crP.isFinishing()) {
                                    AppMethodBeat.o(23464);
                                    return;
                                }
                                com.tencent.mm.plugin.base.model.b.Z(c.this.crP, c.this.ehM.field_username);
                                com.tencent.mm.plugin.base.model.b.x(c.this.crP);
                                AppMethodBeat.o(23464);
                            }
                        }, 1000);
                        break;
                }
                AppMethodBeat.o(23458);
            }
        };
        dVar.cpD();
        AppMethodBeat.o(23497);
    }
}
