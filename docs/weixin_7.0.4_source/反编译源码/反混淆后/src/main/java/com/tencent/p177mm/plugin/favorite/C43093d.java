package com.tencent.p177mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.google.android.gms.auth.api.accounttransfer.AccountTransferStatusCodes;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.p874a.C42218c;
import com.tencent.p177mm.p1186bq.C18114a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p198aw.C9059f;
import com.tencent.p177mm.p230g.p231a.C18313ld;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a.C5649b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fav.p407a.C11853i;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C39038m;
import com.tencent.p177mm.plugin.fav.p407a.C39038m.C20676b;
import com.tencent.p177mm.plugin.fav.p407a.C39038m.C27971a;
import com.tencent.p177mm.plugin.fav.p410ui.C11909i.C11914a;
import com.tencent.p177mm.pluginsdk.C30034d;
import com.tencent.p177mm.pluginsdk.model.C46496d;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35844g.C23273a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C44094a;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aau;
import com.tencent.p177mm.protocal.protobuf.aay;
import com.tencent.p177mm.protocal.protobuf.aaz;
import com.tencent.p177mm.protocal.protobuf.abe;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.protocal.protobuf.abo;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.favorite.d */
public final class C43093d {
    private static int[] mqq = new int[]{2131822651, 2131822652, 2131822653, 2131822654, 2131822655};

    /* renamed from: f */
    static /* synthetic */ void m76591f(Context context, C27966g c27966g, abh abh) {
        AppMethodBeat.m2504i(20523);
        C43093d.m76587c(context, c27966g, false, abh);
        AppMethodBeat.m2505o(20523);
    }

    /* renamed from: g */
    static /* synthetic */ void m76592g(Context context, C27966g c27966g, abh abh) {
        AppMethodBeat.m2504i(20524);
        C43093d.m76589d(context, c27966g, false, abh);
        AppMethodBeat.m2505o(20524);
    }

    /* renamed from: h */
    static /* synthetic */ void m76593h(Context context, C27966g c27966g, abh abh) {
        AppMethodBeat.m2504i(20525);
        C43093d.m76578a(context, c27966g, false, abh);
        AppMethodBeat.m2505o(20525);
    }

    /* renamed from: i */
    static /* synthetic */ void m76594i(Context context, C27966g c27966g, abh abh) {
        AppMethodBeat.m2504i(20526);
        C43093d.m76584b(context, c27966g, false, abh);
        AppMethodBeat.m2505o(20526);
    }

