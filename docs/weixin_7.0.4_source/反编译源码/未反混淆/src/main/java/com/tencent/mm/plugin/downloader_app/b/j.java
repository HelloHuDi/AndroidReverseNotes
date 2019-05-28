package com.tencent.mm.plugin.downloader_app.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.b.d.d;
import com.tencent.mm.plugin.downloader_app.d.a;
import com.tencent.mm.plugin.downloader_app.d.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Iterator;
import java.util.LinkedList;

public final class j {
    private static LinkedList<String> kPf = new LinkedList();
    private static LinkedList<String> kPg = new LinkedList();
    private static d kPh;

    static {
        AppMethodBeat.i(136159);
        AppMethodBeat.o(136159);
    }

    public static void stop() {
        AppMethodBeat.i(136149);
        kPf.clear();
        kPg.clear();
        if (kPh != null) {
            d.b(kPh);
        }
        kPh = null;
        AppMethodBeat.o(136149);
    }

    public static LinkedList<String> biP() {
        AppMethodBeat.i(136150);
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(kPf);
        linkedList.addAll(kPg);
        AppMethodBeat.o(136150);
        return linkedList;
    }

    public static LinkedList<String> biQ() {
        AppMethodBeat.i(136151);
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(kPf);
        AppMethodBeat.o(136151);
        return linkedList;
    }

    public static int IM(String str) {
        AppMethodBeat.i(136152);
        int i;
        if (kPg.contains(str)) {
            i = k.kPi;
            AppMethodBeat.o(136152);
            return i;
        }
        i = k.UN_INSTALLED;
        AppMethodBeat.o(136152);
        return i;
    }

    public static boolean contains(String str) {
        AppMethodBeat.i(136153);
        if (kPg.contains(str) || kPf.contains(str)) {
            AppMethodBeat.o(136153);
            return true;
        }
        AppMethodBeat.o(136153);
        return false;
    }

    public static void Iz(String str) {
        AppMethodBeat.i(136154);
        if (!contains(str)) {
            kPf.addFirst(str);
            if (b.biR() != null) {
                a aVar = new a();
                aVar.field_appId = str;
                aVar.field_modifyTime = System.currentTimeMillis();
                b.biR().b((c) aVar);
            }
        }
        AppMethodBeat.o(136154);
    }

    public static void kP(String str) {
        AppMethodBeat.i(136155);
        kPg.remove(str);
        kPf.remove(str);
        if (b.biR() != null) {
            b.biR().hY("DownloadTaskItem", String.format("delete from %s where %s=\"%s\"", new Object[]{"DownloadTaskItem", "appId", str}));
        }
        AppMethodBeat.o(136155);
    }

    public static boolean bix() {
        AppMethodBeat.i(136156);
        if (kPf.size() > 0) {
            AppMethodBeat.o(136156);
            return true;
        }
        AppMethodBeat.o(136156);
        return false;
    }

    public static void biO() {
        LinkedList linkedList = null;
        AppMethodBeat.i(136148);
        if (b.biR() != null) {
            Cursor rawQuery = b.biR().rawQuery(String.format("select * from %s order by %s desc", new Object[]{"DownloadTaskItem", "modifyTime"}), new String[0]);
            if (rawQuery != null) {
                linkedList = new LinkedList();
                while (rawQuery.moveToNext()) {
                    a aVar = new a();
                    aVar.d(rawQuery);
                    linkedList.add(aVar);
                }
                rawQuery.close();
            }
        }
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                ab.d("MicroMsg.TaskManager", "initFromDB, appId:%s, status:%d", aVar2.field_appId, Integer.valueOf(aVar2.field_status));
                if (aVar2.field_status == k.kPi) {
                    if (!kPg.contains(aVar2.field_appId)) {
                        kPg.add(aVar2.field_appId);
                    }
                } else if (!kPf.contains(aVar2.field_appId)) {
                    kPf.add(aVar2.field_appId);
                }
            }
        }
        if (kPh == null) {
            kPh = new d() {
                public final void E(int i, long j) {
                    AppMethodBeat.i(136147);
                    com.tencent.mm.plugin.downloader.f.a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
                    if (hv == null) {
                        AppMethodBeat.o(136147);
                        return;
                    }
                    ab.i("MicroMsg.TaskManager", "onDownloadStatusChange, event = %d, appId = %s", Integer.valueOf(i), hv.field_appId);
                    if (!j.contains(hv.field_appId)) {
                        AppMethodBeat.o(136147);
                    } else if (i == 9) {
                        j.jJ(hv.field_appId);
                        AppMethodBeat.o(136147);
                    } else {
                        if (i == 1 || i == 7) {
                            f bT = g.bT(hv.field_appId, true);
                            if (bT == null || !p.u(ah.getContext(), bT.field_packageName)) {
                                j.sS(hv.field_appId);
                            } else {
                                ab.i("MicroMsg.TaskManager", "onDownloadStatusChange, hasInstall");
                                AppMethodBeat.o(136147);
                                return;
                            }
                        }
                        AppMethodBeat.o(136147);
                    }
                }
            };
        }
        d.a(kPh);
        AppMethodBeat.o(136148);
    }

    static /* synthetic */ void jJ(String str) {
        AppMethodBeat.i(136157);
        if (!kPg.contains(str)) {
            kPf.remove(str);
            kPg.addFirst(str);
            b.bU(str, k.kPi);
        }
        AppMethodBeat.o(136157);
    }

    static /* synthetic */ void sS(String str) {
        AppMethodBeat.i(136158);
        if (!kPf.contains(str)) {
            kPg.remove(str);
            kPf.addFirst(str);
            b.bU(str, k.UN_INSTALLED);
        }
        AppMethodBeat.o(136158);
    }
}
