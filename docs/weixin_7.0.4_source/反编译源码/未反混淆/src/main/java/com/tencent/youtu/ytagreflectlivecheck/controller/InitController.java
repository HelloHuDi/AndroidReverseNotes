package com.tencent.youtu.ytagreflectlivecheck.controller;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ColorSeqRes;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.RGBConfigRequestCallBack;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.YTColorSeqReq;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import com.tencent.youtu.ytcommon.tools.wejson.WeJsonException;

public class InitController {
    private static int GET_RGBCONFIG_FAILED = 0;
    private static int RGBCONFIG_GET_COLLORSEQREQ_FAILED = 2;
    private static int RGBCONFIG_GET_RGBCONFIG_NULL = 3;
    private static int RGBCONFIG_RETURN_NULL = 1;
    private static int RGBCONFIG_YOUTU_SERVER_RETURNCODE_NOT_0 = 4;
    private static final String TAG = "YoutuLightLiveCheck";

    class ColorSeqReqInner {
        public String app_id;
        public String build_brand = Build.BRAND;
        public String build_device = Build.DEVICE;
        public String build_display = Build.DISPLAY;
        public String build_hardware = Build.HARDWARE;
        public String build_id = Build.ID;
        public String build_model = Build.MODEL;
        public String build_product = Build.PRODUCT;
        public String build_serial = Build.SERIAL;
        public String build_test = null;
        public String business_name;
        public String person_id;
        public int platform;

        public ColorSeqReqInner(YTColorSeqReq yTColorSeqReq) {
            this.app_id = yTColorSeqReq.app_id;
            this.business_name = yTColorSeqReq.business_name;
            this.person_id = yTColorSeqReq.person_id;
            this.platform = 2;
        }
    }

    public void start(RGBConfigRequester rGBConfigRequester, final ProcessResult processResult) {
        AppMethodBeat.i(123149);
        YTColorSeqReq colorSeqReq = rGBConfigRequester.getColorSeqReq();
        if (colorSeqReq == null) {
            processResult.onFailed(RGBCONFIG_GET_COLLORSEQREQ_FAILED, "get colorSeqReq failed.", "Check \"rgbConfigRequester.getColorSeqReq()\" return value. Is that null?");
            AppMethodBeat.o(123149);
            return;
        }
        rGBConfigRequester.request(new WeJson().toJson(new ColorSeqReqInner(colorSeqReq)), new RGBConfigRequestCallBack() {
            public void onSuccess(String str) {
                AppMethodBeat.i(123147);
                if (str != null) {
                    if (str != null) {
                        try {
                            if (!str.equals("")) {
                                if (YTCommonExInterface.getBusinessCode() == 1) {
                                    ProcessManager.dataWorker().mRgbConfigCode = str;
                                    processResult.onSuccess();
                                    AppMethodBeat.o(123147);
                                    return;
                                }
                                ColorSeqRes colorSeqRes = (ColorSeqRes) new WeJson().fromJson(str, ColorSeqRes.class);
                                if (colorSeqRes.error_code == 0) {
                                    ProcessManager.dataWorker().mRgbConfigCode = colorSeqRes.color_data;
                                    processResult.onSuccess();
                                    AppMethodBeat.o(123147);
                                    return;
                                }
                                processResult.onFailed(InitController.RGBCONFIG_YOUTU_SERVER_RETURNCODE_NOT_0, "get rgbconfig youtu server return code not 0, current is: " + colorSeqRes.error_code, "Request rgbConfig youtu server return value not currect. Check request and response log for more details.");
                                AppMethodBeat.o(123147);
                                return;
                            }
                        } catch (WeJsonException e) {
                            processResult.onFailed(InitController.GET_RGBCONFIG_FAILED, "get rgbconfig failed.", "Check \"LightLiveCheck.setRGBConfigRequest()\" params. Or maybe net error?");
                            AppMethodBeat.o(123147);
                            return;
                        }
                    }
                    processResult.onFailed(InitController.RGBCONFIG_GET_RGBCONFIG_NULL, "get rgbconfig return string is null.", "Check \"RGBConfigRequester.RGBConfigRequestCallBack()\" return value. Is it null?");
                    AppMethodBeat.o(123147);
                    return;
                }
                processResult.onFailed(InitController.RGBCONFIG_RETURN_NULL, "get rgbconfig return null.", "Server return value not currect.");
                AppMethodBeat.o(123147);
            }

            public void onFailed(int i) {
                AppMethodBeat.i(123148);
                processResult.onFailed(InitController.GET_RGBCONFIG_FAILED, "get rgbconfig failed.", "Check \"LightLiveCheck.setRGBConfigRequest()\" params. Or maybe net error?");
                AppMethodBeat.o(123148);
            }
        });
        AppMethodBeat.o(123149);
    }
}
