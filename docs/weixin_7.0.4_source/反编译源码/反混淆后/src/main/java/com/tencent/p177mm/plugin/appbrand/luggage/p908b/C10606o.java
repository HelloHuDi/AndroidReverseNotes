package com.tencent.p177mm.plugin.appbrand.luggage.p908b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.tencent.luggage.bridge.impl.p1588a.C41702a;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.luggage.p1227a.C27185b;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a.C19163a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a.C19164c;
import com.tencent.p177mm.plugin.appbrand.p1219d.C33139b;
import com.tencent.p177mm.plugin.appbrand.page.C38475s;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.b.o */
public final class C10606o extends C41702a implements C33139b {
    private final C6750i gPI;

    public C10606o(C6750i c6750i) {
        this.gPI = c6750i;
    }

    /* renamed from: wP */
    public final String mo22122wP() {
        return "WxaPkgImageReader";
    }

    public final boolean match(String str) {
        AppMethodBeat.m2504i(86997);
        if (str == null || !str.startsWith("wxapkg://")) {
            AppMethodBeat.m2505o(86997);
            return false;
        }
        AppMethodBeat.m2505o(86997);
        return true;
    }

    /* renamed from: b */
    public final Bitmap mo22119b(String str, Rect rect, C19164c c19164c) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(86998);
        if (match(str)) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("appId");
            String queryParameter2 = parse.getQueryParameter("path");
            if (queryParameter == null || queryParameter.length() == 0 || queryParameter2 == null || queryParameter2.length() == 0) {
                AppMethodBeat.m2505o(86998);
            } else {
                bitmap = C38475s.m65114j(this.gPI, Uri.decode(queryParameter2));
                if (rect != null) {
                    bitmap = new C27185b(rect.left, rect.top, rect.width(), rect.height()).mo22474y(bitmap);
                }
                AppMethodBeat.m2505o(86998);
            }
        } else {
            AppMethodBeat.m2505o(86998);
        }
        return bitmap;
    }

    /* renamed from: a */
    public final boolean mo22118a(C2241c c2241c, String str) {
        AppMethodBeat.m2504i(86999);
        if (c2241c == null || str == null || str.length() == 0) {
            AppMethodBeat.m2505o(86999);
            return false;
        } else if (str.startsWith("wxapkg://") || str.startsWith("http://") || str.startsWith("https://") || str.startsWith("wxfile://") || str.contains("://")) {
            AppMethodBeat.m2505o(86999);
            return false;
        } else {
            AppMethodBeat.m2505o(86999);
            return true;
        }
    }

    /* renamed from: b */
    public final String mo22120b(C2241c c2241c, String str) {
        AppMethodBeat.m2504i(87000);
        if (mo22118a(c2241c, str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("wxapkg://");
            stringBuilder.append("icon?");
            stringBuilder.append("appId=");
            stringBuilder.append(c2241c.getAppId());
            stringBuilder.append("&");
            stringBuilder.append("path=");
            stringBuilder.append(Uri.encode(str));
            str = stringBuilder.toString();
            AppMethodBeat.m2505o(87000);
            return str;
        }
        AppMethodBeat.m2505o(87000);
        return str;
    }

    /* renamed from: a */
    public final void mo22117a(String str, C19163a c19163a) {
        AppMethodBeat.m2504i(87001);
        byte[] bArr = new byte[0];
        if (match(str)) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("appId");
            String queryParameter2 = parse.getQueryParameter("path");
            if (!(queryParameter == null || queryParameter.length() == 0 || queryParameter2 == null || queryParameter2.length() == 0)) {
                InputStream d = C33082aw.m54073d(this.gPI, Uri.decode(queryParameter2));
                bArr = C32192i.m52510k(d);
                C32192i.m52507b(d);
            }
        }
        if (c19163a != null) {
            c19163a.mo34404Q(bArr);
        }
        AppMethodBeat.m2505o(87001);
    }
}
