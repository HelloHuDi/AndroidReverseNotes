package com.tencent.mm.plugin.clean.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.plugin.f.b.a;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b implements Runnable {
    private long kvY = 0;
    private List<String> kwc;
    private List<i> kwd;
    private h kwe;

    public b(List<String> list, List<i> list2, h hVar) {
        this.kwc = list;
        this.kwd = list2;
        this.kwe = hVar;
    }

    private void bm(List<a> list) {
        AppMethodBeat.i(18660);
        int size = list.size();
        HashSet hashSet = new HashSet();
        aw.ZK();
        long iV = c.Ru().iV(Thread.currentThread().getId());
        for (int i = 0; i < size; i++) {
            a aVar = (a) list.get(i);
            long yz = bo.yz();
            if (!hashSet.contains(Long.valueOf(aVar.field_msgId))) {
                aw.ZK();
                bi jf = c.XO().jf(aVar.field_msgId);
                if (!(jf.field_msgId == 0 || jf.dtH())) {
                    com.tencent.mm.plugin.f.b aZc = com.tencent.mm.plugin.f.b.aZc();
                    long j = aVar.field_msgId;
                    aZc.jZK = true;
                    aZc.jZJ.add(Long.valueOf(j));
                    ab.d("MicroMsg.CalcWxService", "%d lock msg change [%d] [%s]", Integer.valueOf(aZc.hashCode()), Long.valueOf(j), bo.dpG());
                    jf.dtI();
                    aw.ZK();
                    c.XO().a(aVar.field_msgId, jf);
                }
                hashSet.add(Long.valueOf(aVar.field_msgId));
                ab.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex handle msg[%d]", aZk(), Long.valueOf(bo.az(yz)));
            }
            if (!(aVar == null || com.tencent.mm.plugin.f.a.sJ(aVar.field_msgSubType) || aVar.field_size <= 0)) {
                this.kvY += aVar.field_size;
                e.deleteFile(g.RP().eJL + aVar.field_path);
                aVar.field_path = "";
                aVar.field_size = 0;
                com.tencent.mm.plugin.f.b.aZc().aZd().a(aVar.xDa, (com.tencent.mm.sdk.e.c) aVar, false);
            }
            ab.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex[%d]", aZk(), Long.valueOf(bo.az(yz)));
        }
        aw.ZK();
        c.Ru().mB(iV);
        AppMethodBeat.o(18660);
    }

    public final void run() {
        AppMethodBeat.i(18661);
        int i;
        long j;
        if (this.kwc != null) {
            long yz = bo.yz();
            int size = this.kwc.size();
            i = 0;
            Iterator it = this.kwc.iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                if (!bo.isNullOrNil(str)) {
                    long yz2 = bo.yz();
                    PLong pLong = new PLong();
                    PLong pLong2 = new PLong();
                    com.tencent.mm.plugin.f.b.b aZd = com.tencent.mm.plugin.f.b.aZc().aZd();
                    long yz3 = bo.yz();
                    String str2 = "select max(msgtime), min(msgtime) from WxFileIndex2 where username='" + str + "' and msgSubType in (1,20,23,30,32,34 ) and size > 0 ";
                    Cursor cursor = null;
                    try {
                        cursor = aZd.bSd.rawQuery(str2, null);
                        if (cursor != null && cursor.moveToFirst()) {
                            pLong.value = cursor.getLong(0);
                            pLong2.value = cursor.getLong(1);
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", str2);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        AppMethodBeat.o(18661);
                    }
                    ab.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaMsgTimeByUsername [%s] cost[%d]", str, Long.valueOf(bo.az(yz3)));
                    pLong2.value--;
                    j = pLong.value;
                    yz3 = Math.max(j - 2592000000L, pLong2.value);
                    if (yz3 == j) {
                        yz3--;
                    }
                    List j2 = com.tencent.mm.plugin.f.b.aZc().aZd().j(str, j, yz3);
                    long size2 = ((long) j2.size()) + 0;
                    bm(j2);
                    while (true) {
                        j = yz3;
                        if (j <= pLong2.value) {
                            break;
                        }
                        yz3 = Math.max(j - 2592000000L, pLong2.value);
                        if (yz3 == j) {
                            yz3--;
                        }
                        j2 = com.tencent.mm.plugin.f.b.aZc().aZd().j(str, j, yz3);
                        size2 += (long) j2.size();
                        bm(j2);
                    }
                    ab.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByName [%s] [%d] [%d %d] cost[%d]", aZk(), str, Long.valueOf(size2), Long.valueOf(pLong2.value), Long.valueOf(pLong.value), Long.valueOf(bo.az(yz2)));
                }
                i = i2 + 1;
                if (this.kwe != null) {
                    this.kwe.dP(i, size);
                }
            }
            if (this.kwe != null) {
                this.kwe.hi(this.kvY);
            }
            com.tencent.mm.plugin.f.b.aZc().aZh();
            ab.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByUsername cost[%d]", aZk(), Long.valueOf(bo.az(yz)));
            AppMethodBeat.o(18661);
        } else if (this.kwd != null) {
            j = bo.yz();
            int size3 = this.kwd.size();
            i = 0;
            Iterator it2 = this.kwd.iterator();
            while (true) {
                int i3 = i;
                if (!it2.hasNext()) {
                    break;
                }
                bm(((i) it2.next()).kwH);
                i = i3 + 1;
                if (this.kwe != null) {
                    this.kwe.dP(i, size3);
                }
            }
            if (this.kwe != null) {
                this.kwe.hi(this.kvY);
            }
            com.tencent.mm.plugin.f.b.aZc().aZh();
            ab.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByNewAnalyseItem cost[%d]", aZk(), Long.valueOf(bo.az(j)));
            AppMethodBeat.o(18661);
        } else {
            AppMethodBeat.o(18661);
        }
    }

    private String aZk() {
        AppMethodBeat.i(18662);
        String str = hashCode();
        AppMethodBeat.o(18662);
        return str;
    }
}
