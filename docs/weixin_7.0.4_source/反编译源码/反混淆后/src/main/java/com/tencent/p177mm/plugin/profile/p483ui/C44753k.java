package com.tencent.p177mm.plugin.profile.p483ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.p1210a.C32873b.C32874a;
import com.tencent.p177mm.openim.p1210a.C32875c;
import com.tencent.p177mm.openim.p1210a.C32875c.C18734a;
import com.tencent.p177mm.openim.p1210a.C32875c.C26514b;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C41966at;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.C46634g;
import com.tencent.p177mm.p612ui.base.preference.KeyValuePreference;
import com.tencent.p177mm.p612ui.base.preference.Preference.C23633b;
import com.tencent.p177mm.p612ui.base.preference.PreferenceSmallCategory;
import com.tencent.p177mm.p612ui.base.preference.PreferenceTitleCategory;
import com.tencent.p177mm.p612ui.base.preference.TextPreference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.friend.p272a.C9878ao;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2206au;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42464aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C38317l;
import com.tencent.p177mm.plugin.profile.C34696c;
import com.tencent.p177mm.plugin.profile.C39503b;
import com.tencent.p177mm.plugin.profile.p1286a.C43387b;
import com.tencent.p177mm.plugin.profile.p483ui.NormalUserFooterPreference.C12838e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.plugin.sns.p1024b.C39728h.C39729a;
import com.tencent.p177mm.pluginsdk.model.C46498m;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.preference.NormalUserHeaderPreference;
import com.tencent.p177mm.protocal.protobuf.ccl;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5060h;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7569ax;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.sdk.WebView;
import com.tencent.view.C31128d;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

@C5060h(doa = {ContactInfoUI.class})
/* renamed from: com.tencent.mm.plugin.profile.ui.k */
public final class C44753k implements C1202f, C39729a, C23233a {
    MMActivity crP;
    String ctQ;
    private int czs;
    private C15541f ehK;
    C7616ad ehM;
    C7577u eih;
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
    C4884c<C41966at> pnn;

    /* renamed from: com.tencent.mm.plugin.profile.ui.k$11 */
    class C363411 implements C12838e {
        C363411() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.k$4 */
    class C128594 implements C23633b {
        C128594() {
        }

