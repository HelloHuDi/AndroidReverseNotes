package com.tencent.mm.plugin.location.ui;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URISyntaxException;
import java.net.URLEncoder;

public final class d {
    private ActivityManager aDn;
    public int cKB = -1;
    public Context context;
    public int nLB = 0;
    public int nLC = 0;
    public boolean nLD = false;

    public static int bJM() {
        AppMethodBeat.i(113438);
        ab.d("MicroMsg.MapHelper", "getDefaultZoom isGoogle : false");
        AppMethodBeat.o(113438);
        return 16;
    }

    public d(Context context) {
        AppMethodBeat.i(113439);
        this.context = context;
        this.aDn = (ActivityManager) context.getSystemService("activity");
        AppMethodBeat.o(113439);
    }

    private static String a(Context context, LocationInfo locationInfo) {
        AppMethodBeat.i(113440);
        String string = context.getString(R.string.cn7);
        if (!bo.isNullOrNil(locationInfo.cIK) && !locationInfo.cIK.equals(string)) {
            string = locationInfo.cIK;
            AppMethodBeat.o(113440);
            return string;
        } else if (bo.isNullOrNil(locationInfo.nJx)) {
            string = "";
            AppMethodBeat.o(113440);
            return string;
        } else {
            string = locationInfo.nJx;
            AppMethodBeat.o(113440);
            return string;
        }
    }

    private static Intent a(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        AppMethodBeat.i(113441);
        Intent intent;
        if (z || !locationInfo2.bJo()) {
            double[] c = e.c(new double[]{locationInfo.nJv, locationInfo.nJu});
            String str = "android.intent.action.VIEW";
            intent = new Intent(str, Uri.parse(String.format("geo:%s,%s?z=%s", new Object[]{Double.valueOf(c[1]), Double.valueOf(c[0]), Integer.valueOf(locationInfo.nJw)})));
            intent.setPackage("com.baidu.BaiduMap");
            AppMethodBeat.o(113441);
            return intent;
        }
        String format;
        String format2;
        if (bo.isNullOrNil(a(context, locationInfo2))) {
            format = String.format("%f,%f", new Object[]{Double.valueOf(locationInfo2.nJu), Double.valueOf(locationInfo2.nJv)});
        } else {
            format = String.format("name:%s|latlng:%f,%f", new Object[]{a(context, locationInfo2), Double.valueOf(locationInfo2.nJu), Double.valueOf(locationInfo2.nJv)});
        }
        if (bo.isNullOrNil(a(context, locationInfo))) {
            format2 = String.format("%f,%f", new Object[]{Double.valueOf(locationInfo.nJu), Double.valueOf(locationInfo.nJv)});
        } else {
            format2 = String.format("name:%s|latlng:%f,%f", new Object[]{a(context, locationInfo), Double.valueOf(locationInfo.nJu), Double.valueOf(locationInfo.nJv)});
        }
        format = String.format("intent://map/direction?origin=%s&destination=%s&mode=driving&coord_type=gcj02", new Object[]{format, format2});
        ab.d("MicroMsg.MapHelper", "url ".concat(String.valueOf(format)));
        try {
            format = format + "&referer=tencent|weixin#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end";
            ab.d("MicroMsg.MapHelper", "all: ".concat(String.valueOf(format)));
            intent = Intent.getIntent(format);
            AppMethodBeat.o(113441);
            return intent;
        } catch (URISyntaxException e) {
            ab.printErrStackTrace("MicroMsg.MapHelper", e, "", new Object[0]);
            AppMethodBeat.o(113441);
            return null;
        }
    }

