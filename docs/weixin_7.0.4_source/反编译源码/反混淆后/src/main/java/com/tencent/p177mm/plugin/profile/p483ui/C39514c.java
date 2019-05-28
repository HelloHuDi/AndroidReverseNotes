package com.tencent.p177mm.plugin.profile.p483ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1827a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26428i;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.gdpr.C32791a;
import com.tencent.p177mm.model.gdpr.C32792b;
import com.tencent.p177mm.model.gdpr.C37918c;
import com.tencent.p177mm.modelsns.SnsAdClick;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17881i;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C16527d.C16528a;
import com.tencent.p177mm.p184aj.C16527d.C16529b;
import com.tencent.p177mm.p184aj.C16527d.C16529b.C16531d;
import com.tencent.p177mm.p184aj.C16527d.C16529b.C16533f;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C25764e;
import com.tencent.p177mm.p184aj.C25772n;
import com.tencent.p177mm.p184aj.C32237a;
import com.tencent.p177mm.p184aj.C37453h.C37454a;
import com.tencent.p177mm.p184aj.C41743i;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.C45147y;
import com.tencent.p177mm.p184aj.C46874g;
import com.tencent.p177mm.p184aj.C8927c;
import com.tencent.p177mm.p184aj.p185a.C25759h;
import com.tencent.p177mm.p184aj.p185a.C45143j;
import com.tencent.p177mm.p201az.C45177d;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C41980dg;
import com.tencent.p177mm.p230g.p231a.C9315dc;
import com.tencent.p177mm.p230g.p231a.C9430of;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.KeyValuePreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceSmallCategory;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C33345i;
import com.tencent.p177mm.plugin.base.model.C42781b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.profile.C39503b;
import com.tencent.p177mm.plugin.profile.p1287b.C28682d;
import com.tencent.p177mm.plugin.profile.p1287b.C39502c;
import com.tencent.p177mm.plugin.profile.p483ui.p1288b.C46914c;
import com.tencent.p177mm.plugin.profile.p483ui.p738a.C39508a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C46490h;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14917a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.preference.ButtonPreference;
import com.tencent.p177mm.protocal.protobuf.C7285uy;
import com.tencent.p177mm.protocal.protobuf.bbo;
import com.tencent.p177mm.protocal.protobuf.bxr;
import com.tencent.p177mm.protocal.protobuf.bxs;
import com.tencent.p177mm.protocal.protobuf.cfr;
import com.tencent.p177mm.protocal.protobuf.cfs;
import com.tencent.p177mm.protocal.protobuf.cwa;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.view.C31128d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.profile.ui.c */
public final class C39514c implements C1202f, C37454a, C25772n, C23233a {
    MMActivity crP;
    C15541f ehK;
    C7616ad ehM;
    private CheckBoxPreference ehV;
    private SharedPreferences ehZ;
    private boolean eif;
    private List<C16528a> fuX;
    private C16529b fuY;
    private boolean fvf;
    private String fvh;
    private int gwP;
    boolean isDeleteCancel;
    String mGZ;
    C16527d pkW;
    private boolean pli;
    private String pln;
    private boolean pmA;
    private boolean pmB;
    boolean pmC;
    private int pmD;
    private String pmE;
    private boolean pmF;
    C5653c pmG;
    private Bundle pmH;
    SnsAdClick pmI;
    private String pmJ;
    private C45143j pmx;
    private List<WxaEntryInfo> pmy;
    private C7285uy pmz;
    C44275p tipDialog;

    /* renamed from: com.tencent.mm.plugin.profile.ui.c$4 */
    class C36314 implements C32792b {
        C36314() {
        }

        /* renamed from: kL */
        public final void mo8219kL(int i) {
            AppMethodBeat.m2504i(23460);
            if (i == 0) {
                C39514c.this.caV();
            }
            AppMethodBeat.m2505o(23460);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.c$2 */
    class C128452 implements C5279d {

        /* renamed from: com.tencent.mm.plugin.profile.ui.c$2$1 */
        class C128461 implements OnClickListener {
            C128461() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(23457);
                C39514c c39514c = C39514c.this;
                String str = c39514c.ehM.field_username;
                C9638aw.m17190ZK();
                C7620bi Ra = C18628c.m29080XO().mo15247Ra(str);
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C45177d(str, Ra.field_msgSvrId));
                c39514c.isDeleteCancel = false;
                Context context = c39514c.crP;
                c39514c.crP.getString(C25738R.string.f9238tz);
                c39514c.tipDialog = C30379h.m48458b(context, c39514c.crP.getString(C25738R.string.f9260un), true, new C395139());
                C1829bf.m3741a(str, new C3950910());
                AppMethodBeat.m2505o(23457);
            }
        }

        C128452() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(23458);
            C39514c c39514c;
            switch (menuItem.getItemId()) {
                case 1:
                    c39514c = C39514c.this;
                    Intent intent = new Intent();
                    intent.putExtra("Select_Talker_Name", c39514c.ehM.field_username);
                    intent.putExtra("Select_block_List", c39514c.ehM.field_username);
                    intent.putExtra("Select_Send_Card", true);
                    intent.putExtra("Select_Conv_Type", 3);
                    intent.putExtra("mutil_select_is_ret", true);
                    C39503b.gkE.mo38899a(intent, c39514c.crP);
                    AppMethodBeat.m2505o(23458);
                    return;
                case 2:
                    C39514c.this.crP.getString(C25738R.string.bx1, new Object[]{C39514c.this.ehM.mo16707Oj()});
                    C30379h.m48466d(C39514c.this.crP, C39514c.this.crP.getString(C25738R.string.auc), "", C39514c.this.crP.getString(C25738R.string.aub), C39514c.this.crP.getString(C25738R.string.f9076or), new C128461(), null);
                    AppMethodBeat.m2505o(23458);
                    return;
                case 3:
                    C39514c.this.caX();
                    AppMethodBeat.m2505o(23458);
                    return;
                case 4:
                    C39514c c39514c2 = C39514c.this;
                    ((C46490h) C1720g.m3528K(C46490h.class)).mo41539a(c39514c2.pkW, c39514c2.crP, c39514c2.ehM, true, new C128473());
                    AppMethodBeat.m2505o(23458);
                    return;
                case 5:
                    c39514c = C39514c.this;
                    C4990ab.m7410d("MicroMsg.ContactWidgetBizInfo", "dealAddShortcut, username = " + c39514c.ehM.field_username);
                    C42781b.m75863aa(c39514c.crP, c39514c.ehM.field_username);
                    C5004al.m7442n(new C395198(), 1000);
                    break;
            }
            AppMethodBeat.m2505o(23458);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.c$3 */
    class C128473 implements Runnable {
        C128473() {
        }

