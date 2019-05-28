package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bh {
    private Context a;
    private int b;
    private boolean c;
    private String d = "";
    private String e = "";
    private String f = "0M100WJ33N1CQ08O";
    private boolean g = false;
    private int h = -1;

    public final Context a() {
        return this.a;
    }

    public final String b() {
        return this.e;
    }

    public final String c() {
        return this.d;
    }

    public final boolean d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        return this.g;
    }

    public final int g() {
        return this.h;
    }

    public final String h() {
        return this.f;
    }

    public final String toString() {
        AppMethodBeat.i(98564);
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append("appid:" + this.b);
        stringBuilder.append(",uuid:" + this.d);
        stringBuilder.append(",channelid:" + this.e);
        stringBuilder.append(",isSDKMode:" + this.c);
        stringBuilder.append(",isTest:" + this.g);
        stringBuilder.append(",testAppid:" + this.h);
        stringBuilder.append("]");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(98564);
        return stringBuilder2;
    }

    public bh(Context context, int i, String str, String str2) {
        AppMethodBeat.i(98563);
        this.a = context.getApplicationContext();
        this.b = i;
        this.c = true;
        this.d = str;
        this.e = str2;
        AppMethodBeat.o(98563);
    }
}
