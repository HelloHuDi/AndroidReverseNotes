package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener;
import com.tencent.mm.plugin.appbrand.media.record.g;
import com.tencent.mm.plugin.appbrand.media.record.g.AnonymousClass7;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.permission.n;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
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

public final class j extends com.tencent.mm.plugin.appbrand.jsapi.a<q> {
    public static final int CTRL_INDEX = 295;
    public static final String NAME = "operateRecorder";
    private static Vector<String> hzY = new Vector();
    private b hAI;
    private u hAJ;
    private com.tencent.mm.plugin.appbrand.page.a.c.a hAK;
    private c huj;

    static class b extends a {
        public int action;
        public String appId;
        private boolean cHT;
        private int duration = 0;
        public boolean error = false;
        private String filePath = "";
        private int fileSize = 0;
        private byte[] frameBuffer;
        AudioRecordVoIPInterruptListener hAN;
        private j hAO;
        public String hAP;
        private String hAQ = "";
        private String hAR;
        private int hAS;
        private final com.tencent.mm.sdk.b.c<mb> hAT = new com.tencent.mm.sdk.b.c<mb>() {
            {
                AppMethodBeat.i(130745);
                this.xxI = mb.class.getName().hashCode();
                AppMethodBeat.o(130745);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(130746);
                mb mbVar = (mb) bVar;
                ab.i("MicroMsg.Record.JsApiOperateRecorder", "mListener callback action : %d", Integer.valueOf(mbVar.cHS.action));
                if (b.this.appId.equalsIgnoreCase(mbVar.cHS.appId)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("state", mbVar.cHS.state);
                    b.this.state = mbVar.cHS.state;
                    if (mbVar.cHS.action == 2) {
                        b.this.filePath = mbVar.cHS.filePath;
                        b.this.duration = mbVar.cHS.duration;
                        b.this.fileSize = mbVar.cHS.fileSize;
                        com.tencent.mm.plugin.appbrand.media.record.c.Cx(b.this.appId);
                    }
                    if (mbVar.cHS.action == 4) {
                        hashMap.put("errCode", Integer.valueOf(mbVar.cHS.errCode));
                        Object obj = "";
                        if (!TextUtils.isEmpty(mbVar.cHS.aIm)) {
                            obj = mbVar.cHS.aIm;
                        }
                        hashMap.put("errMsg", obj);
                    }
                    if (mbVar.cHS.action == 5) {
                        int length;
                        if (mbVar.cHS.frameBuffer == null || mbVar.cHS.frameBuffer.length <= 819200) {
                            b.this.frameBuffer = mbVar.cHS.frameBuffer;
                        } else {
                            b.a(b.this, mbVar);
                        }
                        b bVar2 = b.this;
                        if (mbVar.cHS.frameBuffer != null) {
                            length = mbVar.cHS.frameBuffer.length;
                        } else {
                            length = 0;
                        }
                        bVar2.hAS = length;
                        b.this.cHT = mbVar.cHS.cHT;
                        ab.i("MicroMsg.Record.JsApiOperateRecorder", "frameBufferSize:%d", Integer.valueOf(b.this.hAS));
                    }
                    b.this.hAz = new JSONObject(hashMap).toString();
                    b.this.action = mbVar.cHS.action;
                    b.this.wM();
                    AppMethodBeat.o(130746);
                    return true;
                }
                ab.e("MicroMsg.Record.JsApiOperateRecorder", "appId is diff, don't send event");
                AppMethodBeat.o(130746);
                return false;
            }
        };
        public String hAa = "";
        public String hAz;
        c huj;
        public q hwf;
        public int hwi;
        public String processName = "";
        private String state = "";

        public b(j jVar, q qVar, int i) {
            AppMethodBeat.i(130747);
            this.hAO = jVar;
            this.hwf = qVar;
            this.hwi = i;
            com.tencent.mm.plugin.appbrand.r.j jVar2 = new com.tencent.mm.plugin.appbrand.r.j();
            if (qVar.asE().a(jVar2) == com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
                this.hAR = new File((String) jVar2.value, "frameBuffer").getAbsolutePath();
                AppMethodBeat.o(130747);
                return;
            }
            this.hAR = new File(qVar.getContext().getCacheDir(), "frameBuffer_" + qVar.getAppId()).getAbsolutePath();
            AppMethodBeat.o(130747);
        }

