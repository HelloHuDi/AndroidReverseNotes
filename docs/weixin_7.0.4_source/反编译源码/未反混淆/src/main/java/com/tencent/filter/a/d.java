package com.tencent.filter.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.model.WMElement;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

public final class d extends BaseFilter {
    private BaseFilter bNG = null;
    private a bNH = null;
    private a bNI = null;
    float[] bNJ = new float[7];
    float bNK = 0.3f;
    private final int[] curve_static = new int[]{0, 1, 3, 4, 6, 7, 9, 10, 12, 13, 15, 16, 18, 19, 21, 22, 24, 25, 27, 28, 30, 31, 33, 34, 36, 37, 39, 40, 42, 43, 45, 46, 47, 49, 50, 52, 53, 55, 56, 58, 59, 61, 62, 63, 65, 66, 68, 69, 71, 72, 73, 75, 76, 78, 79, 80, 82, 83, 85, 86, 87, 89, 90, 92, 93, 94, 96, 97, 98, 100, 101, 102, 104, 105, 106, 108, 109, 110, 112, 113, 114, 116, com.tencent.view.d.MIC_ALPHA_ADJUST_REAL, 118, com.tencent.view.d.MIC_AVROUND_BLUR, 121, 122, 123, 125, 126, com.tencent.view.d.MIC_SketchMark, 128, 130, 131, 132, e.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX, n.CTRL_INDEX, 137, 138, com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX, 140, ErrorCode.NEEDDOWNLOAD_3, ErrorCode.NEEDDOWNLOAD_4, 144, 145, 146, ErrorCode.NEEDDOWNLOAD_8, 149, 150, 151, 152, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, JsApiMakeVoIPCall.CTRL_INDEX, 155, 156, 157, JsApiGetBackgroundAudioState.CTRL_INDEX, 160, 161, ErrorCode.STARTDOWNLOAD_3, ErrorCode.STARTDOWNLOAD_4, ErrorCode.STARTDOWNLOAD_5, ErrorCode.STARTDOWNLOAD_6, 166, ErrorCode.STARTDOWNLOAD_8, 168, 169, ErrorCode.NEEDDOWNLOAD_TRUE, ErrorCode.NEEDDOWNLOAD_FALSE_1, ErrorCode.NEEDDOWNLOAD_FALSE_2, ErrorCode.NEEDDOWNLOAD_FALSE_3, ErrorCode.NEEDDOWNLOAD_FALSE_4, ErrorCode.NEEDDOWNLOAD_FALSE_5, ErrorCode.NEEDDOWNLOAD_FALSE_6, ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, 178, 179, 180, 181, 181, FaceMoveUtil.TRIANGLE_COUNT, 183, FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE, 185, 186, 187, 188, 188, 189, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 191, az.CTRL_INDEX, JsApiChooseMedia.CTRL_INDEX, JsApiChooseMedia.CTRL_INDEX, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, JsApiChooseWeChatContact.CTRL_INDEX, 196, 197, 197, o.CTRL_INDEX, 199, 200, 201, 201, 202, 203, 204, 204, 205, 206, 207, 207, 208, 209, 209, 210, 211, 211, 212, 213, 213, 214, 215, 215, 216, 217, 217, 218, 219, 219, 220, 221, 221, 222, 222, 223, 224, 224, 225, 226, 226, 227, 227, 228, 228, 229, 230, 230, 231, 231, 232, 232, com.tencent.view.d.MIC_PTU_MEISHI, com.tencent.view.d.MIC_PTU_FENGJING, com.tencent.view.d.MIC_PTU_FENGJING, com.tencent.view.d.MIC_PTU_AUTOLEVEL, com.tencent.view.d.MIC_PTU_AUTOLEVEL, 236, 236, com.tencent.view.d.MIC_PTU_LENGMEIREN, com.tencent.view.d.MIC_PTU_LENGMEIREN, com.tencent.view.d.MIC_PTU_SHIGUANG, com.tencent.view.d.MIC_PTU_SHIGUANG, com.tencent.view.d.MIC_PTU_SHISHANG2, 240, 240, com.tencent.view.d.MIC_PTU_QINGCONG, com.tencent.view.d.MIC_PTU_QINGCONG, 242, 242, 243, 243, 244, 244, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE, com.tencent.view.d.MIC_PTU_ZIPAI_FAIRYTALE, com.tencent.view.d.MIC_PTU_ZIPAI_FAIRYTALE, 247, 247, com.tencent.view.d.MIC_PTU_ZIPAI_THURSDAY, com.tencent.view.d.MIC_PTU_ZIPAI_THURSDAY, 249, 249, 250, 250, 251, 251, 252, 252, com.tencent.view.d.MIC_PTU_ZIPAI_OKINAWA, com.tencent.view.d.MIC_PTU_ZIPAI_OKINAWA, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED, 255};
    private final int[] meitu_whiten = new int[]{0, 1, 3, 4, 6, 8, 9, 11, 13, 14, 16, 18, 19, 21, 23, 24, 26, 28, 29, 31, 33, 34, 36, 38, 39, 41, 42, 44, 46, 47, 49, 51, 52, 54, 55, 57, 59, 60, 62, 64, 65, 67, 68, 70, 71, 73, 75, 76, 78, 79, 81, 82, 84, 86, 87, 89, 90, 92, 93, 95, 96, 98, 99, 101, 102, 104, 105, 107, 108, 110, 111, 113, 114, 116, com.tencent.view.d.MIC_ALPHA_ADJUST_REAL, com.tencent.view.d.MIC_AVROUND_BLUR, 120, 121, 123, 124, 126, com.tencent.view.d.MIC_SketchMark, 128, 130, 131, e.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX, b.CTRL_INDEX, 137, 138, com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX, 141, ErrorCode.NEEDDOWNLOAD_3, ErrorCode.NEEDDOWNLOAD_4, 145, 146, ErrorCode.NEEDDOWNLOAD_8, 149, 150, 151, 152, JsApiMakeVoIPCall.CTRL_INDEX, 155, 156, 157, JsApiGetBackgroundAudioState.CTRL_INDEX, 160, 161, ErrorCode.STARTDOWNLOAD_3, ErrorCode.STARTDOWNLOAD_5, ErrorCode.STARTDOWNLOAD_6, 166, ErrorCode.STARTDOWNLOAD_8, 168, 169, ErrorCode.NEEDDOWNLOAD_FALSE_1, ErrorCode.NEEDDOWNLOAD_FALSE_2, ErrorCode.NEEDDOWNLOAD_FALSE_3, ErrorCode.NEEDDOWNLOAD_FALSE_4, ErrorCode.NEEDDOWNLOAD_FALSE_5, ErrorCode.NEEDDOWNLOAD_FALSE_6, ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, 178, 179, 180, 181, FaceMoveUtil.TRIANGLE_COUNT, 183, FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE, 186, 187, 188, 188, 189, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 191, az.CTRL_INDEX, JsApiChooseMedia.CTRL_INDEX, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, JsApiChooseWeChatContact.CTRL_INDEX, 196, 197, o.CTRL_INDEX, 199, 200, 200, 201, 202, 203, 204, 205, 205, 206, 207, 208, 208, 209, 210, 211, 211, 212, 213, 214, 214, 215, 216, 216, 217, 218, 218, 219, 219, 220, 221, 221, 222, 223, 223, 224, 224, 225, 225, 226, 226, 227, 228, 228, 229, 229, 230, 230, 231, 231, 232, 232, com.tencent.view.d.MIC_PTU_MEISHI, com.tencent.view.d.MIC_PTU_MEISHI, com.tencent.view.d.MIC_PTU_FENGJING, com.tencent.view.d.MIC_PTU_FENGJING, com.tencent.view.d.MIC_PTU_FENGJING, com.tencent.view.d.MIC_PTU_AUTOLEVEL, com.tencent.view.d.MIC_PTU_AUTOLEVEL, 236, 236, com.tencent.view.d.MIC_PTU_LENGMEIREN, com.tencent.view.d.MIC_PTU_LENGMEIREN, com.tencent.view.d.MIC_PTU_LENGMEIREN, com.tencent.view.d.MIC_PTU_SHIGUANG, com.tencent.view.d.MIC_PTU_SHIGUANG, com.tencent.view.d.MIC_PTU_SHISHANG2, com.tencent.view.d.MIC_PTU_SHISHANG2, 240, 240, 240, com.tencent.view.d.MIC_PTU_QINGCONG, com.tencent.view.d.MIC_PTU_QINGCONG, com.tencent.view.d.MIC_PTU_QINGCONG, 242, 242, 243, 243, 243, 244, 244, 244, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE, com.tencent.view.d.MIC_PTU_ZIPAI_FAIRYTALE, com.tencent.view.d.MIC_PTU_ZIPAI_FAIRYTALE, com.tencent.view.d.MIC_PTU_ZIPAI_FAIRYTALE, 247, 247, 247, com.tencent.view.d.MIC_PTU_ZIPAI_THURSDAY, com.tencent.view.d.MIC_PTU_ZIPAI_THURSDAY, com.tencent.view.d.MIC_PTU_ZIPAI_THURSDAY, 249, 249, 249, 250, 250, 250, 251, 251, 251, 252, 252, 252, com.tencent.view.d.MIC_PTU_ZIPAI_OKINAWA, com.tencent.view.d.MIC_PTU_ZIPAI_OKINAWA, com.tencent.view.d.MIC_PTU_ZIPAI_OKINAWA, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED, com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED, 255};
    float opttype = 1.0f;
    float radius = 0.5f;
    float scale = 1.0f;
    float skinFilter = 1.0f;
    float whitenmag = 0.0f;

