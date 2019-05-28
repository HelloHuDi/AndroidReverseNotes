package com.tencent.mm.g.b.a;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class cq extends a {
    private String cYD = "";
    private String cYv = "";
    private long dhn = 0;
    private long dho = 0;
    private int dhp = 0;
    private String dhq = "";
    private String dhr = "";
    private String dhs = "";
    private String dht = "";
    private long dhu = 0;
    private String dhv = "";

    public final int getId() {
        return 13582;
    }

    public final cq hx(String str) {
        AppMethodBeat.i(128910);
        this.cYv = t("appid", str, true);
        AppMethodBeat.o(128910);
        return this;
    }

    public final cq ez(long j) {
        this.dhn = j;
        return this;
    }

    public final cq eA(long j) {
        this.dho = j;
        return this;
    }

    public final cq Hj() {
        this.dhp = 9;
        return this;
    }

    public final cq hy(String str) {
        AppMethodBeat.i(128911);
        this.dhr = t("errorMessage", str, true);
        AppMethodBeat.o(128911);
        return this;
    }

    public final cq hz(String str) {
        AppMethodBeat.i(128912);
        this.dhs = t("errorStack", str, true);
        AppMethodBeat.o(128912);
        return this;
    }

    public final cq hA(String str) {
        AppMethodBeat.i(128913);
        this.dht = t("sdkversion", str, true);
        AppMethodBeat.o(128913);
        return this;
    }

    public final cq eB(long j) {
        this.dhu = j;
        return this;
    }

    public final cq hB(String str) {
        AppMethodBeat.i(128914);
        this.dhv = t(TencentExtraKeys.LOCATION_KEY_ROUTE, str, true);
        AppMethodBeat.o(128914);
        return this;
    }

    public final cq hC(String str) {
        AppMethodBeat.i(128915);
        this.cYD = t(SearchIntents.EXTRA_QUERY, str, true);
        AppMethodBeat.o(128915);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(128916);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYv);
        stringBuffer.append(str);
        stringBuffer.append(this.dhn);
        stringBuffer.append(str);
        stringBuffer.append(this.dho);
        stringBuffer.append(str);
        stringBuffer.append(this.dhp);
        stringBuffer.append(str);
        stringBuffer.append(this.dhq);
        stringBuffer.append(str);
        stringBuffer.append(this.dhr);
        stringBuffer.append(str);
        stringBuffer.append(this.dhs);
        stringBuffer.append(str);
        stringBuffer.append(this.dht);
        stringBuffer.append(str);
        stringBuffer.append(this.dhu);
        stringBuffer.append(str);
        stringBuffer.append(this.dhv);
        stringBuffer.append(str);
        stringBuffer.append(this.cYD);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(128916);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(128917);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appid:").append(this.cYv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("appversion:").append(this.dhn);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("appstate:").append(this.dho);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("errorType:").append(this.dhp);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("errorName:").append(this.dhq);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("errorMessage:").append(this.dhr);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("errorStack:").append(this.dhs);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("sdkversion:").append(this.dht);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("apptype:").append(this.dhu);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("route:").append(this.dhv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("query:").append(this.cYD);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(128917);
        return stringBuffer2;
    }
}
