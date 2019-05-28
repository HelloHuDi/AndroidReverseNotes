package com.tencent.p177mm.plugin.appbrand.task;

import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.C45445b;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.report.model.C33517f;
import com.tencent.p177mm.plugin.appbrand.report.model.C33517f.C33518a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C27285a;
import com.tencent.p177mm.plugin.appbrand.task.C38520i.C38521a;
import com.tencent.p177mm.plugin.appbrand.task.C45694h.C10744a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.MultiProcessSharedPreferences;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController */
public class AppBrandRemoteTaskController extends MainProcessTask {
    public static final Creator<AppBrandRemoteTaskController> CREATOR = new C426913();
    private static long iEM;
    public static boolean iEP = false;
    public C38520i gOD = null;
    public C27318f gPx = null;
    public String gQX;
    public long iEJ;
    public C27306a iEK = C27306a.NONE;
    int iEL;
    private C38519g iEN = C38519g.NIL;
    String iEO;
    public int igj;
    public String mAppId;
    private long mTimestamp;

    /* renamed from: com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController$a */
    public enum C27306a {
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
            AppMethodBeat.m2505o(132829);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController$2 */
    class C385182 implements C38521a {
        C385182() {
        }

        public final void proceed() {
            AppMethodBeat.m2504i(132824);
            AppBrandRemoteTaskController.m84405b(AppBrandRemoteTaskController.this);
            AppMethodBeat.m2505o(132824);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController$3 */
    static class C426913 implements Creator<AppBrandRemoteTaskController> {
        C426913() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandRemoteTaskController[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(132825);
            AppBrandRemoteTaskController appBrandRemoteTaskController = new AppBrandRemoteTaskController();
            appBrandRemoteTaskController.mo6032g(parcel);
            AppMethodBeat.m2505o(132825);
            return appBrandRemoteTaskController;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController$1 */
    class C456931 implements C10744a {
        C456931() {
        }

        /* renamed from: a */
        public final boolean mo22300a(C45695j c45695j) {
            AppMethodBeat.m2504i(132823);
            if ((c45695j instanceof C46897a) && ((C46897a) c45695j).iEd == AppBrandRemoteTaskController.this.iEJ) {
                AppMethodBeat.m2505o(132823);
                return true;
            }
            AppMethodBeat.m2505o(132823);
            return false;
        }
    }

    /* renamed from: a */
    public final void mo73483a(String str, int i, C38519g c38519g) {
        AppMethodBeat.m2504i(132830);
        this.iEK = C27306a.REGISTER;
        this.mAppId = str;
        this.igj = i;
        this.iEN = c38519g;
        this.iEO = C27285a.m43319DG(str).igT;
        AppBrandMainProcessService.m54349a((MainProcessTask) this);
        AppMethodBeat.m2505o(132830);
    }

    /* renamed from: DL */
    public final void mo73481DL(String str) {
        AppMethodBeat.m2504i(132831);
        this.iEK = C27306a.CLEAR_DUPLICATED;
        this.mAppId = str;
        AppBrandMainProcessService.m54349a((MainProcessTask) this);
        AppMethodBeat.m2505o(132831);
    }

    static {
        AppMethodBeat.m2504i(132841);
        AppMethodBeat.m2505o(132841);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: DM */
    public final void mo73482DM(String str) {
        AppMethodBeat.m2504i(132832);
        this.iEK = C27306a.REMOVE;
        this.mAppId = str;
        aLW();
        aCb();
        AppMethodBeat.m2505o(132832);
    }

    /* Access modifiers changed, original: final */
    public final boolean aLU() {
        AppMethodBeat.m2504i(132833);
        this.iEK = C27306a.CHECK_ALIVE;
        boolean aCb = aCb();
        AppMethodBeat.m2505o(132833);
        return aCb;
    }

    public final void asP() {
        AppMethodBeat.m2504i(132834);
        switch (this.iEK) {
            case REGISTER:
                aLV();
                synchronized (AppBrandRemoteTaskController.class) {
                    long currentTimeMillis;
                    try {
                        if (iEM == 0) {
                            currentTimeMillis = System.currentTimeMillis();
                            iEM = currentTimeMillis;
                            Editor edit = MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "pref_appbrand_process", 4).edit();
                            edit.putLong("on_wxa_process_connected_time", currentTimeMillis);
                            edit.commit();
                            C4990ab.m7419v("MicroMsg.AppBrandReporter", "update timestamp(%s)", Long.valueOf(currentTimeMillis));
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(132834);
                    }
                    this.mTimestamp = iEM;
                }
                aCb();
                AppMethodBeat.m2505o(132834);
                return;
            case UPDATE:
                aLV();
                AppMethodBeat.m2505o(132834);
                return;
            case REMOVE:
                aLW();
                AppMethodBeat.m2505o(132834);
                return;
            case KILL_ALL:
                C45694h.m84430pN(this.iEL);
                AppMethodBeat.m2505o(132834);
                return;
            case CLEAR_DUPLICATED:
                C45694h.m84411DN(this.mAppId);
                AppMethodBeat.m2505o(132834);
                return;
            case PRELOAD:
                C45694h.m84419a(this.iEN, true);
                AppMethodBeat.m2505o(132834);
                return;
            case NOTIFY_PAUSE:
                C33517f c33517f = C33517f.iBe;
                C33518a c33518a = (C33518a) c33517f.iBf.get(this.mAppId);
                if (c33518a != null) {
                    c33518a.iBh = C5046bo.anU();
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(132834);
    }

    private void aLV() {
        C45695j a;
        AppMethodBeat.m2504i(132835);
        if (this.gQX.endsWith(".AppBrandEmbedUI")) {
            a = C45694h.m84417a(new C456931());
            if (a == null) {
                a = new C46897a(this.iEJ);
            }
        } else {
            a = C45694h.m84415DR(this.gQX);
            if (a == null) {
                AppMethodBeat.m2505o(132835);
                return;
            }
        }
        a.mo73490a(this.mAppId, this.igj, this);
        C45694h.m84421b(a);
        AppMethodBeat.m2505o(132835);
    }

    private void aLW() {
        AppMethodBeat.m2504i(132836);
        if (C45694h.m84426cN(this.mAppId, this.gQX) == null) {
            AppMethodBeat.m2505o(132836);
            return;
        }
        C45694h.m84410DI(this.mAppId);
        AppMethodBeat.m2505o(132836);
    }

    public final void asQ() {
        AppMethodBeat.m2504i(132837);
        switch (this.iEK) {
            case REMOVE:
                this.gPx.finish();
                AppMethodBeat.m2505o(132837);
                return;
            case KILL:
                switch (this.iEL) {
                    case 0:
                        C45445b.m83711pj(C4996ah.getProcessName());
                        this.gOD.finish();
                        Process.killProcess(Process.myPid());
                        AppMethodBeat.m2505o(132837);
                        return;
                    case 1:
                        this.gOD.mo54022a(new C385182());
                        break;
                }
                AppMethodBeat.m2505o(132837);
                return;
            case ASSERT:
                Assert.assertTrue("AppBrand Test Assert", false);
                AppMethodBeat.m2505o(132837);
                return;
            case NETWORK_CHANGE:
                this.gPx.onNetworkChange();
                break;
        }
        AppMethodBeat.m2505o(132837);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = -1;
        AppMethodBeat.m2504i(132838);
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
        AppMethodBeat.m2505o(132838);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        C38519g c38519g = null;
        AppMethodBeat.m2504i(132839);
        this.mAppId = parcel.readString();
        this.igj = parcel.readInt();
        this.gQX = parcel.readString();
        this.iEJ = parcel.readLong();
        int readInt = parcel.readInt();
        this.iEK = readInt == -1 ? null : C27306a.values()[readInt];
        this.iEL = parcel.readInt();
        this.mTimestamp = parcel.readLong();
        readInt = parcel.readInt();
        if (readInt != -1) {
            c38519g = C38519g.values()[readInt];
        }
        this.iEN = c38519g;
        this.iEO = parcel.readString();
        AppMethodBeat.m2505o(132839);
    }

    /* renamed from: b */
    static /* synthetic */ void m84405b(AppBrandRemoteTaskController appBrandRemoteTaskController) {
        AppMethodBeat.m2504i(132840);
        appBrandRemoteTaskController.iEK = C27306a.KILL_ALL;
        appBrandRemoteTaskController.iEL = 0;
        AppBrandMainProcessService.m54349a((MainProcessTask) appBrandRemoteTaskController);
        AppMethodBeat.m2505o(132840);
    }
}
