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
    /* renamed from: a */
    private long f17127a;
    /* renamed from: b */
    private int f17128b;
    /* renamed from: c */
    private boolean f17129c;
    /* renamed from: d */
    private boolean f17130d;
    /* renamed from: e */
    private boolean f17131e;
    /* renamed from: f */
    private boolean f17132f;
    /* renamed from: g */
    private long f17133g;
    /* renamed from: h */
    private int f17134h;
    /* renamed from: i */
    private String f17135i;
    /* renamed from: j */
    private String f17136j;
    /* renamed from: k */
    private Bundle f17137k;

    private TencentLocationRequest() {
    }

    public TencentLocationRequest(TencentLocationRequest tencentLocationRequest) {
        AppMethodBeat.m2504i(136469);
        this.f17127a = tencentLocationRequest.f17127a;
        this.f17128b = tencentLocationRequest.f17128b;
        this.f17130d = tencentLocationRequest.f17130d;
        this.f17131e = tencentLocationRequest.f17131e;
        this.f17133g = tencentLocationRequest.f17133g;
        this.f17134h = tencentLocationRequest.f17134h;
        this.f17129c = tencentLocationRequest.f17129c;
        this.f17132f = tencentLocationRequest.f17132f;
        this.f17136j = tencentLocationRequest.f17136j;
        this.f17135i = tencentLocationRequest.f17135i;
        this.f17137k = new Bundle();
        this.f17137k.putAll(tencentLocationRequest.f17137k);
        AppMethodBeat.m2505o(136469);
    }

    public static void copy(TencentLocationRequest tencentLocationRequest, TencentLocationRequest tencentLocationRequest2) {
        AppMethodBeat.m2504i(136470);
        tencentLocationRequest.f17127a = tencentLocationRequest2.f17127a;
        tencentLocationRequest.f17128b = tencentLocationRequest2.f17128b;
        tencentLocationRequest.f17130d = tencentLocationRequest2.f17130d;
        tencentLocationRequest.f17131e = tencentLocationRequest2.f17131e;
        tencentLocationRequest.f17133g = tencentLocationRequest2.f17133g;
        tencentLocationRequest.f17134h = tencentLocationRequest2.f17134h;
        tencentLocationRequest.f17132f = tencentLocationRequest2.f17132f;
        tencentLocationRequest.f17129c = tencentLocationRequest2.f17129c;
        tencentLocationRequest.f17136j = tencentLocationRequest2.f17136j;
        tencentLocationRequest.f17135i = tencentLocationRequest2.f17135i;
        tencentLocationRequest.f17137k.clear();
        tencentLocationRequest.f17137k.putAll(tencentLocationRequest2.f17137k);
        AppMethodBeat.m2505o(136470);
    }

    public static TencentLocationRequest create() {
        AppMethodBeat.m2504i(136471);
        TencentLocationRequest tencentLocationRequest = new TencentLocationRequest();
        tencentLocationRequest.f17127a = 10000;
        tencentLocationRequest.f17128b = 1;
        tencentLocationRequest.f17130d = true;
        tencentLocationRequest.f17131e = false;
        tencentLocationRequest.f17132f = false;
        tencentLocationRequest.f17133g = Long.MAX_VALUE;
        tencentLocationRequest.f17134h = BaseClientBuilder.API_PRIORITY_OTHER;
        tencentLocationRequest.f17129c = true;
        tencentLocationRequest.f17136j = "";
        tencentLocationRequest.f17135i = "";
        tencentLocationRequest.f17137k = new Bundle();
        AppMethodBeat.m2505o(136471);
        return tencentLocationRequest;
    }

    public final TencentLocationRequest setInterval(long j) {
        AppMethodBeat.m2504i(136472);
        if (j < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("interval should >= 0");
            AppMethodBeat.m2505o(136472);
            throw illegalArgumentException;
        }
        this.f17127a = j;
        AppMethodBeat.m2505o(136472);
        return this;
    }

    public final TencentLocationRequest setRequestLevel(int i) {
        AppMethodBeat.m2504i(136473);
        if (m73397a(i)) {
            this.f17128b = i;
            AppMethodBeat.m2505o(136473);
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("request_level: " + i + " not supported!");
        AppMethodBeat.m2505o(136473);
        throw illegalArgumentException;
    }

    /* renamed from: a */
    private boolean m73397a(int i) {
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
        this.f17130d = z;
        return this;
    }

    public final TencentLocationRequest setAllowGPS(boolean z) {
        this.f17129c = z;
        return this;
    }

    public final TencentLocationRequest setAllowDirection(boolean z) {
        this.f17131e = z;
        return this;
    }

    public final TencentLocationRequest setIndoorLocationMode(boolean z) {
        this.f17132f = z;
        return this;
    }

    public final TencentLocationRequest setQQ(String str) {
        this.f17136j = str;
        return this;
    }

    public final TencentLocationRequest setSmallAppKey(String str) {
        AppMethodBeat.m2504i(136474);
        if (!TextUtils.isEmpty(str)) {
            this.f17135i = str;
        }
        AppMethodBeat.m2505o(136474);
        return this;
    }

    public final String getSmallAppKey() {
        return this.f17135i;
    }

    public final String getQQ() {
        return this.f17136j;
    }

    public final TencentLocationRequest setPhoneNumber(String str) {
        AppMethodBeat.m2504i(136475);
        if (str == null) {
            str = "";
        }
        this.f17137k.putString("phoneNumber", str);
        AppMethodBeat.m2505o(136475);
        return this;
    }

    public final String getPhoneNumber() {
        AppMethodBeat.m2504i(136476);
        String string = this.f17137k.getString("phoneNumber");
        if (string == null) {
            string = "";
        }
        AppMethodBeat.m2505o(136476);
        return string;
    }

    public final long getInterval() {
        return this.f17127a;
    }

    public final int getRequestLevel() {
        return this.f17128b;
    }

    public final boolean isAllowCache() {
        return this.f17130d;
    }

    public final boolean isAllowGPS() {
        return this.f17129c;
    }

    public final boolean isIndoorLocationMode() {
        return this.f17132f;
    }

    public final boolean isAllowDirection() {
        return this.f17131e;
    }

    public final Bundle getExtras() {
        return this.f17137k;
    }

    public final String toString() {
        AppMethodBeat.m2504i(136477);
        String str = "TencentLocationRequest {interval=" + this.f17127a + "ms,level=" + this.f17128b + ",allowCache=" + this.f17130d + ",allowGps=" + this.f17129c + ",allowDirection=" + this.f17131e + ",QQ=" + this.f17136j + "}";
        AppMethodBeat.m2505o(136477);
        return str;
    }
}
