package com.tencent.mm.bi;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.a.fy;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.HashMap;

public class d implements at {
    public static int eRI = 0;
    public static int[] fUz = new int[1000];
    private final long TIME_INTERVAL = 259200000;
    private final int cfP = 0;
    private c fUA = new c<fy>() {
        {
            AppMethodBeat.i(16620);
            this.xxI = fy.class.getName().hashCode();
            AppMethodBeat.o(16620);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(16621);
            fy fyVar = (fy) bVar;
            int i = fyVar.cAb.cAd;
            String str = fyVar.cAb.talker;
            int i2 = fyVar.cAb.state;
            if (i == 1) {
                aw akP = d.akP();
                av avVar = new av();
                avVar.field_state = -1;
                Cursor a = akP.bSd.a(String.format("select %s from %s where %s = %s", new Object[]{"state", "fmessage_conversation", "talker", h.escape(str)}), null, 2);
                if (a.moveToFirst()) {
                    avVar.d(a);
                }
                a.close();
                i2 = avVar.field_state;
            } else if (i == 0) {
                if (i2 == 2) {
                    d.akP().ep(str, 2);
                } else if (i2 == 1) {
                    d.akP().ep(str, 1);
                } else {
                    d.akP().ep(str, 0);
                }
            }
            fyVar.cAc.state = i2;
            AppMethodBeat.o(16621);
            return false;
        }
    };
    private e fUw = new e();
    private b fUx = new b();
    private final int fUy = 2;

    public d() {
        AppMethodBeat.i(16622);
        AppMethodBeat.o(16622);
    }

    public static ay akO() {
        AppMethodBeat.i(16623);
        g.RN().QU();
        ay ayVar = (ay) ((j) g.K(j.class)).bOq();
        ayVar.a(akP(), g.RS().oAl.getLooper());
        AppMethodBeat.o(16623);
        return ayVar;
    }

    public static aw akP() {
        AppMethodBeat.i(16624);
        g.RN().QU();
        aw awVar = (aw) ((j) g.K(j.class)).bOp();
        AppMethodBeat.o(16624);
        return awVar;
    }

    public static bg akQ() {
        AppMethodBeat.i(16625);
        g.RN().QU();
        bg bgVar = (bg) ((j) g.K(j.class)).bOo();
        AppMethodBeat.o(16625);
        return bgVar;
    }

    public static bu akR() {
        AppMethodBeat.i(16626);
        g.RN().QU();
        bu buVar = (bu) ((j) g.K(j.class)).bOn();
        AppMethodBeat.o(16626);
        return buVar;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(16627);
        com.tencent.mm.ai.e.d.b(Integer.valueOf(37), this.fUw);
        com.tencent.mm.ai.e.d.b(Integer.valueOf(65), this.fUw);
        com.tencent.mm.ai.e.d.b(Integer.valueOf(40), this.fUx);
        a.xxA.d(this.fUA);
        com.tencent.mm.model.aw.getNotification().IH();
        AppMethodBeat.o(16627);
    }

    public final HashMap<Integer, com.tencent.mm.cd.h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        int i = 1;
        AppMethodBeat.i(16628);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(37), this.fUw);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(65), this.fUw);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(40), this.fUx);
        a.xxA.c(this.fUA);
        int dtd = akP().dtd();
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.model.aw.ZK();
        currentTimeMillis -= bo.a((Long) com.tencent.mm.model.c.Ry().get(340225, null), 0);
        ab.i("MicroMsg.SubCoreVerify", "timeInterval = ".concat(String.valueOf(currentTimeMillis)));
        if (currentTimeMillis > 259200000 && dtd > 0) {
            aw akP = akP();
            Cursor a = akP.bSd.a(String.format("select %s from %s where isNew = 1 ORDER BY lastModifiedTime DESC limit %d", new Object[]{"contentNickname", "fmessage_conversation", Integer.valueOf(2)}), null, 2);
            ArrayList arrayList = new ArrayList();
            while (a.moveToNext()) {
                arrayList.add(a.getString(a.getColumnIndex("contentNickname")));
            }
            a.close();
            int size = arrayList.size();
            if (size > 0) {
                String str = (String) arrayList.get(0);
                while (i < size) {
                    str = str + ", " + ((String) arrayList.get(i));
                    i++;
                }
                ab.i("MicroMsg.SubCoreVerify", "title = ".concat(String.valueOf(str)));
                kz kzVar = new kz();
                kzVar.cGR.userName = null;
                kzVar.cGR.bCu = str;
                kzVar.cGR.type = 0;
                a.xxA.m(kzVar);
                com.tencent.mm.model.aw.ZK();
                com.tencent.mm.model.c.Ry().set(340225, Long.valueOf(System.currentTimeMillis()));
            }
        }
        AppMethodBeat.o(16628);
    }

    public final void bA(boolean z) {
    }

    public static void a(cm cmVar, com.tencent.mm.storage.bi.d dVar) {
        AppMethodBeat.i(16629);
        ab.d("MicroMsg.SubCoreVerify", "saveToLbsVerifyStg, cmdAM, status = " + cmVar.jBT + ", id = " + cmVar.ptF);
        bf bfVar = new bf();
        bfVar.field_content = aa.a(cmVar.vED);
        bfVar.field_createtime = bo.anT();
        bfVar.field_imgpath = "";
        bfVar.field_sayhicontent = dVar.content;
        bfVar.field_sayhiuser = dVar.svN;
        bfVar.field_scene = dVar.scene;
        bfVar.field_status = cmVar.jBT > 3 ? cmVar.jBT : 3;
        bfVar.field_svrid = cmVar.ptF;
        bfVar.field_talker = aa.a(cmVar.vEB);
        bfVar.field_type = cmVar.nao;
        bfVar.field_isSend = 0;
        bfVar.field_sayhiencryptuser = dVar.xZx;
        bfVar.field_ticket = dVar.mGZ;
        bfVar.field_flag = 1;
        ((bg) ((j) g.K(j.class)).bOo()).a(bfVar);
        com.tencent.mm.ah.b.U(bfVar.field_sayhiencryptuser, 3);
        AppMethodBeat.o(16629);
    }

    public static void b(cm cmVar, com.tencent.mm.storage.bi.d dVar) {
        AppMethodBeat.i(16630);
        ab.d("MicroMsg.SubCoreVerify", "saveToShakeVerifyStg, cmdAM, status = " + cmVar.jBT + ", id = " + cmVar.ptF);
        bt btVar = new bt();
        btVar.field_content = aa.a(cmVar.vED);
        btVar.field_createtime = bo.anT();
        btVar.field_imgpath = "";
        btVar.field_sayhicontent = dVar.content;
        btVar.field_sayhiuser = dVar.svN;
        btVar.field_scene = dVar.scene;
        btVar.field_status = cmVar.jBT > 3 ? cmVar.jBT : 3;
        btVar.field_svrid = cmVar.ptF;
        btVar.field_talker = aa.a(cmVar.vEB);
        btVar.field_type = cmVar.nao;
        btVar.field_isSend = 0;
        ((bu) ((j) g.K(j.class)).bOn()).a(btVar);
        com.tencent.mm.ah.b.U(btVar.field_sayhiuser, 3);
        AppMethodBeat.o(16630);
    }
}
