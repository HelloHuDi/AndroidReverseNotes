package com.tencent.mm.plugin.appbrand.menu;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class MenuDelegate_EnableDebug extends a<com.tencent.luggage.sdk.a.a.a> {

    static class SetAppDebugModeTask extends MainProcessTask {
        public static final Creator<SetAppDebugModeTask> CREATOR = new Creator<SetAppDebugModeTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SetAppDebugModeTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(102131);
                SetAppDebugModeTask setAppDebugModeTask = new SetAppDebugModeTask();
                setAppDebugModeTask.g(parcel);
                AppMethodBeat.o(102131);
                return setAppDebugModeTask;
            }
        };
        public String appId;
        public boolean enable;

        private SetAppDebugModeTask() {
        }

        /* synthetic */ SetAppDebugModeTask(byte b) {
            this();
        }

        public final void asP() {
            AppMethodBeat.i(102132);
            String str = this.appId;
            boolean z = this.enable;
            c xH = ((b) e.B(b.class)).xH();
            if (bo.isNullOrNil(str) || xH == null) {
                AppMethodBeat.o(102132);
                return;
            }
            xH.bG(str + "_AppDebugEnabled", String.valueOf(z));
            AppMethodBeat.o(102132);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(102133);
            this.appId = parcel.readString();
            this.enable = parcel.readByte() != (byte) 0;
            AppMethodBeat.o(102133);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(102134);
            parcel.writeString(this.appId);
            parcel.writeByte(this.enable ? (byte) 1 : (byte) 0);
            AppMethodBeat.o(102134);
        }

        static {
            AppMethodBeat.i(102135);
            AppMethodBeat.o(102135);
        }
    }

    public MenuDelegate_EnableDebug() {
        super(o.EnableDebug.ordinal());
        AppMethodBeat.i(102136);
        AppMethodBeat.o(102136);
    }

    public static void f(final Context context, String str, boolean z) {
        String string;
        AppMethodBeat.i(102137);
        MainProcessTask setAppDebugModeTask = new SetAppDebugModeTask();
        setAppDebugModeTask.appId = str;
        setAppDebugModeTask.enable = z;
        AppBrandMainProcessService.a(setAppDebugModeTask);
        if (setAppDebugModeTask.enable) {
            string = context.getString(R.string.hn);
        } else {
            string = context.getString(R.string.hm);
        }
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(102130);
                    Toast.makeText(context, string, 0).show();
                    ((Activity) context).finish();
                    AppMethodBeat.o(102130);
                }
            });
        }
        AppMethodBeat.o(102137);
    }
}
