package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiPrivateAddContact extends a<h> {
    public static final int CTRL_INDEX = 407;
    public static final String NAME = "private_addContact";

    static final class AddContactResult extends ProcessResult {
        public static final Creator<AddContactResult> CREATOR = new Creator<AddContactResult>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddContactResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(73161);
                AddContactResult addContactResult = new AddContactResult(parcel);
                AppMethodBeat.o(73161);
                return addContactResult;
            }
        };
        private int bFZ;

        AddContactResult() {
        }

        AddContactResult(Parcel parcel) {
            AppMethodBeat.i(73162);
            k(parcel);
            AppMethodBeat.o(73162);
        }

        public final void k(Parcel parcel) {
            AppMethodBeat.i(73163);
            this.bFZ = parcel.readInt();
            AppMethodBeat.o(73163);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(73164);
            parcel.writeInt(this.bFZ);
            AppMethodBeat.o(73164);
        }

        static {
            AppMethodBeat.i(73165);
            AppMethodBeat.o(73165);
        }
    }

    static final class a extends AppBrandProxyUIProcessTask {
        private a() {
        }

        static /* synthetic */ void a(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(73168);
            aVar.a(processResult);
            AppMethodBeat.o(73168);
        }

        public final void a(ProcessRequest processRequest) {
            boolean z = true;
            AppMethodBeat.i(73167);
            final AddContactResult addContactResult = new AddContactResult();
            if (processRequest instanceof AddContactRequest) {
                AddContactRequest addContactRequest = (AddContactRequest) processRequest;
                g gVar = (g) com.tencent.mm.kernel.g.K(g.class);
                MMActivity aBQ = aBQ();
                String str = addContactRequest.userName;
                int i = addContactRequest.scene;
                AnonymousClass1 anonymousClass1 = new n() {
                    public final void nZ(int i) {
                        AppMethodBeat.i(73166);
                        ab.i("MicroMsg.JsApiPrivateAddContact", "onAddContact resultCode:%d", Integer.valueOf(i));
                        addContactResult.bFZ = i;
                        a.a(a.this, addContactResult);
                        AppMethodBeat.o(73166);
                    }
                };
                if (addContactRequest.hyy != 1) {
                    z = false;
                }
                gVar.a(aBQ, str, i, anonymousClass1, z, "").show();
                AppMethodBeat.o(73167);
                return;
            }
            ab.w("MicroMsg.JsApiPrivateAddContact", "handleRequest !(request instanceof AddContactRequest)");
            addContactResult.bFZ = -1;
            a((ProcessResult) addContactResult);
            AppMethodBeat.o(73167);
        }
    }

    static final class AddContactRequest extends ProcessRequest {
        public static final Creator<AddContactRequest> CREATOR = new Creator<AddContactRequest>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddContactRequest[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(73156);
                AddContactRequest addContactRequest = new AddContactRequest(parcel);
                AppMethodBeat.o(73156);
                return addContactRequest;
            }
        };
        int hyy;
        int scene;
        String userName;

        AddContactRequest() {
        }

        AddContactRequest(Parcel parcel) {
            AppMethodBeat.i(73157);
            k(parcel);
            AppMethodBeat.o(73157);
        }

        public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
            return a.class;
        }

        public final void k(Parcel parcel) {
            AppMethodBeat.i(73158);
            this.userName = parcel.readString();
            this.scene = parcel.readInt();
            this.hyy = parcel.readInt();
            AppMethodBeat.o(73158);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(73159);
            parcel.writeString(this.userName);
            parcel.writeInt(this.scene);
            parcel.writeInt(this.hyy);
            AppMethodBeat.o(73159);
        }

        static {
            AppMethodBeat.i(73160);
            AppMethodBeat.o(73160);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(73169);
        final h hVar = (h) cVar;
        int aCl = aCl();
        try {
            int i2 = jSONObject.getInt("scene");
            String string = jSONObject.getString("username");
            if (bo.isNullOrNil(string)) {
                ab.i("MicroMsg.JsApiPrivateAddContact", "username nil");
                hVar.M(i, j("fail:username is nil", null));
                AppMethodBeat.o(73169);
                return;
            }
            AddContactRequest addContactRequest = new AddContactRequest();
            addContactRequest.userName = string;
            addContactRequest.scene = i2;
            addContactRequest.hyy = aCl;
            com.tencent.mm.plugin.appbrand.ipc.a.a(hVar.getContext(), addContactRequest, new b<AddContactResult>() {
                public final /* synthetic */ void c(ProcessResult processResult) {
                    AppMethodBeat.i(73155);
                    ab.i("MicroMsg.JsApiPrivateAddContact", "onReceiveResult resultCode:%d", Integer.valueOf(((AddContactResult) processResult).bFZ));
                    switch (((AddContactResult) processResult).bFZ) {
                        case -2:
                            hVar.M(i, JsApiPrivateAddContact.this.j("added", null));
                            AppMethodBeat.o(73155);
                            return;
                        case -1:
                            hVar.M(i, JsApiPrivateAddContact.this.j("fail", null));
                            break;
                        case 0:
                            hVar.M(i, JsApiPrivateAddContact.this.j("cancel", null));
                            AppMethodBeat.o(73155);
                            return;
                        case 1:
                            hVar.M(i, JsApiPrivateAddContact.this.j("ok", null));
                            AppMethodBeat.o(73155);
                            return;
                    }
                    AppMethodBeat.o(73155);
                }
            });
            AppMethodBeat.o(73169);
        } catch (JSONException e) {
            ab.w("MicroMsg.JsApiPrivateAddContact", "parse exp:%s", e);
            hVar.M(i, j("fail:parse exp", null));
            AppMethodBeat.o(73169);
        }
    }

    /* Access modifiers changed, original: protected */
    public int aCl() {
        return 1;
    }
}
