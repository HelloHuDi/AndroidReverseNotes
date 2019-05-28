package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.p057v4.app.C6184a.C0315a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoice.C18719u;
import com.tencent.p177mm.plugin.appbrand.C38450n;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.media.record.C27199a;
import com.tencent.p177mm.plugin.appbrand.media.record.C27199a.C27197a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.page.C38456a;
import com.tencent.p177mm.plugin.appbrand.page.C38456a.C2403a;
import com.tencent.p177mm.plugin.appbrand.page.C38470q;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.page.p327a.C42642c.C2405a;
import com.tencent.p177mm.plugin.appbrand.permission.C19663n;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice */
public final class JsApiStartRecordVoice extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 31;
    public static final String NAME = "startRecord";
    static volatile String hBi = null;
    private C44709u hAJ;
    private C2405a hAK;
    private StartRecordVoice hBj;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice$StartRecordVoice */
    static class StartRecordVoice extends MainProcessTask {
        public static final Creator<StartRecordVoice> CREATOR = new C22222();
        private String appId;
        private int duration;
        private String filePath;
        private JsApiStartRecordVoice hBl;
        private boolean hBm = false;
        private C38492q hwf;
        private int hwi;
        private int result;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice$StartRecordVoice$2 */
        static class C22222 implements Creator<StartRecordVoice> {
            C22222() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartRecordVoice[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130790);
                StartRecordVoice startRecordVoice = new StartRecordVoice(parcel);
                AppMethodBeat.m2505o(130790);
                return startRecordVoice;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice$StartRecordVoice$1 */
        class C312981 implements Runnable {

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice$StartRecordVoice$1$1 */
            class C312991 implements C27197a {
                C312991() {
                }

                /* renamed from: ob */
                public final void mo44863ob(int i) {
                    AppMethodBeat.m2504i(130788);
                    StartRecordVoice.this.result = i;
                    StartRecordVoice.m50547b(StartRecordVoice.this);
                    AppMethodBeat.m2505o(130788);
                }
            }

            C312981() {
            }

            public final void run() {
                AppMethodBeat.m2504i(130789);
                StartRecordVoice.this.hBm = C27199a.m43217a(StartRecordVoice.this.filePath, new C312991(), StartRecordVoice.this.duration * 1000);
                if (!StartRecordVoice.this.hBm) {
                    StartRecordVoice.m50550e(StartRecordVoice.this);
                }
                AppMethodBeat.m2505o(130789);
            }
        }

        /* renamed from: b */
        static /* synthetic */ boolean m50547b(StartRecordVoice startRecordVoice) {
            AppMethodBeat.m2504i(130797);
            boolean aCb = startRecordVoice.aCb();
            AppMethodBeat.m2505o(130797);
            return aCb;
        }

        /* renamed from: e */
        static /* synthetic */ boolean m50550e(StartRecordVoice startRecordVoice) {
            AppMethodBeat.m2504i(130798);
            boolean aCb = startRecordVoice.aCb();
            AppMethodBeat.m2505o(130798);
            return aCb;
        }

        StartRecordVoice(JsApiStartRecordVoice jsApiStartRecordVoice, C38492q c38492q, int i, int i2) {
            AppMethodBeat.m2504i(130791);
            this.hBl = jsApiStartRecordVoice;
            this.hwf = c38492q;
            this.duration = i;
            this.hwi = i2;
            this.appId = c38492q.getAppId();
            String uY = C18719u.m29275uY(this.appId);
            C19681j c19681j = new C19681j();
            if (c38492q.asE().mo5833a(c19681j) == C45518j.OK) {
                this.filePath = new File((String) c19681j.value, uY).getAbsolutePath();
                AppMethodBeat.m2505o(130791);
                return;
            }
            this.filePath = new File(c38492q.getContext().getCacheDir(), uY).getAbsolutePath();
            AppMethodBeat.m2505o(130791);
        }

        StartRecordVoice(Parcel parcel) {
            AppMethodBeat.m2504i(130792);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130792);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130793);
            C42677e.aNS().mo10302aa(new C312981());
            AppMethodBeat.m2505o(130793);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130794);
            if (this.result == -1) {
                C4990ab.m7412e("MicroMsg.JsApiStartRecordVoice", "fail:record_error");
                this.hwf.mo6107M(this.hwi, this.hBl.mo73394j("fail:record_error", null));
                AppMethodBeat.m2505o(130794);
                return;
            }
            if (this.hBm) {
                HashMap hashMap = new HashMap(1);
                C19681j c19681j = new C19681j();
                if (this.hwf.asE().mo5835a(new File(this.filePath), "silk", true, c19681j) == C45518j.OK) {
                    hashMap.put("tempFilePath", c19681j.value);
                    this.hwf.mo6107M(this.hwi, this.hBl.mo73394j("ok", hashMap));
                    C4990ab.m7417i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", this.appId, Boolean.valueOf(this.hBm));
                    JsApiStartRecordVoice.m64749a(this.hBl, false);
                    AppMethodBeat.m2505o(130794);
                }
                C4990ab.m7412e("MicroMsg.JsApiStartRecordVoice", "AppBrandLocalMediaObject obj is null");
                hashMap.put("tempFilePath", "");
            }
            this.hwf.mo6107M(this.hwi, this.hBl.mo73394j("fail", null));
            C4990ab.m7417i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", this.appId, Boolean.valueOf(this.hBm));
            JsApiStartRecordVoice.m64749a(this.hBl, false);
            AppMethodBeat.m2505o(130794);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(130795);
            this.hwi = parcel.readInt();
            this.appId = parcel.readString();
            this.filePath = parcel.readString();
            this.hBm = parcel.readByte() != (byte) 0;
            this.duration = parcel.readInt();
            this.result = parcel.readInt();
            AppMethodBeat.m2505o(130795);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130796);
            parcel.writeInt(this.hwi);
            parcel.writeString(this.appId);
            parcel.writeString(this.filePath);
            parcel.writeByte(this.hBm ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.duration);
            parcel.writeInt(this.result);
            AppMethodBeat.m2505o(130796);
        }

        static {
            AppMethodBeat.m2504i(130799);
            AppMethodBeat.m2505o(130799);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m64749a(JsApiStartRecordVoice jsApiStartRecordVoice, boolean z) {
        AppMethodBeat.m2504i(130803);
        jsApiStartRecordVoice.m64750dU(z);
        AppMethodBeat.m2505o(130803);
    }

    /* renamed from: dU */
    private void m64750dU(final boolean z) {
        AppMethodBeat.m2504i(130801);
        if (this.hAJ == null) {
            AppMethodBeat.m2505o(130801);
        } else if (!C5004al.isMainThread()) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(130786);
                    JsApiStartRecordVoice.m64749a(JsApiStartRecordVoice.this, z);
                    AppMethodBeat.m2505o(130786);
                }
            });
            AppMethodBeat.m2505o(130801);
        } else if (z) {
            this.hAK = C38456a.m65057z(this.hAJ.getRuntime()).mo61145a(C2403a.VOICE);
            C38450n.m65049xb(this.hAJ.getAppId()).gPf = this.hAK;
            AppMethodBeat.m2505o(130801);
        } else {
            if (this.hAK != null) {
                this.hAK.dismiss();
                this.hAK = null;
            }
            AppMethodBeat.m2505o(130801);
        }
    }

    /* renamed from: a */
    public final void mo60989a(final C38492q c38492q, final JSONObject jSONObject, final int i) {
        boolean z;
        AppMethodBeat.m2504i(130800);
        C19663n.m30462a(c38492q.getAppId(), new C0315a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                AppMethodBeat.m2504i(130787);
                if (i != 116) {
                    AppMethodBeat.m2505o(130787);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    c38492q.mo6107M(i, JsApiStartRecordVoice.this.mo73394j("fail:system permission denied", null));
                    AppMethodBeat.m2505o(130787);
                } else {
                    JsApiStartRecordVoice.this.mo60989a(c38492q, jSONObject, i);
                    AppMethodBeat.m2505o(130787);
                }
            }
        });
        Activity activity = c38492q.getContext() instanceof Activity ? (Activity) c38492q.getContext() : null;
        if (activity == null) {
            c38492q.mo6107M(i, mo73394j("fail", null));
            z = false;
        } else {
            z = C35805b.m58707a(activity, "android.permission.RECORD_AUDIO", 116, "", "");
            if (z) {
                C19663n.m30460Dr(c38492q.getAppId());
            }
        }
        if (z) {
            C38470q asV = c38492q.getRuntime().asV();
            if (asV.getCurrentPage() == null || asV.getCurrentPage().getCurrentPageView() == null) {
                c38492q.mo6107M(i, mo73394j("fail", null));
                AppMethodBeat.m2505o(130800);
                return;
            } else if (hBi != null) {
                c38492q.mo6107M(i, mo73394j("fail:audio is recording, don't start record again", null));
                AppMethodBeat.m2505o(130800);
                return;
            } else {
                this.hAJ = asV.getCurrentPage().getCurrentPageView();
                int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 60);
                if (optInt <= 0) {
                    C4990ab.m7412e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, less than 0");
                    optInt = 60;
                }
                if (optInt > 600) {
                    C4990ab.m7413e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, more than %d", Integer.valueOf(600));
                    optInt = 600;
                }
                this.hAJ.mo53827a((C10379b) new C10379b() {
                    /* renamed from: wW */
                    public final void mo21857wW() {
                        AppMethodBeat.m2504i(130784);
                        JsApiStopRecordVoice.m54383g(c38492q);
                        JsApiStartRecordVoice.this.hAJ.mo53832b((C10379b) this);
                        AppMethodBeat.m2505o(130784);
                    }
                });
                this.hAJ.mo53828a((C10380c) new C10380c() {
                    public final void onDestroy() {
                        AppMethodBeat.m2504i(130785);
                        JsApiStopRecordVoice.m54383g(c38492q);
                        JsApiStartRecordVoice.this.hAJ.mo53833b((C10380c) this);
                        AppMethodBeat.m2505o(130785);
                    }
                });
                this.hBj = new StartRecordVoice(this, c38492q, optInt, i);
                hBi = this.hBj.filePath;
                AppBrandMainProcessService.m54349a(this.hBj);
                m64750dU(true);
                AppMethodBeat.m2505o(130800);
                return;
            }
        }
        c38492q.mo6107M(i, mo73394j("fail", null));
        AppMethodBeat.m2505o(130800);
    }
}
