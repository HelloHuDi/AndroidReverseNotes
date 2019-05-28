package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Locale;

public final class AppBrandPreInitTask extends MainProcessTask {
    public static final Creator<AppBrandPreInitTask> CREATOR = new Creator<AppBrandPreInitTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandPreInitTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(131720);
            AppBrandPreInitTask appBrandPreInitTask = new AppBrandPreInitTask(parcel, (byte) 0);
            AppMethodBeat.o(131720);
            return appBrandPreInitTask;
        }
    };
    private transient a ifG;
    private ActivityStarterIpcDelegate ifH;
    private LaunchParcel ifI;
    private AppBrandInitConfigWC ifJ;
    private String ifK;

    public interface a {
        void b(AppBrandInitConfigWC appBrandInitConfigWC);
    }

    /* synthetic */ AppBrandPreInitTask(Parcel parcel, byte b) {
        this(parcel);
    }

    static /* synthetic */ boolean b(AppBrandPreInitTask appBrandPreInitTask) {
        AppMethodBeat.i(131727);
        boolean aCb = appBrandPreInitTask.aCb();
        AppMethodBeat.o(131727);
        return aCb;
    }

    public AppBrandPreInitTask(Context context, LaunchParcel launchParcel, String str, a aVar) {
        AppMethodBeat.i(131721);
        this.ifI = launchParcel;
        this.ifK = str;
        this.ifG = aVar;
        if (context instanceof Activity) {
            this.ifH = new ActivityStarterIpcDelegate((Activity) context);
        } else {
            this.ifH = null;
        }
        this.ifI.ifP = this.ifH;
        AppMethodBeat.o(131721);
    }

    public final void asQ() {
        AppMethodBeat.i(131722);
        if (this.ifG != null) {
            this.ifG.b(this.ifJ);
        }
        aBW();
        AppMethodBeat.o(131722);
    }

    public final void asP() {
        AppMethodBeat.i(131723);
        final e eVar = new e(this.ifI, this.ifK, new com.tencent.mm.plugin.appbrand.launching.d.a<AppBrandInitConfigWC>() {
            public final /* synthetic */ void a(AppBrandInitConfigLU appBrandInitConfigLU, AppBrandStatObject appBrandStatObject, int i) {
                AppMethodBeat.i(138135);
                AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) appBrandInitConfigLU;
                AppBrandPreInitTask.this.ifJ = appBrandInitConfigWC;
                AppBrandPreInitTask.this.ifI.ijy = appBrandStatObject;
                if (appBrandInitConfigWC != null) {
                    c.a(appBrandInitConfigWC, appBrandStatObject);
                }
                AppBrandPreInitTask.b(AppBrandPreInitTask.this);
                AppMethodBeat.o(138135);
            }
        });
        String str = this.ifI.appId;
        int i = this.ifI.har;
        new al(String.format(Locale.US, "AppBrandPreInitTask-%s|%d", new Object[]{str, Integer.valueOf(i)})).aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(131719);
                eVar.run();
                Looper.myLooper().quit();
                AppMethodBeat.o(131719);
            }
        });
        AppMethodBeat.o(131723);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(131724);
        parcel.writeParcelable(this.ifI, i);
        parcel.writeString(this.ifK);
        parcel.writeParcelable(this.ifJ, i);
        parcel.writeParcelable(this.ifH, i);
        AppMethodBeat.o(131724);
    }

    public final void g(Parcel parcel) {
        AppMethodBeat.i(131725);
        this.ifI = (LaunchParcel) parcel.readParcelable(LaunchParcel.class.getClassLoader());
        this.ifK = parcel.readString();
        this.ifJ = (AppBrandInitConfigWC) parcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader());
        this.ifH = (ActivityStarterIpcDelegate) parcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader());
        AppMethodBeat.o(131725);
    }

    private AppBrandPreInitTask(Parcel parcel) {
        AppMethodBeat.i(131726);
        g(parcel);
        AppMethodBeat.o(131726);
    }

    static {
        AppMethodBeat.i(131728);
        AppMethodBeat.o(131728);
    }
}
