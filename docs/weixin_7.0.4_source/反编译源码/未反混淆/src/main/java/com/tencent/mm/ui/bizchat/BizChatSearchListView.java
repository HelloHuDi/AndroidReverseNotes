package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BizChatSearchListView extends ListView {
    private a yEv;

    public interface a {
        boolean aWe();
    }

    public BizChatSearchListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BizChatSearchListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(30134);
        if (this.yEv != null) {
            this.yEv.aWe();
        }
        if (super.onInterceptTouchEvent(motionEvent)) {
            AppMethodBeat.o(30134);
            return true;
        }
        AppMethodBeat.o(30134);
        return false;
    }

    public void setOnTouchListener(a aVar) {
        this.yEv = aVar;
    }
}
