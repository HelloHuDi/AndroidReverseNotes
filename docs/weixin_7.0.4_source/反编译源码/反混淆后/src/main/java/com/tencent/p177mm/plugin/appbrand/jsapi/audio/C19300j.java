package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.support.p057v4.app.C6184a.C0315a;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C37761mb;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener;
import com.tencent.p177mm.plugin.appbrand.media.record.C10626g;
import com.tencent.p177mm.plugin.appbrand.media.record.C10626g.C106289;
import com.tencent.p177mm.plugin.appbrand.media.record.C10626g.C106357;
import com.tencent.p177mm.plugin.appbrand.media.record.C10626g.C23928;
import com.tencent.p177mm.plugin.appbrand.media.record.C27202h;
import com.tencent.p177mm.plugin.appbrand.media.record.C27203j;
import com.tencent.p177mm.plugin.appbrand.media.record.C38444b;
import com.tencent.p177mm.plugin.appbrand.media.record.C45654c;
import com.tencent.p177mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q.C10730b;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q.C27296a;
import com.tencent.p177mm.plugin.appbrand.page.C38470q;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.page.p327a.C42642c.C2405a;
import com.tencent.p177mm.plugin.appbrand.permission.C19663n;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.j */
public final class C19300j extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 295;
    public static final String NAME = "operateRecorder";
    private static Vector<String> hzY = new Vector();
    private C10305b hAI;
    private C44709u hAJ;
    private C2405a hAK;
    private C33186c huj;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.j$b */
    static class C10305b extends C2223a {
        public int action;
        public String appId;
        private boolean cHT;
        private int duration = 0;
        public boolean error = false;
        private String filePath = "";
        private int fileSize = 0;
        private byte[] frameBuffer;
        AudioRecordVoIPInterruptListener hAN;
        private C19300j hAO;
        public String hAP;
        private String hAQ = "";
        private String hAR;
        private int hAS;
        private final C4884c<C37761mb> hAT = new C103061();
        public String hAa = "";
        public String hAz;
        C33186c huj;
        public C38492q hwf;
        public int hwi;
        public String processName = "";
        private String state = "";

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.j$b$1 */
        class C103061 extends C4884c<C37761mb> {
            C103061() {
                AppMethodBeat.m2504i(130745);
                this.xxI = C37761mb.class.getName().hashCode();
                AppMethodBeat.m2505o(130745);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(130746);
                C37761mb c37761mb = (C37761mb) c4883b;
                C4990ab.m7417i("MicroMsg.Record.JsApiOperateRecorder", "mListener callback action : %d", Integer.valueOf(c37761mb.cHS.action));
                if (C10305b.this.appId.equalsIgnoreCase(c37761mb.cHS.appId)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("state", c37761mb.cHS.state);
                    C10305b.this.state = c37761mb.cHS.state;
                    if (c37761mb.cHS.action == 2) {
                        C10305b.this.filePath = c37761mb.cHS.filePath;
                        C10305b.this.duration = c37761mb.cHS.duration;
                        C10305b.this.fileSize = c37761mb.cHS.fileSize;
                        C45654c.m84304Cx(C10305b.this.appId);
                    }
                    if (c37761mb.cHS.action == 4) {
                        hashMap.put("errCode", Integer.valueOf(c37761mb.cHS.errCode));
                        Object obj = "";
                        if (!TextUtils.isEmpty(c37761mb.cHS.aIm)) {
                            obj = c37761mb.cHS.aIm;
                        }
                        hashMap.put("errMsg", obj);
                    }
                    if (c37761mb.cHS.action == 5) {
                        int length;
                        if (c37761mb.cHS.frameBuffer == null || c37761mb.cHS.frameBuffer.length <= 819200) {
                            C10305b.this.frameBuffer = c37761mb.cHS.frameBuffer;
                        } else {
                            C10305b.m17974a(C10305b.this, c37761mb);
                        }
                        C10305b c10305b = C10305b.this;
                        if (c37761mb.cHS.frameBuffer != null) {
                            length = c37761mb.cHS.frameBuffer.length;
                        } else {
                            length = 0;
                        }
                        c10305b.hAS = length;
                        C10305b.this.cHT = c37761mb.cHS.cHT;
                        C4990ab.m7417i("MicroMsg.Record.JsApiOperateRecorder", "frameBufferSize:%d", Integer.valueOf(C10305b.this.hAS));
                    }
                    C10305b.this.hAz = new JSONObject(hashMap).toString();
                    C10305b.this.action = c37761mb.cHS.action;
                    C10305b.this.mo6087wM();
                    AppMethodBeat.m2505o(130746);
                    return true;
                }
                C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "appId is diff, don't send event");
                AppMethodBeat.m2505o(130746);
                return false;
            }
        }

        public C10305b(C19300j c19300j, C38492q c38492q, int i) {
            AppMethodBeat.m2504i(130747);
            this.hAO = c19300j;
            this.hwf = c38492q;
            this.hwi = i;
            C19681j c19681j = new C19681j();
            if (c38492q.asE().mo5833a(c19681j) == C45518j.OK) {
                this.hAR = new File((String) c19681j.value, "frameBuffer").getAbsolutePath();
                AppMethodBeat.m2505o(130747);
                return;
            }
            this.hAR = new File(c38492q.getContext().getCacheDir(), "frameBuffer_" + c38492q.getAppId()).getAbsolutePath();
            AppMethodBeat.m2505o(130747);
        }

        /* JADX WARNING: Removed duplicated region for block: B:76:0x0279  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0176  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: Dp */
        public final void mo21758Dp() {
            int i = 0;
            AppMethodBeat.m2504i(130748);
            try {
                JSONObject jSONObject = new JSONObject(this.hAP);
                String optString = jSONObject.optString("operationType");
                if (TextUtils.isEmpty(optString)) {
                    C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "operationType is null");
                    this.error = true;
                    this.action = -1;
                    this.hAa = "operationType is null";
                    mo6087wM();
                    AppMethodBeat.m2505o(130748);
                    return;
                }
                C4990ab.m7417i("MicroMsg.Record.JsApiOperateRecorder", "operationType;%s", optString);
                this.error = false;
                this.action = -1;
                boolean z;
                C10626g aIm;
                if (optString.equals("start")) {
                    int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 60000);
                    int optInt2 = jSONObject.optInt("sampleRate", TXRecordCommon.AUDIO_SAMPLERATE_44100);
                    int optInt3 = jSONObject.optInt("numberOfChannels", 2);
                    int optInt4 = jSONObject.optInt("encodeBitRate", 128000);
                    String optString2 = jSONObject.optString("format");
                    double optDouble = jSONObject.optDouble("frameSize", 0.0d);
                    C38444b a = C38444b.m65041a(jSONObject.optString("audioSource").toUpperCase(), C38444b.MIC);
                    C45654c.m84305b(this.appId, this.hAT);
                    RecordParam recordParam = new RecordParam();
                    recordParam.duration = optInt;
                    recordParam.sampleRate = optInt2;
                    recordParam.imk = optInt3;
                    recordParam.iml = optInt4;
                    recordParam.hAQ = optString2;
                    recordParam.scene = 8;
                    recordParam.imm = optDouble;
                    recordParam.euD = System.currentTimeMillis();
                    recordParam.processName = this.processName;
                    recordParam.appId = this.appId;
                    recordParam.imn = a;
                    if (this.hAN == null) {
                        this.hAN = new AudioRecordVoIPInterruptListener();
                    }
                    recordParam.imo = this.hAN;
                    this.hAQ = optString2;
                    C45654c.aIe();
                    C10626g aIm2 = C10626g.aIm();
                    C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", JsApiStartRecordVoice.NAME);
                    if (aIm2.ilo == null || recordParam.appId == null || recordParam.appId.equalsIgnoreCase(aIm2.ilo.appId)) {
                        if (aIm2.mIsRecording) {
                            C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is recording");
                        } else if (aIm2.mo22149DA()) {
                            C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is pause");
                        }
                        if (i == 0) {
                            C4990ab.m7416i("MicroMsg.Record.JsApiOperateRecorder", "star record ok");
                            this.action = -1;
                        } else if (C10626g.aIm().mIsRecording) {
                            this.error = true;
                            this.hAa = "audio is recording, don't start record again";
                        } else {
                            this.error = true;
                            this.hAa = "start record fail";
                        }
                    } else {
                        C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "appId is diff, must stop record first");
                        aIm2.mo22151EB();
                    }
                    if (TextUtils.isEmpty(recordParam.hAQ) || recordParam.duration < 0 || recordParam.iml <= 0 || recordParam.sampleRate <= 0 || recordParam.imk <= 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, param is invalid");
                        C27203j.m43227pk(15);
                    } else if (C27202h.m43223Cz(recordParam.hAQ)) {
                        if (TextUtils.isEmpty(recordParam.euD)) {
                            recordParam.euD = System.currentTimeMillis();
                        }
                        C27203j.aIt();
                        C4990ab.m7417i("MicroMsg.Record.RecordParamCompatibility", "recordParam duration:%d, numberOfChannels:%d, sampleRate:%d, encodeBitRate:%d", Integer.valueOf(recordParam.duration), Integer.valueOf(recordParam.imk), Integer.valueOf(recordParam.sampleRate), Integer.valueOf(recordParam.iml));
                        if (recordParam.duration <= 0) {
                            recordParam.duration = 60000;
                        } else if (recordParam.duration >= 600000) {
                            recordParam.duration = 600000;
                        }
                        if (recordParam.imk <= 0 && recordParam.imk > 2) {
                            recordParam.imk = 2;
                        }
                        if (recordParam.sampleRate > TXRecordCommon.AUDIO_SAMPLERATE_48000) {
                            recordParam.sampleRate = TXRecordCommon.AUDIO_SAMPLERATE_48000;
                        } else if (recordParam.sampleRate < TXRecordCommon.AUDIO_SAMPLERATE_8000) {
                            recordParam.sampleRate = TXRecordCommon.AUDIO_SAMPLERATE_8000;
                        }
                        if (recordParam.iml > 320000) {
                            recordParam.iml = 320000;
                        } else if (recordParam.iml < TXRecordCommon.AUDIO_SAMPLERATE_16000) {
                            recordParam.iml = TXRecordCommon.AUDIO_SAMPLERATE_16000;
                        }
                        C7305d.post(new C106357(recordParam), "app_brand_start_record");
                        i = 1;
                    } else {
                        C4990ab.m7413e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, encode format %s is not support!", recordParam.hAQ);
                        C27203j.m43227pk(16);
                    }
                    if (i == 0) {
                    }
                } else if (optString.equals("resume")) {
                    aIm = C10626g.aIm();
                    if (aIm.mIsRecording) {
                        C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, is recording");
                    } else if (aIm.ilo == null) {
                        C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, mRecordParam is null");
                    } else {
                        C27203j.aIt();
                        C7305d.post(new C23928(), "app_brand_resume_record");
                        i = 1;
                    }
                    if (i != 0) {
                        this.action = -1;
                        C4990ab.m7416i("MicroMsg.Record.JsApiOperateRecorder", "resume record ok");
                    } else if (C10626g.aIm().mIsRecording) {
                        this.error = true;
                        this.hAa = "audio is recording, don't resume record again";
                    } else {
                        this.error = true;
                        this.hAa = "resume record fail";
                    }
                } else if (optString.equals("pause")) {
                    int i2;
                    aIm = C10626g.aIm();
                    C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "pauseRecord");
                    if (aIm.ilm == null) {
                        C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "mRecord is null");
                        i2 = 0;
                    } else if (aIm.mo22149DA()) {
                        C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
                        z = true;
                    } else {
                        C7305d.post(new C106289(), "app_brand_pause_record");
                        z = true;
                    }
                    if (i2 != 0) {
                        this.action = -1;
                        C4990ab.m7416i("MicroMsg.Record.JsApiOperateRecorder", "pause record ok");
                    } else if (C10626g.aIm().mo22149DA()) {
                        this.error = true;
                        this.hAa = "audio is pause, don't pause record again";
                    } else {
                        this.error = true;
                        this.hAa = "pause record fail";
                    }
                } else if (!optString.equals("stop")) {
                    C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "operationType is invalid");
                    this.error = true;
                    this.hAa = "operationType is invalid";
                } else if (C10626g.aIm().mo22151EB()) {
                    this.action = -1;
                    C4990ab.m7416i("MicroMsg.Record.JsApiOperateRecorder", "stop record ok");
                } else if (C10626g.aIm().mo22150DB()) {
                    this.error = true;
                    this.hAa = "audio is stop, don't stop record again";
                } else {
                    this.error = true;
                    this.hAa = "stop record fail";
                }
                if (this.error) {
                    C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", this.hAa);
                }
                mo6087wM();
                AppMethodBeat.m2505o(130748);
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.Record.JsApiOperateRecorder", "new json exists exception, data is invalid, dataStr:%s", this.hAP);
                this.error = true;
                this.action = -1;
                this.hAa = "parser data fail, data is invalid";
                C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "exception:%s" + e.getMessage());
                mo6087wM();
                AppMethodBeat.m2505o(130748);
            }
        }

        /* renamed from: wM */
        public final void mo6087wM() {
            AppMethodBeat.m2504i(130749);
            super.mo6087wM();
            if (this.hwf == null) {
                C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "service is null, don't callback");
                AppMethodBeat.m2505o(130749);
            } else if (this.action != -1) {
                C19299a c19299a = new C19299a();
                switch (this.action) {
                    case 0:
                    case 1:
                        C19300j.m29973a(this.hAO, true);
                        if (!C19300j.hzY.contains(this.appId)) {
                            C33183g.m54274a(this.appId, this.huj);
                            C19300j.hzY.add(this.appId);
                            break;
                        }
                        break;
                    case 2:
                    case 3:
                    case 4:
                        C19300j.m29973a(this.hAO, false);
                        if (this.action == 2 || this.action == 4) {
                            C33183g.m54276b(this.appId, this.huj);
                            C19300j.hzY.remove(this.appId);
                            break;
                        }
                }
                if (this.action == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("state", this.state);
                    C4990ab.m7417i("MicroMsg.Record.JsApiOperateRecorder", "filePath:%s, encodeFormat:%s", this.filePath, this.hAQ);
                    C19681j c19681j = new C19681j();
                    if (this.hwf.asE().mo5835a(new File(this.filePath), C27202h.m43222Cy(this.hAQ), true, c19681j) == C45518j.OK) {
                        hashMap.put("tempFilePath", c19681j.value);
                    } else {
                        C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "AppBrandLocalMediaObject obj is null");
                        hashMap.put("tempFilePath", "");
                    }
                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.duration));
                    hashMap.put("fileSize", Integer.valueOf(this.fileSize));
                    this.hAz = new JSONObject(hashMap).toString();
                }
                if (this.action == 5) {
                    Map hashMap2 = new HashMap();
                    hashMap2.put("state", this.state);
                    hashMap2.put("isLastFrame", Boolean.valueOf(this.cHT));
                    if (this.hAS > 819200) {
                        aCw();
                    }
                    if (this.frameBuffer != null) {
                        hashMap2.put("frameBuffer", C27295q.m43335al(this.frameBuffer));
                    } else {
                        C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "framBuffer is null, error");
                    }
                    C10730b a = C27295q.m43333a(this.hwf.aBx(), hashMap2, (C27296a) this.hwf.mo5937aa(C27296a.class));
                    if (a == C10730b.OK) {
                        this.hAz = new JSONObject(hashMap2).toString();
                    } else if (a == C10730b.FAIL_SIZE_EXCEED_LIMIT) {
                        C27295q.m43336m(this.hwf, "onRecorderStateChange");
                        AppMethodBeat.m2505o(130749);
                        return;
                    }
                }
                C4990ab.m7417i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", Integer.valueOf(this.action), this.hAz);
                c19299a.mo61031i(this.hwf).mo61027AL(this.hAz).aCj();
                AppMethodBeat.m2505o(130749);
            } else if (this.error) {
                C4990ab.m7413e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder fail:%s", this.hAa);
                this.hwf.mo6107M(this.hwi, this.hAO.mo73394j("fail:" + this.hAa, null));
                AppMethodBeat.m2505o(130749);
            } else {
                C4990ab.m7416i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder ok");
                this.hwf.mo6107M(this.hwi, this.hAO.mo73394j("ok", null));
                AppMethodBeat.m2505o(130749);
            }
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:26:0x0090=Splitter:B:26:0x0090, B:40:0x00c8=Splitter:B:40:0x00c8} */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x009e A:{SYNTHETIC, Splitter:B:29:0x009e} */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00d6 A:{SYNTHETIC, Splitter:B:43:0x00d6} */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0103 A:{SYNTHETIC, Splitter:B:55:0x0103} */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x009e A:{SYNTHETIC, Splitter:B:29:0x009e} */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00a3  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00d6 A:{SYNTHETIC, Splitter:B:43:0x00d6} */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00db  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0103 A:{SYNTHETIC, Splitter:B:55:0x0103} */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0108  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void aCw() {
            Throwable e;
            AppMethodBeat.m2504i(130750);
            long nanoTime = System.nanoTime();
            File file;
            FileInputStream fileInputStream;
            try {
                file = new File(this.hAR);
                try {
                    if (file.exists()) {
                        fileInputStream = new FileInputStream(file);
                        try {
                            this.frameBuffer = new byte[this.hAS];
                            fileInputStream.read(this.frameBuffer);
                            fileInputStream.close();
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                C4990ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e2, "", new Object[0]);
                            }
                            if (file.exists()) {
                                file.delete();
                            } else {
                                C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                            }
                        } catch (FileNotFoundException e3) {
                            e = e3;
                            try {
                                C4990ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
                                if (fileInputStream != null) {
                                }
                                if (file == null) {
                                }
                                C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                C4990ab.m7411d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                                AppMethodBeat.m2505o(130750);
                            } catch (Throwable th) {
                                e = th;
                                if (fileInputStream != null) {
                                }
                                if (file == null) {
                                }
                                C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                AppMethodBeat.m2505o(130750);
                                throw e;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            C4990ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
                            if (fileInputStream != null) {
                            }
                            if (file == null) {
                            }
                            C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                            C4990ab.m7411d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                            AppMethodBeat.m2505o(130750);
                        }
                        C4990ab.m7411d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                        AppMethodBeat.m2505o(130750);
                    }
                    C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, return");
                    if (file.exists()) {
                        file.delete();
                        AppMethodBeat.m2505o(130750);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                    AppMethodBeat.m2505o(130750);
                } catch (FileNotFoundException e5) {
                    e = e5;
                    fileInputStream = null;
                    C4990ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
                    if (fileInputStream != null) {
                    }
                    if (file == null) {
                    }
                    C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                    C4990ab.m7411d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                    AppMethodBeat.m2505o(130750);
                } catch (IOException e6) {
                    e = e6;
                    fileInputStream = null;
                    C4990ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
                    if (fileInputStream != null) {
                    }
                    if (file == null) {
                    }
                    C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                    C4990ab.m7411d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                    AppMethodBeat.m2505o(130750);
                } catch (Throwable th2) {
                    e = th2;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                    }
                    if (file == null) {
                    }
                    C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                    AppMethodBeat.m2505o(130750);
                    throw e;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                fileInputStream = null;
                file = null;
                C4990ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e22) {
                        C4990ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e22, "", new Object[0]);
                    }
                }
                if (file == null && file.exists()) {
                    file.delete();
                } else {
                    C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                }
                C4990ab.m7411d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                AppMethodBeat.m2505o(130750);
            } catch (IOException e8) {
                e = e8;
                fileInputStream = null;
                file = null;
                C4990ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e222) {
                        C4990ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e222, "", new Object[0]);
                    }
                }
                if (file == null && file.exists()) {
                    file.delete();
                } else {
                    C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                }
                C4990ab.m7411d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                AppMethodBeat.m2505o(130750);
            } catch (Throwable th3) {
                e = th3;
                fileInputStream = null;
                file = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e9) {
                        C4990ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e9, "", new Object[0]);
                    }
                }
                if (file == null && file.exists()) {
                    file.delete();
                } else {
                    C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                }
                AppMethodBeat.m2505o(130750);
                throw e;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.j$a */
    public static final class C19299a extends C38369p {
        private static final int CTRL_INDEX = 296;
        private static final String NAME = "onRecorderStateChange";
    }

    static {
        AppMethodBeat.m2504i(130755);
        AppMethodBeat.m2505o(130755);
    }

    /* renamed from: a */
    public final void mo34488a(final C38492q c38492q, final JSONObject jSONObject, final int i) {
        boolean z;
        AppMethodBeat.m2504i(130752);
        C19663n.m30462a(c38492q.getAppId(), new C0315a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                AppMethodBeat.m2504i(130744);
                if (i != 116) {
                    AppMethodBeat.m2505o(130744);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, SYS_PERM_DENIED");
                    c38492q.mo6107M(i, C19300j.this.mo73394j("fail:system permission denied", null));
                    AppMethodBeat.m2505o(130744);
                } else {
                    C4990ab.m7416i("MicroMsg.Record.JsApiOperateRecorder", "PERMISSION_GRANTED, do invoke again");
                    C19300j.this.mo34488a(c38492q, jSONObject, i);
                    AppMethodBeat.m2505o(130744);
                }
            }
        });
        Activity activity = c38492q.getContext() instanceof Activity ? (Activity) c38492q.getContext() : null;
        if (activity == null) {
            C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, pageContext is null");
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
                AppMethodBeat.m2505o(130752);
                return;
            }
            this.hAJ = asV.getCurrentPage().getCurrentPageView();
            if (jSONObject == null) {
                C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, data is null");
                c38492q.mo6107M(i, mo73394j("fail:data is null", null));
                AppMethodBeat.m2505o(130752);
                return;
            }
            final String appId = c38492q.getAppId();
            C4990ab.m7417i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder appId:%s, data:%s", appId, jSONObject.toString());
            if (this.hAI == null) {
                this.hAI = new C10305b(this, c38492q, i);
            }
            this.hAI.hwi = i;
            this.hAI.appId = appId;
            this.hAI.hAP = jSONObject.toString();
            this.hAI.processName = C4996ah.getProcessName();
            if (this.huj == null) {
                this.huj = new C33186c() {
                    /* renamed from: a */
                    public final void mo6074a(C33184d c33184d) {
                        AppMethodBeat.m2504i(130741);
                        C4990ab.m7417i("MicroMsg.Record.JsApiOperateRecorder", "onPause, appId:%s", appId);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("operationType", "pause");
                        } catch (JSONException e) {
                            C4990ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
                        }
                        if (C19300j.this.hAI == null) {
                            C19300j.this.hAI = new C10305b(C19300j.this, c38492q, i);
                        }
                        C19300j.this.hAI.hAP = jSONObject.toString();
                        C19300j.this.hAI.appId = appId;
                        C19300j.this.hAI.action = -1;
                        C19300j.this.hAI.aCr();
                        AppMethodBeat.m2505o(130741);
                    }

                    public final void onDestroy() {
                        AppMethodBeat.m2504i(130742);
                        C4990ab.m7417i("MicroMsg.Record.JsApiOperateRecorder", "onDestroy, appId:%s", appId);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("operationType", "stop");
                        } catch (JSONException e) {
                            C4990ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
                        }
                        if (C19300j.this.hAI == null) {
                            C19300j.this.hAI = new C10305b(C19300j.this, c38492q, i);
                        }
                        C19300j.this.hAI.hAP = jSONObject.toString();
                        C19300j.this.hAI.appId = appId;
                        C19300j.this.hAI.action = -1;
                        C19300j.this.hAI.aCs();
                        C33183g.m54276b(appId, this);
                        C19300j.hzY.remove(appId);
                        AppMethodBeat.m2505o(130742);
                    }
                };
            }
            this.hAI.huj = this.huj;
            this.hAI.aCr();
            AppMethodBeat.m2505o(130752);
            return;
        }
        C4990ab.m7412e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, requestPermission fail");
        c38492q.mo6107M(i, mo73394j("fail:system permission denied", null));
        AppMethodBeat.m2505o(130752);
    }
}
