package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C37759lr;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas */
public final class JsApiOpenAdCanvas extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 476;
    public static final String NAME = "openADCanvas";
    private String hxW = "";
    private JsApiOpenAdCanvasTask hxX = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas$JsApiOpenAdCanvasTask */
    static class JsApiOpenAdCanvasTask extends MainProcessTask {
        public static final Creator<JsApiOpenAdCanvasTask> CREATOR = new C21902();
        private String cFM;
        private int cHx;
        private int cHy;
        private C38492q hwf;
        private int hwi;
        private C45608m hwz;
        private WeakReference<Context> hxY;
        private String hxZ;
        private String hya;
        private String hyb;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas$JsApiOpenAdCanvasTask$2 */
        static class C21902 implements Creator<JsApiOpenAdCanvasTask> {
            C21902() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new JsApiOpenAdCanvasTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130503);
                JsApiOpenAdCanvasTask jsApiOpenAdCanvasTask = new JsApiOpenAdCanvasTask(parcel);
                AppMethodBeat.m2505o(130503);
                return jsApiOpenAdCanvasTask;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas$JsApiOpenAdCanvasTask$1 */
        class C269141 implements Runnable {
            C269141() {
            }

            public final void run() {
                AppMethodBeat.m2504i(130502);
                C37759lr c37759lr = new C37759lr();
                c37759lr.cHv.pageId = JsApiOpenAdCanvasTask.this.hxZ;
                c37759lr.cHv.cvq = JsApiOpenAdCanvasTask.this.cFM;
                c37759lr.cHv.cHx = JsApiOpenAdCanvasTask.this.cHx;
                c37759lr.cHv.cHy = JsApiOpenAdCanvasTask.this.cHy;
                c37759lr.cHv.cvd = 0;
                C4879a.xxA.mo10055m(c37759lr);
                JsApiOpenAdCanvasTask.this.hyb = c37759lr.cHw.cHz;
                JsApiOpenAdCanvasTask.m42866e(JsApiOpenAdCanvasTask.this);
                AppMethodBeat.m2505o(130502);
            }
        }

        /* renamed from: e */
        static /* synthetic */ boolean m42866e(JsApiOpenAdCanvasTask jsApiOpenAdCanvasTask) {
            AppMethodBeat.m2504i(130509);
            boolean aCb = jsApiOpenAdCanvasTask.aCb();
            AppMethodBeat.m2505o(130509);
            return aCb;
        }

        public JsApiOpenAdCanvasTask(C45608m c45608m, C38492q c38492q, int i, WeakReference<Context> weakReference, String str, int i2, int i3, String str2, String str3) {
            this.hwz = c45608m;
            this.hwf = c38492q;
            this.hwi = i;
            this.hxY = weakReference;
            this.hxZ = str;
            this.cHx = i2;
            this.cHy = i3;
            this.cFM = str2;
            this.hya = str3;
        }

        public JsApiOpenAdCanvasTask(Parcel parcel) {
            AppMethodBeat.m2504i(130504);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130504);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130505);
            String str = this.hyb;
            if (this.cHx == 0) {
                Intent intent = new Intent();
                String str2 = "sns_landing_pages_xml";
                if (str == null) {
                    str = "";
                }
                intent.putExtra(str2, str);
                intent.putExtra("sns_landing_pages_pageid", C5046bo.anl(this.hxZ));
                intent.putExtra("sns_landig_pages_from_source", 13);
                intent.putExtra("sns_landing_pages_extra", this.cFM);
                intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                intent.putExtra("sns_landing_pages_no_store", this.cHy);
                intent.putExtra("sns_landing_pages_ad_info", this.hya);
                C25985d.m41467b((Context) this.hxY.get(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
                this.hwf.mo6107M(this.hwi, this.hwz.mo73394j("ok", null));
            } else if (this.cHx == 1) {
                this.hwf.mo6107M(this.hwi, this.hwz.mo73394j("ok", null));
            } else {
                this.hwf.mo6107M(this.hwi, this.hwz.mo73394j("fail", null));
            }
            aBW();
            AppMethodBeat.m2505o(130505);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130506);
            C7305d.post(new C269141(), "JsApiOpenAdCanvas");
            AppMethodBeat.m2505o(130506);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(130507);
            this.hxZ = parcel.readString();
            this.cHx = parcel.readInt();
            this.cHy = parcel.readInt();
            this.cFM = parcel.readString();
            this.hya = parcel.readString();
            this.hyb = parcel.readString();
            AppMethodBeat.m2505o(130507);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130508);
            parcel.writeString(this.hxZ);
            parcel.writeInt(this.cHx);
            parcel.writeInt(this.cHy);
            parcel.writeString(this.cFM);
            parcel.writeString(this.hya);
            parcel.writeString(this.hyb);
            AppMethodBeat.m2505o(130508);
        }

        static {
            AppMethodBeat.m2504i(130510);
            AppMethodBeat.m2505o(130510);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130511);
        C19722s c19722s = (C19722s) c2241c;
        if (jSONObject == null) {
            c19722s.mo6107M(i, mo73394j("fail jsondata null", null));
            AppMethodBeat.m2505o(130511);
            return;
        }
        Object obj = c19722s.getContext() instanceof MMActivity ? (MMActivity) c19722s.getContext() : null;
        if (obj == null) {
            c19722s.mo6107M(i, mo73394j("fail service context null", null));
            AppMethodBeat.m2505o(130511);
            return;
        }
        try {
            this.hxW = jSONObject.getString("canvasId");
            if (C5046bo.isNullOrNil(this.hxW) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(this.hxW)) {
                HashMap hashMap = new HashMap();
                hashMap.put("canvasId", this.hxW);
                c19722s.mo6107M(i, mo73394j("fail", hashMap));
                C19690c.m30508pJ(0);
                AppMethodBeat.m2505o(130511);
                return;
            }
            int i2 = jSONObject.getInt("preLoad");
            int i3 = jSONObject.getInt("noStore");
            String string = jSONObject.getString("extraData");
            String string2 = jSONObject.getString("adInfoXml");
            C4990ab.m7417i("MicroMsg.JsApiOpenAdCanvas", "doOpenCanvas canvasid %s,preLoad %d, noStore %d", this.hxW, Integer.valueOf(i2), Integer.valueOf(i3));
            this.hxX = new JsApiOpenAdCanvasTask(this, c19722s, i, new WeakReference(obj), this.hxW, i2, i3, string, string2);
            this.hxX.aBV();
            AppBrandMainProcessService.m54349a(this.hxX);
            C19690c.m30501aa(c19722s.getRuntime().atI().bQe + 1000, c19722s.getAppId());
            AppMethodBeat.m2505o(130511);
        } catch (JSONException e) {
            if (this.hxX != null) {
                this.hxX.aBW();
            }
            C4990ab.printErrStackTrace("MicroMsg.JsApiOpenAdCanvas", e, "canvasId=%s", this.hxW);
            C19690c.m30508pJ(1);
            c19722s.mo6107M(i, mo73394j("fail parse json error", null));
            AppMethodBeat.m2505o(130511);
        }
    }
}
