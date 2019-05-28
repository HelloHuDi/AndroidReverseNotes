package com.tencent.p177mm.plugin.appbrand.menu;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.sdk.customize.C0997b;
import com.tencent.luggage.sdk.p819a.p820a.C37402a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.config.C33134c;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.menu.p909a.C10642a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.menu.MenuDelegate_EnableDebug */
public final class MenuDelegate_EnableDebug extends C10642a<C37402a> {

    /* renamed from: com.tencent.mm.plugin.appbrand.menu.MenuDelegate_EnableDebug$SetAppDebugModeTask */
    static class SetAppDebugModeTask extends MainProcessTask {
        public static final Creator<SetAppDebugModeTask> CREATOR = new C106391();
        public String appId;
        public boolean enable;

        /* renamed from: com.tencent.mm.plugin.appbrand.menu.MenuDelegate_EnableDebug$SetAppDebugModeTask$1 */
        static class C106391 implements Creator<SetAppDebugModeTask> {
            C106391() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SetAppDebugModeTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(102131);
                SetAppDebugModeTask setAppDebugModeTask = new SetAppDebugModeTask();
                setAppDebugModeTask.mo6032g(parcel);
                AppMethodBeat.m2505o(102131);
                return setAppDebugModeTask;
            }
        }

        private SetAppDebugModeTask() {
        }

        /* synthetic */ SetAppDebugModeTask(byte b) {
            this();
        }

        public final void asP() {
            AppMethodBeat.m2504i(102132);
            String str = this.appId;
            boolean z = this.enable;
            C33134c xH = ((C0997b) C37384e.m62985B(C0997b.class)).mo3976xH();
            if (C5046bo.isNullOrNil(str) || xH == null) {
                AppMethodBeat.m2505o(102132);
                return;
            }
            xH.mo53682bG(str + "_AppDebugEnabled", String.valueOf(z));
            AppMethodBeat.m2505o(102132);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(102133);
            this.appId = parcel.readString();
            this.enable = parcel.readByte() != (byte) 0;
            AppMethodBeat.m2505o(102133);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(102134);
            parcel.writeString(this.appId);
            parcel.writeByte(this.enable ? (byte) 1 : (byte) 0);
            AppMethodBeat.m2505o(102134);
        }

        static {
            AppMethodBeat.m2504i(102135);
            AppMethodBeat.m2505o(102135);
        }
    }

    public MenuDelegate_EnableDebug() {
        super(C38449o.EnableDebug.ordinal());
        AppMethodBeat.m2504i(102136);
        AppMethodBeat.m2505o(102136);
    }

    /* renamed from: f */
    public static void m84308f(final Context context, String str, boolean z) {
        String string;
        AppMethodBeat.m2504i(102137);
        MainProcessTask setAppDebugModeTask = new SetAppDebugModeTask();
        setAppDebugModeTask.appId = str;
        setAppDebugModeTask.enable = z;
        AppBrandMainProcessService.m54349a(setAppDebugModeTask);
        if (setAppDebugModeTask.enable) {
            string = context.getString(C25738R.string.f8869hn);
        } else {
            string = context.getString(C25738R.string.f8868hm);
        }
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(102130);
                    Toast.makeText(context, string, 0).show();
                    ((Activity) context).finish();
                    AppMethodBeat.m2505o(102130);
                }
            });
        }
        AppMethodBeat.m2505o(102137);
    }
}
