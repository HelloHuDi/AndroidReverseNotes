package com.tencent.filter;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.filter.m.f;
import com.tencent.filter.m.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.plugin.appbrand.jsapi.k.a;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.view.d;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

public final class b extends BaseFilter {
    private final int[] bJs = new int[]{0, 1, 3, 4, 6, 8, 9, 11, 13, 14, 16, 18, 19, 21, 23, 24, 26, 28, 29, 31, 33, 34, 36, 38, 39, 41, 42, 44, 46, 47, 49, 51, 52, 54, 55, 57, 59, 60, 62, 64, 65, 67, 68, 70, 71, 73, 75, 76, 78, 79, 81, 82, 84, 86, 87, 89, 90, 92, 93, 95, 96, 98, 99, 101, 102, 104, 105, 107, 108, 110, 111, 113, 114, 116, d.MIC_ALPHA_ADJUST_REAL, d.MIC_AVROUND_BLUR, 120, 121, 123, 124, 126, d.MIC_SketchMark, 128, 130, 131, e.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX, 137, 138, a.CTRL_INDEX, 141, ErrorCode.NEEDDOWNLOAD_3, ErrorCode.NEEDDOWNLOAD_4, 145, 146, ErrorCode.NEEDDOWNLOAD_8, 149, 150, 151, 152, JsApiMakeVoIPCall.CTRL_INDEX, 155, 156, 157, JsApiGetBackgroundAudioState.CTRL_INDEX, 160, 161, ErrorCode.STARTDOWNLOAD_3, ErrorCode.STARTDOWNLOAD_5, ErrorCode.STARTDOWNLOAD_6, 166, ErrorCode.STARTDOWNLOAD_8, 168, 169, ErrorCode.NEEDDOWNLOAD_FALSE_1, ErrorCode.NEEDDOWNLOAD_FALSE_2, ErrorCode.NEEDDOWNLOAD_FALSE_3, ErrorCode.NEEDDOWNLOAD_FALSE_4, ErrorCode.NEEDDOWNLOAD_FALSE_5, ErrorCode.NEEDDOWNLOAD_FALSE_6, ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, 178, 179, 180, 181, FaceMoveUtil.TRIANGLE_COUNT, 183, FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE, 186, 187, 188, 188, 189, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 191, az.CTRL_INDEX, JsApiChooseMedia.CTRL_INDEX, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, JsApiChooseWeChatContact.CTRL_INDEX, 196, 197, o.CTRL_INDEX, 199, 200, 200, 201, 202, 203, 204, 205, 205, 206, 207, 208, 208, 209, 210, 211, 211, 212, 213, 214, 214, 215, 216, 216, 217, 218, 218, 219, 219, 220, 221, 221, 222, 223, 223, 224, 224, 225, 225, 226, 226, 227, 228, 228, 229, 229, 230, 230, 231, 231, 232, 232, d.MIC_PTU_MEISHI, d.MIC_PTU_MEISHI, d.MIC_PTU_FENGJING, d.MIC_PTU_FENGJING, d.MIC_PTU_FENGJING, d.MIC_PTU_AUTOLEVEL, d.MIC_PTU_AUTOLEVEL, 236, 236, d.MIC_PTU_LENGMEIREN, d.MIC_PTU_LENGMEIREN, d.MIC_PTU_LENGMEIREN, d.MIC_PTU_SHIGUANG, d.MIC_PTU_SHIGUANG, d.MIC_PTU_SHISHANG2, d.MIC_PTU_SHISHANG2, 240, 240, 240, d.MIC_PTU_QINGCONG, d.MIC_PTU_QINGCONG, d.MIC_PTU_QINGCONG, 242, 242, 243, 243, 243, 244, 244, 244, d.MIC_PTU_ZIPAI_LIGHTWHITE, d.MIC_PTU_ZIPAI_LIGHTWHITE, d.MIC_PTU_ZIPAI_LIGHTWHITE, d.MIC_PTU_ZIPAI_FAIRYTALE, d.MIC_PTU_ZIPAI_FAIRYTALE, d.MIC_PTU_ZIPAI_FAIRYTALE, 247, 247, 247, d.MIC_PTU_ZIPAI_THURSDAY, d.MIC_PTU_ZIPAI_THURSDAY, d.MIC_PTU_ZIPAI_THURSDAY, 249, 249, 249, 250, 250, 250, 251, 251, 251, 252, 252, 252, d.MIC_PTU_ZIPAI_OKINAWA, d.MIC_PTU_ZIPAI_OKINAWA, d.MIC_PTU_ZIPAI_OKINAWA, d.MIC_PTU_ZIPAI_LIGHTRED, d.MIC_PTU_ZIPAI_LIGHTRED, d.MIC_PTU_ZIPAI_LIGHTRED, 255};
    int bJt = 0;
    int bJu = 1;
    private final int[] curve_static = new int[]{0, 1, 3, 4, 6, 7, 9, 10, 12, 13, 15, 16, 18, 19, 21, 22, 24, 25, 27, 28, 30, 31, 33, 34, 36, 37, 39, 40, 42, 43, 45, 46, 47, 49, 50, 52, 53, 55, 56, 58, 59, 61, 62, 63, 65, 66, 68, 69, 71, 72, 73, 75, 76, 78, 79, 80, 82, 83, 85, 86, 87, 89, 90, 92, 93, 94, 96, 97, 98, 100, 101, 102, 104, 105, 106, 108, 109, 110, 112, 113, 114, 116, d.MIC_ALPHA_ADJUST_REAL, 118, d.MIC_AVROUND_BLUR, 121, 122, 123, 125, 126, d.MIC_SketchMark, 128, 130, 131, 132, e.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX, n.CTRL_INDEX, 137, 138, a.CTRL_INDEX, 140, ErrorCode.NEEDDOWNLOAD_3, ErrorCode.NEEDDOWNLOAD_4, 144, 145, 146, ErrorCode.NEEDDOWNLOAD_8, 149, 150, 151, 152, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, JsApiMakeVoIPCall.CTRL_INDEX, 155, 156, 157, JsApiGetBackgroundAudioState.CTRL_INDEX, 160, 161, ErrorCode.STARTDOWNLOAD_3, ErrorCode.STARTDOWNLOAD_4, ErrorCode.STARTDOWNLOAD_5, ErrorCode.STARTDOWNLOAD_6, 166, ErrorCode.STARTDOWNLOAD_8, 168, 169, ErrorCode.NEEDDOWNLOAD_TRUE, ErrorCode.NEEDDOWNLOAD_FALSE_1, ErrorCode.NEEDDOWNLOAD_FALSE_2, ErrorCode.NEEDDOWNLOAD_FALSE_3, ErrorCode.NEEDDOWNLOAD_FALSE_4, ErrorCode.NEEDDOWNLOAD_FALSE_5, ErrorCode.NEEDDOWNLOAD_FALSE_6, ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, 178, 179, 180, 181, 181, FaceMoveUtil.TRIANGLE_COUNT, 183, FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE, 185, 186, 187, 188, 188, 189, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 191, az.CTRL_INDEX, JsApiChooseMedia.CTRL_INDEX, JsApiChooseMedia.CTRL_INDEX, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, JsApiChooseWeChatContact.CTRL_INDEX, 196, 197, 197, o.CTRL_INDEX, 199, 200, 201, 201, 202, 203, 204, 204, 205, 206, 207, 207, 208, 209, 209, 210, 211, 211, 212, 213, 213, 214, 215, 215, 216, 217, 217, 218, 219, 219, 220, 221, 221, 222, 222, 223, 224, 224, 225, 226, 226, 227, 227, 228, 228, 229, 230, 230, 231, 231, 232, 232, d.MIC_PTU_MEISHI, d.MIC_PTU_FENGJING, d.MIC_PTU_FENGJING, d.MIC_PTU_AUTOLEVEL, d.MIC_PTU_AUTOLEVEL, 236, 236, d.MIC_PTU_LENGMEIREN, d.MIC_PTU_LENGMEIREN, d.MIC_PTU_SHIGUANG, d.MIC_PTU_SHIGUANG, d.MIC_PTU_SHISHANG2, 240, 240, d.MIC_PTU_QINGCONG, d.MIC_PTU_QINGCONG, 242, 242, 243, 243, 244, 244, d.MIC_PTU_ZIPAI_LIGHTWHITE, d.MIC_PTU_ZIPAI_LIGHTWHITE, d.MIC_PTU_ZIPAI_FAIRYTALE, d.MIC_PTU_ZIPAI_FAIRYTALE, 247, 247, d.MIC_PTU_ZIPAI_THURSDAY, d.MIC_PTU_ZIPAI_THURSDAY, 249, 249, 250, 250, 251, 251, 252, 252, d.MIC_PTU_ZIPAI_OKINAWA, d.MIC_PTU_ZIPAI_OKINAWA, d.MIC_PTU_ZIPAI_LIGHTRED, d.MIC_PTU_ZIPAI_LIGHTRED, 255};

