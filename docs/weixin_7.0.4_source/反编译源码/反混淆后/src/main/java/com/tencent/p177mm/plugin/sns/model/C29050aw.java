package com.tencent.p177mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.modelsns.C37953e;
import com.tencent.p177mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.p177mm.opensdk.modelmsg.WXImageObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.p177mm.opensdk.modelmsg.WXTextObject;
import com.tencent.p177mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.p177mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p230g.p231a.C18386rp;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C21881h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C21905g;
import com.tencent.p177mm.plugin.sns.model.C46220ac.C34953a;
import com.tencent.p177mm.plugin.sns.p1024b.C21876l;
import com.tencent.p177mm.plugin.sns.p1025h.C21898j;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.storage.C21991i;
import com.tencent.p177mm.plugin.sns.storage.C29098r;
import com.tencent.p177mm.plugin.sns.storage.C39789o;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.C44113ds;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.ayq;
import com.tencent.p177mm.protocal.protobuf.ayt;
import com.tencent.p177mm.protocal.protobuf.azu;
import com.tencent.p177mm.protocal.protobuf.bar;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.bav;
import com.tencent.p177mm.protocal.protobuf.baw;
import com.tencent.p177mm.protocal.protobuf.bax;
import com.tencent.p177mm.protocal.protobuf.cco;
import com.tencent.p177mm.protocal.protobuf.cth;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.sns.model.aw */
public final class C29050aw implements C1202f, C21876l {
    public static int qHB = 0;
    private String ecX = "";
    public Set<C29049a> epg = new HashSet();
    private C34959s qNn = null;
    public C34953a qNo = new C290486();

    /* renamed from: com.tencent.mm.plugin.sns.model.aw$b */
    public enum C13422b {
        STATE_ERROR,
        STATE_OK,
        STATE_FALSE;

