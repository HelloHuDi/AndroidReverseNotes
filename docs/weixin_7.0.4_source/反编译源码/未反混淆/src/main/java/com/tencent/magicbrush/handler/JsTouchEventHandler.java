package com.tencent.magicbrush.handler;

import android.view.MotionEvent;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class JsTouchEventHandler {
    public IntBuffer bSF;
    public FloatBuffer bSG;
    public b bSH = new b(this);
    public MBRuntime bSv;
    public float mDensity;

    public interface a {
        void aA(long j);
    }

    public static class b implements a {
        private WeakReference<JsTouchEventHandler> bSI;

        public b(JsTouchEventHandler jsTouchEventHandler) {
            AppMethodBeat.i(115884);
            this.bSI = new WeakReference(jsTouchEventHandler);
            AppMethodBeat.o(115884);
        }

        public final void aA(long j) {
            AppMethodBeat.i(115885);
            JsTouchEventHandler jsTouchEventHandler = (JsTouchEventHandler) this.bSI.get();
            if (jsTouchEventHandler != null) {
                JsTouchEventHandler.a(jsTouchEventHandler, j);
            }
            AppMethodBeat.o(115885);
        }
    }

    private native void nativeFreeTouchEvent(long j);

    public native long nativeCreateTouchEvent(int i, int i2, int i3, IntBuffer intBuffer, FloatBuffer floatBuffer, long j);

    static /* synthetic */ void a(JsTouchEventHandler jsTouchEventHandler, long j) {
        AppMethodBeat.i(115889);
        jsTouchEventHandler.nativeFreeTouchEvent(j);
        AppMethodBeat.o(115889);
    }

    public JsTouchEventHandler(MBRuntime mBRuntime) {
        AppMethodBeat.i(115886);
        this.bSv = mBRuntime;
        this.mDensity = (float) this.bSv.getParams().device_pixel_ratio_;
        fS(10);
        AppMethodBeat.o(115886);
    }

    public final void fS(int i) {
        AppMethodBeat.i(115887);
        if (this.bSF == null || this.bSF.capacity() < i) {
            int capacity;
            if (this.bSF != null) {
                capacity = this.bSF.capacity();
                while (capacity < i) {
                    capacity *= 2;
                }
            } else {
                capacity = i;
            }
            String str = "MicroMsg.JsTouchEventHandler";
            String str2 = "Should Create A New Buffer, Current = [%d], Request = [%d], ShouldBe = [%d]";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(this.bSF == null ? 0 : this.bSF.capacity());
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(capacity);
            c.i(str, str2, objArr);
            this.bSF = ByteBuffer.allocateDirect(capacity * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
            this.bSG = ByteBuffer.allocateDirect((capacity * 2) * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            AppMethodBeat.o(115887);
            return;
        }
        this.bSF.clear();
        this.bSG.clear();
        AppMethodBeat.o(115887);
    }

    public static int n(MotionEvent motionEvent) {
        AppMethodBeat.i(115888);
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 5:
                AppMethodBeat.o(115888);
                return 0;
            case 1:
            case 6:
                AppMethodBeat.o(115888);
                return 2;
            case 2:
                AppMethodBeat.o(115888);
                return 1;
            case 3:
                AppMethodBeat.o(115888);
                return 3;
            default:
                AppMethodBeat.o(115888);
                return -1;
        }
    }
}
