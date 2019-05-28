package com.tencent.tinker.a.b.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.appbrand.jsapi.d.h;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.b.a;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.d;
import com.tencent.wcdb.FileUtils;
import org.xwalk.core.XWalkEnvironment;

public final class b {
    public static short ia(int i, int i2) {
        if ((i & -256) != 0) {
            throw new IllegalArgumentException("bogus lowByte");
        } else if ((i2 & -256) == 0) {
            return (short) ((i2 << 8) | i);
        } else {
            throw new IllegalArgumentException("bogus highByte");
        }
    }

    public static short O(int i, int i2, int i3, int i4) {
        if ((i & -16) != 0) {
            throw new IllegalArgumentException("bogus nibble0");
        } else if ((i2 & -16) != 0) {
            throw new IllegalArgumentException("bogus nibble1");
        } else if ((i3 & -16) != 0) {
            throw new IllegalArgumentException("bogus nibble2");
        } else if ((i4 & -16) == 0) {
            return (short) ((((i2 << 4) | i) | (i3 << 8)) | (i4 << 12));
        } else {
            throw new IllegalArgumentException("bogus nibble3");
        }
    }

    public static int ib(int i, int i2) {
        if ((i & -16) != 0) {
            throw new IllegalArgumentException("bogus lowNibble");
        } else if ((i2 & -16) == 0) {
            return (i2 << 4) | i;
        } else {
            throw new IllegalArgumentException("bogus highNibble");
        }
    }

    public static short Rx(int i) {
        if ((-65536 & i) == 0) {
            return (short) i;
        }
        throw new IllegalArgumentException("bogus unsigned code unit");
    }

    public static int Ry(int i) {
        return (i >> 8) & 255;
    }

    public static short nE(long j) {
        if (j == ((long) ((short) ((int) j)))) {
            return (short) ((int) j);
        }
        throw new j("Literal out of range: " + a.nF(j));
    }

    public static short Rz(int i) {
        if ((-65536 & i) == 0) {
            return (short) i;
        }
        throw new j("Register A out of range: " + a.nF((long) i));
    }

    public static short RA(int i) {
        if ((-65536 & i) == 0) {
            return (short) i;
        }
        throw new j("Register B out of range: " + a.nF((long) i));
    }