        static {
            AppMethodBeat.m2505o(36690);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.aw$6 */
    class C290486 implements C34953a {
        C290486() {
        }

        /* renamed from: kJ */
        public final void mo47130kJ(boolean z) {
            AppMethodBeat.m2504i(36687);
            if (!z) {
                C29050aw.this.cmp();
            }
            AppMethodBeat.m2505o(36687);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.aw$a */
    public interface C29049a {
        /* renamed from: ad */
        void mo25756ad(int i, boolean z);

        void coo();
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.aw$1 */
    class C290511 implements Runnable {
        C290511() {
        }

        public final void run() {
            AppMethodBeat.m2504i(36682);
            C29050aw.m46142a(C29050aw.this);
            AppMethodBeat.m2505o(36682);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.aw$2 */
    class C290522 implements Runnable {
        C290522() {
        }

        public final void run() {
            C46236n c46236n = null;
            AppMethodBeat.m2504i(36683);
            if (C13373af.cnn()) {
                C4990ab.m7412e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                AppMethodBeat.m2505o(36683);
                return;
            }
            C29050aw.m46149b(C29050aw.this);
            if (C13373af.cnn()) {
                C4990ab.m7412e("MicroMsg.UploadManager", "is invalid after checkTLE");
                AppMethodBeat.m2505o(36683);
                return;
            }
            C39789o cnF = C13373af.cnF();
            C46236n c46236n2 = new C46236n();
            String str = "select *,rowid from SnsInfo  where " + C39789o.rfs + " order by SnsInfo.rowid asc ";
            Cursor a = cnF.bSd.mo10104a(str, null, 2);
            C4990ab.m7410d("MicroMsg.SnsInfoStorage", "getLastUpload ".concat(String.valueOf(str)));
            if (a.moveToFirst()) {
                c46236n2.mo8995d(a);
                a.close();
                c46236n = c46236n2;
            } else {
                a.close();
            }
            if (c46236n == null) {
                C4990ab.m7410d("MicroMsg.UploadManager", "All has post");
                AppMethodBeat.m2505o(36683);
            } else if (C13373af.cnE().mo37392CR(c46236n.reX)) {
                C4990ab.m7410d("MicroMsg.UploadManager", "checking isPosting " + c46236n.reX);
                AppMethodBeat.m2505o(36683);
            } else {
                C4990ab.m7410d("MicroMsg.UploadManager", "checking startPost " + c46236n.cqU());
                C29050aw.m46146a(C29050aw.this, c46236n);
                AppMethodBeat.m2505o(36683);
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ boolean m46149b(C29050aw c29050aw) {
        AppMethodBeat.m2504i(36712);
        boolean com = c29050aw.com();
        AppMethodBeat.m2505o(36712);
        return com;
    }

    public C29050aw() {
        AppMethodBeat.m2504i(36691);
        AppMethodBeat.m2505o(36691);
    }

    public final String cnk() {
        AppMethodBeat.m2504i(36692);
        if (this.ecX == null || this.ecX.equals("")) {
            C1720g.m3537RQ();
            this.ecX = (String) C1720g.m3536RP().mo5239Ry().get(2, null);
        }
        String str = this.ecX;
        AppMethodBeat.m2505o(36692);
        return str;
    }

    public final void start() {
        AppMethodBeat.m2504i(36693);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(207, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(209, (C1202f) this);
        AppMethodBeat.m2505o(36693);
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
    /* renamed from: a */
    private void m46143a(C46236n c46236n, int i, int i2, String str) {
        int i3;
        C18386rp c18386rp;
        AppMethodBeat.m2504i(36694);
        C4990ab.m7416i("MicroMsg.UploadManager", "localId " + c46236n.cqU() + "processError " + i2 + " errMsg: " + str);
        C7060h.pYm.mo8378a(22, 129, 1, true);
        if (i != 0) {
            try {
                i3 = ((bax) new bax().parseFrom(C13373af.cnu().mo25635kE((long) i).rfI)).wFm;
                try {
                    bav cqM = c46236n.cqM();
                    if (cqM != null) {
                        cqM.wFm = i3;
                        c46236n.field_postBuf = cqM.toByteArray();
                    }
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.UploadManager", "parse uploadInfo error");
                    C4990ab.m7410d("MicroMsg.UploadManager", "post error ".concat(String.valueOf(i3)));
                    c46236n.cqY();
                    C13373af.cnF().mo62928b(c46236n.reX, c46236n);
                    C4990ab.m7410d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + c46236n.reX);
                    c18386rp = new C18386rp();
                    c18386rp.cNA.cNB = (long) c46236n.reX;
                    C4879a.xxA.mo10055m(c18386rp);
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
                    m46147ac(c46236n.reX, false);
                    AppMethodBeat.m2505o(36694);
                }
            } catch (Exception e2) {
                i3 = 0;
                C4990ab.m7412e("MicroMsg.UploadManager", "parse uploadInfo error");
                C4990ab.m7410d("MicroMsg.UploadManager", "post error ".concat(String.valueOf(i3)));
                c46236n.cqY();
                C13373af.cnF().mo62928b(c46236n.reX, c46236n);
                C4990ab.m7410d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + c46236n.reX);
                c18386rp = new C18386rp();
                c18386rp.cNA.cNB = (long) c46236n.reX;
                C4879a.xxA.mo10055m(c18386rp);
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
                m46147ac(c46236n.reX, false);
                AppMethodBeat.m2505o(36694);
            }
        }
        bav cqM2 = c46236n.cqM();
        i3 = cqM2 != null ? cqM2.wFm : 0;
        C4990ab.m7410d("MicroMsg.UploadManager", "post error ".concat(String.valueOf(i3)));
        c46236n.cqY();
        C13373af.cnF().mo62928b(c46236n.reX, c46236n);
        C4990ab.m7410d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + c46236n.reX);
        c18386rp = new C18386rp();
        c18386rp.cNA.cNB = (long) c46236n.reX;
        C4879a.xxA.mo10055m(c18386rp);
        switch (i2) {
            case 1:
                C4990ab.m7412e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
                break;
            case 2:
                C4990ab.m7412e("MicroMsg.UploadManager", "parser protobuf error");
                break;
            case 3:
                C4990ab.m7412e("MicroMsg.UploadManager", "local id is not in db");
                break;
            case 4:
                C4990ab.m7412e("MicroMsg.UploadManager", "arg is error");
                break;
            case 5:
                C4990ab.m7412e("MicroMsg.UploadManager", "pullTimeLineXml  error");
                break;
            case 6:
                C4990ab.m7412e("MicroMsg.UploadManager", "errtle  error");
                break;
        }
        m46147ac(c46236n.reX, false);
        AppMethodBeat.m2505o(36694);
    }

    /* renamed from: a */
    private void m46144a(C46236n c46236n, int i, String str) {
        AppMethodBeat.m2504i(36695);
        m46143a(c46236n, 0, i, str);
        AppMethodBeat.m2505o(36695);
    }

    /* renamed from: Db */
    private static int m46137Db(int i) {
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

    /* renamed from: fU */
    public final boolean mo37363fU(String str, String str2) {
        AppMethodBeat.m2504i(36696);
        C4990ab.m7410d("MicroMsg.UploadManager", "imgPath " + str + " text " + str2);
        String str3 = C13373af.getAccSnsTmpPath() + C1178g.m2591x(str.getBytes());
        C5730e.m8644y(str, str3);
        C29054ax c29054ax = new C29054ax(1);
        c29054ax.mo47144Ym(str2);
        c29054ax.mo47142Dh(6);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new C21881h(str3, 2));
        c29054ax.mo47163dh(linkedList);
        if (c29054ax.commit() > 0) {
            AppMethodBeat.m2505o(36696);
            return true;
        }
        AppMethodBeat.m2505o(36696);
        return false;
    }

    /* renamed from: b */
    public static C29054ax m46148b(WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        int i;
        AppMethodBeat.m2504i(36697);
        C4990ab.m7410d("MicroMsg.UploadManager", "appmsg.description " + wXMediaMessage.description);
        C4990ab.m7410d("MicroMsg.UploadManager", "appmsg.title " + wXMediaMessage.title);
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
        C29054ax c29054ax = new C29054ax(i);
        c29054ax.mo47150Ys(C5046bo.m7532bc(str2, "")).mo47151Yt(C5046bo.m7532bc(str3, ""));
        c29054ax.mo47142Dh(5);
        C4990ab.m7410d("MicroMsg.UploadManager", "TimeLineType ".concat(String.valueOf(i)));
        if (i == -1) {
            C4990ab.m7410d("MicroMsg.UploadManager", "timeLineType is invalid");
            AppMethodBeat.m2505o(36697);
            return null;
        }
        if (!C5046bo.isNullOrNil(str)) {
            c29054ax.mo47144Ym(str);
        }
        c29054ax.mo47149Yr(C5046bo.m7532bc(wXMediaMessage.title, "")).mo47147Yp(C5046bo.m7532bc(wXMediaMessage.description, ""));
        int Db;
        switch (iMediaObject.type()) {
            case 1:
                WXTextObject wXTextObject = (WXTextObject) iMediaObject;
                c29054ax.mo47147Yp("");
                c29054ax.mo47144Ym(wXTextObject.text);
                break;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) iMediaObject;
                if (C5046bo.m7540cb(wXImageObject.imageData)) {
                    if (C5046bo.isNullOrNil(wXImageObject.imagePath)) {
                        C4990ab.m7412e("MicroMsg.UploadManager", "share img but no res is exist!");
                        AppMethodBeat.m2505o(36697);
                        return null;
                    } else if (!c29054ax.mo47166ge(wXImageObject.imagePath, "")) {
                        AppMethodBeat.m2505o(36697);
                        return null;
                    }
                } else if (!c29054ax.mo47160b(wXImageObject.imageData, "", "")) {
                    AppMethodBeat.m2505o(36697);
                    return null;
                }
                break;
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
                String bc = C5046bo.m7532bc(!C5046bo.isNullOrNil(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                String bc2 = C5046bo.m7532bc(!C5046bo.isNullOrNil(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                c29054ax.mo47149Yr("").mo47147Yp("");
                Db = C29050aw.m46137Db(3);
                if (Db == -1) {
                    C4990ab.m7410d("MicroMsg.UploadManager", "mediaType is invalid");
                    AppMethodBeat.m2505o(36697);
                    return null;
                }
                if (!c29054ax.mo47156a(wXMediaMessage.thumbData, bc, C5046bo.m7532bc(!C5046bo.isNullOrNil(wXMusicObject.musicLowBandDataUrl) ? wXMusicObject.musicLowBandDataUrl : wXMusicObject.musicLowBandUrl, ""), bc2, Db, C5046bo.m7532bc(wXMediaMessage.title, ""), C5046bo.m7532bc(wXMediaMessage.description, ""))) {
                    AppMethodBeat.m2505o(36697);
                    return null;
                }
                break;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
                c29054ax.mo47149Yr("").mo47147Yp("");
                Db = C29050aw.m46137Db(4);
                if (Db == -1) {
                    C4990ab.m7410d("MicroMsg.UploadManager", "mediaType is invalid");
                    AppMethodBeat.m2505o(36697);
                    return null;
                }
                if (!c29054ax.mo47156a(wXMediaMessage.thumbData, C5046bo.m7532bc(!C5046bo.isNullOrNil(wXVideoObject.videoUrl) ? wXVideoObject.videoUrl : wXVideoObject.videoLowBandUrl, ""), wXVideoObject.videoLowBandUrl, wXVideoObject.videoUrl, Db, C5046bo.m7532bc(wXMediaMessage.title, ""), C5046bo.m7532bc(wXMediaMessage.description, ""))) {
                    AppMethodBeat.m2505o(36697);
                    return null;
                }
                break;
            case 5:
                WXWebpageObject wXWebpageObject = (WXWebpageObject) iMediaObject;
                if (!C5046bo.m7540cb(wXMediaMessage.thumbData)) {
                    c29054ax.mo47160b(wXMediaMessage.thumbData, C5046bo.m7532bc(wXMediaMessage.description, ""), C5046bo.m7532bc(wXMediaMessage.title, ""));
                }
                c29054ax.mo47147Yp(wXWebpageObject.webpageUrl).mo47148Yq(wXWebpageObject.webpageUrl);
                c29054ax.qNK.xfI.Url = wXWebpageObject.webpageUrl;
                c29054ax.mo47146Yo(wXWebpageObject.canvasPageXml);
                break;
            case 6:
                C4990ab.m7412e("MicroMsg.UploadManager", "file is not support!");
                AppMethodBeat.m2505o(36697);
                return null;
            case 7:
                WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) iMediaObject;
                if (!C5046bo.isNullOrNil(wXAppExtendObject.filePath) && wXAppExtendObject.filePath.startsWith("http")) {
                    c29054ax.mo47149Yr(wXAppExtendObject.filePath);
                    c29054ax.mo47147Yp(wXAppExtendObject.filePath);
                    break;
                }
                C4990ab.m7412e("MicroMsg.UploadManager", "appdata is not support!");
                AppMethodBeat.m2505o(36697);
                return null;
            default:
                C4990ab.m7412e("MicroMsg.UploadManager", "none type not support!");
                AppMethodBeat.m2505o(36697);
                return null;
        }
        AppMethodBeat.m2505o(36697);
        return c29054ax;
    }

    /* renamed from: a */
    public final boolean mo37361a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i) {
        AppMethodBeat.m2504i(36698);
        C29054ax b = C29050aw.m46148b(wXMediaMessage, str, str2, str3);
        if (b == null) {
            AppMethodBeat.m2505o(36698);
            return false;
        }
        b.mo47145Yn(wXMediaMessage.mediaTagName);
        b.mo47157af(str2, wXMediaMessage.messageExt, wXMediaMessage.messageAction);
        if (i > C24826a.qFE) {
            b.mo47138Dd(1);
        }
        C4990ab.m7410d("MicroMsg.UploadManager", "shareAppMsg set and the result: ".concat(String.valueOf(b.commit())));
        AppMethodBeat.m2505o(36698);
        return true;
    }

    /* renamed from: t */
    private boolean m46152t(C46236n c46236n) {
        AppMethodBeat.m2504i(36699);
        if (c46236n == null) {
            AppMethodBeat.m2505o(36699);
            return false;
        }
        TimeLineObject cqu = c46236n.cqu();
        if (cqu.xfI.wbJ == 8) {
            AppMethodBeat.m2505o(36699);
            return true;
        } else if (cqu.xfI.wbJ == 2) {
            AppMethodBeat.m2505o(36699);
            return true;
        } else {
            if (cqu.xfI.wbJ == 26) {
                C37721gh c37721gh = new C37721gh();
                c37721gh.cAH.type = 30;
                c37721gh.cAH.cAO = 5;
                c37721gh.cAH.desc = cqu.xfI.wbM;
                c37721gh.cAH.cAN = String.valueOf(c46236n.reX);
                C4879a.xxA.mo10055m(c37721gh);
                if (c37721gh.cAI.ret != 1) {
                    AppMethodBeat.m2505o(36699);
                    return false;
                }
            }
            if (cqu == null || cqu.xfI.wbK == null) {
                m46144a(c46236n, 1, "timeline or timelineObjList is null");
                AppMethodBeat.m2505o(36699);
                return false;
            } else if (cqu.xfI.wbK.size() == 0) {
                AppMethodBeat.m2505o(36699);
                return true;
            } else {
                try {
                    boolean z;
                    boolean z2;
                    bav bav = (bav) new bav().parseFrom(c46236n.field_postBuf);
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
                            C13422b Dc = m46138Dc(ayq.wCt);
                            if (Dc == C13422b.STATE_ERROR) {
                                m46143a(c46236n, ayq.wCt, 2, "upload has set it fail");
                                AppMethodBeat.m2505o(36699);
                                return false;
                            } else if (Dc == C13422b.STATE_FALSE) {
                                AppMethodBeat.m2505o(36699);
                                return false;
                            }
                        }
                        AppMethodBeat.m2505o(36699);
                        return true;
                    }
                    Iterator it2 = bav.wFf.iterator();
                    while (it2.hasNext()) {
                        ayq ayq2 = (ayq) it2.next();
                        C13422b a = m46139a(ayq2.wCt, z2, bav, cqu.xfI.wbJ);
                        if (a == C13422b.STATE_ERROR) {
                            m46143a(c46236n, ayq2.wCt, 2, "upload has set it fail");
                            AppMethodBeat.m2505o(36699);
                            return false;
                        } else if (a == C13422b.STATE_FALSE) {
                            AppMethodBeat.m2505o(36699);
                            return false;
                        }
                    }
                    AppMethodBeat.m2505o(36699);
                    return true;
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + c46236n.cqU());
                    m46144a(c46236n, 2, "mediaPostInfo parser error " + e.getMessage());
                    AppMethodBeat.m2505o(36699);
                    return false;
                }
            }
        }
    }

    /* renamed from: u */
    public final void mo47134u(C46236n c46236n) {
        AppMethodBeat.m2504i(36700);
        if (c46236n == null) {
            AppMethodBeat.m2505o(36700);
            return;
        }
        bav bav;
        C4990ab.m7416i("MicroMsg.UploadManager", "cancel snsinfo " + c46236n.cqU());
        try {
            bav = (bav) new bav().parseFrom(c46236n.field_postBuf);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + c46236n.cqU());
            m46144a(c46236n, 2, "mediaPostInfo parser error " + e.getMessage());
            bav = null;
        }
        if (!(bav == null || bav.wFf == null)) {
            Iterator it = bav.wFf.iterator();
            while (it.hasNext()) {
                ayq ayq = (ayq) it.next();
                int CX = C13373af.cnE().mo37398CX(ayq.wCt);
                C13373af.cnE().mo37397CW(ayq.wCt);
                C4990ab.m7417i("MicroMsg.UploadManager", "cancel upload %d", Integer.valueOf(CX));
                if (c46236n.field_type != 15 && CX >= 0) {
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.cancel(CX);
                    C13373af.cnE().mo37396CV(ayq.wCt);
                }
            }
        }
        if (C13373af.cnE().mo37392CR(c46236n.reX) && this.qNn != null) {
            C4990ab.m7416i("MicroMsg.UploadManager", "cancel post");
            this.qNn.ekq = true;
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14547c(this.qNn);
            C13373af.cnE().mo37394CT(c46236n.reX);
        }
        C46236n DK = C13373af.cnF().mo62914DK(c46236n.reX);
        if (!(DK == null || DK.field_snsId == 0)) {
            C13373af.cnE().mo37410km(DK.field_snsId);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(new C46224r(DK.field_snsId, 1), 0);
        }
        C13373af.cnF().mo62915DL(c46236n.reX);
        if (c46236n.field_type == 21) {
            C21905g.cmv().cmx();
        }
        C4990ab.m7410d("MicroMsg.UploadManager", "cancelPost, publish SnsPostFailEvent, snsInfoLocalId " + c46236n.cqU());
        C18386rp c18386rp = new C18386rp();
        c18386rp.cNA.cNB = (long) c46236n.reX;
        C4879a.xxA.mo10055m(c18386rp);
        AppMethodBeat.m2505o(36700);
    }

    public final void cmp() {
        AppMethodBeat.m2504i(36701);
        C13373af.bCo().postDelayed(new C290511(), 1000);
        AppMethodBeat.m2505o(36701);
    }

    private boolean com() {
        AppMethodBeat.m2504i(36702);
        C39789o cnF = C13373af.cnF();
        String str = "select *,rowid from SnsInfo  where " + C39789o.rfs + " order by SnsInfo.rowid asc ";
        Cursor rawQuery = cnF.bSd.rawQuery(str, null);
        C4990ab.m7410d("MicroMsg.SnsInfoStorage", "getLastUpload ".concat(String.valueOf(str)));
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            rawQuery = null;
        } else {
            rawQuery.moveToFirst();
        }
        C46236n c46236n = new C46236n();
        if (rawQuery == null) {
            AppMethodBeat.m2505o(36702);
            return false;
        }
        rawQuery.moveToFirst();
        do {
            c46236n.mo8995d(rawQuery);
            try {
                bav bav = (bav) new bav().parseFrom(c46236n.field_postBuf);
                if (C46236n.m86475kC(bav.wFi)) {
                    C29050aw.m46145a(bav);
                    m46144a(c46236n, 6, "snsinfo is tle");
                    C4990ab.m7416i("MicroMsg.UploadManager", "checkTLE snsinfo localId it time limit " + c46236n.cqU() + " is die ");
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
                m46144a(c46236n, 2, "MediaPostInfo parser error");
            }
        } while (rawQuery.moveToNext());
        rawQuery.close();
        AppMethodBeat.m2505o(36702);
        return true;
    }

    /* renamed from: a */
    private static TimeLineObject m46141a(C46236n c46236n, bav bav) {
        AppMethodBeat.m2504i(36703);
        TimeLineObject cqu = c46236n.cqu();
        ayt ayt = cqu.xfG;
        String str = cqu.xfF;
        String str2 = cqu.ijx;
        String str3 = cqu.vjM;
        String str4 = cqu.xfI.Desc;
        String str5 = cqu.xfI.Title;
        String str6 = cqu.xfI.Url;
        String str7 = cqu.xfI.wbM;
        C44113ds c44113ds = cqu.xfH;
        cth cth = cqu.xfO;
        int i = cqu.xfI.wbJ;
        int i2 = cqu.xfI.wbL;
        TimeLineObject ajM = C37953e.ajM();
        ajM.jBB = c46236n.field_userName;
        ajM.wEJ = c46236n.field_pravited;
        ajM.xfF = str;
        ajM.ijx = C5046bo.nullAsNil(str2);
        ajM.vjM = C5046bo.nullAsNil(str3);
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
        if (c44113ds != null) {
            ajM.xfH = c44113ds;
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
        C32800b y = C37922v.m64076Zp().mo60676y(bav.cvF, true);
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
        AppMethodBeat.m2505o(36703);
        return ajM;
    }

    /* renamed from: v */
    private boolean m46153v(C46236n c46236n) {
        AppMethodBeat.m2504i(36704);
        try {
            bav bav = (bav) new bav().parseFrom(c46236n.field_postBuf);
            bav.eRu++;
            c46236n.field_postBuf = bav.toByteArray();
            C13373af.cnF().mo62928b(c46236n.reX, c46236n);
            if (C46236n.m86475kC(bav.wFi)) {
                m46144a(c46236n, 6, "this item isTimeLimit");
                C4990ab.m7416i("MicroMsg.UploadManager", "snsinfo localId it time limit " + c46236n.cqU() + " is die ");
                AppMethodBeat.m2505o(36704);
                return false;
            }
            C4990ab.m7416i("MicroMsg.UploadManager", "try start post " + c46236n.cqU());
            if (m46152t(c46236n)) {
                String str;
                TimeLineObject cqu = c46236n.cqu();
                TimeLineObject a = C29050aw.m46141a(c46236n, bav);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= bav.wFf.size()) {
                        break;
                    }
                    i = ((ayq) bav.wFf.get(i2)).wCt;
                    C29098r kE = C13373af.cnu().mo25635kE((long) i);
                    if (kE == null) {
                        m46144a(c46236n, 3, "can not get the media from db ,localMediaId: ".concat(String.valueOf(i)));
                        AppMethodBeat.m2505o(36704);
                        return false;
                    }
                    try {
                        bax bax = (bax) new bax().parseFrom(kE.rfI);
                        if (bax.wFA == null || bax.wFC.size() <= 0) {
                            C4990ab.m7412e("MicroMsg.UploadManager", "item with not url" + c46236n.field_type);
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
                                a2 = C37953e.m64184a(kE.rfH, kE.type, str, str2, i3, i4, bax.wEJ, "", baw);
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
                                m46144a(c46236n, 3, "make media error");
                                AppMethodBeat.m2505o(36704);
                                return false;
                            }
                            a.xfI.wbK.add(a2);
                            i = i2 + 1;
                        }
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.UploadManager", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
                        m46144a(c46236n, 2, "mediaUploadInfo parser error " + e.getMessage());
                        AppMethodBeat.m2505o(36704);
                        return false;
                    }
                }
                C4990ab.m7412e("MicroMsg.UploadManager", "item with not url" + c46236n.field_type);
                if (c46236n.field_type != 3) {
                    m46144a(c46236n, 4, "buf url is null");
                    AppMethodBeat.m2505o(36704);
                    return false;
                }
                if (C13373af.cnE().mo37393CS(c46236n.reX)) {
                    final LinkedList linkedList = new LinkedList();
                    Iterator it = bav.wFg.iterator();
                    while (it.hasNext()) {
                        linkedList.add(((cco) it.next()).jBB);
                    }
                    str = C21898j.m33468b(a);
                    C4990ab.m7410d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + a.xfL + " contentDescShowType: " + a.xfK);
                    if (c46236n.field_pravited == 1) {
                        C4990ab.m7416i("MicroMsg.UploadManager", "content private xml is null ? " + C5046bo.isNullOrNil(str));
                    } else {
                        C4990ab.m7417i("MicroMsg.UploadManager", "upload xmlsns: %s", str);
                    }
                    if (str == null || str.equals("")) {
                        m46144a(c46236n, 5, "content is error");
                        C13373af.cnE().mo37394CT(c46236n.reX);
                        AppMethodBeat.m2505o(36704);
                        return false;
                    }
                    boolean z;
                    if (bav.wFo == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    final int i5 = c46236n.reX;
                    final LinkedList linkedList2 = bav.wFp;
                    final C1332b c1332b = a.xfG.wCG;
                    final String str4 = a.xfI.Title;
                    final bav bav2 = bav;
                    final TimeLineObject timeLineObject = cqu;
                    C13373af.bCo().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(36685);
                            if (C13373af.cnn()) {
                                C4990ab.m7412e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                                AppMethodBeat.m2505o(36685);
                                return;
                            }
                            C29050aw.this.qNn = new C34959s(str, bav2.wEJ, bav2.wFe, linkedList, timeLineObject, i5, bav2.ptv, bav2.wFj, bav2.wFk, bav2.wFl, bav2, z, linkedList2, bav2.wFq, c1332b, str4);
                            C1720g.m3537RQ();
                            C1720g.m3535RO().eJo.mo14541a(C29050aw.this.qNn, 0);
                            AppMethodBeat.m2505o(36685);
                        }
                    });
                } else {
                    C4990ab.m7410d("MicroMsg.UploadManager", "this snsinfo is posting");
                    AppMethodBeat.m2505o(36704);
                    return false;
                }
            }
            C4990ab.m7410d("MicroMsg.UploadManager", "startPost, canPost is false, snsInfoId: " + c46236n.cqU());
            AppMethodBeat.m2505o(36704);
            return true;
        } catch (Exception e2) {
            C4990ab.m7412e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
            m46144a(c46236n, 2, "MediaPostInfo parser error:" + e2.getMessage());
            AppMethodBeat.m2505o(36704);
            return false;
        }
    }

