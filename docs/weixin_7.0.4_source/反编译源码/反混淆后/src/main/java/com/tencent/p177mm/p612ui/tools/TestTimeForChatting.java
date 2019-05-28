package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.DrawnCallBackLinearLayout;
import com.tencent.p177mm.plugin.report.service.C34830g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.tools.TestTimeForChatting */
public class TestTimeForChatting extends DrawnCallBackLinearLayout {
    public final String TAG = "MicroMsg.TestTimeForChatting";
    private int eNs = 0;
    private long fYr;
    C5579a zHX;
    public int zHY = 0;
    public int zHZ = 0;

    /* renamed from: com.tencent.mm.ui.tools.TestTimeForChatting$1 */
    class C55781 implements Runnable {
        C55781() {
        }

        public final void run() {
            AppMethodBeat.m2504i(35002);
            if (TestTimeForChatting.this.zHX != null) {
                TestTimeForChatting.this.zHX.dyY();
            }
            AppMethodBeat.m2505o(35002);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.TestTimeForChatting$a */
    public interface C5579a {
        void dyY();
    }

    public TestTimeForChatting(Context context) {
        super(context);
    }

    public TestTimeForChatting(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(35003);
        long currentTimeMillis = System.currentTimeMillis();
        super.onDraw(canvas);
        C4990ab.m7416i("MicroMsg.TestTimeForChatting", (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(35003);
    }

    public final void dJY() {
        AppMethodBeat.m2504i(35004);
        long currentTimeMillis = System.currentTimeMillis() - this.fYr;
        C4990ab.m7417i("MicroMsg.TestTimeForChatting", "start chatting response time: %dms", Long.valueOf(currentTimeMillis));
        this.eNs = 0;
        AppMethodBeat.m2505o(35004);
    }

    public final void dJZ() {
        AppMethodBeat.m2504i(35005);
        C4990ab.m7417i("MicroMsg.TestTimeForChatting", "klem frameCount:%d", Integer.valueOf(this.eNs));
        C7060h.pYm.mo8381e(11198, Integer.valueOf(this.eNs));
        AppMethodBeat.m2505o(35005);
    }

    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.m2504i(35006);
        this.eNs++;
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.TestTimeForChatting", th, "dispatchDraw", new Object[0]);
        }
        C34830g.m57195BO(9);
        C34830g.m57195BO(18);
        C34830g.m57195BO(25);
        C34830g.m57195BO(24);
        C34830g.m57195BO(20);
        C34830g.m57195BO(18);
        if (this.zHX != null) {
            post(new C55781());
        }
        AppMethodBeat.m2505o(35006);
    }

    public void setOndispatchDraw(C5579a c5579a) {
        this.zHX = c5579a;
    }

    public boolean fitSystemWindows(Rect rect) {
        AppMethodBeat.m2504i(35007);
        C4990ab.m7411d("MicroMsg.TestTimeForChatting", "ashu::fitSystemWindows: %s, fixBottomPadding:%d fixRightPadding:%d", rect.toString(), Integer.valueOf(this.zHY), Integer.valueOf(this.zHZ));
        rect.bottom += this.zHY;
        rect.right += this.zHZ;
        boolean fitSystemWindows = super.fitSystemWindows(rect);
        AppMethodBeat.m2505o(35007);
        return fitSystemWindows;
    }
}
