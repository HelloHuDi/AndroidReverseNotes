package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.an */
public class C2562an implements OnTouchListener {
    /* renamed from: LN */
    private static final int f1258LN = ViewConfiguration.getLongPressTimeout();
    private final Handler jho = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(123866);
            switch (message.what) {
                case 1:
                case 2:
                    if (C2562an.m4805a(C2562an.this)) {
                        sendMessageDelayed(Message.obtain(C2562an.this.jho, 2), 50);
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(123866);
        }
    };
    private float jhp;
    private float jhq;
    private boolean jhr = false;

    public C2562an() {
        AppMethodBeat.m2504i(123867);
        AppMethodBeat.m2505o(123867);
    }

    static {
        AppMethodBeat.m2504i(123871);
        AppMethodBeat.m2505o(123871);
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(123868);
        switch (motionEvent.getActionMasked()) {
            case 0:
                view.setPressed(true);
                this.jho.sendMessageDelayed(Message.obtain(this.jho, 1), (long) f1258LN);
                this.jhp = motionEvent.getX();
                this.jhq = motionEvent.getY();
                break;
            case 1:
                if (!this.jhr && this.jho.hasMessages(1)) {
                    aFi();
                }
                m4807cU(view);
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
                m4807cU(view);
                break;
        }
        AppMethodBeat.m2505o(123868);
        return true;
    }

    /* renamed from: cU */
    private void m4807cU(View view) {
        AppMethodBeat.m2504i(123869);
        view.setPressed(false);
        this.jhr = false;
        this.jho.removeMessages(1);
        this.jho.removeMessages(2);
        AppMethodBeat.m2505o(123869);
    }

    /* Access modifiers changed, original: protected */
    public void aFi() {
    }

    /* Access modifiers changed, original: protected */
    public void aQX() {
    }

    /* renamed from: a */
    static /* synthetic */ boolean m4805a(C2562an c2562an) {
        AppMethodBeat.m2504i(123870);
        if (c2562an.jhr) {
            AppMethodBeat.m2505o(123870);
            return false;
        }
        c2562an.aQX();
        AppMethodBeat.m2505o(123870);
        return true;
    }
}
