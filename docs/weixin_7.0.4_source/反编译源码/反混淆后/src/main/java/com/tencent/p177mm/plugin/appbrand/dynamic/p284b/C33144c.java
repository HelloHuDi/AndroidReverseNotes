package com.tencent.p177mm.plugin.appbrand.dynamic.p284b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C9676i;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.C2103e;
import com.tencent.p177mm.plugin.appbrand.canvas.C2103e.C2104a;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10211f.C10213a;
import com.tencent.p177mm.plugin.appbrand.dynamic.C33164i;
import com.tencent.rtmp.TXLiveConstants;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.b.c */
final class C33144c implements C2103e {
    C33144c() {
    }

    /* renamed from: a */
    public final Bitmap mo5910a(C2102d c2102d, String str) {
        AppMethodBeat.m2504i(10772);
        Bitmap a = mo5912a(c2102d, str, null);
        AppMethodBeat.m2505o(10772);
        return a;
    }

    /* renamed from: a */
    public final Bitmap mo5912a(C2102d c2102d, String str, C2104a c2104a) {
        AppMethodBeat.m2504i(10773);
        Bitmap a = mo5911a(c2102d, str, null, c2104a);
        AppMethodBeat.m2505o(10773);
        return a;
    }

    /* renamed from: a */
    public final Bitmap mo5911a(C2102d c2102d, String str, Rect rect, C2104a c2104a) {
        Bitmap a;
        AppMethodBeat.m2504i(10774);
        final String string = c2102d.eIo.getString("id", "");
        if (str.startsWith("wxfile://")) {
            AppBrandLocalMediaObject bt = AppBrandLocalMediaObjectManager.m29647bt(string, str);
            if (bt == null || TextUtils.isEmpty(bt.fnQ)) {
                AppMethodBeat.m2505o(10774);
                return null;
            }
            String str2 = bt.fnQ;
            if (!str2.startsWith("file://")) {
                str2 = "file://".concat(String.valueOf(str2));
            }
            a = C37926b.abR().mo60681a(str2, null);
        } else if (str.startsWith("https://") || str.startsWith("http://")) {
            Bitmap a2 = C37926b.abR().mo60681a(str, null);
            if (a2 == null) {
                final C2104a c2104a2 = c2104a;
                final C2102d c2102d2 = c2102d;
                final String str3 = str;
                C37926b.abR().mo60686a(new C9676i() {
                    public final void abU() {
                    }

                    /* renamed from: x */
                    public final void mo6524x(Bitmap bitmap) {
                        AppMethodBeat.m2504i(10770);
                        if (c2104a2 == null || bitmap == null || bitmap.isRecycled()) {
                            AppMethodBeat.m2505o(10770);
                            return;
                        }
                        c2104a2.mo5913a(c2102d2);
                        AppMethodBeat.m2505o(10770);
                    }

                    /* renamed from: mr */
                    public final void mo6522mr() {
                        AppMethodBeat.m2504i(10771);
                        Bundle bundle = new Bundle();
                        bundle.putString("id", string);
                        bundle.putInt("widgetState", TXLiveConstants.PLAY_WARNING_RECONNECT);
                        C9549f.m17012a(C33164i.azC().mo53694zV(string), bundle, C10213a.class, null);
                        AppMethodBeat.m2505o(10771);
                    }

                    /* renamed from: wP */
                    public final String mo6523wP() {
                        return "WxaWidgetIcon";
                    }
                }, str, null, null);
                a = a2;
            } else {
                a = a2;
            }
        } else {
            a = C19170a.m29828bM(string, str);
        }
        AppMethodBeat.m2505o(10774);
        return a;
    }
}
