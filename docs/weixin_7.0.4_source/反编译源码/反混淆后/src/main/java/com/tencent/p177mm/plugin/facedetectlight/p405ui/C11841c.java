package com.tencent.p177mm.plugin.facedetectlight.p405ui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C41938t;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.p177mm.plugin.facedetect.p402e.C27922a;
import com.tencent.p177mm.plugin.facedetect.p402e.C27922a.C27929b;
import com.tencent.p177mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface;
import com.tencent.p177mm.plugin.facedetectlight.Utils.YTAGFaceReflectResult;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.p406a.C20669b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C7268ju;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.RGBConfigRequestCallBack;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.YTColorSeqReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester.UploadVideoResponse;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceDetectResult;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceTraceingNotice;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.facedetectlight.ui.c */
public final class C11841c {
    int hGq;
    byte[] lWX;
    String mAppId;
    Context mContext;
    int mDesiredPreviewHeight;
    int mDesiredPreviewWidth;
    public int mState;
    TextView mbZ;
    Rect mcb;
    Rect mcc;
    int mcd;
    int mce;
    FaceTraceingNotice mch;
    String mdC;
    public C20669b mdI;
    int mdQ;
    Point mdR;
    float mdS;
    float mdT;
    UploadVideoResponse mdU;
    C41938t mdw;
    FaceReflectMask mdz;

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.c$5 */
    class C118395 implements LightLiveCheckResult {
        C118395() {
        }

        public final void onSuccess(boolean z, LightDiffResponse lightDiffResponse) {
            AppMethodBeat.m2504i(794);
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", "reflect success");
            C11841c.this.mdI.bua();
            C11841c.this.mState = 2;
            C7060h.pYm.mo8378a(917, 9, 1, false);
            AppMethodBeat.m2505o(794);
        }

