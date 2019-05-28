package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ak;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c {
    private LinkedList<d> oof;

    public final void bNA() {
        a aVar = null;
        AppMethodBeat.i(22730);
        boolean bNC = bNC();
        aw.ZK();
        boolean booleanValue = ((Boolean) com.tencent.mm.model.c.Ry().get(102408, Boolean.FALSE)).booleanValue();
        int i = (r.YK() & 65536) == 0 ? 1 : 0;
        ab.d("MicroMsg.MassSendService", "hadSetTop is %B", Boolean.valueOf(booleanValue));
        if (i == 0 || booleanValue || !bNC) {
            if (!bNC) {
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(102408, Boolean.FALSE);
            }
            AppMethodBeat.o(22730);
            return;
        }
        ab.d("MicroMsg.MassSendService", "set top conversation");
        aw.ZK();
        if (com.tencent.mm.model.c.XR().aoZ("masssendapp") == null) {
            aw.ZK();
            if (com.tencent.mm.model.c.XR().aoZ("masssendapp") == null) {
                ak akVar = new ak();
                akVar.setUsername("masssendapp");
                akVar.setContent(ah.getContext().getResources().getString(R.string.axn));
                akVar.eD(bo.anU() + FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                akVar.hO(0);
                akVar.hM(0);
                aw.ZK();
                com.tencent.mm.model.c.XR().d(akVar);
            }
        } else {
            String string;
            Cursor a = h.bNE().fni.a("select * from massendinfo ORDER BY createtime DESC  limit 1", null, 2);
            if (a != null) {
                a aVar2;
                if (a.moveToFirst()) {
                    aVar2 = new a();
                    aVar2.d(a);
                } else {
                    aVar2 = null;
                }
                a.close();
                aVar = aVar2;
            }
            if (aVar == null) {
                string = ah.getContext().getResources().getString(R.string.axn);
            } else {
                h.bNE();
                string = b.a(aVar);
            }
            ak akVar2 = new ak();
            akVar2.setUsername("masssendapp");
            akVar2.setContent(string);
            akVar2.eD(bo.anU() + FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            akVar2.hO(0);
            akVar2.hM(0);
            aw.ZK();
            com.tencent.mm.model.c.XR().a(akVar2, "masssendapp");
        }
        h.pYm.X(10425, "");
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(102409, Long.valueOf(bo.anU()));
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(102408, Boolean.TRUE);
        AppMethodBeat.o(22730);
    }

    public static void je(long j) {
        AppMethodBeat.i(22731);
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(102409, Long.valueOf(j));
        AppMethodBeat.o(22731);
    }

    private static String bNB() {
        AppMethodBeat.i(22732);
        if (aw.RK()) {
            r1 = new Object[2];
            aw.ZK();
            r1[0] = com.tencent.mm.model.c.Rt();
            r1[1] = aa.dor();
            ab.d("MicroMsg.MassSendService", "config file path is %s", String.format("%s/masssend_%s.ini", r1));
            AppMethodBeat.o(22732);
            return String.format("%s/masssend_%s.ini", r1);
        }
        String str = "";
        AppMethodBeat.o(22732);
        return str;
    }

    private boolean bNC() {
        AppMethodBeat.i(22733);
        if (this.oof == null) {
            String bNB = bNB();
            byte[] e = e.e(bNB, 0, -1);
            if (e == null) {
                AppMethodBeat.o(22733);
                return false;
            }
            try {
                this.oof = ((e) new e().parseFrom(e)).oog;
            } catch (Exception e2) {
                e.deleteFile(bNB);
                AppMethodBeat.o(22733);
                return false;
            }
        }
        if (this.oof == null) {
            ab.w("MicroMsg.MassSendService", "info list is empty");
            AppMethodBeat.o(22733);
            return false;
        }
        ab.i("MicroMsg.MassSendService", "info list[%s]", this.oof.toString());
        long anT = bo.anT();
        Iterator it = this.oof.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (((long) dVar.ccb) <= anT && anT <= ((long) dVar.end)) {
                AppMethodBeat.o(22733);
                return true;
            }
        }
        AppMethodBeat.o(22733);
        return false;
    }

    public final void Qt(String str) {
        AppMethodBeat.i(22734);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(22734);
            return;
        }
        Map z = br.z(str, "Festivals");
        if (z == null) {
            AppMethodBeat.o(22734);
            return;
        }
        e eVar = new e();
        int i = 0;
        while (true) {
            String str2 = ".Festivals.Festival" + (i == 0 ? "" : String.valueOf(i));
            if (!z.containsKey(str2)) {
                break;
            }
            d dVar = new d();
            dVar.ccb = bo.anb((String) z.get(str2 + ".StartTime"));
            dVar.end = bo.anb((String) z.get(str2 + ".EndTime")) + Downloads.MAX_RETYR_AFTER;
            eVar.oog.add(dVar);
            i++;
        }
        eVar.count = eVar.oog.size();
        this.oof = eVar.oog;
        try {
            byte[] toByteArray = eVar.toByteArray();
            String bNB = bNB();
            if (bo.isNullOrNil(bNB)) {
                ab.w("MicroMsg.MassSendService", "mass send config file path is null, return");
                AppMethodBeat.o(22734);
                return;
            }
            b bVar = new b(bNB);
            if (bVar.exists()) {
                if ((!e.atg(j.w(bVar.mUri)).equals(g.x(toByteArray)) ? 1 : 0) != 0) {
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(102408, Boolean.FALSE);
                }
            } else {
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(102408, Boolean.FALSE);
            }
            ab.d("MicroMsg.MassSendService", "save to config file : %s", eVar.toString());
            e.b(bNB, toByteArray, toByteArray.length);
            AppMethodBeat.o(22734);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MassSendService", e, "", new Object[0]);
            AppMethodBeat.o(22734);
        }
    }
}
