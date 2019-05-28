package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.j;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.bar;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.cth;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class aw implements f, l {
    public static int qHB = 0;
    private String ecX = "";
    public Set<a> epg = new HashSet();
    private s qNn = null;
    public com.tencent.mm.plugin.sns.model.ac.a qNo = new com.tencent.mm.plugin.sns.model.ac.a() {
        public final void kJ(boolean z) {
            AppMethodBeat.i(36687);
            if (!z) {
                aw.this.cmp();
            }
            AppMethodBeat.o(36687);
        }
    };

    public enum b {
        STATE_ERROR,
        STATE_OK,
        STATE_FALSE;

        static {
            AppMethodBeat.o(36690);
        }
    }

    public interface a {
        void ad(int i, boolean z);

        void coo();
    }

    static /* synthetic */ boolean b(aw awVar) {
        AppMethodBeat.i(36712);
        boolean com = awVar.com();
        AppMethodBeat.o(36712);
        return com;
    }

    public aw() {
        AppMethodBeat.i(36691);
        AppMethodBeat.o(36691);
    }

    public final String cnk() {
        AppMethodBeat.i(36692);
        if (this.ecX == null || this.ecX.equals("")) {
            g.RQ();
            this.ecX = (String) g.RP().Ry().get(2, null);
        }
        String str = this.ecX;
        AppMethodBeat.o(36692);
        return str;
    }

    public final void start() {
        AppMethodBeat.i(36693);
        g.RQ();
        g.RO().eJo.a(207, (f) this);
        g.RQ();
        g.RO().eJo.a(209, (f) this);
        AppMethodBeat.o(36693);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(n nVar, int i, int i2, String str) {
        int i3;
        rp rpVar;
        AppMethodBeat.i(36694);
        ab.i("MicroMsg.UploadManager", "localId " + nVar.cqU() + "processError " + i2 + " errMsg: " + str);
        h.pYm.a(22, 129, 1, true);
        if (i != 0) {
            try {
                i3 = ((bax) new bax().parseFrom(af.cnu().kE((long) i).rfI)).wFm;
                try {
                    bav cqM = nVar.cqM();
                    if (cqM != null) {
                        cqM.wFm = i3;
                        nVar.field_postBuf = cqM.toByteArray();
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.UploadManager", "parse uploadInfo error");
                    ab.d("MicroMsg.UploadManager", "post error ".concat(String.valueOf(i3)));
                    nVar.cqY();
                    af.cnF().b(nVar.reX, nVar);
                    ab.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + nVar.reX);
                    rpVar = new rp();
                    rpVar.cNA.cNB = (long) nVar.reX;
                    com.tencent.mm.sdk.b.a.xxA.m(rpVar);
                    switch (i2) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                    }
                    ac(nVar.reX, false);
                    AppMethodBeat.o(36694);
                }
            } catch (Exception e2) {
                i3 = 0;
                ab.e("MicroMsg.UploadManager", "parse uploadInfo error");
                ab.d("MicroMsg.UploadManager", "post error ".concat(String.valueOf(i3)));
                nVar.cqY();
                af.cnF().b(nVar.reX, nVar);
                ab.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + nVar.reX);
                rpVar = new rp();
                rpVar.cNA.cNB = (long) nVar.reX;
                com.tencent.mm.sdk.b.a.xxA.m(rpVar);
                switch (i2) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                }
                ac(nVar.reX, false);
                AppMethodBeat.o(36694);
            }
        }
        bav cqM2 = nVar.cqM();
        i3 = cqM2 != null ? cqM2.wFm : 0;
        ab.d("MicroMsg.UploadManager", "post error ".concat(String.valueOf(i3)));
        nVar.cqY();
        af.cnF().b(nVar.reX, nVar);
        ab.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + nVar.reX);
        rpVar = new rp();
        rpVar.cNA.cNB = (long) nVar.reX;
        com.tencent.mm.sdk.b.a.xxA.m(rpVar);
        switch (i2) {
            case 1:
                ab.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
                break;
            case 2:
                ab.e("MicroMsg.UploadManager", "parser protobuf error");
                break;
            case 3:
                ab.e("MicroMsg.UploadManager", "local id is not in db");
                break;
            case 4:
                ab.e("MicroMsg.UploadManager", "arg is error");
                break;
            case 5:
                ab.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
                break;
            case 6:
                ab.e("MicroMsg.UploadManager", "errtle  error");
                break;
        }
        ac(nVar.reX, false);
        AppMethodBeat.o(36694);
    }

    private void a(n nVar, int i, String str) {
        AppMethodBeat.i(36695);
        a(nVar, 0, i, str);
        AppMethodBeat.o(36695);
    }

    private static int Db(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return -1;
        }
    }

    public final boolean fU(String str, String str2) {
        AppMethodBeat.i(36696);
        ab.d("MicroMsg.UploadManager", "imgPath " + str + " text " + str2);
        String str3 = af.getAccSnsTmpPath() + com.tencent.mm.a.g.x(str.getBytes());
        e.y(str, str3);
        ax axVar = new ax(1);
        axVar.Ym(str2);
        axVar.Dh(6);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new com.tencent.mm.plugin.sns.data.h(str3, 2));
        axVar.dh(linkedList);
        if (axVar.commit() > 0) {
            AppMethodBeat.o(36696);
            return true;
        }
        AppMethodBeat.o(36696);
        return false;
    }

    public static ax b(WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        int i;
        AppMethodBeat.i(36697);
        ab.d("MicroMsg.UploadManager", "appmsg.description " + wXMediaMessage.description);
        ab.d("MicroMsg.UploadManager", "appmsg.title " + wXMediaMessage.title);
        IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        switch (iMediaObject.type()) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
            case 6:
                i = 3;
                break;
            case 7:
                i = 3;
                break;
            default:
                i = -1;
                break;
        }
        ax axVar = new ax(i);
        axVar.Ys(bo.bc(str2, "")).Yt(bo.bc(str3, ""));
        axVar.Dh(5);
        ab.d("MicroMsg.UploadManager", "TimeLineType ".concat(String.valueOf(i)));
        if (i == -1) {
            ab.d("MicroMsg.UploadManager", "timeLineType is invalid");
            AppMethodBeat.o(36697);
            return null;
        }
        if (!bo.isNullOrNil(str)) {
            axVar.Ym(str);
        }
        axVar.Yr(bo.bc(wXMediaMessage.title, "")).Yp(bo.bc(wXMediaMessage.description, ""));
        int Db;
        switch (iMediaObject.type()) {
            case 1:
                WXTextObject wXTextObject = (WXTextObject) iMediaObject;
                axVar.Yp("");
                axVar.Ym(wXTextObject.text);
                break;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) iMediaObject;
                if (bo.cb(wXImageObject.imageData)) {
                    if (bo.isNullOrNil(wXImageObject.imagePath)) {
                        ab.e("MicroMsg.UploadManager", "share img but no res is exist!");
                        AppMethodBeat.o(36697);
                        return null;
                    } else if (!axVar.ge(wXImageObject.imagePath, "")) {
                        AppMethodBeat.o(36697);
                        return null;
                    }
                } else if (!axVar.b(wXImageObject.imageData, "", "")) {
                    AppMethodBeat.o(36697);
                    return null;
                }
                break;
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
                String bc = bo.bc(!bo.isNullOrNil(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                String bc2 = bo.bc(!bo.isNullOrNil(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                axVar.Yr("").Yp("");
                Db = Db(3);
                if (Db == -1) {
                    ab.d("MicroMsg.UploadManager", "mediaType is invalid");
                    AppMethodBeat.o(36697);
                    return null;
                }
                if (!axVar.a(wXMediaMessage.thumbData, bc, bo.bc(!bo.isNullOrNil(wXMusicObject.musicLowBandDataUrl) ? wXMusicObject.musicLowBandDataUrl : wXMusicObject.musicLowBandUrl, ""), bc2, Db, bo.bc(wXMediaMessage.title, ""), bo.bc(wXMediaMessage.description, ""))) {
                    AppMethodBeat.o(36697);
                    return null;
                }
                break;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
                axVar.Yr("").Yp("");
                Db = Db(4);
                if (Db == -1) {
                    ab.d("MicroMsg.UploadManager", "mediaType is invalid");
                    AppMethodBeat.o(36697);
                    return null;
                }
                if (!axVar.a(wXMediaMessage.thumbData, bo.bc(!bo.isNullOrNil(wXVideoObject.videoUrl) ? wXVideoObject.videoUrl : wXVideoObject.videoLowBandUrl, ""), wXVideoObject.videoLowBandUrl, wXVideoObject.videoUrl, Db, bo.bc(wXMediaMessage.title, ""), bo.bc(wXMediaMessage.description, ""))) {
                    AppMethodBeat.o(36697);
                    return null;
                }
                break;
            case 5:
                WXWebpageObject wXWebpageObject = (WXWebpageObject) iMediaObject;
                if (!bo.cb(wXMediaMessage.thumbData)) {
                    axVar.b(wXMediaMessage.thumbData, bo.bc(wXMediaMessage.description, ""), bo.bc(wXMediaMessage.title, ""));
                }
                axVar.Yp(wXWebpageObject.webpageUrl).Yq(wXWebpageObject.webpageUrl);
                axVar.qNK.xfI.Url = wXWebpageObject.webpageUrl;
                axVar.Yo(wXWebpageObject.canvasPageXml);
                break;
            case 6:
                ab.e("MicroMsg.UploadManager", "file is not support!");
                AppMethodBeat.o(36697);
                return null;
            case 7:
                WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) iMediaObject;
                if (!bo.isNullOrNil(wXAppExtendObject.filePath) && wXAppExtendObject.filePath.startsWith("http")) {
                    axVar.Yr(wXAppExtendObject.filePath);
                    axVar.Yp(wXAppExtendObject.filePath);
                    break;
                }
                ab.e("MicroMsg.UploadManager", "appdata is not support!");
                AppMethodBeat.o(36697);
                return null;
            default:
                ab.e("MicroMsg.UploadManager", "none type not support!");
                AppMethodBeat.o(36697);
                return null;
        }
        AppMethodBeat.o(36697);
        return axVar;
    }

    public final boolean a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i) {
        AppMethodBeat.i(36698);
        ax b = b(wXMediaMessage, str, str2, str3);
        if (b == null) {
            AppMethodBeat.o(36698);
            return false;
        }
        b.Yn(wXMediaMessage.mediaTagName);
        b.af(str2, wXMediaMessage.messageExt, wXMediaMessage.messageAction);
        if (i > com.tencent.mm.plugin.sns.c.a.qFE) {
            b.Dd(1);
        }
        ab.d("MicroMsg.UploadManager", "shareAppMsg set and the result: ".concat(String.valueOf(b.commit())));
        AppMethodBeat.o(36698);
        return true;
    }

    private boolean t(n nVar) {
        AppMethodBeat.i(36699);
        if (nVar == null) {
            AppMethodBeat.o(36699);
            return false;
        }
        TimeLineObject cqu = nVar.cqu();
        if (cqu.xfI.wbJ == 8) {
            AppMethodBeat.o(36699);
            return true;
        } else if (cqu.xfI.wbJ == 2) {
            AppMethodBeat.o(36699);
            return true;
        } else {
            if (cqu.xfI.wbJ == 26) {
                gh ghVar = new gh();
                ghVar.cAH.type = 30;
                ghVar.cAH.cAO = 5;
                ghVar.cAH.desc = cqu.xfI.wbM;
                ghVar.cAH.cAN = String.valueOf(nVar.reX);
                com.tencent.mm.sdk.b.a.xxA.m(ghVar);
                if (ghVar.cAI.ret != 1) {
                    AppMethodBeat.o(36699);
                    return false;
                }
            }
            if (cqu == null || cqu.xfI.wbK == null) {
                a(nVar, 1, "timeline or timelineObjList is null");
                AppMethodBeat.o(36699);
                return false;
            } else if (cqu.xfI.wbK.size() == 0) {
                AppMethodBeat.o(36699);
                return true;
            } else {
                try {
                    boolean z;
                    boolean z2;
                    bav bav = (bav) new bav().parseFrom(nVar.field_postBuf);
                    if (cqu.xfI.wbJ != 1) {
                        z = true;
                    } else if (bav.wFf.size() > 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (cqu.xfI.wbJ == 21) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if (cqu.xfI.wbJ == 15) {
                        Iterator it = bav.wFf.iterator();
                        while (it.hasNext()) {
                            ayq ayq = (ayq) it.next();
                            b Dc = Dc(ayq.wCt);
                            if (Dc == b.STATE_ERROR) {
                                a(nVar, ayq.wCt, 2, "upload has set it fail");
                                AppMethodBeat.o(36699);
                                return false;
                            } else if (Dc == b.STATE_FALSE) {
                                AppMethodBeat.o(36699);
                                return false;
                            }
                        }
                        AppMethodBeat.o(36699);
                        return true;
                    }
                    Iterator it2 = bav.wFf.iterator();
                    while (it2.hasNext()) {
                        ayq ayq2 = (ayq) it2.next();
                        b a = a(ayq2.wCt, z2, bav, cqu.xfI.wbJ);
                        if (a == b.STATE_ERROR) {
                            a(nVar, ayq2.wCt, 2, "upload has set it fail");
                            AppMethodBeat.o(36699);
                            return false;
                        } else if (a == b.STATE_FALSE) {
                            AppMethodBeat.o(36699);
                            return false;
                        }
                    }
                    AppMethodBeat.o(36699);
                    return true;
                } catch (Exception e) {
                    ab.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + nVar.cqU());
                    a(nVar, 2, "mediaPostInfo parser error " + e.getMessage());
                    AppMethodBeat.o(36699);
                    return false;
                }
            }
        }
    }

    public final void u(n nVar) {
        AppMethodBeat.i(36700);
        if (nVar == null) {
            AppMethodBeat.o(36700);
            return;
        }
        bav bav;
        ab.i("MicroMsg.UploadManager", "cancel snsinfo " + nVar.cqU());
        try {
            bav = (bav) new bav().parseFrom(nVar.field_postBuf);
        } catch (Exception e) {
            ab.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + nVar.cqU());
            a(nVar, 2, "mediaPostInfo parser error " + e.getMessage());
            bav = null;
        }
        if (!(bav == null || bav.wFf == null)) {
            Iterator it = bav.wFf.iterator();
            while (it.hasNext()) {
                ayq ayq = (ayq) it.next();
                int CX = af.cnE().CX(ayq.wCt);
                af.cnE().CW(ayq.wCt);
                ab.i("MicroMsg.UploadManager", "cancel upload %d", Integer.valueOf(CX));
                if (nVar.field_type != 15 && CX >= 0) {
                    g.RQ();
                    g.RO().eJo.cancel(CX);
                    af.cnE().CV(ayq.wCt);
                }
            }
        }
        if (af.cnE().CR(nVar.reX) && this.qNn != null) {
            ab.i("MicroMsg.UploadManager", "cancel post");
            this.qNn.ekq = true;
            g.RQ();
            g.RO().eJo.c(this.qNn);
            af.cnE().CT(nVar.reX);
        }
        n DK = af.cnF().DK(nVar.reX);
        if (!(DK == null || DK.field_snsId == 0)) {
            af.cnE().km(DK.field_snsId);
            g.RQ();
            g.RO().eJo.a(new r(DK.field_snsId, 1), 0);
        }
        af.cnF().DL(nVar.reX);
        if (nVar.field_type == 21) {
            com.tencent.mm.plugin.sns.lucky.a.g.cmv().cmx();
        }
        ab.d("MicroMsg.UploadManager", "cancelPost, publish SnsPostFailEvent, snsInfoLocalId " + nVar.cqU());
        rp rpVar = new rp();
        rpVar.cNA.cNB = (long) nVar.reX;
        com.tencent.mm.sdk.b.a.xxA.m(rpVar);
        AppMethodBeat.o(36700);
    }

    public final void cmp() {
        AppMethodBeat.i(36701);
        af.bCo().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(36682);
                aw.a(aw.this);
                AppMethodBeat.o(36682);
            }
        }, 1000);
        AppMethodBeat.o(36701);
    }

    private boolean com() {
        AppMethodBeat.i(36702);
        o cnF = af.cnF();
        String str = "select *,rowid from SnsInfo  where " + o.rfs + " order by SnsInfo.rowid asc ";
        Cursor rawQuery = cnF.bSd.rawQuery(str, null);
        ab.d("MicroMsg.SnsInfoStorage", "getLastUpload ".concat(String.valueOf(str)));
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            rawQuery = null;
        } else {
            rawQuery.moveToFirst();
        }
        n nVar = new n();
        if (rawQuery == null) {
            AppMethodBeat.o(36702);
            return false;
        }
        rawQuery.moveToFirst();
        do {
            nVar.d(rawQuery);
            try {
                bav bav = (bav) new bav().parseFrom(nVar.field_postBuf);
                if (n.kC(bav.wFi)) {
                    a(bav);
                    a(nVar, 6, "snsinfo is tle");
                    ab.i("MicroMsg.UploadManager", "checkTLE snsinfo localId it time limit " + nVar.cqU() + " is die ");
                }
            } catch (Exception e) {
                ab.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
                a(nVar, 2, "MediaPostInfo parser error");
            }
        } while (rawQuery.moveToNext());
        rawQuery.close();
        AppMethodBeat.o(36702);
        return true;
    }

    private static TimeLineObject a(n nVar, bav bav) {
        AppMethodBeat.i(36703);
        TimeLineObject cqu = nVar.cqu();
        ayt ayt = cqu.xfG;
        String str = cqu.xfF;
        String str2 = cqu.ijx;
        String str3 = cqu.vjM;
        String str4 = cqu.xfI.Desc;
        String str5 = cqu.xfI.Title;
        String str6 = cqu.xfI.Url;
        String str7 = cqu.xfI.wbM;
        ds dsVar = cqu.xfH;
        cth cth = cqu.xfO;
        int i = cqu.xfI.wbJ;
        int i2 = cqu.xfI.wbL;
        TimeLineObject ajM = com.tencent.mm.modelsns.e.ajM();
        ajM.jBB = nVar.field_userName;
        ajM.wEJ = nVar.field_pravited;
        ajM.xfF = str;
        ajM.ijx = bo.nullAsNil(str2);
        ajM.vjM = bo.nullAsNil(str3);
        ajM.xfK = cqu.xfK;
        ajM.xfL = cqu.xfL;
        ajM.fgt = cqu.fgt;
        ajM.xfM = cqu.xfM;
        ajM.rCK = cqu.rCK;
        ajM.xfI.Desc = str4;
        ajM.xfI.Title = str5;
        ajM.xfI.wbJ = i;
        ajM.xfI.wbL = i2;
        ajM.xfI.Url = str6;
        ajM.xfI.wbM = str7;
        ajM.xfG = ayt;
        ajM.xfN = cqu.xfN;
        ajM.rjC = cqu.rjC;
        if (cqu.qNO != null) {
            ajM.qNO = cqu.qNO;
        }
        if (dsVar != null) {
            ajM.xfH = dsVar;
        }
        if (cth != null) {
            ajM.xfO = cth;
        }
        Iterator it = cqu.xfI.wbK.iterator();
        while (it.hasNext()) {
            bau bau = (bau) it.next();
            if (bau.wEN == 1) {
                ajM.xfI.wbK.add(bau);
            }
        }
        if (cqu.qNQ != null) {
            ajM.qNQ = cqu.qNQ;
        }
        com.tencent.mm.model.v.b y = v.Zp().y(bav.cvF, true);
        if (y.containsKey("_DATA_CENTER_ITEM_SHOW_TYPE")) {
            int i3 = y.getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
            if (i3 != -1) {
                ajM.xfI.wbN = new azu();
                ajM.xfI.wbN.vGc = i3;
                if (i3 == 5) {
                    ajM.xfI.wbN.fgd = y.getString("_DATA_CENTER_VID", "");
                    ajM.xfI.wbN.fga = y.getInt("_DATA_CENTER_PUB_TIME", 0);
                    ajM.xfI.wbN.duration = y.getInt("_DATA_CENTER__DULATION", 0);
                    ajM.xfI.wbN.desc = y.getString("_DATA_CENTER_DESC", "");
                    ajM.xfI.wbN.lvx = y.getString("_DATA_CENTER_COVER_URL", "");
                    ajM.xfI.wbN.videoWidth = y.getInt("_DATA_CENTER_VIDEO_WIDTH", 0);
                    ajM.xfI.wbN.videoHeight = y.getInt("_DATA_CENTER_VIDEO_HEIGHT", 0);
                    ajM.xfI.wbN.fgc = y.getInt("_DATA_CENTER_FUNC_FLAG", 0);
                }
            }
        }
        AppMethodBeat.o(36703);
        return ajM;
    }

    private boolean v(n nVar) {
        AppMethodBeat.i(36704);
        try {
            bav bav = (bav) new bav().parseFrom(nVar.field_postBuf);
            bav.eRu++;
            nVar.field_postBuf = bav.toByteArray();
            af.cnF().b(nVar.reX, nVar);
            if (n.kC(bav.wFi)) {
                a(nVar, 6, "this item isTimeLimit");
                ab.i("MicroMsg.UploadManager", "snsinfo localId it time limit " + nVar.cqU() + " is die ");
                AppMethodBeat.o(36704);
                return false;
            }
            ab.i("MicroMsg.UploadManager", "try start post " + nVar.cqU());
            if (t(nVar)) {
                String str;
                TimeLineObject cqu = nVar.cqu();
                TimeLineObject a = a(nVar, bav);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= bav.wFf.size()) {
                        break;
                    }
                    i = ((ayq) bav.wFf.get(i2)).wCt;
                    r kE = af.cnu().kE((long) i);
                    if (kE == null) {
                        a(nVar, 3, "can not get the media from db ,localMediaId: ".concat(String.valueOf(i)));
                        AppMethodBeat.o(36704);
                        return false;
                    }
                    try {
                        bax bax = (bax) new bax().parseFrom(kE.rfI);
                        if (bax.wFA == null || bax.wFC.size() <= 0) {
                            ab.e("MicroMsg.UploadManager", "item with not url" + nVar.field_type);
                        } else {
                            bau a2;
                            bau bau;
                            str = bax.wFA.Url;
                            String str2 = ((bar) bax.wFC.get(0)).Url;
                            int i3 = bax.wFA.jCt;
                            int i4 = ((bar) bax.wFC.get(0)).jCt;
                            String str3 = bax.cvZ;
                            baw baw = null;
                            if (i2 < cqu.xfI.wbK.size()) {
                                baw = ((bau) cqu.xfI.wbK.get(i2)).wEK;
                            }
                            if (cqu.xfI.wbJ != 4 && cqu.xfI.wbJ != 5) {
                                a2 = com.tencent.mm.modelsns.e.a(kE.rfH, kE.type, str, str2, i3, i4, bax.wEJ, "", baw);
                            } else if (i2 < cqu.xfI.wbK.size()) {
                                bau = (bau) cqu.xfI.wbK.get(i2);
                                bau.wEH = str2;
                                bau.wEI = i4;
                                a2 = bau;
                            } else {
                                a2 = null;
                            }
                            if (a2 != null && a.xfI.wbJ == 1) {
                                a2.cvZ = str3;
                            }
                            if (a2 != null && a.xfI.wbJ == 15) {
                                a2.cvZ = bax.cvZ;
                                a2.wFc = bax.wFc;
                            }
                            if (i2 < cqu.xfI.wbK.size()) {
                                bau = (bau) cqu.xfI.wbK.get(i2);
                                a2.Title = bau.Title;
                                a2.Desc = bau.Desc;
                                a2.cuu = bau.cuu;
                                a2.rik = bau.rik;
                            }
                            if (a2 == null) {
                                a(nVar, 3, "make media error");
                                AppMethodBeat.o(36704);
                                return false;
                            }
                            a.xfI.wbK.add(a2);
                            i = i2 + 1;
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.UploadManager", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
                        a(nVar, 2, "mediaUploadInfo parser error " + e.getMessage());
                        AppMethodBeat.o(36704);
                        return false;
                    }
                }
                ab.e("MicroMsg.UploadManager", "item with not url" + nVar.field_type);
                if (nVar.field_type != 3) {
                    a(nVar, 4, "buf url is null");
                    AppMethodBeat.o(36704);
                    return false;
                }
                if (af.cnE().CS(nVar.reX)) {
                    final LinkedList linkedList = new LinkedList();
                    Iterator it = bav.wFg.iterator();
                    while (it.hasNext()) {
                        linkedList.add(((cco) it.next()).jBB);
                    }
                    str = j.b(a);
                    ab.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + a.xfL + " contentDescShowType: " + a.xfK);
                    if (nVar.field_pravited == 1) {
                        ab.i("MicroMsg.UploadManager", "content private xml is null ? " + bo.isNullOrNil(str));
                    } else {
                        ab.i("MicroMsg.UploadManager", "upload xmlsns: %s", str);
                    }
                    if (str == null || str.equals("")) {
                        a(nVar, 5, "content is error");
                        af.cnE().CT(nVar.reX);
                        AppMethodBeat.o(36704);
                        return false;
                    }
                    boolean z;
                    if (bav.wFo == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    final int i5 = nVar.reX;
                    final LinkedList linkedList2 = bav.wFp;
                    final com.tencent.mm.bt.b bVar = a.xfG.wCG;
                    final String str4 = a.xfI.Title;
                    final bav bav2 = bav;
                    final TimeLineObject timeLineObject = cqu;
                    af.bCo().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(36685);
                            if (af.cnn()) {
                                ab.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                                AppMethodBeat.o(36685);
                                return;
                            }
                            aw.this.qNn = new s(str, bav2.wEJ, bav2.wFe, linkedList, timeLineObject, i5, bav2.ptv, bav2.wFj, bav2.wFk, bav2.wFl, bav2, z, linkedList2, bav2.wFq, bVar, str4);
                            g.RQ();
                            g.RO().eJo.a(aw.this.qNn, 0);
                            AppMethodBeat.o(36685);
                        }
                    });
                } else {
                    ab.d("MicroMsg.UploadManager", "this snsinfo is posting");
                    AppMethodBeat.o(36704);
                    return false;
                }
            }
            ab.d("MicroMsg.UploadManager", "startPost, canPost is false, snsInfoId: " + nVar.cqU());
            AppMethodBeat.o(36704);
            return true;
        } catch (Exception e2) {
            ab.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
            a(nVar, 2, "MediaPostInfo parser error:" + e2.getMessage());
            AppMethodBeat.o(36704);
            return false;
        }
    }

    private void ac(final int i, final boolean z) {
        AppMethodBeat.i(36705);
        af.bCo().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(36684);
                if (af.cnn()) {
                    ab.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                    AppMethodBeat.o(36684);
                    return;
                }
                for (a aVar : aw.this.epg) {
                    if (aVar != null) {
                        aVar.ad(i, z);
                    }
                }
                AppMethodBeat.o(36684);
            }
        });
        AppMethodBeat.o(36705);
    }

    private b a(int i, boolean z, bav bav, int i2) {
        AppMethodBeat.i(36706);
        b bVar;
        if (i == -1) {
            ab.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media");
            bVar = b.STATE_ERROR;
            AppMethodBeat.o(36706);
            return bVar;
        }
        r kE = af.cnu().kE((long) i);
        try {
            bax bax = (bax) new bax().parseFrom(kE.rfI);
            ab.i("MicroMsg.UploadManager", "state " + bax.wFD + " pic isMuti: " + z);
            if (bax.wFD == 1) {
                bVar = b.STATE_ERROR;
                AppMethodBeat.o(36706);
                return bVar;
            }
            String str = an.fZ(af.getAccSnsPath(), kE.rfE) + i.Xe(kE.rfE);
            if (e.asZ(str) == 0) {
                ab.i("MicroMsg.UploadManager", "path not exist  ".concat(String.valueOf(str)));
                bVar = b.STATE_ERROR;
                AppMethodBeat.o(36706);
                return bVar;
            } else if (bax.wFD == 0) {
                bVar = b.STATE_OK;
                AppMethodBeat.o(36706);
                return bVar;
            } else {
                if (af.cnE().CU(i)) {
                    af.cnu().a(i, kE);
                    final String x = com.tencent.mm.a.g.x((bo.yz() + " " + System.currentTimeMillis()).getBytes());
                    final int i3 = i;
                    final boolean z2 = z;
                    final bav bav2 = bav;
                    final int i4 = i2;
                    af.bCo().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(36686);
                            if (af.cnn()) {
                                ab.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                                AppMethodBeat.o(36686);
                                return;
                            }
                            m zVar = new z(i3, x, z2, i4);
                            af.cnE().fk(i3, zVar.hashCode());
                            g.RQ();
                            g.RO().eJo.a(zVar, 0);
                            AppMethodBeat.o(36686);
                        }
                    });
                }
                bVar = b.STATE_FALSE;
                AppMethodBeat.o(36706);
                return bVar;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.UploadManager", "parse uploadInfo error");
            bVar = b.STATE_ERROR;
            AppMethodBeat.o(36706);
            return bVar;
        }
    }

    private static void a(bav bav) {
        AppMethodBeat.i(36707);
        if (bav == null) {
            AppMethodBeat.o(36707);
            return;
        }
        Iterator it = bav.wFf.iterator();
        while (it.hasNext()) {
            af.cnE().CV(((ayq) it.next()).wCt);
        }
        AppMethodBeat.o(36707);
    }

    private b Dc(int i) {
        AppMethodBeat.i(36708);
        b bVar;
        if (i == -1) {
            ab.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media doUploadSight");
            bVar = b.STATE_ERROR;
            AppMethodBeat.o(36708);
            return bVar;
        }
        r kE = af.cnu().kE((long) i);
        try {
            bax bax = (bax) new bax().parseFrom(kE.rfI);
            ab.i("MicroMsg.UploadManager", "state " + bax.wFD + " doUploadSight, serverErr:" + bax.wFm);
            if (bax.wFD == 1) {
                bVar = b.STATE_ERROR;
                AppMethodBeat.o(36708);
                return bVar;
            } else if (e.asZ(bax.videoPath) == 0) {
                ab.i("MicroMsg.UploadManager", "path not fileexist  " + bax.videoPath);
                bVar = b.STATE_ERROR;
                AppMethodBeat.o(36708);
                return bVar;
            } else if (e.asZ(bax.wFF) == 0) {
                ab.i("MicroMsg.UploadManager", "thumbpath not fileexist  " + bax.wFF);
                bVar = b.STATE_ERROR;
                AppMethodBeat.o(36708);
                return bVar;
            } else if (bax.wFD == 0) {
                bVar = b.STATE_OK;
                AppMethodBeat.o(36708);
                return bVar;
            } else {
                if (af.cnE().CU(i)) {
                    af.cnu().a(i, kE);
                    new ac(i, kE, bax.videoPath, bax.wFF, this.qNo).cne();
                }
                bVar = b.STATE_FALSE;
                AppMethodBeat.o(36708);
                return bVar;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.UploadManager", "parse uploadInfo error doUploadSight");
            bVar = b.STATE_ERROR;
            AppMethodBeat.o(36708);
            return bVar;
        }
    }

    public final void con() {
        AppMethodBeat.i(36709);
        for (a aVar : this.epg) {
            if (aVar != null) {
                aVar.coo();
            }
        }
        AppMethodBeat.o(36709);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(36710);
        ab.i("MicroMsg.UploadManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + mVar.getType() + " @" + hashCode());
        switch (mVar.getType()) {
            case 207:
                if (!(i == 0 && i2 == 0)) {
                    cmp();
                    break;
                }
            case 209:
                s sVar = (s) mVar;
                int i3 = sVar.cNE;
                if (sVar.ekq) {
                    long j = sVar.qJo;
                    ab.i("MicroMsg.UploadManager", "get the del post come back %d ".concat(String.valueOf(j)), Integer.valueOf(i3));
                    if (j != 0) {
                        af.cnE().km(j);
                        g.RQ();
                        g.RO().eJo.a(new r(j, 1), 0);
                    }
                    af.cnF().DL(i3);
                    if (j != 0) {
                        af.cnK().ky(j);
                        com.tencent.mm.plugin.sns.storage.i.kx(j);
                    }
                }
                if (i == 0 && i2 == 0) {
                    ac(sVar.cNE, true);
                    ak.iN(sVar.qJo);
                } else {
                    ac(sVar.cNE, false);
                }
                this.qNn = null;
                break;
        }
        if (i == 0 && i2 == 0) {
            AppMethodBeat.o(36710);
        } else {
            AppMethodBeat.o(36710);
        }
    }
}
