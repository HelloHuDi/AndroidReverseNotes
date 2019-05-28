package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.protocal.protobuf.lh;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.protocal.protobuf.wy;
import com.tencent.mm.protocal.protobuf.wz;
import com.tencent.mm.protocal.protobuf.xt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    public static ArrayList<ShareCardInfo> Hf(String str) {
        AppMethodBeat.i(88851);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.CardInfoParser", "parseShareCardArray jsonContent is null");
            AppMethodBeat.o(88851);
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                ab.e("MicroMsg.CardInfoParser", "parseShareCardArray cardItemListJson is null");
                AppMethodBeat.o(88851);
                return null;
            }
            ArrayList<ShareCardInfo> arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                ShareCardInfo shareCardInfo = new ShareCardInfo();
                a(shareCardInfo, optJSONObject);
                arrayList.add(shareCardInfo);
            }
            AppMethodBeat.o(88851);
            return arrayList;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            AppMethodBeat.o(88851);
            return null;
        }
    }

    public static void a(ShareCardInfo shareCardInfo, String str) {
        AppMethodBeat.i(88852);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
            AppMethodBeat.o(88852);
            return;
        }
        try {
            a(shareCardInfo, new JSONObject(str).optJSONObject("share_card"));
            AppMethodBeat.o(88852);
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            ab.e("MicroMsg.CardInfoParser", e.getMessage());
            AppMethodBeat.o(88852);
        }
    }

    public static void a(ShareCardInfo shareCardInfo, JSONObject jSONObject) {
        AppMethodBeat.i(88853);
        if (jSONObject == null) {
            ab.e("MicroMsg.CardInfoParser", "parserShareCardItemJson json is null");
            AppMethodBeat.o(88853);
            return;
        }
        shareCardInfo.field_card_id = Hh(jSONObject.optString("card_id"));
        shareCardInfo.field_card_tp_id = Hh(jSONObject.optString("card_tp_id"));
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
        shareCardInfo.kcZ = H(optJSONObject);
        shareCardInfo.kcY = I(optJSONObject2);
        shareCardInfo.kda = J(optJSONObject3);
        if (shareCardInfo.kcZ != null) {
            shareCardInfo.a(shareCardInfo.kcZ);
        }
        if (shareCardInfo.kcY != null) {
            shareCardInfo.a(shareCardInfo.kcY);
            shareCardInfo.field_end_time = (long) optJSONObject2.optInt("end_time");
            shareCardInfo.field_begin_time = (long) optJSONObject2.optInt("begin_time");
        }
        if (shareCardInfo.kda != null) {
            shareCardInfo.a(shareCardInfo.kda);
        }
        shareCardInfo.field_local_updateTime = (long) ((int) (System.currentTimeMillis() / 1000));
        AppMethodBeat.o(88853);
    }

    public static ArrayList<CardInfo> Hg(String str) {
        AppMethodBeat.i(88854);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.CardInfoParser", "parseCardArray jsonContent is null");
            AppMethodBeat.o(88854);
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_array");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                ab.e("MicroMsg.CardInfoParser", "parseCardArray cardItemListJson is null");
                AppMethodBeat.o(88854);
                return null;
            }
            ArrayList<CardInfo> arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                CardInfo cardInfo = new CardInfo();
                a(cardInfo, optJSONObject);
                arrayList.add(cardInfo);
            }
            AppMethodBeat.o(88854);
            return arrayList;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            AppMethodBeat.o(88854);
            return null;
        }
    }

    public static void a(CardInfo cardInfo, String str) {
        AppMethodBeat.i(88855);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.CardInfoParser", "parserCardItemJson jsonContent is null");
            AppMethodBeat.o(88855);
            return;
        }
        try {
            a(cardInfo, new JSONObject(str));
            AppMethodBeat.o(88855);
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            AppMethodBeat.o(88855);
        }
    }

    private static void a(CardInfo cardInfo, JSONObject jSONObject) {
        AppMethodBeat.i(88856);
        if (jSONObject == null) {
            ab.e("MicroMsg.CardInfoParser", "parserCardItemJson json is null");
            AppMethodBeat.o(88856);
            return;
        }
        cardInfo.field_card_id = Hh(jSONObject.optString("card_id"));
        cardInfo.field_card_tp_id = Hh(jSONObject.optString("card_tp_id"));
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
        cardInfo.kcZ = H(optJSONObject);
        cardInfo.kcY = I(optJSONObject2);
        cardInfo.kda = J(optJSONObject3);
        if (cardInfo.kcY != null) {
            cardInfo.a(cardInfo.kcY);
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
            cardInfo.a(cardInfo.kcZ);
            cardInfo.field_status = cardInfo.kcZ.status;
        }
        if (cardInfo.kda != null) {
            cardInfo.a(cardInfo.kda);
        }
        cardInfo.field_local_updateTime = (long) ((int) (System.currentTimeMillis() / 1000));
        AppMethodBeat.o(88856);
    }

    private static String Hh(String str) {
        AppMethodBeat.i(88857);
        if (TextUtils.isEmpty(str) || BuildConfig.COMMAND.equals(str)) {
            str = "";
            AppMethodBeat.o(88857);
            return str;
        }
        AppMethodBeat.o(88857);
        return str;
    }

    private static no H(JSONObject jSONObject) {
        LinkedList linkedList = null;
        AppMethodBeat.i(88858);
        if (jSONObject == null) {
            ab.e("MicroMsg.CardInfoParser", "parserCardDataInfo json is null");
            AppMethodBeat.o(88858);
            return null;
        }
        no noVar = new no();
        try {
            noVar.status = jSONObject.optInt("status");
            noVar.vRU = jSONObject.optInt("init_balance");
            noVar.vRV = jSONObject.optInt("init_bonus");
            JSONArray optJSONArray = jSONObject.optJSONArray("cell_list0");
            if (optJSONArray != null) {
                noVar.vRW = p(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("cell_list1");
            if (optJSONArray != null) {
                noVar.vRX = p(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("cell_list2");
            if (optJSONArray != null) {
                noVar.vRY = p(optJSONArray);
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
                noVar.vRZ = linkedList;
            }
            noVar.vSa = jSONObject.optInt("avail_num");
            noVar.vSb = jSONObject.optInt("code_type");
            noVar.code = jSONObject.optString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            JSONArray optJSONArray3 = jSONObject.optJSONArray("secondary_fields");
            if (optJSONArray3 != null) {
                noVar.vSc = q(optJSONArray3);
            }
            noVar.vSd = jSONObject.optLong("stock_num");
            noVar.vSe = jSONObject.optInt("limit_num");
            noVar.vSf = jSONObject.optString("user_report_url");
            JSONObject optJSONObject = jSONObject.optJSONObject("third_field");
            if (optJSONObject != null) {
                noVar.vSg = K(optJSONObject);
            }
            noVar.vSh = r(jSONObject.optJSONArray("action_sheets"));
            optJSONObject = jSONObject.optJSONObject("card_list_field");
            if (optJSONObject != null) {
                noVar.vSi = K(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("operate_field");
            if (optJSONObject != null) {
                noVar.vSj = K(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("limit_field");
            if (optJSONObject != null) {
                noVar.vSk = K(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("detail_table");
            if (optJSONObject != null) {
                noVar.vSl = O(optJSONObject);
            }
            noVar.vSm = jSONObject.optString("background_pic_url");
            optJSONObject = jSONObject.optJSONObject("gifting_info_cell");
            if (optJSONObject != null) {
                noVar.vSn = K(optJSONObject);
            }
            noVar.vSo = jSONObject.optString("sign_number");
            optJSONObject = jSONObject.optJSONObject("unavailable_qrcode_field");
            if (optJSONObject != null) {
                noVar.vSp = K(optJSONObject);
            }
            noVar.vSq = jSONObject.optBoolean("is_commom_card");
            noVar.vSr = jSONObject.optBoolean("is_location_authorized");
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
        AppMethodBeat.o(88858);
        return noVar;
    }

    private static LinkedList<op> p(JSONArray jSONArray) {
        AppMethodBeat.i(88859);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(88859);
            return null;
        }
        LinkedList<op> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            op opVar = new op();
            opVar.title = jSONObject.optString("title");
            opVar.kbW = jSONObject.optString("sub_title");
            opVar.kfM = jSONObject.optString("tips");
            opVar.url = jSONObject.optString("url");
            opVar.vUW = jSONObject.optLong("show_flag");
            opVar.vUX = jSONObject.optString("primary_color");
            opVar.vUY = jSONObject.optString("secondary_color");
            opVar.kKZ = jSONObject.optString("icon_url");
            opVar.vTL = jSONObject.optString("app_brand_user_name");
            opVar.vTM = jSONObject.optString("app_brand_pass");
            linkedList.add(opVar);
        }
        AppMethodBeat.o(88859);
        return linkedList;
    }

    public static oi I(JSONObject jSONObject) {
        lh lhVar = null;
        AppMethodBeat.i(88860);
        if (jSONObject == null) {
            ab.e("MicroMsg.CardInfoParser", "parserCardTpInfo json is null");
            AppMethodBeat.o(88860);
            return null;
        }
        oi oiVar = new oi();
        try {
            nz nzVar;
            cma cma;
            aci aci;
            ax axVar;
            oiVar.kbU = jSONObject.optString("card_tp_id");
            oiVar.kbV = jSONObject.optString("logo_url");
            oiVar.csB = jSONObject.optString("appid");
            oiVar.vTT = jSONObject.optString("app_username");
            oiVar.vTU = jSONObject.optInt("card_category");
            oiVar.iAd = jSONObject.optInt("card_type");
            oiVar.kdg = jSONObject.optString("brand_name");
            oiVar.title = jSONObject.optString("title");
            oiVar.kbW = jSONObject.optString("sub_title");
            oiVar.color = jSONObject.optString("color");
            oiVar.kCx = jSONObject.optString("notice");
            oiVar.vTV = jSONObject.optString("service_phone");
            oiVar.vTY = jSONObject.optString("image_text_url");
            oiVar.vTZ = jSONObject.optString("source_icon");
            oiVar.source = jSONObject.optString("source");
            JSONArray optJSONArray = jSONObject.optJSONArray("primary_fields");
            if (optJSONArray != null) {
                oiVar.vTW = q(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("introduce_fields");
            if (optJSONArray != null) {
                oiVar.vTX = q(optJSONArray);
            }
            oiVar.vUa = jSONObject.optInt("shop_count");
            oiVar.vUb = jSONObject.optString("limit_wording");
            oiVar.kdf = jSONObject.optString("card_type_name");
            oiVar.vUc = jSONObject.optString("h5_show_url");
            oiVar.vUd = jSONObject.optInt("block_mask");
            oiVar.vUe = jSONObject.optString("middle_icon");
            oiVar.vUf = jSONObject.optString("accept_wording");
            oiVar.vUg = jSONObject.optLong("control_flag");
            oiVar.vUh = jSONObject.optString("advertise_wording");
            oiVar.vUi = jSONObject.optString("advertise_url");
            oiVar.vUj = jSONObject.optString("public_service_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("announcement");
            if (optJSONObject == null) {
                ab.e("MicroMsg.CardInfoParser", "parserannoucement json is null");
                nzVar = null;
            } else {
                nzVar = new nz();
                nzVar.type = optJSONObject.optInt("type");
                nzVar.text = optJSONObject.optString("text");
                nzVar.url = optJSONObject.optString("url");
                nzVar.qsz = optJSONObject.optInt("endtime");
                nzVar.vNm = optJSONObject.optInt("create_time");
                nzVar.vTr = optJSONObject.optString("thumb_url");
            }
            oiVar.vUk = nzVar;
            oiVar.vUl = jSONObject.optString("public_service_tip");
            oiVar.vUm = jSONObject.optString("primary_sub_title");
            oiVar.vUn = jSONObject.optInt("gen_type");
            oiVar.vUo = M(jSONObject.optJSONObject("detail_struct"));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("use_condition");
            if (optJSONObject2 == null) {
                ab.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
                cma = null;
            } else {
                int i;
                cgf N;
                cma = new cma();
                cma.title = optJSONObject2.optString("title");
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("outer_tag_list");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    ab.e("MicroMsg.CardInfoParser", "parserUseCondition outer_tag_list is null");
                } else {
                    cma.xjK = new LinkedList();
                    for (i = 0; i < optJSONArray2.length(); i++) {
                        N = N(optJSONArray2.optJSONObject(i));
                        if (N != null) {
                            cma.xjK.add(N);
                        }
                    }
                }
                optJSONArray2 = optJSONObject2.optJSONArray("inner_tag_list");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    ab.e("MicroMsg.CardInfoParser", "parserUseCondition inner_tag_list is null");
                } else {
                    cma.xjL = new LinkedList();
                    for (i = 0; i < optJSONArray2.length(); i++) {
                        N = N(optJSONArray2.optJSONObject(i));
                        if (N != null) {
                            cma.xjL.add(N);
                        }
                    }
                }
                JSONArray optJSONArray3 = optJSONObject2.optJSONArray("detail_field");
                if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                    ab.e("MicroMsg.CardInfoParser", "parserUseCondition detail_field is null");
                } else {
                    cma.xjM = q(optJSONArray3);
                }
            }
            oiVar.vUp = cma;
            optJSONObject = jSONObject.optJSONObject("follow_box");
            if (optJSONObject == null) {
                ab.e("MicroMsg.CardInfoParser", "parserFollowBox json is null");
                aci = null;
            } else {
                aci = new aci();
                aci.text = optJSONObject.optString("text");
                aci.wkd = optJSONObject.optInt("follow");
                ab.i("MicroMsg.CardInfoParser", "follow:" + aci.wkd + "　text:" + aci.text);
            }
            oiVar.vUq = aci;
            optJSONObject = jSONObject.optJSONObject("guidance");
            if (optJSONObject == null) {
                ab.e("MicroMsg.CardInfoParser", "parserActionSheet json is null");
                axVar = null;
            } else {
                axVar = new ax();
                axVar.text = optJSONObject.optString("text");
                axVar.url = optJSONObject.optString("url");
            }
            oiVar.vUr = axVar;
            oiVar.vUs = jSONObject.optInt("need_direct_jump", 0);
            oiVar.vUt = jSONObject.optInt("is_acceptable", 0);
            oiVar.vUu = jSONObject.optString("unacceptable_wording");
            oiVar.vUv = jSONObject.optInt("has_hongbao", 0);
            oiVar.vUw = jSONObject.optString("accept_ui_title");
            oiVar.vUx = jSONObject.optInt("show_accept_view", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("brand_field");
            if (optJSONObject3 != null) {
                oiVar.vUy = K(optJSONObject3);
            }
            oiVar.vUz = jSONObject.optString("shop_name");
            optJSONObject3 = jSONObject.optJSONObject("pay_and_qrcode_field");
            if (optJSONObject3 != null) {
                oiVar.vUA = K(optJSONObject3);
            }
            optJSONObject = jSONObject.optJSONObject("dynamic_qr_code_info");
            if (optJSONObject != null) {
                xt xtVar;
                if (optJSONObject == null) {
                    ab.e("MicroMsg.CardInfoParser", "parserDynamicQrCodeInfo json is null");
                    xtVar = null;
                } else {
                    xtVar = new xt();
                    xtVar.wdu = optJSONObject.optBoolean("is_dynamic");
                    xtVar.wdv = optJSONObject.optBoolean("can_refresh");
                    xtVar.wdw = optJSONObject.optString("refresh_wording");
                    ab.i("MicroMsg.CardInfoParser", "is_dynamic:" + xtVar.wdu + "　can_refresh:" + xtVar.wdv + "　refresh_wording:" + xtVar.wdw);
                }
                oiVar.vUB = xtVar;
            }
            oiVar.vUC = jSONObject.optBoolean("is_card_code_exposed");
            oiVar.vUD = jSONObject.optInt("qrcode_correct_level");
            oiVar.vUE = jSONObject.optBoolean("dismiss_qrcode_icon_on_card");
            oiVar.vUF = jSONObject.optBoolean("need_location");
            optJSONObject3 = jSONObject.optJSONObject("bluetooth_info");
            if (optJSONObject3 != null) {
                if (optJSONObject3 == null) {
                    ab.e("MicroMsg.CardInfoParser", "parseBluetoothInfo json is null");
                } else {
                    lhVar = new lh();
                    lhVar.name = optJSONObject3.optString("name");
                    lhVar.vON = optJSONObject3.optInt("report_time_interval", 0);
                    ab.i("MicroMsg.CardInfoParser", "blueToothInfo.name:%s", lhVar.name);
                }
                oiVar.vUG = lhVar;
            }
            oiVar.vUH = jSONObject.optString("biz_nickname");
            oiVar.vUI = jSONObject.optString("gift_title");
            ab.d("MicroMsg.CardInfoParser", "parse gift title: %s", oiVar.vUI);
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
        AppMethodBeat.o(88860);
        return oiVar;
    }

    private static LinkedList<tm> q(JSONArray jSONArray) {
        AppMethodBeat.i(88861);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(88861);
            return null;
        }
        LinkedList<tm> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            tm K = K(jSONArray.getJSONObject(i));
            if (K != null) {
                linkedList.add(K);
            }
        }
        AppMethodBeat.o(88861);
        return linkedList;
    }

    private static bzi J(JSONObject jSONObject) {
        AppMethodBeat.i(88862);
        if (jSONObject == null) {
            ab.e("MicroMsg.CardInfoParser", "parserShareInfo json is null");
            AppMethodBeat.o(88862);
            return null;
        }
        bzi bzi = new bzi();
        bzi.wYl = jSONObject.optString("gift_msg_title");
        AppMethodBeat.o(88862);
        return bzi;
    }

    private static LinkedList<ax> r(JSONArray jSONArray) {
        AppMethodBeat.i(88863);
        LinkedList linkedList = new LinkedList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    ax axVar = new ax();
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    axVar.text = jSONObject.optString("text");
                    axVar.url = jSONObject.optString("url");
                    linkedList.add(axVar);
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(88863);
        return linkedList;
    }

    private static tm K(JSONObject jSONObject) {
        AppMethodBeat.i(88864);
        if (jSONObject == null) {
            ab.e("MicroMsg.CardInfoParser", "parserThirdFiled json is null");
            AppMethodBeat.o(88864);
            return null;
        }
        tm tmVar = new tm();
        tmVar.title = jSONObject.optString("title");
        tmVar.kbX = jSONObject.optString("aux_title");
        tmVar.kbW = jSONObject.optString("sub_title");
        tmVar.url = jSONObject.optString("url");
        tmVar.vUW = jSONObject.optLong("show_flag");
        tmVar.vUX = jSONObject.optString("primary_color");
        tmVar.vUY = jSONObject.optString("secondary_color");
        tmVar.kKZ = jSONObject.optString("icon_url");
        JSONObject optJSONObject = jSONObject.optJSONObject("gifting_info");
        if (optJSONObject != null) {
            tmVar.waC = L(optJSONObject);
        }
        tmVar.vTL = jSONObject.optString("app_brand_user_name");
        tmVar.vTM = jSONObject.optString("app_brand_pass");
        AppMethodBeat.o(88864);
        return tmVar;
    }

    private static arp L(JSONObject jSONObject) {
        AppMethodBeat.i(88865);
        if (jSONObject == null) {
            ab.e("MicroMsg.CardInfoParser", "parserGiftInfo json is null");
            AppMethodBeat.o(88865);
            return null;
        }
        ab.d("MicroMsg.CardInfoParser", "parserGitfInfo:%s", jSONObject);
        arp arp = new arp();
        arp.vBA = p.cB(jSONObject.optString("biz_uin"));
        arp.vBB = jSONObject.optString("order_id");
        AppMethodBeat.o(88865);
        return arp;
    }

    private static wy M(JSONObject jSONObject) {
        AppMethodBeat.i(88866);
        if (jSONObject == null) {
            ab.e("MicroMsg.CardInfoParser", "parserDetailStruct json is null");
            AppMethodBeat.o(88866);
            return null;
        }
        wy wyVar = new wy();
        wyVar.title = jSONObject.optString("title");
        wyVar.url = jSONObject.optString("url");
        wyVar.desc = jSONObject.optString("abstract");
        wyVar.detail = jSONObject.optString("detail");
        wyVar.wcT = jSONObject.optString("ad_title");
        JSONArray optJSONArray = jSONObject.optJSONArray("icon_url_list");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            ab.e("MicroMsg.CardInfoParser", "parserDetailStruct icon_url_list is null");
        } else {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                Object obj = "";
                try {
                    obj = optJSONArray.getString(i);
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                    ab.e("MicroMsg.CardInfoParser", "getMessage:" + e.getMessage());
                }
                linkedList.add(obj);
            }
            wyVar.wcS = linkedList;
        }
        AppMethodBeat.o(88866);
        return wyVar;
    }

    private static cgf N(JSONObject jSONObject) {
        AppMethodBeat.i(88867);
        if (jSONObject == null) {
            ab.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
            AppMethodBeat.o(88867);
            return null;
        }
        cgf cgf = new cgf();
        cgf.tag = jSONObject.optString("tag");
        cgf.color = jSONObject.optString("color");
        AppMethodBeat.o(88867);
        return cgf;
    }

    private static wz O(JSONObject jSONObject) {
        AppMethodBeat.i(88868);
        if (jSONObject == null) {
            ab.e("MicroMsg.CardInfoParser", "parserDetailTable json is null");
            AppMethodBeat.o(88868);
            return null;
        }
        wz wzVar = new wz();
        wzVar.title = jSONObject.optString("title");
        wzVar.kbW = jSONObject.optString("sub_title");
        wzVar.wcU = jSONObject.optInt("show_num", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("rows");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            ab.e("MicroMsg.CardInfoParser", "parserDetailTable jsonArray is  null");
        } else {
            try {
                wzVar.wcV = q(optJSONArray);
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                ab.e("MicroMsg.CardInfoParser", e.getMessage());
            }
        }
        AppMethodBeat.o(88868);
        return wzVar;
    }
}
