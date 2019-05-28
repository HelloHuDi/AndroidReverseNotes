package com.tencent.p177mm.p612ui.bizchat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.bizchat.BizChatSearchListView */
public class BizChatSearchListView extends ListView {
    private C5296a yEv;

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatSearchListView$a */
    public interface C5296a {
        boolean aWe();
    }

    public BizChatSearchListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BizChatSearchListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(30134);
        if (this.yEv != null) {
            this.yEv.aWe();
        }
        if (super.onInterceptTouchEvent(motionEvent)) {
            AppMethodBeat.m2505o(30134);
            return true;
        }
        AppMethodBeat.m2505o(30134);
        return false;
    }

    public void setOnTouchListener(C5296a c5296a) {
        this.yEv = c5296a;
    }
}
