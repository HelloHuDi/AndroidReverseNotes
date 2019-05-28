package com.tencent.p177mm.plugin.record.p493ui.p494b;

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
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26408ad.C26409b;
import com.tencent.p177mm.model.C26408ad.C26410a;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.p874a.C42218c;
import com.tencent.p177mm.p1186bq.C18114a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p198aw.C9059f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.record.p492b.C21601g;
import com.tencent.p177mm.plugin.record.p492b.C43436n;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a.C3711c;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a.C3712a;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3713b;
import com.tencent.p177mm.plugin.record.p493ui.RecordMsgDetailUI;
import com.tencent.p177mm.plugin.record.p493ui.RecordMsgFileUI;
import com.tencent.p177mm.plugin.record.p493ui.p1619a.C43438b;
import com.tencent.p177mm.pluginsdk.C30034d;
import com.tencent.p177mm.pluginsdk.model.C46496d;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C44094a;
import com.tencent.p177mm.protocal.protobuf.aap;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aas;
import com.tencent.p177mm.protocal.protobuf.aat;
import com.tencent.p177mm.protocal.protobuf.aay;
import com.tencent.p177mm.protocal.protobuf.abe;
import com.tencent.p177mm.protocal.protobuf.abo;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.record.ui.b.b */
public final class C46167b implements C3713b {
    private C4884c hAA = new C461663();
    C7306ak handler;
    private int moM = 0;
    private OnClickListener moP = new C395782();
    private C3709a pKt;
    boolean pLc = false;
    OnClickListener pLd = new C288411();

