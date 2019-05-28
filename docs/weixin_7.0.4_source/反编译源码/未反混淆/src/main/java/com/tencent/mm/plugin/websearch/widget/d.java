package com.tencent.mm.plugin.websearch.widget;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ad;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

public final class d {
    private static final d udm = new d();

    static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle>, i<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(91436);
            Bundle bundle = (Bundle) obj;
            WidgetData widgetData;
            switch (bundle.getInt(NativeProtocol.WEB_DIALOG_ACTION)) {
                case 2:
                    e.cVQ();
                    AppMethodBeat.o(91436);
                    return;
                case 3:
                    e.cVQ().b((WidgetData) bundle.getParcelable("data"), bundle.getString("err"));
                    AppMethodBeat.o(91436);
                    return;
                case 4:
                    widgetData = (WidgetData) bundle.getParcelable("data");
                    e.cVQ().udo.add(widgetData);
                    AppMethodBeat.o(91436);
                    return;
                case 5:
                    widgetData = (WidgetData) bundle.getParcelable("data");
                    e.cVQ().udo.remove(widgetData);
                    AppMethodBeat.o(91436);
                    return;
                case 6:
                    e cVQ = e.cVQ();
                    widgetData = (WidgetData) bundle.getParcelable("data");
                    com.tencent.mm.plugin.websearch.widget.a.a aVar = new com.tencent.mm.plugin.websearch.widget.a.a();
                    aVar.field_appid = widgetData.ubs.fpS;
                    cVQ.udp.a((com.tencent.mm.sdk.e.c) aVar, new String[0]);
                    AppMethodBeat.o(91436);
                    return;
                case 7:
                    e.cVQ().b((WidgetData) bundle.getParcelable("data"), bundle.getString("err"));
                    break;
            }
            AppMethodBeat.o(91436);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(91435);
            Bundle bundle = (Bundle) obj;
            Bundle bundle2 = new Bundle();
            switch (bundle.getInt(NativeProtocol.WEB_DIALOG_ACTION)) {
                case 1:
                    boolean z;
                    WidgetData widgetData = (WidgetData) bundle.getParcelable("data");
                    e cVQ = e.cVQ();
                    cVQ.cVE();
                    if (cVQ.RP) {
                        com.tencent.mm.plugin.websearch.widget.a.a aVar = new com.tencent.mm.plugin.websearch.widget.a.a();
                        aVar.field_appid = widgetData.ubs.fpS;
                        if (cVQ.udp.b((com.tencent.mm.sdk.e.c) aVar, new String[0])) {
                            ab.i("WidgetSafeModeProxyImpl", "safeModeRecord appid %s, proc crash count %d, js exception count %d", aVar.field_appid, Integer.valueOf(aVar.field_crashCount), Integer.valueOf(aVar.field_jsExceptionCount));
                            if (System.currentTimeMillis() - aVar.field_beginTimestamp > 172800000) {
                                cVQ.udp.a((com.tencent.mm.sdk.e.c) aVar, new String[0]);
                            } else if (aVar.field_pkgVersion == widgetData.ubs.version) {
                                if (aVar.field_jsExceptionCount >= 5) {
                                    ab.i("WidgetSafeModeProxyImpl", "local forbidden %s", widgetData.toString());
                                    ad eZ = new ad().eZ(widgetData.ubs.fpS);
                                    eZ.cYw = (long) widgetData.ubs.fmr;
                                    eZ.cYs = 22;
                                    eZ.cYt = System.currentTimeMillis();
                                    eZ.fa(at.gB(ah.getContext())).ajK();
                                    v.kT(32);
                                    z = false;
                                    bundle2.putBoolean("result", z);
                                    break;
                                }
                            } else {
                                cVQ.udp.a((com.tencent.mm.sdk.e.c) aVar, new String[0]);
                            }
                        }
                    }
                    z = true;
                    bundle2.putBoolean("result", z);
            }
            AppMethodBeat.o(91435);
            return bundle2;
        }
    }

    static {
        AppMethodBeat.i(91443);
        AppMethodBeat.o(91443);
    }

    public static d cVP() {
        return udm;
    }

    public static boolean a(WidgetData widgetData) {
        AppMethodBeat.i(91437);
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 1);
        bundle.putParcelable("data", widgetData);
        boolean z = ((Bundle) f.a("com.tencent.mm", bundle, a.class)).getBoolean("result");
        AppMethodBeat.o(91437);
        return z;
    }

    public static void b(WidgetData widgetData, String str) {
        AppMethodBeat.i(91438);
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 3);
        bundle.putParcelable("data", widgetData);
        bundle.putString("err", str);
        f.a("com.tencent.mm", bundle, a.class, null);
        AppMethodBeat.o(91438);
    }

    public static void c(WidgetData widgetData, String str) {
        AppMethodBeat.i(91439);
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 7);
        bundle.putParcelable("data", widgetData);
        bundle.putString("err", str);
        f.a("com.tencent.mm", bundle, a.class, null);
        AppMethodBeat.o(91439);
    }

    public static void b(WidgetData widgetData) {
        AppMethodBeat.i(91440);
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 4);
        bundle.putParcelable("data", widgetData);
        f.a("com.tencent.mm", bundle, a.class, null);
        AppMethodBeat.o(91440);
    }

    public static void c(WidgetData widgetData) {
        AppMethodBeat.i(91441);
        if (widgetData == null) {
            AppMethodBeat.o(91441);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 5);
        bundle.putParcelable("data", widgetData);
        f.a("com.tencent.mm", bundle, a.class, null);
        AppMethodBeat.o(91441);
    }

    public static void d(WidgetData widgetData) {
        AppMethodBeat.i(91442);
        ab.i("WidgetSafeModeIpcImpl", "onDisplaySucc");
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 6);
        bundle.putParcelable("data", widgetData);
        f.a("com.tencent.mm", bundle, a.class, null);
        AppMethodBeat.o(91442);
    }
}
