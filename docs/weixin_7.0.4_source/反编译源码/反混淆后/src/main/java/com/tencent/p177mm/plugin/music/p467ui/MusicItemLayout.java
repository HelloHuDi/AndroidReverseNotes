package com.tencent.p177mm.plugin.music.p467ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.music.p467ui.C39449b.C39450a;

/* renamed from: com.tencent.mm.plugin.music.ui.MusicItemLayout */
public class MusicItemLayout extends LinearLayout {
    private GestureDetector lCs;

    /* renamed from: com.tencent.mm.plugin.music.ui.MusicItemLayout$a */
    class C34599a extends SimpleOnGestureListener {
        private C34599a() {
        }

        /* synthetic */ C34599a(MusicItemLayout musicItemLayout, byte b) {
            this();
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.m2504i(105065);
            if (Math.abs(f2) > Math.abs(f)) {
                C39450a c39450a = (C39450a) MusicItemLayout.this.getTag();
                if (f2 > 0.0f) {
                    c39450a.bUO();
                } else {
                    c39450a.bUN();
                }
            }
            AppMethodBeat.m2505o(105065);
            return false;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(105066);
            C39450a c39450a = (C39450a) MusicItemLayout.this.getTag();
            if (c39450a.bUM()) {
                if (motionEvent.getY() <= ((float) c39450a.oOD.getMeasuredHeight()) && motionEvent.getY() > 100.0f) {
                    c39450a.bUP();
                }
            } else if (motionEvent.getY() >= c39450a.oOG.getY() - 100.0f && motionEvent.getY() < ((float) c39450a.oOG.getMeasuredHeight()) + c39450a.oOG.getY()) {
                c39450a.bUP();
            }
            AppMethodBeat.m2505o(105066);
            return false;
        }
    }

    public MusicItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(105067);
        initView();
        AppMethodBeat.m2505o(105067);
    }

    public MusicItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(105068);
        initView();
        AppMethodBeat.m2505o(105068);
    }

    private void initView() {
        AppMethodBeat.m2504i(105069);
        this.lCs = new GestureDetector(getContext(), new C34599a(this, (byte) 0));
        AppMethodBeat.m2505o(105069);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(105070);
        C39450a c39450a = (C39450a) getTag();
        if (!c39450a.bUM()) {
            Object obj;
            if (c39450a.oOE.getX() <= motionEvent.getX() && motionEvent.getX() <= c39450a.oOE.getX() + ((float) c39450a.oOE.getMeasuredWidth()) && c39450a.oOE.getY() <= motionEvent.getY()) {
                if (motionEvent.getY() <= ((float) c39450a.oOE.getMeasuredHeight()) + c39450a.oOE.getY()) {
                    obj = 1;
                    if (obj == null) {
                        AppMethodBeat.m2505o(105070);
                        return true;
                    }
                }
            }
            obj = null;
            if (obj == null) {
            }
        }
        AppMethodBeat.m2505o(105070);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(105071);
        this.lCs.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(105071);
        return true;
    }
}
