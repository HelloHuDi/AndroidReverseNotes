package com.tencent.liteav.videoencoder;

import com.tencent.wxmm.v2helper;

public class TXSVideoEncoderParam {
    public boolean annexb = false;
    public boolean appendSpsPps = true;
    public boolean enableBFrame = false;
    public boolean enableBlackList = true;
    public boolean enableEGL14 = false;
    public int encoderMode = 1;
    public int encoderProfile = 1;
    public int fps = 20;
    public boolean fullIFrame = false;
    public Object glContext = null;
    public int gop = 3;
    public int height = 640;
    public boolean realTime = false;
    public boolean record = false;
    public boolean syncOutput = false;
    public int width = v2helper.VOIP_ENC_HEIGHT_LV1;
}
