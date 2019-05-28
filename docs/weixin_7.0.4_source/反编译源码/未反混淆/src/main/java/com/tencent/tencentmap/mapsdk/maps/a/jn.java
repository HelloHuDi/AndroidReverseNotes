package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.r;
import com.tencent.tencentmap.mapsdk.a.t;
import com.tencent.tencentmap.mapsdk.a.w;

public class jn {
    private static boolean a = false;

    public static void a(Context context, int i) {
        AppMethodBeat.i(100071);
        if (w.a(context).b("mapConfigStyle") != i) {
            a = true;
            AppMethodBeat.o(100071);
            return;
        }
        a = false;
        AppMethodBeat.o(100071);
    }

    public static void a(Context context, String str) {
        AppMethodBeat.i(100072);
        if (context == null) {
            AppMethodBeat.o(100072);
            return;
        }
        String b = r.a(context).b(str);
        w a = w.a(context);
        a(a);
        int b2 = ic.b("4.2.2.1", a.a("sdkVersion"));
        t.a(context, b, "mapconfig.dat", "mapconfig.dat");
        t.a(context, b, "poi_icon@2x.png", "poi_icon@2x.png");
        t.a(context, b, "poi_icon_nav@2x.png", "poi_icon_nav@2x.png");
        t.a(context, b, "poi_icon_dark@2x.png", "poi_icon_dark@2x.png");
        t.a(context, b, "rtt_config.json", "rtt_config.json");
        t.a(context, b, "indoormap_config.dat", "indoormap_config.dat");
        t.a(context, b, "poi_icon_indoor@2x.png", "poi_icon_indoor@2x.png");
        t.a(context, b, "style_normalmode.xml", "style_normalmode.xml");
        t.a(context, b, "style_trafficmode.xml", "style_trafficmode.xml");
        t.a(context, b, "blockicon.png", "blockicon.png");
        if (b2 > 0) {
            a.a("sdkVersion", "4.2.2.1");
        }
        AppMethodBeat.o(100072);
    }

    private static void a(w wVar) {
        AppMethodBeat.i(100073);
        if (ic.b(wVar.a("sdkVersion"), "4.0.9.1") < 0) {
            wVar.a(new String[]{"mapConfigIndoorVersion", "mapPoiIconIndoorVersion"});
        }
        AppMethodBeat.o(100073);
    }
}
