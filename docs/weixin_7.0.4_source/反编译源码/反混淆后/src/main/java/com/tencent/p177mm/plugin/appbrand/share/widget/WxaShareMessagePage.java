package com.tencent.p177mm.plugin.appbrand.share.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C32809i;
import com.tencent.p177mm.modelappbrand.C32809i.C32807a;
import com.tencent.p177mm.modelappbrand.C32809i.C32808b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C9676i;
import com.tencent.p177mm.p190at.C32292p.C32293a;
import com.tencent.p177mm.p612ui.widget.ThreeDotsLoadingView;
import com.tencent.p177mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.p177mm.plugin.appbrand.p328r.C38496n;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage */
public class WxaShareMessagePage extends LinearLayout implements C9676i {
    public ImageView hYX;
    TextView iDT;
    public ImageView iDU;
    IPCDynamicPageView iDV;
    ThreeDotsLoadingView iDW;
    public ImageView iDX;
    public TextView iDY;
    C32808b iDZ;
    public boolean iEa;
    /* renamed from: qQ */
    public View f13680qQ;

    /* renamed from: com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage$1 */
    public class C272981 implements C32293a {
        /* renamed from: i */
        public final void mo11044i(String str, final Bitmap bitmap) {
            AppMethodBeat.m2504i(132756);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(132755);
                    WxaShareMessagePage.this.iDX.setImageBitmap(bitmap);
                    WxaShareMessagePage.this.iDU.setImageBitmap(bitmap);
                    AppMethodBeat.m2505o(132755);
                }
            });
            AppMethodBeat.m2505o(132756);
        }
    }

    public WxaShareMessagePage(Context context) {
        super(context);
        AppMethodBeat.m2504i(132757);
        init(context);
        AppMethodBeat.m2505o(132757);
    }

    public WxaShareMessagePage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(132758);
        init(context);
        AppMethodBeat.m2505o(132758);
    }

    public WxaShareMessagePage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(132759);
        init(context);
        AppMethodBeat.m2505o(132759);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(132760);
        View inflate = View.inflate(context, 2130971248, this);
        this.f13680qQ = inflate.findViewById(2131829238);
        this.hYX = (ImageView) inflate.findViewById(2131821842);
        this.iDU = (ImageView) inflate.findViewById(2131822521);
        this.iDV = (IPCDynamicPageView) inflate.findViewById(2131829239);
        this.iDT = (TextView) inflate.findViewById(2131821185);
        this.iDW = (ThreeDotsLoadingView) inflate.findViewById(2131821325);
        View inflate2 = LayoutInflater.from(context).inflate(2130969925, (ViewGroup) inflate, false);
        this.iDX = (ImageView) inflate2.findViewById(2131825240);
        this.iDY = (TextView) inflate2.findViewById(2131825241);
        ((ViewGroup) inflate.findViewById(2131821064)).addView(inflate2);
        setGravity(17);
        AppMethodBeat.m2505o(132760);
    }

    public void setOnLoadImageResult(C32808b c32808b) {
        this.iDZ = c32808b;
    }

    public final void abU() {
    }

    /* renamed from: x */
    public final void mo6524x(Bitmap bitmap) {
        AppMethodBeat.m2504i(132761);
        this.iDW.setVisibility(4);
        this.iDW.dKT();
        if (bitmap == null || bitmap.isRecycled()) {
            this.hYX.setImageBitmap(null);
            this.iDU.setVisibility(0);
        } else {
            this.hYX.setImageBitmap(bitmap);
            this.iDU.setVisibility(4);
        }
        if (this.iDZ != null) {
            this.iDZ.mo6398kQ(0);
        }
        AppMethodBeat.m2505o(132761);
    }

    /* renamed from: mr */
    public final void mo6522mr() {
        AppMethodBeat.m2504i(132762);
        this.iDW.setVisibility(4);
        this.iDW.dKT();
        this.hYX.setImageBitmap(null);
        this.iDU.setVisibility(0);
        if (this.iDZ != null) {
            this.iDZ.mo6398kQ(1);
        }
        AppMethodBeat.m2505o(132762);
    }

    /* renamed from: wP */
    public final String mo6523wP() {
        AppMethodBeat.m2504i(132763);
        String bE = C38496n.m65148bE(this);
        AppMethodBeat.m2505o(132763);
        return bE;
    }

    public void setImageUrl(String str) {
        AppMethodBeat.m2504i(132764);
        this.iDW.setVisibility(0);
        this.iDW.dKS();
        this.iDU.setVisibility(4);
        this.hYX.setVisibility(0);
        if (this.iEa) {
            C37926b.abR().mo60686a((C9676i) this, str, null, ((C32809i) C1720g.m3528K(C32809i.class)).mo22287a(112, 90, C32807a.DECODE_TYPE_ORIGIN));
            AppMethodBeat.m2505o(132764);
            return;
        }
        C37926b.abR().mo60686a((C9676i) this, str, null, ((C32809i) C1720g.m3528K(C32809i.class)).mo22292cq(112, 90));
        AppMethodBeat.m2505o(132764);
    }

    public void setImageData(Bitmap bitmap) {
        AppMethodBeat.m2504i(132765);
        this.hYX.setVisibility(0);
        this.iDW.setVisibility(4);
        this.iDU.setVisibility(4);
        if (bitmap == null || bitmap.isRecycled()) {
            this.hYX.setImageBitmap(null);
            AppMethodBeat.m2505o(132765);
            return;
        }
        this.hYX.setImageBitmap(((C32809i) C1720g.m3528K(C32809i.class)).abB().mo22474y(bitmap));
        AppMethodBeat.m2505o(132765);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(132766);
        this.iDT.setText(str);
        AppMethodBeat.m2505o(132766);
    }

    public ImageView getCoverImageView() {
        return this.hYX;
    }

    public ImageView getErrorImageView() {
        return this.iDU;
    }

    public IPCDynamicPageView getWidgetPageView() {
        return this.iDV;
    }

    public ThreeDotsLoadingView getLoadingView() {
        return this.iDW;
    }

    public int getWidgetWidth() {
        AppMethodBeat.m2504i(132767);
        int qb = C42668g.m75571qb(224);
        AppMethodBeat.m2505o(132767);
        return qb;
    }

    public int getWidgetHeight() {
        AppMethodBeat.m2504i(132768);
        int qb = C42668g.m75571qb(180);
        AppMethodBeat.m2505o(132768);
        return qb;
    }
}
