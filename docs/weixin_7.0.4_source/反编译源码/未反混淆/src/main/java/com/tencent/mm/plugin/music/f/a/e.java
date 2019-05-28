package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public final class e {
    public static int zS(int i) {
        AppMethodBeat.i(137653);
        ab.i("MicroMsg.PlayerErrorHandler", "getErrCodeType, errorCode: %d", Integer.valueOf(i));
        switch (i) {
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
            case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                AppMethodBeat.o(137653);
                return 10003;
            case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
            case 63:
            case 64:
            case 101:
            case 701:
            case 703:
            case 705:
                AppMethodBeat.o(137653);
                return 10004;
            case 62:
            case 66:
            case 67:
            case 69:
            case 70:
            case 74:
            case 102:
            case 702:
            case 704:
            case 706:
            case 707:
                AppMethodBeat.o(137653);
                return 10001;
            case 80:
                AppMethodBeat.o(137653);
                return 10002;
            case 500:
            case 501:
            case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE /*502*/:
            case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS /*503*/:
            case 504:
            case 600:
            case 601:
            case 602:
            case 603:
            case 604:
            case 605:
                AppMethodBeat.o(137653);
                return 10001;
            default:
                AppMethodBeat.o(137653);
                return -1;
        }
    }

    public static String ph(int i) {
        AppMethodBeat.i(137654);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("errCode:" + i + ", err:");
        switch (i) {
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                stringBuilder.append("file not found");
                break;
            case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                stringBuilder.append("file can not read");
                break;
            case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                stringBuilder.append("unknow format");
                break;
            case 62:
                stringBuilder.append("load or init native decode so fail");
                break;
            case 63:
                stringBuilder.append("get audio info fail");
                break;
            case 64:
                stringBuilder.append("invalid audio info");
                break;
            case 66:
                stringBuilder.append("create AudioTrack fail");
                break;
            case 67:
                stringBuilder.append("decode audio fail");
                break;
            case 69:
                stringBuilder.append("so file not found");
                break;
            case 70:
                stringBuilder.append("create temp file fail");
                break;
            case 74:
                stringBuilder.append("invalid seek or seek fail");
                break;
            case 80:
                stringBuilder.append("connect network fail");
                break;
            case 101:
                stringBuilder.append("recognition audio format error");
                break;
            case 102:
                stringBuilder.append("write AudioTrack data fail");
                break;
            case 500:
                stringBuilder.append("error URL format");
                break;
            case 501:
                stringBuilder.append("error player to prepare");
                break;
            case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE /*502*/:
                stringBuilder.append("error player to start");
                break;
            case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS /*503*/:
                stringBuilder.append("error player to pause");
                break;
            case 504:
                stringBuilder.append("error player to stop");
                break;
            case 600:
                stringBuilder.append("error create player fail, exceed max count audio players");
                break;
            case 601:
                stringBuilder.append("error, not found audioId");
                break;
            case 602:
                stringBuilder.append("error, not found param");
                break;
            case 603:
                stringBuilder.append("error, ready exist audioId");
                break;
            case 604:
                stringBuilder.append("error, invalid audioID");
                break;
            case 605:
                stringBuilder.append("error, invalid param");
                break;
            case 701:
                stringBuilder.append("error, invalid param");
                break;
            case 702:
                stringBuilder.append("error, mmplayer set source occur error");
                break;
            case 703:
                stringBuilder.append("error, mmplayer media format error");
                break;
            case 704:
                stringBuilder.append("error, mmplayer create MediaCode error");
                break;
            case 705:
                stringBuilder.append("error, mmplayer get audio info error");
                break;
            case 706:
                stringBuilder.append("error, mmplayer decode error");
                break;
            case 707:
                stringBuilder.append("error, mmplayer create audio track orror");
                break;
            default:
                stringBuilder.append("unknow exception");
                break;
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(137654);
        return stringBuilder2;
    }
}
