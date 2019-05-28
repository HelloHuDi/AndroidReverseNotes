package com.tencent.p177mm.plugin.clean.p1246b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.clean.p362c.C2808i;
import com.tencent.p177mm.plugin.clean.p362c.C33824h;
import com.tencent.p177mm.plugin.p398f.C39004a;
import com.tencent.p177mm.plugin.p398f.C45913b;
import com.tencent.p177mm.plugin.p398f.p1482b.C34092a;
import com.tencent.p177mm.plugin.p398f.p1482b.C39005b;
import com.tencent.p177mm.pointers.PLong;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.clean.b.b */
public final class C45810b implements Runnable {
    private long kvY = 0;
    private List<String> kwc;
    private List<C2808i> kwd;
    private C33824h kwe;

    public C45810b(List<String> list, List<C2808i> list2, C33824h c33824h) {
        this.kwc = list;
        this.kwd = list2;
        this.kwe = c33824h;
    }

    /* renamed from: bm */
    private void m84731bm(List<C34092a> list) {
        AppMethodBeat.m2504i(18660);
        int size = list.size();
        HashSet hashSet = new HashSet();
        C9638aw.m17190ZK();
        long iV = C18628c.m29069Ru().mo15639iV(Thread.currentThread().getId());
        for (int i = 0; i < size; i++) {
            C34092a c34092a = (C34092a) list.get(i);
            long yz = C5046bo.m7588yz();
            if (!hashSet.contains(Long.valueOf(c34092a.field_msgId))) {
                C9638aw.m17190ZK();
                C7620bi jf = C18628c.m29080XO().mo15340jf(c34092a.field_msgId);
                if (!(jf.field_msgId == 0 || jf.dtH())) {
                    C45913b aZc = C45913b.aZc();
                    long j = c34092a.field_msgId;
                    aZc.jZK = true;
                    aZc.jZJ.add(Long.valueOf(j));
                    C4990ab.m7411d("MicroMsg.CalcWxService", "%d lock msg change [%d] [%s]", Integer.valueOf(aZc.hashCode()), Long.valueOf(j), C5046bo.dpG());
                    jf.dtI();
                    C9638aw.m17190ZK();
                    C18628c.m29080XO().mo15284a(c34092a.field_msgId, jf);
                }
                hashSet.add(Long.valueOf(c34092a.field_msgId));
                C4990ab.m7411d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex handle msg[%d]", aZk(), Long.valueOf(C5046bo.m7525az(yz)));
            }
            if (!(c34092a == null || C39004a.m66252sJ(c34092a.field_msgSubType) || c34092a.field_size <= 0)) {
                this.kvY += c34092a.field_size;
                C5730e.deleteFile(C1720g.m3536RP().eJL + c34092a.field_path);
                c34092a.field_path = "";
                c34092a.field_size = 0;
                C45913b.aZc().aZd().mo16758a(c34092a.xDa, (C4925c) c34092a, false);
            }
            C4990ab.m7411d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex[%d]", aZk(), Long.valueOf(C5046bo.m7525az(yz)));
        }
        C9638aw.m17190ZK();
        C18628c.m29069Ru().mo15640mB(iV);
        AppMethodBeat.m2505o(18660);
    }

    public final void run() {
        AppMethodBeat.m2504i(18661);
        int i;
        long j;
        if (this.kwc != null) {
            long yz = C5046bo.m7588yz();
            int size = this.kwc.size();
            i = 0;
            Iterator it = this.kwc.iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                if (!C5046bo.isNullOrNil(str)) {
                    long yz2 = C5046bo.m7588yz();
                    PLong pLong = new PLong();
                    PLong pLong2 = new PLong();
                    C39005b aZd = C45913b.aZc().aZd();
                    long yz3 = C5046bo.m7588yz();
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
                        C4990ab.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", str2);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        AppMethodBeat.m2505o(18661);
                    }
                    C4990ab.m7417i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaMsgTimeByUsername [%s] cost[%d]", str, Long.valueOf(C5046bo.m7525az(yz3)));
                    pLong2.value--;
                    j = pLong.value;
                    yz3 = Math.max(j - 2592000000L, pLong2.value);
                    if (yz3 == j) {
                        yz3--;
                    }
                    List j2 = C45913b.aZc().aZd().mo61898j(str, j, yz3);
                    long size2 = ((long) j2.size()) + 0;
                    m84731bm(j2);
                    while (true) {
                        j = yz3;
                        if (j <= pLong2.value) {
                            break;
                        }
                        yz3 = Math.max(j - 2592000000L, pLong2.value);
                        if (yz3 == j) {
                            yz3--;
                        }
                        j2 = C45913b.aZc().aZd().mo61898j(str, j, yz3);
                        size2 += (long) j2.size();
                        m84731bm(j2);
                    }
                    C4990ab.m7417i("MicroMsg.DeleteFileByWxIndex", "%s deleteByName [%s] [%d] [%d %d] cost[%d]", aZk(), str, Long.valueOf(size2), Long.valueOf(pLong2.value), Long.valueOf(pLong.value), Long.valueOf(C5046bo.m7525az(yz2)));
                }
                i = i2 + 1;
                if (this.kwe != null) {
                    this.kwe.mo23158dP(i, size);
                }
            }
            if (this.kwe != null) {
                this.kwe.mo23159hi(this.kvY);
            }
            C45913b.aZc().aZh();
            C4990ab.m7417i("MicroMsg.DeleteFileByWxIndex", "%s deleteByUsername cost[%d]", aZk(), Long.valueOf(C5046bo.m7525az(yz)));
            AppMethodBeat.m2505o(18661);
        } else if (this.kwd != null) {
            j = C5046bo.m7588yz();
            int size3 = this.kwd.size();
            i = 0;
            Iterator it2 = this.kwd.iterator();
            while (true) {
                int i3 = i;
                if (!it2.hasNext()) {
                    break;
                }
                m84731bm(((C2808i) it2.next()).kwH);
                i = i3 + 1;
                if (this.kwe != null) {
                    this.kwe.mo23158dP(i, size3);
                }
            }
            if (this.kwe != null) {
                this.kwe.mo23159hi(this.kvY);
            }
            C45913b.aZc().aZh();
            C4990ab.m7417i("MicroMsg.DeleteFileByWxIndex", "%s deleteByNewAnalyseItem cost[%d]", aZk(), Long.valueOf(C5046bo.m7525az(j)));
            AppMethodBeat.m2505o(18661);
        } else {
            AppMethodBeat.m2505o(18661);
        }
    }

    private String aZk() {
        AppMethodBeat.m2504i(18662);
        String str = hashCode();
        AppMethodBeat.m2505o(18662);
        return str;
    }
}
