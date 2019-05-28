package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.se;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.appbrand.jsapi.k.l;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.e;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.TextPreference;
import com.tencent.mm.ui.base.t;
import com.tencent.smtt.sdk.WebView;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

@h(doa = {ContactInfoUI.class})
public final class k implements f, a, com.tencent.mm.pluginsdk.b.a {
    MMActivity crP;
    String ctQ;
    private int czs;
    private com.tencent.mm.ui.base.preference.f ehK;
    ad ehM;
    u eih;
    String ejD;
    int gwP;
    private String mGZ;
    private boolean pli;
    private boolean plj;
    private int pmV;
    private String pma;
    private ccl pnb;
    private boolean pnc;
    private String pnd;
    private int pne;
    private boolean pnf;
    private boolean png;
    private String pnh;
    private boolean pni;
    private String pnj;
    private String pnk;
    private int pnl;
    String pnm;
    c<at> pnn;

    public final boolean IO(String str) {
        Intent intent;
        AppMethodBeat.i(23575);
        if (str.equals("contact_info_sns")) {
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                intent = this.crP.getIntent();
                intent.putExtra("sns_source", this.czs);
                intent.putExtra("sns_signature", this.ehM.signature);
                intent.putExtra("sns_nickName", this.ehM.Oi());
                intent.putExtra("sns_title", this.ehM.Oj());
                if (n.qFC != null) {
                    intent = n.qFC.e(intent, this.ehM.field_username);
                }
                if (intent == null) {
                    this.crP.finish();
                } else {
                    intent.putExtra("sns_adapter_type", 1);
                    d.b(this.crP, "sns", ".ui.SnsTimeLineUserPagerUI", intent);
                    if ((intent.getFlags() & 67108864) != 0) {
                        this.crP.finish();
                    }
                }
            } else {
                t.hO(this.crP);
                AppMethodBeat.o(23575);
                return true;
            }
        }
        String stringExtra;
        long longExtra;
        String stringExtra2;
        if (str.equals("contact_info_more")) {
            Intent intent2 = new Intent();
            intent2.setClass(this.crP, ContactMoreInfoUI.class);
            intent2.putExtra("Is_RoomOwner", this.crP.getIntent().getBooleanExtra("Is_RoomOwner", false));
            intent2.putExtra("Contact_User", this.ehM.field_username);
            intent2.putExtra("KLinkedInAddFriendNickName", this.pnj);
            intent2.putExtra("KLinkedInAddFriendPubUrl", this.pnk);
            stringExtra = this.crP.getIntent().getStringExtra("room_name");
            if (stringExtra == null) {
                stringExtra = this.crP.getIntent().getStringExtra("Contact_ChatRoomId");
            }
            intent2.putExtra("Contact_ChatRoomId", stringExtra);
            intent2.putExtra("verify_gmail", this.pma);
            intent2.putExtra("profileName", this.pnh);
            longExtra = this.crP.getIntent().getLongExtra("Contact_Uin", 0);
            stringExtra = this.crP.getIntent().getStringExtra("Contact_QQNick");
            intent2.putExtra("Contact_Uin", longExtra);
            intent2.putExtra("Contact_QQNick", stringExtra);
            this.crP.startActivity(intent2);
        } else if (str.equals("contact_info_social")) {
            intent = new Intent();
            intent.setClass(this.crP, ContactSocialInfoUI.class);
            intent.putExtra("Contact_User", this.ehM.field_username);
            longExtra = this.crP.getIntent().getLongExtra("Contact_Uin", 0);
            stringExtra2 = this.crP.getIntent().getStringExtra("Contact_QQNick");
            intent.putExtra("Contact_Uin", longExtra);
            intent.putExtra("Contact_QQNick", stringExtra2);
            intent.putExtra("profileName", this.pnh);
            intent.putExtra("verify_gmail", this.pma);
            stringExtra2 = this.crP.getIntent().getStringExtra("Contact_Mobile_MD5");
            String stringExtra3 = this.crP.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            intent.putExtra("Contact_Mobile_MD5", stringExtra2);
            intent.putExtra("Contact_full_Mobile_MD5", stringExtra3);
            this.crP.startActivity(intent);
        } else if (str.equals("contact_info_invite_source")) {
            stringExtra = ((KeyValuePreference) this.ehK.aqO("contact_info_invite_source")).getExtras().getString("inviteer");
            if (!bo.isNullOrNil(stringExtra)) {
                stringExtra2 = mJ(stringExtra);
                Intent intent3 = new Intent();
                intent3.putExtra("Contact_User", stringExtra);
                intent3.putExtra("Contact_RemarkName", stringExtra2);
                intent3.putExtra("Contact_RoomNickname", stringExtra2);
                intent3.putExtra("Contact_RoomMember", true);
                intent3.putExtra("room_name", this.ejD);
                aw.ZK();
                intent3.putExtra("Contact_Nick", com.tencent.mm.model.c.XM().aoO(stringExtra).field_nickname);
                intent3.putExtra("Contact_Scene", 14);
                intent3.putExtra("Is_RoomOwner", true);
                intent3.putExtra("Contact_ChatRoomId", this.ejD);
                b.gkE.c(intent3, this.crP);
            }
        }
        AppMethodBeat.o(23575);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    /* Access modifiers changed, original: final */
    public final void UT(String str) {
        AppMethodBeat.i(23576);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.ContactWidgetNormal", "view stranger remark, username is null");
            AppMethodBeat.o(23576);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Scene", this.gwP);
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", this.ehM.field_username);
        intent.putExtra("Contact_Nick", this.ehM.field_nickname);
        intent.putExtra("Contact_RemarkName", this.ehM.field_conRemark);
        b.gkE.n(intent, this.crP);
        AppMethodBeat.o(23576);
    }

