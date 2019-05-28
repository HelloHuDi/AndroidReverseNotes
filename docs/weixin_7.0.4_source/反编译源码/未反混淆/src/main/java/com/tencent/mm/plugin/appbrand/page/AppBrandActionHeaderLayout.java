package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;

public class AppBrandActionHeaderLayout extends LinearLayout {
    private LinearLayout iqp;
    private HorizontalScrollView iqq;
    private AppBrandActionSingleHeaderView iqr;
    private AppBrandActionMultipleHeaderView iqs;
    private AppBrandActionMultipleHeaderView iqt;
    private AppBrandActionMultipleHeaderView iqu;
    private AppBrandActionMultipleHeaderView iqv;
    private TextView iqw;
    private int iqx = 1;
    private int iqy = 2;
    private String mAppId;
    private Context mContext;

    public AppBrandActionHeaderLayout(Context context) {
        super(context);
        AppMethodBeat.i(132328);
        cA(context);
        AppMethodBeat.o(132328);
    }

    public AppBrandActionHeaderLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(132329);
        cA(context);
        AppMethodBeat.o(132329);
    }

    @TargetApi(11)
    public AppBrandActionHeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(132330);
        cA(context);
        AppMethodBeat.o(132330);
    }

    private void cA(Context context) {
        AppMethodBeat.i(132331);
        this.mContext = context;
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.e8, this);
        this.iqp = (LinearLayout) findViewById(R.id.y4);
        this.iqq = (HorizontalScrollView) findViewById(R.id.y6);
        this.iqr = (AppBrandActionSingleHeaderView) findViewById(R.id.y5);
        this.iqs = (AppBrandActionMultipleHeaderView) findViewById(R.id.y8);
        this.iqt = (AppBrandActionMultipleHeaderView) findViewById(R.id.y9);
        this.iqu = (AppBrandActionMultipleHeaderView) findViewById(R.id.y_);
        this.iqv = (AppBrandActionMultipleHeaderView) findViewById(R.id.ya);
        this.iqw = (TextView) findViewById(R.id.yb);
        this.iqs.setVisibility(8);
        this.iqt.setVisibility(8);
        this.iqu.setVisibility(8);
        this.iqv.setVisibility(8);
        this.iqw.setVisibility(8);
        AppMethodBeat.o(132331);
    }

    public final void cI(String str, String str2) {
        AppMethodBeat.i(132332);
        aIY();
        this.iqr.setImageDrawable(a.abQ());
        b.abR().a(this.iqr.getImageView(), str, null, f.fqH);
        this.iqr.setTextViewText(str2);
        AppMethodBeat.o(132332);
    }

    private void aIY() {
        AppMethodBeat.i(132333);
        this.iqp.setVisibility(0);
        this.iqq.setVisibility(8);
        AppMethodBeat.o(132333);
    }

    public void setActionHeaderStyle(boolean z) {
        AppMethodBeat.i(132334);
        if (z) {
            this.iqr.setTextViewTextColor(this.mContext.getResources().getColor(R.color.a6a));
            this.iqs.setTextViewTextColor(this.mContext.getResources().getColor(R.color.a6a));
            this.iqt.setTextViewTextColor(this.mContext.getResources().getColor(R.color.a6a));
            this.iqu.setTextViewTextColor(this.mContext.getResources().getColor(R.color.a6a));
            this.iqv.setTextViewTextColor(this.mContext.getResources().getColor(R.color.a6a));
            this.iqw.setTextColor(this.mContext.getResources().getColor(R.color.a6a));
            AppMethodBeat.o(132334);
            return;
        }
        this.iqr.setTextViewTextColor(this.mContext.getResources().getColor(R.color.he));
        this.iqs.setTextViewTextColor(this.mContext.getResources().getColor(R.color.he));
        this.iqt.setTextViewTextColor(this.mContext.getResources().getColor(R.color.he));
        this.iqu.setTextViewTextColor(this.mContext.getResources().getColor(R.color.he));
        this.iqv.setTextViewTextColor(this.mContext.getResources().getColor(R.color.he));
        this.iqw.setTextColor(this.mContext.getResources().getColor(R.color.he));
        AppMethodBeat.o(132334);
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setStatusDescription(CharSequence charSequence) {
        AppMethodBeat.i(132335);
        this.iqw.setText(charSequence);
        this.iqw.setVisibility(0);
        this.iqp.setVisibility(8);
        this.iqq.setVisibility(8);
        AppMethodBeat.o(132335);
    }
}
