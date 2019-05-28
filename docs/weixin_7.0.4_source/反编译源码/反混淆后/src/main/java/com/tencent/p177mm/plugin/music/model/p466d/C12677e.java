package com.tencent.p177mm.plugin.music.model.p466d;

import android.text.TextUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.p177mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27011o;
import com.tencent.p177mm.plugin.music.cache.C39433g;
import com.tencent.p177mm.plugin.music.p1282c.C21339b;
import com.tencent.p177mm.plugin.music.p462e.C39434d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.ArrayList;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.music.model.d.e */
public final class C12677e implements C39434d {
    private C39443f oNn = new C39443f();
    private C3540c oNo = new C3540c();
    private C3539a oNp = new C3539a();

    public C12677e() {
        AppMethodBeat.m2504i(105021);
        AppMethodBeat.m2505o(105021);
    }

    /* renamed from: s */
    public final void mo24651s(C9058e c9058e) {
        AppMethodBeat.m2504i(105022);
        C3541d.m5833s(c9058e);
        AppMethodBeat.m2505o(105022);
    }

    public final void bTT() {
        AppMethodBeat.m2504i(105025);
        C3540c c3540c = this.oNo;
        C4990ab.m7416i("MicroMsg.Music.MusicPlayerReportImpl", "initIdKeyStatDataForMusicPlayer");
        c3540c.oMX = false;
        c3540c.oMY = false;
        c3540c.oMZ = false;
        c3540c.oNa = false;
        c3540c.oNb = false;
        c3540c.oNc = false;
        c3540c.oNd = false;
        c3540c.oNe = false;
        c3540c.oNf = false;
        c3540c.oNg = 0;
        AppMethodBeat.m2505o(105025);
    }

    /* renamed from: a */
    public final void mo24645a(C21339b c21339b) {
        this.oNo.oNh = c21339b;
    }

