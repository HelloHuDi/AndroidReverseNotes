package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.hardcoder.C1625i;
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
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C16527d.C16528a;
import com.tencent.p177mm.p184aj.C16527d.C16529b;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C32237a;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p230g.p231a.C41980dg;
import com.tencent.p177mm.p230g.p231a.C9293ai;
import com.tencent.p177mm.p230g.p231a.C9315dc;
import com.tencent.p177mm.p230g.p231a.C9430of;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5510e.C5494a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C33345i;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.profile.C34696c;
import com.tencent.p177mm.plugin.profile.C39503b;
import com.tencent.p177mm.plugin.profile.p483ui.ContactInfoUI;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b.C12866c;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b.C46140d;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1499d.C34740a;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p484c.C34739c;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p484c.C3642a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14917a;
import com.tencent.p177mm.protocal.protobuf.C40539kt;
import com.tencent.p177mm.protocal.protobuf.C40540ku;
import com.tencent.p177mm.protocal.protobuf.C7285uy;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C30309s;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vending.p639e.C5685b;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.WebView;
import com.tencent.view.C31128d;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.b */
public final class C43392b implements C1202f, C23233a {
    public long edh;
    C15541f ehK;
    public C7616ad ehM;
    public long endTime;
    private List<C16528a> fuX;
    private C16529b fuY;
    private String fvh;
    public int gwP;
    public String mGZ;
    public C16527d pkW;
    boolean pli;
    private String pln;
    private int pmD = 0;
    private Bundle pmH;
    SnsAdClick pmI = null;
    private String pmJ = null;
    public List<WxaEntryInfo> pmy;
    private C7285uy pmz;
    ContactInfoUI ppM;
    public C46140d ppN;
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.b$1 */
    class C214971 implements OnMenuItemClickListener {
        C214971() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(23802);
            C43392b.this.ppM.onBackPressed();
            AppMethodBeat.m2505o(23802);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.b$2 */
    class C214982 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.b$2$1 */
        class C214991 implements C36073c {
            C214991() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(23803);
                if (C7486a.m12942jh(C43392b.this.ehM.field_type)) {
                    if (C43392b.this.ehM.mo16702Oe()) {
                        if (C30309s.aVO() && C17903f.m28106qZ(C43392b.this.ehM.field_username)) {
                            c44273l.mo70072hi(5, C25738R.string.auq);
                        } else {
                            c44273l.mo70072hi(5, C25738R.string.cvm);
                        }
                    } else if (C30309s.aVO() && C17903f.m28106qZ(C43392b.this.ehM.field_username)) {
                        c44273l.mo70072hi(4, C25738R.string.aum);
                    } else {
                        c44273l.mo70072hi(4, C25738R.string.b1r);
                    }
                }
                c44273l.mo70072hi(1, C25738R.string.auk);
                if (C7486a.m12942jh(C43392b.this.ehM.field_type)) {
                    c44273l.mo70072hi(2, C25738R.string.azw);
                    c44273l.mo70072hi(3, C25738R.string.av2);
                }
                AppMethodBeat.m2505o(23803);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.b$2$2 */
        class C215002 implements C5279d {
            C215002() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(23804);
                C43392b c43392b;
                Intent intent;
                switch (menuItem.getItemId()) {
                    case 1:
                        c43392b = C43392b.this;
                        intent = new Intent();
                        intent.setClass(c43392b.ppM, NewBizInfoMoreInofUI.class);
                        intent.putExtra("Contact_User", c43392b.ehM.field_username);
                        if (c43392b.ppM.getIntent() != null) {
                            intent.putExtras(c43392b.ppM.getIntent());
                        }
                        c43392b.ppM.startActivity(intent);
                        C34739c.m57055cP(c43392b.ehM.field_username, 700);
                        AppMethodBeat.m2505o(23804);
                        return;
                    case 2:
                        c43392b = C43392b.this;
                        intent = new Intent();
                        intent.putExtra("Select_Talker_Name", c43392b.ehM.field_username);
                        intent.putExtra("Select_block_List", c43392b.ehM.field_username);
                        intent.putExtra("Select_Send_Card", true);
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("mutil_select_is_ret", true);
                        C39503b.gkE.mo38899a(intent, c43392b.ppM);
                        C34739c.m57055cP(c43392b.ehM.field_username, 800);
                        AppMethodBeat.m2505o(23804);
                        return;
                    case 3:
                        c43392b = C43392b.this;
                        intent = new Intent();
                        intent.setClass(c43392b.ppM, NewBizInfoSettingUI.class);
                        intent.putExtra("Contact_User", c43392b.ehM.field_username);
                        intent.putExtra("key_start_biz_profile_setting_from_scene", 2);
                        if (c43392b.ppM.getIntent() != null) {
                            intent.putExtras(c43392b.ppM.getIntent());
                        }
                        c43392b.ppM.startActivity(intent);
                        AppMethodBeat.m2505o(23804);
                        return;
                    case 4:
                        C34739c.m57055cP(C43392b.this.ehM.field_username, C1625i.SCENE_BIZ_SCROLL);
                        C26428i.m42084mn(C43392b.this.ehM.field_username);
                        C43392b.m77439a(C43392b.this);
                        if (!C30309s.aVO() || C17903f.m28105qY(C43392b.this.ehM.field_username)) {
                            C30379h.m48465bQ(C43392b.this.ppM, C43392b.this.ppM.getString(C25738R.string.cvn));
                            AppMethodBeat.m2505o(23804);
                            return;
                        }
                    case 5:
                        C1855t.m3969x(C43392b.this.ehM.field_username, true);
                        C34739c.m57055cP(C43392b.this.ehM.field_username, 904);
                        C43392b.m77439a(C43392b.this);
                        if (!C30309s.aVO() || C17903f.m28105qY(C43392b.this.ehM.field_username)) {
                            C30379h.m48465bQ(C43392b.this.ppM, C43392b.this.ppM.getString(C25738R.string.a_k));
                            AppMethodBeat.m2505o(23804);
                            return;
                        }
                    default:
                        C4990ab.m7420w("MicroMsg.ContactWidgetNewBizInfo", "default onMMMenuItemSelected err");
                        break;
                }
                AppMethodBeat.m2505o(23804);
            }
        }

