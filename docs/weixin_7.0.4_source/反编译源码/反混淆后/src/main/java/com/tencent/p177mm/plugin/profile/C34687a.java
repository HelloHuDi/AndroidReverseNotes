package com.tencent.p177mm.plugin.profile;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
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
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18411uh;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p230g.p231a.C41966at;
import com.tencent.p177mm.p230g.p231a.C42062sz;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5510e.C5495b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.C46634g;
import com.tencent.p177mm.p612ui.base.preference.KeyValuePreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceSmallCategory;
import com.tencent.p177mm.p612ui.base.preference.PreferenceTitleCategory;
import com.tencent.p177mm.p612ui.base.preference.TextPreference;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.profile.p1286a.C43380a.C248031;
import com.tencent.p177mm.plugin.profile.p1286a.C43380a.C250272;
import com.tencent.p177mm.plugin.profile.p1286a.C43380a.C286803;
import com.tencent.p177mm.plugin.profile.p1286a.C43380a.C394994;
import com.tencent.p177mm.plugin.profile.p1286a.C43380a.C395006;
import com.tencent.p177mm.plugin.profile.p1286a.C43380a.C433815;
import com.tencent.p177mm.plugin.profile.p1286a.C43380a.C433827;
import com.tencent.p177mm.plugin.profile.p1286a.C43387b;
import com.tencent.p177mm.plugin.profile.p1287b.C21453e;
import com.tencent.p177mm.plugin.profile.p1287b.C39501a;
import com.tencent.p177mm.plugin.profile.p483ui.C28705p;
import com.tencent.p177mm.plugin.profile.p483ui.MultiButtonPreference;
import com.tencent.p177mm.plugin.profile.p483ui.NormalProfileHeaderPreference;
import com.tencent.p177mm.plugin.profile.p483ui.SayHiWithSnsPermissionUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.plugin.sns.p1024b.C39728h.C39729a;
import com.tencent.p177mm.plugin.story.api.AbsStoryPreference;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.api.C4109d;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14917a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14918b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.preference.ButtonPreference;
import com.tencent.p177mm.pluginsdk.p597ui.preference.C14957b;
import com.tencent.p177mm.pluginsdk.p597ui.preference.LabelPreference;
import com.tencent.p177mm.pluginsdk.p597ui.preference.PhoneNumPreference;
import com.tencent.p177mm.pluginsdk.p597ui.preference.ProfileDescribePreference;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.alp;
import com.tencent.p177mm.protocal.protobuf.ccl;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.profile.a */
public final class C34687a implements C39729a, C4109d, C23233a {
    C7577u eih;
    String ejD;
    private int gOW;
    C15541f iFE;
    MMActivity jiE;
    C7616ad ldh;
    C43387b pkh;
    private C36356d pki;
    String pkj = null;
    C4884c<C41966at> pkk = new C70186();
    private boolean readOnly = false;

