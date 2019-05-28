package com.tencent.p177mm.plugin.masssend.p992a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.masssend.a.c */
public final class C43293c {
    private LinkedList<C21269d> oof;

    public final void bNA() {
        C39356a c39356a = null;
        AppMethodBeat.m2504i(22730);
        boolean bNC = bNC();
        C9638aw.m17190ZK();
        boolean booleanValue = ((Boolean) C18628c.m29072Ry().get(102408, Boolean.FALSE)).booleanValue();
        int i = (C1853r.m3829YK() & 65536) == 0 ? 1 : 0;
        C4990ab.m7411d("MicroMsg.MassSendService", "hadSetTop is %B", Boolean.valueOf(booleanValue));
        if (i == 0 || booleanValue || !bNC) {
            if (!bNC) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(102408, Boolean.FALSE);
            }
            AppMethodBeat.m2505o(22730);
            return;
        }
        C4990ab.m7410d("MicroMsg.MassSendService", "set top conversation");
        C9638aw.m17190ZK();
        if (C18628c.m29083XR().aoZ("masssendapp") == null) {
            C9638aw.m17190ZK();
            if (C18628c.m29083XR().aoZ("masssendapp") == null) {
                C7617ak c7617ak = new C7617ak();
                c7617ak.setUsername("masssendapp");
                c7617ak.setContent(C4996ah.getContext().getResources().getString(C25738R.string.axn));
                c7617ak.mo14742eD(C5046bo.anU() + FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                c7617ak.mo14750hO(0);
                c7617ak.mo14748hM(0);
                C9638aw.m17190ZK();
                C18628c.m29083XR().mo15807d(c7617ak);
            }
        } else {
            String string;
            Cursor a = C21270h.bNE().fni.mo10104a("select * from massendinfo ORDER BY createtime DESC  limit 1", null, 2);
            if (a != null) {
                C39356a c39356a2;
                if (a.moveToFirst()) {
                    c39356a2 = new C39356a();
                    c39356a2.mo62252d(a);
                } else {
                    c39356a2 = null;
                }
                a.close();
                c39356a = c39356a2;
            }
            if (c39356a == null) {
                string = C4996ah.getContext().getResources().getString(C25738R.string.axn);
            } else {
                C21270h.bNE();
                string = C46069b.m85832a(c39356a);
            }
            C7617ak c7617ak2 = new C7617ak();
            c7617ak2.setUsername("masssendapp");
            c7617ak2.setContent(string);
            c7617ak2.mo14742eD(C5046bo.anU() + FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            c7617ak2.mo14750hO(0);
            c7617ak2.mo14748hM(0);
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo15767a(c7617ak2, "masssendapp");
        }
        C7060h.pYm.mo8374X(10425, "");
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(102409, Long.valueOf(C5046bo.anU()));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(102408, Boolean.TRUE);
        AppMethodBeat.m2505o(22730);
    }

    /* renamed from: je */
    public static void m77162je(long j) {
        AppMethodBeat.m2504i(22731);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(102409, Long.valueOf(j));
        AppMethodBeat.m2505o(22731);
    }

    private static String bNB() {
        AppMethodBeat.m2504i(22732);
        if (C9638aw.m17179RK()) {
            r1 = new Object[2];
            C9638aw.m17190ZK();
            r1[0] = C18628c.m29068Rt();
            r1[1] = C4988aa.dor();
            C4990ab.m7411d("MicroMsg.MassSendService", "config file path is %s", String.format("%s/masssend_%s.ini", r1));
            AppMethodBeat.m2505o(22732);
            return String.format("%s/masssend_%s.ini", r1);
        }
        String str = "";
        AppMethodBeat.m2505o(22732);
        return str;
    }

    private boolean bNC() {
        AppMethodBeat.m2504i(22733);
        if (this.oof == null) {
            String bNB = C43293c.bNB();
            byte[] e = C5730e.m8632e(bNB, 0, -1);
            if (e == null) {
                AppMethodBeat.m2505o(22733);
                return false;
            }
            try {
                this.oof = ((C28480e) new C28480e().parseFrom(e)).oog;
            } catch (Exception e2) {
                C5730e.deleteFile(bNB);
                AppMethodBeat.m2505o(22733);
                return false;
            }
        }
        if (this.oof == null) {
            C4990ab.m7420w("MicroMsg.MassSendService", "info list is empty");
            AppMethodBeat.m2505o(22733);
            return false;
        }
        C4990ab.m7417i("MicroMsg.MassSendService", "info list[%s]", this.oof.toString());
        long anT = C5046bo.anT();
        Iterator it = this.oof.iterator();
        while (it.hasNext()) {
            C21269d c21269d = (C21269d) it.next();
            if (((long) c21269d.ccb) <= anT && anT <= ((long) c21269d.end)) {
                AppMethodBeat.m2505o(22733);
                return true;
            }
        }
        AppMethodBeat.m2505o(22733);
        return false;
    }

    /* renamed from: Qt */
    public final void mo68839Qt(String str) {
        AppMethodBeat.m2504i(22734);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(22734);
            return;
        }
        Map z = C5049br.m7595z(str, "Festivals");
        if (z == null) {
            AppMethodBeat.m2505o(22734);
            return;
        }
        C28480e c28480e = new C28480e();
        int i = 0;
        while (true) {
            String str2 = ".Festivals.Festival" + (i == 0 ? "" : String.valueOf(i));
            if (!z.containsKey(str2)) {
                break;
            }
            C21269d c21269d = new C21269d();
            c21269d.ccb = C5046bo.anb((String) z.get(str2 + ".StartTime"));
            c21269d.end = C5046bo.anb((String) z.get(str2 + ".EndTime")) + Downloads.MAX_RETYR_AFTER;
            c28480e.oog.add(c21269d);
            i++;
        }
        c28480e.count = c28480e.oog.size();
        this.oof = c28480e.oog;
        try {
            byte[] toByteArray = c28480e.toByteArray();
            String bNB = C43293c.bNB();
            if (C5046bo.isNullOrNil(bNB)) {
                C4990ab.m7420w("MicroMsg.MassSendService", "mass send config file path is null, return");
                AppMethodBeat.m2505o(22734);
                return;
            }
            C5728b c5728b = new C5728b(bNB);
            if (c5728b.exists()) {
                if ((!C5730e.atg(C5736j.m8649w(c5728b.mUri)).equals(C1178g.m2591x(toByteArray)) ? 1 : 0) != 0) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(102408, Boolean.FALSE);
                }
            } else {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(102408, Boolean.FALSE);
            }
            C4990ab.m7411d("MicroMsg.MassSendService", "save to config file : %s", c28480e.toString());
            C5730e.m8624b(bNB, toByteArray, toByteArray.length);
            AppMethodBeat.m2505o(22734);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MassSendService", e, "", new Object[0]);
            AppMethodBeat.m2505o(22734);
        }
    }
}
