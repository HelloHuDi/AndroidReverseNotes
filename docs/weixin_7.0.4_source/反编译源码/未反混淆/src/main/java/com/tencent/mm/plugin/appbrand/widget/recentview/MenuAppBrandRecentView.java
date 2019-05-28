package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;
import com.tencent.ttpic.FilterEnum4Shaka;

public class MenuAppBrandRecentView extends BaseAppBrandRecentView {
    private static final int jof = (b.iWq - 1);
    private static final int jog = b.iWq;
    private AppBrandRecentView.b jas;

    public MenuAppBrandRecentView(Context context) {
        super(context);
    }

    public MenuAppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getLayoutId() {
        return R.layout.eg;
    }

    /* Access modifiers changed, original: protected */
    public String getType() {
        AppMethodBeat.i(134384);
        String simpleName = MenuAppBrandRecentView.class.getSimpleName();
        AppMethodBeat.o(134384);
        return simpleName;
    }

    public void setOnItemClickListener(AppBrandRecentView.b bVar) {
        this.jas = bVar;
    }

    public final void a(c cVar, a aVar, int i) {
        AppMethodBeat.i(134385);
        super.a(cVar, aVar, i);
        cVar.gne.setTextColor(-1728053248);
        if (aVar == null || aVar.type != 2) {
            if (aVar != null && aVar.type == -1) {
                cVar.iqT.setImageResource(R.raw.default_avatar);
            }
            AppMethodBeat.o(134385);
            return;
        }
        cVar.gne.setVisibility(0);
        cVar.iYd.setVisibility(8);
        cVar.gne.setText(R.string.d3r);
        cVar.iqT.setImageResource(R.raw.app_brand_capsule_multitasking_wechat);
        AppMethodBeat.o(134385);
    }

    /* Access modifiers changed, original: protected */
    public int getLoadCount() {
        return jog;
    }

    /* Access modifiers changed, original: protected */
    public int getShowCount() {
        return jof;
    }

    /* Access modifiers changed, original: protected|final */
    public final void init(Context context) {
        AppMethodBeat.i(134386);
        super.init(context);
        super.setOnItemClickListener(new AppBrandRecentView.b() {
            public final boolean a(View view, a aVar, float f, float f2) {
                boolean a;
                AppMethodBeat.i(134382);
                if (MenuAppBrandRecentView.this.jas != null) {
                    a = MenuAppBrandRecentView.this.jas.a(view, aVar, f, f2);
                } else {
                    a = false;
                }
                if (a) {
                    AppMethodBeat.o(134382);
                    return true;
                }
                if (aVar.type != 2) {
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI;
                    ((e) g.K(e.class)).a(MenuAppBrandRecentView.this.getContext(), aVar.iXW.username, null, aVar.iXW.har, -1, null, appBrandStatObject);
                }
                AppMethodBeat.o(134382);
                return false;
            }

            public final boolean b(View view, a aVar, float f, float f2) {
                AppMethodBeat.i(134383);
                boolean z = false;
                if (MenuAppBrandRecentView.this.jas != null) {
                    z = MenuAppBrandRecentView.this.jas.b(view, aVar, f, f2);
                }
                AppMethodBeat.o(134383);
                return z;
            }
        });
        AppMethodBeat.o(134386);
    }
}
