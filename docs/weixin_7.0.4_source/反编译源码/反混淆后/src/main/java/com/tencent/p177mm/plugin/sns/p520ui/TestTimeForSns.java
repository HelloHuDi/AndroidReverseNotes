package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C34830g;

/* renamed from: com.tencent.mm.plugin.sns.ui.TestTimeForSns */
public class TestTimeForSns extends FrameLayout {
    public final boolean DEBUG = true;
    public final String TAG = "MicroMsg.TestTimeForSns";
    public long beginTime;
    private boolean hasDrawed;
    private C29165a listener;

    /* renamed from: com.tencent.mm.plugin.sns.ui.TestTimeForSns$a */
    public interface C29165a {
        void bCv();
    }

    public TestTimeForSns(Context context) {
        super(context);
    }

    public TestTimeForSns(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.m2504i(39842);
        super.dispatchDraw(canvas);
        if (!this.hasDrawed) {
            this.hasDrawed = true;
            if (this.listener != null) {
                this.listener.bCv();
            }
        }
        C34830g.m57195BO(10);
        C34830g.m57195BO(22);
        AppMethodBeat.m2505o(39842);
    }

    public void setListener(C29165a c29165a) {
        this.listener = c29165a;
    }

    public boolean hasDrawed() {
        return this.hasDrawed;
    }
}
