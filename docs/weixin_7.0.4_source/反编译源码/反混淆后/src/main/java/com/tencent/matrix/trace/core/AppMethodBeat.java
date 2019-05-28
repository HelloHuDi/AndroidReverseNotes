package com.tencent.matrix.trace.core;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.p157d.C1068b;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.trace.core.C1145a.C1144a;
import com.tencent.matrix.trace.p172c.C1137a;
import com.tencent.matrix.trace.p174e.C1152a;
import com.tencent.matrix.trace.p176g.C1167b;
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
    private static HashSet<C1152a> listeners = new HashSet();
    private static long[] sBuffer = new long[1000000];
    private static volatile long sCurrentDiffTime;
    private static volatile long sDiffTime;
    private static Set<String> sFocusActivitySet = new HashSet();
    private static String sFocusedActivity = "default";
    private static Handler sHandler = new Handler(sTimerUpdateThread.getLooper());
    private static int sIndex = 0;
    private static C1141a sIndexRecordHead = null;
    private static AppMethodBeat sInstance = new AppMethodBeat();
    private static int sLastIndex = -1;
    private static Thread sMainThread = Looper.getMainLooper().getThread();
    private static HandlerThread sTimerUpdateThread = C1068b.m2356cj("matrix_time_update_thread");
    private static Runnable sUpdateDiffTimeRunnable = new C11392();
    private static volatile int status = Integer.MAX_VALUE;
    private static Object statusLock = new Object();
    private static Object updateTimeLock = new Object();

    /* renamed from: com.tencent.matrix.trace.core.AppMethodBeat$1 */
    static class C11381 implements Runnable {
        C11381() {
        }

        public final void run() {
            AppMethodBeat.realRelease();
        }
    }

    /* renamed from: com.tencent.matrix.trace.core.AppMethodBeat$2 */
    static class C11392 implements Runnable {
        C11392() {
        }

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
                    C1070c.m2367e(AppMethodBeat.TAG, e.toString(), new Object[0]);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.matrix.trace.core.AppMethodBeat$3 */
    static class C11403 implements Runnable {
        C11403() {
        }

        public final void run() {
            synchronized (AppMethodBeat.statusLock) {
                if (AppMethodBeat.status == Integer.MAX_VALUE || AppMethodBeat.status == 1) {
                    AppMethodBeat.status = -2;
                }
            }
        }
    }

    /* renamed from: com.tencent.matrix.trace.core.AppMethodBeat$a */
    public static final class C1141a {
        C1141a bYM;
        public boolean bYN;
        public int index;
        public String source;

        public C1141a(int i) {
            this.bYN = true;
            this.index = i;
        }

        public C1141a() {
            this.bYN = true;
            this.bYN = false;
        }

        public final void release() {
            this.bYN = false;
            C1141a c1141a = null;
            for (C1141a access$1000 = AppMethodBeat.sIndexRecordHead; access$1000 != null; access$1000 = access$1000.bYM) {
                if (access$1000 == this) {
                    if (c1141a != null) {
                        c1141a.bYM = access$1000.bYM;
                    } else {
                        AppMethodBeat.sIndexRecordHead = access$1000.bYM;
                    }
                    access$1000.bYM = null;
                    return;
                }
                c1141a = access$1000;
            }
        }

        public final String toString() {
            return "index:" + this.index + ",\tisValid:" + this.bYN + " source:" + this.source;
        }
    }

    /* renamed from: com.tencent.matrix.trace.core.AppMethodBeat$4 */
    static class C11424 extends C1144a {
        C11424() {
        }

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
    }

    static {
        long uptimeMillis = SystemClock.uptimeMillis();
        sCurrentDiffTime = uptimeMillis;
        sDiffTime = uptimeMillis;
        sHandler.postDelayed(new C11381(), 15000);
    }

    public static AppMethodBeat getInstance() {
        return sInstance;
    }

    public void onStart() {
        synchronized (statusLock) {
            if (status >= 2 || status < -2) {
                C1070c.m2370w(TAG, "[onStart] current status:%s", Integer.valueOf(status));
            } else {
                sHandler.removeCallbacks(checkStartExpiredRunnable);
                if (sBuffer == null) {
                    throw new RuntimeException("Matrix.AppMethodBeat sBuffer == null");
                }
                C1070c.m2368i(TAG, "[onStart] preStatus:%s", Integer.valueOf(status), C1167b.getStack());
                status = 2;
            }
        }
    }

    public void onStop() {
        synchronized (statusLock) {
            if (status == 2) {
                C1070c.m2368i(TAG, "[onStop] %s", C1167b.getStack());
                status = -1;
            } else {
                C1070c.m2370w(TAG, "[onStop] current status:%s", Integer.valueOf(status));
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
                C1070c.m2368i(TAG, "[realRelease] timestamp:%s", Long.valueOf(System.currentTimeMillis()));
                sHandler.removeCallbacksAndMessages(null);
                sTimerUpdateThread.quit();
                sBuffer = null;
                status = -3;
            }
        }
    }

    private static void realExecute() {
        C1070c.m2368i(TAG, "[realExecute] timestamp:%s", Long.valueOf(System.currentTimeMillis()));
        sCurrentDiffTime = SystemClock.uptimeMillis() - sDiffTime;
        sHandler.removeCallbacksAndMessages(null);
        sHandler.postDelayed(sUpdateDiffTimeRunnable, 5);
        Handler handler = sHandler;
        C11403 c11403 = new C11403();
        checkStartExpiredRunnable = c11403;
        handler.postDelayed(c11403, 15000);
        C1137a.m2501zy();
        C1145a.m2506a(new C11424());
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

    /* renamed from: i */
    public static void m2504i(int i) {
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

    /* renamed from: o */
    public static void m2505o(int i) {
        if (status >= 0 && i < METHOD_ID_MAX && Thread.currentThread() == sMainThread) {
            if (sIndex < 1000000) {
                mergeData(i, sIndex, false);
            } else {
                sIndex = -1;
            }
            sIndex++;
        }
    }

    /* renamed from: at */
    public static void m2503at(Activity activity, boolean z) {
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
                        ((C1152a) it.next()).mo4385ch(name);
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
                C1070c.m2368i(str, str2, objArr);
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
            C1070c.m2368i(str, str2, objArr);
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

    public void addListener(C1152a c1152a) {
        synchronized (listeners) {
            listeners.add(c1152a);
        }
    }

    public void removeListener(C1152a c1152a) {
        synchronized (listeners) {
            listeners.remove(c1152a);
        }
    }

    public C1141a maskIndex(String str) {
        C1141a c1141a;
        if (sIndexRecordHead == null) {
            c1141a = new C1141a(sIndex - 1);
            sIndexRecordHead = c1141a;
            c1141a.source = str;
            return sIndexRecordHead;
        }
        c1141a = new C1141a(sIndex - 1);
        c1141a.source = str;
        C1141a c1141a2 = sIndexRecordHead;
        C1141a c1141a3 = null;
        while (c1141a2 != null) {
            if (c1141a.index > c1141a2.index) {
                c1141a3 = c1141a2;
                c1141a2 = c1141a2.bYM;
            } else if (c1141a3 == null) {
                c1141a3 = sIndexRecordHead;
                sIndexRecordHead = c1141a;
                c1141a.bYM = c1141a3;
                return c1141a;
            } else {
                c1141a2 = c1141a3.bYM;
                c1141a3.bYM = c1141a;
                c1141a.bYM = c1141a2;
                return c1141a;
            }
        }
        c1141a3.bYM = c1141a;
        return c1141a;
    }

    private static void checkPileup(int i) {
        C1141a c1141a = sIndexRecordHead;
        while (c1141a != null) {
            if (c1141a.index == i || (c1141a.index == -1 && sLastIndex == 999999)) {
                c1141a.bYN = false;
                C1070c.m2370w(TAG, "[checkPileup] %s", c1141a.toString());
                c1141a = c1141a.bYM;
                sIndexRecordHead = c1141a;
            } else {
                return;
            }
        }
    }

    public long[] copyData(C1141a c1141a) {
        return copyData(c1141a, new C1141a(sIndex - 1));
    }

    public long[] copyData(C1141a c1141a, C1141a c1141a2) {
        long currentTimeMillis = System.currentTimeMillis();
        long[] jArr = new long[0];
        try {
            if (c1141a.bYN && c1141a2.bYN) {
                int max = Math.max(0, c1141a.index);
                int max2 = Math.max(0, c1141a2.index);
                if (max2 > max) {
                    max2 = (max2 - max) + 1;
                    jArr = new long[max2];
                    System.arraycopy(sBuffer, max, jArr, 0, max2);
                } else if (max2 < max) {
                    jArr = new long[((max2 + 1) + (sBuffer.length - max))];
                    System.arraycopy(sBuffer, max, jArr, 0, sBuffer.length - max);
                    System.arraycopy(sBuffer, 0, jArr, sBuffer.length - max, max2 + 1);
                }
                C1070c.m2368i(TAG, "[copyData] [%s:%s] cost:%sms", Integer.valueOf(Math.max(0, c1141a.index)), Integer.valueOf(c1141a2.index), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return jArr;
            }
            C1070c.m2368i(TAG, "[copyData] [%s:%s] cost:%sms", Integer.valueOf(Math.max(0, c1141a.index)), Integer.valueOf(c1141a2.index), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return jArr;
        } catch (Exception e) {
            C1070c.m2367e(TAG, e.toString(), new Object[0]);
            C1070c.m2368i(TAG, "[copyData] [%s:%s] cost:%sms", Integer.valueOf(Math.max(0, c1141a.index)), Integer.valueOf(c1141a2.index), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable th) {
            C1070c.m2368i(TAG, "[copyData] [%s:%s] cost:%sms", Integer.valueOf(Math.max(0, c1141a.index)), Integer.valueOf(c1141a2.index), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
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
        C1070c.m2368i(TAG, "[printIndexRecord] %s", stringBuilder.toString());
    }

    private static <T> T reflectObject(Object obj, String str) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e) {
            C1070c.m2367e(TAG, e.toString(), new Object[0]);
            return null;
        }
    }
}
