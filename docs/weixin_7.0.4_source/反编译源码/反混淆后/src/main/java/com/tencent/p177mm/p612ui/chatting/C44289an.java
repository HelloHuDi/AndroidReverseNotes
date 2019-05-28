package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.openim.room.p266a.C42249a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.gallery.model.C39159k;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.record.p492b.C43436n;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d.C40433a;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44099c;
import com.tencent.p177mm.protocal.protobuf.aap;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aat;
import com.tencent.p177mm.protocal.protobuf.aay;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5136b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWMediaConversation;
import com.tencent.wework.api.model.WWMediaFile;
import com.tencent.wework.api.model.WWMediaImage;
import com.tencent.wework.api.model.WWMediaLink;
import com.tencent.wework.api.model.WWMediaLocation;
import com.tencent.wework.api.model.WWMediaMergedConvs;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;
import com.tencent.wework.api.model.WWMediaMiniProgram;
import com.tencent.wework.api.model.WWMediaText;
import com.tencent.wework.api.model.WWMediaVideo;
import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.an */
public final class C44289an {

    /* renamed from: com.tencent.mm.ui.chatting.an$a */
    static class C5305a extends Exception {
        private C5305a() {
        }

        /* synthetic */ C5305a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.an$1 */
    public static class C407111 implements OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.an$2 */
    public static class C407122 implements OnClickListener {
        final /* synthetic */ C7616ad emj;
        final /* synthetic */ Context val$context;
        final /* synthetic */ List yMq;
        final /* synthetic */ boolean yMr;

        public C407122(Context context, C7616ad c7616ad, List list, boolean z) {
            this.val$context = context;
            this.emj = c7616ad;
            this.yMq = list;
            this.yMr = z;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31034);
            C44289an.m80043a(this.val$context, this.emj, this.yMq, this.yMr);
            AppMethodBeat.m2505o(31034);
        }
    }

    /* renamed from: a */
    public static void m80043a(Context context, C7616ad c7616ad, List<C7620bi> list, boolean z) {
        AppMethodBeat.m2504i(31035);
        IWWAPI jv = WWAPIFactory.m50230jv(context);
        try {
            BaseMessage a;
            if (list.size() == 1) {
                a = C44289an.m80041a(c7616ad, (C7620bi) list.get(0), z);
            } else {
                a = C44289an.m80042a(c7616ad, (List) list, z);
            }
            jv.mo13198a(a);
            AppMethodBeat.m2505o(31035);
        } catch (C5305a e) {
            C30379h.m48467g(context, C25738R.string.e3m, C25738R.string.f9238tz);
            AppMethodBeat.m2505o(31035);
        }
    }

    /* renamed from: a */
    private static WWMediaObject m80041a(C7616ad c7616ad, C7620bi c7620bi, boolean z) {
        AppMethodBeat.m2504i(31036);
        int type = c7620bi.getType();
        WWMediaObject aZ;
        if (type == 1) {
            WWMediaText wWMediaText = new WWMediaText(C40788j.m70679v(c7620bi.field_content, c7620bi.field_isSend, z));
            AppMethodBeat.m2505o(31036);
            return wWMediaText;
        } else if (type == 3) {
            aZ = C44289an.m80044aZ(c7620bi);
            AppMethodBeat.m2505o(31036);
            return aZ;
        } else if (type == 43) {
            aZ = new WWMediaVideo();
            C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
            C37961o.all();
            aZ.filePath = C9720t.m17303uh(ut.getFileName());
            C4990ab.m7417i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", aZ.filePath);
            AppMethodBeat.m2505o(31036);
            return aZ;
        } else if (type == 48) {
            aZ = new WWMediaLocation();
            String v = C40788j.m70679v(c7620bi.field_content, c7620bi.field_isSend, z);
            C9638aw.m17190ZK();
            C5136b Ro = C18628c.m29080XO().mo15261Ro(v);
            aZ.title = Ro.eUu;
            aZ.fBg = Ro.label;
            aZ.longitude = Ro.nJv;
            aZ.latitude = Ro.nJu;
            aZ.ALG = (double) Ro.cED;
            AppMethodBeat.m2505o(31036);
            return aZ;
        } else if (type == 49 || type == 268435505) {
            aZ = C44289an.m80045b(c7616ad, c7620bi, z);
            AppMethodBeat.m2505o(31036);
            return aZ;
        } else {
            C4990ab.m7413e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", Integer.valueOf(type));
            AppMethodBeat.m2505o(31036);
            return null;
        }
    }

