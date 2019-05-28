package com.tencent.p177mm.plugin.appbrand.widget.p915c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C26931e;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.tencent.mm.plugin.appbrand.widget.c.f */
class C33593f extends ImageView implements C26931e {
    private boolean ikj;

    public C33593f(Context context) {
        super(context);
    }

    public void setInterceptEvent(boolean z) {
        this.ikj = z;
    }

    public boolean aCH() {
        return this.ikj;
    }
}
