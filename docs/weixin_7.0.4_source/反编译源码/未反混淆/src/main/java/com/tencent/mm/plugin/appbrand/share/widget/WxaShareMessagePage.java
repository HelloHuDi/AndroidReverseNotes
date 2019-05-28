package com.tencent.mm.plugin.appbrand.share.widget;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.modelappbrand.i.a;
import com.tencent.mm.modelappbrand.i.b;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.r.n;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public class WxaShareMessagePage extends LinearLayout implements i {
    public ImageView hYX;
    TextView iDT;
    public ImageView iDU;
    IPCDynamicPageView iDV;
    ThreeDotsLoadingView iDW;
    public ImageView iDX;
    public TextView iDY;
    b iDZ;
    public boolean iEa;
    public View qQ;

    public WxaShareMessagePage(Context context) {
        super(context);
        AppMethodBeat.i(132757);
        init(context);
        AppMethodBeat.o(132757);
    }

    public WxaShareMessagePage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(132758);
        init(context);
        AppMethodBeat.o(132758);
    }

    public WxaShareMessagePage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(132759);
        init(context);
        AppMethodBeat.o(132759);
    }

    private void init(Context context) {
        AppMethodBeat.i(132760);
        View inflate = View.inflate(context, R.layout.b8a, this);
        this.qQ = inflate.findViewById(R.id.fm0);
        this.hYX = (ImageView) inflate.findViewById(R.id.a82);
        this.iDU = (ImageView) inflate.findViewById(R.id.ape);
        this.iDV = (IPCDynamicPageView) inflate.findViewById(R.id.fm1);
        this.iDT = (TextView) inflate.findViewById(R.id.qm);
        this.iDW = (ThreeDotsLoadingView) inflate.findViewById(R.id.ue);
        View inflate2 = LayoutInflater.from(context).inflate(R.layout.a9n, (ViewGroup) inflate, false);
        this.iDX = (ImageView) inflate2.findViewById(R.id.coy);
        this.iDY = (TextView) inflate2.findViewById(R.id.coz);
        ((ViewGroup) inflate.findViewById(R.id.nc)).addView(inflate2);
        setGravity(17);
        AppMethodBeat.o(132760);
    }

    public void setOnLoadImageResult(b bVar) {
        this.iDZ = bVar;
    }

    public final void abU() {
    }

    public final void x(Bitmap bitmap) {
        AppMethodBeat.i(132761);
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
            this.iDZ.kQ(0);
        }
        AppMethodBeat.o(132761);
    }

    public final void mr() {
        AppMethodBeat.i(132762);
        this.iDW.setVisibility(4);
        this.iDW.dKT();
        this.hYX.setImageBitmap(null);
        this.iDU.setVisibility(0);
        if (this.iDZ != null) {
            this.iDZ.kQ(1);
        }
        AppMethodBeat.o(132762);
    }

    public final String wP() {
        AppMethodBeat.i(132763);
        String bE = n.bE(this);
        AppMethodBeat.o(132763);
        return bE;
    }

    public void setImageUrl(String str) {
        AppMethodBeat.i(132764);
        this.iDW.setVisibility(0);
        this.iDW.dKS();
        this.iDU.setVisibility(4);
        this.hYX.setVisibility(0);
        if (this.iEa) {
            com.tencent.mm.modelappbrand.a.b.abR().a((i) this, str, null, ((com.tencent.mm.modelappbrand.i) g.K(com.tencent.mm.modelappbrand.i.class)).a(112, 90, a.DECODE_TYPE_ORIGIN));
            AppMethodBeat.o(132764);
            return;
        }
        com.tencent.mm.modelappbrand.a.b.abR().a((i) this, str, null, ((com.tencent.mm.modelappbrand.i) g.K(com.tencent.mm.modelappbrand.i.class)).cq(112, 90));
        AppMethodBeat.o(132764);
    }

    public void setImageData(Bitmap bitmap) {
        AppMethodBeat.i(132765);
        this.hYX.setVisibility(0);
        this.iDW.setVisibility(4);
        this.iDU.setVisibility(4);
        if (bitmap == null || bitmap.isRecycled()) {
            this.hYX.setImageBitmap(null);
            AppMethodBeat.o(132765);
            return;
        }
        this.hYX.setImageBitmap(((com.tencent.mm.modelappbrand.i) g.K(com.tencent.mm.modelappbrand.i.class)).abB().y(bitmap));
        AppMethodBeat.o(132765);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(132766);
        this.iDT.setText(str);
        AppMethodBeat.o(132766);
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
        AppMethodBeat.i(132767);
        int qb = com.tencent.mm.plugin.appbrand.r.g.qb(224);
        AppMethodBeat.o(132767);
        return qb;
    }

    public int getWidgetHeight() {
        AppMethodBeat.i(132768);
        int qb = com.tencent.mm.plugin.appbrand.r.g.qb(180);
        AppMethodBeat.o(132768);
        return qb;
    }
}