    /* renamed from: com.tencent.mm.plugin.record.ui.b.b$1 */
    class C288411 implements OnClickListener {
        C288411() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x00a4  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:224:0x090e  */
        /* JADX WARNING: Removed duplicated region for block: B:228:0x093b  */
        /* JADX WARNING: Removed duplicated region for block: B:227:0x0939  */
        /* JADX WARNING: Removed duplicated region for block: B:229:0x093d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(View view) {
            AppMethodBeat.m2504i(24350);
            C43438b c43438b = (C43438b) view.getTag();
            String str;
            Intent intent;
            String str2;
            Intent intent2;
            Bundle tL;
            Intent intent3;
            Context context;
            switch (c43438b.cAv.dataType) {
                case 4:
                case 15:
                    Context context2 = view.getContext();
                    if ((C5046bo.isNullOrNil(c43438b.cAv.wfZ) && C5046bo.isNullOrNil(c43438b.cAv.whr)) || c43438b.cAv.wgu <= 0) {
                        C4990ab.m7421w("MicroMsg.OtherViewWrapper", "full md5[%s], fullsize[%d], start use url", c43438b.cAv.wgq, Long.valueOf(c43438b.cAv.wgu));
                        str = c43438b.cAv.wgg;
                        if (C5046bo.isNullOrNil(str)) {
                            str = c43438b.cAv.wgk;
                        }
                        if (C5046bo.isNullOrNil(str)) {
                            C4990ab.m7421w("MicroMsg.OtherViewWrapper", "go to video[webpage] error, url null, dataid[%s]", c43438b.cAv.mnd);
                            if (c43438b.dataType == 1 && c43438b.mnW.field_itemStatus != 10 && c43438b.cAv.whh == 0) {
                                intent = new Intent();
                                intent.putExtra("key_detail_info_id", c43438b.mnW.field_localId);
                                intent.putExtra("key_detail_data_id", c43438b.cAv.mnd);
                                if (C21601g.m33079c(c43438b)) {
                                    C46167b.m86199a(intent, c43438b, context2, C21601g.m33077a(c43438b), C21601g.m33078b(c43438b));
                                    AppMethodBeat.m2505o(24350);
                                    return;
                                }
                                C39037b.m66352a(context2, ".ui.detail.FavoriteFileDetailUI", intent, 1);
                                AppMethodBeat.m2505o(24350);
                                return;
                            }
                            Intent intent4 = new Intent();
                            str2 = "";
                            str = "";
                            if (c43438b.dataType == 0) {
                                str = C43436n.m77562f(c43438b.cAv, c43438b.cvx);
                                if (C5046bo.isNullOrNil(str) || !C1173e.m2561ct(str)) {
                                    C30379h.m48465bQ(context2, context2.getString(C25738R.string.bqx));
                                    AppMethodBeat.m2505o(24350);
                                    return;
                                }
                                str2 = C43436n.m77558c(c43438b.cAv, c43438b.cvx);
                                if (C5046bo.isNullOrNil(str2) || !C1173e.m2561ct(str2)) {
                                    intent4.putExtra("key_detail_data_valid", false);
                                }
                            } else if (c43438b.dataType == 1) {
                                str = C21601g.m33078b(c43438b);
                                if (C5046bo.isNullOrNil(str) || !C1173e.m2561ct(str)) {
                                    C30379h.m48465bQ(context2, context2.getString(C25738R.string.bqx));
                                    AppMethodBeat.m2505o(24350);
                                    return;
                                }
                                str2 = C21601g.m33077a(c43438b);
                                if (C5046bo.isNullOrNil(str2) || !C1173e.m2561ct(str2)) {
                                    intent4.putExtra("key_detail_data_valid", false);
                                }
                            }
                            C46167b.m86199a(intent4, c43438b, context2, str2, str);
                            AppMethodBeat.m2505o(24350);
                            return;
                        }
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str);
                        if (c43438b.dataType == 1) {
                            intent2.putExtra("is_favorite_item", true);
                            intent2.putExtra("fav_local_id", c43438b.mnW.field_localId);
                            intent2.putExtra("key_detail_can_delete", false);
                            intent2.putExtra("geta8key_scene", 14);
                            tL = C42218c.m74509tL(C46496d.class.getName());
                            tL.putInt("mm_rpt_fav_id", c43438b.mnW.field_id);
                            intent2.putExtra("mm_report_bundle", tL);
                            C4990ab.m7411d("MicroMsg.OtherViewWrapper", "go to video, fav id %d, fav local id %d, data id %s", Integer.valueOf(c43438b.mnW.field_id), Long.valueOf(c43438b.mnW.field_localId), c43438b.cAv.mnd);
                        }
                        C25985d.m41468b(context2, "webview", ".ui.tools.WebViewUI", intent2, 1);
                        AppMethodBeat.m2505o(24350);
                        return;
                    } else if (c43438b.dataType == 0) {
                        intent = new Intent();
                        intent.putExtra("message_id", c43438b.cvx);
                        intent.putExtra("record_xml", c43438b.cKa);
                        intent.putExtra("record_data_id", c43438b.cAv.mnd);
                        intent.putExtra("key_detail_fav_video_scene_from", 1);
                        if (C43436n.m77560d(c43438b.cAv, c43438b.cvx)) {
                            C46167b.m86199a(intent, c43438b, context2, C43436n.m77558c(c43438b.cAv, c43438b.cvx), C43436n.m77562f(c43438b.cAv, c43438b.cvx));
                            AppMethodBeat.m2505o(24350);
                            return;
                        }
                        C25985d.m41468b(context2, "record", ".ui.RecordMsgFileUI", intent, 1);
                        AppMethodBeat.m2505o(24350);
                        return;
                    } else {
                        if (c43438b.dataType == 1) {
                            intent = new Intent();
                            intent.putExtra("key_detail_info_id", c43438b.mnW.field_localId);
                            intent.putExtra("key_detail_data_id", c43438b.cAv.mnd);
                            if (C21601g.m33079c(c43438b)) {
                                C46167b.m86199a(intent, c43438b, context2, C21601g.m33077a(c43438b), C21601g.m33078b(c43438b));
                                AppMethodBeat.m2505o(24350);
                                return;
                            }
                            C39037b.m66352a(context2, ".ui.detail.FavoriteFileDetailUI", intent, 1);
                        }
                        AppMethodBeat.m2505o(24350);
                        return;
                    }
                case 5:
                    Context context3 = view.getContext();
                    if (c43438b.cAv.wgT == null) {
                        C4990ab.m7421w("MicroMsg.OtherViewWrapper", "go to web page error, get data proto item null, dataid[%s]", c43438b.cAv.mnd);
                        C30379h.m48465bQ(context3, context3.getString(C25738R.string.bqw));
                        AppMethodBeat.m2505o(24350);
                        return;
                    }
                    aar aar = c43438b.cAv;
                    if (aar != null) {
                        if (aar.whe) {
                            str = aar.canvasPageXml;
                        } else if (!(aar.wgT == null || aar.wgT.whA == null || !aar.wgT.whA.whe)) {
                            str = aar.wgT.whA.canvasPageXml;
                        }
                        if (C5046bo.isNullOrNil(str)) {
                            intent2 = new Intent();
                            intent2.putExtra("sns_landing_pages_xml", str);
                            intent2.putExtra("sns_landig_pages_from_source", 5);
                            intent2.putExtra("sns_landing_pages_share_thumb_url", c43438b.cAv.fgE);
                            intent2.addFlags(268435456);
                            intent2.putExtra("msg_id", c43438b.cvx);
                            C25985d.m41468b(context3, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent2, 1);
                            AppMethodBeat.m2505o(24350);
                            return;
                        }
                        aat aat = c43438b.cAv.wgT.whw;
                        str = "";
                        if (c43438b.cAv.wgT.whA != null) {
                            str = c43438b.cAv.wgT.whA.wiY;
                        }
                        if (aat != null && C5046bo.isNullOrNil(r1)) {
                            str = aat.link;
                        }
                        if (C5046bo.isNullOrNil(str)) {
                            str = c43438b.cAv.wgg;
                        }
                        if (C5046bo.isNullOrNil(str)) {
                            C4990ab.m7421w("MicroMsg.OtherViewWrapper", "go to web page error, url null, dataid[%s]", c43438b.cAv.mnd);
                            C30379h.m48465bQ(context3, context3.getString(C25738R.string.bqw));
                            AppMethodBeat.m2505o(24350);
                            return;
                        }
                        intent3 = new Intent();
                        intent3.putExtra("rawUrl", str);
                        if (!(aat == null || C5046bo.isNullOrNil(aat.csl))) {
                            intent3.putExtra("srcDisplayname", C1854s.m3866mJ(aat.csl));
                        }
                        intent3.putExtra("mode", 1);
                        C46167b.m86198A(context3, intent3);
                        if (c43438b.dataType == 1) {
                            intent3.putExtra("is_favorite_item", true);
                            intent3.putExtra("fav_local_id", c43438b.mnW.field_localId);
                            intent3.putExtra("key_detail_can_delete", false);
                            intent3.putExtra("geta8key_scene", 14);
                            intent3.putExtra("from_scence", 4);
                            tL = C42218c.m74509tL(C46496d.class.getName());
                            tL.putInt("mm_rpt_fav_id", c43438b.mnW.field_id);
                            intent3.putExtra("mm_report_bundle", tL);
                        }
                        tL = new Bundle();
                        tL.putString("key_snsad_statextstr", c43438b.cAv.cMn);
                        intent3.putExtra("jsapiargs", tL);
                        C25985d.m41468b(context3, "webview", ".ui.tools.WebViewUI", intent3, 1);
                        AppMethodBeat.m2505o(24350);
                        return;
                    }
                    str = null;
                    if (C5046bo.isNullOrNil(str)) {
                    }
                case 6:
                    Context context4 = view.getContext();
                    if (context4 != null) {
                        aay aay;
                        aat aat2;
                        if (c43438b.cAv.wgT != null) {
                            aay = c43438b.cAv.wgT.why;
                            aat2 = c43438b.cAv.wgT.whw;
                        } else {
                            aat2 = null;
                            aay = null;
                        }
                        if (aat2 == null) {
                            str = null;
                        } else if (C5046bo.isNullOrNil(aat2.whU)) {
                            str = C1854s.m3866mJ(aat2.cEV);
                        } else {
                            str = C1854s.m3866mJ(aat2.whU);
                        }
                        if (aat2 == null && c43438b.dataType == 1) {
                            str = C1854s.m3866mJ(c43438b.mnW.field_fromUser);
                        }
                        if (aay == null) {
                            C4990ab.m7421w("MicroMsg.OtherViewWrapper", "go to location error, locItem null, dataid[%s]", c43438b.cAv.mnd);
                            C30379h.m48465bQ(context4, context4.getString(C25738R.string.bqo));
                            AppMethodBeat.m2505o(24350);
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
                        if (c43438b.dataType == 1) {
                            intent2.putExtra("KFavLocSigleView", true);
                            intent2.putExtra("map_view_type", 2);
                            intent2.putExtra("kFavInfoLocalId", c43438b.mnW.field_localId);
                            intent2.putExtra("kFavCanDel", false);
                            intent2.putExtra("kFavCanRemark", false);
                            C25985d.m41468b(context4, C8741b.LOCATION, ".ui.RedirectUI", intent2, 1);
                            AppMethodBeat.m2505o(24350);
                            return;
                        }
                        if (c43438b.dataType == 0) {
                            intent2.putExtra("map_view_type", 1);
                            C25985d.m41468b(context4, C8741b.LOCATION, ".ui.RedirectUI", intent2, 1002);
                        }
                        AppMethodBeat.m2505o(24350);
                        return;
                    }
                    break;
                case 7:
                    context = view.getContext();
                    intent2 = new Intent();
                    if (C5046bo.isNullOrNil(c43438b.cAv.wgg)) {
                        C4990ab.m7421w("MicroMsg.OtherViewWrapper", "go to music[webpage], web url is null, use data url instead, dataid[%s]", c43438b.cAv.mnd);
                        intent2.putExtra("rawUrl", c43438b.cAv.wgi);
                    } else {
                        intent2.putExtra("rawUrl", c43438b.cAv.wgg);
                    }
                    if (c43438b.dataType == 1) {
                        intent2.putExtra("is_favorite_item", true);
                        intent2.putExtra("fav_local_id", c43438b.mnW.field_localId);
                        intent2.putExtra("key_detail_can_delete", false);
                        Bundle tL2 = C42218c.m74509tL(C46496d.class.getName());
                        tL2.putInt("mm_rpt_fav_id", c43438b.mnW.field_id);
                        intent2.putExtra("mm_report_bundle", tL2);
                        C4990ab.m7411d("MicroMsg.OtherViewWrapper", "start music webview, fav id %d, fav local id %d, data id %s", Integer.valueOf(c43438b.mnW.field_id), Long.valueOf(c43438b.mnW.field_localId), c43438b.cAv.mnd);
                    }
                    C25985d.m41468b(context, "webview", ".ui.tools.WebViewUI", intent2, 1);
                    AppMethodBeat.m2505o(24350);
                    return;
                case 8:
                    int i;
                    Context context5 = view.getContext();
                    if (c43438b.dataType == 0) {
                        if (C43436n.m77560d(c43438b.cAv, c43438b.cvx) && !C44094a.m79366M(C43436n.m77558c(c43438b.cAv, c43438b.cvx), c43438b.cAv.wgo, 2)) {
                            i = 0;
                        }
                        i = 1;
                    } else {
                        if (c43438b.dataType == 1 && C21601g.m33079c(c43438b) && !C44094a.m79366M(C21601g.m33077a(c43438b), c43438b.cAv.wgo, 2)) {
                            i = 0;
                        }
                        i = 1;
                    }
                    if (i != 0) {
                        if (c43438b.dataType == 0) {
                            intent = new Intent(context5, RecordMsgFileUI.class);
                            intent.putExtra("message_id", c43438b.cvx);
                            intent.putExtra("record_xml", c43438b.cKa);
                            intent.putExtra("record_data_id", c43438b.cAv.mnd);
                            context5.startActivity(intent);
                            AppMethodBeat.m2505o(24350);
                            return;
                        } else if (c43438b.dataType == 1) {
                            if (C43436n.m77565h(c43438b.cAv, c43438b.cvx)) {
                                intent = new Intent();
                                intent.putExtra("key_detail_info_id", c43438b.mnW.field_localId);
                                C39037b.m66352a(context5, ".ui.detail.FavoriteImgDetailUI", intent, 1);
                                AppMethodBeat.m2505o(24350);
                                return;
                            }
                            intent = new Intent();
                            intent.putExtra("key_detail_info_id", c43438b.mnW.field_localId);
                            intent.putExtra("key_detail_data_id", c43438b.cAv.mnd);
                            intent.putExtra("key_detail_can_delete", false);
                            C39037b.m66352a(context5, ".ui.detail.FavoriteFileDetailUI", intent, 1);
                        }
                    }
                    AppMethodBeat.m2505o(24350);
                    return;
                case 10:
                    context = view.getContext();
                    if (c43438b.cAv.wgT == null || c43438b.cAv.wgT.whC == null) {
                        C4990ab.m7421w("MicroMsg.OtherViewWrapper", "go to product error, get data proto item null, dataid[%s]", c43438b.cAv.mnd);
                        C30379h.m48465bQ(context, context.getString(C25738R.string.bqn));
                        AppMethodBeat.m2505o(24350);
                        return;
                    }
                    intent2 = new Intent();
                    intent2.putExtra("key_Product_xml", c43438b.cAv.wgT.whC.info);
                    if (c43438b.dataType == 1) {
                        intent2.putExtra("key_is_favorite_item", true);
                        intent2.putExtra("key_favorite_local_id", c43438b.mnW.field_localId);
                        intent2.putExtra("key_can_delete_favorite_item", false);
                        intent2.putExtra("key_ProductUI_getProductInfoScene", 3);
                    }
                    C25985d.m41468b(context, "scanner", ".ui.ProductUI", intent2, 1);
                    AppMethodBeat.m2505o(24350);
                    return;
                case 11:
                    context = view.getContext();
                    if (c43438b.cAv.wgT == null || c43438b.cAv.wgT.whC == null) {
                        C4990ab.m7421w("MicroMsg.OtherViewWrapper", "go to mall product error, get data proto item null, dataid[%s]", c43438b.cAv.mnd);
                        C30379h.m48465bQ(context, context.getString(C25738R.string.bqn));
                        AppMethodBeat.m2505o(24350);
                        return;
                    }
                    intent2 = new Intent();
                    intent2.putExtra("key_product_info", c43438b.cAv.wgT.whC.info);
                    if (c43438b.dataType == 1) {
                        intent2.putExtra("key_product_scene", 4);
                    }
                    C25985d.m41468b(context, "product", ".ui.MallProductUI", intent2, 1);
                    AppMethodBeat.m2505o(24350);
                    return;
                case 14:
                    context = view.getContext();
                    if (c43438b.cAv.wgT == null || c43438b.cAv.wgT.whE == null) {
                        C4990ab.m7421w("MicroMsg.OtherViewWrapper", "go to tv error, get data proto item null, dataid[%s]", c43438b.cAv.mnd);
                        C30379h.m48465bQ(context, context.getString(C25738R.string.bqn));
                        AppMethodBeat.m2505o(24350);
                        return;
                    }
                    intent2 = new Intent();
                    intent2.putExtra("key_TV_getProductInfoScene", 3);
                    intent2.putExtra("key_TV_xml", c43438b.cAv.wgT.whE.info);
                    if (c43438b.dataType == 1) {
                        intent2.putExtra("key_is_favorite_item", true);
                        intent2.putExtra("key_favorite_local_id", c43438b.mnW.field_localId);
                        intent2.putExtra("key_can_delete_favorite_item", false);
                    }
                    C25985d.m41468b(context, "shake", ".ui.TVInfoUI", intent2, 1);
                    AppMethodBeat.m2505o(24350);
                    return;
                case 16:
                    context = view.getContext();
                    if (c43438b.cAv.wgT == null) {
                        C4990ab.m7421w("MicroMsg.OtherViewWrapper", "go to friend card error, get data proto item null, dataid[%s]", c43438b.cAv.mnd);
                        C30379h.m48465bQ(context, context.getString(C25738R.string.bqn));
                        AppMethodBeat.m2505o(24350);
                        return;
                    }
                    str2 = c43438b.cAv.desc;
                    C9638aw.m17190ZK();
                    C5135a Rn = C18628c.m29080XO().mo15260Rn(str2);
                    if (Rn == null) {
                        C4990ab.m7421w("MicroMsg.OtherViewWrapper", "go to friend card error, parse content fail,[%s], dataid[%s]", str2, c43438b.cAv.mnd);
                        C30379h.m48465bQ(context, context.getString(C25738R.string.bqn));
                        AppMethodBeat.m2505o(24350);
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
                    C46167b.m86198A(context, intent5);
                    C25985d.m41468b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent5, 1);
                    C18114a.m28535Lu(Rn.scene);
                    AppMethodBeat.m2505o(24350);
                    return;
                case 17:
                    context = view.getContext();
                    if (context != null) {
                        if (c43438b.dataType == 0 && c43438b.cAv.whj != null) {
                            intent2 = new Intent(context, RecordMsgDetailUI.class);
                            intent2.putExtra("message_id", c43438b.cvx);
                            intent2.putExtra("record_xml", c43438b.cAv.whj);
                            C46167b.m86198A(context, intent2);
                            context.startActivity(intent2);
                        }
                        AppMethodBeat.m2505o(24350);
                        return;
                    }
                    break;
                case 19:
                    context = view.getContext();
                    if (context != null) {
                        aas aas = c43438b.cAv.wgT;
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
                                        ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(context, aap.username, aap.appId, aap.cBc, -1, aap.csu, appBrandStatObject);
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
                                ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(context, aap.username, aap.appId, aap.cBc, -1, aap.csu, appBrandStatObject);
                            }
                        }
                        AppMethodBeat.m2505o(24350);
                        return;
                    }
                    break;
                default:
                    AppMethodBeat.m2505o(24350);
                    return;
            }
            AppMethodBeat.m2505o(24350);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.b.b$2 */
    class C395782 implements OnClickListener {
        C395782() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24351);
            if (C1445f.m3070Mn()) {
                C43438b c43438b = (C43438b) view.getTag();
                aat aat = c43438b.cAv.wgT.whw;
                if (C46167b.m86200e(c43438b.cAv)) {
                    C4990ab.m7416i("MicroMsg.OtherViewWrapper", "same song, do release");
                    C37494a.aic();
                    if (!C46167b.this.pLc) {
                        C46167b.this.handler.sendMessageAtFrontOfQueue(C46167b.this.handler.obtainMessage(1));
                        AppMethodBeat.m2505o(24351);
                        return;
                    }
                }
                String absolutePath;
                C46167b.this.pLc = true;
                File file = new File(C43436n.m77562f(c43438b.cAv, c43438b.cvx));
                if (file.exists()) {
                    absolutePath = file.getAbsolutePath();
                } else if (c43438b.cAv.cvq == null) {
                    absolutePath = "";
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    C9638aw.m17190ZK();
                    file = new File(stringBuilder.append(C18628c.m29098Yg()).append("web/").append(C1178g.m2591x(c43438b.cAv.cvq.getBytes())).toString());
                    absolutePath = file.exists() ? file.getAbsolutePath() : "";
                }
                aar aar = c43438b.cAv;
                String str = aar.title;
                String str2 = aar.desc;
                String str3 = aar.wgg;
                String str4 = aar.wgk;
                String str5 = aar.wgi;
                String str6 = aar.mnd;
                StringBuilder stringBuilder2 = new StringBuilder();
                C9638aw.m17190ZK();
                C37494a.m63280b(C9059f.m16431a(6, null, str, str2, str3, str4, str5, str6, stringBuilder2.append(C18628c.m29098Yg()).append("web/").toString(), absolutePath, "", aat.appId));
                AppMethodBeat.m2505o(24351);
                return;
            }
            C23639t.m36492hO(view.getContext());
            AppMethodBeat.m2505o(24351);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.b.b$3 */
    class C461663 extends C4884c<C37752ke> {
        C461663() {
            super(0);
            AppMethodBeat.m2504i(24352);
            this.xxI = C37752ke.class.getName().hashCode();
            AppMethodBeat.m2505o(24352);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(24353);
            C37752ke c37752ke = (C37752ke) c4883b;
            if (c37752ke instanceof C37752ke) {
                switch (c37752ke.cFH.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        C46167b.this.handler.sendMessageAtFrontOfQueue(C46167b.this.handler.obtainMessage(1));
                        break;
                }
            }
            AppMethodBeat.m2505o(24353);
            return false;
        }
    }

