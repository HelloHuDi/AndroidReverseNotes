package com.tencent.mm.plugin.appbrand.appusage;

import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Parcel;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class o extends k implements ag {
    private final Set<com.tencent.mm.sdk.e.k.a> gZx = new HashSet();

    static final class a implements i<IPCInteger, Parcel> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(129585);
            Parcel a = a((IPCInteger) obj);
            AppMethodBeat.o(129585);
            return a;
        }

        private static Parcel a(IPCInteger iPCInteger) {
            AppMethodBeat.i(129584);
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeTypedList(((ag) g.K(ag.class)).nA(iPCInteger.value));
                AppMethodBeat.o(129584);
                return obtain;
            } catch (Exception e) {
                obtain.setDataPosition(0);
                obtain.writeTypedList(null);
                AppMethodBeat.o(129584);
                return obtain;
            }
        }
    }

    static final class c implements i<AppIdentity, IPCBoolean> {
        private c() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(129591);
            IPCBoolean c = c((AppIdentity) obj);
            AppMethodBeat.o(129591);
            return c;
        }

        private static IPCBoolean c(AppIdentity appIdentity) {
            AppMethodBeat.i(129590);
            IPCBoolean iPCBoolean;
            try {
                iPCBoolean = new IPCBoolean(((ag) g.K(ag.class)).aE(appIdentity.username, appIdentity.har));
                AppMethodBeat.o(129590);
                return iPCBoolean;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrandLocalUsageStorageIPCImpl", e, "ipc removeUsage", new Object[0]);
                iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.o(129590);
                return iPCBoolean;
            }
        }
    }

    static final class b implements com.tencent.mm.ipcinvoker.a<IPCVoid, Parcel> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, final com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(129589);
            final AnonymousClass1 anonymousClass1 = new com.tencent.mm.sdk.e.k.a() {
                public final void a(String str, m mVar) {
                    AppMethodBeat.i(129586);
                    if (cVar != null) {
                        Parcel obtain = Parcel.obtain();
                        obtain.writeString(str);
                        obtain.writeInt(mVar.hsh);
                        obtain.writeString(mVar.obj == null ? null : mVar.obj.toString());
                        cVar.ao(obtain);
                    }
                    AppMethodBeat.o(129586);
                }
            };
            ((ag) g.K(ag.class)).a(anonymousClass1, e.aNS().oAl.getLooper());
            ((com.tencent.mm.ipcinvoker.e.a) cVar).a(new com.tencent.mm.ipcinvoker.e.b() {
                public final void d(Exception exception) {
                    AppMethodBeat.i(129588);
                    if (exception instanceof DeadObjectException) {
                        new ak(Looper.myLooper()).post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(129587);
                                ((ag) g.K(ag.class)).d(anonymousClass1);
                                AppMethodBeat.o(129587);
                            }
                        });
                        AppMethodBeat.o(129588);
                        return;
                    }
                    ab.e("MicroMsg.AppBrandLocalUsageStorageIPCImpl", "onExceptionOccur(%s)", Log.getStackTraceString(exception));
                    AppMethodBeat.o(129588);
                }
            });
            AppMethodBeat.o(129589);
        }
    }

    public o() {
        AppMethodBeat.i(129592);
        AppMethodBeat.o(129592);
    }

    public final boolean aE(String str, int i) {
        AppMethodBeat.i(129593);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a("com.tencent.mm", new AppIdentity(str, i), c.class);
        if (iPCBoolean == null) {
            AppMethodBeat.o(129593);
            return false;
        }
        boolean z = iPCBoolean.value;
        AppMethodBeat.o(129593);
        return z;
    }

    public final List<LocalUsageInfo> nA(int i) {
        AppMethodBeat.i(129594);
        Parcel parcel = (Parcel) XIPCInvoker.a("com.tencent.mm", new IPCInteger(i), a.class);
        if (parcel == null) {
            AppMethodBeat.o(129594);
            return null;
        }
        ArrayList arrayList = new ArrayList(i);
        parcel.readTypedList(arrayList, LocalUsageInfo.CREATOR);
        AppMethodBeat.o(129594);
        return arrayList;
    }

    public final void c(com.tencent.mm.sdk.e.k.a aVar) {
        AppMethodBeat.i(129595);
        a(aVar, Looper.getMainLooper());
        AppMethodBeat.o(129595);
    }

    public final void a(com.tencent.mm.sdk.e.k.a aVar, Looper looper) {
        Object obj = 1;
        AppMethodBeat.i(129596);
        if (aVar == null || looper == null) {
            AppMethodBeat.o(129596);
            return;
        }
        super.a(aVar, looper);
        synchronized (this.gZx) {
            try {
                this.gZx.add(aVar);
                if (this.gZx.size() != 1) {
                    obj = null;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(129596);
                }
            }
        }
        if (obj != null) {
            XIPCInvoker.a("com.tencent.mm", IPCVoid.eGH, b.class, new com.tencent.mm.ipcinvoker.c<Parcel>() {
                public final /* synthetic */ void ao(Object obj) {
                    AppMethodBeat.i(129583);
                    Parcel parcel = (Parcel) obj;
                    o.this.b(parcel.readString(), parcel.readInt(), parcel.readString());
                    AppMethodBeat.o(129583);
                }
            });
        }
        AppMethodBeat.o(129596);
    }

    public final void d(com.tencent.mm.sdk.e.k.a aVar) {
        AppMethodBeat.i(129597);
        if (aVar == null) {
            AppMethodBeat.o(129597);
            return;
        }
        super.d(aVar);
        synchronized (this.gZx) {
            try {
                this.gZx.remove(aVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(129597);
            }
        }
    }
}
