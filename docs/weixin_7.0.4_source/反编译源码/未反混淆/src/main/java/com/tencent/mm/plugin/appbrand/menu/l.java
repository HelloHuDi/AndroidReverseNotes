package com.tencent.mm.plugin.appbrand.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.smtt.sdk.WebView;
import java.util.Locale;

final class l extends a {
    l() {
        super(o.ShowPkgInfo.ordinal());
        AppMethodBeat.i(132248);
        AppMethodBeat.o(132248);
    }

    public final void a(Context context, u uVar, com.tencent.mm.ui.base.l lVar, String str) {
        AppMethodBeat.i(132249);
        if (bp.dpL()) {
            lVar.e(this.inj, context.getString(R.string.o5));
        }
        AppMethodBeat.o(132249);
    }

    @SuppressLint({"DefaultLocale", "RtlHardcoded"})
    public final void a(Context context, u uVar, String str, n nVar) {
        AppMethodBeat.i(132250);
        h ye = uVar.getRuntime().ye();
        StringBuilder stringBuilder = new StringBuilder("!PKG_INFO!\n");
        WxaPkgWrappingInfo avQ = WxaCommLibRuntimeReader.avQ();
        stringBuilder.append("\n[lib.src    ] ");
        if (avQ.gVw) {
            stringBuilder.append(an.avU() ? "local(force)" : ImagesContract.LOCAL);
        } else {
            stringBuilder.append(TencentLocation.NETWORK_PROVIDER);
        }
        stringBuilder.append("\n[lib.ver_cli] ").append(avQ.gVu);
        stringBuilder.append("\n[lib.ver_sdk] ").append(WxaCommLibRuntimeReader.avP().avl());
        if (avQ.gVt != 0) {
            String str2;
            StringBuilder append = stringBuilder.append("  ");
            if (avQ.gVt == 0) {
                str2 = "";
            } else {
                str2 = bo.mx(avQ.gVv);
            }
            append.append(str2);
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo = ye.hhd;
        stringBuilder.append(10);
        stringBuilder.append("\n[app.version] ").append(wxaPkgWrappingInfo.gVu);
        if (ye.hhd.gVt != 0) {
            stringBuilder.append("  ").append(bo.mx(wxaPkgWrappingInfo.gVv));
        }
        boolean z = !bo.ek(wxaPkgWrappingInfo.gVx);
        stringBuilder.append("\n[app.module ] ").append(String.valueOf(z));
        if (z) {
            stringBuilder.append(String.format(Locale.US, "  (%s)", new Object[]{((com.tencent.mm.plugin.appbrand.j.h) uVar.getRuntime().gNO).CE(uVar.getURL()).name}));
            if (((com.tencent.mm.plugin.appbrand.j.h) uVar.getRuntime().gNO).CE(uVar.getURL()).cta) {
                stringBuilder.append(" (independent)");
            }
        }
        if (!p.b(uVar)) {
            stringBuilder.append("\n[app.page.url] ").append(uVar.getURL());
        }
        stringBuilder.append(10);
        stringBuilder.append("\n[js_runtime] ").append(com.tencent.mm.plugin.appbrand.report.a.e(uVar.xT().aBx()));
        if (!p.b(uVar)) {
            stringBuilder.append("\n[webview] ").append(g.aLe());
        }
        p pVar = p.inf;
        p.a(stringBuilder, uVar.xT());
        stringBuilder.append(10);
        stringBuilder.append("\n[isolate_context] ").append(((s) uVar.xT()).aut());
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(WebView.NIGHT_MODE_COLOR);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.l5);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        com.tencent.mm.ui.base.h.a(context, null, textView, null).setCanceledOnTouchOutside(false);
        AppMethodBeat.o(132250);
    }
}
