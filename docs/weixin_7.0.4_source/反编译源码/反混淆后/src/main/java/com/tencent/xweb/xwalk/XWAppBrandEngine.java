package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class XWAppBrandEngine {
    public static C6049b ARM = null;
    private int ARI = 0;
    private HashMap<Integer, C6046a> ARJ = new HashMap();
    private boolean ARK = false;
    public ArrayList<Runnable> ARL = new ArrayList();
    private Handler mHandler = new Handler();
    private long mInstance = nativeCreated();
    private Timer mTimer = new Timer();

    /* renamed from: com.tencent.xweb.xwalk.XWAppBrandEngine$a */
    public class C6046a extends TimerTask {
        public int ARN;
        public boolean ARO;

        /* renamed from: com.tencent.xweb.xwalk.XWAppBrandEngine$a$1 */
        class C60471 implements Runnable {
            C60471() {
            }

            public final void run() {
                AppMethodBeat.m2504i(4165);
                XWAppBrandEngine.m9519a(XWAppBrandEngine.this, XWAppBrandEngine.this.mInstance, C6046a.this.ARN);
                AppMethodBeat.m2505o(4165);
            }
        }

        /* renamed from: com.tencent.xweb.xwalk.XWAppBrandEngine$a$2 */
        class C60482 implements Runnable {
            C60482() {
            }

            public final void run() {
                AppMethodBeat.m2504i(4166);
                XWAppBrandEngine.m9519a(XWAppBrandEngine.this, XWAppBrandEngine.this.mInstance, C6046a.this.ARN);
                AppMethodBeat.m2505o(4166);
            }
        }

        public C6046a(int i, boolean z) {
            this.ARN = i;
            this.ARO = z;
        }

        public final void run() {
            AppMethodBeat.m2504i(4167);
            if (!XWAppBrandEngine.this.ARK) {
                XWAppBrandEngine.this.mHandler.post(new C60482());
                AppMethodBeat.m2505o(4167);
            } else if (this.ARO) {
                AppMethodBeat.m2505o(4167);
            } else {
                synchronized (XWAppBrandEngine.this.ARL) {
                    try {
                        XWAppBrandEngine.this.ARL.add(new C60471());
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(4167);
                    }
                }
            }
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.XWAppBrandEngine$b */
    public interface C6049b {
    }

    private native void addJsInterface(long j, Object obj, String str);

    private native String evaluateJavascript(long j, String str);

    private native ByteBuffer getNativeBuffer(long j, int i);

    private native int getNativeBufferId(long j);

    private native long nativeCreated();

    private native void nativeFinalize(long j);

    private native void notifyClearTimer(long j, int i);

    private native boolean notifyRunTimer(long j, int i);

    private native boolean removeJsInterface(long j, String str);

    private native void setNativeBuffer(long j, int i, ByteBuffer byteBuffer);

    /* renamed from: a */
    static /* synthetic */ boolean m9519a(XWAppBrandEngine xWAppBrandEngine, long j, int i) {
        AppMethodBeat.m2504i(4171);
        boolean notifyRunTimer = xWAppBrandEngine.notifyRunTimer(j, i);
        AppMethodBeat.m2505o(4171);
        return notifyRunTimer;
    }

    public XWAppBrandEngine() {
        AppMethodBeat.m2504i(4168);
        AppMethodBeat.m2505o(4168);
    }

    @Keep
    public int setTimer(int i, boolean z) {
        AppMethodBeat.m2504i(4169);
        int i2 = this.ARI + 1;
        this.ARI = i2;
        C6046a c6046a = new C6046a(i2, z);
        this.ARJ.put(Integer.valueOf(i2), c6046a);
        if (i <= 0) {
            i = 1;
        }
        if (z) {
            this.mTimer.schedule(c6046a, (long) i, (long) i);
        } else {
            this.mTimer.schedule(c6046a, (long) i);
        }
        AppMethodBeat.m2505o(4169);
        return i2;
    }

    @Keep
    public void clearTimer(int i) {
        AppMethodBeat.m2504i(4170);
        if (this.ARJ.containsKey(Integer.valueOf(i))) {
            ((C6046a) this.ARJ.get(Integer.valueOf(i))).cancel();
            this.ARJ.remove(Integer.valueOf(i));
            AppMethodBeat.m2505o(4170);
            return;
        }
        AppMethodBeat.m2505o(4170);
    }

    @Keep
    public void onLog(int i, String str) {
        String[] strArr = new String[]{"debug", "log", "info", "warn", "error"};
    }

    static {
        AppMethodBeat.m2504i(4172);
        ClassLoader classLoader = XWAppBrandEngine.class.getClassLoader();
        C1449k.m3079a("mmv8", classLoader);
        C1449k.m3079a("jsengine", classLoader);
        AppMethodBeat.m2505o(4172);
    }

    @Keep
    public static void reportException(String str, String str2, long j) {
        if (ARM != null) {
        }
    }
}