    public static class a extends BaseFilter {
        int aIV;
        int aIW;
        boolean bNL;
        public boolean bNM = true;
        float radius = 0.5f;

        public final void X(float f) {
            this.radius = f;
            this.bNM = true;
        }

        private void wG() {
            int floor;
            AppMethodBeat.i(86431);
            float round = (float) Math.round(((this.radius * 10.0f) / 720.0f) * ((float) this.aIV));
            if (round >= 1.0f) {
                floor = (int) Math.floor(Math.sqrt((-2.0d * Math.pow((double) round, 2.0d)) * Math.log(0.00390625d * Math.sqrt(6.283185307179586d * Math.pow((double) round, 2.0d)))));
                floor += floor % 2;
            } else {
                floor = 0;
            }
            updateFragmentShader(aj.b(floor, round, this.bNL, this.bNL));
            clearGLSLSelf();
            ApplyGLSLFilter();
            this.bNM = false;
            AppMethodBeat.o(86431);
        }

        public a(boolean z) {
            super(GLSLRender.bJB);
            this.bNL = z;
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.i(86432);
            this.aIV = (int) f;
            this.aIW = (int) f2;
            wG();
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.o(86432);
        }

        public final void beforeRender(int i, int i2, int i3) {
            AppMethodBeat.i(86433);
            boolean z = (!this.bNM && this.aIV == i2 && this.aIW == i3) ? false : true;
            this.bNM = z;
            if (this.bNM) {
                this.aIV = i2;
                this.aIW = i3;
                wG();
            }
            AppMethodBeat.o(86433);
        }
    }

