package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class FavDetailTitleView extends LinearLayout {
    private ImageView ejo;
    private TextView gnB;

    public FavDetailTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(74671);
        super.onFinishInflate();
        this.ejo = (ImageView) findViewById(R.id.qk);
        this.gnB = (TextView) findViewById(R.id.qm);
        AppMethodBeat.o(74671);
    }
}
