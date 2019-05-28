package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.memory.ui.QPictureView;

public class QFadeImageView extends QPictureView {
    String key;
    long mSd;

    public QFadeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFadeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void D(long j, String str) {
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
