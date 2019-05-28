package com.tencent.magicbrush.handler;

import android.view.MotionEvent;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class JsTouchEventHandler {
    public IntBuffer bSF;
    public FloatBuffer bSG;
    public C17840b bSH = new C17840b(this);
    public MBRuntime bSv;
    public float mDensity;

    /* renamed from: com.tencent.magicbrush.handler.JsTouchEventHandler$a */
    public interface C1007a {
        /* renamed from: aA */
        void mo4005aA(long j);
    }

    /* renamed from: com.tencent.magicbrush.handler.JsTouchEventHandler$b */
    public static class C17840b implements C1007a {
        private WeakReference<JsTouchEventHandler> bSI;

        public C17840b(JsTouchEventHandler jsTouchEventHandler) {
            AppMethodBeat.m2504i(115884);
            this.bSI = new WeakReference(jsTouchEventHandler);
            AppMethodBeat.m2505o(115884);
        }

        /* renamed from: aA */
        public final void mo4005aA(long j) {
            AppMethodBeat.m2504i(115885);
            JsTouchEventHandler jsTouchEventHandler = (JsTouchEventHandler) this.bSI.get();
            if (jsTouchEventHandler != null) {
                JsTouchEventHandler.m27922a(jsTouchEventHandler, j);
            }
            AppMethodBeat.m2505o(115885);
        }
    }

    private native void nativeFreeTouchEvent(long j);

    public native long nativeCreateTouchEvent(int i, int i2, int i3, IntBuffer intBuffer, FloatBuffer floatBuffer, long j);

    /* renamed from: a */
    static /* synthetic */ void m27922a(JsTouchEventHandler jsTouchEventHandler, long j) {
        AppMethodBeat.m2504i(115889);
        jsTouchEventHandler.nativeFreeTouchEvent(j);
        AppMethodBeat.m2505o(115889);
    }

    public JsTouchEventHandler(MBRuntime mBRuntime) {
        AppMethodBeat.m2504i(115886);
        this.bSv = mBRuntime;
        this.mDensity = (float) this.bSv.getParams().device_pixel_ratio_;
        mo33015fS(10);
        AppMethodBeat.m2505o(115886);
    }

    /* renamed from: fS */
    public final void mo33015fS(int i) {
        AppMethodBeat.m2504i(115887);
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
            C17837c.m27916i(str, str2, objArr);
            this.bSF = ByteBuffer.allocateDirect(capacity * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
            this.bSG = ByteBuffer.allocateDirect((capacity * 2) * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            AppMethodBeat.m2505o(115887);
            return;
        }
        this.bSF.clear();
        this.bSG.clear();
        AppMethodBeat.m2505o(115887);
    }

    /* renamed from: n */
    public static int m27923n(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(115888);
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 5:
                AppMethodBeat.m2505o(115888);
                return 0;
            case 1:
            case 6:
                AppMethodBeat.m2505o(115888);
                return 2;
            case 2:
                AppMethodBeat.m2505o(115888);
                return 1;
            case 3:
                AppMethodBeat.m2505o(115888);
                return 3;
            default:
                AppMethodBeat.m2505o(115888);
                return -1;
        }
    }
}
