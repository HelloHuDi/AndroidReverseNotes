package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectResult;
import com.tencent.mm.plugin.facedetectlight.ui.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ju;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.RGBConfigRequestCallBack;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.YTColorSeqReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester.UploadVideoResponse;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceTraceingNotice;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
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
    public b mdI;
    int mdQ;
    Point mdR;
    float mdS;
    float mdT;
    UploadVideoResponse mdU;
    t mdw;
    FaceReflectMask mdz;

    public static class a {
        private static c mdY = new c();

        static {
            AppMethodBeat.i(799);
            AppMethodBeat.o(799);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.c$4 */
    class AnonymousClass4 implements RGBConfigRequester {
        final /* synthetic */ String mdW;

        AnonymousClass4(String str) {
            this.mdW = str;
        }

        public final YTColorSeqReq getColorSeqReq() {
            AppMethodBeat.i(792);
            YTColorSeqReq yTColorSeqReq = new YTColorSeqReq("", "", "");
            AppMethodBeat.o(792);
            return yTColorSeqReq;
        }

        public final void request(String str, RGBConfigRequestCallBack rGBConfigRequestCallBack) {
            AppMethodBeat.i(793);
            ab.i("MicroMsg.FaceReflectLogic", " get config lightList");
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
                ab.printErrStackTrace("MicroMsg.FaceReflectLogic", e, "parse action data error", new Object[0]);
            }
            ab.i("MicroMsg.FaceReflectLogic", "get actionData: %s", str2);
            if (bo.isNullOrNil(str2)) {
                h.pYm.a(917, 6, 1, false);
                rGBConfigRequestCallBack.onFailed(-1);
                AppMethodBeat.o(793);
                return;
            }
            h.pYm.a(917, 5, 1, false);
            rGBConfigRequestCallBack.onSuccess(str2);
            AppMethodBeat.o(793);
        }
    }

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
        this.mState = 0;
    }

    static String a(YTAGFaceReflectResult yTAGFaceReflectResult) {
        AppMethodBeat.i(800);
        if (yTAGFaceReflectResult == null || yTAGFaceReflectResult.result != 0) {
            ab.e("MicroMsg.FaceReflectLogic", "carson  face result is null or result code not 0");
            AppMethodBeat.o(800);
            return null;
        }
        try {
            String bsS = p.bsS();
            ju juVar = new ju();
            juVar.vMj = com.tencent.mm.bt.b.bI(yTAGFaceReflectResult.sidedata);
            juVar.vMk = com.tencent.mm.bt.b.bI(yTAGFaceReflectResult.data);
            p.d(juVar.toByteArray(), bsS);
            AppMethodBeat.o(800);
            return bsS;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.FaceReflectLogic", e, "", new Object[0]);
            AppMethodBeat.o(800);
            return null;
        }
    }

    public final void onBackPressed() {
        AppMethodBeat.i(801);
        if (this.mState == 0 || this.mState == 1) {
            this.mdI.aB(90004, "user cancelled in processing");
            AppMethodBeat.o(801);
        } else if (this.mState == 2) {
            this.mdI.aB(90025, "user cancelled in intermediate page");
            AppMethodBeat.o(801);
        } else {
            if (this.mState == 3) {
                this.mdI.aB(90006, "cancel with on stop");
            }
            AppMethodBeat.o(801);
        }
    }

    public final void release() {
        AppMethodBeat.i(802);
        try {
            if (this.mState == 0 || this.mState == 1) {
                YTAGReflectLiveCheckInterface.cancel();
                AppMethodBeat.o(802);
                return;
            }
            YTAGReflectLiveCheckInterface.releaseModel();
            AppMethodBeat.o(802);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.FaceReflectLogic", e, "release error, e: %s", e.getMessage());
            AppMethodBeat.o(802);
        }
    }
}
