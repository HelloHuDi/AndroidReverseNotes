package com.tencent.mm.plugin.appbrand.widget.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;

@SuppressLint({"AppCompatCustomView"})
class f extends ImageView implements e {
    private boolean ikj;

    public f(Context context) {
        super(context);
    }

    public void setInterceptEvent(boolean z) {
        this.ikj = z;
    }

    public boolean aCH() {
        return this.ikj;
    }
}
