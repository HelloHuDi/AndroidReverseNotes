package com.tencent.mm.plugin.appbrand.report;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0007J,\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J<\u0010\f\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00048G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/report/AppBrandStarOperationReporter;", "", "()V", "TAG", "", "value", "pullDownOpenSceneId", "getPullDownOpenSceneId", "()Ljava/lang/String;", "setPullDownOpenSceneId", "(Ljava/lang/String;)V", "generateSceneId", "report", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "eventId", "", "scene", "sceneId", "appId", "appVersion", "appState", "plugin-appbrand-integration_release"})
public final class e {
    private static String iAm;
    public static final e iAn = new e();

    static {
        AppMethodBeat.i(134940);
        AppMethodBeat.o(134940);
    }

    private e() {
    }

    public static final void a(LocalUsageInfo localUsageInfo, int i, int i2, String str) {
        AppMethodBeat.i(134938);
        if (localUsageInfo != null) {
            String str2 = localUsageInfo.appId;
            int i3 = localUsageInfo.axy;
            int i4 = localUsageInfo.har + 1;
            if (str2 != null) {
                ab.d("MicroMsg.AppBrandStarOperationReporter", "report, appId: " + str2 + ", appVersion: " + i3 + ", appState: : " + i4 + ", eventId: " + i + ',' + "scene: " + i2 + ", sceneId: " + str + ", serviceType: " + c.Dw(str2));
                h.pYm.e(13801, str2, Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(bo.anT()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(r3));
            }
        }
        AppMethodBeat.o(134938);
    }

    public static final String aLc() {
        AppMethodBeat.i(134939);
        StringBuilder append = new StringBuilder("SceneId@").append(iAn.hashCode()).append('#');
        j.o(g.RN(), "MMKernel.account()");
        String stringBuilder = append.append(p.getString(a.QF())).append('#').append(bo.anU()).toString();
        AppMethodBeat.o(134939);
        return stringBuilder;
    }

    public static final String aLd() {
        return iAm;
    }

    public static final void Dz(String str) {
        iAm = str;
    }
}
