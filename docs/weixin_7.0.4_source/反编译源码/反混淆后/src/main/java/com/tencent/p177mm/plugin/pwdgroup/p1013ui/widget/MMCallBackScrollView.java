package com.tencent.p177mm.plugin.pwdgroup.p1013ui.widget;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView */
public class MMCallBackScrollView extends ScrollView {
    private C7306ak mHandler = new C287221();
    private int mState = 0;
    private int prR;
    private C21512a prS;

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView$a */
    public interface C21512a {
        /* renamed from: cm */
        void mo36983cm(int i);
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView$1 */
    class C287221 extends C7306ak {
        C287221() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(24039);
            int scrollY = MMCallBackScrollView.this.getScrollY();
            if (scrollY == MMCallBackScrollView.this.prR) {
                MMCallBackScrollView.m45643a(MMCallBackScrollView.this, 0);
                AppMethodBeat.m2505o(24039);
                return;
            }
            MMCallBackScrollView.this.prR = scrollY;
            MMCallBackScrollView.this.mHandler.sendMessageDelayed(MMCallBackScrollView.this.mHandler.obtainMessage(), 5);
            MMCallBackScrollView.m45643a(MMCallBackScrollView.this, 1);
            AppMethodBeat.m2505o(24039);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m45643a(MMCallBackScrollView mMCallBackScrollView, int i) {
        AppMethodBeat.m2504i(24044);
        mMCallBackScrollView.m45641Bm(i);
        AppMethodBeat.m2505o(24044);
    }

    public void setMMOnScrollListener(C21512a c21512a) {
        this.prS = c21512a;
    }

    /* renamed from: Bm */
    private void m45641Bm(int i) {
        AppMethodBeat.m2504i(24040);
        if (!(this.prS == null || this.mState == i)) {
            this.mState = i;
            this.prS.mo36983cm(i);
        }
        AppMethodBeat.m2505o(24040);
    }

    public MMCallBackScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(24041);
        AppMethodBeat.m2505o(24041);
    }

    public MMCallBackScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(24042);
        AppMethodBeat.m2505o(24042);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(24043);
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
                m45641Bm(1);
                break;
        }
        AppMethodBeat.m2505o(24043);
        return onTouchEvent;
    }
}