    public d() {
        super(GLSLRender.bLT);
        AppMethodBeat.i(86434);
        setRadius(1.0f);
        AppMethodBeat.o(86434);
    }

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.i(86435);
        if (map.containsKey("opttype")) {
            this.opttype = ((Float) map.get("opttype")).floatValue();
            if (this.bNG != null) {
                this.bNG.addParam(new f("opttype", this.opttype));
            }
        }
        if (map.containsKey("whitenmag")) {
            this.whitenmag = Math.max(0.0f, Math.min(((Float) map.get("whitenmag")).floatValue(), 1.0f));
            if (this.bNG != null) {
                this.bNG.addParam(new f("whiten", this.whitenmag));
            }
        }
        if (map.containsKey(WMElement.ANIMATE_TYPE_SCALE)) {
            this.scale = ((Float) map.get(WMElement.ANIMATE_TYPE_SCALE)).floatValue();
        }
        if (map.containsKey("radius")) {
            setRadius(((Float) map.get("radius")).floatValue());
        }
        if (map.containsKey("smoothMag")) {
            this.bNK = ((Float) map.get("smoothMag")).floatValue();
            if (this.bNG != null) {
                this.bNG.addParam(new f("smoothMag", this.bNK));
            }
        }
        if (map.containsKey("skinFilter")) {
            this.skinFilter = ((Float) map.get("skinFilter")).floatValue();
            if (this.bNG != null) {
                this.bNG.addParam(new f("skinFilter", this.skinFilter));
            }
        }
        AppMethodBeat.o(86435);
    }

    private void setRadius(float f) {
        AppMethodBeat.i(86436);
        this.radius = Math.max(0.0f, Math.min(f, 1.0f));
        this.radius = this.radius;
        if (this.bNI != null) {
            this.bNH.X(this.radius);
            this.bNI.X(this.radius);
        }
        AppMethodBeat.o(86436);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86437);
        if (IsFilterInvalute()) {
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.o(86437);
            return;
        }
        float[] fArr = new float[]{1.0f, 1.0f, 1.0f};
        float[] fArr2 = new float[]{0.96f, 0.96f, 0.96f};
        float[] fArr3 = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr4 = new float[]{1.0f, 1.0f, 1.0f};
        addParam(new g("levelMinimum", new float[]{0.04f, 0.04f, 0.04f}));
        addParam(new g("levelMiddle", fArr));
        addParam(new g("levelMaximum", fArr2));
        addParam(new g("minOutput", fArr3));
        addParam(new g("maxOutput", fArr4));
        this.bNH = new a(true);
        this.bNH.X(this.radius);
        setNextFilter(this.bNH, null);
        this.bNI = new a(false);
        this.bNI.X(this.radius);
        this.bNH.setNextFilter(this.bNI, null);
        this.bNG = new BaseFilter(GLSLRender.bLS);
        this.bNG.addParam(new m("inputImageTexture2", this.curve_static, 33986));
        this.bNG.addParam(new m("inputImageTexture3", this.meitu_whiten, 33987));
        this.bNG.addParam(new f("whiten", this.whitenmag));
        this.bNG.addParam(new f("opttype", this.opttype));
        this.bNG.addParam(new f("skinFilter", this.skinFilter));
        this.bNG.addParam(new f("smoothMag", this.bNK));
        this.bNI.setNextFilter(this.bNG, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86437);
    }
}
