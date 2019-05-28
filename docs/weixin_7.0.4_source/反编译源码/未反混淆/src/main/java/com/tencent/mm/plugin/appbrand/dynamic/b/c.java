package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.canvas.e.a;
import com.tencent.rtmp.TXLiveConstants;

final class c implements e {
    c() {
    }

    public final Bitmap a(d dVar, String str) {
        AppMethodBeat.i(10772);
        Bitmap a = a(dVar, str, null);
        AppMethodBeat.o(10772);
        return a;
    }

    public final Bitmap a(d dVar, String str, a aVar) {
        AppMethodBeat.i(10773);
        Bitmap a = a(dVar, str, null, aVar);
        AppMethodBeat.o(10773);
        return a;
    }

    public final Bitmap a(d dVar, String str, Rect rect, a aVar) {
        Bitmap a;
        AppMethodBeat.i(10774);
        final String string = dVar.eIo.getString("id", "");
        if (str.startsWith("wxfile://")) {
            AppBrandLocalMediaObject bt = AppBrandLocalMediaObjectManager.bt(string, str);
            if (bt == null || TextUtils.isEmpty(bt.fnQ)) {
                AppMethodBeat.o(10774);
                return null;
            }
            String str2 = bt.fnQ;
            if (!str2.startsWith("file://")) {
                str2 = "file://".concat(String.valueOf(str2));
            }
            a = b.abR().a(str2, null);
        } else if (str.startsWith("https://") || str.startsWith("http://")) {
            Bitmap a2 = b.abR().a(str, null);
            if (a2 == null) {
                final a aVar2 = aVar;
                final d dVar2 = dVar;
                final String str3 = str;
                b.abR().a(new i() {
                    public final void abU() {
                    }

                    public final void x(Bitmap bitmap) {
                        AppMethodBeat.i(10770);
                        if (aVar2 == null || bitmap == null || bitmap.isRecycled()) {
                            AppMethodBeat.o(10770);
                            return;
                        }
                        aVar2.a(dVar2);
                        AppMethodBeat.o(10770);
                    }

                    public final void mr() {
                        AppMethodBeat.i(10771);
                        Bundle bundle = new Bundle();
                        bundle.putString("id", string);
                        bundle.putInt("widgetState", TXLiveConstants.PLAY_WARNING_RECONNECT);
                        f.a(com.tencent.mm.plugin.appbrand.dynamic.i.azC().zV(string), bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
                        AppMethodBeat.o(10771);
                    }

                    public final String wP() {
                        return "WxaWidgetIcon";
                    }
                }, str, null, null);
                a = a2;
            } else {
                a = a2;
            }
        } else {
            a = a.bM(string, str);
        }
        AppMethodBeat.o(10774);
        return a;
    }
}
