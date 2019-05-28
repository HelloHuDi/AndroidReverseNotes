package com.tencent.p177mm.plugin.appbrand.appusage;

import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Parcel;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.p1532e.C37868a;
import com.tencent.p177mm.ipcinvoker.p1532e.C42131b;
import com.tencent.p177mm.ipcinvoker.type.IPCBoolean;
import com.tencent.p177mm.ipcinvoker.type.IPCInteger;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.o */
public final class C42377o extends C7296k implements C26767ag {
    private final Set<C4931a> gZx = new HashSet();

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.o$1 */
    class C246891 implements C18507c<Parcel> {
        C246891() {
        }

        /* renamed from: ao */
        public final /* synthetic */ void mo5960ao(Object obj) {
            AppMethodBeat.m2504i(129583);
            Parcel parcel = (Parcel) obj;
            C42377o.this.mo15641b(parcel.readString(), parcel.readInt(), parcel.readString());
            AppMethodBeat.m2505o(129583);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.o$a */
    static final class C38131a implements C45413i<IPCInteger, Parcel> {
        private C38131a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(129585);
            Parcel a = C38131a.m64525a((IPCInteger) obj);
            AppMethodBeat.m2505o(129585);
            return a;
        }

        /* renamed from: a */
        private static Parcel m64525a(IPCInteger iPCInteger) {
            AppMethodBeat.m2504i(129584);
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeTypedList(((C26767ag) C1720g.m3528K(C26767ag.class)).mo44540nA(iPCInteger.value));
                AppMethodBeat.m2505o(129584);
                return obtain;
            } catch (Exception e) {
                obtain.setDataPosition(0);
                obtain.writeTypedList(null);
                AppMethodBeat.m2505o(129584);
                return obtain;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.o$c */
    static final class C38133c implements C45413i<AppIdentity, IPCBoolean> {
        private C38133c() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(129591);
            IPCBoolean c = C38133c.m64527c((AppIdentity) obj);
            AppMethodBeat.m2505o(129591);
            return c;
        }

        /* renamed from: c */
        private static IPCBoolean m64527c(AppIdentity appIdentity) {
            AppMethodBeat.m2504i(129590);
            IPCBoolean iPCBoolean;
            try {
                iPCBoolean = new IPCBoolean(((C26767ag) C1720g.m3528K(C26767ag.class)).mo44539aE(appIdentity.username, appIdentity.har));
                AppMethodBeat.m2505o(129590);
                return iPCBoolean;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandLocalUsageStorageIPCImpl", e, "ipc removeUsage", new Object[0]);
                iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.m2505o(129590);
                return iPCBoolean;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.o$b */
    static final class C42378b implements C37866a<IPCVoid, Parcel> {
        private C42378b() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, final C18507c c18507c) {
            AppMethodBeat.m2504i(129589);
            final C423801 c423801 = new C4931a() {
                /* renamed from: a */
                public final void mo5248a(String str, C4935m c4935m) {
                    AppMethodBeat.m2504i(129586);
                    if (c18507c != null) {
                        Parcel obtain = Parcel.obtain();
                        obtain.writeString(str);
                        obtain.writeInt(c4935m.hsh);
                        obtain.writeString(c4935m.obj == null ? null : c4935m.obj.toString());
                        c18507c.mo5960ao(obtain);
                    }
                    AppMethodBeat.m2505o(129586);
                }
            };
            ((C26767ag) C1720g.m3528K(C26767ag.class)).mo10114a(c423801, C42677e.aNS().oAl.getLooper());
            ((C37868a) c18507c).mo33744a(new C42131b() {

                /* renamed from: com.tencent.mm.plugin.appbrand.appusage.o$b$2$1 */
                class C381321 implements Runnable {
                    C381321() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(129587);
                        ((C26767ag) C1720g.m3528K(C26767ag.class)).mo10117d(c423801);
                        AppMethodBeat.m2505o(129587);
                    }
                }

                /* renamed from: d */
                public final void mo67680d(Exception exception) {
                    AppMethodBeat.m2504i(129588);
                    if (exception instanceof DeadObjectException) {
                        new C7306ak(Looper.myLooper()).post(new C381321());
                        AppMethodBeat.m2505o(129588);
                        return;
                    }
                    C4990ab.m7413e("MicroMsg.AppBrandLocalUsageStorageIPCImpl", "onExceptionOccur(%s)", Log.getStackTraceString(exception));
                    AppMethodBeat.m2505o(129588);
                }
            });
            AppMethodBeat.m2505o(129589);
        }
    }

    public C42377o() {
        AppMethodBeat.m2504i(129592);
        AppMethodBeat.m2505o(129592);
    }

    /* renamed from: aE */
    public final boolean mo44539aE(String str, int i) {
        AppMethodBeat.m2504i(129593);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.m83628a("com.tencent.mm", new AppIdentity(str, i), C38133c.class);
        if (iPCBoolean == null) {
            AppMethodBeat.m2505o(129593);
            return false;
        }
        boolean z = iPCBoolean.value;
        AppMethodBeat.m2505o(129593);
        return z;
    }

    /* renamed from: nA */
    public final List<LocalUsageInfo> mo44540nA(int i) {
        AppMethodBeat.m2504i(129594);
        Parcel parcel = (Parcel) XIPCInvoker.m83628a("com.tencent.mm", new IPCInteger(i), C38131a.class);
        if (parcel == null) {
            AppMethodBeat.m2505o(129594);
            return null;
        }
        ArrayList arrayList = new ArrayList(i);
        parcel.readTypedList(arrayList, LocalUsageInfo.CREATOR);
        AppMethodBeat.m2505o(129594);
        return arrayList;
    }

    /* renamed from: c */
    public final void mo10116c(C4931a c4931a) {
        AppMethodBeat.m2504i(129595);
        mo10114a(c4931a, Looper.getMainLooper());
        AppMethodBeat.m2505o(129595);
    }

    /* renamed from: a */
    public final void mo10114a(C4931a c4931a, Looper looper) {
        Object obj = 1;
        AppMethodBeat.m2504i(129596);
        if (c4931a == null || looper == null) {
            AppMethodBeat.m2505o(129596);
            return;
        }
        super.mo10114a(c4931a, looper);
        synchronized (this.gZx) {
            try {
                this.gZx.add(c4931a);
                if (this.gZx.size() != 1) {
                    obj = null;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(129596);
                }
            }
        }
        if (obj != null) {
            XIPCInvoker.m83629a("com.tencent.mm", IPCVoid.eGH, C42378b.class, new C246891());
        }
        AppMethodBeat.m2505o(129596);
    }

    /* renamed from: d */
    public final void mo10117d(C4931a c4931a) {
        AppMethodBeat.m2504i(129597);
        if (c4931a == null) {
            AppMethodBeat.m2505o(129597);
            return;
        }
        super.mo10117d(c4931a);
        synchronized (this.gZx) {
            try {
                this.gZx.remove(c4931a);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(129597);
            }
        }
    }
}