    private static Intent a(LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        AppMethodBeat.i(113442);
        Intent intent;
        if (z || !locationInfo2.bJo()) {
            double[] c = e.c(new double[]{locationInfo.nJv, locationInfo.nJu});
            intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%s,%s?z=%s", new Object[]{Double.valueOf(c[1]), Double.valueOf(c[0]), Integer.valueOf(locationInfo.nJw)})));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            AppMethodBeat.o(113442);
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=".concat(String.valueOf(bo.isNullOrNil(locationInfo.nJy) ? "zh-cn" : locationInfo.nJy)), new Object[]{Double.valueOf(locationInfo2.nJu), Double.valueOf(locationInfo2.nJv), Double.valueOf(locationInfo.nJu), Double.valueOf(locationInfo.nJv)})));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        AppMethodBeat.o(113442);
        return intent;
    }

    private static Intent b(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        AppMethodBeat.i(113443);
        Intent intent;
        if (z || !locationInfo2.bJo()) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nJu + "," + locationInfo.nJv + "?z=" + locationInfo.nJw));
            intent.setPackage("com.tencent.map");
            AppMethodBeat.o(113443);
            return intent;
        }
        String str = "qqmap://map/routeplan/type=drive&touid=%s&tocoord=%f,%f&from=%s&to=%s&referer=wx_client";
        String str2 = locationInfo.nJB;
        if (!bo.isNullOrNil(locationInfo.nJB) && locationInfo.nJB.startsWith("qqmap_")) {
            str2 = locationInfo.nJB.substring(6);
        }
        String a = a(context, locationInfo2);
        String a2 = a(context, locationInfo);
        ab.d("MicroMsg.MapHelper", "tencentluxian, url=%s", String.format(str, new Object[]{str2, Double.valueOf(locationInfo.nJu), Double.valueOf(locationInfo.nJv), URLEncoder.encode(a), URLEncoder.encode(a2)}));
        intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
        intent.setPackage("com.tencent.map");
        if (bo.k(context, intent)) {
            AppMethodBeat.o(113443);
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nJu + "," + locationInfo.nJv));
        intent.setPackage("com.tencent.map");
        AppMethodBeat.o(113443);
        return intent;
    }

    private static Intent a(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z, String str) {
        AppMethodBeat.i(113444);
        Intent intent;
        if (z || !locationInfo2.bJo()) {
            double[] c = e.c(new double[]{locationInfo.nJv, locationInfo.nJu});
            String str2 = "android.intent.action.VIEW";
            intent = new Intent(str2, Uri.parse(String.format("geo:%s,%s?z=%s", new Object[]{Double.valueOf(c[1]), Double.valueOf(c[0]), Integer.valueOf(locationInfo.nJw)})));
            intent.setPackage(str);
            AppMethodBeat.o(113444);
            return intent;
        }
        String str3 = "&from=%s&to=%s";
        String format = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[]{Double.valueOf(locationInfo2.nJu), Double.valueOf(locationInfo2.nJv), Double.valueOf(locationInfo.nJu), Double.valueOf(locationInfo.nJv)});
        if (!(bo.isNullOrNil(locationInfo2.nJx) || bo.isNullOrNil(locationInfo.nJx))) {
            format = format + String.format(str3, new Object[]{locationInfo2.nJx, locationInfo.nJx});
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent.setPackage(str);
        if (bo.k(context, intent)) {
            AppMethodBeat.o(113444);
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nJu + "," + locationInfo.nJv));
        intent.setPackage(str);
        AppMethodBeat.o(113444);
        return intent;
    }

    private static Intent b(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z, String str) {
        AppMethodBeat.i(113445);
        Intent intent;
        if (z || !locationInfo2.bJo()) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nJu + "," + locationInfo.nJv + "?z=" + locationInfo.nJw));
            intent.setPackage(str);
            AppMethodBeat.o(113445);
            return intent;
        }
        String str2 = "&from=%s&to=%s";
        String format = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[]{Double.valueOf(locationInfo2.nJu), Double.valueOf(locationInfo2.nJv), Double.valueOf(locationInfo.nJu), Double.valueOf(locationInfo.nJv)});
        if (!(bo.isNullOrNil(locationInfo2.nJx) || bo.isNullOrNil(locationInfo.nJx))) {
            format = format + String.format(str2, new Object[]{locationInfo2.nJx, locationInfo.nJx});
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent.setPackage(str);
        if (bo.k(context, intent)) {
            AppMethodBeat.o(113445);
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nJu + "," + locationInfo.nJv));
        intent.setPackage(str);
        AppMethodBeat.o(113445);
        return intent;
    }

    public final void a(LocationInfo locationInfo, LocationInfo locationInfo2, String str, boolean z) {
        AppMethodBeat.i(113446);
        if ("com.tencent.map".equals(str)) {
            if (z) {
                h.pYm.e(11091, Integer.valueOf(4), Integer.valueOf(2));
            } else {
                h.pYm.e(11091, Integer.valueOf(4), Integer.valueOf(1));
            }
        } else if (z) {
            h.pYm.e(11091, Integer.valueOf(5), Integer.valueOf(2));
        } else {
            h.pYm.e(11091, Integer.valueOf(5), Integer.valueOf(1));
        }
        PackageManager packageManager = this.context.getPackageManager();
        Intent a;
        String charSequence;
        PackageInfo aK;
        if ("com.google.android.apps.maps".equals(str)) {
            a = a(locationInfo, locationInfo2, false);
            if (!bo.k(this.context, a)) {
                a = a(locationInfo, locationInfo2, true);
            }
            h.pYm.e(10997, "4", "", Integer.valueOf(0), Integer.valueOf(0));
            this.context.startActivity(a);
            AppMethodBeat.o(113446);
        } else if ("com.baidu.BaiduMap".equals(str)) {
            a = a(this.context, locationInfo, locationInfo2, false);
            if (!bo.k(this.context, a)) {
                a = a(this.context, locationInfo, locationInfo2, true);
            }
            charSequence = e.aK(this.context, "com.baidu.BaiduMap").applicationInfo.loadLabel(packageManager).toString();
            h.pYm.e(10997, "5", charSequence, Integer.valueOf(0), Integer.valueOf(0));
            this.context.startActivity(a);
            AppMethodBeat.o(113446);
        } else if ("com.tencent.map".equals(str)) {
            a = b(this.context, locationInfo, locationInfo2, false);
            if (!bo.k(this.context, a)) {
                a = b(this.context, locationInfo, locationInfo2, true);
            }
            h.pYm.e(10997, "2", "", Integer.valueOf(0), Integer.valueOf(0));
            this.context.startActivity(a);
            AppMethodBeat.o(113446);
        } else if ("com.autonavi.minimap".equals(str)) {
            aK = e.aK(this.context, str);
            if (aK != null) {
                a = a(this.context, locationInfo, locationInfo2, false, str);
                if (!bo.k(this.context, a)) {
                    a = a(this.context, locationInfo, locationInfo2, true, str);
                }
                charSequence = aK.applicationInfo.loadLabel(packageManager).toString();
                h.pYm.e(10997, "5", charSequence, Integer.valueOf(0), Integer.valueOf(0));
                this.context.startActivity(a);
            }
            AppMethodBeat.o(113446);
        } else {
            if ("com.sogou.map.android.maps".equals(str)) {
                aK = e.aK(this.context, str);
                if (aK != null) {
                    a = b(this.context, locationInfo, locationInfo2, false, str);
                    if (!bo.k(this.context, a)) {
                        a = b(this.context, locationInfo, locationInfo2, true, str);
                    }
                    charSequence = aK.applicationInfo.loadLabel(packageManager).toString();
                    h.pYm.e(10997, "5", charSequence, Integer.valueOf(0), Integer.valueOf(0));
                    this.context.startActivity(a);
                }
            }
            AppMethodBeat.o(113446);
        }
    }
}
