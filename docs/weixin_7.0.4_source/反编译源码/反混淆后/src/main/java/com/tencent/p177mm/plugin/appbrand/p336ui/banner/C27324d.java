package com.tencent.p177mm.plugin.appbrand.p336ui.banner;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C9676i;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.banner.d */
public final class C27324d extends C14933b implements OnClickListener, C10835f {
    private static boolean iKF = false;
    private TextView iKA;
    private ImageView iKB;
    private String iKC;
    private final Runnable iKD;
    private final C9676i iKE;
    private View iKz;

    public final int getLayoutId() {
        return 2130969012;
    }

    public final boolean aMN() {
        AppMethodBeat.m2504i(133275);
        if (!iKF) {
            ((C10834e) C1720g.m3528K(C10834e.class)).mo22394b(this);
            ((C10834e) C1720g.m3528K(C10834e.class)).aMK();
            ((C10834e) C1720g.m3528K(C10834e.class)).mo22391a(this);
            iKF = true;
        }
        BannerModel aMT = BannerModel.aMT();
        if (aMT == null || C5046bo.isNullOrNil(aMT.appId)) {
            setVisibility(8);
            AppMethodBeat.m2505o(133275);
            return false;
        }
        String str = aMT.appName;
        String str2 = aMT.iKV;
        String str3 = aMT.haO;
        if (!C5046bo.isNullOrNil(str2)) {
            str = str2;
        }
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(133275);
            return false;
        }
        setVisibility(0);
        if (this.iKA != null) {
            this.iKA.setText(str);
        }
        if (!C5046bo.isNullOrNil(str3)) {
            Bitmap bitmap = null;
            if (!C5046bo.isNullOrNil(this.iKC)) {
                bitmap = C37926b.abR().mo60687pB(this.iKC);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                this.iKC = C37926b.abR().mo60685a(this.iKE, str3, C42201f.fqH);
            } else {
                this.iKE.mo6524x(bitmap);
            }
        }
        AppMethodBeat.m2505o(133275);
        return true;
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(133276);
        if (this.iKz != null) {
            this.iKz.setVisibility(i);
        }
        AppMethodBeat.m2505o(133276);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(133277);
        if (this.iKz != null) {
            ((ViewGroup) this.iKz).removeAllViews();
            this.iKz.setVisibility(8);
        }
        this.iKz = null;
        this.iKA = null;
        this.iKB = null;
        ((C10834e) C1720g.m3528K(C10834e.class)).mo22394b(this);
        AppMethodBeat.m2505o(133277);
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(133278);
        BannerModel aMT = BannerModel.aMT();
        if (aMT == null) {
            AppMethodBeat.m2505o(133278);
            return;
        }
        String str = aMT.appId;
        int i = aMT.har;
        if (C5046bo.isNullOrNil(str)) {
            aMN();
            AppMethodBeat.m2505o(133278);
            return;
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1022;
        ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(view.getContext(), null, str, i, -1, null, appBrandStatObject);
        AppMethodBeat.m2505o(133278);
    }

    public static void aMO() {
        iKF = false;
    }

    /* renamed from: bg */
    public final void mo6073bg(String str, int i) {
        AppMethodBeat.m2504i(133279);
        C5004al.m7441d(this.iKD);
        AppMethodBeat.m2505o(133279);
    }
}
