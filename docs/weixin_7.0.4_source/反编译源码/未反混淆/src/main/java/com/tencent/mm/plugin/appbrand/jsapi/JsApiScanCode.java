package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.bp.d;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiScanCode extends a<s> {
    public static final int CTRL_INDEX = 148;
    public static final String NAME = "scanCode";
    private static volatile boolean hyh = false;

    public static class GetA8KeyTask extends MainProcessTask {
        public static final Creator<GetA8KeyTask> CREATOR = new Creator<GetA8KeyTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetA8KeyTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130558);
                GetA8KeyTask getA8KeyTask = new GetA8KeyTask();
                getA8KeyTask.g(parcel);
                AppMethodBeat.o(130558);
                return getA8KeyTask;
            }
        };
        public int actionCode;
        public int cvn;
        public int cvo;
        public String hyL;
        public String hyM;
        public Runnable hyN;

        static /* synthetic */ boolean a(GetA8KeyTask getA8KeyTask) {
            AppMethodBeat.i(130563);
            boolean aCb = getA8KeyTask.aCb();
            AppMethodBeat.o(130563);
            return aCb;
        }

        static /* synthetic */ boolean b(GetA8KeyTask getA8KeyTask) {
            AppMethodBeat.i(130564);
            boolean aCb = getA8KeyTask.aCb();
            AppMethodBeat.o(130564);
            return aCb;
        }

        public final void asP() {
            AppMethodBeat.i(130559);
            final h hVar = new h(this.hyL, 36, this.cvn, this.cvo, null, (int) System.currentTimeMillis(), new byte[0]);
            w.a(hVar.ehh, new a() {
                public final int a(int i, int i2, String str, b bVar, m mVar) {
                    AppMethodBeat.i(130557);
                    if (i == 0 && i2 == 0) {
                        GetA8KeyTask.this.actionCode = hVar.aiV();
                        switch (GetA8KeyTask.this.actionCode) {
                            case 26:
                                GetA8KeyTask.this.hyM = hVar.aiT();
                                break;
                            default:
                                GetA8KeyTask.this.hyM = "";
                                break;
                        }
                        GetA8KeyTask.b(GetA8KeyTask.this);
                        AppMethodBeat.o(130557);
                    } else {
                        GetA8KeyTask.this.actionCode = -1;
                        GetA8KeyTask.a(GetA8KeyTask.this);
                        AppMethodBeat.o(130557);
                    }
                    return 0;
                }
            }, true);
            AppMethodBeat.o(130559);
        }

        public final void asQ() {
            AppMethodBeat.i(130560);
            if (this.hyN != null) {
                this.hyN.run();
            }
            AppMethodBeat.o(130560);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130561);
            parcel.writeString(this.hyL);
            parcel.writeInt(this.actionCode);
            parcel.writeString(this.hyM);
            parcel.writeInt(this.cvn);
            parcel.writeInt(this.cvo);
            AppMethodBeat.o(130561);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(130562);
            this.hyL = parcel.readString();
            this.actionCode = parcel.readInt();
            this.hyM = parcel.readString();
            this.cvn = parcel.readInt();
            this.cvo = parcel.readInt();
            AppMethodBeat.o(130562);
        }

        static {
            AppMethodBeat.i(130565);
            AppMethodBeat.o(130565);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(130566);
        final s sVar = (s) cVar;
        if (hyh) {
            sVar.M(i, j("cancel", null));
            AppMethodBeat.o(130566);
            return;
        }
        hyh = true;
        Context context = (MMActivity) sVar.ad(MMActivity.class);
        if (context == null) {
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(130566);
            return;
        }
        context.ifE = new MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(130556);
                JsApiScanCode.hyh = false;
                if (i != (JsApiScanCode.this.hashCode() & CdnLogic.kBizGeneric)) {
                    AppMethodBeat.o(130556);
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
                                    AppMethodBeat.i(130555);
                                    getA8KeyTask.aBW();
                                    if (getA8KeyTask.actionCode == 26) {
                                        Uri parse = Uri.parse(getA8KeyTask.hyM);
                                        if (sVar.getRuntime().atI().username.equals(parse.getQueryParameter("username"))) {
                                            hashMap.put("path", URLDecoder.decode(bo.nullAsNil(parse.getQueryParameter("path"))));
                                        }
                                    }
                                    sVar.M(i, JsApiScanCode.this.j("ok", hashMap));
                                    AppMethodBeat.o(130555);
                                }
                            };
                            getA8KeyTask.aBV();
                            AppBrandMainProcessService.a(getA8KeyTask);
                            AppMethodBeat.o(130556);
                            return;
                        }
                        String[] split = obj.split(",");
                        String str = "result";
                        if (split.length > 1) {
                            obj = split[1];
                        }
                        hashMap.put(str, obj);
                        hashMap.put("scanType", split.length > 1 ? split[0] : "");
                        sVar.M(i, JsApiScanCode.this.j("ok", hashMap));
                        AppMethodBeat.o(130556);
                        return;
                    case 0:
                        sVar.M(i, JsApiScanCode.this.j("cancel", null));
                        AppMethodBeat.o(130556);
                        return;
                    default:
                        sVar.M(i, JsApiScanCode.this.j("fail", null));
                        AppMethodBeat.o(130556);
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
        d.a(context, "scanner", ".ui.SingleTopScanUI", intent, hashCode() & CdnLogic.kBizGeneric, false);
        AppMethodBeat.o(130566);
    }
}
