package com.tencent.mm.plugin.appbrand.u;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.c;
import org.xwalk.core.XWalkEnvironment;

@l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebABTests;", "", "()V", "TAG", "", "XWEB_ABTEST_COMMAND", "XWEB_VIDEO_COMMAND", "clearXwebVideoCommandValue", "", "getXwebVideoCommandValue", "", "openXWebMapSameLayer", "", "openXWebSameLayerRendering", "setXwebVideoCommandValue", "value", "plugin-appbrand-integration_release"})
public final class a {
    public static final a jqp = new a();

    static {
        AppMethodBeat.i(135274);
        AppMethodBeat.o(135274);
    }

    private a() {
    }

    public static final void aSi() {
        AppMethodBeat.i(135270);
        as.amF("xweb_abtest_command").removeValueForKey("xweb_video_command_value");
        AppMethodBeat.o(135270);
    }

    public static final void rh(int i) {
        AppMethodBeat.i(135271);
        as.amF("xweb_abtest_command").encode("xweb_video_command_value", i);
        AppMethodBeat.o(135271);
    }

    public static final boolean aSk() {
        int i;
        AppMethodBeat.i(135273);
        if (((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_android_wxa_use_xweb_map, 0) == 1) {
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0 || !XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand()) {
            AppMethodBeat.o(135273);
            return false;
        }
        AppMethodBeat.o(135273);
        return true;
    }

    public static final boolean aSj() {
        AppMethodBeat.i(135272);
        int decodeInt = as.amF("xweb_abtest_command").decodeInt("xweb_video_command_value", -1);
        if (decodeInt >= 0) {
            if (decodeInt == 1) {
                AppMethodBeat.o(135272);
                return true;
            }
            AppMethodBeat.o(135272);
            return false;
        } else if (f.IS_FLAVOR_RED) {
            AppMethodBeat.o(135272);
            return true;
        } else {
            com.tencent.mm.ipcinvoker.wx_extension.a.a.PW();
            c ll = com.tencent.mm.ipcinvoker.wx_extension.a.a.ll("100439");
            if (ll == null) {
                ab.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering, item is null");
                AppMethodBeat.o(135272);
                return false;
            } else if (ll.isValid()) {
                boolean z;
                if (bo.getInt((String) ll.dru().get("useXWebVideo"), 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                ab.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering, abtestFlag:%b", Boolean.valueOf(z));
                AppMethodBeat.o(135272);
                return z;
            } else {
                ab.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering, item not valid");
                AppMethodBeat.o(135272);
                return false;
            }
        }
    }
}
