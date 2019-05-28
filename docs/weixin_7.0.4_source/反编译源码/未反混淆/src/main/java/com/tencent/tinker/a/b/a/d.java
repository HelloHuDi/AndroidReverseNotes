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
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.appbrand.jsapi.d.h;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.plugin.appbrand.jsapi.k.a;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.plugin.appbrand.jsapi.l.i;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tinker.a.a.j;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.wcdb.FileUtils;
import org.xwalk.core.XWalkEnvironment;

public final class d {
    private final g Azb;

    public d(g gVar) {
        this.Azb = gVar;
    }

    public final void a(e eVar) {
        g gVar = this.Azb;
        gVar.AyY.mSize = 0;
        gVar.akp = 0;
        while (true) {
            Object obj;
            gVar = this.Azb;
            if (gVar.akp < gVar.Azg.length) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                int i = this.Azb.akp;
                int read = this.Azb.read();
                int i2 = read & 255;
                if (i2 == 0 || i2 == 255) {
                    i2 = read;
                }
                int i3;
                int i4;
                int read2;
                int i5;
                int i6;
                int RB;
                int readInt;
                int[] iArr;
                switch (i2) {
                    case -1:
                        eVar.a(i, read, 0, 1, 0, 0);
                        break;
                    case 0:
                    case 14:
                        eVar.a(i, read & 255, 0, 1, 0, (long) b.Ry(read));
                        break;
                    case 1:
                    case 4:
                    case 7:
                    case 33:
                    case 123:
                    case 124:
                    case 125:
                    case 126:
                    case com.tencent.view.d.MIC_SketchMark /*127*/:
                    case 128:
                    case GmsClientSupervisor.DEFAULT_BIND_FLAGS /*129*/:
                    case 130:
                    case 131:
                    case 132:
                    case e.CTRL_INDEX /*133*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX /*134*/:
                    case b.CTRL_INDEX /*135*/:
                    case n.CTRL_INDEX /*136*/:
                    case 137:
                    case 138:
                    case a.CTRL_INDEX /*139*/:
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
                        eVar.a(i, read & 255, 0, 1, 0, 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case 2:
                    case 5:
                    case 8:
                        eVar.a(i, read & 255, 0, 1, 0, 0, b.Ry(read), this.Azb.read());
                        break;
                    case 3:
                    case 6:
                    case 9:
                        eVar.a(i, read & 255, 0, 1, 0, (long) b.Ry(read), this.Azb.read(), this.Azb.read());
                        break;
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
                        eVar.a(i, read & 255, 0, 1, 0, 0, b.Ry(read));
                        break;
                    case 18:
                        eVar.a(i, read & 255, 0, 1, 0, (long) ((((read >> 12) & 15) << 28) >> 28), (read >> 8) & 15);
                        break;
                    case 19:
                    case 22:
                        eVar.a(i, read & 255, 0, 1, 0, (long) ((short) this.Azb.read()), b.Ry(read));
                        break;
                    case 20:
                    case 23:
                        eVar.a(i, read & 255, 0, 1, 0, (long) this.Azb.readInt(), b.Ry(read));
                        break;
                    case 21:
                    case 25:
                        i3 = read & 255;
                        eVar.a(i, i3, 0, 1, 0, ((long) ((short) this.Azb.read())) << (i3 == 21 ? 16 : 48), b.Ry(read));
                        break;
                    case 24:
                        eVar.a(i, read & 255, 0, 1, 0, this.Azb.readLong(), b.Ry(read));
                        break;
                    case 26:
                    case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
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
                        i3 = read & 255;
                        eVar.a(i, i3, this.Azb.read(), b.RB(i3), 0, 0, b.Ry(read));
                        break;
                    case 27:
                        i3 = read & 255;
                        eVar.a(i, i3, this.Azb.readInt(), b.RB(i3), 0, 0, b.Ry(read));
                        break;
                    case 32:
                    case 35:
                    case 82:
                    case 83:
                    case com.tencent.mm.plugin.appbrand.jsapi.m.e.CTRL_INDEX /*84*/:
                    case i.CTRL_INDEX /*85*/:
                    case 86:
                    case com.tencent.view.d.MIC_COLORPENCIL /*87*/:
                    case 88:
                    case PlayerException.EXCEPTION_IN_CHECK_STATE /*89*/:
                    case 90:
                    case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                    case 92:
                    case PlayerException.EXCEPTION_IN_PAUSE /*93*/:
                    case 94:
                    case 95:
                        i4 = read & 255;
                        eVar.a(i, i4, this.Azb.read(), b.RB(i4), 0, 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case 36:
                    case 110:
                    case 111:
                    case 112:
                    case 113:
                    case 114:
                        int i7 = read & 255;
                        int i8 = (read >> 8) & 15;
                        i2 = (read >> 12) & 15;
                        read2 = this.Azb.read();
                        read = this.Azb.read();
                        i5 = read & 15;
                        i3 = (read >> 4) & 15;
                        i4 = (read >> 8) & 15;
                        i6 = (read >> 12) & 15;
                        RB = b.RB(i7);
                        switch (i2) {
                            case 0:
                                eVar.a(i, i7, read2, RB, 0, 0);
                                break;
                            case 1:
                                eVar.a(i, i7, read2, RB, 0, 0, i5);
                                break;
                            case 2:
                                eVar.a(i, i7, read2, RB, 0, 0, i5, i3);
                                break;
                            case 3:
                                eVar.a(i, i7, read2, RB, 0, 0, i5, i3, i4);
                                break;
                            case 4:
                                eVar.a(i, i7, read2, RB, 0, 0, i5, i3, i4, i6);
                                break;
                            case 5:
                                eVar.a(i, i7, read2, RB, 0, 0, i5, i3, i4, i6, i8);
                                break;
                            default:
                                throw new j("bogus registerCount: " + new String(new char[]{Character.forDigit(i2 & 15, 16)}));
                        }
                    case g.CTRL_INDEX /*37*/:
                    case 116:
                    case com.tencent.view.d.MIC_ALPHA_ADJUST_REAL /*117*/:
                    case 118:
                    case com.tencent.view.d.MIC_AVROUND_BLUR /*119*/:
                    case 120:
                        i4 = read & 255;
                        eVar.b(i, i4, this.Azb.read(), b.RB(i4), 0, 0, this.Azb.read(), b.Ry(read));
                        break;
                    case 38:
                    case 43:
                    case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                        i3 = read & 255;
                        i5 = b.Ry(read);
                        readInt = i + this.Azb.readInt();
                        switch (i3) {
                            case 43:
                            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                                this.Azb.hZ(readInt + 1, i);
                                break;
                        }
                        eVar.a(i, i3, 0, 1, readInt, 0, i5);
                        break;
                    case 40:
                        eVar.a(i, read & 255, 0, 1, i + ((byte) b.Ry(read)), 0);
                        break;
                    case 41:
                        eVar.a(i, read & 255, 0, 1, i + ((short) this.Azb.read()), (long) b.Ry(read));
                        break;
                    case 42:
                        eVar.a(i, read & 255, 0, 1, i + this.Azb.readInt(), (long) b.Ry(read));
                        break;
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
                        i6 = read & 255;
                        i5 = b.Ry(read);
                        i2 = this.Azb.read();
                        eVar.a(i, i6, 0, 1, 0, 0, i5, i2 & 255, b.Ry(i2));
                        break;
                    case 50:
                    case 51:
                    case 52:
                    case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                        eVar.a(i, read & 255, 0, 1, i + ((short) this.Azb.read()), 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case FileUtils.S_IRWXG /*56*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX /*57*/:
                    case aa.CTRL_INDEX /*58*/:
                    case au.CTRL_INDEX /*59*/:
                    case 60:
                    case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                        eVar.a(i, read & 255, 0, 1, i + ((short) this.Azb.read()), 0, b.Ry(read));
                        break;
                    case 208:
                    case 209:
                    case 210:
                    case 211:
                    case 212:
                    case 213:
                    case 214:
                    case 215:
                        eVar.a(i, read & 255, 0, 1, 0, (long) ((short) this.Azb.read()), (read >> 8) & 15, (read >> 12) & 15);
                        break;
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
                        i4 = read & 255;
                        i5 = b.Ry(read);
                        i2 = this.Azb.read();
                        eVar.a(i, i4, 0, 1, 0, (long) ((byte) b.Ry(i2)), i5, i2 & 255);
                        break;
                    case 256:
                        read2 = this.Azb.dSb();
                        RB = this.Azb.read();
                        readInt = this.Azb.readInt();
                        iArr = new int[RB];
                        for (i2 = 0; i2 < RB; i2++) {
                            iArr[i2] = this.Azb.readInt() + read2;
                        }
                        eVar.a(i, read, readInt, iArr);
                        break;
                    case 512:
                        read2 = this.Azb.dSb();
                        RB = this.Azb.read();
                        int[] iArr2 = new int[RB];
                        iArr = new int[RB];
                        for (i2 = 0; i2 < RB; i2++) {
                            iArr2[i2] = this.Azb.readInt();
                        }
                        for (i2 = 0; i2 < RB; i2++) {
                            iArr[i2] = this.Azb.readInt() + read2;
                        }
                        eVar.a(i, read, iArr2, iArr);
                        break;
                    case 768:
                        i2 = this.Azb.read();
                        i5 = this.Azb.readInt();
                        switch (i2) {
                            case 1:
                                byte[] bArr = new byte[i5];
                                i2 = 0;
                                int i9 = 0;
                                Object obj2 = 1;
                                while (i9 < i5) {
                                    if (obj2 != null) {
                                        i2 = this.Azb.read();
                                    }
                                    bArr[i9] = (byte) (i2 & 255);
                                    i9++;
                                    i2 >>= 8;
                                    obj2 = obj2 == null ? 1 : null;
                                }
                                eVar.a(i, read, bArr, bArr.length, 1);
                                break;
                            case 2:
                                short[] sArr = new short[i5];
                                for (i2 = 0; i2 < i5; i2++) {
                                    sArr[i2] = (short) this.Azb.read();
                                }
                                eVar.a(i, read, sArr, sArr.length, 2);
                                break;
                            case 4:
                                int[] iArr3 = new int[i5];
                                for (i2 = 0; i2 < i5; i2++) {
                                    iArr3[i2] = this.Azb.readInt();
                                }
                                eVar.a(i, read, iArr3, iArr3.length, 4);
                                break;
                            case 8:
                                long[] jArr = new long[i5];
                                for (i2 = 0; i2 < i5; i2++) {
                                    jArr[i2] = this.Azb.readLong();
                                }
                                eVar.a(i, read, jArr, jArr.length, 8);
                                break;
                            default:
                                throw new j("bogus element_width: " + com.tencent.tinker.a.b.b.a.RF(i2));
                        }
                    default:
                        throw new IllegalStateException("Unknown opcode: " + com.tencent.tinker.a.b.b.a.RE(i2));
                }
            }
            return;
        }
    }
}
