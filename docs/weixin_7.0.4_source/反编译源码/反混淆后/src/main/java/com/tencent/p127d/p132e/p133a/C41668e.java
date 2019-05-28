package com.tencent.p127d.p132e.p133a;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p132e.p133a.p1165b.C17729a;
import com.tencent.p127d.p132e.p133a.p134a.C17728k;
import com.tencent.p127d.p132e.p133a.p134a.C25600c;
import com.tencent.p127d.p132e.p133a.p134a.C37318d;
import com.tencent.p127d.p132e.p133a.p134a.C37319g;
import com.tencent.p127d.p132e.p133a.p134a.C41661f;
import com.tencent.p127d.p132e.p133a.p134a.C45083e;
import com.tencent.p127d.p132e.p133a.p134a.C45084h;
import com.tencent.p127d.p132e.p133a.p134a.C45084h.C37320a;
import com.tencent.p127d.p132e.p133a.p134a.C8762b;
import com.tencent.p127d.p135f.C32113f;
import com.tencent.p127d.p135f.C37322j;
import com.tencent.p127d.p135f.C41670b;
import com.tencent.p127d.p135f.C8768c;
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

/* renamed from: com.tencent.d.e.a.e */
public final class C41668e {
    private static final C37322j<C41668e> Atp = new C177311();
    private C37319g Atq;
    private final List<C17728k> Atr;
    private C8766d Ats;
    private C8765b Att;
    private C37318d Atu;
    private final Runnable Atv;
    private final C41667a Atw;
    private boolean apg;
    private final Handler mHandler;

    /* renamed from: com.tencent.d.e.a.e$1 */
    static class C177311 extends C37322j<C41668e> {
        C177311() {
        }

        /* renamed from: mG */
        public final /* synthetic */ Object mo19824mG() {
            AppMethodBeat.m2504i(114535);
            C41668e c41668e = new C41668e();
            AppMethodBeat.m2505o(114535);
            return c41668e;
        }
    }

    /* renamed from: com.tencent.d.e.a.e$2 */
    class C177322 extends C25600c {
        C177322() {
        }

        /* JADX WARNING: Missing block: B:18:0x007a, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(114536);
     */
        /* JADX WARNING: Missing block: B:25:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void dQt() {
            AppMethodBeat.m2504i(114536);
            synchronized (C41668e.this) {
                try {
                    if (!C41668e.this.apg) {
                    } else if (C41668e.this.Atq == null) {
                        AppMethodBeat.m2505o(114536);
                    } else if (C41668e.this.Atq.mo60053nA(C41668e.this.Ats.Ato)) {
                        long dQx = C41668e.this.Atq.AtN.dQx();
                        C41667a d = C41668e.this.Atw;
                        int i = (int) (C41668e.this.Ats.Ato / C41661f.AtG);
                        d.mCount = 1;
                        d.mMaxCount = i;
                        d.AtD = dQx;
                        dQx = (dQx + C41661f.AtG) - System.currentTimeMillis();
                        if (dQx > 0) {
                            C41668e.this.mHandler.postDelayed(C41668e.this.Atw, dQx);
                        } else {
                            C41668e.this.mHandler.post(C41668e.this.Atw);
                        }
                    }
                } finally {
                    AppMethodBeat.m2505o(114536);
                }
            }
        }

        public final void dQu() {
            AppMethodBeat.m2504i(114537);
            if (C41668e.this.Atu != null) {
                C41668e.this.Atu;
            }
            AppMethodBeat.m2505o(114537);
        }
    }

    /* renamed from: com.tencent.d.e.a.e$a */
    class C41667a extends C25600c {
        long AtD;
        int mCount;
        int mMaxCount;

        private C41667a() {
            this.mCount = 1;
            this.mMaxCount = 3;
            this.AtD = 0;
        }

        /* synthetic */ C41667a(C41668e c41668e, byte b) {
            this();
        }