    /* renamed from: c */
    public final void mo24649c(C9058e c9058e, int i, int i2) {
        AppMethodBeat.m2504i(105026);
        C3540c c3540c = this.oNo;
        IDKey iDKey = new IDKey();
        iDKey.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey.SetKey(3);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(JsApiSetLabInfo.CTRL_INDEX);
        int i3 = c9058e.fJS;
        C4990ab.m7416i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerErrIdKeyByMusicType, musicType:".concat(String.valueOf(i3)));
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
        if (i != 19 && (c3540c.getMimeType() == null || !c3540c.getMimeType().contains("text/html"))) {
            if (i == 21) {
                i3 = c9058e.fJS;
                C4990ab.m7416i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerPlayErrIdKeyByMusicType, musicType:".concat(String.valueOf(i3)));
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
                i3 = c9058e.fJS;
                C4990ab.m7416i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerNetworkErrIdKeyByMusicType, musicType:".concat(String.valueOf(i3)));
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
        C4990ab.m7417i("MicroMsg.Music.MusicPlayerReportImpl", "hasStatForHttpErr:%b, hasStatForUrlErr:%b, hasStatForNetworkErr:%b, hasStatForHttpRangeErr:%b, hasStatDownloadExceptionErr:%b", Boolean.valueOf(c3540c.oMX), Boolean.valueOf(c3540c.oMZ), Boolean.valueOf(c3540c.oNc), Boolean.valueOf(c3540c.oMY), Boolean.valueOf(c3540c.oNa));
        if (i == -1 && !c3540c.oMX) {
            c3540c.oMX = true;
            i3 = 0;
            if (c3540c.oNh != null) {
                i3 = c3540c.oNh.oLx;
            }
            if (i3 == 403) {
                iDKey = new IDKey();
                iDKey.SetID(JsApiSetLabInfo.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(C21350b.m32753zN(700));
                arrayList.add(iDKey);
            }
            C7060h.pYm.mo8379b(arrayList, true);
            C7060h.pYm.mo8381e(14777, Integer.valueOf(0), Integer.valueOf(c9058e.fJS), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(0));
        }
        if (i == 6 && !c3540c.oMY) {
            c3540c.oMY = true;
            C7060h.pYm.mo8379b(arrayList, true);
            C7060h.pYm.mo8381e(14777, Integer.valueOf(0), Integer.valueOf(c9058e.fJS), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0));
        }
        if (i == -2 && !c3540c.oMZ) {
            c3540c.oMZ = true;
            C7060h.pYm.mo8379b(arrayList, true);
            C7060h.pYm.mo8381e(14777, Integer.valueOf(0), Integer.valueOf(c9058e.fJS), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0));
        }
        if (i == 5 && !c3540c.oNa) {
            c3540c.oNa = true;
            C7060h.pYm.mo8379b(arrayList, true);
            i3 = 0;
            if (c3540c.oNh != null) {
                i3 = c3540c.oNh.clN;
            }
            C7060h.pYm.mo8381e(14777, Integer.valueOf(0), Integer.valueOf(c9058e.fJS), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i3));
        }
        if (i == 19 && !c3540c.oNb) {
            c3540c.oNb = true;
            C7060h.pYm.mo8379b(arrayList, true);
            C7060h.pYm.mo8381e(14777, Integer.valueOf(0), Integer.valueOf(c9058e.fJS), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0));
        }
        if (i == 4 && !c3540c.oNc) {
            c3540c.oNc = true;
            C7060h.pYm.mo8379b(arrayList, true);
            C7060h.pYm.mo8381e(14777, Integer.valueOf(0), Integer.valueOf(c9058e.fJS), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0));
        }
        if (i == 20 && !c3540c.oNd) {
            c3540c.oNd = true;
            c3540c.oNg = i2;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(iDKey3);
            C7060h.pYm.mo8379b(arrayList2, true);
        }
        if (i == 21 && !c3540c.oNe && c3540c.oNd) {
            c3540c.oNe = true;
            IDKey iDKey5;
            if (c3540c.getMimeType() == null || !c3540c.getMimeType().contains("text/html")) {
                Object obj;
                iDKey5 = new IDKey();
                iDKey5.SetID(JsApiSetLabInfo.CTRL_INDEX);
                iDKey5.SetValue(1);
                iDKey5.SetKey(C21350b.m32753zN(i2));
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
                    i3 = c9058e.fJS;
                    C4990ab.m7416i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerDecodeErrIdKeyByMusicType, musicType:".concat(String.valueOf(i3)));
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
                            i3 = C27011o.CTRL_INDEX;
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
                iDKey5.SetKey(C21350b.m32753zN(701));
                arrayList.add(iDKey5);
            }
            C7060h.pYm.mo8379b(arrayList, true);
            C7060h.pYm.mo8381e(14777, Integer.valueOf(0), Integer.valueOf(c9058e.fJS), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0));
        }
        AppMethodBeat.m2505o(105026);
    }

    /* renamed from: a */
    public final void mo24644a(C9058e c9058e, String str) {
        CharSequence str2;
        AppMethodBeat.m2504i(105027);
        C3540c c3540c = this.oNo;
        if (TextUtils.isEmpty(str2) && c3540c.oNh != null) {
            str2 = c3540c.getMimeType();
        }
        C4990ab.m7417i("MicroMsg.Music.MusicPlayerReportImpl", "idKeyReportMusicMimeType mineType:%s, hasStatForMimeType:%b", str2, Boolean.valueOf(c3540c.oNf));
        if (!(TextUtils.isEmpty(str2) || c3540c.oNf)) {
            int i;
            C4990ab.m7416i("MicroMsg.Music.MusicPlayerReportImpl", "idKeyReportMusicMimeType OK");
            c3540c.oNf = true;
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
            C7060h.pYm.mo8379b(arrayList, true);
            if (c9058e != null) {
                i = C21350b.m32751To(str2);
                C7060h.pYm.mo8381e(14486, Integer.valueOf(0), Integer.valueOf(c9058e.fJS), Integer.valueOf(i), str2);
            }
        }
        AppMethodBeat.m2505o(105027);
    }

    /* renamed from: b */
    public final void mo24646b(C9058e c9058e, int i) {
        AppMethodBeat.m2504i(105023);
        IDKey iDKey = new IDKey();
        iDKey.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey.SetKey(4);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(JsApiSetLabInfo.CTRL_INDEX);
        int i2 = c9058e.fJS;
        C4990ab.m7416i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerErrIdKeyByMusicType, musicType:".concat(String.valueOf(i2)));
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
        iDKey3.SetKey(C21350b.m32752zM(i));
        iDKey3.SetValue(1);
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey4.SetValue(1);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        if (i == 80) {
            i2 = c9058e.fJS;
            C4990ab.m7416i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerNetworkErrIdKeyByMusicType, musicType:".concat(String.valueOf(i2)));
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
            int Tb = C39433g.m67350Tb(c9058e.playUrl);
            i2 = C39433g.m67351Tc(c9058e.playUrl);
            if (C39433g.m67350Tb(c9058e.playUrl) == 403) {
                IDKey iDKey5 = new IDKey();
                iDKey5.SetID(JsApiSetLabInfo.CTRL_INDEX);
                iDKey5.SetValue(1);
                iDKey5.SetKey(C21350b.m32752zM(700));
                arrayList.add(iDKey5);
                i4 = Tb;
            } else {
                i4 = Tb;
            }
        } else if (C39433g.m67347SY(c9058e.playUrl) == null || !C39433g.m67347SY(c9058e.playUrl).contains("text/html")) {
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
                    i2 = c9058e.fJS;
                    C4990ab.m7416i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerDecodeErrIdKeyByMusicType, musicType:".concat(String.valueOf(i2)));
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
                i2 = c9058e.fJS;
                C4990ab.m7416i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerPlayErrIdKeyByMusicType, musicType:".concat(String.valueOf(i2)));
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
            iDKey7.SetKey(C21350b.m32752zM(701));
            arrayList.add(iDKey7);
            i2 = 0;
        }
        C7060h.pYm.mo8381e(14777, Integer.valueOf(1), Integer.valueOf(c9058e.fJS), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i2));
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        C7060h.pYm.mo8379b(arrayList, true);
        AppMethodBeat.m2505o(105023);
    }

    /* renamed from: c */
    public final void mo24648c(C9058e c9058e, int i) {
        int i2;
        AppMethodBeat.m2504i(105024);
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
        C7060h.pYm.mo8379b(arrayList, true);
        String SY = C39433g.m67347SY(c9058e.playUrl);
        C4990ab.m7417i("MicroMsg.Music.QQMusicPlayerReportImpl", "mineTypeStr:%s", SY);
        if (c9058e == null || TextUtils.isEmpty(SY)) {
            C4990ab.m7412e("MicroMsg.Music.QQMusicPlayerReportImpl", "music is null or mineTypeStr is empty");
            AppMethodBeat.m2505o(105024);
            return;
        }
        int To = C21350b.m32751To(SY);
        C7060h.pYm.mo8381e(14486, Integer.valueOf(1), Integer.valueOf(c9058e.fJS), Integer.valueOf(To), SY);
        AppMethodBeat.m2505o(105024);
    }

    /* renamed from: zG */
    public final void mo24652zG(int i) {
        AppMethodBeat.m2504i(105028);
        if (i == 300 || i == 301 || i == 302 || i == 303) {
            IDKey iDKey = new IDKey();
            iDKey.SetID(JsApiSetLabInfo.CTRL_INDEX);
            iDKey.SetKey(15);
            iDKey.SetValue(1);
            ArrayList arrayList = new ArrayList();
            arrayList.add(iDKey);
            C7060h.pYm.mo8379b(arrayList, true);
        }
        AppMethodBeat.m2505o(105028);
    }

    /* renamed from: d */
    public final void mo24650d(C9058e c9058e, int i, int i2) {
        AppMethodBeat.m2504i(105029);
        IDKey iDKey = new IDKey();
        iDKey.SetID(797);
        iDKey.SetKey(2);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(797);
        int i3 = c9058e.fJS;
        C4990ab.m7416i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrIdKeyByMusicType, musicType:".concat(String.valueOf(i3)));
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
        C4990ab.m7416i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrTypeIdKey, errType:".concat(String.valueOf(i)));
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
        C4990ab.m7416i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrIdKey, errCode:".concat(String.valueOf(i2)));
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
        C7060h.pYm.mo8379b(arrayList, true);
        AppMethodBeat.m2505o(105029);
    }
}
