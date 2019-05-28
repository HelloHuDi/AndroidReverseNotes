package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.gallery.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.b;
import com.tencent.mm.ui.base.h;
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

public final class an {

    static class a extends Exception {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.an$2 */
    public static class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ ad emj;
        final /* synthetic */ Context val$context;
        final /* synthetic */ List yMq;
        final /* synthetic */ boolean yMr;

        public AnonymousClass2(Context context, ad adVar, List list, boolean z) {
            this.val$context = context;
            this.emj = adVar;
            this.yMq = list;
            this.yMr = z;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(31034);
            an.a(this.val$context, this.emj, this.yMq, this.yMr);
            AppMethodBeat.o(31034);
        }
    }

    public static void a(Context context, ad adVar, List<bi> list, boolean z) {
        AppMethodBeat.i(31035);
        IWWAPI jv = WWAPIFactory.jv(context);
        try {
            BaseMessage a;
            if (list.size() == 1) {
                a = a(adVar, (bi) list.get(0), z);
            } else {
                a = a(adVar, (List) list, z);
            }
            jv.a(a);
            AppMethodBeat.o(31035);
        } catch (a e) {
            h.g(context, R.string.e3m, R.string.tz);
            AppMethodBeat.o(31035);
        }
    }

    private static WWMediaObject a(ad adVar, bi biVar, boolean z) {
        AppMethodBeat.i(31036);
        int type = biVar.getType();
        WWMediaObject aZ;
        if (type == 1) {
            WWMediaText wWMediaText = new WWMediaText(j.v(biVar.field_content, biVar.field_isSend, z));
            AppMethodBeat.o(31036);
            return wWMediaText;
        } else if (type == 3) {
            aZ = aZ(biVar);
            AppMethodBeat.o(31036);
            return aZ;
        } else if (type == 43) {
            aZ = new WWMediaVideo();
            s ut = u.ut(biVar.field_imgPath);
            o.all();
            aZ.filePath = t.uh(ut.getFileName());
            ab.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", aZ.filePath);
            AppMethodBeat.o(31036);
            return aZ;
        } else if (type == 48) {
            aZ = new WWMediaLocation();
            String v = j.v(biVar.field_content, biVar.field_isSend, z);
            aw.ZK();
            b Ro = c.XO().Ro(v);
            aZ.title = Ro.eUu;
            aZ.fBg = Ro.label;
            aZ.longitude = Ro.nJv;
            aZ.latitude = Ro.nJu;
            aZ.ALG = (double) Ro.cED;
            AppMethodBeat.o(31036);
            return aZ;
        } else if (type == 49 || type == 268435505) {
            aZ = b(adVar, biVar, z);
            AppMethodBeat.o(31036);
            return aZ;
        } else {
            ab.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", Integer.valueOf(type));
            AppMethodBeat.o(31036);
            return null;
        }
    }

    private static WWMediaObject a(ad adVar, List<bi> list, boolean z) {
        AppMethodBeat.i(31038);
        WWMediaMergedConvs wWMediaMergedConvs = new WWMediaMergedConvs();
        String str = adVar.field_username;
        Context context = ah.getContext();
        if (z) {
            str = context.getString(R.string.dja);
        } else {
            if (r.YB().equals(com.tencent.mm.model.s.mI(str))) {
                str = context.getString(R.string.bqj, new Object[]{r.YB()});
            } else {
                str = context.getString(R.string.bqi, new Object[]{r.YB(), com.tencent.mm.model.s.mI(str)});
            }
        }
        wWMediaMergedConvs.title = str;
        for (bi biVar : list) {
            String Yz;
            WWMediaConversation wWMediaConversation = new WWMediaConversation();
            if (biVar.field_isSend == 1) {
                Yz = r.Yz();
            } else if (z) {
                Yz = bf.oy(biVar.field_content);
            } else {
                Yz = biVar.field_talker;
            }
            wWMediaConversation.name = com.tencent.mm.model.s.mI(Yz) + bo.nullAsNil(com.tencent.mm.openim.room.a.a.A(((j) g.K(j.class)).XM().aoO(Yz)));
            try {
                Bitmap a = com.tencent.mm.ah.b.a(Yz, false, -1);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(CompressFormat.JPEG, 50, byteArrayOutputStream);
                wWMediaConversation.ALE = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e) {
            }
            wWMediaConversation.pXQ = biVar.field_createTime;
            wWMediaConversation.ALF = a(adVar, biVar, z);
            wWMediaMergedConvs.a(wWMediaConversation);
        }
        AppMethodBeat.o(31038);
        return wWMediaMergedConvs;
    }

