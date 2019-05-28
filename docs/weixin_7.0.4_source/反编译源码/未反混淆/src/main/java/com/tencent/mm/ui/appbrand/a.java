package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.v;
import java.io.UnsupportedEncodingException;

public final class a {
    public String appId = "";
    Context context;
    public WxaExposedParams iIa = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a().ayP();
    com.tencent.mm.ui.widget.a.d irC;
    public boolean jnK;
    public int scene;
    public String username;
    h yrj;
    public String yrk = "";

    public class f extends c {
        public f() {
            super();
        }

        public final View dzm() {
            AppMethodBeat.i(29939);
            View inflate = v.hu(a.this.context).inflate(R.layout.l4, null);
            ((TextView) inflate.findViewById(R.id.am1)).setText(a.this.context.getString(R.string.nu));
            AppMethodBeat.o(29939);
            return inflate;
        }

        public final void a(l lVar) {
            AppMethodBeat.i(29940);
            super.a(lVar);
            lVar.e(5, a.this.context.getString(R.string.ku));
            lVar.e(4, a.this.context.getString(R.string.ns));
            AppMethodBeat.o(29940);
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(29941);
            super.onMMMenuItemSelected(menuItem, i);
            AppMethodBeat.o(29941);
        }
    }

    public interface h {
        void a(l lVar);

        View dzm();

        void onMMMenuItemSelected(MenuItem menuItem, int i);
    }

    public class g extends c {
        public g() {
            super();
        }

        public final View dzm() {
            AppMethodBeat.i(29942);
            View inflate = v.hu(a.this.context).inflate(R.layout.l4, null);
            ((TextView) inflate.findViewById(R.id.am1)).setText(a.this.context.getString(R.string.nw));
            AppMethodBeat.o(29942);
            return inflate;
        }

        public final void a(l lVar) {
            AppMethodBeat.i(29943);
            super.a(lVar);
            lVar.e(6, a.this.context.getString(R.string.kv));
            lVar.e(4, a.this.context.getString(R.string.ns));
            AppMethodBeat.o(29943);
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(29944);
            super.onMMMenuItemSelected(menuItem, i);
            AppMethodBeat.o(29944);
        }
    }

    public class b extends c {
        public b() {
            super();
        }

        public final void a(l lVar) {
            AppMethodBeat.i(29930);
            super.a(lVar);
            lVar.e(3, a.this.context.getString(R.string.nx));
            lVar.e(8, a.this.context.getString(R.string.nt));
            lVar.e(7, a.a(a.this));
            AppMethodBeat.o(29930);
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(29931);
            super.onMMMenuItemSelected(menuItem, i);
            AppMethodBeat.o(29931);
        }
    }

    public class e extends c {
        public e() {
            super();
        }

        public final void a(l lVar) {
            AppMethodBeat.i(29937);
            super.a(lVar);
            lVar.e(3, a.this.context.getString(R.string.nx));
            lVar.e(8, a.this.context.getString(R.string.nt));
            lVar.e(7, a.a(a.this));
            AppMethodBeat.o(29937);
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(29938);
            super.onMMMenuItemSelected(menuItem, i);
            AppMethodBeat.o(29938);
        }
    }

    public class a extends c {
        public a() {
            super();
        }

        public final void a(l lVar) {
            AppMethodBeat.i(29928);
            super.a(lVar);
            lVar.e(2, a.this.context.getString(R.string.nv));
            lVar.e(8, a.this.context.getString(R.string.nt));
            lVar.e(7, a.a(a.this));
            AppMethodBeat.o(29928);
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(29929);
            super.onMMMenuItemSelected(menuItem, i);
            AppMethodBeat.o(29929);
        }
    }

    public class d extends c {
        public d() {
            super();
        }

        public final void a(l lVar) {
            AppMethodBeat.i(29935);
            super.a(lVar);
            lVar.e(2, a.this.context.getString(R.string.nv));
            lVar.e(8, a.this.context.getString(R.string.nt));
            lVar.e(7, a.a(a.this));
            AppMethodBeat.o(29935);
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(29936);
            super.onMMMenuItemSelected(menuItem, i);
            AppMethodBeat.o(29936);
        }
    }

