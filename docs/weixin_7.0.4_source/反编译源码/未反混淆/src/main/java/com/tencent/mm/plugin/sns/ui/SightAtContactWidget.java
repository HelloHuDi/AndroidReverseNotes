package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.R;

public class SightAtContactWidget extends AtContactWidget {
    @TargetApi(11)
    public SightAtContactWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SightAtContactWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutResource() {
        return R.layout.at2;
    }

    /* Access modifiers changed, original: protected */
    public int getWithDrawableId() {
        return R.raw.sight_icon_mention;
    }

    /* Access modifiers changed, original: protected */
    public int getWithEmptyDrawableId() {
        return R.raw.sight_icon_mention;
    }
}
