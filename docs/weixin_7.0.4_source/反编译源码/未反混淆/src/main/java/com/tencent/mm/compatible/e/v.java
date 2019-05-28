package com.tencent.mm.compatible.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v {
    public int etA;
    public int etB;
    public int etC;
    public int etD;
    public int etE;
    public int etF;
    public int etG;
    public int etH;
    public int etI;
    public int etJ;
    public int etK;
    public int etL;
    public int etM;
    public int etN;
    public int etO;
    public int etP;
    public int etz;

    public v() {
        AppMethodBeat.i(93014);
        reset();
        AppMethodBeat.o(93014);
    }

    public final void reset() {
        this.etz = -1;
        this.etA = -1;
        this.etB = -1;
        this.etC = -1;
        this.etD = -1;
        this.etE = -1;
        this.etF = -1;
        this.etG = -1;
        this.etH = -1;
        this.etI = -1;
        this.etJ = -1;
        this.etK = -1;
        this.etL = -1;
        this.etM = -1;
        this.etN = -1;
        this.etO = -1;
        this.etP = -1;
    }

    public final String toString() {
        AppMethodBeat.i(93015);
        String format = String.format("MMSightRecorderInfo, recorderType: %s, needRotateEachFrame: %s, enableHighResolutionRecord: %s, landscapeRecordModeEnable: %s, transcodeDecoderType: %s, mediaPlayerType : %s strategybit: %s, recorderOption: %s, useMetering: %s, transcodeEncoderType: %s, checkSendVideoBitrate: %s, cpuCrop: %s, backgroundRemux:%s, emojiPreviewSize:%s, emojiStickerSampleSize:%s, emojiUseSmallModel:%s, emojiUseGpuSegment:%s", new Object[]{Integer.valueOf(this.etz), Integer.valueOf(this.etA), Integer.valueOf(this.etB), Integer.valueOf(this.etC), Integer.valueOf(this.etD), Integer.valueOf(this.etE), Integer.valueOf(this.etF), Integer.valueOf(this.etG), Integer.valueOf(this.etH), Integer.valueOf(this.etI), Integer.valueOf(this.etJ), Integer.valueOf(this.etK), Integer.valueOf(this.etL), Integer.valueOf(this.etM), Integer.valueOf(this.etN), Integer.valueOf(this.etO), Integer.valueOf(this.etP)});
        AppMethodBeat.o(93015);
        return format;
    }
}
