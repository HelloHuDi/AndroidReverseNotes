package com.tencent.mm.modelmulti;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public final class q {
    private static ArrayList<cm> fJE = new ArrayList();
    private static ArrayList<ad> fJF = new ArrayList();

    static {
        AppMethodBeat.i(16517);
        AppMethodBeat.o(16517);
    }

    public static void cu(final int i, final int i2) {
        AppMethodBeat.i(16514);
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(16513);
                q.access$000();
                q.sS(e.eSn + "/testaddmsg.txt");
                if (q.fJF.size() <= 0 || q.fJE.size() <= 0) {
                    ab.e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", Integer.valueOf(q.fJE.size()), Integer.valueOf(q.fJF.size()));
                    AppMethodBeat.o(16513);
                    return;
                }
                new ap(aw.RS().oAl.getLooper(), new a() {
                    int fJI = i;

                    {
                        AppMethodBeat.i(16511);
                        AppMethodBeat.o(16511);
                    }

                    public final boolean BI() {
                        AppMethodBeat.i(16512);
                        if (this.fJI <= 0) {
                            AppMethodBeat.o(16512);
                            return false;
                        }
                        this.fJI--;
                        b bVar = new b();
                        bVar.vyH.vTR = new tc();
                        int gV = bo.gV(i2, 1);
                        for (int i = 0; i < gV; i++) {
                            cm cmVar = (cm) q.fJE.get(bo.gV(q.fJE.size() - 1, 0));
                            cmVar.vEB = new bts().alV(((ad) q.fJF.get(bo.gV(q.fJF.size() - 1, 0))).field_username);
                            cmVar.pcX = (int) bo.anT();
                            cmVar.ptF = (long) Math.abs(((int) bo.anU()) % 10000000);
                            try {
                                tb tbVar = new tb();
                                tbVar.wau = new SKBuiltinBuffer_t();
                                tbVar.wau.setBuffer(cmVar.toByteArray());
                                tbVar.wat = 5;
                                bVar.vyH.vTR.jBw.add(tbVar);
                                tc tcVar = bVar.vyH.vTR;
                                tcVar.jBv++;
                                ab.d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", Integer.valueOf(this.fJI), Integer.valueOf(i), Integer.valueOf(gV), Integer.valueOf(bVar.vyH.vTR.jBw.size()), Long.valueOf(cmVar.ptF), cmVar.vEB.wVI);
                            } catch (Exception e) {
                                ab.d("MicroMsg.TestSyncAddMsg", e.getMessage());
                                ab.printErrStackTrace("MicroMsg.TestSyncAddMsg", e, "", new Object[0]);
                            }
                        }
                        bVar.vyH.vQe = 0;
                        bek bek = bVar.vyH;
                        aw.ZK();
                        bek.vTO = aa.ad(bo.anf(bo.nullAsNil((String) c.Ry().get(8195, new byte[0]))));
                        bVar.vyH.Ret = 0;
                        bVar.vyH.jBT = 0;
                        n.ahW().a(bVar, 0, bo.anT());
                        AppMethodBeat.o(16512);
                        return true;
                    }
                }, true).ae(3000, 3000);
                AppMethodBeat.o(16513);
            }
        });
        AppMethodBeat.o(16514);
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(16515);
        aw.ZK();
        Cursor d = c.XM().d(null, null, new ArrayList());
        while (d.moveToNext()) {
            ad adVar = new ad();
            adVar.d(d);
            fJF.add(adVar);
        }
        d.close();
        AppMethodBeat.o(16515);
    }

    static /* synthetic */ void sS(String str) {
        Exception e;
        Throwable th;
        int i = 0;
        AppMethodBeat.i(16516);
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
                            ab.e(str2, str3, objArr);
                        } else {
                            cm cmVar = new cm();
                            cmVar.vEC = new bts().alV(r.Yz());
                            cmVar.jBT = 2;
                            cmVar.vEF = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                            cmVar.nao = bo.getInt(split[0], 0);
                            cmVar.vEE = bo.getInt(split[1], 0);
                            cmVar.vED = new bts().alV(split[2]);
                            fJE.add(cmVar);
                        }
                    } else {
                        try {
                            bufferedReader.close();
                            AppMethodBeat.o(16516);
                            return;
                        } catch (Exception e2) {
                            AppMethodBeat.o(16516);
                            return;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        ab.e("MicroMsg.TestSyncAddMsg", "readMsgFromFile failed e:%s", e.getMessage());
                        ab.printErrStackTrace("MicroMsg.TestSyncAddMsg", e, "", new Object[0]);
                        try {
                            bufferedReader.close();
                            AppMethodBeat.o(16516);
                        } catch (Exception e4) {
                            AppMethodBeat.o(16516);
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            bufferedReader.close();
                        } catch (Exception e5) {
                        }
                        AppMethodBeat.o(16516);
                        throw th;
                    }
                }
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            ab.e("MicroMsg.TestSyncAddMsg", "readMsgFromFile failed e:%s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.TestSyncAddMsg", e, "", new Object[0]);
            bufferedReader.close();
            AppMethodBeat.o(16516);
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            bufferedReader.close();
            AppMethodBeat.o(16516);
            throw th;
        }
    }
}
