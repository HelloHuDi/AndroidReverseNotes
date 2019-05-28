package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class SlowImageView extends ImageView {

    public interface a {
    }

    public SlowImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlowImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageLoader(a aVar) {
    }
}