        public final void run() {
            AppMethodBeat.m2504i(23459);
            C39514c.this.mo62476aV(4, null);
            if (C39514c.this.crP.getIntent().getIntExtra("Kdel_from", -1) == 1) {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                C25985d.m41467b(C39514c.this.crP, "shake", ".ui.ShakeReportUI", intent);
            }
            AppMethodBeat.m2505o(23459);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.c$17 */
    class C2148717 implements OnMenuItemClickListener {
        C2148717() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(23472);
            C39514c.m67524a(C39514c.this);
            AppMethodBeat.m2505o(23472);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.c$10 */
    class C3950910 implements C1827a {
        C3950910() {
        }

        /* renamed from: JU */
        public final boolean mo5405JU() {
            return C39514c.this.isDeleteCancel;
        }

        /* renamed from: JV */
        public final void mo5406JV() {
            AppMethodBeat.m2504i(23465);
            if (C39514c.this.tipDialog != null) {
                C39514c.this.tipDialog.dismiss();
                C39514c.this.tipDialog = null;
            }
            AppMethodBeat.m2505o(23465);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.c$13 */
    class C3951113 implements OnClickListener {
        C3951113() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23468);
            C39514c.this.mo62479jN(false);
            AppMethodBeat.m2505o(23468);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.c$9 */
    class C395139 implements OnCancelListener {
        C395139() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            C39514c.this.isDeleteCancel = true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.c$18 */
    class C3951518 implements OnMenuItemClickListener {
        C3951518() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(23473);
            C39514c.m67524a(C39514c.this);
            AppMethodBeat.m2505o(23473);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.c$19 */
    class C3951619 implements C36073c {
        C3951619() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(23474);
            if (C39514c.this.pkW != null && C39514c.this.pkW.adP()) {
                c44273l.mo70072hi(1, C25738R.string.azw);
                c44273l.mo70072hi(3, C25738R.string.a9n);
                c44273l.mo70072hi(4, C25738R.string.auz);
                c44273l.mo70072hi(5, C25738R.string.atv);
                AppMethodBeat.m2505o(23474);
            } else if (C39514c.this.pkW == null || !C39514c.this.pkW.adQ()) {
                c44273l.mo70072hi(1, C25738R.string.azw);
                c44273l.mo70072hi(2, C25738R.string.aub);
                if (!C1855t.m3931nQ(C39514c.this.ehM.field_username)) {
                    c44273l.mo70072hi(3, C25738R.string.a9n);
                    c44273l.mo70072hi(4, C25738R.string.auz);
                }
                c44273l.mo70072hi(5, C25738R.string.atv);
                AppMethodBeat.m2505o(23474);
            } else {
                c44273l.mo70072hi(5, C25738R.string.atv);
                AppMethodBeat.m2505o(23474);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.c$6 */
    class C395186 implements C14917a {
        C395186() {
        }

        /* JADX WARNING: Missing block: B:62:0x021f, code skipped:
            if (r3 == false) goto L_0x011b;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo5739a(boolean z, boolean z2, String str, String str2) {
            AppMethodBeat.m2504i(23462);
            if (z) {
                C16527d qX;
                C30379h.m48465bQ(C39514c.this.crP, C39514c.this.crP.getString(C25738R.string.au5));
                C39514c.this.ehK.mo27715ce("contact_info_time_expired", true);
                C7616ad c7616ad = C39514c.this.ehM;
                if (c7616ad == null || C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.ContactWidgetBizInfo", "respUsername == " + str + ", contact = " + c7616ad);
                } else {
                    if (C1855t.m3911mX(c7616ad.field_username)) {
                        String nullAsNil = C5046bo.nullAsNil(c7616ad.field_username);
                        qX = C17903f.m28104qX(nullAsNil);
                        if (qX != null) {
                            qX.field_username = str;
                        }
                        C41747z.aeR().delete(nullAsNil);
                        c7616ad.mo14709iH(nullAsNil);
                    } else {
                        qX = null;
                    }
                    c7616ad.setUsername(str);
                    if (((int) c7616ad.ewQ) == 0) {
                        C9638aw.m17190ZK();
                        C18628c.m29078XM().mo15708aa(c7616ad);
                    }
                    if (((int) c7616ad.ewQ) <= 0) {
                        C4990ab.m7412e("MicroMsg.ContactWidgetBizInfo", "addContact : insert contact failed");
                    } else {
                        C1855t.m3960q(c7616ad);
                        C9638aw.m17190ZK();
                        c7616ad = C18628c.m29078XM().aoO(c7616ad.field_username);
                        if (qX != null) {
                            C41747z.aeR().mo43724d(qX);
                        } else {
                            C16527d qX2 = C17903f.m28104qX(c7616ad.field_username);
                            boolean z3;
                            if (c7616ad.dsf() && C32237a.adG()) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (qX2 == null || (qX2.adJ() && !z3)) {
                                C4990ab.m7410d("MicroMsg.ContactWidgetBizInfo", "shouldUpdate");
                                C26417a.flu.mo20967ai(c7616ad.field_username, "");
                                C41730b.m73506pY(c7616ad.field_username);
                            } else if (c7616ad.dsi() && !z3) {
                                C4990ab.m7411d("MicroMsg.ContactWidgetBizInfo", "update contact, last check time=%d", Integer.valueOf(c7616ad.duj));
                                C26417a.flu.mo20967ai(c7616ad.field_username, "");
                                C41730b.m73506pY(c7616ad.field_username);
                            }
                        }
                    }
                }
                C39514c.this.pmC = true;
                if (C39514c.this.pmI != null) {
                    C9430of c9430of = new C9430of();
                    C39514c.this.pmI.fPZ = 4;
                    c9430of.cKy.cKz = C39514c.this.pmI;
                    C4879a.xxA.mo10055m(c9430of);
                }
                qX = C41747z.aeR().mo43729qP(C39514c.this.ehM.field_username);
                qX.field_status = 1;
                if (!C5046bo.isNullOrNil(qX.field_extInfo) || C5046bo.isNullOrNil(qX.field_username) || C39514c.this.pkW == null || !qX.field_username.equals(C5046bo.nullAsNil(C39514c.this.pkW.field_username))) {
                    C41747z.aeR().mo43726e(qX);
                } else {
                    C41747z.aeR().mo43726e(C39514c.this.pkW);
                }
                boolean booleanExtra = C39514c.this.crP.getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
                boolean booleanExtra2 = C39514c.this.crP.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
                Intent intent;
                if (qX.adP()) {
                    intent = new Intent();
                    intent.putExtra("enterprise_biz_name", C39514c.this.ehM.field_username);
                    intent.putExtra("enterprise_biz_display_name", C1854s.m3866mJ(C39514c.this.ehM.field_username));
                    intent.putExtra("enterprise_from_scene", 7);
                    intent.addFlags(67108864);
                    C25985d.m41473f(C39514c.this.crP, ".ui.conversation.EnterpriseConversationUI", intent);
                } else {
                    intent = new Intent();
                    intent.putExtra("Chat_User", C39514c.this.ehM.field_username);
                    intent.putExtra("key_has_add_contact", true);
                    intent.putExtra("finish_direct", true);
                    if (booleanExtra2) {
                        intent.addFlags(268435456);
                    }
                    C39503b.gkE.mo38915d(intent, C39514c.this.crP);
                    if (!booleanExtra) {
                    }
                }
                C39514c.this.crP.finish();
                C39514c.this.mo62476aV(3, null);
            }
            AppMethodBeat.m2505o(23462);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.c$8 */
    class C395198 implements Runnable {
        C395198() {
        }

        public final void run() {
            AppMethodBeat.m2504i(23464);
            if (C39514c.this.crP.isFinishing()) {
                AppMethodBeat.m2505o(23464);
                return;
            }
            C42781b.m75859Z(C39514c.this.crP, C39514c.this.ehM.field_username);
            C42781b.m75871x(C39514c.this.crP);
            AppMethodBeat.m2505o(23464);
        }
    }

    private C39514c(MMActivity mMActivity) {
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

    public C39514c(MMActivity mMActivity, String str, C7285uy c7285uy) {
        this(mMActivity);
        this.pln = str;
        this.pmz = c7285uy;
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(23475);
        Intent intent;
        String adX;
        if (str == null) {
            AppMethodBeat.m2505o(23475);
            return false;
        } else if (str.equals("contact_info_verifyuser_weibo")) {
            new C39508a(this.crP).mo62470fF(this.ehM.dug, this.ehM.field_username);
            AppMethodBeat.m2505o(23475);
            return true;
        } else if ("contact_info_biz_go_chatting".endsWith(str)) {
            if (this.pmI != null) {
                C9430of c9430of = new C9430of();
                this.pmI.fPZ = 5;
                c9430of.cKy.cKz = this.pmI;
                C4879a.xxA.mo10055m(c9430of);
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
                    C39503b.gkE.mo38915d(intent, this.crP);
                }
            } else {
                intent = new Intent();
                if (this.pkW.adR()) {
                    adX = this.pkW.adX();
                    if (C5046bo.isNullOrNil(adX)) {
                        C4990ab.m7420w("MicroMsg.ContactWidgetBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
                        AppMethodBeat.m2505o(23475);
                        return false;
                    }
                    intent.putExtra("enterprise_biz_name", adX);
                    intent.putExtra("enterprise_biz_display_name", C1854s.m3866mJ(adX));
                } else {
                    intent.putExtra("enterprise_biz_name", this.ehM.field_username);
                    intent.putExtra("enterprise_biz_display_name", C1854s.m3866mJ(this.ehM.field_username));
                }
                intent.addFlags(67108864);
                C25985d.m41473f(this.crP, ".ui.conversation.EnterpriseConversationUI", intent);
                this.crP.finish();
            }
            mo62476aV(5, null);
            AppMethodBeat.m2505o(23475);
            return true;
        } else if ("contact_info_biz_add".endsWith(str)) {
            if (C37918c.aaZ()) {
                C37918c.m64041a(this.crP, C32791a.BIZ, this.ehM.field_username, new C36314());
            } else {
                caV();
            }
            if (this.pmD != 0) {
                C7060h.pYm.mo8381e(11263, Integer.valueOf(this.pmD), this.ehM.field_username);
            }
            AppMethodBeat.m2505o(23475);
            return true;
        } else if ("contact_info_biz_read_msg_online".endsWith(str)) {
            AppMethodBeat.m2505o(23475);
            return true;
        } else if ("contact_info_stick_biz".equals(str)) {
            if (((CheckBoxPreference) this.ehK.aqO("contact_info_stick_biz")).isChecked()) {
                C7060h.pYm.mo8381e(13307, this.ehM.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0));
                C26428i.m42084mn(this.ehM.field_username);
            } else {
                C1855t.m3969x(this.ehM.field_username, true);
                C7060h.pYm.mo8381e(13307, this.ehM.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
            }
            AppMethodBeat.m2505o(23475);
            return true;
        } else {
            String str2;
            String str3;
            if (!(!"contact_info_guarantee_info".equals(str) || this.fuY.aei() == null || C5046bo.isNullOrNil(this.fuY.aei().fvZ))) {
                intent = new Intent();
                intent.putExtra("rawUrl", this.fuY.aei().fvZ);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                intent.putExtra("geta8key_scene", 3);
                C25985d.m41467b(this.crP, "webview", ".ui.tools.WebViewUI", intent);
            }
            if (str.startsWith("contact_info_bizinfo_external#")) {
                int i = C5046bo.getInt(str.replace("contact_info_bizinfo_external#", ""), -1);
                if (i >= 0 && i < this.fuX.size()) {
                    C16528a c16528a = (C16528a) this.fuX.get(i);
                    str2 = c16528a.url;
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", str2);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("vertical_scroll", true);
                    intent2.putExtra("geta8key_scene", 3);
                    intent2.putExtra("KPublisherId", "brand_profile");
                    intent2.putExtra("prePublishId", "brand_profile");
                    if ((this.pmH != null && (this.gwP == 39 || this.gwP == 56 || this.gwP == 35)) || this.gwP == 87 || this.gwP == 89 || this.gwP == 85 || this.gwP == 88) {
                        C4990ab.m7410d("MicroMsg.ContactWidgetBizInfo", "from biz search.");
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("KFromBizSearch", true);
                        bundle.putBundle("KBizSearchExtArgs", this.pmH);
                        intent2.putExtra("jsapiargs", bundle);
                        int i2 = C7486a.m12942jh(this.ehM.field_type) ? 7 : 6;
                        int identifier = this.crP.getResources().getIdentifier(c16528a.fvb, "string", this.crP.getPackageName());
                        str3 = c16528a.title;
                        if (identifier > 0) {
                            str3 = this.crP.getString(identifier);
                        }
                        mo62476aV(i2, str3);
                    }
                    C25985d.m41467b(this.crP, "webview", ".ui.tools.WebViewUI", intent2);
                    AppMethodBeat.m2505o(23475);
                    return true;
                }
            }
            C16527d c16527d;
            Intent intent3;
            if ("contact_info_subscribe_bizinfo".endsWith(str) || "contact_info_show_brand".endsWith(str) || "contact_info_locate".endsWith(str)) {
                final C16527d c16527d2 = this.pkW;
                if (c16527d2 == null) {
                    AppMethodBeat.m2505o(23475);
                    return true;
                }
                boolean z;
                if ("contact_info_subscribe_bizinfo".endsWith(str)) {
                    if (!c16527d2.adO()) {
                        if (c16527d2.adH()) {
                            c16527d2.field_brandFlag |= 1;
                            if (this.fuY == null && c16527d2 != null) {
                                this.fuY = c16527d2.mo30481cJ(false);
                            }
                            if (this.fuY != null && this.fuY.aeb() && C25985d.afj("brandservice")) {
                                this.ehK.mo27715ce("contact_info_template_recv", false);
                            } else {
                                this.ehK.mo27715ce("contact_info_template_recv", true);
                            }
                        } else {
                            c16527d2.field_brandFlag &= -2;
                            this.ehK.mo27715ce("contact_info_template_recv", true);
                        }
                        C7060h c7060h = C7060h.pYm;
                        Object[] objArr = new Object[4];
                        objArr[0] = c16527d2.field_username;
                        objArr[1] = Integer.valueOf(1);
                        objArr[2] = Integer.valueOf(c16527d2.adH() ? 3 : 4);
                        objArr[3] = Integer.valueOf(0);
                        c7060h.mo8381e(13307, objArr);
                    } else if (c16527d2 != null) {
                        if (c16527d2.adR()) {
                            C9638aw.m17182Rg().mo14539a(1363, (C1202f) this);
                            final C1207m c39502c = new C39502c(c16527d2.field_username, ((CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo")).isChecked() ? 0 : 4);
                            C9638aw.m17182Rg().mo14541a(c39502c, 0);
                            Context context = this.crP;
                            this.crP.getString(C25738R.string.f9238tz);
                            this.tipDialog = C30379h.m48458b(context, this.crP.getString(C25738R.string.f9260un), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.m2504i(23470);
                                    C9638aw.m17182Rg().mo14547c(c39502c);
                                    C9638aw.m17182Rg().mo14546b(1363, C39514c.this);
                                    AppMethodBeat.m2505o(23470);
                                }
                            });
                        } else if (c16527d2.adP()) {
                            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo");
                            C41747z.afa();
                            adX = c16527d2.field_username;
                            if (checkBoxPreference.isChecked()) {
                                z = false;
                            } else {
                                z = true;
                            }
                            final C45147y a = C8927c.m16086a(adX, z, this);
                            Context context2 = this.crP;
                            this.crP.getString(C25738R.string.f9238tz);
                            this.tipDialog = C30379h.m48458b(context2, this.crP.getString(C25738R.string.f9260un), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.m2504i(23471);
                                    C41747z.afa();
                                    C8927c.m16087a(a);
                                    AppMethodBeat.m2505o(23471);
                                }
                            });
                        }
                    }
                } else if ("contact_info_show_brand".endsWith(str)) {
                    if ((c16527d2.field_brandFlag & 2) == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        c16527d2.field_brandFlag |= 2;
                    } else {
                        c16527d2.field_brandFlag &= -3;
                    }
                } else if ("contact_info_locate".endsWith(str)) {
                    if (c16527d2.adI()) {
                        c16527d2.field_brandFlag &= -5;
                    } else {
                        this.pmG = C30379h.m48440a(this.crP, this.crP.getString(C25738R.string.ak4, new Object[]{this.ehM.mo16707Oj()}), this.crP.getString(C25738R.string.f9238tz), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(23456);
                                c16527d2.field_hadAlert = 1;
                                c16527d2.field_brandFlag |= 4;
                                C39514c.this.mo62475a(c16527d2, true);
                                AppMethodBeat.m2505o(23456);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(23467);
                                c16527d2.field_hadAlert = 1;
                                C39514c.this.mo62475a(c16527d2, false);
                                AppMethodBeat.m2505o(23467);
                            }
                        });
                    }
                }
                if (!(c16527d2.adR() || c16527d2.adP())) {
                    mo62475a(c16527d2, false);
                }
                AppMethodBeat.m2505o(23475);
                return true;
            } else if ("contact_info_verifyuser".endsWith(str)) {
                c16527d = this.pkW;
                if (c16527d == null) {
                    AppMethodBeat.m2505o(23475);
                    return true;
                }
                C16529b cJ = c16527d.mo30481cJ(false);
                if (cJ == null) {
                    AppMethodBeat.m2505o(23475);
                    return true;
                }
                str3 = null;
                if (cJ.aek() != null && !C5046bo.isNullOrNil(cJ.aek().fvU)) {
                    str3 = cJ.aek().fvU;
                } else if (!(cJ.ael() == null || C5046bo.isNullOrNil(cJ.ael().fwc))) {
                    str3 = cJ.ael().fwc;
                }
                if (!C5046bo.isNullOrNil(str3)) {
                    intent3 = new Intent();
                    intent3.putExtra("rawUrl", str3);
                    intent3.putExtra("useJs", true);
                    intent3.putExtra("vertical_scroll", true);
                    intent3.putExtra("geta8key_scene", 3);
                    C25985d.m41467b(this.crP, "webview", ".ui.tools.WebViewUI", intent3);
                }
                AppMethodBeat.m2505o(23475);
                return true;
            } else if ("contact_info_trademark".endsWith(str)) {
                c16527d = this.pkW;
                if (c16527d == null) {
                    AppMethodBeat.m2505o(23475);
                    return true;
                }
                if (!(c16527d.mo30481cJ(false) == null || C5046bo.isNullOrNil(c16527d.mo30481cJ(false).aed()))) {
                    intent3 = new Intent();
                    intent3.putExtra("rawUrl", c16527d.mo30481cJ(false).aed());
                    intent3.putExtra("useJs", true);
                    intent3.putExtra("vertical_scroll", true);
                    intent3.putExtra("geta8key_scene", 3);
                    C25985d.m41467b(this.crP, "webview", ".ui.tools.WebViewUI", intent3);
                }
                AppMethodBeat.m2505o(23475);
                return true;
            } else {
                if ("contact_is_mute".endsWith(str)) {
                    this.eif = !this.eif;
                    if (this.eif) {
                        C1855t.m3958o(this.ehM);
                    } else {
                        C1855t.m3959p(this.ehM);
                    }
                    m67526jO(this.eif);
                }
                if ("enterprise_contact_info_enter".equals(str)) {
                    if (this.crP == null) {
                        C4990ab.m7412e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise context is null");
                    } else if (this.pkW == null) {
                        C4990ab.m7412e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise bizInfo is null");
                    } else {
                        intent = new Intent();
                        intent.putExtra("enterprise_biz_name", this.pkW.field_username);
                        intent.addFlags(67108864);
                        C25985d.m41467b(this.crP, "brandservice", ".ui.EnterpriseBizContactListUI", intent);
                    }
                }
                if ("contact_info_biz_disable".equals(str)) {
                    C30379h.m48466d(this.crP, this.crP.getString(C25738R.string.bdm), "", this.crP.getString(C25738R.string.bdl), this.crP.getString(C25738R.string.f9076or), new C3951113(), null);
                }
                if ("contact_info_biz_enable".equals(str)) {
                    mo62479jN(true);
                }
                if ("contact_info_template_recv".equals(str)) {
                    intent = new Intent();
                    intent.putExtra("enterprise_biz_name", this.pkW.field_username);
                    C25985d.m41467b(this.crP, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", intent);
                }
                if ("contact_info_service_phone".equals(str)) {
                    Preference aqO = this.ehK.aqO("contact_info_service_phone");
                    if (!(aqO == null || aqO.getSummary() == null || C5046bo.isNullOrNil(aqO.getSummary().toString()))) {
                        str2 = aqO.getSummary().toString();
                        C30379h.m48453a(this.crP, true, str2, "", this.crP.getString(C25738R.string.avl), this.crP.getString(C25738R.string.f9076or), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(23463);
                                Intent intent = new Intent("android.intent.action.DIAL");
                                intent.setFlags(268435456);
                                intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str2).toString()));
                                if (C5046bo.m7572k(C39514c.this.crP, intent)) {
                                    C39514c.this.crP.startActivity(intent);
                                }
                                AppMethodBeat.m2505o(23463);
                            }
                        }, null);
                    }
                }
                if ("contact_info_expose_btn".equals(str)) {
                    caX();
                }
                if (str.equals("biz_placed_to_the_top")) {
                    C4990ab.m7410d("MicroMsg.ContactWidgetBizInfo", "changePlacedTop");
                    if (this.ehZ == null) {
                        this.ehZ = this.crP.getSharedPreferences(this.crP.getPackageName() + "_preferences", 0);
                    }
                    if (this.ehM != null) {
                        if (this.ehM.mo16702Oe()) {
                            C4990ab.m7411d("MicroMsg.ContactWidgetBizInfo", "unSetPlaceTop:%s", this.ehM.field_username);
                            C1855t.m3969x(this.ehM.field_username, true);
                            this.ehZ.edit().putBoolean("biz_placed_to_the_top", false).commit();
                        } else {
                            C26428i.m42084mn(this.ehM.field_username);
                            C4990ab.m7411d("MicroMsg.ContactWidgetBizInfo", "setPlaceTop:%s", this.ehM.field_username);
                            this.ehZ.edit().putBoolean("biz_placed_to_the_top", true).commit();
                        }
                    }
                }
                AppMethodBeat.m2505o(23475);
                return true;
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: jN */
    public final void mo62479jN(boolean z) {
        AppMethodBeat.m2504i(23476);
        final C1207m c28682d = new C28682d(this.pkW.field_username, !z);
        C9638aw.m17182Rg().mo14539a(1394, (C1202f) this);
        C9638aw.m17182Rg().mo14541a(c28682d, 0);
        Context context = this.crP;
        this.crP.getString(C25738R.string.f9238tz);
        this.tipDialog = C30379h.m48458b(context, this.crP.getString(C25738R.string.f9260un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(23469);
                C9638aw.m17182Rg().mo14547c(c28682d);
                C9638aw.m17182Rg().mo14546b(1394, C39514c.this);
                AppMethodBeat.m2505o(23469);
            }
        });
        AppMethodBeat.m2505o(23476);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo62475a(C16527d c16527d, boolean z) {
        AppMethodBeat.m2504i(23477);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("contact_info_locate");
        bbo bbo = new bbo();
        bbo.gvb = c16527d.field_brandFlag;
        bbo.jBB = this.ehM.field_username;
        if (C39514c.m67520Bd(this.gwP)) {
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
            caT();
        }
        AppMethodBeat.m2505o(23477);
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        boolean z2;
        AppMethodBeat.m2504i(23478);
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
        this.pmD = this.crP.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.pmI = (SnsAdClick) this.crP.getIntent().getParcelableExtra("KSnsAdTag");
        this.pmH = this.crP.getIntent().getBundleExtra("Contact_Ext_Args");
        this.pmJ = this.crP.getIntent().getStringExtra("key_add_contact_report_info");
        caT();
        String stringExtra = this.crP.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.crP.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
            C30379h.m48443a(this.crP, stringExtra, "", this.crP.getString(C25738R.string.f9187s6), null);
        }
        if (c7616ad != null) {
            C41747z.afd().mo52930qB(c7616ad.field_username);
            if (C17903f.m28107ra(c7616ad.field_username)) {
                stringExtra = c7616ad.field_username;
                if (C17903f.m28103kq(stringExtra)) {
                    C41747z.aeZ();
                    C25759h.m40920a(stringExtra, (C25772n) this);
                    stringExtra = C17903f.m28104qX(stringExtra).adX();
                    if (stringExtra != null) {
                        C41747z.afd().mo52930qB(stringExtra);
                    }
                } else if (C17903f.m28109rc(stringExtra)) {
                    C41747z.afa();
                    C8927c.m16090a(stringExtra, (C1202f) this);
                    C41747z.aeR();
                    stringExtra = C25764e.m40952qT(stringExtra);
                    if (stringExtra != null) {
                        C41747z.afd().mo52930qB(stringExtra);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(23478);
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
        C16527d c16527d;
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
        AppMethodBeat.m2504i(23479);
        biV();
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8477s);
        if (this.pmC) {
            this.ehK.mo27715ce("contact_info_time_expired", true);
        }
        C16527d qX = C17903f.m28104qX(this.ehM.field_username);
        this.fuX = null;
        this.fuY = null;
        this.pmy = null;
        if ((qX == null || qX.mo30481cJ(false) == null) && this.pmz != null) {
            qX = new C16527d();
            qX.field_username = this.ehM.field_username;
            qX.field_brandFlag = this.pmz.gvb;
            qX.field_brandIconURL = this.pmz.gve;
            qX.field_brandInfo = this.pmz.gvd;
            qX.field_extInfo = this.pmz.gvc;
            c16527d = qX;
        } else {
            c16527d = qX;
        }
        if (c16527d != null && c16527d.field_brandInfo == null && c16527d.field_extInfo == null && this.pmz != null) {
            c16527d.field_username = this.ehM.field_username;
            c16527d.field_brandFlag = this.pmz.gvb;
            c16527d.field_brandIconURL = this.pmz.gve;
            c16527d.field_brandInfo = this.pmz.gvd;
            c16527d.field_extInfo = this.pmz.gvc;
        }
        BizInfoHeaderPreference bizInfoHeaderPreference = (BizInfoHeaderPreference) this.ehK.aqO("contact_info_header_bizinfo");
        if (bizInfoHeaderPreference == null || C5046bo.isNullOrNil(this.ehM.field_username)) {
            C4990ab.m7420w("MicroMsg.ContactWidgetBizInfo", "head pref is null");
            this.ehK.mo27715ce("contact_info_header_bizinfo", true);
        } else {
            bizInfoHeaderPreference.mo55303a(this.ehM, this.pln, c16527d);
        }
        this.ehK.mo27715ce("biz_placed_to_the_top", true);
        this.ehK.mo27715ce("contact_info_biz_enable", true);
        this.ehK.mo27715ce("contact_info_biz_disable", true);
        this.ehK.mo27715ce("contact_info_stick_biz", true);
        if (c16527d != null) {
            if (c16527d.adQ()) {
                this.ehK.mo27715ce("contact_info_biz_add", true);
                this.ehK.mo27715ce("contact_info_expose_btn", true);
                this.ehK.mo27715ce("contact_is_mute", false);
                this.eif = this.ehM.mo16673DX();
                if (c16527d.adR()) {
                    this.ehK.mo27715ce("contact_info_biz_go_chatting", true);
                    this.ehK.mo27715ce("contact_info_stick_biz", !C7486a.m12942jh(this.ehM.field_type));
                    checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_stick_biz");
                    checkBoxPreference.uOT = this.ehM.mo16702Oe();
                    checkBoxPreference.setTitle((int) C25738R.string.bdj);
                    caY();
                } else {
                    this.ehK.mo27715ce("contact_info_subscribe_bizinfo", true);
                    this.ehK.mo27715ce("contact_info_biz_go_chatting", true);
                    if (c16527d.adH()) {
                        this.ehK.mo27715ce("contact_info_biz_enable", true);
                        this.ehK.mo27715ce("contact_info_biz_disable", false);
                        this.ehK.aqO("contact_info_biz_disable").setTitle((int) C25738R.string.bdl);
                        this.ehK.mo27715ce("contact_is_mute", false);
                        this.ehK.mo27715ce("biz_placed_to_the_top", false);
                        this.ehV = (CheckBoxPreference) this.ehK.aqO("biz_placed_to_the_top");
                        this.ehV.setTitle((int) C25738R.string.be1);
                        caY();
                        if (c16527d.adS()) {
                            this.ehK.mo27715ce("contact_info_locate", true);
                        }
                    } else {
                        this.ehK.mo27715ce("contact_info_biz_enable", false);
                        this.ehK.mo27715ce("contact_info_biz_disable", true);
                        ((ButtonPreference) this.ehK.aqO("contact_info_biz_enable")).mo41835ed(this.crP.getResources().getString(C25738R.string.bdn), this.crP.getResources().getColor(C25738R.color.f11795hi));
                        this.ehK.mo27715ce("contact_is_mute", true);
                        this.ehK.mo27715ce("biz_placed_to_the_top", true);
                        this.ehK.mo27715ce("contact_info_locate", true);
                    }
                }
                m67526jO(this.eif);
            } else if (c16527d.adP()) {
                this.ehK.mo27715ce("contact_info_locate", true);
                this.ehK.mo27715ce("contact_info_subscribe_bizinfo", false);
                this.ehK.mo27715ce("enterprise_contact_info_enter", false);
                ((ButtonPreference) this.ehK.aqO("contact_info_biz_go_chatting")).mo41835ed(this.crP.getResources().getString(C25738R.string.bdo), this.crP.getResources().getColor(C25738R.color.f11795hi));
                this.ehK.mo27715ce("contact_info_stick_biz", !C7486a.m12942jh(this.ehM.field_type));
                checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_stick_biz");
                checkBoxPreference.uOT = this.ehM.mo16702Oe();
                checkBoxPreference.setTitle((int) C25738R.string.bdr);
                caY();
                this.ehK.mo27715ce("contact_is_mute", true);
                this.eif = this.ehM.mo16673DX();
                m67526jO(this.eif);
                this.ehK.aqO("contact_is_mute").setSummary((int) C25738R.string.avp);
            } else {
                C15541f c15541f = this.ehK;
                String str3 = "contact_info_stick_biz";
                z = C1855t.m3943nl(this.ehM.field_username) || !C7486a.m12942jh(this.ehM.field_type);
                c15541f.mo27715ce(str3, z);
                ((CheckBoxPreference) this.ehK.aqO("contact_info_stick_biz")).uOT = this.ehM.mo16702Oe();
                this.ehK.mo27715ce("contact_is_mute", true);
                this.eif = false;
            }
            this.pkW = c16527d;
            this.fuX = c16527d.adY();
            this.fuY = c16527d.mo30481cJ(false);
            this.pmy = this.fuY.getWxaEntryInfoList();
            if (this.fuY.adZ()) {
                this.ehK.aqO("near_field_service").setSummary((int) C25738R.string.g0r);
            } else {
                this.ehK.mo27715ce("near_field_service", true);
            }
            if (this.fuY.aef() != null) {
                this.pmB = true;
                if (C39514c.m67521UQ(this.fuY.aef())) {
                    this.pmA = true;
                    if (!C7486a.m12942jh(this.ehM.field_type)) {
                        C4990ab.m7421w("MicroMsg.ContactWidgetBizInfo", "expireTime not null, and %s is not my contact", this.ehM.field_username);
                        caU();
                        if (C1855t.m3921nG(this.ehM.field_username) || C1855t.m3931nQ(this.ehM.field_username)) {
                            caU();
                        }
                    }
                }
                this.ehK.mo27715ce("contact_info_time_expired", true);
                caU();
            } else {
                this.ehK.mo27715ce("contact_info_time_expired", true);
            }
            if (this.fuY.aec() != null && this.fuY.aec().length() > 0) {
                this.fvh = this.fuY.aec();
            }
            this.fvf = this.fuY.aea();
            if (C5046bo.isNullOrNil(this.fuY.aep())) {
                this.ehK.mo27715ce("contact_info_service_phone", true);
            } else {
                this.ehK.mo27715ce("contact_info_service_phone", false);
                aqO = this.ehK.aqO("contact_info_service_phone");
                if (aqO != null) {
                    aqO.setSummary(this.fuY.aep());
                    aqO.ksd = this.crP.getResources().getColor(C25738R.color.f12123t7);
                }
            }
        } else {
            this.ehK.mo27715ce("contact_info_time_expired", true);
            C4990ab.m7412e("MicroMsg.ContactWidgetBizInfo", "get biz info from storage, but return null");
        }
        if (C5046bo.isNullOrNil(this.ehM.signature)) {
            C4990ab.m7420w("MicroMsg.ContactWidgetBizInfo", "has not desc info");
            this.ehK.mo27715ce("contact_info_user_desc", true);
            if (!this.pmA) {
                this.ehK.mo27715ce("contact_info_time_expired", true);
            }
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_user_desc");
            if (keyValuePreference != null) {
                if (C5046bo.nullAsNil(this.ehM.signature).trim().length() <= 0) {
                    this.ehK.mo27715ce("contact_info_user_desc", true);
                } else {
                    keyValuePreference.yCj = false;
                    keyValuePreference.ylA = this.crP.getString(C25738R.string.aww);
                    keyValuePreference.setSummary((CharSequence) C44089j.m79292b(this.crP, this.ehM.signature));
                    keyValuePreference.mo41844qi(false);
                    if (C26417a.flw != null) {
                        i = C4977b.m7374i(C26417a.flw.mo37872ky(this.ehM.field_verifyFlag), 2.0f);
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
                    C4990ab.m7417i(str, str2, objArr);
                    if (i != null) {
                        bitmapDrawable = new BitmapDrawable(this.crP.getResources(), i);
                    } else {
                        bitmapDrawable = null;
                    }
                    keyValuePreference.yCr = bitmapDrawable;
                    keyValuePreference.yCp = 8;
                    keyValuePreference.mo39406NW(8);
                }
            }
        }
        if (this.fuY != null && this.fuY.aek() != null && !C5046bo.isNullOrNil(this.fuY.aek().fvS)) {
            C16531d aek = this.fuY.aek();
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_verifyuser");
            if (keyValuePreference != null) {
                Bitmap i2;
                keyValuePreference.yCj = false;
                if (C5046bo.isNullOrNil(aek.fvT)) {
                    keyValuePreference.ylA = m67519Bc(aek.fvR);
                } else {
                    keyValuePreference.ylA = aek.fvT;
                }
                if (C26417a.flw != null) {
                    i2 = C4977b.m7374i(C26417a.flw.mo37872ky(this.ehM.field_verifyFlag), 2.0f);
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
                C4990ab.m7417i(str2, str4, objArr2);
                keyValuePreference.yCr = bitmapDrawable;
                if (aek.fvS != null) {
                    str2 = aek.fvV;
                    CharSequence b = C44089j.m79292b(this.crP, aek.fvS.trim());
                    if (C5046bo.isNullOrNil(str2)) {
                        charSequence = b;
                    } else {
                        try {
                            charSequence = new SpannableString(str2 + " " + b);
                            try {
                                charSequence.setSpan(new ForegroundColorSpan(-36352), 0, str2.length(), 17);
                            } catch (IndexOutOfBoundsException e2) {
                                e = e2;
                                C4990ab.m7413e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", e.getMessage());
                                keyValuePreference.setSummary(charSequence);
                                if (this.fuY != null) {
                                }
                                C4990ab.m7420w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
                                this.ehK.mo27715ce("contact_info_trademark", true);
                                if (this.fuY != null) {
                                }
                                this.ehK.mo27715ce("contact_info_privilege", true);
                                indexOf = this.ehK.indexOf("contact_info_category2");
                                if (indexOf >= 0) {
                                }
                                C4990ab.m7410d("MicroMsg.ContactWidgetBizInfo", "pos no more");
                                if (!this.pmA) {
                                }
                                this.ehK.mo27715ce("contact_info_verifyuser_weibo", true);
                                if (this.fuY != null) {
                                }
                                this.ehK.mo27715ce("contact_info_reputation", true);
                                this.ehK.mo27715ce("contact_info_guarantee_info", true);
                                this.ehK.mo27715ce("contact_info_scope_of_business", true);
                                if (this.pmy != null) {
                                }
                                this.ehK.mo27715ce("contact_info_bindwxainfo", true);
                                m67522UR(this.crP.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
                                C4990ab.m7411d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", Boolean.valueOf(this.crP.getIntent().getBooleanExtra("KIsHardDevice", false)));
                                if (this.crP.getIntent() == null) {
                                }
                                if (C7486a.m12942jh(this.ehM.field_type)) {
                                }
                            }
                        } catch (IndexOutOfBoundsException e3) {
                            e = e3;
                            charSequence = b;
                            C4990ab.m7413e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", e.getMessage());
                            keyValuePreference.setSummary(charSequence);
                            if (this.fuY != null) {
                            }
                            C4990ab.m7420w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
                            this.ehK.mo27715ce("contact_info_trademark", true);
                            if (this.fuY != null) {
                            }
                            this.ehK.mo27715ce("contact_info_privilege", true);
                            indexOf = this.ehK.indexOf("contact_info_category2");
                            if (indexOf >= 0) {
                            }
                            C4990ab.m7410d("MicroMsg.ContactWidgetBizInfo", "pos no more");
                            if (this.pmA) {
                            }
                            this.ehK.mo27715ce("contact_info_verifyuser_weibo", true);
                            if (this.fuY != null) {
                            }
                            this.ehK.mo27715ce("contact_info_reputation", true);
                            this.ehK.mo27715ce("contact_info_guarantee_info", true);
                            this.ehK.mo27715ce("contact_info_scope_of_business", true);
                            if (this.pmy != null) {
                            }
                            this.ehK.mo27715ce("contact_info_bindwxainfo", true);
                            m67522UR(this.crP.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
                            C4990ab.m7411d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", Boolean.valueOf(this.crP.getIntent().getBooleanExtra("KIsHardDevice", false)));
                            if (this.crP.getIntent() == null) {
                            }
                            if (C7486a.m12942jh(this.ehM.field_type)) {
                            }
                        }
                    }
                    keyValuePreference.setSummary(charSequence);
                } else {
                    C4990ab.m7412e("MicroMsg.ContactWidgetBizInfo", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
                }
            } else {
                this.ehK.mo27715ce("contact_info_verifyuser", true);
            }
        } else if (this.fuY == null || this.fuY.ael() == null || C5046bo.isNullOrNil(this.fuY.ael().fwb)) {
            C4990ab.m7420w("MicroMsg.ContactWidgetBizInfo", "has not verify info");
            this.ehK.mo27715ce("contact_info_verifyuser", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_verifyuser");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary((CharSequence) this.fuY.ael().fwb);
            }
        }
        if (this.fuY != null || C5046bo.isNullOrNil(this.fuY.aee())) {
            C4990ab.m7420w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
            this.ehK.mo27715ce("contact_info_trademark", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_trademark");
            if (keyValuePreference != null) {
                keyValuePreference.yCj = false;
                if (C26417a.flw != null) {
                    i = C5056d.m7610LV(C1318a.biz_info_trademark_protection);
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
                C4990ab.m7417i(str, str2, objArr);
                if (i != null) {
                    bitmapDrawable = new BitmapDrawable(this.crP.getResources(), i);
                } else {
                    bitmapDrawable = null;
                }
                keyValuePreference.yCr = bitmapDrawable;
                keyValuePreference.setSummary((CharSequence) this.fuY.aee());
                C4990ab.m7411d("MicroMsg.ContactWidgetBizInfo", "trademark name : %s, url : %s.", this.fuY.aee(), this.fuY.aed());
            }
        }
        if (this.fuY != null || this.fuY.aeg() == null || this.fuY.aeg().size() <= 0) {
            this.ehK.mo27715ce("contact_info_privilege", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_privilege");
            keyValuePreference.mo41844qi(false);
            keyValuePreference.dAC();
            for (C16533f c16533f : this.fuY.aeg()) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this.crP, 2130969913, null);
                ((ImageView) linearLayout.findViewById(2131822184)).setImageDrawable(new C46914c(this.crP.getResources(), c16533f.iconUrl));
                CharSequence charSequence2 = c16533f.description;
                identifier = this.crP.getResources().getIdentifier(c16533f.fwa, "string", this.crP.getPackageName());
                if (identifier > 0) {
                    charSequence2 = this.crP.getString(identifier);
                }
                ((TextView) linearLayout.findViewById(2131821841)).setText(charSequence2);
                keyValuePreference.mo41843eI(linearLayout);
            }
        }
        indexOf = this.ehK.indexOf("contact_info_category2");
        if (indexOf >= 0 || this.fuX == null || this.fuX.size() <= 0) {
            C4990ab.m7410d("MicroMsg.ContactWidgetBizInfo", "pos no more");
        } else {
            int size = this.fuX.size() - 1;
            while (size >= 0) {
                if (this.fuX.get(size) != null && ((!this.crP.getString(C25738R.string.auy).equals(((C16528a) this.fuX.get(size)).title) || this.fvf) && !(C5046bo.isNullOrNil(((C16528a) this.fuX.get(size)).title) && C5046bo.isNullOrNil(((C16528a) this.fuX.get(size)).fvb)))) {
                    Preference preference = new Preference(this.crP);
                    preference.setKey("contact_info_bizinfo_external#".concat(String.valueOf(size)));
                    charSequence = ((C16528a) this.fuX.get(size)).title;
                    int identifier2 = this.crP.getResources().getIdentifier(((C16528a) this.fuX.get(size)).fvb, "string", this.crP.getPackageName());
                    if (identifier2 > 0) {
                        charSequence = this.crP.getString(identifier2);
                    }
                    if (this.pkW.adO() && ("__mp_wording__brandinfo_history_massmsg".equals(((C16528a) this.fuX.get(size)).fvb) || r1.equals(this.crP.getString(C25738R.string.__mp_wording__brandinfo_history_massmsg)))) {
                        charSequence = this.crP.getString(C25738R.string.bdf);
                    }
                    preference.setTitle(charSequence);
                    if (!C5046bo.isNullOrNil(((C16528a) this.fuX.get(size)).description)) {
                        preference.setSummary(((C16528a) this.fuX.get(size)).description);
                    }
                    if (C5046bo.nullAsNil(((C16528a) this.fuX.get(size)).fvb).equals("__mp_wording__brandinfo_feedback")) {
                        identifier2 = this.ehK.indexOf("contact_info_scope_of_business");
                        if (identifier2 > 0) {
                            identifier = identifier2 + 1;
                            this.ehK.mo27708a(preference, identifier);
                            if (!C5046bo.nullAsNil(((C16528a) this.fuX.get(size)).fvb).equals("__mp_wording__brandinfo_biz_detail")) {
                                this.ehK.mo27708a(new PreferenceSmallCategory(this.crP), identifier);
                            }
                        }
                    }
                    identifier = indexOf;
                    this.ehK.mo27708a(preference, identifier);
                    if (!C5046bo.nullAsNil(((C16528a) this.fuX.get(size)).fvb).equals("__mp_wording__brandinfo_biz_detail")) {
                    }
                }
                size--;
            }
        }
        if (this.pmA || !C1855t.m3968w(this.ehM) || this.ehM.dug == null || this.ehM.dug.equals("")) {
            this.ehK.mo27715ce("contact_info_verifyuser_weibo", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_verifyuser_weibo");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary((CharSequence) C5046bo.m7532bc(this.ehM.field_weiboNickname, "") + this.crP.getString(C25738R.string.eai, new Object[]{C1855t.m3930nP(this.ehM.dug)}));
                keyValuePreference.ksd = C1338a.m2872i(this.crP, C25738R.color.f12123t7);
                keyValuePreference.mo41844qi(false);
            }
        }
        if (this.fuY != null || this.fuY.aei() == null) {
            this.ehK.mo27715ce("contact_info_reputation", true);
            this.ehK.mo27715ce("contact_info_guarantee_info", true);
            this.ehK.mo27715ce("contact_info_scope_of_business", true);
        } else {
            BizInfoPayInfoIconPreference bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.ehK.aqO("contact_info_reputation");
            if (this.fuY.aei().fvW > 0) {
                bizInfoPayInfoIconPreference.mo46830AS(this.fuY.aei().fvW);
            } else {
                this.ehK.mo27715ce("contact_info_reputation", true);
            }
            bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.ehK.aqO("contact_info_guarantee_info");
            if (this.fuY.aei().fvY == null || this.fuY.aei().fvY.size() <= 0) {
                this.ehK.mo27715ce("contact_info_guarantee_info", true);
            } else {
                bizInfoPayInfoIconPreference.mo46831cC(this.fuY.aei().fvY);
            }
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_scope_of_business");
            if (C5046bo.isNullOrNil(this.fuY.aei().fvX)) {
                this.ehK.mo27715ce("contact_info_scope_of_business", true);
            } else {
                keyValuePreference.setSummary((CharSequence) this.fuY.aei().fvX);
                keyValuePreference.yCp = 4;
                keyValuePreference.mo41844qi(false);
            }
        }
        if (this.pmy != null || this.pmy.size() <= 0) {
            this.ehK.mo27715ce("contact_info_bindwxainfo", true);
        } else {
            this.ehK.mo27715ce("contact_info_bindwxainfo", false);
            ((BizBindWxaInfoPreference) this.ehK.aqO("contact_info_bindwxainfo")).mo74082a(this.pkW, this.pmy);
        }
        m67522UR(this.crP.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
        C4990ab.m7411d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", Boolean.valueOf(this.crP.getIntent().getBooleanExtra("KIsHardDevice", false)));
        CheckBoxPreference checkBoxPreference2;
        String Oj;
        if (this.crP.getIntent() == null && this.crP.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            C4990ab.m7410d("MicroMsg.ContactWidgetBizInfo", "Hard device biz...");
            z = caW();
            C4990ab.m7411d("MicroMsg.ContactWidgetBizInfo", "contact.isContact()(%b), isHardDeviceBound(%b)", Boolean.valueOf(C7486a.m12942jh(this.ehM.field_type)), Boolean.valueOf(z));
            if (C7486a.m12942jh(this.ehM.field_type) && z) {
                if (c16527d != null) {
                    checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo");
                    checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("contact_info_locate");
                    if (c16527d.adR()) {
                        this.pmx = C41747z.aeV().mo60356cH(C41747z.aeV().mo60357cI(c16527d.field_username));
                        if (this.pmx != null) {
                            if (this.pmx.mo73056lc(4)) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            checkBoxPreference.uOT = z2;
                        } else {
                            C4990ab.m7420w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                        }
                    } else {
                        checkBoxPreference.uOT = c16527d.adH();
                    }
                    if (c16527d.adH()) {
                        if (this.fuY == null && c16527d != null) {
                            this.fuY = c16527d.mo30481cJ(false);
                        }
                        if (this.fuY != null && this.fuY.aeb() && C25985d.afj("brandservice")) {
                            this.ehK.mo27715ce("contact_info_template_recv", false);
                        } else {
                            this.ehK.mo27715ce("contact_info_template_recv", true);
                        }
                    } else {
                        this.ehK.mo27715ce("contact_info_template_recv", true);
                    }
                    if (c16527d.mo30481cJ(false).adL()) {
                        checkBoxPreference2.uOT = c16527d.adI();
                    } else {
                        this.ehK.mo27715ce("contact_info_locate", true);
                        checkBoxPreference2.uOT = c16527d.adI();
                    }
                } else {
                    this.ehK.mo27715ce("contact_info_subscribe_bizinfo", true);
                    this.ehK.mo27715ce("contact_info_locate", true);
                    this.ehK.mo27715ce("contact_info_template_recv", true);
                }
                this.ehK.mo27715ce("contact_info_biz_read_msg_online", true);
                this.ehK.mo27715ce("contact_info_biz_add", true);
                Oj = this.ehM.mo16707Oj();
                if (Oj != null) {
                    this.crP.setMMTitle(Oj);
                }
                if (C1855t.m3943nl(this.ehM.field_username)) {
                    ((ButtonPreference) this.ehK.aqO("contact_info_biz_go_chatting")).mo41835ed(this.crP.getResources().getString(C25738R.string.azv), this.crP.getResources().getColor(C25738R.color.f11795hi));
                    this.crP.setMMTitle((int) C25738R.string.b1v);
                }
                if (!(C1855t.m3921nG(this.ehM.field_username) || this.pkW == null || this.pkW.adQ())) {
                    this.crP.addIconOptionMenu(0, C25738R.drawable.f6899uu, new C2148717());
                }
                AppMethodBeat.m2505o(23479);
                return;
            }
            C4990ab.m7421w("MicroMsg.ContactWidgetBizInfo", "%s is not my hard biz contact", this.ehM.field_username);
            caU();
            Preference aqO2 = this.ehK.aqO("contact_info_biz_add");
            C4990ab.m7411d("MicroMsg.ContactWidgetBizInfo", "isBizConferenceAccount(%b)", Boolean.valueOf(this.pmB));
            if (aqO2 != null) {
                if (z) {
                    aqO2.setTitle((int) C25738R.string.auh);
                } else {
                    aqO2.setTitle((int) C25738R.string.aua);
                }
            }
            if (C39514c.m67520Bd(this.gwP)) {
                if (c16527d == null) {
                    C4990ab.m7412e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                } else {
                    ((CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo")).uOT = c16527d.adH();
                    this.ehK.mo27715ce("contact_info_subscribe_bizinfo", false);
                }
            }
            this.crP.showOptionMenu(false);
            AppMethodBeat.m2505o(23479);
        } else if (C7486a.m12942jh(this.ehM.field_type)) {
            if (c16527d != null) {
                checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo");
                checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("contact_info_locate");
                if (c16527d.adR()) {
                    checkBoxPreference.setTitle((int) C25738R.string.bdk);
                    this.pmx = C41747z.aeV().mo60356cH(C41747z.aeV().mo60357cI(c16527d.field_username));
                    if (this.pmx != null) {
                        if (this.pmx.mo73056lc(4)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        checkBoxPreference.uOT = z2;
                    } else {
                        C4990ab.m7420w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                    }
                } else if (c16527d.adP()) {
                    checkBoxPreference.setTitle((int) C25738R.string.bdg);
                    if (C41747z.afa().mo20351qG(c16527d.field_username)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    checkBoxPreference.uOT = z2;
                } else {
                    checkBoxPreference.uOT = c16527d.adH();
                }
                if (c16527d.adH()) {
                    if (this.fuY == null && c16527d != null) {
                        this.fuY = c16527d.mo30481cJ(false);
                    }
                    if (this.fuY != null && this.fuY.aeb() && C25985d.afj("brandservice")) {
                        this.ehK.mo27715ce("contact_info_template_recv", false);
                    } else {
                        this.ehK.mo27715ce("contact_info_template_recv", true);
                    }
                } else {
                    this.ehK.mo27715ce("contact_info_template_recv", true);
                }
                if (c16527d.mo30481cJ(false).adL()) {
                    checkBoxPreference2.uOT = c16527d.adI();
                } else {
                    this.ehK.mo27715ce("contact_info_locate", true);
                    checkBoxPreference2.uOT = c16527d.adI();
                }
            } else {
                this.ehK.mo27715ce("contact_info_subscribe_bizinfo", true);
                this.ehK.mo27715ce("contact_info_locate", true);
                this.ehK.mo27715ce("contact_info_template_recv", true);
            }
            this.ehK.mo27715ce("contact_info_biz_read_msg_online", true);
            this.ehK.mo27715ce("contact_info_biz_add", true);
            Oj = this.ehM.mo16707Oj();
            if (Oj != null) {
                this.crP.setMMTitle(Oj);
            }
            if (C1855t.m3943nl(this.ehM.field_username)) {
                ((ButtonPreference) this.ehK.aqO("contact_info_biz_go_chatting")).mo41835ed(this.crP.getResources().getString(C25738R.string.azv), this.crP.getResources().getColor(C25738R.color.f11795hi));
                this.crP.setMMTitle((int) C25738R.string.b1v);
            }
            if (!(C1855t.m3921nG(this.ehM.field_username) || this.pkW == null)) {
                this.crP.addIconOptionMenu(0, C25738R.drawable.f6899uu, new C3951518());
            }
            AppMethodBeat.m2505o(23479);
        } else {
            C4990ab.m7421w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", this.ehM.field_username);
            caU();
            aqO = this.ehK.aqO("contact_info_biz_add");
            if (aqO != null && this.pmB) {
                aqO.setTitle((int) C25738R.string.auh);
            }
            if (C39514c.m67520Bd(this.gwP)) {
                if (c16527d == null) {
                    C4990ab.m7412e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                } else {
                    ((CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo")).uOT = c16527d.adH();
                    this.ehK.mo27715ce("contact_info_subscribe_bizinfo", false);
                }
            }
            this.crP.showOptionMenu(false);
            AppMethodBeat.m2505o(23479);
        }
    }

    /* renamed from: Bc */
    private String m67519Bc(int i) {
        AppMethodBeat.m2504i(23480);
        String string;
        switch (i) {
            case 0:
                string = this.crP.getResources().getString(C25738R.string.b24);
                AppMethodBeat.m2505o(23480);
                return string;
            case 1:
                string = this.crP.getResources().getString(C25738R.string.abf);
                AppMethodBeat.m2505o(23480);
                return string;
            case 2:
                string = this.crP.getResources().getString(C25738R.string.abg);
                AppMethodBeat.m2505o(23480);
                return string;
            default:
                C4990ab.m7421w("MicroMsg.ContactWidgetBizInfo", "getVerifyStr, error type %d", Integer.valueOf(i));
                string = this.crP.getResources().getString(C25738R.string.aww);
                AppMethodBeat.m2505o(23480);
                return string;
        }
    }

    private void caU() {
        AppMethodBeat.m2504i(23481);
        if (this.ehM == null || !C7486a.m12942jh(this.ehM.field_type) || C1855t.m3943nl(this.ehM.field_username) || C1855t.m3931nQ(this.ehM.field_username)) {
            this.ehK.mo27715ce("contact_is_mute", true);
            if (this.ehM == null || C7486a.m12942jh(this.ehM.field_type) || !C39514c.m67520Bd(this.gwP)) {
                this.ehK.mo27715ce("contact_info_expose_btn", true);
            } else {
                this.ehK.mo27715ce("contact_info_expose_btn", false);
            }
        } else {
            this.ehK.mo27715ce("contact_is_mute", false);
        }
        this.ehK.mo27715ce("contact_info_verifyuser_weibo", true);
        this.ehK.mo27715ce("contact_info_subscribe_bizinfo", true);
        this.ehK.mo27715ce("contact_info_template_recv", true);
        this.ehK.mo27715ce("contact_info_locate", true);
        if (this.pmA) {
            this.ehK.mo27715ce("contact_info_biz_add", true);
        } else {
            this.ehK.mo27715ce("contact_info_time_expired", true);
        }
        if (this.ehM == null || !((C1855t.m3921nG(this.ehM.field_username) || C1855t.m3931nQ(this.ehM.field_username)) && C7486a.m12942jh(this.ehM.field_type))) {
            this.ehK.mo27715ce("contact_info_biz_go_chatting", true);
        } else {
            this.ehK.mo27715ce("contact_info_biz_go_chatting", false);
        }
        if (C1855t.m3931nQ(this.ehM.field_username)) {
            this.ehK.mo27715ce("contact_info_user_desc", true);
        }
        AppMethodBeat.m2505o(23481);
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(23482);
        BizInfoHeaderPreference bizInfoHeaderPreference = (BizInfoHeaderPreference) this.ehK.aqO("contact_info_header_bizinfo");
        if (bizInfoHeaderPreference != null) {
            bizInfoHeaderPreference.onDetach();
        }
        AppMethodBeat.m2505o(23482);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(23483);
        if (this.crP == null) {
            C4990ab.m7412e("MicroMsg.ContactWidgetBizInfo", "null == context");
            AppMethodBeat.m2505o(23483);
            return;
        }
        C4990ab.m7417i("MicroMsg.ContactWidgetBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 != -1 || intent == null) {
                    AppMethodBeat.m2505o(23483);
                    return;
                }
                String stringExtra = intent.getStringExtra("be_send_card_name");
                String stringExtra2 = intent.getStringExtra("received_card_name");
                boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                String stringExtra3 = intent.getStringExtra("custom_send_text");
                C12519g.bOk().mo46462q(stringExtra, stringExtra2, booleanExtra);
                C12519g.bOk().mo46461eZ(stringExtra3, stringExtra2);
                C5670b.m8523i(this.crP, this.crP.getString(C25738R.string.bvk));
                AppMethodBeat.m2505o(23483);
                return;
            default:
                AppMethodBeat.m2505o(23483);
                return;
        }
    }

    /* renamed from: UQ */
    private static boolean m67521UQ(String str) {
        AppMethodBeat.m2504i(23484);
        try {
            long j = C5046bo.getLong(str, 0);
            if (j <= 0 || j - (System.currentTimeMillis() / 1000) >= 0) {
                AppMethodBeat.m2505o(23484);
                return false;
            }
            AppMethodBeat.m2505o(23484);
            return true;
        } catch (Exception e) {
            AppMethodBeat.m2505o(23484);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: aV */
    public final void mo62476aV(int i, String str) {
        AppMethodBeat.m2504i(23485);
        if (this.pmH == null || !(this.gwP == 39 || this.gwP == 56 || this.gwP == 35 || this.gwP == 87 || this.gwP == 88 || this.gwP == 89 || this.gwP == 85)) {
            C4990ab.m7410d("MicroMsg.ContactWidgetBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
            AppMethodBeat.m2505o(23485);
        } else if (this.ehM == null) {
            C4990ab.m7416i("MicroMsg.ContactWidgetBizInfo", "contact is null.");
            AppMethodBeat.m2505o(23485);
        } else {
            int i2;
            String string = this.pmH.getString("Contact_Ext_Args_Search_Id");
            String nullAsNil = C5046bo.nullAsNil(this.pmH.getString("Contact_Ext_Args_Query_String"));
            int i3 = this.pmH.getInt("Contact_Ext_Args_Index");
            switch (this.gwP) {
                case 35:
                    i2 = 1;
                    break;
                case C33345i.CTRL_INDEX /*85*/:
                    i2 = 5;
                    break;
                case C31128d.MIC_COLORPENCIL /*87*/:
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
            String nullAsNil2 = C5046bo.nullAsNil(this.pmH.getString("Contact_Ext_Extra_Params"));
            String str2 = nullAsNil + "," + i + "," + C5046bo.nullAsNil(this.ehM.field_username) + "," + i3 + "," + (System.currentTimeMillis() / 1000) + "," + string + "," + i2;
            if (C5046bo.isNullOrNil(str)) {
                str2 = str2 + ",," + nullAsNil2;
            } else {
                str2 = str2 + "," + str + "," + nullAsNil2;
            }
            C4990ab.m7419v("MicroMsg.ContactWidgetBizInfo", "report 10866: %s", str2);
            C7060h.pYm.mo8374X(10866, str2);
            AppMethodBeat.m2505o(23485);
        }
    }

    /* Access modifiers changed, original: final */
    public final void caV() {
        AppMethodBeat.m2504i(23486);
        if (this.crP.getIntent() != null && this.crP.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            String stringExtra = this.crP.getIntent().getStringExtra("KHardDeviceBindTicket");
            if (C5046bo.isNullOrNil(stringExtra)) {
                C4990ab.m7416i("MicroMsg.ContactWidgetBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
            } else if (!caW()) {
                C4990ab.m7411d("MicroMsg.ContactWidgetBizInfo", "IsHardDevice, bindTicket = %s", stringExtra);
                C9638aw.m17182Rg().mo14539a(536, (C1202f) this);
                C9315dc c9315dc = new C9315dc();
                c9315dc.cwj.cwl = stringExtra;
                c9315dc.cwj.opType = 1;
                C4879a.xxA.mo10055m(c9315dc);
                final C1207m c1207m = c9315dc.cwk.cwn;
                Context context = this.crP;
                this.crP.getString(C25738R.string.f9238tz);
                this.tipDialog = C30379h.m48458b(context, this.crP.getString(C25738R.string.f9260un), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(23461);
                        C9638aw.m17182Rg().mo14546b(536, C39514c.this);
                        C9315dc c9315dc = new C9315dc();
                        c9315dc.cwj.opType = 2;
                        c9315dc.cwj.cwn = c1207m;
                        C4879a.xxA.mo10055m(c9315dc);
                        AppMethodBeat.m2505o(23461);
                    }
                });
                AppMethodBeat.m2505o(23486);
                return;
            }
        }
        C14916a c14916a = new C14916a(this.crP, new C395186());
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(this.gwP));
        if (this.fvh != null) {
            c14916a.vjK = this.fvh;
        }
        if (!C5046bo.isNullOrNil(this.mGZ)) {
            c14916a.mGZ = this.mGZ;
        }
        c14916a.vjP = true;
        c14916a.mo27240a(this.ehM.field_username, linkedList, this.pmJ);
        AppMethodBeat.m2505o(23486);
    }

    private boolean caW() {
        AppMethodBeat.m2504i(23487);
        if (this.crP.getIntent() == null) {
            AppMethodBeat.m2505o(23487);
            return false;
        }
        String stringExtra = this.crP.getIntent().getStringExtra("device_id");
        String stringExtra2 = this.crP.getIntent().getStringExtra("device_type");
        C41980dg c41980dg = new C41980dg();
        c41980dg.cwu.ceI = stringExtra;
        c41980dg.cwu.cws = stringExtra2;
        C4879a.xxA.mo10055m(c41980dg);
        boolean z = c41980dg.cwv.cww;
        AppMethodBeat.m2505o(23487);
        return z;
    }

    /* Access modifiers changed, original: final */
    public final void caX() {
        AppMethodBeat.m2504i(23488);
        if (this.ehM == null || C5046bo.isNullOrNil(this.ehM.field_username)) {
            AppMethodBeat.m2505o(23488);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[]{this.ehM.field_username}));
        intent.putExtra("showShare", false);
        C25985d.m41467b(this.crP, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(23488);
    }

    /* renamed from: jO */
    private void m67526jO(boolean z) {
        AppMethodBeat.m2504i(23489);
        if (this.ehM != null) {
            if (this.crP != null) {
                if (!z || C17903f.m28103kq(this.ehM.field_username)) {
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
        AppMethodBeat.m2505o(23489);
    }

    /* renamed from: UR */
    private void m67522UR(String str) {
        AppMethodBeat.m2504i(23490);
        C4990ab.m7411d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", str, Boolean.valueOf(this.pmF));
        if (this.pmF) {
            AppMethodBeat.m2505o(23490);
            return;
        }
        this.pmE = str;
        C46874g rh;
        IconWidgetPreference iconWidgetPreference;
        Bitmap a;
        if (this.fuY == null || !this.fuY.aeq() || this.ehM == null) {
            this.ehK.mo27715ce("contact_info_kf_worker", true);
            AppMethodBeat.m2505o(23490);
        } else if (C5046bo.isNullOrNil(str)) {
            rh = C41747z.aeQ().mo67511rh(this.ehM.field_username);
            if (rh == null) {
                this.ehK.mo27715ce("contact_info_kf_worker", true);
                C41747z.aeS().mo60362a(this);
                C41747z.aeS().mo60363ax(this.ehM.field_username, C1853r.m3846Yz());
                this.pmF = true;
                AppMethodBeat.m2505o(23490);
                return;
            }
            C4990ab.m7411d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", rh.field_openId);
            this.ehK.mo27715ce("contact_info_kf_worker", false);
            iconWidgetPreference = (IconWidgetPreference) this.ehK.aqO("contact_info_kf_worker");
            iconWidgetPreference.setSummary((CharSequence) rh.field_nickname);
            a = C41730b.m73490a(rh.field_openId, false, -1);
            if (a == null) {
                C39514c.m67525c(rh);
                m67523US(rh.field_openId);
                AppMethodBeat.m2505o(23490);
                return;
            }
            iconWidgetPreference.mo24866O(a);
            AppMethodBeat.m2505o(23490);
        } else {
            C41743i aeQ = C41747z.aeQ();
            C46874g rg = aeQ.mo67510rg(str);
            if (rg == null || C41743i.m73577a(rg)) {
                C41747z.aeS().mo60362a(this);
                C41747z.aeS().mo60364ay(this.ehM.field_username, str);
                this.pmF = true;
            }
            if (rg == null) {
                C4990ab.m7410d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                rh = aeQ.mo67511rh(this.ehM.field_username);
            } else {
                rh = rg;
            }
            if (rh == null) {
                this.ehK.mo27715ce("contact_info_kf_worker", true);
                AppMethodBeat.m2505o(23490);
                return;
            }
            this.ehK.mo27715ce("contact_info_kf_worker", false);
            iconWidgetPreference = (IconWidgetPreference) this.ehK.aqO("contact_info_kf_worker");
            iconWidgetPreference.setSummary((CharSequence) rh.field_nickname);
            a = C41730b.m73490a(rh.field_openId, false, -1);
            if (a == null) {
                C39514c.m67525c(rh);
                m67523US(rh.field_openId);
            } else {
                iconWidgetPreference.mo24866O(a);
            }
            C4990ab.m7411d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", rh.field_openId, rh.field_nickname);
            AppMethodBeat.m2505o(23490);
        }
    }

    /* renamed from: US */
    private void m67523US(final String str) {
        AppMethodBeat.m2504i(23491);
        C5004al.m7442n(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(23466);
                if (C39514c.this.ehK == null) {
                    C4990ab.m7420w("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar screen is null");
                    AppMethodBeat.m2505o(23466);
                    return;
                }
                IconWidgetPreference iconWidgetPreference = (IconWidgetPreference) C39514c.this.ehK.aqO("contact_info_kf_worker");
                if (!(iconWidgetPreference == null || C39514c.this.ehK == null)) {
                    Bitmap a = C41730b.m73490a(str, false, -1);
                    if (a != null) {
                        C4990ab.m7411d("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar success %s, update screen", str);
                        iconWidgetPreference.mo24866O(a);
                        C39514c.this.ehK.notifyDataSetChanged();
                    }
                }
                AppMethodBeat.m2505o(23466);
            }
        }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.m2505o(23491);
    }

    /* renamed from: c */
    private static void m67525c(C46874g c46874g) {
        AppMethodBeat.m2504i(23492);
        long currentTimeMillis = System.currentTimeMillis();
        C17881i act = C17884o.act();
        if (act.mo33392qo(c46874g.field_openId) == null) {
            C17880h c17880h = new C17880h();
            c17880h.username = c46874g.field_openId;
            c17880h.frV = c46874g.field_headImgUrl;
            c17880h.mo33385cB(false);
            c17880h.dtR = 3;
            act.mo33391b(c17880h);
        }
        C17884o.acv().mo67496qa(c46874g.field_openId);
        C4990ab.m7411d("MicroMsg.ContactWidgetBizInfo", "downloadKFAvatar, %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(23492);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        bxr bxr = null;
        AppMethodBeat.m2504i(23493);
        C4990ab.m7410d("MicroMsg.ContactWidgetBizInfo", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        this.pmF = false;
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (c1207m == null) {
            C4990ab.m7412e("MicroMsg.ContactWidgetBizInfo", "scene == null");
            AppMethodBeat.m2505o(23493);
            return;
        }
        C9638aw.m17182Rg().mo14546b(c1207m.getType(), (C1202f) this);
        if (i == 0 && i2 == 0) {
            C4990ab.m7411d("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", Integer.valueOf(c1207m.getType()));
            if (c1207m.getType() == 536) {
                C9638aw.m17182Rg().mo14546b(536, (C1202f) this);
                caT();
                AppMethodBeat.m2505o(23493);
                return;
            } else if (c1207m.getType() == 1363) {
                bxs bxs;
                C39502c c39502c = (C39502c) c1207m;
                if (c39502c.ehh == null || c39502c.ehh.fsH.fsP == null) {
                    bxs = null;
                } else {
                    bxs = (bxs) c39502c.ehh.fsH.fsP;
                }
                C39502c c39502c2 = (C39502c) c1207m;
                if (!(c39502c2.ehh == null || c39502c2.ehh.fsG.fsP == null)) {
                    bxr = (bxr) c39502c2.ehh.fsG.fsP;
                }
                if (bxs == null || bxs.vNh == null || bxs.vNh.ret != 0 || bxs.vNe == null || C5046bo.isNullOrNil(bxs.vNe.vNc)) {
                    if (bxs == null || bxs.vNh == null) {
                        C4990ab.m7420w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:resp == null");
                        AppMethodBeat.m2505o(23493);
                        return;
                    }
                    C4990ab.m7421w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:code:%s", Integer.valueOf(bxs.vNh.ret));
                    AppMethodBeat.m2505o(23493);
                    return;
                } else if (bxs.vNe == null) {
                    C4990ab.m7420w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd resp.user == null");
                    AppMethodBeat.m2505o(23493);
                    return;
                } else {
                    C45143j cH = C41747z.aeV().mo60356cH(bxs.vNe.vNc);
                    if (cH == null) {
                        cH = new C45143j();
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
                    if (!C41747z.aeV().mo60354b(cH)) {
                        C41747z.aeV().mo60353a(cH);
                    }
                    AppMethodBeat.m2505o(23493);
                    return;
                }
            } else if (c1207m.getType() == 1394) {
                cfr caz = ((C28682d) c1207m).caz();
                cfs cay = ((C28682d) c1207m).cay();
                if (cay != null && cay.vNh != null && cay.vNh.ret == 0) {
                    int i3;
                    if (caz.xeS) {
                        boolean i32 = false;
                    } else {
                        i32 = 1;
                    }
                    C16527d c16527d;
                    if (i32 != 0) {
                        C7617ak c7617ak;
                        c16527d = this.pkW;
                        c16527d.field_brandFlag &= -2;
                        mo62475a(c16527d, true);
                        C9638aw.m17190ZK();
                        if (C18628c.m29083XR().aoZ(c16527d.field_username) == null) {
                            c7617ak = new C7617ak(c16527d.field_username);
                            c7617ak.mo14760jj(C5046bo.nullAsNil(this.pkW.adX()));
                            C9638aw.m17190ZK();
                            C7620bi Rb = C18628c.m29080XO().mo15248Rb(c16527d.field_username);
                            if (Rb != null) {
                                C9638aw.m17190ZK();
                                C18628c.m29083XR().mo15807d(c7617ak);
                                C9638aw.m17190ZK();
                                C18628c.m29083XR().mo15801aq(Rb);
                            } else {
                                c7617ak.dsI();
                                C9638aw.m17190ZK();
                                C18628c.m29083XR().mo15807d(c7617ak);
                            }
                        }
                        C9638aw.m17190ZK();
                        if (C18628c.m29083XR().aoZ(c16527d.field_enterpriseFather) == null) {
                            c7617ak = new C7617ak(c16527d.field_enterpriseFather);
                            c7617ak.dsI();
                            C9638aw.m17190ZK();
                            C18628c.m29083XR().mo15807d(c7617ak);
                            AppMethodBeat.m2505o(23493);
                            return;
                        }
                        C9638aw.m17190ZK();
                        C18628c.m29082XQ().aoj(c16527d.field_enterpriseFather);
                        AppMethodBeat.m2505o(23493);
                        return;
                    }
                    c16527d = this.pkW;
                    c16527d.field_brandFlag |= 1;
                    mo62475a(c16527d, true);
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().aoX(c16527d.field_username);
                    C9638aw.m17190ZK();
                    if (C18628c.m29083XR().apl(c16527d.field_enterpriseFather) <= 0) {
                        C9638aw.m17190ZK();
                        C18628c.m29083XR().aoX(c16527d.field_enterpriseFather);
                        AppMethodBeat.m2505o(23493);
                        return;
                    }
                    C9638aw.m17190ZK();
                    C18628c.m29082XQ().aoj(c16527d.field_enterpriseFather);
                    AppMethodBeat.m2505o(23493);
                    return;
                } else if (cay == null || cay.vNh == null) {
                    C4990ab.m7421w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:resp == null", Integer.valueOf(c1207m.getType()));
                    AppMethodBeat.m2505o(23493);
                    return;
                } else {
                    C4990ab.m7421w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:code:%s", Integer.valueOf(c1207m.getType()), Integer.valueOf(cay.vNh.ret));
                    AppMethodBeat.m2505o(23493);
                    return;
                }
            } else if (c1207m.getType() == 1343) {
                caT();
                AppMethodBeat.m2505o(23493);
                return;
            } else {
                if (c1207m.getType() == 1228) {
                    caT();
                }
                AppMethodBeat.m2505o(23493);
                return;
            }
        }
        C4990ab.m7413e("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", Integer.valueOf(c1207m.getType()));
        AppMethodBeat.m2505o(23493);
    }

    /* renamed from: e */
    public final void mo11035e(LinkedList<cwa> linkedList) {
        AppMethodBeat.m2504i(23494);
        C41747z.aeS().mo60365b(this);
        if (this.ehK == null) {
            C4990ab.m7412e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, screen is null");
            AppMethodBeat.m2505o(23494);
        } else if (this.ehM == null) {
            C4990ab.m7412e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, contact is null");
            AppMethodBeat.m2505o(23494);
        } else if (linkedList == null || linkedList.size() <= 0) {
            C4990ab.m7420w("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, worker is null");
            AppMethodBeat.m2505o(23494);
        } else {
            if (!C5046bo.isNullOrNil(this.pmE)) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    cwa cwa = (cwa) it.next();
                    if (cwa.xrU != null && cwa.xrU.equals(this.pmE)) {
                        this.ehK.mo27715ce("contact_info_kf_worker", false);
                        this.ehK.aqO("contact_info_kf_worker").setSummary(cwa.wCW);
                        AppMethodBeat.m2505o(23494);
                        return;
                    }
                }
            }
            this.ehK.mo27715ce("contact_info_kf_worker", false);
            Preference aqO = this.ehK.aqO("contact_info_kf_worker");
            if (!(aqO == null || linkedList == null || linkedList.get(0) == null)) {
                aqO.setSummary(((cwa) linkedList.get(0)).wCW);
            }
            AppMethodBeat.m2505o(23494);
        }
    }

    /* renamed from: a */
    public final void mo15832a(int i, C1207m c1207m) {
        AppMethodBeat.m2504i(23495);
        if (this.pkW == null || !this.pkW.adR()) {
            AppMethodBeat.m2505o(23495);
            return;
        }
        if (c1207m.getType() == 1354) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_subscribe_bizinfo");
            this.pmx = C41747z.aeV().mo60356cH(C41747z.aeV().mo60357cI(this.pkW.field_username));
            if (this.pmx != null) {
                boolean z;
                if (this.pmx.mo73056lc(4)) {
                    z = false;
                } else {
                    z = true;
                }
                checkBoxPreference.uOT = z;
                this.ehK.notifyDataSetChanged();
                AppMethodBeat.m2505o(23495);
                return;
            }
            C4990ab.m7420w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null after GetBizChatMyUserInfo");
        }
        AppMethodBeat.m2505o(23495);
    }

    public final String aeI() {
        return "MicroMsg.ContactWidgetBizInfo";
    }

    private void caY() {
        AppMethodBeat.m2504i(23496);
        C4990ab.m7410d("MicroMsg.ContactWidgetBizInfo", "updatePlaceTop");
        if (this.ehZ == null) {
            this.ehZ = this.crP.getSharedPreferences(this.crP.getPackageName() + "_preferences", 0);
        }
        if (this.ehV != null) {
            if (this.ehM != null) {
                this.ehZ.edit().putBoolean("biz_placed_to_the_top", this.ehM.mo16702Oe()).commit();
            } else {
                this.ehZ.edit().putBoolean("biz_placed_to_the_top", false).commit();
            }
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(23496);
    }

    /* renamed from: Bd */
    private static boolean m67520Bd(int i) {
        if (i == 81 || i == 92 || i == 93 || i == 94) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m67524a(C39514c c39514c) {
        AppMethodBeat.m2504i(23497);
        C36356d c36356d = new C36356d(c39514c.crP, 1, false);
        c36356d.rBl = new C3951619();
        c36356d.rBm = new C128452();
        c36356d.cpD();
        AppMethodBeat.m2505o(23497);
    }
}
