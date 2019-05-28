package com.tencent.p177mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.page.AppBrandActionSingleHeaderView */
public class AppBrandActionSingleHeaderView extends LinearLayout {
    private ImageView cAw;
    private TextView exj;

    public AppBrandActionSingleHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(87015);
        init(context);
        AppMethodBeat.m2505o(87015);
    }

    @TargetApi(11)
    public AppBrandActionSingleHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(87016);
        init(context);
        AppMethodBeat.m2505o(87016);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(87017);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(2130968761, this);
        this.cAw = (ImageView) findViewById(2131821473);
        this.exj = (TextView) findViewById(2131821474);
        AppMethodBeat.m2505o(87017);
    }

    public ImageView getImageView() {
        return this.cAw;
    }

    public void setImageResource(int i) {
        AppMethodBeat.m2504i(87018);
        this.cAw.setImageResource(i);
        AppMethodBeat.m2505o(87018);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(87019);
        this.cAw.setImageDrawable(drawable);
        AppMethodBeat.m2505o(87019);
    }

    public void setTextViewText(String str) {
        AppMethodBeat.m2504i(87020);
        this.exj.setText(str);
        AppMethodBeat.m2505o(87020);
    }

    public void setTextViewTextColor(int i) {
        AppMethodBeat.m2504i(87021);
        this.exj.setTextColor(i);
        AppMethodBeat.m2505o(87021);
    }
}