    /* renamed from: b */
    public static void m76583b(Context context, C27966g c27966g, abh abh) {
        AppMethodBeat.m2504i(20508);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.FavItemLogic", "Context is null");
            AppMethodBeat.m2505o(20508);
        } else if (c27966g == null) {
            C4990ab.m7420w("MicroMsg.FavItemLogic", "Fav item is null");
            AppMethodBeat.m2505o(20508);
        } else {
            C4990ab.m7417i("MicroMsg.FavItemLogic", "Handler favItemInfo id %d, type %d", Long.valueOf(c27966g.field_localId), Integer.valueOf(c27966g.field_type));
            Intent intent;
            String w;
            long j;
            String str;
            Intent intent2;
            switch (c27966g.field_type) {
                case -2:
                    Toast.makeText(context, C25738R.string.bs6, 0).show();
                    AppMethodBeat.m2505o(20508);
                    return;
                case 1:
                    Intent intent3 = new Intent();
                    intent3.putExtra("key_detail_text", c27966g.field_favProto.desc);
                    intent3.putExtra("key_detail_info_id", c27966g.field_localId);
                    intent3.putExtra("key_detail_can_share_to_friend", c27966g.but());
                    intent3.putExtra("key_detail_time", c27966g.field_updateTime);
                    intent3.putExtra("key_detail_create_time", c27966g.field_sourceCreateTime <= 0 ? c27966g.field_updateTime : c27966g.field_sourceCreateTime);
                    C43093d.m76581a(abh, intent3);
                    C11853i.m19721el("FavoriteTextDetailUI", abh.cvF);
                    C39037b.m66371b(context, ".ui.detail.FavoriteTextDetailUI", intent3);
                    AppMethodBeat.m2505o(20508);
                    return;
                case 2:
                    C43093d.m76590e(context, c27966g, abh);
                    AppMethodBeat.m2505o(20508);
                    return;
                case 3:
                    intent = new Intent();
                    C43093d.m76579a(c27966g, abh, intent);
                    intent.putExtra("key_detail_create_time", c27966g.field_favProto.wit.createTime);
                    C11853i.m19721el("FavoriteVoiceDetailUI", abh.cvF);
                    C39037b.m66371b(context, ".ui.detail.FavoriteVoiceDetailUI", intent);
                    AppMethodBeat.m2505o(20508);
                    return;
                case 4:
                    C43093d.m76588d(context, c27966g, abh);
                    AppMethodBeat.m2505o(20508);
                    return;
                case 5:
                    C43093d.m76589d(context, c27966g, true, abh);
                    AppMethodBeat.m2505o(20508);
                    return;
                case 6:
                    String mJ;
                    aay aay = c27966g.field_favProto.why;
                    String str2 = c27966g.field_favProto.hHV;
                    abl abl = c27966g.field_favProto.wit;
                    if (abl == null || C5046bo.isNullOrNil(abl.whU)) {
                        mJ = C1854s.m3866mJ(c27966g.field_fromUser);
                    } else {
                        mJ = C1854s.m3866mJ(abl.whU);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (c27966g.field_tagProto.wiJ != null) {
                        arrayList.addAll(c27966g.field_tagProto.wiJ);
                    }
                    C11853i.m19721el("RedirectUI", abh.cvF);
                    C39037b.m66351a(c27966g.field_localId, aay, mJ, str2, arrayList, context);
                    AppMethodBeat.m2505o(20508);
                    return;
                case 7:
                    String w2;
                    abl abl2 = c27966g.field_favProto.wit;
                    aar c = C39037b.m66378c(c27966g);
                    C5728b c5728b = new C5728b(C39037b.m66379c(c));
                    if (c5728b.exists()) {
                        w2 = C5736j.m8649w(c5728b.dMD());
                    } else if (c.cvq == null) {
                        w2 = "";
                    } else {
                        c5728b = new C5728b(C39037b.bue() + C1178g.m2591x(c.cvq.getBytes()));
                        if (c5728b.exists()) {
                            w = C5736j.m8649w(c5728b.dMD());
                        } else {
                            w = "";
                        }
                        w2 = w;
                    }
                    C9058e a = C9059f.m16431a(6, null, c.title, c.desc, c.wgg, c.wgk, c.wgi, c.mnd, C39037b.bul(), w2, "", abl2.appId);
                    if (C39037b.m66390e(c)) {
                        C4990ab.m7416i("MicroMsg.FavItemLogic", "The music is playing, don't start play again");
                    } else {
                        C4990ab.m7416i("MicroMsg.FavItemLogic", " start play music");
                        C37494a.m63280b(a);
                    }
                    a.fKs = String.valueOf(c27966g.field_localId);
                    intent = new Intent();
                    intent.putExtra("key_scene", 2);
                    C11853i.m19721el("MusicMainUI", abh.cvF);
                    C25985d.m41467b(context, "music", ".ui.MusicMainUI", intent);
                    AppMethodBeat.m2505o(20508);
                    return;
                case 8:
                    C43093d.m76587c(context, c27966g, true, abh);
                    AppMethodBeat.m2505o(20508);
                    return;
                case 10:
                    C4990ab.m7411d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", Integer.valueOf(c27966g.field_id), Long.valueOf(c27966g.field_localId));
                    j = c27966g.field_localId;
                    str = c27966g.field_favProto.whC.info;
                    intent2 = new Intent();
                    intent2.putExtra("key_is_favorite_item", true);
                    intent2.putExtra("key_favorite_local_id", j);
                    intent2.putExtra("key_Product_xml", str);
                    intent2.putExtra("key_can_delete_favorite_item", true);
                    intent2.putExtra("key_ProductUI_getProductInfoScene", 3);
                    C25985d.m41467b(context, "scanner", ".ui.ProductUI", intent2);
                    AppMethodBeat.m2505o(20508);
                    return;
                case 11:
                    C4990ab.m7411d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", Integer.valueOf(c27966g.field_id), Long.valueOf(c27966g.field_localId));
                    intent = new Intent();
                    intent.putExtra("key_product_scene", 4);
                    intent.putExtra("key_product_info", c27966g.field_favProto.whC.info);
                    C25985d.m41467b(context, "product", ".ui.MallProductUI", intent);
                    AppMethodBeat.m2505o(20508);
                    return;
                case 12:
                case 15:
                    C4990ab.m7411d("MicroMsg.FavItemLogic", "start tv ui, fav id %d, fav local id %d", Integer.valueOf(c27966g.field_id), Long.valueOf(c27966g.field_localId));
                    j = c27966g.field_localId;
                    str = c27966g.field_favProto.whE.info;
                    intent2 = new Intent();
                    intent2.putExtra("key_TV_getProductInfoScene", 3);
                    intent2.putExtra("key_is_favorite_item", true);
                    intent2.putExtra("key_favorite_local_id", j);
                    intent2.putExtra("key_TV_xml", str);
                    intent2.putExtra("key_can_delete_favorite_item", true);
                    C25985d.m41467b(context, "shake", ".ui.TVInfoUI", intent2);
                    AppMethodBeat.m2505o(20508);
                    return;
                case 14:
                    C43093d.m76578a(context, c27966g, true, abh);
                    AppMethodBeat.m2505o(20508);
                    return;
                case 16:
                    aar c2 = C39037b.m66378c(c27966g);
                    if (c2 == null || c2.wgZ == null || (C5046bo.isNullOrNil(c2.wgZ.fiG) && C5046bo.isNullOrNil(c2.wgZ.fiK))) {
                        C43093d.m76588d(context, c27966g, abh);
                        AppMethodBeat.m2505o(20508);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.FavItemLogic", "it is ad sight.");
                    C43093d.m76586c(context, c27966g, abh);
                    AppMethodBeat.m2505o(20508);
                    return;
                case 17:
                    w = C39037b.m66378c(c27966g).desc;
                    C9638aw.m17190ZK();
                    C5135a Rn = C18628c.m29080XO().mo15260Rn(w);
                    if (Rn != null) {
                        Intent intent4 = new Intent();
                        intent4.putExtra("Contact_User", Rn.svN);
                        intent4.putExtra("Contact_Alias", Rn.dFl);
                        intent4.putExtra("Contact_Nick", Rn.nickname);
                        intent4.putExtra("Contact_QuanPin", Rn.gwG);
                        intent4.putExtra("Contact_PyInitial", Rn.gwF);
                        intent4.putExtra("Contact_Uin", Rn.pnz);
                        intent4.putExtra("Contact_Mobile_MD5", Rn.xZi);
                        intent4.putExtra("Contact_full_Mobile_MD5", Rn.xZj);
                        intent4.putExtra("Contact_QQNick", Rn.dtZ());
                        intent4.putExtra("User_From_Fmessage", false);
                        intent4.putExtra("Contact_Scene", Rn.scene);
                        intent4.putExtra("Contact_FMessageCard", true);
                        intent4.putExtra("Contact_RemarkName", Rn.gwK);
                        intent4.putExtra("Contact_VUser_Info_Flag", Rn.ufB);
                        intent4.putExtra("Contact_VUser_Info", Rn.duh);
                        intent4.putExtra("Contact_BrandIconURL", Rn.pln);
                        intent4.putExtra("Contact_Province", Rn.getProvince());
                        intent4.putExtra("Contact_City", Rn.getCity());
                        intent4.putExtra("Contact_Sex", Rn.dtS);
                        intent4.putExtra("Contact_Signature", Rn.signature);
                        intent4.putExtra("Contact_ShowUserName", false);
                        intent4.putExtra("Contact_KSnsIFlag", 0);
                        C11853i.m19721el("ContactInfoUI", abh.cvF);
                        C25985d.m41467b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent4);
                        C18114a.m28535Lu(Rn.scene);
                        AppMethodBeat.m2505o(20508);
                        return;
                    }
                    break;
                case 18:
                    C43093d.m76584b(context, c27966g, true, abh);
                    AppMethodBeat.m2505o(20508);
                    return;
                default:
                    C4990ab.m7421w("MicroMsg.FavItemLogic", "Do not match any type %d", Integer.valueOf(c27966g.field_type));
                    break;
            }
            AppMethodBeat.m2505o(20508);
        }
    }

