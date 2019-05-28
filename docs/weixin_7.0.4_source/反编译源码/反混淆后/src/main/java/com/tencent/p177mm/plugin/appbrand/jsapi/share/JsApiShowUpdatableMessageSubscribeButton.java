package com.tencent.p177mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C45446k;
import com.tencent.p177mm.p181af.p1175a.C17871b;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import junit.framework.Assert;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShowUpdatableMessageSubscribeButton */
public final class JsApiShowUpdatableMessageSubscribeButton extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 465;
    public static final String NAME = "showUpdatableMessageSubscribeButton";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShowUpdatableMessageSubscribeButton$ShowUpdatableMessageSubscribeButtonTask */
    static class ShowUpdatableMessageSubscribeButtonTask extends MainProcessTask {
        public static final Creator<ShowUpdatableMessageSubscribeButtonTask> CREATOR = new C383801();
        public String bQi;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShowUpdatableMessageSubscribeButton$ShowUpdatableMessageSubscribeButtonTask$1 */
        static class C383801 implements Creator<ShowUpdatableMessageSubscribeButtonTask> {
            C383801() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ShowUpdatableMessageSubscribeButtonTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131453);
                ShowUpdatableMessageSubscribeButtonTask showUpdatableMessageSubscribeButtonTask = new ShowUpdatableMessageSubscribeButtonTask(parcel);
                AppMethodBeat.m2505o(131453);
                return showUpdatableMessageSubscribeButtonTask;
            }
        }

        public ShowUpdatableMessageSubscribeButtonTask(Parcel parcel) {
            AppMethodBeat.m2504i(131454);
            mo6032g(parcel);
            AppMethodBeat.m2505o(131454);
        }

        public final void asP() {
            AppMethodBeat.m2504i(131455);
            if (C1720g.m3528K(C45446k.class) == null) {
                C4990ab.m7412e("MicroMsg.ShowUpdatableMessageSubscribeButtonTask", "IWxaUpdateableMsgService is null, err, return");
                if (C5058f.IS_FLAVOR_RED) {
                    Assert.assertTrue("IWxaUpdateableMsgService is null, err, @tummy", false);
                }
                AppMethodBeat.m2505o(131455);
                return;
            }
            C17871b pn = ((C45446k) C1720g.m3528K(C45446k.class)).mo60978pn(this.bQi);
            if (pn == null || (pn.field_btnState != 2 && pn.field_msgState == 0)) {
                ((C45446k) C1720g.m3528K(C45446k.class)).mo60973T(this.bQi, 1);
                AppMethodBeat.m2505o(131455);
                return;
            }
            C4990ab.m7413e("MicroMsg.ShowUpdatableMessageSubscribeButtonTask", "shareKey:%s btnState:%d msgState:%d ingore already process", this.bQi, Integer.valueOf(pn.field_btnState), Integer.valueOf(pn.field_msgState));
            AppMethodBeat.m2505o(131455);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(131456);
            this.bQi = parcel.readString();
            AppMethodBeat.m2505o(131456);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131457);
            parcel.writeString(this.bQi);
            AppMethodBeat.m2505o(131457);
        }

        static {
            AppMethodBeat.m2504i(131458);
            AppMethodBeat.m2505o(131458);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131459);
        C38492q c38492q = (C38492q) c2241c;
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiShowUpdatableMessageSubscribeButton", "data is null, err");
            c38492q.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(131459);
            return;
        }
        String optString = jSONObject.optString("shareKey");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7412e("MicroMsg.JsApiShowUpdatableMessageSubscribeButton", "shareKey is null, err");
            c38492q.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(131459);
            return;
        }
        MainProcessTask showUpdatableMessageSubscribeButtonTask = new ShowUpdatableMessageSubscribeButtonTask();
        showUpdatableMessageSubscribeButtonTask.bQi = optString;
        AppBrandMainProcessService.m54349a(showUpdatableMessageSubscribeButtonTask);
        c38492q.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(131459);
    }
}
