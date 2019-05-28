package com.tencent.p177mm.p612ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.applet.b */
public final class C36043b {
    int direction = 0;
    private IdleHandler jQs;
    private GestureDetector lCs = new GestureDetector(new C360442());
    private int yrA;
    private C5235c yrB;
    LinkedList<String> yrC;
    C5234a yrD;

    /* renamed from: com.tencent.mm.ui.applet.b$a */
    public interface C5234a {
        /* renamed from: wd */
        Bitmap mo10738wd(String str);
    }

    /* renamed from: com.tencent.mm.ui.applet.b$c */
    class C5235c {
        private LinkedList<String> eow;
        private int maxSize;

        public C5235c() {
            AppMethodBeat.m2504i(106224);
            this.eow = null;
            this.maxSize = 40;
            this.eow = new LinkedList();
            AppMethodBeat.m2505o(106224);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: wy */
        public final void mo10740wy(String str) {
            AppMethodBeat.m2504i(106225);
            if (this.eow.contains(str)) {
                AppMethodBeat.m2505o(106225);
                return;
            }
            this.eow.add(str);
            if (this.eow.size() >= this.maxSize) {
                this.eow.removeFirst();
            }
            AppMethodBeat.m2505o(106225);
        }

        /* Access modifiers changed, original: final */
        public final boolean contains(String str) {
            AppMethodBeat.m2504i(106226);
            boolean contains = this.eow.contains(str);
            AppMethodBeat.m2505o(106226);
            return contains;
        }
    }

    /* renamed from: com.tencent.mm.ui.applet.b$b */
    public interface C23577b {
        int apO();

        /* renamed from: mW */
        String mo11090mW(int i);
    }

    /* renamed from: com.tencent.mm.ui.applet.b$2 */
    class C360442 implements OnGestureListener {
        C360442() {
        }

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
            C36043b c36043b = C36043b.this;
            if (f2 >= 0.0f) {
                i = 0;
            } else {
                i = 1;
            }
            c36043b.direction = i;
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.applet.b$1 */
    class C360451 implements IdleHandler {
        C360451() {
        }

        public final boolean queueIdle() {
            AppMethodBeat.m2504i(106223);
            while (C36043b.this.yrC.size() > 0) {
                C36043b.this.yrD.mo10738wd((String) C36043b.this.yrC.removeFirst());
            }
            AppMethodBeat.m2505o(106223);
            return true;
        }
    }

    public C36043b(C5234a c5234a) {
        AppMethodBeat.m2504i(106227);
        this.yrD = c5234a;
        this.yrA = 15;
        this.yrB = new C5235c();
        this.yrC = new LinkedList();
        this.jQs = new C360451();
        Looper.myQueue().addIdleHandler(this.jQs);
        AppMethodBeat.m2505o(106227);
    }

    /* renamed from: a */
    public final void mo56803a(int i, C23577b c23577b) {
        AppMethodBeat.m2504i(106228);
        if (c23577b == null) {
            C4990ab.m7412e("MicroMsg.EarlyGetHeadImg", "earlyGet, getter is null, no early get headimg will be performed");
            AppMethodBeat.m2505o(106228);
        } else if (this.yrA <= 0) {
            C4990ab.m7412e("MicroMsg.EarlyGetHeadImg", "earlyGet fail, threshold is invalid");
            AppMethodBeat.m2505o(106228);
        } else {
            int apO = c23577b.apO();
            for (int i2 = 1; i2 <= this.yrA; i2++) {
                String mW;
                if (this.direction == 1) {
                    if (i - i2 < 0) {
                        AppMethodBeat.m2505o(106228);
                        return;
                    }
                    mW = c23577b.mo11090mW(i - i2);
                    if (!(mW == null || mW.length() == 0 || this.yrB.contains(mW))) {
                        this.yrB.mo10740wy(mW);
                        this.yrC.add(mW);
                    }
                } else if (i + i2 >= apO) {
                    AppMethodBeat.m2505o(106228);
                    return;
                } else {
                    mW = c23577b.mo11090mW(i + i2);
                    if (!(mW == null || mW.length() == 0 || this.yrB.contains(mW))) {
                        this.yrB.mo10740wy(mW);
                        this.yrC.add(mW);
                    }
                }
            }
            AppMethodBeat.m2505o(106228);
        }
    }

    public final void onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(106229);
        if (this.lCs != null) {
            this.lCs.onTouchEvent(motionEvent);
        }
        AppMethodBeat.m2505o(106229);
    }

    public final void detach() {
        AppMethodBeat.m2504i(106230);
        if (this.jQs != null) {
            Looper.myQueue().removeIdleHandler(this.jQs);
        }
        AppMethodBeat.m2505o(106230);
    }
}
