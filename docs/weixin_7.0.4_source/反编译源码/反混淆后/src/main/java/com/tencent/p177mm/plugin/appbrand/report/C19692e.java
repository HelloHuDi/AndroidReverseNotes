package com.tencent.p177mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0007J,\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J<\u0010\f\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00048G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/report/AppBrandStarOperationReporter;", "", "()V", "TAG", "", "value", "pullDownOpenSceneId", "getPullDownOpenSceneId", "()Ljava/lang/String;", "setPullDownOpenSceneId", "(Ljava/lang/String;)V", "generateSceneId", "report", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "eventId", "", "scene", "sceneId", "appId", "appVersion", "appState", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.report.e */
public final class C19692e {
    private static String iAm;
    public static final C19692e iAn = new C19692e();

    static {
        AppMethodBeat.m2504i(134940);
        AppMethodBeat.m2505o(134940);
    }

    private C19692e() {
    }

    /* renamed from: a */
    public static final void m30513a(LocalUsageInfo localUsageInfo, int i, int i2, String str) {
        AppMethodBeat.m2504i(134938);
        if (localUsageInfo != null) {
            String str2 = localUsageInfo.appId;
            int i3 = localUsageInfo.axy;
            int i4 = localUsageInfo.har + 1;
            if (str2 != null) {
                C4990ab.m7410d("MicroMsg.AppBrandStarOperationReporter", "report, appId: " + str2 + ", appVersion: " + i3 + ", appState: : " + i4 + ", eventId: " + i + ',' + "scene: " + i2 + ", sceneId: " + str + ", serviceType: " + C19690c.m30493Dw(str2));
                C7060h.pYm.mo8381e(13801, str2, Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(C5046bo.anT()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(r3));
            }
        }
        AppMethodBeat.m2505o(134938);
    }

    public static final String aLc() {
        AppMethodBeat.m2504i(134939);
        StringBuilder append = new StringBuilder("SceneId@").append(iAn.hashCode()).append('#');
        C25052j.m39375o(C1720g.m3534RN(), "MMKernel.account()");
        String stringBuilder = append.append(C1183p.getString(C1668a.m3383QF())).append('#').append(C5046bo.anU()).toString();
        AppMethodBeat.m2505o(134939);
        return stringBuilder;
    }

    public static final String aLd() {
        return iAm;
    }

    /* renamed from: Dz */
    public static final void m30512Dz(String str) {
        iAm = str;
    }
}