    private void cbc() {
        String str = null;
        AppMethodBeat.i(23577);
        ContactSocialInfoPreference contactSocialInfoPreference = (ContactSocialInfoPreference) this.ehK.aqO("contact_info_social");
        if (contactSocialInfoPreference != null) {
            if (bo.isNullOrNil(this.pnm)) {
                contactSocialInfoPreference.Bb(8);
            } else {
                contactSocialInfoPreference.Bb(0);
                this.pnl = 1;
            }
            aw.ZK();
            int h = bo.h((Integer) com.tencent.mm.model.c.Ry().get(9, (Object) str));
            long longExtra = this.crP.getIntent().getLongExtra("Contact_Uin", 0);
            String stringExtra = this.crP.getIntent().getStringExtra("Contact_QQNick");
            if (!(longExtra == 0 || h == 0)) {
                if (stringExtra == null || stringExtra.length() == 0) {
                    ao ge = com.tencent.mm.plugin.account.a.getQQListStg().ge(longExtra);
                    if (ge == null) {
                        ge = str;
                    }
                    if (ge != null) {
                        ge.getDisplayName();
                    }
                }
                if (longExtra == -1 || new p(longExtra).longValue() <= 0) {
                    contactSocialInfoPreference.AX(8);
                } else {
                    contactSocialInfoPreference.AX(0);
                    this.pnl = 1;
                }
            }
            if (bo.isNullOrNil(this.pma) || bo.isNullOrNil(this.pnh)) {
                contactSocialInfoPreference.AZ(8);
            } else {
                contactSocialInfoPreference.AZ(0);
                this.pnl = 1;
            }
            String value = g.Nu().getValue("LinkedinPluginClose");
            if (bo.isNullOrNil(value) || Integer.valueOf(value).intValue() == 0) {
                h = 1;
            } else {
                h = 0;
            }
            if (h == 0 || bo.isNullOrNil(this.ehM.dun)) {
                contactSocialInfoPreference.AY(8);
            } else {
                contactSocialInfoPreference.AY(0);
                this.pnl = 1;
            }
            if (r.Yz().equals(this.ehM.field_username)) {
                aw.ZK();
                value = (String) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_PROFILE_WEIDIANINFO_STRING, (Object) str);
            } else {
                value = this.ehM.duq;
            }
            if (!bo.isNullOrNil(value)) {
                try {
                    str = new JSONObject(value).optString("ShopUrl");
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "", new Object[0]);
                }
            }
            ab.i("MicroMsg.ContactWidgetNormal", "weiShopInfo:%s, shopUrl:%s", value, str);
            if (bo.isNullOrNil(str)) {
                contactSocialInfoPreference.Ba(8);
            } else {
                contactSocialInfoPreference.Ba(0);
                this.pnl = 1;
            }
            if (this.pnl == 0) {
                this.ehK.aqP("contact_info_social");
            }
        }
        AppMethodBeat.o(23577);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, ad adVar, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(23578);
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
        this.plj = this.crP.getIntent().getBooleanExtra("User_Verify", false);
        this.mGZ = bo.nullAsNil(this.crP.getIntent().getStringExtra("Verify_ticket"));
        this.pnc = this.crP.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
        this.pmV = this.crP.getIntent().getIntExtra("Kdel_from", -1);
        this.pnd = this.crP.getIntent().getStringExtra("Contact_RemarkName");
        this.czs = this.crP.getIntent().getIntExtra("Sns_from_Scene", 0);
        this.pnf = this.crP.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
        this.png = this.crP.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
        this.pne = this.crP.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
        long longExtra = this.crP.getIntent().getLongExtra("Contact_KSnsBgId", -1);
        String bc = bo.bc(this.crP.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
        this.pma = bo.bc(this.crP.getIntent().getStringExtra("verify_gmail"), "");
        this.pnh = bo.bc(this.crP.getIntent().getStringExtra("profileName"), bo.anu(this.pma));
        this.pnb.guY = this.pne;
        this.pnb.gva = longExtra;
        this.pnb.guZ = bc;
        this.pnj = this.crP.getIntent().getStringExtra("KLinkedInAddFriendNickName");
        this.pnk = this.crP.getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
        if (n.qFy != null) {
            this.pnb = n.qFy.b(adVar.field_username, this.pnb);
        }
        this.ejD = this.crP.getIntent().getStringExtra("room_name");
        aw.ZK();
        this.eih = com.tencent.mm.model.c.XV().oa(this.ejD);
        this.pni = adVar.field_deleteFlag == 1;
        caT();
        aw.ZK();
        com.tencent.mm.model.c.XM().aoJ(adVar.field_username);
        z2 = r.Yz().equals(adVar.field_username);
        ab.v("MicroMsg.ContactWidgetNormal", "get from extinfo %s", Integer.valueOf(this.pnb.guY));
        if ((this.pnb.guY & 1) > 0) {
            z3 = true;
        }
        if (!(adVar.Oa() || ad.aov(adVar.field_username) || !z3 || n.qFC == null)) {
            n.qFC.a(2, adVar.field_username, z2, this.czs);
        }
        AppMethodBeat.o(23578);
        return true;
    }

    private void caT() {
        String stringExtra;
        int i;
        KeyValuePreference keyValuePreference;
        AppMethodBeat.i(23579);
        biV();
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.a4);
        if (n.qFC != null) {
            n.qFC.a(3, this.ehM.field_username, this);
        }
        aw.Rg().a(30, (f) this);
        aw.Rg().a((int) l.CTRL_INDEX, (f) this);
        this.pnm = "";
        ab.i("MicroMsg.ContactWidgetNormal", "isCancelMatchPhoneMD5 %s", this.ehM.Of());
        if (!this.ehM.Of()) {
            com.tencent.mm.plugin.account.friend.a.a aVar = null;
            stringExtra = this.crP.getIntent().getStringExtra("Contact_Mobile_MD5");
            String stringExtra2 = this.crP.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            String str;
            Object[] objArr;
            if (bo.isNullOrNil(stringExtra) && bo.isNullOrNil(stringExtra2)) {
                if (!bo.isNullOrNil(this.ehM.field_username)) {
                    com.tencent.mm.plugin.account.friend.a.a vT = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(this.ehM.field_username);
                    stringExtra2 = "MicroMsg.ContactWidgetNormal";
                    str = "Contact name: %s AddrUpload IS NULL? %s";
                    objArr = new Object[2];
                    objArr[0] = this.ehM.field_username;
                    objArr[1] = vT == null ? "true" : "false";
                    ab.i(stringExtra2, str, objArr);
                    aVar = vT;
                }
            } else if (!(bo.isNullOrNil(stringExtra) && bo.isNullOrNil(stringExtra2))) {
                ab.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", this.ehM.field_username, stringExtra, stringExtra2);
                aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(stringExtra);
                if (aVar == null || bo.isNullOrNil(aVar.Aq())) {
                    aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(stringExtra2);
                }
                stringExtra2 = "MicroMsg.ContactWidgetNormal";
                str = "Contact name: %s AddrUpload IS NULL? %s";
                objArr = new Object[2];
                objArr[0] = this.ehM.field_username;
                objArr[1] = aVar == null ? "true" : "false";
                ab.i(stringExtra2, str, objArr);
            }
            if (!(aVar == null || bo.isNullOrNil(aVar.Aq()))) {
                this.pnm = bo.nullAsNil(aVar.apG()).replace(" ", "");
                ab.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s", this.ehM.field_username, this.pnm);
            }
        }
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.ehK.aqO("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.a(this.ehM, this.gwP, this.mGZ, this.pnm, this.ehM.dur);
            normalUserHeaderPreference.bW(this.ehM.field_username, this.pnf);
            normalUserHeaderPreference.vri = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23566);
                    k kVar = k.this;
                    if (view.getId() == R.id.b31) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(16055, Integer.valueOf(com.tencent.mm.plugin.profile.c.am(kVar.crP.getIntent())), Integer.valueOf(2));
                    }
                    if (kVar.ehM == null) {
                        ab.e("MicroMsg.ContactWidgetNormal", "contact is null");
                        AppMethodBeat.o(23566);
                    } else if (com.tencent.mm.n.a.jh(kVar.ehM.field_type)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_Scene", kVar.gwP);
                        intent.putExtra("Contact_User", kVar.ehM.field_username);
                        intent.putExtra("Contact_RoomNickname", kVar.crP.getIntent().getStringExtra("Contact_RoomNickname"));
                        intent.putExtra("view_mode", true);
                        intent.putExtra("contact_phone_number_by_md5", kVar.pnm);
                        intent.putExtra("contact_phone_number_list", kVar.ehM.dur);
                        b.gkE.m(intent, kVar.crP);
                        AppMethodBeat.o(23566);
                    } else if (bo.isNullOrNil(kVar.ehM.field_encryptUsername)) {
                        kVar.UT(kVar.ehM.field_username);
                        AppMethodBeat.o(23566);
                    } else {
                        kVar.UT(kVar.ehM.field_encryptUsername);
                        AppMethodBeat.o(23566);
                    }
                }
            };
            if (com.tencent.mm.n.a.jh(this.ehM.field_type)) {
                this.png = false;
            }
            normalUserHeaderPreference.bX(this.ehM.field_username, this.png);
        } else {
            this.ehK.d(normalUserHeaderPreference);
        }
        if (ad.aox(this.ehM.field_username) && this.ehM.duv != 0) {
            int indexOf = this.ehK.indexOf("contact_info_category_1");
            CharSequence c = ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.b.class)).c(this.ehM.field_openImAppid, "openim_custom_info_header", com.tencent.mm.openim.a.b.a.TYPE_WORDING);
            if (!TextUtils.isEmpty(c)) {
                PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this.crP);
                preferenceTitleCategory.setTitle(c);
                this.ehK.a(preferenceTitleCategory, indexOf);
                preferenceTitleCategory.yCX = new Preference.b() {
                    public final boolean car() {
                        return false;
                    }
                };
            }
            com.tencent.mm.openim.a.c cVar = new com.tencent.mm.openim.a.c();
            cVar.vj(this.ehM.duw);
            for (final com.tencent.mm.openim.a.c.a aVar2 : cVar.geU) {
                for (final com.tencent.mm.openim.a.c.b bVar : aVar2.geV) {
                    indexOf++;
                    AnonymousClass5 anonymousClass5 = new KeyValuePreference(this.crP) {
                        public final void onBindView(View view) {
                            AppMethodBeat.i(23569);
                            super.onBindView(view);
                            if (this.pnu != null) {
                                int i = (bVar.action == 2 || bVar.action == 3) ? 1 : 0;
                                if (i != 0) {
                                    this.pnu.setTextColor(ah.getResources().getColorStateList(R.color.a86));
                                }
                            }
                            if (!(this.yCq == null || TextUtils.isEmpty(bVar.cIY))) {
                                this.yCq.setVisibility(0);
                                o.ahp().a(bVar.cIY, this.yCq);
                            }
                            AppMethodBeat.o(23569);
                        }
                    };
                    anonymousClass5.ylA = aVar2.title;
                    anonymousClass5.setSummary((CharSequence) j.b(this.crP, bVar.vk(this.ehM.field_openImAppid)));
                    this.ehK.a(anonymousClass5, indexOf);
                    if (bVar.action == 0 || bVar.action == 1) {
                        anonymousClass5.setEnabled(true);
                    } else if (bVar.action == 2) {
                        anonymousClass5.yCX = new Preference.b() {
                            public final boolean car() {
                                AppMethodBeat.i(23570);
                                Object obj = bVar.geX;
                                try {
                                    obj = new JSONObject(bVar.geX).optString("tel");
                                } catch (JSONException e) {
                                    ab.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "OpenIMCustomDetail.OPENIM_ACTION_DIAL_PHONE click parse error", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.h.pYm.e(15319, k.this.ehM.field_openImAppid, Integer.valueOf(bVar.action), aVar2.title);
                                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(obj))));
                                intent.setFlags(268435456);
                                k.this.crP.startActivity(intent);
                                AppMethodBeat.o(23570);
                                return true;
                            }
                        };
                    } else if (bVar.action == 3) {
                        anonymousClass5.yCX = new Preference.b() {
                            public final boolean car() {
                                AppMethodBeat.i(23571);
                                Object obj = "";
                                try {
                                    obj = new JSONObject(bVar.geX).optString("mailto");
                                } catch (JSONException e) {
                                    ab.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "loadProfile", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.h.pYm.e(15319, k.this.ehM.field_openImAppid, Integer.valueOf(bVar.action), aVar2.title);
                                Intent intent = new Intent("android.intent.action.SENDTO");
                                intent.setData(Uri.parse(WebView.SCHEME_MAILTO.concat(String.valueOf(obj))));
                                k.this.crP.startActivity(intent);
                                AppMethodBeat.o(23571);
                                return true;
                            }
                        };
                    } else if (bVar.action == 4) {
                        anonymousClass5.yCX = new Preference.b() {
                            public final boolean car() {
                                AppMethodBeat.i(23572);
                                Intent intent = new Intent();
                                intent.setFlags(268435456);
                                intent.setClassName(ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                                String str = "";
                                try {
                                    str = new JSONObject(bVar.geX).optString("url");
                                } catch (JSONException e) {
                                    ab.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "loadProfile", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.h.pYm.e(15319, k.this.ehM.field_openImAppid, Integer.valueOf(bVar.action), aVar2.title);
                                intent.putExtra("geta8key_scene", 58);
                                intent.putExtra("rawUrl", str);
                                ah.getContext().startActivity(intent);
                                AppMethodBeat.o(23572);
                                return true;
                            }
                        };
                    } else if (bVar.action == 5) {
                        anonymousClass5.yCX = new Preference.b() {
                            public final boolean car() {
                                AppMethodBeat.i(23573);
                                try {
                                    JSONObject jSONObject = new JSONObject(bVar.geX);
                                    String optString = jSONObject.optString("name");
                                    String optString2 = jSONObject.optString("pagepath");
                                    se seVar = new se();
                                    seVar.cOf.userName = optString;
                                    seVar.cOf.cOh = bo.bc(optString2, "");
                                    com.tencent.mm.sdk.b.a.xxA.m(seVar);
                                    com.tencent.mm.plugin.report.service.h.pYm.e(15319, k.this.ehM.field_openImAppid, Integer.valueOf(bVar.action), aVar2.title);
                                } catch (JSONException e) {
                                    ab.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "loadProfile", new Object[0]);
                                }
                                AppMethodBeat.o(23573);
                                return true;
                            }
                        };
                    }
                }
            }
            i = indexOf + 1;
            this.ehK.a(new PreferenceSmallCategory(this.crP), i);
            int i2 = i + 1;
            KeyValuePreference keyValuePreference2 = new KeyValuePreference(this.crP);
            keyValuePreference2.setTitle((int) R.string.avq);
            final CharSequence c2 = ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.b.class)).c(this.ehM.field_openImAppid, "openim_intro_desc", com.tencent.mm.openim.a.b.a.TYPE_WORDING);
            keyValuePreference2.setSummary((CharSequence) j.b(this.crP, c2));
            stringExtra = ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.b.class)).c(this.ehM.field_openImAppid, "openim_intro_url", com.tencent.mm.openim.a.b.a.TYPE_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                keyValuePreference2.yCX = new Preference.b() {
                    public final boolean car() {
                        AppMethodBeat.i(23574);
                        Intent intent = new Intent();
                        intent.setFlags(268435456);
                        intent.setClassName(ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                        intent.putExtra("rawUrl", stringExtra);
                        intent.putExtra("geta8key_scene", 58);
                        ah.getContext().startActivity(intent);
                        com.tencent.mm.plugin.report.service.h.pYm.e(15319, k.this.ehM.field_openImAppid, Integer.valueOf(6), c2);
                        AppMethodBeat.o(23574);
                        return true;
                    }
                };
            }
            this.ehK.a(keyValuePreference2, i2);
        }
        if (bo.isNullOrNil(this.ehM.getProvince())) {
            this.ehK.aqP("contact_info_district");
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_district");
            if (keyValuePreference != null) {
                keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.avo));
                keyValuePreference.setSummary((CharSequence) s.mL(this.ehM.getProvince()) + (bo.isNullOrNil(this.ehM.getCity()) ? "" : "  " + this.ehM.getCity()));
                keyValuePreference.qi(false);
                keyValuePreference.setEnabled(false);
            }
        }
        if (this.ehM.signature == null || this.ehM.signature.trim().equals("") || com.tencent.mm.n.a.jh(this.ehM.field_type)) {
            this.ehK.aqP("contact_info_signature");
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_signature");
            if (keyValuePreference != null) {
                keyValuePreference.yCj = false;
                keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b0a));
                keyValuePreference.setSummary((CharSequence) j.b(this.crP, this.ehM.signature));
                keyValuePreference.qi(false);
            }
        }
        this.ehK.aqO("contact_info_facebook");
        this.ehK.aqP("contact_info_facebook");
        if ((this.pnb.guY & 1) > 0) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i & d.afj("sns")) == 0 || ad.aov(this.ehM.field_username) || this.ehM.Oa()) {
            this.ehK.aqP("contact_info_sns");
        } else {
            com.tencent.mm.ui.base.preference.g gVar = (com.tencent.mm.ui.base.preference.g) this.ehK.aqO("contact_info_sns");
            if (!(gVar == null || n.qFy == null)) {
                gVar.ajO(this.ehM.field_username);
            }
        }
        this.ehK.aqP("contact_info_verifyuser");
        this.ehK.aqP("contact_info_footer_normal");
        new com.tencent.mm.plugin.profile.a.b(this.crP, this.ehM).bKH();
        if (this.gwP == 96) {
            this.ehK.aqP("contact_info_footer_normal");
        }
        if (com.tencent.mm.n.a.jh(this.ehM.field_type)) {
            cbf();
            this.ehK.aqP("contact_info_social");
        } else {
            cbc();
            this.ehK.aqP("contact_info_more");
        }
        cbd();
        cbe();
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.ehK.aqO("contact_info_footer_normal");
        boolean booleanExtra = this.crP.getIntent().getBooleanExtra("User_From_Fmessage", false);
        boolean booleanExtra2 = this.crP.getIntent().getBooleanExtra("Contact_FMessageCard", false);
        this.crP.getIntent().getBooleanExtra("Contact_KHideExpose", false);
        long longExtra = this.crP.getIntent().getLongExtra("Contact_Uin", -1);
        if (this.gwP == 30 || this.gwP == 45) {
            this.pnc = false;
        }
        if (normalUserFooterPreference == null || !normalUserFooterPreference.a(this.ehM, this.mGZ, this.pli, this.plj, this.pnc, this.gwP, this.pmV, booleanExtra2, booleanExtra, longExtra, this.pnd)) {
            this.ehK.aqP("contact_info_footer_normal");
        } else {
            normalUserFooterPreference.fry.removeAll();
            normalUserFooterPreference.fry.a(new e() {
            }, Looper.getMainLooper());
        }
        this.ehK.aqP("clear_lbs_info");
        if (this.pni) {
            this.ehK.removeAll();
            if (normalUserHeaderPreference != null) {
                this.ehK.b(normalUserHeaderPreference);
            }
            if (normalUserFooterPreference != null) {
                this.ehK.b(normalUserFooterPreference);
            }
        }
        AppMethodBeat.o(23579);
    }

    private void cbd() {
        AppMethodBeat.i(23580);
        if (com.tencent.mm.n.a.jh(this.ehM.field_type)) {
            this.ehK.aqP("contact_info_source");
            AppMethodBeat.o(23580);
            return;
        }
        int intExtra = this.crP.getIntent().getIntExtra("Contact_Source_FMessage", 0);
        ab.d("MicroMsg.ContactWidgetNormal", "initFriendSource, contact source = " + this.ehM.getSource() + ", sourceFMessage = " + intExtra);
        if (intExtra != 0) {
            Bf(intExtra);
            AppMethodBeat.o(23580);
            return;
        }
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_source");
        if (this.plj) {
            switch (this.ehM.getSource()) {
                case 18:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        keyValuePreference.setSummary((int) R.string.b12);
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23580);
                        return;
                    }
                    break;
                case 22:
                case 23:
                case 24:
                case 26:
                case 27:
                case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                case 29:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        keyValuePreference.setSummary((int) R.string.b1j);
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23580);
                        return;
                    }
                    break;
                case 30:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        keyValuePreference.setSummary((int) R.string.b17);
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23580);
                        return;
                    }
                    break;
                case 34:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        keyValuePreference.setSummary((CharSequence) this.crP.getString(R.string.b0m));
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23580);
                        return;
                    }
                    break;
                case 48:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        keyValuePreference.setSummary((CharSequence) this.crP.getString(R.string.b19));
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23580);
                        return;
                    }
                    break;
                case aa.CTRL_INDEX /*58*/:
                case au.CTRL_INDEX /*59*/:
                case 60:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        keyValuePreference.setSummary((CharSequence) this.crP.getString(R.string.c8k));
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23580);
                        return;
                    }
                    break;
                case 76:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        keyValuePreference.setSummary((CharSequence) this.crP.getString(R.string.b14));
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23580);
                        return;
                    }
                    break;
                default:
                    this.ehK.d(keyValuePreference);
                    AppMethodBeat.o(23580);
                    return;
            }
        }
        this.ehK.d(keyValuePreference);
        AppMethodBeat.o(23580);
    }

    private void cbe() {
        AppMethodBeat.i(23581);
        this.ehK.ce("contact_info_invite_source", true);
        boolean booleanExtra = this.eih == null ? this.crP.getIntent().getBooleanExtra("Is_RoomOwner", false) : this.eih.JR();
        if (this.gwP != 14 || !booleanExtra || this.eih == null || this.ehM.field_username.equals(this.eih.field_roomowner)) {
            String str = "MicroMsg.ContactWidgetNormal";
            String str2 = "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(this.gwP);
            objArr[1] = Boolean.valueOf(booleanExtra);
            if (this.eih == null) {
                booleanExtra = true;
            } else {
                booleanExtra = false;
            }
            objArr[2] = Boolean.valueOf(booleanExtra);
            ab.i(str, str2, objArr);
            this.ehK.ce("contact_info_invite_source", true);
            AppMethodBeat.o(23581);
            return;
        }
        this.ctQ = this.crP.getIntent().getStringExtra("inviteer");
        if (bo.isNullOrNil(this.ctQ)) {
            this.ctQ = this.eih.aop(this.ehM.field_username);
        }
        if (bo.isNullOrNil(this.ctQ)) {
            this.ctQ = com.tencent.mm.model.n.Z(this.ehM.field_username, this.ejD);
        }
        if (bo.isNullOrNil(this.ctQ)) {
            ab.w("MicroMsg.ContactWidgetNormal", "mRoomId:%s member:%s , inviteer is null!", this.ejD, this.ehM.field_username);
            this.pnn.dnU();
            com.tencent.mm.model.ao.a.flu.a(this.ehM.field_username, this.ejD, new com.tencent.mm.model.ao.b.a() {
                public final void o(String str, boolean z) {
                    AppMethodBeat.i(23567);
                    ab.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", str, k.this.ejD, Boolean.valueOf(z));
                    k.this.pnn.dead();
                    AppMethodBeat.o(23567);
                }
            });
            AppMethodBeat.o(23581);
            return;
        }
        this.crP.getIntent().putExtra("inviteer", this.ctQ);
        String mJ = mJ(this.ctQ);
        if (bo.isNullOrNil(mJ)) {
            com.tencent.mm.model.ao.a.flu.a(this.ehM.field_username, "", new com.tencent.mm.model.ao.b.a() {
                public final void o(String str, boolean z) {
                    AppMethodBeat.i(23568);
                    ab.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", str, k.this.ejD, Boolean.valueOf(z));
                    if (z) {
                        aw.ZK();
                        k.this.fE(k.this.ctQ, com.tencent.mm.model.c.XM().aoO(str).Oi());
                    }
                    AppMethodBeat.o(23568);
                }
            });
            AppMethodBeat.o(23581);
            return;
        }
        fE(this.ctQ, mJ);
        AppMethodBeat.o(23581);
    }

    /* Access modifiers changed, original: final */
    public final void fE(String str, String str2) {
        AppMethodBeat.i(23582);
        ab.i("MicroMsg.ContactWidgetNormal", "[showInviteerView] inviteer:%s inviteerDisplayName:%s", str, str2);
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_invite_source");
        TextPreference textPreference = (TextPreference) this.ehK.aqO("contact_info_hint");
        this.ehK.ce("contact_info_invite_source", false);
        SpannableString spannableString = new SpannableString(j.b(this.crP, this.crP.getResources().getString(R.string.awu, new Object[]{str2})));
        spannableString.setSpan(new ForegroundColorSpan(this.crP.getResources().getColor(R.color.hi)), 0, str2.length(), 33);
        keyValuePreference.setSummary((CharSequence) spannableString);
        keyValuePreference.getExtras().putString("inviteer", str);
        this.crP.getIntent().putExtra("inviteer", str);
        if (this.eih == null || this.eih.afg().contains(this.ehM.field_username)) {
            this.ehK.ce("contact_info_footer_normal", false);
            AppMethodBeat.o(23582);
            return;
        }
        this.ehK.ce("contact_info_footer_normal", true);
        textPreference.ae(j.b(this.crP, this.crP.getResources().getString(R.string.ay_, new Object[]{mJ(this.ehM.field_username)})));
        AppMethodBeat.o(23582);
    }

    private String mJ(String str) {
        String str2 = null;
        AppMethodBeat.i(23583);
        if (this.eih == null) {
            AppMethodBeat.o(23583);
        } else {
            aw.ZK();
            ad aoO = com.tencent.mm.model.c.XM().aoO(str);
            if (aoO != null && ((int) aoO.ewQ) > 0) {
                str2 = aoO.field_conRemark;
            }
            if (bo.isNullOrNil(str2)) {
                str2 = this.eih.mJ(str);
            }
            if (bo.isNullOrNil(str2) && aoO != null) {
                str2 = aoO.Oi();
            }
            AppMethodBeat.o(23583);
        }
        return str2;
    }

    private void Bf(int i) {
        AppMethodBeat.i(23584);
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_source");
        if (this.plj) {
            String str;
            switch (i) {
                case 1:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        keyValuePreference.setSummary((int) R.string.b1d);
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23584);
                        return;
                    }
                    break;
                case 3:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        keyValuePreference.setSummary((int) R.string.b1g);
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23584);
                        return;
                    }
                    break;
                case 4:
                case 12:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        keyValuePreference.setSummary((CharSequence) this.crP.getString(R.string.bw3));
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23584);
                        return;
                    }
                    break;
                case 8:
                case 14:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        ax apw = com.tencent.mm.bi.d.akO().apw(this.ehM.field_username);
                        aw.ZK();
                        ad aoO = com.tencent.mm.model.c.XM().aoO(apw == null ? "" : apw.field_chatroomName);
                        if (aoO != null) {
                            str = aoO.field_nickname;
                        } else {
                            str = null;
                        }
                        if (bo.isNullOrNil(str)) {
                            keyValuePreference.setSummary((int) R.string.b0y);
                        } else {
                            keyValuePreference.setSummary((CharSequence) this.crP.getString(R.string.b10, new Object[]{str}));
                        }
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23584);
                        return;
                    }
                    break;
                case 10:
                case 13:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        keyValuePreference.setSummary((int) R.string.b1m);
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23584);
                        return;
                    }
                    break;
                case 15:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        keyValuePreference.setSummary((int) R.string.b1a);
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23584);
                        return;
                    }
                    break;
                case 17:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        str = s.mJ(this.crP.getIntent().getStringExtra("source_from_user_name"));
                        if (bo.isNullOrNil(str)) {
                            str = this.crP.getIntent().getStringExtra("source_from_nick_name");
                        }
                        if (bo.isNullOrNil(str)) {
                            keyValuePreference.setSummary((int) R.string.b0u);
                        } else {
                            keyValuePreference.setSummary((CharSequence) j.b(this.crP, this.crP.getString(R.string.b0t, new Object[]{str})));
                        }
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23584);
                        return;
                    }
                    break;
                case 18:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        keyValuePreference.setSummary((int) R.string.b12);
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23584);
                        return;
                    }
                    break;
                case 25:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        keyValuePreference.setSummary((int) R.string.b0p);
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23584);
                        return;
                    }
                    break;
                case 30:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        keyValuePreference.setSummary((int) R.string.b17);
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23584);
                        return;
                    }
                    break;
                case 48:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        keyValuePreference.setSummary((CharSequence) this.crP.getString(R.string.b19));
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23584);
                        return;
                    }
                    break;
                case aa.CTRL_INDEX /*58*/:
                case au.CTRL_INDEX /*59*/:
                case 60:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                        keyValuePreference.setSummary((CharSequence) this.crP.getString(R.string.c8k));
                        keyValuePreference.qi(false);
                        AppMethodBeat.o(23584);
                        return;
                    }
                    break;
                default:
                    this.ehK.d(keyValuePreference);
                    break;
            }
            AppMethodBeat.o(23584);
            return;
        }
        if (keyValuePreference != null) {
            if (i == 10) {
                keyValuePreference.yCj = false;
                keyValuePreference.setTitle((CharSequence) this.crP.getString(R.string.b1p));
                keyValuePreference.setSummary((CharSequence) this.crP.getString(R.string.bw2));
                keyValuePreference.qi(false);
                AppMethodBeat.o(23584);
                return;
            }
            this.ehK.d(keyValuePreference);
        }
        AppMethodBeat.o(23584);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cbf() {
        int i = 1;
        AppMethodBeat.i(23585);
        int[] iArr = new int[7];
        ContactMoreInfoPreference contactMoreInfoPreference = (ContactMoreInfoPreference) this.ehK.aqO("contact_info_more");
        if (contactMoreInfoPreference != null) {
            String str;
            long longExtra = this.crP.getIntent().getLongExtra("Contact_Uin", 0);
            if (longExtra == -1 || new p(longExtra).longValue() <= 0) {
                contactMoreInfoPreference.AX(8);
                iArr[0] = 8;
            } else {
                contactMoreInfoPreference.AX(0);
                iArr[0] = 0;
            }
            if (bo.isNullOrNil(this.pma) || bo.isNullOrNil(this.pnh)) {
                contactMoreInfoPreference.AZ(8);
                iArr[1] = 8;
            } else {
                contactMoreInfoPreference.AZ(0);
                iArr[1] = 0;
            }
            String value = g.Nu().getValue("LinkedinPluginClose");
            if (!(bo.isNullOrNil(value) || Integer.valueOf(value).intValue() == 0)) {
                i = 0;
            }
            if (i == 0 || bo.isNullOrNil(this.ehM.dun)) {
                contactMoreInfoPreference.AY(8);
                iArr[2] = 8;
            } else {
                contactMoreInfoPreference.AY(0);
                iArr[2] = 0;
            }
            if (r.Yz().equals(this.ehM.field_username)) {
                aw.ZK();
                str = (String) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_PROFILE_WEIDIANINFO_STRING, null);
            } else {
                str = this.ehM.duq;
            }
            if (!bo.isNullOrNil(str)) {
                try {
                    str = new JSONObject(str).optString("ShopUrl");
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "", new Object[0]);
                }
                if (bo.isNullOrNil(str)) {
                    contactMoreInfoPreference.Ba(0);
                    iArr[3] = 0;
                } else {
                    contactMoreInfoPreference.Ba(8);
                    iArr[3] = 8;
                }
                if (bo.isNullOrNil(this.ehM.signature)) {
                    iArr[4] = 0;
                } else {
                    iArr[4] = 8;
                }
                if (this.ehM.getSource() > 0) {
                    iArr[5] = 8;
                } else {
                    iArr[5] = 0;
                }
                iArr[6] = 8;
                this.ehK.ce("contact_info_more", false);
            }
            str = null;
            if (bo.isNullOrNil(str)) {
            }
            if (bo.isNullOrNil(this.ehM.signature)) {
            }
            if (this.ehM.getSource() > 0) {
            }
            iArr[6] = 8;
            this.ehK.ce("contact_info_more", false);
        }
        AppMethodBeat.o(23585);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(23587);
        if (mVar.getType() == 30 || mVar.getType() == FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED) {
            if (i == 0 && i2 == 0) {
                if (mVar.getType() == 30) {
                    com.tencent.mm.pluginsdk.model.m mVar2 = (com.tencent.mm.pluginsdk.model.m) mVar;
                    if (mVar2.cAd != 1 && mVar2.cAd != 3) {
                        AppMethodBeat.o(23587);
                        return;
                    } else if (mVar2.vbm == null || mVar2.vbm.contains(this.ehM.field_username)) {
                        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.ehK.aqO("contact_info_header_normal");
                        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.ehK.aqO("contact_info_footer_normal");
                        if (!(normalUserHeaderPreference == null || normalUserFooterPreference == null || !normalUserFooterPreference.poQ)) {
                            ab.d("MicroMsg.ContactWidgetNormal", "happy update remark change");
                            this.pnf = false;
                            this.png = false;
                            normalUserHeaderPreference.bW(this.ehM.field_username, false);
                            normalUserHeaderPreference.bX(this.ehM.field_username, false);
                            normalUserHeaderPreference.qj(this.ehM.field_username);
                            this.crP.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.pnf);
                            this.crP.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.png);
                        }
                    } else {
                        AppMethodBeat.o(23587);
                        return;
                    }
                }
                if (mVar.getType() == l.CTRL_INDEX) {
                    caT();
                    AppMethodBeat.o(23587);
                    return;
                }
            } else if (i == 4 && i2 == -24 && !bo.isNullOrNil(str)) {
                Toast.makeText(this.crP, str, 1).show();
            }
            AppMethodBeat.o(23587);
            return;
        }
        ab.w("MicroMsg.ContactWidgetNormal", "not expected scene,  type = " + mVar.getType());
        AppMethodBeat.o(23587);
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j, String str2) {
        AppMethodBeat.i(23588);
        com.tencent.mm.ui.base.preference.g gVar = (com.tencent.mm.ui.base.preference.g) this.ehK.aqO("contact_info_sns");
        if (!(gVar == null || n.qFy == null)) {
            gVar.ajO(this.ehM.field_username);
        }
        this.pnb = n.qFy.b(this.ehM.field_username, this.pnb);
        this.ehK.notifyDataSetChanged();
        if (z3) {
            ab.d("MicroMsg.ContactWidgetNormal", "bg Change!");
            if (n.qFC != null) {
                n.qFC.WZ(this.ehM.field_username);
            }
        }
        AppMethodBeat.o(23588);
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j, String str2) {
    }

    public final boolean biV() {
        AppMethodBeat.i(23586);
        if (n.qFC != null) {
            n.qFC.a(this, 3);
        }
        aw.Rg().b(30, (f) this);
        aw.Rg().b((int) l.CTRL_INDEX, (f) this);
        NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) this.ehK.aqO("contact_profile_header_normal");
        if (normalProfileHeaderPreference != null) {
            normalProfileHeaderPreference.onDetach();
        }
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.ehK.aqO("contact_info_footer_normal");
        if (normalUserFooterPreference != null) {
            normalUserFooterPreference.biV();
        }
        FriendPreference friendPreference = (FriendPreference) this.ehK.aqO("contact_info_friend_qq");
        if (friendPreference != null) {
            friendPreference.biV();
        }
        friendPreference = (FriendPreference) this.ehK.aqO("contact_info_friend_mobile");
        if (friendPreference != null) {
            friendPreference.biV();
        }
        friendPreference = (FriendPreference) this.ehK.aqO("contact_info_facebook");
        if (friendPreference != null) {
            friendPreference.biV();
        }
        this.ehK.aqO("contact_info_sns");
        AppMethodBeat.o(23586);
        return true;
    }
}
