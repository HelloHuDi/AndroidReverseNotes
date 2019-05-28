package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* renamed from: com.tencent.tencentmap.mapsdk.a.ac */
public abstract class C36456ac extends FrameLayout {
    /* renamed from: a */
    private C30982aj f15206a = null;

    public abstract int getMapViewType();

    public C36456ac(Context context, C44480ak c44480ak) {
        super(context);
        setClickable(true);
        if (!isInEditMode()) {
            m60229a(context, c44480ak);
        }
    }

    /* renamed from: a */
    private void m60229a(Context context, C44480ak c44480ak) {
        setBackgroundColor(Color.rgb(222, 215, 214));
        setEnabled(true);
        this.f15206a = new C30982aj(this, context, c44480ak);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f15206a == null || this.f15206a.mo50132c() == null || this.f15206a.mo50132c().mo41910l() == null) {
            return super.onTouchEvent(motionEvent);
        }
        return this.f15206a.mo50132c().mo41910l().mo50453a(motionEvent);
    }

    public final C30982aj getMap() {
        return this.f15206a;
    }

    /* renamed from: a */
    public void mo57646a() {
        if (this.f15206a != null) {
            this.f15206a.mo50153p();
        }
    }

    /* renamed from: b */
    public void mo57647b() {
        if (this.f15206a != null) {
            this.f15206a.mo50154q();
        }
    }

    /* renamed from: c */
    public void mo57648c() {
        if (this.f15206a != null) {
            this.f15206a.mo50156s();
            this.f15206a = null;
        }
    }

    /* renamed from: d */
    public void mo57649d() {
        if (this.f15206a != null) {
            this.f15206a.mo50152o();
        }
    }

    /* renamed from: e */
    public void mo57650e() {
        if (this.f15206a != null) {
            this.f15206a.mo50155r();
        }
    }

    /* renamed from: f */
    public void mo57651f() {
        if (this.f15206a != null) {
            this.f15206a.mo50151n();
        }
    }

    public void setOnTop(boolean z) {
        if (this.f15206a != null) {
            this.f15206a.mo50137d(z);
        }
    }

    public int[] getMapPadding() {
        return new int[]{getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()};
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f15206a.mo50127b().mo29105b().onSizeChanged(i, i2, i3, i4);
    }
}
