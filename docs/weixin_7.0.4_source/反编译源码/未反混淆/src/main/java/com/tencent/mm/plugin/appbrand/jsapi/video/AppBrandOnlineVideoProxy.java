package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.i.h;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.c.d.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;

public final class AppBrandOnlineVideoProxy implements b {
    private OnlineVideoProxy hYl;
    private a hYm;

    static class OnlineVideoProxy extends MainProcessTask {
        public static final Creator<OnlineVideoProxy> CREATOR = new Creator<OnlineVideoProxy>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OnlineVideoProxy[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131505);
                OnlineVideoProxy onlineVideoProxy = new OnlineVideoProxy(parcel);
                AppMethodBeat.o(131505);
                return onlineVideoProxy;
            }
        };
        final int START = 1;
        final int STOP = 4;
        String fUL;
        c hYA = new c() {
            public final void cR(int i, int i2) {
                AppMethodBeat.i(131501);
                OnlineVideoProxy.this.hYx = i;
                OnlineVideoProxy.this.hYy = i2;
                OnlineVideoProxy.this.hYv = 10;
                OnlineVideoProxy.a(OnlineVideoProxy.this);
                AppMethodBeat.o(131501);
            }

            public final void cS(int i, int i2) {
                AppMethodBeat.i(131502);
                OnlineVideoProxy.this.hYx = i;
                OnlineVideoProxy.this.hYy = i2;
                OnlineVideoProxy.this.hYv = 11;
                OnlineVideoProxy.b(OnlineVideoProxy.this);
                AppMethodBeat.o(131502);
            }

            public final void cT(int i, int i2) {
                AppMethodBeat.i(131503);
                OnlineVideoProxy.this.hYx = i;
                OnlineVideoProxy.this.hYy = i2;
                OnlineVideoProxy.this.hYv = 12;
                OnlineVideoProxy.c(OnlineVideoProxy.this);
                AppMethodBeat.o(131503);
            }

            public final void ad(String str, int i) {
                AppMethodBeat.i(131504);
                ab.i("MicroMsg.AppBrandOnlineVideoProxy", "on finish [%s %d]", str, Integer.valueOf(i));
                OnlineVideoProxy.this.hYx = i;
                OnlineVideoProxy.this.hYv = 13;
                f.auY().yD(OnlineVideoProxy.this.fUL);
                OnlineVideoProxy.d(OnlineVideoProxy.this);
                AppMethodBeat.o(131504);
            }
        };
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
        a hYz;
        int length;
        int offset;
        String path;
        String url;

        static /* synthetic */ boolean a(OnlineVideoProxy onlineVideoProxy) {
            AppMethodBeat.i(131512);
            boolean aCb = onlineVideoProxy.aCb();
            AppMethodBeat.o(131512);
            return aCb;
        }

        static /* synthetic */ boolean b(OnlineVideoProxy onlineVideoProxy) {
            AppMethodBeat.i(131513);
            boolean aCb = onlineVideoProxy.aCb();
            AppMethodBeat.o(131513);
            return aCb;
        }

        static /* synthetic */ boolean c(OnlineVideoProxy onlineVideoProxy) {
            AppMethodBeat.i(131514);
            boolean aCb = onlineVideoProxy.aCb();
            AppMethodBeat.o(131514);
            return aCb;
        }

        static /* synthetic */ boolean d(OnlineVideoProxy onlineVideoProxy) {
            AppMethodBeat.i(131515);
            boolean aCb = onlineVideoProxy.aCb();
            AppMethodBeat.o(131515);
            return aCb;
        }

        public OnlineVideoProxy() {
            AppMethodBeat.i(131506);
            AppMethodBeat.o(131506);
        }

        public OnlineVideoProxy(Parcel parcel) {
            AppMethodBeat.i(131507);
            g(parcel);
            AppMethodBeat.o(131507);
        }

        public final void asQ() {
            AppMethodBeat.i(131508);
            ab.d("MicroMsg.AppBrandOnlineVideoProxy", "runInClientProcess cdnMediaId[%s] clientState[%d] [%d %d]", this.fUL, Integer.valueOf(this.hYv), Integer.valueOf(this.hYx), Integer.valueOf(this.hYy));
            if (this.hYz == null) {
                AppMethodBeat.o(131508);
                return;
            }
            switch (this.hYv) {
                case 10:
                    this.hYz.ml(this.hYx);
                    break;
                case 11:
                    this.hYz.onDataAvailable(this.fUL, this.hYx, this.hYy);
                    break;
                case 12:
                    this.hYz.h(this.fUL, this.hYx, this.hYy);
                    break;
                case 13:
                    this.hYz.ad(this.fUL, this.hYx);
                    break;
            }
            this.hYv = 0;
            ab.i("MicroMsg.AppBrandOnlineVideoProxy", "runInClientProcess reset clientState[%d] ", Integer.valueOf(this.hYv));
            AppMethodBeat.o(131508);
        }

        public final void asP() {
            AppMethodBeat.i(131509);
            ab.d("MicroMsg.AppBrandOnlineVideoProxy", "runInMainProcess cdnMediaId[%s] state[%d]", this.fUL, Integer.valueOf(this.hYq));
            String str;
            int i;
            int i2;
            switch (this.hYq) {
                case 1:
                    com.tencent.mm.plugin.appbrand.c.b auY = f.auY();
                    auY.hew.put(this.fUL, this.hYA);
                    auY = f.auY();
                    ab.i("MicroMsg.AppbrandCdnService", "add online video task [%s] url[%s] path[%s]", this.fUL, this.url, this.path);
                    h hVar = new h();
                    hVar.field_mediaId = r1;
                    hVar.field_fullpath = r3;
                    hVar.url = r2;
                    hVar.egK = auY.hex;
                    hVar.egD = 1;
                    hVar.egy = 4;
                    o.alm().a(hVar, false);
                    break;
                case 2:
                    f.auY();
                    str = this.fUL;
                    i = this.offset;
                    i2 = this.length;
                    ab.i("MicroMsg.AppbrandCdnService", "request online video task [%s]", str);
                    o.alm();
                    e.k(str, i, i2);
                    break;
                case 3:
                    f.auY();
                    str = this.fUL;
                    i = this.offset;
                    i2 = this.length;
                    ab.i("MicroMsg.AppbrandCdnService", "check online video task [%s]", str);
                    this.hYw = o.alm().isVideoDataAvailable(str, i, i2);
                    aCb();
                    AppMethodBeat.o(131509);
                    return;
                case 4:
                    f.auY().yD(this.fUL);
                    f.auY();
                    ab.i("MicroMsg.AppbrandCdnService", "cancel online video task [%s]", this.fUL);
                    o.alm().m(str, null);
                    break;
                default:
                    ab.w("MicroMsg.AppBrandOnlineVideoProxy", "unknow state ");
                    break;
            }
            this.hYq = 0;
            ab.i("MicroMsg.AppBrandOnlineVideoProxy", "runInMainProcess reset mainState[%d] ", Integer.valueOf(this.hYq));
            aCb();
            AppMethodBeat.o(131509);
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(131510);
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
            AppMethodBeat.o(131510);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131511);
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
            AppMethodBeat.o(131511);
        }

        static {
            AppMethodBeat.i(131516);
            AppMethodBeat.o(131516);
        }
    }

    public final void r(String str, String str2, String str3) {
        AppMethodBeat.i(131517);
        ab.i("MicroMsg.AppBrandOnlineVideoProxy", "%s start http stream[%s, %s, %s]", Integer.valueOf(hashCode()), str, str2, str3);
        if (this.hYl == null) {
            this.hYl = new OnlineVideoProxy();
            this.hYl.hYz = this.hYm;
            this.hYl.aBV();
        }
        MainProcessTask mainProcessTask = this.hYl;
        ab.i("MicroMsg.AppBrandOnlineVideoProxy", "%s OnlineVideoProxy start http stream[%s %s %s] ", Integer.valueOf(mainProcessTask.hashCode()), str, str2, str3);
        mainProcessTask.fUL = str;
        mainProcessTask.path = str2;
        mainProcessTask.url = str3;
        mainProcessTask.hYq = 1;
        AppBrandMainProcessService.a(mainProcessTask);
        AppMethodBeat.o(131517);
    }

    public final void dV(String str) {
        AppMethodBeat.i(131518);
        ab.i("MicroMsg.AppBrandOnlineVideoProxy", "%s stop http stream[%s]", Integer.valueOf(hashCode()), str);
        if (this.hYl != null) {
            this.hYl.hYz = null;
            MainProcessTask mainProcessTask = this.hYl;
            mainProcessTask.hYq = 4;
            AppBrandMainProcessService.a(mainProcessTask);
            this.hYl.aBW();
        }
        this.hYl = null;
        AppMethodBeat.o(131518);
    }

    public final void requestVideoData(String str, int i, int i2) {
        AppMethodBeat.i(131519);
        ab.i("MicroMsg.AppBrandOnlineVideoProxy", "%s requestVideoData [%s, %d %d]", Integer.valueOf(hashCode()), str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.hYl != null) {
            MainProcessTask mainProcessTask = this.hYl;
            mainProcessTask.offset = i;
            mainProcessTask.length = i2;
            mainProcessTask.hYq = 2;
            AppBrandMainProcessService.a(mainProcessTask);
        }
        AppMethodBeat.o(131519);
    }

    public final boolean isVideoDataAvailable(String str, int i, int i2) {
        AppMethodBeat.i(131520);
        if (this.hYl == null) {
            AppMethodBeat.o(131520);
            return false;
        }
        MainProcessTask mainProcessTask = this.hYl;
        mainProcessTask.offset = i;
        mainProcessTask.length = i2;
        mainProcessTask.hYq = 3;
        AppBrandMainProcessService.b(mainProcessTask);
        boolean z = mainProcessTask.hYw;
        AppMethodBeat.o(131520);
        return z;
    }

    public final void a(a aVar) {
        this.hYm = aVar;
        if (this.hYl != null) {
            this.hYl.hYz = aVar;
        }
    }
}
