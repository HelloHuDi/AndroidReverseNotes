package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.view.d;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class h {
    public static boolean a(String str, LinkedList<aar> linkedList, long j) {
        AppMethodBeat.i(74035);
        if (str.length() == 0) {
            ab.e("MicroMsg.FavPostLogic", "postNote null");
            AppMethodBeat.o(74035);
            return false;
        }
        g a;
        if (-1 == j) {
            a = a(linkedList, j);
        } else {
            a = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(j);
        }
        b.B(a);
        AppMethodBeat.o(74035);
        return true;
    }

    public static g a(LinkedList<aar> linkedList, long j) {
        AppMethodBeat.i(74036);
        g gVar = null;
        if (j != -1) {
            gVar = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(j);
            if (gVar == null) {
                gVar = iJ(j);
            }
            gVar.field_favProto.wiv.clear();
        }
        if (gVar == null) {
            gVar = new g();
            gVar.field_type = 18;
            gVar.field_sourceType = 6;
            E(gVar);
            gVar.field_favProto.LM(1);
            gVar.field_favProto.LL(d.MIC_SketchMark);
        }
        gVar.field_edittime = bo.anT();
        gVar.field_updateTime = bo.anU();
        gVar.field_favProto.mk(gVar.field_edittime);
        gVar.field_favProto.wit.ml(bo.anU());
        gVar.field_favProto.aE(linkedList);
        AppMethodBeat.o(74036);
        return gVar;
    }

    private static g iJ(long j) {
        AppMethodBeat.i(74037);
        g gVar = new g();
        gVar.field_type = 18;
        gVar.field_sourceType = 6;
        String Yz = r.Yz();
        abl abl = new abl();
        abl.alD(Yz);
        abl.alE(Yz);
        abl.LN(gVar.field_sourceType);
        abl.ml(bo.anU());
        gVar.field_favProto.a(abl);
        gVar.field_fromUser = abl.cEV;
        gVar.field_toUser = abl.toUser;
        gVar.field_favProto.LM(1);
        gVar.field_favProto.LL(d.MIC_SketchMark);
        gVar.field_edittime = bo.anT();
        gVar.field_updateTime = bo.anU();
        gVar.field_favProto.mk(gVar.field_edittime);
        gVar.field_favProto.wit.ml(bo.anU());
        gVar.field_itemStatus = 9;
        gVar.field_localId = j;
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().y(gVar);
        AppMethodBeat.o(74037);
        return gVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045 A:{Splitter:B:9:0x0028, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:21:0x0046, code skipped:
            com.tencent.mm.sdk.platformtools.bo.b(r2);
            com.tencent.matrix.trace.core.AppMethodBeat.o(74038);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static List<String> bN(List<String> list) {
        InputStream inputStream;
        AppMethodBeat.i(74038);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(74038);
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            inputStream = null;
            try {
                inputStream = e.openRead(str);
                if (inputStream == null) {
                    bo.b(inputStream);
                } else {
                    if (com.tencent.mm.sdk.platformtools.r.amn(str)) {
                        arrayList.add(str);
                    }
                    bo.b(inputStream);
                }
            } catch (Exception e) {
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.o(74038);
        return arrayList;
        bo.b(inputStream);
    }

    static void E(g gVar) {
        AppMethodBeat.i(74040);
        String Yz = r.Yz();
        abl abl = new abl();
        abl.alD(Yz);
        abl.alE(Yz);
        abl.LN(gVar.field_sourceType);
        abl.ml(bo.anU());
        gVar.field_favProto.a(abl);
        gVar.field_fromUser = abl.cEV;
        gVar.field_toUser = abl.toUser;
        AppMethodBeat.o(74040);
    }

    public static boolean bO(List<String> list) {
        AppMethodBeat.i(74039);
        List<String> bN = bN(list);
        if (bN == null || bN.size() == 0) {
            ab.e("MicroMsg.FavPostLogic", "postImgs path null");
            AppMethodBeat.o(74039);
            return false;
        }
        g gVar = new g();
        gVar.field_type = 2;
        gVar.field_sourceType = 6;
        E(gVar);
        for (String str : bN) {
            aar aar = new aar();
            aar.akV(str);
            aar.akU(b.cf(aar.toString(), 2));
            com.tencent.mm.sdk.platformtools.d.c(str, 150, 150, CompressFormat.JPEG, 90, b.c(aar));
            aar.akW(b.c(aar));
            aar.LE(2);
            gVar.field_favProto.wiv.add(aar);
        }
        b.B(gVar);
        com.tencent.mm.plugin.report.service.h.pYm.e(10648, Integer.valueOf(2), Integer.valueOf(bN.size()));
        AppMethodBeat.o(74039);
        return true;
    }
}
