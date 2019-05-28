package com.tencent.p177mm.kiss.p243a;

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
import com.tencent.p177mm.p230g.p231a.C6487gn;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.kiss.a.b */
public final class C1742b {
    private static C1742b eMM;
    private ConcurrentHashMap<String, C1745c> eML = new ConcurrentHashMap();
    public Looper eMN;
    public C7306ak eMO;
    public boolean eMP = false;
    public boolean eMQ = false;
    public C1739b eMR;
    public LayoutInflater mInflater;
    public int mMode = 2;

    /* renamed from: com.tencent.mm.kiss.a.b$a */
    static final class C1738a implements OnAttachStateChangeListener {
        private String eMT;
        private C1742b eMU;
        private C1741c eMV = null;

        public C1738a(String str, C1742b c1742b) {
            this.eMT = str;
            this.eMU = c1742b;
        }

        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            AppMethodBeat.m2504i(105679);
            C1745c c1745c = (C1745c) this.eMU.eML.get(this.eMT);
            if (this.eMU.mMode == 1) {
                if (c1745c != null) {
                    synchronized (c1745c) {
                        try {
                            c1745c.eNe.remove(view);
                            c1745c.eNd.add(view);
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.m2505o(105679);
                            }
                        }
                    }
                    if (this.eMV != null) {
                    }
                }
            } else if (c1745c.eNh) {
                C1742b.m3598a(this.eMU, c1745c);
            }
            view.removeOnAttachStateChangeListener(this);
            if (this.eMU.eMR != null) {
                C1739b d = this.eMU.eMR;
                try {
                    if (d.mo5273EK()) {
                        d.mHandler.removeCallbacksAndMessages(null);
                        d.mHandler.sendEmptyMessageDelayed(0, 1000);
                    } else {
                        AppMethodBeat.m2505o(105679);
                        return;
                    }
                } catch (Throwable th2) {
                    AppMethodBeat.m2505o(105679);
                    return;
                }
            }
            AppMethodBeat.m2505o(105679);
        }
    }

    /* renamed from: com.tencent.mm.kiss.a.b$b */
    public static final class C1739b {
        Class eMW;
        Field eMX;
        Class eMY;
        Field eMZ = null;
        private boolean eNa = false;
        private boolean eNb = false;
        C7306ak mHandler;

        public C1739b(Looper looper) {
            AppMethodBeat.m2504i(105681);
            this.mHandler = new C7306ak(looper) {
                public final void handleMessage(Message message) {
                    long nanoTime;
                    AppMethodBeat.m2504i(105680);
                    try {
                        nanoTime = System.nanoTime();
                        C1739b c1739b = C1739b.this;
                        ThreadLocal threadLocal = (ThreadLocal) c1739b.eMX.get(null);
                        if (threadLocal != null) {
                            Object obj = threadLocal.get();
                            if (obj != null) {
                                try {
                                    obj = c1739b.eMZ.get(obj);
                                    if (obj != null) {
                                        if (obj instanceof List) {
                                            ((List) obj).clear();
                                        }
                                    }
                                } catch (IllegalAccessException e) {
                                    C4990ab.printErrStackTrace("KISS.InflateRecycler", e, "", new Object[0]);
                                }
                            }
                        }
                    } catch (IllegalAccessException e2) {
                        C4990ab.printErrStackTrace("KISS.InflateRecycler", e2, "", new Object[0]);
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(105680);
                        return;
                    }
                    long nanoTime2 = System.nanoTime() - nanoTime;
                    C4990ab.m7417i("KISS.InflateRecycler", "durtion %s", Long.valueOf(nanoTime2));
                    AppMethodBeat.m2505o(105680);
                }
            };
            AppMethodBeat.m2505o(105681);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: EK */
        public final boolean mo5273EK() {
            AppMethodBeat.m2504i(105682);
            if (this.eNa) {
                boolean z = this.eNb;
                AppMethodBeat.m2505o(105682);
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
                            AppMethodBeat.m2505o(105682);
                            return true;
                        } catch (NoSuchFieldException e) {
                            C4990ab.printErrStackTrace("KISS.InflateRecycler", e, "", new Object[0]);
                            AppMethodBeat.m2505o(105682);
                            return false;
                        }
                    } catch (ClassNotFoundException e2) {
                        C4990ab.printErrStackTrace("KISS.InflateRecycler", e2, "", new Object[0]);
                        AppMethodBeat.m2505o(105682);
                        return false;
                    }
                } catch (NoSuchFieldException e3) {
                    C4990ab.printErrStackTrace("KISS.InflateRecycler", e3, "", new Object[0]);
                    AppMethodBeat.m2505o(105682);
                    return false;
                }
            } catch (ClassNotFoundException e22) {
                C4990ab.printErrStackTrace("KISS.InflateRecycler", e22, "", new Object[0]);
                AppMethodBeat.m2505o(105682);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.kiss.a.b$c */
    public interface C1741c {
    }

    /* renamed from: com.tencent.mm.kiss.a.b$2 */
    public class C17432 extends C4884c<C6487gn> {
        public C17432() {
            AppMethodBeat.m2504i(105677);
            this.xxI = C6487gn.class.getName().hashCode();
            AppMethodBeat.m2505o(105677);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(105678);
            for (String str : C1742b.this.eML.keySet()) {
                C1745c c1745c = (C1745c) C1742b.this.eML.get(str);
                c1745c.eNd.clear();
                C1742b.m3598a(C1742b.this, c1745c);
            }
            AppMethodBeat.m2505o(105678);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.kiss.a.b$1 */
    public class C17441 extends C7306ak {
        public C17441(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(105676);
            C4990ab.m7417i("KISS.InflateRecycler", "InflateViewRecycler start %s", Long.valueOf(System.currentTimeMillis()));
            C1745c c1745c = (C1745c) message.obj;
            int size = c1745c.mCapacity - c1745c.eNd.size();
            int i = c1745c.f1234Rt;
            C4990ab.m7417i("KISS.InflateRecycler", "InflateViewRecycler for %s", c1745c.eMT);
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    View inflate = C1742b.this.mInflater.inflate(i, c1745c.eNg, false);
                    if (!(c1745c.eNf == null || c1745c.eNf.length == 0)) {
                        for (int i3 = 0; i3 < c1745c.eNf.length; i3 += 2) {
                            View findViewById = inflate.findViewById(c1745c.eNf[i3]);
                            if (findViewById != null && (findViewById instanceof ViewStub)) {
                                int i4 = c1745c.eNf[i3 + 1];
                                if (i4 != 0) {
                                    ((ViewStub) findViewById).setLayoutResource(i4);
                                }
                                ((ViewStub) findViewById).inflate();
                            }
                        }
                    }
                    synchronized (c1745c) {
                        c1745c.eNd.add(inflate);
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("KISS.InflateRecycler", e, "pre inflate failed.", new Object[0]);
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(105676);
                }
            }
            C4990ab.m7417i("KISS.InflateRecycler", "InflateViewRecycler end %s", Long.valueOf(System.currentTimeMillis()));
            C4990ab.m7416i("KISS.InflateRecycler", "preload done");
            AppMethodBeat.m2505o(105676);
        }
    }

    public C1742b() {
        AppMethodBeat.m2504i(105683);
        AppMethodBeat.m2505o(105683);
    }

    static {
        AppMethodBeat.m2504i(105689);
        eMM = null;
        eMM = new C1742b();
        AppMethodBeat.m2505o(105689);
    }

    /* renamed from: SM */
    public static C1742b m3596SM() {
        return eMM;
    }

    /* renamed from: a */
    public final View mo5274a(Activity activity, String str, int i) {
        AppMethodBeat.m2504i(105684);
        View inflate;
        if (this.eMQ) {
            C4990ab.m7416i("KISS.InflateRecycler", "not support application inflate");
            inflate = activity.getLayoutInflater().inflate(i, null);
            AppMethodBeat.m2505o(105684);
            return inflate;
        } else if (this.eMP) {
            C1745c c1745c = (C1745c) this.eML.get(str);
            if (c1745c != null) {
                synchronized (c1745c) {
                    try {
                        inflate = (View) c1745c.eNd.poll();
                        if (this.mMode == 1) {
                            c1745c.eNe.add(inflate);
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(105684);
                    }
                }
                if (inflate != null) {
                    C4990ab.m7417i("KISS.InflateRecycler", "cache reach %s", str);
                    inflate.addOnAttachStateChangeListener(new C1738a(str, this));
                    return inflate;
                }
            }
            C4990ab.m7417i("KISS.InflateRecycler", "no cache reach %s", str);
            inflate = this.mInflater.inflate(i, null);
            AppMethodBeat.m2505o(105684);
            return inflate;
        } else {
            inflate = activity.getLayoutInflater().inflate(i, null);
            AppMethodBeat.m2505o(105684);
            return inflate;
        }
    }

    /* renamed from: a */
    public final boolean mo5277a(String str, int i, int... iArr) {
        AppMethodBeat.m2504i(105685);
        boolean a = mo5275a(str, i, 2130970820, null, true, iArr);
        AppMethodBeat.m2505o(105685);
        return a;
    }

    /* renamed from: a */
    public final boolean mo5276a(String str, int i, int i2, int... iArr) {
        AppMethodBeat.m2504i(105686);
        boolean a = mo5275a(str, i, i2, null, false, iArr);
        AppMethodBeat.m2505o(105686);
        return a;
    }

    /* renamed from: a */
    public final boolean mo5275a(String str, int i, int i2, ViewGroup viewGroup, boolean z, int... iArr) {
        AppMethodBeat.m2504i(105687);
        if (!this.eMP) {
            AppMethodBeat.m2505o(105687);
            return false;
        } else if (this.eMQ) {
            C4990ab.m7416i("KISS.InflateRecycler", "not support application inflate");
            AppMethodBeat.m2505o(105687);
            return false;
        } else {
            if (viewGroup != null) {
                if (VERSION.SDK_INT >= 19) {
                    Assert.assertFalse(viewGroup.isAttachedToWindow());
                }
                Assert.assertTrue(viewGroup.getParent() == null);
            }
            if (((C1745c) this.eML.get(str)) != null) {
                AppMethodBeat.m2505o(105687);
                return false;
            }
            C1745c c1745c = new C1745c();
            this.eML.put(str, c1745c);
            c1745c.mCapacity = i;
            c1745c.eMT = str;
            c1745c.f1234Rt = i2;
            c1745c.eNf = iArr;
            c1745c.eNg = viewGroup;
            c1745c.eNh = z;
            this.eMO.sendMessage(this.eMO.obtainMessage(0, c1745c));
            AppMethodBeat.m2505o(105687);
            return true;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m3598a(C1742b c1742b, C1745c c1745c) {
        AppMethodBeat.m2504i(105688);
        if (c1742b.eMP && !c1742b.eMQ && c1745c.mCapacity > c1745c.eNd.size()) {
            c1742b.eMO.sendMessage(c1742b.eMO.obtainMessage(0, c1745c));
        }
        AppMethodBeat.m2505o(105688);
    }
}