        C214982() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(23805);
            C36356d c36356d = new C36356d(C43392b.this.ppM, 1, false);
            c36356d.rBl = new C214991();
            c36356d.rBm = new C215002();
            c36356d.cpD();
            C34739c.m57055cP(C43392b.this.ehM.field_username, 600);
            AppMethodBeat.m2505o(23805);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.b$3 */
    class C215013 implements Runnable {
        C215013() {
        }

        public final void run() {
            AppMethodBeat.m2504i(23806);
            C43392b.this.mo68939Bj(4);
            if (C43392b.this.ppM.getIntent().getIntExtra("Kdel_from", -1) == 1) {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                C25985d.m41467b(C43392b.this.ppM, "shake", ".ui.ShakeReportUI", intent);
            }
            AppMethodBeat.m2505o(23806);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.b$4 */
    class C433914 implements C1224a {
        C433914() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(23807);
            C4990ab.m7417i("MicroMsg.ContactWidgetNewBizInfo", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            C40540ku c40540ku = (C40540ku) c7472b.fsH.fsP;
            if (i == 0 && i2 == 0 && c40540ku != null) {
                C4990ab.m7411d("MicroMsg.ContactWidgetNewBizInfo", "BizProfileResp:%d", Integer.valueOf(c40540ku.vKQ.size()));
                C43392b.this.ppN = C46140d.m86124a(C43392b.this.ehM.field_username, c40540ku);
                if (C43392b.this.ppN != null) {
                    boolean z;
                    C34740a cap = C34696c.cap();
                    C46140d c46140d = C43392b.this.ppN;
                    if (c46140d == null) {
                        C4990ab.m7412e("MicroMsg.ProfileInfoStorage", "profileInfo is null, err");
                        z = false;
                    } else {
                        C46140d c46140d2 = new C46140d();
                        c46140d2.field_username = c46140d.field_username;
                        boolean b = cap.mo10102b((C4925c) c46140d2, new String[0]);
                        C4990ab.m7417i("MicroMsg.ProfileInfoStorage", "insertOrUpdate username:%s", c46140d.field_username);
                        z = b ? cap.mo10103c(c46140d, new String[0]) : cap.mo10101b((C4925c) c46140d);
                    }
                    C4990ab.m7417i("MicroMsg.ContactWidgetNewBizInfo", "username:%s insert db :%b", C43392b.this.ppN.field_username, Boolean.valueOf(z));
                }
                C43392b.this.caT();
                C43392b c43392b = C43392b.this;
                if (c43392b.ehM == null || c43392b.pkW == null || c43392b.ppN == null) {
                    C4990ab.m7420w("MicroMsg.ContactWidgetNewBizInfo", "reportUpdate fail, err");
                } else {
                    int i3;
                    String str2 = c43392b.ehM.field_username;
                    int i4 = c43392b.gwP;
                    int i5 = c43392b.pkW.field_type;
                    long j = c43392b.edh;
                    if (C7486a.m12942jh(c43392b.ehM.field_type)) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    C3642a.m5975a(str2, i4, i5, j, i3, c43392b.ppN.field_originalArticleCount, c43392b.ppN.field_friendSubscribeCount, c43392b.pmy != null ? c43392b.pmy.size() : 0, C3642a.m5977cE(c43392b.ppN.cbL()), C3642a.m5978cF(c43392b.ppN.cbM()), c43392b.ppN.field_decryptUserName);
                    if (c43392b.ppN != null && c43392b.ppN.cbR()) {
                        C34739c.m57055cP(c43392b.ehM.field_username, 104);
                    }
                    if (c43392b.ppN != null && c43392b.ppN.cbO()) {
                        C34739c.m57055cP(c43392b.ehM.field_username, 101);
                    }
                    if (c43392b.ppN != null && c43392b.isNormal() && c43392b.pmy != null && c43392b.pmy.size() > 0) {
                        C34739c.m57055cP(c43392b.ehM.field_username, 105);
                    }
                }
            }
            AppMethodBeat.m2505o(23807);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.b$5 */
    class C433935 implements C32792b {
        C433935() {
        }

        /* renamed from: kL */
        public final void mo8219kL(int i) {
            AppMethodBeat.m2504i(23808);
            if (i == 0) {
                C43392b.this.caV();
            }
            AppMethodBeat.m2505o(23808);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.b$7 */
    class C433947 implements C14917a {
        C433947() {
        }

        /* JADX WARNING: Missing block: B:62:0x0224, code skipped:
            if (r2 == false) goto L_0x0116;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo5739a(boolean z, boolean z2, String str, String str2) {
            AppMethodBeat.m2504i(23810);
            if (z) {
                C16527d c16527d;
                C30379h.m48465bQ(C43392b.this.ppM, C43392b.this.ppM.getString(C25738R.string.aul));
                C43392b.this.ehK.mo27715ce("contact_info_time_expired", true);
                C7616ad c7616ad = C43392b.this.ehM;
                if (c7616ad == null || C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.ContactWidgetNewBizInfo", "respUsername == " + str + ", contact = " + c7616ad);
                } else {
                    c16527d = null;
                    if (C1855t.m3911mX(c7616ad.field_username)) {
                        String nullAsNil = C5046bo.nullAsNil(c7616ad.field_username);
                        c16527d = C17903f.m28104qX(nullAsNil);
                        if (c16527d != null) {
                            c16527d.field_username = str;
                        }
                        C41747z.aeR().delete(nullAsNil);
                        c7616ad.mo14709iH(nullAsNil);
                    }
                    c7616ad.setUsername(str);
                    if (((int) c7616ad.ewQ) == 0) {
                        C9638aw.m17190ZK();
                        C18628c.m29078XM().mo15708aa(c7616ad);
                    }
                    if (((int) c7616ad.ewQ) <= 0) {
                        C4990ab.m7412e("MicroMsg.ContactWidgetNewBizInfo", "addContact : insert contact failed");
                    } else {
                        C1855t.m3960q(c7616ad);
                        C9638aw.m17190ZK();
                        c7616ad = C18628c.m29078XM().aoO(c7616ad.field_username);
                        if (c16527d != null) {
                            C41747z.aeR().mo43724d(c16527d);
                        } else {
                            C16527d qX = C17903f.m28104qX(c7616ad.field_username);
                            boolean z3;
                            if (c7616ad.dsf() && C32237a.adG()) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (qX == null || (qX.adJ() && !z3)) {
                                C4990ab.m7410d("MicroMsg.ContactWidgetNewBizInfo", "shouldUpdate");
                                C26417a.flu.mo20967ai(c7616ad.field_username, "");
                                C41730b.m73506pY(c7616ad.field_username);
                            } else if (c7616ad.dsi() && !z3) {
                                C4990ab.m7411d("MicroMsg.ContactWidgetNewBizInfo", "update contact, last check time=%d", Integer.valueOf(c7616ad.duj));
                                C26417a.flu.mo20967ai(c7616ad.field_username, "");
                                C41730b.m73506pY(c7616ad.field_username);
                            }
                        }
                    }
                }
                if (C43392b.this.pmI != null) {
                    C9430of c9430of = new C9430of();
                    C43392b.this.pmI.fPZ = 4;
                    c9430of.cKy.cKz = C43392b.this.pmI;
                    C4879a.xxA.mo10055m(c9430of);
                }
                c16527d = C41747z.aeR().mo43729qP(C43392b.this.ehM.field_username);
                c16527d.field_status = 1;
                if (!C5046bo.isNullOrNil(c16527d.field_extInfo) || C5046bo.isNullOrNil(c16527d.field_username) || C43392b.this.pkW == null || !c16527d.field_username.equals(C5046bo.nullAsNil(C43392b.this.pkW.field_username))) {
                    C41747z.aeR().mo43726e(c16527d);
                } else {
                    C41747z.aeR().mo43726e(C43392b.this.pkW);
                }
                boolean booleanExtra = C43392b.this.ppM.getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
                boolean booleanExtra2 = C43392b.this.ppM.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
                Intent intent;
                if (c16527d.adP()) {
                    intent = new Intent();
                    intent.putExtra("enterprise_biz_name", C43392b.this.ehM.field_username);
                    intent.putExtra("enterprise_biz_display_name", C1854s.m3866mJ(C43392b.this.ehM.field_username));
                    intent.putExtra("enterprise_from_scene", 7);
                    intent.addFlags(67108864);
                    C25985d.m41473f(C43392b.this.ppM, ".ui.conversation.EnterpriseConversationUI", intent);
                } else {
                    intent = new Intent();
                    intent.putExtra("Chat_User", C43392b.this.ehM.field_username);
                    intent.putExtra("key_has_add_contact", true);
                    intent.putExtra("finish_direct", true);
                    if (booleanExtra2) {
                        intent.addFlags(268435456);
                    }
                    C30309s.aom(C43392b.this.ehM.field_username);
                    C39503b.gkE.mo38915d(intent, C43392b.this.ppM);
                    if (!booleanExtra) {
                    }
                }
                C43392b.this.ppM.finish();
                C43392b.this.mo68939Bj(3);
            }
            AppMethodBeat.m2505o(23810);
        }
    }

    public C43392b(ContactInfoUI contactInfoUI, String str, C7285uy c7285uy) {
        this.ppM = contactInfoUI;
        this.pln = str;
        this.pmz = c7285uy;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0129  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        AppMethodBeat.m2504i(23811);
        if (this.ppM.isFinishing()) {
            AppMethodBeat.m2505o(23811);
        } else {
            boolean z2;
            String stringExtra;
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
            this.pmI = (SnsAdClick) this.ppM.getIntent().getParcelableExtra("KSnsAdTag");
            this.pmJ = this.ppM.getIntent().getStringExtra("key_add_contact_report_info");
            this.pmD = this.ppM.getIntent().getIntExtra("add_more_friend_search_scene", 0);
            this.pmH = this.ppM.getIntent().getBundleExtra("Contact_Ext_Args");
            this.ppM.setMMTitle("");
            this.ppM.mo17443ta(WebView.NIGHT_MODE_COLOR);
            this.ppM.mo17426pO(false);
            this.ppM.mo17446xE(-1);
            this.ppM.dyb();
            this.ppM.setBackBtn(new C214971(), C1318a.actionbar_icon_dark_back);
            Drawable drawable = this.ppM.getResources().getDrawable(C25738R.drawable.f6899uu);
            drawable.setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
            this.ppM.mo17378a(0, "", drawable, (OnMenuItemClickListener) new C214982());
            this.ppN = C34696c.cap().mo55342Va(this.ehM.field_username);
            caT();
            String str = c7616ad.field_username;
            if (this.ppN != null) {
                if (System.currentTimeMillis() - this.ppN.field_cacheTime < 60000) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    C4990ab.m7416i("MicroMsg.ContactWidgetNewBizInfo", "not obtailBizInfoFromCgi, use cache");
                    stringExtra = this.ppM.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        this.ppM.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
                        C30379h.m48443a(this.ppM, stringExtra, "", this.ppM.getString(C25738R.string.f9187s6), null);
                    }
                    if (c7616ad != null) {
                        C41747z.afd().mo52930qB(c7616ad.field_username);
                    }
                    AppMethodBeat.m2505o(23811);
                }
            }
            C1196a c1196a = new C1196a();
            c1196a.fsI = 2656;
            c1196a.uri = "/cgi-bin/mmbiz-bin/bizattr/bizprofile";
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            C40539kt c40539kt = new C40539kt();
            c40539kt.vMR = str;
            c40539kt.vOl = C30309s.getSessionId();
            c40539kt.Scene = this.gwP;
            c1196a.fsJ = c40539kt;
            c1196a.fsK = new C40540ku();
            C1226w.m2656a(c1196a.acD(), new C433914(), false, this.ppM instanceof C5685b ? this.ppM : null);
            stringExtra = this.ppM.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
            if (C5046bo.isNullOrNil(stringExtra)) {
            }
            if (c7616ad != null) {
            }
            AppMethodBeat.m2505o(23811);
        }
        return true;
    }

    private void cbE() {
        AppMethodBeat.m2504i(23812);
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
            qX.field_type = qX.mo30481cJ(false).getServiceType();
        }
        if (qX != null && qX.field_brandInfo == null && qX.field_extInfo == null && this.pmz != null) {
            qX.field_username = this.ehM.field_username;
            qX.field_brandFlag = this.pmz.gvb;
            qX.field_brandIconURL = this.pmz.gve;
            qX.field_brandInfo = this.pmz.gvd;
            qX.field_extInfo = this.pmz.gvc;
            qX.field_type = qX.mo30481cJ(false).getServiceType();
        }
        if (qX != null) {
            this.pkW = qX;
            this.fuX = qX.adY();
            this.fuY = qX.mo30481cJ(false);
            this.pmy = this.fuY.getWxaEntryInfoList();
            if (this.fuY.aec() != null && this.fuY.aec().length() > 0) {
                this.fvh = this.fuY.aec();
            }
        }
        AppMethodBeat.m2505o(23812);
    }

    /* Access modifiers changed, original: final */
    public final void caT() {
        AppMethodBeat.m2504i(23813);
        biV();
        cbE();
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8487a3);
        NewBizInfoHeaderPreference newBizInfoHeaderPreference = (NewBizInfoHeaderPreference) this.ehK.aqO("contact_info_header_newbizinfo");
        if (newBizInfoHeaderPreference == null || C5046bo.isNullOrNil(this.ehM.field_username)) {
            C4990ab.m7420w("MicroMsg.ContactWidgetNewBizInfo", "head pref is null");
            this.ehK.mo27715ce("contact_info_header_bizinfo", true);
        } else {
            newBizInfoHeaderPreference.mo74083a(this.ehM, this.pln, this.pkW, this.ppN);
        }
        ((NewBizInfoDescPreference) this.ehK.aqO("contact_info_desc_newbizinfo")).ppN = this.ppN;
        this.ehK.mo27715ce("contact_info_footer_space", false);
        this.ehK.mo27715ce("contact_info_biz_space", true);
        if (this.ppN == null || !this.ppN.cbQ()) {
            this.ehK.mo27715ce("contact_info_biz_add", true);
            this.ehK.mo27715ce("contact_info_biz_go_chatting", true);
            this.ehK.mo27715ce("contact_info_biz_space", false);
        } else if (C7486a.m12942jh(this.ehM.field_type)) {
            this.ehK.mo27715ce("contact_info_biz_add", true);
            this.ehK.mo27715ce("contact_info_biz_go_chatting", false);
            ((NewBizInfoFollowPreference) this.ehK.aqO("contact_info_biz_go_chatting")).plh = this;
        } else {
            this.ehK.mo27715ce("contact_info_biz_add", false);
            this.ehK.mo27715ce("contact_info_biz_go_chatting", true);
        }
        if (this.ppN == null || !TextUtils.isEmpty(this.ppN.field_newBanReason)) {
            this.ehK.mo27715ce("contact_info_biz_loading", false);
            ((NewBizInfoLoadingPreference) this.ehK.aqO("contact_info_biz_loading")).mo24888a(this.ppN, cbF());
        } else {
            this.ehK.mo27715ce("contact_info_biz_loading", true);
        }
        if (!(this.ppN == null || isNormal() || C7486a.m12942jh(this.ehM.field_type))) {
            this.ppM.showOptionMenu(false);
        }
        if (this.ppN == null || !this.ppN.cbR()) {
            this.ehK.mo27715ce("contact_info_biz_menu_newbizinfo", true);
        } else {
            this.ehK.mo27715ce("contact_info_biz_menu_newbizinfo", false);
            if (this.ppN != null) {
                ((NewBizInfoMenuPreference) this.ehK.aqO("contact_info_biz_menu_newbizinfo")).mo68938a(this.ppN, this.ehM);
            }
        }
        if (this.ppN == null || !this.ppN.cbO()) {
            this.ehK.mo27715ce("contact_info_message_newbizinfo", true);
        } else {
            this.ehK.mo27715ce("contact_info_message_newbizinfo", false);
            ((NewBizInfoMessagePreference) this.ehK.aqO("contact_info_message_newbizinfo")).mo74085a(this.ppN, this.ehM);
        }
        if (this.ppN == null || !this.ppN.cbN() || cbG() == null) {
            this.ehK.mo27715ce("contact_info_all_message_newbizinfo", true);
        } else {
            this.ehK.mo27715ce("contact_info_all_message_newbizinfo", false);
            ((NewBizInfoAllMessagePreference) this.ehK.aqO("contact_info_all_message_newbizinfo")).ppN = this.ppN;
        }
        if (this.ppN == null || !isNormal() || this.pmy == null || this.pmy.size() <= 0) {
            this.ehK.mo27715ce("contact_info_new_bindwxainfo", true);
        } else {
            this.ehK.mo27715ce("contact_info_new_bindwxainfo", false);
            ((NewBizBindWxaInfoPreference) this.ehK.aqO("contact_info_new_bindwxainfo")).mo8225a(this.pkW, this.pmy);
        }
        C4990ab.m7411d("MicroMsg.ContactWidgetNewBizInfo", "KIsardDevice(%b)", Boolean.valueOf(this.ppM.getIntent().getBooleanExtra("KIsHardDevice", false)));
        if (this.ppM.getIntent() == null || !this.ppM.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            if (cbF()) {
                this.ehK.mo27715ce("contact_info_biz_loading", false);
                this.ehK.mo27715ce("contact_info_biz_add", true);
                this.ehK.mo27715ce("contact_info_biz_go_chatting", true);
                this.ehK.mo27715ce("contact_info_message_newbizinfo", true);
                this.ehK.mo27715ce("contact_info_biz_menu_newbizinfo", true);
                this.ehK.mo27715ce("contact_info_all_message_newbizinfo", true);
                this.ehK.mo27715ce("contact_info_new_bindwxainfo", true);
            }
            AppMethodBeat.m2505o(23813);
            return;
        }
        C4990ab.m7410d("MicroMsg.ContactWidgetNewBizInfo", "Hard device biz...");
        boolean caW = caW();
        C4990ab.m7411d("MicroMsg.ContactWidgetNewBizInfo", "contact.isContact()(%b), isHarDeviceBound(%b)", Boolean.valueOf(C7486a.m12942jh(this.ehM.field_type)), Boolean.valueOf(caW));
        if (!(C7486a.m12942jh(this.ehM.field_type) && caW)) {
            C4990ab.m7421w("MicroMsg.ContactWidgetNewBizInfo", "%s is not my hard biz contact", this.ehM.field_username);
            caU();
            Preference aqO = this.ehK.aqO("contact_info_biz_add");
            this.ehK.mo27715ce("contact_info_biz_add", false);
            if (aqO != null) {
                if (caW) {
                    aqO.setTitle((int) C25738R.string.auo);
                    AppMethodBeat.m2505o(23813);
                    return;
                }
                aqO.setTitle((int) C25738R.string.aua);
            }
        }
        AppMethodBeat.m2505o(23813);
    }

    /* Access modifiers changed, original: final */
    public final boolean isNormal() {
        AppMethodBeat.m2504i(23814);
        if (this.ppN == null || !this.ppN.isNormal() || cbF()) {
            AppMethodBeat.m2505o(23814);
            return false;
        }
        AppMethodBeat.m2505o(23814);
        return true;
    }

    private boolean cbF() {
        boolean z = true;
        AppMethodBeat.m2504i(23815);
        try {
            String aef = this.fuY.aef();
            if (C5046bo.isNullOrNil(aef)) {
                AppMethodBeat.m2505o(23815);
                return false;
            }
            long j = C5046bo.getLong(aef, 0);
            if (j <= 0 || j - (System.currentTimeMillis() / 1000) >= 0) {
                z = false;
            }
            C4990ab.m7411d("MicroMsg.ContactWidgetNewBizInfo", "isBizAccountTimeExpired:%b", Boolean.valueOf(z));
            AppMethodBeat.m2505o(23815);
            return z;
        } catch (Exception e) {
            AppMethodBeat.m2505o(23815);
            return false;
        }
    }

    private void caU() {
        AppMethodBeat.m2504i(23816);
        if (this.ehM == null || !((C1855t.m3921nG(this.ehM.field_username) || C1855t.m3931nQ(this.ehM.field_username)) && C7486a.m12942jh(this.ehM.field_type))) {
            this.ehK.mo27715ce("contact_info_biz_go_chatting", true);
            AppMethodBeat.m2505o(23816);
            return;
        }
        this.ehK.mo27715ce("contact_info_biz_go_chatting", false);
        AppMethodBeat.m2505o(23816);
    }

    private C16528a cbG() {
        AppMethodBeat.m2504i(23817);
        if (this.fuX == null || this.fuX.size() < 0) {
            C4990ab.m7420w("MicroMsg.ContactWidgetNewBizInfo", "brandInfoList is null not show all message");
            AppMethodBeat.m2505o(23817);
            return null;
        }
        for (C16528a c16528a : this.fuX) {
            if (c16528a.fvb.equals("__mp_wording__brandinfo_history_massmsg")) {
                AppMethodBeat.m2505o(23817);
                return c16528a;
            }
        }
        C4990ab.m7420w("MicroMsg.ContactWidgetNewBizInfo", "brandInfoList is null not show all message");
        AppMethodBeat.m2505o(23817);
        return null;
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(23818);
        if (this.ehK == null) {
            AppMethodBeat.m2505o(23818);
        } else {
            NewBizInfoHeaderPreference newBizInfoHeaderPreference = (NewBizInfoHeaderPreference) this.ehK.aqO("contact_info_header_newbizinfo");
            if (newBizInfoHeaderPreference != null) {
                newBizInfoHeaderPreference.onDetach();
            }
            AppMethodBeat.m2505o(23818);
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(23819);
        if (this.ppM == null) {
            C4990ab.m7412e("MicroMsg.ContactWidgetNewBizInfo", "null == context");
            AppMethodBeat.m2505o(23819);
            return;
        }
        C4990ab.m7417i("MicroMsg.ContactWidgetNewBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 != -1 || intent == null) {
                    AppMethodBeat.m2505o(23819);
                    return;
                }
                String stringExtra = intent.getStringExtra("be_send_card_name");
                String stringExtra2 = intent.getStringExtra("received_card_name");
                boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                String stringExtra3 = intent.getStringExtra("custom_send_text");
                C12519g.bOk().mo46462q(stringExtra, stringExtra2, booleanExtra);
                C12519g.bOk().mo46461eZ(stringExtra3, stringExtra2);
                C5670b.m8523i(this.ppM, this.ppM.getString(C25738R.string.bvk));
                AppMethodBeat.m2505o(23819);
                return;
            default:
                AppMethodBeat.m2505o(23819);
                return;
        }
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(23820);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key is null, return");
            AppMethodBeat.m2505o(23820);
            return false;
        }
        C4990ab.m7417i("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key:%s", str);
        if ("contact_info_biz_add".endsWith(str)) {
            if (C37918c.aaZ()) {
                C37918c.m64041a(this.ppM, C32791a.BIZ, this.ehM.field_username, new C433935());
            } else {
                caV();
            }
            if (this.pmD != 0) {
                C7060h.pYm.mo8381e(11263, Integer.valueOf(this.pmD), this.ehM.field_username);
            }
            C34739c.m57055cP(this.ehM.field_username, 200);
            AppMethodBeat.m2505o(23820);
            return true;
        } else if ("contact_info_all_message_newbizinfo".endsWith(str)) {
            String str2 = this.ppN.field_historyArticlesUrl;
            C4990ab.m7417i("MicroMsg.ContactWidgetNewBizInfo", "contact_info_all_message_newbizinfo click:%s", this.ppN.field_historyArticlesUrl);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.putExtra("geta8key_scene", 3);
            str2 = this.ppM.getIntent().getStringExtra("prePublishId");
            if (C5046bo.isNullOrNil(str2)) {
                intent.putExtra("prePublishId", "brand_profile");
            } else {
                intent.putExtra("prePublishId", str2);
                intent.putExtra("preUsername", this.ppM.getIntent().getStringExtra("preUsername"));
                intent.putExtra("preChatName", this.ppM.getIntent().getStringExtra("preChatName"));
            }
            intent.putExtra("preChatTYPE", this.ppM.getIntent().getIntExtra("preChatTYPE", 0));
            C25985d.m41467b(this.ppM, "webview", ".ui.tools.WebViewUI", intent);
            C34739c.m57055cP(this.ehM.field_username, 400);
            AppMethodBeat.m2505o(23820);
            return true;
        } else {
            AppMethodBeat.m2505o(23820);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final void caV() {
        AppMethodBeat.m2504i(23821);
        if (((NewBizInfoHeaderPreference) this.ehK.aqO("contact_info_header_newbizinfo")) != null) {
            NewBizInfoHeaderPreference.m86116jy(System.currentTimeMillis());
        }
        if (this.ppM.getIntent() != null && this.ppM.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            String stringExtra = this.ppM.getIntent().getStringExtra("KHardDeviceBindTicket");
            if (C5046bo.isNullOrNil(stringExtra)) {
                C4990ab.m7416i("MicroMsg.ContactWidgetNewBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
            } else if (!caW()) {
                C4990ab.m7411d("MicroMsg.ContactWidgetNewBizInfo", "IsHardDevice, bindTicket = %s", stringExtra);
                C9638aw.m17182Rg().mo14539a(536, (C1202f) this);
                C9315dc c9315dc = new C9315dc();
                c9315dc.cwj.cwl = stringExtra;
                c9315dc.cwj.opType = 1;
                C4879a.xxA.mo10055m(c9315dc);
                final C1207m c1207m = c9315dc.cwk.cwn;
                Context context = this.ppM;
                this.ppM.getString(C25738R.string.f9238tz);
                this.tipDialog = C30379h.m48458b(context, this.ppM.getString(C25738R.string.f9260un), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(23809);
                        C9638aw.m17182Rg().mo14546b(536, C43392b.this);
                        C9315dc c9315dc = new C9315dc();
                        c9315dc.cwj.opType = 2;
                        c9315dc.cwj.cwn = c1207m;
                        C4879a.xxA.mo10055m(c9315dc);
                        AppMethodBeat.m2505o(23809);
                    }
                });
                AppMethodBeat.m2505o(23821);
                return;
            }
        }
        C14916a c14916a = new C14916a(this.ppM, new C433947());
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(this.gwP));
        if (this.fvh != null) {
            c14916a.vjK = this.fvh;
        }
        if (!C5046bo.isNullOrNil(this.mGZ)) {
            c14916a.mGZ = this.mGZ;
        }
        c14916a.vjP = true;
        c14916a.vjQ = this.ppM.getIntent().getStringExtra("url");
        c14916a.jSW = C5494a.m8288MQ(this.ppM.getIntent().getIntExtra("qbarScene", -1));
        c14916a.mo27240a(this.ehM.field_username, linkedList, this.pmJ);
        cbH();
        AppMethodBeat.m2505o(23821);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cbH() {
        Throwable e;
        AppMethodBeat.m2504i(23822);
        Intent intent = this.ppM.getIntent();
        int Bk = C12866c.m20858Bk(intent.getIntExtra("Contact_Scene", 0));
        String stringExtra = intent.getStringExtra("preChatName");
        String stringExtra2 = intent.getStringExtra("preUsername");
        int aW = C12866c.m20860aW(intent.getIntExtra("preChatTYPE", 0), stringExtra);
        String stringExtra3 = intent.getStringExtra("rawUrl");
        String stringExtra4 = intent.getStringExtra("url");
        Bundle bundleExtra = intent.getBundleExtra("Contact_Ext_Args");
        String str = "";
        if (bundleExtra != null) {
            str = bundleExtra.getString("Contact_Ext_Args_Query_String", "");
        }
        int MQ = C5494a.m8288MQ(intent.getIntExtra("qbarScene", -1));
        String str2 = this.ehM.field_username;
        String str3 = "";
        if (C5046bo.isNullOrNil(str)) {
            str = str3;
        } else {
            try {
                str = URLEncoder.encode(C5046bo.nullAsNil(str), "UTF-8");
                try {
                    stringExtra3 = URLEncoder.encode(C5046bo.nullAsNil(stringExtra3), "UTF-8");
                    stringExtra4 = URLEncoder.encode(C5046bo.nullAsNil(stringExtra4), "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    C4990ab.printErrStackTrace("MicroMsg.ContactWidgetNewBizInfo", e, "", new Object[0]);
                    C7060h.pYm.mo8381e(16232, Integer.valueOf(Bk), Integer.valueOf(aW), stringExtra, stringExtra2, stringExtra3, stringExtra4, str, Integer.valueOf(MQ), str2);
                    if (!C5046bo.isNullOrNil(this.pmJ)) {
                    }
                    AppMethodBeat.m2505o(23822);
                }
            } catch (UnsupportedEncodingException e3) {
                e = e3;
                str = str3;
            }
        }
        C7060h.pYm.mo8381e(16232, Integer.valueOf(Bk), Integer.valueOf(aW), stringExtra, stringExtra2, stringExtra3, stringExtra4, str, Integer.valueOf(MQ), str2);
        if (C5046bo.isNullOrNil(this.pmJ)) {
            C7060h.pYm.mo8374X(16697, this.pmJ);
        }
        AppMethodBeat.m2505o(23822);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(23823);
        C4990ab.m7410d("MicroMsg.ContactWidgetNewBizInfo", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (c1207m == null) {
            C4990ab.m7412e("MicroMsg.ContactWidgetNewBizInfo", "scene == null");
            AppMethodBeat.m2505o(23823);
            return;
        }
        C9638aw.m17182Rg().mo14546b(c1207m.getType(), (C1202f) this);
        if (i == 0 && i2 == 0) {
            C4990ab.m7411d("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", Integer.valueOf(c1207m.getType()));
            if (c1207m.getType() == 536) {
                C9638aw.m17182Rg().mo14546b(536, (C1202f) this);
                caT();
            }
            AppMethodBeat.m2505o(23823);
            return;
        }
        C4990ab.m7413e("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", Integer.valueOf(c1207m.getType()));
        AppMethodBeat.m2505o(23823);
    }

    private boolean caW() {
        AppMethodBeat.m2504i(23824);
        if (this.ppM.getIntent() == null) {
            AppMethodBeat.m2505o(23824);
            return false;
        }
        String stringExtra = this.ppM.getIntent().getStringExtra("device_id");
        String stringExtra2 = this.ppM.getIntent().getStringExtra("device_type");
        C41980dg c41980dg = new C41980dg();
        c41980dg.cwu.ceI = stringExtra;
        c41980dg.cwu.cws = stringExtra2;
        C4879a.xxA.mo10055m(c41980dg);
        boolean z = c41980dg.cwv.cww;
        AppMethodBeat.m2505o(23824);
        return z;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Bj */
    public final void mo68939Bj(int i) {
        AppMethodBeat.m2504i(23825);
        if (this.pmH == null || !(this.gwP == 39 || this.gwP == 56 || this.gwP == 35 || this.gwP == 87 || this.gwP == 88 || this.gwP == 89 || this.gwP == 85)) {
            C4990ab.m7410d("MicroMsg.ContactWidgetNewBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
            AppMethodBeat.m2505o(23825);
        } else if (this.ehM == null) {
            C4990ab.m7416i("MicroMsg.ContactWidgetNewBizInfo", "contact is null.");
            AppMethodBeat.m2505o(23825);
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
            String str = nullAsNil + "," + i + "," + C5046bo.nullAsNil(this.ehM.field_username) + "," + i3 + "," + (System.currentTimeMillis() / 1000) + "," + string + "," + i2;
            if (C5046bo.isNullOrNil(null)) {
                str = str + ",," + nullAsNil2;
            } else {
                str = str + "," + null + "," + nullAsNil2;
            }
            C4990ab.m7419v("MicroMsg.ContactWidgetNewBizInfo", "report 10866: %s", str);
            C7060h.pYm.mo8374X(10866, str);
            AppMethodBeat.m2505o(23825);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m77439a(C43392b c43392b) {
        AppMethodBeat.m2504i(23826);
        C9293ai c9293ai = new C9293ai();
        c9293ai.ctg.userName = c43392b.ehM.field_username;
        C4879a.xxA.mo10055m(c9293ai);
        AppMethodBeat.m2505o(23826);
    }
}
