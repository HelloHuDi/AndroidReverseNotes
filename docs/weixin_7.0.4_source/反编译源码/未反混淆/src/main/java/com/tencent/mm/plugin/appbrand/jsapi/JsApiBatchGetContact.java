package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiBatchGetContact extends a<q> {
    public static final int CTRL_INDEX = 410;
    public static final String NAME = "batchGetContact";

    static class JsApiBatchGetContactTask extends MainProcessTask {
        public static final Creator<JsApiBatchGetContactTask> CREATOR = new Creator<JsApiBatchGetContactTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new JsApiBatchGetContactTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130394);
                JsApiBatchGetContactTask jsApiBatchGetContactTask = new JsApiBatchGetContactTask(parcel);
                AppMethodBeat.o(130394);
                return jsApiBatchGetContactTask;
            }
        };
        private String aIm;
        private String hwA;
        private q hwf;
        private int hwi;
        public ArrayList<String> hwy;
        private m hwz;

        static /* synthetic */ boolean a(JsApiBatchGetContactTask jsApiBatchGetContactTask) {
            AppMethodBeat.i(130400);
            boolean aCb = jsApiBatchGetContactTask.aCb();
            AppMethodBeat.o(130400);
            return aCb;
        }

        static /* synthetic */ boolean b(JsApiBatchGetContactTask jsApiBatchGetContactTask) {
            AppMethodBeat.i(130401);
            boolean aCb = jsApiBatchGetContactTask.aCb();
            AppMethodBeat.o(130401);
            return aCb;
        }

        static /* synthetic */ boolean c(JsApiBatchGetContactTask jsApiBatchGetContactTask) {
            AppMethodBeat.i(130402);
            boolean aCb = jsApiBatchGetContactTask.aCb();
            AppMethodBeat.o(130402);
            return aCb;
        }

        static /* synthetic */ boolean d(JsApiBatchGetContactTask jsApiBatchGetContactTask) {
            AppMethodBeat.i(130403);
            boolean aCb = jsApiBatchGetContactTask.aCb();
            AppMethodBeat.o(130403);
            return aCb;
        }

        public JsApiBatchGetContactTask(m mVar, q qVar, int i, ArrayList<String> arrayList) {
            this.hwz = mVar;
            this.hwf = qVar;
            this.hwi = i;
            this.hwy = arrayList;
        }

        public JsApiBatchGetContactTask(Parcel parcel) {
            AppMethodBeat.i(130395);
            g(parcel);
            AppMethodBeat.o(130395);
        }

        public final void asQ() {
            AppMethodBeat.i(130396);
            if (bo.isNullOrNil(this.hwA)) {
                this.hwf.M(this.hwi, this.hwz.j(this.aIm, null));
            } else {
                this.hwf.M(this.hwi, this.hwA);
            }
            aBW();
            AppMethodBeat.o(130396);
        }

        public final void asP() {
            AppMethodBeat.i(130397);
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(130393);
                    final boolean[] zArr = new boolean[]{false};
                    final Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        public final void run() {
                            AppMethodBeat.i(130392);
                            synchronized (JsApiBatchGetContact.class) {
                                try {
                                    if (zArr[0]) {
                                        ab.i("MicroMsg.JsApiBatchGetContact", "isCallBacked");
                                    } else {
                                        zArr[0] = true;
                                        ab.w("MicroMsg.JsApiBatchGetContact", "get contact timeout");
                                        JsApiBatchGetContactTask.this.aIm = "fail:get contact timeout";
                                        JsApiBatchGetContactTask.a(JsApiBatchGetContactTask.this);
                                    }
                                } finally {
                                    AppMethodBeat.o(130392);
                                }
                            }
                            cancel();
                            timer.cancel();
                        }
                    }, 60000);
                    try {
                        ArrayList arrayList = new ArrayList();
                        JSONArray jSONArray = new JSONArray();
                        Iterator it = JsApiBatchGetContactTask.this.hwy.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            Pair aa = r.aa(str, false);
                            if (aa.second == null) {
                                arrayList.add(str);
                            }
                            synchronized (JsApiBatchGetContact.class) {
                                if (zArr[0]) {
                                    timer.cancel();
                                    AppMethodBeat.o(130393);
                                    return;
                                } else if (aa.first == null || bo.isNullOrNil(((WxaAttributes) aa.first).field_appInfo)) {
                                    zArr[0] = true;
                                    JsApiBatchGetContactTask.this.aIm = "fail:get contact fail";
                                    ab.w("MicroMsg.JsApiBatchGetContact", "get contact fail");
                                    JsApiBatchGetContactTask.b(JsApiBatchGetContactTask.this);
                                    timer.cancel();
                                    AppMethodBeat.o(130393);
                                    return;
                                } else {
                                    JSONObject optJSONObject = new JSONObject(((WxaAttributes) aa.first).field_appInfo).optJSONObject("PluginInfo");
                                    if (optJSONObject == null) {
                                        optJSONObject = new JSONObject();
                                    }
                                    optJSONObject.put("appId", str);
                                    jSONArray.put(optJSONObject);
                                }
                            }
                        }
                        if (!bo.ek(arrayList)) {
                            ab.i("MicroMsg.JsApiBatchGetContact", "needUpdateList size %d", Integer.valueOf(arrayList.size()));
                            if (!bo.ek(arrayList)) {
                                d.post(new com.tencent.mm.plugin.appbrand.config.r.AnonymousClass2(arrayList), "WxaAttrSync");
                            }
                        }
                        synchronized (JsApiBatchGetContact.class) {
                            if (zArr[0]) {
                                timer.cancel();
                                AppMethodBeat.o(130393);
                                return;
                            }
                            zArr[0] = true;
                            ab.i("MicroMsg.JsApiBatchGetContact", "try to stop timer");
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("errMsg", "batchGetContact:ok");
                            jSONObject.put("contactList", jSONArray);
                            JsApiBatchGetContactTask.this.hwA = jSONObject.toString();
                            JsApiBatchGetContactTask.c(JsApiBatchGetContactTask.this);
                            timer.cancel();
                            AppMethodBeat.o(130393);
                        }
                    } catch (JSONException e) {
                        try {
                            ab.printErrStackTrace("MicroMsg.JsApiBatchGetContact", e, "", new Object[0]);
                            JsApiBatchGetContactTask.this.aIm = "fail:" + e.getMessage();
                            JsApiBatchGetContactTask.d(JsApiBatchGetContactTask.this);
                            timer.cancel();
                            AppMethodBeat.o(130393);
                        } catch (Throwable th) {
                            timer.cancel();
                            AppMethodBeat.o(130393);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        AppMethodBeat.o(130393);
                        throw th2;
                    }
                }
            }, "AppBrandJsApiBatchGetContact");
            AppMethodBeat.o(130397);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(130398);
            this.hwy = parcel.readArrayList(getClass().getClassLoader());
            this.hwA = parcel.readString();
            this.aIm = parcel.readString();
            AppMethodBeat.o(130398);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130399);
            parcel.writeList(this.hwy);
            parcel.writeString(this.hwA);
            parcel.writeString(this.aIm);
            AppMethodBeat.o(130399);
        }

        static {
            AppMethodBeat.i(130404);
            AppMethodBeat.o(130404);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130405);
        q qVar = (q) cVar;
        ab.i("MicroMsg.JsApiBatchGetContact", NAME);
        if (jSONObject == null) {
            qVar.M(i, j("fail:data is null or nil", null));
            AppMethodBeat.o(130405);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("appIds");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            ab.w("MicroMsg.JsApiBatchGetContact", "appIds is empty");
            qVar.M(i, j("fail:appIds is empty", null));
            AppMethodBeat.o(130405);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            arrayList.add(optJSONArray.optString(i2));
        }
        MainProcessTask jsApiBatchGetContactTask = new JsApiBatchGetContactTask(this, qVar, i, arrayList);
        jsApiBatchGetContactTask.aBV();
        AppBrandMainProcessService.a(jsApiBatchGetContactTask);
        AppMethodBeat.o(130405);
    }
}
