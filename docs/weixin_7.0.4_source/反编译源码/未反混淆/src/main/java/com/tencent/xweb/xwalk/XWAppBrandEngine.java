package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class XWAppBrandEngine {
    public static b ARM = null;
    private int ARI = 0;
    private HashMap<Integer, a> ARJ = new HashMap();
    private boolean ARK = false;
    public ArrayList<Runnable> ARL = new ArrayList();
    private Handler mHandler = new Handler();
    private long mInstance = nativeCreated();
    private Timer mTimer = new Timer();

    public class a extends TimerTask {
        public int ARN;
        public boolean ARO;

        public a(int i, boolean z) {
            this.ARN = i;
            this.ARO = z;
        }

        public final void run() {
            AppMethodBeat.i(4167);
            if (!XWAppBrandEngine.this.ARK) {
                XWAppBrandEngine.this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(4166);
                        XWAppBrandEngine.a(XWAppBrandEngine.this, XWAppBrandEngine.this.mInstance, a.this.ARN);
                        AppMethodBeat.o(4166);
                    }
                });
                AppMethodBeat.o(4167);
            } else if (this.ARO) {
                AppMethodBeat.o(4167);
            } else {
                synchronized (XWAppBrandEngine.this.ARL) {
                    try {
                        XWAppBrandEngine.this.ARL.add(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(4165);
                                XWAppBrandEngine.a(XWAppBrandEngine.this, XWAppBrandEngine.this.mInstance, a.this.ARN);
                                AppMethodBeat.o(4165);
                            }
                        });
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(4167);
                    }
                }
            }
        }
    }

    public interface b {
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

    static /* synthetic */ boolean a(XWAppBrandEngine xWAppBrandEngine, long j, int i) {
        AppMethodBeat.i(4171);
        boolean notifyRunTimer = xWAppBrandEngine.notifyRunTimer(j, i);
        AppMethodBeat.o(4171);
        return notifyRunTimer;
    }

    public XWAppBrandEngine() {
        AppMethodBeat.i(4168);
        AppMethodBeat.o(4168);
    }

    @Keep
    public int setTimer(int i, boolean z) {
        AppMethodBeat.i(4169);
        int i2 = this.ARI + 1;
        this.ARI = i2;
        a aVar = new a(i2, z);
        this.ARJ.put(Integer.valueOf(i2), aVar);
        if (i <= 0) {
            i = 1;
        }
        if (z) {
            this.mTimer.schedule(aVar, (long) i, (long) i);
        } else {
            this.mTimer.schedule(aVar, (long) i);
        }
        AppMethodBeat.o(4169);
        return i2;
    }

    @Keep
    public void clearTimer(int i) {
        AppMethodBeat.i(4170);
        if (this.ARJ.containsKey(Integer.valueOf(i))) {
            ((a) this.ARJ.get(Integer.valueOf(i))).cancel();
            this.ARJ.remove(Integer.valueOf(i));
            AppMethodBeat.o(4170);
            return;
        }
        AppMethodBeat.o(4170);
    }

    @Keep
    public void onLog(int i, String str) {
        String[] strArr = new String[]{"debug", "log", "info", "warn", "error"};
    }

    static {
        AppMethodBeat.i(4172);
        ClassLoader classLoader = XWAppBrandEngine.class.getClassLoader();
        k.a("mmv8", classLoader);
        k.a("jsengine", classLoader);
        AppMethodBeat.o(4172);
    }

    @Keep
    public static void reportException(String str, String str2, long j) {
        if (ARM != null) {
        }
    }
}
