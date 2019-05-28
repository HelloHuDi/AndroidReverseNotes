package com.tencent.p177mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.protocal.protobuf.axc;
import com.tencent.p177mm.protocal.protobuf.cbd;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.cache.VideoMemoryManager;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.sns.storage.q */
public final class C13477q extends C7563j<C46237p> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C46237p.ccO, "SnsReportKv")};
    public C7480h fni;

    static {
        AppMethodBeat.m2504i(37975);
        AppMethodBeat.m2505o(37975);
    }

    public C13477q(C7480h c7480h) {
        super(c7480h, C46237p.ccO, "SnsReportKv", C46237p.diI);
        this.fni = c7480h;
    }

    /* renamed from: a */
    public final int mo25628a(cbd cbd) {
        AppMethodBeat.m2504i(37972);
        cbd cbd2 = new cbd();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < cbd.vDW.size(); i3++) {
            axc axc = (axc) cbd.vDW.get(i3);
            if (axc.wBe.f1226wR.length + i2 > VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB) {
                m21629a(cbd2, i2);
                i++;
                cbd2.vDW.clear();
                i2 = 0;
            } else {
                i2 += axc.wBe.f1226wR.length;
                cbd2.vDW.add(axc);
            }
        }
        if (cbd2.vDW.size() > 0) {
            i++;
            m21629a(cbd2, i2);
        }
        AppMethodBeat.m2505o(37972);
        return i;
    }

    /* renamed from: a */
    private int m21629a(cbd cbd, int i) {
        AppMethodBeat.m2504i(37973);
        try {
            byte[] toByteArray = cbd.toByteArray();
            C46237p c46237p = new C46237p();
            c46237p.field_value = toByteArray;
            c46237p.field_logtime = System.currentTimeMillis();
            c46237p.field_logsize = i;
            c46237p.field_offset = 0;
            int insert = (int) this.fni.insert("SnsReportKv", "", c46237p.mo10098Hl());
            C4990ab.m7410d("MicroMsg.SnsKvReportStg", "SnsKvReport Insert result ".concat(String.valueOf(insert)));
            AppMethodBeat.m2505o(37973);
            return insert;
        } catch (Exception e) {
            AppMethodBeat.m2505o(37973);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0115 A:{SYNTHETIC, EDGE_INSN: B:44:0x0115->B:24:0x0115 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x013c A:{LOOP_END, LOOP:2: B:26:0x0136->B:28:0x013c} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0115 A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: fr */
    public final cbd mo25629fr(int i, int i2) {
        Throwable e;
        AppMethodBeat.m2504i(37974);
        String str = "select rowid, *  from SnsReportKv";
        StringBuffer stringBuffer = new StringBuffer();
        if (i2 > 0) {
            str = str + " where rowid <= " + i2;
        }
        Cursor a = this.fni.mo10104a(str, null, 0);
        cbd cbd = new cbd();
        ArrayList<Integer> arrayList = new ArrayList();
        stringBuffer.append("target size " + i + " current maxcolid " + i2);
        if (a.moveToFirst()) {
            int i3 = 0;
            do {
                C46237p c46237p = new C46237p();
                c46237p.mo8995d(a);
                int i4 = c46237p.field_offset;
                stringBuffer.append("|offset: ".concat(String.valueOf(i4)));
                cbd cbd2 = new cbd();
                try {
                    cbd2.parseFrom(c46237p.field_value);
                    int i5 = i3;
                    while (i4 < cbd2.vDW.size()) {
                        try {
                            axc axc = (axc) cbd2.vDW.get(i4);
                            if (axc.wBe.f1226wR.length + i5 > i) {
                                if (i5 == 0) {
                                    arrayList.add(Integer.valueOf(c46237p.reX));
                                    C4990ab.m7416i("MicroMsg.SnsKvReportStg", "error by server for the mini size " + i + " vlauesize " + axc.wBe.f1226wR.length);
                                }
                                i3 = 1;
                                stringBuffer.append("|read end on " + c46237p.reX + " and get size " + i5);
                                if (i3 != 0 || c46237p.field_offset > cbd2.vDW.size()) {
                                    stringBuffer.append("|read full ");
                                    arrayList.add(Integer.valueOf(c46237p.reX));
                                } else {
                                    mo16757a((long) c46237p.reX, (C4925c) c46237p);
                                    stringBuffer.append("|update new offset " + c46237p.field_offset);
                                }
                                if (i3 == 0) {
                                    break;
                                }
                                i3 = i5;
                            } else {
                                c46237p.field_offset = i4 + 1;
                                cbd.vDW.add(axc);
                                i5 += axc.wBe.f1226wR.length;
                                i4++;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            i3 = i5;
                            C4990ab.printErrStackTrace("MicroMsg.SnsKvReportStg", e, "", new Object[0]);
                            arrayList.add(Integer.valueOf(c46237p.reX));
                            C4990ab.m7416i("MicroMsg.SnsKvReportStg", "error paser then delete " + c46237p.reX);
                            if (!a.moveToNext()) {
                                C4990ab.m7416i("MicroMsg.SnsKvReportStg", "read info " + stringBuffer.toString());
                                a.close();
                                for (Integer intValue : arrayList) {
                                }
                                AppMethodBeat.m2505o(37974);
                                return cbd;
                            }
                        }
                    }
                    i3 = 0;
                    stringBuffer.append("|read end on " + c46237p.reX + " and get size " + i5);
                    if (i3 != 0) {
                    }
                    stringBuffer.append("|read full ");
                    arrayList.add(Integer.valueOf(c46237p.reX));
                    if (i3 == 0) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    C4990ab.printErrStackTrace("MicroMsg.SnsKvReportStg", e, "", new Object[0]);
                    arrayList.add(Integer.valueOf(c46237p.reX));
                    C4990ab.m7416i("MicroMsg.SnsKvReportStg", "error paser then delete " + c46237p.reX);
                    if (a.moveToNext()) {
                    }
                }
            } while (a.moveToNext());
            C4990ab.m7416i("MicroMsg.SnsKvReportStg", "read info " + stringBuffer.toString());
        }
        a.close();
        while (r1.hasNext()) {
            delete((long) intValue.intValue());
        }
        AppMethodBeat.m2505o(37974);
        return cbd;
    }
}
