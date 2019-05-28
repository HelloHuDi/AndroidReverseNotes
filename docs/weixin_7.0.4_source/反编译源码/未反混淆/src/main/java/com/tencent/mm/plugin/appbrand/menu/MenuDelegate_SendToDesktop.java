package com.tencent.mm.plugin.appbrand.menu;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.widget.a.e;

public final class MenuDelegate_SendToDesktop extends a<w> {

    static final class SaveNoMoreShowPermissionNotifyStatusTask extends MainProcessTask {
        public static final Creator<SaveNoMoreShowPermissionNotifyStatusTask> CREATOR = new Creator<SaveNoMoreShowPermissionNotifyStatusTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SaveNoMoreShowPermissionNotifyStatusTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(132230);
                SaveNoMoreShowPermissionNotifyStatusTask saveNoMoreShowPermissionNotifyStatusTask = new SaveNoMoreShowPermissionNotifyStatusTask((byte) 0);
                AppMethodBeat.o(132230);
                return saveNoMoreShowPermissionNotifyStatusTask;
            }
        };

        public SaveNoMoreShowPermissionNotifyStatusTask(byte b) {
        }

        public final void asP() {
            AppMethodBeat.i(132231);
            f.xH().bG("key_sendtodesktop_no_more_show_permission_notify_dialog", "1");
            AppMethodBeat.o(132231);
        }

        static {
            AppMethodBeat.i(132232);
            AppMethodBeat.o(132232);
        }
    }

    MenuDelegate_SendToDesktop() {
        super(o.SendToDesktop.ordinal());
        AppMethodBeat.i(132233);
        AppMethodBeat.o(132233);
    }

    static /* synthetic */ void a(e.a aVar, int i, String str) {
        AppMethodBeat.i(132237);
        aVar.gud.dismiss();
        h.pYm.e(15790, Integer.valueOf(i), Integer.valueOf(0), str);
        AppMethodBeat.o(132237);
    }

    static /* synthetic */ void d(boolean z, String str, int i) {
        AppMethodBeat.i(132238);
        if (z) {
            h.pYm.e(15789, Integer.valueOf(i), Integer.valueOf(0), str);
            AppBrandMainProcessService.a(new SaveNoMoreShowPermissionNotifyStatusTask());
            AppBrandSysConfigWC wJ = com.tencent.mm.plugin.appbrand.a.wJ(str);
            if (wJ != null) {
                wJ.bQP = true;
            }
        }
        AppMethodBeat.o(132238);
    }
}
