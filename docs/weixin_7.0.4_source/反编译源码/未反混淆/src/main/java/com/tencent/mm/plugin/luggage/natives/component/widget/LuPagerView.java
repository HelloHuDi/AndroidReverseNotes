package com.tencent.mm.plugin.luggage.natives.component.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.d;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LuPagerView extends ViewPager {
    private static final String TAG = "LuPagerView";
    private int mOrientation = 0;

    class a implements d {
        private a() {
        }

        /* synthetic */ a(LuPagerView luPagerView, byte b) {
            this();
        }

        public final void j(View view, float f) {
        }
    }

    class b implements d {
        private b() {
        }

        /* synthetic */ b(LuPagerView luPagerView, byte b) {
            this();
        }

        public final void j(View view, float f) {
            AppMethodBeat.i(116892);
            if (f >= -1.0f) {
                if (f <= 0.0f) {
                    view.setTranslationX(((float) view.getWidth()) * (-f));
                    view.setTranslationY(((float) view.getHeight()) * f);
                    AppMethodBeat.o(116892);
                    return;
                } else if (f <= 1.0f) {
                    view.setTranslationX(((float) view.getWidth()) * (-f));
                    view.setTranslationY(0.0f);
                }
            }
            AppMethodBeat.o(116892);
        }
    }

    public LuPagerView(Context context) {
        super(context);
        AppMethodBeat.i(116893);
        init();
        AppMethodBeat.o(116893);
    }

    public LuPagerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(116894);
        init();
        AppMethodBeat.o(116894);
    }

    public void init() {
        AppMethodBeat.i(116895);
        setOverScrollMode(2);
        AppMethodBeat.o(116895);
    }

    public void setPageOrientation(int i) {
        AppMethodBeat.i(116896);
        this.mOrientation = i;
        if (this.mOrientation == 1) {
            setPageTransformer(true, new b(this, (byte) 0));
            AppMethodBeat.o(116896);
            return;
        }
        setPageTransformer(true, new a(this, (byte) 0));
        AppMethodBeat.o(116896);
    }

    private MotionEvent swapXY(MotionEvent motionEvent) {
        AppMethodBeat.i(116897);
        if (this.mOrientation == 1) {
            float width = (float) getWidth();
            float height = (float) getHeight();
            motionEvent.setLocation(height * (motionEvent.getY() / height), width * (motionEvent.getX() / width));
        }
        AppMethodBeat.o(116897);
        return motionEvent;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(116898);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(swapXY(motionEvent));
        swapXY(motionEvent);
        AppMethodBeat.o(116898);
        return onInterceptTouchEvent;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(116899);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(116899);
        return dispatchTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(116900);
        switch (motionEvent.getAction()) {
            case 0:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case 1:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(swapXY(motionEvent));
        AppMethodBeat.o(116900);
        return onTouchEvent;
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(116901);
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            childAt.measure(i, MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i3) {
                i3 = measuredHeight;
            }
        }
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(i3, ErrorDialogData.SUPPRESSED));
        AppMethodBeat.o(116901);
    }
}