        public final void dQt() {
            AppMethodBeat.m2504i(114542);
            C17728k c17728k = new C17728k();
            synchronized (C41668e.this) {
                try {
                    Object systemService;
                    int i;
                    Context context = C41668e.this.Ats.context;
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
                                    c17728k.AtW = obj != null ? 1 : 2;
                                    i = c17728k.AtW;
                                }
                            }
                            c17728k.AtW = i;
                        } else {
                            PowerManager powerManager = (PowerManager) context.getSystemService("power");
                            if (powerManager != null) {
                                c17728k.AtW = powerManager.isScreenOn() ? 1 : 2;
                            }
                        }
                    } catch (Throwable th) {
                    }
                    String ag = C32113f.m52250ag(new File("/sys/class/android_usb/android0/state"));
                    if (!TextUtils.isEmpty(ag)) {
                        if ("CONFIGURED".equals(ag)) {
                            c17728k.AtY = 1;
                        } else if ("DISCONNECTED".equals(ag)) {
                            c17728k.AtY = 2;
                        } else if ("CONNECTED".equals(ag)) {
                            c17728k.AtY = 3;
                        }
                    }
                    Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    if (registerReceiver != null) {
                        i = registerReceiver.getIntExtra("status", -1);
                        systemService = (i == 2 || i == 5) ? 1 : null;
                        if (systemService == null) {
                            c17728k.AtZ = 1;
                        } else {
                            i = registerReceiver.getIntExtra("plugged", -1);
                            if (i == 2) {
                                c17728k.AtZ = 3;
                            } else if (i == 1) {
                                c17728k.AtZ = 2;
                            } else {
                                c17728k.AtZ = 0;
                            }
                        }
                    }
                } finally {
                    AppMethodBeat.m2505o(114542);
                }
            }
            synchronized (C41668e.this.Atr) {
                try {
                    C41668e.this.Atr.add(c17728k);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(114542);
                }
            }
            if (this.mCount >= this.mMaxCount) {
                synchronized (C41668e.this) {
                    try {
                        if (C41668e.this.apg) {
                            C41668e.this.mo67143EH();
                        }
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.m2505o(114542);
                        }
                    }
                }
            }
            this.mCount++;
            long currentTimeMillis = (this.AtD + (C41661f.AtG * ((long) this.mCount))) - System.currentTimeMillis();
            if (currentTimeMillis > 0) {
                C41668e.this.mHandler.postDelayed(C41668e.this.Atw, currentTimeMillis);
                AppMethodBeat.m2505o(114542);
                return;
            }
            C41668e.this.mHandler.post(C41668e.this.Atw);
            AppMethodBeat.m2505o(114542);
        }

        public final void dQu() {
            AppMethodBeat.m2504i(114543);
            if (C41668e.this.Atu != null) {
                C41668e.this.Atu;
            }
            AppMethodBeat.m2505o(114543);
        }
    }

    /* synthetic */ C41668e(byte b) {
        this();
    }

    static {
        AppMethodBeat.m2504i(114551);
        AppMethodBeat.m2505o(114551);
    }

    public static C41668e dQs() {
        AppMethodBeat.m2504i(114544);
        C41668e c41668e = (C41668e) Atp.get();
        AppMethodBeat.m2505o(114544);
        return c41668e;
    }

    private C41668e() {
        AppMethodBeat.m2504i(114545);
        this.apg = false;
        this.Atr = new ArrayList();
        this.Atv = new C177322();
        this.Atw = new C41667a(this, (byte) 0);
        HandlerThread handlerThread = new HandlerThread("TuringMMCore");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        AppMethodBeat.m2505o(114545);
    }

    /* renamed from: EH */
    public final synchronized boolean mo67143EH() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(114547);
            if (this.apg) {
                this.apg = false;
                if (this.Ats == null) {
                    AppMethodBeat.m2505o(114547);
                } else {
                    this.mHandler.removeCallbacks(this.Atv);
                    this.mHandler.removeCallbacks(this.Atw);
                    if (this.Atq != null) {
                        this.Atq.dQv();
                        if (((int) (this.Atq.AtN.dQy() / C41661f.AtG)) < 3) {
                            AppMethodBeat.m2505o(114547);
                        } else {
                            final SparseArray dQw = this.Atq.dQw();
                            if (dQw.size() == 0) {
                                AppMethodBeat.m2505o(114547);
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
                                        AppMethodBeat.m2505o(114547);
                                    }
                                }
                                i = arrayList.size();
                                if (i < 3) {
                                    AppMethodBeat.m2505o(i);
                                } else {
                                    final int i2 = this.Ats.Atn;
                                    final int i3 = this.Ats.action;
                                    final int i4 = this.Ats.requestType;
                                    this.mHandler.post(new C25600c() {
                                        /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
                                        /* JADX WARNING: Removed duplicated region for block: B:25:0x007d  */
                                        /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
                                        /* JADX WARNING: Removed duplicated region for block: B:25:0x007d  */
                                        /* Code decompiled incorrectly, please refer to instructions dump. */
                                        public final void dQt() {
                                            Closeable closeable;
                                            String hT;
                                            Throwable th;
                                            AppMethodBeat.m2504i(114538);
                                            try {
                                                C17729a a;
                                                synchronized (C41668e.this) {
                                                    a = C8762b.m15590a(i2, i3, C41668e.this.Ats.context, i4, dQw, arrayList);
                                                }
                                                C45084h dQz = C45084h.dQz();
                                                int i = i2;
                                                int i2 = i3;
                                                byte[] m = C8768c.m15598m(C41670b.compress(a.toByteArray()), C8768c.dQC());
                                                if (m != null) {
                                                    CharSequence charSequence;
                                                    File dir = dQz.mContext.getDir("turingmm", 0);
                                                    if (dir == null) {
                                                        charSequence = "";
                                                    } else {
                                                        charSequence = dir.getAbsolutePath() + File.separator + C45084h.m82709hU(i, i2) + "_" + System.currentTimeMillis();
                                                    }
                                                    if (!TextUtils.isEmpty(charSequence)) {
                                                        Closeable closeable2 = null;
                                                        try {
                                                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(charSequence));
                                                            try {
                                                                bufferedOutputStream.write(m);
                                                                bufferedOutputStream.flush();
                                                                C32113f.closeQuietly(bufferedOutputStream);
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                Object closeable22 = bufferedOutputStream;
                                                                C32113f.closeQuietly(closeable22);
                                                                AppMethodBeat.m2505o(114538);
                                                                throw th;
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            C32113f.closeQuietly(closeable22);
                                                            AppMethodBeat.m2505o(114538);
                                                            throw th;
                                                        }
                                                        hT = dQz.mo72859hT(i, i2);
                                                        if (TextUtils.isEmpty(hT)) {
                                                            new File(hT).delete();
                                                        }
                                                    }
                                                }
                                                if (C41668e.this.Att != null) {
                                                    C41668e.this.Att;
                                                }
                                                AppMethodBeat.m2505o(114538);
                                            } catch (IllegalArgumentException e) {
                                                AppMethodBeat.m2505o(114538);
                                            } catch (Throwable th4) {
                                                while (true) {
                                                    AppMethodBeat.m2505o(114538);
                                                }
                                            }
                                        }

                                        public final void dQu() {
                                            AppMethodBeat.m2504i(114539);
                                            if (C41668e.this.Atu != null) {
                                                C41668e.this.Atu;
                                            }
                                            AppMethodBeat.m2505o(114539);
                                        }
                                    });
                                    AppMethodBeat.m2505o(114547);
                                    z = true;
                                }
                            }
                        }
                    } else {
                        AppMethodBeat.m2505o(114547);
                        z = true;
                    }
                }
            } else {
                AppMethodBeat.m2505o(114547);
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public final synchronized void mo67144a(Context context, final String str, final C45083e c45083e) {
        AppMethodBeat.m2504i(114548);
        C45084h dQz = C45084h.dQz();
        if (!dQz.mInit) {
            dQz.init(context);
        }
        this.mHandler.post(new C25600c() {
            public final void dQt() {
                AppMethodBeat.m2504i(114540);
                Map dQA = C45084h.dQz().dQA();
                HashMap hashMap = new HashMap();
                if (dQA.size() != 0) {
                    C37320a e = C45084h.m82708e(dQA, 0);
                    if (e != null) {
                        hashMap.put(e.AtS, e.AtT);
                    }
                    e = C45084h.m82708e(dQA, 1);
                    if (e != null) {
                        hashMap.put(e.AtS, e.AtT);
                    }
                    C37320a e2 = C45084h.m82708e(dQA, 2);
                    if (e2 != null) {
                        hashMap.put(e2.AtS, e2.AtT);
                    }
                }
                if (hashMap.size() == 0) {
                    c45083e.asv();
                    AppMethodBeat.m2505o(114540);
                    return;
                }
                for (C17729a c17729a : hashMap.keySet()) {
                    c17729a.Aua = System.currentTimeMillis();
                    c17729a.few = str;
                    boolean a = c45083e instanceof C25601a ? C41668e.m73056a((C25601a) c45083e, c17729a) : c45083e instanceof C25602c ? C41668e.m73057a((C25602c) c45083e, c17729a) : false;
                    if (a) {
                        for (String file : (List) hashMap.get(c17729a)) {
                            try {
                                new File(file).delete();
                            } catch (Throwable th) {
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(114540);
            }

            public final void dQu() {
                AppMethodBeat.m2504i(114541);
                if (C41668e.this.Atu != null) {
                    C41668e.this.Atu;
                }
                AppMethodBeat.m2505o(114541);
            }
        });
        AppMethodBeat.m2505o(114548);
    }

    /* renamed from: a */
    public final synchronized boolean mo67145a(C8766d c8766d) {
        int i;
        boolean th = true;
        synchronized (this) {
            AppMethodBeat.m2504i(114546);
            Context context = c8766d.context;
            if (context == null) {
                th = false;
                AppMethodBeat.m2505o(114546);
            } else {
                C45084h dQz = C45084h.dQz();
                if (!dQz.mInit) {
                    dQz.init(context);
                }
                if (this.apg) {
                    mo67143EH();
                }
                this.Ats = c8766d;
                this.apg = true;
                if (this.Atq == null) {
                    this.Atq = new C37319g(context);
                }
                if (this.Atq != null) {
                    C37319g c37319g = this.Atq;
                    synchronized (c37319g.AtL) {
                        try {
                            c37319g.AtL.clear();
                        } catch (Throwable th2) {
                            while (true) {
                                th = th2;
                            }
                            AppMethodBeat.m2505o(i);
                        } finally {
                            while (true) {
                            }
                            i = 114546;
                            AppMethodBeat.m2505o(114546);
                        }
                    }
                }
                i = this.Atr;
                synchronized (i) {
                    this.Atr.clear();
                }
                this.mHandler.postDelayed(this.Atv, c8766d.xzH);
            }
        }
        return th;
    }
}
