package com.tencent.qqmusic.mediaplayer.codec.mp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.C33381d;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.view.C31128d;
import com.tencent.wcdb.FileUtils;

class MP3Header {
    public static final int MPEG1 = 3;
    public static final int MPEG2 = 2;
    public static final int MPEG25 = 0;
    private int[][][] bitrate;
    private int bitrate_index;
    private int framesize;
    private int layer;
    private int lsf;
    private int mode;
    private int mode_extension;
    private int padding;
    private int protection_bit;
    private int[][] samplingRate = new int[][]{new int[]{11025, 12000, TXRecordCommon.AUDIO_SAMPLERATE_8000, 0}, new int[]{0, 0, 0, 0}, new int[]{22050, 24000, TXRecordCommon.AUDIO_SAMPLERATE_16000, 0}, new int[]{TXRecordCommon.AUDIO_SAMPLERATE_44100, TXRecordCommon.AUDIO_SAMPLERATE_48000, TXRecordCommon.AUDIO_SAMPLERATE_32000, 0}};
    private int sampling_frequency;
    private int sideinfosize;
    private int verID;

    MP3Header() {
        AppMethodBeat.m2504i(128578);
        r0 = new int[2][][];
        r0[0] = new int[][]{new int[]{0, 32, 64, 96, 128, 160, C33250az.CTRL_INDEX, 224, 256, C31128d.MIC_PTU_YOUJIALI, 320, C33381d.CTRL_INDEX, 384, 416, FileUtils.S_IRWXU}, new int[]{0, 32, 48, 56, 64, 80, 96, 112, 128, 160, C33250az.CTRL_INDEX, 224, 256, 320, 384}, new int[]{0, 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, C33250az.CTRL_INDEX, 224, 256, 320}};
        r0[1] = new int[][]{new int[]{0, 32, 48, 56, 64, 80, 96, 112, 128, 144, 160, ErrorCode.NEEDDOWNLOAD_FALSE_6, C33250az.CTRL_INDEX, 224, 256}, new int[]{0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160}, new int[]{0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160}};
        this.bitrate = r0;
        AppMethodBeat.m2505o(128578);
    }

    /* Access modifiers changed, original: protected */
    public void initialize() {
        this.framesize = 0;
        this.sideinfosize = 0;
        this.layer = 0;
        this.verID = 1;
    }

    /* Access modifiers changed, original: protected */
    public void decode(int i) {
        int i2 = 17;
        this.verID = (i >> 19) & 3;
        this.layer = 4 - ((i >> 17) & 3);
        this.protection_bit = (i >> 16) & 1;
        this.bitrate_index = (i >> 12) & 15;
        this.sampling_frequency = (i >> 10) & 3;
        this.padding = (i >> 9) & 1;
        this.mode = (i >> 6) & 3;
        this.mode_extension = (i >> 4) & 3;
        this.lsf = this.verID == 3 ? 0 : 1;
        switch (this.layer) {
            case 1:
                this.framesize = this.bitrate[this.lsf][0][this.bitrate_index] * 12000;
                this.framesize /= this.samplingRate[this.verID][this.sampling_frequency];
                this.framesize += this.padding;
                this.framesize <<= 2;
                return;
            case 2:
                this.framesize = this.bitrate[this.lsf][1][this.bitrate_index] * 144000;
                this.framesize /= this.samplingRate[this.verID][this.sampling_frequency];
                this.framesize += this.padding;
                return;
            case 3:
                this.framesize = this.bitrate[this.lsf][2][this.bitrate_index] * 144000;
                this.framesize /= this.samplingRate[this.verID][this.sampling_frequency] << this.lsf;
                this.framesize += this.padding;
                if (this.verID == 3) {
                    this.sideinfosize = this.mode == 3 ? 17 : 32;
                    return;
                }
                if (this.mode == 3) {
                    i2 = 9;
                }
                this.sideinfosize = i2;
                return;
            default:
                return;
        }
    }

    public int getFrameSize() {
        return this.framesize;
    }

    public boolean isProtected() {
        return this.protection_bit == 0;
    }
}
