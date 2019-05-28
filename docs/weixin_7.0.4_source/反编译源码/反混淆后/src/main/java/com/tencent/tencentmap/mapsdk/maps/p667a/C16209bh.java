package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.bh */
public final class C16209bh {
    /* renamed from: a */
    private Context f3141a;
    /* renamed from: b */
    private int f3142b;
    /* renamed from: c */
    private boolean f3143c;
    /* renamed from: d */
    private String f3144d = "";
    /* renamed from: e */
    private String f3145e = "";
    /* renamed from: f */
    private String f3146f = "0M100WJ33N1CQ08O";
    /* renamed from: g */
    private boolean f3147g = false;
    /* renamed from: h */
    private int f3148h = -1;

    /* renamed from: a */
    public final Context mo29243a() {
        return this.f3141a;
    }

    /* renamed from: b */
    public final String mo29244b() {
        return this.f3145e;
    }

    /* renamed from: c */
    public final String mo29245c() {
        return this.f3144d;
    }

    /* renamed from: d */
    public final boolean mo29246d() {
        return this.f3143c;
    }

    /* renamed from: e */
    public final int mo29247e() {
        return this.f3142b;
    }

    /* renamed from: f */
    public final boolean mo29248f() {
        return this.f3147g;
    }

    /* renamed from: g */
    public final int mo29249g() {
        return this.f3148h;
    }

    /* renamed from: h */
    public final String mo29250h() {
        return this.f3146f;
    }

    public final String toString() {
        AppMethodBeat.m2504i(98564);
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append("appid:" + this.f3142b);
        stringBuilder.append(",uuid:" + this.f3144d);
        stringBuilder.append(",channelid:" + this.f3145e);
        stringBuilder.append(",isSDKMode:" + this.f3143c);
        stringBuilder.append(",isTest:" + this.f3147g);
        stringBuilder.append(",testAppid:" + this.f3148h);
        stringBuilder.append("]");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(98564);
        return stringBuilder2;
    }

    public C16209bh(Context context, int i, String str, String str2) {
        AppMethodBeat.m2504i(98563);
        this.f3141a = context.getApplicationContext();
        this.f3142b = i;
        this.f3143c = true;
        this.f3144d = str;
        this.f3145e = str2;
        AppMethodBeat.m2505o(98563);
    }
}
