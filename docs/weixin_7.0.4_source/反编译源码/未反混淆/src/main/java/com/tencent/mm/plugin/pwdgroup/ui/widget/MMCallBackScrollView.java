package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public class MMCallBackScrollView extends ScrollView {
    private ak mHandler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(24039);
            int scrollY = MMCallBackScrollView.this.getScrollY();
            if (scrollY == MMCallBackScrollView.this.prR) {
                MMCallBackScrollView.a(MMCallBackScrollView.this, 0);
                AppMethodBeat.o(24039);
                return;
            }
            MMCallBackScrollView.this.prR = scrollY;
            MMCallBackScrollView.this.mHandler.sendMessageDelayed(MMCallBackScrollView.this.mHandler.obtainMessage(), 5);
            MMCallBackScrollView.a(MMCallBackScrollView.this, 1);
            AppMethodBeat.o(24039);
        }
    };
    private int mState = 0;
    private int prR;
    private a prS;

    public interface a {
        void cm(int i);
    }

    static /* synthetic */ void a(MMCallBackScrollView mMCallBackScrollView, int i) {
        AppMethodBeat.i(24044);
        mMCallBackScrollView.Bm(i);
        AppMethodBeat.o(24044);
    }

    public void setMMOnScrollListener(a aVar) {
        this.prS = aVar;
    }

    private void Bm(int i) {
        AppMethodBeat.i(24040);
        if (!(this.prS == null || this.mState == i)) {
            this.mState = i;
            this.prS.cm(i);
        }
        AppMethodBeat.o(24040);
    }

    public MMCallBackScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(24041);
        AppMethodBeat.o(24041);
    }

    public MMCallBackScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(24042);
        AppMethodBeat.o(24042);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(24043);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        this.prR = getScrollY();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.mHandler != null) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(), 5);
                    break;
                }
                break;
            case 2:
                Bm(1);
                break;
        }
        AppMethodBeat.o(24043);
        return onTouchEvent;
    }
}
