package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MusicItemLayout extends LinearLayout {
    private GestureDetector lCs;

    class a extends SimpleOnGestureListener {
        private a() {
        }

        /* synthetic */ a(MusicItemLayout musicItemLayout, byte b) {
            this();
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.i(105065);
            if (Math.abs(f2) > Math.abs(f)) {
                com.tencent.mm.plugin.music.ui.b.a aVar = (com.tencent.mm.plugin.music.ui.b.a) MusicItemLayout.this.getTag();
                if (f2 > 0.0f) {
                    aVar.bUO();
                } else {
                    aVar.bUN();
                }
            }
            AppMethodBeat.o(105065);
            return false;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(105066);
            com.tencent.mm.plugin.music.ui.b.a aVar = (com.tencent.mm.plugin.music.ui.b.a) MusicItemLayout.this.getTag();
            if (aVar.bUM()) {
                if (motionEvent.getY() <= ((float) aVar.oOD.getMeasuredHeight()) && motionEvent.getY() > 100.0f) {
                    aVar.bUP();
                }
            } else if (motionEvent.getY() >= aVar.oOG.getY() - 100.0f && motionEvent.getY() < ((float) aVar.oOG.getMeasuredHeight()) + aVar.oOG.getY()) {
                aVar.bUP();
            }
            AppMethodBeat.o(105066);
            return false;
        }
    }

    public MusicItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(105067);
        initView();
        AppMethodBeat.o(105067);
    }

    public MusicItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(105068);
        initView();
        AppMethodBeat.o(105068);
    }

    private void initView() {
        AppMethodBeat.i(105069);
        this.lCs = new GestureDetector(getContext(), new a(this, (byte) 0));
        AppMethodBeat.o(105069);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(105070);
        com.tencent.mm.plugin.music.ui.b.a aVar = (com.tencent.mm.plugin.music.ui.b.a) getTag();
        if (!aVar.bUM()) {
            Object obj;
            if (aVar.oOE.getX() <= motionEvent.getX() && motionEvent.getX() <= aVar.oOE.getX() + ((float) aVar.oOE.getMeasuredWidth()) && aVar.oOE.getY() <= motionEvent.getY()) {
                if (motionEvent.getY() <= ((float) aVar.oOE.getMeasuredHeight()) + aVar.oOE.getY()) {
                    obj = 1;
                    if (obj == null) {
                        AppMethodBeat.o(105070);
                        return true;
                    }
                }
            }
            obj = null;
            if (obj == null) {
            }
        }
        AppMethodBeat.o(105070);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(105071);
        this.lCs.onTouchEvent(motionEvent);
        AppMethodBeat.o(105071);
        return true;
    }
}
