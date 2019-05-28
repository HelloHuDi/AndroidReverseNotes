package com.tencent.mm.plugin.music.model.d;

import android.text.TextUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.plugin.music.c.b;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.ArrayList;
import org.xwalk.core.XWalkEnvironment;

public final class e implements d {
    private f oNn = new f();
    private c oNo = new c();
    private a oNp = new a();

    public e() {
        AppMethodBeat.i(105021);
        AppMethodBeat.o(105021);
    }

    public final void s(com.tencent.mm.aw.e eVar) {
        AppMethodBeat.i(105022);
        d.s(eVar);
        AppMethodBeat.o(105022);
    }

    public final void bTT() {
        AppMethodBeat.i(105025);
        c cVar = this.oNo;
        ab.i("MicroMsg.Music.MusicPlayerReportImpl", "initIdKeyStatDataForMusicPlayer");
        cVar.oMX = false;
        cVar.oMY = false;
        cVar.oMZ = false;
        cVar.oNa = false;
        cVar.oNb = false;
        cVar.oNc = false;
        cVar.oNd = false;
        cVar.oNe = false;
        cVar.oNf = false;
        cVar.oNg = 0;
        AppMethodBeat.o(105025);
    }

    public final void a(b bVar) {
        this.oNo.oNh = bVar;
    }

