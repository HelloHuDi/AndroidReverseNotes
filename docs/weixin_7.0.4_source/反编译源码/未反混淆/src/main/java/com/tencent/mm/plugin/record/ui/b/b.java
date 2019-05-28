package com.tencent.mm.plugin.record.ui.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.aw.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.ui.RecordMsgDetailUI;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h;
import com.tencent.mm.pluginsdk.model.d;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.t;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.File;

public final class b implements com.tencent.mm.plugin.record.ui.h.b {
    private c hAA = new c<ke>() {
        {
            AppMethodBeat.i(24352);
            this.xxI = ke.class.getName().hashCode();
            AppMethodBeat.o(24352);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(24353);
            ke keVar = (ke) bVar;
            if (keVar instanceof ke) {
                switch (keVar.cFH.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        b.this.handler.sendMessageAtFrontOfQueue(b.this.handler.obtainMessage(1));
                        break;
                }
            }
            AppMethodBeat.o(24353);
            return false;
        }
    };
    ak handler;
    private int moM = 0;
    private OnClickListener moP = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(24351);
            if (f.Mn()) {
                com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
                aat aat = bVar.cAv.wgT.whw;
                if (b.e(bVar.cAv)) {
                    ab.i("MicroMsg.OtherViewWrapper", "same song, do release");
                    a.aic();
                    if (!b.this.pLc) {
                        b.this.handler.sendMessageAtFrontOfQueue(b.this.handler.obtainMessage(1));
                        AppMethodBeat.o(24351);
                        return;
                    }
                }
                String absolutePath;
                b.this.pLc = true;
                File file = new File(n.f(bVar.cAv, bVar.cvx));
                if (file.exists()) {
                    absolutePath = file.getAbsolutePath();
                } else if (bVar.cAv.cvq == null) {
                    absolutePath = "";
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    aw.ZK();
                    file = new File(stringBuilder.append(com.tencent.mm.model.c.Yg()).append("web/").append(g.x(bVar.cAv.cvq.getBytes())).toString());
                    absolutePath = file.exists() ? file.getAbsolutePath() : "";
                }
                aar aar = bVar.cAv;
                String str = aar.title;
                String str2 = aar.desc;
                String str3 = aar.wgg;
                String str4 = aar.wgk;
                String str5 = aar.wgi;
                String str6 = aar.mnd;
                StringBuilder stringBuilder2 = new StringBuilder();
                aw.ZK();
                a.b(com.tencent.mm.aw.f.a(6, null, str, str2, str3, str4, str5, str6, stringBuilder2.append(com.tencent.mm.model.c.Yg()).append("web/").toString(), absolutePath, "", aat.appId));
                AppMethodBeat.o(24351);
                return;
            }
            t.hO(view.getContext());
            AppMethodBeat.o(24351);
        }
    };
    private h.a pKt;
    boolean pLc = false;
    OnClickListener pLd = new OnClickListener() {
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00a4  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:224:0x090e  */
        /* JADX WARNING: Removed duplicated region for block: B:228:0x093b  */
        /* JADX WARNING: Removed duplicated region for block: B:227:0x0939  */
        /* JADX WARNING: Removed duplicated region for block: B:229:0x093d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(View view) {
            AppMethodBeat.i(24350);
            com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            String str;
            Intent intent;
            String str2;
            Intent intent2;
            Bundle tL;
            Intent intent3;
            Context context;
            switch (bVar.cAv.dataType) {
                case 4:
                case 15:
                    Context context2 = view.getContext();
                    if ((bo.isNullOrNil(bVar.cAv.wfZ) && bo.isNullOrNil(bVar.cAv.whr)) || bVar.cAv.wgu <= 0) {
                        ab.w("MicroMsg.OtherViewWrapper", "full md5[%s], fullsize[%d], start use url", bVar.cAv.wgq, Long.valueOf(bVar.cAv.wgu));
                        str = bVar.cAv.wgg;
                        if (bo.isNullOrNil(str)) {
                            str = bVar.cAv.wgk;
                        }
                        if (bo.isNullOrNil(str)) {
                            ab.w("MicroMsg.OtherViewWrapper", "go to video[webpage] error, url null, dataid[%s]", bVar.cAv.mnd);
                            if (bVar.dataType == 1 && bVar.mnW.field_itemStatus != 10 && bVar.cAv.whh == 0) {
                                intent = new Intent();
                                intent.putExtra("key_detail_info_id", bVar.mnW.field_localId);
                                intent.putExtra("key_detail_data_id", bVar.cAv.mnd);
                                if (com.tencent.mm.plugin.record.b.g.c(bVar)) {
                                    b.a(intent, bVar, context2, com.tencent.mm.plugin.record.b.g.a(bVar), com.tencent.mm.plugin.record.b.g.b(bVar));
                                    AppMethodBeat.o(24350);
                                    return;
                                }
                                com.tencent.mm.plugin.fav.a.b.a(context2, ".ui.detail.FavoriteFileDetailUI", intent, 1);
                                AppMethodBeat.o(24350);
                                return;
                            }
                            Intent intent4 = new Intent();
                            str2 = "";
                            str = "";
                            if (bVar.dataType == 0) {
                                str = n.f(bVar.cAv, bVar.cvx);
                                if (bo.isNullOrNil(str) || !e.ct(str)) {
                                    com.tencent.mm.ui.base.h.bQ(context2, context2.getString(R.string.bqx));
                                    AppMethodBeat.o(24350);
                                    return;
                                }
                                str2 = n.c(bVar.cAv, bVar.cvx);
                                if (bo.isNullOrNil(str2) || !e.ct(str2)) {
                                    intent4.putExtra("key_detail_data_valid", false);
                                }
                            } else if (bVar.dataType == 1) {
                                str = com.tencent.mm.plugin.record.b.g.b(bVar);
                                if (bo.isNullOrNil(str) || !e.ct(str)) {
                                    com.tencent.mm.ui.base.h.bQ(context2, context2.getString(R.string.bqx));
                                    AppMethodBeat.o(24350);
                                    return;
                                }
                                str2 = com.tencent.mm.plugin.record.b.g.a(bVar);
                                if (bo.isNullOrNil(str2) || !e.ct(str2)) {
                                    intent4.putExtra("key_detail_data_valid", false);
                                }
                            }
                            b.a(intent4, bVar, context2, str2, str);
                            AppMethodBeat.o(24350);
                            return;
                        }
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str);
                        if (bVar.dataType == 1) {
                            intent2.putExtra("is_favorite_item", true);
                            intent2.putExtra("fav_local_id", bVar.mnW.field_localId);
                            intent2.putExtra("key_detail_can_delete", false);
                            intent2.putExtra("geta8key_scene", 14);
                            tL = com.tencent.mm.modelstat.a.c.tL(d.class.getName());
                            tL.putInt("mm_rpt_fav_id", bVar.mnW.field_id);
                            intent2.putExtra("mm_report_bundle", tL);
                            ab.d("MicroMsg.OtherViewWrapper", "go to video, fav id %d, fav local id %d, data id %s", Integer.valueOf(bVar.mnW.field_id), Long.valueOf(bVar.mnW.field_localId), bVar.cAv.mnd);
                        }
                        com.tencent.mm.bp.d.b(context2, "webview", ".ui.tools.WebViewUI", intent2, 1);
                        AppMethodBeat.o(24350);
                        return;
                    } else if (bVar.dataType == 0) {
                        intent = new Intent();
                        intent.putExtra("message_id", bVar.cvx);
                        intent.putExtra("record_xml", bVar.cKa);
                        intent.putExtra("record_data_id", bVar.cAv.mnd);
                        intent.putExtra("key_detail_fav_video_scene_from", 1);
                        if (n.d(bVar.cAv, bVar.cvx)) {
                            b.a(intent, bVar, context2, n.c(bVar.cAv, bVar.cvx), n.f(bVar.cAv, bVar.cvx));
                            AppMethodBeat.o(24350);
                            return;
                        }
                        com.tencent.mm.bp.d.b(context2, "record", ".ui.RecordMsgFileUI", intent, 1);
                        AppMethodBeat.o(24350);
                        return;
                    } else {
                        if (bVar.dataType == 1) {
                            intent = new Intent();
                            intent.putExtra("key_detail_info_id", bVar.mnW.field_localId);
                            intent.putExtra("key_detail_data_id", bVar.cAv.mnd);
                            if (com.tencent.mm.plugin.record.b.g.c(bVar)) {
                                b.a(intent, bVar, context2, com.tencent.mm.plugin.record.b.g.a(bVar), com.tencent.mm.plugin.record.b.g.b(bVar));
                                AppMethodBeat.o(24350);
                                return;
                            }
                            com.tencent.mm.plugin.fav.a.b.a(context2, ".ui.detail.FavoriteFileDetailUI", intent, 1);
                        }
                        AppMethodBeat.o(24350);
                        return;
                    }
                case 5:
                    Context context3 = view.getContext();
                    if (bVar.cAv.wgT == null) {
                        ab.w("MicroMsg.OtherViewWrapper", "go to web page error, get data proto item null, dataid[%s]", bVar.cAv.mnd);
                        com.tencent.mm.ui.base.h.bQ(context3, context3.getString(R.string.bqw));
                        AppMethodBeat.o(24350);
                        return;
                    }
                    aar aar = bVar.cAv;
                    if (aar != null) {
                        if (aar.whe) {
                            str = aar.canvasPageXml;
                        } else if (!(aar.wgT == null || aar.wgT.whA == null || !aar.wgT.whA.whe)) {
                            str = aar.wgT.whA.canvasPageXml;
                        }
                        if (bo.isNullOrNil(str)) {
                            intent2 = new Intent();
                            intent2.putExtra("sns_landing_pages_xml", str);
                            intent2.putExtra("sns_landig_pages_from_source", 5);
                            intent2.putExtra("sns_landing_pages_share_thumb_url", bVar.cAv.fgE);
                            intent2.addFlags(268435456);
                            intent2.putExtra("msg_id", bVar.cvx);
                            com.tencent.mm.bp.d.b(context3, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent2, 1);
                            AppMethodBeat.o(24350);
                            return;
                        }
                        aat aat = bVar.cAv.wgT.whw;
                        str = "";
                        if (bVar.cAv.wgT.whA != null) {
                            str = bVar.cAv.wgT.whA.wiY;
                        }
                        if (aat != null && bo.isNullOrNil(r1)) {
                            str = aat.link;
                        }
                        if (bo.isNullOrNil(str)) {
                            str = bVar.cAv.wgg;
                        }
                        if (bo.isNullOrNil(str)) {
                            ab.w("MicroMsg.OtherViewWrapper", "go to web page error, url null, dataid[%s]", bVar.cAv.mnd);
                            com.tencent.mm.ui.base.h.bQ(context3, context3.getString(R.string.bqw));
                            AppMethodBeat.o(24350);
                            return;
                        }
                        intent3 = new Intent();
                        intent3.putExtra("rawUrl", str);
                        if (!(aat == null || bo.isNullOrNil(aat.csl))) {
                            intent3.putExtra("srcDisplayname", s.mJ(aat.csl));
                        }
                        intent3.putExtra("mode", 1);
                        b.A(context3, intent3);
                        if (bVar.dataType == 1) {
                            intent3.putExtra("is_favorite_item", true);
                            intent3.putExtra("fav_local_id", bVar.mnW.field_localId);
                            intent3.putExtra("key_detail_can_delete", false);
                            intent3.putExtra("geta8key_scene", 14);
                            intent3.putExtra("from_scence", 4);
                            tL = com.tencent.mm.modelstat.a.c.tL(d.class.getName());
                            tL.putInt("mm_rpt_fav_id", bVar.mnW.field_id);
                            intent3.putExtra("mm_report_bundle", tL);
                        }
                        tL = new Bundle();
                        tL.putString("key_snsad_statextstr", bVar.cAv.cMn);
                        intent3.putExtra("jsapiargs", tL);
                        com.tencent.mm.bp.d.b(context3, "webview", ".ui.tools.WebViewUI", intent3, 1);
                        AppMethodBeat.o(24350);
                        return;
                    }
                    str = null;
                    if (bo.isNullOrNil(str)) {
                    }
                case 6:
                    Context context4 = view.getContext();
                    if (context4 != null) {
                        aay aay;
                        aat aat2;
                        if (bVar.cAv.wgT != null) {
                            aay = bVar.cAv.wgT.why;
                            aat2 = bVar.cAv.wgT.whw;
                        } else {
                            aat2 = null;
                            aay = null;
                        }
                        if (aat2 == null) {
                            str = null;
                        } else if (bo.isNullOrNil(aat2.whU)) {
                            str = s.mJ(aat2.cEV);
                        } else {
                            str = s.mJ(aat2.whU);
                        }
                        if (aat2 == null && bVar.dataType == 1) {
                            str = s.mJ(bVar.mnW.field_fromUser);
                        }
                        if (aay == null) {
                            ab.w("MicroMsg.OtherViewWrapper", "go to location error, locItem null, dataid[%s]", bVar.cAv.mnd);
                            com.tencent.mm.ui.base.h.bQ(context4, context4.getString(R.string.bqo));
                            AppMethodBeat.o(24350);
                            return;
                        }
                        intent2 = new Intent();
                        intent2.putExtra("kwebmap_slat", aay.lat);
                        intent2.putExtra("kwebmap_lng", aay.lng);
                        intent2.putExtra("kPoiName", aay.cIK);
                        intent2.putExtra("Kwebmap_locaion", aay.label);
                        if (aay.cED >= 0) {
                            intent2.putExtra("kwebmap_scale", aay.cED);
                        }
                        intent2.putExtra("kisUsername", str);
                        intent2.putExtra("kwebmap_from_to", true);
                        if (bVar.dataType == 1) {
                            intent2.putExtra("KFavLocSigleView", true);
                            intent2.putExtra("map_view_type", 2);
                            intent2.putExtra("kFavInfoLocalId", bVar.mnW.field_localId);
                            intent2.putExtra("kFavCanDel", false);
                            intent2.putExtra("kFavCanRemark", false);
                            com.tencent.mm.bp.d.b(context4, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent2, 1);
                            AppMethodBeat.o(24350);
                            return;
                        }
                        if (bVar.dataType == 0) {
                            intent2.putExtra("map_view_type", 1);
                            com.tencent.mm.bp.d.b(context4, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent2, 1002);
                        }
                        AppMethodBeat.o(24350);
                        return;
                    }
                    break;
                case 7:
                    context = view.getContext();
                    intent2 = new Intent();
                    if (bo.isNullOrNil(bVar.cAv.wgg)) {
                        ab.w("MicroMsg.OtherViewWrapper", "go to music[webpage], web url is null, use data url instead, dataid[%s]", bVar.cAv.mnd);
                        intent2.putExtra("rawUrl", bVar.cAv.wgi);
                    } else {
                        intent2.putExtra("rawUrl", bVar.cAv.wgg);
                    }
                    if (bVar.dataType == 1) {
                        intent2.putExtra("is_favorite_item", true);
                        intent2.putExtra("fav_local_id", bVar.mnW.field_localId);
                        intent2.putExtra("key_detail_can_delete", false);
                        Bundle tL2 = com.tencent.mm.modelstat.a.c.tL(d.class.getName());
                        tL2.putInt("mm_rpt_fav_id", bVar.mnW.field_id);
                        intent2.putExtra("mm_report_bundle", tL2);
                        ab.d("MicroMsg.OtherViewWrapper", "start music webview, fav id %d, fav local id %d, data id %s", Integer.valueOf(bVar.mnW.field_id), Long.valueOf(bVar.mnW.field_localId), bVar.cAv.mnd);
                    }
                    com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewUI", intent2, 1);
                    AppMethodBeat.o(24350);
                    return;
                case 8:
                    int i;
                    Context context5 = view.getContext();
                    if (bVar.dataType == 0) {
                        if (n.d(bVar.cAv, bVar.cvx) && !com.tencent.mm.pluginsdk.ui.tools.a.M(n.c(bVar.cAv, bVar.cvx), bVar.cAv.wgo, 2)) {
                            i = 0;
                        }
                        i = 1;
                    } else {
                        if (bVar.dataType == 1 && com.tencent.mm.plugin.record.b.g.c(bVar) && !com.tencent.mm.pluginsdk.ui.tools.a.M(com.tencent.mm.plugin.record.b.g.a(bVar), bVar.cAv.wgo, 2)) {
                            i = 0;
                        }
                        i = 1;
                    }
                    if (i != 0) {
                        if (bVar.dataType == 0) {
                            intent = new Intent(context5, RecordMsgFileUI.class);
                            intent.putExtra("message_id", bVar.cvx);
                            intent.putExtra("record_xml", bVar.cKa);
                            intent.putExtra("record_data_id", bVar.cAv.mnd);
                            context5.startActivity(intent);
                            AppMethodBeat.o(24350);
                            return;
                        } else if (bVar.dataType == 1) {
                            if (n.h(bVar.cAv, bVar.cvx)) {
                                intent = new Intent();
                                intent.putExtra("key_detail_info_id", bVar.mnW.field_localId);
                                com.tencent.mm.plugin.fav.a.b.a(context5, ".ui.detail.FavoriteImgDetailUI", intent, 1);
                                AppMethodBeat.o(24350);
                                return;
                            }
                            intent = new Intent();
                            intent.putExtra("key_detail_info_id", bVar.mnW.field_localId);
                            intent.putExtra("key_detail_data_id", bVar.cAv.mnd);
                            intent.putExtra("key_detail_can_delete", false);
                            com.tencent.mm.plugin.fav.a.b.a(context5, ".ui.detail.FavoriteFileDetailUI", intent, 1);
                        }
                    }
                    AppMethodBeat.o(24350);
                    return;
                case 10:
                    context = view.getContext();
                    if (bVar.cAv.wgT == null || bVar.cAv.wgT.whC == null) {
                        ab.w("MicroMsg.OtherViewWrapper", "go to product error, get data proto item null, dataid[%s]", bVar.cAv.mnd);
                        com.tencent.mm.ui.base.h.bQ(context, context.getString(R.string.bqn));
                        AppMethodBeat.o(24350);
                        return;
                    }
                    intent2 = new Intent();
                    intent2.putExtra("key_Product_xml", bVar.cAv.wgT.whC.info);
                    if (bVar.dataType == 1) {
                        intent2.putExtra("key_is_favorite_item", true);
                        intent2.putExtra("key_favorite_local_id", bVar.mnW.field_localId);
                        intent2.putExtra("key_can_delete_favorite_item", false);
                        intent2.putExtra("key_ProductUI_getProductInfoScene", 3);
                    }
                    com.tencent.mm.bp.d.b(context, "scanner", ".ui.ProductUI", intent2, 1);
                    AppMethodBeat.o(24350);
                    return;
                case 11:
                    context = view.getContext();
                    if (bVar.cAv.wgT == null || bVar.cAv.wgT.whC == null) {
                        ab.w("MicroMsg.OtherViewWrapper", "go to mall product error, get data proto item null, dataid[%s]", bVar.cAv.mnd);
                        com.tencent.mm.ui.base.h.bQ(context, context.getString(R.string.bqn));
                        AppMethodBeat.o(24350);
                        return;
                    }
                    intent2 = new Intent();
                    intent2.putExtra("key_product_info", bVar.cAv.wgT.whC.info);
                    if (bVar.dataType == 1) {
                        intent2.putExtra("key_product_scene", 4);
                    }
                    com.tencent.mm.bp.d.b(context, "product", ".ui.MallProductUI", intent2, 1);
                    AppMethodBeat.o(24350);
                    return;
                case 14:
                    context = view.getContext();
                    if (bVar.cAv.wgT == null || bVar.cAv.wgT.whE == null) {
                        ab.w("MicroMsg.OtherViewWrapper", "go to tv error, get data proto item null, dataid[%s]", bVar.cAv.mnd);
                        com.tencent.mm.ui.base.h.bQ(context, context.getString(R.string.bqn));
                        AppMethodBeat.o(24350);
                        return;
                    }
                    intent2 = new Intent();
                    intent2.putExtra("key_TV_getProductInfoScene", 3);
                    intent2.putExtra("key_TV_xml", bVar.cAv.wgT.whE.info);
                    if (bVar.dataType == 1) {
                        intent2.putExtra("key_is_favorite_item", true);
                        intent2.putExtra("key_favorite_local_id", bVar.mnW.field_localId);
                        intent2.putExtra("key_can_delete_favorite_item", false);
                    }
                    com.tencent.mm.bp.d.b(context, "shake", ".ui.TVInfoUI", intent2, 1);
                    AppMethodBeat.o(24350);
                    return;
                case 16:
                    context = view.getContext();
                    if (bVar.cAv.wgT == null) {
                        ab.w("MicroMsg.OtherViewWrapper", "go to friend card error, get data proto item null, dataid[%s]", bVar.cAv.mnd);
                        com.tencent.mm.ui.base.h.bQ(context, context.getString(R.string.bqn));
                        AppMethodBeat.o(24350);
                        return;
                    }
                    str2 = bVar.cAv.desc;
                    aw.ZK();
                    bi.a Rn = com.tencent.mm.model.c.XO().Rn(str2);
                    if (Rn == null) {
                        ab.w("MicroMsg.OtherViewWrapper", "go to friend card error, parse content fail,[%s], dataid[%s]", str2, bVar.cAv.mnd);
                        com.tencent.mm.ui.base.h.bQ(context, context.getString(R.string.bqn));
                        AppMethodBeat.o(24350);
                        return;
                    }
                    Intent intent5 = new Intent();
                    intent5.putExtra("Contact_User", Rn.svN);
                    intent5.putExtra("Contact_Alias", Rn.dFl);
                    intent5.putExtra("Contact_Nick", Rn.nickname);
                    intent5.putExtra("Contact_QuanPin", Rn.gwG);
                    intent5.putExtra("Contact_PyInitial", Rn.gwF);
                    intent5.putExtra("Contact_Uin", Rn.pnz);
                    intent5.putExtra("Contact_Mobile_MD5", Rn.xZi);
                    intent5.putExtra("Contact_full_Mobile_MD5", Rn.xZj);
                    intent5.putExtra("Contact_QQNick", Rn.dtZ());
                    intent5.putExtra("User_From_Fmessage", false);
                    intent5.putExtra("Contact_Scene", Rn.scene);
                    intent5.putExtra("Contact_FMessageCard", true);
                    intent5.putExtra("Contact_RemarkName", Rn.gwK);
                    intent5.putExtra("Contact_VUser_Info_Flag", Rn.ufB);
                    intent5.putExtra("Contact_VUser_Info", Rn.duh);
                    intent5.putExtra("Contact_BrandIconURL", Rn.pln);
                    intent5.putExtra("Contact_Province", Rn.getProvince());
                    intent5.putExtra("Contact_City", Rn.getCity());
                    intent5.putExtra("Contact_Sex", Rn.dtS);
                    intent5.putExtra("Contact_Signature", Rn.signature);
                    intent5.putExtra("Contact_ShowUserName", false);
                    intent5.putExtra("Contact_KSnsIFlag", 0);
                    b.A(context, intent5);
                    com.tencent.mm.bp.d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent5, 1);
                    com.tencent.mm.bq.a.Lu(Rn.scene);
                    AppMethodBeat.o(24350);
                    return;
                case 17:
                    context = view.getContext();
                    if (context != null) {
                        if (bVar.dataType == 0 && bVar.cAv.whj != null) {
                            intent2 = new Intent(context, RecordMsgDetailUI.class);
                            intent2.putExtra("message_id", bVar.cvx);
                            intent2.putExtra("record_xml", bVar.cAv.whj);
                            b.A(context, intent2);
                            context.startActivity(intent2);
                        }
                        AppMethodBeat.o(24350);
                        return;
                    }
                    break;
                case 19:
                    context = view.getContext();
                    if (context != null) {
                        aas aas = bVar.cAv.wgT;
                        if (aas != null) {
                            aap aap = aas.whN;
                            if (aap != null) {
                                Object stringExtra;
                                Object obj;
                                int i2;
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING;
                                if (aas.whw != null) {
                                    appBrandStatObject.cst = aas.whw.cEV;
                                }
                                int i3 = -1;
                                if (context instanceof Activity) {
                                    intent3 = ((Activity) context).getIntent();
                                    if (intent3 != null) {
                                        i3 = intent3.getIntExtra("preChatTYPE", 2);
                                        String stringExtra2 = intent3.getStringExtra("preUsername");
                                        stringExtra = intent3.getStringExtra("preChatName");
                                        obj = stringExtra2;
                                        switch (i3) {
                                            case 1:
                                                i2 = 1;
                                                break;
                                            case 2:
                                                i2 = 2;
                                                break;
                                            case 15:
                                                i2 = 5;
                                                break;
                                            default:
                                                i2 = 0;
                                                break;
                                        }
                                        appBrandStatObject.cOq = i2;
                                        appBrandStatObject.cOr = String.format("%s:%s", new Object[]{obj, stringExtra});
                                        ((com.tencent.mm.plugin.appbrand.service.e) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(context, aap.username, aap.appId, aap.cBc, -1, aap.csu, appBrandStatObject);
                                    }
                                }
                                stringExtra = null;
                                obj = null;
                                switch (i3) {
                                    case 1:
                                        break;
                                    case 2:
                                        break;
                                    case 15:
                                        break;
                                    default:
                                        break;
                                }
                                appBrandStatObject.cOq = i2;
                                appBrandStatObject.cOr = String.format("%s:%s", new Object[]{obj, stringExtra});
                                ((com.tencent.mm.plugin.appbrand.service.e) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(context, aap.username, aap.appId, aap.cBc, -1, aap.csu, appBrandStatObject);
                            }
                        }
                        AppMethodBeat.o(24350);
                        return;
                    }
                    break;
                default:
                    AppMethodBeat.o(24350);
                    return;
            }
            AppMethodBeat.o(24350);
        }
    };

    public b(h.a aVar, ak akVar) {
        AppMethodBeat.i(24354);
        this.pKt = aVar;
        this.handler = akVar;
        AppMethodBeat.o(24354);
    }

    public final View eK(Context context) {
        AppMethodBeat.i(24355);
        View inflate = View.inflate(context, R.layout.ano, null);
        this.moM = com.tencent.mm.bz.a.fromDPToPix(context, 75);
        com.tencent.mm.sdk.b.a.xxA.c(this.hAA);
        AppMethodBeat.o(24355);
        return inflate;
    }

    public static boolean e(aar aar) {
        AppMethodBeat.i(24357);
        com.tencent.mm.aw.e aih = a.aih();
        if (aih != null && aih.fJS == 6 && bo.bc(aar.mnd, "").equals(aih.fJU) && a.aie()) {
            AppMethodBeat.o(24357);
            return true;
        }
        AppMethodBeat.o(24357);
        return false;
    }

    @SuppressLint({"ResourceType"})
    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        AppMethodBeat.i(24358);
        TextView textView = (TextView) view.findViewById(R.id.cx);
        TextView textView2 = (TextView) view.findViewById(R.id.o7);
        TextView textView3 = (TextView) view.findViewById(R.id.dx4);
        MMImageView mMImageView = (MMImageView) view.findViewById(R.id.jb);
        mMImageView.setVisibility(0);
        ImageView imageView = (ImageView) view.findViewById(R.id.dx3);
        imageView.setVisibility(8);
        View findViewById = view.findViewById(R.id.dx0);
        findViewById.setVisibility(0);
        findViewById.setTag(bVar);
        findViewById.setOnClickListener(this.pLd);
        View findViewById2 = view.findViewById(R.id.dx2);
        findViewById2.setVisibility(8);
        h.a.a aVar = new h.a.a();
        if (bVar.dataType == 0) {
            aVar.pKv = bVar.cvx;
        } else if (bVar.dataType == 1) {
            aVar.pKv = bVar.mnW.field_localId;
        }
        aVar.cAw = mMImageView;
        aVar.cAv = bVar.cAv;
        aVar.height = this.moM;
        aVar.width = this.moM;
        aar aar;
        int i2;
        String appName;
        aar aar2;
        aar aar3;
        switch (bVar.cAv.dataType) {
            case 4:
            case 15:
                aar = bVar.cAv;
                if (bo.isNullOrNil(aar.title)) {
                    textView.setText(R.string.bs9);
                } else {
                    textView.setText(aar.title);
                }
                if (aar.duration <= 0) {
                    textView2.setVisibility(8);
                } else {
                    CharSequence string;
                    textView2.setVisibility(0);
                    Context context = textView2.getContext();
                    int i3 = aar.duration;
                    if (i3 <= 0) {
                        string = context.getString(R.string.bsa, new Object[]{Integer.valueOf(0)});
                    } else {
                        i2 = i3 / 60;
                        i3 %= 60;
                        if (i2 == 0) {
                            string = context.getString(R.string.bsa, new Object[]{Integer.valueOf(i3)});
                        } else {
                            string = context.getString(R.string.bs_, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                        }
                    }
                    textView2.setText(string);
                }
                if (aar.wgT == null) {
                    ab.w("MicroMsg.OtherViewWrapper", "video, get data proto item null, dataid[%s]", aar.mnd);
                    textView3.setVisibility(8);
                } else {
                    aat aat = aar.wgT.whw;
                    if (!bo.isNullOrNil(aat.appId)) {
                        appName = getAppName(textView3.getContext(), aat.appId);
                        if (bo.isNullOrNil(appName)) {
                            textView3.setVisibility(8);
                        } else {
                            textView3.setVisibility(0);
                            textView3.setText(appName);
                        }
                    }
                }
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.aql);
                aVar.cAx = R.raw.app_attach_file_icon_video;
                this.pKt.a(aVar);
                break;
            case 5:
                aar2 = bVar.cAv;
                String str = "";
                abu abu = null;
                if (!(aar2 == null || aar2.wgT == null)) {
                    abu = aar2.wgT.whA;
                }
                if (abu != null) {
                    str = abu.title;
                }
                if (bo.isNullOrNil(str) && aar2 != null) {
                    str = aar2.title;
                }
                if (bo.isNullOrNil(str)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(str);
                    textView.setVisibility(0);
                }
                textView2.setVisibility(8);
                appName = "";
                if (abu != null) {
                    appName = bo.anh(abu.wiY);
                }
                aat aat2 = null;
                if (!(aar2 == null || aar2.wgT == null)) {
                    aat2 = aar2.wgT.whw;
                }
                if (aat2 != null) {
                    if (!bo.isNullOrNil(aat2.appId)) {
                        appName = bo.bc(getAppName(textView3.getContext(), aat2.appId), "");
                    } else if (!bo.isNullOrNil(aat2.csl)) {
                        aw.ZK();
                        ad aoO = com.tencent.mm.model.c.XM().aoO(aat2.csl);
                        if (aoO == null || !aoO.field_username.equals(aat2.csl)) {
                            ao.a.flu.a(aat2.csl, "", null);
                        } else {
                            appName = aoO.Oj();
                        }
                    }
                    if (bo.isNullOrNil(appName) || appName.equals(aat2.csl)) {
                        appName = bo.anh(aat2.link);
                    }
                }
                if (bo.isNullOrNil(appName)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setText(appName);
                    textView3.setVisibility(0);
                }
                aVar.cAx = R.drawable.avp;
                this.pKt.a(aVar);
                break;
            case 6:
                aar3 = bVar.cAv;
                if (aar3.wgT == null) {
                    ab.w("MicroMsg.OtherViewWrapper", "location, get data proto item null, dataid[%s]", aar3.mnd);
                    textView.setText(R.string.bpj);
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    aay aay = aar3.wgT.why;
                    if (bo.isNullOrNil(aay.cIK)) {
                        textView.setText(aay.label);
                        textView2.setText(R.string.bpj);
                        textView3.setText("");
                    } else {
                        textView.setText(aay.cIK);
                        textView2.setText(aay.label);
                        textView3.setText(R.string.bpj);
                    }
                }
                mMImageView.setImageResource(R.raw.app_attach_file_icon_location);
                break;
            case 7:
                textView.setText(bVar.cAv.title);
                textView2.setText(bVar.cAv.desc);
                imageView.setTag(bVar);
                imageView.setOnClickListener(this.moP);
                imageView.setImageResource(R.drawable.vs);
                imageView.setVisibility(0);
                if (e(bVar.cAv)) {
                    imageView.setImageResource(R.drawable.vq);
                }
                textView3.setVisibility(8);
                aVar.cAx = R.raw.app_attach_file_icon_music;
                this.pKt.a(aVar);
                break;
            case 8:
                aar3 = bVar.cAv;
                textView.setText(aar3.title);
                textView2.setVisibility(0);
                textView2.setText(bo.aC((float) aar3.wgu));
                textView3.setVisibility(8);
                if (aar3.whh == 2) {
                    textView2.setText(">25MB");
                }
                mMImageView.setImageResource(com.tencent.mm.pluginsdk.d.ail(bVar.cAv.wgo));
                break;
            case 10:
                aar = bVar.cAv;
                if (aar.wgT == null) {
                    ab.w("MicroMsg.OtherViewWrapper", "product, get data proto item null, dataid[%s]", aar.mnd);
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    abe abe = aar.wgT.whC;
                    textView.setText(abe.title);
                    textView2.setText(abe.desc);
                    textView3.setText(bo.bc(getAppName(textView3.getContext(), aar.wgT.whw.appId), textView3.getContext().getString(R.string.bqc)));
                }
                aVar.cAx = R.raw.app_attach_file_icon_unknow;
                this.pKt.a(aVar);
                break;
            case 11:
                aar = bVar.cAv;
                if (aar.wgT == null) {
                    ab.w("MicroMsg.OtherViewWrapper", "mall product, get data proto item null, dataid[%s]", aar.mnd);
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    abe abe2 = aar.wgT.whC;
                    textView.setText(abe2.title);
                    textView2.setText(abe2.desc);
                    textView.setSingleLine(false);
                    textView.setMaxLines(2);
                    textView3.setVisibility(8);
                }
                aVar.cAx = R.raw.app_attach_file_icon_unknow;
                aVar.cAv = null;
                this.pKt.a(aVar);
                break;
            case 14:
                aar = bVar.cAv;
                if (aar.wgT == null || aar.wgT.whE == null) {
                    ab.w("MicroMsg.OtherViewWrapper", "tv, get data proto item null, dataid[%s]", aar.mnd);
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    abo abo = aar.wgT.whE;
                    textView.setText(abo.title);
                    textView2.setText(abo.desc);
                    textView3.setText(bo.bc(getAppName(textView3.getContext(), aar.wgT.whw.appId), textView3.getContext().getString(R.string.bs5)));
                }
                aVar.cAx = R.raw.app_attach_file_icon_unknow;
                aVar.cAv = null;
                this.pKt.a(aVar);
                break;
            case 16:
                CharSequence charSequence;
                aar3 = bVar.cAv;
                aw.ZK();
                bi.a Rn = com.tencent.mm.model.c.XO().Rn(aar3.desc);
                if (Rn == null) {
                    ab.e("MicroMsg.OtherViewWrapper", "parse possible friend msg failed");
                }
                Context context2 = textView.getContext();
                if (Rn != null) {
                    charSequence = Rn.nickname;
                } else {
                    charSequence = "";
                }
                textView.setText(j.b(context2, charSequence, textView.getTextSize()));
                textView2.setVisibility(8);
                textView3.setText(R.string.bp3);
                textView3.setVisibility(0);
                appName = Rn.svN;
                if (!bo.isNullOrNil(appName)) {
                    com.tencent.mm.pluginsdk.ui.a.b.b(mMImageView, appName);
                    break;
                } else {
                    mMImageView.setImageResource(R.drawable.ad2);
                    break;
                }
            case 17:
                aar3 = bVar.cAv;
                textView.setText(aar3.title);
                textView2.setVisibility(0);
                textView2.setText(aar3.desc);
                mMImageView.setVisibility(8);
                break;
            case 19:
                aar2 = bVar.cAv;
                i2 = bVar.cAv.dataType;
                String str2 = "";
                if (aar2 != null) {
                    str2 = aar2.title;
                }
                if (bo.isNullOrNil(str2)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(str2);
                    textView.setVisibility(0);
                }
                appName = "";
                if (19 == i2) {
                    appName = textView2.getContext().getString(R.string.i9);
                }
                if (bo.isNullOrNil(appName)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(appName);
                    textView2.setVisibility(0);
                }
                h.a.c cVar = new h.a.c();
                cVar.cAv = bVar.cAv;
                if (bVar.dataType == 0) {
                    cVar.pKv = bVar.cvx;
                } else if (bVar.dataType == 1) {
                    cVar.pKv = bVar.mnW.field_localId;
                }
                aVar.cAx = R.drawable.avp;
                Bitmap a = this.pKt.a(cVar);
                if (a == null) {
                    this.pKt.a(aVar);
                    break;
                } else {
                    mMImageView.setImageBitmap(a);
                    break;
                }
            default:
                findViewById.setVisibility(8);
                findViewById2.setVisibility(0);
                AppMethodBeat.o(24358);
                return;
        }
        textView3.setVisibility(8);
        AppMethodBeat.o(24358);
    }

    public final void destroy() {
        AppMethodBeat.i(24359);
        ab.d("MicroMsg.OtherViewWrapper", "do destroy");
        this.pKt = null;
        this.handler = null;
        com.tencent.mm.sdk.b.a.xxA.d(this.hAA);
        this.pLc = false;
        AppMethodBeat.o(24359);
    }

    public final void pause() {
    }

    static void a(Intent intent, com.tencent.mm.plugin.record.ui.a.b bVar, Context context, String str, String str2) {
        AppMethodBeat.i(24360);
        intent.putExtra("key_detail_fav_path", str);
        intent.putExtra("key_detail_fav_thumb_path", str2);
        intent.putExtra("key_detail_fav_video_duration", bVar.cAv.duration);
        intent.putExtra("key_detail_statExtStr", bVar.cAv.cMn);
        com.tencent.mm.plugin.fav.a.b.a(context, ".ui.detail.FavoriteVideoPlayUI", intent, 1);
        AppMethodBeat.o(24360);
    }

    static void A(Context context, Intent intent) {
        AppMethodBeat.i(24361);
        if (context instanceof Activity) {
            Intent intent2 = ((Activity) context).getIntent();
            if (intent2 != null) {
                intent.putExtra("prePublishId", intent2.getStringExtra("prePublishId"));
                intent.putExtra("preUsername", intent2.getStringExtra("preUsername"));
                intent.putExtra("preChatName", intent2.getStringExtra("preChatName"));
                intent.putExtra("preChatTYPE", intent2.getIntExtra("preChatTYPE", 0));
            }
        }
        AppMethodBeat.o(24361);
    }

    private static String getAppName(Context context, String str) {
        AppMethodBeat.i(24356);
        com.tencent.mm.model.ad.b bVar = com.tencent.mm.model.ad.a.fls;
        String t;
        if (bVar != null) {
            t = bVar.t(context, str);
            AppMethodBeat.o(24356);
            return t;
        }
        t = "";
        AppMethodBeat.o(24356);
        return t;
    }
}
