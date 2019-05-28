package com.tencent.worddetect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WordDetectNative {
    private static final String TAG = "WordDetectNative";
    private int handleId = -1;

    public static class WordDetectDetailResult {
        public float chn_rate;
        public float eng_rate;
        public int height;
        public byte[] rawData;
        public int width;
    }

    public static class ConfigParam {
        public String detect_model_bin;
        public String detect_model_param;
    }

    private native int GetDetailResult(WordDetectDetailResult wordDetectDetailResult, int i);

    private native int GetResult(int i);

    private static native String GetVersion();

    private native int Init(ConfigParam configParam);

    private native int Release(int i);

    private native int ScanImage(byte[] bArr, int i, int i2, int i3, int i4);

    static {
        AppMethodBeat.i(108298);
        System.loadLibrary("wechatWordDetectMod");
        AppMethodBeat.o(108298);
    }

    public static String getVersion() {
        AppMethodBeat.i(108292);
        String GetVersion = GetVersion();
        AppMethodBeat.o(108292);
        return GetVersion;
    }

    public int init(ConfigParam configParam) {
        AppMethodBeat.i(108293);
        if (this.handleId < 0) {
            this.handleId = Init(configParam);
        }
        if (this.handleId < 0) {
            AppMethodBeat.o(108293);
            return -1;
        }
        AppMethodBeat.o(108293);
        return 0;
    }

    public int scanImage(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.i(108294);
        int ScanImage = ScanImage(bArr, i, i2, i3, this.handleId);
        AppMethodBeat.o(108294);
        return ScanImage;
    }

    public int release() {
        AppMethodBeat.i(108295);
        int Release = Release(this.handleId);
        this.handleId = -1;
        AppMethodBeat.o(108295);
        return Release;
    }

    public int getResult() {
        AppMethodBeat.i(108296);
        int GetResult = GetResult(this.handleId);
        AppMethodBeat.o(108296);
        return GetResult;
    }

    public int getDetailResult(WordDetectDetailResult wordDetectDetailResult) {
        AppMethodBeat.i(108297);
        int GetDetailResult = GetDetailResult(wordDetectDetailResult, this.handleId);
        AppMethodBeat.o(108297);
        return GetDetailResult;
    }
}
