package com.tencent.p177mm.plugin.luggage.natives.component.widget;

import android.content.Context;
import android.support.p057v4.view.ViewPager;
import android.support.p057v4.view.ViewPager.C0435d;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.luggage.natives.component.widget.LuPagerView */
public class LuPagerView extends ViewPager {
    private static final String TAG = "LuPagerView";
    private int mOrientation = 0;

    /* renamed from: com.tencent.mm.plugin.luggage.natives.component.widget.LuPagerView$a */
    class C39348a implements C0435d {
        private C39348a() {
        }

        /* synthetic */ C39348a(LuPagerView luPagerView, byte b) {
            this();
        }

        /* renamed from: j */
        public final void mo959j(View view, float f) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luggage.natives.component.widget.LuPagerView$b */
    class C39349b implements C0435d {
        private C39349b() {
        }

        /* synthetic */ C39349b(LuPagerView luPagerView, byte b) {
            this();
        }

        /* renamed from: j */
        public final void mo959j(View view, float f) {
            AppMethodBeat.m2504i(116892);
            if (f >= -1.0f) {
                if (f <= 0.0f) {
                    view.setTranslationX(((float) view.getWidth()) * (-f));
                    view.setTranslationY(((float) view.getHeight()) * f);
                    AppMethodBeat.m2505o(116892);
                    return;
                } else if (f <= 1.0f) {
                    view.setTranslationX(((float) view.getWidth()) * (-f));
                    view.setTranslationY(0.0f);
                }
            }
            AppMethodBeat.m2505o(116892);
        }
    }

    public LuPagerView(Context context) {
        super(context);
        AppMethodBeat.m2504i(116893);
        init();
        AppMethodBeat.m2505o(116893);
    }

    public LuPagerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(116894);
        init();
        AppMethodBeat.m2505o(116894);
    }

    public void init() {
        AppMethodBeat.m2504i(116895);
        setOverScrollMode(2);
        AppMethodBeat.m2505o(116895);
    }

    public void setPageOrientation(int i) {
        AppMethodBeat.m2504i(116896);
        this.mOrientation = i;
        if (this.mOrientation == 1) {
            setPageTransformer(true, new C39349b(this, (byte) 0));
            AppMethodBeat.m2505o(116896);
            return;
        }
        setPageTransformer(true, new C39348a(this, (byte) 0));
        AppMethodBeat.m2505o(116896);
    }

    private MotionEvent swapXY(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(116897);
        if (this.mOrientation == 1) {
            float width = (float) getWidth();
            float height = (float) getHeight();
            motionEvent.setLocation(height * (motionEvent.getY() / height), width * (motionEvent.getX() / width));
        }
        AppMethodBeat.m2505o(116897);
        return motionEvent;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(116898);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(swapXY(motionEvent));
        swapXY(motionEvent);
        AppMethodBeat.m2505o(116898);
        return onInterceptTouchEvent;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(116899);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(116899);
        return dispatchTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(116900);
        switch (motionEvent.getAction()) {
            case 0:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case 1:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(swapXY(motionEvent));
        AppMethodBeat.m2505o(116900);
        return onTouchEvent;
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(116901);
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
        AppMethodBeat.m2505o(116901);
    }
}
