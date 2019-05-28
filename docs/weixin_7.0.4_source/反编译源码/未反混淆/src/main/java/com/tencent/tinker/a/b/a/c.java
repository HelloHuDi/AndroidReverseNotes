package com.tencent.tinker.a.b.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.d.h;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.plugin.appbrand.jsapi.l.i;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.b.a;
import com.tencent.tinker.a.c.b;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.d;
import com.tencent.wcdb.FileUtils;
import org.xwalk.core.XWalkEnvironment;

public final class c extends e {
    private final b AyZ = new b();
    private int Aza = 0;

    public c() {
        super(null);
    }

    private void RC(int i) {
        if (i != this.Aza) {
            b bVar = this.AyZ;
            int i2 = this.Aza;
            if (bVar.mSize == 0 || i > bVar.Ly[bVar.mSize - 1]) {
                bVar.Ly = b.h(bVar.Ly, bVar.mSize, i);
                bVar.Azj = b.h(bVar.Azj, bVar.mSize, i2);
                bVar.mSize++;
                return;
            }
            bVar.put(i, i2);
        }
    }

    public final int RD(int i) {
        int indexOfKey = this.AyZ.indexOfKey(i);
        if (indexOfKey < 0) {
            return i;
        }
        return this.AyZ.Azj[indexOfKey];
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j) {
        RC(i);
        switch (i2) {
            case -1:
            case 0:
            case 14:
                this.Aza++;
                return;
            case 36:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Aza += 3;
                return;
            case 40:
                byte b = i5 - this.Aza;
                if (b == ((byte) b)) {
                    this.Aza++;
                    return;
                } else if (b != ((short) b)) {
                    this.Aza += 3;
                    return;
                } else {
                    this.Aza += 2;
                    return;
                }
            case 41:
                short s = i5 - this.Aza;
                if (s != ((short) s)) {
                    this.Aza += 3;
                    return;
                } else {
                    this.Aza += 2;
                    return;
                }
            case 42:
                this.Aza += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.RG(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        RC(i);
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
            case 15:
            case 16:
            case 17:
            case 18:
            case 29:
            case 30:
            case 39:
                this.Aza++;
                return;
            case 19:
            case 21:
            case 22:
            case 25:
            case d.MIC_BASE_CHANNELSHARPEN /*28*/:
            case 31:
            case 34:
            case FileUtils.S_IRWXG /*56*/:
            case e.CTRL_INDEX /*57*/:
            case aa.CTRL_INDEX /*58*/:
            case au.CTRL_INDEX /*59*/:
            case 60:
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
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
                this.Aza += 2;
                return;
            case 20:
            case 23:
            case 36:
            case 38:
            case 43:
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Aza += 3;
                return;
            case 24:
                this.Aza += 5;
                return;
            case 26:
                if (i3 > CdnLogic.kBizGeneric) {
                    this.Aza += 3;
                    return;
                } else {
                    this.Aza += 2;
                    return;
                }
            case 27:
                this.Aza += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.RG(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        RC(i);
        switch (i2) {
            case 1:
            case 4:
            case 7:
            case 33:
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
                this.Aza++;
                return;
            case 2:
            case 5:
            case 8:
                this.Aza += 2;
                return;
            case 3:
            case 6:
            case 9:
            case 36:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Aza += 3;
                return;
            case 32:
            case 35:
            case 50:
            case 51:
            case 52:
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
            case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
            case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
            case 82:
            case 83:
            case com.tencent.mm.plugin.appbrand.jsapi.m.e.CTRL_INDEX /*84*/:
            case i.CTRL_INDEX /*85*/:
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
                this.Aza += 2;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.RG(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
        RC(i);
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Aza += 3;
                return;
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
            case 46:
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
            case 48:
            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
            case com.tencent.mm.plugin.appbrand.jsapi.b.i.CTRL_INDEX /*68*/:
            case 69:
            case 70:
            case 71:
            case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*72*/:
            case com.tencent.mm.plugin.appbrand.jsapi.share.c.CTRL_INDEX /*73*/:
            case 74:
            case 75:
            case 76:
            case 77:
            case h.a.CTRL_INDEX /*78*/:
            case JsApiOperateWXData.CTRL_INDEX /*79*/:
            case 80:
            case 81:
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
                this.Aza += 2;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.RG(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
        RC(i);
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Aza += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.RG(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
        RC(i);
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Aza += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.RG(i2));
        }
    }

    public final void b(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        RC(i);
        switch (i2) {
            case g.CTRL_INDEX /*37*/:
            case 116:
            case d.MIC_ALPHA_ADJUST_REAL /*117*/:
            case 118:
            case d.MIC_AVROUND_BLUR /*119*/:
            case 120:
                this.Aza += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.RG(i2));
        }
    }

    public final void a(int i, int i2, int[] iArr, int[] iArr2) {
        RC(i);
        this.Aza += 2;
        this.Aza += iArr.length * 2;
        this.Aza += iArr2.length * 2;
    }

    public final void a(int i, int i2, int i3, int[] iArr) {
        RC(i);
        this.Aza += 4;
        this.Aza += iArr.length * 2;
    }

    public final void a(int i, int i2, Object obj, int i3, int i4) {
        RC(i);
        this.Aza += 4;
        switch (i4) {
            case 1:
                int length = ((byte[]) obj).length;
                this.Aza = ((length & 1) + (length >> 1)) + this.Aza;
                return;
            case 2:
                this.Aza += ((short[]) obj).length * 1;
                return;
            case 4:
                this.Aza += ((int[]) obj).length * 2;
                return;
            case 8:
                this.Aza += ((long[]) obj).length * 4;
                return;
            default:
                throw new j("bogus element_width: " + a.RF(i4));
        }
    }
}
