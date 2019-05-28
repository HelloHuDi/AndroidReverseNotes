package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.cache.VideoMemoryManager;
import java.util.ArrayList;

public final class q extends j<p> {
    public static final String[] fnj = new String[]{j.a(p.ccO, "SnsReportKv")};
    public h fni;

    static {
        AppMethodBeat.i(37975);
        AppMethodBeat.o(37975);
    }

    public q(h hVar) {
        super(hVar, p.ccO, "SnsReportKv", p.diI);
        this.fni = hVar;
    }

    public final int a(cbd cbd) {
        AppMethodBeat.i(37972);
        cbd cbd2 = new cbd();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < cbd.vDW.size(); i3++) {
            axc axc = (axc) cbd.vDW.get(i3);
            if (axc.wBe.wR.length + i2 > VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB) {
                a(cbd2, i2);
                i++;
                cbd2.vDW.clear();
                i2 = 0;
            } else {
                i2 += axc.wBe.wR.length;
                cbd2.vDW.add(axc);
            }
        }
        if (cbd2.vDW.size() > 0) {
            i++;
            a(cbd2, i2);
        }
        AppMethodBeat.o(37972);
        return i;
    }

    private int a(cbd cbd, int i) {
        AppMethodBeat.i(37973);
        try {
            byte[] toByteArray = cbd.toByteArray();
            p pVar = new p();
            pVar.field_value = toByteArray;
            pVar.field_logtime = System.currentTimeMillis();
            pVar.field_logsize = i;
            pVar.field_offset = 0;
            int insert = (int) this.fni.insert("SnsReportKv", "", pVar.Hl());
            ab.d("MicroMsg.SnsKvReportStg", "SnsKvReport Insert result ".concat(String.valueOf(insert)));
            AppMethodBeat.o(37973);
            return insert;
        } catch (Exception e) {
            AppMethodBeat.o(37973);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0115 A:{SYNTHETIC, EDGE_INSN: B:44:0x0115->B:24:0x0115 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x013c A:{LOOP_END, LOOP:2: B:26:0x0136->B:28:0x013c} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0115 A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final cbd fr(int i, int i2) {
        Throwable e;
        AppMethodBeat.i(37974);
        String str = "select rowid, *  from SnsReportKv";
        StringBuffer stringBuffer = new StringBuffer();
        if (i2 > 0) {
            str = str + " where rowid <= " + i2;
        }
        Cursor a = this.fni.a(str, null, 0);
        cbd cbd = new cbd();
        ArrayList<Integer> arrayList = new ArrayList();
        stringBuffer.append("target size " + i + " current maxcolid " + i2);
        if (a.moveToFirst()) {
            int i3 = 0;
            do {
                p pVar = new p();
                pVar.d(a);
                int i4 = pVar.field_offset;
                stringBuffer.append("|offset: ".concat(String.valueOf(i4)));
                cbd cbd2 = new cbd();
                try {
                    cbd2.parseFrom(pVar.field_value);
                    int i5 = i3;
                    while (i4 < cbd2.vDW.size()) {
                        try {
                            axc axc = (axc) cbd2.vDW.get(i4);
                            if (axc.wBe.wR.length + i5 > i) {
                                if (i5 == 0) {
                                    arrayList.add(Integer.valueOf(pVar.reX));
                                    ab.i("MicroMsg.SnsKvReportStg", "error by server for the mini size " + i + " vlauesize " + axc.wBe.wR.length);
                                }
                                i3 = 1;
                                stringBuffer.append("|read end on " + pVar.reX + " and get size " + i5);
                                if (i3 != 0 || pVar.field_offset > cbd2.vDW.size()) {
                                    stringBuffer.append("|read full ");
                                    arrayList.add(Integer.valueOf(pVar.reX));
                                } else {
                                    a((long) pVar.reX, (c) pVar);
                                    stringBuffer.append("|update new offset " + pVar.field_offset);
                                }
                                if (i3 == 0) {
                                    break;
                                }
                                i3 = i5;
                            } else {
                                pVar.field_offset = i4 + 1;
                                cbd.vDW.add(axc);
                                i5 += axc.wBe.wR.length;
                                i4++;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            i3 = i5;
                            ab.printErrStackTrace("MicroMsg.SnsKvReportStg", e, "", new Object[0]);
                            arrayList.add(Integer.valueOf(pVar.reX));
                            ab.i("MicroMsg.SnsKvReportStg", "error paser then delete " + pVar.reX);
                            if (!a.moveToNext()) {
                                ab.i("MicroMsg.SnsKvReportStg", "read info " + stringBuffer.toString());
                                a.close();
                                for (Integer intValue : arrayList) {
                                }
                                AppMethodBeat.o(37974);
                                return cbd;
                            }
                        }
                    }
                    i3 = 0;
                    stringBuffer.append("|read end on " + pVar.reX + " and get size " + i5);
                    if (i3 != 0) {
                    }
                    stringBuffer.append("|read full ");
                    arrayList.add(Integer.valueOf(pVar.reX));
                    if (i3 == 0) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    ab.printErrStackTrace("MicroMsg.SnsKvReportStg", e, "", new Object[0]);
                    arrayList.add(Integer.valueOf(pVar.reX));
                    ab.i("MicroMsg.SnsKvReportStg", "error paser then delete " + pVar.reX);
                    if (a.moveToNext()) {
                    }
                }
            } while (a.moveToNext());
            ab.i("MicroMsg.SnsKvReportStg", "read info " + stringBuffer.toString());
        }
        a.close();
        while (r1.hasNext()) {
            delete((long) intValue.intValue());
        }
        AppMethodBeat.o(37974);
        return cbd;
    }
}