    public b(int i, int i2) {
        super(i);
        AppMethodBeat.i(86346);
        this.bJu = i2;
        AppMethodBeat.o(86346);
    }

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.i(86347);
        if (map.containsKey("effectIndex")) {
            this.bJt = ((Integer) map.get("effectIndex")).intValue();
        }
        AppMethodBeat.o(86347);
    }

    public final void setEffectIndex(int i) {
        this.bJt = i;
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86348);
        if (IsFilterInvalute()) {
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.o(86348);
            return;
        }
        BaseFilter baseFilter;
        BaseFilter baseFilter2;
        this.glsl_programID = GLSLRender.bJB;
        if (this.bJu == 1) {
            baseFilter = new BaseFilter(GLSLRender.bJQ);
            baseFilter.addParam(new f("radius", 2.0f));
            setNextFilter(baseFilter, null);
            baseFilter2 = new BaseFilter(GLSLRender.bJR);
            baseFilter2.addParam(new f("radius", 2.0f));
            baseFilter.setNextFilter(baseFilter2, null);
            baseFilter = new BaseFilter(GLSLRender.bJS);
            baseFilter.addParam(new m("inputImageTexture2", this.curve_static, 33986));
            baseFilter2.setNextFilter(baseFilter, null);
            baseFilter.setNextFilter(new BaseFilter(GLSLRender.bJT), new int[]{this.srcTextureIndex + 1});
        } else {
            baseFilter = this;
        }
        switch (this.bJt) {
            case 1:
                baseFilter2 = new BaseFilter(GLSLRender.bJV);
                baseFilter2.addParam(new m.o("inputImageTexture2", "portraitbeauty.png", 33986));
                break;
            case 2:
            case 1002:
                baseFilter2 = new BaseFilter(GLSLRender.bJW);
                baseFilter2.addParam(new m.o("inputImageTexture2", "portraitbeauty.png", 33986));
                break;
            case 3:
                baseFilter2 = new BaseFilter(GLSLRender.bJX);
                baseFilter2.addParam(new m.o("inputImageTexture2", "portraitbeauty.png", 33986));
                break;
            case 4:
                baseFilter2 = new BaseFilter(GLSLRender.bJY);
                baseFilter2.addParam(new m.o("inputImageTexture2", "portraitbeauty.png", 33986));
                break;
            case 5:
                baseFilter2 = new BaseFilter(GLSLRender.bJZ);
                baseFilter2.addParam(new m.o("inputImageTexture2", "portraitbeauty.png", 33986));
                break;
            case 6:
                baseFilter2 = new BaseFilter(GLSLRender.bKa);
                baseFilter2.addParam(new m("inputImageTexture2", this.bJs, 33986));
                break;
            case 7:
                baseFilter2 = new BaseFilter(GLSLRender.bKb);
                baseFilter2.addParam(new m.o("inputImageTexture2", "fennen.png", 33986));
                break;
            case 8:
                baseFilter2 = new BaseFilter(GLSLRender.bJN);
                baseFilter2.addParam(new m.o("inputImageTexture2", "gradient.jpg", 33986));
                break;
            case 9:
                baseFilter2 = new BaseFilter(GLSLRender.bKs);
                baseFilter2.addParam(new m.o("inputImageTexture2", "portraitbeauty.png", 33986));
                break;
            case 101:
                baseFilter2 = new BaseFilter(GLSLRender.bKq);
                baseFilter2.addParam(new m.o("inputImageTexture2", "yangguang.png", 33986));
                break;
            case 102:
                baseFilter2 = new BaseFilter(GLSLRender.bKr);
                baseFilter2.addParam(new m.o("inputImageTexture2", "hongrun.png", 33986));
                break;
            case 103:
                baseFilter2 = new BaseFilter(GLSLRender.bKp);
                baseFilter2.addParam(new m.o("inputImageTexture2", "tianmei.png", 33986));
                break;
            default:
                baseFilter2 = null;
                break;
        }
        baseFilter.setNextFilter(baseFilter2, null);
        if (!(this.bJt == 1 || this.bJt == 8 || this.bJt <= 0)) {
            baseFilter = new BaseFilter(GLSLRender.bJU);
            baseFilter.addParam(new m.o("inputImageTexture2", "glowcenter.jpg", 33986));
            baseFilter2.setNextFilter(baseFilter, null);
            baseFilter2 = baseFilter;
        }
        if (this.bJt == 9) {
            baseFilter = new BaseFilter(GLSLRender.bJF);
            baseFilter.addParam(new f("filterAdjustParam", 0.64000005f));
            baseFilter2.setNextFilter(baseFilter, new int[]{this.srcTextureIndex + 1});
        } else if (this.bJt == 1002) {
            baseFilter = new BaseFilter(GLSLRender.bJF);
            baseFilter.addParam(new f("filterAdjustParam", 0.56f));
            baseFilter2.setNextFilter(baseFilter, new int[]{this.srcTextureIndex + 1});
        }
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86348);
    }
}
