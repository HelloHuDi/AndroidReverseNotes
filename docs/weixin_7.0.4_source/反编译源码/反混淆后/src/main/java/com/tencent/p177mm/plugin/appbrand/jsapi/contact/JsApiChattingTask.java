package com.tencent.p177mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.appbrand.service.C42686d.C38509a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChattingTask */
public class JsApiChattingTask extends MainProcessTask {
    public static final Creator<JsApiChattingTask> CREATOR = new C313002();
    public Runnable hww;
    public String nickname;
    public String sessionFrom;
    public String username;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChattingTask$2 */
    static class C313002 implements Creator<JsApiChattingTask> {
        C313002() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiChattingTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(130983);
            JsApiChattingTask jsApiChattingTask = new JsApiChattingTask(parcel);
            AppMethodBeat.m2505o(130983);
            return jsApiChattingTask;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChattingTask$1 */
    class C313011 implements C38509a {
        C313011() {
        }

        /* renamed from: d */
        public final void mo21701d(WxaAttributes wxaAttributes) {
            AppMethodBeat.m2504i(130982);
            if (wxaAttributes == null) {
                C4990ab.m7420w("MicroMsg.JsApiChattingTask", "info is null, err");
            }
            JsApiChattingTask.m50553a(JsApiChattingTask.this);
            AppMethodBeat.m2505o(130982);
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m50553a(JsApiChattingTask jsApiChattingTask) {
        AppMethodBeat.m2504i(130989);
        boolean aCb = jsApiChattingTask.aCb();
        AppMethodBeat.m2505o(130989);
        return aCb;
    }

    public JsApiChattingTask(Parcel parcel) {
        AppMethodBeat.m2504i(130984);
        mo6032g(parcel);
        AppMethodBeat.m2505o(130984);
    }

    public final void asP() {
        AppMethodBeat.m2504i(130985);
        if (C1720g.m3534RN().eJb) {
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.username);
            C4990ab.m7411d("MicroMsg.JsApiChattingTask", "sessionFrom:%s,username:%s,nickname:%s", this.sessionFrom, this.username, this.nickname);
            if (aoO == null || ((int) aoO.ewQ) == 0) {
                C7616ad c7616ad = new C7616ad(this.username);
                c7616ad.setType(0);
                c7616ad.mo14703iB(this.nickname);
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15702Z(c7616ad);
                C4990ab.m7417i("MicroMsg.JsApiChattingTask", "%s save to contact_table", this.username);
            }
            ((C42686d) C1720g.m3528K(C42686d.class)).mo44617b(this.username, new C313011());
            AppMethodBeat.m2505o(130985);
            return;
        }
        aCb();
        AppMethodBeat.m2505o(130985);
    }

    public final void asQ() {
        AppMethodBeat.m2504i(130986);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.m2505o(130986);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        AppMethodBeat.m2504i(130987);
        this.sessionFrom = parcel.readString();
        this.username = parcel.readString();
        this.nickname = parcel.readString();
        AppMethodBeat.m2505o(130987);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(130988);
        parcel.writeString(this.sessionFrom);
        parcel.writeString(this.username);
        parcel.writeString(this.nickname);
        AppMethodBeat.m2505o(130988);
    }

    static {
        AppMethodBeat.m2504i(130990);
        AppMethodBeat.m2505o(130990);
    }
}
