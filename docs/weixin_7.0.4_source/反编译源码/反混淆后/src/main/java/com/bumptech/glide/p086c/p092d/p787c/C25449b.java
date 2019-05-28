package com.bumptech.glide.p086c.p092d.p787c;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p086c.p088b.C41547q;
import com.bumptech.glide.p086c.p092d.p788e.C37186c;
import com.bumptech.glide.p095h.C8561i;

/* renamed from: com.bumptech.glide.c.d.c.b */
public abstract class C25449b<T extends Drawable> implements C41547q, C17526u<T> {
    protected final T drawable;

    public C25449b(T t) {
        this.drawable = (Drawable) C8561i.m15217d(t, "Argument must not be null");
    }

    public void initialize() {
        if (this.drawable instanceof BitmapDrawable) {
            ((BitmapDrawable) this.drawable).getBitmap().prepareToDraw();
        } else if (this.drawable instanceof C37186c) {
            ((C37186c) this.drawable).mo59276ny().prepareToDraw();
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
