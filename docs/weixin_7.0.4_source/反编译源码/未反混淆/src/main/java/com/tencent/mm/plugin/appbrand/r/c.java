package com.tencent.mm.plugin.appbrand.r;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    private static LinkedList<e> eow = new LinkedList();
    private static HashSet<a> iQR = new HashSet();
    private static boolean iQS = false;
    private static boolean iQT = false;

    public interface a {
        void z(LinkedList<e> linkedList);
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.i(93776);
        done();
        AppMethodBeat.o(93776);
    }

    static {
        AppMethodBeat.i(93777);
        AppMethodBeat.o(93777);
    }

    public static synchronized void reset() {
        synchronized (c.class) {
            AppMethodBeat.i(93772);
            iQS = false;
            iQT = false;
            eow.clear();
            iQR.clear();
            AppMethodBeat.o(93772);
        }
    }

    public static synchronized void a(final String str, a aVar) {
        synchronized (c.class) {
            AppMethodBeat.i(93773);
            if (iQS) {
                iQR.add(aVar);
                AppMethodBeat.o(93773);
            } else if (iQT) {
                aVar.z(eow);
                AppMethodBeat.o(93773);
            } else {
                iQS = true;
                iQR.add(aVar);
                g.RQ();
                g.RS().aa(new Runnable() {
                    public final void run() {
                        u oa;
                        AppMethodBeat.i(93771);
                        c.eow.clear();
                        if (t.kH(str)) {
                            oa = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().oa(str);
                        } else {
                            oa = null;
                        }
                        int i = 0;
                        int i2 = 100;
                        while (true) {
                            int i3 = i;
                            if (i2 >= 100) {
                                Cursor cv = ((j) g.K(j.class)).bOr().cv(str, i3);
                                if (cv != null) {
                                    try {
                                        i2 = cv.getCount();
                                    } catch (Throwable th) {
                                        if (cv != null) {
                                            cv.close();
                                        }
                                        AppMethodBeat.o(93771);
                                    }
                                } else {
                                    i2 = 0;
                                }
                                while (cv != null && cv.moveToNext()) {
                                    cy biVar = new bi();
                                    biVar.setMsgId(cv.getLong(0));
                                    biVar.eI(cv.getLong(1));
                                    biVar.eJ(cv.getLong(2));
                                    biVar.setContent(cv.getString(3));
                                    biVar.hO(cv.getInt(4));
                                    biVar.jv(cv.getString(5));
                                    String str = biVar.field_content;
                                    if (str != null) {
                                        b me = b.me(str);
                                        if (me != null && c.pY(me.type)) {
                                            String a = c.a(biVar, t.kH(str), str);
                                            ad aoO = ((j) g.K(j.class)).XM().aoO(a);
                                            String str2 = "";
                                            if (oa != null) {
                                                str2 = oa.mJ(a);
                                            }
                                            e eVar = new e(biVar.field_createTime, me.type, me.title, biVar.field_msgId, aoO.field_username, aoO.Oi(), aoO.field_conRemark, str2, bo.bc(me.fiQ, me.appId), me, biVar.field_msgSvrId);
                                            eVar.desc = me.title;
                                            WxaAttributes zb = ((d) g.K(d.class)).zb(eVar.cJM.fiP);
                                            eVar.title = zb != null ? zb.field_nickname : eVar.cJM.cMh;
                                            if (zb != null) {
                                                str = zb.field_brandIconURL;
                                            } else {
                                                str = eVar.cJM.fjb;
                                            }
                                            eVar.imagePath = str;
                                            if (me.fiR != 1) {
                                                str = o.ahl().c(biVar.field_imgPath, false, true);
                                                if (!bo.isNullOrNil(str)) {
                                                    eVar.iQW = "file://".concat(String.valueOf(str));
                                                }
                                            }
                                            c.eow.add(eVar);
                                        }
                                    }
                                }
                                if (cv != null) {
                                    cv.close();
                                }
                                i = i3 + i2;
                            } else {
                                ab.i("MicroMsg.AppBrandHistoryListLogic", "[loadData] data:%s", Integer.valueOf(c.eow.size()));
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(93770);
                                        c.access$100();
                                        AppMethodBeat.o(93770);
                                    }
                                });
                                AppMethodBeat.o(93771);
                                return;
                            }
                        }
                    }
                });
                AppMethodBeat.o(93773);
            }
        }
    }

    private static synchronized void done() {
        synchronized (c.class) {
            AppMethodBeat.i(93774);
            ab.i("MicroMsg.AppBrandHistoryListLogic", "done");
            iQT = true;
            iQS = false;
            Iterator it = iQR.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.z(eow);
                }
            }
            iQR.clear();
            AppMethodBeat.o(93774);
        }
    }

    public static boolean pY(int i) {
        return 33 == i || 36 == i;
    }

    protected static String a(bi biVar, boolean z, String str) {
        AppMethodBeat.i(93775);
        if (biVar.field_isSend == 1) {
            str = r.Yz();
            AppMethodBeat.o(93775);
            return str;
        }
        String str2 = null;
        if (z) {
            str2 = bf.oy(biVar.field_content);
        }
        if (!bo.isNullOrNil(str2)) {
            str = str2;
        }
        AppMethodBeat.o(93775);
        return str;
    }
}
