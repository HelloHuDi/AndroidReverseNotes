package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.tencent.luggage.bridge.impl.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.d.a.c;
import com.tencent.mm.plugin.appbrand.d.b;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.s;
import java.io.InputStream;

public final class o extends a implements b {
    private final i gPI;

    public o(i iVar) {
        this.gPI = iVar;
    }

    public final String wP() {
        return "WxaPkgImageReader";
    }

    public final boolean match(String str) {
        AppMethodBeat.i(86997);
        if (str == null || !str.startsWith("wxapkg://")) {
            AppMethodBeat.o(86997);
            return false;
        }
        AppMethodBeat.o(86997);
        return true;
    }

    public final Bitmap b(String str, Rect rect, c cVar) {
        Bitmap bitmap = null;
        AppMethodBeat.i(86998);
        if (match(str)) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("appId");
            String queryParameter2 = parse.getQueryParameter("path");
            if (queryParameter == null || queryParameter.length() == 0 || queryParameter2 == null || queryParameter2.length() == 0) {
                AppMethodBeat.o(86998);
            } else {
                bitmap = s.j(this.gPI, Uri.decode(queryParameter2));
                if (rect != null) {
                    bitmap = new com.tencent.mm.plugin.appbrand.luggage.a.b(rect.left, rect.top, rect.width(), rect.height()).y(bitmap);
                }
                AppMethodBeat.o(86998);
            }
        } else {
            AppMethodBeat.o(86998);
        }
        return bitmap;
    }

    public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str) {
        AppMethodBeat.i(86999);
        if (cVar == null || str == null || str.length() == 0) {
            AppMethodBeat.o(86999);
            return false;
        } else if (str.startsWith("wxapkg://") || str.startsWith("http://") || str.startsWith("https://") || str.startsWith("wxfile://") || str.contains("://")) {
            AppMethodBeat.o(86999);
            return false;
        } else {
            AppMethodBeat.o(86999);
            return true;
        }
    }

    public final String b(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str) {
        AppMethodBeat.i(87000);
        if (a(cVar, str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("wxapkg://");
            stringBuilder.append("icon?");
            stringBuilder.append("appId=");
            stringBuilder.append(cVar.getAppId());
            stringBuilder.append("&");
            stringBuilder.append("path=");
            stringBuilder.append(Uri.encode(str));
            str = stringBuilder.toString();
            AppMethodBeat.o(87000);
            return str;
        }
        AppMethodBeat.o(87000);
        return str;
    }

    public final void a(String str, com.tencent.mm.plugin.appbrand.d.a.a aVar) {
        AppMethodBeat.i(87001);
        byte[] bArr = new byte[0];
        if (match(str)) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("appId");
            String queryParameter2 = parse.getQueryParameter("path");
            if (!(queryParameter == null || queryParameter.length() == 0 || queryParameter2 == null || queryParameter2.length() == 0)) {
                InputStream d = aw.d(this.gPI, Uri.decode(queryParameter2));
                bArr = com.tencent.luggage.g.i.k(d);
                com.tencent.luggage.g.i.b(d);
            }
        }
        if (aVar != null) {
            aVar.Q(bArr);
        }
        AppMethodBeat.o(87001);
    }
}
