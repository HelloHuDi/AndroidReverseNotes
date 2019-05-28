package com.bumptech.glide.c.d.c;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.bumptech.glide.c.b.q;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.d.e.c;
import com.bumptech.glide.h.i;

public abstract class b<T extends Drawable> implements q, u<T> {
    protected final T drawable;

    public b(T t) {
        this.drawable = (Drawable) i.d(t, "Argument must not be null");
    }

    public void initialize() {
        if (this.drawable instanceof BitmapDrawable) {
            ((BitmapDrawable) this.drawable).getBitmap().prepareToDraw();
        } else if (this.drawable instanceof c) {
            ((c) this.drawable).ny().prepareToDraw();
        }
    }

    public final /* synthetic */ Object get() {
        ConstantState constantState = this.drawable.getConstantState();
        if (constantState == null) {
            return this.drawable;
        }
        return constantState.newDrawable();
    }
}
