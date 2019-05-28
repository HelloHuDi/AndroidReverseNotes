package com.tencent.p177mm.plugin.card.widget;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.card.widget.a */
public abstract class C2788a implements C27634g {
    private final String TAG = "MicroMsg.CardWidgetCouponBase";
    protected OnClickListener gKK;
    protected TextView iPD;
    protected C42837b kaS;
    protected View ksf;
    protected ImageView ksg;
    protected Context mContext;
    protected LayoutInflater mInflater;

    public abstract void beJ();

    public abstract void beK();

    public C2788a(Context context) {
        this.mContext = context;
    }

    /* renamed from: i */
    public final void mo6893i(C42837b c42837b) {
        this.kaS = c42837b;
    }

    /* renamed from: hS */
    public final View mo6892hS() {
        if (this.kaS == null || this.kaS.aZV() == null) {
            C4990ab.m7412e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
            return null;
        }
        int i;
        this.mInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        LayoutInflater layoutInflater = this.mInflater;
        if (!this.kaS.aZE()) {
            if (this.kaS.aZF()) {
                i = 2130968992;
            } else if (this.kaS.aZD()) {
                i = 2130968954;
            } else if (this.kaS.aZG()) {
                i = 2130968916;
            } else if (this.kaS.aZH()) {
                i = 2130968945;
            }
            this.ksf = layoutInflater.inflate(i, null);
            this.ksg = (ImageView) this.ksf.findViewById(2131821978);
            this.iPD = (TextView) this.ksf.findViewById(2131821434);
            beJ();
            refreshView();
            return this.ksf;
        }
        i = 2130968909;
        this.ksf = layoutInflater.inflate(i, null);
        this.ksg = (ImageView) this.ksf.findViewById(2131821978);
        this.iPD = (TextView) this.ksf.findViewById(2131821434);
        beJ();
        refreshView();
        return this.ksf;
    }

    private void refreshView() {
        if (this.kaS == null || this.kaS.aZV() == null) {
            C4990ab.m7412e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
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

    /* renamed from: tq */
    public void mo6896tq(int i) {
    }

    /* renamed from: fL */
    public void mo6890fL(boolean z) {
    }

    /* renamed from: d */
    public final void mo6889d(C42837b c42837b) {
        this.kaS = c42837b;
        refreshView();
    }

    /* renamed from: a */
    public void mo6885a(ShapeDrawable shapeDrawable) {
    }

    /* renamed from: fM */
    public void mo6891fM(boolean z) {
    }

    /* renamed from: x */
    public void mo6897x(boolean z, boolean z2) {
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.gKK = onClickListener;
    }

    private void beL() {
        if (!C5046bo.isNullOrNil(this.kaS.aZV().kbV)) {
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10241vi);
            if (this.kaS.aZB() && this.kaS.aZE()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10239vg);
            } else if (this.kaS.aZB() && this.kaS.aZD()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10263w6);
            } else if (this.kaS.aZB() && this.kaS.aZF()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10273wh);
            } else if (this.kaS.aZH()) {
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize > 0) {
                C45778m.m84644a(this.ksg, this.kaS.aZV().kbV, dimensionPixelSize, (int) C25738R.drawable.bcm, true);
            }
        }
        if (!C5046bo.isNullOrNil(this.kaS.aZV().kdg)) {
            this.iPD.setText(this.kaS.aZV().kdg);
        }
    }
}
