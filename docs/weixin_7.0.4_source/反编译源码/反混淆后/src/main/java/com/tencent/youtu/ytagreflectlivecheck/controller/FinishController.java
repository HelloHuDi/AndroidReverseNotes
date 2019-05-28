package com.tencent.youtu.ytagreflectlivecheck.controller;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult;
import com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.PersonLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester.UploadVideoResponse;
import com.tencent.youtu.ytcommon.tools.CameraSetting;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;

public class FinishController {
    private static int ERRCODE_JNI_DETECT_FAILED = 3;
    private static int ERRCODE_JSON_DECODE_FAILED = 2;
    private static int ERRCODE_NET_RETURN_PARSE_NULL = 0;
    private static int ERRCODE_UPLOAD_VIDEO_FAILED = 1;
    private static final String TAG = "YoutuLightLiveCheck";

    public void start(UploadVideoRequester uploadVideoRequester, LightLiveCheckResult lightLiveCheckResult) {
        AppMethodBeat.m2504i(123146);
        YTLogger.m50246i("mCountDownTimer", "current thread3: " + Thread.currentThread());
        long currentTimeMillis = System.currentTimeMillis();
        int rotateTag = CameraSetting.getRotateTag(ProcessManager.dataWorker().mCameraRotate);
        long currentTimeMillis2 = System.currentTimeMillis();
        rotateTag = YTAGReflectLiveCheckJNIInterface.getInstance().FRDoDetectionYuvs(false, rotateTag);
        long currentTimeMillis3 = System.currentTimeMillis();
        if (rotateTag == 0) {
            FullPack FRGetAGin = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetAGin();
            long currentTimeMillis4 = System.currentTimeMillis();
            PersonLiveReq translation = JNIUtils.translation(FRGetAGin, ProcessManager.dataWorker().mRgbConfigCode);
            long currentTimeMillis5 = System.currentTimeMillis();
            String toJson = new WeJson().toJson(translation);
            long currentTimeMillis6 = System.currentTimeMillis();
            YTLogger.m50246i("mCountDownTimer", "[FinishController.start] finish t2: " + (currentTimeMillis2 - currentTimeMillis));
            YTLogger.m50246i("mCountDownTimer", "[FinishController.start] finish t3: " + (currentTimeMillis3 - currentTimeMillis2));
            YTLogger.m50246i("mCountDownTimer", "[FinishController.start] finish t4: " + (currentTimeMillis4 - currentTimeMillis3));
            YTLogger.m50246i("mCountDownTimer", "[FinishController.start] finish t5: " + (currentTimeMillis5 - currentTimeMillis4));
            YTLogger.m50246i("mCountDownTimer", "[FinishController.start] finish t6: " + (currentTimeMillis6 - currentTimeMillis5));
            final LightLiveCheckResult lightLiveCheckResult2 = lightLiveCheckResult;
            uploadVideoRequester.request(toJson, new UploadVideoResponse() {
                public void onSuccess(String str) {
                    AppMethodBeat.m2504i(123144);
                    try {
                        LightDiffResponse lightDiffResponse = (LightDiffResponse) new WeJson().fromJson(str, LightDiffResponse.class);
                        if (lightDiffResponse == null) {
                            lightLiveCheckResult2.onFailed(FinishController.ERRCODE_NET_RETURN_PARSE_NULL, "Upload video call back decode return nil.", "received response: ".concat(String.valueOf(str)));
                            AppMethodBeat.m2505o(123144);
                        } else if (lightDiffResponse.getError_code() == 0) {
                            lightLiveCheckResult2.onSuccess(true, lightDiffResponse);
                            AppMethodBeat.m2505o(123144);
                        } else {
                            lightLiveCheckResult2.onSuccess(false, lightDiffResponse);
                            AppMethodBeat.m2505o(123144);
                        }
                    } catch (Exception e) {
                        YTException.report(e);
                        lightLiveCheckResult2.onFailed(FinishController.ERRCODE_JSON_DECODE_FAILED, "Upload video response json decode failed.", "received response: ".concat(String.valueOf(str)));
                        AppMethodBeat.m2505o(123144);
                    }
                }

                public void onFailed(int i, String str) {
                    AppMethodBeat.m2504i(123145);
                    lightLiveCheckResult2.onFailed(FinishController.ERRCODE_UPLOAD_VIDEO_FAILED, "Upload video failed.[" + i + "]", "Maybe net error? return code: " + i + " message: " + str);
                    AppMethodBeat.m2505o(123145);
                }
            });
            AppMethodBeat.m2505o(123146);
            return;
        }
        lightLiveCheckResult.onFailed(ERRCODE_JNI_DETECT_FAILED, "JNI return failed.[" + rotateTag + "]", "Check log for more information. code: ".concat(String.valueOf(rotateTag)));
        AppMethodBeat.m2505o(123146);
    }
}
