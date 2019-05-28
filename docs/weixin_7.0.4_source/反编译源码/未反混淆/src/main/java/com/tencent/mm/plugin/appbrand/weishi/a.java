package com.tencent.mm.plugin.appbrand.weishi;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.q;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.precondition.d;
import com.tencent.mm.plugin.appbrand.launching.precondition.g;
import com.tencent.mm.plugin.appbrand.ui.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a extends ContextWrapper implements g {
    private c<q> hAT = new c<q>() {
        {
            AppMethodBeat.i(133609);
            this.xxI = q.class.getName().hashCode();
            AppMethodBeat.o(133609);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(133610);
            q qVar = (q) bVar;
            if (!(qVar == null || qVar.csA == null)) {
                String str = qVar.csA.csB;
                if (!bo.isNullOrNil(str) && str.equalsIgnoreCase("wxfe02ecfe70800f46")) {
                    ab.i("MicroMsg.AppBrandThumbFromMMProxyUI", "appbrand weishi ui close, close launch proxy ui");
                    a.this.finish();
                }
            }
            AppMethodBeat.o(133610);
            return false;
        }
    };
    private int huR = 0;
    private ImageView iTN;

    public a(AppBrandLaunchProxyUI appBrandLaunchProxyUI) {
        super(appBrandLaunchProxyUI);
        AppMethodBeat.i(133613);
        AppMethodBeat.o(133613);
    }

    private void cV(String str, final String str2) {
        AppMethodBeat.i(133616);
        ab.i("MicroMsg.AppBrandThumbFromMMProxyUI", "loadThumbImage:%s", str);
        com.tencent.mm.modelappbrand.a.b.abR().a(new i() {
            public final void abU() {
            }

            public final void x(Bitmap bitmap) {
                AppMethodBeat.i(133611);
                ab.i("MicroMsg.AppBrandThumbFromMMProxyUI", "proxy thumb loaded");
                a.a(a.this, bitmap);
                AppMethodBeat.o(133611);
            }

            public final void mr() {
                AppMethodBeat.i(133612);
                ab.e("MicroMsg.AppBrandThumbFromMMProxyUI", "proxy thumb loaded fail");
                if (str2 != null) {
                    a.a(a.this, str2);
                }
                AppMethodBeat.o(133612);
            }

            public final String wP() {
                return "AppBrandThumbFromMMProxyUI#THUMB";
            }
        }, str, null, null);
        AppMethodBeat.o(133616);
    }

    public final boolean aHO() {
        return false;
    }

    public final void onResume() {
        AppMethodBeat.i(133617);
        this.huR++;
        ab.i("MicroMsg.AppBrandThumbFromMMProxyUI", "onResume, resume count:%d", Integer.valueOf(this.huR));
        if (this.huR > 1) {
            ab.i("MicroMsg.AppBrandThumbFromMMProxyUI", "onResume, finish when resume again");
            finish();
        }
        AppMethodBeat.o(133617);
    }

    public final void onPause() {
        AppMethodBeat.i(133618);
        ab.i("MicroMsg.AppBrandThumbFromMMProxyUI", "onPause");
        AppMethodBeat.o(133618);
    }

    public final void onDestroy() {
        AppMethodBeat.i(133619);
        ab.i("MicroMsg.AppBrandThumbFromMMProxyUI", "onDestroy");
        AppMethodBeat.o(133619);
    }

    public final void finish() {
        AppMethodBeat.i(133614);
        if (!(((AppBrandLaunchProxyUI) super.getBaseContext()) == null || ((AppBrandLaunchProxyUI) super.getBaseContext()).isFinishing())) {
            ((AppBrandLaunchProxyUI) super.getBaseContext()).finish();
        }
        AppMethodBeat.o(133614);
    }

    public final void E(Intent intent) {
        AppMethodBeat.i(133615);
        n.c(((AppBrandLaunchProxyUI) super.getBaseContext()).getWindow(), true);
        View inflate = ((AppBrandLaunchProxyUI) super.getBaseContext()).getLayoutInflater().inflate(R.layout.cd, null);
        this.iTN = (ImageView) inflate.findViewById(R.id.ri);
        ((AppBrandLaunchProxyUI) super.getBaseContext()).setContentView(inflate);
        d Cn = d.Cn(intent.getStringExtra("extra_entry_token"));
        if (Cn == null) {
            finish();
            AppMethodBeat.o(133615);
            return;
        }
        Cn.setBaseContext((AppBrandLaunchProxyUI) super.getBaseContext());
        if (intent != null) {
            String stringExtra = intent.getStringExtra("extra_launch_thumb_url");
            String stringExtra2 = intent.getStringExtra("extra_launch_thumb_path");
            ab.i("MicroMsg.AppBrandThumbFromMMProxyUI", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", stringExtra, stringExtra2);
            if (!bo.isNullOrNil(stringExtra)) {
                cV(stringExtra, "file://".concat(String.valueOf(stringExtra2)));
            } else if (!bo.isNullOrNil(stringExtra2)) {
                cV("file://".concat(String.valueOf(stringExtra2)), null);
            }
        }
        com.tencent.mm.sdk.b.a.xxA.b(this.hAT);
        AppMethodBeat.o(133615);
    }

    public final /* bridge */ /* synthetic */ Context getBaseContext() {
        AppMethodBeat.i(133620);
        AppBrandLaunchProxyUI appBrandLaunchProxyUI = (AppBrandLaunchProxyUI) super.getBaseContext();
        AppMethodBeat.o(133620);
        return appBrandLaunchProxyUI;
    }
}