    public C46167b(C3709a c3709a, C7306ak c7306ak) {
        AppMethodBeat.m2504i(24354);
        this.pKt = c3709a;
        this.handler = c7306ak;
        AppMethodBeat.m2505o(24354);
    }

    /* renamed from: eK */
    public final View mo8346eK(Context context) {
        AppMethodBeat.m2504i(24355);
        View inflate = View.inflate(context, 2130970482, null);
        this.moM = C1338a.fromDPToPix(context, 75);
        C4879a.xxA.mo10052c(this.hAA);
        AppMethodBeat.m2505o(24355);
        return inflate;
    }

    /* renamed from: e */
    public static boolean m86200e(aar aar) {
        AppMethodBeat.m2504i(24357);
        C9058e aih = C37494a.aih();
        if (aih != null && aih.fJS == 6 && C5046bo.m7532bc(aar.mnd, "").equals(aih.fJU) && C37494a.aie()) {
            AppMethodBeat.m2505o(24357);
            return true;
        }
        AppMethodBeat.m2505o(24357);
        return false;
    }

    @SuppressLint({"ResourceType"})
    /* renamed from: a */
    public final void mo8344a(View view, int i, C43438b c43438b) {
        AppMethodBeat.m2504i(24358);
        TextView textView = (TextView) view.findViewById(2131820678);
        TextView textView2 = (TextView) view.findViewById(2131821095);
        TextView textView3 = (TextView) view.findViewById(2131826911);
        MMImageView mMImageView = (MMImageView) view.findViewById(2131820915);
        mMImageView.setVisibility(0);
        ImageView imageView = (ImageView) view.findViewById(2131826910);
        imageView.setVisibility(8);
        View findViewById = view.findViewById(2131826907);
        findViewById.setVisibility(0);
        findViewById.setTag(c43438b);
        findViewById.setOnClickListener(this.pLd);
        View findViewById2 = view.findViewById(2131826909);
        findViewById2.setVisibility(8);
        C3712a c3712a = new C3712a();
        if (c43438b.dataType == 0) {
            c3712a.pKv = c43438b.cvx;
        } else if (c43438b.dataType == 1) {
            c3712a.pKv = c43438b.mnW.field_localId;
        }
        c3712a.cAw = mMImageView;
        c3712a.cAv = c43438b.cAv;
        c3712a.height = this.moM;
        c3712a.width = this.moM;
        aar aar;
        int i2;
        String appName;
        aar aar2;
        aar aar3;
        switch (c43438b.cAv.dataType) {
            case 4:
            case 15:
                aar = c43438b.cAv;
                if (C5046bo.isNullOrNil(aar.title)) {
                    textView.setText(C25738R.string.bs9);
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
                        string = context.getString(C25738R.string.bsa, new Object[]{Integer.valueOf(0)});
                    } else {
                        i2 = i3 / 60;
                        i3 %= 60;
                        if (i2 == 0) {
                            string = context.getString(C25738R.string.bsa, new Object[]{Integer.valueOf(i3)});
                        } else {
                            string = context.getString(C25738R.string.bs_, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                        }
                    }
                    textView2.setText(string);
                }
                if (aar.wgT == null) {
                    C4990ab.m7421w("MicroMsg.OtherViewWrapper", "video, get data proto item null, dataid[%s]", aar.mnd);
                    textView3.setVisibility(8);
                } else {
                    aat aat = aar.wgT.whw;
                    if (!C5046bo.isNullOrNil(aat.appId)) {
                        appName = C46167b.getAppName(textView3.getContext(), aat.appId);
                        if (C5046bo.isNullOrNil(appName)) {
                            textView3.setVisibility(8);
                        } else {
                            textView3.setVisibility(0);
                            textView3.setText(appName);
                        }
                    }
                }
                imageView.setVisibility(0);
                imageView.setImageResource(C25738R.drawable.aql);
                c3712a.cAx = C1318a.app_attach_file_icon_video;
                this.pKt.mo8342a(c3712a);
                break;
            case 5:
                aar2 = c43438b.cAv;
                String str = "";
                abu abu = null;
                if (!(aar2 == null || aar2.wgT == null)) {
                    abu = aar2.wgT.whA;
                }
                if (abu != null) {
                    str = abu.title;
                }
                if (C5046bo.isNullOrNil(str) && aar2 != null) {
                    str = aar2.title;
                }
                if (C5046bo.isNullOrNil(str)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(str);
                    textView.setVisibility(0);
                }
                textView2.setVisibility(8);
                appName = "";
                if (abu != null) {
                    appName = C5046bo.anh(abu.wiY);
                }
                aat aat2 = null;
                if (!(aar2 == null || aar2.wgT == null)) {
                    aat2 = aar2.wgT.whw;
                }
                if (aat2 != null) {
                    if (!C5046bo.isNullOrNil(aat2.appId)) {
                        appName = C5046bo.m7532bc(C46167b.getAppName(textView3.getContext(), aat2.appId), "");
                    } else if (!C5046bo.isNullOrNil(aat2.csl)) {
                        C9638aw.m17190ZK();
                        C7616ad aoO = C18628c.m29078XM().aoO(aat2.csl);
                        if (aoO == null || !aoO.field_username.equals(aat2.csl)) {
                            C26417a.flu.mo20966a(aat2.csl, "", null);
                        } else {
                            appName = aoO.mo16707Oj();
                        }
                    }
                    if (C5046bo.isNullOrNil(appName) || appName.equals(aat2.csl)) {
                        appName = C5046bo.anh(aat2.link);
                    }
                }
                if (C5046bo.isNullOrNil(appName)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setText(appName);
                    textView3.setVisibility(0);
                }
                c3712a.cAx = C25738R.drawable.avp;
                this.pKt.mo8342a(c3712a);
                break;
            case 6:
                aar3 = c43438b.cAv;
                if (aar3.wgT == null) {
                    C4990ab.m7421w("MicroMsg.OtherViewWrapper", "location, get data proto item null, dataid[%s]", aar3.mnd);
                    textView.setText(C25738R.string.bpj);
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    aay aay = aar3.wgT.why;
                    if (C5046bo.isNullOrNil(aay.cIK)) {
                        textView.setText(aay.label);
                        textView2.setText(C25738R.string.bpj);
                        textView3.setText("");
                    } else {
                        textView.setText(aay.cIK);
                        textView2.setText(aay.label);
                        textView3.setText(C25738R.string.bpj);
                    }
                }
                mMImageView.setImageResource(C1318a.app_attach_file_icon_location);
                break;
            case 7:
                textView.setText(c43438b.cAv.title);
                textView2.setText(c43438b.cAv.desc);
                imageView.setTag(c43438b);
                imageView.setOnClickListener(this.moP);
                imageView.setImageResource(C25738R.drawable.f6932vs);
                imageView.setVisibility(0);
                if (C46167b.m86200e(c43438b.cAv)) {
                    imageView.setImageResource(C25738R.drawable.f6930vq);
                }
                textView3.setVisibility(8);
                c3712a.cAx = C1318a.app_attach_file_icon_music;
                this.pKt.mo8342a(c3712a);
                break;
            case 8:
                aar3 = c43438b.cAv;
                textView.setText(aar3.title);
                textView2.setVisibility(0);
                textView2.setText(C5046bo.m7518aC((float) aar3.wgu));
                textView3.setVisibility(8);
                if (aar3.whh == 2) {
                    textView2.setText(">25MB");
                }
                mMImageView.setImageResource(C30034d.ail(c43438b.cAv.wgo));
                break;
            case 10:
                aar = c43438b.cAv;
                if (aar.wgT == null) {
                    C4990ab.m7421w("MicroMsg.OtherViewWrapper", "product, get data proto item null, dataid[%s]", aar.mnd);
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    abe abe = aar.wgT.whC;
                    textView.setText(abe.title);
                    textView2.setText(abe.desc);
                    textView3.setText(C5046bo.m7532bc(C46167b.getAppName(textView3.getContext(), aar.wgT.whw.appId), textView3.getContext().getString(C25738R.string.bqc)));
                }
                c3712a.cAx = C1318a.app_attach_file_icon_unknow;
                this.pKt.mo8342a(c3712a);
                break;
            case 11:
                aar = c43438b.cAv;
                if (aar.wgT == null) {
                    C4990ab.m7421w("MicroMsg.OtherViewWrapper", "mall product, get data proto item null, dataid[%s]", aar.mnd);
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
                c3712a.cAx = C1318a.app_attach_file_icon_unknow;
                c3712a.cAv = null;
                this.pKt.mo8342a(c3712a);
                break;
            case 14:
                aar = c43438b.cAv;
                if (aar.wgT == null || aar.wgT.whE == null) {
                    C4990ab.m7421w("MicroMsg.OtherViewWrapper", "tv, get data proto item null, dataid[%s]", aar.mnd);
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    abo abo = aar.wgT.whE;
                    textView.setText(abo.title);
                    textView2.setText(abo.desc);
                    textView3.setText(C5046bo.m7532bc(C46167b.getAppName(textView3.getContext(), aar.wgT.whw.appId), textView3.getContext().getString(C25738R.string.bs5)));
                }
                c3712a.cAx = C1318a.app_attach_file_icon_unknow;
                c3712a.cAv = null;
                this.pKt.mo8342a(c3712a);
                break;
            case 16:
                CharSequence charSequence;
                aar3 = c43438b.cAv;
                C9638aw.m17190ZK();
                C5135a Rn = C18628c.m29080XO().mo15260Rn(aar3.desc);
                if (Rn == null) {
                    C4990ab.m7412e("MicroMsg.OtherViewWrapper", "parse possible friend msg failed");
                }
                Context context2 = textView.getContext();
                if (Rn != null) {
                    charSequence = Rn.nickname;
                } else {
                    charSequence = "";
                }
                textView.setText(C44089j.m79293b(context2, charSequence, textView.getTextSize()));
                textView2.setVisibility(8);
                textView3.setText(C25738R.string.bp3);
                textView3.setVisibility(0);
                appName = Rn.svN;
                if (!C5046bo.isNullOrNil(appName)) {
                    C40460b.m69434b(mMImageView, appName);
                    break;
                } else {
                    mMImageView.setImageResource(C25738R.drawable.ad2);
                    break;
                }
            case 17:
                aar3 = c43438b.cAv;
                textView.setText(aar3.title);
                textView2.setVisibility(0);
                textView2.setText(aar3.desc);
                mMImageView.setVisibility(8);
                break;
            case 19:
                aar2 = c43438b.cAv;
                i2 = c43438b.cAv.dataType;
                String str2 = "";
                if (aar2 != null) {
                    str2 = aar2.title;
                }
                if (C5046bo.isNullOrNil(str2)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(str2);
                    textView.setVisibility(0);
                }
                appName = "";
                if (19 == i2) {
                    appName = textView2.getContext().getString(C25738R.string.f8887i9);
                }
                if (C5046bo.isNullOrNil(appName)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(appName);
                    textView2.setVisibility(0);
                }
                C3711c c3711c = new C3711c();
                c3711c.cAv = c43438b.cAv;
                if (c43438b.dataType == 0) {
                    c3711c.pKv = c43438b.cvx;
                } else if (c43438b.dataType == 1) {
                    c3711c.pKv = c43438b.mnW.field_localId;
                }
                c3712a.cAx = C25738R.drawable.avp;
                Bitmap a = this.pKt.mo8341a(c3711c);
                if (a == null) {
                    this.pKt.mo8342a(c3712a);
                    break;
                } else {
                    mMImageView.setImageBitmap(a);
                    break;
                }
            default:
                findViewById.setVisibility(8);
                findViewById2.setVisibility(0);
                AppMethodBeat.m2505o(24358);
                return;
        }
        textView3.setVisibility(8);
        AppMethodBeat.m2505o(24358);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(24359);
        C4990ab.m7410d("MicroMsg.OtherViewWrapper", "do destroy");
        this.pKt = null;
        this.handler = null;
        C4879a.xxA.mo10053d(this.hAA);
        this.pLc = false;
        AppMethodBeat.m2505o(24359);
    }

    public final void pause() {
    }

    /* renamed from: a */
    static void m86199a(Intent intent, C43438b c43438b, Context context, String str, String str2) {
        AppMethodBeat.m2504i(24360);
        intent.putExtra("key_detail_fav_path", str);
        intent.putExtra("key_detail_fav_thumb_path", str2);
        intent.putExtra("key_detail_fav_video_duration", c43438b.cAv.duration);
        intent.putExtra("key_detail_statExtStr", c43438b.cAv.cMn);
        C39037b.m66352a(context, ".ui.detail.FavoriteVideoPlayUI", intent, 1);
        AppMethodBeat.m2505o(24360);
    }

    /* renamed from: A */
    static void m86198A(Context context, Intent intent) {
        AppMethodBeat.m2504i(24361);
        if (context instanceof Activity) {
            Intent intent2 = ((Activity) context).getIntent();
            if (intent2 != null) {
                intent.putExtra("prePublishId", intent2.getStringExtra("prePublishId"));
                intent.putExtra("preUsername", intent2.getStringExtra("preUsername"));
                intent.putExtra("preChatName", intent2.getStringExtra("preChatName"));
                intent.putExtra("preChatTYPE", intent2.getIntExtra("preChatTYPE", 0));
            }
        }
        AppMethodBeat.m2505o(24361);
    }

    private static String getAppName(Context context, String str) {
        AppMethodBeat.m2504i(24356);
        C26409b c26409b = C26410a.fls;
        String t;
        if (c26409b != null) {
            t = c26409b.mo44181t(context, str);
            AppMethodBeat.m2505o(24356);
            return t;
        }
        t = "";
        AppMethodBeat.m2505o(24356);
        return t;
    }
}
