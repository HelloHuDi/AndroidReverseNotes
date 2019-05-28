package com.tencent.p177mm.plugin.downloader_app.p377b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader_app.p377b.C42918d.C11519d;
import com.tencent.p177mm.plugin.downloader_app.p944d.C11520b;
import com.tencent.p177mm.plugin.downloader_app.p944d.C27718a;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.downloader_app.b.j */
public final class C45837j {
    private static LinkedList<String> kPf = new LinkedList();
    private static LinkedList<String> kPg = new LinkedList();
    private static C11519d kPh;

    /* renamed from: com.tencent.mm.plugin.downloader_app.b.j$1 */
    static class C339351 implements C11519d {
        C339351() {
        }

        /* renamed from: E */
        public final void mo7097E(int i, long j) {
            AppMethodBeat.m2504i(136147);
            C42911a hv = C2895c.m5147hv(j);
            if (hv == null) {
                AppMethodBeat.m2505o(136147);
                return;
            }
            C4990ab.m7417i("MicroMsg.TaskManager", "onDownloadStatusChange, event = %d, appId = %s", Integer.valueOf(i), hv.field_appId);
            if (!C45837j.contains(hv.field_appId)) {
                AppMethodBeat.m2505o(136147);
            } else if (i == 9) {
                C45837j.m84847jJ(hv.field_appId);
                AppMethodBeat.m2505o(136147);
            } else {
                if (i == 1 || i == 7) {
                    C40439f bT = C46494g.m87739bT(hv.field_appId, true);
                    if (bT == null || !C35799p.m58695u(C4996ah.getContext(), bT.field_packageName)) {
                        C45837j.m84849sS(hv.field_appId);
                    } else {
                        C4990ab.m7416i("MicroMsg.TaskManager", "onDownloadStatusChange, hasInstall");
                        AppMethodBeat.m2505o(136147);
                        return;
                    }
                }
                AppMethodBeat.m2505o(136147);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(136159);
        AppMethodBeat.m2505o(136159);
    }

    public static void stop() {
        AppMethodBeat.m2504i(136149);
        kPf.clear();
        kPg.clear();
        if (kPh != null) {
            C42918d.m76209b(kPh);
        }
        kPh = null;
        AppMethodBeat.m2505o(136149);
    }

    public static LinkedList<String> biP() {
        AppMethodBeat.m2504i(136150);
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(kPf);
        linkedList.addAll(kPg);
        AppMethodBeat.m2505o(136150);
        return linkedList;
    }

    public static LinkedList<String> biQ() {
        AppMethodBeat.m2504i(136151);
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(kPf);
        AppMethodBeat.m2505o(136151);
        return linkedList;
    }

    /* renamed from: IM */
    public static int m84845IM(String str) {
        AppMethodBeat.m2504i(136152);
        int i;
        if (kPg.contains(str)) {
            i = C38862k.kPi;
            AppMethodBeat.m2505o(136152);
            return i;
        }
        i = C38862k.UN_INSTALLED;
        AppMethodBeat.m2505o(136152);
        return i;
    }

    public static boolean contains(String str) {
        AppMethodBeat.m2504i(136153);
        if (kPg.contains(str) || kPf.contains(str)) {
            AppMethodBeat.m2505o(136153);
            return true;
        }
        AppMethodBeat.m2505o(136153);
        return false;
    }

    /* renamed from: Iz */
    public static void m84846Iz(String str) {
        AppMethodBeat.m2504i(136154);
        if (!C45837j.contains(str)) {
            kPf.addFirst(str);
            if (C11520b.biR() != null) {
                C27718a c27718a = new C27718a();
                c27718a.field_appId = str;
                c27718a.field_modifyTime = System.currentTimeMillis();
                C11520b.biR().mo10101b((C4925c) c27718a);
            }
        }
        AppMethodBeat.m2505o(136154);
    }

    /* renamed from: kP */
    public static void m84848kP(String str) {
        AppMethodBeat.m2504i(136155);
        kPg.remove(str);
        kPf.remove(str);
        if (C11520b.biR() != null) {
            C11520b.biR().mo16768hY("DownloadTaskItem", String.format("delete from %s where %s=\"%s\"", new Object[]{"DownloadTaskItem", "appId", str}));
        }
        AppMethodBeat.m2505o(136155);
    }

    public static boolean bix() {
        AppMethodBeat.m2504i(136156);
        if (kPf.size() > 0) {
            AppMethodBeat.m2505o(136156);
            return true;
        }
        AppMethodBeat.m2505o(136156);
        return false;
    }

    public static void biO() {
        LinkedList linkedList = null;
        AppMethodBeat.m2504i(136148);
        if (C11520b.biR() != null) {
            Cursor rawQuery = C11520b.biR().rawQuery(String.format("select * from %s order by %s desc", new Object[]{"DownloadTaskItem", "modifyTime"}), new String[0]);
            if (rawQuery != null) {
                linkedList = new LinkedList();
                while (rawQuery.moveToNext()) {
                    C27718a c27718a = new C27718a();
                    c27718a.mo8995d(rawQuery);
                    linkedList.add(c27718a);
                }
                rawQuery.close();
            }
        }
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                C27718a c27718a2 = (C27718a) it.next();
                C4990ab.m7411d("MicroMsg.TaskManager", "initFromDB, appId:%s, status:%d", c27718a2.field_appId, Integer.valueOf(c27718a2.field_status));
                if (c27718a2.field_status == C38862k.kPi) {
                    if (!kPg.contains(c27718a2.field_appId)) {
                        kPg.add(c27718a2.field_appId);
                    }
                } else if (!kPf.contains(c27718a2.field_appId)) {
                    kPf.add(c27718a2.field_appId);
                }
            }
        }
        if (kPh == null) {
            kPh = new C339351();
        }
        C42918d.m76202a(kPh);
        AppMethodBeat.m2505o(136148);
    }

    /* renamed from: jJ */
    static /* synthetic */ void m84847jJ(String str) {
        AppMethodBeat.m2504i(136157);
        if (!kPg.contains(str)) {
            kPf.remove(str);
            kPg.addFirst(str);
            C11520b.m19331bU(str, C38862k.kPi);
        }
        AppMethodBeat.m2505o(136157);
    }

    /* renamed from: sS */
    static /* synthetic */ void m84849sS(String str) {
        AppMethodBeat.m2504i(136158);
        if (!kPf.contains(str)) {
            kPg.remove(str);
            kPf.addFirst(str);
            C11520b.m19331bU(str, C38862k.UN_INSTALLED);
        }
        AppMethodBeat.m2505o(136158);
    }
}
