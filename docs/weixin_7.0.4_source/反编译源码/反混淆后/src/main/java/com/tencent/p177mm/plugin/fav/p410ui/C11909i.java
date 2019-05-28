package com.tencent.p177mm.plugin.fav.p410ui;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C26408ad.C26410a;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.p177mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p230g.p231a.C18348nt;
import com.tencent.p177mm.p230g.p231a.C42029mt;
import com.tencent.p177mm.p230g.p231a.C42060sx;
import com.tencent.p177mm.plugin.fav.p407a.C27962am.C3068a;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C6892ab;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aau;
import com.tencent.p177mm.protocal.protobuf.aay;
import com.tencent.p177mm.protocal.protobuf.abe;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.protocal.protobuf.abo;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.protocal.protobuf.cfh;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.ui.i */
public final class C11909i {

    /* renamed from: com.tencent.mm.plugin.fav.ui.i$2 */
    public static class C119082 implements C3068a {
        final /* synthetic */ Runnable cfC;
        final /* synthetic */ C27966g meE;
        final /* synthetic */ Context val$context;

        public C119082(C27966g c27966g, Context context, Runnable runnable) {
            this.meE = c27966g;
            this.val$context = context;
            this.cfC = runnable;
        }

        /* renamed from: d */
        public final void mo7313d(SparseArray<String> sparseArray) {
            AppMethodBeat.m2504i(74119);
            String str = (String) sparseArray.get(this.meE.field_id);
            C4990ab.m7411d("MicroMsg.FavSendLogic", "on finish, favid %d, url %s", Integer.valueOf(this.meE.field_id), str);
            if (!C5046bo.isNullOrNil(str)) {
                if (4 == this.meE.field_type) {
                    aar c = C39037b.m66378c(this.meE);
                    String bc = C5046bo.m7532bc(c.title, this.val$context.getString(C25738R.string.bs9));
                    Intent intent = new Intent();
                    intent.putExtra("Ksnsupload_link", str);
                    intent.putExtra("Ksnsupload_title", bc);
                    intent.putExtra("Ksnsupload_imgbuf", C5730e.m8632e(C39037b.m66379c(c), 0, -1));
                    C39037b.m66419v(intent, this.val$context);
                    str = "fav_" + C1853r.m3846Yz() + "_" + this.meE.field_id;
                    String nW = C37922v.m64078nW(str);
                    C37922v.m64076Zp().mo60676y(nW, true).mo53356j("prePublishId", str);
                    intent.putExtra("reportSessionId", nW);
                    C27968h.m44531j(this.meE.field_localId, 0, 0);
                } else {
                    C4990ab.m7421w("MicroMsg.FavSendLogic", "unknown type %d, fav id %d", Integer.valueOf(this.meE.field_type), Integer.valueOf(this.meE.field_id));
                }
            }
            if (this.cfC != null) {
                C5004al.m7441d(this.cfC);
            }
            AppMethodBeat.m2505o(74119);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.i$5 */
    public static class C119125 implements Runnable {
        final /* synthetic */ Runnable cfC;
        final /* synthetic */ String cgl;
        final /* synthetic */ String fED;
        final /* synthetic */ int hVj;
        final /* synthetic */ String mjM;
        final /* synthetic */ String mjN;
        final /* synthetic */ Context val$context;

        public C119125(Context context, String str, String str2, String str3, int i, String str4, Runnable runnable) {
            this.val$context = context;
            this.cgl = str;
            this.mjM = str2;
            this.fED = str3;
            this.hVj = i;
            this.mjN = str4;
            this.cfC = runnable;
        }

        public final void run() {
            AppMethodBeat.m2504i(74124);
            Context context = this.val$context;
            String str = this.cgl;
            String str2 = this.mjM;
            String str3 = this.fED;
            int i = this.hVj;
            String str4 = this.mjN;
            C5728b c5728b = new C5728b(str2);
            if (c5728b.exists()) {
                C5728b c5728b2 = new C5728b(str3);
                C4990ab.m7417i("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", C5736j.m8649w(c5728b.dMD()), C5736j.m8649w(c5728b2.dMD()));
                C12519g.bOk().mo46459a(context, str, C5736j.m8649w(c5728b.dMD()), str3, 1, i, str4);
            }
            C5004al.m7441d(this.cfC);
            AppMethodBeat.m2505o(74124);
        }

        public final String toString() {
            AppMethodBeat.m2504i(74125);
            String str = super.toString() + "|sendFavVideo";
            AppMethodBeat.m2505o(74125);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.i$a */
    public static class C11914a {
        public String desc;
        public String mjO;
        public String thumbPath;
        public String title;

        /* renamed from: Mc */
        private static boolean m19796Mc(String str) {
            AppMethodBeat.m2504i(74126);
            boolean exists = new C5728b(str).exists();
            AppMethodBeat.m2505o(74126);
            return exists;
        }

        /* renamed from: a */
        public static C11914a m19797a(Context context, C27966g c27966g) {
            AppMethodBeat.m2504i(74127);
            Object obj;
            String str;
            String c;
            StringBuilder append;
            if (c27966g.field_type == 18) {
                C11914a c11914a = new C11914a();
                SparseIntArray sparseIntArray = new SparseIntArray();
                if (c27966g.field_type == 18) {
                    c11914a.title = c27966g.field_favProto.title;
                }
                Object obj2 = null;
                LinkedList linkedList = new LinkedList();
                obj = null;
                for (aar aar : c27966g.field_favProto.wiv) {
                    if (c27966g.field_type != 18 || C5046bo.isNullOrNil(aar.wgo) || !aar.wgo.equals(".htm")) {
                        sparseIntArray.put(aar.dataType, sparseIntArray.get(aar.dataType) + 1);
                        switch (aar.dataType) {
                            case 1:
                                if (linkedList.size() >= 4) {
                                    break;
                                }
                                str = aar.desc;
                                if (!C5046bo.isNullOrNil(str)) {
                                    linkedList.add(str.replaceAll("&lt;", "<").replaceAll("&gt;", ">") + IOUtils.LINE_SEPARATOR_UNIX);
                                    break;
                                }
                                break;
                            case 2:
                                if (obj != null) {
                                    break;
                                }
                                c = C39037b.m66379c(aar);
                                if (!C11914a.m19796Mc(c)) {
                                    c11914a.thumbPath = C39037b.m66370b(aar);
                                    obj = 1;
                                    break;
                                }
                                c11914a.thumbPath = c;
                                obj = 1;
                                break;
                            case 3:
                                if (linkedList.size() >= 4) {
                                    break;
                                }
                                int iu = (int) C39037b.m66406iu((long) aar.duration);
                                linkedList.add(context.getString(C25738R.string.f9256ug) + context.getString(C25738R.string.bng, new Object[]{Integer.valueOf(iu)}) + IOUtils.LINE_SEPARATOR_UNIX);
                                break;
                            case 4:
                                if (linkedList.size() >= 4) {
                                    break;
                                }
                                linkedList.add(context.getString(C25738R.string.f9253ud) + IOUtils.LINE_SEPARATOR_UNIX);
                                break;
                            case 6:
                                if (linkedList.size() < 4) {
                                    aay aay = aar.wgT.why;
                                    append = new StringBuilder().append(context.getString(C25738R.string.f9162rf));
                                    if (C5046bo.isNullOrNil(aay.cIK) || aay.cIK.equals(context.getString(C25738R.string.cnx))) {
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
                                    linkedList.add(context.getString(C25738R.string.f9140qr) + aar.title + IOUtils.LINE_SEPARATOR_UNIX);
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
                                linkedList.add(context.getString(C25738R.string.f9212t5) + IOUtils.LINE_SEPARATOR_UNIX);
                                break;
                            case 19:
                                if (linkedList.size() >= 4) {
                                    break;
                                }
                                linkedList.add(context.getString(C25738R.string.f8821fz) + aar.title + IOUtils.LINE_SEPARATOR_UNIX);
                                break;
                            default:
                                break;
                        }
                    }
                }
                str = "";
                c11914a.desc = "";
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
                        c11914a.desc = str;
                        if (c11914a.title == null) {
                            c11914a.title = "";
                        }
                        AppMethodBeat.m2505o(74127);
                        return c11914a;
                    }
                }
            }
            C11914a c11914a2 = new C11914a();
            SparseIntArray sparseIntArray2 = new SparseIntArray();
            if (c27966g.field_type == 14) {
                c11914a2.title = c27966g.field_favProto.title;
            }
            LinkedList linkedList2 = new LinkedList();
            obj = null;
            for (aar aar2 : c27966g.field_favProto.wiv) {
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
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9199sn) + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        str = C39037b.m66379c(aar2);
                        if (C11914a.m19796Mc(str)) {
                            c11914a2.thumbPath = str;
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
                        int fY = (int) C39037b.m66394fY((long) aar2.duration);
                        linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9256ug) + context.getString(C25738R.string.bng, new Object[]{Integer.valueOf(fY)}) + IOUtils.LINE_SEPARATOR_UNIX);
                        break;
                    case 4:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9253ud) + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        str = C39037b.m66379c(aar2);
                        if (C11914a.m19796Mc(str)) {
                            c11914a2.thumbPath = str;
                            obj3 = 1;
                        } else {
                            obj3 = obj;
                        }
                        obj = obj3;
                        break;
                    case 5:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9248u9) + aar2.title + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        c = C39037b.m66379c(aar2);
                        if (C11914a.m19796Mc(c)) {
                            c11914a2.thumbPath = c;
                        } else {
                            abu abu = aar2.wgT.whA;
                            if (abu == null) {
                                c = "";
                            } else {
                                c = abu.thumbUrl;
                            }
                            if (C5046bo.isNullOrNil(c)) {
                                c = C5046bo.m7532bc(aar2.cvq, "");
                            }
                            C11914a.m19798a(c11914a2, c);
                        }
                        obj = 1;
                        break;
                    case 6:
                        if (linkedList2.size() < 4) {
                            aay aay2 = aar2.wgT.why;
                            append = new StringBuilder().append(aar2.wgV).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(context.getString(C25738R.string.f9162rf));
                            if (C5046bo.isNullOrNil(aay2.cIK) || aay2.cIK.equals(context.getString(C25738R.string.cnx))) {
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
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9174rs) + aar2.title + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        C11914a.m19798a(c11914a2, aar2.cvq);
                        obj = 1;
                        break;
                    case 8:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9140qr) + aar2.title + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        obj = 1;
                        break;
                    case 10:
                    case 11:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9201ss) + aar2.wgT.whC.title + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        abe abe = aar2.wgT.whC;
                        if (abe != null) {
                            C11914a.m19798a(c11914a2, abe.thumbUrl);
                        }
                        obj = 1;
                        break;
                    case 14:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f8820fy) + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        abo abo = aar2.wgT.whE;
                        if (abo != null) {
                            C11914a.m19798a(c11914a2, abo.thumbUrl);
                        }
                        obj = 1;
                        break;
                    case 15:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9230tp) + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        str = C39037b.m66379c(aar2);
                        if (C11914a.m19796Mc(str)) {
                            c11914a2.thumbPath = str;
                            obj3 = 1;
                        } else {
                            obj3 = obj;
                        }
                        obj = obj3;
                        break;
                    case 16:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9145qw) + IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        if (obj != null) {
                            break;
                        }
                        c11914a2.mjO = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15260Rn(aar2.desc).svN;
                        obj = 1;
                        break;
                    case 17:
                        if (linkedList2.size() >= 4) {
                            break;
                        }
                        linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9212t5) + IOUtils.LINE_SEPARATOR_UNIX);
                        break;
                    case 19:
                        if (linkedList2.size() < 4) {
                            if (aar2.wgT.whN != null && aar2.wgT.whN.type == 3) {
                                linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9185s4) + IOUtils.LINE_SEPARATOR_UNIX);
                                break;
                            }
                            linkedList2.add(aar2.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f8821fz) + aar2.title + IOUtils.LINE_SEPARATOR_UNIX);
                            break;
                        }
                        break;
                        break;
                    default:
                        break;
                }
            }
            str = "";
            c11914a2.desc = "";
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
                    c11914a2.desc = str;
                    AppMethodBeat.m2505o(74127);
                    return c11914a2;
                }
            }
        }

        /* renamed from: a */
        private static void m19798a(C11914a c11914a, String str) {
            AppMethodBeat.m2504i(74128);
            String str2 = C39037b.bue() + C1178g.m2591x(C5046bo.m7532bc(str, "").getBytes());
            if (C11914a.m19796Mc(str2)) {
                c11914a.thumbPath = str2;
            }
            AppMethodBeat.m2505o(74128);
        }
    }

    /* renamed from: a */
    public static void m19791a(Context context, String str, String str2, C27966g c27966g, Runnable runnable) {
        AppMethodBeat.m2504i(74129);
        List linkedList = new LinkedList();
        linkedList.add(c27966g);
        C11909i.m19792a(context, str, str2, linkedList, runnable);
        AppMethodBeat.m2505o(74129);
    }

    /* renamed from: a */
    public static void m19792a(Context context, String str, String str2, List<C27966g> list, Runnable runnable) {
        AppMethodBeat.m2504i(74130);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.FavSendLogic", "want to send fav msg, but context is null");
            C5004al.m7441d(runnable);
            AppMethodBeat.m2505o(74130);
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.FavSendLogic", "want to send fav msg, but to user is null");
            C5004al.m7441d(runnable);
            AppMethodBeat.m2505o(74130);
        } else if (list.isEmpty()) {
            C4990ab.m7420w("MicroMsg.FavSendLogic", "want to send fav msg, but info is null");
            C5004al.m7441d(runnable);
            AppMethodBeat.m2505o(74130);
        } else {
            final String str3 = str;
            final List<C27966g> list2 = list;
            final Context context2 = context;
            final String str4 = str2;
            final Runnable runnable2 = runnable;
            C7305d.xDH.mo10142ak(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(74117);
                    for (String str : C5046bo.m7508P(str3.split(","))) {
                        for (C27966g c27966g : list2) {
                            if (c27966g != null) {
                                C7060h.pYm.mo8381e(10925, Integer.valueOf(c27966g.field_type), Integer.valueOf(c27966g.field_id));
                                String str2;
                                byte[] readFromFile;
                                Context context;
                                abe abe;
                                C42029mt c42029mt;
                                byte[] readFromFile2;
                                switch (c27966g.field_type) {
                                    case 1:
                                        C12519g.bOk().mo46456F(str, c27966g.field_favProto.desc, C1855t.m3925nK(str));
                                        break;
                                    case 2:
                                        Iterator it = c27966g.field_favProto.wiv.iterator();
                                        while (it.hasNext()) {
                                            C12519g.bOk().mo46457a(context2, str, C39037b.m66370b((aar) it.next()), 0, "", "");
                                        }
                                        break;
                                    case 4:
                                        C11909i.m19794b(context2, str, C39037b.m66378c(c27966g));
                                        break;
                                    case 5:
                                        if (c27966g != null) {
                                            aar c = C39037b.m66378c(c27966g);
                                            abu abu = c27966g.field_favProto.whA;
                                            abl abl = c27966g.field_favProto.wit;
                                            C8910b c8910b = new C8910b();
                                            if (abu != null) {
                                                c8910b.title = abu.title;
                                                str2 = abu.thumbUrl;
                                                if (C5046bo.isNullOrNil(str2)) {
                                                    str2 = C5046bo.m7532bc(c.cvq, "");
                                                }
                                                c8910b.thumburl = str2;
                                            }
                                            if (C5046bo.isNullOrNil(c8910b.title)) {
                                                c8910b.title = c.title;
                                            }
                                            if (abu != null) {
                                                c8910b.description = abu.desc;
                                            }
                                            if (C5046bo.isNullOrNil(c8910b.description)) {
                                                c8910b.description = c.desc;
                                            }
                                            if (c27966g.field_favProto.whA != null) {
                                                c8910b.url = c27966g.field_favProto.whA.wiY;
                                            }
                                            if (abl != null && C5046bo.isNullOrNil(c8910b.url)) {
                                                c8910b.url = abl.link;
                                            }
                                            if (!C5046bo.isNullOrNil(c.canvasPageXml)) {
                                                c8910b.canvasPageXml = c.canvasPageXml;
                                            }
                                            c8910b.action = "view";
                                            c8910b.type = 5;
                                            c8910b.cMn = c.cMn;
                                            readFromFile = C5046bo.readFromFile(C39037b.m66379c(c));
                                            if (readFromFile == null) {
                                                if (abu == null) {
                                                    str2 = null;
                                                } else {
                                                    str2 = abu.thumbUrl;
                                                }
                                                if (C5046bo.isNullOrNil(str2)) {
                                                    str2 = C5046bo.m7532bc(c.cvq, "");
                                                }
                                                readFromFile = C5046bo.readFromFile(C39037b.bue() + C1178g.m2591x(str2.getBytes()));
                                            }
                                            String str3 = "fav_" + C1853r.m3846Yz() + "_" + c27966g.field_id;
                                            String nW = C37922v.m64078nW(str3);
                                            C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
                                            y.mo53356j("prePublishId", str3);
                                            y.mo53356j("preUsername", c27966g.field_fromUser);
                                            y.mo53356j("sendAppMsgScene", Integer.valueOf(1));
                                            y.mo53356j("adExtStr", c.cMn);
                                            C12519g.bOk().mo46460a(str, readFromFile, C8910b.m16061a(c8910b, null, null), nW);
                                            break;
                                        }
                                        C4990ab.m7420w("MicroMsg.FavSendLogic", "item info is null, send fav url fail, return");
                                        break;
                                    case 6:
                                        aay aay = c27966g.field_favProto.why;
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("<msg>");
                                        stringBuilder.append("<location ");
                                        stringBuilder.append("x=\"").append(aay.lat).append("\" ");
                                        stringBuilder.append("y=\"").append(aay.lng).append("\" ");
                                        stringBuilder.append("scale=\"").append(aay.cED).append("\" ");
                                        stringBuilder.append("label=\"").append(C5046bo.m7532bc(aay.label, "")).append("\" ");
                                        stringBuilder.append("maptype=\"0\" ");
                                        stringBuilder.append("poiname=\"").append(C5046bo.m7532bc(aay.cIK, "")).append("\" ");
                                        stringBuilder.append("/>");
                                        stringBuilder.append("</msg>");
                                        C12519g.bOk().mo46456F(str, stringBuilder.toString(), 48);
                                        break;
                                    case 7:
                                        Context context2 = context2;
                                        aar c2 = C39037b.m66378c(c27966g);
                                        WXMusicObject wXMusicObject = new WXMusicObject();
                                        wXMusicObject.musicUrl = c2.wgg;
                                        wXMusicObject.musicDataUrl = c2.wgi;
                                        wXMusicObject.musicLowBandUrl = c2.wgk;
                                        wXMusicObject.musicLowBandDataUrl = c2.wgk;
                                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                        wXMediaMessage.mediaObject = wXMusicObject;
                                        wXMediaMessage.title = c2.title;
                                        wXMediaMessage.description = c2.desc;
                                        readFromFile = C5046bo.readFromFile(C39037b.m66379c(c2));
                                        if (readFromFile == null) {
                                            readFromFile = C5046bo.readFromFile(C39037b.bue() + C1178g.m2591x(C5046bo.m7532bc(c2.cvq, "").getBytes()));
                                        }
                                        wXMediaMessage.thumbData = readFromFile;
                                        str2 = c27966g.field_favProto.wit.appId;
                                        ((C6892ab) C1720g.m3528K(C6892ab.class)).mo15147a(wXMediaMessage, str2, C26410a.fls.mo44181t(context2, str2), str);
                                        break;
                                    case 8:
                                        C11909i.m19793a(str, c27966g, C39037b.m66378c(c27966g));
                                        break;
                                    case 10:
                                        context = context2;
                                        abe = c27966g.field_favProto.whC;
                                        c42029mt = new C42029mt();
                                        c42029mt.cIE.opType = 0;
                                        c42029mt.cIE.cIG = abe.info;
                                        c42029mt.cIE.context = context;
                                        C4879a.xxA.mo10055m(c42029mt);
                                        if (!c42029mt.cIF.cvi) {
                                            break;
                                        }
                                        readFromFile2 = C5046bo.readFromFile(C39037b.bue() + C1178g.m2591x(C5046bo.m7532bc(abe.thumbUrl, "").getBytes()));
                                        if (readFromFile2 == null) {
                                            readFromFile2 = C5046bo.readFromFile(c42029mt.cIF.thumbPath);
                                        }
                                        C12519g.bOk().mo46460a(str, readFromFile2, c42029mt.cIF.cIH, null);
                                        break;
                                    case 11:
                                        context = context2;
                                        abe = c27966g.field_favProto.whC;
                                        c42029mt = new C42029mt();
                                        c42029mt.cIE.opType = 1;
                                        c42029mt.cIE.cIG = abe.info;
                                        c42029mt.cIE.context = context;
                                        C4879a.xxA.mo10055m(c42029mt);
                                        if (!c42029mt.cIF.cvi) {
                                            break;
                                        }
                                        readFromFile2 = C5046bo.readFromFile(C39037b.bue() + C1178g.m2591x(C5046bo.m7532bc(abe.thumbUrl, "").getBytes()));
                                        if (readFromFile2 == null) {
                                            readFromFile2 = C5046bo.readFromFile(c42029mt.cIF.thumbPath);
                                        }
                                        C12519g.bOk().mo46460a(str, readFromFile2, c42029mt.cIF.cIH, null);
                                        break;
                                    case 14:
                                    case 18:
                                        C4990ab.m7417i("MicroMsg.FavSendLogic", "want send record, fav id %d", Integer.valueOf(c27966g.field_id));
                                        C11914a a = C11914a.m19797a(context2, c27966g);
                                        abf abf = new abf();
                                        try {
                                            C4990ab.m7410d("MicroMsg.FavSendLogic", "do clone fav proto item");
                                            abf.parseFrom(c27966g.field_favProto.toByteArray());
                                        } catch (Exception e) {
                                            C4990ab.printErrStackTrace("MicroMsg.FavSendLogic", e, "", new Object[0]);
                                            C4990ab.m7413e("MicroMsg.FavSendLogic", "clone fav proto item error: %s", e.getMessage());
                                        }
                                        LinkedList linkedList = abf.wiv;
                                        int i = 0;
                                        Iterator it2 = linkedList.iterator();
                                        while (true) {
                                            int i2 = i;
                                            if (!it2.hasNext()) {
                                                C18348nt c18348nt = new C18348nt();
                                                c18348nt.cJY.type = 2;
                                                c18348nt.cJY.toUser = str;
                                                c18348nt.cJY.cKb = abf;
                                                c18348nt.cJY.title = a.title;
                                                c18348nt.cJY.desc = a.desc;
                                                c18348nt.cJY.thumbPath = a.thumbPath;
                                                c18348nt.cJY.cKg = a.mjO;
                                                C4879a.xxA.mo10055m(c18348nt);
                                                break;
                                            }
                                            aar aar = (aar) it2.next();
                                            if (!(aar.wgT == null || aar.wgT.whN == null || aar.wgT.whN.type != 3)) {
                                                aar.mo27394LE(1);
                                                aar.akI(context2.getString(C25738R.string.f9185s4));
                                                linkedList.set(i2, aar);
                                                abf.mo74738aE(linkedList);
                                            }
                                            i = i2 + 1;
                                        }
                                    case 15:
                                        context = context2;
                                        abo abo = c27966g.field_favProto.whE;
                                        C42060sx c42060sx = new C42060sx();
                                        c42060sx.cPa.opType = 0;
                                        c42060sx.cPa.cPc = abo.info;
                                        c42060sx.cPa.context = context;
                                        C4879a.xxA.mo10055m(c42060sx);
                                        C4990ab.m7411d("MicroMsg.FavSendLogic", "sendFavTV ret = [%s], thumbUrl = [%s]", Boolean.valueOf(c42060sx.cPb.cvi), abo.thumbUrl);
                                        if (!c42060sx.cPb.cvi) {
                                            break;
                                        }
                                        readFromFile2 = C5046bo.readFromFile(C39037b.bue() + C1178g.m2591x(C5046bo.m7532bc(abo.thumbUrl, "").getBytes()));
                                        if (readFromFile2 == null) {
                                            readFromFile2 = C5046bo.readFromFile(c42060sx.cPb.thumbPath);
                                        }
                                        C12519g.bOk().mo46460a(str, readFromFile2, c42060sx.cPb.cIH, null);
                                        break;
                                    case 16:
                                        C11909i.m19789a(context2, str, C39037b.m66378c(c27966g));
                                        break;
                                    case 17:
                                        str2 = C39037b.m66378c(c27966g).desc;
                                        C12519g.bOk().mo46456F(str, str2, C7616ad.aox(C5135a.apC(str2).svN) ? 66 : 42);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            C4990ab.m7413e("MicroMsg.FavSendLogic", "in run workerThread,want to send fav msg, but info is null,infos.size = %d", Integer.valueOf(list2.size()));
                        }
                        if (!C5046bo.isNullOrNil(str4)) {
                            C12519g.bOk().mo46456F(str, str4, C1855t.m3925nK(str));
                        }
                    }
                    C5004al.m7441d(runnable2);
                    AppMethodBeat.m2505o(74117);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(74118);
                    String str = super.toString() + "|sendFavMsg";
                    AppMethodBeat.m2505o(74118);
                    return str;
                }
            });
            AppMethodBeat.m2505o(74130);
        }
    }

    /* renamed from: a */
    public static void m19790a(final Context context, final String str, final aar aar, final Runnable runnable) {
        AppMethodBeat.m2504i(74131);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
            AppMethodBeat.m2505o(74131);
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
            AppMethodBeat.m2505o(74131);
        } else if (aar == null) {
            C4990ab.m7420w("MicroMsg.FavSendLogic", "want to send fav video, but dataItem is null");
            AppMethodBeat.m2505o(74131);
        } else {
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(74120);
                    if (aar.dataType == 15) {
                        C11909i.m19789a(context, str, aar);
                    } else {
                        C11909i.m19794b(context, str, aar);
                    }
                    C5004al.m7441d(runnable);
                    AppMethodBeat.m2505o(74120);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(74121);
                    String str = super.toString() + "|sendFavVideo";
                    AppMethodBeat.m2505o(74121);
                    return str;
                }
            });
            AppMethodBeat.m2505o(74131);
        }
    }

    /* renamed from: a */
    public static void m19788a(Context context, final String str, final C27966g c27966g, final aar aar, final Runnable runnable) {
        AppMethodBeat.m2504i(74132);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.FavSendLogic", "want to send fav file, but context is null");
            AppMethodBeat.m2505o(74132);
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.FavSendLogic", "want to send fav file, but to user is null");
            AppMethodBeat.m2505o(74132);
        } else {
            if (c27966g == null) {
                C4990ab.m7420w("MicroMsg.FavSendLogic", "want to send fav file, but info is null");
            }
            if (aar == null) {
                C4990ab.m7420w("MicroMsg.FavSendLogic", "want to send fav file, but dataItem is null");
                AppMethodBeat.m2505o(74132);
                return;
            }
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(74122);
                    C11909i.m19793a(str, c27966g, aar);
                    C5004al.m7441d(runnable);
                    AppMethodBeat.m2505o(74122);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(74123);
                    String str = super.toString() + "|sendFavFile";
                    AppMethodBeat.m2505o(74123);
                    return str;
                }
            });
            AppMethodBeat.m2505o(74132);
        }
    }

    /* renamed from: i */
    public static String m19795i(aar aar) {
        String w;
        AppMethodBeat.m2504i(74133);
        C5728b c5728b = new C5728b(C39037b.m66379c(aar));
        if (c5728b.exists()) {
            w = C5736j.m8649w(c5728b.dMD());
        } else {
            w = C39037b.bue() + C1178g.m2591x(C5046bo.m7532bc(aar.cvq, "").getBytes());
        }
        AppMethodBeat.m2505o(74133);
        return w;
    }

    /* renamed from: b */
    static /* synthetic */ void m19794b(Context context, String str, aar aar) {
        AppMethodBeat.m2504i(74135);
        C5728b c5728b = new C5728b(C39037b.m66370b(aar));
        aau aau;
        if (c5728b.exists()) {
            String w;
            C5728b c5728b2 = new C5728b(C39037b.m66379c(aar));
            if (c5728b2.exists()) {
                w = C5736j.m8649w(c5728b2.dMD());
            } else {
                w = C39037b.bue() + C1178g.m2591x(C5046bo.m7532bc(aar.cvq, "").getBytes());
            }
            C4990ab.m7411d("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", C5736j.m8649w(c5728b.dMD()), w);
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
                C12519g.bOk().mo46458a(context, str, C5736j.m8649w(c5728b.dMD()), w, 1, aar.duration, cfh, aar.cMn);
                AppMethodBeat.m2505o(74135);
                return;
            }
            C12519g.bOk().mo46459a(context, str, C5736j.m8649w(c5728b.dMD()), w, 1, aar.duration, aar.cMn);
            AppMethodBeat.m2505o(74135);
            return;
        }
        String str2 = aar.wgg;
        if (!C5046bo.isNullOrNil(str2)) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = str2;
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            str2 = C5046bo.m7532bc(aar.title, context.getResources().getString(C25738R.string.bs9));
            wXMediaMessage.mediaObject = wXVideoObject;
            wXMediaMessage.title = str2;
            wXMediaMessage.description = aar.desc;
            wXMediaMessage.thumbData = C5046bo.readFromFile(C39037b.m66379c(aar));
            if (wXMediaMessage.thumbData == null) {
                wXMediaMessage.thumbData = C5046bo.readFromFile(C39037b.bue() + C1178g.m2591x(C5046bo.m7532bc(aar.cvq, "").getBytes()));
            }
            C8910b c8910b = new C8910b();
            c8910b.fgr = 3;
            aau = aar.wgZ;
            if (aau != null) {
                c8910b.fiL = aau.fiL;
                c8910b.fiI = aau.fiI;
                c8910b.fiH = aau.wid;
                c8910b.fiG = aau.fiG;
                c8910b.fiJ = aau.fiJ;
                c8910b.fiM = aau.fiM;
                c8910b.fiN = aau.fiN;
            }
            ((C6892ab) C1720g.m3528K(C6892ab.class)).mo15146a(c8910b, wXMediaMessage, str);
        }
        AppMethodBeat.m2505o(74135);
    }
}
