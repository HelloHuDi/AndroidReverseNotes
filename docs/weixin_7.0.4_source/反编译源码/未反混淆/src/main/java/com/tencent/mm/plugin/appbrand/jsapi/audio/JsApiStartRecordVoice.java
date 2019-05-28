package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.a.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiStartRecordVoice extends a<q> {
    public static final int CTRL_INDEX = 31;
    public static final String NAME = "startRecord";
    static volatile String hBi = null;
    private u hAJ;
    private c.a hAK;
    private StartRecordVoice hBj;

    static class StartRecordVoice extends MainProcessTask {
        public static final Creator<StartRecordVoice> CREATOR = new Creator<StartRecordVoice>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartRecordVoice[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130790);
                StartRecordVoice startRecordVoice = new StartRecordVoice(parcel);
                AppMethodBeat.o(130790);
                return startRecordVoice;
            }
        };
        private String appId;
        private int duration;
        private String filePath;
        private JsApiStartRecordVoice hBl;
        private boolean hBm = false;
        private q hwf;
        private int hwi;
        private int result;

        static /* synthetic */ boolean b(StartRecordVoice startRecordVoice) {
            AppMethodBeat.i(130797);
            boolean aCb = startRecordVoice.aCb();
            AppMethodBeat.o(130797);
            return aCb;
        }

        static /* synthetic */ boolean e(StartRecordVoice startRecordVoice) {
            AppMethodBeat.i(130798);
            boolean aCb = startRecordVoice.aCb();
            AppMethodBeat.o(130798);
            return aCb;
        }

        StartRecordVoice(JsApiStartRecordVoice jsApiStartRecordVoice, q qVar, int i, int i2) {
            AppMethodBeat.i(130791);
            this.hBl = jsApiStartRecordVoice;
            this.hwf = qVar;
            this.duration = i;
            this.hwi = i2;
            this.appId = qVar.getAppId();
            String uY = com.tencent.mm.modelvoice.u.uY(this.appId);
            j jVar = new j();
            if (qVar.asE().a(jVar) == com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
                this.filePath = new File((String) jVar.value, uY).getAbsolutePath();
                AppMethodBeat.o(130791);
                return;
            }
            this.filePath = new File(qVar.getContext().getCacheDir(), uY).getAbsolutePath();
            AppMethodBeat.o(130791);
        }

        StartRecordVoice(Parcel parcel) {
            AppMethodBeat.i(130792);
            g(parcel);
            AppMethodBeat.o(130792);
        }

        public final void asP() {
            AppMethodBeat.i(130793);
            e.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(130789);
                    StartRecordVoice.this.hBm = com.tencent.mm.plugin.appbrand.media.record.a.a(StartRecordVoice.this.filePath, new com.tencent.mm.plugin.appbrand.media.record.a.a() {
                        public final void ob(int i) {
                            AppMethodBeat.i(130788);
                            StartRecordVoice.this.result = i;
                            StartRecordVoice.b(StartRecordVoice.this);
                            AppMethodBeat.o(130788);
                        }
                    }, StartRecordVoice.this.duration * 1000);
                    if (!StartRecordVoice.this.hBm) {
                        StartRecordVoice.e(StartRecordVoice.this);
                    }
                    AppMethodBeat.o(130789);
                }
            });
            AppMethodBeat.o(130793);
        }

        public final void asQ() {
            AppMethodBeat.i(130794);
            if (this.result == -1) {
                ab.e("MicroMsg.JsApiStartRecordVoice", "fail:record_error");
                this.hwf.M(this.hwi, this.hBl.j("fail:record_error", null));
                AppMethodBeat.o(130794);
                return;
            }
            if (this.hBm) {
                HashMap hashMap = new HashMap(1);
                j jVar = new j();
                if (this.hwf.asE().a(new File(this.filePath), "silk", true, jVar) == com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
                    hashMap.put("tempFilePath", jVar.value);
                    this.hwf.M(this.hwi, this.hBl.j("ok", hashMap));
                    ab.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", this.appId, Boolean.valueOf(this.hBm));
                    JsApiStartRecordVoice.a(this.hBl, false);
                    AppMethodBeat.o(130794);
                }
                ab.e("MicroMsg.JsApiStartRecordVoice", "AppBrandLocalMediaObject obj is null");
                hashMap.put("tempFilePath", "");
            }
            this.hwf.M(this.hwi, this.hBl.j("fail", null));
            ab.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", this.appId, Boolean.valueOf(this.hBm));
            JsApiStartRecordVoice.a(this.hBl, false);
            AppMethodBeat.o(130794);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(130795);
            this.hwi = parcel.readInt();
            this.appId = parcel.readString();
            this.filePath = parcel.readString();
            this.hBm = parcel.readByte() != (byte) 0;
            this.duration = parcel.readInt();
            this.result = parcel.readInt();
            AppMethodBeat.o(130795);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130796);
            parcel.writeInt(this.hwi);
            parcel.writeString(this.appId);
            parcel.writeString(this.filePath);
            parcel.writeByte(this.hBm ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.duration);
            parcel.writeInt(this.result);
            AppMethodBeat.o(130796);
        }

        static {
            AppMethodBeat.i(130799);
            AppMethodBeat.o(130799);
        }
    }

    static /* synthetic */ void a(JsApiStartRecordVoice jsApiStartRecordVoice, boolean z) {
        AppMethodBeat.i(130803);
        jsApiStartRecordVoice.dU(z);
        AppMethodBeat.o(130803);
    }

    private void dU(final boolean z) {
        AppMethodBeat.i(130801);
        if (this.hAJ == null) {
            AppMethodBeat.o(130801);
        } else if (!al.isMainThread()) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(130786);
                    JsApiStartRecordVoice.a(JsApiStartRecordVoice.this, z);
                    AppMethodBeat.o(130786);
                }
            });
            AppMethodBeat.o(130801);
        } else if (z) {
            this.hAK = com.tencent.mm.plugin.appbrand.page.a.z(this.hAJ.getRuntime()).a(com.tencent.mm.plugin.appbrand.page.a.a.VOICE);
            n.xb(this.hAJ.getAppId()).gPf = this.hAK;
            AppMethodBeat.o(130801);
        } else {
            if (this.hAK != null) {
                this.hAK.dismiss();
                this.hAK = null;
            }
            AppMethodBeat.o(130801);
        }
    }

    public final void a(final q qVar, final JSONObject jSONObject, final int i) {
        boolean z;
        AppMethodBeat.i(130800);
        com.tencent.mm.plugin.appbrand.permission.n.a(qVar.getAppId(), new android.support.v4.app.a.a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                AppMethodBeat.i(130787);
                if (i != 116) {
                    AppMethodBeat.o(130787);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    qVar.M(i, JsApiStartRecordVoice.this.j("fail:system permission denied", null));
                    AppMethodBeat.o(130787);
                } else {
                    JsApiStartRecordVoice.this.a(qVar, jSONObject, i);
                    AppMethodBeat.o(130787);
                }
            }
        });
        Activity activity = qVar.getContext() instanceof Activity ? (Activity) qVar.getContext() : null;
        if (activity == null) {
            qVar.M(i, j("fail", null));
            z = false;
        } else {
            z = b.a(activity, "android.permission.RECORD_AUDIO", 116, "", "");
            if (z) {
                com.tencent.mm.plugin.appbrand.permission.n.Dr(qVar.getAppId());
            }
        }
        if (z) {
            com.tencent.mm.plugin.appbrand.page.q asV = qVar.getRuntime().asV();
            if (asV.getCurrentPage() == null || asV.getCurrentPage().getCurrentPageView() == null) {
                qVar.M(i, j("fail", null));
                AppMethodBeat.o(130800);
                return;
            } else if (hBi != null) {
                qVar.M(i, j("fail:audio is recording, don't start record again", null));
                AppMethodBeat.o(130800);
                return;
            } else {
                this.hAJ = asV.getCurrentPage().getCurrentPageView();
                int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 60);
                if (optInt <= 0) {
                    ab.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, less than 0");
                    optInt = 60;
                }
                if (optInt > 600) {
                    ab.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, more than %d", Integer.valueOf(600));
                    optInt = 600;
                }
                this.hAJ.a((f.b) new f.b() {
                    public final void wW() {
                        AppMethodBeat.i(130784);
                        JsApiStopRecordVoice.g(qVar);
                        JsApiStartRecordVoice.this.hAJ.b((f.b) this);
                        AppMethodBeat.o(130784);
                    }
                });
                this.hAJ.a((f.c) new f.c() {
                    public final void onDestroy() {
                        AppMethodBeat.i(130785);
                        JsApiStopRecordVoice.g(qVar);
                        JsApiStartRecordVoice.this.hAJ.b((f.c) this);
                        AppMethodBeat.o(130785);
                    }
                });
                this.hBj = new StartRecordVoice(this, qVar, optInt, i);
                hBi = this.hBj.filePath;
                AppBrandMainProcessService.a(this.hBj);
                dU(true);
                AppMethodBeat.o(130800);
                return;
            }
        }
        qVar.M(i, j("fail", null));
        AppMethodBeat.o(130800);
    }
}