    public static int RB(int i) {
        switch (i) {
            case -1:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 29:
            case 30:
            case 33:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
            case 46:
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
            case 48:
            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
            case 50:
            case 51:
            case 52:
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
            case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
            case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
            case FileUtils.S_IRWXG /*56*/:
            case e.CTRL_INDEX /*57*/:
            case aa.CTRL_INDEX /*58*/:
            case au.CTRL_INDEX /*59*/:
            case 60:
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
            case i.CTRL_INDEX /*68*/:
            case 69:
            case 70:
            case 71:
            case c.CTRL_INDEX /*72*/:
            case com.tencent.mm.plugin.appbrand.jsapi.share.c.CTRL_INDEX /*73*/:
            case 74:
            case 75:
            case 76:
            case 77:
            case h.a.CTRL_INDEX /*78*/:
            case JsApiOperateWXData.CTRL_INDEX /*79*/:
            case 80:
            case 81:
            case 123:
            case 124:
            case 125:
            case 126:
            case d.MIC_SketchMark /*127*/:
            case 128:
            case GmsClientSupervisor.DEFAULT_BIND_FLAGS /*129*/:
            case 130:
            case 131:
            case 132:
            case com.tencent.mm.plugin.appbrand.jsapi.g.e.CTRL_INDEX /*133*/:
            case com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX /*134*/:
            case com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX /*135*/:
            case n.CTRL_INDEX /*136*/:
            case 137:
            case 138:
            case com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX /*139*/:
            case 140:
            case 141:
            case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
            case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
            case 144:
            case 145:
            case 146:
            case ErrorCode.NEEDDOWNLOAD_8 /*147*/:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION /*153*/:
            case JsApiMakeVoIPCall.CTRL_INDEX /*154*/:
            case 155:
            case 156:
            case 157:
            case 158:
            case JsApiGetBackgroundAudioState.CTRL_INDEX /*159*/:
            case 160:
            case 161:
            case ErrorCode.STARTDOWNLOAD_3 /*162*/:
            case ErrorCode.STARTDOWNLOAD_4 /*163*/:
            case ErrorCode.STARTDOWNLOAD_5 /*164*/:
            case ErrorCode.STARTDOWNLOAD_6 /*165*/:
            case 166:
            case ErrorCode.STARTDOWNLOAD_8 /*167*/:
            case 168:
            case 169:
            case ErrorCode.NEEDDOWNLOAD_TRUE /*170*/:
            case ErrorCode.NEEDDOWNLOAD_FALSE_1 /*171*/:
            case ErrorCode.NEEDDOWNLOAD_FALSE_2 /*172*/:
            case ErrorCode.NEEDDOWNLOAD_FALSE_3 /*173*/:
            case ErrorCode.NEEDDOWNLOAD_FALSE_4 /*174*/:
            case ErrorCode.NEEDDOWNLOAD_FALSE_5 /*175*/:
            case ErrorCode.NEEDDOWNLOAD_FALSE_6 /*176*/:
            case ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING /*177*/:
            case 178:
            case 179:
            case 180:
            case 181:
            case FaceMoveUtil.TRIANGLE_COUNT /*182*/:
            case 183:
            case FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE /*184*/:
            case 185:
            case 186:
            case 187:
            case 188:
            case 189:
            case FacebookRequestErrorClassification.EC_INVALID_TOKEN /*190*/:
            case 191:
            case az.CTRL_INDEX /*192*/:
            case JsApiChooseMedia.CTRL_INDEX /*193*/:
            case JsApiUploadEncryptedFileToCDN.CTRL_INDEX /*194*/:
            case JsApiChooseWeChatContact.CTRL_INDEX /*195*/:
            case 196:
            case 197:
            case o.CTRL_INDEX /*198*/:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
            case 205:
            case 206:
            case 207:
            case 208:
            case 209:
            case 210:
            case 211:
            case 212:
            case 213:
            case 214:
            case 215:
            case 216:
            case 217:
            case 218:
            case 219:
            case 220:
            case 221:
            case 222:
            case 223:
            case 224:
            case 225:
            case 226:
            case 256:
            case 512:
            case 768:
                return 1;
            case 26:
            case 27:
                return 3;
            case d.MIC_BASE_CHANNELSHARPEN /*28*/:
            case 31:
            case 32:
            case 34:
            case 35:
            case 36:
            case g.CTRL_INDEX /*37*/:
                return 2;
            case 82:
            case 83:
            case com.tencent.mm.plugin.appbrand.jsapi.m.e.CTRL_INDEX /*84*/:
            case com.tencent.mm.plugin.appbrand.jsapi.l.i.CTRL_INDEX /*85*/:
            case 86:
            case d.MIC_COLORPENCIL /*87*/:
            case 88:
            case PlayerException.EXCEPTION_IN_CHECK_STATE /*89*/:
            case 90:
            case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
            case 92:
            case PlayerException.EXCEPTION_IN_PAUSE /*93*/:
            case 94:
            case 95:
            case 96:
            case PlayerException.EXCEPTION_IN_RELEASE /*97*/:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
                return 5;
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 116:
            case d.MIC_ALPHA_ADJUST_REAL /*117*/:
            case 118:
            case d.MIC_AVROUND_BLUR /*119*/:
            case 120:
                return 4;
            default:
                return 0;
        }
    }

    public static short ic(int i, int i2) {
        short s = i - i2;
        if (s == ((short) s)) {
            return (short) s;
        }
        throw new j("Target out of range: " + a.RH(s) + ", perhaps you need to enable force jumbo mode.");
    }
}
