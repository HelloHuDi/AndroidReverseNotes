package com.tencent.g;

import com.tencent.g.b.b;
import com.tencent.g.b.c;
import com.tencent.g.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class f {
    private static f AHA;
    private HashMap<String, g> AHB = new HashMap();
    HashMap<String, Object> AHC = new HashMap();
    private Object AHD = new Object();
    Object AHE = new Object();
    private a AHF = new a();

    class a {
        private final HashMap<String, Object> AHG = new HashMap();
        private final Object mLock = new Object();

        a() {
            AppMethodBeat.i(127748);
            AppMethodBeat.o(127748);
        }

        /* Access modifiers changed, original: final */
        public final void iD(String str, String str2) {
            AppMethodBeat.i(127749);
            c cVar = str + str2;
            synchronized (this.mLock) {
                while (this.AHG.get(cVar) != null) {
                    try {
                        this.mLock.wait();
                    } catch (InterruptedException e) {
                        cVar = new c("install fail,lock interrupted!");
                        throw cVar;
                    } finally {
                        AppMethodBeat.o(127749);
                    }
                }
                this.AHG.put(cVar, str2);
            }
        }

        /* Access modifiers changed, original: final */
        public final void iE(String str, String str2) {
            AppMethodBeat.i(127750);
            String str3 = str + str2;
            synchronized (this.mLock) {
                try {
                    this.AHG.remove(str3);
                    this.mLock.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(127750);
                }
            }
        }
    }

    public f() {
        AppMethodBeat.i(127751);
        AppMethodBeat.o(127751);
    }

    static f dSG() {
        AppMethodBeat.i(127752);
        if (AHA == null) {
            synchronized (f.class) {
                try {
                    if (AHA == null) {
                        AHA = new f();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(127752);
                    }
                }
            }
        }
        f fVar = AHA;
        AppMethodBeat.o(127752);
        return fVar;
    }

    public static Object aux(String str) {
        AppMethodBeat.i(127753);
        Object auy = dSG().auy(str);
        AppMethodBeat.o(127753);
        return auy;
    }

    public static b a(d dVar) {
        AppMethodBeat.i(127754);
        b b = dSG().b(dVar);
        AppMethodBeat.o(127754);
        return b;
    }

    private Object auy(String str) {
        AppMethodBeat.i(127755);
        if (str == null) {
            h hVar = new h("TpfServiceCenter|getService|service name should not be null");
            AppMethodBeat.o(127755);
            throw hVar;
        }
        Object obj;
        Object c;
        synchronized (this.AHE) {
            try {
                obj = this.AHC.get(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(127755);
                }
            }
        }
        if (obj == null) {
            g gVar;
            synchronized (this.AHD) {
                try {
                    gVar = (g) this.AHB.get(str);
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.o(127755);
                    }
                }
            }
            if (gVar != null) {
                if (gVar.AHJ.AHU) {
                    c = c(gVar);
                } else {
                    if (4 == gVar.mState) {
                        try {
                            a(gVar);
                        } catch (c e) {
                            com.tencent.pb.common.c.c.w("service", e);
                            AppMethodBeat.o(127755);
                            return null;
                        }
                    }
                    synchronized (this.AHE) {
                        try {
                            c = this.AHC.get(str);
                        } catch (Throwable th3) {
                            AppMethodBeat.o(127755);
                        }
                    }
                }
                AppMethodBeat.o(127755);
                return c;
            }
        }
        c = obj;
        AppMethodBeat.o(127755);
        return c;
    }

    private b b(d dVar) {
        Object obj = 1;
        AppMethodBeat.i(127756);
        if (dVar == null || dVar.AHS == null) {
            AppMethodBeat.o(127756);
            return null;
        }
        String str = dVar.AHS;
        this.AHF.iD("install_", str);
        try {
            b bVar;
            Object obj2;
            synchronized (this.AHD) {
                bVar = (g) this.AHB.get(str);
                if (bVar == null) {
                    bVar = new g(this, dVar);
                    bVar.mState = 2;
                    com.tencent.pb.common.c.c.d("service", "service [", str, "] installed!");
                    this.AHB.put(str, bVar);
                    obj2 = 1;
                } else {
                    com.tencent.pb.common.c.c.d("service", "service [", str, "] had been installed!");
                    obj2 = null;
                }
            }
            if (obj2 != null) {
                if (dVar.AHR == null) {
                    obj = null;
                }
                if (obj != null) {
                    bVar.mState = 4;
                    com.tencent.pb.common.c.c.d("service", "service [", str, "] resolved!");
                } else {
                    c cVar = new c("resolve service [" + str + "] failed.");
                    AppMethodBeat.o(127756);
                    throw cVar;
                }
            }
            this.AHF.iE("install_", str);
            AppMethodBeat.o(127756);
            return bVar;
        } catch (Throwable th) {
            this.AHF.iE("install_", str);
            AppMethodBeat.o(127756);
        }
    }

    private boolean Z(String[] strArr) {
        boolean z;
        AppMethodBeat.i(127758);
        if (strArr != null) {
            for (Object obj : strArr) {
                if (obj != null) {
                    g gVar;
                    synchronized (this.AHD) {
                        try {
                            gVar = (g) this.AHB.get(obj);
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.o(127758);
                            }
                        }
                    }
                    if (gVar == null) {
                        z = false;
                        break;
                    }
                    a(gVar);
                    if (gVar.mState != 32) {
                        z = false;
                        break;
                    }
                    gVar.mReferenceCount++;
                    com.tencent.pb.common.c.c.d("reference_count", "addReferenceCount|", gVar.AHJ.AHS, "|refcount=", Integer.valueOf(gVar.mReferenceCount));
                }
            }
        }
        z = true;
        AppMethodBeat.o(127758);
        return z;
    }

    /* Access modifiers changed, original: final */
    public final boolean a(g gVar) {
        boolean z = false;
        AppMethodBeat.i(127757);
        d dVar = gVar.AHJ;
        String str = dVar.AHS;
        this.AHF.iD("service_", str);
        try {
            if (gVar.mState == 32) {
                z = true;
            } else if (gVar.mState == 4) {
                gVar.mState = 8;
                com.tencent.pb.common.c.c.d("service", "service [", str, "] starting...");
                if (dVar.AHT != null) {
                    Z(dVar.AHT);
                }
                if (b(gVar)) {
                    gVar.mState = 32;
                    com.tencent.pb.common.c.c.d("service", "service [", str, "] active...");
                    z = true;
                }
            }
            this.AHF.iE("service_", str);
            if (z) {
                AppMethodBeat.o(127757);
                return true;
            }
            c cVar = new c("startService [" + str + "] failed");
            AppMethodBeat.o(127757);
            throw cVar;
        } catch (Throwable th) {
            this.AHF.iE("service_", str);
            AppMethodBeat.o(127757);
        }
    }

    private static boolean b(g gVar) {
        boolean z;
        AppMethodBeat.i(127759);
        if (!gVar.AHJ.AHU) {
            try {
                b bVar = (b) Class.forName(gVar.AHJ.AHR).newInstance();
                gVar.AHK = bVar;
                a aVar = new a(gVar);
                gVar.AHL = aVar;
                bVar.a(aVar);
                z = true;
            } catch (Exception e) {
                com.tencent.pb.common.c.c.w("service", e);
            }
            AppMethodBeat.o(127759);
            return z;
        }
        z = false;
        AppMethodBeat.o(127759);
        return z;
    }

    private static Object c(g gVar) {
        AppMethodBeat.i(127760);
        try {
            c cVar = (c) Class.forName(gVar.AHJ.AHR).newInstance();
            gVar.AHL = new a(gVar);
            gVar.mState = 32;
            Object dSB = cVar.dSB();
            AppMethodBeat.o(127760);
            return dSB;
        } catch (Exception e) {
            com.tencent.pb.common.c.c.w("service", e);
            AppMethodBeat.o(127760);
            return null;
        }
    }
}
