package com.tencent.mm.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class b {
    int direction = 0;
    private IdleHandler jQs;
    private GestureDetector lCs = new GestureDetector(new OnGestureListener() {
        public final boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        public final void onShowPress(MotionEvent motionEvent) {
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            int i;
            b bVar = b.this;
            if (f2 >= 0.0f) {
                i = 0;
            } else {
                i = 1;
            }
            bVar.direction = i;
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }
    });
    private int yrA;
    private c yrB;
    LinkedList<String> yrC;
    a yrD;

    public interface a {
        Bitmap wd(String str);
    }

    class c {
        private LinkedList<String> eow;
        private int maxSize;

        public c() {
            AppMethodBeat.i(106224);
            this.eow = null;
            this.maxSize = 40;
            this.eow = new LinkedList();
            AppMethodBeat.o(106224);
        }

        /* Access modifiers changed, original: final */
        public final void wy(String str) {
            AppMethodBeat.i(106225);
            if (this.eow.contains(str)) {
                AppMethodBeat.o(106225);
                return;
            }
            this.eow.add(str);
            if (this.eow.size() >= this.maxSize) {
                this.eow.removeFirst();
            }
            AppMethodBeat.o(106225);
        }

        /* Access modifiers changed, original: final */
        public final boolean contains(String str) {
            AppMethodBeat.i(106226);
            boolean contains = this.eow.contains(str);
            AppMethodBeat.o(106226);
            return contains;
        }
    }

    public interface b {
        int apO();

        String mW(int i);
    }

    public b(a aVar) {
        AppMethodBeat.i(106227);
        this.yrD = aVar;
        this.yrA = 15;
        this.yrB = new c();
        this.yrC = new LinkedList();
        this.jQs = new IdleHandler() {
            public final boolean queueIdle() {
                AppMethodBeat.i(106223);
                while (b.this.yrC.size() > 0) {
                    b.this.yrD.wd((String) b.this.yrC.removeFirst());
                }
                AppMethodBeat.o(106223);
                return true;
            }
        };
        Looper.myQueue().addIdleHandler(this.jQs);
        AppMethodBeat.o(106227);
    }

    public final void a(int i, b bVar) {
        AppMethodBeat.i(106228);
        if (bVar == null) {
            ab.e("MicroMsg.EarlyGetHeadImg", "earlyGet, getter is null, no early get headimg will be performed");
            AppMethodBeat.o(106228);
        } else if (this.yrA <= 0) {
            ab.e("MicroMsg.EarlyGetHeadImg", "earlyGet fail, threshold is invalid");
            AppMethodBeat.o(106228);
        } else {
            int apO = bVar.apO();
            for (int i2 = 1; i2 <= this.yrA; i2++) {
                String mW;
                if (this.direction == 1) {
                    if (i - i2 < 0) {
                        AppMethodBeat.o(106228);
                        return;
                    }
                    mW = bVar.mW(i - i2);
                    if (!(mW == null || mW.length() == 0 || this.yrB.contains(mW))) {
                        this.yrB.wy(mW);
                        this.yrC.add(mW);
                    }
                } else if (i + i2 >= apO) {
                    AppMethodBeat.o(106228);
                    return;
                } else {
                    mW = bVar.mW(i + i2);
                    if (!(mW == null || mW.length() == 0 || this.yrB.contains(mW))) {
                        this.yrB.wy(mW);
                        this.yrC.add(mW);
                    }
                }
            }
            AppMethodBeat.o(106228);
        }
    }

    public final void onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(106229);
        if (this.lCs != null) {
            this.lCs.onTouchEvent(motionEvent);
        }
        AppMethodBeat.o(106229);
    }

    public final void detach() {
        AppMethodBeat.i(106230);
        if (this.jQs != null) {
            Looper.myQueue().removeIdleHandler(this.jQs);
        }
        AppMethodBeat.o(106230);
    }
}