        /* JADX WARNING: Removed duplicated region for block: B:76:0x0279  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0176  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void Dp() {
            int i = 0;
            AppMethodBeat.i(130748);
            try {
                JSONObject jSONObject = new JSONObject(this.hAP);
                String optString = jSONObject.optString("operationType");
                if (TextUtils.isEmpty(optString)) {
                    ab.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is null");
                    this.error = true;
                    this.action = -1;
                    this.hAa = "operationType is null";
                    wM();
                    AppMethodBeat.o(130748);
                    return;
                }
                ab.i("MicroMsg.Record.JsApiOperateRecorder", "operationType;%s", optString);
                this.error = false;
                this.action = -1;
                boolean z;
                g aIm;
                if (optString.equals("start")) {
                    int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 60000);
                    int optInt2 = jSONObject.optInt("sampleRate", TXRecordCommon.AUDIO_SAMPLERATE_44100);
                    int optInt3 = jSONObject.optInt("numberOfChannels", 2);
                    int optInt4 = jSONObject.optInt("encodeBitRate", 128000);
                    String optString2 = jSONObject.optString("format");
                    double optDouble = jSONObject.optDouble("frameSize", 0.0d);
                    com.tencent.mm.plugin.appbrand.media.record.b a = com.tencent.mm.plugin.appbrand.media.record.b.a(jSONObject.optString("audioSource").toUpperCase(), com.tencent.mm.plugin.appbrand.media.record.b.MIC);
                    com.tencent.mm.plugin.appbrand.media.record.c.b(this.appId, this.hAT);
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
                    com.tencent.mm.plugin.appbrand.media.record.c.aIe();
                    g aIm2 = g.aIm();
                    ab.i("MicroMsg.Record.AudioRecordMgr", JsApiStartRecordVoice.NAME);
                    if (aIm2.ilo == null || recordParam.appId == null || recordParam.appId.equalsIgnoreCase(aIm2.ilo.appId)) {
                        if (aIm2.mIsRecording) {
                            ab.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is recording");
                        } else if (aIm2.DA()) {
                            ab.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is pause");
                        }
                        if (i == 0) {
                            ab.i("MicroMsg.Record.JsApiOperateRecorder", "star record ok");
                            this.action = -1;
                        } else if (g.aIm().mIsRecording) {
                            this.error = true;
                            this.hAa = "audio is recording, don't start record again";
                        } else {
                            this.error = true;
                            this.hAa = "start record fail";
                        }
                    } else {
                        ab.e("MicroMsg.Record.AudioRecordMgr", "appId is diff, must stop record first");
                        aIm2.EB();
                    }
                    if (TextUtils.isEmpty(recordParam.hAQ) || recordParam.duration < 0 || recordParam.iml <= 0 || recordParam.sampleRate <= 0 || recordParam.imk <= 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        ab.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, param is invalid");
                        com.tencent.mm.plugin.appbrand.media.record.j.pk(15);
                    } else if (h.Cz(recordParam.hAQ)) {
                        if (TextUtils.isEmpty(recordParam.euD)) {
                            recordParam.euD = System.currentTimeMillis();
                        }
                        com.tencent.mm.plugin.appbrand.media.record.j.aIt();
                        ab.i("MicroMsg.Record.RecordParamCompatibility", "recordParam duration:%d, numberOfChannels:%d, sampleRate:%d, encodeBitRate:%d", Integer.valueOf(recordParam.duration), Integer.valueOf(recordParam.imk), Integer.valueOf(recordParam.sampleRate), Integer.valueOf(recordParam.iml));
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
                        d.post(new AnonymousClass7(recordParam), "app_brand_start_record");
                        i = 1;
                    } else {
                        ab.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, encode format %s is not support!", recordParam.hAQ);
                        com.tencent.mm.plugin.appbrand.media.record.j.pk(16);
                    }
                    if (i == 0) {
                    }
                } else if (optString.equals("resume")) {
                    aIm = g.aIm();
                    if (aIm.mIsRecording) {
                        ab.e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, is recording");
                    } else if (aIm.ilo == null) {
                        ab.e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, mRecordParam is null");
                    } else {
                        com.tencent.mm.plugin.appbrand.media.record.j.aIt();
                        d.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(105610);
                                synchronized (g.this.iln) {
                                    try {
                                        g.h(g.this);
                                    } finally {
                                        while (true) {
                                        }
                                        AppMethodBeat.o(105610);
                                    }
                                }
                            }
                        }, "app_brand_resume_record");
                        i = 1;
                    }
                    if (i != 0) {
                        this.action = -1;
                        ab.i("MicroMsg.Record.JsApiOperateRecorder", "resume record ok");
                    } else if (g.aIm().mIsRecording) {
                        this.error = true;
                        this.hAa = "audio is recording, don't resume record again";
                    } else {
                        this.error = true;
                        this.hAa = "resume record fail";
                    }
                } else if (optString.equals("pause")) {
                    int i2;
                    aIm = g.aIm();
                    ab.i("MicroMsg.Record.AudioRecordMgr", "pauseRecord");
                    if (aIm.ilm == null) {
                        ab.e("MicroMsg.Record.AudioRecordMgr", "mRecord is null");
                        i2 = 0;
                    } else if (aIm.DA()) {
                        ab.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
                        z = true;
                    } else {
                        d.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(105611);
                                synchronized (g.this.iln) {
                                    try {
                                        g.this.aIo();
                                    } finally {
                                        while (true) {
                                        }
                                        AppMethodBeat.o(105611);
                                    }
                                }
                            }
                        }, "app_brand_pause_record");
                        z = true;
                    }
                    if (i2 != 0) {
                        this.action = -1;
                        ab.i("MicroMsg.Record.JsApiOperateRecorder", "pause record ok");
                    } else if (g.aIm().DA()) {
                        this.error = true;
                        this.hAa = "audio is pause, don't pause record again";
                    } else {
                        this.error = true;
                        this.hAa = "pause record fail";
                    }
                } else if (!optString.equals("stop")) {
                    ab.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is invalid");
                    this.error = true;
                    this.hAa = "operationType is invalid";
                } else if (g.aIm().EB()) {
                    this.action = -1;
                    ab.i("MicroMsg.Record.JsApiOperateRecorder", "stop record ok");
                } else if (g.aIm().DB()) {
                    this.error = true;
                    this.hAa = "audio is stop, don't stop record again";
                } else {
                    this.error = true;
                    this.hAa = "stop record fail";
                }
                if (this.error) {
                    ab.e("MicroMsg.Record.JsApiOperateRecorder", this.hAa);
                }
                wM();
                AppMethodBeat.o(130748);
            } catch (JSONException e) {
                ab.e("MicroMsg.Record.JsApiOperateRecorder", "new json exists exception, data is invalid, dataStr:%s", this.hAP);
                this.error = true;
                this.action = -1;
                this.hAa = "parser data fail, data is invalid";
                ab.e("MicroMsg.Record.JsApiOperateRecorder", "exception:%s" + e.getMessage());
                wM();
                AppMethodBeat.o(130748);
            }
        }

        public final void wM() {
            AppMethodBeat.i(130749);
            super.wM();
            if (this.hwf == null) {
                ab.e("MicroMsg.Record.JsApiOperateRecorder", "service is null, don't callback");
                AppMethodBeat.o(130749);
            } else if (this.action != -1) {
                a aVar = new a();
                switch (this.action) {
                    case 0:
                    case 1:
                        j.a(this.hAO, true);
                        if (!j.hzY.contains(this.appId)) {
                            com.tencent.mm.plugin.appbrand.g.a(this.appId, this.huj);
                            j.hzY.add(this.appId);
                            break;
                        }
                        break;
                    case 2:
                    case 3:
                    case 4:
                        j.a(this.hAO, false);
                        if (this.action == 2 || this.action == 4) {
                            com.tencent.mm.plugin.appbrand.g.b(this.appId, this.huj);
                            j.hzY.remove(this.appId);
                            break;
                        }
                }
                if (this.action == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("state", this.state);
                    ab.i("MicroMsg.Record.JsApiOperateRecorder", "filePath:%s, encodeFormat:%s", this.filePath, this.hAQ);
                    com.tencent.mm.plugin.appbrand.r.j jVar = new com.tencent.mm.plugin.appbrand.r.j();
                    if (this.hwf.asE().a(new File(this.filePath), h.Cy(this.hAQ), true, jVar) == com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
                        hashMap.put("tempFilePath", jVar.value);
                    } else {
                        ab.e("MicroMsg.Record.JsApiOperateRecorder", "AppBrandLocalMediaObject obj is null");
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
                        hashMap2.put("frameBuffer", com.tencent.mm.plugin.appbrand.s.q.al(this.frameBuffer));
                    } else {
                        ab.e("MicroMsg.Record.JsApiOperateRecorder", "framBuffer is null, error");
                    }
                    com.tencent.mm.plugin.appbrand.s.q.b a = com.tencent.mm.plugin.appbrand.s.q.a(this.hwf.aBx(), hashMap2, (com.tencent.mm.plugin.appbrand.s.q.a) this.hwf.aa(com.tencent.mm.plugin.appbrand.s.q.a.class));
                    if (a == com.tencent.mm.plugin.appbrand.s.q.b.OK) {
                        this.hAz = new JSONObject(hashMap2).toString();
                    } else if (a == com.tencent.mm.plugin.appbrand.s.q.b.FAIL_SIZE_EXCEED_LIMIT) {
                        com.tencent.mm.plugin.appbrand.s.q.m(this.hwf, "onRecorderStateChange");
                        AppMethodBeat.o(130749);
                        return;
                    }
                }
                ab.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", Integer.valueOf(this.action), this.hAz);
                aVar.i(this.hwf).AL(this.hAz).aCj();
                AppMethodBeat.o(130749);
            } else if (this.error) {
                ab.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder fail:%s", this.hAa);
                this.hwf.M(this.hwi, this.hAO.j("fail:" + this.hAa, null));
                AppMethodBeat.o(130749);
            } else {
                ab.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder ok");
                this.hwf.M(this.hwi, this.hAO.j("ok", null));
                AppMethodBeat.o(130749);
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
            AppMethodBeat.i(130750);
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
                                ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e2, "", new Object[0]);
                            }
                            if (file.exists()) {
                                file.delete();
                            } else {
                                ab.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                            }
                        } catch (FileNotFoundException e3) {
                            e = e3;
                            try {
                                ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
                                if (fileInputStream != null) {
                                }
                                if (file == null) {
                                }
                                ab.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                ab.d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                                AppMethodBeat.o(130750);
                            } catch (Throwable th) {
                                e = th;
                                if (fileInputStream != null) {
                                }
                                if (file == null) {
                                }
                                ab.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                AppMethodBeat.o(130750);
                                throw e;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
                            if (fileInputStream != null) {
                            }
                            if (file == null) {
                            }
                            ab.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                            ab.d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                            AppMethodBeat.o(130750);
                        }
                        ab.d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                        AppMethodBeat.o(130750);
                    }
                    ab.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, return");
                    if (file.exists()) {
                        file.delete();
                        AppMethodBeat.o(130750);
                        return;
                    }
                    ab.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                    AppMethodBeat.o(130750);
                } catch (FileNotFoundException e5) {
                    e = e5;
                    fileInputStream = null;
                    ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
                    if (fileInputStream != null) {
                    }
                    if (file == null) {
                    }
                    ab.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                    ab.d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                    AppMethodBeat.o(130750);
                } catch (IOException e6) {
                    e = e6;
                    fileInputStream = null;
                    ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
                    if (fileInputStream != null) {
                    }
                    if (file == null) {
                    }
                    ab.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                    ab.d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                    AppMethodBeat.o(130750);
                } catch (Throwable th2) {
                    e = th2;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                    }
                    if (file == null) {
                    }
                    ab.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                    AppMethodBeat.o(130750);
                    throw e;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                fileInputStream = null;
                file = null;
                ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e22) {
                        ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e22, "", new Object[0]);
                    }
                }
                if (file == null && file.exists()) {
                    file.delete();
                } else {
                    ab.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                }
                ab.d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                AppMethodBeat.o(130750);
            } catch (IOException e8) {
                e = e8;
                fileInputStream = null;
                file = null;
                ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e222) {
                        ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e222, "", new Object[0]);
                    }
                }
                if (file == null && file.exists()) {
                    file.delete();
                } else {
                    ab.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                }
                ab.d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                AppMethodBeat.o(130750);
            } catch (Throwable th3) {
                e = th3;
                fileInputStream = null;
                file = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e9) {
                        ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e9, "", new Object[0]);
                    }
                }
                if (file == null && file.exists()) {
                    file.delete();
                } else {
                    ab.e("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                }
                AppMethodBeat.o(130750);
                throw e;
            }
        }
    }

    public static final class a extends p {
        private static final int CTRL_INDEX = 296;
        private static final String NAME = "onRecorderStateChange";
    }

    static {
        AppMethodBeat.i(130755);
        AppMethodBeat.o(130755);
    }

    public final void a(final q qVar, final JSONObject jSONObject, final int i) {
        boolean z;
        AppMethodBeat.i(130752);
        n.a(qVar.getAppId(), new android.support.v4.app.a.a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                AppMethodBeat.i(130744);
                if (i != 116) {
                    AppMethodBeat.o(130744);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    ab.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, SYS_PERM_DENIED");
                    qVar.M(i, j.this.j("fail:system permission denied", null));
                    AppMethodBeat.o(130744);
                } else {
                    ab.i("MicroMsg.Record.JsApiOperateRecorder", "PERMISSION_GRANTED, do invoke again");
                    j.this.a(qVar, jSONObject, i);
                    AppMethodBeat.o(130744);
                }
            }
        });
        Activity activity = qVar.getContext() instanceof Activity ? (Activity) qVar.getContext() : null;
        if (activity == null) {
            ab.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, pageContext is null");
            qVar.M(i, j("fail", null));
            z = false;
        } else {
            z = com.tencent.mm.pluginsdk.permission.b.a(activity, "android.permission.RECORD_AUDIO", 116, "", "");
            if (z) {
                n.Dr(qVar.getAppId());
            }
        }
        if (z) {
            com.tencent.mm.plugin.appbrand.page.q asV = qVar.getRuntime().asV();
            if (asV.getCurrentPage() == null || asV.getCurrentPage().getCurrentPageView() == null) {
                qVar.M(i, j("fail", null));
                AppMethodBeat.o(130752);
                return;
            }
            this.hAJ = asV.getCurrentPage().getCurrentPageView();
            if (jSONObject == null) {
                ab.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, data is null");
                qVar.M(i, j("fail:data is null", null));
                AppMethodBeat.o(130752);
                return;
            }
            final String appId = qVar.getAppId();
            ab.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder appId:%s, data:%s", appId, jSONObject.toString());
            if (this.hAI == null) {
                this.hAI = new b(this, qVar, i);
            }
            this.hAI.hwi = i;
            this.hAI.appId = appId;
            this.hAI.hAP = jSONObject.toString();
            this.hAI.processName = ah.getProcessName();
            if (this.huj == null) {
                this.huj = new c() {
                    public final void a(com.tencent.mm.plugin.appbrand.g.d dVar) {
                        AppMethodBeat.i(130741);
                        ab.i("MicroMsg.Record.JsApiOperateRecorder", "onPause, appId:%s", appId);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("operationType", "pause");
                        } catch (JSONException e) {
                            ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
                        }
                        if (j.this.hAI == null) {
                            j.this.hAI = new b(j.this, qVar, i);
                        }
                        j.this.hAI.hAP = jSONObject.toString();
                        j.this.hAI.appId = appId;
                        j.this.hAI.action = -1;
                        j.this.hAI.aCr();
                        AppMethodBeat.o(130741);
                    }

                    public final void onDestroy() {
                        AppMethodBeat.i(130742);
                        ab.i("MicroMsg.Record.JsApiOperateRecorder", "onDestroy, appId:%s", appId);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("operationType", "stop");
                        } catch (JSONException e) {
                            ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e, "", new Object[0]);
                        }
                        if (j.this.hAI == null) {
                            j.this.hAI = new b(j.this, qVar, i);
                        }
                        j.this.hAI.hAP = jSONObject.toString();
                        j.this.hAI.appId = appId;
                        j.this.hAI.action = -1;
                        j.this.hAI.aCs();
                        com.tencent.mm.plugin.appbrand.g.b(appId, this);
                        j.hzY.remove(appId);
                        AppMethodBeat.o(130742);
                    }
                };
            }
            this.hAI.huj = this.huj;
            this.hAI.aCr();
            AppMethodBeat.o(130752);
            return;
        }
        ab.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, requestPermission fail");
        qVar.M(i, j("fail:system permission denied", null));
        AppMethodBeat.o(130752);
    }
}
