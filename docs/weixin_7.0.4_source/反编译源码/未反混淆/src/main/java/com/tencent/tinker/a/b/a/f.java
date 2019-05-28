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
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.appbrand.jsapi.d.h;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
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
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.d;
import com.tencent.wcdb.FileUtils;
import org.xwalk.core.XWalkEnvironment;

public final class f extends e {
    private final h Azd;
    private final c Aze;
    private final boolean Azf = true;

    public f(h hVar, c cVar) {
        super(null);
        this.Azd = hVar;
        this.Aze = cVar;
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j) {
        if (this.Azf) {
            i5 = this.Aze.RD(i5);
        }
        switch (i2) {
            case -1:
            case 0:
            case 14:
                this.Azd.c((short) i2);
                return;
            case 36:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Azd.a(b.ia(i2, b.ib(0, 0)), (short) i3, b.O(0, 0, 0, 0));
                return;
            case 40:
                byte b;
                if (this.Azf) {
                    b = i5 - this.Azd.akp;
                    if (b == ((byte) b)) {
                        this.Azd.c(b.ia(i2, b & 255));
                        return;
                    } else if (b != ((short) b)) {
                        this.Azd.a((short) 42, (short) b, (short) (b >> 16));
                        return;
                    } else {
                        this.Azd.c((short) 41, (short) b);
                        return;
                    }
                }
                b = i5 - this.Azd.akp;
                if (b != ((byte) b)) {
                    throw new j("Target out of range: " + a.RH(b) + ", perhaps you need to enable force jumbo mode.");
                }
                this.Azd.c(b.ia(i2, b & 255));
                return;
            case 41:
                short s;
                if (this.Azf) {
                    short s2 = i5 - this.Azd.akp;
                    if (s2 != ((short) s2)) {
                        this.Azd.a((short) 42, (short) s2, (short) (s2 >> 16));
                        return;
                    }
                    s = (short) i2;
                    this.Azd.c(s, (short) s2);
                    return;
                }
                s = (short) i2;
                this.Azd.c(s, b.ic(i5, this.Azd.akp));
                return;
            case 42:
                int i6 = i5 - this.Azd.akp;
                this.Azd.a((short) i2, (short) i6, (short) (i6 >> 16));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.RG(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        if (this.Azf) {
            i5 = this.Aze.RD(i5);
        }
        int i7;
        h hVar;
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
            case 15:
            case 16:
            case 17:
            case 29:
            case 30:
            case 39:
                this.Azd.c(b.ia(i2, i6));
                return;
            case 18:
                short s = (short) i2;
                h hVar2 = this.Azd;
                if (j < -8 || j > 7) {
                    throw new j("Literal out of range: " + a.nF(j));
                }
                hVar2.c(b.ia(s, b.ib(i6, ((int) j) & 15)));
                return;
            case 19:
            case 22:
                this.Azd.c(b.ia(i2, i6), b.nE(j));
                return;
            case 20:
            case 23:
                if (j != ((long) ((int) j))) {
                    throw new j("Literal out of range: " + a.nF(j));
                }
                i7 = (int) j;
                this.Azd.a(b.ia(i2, i6), (short) i7, (short) (i7 >> 16));
                return;
            case 21:
            case 25:
                this.Azd.c(b.ia(i2, i6), (short) ((int) (j >> (i2 == 21 ? 16 : 48))));
                return;
            case 24:
                hVar = this.Azd;
                short s2 = (short) ((int) j);
                short s3 = (short) ((int) (j >> 16));
                short s4 = (short) ((int) (j >> 32));
                short s5 = (short) ((int) (j >> 48));
                hVar.c(b.ia(i2, i6));
                hVar.c(s2);
                hVar.c(s3);
                hVar.c(s4);
                hVar.c(s5);
                return;
            case 26:
                if (this.Azf) {
                    if (i3 > CdnLogic.kBizGeneric) {
                        this.Azd.a(b.ia(27, i6), (short) i3, (short) (i3 >> 16));
                        return;
                    } else {
                        this.Azd.c(b.ia(i2, i6), (short) i3);
                        return;
                    }
                } else if (i3 > CdnLogic.kBizGeneric) {
                    throw new j("string index out of bound: " + a.RE(i3) + ", perhaps you need to enable force jumbo mode.");
                } else {
                    this.Azd.c(b.ia(i2, i6), (short) i3);
                    return;
                }
            case 27:
                this.Azd.a(b.ia(i2, i6), (short) i3, (short) (i3 >> 16));
                return;
            case d.MIC_BASE_CHANNELSHARPEN /*28*/:
            case 31:
            case 34:
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
                this.Azd.c(b.ia(i2, i6), (short) i3);
                return;
            case 36:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Azd.a(b.ia(i2, b.ib(0, 1)), (short) i3, b.O(i6, 0, 0, 0));
                return;
            case 38:
            case 43:
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                switch (i2) {
                    case 43:
                    case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                        hVar = this.Azd;
                        hVar.hZ(i5, hVar.akp);
                        break;
                }
                i7 = i5 - this.Azd.akp;
                this.Azd.a(b.ia(i2, i6), (short) i7, (short) (i7 >> 16));
                return;
            case FileUtils.S_IRWXG /*56*/:
            case e.CTRL_INDEX /*57*/:
            case aa.CTRL_INDEX /*58*/:
            case au.CTRL_INDEX /*59*/:
            case 60:
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                this.Azd.c(b.ia(i2, i6), b.ic(i5, this.Azd.akp));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.RG(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        if (this.Azf) {
            i5 = this.Aze.RD(i5);
        }
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
            case b.CTRL_INDEX /*135*/:
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
                this.Azd.c(b.ia((short) i2, b.ib(i6, i7)));
                return;
            case 2:
            case 5:
            case 8:
                this.Azd.c(b.ia(i2, i6), b.RA(i7));
                return;
            case 3:
            case 6:
            case 9:
                this.Azd.a((short) i2, b.Rz(i6), b.RA(i7));
                return;
            case 32:
            case 35:
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
                this.Azd.c(b.ia(i2, b.ib(i6, i7)), (short) i3);
                return;
            case 36:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Azd.a(b.ia(i2, b.ib(0, 2)), (short) i3, b.O(i6, i7, 0, 0));
                return;
            case 50:
            case 51:
            case 52:
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
            case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
            case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                this.Azd.c(b.ia(i2, b.ib(i6, i7)), b.ic(i5, this.Azd.akp));
                return;
            case 208:
            case 209:
            case 210:
            case 211:
            case 212:
            case 213:
            case 214:
            case 215:
                this.Azd.c(b.ia(i2, b.ib(i6, i7)), b.nE(j));
                return;
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
                h hVar = this.Azd;
                short ia = b.ia(i2, i6);
                if (j != ((long) ((byte) ((int) j)))) {
                    throw new j("Literal out of range: " + a.nF(j));
                }
                hVar.c(ia, b.ia(i7, ((int) j) & 255));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.RG(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Azd.a(b.ia(i2, b.ib(0, 3)), (short) i3, b.O(i6, i7, i8, 0));
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
                this.Azd.c(b.ia(i2, i6), b.ia(i7, i8));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.RG(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Azd.a(b.ia(i2, b.ib(0, 4)), (short) i3, b.O(i6, i7, i8, i9));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.RG(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.Azd.a(b.ia(i2, b.ib(i10, 5)), (short) i3, b.O(i6, i7, i8, i9));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.RG(i2));
        }
    }

    public final void b(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        switch (i2) {
            case g.CTRL_INDEX /*37*/:
            case 116:
            case d.MIC_ALPHA_ADJUST_REAL /*117*/:
            case 118:
            case d.MIC_AVROUND_BLUR /*119*/:
            case 120:
                this.Azd.a(b.ia(i2, i7), (short) i3, b.Rz(i6));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.RG(i2));
        }
    }

    public final void a(int i, int i2, int[] iArr, int[] iArr2) {
        int length;
        int i3 = 0;
        int dSb = this.Azd.dSb();
        this.Azd.c((short) i2);
        this.Azd.c(b.Rx(iArr2.length));
        for (int writeInt : iArr) {
            this.Azd.writeInt(writeInt);
        }
        if (this.Azf) {
            length = iArr2.length;
            while (i3 < length) {
                this.Azd.writeInt(this.Aze.RD(iArr2[i3]) - dSb);
                i3++;
            }
            return;
        }
        length = iArr2.length;
        while (i3 < length) {
            this.Azd.writeInt(iArr2[i3] - dSb);
            i3++;
        }
    }

    public final void a(int i, int i2, int i3, int[] iArr) {
        int i4 = 0;
        int dSb = this.Azd.dSb();
        this.Azd.c((short) i2);
        this.Azd.c(b.Rx(iArr.length));
        this.Azd.writeInt(i3);
        int length;
        if (this.Azf) {
            length = iArr.length;
            while (i4 < length) {
                this.Azd.writeInt(this.Aze.RD(iArr[i4]) - dSb);
                i4++;
            }
            return;
        }
        length = iArr.length;
        while (i4 < length) {
            this.Azd.writeInt(iArr[i4] - dSb);
            i4++;
        }
    }

    public final void a(int i, int i2, Object obj, int i3, int i4) {
        int i5 = 0;
        this.Azd.c((short) i2);
        this.Azd.c((short) i4);
        this.Azd.writeInt(i3);
        h hVar;
        int length;
        switch (i4) {
            case 1:
                h hVar2 = this.Azd;
                int i6 = 1;
                int i7 = 0;
                for (byte b : (byte[]) obj) {
                    if (i6 != 0) {
                        i7 = b & 255;
                        i6 = 0;
                    } else {
                        i7 |= b << 8;
                        hVar2.c((short) i7);
                        i6 = 1;
                    }
                }
                if (i6 == 0) {
                    hVar2.c((short) i7);
                    return;
                }
                return;
            case 2:
                hVar = this.Azd;
                short[] sArr = (short[]) obj;
                length = sArr.length;
                while (i5 < length) {
                    hVar.c(sArr[i5]);
                    i5++;
                }
                return;
            case 4:
                hVar = this.Azd;
                int[] iArr = (int[]) obj;
                length = iArr.length;
                while (i5 < length) {
                    hVar.writeInt(iArr[i5]);
                    i5++;
                }
                return;
            case 8:
                hVar = this.Azd;
                long[] jArr = (long[]) obj;
                length = jArr.length;
                while (i5 < length) {
                    long j = jArr[i5];
                    hVar.c((short) ((int) j));
                    hVar.c((short) ((int) (j >> 16)));
                    hVar.c((short) ((int) (j >> 32)));
                    hVar.c((short) ((int) (j >> 48)));
                    i5++;
                }
                return;
            default:
                throw new j("bogus element_width: " + a.RF(i4));
        }
    }
}
