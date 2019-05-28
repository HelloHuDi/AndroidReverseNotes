package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.map.lib.C41716b;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C31015v;
import com.tencent.tencentmap.mapsdk.p666a.C46765r;
import com.tencent.tencentmap.mapsdk.p666a.C46766t;
import java.io.Closeable;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jh */
public class C36524jh implements C41716b {
    /* renamed from: a */
    private Context f15431a;
    /* renamed from: b */
    private final float f15432b = (SystemUtil.getDensity(this.f15431a) / 2.0f);
    /* renamed from: c */
    private String f15433c;

    public C36524jh(Context context, String str) {
        AppMethodBeat.m2504i(100033);
        this.f15431a = context.getApplicationContext();
        this.f15433c = str;
        AppMethodBeat.m2505o(100033);
    }

    /* renamed from: a */
    public Bitmap mo57764a(String str) {
        AppMethodBeat.m2504i(100034);
        Bitmap a = C16263gj.m24919a(str);
        if (a == null) {
            a = C36520ic.f15415t.mo40419a(str);
        }
        if (this.f15431a == null) {
            AppMethodBeat.m2505o(100034);
        } else {
            if (a == null) {
                try {
                    if (str.startsWith("poi_icon") || str.startsWith("mapcfg_")) {
                        a = m60505b(StringUtil.removeSuffix(str) + "@2x.png");
                    }
                    if (a == null) {
                        a = m60505b(str);
                    } else if (str.contains("poi_icon_indoor")) {
                        a = C24388ht.m37841a(a, ((float) ((int) (this.f15432b * ((float) a.getHeight())))) / ((float) a.getHeight()));
                    } else {
                        a = C24388ht.m37841a(a, this.f15432b);
                    }
                } catch (OutOfMemoryError e) {
                }
            }
            AppMethodBeat.m2505o(100034);
        }
        return a;
    }

    /* renamed from: a */
    public String mo57765a(GeoPoint geoPoint) {
        return null;
    }

    /* renamed from: b */
    private Bitmap m60505b(String str) {
        AppMethodBeat.m2504i(100035);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(100035);
            return null;
        }
        Closeable b = C31015v.m49804b(C46765r.m88663a(this.f15431a).mo75316b(this.f15433c) + str);
        if (b == null) {
            b = C31015v.m49804b(C46765r.m88663a(this.f15431a).mo75318c(this.f15433c) + str);
        }
        if (b == null) {
            b = C31015v.m49804b(C46765r.m88663a(this.f15431a).mo75321e() + str);
        }
        if (b == null) {
            if (C46766t.m88676a() != null) {
                b = C46766t.m88679b(this.f15431a, C46766t.m88676a() + str);
            } else if (C46766t.m88680b() != null) {
                b = C31015v.m49804b(C46766t.m88680b() + str);
            }
        }
        if (b == null) {
            b = C46766t.m88674a(this.f15431a, str);
        }
        if (b == null) {
            b = C46766t.m88679b(this.f15431a, str);
        }
        if (b == null) {
            AppMethodBeat.m2505o(100035);
            return null;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(b);
        C31015v.m49801a(b);
        AppMethodBeat.m2505o(100035);
        return decodeStream;
    }
}
