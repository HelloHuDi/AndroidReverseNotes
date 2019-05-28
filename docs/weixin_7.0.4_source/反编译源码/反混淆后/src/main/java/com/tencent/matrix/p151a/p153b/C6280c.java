package com.tencent.matrix.p151a.p153b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.content.Context;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.WorkSource;
import com.tencent.matrix.p151a.C7462a;
import com.tencent.matrix.p151a.p152a.C1024a;
import com.tencent.matrix.p151a.p153b.C1036b.C1033c;
import com.tencent.matrix.p151a.p153b.C1047e.C1045b;
import com.tencent.matrix.p151a.p153b.C6278a.C1025a;
import com.tencent.matrix.p151a.p153b.C6278a.C1026b;
import com.tencent.matrix.p151a.p153b.C6278a.C1029e;
import com.tencent.matrix.p151a.p153b.C6281f.C1050a;
import com.tencent.matrix.p151a.p153b.C6281f.C1052c;
import com.tencent.matrix.p151a.p153b.C6281f.C1053d;
import com.tencent.matrix.p151a.p153b.C6281f.C1054e;
import com.tencent.matrix.p151a.p154c.C1055a;
import com.tencent.matrix.p156c.C1062b;
import com.tencent.matrix.p156c.C1064c.C1063a;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.p157d.C1073d;
import com.tencent.sqlitelint.util.SQLiteLintUtil;

/* renamed from: com.tencent.matrix.a.b.c */
public final class C6280c implements C1033c, C1045b, C1063a {
    private final C1024a bUD;
    final C1043d bVj = new C1043d();
    private final C7462a bVk;
    C6281f bVl;
    C6278a bVm;
    final Context mContext;
    private boolean mIsStart;

    /* renamed from: com.tencent.matrix.a.b.c$4 */
    class C10404 implements Runnable {
        C10404() {
        }

        public final void run() {
            C6280c.this.bVm.mo14510yP();
        }
    }

    /* renamed from: com.tencent.matrix.a.b.c$3 */
    class C62793 implements C1050a {
        C62793() {
        }

        /* renamed from: e */
        public final void mo4182e(Runnable runnable, long j) {
            C6280c.this.bVj.mDetectHandler.postDelayed(runnable, j);
        }

        public final boolean isScreenOn() {
            return ((PowerManager) C6280c.this.mContext.getSystemService("power")).isScreenOn();
        }
    }

    public C6280c(C7462a c7462a) {
        this.bUD = c7462a.bUD;
        this.bVk = c7462a;
        this.mContext = c7462a.getApplication();
    }

    public final void start() {
        this.bVj.start();
        m10282a(this.bUD);
        synchronized (this) {
            this.mIsStart = true;
        }
    }

    public final void stop() {
        synchronized (this) {
            this.mIsStart = false;
        }
        C1047e.m2327b(this);
        C1036b.m2318b(this);
        this.bVj.quit();
        this.bVl = null;
    }

