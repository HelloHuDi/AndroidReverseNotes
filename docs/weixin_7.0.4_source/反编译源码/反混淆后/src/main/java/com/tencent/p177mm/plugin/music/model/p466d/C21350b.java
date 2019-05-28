package com.tencent.p177mm.plugin.music.model.p466d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.plugin.music.model.d.b */
public final class C21350b {
    /* renamed from: zM */
    public static int m32752zM(int i) {
        AppMethodBeat.m2504i(105007);
        C4990ab.m7416i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerErrIdKey, errCode:".concat(String.valueOf(i)));
        switch (i) {
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                AppMethodBeat.m2505o(105007);
                return 17;
            case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                AppMethodBeat.m2505o(105007);
                return 18;
            case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                AppMethodBeat.m2505o(105007);
                return 19;
            case 62:
                AppMethodBeat.m2505o(105007);
                return 20;
            case 63:
                AppMethodBeat.m2505o(105007);
                return 21;
            case 64:
                AppMethodBeat.m2505o(105007);
                return 22;
            case 66:
                AppMethodBeat.m2505o(105007);
                return 23;
            case 67:
                AppMethodBeat.m2505o(105007);
                return 24;
            case 69:
                AppMethodBeat.m2505o(105007);
                return 25;
            case 70:
                AppMethodBeat.m2505o(105007);
                return 36;
            case 74:
                AppMethodBeat.m2505o(105007);
                return 26;
            case 80:
                AppMethodBeat.m2505o(105007);
                return 27;
            case 101:
                AppMethodBeat.m2505o(105007);
                return 28;
            case 102:
                AppMethodBeat.m2505o(105007);
                return 29;
            case 500:
                AppMethodBeat.m2505o(105007);
                return 31;
            case 501:
                AppMethodBeat.m2505o(105007);
                return 32;
            case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE /*502*/:
                AppMethodBeat.m2505o(105007);
                return 33;
            case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS /*503*/:
                AppMethodBeat.m2505o(105007);
                return 34;
            case 504:
                AppMethodBeat.m2505o(105007);
                return 35;
            case 700:
                AppMethodBeat.m2505o(105007);
                return 37;
            case 701:
                AppMethodBeat.m2505o(105007);
                return 38;
            default:
                AppMethodBeat.m2505o(105007);
                return 30;
        }
    }

    /* renamed from: zN */
    public static int m32753zN(int i) {
        AppMethodBeat.m2504i(105008);
        C4990ab.m7416i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerErrIdKey, errCode:".concat(String.valueOf(i)));
        switch (i) {
            case 700:
                AppMethodBeat.m2505o(105008);
                return 45;
            case 701:
                AppMethodBeat.m2505o(105008);
                return 48;
            case 702:
                AppMethodBeat.m2505o(105008);
                return 39;
            case 703:
                AppMethodBeat.m2505o(105008);
                return 40;
            case 704:
                AppMethodBeat.m2505o(105008);
                return 41;
            case 705:
                AppMethodBeat.m2505o(105008);
                return 42;
            case 706:
                AppMethodBeat.m2505o(105008);
                return 43;
            case 707:
                AppMethodBeat.m2505o(105008);
                return 44;
            default:
                AppMethodBeat.m2505o(105008);
                return 189;
        }
    }

    /* renamed from: To */
    public static int m32751To(String str) {
        AppMethodBeat.m2504i(105009);
        if ("audio/3gpp".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105009);
            return 1;
        } else if ("audio/amr-wb".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105009);
            return 2;
        } else if ("audio/mpeg".equalsIgnoreCase(str) || "audio/mp3".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105009);
            return 3;
        } else if ("audio/mp4a-latm".equalsIgnoreCase(str) || str.startsWith("audio/mp4")) {
            AppMethodBeat.m2505o(105009);
            return 4;
        } else if ("audio/qcelp".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105009);
            return 5;
        } else if ("audio/vorbis".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105009);
            return 6;
        } else if ("audio/opus".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105009);
            return 7;
        } else if ("audio/g711-alaw".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105009);
            return 8;
        } else if ("audio/g711-mlaw".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105009);
            return 9;
        } else if ("audio/raw".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105009);
            return 10;
        } else if ("audio/flac".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105009);
            return 11;
        } else if ("audio/gsm".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105009);
            return 12;
        } else if ("audio/ac3".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105009);
            return 13;
        } else if ("audio/eac3".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105009);
            return 14;
        } else if ("audio/x-ms-wma".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105009);
            return 15;
        } else if ("audio/x-wav".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105009);
            return 16;
        } else if ("audio/x-ape".equalsIgnoreCase(str) || "application/x-ape".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105009);
            return 17;
        } else {
            AppMethodBeat.m2505o(105009);
            return 0;
        }
    }
}
