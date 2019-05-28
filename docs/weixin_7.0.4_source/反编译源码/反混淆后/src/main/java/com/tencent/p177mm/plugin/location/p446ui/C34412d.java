package com.tencent.p177mm.plugin.location.p446ui;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.location.model.C39283e;
import com.tencent.p177mm.plugin.location.model.LocationInfo;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.URISyntaxException;
import java.net.URLEncoder;

/* renamed from: com.tencent.mm.plugin.location.ui.d */
public final class C34412d {
    private ActivityManager aDn;
    public int cKB = -1;
    public Context context;
    public int nLB = 0;
    public int nLC = 0;
    public boolean nLD = false;

    public static int bJM() {
        AppMethodBeat.m2504i(113438);
        C4990ab.m7410d("MicroMsg.MapHelper", "getDefaultZoom isGoogle : false");
        AppMethodBeat.m2505o(113438);
        return 16;
    }

    public C34412d(Context context) {
        AppMethodBeat.m2504i(113439);
        this.context = context;
        this.aDn = (ActivityManager) context.getSystemService("activity");
        AppMethodBeat.m2505o(113439);
    }

    /* renamed from: a */
    private static String m56411a(Context context, LocationInfo locationInfo) {
        AppMethodBeat.m2504i(113440);
        String string = context.getString(C25738R.string.cn7);
        if (!C5046bo.isNullOrNil(locationInfo.cIK) && !locationInfo.cIK.equals(string)) {
            string = locationInfo.cIK;
            AppMethodBeat.m2505o(113440);
            return string;
        } else if (C5046bo.isNullOrNil(locationInfo.nJx)) {
            string = "";
            AppMethodBeat.m2505o(113440);
            return string;
        } else {
            string = locationInfo.nJx;
            AppMethodBeat.m2505o(113440);
            return string;
        }
    }

