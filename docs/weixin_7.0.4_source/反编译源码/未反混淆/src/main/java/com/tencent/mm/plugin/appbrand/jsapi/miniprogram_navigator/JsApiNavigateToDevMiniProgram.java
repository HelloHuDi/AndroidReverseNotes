package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.launching.l;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class JsApiNavigateToDevMiniProgram extends a {
    private static final int CTRL_INDEX = 351;
    private static final String NAME = "navigateToDevMiniProgram";

    static final class DevPkgInfo implements Parcelable {
        public static final Creator<DevPkgInfo> CREATOR = new Creator<DevPkgInfo>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DevPkgInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131338);
                DevPkgInfo devPkgInfo = new DevPkgInfo(parcel);
                AppMethodBeat.o(131338);
                return devPkgInfo;
            }
        };
        String appId;
        String cOj;
        String cOk;
        String hQT;

        DevPkgInfo() {
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131339);
            parcel.writeString(this.appId);
            parcel.writeString(this.cOj);
            parcel.writeString(this.cOk);
            parcel.writeString(this.hQT);
            AppMethodBeat.o(131339);
        }

        DevPkgInfo(Parcel parcel) {
            AppMethodBeat.i(131340);
            this.appId = parcel.readString();
            this.cOj = parcel.readString();
            this.cOk = parcel.readString();
            this.hQT = parcel.readString();
            AppMethodBeat.o(131340);
        }

        static {
            AppMethodBeat.i(131341);
            AppMethodBeat.o(131341);
        }
    }

    static final class a implements i<DevPkgInfo, IPCVoid> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(131342);
            DevPkgInfo devPkgInfo = (DevPkgInfo) obj;
            ((l) ((b) e.B(b.class)).E(l.class)).n(devPkgInfo.appId, 1, devPkgInfo.hQT);
            if (((b) e.B(b.class)).xF().a(devPkgInfo.appId, 1, devPkgInfo.cOj, devPkgInfo.cOk, 0, bo.anT() + 7200)) {
                h.bt(devPkgInfo.appId, 1);
            }
            IPCVoid iPCVoid = IPCVoid.eGH;
            AppMethodBeat.o(131342);
            return iPCVoid;
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131343);
        final d dVar = (d) cVar;
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("downloadURL");
        String optString3 = jSONObject.optString("checkSumMd5");
        b a = b.a(jSONObject.optString("envVersion"), b.DEVELOP);
        String optString4 = jSONObject.optString("relativeURL");
        JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
        String optString5 = jSONObject.optString("extoptions");
        if (bo.isNullOrNil(optString)) {
            dVar.M(i, j("fail:appID is empty", null));
            AppMethodBeat.o(131343);
        } else if (b.DEVELOP == a && (bo.isNullOrNil(optString2) || bo.isNullOrNil(optString3))) {
            dVar.M(i, j("fail invalid downloadURL & checkSumMd5", null));
            AppMethodBeat.o(131343);
        } else {
            if (b.DEVELOP == a) {
                DevPkgInfo devPkgInfo = new DevPkgInfo();
                devPkgInfo.appId = optString;
                devPkgInfo.cOj = optString2;
                devPkgInfo.cOk = optString3;
                devPkgInfo.hQT = optString5;
                f.a(ah.getPackageName(), devPkgInfo, a.class);
            }
            k.hRd.a(dVar, optString, a.har, optString4, null, optJSONObject, null, new c.c() {
                public final void dY(boolean z) {
                    String str;
                    AppMethodBeat.i(131337);
                    d dVar = dVar;
                    int i = i;
                    JsApiNavigateToDevMiniProgram jsApiNavigateToDevMiniProgram = JsApiNavigateToDevMiniProgram.this;
                    if (z) {
                        str = "ok";
                    } else {
                        str = "fail";
                    }
                    dVar.M(i, jsApiNavigateToDevMiniProgram.j(str, null));
                    AppMethodBeat.o(131337);
                }
            });
            AppMethodBeat.o(131343);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final c aDv() {
        return k.hRd;
    }
}
