package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C31016w;
import com.tencent.tencentmap.mapsdk.p666a.C46765r;
import com.tencent.tencentmap.mapsdk.p666a.C46766t;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jn */
public class C46795jn {
    /* renamed from: a */
    private static boolean f18239a = false;

    /* renamed from: a */
    public static void m88976a(Context context, int i) {
        AppMethodBeat.m2504i(100071);
        if (C31016w.m49806a(context).mo65087b("mapConfigStyle") != i) {
            f18239a = true;
            AppMethodBeat.m2505o(100071);
            return;
        }
        f18239a = false;
        AppMethodBeat.m2505o(100071);
    }

    /* renamed from: a */
    public static void m88977a(Context context, String str) {
        AppMethodBeat.m2504i(100072);
        if (context == null) {
            AppMethodBeat.m2505o(100072);
            return;
        }
        String b = C46765r.m88663a(context).mo75316b(str);
        C31016w a = C31016w.m49806a(context);
        C46795jn.m88978a(a);
        int b2 = C36520ic.m60481b("4.2.2.1", a.mo65080a("sdkVersion"));
        C46766t.m88677a(context, b, "mapconfig.dat", "mapconfig.dat");
        C46766t.m88677a(context, b, "poi_icon@2x.png", "poi_icon@2x.png");
        C46766t.m88677a(context, b, "poi_icon_nav@2x.png", "poi_icon_nav@2x.png");
        C46766t.m88677a(context, b, "poi_icon_dark@2x.png", "poi_icon_dark@2x.png");
        C46766t.m88677a(context, b, "rtt_config.json", "rtt_config.json");
        C46766t.m88677a(context, b, "indoormap_config.dat", "indoormap_config.dat");
        C46766t.m88677a(context, b, "poi_icon_indoor@2x.png", "poi_icon_indoor@2x.png");
        C46766t.m88677a(context, b, "style_normalmode.xml", "style_normalmode.xml");
        C46766t.m88677a(context, b, "style_trafficmode.xml", "style_trafficmode.xml");
        C46766t.m88677a(context, b, "blockicon.png", "blockicon.png");
        if (b2 > 0) {
            a.mo65084a("sdkVersion", "4.2.2.1");
        }
        AppMethodBeat.m2505o(100072);
    }

    /* renamed from: a */
    private static void m88978a(C31016w c31016w) {
        AppMethodBeat.m2504i(100073);
        if (C36520ic.m60481b(c31016w.mo65080a("sdkVersion"), "4.0.9.1") < 0) {
            c31016w.mo65086a(new String[]{"mapConfigIndoorVersion", "mapPoiIconIndoorVersion"});
        }
        AppMethodBeat.m2505o(100073);
    }
}
