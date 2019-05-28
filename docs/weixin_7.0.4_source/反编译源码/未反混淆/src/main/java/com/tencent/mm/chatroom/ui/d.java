package com.tencent.mm.chatroom.ui;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class d extends TouchDelegate {
    private static final Rect eoc = new Rect();
    ArrayList<TouchDelegate> eod;
    TouchDelegate eoe;

    static {
        AppMethodBeat.i(104461);
        AppMethodBeat.o(104461);
    }

    public d(View view) {
        super(eoc, view);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        TouchDelegate touchDelegate;
        AppMethodBeat.i(104460);
        switch (motionEvent.getAction()) {
            case 0:
                if (this.eod != null) {
                    Iterator it = this.eod.iterator();
                    while (it.hasNext()) {
                        touchDelegate = (TouchDelegate) it.next();
                        if (touchDelegate != null && touchDelegate.onTouchEvent(motionEvent)) {
                            this.eoe = touchDelegate;
                            AppMethodBeat.o(104460);
                            return true;
                        }
                    }
                    touchDelegate = null;
                    break;
                }
                break;
            case 1:
            case 3:
                touchDelegate = this.eoe;
                this.eoe = null;
                break;
            case 2:
                touchDelegate = this.eoe;
                break;
            default:
                touchDelegate = null;
                break;
        }
        if (touchDelegate == null) {
            AppMethodBeat.o(104460);
            return false;
        }
        boolean onTouchEvent = touchDelegate.onTouchEvent(motionEvent);
        AppMethodBeat.o(104460);
        return onTouchEvent;
    }
}
