package com.tencent.mm.plugin.luckymoney.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class ap extends ak {
    public String nSX;
    public String nYX;
    public String nYY;

    public ap(int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, int i3, String str7, int i4, int i5, String str8) {
        this(i, str, str2, str3, str4, str5, i2, "", "", str6, i3, str7, i4, i5, str8);
    }

    private ap(int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, String str8, int i3, String str9, int i4, int i5, String str10) {
        AppMethodBeat.i(42419);
        HashMap hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(i));
        hashMap.put("wishing", URLEncoder.encode(bo.nullAsNil(str)));
        hashMap.put("sendUserName", str4);
        if (!bo.isNullOrNil(str3)) {
            hashMap.put("username", str3);
        }
        if (!bo.isNullOrNil(str2)) {
            hashMap.put("headImg", URLEncoder.encode(str2));
        }
        if (!bo.isNullOrNil(str5)) {
            hashMap.put("nickName", URLEncoder.encode(bo.nullAsNil(str5)));
        }
        hashMap.put("inWay", String.valueOf(i2));
        hashMap.put("imageId", str6);
        hashMap.put("imageAesKey", str7);
        hashMap.put("imageLength", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("expressionurl", str8);
        hashMap.put("expressiontype", String.valueOf(i3));
        if (!bo.isNullOrNil(str9)) {
            hashMap.put("unique_id", str9);
        }
        hashMap.put("user_confirm_jump", String.valueOf(i4));
        hashMap.put("unpay_type", String.valueOf(i5));
        if (!bo.isNullOrNil(str10)) {
            hashMap.put("cancel_sendid", str10);
        }
        M(hashMap);
        AppMethodBeat.o(42419);
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/yearrequestwxhb";
    }

    public final int getType() {
        return 1643;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(42420);
        this.nSX = jSONObject.optString("sendId");
        this.nYX = jSONObject.optString("reqkey");
        this.nYY = jSONObject.optString("sendMsgXml");
        AppMethodBeat.o(42420);
    }
}
