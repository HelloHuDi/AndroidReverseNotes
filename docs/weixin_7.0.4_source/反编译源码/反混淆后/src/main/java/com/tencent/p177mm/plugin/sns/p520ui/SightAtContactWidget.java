package com.tencent.p177mm.plugin.sns.p520ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.p177mm.boot.C1319a.C1318a;

/* renamed from: com.tencent.mm.plugin.sns.ui.SightAtContactWidget */
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
        return 2130970681;
    }

    /* Access modifiers changed, original: protected */
    public int getWithDrawableId() {
        return C1318a.sight_icon_mention;
    }

    /* Access modifiers changed, original: protected */
    public int getWithEmptyDrawableId() {
        return C1318a.sight_icon_mention;
    }
}
