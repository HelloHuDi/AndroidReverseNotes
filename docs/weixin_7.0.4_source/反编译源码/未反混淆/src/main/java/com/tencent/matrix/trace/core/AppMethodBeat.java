package com.tencent.matrix.trace.core;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.d.b;
import com.tencent.matrix.d.c;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AppMethodBeat {
    public static final int METHOD_ID_DISPATCH = 1048574;
    private static final int METHOD_ID_MAX = 1048575;
    private static final int STATUS_DEFAULT = Integer.MAX_VALUE;
    private static final int STATUS_EXPIRED_START = -2;
    private static final int STATUS_OUT_RELEASE = -3;
    private static final int STATUS_READY = 1;
    private static final int STATUS_STARTED = 2;
    private static final int STATUS_STOPPED = -1;
    private static final String TAG = "Matrix.AppMethodBeat";
    private static boolean assertIn = false;
    private static Runnable checkStartExpiredRunnable = null;
    private static boolean isPauseUpdateTime = false;
    private static HashSet<com.tencent.matrix.trace.e.a> listeners = new HashSet();
    private static long[] sBuffer = new long[1000000];
    private static volatile long sCurrentDiffTime;
    private static volatile long sDiffTime;
    private static Set<String> sFocusActivitySet = new HashSet();
    private static String sFocusedActivity = "default";
    private static Handler sHandler = new Handler(sTimerUpdateThread.getLooper());
    private static int sIndex = 0;
    private static a sIndexRecordHead = null;
    private static AppMethodBeat sInstance = new AppMethodBeat();
    private static int sLastIndex = -1;
    private static Thread sMainThread = Looper.getMainLooper().getThread();
    private static HandlerThread sTimerUpdateThread = b.cj("matrix_time_update_thread");
    private static Runnable sUpdateDiffTimeRunnable = new Runnable() {
        public final void run() {
            while (true) {
                try {
                    if (AppMethodBeat.isPauseUpdateTime || AppMethodBeat.status < 0) {
                        synchronized (AppMethodBeat.updateTimeLock) {
                            AppMethodBeat.updateTimeLock.wait();
                        }
                    } else {
                        AppMethodBeat.sCurrentDiffTime = SystemClock.uptimeMillis() - AppMethodBeat.sDiffTime;
                        SystemClock.sleep(5);
                    }
                } catch (InterruptedException e) {
                    c.e(AppMethodBeat.TAG, e.toString(), new Object[0]);
                    return;
                }
            }
        }
    };
    private static volatile int status = Integer.MAX_VALUE;
    private static Object statusLock = new Object();
    private static Object updateTimeLock = new Object();

    public static final class a {
        a bYM;
        public boolean bYN;
        public int index;
        public String source;

        public a(int i) {
            this.bYN = true;
            this.index = i;
        }

        public a() {
            this.bYN = true;
            this.bYN = false;
        }

        public final void release() {
            this.bYN = false;
            a aVar = null;
            for (a access$1000 = AppMethodBeat.sIndexRecordHead; access$1000 != null; access$1000 = access$1000.bYM) {
                if (access$1000 == this) {
                    if (aVar != null) {
                        aVar.bYM = access$1000.bYM;
                    } else {
                        AppMethodBeat.sIndexRecordHead = access$1000.bYM;
                    }
                    access$1000.bYM = null;
                    return;
                }
                aVar = access$1000;
            }
        }

        public final String toString() {
            return "index:" + this.index + ",\tisValid:" + this.bYN + " source:" + this.source;
        }
    }

    static {
        long uptimeMillis = SystemClock.uptimeMillis();
        sCurrentDiffTime = uptimeMillis;
        sDiffTime = uptimeMillis;
        sHandler.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.realRelease();
            }
        }, 15000);
    }

    public static AppMethodBeat getInstance() {
        return sInstance;
    }

    public void onStart() {
        synchronized (statusLock) {
            if (status >= 2 || status < -2) {
                c.w(TAG, "[onStart] current status:%s", Integer.valueOf(status));
            } else {
                sHandler.removeCallbacks(checkStartExpiredRunnable);
                if (sBuffer == null) {
                    throw new RuntimeException("Matrix.AppMethodBeat sBuffer == null");
                }
                c.i(TAG, "[onStart] preStatus:%s", Integer.valueOf(status), com.tencent.matrix.trace.g.b.getStack());
                status = 2;
            }
        }
    }

    public void onStop() {
        synchronized (statusLock) {
            if (status == 2) {
                c.i(TAG, "[onStop] %s", com.tencent.matrix.trace.g.b.getStack());
                status = -1;
            } else {
                c.w(TAG, "[onStop] current status:%s", Integer.valueOf(status));
            }
        }
    }

    public boolean isAlive() {
        return status >= 2;
    }

    public static boolean isRealTrace() {
        return status > 0;
    }

    private static void realRelease() {
        synchronized (statusLock) {
            if (status == Integer.MAX_VALUE) {
                c.i(TAG, "[realRelease] timestamp:%s", Long.valueOf(System.currentTimeMillis()));
                sHandler.removeCallbacksAndMessages(null);
                sTimerUpdateThread.quit();
                sBuffer = null;
                status = -3;
            }
        }
    }

    private static void realExecute() {
        c.i(TAG, "[realExecute] timestamp:%s", Long.valueOf(System.currentTimeMillis()));
        sCurrentDiffTime = SystemClock.uptimeMillis() - sDiffTime;
        sHandler.removeCallbacksAndMessages(null);
        sHandler.postDelayed(sUpdateDiffTimeRunnable, 5);
        Handler handler = sHandler;
        AnonymousClass3 anonymousClass3 = new Runnable() {
            public final void run() {
                synchronized (AppMethodBeat.statusLock) {
                    if (AppMethodBeat.status == Integer.MAX_VALUE || AppMethodBeat.status == 1) {
                        AppMethodBeat.status = -2;
                    }
                }
            }
        };
        checkStartExpiredRunnable = anonymousClass3;
        handler.postDelayed(anonymousClass3, 15000);
        com.tencent.matrix.trace.c.a.zy();
        a.a(new com.tencent.matrix.trace.core.a.a() {
            public final boolean isValid() {
                return AppMethodBeat.status > 0;
            }

            public final void dispatchStart() {
                super.dispatchStart();
                AppMethodBeat.dispatchBegin();
            }

            public final void dispatchEnd() {
                super.dispatchEnd();
                AppMethodBeat.dispatchEnd();
            }
        });
    }

    private static void dispatchBegin() {
        sCurrentDiffTime = SystemClock.uptimeMillis() - sDiffTime;
        isPauseUpdateTime = false;
        synchronized (updateTimeLock) {
            updateTimeLock.notifyAll();
        }
    }

    private static void dispatchEnd() {
        isPauseUpdateTime = true;
    }

    public static void i(int i) {
        if (status >= 0 && i < METHOD_ID_MAX) {
            if (status == Integer.MAX_VALUE) {
                synchronized (statusLock) {
                    if (status == Integer.MAX_VALUE) {
                        realExecute();
                        status = 1;
                    }
                }
            }
            if (Thread.currentThread() == sMainThread && !assertIn) {
                assertIn = true;
                if (sIndex < 1000000) {
                    mergeData(i, sIndex, true);
                } else {
                    sIndex = -1;
                }
                sIndex++;
                assertIn = false;
            }
        }
    }

    public static void o(int i) {
        if (status >= 0 && i < METHOD_ID_MAX && Thread.currentThread() == sMainThread) {
            if (sIndex < 1000000) {
                mergeData(i, sIndex, false);
            } else {
                sIndex = -1;
            }
            sIndex++;
        }
    }

    public static void at(Activity activity, boolean z) {
        String name = activity.getClass().getName();
        String str;
        String str2;
        Object[] objArr;
        if (z) {
            sFocusedActivity = name;
            if (sFocusActivitySet.add(name)) {
                String str3;
                synchronized (listeners) {
                    Iterator it = listeners.iterator();
                    while (it.hasNext()) {
                        ((com.tencent.matrix.trace.e.a) it.next()).ch(name);
                    }
                }
                str = TAG;
                str2 = "[at] Activity[%s] has %s focus!";
                objArr = new Object[2];
                objArr[0] = name;
                if (z) {
                    str3 = "attach";
                } else {
                    str3 = "detach";
                }
                objArr[1] = str3;
                c.i(str, str2, objArr);
                return;
            }
            return;
        }
        if (sFocusedActivity.equals(name)) {
            sFocusedActivity = "default";
        }
        if (sFocusActivitySet.remove(name)) {
            str = TAG;
            str2 = "[at] Activity[%s] has %s focus!";
            objArr = new Object[2];
            objArr[0] = name;
            objArr[1] = z ? "attach" : "detach";
            c.i(str, str2, objArr);
        }
    }

    public static String getFocusedActivity() {
        return sFocusedActivity;
    }

    private static void mergeData(int i, int i2, boolean z) {
        long j = 0;
        if (z) {
            j = Long.MIN_VALUE;
        }
        sBuffer[i2] = (j | (((long) i) << 43)) | (sCurrentDiffTime & 8796093022207L);
        checkPileup(i2);
        sLastIndex = i2;
    }

    public void addListener(com.tencent.matrix.trace.e.a aVar) {
        synchronized (listeners) {
            listeners.add(aVar);
        }
    }

    public void removeListener(com.tencent.matrix.trace.e.a aVar) {
        synchronized (listeners) {
            listeners.remove(aVar);
        }
    }

    public a maskIndex(String str) {
        a aVar;
        if (sIndexRecordHead == null) {
            aVar = new a(sIndex - 1);
            sIndexRecordHead = aVar;
            aVar.source = str;
            return sIndexRecordHead;
        }
        aVar = new a(sIndex - 1);
        aVar.source = str;
        a aVar2 = sIndexRecordHead;
        a aVar3 = null;
        while (aVar2 != null) {
            if (aVar.index > aVar2.index) {
                aVar3 = aVar2;
                aVar2 = aVar2.bYM;
            } else if (aVar3 == null) {
                aVar3 = sIndexRecordHead;
                sIndexRecordHead = aVar;
                aVar.bYM = aVar3;
                return aVar;
            } else {
                aVar2 = aVar3.bYM;
                aVar3.bYM = aVar;
                aVar.bYM = aVar2;
                return aVar;
            }
        }
        aVar3.bYM = aVar;
        return aVar;
    }

    private static void checkPileup(int i) {
        a aVar = sIndexRecordHead;
        while (aVar != null) {
            if (aVar.index == i || (aVar.index == -1 && sLastIndex == 999999)) {
                aVar.bYN = false;
                c.w(TAG, "[checkPileup] %s", aVar.toString());
                aVar = aVar.bYM;
                sIndexRecordHead = aVar;
            } else {
                return;
            }
        }
    }

    public long[] copyData(a aVar) {
        return copyData(aVar, new a(sIndex - 1));
    }

    public long[] copyData(a aVar, a aVar2) {
        long currentTimeMillis = System.currentTimeMillis();
        long[] jArr = new long[0];
        try {
            if (aVar.bYN && aVar2.bYN) {
                int max = Math.max(0, aVar.index);
                int max2 = Math.max(0, aVar2.index);
                if (max2 > max) {
                    max2 = (max2 - max) + 1;
                    jArr = new long[max2];
                    System.arraycopy(sBuffer, max, jArr, 0, max2);
                } else if (max2 < max) {
                    jArr = new long[((max2 + 1) + (sBuffer.length - max))];
                    System.arraycopy(sBuffer, max, jArr, 0, sBuffer.length - max);
                    System.arraycopy(sBuffer, 0, jArr, sBuffer.length - max, max2 + 1);
                }
                c.i(TAG, "[copyData] [%s:%s] cost:%sms", Integer.valueOf(Math.max(0, aVar.index)), Integer.valueOf(aVar2.index), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return jArr;
            }
            c.i(TAG, "[copyData] [%s:%s] cost:%sms", Integer.valueOf(Math.max(0, aVar.index)), Integer.valueOf(aVar2.index), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return jArr;
        } catch (Exception e) {
            c.e(TAG, e.toString(), new Object[0]);
            c.i(TAG, "[copyData] [%s:%s] cost:%sms", Integer.valueOf(Math.max(0, aVar.index)), Integer.valueOf(aVar2.index), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable th) {
            c.i(TAG, "[copyData] [%s:%s] cost:%sms", Integer.valueOf(Math.max(0, aVar.index)), Integer.valueOf(aVar2.index), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static long getDiffTime() {
        return sDiffTime;
    }

    public void printIndexRecord() {
        StringBuilder stringBuilder = new StringBuilder(" \n");
        for (Object obj = sIndexRecordHead; obj != null; obj = obj.bYM) {
            stringBuilder.append(obj).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        c.i(TAG, "[printIndexRecord] %s", stringBuilder.toString());
    }

    private static <T> T reflectObject(Object obj, String str) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e) {
            c.e(TAG, e.toString(), new Object[0]);
            return null;
        }
    }
}