    /* renamed from: a */
    private static Intent m56408a(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        AppMethodBeat.m2504i(113441);
        Intent intent;
        if (z || !locationInfo2.bJo()) {
            double[] c = C39283e.m66954c(new double[]{locationInfo.nJv, locationInfo.nJu});
            String str = "android.intent.action.VIEW";
            intent = new Intent(str, Uri.parse(String.format("geo:%s,%s?z=%s", new Object[]{Double.valueOf(c[1]), Double.valueOf(c[0]), Integer.valueOf(locationInfo.nJw)})));
            intent.setPackage("com.baidu.BaiduMap");
            AppMethodBeat.m2505o(113441);
            return intent;
        }
        String format;
        String format2;
        if (C5046bo.isNullOrNil(C34412d.m56411a(context, locationInfo2))) {
            format = String.format("%f,%f", new Object[]{Double.valueOf(locationInfo2.nJu), Double.valueOf(locationInfo2.nJv)});
        } else {
            format = String.format("name:%s|latlng:%f,%f", new Object[]{C34412d.m56411a(context, locationInfo2), Double.valueOf(locationInfo2.nJu), Double.valueOf(locationInfo2.nJv)});
        }
        if (C5046bo.isNullOrNil(C34412d.m56411a(context, locationInfo))) {
            format2 = String.format("%f,%f", new Object[]{Double.valueOf(locationInfo.nJu), Double.valueOf(locationInfo.nJv)});
        } else {
            format2 = String.format("name:%s|latlng:%f,%f", new Object[]{C34412d.m56411a(context, locationInfo), Double.valueOf(locationInfo.nJu), Double.valueOf(locationInfo.nJv)});
        }
        format = String.format("intent://map/direction?origin=%s&destination=%s&mode=driving&coord_type=gcj02", new Object[]{format, format2});
        C4990ab.m7410d("MicroMsg.MapHelper", "url ".concat(String.valueOf(format)));
        try {
            format = format + "&referer=tencent|weixin#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end";
            C4990ab.m7410d("MicroMsg.MapHelper", "all: ".concat(String.valueOf(format)));
            intent = Intent.getIntent(format);
            AppMethodBeat.m2505o(113441);
            return intent;
        } catch (URISyntaxException e) {
            C4990ab.printErrStackTrace("MicroMsg.MapHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(113441);
            return null;
        }
    }

    /* renamed from: a */
    private static Intent m56410a(LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        AppMethodBeat.m2504i(113442);
        Intent intent;
        if (z || !locationInfo2.bJo()) {
            double[] c = C39283e.m66954c(new double[]{locationInfo.nJv, locationInfo.nJu});
            intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%s,%s?z=%s", new Object[]{Double.valueOf(c[1]), Double.valueOf(c[0]), Integer.valueOf(locationInfo.nJw)})));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            AppMethodBeat.m2505o(113442);
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=".concat(String.valueOf(C5046bo.isNullOrNil(locationInfo.nJy) ? "zh-cn" : locationInfo.nJy)), new Object[]{Double.valueOf(locationInfo2.nJu), Double.valueOf(locationInfo2.nJv), Double.valueOf(locationInfo.nJu), Double.valueOf(locationInfo.nJv)})));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        AppMethodBeat.m2505o(113442);
        return intent;
    }

    /* renamed from: b */
    private static Intent m56412b(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        AppMethodBeat.m2504i(113443);
        Intent intent;
        if (z || !locationInfo2.bJo()) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nJu + "," + locationInfo.nJv + "?z=" + locationInfo.nJw));
            intent.setPackage("com.tencent.map");
            AppMethodBeat.m2505o(113443);
            return intent;
        }
        String str = "qqmap://map/routeplan/type=drive&touid=%s&tocoord=%f,%f&from=%s&to=%s&referer=wx_client";
        String str2 = locationInfo.nJB;
        if (!C5046bo.isNullOrNil(locationInfo.nJB) && locationInfo.nJB.startsWith("qqmap_")) {
            str2 = locationInfo.nJB.substring(6);
        }
        String a = C34412d.m56411a(context, locationInfo2);
        String a2 = C34412d.m56411a(context, locationInfo);
        C4990ab.m7411d("MicroMsg.MapHelper", "tencentluxian, url=%s", String.format(str, new Object[]{str2, Double.valueOf(locationInfo.nJu), Double.valueOf(locationInfo.nJv), URLEncoder.encode(a), URLEncoder.encode(a2)}));
        intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
        intent.setPackage("com.tencent.map");
        if (C5046bo.m7572k(context, intent)) {
            AppMethodBeat.m2505o(113443);
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nJu + "," + locationInfo.nJv));
        intent.setPackage("com.tencent.map");
        AppMethodBeat.m2505o(113443);
        return intent;
    }

    /* renamed from: a */
    private static Intent m56409a(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z, String str) {
        AppMethodBeat.m2504i(113444);
        Intent intent;
        if (z || !locationInfo2.bJo()) {
            double[] c = C39283e.m66954c(new double[]{locationInfo.nJv, locationInfo.nJu});
            String str2 = "android.intent.action.VIEW";
            intent = new Intent(str2, Uri.parse(String.format("geo:%s,%s?z=%s", new Object[]{Double.valueOf(c[1]), Double.valueOf(c[0]), Integer.valueOf(locationInfo.nJw)})));
            intent.setPackage(str);
            AppMethodBeat.m2505o(113444);
            return intent;
        }
        String str3 = "&from=%s&to=%s";
        String format = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[]{Double.valueOf(locationInfo2.nJu), Double.valueOf(locationInfo2.nJv), Double.valueOf(locationInfo.nJu), Double.valueOf(locationInfo.nJv)});
        if (!(C5046bo.isNullOrNil(locationInfo2.nJx) || C5046bo.isNullOrNil(locationInfo.nJx))) {
            format = format + String.format(str3, new Object[]{locationInfo2.nJx, locationInfo.nJx});
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent.setPackage(str);
        if (C5046bo.m7572k(context, intent)) {
            AppMethodBeat.m2505o(113444);
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nJu + "," + locationInfo.nJv));
        intent.setPackage(str);
        AppMethodBeat.m2505o(113444);
        return intent;
    }

    /* renamed from: b */
    private static Intent m56413b(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z, String str) {
        AppMethodBeat.m2504i(113445);
        Intent intent;
        if (z || !locationInfo2.bJo()) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nJu + "," + locationInfo.nJv + "?z=" + locationInfo.nJw));
            intent.setPackage(str);
            AppMethodBeat.m2505o(113445);
            return intent;
        }
        String str2 = "&from=%s&to=%s";
        String format = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[]{Double.valueOf(locationInfo2.nJu), Double.valueOf(locationInfo2.nJv), Double.valueOf(locationInfo.nJu), Double.valueOf(locationInfo.nJv)});
        if (!(C5046bo.isNullOrNil(locationInfo2.nJx) || C5046bo.isNullOrNil(locationInfo.nJx))) {
            format = format + String.format(str2, new Object[]{locationInfo2.nJx, locationInfo.nJx});
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent.setPackage(str);
        if (C5046bo.m7572k(context, intent)) {
            AppMethodBeat.m2505o(113445);
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nJu + "," + locationInfo.nJv));
        intent.setPackage(str);
        AppMethodBeat.m2505o(113445);
        return intent;
    }

    /* renamed from: a */
    public final void mo54920a(LocationInfo locationInfo, LocationInfo locationInfo2, String str, boolean z) {
        AppMethodBeat.m2504i(113446);
        if ("com.tencent.map".equals(str)) {
            if (z) {
                C7060h.pYm.mo8381e(11091, Integer.valueOf(4), Integer.valueOf(2));
            } else {
                C7060h.pYm.mo8381e(11091, Integer.valueOf(4), Integer.valueOf(1));
            }
        } else if (z) {
            C7060h.pYm.mo8381e(11091, Integer.valueOf(5), Integer.valueOf(2));
        } else {
            C7060h.pYm.mo8381e(11091, Integer.valueOf(5), Integer.valueOf(1));
        }
        PackageManager packageManager = this.context.getPackageManager();
        Intent a;
        String charSequence;
        PackageInfo aK;
        if ("com.google.android.apps.maps".equals(str)) {
            a = C34412d.m56410a(locationInfo, locationInfo2, false);
            if (!C5046bo.m7572k(this.context, a)) {
                a = C34412d.m56410a(locationInfo, locationInfo2, true);
            }
            C7060h.pYm.mo8381e(10997, "4", "", Integer.valueOf(0), Integer.valueOf(0));
            this.context.startActivity(a);
            AppMethodBeat.m2505o(113446);
        } else if ("com.baidu.BaiduMap".equals(str)) {
            a = C34412d.m56408a(this.context, locationInfo, locationInfo2, false);
            if (!C5046bo.m7572k(this.context, a)) {
                a = C34412d.m56408a(this.context, locationInfo, locationInfo2, true);
            }
            charSequence = C39283e.m66953aK(this.context, "com.baidu.BaiduMap").applicationInfo.loadLabel(packageManager).toString();
            C7060h.pYm.mo8381e(10997, "5", charSequence, Integer.valueOf(0), Integer.valueOf(0));
            this.context.startActivity(a);
            AppMethodBeat.m2505o(113446);
        } else if ("com.tencent.map".equals(str)) {
            a = C34412d.m56412b(this.context, locationInfo, locationInfo2, false);
            if (!C5046bo.m7572k(this.context, a)) {
                a = C34412d.m56412b(this.context, locationInfo, locationInfo2, true);
            }
            C7060h.pYm.mo8381e(10997, "2", "", Integer.valueOf(0), Integer.valueOf(0));
            this.context.startActivity(a);
            AppMethodBeat.m2505o(113446);
        } else if ("com.autonavi.minimap".equals(str)) {
            aK = C39283e.m66953aK(this.context, str);
            if (aK != null) {
                a = C34412d.m56409a(this.context, locationInfo, locationInfo2, false, str);
                if (!C5046bo.m7572k(this.context, a)) {
                    a = C34412d.m56409a(this.context, locationInfo, locationInfo2, true, str);
                }
                charSequence = aK.applicationInfo.loadLabel(packageManager).toString();
                C7060h.pYm.mo8381e(10997, "5", charSequence, Integer.valueOf(0), Integer.valueOf(0));
                this.context.startActivity(a);
            }
            AppMethodBeat.m2505o(113446);
        } else {
            if ("com.sogou.map.android.maps".equals(str)) {
                aK = C39283e.m66953aK(this.context, str);
                if (aK != null) {
                    a = C34412d.m56413b(this.context, locationInfo, locationInfo2, false, str);
                    if (!C5046bo.m7572k(this.context, a)) {
                        a = C34412d.m56413b(this.context, locationInfo, locationInfo2, true, str);
                    }
                    charSequence = aK.applicationInfo.loadLabel(packageManager).toString();
                    C7060h.pYm.mo8381e(10997, "5", charSequence, Integer.valueOf(0), Integer.valueOf(0));
                    this.context.startActivity(a);
                }
            }
            AppMethodBeat.m2505o(113446);
        }
    }
}
