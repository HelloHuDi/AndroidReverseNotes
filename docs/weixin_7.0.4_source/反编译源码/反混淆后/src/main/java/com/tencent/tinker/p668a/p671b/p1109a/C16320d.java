package com.tencent.tinker.p668a.p671b.p1109a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2206au;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42464aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C33279c;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C42477i;
import com.tencent.p177mm.plugin.appbrand.jsapi.p303d.C33289h.C33294a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27011o;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p311m.C38339e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C19410e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C33345i;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C27077c;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tinker.p668a.p669a.C36548j;
import com.tencent.tinker.p668a.p671b.p672b.C5917a;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.C31128d;
import com.tencent.wcdb.FileUtils;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.tinker.a.b.a.d */
public final class C16320d {
    private final C46813g Azb;

    public C16320d(C46813g c46813g) {
        this.Azb = c46813g;
    }

    /* renamed from: a */
    public final void mo29592a(C46812e c46812e) {
        C46813g c46813g = this.Azb;
        c46813g.AyY.mSize = 0;
        c46813g.akp = 0;
        while (true) {
            Object obj;
            c46813g = this.Azb;
            if (c46813g.akp < c46813g.Azg.length) {
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
                        c46812e.mo12591a(i, read, 0, 1, 0, 0);
                        break;
                    case 0:
                    case 14:
                        c46812e.mo12591a(i, read & 255, 0, 1, 0, (long) C16319b.m25150Ry(read));
                        break;
                    case 1:
                    case 4:
                    case 7:
                    case 33:
                    case 123:
                    case 124:
                    case 125:
                    case 126:
                    case C31128d.MIC_SketchMark /*127*/:
                    case 128:
                    case GmsClientSupervisor.DEFAULT_BIND_FLAGS /*129*/:
                    case 130:
                    case 131:
                    case 132:
                    case C19394e.CTRL_INDEX /*133*/:
                    case C19392d.CTRL_INDEX /*134*/:
                    case C44697b.CTRL_INDEX /*135*/:
                    case C19395n.CTRL_INDEX /*136*/:
                    case 137:
                    case 138:
                    case C33333a.CTRL_INDEX /*139*/:
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
                    case C33250az.CTRL_INDEX /*192*/:
                    case JsApiChooseMedia.CTRL_INDEX /*193*/:
                    case JsApiUploadEncryptedFileToCDN.CTRL_INDEX /*194*/:
                    case JsApiChooseWeChatContact.CTRL_INDEX /*195*/:
                    case 196:
                    case 197:
                    case C27011o.CTRL_INDEX /*198*/:
                    case 199:
                    case 200:
                    case 201:
                    case 202:
                    case 203:
                    case 204:
                    case 205:
                    case 206:
                    case 207:
                        c46812e.mo12593a(i, read & 255, 0, 1, 0, 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case 2:
                    case 5:
                    case 8:
                        c46812e.mo12593a(i, read & 255, 0, 1, 0, 0, C16319b.m25150Ry(read), this.Azb.read());
                        break;
                    case 3:
                    case 6:
                    case 9:
                        c46812e.mo12593a(i, read & 255, 0, 1, 0, (long) C16319b.m25150Ry(read), this.Azb.read(), this.Azb.read());
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
                        c46812e.mo12592a(i, read & 255, 0, 1, 0, 0, C16319b.m25150Ry(read));
                        break;
                    case 18:
                        c46812e.mo12592a(i, read & 255, 0, 1, 0, (long) ((((read >> 12) & 15) << 28) >> 28), (read >> 8) & 15);
                        break;
                    case 19:
                    case 22:
                        c46812e.mo12592a(i, read & 255, 0, 1, 0, (long) ((short) this.Azb.read()), C16319b.m25150Ry(read));
                        break;
                    case 20:
                    case 23:
                        c46812e.mo12592a(i, read & 255, 0, 1, 0, (long) this.Azb.readInt(), C16319b.m25150Ry(read));
                        break;
                    case 21:
                    case 25:
                        i3 = read & 255;
                        c46812e.mo12592a(i, i3, 0, 1, 0, ((long) ((short) this.Azb.read())) << (i3 == 21 ? 16 : 48), C16319b.m25150Ry(read));
                        break;
                    case 24:
                        c46812e.mo12592a(i, read & 255, 0, 1, 0, this.Azb.readLong(), C16319b.m25150Ry(read));
                        break;
                    case 26:
                    case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
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
                        c46812e.mo12592a(i, i3, this.Azb.read(), C16319b.m25148RB(i3), 0, 0, C16319b.m25150Ry(read));
                        break;
                    case 27:
                        i3 = read & 255;
                        c46812e.mo12592a(i, i3, this.Azb.readInt(), C16319b.m25148RB(i3), 0, 0, C16319b.m25150Ry(read));
                        break;
                    case 32:
                    case 35:
                    case 82:
                    case 83:
                    case C38339e.CTRL_INDEX /*84*/:
                    case C33345i.CTRL_INDEX /*85*/:
                    case 86:
                    case C31128d.MIC_COLORPENCIL /*87*/:
                    case 88:
                    case PlayerException.EXCEPTION_IN_CHECK_STATE /*89*/:
                    case 90:
                    case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                    case 92:
                    case PlayerException.EXCEPTION_IN_PAUSE /*93*/:
                    case 94:
                    case 95:
                        i4 = read & 255;
                        c46812e.mo12593a(i, i4, this.Azb.read(), C16319b.m25148RB(i4), 0, 0, (read >> 8) & 15, (read >> 12) & 15);
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
                        RB = C16319b.m25148RB(i7);
                        switch (i2) {
                            case 0:
                                c46812e.mo12591a(i, i7, read2, RB, 0, 0);
                                break;
                            case 1:
                                c46812e.mo12592a(i, i7, read2, RB, 0, 0, i5);
                                break;
                            case 2:
                                c46812e.mo12593a(i, i7, read2, RB, 0, 0, i5, i3);
                                break;
                            case 3:
                                c46812e.mo12594a(i, i7, read2, RB, 0, 0, i5, i3, i4);
                                break;
                            case 4:
                                c46812e.mo12595a(i, i7, read2, RB, 0, 0, i5, i3, i4, i6);
                                break;
                            case 5:
                                c46812e.mo12596a(i, i7, read2, RB, 0, 0, i5, i3, i4, i6, i8);
                                break;
                            default:
                                throw new C36548j("bogus registerCount: " + new String(new char[]{Character.forDigit(i2 & 15, 16)}));
                        }
                    case C2275g.CTRL_INDEX /*37*/:
                    case 116:
                    case C31128d.MIC_ALPHA_ADJUST_REAL /*117*/:
                    case 118:
                    case C31128d.MIC_AVROUND_BLUR /*119*/:
                    case 120:
                        i4 = read & 255;
                        c46812e.mo12597b(i, i4, this.Azb.read(), C16319b.m25148RB(i4), 0, 0, this.Azb.read(), C16319b.m25150Ry(read));
                        break;
                    case 38:
                    case 43:
                    case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                        i3 = read & 255;
                        i5 = C16319b.m25150Ry(read);
                        readInt = i + this.Azb.readInt();
                        switch (i3) {
                            case 43:
                            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                                this.Azb.mo29591hZ(readInt + 1, i);
                                break;
                        }
                        c46812e.mo12592a(i, i3, 0, 1, readInt, 0, i5);
                        break;
                    case 40:
                        c46812e.mo12591a(i, read & 255, 0, 1, i + ((byte) C16319b.m25150Ry(read)), 0);
                        break;
                    case 41:
                        c46812e.mo12591a(i, read & 255, 0, 1, i + ((short) this.Azb.read()), (long) C16319b.m25150Ry(read));
                        break;
                    case 42:
                        c46812e.mo12591a(i, read & 255, 0, 1, i + this.Azb.readInt(), (long) C16319b.m25150Ry(read));
                        break;
                    case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                    case 46:
                    case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    case 48:
                    case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    case C42477i.CTRL_INDEX /*68*/:
                    case 69:
                    case 70:
                    case 71:
                    case C33279c.CTRL_INDEX /*72*/:
                    case C27077c.CTRL_INDEX /*73*/:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case C33294a.CTRL_INDEX /*78*/:
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
                        i5 = C16319b.m25150Ry(read);
                        i2 = this.Azb.read();
                        c46812e.mo12594a(i, i6, 0, 1, 0, 0, i5, i2 & 255, C16319b.m25150Ry(i2));
                        break;
                    case 50:
                    case 51:
                    case 52:
                    case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                        c46812e.mo12593a(i, read & 255, 0, 1, i + ((short) this.Azb.read()), 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case FileUtils.S_IRWXG /*56*/:
                    case C19410e.CTRL_INDEX /*57*/:
                    case C42464aa.CTRL_INDEX /*58*/:
                    case C2206au.CTRL_INDEX /*59*/:
                    case 60:
                    case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                        c46812e.mo12592a(i, read & 255, 0, 1, i + ((short) this.Azb.read()), 0, C16319b.m25150Ry(read));
                        break;
                    case 208:
                    case 209:
                    case 210:
                    case 211:
                    case 212:
                    case 213:
                    case 214:
                    case 215:
                        c46812e.mo12593a(i, read & 255, 0, 1, 0, (long) ((short) this.Azb.read()), (read >> 8) & 15, (read >> 12) & 15);
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
                        i5 = C16319b.m25150Ry(read);
                        i2 = this.Azb.read();
                        c46812e.mo12593a(i, i4, 0, 1, 0, (long) ((byte) C16319b.m25150Ry(i2)), i5, i2 & 255);
                        break;
                    case 256:
                        read2 = this.Azb.dSb();
                        RB = this.Azb.read();
                        readInt = this.Azb.readInt();
                        iArr = new int[RB];
                        for (i2 = 0; i2 < RB; i2++) {
                            iArr[i2] = this.Azb.readInt() + read2;
                        }
                        c46812e.mo50546a(i, read, readInt, iArr);
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
                        c46812e.mo50548a(i, read, iArr2, iArr);
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
                                c46812e.mo50547a(i, read, bArr, bArr.length, 1);
                                break;
                            case 2:
                                short[] sArr = new short[i5];
                                for (i2 = 0; i2 < i5; i2++) {
                                    sArr[i2] = (short) this.Azb.read();
                                }
                                c46812e.mo50547a(i, read, sArr, sArr.length, 2);
                                break;
                            case 4:
                                int[] iArr3 = new int[i5];
                                for (i2 = 0; i2 < i5; i2++) {
                                    iArr3[i2] = this.Azb.readInt();
                                }
                                c46812e.mo50547a(i, read, iArr3, iArr3.length, 4);
                                break;
                            case 8:
                                long[] jArr = new long[i5];
                                for (i2 = 0; i2 < i5; i2++) {
                                    jArr[i2] = this.Azb.readLong();
                                }
                                c46812e.mo50547a(i, read, jArr, jArr.length, 8);
                                break;
                            default:
                                throw new C36548j("bogus element_width: " + C5917a.m9201RF(i2));
                        }
                    default:
                        throw new IllegalStateException("Unknown opcode: " + C5917a.m9200RE(i2));
                }
            }
            return;
        }
    }
}
