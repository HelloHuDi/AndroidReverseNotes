package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class an implements OnTouchListener {
    private static final int LN = ViewConfiguration.getLongPressTimeout();
    private final Handler jho = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(123866);
            switch (message.what) {
                case 1:
                case 2:
                    if (an.a(an.this)) {
                        sendMessageDelayed(Message.obtain(an.this.jho, 2), 50);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(123866);
        }
    };
    private float jhp;
    private float jhq;
    private boolean jhr = false;

    public an() {
        AppMethodBeat.i(123867);
        AppMethodBeat.o(123867);
    }

    static {
        AppMethodBeat.i(123871);
        AppMethodBeat.o(123871);
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(123868);
        switch (motionEvent.getActionMasked()) {
            case 0:
                view.setPressed(true);
                this.jho.sendMessageDelayed(Message.obtain(this.jho, 1), (long) LN);
                this.jhp = motionEvent.getX();
                this.jhq = motionEvent.getY();
                break;
            case 1:
                if (!this.jhr && this.jho.hasMessages(1)) {
                    aFi();
                }
                cU(view);
                break;
            case 2:
                int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (((float) (-scaledTouchSlop)) > x || x > ((float) (view.getWidth() + scaledTouchSlop)) || ((float) (-scaledTouchSlop)) > y || y > ((float) (scaledTouchSlop + view.getHeight()))) {
                    this.jhr = true;
                    break;
                }
            case 3:
                cU(view);
                break;
        }
        AppMethodBeat.o(123868);
        return true;
    }

    private void cU(View view) {
        AppMethodBeat.i(123869);
        view.setPressed(false);
        this.jhr = false;
        this.jho.removeMessages(1);
        this.jho.removeMessages(2);
        AppMethodBeat.o(123869);
    }

    /* Access modifiers changed, original: protected */
    public void aFi() {
    }

    /* Access modifiers changed, original: protected */
    public void aQX() {
    }

    static /* synthetic */ boolean a(an anVar) {
        AppMethodBeat.i(123870);
        if (anVar.jhr) {
            AppMethodBeat.o(123870);
            return false;
        }
        anVar.aQX();
        AppMethodBeat.o(123870);
        return true;
    }
}