    public final void c(com.tencent.mm.aw.e eVar, int i, int i2) {
        AppMethodBeat.i(105026);
        c cVar = this.oNo;
        IDKey iDKey = new IDKey();
        iDKey.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey.SetKey(3);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(JsApiSetLabInfo.CTRL_INDEX);
        int i3 = eVar.fJS;
        ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerErrIdKeyByMusicType, musicType:".concat(String.valueOf(i3)));
        switch (i3) {
            case 0:
                i3 = 60;
                break;
            case 1:
                i3 = 61;
                break;
            case 4:
                i3 = 62;
                break;
            case 5:
                i3 = 63;
                break;
            case 6:
                i3 = 64;
                break;
            case 7:
                i3 = 5;
                break;
            case 8:
                i3 = 65;
                break;
            case 9:
                i3 = 66;
                break;
            default:
                i3 = 6;
                break;
        }
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(JsApiSetLabInfo.CTRL_INDEX);
        if (i == -1) {
            iDKey3.SetKey(12);
        } else if (i == 6) {
            iDKey3.SetKey(46);
        } else if (i == -2) {
            iDKey3.SetKey(13);
        } else if (i == 5) {
            iDKey3.SetKey(16);
        } else if (i == 4) {
            iDKey3.SetKey(14);
        } else if (i == 20) {
            iDKey3.SetKey(11);
        } else if (i == 21) {
            iDKey3.SetKey(47);
        } else if (i == 19) {
            iDKey3.SetKey(FacebookRequestErrorClassification.EC_INVALID_TOKEN);
        }
        iDKey3.SetValue(1);
        ArrayList arrayList = new ArrayList();
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey4.SetValue(1);
        if (i != 19 && (cVar.getMimeType() == null || !cVar.getMimeType().contains("text/html"))) {
            if (i == 21) {
                i3 = eVar.fJS;
                ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerPlayErrIdKeyByMusicType, musicType:".concat(String.valueOf(i3)));
                switch (i3) {
                    case 0:
                        i3 = JsApiGetBackgroundAudioState.CTRL_INDEX;
                        break;
                    case 1:
                        i3 = 160;
                        break;
                    case 4:
                        i3 = 161;
                        break;
                    case 6:
                        i3 = ErrorCode.STARTDOWNLOAD_3;
                        break;
                    case 7:
                        i3 = ErrorCode.STARTDOWNLOAD_4;
                        break;
                    case 8:
                        i3 = ErrorCode.STARTDOWNLOAD_5;
                        break;
                    case 9:
                        i3 = ErrorCode.STARTDOWNLOAD_6;
                        break;
                    default:
                        i3 = 188;
                        break;
                }
                iDKey4.SetKey(i3);
                arrayList.add(iDKey4);
            } else if (i == -1 || i == 6 || i == -2 || i == 5 || i == 4) {
                i3 = eVar.fJS;
                ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerNetworkErrIdKeyByMusicType, musicType:".concat(String.valueOf(i3)));
                switch (i3) {
                    case 0:
                        i3 = 151;
                        break;
                    case 1:
                        i3 = 152;
                        break;
                    case 4:
                        i3 = XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION;
                        break;
                    case 6:
                        i3 = JsApiMakeVoIPCall.CTRL_INDEX;
                        break;
                    case 7:
                        i3 = 155;
                        break;
                    case 8:
                        i3 = 156;
                        break;
                    case 9:
                        i3 = 157;
                        break;
                    default:
                        i3 = 188;
                        break;
                }
                iDKey4.SetKey(i3);
                arrayList.add(iDKey4);
            }
        }
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        ab.i("MicroMsg.Music.MusicPlayerReportImpl", "hasStatForHttpErr:%b, hasStatForUrlErr:%b, hasStatForNetworkErr:%b, hasStatForHttpRangeErr:%b, hasStatDownloadExceptionErr:%b", Boolean.valueOf(cVar.oMX), Boolean.valueOf(cVar.oMZ), Boolean.valueOf(cVar.oNc), Boolean.valueOf(cVar.oMY), Boolean.valueOf(cVar.oNa));
        if (i == -1 && !cVar.oMX) {
            cVar.oMX = true;
            i3 = 0;
            if (cVar.oNh != null) {
                i3 = cVar.oNh.oLx;
            }
            if (i3 == 403) {
                iDKey = new IDKey();
                iDKey.SetID(JsApiSetLabInfo.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(b.zN(700));
                arrayList.add(iDKey);
            }
            h.pYm.b(arrayList, true);
            h.pYm.e(14777, Integer.valueOf(0), Integer.valueOf(eVar.fJS), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(0));
        }
        if (i == 6 && !cVar.oMY) {
            cVar.oMY = true;
            h.pYm.b(arrayList, true);
            h.pYm.e(14777, Integer.valueOf(0), Integer.valueOf(eVar.fJS), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0));
        }
        if (i == -2 && !cVar.oMZ) {
            cVar.oMZ = true;
            h.pYm.b(arrayList, true);
            h.pYm.e(14777, Integer.valueOf(0), Integer.valueOf(eVar.fJS), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0));
        }
        if (i == 5 && !cVar.oNa) {
            cVar.oNa = true;
            h.pYm.b(arrayList, true);
            i3 = 0;
            if (cVar.oNh != null) {
                i3 = cVar.oNh.clN;
            }
            h.pYm.e(14777, Integer.valueOf(0), Integer.valueOf(eVar.fJS), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i3));
        }
        if (i == 19 && !cVar.oNb) {
            cVar.oNb = true;
            h.pYm.b(arrayList, true);
            h.pYm.e(14777, Integer.valueOf(0), Integer.valueOf(eVar.fJS), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0));
        }
        if (i == 4 && !cVar.oNc) {
            cVar.oNc = true;
            h.pYm.b(arrayList, true);
            h.pYm.e(14777, Integer.valueOf(0), Integer.valueOf(eVar.fJS), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0));
        }
        if (i == 20 && !cVar.oNd) {
            cVar.oNd = true;
            cVar.oNg = i2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(iDKey3);
            h.pYm.b(arrayList2, true);
        }
        if (i == 21 && !cVar.oNe && cVar.oNd) {
            cVar.oNe = true;
            IDKey iDKey5;
            if (cVar.getMimeType() == null || !cVar.getMimeType().contains("text/html")) {
                Object obj;
                iDKey5 = new IDKey();
                iDKey5.SetID(JsApiSetLabInfo.CTRL_INDEX);
                iDKey5.SetValue(1);
                iDKey5.SetKey(b.zN(i2));
                arrayList.add(iDKey5);
                switch (i2) {
                    case 704:
                    case 705:
                    case 706:
                        obj = 1;
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj != null) {
                    IDKey iDKey6 = new IDKey();
                    iDKey6.SetID(JsApiSetLabInfo.CTRL_INDEX);
                    iDKey6.SetValue(1);
                    i3 = eVar.fJS;
                    ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerDecodeErrIdKeyByMusicType, musicType:".concat(String.valueOf(i3)));
                    switch (i3) {
                        case 0:
                            i3 = JsApiUploadEncryptedFileToCDN.CTRL_INDEX;
                            break;
                        case 1:
                            i3 = JsApiChooseWeChatContact.CTRL_INDEX;
                            break;
                        case 4:
                            i3 = 196;
                            break;
                        case 6:
                            i3 = 197;
                            break;
                        case 7:
                            i3 = o.CTRL_INDEX;
                            break;
                        case 8:
                            i3 = 199;
                            break;
                        case 9:
                            i3 = 200;
                            break;
                        default:
                            i3 = 188;
                            break;
                    }
                    iDKey6.SetKey(i3);
                    arrayList.add(iDKey6);
                }
            } else {
                i2 = 701;
                iDKey5 = new IDKey();
                iDKey5.SetID(JsApiSetLabInfo.CTRL_INDEX);
                iDKey5.SetValue(1);
                iDKey5.SetKey(b.zN(701));
                arrayList.add(iDKey5);
            }
            h.pYm.b(arrayList, true);
            h.pYm.e(14777, Integer.valueOf(0), Integer.valueOf(eVar.fJS), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0));
        }
        AppMethodBeat.o(105026);
    }

    public final void a(com.tencent.mm.aw.e eVar, String str) {
        CharSequence str2;
        AppMethodBeat.i(105027);
        c cVar = this.oNo;
        if (TextUtils.isEmpty(str2) && cVar.oNh != null) {
            str2 = cVar.getMimeType();
        }
        ab.i("MicroMsg.Music.MusicPlayerReportImpl", "idKeyReportMusicMimeType mineType:%s, hasStatForMimeType:%b", str2, Boolean.valueOf(cVar.oNf));
        if (!(TextUtils.isEmpty(str2) || cVar.oNf)) {
            int i;
            ab.i("MicroMsg.Music.MusicPlayerReportImpl", "idKeyReportMusicMimeType OK");
            cVar.oNf = true;
            IDKey iDKey = new IDKey();
            iDKey.SetID(JsApiSetLabInfo.CTRL_INDEX);
            if ("audio/3gpp".equalsIgnoreCase(str2)) {
                i = 70;
            } else if ("audio/amr-wb".equalsIgnoreCase(str2)) {
                i = 71;
            } else if ("audio/mpeg".equalsIgnoreCase(str2) || str2.equalsIgnoreCase("audio/mp3")) {
                i = 72;
            } else if ("audio/mp4a-latm".equalsIgnoreCase(str2) || str2.startsWith("audio/mp4")) {
                i = 73;
            } else if ("audio/qcelp".equalsIgnoreCase(str2)) {
                i = 74;
            } else if ("audio/vorbis".equalsIgnoreCase(str2)) {
                i = 75;
            } else if ("audio/opus".equalsIgnoreCase(str2)) {
                i = 76;
            } else if ("audio/g711-alaw".equalsIgnoreCase(str2)) {
                i = 77;
            } else if ("audio/g711-mlaw".equalsIgnoreCase(str2)) {
                i = 78;
            } else if ("audio/raw".equalsIgnoreCase(str2)) {
                i = 79;
            } else if ("audio/flac".equalsIgnoreCase(str2)) {
                i = 80;
            } else if ("audio/gsm".equalsIgnoreCase(str2)) {
                i = 81;
            } else if ("audio/ac3".equalsIgnoreCase(str2)) {
                i = 82;
            } else if ("audio/eac3".equalsIgnoreCase(str2)) {
                i = 83;
            } else if ("audio/x-ms-wma".equalsIgnoreCase(str2)) {
                i = 84;
            } else if ("audio/x-wav".equalsIgnoreCase(str2)) {
                i = 85;
            } else if ("audio/x-ape".equalsIgnoreCase(str2) || "application/x-ape".equalsIgnoreCase(str2)) {
                i = 86;
            } else {
                i = 87;
            }
            iDKey.SetKey(i);
            iDKey.SetValue(1);
            ArrayList arrayList = new ArrayList();
            arrayList.add(iDKey);
            h.pYm.b(arrayList, true);
            if (eVar != null) {
                i = b.To(str2);
                h.pYm.e(14486, Integer.valueOf(0), Integer.valueOf(eVar.fJS), Integer.valueOf(i), str2);
            }
        }
        AppMethodBeat.o(105027);
    }

    public final void b(com.tencent.mm.aw.e eVar, int i) {
        AppMethodBeat.i(105023);
        IDKey iDKey = new IDKey();
        iDKey.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey.SetKey(4);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(JsApiSetLabInfo.CTRL_INDEX);
        int i2 = eVar.fJS;
        ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerErrIdKeyByMusicType, musicType:".concat(String.valueOf(i2)));
        switch (i2) {
            case 0:
                i2 = 49;
                break;
            case 1:
                i2 = 50;
                break;
            case 4:
                i2 = 51;
                break;
            case 5:
                i2 = 52;
                break;
            case 6:
                i2 = 53;
                break;
            case 7:
                i2 = 54;
                break;
            case 8:
                i2 = 55;
                break;
            case 9:
                i2 = 56;
                break;
            case 10:
                i2 = 7;
                break;
            case 11:
                i2 = 8;
                break;
            default:
                i2 = 9;
                break;
        }
        iDKey2.SetKey(i2);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey3.SetKey(b.zM(i));
        iDKey3.SetValue(1);
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey4.SetValue(1);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        if (i == 80) {
            i2 = eVar.fJS;
            ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerNetworkErrIdKeyByMusicType, musicType:".concat(String.valueOf(i2)));
            switch (i2) {
                case 0:
                    i2 = ErrorCode.STARTDOWNLOAD_8;
                    break;
                case 1:
                    i2 = 168;
                    break;
                case 4:
                    i2 = 169;
                    break;
                case 6:
                    i2 = ErrorCode.NEEDDOWNLOAD_TRUE;
                    break;
                case 7:
                    i2 = ErrorCode.NEEDDOWNLOAD_FALSE_1;
                    break;
                case 8:
                    i2 = ErrorCode.NEEDDOWNLOAD_FALSE_2;
                    break;
                case 9:
                    i2 = ErrorCode.NEEDDOWNLOAD_FALSE_3;
                    break;
                case 10:
                    i2 = ErrorCode.NEEDDOWNLOAD_FALSE_4;
                    break;
                case 11:
                    i2 = ErrorCode.NEEDDOWNLOAD_FALSE_5;
                    break;
                default:
                    i2 = 188;
                    break;
            }
            iDKey4.SetKey(i2);
            arrayList.add(iDKey4);
            i3 = 1;
            int Tb = g.Tb(eVar.playUrl);
            i2 = g.Tc(eVar.playUrl);
            if (g.Tb(eVar.playUrl) == 403) {
                IDKey iDKey5 = new IDKey();
                iDKey5.SetID(JsApiSetLabInfo.CTRL_INDEX);
                iDKey5.SetValue(1);
                iDKey5.SetKey(b.zM(700));
                arrayList.add(iDKey5);
                i4 = Tb;
            } else {
                i4 = Tb;
            }
        } else if (g.SY(eVar.playUrl) == null || !g.SY(eVar.playUrl).contains("text/html")) {
            if (i != 70) {
                Object obj;
                switch (i) {
                    case 62:
                    case 63:
                    case 64:
                    case 67:
                    case 74:
                        obj = 1;
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj != null) {
                    IDKey iDKey6 = new IDKey();
                    iDKey6.SetID(JsApiSetLabInfo.CTRL_INDEX);
                    iDKey6.SetValue(1);
                    i2 = eVar.fJS;
                    ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerDecodeErrIdKeyByMusicType, musicType:".concat(String.valueOf(i2)));
                    switch (i2) {
                        case 0:
                            i2 = 202;
                            break;
                        case 1:
                            i2 = 203;
                            break;
                        case 4:
                            i2 = 204;
                            break;
                        case 6:
                            i2 = 205;
                            break;
                        case 7:
                            i2 = 206;
                            break;
                        case 8:
                            i2 = 207;
                            break;
                        case 9:
                            i2 = 208;
                            break;
                        case 10:
                            i2 = 209;
                            break;
                        case 11:
                            i2 = 210;
                            break;
                        default:
                            i2 = 188;
                            break;
                    }
                    iDKey6.SetKey(i2);
                    arrayList.add(iDKey6);
                }
                i2 = eVar.fJS;
                ab.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerPlayErrIdKeyByMusicType, musicType:".concat(String.valueOf(i2)));
                switch (i2) {
                    case 0:
                        i2 = 178;
                        break;
                    case 1:
                        i2 = 179;
                        break;
                    case 4:
                        i2 = 180;
                        break;
                    case 6:
                        i2 = 181;
                        break;
                    case 7:
                        i2 = FaceMoveUtil.TRIANGLE_COUNT;
                        break;
                    case 8:
                        i2 = 183;
                        break;
                    case 9:
                        i2 = FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE;
                        break;
                    case 10:
                        i2 = 185;
                        break;
                    case 11:
                        i2 = 186;
                        break;
                    default:
                        i2 = 188;
                        break;
                }
                iDKey4.SetKey(i2);
                arrayList.add(iDKey4);
            }
            i2 = 0;
        } else {
            i4 = 701;
            IDKey iDKey7 = new IDKey();
            iDKey7.SetID(JsApiSetLabInfo.CTRL_INDEX);
            iDKey7.SetValue(1);
            iDKey7.SetKey(b.zM(701));
            arrayList.add(iDKey7);
            i2 = 0;
        }
        h.pYm.e(14777, Integer.valueOf(1), Integer.valueOf(eVar.fJS), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i2));
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        h.pYm.b(arrayList, true);
        AppMethodBeat.o(105023);
    }

    public final void c(com.tencent.mm.aw.e eVar, int i) {
        int i2;
        AppMethodBeat.i(105024);
        IDKey iDKey = new IDKey();
        iDKey.SetID(JsApiSetLabInfo.CTRL_INDEX);
        if (i == 2) {
            i2 = 92;
        } else if (i == 3) {
            i2 = 93;
        } else if (i == 4) {
            i2 = 94;
        } else if (i == 5) {
            i2 = 95;
        } else if (i == 6) {
            i2 = 96;
        } else if (i == 7) {
            i2 = 97;
        } else if (i == 8) {
            i2 = 98;
        } else if (i == 9) {
            i2 = 99;
        } else {
            i2 = 100;
        }
        iDKey.SetKey(i2);
        iDKey.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        h.pYm.b(arrayList, true);
        String SY = g.SY(eVar.playUrl);
        ab.i("MicroMsg.Music.QQMusicPlayerReportImpl", "mineTypeStr:%s", SY);
        if (eVar == null || TextUtils.isEmpty(SY)) {
            ab.e("MicroMsg.Music.QQMusicPlayerReportImpl", "music is null or mineTypeStr is empty");
            AppMethodBeat.o(105024);
            return;
        }
        int To = b.To(SY);
        h.pYm.e(14486, Integer.valueOf(1), Integer.valueOf(eVar.fJS), Integer.valueOf(To), SY);
        AppMethodBeat.o(105024);
    }

    public final void zG(int i) {
        AppMethodBeat.i(105028);
        if (i == 300 || i == 301 || i == 302 || i == 303) {
            IDKey iDKey = new IDKey();
            iDKey.SetID(JsApiSetLabInfo.CTRL_INDEX);
            iDKey.SetKey(15);
            iDKey.SetValue(1);
            ArrayList arrayList = new ArrayList();
            arrayList.add(iDKey);
            h.pYm.b(arrayList, true);
        }
        AppMethodBeat.o(105028);
    }

    public final void d(com.tencent.mm.aw.e eVar, int i, int i2) {
        AppMethodBeat.i(105029);
        IDKey iDKey = new IDKey();
        iDKey.SetID(797);
        iDKey.SetKey(2);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(797);
        int i3 = eVar.fJS;
        ab.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrIdKeyByMusicType, musicType:".concat(String.valueOf(i3)));
        switch (i3) {
            case 0:
                i3 = 62;
                break;
            case 1:
                i3 = 63;
                break;
            case 4:
                i3 = 64;
                break;
            case 6:
                i3 = 65;
                break;
            case 7:
                i3 = 66;
                break;
            case 8:
                i3 = 67;
                break;
            case 9:
                i3 = 68;
                break;
            case 10:
                i3 = 69;
                break;
            case 11:
                i3 = 70;
                break;
            default:
                i3 = 71;
                break;
        }
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(797);
        ab.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrTypeIdKey, errType:".concat(String.valueOf(i)));
        switch (i) {
            case -4999:
                i3 = 9;
                break;
            case -4005:
                i3 = 8;
                break;
            case -4004:
                i3 = 7;
                break;
            case -4003:
                i3 = 6;
                break;
            case -4002:
                i3 = 5;
                break;
            case -4001:
                i3 = 4;
                break;
            case -4000:
                i3 = 3;
                break;
            default:
                i3 = 9;
                break;
        }
        iDKey3.SetKey(i3);
        iDKey3.SetValue(1);
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(797);
        ab.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrIdKey, errCode:".concat(String.valueOf(i2)));
        switch (i2) {
            case -43:
                i3 = 25;
                break;
            case -42:
                i3 = 24;
                break;
            case -41:
                i3 = 23;
                break;
            case -40:
                i3 = 22;
                break;
            case -30:
                i3 = 21;
                break;
            case -13:
                i3 = 20;
                break;
            case -12:
                i3 = 19;
                break;
            case -11:
                i3 = 18;
                break;
            case -10:
                i3 = 17;
                break;
            case -3:
                i3 = 16;
                break;
            case -2:
                i3 = 15;
                break;
            case -1:
                i3 = 14;
                break;
            default:
                i3 = 14;
                break;
        }
        iDKey4.SetKey(i3);
        iDKey4.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        arrayList.add(iDKey4);
        h.pYm.b(arrayList, true);
        AppMethodBeat.o(105029);
    }
}
