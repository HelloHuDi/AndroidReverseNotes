package com.tencent.p177mm.plugin.appbrand.jsapi.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9715b;
import com.tencent.p177mm.modelvideo.C9715b.C9714a;
import com.tencent.p177mm.p187al.C45150e;
import com.tencent.p177mm.p235i.C44686h;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.p884c.C19129d.C19131c;
import com.tencent.p177mm.plugin.appbrand.p884c.C26799b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandOnlineVideoProxy */
public final class AppBrandOnlineVideoProxy implements C9715b {
    private OnlineVideoProxy hYl;
    private C9714a hYm;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandOnlineVideoProxy$OnlineVideoProxy */
    static class OnlineVideoProxy extends MainProcessTask {
        public static final Creator<OnlineVideoProxy> CREATOR = new C271252();
        final int START = 1;
        final int STOP = 4;
        String fUL;
        C19131c hYA = new C313091();
        final int hYn = 0;
        final int hYo = 2;
        final int hYp = 3;
        int hYq;
        final int hYr = 10;
        final int hYs = 11;
        final int hYt = 12;
        final int hYu = 13;
        int hYv;
        boolean hYw = false;
        int hYx;
        int hYy;
        C9714a hYz;
        int length;
        int offset;
        String path;
        String url;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandOnlineVideoProxy$OnlineVideoProxy$2 */
        static class C271252 implements Creator<OnlineVideoProxy> {
            C271252() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OnlineVideoProxy[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131505);
                OnlineVideoProxy onlineVideoProxy = new OnlineVideoProxy(parcel);
                AppMethodBeat.m2505o(131505);
                return onlineVideoProxy;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandOnlineVideoProxy$OnlineVideoProxy$1 */
        class C313091 implements C19131c {
            C313091() {
            }

            /* renamed from: cR */
            public final void mo34343cR(int i, int i2) {
                AppMethodBeat.m2504i(131501);
                OnlineVideoProxy.this.hYx = i;
                OnlineVideoProxy.this.hYy = i2;
                OnlineVideoProxy.this.hYv = 10;
                OnlineVideoProxy.m84229a(OnlineVideoProxy.this);
                AppMethodBeat.m2505o(131501);
            }

            /* renamed from: cS */
            public final void mo34344cS(int i, int i2) {
                AppMethodBeat.m2504i(131502);
                OnlineVideoProxy.this.hYx = i;
                OnlineVideoProxy.this.hYy = i2;
                OnlineVideoProxy.this.hYv = 11;
                OnlineVideoProxy.m84230b(OnlineVideoProxy.this);
                AppMethodBeat.m2505o(131502);
            }

            /* renamed from: cT */
            public final void mo34345cT(int i, int i2) {
                AppMethodBeat.m2504i(131503);
                OnlineVideoProxy.this.hYx = i;
                OnlineVideoProxy.this.hYy = i2;
                OnlineVideoProxy.this.hYv = 12;
                OnlineVideoProxy.m84231c(OnlineVideoProxy.this);
                AppMethodBeat.m2505o(131503);
            }

            /* renamed from: ad */
            public final void mo34342ad(String str, int i) {
                AppMethodBeat.m2504i(131504);
                C4990ab.m7417i("MicroMsg.AppBrandOnlineVideoProxy", "on finish [%s %d]", str, Integer.valueOf(i));
                OnlineVideoProxy.this.hYx = i;
                OnlineVideoProxy.this.hYv = 13;
                C42340f.auY().mo44566yD(OnlineVideoProxy.this.fUL);
                OnlineVideoProxy.m84232d(OnlineVideoProxy.this);
                AppMethodBeat.m2505o(131504);
            }
        }

        /* renamed from: a */
        static /* synthetic */ boolean m84229a(OnlineVideoProxy onlineVideoProxy) {
            AppMethodBeat.m2504i(131512);
            boolean aCb = onlineVideoProxy.aCb();
            AppMethodBeat.m2505o(131512);
            return aCb;
        }

        /* renamed from: b */
        static /* synthetic */ boolean m84230b(OnlineVideoProxy onlineVideoProxy) {
            AppMethodBeat.m2504i(131513);
            boolean aCb = onlineVideoProxy.aCb();
            AppMethodBeat.m2505o(131513);
            return aCb;
        }

