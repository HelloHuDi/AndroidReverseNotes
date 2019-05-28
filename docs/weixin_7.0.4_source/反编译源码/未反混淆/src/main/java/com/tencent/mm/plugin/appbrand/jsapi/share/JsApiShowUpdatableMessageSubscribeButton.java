package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import junit.framework.Assert;
import org.json.JSONObject;

public final class JsApiShowUpdatableMessageSubscribeButton extends a<q> {
    public static final int CTRL_INDEX = 465;
    public static final String NAME = "showUpdatableMessageSubscribeButton";

    static class ShowUpdatableMessageSubscribeButtonTask extends MainProcessTask {
        public static final Creator<ShowUpdatableMessageSubscribeButtonTask> CREATOR = new Creator<ShowUpdatableMessageSubscribeButtonTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ShowUpdatableMessageSubscribeButtonTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131453);
                ShowUpdatableMessageSubscribeButtonTask showUpdatableMessageSubscribeButtonTask = new ShowUpdatableMessageSubscribeButtonTask(parcel);
                AppMethodBeat.o(131453);
                return showUpdatableMessageSubscribeButtonTask;
            }
        };
        public String bQi;

        public ShowUpdatableMessageSubscribeButtonTask(Parcel parcel) {
            AppMethodBeat.i(131454);
            g(parcel);
            AppMethodBeat.o(131454);
        }

        public final void asP() {
            AppMethodBeat.i(131455);
            if (g.K(k.class) == null) {
                ab.e("MicroMsg.ShowUpdatableMessageSubscribeButtonTask", "IWxaUpdateableMsgService is null, err, return");
                if (f.IS_FLAVOR_RED) {
                    Assert.assertTrue("IWxaUpdateableMsgService is null, err, @tummy", false);
                }
                AppMethodBeat.o(131455);
                return;
            }
            b pn = ((k) g.K(k.class)).pn(this.bQi);
            if (pn == null || (pn.field_btnState != 2 && pn.field_msgState == 0)) {
                ((k) g.K(k.class)).T(this.bQi, 1);
                AppMethodBeat.o(131455);
                return;
            }
            ab.e("MicroMsg.ShowUpdatableMessageSubscribeButtonTask", "shareKey:%s btnState:%d msgState:%d ingore already process", this.bQi, Integer.valueOf(pn.field_btnState), Integer.valueOf(pn.field_msgState));
            AppMethodBeat.o(131455);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(131456);
            this.bQi = parcel.readString();
            AppMethodBeat.o(131456);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131457);
            parcel.writeString(this.bQi);
            AppMethodBeat.o(131457);
        }

        static {
            AppMethodBeat.i(131458);
            AppMethodBeat.o(131458);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131459);
        q qVar = (q) cVar;
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiShowUpdatableMessageSubscribeButton", "data is null, err");
            qVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(131459);
            return;
        }
        String optString = jSONObject.optString("shareKey");
        if (bo.isNullOrNil(optString)) {
            ab.e("MicroMsg.JsApiShowUpdatableMessageSubscribeButton", "shareKey is null, err");
            qVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(131459);
            return;
        }
        MainProcessTask showUpdatableMessageSubscribeButtonTask = new ShowUpdatableMessageSubscribeButtonTask();
        showUpdatableMessageSubscribeButtonTask.bQi = optString;
        AppBrandMainProcessService.a(showUpdatableMessageSubscribeButtonTask);
        qVar.M(i, j("ok", null));
        AppMethodBeat.o(131459);
    }
}
