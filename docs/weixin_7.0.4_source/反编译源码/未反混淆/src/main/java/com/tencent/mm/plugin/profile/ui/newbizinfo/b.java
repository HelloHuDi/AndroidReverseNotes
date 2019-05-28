package com.tencent.mm.plugin.profile.ui.newbizinfo;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.ai;
import com.tencent.mm.g.a.dc;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.g.a.of;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.protocal.protobuf.kt;
import com.tencent.mm.protocal.protobuf.ku;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class b implements f, a {
    public long edh;
    com.tencent.mm.ui.base.preference.f ehK;
    public ad ehM;
    public long endTime;
    private List<d.a> fuX;
    private com.tencent.mm.aj.d.b fuY;
    private String fvh;
    public int gwP;
    public String mGZ;
    public d pkW;
    boolean pli;
    private String pln;
    private int pmD = 0;
    private Bundle pmH;
    SnsAdClick pmI = null;
    private String pmJ = null;
    public List<WxaEntryInfo> pmy;
    private uy pmz;
    ContactInfoUI ppM;
    public com.tencent.mm.plugin.profile.ui.newbizinfo.b.d ppN;
    private p tipDialog = null;

    public b(ContactInfoUI contactInfoUI, String str, uy uyVar) {
        this.ppM = contactInfoUI;
        this.pln = str;
        this.pmz = uyVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0129  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, ad adVar, boolean z, int i) {
        AppMethodBeat.i(23811);
        if (this.ppM.isFinishing()) {
            AppMethodBeat.o(23811);
        } else {
            boolean z2;
            String stringExtra;
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
            this.pmI = (SnsAdClick) this.ppM.getIntent().getParcelableExtra("KSnsAdTag");
            this.pmJ = this.ppM.getIntent().getStringExtra("key_add_contact_report_info");
            this.pmD = this.ppM.getIntent().getIntExtra("add_more_friend_search_scene", 0);
            this.pmH = this.ppM.getIntent().getBundleExtra("Contact_Ext_Args");
            this.ppM.setMMTitle("");
            this.ppM.ta(WebView.NIGHT_MODE_COLOR);
            this.ppM.pO(false);
            this.ppM.xE(-1);
            this.ppM.dyb();
            this.ppM.setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(23802);
                    b.this.ppM.onBackPressed();
                    AppMethodBeat.o(23802);
                    return true;
                }
            }, R.raw.actionbar_icon_dark_back);
            Drawable drawable = this.ppM.getResources().getDrawable(R.drawable.uu);
            drawable.setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
            this.ppM.a(0, "", drawable, (OnMenuItemClickListener) new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(23805);
                    com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(b.this.ppM, 1, false);
                    dVar.rBl = new c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(23803);
                            if (com.tencent.mm.n.a.jh(b.this.ehM.field_type)) {
                                if (b.this.ehM.Oe()) {
                                    if (s.aVO() && com.tencent.mm.aj.f.qZ(b.this.ehM.field_username)) {
                                        lVar.hi(5, R.string.auq);
                                    } else {
                                        lVar.hi(5, R.string.cvm);
                                    }
                                } else if (s.aVO() && com.tencent.mm.aj.f.qZ(b.this.ehM.field_username)) {
                                    lVar.hi(4, R.string.aum);
                                } else {
                                    lVar.hi(4, R.string.b1r);
                                }
                            }
                            lVar.hi(1, R.string.auk);
                            if (com.tencent.mm.n.a.jh(b.this.ehM.field_type)) {
                                lVar.hi(2, R.string.azw);
                                lVar.hi(3, R.string.av2);
                            }
                            AppMethodBeat.o(23803);
                        }
                    };
                    dVar.rBm = new n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(23804);
                            b bVar;
                            Intent intent;
                            switch (menuItem.getItemId()) {
                                case 1:
                                    bVar = b.this;
                                    intent = new Intent();
                                    intent.setClass(bVar.ppM, NewBizInfoMoreInofUI.class);
                                    intent.putExtra("Contact_User", bVar.ehM.field_username);
                                    if (bVar.ppM.getIntent() != null) {
                                        intent.putExtras(bVar.ppM.getIntent());
                                    }
                                    bVar.ppM.startActivity(intent);
                                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(bVar.ehM.field_username, 700);
                                    AppMethodBeat.o(23804);
                                    return;
                                case 2:
                                    bVar = b.this;
                                    intent = new Intent();
                                    intent.putExtra("Select_Talker_Name", bVar.ehM.field_username);
                                    intent.putExtra("Select_block_List", bVar.ehM.field_username);
                                    intent.putExtra("Select_Send_Card", true);
                                    intent.putExtra("Select_Conv_Type", 3);
                                    intent.putExtra("mutil_select_is_ret", true);
                                    com.tencent.mm.plugin.profile.b.gkE.a(intent, bVar.ppM);
                                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(bVar.ehM.field_username, 800);
                                    AppMethodBeat.o(23804);
                                    return;
                                case 3:
                                    bVar = b.this;
                                    intent = new Intent();
                                    intent.setClass(bVar.ppM, NewBizInfoSettingUI.class);
                                    intent.putExtra("Contact_User", bVar.ehM.field_username);
                                    intent.putExtra("key_start_biz_profile_setting_from_scene", 2);
                                    if (bVar.ppM.getIntent() != null) {
                                        intent.putExtras(bVar.ppM.getIntent());
                                    }
                                    bVar.ppM.startActivity(intent);
                                    AppMethodBeat.o(23804);
                                    return;
                                case 4:
                                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(b.this.ehM.field_username, i.SCENE_BIZ_SCROLL);
                                    com.tencent.mm.model.i.mn(b.this.ehM.field_username);
                                    b.a(b.this);
                                    if (!s.aVO() || com.tencent.mm.aj.f.qY(b.this.ehM.field_username)) {
                                        h.bQ(b.this.ppM, b.this.ppM.getString(R.string.cvn));
                                        AppMethodBeat.o(23804);
                                        return;
                                    }
                                case 5:
                                    t.x(b.this.ehM.field_username, true);
                                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(b.this.ehM.field_username, 904);
                                    b.a(b.this);
                                    if (!s.aVO() || com.tencent.mm.aj.f.qY(b.this.ehM.field_username)) {
                                        h.bQ(b.this.ppM, b.this.ppM.getString(R.string.a_k));
                                        AppMethodBeat.o(23804);
                                        return;
                                    }
                                default:
                                    ab.w("MicroMsg.ContactWidgetNewBizInfo", "default onMMMenuItemSelected err");
                                    break;
                            }
                            AppMethodBeat.o(23804);
                        }
                    };
                    dVar.cpD();
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(b.this.ehM.field_username, 600);
                    AppMethodBeat.o(23805);
                    return false;
                }
            });
            this.ppN = com.tencent.mm.plugin.profile.c.cap().Va(this.ehM.field_username);
            caT();
            String str = adVar.field_username;
            if (this.ppN != null) {
                if (System.currentTimeMillis() - this.ppN.field_cacheTime < 60000) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    ab.i("MicroMsg.ContactWidgetNewBizInfo", "not obtailBizInfoFromCgi, use cache");
                    stringExtra = this.ppM.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
                    if (!bo.isNullOrNil(stringExtra)) {
                        this.ppM.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
                        h.a(this.ppM, stringExtra, "", this.ppM.getString(R.string.s6), null);
                    }
                    if (adVar != null) {
                        z.afd().qB(adVar.field_username);
                    }
                    AppMethodBeat.o(23811);
                }
            }
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.fsI = 2656;
            aVar.uri = "/cgi-bin/mmbiz-bin/bizattr/bizprofile";
            aVar.fsL = 0;
            aVar.fsM = 0;
            kt ktVar = new kt();
            ktVar.vMR = str;
            ktVar.vOl = s.getSessionId();
            ktVar.Scene = this.gwP;
            aVar.fsJ = ktVar;
            aVar.fsK = new ku();
            w.a(aVar.acD(), new w.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                    AppMethodBeat.i(23807);
                    ab.i("MicroMsg.ContactWidgetNewBizInfo", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    ku kuVar = (ku) bVar.fsH.fsP;
                    if (i == 0 && i2 == 0 && kuVar != null) {
                        ab.d("MicroMsg.ContactWidgetNewBizInfo", "BizProfileResp:%d", Integer.valueOf(kuVar.vKQ.size()));
                        b.this.ppN = com.tencent.mm.plugin.profile.ui.newbizinfo.b.d.a(b.this.ehM.field_username, kuVar);
                        if (b.this.ppN != null) {
                            boolean z;
                            com.tencent.mm.plugin.profile.ui.newbizinfo.d.a cap = com.tencent.mm.plugin.profile.c.cap();
                            com.tencent.mm.plugin.profile.ui.newbizinfo.b.d dVar = b.this.ppN;
                            if (dVar == null) {
                                ab.e("MicroMsg.ProfileInfoStorage", "profileInfo is null, err");
                                z = false;
                            } else {
                                com.tencent.mm.plugin.profile.ui.newbizinfo.b.d dVar2 = new com.tencent.mm.plugin.profile.ui.newbizinfo.b.d();
                                dVar2.field_username = dVar.field_username;
                                boolean b = cap.b((com.tencent.mm.sdk.e.c) dVar2, new String[0]);
                                ab.i("MicroMsg.ProfileInfoStorage", "insertOrUpdate username:%s", dVar.field_username);
                                z = b ? cap.c(dVar, new String[0]) : cap.b((com.tencent.mm.sdk.e.c) dVar);
                            }
                            ab.i("MicroMsg.ContactWidgetNewBizInfo", "username:%s insert db :%b", b.this.ppN.field_username, Boolean.valueOf(z));
                        }
                        b.this.caT();
                        b bVar2 = b.this;
                        if (bVar2.ehM == null || bVar2.pkW == null || bVar2.ppN == null) {
                            ab.w("MicroMsg.ContactWidgetNewBizInfo", "reportUpdate fail, err");
                        } else {
                            int i3;
                            String str2 = bVar2.ehM.field_username;
                            int i4 = bVar2.gwP;
                            int i5 = bVar2.pkW.field_type;
                            long j = bVar2.edh;
                            if (com.tencent.mm.n.a.jh(bVar2.ehM.field_type)) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str2, i4, i5, j, i3, bVar2.ppN.field_originalArticleCount, bVar2.ppN.field_friendSubscribeCount, bVar2.pmy != null ? bVar2.pmy.size() : 0, com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.cE(bVar2.ppN.cbL()), com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.cF(bVar2.ppN.cbM()), bVar2.ppN.field_decryptUserName);
                            if (bVar2.ppN != null && bVar2.ppN.cbR()) {
                                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(bVar2.ehM.field_username, 104);
                            }
                            if (bVar2.ppN != null && bVar2.ppN.cbO()) {
                                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(bVar2.ehM.field_username, 101);
                            }
                            if (bVar2.ppN != null && bVar2.isNormal() && bVar2.pmy != null && bVar2.pmy.size() > 0) {
                                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(bVar2.ehM.field_username, 105);
                            }
                        }
                    }
                    AppMethodBeat.o(23807);
                    return 0;
                }
            }, false, this.ppM instanceof com.tencent.mm.vending.e.b ? this.ppM : null);
            stringExtra = this.ppM.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
            if (bo.isNullOrNil(stringExtra)) {
            }
            if (adVar != null) {
            }
            AppMethodBeat.o(23811);
        }
        return true;
    }

    private void cbE() {
        AppMethodBeat.i(23812);
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
            qX.field_type = qX.cJ(false).getServiceType();
        }
        if (qX != null && qX.field_brandInfo == null && qX.field_extInfo == null && this.pmz != null) {
            qX.field_username = this.ehM.field_username;
            qX.field_brandFlag = this.pmz.gvb;
            qX.field_brandIconURL = this.pmz.gve;
            qX.field_brandInfo = this.pmz.gvd;
            qX.field_extInfo = this.pmz.gvc;
            qX.field_type = qX.cJ(false).getServiceType();
        }
        if (qX != null) {
            this.pkW = qX;
            this.fuX = qX.adY();
            this.fuY = qX.cJ(false);
            this.pmy = this.fuY.getWxaEntryInfoList();
            if (this.fuY.aec() != null && this.fuY.aec().length() > 0) {
                this.fvh = this.fuY.aec();
            }
        }
        AppMethodBeat.o(23812);
    }

    /* Access modifiers changed, original: final */
    public final void caT() {
        AppMethodBeat.i(23813);
        biV();
        cbE();
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.a3);
        NewBizInfoHeaderPreference newBizInfoHeaderPreference = (NewBizInfoHeaderPreference) this.ehK.aqO("contact_info_header_newbizinfo");
        if (newBizInfoHeaderPreference == null || bo.isNullOrNil(this.ehM.field_username)) {
            ab.w("MicroMsg.ContactWidgetNewBizInfo", "head pref is null");
            this.ehK.ce("contact_info_header_bizinfo", true);
        } else {
            newBizInfoHeaderPreference.a(this.ehM, this.pln, this.pkW, this.ppN);
        }
        ((NewBizInfoDescPreference) this.ehK.aqO("contact_info_desc_newbizinfo")).ppN = this.ppN;
        this.ehK.ce("contact_info_footer_space", false);
        this.ehK.ce("contact_info_biz_space", true);
        if (this.ppN == null || !this.ppN.cbQ()) {
            this.ehK.ce("contact_info_biz_add", true);
            this.ehK.ce("contact_info_biz_go_chatting", true);
            this.ehK.ce("contact_info_biz_space", false);
        } else if (com.tencent.mm.n.a.jh(this.ehM.field_type)) {
            this.ehK.ce("contact_info_biz_add", true);
            this.ehK.ce("contact_info_biz_go_chatting", false);
            ((NewBizInfoFollowPreference) this.ehK.aqO("contact_info_biz_go_chatting")).plh = this;
        } else {
            this.ehK.ce("contact_info_biz_add", false);
            this.ehK.ce("contact_info_biz_go_chatting", true);
        }
        if (this.ppN == null || !TextUtils.isEmpty(this.ppN.field_newBanReason)) {
            this.ehK.ce("contact_info_biz_loading", false);
            ((NewBizInfoLoadingPreference) this.ehK.aqO("contact_info_biz_loading")).a(this.ppN, cbF());
        } else {
            this.ehK.ce("contact_info_biz_loading", true);
        }
        if (!(this.ppN == null || isNormal() || com.tencent.mm.n.a.jh(this.ehM.field_type))) {
            this.ppM.showOptionMenu(false);
        }
        if (this.ppN == null || !this.ppN.cbR()) {
            this.ehK.ce("contact_info_biz_menu_newbizinfo", true);
        } else {
            this.ehK.ce("contact_info_biz_menu_newbizinfo", false);
            if (this.ppN != null) {
                ((NewBizInfoMenuPreference) this.ehK.aqO("contact_info_biz_menu_newbizinfo")).a(this.ppN, this.ehM);
            }
        }
        if (this.ppN == null || !this.ppN.cbO()) {
            this.ehK.ce("contact_info_message_newbizinfo", true);
        } else {
            this.ehK.ce("contact_info_message_newbizinfo", false);
            ((NewBizInfoMessagePreference) this.ehK.aqO("contact_info_message_newbizinfo")).a(this.ppN, this.ehM);
        }
        if (this.ppN == null || !this.ppN.cbN() || cbG() == null) {
            this.ehK.ce("contact_info_all_message_newbizinfo", true);
        } else {
            this.ehK.ce("contact_info_all_message_newbizinfo", false);
            ((NewBizInfoAllMessagePreference) this.ehK.aqO("contact_info_all_message_newbizinfo")).ppN = this.ppN;
        }
        if (this.ppN == null || !isNormal() || this.pmy == null || this.pmy.size() <= 0) {
            this.ehK.ce("contact_info_new_bindwxainfo", true);
        } else {
            this.ehK.ce("contact_info_new_bindwxainfo", false);
            ((NewBizBindWxaInfoPreference) this.ehK.aqO("contact_info_new_bindwxainfo")).a(this.pkW, this.pmy);
        }
        ab.d("MicroMsg.ContactWidgetNewBizInfo", "KIsardDevice(%b)", Boolean.valueOf(this.ppM.getIntent().getBooleanExtra("KIsHardDevice", false)));
        if (this.ppM.getIntent() == null || !this.ppM.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            if (cbF()) {
                this.ehK.ce("contact_info_biz_loading", false);
                this.ehK.ce("contact_info_biz_add", true);
                this.ehK.ce("contact_info_biz_go_chatting", true);
                this.ehK.ce("contact_info_message_newbizinfo", true);
                this.ehK.ce("contact_info_biz_menu_newbizinfo", true);
                this.ehK.ce("contact_info_all_message_newbizinfo", true);
                this.ehK.ce("contact_info_new_bindwxainfo", true);
            }
            AppMethodBeat.o(23813);
            return;
        }
        ab.d("MicroMsg.ContactWidgetNewBizInfo", "Hard device biz...");
        boolean caW = caW();
        ab.d("MicroMsg.ContactWidgetNewBizInfo", "contact.isContact()(%b), isHarDeviceBound(%b)", Boolean.valueOf(com.tencent.mm.n.a.jh(this.ehM.field_type)), Boolean.valueOf(caW));
        if (!(com.tencent.mm.n.a.jh(this.ehM.field_type) && caW)) {
            ab.w("MicroMsg.ContactWidgetNewBizInfo", "%s is not my hard biz contact", this.ehM.field_username);
            caU();
            Preference aqO = this.ehK.aqO("contact_info_biz_add");
            this.ehK.ce("contact_info_biz_add", false);
            if (aqO != null) {
                if (caW) {
                    aqO.setTitle((int) R.string.auo);
                    AppMethodBeat.o(23813);
                    return;
                }
                aqO.setTitle((int) R.string.aua);
            }
        }
        AppMethodBeat.o(23813);
    }

    /* Access modifiers changed, original: final */
    public final boolean isNormal() {
        AppMethodBeat.i(23814);
        if (this.ppN == null || !this.ppN.isNormal() || cbF()) {
            AppMethodBeat.o(23814);
            return false;
        }
        AppMethodBeat.o(23814);
        return true;
    }

    private boolean cbF() {
        boolean z = true;
        AppMethodBeat.i(23815);
        try {
            String aef = this.fuY.aef();
            if (bo.isNullOrNil(aef)) {
                AppMethodBeat.o(23815);
                return false;
            }
            long j = bo.getLong(aef, 0);
            if (j <= 0 || j - (System.currentTimeMillis() / 1000) >= 0) {
                z = false;
            }
            ab.d("MicroMsg.ContactWidgetNewBizInfo", "isBizAccountTimeExpired:%b", Boolean.valueOf(z));
            AppMethodBeat.o(23815);
            return z;
        } catch (Exception e) {
            AppMethodBeat.o(23815);
            return false;
        }
    }

    private void caU() {
        AppMethodBeat.i(23816);
        if (this.ehM == null || !((t.nG(this.ehM.field_username) || t.nQ(this.ehM.field_username)) && com.tencent.mm.n.a.jh(this.ehM.field_type))) {
            this.ehK.ce("contact_info_biz_go_chatting", true);
            AppMethodBeat.o(23816);
            return;
        }
        this.ehK.ce("contact_info_biz_go_chatting", false);
        AppMethodBeat.o(23816);
    }

    private d.a cbG() {
        AppMethodBeat.i(23817);
        if (this.fuX == null || this.fuX.size() < 0) {
            ab.w("MicroMsg.ContactWidgetNewBizInfo", "brandInfoList is null not show all message");
            AppMethodBeat.o(23817);
            return null;
        }
        for (d.a aVar : this.fuX) {
            if (aVar.fvb.equals("__mp_wording__brandinfo_history_massmsg")) {
                AppMethodBeat.o(23817);
                return aVar;
            }
        }
        ab.w("MicroMsg.ContactWidgetNewBizInfo", "brandInfoList is null not show all message");
        AppMethodBeat.o(23817);
        return null;
    }

    public final boolean biV() {
        AppMethodBeat.i(23818);
        if (this.ehK == null) {
            AppMethodBeat.o(23818);
        } else {
            NewBizInfoHeaderPreference newBizInfoHeaderPreference = (NewBizInfoHeaderPreference) this.ehK.aqO("contact_info_header_newbizinfo");
            if (newBizInfoHeaderPreference != null) {
                newBizInfoHeaderPreference.onDetach();
            }
            AppMethodBeat.o(23818);
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(23819);
        if (this.ppM == null) {
            ab.e("MicroMsg.ContactWidgetNewBizInfo", "null == context");
            AppMethodBeat.o(23819);
            return;
        }
        ab.i("MicroMsg.ContactWidgetNewBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 != -1 || intent == null) {
                    AppMethodBeat.o(23819);
                    return;
                }
                String stringExtra = intent.getStringExtra("be_send_card_name");
                String stringExtra2 = intent.getStringExtra("received_card_name");
                boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                String stringExtra3 = intent.getStringExtra("custom_send_text");
                g.bOk().q(stringExtra, stringExtra2, booleanExtra);
                g.bOk().eZ(stringExtra3, stringExtra2);
                com.tencent.mm.ui.widget.snackbar.b.i(this.ppM, this.ppM.getString(R.string.bvk));
                AppMethodBeat.o(23819);
                return;
            default:
                AppMethodBeat.o(23819);
                return;
        }
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(23820);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key is null, return");
            AppMethodBeat.o(23820);
            return false;
        }
        ab.i("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key:%s", str);
        if ("contact_info_biz_add".endsWith(str)) {
            if (com.tencent.mm.model.gdpr.c.aaZ()) {
                com.tencent.mm.model.gdpr.c.a(this.ppM, com.tencent.mm.model.gdpr.a.BIZ, this.ehM.field_username, new com.tencent.mm.model.gdpr.b() {
                    public final void kL(int i) {
                        AppMethodBeat.i(23808);
                        if (i == 0) {
                            b.this.caV();
                        }
                        AppMethodBeat.o(23808);
                    }
                });
            } else {
                caV();
            }
            if (this.pmD != 0) {
                com.tencent.mm.plugin.report.service.h.pYm.e(11263, Integer.valueOf(this.pmD), this.ehM.field_username);
            }
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(this.ehM.field_username, 200);
            AppMethodBeat.o(23820);
            return true;
        } else if ("contact_info_all_message_newbizinfo".endsWith(str)) {
            String str2 = this.ppN.field_historyArticlesUrl;
            ab.i("MicroMsg.ContactWidgetNewBizInfo", "contact_info_all_message_newbizinfo click:%s", this.ppN.field_historyArticlesUrl);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.putExtra("geta8key_scene", 3);
            str2 = this.ppM.getIntent().getStringExtra("prePublishId");
            if (bo.isNullOrNil(str2)) {
                intent.putExtra("prePublishId", "brand_profile");
            } else {
                intent.putExtra("prePublishId", str2);
                intent.putExtra("preUsername", this.ppM.getIntent().getStringExtra("preUsername"));
                intent.putExtra("preChatName", this.ppM.getIntent().getStringExtra("preChatName"));
            }
            intent.putExtra("preChatTYPE", this.ppM.getIntent().getIntExtra("preChatTYPE", 0));
            com.tencent.mm.bp.d.b(this.ppM, "webview", ".ui.tools.WebViewUI", intent);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(this.ehM.field_username, 400);
            AppMethodBeat.o(23820);
            return true;
        } else {
            AppMethodBeat.o(23820);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final void caV() {
        AppMethodBeat.i(23821);
        if (((NewBizInfoHeaderPreference) this.ehK.aqO("contact_info_header_newbizinfo")) != null) {
            NewBizInfoHeaderPreference.jy(System.currentTimeMillis());
        }
        if (this.ppM.getIntent() != null && this.ppM.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            String stringExtra = this.ppM.getIntent().getStringExtra("KHardDeviceBindTicket");
            if (bo.isNullOrNil(stringExtra)) {
                ab.i("MicroMsg.ContactWidgetNewBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
            } else if (!caW()) {
                ab.d("MicroMsg.ContactWidgetNewBizInfo", "IsHardDevice, bindTicket = %s", stringExtra);
                aw.Rg().a(536, (f) this);
                dc dcVar = new dc();
                dcVar.cwj.cwl = stringExtra;
                dcVar.cwj.opType = 1;
                com.tencent.mm.sdk.b.a.xxA.m(dcVar);
                final m mVar = dcVar.cwk.cwn;
                Context context = this.ppM;
                this.ppM.getString(R.string.tz);
                this.tipDialog = h.b(context, this.ppM.getString(R.string.un), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(23809);
                        aw.Rg().b(536, b.this);
                        dc dcVar = new dc();
                        dcVar.cwj.opType = 2;
                        dcVar.cwj.cwn = mVar;
                        com.tencent.mm.sdk.b.a.xxA.m(dcVar);
                        AppMethodBeat.o(23809);
                    }
                });
                AppMethodBeat.o(23821);
                return;
            }
        }
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.ppM, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
            /* JADX WARNING: Missing block: B:62:0x0224, code skipped:
            if (r2 == false) goto L_0x0116;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(boolean z, boolean z2, String str, String str2) {
                AppMethodBeat.i(23810);
                if (z) {
                    d dVar;
                    h.bQ(b.this.ppM, b.this.ppM.getString(R.string.aul));
                    b.this.ehK.ce("contact_info_time_expired", true);
                    ad adVar = b.this.ehM;
                    if (adVar == null || bo.isNullOrNil(str)) {
                        ab.e("MicroMsg.ContactWidgetNewBizInfo", "respUsername == " + str + ", contact = " + adVar);
                    } else {
                        dVar = null;
                        if (t.mX(adVar.field_username)) {
                            String nullAsNil = bo.nullAsNil(adVar.field_username);
                            dVar = com.tencent.mm.aj.f.qX(nullAsNil);
                            if (dVar != null) {
                                dVar.field_username = str;
                            }
                            z.aeR().delete(nullAsNil);
                            adVar.iH(nullAsNil);
                        }
                        adVar.setUsername(str);
                        if (((int) adVar.ewQ) == 0) {
                            aw.ZK();
                            com.tencent.mm.model.c.XM().aa(adVar);
                        }
                        if (((int) adVar.ewQ) <= 0) {
                            ab.e("MicroMsg.ContactWidgetNewBizInfo", "addContact : insert contact failed");
                        } else {
                            t.q(adVar);
                            aw.ZK();
                            adVar = com.tencent.mm.model.c.XM().aoO(adVar.field_username);
                            if (dVar != null) {
                                z.aeR().d(dVar);
                            } else {
                                d qX = com.tencent.mm.aj.f.qX(adVar.field_username);
                                boolean z3;
                                if (adVar.dsf() && com.tencent.mm.aj.a.adG()) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (qX == null || (qX.adJ() && !z3)) {
                                    ab.d("MicroMsg.ContactWidgetNewBizInfo", "shouldUpdate");
                                    ao.a.flu.ai(adVar.field_username, "");
                                    com.tencent.mm.ah.b.pY(adVar.field_username);
                                } else if (adVar.dsi() && !z3) {
                                    ab.d("MicroMsg.ContactWidgetNewBizInfo", "update contact, last check time=%d", Integer.valueOf(adVar.duj));
                                    ao.a.flu.ai(adVar.field_username, "");
                                    com.tencent.mm.ah.b.pY(adVar.field_username);
                                }
                            }
                        }
                    }
                    if (b.this.pmI != null) {
                        of ofVar = new of();
                        b.this.pmI.fPZ = 4;
                        ofVar.cKy.cKz = b.this.pmI;
                        com.tencent.mm.sdk.b.a.xxA.m(ofVar);
                    }
                    dVar = z.aeR().qP(b.this.ehM.field_username);
                    dVar.field_status = 1;
                    if (!bo.isNullOrNil(dVar.field_extInfo) || bo.isNullOrNil(dVar.field_username) || b.this.pkW == null || !dVar.field_username.equals(bo.nullAsNil(b.this.pkW.field_username))) {
                        z.aeR().e(dVar);
                    } else {
                        z.aeR().e(b.this.pkW);
                    }
                    boolean booleanExtra = b.this.ppM.getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
                    boolean booleanExtra2 = b.this.ppM.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
                    Intent intent;
                    if (dVar.adP()) {
                        intent = new Intent();
                        intent.putExtra("enterprise_biz_name", b.this.ehM.field_username);
                        intent.putExtra("enterprise_biz_display_name", com.tencent.mm.model.s.mJ(b.this.ehM.field_username));
                        intent.putExtra("enterprise_from_scene", 7);
                        intent.addFlags(67108864);
                        com.tencent.mm.bp.d.f(b.this.ppM, ".ui.conversation.EnterpriseConversationUI", intent);
                    } else {
                        intent = new Intent();
                        intent.putExtra("Chat_User", b.this.ehM.field_username);
                        intent.putExtra("key_has_add_contact", true);
                        intent.putExtra("finish_direct", true);
                        if (booleanExtra2) {
                            intent.addFlags(268435456);
                        }
                        s.aom(b.this.ehM.field_username);
                        com.tencent.mm.plugin.profile.b.gkE.d(intent, b.this.ppM);
                        if (!booleanExtra) {
                        }
                    }
                    b.this.ppM.finish();
                    b.this.Bj(3);
                }
                AppMethodBeat.o(23810);
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
        aVar.vjQ = this.ppM.getIntent().getStringExtra("url");
        aVar.jSW = e.a.MQ(this.ppM.getIntent().getIntExtra("qbarScene", -1));
        aVar.a(this.ehM.field_username, linkedList, this.pmJ);
        cbH();
        AppMethodBeat.o(23821);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cbH() {
        Throwable e;
        AppMethodBeat.i(23822);
        Intent intent = this.ppM.getIntent();
        int Bk = com.tencent.mm.plugin.profile.ui.newbizinfo.b.c.Bk(intent.getIntExtra("Contact_Scene", 0));
        String stringExtra = intent.getStringExtra("preChatName");
        String stringExtra2 = intent.getStringExtra("preUsername");
        int aW = com.tencent.mm.plugin.profile.ui.newbizinfo.b.c.aW(intent.getIntExtra("preChatTYPE", 0), stringExtra);
        String stringExtra3 = intent.getStringExtra("rawUrl");
        String stringExtra4 = intent.getStringExtra("url");
        Bundle bundleExtra = intent.getBundleExtra("Contact_Ext_Args");
        String str = "";
        if (bundleExtra != null) {
            str = bundleExtra.getString("Contact_Ext_Args_Query_String", "");
        }
        int MQ = e.a.MQ(intent.getIntExtra("qbarScene", -1));
        String str2 = this.ehM.field_username;
        String str3 = "";
        if (bo.isNullOrNil(str)) {
            str = str3;
        } else {
            try {
                str = URLEncoder.encode(bo.nullAsNil(str), "UTF-8");
                try {
                    stringExtra3 = URLEncoder.encode(bo.nullAsNil(stringExtra3), "UTF-8");
                    stringExtra4 = URLEncoder.encode(bo.nullAsNil(stringExtra4), "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    ab.printErrStackTrace("MicroMsg.ContactWidgetNewBizInfo", e, "", new Object[0]);
                    com.tencent.mm.plugin.report.service.h.pYm.e(16232, Integer.valueOf(Bk), Integer.valueOf(aW), stringExtra, stringExtra2, stringExtra3, stringExtra4, str, Integer.valueOf(MQ), str2);
                    if (!bo.isNullOrNil(this.pmJ)) {
                    }
                    AppMethodBeat.o(23822);
                }
            } catch (UnsupportedEncodingException e3) {
                e = e3;
                str = str3;
            }
        }
        com.tencent.mm.plugin.report.service.h.pYm.e(16232, Integer.valueOf(Bk), Integer.valueOf(aW), stringExtra, stringExtra2, stringExtra3, stringExtra4, str, Integer.valueOf(MQ), str2);
        if (bo.isNullOrNil(this.pmJ)) {
            com.tencent.mm.plugin.report.service.h.pYm.X(16697, this.pmJ);
        }
        AppMethodBeat.o(23822);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(23823);
        ab.d("MicroMsg.ContactWidgetNewBizInfo", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (mVar == null) {
            ab.e("MicroMsg.ContactWidgetNewBizInfo", "scene == null");
            AppMethodBeat.o(23823);
            return;
        }
        aw.Rg().b(mVar.getType(), (f) this);
        if (i == 0 && i2 == 0) {
            ab.d("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", Integer.valueOf(mVar.getType()));
            if (mVar.getType() == 536) {
                aw.Rg().b(536, (f) this);
                caT();
            }
            AppMethodBeat.o(23823);
            return;
        }
        ab.e("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", Integer.valueOf(mVar.getType()));
        AppMethodBeat.o(23823);
    }

    private boolean caW() {
        AppMethodBeat.i(23824);
        if (this.ppM.getIntent() == null) {
            AppMethodBeat.o(23824);
            return false;
        }
        String stringExtra = this.ppM.getIntent().getStringExtra("device_id");
        String stringExtra2 = this.ppM.getIntent().getStringExtra("device_type");
        dg dgVar = new dg();
        dgVar.cwu.ceI = stringExtra;
        dgVar.cwu.cws = stringExtra2;
        com.tencent.mm.sdk.b.a.xxA.m(dgVar);
        boolean z = dgVar.cwv.cww;
        AppMethodBeat.o(23824);
        return z;
    }

    /* Access modifiers changed, original: final */
    public final void Bj(int i) {
        AppMethodBeat.i(23825);
        if (this.pmH == null || !(this.gwP == 39 || this.gwP == 56 || this.gwP == 35 || this.gwP == 87 || this.gwP == 88 || this.gwP == 89 || this.gwP == 85)) {
            ab.d("MicroMsg.ContactWidgetNewBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
            AppMethodBeat.o(23825);
        } else if (this.ehM == null) {
            ab.i("MicroMsg.ContactWidgetNewBizInfo", "contact is null.");
            AppMethodBeat.o(23825);
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
            String str = nullAsNil + "," + i + "," + bo.nullAsNil(this.ehM.field_username) + "," + i3 + "," + (System.currentTimeMillis() / 1000) + "," + string + "," + i2;
            if (bo.isNullOrNil(null)) {
                str = str + ",," + nullAsNil2;
            } else {
                str = str + "," + null + "," + nullAsNil2;
            }
            ab.v("MicroMsg.ContactWidgetNewBizInfo", "report 10866: %s", str);
            com.tencent.mm.plugin.report.service.h.pYm.X(10866, str);
            AppMethodBeat.o(23825);
        }
    }

    static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(23826);
        ai aiVar = new ai();
        aiVar.ctg.userName = bVar.ehM.field_username;
        com.tencent.mm.sdk.b.a.xxA.m(aiVar);
        AppMethodBeat.o(23826);
    }
}