        /* renamed from: c */
        static /* synthetic */ boolean m84231c(OnlineVideoProxy onlineVideoProxy) {
            AppMethodBeat.m2504i(131514);
            boolean aCb = onlineVideoProxy.aCb();
            AppMethodBeat.m2505o(131514);
            return aCb;
        }

        /* renamed from: d */
        static /* synthetic */ boolean m84232d(OnlineVideoProxy onlineVideoProxy) {
            AppMethodBeat.m2504i(131515);
            boolean aCb = onlineVideoProxy.aCb();
            AppMethodBeat.m2505o(131515);
            return aCb;
        }

        public OnlineVideoProxy() {
            AppMethodBeat.m2504i(131506);
            AppMethodBeat.m2505o(131506);
        }

        public OnlineVideoProxy(Parcel parcel) {
            AppMethodBeat.m2504i(131507);
            mo6032g(parcel);
            AppMethodBeat.m2505o(131507);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(131508);
            C4990ab.m7411d("MicroMsg.AppBrandOnlineVideoProxy", "runInClientProcess cdnMediaId[%s] clientState[%d] [%d %d]", this.fUL, Integer.valueOf(this.hYv), Integer.valueOf(this.hYx), Integer.valueOf(this.hYy));
            if (this.hYz == null) {
                AppMethodBeat.m2505o(131508);
                return;
            }
            switch (this.hYv) {
                case 10:
                    this.hYz.mo21050ml(this.hYx);
                    break;
                case 11:
                    this.hYz.onDataAvailable(this.fUL, this.hYx, this.hYy);
                    break;
                case 12:
                    this.hYz.mo9075h(this.fUL, this.hYx, this.hYy);
                    break;
                case 13:
                    this.hYz.mo9058ad(this.fUL, this.hYx);
                    break;
            }
            this.hYv = 0;
            C4990ab.m7417i("MicroMsg.AppBrandOnlineVideoProxy", "runInClientProcess reset clientState[%d] ", Integer.valueOf(this.hYv));
            AppMethodBeat.m2505o(131508);
        }

        public final void asP() {
            AppMethodBeat.m2504i(131509);
            C4990ab.m7411d("MicroMsg.AppBrandOnlineVideoProxy", "runInMainProcess cdnMediaId[%s] state[%d]", this.fUL, Integer.valueOf(this.hYq));
            String str;
            int i;
            int i2;
            switch (this.hYq) {
                case 1:
                    C26799b auY = C42340f.auY();
                    auY.hew.put(this.fUL, this.hYA);
                    auY = C42340f.auY();
                    C4990ab.m7417i("MicroMsg.AppbrandCdnService", "add online video task [%s] url[%s] path[%s]", this.fUL, this.url, this.path);
                    C44686h c44686h = new C44686h();
                    c44686h.field_mediaId = r1;
                    c44686h.field_fullpath = r3;
                    c44686h.url = r2;
                    c44686h.egK = auY.hex;
                    c44686h.egD = 1;
                    c44686h.egy = 4;
                    C37961o.alm().mo73060a(c44686h, false);
                    break;
                case 2:
                    C42340f.auY();
                    str = this.fUL;
                    i = this.offset;
                    i2 = this.length;
                    C4990ab.m7417i("MicroMsg.AppbrandCdnService", "request online video task [%s]", str);
                    C37961o.alm();
                    C45150e.m83031k(str, i, i2);
                    break;
                case 3:
                    C42340f.auY();
                    str = this.fUL;
                    i = this.offset;
                    i2 = this.length;
                    C4990ab.m7417i("MicroMsg.AppbrandCdnService", "check online video task [%s]", str);
                    this.hYw = C37961o.alm().isVideoDataAvailable(str, i, i2);
                    aCb();
                    AppMethodBeat.m2505o(131509);
                    return;
                case 4:
                    C42340f.auY().mo44566yD(this.fUL);
                    C42340f.auY();
                    C4990ab.m7417i("MicroMsg.AppbrandCdnService", "cancel online video task [%s]", this.fUL);
                    C37961o.alm().mo73064m(str, null);
                    break;
                default:
                    C4990ab.m7420w("MicroMsg.AppBrandOnlineVideoProxy", "unknow state ");
                    break;
            }
            this.hYq = 0;
            C4990ab.m7417i("MicroMsg.AppBrandOnlineVideoProxy", "runInMainProcess reset mainState[%d] ", Integer.valueOf(this.hYq));
            aCb();
            AppMethodBeat.m2505o(131509);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(131510);
            this.fUL = parcel.readString();
            this.hYq = parcel.readInt();
            this.path = parcel.readString();
            this.url = parcel.readString();
            this.offset = parcel.readInt();
            this.length = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.hYw = z;
            this.hYv = parcel.readInt();
            this.hYx = parcel.readInt();
            this.hYy = parcel.readInt();
            AppMethodBeat.m2505o(131510);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131511);
            parcel.writeString(this.fUL);
            parcel.writeInt(this.hYq);
            parcel.writeString(this.path);
            parcel.writeString(this.url);
            parcel.writeInt(this.offset);
            parcel.writeInt(this.length);
            parcel.writeInt(this.hYw ? 1 : 0);
            parcel.writeInt(this.hYv);
            parcel.writeInt(this.hYx);
            parcel.writeInt(this.hYy);
            AppMethodBeat.m2505o(131511);
        }