    private static WWMediaMergedConvs a(aar aar, bi biVar, ad adVar, boolean z) {
        AppMethodBeat.i(31041);
        WWMediaMergedConvs wWMediaMergedConvs = new WWMediaMergedConvs();
        if (aar == null) {
            AppMethodBeat.o(31041);
            return wWMediaMergedConvs;
        }
        com.tencent.mm.protocal.b.a.c VI = n.VI(aar.whj);
        if (VI == null) {
            AppMethodBeat.o(31041);
            return wWMediaMergedConvs;
        }
        wWMediaMergedConvs.title = VI.title;
        Iterator it = VI.fjr.iterator();
        while (it.hasNext()) {
            aar aar2 = (aar) it.next();
            WWMediaConversation wWMediaConversation = new WWMediaConversation();
            String str = aar2.wgV;
            if (bo.isNullOrNil(aar2.whu)) {
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
                Bitmap a = com.tencent.mm.ah.b.a(str, false, -1);
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
            wWMediaConversation.ALF = a(adVar, aar2, biVar, z);
            wWMediaMergedConvs.a(wWMediaConversation);
        }
        AppMethodBeat.o(31041);
        return wWMediaMergedConvs;
    }

    private static WWMediaObject a(ad adVar, aar aar, bi biVar, boolean z) {
        AppMethodBeat.i(31037);
        int i = aar.dataType;
        String c;
        WWMediaObject wWMediaImage;
        if (i == 1) {
            WWMediaText wWMediaText = new WWMediaText(aar.desc);
            AppMethodBeat.o(31037);
            return wWMediaText;
        } else if (i == 2) {
            long j = biVar.field_msgId;
            if (f.Mn()) {
                c = n.c(aar, j);
                if (bo.isNullOrNil(c)) {
                    c = n.f(aar, j);
                }
                if (bo.isNullOrNil(c) || !e.ct(c)) {
                    ab.d("MicroMsg.RecordMsgImgService", "getPath file not exist, path[%s]", c);
                    c = null;
                }
            } else {
                c = null;
            }
            if (bo.isNullOrNil(c)) {
                ab.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_IMG not exist!");
                AppMethodBeat.o(31037);
                return null;
            }
            wWMediaImage = new WWMediaImage();
            wWMediaImage.filePath = c;
            ab.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", wWMediaImage.filePath);
            AppMethodBeat.o(31037);
            return wWMediaImage;
        } else if (i == 4) {
            c = n.c(aar, biVar.field_msgId);
            if (bo.isNullOrNil(c) || !com.tencent.mm.pluginsdk.g.a.d.a.ct(c)) {
                ab.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_VIDEO not exist!");
                AppMethodBeat.o(31037);
                return null;
            }
            wWMediaImage = new WWMediaVideo();
            wWMediaImage.filePath = c;
            ab.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", wWMediaImage.filePath);
            AppMethodBeat.o(31037);
            return wWMediaImage;
        } else if (i == 6) {
            WWMediaObject wWMediaLocation = new WWMediaLocation();
            if (aar.wgT == null) {
                ab.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_LOC not exist!");
                AppMethodBeat.o(31037);
                return null;
            }
            aay aay = aar.wgT.why;
            if (aay == null) {
                ab.w("MicroMsg.SendToWeWorkHelper", "location error, locItem null, dataid[%s]", aar.mnd);
                AppMethodBeat.o(31037);
                return null;
            }
            wWMediaLocation.title = aay.cIK;
            wWMediaLocation.fBg = aay.label;
            wWMediaLocation.longitude = aay.lng;
            wWMediaLocation.latitude = aay.lat;
            wWMediaLocation.ALG = (double) aay.cED;
            AppMethodBeat.o(31037);
            return wWMediaLocation;
        } else if (i == 8) {
            c = n.c(aar, biVar.field_msgId);
            if (bo.isNullOrNil(c)) {
                ab.w("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_FILE title == null, dataid[%s]", aar.mnd);
                AppMethodBeat.o(31037);
                return null;
            } else if (com.tencent.mm.pluginsdk.g.a.d.a.ek(c) > DownloadHelper.SAVE_LENGTH) {
                a aVar = new a();
                AppMethodBeat.o(31037);
                throw aVar;
            } else {
                wWMediaImage = new WWMediaFile();
                wWMediaImage.fileName = aar.title;
                wWMediaImage.filePath = c;
                wWMediaImage.contentLengthLimit = 104857600;
                AppMethodBeat.o(31037);
                return wWMediaImage;
            }
        } else if (i == 17) {
            wWMediaImage = a(aar, biVar, adVar, z);
            AppMethodBeat.o(31037);
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
            ab.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", wWMediaImage.username, wWMediaImage.path, wWMediaImage.iconUrl, Integer.valueOf(wWMediaImage.ALI.length), wWMediaImage.name, wWMediaImage.title);
            AppMethodBeat.o(31037);
            return wWMediaImage;
        } else {
            ab.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", Integer.valueOf(i));
            AppMethodBeat.o(31037);
            return null;
        }
    }

    private static WWMediaObject aZ(bi biVar) {
        com.tencent.mm.at.e fJ;
        AppMethodBeat.i(31039);
        if (biVar.field_msgId > 0) {
            fJ = com.tencent.mm.at.o.ahl().fJ(biVar.field_msgId);
        } else {
            fJ = null;
        }
        if ((fJ == null || fJ.fDy <= 0) && biVar.field_msgSvrId > 0) {
            fJ = com.tencent.mm.at.o.ahl().fI(biVar.field_msgSvrId);
        }
        if (fJ == null) {
            AppMethodBeat.o(31039);
            return null;
        }
        String q = com.tencent.mm.at.o.ahl().q(com.tencent.mm.at.f.c(fJ), "", "");
        WWMediaObject wWMediaImage = new WWMediaImage();
        wWMediaImage.filePath = q;
        ab.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", wWMediaImage.filePath);
        AppMethodBeat.o(31039);
        return wWMediaImage;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x018d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static WWMediaObject b(ad adVar, bi biVar, boolean z) {
        com.tencent.mm.af.j.b X;
        AppMethodBeat.i(31040);
        String str = biVar.field_content;
        if (z) {
            int indexOf = biVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str = biVar.field_content.substring(indexOf + 1);
            }
        }
        if (str != null) {
            X = com.tencent.mm.af.j.b.X(str, biVar.field_reserved);
        } else {
            X = null;
        }
        if (X == null) {
            AppMethodBeat.o(31040);
            return null;
        }
        WWMediaObject wWMediaImage;
        WWMediaObject wWMediaLink;
        switch (X.type) {
            case 2:
                if (X.csD != null && X.csD.length() > 0) {
                    com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(X.csD);
                    if (aiE != null && aiE.bCR()) {
                        str = aiE.field_fileFullPath;
                        if (com.tencent.mm.vfs.e.ct(str)) {
                            wWMediaImage = new WWMediaImage();
                            wWMediaImage.filePath = str;
                            ab.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", wWMediaImage.filePath);
                            AppMethodBeat.o(31040);
                            return wWMediaImage;
                        }
                        ab.i("MicroMsg.SendToWeWorkHelper", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", str, Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId));
                        AppMethodBeat.o(31040);
                        return null;
                    }
                }
                AppMethodBeat.o(31040);
                return null;
            case 5:
                ByteArrayOutputStream byteArrayOutputStream;
                wWMediaLink = new WWMediaLink();
                wWMediaLink.webpageUrl = X.url;
                wWMediaLink.title = X.title;
                wWMediaLink.description = X.description;
                Bitmap a = com.tencent.mm.at.o.ahl().a(biVar.field_imgPath, com.tencent.mm.bz.a.getDensity(null), false);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    a.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
                    wWMediaLink.thumbData = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Exception e) {
                }
                try {
                    a = com.tencent.mm.at.o.ahl().a(biVar.field_imgPath, com.tencent.mm.bz.a.getDensity(null), false);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                    wWMediaLink.thumbData = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                }
                AppMethodBeat.o(31040);
                return wWMediaLink;
            case 6:
                com.tencent.mm.pluginsdk.model.app.b aiM = l.aiM(X.csD);
                if (aiM == null) {
                    aiM = am.aUq().lZ(biVar.field_msgId);
                }
                if (aiM.field_totalLen > DownloadHelper.SAVE_LENGTH) {
                    a aVar = new a();
                    AppMethodBeat.o(31040);
                    throw aVar;
                }
                wWMediaLink = new WWMediaFile();
                wWMediaLink.fileName = X.title;
                wWMediaLink.filePath = aiM.field_fileFullPath;
                wWMediaLink.contentLengthLimit = 104857600;
                AppMethodBeat.o(31040);
                return wWMediaLink;
            case 19:
                wWMediaImage = a(biVar, adVar, z);
                AppMethodBeat.o(31040);
                return wWMediaImage;
            case 33:
                if (X.fiR == 3) {
                    AppMethodBeat.o(31040);
                    return null;
                }
                wWMediaImage = new WWMediaMiniProgram();
                wWMediaImage.username = X.fiP;
                wWMediaImage.path = X.fiO;
                wWMediaImage.iconUrl = X.fjb;
                str = com.tencent.mm.at.o.ahl().c(biVar.field_imgPath, false, true);
                if (com.tencent.mm.pluginsdk.g.a.d.a.ct(str)) {
                    try {
                        Bitmap NC = k.NC(str);
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        NC.compress(CompressFormat.JPEG, 70, byteArrayOutputStream2);
                        wWMediaImage.ALI = byteArrayOutputStream2.toByteArray();
                        byteArrayOutputStream2.close();
                    } catch (Exception e3) {
                        ab.i("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram.hdImageData Exception:%s", e3.getMessage());
                    }
                    if (wWMediaImage.ALI.length > 1048576) {
                        ab.i("MicroMsg.SendToWeWorkHelper", "miniProgram.hdImageData.length > 1M");
                        wWMediaImage.ALI = new byte[1];
                    }
                    wWMediaImage.name = X.cMh;
                    wWMediaImage.title = X.title;
                    ab.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", wWMediaImage.username, wWMediaImage.path, wWMediaImage.iconUrl, Integer.valueOf(wWMediaImage.ALI.length), wWMediaImage.name, wWMediaImage.title);
                    AppMethodBeat.o(31040);
                    return wWMediaImage;
                }
                wWMediaImage.ALI = new byte[1];
                if (wWMediaImage.ALI.length > 1048576) {
                }
                wWMediaImage.name = X.cMh;
                wWMediaImage.title = X.title;
                ab.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", wWMediaImage.username, wWMediaImage.path, wWMediaImage.iconUrl, Integer.valueOf(wWMediaImage.ALI.length), wWMediaImage.name, wWMediaImage.title);
                AppMethodBeat.o(31040);
                return wWMediaImage;
            default:
                AppMethodBeat.o(31040);
                return null;
        }
    }

    private static WWMediaMergedConvs a(bi biVar, ad adVar, boolean z) {
        com.tencent.mm.protocal.b.a.c VI;
        AppMethodBeat.i(31042);
        String str = biVar.field_content;
        if (com.tencent.mm.model.t.kH(biVar.field_talker)) {
            str = bf.oz(biVar.field_content);
        }
        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
        if (me != null) {
            VI = n.VI(me.fgU);
        } else {
            VI = null;
        }
        WWMediaMergedConvs wWMediaMergedConvs = new WWMediaMergedConvs();
        if (VI == null) {
            AppMethodBeat.o(31042);
            return wWMediaMergedConvs;
        }
        wWMediaMergedConvs.title = VI.title;
        Iterator it = VI.fjr.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            WWMediaConversation wWMediaConversation = new WWMediaConversation();
            String str2 = aar.wgV;
            if (bo.isNullOrNil(aar.whu)) {
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
                Bitmap a = com.tencent.mm.ah.b.a(str2, false, -1);
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
            wWMediaConversation.ALF = a(adVar, aar, biVar, z);
            wWMediaMergedConvs.a(wWMediaConversation);
        }
        AppMethodBeat.o(31042);
        return wWMediaMergedConvs;
    }
}