    /* renamed from: a */
    private static void m76578a(Context context, C27966g c27966g, boolean z, abh abh) {
        AppMethodBeat.m2504i(20509);
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", c27966g.field_localId);
        intent.putExtra("show_share", z);
        intent.putExtra("prePublishId", "msgrecord_detail");
        intent.putExtra("preChatTYPE", 15);
        C43093d.m76581a(abh, intent);
        C11853i.m19721el("FavRecordDetailUI", abh.cvF);
        C25985d.m41467b(context, "record", ".ui.FavRecordDetailUI", intent);
        AppMethodBeat.m2505o(20509);
    }

    /* renamed from: b */
    private static void m76584b(Context context, C27966g c27966g, boolean z, abh abh) {
        AppMethodBeat.m2504i(20510);
        C4990ab.m7416i("MicroMsg.FavItemLogic", "click WNNoteItem, handleWNNoteItem");
        C18313ld c18313ld = new C18313ld();
        c18313ld.cGU.field_localId = c27966g.field_localId;
        if (c27966g.field_localId == -1) {
            c18313ld.cGU.cHa = 4;
        } else {
            c18313ld.cGU.cGW = c27966g.field_xml;
        }
        c18313ld.cGU.context = context;
        Bundle bundle = new Bundle();
        aaz aaz = c27966g.field_favProto.vzK;
        if (aaz != null) {
            bundle.putString("noteauthor", aaz.wim);
            bundle.putString("noteeditor", aaz.win);
        }
        bundle.putLong("edittime", c27966g.field_updateTime);
        c18313ld.cGU.cGZ = bundle;
        c18313ld.cGU.field_favProto = c27966g.field_favProto;
        c18313ld.cGU.type = 2;
        c18313ld.cGU.cHc = z;
        c18313ld.cGU.cHd = abh;
        C4879a.xxA.mo10055m(c18313ld);
        C11853i.m19721el("NoteEditorUI", abh.cvF);
        AppMethodBeat.m2505o(20510);
    }

    /* renamed from: c */
    private static void m76587c(Context context, C27966g c27966g, boolean z, abh abh) {
        AppMethodBeat.m2504i(20511);
        aar c = C39037b.m66378c(c27966g);
        Intent intent;
        if (abh != null && abh.cOi == 1) {
            intent = new Intent();
            intent.putExtra("key_detail_info_id", c27966g.field_localId);
            intent.putExtra("key_detail_open_way", true);
            intent.putExtra("show_share", z);
            C43093d.m76581a(abh, intent);
            C11853i.m19721el("FavoriteFileDetailUI", abh.cvF);
            C39037b.m66371b(context, ".ui.detail.FavoriteFileDetailUI", intent);
            AppMethodBeat.m2505o(20511);
        } else if (abh == null || abh.cOi != 2) {
            if (C39037b.m66393f(c)) {
                if (C39037b.m66396g(c)) {
                    C43093d.m76590e(context, c27966g, abh);
                    AppMethodBeat.m2505o(20511);
                    return;
                } else if (!C44094a.m79366M(C39037b.m66370b(c), c.wgo, 2)) {
                    AppMethodBeat.m2505o(20511);
                    return;
                }
            }
            intent = new Intent();
            intent.putExtra("key_detail_info_id", c27966g.field_localId);
            intent.putExtra("show_share", z);
            C43093d.m76581a(abh, intent);
            C11853i.m19721el("FavoriteFileDetailUI", abh.cvF);
            C39037b.m66371b(context, ".ui.detail.FavoriteFileDetailUI", intent);
            AppMethodBeat.m2505o(20511);
        } else {
            C44094a.m79370b((Activity) context, C39037b.m66370b(c), c.wgo, 2);
            AppMethodBeat.m2505o(20511);
        }
    }

