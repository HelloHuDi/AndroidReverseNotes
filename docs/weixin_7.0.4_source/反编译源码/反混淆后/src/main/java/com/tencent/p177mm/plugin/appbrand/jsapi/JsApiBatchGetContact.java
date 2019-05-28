package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.config.C42406r;
import com.tencent.p177mm.plugin.appbrand.config.C42406r.C191602;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact */
public class JsApiBatchGetContact extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 410;
    public static final String NAME = "batchGetContact";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact$JsApiBatchGetContactTask */
    static class JsApiBatchGetContactTask extends MainProcessTask {
        public static final Creator<JsApiBatchGetContactTask> CREATOR = new C192602();
        private String aIm;
        private String hwA;
        private C38492q hwf;
        private int hwi;
        public ArrayList<String> hwy;
        private C45608m hwz;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact$JsApiBatchGetContactTask$1 */
        class C192581 implements Runnable {
            C192581() {
            }

            public final void run() {
                AppMethodBeat.m2504i(130393);
                final boolean[] zArr = new boolean[]{false};
                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public final void run() {
                        AppMethodBeat.m2504i(130392);
                        synchronized (JsApiBatchGetContact.class) {
                            try {
                                if (zArr[0]) {
                                    C4990ab.m7416i("MicroMsg.JsApiBatchGetContact", "isCallBacked");
                                } else {
                                    zArr[0] = true;
                                    C4990ab.m7420w("MicroMsg.JsApiBatchGetContact", "get contact timeout");
                                    JsApiBatchGetContactTask.this.aIm = "fail:get contact timeout";
                                    JsApiBatchGetContactTask.m29906a(JsApiBatchGetContactTask.this);
                                }
                            } finally {
                                AppMethodBeat.m2505o(130392);
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
                        Pair aa = C42406r.m75074aa(str, false);
                        if (aa.second == null) {
                            arrayList.add(str);
                        }
                        synchronized (JsApiBatchGetContact.class) {
                            if (zArr[0]) {
                                timer.cancel();
                                AppMethodBeat.m2505o(130393);
                                return;
                            } else if (aa.first == null || C5046bo.isNullOrNil(((WxaAttributes) aa.first).field_appInfo)) {
                                zArr[0] = true;
                                JsApiBatchGetContactTask.this.aIm = "fail:get contact fail";
                                C4990ab.m7420w("MicroMsg.JsApiBatchGetContact", "get contact fail");
                                JsApiBatchGetContactTask.m29908b(JsApiBatchGetContactTask.this);
                                timer.cancel();
                                AppMethodBeat.m2505o(130393);
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
                    if (!C5046bo.m7548ek(arrayList)) {
                        C4990ab.m7417i("MicroMsg.JsApiBatchGetContact", "needUpdateList size %d", Integer.valueOf(arrayList.size()));
                        if (!C5046bo.m7548ek(arrayList)) {
                            C7305d.post(new C191602(arrayList), "WxaAttrSync");
                        }
                    }
                    synchronized (JsApiBatchGetContact.class) {
                        if (zArr[0]) {
                            timer.cancel();
                            AppMethodBeat.m2505o(130393);
                            return;
                        }
                        zArr[0] = true;
                        C4990ab.m7416i("MicroMsg.JsApiBatchGetContact", "try to stop timer");
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("errMsg", "batchGetContact:ok");
                        jSONObject.put("contactList", jSONArray);
                        JsApiBatchGetContactTask.this.hwA = jSONObject.toString();
                        JsApiBatchGetContactTask.m29909c(JsApiBatchGetContactTask.this);
                        timer.cancel();
                        AppMethodBeat.m2505o(130393);
                    }
                } catch (JSONException e) {
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.JsApiBatchGetContact", e, "", new Object[0]);
                        JsApiBatchGetContactTask.this.aIm = "fail:" + e.getMessage();
                        JsApiBatchGetContactTask.m29910d(JsApiBatchGetContactTask.this);
                        timer.cancel();
                        AppMethodBeat.m2505o(130393);
                    } catch (Throwable th) {
                        timer.cancel();
                        AppMethodBeat.m2505o(130393);
                        throw th;
                    }
                } catch (Throwable th2) {
                    AppMethodBeat.m2505o(130393);
                    throw th2;
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact$JsApiBatchGetContactTask$2 */
        static class C192602 implements Creator<JsApiBatchGetContactTask> {
            C192602() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new JsApiBatchGetContactTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130394);
                JsApiBatchGetContactTask jsApiBatchGetContactTask = new JsApiBatchGetContactTask(parcel);
                AppMethodBeat.m2505o(130394);
                return jsApiBatchGetContactTask;
            }
        }

        /* renamed from: a */
        static /* synthetic */ boolean m29906a(JsApiBatchGetContactTask jsApiBatchGetContactTask) {
            AppMethodBeat.m2504i(130400);
            boolean aCb = jsApiBatchGetContactTask.aCb();
            AppMethodBeat.m2505o(130400);
            return aCb;
        }

        /* renamed from: b */
        static /* synthetic */ boolean m29908b(JsApiBatchGetContactTask jsApiBatchGetContactTask) {
            AppMethodBeat.m2504i(130401);
            boolean aCb = jsApiBatchGetContactTask.aCb();
            AppMethodBeat.m2505o(130401);
            return aCb;
        }

        /* renamed from: c */
        static /* synthetic */ boolean m29909c(JsApiBatchGetContactTask jsApiBatchGetContactTask) {
            AppMethodBeat.m2504i(130402);
            boolean aCb = jsApiBatchGetContactTask.aCb();
            AppMethodBeat.m2505o(130402);
            return aCb;
        }

        /* renamed from: d */
        static /* synthetic */ boolean m29910d(JsApiBatchGetContactTask jsApiBatchGetContactTask) {
            AppMethodBeat.m2504i(130403);
            boolean aCb = jsApiBatchGetContactTask.aCb();
            AppMethodBeat.m2505o(130403);
            return aCb;
        }

        public JsApiBatchGetContactTask(C45608m c45608m, C38492q c38492q, int i, ArrayList<String> arrayList) {
            this.hwz = c45608m;
            this.hwf = c38492q;
            this.hwi = i;
            this.hwy = arrayList;
        }

        public JsApiBatchGetContactTask(Parcel parcel) {
            AppMethodBeat.m2504i(130395);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130395);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130396);
            if (C5046bo.isNullOrNil(this.hwA)) {
                this.hwf.mo6107M(this.hwi, this.hwz.mo73394j(this.aIm, null));
            } else {
                this.hwf.mo6107M(this.hwi, this.hwA);
            }
            aBW();
            AppMethodBeat.m2505o(130396);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130397);
            C7305d.post(new C192581(), "AppBrandJsApiBatchGetContact");
            AppMethodBeat.m2505o(130397);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(130398);
            this.hwy = parcel.readArrayList(getClass().getClassLoader());
            this.hwA = parcel.readString();
            this.aIm = parcel.readString();
            AppMethodBeat.m2505o(130398);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130399);
            parcel.writeList(this.hwy);
            parcel.writeString(this.hwA);
            parcel.writeString(this.aIm);
            AppMethodBeat.m2505o(130399);
        }

        static {
            AppMethodBeat.m2504i(130404);
            AppMethodBeat.m2505o(130404);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130405);
        C38492q c38492q = (C38492q) c2241c;
        C4990ab.m7416i("MicroMsg.JsApiBatchGetContact", NAME);
        if (jSONObject == null) {
            c38492q.mo6107M(i, mo73394j("fail:data is null or nil", null));
            AppMethodBeat.m2505o(130405);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("appIds");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            C4990ab.m7420w("MicroMsg.JsApiBatchGetContact", "appIds is empty");
            c38492q.mo6107M(i, mo73394j("fail:appIds is empty", null));
            AppMethodBeat.m2505o(130405);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            arrayList.add(optJSONArray.optString(i2));
        }
        MainProcessTask jsApiBatchGetContactTask = new JsApiBatchGetContactTask(this, c38492q, i, arrayList);
        jsApiBatchGetContactTask.aBV();
        AppBrandMainProcessService.m54349a(jsApiBatchGetContactTask);
        AppMethodBeat.m2505o(130405);
    }
}
