package com.tencent.matrix.a.b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Environment;
import android.os.Parcel;
import android.os.SystemClock;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends com.tencent.matrix.c.c {
    private final int bUH;
    private final int bUI;
    private final f bUJ = new f();
    final b bUK;
    List<a> bUL;
    private long bUM;

    static final class a {
        final long bUN;
        final long bUO;
        final e bUP;
        final OnAlarmListener bUQ;
        long bUR;
        final String stackTrace;
        final int type;

        a(int i, long j, long j2, PendingIntent pendingIntent, OnAlarmListener onAlarmListener, String str) {
            long elapsedRealtime;
            this.type = i;
            if (i == 2 || i == 3) {
                elapsedRealtime = SystemClock.elapsedRealtime();
            } else {
                elapsedRealtime = System.currentTimeMillis();
            }
            elapsedRealtime += 5000;
            if (j < elapsedRealtime) {
                j = elapsedRealtime;
            }
            this.bUN = j;
            if (j2 > 0 && j2 < 60000) {
                j2 = 60000;
            }
            this.bUO = j2;
            this.bUP = new e(pendingIntent);
            this.bUQ = onAlarmListener;
            this.stackTrace = str;
            this.bUR = Long.MAX_VALUE;
        }

        a(int i, long j, long j2, e eVar, String str, long j3) {
            this.type = i;
            this.bUN = j;
            this.bUO = j2;
            this.bUP = eVar;
            this.bUQ = null;
            this.stackTrace = str;
            this.bUR = j3;
        }

        public final void yQ() {
            if (this.bUR == Long.MAX_VALUE) {
                this.bUR = System.currentTimeMillis();
            }
        }
    }

    static final class b {
        private final String bUS;

        b() {
            String formatTime = com.tencent.matrix.d.d.formatTime("yyyy-MM-dd", System.currentTimeMillis());
            this.bUS = String.format("%s/com.tencent.matrix/alarm-detector-record/%s/alarm-info-record-%s", new Object[]{Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.matrix.a.c.a.getPackageName(), formatTime});
            com.tencent.matrix.d.c.i("MicroMsg.AlarmDetector", "AlarmInfoRecorder path:%s", this.bUS);
        }

        /* Access modifiers changed, original: final */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x0067=Splitter:B:22:0x0067, B:15:0x004b=Splitter:B:15:0x004b} */
        /* JADX WARNING: Removed duplicated region for block: B:41:? A:{SYNTHETIC, RETURN, Catch:{ FileNotFoundException -> 0x004a, IOException -> 0x0066 }} */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0060 A:{SYNTHETIC, Splitter:B:18:0x0060} */
        /* JADX WARNING: Removed duplicated region for block: B:42:? A:{SYNTHETIC, RETURN, Catch:{ FileNotFoundException -> 0x004a, IOException -> 0x0066 }} */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x007c A:{SYNTHETIC, Splitter:B:25:0x007c} */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0085 A:{SYNTHETIC, Splitter:B:30:0x0085} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void cc(String str) {
            FileNotFoundException e;
            Throwable th;
            IOException e2;
            BufferedWriter bufferedWriter = null;
            try {
                File file = new File(this.bUS);
                if (file.getParentFile().mkdirs() || file.getParentFile().exists()) {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
                    try {
                        bufferedWriter2.write(str, 0, str.length());
                        bufferedWriter2.flush();
                        try {
                            bufferedWriter2.close();
                            return;
                        } catch (IOException e3) {
                            return;
                        }
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        bufferedWriter = bufferedWriter2;
                        try {
                            com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "doRecord exp:%s", e.getLocalizedMessage());
                            if (bufferedWriter == null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e5) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e6) {
                        e2 = e6;
                        bufferedWriter = bufferedWriter2;
                        com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "doRecord exp:%s", e2.getLocalizedMessage());
                        if (bufferedWriter == null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                        }
                        throw th;
                    }
                }
                com.tencent.matrix.d.c.e("MicroMsg.AlarmDetector", "doRecord mkdirs failed", new Object[0]);
            } catch (FileNotFoundException e7) {
                e = e7;
                com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "doRecord exp:%s", e.getLocalizedMessage());
                if (bufferedWriter == null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e8) {
                    }
                }
            } catch (IOException e9) {
                e2 = e9;
                com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "doRecord exp:%s", e2.getLocalizedMessage());
                if (bufferedWriter == null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e10) {
                    }
                }
            }
        }
    }

    static final class c implements Serializable {
        static final /* synthetic */ boolean $assertionsDisabled = (!a.class.desiredAssertionStatus());
        final long bUN;
        final long bUO;
        long bUR;
        final int bUT;
        final byte[] bUU;
        final String bUV;
        final String stackTrace;
        final int type;

        c(a aVar) {
            if ($assertionsDisabled || aVar != null) {
                this.type = aVar.type;
                this.bUN = aVar.bUN;
                this.bUO = aVar.bUO;
                this.bUT = aVar.bUP.bUT;
                this.bUU = a.k(aVar.bUP.bUZ);
                this.bUV = aVar.bUP.bUV;
                this.stackTrace = aVar.stackTrace;
                this.bUR = aVar.bUR;
                return;
            }
            throw new AssertionError();
        }
    }

    static final class d implements Serializable {
        private final List<c> bUL = new ArrayList();
        private final long bUM;

        d(List<a> list, long j) {
            if (list != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    this.bUL.add(new c((a) list.get(i2)));
                    i = i2 + 1;
                }
            }
            this.bUM = j;
        }

        public final List<a> yR() {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.bUL.size(); i++) {
                c cVar = (c) this.bUL.get(i);
                Intent v = a.u(cVar.bUU);
                if (v == null) {
                    com.tencent.matrix.d.c.e("MicroMsg.AlarmDetector", "bytesToIntent is null,  alarmInfoSet maybe invalid object", new Object[0]);
                } else {
                    arrayList.add(new a(cVar.type, cVar.bUN, cVar.bUO, new e(cVar.bUT, v, cVar.bUV), cVar.stackTrace, cVar.bUR));
                }
            }
            return arrayList;
        }
    }

    static final class e {
        private static Method bUW;
        private static Method bUX;
        final int bUT;
        final String bUV;
        final PendingIntent bUY;
        final Intent bUZ;

        e(PendingIntent pendingIntent) {
            this.bUY = pendingIntent;
            if (this.bUY != null) {
                this.bUT = pendingIntent.hashCode();
                this.bUZ = b(pendingIntent);
                this.bUV = c(pendingIntent);
                return;
            }
            this.bUT = -1;
            this.bUZ = null;
            this.bUV = null;
        }

        e(int i, Intent intent, String str) {
            this.bUY = null;
            this.bUT = i;
            this.bUZ = intent;
            this.bUV = str;
        }

        private static Intent b(PendingIntent pendingIntent) {
            if (pendingIntent == null) {
                return null;
            }
            if (bUW == null) {
                try {
                    Method declaredMethod = PendingIntent.class.getDeclaredMethod("getIntent", new Class[0]);
                    bUW = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "getOperationIntent e:%s", e);
                    return null;
                }
            }
            try {
                Object invoke = bUW.invoke(pendingIntent, new Object[0]);
                if (invoke instanceof Intent) {
                    return (Intent) invoke;
                }
                return null;
            } catch (IllegalAccessException e2) {
                com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "getOperationIntent e:%s", e2);
            } catch (InvocationTargetException e3) {
            } catch (SecurityException e4) {
                com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "getOperationIntent e:%s", e4);
            }
            return null;
        }

        private static String c(PendingIntent pendingIntent) {
            if (pendingIntent == null) {
                return null;
            }
            if (bUX == null) {
                try {
                    Method declaredMethod = PendingIntent.class.getDeclaredMethod("getTag", new Class[]{String.class});
                    bUX = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "getOperationIntentTag e:%s", e);
                    return null;
                }
            }
            try {
                Object invoke = bUX.invoke(pendingIntent, new Object[]{""});
                if (invoke instanceof String) {
                    return (String) invoke;
                }
                return null;
            } catch (IllegalAccessException e2) {
                com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "getOperationIntentTag e:%s", e2);
            } catch (InvocationTargetException e3) {
                com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "getOperationIntentTag e:%s", e3);
            }
            return null;
        }
    }

    final class f {
        final String bVa = String.format("%s/com.tencent.matrix/alarm-detector-record/%s/current-alarm-info-%s", new Object[]{Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.matrix.a.c.a.getPackageName(), com.tencent.matrix.a.c.a.getProcessName()});

        f() {
            com.tencent.matrix.d.c.i("MicroMsg.AlarmDetector", "PersistenceHelper mSaveFileName :%s", this.bVa);
        }
    }

    static /* synthetic */ byte[] k(Intent intent) {
        if (intent == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        intent.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x00f2=Splitter:B:31:0x00f2, B:40:0x011a=Splitter:B:40:0x011a, B:22:0x00cc=Splitter:B:22:0x00cc} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00dd A:{SYNTHETIC, Splitter:B:25:0x00dd} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0103 A:{SYNTHETIC, Splitter:B:34:0x0103} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x012b A:{SYNTHETIC, Splitter:B:43:0x012b} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0144 A:{SYNTHETIC, Splitter:B:50:0x0144} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(com.tencent.matrix.c.c.a aVar, com.tencent.matrix.a.a.a aVar2) {
        IOException e;
        Throwable th;
        ClassNotFoundException e2;
        Exception e3;
        super(aVar);
        this.bUH = aVar2.bUG.get(com.tencent.mrs.b.a.a.clicfg_matrix_battery_alarm_1h_trigger_cnt_threshold.name(), 20);
        this.bUI = aVar2.bUG.get(com.tencent.mrs.b.a.a.clicfg_matrix_battery_wake_up_alarm_1h_trigger_cnt_threshold.name(), 12);
        f fVar = this.bUJ;
        File file = new File(fVar.bVa);
        if (file.exists()) {
            ObjectInputStream objectInputStream;
            try {
                objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
                try {
                    d dVar = (d) objectInputStream.readObject();
                    if (dVar != null) {
                        a.this.bUL = dVar.yR();
                        a.this.bUM = dVar.bUM;
                    }
                    try {
                        objectInputStream.close();
                    } catch (IOException e4) {
                        com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "save : exp:%s", e4);
                    }
                } catch (IOException e5) {
                    e4 = e5;
                    try {
                        com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "load : exp:%s", e4);
                        if (objectInputStream != null) {
                        }
                        if (a.this.bUL == null) {
                        }
                        com.tencent.matrix.d.c.i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(a.this.bUM), Integer.valueOf(a.this.bUL.size()));
                        if (aVar2.yO()) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectInputStream != null) {
                        }
                        throw th;
                    }
                } catch (ClassNotFoundException e6) {
                    e2 = e6;
                    com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "load : exp:%s", e2);
                    if (objectInputStream != null) {
                    }
                    if (a.this.bUL == null) {
                    }
                    com.tencent.matrix.d.c.i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(a.this.bUM), Integer.valueOf(a.this.bUL.size()));
                    if (aVar2.yO()) {
                    }
                } catch (Exception e7) {
                    e3 = e7;
                    com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "load: exp:%s", e3);
                    if (objectInputStream != null) {
                    }
                    if (a.this.bUL == null) {
                    }
                    com.tencent.matrix.d.c.i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(a.this.bUM), Integer.valueOf(a.this.bUL.size()));
                    if (aVar2.yO()) {
                    }
                }
            } catch (IOException e8) {
                e4 = e8;
                objectInputStream = null;
                com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "load : exp:%s", e4);
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e42) {
                        com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "save : exp:%s", e42);
                    }
                }
                if (a.this.bUL == null) {
                }
                com.tencent.matrix.d.c.i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(a.this.bUM), Integer.valueOf(a.this.bUL.size()));
                if (aVar2.yO()) {
                }
            } catch (ClassNotFoundException e9) {
                e2 = e9;
                objectInputStream = null;
                com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "load : exp:%s", e2);
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e422) {
                        com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "save : exp:%s", e422);
                    }
                }
                if (a.this.bUL == null) {
                }
                com.tencent.matrix.d.c.i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(a.this.bUM), Integer.valueOf(a.this.bUL.size()));
                if (aVar2.yO()) {
                }
            } catch (Exception e10) {
                e3 = e10;
                objectInputStream = null;
                com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "load: exp:%s", e3);
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e4222) {
                        com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "save : exp:%s", e4222);
                    }
                }
                if (a.this.bUL == null) {
                }
                com.tencent.matrix.d.c.i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(a.this.bUM), Integer.valueOf(a.this.bUL.size()));
                if (aVar2.yO()) {
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e11) {
                        com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "save : exp:%s", e11);
                    }
                }
                throw th;
            }
            if (a.this.bUL == null) {
                a.this.bUL = new ArrayList();
                a.this.bUM = -1;
            }
            com.tencent.matrix.d.c.i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(a.this.bUM), Integer.valueOf(a.this.bUL.size()));
        } else {
            a.this.bUL = new ArrayList();
            a.this.bUM = -1;
        }
        if (aVar2.yO()) {
            this.bUK = new b();
        } else {
            this.bUK = null;
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:119:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0297 A:{SYNTHETIC, Splitter:B:90:0x0297} */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02b0 A:{SYNTHETIC, Splitter:B:97:0x02b0} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void yP() {
        IOException e;
        Throwable th;
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.matrix.d.c.i("MicroMsg.AlarmDetector", "countAndDetect now:%d mCurrentCountPeriodFrom:%d", Long.valueOf(currentTimeMillis), Long.valueOf(this.bUM));
        if (this.bUM <= 0) {
            this.bUM = currentTimeMillis;
        }
        if (currentTimeMillis - this.bUM >= 345600000) {
            this.bUM = currentTimeMillis - 172800000;
        } else if (currentTimeMillis - this.bUM >= 172800000) {
            this.bUM += 172800000;
        }
        while (this.bUM + 3600000 <= currentTimeMillis) {
            if (this.bUL == null || this.bUL.isEmpty()) {
                com.tencent.matrix.d.c.i("MicroMsg.AlarmDetector", "doCountAndDetect no alarms", new Object[0]);
            } else {
                Object obj;
                StringBuilder stringBuilder = new StringBuilder();
                StringBuilder stringBuilder2 = new StringBuilder();
                int i = 0;
                long j = this.bUM + 3600000;
                Iterator it = this.bUL.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    long j2;
                    a aVar = (a) it.next();
                    if (aVar.type == 1 || aVar.type == 0) {
                        j2 = aVar.bUN;
                    } else {
                        j2 = (aVar.bUN + System.currentTimeMillis()) - SystemClock.elapsedRealtime();
                    }
                    if (j2 < this.bUM && aVar.bUO <= 0) {
                        it.remove();
                    } else if (aVar.bUR < this.bUM || aVar.bUR <= j2) {
                        it.remove();
                    } else if (j2 < j) {
                        if (aVar.bUO > 0) {
                            long j3 = aVar.bUR < j ? aVar.bUR : j;
                            if (this.bUM <= j2) {
                                j2 = (((j3 - j2) - 1) / aVar.bUO) + 1;
                            } else {
                                j2 = ((j3 - (this.bUM - ((this.bUM - j2) % aVar.bUO))) - 1) / aVar.bUO;
                            }
                        } else {
                            j2 = 1;
                        }
                        i = (int) (((long) i) + j2);
                        stringBuilder.append(aVar.stackTrace).append("\t\t");
                        if (aVar.type == 0 || aVar.type == 2) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            i2 = (int) (j2 + ((long) i2));
                            stringBuilder2.append(aVar.stackTrace).append("\t\t");
                        }
                    }
                }
                int i3 = -1;
                obj = null;
                if (i >= this.bUH) {
                    obj = stringBuilder.toString();
                    i3 = 4;
                } else if (i2 >= this.bUI) {
                    i3 = 5;
                    i = i2;
                    String stringBuilder3 = stringBuilder2.toString();
                } else {
                    i = 0;
                }
                if (i3 > 0) {
                    String ck = com.tencent.matrix.d.d.ck(String.format("%d%s", new Object[]{Integer.valueOf(i3), obj}));
                    if (cg(ck)) {
                        com.tencent.matrix.d.c.v("MicroMsg.AlarmDetector", "doCountAndDetect issue already published", new Object[0]);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("alarmSetStacks", obj);
                            jSONObject.put("alarmTriggeredNum1H", i);
                            jSONObject.put("subTag", "alarm");
                        } catch (JSONException e2) {
                            com.tencent.matrix.d.c.e("MicroMsg.AlarmDetector", "doCountAndDetect json content error: %s", e2);
                        }
                        com.tencent.matrix.c.b bVar = new com.tencent.matrix.c.b(i3);
                        bVar.key = ck;
                        bVar.bWv = jSONObject;
                        b(bVar);
                        cf(ck);
                    }
                }
            }
            this.bUM += 3600000;
        }
        f fVar = this.bUJ;
        File file = new File(fVar.bVa);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            try {
                objectOutputStream.writeObject(new d(a.this.bUL, a.this.bUM));
                objectOutputStream.flush();
                com.tencent.matrix.d.c.i("MicroMsg.AlarmDetector", "save mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(a.this.bUM), Integer.valueOf(a.this.bUL.size()));
                try {
                    objectOutputStream.close();
                } catch (IOException e3) {
                    com.tencent.matrix.d.c.i("MicroMsg.AlarmDetector", "save close: exp:%s", e3);
                }
            } catch (IOException e4) {
                e3 = e4;
                try {
                    com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "save : exp:%s", e3);
                    if (objectOutputStream == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e3 = e5;
            objectOutputStream = null;
            com.tencent.matrix.d.c.w("MicroMsg.AlarmDetector", "save : exp:%s", e3);
            if (objectOutputStream == null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e32) {
                    com.tencent.matrix.d.c.i("MicroMsg.AlarmDetector", "save close: exp:%s", e32);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e6) {
                    com.tencent.matrix.d.c.i("MicroMsg.AlarmDetector", "save close: exp:%s", e6);
                }
            }
            throw th;
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(OnAlarmListener onAlarmListener, e eVar) {
        for (int i = 0; i < this.bUL.size(); i++) {
            a aVar = (a) this.bUL.get(i);
            if (aVar.bUQ == null || !aVar.bUQ.equals(onAlarmListener)) {
                if (aVar.bUP != null) {
                    Object obj;
                    e eVar2 = aVar.bUP;
                    int obj2;
                    if (eVar2.bUY != null && eVar2.bUY.equals(eVar.bUY)) {
                        obj2 = 1;
                    } else if (eVar2.bUT == eVar.bUT) {
                        obj2 = 1;
                    } else if (eVar2.bUZ != null && eVar2.bUZ.filterEquals(eVar.bUZ)) {
                        obj2 = 1;
                    } else if (eVar2.bUV == null || !eVar2.bUV.equals(eVar.bUV)) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        aVar.yQ();
                    }
                }
                if (aVar.bUP == null && aVar.bUQ == null) {
                    aVar.yQ();
                }
            } else {
                aVar.yQ();
            }
        }
    }

    private static Intent u(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            Intent intent = (Intent) Intent.CREATOR.createFromParcel(obtain);
            obtain.recycle();
            return intent;
        } catch (IllegalStateException e) {
            com.tencent.matrix.d.c.e("MicroMsg.AlarmDetector", "[bytesToIntent] %s", e);
            return null;
        }
    }
}
