package com.tencent.p177mm.plugin.card.p931d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.p177mm.protocal.protobuf.C15320ax;
import com.tencent.p177mm.protocal.protobuf.C15368nz;
import com.tencent.p177mm.protocal.protobuf.C15395wy;
import com.tencent.p177mm.protocal.protobuf.C15396wz;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import com.tencent.p177mm.protocal.protobuf.C30244xt;
import com.tencent.p177mm.protocal.protobuf.C35938no;
import com.tencent.p177mm.protocal.protobuf.C40543lh;
import com.tencent.p177mm.protocal.protobuf.C44151oi;
import com.tencent.p177mm.protocal.protobuf.C44153op;
import com.tencent.p177mm.protocal.protobuf.aci;
import com.tencent.p177mm.protocal.protobuf.arp;
import com.tencent.p177mm.protocal.protobuf.bzi;
import com.tencent.p177mm.protocal.protobuf.cgf;
import com.tencent.p177mm.protocal.protobuf.cma;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.card.d.f */
public final class C27575f {
    /* renamed from: Hf */
    public static ArrayList<ShareCardInfo> m43792Hf(String str) {
        AppMethodBeat.m2504i(88851);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.CardInfoParser", "parseShareCardArray jsonContent is null");
            AppMethodBeat.m2505o(88851);
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                C4990ab.m7412e("MicroMsg.CardInfoParser", "parseShareCardArray cardItemListJson is null");
                AppMethodBeat.m2505o(88851);
                return null;
            }
            ArrayList<ShareCardInfo> arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                ShareCardInfo shareCardInfo = new ShareCardInfo();
                C27575f.m43805a(shareCardInfo, optJSONObject);
                arrayList.add(shareCardInfo);
            }
            AppMethodBeat.m2505o(88851);
            return arrayList;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            AppMethodBeat.m2505o(88851);
            return null;
        }
    }

    /* renamed from: a */
    public static void m43804a(ShareCardInfo shareCardInfo, String str) {
        AppMethodBeat.m2504i(88852);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
            AppMethodBeat.m2505o(88852);
            return;
        }
        try {
            C27575f.m43805a(shareCardInfo, new JSONObject(str).optJSONObject("share_card"));
            AppMethodBeat.m2505o(88852);
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.CardInfoParser", e.getMessage());
            AppMethodBeat.m2505o(88852);
        }
    }

    /* renamed from: a */
    public static void m43805a(ShareCardInfo shareCardInfo, JSONObject jSONObject) {
        AppMethodBeat.m2504i(88853);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.CardInfoParser", "parserShareCardItemJson json is null");
            AppMethodBeat.m2505o(88853);
            return;
        }
        shareCardInfo.field_card_id = C27575f.m43794Hh(jSONObject.optString("card_id"));
        shareCardInfo.field_card_tp_id = C27575f.m43794Hh(jSONObject.optString("card_tp_id"));
        shareCardInfo.field_app_id = jSONObject.optString("app_id");
        shareCardInfo.field_consumer = jSONObject.optString("consumer");
        shareCardInfo.field_share_time = (long) jSONObject.optInt("share_time");
        shareCardInfo.field_updateTime = (long) jSONObject.optInt("update_time");
        shareCardInfo.field_status = jSONObject.optInt("state_flag");
        shareCardInfo.field_updateSeq = jSONObject.optLong("sequence");
        shareCardInfo.field_from_username = jSONObject.optString("from_user_name");
        shareCardInfo.field_begin_time = jSONObject.optLong("begin_time");
        shareCardInfo.field_end_time = (long) jSONObject.optInt("end_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("card_data_info");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("card_tp_info");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("share_info");
        shareCardInfo.kcZ = C27575f.m43791H(optJSONObject);
        shareCardInfo.kcY = C27575f.m43795I(optJSONObject2);
        shareCardInfo.kda = C27575f.m43796J(optJSONObject3);
        if (shareCardInfo.kcZ != null) {
            shareCardInfo.mo45388a(shareCardInfo.kcZ);
        }
        if (shareCardInfo.kcY != null) {
            shareCardInfo.mo45390a(shareCardInfo.kcY);
            shareCardInfo.field_end_time = (long) optJSONObject2.optInt("end_time");
            shareCardInfo.field_begin_time = (long) optJSONObject2.optInt("begin_time");
        }
        if (shareCardInfo.kda != null) {
            shareCardInfo.mo45387a(shareCardInfo.kda);
        }
        shareCardInfo.field_local_updateTime = (long) ((int) (System.currentTimeMillis() / 1000));
        AppMethodBeat.m2505o(88853);
    }

    /* renamed from: Hg */
    public static ArrayList<CardInfo> m43793Hg(String str) {
        AppMethodBeat.m2504i(88854);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.CardInfoParser", "parseCardArray jsonContent is null");
            AppMethodBeat.m2505o(88854);
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_array");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                C4990ab.m7412e("MicroMsg.CardInfoParser", "parseCardArray cardItemListJson is null");
                AppMethodBeat.m2505o(88854);
                return null;
            }
            ArrayList<CardInfo> arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                CardInfo cardInfo = new CardInfo();
                C27575f.m43803a(cardInfo, optJSONObject);
                arrayList.add(cardInfo);
            }
            AppMethodBeat.m2505o(88854);
            return arrayList;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            AppMethodBeat.m2505o(88854);
            return null;
        }
    }

    /* renamed from: a */
    public static void m43802a(CardInfo cardInfo, String str) {
        AppMethodBeat.m2504i(88855);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.CardInfoParser", "parserCardItemJson jsonContent is null");
            AppMethodBeat.m2505o(88855);
            return;
        }
        try {
            C27575f.m43803a(cardInfo, new JSONObject(str));
            AppMethodBeat.m2505o(88855);
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            AppMethodBeat.m2505o(88855);
        }
    }

    /* renamed from: a */
    private static void m43803a(CardInfo cardInfo, JSONObject jSONObject) {
        AppMethodBeat.m2504i(88856);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.CardInfoParser", "parserCardItemJson json is null");
            AppMethodBeat.m2505o(88856);
            return;
        }
        cardInfo.field_card_id = C27575f.m43794Hh(jSONObject.optString("card_id"));
        cardInfo.field_card_tp_id = C27575f.m43794Hh(jSONObject.optString("card_tp_id"));
        cardInfo.field_delete_state_flag = jSONObject.optInt("state_flag");
        cardInfo.field_updateTime = (long) jSONObject.optInt("update_time");
        cardInfo.field_updateSeq = jSONObject.optLong("sequence");
        cardInfo.field_from_username = jSONObject.optString("from_username");
        cardInfo.field_begin_time = jSONObject.optLong("begin_time", 0);
        cardInfo.field_end_time = jSONObject.optLong("end_time", 0);
        cardInfo.kbY = jSONObject.optString("encrypt_code");
        JSONObject optJSONObject = jSONObject.optJSONObject("card_data_info");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("card_tp_info");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("share_info");
        cardInfo.kcZ = C27575f.m43791H(optJSONObject);
        cardInfo.kcY = C27575f.m43795I(optJSONObject2);
        cardInfo.kda = C27575f.m43796J(optJSONObject3);
        if (cardInfo.kcY != null) {
            cardInfo.mo73581a(cardInfo.kcY);
            cardInfo.field_block_mask = Integer.toString(cardInfo.kcY.vUd);
            cardInfo.field_card_type = cardInfo.kcY.iAd;
            if (TextUtils.isEmpty(cardInfo.field_card_tp_id)) {
                cardInfo.field_card_tp_id = cardInfo.kcY.kbU;
            }
            if (cardInfo.field_begin_time == 0 && optJSONObject2 != null) {
                cardInfo.field_begin_time = optJSONObject2.optLong("begin_time");
            }
            if (cardInfo.field_end_time == 0 && optJSONObject2 != null) {
                cardInfo.field_end_time = optJSONObject2.optLong("end_time");
            }
            if (cardInfo.kcY.vUB != null) {
                cardInfo.field_is_dynamic = cardInfo.kcY.vUB.wdu;
            }
        }
        if (cardInfo.kcZ != null) {
            cardInfo.mo45388a(cardInfo.kcZ);
            cardInfo.field_status = cardInfo.kcZ.status;
        }
        if (cardInfo.kda != null) {
            cardInfo.mo73580a(cardInfo.kda);
        }
        cardInfo.field_local_updateTime = (long) ((int) (System.currentTimeMillis() / 1000));
        AppMethodBeat.m2505o(88856);
    }

    /* renamed from: Hh */
    private static String m43794Hh(String str) {
        AppMethodBeat.m2504i(88857);
        if (TextUtils.isEmpty(str) || BuildConfig.COMMAND.equals(str)) {
            str = "";
            AppMethodBeat.m2505o(88857);
            return str;
        }
        AppMethodBeat.m2505o(88857);
        return str;
    }

    /* renamed from: H */
    private static C35938no m43791H(JSONObject jSONObject) {
        LinkedList linkedList = null;
        AppMethodBeat.m2504i(88858);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.CardInfoParser", "parserCardDataInfo json is null");
            AppMethodBeat.m2505o(88858);
            return null;
        }
        C35938no c35938no = new C35938no();
        try {
            c35938no.status = jSONObject.optInt("status");
            c35938no.vRU = jSONObject.optInt("init_balance");
            c35938no.vRV = jSONObject.optInt("init_bonus");
            JSONArray optJSONArray = jSONObject.optJSONArray("cell_list0");
            if (optJSONArray != null) {
                c35938no.vRW = C27575f.m43806p(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("cell_list1");
            if (optJSONArray != null) {
                c35938no.vRX = C27575f.m43806p(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("cell_list2");
            if (optJSONArray != null) {
                c35938no.vRY = C27575f.m43806p(optJSONArray);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("acceptors");
            if (optJSONArray2 != null) {
                if (!(optJSONArray2 == null || optJSONArray2.length() == 0)) {
                    LinkedList linkedList2 = new LinkedList();
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        linkedList2.add((String) optJSONArray2.get(i));
                    }
                    linkedList = linkedList2;
                }
                c35938no.vRZ = linkedList;
            }
            c35938no.vSa = jSONObject.optInt("avail_num");
            c35938no.vSb = jSONObject.optInt("code_type");
            c35938no.code = jSONObject.optString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            JSONArray optJSONArray3 = jSONObject.optJSONArray("secondary_fields");
            if (optJSONArray3 != null) {
                c35938no.vSc = C27575f.m43807q(optJSONArray3);
            }
            c35938no.vSd = jSONObject.optLong("stock_num");
            c35938no.vSe = jSONObject.optInt("limit_num");
            c35938no.vSf = jSONObject.optString("user_report_url");
            JSONObject optJSONObject = jSONObject.optJSONObject("third_field");
            if (optJSONObject != null) {
                c35938no.vSg = C27575f.m43797K(optJSONObject);
            }
            c35938no.vSh = C27575f.m43808r(jSONObject.optJSONArray("action_sheets"));
            optJSONObject = jSONObject.optJSONObject("card_list_field");
            if (optJSONObject != null) {
                c35938no.vSi = C27575f.m43797K(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("operate_field");
            if (optJSONObject != null) {
                c35938no.vSj = C27575f.m43797K(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("limit_field");
            if (optJSONObject != null) {
                c35938no.vSk = C27575f.m43797K(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("detail_table");
            if (optJSONObject != null) {
                c35938no.vSl = C27575f.m43801O(optJSONObject);
            }
            c35938no.vSm = jSONObject.optString("background_pic_url");
            optJSONObject = jSONObject.optJSONObject("gifting_info_cell");
            if (optJSONObject != null) {
                c35938no.vSn = C27575f.m43797K(optJSONObject);
            }
            c35938no.vSo = jSONObject.optString("sign_number");
            optJSONObject = jSONObject.optJSONObject("unavailable_qrcode_field");
            if (optJSONObject != null) {
                c35938no.vSp = C27575f.m43797K(optJSONObject);
            }
            c35938no.vSq = jSONObject.optBoolean("is_commom_card");
            c35938no.vSr = jSONObject.optBoolean("is_location_authorized");
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(88858);
        return c35938no;
    }

    /* renamed from: p */
    private static LinkedList<C44153op> m43806p(JSONArray jSONArray) {
        AppMethodBeat.m2504i(88859);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.m2505o(88859);
            return null;
        }
        LinkedList<C44153op> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            C44153op c44153op = new C44153op();
            c44153op.title = jSONObject.optString("title");
            c44153op.kbW = jSONObject.optString("sub_title");
            c44153op.kfM = jSONObject.optString("tips");
            c44153op.url = jSONObject.optString("url");
            c44153op.vUW = jSONObject.optLong("show_flag");
            c44153op.vUX = jSONObject.optString("primary_color");
            c44153op.vUY = jSONObject.optString("secondary_color");
            c44153op.kKZ = jSONObject.optString("icon_url");
            c44153op.vTL = jSONObject.optString("app_brand_user_name");
            c44153op.vTM = jSONObject.optString("app_brand_pass");
            linkedList.add(c44153op);
        }
        AppMethodBeat.m2505o(88859);
        return linkedList;
    }

    /* renamed from: I */
    public static C44151oi m43795I(JSONObject jSONObject) {
        C40543lh c40543lh = null;
        AppMethodBeat.m2504i(88860);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.CardInfoParser", "parserCardTpInfo json is null");
            AppMethodBeat.m2505o(88860);
            return null;
        }
        C44151oi c44151oi = new C44151oi();
        try {
            C15368nz c15368nz;
            cma cma;
            aci aci;
            C15320ax c15320ax;
            c44151oi.kbU = jSONObject.optString("card_tp_id");
            c44151oi.kbV = jSONObject.optString("logo_url");
            c44151oi.csB = jSONObject.optString("appid");
            c44151oi.vTT = jSONObject.optString("app_username");
            c44151oi.vTU = jSONObject.optInt("card_category");
            c44151oi.iAd = jSONObject.optInt("card_type");
            c44151oi.kdg = jSONObject.optString("brand_name");
            c44151oi.title = jSONObject.optString("title");
            c44151oi.kbW = jSONObject.optString("sub_title");
            c44151oi.color = jSONObject.optString("color");
            c44151oi.kCx = jSONObject.optString("notice");
            c44151oi.vTV = jSONObject.optString("service_phone");
            c44151oi.vTY = jSONObject.optString("image_text_url");
            c44151oi.vTZ = jSONObject.optString("source_icon");
            c44151oi.source = jSONObject.optString("source");
            JSONArray optJSONArray = jSONObject.optJSONArray("primary_fields");
            if (optJSONArray != null) {
                c44151oi.vTW = C27575f.m43807q(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("introduce_fields");
            if (optJSONArray != null) {
                c44151oi.vTX = C27575f.m43807q(optJSONArray);
            }
            c44151oi.vUa = jSONObject.optInt("shop_count");
            c44151oi.vUb = jSONObject.optString("limit_wording");
            c44151oi.kdf = jSONObject.optString("card_type_name");
            c44151oi.vUc = jSONObject.optString("h5_show_url");
            c44151oi.vUd = jSONObject.optInt("block_mask");
            c44151oi.vUe = jSONObject.optString("middle_icon");
            c44151oi.vUf = jSONObject.optString("accept_wording");
            c44151oi.vUg = jSONObject.optLong("control_flag");
            c44151oi.vUh = jSONObject.optString("advertise_wording");
            c44151oi.vUi = jSONObject.optString("advertise_url");
            c44151oi.vUj = jSONObject.optString("public_service_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("announcement");
            if (optJSONObject == null) {
                C4990ab.m7412e("MicroMsg.CardInfoParser", "parserannoucement json is null");
                c15368nz = null;
            } else {
                c15368nz = new C15368nz();
                c15368nz.type = optJSONObject.optInt("type");
                c15368nz.text = optJSONObject.optString("text");
                c15368nz.url = optJSONObject.optString("url");
                c15368nz.qsz = optJSONObject.optInt("endtime");
                c15368nz.vNm = optJSONObject.optInt("create_time");
                c15368nz.vTr = optJSONObject.optString("thumb_url");
            }
            c44151oi.vUk = c15368nz;
            c44151oi.vUl = jSONObject.optString("public_service_tip");
            c44151oi.vUm = jSONObject.optString("primary_sub_title");
            c44151oi.vUn = jSONObject.optInt("gen_type");
            c44151oi.vUo = C27575f.m43799M(jSONObject.optJSONObject("detail_struct"));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("use_condition");
            if (optJSONObject2 == null) {
                C4990ab.m7412e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
                cma = null;
            } else {
                int i;
                cgf N;
                cma = new cma();
                cma.title = optJSONObject2.optString("title");
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("outer_tag_list");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    C4990ab.m7412e("MicroMsg.CardInfoParser", "parserUseCondition outer_tag_list is null");
                } else {
                    cma.xjK = new LinkedList();
                    for (i = 0; i < optJSONArray2.length(); i++) {
                        N = C27575f.m43800N(optJSONArray2.optJSONObject(i));
                        if (N != null) {
                            cma.xjK.add(N);
                        }
                    }
                }
                optJSONArray2 = optJSONObject2.optJSONArray("inner_tag_list");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    C4990ab.m7412e("MicroMsg.CardInfoParser", "parserUseCondition inner_tag_list is null");
                } else {
                    cma.xjL = new LinkedList();
                    for (i = 0; i < optJSONArray2.length(); i++) {
                        N = C27575f.m43800N(optJSONArray2.optJSONObject(i));
                        if (N != null) {
                            cma.xjL.add(N);
                        }
                    }
                }
                JSONArray optJSONArray3 = optJSONObject2.optJSONArray("detail_field");
                if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                    C4990ab.m7412e("MicroMsg.CardInfoParser", "parserUseCondition detail_field is null");
                } else {
                    cma.xjM = C27575f.m43807q(optJSONArray3);
                }
            }
            c44151oi.vUp = cma;
            optJSONObject = jSONObject.optJSONObject("follow_box");
            if (optJSONObject == null) {
                C4990ab.m7412e("MicroMsg.CardInfoParser", "parserFollowBox json is null");
                aci = null;
            } else {
                aci = new aci();
                aci.text = optJSONObject.optString("text");
                aci.wkd = optJSONObject.optInt("follow");
                C4990ab.m7416i("MicroMsg.CardInfoParser", "follow:" + aci.wkd + "　text:" + aci.text);
            }
            c44151oi.vUq = aci;
            optJSONObject = jSONObject.optJSONObject("guidance");
            if (optJSONObject == null) {
                C4990ab.m7412e("MicroMsg.CardInfoParser", "parserActionSheet json is null");
                c15320ax = null;
            } else {
                c15320ax = new C15320ax();
                c15320ax.text = optJSONObject.optString("text");
                c15320ax.url = optJSONObject.optString("url");
            }
            c44151oi.vUr = c15320ax;
            c44151oi.vUs = jSONObject.optInt("need_direct_jump", 0);
            c44151oi.vUt = jSONObject.optInt("is_acceptable", 0);
            c44151oi.vUu = jSONObject.optString("unacceptable_wording");
            c44151oi.vUv = jSONObject.optInt("has_hongbao", 0);
            c44151oi.vUw = jSONObject.optString("accept_ui_title");
            c44151oi.vUx = jSONObject.optInt("show_accept_view", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("brand_field");
            if (optJSONObject3 != null) {
                c44151oi.vUy = C27575f.m43797K(optJSONObject3);
            }
            c44151oi.vUz = jSONObject.optString("shop_name");
            optJSONObject3 = jSONObject.optJSONObject("pay_and_qrcode_field");
            if (optJSONObject3 != null) {
                c44151oi.vUA = C27575f.m43797K(optJSONObject3);
            }
            optJSONObject = jSONObject.optJSONObject("dynamic_qr_code_info");
            if (optJSONObject != null) {
                C30244xt c30244xt;
                if (optJSONObject == null) {
                    C4990ab.m7412e("MicroMsg.CardInfoParser", "parserDynamicQrCodeInfo json is null");
                    c30244xt = null;
                } else {
                    c30244xt = new C30244xt();
                    c30244xt.wdu = optJSONObject.optBoolean("is_dynamic");
                    c30244xt.wdv = optJSONObject.optBoolean("can_refresh");
                    c30244xt.wdw = optJSONObject.optString("refresh_wording");
                    C4990ab.m7416i("MicroMsg.CardInfoParser", "is_dynamic:" + c30244xt.wdu + "　can_refresh:" + c30244xt.wdv + "　refresh_wording:" + c30244xt.wdw);
                }
                c44151oi.vUB = c30244xt;
            }
            c44151oi.vUC = jSONObject.optBoolean("is_card_code_exposed");
            c44151oi.vUD = jSONObject.optInt("qrcode_correct_level");
            c44151oi.vUE = jSONObject.optBoolean("dismiss_qrcode_icon_on_card");
            c44151oi.vUF = jSONObject.optBoolean("need_location");
            optJSONObject3 = jSONObject.optJSONObject("bluetooth_info");
            if (optJSONObject3 != null) {
                if (optJSONObject3 == null) {
                    C4990ab.m7412e("MicroMsg.CardInfoParser", "parseBluetoothInfo json is null");
                } else {
                    c40543lh = new C40543lh();
                    c40543lh.name = optJSONObject3.optString("name");
                    c40543lh.vON = optJSONObject3.optInt("report_time_interval", 0);
                    C4990ab.m7417i("MicroMsg.CardInfoParser", "blueToothInfo.name:%s", c40543lh.name);
                }
                c44151oi.vUG = c40543lh;
            }
            c44151oi.vUH = jSONObject.optString("biz_nickname");
            c44151oi.vUI = jSONObject.optString("gift_title");
            C4990ab.m7411d("MicroMsg.CardInfoParser", "parse gift title: %s", c44151oi.vUI);
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(88860);
        return c44151oi;
    }

    /* renamed from: q */
    private static LinkedList<C23446tm> m43807q(JSONArray jSONArray) {
        AppMethodBeat.m2504i(88861);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.m2505o(88861);
            return null;
        }
        LinkedList<C23446tm> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            C23446tm K = C27575f.m43797K(jSONArray.getJSONObject(i));
            if (K != null) {
                linkedList.add(K);
            }
        }
        AppMethodBeat.m2505o(88861);
        return linkedList;
    }

    /* renamed from: J */
    private static bzi m43796J(JSONObject jSONObject) {
        AppMethodBeat.m2504i(88862);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.CardInfoParser", "parserShareInfo json is null");
            AppMethodBeat.m2505o(88862);
            return null;
        }
        bzi bzi = new bzi();
        bzi.wYl = jSONObject.optString("gift_msg_title");
        AppMethodBeat.m2505o(88862);
        return bzi;
    }

    /* renamed from: r */
    private static LinkedList<C15320ax> m43808r(JSONArray jSONArray) {
        AppMethodBeat.m2504i(88863);
        LinkedList linkedList = new LinkedList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    C15320ax c15320ax = new C15320ax();
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    c15320ax.text = jSONObject.optString("text");
                    c15320ax.url = jSONObject.optString("url");
                    linkedList.add(c15320ax);
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.m2505o(88863);
        return linkedList;
    }

    /* renamed from: K */
    private static C23446tm m43797K(JSONObject jSONObject) {
        AppMethodBeat.m2504i(88864);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.CardInfoParser", "parserThirdFiled json is null");
            AppMethodBeat.m2505o(88864);
            return null;
        }
        C23446tm c23446tm = new C23446tm();
        c23446tm.title = jSONObject.optString("title");
        c23446tm.kbX = jSONObject.optString("aux_title");
        c23446tm.kbW = jSONObject.optString("sub_title");
        c23446tm.url = jSONObject.optString("url");
        c23446tm.vUW = jSONObject.optLong("show_flag");
        c23446tm.vUX = jSONObject.optString("primary_color");
        c23446tm.vUY = jSONObject.optString("secondary_color");
        c23446tm.kKZ = jSONObject.optString("icon_url");
        JSONObject optJSONObject = jSONObject.optJSONObject("gifting_info");
        if (optJSONObject != null) {
            c23446tm.waC = C27575f.m43798L(optJSONObject);
        }
        c23446tm.vTL = jSONObject.optString("app_brand_user_name");
        c23446tm.vTM = jSONObject.optString("app_brand_pass");
        AppMethodBeat.m2505o(88864);
        return c23446tm;
    }

    /* renamed from: L */
    private static arp m43798L(JSONObject jSONObject) {
        AppMethodBeat.m2504i(88865);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.CardInfoParser", "parserGiftInfo json is null");
            AppMethodBeat.m2505o(88865);
            return null;
        }
        C4990ab.m7411d("MicroMsg.CardInfoParser", "parserGitfInfo:%s", jSONObject);
        arp arp = new arp();
        arp.vBA = C1183p.m2611cB(jSONObject.optString("biz_uin"));
        arp.vBB = jSONObject.optString("order_id");
        AppMethodBeat.m2505o(88865);
        return arp;
    }

    /* renamed from: M */
    private static C15395wy m43799M(JSONObject jSONObject) {
        AppMethodBeat.m2504i(88866);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.CardInfoParser", "parserDetailStruct json is null");
            AppMethodBeat.m2505o(88866);
            return null;
        }
        C15395wy c15395wy = new C15395wy();
        c15395wy.title = jSONObject.optString("title");
        c15395wy.url = jSONObject.optString("url");
        c15395wy.desc = jSONObject.optString("abstract");
        c15395wy.detail = jSONObject.optString("detail");
        c15395wy.wcT = jSONObject.optString("ad_title");
        JSONArray optJSONArray = jSONObject.optJSONArray("icon_url_list");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            C4990ab.m7412e("MicroMsg.CardInfoParser", "parserDetailStruct icon_url_list is null");
        } else {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                Object obj = "";
                try {
                    obj = optJSONArray.getString(i);
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                    C4990ab.m7412e("MicroMsg.CardInfoParser", "getMessage:" + e.getMessage());
                }
                linkedList.add(obj);
            }
            c15395wy.wcS = linkedList;
        }
        AppMethodBeat.m2505o(88866);
        return c15395wy;
    }

    /* renamed from: N */
    private static cgf m43800N(JSONObject jSONObject) {
        AppMethodBeat.m2504i(88867);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
            AppMethodBeat.m2505o(88867);
            return null;
        }
        cgf cgf = new cgf();
        cgf.tag = jSONObject.optString("tag");
        cgf.color = jSONObject.optString("color");
        AppMethodBeat.m2505o(88867);
        return cgf;
    }

    /* renamed from: O */
    private static C15396wz m43801O(JSONObject jSONObject) {
        AppMethodBeat.m2504i(88868);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.CardInfoParser", "parserDetailTable json is null");
            AppMethodBeat.m2505o(88868);
            return null;
        }
        C15396wz c15396wz = new C15396wz();
        c15396wz.title = jSONObject.optString("title");
        c15396wz.kbW = jSONObject.optString("sub_title");
        c15396wz.wcU = jSONObject.optInt("show_num", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("rows");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            C4990ab.m7412e("MicroMsg.CardInfoParser", "parserDetailTable jsonArray is  null");
        } else {
            try {
                c15396wz.wcV = C27575f.m43807q(optJSONArray);
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.CardInfoParser", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(88868);
        return c15396wz;
    }
}
