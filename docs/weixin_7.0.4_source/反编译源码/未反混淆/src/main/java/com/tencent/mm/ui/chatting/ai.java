package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ai {
    private static ai yLT;
    Object yLS;

    @TargetApi(14)
    public static class a implements OnHoverListener {
        private b yLU;

        public a(b bVar) {
            this.yLU = bVar;
        }

        public final boolean onHover(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(30960);
            if (this.yLU != null) {
                boolean f = this.yLU.f(view, motionEvent);
                AppMethodBeat.o(30960);
                return f;
            }
            AppMethodBeat.o(30960);
            return false;
        }
    }

    public interface b {
        boolean f(View view, MotionEvent motionEvent);
    }

    public static synchronized ai dCK() {
        ai aiVar;
        synchronized (ai.class) {
            AppMethodBeat.i(30961);
            if (yLT == null) {
                yLT = new ai();
            }
            aiVar = yLT;
            AppMethodBeat.o(30961);
        }
        return aiVar;
    }
}
