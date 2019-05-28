package com.tencent.p177mm.p230g.p232b.p233a;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.cq */
public final class C26287cq extends C46180a {
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

    /* renamed from: hx */
    public final C26287cq mo44045hx(String str) {
        AppMethodBeat.m2504i(128910);
        this.cYv = mo74169t("appid", str, true);
        AppMethodBeat.m2505o(128910);
        return this;
    }

    /* renamed from: ez */
    public final C26287cq mo44041ez(long j) {
        this.dhn = j;
        return this;
    }

    /* renamed from: eA */
    public final C26287cq mo44039eA(long j) {
        this.dho = j;
        return this;
    }

    /* renamed from: Hj */
    public final C26287cq mo44038Hj() {
        this.dhp = 9;
        return this;
    }

    /* renamed from: hy */
    public final C26287cq mo44046hy(String str) {
        AppMethodBeat.m2504i(128911);
        this.dhr = mo74169t("errorMessage", str, true);
        AppMethodBeat.m2505o(128911);
        return this;
    }

    /* renamed from: hz */
    public final C26287cq mo44047hz(String str) {
        AppMethodBeat.m2504i(128912);
        this.dhs = mo74169t("errorStack", str, true);
        AppMethodBeat.m2505o(128912);
        return this;
    }

    /* renamed from: hA */
    public final C26287cq mo44042hA(String str) {
        AppMethodBeat.m2504i(128913);
        this.dht = mo74169t("sdkversion", str, true);
        AppMethodBeat.m2505o(128913);
        return this;
    }

    /* renamed from: eB */
    public final C26287cq mo44040eB(long j) {
        this.dhu = j;
        return this;
    }

    /* renamed from: hB */
    public final C26287cq mo44043hB(String str) {
        AppMethodBeat.m2504i(128914);
        this.dhv = mo74169t(TencentExtraKeys.LOCATION_KEY_ROUTE, str, true);
        AppMethodBeat.m2505o(128914);
        return this;
    }

    /* renamed from: hC */
    public final C26287cq mo44044hC(String str) {
        AppMethodBeat.m2504i(128915);
        this.cYD = mo74169t(SearchIntents.EXTRA_QUERY, str, true);
        AppMethodBeat.m2505o(128915);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(128916);
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
        mo74164VX(str);
        AppMethodBeat.m2505o(128916);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128917);
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
        AppMethodBeat.m2505o(128917);
        return stringBuffer2;
    }
}
