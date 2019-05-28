package com.tencent.matrix.p151a.p153b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Environment;
import android.os.Parcel;
import android.os.SystemClock;
import com.tencent.matrix.p151a.p152a.C1024a;
import com.tencent.matrix.p151a.p154c.C1055a;
import com.tencent.matrix.p156c.C1062b;
import com.tencent.matrix.p156c.C1064c;
import com.tencent.matrix.p156c.C1064c.C1063a;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.p157d.C1073d;
import com.tencent.mrs.p656b.C5774a.C5773a;
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

/* renamed from: com.tencent.matrix.a.b.a */
public class C6278a extends C1064c {
    private final int bUH;
    private final int bUI;
    private final C1030f bUJ = new C1030f();
    final C1026b bUK;
    List<C1025a> bUL;
    private long bUM;

    /* renamed from: com.tencent.matrix.a.b.a$a */
    static final class C1025a {
        final long bUN;
        final long bUO;
        final C1029e bUP;
        final OnAlarmListener bUQ;
        long bUR;
        final String stackTrace;
        final int type;

        C1025a(int i, long j, long j2, PendingIntent pendingIntent, OnAlarmListener onAlarmListener, String str) {
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
            this.bUP = new C1029e(pendingIntent);
            this.bUQ = onAlarmListener;
            this.stackTrace = str;
            this.bUR = Long.MAX_VALUE;
        }

        C1025a(int i, long j, long j2, C1029e c1029e, String str, long j3) {
            this.type = i;
            this.bUN = j;
            this.bUO = j2;
            this.bUP = c1029e;
            this.bUQ = null;
            this.stackTrace = str;
            this.bUR = j3;
        }

        /* renamed from: yQ */
        public final void mo4165yQ() {
            if (this.bUR == Long.MAX_VALUE) {
                this.bUR = System.currentTimeMillis();
            }
        }
    }

    /* renamed from: com.tencent.matrix.a.b.a$b */
    static final class C1026b {
        private final String bUS;

        C1026b() {
            String formatTime = C1073d.formatTime("yyyy-MM-dd", System.currentTimeMillis());
            this.bUS = String.format("%s/com.tencent.matrix/alarm-detector-record/%s/alarm-info-record-%s", new Object[]{Environment.getExternalStorageDirectory().getAbsolutePath(), C1055a.getPackageName(), formatTime});
            C1070c.m2368i("MicroMsg.AlarmDetector", "AlarmInfoRecorder path:%s", this.bUS);
        }

