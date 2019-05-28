package com.tencent.p177mm.plugin.webview.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask */
public class JsApiMMTask extends MainProcessTask {
    public static final Creator<JsApiMMTask> CREATOR = new C228282();
    public String aIm;
    public String hAP;
    public C32183a ujK;
    public String ujL;
    public String ujM;

    /* renamed from: com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask$1 */
    class C144751 extends C22841a {
        C144751() {
        }

        /* renamed from: d */
        public final void mo26722d(String str, JSONObject jSONObject) {
            AppMethodBeat.m2504i(6255);
            JsApiMMTask.this.aIm = str;
            if (jSONObject != null) {
                JsApiMMTask.this.ujM = jSONObject.toString();
            }
            JsApiMMTask.m34644a(JsApiMMTask.this);
            AppMethodBeat.m2505o(6255);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask$2 */
    static class C228282 implements Creator<JsApiMMTask> {
        C228282() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiMMTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(6256);
            JsApiMMTask jsApiMMTask = new JsApiMMTask(parcel, (byte) 0);
            AppMethodBeat.m2505o(6256);
            return jsApiMMTask;
        }
    }

    /* synthetic */ JsApiMMTask(Parcel parcel, byte b) {
        this(parcel);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m34644a(JsApiMMTask jsApiMMTask) {
        AppMethodBeat.m2504i(6262);
        boolean aCb = jsApiMMTask.aCb();
        AppMethodBeat.m2505o(6262);
        return aCb;
    }

    public final void asP() {
        AppMethodBeat.m2504i(6257);
        try {
            ((C22840bc) Class.forName(this.ujL).newInstance()).mo9617a(C4996ah.getContext(), this.hAP, new C144751());
            AppMethodBeat.m2505o(6257);
        } catch (Exception e) {
            AppMethodBeat.m2505o(6257);
        }
    }

    public final void asQ() {
        AppMethodBeat.m2504i(6258);
        aBW();
        if (this.ujK != null) {
            try {
                this.ujK.mo52824a(this.aIm, new JSONObject(this.ujM));
                AppMethodBeat.m2505o(6258);
                return;
            } catch (Exception e) {
                this.ujK.mo52824a(this.aIm, null);
            }
        }
        AppMethodBeat.m2505o(6258);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        AppMethodBeat.m2504i(6259);
        this.hAP = parcel.readString();
        this.ujL = parcel.readString();
        this.aIm = parcel.readString();
        this.ujM = parcel.readString();
        AppMethodBeat.m2505o(6259);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(6260);
        parcel.writeString(this.hAP);
        parcel.writeString(this.ujL);
        parcel.writeString(this.aIm);
        parcel.writeString(this.ujM);
        AppMethodBeat.m2505o(6260);
    }

    private JsApiMMTask(Parcel parcel) {
        AppMethodBeat.m2504i(6261);
        mo6032g(parcel);
        AppMethodBeat.m2505o(6261);
    }

    static {
        AppMethodBeat.m2504i(6263);
        AppMethodBeat.m2505o(6263);
    }
}
