package com.tencent.mm.plugin.facedetect.model;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.av;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;

public final class e {
    private static long lTI = -1;
    private static long lTJ = -1;
    private static float lTK = -1.0f;

    public static void il(long j) {
        lTI = j;
    }

    public static boolean bst() {
        AppMethodBeat.i(188);
        boolean parseBoolean = Boolean.parseBoolean(av.fly.T("last_login_face_use_debug_mode", "false"));
        AppMethodBeat.o(188);
        return parseBoolean;
    }

    public static boolean bsu() {
        AppMethodBeat.i(189);
        boolean parseBoolean = Boolean.parseBoolean(av.fly.T("last_login_face_is_force_upload_face", "false"));
        AppMethodBeat.o(189);
        return parseBoolean;
    }

    public static boolean bsv() {
        AppMethodBeat.i(FacebookRequestErrorClassification.EC_INVALID_TOKEN);
        boolean parseBoolean = Boolean.parseBoolean(av.fly.T("last_login_face_save_correct_debug_mode", "false"));
        AppMethodBeat.o(FacebookRequestErrorClassification.EC_INVALID_TOKEN);
        return parseBoolean;
    }

    public static boolean bsw() {
        AppMethodBeat.i(191);
        boolean parseBoolean = Boolean.parseBoolean(av.fly.T("last_login_face_save_final_debug_mode", "false"));
        AppMethodBeat.o(191);
        return parseBoolean;
    }

    public static boolean bsx() {
        AppMethodBeat.i(az.CTRL_INDEX);
        boolean parseBoolean = Boolean.parseBoolean(av.fly.T("last_login_face_save_lip_reading", "false"));
        AppMethodBeat.o(az.CTRL_INDEX);
        return parseBoolean;
    }

    public static boolean bsy() {
        AppMethodBeat.i(JsApiChooseMedia.CTRL_INDEX);
        boolean parseBoolean = Boolean.parseBoolean(av.fly.T("last_login_face_save_final_voice", "false"));
        AppMethodBeat.o(JsApiChooseMedia.CTRL_INDEX);
        return parseBoolean;
    }

    public static void gU(boolean z) {
        AppMethodBeat.i(JsApiUploadEncryptedFileToCDN.CTRL_INDEX);
        av.fly.ak("last_login_face_use_debug_mode", String.valueOf(z));
        AppMethodBeat.o(JsApiUploadEncryptedFileToCDN.CTRL_INDEX);
    }

    public static void gV(boolean z) {
        AppMethodBeat.i(JsApiChooseWeChatContact.CTRL_INDEX);
        av.fly.ak("last_login_face_save_correct_debug_mode", String.valueOf(z));
        AppMethodBeat.o(JsApiChooseWeChatContact.CTRL_INDEX);
    }

    public static void gW(boolean z) {
        AppMethodBeat.i(196);
        av.fly.ak("last_login_face_save_final_debug_mode", String.valueOf(z));
        AppMethodBeat.o(196);
    }

    public static void gX(boolean z) {
        AppMethodBeat.i(197);
        av.fly.ak("last_login_face_save_lip_reading", String.valueOf(z));
        AppMethodBeat.o(197);
    }

    public static void gY(boolean z) {
        AppMethodBeat.i(o.CTRL_INDEX);
        av.fly.ak("last_login_face_save_final_voice", String.valueOf(z));
        AppMethodBeat.o(o.CTRL_INDEX);
    }

    public static void gZ(boolean z) {
        AppMethodBeat.i(199);
        av.fly.ak("last_login_face_is_force_upload_face", String.valueOf(z));
        AppMethodBeat.o(199);
    }
}
