package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiOpenAdCanvas extends a<s> {
    public static final int CTRL_INDEX = 476;
    public static final String NAME = "openADCanvas";
    private String hxW = "";
    private JsApiOpenAdCanvasTask hxX = null;

    static class JsApiOpenAdCanvasTask extends MainProcessTask {
        public static final Creator<JsApiOpenAdCanvasTask> CREATOR = new Creator<JsApiOpenAdCanvasTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new JsApiOpenAdCanvasTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130503);
                JsApiOpenAdCanvasTask jsApiOpenAdCanvasTask = new JsApiOpenAdCanvasTask(parcel);
                AppMethodBeat.o(130503);
                return jsApiOpenAdCanvasTask;
            }
        };
        private String cFM;
        private int cHx;
        private int cHy;
        private q hwf;
        private int hwi;
        private m hwz;
        private WeakReference<Context> hxY;
        private String hxZ;
        private String hya;
        private String hyb;

        static /* synthetic */ boolean e(JsApiOpenAdCanvasTask jsApiOpenAdCanvasTask) {
            AppMethodBeat.i(130509);
            boolean aCb = jsApiOpenAdCanvasTask.aCb();
            AppMethodBeat.o(130509);
            return aCb;
        }

        public JsApiOpenAdCanvasTask(m mVar, q qVar, int i, WeakReference<Context> weakReference, String str, int i2, int i3, String str2, String str3) {
            this.hwz = mVar;
            this.hwf = qVar;
            this.hwi = i;
            this.hxY = weakReference;
            this.hxZ = str;
            this.cHx = i2;
            this.cHy = i3;
            this.cFM = str2;
            this.hya = str3;
        }

        public JsApiOpenAdCanvasTask(Parcel parcel) {
            AppMethodBeat.i(130504);
            g(parcel);
            AppMethodBeat.o(130504);
        }

        public final void asQ() {
            AppMethodBeat.i(130505);
            String str = this.hyb;
            if (this.cHx == 0) {
                Intent intent = new Intent();
                String str2 = "sns_landing_pages_xml";
                if (str == null) {
                    str = "";
                }
                intent.putExtra(str2, str);
                intent.putExtra("sns_landing_pages_pageid", bo.anl(this.hxZ));
                intent.putExtra("sns_landig_pages_from_source", 13);
                intent.putExtra("sns_landing_pages_extra", this.cFM);
                intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                intent.putExtra("sns_landing_pages_no_store", this.cHy);
                intent.putExtra("sns_landing_pages_ad_info", this.hya);
                d.b((Context) this.hxY.get(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
                this.hwf.M(this.hwi, this.hwz.j("ok", null));
            } else if (this.cHx == 1) {
                this.hwf.M(this.hwi, this.hwz.j("ok", null));
            } else {
                this.hwf.M(this.hwi, this.hwz.j("fail", null));
            }
            aBW();
            AppMethodBeat.o(130505);
        }

        public final void asP() {
            AppMethodBeat.i(130506);
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(130502);
                    lr lrVar = new lr();
                    lrVar.cHv.pageId = JsApiOpenAdCanvasTask.this.hxZ;
                    lrVar.cHv.cvq = JsApiOpenAdCanvasTask.this.cFM;
                    lrVar.cHv.cHx = JsApiOpenAdCanvasTask.this.cHx;
                    lrVar.cHv.cHy = JsApiOpenAdCanvasTask.this.cHy;
                    lrVar.cHv.cvd = 0;
                    a.xxA.m(lrVar);
                    JsApiOpenAdCanvasTask.this.hyb = lrVar.cHw.cHz;
                    JsApiOpenAdCanvasTask.e(JsApiOpenAdCanvasTask.this);
                    AppMethodBeat.o(130502);
                }
            }, "JsApiOpenAdCanvas");
            AppMethodBeat.o(130506);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(130507);
            this.hxZ = parcel.readString();
            this.cHx = parcel.readInt();
            this.cHy = parcel.readInt();
            this.cFM = parcel.readString();
            this.hya = parcel.readString();
            this.hyb = parcel.readString();
            AppMethodBeat.o(130507);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130508);
            parcel.writeString(this.hxZ);
            parcel.writeInt(this.cHx);
            parcel.writeInt(this.cHy);
            parcel.writeString(this.cFM);
            parcel.writeString(this.hya);
            parcel.writeString(this.hyb);
            AppMethodBeat.o(130508);
        }

        static {
            AppMethodBeat.i(130510);
            AppMethodBeat.o(130510);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130511);
        s sVar = (s) cVar;
        if (jSONObject == null) {
            sVar.M(i, j("fail jsondata null", null));
            AppMethodBeat.o(130511);
            return;
        }
        Object obj = sVar.getContext() instanceof MMActivity ? (MMActivity) sVar.getContext() : null;
        if (obj == null) {
            sVar.M(i, j("fail service context null", null));
            AppMethodBeat.o(130511);
            return;
        }
        try {
            this.hxW = jSONObject.getString("canvasId");
            if (bo.isNullOrNil(this.hxW) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(this.hxW)) {
                HashMap hashMap = new HashMap();
                hashMap.put("canvasId", this.hxW);
                sVar.M(i, j("fail", hashMap));
                c.pJ(0);
                AppMethodBeat.o(130511);
                return;
            }
            int i2 = jSONObject.getInt("preLoad");
            int i3 = jSONObject.getInt("noStore");
            String string = jSONObject.getString("extraData");
            String string2 = jSONObject.getString("adInfoXml");
            ab.i("MicroMsg.JsApiOpenAdCanvas", "doOpenCanvas canvasid %s,preLoad %d, noStore %d", this.hxW, Integer.valueOf(i2), Integer.valueOf(i3));
            this.hxX = new JsApiOpenAdCanvasTask(this, sVar, i, new WeakReference(obj), this.hxW, i2, i3, string, string2);
            this.hxX.aBV();
            AppBrandMainProcessService.a(this.hxX);
            c.aa(sVar.getRuntime().atI().bQe + 1000, sVar.getAppId());
            AppMethodBeat.o(130511);
        } catch (JSONException e) {
            if (this.hxX != null) {
                this.hxX.aBW();
            }
            ab.printErrStackTrace("MicroMsg.JsApiOpenAdCanvas", e, "canvasId=%s", this.hxW);
            c.pJ(1);
            sVar.M(i, j("fail parse json error", null));
            AppMethodBeat.o(130511);
        }
    }
}
