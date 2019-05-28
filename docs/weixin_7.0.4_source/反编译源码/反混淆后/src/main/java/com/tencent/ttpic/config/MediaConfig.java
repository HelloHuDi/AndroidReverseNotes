package com.tencent.ttpic.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.wxmm.v2helper;

public class MediaConfig {
    public static int BPS_HIGH = 5242880;
    public static int BPS_LOW = 5242880;
    public static int BPS_MEDIUM = 5242880;
    public static int GIF_OUTPUT_TEX_HEIGHT = 720;
    public static int GIF_OUTPUT_TEX_WIDTH = 720;
    public static int GIF_OUTPUT_WATERMARK_HEIGHT = 50;
    public static int GIF_OUTPUT_WATERMARK_WIDTH = 180;
    public static float GIF_PLAY_RATE = 0.5f;
    public static long GIF_SAMPLE_TIME_MS = 200;
    public static int INTERMIDIATE_IMAGE_WIDTH_HIGH = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
    public static int INTERMIDIATE_IMAGE_WIDTH_LOW = 540;
    public static int INTERMIDIATE_IMAGE_WIDTH_MEDIUM = 720;
    public static int MS_VIDEO_FRAME_RATE = 25;
    public static final String VIDEO_AAC_FILE_POSTFIX = ".m4a";
    public static int VIDEO_FRAME_RATE = 25;
    public static int VIDEO_IMAGE_HEIGHT = 640;
    public static int VIDEO_IMAGE_WIDTH = 480;
    public static int VIDEO_OUTPUT_HEIGHT = VideoFilterUtil.IMAGE_HEIGHT;
    public static int VIDEO_OUTPUT_HEIGHT_LONG = ActUtil.HEIGHT;
    public static int VIDEO_OUTPUT_HEIGHT_SHORT = 720;
    public static int VIDEO_OUTPUT_WATERMARK_HEIGHT = 55;
    public static int VIDEO_OUTPUT_WATERMARK_WIDTH = 140;
    public static int VIDEO_OUTPUT_WIDTH = 720;

    public enum ENCODE_SIZE {
        HIGH(720, ActUtil.HEIGHT),
        MEDIUM(576, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT),
        LOW(v2helper.EMethodSetSendToNetworkOn, 768);
        
        public final int height;
        public final int width;

        static {
            AppMethodBeat.m2505o(49802);
        }

        private ENCODE_SIZE(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }

    public static int getDowngradeWidth(int i) {
        if (i <= 0) {
            return ENCODE_SIZE.HIGH.width;
        }
        if (i == ENCODE_SIZE.HIGH.width) {
            return ENCODE_SIZE.MEDIUM.width;
        }
        if (i == ENCODE_SIZE.MEDIUM.width) {
            return ENCODE_SIZE.LOW.width;
        }
        return -1;
    }
}
