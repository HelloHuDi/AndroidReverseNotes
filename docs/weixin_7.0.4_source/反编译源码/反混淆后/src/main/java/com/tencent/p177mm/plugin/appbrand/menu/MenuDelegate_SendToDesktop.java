package com.tencent.p177mm.plugin.appbrand.menu;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.menu.p909a.C10642a;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.report.service.C7060h;

/* renamed from: com.tencent.mm.plugin.appbrand.menu.MenuDelegate_SendToDesktop */
public final class MenuDelegate_SendToDesktop extends C10642a<C27242w> {

    /* renamed from: com.tencent.mm.plugin.appbrand.menu.MenuDelegate_SendToDesktop$SaveNoMoreShowPermissionNotifyStatusTask */
    static final class SaveNoMoreShowPermissionNotifyStatusTask extends MainProcessTask {
        public static final Creator<SaveNoMoreShowPermissionNotifyStatusTask> CREATOR = new C196081();

        /* renamed from: com.tencent.mm.plugin.appbrand.menu.MenuDelegate_SendToDesktop$SaveNoMoreShowPermissionNotifyStatusTask$1 */
        static class C196081 implements Creator<SaveNoMoreShowPermissionNotifyStatusTask> {
            C196081() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SaveNoMoreShowPermissionNotifyStatusTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(132230);
                SaveNoMoreShowPermissionNotifyStatusTask saveNoMoreShowPermissionNotifyStatusTask = new SaveNoMoreShowPermissionNotifyStatusTask((byte) 0);
                AppMethodBeat.m2505o(132230);
                return saveNoMoreShowPermissionNotifyStatusTask;
            }
        }

        public SaveNoMoreShowPermissionNotifyStatusTask(byte b) {
        }

        public final void asP() {
            AppMethodBeat.m2504i(132231);
            C42340f.m74880xH().mo53682bG("key_sendtodesktop_no_more_show_permission_notify_dialog", "1");
            AppMethodBeat.m2505o(132231);
        }

        static {
            AppMethodBeat.m2504i(132232);
            AppMethodBeat.m2505o(132232);
        }
    }

    MenuDelegate_SendToDesktop() {
        super(C38449o.SendToDesktop.ordinal());
        AppMethodBeat.m2504i(132233);
        AppMethodBeat.m2505o(132233);
    }

    /* renamed from: a */
    static /* synthetic */ void m75498a(C5659a c5659a, int i, String str) {
        AppMethodBeat.m2504i(132237);
        c5659a.gud.dismiss();
        C7060h.pYm.mo8381e(15790, Integer.valueOf(i), Integer.valueOf(0), str);
        AppMethodBeat.m2505o(132237);
    }

    /* renamed from: d */
    static /* synthetic */ void m75499d(boolean z, String str, int i) {
        AppMethodBeat.m2504i(132238);
        if (z) {
            C7060h.pYm.mo8381e(15789, Integer.valueOf(i), Integer.valueOf(0), str);
            AppBrandMainProcessService.m54349a(new SaveNoMoreShowPermissionNotifyStatusTask());
            AppBrandSysConfigWC wJ = C10048a.m17636wJ(str);
            if (wJ != null) {
                wJ.bQP = true;
            }
        }
        AppMethodBeat.m2505o(132238);
    }
}
