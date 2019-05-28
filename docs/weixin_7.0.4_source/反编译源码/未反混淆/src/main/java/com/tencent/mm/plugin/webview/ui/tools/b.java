package com.tencent.mm.plugin.webview.ui.tools;

import com.facebook.login.widget.ToolTipPopup;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static final Map<Integer, Integer> uqW;
    private static final Map<Integer, Integer> uqX;
    private static final Map<Integer, Integer> uqY;
    private static final Map<String, Integer> uqZ;

    static {
        AppMethodBeat.i(7347);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(-1), Integer.valueOf(5));
        hashMap.put(Integer.valueOf(-2), Integer.valueOf(6));
        hashMap.put(Integer.valueOf(-3), Integer.valueOf(7));
        hashMap.put(Integer.valueOf(-4), Integer.valueOf(8));
        hashMap.put(Integer.valueOf(-5), Integer.valueOf(9));
        hashMap.put(Integer.valueOf(-6), Integer.valueOf(10));
        hashMap.put(Integer.valueOf(-7), Integer.valueOf(11));
        hashMap.put(Integer.valueOf(-8), Integer.valueOf(12));
        hashMap.put(Integer.valueOf(-9), Integer.valueOf(13));
        hashMap.put(Integer.valueOf(-10), Integer.valueOf(14));
        hashMap.put(Integer.valueOf(-11), Integer.valueOf(15));
        hashMap.put(Integer.valueOf(-12), Integer.valueOf(16));
        hashMap.put(Integer.valueOf(-13), Integer.valueOf(17));
        hashMap.put(Integer.valueOf(-14), Integer.valueOf(18));
        hashMap.put(Integer.valueOf(-15), Integer.valueOf(19));
        uqW = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put(Integer.valueOf(-1), Integer.valueOf(4));
        hashMap.put(Integer.valueOf(-2), Integer.valueOf(5));
        hashMap.put(Integer.valueOf(-3), Integer.valueOf(6));
        hashMap.put(Integer.valueOf(-4), Integer.valueOf(7));
        hashMap.put(Integer.valueOf(-5), Integer.valueOf(8));
        hashMap.put(Integer.valueOf(-6), Integer.valueOf(9));
        uqX = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), Integer.valueOf(0));
        hashMap.put(Integer.valueOf(1), Integer.valueOf(1));
        hashMap.put(Integer.valueOf(2), Integer.valueOf(2));
        uqY = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put("imagePreview", Integer.valueOf(2));
        hashMap.put(Scopes.PROFILE, Integer.valueOf(3));
        hashMap.put("addContact", Integer.valueOf(4));
        hashMap.put(f.NAME, Integer.valueOf(7));
        hashMap.put("scanQRCode", Integer.valueOf(8));
        hashMap.put("hideOptionMenu", Integer.valueOf(10));
        hashMap.put("getBrandWCPayRequest", Integer.valueOf(11));
        hashMap.put("editAddress", Integer.valueOf(12));
        hashMap.put("getLatestAddress", Integer.valueOf(13));
        hashMap.put("jumpWCMall", Integer.valueOf(14));
        hashMap.put("geoLocation", Integer.valueOf(15));
        hashMap.put("openProductView", Integer.valueOf(16));
        hashMap.put("openProductViewWithPid", Integer.valueOf(16));
        hashMap.put(j.NAME, Integer.valueOf(17));
        hashMap.put("hideMenuItems", Integer.valueOf(19));
        hashMap.put("connectToFreeWifi", Integer.valueOf(20));
        hashMap.put(JsApiStartRecordVoice.NAME, Integer.valueOf(21));
        hashMap.put(JsApiChooseImage.NAME, Integer.valueOf(22));
        hashMap.put("scanCover", Integer.valueOf(23));
        hashMap.put("openGameWebView", Integer.valueOf(28));
        uqZ = Collections.unmodifiableMap(hashMap);
        AppMethodBeat.o(7347);
    }

    public static int Jf(int i) {
        AppMethodBeat.i(7343);
        Integer num = (Integer) uqW.get(Integer.valueOf(i));
        if (num == null) {
            num = (Integer) uqW.get(Integer.valueOf(-1));
        }
        int intValue = num.intValue();
        AppMethodBeat.o(7343);
        return intValue;
    }

    public static int Jg(int i) {
        AppMethodBeat.i(7344);
        Integer num = (Integer) uqX.get(Integer.valueOf(i));
        if (num == null) {
            num = (Integer) uqX.get(Integer.valueOf(-1));
        }
        int intValue = num.intValue();
        AppMethodBeat.o(7344);
        return intValue;
    }

    public static int Jh(int i) {
        AppMethodBeat.i(7345);
        Integer num = (Integer) uqY.get(Integer.valueOf(i));
        if (num == null) {
            num = Integer.valueOf(-1);
        }
        int intValue = num.intValue();
        AppMethodBeat.o(7345);
        return intValue;
    }

    public static int afq(String str) {
        AppMethodBeat.i(7346);
        Integer num = (Integer) uqZ.get(str);
        if (num == null) {
            num = Integer.valueOf(-1);
        }
        int intValue = num.intValue();
        AppMethodBeat.o(7346);
        return intValue;
    }

    public static int lS(long j) {
        if (j < 0) {
            return -1;
        }
        if (j <= FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
            return 1;
        }
        if (j <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME) {
            return 2;
        }
        if (j <= 12000) {
            return 3;
        }
        if (j <= 60000) {
            return 4;
        }
        return 5;
    }
}
