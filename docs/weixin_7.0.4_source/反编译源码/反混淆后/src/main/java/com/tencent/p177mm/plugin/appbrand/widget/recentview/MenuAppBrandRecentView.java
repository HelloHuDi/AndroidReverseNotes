package com.tencent.p177mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.C2545b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C38620b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.C19910c;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.MenuAppBrandRecentView */
public class MenuAppBrandRecentView extends BaseAppBrandRecentView {
    private static final int jof = (C2545b.iWq - 1);
    private static final int jog = C2545b.iWq;
    private C38620b jas;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.MenuAppBrandRecentView$1 */
    class C386231 implements C38620b {
        C386231() {
        }

        /* renamed from: a */
        public final boolean mo35067a(View view, C42748a c42748a, float f, float f2) {
            boolean a;
            AppMethodBeat.m2504i(134382);
            if (MenuAppBrandRecentView.this.jas != null) {
                a = MenuAppBrandRecentView.this.jas.mo35067a(view, c42748a, f, f2);
            } else {
                a = false;
            }
            if (a) {
                AppMethodBeat.m2505o(134382);
                return true;
            }
            if (c42748a.type != 2) {
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI;
                ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(MenuAppBrandRecentView.this.getContext(), c42748a.iXW.username, null, c42748a.iXW.har, -1, null, appBrandStatObject);
            }
            AppMethodBeat.m2505o(134382);
            return false;
        }

        /* renamed from: b */
        public final boolean mo35068b(View view, C42748a c42748a, float f, float f2) {
            AppMethodBeat.m2504i(134383);
            boolean z = false;
            if (MenuAppBrandRecentView.this.jas != null) {
                z = MenuAppBrandRecentView.this.jas.mo35068b(view, c42748a, f, f2);
            }
            AppMethodBeat.m2505o(134383);
            return z;
        }
    }

    public MenuAppBrandRecentView(Context context) {
        super(context);
    }

    public MenuAppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getLayoutId() {
        return 2130968767;
    }

    /* Access modifiers changed, original: protected */
    public String getType() {
        AppMethodBeat.m2504i(134384);
        String simpleName = MenuAppBrandRecentView.class.getSimpleName();
        AppMethodBeat.m2505o(134384);
        return simpleName;
    }

    public void setOnItemClickListener(C38620b c38620b) {
        this.jas = c38620b;
    }

    /* renamed from: a */
    public final void mo61441a(C19910c c19910c, C42748a c42748a, int i) {
        AppMethodBeat.m2504i(134385);
        super.mo61441a(c19910c, c42748a, i);
        c19910c.gne.setTextColor(-1728053248);
        if (c42748a == null || c42748a.type != 2) {
            if (c42748a != null && c42748a.type == -1) {
                c19910c.iqT.setImageResource(C1318a.default_avatar);
            }
            AppMethodBeat.m2505o(134385);
            return;
        }
        c19910c.gne.setVisibility(0);
        c19910c.iYd.setVisibility(8);
        c19910c.gne.setText(C25738R.string.d3r);
        c19910c.iqT.setImageResource(C1318a.app_brand_capsule_multitasking_wechat);
        AppMethodBeat.m2505o(134385);
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
        AppMethodBeat.m2504i(134386);
        super.init(context);
        super.setOnItemClickListener(new C386231());
        AppMethodBeat.m2505o(134386);
    }
}
