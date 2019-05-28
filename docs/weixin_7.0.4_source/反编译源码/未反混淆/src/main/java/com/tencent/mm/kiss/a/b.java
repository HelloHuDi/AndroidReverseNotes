package com.tencent.mm.kiss.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class b {
    private static b eMM;
    private ConcurrentHashMap<String, c> eML = new ConcurrentHashMap();
    public Looper eMN;
    public ak eMO;
    public boolean eMP = false;
    public boolean eMQ = false;
    public b eMR;
    public LayoutInflater mInflater;
    public int mMode = 2;

    static final class a implements OnAttachStateChangeListener {
        private String eMT;
        private b eMU;
        private c eMV = null;

        public a(String str, b bVar) {
            this.eMT = str;
            this.eMU = bVar;
        }

        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            AppMethodBeat.i(105679);
            c cVar = (c) this.eMU.eML.get(this.eMT);
            if (this.eMU.mMode == 1) {
                if (cVar != null) {
                    synchronized (cVar) {
                        try {
                            cVar.eNe.remove(view);
                            cVar.eNd.add(view);
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.o(105679);
                            }
                        }
                    }
                    if (this.eMV != null) {
                    }
                }
            } else if (cVar.eNh) {
                b.a(this.eMU, cVar);
            }
            view.removeOnAttachStateChangeListener(this);
            if (this.eMU.eMR != null) {
                b d = this.eMU.eMR;
                try {
                    if (d.EK()) {
                        d.mHandler.removeCallbacksAndMessages(null);
                        d.mHandler.sendEmptyMessageDelayed(0, 1000);
                    } else {
                        AppMethodBeat.o(105679);
                        return;
                    }
                } catch (Throwable th2) {
                    AppMethodBeat.o(105679);
                    return;
                }
            }
            AppMethodBeat.o(105679);
        }
    }

    public static final class b {
        Class eMW;
        Field eMX;
        Class eMY;
        Field eMZ = null;
        private boolean eNa = false;
        private boolean eNb = false;
        ak mHandler;

        public b(Looper looper) {
            AppMethodBeat.i(105681);
            this.mHandler = new ak(looper) {
                public final void handleMessage(Message message) {
                    long nanoTime;
                    AppMethodBeat.i(105680);
                    try {
                        nanoTime = System.nanoTime();
                        b bVar = b.this;
                        ThreadLocal threadLocal = (ThreadLocal) bVar.eMX.get(null);
                        if (threadLocal != null) {
                            Object obj = threadLocal.get();
                            if (obj != null) {
                                try {
                                    obj = bVar.eMZ.get(obj);
                                    if (obj != null) {
                                        if (obj instanceof List) {
                                            ((List) obj).clear();
                                        }
                                    }
                                } catch (IllegalAccessException e) {
                                    ab.printErrStackTrace("KISS.InflateRecycler", e, "", new Object[0]);
                                }
                            }
                        }
                    } catch (IllegalAccessException e2) {
                        ab.printErrStackTrace("KISS.InflateRecycler", e2, "", new Object[0]);
                    } catch (Throwable th) {
                        AppMethodBeat.o(105680);
                        return;
                    }
                    long nanoTime2 = System.nanoTime() - nanoTime;
                    ab.i("KISS.InflateRecycler", "durtion %s", Long.valueOf(nanoTime2));
                    AppMethodBeat.o(105680);
                }
            };
            AppMethodBeat.o(105681);
        }

        /* Access modifiers changed, original: final */
        public final boolean EK() {
            AppMethodBeat.i(105682);
            if (this.eNa) {
                boolean z = this.eNb;
                AppMethodBeat.o(105682);
                return z;
            }
            this.eNa = true;
            try {
                this.eMW = Class.forName("android.view.ViewRootImpl");
                try {
                    this.eMX = this.eMW.getDeclaredField("sRunQueues");
                    this.eMX.setAccessible(true);
                    try {
                        this.eMY = Class.forName("android.view.ViewRootImpl$RunQueue");
                        try {
                            this.eMZ = this.eMY.getDeclaredField("mActions");
                            this.eMZ.setAccessible(true);
                            this.eNb = true;
                            AppMethodBeat.o(105682);
                            return true;
                        } catch (NoSuchFieldException e) {
                            ab.printErrStackTrace("KISS.InflateRecycler", e, "", new Object[0]);
                            AppMethodBeat.o(105682);
                            return false;
                        }
                    } catch (ClassNotFoundException e2) {
                        ab.printErrStackTrace("KISS.InflateRecycler", e2, "", new Object[0]);
                        AppMethodBeat.o(105682);
                        return false;
                    }
                } catch (NoSuchFieldException e3) {
                    ab.printErrStackTrace("KISS.InflateRecycler", e3, "", new Object[0]);
                    AppMethodBeat.o(105682);
                    return false;
                }
            } catch (ClassNotFoundException e22) {
                ab.printErrStackTrace("KISS.InflateRecycler", e22, "", new Object[0]);
                AppMethodBeat.o(105682);
                return false;
            }
        }
    }

    public interface c {
    }

    /* renamed from: com.tencent.mm.kiss.a.b$1 */
    public class AnonymousClass1 extends ak {
        public AnonymousClass1(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(105676);
            ab.i("KISS.InflateRecycler", "InflateViewRecycler start %s", Long.valueOf(System.currentTimeMillis()));
            c cVar = (c) message.obj;
            int size = cVar.mCapacity - cVar.eNd.size();
            int i = cVar.Rt;
            ab.i("KISS.InflateRecycler", "InflateViewRecycler for %s", cVar.eMT);
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    View inflate = b.this.mInflater.inflate(i, cVar.eNg, false);
                    if (!(cVar.eNf == null || cVar.eNf.length == 0)) {
                        for (int i3 = 0; i3 < cVar.eNf.length; i3 += 2) {
                            View findViewById = inflate.findViewById(cVar.eNf[i3]);
                            if (findViewById != null && (findViewById instanceof ViewStub)) {
                                int i4 = cVar.eNf[i3 + 1];
                                if (i4 != 0) {
                                    ((ViewStub) findViewById).setLayoutResource(i4);
                                }
                                ((ViewStub) findViewById).inflate();
                            }
                        }
                    }
                    synchronized (cVar) {
                        cVar.eNd.add(inflate);
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("KISS.InflateRecycler", e, "pre inflate failed.", new Object[0]);
                } catch (Throwable th) {
                    AppMethodBeat.o(105676);
                }
            }
            ab.i("KISS.InflateRecycler", "InflateViewRecycler end %s", Long.valueOf(System.currentTimeMillis()));
            ab.i("KISS.InflateRecycler", "preload done");
            AppMethodBeat.o(105676);
        }
    }

    public b() {
        AppMethodBeat.i(105683);
        AppMethodBeat.o(105683);
    }

    static {
        AppMethodBeat.i(105689);
        eMM = null;
        eMM = new b();
        AppMethodBeat.o(105689);
    }

    public static b SM() {
        return eMM;
    }

    public final View a(Activity activity, String str, int i) {
        AppMethodBeat.i(105684);
        View inflate;
        if (this.eMQ) {
            ab.i("KISS.InflateRecycler", "not support application inflate");
            inflate = activity.getLayoutInflater().inflate(i, null);
            AppMethodBeat.o(105684);
            return inflate;
        } else if (this.eMP) {
            c cVar = (c) this.eML.get(str);
            if (cVar != null) {
                synchronized (cVar) {
                    try {
                        inflate = (View) cVar.eNd.poll();
                        if (this.mMode == 1) {
                            cVar.eNe.add(inflate);
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(105684);
                    }
                }
                if (inflate != null) {
                    ab.i("KISS.InflateRecycler", "cache reach %s", str);
                    inflate.addOnAttachStateChangeListener(new a(str, this));
                    return inflate;
                }
            }
            ab.i("KISS.InflateRecycler", "no cache reach %s", str);
            inflate = this.mInflater.inflate(i, null);
            AppMethodBeat.o(105684);
            return inflate;
        } else {
            inflate = activity.getLayoutInflater().inflate(i, null);
            AppMethodBeat.o(105684);
            return inflate;
        }
    }

    public final boolean a(String str, int i, int... iArr) {
        AppMethodBeat.i(105685);
        boolean a = a(str, i, R.layout.awu, null, true, iArr);
        AppMethodBeat.o(105685);
        return a;
    }

    public final boolean a(String str, int i, int i2, int... iArr) {
        AppMethodBeat.i(105686);
        boolean a = a(str, i, i2, null, false, iArr);
        AppMethodBeat.o(105686);
        return a;
    }

    public final boolean a(String str, int i, int i2, ViewGroup viewGroup, boolean z, int... iArr) {
        AppMethodBeat.i(105687);
        if (!this.eMP) {
            AppMethodBeat.o(105687);
            return false;
        } else if (this.eMQ) {
            ab.i("KISS.InflateRecycler", "not support application inflate");
            AppMethodBeat.o(105687);
            return false;
        } else {
            if (viewGroup != null) {
                if (VERSION.SDK_INT >= 19) {
                    Assert.assertFalse(viewGroup.isAttachedToWindow());
                }
                Assert.assertTrue(viewGroup.getParent() == null);
            }
            if (((c) this.eML.get(str)) != null) {
                AppMethodBeat.o(105687);
                return false;
            }
            c cVar = new c();
            this.eML.put(str, cVar);
            cVar.mCapacity = i;
            cVar.eMT = str;
            cVar.Rt = i2;
            cVar.eNf = iArr;
            cVar.eNg = viewGroup;
            cVar.eNh = z;
            this.eMO.sendMessage(this.eMO.obtainMessage(0, cVar));
            AppMethodBeat.o(105687);
            return true;
        }
    }

    static /* synthetic */ void a(b bVar, c cVar) {
        AppMethodBeat.i(105688);
        if (bVar.eMP && !bVar.eMQ && cVar.mCapacity > cVar.eNd.size()) {
            bVar.eMO.sendMessage(bVar.eMO.obtainMessage(0, cVar));
        }
        AppMethodBeat.o(105688);
    }
}