    /* renamed from: a */
    public final void mo4180a(IBinder iBinder, int i, String str, String str2, WorkSource workSource, String str3) {
        if (this.bVl != null) {
            final String throwableStack = C1055a.getThrowableStack(new Throwable());
            final long currentTimeMillis = System.currentTimeMillis();
            final IBinder iBinder2 = iBinder;
            final int i2 = i;
            final String str4 = str;
            final String str5 = str2;
            final WorkSource workSource2 = workSource;
            final String str6 = str3;
            this.bVj.mo4176j(new Runnable() {
                public final void run() {
                    C1053d c1053d;
                    C6281f c6281f = C6280c.this.bVl;
                    IBinder iBinder = iBinder2;
                    int i = i2;
                    String str = str4;
                    String str2 = throwableStack;
                    long j = currentTimeMillis;
                    C1070c.m2368i("Matrix.WakeLockDetector", "onAcquireWakeLock token:%s tag:%s", iBinder, str);
                    if (c6281f.bVK != null) {
                        C1054e c1054e = c6281f.bVK;
                        c1054e.bVZ.append(C1073d.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, j)).append(" onAcquireWakeLock token:").append(iBinder.toString()).append(" flags:").append(i).append(" tag:").append(str).append(10).append(str2).append(10);
                        c1054e.bVY++;
                        c1054e.mo4187yY();
                    }
                    String obj = iBinder.toString();
                    if (c6281f.bVD.containsKey(obj)) {
                        c1053d = (C1053d) c6281f.bVD.get(obj);
                    } else {
                        c1053d = new C1053d(obj, str, i, j);
                        c6281f.bVD.put(obj, c1053d);
                    }
                    c1053d.bVS.mo4184cd(str2);
                    if (!c6281f.bVE.containsKey(str)) {
                        c6281f.bVE.put(str, new C1052c(str));
                    }
                    C1052c c1052c = (C1052c) c6281f.bVE.get(str);
                    boolean isScreenOn = c6281f.bVI.isScreenOn();
                    c1052c.bVV = isScreenOn;
                    c1052c.bVQ++;
                    if (!isScreenOn) {
                        c1052c.bVR++;
                    }
                    c1052c.bVT.put(obj, Boolean.TRUE);
                    if (c1052c.bVU < 0) {
                        c1052c.bVU = System.currentTimeMillis();
                    }
                    c1052c.bVS.mo4184cd(str2);
                    c6281f.bVI.mo4182e(c6281f.bVJ, (long) c6281f.bVF);
                }
            });
        }
    }

    /* renamed from: a */
    public final void mo4179a(IBinder iBinder, int i) {
        if (this.bVl != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            final IBinder iBinder2 = iBinder;
            final int i2 = i;
            this.bVj.mo4176j(new Runnable() {
                public final void run() {
                    int i = 1;
                    C6281f c6281f = C6280c.this.bVl;
                    IBinder iBinder = iBinder2;
                    int i2 = i2;
                    long j = currentTimeMillis;
                    C1070c.m2368i("Matrix.WakeLockDetector", "onReleaseWakeLock token:%s", iBinder);
                    if (c6281f.bVK != null) {
                        C1054e c1054e = c6281f.bVK;
                        c1054e.bVZ.append(C1073d.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, j)).append(" onReleaseWakeLock token:").append(iBinder.toString()).append(" flags:").append(i2).append("\n\n");
                        c1054e.bVY++;
                        c1054e.mo4187yY();
                    }
                    String obj = iBinder.toString();
                    if (c6281f.bVD.containsKey(obj)) {
                        String str = ((C1053d) c6281f.bVD.get(obj)).tag;
                        if (c6281f.bVE.containsKey(str)) {
                            C1052c c1052c = (C1052c) c6281f.bVE.get(str);
                            c1052c.mo4186yX();
                            c1052c.bVT.remove(obj);
                            if (c1052c.bVT.isEmpty()) {
                                i = 0;
                            }
                            if (i == 0) {
                                c1052c.bVU = -1;
                            }
                        }
                    } else {
                        C1070c.m2368i("Matrix.WakeLockDetector", "onReleaseWakeLock not in mWakeLockInfoMap: %s", obj);
                    }
                    c6281f.mo14513yU();
                    c6281f.bVD.remove(obj);
                }
            });
        }
    }

    public final void onDetectIssue(C1062b c1062b) {
        this.bVk.onDetectIssue(c1062b);
    }

    /* renamed from: a */
    private void m10282a(C1024a c1024a) {
        if (c1024a == null) {
            throw new RuntimeException("batteryConfig is null");
        }
        if (c1024a.mo4161yL()) {
            this.bVl = new C6281f(this, c1024a, new C62793());
            C1047e.m2325a(this);
        }
        if (c1024a.mo4162yM()) {
            this.bVm = new C6278a(this, this.bUD);
            this.bVj.mo4176j(new C10404());
            C1036b.m2316a(this);
        }
    }

    /* renamed from: a */
    public final void mo4168a(int i, long j, long j2, long j3, int i2, PendingIntent pendingIntent, OnAlarmListener onAlarmListener) {
        if (this.bVm != null) {
            final String throwableStack = C1055a.getThrowableStack(new Throwable());
            final int i3 = i;
            final long j4 = j;
            final long j5 = j2;
            final long j6 = j3;
            final int i4 = i2;
            final PendingIntent pendingIntent2 = pendingIntent;
            final OnAlarmListener onAlarmListener2 = onAlarmListener;
            this.bVj.mo4176j(new Runnable() {
                public final void run() {
                    C6278a c6278a = C6280c.this.bVm;
                    int i = i3;
                    long j = j4;
                    long j2 = j5;
                    long j3 = j6;
                    int i2 = i4;
                    PendingIntent pendingIntent = pendingIntent2;
                    OnAlarmListener onAlarmListener = onAlarmListener2;
                    String str = throwableStack;
                    if (c6278a.bUK != null) {
                        C1026b c1026b = c6278a.bUK;
                        try {
                            String str2 = "%s onAlarmSet type:%d triggerAtMillis:%d windowMillis:%d intervalMillis:%d flags:%d operationInfo:%s operationHashCode:%d onAlarmListener:%s onAlarmListenerHashCode:%d\n%s\n\n";
                            Object[] objArr = new Object[11];
                            objArr[0] = C1073d.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, System.currentTimeMillis());
                            objArr[1] = Integer.valueOf(i);
                            objArr[2] = Long.valueOf(j);
                            objArr[3] = Long.valueOf(j2);
                            objArr[4] = Long.valueOf(j3);
                            objArr[5] = Integer.valueOf(i2);
                            objArr[6] = pendingIntent;
                            objArr[7] = Integer.valueOf(pendingIntent == null ? -1 : pendingIntent.hashCode());
                            objArr[8] = onAlarmListener;
                            objArr[9] = Integer.valueOf(onAlarmListener == null ? -1 : onAlarmListener.hashCode());
                            objArr[10] = str;
                            c1026b.mo4166cc(String.format(str2, objArr));
                        } catch (ClassCastException e) {
                            C1070c.m2367e("MicroMsg.AlarmDetector", e.toString(), new Object[0]);
                        }
                    }
                    C1025a c1025a = new C1025a(i, j, j3, pendingIntent, onAlarmListener, str);
                    c6278a.mo14509a(c1025a.bUQ, c1025a.bUP);
                    c6278a.bUL.add(c1025a);
                    c6278a.mo14510yP();
                }
            });
        }
    }

    /* renamed from: a */
    public final void mo4169a(final PendingIntent pendingIntent, final OnAlarmListener onAlarmListener) {
        final String throwableStack = C1055a.getThrowableStack(new Throwable());
        this.bVj.mo4176j(new Runnable() {
            public final void run() {
                int i = -1;
                C6278a c6278a = C6280c.this.bVm;
                PendingIntent pendingIntent = pendingIntent;
                OnAlarmListener onAlarmListener = onAlarmListener;
                String str = throwableStack;
                if (c6278a.bUK != null) {
                    C1026b c1026b = c6278a.bUK;
                    try {
                        int i2;
                        String str2 = "%s onAlarmRemove operationInfo:%s operationHashCode:%d onAlarmListener:%s onAlarmListenerHashCode:%d\n%s\n\n";
                        Object[] objArr = new Object[6];
                        objArr[0] = C1073d.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, System.currentTimeMillis());
                        objArr[1] = pendingIntent;
                        if (pendingIntent == null) {
                            i2 = -1;
                        } else {
                            i2 = pendingIntent.hashCode();
                        }
                        objArr[2] = Integer.valueOf(i2);
                        objArr[3] = onAlarmListener;
                        if (onAlarmListener != null) {
                            i = onAlarmListener.hashCode();
                        }
                        objArr[4] = Integer.valueOf(i);
                        objArr[5] = str;
                        c1026b.mo4166cc(String.format(str2, objArr));
                    } catch (ClassCastException e) {
                        C1070c.m2367e("MicroMsg.AlarmDetector", e.toString(), new Object[0]);
                    }
                }
                c6278a.mo14509a(onAlarmListener, new C1029e(pendingIntent));
                c6278a.mo14510yP();
            }
        });
    }
}
