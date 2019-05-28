package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;

public class TestTimeForChatting extends DrawnCallBackLinearLayout {
    public final String TAG = "MicroMsg.TestTimeForChatting";
    private int eNs = 0;
    private long fYr;
    a zHX;
    public int zHY = 0;
    public int zHZ = 0;

    public interface a {
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
        AppMethodBeat.i(35003);
        long currentTimeMillis = System.currentTimeMillis();
        super.onDraw(canvas);
        ab.i("MicroMsg.TestTimeForChatting", (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(35003);
    }

    public final void dJY() {
        AppMethodBeat.i(35004);
        long currentTimeMillis = System.currentTimeMillis() - this.fYr;
        ab.i("MicroMsg.TestTimeForChatting", "start chatting response time: %dms", Long.valueOf(currentTimeMillis));
        this.eNs = 0;
        AppMethodBeat.o(35004);
    }

    public final void dJZ() {
        AppMethodBeat.i(35005);
        ab.i("MicroMsg.TestTimeForChatting", "klem frameCount:%d", Integer.valueOf(this.eNs));
        h.pYm.e(11198, Integer.valueOf(this.eNs));
        AppMethodBeat.o(35005);
    }

    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(35006);
        this.eNs++;
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.TestTimeForChatting", th, "dispatchDraw", new Object[0]);
        }
        g.BO(9);
        g.BO(18);
        g.BO(25);
        g.BO(24);
        g.BO(20);
        g.BO(18);
        if (this.zHX != null) {
            post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(35002);
                    if (TestTimeForChatting.this.zHX != null) {
                        TestTimeForChatting.this.zHX.dyY();
                    }
                    AppMethodBeat.o(35002);
                }
            });
        }
        AppMethodBeat.o(35006);
    }

    public void setOndispatchDraw(a aVar) {
        this.zHX = aVar;
    }

    public boolean fitSystemWindows(Rect rect) {
        AppMethodBeat.i(35007);
        ab.d("MicroMsg.TestTimeForChatting", "ashu::fitSystemWindows: %s, fixBottomPadding:%d fixRightPadding:%d", rect.toString(), Integer.valueOf(this.zHY), Integer.valueOf(this.zHZ));
        rect.bottom += this.zHY;
        rect.right += this.zHZ;
        boolean fitSystemWindows = super.fitSystemWindows(rect);
        AppMethodBeat.o(35007);
        return fitSystemWindows;
    }
}