    /* renamed from: H */
    private static String m76576H(C27966g c27966g) {
        AppMethodBeat.m2504i(20512);
        String str;
        if (c27966g.field_favProto == null) {
            AppMethodBeat.m2505o(20512);
            return null;
        } else if (c27966g.field_favProto.whA == null || C5046bo.isNullOrNil(c27966g.field_favProto.whA.canvasPageXml)) {
            LinkedList linkedList = c27966g.field_favProto.wiv;
            if (linkedList == null || linkedList.size() != 1) {
                AppMethodBeat.m2505o(20512);
                return null;
            }
            str = ((aar) linkedList.get(0)).canvasPageXml;
            AppMethodBeat.m2505o(20512);
            return str;
        } else {
            str = c27966g.field_favProto.whA.canvasPageXml;
            AppMethodBeat.m2505o(20512);
            return str;
        }
    }

    /* renamed from: I */
    private static String m76577I(C27966g c27966g) {
        AppMethodBeat.m2504i(20513);
        String str;
        if (c27966g.field_favProto == null) {
            AppMethodBeat.m2505o(20513);
            return null;
        } else if (c27966g.field_favProto.whA == null || C5046bo.isNullOrNil(c27966g.field_favProto.whA.thumbUrl)) {
            LinkedList linkedList = c27966g.field_favProto.wiv;
            if (linkedList == null || linkedList.size() != 1) {
                AppMethodBeat.m2505o(20513);
                return null;
            }
            str = ((aar) linkedList.get(0)).fgE;
            AppMethodBeat.m2505o(20513);
            return str;
        } else {
            str = c27966g.field_favProto.whA.thumbUrl;
            AppMethodBeat.m2505o(20513);
            return str;
        }
    }

