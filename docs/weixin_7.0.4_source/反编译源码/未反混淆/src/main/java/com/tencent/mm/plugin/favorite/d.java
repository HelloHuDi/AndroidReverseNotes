package com.tencent.mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.google.android.gms.auth.api.accounttransfer.AccountTransferStatusCodes;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.a;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.f;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.aaz;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.j;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    private static int[] mqq = new int[]{R.id.asx, R.id.asy, R.id.asz, R.id.at0, R.id.at1};

    static /* synthetic */ void f(Context context, g gVar, abh abh) {
        AppMethodBeat.i(20523);
        c(context, gVar, false, abh);
        AppMethodBeat.o(20523);
    }

    static /* synthetic */ void g(Context context, g gVar, abh abh) {
        AppMethodBeat.i(20524);
        d(context, gVar, false, abh);
        AppMethodBeat.o(20524);
    }

    static /* synthetic */ void h(Context context, g gVar, abh abh) {
        AppMethodBeat.i(20525);
        a(context, gVar, false, abh);
        AppMethodBeat.o(20525);
    }

    static /* synthetic */ void i(Context context, g gVar, abh abh) {
        AppMethodBeat.i(20526);
        b(context, gVar, false, abh);
        AppMethodBeat.o(20526);
    }

    public static void b(Context context, g gVar, abh abh) {
        AppMethodBeat.i(20508);
        if (context == null) {
            ab.w("MicroMsg.FavItemLogic", "Context is null");
            AppMethodBeat.o(20508);
        } else if (gVar == null) {
            ab.w("MicroMsg.FavItemLogic", "Fav item is null");
            AppMethodBeat.o(20508);
        } else {
            ab.i("MicroMsg.FavItemLogic", "Handler favItemInfo id %d, type %d", Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_type));
            Intent intent;
            String w;
            long j;
            String str;
            Intent intent2;
            switch (gVar.field_type) {
                case -2:
                    Toast.makeText(context, R.string.bs6, 0).show();
                    AppMethodBeat.o(20508);
                    return;
                case 1:
                    Intent intent3 = new Intent();
                    intent3.putExtra("key_detail_text", gVar.field_favProto.desc);
                    intent3.putExtra("key_detail_info_id", gVar.field_localId);
                    intent3.putExtra("key_detail_can_share_to_friend", gVar.but());
                    intent3.putExtra("key_detail_time", gVar.field_updateTime);
                    intent3.putExtra("key_detail_create_time", gVar.field_sourceCreateTime <= 0 ? gVar.field_updateTime : gVar.field_sourceCreateTime);
                    a(abh, intent3);
                    i.el("FavoriteTextDetailUI", abh.cvF);
                    b.b(context, ".ui.detail.FavoriteTextDetailUI", intent3);
                    AppMethodBeat.o(20508);
                    return;
                case 2:
                    e(context, gVar, abh);
                    AppMethodBeat.o(20508);
                    return;
                case 3:
                    intent = new Intent();
                    a(gVar, abh, intent);
                    intent.putExtra("key_detail_create_time", gVar.field_favProto.wit.createTime);
                    i.el("FavoriteVoiceDetailUI", abh.cvF);
                    b.b(context, ".ui.detail.FavoriteVoiceDetailUI", intent);
                    AppMethodBeat.o(20508);
                    return;
                case 4:
                    d(context, gVar, abh);
                    AppMethodBeat.o(20508);
                    return;
                case 5:
                    d(context, gVar, true, abh);
                    AppMethodBeat.o(20508);
                    return;
                case 6:
                    String mJ;
                    aay aay = gVar.field_favProto.why;
                    String str2 = gVar.field_favProto.hHV;
                    abl abl = gVar.field_favProto.wit;
                    if (abl == null || bo.isNullOrNil(abl.whU)) {
                        mJ = s.mJ(gVar.field_fromUser);
                    } else {
                        mJ = s.mJ(abl.whU);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (gVar.field_tagProto.wiJ != null) {
                        arrayList.addAll(gVar.field_tagProto.wiJ);
                    }
                    i.el("RedirectUI", abh.cvF);
                    b.a(gVar.field_localId, aay, mJ, str2, arrayList, context);
                    AppMethodBeat.o(20508);
                    return;
                case 7:
                    String w2;
                    abl abl2 = gVar.field_favProto.wit;
                    aar c = b.c(gVar);
                    com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(b.c(c));
                    if (bVar.exists()) {
                        w2 = j.w(bVar.dMD());
                    } else if (c.cvq == null) {
                        w2 = "";
                    } else {
                        bVar = new com.tencent.mm.vfs.b(b.bue() + com.tencent.mm.a.g.x(c.cvq.getBytes()));
                        if (bVar.exists()) {
                            w = j.w(bVar.dMD());
                        } else {
                            w = "";
                        }
                        w2 = w;
                    }
                    e a = f.a(6, null, c.title, c.desc, c.wgg, c.wgk, c.wgi, c.mnd, b.bul(), w2, "", abl2.appId);
                    if (b.e(c)) {
                        ab.i("MicroMsg.FavItemLogic", "The music is playing, don't start play again");
                    } else {
                        ab.i("MicroMsg.FavItemLogic", " start play music");
                        a.b(a);
                    }
                    a.fKs = String.valueOf(gVar.field_localId);
                    intent = new Intent();
                    intent.putExtra("key_scene", 2);
                    i.el("MusicMainUI", abh.cvF);
                    com.tencent.mm.bp.d.b(context, "music", ".ui.MusicMainUI", intent);
                    AppMethodBeat.o(20508);
                    return;
                case 8:
                    c(context, gVar, true, abh);
                    AppMethodBeat.o(20508);
                    return;
                case 10:
                    ab.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId));
                    j = gVar.field_localId;
                    str = gVar.field_favProto.whC.info;
                    intent2 = new Intent();
                    intent2.putExtra("key_is_favorite_item", true);
                    intent2.putExtra("key_favorite_local_id", j);
                    intent2.putExtra("key_Product_xml", str);
                    intent2.putExtra("key_can_delete_favorite_item", true);
                    intent2.putExtra("key_ProductUI_getProductInfoScene", 3);
                    com.tencent.mm.bp.d.b(context, "scanner", ".ui.ProductUI", intent2);
                    AppMethodBeat.o(20508);
                    return;
                case 11:
                    ab.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId));
                    intent = new Intent();
                    intent.putExtra("key_product_scene", 4);
                    intent.putExtra("key_product_info", gVar.field_favProto.whC.info);
                    com.tencent.mm.bp.d.b(context, "product", ".ui.MallProductUI", intent);
                    AppMethodBeat.o(20508);
                    return;
                case 12:
                case 15:
                    ab.d("MicroMsg.FavItemLogic", "start tv ui, fav id %d, fav local id %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId));
                    j = gVar.field_localId;
                    str = gVar.field_favProto.whE.info;
                    intent2 = new Intent();
                    intent2.putExtra("key_TV_getProductInfoScene", 3);
                    intent2.putExtra("key_is_favorite_item", true);
                    intent2.putExtra("key_favorite_local_id", j);
                    intent2.putExtra("key_TV_xml", str);
                    intent2.putExtra("key_can_delete_favorite_item", true);
                    com.tencent.mm.bp.d.b(context, "shake", ".ui.TVInfoUI", intent2);
                    AppMethodBeat.o(20508);
                    return;
                case 14:
                    a(context, gVar, true, abh);
                    AppMethodBeat.o(20508);
                    return;
                case 16:
                    aar c2 = b.c(gVar);
                    if (c2 == null || c2.wgZ == null || (bo.isNullOrNil(c2.wgZ.fiG) && bo.isNullOrNil(c2.wgZ.fiK))) {
                        d(context, gVar, abh);
                        AppMethodBeat.o(20508);
                        return;
                    }
                    ab.i("MicroMsg.FavItemLogic", "it is ad sight.");
                    c(context, gVar, abh);
                    AppMethodBeat.o(20508);
                    return;
                case 17:
                    w = b.c(gVar).desc;
                    aw.ZK();
                    bi.a Rn = c.XO().Rn(w);
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
                        i.el("ContactInfoUI", abh.cvF);
                        com.tencent.mm.bp.d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent4);
                        com.tencent.mm.bq.a.Lu(Rn.scene);
                        AppMethodBeat.o(20508);
                        return;
                    }
                    break;
                case 18:
                    b(context, gVar, true, abh);
                    AppMethodBeat.o(20508);
                    return;
                default:
                    ab.w("MicroMsg.FavItemLogic", "Do not match any type %d", Integer.valueOf(gVar.field_type));
                    break;
            }
            AppMethodBeat.o(20508);
        }
    }

    private static void a(Context context, g gVar, boolean z, abh abh) {
        AppMethodBeat.i(20509);
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", gVar.field_localId);
        intent.putExtra("show_share", z);
        intent.putExtra("prePublishId", "msgrecord_detail");
        intent.putExtra("preChatTYPE", 15);
        a(abh, intent);
        i.el("FavRecordDetailUI", abh.cvF);
        com.tencent.mm.bp.d.b(context, "record", ".ui.FavRecordDetailUI", intent);
        AppMethodBeat.o(20509);
    }

    private static void b(Context context, g gVar, boolean z, abh abh) {
        AppMethodBeat.i(20510);
        ab.i("MicroMsg.FavItemLogic", "click WNNoteItem, handleWNNoteItem");
        ld ldVar = new ld();
        ldVar.cGU.field_localId = gVar.field_localId;
        if (gVar.field_localId == -1) {
            ldVar.cGU.cHa = 4;
        } else {
            ldVar.cGU.cGW = gVar.field_xml;
        }
        ldVar.cGU.context = context;
        Bundle bundle = new Bundle();
        aaz aaz = gVar.field_favProto.vzK;
        if (aaz != null) {
            bundle.putString("noteauthor", aaz.wim);
            bundle.putString("noteeditor", aaz.win);
        }
        bundle.putLong("edittime", gVar.field_updateTime);
        ldVar.cGU.cGZ = bundle;
        ldVar.cGU.field_favProto = gVar.field_favProto;
        ldVar.cGU.type = 2;
        ldVar.cGU.cHc = z;
        ldVar.cGU.cHd = abh;
        com.tencent.mm.sdk.b.a.xxA.m(ldVar);
        i.el("NoteEditorUI", abh.cvF);
        AppMethodBeat.o(20510);
    }

    private static void c(Context context, g gVar, boolean z, abh abh) {
        AppMethodBeat.i(20511);
        aar c = b.c(gVar);
        Intent intent;
        if (abh != null && abh.cOi == 1) {
            intent = new Intent();
            intent.putExtra("key_detail_info_id", gVar.field_localId);
            intent.putExtra("key_detail_open_way", true);
            intent.putExtra("show_share", z);
            a(abh, intent);
            i.el("FavoriteFileDetailUI", abh.cvF);
            b.b(context, ".ui.detail.FavoriteFileDetailUI", intent);
            AppMethodBeat.o(20511);
        } else if (abh == null || abh.cOi != 2) {
            if (b.f(c)) {
                if (b.g(c)) {
                    e(context, gVar, abh);
                    AppMethodBeat.o(20511);
                    return;
                } else if (!com.tencent.mm.pluginsdk.ui.tools.a.M(b.b(c), c.wgo, 2)) {
                    AppMethodBeat.o(20511);
                    return;
                }
            }
            intent = new Intent();
            intent.putExtra("key_detail_info_id", gVar.field_localId);
            intent.putExtra("show_share", z);
            a(abh, intent);
            i.el("FavoriteFileDetailUI", abh.cvF);
            b.b(context, ".ui.detail.FavoriteFileDetailUI", intent);
            AppMethodBeat.o(20511);
        } else {
            com.tencent.mm.pluginsdk.ui.tools.a.b((Activity) context, b.b(c), c.wgo, 2);
            AppMethodBeat.o(20511);
        }
    }

    private static String H(g gVar) {
        AppMethodBeat.i(20512);
        String str;
        if (gVar.field_favProto == null) {
            AppMethodBeat.o(20512);
            return null;
        } else if (gVar.field_favProto.whA == null || bo.isNullOrNil(gVar.field_favProto.whA.canvasPageXml)) {
            LinkedList linkedList = gVar.field_favProto.wiv;
            if (linkedList == null || linkedList.size() != 1) {
                AppMethodBeat.o(20512);
                return null;
            }
            str = ((aar) linkedList.get(0)).canvasPageXml;
            AppMethodBeat.o(20512);
            return str;
        } else {
            str = gVar.field_favProto.whA.canvasPageXml;
            AppMethodBeat.o(20512);
            return str;
        }
    }

    private static String I(g gVar) {
        AppMethodBeat.i(20513);
        String str;
        if (gVar.field_favProto == null) {
            AppMethodBeat.o(20513);
            return null;
        } else if (gVar.field_favProto.whA == null || bo.isNullOrNil(gVar.field_favProto.whA.thumbUrl)) {
            LinkedList linkedList = gVar.field_favProto.wiv;
            if (linkedList == null || linkedList.size() != 1) {
                AppMethodBeat.o(20513);
                return null;
            }
            str = ((aar) linkedList.get(0)).fgE;
            AppMethodBeat.o(20513);
            return str;
        } else {
            str = gVar.field_favProto.whA.thumbUrl;
            AppMethodBeat.o(20513);
            return str;
        }
    }

    private static void d(Context context, g gVar, boolean z, abh abh) {
        AppMethodBeat.i(20514);
        String H = H(gVar);
        if (bo.isNullOrNil(H)) {
            abl abl = gVar.field_favProto.wit;
            H = "";
            String str = "";
            String str2 = "";
            if (gVar.field_favProto.whA != null) {
                abu abu = gVar.field_favProto.whA;
                H = abu.wiY;
                str = abu.title;
                str2 = abu.desc;
            }
            if (abl != null && bo.isNullOrNil(r0)) {
                H = abl.link;
            }
            if (bo.isNullOrNil(H)) {
                AppMethodBeat.o(20514);
                return;
            }
            aar c = b.c(gVar);
            if (c != null) {
                if (bo.isNullOrNil(str)) {
                    str = c.title;
                }
                if (bo.isNullOrNil(str2)) {
                    str2 = c.desc;
                }
            }
            ab.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", H);
            intent.putExtra("showShare", z);
            intent.putExtra("is_favorite_item", true);
            intent.putExtra("fav_local_id", gVar.field_localId);
            intent.putExtra("favorite_control_argument", gVar.buv());
            intent.putExtra("sentUsername", gVar.field_fromUser);
            if (!(abl == null || bo.isNullOrNil(abl.csl))) {
                intent.putExtra("srcDisplayname", s.mJ(abl.csl));
            }
            intent.putExtra("mode", 1);
            intent.putExtra("geta8key_scene", 14);
            Bundle bundle = new Bundle();
            bundle.putString("key_snsad_statextstr", b.c(gVar).cMn);
            bundle.putLong("favlocalid", gVar.field_localId);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("from_scence", 4);
            String str3 = "fav_" + r.Yz() + "_" + gVar.field_id;
            intent.putExtra("KPublisherId", str3);
            intent.putExtra("pre_username", gVar.field_fromUser);
            intent.putExtra("prePublishId", str3);
            intent.putExtra("preChatTYPE", 14);
            intent.putExtra("share_report_pre_msg_url", H);
            intent.putExtra("share_report_pre_msg_title", str);
            intent.putExtra("share_report_pre_msg_desc", str2);
            intent.putExtra("share_report_pre_msg_icon_url", I(gVar));
            intent.putExtra("share_report_pre_msg_appid", "");
            intent.putExtra("share_report_from_scene", 4);
            Bundle tL = com.tencent.mm.modelstat.a.c.tL(com.tencent.mm.pluginsdk.model.d.class.getName());
            tL.putInt("mm_rpt_fav_id", gVar.field_id);
            tL.putInt("key_detail_fav_scene", abh.scene);
            tL.putInt("key_detail_fav_sub_scene", abh.jSW);
            tL.putInt("key_detail_fav_index", abh.index);
            tL.putString("key_detail_fav_query", abh.query);
            tL.putString("key_detail_fav_sessionid", abh.cvF);
            tL.putString("key_detail_fav_tags", abh.mfg);
            i.el("WebViewUI", abh.cvF);
            intent.putExtra("mm_report_bundle", tL);
            intent.putExtra("geta8key_scene", 14);
            com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(20514);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("sns_landing_pages_xml", H);
        intent2.putExtra("sns_landig_pages_from_source", 7);
        intent2.putExtra("sns_landing_pages_share_thumb_url", I(gVar));
        intent2.putExtra("sns_landing_favid", r.Yz() + "_" + gVar.field_id);
        intent2.addFlags(268435456);
        com.tencent.mm.bp.d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent2);
        AppMethodBeat.o(20514);
    }

    private static void c(Context context, g gVar, abh abh) {
        AppMethodBeat.i(20515);
        m.a(m.a.PlayIcon, gVar);
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", gVar.field_localId);
        a(abh, intent);
        b.b(context, ".ui.detail.FavoriteSightDetailUI", intent);
        AppMethodBeat.o(20515);
    }

    private static void d(Context context, g gVar, abh abh) {
        AppMethodBeat.i(20517);
        aar c = b.c(gVar);
        if (a(context, c, gVar)) {
            AppMethodBeat.o(20517);
        } else if (bo.isNullOrNil(c.wgq) || c.wgu <= 0) {
            ab.w("MicroMsg.FavItemLogic", "full md5[%s], fullsize[%d], start use url", c.wgq, Long.valueOf(c.wgu));
            String str = b.c(gVar).wgg;
            if (bo.isNullOrNil(str)) {
                str = b.c(gVar).wgk;
            }
            if (bo.isNullOrNil(str)) {
                ab.w("MicroMsg.FavItemLogic", "onClick video url null, return");
                c(context, gVar, abh);
                AppMethodBeat.o(20517);
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("key_snsad_statextstr", c.cMn);
            bundle.putLong("favlocalid", gVar.field_localId);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("rawUrl", str);
            intent.putExtra("is_favorite_item", true);
            intent.putExtra("fav_local_id", gVar.field_localId);
            intent.putExtra("geta8key_scene", 14);
            ab.d("MicroMsg.FavItemLogic", "start video webview, fav id %d, fav local id %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId));
            intent.putExtra("geta8key_scene", 14);
            com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(20517);
        } else {
            Intent intent2 = new Intent();
            a(gVar, abh, intent2);
            i.el("FavoriteSightDetailUI", abh.cvF);
            b.b(context, ".ui.detail.FavoriteSightDetailUI", intent2);
            AppMethodBeat.o(20517);
        }
    }

    private static void e(Context context, g gVar, abh abh) {
        AppMethodBeat.i(20518);
        Intent intent = new Intent();
        a(gVar, abh, intent);
        i.el("FavoriteImgDetailUI", abh.cvF);
        b.b(context, ".ui.detail.FavoriteImgDetailUI", intent);
        AppMethodBeat.o(20518);
    }

    private static void a(g gVar, abh abh, Intent intent) {
        AppMethodBeat.i(20519);
        a(abh, intent);
        intent.putExtra("key_detail_info_id", gVar.field_localId);
        AppMethodBeat.o(20519);
    }

    private static void a(abh abh, Intent intent) {
        AppMethodBeat.i(20520);
        intent.putExtra("key_detail_fav_scene", abh.scene);
        intent.putExtra("key_detail_fav_sub_scene", abh.jSW);
        intent.putExtra("key_detail_fav_index", abh.index);
        intent.putExtra("key_detail_fav_query", abh.query);
        intent.putExtra("key_detail_fav_sessionid", abh.cvF);
        intent.putExtra("key_detail_fav_tags", abh.mfg);
        AppMethodBeat.o(20520);
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
    public static void a(com.tencent.mm.pluginsdk.ui.applet.g.a aVar, final Context context, final g gVar) {
        String str = null;
        AppMethodBeat.i(20521);
        if (gVar != null && context != null) {
            String w;
            abu abu;
            aar c = b.c(gVar);
            if (gVar == null) {
                ab.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
            } else {
                String LD;
                aar c2 = b.c(gVar);
                com.tencent.mm.vfs.b bVar;
                if (5 == gVar.field_type) {
                    bVar = new com.tencent.mm.vfs.b(b.c(c2));
                    if (bVar.exists()) {
                        w = j.w(bVar.dMD());
                    } else {
                        abu abu2 = gVar.field_favProto.whA;
                        if (abu2 == null) {
                            w = null;
                        } else {
                            w = abu2.thumbUrl;
                        }
                        if (bo.isNullOrNil(w)) {
                            w = c2.cvq;
                        }
                        w = b.LD(w);
                        if (bo.isNullOrNil(w)) {
                            w = Integer.valueOf(R.raw.app_attach_file_icon_webpage);
                        }
                    }
                } else {
                    if (11 == gVar.field_type || 10 == gVar.field_type) {
                        abe abe = gVar.field_favProto.whC;
                        if (abe != null) {
                            w = b.LD(abe.thumbUrl);
                            if (bo.isNullOrNil(w)) {
                                w = Integer.valueOf(R.raw.app_attach_file_icon_unknow);
                            }
                        }
                    }
                    if (15 == gVar.field_type || 12 == gVar.field_type) {
                        abo abo = gVar.field_favProto.whE;
                        if (abo != null) {
                            w = b.LD(abo.thumbUrl);
                            if (bo.isNullOrNil(w)) {
                                w = Integer.valueOf(R.raw.app_attach_file_icon_unknow);
                            }
                        }
                    }
                    if (2 == gVar.field_type || 7 == gVar.field_type || 16 == gVar.field_type || 4 == gVar.field_type) {
                        bVar = new com.tencent.mm.vfs.b(b.c(c2));
                        if (!bVar.exists()) {
                            w = b.LD(c2.cvq);
                            if (bo.isNullOrNil(w)) {
                                b.a(gVar, c2);
                                w = b.c(c2);
                            }
                            if (bo.isNullOrNil(w)) {
                                switch (gVar.field_type) {
                                    case 2:
                                        w = Integer.valueOf(R.drawable.avp);
                                        break;
                                    case 7:
                                        w = Integer.valueOf(R.raw.app_attach_file_icon_music);
                                        break;
                                    default:
                                        w = Integer.valueOf(R.raw.app_attach_file_icon_video);
                                        break;
                                }
                            }
                        }
                        w = j.w(bVar.dMD());
                    } else if (!(3 == gVar.field_type || 6 == gVar.field_type)) {
                        bi.a Rn;
                        if (8 == gVar.field_type) {
                            w = Integer.valueOf(com.tencent.mm.pluginsdk.d.ail(c2.wgo));
                        } else if (17 == gVar.field_type) {
                            aw.ZK();
                            Rn = c.XO().Rn(c2.desc);
                            w = (Rn.svN == null || Rn.svN.length() == 0) ? Integer.valueOf(R.drawable.ad2) : new SpannableString(Rn.svN);
                        } else if (14 == gVar.field_type && gVar.field_favProto.wiv != null) {
                            Iterator it = gVar.field_favProto.wiv.iterator();
                            while (it.hasNext()) {
                                aar aar = (aar) it.next();
                                if (aar.dataType != 1) {
                                    if (aar.dataType == 3) {
                                        w = Integer.valueOf(R.raw.app_attach_file_icon_voice);
                                        break;
                                    } else if (aar.dataType == 6) {
                                        w = Integer.valueOf(R.raw.app_attach_file_icon_location);
                                        break;
                                    } else if (aar.dataType == 8) {
                                        w = Integer.valueOf(com.tencent.mm.pluginsdk.d.ail(aar.wgo));
                                        break;
                                    } else if (aar.dataType == 2 || aar.dataType == 7 || aar.dataType == 15 || aar.dataType == 4) {
                                        bVar = new com.tencent.mm.vfs.b(b.c(aar));
                                        if (bVar.exists()) {
                                            w = j.w(bVar.dMD());
                                        } else {
                                            LD = b.LD(aar.cvq);
                                            if (bo.isNullOrNil(LD)) {
                                                switch (aar.dataType) {
                                                    case 2:
                                                        w = Integer.valueOf(R.drawable.avp);
                                                        break;
                                                    case 7:
                                                        w = Integer.valueOf(R.raw.app_attach_file_icon_music);
                                                        break;
                                                    default:
                                                        w = Integer.valueOf(R.raw.app_attach_file_icon_video);
                                                        break;
                                                }
                                            }
                                            w = LD;
                                        }
                                    } else if (aar.dataType == 5) {
                                        bVar = new com.tencent.mm.vfs.b(b.c(aar));
                                        if (bVar.exists()) {
                                            w = j.w(bVar.dMD());
                                        } else {
                                            abu abu3 = aar.wgT.whA;
                                            if (abu3 == null) {
                                                LD = null;
                                            } else {
                                                LD = abu3.thumbUrl;
                                            }
                                            if (bo.isNullOrNil(LD)) {
                                                LD = aar.cvq;
                                            }
                                            w = b.LD(LD);
                                            if (bo.isNullOrNil(w)) {
                                                w = Integer.valueOf(R.raw.app_attach_file_icon_webpage);
                                            }
                                        }
                                    } else {
                                        if (aar.dataType == 10 || aar.dataType == 11) {
                                            abe abe2 = aar.wgT.whC;
                                            if (abe2 != null) {
                                                w = b.LD(abe2.thumbUrl);
                                                if (bo.isNullOrNil(w)) {
                                                    w = Integer.valueOf(R.raw.app_attach_file_icon_unknow);
                                                }
                                            }
                                        }
                                        if (aar.dataType == 12 || aar.dataType == 14) {
                                            abo abo2 = aar.wgT.whE;
                                            if (abo2 != null) {
                                                w = b.LD(abo2.thumbUrl);
                                                if (bo.isNullOrNil(w)) {
                                                    w = Integer.valueOf(R.raw.app_attach_file_icon_unknow);
                                                }
                                            }
                                        }
                                        if (aar.dataType == 16) {
                                            aw.ZK();
                                            Rn = c.XO().Rn(aar.desc);
                                            w = (Rn.svN == null || Rn.svN.length() == 0) ? Integer.valueOf(R.drawable.ad2) : new SpannableString(Rn.svN);
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
                abu = gVar.field_favProto.whA;
                switch (gVar.field_type) {
                    case 1:
                        aVar.ajC(gVar.field_favProto.desc);
                        aVar.djw();
                        aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                            public final void bwF() {
                                AppMethodBeat.i(AccountTransferStatusCodes.NOT_ALLOWED_SECURITY);
                                Intent intent = new Intent();
                                intent.putExtra("Retr_Msg_content", gVar.field_favProto.desc);
                                com.tencent.mm.bp.d.f(context, ".ui.transmit.RetransmitPreviewUI", intent);
                                com.tencent.mm.ui.base.b.hL(context);
                                AppMethodBeat.o(AccountTransferStatusCodes.NOT_ALLOWED_SECURITY);
                            }
                        });
                        AppMethodBeat.o(20521);
                        return;
                    case 2:
                        aVar.b(com.tencent.mm.sdk.platformtools.d.aml(w), 3);
                        AppMethodBeat.o(20521);
                        return;
                    case 4:
                        aVar.b(com.tencent.mm.sdk.platformtools.d.aml(w), 2);
                        AppMethodBeat.o(20521);
                        return;
                    case 5:
                        if (abu == null || bo.isNullOrNil(abu.title)) {
                            w = null;
                            LD = null;
                        } else {
                            LD = abu.title;
                            w = abu.desc;
                        }
                        if (bo.isNullOrNil(LD)) {
                            LD = c.title;
                        }
                        bo.isNullOrNil(w);
                        aVar.ajC(new StringBuffer(context.getResources().getString(R.string.u9)).append(LD).toString());
                        AppMethodBeat.o(20521);
                        return;
                    case 6:
                        aVar.ajC(context.getString(R.string.rf) + gVar.field_favProto.why.label);
                        AppMethodBeat.o(20521);
                        return;
                    case 7:
                        if (!(abu == null || bo.isNullOrNil(abu.title))) {
                            str = abu.title;
                        }
                        if (bo.isNullOrNil(str)) {
                            str = c.title;
                        }
                        aVar.ajC(new StringBuffer(context.getResources().getString(R.string.rs)).append(str).toString());
                        AppMethodBeat.o(20521);
                        return;
                    case 8:
                        w = gVar.field_favProto.title;
                        if (bo.isNullOrNil(w)) {
                            w = c.title;
                        }
                        aVar.ajC(new StringBuffer(context.getResources().getString(R.string.qr)).append(w).toString());
                        AppMethodBeat.o(20521);
                        return;
                    case 14:
                        aVar.ajC(new StringBuffer(context.getResources().getString(R.string.t5)).append(com.tencent.mm.plugin.fav.ui.i.a.a(context, gVar).title).toString());
                        AppMethodBeat.o(20521);
                        return;
                    case 16:
                        aVar.b(com.tencent.mm.sdk.platformtools.d.aml(w), 2);
                        AppMethodBeat.o(20521);
                        return;
                    case 18:
                        aVar.ajC(new StringBuffer(context.getResources().getString(R.string.s5)).append(com.tencent.mm.plugin.fav.ui.i.a.a(context, gVar).desc.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, " ")).toString());
                        AppMethodBeat.o(20521);
                        return;
                    default:
                        if (!(abu == null || bo.isNullOrNil(abu.title))) {
                            str = abu.title;
                        }
                        if (bo.isNullOrNil(str)) {
                            str = c.title;
                        }
                        aVar.ajC(new StringBuffer(context.getResources().getString(R.string.fy)).append(str).toString());
                        AppMethodBeat.o(20521);
                        return;
                }
            }
            w = null;
            if (w instanceof String) {
            }
            abu = gVar.field_favProto.whA;
            switch (gVar.field_type) {
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
        ab.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
        AppMethodBeat.o(20521);
    }

    public static void b(com.tencent.mm.pluginsdk.ui.applet.g.a aVar, final Context context, final g gVar) {
        AppMethodBeat.i(20522);
        if (gVar == null || context == null) {
            ab.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
            AppMethodBeat.o(20522);
            return;
        }
        final aar c = b.c(gVar);
        switch (gVar.field_type) {
            case 1:
                aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                    public final void bwF() {
                        AppMethodBeat.i(AccountTransferStatusCodes.INVALID_REQUEST);
                        Intent intent = new Intent();
                        intent.putExtra("Retr_Msg_content", gVar.field_favProto.desc);
                        com.tencent.mm.bp.d.f(context, ".ui.transmit.RetransmitPreviewUI", intent);
                        com.tencent.mm.ui.base.b.hL(context);
                        AppMethodBeat.o(AccountTransferStatusCodes.INVALID_REQUEST);
                    }
                });
                AppMethodBeat.o(20522);
                return;
            case 2:
                aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                    public final void bwF() {
                        AppMethodBeat.i(20506);
                        Intent intent = new Intent();
                        intent.putExtra("key_detail_info_id", gVar.field_localId);
                        intent.putExtra("key_detail_data_id", c.mnd);
                        intent.putExtra("show_share", false);
                        b.b(context, ".ui.FavImgGalleryUI", intent);
                        AppMethodBeat.o(20506);
                    }
                });
                AppMethodBeat.o(20522);
                return;
            case 4:
            case 16:
                aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                    public final void bwF() {
                        AppMethodBeat.i(20507);
                        aar c = b.c(gVar);
                        Intent intent;
                        if (c == null) {
                            ab.e("MicroMsg.FavItemLogic", "goPlayView, but dataitem is null , exit");
                            AppMethodBeat.o(20507);
                        } else if (c.wgZ == null || (bo.isNullOrNil(c.wgZ.fiG) && bo.isNullOrNil(c.wgZ.fiK))) {
                            intent = new Intent();
                            intent.putExtra("key_detail_info_id", gVar.field_localId);
                            intent.putExtra("key_detail_fav_path", b.b(c));
                            intent.putExtra("key_detail_fav_thumb_path", b.c(c));
                            intent.putExtra("key_detail_fav_video_duration", c.duration);
                            intent.putExtra("key_detail_statExtStr", c.cMn);
                            intent.putExtra("show_share", false);
                            b.b(context, ".ui.detail.FavoriteVideoPlayUI", intent);
                            AppMethodBeat.o(20507);
                        } else {
                            ab.i("MicroMsg.FavItemLogic", "it is ad sight.use sight play");
                            intent = new Intent();
                            intent.putExtra("key_detail_info_id", gVar.field_localId);
                            intent.putExtra("key_detail_data_id", c.mnd);
                            intent.putExtra("key_detail_can_delete", false);
                            b.b(context, ".ui.detail.FavoriteFileDetailUI", intent);
                            AppMethodBeat.o(20507);
                        }
                    }
                });
                AppMethodBeat.o(20522);
                return;
            case 5:
                aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                    public final void bwF() {
                        AppMethodBeat.i(AccountTransferStatusCodes.SESSION_INACTIVE);
                        d.g(context, gVar, new abh());
                        AppMethodBeat.o(AccountTransferStatusCodes.SESSION_INACTIVE);
                    }
                });
                AppMethodBeat.o(20522);
                return;
            case 6:
                final aay aay = gVar.field_favProto.why;
                aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                    public final void bwF() {
                        AppMethodBeat.i(AccountTransferStatusCodes.CHALLENGE_NOT_ALLOWED);
                        Intent intent = new Intent();
                        intent.putExtra("map_view_type", 1);
                        intent.putExtra("kwebmap_slat", aay.lat);
                        intent.putExtra("kwebmap_lng", aay.lng);
                        intent.putExtra("Kwebmap_locaion", aay.label);
                        intent.putExtra("kShowshare", false);
                        com.tencent.mm.bp.d.b(context, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent);
                        AppMethodBeat.o(AccountTransferStatusCodes.CHALLENGE_NOT_ALLOWED);
                    }
                });
                AppMethodBeat.o(20522);
                return;
            case 8:
                aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                    public final void bwF() {
                        AppMethodBeat.i(AccountTransferStatusCodes.NO_DATA_AVAILABLE);
                        d.f(context, gVar, new abh());
                        AppMethodBeat.o(AccountTransferStatusCodes.NO_DATA_AVAILABLE);
                    }
                });
                AppMethodBeat.o(20522);
                return;
            case 14:
                aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                    public final void bwF() {
                        AppMethodBeat.i(20505);
                        d.h(context, gVar, new abh());
                        AppMethodBeat.o(20505);
                    }
                });
                AppMethodBeat.o(20522);
                return;
            case 18:
                aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                    public final void bwF() {
                        AppMethodBeat.i(20499);
                        d.i(context, gVar, new abh());
                        AppMethodBeat.o(20499);
                    }
                });
                break;
        }
        AppMethodBeat.o(20522);
    }

    private static boolean a(Context context, aar aar, g gVar) {
        AppMethodBeat.i(20516);
        aau aau = aar.wgZ;
        if (aau == null || bo.isNullOrNil(aau.fiG)) {
            AppMethodBeat.o(20516);
            return false;
        }
        m.a(m.a.EnterCompleteVideo, gVar);
        String c = b.c(aar);
        Intent intent = new Intent();
        intent.putExtra("IsAd", false);
        intent.putExtra("KStremVideoUrl", aau.fiG);
        intent.putExtra("StreamWording", aau.fiJ);
        intent.putExtra("StremWebUrl", aau.fiK);
        intent.putExtra("KThumUrl", aau.fiL);
        intent.putExtra("KSta_StremVideoAduxInfo", aau.fiM);
        intent.putExtra("KSta_StremVideoPublishId", aau.fiN);
        intent.putExtra("KSta_SourceType", 2);
        intent.putExtra("KSta_Scene", m.b.Fav.value);
        intent.putExtra("KSta_FromUserName", gVar.field_fromUser);
        intent.putExtra("KSta_FavID", gVar.field_id);
        intent.putExtra("KSta_SnsStatExtStr", aar.cMn);
        intent.putExtra("KBlockFav", true);
        intent.putExtra("KMediaId", "fakeid_" + gVar.field_id);
        intent.putExtra("KThumbPath", c);
        intent.putExtra("KMediaVideoTime", aau.wid);
        intent.putExtra("KMediaTitle", aau.fiI);
        com.tencent.mm.bp.d.b(context, "sns", ".ui.VideoAdPlayerUI", intent);
        AppMethodBeat.o(20516);
        return true;
    }
}
