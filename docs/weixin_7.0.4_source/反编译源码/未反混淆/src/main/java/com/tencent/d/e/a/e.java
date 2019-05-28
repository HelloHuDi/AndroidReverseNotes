package com.tencent.d.e.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Display;
import com.tencent.d.e.a.a.b;
import com.tencent.d.e.a.a.c;
import com.tencent.d.e.a.a.d;
import com.tencent.d.e.a.a.g;
import com.tencent.d.e.a.a.h;
import com.tencent.d.e.a.a.k;
import com.tencent.d.f.f;
import com.tencent.d.f.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e {
    private static final j<e> Atp = new j<e>() {
        public final /* synthetic */ Object mG() {
            AppMethodBeat.i(114535);
            e eVar = new e();
            AppMethodBeat.o(114535);
            return eVar;
        }
    };
    private g Atq;
    private final List<k> Atr;
    private d Ats;
    private b Att;
    private d Atu;
    private final Runnable Atv;
    private final a Atw;
    private boolean apg;
    private final Handler mHandler;

    class a extends c {
        long AtD;
        int mCount;
        int mMaxCount;

        private a() {
            this.mCount = 1;
            this.mMaxCount = 3;
            this.AtD = 0;
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        public final void dQt() {
            AppMethodBeat.i(114542);
            k kVar = new k();
            synchronized (e.this) {
                try {
                    Object systemService;
                    int i;
                    Context context = e.this.Ats.context;
                    try {
                        if (VERSION.SDK_INT >= 20) {
                            Class cls = Class.forName("android.hardware.display.DisplayManager");
                            Field field = context.getClass().getField("DISPLAY_SERVICE");
                            field.setAccessible(true);
                            systemService = context.getSystemService((String) field.get(context));
                            if (systemService == null) {
                                i = 0;
                            } else {
                                Method method = cls.getMethod("getDisplays", new Class[0]);
                                if (method == null) {
                                    i = 0;
                                } else {
                                    method.setAccessible(true);
                                    Display[] displayArr = (Display[]) method.invoke(systemService, new Object[0]);
                                    Method method2 = Display.class.getMethod("getState", new Class[0]);
                                    method2.setAccessible(true);
                                    Field field2 = Display.class.getField("STATE_OFF");
                                    field2.setAccessible(true);
                                    Object obj = null;
                                    int length = displayArr.length;
                                    int i2 = 0;
                                    while (i2 < length) {
                                        Object obj2 = displayArr[i2];
                                        if (((Integer) method2.invoke(obj2, new Object[0])).intValue() != field2.getInt(obj2)) {
                                            obj2 = 1;
                                        } else {
                                            obj2 = obj;
                                        }
                                        i2++;
                                        obj = obj2;
                                    }
                                    kVar.AtW = obj != null ? 1 : 2;
                                    i = kVar.AtW;
                                }
                            }
                            kVar.AtW = i;
                        } else {
                            PowerManager powerManager = (PowerManager) context.getSystemService("power");
                            if (powerManager != null) {
                                kVar.AtW = powerManager.isScreenOn() ? 1 : 2;
                            }
                        }
                    } catch (Throwable th) {
                    }
                    String ag = f.ag(new File("/sys/class/android_usb/android0/state"));
                    if (!TextUtils.isEmpty(ag)) {
                        if ("CONFIGURED".equals(ag)) {
                            kVar.AtY = 1;
                        } else if ("DISCONNECTED".equals(ag)) {
                            kVar.AtY = 2;
                        } else if ("CONNECTED".equals(ag)) {
                            kVar.AtY = 3;
                        }
                    }
                    Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    if (registerReceiver != null) {
                        i = registerReceiver.getIntExtra("status", -1);
                        systemService = (i == 2 || i == 5) ? 1 : null;
                        if (systemService == null) {
                            kVar.AtZ = 1;
                        } else {
                            i = registerReceiver.getIntExtra("plugged", -1);
                            if (i == 2) {
                                kVar.AtZ = 3;
                            } else if (i == 1) {
                                kVar.AtZ = 2;
                            } else {
                                kVar.AtZ = 0;
                            }
                        }
                    }
                } finally {
                    AppMethodBeat.o(114542);
                }
            }
            synchronized (e.this.Atr) {
                try {
                    e.this.Atr.add(kVar);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(114542);
                }
            }
            if (this.mCount >= this.mMaxCount) {
                synchronized (e.this) {
                    try {
                        if (e.this.apg) {
                            e.this.EH();
                        }
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.o(114542);
                        }
                    }
                }
            }
            this.mCount++;
            long currentTimeMillis = (this.AtD + (com.tencent.d.e.a.a.f.AtG * ((long) this.mCount))) - System.currentTimeMillis();
            if (currentTimeMillis > 0) {
                e.this.mHandler.postDelayed(e.this.Atw, currentTimeMillis);
                AppMethodBeat.o(114542);
                return;
            }
            e.this.mHandler.post(e.this.Atw);
            AppMethodBeat.o(114542);
        }

        public final void dQu() {
            AppMethodBeat.i(114543);
            if (e.this.Atu != null) {
                e.this.Atu;
            }
            AppMethodBeat.o(114543);
        }
    }

    /* synthetic */ e(byte b) {
        this();
    }

    static {
        AppMethodBeat.i(114551);
        AppMethodBeat.o(114551);
    }

    public static e dQs() {
        AppMethodBeat.i(114544);
        e eVar = (e) Atp.get();
        AppMethodBeat.o(114544);
        return eVar;
    }

    private e() {
        AppMethodBeat.i(114545);
        this.apg = false;
        this.Atr = new ArrayList();
        this.Atv = new c() {
            /* JADX WARNING: Missing block: B:18:0x007a, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(114536);
     */
            /* JADX WARNING: Missing block: B:25:?, code skipped:
            return;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void dQt() {
                AppMethodBeat.i(114536);
                synchronized (e.this) {
                    try {
                        if (!e.this.apg) {
                        } else if (e.this.Atq == null) {
                            AppMethodBeat.o(114536);
                        } else if (e.this.Atq.nA(e.this.Ats.Ato)) {
                            long dQx = e.this.Atq.AtN.dQx();
                            a d = e.this.Atw;
                            int i = (int) (e.this.Ats.Ato / com.tencent.d.e.a.a.f.AtG);
                            d.mCount = 1;
                            d.mMaxCount = i;
                            d.AtD = dQx;
                            dQx = (dQx + com.tencent.d.e.a.a.f.AtG) - System.currentTimeMillis();
                            if (dQx > 0) {
                                e.this.mHandler.postDelayed(e.this.Atw, dQx);
                            } else {
                                e.this.mHandler.post(e.this.Atw);
                            }
                        }
                    } finally {
                        AppMethodBeat.o(114536);
                    }
                }
            }

            public final void dQu() {
                AppMethodBeat.i(114537);
                if (e.this.Atu != null) {
                    e.this.Atu;
                }
                AppMethodBeat.o(114537);
            }
        };
        this.Atw = new a(this, (byte) 0);
        HandlerThread handlerThread = new HandlerThread("TuringMMCore");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        AppMethodBeat.o(114545);
    }

    public final synchronized boolean EH() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(114547);
            if (this.apg) {
                this.apg = false;
                if (this.Ats == null) {
                    AppMethodBeat.o(114547);
                } else {
                    this.mHandler.removeCallbacks(this.Atv);
                    this.mHandler.removeCallbacks(this.Atw);
                    if (this.Atq != null) {
                        this.Atq.dQv();
                        if (((int) (this.Atq.AtN.dQy() / com.tencent.d.e.a.a.f.AtG)) < 3) {
                            AppMethodBeat.o(114547);
                        } else {
                            final SparseArray dQw = this.Atq.dQw();
                            if (dQw.size() == 0) {
                                AppMethodBeat.o(114547);
                            } else {
                                final ArrayList arrayList;
                                int i;
                                synchronized (this.Atr) {
                                    try {
                                        arrayList = new ArrayList(this.Atr);
                                    } finally {
                                        while (true) {
                                        }
                                        i = 114547;
                                        AppMethodBeat.o(114547);
                                    }
                                }
                                i = arrayList.size();
                                if (i < 3) {
                                    AppMethodBeat.o(i);
                                } else {
                                    final int i2 = this.Ats.Atn;
                                    final int i3 = this.Ats.action;
                                    final int i4 = this.Ats.requestType;
                                    this.mHandler.post(new c() {
                                        /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
                                        /* JADX WARNING: Removed duplicated region for block: B:25:0x007d  */
                                        /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
                                        /* JADX WARNING: Removed duplicated region for block: B:25:0x007d  */
                                        /* Code decompiled incorrectly, please refer to instructions dump. */
                                        public final void dQt() {
                                            Closeable closeable;
                                            String hT;
                                            Throwable th;
                                            AppMethodBeat.i(114538);
                                            try {
                                                com.tencent.d.e.a.b.a a;
                                                synchronized (e.this) {
                                                    a = b.a(i2, i3, e.this.Ats.context, i4, dQw, arrayList);
                                                }
                                                h dQz = h.dQz();
                                                int i = i2;
                                                int i2 = i3;
                                                byte[] m = com.tencent.d.f.c.m(com.tencent.d.f.b.compress(a.toByteArray()), com.tencent.d.f.c.dQC());
                                                if (m != null) {
                                                    CharSequence charSequence;
                                                    File dir = dQz.mContext.getDir("turingmm", 0);
                                                    if (dir == null) {
                                                        charSequence = "";
                                                    } else {
                                                        charSequence = dir.getAbsolutePath() + File.separator + h.hU(i, i2) + "_" + System.currentTimeMillis();
                                                    }
                                                    if (!TextUtils.isEmpty(charSequence)) {
                                                        Closeable closeable2 = null;
                                                        try {
                                                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(charSequence));
                                                            try {
                                                                bufferedOutputStream.write(m);
                                                                bufferedOutputStream.flush();
                                                                f.closeQuietly(bufferedOutputStream);
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                Object closeable22 = bufferedOutputStream;
                                                                f.closeQuietly(closeable22);
                                                                AppMethodBeat.o(114538);
                                                                throw th;
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            f.closeQuietly(closeable22);
                                                            AppMethodBeat.o(114538);
                                                            throw th;
                                                        }
                                                        hT = dQz.hT(i, i2);
                                                        if (TextUtils.isEmpty(hT)) {
                                                            new File(hT).delete();
                                                        }
                                                    }
                                                }
                                                if (e.this.Att != null) {
                                                    e.this.Att;
                                                }
                                                AppMethodBeat.o(114538);
                                            } catch (IllegalArgumentException e) {
                                                AppMethodBeat.o(114538);
                                            } catch (Throwable th4) {
                                                while (true) {
                                                    AppMethodBeat.o(114538);
                                                }
                                            }
                                        }

                                        public final void dQu() {
                                            AppMethodBeat.i(114539);
                                            if (e.this.Atu != null) {
                                                e.this.Atu;
                                            }
                                            AppMethodBeat.o(114539);
                                        }
                                    });
                                    AppMethodBeat.o(114547);
                                    z = true;
                                }
                            }
                        }
                    } else {
                        AppMethodBeat.o(114547);
                        z = true;
                    }
                }
            } else {
                AppMethodBeat.o(114547);
                z = true;
            }
        }
        return z;
    }

    public final synchronized void a(Context context, final String str, final com.tencent.d.e.a.a.e eVar) {
        AppMethodBeat.i(114548);
        h dQz = h.dQz();
        if (!dQz.mInit) {
            dQz.init(context);
        }
        this.mHandler.post(new c() {
            public final void dQt() {
                AppMethodBeat.i(114540);
                Map dQA = h.dQz().dQA();
                HashMap hashMap = new HashMap();
                if (dQA.size() != 0) {
                    com.tencent.d.e.a.a.h.a e = h.e(dQA, 0);
                    if (e != null) {
                        hashMap.put(e.AtS, e.AtT);
                    }
                    e = h.e(dQA, 1);
                    if (e != null) {
                        hashMap.put(e.AtS, e.AtT);
                    }
                    com.tencent.d.e.a.a.h.a e2 = h.e(dQA, 2);
                    if (e2 != null) {
                        hashMap.put(e2.AtS, e2.AtT);
                    }
                }
                if (hashMap.size() == 0) {
                    eVar.asv();
                    AppMethodBeat.o(114540);
                    return;
                }
                for (com.tencent.d.e.a.b.a aVar : hashMap.keySet()) {
                    aVar.Aua = System.currentTimeMillis();
                    aVar.few = str;
                    boolean a = eVar instanceof a ? e.a((a) eVar, aVar) : eVar instanceof c ? e.a((c) eVar, aVar) : false;
                    if (a) {
                        for (String file : (List) hashMap.get(aVar)) {
                            try {
                                new File(file).delete();
                            } catch (Throwable th) {
                            }
                        }
                    }
                }
                AppMethodBeat.o(114540);
            }

            public final void dQu() {
                AppMethodBeat.i(114541);
                if (e.this.Atu != null) {
                    e.this.Atu;
                }
                AppMethodBeat.o(114541);
            }
        });
        AppMethodBeat.o(114548);
    }

    public final synchronized boolean a(d dVar) {
        int i;
        boolean th = true;
        synchronized (this) {
            AppMethodBeat.i(114546);
            Context context = dVar.context;
            if (context == null) {
                th = false;
                AppMethodBeat.o(114546);
            } else {
                h dQz = h.dQz();
                if (!dQz.mInit) {
                    dQz.init(context);
                }
                if (this.apg) {
                    EH();
                }
                this.Ats = dVar;
                this.apg = true;
                if (this.Atq == null) {
                    this.Atq = new g(context);
                }
                if (this.Atq != null) {
                    g gVar = this.Atq;
                    synchronized (gVar.AtL) {
                        try {
                            gVar.AtL.clear();
                        } catch (Throwable th2) {
                            while (true) {
                                th = th2;
                            }
                            AppMethodBeat.o(i);
                        } finally {
                            while (true) {
                            }
                            i = 114546;
                            AppMethodBeat.o(114546);
                        }
                    }
                }
                i = this.Atr;
                synchronized (i) {
                    this.Atr.clear();
                }
                this.mHandler.postDelayed(this.Atv, dVar.xzH);
            }
        }
        return th;
    }
}