    /* renamed from: a */
    private static WWMediaObject m80042a(C7616ad c7616ad, List<C7620bi> list, boolean z) {
        AppMethodBeat.m2504i(31038);
        WWMediaMergedConvs wWMediaMergedConvs = new WWMediaMergedConvs();
        String str = c7616ad.field_username;
        Context context = C4996ah.getContext();
        if (z) {
            str = context.getString(C25738R.string.dja);
        } else {
            if (C1853r.m3820YB().equals(C1854s.m3865mI(str))) {
                str = context.getString(C25738R.string.bqj, new Object[]{C1853r.m3820YB()});
            } else {
                str = context.getString(C25738R.string.bqi, new Object[]{C1853r.m3820YB(), C1854s.m3865mI(str)});
            }
        }
        wWMediaMergedConvs.title = str;
        for (C7620bi c7620bi : list) {
            String Yz;
            WWMediaConversation wWMediaConversation = new WWMediaConversation();
            if (c7620bi.field_isSend == 1) {
                Yz = C1853r.m3846Yz();
            } else if (z) {
                Yz = C1829bf.m3762oy(c7620bi.field_content);
            } else {
                Yz = c7620bi.field_talker;
            }
            wWMediaConversation.name = C1854s.m3865mI(Yz) + C5046bo.nullAsNil(C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(Yz)));
            try {
                Bitmap a = C41730b.m73490a(Yz, false, -1);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(CompressFormat.JPEG, 50, byteArrayOutputStream);
                wWMediaConversation.ALE = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e) {
            }
            wWMediaConversation.pXQ = c7620bi.field_createTime;
            wWMediaConversation.ALF = C44289an.m80041a(c7616ad, c7620bi, z);
            wWMediaMergedConvs.mo65658a(wWMediaConversation);
        }
        AppMethodBeat.m2505o(31038);
        return wWMediaMergedConvs;
    }

    /* renamed from: a */
    private static WWMediaMergedConvs m80038a(aar aar, C7620bi c7620bi, C7616ad c7616ad, boolean z) {
        AppMethodBeat.m2504i(31041);
        WWMediaMergedConvs wWMediaMergedConvs = new WWMediaMergedConvs();
        if (aar == null) {
            AppMethodBeat.m2505o(31041);
            return wWMediaMergedConvs;
        }
        C44099c VI = C43436n.m77547VI(aar.whj);
        if (VI == null) {
            AppMethodBeat.m2505o(31041);
            return wWMediaMergedConvs;
        }
        wWMediaMergedConvs.title = VI.title;
        Iterator it = VI.fjr.iterator();
        while (it.hasNext()) {
            aar aar2 = (aar) it.next();
            WWMediaConversation wWMediaConversation = new WWMediaConversation();
            String str = aar2.wgV;
            if (C5046bo.isNullOrNil(aar2.whu)) {
                wWMediaConversation.name = str;
            } else {
                wWMediaConversation.name = str + aar2.whu;
            }
            try {
                aat aat = aar2.wgT.whw;
                if (aat.whQ) {
                    str = aat.cEV;
                } else if (aat.whV) {
                    str = aat.whU;
                } else {
                    str = "";
                }
                Bitmap a = C41730b.m73490a(str, false, -1);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(CompressFormat.JPEG, 50, byteArrayOutputStream);
                wWMediaConversation.ALE = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e) {
            }
            long j = 0;
            try {
                j = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(aar2.wgX).getTime();
            } catch (ParseException e2) {
            }
            wWMediaConversation.pXQ = j;
            wWMediaConversation.ALF = C44289an.m80040a(c7616ad, aar2, c7620bi, z);
            wWMediaMergedConvs.mo65658a(wWMediaConversation);
        }
        AppMethodBeat.m2505o(31041);
        return wWMediaMergedConvs;
    }

    /* renamed from: a */
    private static WWMediaObject m80040a(C7616ad c7616ad, aar aar, C7620bi c7620bi, boolean z) {
        AppMethodBeat.m2504i(31037);
        int i = aar.dataType;
        String c;
        WWMediaObject wWMediaImage;
        if (i == 1) {
            WWMediaText wWMediaText = new WWMediaText(aar.desc);
            AppMethodBeat.m2505o(31037);
            return wWMediaText;
        } else if (i == 2) {
            long j = c7620bi.field_msgId;
            if (C1445f.m3070Mn()) {
                c = C43436n.m77558c(aar, j);
                if (C5046bo.isNullOrNil(c)) {
                    c = C43436n.m77562f(aar, j);
                }
                if (C5046bo.isNullOrNil(c) || !C1173e.m2561ct(c)) {
                    C4990ab.m7411d("MicroMsg.RecordMsgImgService", "getPath file not exist, path[%s]", c);
                    c = null;
                }
            } else {
                c = null;
            }
            if (C5046bo.isNullOrNil(c)) {
                C4990ab.m7416i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_IMG not exist!");
                AppMethodBeat.m2505o(31037);
                return null;
            }
            wWMediaImage = new WWMediaImage();
            wWMediaImage.filePath = c;
            C4990ab.m7417i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", wWMediaImage.filePath);
            AppMethodBeat.m2505o(31037);
            return wWMediaImage;
        } else if (i == 4) {
            c = C43436n.m77558c(aar, c7620bi.field_msgId);
            if (C5046bo.isNullOrNil(c) || !C40433a.m69345ct(c)) {
                C4990ab.m7416i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_VIDEO not exist!");
                AppMethodBeat.m2505o(31037);
                return null;
            }
            wWMediaImage = new WWMediaVideo();
            wWMediaImage.filePath = c;
            C4990ab.m7417i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", wWMediaImage.filePath);
            AppMethodBeat.m2505o(31037);
            return wWMediaImage;
        } else if (i == 6) {
            WWMediaObject wWMediaLocation = new WWMediaLocation();
            if (aar.wgT == null) {
                C4990ab.m7416i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_LOC not exist!");
                AppMethodBeat.m2505o(31037);
                return null;
            }
            aay aay = aar.wgT.why;
            if (aay == null) {
                C4990ab.m7421w("MicroMsg.SendToWeWorkHelper", "location error, locItem null, dataid[%s]", aar.mnd);
                AppMethodBeat.m2505o(31037);
                return null;
            }
            wWMediaLocation.title = aay.cIK;
            wWMediaLocation.fBg = aay.label;
            wWMediaLocation.longitude = aay.lng;
            wWMediaLocation.latitude = aay.lat;
            wWMediaLocation.ALG = (double) aay.cED;
            AppMethodBeat.m2505o(31037);
            return wWMediaLocation;
        } else if (i == 8) {
            c = C43436n.m77558c(aar, c7620bi.field_msgId);
            if (C5046bo.isNullOrNil(c)) {
                C4990ab.m7421w("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_FILE title == null, dataid[%s]", aar.mnd);
                AppMethodBeat.m2505o(31037);
                return null;
            } else if (C40433a.m69347ek(c) > DownloadHelper.SAVE_LENGTH) {
                C5305a c5305a = new C5305a();
                AppMethodBeat.m2505o(31037);
                throw c5305a;
            } else {
                wWMediaImage = new WWMediaFile();
                wWMediaImage.fileName = aar.title;
                wWMediaImage.filePath = c;
                wWMediaImage.contentLengthLimit = 104857600;
                AppMethodBeat.m2505o(31037);
                return wWMediaImage;
            }
        } else if (i == 17) {
            wWMediaImage = C44289an.m80038a(aar, c7620bi, c7616ad, z);
            AppMethodBeat.m2505o(31037);
            return wWMediaImage;
        } else if (i == 19) {
            aap aap = aar.wgT.whN;
            wWMediaImage = new WWMediaMiniProgram();
            wWMediaImage.username = aap.username;
            wWMediaImage.path = aap.csu;
            wWMediaImage.iconUrl = aap.iconUrl;
            wWMediaImage.ALI = new byte[1];
            wWMediaImage.name = aap.wfO;
            wWMediaImage.title = "";
            C4990ab.m7411d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", wWMediaImage.username, wWMediaImage.path, wWMediaImage.iconUrl, Integer.valueOf(wWMediaImage.ALI.length), wWMediaImage.name, wWMediaImage.title);
            AppMethodBeat.m2505o(31037);
            return wWMediaImage;
        } else {
            C4990ab.m7413e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", Integer.valueOf(i));
            AppMethodBeat.m2505o(31037);
            return null;
        }
    }

    /* renamed from: aZ */
    private static WWMediaObject m80044aZ(C7620bi c7620bi) {
        C25822e fJ;
        AppMethodBeat.m2504i(31039);
        if (c7620bi.field_msgId > 0) {
            fJ = C32291o.ahl().mo73113fJ(c7620bi.field_msgId);
        } else {
            fJ = null;
        }
        if ((fJ == null || fJ.fDy <= 0) && c7620bi.field_msgSvrId > 0) {
            fJ = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
        }
        if (fJ == null) {
            AppMethodBeat.m2505o(31039);
            return null;
        }
        String q = C32291o.ahl().mo73118q(C37478f.m63227c(fJ), "", "");
        WWMediaObject wWMediaImage = new WWMediaImage();
        wWMediaImage.filePath = q;
        C4990ab.m7417i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", wWMediaImage.filePath);
        AppMethodBeat.m2505o(31039);
        return wWMediaImage;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x018d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static WWMediaObject m80045b(C7616ad c7616ad, C7620bi c7620bi, boolean z) {
        C8910b X;
        AppMethodBeat.m2504i(31040);
        String str = c7620bi.field_content;
        if (z) {
            int indexOf = c7620bi.field_content.indexOf(58);
            if (indexOf != -1) {
                str = c7620bi.field_content.substring(indexOf + 1);
            }
        }
        if (str != null) {
            X = C8910b.m16058X(str, c7620bi.field_reserved);
        } else {
            X = null;
        }
        if (X == null) {
            AppMethodBeat.m2505o(31040);
            return null;
        }
        WWMediaObject wWMediaImage;
        WWMediaObject wWMediaLink;
        switch (X.type) {
            case 2:
                if (X.csD != null && X.csD.length() > 0) {
                    C30065b aiE = C14877am.aUq().aiE(X.csD);
                    if (aiE != null && aiE.bCR()) {
                        str = aiE.field_fileFullPath;
                        if (C5730e.m8628ct(str)) {
                            wWMediaImage = new WWMediaImage();
                            wWMediaImage.filePath = str;
                            C4990ab.m7417i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", wWMediaImage.filePath);
                            AppMethodBeat.m2505o(31040);
                            return wWMediaImage;
                        }
                        C4990ab.m7417i("MicroMsg.SendToWeWorkHelper", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", str, Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId));
                        AppMethodBeat.m2505o(31040);
                        return null;
                    }
                }
                AppMethodBeat.m2505o(31040);
                return null;
            case 5:
                ByteArrayOutputStream byteArrayOutputStream;
                wWMediaLink = new WWMediaLink();
                wWMediaLink.webpageUrl = X.url;
                wWMediaLink.title = X.title;
                wWMediaLink.description = X.description;
                Bitmap a = C32291o.ahl().mo73087a(c7620bi.field_imgPath, C1338a.getDensity(null), false);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    a.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
                    wWMediaLink.thumbData = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Exception e) {
                }
                try {
                    a = C32291o.ahl().mo73087a(c7620bi.field_imgPath, C1338a.getDensity(null), false);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                    wWMediaLink.thumbData = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                }
                AppMethodBeat.m2505o(31040);
                return wWMediaLink;
            case 6:
                C30065b aiM = C4733l.aiM(X.csD);
                if (aiM == null) {
                    aiM = C14877am.aUq().mo48329lZ(c7620bi.field_msgId);
                }
                if (aiM.field_totalLen > DownloadHelper.SAVE_LENGTH) {
                    C5305a c5305a = new C5305a();
                    AppMethodBeat.m2505o(31040);
                    throw c5305a;
                }
                wWMediaLink = new WWMediaFile();
                wWMediaLink.fileName = X.title;
                wWMediaLink.filePath = aiM.field_fileFullPath;
                wWMediaLink.contentLengthLimit = 104857600;
                AppMethodBeat.m2505o(31040);
                return wWMediaLink;
            case 19:
                wWMediaImage = C44289an.m80039a(c7620bi, c7616ad, z);
                AppMethodBeat.m2505o(31040);
                return wWMediaImage;
            case 33:
                if (X.fiR == 3) {
                    AppMethodBeat.m2505o(31040);
                    return null;
                }
                wWMediaImage = new WWMediaMiniProgram();
                wWMediaImage.username = X.fiP;
                wWMediaImage.path = X.fiO;
                wWMediaImage.iconUrl = X.fjb;
                str = C32291o.ahl().mo73108c(c7620bi.field_imgPath, false, true);
                if (C40433a.m69345ct(str)) {
                    try {
                        Bitmap NC = C39159k.m66636NC(str);
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        NC.compress(CompressFormat.JPEG, 70, byteArrayOutputStream2);
                        wWMediaImage.ALI = byteArrayOutputStream2.toByteArray();
                        byteArrayOutputStream2.close();
                    } catch (Exception e3) {
                        C4990ab.m7417i("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram.hdImageData Exception:%s", e3.getMessage());
                    }
                    if (wWMediaImage.ALI.length > 1048576) {
                        C4990ab.m7416i("MicroMsg.SendToWeWorkHelper", "miniProgram.hdImageData.length > 1M");
                        wWMediaImage.ALI = new byte[1];
                    }
                    wWMediaImage.name = X.cMh;
                    wWMediaImage.title = X.title;
                    C4990ab.m7411d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", wWMediaImage.username, wWMediaImage.path, wWMediaImage.iconUrl, Integer.valueOf(wWMediaImage.ALI.length), wWMediaImage.name, wWMediaImage.title);
                    AppMethodBeat.m2505o(31040);
                    return wWMediaImage;
                }
                wWMediaImage.ALI = new byte[1];
                if (wWMediaImage.ALI.length > 1048576) {
                }
                wWMediaImage.name = X.cMh;
                wWMediaImage.title = X.title;
                C4990ab.m7411d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", wWMediaImage.username, wWMediaImage.path, wWMediaImage.iconUrl, Integer.valueOf(wWMediaImage.ALI.length), wWMediaImage.name, wWMediaImage.title);
                AppMethodBeat.m2505o(31040);
                return wWMediaImage;
            default:
                AppMethodBeat.m2505o(31040);
                return null;
        }
    }

    /* renamed from: a */
    private static WWMediaMergedConvs m80039a(C7620bi c7620bi, C7616ad c7616ad, boolean z) {
        C44099c VI;
        AppMethodBeat.m2504i(31042);
        String str = c7620bi.field_content;
        if (C1855t.m3896kH(c7620bi.field_talker)) {
            str = C1829bf.m3763oz(c7620bi.field_content);
        }
        C8910b me = C8910b.m16064me(str);
        if (me != null) {
            VI = C43436n.m77547VI(me.fgU);
        } else {
            VI = null;
        }
        WWMediaMergedConvs wWMediaMergedConvs = new WWMediaMergedConvs();
        if (VI == null) {
            AppMethodBeat.m2505o(31042);
            return wWMediaMergedConvs;
        }
        wWMediaMergedConvs.title = VI.title;
        Iterator it = VI.fjr.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            WWMediaConversation wWMediaConversation = new WWMediaConversation();
            String str2 = aar.wgV;
            if (C5046bo.isNullOrNil(aar.whu)) {
                wWMediaConversation.name = str2;
            } else {
                wWMediaConversation.name = str2 + aar.whu;
            }
            try {
                aat aat = aar.wgT.whw;
                if (aat.whQ) {
                    str2 = aat.cEV;
                } else if (aat.whV) {
                    str2 = aat.whU;
                } else {
                    str2 = "";
                }
                Bitmap a = C41730b.m73490a(str2, false, -1);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(CompressFormat.JPEG, 50, byteArrayOutputStream);
                wWMediaConversation.ALE = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e) {
            }
            long j = 0;
            try {
                j = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(aar.wgX).getTime();
            } catch (ParseException e2) {
            }
            wWMediaConversation.pXQ = j;
            wWMediaConversation.ALF = C44289an.m80040a(c7616ad, aar, c7620bi, z);
            wWMediaMergedConvs.mo65658a(wWMediaConversation);
        }
        AppMethodBeat.m2505o(31042);
        return wWMediaMergedConvs;
    }
}