    /* renamed from: d */
    private static void m76589d(Context context, C27966g c27966g, boolean z, abh abh) {
        AppMethodBeat.m2504i(20514);
        String H = C43093d.m76576H(c27966g);
        if (C5046bo.isNullOrNil(H)) {
            abl abl = c27966g.field_favProto.wit;
            H = "";
            String str = "";
            String str2 = "";
            if (c27966g.field_favProto.whA != null) {
                abu abu = c27966g.field_favProto.whA;
                H = abu.wiY;
                str = abu.title;
                str2 = abu.desc;
            }
            if (abl != null && C5046bo.isNullOrNil(r0)) {
                H = abl.link;
            }
            if (C5046bo.isNullOrNil(H)) {
                AppMethodBeat.m2505o(20514);
                return;
            }
            aar c = C39037b.m66378c(c27966g);
            if (c != null) {
                if (C5046bo.isNullOrNil(str)) {
                    str = c.title;
                }
                if (C5046bo.isNullOrNil(str2)) {
                    str2 = c.desc;
                }
            }
            C4990ab.m7411d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", Integer.valueOf(c27966g.field_id), Long.valueOf(c27966g.field_localId));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", H);
            intent.putExtra("showShare", z);
            intent.putExtra("is_favorite_item", true);
            intent.putExtra("fav_local_id", c27966g.field_localId);
            intent.putExtra("favorite_control_argument", c27966g.buv());
            intent.putExtra("sentUsername", c27966g.field_fromUser);
            if (!(abl == null || C5046bo.isNullOrNil(abl.csl))) {
                intent.putExtra("srcDisplayname", C1854s.m3866mJ(abl.csl));
            }
            intent.putExtra("mode", 1);
            intent.putExtra("geta8key_scene", 14);
            Bundle bundle = new Bundle();
            bundle.putString("key_snsad_statextstr", C39037b.m66378c(c27966g).cMn);
            bundle.putLong("favlocalid", c27966g.field_localId);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("from_scence", 4);
            String str3 = "fav_" + C1853r.m3846Yz() + "_" + c27966g.field_id;
            intent.putExtra("KPublisherId", str3);
            intent.putExtra("pre_username", c27966g.field_fromUser);
            intent.putExtra("prePublishId", str3);
            intent.putExtra("preChatTYPE", 14);
            intent.putExtra("share_report_pre_msg_url", H);
            intent.putExtra("share_report_pre_msg_title", str);
            intent.putExtra("share_report_pre_msg_desc", str2);
            intent.putExtra("share_report_pre_msg_icon_url", C43093d.m76577I(c27966g));
            intent.putExtra("share_report_pre_msg_appid", "");
            intent.putExtra("share_report_from_scene", 4);
            Bundle tL = C42218c.m74509tL(C46496d.class.getName());
            tL.putInt("mm_rpt_fav_id", c27966g.field_id);
            tL.putInt("key_detail_fav_scene", abh.scene);
            tL.putInt("key_detail_fav_sub_scene", abh.jSW);
            tL.putInt("key_detail_fav_index", abh.index);
            tL.putString("key_detail_fav_query", abh.query);
            tL.putString("key_detail_fav_sessionid", abh.cvF);
            tL.putString("key_detail_fav_tags", abh.mfg);
            C11853i.m19721el("WebViewUI", abh.cvF);
            intent.putExtra("mm_report_bundle", tL);
            intent.putExtra("geta8key_scene", 14);
            C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(20514);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("sns_landing_pages_xml", H);
        intent2.putExtra("sns_landig_pages_from_source", 7);
        intent2.putExtra("sns_landing_pages_share_thumb_url", C43093d.m76577I(c27966g));
        intent2.putExtra("sns_landing_favid", C1853r.m3846Yz() + "_" + c27966g.field_id);
        intent2.addFlags(268435456);
        C25985d.m41467b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent2);
        AppMethodBeat.m2505o(20514);
    }

    /* renamed from: c */
    private static void m76586c(Context context, C27966g c27966g, abh abh) {
        AppMethodBeat.m2504i(20515);
        C39038m.m66421a(C27971a.PlayIcon, c27966g);
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", c27966g.field_localId);
        C43093d.m76581a(abh, intent);
        C39037b.m66371b(context, ".ui.detail.FavoriteSightDetailUI", intent);
        AppMethodBeat.m2505o(20515);
    }

    /* renamed from: d */
    private static void m76588d(Context context, C27966g c27966g, abh abh) {
        AppMethodBeat.m2504i(20517);
        aar c = C39037b.m66378c(c27966g);
        if (C43093d.m76582a(context, c, c27966g)) {
            AppMethodBeat.m2505o(20517);
        } else if (C5046bo.isNullOrNil(c.wgq) || c.wgu <= 0) {
            C4990ab.m7421w("MicroMsg.FavItemLogic", "full md5[%s], fullsize[%d], start use url", c.wgq, Long.valueOf(c.wgu));
            String str = C39037b.m66378c(c27966g).wgg;
            if (C5046bo.isNullOrNil(str)) {
                str = C39037b.m66378c(c27966g).wgk;
            }
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7420w("MicroMsg.FavItemLogic", "onClick video url null, return");
                C43093d.m76586c(context, c27966g, abh);
                AppMethodBeat.m2505o(20517);
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("key_snsad_statextstr", c.cMn);
            bundle.putLong("favlocalid", c27966g.field_localId);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("rawUrl", str);
            intent.putExtra("is_favorite_item", true);
            intent.putExtra("fav_local_id", c27966g.field_localId);
            intent.putExtra("geta8key_scene", 14);
            C4990ab.m7411d("MicroMsg.FavItemLogic", "start video webview, fav id %d, fav local id %d", Integer.valueOf(c27966g.field_id), Long.valueOf(c27966g.field_localId));
            intent.putExtra("geta8key_scene", 14);
            C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(20517);
        } else {
            Intent intent2 = new Intent();
            C43093d.m76579a(c27966g, abh, intent2);
            C11853i.m19721el("FavoriteSightDetailUI", abh.cvF);
            C39037b.m66371b(context, ".ui.detail.FavoriteSightDetailUI", intent2);
            AppMethodBeat.m2505o(20517);
        }
    }

    /* renamed from: e */
    private static void m76590e(Context context, C27966g c27966g, abh abh) {
        AppMethodBeat.m2504i(20518);
        Intent intent = new Intent();
        C43093d.m76579a(c27966g, abh, intent);
        C11853i.m19721el("FavoriteImgDetailUI", abh.cvF);
        C39037b.m66371b(context, ".ui.detail.FavoriteImgDetailUI", intent);
        AppMethodBeat.m2505o(20518);
    }

    /* renamed from: a */
    private static void m76579a(C27966g c27966g, abh abh, Intent intent) {
        AppMethodBeat.m2504i(20519);
        C43093d.m76581a(abh, intent);
        intent.putExtra("key_detail_info_id", c27966g.field_localId);
        AppMethodBeat.m2505o(20519);
    }

    /* renamed from: a */
    private static void m76581a(abh abh, Intent intent) {
        AppMethodBeat.m2504i(20520);
        intent.putExtra("key_detail_fav_scene", abh.scene);
        intent.putExtra("key_detail_fav_sub_scene", abh.jSW);
        intent.putExtra("key_detail_fav_index", abh.index);
        intent.putExtra("key_detail_fav_query", abh.query);
        intent.putExtra("key_detail_fav_sessionid", abh.cvF);
        intent.putExtra("key_detail_fav_tags", abh.mfg);
        AppMethodBeat.m2505o(20520);
    }

    /* JADX WARNING: Removed duplicated region for block: B:168:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x03ed  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0405  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x038d  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0441 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x03c7  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x03f9  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0411  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m76580a(C23273a c23273a, final Context context, final C27966g c27966g) {
        String str = null;
        AppMethodBeat.m2504i(20521);
        if (c27966g != null && context != null) {
            String w;
            abu abu;
            aar c = C39037b.m66378c(c27966g);
            if (c27966g == null) {
                C4990ab.m7420w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
            } else {
                String LD;
                aar c2 = C39037b.m66378c(c27966g);
                C5728b c5728b;
                if (5 == c27966g.field_type) {
                    c5728b = new C5728b(C39037b.m66379c(c2));
                    if (c5728b.exists()) {
                        w = C5736j.m8649w(c5728b.dMD());
                    } else {
                        abu abu2 = c27966g.field_favProto.whA;
                        if (abu2 == null) {
                            w = null;
                        } else {
                            w = abu2.thumbUrl;
                        }
                        if (C5046bo.isNullOrNil(w)) {
                            w = c2.cvq;
                        }
                        w = C39037b.m66339LD(w);
                        if (C5046bo.isNullOrNil(w)) {
                            w = Integer.valueOf(C1318a.app_attach_file_icon_webpage);
                        }
                    }
                } else {
                    if (11 == c27966g.field_type || 10 == c27966g.field_type) {
                        abe abe = c27966g.field_favProto.whC;
                        if (abe != null) {
                            w = C39037b.m66339LD(abe.thumbUrl);
                            if (C5046bo.isNullOrNil(w)) {
                                w = Integer.valueOf(C1318a.app_attach_file_icon_unknow);
                            }
                        }
                    }
                    if (15 == c27966g.field_type || 12 == c27966g.field_type) {
                        abo abo = c27966g.field_favProto.whE;
                        if (abo != null) {
                            w = C39037b.m66339LD(abo.thumbUrl);
                            if (C5046bo.isNullOrNil(w)) {
                                w = Integer.valueOf(C1318a.app_attach_file_icon_unknow);
                            }
                        }
                    }
                    if (2 == c27966g.field_type || 7 == c27966g.field_type || 16 == c27966g.field_type || 4 == c27966g.field_type) {
                        c5728b = new C5728b(C39037b.m66379c(c2));
                        if (!c5728b.exists()) {
                            w = C39037b.m66339LD(c2.cvq);
                            if (C5046bo.isNullOrNil(w)) {
                                C39037b.m66359a(c27966g, c2);
                                w = C39037b.m66379c(c2);
                            }
                            if (C5046bo.isNullOrNil(w)) {
                                switch (c27966g.field_type) {
                                    case 2:
                                        w = Integer.valueOf(C25738R.drawable.avp);
                                        break;
                                    case 7:
                                        w = Integer.valueOf(C1318a.app_attach_file_icon_music);
                                        break;
                                    default:
                                        w = Integer.valueOf(C1318a.app_attach_file_icon_video);
                                        break;
                                }
                            }
                        }
                        w = C5736j.m8649w(c5728b.dMD());
                    } else if (!(3 == c27966g.field_type || 6 == c27966g.field_type)) {
                        C5135a Rn;
                        if (8 == c27966g.field_type) {
                            w = Integer.valueOf(C30034d.ail(c2.wgo));
                        } else if (17 == c27966g.field_type) {
                            C9638aw.m17190ZK();
                            Rn = C18628c.m29080XO().mo15260Rn(c2.desc);
                            w = (Rn.svN == null || Rn.svN.length() == 0) ? Integer.valueOf(C25738R.drawable.ad2) : new SpannableString(Rn.svN);
                        } else if (14 == c27966g.field_type && c27966g.field_favProto.wiv != null) {
                            Iterator it = c27966g.field_favProto.wiv.iterator();
                            while (it.hasNext()) {
                                aar aar = (aar) it.next();
                                if (aar.dataType != 1) {
                                    if (aar.dataType == 3) {
                                        w = Integer.valueOf(C1318a.app_attach_file_icon_voice);
                                        break;
                                    } else if (aar.dataType == 6) {
                                        w = Integer.valueOf(C1318a.app_attach_file_icon_location);
                                        break;
                                    } else if (aar.dataType == 8) {
                                        w = Integer.valueOf(C30034d.ail(aar.wgo));
                                        break;
                                    } else if (aar.dataType == 2 || aar.dataType == 7 || aar.dataType == 15 || aar.dataType == 4) {
                                        c5728b = new C5728b(C39037b.m66379c(aar));
                                        if (c5728b.exists()) {
                                            w = C5736j.m8649w(c5728b.dMD());
                                        } else {
                                            LD = C39037b.m66339LD(aar.cvq);
                                            if (C5046bo.isNullOrNil(LD)) {
                                                switch (aar.dataType) {
                                                    case 2:
                                                        w = Integer.valueOf(C25738R.drawable.avp);
                                                        break;
                                                    case 7:
                                                        w = Integer.valueOf(C1318a.app_attach_file_icon_music);
                                                        break;
                                                    default:
                                                        w = Integer.valueOf(C1318a.app_attach_file_icon_video);
                                                        break;
                                                }
                                            }
                                            w = LD;
                                        }
                                    } else if (aar.dataType == 5) {
                                        c5728b = new C5728b(C39037b.m66379c(aar));
                                        if (c5728b.exists()) {
                                            w = C5736j.m8649w(c5728b.dMD());
                                        } else {
                                            abu abu3 = aar.wgT.whA;
                                            if (abu3 == null) {
                                                LD = null;
                                            } else {
                                                LD = abu3.thumbUrl;
                                            }
                                            if (C5046bo.isNullOrNil(LD)) {
                                                LD = aar.cvq;
                                            }
                                            w = C39037b.m66339LD(LD);
                                            if (C5046bo.isNullOrNil(w)) {
                                                w = Integer.valueOf(C1318a.app_attach_file_icon_webpage);
                                            }
                                        }
                                    } else {
                                        if (aar.dataType == 10 || aar.dataType == 11) {
                                            abe abe2 = aar.wgT.whC;
                                            if (abe2 != null) {
                                                w = C39037b.m66339LD(abe2.thumbUrl);
                                                if (C5046bo.isNullOrNil(w)) {
                                                    w = Integer.valueOf(C1318a.app_attach_file_icon_unknow);
                                                }
                                            }
                                        }
                                        if (aar.dataType == 12 || aar.dataType == 14) {
                                            abo abo2 = aar.wgT.whE;
                                            if (abo2 != null) {
                                                w = C39037b.m66339LD(abo2.thumbUrl);
                                                if (C5046bo.isNullOrNil(w)) {
                                                    w = Integer.valueOf(C1318a.app_attach_file_icon_unknow);
                                                }
                                            }
                                        }
                                        if (aar.dataType == 16) {
                                            C9638aw.m17190ZK();
                                            Rn = C18628c.m29080XO().mo15260Rn(aar.desc);
                                            w = (Rn.svN == null || Rn.svN.length() == 0) ? Integer.valueOf(C25738R.drawable.ad2) : new SpannableString(Rn.svN);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (w instanceof String) {
                    if (w instanceof Integer) {
                        ((Integer) w).intValue();
                    }
                    w = null;
                } else {
                    w = w;
                }
                abu = c27966g.field_favProto.whA;
                switch (c27966g.field_type) {
                    case 1:
                        c23273a.ajC(c27966g.field_favProto.desc);
                        c23273a.djw();
                        c23273a.mo38967a(new C5649b() {
                            public final void bwF() {
                                AppMethodBeat.m2504i(AccountTransferStatusCodes.NOT_ALLOWED_SECURITY);
                                Intent intent = new Intent();
                                intent.putExtra("Retr_Msg_content", c27966g.field_favProto.desc);
                                C25985d.m41473f(context, ".ui.transmit.RetransmitPreviewUI", intent);
                                C5274b.m8053hL(context);
                                AppMethodBeat.m2505o(AccountTransferStatusCodes.NOT_ALLOWED_SECURITY);
                            }
                        });
                        AppMethodBeat.m2505o(20521);
                        return;
                    case 2:
                        c23273a.mo38971b(C5056d.aml(w), 3);
                        AppMethodBeat.m2505o(20521);
                        return;
                    case 4:
                        c23273a.mo38971b(C5056d.aml(w), 2);
                        AppMethodBeat.m2505o(20521);
                        return;
                    case 5:
                        if (abu == null || C5046bo.isNullOrNil(abu.title)) {
                            w = null;
                            LD = null;
                        } else {
                            LD = abu.title;
                            w = abu.desc;
                        }
                        if (C5046bo.isNullOrNil(LD)) {
                            LD = c.title;
                        }
                        C5046bo.isNullOrNil(w);
                        c23273a.ajC(new StringBuffer(context.getResources().getString(C25738R.string.f9248u9)).append(LD).toString());
                        AppMethodBeat.m2505o(20521);
                        return;
                    case 6:
                        c23273a.ajC(context.getString(C25738R.string.f9162rf) + c27966g.field_favProto.why.label);
                        AppMethodBeat.m2505o(20521);
                        return;
                    case 7:
                        if (!(abu == null || C5046bo.isNullOrNil(abu.title))) {
                            str = abu.title;
                        }
                        if (C5046bo.isNullOrNil(str)) {
                            str = c.title;
                        }
                        c23273a.ajC(new StringBuffer(context.getResources().getString(C25738R.string.f9174rs)).append(str).toString());
                        AppMethodBeat.m2505o(20521);
                        return;
                    case 8:
                        w = c27966g.field_favProto.title;
                        if (C5046bo.isNullOrNil(w)) {
                            w = c.title;
                        }
                        c23273a.ajC(new StringBuffer(context.getResources().getString(C25738R.string.f9140qr)).append(w).toString());
                        AppMethodBeat.m2505o(20521);
                        return;
                    case 14:
                        c23273a.ajC(new StringBuffer(context.getResources().getString(C25738R.string.f9212t5)).append(C11914a.m19797a(context, c27966g).title).toString());
                        AppMethodBeat.m2505o(20521);
                        return;
                    case 16:
                        c23273a.mo38971b(C5056d.aml(w), 2);
                        AppMethodBeat.m2505o(20521);
                        return;
                    case 18:
                        c23273a.ajC(new StringBuffer(context.getResources().getString(C25738R.string.f9186s5)).append(C11914a.m19797a(context, c27966g).desc.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, " ")).toString());
                        AppMethodBeat.m2505o(20521);
                        return;
                    default:
                        if (!(abu == null || C5046bo.isNullOrNil(abu.title))) {
                            str = abu.title;
                        }
                        if (C5046bo.isNullOrNil(str)) {
                            str = c.title;
                        }
                        c23273a.ajC(new StringBuffer(context.getResources().getString(C25738R.string.f8820fy)).append(str).toString());
                        AppMethodBeat.m2505o(20521);
                        return;
                }
            }
            w = null;
            if (w instanceof String) {
            }
            abu = c27966g.field_favProto.whA;
            switch (c27966g.field_type) {
                case 1:
                    break;
                case 2:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 14:
                    break;
                case 16:
                    break;
                case 18:
                    break;
                default:
                    break;
            }
        }
        C4990ab.m7420w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
        AppMethodBeat.m2505o(20521);
    }

    /* renamed from: b */
    public static void m76585b(C23273a c23273a, final Context context, final C27966g c27966g) {
        AppMethodBeat.m2504i(20522);
        if (c27966g == null || context == null) {
            C4990ab.m7420w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
            AppMethodBeat.m2505o(20522);
            return;
        }
        final aar c = C39037b.m66378c(c27966g);
        switch (c27966g.field_type) {
            case 1:
                c23273a.mo38967a(new C5649b() {
                    public final void bwF() {
                        AppMethodBeat.m2504i(AccountTransferStatusCodes.INVALID_REQUEST);
                        Intent intent = new Intent();
                        intent.putExtra("Retr_Msg_content", c27966g.field_favProto.desc);
                        C25985d.m41473f(context, ".ui.transmit.RetransmitPreviewUI", intent);
                        C5274b.m8053hL(context);
                        AppMethodBeat.m2505o(AccountTransferStatusCodes.INVALID_REQUEST);
                    }
                });
                AppMethodBeat.m2505o(20522);
                return;
            case 2:
                c23273a.mo38967a(new C5649b() {
                    public final void bwF() {
                        AppMethodBeat.m2504i(20506);
                        Intent intent = new Intent();
                        intent.putExtra("key_detail_info_id", c27966g.field_localId);
                        intent.putExtra("key_detail_data_id", c.mnd);
                        intent.putExtra("show_share", false);
                        C39037b.m66371b(context, ".ui.FavImgGalleryUI", intent);
                        AppMethodBeat.m2505o(20506);
                    }
                });
                AppMethodBeat.m2505o(20522);
                return;
            case 4:
            case 16:
                c23273a.mo38967a(new C5649b() {
                    public final void bwF() {
                        AppMethodBeat.m2504i(20507);
                        aar c = C39037b.m66378c(c27966g);
                        Intent intent;
                        if (c == null) {
                            C4990ab.m7412e("MicroMsg.FavItemLogic", "goPlayView, but dataitem is null , exit");
                            AppMethodBeat.m2505o(20507);
                        } else if (c.wgZ == null || (C5046bo.isNullOrNil(c.wgZ.fiG) && C5046bo.isNullOrNil(c.wgZ.fiK))) {
                            intent = new Intent();
                            intent.putExtra("key_detail_info_id", c27966g.field_localId);
                            intent.putExtra("key_detail_fav_path", C39037b.m66370b(c));
                            intent.putExtra("key_detail_fav_thumb_path", C39037b.m66379c(c));
                            intent.putExtra("key_detail_fav_video_duration", c.duration);
                            intent.putExtra("key_detail_statExtStr", c.cMn);
                            intent.putExtra("show_share", false);
                            C39037b.m66371b(context, ".ui.detail.FavoriteVideoPlayUI", intent);
                            AppMethodBeat.m2505o(20507);
                        } else {
                            C4990ab.m7416i("MicroMsg.FavItemLogic", "it is ad sight.use sight play");
                            intent = new Intent();
                            intent.putExtra("key_detail_info_id", c27966g.field_localId);
                            intent.putExtra("key_detail_data_id", c.mnd);
                            intent.putExtra("key_detail_can_delete", false);
                            C39037b.m66371b(context, ".ui.detail.FavoriteFileDetailUI", intent);
                            AppMethodBeat.m2505o(20507);
                        }
                    }
                });
                AppMethodBeat.m2505o(20522);
                return;
            case 5:
                c23273a.mo38967a(new C5649b() {
                    public final void bwF() {
                        AppMethodBeat.m2504i(AccountTransferStatusCodes.SESSION_INACTIVE);
                        C43093d.m76592g(context, c27966g, new abh());
                        AppMethodBeat.m2505o(AccountTransferStatusCodes.SESSION_INACTIVE);
                    }
                });
                AppMethodBeat.m2505o(20522);
                return;
            case 6:
                final aay aay = c27966g.field_favProto.why;
                c23273a.mo38967a(new C5649b() {
                    public final void bwF() {
                        AppMethodBeat.m2504i(AccountTransferStatusCodes.CHALLENGE_NOT_ALLOWED);
                        Intent intent = new Intent();
                        intent.putExtra("map_view_type", 1);
                        intent.putExtra("kwebmap_slat", aay.lat);
                        intent.putExtra("kwebmap_lng", aay.lng);
                        intent.putExtra("Kwebmap_locaion", aay.label);
                        intent.putExtra("kShowshare", false);
                        C25985d.m41467b(context, C8741b.LOCATION, ".ui.RedirectUI", intent);
                        AppMethodBeat.m2505o(AccountTransferStatusCodes.CHALLENGE_NOT_ALLOWED);
                    }
                });
                AppMethodBeat.m2505o(20522);
                return;
            case 8:
                c23273a.mo38967a(new C5649b() {
                    public final void bwF() {
                        AppMethodBeat.m2504i(AccountTransferStatusCodes.NO_DATA_AVAILABLE);
                        C43093d.m76591f(context, c27966g, new abh());
                        AppMethodBeat.m2505o(AccountTransferStatusCodes.NO_DATA_AVAILABLE);
                    }
                });
                AppMethodBeat.m2505o(20522);
                return;
            case 14:
                c23273a.mo38967a(new C5649b() {
                    public final void bwF() {
                        AppMethodBeat.m2504i(20505);
                        C43093d.m76593h(context, c27966g, new abh());
                        AppMethodBeat.m2505o(20505);
                    }
                });
                AppMethodBeat.m2505o(20522);
                return;
            case 18:
                c23273a.mo38967a(new C5649b() {
                    public final void bwF() {
                        AppMethodBeat.m2504i(20499);
                        C43093d.m76594i(context, c27966g, new abh());
                        AppMethodBeat.m2505o(20499);
                    }
                });
                break;
        }
        AppMethodBeat.m2505o(20522);
    }

    /* renamed from: a */
    private static boolean m76582a(Context context, aar aar, C27966g c27966g) {
        AppMethodBeat.m2504i(20516);
        aau aau = aar.wgZ;
        if (aau == null || C5046bo.isNullOrNil(aau.fiG)) {
            AppMethodBeat.m2505o(20516);
            return false;
        }
        C39038m.m66421a(C27971a.EnterCompleteVideo, c27966g);
        String c = C39037b.m66379c(aar);
        Intent intent = new Intent();
        intent.putExtra("IsAd", false);
        intent.putExtra("KStremVideoUrl", aau.fiG);
        intent.putExtra("StreamWording", aau.fiJ);
        intent.putExtra("StremWebUrl", aau.fiK);
        intent.putExtra("KThumUrl", aau.fiL);
        intent.putExtra("KSta_StremVideoAduxInfo", aau.fiM);
        intent.putExtra("KSta_StremVideoPublishId", aau.fiN);
        intent.putExtra("KSta_SourceType", 2);
        intent.putExtra("KSta_Scene", C20676b.Fav.value);
        intent.putExtra("KSta_FromUserName", c27966g.field_fromUser);
        intent.putExtra("KSta_FavID", c27966g.field_id);
        intent.putExtra("KSta_SnsStatExtStr", aar.cMn);
        intent.putExtra("KBlockFav", true);
        intent.putExtra("KMediaId", "fakeid_" + c27966g.field_id);
        intent.putExtra("KThumbPath", c);
        intent.putExtra("KMediaVideoTime", aau.wid);
        intent.putExtra("KMediaTitle", aau.fiI);
        C25985d.m41467b(context, "sns", ".ui.VideoAdPlayerUI", intent);
        AppMethodBeat.m2505o(20516);
        return true;
    }
}
