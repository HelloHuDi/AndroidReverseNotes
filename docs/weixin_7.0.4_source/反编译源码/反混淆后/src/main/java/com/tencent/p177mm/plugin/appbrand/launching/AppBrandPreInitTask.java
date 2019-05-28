package com.tencent.p177mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.launching.C27164d.C27163a;
import com.tencent.p177mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask */
public final class AppBrandPreInitTask extends MainProcessTask {
    public static final Creator<AppBrandPreInitTask> CREATOR = new C195553();
    private transient C10574a ifG;
    private ActivityStarterIpcDelegate ifH;
    private LaunchParcel ifI;
    private AppBrandInitConfigWC ifJ;
    private String ifK;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask$a */
    public interface C10574a {
        /* renamed from: b */
        void mo15056b(AppBrandInitConfigWC appBrandInitConfigWC);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask$3 */
    static class C195553 implements Creator<AppBrandPreInitTask> {
        C195553() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandPreInitTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(131720);
            AppBrandPreInitTask appBrandPreInitTask = new AppBrandPreInitTask(parcel, (byte) 0);
            AppMethodBeat.m2505o(131720);
            return appBrandPreInitTask;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask$1 */
    class C334261 implements C27163a<AppBrandInitConfigWC> {
        C334261() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo44834a(AppBrandInitConfigLU appBrandInitConfigLU, AppBrandStatObject appBrandStatObject, int i) {
            AppMethodBeat.m2504i(138135);
            AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) appBrandInitConfigLU;
            AppBrandPreInitTask.this.ifJ = appBrandInitConfigWC;
            AppBrandPreInitTask.this.ifI.ijy = appBrandStatObject;
            if (appBrandInitConfigWC != null) {
                C38421c.m65007a(appBrandInitConfigWC, appBrandStatObject);
            }
            AppBrandPreInitTask.m54636b(AppBrandPreInitTask.this);
            AppMethodBeat.m2505o(138135);
        }
    }

    /* synthetic */ AppBrandPreInitTask(Parcel parcel, byte b) {
        this(parcel);
    }

    /* renamed from: b */
    static /* synthetic */ boolean m54636b(AppBrandPreInitTask appBrandPreInitTask) {
        AppMethodBeat.m2504i(131727);
        boolean aCb = appBrandPreInitTask.aCb();
        AppMethodBeat.m2505o(131727);
        return aCb;
    }

    public AppBrandPreInitTask(Context context, LaunchParcel launchParcel, String str, C10574a c10574a) {
        AppMethodBeat.m2504i(131721);
        this.ifI = launchParcel;
        this.ifK = str;
        this.ifG = c10574a;
        if (context instanceof Activity) {
            this.ifH = new ActivityStarterIpcDelegate((Activity) context);
        } else {
            this.ifH = null;
        }
        this.ifI.ifP = this.ifH;
        AppMethodBeat.m2505o(131721);
    }

    public final void asQ() {
        AppMethodBeat.m2504i(131722);
        if (this.ifG != null) {
            this.ifG.mo15056b(this.ifJ);
        }
        aBW();
        AppMethodBeat.m2505o(131722);
    }

    public final void asP() {
        AppMethodBeat.m2504i(131723);
        final C31317e c31317e = new C31317e(this.ifI, this.ifK, new C334261());
        String str = this.ifI.appId;
        int i = this.ifI.har;
        new C5004al(String.format(Locale.US, "AppBrandPreInitTask-%s|%d", new Object[]{str, Integer.valueOf(i)})).mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(131719);
                c31317e.run();
                Looper.myLooper().quit();
                AppMethodBeat.m2505o(131719);
            }
        });
        AppMethodBeat.m2505o(131723);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(131724);
        parcel.writeParcelable(this.ifI, i);
        parcel.writeString(this.ifK);
        parcel.writeParcelable(this.ifJ, i);
        parcel.writeParcelable(this.ifH, i);
        AppMethodBeat.m2505o(131724);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        AppMethodBeat.m2504i(131725);
        this.ifI = (LaunchParcel) parcel.readParcelable(LaunchParcel.class.getClassLoader());
        this.ifK = parcel.readString();
        this.ifJ = (AppBrandInitConfigWC) parcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader());
        this.ifH = (ActivityStarterIpcDelegate) parcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader());
        AppMethodBeat.m2505o(131725);
    }

    private AppBrandPreInitTask(Parcel parcel) {
        AppMethodBeat.m2504i(131726);
        mo6032g(parcel);
        AppMethodBeat.m2505o(131726);
    }

    static {
        AppMethodBeat.m2504i(131728);
        AppMethodBeat.m2505o(131728);
    }
}
