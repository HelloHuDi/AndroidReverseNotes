package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.CustomViewPager;

public class MusicViewPager extends CustomViewPager {
    private GestureDetector lCs = new GestureDetector(getContext(), new b(this, (byte) 0));

    public class a extends Scroller {
        private int duration = 1000;

        public a(Context context) {
            super(context);
        }

        public final void startScroll(int i, int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(105139);
            super.startScroll(i, i2, i3, i4, this.duration);
            AppMethodBeat.o(105139);
        }

        public final void startScroll(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(105140);
            super.startScroll(i, i2, i3, i4, this.duration);
            AppMethodBeat.o(105140);
        }
    }

    class b extends SimpleOnGestureListener {
        private b() {
        }

        /* synthetic */ b(MusicViewPager musicViewPager, byte b) {
            this();
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.i(105141);
            if (Math.abs(f2) < Math.abs(f)) {
                AppMethodBeat.o(105141);
                return true;
            }
            AppMethodBeat.o(105141);
            return false;
        }
    }

    public MusicViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(105142);
        setScroller(new a(getContext()));
        AppMethodBeat.o(105142);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(105143);
        if (super.onInterceptTouchEvent(motionEvent) && this.lCs.onTouchEvent(motionEvent)) {
            AppMethodBeat.o(105143);
            return true;
        }
        AppMethodBeat.o(105143);
        return false;
    }
}
