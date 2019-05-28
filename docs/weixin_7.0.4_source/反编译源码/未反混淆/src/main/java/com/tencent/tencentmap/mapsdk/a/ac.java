package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public abstract class ac extends FrameLayout {
    private aj a = null;

    public abstract int getMapViewType();

    public ac(Context context, ak akVar) {
        super(context);
        setClickable(true);
        if (!isInEditMode()) {
            a(context, akVar);
        }
    }

    private void a(Context context, ak akVar) {
        setBackgroundColor(Color.rgb(222, 215, 214));
        setEnabled(true);
        this.a = new aj(this, context, akVar);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a == null || this.a.c() == null || this.a.c().l() == null) {
            return super.onTouchEvent(motionEvent);
        }
        return this.a.c().l().a(motionEvent);
    }

    public final aj getMap() {
        return this.a;
    }

    public void a() {
        if (this.a != null) {
            this.a.p();
        }
    }

    public void b() {
        if (this.a != null) {
            this.a.q();
        }
    }

    public void c() {
        if (this.a != null) {
            this.a.s();
            this.a = null;
        }
    }

    public void d() {
        if (this.a != null) {
            this.a.o();
        }
    }

    public void e() {
        if (this.a != null) {
            this.a.r();
        }
    }

    public void f() {
        if (this.a != null) {
            this.a.n();
        }
    }

    public void setOnTop(boolean z) {
        if (this.a != null) {
            this.a.d(z);
        }
    }

    public int[] getMapPadding() {
        return new int[]{getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()};
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a.b().b().onSizeChanged(i, i2, i3, i4);
    }
}
