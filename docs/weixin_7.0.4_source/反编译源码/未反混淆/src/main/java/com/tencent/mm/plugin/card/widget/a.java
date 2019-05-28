package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class a implements g {
    private final String TAG = "MicroMsg.CardWidgetCouponBase";
    protected OnClickListener gKK;
    protected TextView iPD;
    protected b kaS;
    protected View ksf;
    protected ImageView ksg;
    protected Context mContext;
    protected LayoutInflater mInflater;

    public abstract void beJ();

    public abstract void beK();

    public a(Context context) {
        this.mContext = context;
    }

    public final void i(b bVar) {
        this.kaS = bVar;
    }

    public final View hS() {
        if (this.kaS == null || this.kaS.aZV() == null) {
            ab.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
            return null;
        }
        int i;
        this.mInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        LayoutInflater layoutInflater = this.mInflater;
        if (!this.kaS.aZE()) {
            if (this.kaS.aZF()) {
                i = R.layout.kj;
            } else if (this.kaS.aZD()) {
                i = R.layout.ji;
            } else if (this.kaS.aZG()) {
                i = R.layout.ih;
            } else if (this.kaS.aZH()) {
                i = R.layout.j_;
            }
            this.ksf = layoutInflater.inflate(i, null);
            this.ksg = (ImageView) this.ksf.findViewById(R.id.aaq);
            this.iPD = (TextView) this.ksf.findViewById(R.id.xc);
            beJ();
            refreshView();
            return this.ksf;
        }
        i = R.layout.ia;
        this.ksf = layoutInflater.inflate(i, null);
        this.ksg = (ImageView) this.ksf.findViewById(R.id.aaq);
        this.iPD = (TextView) this.ksf.findViewById(R.id.xc);
        beJ();
        refreshView();
        return this.ksf;
    }

    private void refreshView() {
        if (this.kaS == null || this.kaS.aZV() == null) {
            ab.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
            return;
        }
        beL();
        beK();
    }

    /* Access modifiers changed, original: protected|final */
    public final View beI() {
        return this.ksf;
    }

    public final void release() {
        this.gKK = null;
        this.mContext = null;
    }

    public void tq(int i) {
    }

    public void fL(boolean z) {
    }

    public final void d(b bVar) {
        this.kaS = bVar;
        refreshView();
    }

    public void a(ShapeDrawable shapeDrawable) {
    }

    public void fM(boolean z) {
    }

    public void x(boolean z, boolean z2) {
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.gKK = onClickListener;
    }

    private void beL() {
        if (!bo.isNullOrNil(this.kaS.aZV().kbV)) {
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.vi);
            if (this.kaS.aZB() && this.kaS.aZE()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.vg);
            } else if (this.kaS.aZB() && this.kaS.aZD()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.w6);
            } else if (this.kaS.aZB() && this.kaS.aZF()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.wh);
            } else if (this.kaS.aZH()) {
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize > 0) {
                m.a(this.ksg, this.kaS.aZV().kbV, dimensionPixelSize, (int) R.drawable.bcm, true);
            }
        }
        if (!bo.isNullOrNil(this.kaS.aZV().kdg)) {
            this.iPD.setText(this.kaS.aZV().kdg);
        }
    }
}
