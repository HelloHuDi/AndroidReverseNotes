package com.tencent.p177mm.modelmulti;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.C30256t.C7290b;
import com.tencent.p177mm.protocal.protobuf.C35956tc;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bek;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7616ad;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.modelmulti.q */
public final class C1861q {
    private static ArrayList<C7254cm> fJE = new ArrayList();
    private static ArrayList<C7616ad> fJF = new ArrayList();

    static {
        AppMethodBeat.m2504i(16517);
        AppMethodBeat.m2505o(16517);
    }

    /* renamed from: cu */
    public static void m3975cu(final int i, final int i2) {
        AppMethodBeat.m2504i(16514);
        C9638aw.m17180RS().mo10302aa(new Runnable() {

            /* renamed from: com.tencent.mm.modelmulti.q$1$1 */
            class C18631 implements C5015a {
                int fJI = i;

                C18631() {
                    AppMethodBeat.m2504i(16511);
                    AppMethodBeat.m2505o(16511);
                }

                /* renamed from: BI */
                public final boolean mo4499BI() {
                    AppMethodBeat.m2504i(16512);
                    if (this.fJI <= 0) {
                        AppMethodBeat.m2505o(16512);
                        return false;
                    }
                    this.fJI--;
                    C7290b c7290b = new C7290b();
                    c7290b.vyH.vTR = new C35956tc();
                    int gV = C5046bo.m7560gV(i2, 1);
                    for (int i = 0; i < gV; i++) {
                        C7254cm c7254cm = (C7254cm) C1861q.fJE.get(C5046bo.m7560gV(C1861q.fJE.size() - 1, 0));
                        c7254cm.vEB = new bts().alV(((C7616ad) C1861q.fJF.get(C5046bo.m7560gV(C1861q.fJF.size() - 1, 0))).field_username);
                        c7254cm.pcX = (int) C5046bo.anT();
                        c7254cm.ptF = (long) Math.abs(((int) C5046bo.anU()) % 10000000);
                        try {
                            C40573tb c40573tb = new C40573tb();
                            c40573tb.wau = new SKBuiltinBuffer_t();
                            c40573tb.wau.setBuffer(c7254cm.toByteArray());
                            c40573tb.wat = 5;
                            c7290b.vyH.vTR.jBw.add(c40573tb);
                            C35956tc c35956tc = c7290b.vyH.vTR;
                            c35956tc.jBv++;
                            C4990ab.m7411d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", Integer.valueOf(this.fJI), Integer.valueOf(i), Integer.valueOf(gV), Integer.valueOf(c7290b.vyH.vTR.jBw.size()), Long.valueOf(c7254cm.ptF), c7254cm.vEB.wVI);
                        } catch (Exception e) {
                            C4990ab.m7410d("MicroMsg.TestSyncAddMsg", e.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.TestSyncAddMsg", e, "", new Object[0]);
                        }
                    }
                    c7290b.vyH.vQe = 0;
                    bek bek = c7290b.vyH;
                    C9638aw.m17190ZK();
                    bek.vTO = C1946aa.m4152ad(C5046bo.anf(C5046bo.nullAsNil((String) C18628c.m29072Ry().get(8195, new byte[0]))));
                    c7290b.vyH.Ret = 0;
                    c7290b.vyH.jBT = 0;
                    C18668n.ahW().mo44215a(c7290b, 0, C5046bo.anT());
                    AppMethodBeat.m2505o(16512);
                    return true;
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(16513);
                C1861q.access$000();
                C1861q.m3976sS(C6457e.eSn + "/testaddmsg.txt");
                if (C1861q.fJF.size() <= 0 || C1861q.fJE.size() <= 0) {
                    C4990ab.m7413e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", Integer.valueOf(C1861q.fJE.size()), Integer.valueOf(C1861q.fJF.size()));
                    AppMethodBeat.m2505o(16513);
                    return;
                }
                new C7564ap(C9638aw.m17180RS().oAl.getLooper(), new C18631(), true).mo16770ae(3000, 3000);
                AppMethodBeat.m2505o(16513);
            }
        });
        AppMethodBeat.m2505o(16514);
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.m2504i(16515);
        C9638aw.m17190ZK();
        Cursor d = C18628c.m29078XM().mo15738d(null, null, new ArrayList());
        while (d.moveToNext()) {
            C7616ad c7616ad = new C7616ad();
            c7616ad.mo8995d(d);
            fJF.add(c7616ad);
        }
        d.close();
        AppMethodBeat.m2505o(16515);
    }

    /* renamed from: sS */
    static /* synthetic */ void m3976sS(String str) {
        Exception e;
        Throwable th;
        int i = 0;
        AppMethodBeat.m2504i(16516);
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        i++;
                        String[] split = readLine.split("###");
                        if (split == null || split.length != 3) {
                            int i2;
                            String str2 = "MicroMsg.TestSyncAddMsg";
                            String str3 = "readMsgFromFile parse line %d failed : len:%d ";
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(i);
                            if (split == null) {
                                i2 = -1;
                            } else {
                                i2 = split.length;
                            }
                            objArr[1] = Integer.valueOf(i2);
                            C4990ab.m7413e(str2, str3, objArr);
                        } else {
                            C7254cm c7254cm = new C7254cm();
                            c7254cm.vEC = new bts().alV(C1853r.m3846Yz());
                            c7254cm.jBT = 2;
                            c7254cm.vEF = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                            c7254cm.nao = C5046bo.getInt(split[0], 0);
                            c7254cm.vEE = C5046bo.getInt(split[1], 0);
                            c7254cm.vED = new bts().alV(split[2]);
                            fJE.add(c7254cm);
                        }
                    } else {
                        try {
                            bufferedReader.close();
                            AppMethodBeat.m2505o(16516);
                            return;
                        } catch (Exception e2) {
                            AppMethodBeat.m2505o(16516);
                            return;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        C4990ab.m7413e("MicroMsg.TestSyncAddMsg", "readMsgFromFile failed e:%s", e.getMessage());
                        C4990ab.printErrStackTrace("MicroMsg.TestSyncAddMsg", e, "", new Object[0]);
                        try {
                            bufferedReader.close();
                            AppMethodBeat.m2505o(16516);
                        } catch (Exception e4) {
                            AppMethodBeat.m2505o(16516);
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            bufferedReader.close();
                        } catch (Exception e5) {
                        }
                        AppMethodBeat.m2505o(16516);
                        throw th;
                    }
                }
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            C4990ab.m7413e("MicroMsg.TestSyncAddMsg", "readMsgFromFile failed e:%s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.TestSyncAddMsg", e, "", new Object[0]);
            bufferedReader.close();
            AppMethodBeat.m2505o(16516);
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            bufferedReader.close();
            AppMethodBeat.m2505o(16516);
            throw th;
        }
    }
}
