package com.tencent.mm.plugin.appbrand.task;

import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.model.f;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public class AppBrandRemoteTaskController extends MainProcessTask {
    public static final Creator<AppBrandRemoteTaskController> CREATOR = new Creator<AppBrandRemoteTaskController>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandRemoteTaskController[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(132825);
            AppBrandRemoteTaskController appBrandRemoteTaskController = new AppBrandRemoteTaskController();
            appBrandRemoteTaskController.g(parcel);
            AppMethodBeat.o(132825);
            return appBrandRemoteTaskController;
        }
    };
    private static long iEM;
    public static boolean iEP = false;
    public i gOD = null;
    public f gPx = null;
    public String gQX;
    public long iEJ;
    public a iEK = a.NONE;
    int iEL;
    private g iEN = g.NIL;
    String iEO;
    public int igj;
    public String mAppId;
    private long mTimestamp;

    public enum a {
        NONE,
        REGISTER,
        UPDATE,
        REMOVE,
        KILL,
        KILL_ALL,
        ASSERT,
        CHECK_ALIVE,
        NETWORK_CHANGE,
        CLEAR_DUPLICATED,
        PRELOAD,
        NOTIFY_PAUSE;

        static {
            AppMethodBeat.o(132829);
        }
    }

    public final void a(String str, int i, g gVar) {
        AppMethodBeat.i(132830);
        this.iEK = a.REGISTER;
        this.mAppId = str;
        this.igj = i;
        this.iEN = gVar;
        this.iEO = com.tencent.mm.plugin.appbrand.report.quality.a.DG(str).igT;
        AppBrandMainProcessService.a((MainProcessTask) this);
        AppMethodBeat.o(132830);
    }

    public final void DL(String str) {
        AppMethodBeat.i(132831);
        this.iEK = a.CLEAR_DUPLICATED;
        this.mAppId = str;
        AppBrandMainProcessService.a((MainProcessTask) this);
        AppMethodBeat.o(132831);
    }

    static {
        AppMethodBeat.i(132841);
        AppMethodBeat.o(132841);
    }

    /* Access modifiers changed, original: final */
    public final void DM(String str) {
        AppMethodBeat.i(132832);
        this.iEK = a.REMOVE;
        this.mAppId = str;
        aLW();
        aCb();
        AppMethodBeat.o(132832);
    }

    /* Access modifiers changed, original: final */
    public final boolean aLU() {
        AppMethodBeat.i(132833);
        this.iEK = a.CHECK_ALIVE;
        boolean aCb = aCb();
        AppMethodBeat.o(132833);
        return aCb;
    }

    public final void asP() {
        AppMethodBeat.i(132834);
        switch (this.iEK) {
            case REGISTER:
                aLV();
                synchronized (AppBrandRemoteTaskController.class) {
                    long currentTimeMillis;
                    try {
                        if (iEM == 0) {
                            currentTimeMillis = System.currentTimeMillis();
                            iEM = currentTimeMillis;
                            Editor edit = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "pref_appbrand_process", 4).edit();
                            edit.putLong("on_wxa_process_connected_time", currentTimeMillis);
                            edit.commit();
                            ab.v("MicroMsg.AppBrandReporter", "update timestamp(%s)", Long.valueOf(currentTimeMillis));
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(132834);
                    }
                    this.mTimestamp = iEM;
                }
                aCb();
                AppMethodBeat.o(132834);
                return;
            case UPDATE:
                aLV();
                AppMethodBeat.o(132834);
                return;
            case REMOVE:
                aLW();
                AppMethodBeat.o(132834);
                return;
            case KILL_ALL:
                h.pN(this.iEL);
                AppMethodBeat.o(132834);
                return;
            case CLEAR_DUPLICATED:
                h.DN(this.mAppId);
                AppMethodBeat.o(132834);
                return;
            case PRELOAD:
                h.a(this.iEN, true);
                AppMethodBeat.o(132834);
                return;
            case NOTIFY_PAUSE:
                f fVar = f.iBe;
                com.tencent.mm.plugin.appbrand.report.model.f.a aVar = (com.tencent.mm.plugin.appbrand.report.model.f.a) fVar.iBf.get(this.mAppId);
                if (aVar != null) {
                    aVar.iBh = bo.anU();
                    break;
                }
                break;
        }
        AppMethodBeat.o(132834);
    }

    private void aLV() {
        j a;
        AppMethodBeat.i(132835);
        if (this.gQX.endsWith(".AppBrandEmbedUI")) {
            a = h.a(new a() {
                public final boolean a(j jVar) {
                    AppMethodBeat.i(132823);
                    if ((jVar instanceof a) && ((a) jVar).iEd == AppBrandRemoteTaskController.this.iEJ) {
                        AppMethodBeat.o(132823);
                        return true;
                    }
                    AppMethodBeat.o(132823);
                    return false;
                }
            });
            if (a == null) {
                a = new a(this.iEJ);
            }
        } else {
            a = h.DR(this.gQX);
            if (a == null) {
                AppMethodBeat.o(132835);
                return;
            }
        }
        a.a(this.mAppId, this.igj, this);
        h.b(a);
        AppMethodBeat.o(132835);
    }

    private void aLW() {
        AppMethodBeat.i(132836);
        if (h.cN(this.mAppId, this.gQX) == null) {
            AppMethodBeat.o(132836);
            return;
        }
        h.DI(this.mAppId);
        AppMethodBeat.o(132836);
    }

    public final void asQ() {
        AppMethodBeat.i(132837);
        switch (this.iEK) {
            case REMOVE:
                this.gPx.finish();
                AppMethodBeat.o(132837);
                return;
            case KILL:
                switch (this.iEL) {
                    case 0:
                        b.pj(ah.getProcessName());
                        this.gOD.finish();
                        Process.killProcess(Process.myPid());
                        AppMethodBeat.o(132837);
                        return;
                    case 1:
                        this.gOD.a(new com.tencent.mm.plugin.appbrand.task.i.a() {
                            public final void proceed() {
                                AppMethodBeat.i(132824);
                                AppBrandRemoteTaskController.b(AppBrandRemoteTaskController.this);
                                AppMethodBeat.o(132824);
                            }
                        });
                        break;
                }
                AppMethodBeat.o(132837);
                return;
            case ASSERT:
                Assert.assertTrue("AppBrand Test Assert", false);
                AppMethodBeat.o(132837);
                return;
            case NETWORK_CHANGE:
                this.gPx.onNetworkChange();
                break;
        }
        AppMethodBeat.o(132837);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = -1;
        AppMethodBeat.i(132838);
        parcel.writeString(this.mAppId);
        parcel.writeInt(this.igj);
        parcel.writeString(this.gQX);
        parcel.writeLong(this.iEJ);
        parcel.writeInt(this.iEK == null ? -1 : this.iEK.ordinal());
        parcel.writeInt(this.iEL);
        parcel.writeLong(this.mTimestamp);
        if (this.iEN != null) {
            i2 = this.iEN.ordinal();
        }
        parcel.writeInt(i2);
        parcel.writeString(this.iEO);
        AppMethodBeat.o(132838);
    }

    public final void g(Parcel parcel) {
        g gVar = null;
        AppMethodBeat.i(132839);
        this.mAppId = parcel.readString();
        this.igj = parcel.readInt();
        this.gQX = parcel.readString();
        this.iEJ = parcel.readLong();
        int readInt = parcel.readInt();
        this.iEK = readInt == -1 ? null : a.values()[readInt];
        this.iEL = parcel.readInt();
        this.mTimestamp = parcel.readLong();
        readInt = parcel.readInt();
        if (readInt != -1) {
            gVar = g.values()[readInt];
        }
        this.iEN = gVar;
        this.iEO = parcel.readString();
        AppMethodBeat.o(132839);
    }

    static /* synthetic */ void b(AppBrandRemoteTaskController appBrandRemoteTaskController) {
        AppMethodBeat.i(132840);
        appBrandRemoteTaskController.iEK = a.KILL_ALL;
        appBrandRemoteTaskController.iEL = 0;
        AppBrandMainProcessService.a((MainProcessTask) appBrandRemoteTaskController);
        AppMethodBeat.o(132840);
    }
}
