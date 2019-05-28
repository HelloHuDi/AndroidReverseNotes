package com.tencent.p177mm.p1374bi;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C18269fy;
import com.tencent.p177mm.p230g.p231a.C6512kz;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C35998bg;
import com.tencent.p177mm.storage.C41338bt;
import com.tencent.p177mm.storage.C46622bu;
import com.tencent.p177mm.storage.C7568av;
import com.tencent.p177mm.storage.C7570bf;
import com.tencent.p177mm.storage.C7618aw;
import com.tencent.p177mm.storage.C7619ay;
import com.tencent.p177mm.storage.C7620bi.C5138d;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.tencent.mm.bi.d */
public class C41789d implements C1816at {
    public static int eRI = 0;
    public static int[] fUz = new int[1000];
    private final long TIME_INTERVAL = 259200000;
    private final int cfP = 0;
    private C4884c fUA = new C417881();
    private C37513e fUw = new C37513e();
    private C25861b fUx = new C25861b();
    private final int fUy = 2;

    /* renamed from: com.tencent.mm.bi.d$1 */
    class C417881 extends C4884c<C18269fy> {
        C417881() {
            AppMethodBeat.m2504i(16620);
            this.xxI = C18269fy.class.getName().hashCode();
            AppMethodBeat.m2505o(16620);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(16621);
            C18269fy c18269fy = (C18269fy) c4883b;
            int i = c18269fy.cAb.cAd;
            String str = c18269fy.cAb.talker;
            int i2 = c18269fy.cAb.state;
            if (i == 1) {
                C7618aw akP = C41789d.akP();
                C7568av c7568av = new C7568av();
                c7568av.field_state = -1;
                Cursor a = akP.bSd.mo10104a(String.format("select %s from %s where %s = %s", new Object[]{"state", "fmessage_conversation", "talker", C7480h.escape(str)}), null, 2);
                if (a.moveToFirst()) {
                    c7568av.mo8995d(a);
                }
                a.close();
                i2 = c7568av.field_state;
            } else if (i == 0) {
                if (i2 == 2) {
                    C41789d.akP().mo17076ep(str, 2);
                } else if (i2 == 1) {
                    C41789d.akP().mo17076ep(str, 1);
                } else {
                    C41789d.akP().mo17076ep(str, 0);
                }
            }
            c18269fy.cAc.state = i2;
            AppMethodBeat.m2505o(16621);
            return false;
        }
    }

    public C41789d() {
        AppMethodBeat.m2504i(16622);
        AppMethodBeat.m2505o(16622);
    }

    public static C7619ay akO() {
        AppMethodBeat.m2504i(16623);
        C1720g.m3534RN().mo5159QU();
        C7619ay c7619ay = (C7619ay) ((C6982j) C1720g.m3528K(C6982j.class)).bOq();
        c7619ay.mo10114a(C41789d.akP(), C1720g.m3539RS().oAl.getLooper());
        AppMethodBeat.m2505o(16623);
        return c7619ay;
    }

    public static C7618aw akP() {
        AppMethodBeat.m2504i(16624);
        C1720g.m3534RN().mo5159QU();
        C7618aw c7618aw = (C7618aw) ((C6982j) C1720g.m3528K(C6982j.class)).bOp();
        AppMethodBeat.m2505o(16624);
        return c7618aw;
    }

    public static C35998bg akQ() {
        AppMethodBeat.m2504i(16625);
        C1720g.m3534RN().mo5159QU();
        C35998bg c35998bg = (C35998bg) ((C6982j) C1720g.m3528K(C6982j.class)).bOo();
        AppMethodBeat.m2505o(16625);
        return c35998bg;
    }

