package com.tencent.p177mm.plugin.appbrand.weishi;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C9676i;
import com.tencent.p177mm.p230g.p231a.C42038q;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.p177mm.plugin.appbrand.launching.precondition.C19583g;
import com.tencent.p177mm.plugin.appbrand.launching.precondition.C42613d;
import com.tencent.p177mm.plugin.appbrand.p336ui.C42696n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.weishi.a */
public final class C27352a extends ContextWrapper implements C19583g {
    private C4884c<C42038q> hAT = new C273511();
    private int huR = 0;
    private ImageView iTN;

    /* renamed from: com.tencent.mm.plugin.appbrand.weishi.a$1 */
    class C273511 extends C4884c<C42038q> {
        C273511() {
            AppMethodBeat.m2504i(133609);
            this.xxI = C42038q.class.getName().hashCode();
            AppMethodBeat.m2505o(133609);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(133610);
            C42038q c42038q = (C42038q) c4883b;
            if (!(c42038q == null || c42038q.csA == null)) {
                String str = c42038q.csA.csB;
                if (!C5046bo.isNullOrNil(str) && str.equalsIgnoreCase("wxfe02ecfe70800f46")) {
                    C4990ab.m7416i("MicroMsg.AppBrandThumbFromMMProxyUI", "appbrand weishi ui close, close launch proxy ui");
                    C27352a.this.finish();
                }
            }
            AppMethodBeat.m2505o(133610);
            return false;
        }
    }

    public C27352a(AppBrandLaunchProxyUI appBrandLaunchProxyUI) {
        super(appBrandLaunchProxyUI);
        AppMethodBeat.m2504i(133613);
        AppMethodBeat.m2505o(133613);
    }

    /* renamed from: cV */
    private void m43420cV(String str, final String str2) {
        AppMethodBeat.m2504i(133616);
        C4990ab.m7417i("MicroMsg.AppBrandThumbFromMMProxyUI", "loadThumbImage:%s", str);
        C37926b.abR().mo60686a(new C9676i() {
            public final void abU() {
            }

            /* renamed from: x */
            public final void mo6524x(Bitmap bitmap) {
                AppMethodBeat.m2504i(133611);
                C4990ab.m7416i("MicroMsg.AppBrandThumbFromMMProxyUI", "proxy thumb loaded");
                C27352a.m43418a(C27352a.this, bitmap);
                AppMethodBeat.m2505o(133611);
            }

            /* renamed from: mr */
            public final void mo6522mr() {
                AppMethodBeat.m2504i(133612);
                C4990ab.m7412e("MicroMsg.AppBrandThumbFromMMProxyUI", "proxy thumb loaded fail");
                if (str2 != null) {
                    C27352a.m43419a(C27352a.this, str2);
                }
                AppMethodBeat.m2505o(133612);
            }

            /* renamed from: wP */
            public final String mo6523wP() {
                return "AppBrandThumbFromMMProxyUI#THUMB";
            }
        }, str, null, null);
        AppMethodBeat.m2505o(133616);
    }

    public final boolean aHO() {
        return false;
    }

    public final void onResume() {
        AppMethodBeat.m2504i(133617);
        this.huR++;
        C4990ab.m7417i("MicroMsg.AppBrandThumbFromMMProxyUI", "onResume, resume count:%d", Integer.valueOf(this.huR));
        if (this.huR > 1) {
            C4990ab.m7416i("MicroMsg.AppBrandThumbFromMMProxyUI", "onResume, finish when resume again");
            finish();
        }
        AppMethodBeat.m2505o(133617);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(133618);
        C4990ab.m7416i("MicroMsg.AppBrandThumbFromMMProxyUI", "onPause");
        AppMethodBeat.m2505o(133618);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(133619);
        C4990ab.m7416i("MicroMsg.AppBrandThumbFromMMProxyUI", "onDestroy");
        AppMethodBeat.m2505o(133619);
    }

    public final void finish() {
        AppMethodBeat.m2504i(133614);
        if (!(((AppBrandLaunchProxyUI) super.getBaseContext()) == null || ((AppBrandLaunchProxyUI) super.getBaseContext()).isFinishing())) {
            ((AppBrandLaunchProxyUI) super.getBaseContext()).finish();
        }
        AppMethodBeat.m2505o(133614);
    }

    /* renamed from: E */
    public final void mo34794E(Intent intent) {
        AppMethodBeat.m2504i(133615);
        C42696n.m75620c(((AppBrandLaunchProxyUI) super.getBaseContext()).getWindow(), true);
        View inflate = ((AppBrandLaunchProxyUI) super.getBaseContext()).getLayoutInflater().inflate(2130968690, null);
        this.iTN = (ImageView) inflate.findViewById(2131821218);
        ((AppBrandLaunchProxyUI) super.getBaseContext()).setContentView(inflate);
        C42613d Cn = C42613d.m75451Cn(intent.getStringExtra("extra_entry_token"));
        if (Cn == null) {
            finish();
            AppMethodBeat.m2505o(133615);
            return;
        }
        Cn.setBaseContext((AppBrandLaunchProxyUI) super.getBaseContext());
        if (intent != null) {
            String stringExtra = intent.getStringExtra("extra_launch_thumb_url");
            String stringExtra2 = intent.getStringExtra("extra_launch_thumb_path");
            C4990ab.m7417i("MicroMsg.AppBrandThumbFromMMProxyUI", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", stringExtra, stringExtra2);
            if (!C5046bo.isNullOrNil(stringExtra)) {
                m43420cV(stringExtra, "file://".concat(String.valueOf(stringExtra2)));
            } else if (!C5046bo.isNullOrNil(stringExtra2)) {
                m43420cV("file://".concat(String.valueOf(stringExtra2)), null);
            }
        }
        C4879a.xxA.mo10051b(this.hAT);
        AppMethodBeat.m2505o(133615);
    }

    public final /* bridge */ /* synthetic */ Context getBaseContext() {
        AppMethodBeat.m2504i(133620);
        AppBrandLaunchProxyUI appBrandLaunchProxyUI = (AppBrandLaunchProxyUI) super.getBaseContext();
        AppMethodBeat.m2505o(133620);
        return appBrandLaunchProxyUI;
    }
}