        /* Access modifiers changed, original: final */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x0067=Splitter:B:22:0x0067, B:15:0x004b=Splitter:B:15:0x004b} */
        /* JADX WARNING: Removed duplicated region for block: B:41:? A:{SYNTHETIC, RETURN, Catch:{ FileNotFoundException -> 0x004a, IOException -> 0x0066 }} */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0060 A:{SYNTHETIC, Splitter:B:18:0x0060} */
        /* JADX WARNING: Removed duplicated region for block: B:42:? A:{SYNTHETIC, RETURN, Catch:{ FileNotFoundException -> 0x004a, IOException -> 0x0066 }} */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x007c A:{SYNTHETIC, Splitter:B:25:0x007c} */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0085 A:{SYNTHETIC, Splitter:B:30:0x0085} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: cc */
        public final void mo4166cc(String str) {
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
                            C1070c.m2370w("MicroMsg.AlarmDetector", "doRecord exp:%s", e.getLocalizedMessage());
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
                        C1070c.m2370w("MicroMsg.AlarmDetector", "doRecord exp:%s", e2.getLocalizedMessage());
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
                C1070c.m2367e("MicroMsg.AlarmDetector", "doRecord mkdirs failed", new Object[0]);
            } catch (FileNotFoundException e7) {
                e = e7;
                C1070c.m2370w("MicroMsg.AlarmDetector", "doRecord exp:%s", e.getLocalizedMessage());
                if (bufferedWriter == null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e8) {
                    }
                }
            } catch (IOException e9) {
                e2 = e9;
                C1070c.m2370w("MicroMsg.AlarmDetector", "doRecord exp:%s", e2.getLocalizedMessage());
                if (bufferedWriter == null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e10) {
                    }
                }
            }
        }
    }

    /* renamed from: com.tencent.matrix.a.b.a$c */
    static final class C1027c implements Serializable {
        static final /* synthetic */ boolean $assertionsDisabled = (!C6278a.class.desiredAssertionStatus());
        final long bUN;
        final long bUO;
        long bUR;
        final int bUT;
        final byte[] bUU;
        final String bUV;
        final String stackTrace;
        final int type;

        C1027c(C1025a c1025a) {
            if ($assertionsDisabled || c1025a != null) {
                this.type = c1025a.type;
                this.bUN = c1025a.bUN;
                this.bUO = c1025a.bUO;
                this.bUT = c1025a.bUP.bUT;
                this.bUU = C6278a.m10276k(c1025a.bUP.bUZ);
                this.bUV = c1025a.bUP.bUV;
                this.stackTrace = c1025a.stackTrace;
                this.bUR = c1025a.bUR;
                return;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: com.tencent.matrix.a.b.a$d */
    static final class C1028d implements Serializable {
        private final List<C1027c> bUL = new ArrayList();
        private final long bUM;

        C1028d(List<C1025a> list, long j) {
            if (list != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    this.bUL.add(new C1027c((C1025a) list.get(i2)));
                    i = i2 + 1;
                }
            }
            this.bUM = j;
        }

        /* renamed from: yR */
        public final List<C1025a> mo4167yR() {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.bUL.size(); i++) {
                C1027c c1027c = (C1027c) this.bUL.get(i);
                Intent v = C6278a.m10277u(c1027c.bUU);
                if (v == null) {
                    C1070c.m2367e("MicroMsg.AlarmDetector", "bytesToIntent is null,  alarmInfoSet maybe invalid object", new Object[0]);
                } else {
                    arrayList.add(new C1025a(c1027c.type, c1027c.bUN, c1027c.bUO, new C1029e(c1027c.bUT, v, c1027c.bUV), c1027c.stackTrace, c1027c.bUR));
                }
            }
            return arrayList;
        }
    }

    /* renamed from: com.tencent.matrix.a.b.a$e */
    static final class C1029e {
        private static Method bUW;
        private static Method bUX;
        final int bUT;
        final String bUV;
        final PendingIntent bUY;
        final Intent bUZ;

        C1029e(PendingIntent pendingIntent) {
            this.bUY = pendingIntent;
            if (this.bUY != null) {
                this.bUT = pendingIntent.hashCode();
                this.bUZ = C1029e.m2310b(pendingIntent);
                this.bUV = C1029e.m2311c(pendingIntent);
                return;
            }
            this.bUT = -1;
            this.bUZ = null;
            this.bUV = null;
        }

        C1029e(int i, Intent intent, String str) {
            this.bUY = null;
            this.bUT = i;
            this.bUZ = intent;
            this.bUV = str;
        }

        /* renamed from: b */
        private static Intent m2310b(PendingIntent pendingIntent) {
            if (pendingIntent == null) {
                return null;
            }
            if (bUW == null) {
                try {
                    Method declaredMethod = PendingIntent.class.getDeclaredMethod("getIntent", new Class[0]);
                    bUW = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    C1070c.m2370w("MicroMsg.AlarmDetector", "getOperationIntent e:%s", e);
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
                C1070c.m2370w("MicroMsg.AlarmDetector", "getOperationIntent e:%s", e2);
            } catch (InvocationTargetException e3) {
            } catch (SecurityException e4) {
                C1070c.m2370w("MicroMsg.AlarmDetector", "getOperationIntent e:%s", e4);
            }
            return null;
        }

        /* renamed from: c */
        private static String m2311c(PendingIntent pendingIntent) {
            if (pendingIntent == null) {
                return null;
            }
            if (bUX == null) {
                try {
                    Method declaredMethod = PendingIntent.class.getDeclaredMethod("getTag", new Class[]{String.class});
                    bUX = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    C1070c.m2370w("MicroMsg.AlarmDetector", "getOperationIntentTag e:%s", e);
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
                C1070c.m2370w("MicroMsg.AlarmDetector", "getOperationIntentTag e:%s", e2);
            } catch (InvocationTargetException e3) {
                C1070c.m2370w("MicroMsg.AlarmDetector", "getOperationIntentTag e:%s", e3);
            }
            return null;
        }
    }

    /* renamed from: com.tencent.matrix.a.b.a$f */
    final class C1030f {
        final String bVa = String.format("%s/com.tencent.matrix/alarm-detector-record/%s/current-alarm-info-%s", new Object[]{Environment.getExternalStorageDirectory().getAbsolutePath(), C1055a.getPackageName(), C1055a.getProcessName()});

        C1030f() {
            C1070c.m2368i("MicroMsg.AlarmDetector", "PersistenceHelper mSaveFileName :%s", this.bVa);
        }
    }

    /* renamed from: k */
    static /* synthetic */ byte[] m10276k(Intent intent) {
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
    public C6278a(C1063a c1063a, C1024a c1024a) {
        IOException e;
        Throwable th;
        ClassNotFoundException e2;
        Exception e3;
        super(c1063a);
        this.bUH = c1024a.bUG.get(C5773a.clicfg_matrix_battery_alarm_1h_trigger_cnt_threshold.name(), 20);
        this.bUI = c1024a.bUG.get(C5773a.clicfg_matrix_battery_wake_up_alarm_1h_trigger_cnt_threshold.name(), 12);
        C1030f c1030f = this.bUJ;
        File file = new File(c1030f.bVa);
        if (file.exists()) {
            ObjectInputStream objectInputStream;
            try {
                objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
                try {
                    C1028d c1028d = (C1028d) objectInputStream.readObject();
                    if (c1028d != null) {
                        C6278a.this.bUL = c1028d.mo4167yR();
                        C6278a.this.bUM = c1028d.bUM;
                    }
                    try {
                        objectInputStream.close();
                    } catch (IOException e4) {
                        C1070c.m2370w("MicroMsg.AlarmDetector", "save : exp:%s", e4);
                    }
                } catch (IOException e5) {
                    e4 = e5;
                    try {
                        C1070c.m2370w("MicroMsg.AlarmDetector", "load : exp:%s", e4);
                        if (objectInputStream != null) {
                        }
                        if (C6278a.this.bUL == null) {
                        }
                        C1070c.m2368i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(C6278a.this.bUM), Integer.valueOf(C6278a.this.bUL.size()));
                        if (c1024a.mo4164yO()) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectInputStream != null) {
                        }
                        throw th;
                    }
                } catch (ClassNotFoundException e6) {
                    e2 = e6;
                    C1070c.m2370w("MicroMsg.AlarmDetector", "load : exp:%s", e2);
                    if (objectInputStream != null) {
                    }
                    if (C6278a.this.bUL == null) {
                    }
                    C1070c.m2368i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(C6278a.this.bUM), Integer.valueOf(C6278a.this.bUL.size()));
                    if (c1024a.mo4164yO()) {
                    }
                } catch (Exception e7) {
                    e3 = e7;
                    C1070c.m2370w("MicroMsg.AlarmDetector", "load: exp:%s", e3);
                    if (objectInputStream != null) {
                    }
                    if (C6278a.this.bUL == null) {
                    }
                    C1070c.m2368i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(C6278a.this.bUM), Integer.valueOf(C6278a.this.bUL.size()));
                    if (c1024a.mo4164yO()) {
                    }
                }
            } catch (IOException e8) {
                e4 = e8;
                objectInputStream = null;
                C1070c.m2370w("MicroMsg.AlarmDetector", "load : exp:%s", e4);
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e42) {
                        C1070c.m2370w("MicroMsg.AlarmDetector", "save : exp:%s", e42);
                    }
                }
                if (C6278a.this.bUL == null) {
                }
                C1070c.m2368i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(C6278a.this.bUM), Integer.valueOf(C6278a.this.bUL.size()));
                if (c1024a.mo4164yO()) {
                }
            } catch (ClassNotFoundException e9) {
                e2 = e9;
                objectInputStream = null;
                C1070c.m2370w("MicroMsg.AlarmDetector", "load : exp:%s", e2);
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e422) {
                        C1070c.m2370w("MicroMsg.AlarmDetector", "save : exp:%s", e422);
                    }
                }
                if (C6278a.this.bUL == null) {
                }
                C1070c.m2368i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(C6278a.this.bUM), Integer.valueOf(C6278a.this.bUL.size()));
                if (c1024a.mo4164yO()) {
                }
            } catch (Exception e10) {
                e3 = e10;
                objectInputStream = null;
                C1070c.m2370w("MicroMsg.AlarmDetector", "load: exp:%s", e3);
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e4222) {
                        C1070c.m2370w("MicroMsg.AlarmDetector", "save : exp:%s", e4222);
                    }
                }
                if (C6278a.this.bUL == null) {
                }
                C1070c.m2368i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(C6278a.this.bUM), Integer.valueOf(C6278a.this.bUL.size()));
                if (c1024a.mo4164yO()) {
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e11) {
                        C1070c.m2370w("MicroMsg.AlarmDetector", "save : exp:%s", e11);
                    }
                }
                throw th;
            }
            if (C6278a.this.bUL == null) {
                C6278a.this.bUL = new ArrayList();
                C6278a.this.bUM = -1;
            }
            C1070c.m2368i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(C6278a.this.bUM), Integer.valueOf(C6278a.this.bUL.size()));
        } else {
            C6278a.this.bUL = new ArrayList();
            C6278a.this.bUM = -1;
        }
        if (c1024a.mo4164yO()) {
            this.bUK = new C1026b();
        } else {
            this.bUK = null;
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:119:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0297 A:{SYNTHETIC, Splitter:B:90:0x0297} */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02b0 A:{SYNTHETIC, Splitter:B:97:0x02b0} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: yP */
    public final void mo14510yP() {
        IOException e;
        Throwable th;
        long currentTimeMillis = System.currentTimeMillis();
        C1070c.m2368i("MicroMsg.AlarmDetector", "countAndDetect now:%d mCurrentCountPeriodFrom:%d", Long.valueOf(currentTimeMillis), Long.valueOf(this.bUM));
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
                C1070c.m2368i("MicroMsg.AlarmDetector", "doCountAndDetect no alarms", new Object[0]);
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
                    C1025a c1025a = (C1025a) it.next();
                    if (c1025a.type == 1 || c1025a.type == 0) {
                        j2 = c1025a.bUN;
                    } else {
                        j2 = (c1025a.bUN + System.currentTimeMillis()) - SystemClock.elapsedRealtime();
                    }
                    if (j2 < this.bUM && c1025a.bUO <= 0) {
                        it.remove();
                    } else if (c1025a.bUR < this.bUM || c1025a.bUR <= j2) {
                        it.remove();
                    } else if (j2 < j) {
                        if (c1025a.bUO > 0) {
                            long j3 = c1025a.bUR < j ? c1025a.bUR : j;
                            if (this.bUM <= j2) {
                                j2 = (((j3 - j2) - 1) / c1025a.bUO) + 1;
                            } else {
                                j2 = ((j3 - (this.bUM - ((this.bUM - j2) % c1025a.bUO))) - 1) / c1025a.bUO;
                            }
                        } else {
                            j2 = 1;
                        }
                        i = (int) (((long) i) + j2);
                        stringBuilder.append(c1025a.stackTrace).append("\t\t");
                        if (c1025a.type == 0 || c1025a.type == 2) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            i2 = (int) (j2 + ((long) i2));
                            stringBuilder2.append(c1025a.stackTrace).append("\t\t");
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
                    String ck = C1073d.m2379ck(String.format("%d%s", new Object[]{Integer.valueOf(i3), obj}));
                    if (mo4202cg(ck)) {
                        C1070c.m2369v("MicroMsg.AlarmDetector", "doCountAndDetect issue already published", new Object[0]);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("alarmSetStacks", obj);
                            jSONObject.put("alarmTriggeredNum1H", i);
                            jSONObject.put("subTag", "alarm");
                        } catch (JSONException e2) {
                            C1070c.m2367e("MicroMsg.AlarmDetector", "doCountAndDetect json content error: %s", e2);
                        }
                        C1062b c1062b = new C1062b(i3);
                        c1062b.key = ck;
                        c1062b.bWv = jSONObject;
                        mo4200b(c1062b);
                        mo4201cf(ck);
                    }
                }
            }
            this.bUM += 3600000;
        }
        C1030f c1030f = this.bUJ;
        File file = new File(c1030f.bVa);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            try {
                objectOutputStream.writeObject(new C1028d(C6278a.this.bUL, C6278a.this.bUM));
                objectOutputStream.flush();
                C1070c.m2368i("MicroMsg.AlarmDetector", "save mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(C6278a.this.bUM), Integer.valueOf(C6278a.this.bUL.size()));
                try {
                    objectOutputStream.close();
                } catch (IOException e3) {
                    C1070c.m2368i("MicroMsg.AlarmDetector", "save close: exp:%s", e3);
                }
            } catch (IOException e4) {
                e3 = e4;
                try {
                    C1070c.m2370w("MicroMsg.AlarmDetector", "save : exp:%s", e3);
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
            C1070c.m2370w("MicroMsg.AlarmDetector", "save : exp:%s", e3);
            if (objectOutputStream == null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e32) {
                    C1070c.m2368i("MicroMsg.AlarmDetector", "save close: exp:%s", e32);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e6) {
                    C1070c.m2368i("MicroMsg.AlarmDetector", "save close: exp:%s", e6);
                }
            }
            throw th;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo14509a(OnAlarmListener onAlarmListener, C1029e c1029e) {
        for (int i = 0; i < this.bUL.size(); i++) {
            C1025a c1025a = (C1025a) this.bUL.get(i);
            if (c1025a.bUQ == null || !c1025a.bUQ.equals(onAlarmListener)) {
                if (c1025a.bUP != null) {
                    Object obj;
                    C1029e c1029e2 = c1025a.bUP;
                    int obj2;
                    if (c1029e2.bUY != null && c1029e2.bUY.equals(c1029e.bUY)) {
                        obj2 = 1;
                    } else if (c1029e2.bUT == c1029e.bUT) {
                        obj2 = 1;
                    } else if (c1029e2.bUZ != null && c1029e2.bUZ.filterEquals(c1029e.bUZ)) {
                        obj2 = 1;
                    } else if (c1029e2.bUV == null || !c1029e2.bUV.equals(c1029e.bUV)) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        c1025a.mo4165yQ();
                    }
                }
                if (c1025a.bUP == null && c1025a.bUQ == null) {
                    c1025a.mo4165yQ();
                }
            } else {
                c1025a.mo4165yQ();
            }
        }
    }

    /* renamed from: u */
    private static Intent m10277u(byte[] bArr) {
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
            C1070c.m2367e("MicroMsg.AlarmDetector", "[bytesToIntent] %s", e);
            return null;
        }
    }
}
