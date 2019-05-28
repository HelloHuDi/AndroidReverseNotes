package com.tencent.p177mm.plugin.appbrand.p1472u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C5141c;
import org.xwalk.core.XWalkEnvironment;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebABTests;", "", "()V", "TAG", "", "XWEB_ABTEST_COMMAND", "XWEB_VIDEO_COMMAND", "clearXwebVideoCommandValue", "", "getXwebVideoCommandValue", "", "openXWebMapSameLayer", "", "openXWebSameLayerRendering", "setXwebVideoCommandValue", "value", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.u.a */
public final class C33536a {
    public static final C33536a jqp = new C33536a();

    static {
        AppMethodBeat.m2504i(135274);
        AppMethodBeat.m2505o(135274);
    }

    private C33536a() {
    }

    public static final void aSi() {
        AppMethodBeat.m2504i(135270);
        C5018as.amF("xweb_abtest_command").removeValueForKey("xweb_video_command_value");
        AppMethodBeat.m2505o(135270);
    }

    /* renamed from: rh */
    public static final void m54769rh(int i) {
        AppMethodBeat.m2504i(135271);
        C5018as.amF("xweb_abtest_command").encode("xweb_video_command_value", i);
        AppMethodBeat.m2505o(135271);
    }

    public static final boolean aSk() {
        int i;
        AppMethodBeat.m2504i(135273);
        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_android_wxa_use_xweb_map, 0) == 1) {
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0 || !XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand()) {
            AppMethodBeat.m2505o(135273);
            return false;
        }
        AppMethodBeat.m2505o(135273);
        return true;
    }

    public static final boolean aSj() {
        AppMethodBeat.m2504i(135272);
        int decodeInt = C5018as.amF("xweb_abtest_command").decodeInt("xweb_video_command_value", -1);
        if (decodeInt >= 0) {
            if (decodeInt == 1) {
                AppMethodBeat.m2505o(135272);
                return true;
            }
            AppMethodBeat.m2505o(135272);
            return false;
        } else if (C5058f.IS_FLAVOR_RED) {
            AppMethodBeat.m2505o(135272);
            return true;
        } else {
            C42142a.m74294PW();
            C5141c ll = C42142a.m74295ll("100439");
            if (ll == null) {
                C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering, item is null");
                AppMethodBeat.m2505o(135272);
                return false;
            } else if (ll.isValid()) {
                boolean z;
                if (C5046bo.getInt((String) ll.dru().get("useXWebVideo"), 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering, abtestFlag:%b", Boolean.valueOf(z));
                AppMethodBeat.m2505o(135272);
                return z;
            } else {
                C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering, item not valid");
                AppMethodBeat.m2505o(135272);
                return false;
            }
        }
    }
}
