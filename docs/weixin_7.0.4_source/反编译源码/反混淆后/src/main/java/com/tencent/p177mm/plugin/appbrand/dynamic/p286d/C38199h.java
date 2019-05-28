package com.tencent.p177mm.plugin.appbrand.dynamic.p286d;

import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.extension.C42136f;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.modelappbrand.C26438t;
import com.tencent.p177mm.p652z.p1101b.C40953b.C16115a;
import com.tencent.p177mm.p652z.p653c.C36405a;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10210e;
import com.tencent.p177mm.plugin.appbrand.dynamic.C2150h;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p888a.C10200a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.h */
public final class C38199h extends C10200a {

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.h$a */
    static class C10206a implements C37866a<C10207b, Bundle> {
        private C10206a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, final C18507c c18507c) {
            AppMethodBeat.m2504i(10841);
            C10207b c10207b = (C10207b) obj;
            final Bundle bundle = new Bundle();
            View zS = C10210e.azz().mo21627zS(c10207b.f2868id);
            if (zS instanceof C2150h) {
                ((C2150h) zS).mo5965a(c10207b.hmZ, c10207b.cOS, c10207b.hna, new C26438t() {
                    /* renamed from: b */
                    public final void mo5959b(boolean z, String str, Bundle bundle) {
                        AppMethodBeat.m2504i(10840);
                        bundle.putBoolean("ret", z);
                        bundle.putString("reason", str);
                        bundle.putBundle("data", bundle);
                        c18507c.mo5960ao(bundle);
                        AppMethodBeat.m2505o(10840);
                    }
                });
                AppMethodBeat.m2505o(10841);
                return;
            }
            C4990ab.m7417i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "onTapCallback failed, view is not a instance of DynamicPageAccessible.(%s)", c10207b.f2868id);
            bundle.putBoolean("ret", false);
            bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
            c18507c.mo5960ao(bundle);
            AppMethodBeat.m2505o(10841);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.h$b */
    public static class C10207b implements C42136f {
        String cOS;
        boolean hmZ;
        boolean hna;
        /* renamed from: id */
        String f2868id;

        /* renamed from: e */
        public final void mo5956e(Parcel parcel) {
            int i;
            int i2 = 1;
            AppMethodBeat.m2504i(10842);
            parcel.writeString(this.f2868id);
            if (this.hmZ) {
                i = 1;
            } else {
                i = 0;
            }
            parcel.writeInt(i);
            parcel.writeString(this.cOS);
            if (!this.hna) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            AppMethodBeat.m2505o(10842);
        }

        public final void readFromParcel(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(10843);
            this.f2868id = parcel.readString();
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.hmZ = z;
            this.cOS = parcel.readString();
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.hna = z2;
            AppMethodBeat.m2505o(10843);
        }
    }

    public C38199h() {
        super("onTapCallback", ErrorCode.TEST_THROWABLE_ISNOT_NULL);
    }

    /* renamed from: a */
    public final void mo5955a(C36405a c36405a, JSONObject jSONObject, final C16115a<JSONObject> c16115a) {
        AppMethodBeat.m2504i(10844);
        C32800b Qy = c36405a.mo11733Qy();
        C10207b c10207b = new C10207b();
        c10207b.f2868id = Qy.getString("__page_view_id", "");
        c10207b.cOS = jSONObject.optString("eventId", "");
        c10207b.hmZ = jSONObject.optBoolean("hasHandler");
        c10207b.hna = jSONObject.optBoolean("res");
        XIPCInvoker.m83629a(Qy.getString("__process_name", C4996ah.getProcessName()), c10207b, C10206a.class, new C18507c<Bundle>() {
            /* renamed from: ao */
            public final /* synthetic */ void mo5960ao(Object obj) {
                Bundle bundle;
                String str;
                AppMethodBeat.m2504i(10839);
                Bundle bundle2 = (Bundle) obj;
                boolean z = false;
                if (bundle2 != null) {
                    z = bundle2.getBoolean("ret");
                    String string = bundle2.getString("reason");
                    bundle = bundle2.getBundle("data");
                    str = string;
                } else {
                    bundle = null;
                    str = null;
                }
                c16115a.mo11732au(C38199h.this.mo57326a(z, str, bundle));
                AppMethodBeat.m2505o(10839);
            }
        });
        AppMethodBeat.m2505o(10844);
    }
}
