package com.tencent.p177mm.p612ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.p177mm.memory.p1206ui.QPictureView;

/* renamed from: com.tencent.mm.ui.widget.QFadeImageView */
public class QFadeImageView extends QPictureView {
    String key;
    long mSd;

    public QFadeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFadeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: D */
    public final void mo28267D(long j, String str) {
        this.mSd = j;
        this.key = str;
    }

    public String getImageKey() {
        return this.key;
    }

    public long getStartTimeMillis() {
        return this.mSd;
    }
}
