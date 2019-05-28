package com.tencent.p177mm.plugin.appbrand.menu;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.menu.p909a.C10642a;
import com.tencent.p177mm.plugin.appbrand.p896i.C45567f;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper */
public final class WxaMenuHelper {
    private final SparseArray<C10642a> ing;

    /* renamed from: com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper$GetCopyPathMenuExpireTimeTask */
    public static class GetCopyPathMenuExpireTimeTask extends MainProcessTask {
        public static final Creator<GetCopyPathMenuExpireTimeTask> CREATOR = new C334521();
        private long inh = 0;
        private String mAppId;

        /* renamed from: com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper$GetCopyPathMenuExpireTimeTask$1 */
        static class C334521 implements Creator<GetCopyPathMenuExpireTimeTask> {
            C334521() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetCopyPathMenuExpireTimeTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(132254);
                GetCopyPathMenuExpireTimeTask getCopyPathMenuExpireTimeTask = new GetCopyPathMenuExpireTimeTask(parcel);
                AppMethodBeat.m2505o(132254);
                return getCopyPathMenuExpireTimeTask;
            }
        }

        public GetCopyPathMenuExpireTimeTask(String str) {
            this.mAppId = str;
        }

        public GetCopyPathMenuExpireTimeTask(Parcel parcel) {
            AppMethodBeat.m2504i(132255);
            mo6032g(parcel);
            AppMethodBeat.m2505o(132255);
        }

        public final void asP() {
            AppMethodBeat.m2504i(132256);
            C45567f c45567f = C45567f.inF;
            Long cF = C45567f.m84062cF(this.mAppId, "copypath");
            if (cF == null) {
                this.inh = 0;
                AppMethodBeat.m2505o(132256);
                return;
            }
            this.inh = cF.longValue();
            AppMethodBeat.m2505o(132256);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(132257);
            this.inh = parcel.readLong();
            this.mAppId = parcel.readString();
            AppMethodBeat.m2505o(132257);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(132258);
            parcel.writeLong(this.inh);
            parcel.writeString(this.mAppId);
            AppMethodBeat.m2505o(132258);
        }

        static {
            AppMethodBeat.m2504i(132259);
            AppMethodBeat.m2505o(132259);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper$a */
    static class C33453a {
        static WxaMenuHelper ini = new WxaMenuHelper();

        static {
            AppMethodBeat.m2504i(132260);
            AppMethodBeat.m2505o(132260);
        }
    }

    /* synthetic */ WxaMenuHelper(byte b) {
        this();
    }

    private WxaMenuHelper() {
        AppMethodBeat.m2504i(132261);
        this.ing = new SparseArray();
        m54661a(new C2394c());
        m54661a(new C33454b());
        m54661a(new C27206i());
        m54661a(new C19609a());
        m54661a(new C33457h());
        m54661a(new C2399d());
        m54661a(new C33456g());
        m54661a(new MenuDelegate_SendToDesktop());
        m54661a(new C19610j());
        m54661a(new C16692l());
        m54661a(new C45658m());
        m54661a(new MenuDelegate_EnableDebug());
        m54661a(new C27208k());
        m54661a(new C38448f());
        m54661a(new C33455e());
        AppMethodBeat.m2505o(132261);
    }

    /* renamed from: c */
    public static void m54662c(List<C42636n> list, int i, boolean z) {
        AppMethodBeat.m2504i(132262);
        C42636n c42636n = new C42636n(i, (C10642a) C33453a.ini.ing.get(i));
        c42636n.imK = z;
        list.add(c42636n);
        AppMethodBeat.m2505o(132262);
    }

    /* renamed from: a */
    private void m54661a(C10642a c10642a) {
        AppMethodBeat.m2504i(132263);
        this.ing.put(c10642a.inj, c10642a);
        AppMethodBeat.m2505o(132263);
    }
}
