package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsimple.C6681h;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode */
public final class JsApiScanCode extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 148;
    public static final String NAME = "scanCode";
    private static volatile boolean hyh = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode$GetA8KeyTask */
    public static class GetA8KeyTask extends MainProcessTask {
        public static final Creator<GetA8KeyTask> CREATOR = new C166192();
        public int actionCode;
        public int cvn;
        public int cvo;
        public String hyL;
        public String hyM;
        public Runnable hyN;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode$GetA8KeyTask$2 */
        static class C166192 implements Creator<GetA8KeyTask> {
            C166192() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetA8KeyTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130558);
                GetA8KeyTask getA8KeyTask = new GetA8KeyTask();
                getA8KeyTask.mo6032g(parcel);
                AppMethodBeat.m2505o(130558);
                return getA8KeyTask;
            }
        }

        /* renamed from: a */
        static /* synthetic */ boolean m25556a(GetA8KeyTask getA8KeyTask) {
            AppMethodBeat.m2504i(130563);
            boolean aCb = getA8KeyTask.aCb();
            AppMethodBeat.m2505o(130563);
            return aCb;
        }

        /* renamed from: b */
        static /* synthetic */ boolean m25557b(GetA8KeyTask getA8KeyTask) {
            AppMethodBeat.m2504i(130564);
            boolean aCb = getA8KeyTask.aCb();
            AppMethodBeat.m2505o(130564);
            return aCb;
        }

        public final void asP() {
            AppMethodBeat.m2504i(130559);
            final C6681h c6681h = new C6681h(this.hyL, 36, this.cvn, this.cvo, null, (int) System.currentTimeMillis(), new byte[0]);
            C1226w.m2655a(c6681h.ehh, new C1224a() {
                /* renamed from: a */
                public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                    AppMethodBeat.m2504i(130557);
                    if (i == 0 && i2 == 0) {
                        GetA8KeyTask.this.actionCode = c6681h.aiV();
                        switch (GetA8KeyTask.this.actionCode) {
                            case 26:
                                GetA8KeyTask.this.hyM = c6681h.aiT();
                                break;
                            default:
                                GetA8KeyTask.this.hyM = "";
                                break;
                        }
                        GetA8KeyTask.m25557b(GetA8KeyTask.this);
                        AppMethodBeat.m2505o(130557);
                    } else {
                        GetA8KeyTask.this.actionCode = -1;
                        GetA8KeyTask.m25556a(GetA8KeyTask.this);
                        AppMethodBeat.m2505o(130557);
                    }
                    return 0;
                }
            }, true);
            AppMethodBeat.m2505o(130559);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130560);
            if (this.hyN != null) {
                this.hyN.run();
            }
            AppMethodBeat.m2505o(130560);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130561);
            parcel.writeString(this.hyL);
            parcel.writeInt(this.actionCode);
            parcel.writeString(this.hyM);
            parcel.writeInt(this.cvn);
            parcel.writeInt(this.cvo);
            AppMethodBeat.m2505o(130561);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(130562);
            this.hyL = parcel.readString();
            this.actionCode = parcel.readInt();
            this.hyM = parcel.readString();
            this.cvn = parcel.readInt();
            this.cvo = parcel.readInt();
            AppMethodBeat.m2505o(130562);
        }

        static {
            AppMethodBeat.m2504i(130565);
            AppMethodBeat.m2505o(130565);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(130566);
        final C19722s c19722s = (C19722s) c2241c;
        if (hyh) {
            c19722s.mo6107M(i, mo73394j("cancel", null));
            AppMethodBeat.m2505o(130566);
            return;
        }
        hyh = true;
        Context context = (MMActivity) c19722s.mo61197ad(MMActivity.class);
        if (context == null) {
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(130566);
            return;
        }
        context.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(130556);
                JsApiScanCode.hyh = false;
                if (i != (JsApiScanCode.this.hashCode() & CdnLogic.kBizGeneric)) {
                    AppMethodBeat.m2505o(130556);
                    return;
                }
                switch (i2) {
                    case -1:
                        int intExtra;
                        int intExtra2;
                        Object obj = "";
                        Object encodeToString = Base64.encodeToString(new byte[0], 2);
                        if (intent != null) {
                            obj = intent.getStringExtra("key_scan_result");
                            byte[] byteArrayExtra = intent.getByteArrayExtra("key_scan_result_raw");
                            if (byteArrayExtra != null) {
                                encodeToString = Base64.encodeToString(byteArrayExtra, 2);
                            }
                            intent.getIntExtra("key_scan_result_type", 0);
                            intExtra = intent.getIntExtra("key_scan_result_code_type", 0);
                            intExtra2 = intent.getIntExtra("key_scan_result_code_version", 0);
                        } else {
                            intExtra2 = 0;
                            intExtra = 0;
                        }
                        final HashMap hashMap = new HashMap();
                        hashMap.put("charSet", ProtocolPackage.ServerEncoding);
                        hashMap.put("rawData", encodeToString);
                        if (intExtra == 19 || intExtra == 22) {
                            hashMap.put("result", intExtra == 22 ? "" : obj);
                            hashMap.put("scanType", intExtra == 22 ? "WX_CODE" : "QR_CODE");
                            final MainProcessTask getA8KeyTask = new GetA8KeyTask();
                            getA8KeyTask.hyL = obj;
                            getA8KeyTask.cvn = intExtra;
                            getA8KeyTask.cvo = intExtra2;
                            getA8KeyTask.hyN = new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(130555);
                                    getA8KeyTask.aBW();
                                    if (getA8KeyTask.actionCode == 26) {
                                        Uri parse = Uri.parse(getA8KeyTask.hyM);
                                        if (c19722s.getRuntime().atI().username.equals(parse.getQueryParameter("username"))) {
                                            hashMap.put("path", URLDecoder.decode(C5046bo.nullAsNil(parse.getQueryParameter("path"))));
                                        }
                                    }
                                    c19722s.mo6107M(i, JsApiScanCode.this.mo73394j("ok", hashMap));
                                    AppMethodBeat.m2505o(130555);
                                }
                            };
                            getA8KeyTask.aBV();
                            AppBrandMainProcessService.m54349a(getA8KeyTask);
                            AppMethodBeat.m2505o(130556);
                            return;
                        }
                        String[] split = obj.split(",");
                        String str = "result";
                        if (split.length > 1) {
                            obj = split[1];
                        }
                        hashMap.put(str, obj);
                        hashMap.put("scanType", split.length > 1 ? split[0] : "");
                        c19722s.mo6107M(i, JsApiScanCode.this.mo73394j("ok", hashMap));
                        AppMethodBeat.m2505o(130556);
                        return;
                    case 0:
                        c19722s.mo6107M(i, JsApiScanCode.this.mo73394j("cancel", null));
                        AppMethodBeat.m2505o(130556);
                        return;
                    default:
                        c19722s.mo6107M(i, JsApiScanCode.this.mo73394j("fail", null));
                        AppMethodBeat.m2505o(130556);
                        return;
                }
            }
        };
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 1);
        intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
        intent.putExtra("key_is_finish_on_scanned", true);
        intent.putExtra("key_is_hide_right_btn", jSONObject.optBoolean("onlyFromCamera", false));
        JSONArray optJSONArray = jSONObject.optJSONArray("scanType");
        HashSet<Integer> hashSet = new HashSet();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            hashSet.add(Integer.valueOf(2));
            hashSet.add(Integer.valueOf(4));
            hashSet.add(Integer.valueOf(5));
            hashSet.add(Integer.valueOf(3));
            hashSet.add(Integer.valueOf(1));
            int[] iArr = new int[hashSet.size()];
            int i2 = 0;
            for (Integer intValue : hashSet) {
                int i3 = i2 + 1;
                iArr[i2] = intValue.intValue();
                i2 = i3;
            }
            intent.putExtra("key_support_scan_code_type", iArr);
        }
        C25985d.m41453a(context, "scanner", ".ui.SingleTopScanUI", intent, hashCode() & CdnLogic.kBizGeneric, false);
        AppMethodBeat.m2505o(130566);
    }
}
