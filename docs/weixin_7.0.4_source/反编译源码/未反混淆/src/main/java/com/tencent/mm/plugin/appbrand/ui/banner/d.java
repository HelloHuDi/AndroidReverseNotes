package com.tencent.mm.plugin.appbrand.ui.banner;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class d extends b implements OnClickListener, f {
    private static boolean iKF = false;
    private TextView iKA;
    private ImageView iKB;
    private String iKC;
    private final Runnable iKD;
    private final i iKE;
    private View iKz;

    public final int getLayoutId() {
        return R.layout.l3;
    }

    public final boolean aMN() {
        AppMethodBeat.i(133275);
        if (!iKF) {
            ((e) g.K(e.class)).b(this);
            ((e) g.K(e.class)).aMK();
            ((e) g.K(e.class)).a(this);
            iKF = true;
        }
        BannerModel aMT = BannerModel.aMT();
        if (aMT == null || bo.isNullOrNil(aMT.appId)) {
            setVisibility(8);
            AppMethodBeat.o(133275);
            return false;
        }
        String str = aMT.appName;
        String str2 = aMT.iKV;
        String str3 = aMT.haO;
        if (!bo.isNullOrNil(str2)) {
            str = str2;
        }
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(133275);
            return false;
        }
        setVisibility(0);
        if (this.iKA != null) {
            this.iKA.setText(str);
        }
        if (!bo.isNullOrNil(str3)) {
            Bitmap bitmap = null;
            if (!bo.isNullOrNil(this.iKC)) {
                bitmap = com.tencent.mm.modelappbrand.a.b.abR().pB(this.iKC);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                this.iKC = com.tencent.mm.modelappbrand.a.b.abR().a(this.iKE, str3, f.fqH);
            } else {
                this.iKE.x(bitmap);
            }
        }
        AppMethodBeat.o(133275);
        return true;
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(133276);
        if (this.iKz != null) {
            this.iKz.setVisibility(i);
        }
        AppMethodBeat.o(133276);
    }

    public final void destroy() {
        AppMethodBeat.i(133277);
        if (this.iKz != null) {
            ((ViewGroup) this.iKz).removeAllViews();
            this.iKz.setVisibility(8);
        }
        this.iKz = null;
        this.iKA = null;
        this.iKB = null;
        ((e) g.K(e.class)).b(this);
        AppMethodBeat.o(133277);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(133278);
        BannerModel aMT = BannerModel.aMT();
        if (aMT == null) {
            AppMethodBeat.o(133278);
            return;
        }
        String str = aMT.appId;
        int i = aMT.har;
        if (bo.isNullOrNil(str)) {
            aMN();
            AppMethodBeat.o(133278);
            return;
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1022;
        ((e) g.K(e.class)).a(view.getContext(), null, str, i, -1, null, appBrandStatObject);
        AppMethodBeat.o(133278);
    }

    public static void aMO() {
        iKF = false;
    }

    public final void bg(String str, int i) {
        AppMethodBeat.i(133279);
        al.d(this.iKD);
        AppMethodBeat.o(133279);
    }
}
