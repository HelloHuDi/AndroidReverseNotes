package com.tencent.p177mm.loader.p1197h;

import android.graphics.Bitmap;

/* renamed from: com.tencent.mm.loader.h.e */
public final class C42161e<T> {
    private C42161e<?> eRU;
    private T value;

    public C42161e(T t) {
        this.value = t;
    }

    public final T getValue() {
        return this.value;
    }

    public final T value() {
        return this.value;
    }

    public final boolean isValid() {
        if (this.value == null) {
            return false;
        }
        if (this.value instanceof Bitmap) {
            return !((Bitmap) this.value).isRecycled();
        } else {
            return true;
        }
    }

    /* renamed from: Ue */
    public final C42161e mo67705Ue() {
        return this.eRU;
    }
}
