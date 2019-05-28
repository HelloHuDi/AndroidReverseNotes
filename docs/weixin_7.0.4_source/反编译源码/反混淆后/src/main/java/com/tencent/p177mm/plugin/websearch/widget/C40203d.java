package com.tencent.p177mm.plugin.websearch.widget;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.modelappbrand.C26439v;
import com.tencent.p177mm.p230g.p232b.p233a.C26273ad;
import com.tencent.p177mm.plugin.websearch.api.WidgetData;
import com.tencent.p177mm.plugin.websearch.widget.p577a.C4534a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;

/* renamed from: com.tencent.mm.plugin.websearch.widget.d */
public final class C40203d {
    private static final C40203d udm = new C40203d();

    /* renamed from: com.tencent.mm.plugin.websearch.widget.d$a */
    static class C14439a implements C37866a<Bundle, Bundle>, C45413i<Bundle, Bundle> {
        private C14439a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(91436);
            Bundle bundle = (Bundle) obj;
            WidgetData widgetData;
            switch (bundle.getInt(NativeProtocol.WEB_DIALOG_ACTION)) {
                case 2:
                    C40204e.cVQ();
                    AppMethodBeat.m2505o(91436);
                    return;
                case 3:
                    C40204e.cVQ().mo63554b((WidgetData) bundle.getParcelable("data"), bundle.getString("err"));
                    AppMethodBeat.m2505o(91436);
                    return;
                case 4:
                    widgetData = (WidgetData) bundle.getParcelable("data");
                    C40204e.cVQ().udo.add(widgetData);
                    AppMethodBeat.m2505o(91436);
                    return;
                case 5:
                    widgetData = (WidgetData) bundle.getParcelable("data");
                    C40204e.cVQ().udo.remove(widgetData);
                    AppMethodBeat.m2505o(91436);
                    return;
                case 6:
                    C40204e cVQ = C40204e.cVQ();
                    widgetData = (WidgetData) bundle.getParcelable("data");
                    C4534a c4534a = new C4534a();
                    c4534a.field_appid = widgetData.ubs.fpS;
                    cVQ.udp.mo16760a((C4925c) c4534a, new String[0]);
                    AppMethodBeat.m2505o(91436);
                    return;
                case 7:
                    C40204e.cVQ().mo63554b((WidgetData) bundle.getParcelable("data"), bundle.getString("err"));
                    break;
            }
            AppMethodBeat.m2505o(91436);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(91435);
            Bundle bundle = (Bundle) obj;
            Bundle bundle2 = new Bundle();
            switch (bundle.getInt(NativeProtocol.WEB_DIALOG_ACTION)) {
                case 1:
                    boolean z;
                    WidgetData widgetData = (WidgetData) bundle.getParcelable("data");
                    C40204e cVQ = C40204e.cVQ();
                    cVQ.cVE();
                    if (cVQ.f16196RP) {
                        C4534a c4534a = new C4534a();
                        c4534a.field_appid = widgetData.ubs.fpS;
                        if (cVQ.udp.mo10102b((C4925c) c4534a, new String[0])) {
                            C4990ab.m7417i("WidgetSafeModeProxyImpl", "safeModeRecord appid %s, proc crash count %d, js exception count %d", c4534a.field_appid, Integer.valueOf(c4534a.field_crashCount), Integer.valueOf(c4534a.field_jsExceptionCount));
                            if (System.currentTimeMillis() - c4534a.field_beginTimestamp > 172800000) {
                                cVQ.udp.mo16760a((C4925c) c4534a, new String[0]);
                            } else if (c4534a.field_pkgVersion == widgetData.ubs.version) {
                                if (c4534a.field_jsExceptionCount >= 5) {
                                    C4990ab.m7417i("WidgetSafeModeProxyImpl", "local forbidden %s", widgetData.toString());
                                    C26273ad eZ = new C26273ad().mo43951eZ(widgetData.ubs.fpS);
                                    eZ.cYw = (long) widgetData.ubs.fmr;
                                    eZ.cYs = 22;
                                    eZ.cYt = System.currentTimeMillis();
                                    eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
                                    C26439v.m42099kT(32);
                                    z = false;
                                    bundle2.putBoolean("result", z);
                                    break;
                                }
                            } else {
                                cVQ.udp.mo16760a((C4925c) c4534a, new String[0]);
                            }
                        }
                    }
                    z = true;
                    bundle2.putBoolean("result", z);
            }
            AppMethodBeat.m2505o(91435);
            return bundle2;
        }
    }

    static {
        AppMethodBeat.m2504i(91443);
        AppMethodBeat.m2505o(91443);
    }

    public static C40203d cVP() {
        return udm;
    }

    /* renamed from: a */
    public static boolean m68949a(WidgetData widgetData) {
        AppMethodBeat.m2504i(91437);
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 1);
        bundle.putParcelable("data", widgetData);
        boolean z = ((Bundle) C9549f.m17010a("com.tencent.mm", bundle, C14439a.class)).getBoolean("result");
        AppMethodBeat.m2505o(91437);
        return z;
    }

    /* renamed from: b */
    public static void m68951b(WidgetData widgetData, String str) {
        AppMethodBeat.m2504i(91438);
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 3);
        bundle.putParcelable("data", widgetData);
        bundle.putString("err", str);
        C9549f.m17012a("com.tencent.mm", bundle, C14439a.class, null);
        AppMethodBeat.m2505o(91438);
    }

    /* renamed from: c */
    public static void m68953c(WidgetData widgetData, String str) {
        AppMethodBeat.m2504i(91439);
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 7);
        bundle.putParcelable("data", widgetData);
        bundle.putString("err", str);
        C9549f.m17012a("com.tencent.mm", bundle, C14439a.class, null);
        AppMethodBeat.m2505o(91439);
    }

    /* renamed from: b */
    public static void m68950b(WidgetData widgetData) {
        AppMethodBeat.m2504i(91440);
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 4);
        bundle.putParcelable("data", widgetData);
        C9549f.m17012a("com.tencent.mm", bundle, C14439a.class, null);
        AppMethodBeat.m2505o(91440);
    }

    /* renamed from: c */
    public static void m68952c(WidgetData widgetData) {
        AppMethodBeat.m2504i(91441);
        if (widgetData == null) {
            AppMethodBeat.m2505o(91441);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 5);
        bundle.putParcelable("data", widgetData);
        C9549f.m17012a("com.tencent.mm", bundle, C14439a.class, null);
        AppMethodBeat.m2505o(91441);
    }

    /* renamed from: d */
    public static void m68954d(WidgetData widgetData) {
        AppMethodBeat.m2504i(91442);
        C4990ab.m7416i("WidgetSafeModeIpcImpl", "onDisplaySucc");
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 6);
        bundle.putParcelable("data", widgetData);
        C9549f.m17012a("com.tencent.mm", bundle, C14439a.class, null);
        AppMethodBeat.m2505o(91442);
    }
}