    /* renamed from: com.tencent.mm.plugin.profile.a$7 */
    class C36117 implements OnClickListener {
        C36117() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23212);
            C34687a.this.pkh.cax();
            AppMethodBeat.m2505o(23212);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a$8 */
    class C36128 implements OnClickListener {
        C36128() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23213);
            C34687a.this.pkh.cax();
            AppMethodBeat.m2505o(23213);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a$6 */
    class C70186 extends C4884c<C41966at> {
        C70186() {
            AppMethodBeat.m2504i(23210);
            this.xxI = C41966at.class.getName().hashCode();
            AppMethodBeat.m2505o(23210);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(23211);
            final C41966at c41966at = (C41966at) c4883b;
            C4990ab.m7417i("MicroMsg.NewContactWidgetNormal", "[ChatroomMemberInviterUpdatedEvent callback] username:%s inviter:%s", c41966at.ctP.username, c41966at.ctP.ctQ);
            if (!(C5046bo.isNullOrNil(c41966at.ctP.username) || !c41966at.ctP.username.equals(C34687a.this.ldh.field_username) || C5046bo.isNullOrNil(c41966at.ctP.ctQ))) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(23209);
                        final String str = c41966at.ctP.ctQ;
                        C34687a.this.jiE.getIntent().putExtra("inviteer", str);
                        String b = C34687a.m56953b(C34687a.this.eih, c41966at.ctP.ctQ);
                        C4990ab.m7417i("MicroMsg.NewContactWidgetNormal", "[ChatroomMemberInviterUpdatedEvent callback] inviter:%s inviterDisplayName:%s", str, b);
                        if (C5046bo.isNullOrNil(b)) {
                            C26417a.flu.mo20966a(str, "", new C9636a() {
                                /* renamed from: o */
                                public final void mo6218o(String str, boolean z) {
                                    AppMethodBeat.m2504i(23208);
                                    C4990ab.m7417i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", str, C34687a.this.ejD, Boolean.valueOf(z));
                                    if (z) {
                                        C9638aw.m17190ZK();
                                        C34687a.m56950a(C34687a.this.iFE, C34687a.this.jiE, str, C18628c.m29078XM().aoO(str).mo16706Oi());
                                    }
                                    AppMethodBeat.m2505o(23208);
                                }
                            });
                            AppMethodBeat.m2505o(23209);
                            return;
                        }
                        C34687a.m56950a(C34687a.this.iFE, C34687a.this.jiE, str, b);
                        AppMethodBeat.m2505o(23209);
                    }
                });
            }
            AppMethodBeat.m2505o(23211);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a$9 */
    class C70219 implements C1202f {
        C70219() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(23214);
            c1207m.ftk = true;
            C39501a c39501a = (C39501a) c1207m;
            if (i == 0 && i2 == 0) {
                if (c39501a.pkG == null) {
                    c39501a.pkG = (alp) c39501a.ehh.fsH.fsP;
                }
                Uri uri = null;
                try {
                    uri = Uri.parse(c39501a.pkG.wqR);
                } catch (Exception e) {
                    C4990ab.m7417i("MicroMsg.NewContactWidgetNormal", "goToWework() Exception:%s", e.getMessage());
                }
                C34687a.this.jiE.startActivityForResult(new Intent("android.intent.action.VIEW", uri), 111);
                C4990ab.m7417i("MicroMsg.NewContactWidgetNormal", "goToWework() success! openurl:%s", r1);
                AppMethodBeat.m2505o(23214);
                return;
            }
            String str2;
            C4990ab.m7416i("MicroMsg.NewContactWidgetNormal", "goToWework() fail!");
            if (c39501a.pkG == null) {
                c39501a.pkG = (alp) c39501a.ehh.fsH.fsP;
            }
            if (c39501a.pkG.BaseResponse == null || c39501a.pkG.BaseResponse.ErrMsg == null) {
                str2 = c39501a.aIm;
            } else {
                str2 = C5046bo.nullAsNil(c39501a.pkG.BaseResponse.ErrMsg.wVI);
            }
            if (C5046bo.isNullOrNil(str2)) {
                str2 = C34687a.this.jiE.getString(C25738R.string.day);
            }
            C30379h.m48461b(C34687a.this.jiE, str2, C34687a.this.jiE.getString(C25738R.string.ewj), false);
            AppMethodBeat.m2505o(23214);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a$10 */
    class C2867910 implements C36073c {
        C2867910() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(23215);
            c44273l.mo70063ax(2, C25738R.string.f9132qh, C1318a.sharemore_videovoip);
            c44273l.mo70063ax(1, C25738R.string.f9134qj, C1318a.sharemore_voipvoice);
            AppMethodBeat.m2505o(23215);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a$1 */
    class C346861 implements OnClickListener {
        C346861() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23203);
            C34687a.this.pkh.mo68929jL(true);
            AppMethodBeat.m2505o(23203);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a$4 */
    class C346904 implements C9636a {
        C346904() {
        }

        /* renamed from: o */
        public final void mo6218o(String str, boolean z) {
            AppMethodBeat.m2504i(23206);
            C4990ab.m7417i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", str, C34687a.this.ejD, Boolean.valueOf(z));
            C34687a.this.pkk.dead();
            AppMethodBeat.m2505o(23206);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a$3 */
    class C346943 implements DialogInterface.OnClickListener {
        C346943() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23205);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(23205);
        }
    }

    public C34687a(MMActivity mMActivity) {
        AppMethodBeat.m2504i(23220);
        this.jiE = mMActivity;
        AppMethodBeat.m2505o(23220);
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
    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        int i2;
        String c;
        AppMethodBeat.m2504i(23221);
        this.readOnly = this.readOnly;
        this.iFE = c15541f;
        this.ldh = c7616ad;
        this.gOW = i;
        this.ejD = this.jiE.getIntent().getStringExtra("room_name");
        C9638aw.m17190ZK();
        this.eih = C18628c.m29087XV().mo14885oa(this.ejD);
        if (this.pkh == null) {
            this.pkh = new C43387b(this.jiE, c7616ad);
            this.pkh.bKH();
        }
        C4990ab.m7417i("MicroMsg.NewContactWidgetNormal", "[onAttach] username:%s", c7616ad.field_username);
        c15541f.removeAll();
        c15541f.addPreferencesFromResource(C25738R.xml.f8520b5);
        NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) c15541f.aqO("contact_profile_header_normal");
        normalProfileHeaderPreference.iFE = c15541f;
        normalProfileHeaderPreference.mo8202a(c7616ad, i, z, this.pkh);
        ButtonPreference buttonPreference = (ButtonPreference) c15541f.aqO("contact_profile_send");
        if (buttonPreference != null) {
            buttonPreference.vql = 2131823106;
        }
        Context context = this.jiE;
        C7616ad c7616ad2 = this.ldh;
        if (C7616ad.aox(c7616ad2.field_username) && c7616ad2.duv != 0) {
            int indexOf = c15541f.indexOf("contact_info_category_1");
            CharSequence c2 = ((C32873b) C1720g.m3528K(C32873b.class)).mo44307c(c7616ad2.field_openImAppid, "openim_custom_info_header", C32874a.TYPE_WORDING);
            if (!TextUtils.isEmpty(c2)) {
                PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(context);
                preferenceTitleCategory.setTitle(c2);
                c15541f.mo27708a(preferenceTitleCategory, indexOf);
                preferenceTitleCategory.yCX = new C248031();
            }
            C32875c c32875c = new C32875c();
            c32875c.mo53440vj(c7616ad2.duw);
            for (C18734a c18734a : c32875c.geU) {
                for (C26514b c26514b : c18734a.geV) {
                    indexOf++;
                    C250272 c250272 = new C250272(context, c26514b);
                    c250272.ylA = c18734a.title;
                    c250272.setSummary((CharSequence) C44089j.m79292b(context, c26514b.mo44297vk(c7616ad2.field_openImAppid)));
                    c15541f.mo27708a(c250272, indexOf);
                    if (c26514b.action == 0 || c26514b.action == 1) {
                        c250272.setEnabled(true);
                    } else if (c26514b.action == 2) {
                        c250272.yCX = new C286803(c26514b, c7616ad2, c18734a, context);
                    } else if (c26514b.action == 3) {
                        c250272.yCX = new C394994(c26514b, c7616ad2, c18734a, context);
                    } else if (c26514b.action == 4) {
                        c250272.yCX = new C433815(c26514b, c7616ad2, c18734a);
                    } else if (c26514b.action == 5) {
                        c250272.yCX = new C395006(c26514b, c7616ad2, c18734a);
                    }
                }
            }
            i2 = indexOf + 1;
            c15541f.mo27708a(new PreferenceSmallCategory(context), i2);
            int i3 = i2 + 1;
            KeyValuePreference keyValuePreference = new KeyValuePreference(context);
            keyValuePreference.setTitle((int) C25738R.string.avq);
            CharSequence c3 = ((C32873b) C1720g.m3528K(C32873b.class)).mo44307c(c7616ad2.field_openImAppid, "openim_intro_desc", C32874a.TYPE_WORDING);
            keyValuePreference.setSummary((CharSequence) C44089j.m79292b(context, c3));
            c = ((C32873b) C1720g.m3528K(C32873b.class)).mo44307c(c7616ad2.field_openImAppid, "openim_intro_url", C32874a.TYPE_URL);
            if (!TextUtils.isEmpty(c)) {
                keyValuePreference.yCX = new C433827(c, c7616ad2, c3);
            }
            c15541f.mo27708a(keyValuePreference, i3);
        }
        KeyValuePreference keyValuePreference2;
        if (cai()) {
            c15541f.removeAll();
            c15541f.mo27713b(normalProfileHeaderPreference);
            c15541f.mo27713b(new PreferenceSmallCategory(this.jiE));
            keyValuePreference2 = new KeyValuePreference(this.jiE);
            keyValuePreference2.setTitle((int) C25738R.string.aww);
            keyValuePreference2.setSummary((int) C25738R.string.b2e);
            keyValuePreference2.mo41839NT(BaseClientBuilder.API_PRIORITY_OTHER);
            keyValuePreference2.yCj = false;
            keyValuePreference2.mo39406NW(8);
            c15541f.mo27713b(keyValuePreference2);
            c15541f.mo27713b(new PreferenceSmallCategory(this.jiE));
            c15541f.mo27713b(buttonPreference);
            this.pkh.knn.mController.removeAllOptionMenu();
            AppMethodBeat.m2505o(23221);
            return true;
        }
        CharSequence charSequence;
        String str;
        Object obj;
        MultiButtonPreference multiButtonPreference;
        Object[] objArr;
        boolean aoJ;
        C36117 c36117;
        C7616ad c7616ad3 = this.ldh;
        i2 = this.jiE.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
        long longExtra = this.jiE.getIntent().getLongExtra("Contact_KSnsBgId", -1);
        String bc = C5046bo.m7532bc(this.jiE.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
        ccl ccl = new ccl();
        ccl.guY = i2;
        ccl.gva = longExtra;
        ccl.guZ = bc;
        if (C21877n.qFy != null) {
            ccl = C21877n.qFy.mo47114b(c7616ad3.field_username, ccl);
        }
        C9638aw.m17190ZK();
        boolean aoJ2 = C18628c.m29078XM().aoJ(c7616ad3.field_username);
        boolean equals = C1853r.m3846Yz().equals(c7616ad3.field_username);
        C4990ab.m7417i("MicroMsg.NewContactWidgetNormal", "isFriend:%s isSelf:%s openAlbum:%s", Boolean.valueOf(aoJ2), Boolean.valueOf(equals), Boolean.valueOf((ccl.guY & 1) > 0));
        if ((!C7616ad.aov(c7616ad3.field_username) && r4) || cak() || equals) {
            this.iFE.mo27715ce("contact_profile_sns", false);
            C46634g c46634g = (C46634g) this.iFE.aqO("contact_profile_sns");
            if (C21877n.qFC != null) {
                C21877n.qFC.mo8617a(3, c7616ad3.field_username, this);
                C21877n.qFC.mo8618a(2, c7616ad3.field_username, equals, this.jiE.getIntent().getIntExtra("Sns_from_Scene", 0));
            }
            c46634g.ajO(c7616ad3.field_username);
        } else {
            this.iFE.mo27715ce("contact_profile_sns", true);
        }
        if (C7616ad.aox(c7616ad3.field_username)) {
            this.iFE.mo27715ce("contact_profile_sns", true);
        }
        Preference aqO = c15541f.aqO("contact_profile_setting_desc");
        if (C7616ad.aox(this.ldh.field_username)) {
            charSequence = this.jiE.getText(C25738R.string.b2o).toString();
        } else {
            charSequence = this.jiE.getText(C25738R.string.b2n).toString();
        }
        aqO.setTitle(charSequence);
        keyValuePreference2 = (KeyValuePreference) c15541f.aqO("contact_profile_source");
        CharSequence a = NormalProfileHeaderPreference.m5953a(this.jiE, this.ldh, this.jiE.getIntent().getIntExtra("Contact_Source_FMessage", i), this.ldh.field_username, cak());
        keyValuePreference2.setSummary(a);
        keyValuePreference2.mo41839NT(2);
        keyValuePreference2.yCj = false;
        keyValuePreference2.nnX = ((float) C1338a.m2859ao(this.jiE, (int) this.jiE.getResources().getDimension(C25738R.dimen.f9980m5))) * C1338a.m2860dm(this.jiE);
        keyValuePreference2.mo39406NW(8);
        c = "contact_profile_source";
        boolean z2 = C7486a.m12942jh(c7616ad.field_type) || C5046bo.m7519ac(a) || (cal() && !cak());
        c15541f.mo27715ce(c, z2);
        LabelPreference labelPreference = (LabelPreference) c15541f.aqO("contact_profile_label");
        labelPreference.ldh = c7616ad;
        if (!C7486a.m12942jh(labelPreference.ldh.field_type)) {
            str = labelPreference.ldh.field_encryptUsername;
            if (!C5046bo.isNullOrNil(str)) {
                C9638aw.m17190ZK();
                labelPreference.pCq = C18628c.m29079XN().mo15364RB(str);
            }
            if (labelPreference.pCq != null && labelPreference.pCq.xDa < 0) {
                C9638aw.m17190ZK();
                labelPreference.pCq = C18628c.m29079XN().mo15364RB(labelPreference.ldh.field_username);
            }
        }
        str = "contact_profile_label";
        if (C7486a.m12942jh(labelPreference.ldh.field_type) && !C5046bo.isNullOrNil(labelPreference.ldh.field_contactLabelIds)) {
            obj = 1;
        } else if (labelPreference.pCq == null || C5046bo.isNullOrNil(labelPreference.pCq.field_contactLabels)) {
            obj = null;
        } else {
            obj = 1;
        }
        c15541f.mo27715ce(str, obj == null);
        PhoneNumPreference phoneNumPreference = (PhoneNumPreference) c15541f.aqO("contact_profile_phone");
        phoneNumPreference.iFE = c15541f;
        Intent intent = this.jiE.getIntent();
        phoneNumPreference.ldh = c7616ad;
        phoneNumPreference.vin = c7616ad.dur;
        C4990ab.m7417i("MicroMsg.PhoneNumPreference", "isCancelMatchPhoneMD5 %s", c7616ad.mo16703Of());
        if (!c7616ad.mo16703Of()) {
            C18817a c18817a = null;
            bc = intent.getStringExtra("Contact_Mobile_MD5");
            c = intent.getStringExtra("Contact_full_Mobile_MD5");
            String str2;
            Object[] objArr2;
            if (C5046bo.isNullOrNil(bc) && C5046bo.isNullOrNil(c)) {
                if (!C5046bo.isNullOrNil(c7616ad.field_username)) {
                    C18817a vT = C32923a.getAddrUploadStg().mo34089vT(c7616ad.field_username);
                    bc = "MicroMsg.PhoneNumPreference";
                    str2 = "Contact name: %s AddrUpload IS NULL? %s";
                    objArr2 = new Object[2];
                    objArr2[0] = c7616ad.field_username;
                    objArr2[1] = vT == null ? "true" : "false";
                    C4990ab.m7417i(bc, str2, objArr2);
                    c18817a = vT;
                }
            } else if (!(C5046bo.isNullOrNil(bc) && C5046bo.isNullOrNil(c))) {
                C4990ab.m7417i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", c7616ad.field_username, bc, c);
                c18817a = C32923a.getAddrUploadStg().mo34092vW(bc);
                if (c18817a == null || C5046bo.isNullOrNil(c18817a.mo34067Aq())) {
                    c18817a = C32923a.getAddrUploadStg().mo34092vW(c);
                }
                bc = "MicroMsg.PhoneNumPreference";
                str2 = "Contact name: %s AddrUpload IS NULL? %s";
                objArr2 = new Object[2];
                objArr2[0] = c7616ad.field_username;
                objArr2[1] = c18817a == null ? "true" : "false";
                C4990ab.m7417i(bc, str2, objArr2);
            }
            if (!(c18817a == null || C5046bo.isNullOrNil(c18817a.mo34067Aq()))) {
                phoneNumPreference.vim = C5046bo.nullAsNil(c18817a.apG()).replace(" ", "");
                C4990ab.m7417i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s", c7616ad.field_username, phoneNumPreference.vim);
            }
            phoneNumPreference.dlc();
        }
        phoneNumPreference.iFE.mo27715ce("contact_profile_phone", true);
        phoneNumPreference.dlc();
        phoneNumPreference.mo39406NW(8);
        ProfileDescribePreference profileDescribePreference = (ProfileDescribePreference) c15541f.aqO("contact_profile_desc");
        profileDescribePreference.ldh = c7616ad;
        if (!C7486a.m12942jh(profileDescribePreference.ldh.field_type)) {
            str = profileDescribePreference.ldh.field_encryptUsername;
            if (!C5046bo.isNullOrNil(str)) {
                C9638aw.m17190ZK();
                profileDescribePreference.pCq = C18628c.m29079XN().mo15364RB(str);
            }
            if (profileDescribePreference.pCq != null && profileDescribePreference.pCq.xDa < 0) {
                C9638aw.m17190ZK();
                profileDescribePreference.pCq = C18628c.m29079XN().mo15364RB(profileDescribePreference.ldh.field_username);
            }
        }
        c = "contact_profile_desc";
        if (C7486a.m12942jh(profileDescribePreference.ldh.field_type)) {
            obj = (C5046bo.isNullOrNil(profileDescribePreference.ldh.dul) && (!C5046bo.isNullOrNil(profileDescribePreference.ldh.dum) ? 1 : null) == null) ? null : 1;
        } else {
            obj = (profileDescribePreference.pCq == null || C5046bo.isNullOrNil(profileDescribePreference.pCq.field_conDescription)) ? null : 1;
        }
        if (obj == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        c15541f.mo27715ce(c, z2);
        if (C7486a.m12942jh(c7616ad.field_type) || C5046bo.isNullOrNil(c7616ad.signature)) {
            c15541f.aqP("contact_info_signature");
        } else {
            keyValuePreference2 = (KeyValuePreference) c15541f.aqO("contact_info_signature");
            if (keyValuePreference2 != null) {
                keyValuePreference2.nnX = ((float) C1338a.m2859ao(this.jiE, (int) this.jiE.getResources().getDimension(C25738R.dimen.f9980m5))) * C1338a.m2860dm(this.jiE);
                keyValuePreference2.yCj = false;
                keyValuePreference2.setTitle((CharSequence) this.jiE.getString(C25738R.string.b0a));
                keyValuePreference2.setSummary((CharSequence) C44089j.m79292b(this.jiE, c7616ad.signature));
                keyValuePreference2.mo41844qi(false);
                keyValuePreference2.mo41839NT(5);
                keyValuePreference2.mo39406NW(8);
            }
        }
        if (c15541f.aqQ("contact_profile_desc") < 0) {
            if (c15541f.aqQ("contact_profile_label") < 0) {
                c15541f.mo27715ce("contact_profile_setting_desc", false);
                if (!C7486a.m12942jh(c7616ad.field_type)) {
                    c15541f.mo27715ce("contact_profile_setting_desc", false);
                }
                c15541f.mo27715ce("contact_profile_set_des_category", true);
                if (!C7616ad.aox(this.ldh.field_username) && C5046bo.isNullOrNil(this.ldh.field_conRemark)) {
                    c15541f.mo27715ce("contact_profile_setting_desc", false);
                    c15541f.mo27715ce("contact_profile_set_des_category", true);
                } else if (C7616ad.aox(this.ldh.field_username)) {
                    c15541f.mo27715ce("contact_profile_setting_desc", true);
                    c15541f.mo27715ce("contact_profile_set_des_category", true);
                }
                c15541f.aqO("contact_profile_info_more").setTitle(this.jiE.getText(C25738R.string.ay0).toString());
                ((TextPreference) c15541f.aqO("contact_profile_hint")).mo56922ae(this.jiE.getText(C25738R.string.ay5));
                if (c7616ad.mo16698Oa()) {
                    c15541f.mo27715ce("contact_profile_hint", true);
                } else {
                    c15541f.mo27715ce("contact_profile_hint", false);
                }
                multiButtonPreference = (MultiButtonPreference) c15541f.aqO("contact_profile_multi_button");
                if (!cak()) {
                    Object obj2;
                    if (C7486a.m12942jh(this.ldh.field_type) || this.jiE.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) != 2) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 == null) {
                        if (c7616ad.mo16698Oa() || can() || cam()) {
                            multiButtonPreference.mo62464a(this.jiE.getString(C25738R.string.a9n), new C36128());
                        }
                        if (cah() || ((C7486a.m12942jh(c7616ad.field_type) && !c7616ad.mo16698Oa()) || (!cak() && cal()))) {
                            c15541f.mo27715ce("contact_profile_multi_button", true);
                        }
                        if (C7486a.m12942jh(this.ldh.field_type) || cak() || cao() || caj()) {
                            c15541f.mo27715ce("contact_profile_send", true);
                            c15541f.mo27715ce("contact_profile_voip", true);
                        } else {
                            c15541f.mo27715ce("contact_profile_send", false);
                            c15541f.mo27715ce("contact_profile_voip", this.ldh.mo16698Oa());
                        }
                        if (!C7486a.m12942jh(this.ldh.field_type) || cak() || cao() || can() || cam()) {
                            c15541f.mo27715ce("contact_profile_add_contact", true);
                        } else {
                            c15541f.mo27715ce("contact_profile_add_contact", false);
                            c15541f.mo27715ce("contact_profile_setting_desc", false);
                            c15541f.mo27715ce("contact_profile_phone", true);
                            c15541f.mo27715ce("contact_profile_info_more", true);
                        }
                        m56951a(c15541f, c7616ad, false);
                        if (cak() && !C7486a.m12942jh(c7616ad.field_type) && (caj() || can() || cam())) {
                            c15541f.mo27715ce("contact_profile_info_more", true);
                            c15541f.mo27715ce("contact_profile_say_hi", false);
                        } else {
                            c15541f.mo27715ce("contact_profile_say_hi", true);
                            if (C7486a.m12942jh(c7616ad.field_type)) {
                                c15541f.mo27715ce("contact_profile_info_more", false);
                            } else {
                                c15541f.mo27715ce("contact_profile_info_more", true);
                            }
                        }
                        if (C1853r.m3858mG(this.ldh.field_username)) {
                            c15541f.mo27715ce("contact_profile_multi_button", true);
                            c15541f.mo27715ce("contact_profile_info_more", C5046bo.isNullOrNil(c7616ad.signature));
                            c15541f.mo27715ce("contact_profile_setting_desc", true);
                            c15541f.mo27715ce("contact_profile_voip", true);
                            this.pkh.knn.mController.removeAllOptionMenu();
                        }
                        c7616ad3 = this.ldh;
                        c15541f.mo27715ce("contact_info_invite_source", true);
                        z2 = this.eih == null ? this.jiE.getIntent().getBooleanExtra("Is_RoomOwner", false) : this.eih.mo16786JR();
                        if (this.gOW == 14 || !z2 || this.eih == null || c7616ad3.field_username.equals(this.eih.field_roomowner)) {
                            str = "MicroMsg.NewContactWidgetNormal";
                            c = "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s";
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(this.gOW);
                            objArr[1] = Boolean.valueOf(z2);
                            objArr[2] = Boolean.valueOf(this.eih == null);
                            C4990ab.m7417i(str, c, objArr);
                            c15541f.mo27715ce("contact_info_invite_source", true);
                        } else {
                            this.pkj = this.jiE.getIntent().getStringExtra("inviteer");
                            if (C5046bo.isNullOrNil(this.pkj)) {
                                this.pkj = this.eih.aop(c7616ad3.field_username);
                            }
                            if (C5046bo.isNullOrNil(this.pkj)) {
                                this.pkj = C37921n.m64046Z(c7616ad3.field_username, this.ejD);
                            }
                            if (C5046bo.isNullOrNil(this.pkj)) {
                                C4990ab.m7421w("MicroMsg.NewContactWidgetNormal", "mRoomId:%s member:%s , inviter is null!", this.ejD, c7616ad3.field_username);
                                this.pkk.dnU();
                                C26417a.flu.mo20966a(c7616ad3.field_username, this.ejD, new C346904());
                            } else {
                                this.jiE.getIntent().putExtra("inviteer", this.pkj);
                                String b = C34687a.m56953b(this.eih, this.pkj);
                                if (C5046bo.isNullOrNil(b)) {
                                    final C15541f c15541f2 = c15541f;
                                    C26417a.flu.mo20966a(c7616ad3.field_username, "", new C9636a() {
                                        /* renamed from: o */
                                        public final void mo6218o(String str, boolean z) {
                                            AppMethodBeat.m2504i(23207);
                                            C4990ab.m7417i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", str, C34687a.this.ejD, Boolean.valueOf(z));
                                            if (z) {
                                                C9638aw.m17190ZK();
                                                C34687a.m56950a(c15541f2, C34687a.this.jiE, C34687a.this.pkj, C18628c.m29078XM().aoO(str).mo16706Oi());
                                            }
                                            AppMethodBeat.m2505o(23207);
                                        }
                                    });
                                } else {
                                    C34687a.m56950a(c15541f, this.jiE, this.pkj, b);
                                }
                            }
                        }
                        this.iFE.mo27715ce("contact_profile_story", true);
                        C9638aw.m17190ZK();
                        aoJ = C18628c.m29078XM().aoJ(c7616ad.field_username);
                        aoJ2 = C1853r.m3846Yz().equals(c7616ad.field_username);
                        if (((C35168e) C1720g.m3530M(C35168e.class)).getStoryBasicConfig().cwU()) {
                            C4990ab.m7417i("MicroMsg.NewContactWidgetNormal", "updateStoryVisible isFriend:%s isSelf:%s ", Boolean.valueOf(aoJ), Boolean.valueOf(aoJ2));
                            if ((!C7616ad.aov(c7616ad.field_username) && aoJ) || aoJ2) {
                                AbsStoryPreference absStoryPreference = (AbsStoryPreference) this.iFE.aqO("contact_profile_story");
                                absStoryPreference.onCreate(c7616ad.field_username);
                                absStoryPreference.mo41694a(this);
                                absStoryPreference.cwP();
                                absStoryPreference.cwO();
                            }
                        }
                        AppMethodBeat.m2505o(23221);
                        return true;
                    }
                }
                if (this.ldh.mo16698Oa()) {
                    str = this.jiE.getString(C25738R.string.ay1);
                } else {
                    str = this.jiE.getString(C25738R.string.ay6);
                }
                multiButtonPreference.mo62464a(str, new C346861());
                str = this.jiE.getString(C25738R.string.a9n);
                c36117 = new C36117();
                multiButtonPreference.pnK = str;
                multiButtonPreference.pnN = c36117;
                c15541f.mo27715ce("contact_profile_multi_button", true);
                if (C7486a.m12942jh(this.ldh.field_type)) {
                }
                c15541f.mo27715ce("contact_profile_send", true);
                c15541f.mo27715ce("contact_profile_voip", true);
                if (C7486a.m12942jh(this.ldh.field_type)) {
                }
                c15541f.mo27715ce("contact_profile_add_contact", true);
                m56951a(c15541f, c7616ad, false);
                if (cak()) {
                }
                c15541f.mo27715ce("contact_profile_say_hi", true);
                if (C7486a.m12942jh(c7616ad.field_type)) {
                }
                if (C1853r.m3858mG(this.ldh.field_username)) {
                }
                c7616ad3 = this.ldh;
                c15541f.mo27715ce("contact_info_invite_source", true);
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
                C4990ab.m7417i(str, c, objArr);
                c15541f.mo27715ce("contact_info_invite_source", true);
                this.iFE.mo27715ce("contact_profile_story", true);
                C9638aw.m17190ZK();
                aoJ = C18628c.m29078XM().aoJ(c7616ad.field_username);
                aoJ2 = C1853r.m3846Yz().equals(c7616ad.field_username);
                if (((C35168e) C1720g.m3530M(C35168e.class)).getStoryBasicConfig().cwU()) {
                }
                AppMethodBeat.m2505o(23221);
                return true;
            }
        }
        c15541f.mo27715ce("contact_profile_setting_desc", true);
        if (C7486a.m12942jh(c7616ad.field_type)) {
        }
        c15541f.mo27715ce("contact_profile_set_des_category", true);
        if (!C7616ad.aox(this.ldh.field_username)) {
        }
        if (C7616ad.aox(this.ldh.field_username)) {
        }
        c15541f.aqO("contact_profile_info_more").setTitle(this.jiE.getText(C25738R.string.ay0).toString());
        ((TextPreference) c15541f.aqO("contact_profile_hint")).mo56922ae(this.jiE.getText(C25738R.string.ay5));
        if (c7616ad.mo16698Oa()) {
        }
        multiButtonPreference = (MultiButtonPreference) c15541f.aqO("contact_profile_multi_button");
        if (cak()) {
        }
        if (this.ldh.mo16698Oa()) {
        }
        multiButtonPreference.mo62464a(str, new C346861());
        str = this.jiE.getString(C25738R.string.a9n);
        c36117 = new C36117();
        multiButtonPreference.pnK = str;
        multiButtonPreference.pnN = c36117;
        c15541f.mo27715ce("contact_profile_multi_button", true);
        if (C7486a.m12942jh(this.ldh.field_type)) {
        }
        c15541f.mo27715ce("contact_profile_send", true);
        c15541f.mo27715ce("contact_profile_voip", true);
        if (C7486a.m12942jh(this.ldh.field_type)) {
        }
        c15541f.mo27715ce("contact_profile_add_contact", true);
        m56951a(c15541f, c7616ad, false);
        if (cak()) {
        }
        c15541f.mo27715ce("contact_profile_say_hi", true);
        if (C7486a.m12942jh(c7616ad.field_type)) {
        }
        if (C1853r.m3858mG(this.ldh.field_username)) {
        }
        c7616ad3 = this.ldh;
        c15541f.mo27715ce("contact_info_invite_source", true);
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
        C4990ab.m7417i(str, c, objArr);
        c15541f.mo27715ce("contact_info_invite_source", true);
        this.iFE.mo27715ce("contact_profile_story", true);
        C9638aw.m17190ZK();
        aoJ = C18628c.m29078XM().aoJ(c7616ad.field_username);
        aoJ2 = C1853r.m3846Yz().equals(c7616ad.field_username);
        if (((C35168e) C1720g.m3530M(C35168e.class)).getStoryBasicConfig().cwU()) {
        }
        AppMethodBeat.m2505o(23221);
        return true;
    }

    /* renamed from: a */
    private void m56951a(C15541f c15541f, C7616ad c7616ad, boolean z) {
        AppMethodBeat.m2504i(23222);
        if (cak()) {
            c15541f.mo27715ce("contact_profile_setting_desc", true);
            c15541f.mo27715ce("contact_profile_phone", true);
            c15541f.mo27715ce("contact_profile_info_more", true);
            c15541f.mo27715ce("contact_profile_sns", C7616ad.aox(c7616ad.field_username));
            boolean z2 = (C1853r.m3823YE() & 268435456) != 0;
            boolean u = C35799p.m58695u(this.jiE, "com.tencent.wework");
            C9638aw.m17190ZK();
            Integer num = (Integer) C18628c.m29072Ry().get(C5127a.USERINFO_ADD_CONTACT_BY_WEWORK_SWITCH_INT, Integer.valueOf(0));
            C4990ab.m7417i("MicroMsg.NewContactWidgetNormal", "ExtStatus:%s openAddByWework:%s isInstallWework:%s", Long.valueOf(C1853r.m3823YE()), Boolean.valueOf(z2), Boolean.valueOf(u));
            if (C5046bo.m7563gW(num.intValue(), 1) || (z2 && C35799p.m58695u(this.jiE, "com.tencent.wework") && !C7616ad.aox(this.ldh.field_username))) {
                String str;
                c15541f.mo27715ce("contact_profile_accept_contact_by_wework", false);
                C14957b[] a = C28705p.m45603a(this.jiE, c7616ad, this.gOW);
                String str2 = "";
                if (a == null || a.length <= 0) {
                    str = str2;
                } else {
                    str = C28705p.m45604b(this.jiE, c7616ad, this.gOW);
                }
                if (C21453e.m32905UM(this.ldh.field_username)) {
                    ((ButtonPreference) c15541f.aqO("contact_profile_accept_contact_by_wework")).mo41835ed(this.jiE.getString(C25738R.string.awr), this.jiE.getResources().getColor(C25738R.color.f11795hi));
                }
                if (!C5046bo.isNullOrNil(str) && C21453e.m32904UL(str) == 2 && z) {
                    c15541f.mo27715ce("contact_profile_accept_contact", true);
                }
                AppMethodBeat.m2505o(23222);
                return;
            }
            c15541f.mo27715ce("contact_profile_accept_contact_by_wework", true);
            AppMethodBeat.m2505o(23222);
            return;
        }
        c15541f.mo27715ce("contact_profile_accept_contact", true);
        c15541f.mo27715ce("contact_profile_accept_contact_by_wework", true);
        AppMethodBeat.m2505o(23222);
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(23223);
        this.iFE.aqO("contact_profile_sns");
        if (C21877n.qFC != null) {
            C21877n.qFC.mo8619a(this, 3);
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
        AppMethodBeat.m2505o(23223);
        return false;
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(23224);
        Intent intent;
        C7616ad c7616ad;
        String str2;
        Intent intent2;
        String stringExtra;
        C7616ad c7616ad2;
        if (str.equals("contact_profile_sns")) {
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                Intent intent3 = this.jiE.getIntent();
                intent3.putExtra("sns_source", this.jiE.getIntent().getIntExtra("Sns_from_Scene", 0));
                intent3.putExtra("sns_signature", this.ldh.signature);
                intent3.putExtra("sns_nickName", this.ldh.mo16706Oi());
                intent3.putExtra("sns_title", this.ldh.mo16707Oj());
                if (C21877n.qFC != null) {
                    intent3 = C21877n.qFC.mo8622e(intent3, this.ldh.field_username);
                }
                if (intent3 == null) {
                    this.jiE.finish();
                } else {
                    C25985d.m41467b(this.jiE, "sns", ".ui.SnsUserUI", intent3);
                    if ((intent3.getFlags() & 67108864) != 0) {
                        this.jiE.finish();
                    }
                }
            } else {
                C23639t.m36492hO(this.jiE);
            }
        } else if (str.equals("contact_profile_label") || str.equals("contact_profile_desc") || str.equals("contact_profile_phone") || str.equals("contact_profile_setting_desc")) {
            C7616ad c7616ad3 = this.ldh;
            if (c7616ad3 == null) {
                C4990ab.m7412e("MicroMsg.NewContactWidgetNormal", "contact is null");
            } else if (C7486a.m12942jh(c7616ad3.field_type)) {
                PhoneNumPreference phoneNumPreference = (PhoneNumPreference) this.iFE.aqO("contact_profile_phone");
                intent = new Intent();
                intent.putExtra("Contact_Scene", this.gOW);
                intent.putExtra("Contact_User", c7616ad3.field_username);
                intent.putExtra("Contact_RoomNickname", this.jiE.getIntent().getStringExtra("Contact_RoomNickname"));
                intent.putExtra("view_mode", true);
                intent.putExtra("contact_phone_number_by_md5", phoneNumPreference.vim);
                intent.putExtra("contact_phone_number_list", c7616ad3.dur);
                C39503b.gkE.mo38928m(intent, this.jiE);
            } else if (C5046bo.isNullOrNil(c7616ad3.field_encryptUsername)) {
                m56952a(c7616ad3.field_username, c7616ad3);
            } else {
                m56952a(c7616ad3.field_encryptUsername, c7616ad3);
            }
        } else if (str.equals("contact_profile_power")) {
            if (this.pkh != null) {
                this.pkh.cas();
            }
        } else if (str.equals("contact_profile_send")) {
            c7616ad = this.ldh;
            if (C5046bo.m7517a(Boolean.valueOf(C1855t.m3910mW(c7616ad.field_username)), false)) {
                str2 = c7616ad.field_username;
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
                    intent2.putExtra("Chat_User", c7616ad.field_username);
                    intent2.putExtra("Chat_Mode", 1);
                    this.jiE.setResult(-1, intent2);
                } else {
                    intent2.putExtra("Chat_User", c7616ad.field_username);
                    intent2.putExtra("Chat_Mode", 1);
                    intent2.setClassName(this.jiE, "com.tencent.mm.ui.chatting.ChattingUI");
                    this.jiE.startActivity(intent2);
                }
            }
        } else if (str.equals("contact_profile_voip")) {
            final C7616ad c7616ad4 = this.ldh;
            C18411uh c18411uh = new C18411uh();
            C4879a.xxA.mo10055m(c18411uh);
            if (!c7616ad4.field_username.equals(c18411uh.cQt.talker) && (c18411uh.cQt.cQv || c18411uh.cQt.cQw)) {
                Toast.makeText(this.jiE, c18411uh.cQt.cQu ? C25738R.string.ac6 : C25738R.string.ac7, 0).show();
                C4990ab.m7416i("MicroMsg.NewContactWidgetNormal", "voip is running, can't do this");
            } else if (!C35973a.m59177bH(this.jiE)) {
                C42062sz c42062sz = new C42062sz();
                c42062sz.cPf.cPh = true;
                C4879a.xxA.mo10055m(c42062sz);
                str2 = c42062sz.cPg.cPj;
                if (C5046bo.isNullOrNil(str2)) {
                    mo55299a(c7616ad4, this.jiE);
                } else {
                    C4990ab.m7418v("MicroMsg.NewContactWidgetNormal", "Talkroom is on: ".concat(String.valueOf(str2)));
                    C30379h.m48466d(this.jiE, this.jiE.getString(C25738R.string.euf), "", this.jiE.getString(C25738R.string.f9187s6), this.jiE.getString(C25738R.string.f9076or), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(23204);
                            C42062sz c42062sz = new C42062sz();
                            c42062sz.cPf.cPi = true;
                            C4879a.xxA.mo10055m(c42062sz);
                            C34687a.this.mo55299a(c7616ad4, C34687a.this.jiE);
                            dialogInterface.dismiss();
                            AppMethodBeat.m2505o(23204);
                        }
                    }, new C346943());
                }
            }
        } else if (str.equals("contact_profile_add_contact")) {
            final MMActivity mMActivity = this.jiE;
            C7616ad c7616ad5 = this.ldh;
            final int i = this.gOW;
            if (((int) c7616ad5.ewQ) == 0) {
                C9638aw.m17190ZK();
                if (C18628c.m29078XM().mo15708aa(c7616ad5) != -1) {
                    C9638aw.m17190ZK();
                    c7616ad5 = C18628c.m29078XM().aoO(c7616ad5.field_username);
                }
            }
            str2 = this.jiE.getIntent().getStringExtra("Contact_Mobile_MD5");
            stringExtra = this.jiE.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            String nullAsNil = C5046bo.nullAsNil(str2);
            stringExtra = C5046bo.nullAsNil(stringExtra);
            if (!(nullAsNil.equals("") && stringExtra.equals(""))) {
                C18817a vW = C32923a.getAddrUploadStg().mo34092vW(nullAsNil);
                if (vW == null) {
                    vW = C32923a.getAddrUploadStg().mo34092vW(stringExtra);
                } else {
                    stringExtra = nullAsNil;
                }
                if (vW != null) {
                    C32923a.getAddrUploadStg().mo34084a(stringExtra, vW);
                }
            }
            C14916a c14916a = new C14916a(this.jiE, new C14917a() {
                /* renamed from: a */
                public final void mo5739a(boolean z, boolean z2, String str, String str2) {
                    AppMethodBeat.m2504i(23217);
                    if (z) {
                        C34687a c34687a = C34687a.this;
                        C7616ad c7616ad = c7616ad5;
                        int i = i;
                        if (((int) c7616ad.ewQ) == 0) {
                            C9638aw.m17190ZK();
                            C18628c.m29078XM().mo15708aa(c7616ad);
                            C9638aw.m17190ZK();
                            C18628c.m29078XM().aoO(c7616ad.field_username);
                        }
                        if (((int) c7616ad.ewQ) <= 0) {
                            C4990ab.m7412e("MicroMsg.NewContactWidgetNormal", "addContact : insert contact failed");
                            AppMethodBeat.m2505o(23217);
                            return;
                        }
                        if (!C7486a.m12942jh(c7616ad.field_type) && i == 15) {
                            C18817a vT = C32923a.getAddrUploadStg().mo34089vT(c7616ad.field_username);
                            if (!(vT == null || C5046bo.isNullOrNil(c7616ad.dur))) {
                                C7060h c7060h = C7060h.pYm;
                                Object[] objArr = new Object[4];
                                objArr[0] = c7616ad.field_username;
                                objArr[1] = Integer.valueOf(3);
                                if (C5046bo.isNullOrNil(vT.mo34067Aq())) {
                                    i = 0;
                                } else {
                                    i = 1;
                                }
                                objArr[2] = Integer.valueOf(i);
                                if (c7616ad.dur.toString().split(",").length >= 5) {
                                    i = 5;
                                } else {
                                    i = c7616ad.dur.toString().split(",").length;
                                }
                                objArr[3] = Integer.valueOf(i);
                                c7060h.mo8381e(12040, objArr);
                            }
                        }
                        C1855t.m3960q(c7616ad);
                        c34687a.iFE.notifyDataSetChanged();
                        AppMethodBeat.m2505o(23217);
                    } else if (z2) {
                        C41789d.akP().mo17076ep(str, 2);
                        AppMethodBeat.m2505o(23217);
                    } else {
                        C4990ab.m7412e("MicroMsg.NewContactWidgetNormal", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(str)));
                        AppMethodBeat.m2505o(23217);
                    }
                }
            });
            LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(i));
            nullAsNil = mMActivity.getIntent().getStringExtra("source_from_user_name");
            final String stringExtra2 = mMActivity.getIntent().getStringExtra("source_from_nick_name");
            c14916a.mo27245hH(nullAsNil, stringExtra2);
            c14916a.vjI = new C14918b() {
                /* renamed from: vQ */
                public final boolean mo8211vQ(String str) {
                    AppMethodBeat.m2504i(23218);
                    String stringExtra = mMActivity.getIntent().getStringExtra("room_name");
                    Intent intent = new Intent(mMActivity, SayHiWithSnsPermissionUI.class);
                    intent.putExtra("Contact_User", c7616ad5.field_username);
                    intent.putExtra("Contact_Nick", c7616ad5.field_nickname);
                    intent.putExtra("Contact_RemarkName", c7616ad5.field_conRemark);
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
                    intent.putExtra(C5495b.yfT, str);
                    mMActivity.startActivity(intent);
                    AppMethodBeat.m2505o(23218);
                    return true;
                }
            };
            nullAsNil = mMActivity.getIntent().getStringExtra("room_name");
            str2 = mMActivity.getIntent().getStringExtra(C5495b.yfT);
            if (!TextUtils.isEmpty(str2)) {
                c14916a.ajw(str2);
                c14916a.mo27243c(c7616ad5.field_username, "", linkedList);
            } else if (TextUtils.isEmpty(nullAsNil)) {
                c14916a.ajw(c7616ad5.dus);
                c14916a.mo27244e(c7616ad5.field_username, linkedList);
            } else if (TextUtils.isEmpty(c14916a.mGZ)) {
                C9638aw.m17190ZK();
                c7616ad = C18628c.m29078XM().aoO(c7616ad5.field_username);
                CharSequence bc = c7616ad != null ? C5046bo.m7532bc(c7616ad.dus, "") : "";
                C4990ab.m7417i("MicroMsg.NewContactWidgetNormal", "dkverify footer add:%s chat:%s ticket:%s", c7616ad5.field_username, nullAsNil, bc);
                if (TextUtils.isEmpty(bc)) {
                    final C14916a c14916a2 = c14916a;
                    final LinkedList linkedList2 = linkedList;
                    C26417a.flu.mo20966a(c7616ad5.field_username, nullAsNil, new C9636a() {
                        /* renamed from: o */
                        public final void mo6218o(String str, boolean z) {
                            AppMethodBeat.m2504i(23219);
                            C9638aw.m17190ZK();
                            C7616ad aoO = C18628c.m29078XM().aoO(c7616ad5.field_username);
                            c14916a2.ajw(aoO != null ? C5046bo.m7532bc(aoO.dus, "") : "");
                            c14916a2.mo27243c(c7616ad5.field_username, nullAsNil, linkedList2);
                            AppMethodBeat.m2505o(23219);
                        }
                    });
                } else {
                    c14916a.ajw(bc);
                    c14916a.mo27243c(c7616ad5.field_username, nullAsNil, linkedList);
                }
            } else {
                c14916a.mo27243c(c7616ad5.field_username, nullAsNil, linkedList);
            }
        } else if (str.equals("contact_profile_accept_contact")) {
            MMActivity mMActivity2 = this.jiE;
            c7616ad2 = this.ldh;
            mMActivity2.getIntent().removeExtra("Accept_NewFriend_FromOutside");
            Intent intent4 = new Intent(mMActivity2, SayHiWithSnsPermissionUI.class);
            intent4.putExtra("Contact_User", c7616ad2.field_username);
            intent4.putExtra("Contact_Nick", c7616ad2.field_nickname);
            intent4.putExtra("Contact_RemarkName", c7616ad2.field_conRemark);
            if (this.gOW == 14 || this.gOW == 8) {
                intent4.putExtra("Contact_RoomNickname", mMActivity2.getIntent().getStringExtra("Contact_RoomNickname"));
            }
            intent4.putExtra("Contact_Scene", this.gOW);
            intent4.putExtra("Verify_ticket", C5046bo.nullAsNil(mMActivity2.getIntent().getStringExtra("Verify_ticket")));
            intent4.putExtra("sayhi_with_sns_perm_send_verify", false);
            intent4.putExtra("sayhi_with_sns_perm_add_remark", true);
            intent4.putExtra("sayhi_with_sns_perm_set_label", true);
            intent4.putExtra("sayhi_with_sns_permission", c7616ad2.mo16701Od());
            mMActivity2.startActivity(intent4);
        } else if (str.equals("contact_profile_say_hi")) {
            c7616ad = this.ldh;
            intent2 = new Intent();
            intent2.putExtra("Contact_User", c7616ad.field_username);
            intent2.putExtra("Contact_Scene", this.gOW);
            intent2.putExtra(C5495b.yfT, c7616ad.dus);
            C39503b.gkE.mo38897a(intent2, this.jiE);
        } else if (str.equals("contact_profile_info_more")) {
            if (this.pkh != null) {
                C43387b.m77408a(this.jiE, this.ldh);
            }
        } else if (str.equals("contact_info_invite_source")) {
            str2 = ((KeyValuePreference) this.iFE.aqO("contact_info_invite_source")).getExtras().getString("inviter");
            if (!C5046bo.isNullOrNil(str2)) {
                stringExtra = C34687a.m56953b(this.eih, str2);
                intent = new Intent();
                intent.putExtra("Contact_User", str2);
                intent.putExtra("Contact_RemarkName", stringExtra);
                intent.putExtra("Contact_RoomNickname", stringExtra);
                intent.putExtra("Contact_RoomMember", true);
                intent.putExtra("room_name", this.ejD);
                C9638aw.m17190ZK();
                intent.putExtra("Contact_Nick", C18628c.m29078XM().aoO(str2).field_nickname);
                intent.putExtra("Contact_Scene", 14);
                intent.putExtra("Is_RoomOwner", true);
                intent.putExtra("Contact_ChatRoomId", this.ejD);
                C39503b.gkE.mo38912c(intent, this.jiE);
            }
        } else if (str.equals("contact_profile_accept_contact_by_wework")) {
            c7616ad2 = this.ldh;
            String nullAsNil2 = C5046bo.nullAsNil(this.jiE.getIntent().getStringExtra("Verify_ticket"));
            C14957b[] a = C28705p.m45603a(this.jiE, c7616ad2, this.gOW);
            stringExtra = "";
            str2 = "";
            if (a.length > 0) {
                stringExtra = a[a.length - 1].fjz;
                str2 = C28705p.m45604b(this.jiE, c7616ad2, this.gOW);
            }
            new C39501a(c7616ad2.field_username, nullAsNil2, str2, stringExtra).mo4456a(C1720g.m3535RO().eJo.ftA, new C70219());
        } else if (str.equals("contact_profile_story")) {
            AbsStoryPreference absStoryPreference = (AbsStoryPreference) this.iFE.aqO("contact_profile_story");
            if (absStoryPreference != null) {
                absStoryPreference.cwQ();
            }
        }
        AppMethodBeat.m2505o(23224);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(23225);
        m56951a(this.iFE, this.ldh, true);
        AppMethodBeat.m2505o(23225);
    }

    private boolean cah() {
        AppMethodBeat.m2504i(23226);
        for (String equalsIgnoreCase : C1855t.fkY) {
            if (equalsIgnoreCase.equalsIgnoreCase(this.ldh.field_username)) {
                AppMethodBeat.m2505o(23226);
                return true;
            }
        }
        boolean cai = cai();
        AppMethodBeat.m2505o(23226);
        return cai;
    }

    private boolean cai() {
        AppMethodBeat.m2504i(23227);
        boolean nB = C1855t.m3916nB(this.ldh.field_username);
        AppMethodBeat.m2505o(23227);
        return nB;
    }

    private boolean caj() {
        AppMethodBeat.m2504i(23228);
        boolean mR = C7616ad.m13548mR(this.ldh.field_username);
        AppMethodBeat.m2505o(23228);
        return mR;
    }

    private boolean cak() {
        AppMethodBeat.m2504i(23229);
        if (C7486a.m12942jh(this.ldh.field_type) || !this.jiE.getIntent().getBooleanExtra("User_Verify", false)) {
            AppMethodBeat.m2505o(23229);
            return false;
        }
        AppMethodBeat.m2505o(23229);
        return true;
    }

    private boolean cal() {
        AppMethodBeat.m2504i(23230);
        if (this.jiE.getIntent().getIntExtra("Contact_Scene", -1) == 14) {
            AppMethodBeat.m2505o(23230);
            return true;
        }
        AppMethodBeat.m2505o(23230);
        return false;
    }

    private boolean cam() {
        AppMethodBeat.m2504i(23231);
        if (this.jiE.getIntent().getIntExtra("Contact_Scene", 0) == 18) {
            AppMethodBeat.m2505o(23231);
            return true;
        }
        AppMethodBeat.m2505o(23231);
        return false;
    }

    private boolean can() {
        AppMethodBeat.m2504i(23232);
        int intExtra = this.jiE.getIntent().getIntExtra("Contact_Scene", 0);
        if (26 > intExtra || intExtra > 29) {
            AppMethodBeat.m2505o(23232);
            return false;
        }
        AppMethodBeat.m2505o(23232);
        return true;
    }

    private boolean cao() {
        return this.ldh.field_deleteFlag == 1;
    }

    /* renamed from: a */
    private void m56952a(String str, C7616ad c7616ad) {
        AppMethodBeat.m2504i(23233);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.NewContactWidgetNormal", "view stranger remark, username is null");
            AppMethodBeat.m2505o(23233);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Scene", this.gOW);
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", c7616ad.field_username);
        intent.putExtra("Contact_Nick", c7616ad.field_nickname);
        intent.putExtra("Contact_RemarkName", c7616ad.field_conRemark);
        C39503b.gkE.mo38929n(intent, this.jiE);
        AppMethodBeat.m2505o(23233);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo55299a(final C7616ad c7616ad, final Context context) {
        AppMethodBeat.m2504i(23234);
        this.pki = new C36356d(this.jiE, 1, false);
        this.pki.rBl = new C2867910();
        this.pki.rBm = new C5279d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(23216);
                C7616ad c7616ad;
                Context context;
                C26250ui c26250ui;
                switch (menuItem.getItemId()) {
                    case 1:
                        c7616ad = c7616ad;
                        context = context;
                        C4990ab.m7417i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a((Activity) context, "android.permission.RECORD_AUDIO", 82, "", "")), C5046bo.dpG(), context);
                        if (C35805b.m58707a((Activity) context, "android.permission.RECORD_AUDIO", 82, "", "")) {
                            c26250ui = new C26250ui();
                            c26250ui.cQx.cAd = 5;
                            c26250ui.cQx.talker = c7616ad.field_username;
                            c26250ui.cQx.context = context;
                            c26250ui.cQx.cQs = 4;
                            C4879a.xxA.mo10055m(c26250ui);
                        }
                        AppMethodBeat.m2505o(23216);
                        return;
                    case 2:
                        c7616ad = c7616ad;
                        context = context;
                        C4990ab.m7417i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a((Activity) context, "android.permission.CAMERA", 19, "", "")), C5046bo.dpG(), context);
                        if (C35805b.m58707a((Activity) context, "android.permission.CAMERA", 19, "", "")) {
                            C4990ab.m7417i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a((Activity) context, "android.permission.RECORD_AUDIO", 19, "", "")), C5046bo.dpG(), context);
                            if (C35805b.m58707a((Activity) context, "android.permission.RECORD_AUDIO", 19, "", "")) {
                                c26250ui = new C26250ui();
                                c26250ui.cQx.cAd = 5;
                                c26250ui.cQx.talker = c7616ad.field_username;
                                c26250ui.cQx.context = context;
                                c26250ui.cQx.cQs = 2;
                                C4879a.xxA.mo10055m(c26250ui);
                                break;
                            }
                        }
                        break;
                }
                AppMethodBeat.m2505o(23216);
            }
        };
        this.pki.cpD();
        AppMethodBeat.m2505o(23234);
    }

    /* renamed from: a */
    public final void mo17657a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j, String str2) {
        AppMethodBeat.m2504i(23235);
        C46634g c46634g = (C46634g) this.iFE.aqO("contact_profile_sns");
        if (!(c46634g == null || C21877n.qFy == null)) {
            c46634g.ajO(this.ldh.field_username);
            if (C21877n.qFC != null) {
                C21877n.qFC.mo8619a(this, 3);
            }
            this.iFE.notifyDataSetChanged();
            if (z3) {
                C4990ab.m7410d("MicroMsg.NewContactWidgetNormal", "bg Change!");
                if (C21877n.qFC != null) {
                    C21877n.qFC.mo8614WZ(this.ldh.field_username);
                }
            }
        }
        AppMethodBeat.m2505o(23235);
    }

    /* renamed from: a */
    public final void mo17656a(boolean z, String str, boolean z2, boolean z3, int i, long j, String str2) {
    }

    /* renamed from: cA */
    public final void mo8985cA(List list) {
        AppMethodBeat.m2504i(23236);
        if (list == null || list.isEmpty()) {
            C4990ab.m7410d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish hideStoryPreference");
            this.iFE.mo27715ce("contact_profile_story", true);
            AppMethodBeat.m2505o(23236);
            return;
        }
        C4990ab.m7410d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish showStoryPreference");
        this.iFE.mo27715ce("contact_profile_story", false);
        AppMethodBeat.m2505o(23236);
    }

    /* renamed from: a */
    static void m56950a(C15541f c15541f, Activity activity, String str, String str2) {
        AppMethodBeat.m2504i(23237);
        C4990ab.m7417i("MicroMsg.NewContactWidgetNormal", "[showInviterView] inviter:%s inviterDisplayName:%s", str, str2);
        KeyValuePreference keyValuePreference = (KeyValuePreference) c15541f.aqO("contact_info_invite_source");
        c15541f.mo27715ce("contact_info_invite_source", false);
        SpannableString spannableString = new SpannableString(C44089j.m79292b((Context) activity, activity.getResources().getString(C25738R.string.awu, new Object[]{str2})));
        spannableString.setSpan(new ForegroundColorSpan(activity.getResources().getColor(C25738R.color.f11795hi)), 0, str2.length(), 33);
        keyValuePreference.mo41839NT(2);
        keyValuePreference.yCj = false;
        keyValuePreference.setSummary((CharSequence) spannableString);
        keyValuePreference.getExtras().putString("inviter", str);
        activity.getIntent().putExtra("inviteer", str);
        AppMethodBeat.m2505o(23237);
    }

    /* renamed from: b */
    static String m56953b(C7577u c7577u, String str) {
        String str2 = null;
        AppMethodBeat.m2504i(23238);
        if (c7577u == null) {
            AppMethodBeat.m2505o(23238);
        } else {
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(str);
            if (aoO != null && ((int) aoO.ewQ) > 0) {
                str2 = aoO.field_conRemark;
            }
            if (C5046bo.isNullOrNil(str2)) {
                str2 = c7577u.mo16807mJ(str);
            }
            if (C5046bo.isNullOrNil(str2) && aoO != null) {
                str2 = aoO.mo16706Oi();
            }
            AppMethodBeat.m2505o(23238);
        }
        return str2;
    }
}