    /* renamed from: ac */
    private void m46147ac(final int i, final boolean z) {
        AppMethodBeat.m2504i(36705);
        C13373af.bCo().post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(36684);
                if (C13373af.cnn()) {
                    C4990ab.m7412e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                    AppMethodBeat.m2505o(36684);
                    return;
                }
                for (C29049a c29049a : C29050aw.this.epg) {
                    if (c29049a != null) {
                        c29049a.mo25756ad(i, z);
                    }
                }
                AppMethodBeat.m2505o(36684);
            }
        });
        AppMethodBeat.m2505o(36705);
    }

    /* renamed from: a */
    private C13422b m46139a(int i, boolean z, bav bav, int i2) {
        AppMethodBeat.m2504i(36706);
        C13422b c13422b;
        if (i == -1) {
            C4990ab.m7412e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media");
            c13422b = C13422b.STATE_ERROR;
            AppMethodBeat.m2505o(36706);
            return c13422b;
        }
        C29098r kE = C13373af.cnu().mo25635kE((long) i);
        try {
            bax bax = (bax) new bax().parseFrom(kE.rfI);
            C4990ab.m7416i("MicroMsg.UploadManager", "state " + bax.wFD + " pic isMuti: " + z);
            if (bax.wFD == 1) {
                c13422b = C13422b.STATE_ERROR;
                AppMethodBeat.m2505o(36706);
                return c13422b;
            }
            String str = C3892an.m6198fZ(C13373af.getAccSnsPath(), kE.rfE) + C29036i.m46082Xe(kE.rfE);
            if (C5730e.asZ(str) == 0) {
                C4990ab.m7416i("MicroMsg.UploadManager", "path not exist  ".concat(String.valueOf(str)));
                c13422b = C13422b.STATE_ERROR;
                AppMethodBeat.m2505o(36706);
                return c13422b;
            } else if (bax.wFD == 0) {
                c13422b = C13422b.STATE_OK;
                AppMethodBeat.m2505o(36706);
                return c13422b;
            } else {
                if (C13373af.cnE().mo37395CU(i)) {
                    C13373af.cnu().mo25631a(i, kE);
                    final String x = C1178g.m2591x((C5046bo.m7588yz() + " " + System.currentTimeMillis()).getBytes());
                    final int i3 = i;
                    final boolean z2 = z;
                    final bav bav2 = bav;
                    final int i4 = i2;
                    C13373af.bCo().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(36686);
                            if (C13373af.cnn()) {
                                C4990ab.m7412e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                                AppMethodBeat.m2505o(36686);
                                return;
                            }
                            C1207m c39762z = new C39762z(i3, x, z2, i4);
                            C13373af.cnE().mo37407fk(i3, c39762z.hashCode());
                            C1720g.m3537RQ();
                            C1720g.m3535RO().eJo.mo14541a(c39762z, 0);
                            AppMethodBeat.m2505o(36686);
                        }
                    });
                }
                c13422b = C13422b.STATE_FALSE;
                AppMethodBeat.m2505o(36706);
                return c13422b;
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.UploadManager", "parse uploadInfo error");
            c13422b = C13422b.STATE_ERROR;
            AppMethodBeat.m2505o(36706);
            return c13422b;
        }
    }

    /* renamed from: a */
    private static void m46145a(bav bav) {
        AppMethodBeat.m2504i(36707);
        if (bav == null) {
            AppMethodBeat.m2505o(36707);
            return;
        }
        Iterator it = bav.wFf.iterator();
        while (it.hasNext()) {
            C13373af.cnE().mo37396CV(((ayq) it.next()).wCt);
        }
        AppMethodBeat.m2505o(36707);
    }

    /* renamed from: Dc */
    private C13422b m46138Dc(int i) {
        AppMethodBeat.m2504i(36708);
        C13422b c13422b;
        if (i == -1) {
            C4990ab.m7412e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media doUploadSight");
            c13422b = C13422b.STATE_ERROR;
            AppMethodBeat.m2505o(36708);
            return c13422b;
        }
        C29098r kE = C13373af.cnu().mo25635kE((long) i);
        try {
            bax bax = (bax) new bax().parseFrom(kE.rfI);
            C4990ab.m7416i("MicroMsg.UploadManager", "state " + bax.wFD + " doUploadSight, serverErr:" + bax.wFm);
            if (bax.wFD == 1) {
                c13422b = C13422b.STATE_ERROR;
                AppMethodBeat.m2505o(36708);
                return c13422b;
            } else if (C5730e.asZ(bax.videoPath) == 0) {
                C4990ab.m7416i("MicroMsg.UploadManager", "path not fileexist  " + bax.videoPath);
                c13422b = C13422b.STATE_ERROR;
                AppMethodBeat.m2505o(36708);
                return c13422b;
            } else if (C5730e.asZ(bax.wFF) == 0) {
                C4990ab.m7416i("MicroMsg.UploadManager", "thumbpath not fileexist  " + bax.wFF);
                c13422b = C13422b.STATE_ERROR;
                AppMethodBeat.m2505o(36708);
                return c13422b;
            } else if (bax.wFD == 0) {
                c13422b = C13422b.STATE_OK;
                AppMethodBeat.m2505o(36708);
                return c13422b;
            } else {
                if (C13373af.cnE().mo37395CU(i)) {
                    C13373af.cnu().mo25631a(i, kE);
                    new C46220ac(i, kE, bax.videoPath, bax.wFF, this.qNo).cne();
                }
                c13422b = C13422b.STATE_FALSE;
                AppMethodBeat.m2505o(36708);
                return c13422b;
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.UploadManager", "parse uploadInfo error doUploadSight");
            c13422b = C13422b.STATE_ERROR;
            AppMethodBeat.m2505o(36708);
            return c13422b;
        }
    }

    public final void con() {
        AppMethodBeat.m2504i(36709);
        for (C29049a c29049a : this.epg) {
            if (c29049a != null) {
                c29049a.coo();
            }
        }
        AppMethodBeat.m2505o(36709);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(36710);
        C4990ab.m7416i("MicroMsg.UploadManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + c1207m.getType() + " @" + hashCode());
        switch (c1207m.getType()) {
            case 207:
                if (!(i == 0 && i2 == 0)) {
                    cmp();
                    break;
                }
            case 209:
                C34959s c34959s = (C34959s) c1207m;
                int i3 = c34959s.cNE;
                if (c34959s.ekq) {
                    long j = c34959s.qJo;
                    C4990ab.m7417i("MicroMsg.UploadManager", "get the del post come back %d ".concat(String.valueOf(j)), Integer.valueOf(i3));
                    if (j != 0) {
                        C13373af.cnE().mo37410km(j);
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(new C46224r(j, 1), 0);
                    }
                    C13373af.cnF().mo62915DL(i3);
                    if (j != 0) {
                        C13373af.cnK().mo47208ky(j);
                        C21991i.m33620kx(j);
                    }
                }
                if (i == 0 && i2 == 0) {
                    m46147ac(c34959s.cNE, true);
                    C34956ak.m57410iN(c34959s.qJo);
                } else {
                    m46147ac(c34959s.cNE, false);
                }
                this.qNn = null;
                break;
        }
        if (i == 0 && i2 == 0) {
            AppMethodBeat.m2505o(36710);
        } else {
            AppMethodBeat.m2505o(36710);
        }
    }
}
