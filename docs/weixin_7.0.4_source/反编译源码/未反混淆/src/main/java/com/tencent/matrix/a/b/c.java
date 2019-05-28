package com.tencent.matrix.a.b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.content.Context;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.WorkSource;
import com.tencent.matrix.a.b.e.b;
import com.tencent.matrix.c.c.a;
import com.tencent.matrix.d.d;
import com.tencent.sqlitelint.util.SQLiteLintUtil;

public final class c implements com.tencent.matrix.a.b.b.c, b, a {
    private final com.tencent.matrix.a.a.a bUD;
    final d bVj = new d();
    private final com.tencent.matrix.a.a bVk;
    f bVl;
    a bVm;
    final Context mContext;
    private boolean mIsStart;

    public c(com.tencent.matrix.a.a aVar) {
        this.bUD = aVar.bUD;
        this.bVk = aVar;
        this.mContext = aVar.getApplication();
    }

    public final void start() {
        this.bVj.start();
        a(this.bUD);
        synchronized (this) {
            this.mIsStart = true;
        }
    }

    public final void stop() {
        synchronized (this) {
            this.mIsStart = false;
        }
        e.b(this);
        b.b(this);
        this.bVj.quit();
        this.bVl = null;
    }

    public final void a(IBinder iBinder, int i, String str, String str2, WorkSource workSource, String str3) {
        if (this.bVl != null) {
            final String throwableStack = com.tencent.matrix.a.c.a.getThrowableStack(new Throwable());
            final long currentTimeMillis = System.currentTimeMillis();
            final IBinder iBinder2 = iBinder;
            final int i2 = i;
            final String str4 = str;
            final String str5 = str2;
            final WorkSource workSource2 = workSource;
            final String str6 = str3;
            this.bVj.j(new Runnable() {
                public final void run() {
                    d dVar;
                    f fVar = c.this.bVl;
                    IBinder iBinder = iBinder2;
                    int i = i2;
                    String str = str4;
                    String str2 = throwableStack;
                    long j = currentTimeMillis;
                    com.tencent.matrix.d.c.i("Matrix.WakeLockDetector", "onAcquireWakeLock token:%s tag:%s", iBinder, str);
                    if (fVar.bVK != null) {
                        e eVar = fVar.bVK;
                        eVar.bVZ.append(d.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, j)).append(" onAcquireWakeLock token:").append(iBinder.toString()).append(" flags:").append(i).append(" tag:").append(str).append(10).append(str2).append(10);
                        eVar.bVY++;
                        eVar.yY();
                    }
                    String obj = iBinder.toString();
                    if (fVar.bVD.containsKey(obj)) {
                        dVar = (d) fVar.bVD.get(obj);
                    } else {
                        dVar = new d(obj, str, i, j);
                        fVar.bVD.put(obj, dVar);
                    }
                    dVar.bVS.cd(str2);
                    if (!fVar.bVE.containsKey(str)) {
                        fVar.bVE.put(str, new c(str));
                    }
                    c cVar = (c) fVar.bVE.get(str);
                    boolean isScreenOn = fVar.bVI.isScreenOn();
                    cVar.bVV = isScreenOn;
                    cVar.bVQ++;
                    if (!isScreenOn) {
                        cVar.bVR++;
                    }
                    cVar.bVT.put(obj, Boolean.TRUE);
                    if (cVar.bVU < 0) {
                        cVar.bVU = System.currentTimeMillis();
                    }
                    cVar.bVS.cd(str2);
                    fVar.bVI.e(fVar.bVJ, (long) fVar.bVF);
                }
            });
        }
    }

    public final void a(IBinder iBinder, int i) {
        if (this.bVl != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            final IBinder iBinder2 = iBinder;
            final int i2 = i;
            this.bVj.j(new Runnable() {
                public final void run() {
                    int i = 1;
                    f fVar = c.this.bVl;
                    IBinder iBinder = iBinder2;
                    int i2 = i2;
                    long j = currentTimeMillis;
                    com.tencent.matrix.d.c.i("Matrix.WakeLockDetector", "onReleaseWakeLock token:%s", iBinder);
                    if (fVar.bVK != null) {
                        e eVar = fVar.bVK;
                        eVar.bVZ.append(d.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, j)).append(" onReleaseWakeLock token:").append(iBinder.toString()).append(" flags:").append(i2).append("\n\n");
                        eVar.bVY++;
                        eVar.yY();
                    }
                    String obj = iBinder.toString();
                    if (fVar.bVD.containsKey(obj)) {
                        String str = ((d) fVar.bVD.get(obj)).tag;
                        if (fVar.bVE.containsKey(str)) {
                            c cVar = (c) fVar.bVE.get(str);
                            cVar.yX();
                            cVar.bVT.remove(obj);
                            if (cVar.bVT.isEmpty()) {
                                i = 0;
                            }
                            if (i == 0) {
                                cVar.bVU = -1;
                            }
                        }
                    } else {
                        com.tencent.matrix.d.c.i("Matrix.WakeLockDetector", "onReleaseWakeLock not in mWakeLockInfoMap: %s", obj);
                    }
                    fVar.yU();
                    fVar.bVD.remove(obj);
                }
            });
        }
    }

    public final void onDetectIssue(com.tencent.matrix.c.b bVar) {
        this.bVk.onDetectIssue(bVar);
    }

    private void a(com.tencent.matrix.a.a.a aVar) {
        if (aVar == null) {
            throw new RuntimeException("batteryConfig is null");
        }
        if (aVar.yL()) {
            this.bVl = new f(this, aVar, new f.a() {
                public final void e(Runnable runnable, long j) {
                    c.this.bVj.mDetectHandler.postDelayed(runnable, j);
                }

                public final boolean isScreenOn() {
                    return ((PowerManager) c.this.mContext.getSystemService("power")).isScreenOn();
                }
            });
            e.a(this);
        }
        if (aVar.yM()) {
            this.bVm = new a(this, this.bUD);
            this.bVj.j(new Runnable() {
                public final void run() {
                    c.this.bVm.yP();
                }
            });
            b.a(this);
        }
    }

    public final void a(int i, long j, long j2, long j3, int i2, PendingIntent pendingIntent, OnAlarmListener onAlarmListener) {
        if (this.bVm != null) {
            final String throwableStack = com.tencent.matrix.a.c.a.getThrowableStack(new Throwable());
            final int i3 = i;
            final long j4 = j;
            final long j5 = j2;
            final long j6 = j3;
            final int i4 = i2;
            final PendingIntent pendingIntent2 = pendingIntent;
            final OnAlarmListener onAlarmListener2 = onAlarmListener;
            this.bVj.j(new Runnable() {
                public final void run() {
                    a aVar = c.this.bVm;
                    int i = i3;
                    long j = j4;
                    long j2 = j5;
                    long j3 = j6;
                    int i2 = i4;
                    PendingIntent pendingIntent = pendingIntent2;
                    OnAlarmListener onAlarmListener = onAlarmListener2;
                    String str = throwableStack;
                    if (aVar.bUK != null) {
                        b bVar = aVar.bUK;
                        try {
                            String str2 = "%s onAlarmSet type:%d triggerAtMillis:%d windowMillis:%d intervalMillis:%d flags:%d operationInfo:%s operationHashCode:%d onAlarmListener:%s onAlarmListenerHashCode:%d\n%s\n\n";
                            Object[] objArr = new Object[11];
                            objArr[0] = d.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, System.currentTimeMillis());
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
                            bVar.cc(String.format(str2, objArr));
                        } catch (ClassCastException e) {
                            com.tencent.matrix.d.c.e("MicroMsg.AlarmDetector", e.toString(), new Object[0]);
                        }
                    }
                    a aVar2 = new a(i, j, j3, pendingIntent, onAlarmListener, str);
                    aVar.a(aVar2.bUQ, aVar2.bUP);
                    aVar.bUL.add(aVar2);
                    aVar.yP();
                }
            });
        }
    }

    public final void a(final PendingIntent pendingIntent, final OnAlarmListener onAlarmListener) {
        final String throwableStack = com.tencent.matrix.a.c.a.getThrowableStack(new Throwable());
        this.bVj.j(new Runnable() {
            public final void run() {
                int i = -1;
                a aVar = c.this.bVm;
                PendingIntent pendingIntent = pendingIntent;
                OnAlarmListener onAlarmListener = onAlarmListener;
                String str = throwableStack;
                if (aVar.bUK != null) {
                    b bVar = aVar.bUK;
                    try {
                        int i2;
                        String str2 = "%s onAlarmRemove operationInfo:%s operationHashCode:%d onAlarmListener:%s onAlarmListenerHashCode:%d\n%s\n\n";
                        Object[] objArr = new Object[6];
                        objArr[0] = d.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, System.currentTimeMillis());
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
                        bVar.cc(String.format(str2, objArr));
                    } catch (ClassCastException e) {
                        com.tencent.matrix.d.c.e("MicroMsg.AlarmDetector", e.toString(), new Object[0]);
                    }
                }
                aVar.a(onAlarmListener, new e(pendingIntent));
                aVar.yP();
            }
        });
    }
}
