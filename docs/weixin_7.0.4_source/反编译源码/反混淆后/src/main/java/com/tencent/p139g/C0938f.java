package com.tencent.p139g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p139g.p1166b.C17760c;
import com.tencent.p139g.p1166b.C25637b;
import com.tencent.p139g.p1166b.C25638d;
import com.tencent.p659pb.common.p1102c.C44443c;
import java.util.HashMap;

/* renamed from: com.tencent.g.f */
public final class C0938f {
    private static C0938f AHA;
    private HashMap<String, C0940g> AHB = new HashMap();
    HashMap<String, Object> AHC = new HashMap();
    private Object AHD = new Object();
    Object AHE = new Object();
    private C0939a AHF = new C0939a();

    /* renamed from: com.tencent.g.f$a */
    class C0939a {
        private final HashMap<String, Object> AHG = new HashMap();
        private final Object mLock = new Object();

        C0939a() {
            AppMethodBeat.m2504i(127748);
            AppMethodBeat.m2505o(127748);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: iD */
        public final void mo3772iD(String str, String str2) {
            AppMethodBeat.m2504i(127749);
            C17760c c17760c = str + str2;
            synchronized (this.mLock) {
                while (this.AHG.get(c17760c) != null) {
                    try {
                        this.mLock.wait();
                    } catch (InterruptedException e) {
                        c17760c = new C17760c("install fail,lock interrupted!");
                        throw c17760c;
                    } finally {
                        AppMethodBeat.m2505o(127749);
                    }
                }
                this.AHG.put(c17760c, str2);
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: iE */
        public final void mo3773iE(String str, String str2) {
            AppMethodBeat.m2504i(127750);
            String str3 = str + str2;
            synchronized (this.mLock) {
                try {
                    this.AHG.remove(str3);
                    this.mLock.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(127750);
                }
            }
        }
    }

    public C0938f() {
        AppMethodBeat.m2504i(127751);
        AppMethodBeat.m2505o(127751);
    }

    static C0938f dSG() {
        AppMethodBeat.m2504i(127752);
        if (AHA == null) {
            synchronized (C0938f.class) {
                try {
                    if (AHA == null) {
                        AHA = new C0938f();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(127752);
                    }
                }
            }
        }
        C0938f c0938f = AHA;
        AppMethodBeat.m2505o(127752);
        return c0938f;
    }

    public static Object aux(String str) {
        AppMethodBeat.m2504i(127753);
        Object auy = C0938f.dSG().auy(str);
        AppMethodBeat.m2505o(127753);
        return auy;
    }

    /* renamed from: a */
    public static C25637b m2110a(C25638d c25638d) {
        AppMethodBeat.m2504i(127754);
        C25637b b = C0938f.dSG().m2111b(c25638d);
        AppMethodBeat.m2505o(127754);
        return b;
    }

    private Object auy(String str) {
        AppMethodBeat.m2504i(127755);
        if (str == null) {
            C0941h c0941h = new C0941h("TpfServiceCenter|getService|service name should not be null");
            AppMethodBeat.m2505o(127755);
            throw c0941h;
        }
        Object obj;
        Object c;
        synchronized (this.AHE) {
            try {
                obj = this.AHC.get(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(127755);
                }
            }
        }
        if (obj == null) {
            C0940g c0940g;
            synchronized (this.AHD) {
                try {
                    c0940g = (C0940g) this.AHB.get(str);
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.m2505o(127755);
                    }
                }
            }
            if (c0940g != null) {
                if (c0940g.AHJ.AHU) {
                    c = C0938f.m2113c(c0940g);
                } else {
                    if (4 == c0940g.mState) {
                        try {
                            mo3771a(c0940g);
                        } catch (C17760c e) {
                            C44443c.m80392w("service", e);
                            AppMethodBeat.m2505o(127755);
                            return null;
                        }
                    }
                    synchronized (this.AHE) {
                        try {
                            c = this.AHC.get(str);
                        } catch (Throwable th3) {
                            AppMethodBeat.m2505o(127755);
                        }
                    }
                }
                AppMethodBeat.m2505o(127755);
                return c;
            }
        }
        c = obj;
        AppMethodBeat.m2505o(127755);
        return c;
    }

    /* renamed from: b */
    private C25637b m2111b(C25638d c25638d) {
        Object obj = 1;
        AppMethodBeat.m2504i(127756);
        if (c25638d == null || c25638d.AHS == null) {
            AppMethodBeat.m2505o(127756);
            return null;
        }
        String str = c25638d.AHS;
        this.AHF.mo3772iD("install_", str);
        try {
            C25637b c25637b;
            Object obj2;
            synchronized (this.AHD) {
                c25637b = (C0940g) this.AHB.get(str);
                if (c25637b == null) {
                    c25637b = new C0940g(this, c25638d);
                    c25637b.mState = 2;
                    C44443c.m80389d("service", "service [", str, "] installed!");
                    this.AHB.put(str, c25637b);
                    obj2 = 1;
                } else {
                    C44443c.m80389d("service", "service [", str, "] had been installed!");
                    obj2 = null;
                }
            }
            if (obj2 != null) {
                if (c25638d.AHR == null) {
                    obj = null;
                }
                if (obj != null) {
                    c25637b.mState = 4;
                    C44443c.m80389d("service", "service [", str, "] resolved!");
                } else {
                    C17760c c17760c = new C17760c("resolve service [" + str + "] failed.");
                    AppMethodBeat.m2505o(127756);
                    throw c17760c;
                }
            }
            this.AHF.mo3773iE("install_", str);
            AppMethodBeat.m2505o(127756);
            return c25637b;
        } catch (Throwable th) {
            this.AHF.mo3773iE("install_", str);
            AppMethodBeat.m2505o(127756);
        }
    }

    /* renamed from: Z */
    private boolean m2109Z(String[] strArr) {
        boolean z;
        AppMethodBeat.m2504i(127758);
        if (strArr != null) {
            for (Object obj : strArr) {
                if (obj != null) {
                    C0940g c0940g;
                    synchronized (this.AHD) {
                        try {
                            c0940g = (C0940g) this.AHB.get(obj);
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.m2505o(127758);
                            }
                        }
                    }
                    if (c0940g == null) {
                        z = false;
                        break;
                    }
                    mo3771a(c0940g);
                    if (c0940g.mState != 32) {
                        z = false;
                        break;
                    }
                    c0940g.mReferenceCount++;
                    C44443c.m80389d("reference_count", "addReferenceCount|", c0940g.AHJ.AHS, "|refcount=", Integer.valueOf(c0940g.mReferenceCount));
                }
            }
        }
        z = true;
        AppMethodBeat.m2505o(127758);
        return z;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo3771a(C0940g c0940g) {
        boolean z = false;
        AppMethodBeat.m2504i(127757);
        C25638d c25638d = c0940g.AHJ;
        String str = c25638d.AHS;
        this.AHF.mo3772iD("service_", str);
        try {
            if (c0940g.mState == 32) {
                z = true;
            } else if (c0940g.mState == 4) {
                c0940g.mState = 8;
                C44443c.m80389d("service", "service [", str, "] starting...");
                if (c25638d.AHT != null) {
                    m2109Z(c25638d.AHT);
                }
                if (C0938f.m2112b(c0940g)) {
                    c0940g.mState = 32;
                    C44443c.m80389d("service", "service [", str, "] active...");
                    z = true;
                }
            }
            this.AHF.mo3773iE("service_", str);
            if (z) {
                AppMethodBeat.m2505o(127757);
                return true;
            }
            C17760c c17760c = new C17760c("startService [" + str + "] failed");
            AppMethodBeat.m2505o(127757);
            throw c17760c;
        } catch (Throwable th) {
            this.AHF.mo3773iE("service_", str);
            AppMethodBeat.m2505o(127757);
        }
    }

    /* renamed from: b */
    private static boolean m2112b(C0940g c0940g) {
        boolean z;
        AppMethodBeat.m2504i(127759);
        if (!c0940g.AHJ.AHU) {
            try {
                C32132b c32132b = (C32132b) Class.forName(c0940g.AHJ.AHR).newInstance();
                c0940g.AHK = c32132b;
                C37344a c37344a = new C37344a(c0940g);
                c0940g.AHL = c37344a;
                c32132b.mo52707a(c37344a);
                z = true;
            } catch (Exception e) {
                C44443c.m80392w("service", e);
            }
            AppMethodBeat.m2505o(127759);
            return z;
        }
        z = false;
        AppMethodBeat.m2505o(127759);
        return z;
    }

    /* renamed from: c */
    private static Object m2113c(C0940g c0940g) {
        AppMethodBeat.m2504i(127760);
        try {
            C32133c c32133c = (C32133c) Class.forName(c0940g.AHJ.AHR).newInstance();
            c0940g.AHL = new C37344a(c0940g);
            c0940g.mState = 32;
            Object dSB = c32133c.dSB();
            AppMethodBeat.m2505o(127760);
            return dSB;
        } catch (Exception e) {
            C44443c.m80392w("service", e);
            AppMethodBeat.m2505o(127760);
            return null;
        }
    }
}
