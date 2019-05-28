package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.C19247b;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.p177mm.plugin.appbrand.ipc.C26907a;
import com.tencent.p177mm.pluginsdk.C23243g;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40461n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact */
public class JsApiPrivateAddContact extends C10296a<C33327h> {
    public static final int CTRL_INDEX = 407;
    public static final String NAME = "private_addContact";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact$AddContactResult */
    static final class AddContactResult extends ProcessResult {
        public static final Creator<AddContactResult> CREATOR = new C21911();
        private int bFZ;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact$AddContactResult$1 */
        static class C21911 implements Creator<AddContactResult> {
            C21911() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddContactResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(73161);
                AddContactResult addContactResult = new AddContactResult(parcel);
                AppMethodBeat.m2505o(73161);
                return addContactResult;
            }
        }

        AddContactResult() {
        }

        AddContactResult(Parcel parcel) {
            AppMethodBeat.m2504i(73162);
            mo6045k(parcel);
            AppMethodBeat.m2505o(73162);
        }

        /* renamed from: k */
        public final void mo6045k(Parcel parcel) {
            AppMethodBeat.m2504i(73163);
            this.bFZ = parcel.readInt();
            AppMethodBeat.m2505o(73163);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(73164);
            parcel.writeInt(this.bFZ);
            AppMethodBeat.m2505o(73164);
        }

        static {
            AppMethodBeat.m2504i(73165);
            AppMethodBeat.m2505o(73165);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact$a */
    static final class C2193a extends AppBrandProxyUIProcessTask {
        private C2193a() {
        }

        /* renamed from: a */
        static /* synthetic */ void m4405a(C2193a c2193a, ProcessResult processResult) {
            AppMethodBeat.m2504i(73168);
            c2193a.mo34449a(processResult);
            AppMethodBeat.m2505o(73168);
        }

        /* renamed from: a */
        public final void mo6047a(ProcessRequest processRequest) {
            boolean z = true;
            AppMethodBeat.m2504i(73167);
            final AddContactResult addContactResult = new AddContactResult();
            if (processRequest instanceof AddContactRequest) {
                AddContactRequest addContactRequest = (AddContactRequest) processRequest;
                C23243g c23243g = (C23243g) C1720g.m3528K(C23243g.class);
                MMActivity aBQ = aBQ();
                String str = addContactRequest.userName;
                int i = addContactRequest.scene;
                C21921 c21921 = new C40461n() {
                    /* renamed from: nZ */
                    public final void mo6042nZ(int i) {
                        AppMethodBeat.m2504i(73166);
                        C4990ab.m7417i("MicroMsg.JsApiPrivateAddContact", "onAddContact resultCode:%d", Integer.valueOf(i));
                        addContactResult.bFZ = i;
                        C2193a.m4405a(C2193a.this, addContactResult);
                        AppMethodBeat.m2505o(73166);
                    }
                };
                if (addContactRequest.hyy != 1) {
                    z = false;
                }
                c23243g.mo9881a(aBQ, str, i, c21921, z, "").show();
                AppMethodBeat.m2505o(73167);
                return;
            }
            C4990ab.m7420w("MicroMsg.JsApiPrivateAddContact", "handleRequest !(request instanceof AddContactRequest)");
            addContactResult.bFZ = -1;
            mo34449a((ProcessResult) addContactResult);
            AppMethodBeat.m2505o(73167);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact$AddContactRequest */
    static final class AddContactRequest extends ProcessRequest {
        public static final Creator<AddContactRequest> CREATOR = new C21941();
        int hyy;
        int scene;
        String userName;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact$AddContactRequest$1 */
        static class C21941 implements Creator<AddContactRequest> {
            C21941() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddContactRequest[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(73156);
                AddContactRequest addContactRequest = new AddContactRequest(parcel);
                AppMethodBeat.m2505o(73156);
                return addContactRequest;
            }
        }

        AddContactRequest() {
        }

        AddContactRequest(Parcel parcel) {
            AppMethodBeat.m2504i(73157);
            mo6049k(parcel);
            AppMethodBeat.m2505o(73157);
        }

        public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
            return C2193a.class;
        }

        /* renamed from: k */
        public final void mo6049k(Parcel parcel) {
            AppMethodBeat.m2504i(73158);
            this.userName = parcel.readString();
            this.scene = parcel.readInt();
            this.hyy = parcel.readInt();
            AppMethodBeat.m2505o(73158);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(73159);
            parcel.writeString(this.userName);
            parcel.writeInt(this.scene);
            parcel.writeInt(this.hyy);
            AppMethodBeat.m2505o(73159);
        }

        static {
            AppMethodBeat.m2504i(73160);
            AppMethodBeat.m2505o(73160);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(73169);
        final C33327h c33327h = (C33327h) c2241c;
        int aCl = aCl();
        try {
            int i2 = jSONObject.getInt("scene");
            String string = jSONObject.getString("username");
            if (C5046bo.isNullOrNil(string)) {
                C4990ab.m7416i("MicroMsg.JsApiPrivateAddContact", "username nil");
                c33327h.mo6107M(i, mo73394j("fail:username is nil", null));
                AppMethodBeat.m2505o(73169);
                return;
            }
            AddContactRequest addContactRequest = new AddContactRequest();
            addContactRequest.userName = string;
            addContactRequest.scene = i2;
            addContactRequest.hyy = aCl;
            C26907a.m42840a(c33327h.getContext(), addContactRequest, new C19247b<AddContactResult>() {
                /* renamed from: c */
                public final /* synthetic */ void mo6053c(ProcessResult processResult) {
                    AppMethodBeat.m2504i(73155);
                    C4990ab.m7417i("MicroMsg.JsApiPrivateAddContact", "onReceiveResult resultCode:%d", Integer.valueOf(((AddContactResult) processResult).bFZ));
                    switch (((AddContactResult) processResult).bFZ) {
                        case -2:
                            c33327h.mo6107M(i, JsApiPrivateAddContact.this.mo73394j("added", null));
                            AppMethodBeat.m2505o(73155);
                            return;
                        case -1:
                            c33327h.mo6107M(i, JsApiPrivateAddContact.this.mo73394j("fail", null));
                            break;
                        case 0:
                            c33327h.mo6107M(i, JsApiPrivateAddContact.this.mo73394j("cancel", null));
                            AppMethodBeat.m2505o(73155);
                            return;
                        case 1:
                            c33327h.mo6107M(i, JsApiPrivateAddContact.this.mo73394j("ok", null));
                            AppMethodBeat.m2505o(73155);
                            return;
                    }
                    AppMethodBeat.m2505o(73155);
                }
            });
            AppMethodBeat.m2505o(73169);
        } catch (JSONException e) {
            C4990ab.m7421w("MicroMsg.JsApiPrivateAddContact", "parse exp:%s", e);
            c33327h.mo6107M(i, mo73394j("fail:parse exp", null));
            AppMethodBeat.m2505o(73169);
        }
    }

    /* Access modifiers changed, original: protected */
    public int aCl() {
        return 1;
    }
}
