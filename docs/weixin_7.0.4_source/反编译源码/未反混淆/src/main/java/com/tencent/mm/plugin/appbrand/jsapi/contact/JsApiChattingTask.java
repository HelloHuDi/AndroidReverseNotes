package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.plugin.appbrand.service.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;

public class JsApiChattingTask extends MainProcessTask {
    public static final Creator<JsApiChattingTask> CREATOR = new Creator<JsApiChattingTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiChattingTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(130983);
            JsApiChattingTask jsApiChattingTask = new JsApiChattingTask(parcel);
            AppMethodBeat.o(130983);
            return jsApiChattingTask;
        }
    };
    public Runnable hww;
    public String nickname;
    public String sessionFrom;
    public String username;

    static /* synthetic */ boolean a(JsApiChattingTask jsApiChattingTask) {
        AppMethodBeat.i(130989);
        boolean aCb = jsApiChattingTask.aCb();
        AppMethodBeat.o(130989);
        return aCb;
    }

    public JsApiChattingTask(Parcel parcel) {
        AppMethodBeat.i(130984);
        g(parcel);
        AppMethodBeat.o(130984);
    }

    public final void asP() {
        AppMethodBeat.i(130985);
        if (g.RN().eJb) {
            ad aoO = ((j) g.K(j.class)).XM().aoO(this.username);
            ab.d("MicroMsg.JsApiChattingTask", "sessionFrom:%s,username:%s,nickname:%s", this.sessionFrom, this.username, this.nickname);
            if (aoO == null || ((int) aoO.ewQ) == 0) {
                ad adVar = new ad(this.username);
                adVar.setType(0);
                adVar.iB(this.nickname);
                ((j) g.K(j.class)).XM().Z(adVar);
                ab.i("MicroMsg.JsApiChattingTask", "%s save to contact_table", this.username);
            }
            ((d) g.K(d.class)).b(this.username, new a() {
                public final void d(WxaAttributes wxaAttributes) {
                    AppMethodBeat.i(130982);
                    if (wxaAttributes == null) {
                        ab.w("MicroMsg.JsApiChattingTask", "info is null, err");
                    }
                    JsApiChattingTask.a(JsApiChattingTask.this);
                    AppMethodBeat.o(130982);
                }
            });
            AppMethodBeat.o(130985);
            return;
        }
        aCb();
        AppMethodBeat.o(130985);
    }

    public final void asQ() {
        AppMethodBeat.i(130986);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.o(130986);
    }

    public final void g(Parcel parcel) {
        AppMethodBeat.i(130987);
        this.sessionFrom = parcel.readString();
        this.username = parcel.readString();
        this.nickname = parcel.readString();
        AppMethodBeat.o(130987);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(130988);
        parcel.writeString(this.sessionFrom);
        parcel.writeString(this.username);
        parcel.writeString(this.nickname);
        AppMethodBeat.o(130988);
    }

    static {
        AppMethodBeat.i(130990);
        AppMethodBeat.o(130990);
    }
}
