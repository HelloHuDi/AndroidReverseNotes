package com.tencent.map.geolocation;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class TencentLocationRequest {
    public static final int REQUEST_LEVEL_ADMIN_AREA = 3;
    public static final int REQUEST_LEVEL_GEO = 0;
    public static final int REQUEST_LEVEL_NAME = 1;
    public static final int REQUEST_LEVEL_POI = 4;
    private long a;
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private long g;
    private int h;
    private String i;
    private String j;
    private Bundle k;

    private TencentLocationRequest() {
    }

    public TencentLocationRequest(TencentLocationRequest tencentLocationRequest) {
        AppMethodBeat.i(136469);
        this.a = tencentLocationRequest.a;
        this.b = tencentLocationRequest.b;
        this.d = tencentLocationRequest.d;
        this.e = tencentLocationRequest.e;
        this.g = tencentLocationRequest.g;
        this.h = tencentLocationRequest.h;
        this.c = tencentLocationRequest.c;
        this.f = tencentLocationRequest.f;
        this.j = tencentLocationRequest.j;
        this.i = tencentLocationRequest.i;
        this.k = new Bundle();
        this.k.putAll(tencentLocationRequest.k);
        AppMethodBeat.o(136469);
    }

    public static void copy(TencentLocationRequest tencentLocationRequest, TencentLocationRequest tencentLocationRequest2) {
        AppMethodBeat.i(136470);
        tencentLocationRequest.a = tencentLocationRequest2.a;
        tencentLocationRequest.b = tencentLocationRequest2.b;
        tencentLocationRequest.d = tencentLocationRequest2.d;
        tencentLocationRequest.e = tencentLocationRequest2.e;
        tencentLocationRequest.g = tencentLocationRequest2.g;
        tencentLocationRequest.h = tencentLocationRequest2.h;
        tencentLocationRequest.f = tencentLocationRequest2.f;
        tencentLocationRequest.c = tencentLocationRequest2.c;
        tencentLocationRequest.j = tencentLocationRequest2.j;
        tencentLocationRequest.i = tencentLocationRequest2.i;
        tencentLocationRequest.k.clear();
        tencentLocationRequest.k.putAll(tencentLocationRequest2.k);
        AppMethodBeat.o(136470);
    }

    public static TencentLocationRequest create() {
        AppMethodBeat.i(136471);
        TencentLocationRequest tencentLocationRequest = new TencentLocationRequest();
        tencentLocationRequest.a = 10000;
        tencentLocationRequest.b = 1;
        tencentLocationRequest.d = true;
        tencentLocationRequest.e = false;
        tencentLocationRequest.f = false;
        tencentLocationRequest.g = Long.MAX_VALUE;
        tencentLocationRequest.h = BaseClientBuilder.API_PRIORITY_OTHER;
        tencentLocationRequest.c = true;
        tencentLocationRequest.j = "";
        tencentLocationRequest.i = "";
        tencentLocationRequest.k = new Bundle();
        AppMethodBeat.o(136471);
        return tencentLocationRequest;
    }

    public final TencentLocationRequest setInterval(long j) {
        AppMethodBeat.i(136472);
        if (j < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("interval should >= 0");
            AppMethodBeat.o(136472);
            throw illegalArgumentException;
        }
        this.a = j;
        AppMethodBeat.o(136472);
        return this;
    }

    public final TencentLocationRequest setRequestLevel(int i) {
        AppMethodBeat.i(136473);
        if (a(i)) {
            this.b = i;
            AppMethodBeat.o(136473);
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("request_level: " + i + " not supported!");
        AppMethodBeat.o(136473);
        throw illegalArgumentException;
    }

    private boolean a(int i) {
        switch (i) {
            case 0:
            case 1:
            case 3:
            case 4:
                return true;
            default:
                return i == 7;
        }
    }

    public final TencentLocationRequest setAllowCache(boolean z) {
        this.d = z;
        return this;
    }

    public final TencentLocationRequest setAllowGPS(boolean z) {
        this.c = z;
        return this;
    }

    public final TencentLocationRequest setAllowDirection(boolean z) {
        this.e = z;
        return this;
    }

    public final TencentLocationRequest setIndoorLocationMode(boolean z) {
        this.f = z;
        return this;
    }

    public final TencentLocationRequest setQQ(String str) {
        this.j = str;
        return this;
    }

    public final TencentLocationRequest setSmallAppKey(String str) {
        AppMethodBeat.i(136474);
        if (!TextUtils.isEmpty(str)) {
            this.i = str;
        }
        AppMethodBeat.o(136474);
        return this;
    }

    public final String getSmallAppKey() {
        return this.i;
    }

    public final String getQQ() {
        return this.j;
    }

    public final TencentLocationRequest setPhoneNumber(String str) {
        AppMethodBeat.i(136475);
        if (str == null) {
            str = "";
        }
        this.k.putString("phoneNumber", str);
        AppMethodBeat.o(136475);
        return this;
    }

    public final String getPhoneNumber() {
        AppMethodBeat.i(136476);
        String string = this.k.getString("phoneNumber");
        if (string == null) {
            string = "";
        }
        AppMethodBeat.o(136476);
        return string;
    }

    public final long getInterval() {
        return this.a;
    }

    public final int getRequestLevel() {
        return this.b;
    }

    public final boolean isAllowCache() {
        return this.d;
    }

    public final boolean isAllowGPS() {
        return this.c;
    }

    public final boolean isIndoorLocationMode() {
        return this.f;
    }

    public final boolean isAllowDirection() {
        return this.e;
    }

    public final Bundle getExtras() {
        return this.k;
    }

    public final String toString() {
        AppMethodBeat.i(136477);
        String str = "TencentLocationRequest {interval=" + this.a + "ms,level=" + this.b + ",allowCache=" + this.d + ",allowGps=" + this.c + ",allowDirection=" + this.e + ",QQ=" + this.j + "}";
        AppMethodBeat.o(136477);
        return str;
    }
}
