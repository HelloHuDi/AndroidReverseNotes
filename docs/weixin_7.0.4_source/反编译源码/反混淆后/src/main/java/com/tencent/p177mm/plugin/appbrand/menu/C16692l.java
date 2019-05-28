package com.tencent.p177mm.plugin.appbrand.menu;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.C42641p;
import com.tencent.p177mm.plugin.appbrand.appcache.C38104an;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.menu.p909a.C10642a;
import com.tencent.p177mm.plugin.appbrand.p298j.C26910h;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.report.C42669a;
import com.tencent.p177mm.plugin.appbrand.report.C42671g;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.smtt.sdk.WebView;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.menu.l */
final class C16692l extends C10642a {
    C16692l() {
        super(C38449o.ShowPkgInfo.ordinal());
        AppMethodBeat.m2504i(132248);
        AppMethodBeat.m2505o(132248);
    }

    /* renamed from: a */
    public final void mo6300a(Context context, C44709u c44709u, C44273l c44273l, String str) {
        AppMethodBeat.m2504i(132249);
        if (C5047bp.dpL()) {
            c44273l.mo70068e(this.inj, context.getString(C25738R.string.f9061o5));
        }
        AppMethodBeat.m2505o(132249);
    }

    @SuppressLint({"DefaultLocale", "RtlHardcoded"})
    /* renamed from: a */
    public final void mo6301a(Context context, C44709u c44709u, String str, C42636n c42636n) {
        AppMethodBeat.m2504i(132250);
        C16597h ye = c44709u.getRuntime().mo15034ye();
        StringBuilder stringBuilder = new StringBuilder("!PKG_INFO!\n");
        WxaPkgWrappingInfo avQ = WxaCommLibRuntimeReader.avQ();
        stringBuilder.append("\n[lib.src    ] ");
        if (avQ.gVw) {
            stringBuilder.append(C38104an.avU() ? "local(force)" : ImagesContract.LOCAL);
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
                str2 = C5046bo.m7579mx(avQ.gVv);
            }
            append.append(str2);
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo = ye.hhd;
        stringBuilder.append(10);
        stringBuilder.append("\n[app.version] ").append(wxaPkgWrappingInfo.gVu);
        if (ye.hhd.gVt != 0) {
            stringBuilder.append("  ").append(C5046bo.m7579mx(wxaPkgWrappingInfo.gVv));
        }
        boolean z = !C5046bo.m7548ek(wxaPkgWrappingInfo.gVx);
        stringBuilder.append("\n[app.module ] ").append(String.valueOf(z));
        if (z) {
            stringBuilder.append(String.format(Locale.US, "  (%s)", new Object[]{((C26910h) c44709u.getRuntime().gNO).mo44655CE(c44709u.getURL()).name}));
            if (((C26910h) c44709u.getRuntime().gNO).mo44655CE(c44709u.getURL()).cta) {
                stringBuilder.append(" (independent)");
            }
        }
        if (!C42641p.m75510b(c44709u)) {
            stringBuilder.append("\n[app.page.url] ").append(c44709u.getURL());
        }
        stringBuilder.append(10);
        stringBuilder.append("\n[js_runtime] ").append(C42669a.m75573e(c44709u.mo44926xT().aBx()));
        if (!C42641p.m75510b(c44709u)) {
            stringBuilder.append("\n[webview] ").append(C42671g.aLe());
        }
        C45659p c45659p = C45659p.inf;
        C45659p.m84313a(stringBuilder, c44709u.mo44926xT());
        stringBuilder.append(10);
        stringBuilder.append("\n[isolate_context] ").append(((C19722s) c44709u.mo44926xT()).aut());
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(WebView.NIGHT_MODE_COLOR);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        C30379h.m48435a(context, null, textView, null).setCanceledOnTouchOutside(false);
        AppMethodBeat.m2505o(132250);
    }
}
