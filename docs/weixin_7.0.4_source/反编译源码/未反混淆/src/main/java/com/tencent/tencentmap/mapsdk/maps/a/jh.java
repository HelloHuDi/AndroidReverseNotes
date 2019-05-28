package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.map.lib.b;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.r;
import com.tencent.tencentmap.mapsdk.a.t;
import com.tencent.tencentmap.mapsdk.a.v;
import java.io.Closeable;

public class jh implements b {
    private Context a;
    private final float b = (SystemUtil.getDensity(this.a) / 2.0f);
    private String c;

    public jh(Context context, String str) {
        AppMethodBeat.i(100033);
        this.a = context.getApplicationContext();
        this.c = str;
        AppMethodBeat.o(100033);
    }

    public Bitmap a(String str) {
        AppMethodBeat.i(100034);
        Bitmap a = gj.a(str);
        if (a == null) {
            a = ic.t.a(str);
        }
        if (this.a == null) {
            AppMethodBeat.o(100034);
        } else {
            if (a == null) {
                try {
                    if (str.startsWith("poi_icon") || str.startsWith("mapcfg_")) {
                        a = b(StringUtil.removeSuffix(str) + "@2x.png");
                    }
                    if (a == null) {
                        a = b(str);
                    } else if (str.contains("poi_icon_indoor")) {
                        a = ht.a(a, ((float) ((int) (this.b * ((float) a.getHeight())))) / ((float) a.getHeight()));
                    } else {
                        a = ht.a(a, this.b);
                    }
                } catch (OutOfMemoryError e) {
                }
            }
            AppMethodBeat.o(100034);
        }
        return a;
    }

    public String a(GeoPoint geoPoint) {
        return null;
    }

    private Bitmap b(String str) {
        AppMethodBeat.i(100035);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(100035);
            return null;
        }
        Closeable b = v.b(r.a(this.a).b(this.c) + str);
        if (b == null) {
            b = v.b(r.a(this.a).c(this.c) + str);
        }
        if (b == null) {
            b = v.b(r.a(this.a).e() + str);
        }
        if (b == null) {
            if (t.a() != null) {
                b = t.b(this.a, t.a() + str);
            } else if (t.b() != null) {
                b = v.b(t.b() + str);
            }
        }
        if (b == null) {
            b = t.a(this.a, str);
        }
        if (b == null) {
            b = t.b(this.a, str);
        }
        if (b == null) {
            AppMethodBeat.o(100035);
            return null;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(b);
        v.a(b);
        AppMethodBeat.o(100035);
        return decodeStream;
    }
}