    public static C46622bu akR() {
        AppMethodBeat.m2504i(16626);
        C1720g.m3534RN().mo5159QU();
        C46622bu c46622bu = (C46622bu) ((C6982j) C1720g.m3528K(C6982j.class)).bOn();
        AppMethodBeat.m2505o(16626);
        return c46622bu;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(16627);
        C1200d.m2637b(Integer.valueOf(37), this.fUw);
        C1200d.m2637b(Integer.valueOf(65), this.fUw);
        C1200d.m2637b(Integer.valueOf(40), this.fUx);
        C4879a.xxA.mo10053d(this.fUA);
        C9638aw.getNotification().mo41568IH();
        AppMethodBeat.m2505o(16627);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        int i = 1;
        AppMethodBeat.m2504i(16628);
        C1200d.m2636a(Integer.valueOf(37), this.fUw);
        C1200d.m2636a(Integer.valueOf(65), this.fUw);
        C1200d.m2636a(Integer.valueOf(40), this.fUx);
        C4879a.xxA.mo10052c(this.fUA);
        int dtd = C41789d.akP().dtd();
        long currentTimeMillis = System.currentTimeMillis();
        C9638aw.m17190ZK();
        currentTimeMillis -= C5046bo.m7514a((Long) C18628c.m29072Ry().get(340225, null), 0);
        C4990ab.m7416i("MicroMsg.SubCoreVerify", "timeInterval = ".concat(String.valueOf(currentTimeMillis)));
        if (currentTimeMillis > 259200000 && dtd > 0) {
            C7618aw akP = C41789d.akP();
            Cursor a = akP.bSd.mo10104a(String.format("select %s from %s where isNew = 1 ORDER BY lastModifiedTime DESC limit %d", new Object[]{"contentNickname", "fmessage_conversation", Integer.valueOf(2)}), null, 2);
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
                C4990ab.m7416i("MicroMsg.SubCoreVerify", "title = ".concat(String.valueOf(str)));
                C6512kz c6512kz = new C6512kz();
                c6512kz.cGR.userName = null;
                c6512kz.cGR.bCu = str;
                c6512kz.cGR.type = 0;
                C4879a.xxA.mo10055m(c6512kz);
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(340225, Long.valueOf(System.currentTimeMillis()));
            }
        }
        AppMethodBeat.m2505o(16628);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: a */
    public static void m73765a(C7254cm c7254cm, C5138d c5138d) {
        AppMethodBeat.m2504i(16629);
        C4990ab.m7410d("MicroMsg.SubCoreVerify", "saveToLbsVerifyStg, cmdAM, status = " + c7254cm.jBT + ", id = " + c7254cm.ptF);
        C7570bf c7570bf = new C7570bf();
        c7570bf.field_content = C1946aa.m4148a(c7254cm.vED);
        c7570bf.field_createtime = C5046bo.anT();
        c7570bf.field_imgpath = "";
        c7570bf.field_sayhicontent = c5138d.content;
        c7570bf.field_sayhiuser = c5138d.svN;
        c7570bf.field_scene = c5138d.scene;
        c7570bf.field_status = c7254cm.jBT > 3 ? c7254cm.jBT : 3;
        c7570bf.field_svrid = c7254cm.ptF;
        c7570bf.field_talker = C1946aa.m4148a(c7254cm.vEB);
        c7570bf.field_type = c7254cm.nao;
        c7570bf.field_isSend = 0;
        c7570bf.field_sayhiencryptuser = c5138d.xZx;
        c7570bf.field_ticket = c5138d.mGZ;
        c7570bf.field_flag = 1;
        ((C35998bg) ((C6982j) C1720g.m3528K(C6982j.class)).bOo()).mo56738a(c7570bf);
        C41730b.m73489U(c7570bf.field_sayhiencryptuser, 3);
        AppMethodBeat.m2505o(16629);
    }

    /* renamed from: b */
    public static void m73766b(C7254cm c7254cm, C5138d c5138d) {
        AppMethodBeat.m2504i(16630);
        C4990ab.m7410d("MicroMsg.SubCoreVerify", "saveToShakeVerifyStg, cmdAM, status = " + c7254cm.jBT + ", id = " + c7254cm.ptF);
        C41338bt c41338bt = new C41338bt();
        c41338bt.field_content = C1946aa.m4148a(c7254cm.vED);
        c41338bt.field_createtime = C5046bo.anT();
        c41338bt.field_imgpath = "";
        c41338bt.field_sayhicontent = c5138d.content;
        c41338bt.field_sayhiuser = c5138d.svN;
        c41338bt.field_scene = c5138d.scene;
        c41338bt.field_status = c7254cm.jBT > 3 ? c7254cm.jBT : 3;
        c41338bt.field_svrid = c7254cm.ptF;
        c41338bt.field_talker = C1946aa.m4148a(c7254cm.vEB);
        c41338bt.field_type = c7254cm.nao;
        c41338bt.field_isSend = 0;
        ((C46622bu) ((C6982j) C1720g.m3528K(C6982j.class)).bOn()).mo74759a(c41338bt);
        C41730b.m73489U(c41338bt.field_sayhiuser, 3);
        AppMethodBeat.m2505o(16630);
    }
}