        public final boolean car() {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.k$2 */
    class C347302 implements C9636a {
        C347302() {
        }

        /* renamed from: o */
        public final void mo6218o(String str, boolean z) {
            AppMethodBeat.m2504i(23567);
            C4990ab.m7417i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", str, C44753k.this.ejD, Boolean.valueOf(z));
            C44753k.this.pnn.dead();
            AppMethodBeat.m2505o(23567);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.k$3 */
    class C347313 implements C9636a {
        C347313() {
        }

        /* renamed from: o */
        public final void mo6218o(String str, boolean z) {
            AppMethodBeat.m2504i(23568);
            C4990ab.m7417i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", str, C44753k.this.ejD, Boolean.valueOf(z));
            if (z) {
                C9638aw.m17190ZK();
                C44753k.this.mo71827fE(C44753k.this.ctQ, C18628c.m29078XM().aoO(str).mo16706Oi());
            }
            AppMethodBeat.m2505o(23568);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.k$1 */
    class C447541 implements OnClickListener {
        C447541() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23566);
            C44753k c44753k = C44753k.this;
            if (view.getId() == 2131823024) {
                C7060h.pYm.mo8381e(16055, Integer.valueOf(C34696c.m56965am(c44753k.crP.getIntent())), Integer.valueOf(2));
            }
            if (c44753k.ehM == null) {
                C4990ab.m7412e("MicroMsg.ContactWidgetNormal", "contact is null");
                AppMethodBeat.m2505o(23566);
            } else if (C7486a.m12942jh(c44753k.ehM.field_type)) {
                Intent intent = new Intent();
                intent.putExtra("Contact_Scene", c44753k.gwP);
                intent.putExtra("Contact_User", c44753k.ehM.field_username);
                intent.putExtra("Contact_RoomNickname", c44753k.crP.getIntent().getStringExtra("Contact_RoomNickname"));
                intent.putExtra("view_mode", true);
                intent.putExtra("contact_phone_number_by_md5", c44753k.pnm);
                intent.putExtra("contact_phone_number_list", c44753k.ehM.dur);
                C39503b.gkE.mo38928m(intent, c44753k.crP);
                AppMethodBeat.m2505o(23566);
            } else if (C5046bo.isNullOrNil(c44753k.ehM.field_encryptUsername)) {
                c44753k.mo71826UT(c44753k.ehM.field_username);
                AppMethodBeat.m2505o(23566);
            } else {
                c44753k.mo71826UT(c44753k.ehM.field_encryptUsername);
                AppMethodBeat.m2505o(23566);
            }
        }
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        Intent intent;
        AppMethodBeat.m2504i(23575);
        if (str.equals("contact_info_sns")) {
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                intent = this.crP.getIntent();
                intent.putExtra("sns_source", this.czs);
                intent.putExtra("sns_signature", this.ehM.signature);
                intent.putExtra("sns_nickName", this.ehM.mo16706Oi());
                intent.putExtra("sns_title", this.ehM.mo16707Oj());
                if (C21877n.qFC != null) {
                    intent = C21877n.qFC.mo8622e(intent, this.ehM.field_username);
                }
                if (intent == null) {
                    this.crP.finish();
                } else {
                    intent.putExtra("sns_adapter_type", 1);
                    C25985d.m41467b(this.crP, "sns", ".ui.SnsTimeLineUserPagerUI", intent);
                    if ((intent.getFlags() & 67108864) != 0) {
                        this.crP.finish();
                    }
                }
            } else {
                C23639t.m36492hO(this.crP);
                AppMethodBeat.m2505o(23575);
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
            if (!C5046bo.isNullOrNil(stringExtra)) {
                stringExtra2 = m81603mJ(stringExtra);
                Intent intent3 = new Intent();
                intent3.putExtra("Contact_User", stringExtra);
                intent3.putExtra("Contact_RemarkName", stringExtra2);
                intent3.putExtra("Contact_RoomNickname", stringExtra2);
                intent3.putExtra("Contact_RoomMember", true);
                intent3.putExtra("room_name", this.ejD);
                C9638aw.m17190ZK();
                intent3.putExtra("Contact_Nick", C18628c.m29078XM().aoO(stringExtra).field_nickname);
                intent3.putExtra("Contact_Scene", 14);
                intent3.putExtra("Is_RoomOwner", true);
                intent3.putExtra("Contact_ChatRoomId", this.ejD);
                C39503b.gkE.mo38912c(intent3, this.crP);
            }
        }
        AppMethodBeat.m2505o(23575);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: UT */
    public final void mo71826UT(String str) {
        AppMethodBeat.m2504i(23576);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.ContactWidgetNormal", "view stranger remark, username is null");
            AppMethodBeat.m2505o(23576);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Scene", this.gwP);
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", this.ehM.field_username);
        intent.putExtra("Contact_Nick", this.ehM.field_nickname);
        intent.putExtra("Contact_RemarkName", this.ehM.field_conRemark);
        C39503b.gkE.mo38929n(intent, this.crP);
        AppMethodBeat.m2505o(23576);
    }

    private void cbc() {
        String str = null;
        AppMethodBeat.m2504i(23577);
        ContactSocialInfoPreference contactSocialInfoPreference = (ContactSocialInfoPreference) this.ehK.aqO("contact_info_social");
        if (contactSocialInfoPreference != null) {
            if (C5046bo.isNullOrNil(this.pnm)) {
                contactSocialInfoPreference.mo68935Bb(8);
            } else {
                contactSocialInfoPreference.mo68935Bb(0);
                this.pnl = 1;
            }
            C9638aw.m17190ZK();
            int h = C5046bo.m7567h((Integer) C18628c.m29072Ry().get(9, (Object) str));
            long longExtra = this.crP.getIntent().getLongExtra("Contact_Uin", 0);
            String stringExtra = this.crP.getIntent().getStringExtra("Contact_QQNick");
            if (!(longExtra == 0 || h == 0)) {
                if (stringExtra == null || stringExtra.length() == 0) {
                    C9878ao ge = C32923a.getQQListStg().mo73284ge(longExtra);
                    if (ge == null) {
                        ge = str;
                    }
                    if (ge != null) {
                        ge.getDisplayName();
                    }
                }
                if (longExtra == -1 || new C1183p(longExtra).longValue() <= 0) {
                    contactSocialInfoPreference.mo68931AX(8);
                } else {
                    contactSocialInfoPreference.mo68931AX(0);
                    this.pnl = 1;
                }
            }
            if (C5046bo.isNullOrNil(this.pma) || C5046bo.isNullOrNil(this.pnh)) {
                contactSocialInfoPreference.mo68933AZ(8);
            } else {
                contactSocialInfoPreference.mo68933AZ(0);
                this.pnl = 1;
            }
            String value = C26373g.m41964Nu().getValue("LinkedinPluginClose");
            if (C5046bo.isNullOrNil(value) || Integer.valueOf(value).intValue() == 0) {
                h = 1;
            } else {
                h = 0;
            }
            if (h == 0 || C5046bo.isNullOrNil(this.ehM.dun)) {
                contactSocialInfoPreference.mo68932AY(8);
            } else {
                contactSocialInfoPreference.mo68932AY(0);
                this.pnl = 1;
            }
            if (C1853r.m3846Yz().equals(this.ehM.field_username)) {
                C9638aw.m17190ZK();
                value = (String) C18628c.m29072Ry().get(C5127a.USERINFO_PROFILE_WEIDIANINFO_STRING, (Object) str);
            } else {
                value = this.ehM.duq;
            }
            if (!C5046bo.isNullOrNil(value)) {
                try {
                    str = new JSONObject(value).optString("ShopUrl");
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "", new Object[0]);
                }
            }
            C4990ab.m7417i("MicroMsg.ContactWidgetNormal", "weiShopInfo:%s, shopUrl:%s", value, str);
            if (C5046bo.isNullOrNil(str)) {
                contactSocialInfoPreference.mo68934Ba(8);
            } else {
                contactSocialInfoPreference.mo68934Ba(0);
                this.pnl = 1;
            }
            if (this.pnl == 0) {
                this.ehK.aqP("contact_info_social");
            }
        }
        AppMethodBeat.m2505o(23577);
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.m2504i(23578);
        if (c7616ad != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (C5046bo.nullAsNil(c7616ad.field_username).length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (c15541f != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        this.ehK = c15541f;
        this.ehM = c7616ad;
        this.pli = z;
        this.gwP = i;
        this.plj = this.crP.getIntent().getBooleanExtra("User_Verify", false);
        this.mGZ = C5046bo.nullAsNil(this.crP.getIntent().getStringExtra("Verify_ticket"));
        this.pnc = this.crP.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
        this.pmV = this.crP.getIntent().getIntExtra("Kdel_from", -1);
        this.pnd = this.crP.getIntent().getStringExtra("Contact_RemarkName");
        this.czs = this.crP.getIntent().getIntExtra("Sns_from_Scene", 0);
        this.pnf = this.crP.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
        this.png = this.crP.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
        this.pne = this.crP.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
        long longExtra = this.crP.getIntent().getLongExtra("Contact_KSnsBgId", -1);
        String bc = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
        this.pma = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("verify_gmail"), "");
        this.pnh = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("profileName"), C5046bo.anu(this.pma));
        this.pnb.guY = this.pne;
        this.pnb.gva = longExtra;
        this.pnb.guZ = bc;
        this.pnj = this.crP.getIntent().getStringExtra("KLinkedInAddFriendNickName");
        this.pnk = this.crP.getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
        if (C21877n.qFy != null) {
            this.pnb = C21877n.qFy.mo47114b(c7616ad.field_username, this.pnb);
        }
        this.ejD = this.crP.getIntent().getStringExtra("room_name");
        C9638aw.m17190ZK();
        this.eih = C18628c.m29087XV().mo14885oa(this.ejD);
        this.pni = c7616ad.field_deleteFlag == 1;
        caT();
        C9638aw.m17190ZK();
        C18628c.m29078XM().aoJ(c7616ad.field_username);
        z2 = C1853r.m3846Yz().equals(c7616ad.field_username);
        C4990ab.m7419v("MicroMsg.ContactWidgetNormal", "get from extinfo %s", Integer.valueOf(this.pnb.guY));
        if ((this.pnb.guY & 1) > 0) {
            z3 = true;
        }
        if (!(c7616ad.mo16698Oa() || C7616ad.aov(c7616ad.field_username) || !z3 || C21877n.qFC == null)) {
            C21877n.qFC.mo8618a(2, c7616ad.field_username, z2, this.czs);
        }
        AppMethodBeat.m2505o(23578);
        return true;
    }

    private void caT() {
        String stringExtra;
        int i;
        KeyValuePreference keyValuePreference;
        AppMethodBeat.m2504i(23579);
        biV();
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8488a4);
        if (C21877n.qFC != null) {
            C21877n.qFC.mo8617a(3, this.ehM.field_username, this);
        }
        C9638aw.m17182Rg().mo14539a(30, (C1202f) this);
        C9638aw.m17182Rg().mo14539a((int) C38317l.CTRL_INDEX, (C1202f) this);
        this.pnm = "";
        C4990ab.m7417i("MicroMsg.ContactWidgetNormal", "isCancelMatchPhoneMD5 %s", this.ehM.mo16703Of());
        if (!this.ehM.mo16703Of()) {
            C18817a c18817a = null;
            stringExtra = this.crP.getIntent().getStringExtra("Contact_Mobile_MD5");
            String stringExtra2 = this.crP.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            String str;
            Object[] objArr;
            if (C5046bo.isNullOrNil(stringExtra) && C5046bo.isNullOrNil(stringExtra2)) {
                if (!C5046bo.isNullOrNil(this.ehM.field_username)) {
                    C18817a vT = C32923a.getAddrUploadStg().mo34089vT(this.ehM.field_username);
                    stringExtra2 = "MicroMsg.ContactWidgetNormal";
                    str = "Contact name: %s AddrUpload IS NULL? %s";
                    objArr = new Object[2];
                    objArr[0] = this.ehM.field_username;
                    objArr[1] = vT == null ? "true" : "false";
                    C4990ab.m7417i(stringExtra2, str, objArr);
                    c18817a = vT;
                }
            } else if (!(C5046bo.isNullOrNil(stringExtra) && C5046bo.isNullOrNil(stringExtra2))) {
                C4990ab.m7417i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", this.ehM.field_username, stringExtra, stringExtra2);
                c18817a = C32923a.getAddrUploadStg().mo34092vW(stringExtra);
                if (c18817a == null || C5046bo.isNullOrNil(c18817a.mo34067Aq())) {
                    c18817a = C32923a.getAddrUploadStg().mo34092vW(stringExtra2);
                }
                stringExtra2 = "MicroMsg.ContactWidgetNormal";
                str = "Contact name: %s AddrUpload IS NULL? %s";
                objArr = new Object[2];
                objArr[0] = this.ehM.field_username;
                objArr[1] = c18817a == null ? "true" : "false";
                C4990ab.m7417i(stringExtra2, str, objArr);
            }
            if (!(c18817a == null || C5046bo.isNullOrNil(c18817a.mo34067Aq()))) {
                this.pnm = C5046bo.nullAsNil(c18817a.apG()).replace(" ", "");
                C4990ab.m7417i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s", this.ehM.field_username, this.pnm);
            }
        }
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.ehK.aqO("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.mo56682a(this.ehM, this.gwP, this.mGZ, this.pnm, this.ehM.dur);
            normalUserHeaderPreference.mo56683bW(this.ehM.field_username, this.pnf);
            normalUserHeaderPreference.vri = new C447541();
            if (C7486a.m12942jh(this.ehM.field_type)) {
                this.png = false;
            }
            normalUserHeaderPreference.mo56684bX(this.ehM.field_username, this.png);
        } else {
            this.ehK.mo27716d(normalUserHeaderPreference);
        }
        if (C7616ad.aox(this.ehM.field_username) && this.ehM.duv != 0) {
            int indexOf = this.ehK.indexOf("contact_info_category_1");
            CharSequence c = ((C32873b) C1720g.m3528K(C32873b.class)).mo44307c(this.ehM.field_openImAppid, "openim_custom_info_header", C32874a.TYPE_WORDING);
            if (!TextUtils.isEmpty(c)) {
                PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this.crP);
                preferenceTitleCategory.setTitle(c);
                this.ehK.mo27708a(preferenceTitleCategory, indexOf);
                preferenceTitleCategory.yCX = new C128594();
            }
            C32875c c32875c = new C32875c();
            c32875c.mo53440vj(this.ehM.duw);
            for (final C18734a c18734a : c32875c.geU) {
                for (final C26514b c26514b : c18734a.geV) {
                    indexOf++;
                    C36355 c36355 = new KeyValuePreference(this.crP) {
                        public final void onBindView(View view) {
                            AppMethodBeat.m2504i(23569);
                            super.onBindView(view);
                            if (this.pnu != null) {
                                int i = (c26514b.action == 2 || c26514b.action == 3) ? 1 : 0;
                                if (i != 0) {
                                    this.pnu.setTextColor(C4996ah.getResources().getColorStateList(C25738R.color.a86));
                                }
                            }
                            if (!(this.yCq == null || TextUtils.isEmpty(c26514b.cIY))) {
                                this.yCq.setVisibility(0);
                                C32291o.ahp().mo43765a(c26514b.cIY, this.yCq);
                            }
                            AppMethodBeat.m2505o(23569);
                        }
                    };
                    c36355.ylA = c18734a.title;
                    c36355.setSummary((CharSequence) C44089j.m79292b(this.crP, c26514b.mo44297vk(this.ehM.field_openImAppid)));
                    this.ehK.mo27708a(c36355, indexOf);
                    if (c26514b.action == 0 || c26514b.action == 1) {
                        c36355.setEnabled(true);
                    } else if (c26514b.action == 2) {
                        c36355.yCX = new C23633b() {
                            public final boolean car() {
                                AppMethodBeat.m2504i(23570);
                                Object obj = c26514b.geX;
                                try {
                                    obj = new JSONObject(c26514b.geX).optString("tel");
                                } catch (JSONException e) {
                                    C4990ab.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "OpenIMCustomDetail.OPENIM_ACTION_DIAL_PHONE click parse error", new Object[0]);
                                }
                                C7060h.pYm.mo8381e(15319, C44753k.this.ehM.field_openImAppid, Integer.valueOf(c26514b.action), c18734a.title);
                                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(obj))));
                                intent.setFlags(268435456);
                                C44753k.this.crP.startActivity(intent);
                                AppMethodBeat.m2505o(23570);
                                return true;
                            }
                        };
                    } else if (c26514b.action == 3) {
                        c36355.yCX = new C23633b() {
                            public final boolean car() {
                                AppMethodBeat.m2504i(23571);
                                Object obj = "";
                                try {
                                    obj = new JSONObject(c26514b.geX).optString("mailto");
                                } catch (JSONException e) {
                                    C4990ab.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "loadProfile", new Object[0]);
                                }
                                C7060h.pYm.mo8381e(15319, C44753k.this.ehM.field_openImAppid, Integer.valueOf(c26514b.action), c18734a.title);
                                Intent intent = new Intent("android.intent.action.SENDTO");
                                intent.setData(Uri.parse(WebView.SCHEME_MAILTO.concat(String.valueOf(obj))));
                                C44753k.this.crP.startActivity(intent);
                                AppMethodBeat.m2505o(23571);
                                return true;
                            }
                        };
                    } else if (c26514b.action == 4) {
                        c36355.yCX = new C23633b() {
                            public final boolean car() {
                                AppMethodBeat.m2504i(23572);
                                Intent intent = new Intent();
                                intent.setFlags(268435456);
                                intent.setClassName(C4996ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                                String str = "";
                                try {
                                    str = new JSONObject(c26514b.geX).optString("url");
                                } catch (JSONException e) {
                                    C4990ab.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "loadProfile", new Object[0]);
                                }
                                C7060h.pYm.mo8381e(15319, C44753k.this.ehM.field_openImAppid, Integer.valueOf(c26514b.action), c18734a.title);
                                intent.putExtra("geta8key_scene", 58);
                                intent.putExtra("rawUrl", str);
                                C4996ah.getContext().startActivity(intent);
                                AppMethodBeat.m2505o(23572);
                                return true;
                            }
                        };
                    } else if (c26514b.action == 5) {
                        c36355.yCX = new C23633b() {
                            public final boolean car() {
                                AppMethodBeat.m2504i(23573);
                                try {
                                    JSONObject jSONObject = new JSONObject(c26514b.geX);
                                    String optString = jSONObject.optString("name");
                                    String optString2 = jSONObject.optString("pagepath");
                                    C32628se c32628se = new C32628se();
                                    c32628se.cOf.userName = optString;
                                    c32628se.cOf.cOh = C5046bo.m7532bc(optString2, "");
                                    C4879a.xxA.mo10055m(c32628se);
                                    C7060h.pYm.mo8381e(15319, C44753k.this.ehM.field_openImAppid, Integer.valueOf(c26514b.action), c18734a.title);
                                } catch (JSONException e) {
                                    C4990ab.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "loadProfile", new Object[0]);
                                }
                                AppMethodBeat.m2505o(23573);
                                return true;
                            }
                        };
                    }
                }
            }
            i = indexOf + 1;
            this.ehK.mo27708a(new PreferenceSmallCategory(this.crP), i);
            int i2 = i + 1;
            KeyValuePreference keyValuePreference2 = new KeyValuePreference(this.crP);
            keyValuePreference2.setTitle((int) C25738R.string.avq);
            final CharSequence c2 = ((C32873b) C1720g.m3528K(C32873b.class)).mo44307c(this.ehM.field_openImAppid, "openim_intro_desc", C32874a.TYPE_WORDING);
            keyValuePreference2.setSummary((CharSequence) C44089j.m79292b(this.crP, c2));
            stringExtra = ((C32873b) C1720g.m3528K(C32873b.class)).mo44307c(this.ehM.field_openImAppid, "openim_intro_url", C32874a.TYPE_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                keyValuePreference2.yCX = new C23633b() {
                    public final boolean car() {
                        AppMethodBeat.m2504i(23574);
                        Intent intent = new Intent();
                        intent.setFlags(268435456);
                        intent.setClassName(C4996ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                        intent.putExtra("rawUrl", stringExtra);
                        intent.putExtra("geta8key_scene", 58);
                        C4996ah.getContext().startActivity(intent);
                        C7060h.pYm.mo8381e(15319, C44753k.this.ehM.field_openImAppid, Integer.valueOf(6), c2);
                        AppMethodBeat.m2505o(23574);
                        return true;
                    }
                };
            }
            this.ehK.mo27708a(keyValuePreference2, i2);
        }
        if (C5046bo.isNullOrNil(this.ehM.getProvince())) {
            this.ehK.aqP("contact_info_district");
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_district");
            if (keyValuePreference != null) {
                keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.avo));
                keyValuePreference.setSummary((CharSequence) C1854s.m3868mL(this.ehM.getProvince()) + (C5046bo.isNullOrNil(this.ehM.getCity()) ? "" : "  " + this.ehM.getCity()));
                keyValuePreference.mo41844qi(false);
                keyValuePreference.setEnabled(false);
            }
        }
        if (this.ehM.signature == null || this.ehM.signature.trim().equals("") || C7486a.m12942jh(this.ehM.field_type)) {
            this.ehK.aqP("contact_info_signature");
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_signature");
            if (keyValuePreference != null) {
                keyValuePreference.yCj = false;
                keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b0a));
                keyValuePreference.setSummary((CharSequence) C44089j.m79292b(this.crP, this.ehM.signature));
                keyValuePreference.mo41844qi(false);
            }
        }
        this.ehK.aqO("contact_info_facebook");
        this.ehK.aqP("contact_info_facebook");
        if ((this.pnb.guY & 1) > 0) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i & C25985d.afj("sns")) == 0 || C7616ad.aov(this.ehM.field_username) || this.ehM.mo16698Oa()) {
            this.ehK.aqP("contact_info_sns");
        } else {
            C46634g c46634g = (C46634g) this.ehK.aqO("contact_info_sns");
            if (!(c46634g == null || C21877n.qFy == null)) {
                c46634g.ajO(this.ehM.field_username);
            }
        }
        this.ehK.aqP("contact_info_verifyuser");
        this.ehK.aqP("contact_info_footer_normal");
        new C43387b(this.crP, this.ehM).bKH();
        if (this.gwP == 96) {
            this.ehK.aqP("contact_info_footer_normal");
        }
        if (C7486a.m12942jh(this.ehM.field_type)) {
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
        if (normalUserFooterPreference == null || !normalUserFooterPreference.mo55318a(this.ehM, this.mGZ, this.pli, this.plj, this.pnc, this.gwP, this.pmV, booleanExtra2, booleanExtra, longExtra, this.pnd)) {
            this.ehK.aqP("contact_info_footer_normal");
        } else {
            normalUserFooterPreference.fry.removeAll();
            normalUserFooterPreference.fry.mo10125a(new C363411(), Looper.getMainLooper());
        }
        this.ehK.aqP("clear_lbs_info");
        if (this.pni) {
            this.ehK.removeAll();
            if (normalUserHeaderPreference != null) {
                this.ehK.mo27713b(normalUserHeaderPreference);
            }
            if (normalUserFooterPreference != null) {
                this.ehK.mo27713b(normalUserFooterPreference);
            }
        }
        AppMethodBeat.m2505o(23579);
    }

    private void cbd() {
        AppMethodBeat.m2504i(23580);
        if (C7486a.m12942jh(this.ehM.field_type)) {
            this.ehK.aqP("contact_info_source");
            AppMethodBeat.m2505o(23580);
            return;
        }
        int intExtra = this.crP.getIntent().getIntExtra("Contact_Source_FMessage", 0);
        C4990ab.m7410d("MicroMsg.ContactWidgetNormal", "initFriendSource, contact source = " + this.ehM.getSource() + ", sourceFMessage = " + intExtra);
        if (intExtra != 0) {
            m81602Bf(intExtra);
            AppMethodBeat.m2505o(23580);
            return;
        }
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_source");
        if (this.plj) {
            switch (this.ehM.getSource()) {
                case 18:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        keyValuePreference.setSummary((int) C25738R.string.b12);
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23580);
                        return;
                    }
                    break;
                case 22:
                case 23:
                case 24:
                case 26:
                case 27:
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                case 29:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        keyValuePreference.setSummary((int) C25738R.string.b1j);
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23580);
                        return;
                    }
                    break;
                case 30:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        keyValuePreference.setSummary((int) C25738R.string.b17);
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23580);
                        return;
                    }
                    break;
                case 34:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        keyValuePreference.setSummary((CharSequence) this.crP.getString(C25738R.string.b0m));
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23580);
                        return;
                    }
                    break;
                case 48:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        keyValuePreference.setSummary((CharSequence) this.crP.getString(C25738R.string.b19));
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23580);
                        return;
                    }
                    break;
                case C42464aa.CTRL_INDEX /*58*/:
                case C2206au.CTRL_INDEX /*59*/:
                case 60:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        keyValuePreference.setSummary((CharSequence) this.crP.getString(C25738R.string.c8k));
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23580);
                        return;
                    }
                    break;
                case 76:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        keyValuePreference.setSummary((CharSequence) this.crP.getString(C25738R.string.b14));
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23580);
                        return;
                    }
                    break;
                default:
                    this.ehK.mo27716d(keyValuePreference);
                    AppMethodBeat.m2505o(23580);
                    return;
            }
        }
        this.ehK.mo27716d(keyValuePreference);
        AppMethodBeat.m2505o(23580);
    }

    private void cbe() {
        AppMethodBeat.m2504i(23581);
        this.ehK.mo27715ce("contact_info_invite_source", true);
        boolean booleanExtra = this.eih == null ? this.crP.getIntent().getBooleanExtra("Is_RoomOwner", false) : this.eih.mo16786JR();
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
            C4990ab.m7417i(str, str2, objArr);
            this.ehK.mo27715ce("contact_info_invite_source", true);
            AppMethodBeat.m2505o(23581);
            return;
        }
        this.ctQ = this.crP.getIntent().getStringExtra("inviteer");
        if (C5046bo.isNullOrNil(this.ctQ)) {
            this.ctQ = this.eih.aop(this.ehM.field_username);
        }
        if (C5046bo.isNullOrNil(this.ctQ)) {
            this.ctQ = C37921n.m64046Z(this.ehM.field_username, this.ejD);
        }
        if (C5046bo.isNullOrNil(this.ctQ)) {
            C4990ab.m7421w("MicroMsg.ContactWidgetNormal", "mRoomId:%s member:%s , inviteer is null!", this.ejD, this.ehM.field_username);
            this.pnn.dnU();
            C26417a.flu.mo20966a(this.ehM.field_username, this.ejD, new C347302());
            AppMethodBeat.m2505o(23581);
            return;
        }
        this.crP.getIntent().putExtra("inviteer", this.ctQ);
        String mJ = m81603mJ(this.ctQ);
        if (C5046bo.isNullOrNil(mJ)) {
            C26417a.flu.mo20966a(this.ehM.field_username, "", new C347313());
            AppMethodBeat.m2505o(23581);
            return;
        }
        mo71827fE(this.ctQ, mJ);
        AppMethodBeat.m2505o(23581);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: fE */
    public final void mo71827fE(String str, String str2) {
        AppMethodBeat.m2504i(23582);
        C4990ab.m7417i("MicroMsg.ContactWidgetNormal", "[showInviteerView] inviteer:%s inviteerDisplayName:%s", str, str2);
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_invite_source");
        TextPreference textPreference = (TextPreference) this.ehK.aqO("contact_info_hint");
        this.ehK.mo27715ce("contact_info_invite_source", false);
        SpannableString spannableString = new SpannableString(C44089j.m79292b(this.crP, this.crP.getResources().getString(C25738R.string.awu, new Object[]{str2})));
        spannableString.setSpan(new ForegroundColorSpan(this.crP.getResources().getColor(C25738R.color.f11795hi)), 0, str2.length(), 33);
        keyValuePreference.setSummary((CharSequence) spannableString);
        keyValuePreference.getExtras().putString("inviteer", str);
        this.crP.getIntent().putExtra("inviteer", str);
        if (this.eih == null || this.eih.afg().contains(this.ehM.field_username)) {
            this.ehK.mo27715ce("contact_info_footer_normal", false);
            AppMethodBeat.m2505o(23582);
            return;
        }
        this.ehK.mo27715ce("contact_info_footer_normal", true);
        textPreference.mo56922ae(C44089j.m79292b(this.crP, this.crP.getResources().getString(C25738R.string.ay_, new Object[]{m81603mJ(this.ehM.field_username)})));
        AppMethodBeat.m2505o(23582);
    }

    /* renamed from: mJ */
    private String m81603mJ(String str) {
        String str2 = null;
        AppMethodBeat.m2504i(23583);
        if (this.eih == null) {
            AppMethodBeat.m2505o(23583);
        } else {
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(str);
            if (aoO != null && ((int) aoO.ewQ) > 0) {
                str2 = aoO.field_conRemark;
            }
            if (C5046bo.isNullOrNil(str2)) {
                str2 = this.eih.mo16807mJ(str);
            }
            if (C5046bo.isNullOrNil(str2) && aoO != null) {
                str2 = aoO.mo16706Oi();
            }
            AppMethodBeat.m2505o(23583);
        }
        return str2;
    }

    /* renamed from: Bf */
    private void m81602Bf(int i) {
        AppMethodBeat.m2504i(23584);
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_source");
        if (this.plj) {
            String str;
            switch (i) {
                case 1:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        keyValuePreference.setSummary((int) C25738R.string.b1d);
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23584);
                        return;
                    }
                    break;
                case 3:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        keyValuePreference.setSummary((int) C25738R.string.b1g);
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23584);
                        return;
                    }
                    break;
                case 4:
                case 12:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        keyValuePreference.setSummary((CharSequence) this.crP.getString(C25738R.string.bw3));
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23584);
                        return;
                    }
                    break;
                case 8:
                case 14:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        C7569ax apw = C41789d.akO().apw(this.ehM.field_username);
                        C9638aw.m17190ZK();
                        C7616ad aoO = C18628c.m29078XM().aoO(apw == null ? "" : apw.field_chatroomName);
                        if (aoO != null) {
                            str = aoO.field_nickname;
                        } else {
                            str = null;
                        }
                        if (C5046bo.isNullOrNil(str)) {
                            keyValuePreference.setSummary((int) C25738R.string.b0y);
                        } else {
                            keyValuePreference.setSummary((CharSequence) this.crP.getString(C25738R.string.b10, new Object[]{str}));
                        }
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23584);
                        return;
                    }
                    break;
                case 10:
                case 13:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        keyValuePreference.setSummary((int) C25738R.string.b1m);
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23584);
                        return;
                    }
                    break;
                case 15:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        keyValuePreference.setSummary((int) C25738R.string.b1a);
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23584);
                        return;
                    }
                    break;
                case 17:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        str = C1854s.m3866mJ(this.crP.getIntent().getStringExtra("source_from_user_name"));
                        if (C5046bo.isNullOrNil(str)) {
                            str = this.crP.getIntent().getStringExtra("source_from_nick_name");
                        }
                        if (C5046bo.isNullOrNil(str)) {
                            keyValuePreference.setSummary((int) C25738R.string.b0u);
                        } else {
                            keyValuePreference.setSummary((CharSequence) C44089j.m79292b(this.crP, this.crP.getString(C25738R.string.b0t, new Object[]{str})));
                        }
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23584);
                        return;
                    }
                    break;
                case 18:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        keyValuePreference.setSummary((int) C25738R.string.b12);
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23584);
                        return;
                    }
                    break;
                case 25:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        keyValuePreference.setSummary((int) C25738R.string.b0p);
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23584);
                        return;
                    }
                    break;
                case 30:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        keyValuePreference.setSummary((int) C25738R.string.b17);
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23584);
                        return;
                    }
                    break;
                case 48:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        keyValuePreference.setSummary((CharSequence) this.crP.getString(C25738R.string.b19));
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23584);
                        return;
                    }
                    break;
                case C42464aa.CTRL_INDEX /*58*/:
                case C2206au.CTRL_INDEX /*59*/:
                case 60:
                    if (keyValuePreference != null) {
                        keyValuePreference.yCj = false;
                        keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                        keyValuePreference.setSummary((CharSequence) this.crP.getString(C25738R.string.c8k));
                        keyValuePreference.mo41844qi(false);
                        AppMethodBeat.m2505o(23584);
                        return;
                    }
                    break;
                default:
                    this.ehK.mo27716d(keyValuePreference);
                    break;
            }
            AppMethodBeat.m2505o(23584);
            return;
        }
        if (keyValuePreference != null) {
            if (i == 10) {
                keyValuePreference.yCj = false;
                keyValuePreference.setTitle((CharSequence) this.crP.getString(C25738R.string.b1p));
                keyValuePreference.setSummary((CharSequence) this.crP.getString(C25738R.string.bw2));
                keyValuePreference.mo41844qi(false);
                AppMethodBeat.m2505o(23584);
                return;
            }
            this.ehK.mo27716d(keyValuePreference);
        }
        AppMethodBeat.m2505o(23584);
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
        AppMethodBeat.m2504i(23585);
        int[] iArr = new int[7];
        ContactMoreInfoPreference contactMoreInfoPreference = (ContactMoreInfoPreference) this.ehK.aqO("contact_info_more");
        if (contactMoreInfoPreference != null) {
            String str;
            long longExtra = this.crP.getIntent().getLongExtra("Contact_Uin", 0);
            if (longExtra == -1 || new C1183p(longExtra).longValue() <= 0) {
                contactMoreInfoPreference.mo24862AX(8);
                iArr[0] = 8;
            } else {
                contactMoreInfoPreference.mo24862AX(0);
                iArr[0] = 0;
            }
            if (C5046bo.isNullOrNil(this.pma) || C5046bo.isNullOrNil(this.pnh)) {
                contactMoreInfoPreference.mo24864AZ(8);
                iArr[1] = 8;
            } else {
                contactMoreInfoPreference.mo24864AZ(0);
                iArr[1] = 0;
            }
            String value = C26373g.m41964Nu().getValue("LinkedinPluginClose");
            if (!(C5046bo.isNullOrNil(value) || Integer.valueOf(value).intValue() == 0)) {
                i = 0;
            }
            if (i == 0 || C5046bo.isNullOrNil(this.ehM.dun)) {
                contactMoreInfoPreference.mo24863AY(8);
                iArr[2] = 8;
            } else {
                contactMoreInfoPreference.mo24863AY(0);
                iArr[2] = 0;
            }
            if (C1853r.m3846Yz().equals(this.ehM.field_username)) {
                C9638aw.m17190ZK();
                str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_PROFILE_WEIDIANINFO_STRING, null);
            } else {
                str = this.ehM.duq;
            }
            if (!C5046bo.isNullOrNil(str)) {
                try {
                    str = new JSONObject(str).optString("ShopUrl");
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "", new Object[0]);
                }
                if (C5046bo.isNullOrNil(str)) {
                    contactMoreInfoPreference.mo24865Ba(0);
                    iArr[3] = 0;
                } else {
                    contactMoreInfoPreference.mo24865Ba(8);
                    iArr[3] = 8;
                }
                if (C5046bo.isNullOrNil(this.ehM.signature)) {
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
                this.ehK.mo27715ce("contact_info_more", false);
            }
            str = null;
            if (C5046bo.isNullOrNil(str)) {
            }
            if (C5046bo.isNullOrNil(this.ehM.signature)) {
            }
            if (this.ehM.getSource() > 0) {
            }
            iArr[6] = 8;
            this.ehK.mo27715ce("contact_info_more", false);
        }
        AppMethodBeat.m2505o(23585);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(23587);
        if (c1207m.getType() == 30 || c1207m.getType() == FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED) {
            if (i == 0 && i2 == 0) {
                if (c1207m.getType() == 30) {
                    C46498m c46498m = (C46498m) c1207m;
                    if (c46498m.cAd != 1 && c46498m.cAd != 3) {
                        AppMethodBeat.m2505o(23587);
                        return;
                    } else if (c46498m.vbm == null || c46498m.vbm.contains(this.ehM.field_username)) {
                        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.ehK.aqO("contact_info_header_normal");
                        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.ehK.aqO("contact_info_footer_normal");
                        if (!(normalUserHeaderPreference == null || normalUserFooterPreference == null || !normalUserFooterPreference.poQ)) {
                            C4990ab.m7410d("MicroMsg.ContactWidgetNormal", "happy update remark change");
                            this.pnf = false;
                            this.png = false;
                            normalUserHeaderPreference.mo56683bW(this.ehM.field_username, false);
                            normalUserHeaderPreference.mo56684bX(this.ehM.field_username, false);
                            normalUserHeaderPreference.mo20342qj(this.ehM.field_username);
                            this.crP.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.pnf);
                            this.crP.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.png);
                        }
                    } else {
                        AppMethodBeat.m2505o(23587);
                        return;
                    }
                }
                if (c1207m.getType() == C38317l.CTRL_INDEX) {
                    caT();
                    AppMethodBeat.m2505o(23587);
                    return;
                }
            } else if (i == 4 && i2 == -24 && !C5046bo.isNullOrNil(str)) {
                Toast.makeText(this.crP, str, 1).show();
            }
            AppMethodBeat.m2505o(23587);
            return;
        }
        C4990ab.m7420w("MicroMsg.ContactWidgetNormal", "not expected scene,  type = " + c1207m.getType());
        AppMethodBeat.m2505o(23587);
    }

    /* renamed from: a */
    public final void mo17657a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j, String str2) {
        AppMethodBeat.m2504i(23588);
        C46634g c46634g = (C46634g) this.ehK.aqO("contact_info_sns");
        if (!(c46634g == null || C21877n.qFy == null)) {
            c46634g.ajO(this.ehM.field_username);
        }
        this.pnb = C21877n.qFy.mo47114b(this.ehM.field_username, this.pnb);
        this.ehK.notifyDataSetChanged();
        if (z3) {
            C4990ab.m7410d("MicroMsg.ContactWidgetNormal", "bg Change!");
            if (C21877n.qFC != null) {
                C21877n.qFC.mo8614WZ(this.ehM.field_username);
            }
        }
        AppMethodBeat.m2505o(23588);
    }

    /* renamed from: a */
    public final void mo17656a(boolean z, String str, boolean z2, boolean z3, int i, long j, String str2) {
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(23586);
        if (C21877n.qFC != null) {
            C21877n.qFC.mo8619a(this, 3);
        }
        C9638aw.m17182Rg().mo14546b(30, (C1202f) this);
        C9638aw.m17182Rg().mo14546b((int) C38317l.CTRL_INDEX, (C1202f) this);
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
        AppMethodBeat.m2505o(23586);
        return true;
    }
}
