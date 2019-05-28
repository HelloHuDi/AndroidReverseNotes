package com.tencent.p177mm.p612ui.chatting;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.chatting.ai */
public final class C30458ai {
    private static C30458ai yLT;
    Object yLS;

    @TargetApi(14)
    /* renamed from: com.tencent.mm.ui.chatting.ai$a */
    public static class C15576a implements OnHoverListener {
        private C15577b yLU;

        public C15576a(C15577b c15577b) {
            this.yLU = c15577b;
        }

        public final boolean onHover(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(30960);
            if (this.yLU != null) {
                boolean f = this.yLU.mo10987f(view, motionEvent);
                AppMethodBeat.m2505o(30960);
                return f;
            }
            AppMethodBeat.m2505o(30960);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ai$b */
    public interface C15577b {
        /* renamed from: f */
        boolean mo10987f(View view, MotionEvent motionEvent);
    }

    public static synchronized C30458ai dCK() {
        C30458ai c30458ai;
        synchronized (C30458ai.class) {
            AppMethodBeat.m2504i(30961);
            if (yLT == null) {
                yLT = new C30458ai();
            }
            c30458ai = yLT;
            AppMethodBeat.m2505o(30961);
        }
        return c30458ai;
    }
}
