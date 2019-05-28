package com.tencent.p177mm.plugin.fav.p410ui;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.view.C31128d;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.ui.h */
public final class C3109h {
    /* renamed from: a */
    public static boolean m5350a(String str, LinkedList<aar> linkedList, long j) {
        AppMethodBeat.m2504i(74035);
        if (str.length() == 0) {
            C4990ab.m7412e("MicroMsg.FavPostLogic", "postNote null");
            AppMethodBeat.m2505o(74035);
            return false;
        }
        C27966g a;
        if (-1 == j) {
            a = C3109h.m5349a(linkedList, j);
        } else {
            a = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(j);
        }
        C34157b.m56005B(a);
        AppMethodBeat.m2505o(74035);
        return true;
    }

    /* renamed from: a */
    public static C27966g m5349a(LinkedList<aar> linkedList, long j) {
        AppMethodBeat.m2504i(74036);
        C27966g c27966g = null;
        if (j != -1) {
            c27966g = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(j);
            if (c27966g == null) {
                c27966g = C3109h.m5353iJ(j);
            }
            c27966g.field_favProto.wiv.clear();
        }
        if (c27966g == null) {
            c27966g = new C27966g();
            c27966g.field_type = 18;
            c27966g.field_sourceType = 6;
            C3109h.m5348E(c27966g);
            c27966g.field_favProto.mo74735LM(1);
            c27966g.field_favProto.mo74734LL(C31128d.MIC_SketchMark);
        }
        c27966g.field_edittime = C5046bo.anT();
        c27966g.field_updateTime = C5046bo.anU();
        c27966g.field_favProto.mo74748mk(c27966g.field_edittime);
        c27966g.field_favProto.wit.mo39136ml(C5046bo.anU());
        c27966g.field_favProto.mo74738aE(linkedList);
        AppMethodBeat.m2505o(74036);
        return c27966g;
    }

    /* renamed from: iJ */
    private static C27966g m5353iJ(long j) {
        AppMethodBeat.m2504i(74037);
        C27966g c27966g = new C27966g();
        c27966g.field_type = 18;
        c27966g.field_sourceType = 6;
        String Yz = C1853r.m3846Yz();
        abl abl = new abl();
        abl.alD(Yz);
        abl.alE(Yz);
        abl.mo39126LN(c27966g.field_sourceType);
        abl.mo39136ml(C5046bo.anU());
        c27966g.field_favProto.mo74737a(abl);
        c27966g.field_fromUser = abl.cEV;
        c27966g.field_toUser = abl.toUser;
        c27966g.field_favProto.mo74735LM(1);
        c27966g.field_favProto.mo74734LL(C31128d.MIC_SketchMark);
        c27966g.field_edittime = C5046bo.anT();
        c27966g.field_updateTime = C5046bo.anU();
        c27966g.field_favProto.mo74748mk(c27966g.field_edittime);
        c27966g.field_favProto.wit.mo39136ml(C5046bo.anU());
        c27966g.field_itemStatus = 9;
        c27966g.field_localId = j;
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23700y(c27966g);
        AppMethodBeat.m2505o(74037);
        return c27966g;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045 A:{Splitter:B:9:0x0028, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:21:0x0046, code skipped:
            com.tencent.p177mm.sdk.platformtools.C5046bo.m7527b(r2);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(74038);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: bN */
    private static List<String> m5351bN(List<String> list) {
        InputStream inputStream;
        AppMethodBeat.m2504i(74038);
        if (list == null || list.size() == 0) {
            AppMethodBeat.m2505o(74038);
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            inputStream = null;
            try {
                inputStream = C5730e.openRead(str);
                if (inputStream == null) {
                    C5046bo.m7527b(inputStream);
                } else {
                    if (C5063r.amn(str)) {
                        arrayList.add(str);
                    }
                    C5046bo.m7527b(inputStream);
                }
            } catch (Exception e) {
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.m2505o(74038);
        return arrayList;
        C5046bo.m7527b(inputStream);
    }

    /* renamed from: E */
    static void m5348E(C27966g c27966g) {
        AppMethodBeat.m2504i(74040);
        String Yz = C1853r.m3846Yz();
        abl abl = new abl();
        abl.alD(Yz);
        abl.alE(Yz);
        abl.mo39126LN(c27966g.field_sourceType);
        abl.mo39136ml(C5046bo.anU());
        c27966g.field_favProto.mo74737a(abl);
        c27966g.field_fromUser = abl.cEV;
        c27966g.field_toUser = abl.toUser;
        AppMethodBeat.m2505o(74040);
    }

    /* renamed from: bO */
    public static boolean m5352bO(List<String> list) {
        AppMethodBeat.m2504i(74039);
        List<String> bN = C3109h.m5351bN(list);
        if (bN == null || bN.size() == 0) {
            C4990ab.m7412e("MicroMsg.FavPostLogic", "postImgs path null");
            AppMethodBeat.m2505o(74039);
            return false;
        }
        C27966g c27966g = new C27966g();
        c27966g.field_type = 2;
        c27966g.field_sourceType = 6;
        C3109h.m5348E(c27966g);
        for (String str : bN) {
            aar aar = new aar();
            aar.akV(str);
            aar.akU(C39037b.m66382cf(aar.toString(), 2));
            C5056d.m7656c(str, 150, 150, CompressFormat.JPEG, 90, C39037b.m66379c(aar));
            aar.akW(C39037b.m66379c(aar));
            aar.mo27394LE(2);
            c27966g.field_favProto.wiv.add(aar);
        }
        C34157b.m56005B(c27966g);
        C7060h.pYm.mo8381e(10648, Integer.valueOf(2), Integer.valueOf(bN.size()));
        AppMethodBeat.m2505o(74039);
        return true;
    }
}