        static {
            AppMethodBeat.m2504i(131516);
            AppMethodBeat.m2505o(131516);
        }
    }

    /* renamed from: r */
    public final void mo8715r(String str, String str2, String str3) {
        AppMethodBeat.m2504i(131517);
        C4990ab.m7417i("MicroMsg.AppBrandOnlineVideoProxy", "%s start http stream[%s, %s, %s]", Integer.valueOf(hashCode()), str, str2, str3);
        if (this.hYl == null) {
            this.hYl = new OnlineVideoProxy();
            this.hYl.hYz = this.hYm;
            this.hYl.aBV();
        }
        MainProcessTask mainProcessTask = this.hYl;
        C4990ab.m7417i("MicroMsg.AppBrandOnlineVideoProxy", "%s OnlineVideoProxy start http stream[%s %s %s] ", Integer.valueOf(mainProcessTask.hashCode()), str, str2, str3);
        mainProcessTask.fUL = str;
        mainProcessTask.path = str2;
        mainProcessTask.url = str3;
        mainProcessTask.hYq = 1;
        AppBrandMainProcessService.m54349a(mainProcessTask);
        AppMethodBeat.m2505o(131517);
    }

    /* renamed from: dV */
    public final void mo8713dV(String str) {
        AppMethodBeat.m2504i(131518);
        C4990ab.m7417i("MicroMsg.AppBrandOnlineVideoProxy", "%s stop http stream[%s]", Integer.valueOf(hashCode()), str);
        if (this.hYl != null) {
            this.hYl.hYz = null;
            MainProcessTask mainProcessTask = this.hYl;
            mainProcessTask.hYq = 4;
            AppBrandMainProcessService.m54349a(mainProcessTask);
            this.hYl.aBW();
        }
        this.hYl = null;
        AppMethodBeat.m2505o(131518);
    }

    public final void requestVideoData(String str, int i, int i2) {
        AppMethodBeat.m2504i(131519);
        C4990ab.m7417i("MicroMsg.AppBrandOnlineVideoProxy", "%s requestVideoData [%s, %d %d]", Integer.valueOf(hashCode()), str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.hYl != null) {
            MainProcessTask mainProcessTask = this.hYl;
            mainProcessTask.offset = i;
            mainProcessTask.length = i2;
            mainProcessTask.hYq = 2;
            AppBrandMainProcessService.m54349a(mainProcessTask);
        }
        AppMethodBeat.m2505o(131519);
    }

    public final boolean isVideoDataAvailable(String str, int i, int i2) {
        AppMethodBeat.m2504i(131520);
        if (this.hYl == null) {
            AppMethodBeat.m2505o(131520);
            return false;
        }
        MainProcessTask mainProcessTask = this.hYl;
        mainProcessTask.offset = i;
        mainProcessTask.length = i2;
        mainProcessTask.hYq = 3;
        AppBrandMainProcessService.m54355b(mainProcessTask);
        boolean z = mainProcessTask.hYw;
        AppMethodBeat.m2505o(131520);
        return z;
    }

    /* renamed from: a */
    public final void mo8712a(C9714a c9714a) {
        this.hYm = c9714a;
        if (this.hYl != null) {
            this.hYl.hYz = c9714a;
        }
    }
}
