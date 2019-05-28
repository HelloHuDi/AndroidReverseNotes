package com.tencent.p177mm.p612ui.appbrand;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.p177mm.plugin.appbrand.config.WxaExposedParams.C19154a;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.UnsupportedEncodingException;

/* renamed from: com.tencent.mm.ui.appbrand.a */
public final class C40661a {
    public String appId = "";
    Context context;
    public WxaExposedParams iIa = new C19154a().ayP();
    C36356d irC;
    public boolean jnK;
    public int scene;
    public String username;
    C23575h yrj;
    public String yrk = "";

    /* renamed from: com.tencent.mm.ui.appbrand.a$2 */
    class C52322 implements C36073c {
        C52322() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(29927);
            if (C40661a.this.yrj == null) {
                C4990ab.m7412e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
                AppMethodBeat.m2505o(29927);
                return;
            }
            C40661a.this.yrj.mo27569a(c44273l);
            AppMethodBeat.m2505o(29927);
        }
    }

    /* renamed from: com.tencent.mm.ui.appbrand.a$1 */
    class C154871 implements C5279d {
        C154871() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(29926);
            if (C40661a.this.yrj == null) {
                C4990ab.m7412e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
                AppMethodBeat.m2505o(29926);
                return;
            }
            C40661a.this.yrj.onMMMenuItemSelected(menuItem, i);
            AppMethodBeat.m2505o(29926);
        }
    }

    /* renamed from: com.tencent.mm.ui.appbrand.a$f */
    public class C15489f extends C40662c {
        public C15489f() {
            super();
        }

        public final View dzm() {
            AppMethodBeat.m2504i(29939);
            View inflate = C5616v.m8409hu(C40661a.this.context).inflate(2130969013, null);
            ((TextView) inflate.findViewById(2131822396)).setText(C40661a.this.context.getString(C25738R.string.f9050nu));
            AppMethodBeat.m2505o(29939);
            return inflate;
        }

        /* renamed from: a */
        public final void mo27569a(C44273l c44273l) {
            AppMethodBeat.m2504i(29940);
            super.mo27569a(c44273l);
            c44273l.mo70068e(5, C40661a.this.context.getString(C25738R.string.f8960ku));
            c44273l.mo70068e(4, C40661a.this.context.getString(C25738R.string.f9048ns));
            AppMethodBeat.m2505o(29940);
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(29941);
            super.onMMMenuItemSelected(menuItem, i);
            AppMethodBeat.m2505o(29941);
        }
    }

    /* renamed from: com.tencent.mm.ui.appbrand.a$h */
    public interface C23575h {
        /* renamed from: a */
        void mo27569a(C44273l c44273l);

        View dzm();

        void onMMMenuItemSelected(MenuItem menuItem, int i);
    }

    /* renamed from: com.tencent.mm.ui.appbrand.a$g */
    public class C30358g extends C40662c {
        public C30358g() {
            super();
        }

        public final View dzm() {
            AppMethodBeat.m2504i(29942);
            View inflate = C5616v.m8409hu(C40661a.this.context).inflate(2130969013, null);
            ((TextView) inflate.findViewById(2131822396)).setText(C40661a.this.context.getString(C25738R.string.f9052nw));
            AppMethodBeat.m2505o(29942);
            return inflate;
        }

        /* renamed from: a */
        public final void mo27569a(C44273l c44273l) {
            AppMethodBeat.m2504i(29943);
            super.mo27569a(c44273l);
            c44273l.mo70068e(6, C40661a.this.context.getString(C25738R.string.f8961kv));
            c44273l.mo70068e(4, C40661a.this.context.getString(C25738R.string.f9048ns));
            AppMethodBeat.m2505o(29943);
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(29944);
            super.onMMMenuItemSelected(menuItem, i);
            AppMethodBeat.m2505o(29944);
        }
    }

    /* renamed from: com.tencent.mm.ui.appbrand.a$b */
    public class C36037b extends C40662c {
        public C36037b() {
            super();
        }

        /* renamed from: a */
        public final void mo27569a(C44273l c44273l) {
            AppMethodBeat.m2504i(29930);
            super.mo27569a(c44273l);
            c44273l.mo70068e(3, C40661a.this.context.getString(C25738R.string.f9053nx));
            c44273l.mo70068e(8, C40661a.this.context.getString(C25738R.string.f9049nt));
            c44273l.mo70068e(7, C40661a.m70229a(C40661a.this));
            AppMethodBeat.m2505o(29930);
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(29931);
            super.onMMMenuItemSelected(menuItem, i);
            AppMethodBeat.m2505o(29931);
        }
    }

    /* renamed from: com.tencent.mm.ui.appbrand.a$e */
    public class C36038e extends C40662c {
        public C36038e() {
            super();
        }

        /* renamed from: a */
        public final void mo27569a(C44273l c44273l) {
            AppMethodBeat.m2504i(29937);
            super.mo27569a(c44273l);
            c44273l.mo70068e(3, C40661a.this.context.getString(C25738R.string.f9053nx));
            c44273l.mo70068e(8, C40661a.this.context.getString(C25738R.string.f9049nt));
            c44273l.mo70068e(7, C40661a.m70229a(C40661a.this));
            AppMethodBeat.m2505o(29937);
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(29938);
            super.onMMMenuItemSelected(menuItem, i);
            AppMethodBeat.m2505o(29938);
        }
    }

    /* renamed from: com.tencent.mm.ui.appbrand.a$a */
    public class C40659a extends C40662c {
        public C40659a() {
            super();
        }

        /* renamed from: a */
        public final void mo27569a(C44273l c44273l) {
            AppMethodBeat.m2504i(29928);
            super.mo27569a(c44273l);
            c44273l.mo70068e(2, C40661a.this.context.getString(C25738R.string.f9051nv));
            c44273l.mo70068e(8, C40661a.this.context.getString(C25738R.string.f9049nt));
            c44273l.mo70068e(7, C40661a.m70229a(C40661a.this));
            AppMethodBeat.m2505o(29928);
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(29929);
            super.onMMMenuItemSelected(menuItem, i);
            AppMethodBeat.m2505o(29929);
        }
    }

    /* renamed from: com.tencent.mm.ui.appbrand.a$d */
    public class C40660d extends C40662c {
        public C40660d() {
            super();
        }

        /* renamed from: a */
        public final void mo27569a(C44273l c44273l) {
            AppMethodBeat.m2504i(29935);
            super.mo27569a(c44273l);
            c44273l.mo70068e(2, C40661a.this.context.getString(C25738R.string.f9051nv));
            c44273l.mo70068e(8, C40661a.this.context.getString(C25738R.string.f9049nt));
            c44273l.mo70068e(7, C40661a.m70229a(C40661a.this));
            AppMethodBeat.m2505o(29935);
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(29936);
            super.onMMMenuItemSelected(menuItem, i);
            AppMethodBeat.m2505o(29936);
        }
    }

    /* renamed from: com.tencent.mm.ui.appbrand.a$c */
    public class C40662c implements C23575h {

        /* renamed from: com.tencent.mm.ui.appbrand.a$c$2 */
        class C154882 implements Runnable {
            C154882() {
            }

            public final void run() {
                AppMethodBeat.m2504i(29933);
                C40661a.this.show(4);
                AppMethodBeat.m2505o(29933);
            }
        }

        /* renamed from: com.tencent.mm.ui.appbrand.a$c$1 */
        class C303571 implements Runnable {
            C303571() {
            }

            public final void run() {
                AppMethodBeat.m2504i(29932);
                C40661a.this.show(3);
                AppMethodBeat.m2505o(29932);
            }
        }

        public View dzm() {
            return null;
        }

        /* renamed from: a */
        public void mo27569a(C44273l c44273l) {
        }

        /* JADX WARNING: Missing block: B:33:0x0147, code skipped:
            r0 = true;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMMMenuItemSelected(MenuItem menuItem, int i) {
            boolean z = false;
            AppMethodBeat.m2504i(29934);
            C40661a c40661a;
            switch (menuItem.getItemId()) {
                case 2:
                    C5004al.m7442n(new C303571(), 100);
                    z = true;
                    break;
                case 3:
                    C5004al.m7442n(new C154882(), 100);
                    z = true;
                    break;
                case 4:
                    C40661a.this.irC.cpE();
                    z = true;
                    break;
                case 5:
                    if (!C5046bo.isNullOrNil(C40661a.this.username)) {
                        C40663b.m70234k(C40661a.this.context, C40661a.this.username, true);
                        if (!C40661a.this.jnK) {
                            C40661a.this.mo64150he(C40661a.this.scene, 4);
                            z = true;
                            break;
                        }
                        C40661a.m70230a(C40661a.this, 6);
                        z = true;
                        break;
                    }
                case 6:
                    if (!C5046bo.isNullOrNil(C40661a.this.username)) {
                        C40663b.m70234k(C40661a.this.context, C40661a.this.username, false);
                        if (!C40661a.this.jnK) {
                            C40661a.this.mo64150he(C40661a.this.scene, 2);
                            z = true;
                            break;
                        }
                        C40661a.m70230a(C40661a.this, 1);
                        z = true;
                        break;
                    }
                case 7:
                    c40661a = C40661a.this;
                    Context context = C40661a.this.context;
                    WxaExposedParams wxaExposedParams = C40661a.this.iIa;
                    if (wxaExposedParams != null) {
                        C4990ab.m7417i("MicroMsg.AppBrandServiceActionSheet", "exportUrlParams : %s", wxaExposedParams.toString());
                        if (!C5046bo.isNullOrNil(wxaExposedParams.username)) {
                            Intent intent = new Intent();
                            intent.putExtra("key_username", wxaExposedParams.username);
                            intent.putExtra("key_from_scene", 4);
                            intent.putExtra("key_scene_exposed_params", wxaExposedParams);
                            C25985d.m41467b(context, "appbrand", ".ui.AppBrandProfileUI", intent);
                            c40661a.mo64150he(c40661a.scene, 1);
                        }
                        z = true;
                        break;
                    }
                    C4990ab.m7412e("MicroMsg.AppBrandServiceActionSheet", "exportUrlParams is null");
                    z = true;
                    break;
                case 8:
                    c40661a = C40661a.this;
                    Intent intent2 = new Intent();
                    String aE = C40661a.m70231aE(c40661a.iIa.appId, c40661a.iIa.pageId, c40661a.iIa.appId.equals(c40661a.getAppId()) ? "" : c40661a.getAppId());
                    C4990ab.m7418v("MicroMsg.AppBrandServiceActionSheet", "KRawUrl ".concat(String.valueOf(aE)));
                    intent2.putExtra("rawUrl", aE);
                    intent2.putExtra("forceHideShare", true);
                    C25985d.m41467b(c40661a.context, "webview", ".ui.tools.WebViewUI", intent2);
                    z = true;
                    break;
            }
            if (z) {
                C40661a.this.irC.cpE();
            }
            AppMethodBeat.m2505o(29934);
        }
    }

    public C40661a(Context context) {
        AppMethodBeat.m2504i(29945);
        this.context = context;
        AppMethodBeat.m2505o(29945);
    }

    public final void show(int i) {
        AppMethodBeat.m2504i(29946);
        this.irC = new C36356d(this.context, 1, true);
        switch (i) {
            case 1:
                this.yrj = new C40659a();
                break;
            case 2:
                this.yrj = new C36037b();
                break;
            case 3:
                this.yrj = new C15489f();
                break;
            case 4:
                this.yrj = new C30358g();
                break;
            case 5:
                this.yrj = new C40660d();
                break;
            case 6:
                this.yrj = new C36038e();
                break;
            default:
                AppMethodBeat.m2505o(29946);
                return;
        }
        if (this.yrj == null) {
            C4990ab.m7412e("MicroMsg.AppBrandServiceActionSheet", "resetTitleView, state is null");
        } else {
            View dzm = this.yrj.dzm();
            if (dzm != null) {
                this.irC.mo57234F(dzm, false);
            }
        }
        this.irC.rBl = new C52322();
        this.irC.rBm = new C154871();
        this.irC.cpD();
        AppMethodBeat.m2505o(29946);
    }

    /* Access modifiers changed, original: final */
    public final String getAppId() {
        AppMethodBeat.m2504i(29947);
        if (C5046bo.isNullOrNil(this.username)) {
            AppMethodBeat.m2505o(29947);
            return null;
        }
        if (C5046bo.isNullOrNil(this.appId)) {
            WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(this.username);
            if (zb != null) {
                this.appId = zb.field_appId;
            }
        }
        String str = this.appId;
        AppMethodBeat.m2505o(29947);
        return str;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: he */
    public final void mo64150he(int i, int i2) {
        AppMethodBeat.m2504i(29948);
        if (C5046bo.isNullOrNil(getAppId())) {
            AppMethodBeat.m2505o(29948);
            return;
        }
        C4990ab.m7411d("MicroMsg.AppBrandServiceActionSheet", "stev report(%s), appId : %s, scene %s, sceneId %s, action %s", Integer.valueOf(13918), this.appId, Integer.valueOf(i), this.yrk, Integer.valueOf(i2));
        C7060h.pYm.mo8381e(13918, getAppId(), Integer.valueOf(i), this.yrk, Integer.valueOf(i2), Long.valueOf(C5046bo.anT()));
        AppMethodBeat.m2505o(29948);
    }

    /* renamed from: aE */
    public static String m70231aE(String str, String str2, String str3) {
        AppMethodBeat.m2504i(29949);
        String str4 = "";
        try {
            str4 = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&&business_appid=%s#wechat_redirect", new Object[]{C18178q.encode(C5046bo.nullAsNil(str), "UTF-8"), C18178q.encode(C5046bo.nullAsNil(str2), "UTF-8"), Integer.valueOf(10), C18178q.encode(C5046bo.nullAsNil(str3), "UTF-8")});
            AppMethodBeat.m2505o(29949);
        } catch (UnsupportedEncodingException e) {
            C4990ab.m7412e("MicroMsg.AppBrandServiceActionSheet", "buildExposeUrl encode fail, invalid arguments");
            AppMethodBeat.m2505o(29949);
        }
        return str4;
    }

    /* renamed from: a */
    static /* synthetic */ void m70230a(C40661a c40661a, int i) {
        AppMethodBeat.m2504i(29950);
        if (!C5046bo.isNullOrNil(c40661a.getAppId())) {
            C4990ab.m7411d("MicroMsg.AppBrandServiceActionSheet", "stev report(%s), eventId : %s, appId %s, sceneId %s", Integer.valueOf(13798), Integer.valueOf(i), c40661a.appId, c40661a.yrk);
            C7060h.pYm.mo8381e(13798, Integer.valueOf(i), c40661a.getAppId(), Integer.valueOf(0), c40661a.yrk, Long.valueOf(C5046bo.anT()));
        }
        AppMethodBeat.m2505o(29950);
    }

    /* renamed from: a */
    static /* synthetic */ String m70229a(C40661a c40661a) {
        AppMethodBeat.m2504i(29951);
        String str;
        if (c40661a.iIa == null) {
            str = "";
            AppMethodBeat.m2505o(29951);
            return str;
        }
        if (C5046bo.isNullOrNil(c40661a.iIa.nickname)) {
            if (!C5046bo.isNullOrNil(c40661a.iIa.username)) {
                c40661a.iIa.nickname = C40663b.aqK(c40661a.iIa.username);
            }
            if (C5046bo.isNullOrNil(c40661a.iIa.nickname)) {
                c40661a.iIa.nickname = "";
            }
        }
        str = c40661a.context.getString(C25738R.string.f8824g2, new Object[]{c40661a.iIa.nickname});
        AppMethodBeat.m2505o(29951);
        return str;
    }
}
