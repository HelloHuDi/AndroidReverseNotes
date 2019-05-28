package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i {

    /* renamed from: com.tencent.mm.plugin.fav.ui.i$2 */
    public static class AnonymousClass2 implements com.tencent.mm.plugin.fav.a.am.a {
        final /* synthetic */ Runnable cfC;
        final /* synthetic */ g meE;
        final /* synthetic */ Context val$context;

        public AnonymousClass2(g gVar, Context context, Runnable runnable) {
            this.meE = gVar;
            this.val$context = context;
            this.cfC = runnable;
        }

        public final void d(SparseArray<String> sparseArray) {
            AppMethodBeat.i(74119);
            String str = (String) sparseArray.get(this.meE.field_id);
            ab.d("MicroMsg.FavSendLogic", "on finish, favid %d, url %s", Integer.valueOf(this.meE.field_id), str);
            if (!bo.isNullOrNil(str)) {
                if (4 == this.meE.field_type) {
                    aar c = b.c(this.meE);
                    String bc = bo.bc(c.title, this.val$context.getString(R.string.bs9));
                    Intent intent = new Intent();
                    intent.putExtra("Ksnsupload_link", str);
                    intent.putExtra("Ksnsupload_title", bc);
                    intent.putExtra("Ksnsupload_imgbuf", e.e(b.c(c), 0, -1));
                    b.v(intent, this.val$context);
                    str = "fav_" + r.Yz() + "_" + this.meE.field_id;
                    String nW = v.nW(str);
                    v.Zp().y(nW, true).j("prePublishId", str);
                    intent.putExtra("reportSessionId", nW);
                    h.j(this.meE.field_localId, 0, 0);
                } else {
                    ab.w("MicroMsg.FavSendLogic", "unknown type %d, fav id %d", Integer.valueOf(this.meE.field_type), Integer.valueOf(this.meE.field_id));
                }
            }
            if (this.cfC != null) {
                al.d(this.cfC);
            }
            AppMethodBeat.o(74119);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.i$5 */
    public static class AnonymousClass5 implements Runnable {
        final /* synthetic */ Runnable cfC;
        final /* synthetic */ String cgl;
        final /* synthetic */ String fED;
        final /* synthetic */ int hVj;
        final /* synthetic */ String mjM;
        final /* synthetic */ String mjN;
        final /* synthetic */ Context val$context;

        public AnonymousClass5(Context context, String str, String str2, String str3, int i, String str4, Runnable runnable) {
            this.val$context = context;
            this.cgl = str;
            this.mjM = str2;
            this.fED = str3;
            this.hVj = i;
            this.mjN = str4;
            this.cfC = runnable;
        }

        public final void run() {
            AppMethodBeat.i(74124);
            Context context = this.val$context;
            String str = this.cgl;
            String str2 = this.mjM;
            String str3 = this.fED;
            int i = this.hVj;
            String str4 = this.mjN;
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str2);
            if (bVar.exists()) {
                com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(str3);
                ab.i("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", j.w(bVar.dMD()), j.w(bVar2.dMD()));
                com.tencent.mm.plugin.messenger.a.g.bOk().a(context, str, j.w(bVar.dMD()), str3, 1, i, str4);
            }
            al.d(this.cfC);
            AppMethodBeat.o(74124);
        }

        public final String toString() {
            AppMethodBeat.i(74125);
            String str = super.toString() + "|sendFavVideo";
            AppMethodBeat.o(74125);
            return str;
        }
    }

    public static class a {
        public String desc;
        public String mjO;
        public String thumbPath;
        public String title;

        private static boolean Mc(String str) {
            AppMethodBeat.i(74126);
            boolean exists = new com.tencent.mm.vfs.b(str).exists();
            AppMethodBeat.o(74126);
            return exists;
        }

        public static a a(Context context, g gVar) {
            AppMethodBeat.i(74127);
            Object obj;
            String str;
            String c;
            StringBuilder append;
            if (gVar.field_type == 18) {
                a aVar = new a();
                SparseIntArray sparseIntArray = new SparseIntArray();
                if (gVar.field_type == 18) {
                    aVar.title = gVar.field_favProto.title;
                }
                Object obj2 = null;
                LinkedList linkedList = new LinkedList();
                obj = null;
                for (aar aar : gVar.field_favProto.wiv) {
                    if (gVar.field_type != 18 || bo.isNullOrNil(aar.wgo) || !aar.wgo.equals(".htm")) {
                        sparseIntArray.put(aar.dataType, sparseIntArray.get(aar.dataType) + 1);
                        switch (aar.dataType) {
                            case 1:
                                if (linkedList.size() >= 4) {
                                    break;
                                }
                                str = aar.desc;
                                if (!bo.isNullOrNil(str)) {
                                    linkedList.add(str.replaceAll("&lt;", "<").replaceAll("&gt;", ">") + IOUtils.LINE_SEPARATOR_UNIX);
                                    break;
                                }
                                break;
                            case 2:
                                if (obj != null) {
                                    break;
                                }
                                c = b.c(aar);
                                if (!Mc(c)) {
                                    aVar.thumbPath = b.b(aar);
                                    obj = 1;
                                    break;
                                }
                                aVar.thumbPath = c;
                                obj = 1;
                                break;
                            case 3:
                                if (linkedList.size() >= 4) {
                                    break;
                                }
                                int iu = (int) b.iu((long) aar.duration);
                                linkedList.add(context.getString(R.string.ug) + context.getString(R.string.bng, new Object[]{Integer.valueOf(iu)}) + IOUtils.LINE_SEPARATOR_UNIX);
                                break;
                            case 4:
                                if (linkedList.size() >= 4) {
                                    break;
                                }
                                linkedList.add(context.getString(R.string.ud) + IOUtils.LINE_SEPARATOR_UNIX);
                                break;
                            case 6:
                                if (linkedList.size() < 4) {
                                    aay aay = aar.wgT.why;
                                    append = new StringBuilder().append(context.getString(R.string.rf));
                                    if (bo.isNullOrNil(aay.cIK) || aay.cIK.equals(context.getString(R.string.cnx))) {
                                        str = aay.label;
                                    } else {
                                        str = aay.cIK;
                                    }
                                    linkedList.add(append.append(str).append(IOUtils.LINE_SEPARATOR_UNIX).toString());
                                }
                                if (obj2 != null) {
                                    break;
                                }
                                obj2 = 1;
                                break;
                            case 8:
                                if (linkedList.size() < 4) {
                                    linkedList.add(context.getString(R.string.qr) + aar.title + IOUtils.LINE_SEPARATOR_UNIX);
                                }
                                if (obj2 != null) {
                                    break;
                                }
                                obj2 = 1;
                                break;
                            case 17:
                                if (linkedList.size() >= 4) {
                                    break;
                                }
                                linkedList.add(context.getString(R.string.t5) + IOUtils.LINE_SEPARATOR_UNIX);
                                break;
                            case 19:
                                if (linkedList.size() >= 4) {
                                    break;
                                }
                                linkedList.add(context.getString(R.string.fz) + aar.title + IOUtils.LINE_SEPARATOR_UNIX);
                                break;
                            default:
                                break;
                        }
                    }
                }
                str = "";
                aVar.desc = "";
                Iterator it = linkedList.iterator();
                while (true) {
                    c = str;
                    if (it.hasNext()) {
                        str = c + ((String) it.next());
                    } else {
                        str = c.trim();
                        if (linkedList.size() >= 4) {
                            str = str + "...";
                        }
                        aVar.desc = str;
                        if (aVar.title == null) {
                            aVar.title = "";
                        }
                        AppMethodBeat.o(74127);
                        return aVar;
                    }
                }
            }
            a aVar2 = new a();
            SparseIntArray sparseIntArray2 = new SparseIntArray();
            if (gVar.field_type == 14) {
                aVar2.title = gVar.field_favProto.title;
            }
            LinkedList linkedList2 = new LinkedList();
            obj = null;
            for (aar aar2 : gVar.field_favProto.wiv) {
                sparseIntArray2.put(aar2.dataType, sparseIntArray2.get(aar2.dataType) + 1);
                Object obj3;
                switch (aar2.dataType) {
                    case 1:
                        if (linkedList2.size() >= 4) {
                            break;
                        }
                        linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + aar2.desc + IOUtils.LINE_SEPARATOR_UNIX);
                        break;
                    case 2:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.sn) + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        str = b.c(aar2);
                        if (Mc(str)) {
                            aVar2.thumbPath = str;
                            obj3 = 1;
                        } else {
                            obj3 = obj;
                        }
                        obj = obj3;
                        break;
                    case 3:
                        if (linkedList2.size() >= 4) {
                            break;
                        }
                        int fY = (int) b.fY((long) aar2.duration);
                        linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.ug) + context.getString(R.string.bng, new Object[]{Integer.valueOf(fY)}) + IOUtils.LINE_SEPARATOR_UNIX);
                        break;
                    case 4:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.ud) + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        str = b.c(aar2);
                        if (Mc(str)) {
                            aVar2.thumbPath = str;
                            obj3 = 1;
                        } else {
                            obj3 = obj;
                        }
                        obj = obj3;
                        break;
                    case 5:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.u9) + aar2.title + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        c = b.c(aar2);
                        if (Mc(c)) {
                            aVar2.thumbPath = c;
                        } else {
                            abu abu = aar2.wgT.whA;
                            if (abu == null) {
                                c = "";
                            } else {
                                c = abu.thumbUrl;
                            }
                            if (bo.isNullOrNil(c)) {
                                c = bo.bc(aar2.cvq, "");
                            }
                            a(aVar2, c);
                        }
                        obj = 1;
                        break;
                    case 6:
                        if (linkedList2.size() < 4) {
                            aay aay2 = aar2.wgT.why;
                            append = new StringBuilder().append(aar2.wgV).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(context.getString(R.string.rf));
                            if (bo.isNullOrNil(aay2.cIK) || aay2.cIK.equals(context.getString(R.string.cnx))) {
                                str = aay2.label;
                            } else {
                                str = aay2.cIK;
                            }
                            linkedList2.add(append.append(str).append(IOUtils.LINE_SEPARATOR_UNIX).toString());
                        }
                        if (obj != null) {
                            break;
                        }
                        obj = 1;
                        break;
                    case 7:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.rs) + aar2.title + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        a(aVar2, aar2.cvq);
                        obj = 1;
                        break;
                    case 8:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.qr) + aar2.title + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        obj = 1;
                        break;
                    case 10:
                    case 11:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.ss) + aar2.wgT.whC.title + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        abe abe = aar2.wgT.whC;
                        if (abe != null) {
                            a(aVar2, abe.thumbUrl);
                        }
                        obj = 1;
                        break;
                    case 14:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.fy) + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        abo abo = aar2.wgT.whE;
                        if (abo != null) {
                            a(aVar2, abo.thumbUrl);
                        }
                        obj = 1;
                        break;
                    case 15:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.tp) + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        str = b.c(aar2);
                        if (Mc(str)) {
                            aVar2.thumbPath = str;
                            obj3 = 1;
                        } else {
                            obj3 = obj;
                        }
                        obj = obj3;
                        break;
                    case 16:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.qw) + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        aVar2.mjO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Rn(aar2.desc).svN;
                        obj = 1;
                        break;
                    case 17:
                        if (linkedList2.size() >= 4) {
                            break;
                        }
                        linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.t5) + IOUtils.LINE_SEPARATOR_UNIX);
                        break;
                    case 19:
                        if (linkedList2.size() < 4) {
                            if (aar2.wgT.whN != null && aar2.wgT.whN.type == 3) {
                                linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.s4) + IOUtils.LINE_SEPARATOR_UNIX);
                                break;
                            }
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.fz) + aar2.title + IOUtils.LINE_SEPARATOR_UNIX);
                            break;
                        }
                        break;
                        break;
                    default:
                        break;
                }
            }
            str = "";
            aVar2.desc = "";
            Iterator it2 = linkedList2.iterator();
            while (true) {
                c = str;
                if (it2.hasNext()) {
                    str = c + ((String) it2.next());
                } else {
                    str = c.trim();
                    if (linkedList2.size() >= 4) {
                        str = str + "...";
                    }
                    aVar2.desc = str;
                    AppMethodBeat.o(74127);
                    return aVar2;
                }
            }
        }

        private static void a(a aVar, String str) {
            AppMethodBeat.i(74128);
            String str2 = b.bue() + com.tencent.mm.a.g.x(bo.bc(str, "").getBytes());
            if (Mc(str2)) {
                aVar.thumbPath = str2;
            }
            AppMethodBeat.o(74128);
        }
    }

    public static void a(Context context, String str, String str2, g gVar, Runnable runnable) {
        AppMethodBeat.i(74129);
        List linkedList = new LinkedList();
        linkedList.add(gVar);
        a(context, str, str2, linkedList, runnable);
        AppMethodBeat.o(74129);
    }

    public static void a(Context context, String str, String str2, List<g> list, Runnable runnable) {
        AppMethodBeat.i(74130);
        if (context == null) {
            ab.w("MicroMsg.FavSendLogic", "want to send fav msg, but context is null");
            al.d(runnable);
            AppMethodBeat.o(74130);
        } else if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.FavSendLogic", "want to send fav msg, but to user is null");
            al.d(runnable);
            AppMethodBeat.o(74130);
        } else if (list.isEmpty()) {
            ab.w("MicroMsg.FavSendLogic", "want to send fav msg, but info is null");
            al.d(runnable);
            AppMethodBeat.o(74130);
        } else {
            final String str3 = str;
            final List<g> list2 = list;
            final Context context2 = context;
            final String str4 = str2;
            final Runnable runnable2 = runnable;
            d.xDH.ak(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74117);
                    for (String str : bo.P(str3.split(","))) {
                        for (g gVar : list2) {
                            if (gVar != null) {
                                com.tencent.mm.plugin.report.service.h.pYm.e(10925, Integer.valueOf(gVar.field_type), Integer.valueOf(gVar.field_id));
                                String str2;
                                byte[] readFromFile;
                                Context context;
                                abe abe;
                                mt mtVar;
                                byte[] readFromFile2;
                                switch (gVar.field_type) {
                                    case 1:
                                        com.tencent.mm.plugin.messenger.a.g.bOk().F(str, gVar.field_favProto.desc, t.nK(str));
                                        break;
                                    case 2:
                                        Iterator it = gVar.field_favProto.wiv.iterator();
                                        while (it.hasNext()) {
                                            com.tencent.mm.plugin.messenger.a.g.bOk().a(context2, str, b.b((aar) it.next()), 0, "", "");
                                        }
                                        break;
                                    case 4:
                                        i.b(context2, str, b.c(gVar));
                                        break;
                                    case 5:
                                        if (gVar != null) {
                                            aar c = b.c(gVar);
                                            abu abu = gVar.field_favProto.whA;
                                            abl abl = gVar.field_favProto.wit;
                                            com.tencent.mm.af.j.b bVar = new com.tencent.mm.af.j.b();
                                            if (abu != null) {
                                                bVar.title = abu.title;
                                                str2 = abu.thumbUrl;
                                                if (bo.isNullOrNil(str2)) {
                                                    str2 = bo.bc(c.cvq, "");
                                                }
                                                bVar.thumburl = str2;
                                            }
                                            if (bo.isNullOrNil(bVar.title)) {
                                                bVar.title = c.title;
                                            }
                                            if (abu != null) {
                                                bVar.description = abu.desc;
                                            }
                                            if (bo.isNullOrNil(bVar.description)) {
                                                bVar.description = c.desc;
                                            }
                                            if (gVar.field_favProto.whA != null) {
                                                bVar.url = gVar.field_favProto.whA.wiY;
                                            }
                                            if (abl != null && bo.isNullOrNil(bVar.url)) {
                                                bVar.url = abl.link;
                                            }
                                            if (!bo.isNullOrNil(c.canvasPageXml)) {
                                                bVar.canvasPageXml = c.canvasPageXml;
                                            }
                                            bVar.action = "view";
                                            bVar.type = 5;
                                            bVar.cMn = c.cMn;
                                            readFromFile = bo.readFromFile(b.c(c));
                                            if (readFromFile == null) {
                                                if (abu == null) {
                                                    str2 = null;
                                                } else {
                                                    str2 = abu.thumbUrl;
                                                }
                                                if (bo.isNullOrNil(str2)) {
                                                    str2 = bo.bc(c.cvq, "");
                                                }
                                                readFromFile = bo.readFromFile(b.bue() + com.tencent.mm.a.g.x(str2.getBytes()));
                                            }
                                            String str3 = "fav_" + r.Yz() + "_" + gVar.field_id;
                                            String nW = v.nW(str3);
                                            v.b y = v.Zp().y(nW, true);
                                            y.j("prePublishId", str3);
                                            y.j("preUsername", gVar.field_fromUser);
                                            y.j("sendAppMsgScene", Integer.valueOf(1));
                                            y.j("adExtStr", c.cMn);
                                            com.tencent.mm.plugin.messenger.a.g.bOk().a(str, readFromFile, com.tencent.mm.af.j.b.a(bVar, null, null), nW);
                                            break;
                                        }
                                        ab.w("MicroMsg.FavSendLogic", "item info is null, send fav url fail, return");
                                        break;
                                    case 6:
                                        aay aay = gVar.field_favProto.why;
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("<msg>");
                                        stringBuilder.append("<location ");
                                        stringBuilder.append("x=\"").append(aay.lat).append("\" ");
                                        stringBuilder.append("y=\"").append(aay.lng).append("\" ");
                                        stringBuilder.append("scale=\"").append(aay.cED).append("\" ");
                                        stringBuilder.append("label=\"").append(bo.bc(aay.label, "")).append("\" ");
                                        stringBuilder.append("maptype=\"0\" ");
                                        stringBuilder.append("poiname=\"").append(bo.bc(aay.cIK, "")).append("\" ");
                                        stringBuilder.append("/>");
                                        stringBuilder.append("</msg>");
                                        com.tencent.mm.plugin.messenger.a.g.bOk().F(str, stringBuilder.toString(), 48);
                                        break;
                                    case 7:
                                        Context context2 = context2;
                                        aar c2 = b.c(gVar);
                                        WXMusicObject wXMusicObject = new WXMusicObject();
                                        wXMusicObject.musicUrl = c2.wgg;
                                        wXMusicObject.musicDataUrl = c2.wgi;
                                        wXMusicObject.musicLowBandUrl = c2.wgk;
                                        wXMusicObject.musicLowBandDataUrl = c2.wgk;
                                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                        wXMediaMessage.mediaObject = wXMusicObject;
                                        wXMediaMessage.title = c2.title;
                                        wXMediaMessage.description = c2.desc;
                                        readFromFile = bo.readFromFile(b.c(c2));
                                        if (readFromFile == null) {
                                            readFromFile = bo.readFromFile(b.bue() + com.tencent.mm.a.g.x(bo.bc(c2.cvq, "").getBytes()));
                                        }
                                        wXMediaMessage.thumbData = readFromFile;
                                        str2 = gVar.field_favProto.wit.appId;
                                        ((com.tencent.mm.plugin.fav.a.ab) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.fav.a.ab.class)).a(wXMediaMessage, str2, com.tencent.mm.model.ad.a.fls.t(context2, str2), str);
                                        break;
                                    case 8:
                                        i.a(str, gVar, b.c(gVar));
                                        break;
                                    case 10:
                                        context = context2;
                                        abe = gVar.field_favProto.whC;
                                        mtVar = new mt();
                                        mtVar.cIE.opType = 0;
                                        mtVar.cIE.cIG = abe.info;
                                        mtVar.cIE.context = context;
                                        com.tencent.mm.sdk.b.a.xxA.m(mtVar);
                                        if (!mtVar.cIF.cvi) {
                                            break;
                                        }
                                        readFromFile2 = bo.readFromFile(b.bue() + com.tencent.mm.a.g.x(bo.bc(abe.thumbUrl, "").getBytes()));
                                        if (readFromFile2 == null) {
                                            readFromFile2 = bo.readFromFile(mtVar.cIF.thumbPath);
                                        }
                                        com.tencent.mm.plugin.messenger.a.g.bOk().a(str, readFromFile2, mtVar.cIF.cIH, null);
                                        break;
                                    case 11:
                                        context = context2;
                                        abe = gVar.field_favProto.whC;
                                        mtVar = new mt();
                                        mtVar.cIE.opType = 1;
                                        mtVar.cIE.cIG = abe.info;
                                        mtVar.cIE.context = context;
                                        com.tencent.mm.sdk.b.a.xxA.m(mtVar);
                                        if (!mtVar.cIF.cvi) {
                                            break;
                                        }
                                        readFromFile2 = bo.readFromFile(b.bue() + com.tencent.mm.a.g.x(bo.bc(abe.thumbUrl, "").getBytes()));
                                        if (readFromFile2 == null) {
                                            readFromFile2 = bo.readFromFile(mtVar.cIF.thumbPath);
                                        }
                                        com.tencent.mm.plugin.messenger.a.g.bOk().a(str, readFromFile2, mtVar.cIF.cIH, null);
                                        break;
                                    case 14:
                                    case 18:
                                        ab.i("MicroMsg.FavSendLogic", "want send record, fav id %d", Integer.valueOf(gVar.field_id));
                                        a a = a.a(context2, gVar);
                                        abf abf = new abf();
                                        try {
                                            ab.d("MicroMsg.FavSendLogic", "do clone fav proto item");
                                            abf.parseFrom(gVar.field_favProto.toByteArray());
                                        } catch (Exception e) {
                                            ab.printErrStackTrace("MicroMsg.FavSendLogic", e, "", new Object[0]);
                                            ab.e("MicroMsg.FavSendLogic", "clone fav proto item error: %s", e.getMessage());
                                        }
                                        LinkedList linkedList = abf.wiv;
                                        int i = 0;
                                        Iterator it2 = linkedList.iterator();
                                        while (true) {
                                            int i2 = i;
                                            if (!it2.hasNext()) {
                                                nt ntVar = new nt();
                                                ntVar.cJY.type = 2;
                                                ntVar.cJY.toUser = str;
                                                ntVar.cJY.cKb = abf;
                                                ntVar.cJY.title = a.title;
                                                ntVar.cJY.desc = a.desc;
                                                ntVar.cJY.thumbPath = a.thumbPath;
                                                ntVar.cJY.cKg = a.mjO;
                                                com.tencent.mm.sdk.b.a.xxA.m(ntVar);
                                                break;
                                            }
                                            aar aar = (aar) it2.next();
                                            if (!(aar.wgT == null || aar.wgT.whN == null || aar.wgT.whN.type != 3)) {
                                                aar.LE(1);
                                                aar.akI(context2.getString(R.string.s4));
                                                linkedList.set(i2, aar);
                                                abf.aE(linkedList);
                                            }
                                            i = i2 + 1;
                                        }
                                    case 15:
                                        context = context2;
                                        abo abo = gVar.field_favProto.whE;
                                        sx sxVar = new sx();
                                        sxVar.cPa.opType = 0;
                                        sxVar.cPa.cPc = abo.info;
                                        sxVar.cPa.context = context;
                                        com.tencent.mm.sdk.b.a.xxA.m(sxVar);
                                        ab.d("MicroMsg.FavSendLogic", "sendFavTV ret = [%s], thumbUrl = [%s]", Boolean.valueOf(sxVar.cPb.cvi), abo.thumbUrl);
                                        if (!sxVar.cPb.cvi) {
                                            break;
                                        }
                                        readFromFile2 = bo.readFromFile(b.bue() + com.tencent.mm.a.g.x(bo.bc(abo.thumbUrl, "").getBytes()));
                                        if (readFromFile2 == null) {
                                            readFromFile2 = bo.readFromFile(sxVar.cPb.thumbPath);
                                        }
                                        com.tencent.mm.plugin.messenger.a.g.bOk().a(str, readFromFile2, sxVar.cPb.cIH, null);
                                        break;
                                    case 16:
                                        i.a(context2, str, b.c(gVar));
                                        break;
                                    case 17:
                                        str2 = b.c(gVar).desc;
                                        com.tencent.mm.plugin.messenger.a.g.bOk().F(str, str2, ad.aox(com.tencent.mm.storage.bi.a.apC(str2).svN) ? 66 : 42);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            ab.e("MicroMsg.FavSendLogic", "in run workerThread,want to send fav msg, but info is null,infos.size = %d", Integer.valueOf(list2.size()));
                        }
                        if (!bo.isNullOrNil(str4)) {
                            com.tencent.mm.plugin.messenger.a.g.bOk().F(str, str4, t.nK(str));
                        }
                    }
                    al.d(runnable2);
                    AppMethodBeat.o(74117);
                }

                public final String toString() {
                    AppMethodBeat.i(74118);
                    String str = super.toString() + "|sendFavMsg";
                    AppMethodBeat.o(74118);
                    return str;
                }
            });
            AppMethodBeat.o(74130);
        }
    }

    public static void a(final Context context, final String str, final aar aar, final Runnable runnable) {
        AppMethodBeat.i(74131);
        if (context == null) {
            ab.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
            AppMethodBeat.o(74131);
        } else if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
            AppMethodBeat.o(74131);
        } else if (aar == null) {
            ab.w("MicroMsg.FavSendLogic", "want to send fav video, but dataItem is null");
            AppMethodBeat.o(74131);
        } else {
            com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74120);
                    if (aar.dataType == 15) {
                        i.a(context, str, aar);
                    } else {
                        i.b(context, str, aar);
                    }
                    al.d(runnable);
                    AppMethodBeat.o(74120);
                }

                public final String toString() {
                    AppMethodBeat.i(74121);
                    String str = super.toString() + "|sendFavVideo";
                    AppMethodBeat.o(74121);
                    return str;
                }
            });
            AppMethodBeat.o(74131);
        }
    }

    public static void a(Context context, final String str, final g gVar, final aar aar, final Runnable runnable) {
        AppMethodBeat.i(74132);
        if (context == null) {
            ab.w("MicroMsg.FavSendLogic", "want to send fav file, but context is null");
            AppMethodBeat.o(74132);
        } else if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.FavSendLogic", "want to send fav file, but to user is null");
            AppMethodBeat.o(74132);
        } else {
            if (gVar == null) {
                ab.w("MicroMsg.FavSendLogic", "want to send fav file, but info is null");
            }
            if (aar == null) {
                ab.w("MicroMsg.FavSendLogic", "want to send fav file, but dataItem is null");
                AppMethodBeat.o(74132);
                return;
            }
            com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74122);
                    i.a(str, gVar, aar);
                    al.d(runnable);
                    AppMethodBeat.o(74122);
                }

                public final String toString() {
                    AppMethodBeat.i(74123);
                    String str = super.toString() + "|sendFavFile";
                    AppMethodBeat.o(74123);
                    return str;
                }
            });
            AppMethodBeat.o(74132);
        }
    }

    public static String i(aar aar) {
        String w;
        AppMethodBeat.i(74133);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(b.c(aar));
        if (bVar.exists()) {
            w = j.w(bVar.dMD());
        } else {
            w = b.bue() + com.tencent.mm.a.g.x(bo.bc(aar.cvq, "").getBytes());
        }
        AppMethodBeat.o(74133);
        return w;
    }

    static /* synthetic */ void b(Context context, String str, aar aar) {
        AppMethodBeat.i(74135);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(b.b(aar));
        aau aau;
        if (bVar.exists()) {
            String w;
            com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(b.c(aar));
            if (bVar2.exists()) {
                w = j.w(bVar2.dMD());
            } else {
                w = b.bue() + com.tencent.mm.a.g.x(bo.bc(aar.cvq, "").getBytes());
            }
            ab.d("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", j.w(bVar.dMD()), w);
            cfh cfh = null;
            aau = aar.wgZ;
            if (aau != null) {
                cfh = new cfh();
                cfh.fiL = aau.fiL;
                cfh.fiI = aau.fiI;
                cfh.wid = aau.wid;
                cfh.fiG = aau.fiG;
                cfh.fiJ = aau.fiJ;
                cfh.fiM = aau.fiM;
                cfh.fiN = aau.fiN;
            }
            if (cfh != null) {
                com.tencent.mm.plugin.messenger.a.g.bOk().a(context, str, j.w(bVar.dMD()), w, 1, aar.duration, cfh, aar.cMn);
                AppMethodBeat.o(74135);
                return;
            }
            com.tencent.mm.plugin.messenger.a.g.bOk().a(context, str, j.w(bVar.dMD()), w, 1, aar.duration, aar.cMn);
            AppMethodBeat.o(74135);
            return;
        }
        String str2 = aar.wgg;
        if (!bo.isNullOrNil(str2)) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = str2;
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            str2 = bo.bc(aar.title, context.getResources().getString(R.string.bs9));
            wXMediaMessage.mediaObject = wXVideoObject;
            wXMediaMessage.title = str2;
            wXMediaMessage.description = aar.desc;
            wXMediaMessage.thumbData = bo.readFromFile(b.c(aar));
            if (wXMediaMessage.thumbData == null) {
                wXMediaMessage.thumbData = bo.readFromFile(b.bue() + com.tencent.mm.a.g.x(bo.bc(aar.cvq, "").getBytes()));
            }
            com.tencent.mm.af.j.b bVar3 = new com.tencent.mm.af.j.b();
            bVar3.fgr = 3;
            aau = aar.wgZ;
            if (aau != null) {
                bVar3.fiL = aau.fiL;
                bVar3.fiI = aau.fiI;
                bVar3.fiH = aau.wid;
                bVar3.fiG = aau.fiG;
                bVar3.fiJ = aau.fiJ;
                bVar3.fiM = aau.fiM;
                bVar3.fiN = aau.fiN;
            }
            ((com.tencent.mm.plugin.fav.a.ab) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.fav.a.ab.class)).a(bVar3, wXMediaMessage, str);
        }
        AppMethodBeat.o(74135);
    }
}
