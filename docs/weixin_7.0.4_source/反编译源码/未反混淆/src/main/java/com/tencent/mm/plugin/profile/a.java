package com.tencent.mm.plugin.profile;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.plugin.profile.ui.MultiButtonPreference;
import com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.story.api.AbsStoryPreference;
import com.tencent.mm.plugin.story.api.d;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.preference.ButtonPreference;
import com.tencent.mm.pluginsdk.ui.preference.LabelPreference;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.ProfileDescribePreference;
import com.tencent.mm.protocal.protobuf.alp;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.TextPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import java.util.LinkedList;
import java.util.List;

public final class a implements com.tencent.mm.plugin.sns.b.h.a, d, com.tencent.mm.pluginsdk.b.a {
    u eih;
    String ejD;
    private int gOW;
    f iFE;
    MMActivity jiE;
    ad ldh;
    b pkh;
    private com.tencent.mm.ui.widget.a.d pki;
    String pkj = null;
    c<at> pkk = new c<at>() {
        {
            AppMethodBeat.i(23210);
            this.xxI = at.class.getName().hashCode();
            AppMethodBeat.o(23210);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(23211);
            final at atVar = (at) bVar;
            ab.i("MicroMsg.NewContactWidgetNormal", "[ChatroomMemberInviterUpdatedEvent callback] username:%s inviter:%s", atVar.ctP.username, atVar.ctP.ctQ);
            if (!(bo.isNullOrNil(atVar.ctP.username) || !atVar.ctP.username.equals(a.this.ldh.field_username) || bo.isNullOrNil(atVar.ctP.ctQ))) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(23209);
                        final String str = atVar.ctP.ctQ;
                        a.this.jiE.getIntent().putExtra("inviteer", str);
                        String b = a.b(a.this.eih, atVar.ctP.ctQ);
                        ab.i("MicroMsg.NewContactWidgetNormal", "[ChatroomMemberInviterUpdatedEvent callback] inviter:%s inviterDisplayName:%s", str, b);
                        if (bo.isNullOrNil(b)) {
                            com.tencent.mm.model.ao.a.flu.a(str, "", new com.tencent.mm.model.ao.b.a() {
                                public final void o(String str, boolean z) {
                                    AppMethodBeat.i(23208);
                                    ab.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", str, a.this.ejD, Boolean.valueOf(z));
                                    if (z) {
                                        aw.ZK();
                                        a.a(a.this.iFE, a.this.jiE, str, com.tencent.mm.model.c.XM().aoO(str).Oi());
                                    }
                                    AppMethodBeat.o(23208);
                                }
                            });
                            AppMethodBeat.o(23209);
                            return;
                        }
                        a.a(a.this.iFE, a.this.jiE, str, b);
                        AppMethodBeat.o(23209);
                    }
                });
            }
            AppMethodBeat.o(23211);
            return false;
        }
    };
    private boolean readOnly = false;

    public a(MMActivity mMActivity) {
        AppMethodBeat.i(23220);
        this.jiE = mMActivity;
        AppMethodBeat.o(23220);
    }

    /* JADX WARNING: Removed duplicated region for block: B:286:0x0ad8  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x0acd  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0806  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x0ae3  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x084f  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x0aed  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x089f  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x08ea  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x064d  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0a21  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0a35  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x06c3  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x06dd  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x0a43  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0709  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x076b  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x079b  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x07cc  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x0acd  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x0ad8  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0806  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x084f  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x0ae3  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0867 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x089f  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x0aed  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x08ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(f fVar, ad adVar, boolean z, int i) {
        int i2;
        String c;
        AppMethodBeat.i(23221);
        this.readOnly = this.readOnly;
        this.iFE = fVar;
        this.ldh = adVar;
        this.gOW = i;
        this.ejD = this.jiE.getIntent().getStringExtra("room_name");
        aw.ZK();
        this.eih = com.tencent.mm.model.c.XV().oa(this.ejD);
        if (this.pkh == null) {
            this.pkh = new b(this.jiE, adVar);
            this.pkh.bKH();
        }
        ab.i("MicroMsg.NewContactWidgetNormal", "[onAttach] username:%s", adVar.field_username);
        fVar.removeAll();
        fVar.addPreferencesFromResource(R.xml.b5);
        NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) fVar.aqO("contact_profile_header_normal");
        normalProfileHeaderPreference.iFE = fVar;
        normalProfileHeaderPreference.a(adVar, i, z, this.pkh);
        ButtonPreference buttonPreference = (ButtonPreference) fVar.aqO("contact_profile_send");
        if (buttonPreference != null) {
            buttonPreference.vql = R.id.b59;
        }
        Context context = this.jiE;
        ad adVar2 = this.ldh;
        if (ad.aox(adVar2.field_username) && adVar2.duv != 0) {
            int indexOf = fVar.indexOf("contact_info_category_1");
            CharSequence c2 = ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).c(adVar2.field_openImAppid, "openim_custom_info_header", com.tencent.mm.openim.a.b.a.TYPE_WORDING);
            if (!TextUtils.isEmpty(c2)) {
                PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(context);
                preferenceTitleCategory.setTitle(c2);
                fVar.a(preferenceTitleCategory, indexOf);
                preferenceTitleCategory.yCX = new Preference.b() {
                    public final boolean car() {
                        return false;
                    }
                };
            }
            com.tencent.mm.openim.a.c cVar = new com.tencent.mm.openim.a.c();
            cVar.vj(adVar2.duw);
            for (com.tencent.mm.openim.a.c.a aVar : cVar.geU) {
                for (com.tencent.mm.openim.a.c.b bVar : aVar.geV) {
                    indexOf++;
                    com.tencent.mm.plugin.profile.a.a.AnonymousClass2 anonymousClass2 = new com.tencent.mm.plugin.profile.a.a.AnonymousClass2(context, bVar);
                    anonymousClass2.ylA = aVar.title;
                    anonymousClass2.setSummary((CharSequence) j.b(context, bVar.vk(adVar2.field_openImAppid)));
                    fVar.a(anonymousClass2, indexOf);
                    if (bVar.action == 0 || bVar.action == 1) {
                        anonymousClass2.setEnabled(true);
                    } else if (bVar.action == 2) {
                        anonymousClass2.yCX = new com.tencent.mm.plugin.profile.a.a.AnonymousClass3(bVar, adVar2, aVar, context);
                    } else if (bVar.action == 3) {
                        anonymousClass2.yCX = new com.tencent.mm.plugin.profile.a.a.AnonymousClass4(bVar, adVar2, aVar, context);
                    } else if (bVar.action == 4) {
                        anonymousClass2.yCX = new com.tencent.mm.plugin.profile.a.a.AnonymousClass5(bVar, adVar2, aVar);
                    } else if (bVar.action == 5) {
                        anonymousClass2.yCX = new com.tencent.mm.plugin.profile.a.a.AnonymousClass6(bVar, adVar2, aVar);
                    }
                }
            }
            i2 = indexOf + 1;
            fVar.a(new PreferenceSmallCategory(context), i2);
            int i3 = i2 + 1;
            KeyValuePreference keyValuePreference = new KeyValuePreference(context);
            keyValuePreference.setTitle((int) R.string.avq);
            CharSequence c3 = ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).c(adVar2.field_openImAppid, "openim_intro_desc", com.tencent.mm.openim.a.b.a.TYPE_WORDING);
            keyValuePreference.setSummary((CharSequence) j.b(context, c3));
            c = ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).c(adVar2.field_openImAppid, "openim_intro_url", com.tencent.mm.openim.a.b.a.TYPE_URL);
            if (!TextUtils.isEmpty(c)) {
                keyValuePreference.yCX = new com.tencent.mm.plugin.profile.a.a.AnonymousClass7(c, adVar2, c3);
            }
            fVar.a(keyValuePreference, i3);
        }
        KeyValuePreference keyValuePreference2;
        if (cai()) {
            fVar.removeAll();
            fVar.b(normalProfileHeaderPreference);
            fVar.b(new PreferenceSmallCategory(this.jiE));
            keyValuePreference2 = new KeyValuePreference(this.jiE);
            keyValuePreference2.setTitle((int) R.string.aww);
            keyValuePreference2.setSummary((int) R.string.b2e);
            keyValuePreference2.NT(BaseClientBuilder.API_PRIORITY_OTHER);
            keyValuePreference2.yCj = false;
            keyValuePreference2.NW(8);
            fVar.b(keyValuePreference2);
            fVar.b(new PreferenceSmallCategory(this.jiE));
            fVar.b(buttonPreference);
            this.pkh.knn.mController.removeAllOptionMenu();
            AppMethodBeat.o(23221);
            return true;
        }
        CharSequence charSequence;
        String str;
        Object obj;
        MultiButtonPreference multiButtonPreference;
        Object[] objArr;
        boolean aoJ;
        AnonymousClass7 anonymousClass7;
        ad adVar3 = this.ldh;
        i2 = this.jiE.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
        long longExtra = this.jiE.getIntent().getLongExtra("Contact_KSnsBgId", -1);
        String bc = bo.bc(this.jiE.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
        ccl ccl = new ccl();
        ccl.guY = i2;
        ccl.gva = longExtra;
        ccl.guZ = bc;
        if (n.qFy != null) {
            ccl = n.qFy.b(adVar3.field_username, ccl);
        }
        aw.ZK();
        boolean aoJ2 = com.tencent.mm.model.c.XM().aoJ(adVar3.field_username);
        boolean equals = r.Yz().equals(adVar3.field_username);
        ab.i("MicroMsg.NewContactWidgetNormal", "isFriend:%s isSelf:%s openAlbum:%s", Boolean.valueOf(aoJ2), Boolean.valueOf(equals), Boolean.valueOf((ccl.guY & 1) > 0));
        if ((!ad.aov(adVar3.field_username) && r4) || cak() || equals) {
            this.iFE.ce("contact_profile_sns", false);
            com.tencent.mm.ui.base.preference.g gVar = (com.tencent.mm.ui.base.preference.g) this.iFE.aqO("contact_profile_sns");
            if (n.qFC != null) {
                n.qFC.a(3, adVar3.field_username, this);
                n.qFC.a(2, adVar3.field_username, equals, this.jiE.getIntent().getIntExtra("Sns_from_Scene", 0));
            }
            gVar.ajO(adVar3.field_username);
        } else {
            this.iFE.ce("contact_profile_sns", true);
        }
        if (ad.aox(adVar3.field_username)) {
            this.iFE.ce("contact_profile_sns", true);
        }
        Preference aqO = fVar.aqO("contact_profile_setting_desc");
        if (ad.aox(this.ldh.field_username)) {
            charSequence = this.jiE.getText(R.string.b2o).toString();
        } else {
            charSequence = this.jiE.getText(R.string.b2n).toString();
        }
        aqO.setTitle(charSequence);
        keyValuePreference2 = (KeyValuePreference) fVar.aqO("contact_profile_source");
        CharSequence a = NormalProfileHeaderPreference.a(this.jiE, this.ldh, this.jiE.getIntent().getIntExtra("Contact_Source_FMessage", i), this.ldh.field_username, cak());
        keyValuePreference2.setSummary(a);
        keyValuePreference2.NT(2);
        keyValuePreference2.yCj = false;
        keyValuePreference2.nnX = ((float) com.tencent.mm.bz.a.ao(this.jiE, (int) this.jiE.getResources().getDimension(R.dimen.m5))) * com.tencent.mm.bz.a.dm(this.jiE);
        keyValuePreference2.NW(8);
        c = "contact_profile_source";
        boolean z2 = com.tencent.mm.n.a.jh(adVar.field_type) || bo.ac(a) || (cal() && !cak());
        fVar.ce(c, z2);
        LabelPreference labelPreference = (LabelPreference) fVar.aqO("contact_profile_label");
        labelPreference.ldh = adVar;
        if (!com.tencent.mm.n.a.jh(labelPreference.ldh.field_type)) {
            str = labelPreference.ldh.field_encryptUsername;
            if (!bo.isNullOrNil(str)) {
                aw.ZK();
                labelPreference.pCq = com.tencent.mm.model.c.XN().RB(str);
            }
            if (labelPreference.pCq != null && labelPreference.pCq.xDa < 0) {
                aw.ZK();
                labelPreference.pCq = com.tencent.mm.model.c.XN().RB(labelPreference.ldh.field_username);
            }
        }
        str = "contact_profile_label";
        if (com.tencent.mm.n.a.jh(labelPreference.ldh.field_type) && !bo.isNullOrNil(labelPreference.ldh.field_contactLabelIds)) {
            obj = 1;
        } else if (labelPreference.pCq == null || bo.isNullOrNil(labelPreference.pCq.field_contactLabels)) {
            obj = null;
        } else {
            obj = 1;
        }
        fVar.ce(str, obj == null);
        PhoneNumPreference phoneNumPreference = (PhoneNumPreference) fVar.aqO("contact_profile_phone");
        phoneNumPreference.iFE = fVar;
        Intent intent = this.jiE.getIntent();
        phoneNumPreference.ldh = adVar;
        phoneNumPreference.vin = adVar.dur;
        ab.i("MicroMsg.PhoneNumPreference", "isCancelMatchPhoneMD5 %s", adVar.Of());
        if (!adVar.Of()) {
            com.tencent.mm.plugin.account.friend.a.a aVar2 = null;
            bc = intent.getStringExtra("Contact_Mobile_MD5");
            c = intent.getStringExtra("Contact_full_Mobile_MD5");
            String str2;
            Object[] objArr2;
            if (bo.isNullOrNil(bc) && bo.isNullOrNil(c)) {
                if (!bo.isNullOrNil(adVar.field_username)) {
                    com.tencent.mm.plugin.account.friend.a.a vT = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(adVar.field_username);
                    bc = "MicroMsg.PhoneNumPreference";
                    str2 = "Contact name: %s AddrUpload IS NULL? %s";
                    objArr2 = new Object[2];
                    objArr2[0] = adVar.field_username;
                    objArr2[1] = vT == null ? "true" : "false";
                    ab.i(bc, str2, objArr2);
                    aVar2 = vT;
                }
            } else if (!(bo.isNullOrNil(bc) && bo.isNullOrNil(c))) {
                ab.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", adVar.field_username, bc, c);
                aVar2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(bc);
                if (aVar2 == null || bo.isNullOrNil(aVar2.Aq())) {
                    aVar2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(c);
                }
                bc = "MicroMsg.PhoneNumPreference";
                str2 = "Contact name: %s AddrUpload IS NULL? %s";
                objArr2 = new Object[2];
                objArr2[0] = adVar.field_username;
                objArr2[1] = aVar2 == null ? "true" : "false";
                ab.i(bc, str2, objArr2);
            }
            if (!(aVar2 == null || bo.isNullOrNil(aVar2.Aq()))) {
                phoneNumPreference.vim = bo.nullAsNil(aVar2.apG()).replace(" ", "");
                ab.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s", adVar.field_username, phoneNumPreference.vim);
            }
            phoneNumPreference.dlc();
        }
        phoneNumPreference.iFE.ce("contact_profile_phone", true);
        phoneNumPreference.dlc();
        phoneNumPreference.NW(8);
        ProfileDescribePreference profileDescribePreference = (ProfileDescribePreference) fVar.aqO("contact_profile_desc");
        profileDescribePreference.ldh = adVar;
        if (!com.tencent.mm.n.a.jh(profileDescribePreference.ldh.field_type)) {
            str = profileDescribePreference.ldh.field_encryptUsername;
            if (!bo.isNullOrNil(str)) {
                aw.ZK();
                profileDescribePreference.pCq = com.tencent.mm.model.c.XN().RB(str);
            }
            if (profileDescribePreference.pCq != null && profileDescribePreference.pCq.xDa < 0) {
                aw.ZK();
                profileDescribePreference.pCq = com.tencent.mm.model.c.XN().RB(profileDescribePreference.ldh.field_username);
            }
        }
        c = "contact_profile_desc";
        if (com.tencent.mm.n.a.jh(profileDescribePreference.ldh.field_type)) {
            obj = (bo.isNullOrNil(profileDescribePreference.ldh.dul) && (!bo.isNullOrNil(profileDescribePreference.ldh.dum) ? 1 : null) == null) ? null : 1;
        } else {
            obj = (profileDescribePreference.pCq == null || bo.isNullOrNil(profileDescribePreference.pCq.field_conDescription)) ? null : 1;
        }
        if (obj == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        fVar.ce(c, z2);
        if (com.tencent.mm.n.a.jh(adVar.field_type) || bo.isNullOrNil(adVar.signature)) {
            fVar.aqP("contact_info_signature");
        } else {
            keyValuePreference2 = (KeyValuePreference) fVar.aqO("contact_info_signature");
            if (keyValuePreference2 != null) {
                keyValuePreference2.nnX = ((float) com.tencent.mm.bz.a.ao(this.jiE, (int) this.jiE.getResources().getDimension(R.dimen.m5))) * com.tencent.mm.bz.a.dm(this.jiE);
                keyValuePreference2.yCj = false;
                keyValuePreference2.setTitle((CharSequence) this.jiE.getString(R.string.b0a));
                keyValuePreference2.setSummary((CharSequence) j.b(this.jiE, adVar.signature));
                keyValuePreference2.qi(false);
                keyValuePreference2.NT(5);
                keyValuePreference2.NW(8);
            }
        }
        if (fVar.aqQ("contact_profile_desc") < 0) {
            if (fVar.aqQ("contact_profile_label") < 0) {
                fVar.ce("contact_profile_setting_desc", false);
                if (!com.tencent.mm.n.a.jh(adVar.field_type)) {
                    fVar.ce("contact_profile_setting_desc", false);
                }
                fVar.ce("contact_profile_set_des_category", true);
                if (!ad.aox(this.ldh.field_username) && bo.isNullOrNil(this.ldh.field_conRemark)) {
                    fVar.ce("contact_profile_setting_desc", false);
                    fVar.ce("contact_profile_set_des_category", true);
                } else if (ad.aox(this.ldh.field_username)) {
                    fVar.ce("contact_profile_setting_desc", true);
                    fVar.ce("contact_profile_set_des_category", true);
                }
                fVar.aqO("contact_profile_info_more").setTitle(this.jiE.getText(R.string.ay0).toString());
                ((TextPreference) fVar.aqO("contact_profile_hint")).ae(this.jiE.getText(R.string.ay5));
                if (adVar.Oa()) {
                    fVar.ce("contact_profile_hint", true);
                } else {
                    fVar.ce("contact_profile_hint", false);
                }
                multiButtonPreference = (MultiButtonPreference) fVar.aqO("contact_profile_multi_button");
                if (!cak()) {
                    Object obj2;
                    if (com.tencent.mm.n.a.jh(this.ldh.field_type) || this.jiE.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) != 2) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 == null) {
                        if (adVar.Oa() || can() || cam()) {
                            multiButtonPreference.a(this.jiE.getString(R.string.a9n), new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(23213);
                                    a.this.pkh.cax();
                                    AppMethodBeat.o(23213);
                                }
                            });
                        }
                        if (cah() || ((com.tencent.mm.n.a.jh(adVar.field_type) && !adVar.Oa()) || (!cak() && cal()))) {
                            fVar.ce("contact_profile_multi_button", true);
                        }
                        if (com.tencent.mm.n.a.jh(this.ldh.field_type) || cak() || cao() || caj()) {
                            fVar.ce("contact_profile_send", true);
                            fVar.ce("contact_profile_voip", true);
                        } else {
                            fVar.ce("contact_profile_send", false);
                            fVar.ce("contact_profile_voip", this.ldh.Oa());
                        }
                        if (!com.tencent.mm.n.a.jh(this.ldh.field_type) || cak() || cao() || can() || cam()) {
                            fVar.ce("contact_profile_add_contact", true);
                        } else {
                            fVar.ce("contact_profile_add_contact", false);
                            fVar.ce("contact_profile_setting_desc", false);
                            fVar.ce("contact_profile_phone", true);
                            fVar.ce("contact_profile_info_more", true);
                        }
                        a(fVar, adVar, false);
                        if (cak() && !com.tencent.mm.n.a.jh(adVar.field_type) && (caj() || can() || cam())) {
                            fVar.ce("contact_profile_info_more", true);
                            fVar.ce("contact_profile_say_hi", false);
                        } else {
                            fVar.ce("contact_profile_say_hi", true);
                            if (com.tencent.mm.n.a.jh(adVar.field_type)) {
                                fVar.ce("contact_profile_info_more", false);
                            } else {
                                fVar.ce("contact_profile_info_more", true);
                            }
                        }
                        if (r.mG(this.ldh.field_username)) {
                            fVar.ce("contact_profile_multi_button", true);
                            fVar.ce("contact_profile_info_more", bo.isNullOrNil(adVar.signature));
                            fVar.ce("contact_profile_setting_desc", true);
                            fVar.ce("contact_profile_voip", true);
                            this.pkh.knn.mController.removeAllOptionMenu();
                        }
                        adVar3 = this.ldh;
                        fVar.ce("contact_info_invite_source", true);
                        z2 = this.eih == null ? this.jiE.getIntent().getBooleanExtra("Is_RoomOwner", false) : this.eih.JR();
                        if (this.gOW == 14 || !z2 || this.eih == null || adVar3.field_username.equals(this.eih.field_roomowner)) {
                            str = "MicroMsg.NewContactWidgetNormal";
                            c = "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s";
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(this.gOW);
                            objArr[1] = Boolean.valueOf(z2);
                            objArr[2] = Boolean.valueOf(this.eih == null);
                            ab.i(str, c, objArr);
                            fVar.ce("contact_info_invite_source", true);
                        } else {
                            this.pkj = this.jiE.getIntent().getStringExtra("inviteer");
                            if (bo.isNullOrNil(this.pkj)) {
                                this.pkj = this.eih.aop(adVar3.field_username);
                            }
                            if (bo.isNullOrNil(this.pkj)) {
                                this.pkj = com.tencent.mm.model.n.Z(adVar3.field_username, this.ejD);
                            }
                            if (bo.isNullOrNil(this.pkj)) {
                                ab.w("MicroMsg.NewContactWidgetNormal", "mRoomId:%s member:%s , inviter is null!", this.ejD, adVar3.field_username);
                                this.pkk.dnU();
                                com.tencent.mm.model.ao.a.flu.a(adVar3.field_username, this.ejD, new com.tencent.mm.model.ao.b.a() {
                                    public final void o(String str, boolean z) {
                                        AppMethodBeat.i(23206);
                                        ab.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", str, a.this.ejD, Boolean.valueOf(z));
                                        a.this.pkk.dead();
                                        AppMethodBeat.o(23206);
                                    }
                                });
                            } else {
                                this.jiE.getIntent().putExtra("inviteer", this.pkj);
                                String b = b(this.eih, this.pkj);
                                if (bo.isNullOrNil(b)) {
                                    final f fVar2 = fVar;
                                    com.tencent.mm.model.ao.a.flu.a(adVar3.field_username, "", new com.tencent.mm.model.ao.b.a() {
                                        public final void o(String str, boolean z) {
                                            AppMethodBeat.i(23207);
                                            ab.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", str, a.this.ejD, Boolean.valueOf(z));
                                            if (z) {
                                                aw.ZK();
                                                a.a(fVar2, a.this.jiE, a.this.pkj, com.tencent.mm.model.c.XM().aoO(str).Oi());
                                            }
                                            AppMethodBeat.o(23207);
                                        }
                                    });
                                } else {
                                    a(fVar, this.jiE, this.pkj, b);
                                }
                            }
                        }
                        this.iFE.ce("contact_profile_story", true);
                        aw.ZK();
                        aoJ = com.tencent.mm.model.c.XM().aoJ(adVar.field_username);
                        aoJ2 = r.Yz().equals(adVar.field_username);
                        if (((e) g.M(e.class)).getStoryBasicConfig().cwU()) {
                            ab.i("MicroMsg.NewContactWidgetNormal", "updateStoryVisible isFriend:%s isSelf:%s ", Boolean.valueOf(aoJ), Boolean.valueOf(aoJ2));
                            if ((!ad.aov(adVar.field_username) && aoJ) || aoJ2) {
                                AbsStoryPreference absStoryPreference = (AbsStoryPreference) this.iFE.aqO("contact_profile_story");
                                absStoryPreference.onCreate(adVar.field_username);
                                absStoryPreference.a(this);
                                absStoryPreference.cwP();
                                absStoryPreference.cwO();
                            }
                        }
                        AppMethodBeat.o(23221);
                        return true;
                    }
                }
                if (this.ldh.Oa()) {
                    str = this.jiE.getString(R.string.ay1);
                } else {
                    str = this.jiE.getString(R.string.ay6);
                }
                multiButtonPreference.a(str, new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(23203);
                        a.this.pkh.jL(true);
                        AppMethodBeat.o(23203);
                    }
                });
                str = this.jiE.getString(R.string.a9n);
                anonymousClass7 = new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(23212);
                        a.this.pkh.cax();
                        AppMethodBeat.o(23212);
                    }
                };
                multiButtonPreference.pnK = str;
                multiButtonPreference.pnN = anonymousClass7;
                fVar.ce("contact_profile_multi_button", true);
                if (com.tencent.mm.n.a.jh(this.ldh.field_type)) {
                }
                fVar.ce("contact_profile_send", true);
                fVar.ce("contact_profile_voip", true);
                if (com.tencent.mm.n.a.jh(this.ldh.field_type)) {
                }
                fVar.ce("contact_profile_add_contact", true);
                a(fVar, adVar, false);
                if (cak()) {
                }
                fVar.ce("contact_profile_say_hi", true);
                if (com.tencent.mm.n.a.jh(adVar.field_type)) {
                }
                if (r.mG(this.ldh.field_username)) {
                }
                adVar3 = this.ldh;
                fVar.ce("contact_info_invite_source", true);
                if (this.eih == null) {
                }
                if (this.gOW == 14) {
                }
                str = "MicroMsg.NewContactWidgetNormal";
                c = "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(this.gOW);
                objArr[1] = Boolean.valueOf(z2);
                if (this.eih == null) {
                }
                objArr[2] = Boolean.valueOf(this.eih == null);
                ab.i(str, c, objArr);
                fVar.ce("contact_info_invite_source", true);
                this.iFE.ce("contact_profile_story", true);
                aw.ZK();
                aoJ = com.tencent.mm.model.c.XM().aoJ(adVar.field_username);
                aoJ2 = r.Yz().equals(adVar.field_username);
                if (((e) g.M(e.class)).getStoryBasicConfig().cwU()) {
                }
                AppMethodBeat.o(23221);
                return true;
            }
        }
        fVar.ce("contact_profile_setting_desc", true);
        if (com.tencent.mm.n.a.jh(adVar.field_type)) {
        }
        fVar.ce("contact_profile_set_des_category", true);
        if (!ad.aox(this.ldh.field_username)) {
        }
        if (ad.aox(this.ldh.field_username)) {
        }
        fVar.aqO("contact_profile_info_more").setTitle(this.jiE.getText(R.string.ay0).toString());
        ((TextPreference) fVar.aqO("contact_profile_hint")).ae(this.jiE.getText(R.string.ay5));
        if (adVar.Oa()) {
        }
        multiButtonPreference = (MultiButtonPreference) fVar.aqO("contact_profile_multi_button");
        if (cak()) {
        }
        if (this.ldh.Oa()) {
        }
        multiButtonPreference.a(str, /* anonymous class already generated */);
        str = this.jiE.getString(R.string.a9n);
        anonymousClass7 = /* anonymous class already generated */;
        multiButtonPreference.pnK = str;
        multiButtonPreference.pnN = anonymousClass7;
        fVar.ce("contact_profile_multi_button", true);
        if (com.tencent.mm.n.a.jh(this.ldh.field_type)) {
        }
        fVar.ce("contact_profile_send", true);
        fVar.ce("contact_profile_voip", true);
        if (com.tencent.mm.n.a.jh(this.ldh.field_type)) {
        }
        fVar.ce("contact_profile_add_contact", true);
        a(fVar, adVar, false);
        if (cak()) {
        }
        fVar.ce("contact_profile_say_hi", true);
        if (com.tencent.mm.n.a.jh(adVar.field_type)) {
        }
        if (r.mG(this.ldh.field_username)) {
        }
        adVar3 = this.ldh;
        fVar.ce("contact_info_invite_source", true);
        if (this.eih == null) {
        }
        if (this.gOW == 14) {
        }
        str = "MicroMsg.NewContactWidgetNormal";
        c = "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s";
        objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.gOW);
        objArr[1] = Boolean.valueOf(z2);
        if (this.eih == null) {
        }
        objArr[2] = Boolean.valueOf(this.eih == null);
        ab.i(str, c, objArr);
        fVar.ce("contact_info_invite_source", true);
        this.iFE.ce("contact_profile_story", true);
        aw.ZK();
        aoJ = com.tencent.mm.model.c.XM().aoJ(adVar.field_username);
        aoJ2 = r.Yz().equals(adVar.field_username);
        if (((e) g.M(e.class)).getStoryBasicConfig().cwU()) {
        }
        AppMethodBeat.o(23221);
        return true;
    }

    private void a(f fVar, ad adVar, boolean z) {
        AppMethodBeat.i(23222);
        if (cak()) {
            fVar.ce("contact_profile_setting_desc", true);
            fVar.ce("contact_profile_phone", true);
            fVar.ce("contact_profile_info_more", true);
            fVar.ce("contact_profile_sns", ad.aox(adVar.field_username));
            boolean z2 = (r.YE() & 268435456) != 0;
            boolean u = p.u(this.jiE, "com.tencent.wework");
            aw.ZK();
            Integer num = (Integer) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_ADD_CONTACT_BY_WEWORK_SWITCH_INT, Integer.valueOf(0));
            ab.i("MicroMsg.NewContactWidgetNormal", "ExtStatus:%s openAddByWework:%s isInstallWework:%s", Long.valueOf(r.YE()), Boolean.valueOf(z2), Boolean.valueOf(u));
            if (bo.gW(num.intValue(), 1) || (z2 && p.u(this.jiE, "com.tencent.wework") && !ad.aox(this.ldh.field_username))) {
                String str;
                fVar.ce("contact_profile_accept_contact_by_wework", false);
                com.tencent.mm.pluginsdk.ui.preference.b[] a = com.tencent.mm.plugin.profile.ui.p.a(this.jiE, adVar, this.gOW);
                String str2 = "";
                if (a == null || a.length <= 0) {
                    str = str2;
                } else {
                    str = com.tencent.mm.plugin.profile.ui.p.b(this.jiE, adVar, this.gOW);
                }
                if (com.tencent.mm.plugin.profile.b.e.UM(this.ldh.field_username)) {
                    ((ButtonPreference) fVar.aqO("contact_profile_accept_contact_by_wework")).ed(this.jiE.getString(R.string.awr), this.jiE.getResources().getColor(R.color.hi));
                }
                if (!bo.isNullOrNil(str) && com.tencent.mm.plugin.profile.b.e.UL(str) == 2 && z) {
                    fVar.ce("contact_profile_accept_contact", true);
                }
                AppMethodBeat.o(23222);
                return;
            }
            fVar.ce("contact_profile_accept_contact_by_wework", true);
            AppMethodBeat.o(23222);
            return;
        }
        fVar.ce("contact_profile_accept_contact", true);
        fVar.ce("contact_profile_accept_contact_by_wework", true);
        AppMethodBeat.o(23222);
    }

    public final boolean biV() {
        AppMethodBeat.i(23223);
        this.iFE.aqO("contact_profile_sns");
        if (n.qFC != null) {
            n.qFC.a(this, 3);
        }
        NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) this.iFE.aqO("contact_profile_header_normal");
        if (normalProfileHeaderPreference != null) {
            normalProfileHeaderPreference.onDetach();
        }
        AbsStoryPreference absStoryPreference = (AbsStoryPreference) this.iFE.aqO("contact_profile_story");
        if (absStoryPreference != null) {
            absStoryPreference.onDestroy();
        }
        this.pkk.dead();
        AppMethodBeat.o(23223);
        return false;
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(23224);
        Intent intent;
        ad adVar;
        String str2;
        Intent intent2;
        String stringExtra;
        ad adVar2;
        if (str.equals("contact_profile_sns")) {
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                Intent intent3 = this.jiE.getIntent();
                intent3.putExtra("sns_source", this.jiE.getIntent().getIntExtra("Sns_from_Scene", 0));
                intent3.putExtra("sns_signature", this.ldh.signature);
                intent3.putExtra("sns_nickName", this.ldh.Oi());
                intent3.putExtra("sns_title", this.ldh.Oj());
                if (n.qFC != null) {
                    intent3 = n.qFC.e(intent3, this.ldh.field_username);
                }
                if (intent3 == null) {
                    this.jiE.finish();
                } else {
                    com.tencent.mm.bp.d.b(this.jiE, "sns", ".ui.SnsUserUI", intent3);
                    if ((intent3.getFlags() & 67108864) != 0) {
                        this.jiE.finish();
                    }
                }
            } else {
                t.hO(this.jiE);
            }
        } else if (str.equals("contact_profile_label") || str.equals("contact_profile_desc") || str.equals("contact_profile_phone") || str.equals("contact_profile_setting_desc")) {
            ad adVar3 = this.ldh;
            if (adVar3 == null) {
                ab.e("MicroMsg.NewContactWidgetNormal", "contact is null");
            } else if (com.tencent.mm.n.a.jh(adVar3.field_type)) {
                PhoneNumPreference phoneNumPreference = (PhoneNumPreference) this.iFE.aqO("contact_profile_phone");
                intent = new Intent();
                intent.putExtra("Contact_Scene", this.gOW);
                intent.putExtra("Contact_User", adVar3.field_username);
                intent.putExtra("Contact_RoomNickname", this.jiE.getIntent().getStringExtra("Contact_RoomNickname"));
                intent.putExtra("view_mode", true);
                intent.putExtra("contact_phone_number_by_md5", phoneNumPreference.vim);
                intent.putExtra("contact_phone_number_list", adVar3.dur);
                b.gkE.m(intent, this.jiE);
            } else if (bo.isNullOrNil(adVar3.field_encryptUsername)) {
                a(adVar3.field_username, adVar3);
            } else {
                a(adVar3.field_encryptUsername, adVar3);
            }
        } else if (str.equals("contact_profile_power")) {
            if (this.pkh != null) {
                this.pkh.cas();
            }
        } else if (str.equals("contact_profile_send")) {
            adVar = this.ldh;
            if (bo.a(Boolean.valueOf(com.tencent.mm.model.t.mW(adVar.field_username)), false)) {
                str2 = adVar.field_username;
                intent2 = new Intent();
                intent2.addFlags(67108864);
                if (this.readOnly) {
                    intent2.putExtra("Chat_User", str2);
                    intent2.putExtra("Chat_Mode", 1);
                    this.jiE.setResult(-1, intent2);
                } else {
                    intent2.putExtra("Chat_User", str2);
                    intent2.putExtra("Chat_Mode", 1);
                    intent2.setClassName(this.jiE, "com.tencent.mm.ui.chatting.ChattingUI");
                    this.jiE.startActivity(intent2);
                }
            } else {
                intent2 = new Intent();
                intent2.addFlags(67108864);
                if (this.readOnly) {
                    intent2.putExtra("Chat_User", adVar.field_username);
                    intent2.putExtra("Chat_Mode", 1);
                    this.jiE.setResult(-1, intent2);
                } else {
                    intent2.putExtra("Chat_User", adVar.field_username);
                    intent2.putExtra("Chat_Mode", 1);
                    intent2.setClassName(this.jiE, "com.tencent.mm.ui.chatting.ChattingUI");
                    this.jiE.startActivity(intent2);
                }
            }
        } else if (str.equals("contact_profile_voip")) {
            final ad adVar4 = this.ldh;
            uh uhVar = new uh();
            com.tencent.mm.sdk.b.a.xxA.m(uhVar);
            if (!adVar4.field_username.equals(uhVar.cQt.talker) && (uhVar.cQt.cQv || uhVar.cQt.cQw)) {
                Toast.makeText(this.jiE, uhVar.cQt.cQu ? R.string.ac6 : R.string.ac7, 0).show();
                ab.i("MicroMsg.NewContactWidgetNormal", "voip is running, can't do this");
            } else if (!com.tencent.mm.r.a.bH(this.jiE)) {
                sz szVar = new sz();
                szVar.cPf.cPh = true;
                com.tencent.mm.sdk.b.a.xxA.m(szVar);
                str2 = szVar.cPg.cPj;
                if (bo.isNullOrNil(str2)) {
                    a(adVar4, this.jiE);
                } else {
                    ab.v("MicroMsg.NewContactWidgetNormal", "Talkroom is on: ".concat(String.valueOf(str2)));
                    h.d(this.jiE, this.jiE.getString(R.string.euf), "", this.jiE.getString(R.string.s6), this.jiE.getString(R.string.or), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(23204);
                            sz szVar = new sz();
                            szVar.cPf.cPi = true;
                            com.tencent.mm.sdk.b.a.xxA.m(szVar);
                            a.this.a(adVar4, a.this.jiE);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(23204);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(23205);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(23205);
                        }
                    });
                }
            }
        } else if (str.equals("contact_profile_add_contact")) {
            final MMActivity mMActivity = this.jiE;
            ad adVar5 = this.ldh;
            final int i = this.gOW;
            if (((int) adVar5.ewQ) == 0) {
                aw.ZK();
                if (com.tencent.mm.model.c.XM().aa(adVar5) != -1) {
                    aw.ZK();
                    adVar5 = com.tencent.mm.model.c.XM().aoO(adVar5.field_username);
                }
            }
            str2 = this.jiE.getIntent().getStringExtra("Contact_Mobile_MD5");
            stringExtra = this.jiE.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            String nullAsNil = bo.nullAsNil(str2);
            stringExtra = bo.nullAsNil(stringExtra);
            if (!(nullAsNil.equals("") && stringExtra.equals(""))) {
                com.tencent.mm.plugin.account.friend.a.a vW = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(nullAsNil);
                if (vW == null) {
                    vW = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(stringExtra);
                } else {
                    stringExtra = nullAsNil;
                }
                if (vW != null) {
                    com.tencent.mm.plugin.account.a.getAddrUploadStg().a(stringExtra, vW);
                }
            }
            com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.jiE, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
                public final void a(boolean z, boolean z2, String str, String str2) {
                    AppMethodBeat.i(23217);
                    if (z) {
                        a aVar = a.this;
                        ad adVar = adVar5;
                        int i = i;
                        if (((int) adVar.ewQ) == 0) {
                            aw.ZK();
                            com.tencent.mm.model.c.XM().aa(adVar);
                            aw.ZK();
                            com.tencent.mm.model.c.XM().aoO(adVar.field_username);
                        }
                        if (((int) adVar.ewQ) <= 0) {
                            ab.e("MicroMsg.NewContactWidgetNormal", "addContact : insert contact failed");
                            AppMethodBeat.o(23217);
                            return;
                        }
                        if (!com.tencent.mm.n.a.jh(adVar.field_type) && i == 15) {
                            com.tencent.mm.plugin.account.friend.a.a vT = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(adVar.field_username);
                            if (!(vT == null || bo.isNullOrNil(adVar.dur))) {
                                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                                Object[] objArr = new Object[4];
                                objArr[0] = adVar.field_username;
                                objArr[1] = Integer.valueOf(3);
                                if (bo.isNullOrNil(vT.Aq())) {
                                    i = 0;
                                } else {
                                    i = 1;
                                }
                                objArr[2] = Integer.valueOf(i);
                                if (adVar.dur.toString().split(",").length >= 5) {
                                    i = 5;
                                } else {
                                    i = adVar.dur.toString().split(",").length;
                                }
                                objArr[3] = Integer.valueOf(i);
                                hVar.e(12040, objArr);
                            }
                        }
                        com.tencent.mm.model.t.q(adVar);
                        aVar.iFE.notifyDataSetChanged();
                        AppMethodBeat.o(23217);
                    } else if (z2) {
                        com.tencent.mm.bi.d.akP().ep(str, 2);
                        AppMethodBeat.o(23217);
                    } else {
                        ab.e("MicroMsg.NewContactWidgetNormal", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(str)));
                        AppMethodBeat.o(23217);
                    }
                }
            });
            LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(i));
            nullAsNil = mMActivity.getIntent().getStringExtra("source_from_user_name");
            final String stringExtra2 = mMActivity.getIntent().getStringExtra("source_from_nick_name");
            aVar.hH(nullAsNil, stringExtra2);
            aVar.vjI = new com.tencent.mm.pluginsdk.ui.applet.a.b() {
                public final boolean vQ(String str) {
                    AppMethodBeat.i(23218);
                    String stringExtra = mMActivity.getIntent().getStringExtra("room_name");
                    Intent intent = new Intent(mMActivity, SayHiWithSnsPermissionUI.class);
                    intent.putExtra("Contact_User", adVar5.field_username);
                    intent.putExtra("Contact_Nick", adVar5.field_nickname);
                    intent.putExtra("Contact_RemarkName", adVar5.field_conRemark);
                    if (i == 14 || i == 8) {
                        intent.putExtra("Contact_RoomNickname", mMActivity.getIntent().getStringExtra("Contact_RoomNickname"));
                    }
                    intent.putExtra("Contact_Scene", i);
                    intent.putExtra("room_name", stringExtra);
                    intent.putExtra("source_from_user_name", nullAsNil);
                    intent.putExtra("source_from_nick_name", stringExtra2);
                    intent.putExtra("sayhi_with_sns_perm_send_verify", true);
                    intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                    intent.putExtra("sayhi_with_sns_perm_set_label", false);
                    intent.putExtra(com.tencent.mm.ui.e.b.yfT, str);
                    mMActivity.startActivity(intent);
                    AppMethodBeat.o(23218);
                    return true;
                }
            };
            nullAsNil = mMActivity.getIntent().getStringExtra("room_name");
            str2 = mMActivity.getIntent().getStringExtra(com.tencent.mm.ui.e.b.yfT);
            if (!TextUtils.isEmpty(str2)) {
                aVar.ajw(str2);
                aVar.c(adVar5.field_username, "", linkedList);
            } else if (TextUtils.isEmpty(nullAsNil)) {
                aVar.ajw(adVar5.dus);
                aVar.e(adVar5.field_username, linkedList);
            } else if (TextUtils.isEmpty(aVar.mGZ)) {
                aw.ZK();
                adVar = com.tencent.mm.model.c.XM().aoO(adVar5.field_username);
                CharSequence bc = adVar != null ? bo.bc(adVar.dus, "") : "";
                ab.i("MicroMsg.NewContactWidgetNormal", "dkverify footer add:%s chat:%s ticket:%s", adVar5.field_username, nullAsNil, bc);
                if (TextUtils.isEmpty(bc)) {
                    final com.tencent.mm.pluginsdk.ui.applet.a aVar2 = aVar;
                    final LinkedList linkedList2 = linkedList;
                    com.tencent.mm.model.ao.a.flu.a(adVar5.field_username, nullAsNil, new com.tencent.mm.model.ao.b.a() {
                        public final void o(String str, boolean z) {
                            AppMethodBeat.i(23219);
                            aw.ZK();
                            ad aoO = com.tencent.mm.model.c.XM().aoO(adVar5.field_username);
                            aVar2.ajw(aoO != null ? bo.bc(aoO.dus, "") : "");
                            aVar2.c(adVar5.field_username, nullAsNil, linkedList2);
                            AppMethodBeat.o(23219);
                        }
                    });
                } else {
                    aVar.ajw(bc);
                    aVar.c(adVar5.field_username, nullAsNil, linkedList);
                }
            } else {
                aVar.c(adVar5.field_username, nullAsNil, linkedList);
            }
        } else if (str.equals("contact_profile_accept_contact")) {
            MMActivity mMActivity2 = this.jiE;
            adVar2 = this.ldh;
            mMActivity2.getIntent().removeExtra("Accept_NewFriend_FromOutside");
            Intent intent4 = new Intent(mMActivity2, SayHiWithSnsPermissionUI.class);
            intent4.putExtra("Contact_User", adVar2.field_username);
            intent4.putExtra("Contact_Nick", adVar2.field_nickname);
            intent4.putExtra("Contact_RemarkName", adVar2.field_conRemark);
            if (this.gOW == 14 || this.gOW == 8) {
                intent4.putExtra("Contact_RoomNickname", mMActivity2.getIntent().getStringExtra("Contact_RoomNickname"));
            }
            intent4.putExtra("Contact_Scene", this.gOW);
            intent4.putExtra("Verify_ticket", bo.nullAsNil(mMActivity2.getIntent().getStringExtra("Verify_ticket")));
            intent4.putExtra("sayhi_with_sns_perm_send_verify", false);
            intent4.putExtra("sayhi_with_sns_perm_add_remark", true);
            intent4.putExtra("sayhi_with_sns_perm_set_label", true);
            intent4.putExtra("sayhi_with_sns_permission", adVar2.Od());
            mMActivity2.startActivity(intent4);
        } else if (str.equals("contact_profile_say_hi")) {
            adVar = this.ldh;
            intent2 = new Intent();
            intent2.putExtra("Contact_User", adVar.field_username);
            intent2.putExtra("Contact_Scene", this.gOW);
            intent2.putExtra(com.tencent.mm.ui.e.b.yfT, adVar.dus);
            b.gkE.a(intent2, this.jiE);
        } else if (str.equals("contact_profile_info_more")) {
            if (this.pkh != null) {
                b.a(this.jiE, this.ldh);
            }
        } else if (str.equals("contact_info_invite_source")) {
            str2 = ((KeyValuePreference) this.iFE.aqO("contact_info_invite_source")).getExtras().getString("inviter");
            if (!bo.isNullOrNil(str2)) {
                stringExtra = b(this.eih, str2);
                intent = new Intent();
                intent.putExtra("Contact_User", str2);
                intent.putExtra("Contact_RemarkName", stringExtra);
                intent.putExtra("Contact_RoomNickname", stringExtra);
                intent.putExtra("Contact_RoomMember", true);
                intent.putExtra("room_name", this.ejD);
                aw.ZK();
                intent.putExtra("Contact_Nick", com.tencent.mm.model.c.XM().aoO(str2).field_nickname);
                intent.putExtra("Contact_Scene", 14);
                intent.putExtra("Is_RoomOwner", true);
                intent.putExtra("Contact_ChatRoomId", this.ejD);
                b.gkE.c(intent, this.jiE);
            }
        } else if (str.equals("contact_profile_accept_contact_by_wework")) {
            adVar2 = this.ldh;
            String nullAsNil2 = bo.nullAsNil(this.jiE.getIntent().getStringExtra("Verify_ticket"));
            com.tencent.mm.pluginsdk.ui.preference.b[] a = com.tencent.mm.plugin.profile.ui.p.a(this.jiE, adVar2, this.gOW);
            stringExtra = "";
            str2 = "";
            if (a.length > 0) {
                stringExtra = a[a.length - 1].fjz;
                str2 = com.tencent.mm.plugin.profile.ui.p.b(this.jiE, adVar2, this.gOW);
            }
            new com.tencent.mm.plugin.profile.b.a(adVar2.field_username, nullAsNil2, str2, stringExtra).a(g.RO().eJo.ftA, new com.tencent.mm.ai.f() {
                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(23214);
                    mVar.ftk = true;
                    com.tencent.mm.plugin.profile.b.a aVar = (com.tencent.mm.plugin.profile.b.a) mVar;
                    if (i == 0 && i2 == 0) {
                        if (aVar.pkG == null) {
                            aVar.pkG = (alp) aVar.ehh.fsH.fsP;
                        }
                        Uri uri = null;
                        try {
                            uri = Uri.parse(aVar.pkG.wqR);
                        } catch (Exception e) {
                            ab.i("MicroMsg.NewContactWidgetNormal", "goToWework() Exception:%s", e.getMessage());
                        }
                        a.this.jiE.startActivityForResult(new Intent("android.intent.action.VIEW", uri), 111);
                        ab.i("MicroMsg.NewContactWidgetNormal", "goToWework() success! openurl:%s", r1);
                        AppMethodBeat.o(23214);
                        return;
                    }
                    String str2;
                    ab.i("MicroMsg.NewContactWidgetNormal", "goToWework() fail!");
                    if (aVar.pkG == null) {
                        aVar.pkG = (alp) aVar.ehh.fsH.fsP;
                    }
                    if (aVar.pkG.BaseResponse == null || aVar.pkG.BaseResponse.ErrMsg == null) {
                        str2 = aVar.aIm;
                    } else {
                        str2 = bo.nullAsNil(aVar.pkG.BaseResponse.ErrMsg.wVI);
                    }
                    if (bo.isNullOrNil(str2)) {
                        str2 = a.this.jiE.getString(R.string.day);
                    }
                    h.b(a.this.jiE, str2, a.this.jiE.getString(R.string.ewj), false);
                    AppMethodBeat.o(23214);
                }
            });
        } else if (str.equals("contact_profile_story")) {
            AbsStoryPreference absStoryPreference = (AbsStoryPreference) this.iFE.aqO("contact_profile_story");
            if (absStoryPreference != null) {
                absStoryPreference.cwQ();
            }
        }
        AppMethodBeat.o(23224);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(23225);
        a(this.iFE, this.ldh, true);
        AppMethodBeat.o(23225);
    }

    private boolean cah() {
        AppMethodBeat.i(23226);
        for (String equalsIgnoreCase : com.tencent.mm.model.t.fkY) {
            if (equalsIgnoreCase.equalsIgnoreCase(this.ldh.field_username)) {
                AppMethodBeat.o(23226);
                return true;
            }
        }
        boolean cai = cai();
        AppMethodBeat.o(23226);
        return cai;
    }

    private boolean cai() {
        AppMethodBeat.i(23227);
        boolean nB = com.tencent.mm.model.t.nB(this.ldh.field_username);
        AppMethodBeat.o(23227);
        return nB;
    }

    private boolean caj() {
        AppMethodBeat.i(23228);
        boolean mR = ad.mR(this.ldh.field_username);
        AppMethodBeat.o(23228);
        return mR;
    }

    private boolean cak() {
        AppMethodBeat.i(23229);
        if (com.tencent.mm.n.a.jh(this.ldh.field_type) || !this.jiE.getIntent().getBooleanExtra("User_Verify", false)) {
            AppMethodBeat.o(23229);
            return false;
        }
        AppMethodBeat.o(23229);
        return true;
    }

    private boolean cal() {
        AppMethodBeat.i(23230);
        if (this.jiE.getIntent().getIntExtra("Contact_Scene", -1) == 14) {
            AppMethodBeat.o(23230);
            return true;
        }
        AppMethodBeat.o(23230);
        return false;
    }

    private boolean cam() {
        AppMethodBeat.i(23231);
        if (this.jiE.getIntent().getIntExtra("Contact_Scene", 0) == 18) {
            AppMethodBeat.o(23231);
            return true;
        }
        AppMethodBeat.o(23231);
        return false;
    }

    private boolean can() {
        AppMethodBeat.i(23232);
        int intExtra = this.jiE.getIntent().getIntExtra("Contact_Scene", 0);
        if (26 > intExtra || intExtra > 29) {
            AppMethodBeat.o(23232);
            return false;
        }
        AppMethodBeat.o(23232);
        return true;
    }

    private boolean cao() {
        return this.ldh.field_deleteFlag == 1;
    }

    private void a(String str, ad adVar) {
        AppMethodBeat.i(23233);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.NewContactWidgetNormal", "view stranger remark, username is null");
            AppMethodBeat.o(23233);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Scene", this.gOW);
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", adVar.field_username);
        intent.putExtra("Contact_Nick", adVar.field_nickname);
        intent.putExtra("Contact_RemarkName", adVar.field_conRemark);
        b.gkE.n(intent, this.jiE);
        AppMethodBeat.o(23233);
    }

    /* Access modifiers changed, original: final */
    public final void a(final ad adVar, final Context context) {
        AppMethodBeat.i(23234);
        this.pki = new com.tencent.mm.ui.widget.a.d(this.jiE, 1, false);
        this.pki.rBl = new com.tencent.mm.ui.base.n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(23215);
                lVar.ax(2, R.string.qh, R.raw.sharemore_videovoip);
                lVar.ax(1, R.string.qj, R.raw.sharemore_voipvoice);
                AppMethodBeat.o(23215);
            }
        };
        this.pki.rBm = new com.tencent.mm.ui.base.n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(23216);
                ad adVar;
                Context context;
                ui uiVar;
                switch (menuItem.getItemId()) {
                    case 1:
                        adVar = adVar;
                        context = context;
                        ab.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a((Activity) context, "android.permission.RECORD_AUDIO", 82, "", "")), bo.dpG(), context);
                        if (com.tencent.mm.pluginsdk.permission.b.a((Activity) context, "android.permission.RECORD_AUDIO", 82, "", "")) {
                            uiVar = new ui();
                            uiVar.cQx.cAd = 5;
                            uiVar.cQx.talker = adVar.field_username;
                            uiVar.cQx.context = context;
                            uiVar.cQx.cQs = 4;
                            com.tencent.mm.sdk.b.a.xxA.m(uiVar);
                        }
                        AppMethodBeat.o(23216);
                        return;
                    case 2:
                        adVar = adVar;
                        context = context;
                        ab.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a((Activity) context, "android.permission.CAMERA", 19, "", "")), bo.dpG(), context);
                        if (com.tencent.mm.pluginsdk.permission.b.a((Activity) context, "android.permission.CAMERA", 19, "", "")) {
                            ab.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a((Activity) context, "android.permission.RECORD_AUDIO", 19, "", "")), bo.dpG(), context);
                            if (com.tencent.mm.pluginsdk.permission.b.a((Activity) context, "android.permission.RECORD_AUDIO", 19, "", "")) {
                                uiVar = new ui();
                                uiVar.cQx.cAd = 5;
                                uiVar.cQx.talker = adVar.field_username;
                                uiVar.cQx.context = context;
                                uiVar.cQx.cQs = 2;
                                com.tencent.mm.sdk.b.a.xxA.m(uiVar);
                                break;
                            }
                        }
                        break;
                }
                AppMethodBeat.o(23216);
            }
        };
        this.pki.cpD();
        AppMethodBeat.o(23234);
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j, String str2) {
        AppMethodBeat.i(23235);
        com.tencent.mm.ui.base.preference.g gVar = (com.tencent.mm.ui.base.preference.g) this.iFE.aqO("contact_profile_sns");
        if (!(gVar == null || n.qFy == null)) {
            gVar.ajO(this.ldh.field_username);
            if (n.qFC != null) {
                n.qFC.a(this, 3);
            }
            this.iFE.notifyDataSetChanged();
            if (z3) {
                ab.d("MicroMsg.NewContactWidgetNormal", "bg Change!");
                if (n.qFC != null) {
                    n.qFC.WZ(this.ldh.field_username);
                }
            }
        }
        AppMethodBeat.o(23235);
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j, String str2) {
    }

    public final void cA(List list) {
        AppMethodBeat.i(23236);
        if (list == null || list.isEmpty()) {
            ab.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish hideStoryPreference");
            this.iFE.ce("contact_profile_story", true);
            AppMethodBeat.o(23236);
            return;
        }
        ab.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish showStoryPreference");
        this.iFE.ce("contact_profile_story", false);
        AppMethodBeat.o(23236);
    }

    static void a(f fVar, Activity activity, String str, String str2) {
        AppMethodBeat.i(23237);
        ab.i("MicroMsg.NewContactWidgetNormal", "[showInviterView] inviter:%s inviterDisplayName:%s", str, str2);
        KeyValuePreference keyValuePreference = (KeyValuePreference) fVar.aqO("contact_info_invite_source");
        fVar.ce("contact_info_invite_source", false);
        SpannableString spannableString = new SpannableString(j.b((Context) activity, activity.getResources().getString(R.string.awu, new Object[]{str2})));
        spannableString.setSpan(new ForegroundColorSpan(activity.getResources().getColor(R.color.hi)), 0, str2.length(), 33);
        keyValuePreference.NT(2);
        keyValuePreference.yCj = false;
        keyValuePreference.setSummary((CharSequence) spannableString);
        keyValuePreference.getExtras().putString("inviter", str);
        activity.getIntent().putExtra("inviteer", str);
        AppMethodBeat.o(23237);
    }

    static String b(u uVar, String str) {
        String str2 = null;
        AppMethodBeat.i(23238);
        if (uVar == null) {
            AppMethodBeat.o(23238);
        } else {
            aw.ZK();
            ad aoO = com.tencent.mm.model.c.XM().aoO(str);
            if (aoO != null && ((int) aoO.ewQ) > 0) {
                str2 = aoO.field_conRemark;
            }
            if (bo.isNullOrNil(str2)) {
                str2 = uVar.mJ(str);
            }
            if (bo.isNullOrNil(str2) && aoO != null) {
                str2 = aoO.Oi();
            }
            AppMethodBeat.o(23238);
        }
        return str2;
    }
}
