package com.tencent.p177mm.plugin.facedetect.model;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27011o;

/* renamed from: com.tencent.mm.plugin.facedetect.model.e */
public final class C27932e {
    private static long lTI = -1;
    private static long lTJ = -1;
    private static float lTK = -1.0f;

    /* renamed from: il */
    public static void m44467il(long j) {
        lTI = j;
    }

    public static boolean bst() {
        AppMethodBeat.m2504i(188);
        boolean parseBoolean = Boolean.parseBoolean(C6665av.fly.mo5292T("last_login_face_use_debug_mode", "false"));
        AppMethodBeat.m2505o(188);
        return parseBoolean;
    }

    public static boolean bsu() {
        AppMethodBeat.m2504i(189);
        boolean parseBoolean = Boolean.parseBoolean(C6665av.fly.mo5292T("last_login_face_is_force_upload_face", "false"));
        AppMethodBeat.m2505o(189);
        return parseBoolean;
    }

    public static boolean bsv() {
        AppMethodBeat.m2504i(FacebookRequestErrorClassification.EC_INVALID_TOKEN);
        boolean parseBoolean = Boolean.parseBoolean(C6665av.fly.mo5292T("last_login_face_save_correct_debug_mode", "false"));
        AppMethodBeat.m2505o(FacebookRequestErrorClassification.EC_INVALID_TOKEN);
        return parseBoolean;
    }

    public static boolean bsw() {
        AppMethodBeat.m2504i(191);
        boolean parseBoolean = Boolean.parseBoolean(C6665av.fly.mo5292T("last_login_face_save_final_debug_mode", "false"));
        AppMethodBeat.m2505o(191);
        return parseBoolean;
    }

    public static boolean bsx() {
        AppMethodBeat.m2504i(C33250az.CTRL_INDEX);
        boolean parseBoolean = Boolean.parseBoolean(C6665av.fly.mo5292T("last_login_face_save_lip_reading", "false"));
        AppMethodBeat.m2505o(C33250az.CTRL_INDEX);
        return parseBoolean;
    }

    public static boolean bsy() {
        AppMethodBeat.m2504i(JsApiChooseMedia.CTRL_INDEX);
        boolean parseBoolean = Boolean.parseBoolean(C6665av.fly.mo5292T("last_login_face_save_final_voice", "false"));
        AppMethodBeat.m2505o(JsApiChooseMedia.CTRL_INDEX);
        return parseBoolean;
    }

    /* renamed from: gU */
    public static void m44461gU(boolean z) {
        AppMethodBeat.m2504i(JsApiUploadEncryptedFileToCDN.CTRL_INDEX);
        C6665av.fly.mo14897ak("last_login_face_use_debug_mode", String.valueOf(z));
        AppMethodBeat.m2505o(JsApiUploadEncryptedFileToCDN.CTRL_INDEX);
    }

    /* renamed from: gV */
    public static void m44462gV(boolean z) {
        AppMethodBeat.m2504i(JsApiChooseWeChatContact.CTRL_INDEX);
        C6665av.fly.mo14897ak("last_login_face_save_correct_debug_mode", String.valueOf(z));
        AppMethodBeat.m2505o(JsApiChooseWeChatContact.CTRL_INDEX);
    }

    /* renamed from: gW */
    public static void m44463gW(boolean z) {
        AppMethodBeat.m2504i(196);
        C6665av.fly.mo14897ak("last_login_face_save_final_debug_mode", String.valueOf(z));
        AppMethodBeat.m2505o(196);
    }

    /* renamed from: gX */
    public static void m44464gX(boolean z) {
        AppMethodBeat.m2504i(197);
        C6665av.fly.mo14897ak("last_login_face_save_lip_reading", String.valueOf(z));
        AppMethodBeat.m2505o(197);
    }

    /* renamed from: gY */
    public static void m44465gY(boolean z) {
        AppMethodBeat.m2504i(C27011o.CTRL_INDEX);
        C6665av.fly.mo14897ak("last_login_face_save_final_voice", String.valueOf(z));
        AppMethodBeat.m2505o(C27011o.CTRL_INDEX);
    }

    /* renamed from: gZ */
    public static void m44466gZ(boolean z) {
        AppMethodBeat.m2504i(199);
        C6665av.fly.mo14897ak("last_login_face_is_force_upload_face", String.valueOf(z));
        AppMethodBeat.m2505o(199);
    }
}