        public final void onFailed(int i, String str, String str2) {
            AppMethodBeat.m2504i(795);
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", "reflect failed");
            C4990ab.m7417i("MicroMsg.FaceReflectLogic", "message：%s、tips：%s，resultcode：%s", str, str2, Integer.valueOf(i));
            C7060h.pYm.mo8378a(917, 10, 1, false);
            C11841c.this.mdI.bua();
            C11841c.this.mState = 3;
            C11841c.this.mdI.mo35972u(90023, "face track failed or not stable", C4996ah.getContext().getString(C25738R.string.bjk));
            AppMethodBeat.m2505o(795);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.c$a */
    public static class C11840a {
        private static C11841c mdY = new C11841c();

        static {
            AppMethodBeat.m2504i(799);
            AppMethodBeat.m2505o(799);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.c$6 */
    class C118426 implements UploadVideoRequester {

        /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.c$6$1 */
        class C118431 implements Runnable {
            C118431() {
            }

            public final void run() {
                AppMethodBeat.m2504i(796);
                C11841c.this.mdI.bua();
                AppMethodBeat.m2505o(796);
            }
        }

        C118426() {
        }

        public final void request(String str, UploadVideoResponse uploadVideoResponse) {
            AppMethodBeat.m2504i(797);
            C4990ab.m7417i("MicroMsg.FaceReflectLogic", "start uplaod data ：%s", str);
            FaceDetectReporter.bsJ().mo54645I(6, System.currentTimeMillis());
            C5004al.m7441d(new C118431());
            if (C5046bo.isNullOrNil(str)) {
                uploadVideoResponse.onFailed(-1, "uploadString is empty");
                AppMethodBeat.m2505o(797);
                return;
            }
            C11841c c11841c = C11841c.this;
            C4990ab.m7417i("MicroMsg.FaceReflectLogic", "stopVideoRecordIfNeed, isNeedVideo: %s", Boolean.valueOf(C27922a.btw().lZc));
            if (C27922a.btw().lZc) {
                C27922a.btw().mo45817a(new C118447());
            }
            C11841c.this.mdU = uploadVideoResponse;
            c11841c = C11841c.this;
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", "saveAndUploadReflectResult");
            long yz = C5046bo.m7588yz();
            YTAGFaceReflectResult encodeString = YTAGFaceReflectForWXJNIInterface.getEncodeString(c11841c.mdC);
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", " mResult is ".concat(String.valueOf(encodeString)));
            yz = C5046bo.m7525az(yz);
            if (encodeString != null) {
                FaceDetectReporter.bsJ().mo54643G(encodeString.result, yz);
            }
            String a = C11841c.m19711a(encodeString);
            C4990ab.m7417i("MicroMsg.FaceReflectLogic", "save face result file path: %s", a);
            if (C5046bo.isNullOrNil(a)) {
                c11841c.mdI.mo35972u(90018, "system error", "");
                AppMethodBeat.m2505o(797);
                return;
            }
            c11841c.mdU.onSuccess(str);
            c11841c.mdI.mo35967Ly(a);
            AppMethodBeat.m2505o(797);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.c$7 */
    class C118447 implements C27929b {
        C118447() {
        }

        /* renamed from: Lu */
        public final void mo23665Lu(String str) {
            AppMethodBeat.m2504i(798);
            C4990ab.m7417i("MicroMsg.FaceReflectLogic", "video release done. using: %d ms. file path: %s", Long.valueOf(C5046bo.m7525az(C5046bo.m7588yz())), str);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7416i("MicroMsg.FaceReflectLogic", " video is null");
                C7060h.pYm.mo8378a(917, 20, 1, false);
                AppMethodBeat.m2505o(798);
                return;
            }
            C7060h.pYm.mo8378a(917, 19, 1, false);
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", " begin upload video ");
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", "filePath is : ".concat(String.valueOf(str)));
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", "BioID is : " + C11841c.this.mdC);
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", "AppId is : " + C11841c.this.mAppId);
            AppMethodBeat.m2505o(798);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.c$1 */
    class C118451 implements FaceTraceingNotice {
        C118451() {
        }

        public final void onTracing(int i, FaceStatus faceStatus, Rect rect, byte[] bArr, Camera camera) {
            AppMethodBeat.m2504i(788);
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", "facePreviewState：".concat(String.valueOf(faceStatus)));
            switch (i) {
                case 0:
                    C4990ab.m7416i("MicroMsg.FaceReflectLogic", "Face mState：init");
                    AppMethodBeat.m2505o(788);
                    return;
                case 1:
                    C4990ab.m7416i("MicroMsg.FaceReflectLogic", "Face mState：detecting");
                    C11841c c11841c = C11841c.this;
                    C4990ab.m7416i("MicroMsg.FaceReflectLogic", "setFaceRect（）");
                    c11841c.mcd = c11841c.mContext.getResources().getDisplayMetrics().widthPixels;
                    c11841c.mce = c11841c.mContext.getResources().getDisplayMetrics().heightPixels;
                    c11841c.mcc.left = (int) (((double) c11841c.mcd) * 0.15d);
                    c11841c.mcc.right = (int) (((double) c11841c.mcd) * 0.85d);
                    c11841c.mcc.top = (int) (((double) c11841c.mce) * 0.2d);
                    c11841c.mcc.bottom = (int) (((double) c11841c.mce) * 0.65d);
                    c11841c = C11841c.this;
                    C4990ab.m7416i("MicroMsg.FaceReflectLogic", "setFaceLiveRect（）");
                    C4990ab.m7416i("MicroMsg.FaceReflectLogic", "faceInPreviewFrame is".concat(String.valueOf(rect)));
                    if (rect != null) {
                        int i2 = c11841c.mcd;
                        int i3 = c11841c.mce;
                        int i4 = c11841c.mDesiredPreviewWidth;
                        int i5 = c11841c.mDesiredPreviewHeight;
                        c11841c.mdS = ((float) i2) / ((float) i5);
                        c11841c.mdT = ((float) i3) / ((float) i4);
                        c11841c.mcb.left = (int) (((float) rect.left) * c11841c.mdS);
                        c11841c.mcb.right = (int) (((float) rect.right) * c11841c.mdS);
                        c11841c.mcb.top = (int) (((float) rect.top) * c11841c.mdT);
                        c11841c.mcb.bottom = (int) (((float) rect.bottom) * c11841c.mdT);
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "mUiWidth：" + c11841c.mcd);
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "mUiHeight：" + c11841c.mce);
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "previewWidth：".concat(String.valueOf(i4)));
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "previewHeight：".concat(String.valueOf(i5)));
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "faceInPreviewFrame.right：" + rect.right);
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "mReflectWidthRatio：" + c11841c.mdS);
                    }
                    c11841c = C11841c.this;
                    Rect rect2 = C11841c.this.mcc;
                    Rect rect3 = C11841c.this.mcb;
                    C4990ab.m7416i("MicroMsg.FaceReflectLogic", "getFacePreviewAdvise（）");
                    if (faceStatus == null) {
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "status == null");
                        c11841c.mbZ.setText(C25738R.string.bla);
                    } else {
                        boolean contains = rect2.contains(rect3);
                        float f = ((float) ((rect3.right - rect3.left) * (rect3.bottom - rect3.top))) / ((float) ((rect2.right - rect2.left) * (rect2.bottom - rect2.top)));
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "faceInScreen left is ：" + rect3.left);
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "faceInScreen right is ：" + rect3.right);
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "faceInScreen top is ：" + rect3.top);
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "faceInScreen bottom is ：" + rect3.bottom);
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "checkRect left is ：" + rect2.left);
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "checkRect right is ：" + rect2.right);
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "checkRect top is ：" + rect2.top);
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "checkRect bottom is ：" + rect2.bottom);
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "faceProportion ：".concat(String.valueOf(f)));
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "isInRect？ ：".concat(String.valueOf(contains)));
                        C4990ab.m7416i("MicroMsg.FaceReflectLogic", "status".concat(String.valueOf(faceStatus)));
                        if (((double) f) < 0.3d) {
                            C4990ab.m7416i("MicroMsg.FaceReflectLogic", "Detecting result：too far");
                            c11841c.mbZ.setText(C25738R.string.blf);
                        } else if (((double) f) > 0.75d) {
                            C4990ab.m7416i("MicroMsg.FaceReflectLogic", "Detecting result：too close");
                            c11841c.mbZ.setText(C25738R.string.ble);
                        } else if (!contains) {
                            C4990ab.m7416i("MicroMsg.FaceReflectLogic", "Detecting result：out of rect");
                            c11841c.mbZ.setText(C25738R.string.bla);
                        } else if (Math.abs(faceStatus.pitch) > 15.0f || Math.abs(faceStatus.yaw) > 15.0f || Math.abs(faceStatus.roll) > 15.0f) {
                            C4990ab.m7416i("MicroMsg.FaceReflectLogic", "Detecting result：INCORRECT_POSTURE");
                            c11841c.mbZ.setText(C25738R.string.blc);
                        } else {
                            C4990ab.m7416i("MicroMsg.FaceReflectLogic", "Detecting result：normal");
                            c11841c.mbZ.setText(C25738R.string.blb);
                            c11841c.mdI.buc();
                            YTFaceTraceInterface.stop();
                            C4990ab.m7416i("MicroMsg.FaceReflectLogic", "YTFacePreviewInterface.stop()");
                            if (C27922a.btw().lZc) {
                                C27922a.btw().mo45816EL();
                            }
                            C5004al.m7442n(new C118472(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                        }
                    }
                    C4990ab.m7416i("MicroMsg.FaceReflectLogic", "Face end");
                    break;
                case 2:
                    C4990ab.m7416i("MicroMsg.FaceReflectLogic", "Face mState：stop detect");
                    AppMethodBeat.m2505o(788);
                    return;
            }
            AppMethodBeat.m2505o(788);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.c$3 */
    class C118463 implements FaceDetectResult {
        C118463() {
        }

        public final void onSuccess() {
            AppMethodBeat.m2504i(TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_PERCENTAGE);
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", "camera detect success ");
            AppMethodBeat.m2505o(TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_PERCENTAGE);
        }

        public final void onFailed(int i, String str, String str2) {
            AppMethodBeat.m2504i(791);
            C4990ab.m7417i("MicroMsg.FaceReflectLogic", "camera detect failed: errorCode：%s 、message：%s、tips ：%s ", Integer.valueOf(i), str, str2);
            AppMethodBeat.m2505o(791);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.c$2 */
    class C118472 implements Runnable {
        C118472() {
        }

        public final void run() {
            AppMethodBeat.m2504i(789);
            C11841c c11841c = C11841c.this;
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", " beginFaceReflectiton()");
            c11841c.mdI.bub();
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", " mBioID is " + c11841c.mdC);
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", " mConfig is " + Arrays.toString(c11841c.lWX));
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", "mConfig.length is " + c11841c.lWX.length);
            String decrypt = YTAGFaceReflectForWXJNIInterface.decrypt(c11841c.mdC, c11841c.lWX, (long) c11841c.lWX.length);
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", " real Config is ".concat(String.valueOf(decrypt)));
            YTAGReflectLiveCheckInterface.setRGBConfigRequest(new C118484(decrypt));
            c11841c.mState = 1;
            FaceDetectReporter.bsJ().mo54645I(0, System.currentTimeMillis());
            FaceDetectReporter.bsJ().mo54644H(6, System.currentTimeMillis());
            YTAGReflectLiveCheckInterface.start(c11841c.mContext, c11841c.mdw.etv, c11841c.hGq, c11841c.mdz, new C118395());
            c11841c = C11841c.this;
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", " setUploadDataCallback()");
            YTAGReflectLiveCheckInterface.setUploadVideoRequester(new C118426());
            AppMethodBeat.m2505o(789);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.c$4 */
    class C118484 implements RGBConfigRequester {
        final /* synthetic */ String mdW;

        C118484(String str) {
            this.mdW = str;
        }

        public final YTColorSeqReq getColorSeqReq() {
            AppMethodBeat.m2504i(792);
            YTColorSeqReq yTColorSeqReq = new YTColorSeqReq("", "", "");
            AppMethodBeat.m2505o(792);
            return yTColorSeqReq;
        }

        public final void request(String str, RGBConfigRequestCallBack rGBConfigRequestCallBack) {
            AppMethodBeat.m2504i(793);
            C4990ab.m7416i("MicroMsg.FaceReflectLogic", " get config lightList");
            String str2 = "";
            try {
                JSONArray optJSONArray = new JSONObject(this.mdW).optJSONArray("face_action_seq");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null && optJSONObject.optInt("action_id", 0) == 6) {
                            str2 = optJSONObject.optString("action_data");
                        }
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FaceReflectLogic", e, "parse action data error", new Object[0]);
            }
            C4990ab.m7417i("MicroMsg.FaceReflectLogic", "get actionData: %s", str2);
            if (C5046bo.isNullOrNil(str2)) {
                C7060h.pYm.mo8378a(917, 6, 1, false);
                rGBConfigRequestCallBack.onFailed(-1);
                AppMethodBeat.m2505o(793);
                return;
            }
            C7060h.pYm.mo8378a(917, 5, 1, false);
            rGBConfigRequestCallBack.onSuccess(str2);
            AppMethodBeat.m2505o(793);
        }
    }

    /* synthetic */ C11841c(byte b) {
        this();
    }

    private C11841c() {
        this.mState = 0;
    }

    /* renamed from: a */
    static String m19711a(YTAGFaceReflectResult yTAGFaceReflectResult) {
        AppMethodBeat.m2504i(800);
        if (yTAGFaceReflectResult == null || yTAGFaceReflectResult.result != 0) {
            C4990ab.m7412e("MicroMsg.FaceReflectLogic", "carson  face result is null or result code not 0");
            AppMethodBeat.m2505o(800);
            return null;
        }
        try {
            String bsS = C43036p.bsS();
            C7268ju c7268ju = new C7268ju();
            c7268ju.vMj = C1332b.m2847bI(yTAGFaceReflectResult.sidedata);
            c7268ju.vMk = C1332b.m2847bI(yTAGFaceReflectResult.data);
            C43036p.m76432d(c7268ju.toByteArray(), bsS);
            AppMethodBeat.m2505o(800);
            return bsS;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FaceReflectLogic", e, "", new Object[0]);
            AppMethodBeat.m2505o(800);
            return null;
        }
    }

    public final void onBackPressed() {
        AppMethodBeat.m2504i(801);
        if (this.mState == 0 || this.mState == 1) {
            this.mdI.mo35968aB(90004, "user cancelled in processing");
            AppMethodBeat.m2505o(801);
        } else if (this.mState == 2) {
            this.mdI.mo35968aB(90025, "user cancelled in intermediate page");
            AppMethodBeat.m2505o(801);
        } else {
            if (this.mState == 3) {
                this.mdI.mo35968aB(90006, "cancel with on stop");
            }
            AppMethodBeat.m2505o(801);
        }
    }

    public final void release() {
        AppMethodBeat.m2504i(802);
        try {
            if (this.mState == 0 || this.mState == 1) {
                YTAGReflectLiveCheckInterface.cancel();
                AppMethodBeat.m2505o(802);
                return;
            }
            YTAGReflectLiveCheckInterface.releaseModel();
            AppMethodBeat.m2505o(802);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FaceReflectLogic", e, "release error, e: %s", e.getMessage());
            AppMethodBeat.m2505o(802);
        }
    }
}
