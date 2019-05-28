package com.tencent.p177mm.plugin.fav.p410ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavDetailTitleView */
public class FavDetailTitleView extends LinearLayout {
    private ImageView ejo;
    private TextView gnB;

    public FavDetailTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(74671);
        super.onFinishInflate();
        this.ejo = (ImageView) findViewById(2131821183);
        this.gnB = (TextView) findViewById(2131821185);
        AppMethodBeat.m2505o(74671);
    }
}