    public class c implements h {
        public View dzm() {
            return null;
        }

        public void a(l lVar) {
        }

        /* JADX WARNING: Missing block: B:33:0x0147, code skipped:
            r0 = true;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMMMenuItemSelected(MenuItem menuItem, int i) {
            boolean z = false;
            AppMethodBeat.i(29934);
            a aVar;
            switch (menuItem.getItemId()) {
                case 2:
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(29932);
                            a.this.show(3);
                            AppMethodBeat.o(29932);
                        }
                    }, 100);
                    z = true;
                    break;
                case 3:
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(29933);
                            a.this.show(4);
                            AppMethodBeat.o(29933);
                        }
                    }, 100);
                    z = true;
                    break;
                case 4:
                    a.this.irC.cpE();
                    z = true;
                    break;
                case 5:
                    if (!bo.isNullOrNil(a.this.username)) {
                        b.k(a.this.context, a.this.username, true);
                        if (!a.this.jnK) {
                            a.this.he(a.this.scene, 4);
                            z = true;
                            break;
                        }
                        a.a(a.this, 6);
                        z = true;
                        break;
                    }
                case 6:
                    if (!bo.isNullOrNil(a.this.username)) {
                        b.k(a.this.context, a.this.username, false);
                        if (!a.this.jnK) {
                            a.this.he(a.this.scene, 2);
                            z = true;
                            break;
                        }
                        a.a(a.this, 1);
                        z = true;
                        break;
                    }
                case 7:
                    aVar = a.this;
                    Context context = a.this.context;
                    WxaExposedParams wxaExposedParams = a.this.iIa;
                    if (wxaExposedParams != null) {
                        ab.i("MicroMsg.AppBrandServiceActionSheet", "exportUrlParams : %s", wxaExposedParams.toString());
                        if (!bo.isNullOrNil(wxaExposedParams.username)) {
                            Intent intent = new Intent();
                            intent.putExtra("key_username", wxaExposedParams.username);
                            intent.putExtra("key_from_scene", 4);
                            intent.putExtra("key_scene_exposed_params", wxaExposedParams);
                            com.tencent.mm.bp.d.b(context, "appbrand", ".ui.AppBrandProfileUI", intent);
                            aVar.he(aVar.scene, 1);
                        }
                        z = true;
                        break;
                    }
                    ab.e("MicroMsg.AppBrandServiceActionSheet", "exportUrlParams is null");
                    z = true;
                    break;
                case 8:
                    aVar = a.this;
                    Intent intent2 = new Intent();
                    String aE = a.aE(aVar.iIa.appId, aVar.iIa.pageId, aVar.iIa.appId.equals(aVar.getAppId()) ? "" : aVar.getAppId());
                    ab.v("MicroMsg.AppBrandServiceActionSheet", "KRawUrl ".concat(String.valueOf(aE)));
                    intent2.putExtra("rawUrl", aE);
                    intent2.putExtra("forceHideShare", true);
                    com.tencent.mm.bp.d.b(aVar.context, "webview", ".ui.tools.WebViewUI", intent2);
                    z = true;
                    break;
            }
            if (z) {
                a.this.irC.cpE();
            }
            AppMethodBeat.o(29934);
        }
    }

    public a(Context context) {
        AppMethodBeat.i(29945);
        this.context = context;
        AppMethodBeat.o(29945);
    }

    public final void show(int i) {
        AppMethodBeat.i(29946);
        this.irC = new com.tencent.mm.ui.widget.a.d(this.context, 1, true);
        switch (i) {
            case 1:
                this.yrj = new a();
                break;
            case 2:
                this.yrj = new b();
                break;
            case 3:
                this.yrj = new f();
                break;
            case 4:
                this.yrj = new g();
                break;
            case 5:
                this.yrj = new d();
                break;
            case 6:
                this.yrj = new e();
                break;
            default:
                AppMethodBeat.o(29946);
                return;
        }
        if (this.yrj == null) {
            ab.e("MicroMsg.AppBrandServiceActionSheet", "resetTitleView, state is null");
        } else {
            View dzm = this.yrj.dzm();
            if (dzm != null) {
                this.irC.F(dzm, false);
            }
        }
        this.irC.rBl = new com.tencent.mm.ui.base.n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(29927);
                if (a.this.yrj == null) {
                    ab.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
                    AppMethodBeat.o(29927);
                    return;
                }
                a.this.yrj.a(lVar);
                AppMethodBeat.o(29927);
            }
        };
        this.irC.rBm = new com.tencent.mm.ui.base.n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(29926);
                if (a.this.yrj == null) {
                    ab.e("MicroMsg.AppBrandServiceActionSheet", "resetOnCreateMenuListener, state is null");
                    AppMethodBeat.o(29926);
                    return;
                }
                a.this.yrj.onMMMenuItemSelected(menuItem, i);
                AppMethodBeat.o(29926);
            }
        };
        this.irC.cpD();
        AppMethodBeat.o(29946);
    }

    /* Access modifiers changed, original: final */
    public final String getAppId() {
        AppMethodBeat.i(29947);
        if (bo.isNullOrNil(this.username)) {
            AppMethodBeat.o(29947);
            return null;
        }
        if (bo.isNullOrNil(this.appId)) {
            WxaAttributes zb = ((com.tencent.mm.plugin.appbrand.service.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(this.username);
            if (zb != null) {
                this.appId = zb.field_appId;
            }
        }
        String str = this.appId;
        AppMethodBeat.o(29947);
        return str;
    }

    /* Access modifiers changed, original: final */
    public final void he(int i, int i2) {
        AppMethodBeat.i(29948);
        if (bo.isNullOrNil(getAppId())) {
            AppMethodBeat.o(29948);
            return;
        }
        ab.d("MicroMsg.AppBrandServiceActionSheet", "stev report(%s), appId : %s, scene %s, sceneId %s, action %s", Integer.valueOf(13918), this.appId, Integer.valueOf(i), this.yrk, Integer.valueOf(i2));
        com.tencent.mm.plugin.report.service.h.pYm.e(13918, getAppId(), Integer.valueOf(i), this.yrk, Integer.valueOf(i2), Long.valueOf(bo.anT()));
        AppMethodBeat.o(29948);
    }

    public static String aE(String str, String str2, String str3) {
        AppMethodBeat.i(29949);
        String str4 = "";
        try {
            str4 = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&&business_appid=%s#wechat_redirect", new Object[]{q.encode(bo.nullAsNil(str), "UTF-8"), q.encode(bo.nullAsNil(str2), "UTF-8"), Integer.valueOf(10), q.encode(bo.nullAsNil(str3), "UTF-8")});
            AppMethodBeat.o(29949);
        } catch (UnsupportedEncodingException e) {
            ab.e("MicroMsg.AppBrandServiceActionSheet", "buildExposeUrl encode fail, invalid arguments");
            AppMethodBeat.o(29949);
        }
        return str4;
    }

    static /* synthetic */ void a(a aVar, int i) {
        AppMethodBeat.i(29950);
        if (!bo.isNullOrNil(aVar.getAppId())) {
            ab.d("MicroMsg.AppBrandServiceActionSheet", "stev report(%s), eventId : %s, appId %s, sceneId %s", Integer.valueOf(13798), Integer.valueOf(i), aVar.appId, aVar.yrk);
            com.tencent.mm.plugin.report.service.h.pYm.e(13798, Integer.valueOf(i), aVar.getAppId(), Integer.valueOf(0), aVar.yrk, Long.valueOf(bo.anT()));
        }
        AppMethodBeat.o(29950);
    }

    static /* synthetic */ String a(a aVar) {
        AppMethodBeat.i(29951);
        String str;
        if (aVar.iIa == null) {
            str = "";
            AppMethodBeat.o(29951);
            return str;
        }
        if (bo.isNullOrNil(aVar.iIa.nickname)) {
            if (!bo.isNullOrNil(aVar.iIa.username)) {
                aVar.iIa.nickname = b.aqK(aVar.iIa.username);
            }
            if (bo.isNullOrNil(aVar.iIa.nickname)) {
                aVar.iIa.nickname = "";
            }
        }
        str = aVar.context.getString(R.string.g2, new Object[]{aVar.iIa.nickname});
        AppMethodBeat.o(29951);
        return str;
    }
}
