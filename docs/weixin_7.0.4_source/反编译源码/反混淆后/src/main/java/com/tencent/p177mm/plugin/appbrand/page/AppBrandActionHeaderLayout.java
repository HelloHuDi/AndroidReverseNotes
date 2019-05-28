package com.tencent.p177mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;

/* renamed from: com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout */
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
        AppMethodBeat.m2504i(132328);
        m30414cA(context);
        AppMethodBeat.m2505o(132328);
    }

    public AppBrandActionHeaderLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(132329);
        m30414cA(context);
        AppMethodBeat.m2505o(132329);
    }

    @TargetApi(11)
    public AppBrandActionHeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(132330);
        m30414cA(context);
        AppMethodBeat.m2505o(132330);
    }

    /* renamed from: cA */
    private void m30414cA(Context context) {
        AppMethodBeat.m2504i(132331);
        this.mContext = context;
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(2130968758, this);
        this.iqp = (LinearLayout) findViewById(2131821462);
        this.iqq = (HorizontalScrollView) findViewById(2131821464);
        this.iqr = (AppBrandActionSingleHeaderView) findViewById(2131821463);
        this.iqs = (AppBrandActionMultipleHeaderView) findViewById(2131821466);
        this.iqt = (AppBrandActionMultipleHeaderView) findViewById(2131821467);
        this.iqu = (AppBrandActionMultipleHeaderView) findViewById(2131821468);
        this.iqv = (AppBrandActionMultipleHeaderView) findViewById(2131821469);
        this.iqw = (TextView) findViewById(2131821470);
        this.iqs.setVisibility(8);
        this.iqt.setVisibility(8);
        this.iqu.setVisibility(8);
        this.iqv.setVisibility(8);
        this.iqw.setVisibility(8);
        AppMethodBeat.m2505o(132331);
    }

    /* renamed from: cI */
    public final void mo34821cI(String str, String str2) {
        AppMethodBeat.m2504i(132332);
        aIY();
        this.iqr.setImageDrawable(C32804a.abQ());
        C37926b.abR().mo60683a(this.iqr.getImageView(), str, null, C42201f.fqH);
        this.iqr.setTextViewText(str2);
        AppMethodBeat.m2505o(132332);
    }

    private void aIY() {
        AppMethodBeat.m2504i(132333);
        this.iqp.setVisibility(0);
        this.iqq.setVisibility(8);
        AppMethodBeat.m2505o(132333);
    }

    public void setActionHeaderStyle(boolean z) {
        AppMethodBeat.m2504i(132334);
        if (z) {
            this.iqr.setTextViewTextColor(this.mContext.getResources().getColor(C25738R.color.a6a));
            this.iqs.setTextViewTextColor(this.mContext.getResources().getColor(C25738R.color.a6a));
            this.iqt.setTextViewTextColor(this.mContext.getResources().getColor(C25738R.color.a6a));
            this.iqu.setTextViewTextColor(this.mContext.getResources().getColor(C25738R.color.a6a));
            this.iqv.setTextViewTextColor(this.mContext.getResources().getColor(C25738R.color.a6a));
            this.iqw.setTextColor(this.mContext.getResources().getColor(C25738R.color.a6a));
            AppMethodBeat.m2505o(132334);
            return;
        }
        this.iqr.setTextViewTextColor(this.mContext.getResources().getColor(C25738R.color.f11791he));
        this.iqs.setTextViewTextColor(this.mContext.getResources().getColor(C25738R.color.f11791he));
        this.iqt.setTextViewTextColor(this.mContext.getResources().getColor(C25738R.color.f11791he));
        this.iqu.setTextViewTextColor(this.mContext.getResources().getColor(C25738R.color.f11791he));
        this.iqv.setTextViewTextColor(this.mContext.getResources().getColor(C25738R.color.f11791he));
        this.iqw.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11791he));
        AppMethodBeat.m2505o(132334);
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setStatusDescription(CharSequence charSequence) {
        AppMethodBeat.m2504i(132335);
        this.iqw.setText(charSequence);
        this.iqw.setVisibility(0);
        this.iqp.setVisibility(8);
        this.iqq.setVisibility(8);
        AppMethodBeat.m2505o(132335);
    }
}
