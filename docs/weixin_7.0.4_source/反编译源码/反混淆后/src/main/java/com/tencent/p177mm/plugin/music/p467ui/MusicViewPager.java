package com.tencent.p177mm.plugin.music.p467ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.CustomViewPager;

/* renamed from: com.tencent.mm.plugin.music.ui.MusicViewPager */
public class MusicViewPager extends CustomViewPager {
    private GestureDetector lCs = new GestureDetector(getContext(), new C28586b(this, (byte) 0));

    /* renamed from: com.tencent.mm.plugin.music.ui.MusicViewPager$a */
    public class C12688a extends Scroller {
        private int duration = 1000;

        public C12688a(Context context) {
            super(context);
        }

        public final void startScroll(int i, int i2, int i3, int i4, int i5) {
            AppMethodBeat.m2504i(105139);
            super.startScroll(i, i2, i3, i4, this.duration);
            AppMethodBeat.m2505o(105139);
        }

        public final void startScroll(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(105140);
            super.startScroll(i, i2, i3, i4, this.duration);
            AppMethodBeat.m2505o(105140);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.ui.MusicViewPager$b */
    class C28586b extends SimpleOnGestureListener {
        private C28586b() {
        }

        /* synthetic */ C28586b(MusicViewPager musicViewPager, byte b) {
            this();
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.m2504i(105141);
            if (Math.abs(f2) < Math.abs(f)) {
                AppMethodBeat.m2505o(105141);
                return true;
            }
            AppMethodBeat.m2505o(105141);
            return false;
        }
    }

    public MusicViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(105142);
        setScroller(new C12688a(getContext()));
        AppMethodBeat.m2505o(105142);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(105143);
        if (super.onInterceptTouchEvent(motionEvent) && this.lCs.onTouchEvent(motionEvent)) {
            AppMethodBeat.m2505o(105143);
            return true;
        }
        AppMethodBeat.m2505o(105143);
        return false;
    }
}
