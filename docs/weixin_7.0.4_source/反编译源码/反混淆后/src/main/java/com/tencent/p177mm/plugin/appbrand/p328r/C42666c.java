package com.tencent.p177mm.plugin.appbrand.p328r;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p711c.C6575cy;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.r.c */
public final class C42666c {
    private static LinkedList<C38494e> eow = new LinkedList();
    private static HashSet<C38493a> iQR = new HashSet();
    private static boolean iQS = false;
    private static boolean iQT = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.r.c$a */
    public interface C38493a {
        /* renamed from: z */
        void mo22471z(LinkedList<C38494e> linkedList);
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.m2504i(93776);
        C42666c.done();
        AppMethodBeat.m2505o(93776);
    }

    static {
        AppMethodBeat.m2504i(93777);
        AppMethodBeat.m2505o(93777);
    }

    public static synchronized void reset() {
        synchronized (C42666c.class) {
            AppMethodBeat.m2504i(93772);
            iQS = false;
            iQT = false;
            eow.clear();
            iQR.clear();
            AppMethodBeat.m2505o(93772);
        }
    }

    /* renamed from: a */
    public static synchronized void m75549a(final String str, C38493a c38493a) {
        synchronized (C42666c.class) {
            AppMethodBeat.m2504i(93773);
            if (iQS) {
                iQR.add(c38493a);
                AppMethodBeat.m2505o(93773);
            } else if (iQT) {
                c38493a.mo22471z(eow);
                AppMethodBeat.m2505o(93773);
            } else {
                iQS = true;
                iQR.add(c38493a);
                C1720g.m3537RQ();
                C1720g.m3539RS().mo10302aa(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.appbrand.r.c$1$1 */
                    class C24391 implements Runnable {
                        C24391() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(93770);
                            C42666c.access$100();
                            AppMethodBeat.m2505o(93770);
                        }
                    }

                    public final void run() {
                        C7577u oa;
                        AppMethodBeat.m2504i(93771);
                        C42666c.eow.clear();
                        if (C1855t.m3896kH(str)) {
                            oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(str);
                        } else {
                            oa = null;
                        }
                        int i = 0;
                        int i2 = 100;
                        while (true) {
                            int i3 = i;
                            if (i2 >= 100) {
                                Cursor cv = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15323cv(str, i3);
                                if (cv != null) {
                                    try {
                                        i2 = cv.getCount();
                                    } catch (Throwable th) {
                                        if (cv != null) {
                                            cv.close();
                                        }
                                        AppMethodBeat.m2505o(93771);
                                    }
                                } else {
                                    i2 = 0;
                                }
                                while (cv != null && cv.moveToNext()) {
                                    C6575cy c7620bi = new C7620bi();
                                    c7620bi.setMsgId(cv.getLong(0));
                                    c7620bi.mo14774eI(cv.getLong(1));
                                    c7620bi.mo14775eJ(cv.getLong(2));
                                    c7620bi.setContent(cv.getString(3));
                                    c7620bi.mo14781hO(cv.getInt(4));
                                    c7620bi.mo14795jv(cv.getString(5));
                                    String str = c7620bi.field_content;
                                    if (str != null) {
                                        C8910b me = C8910b.m16064me(str);
                                        if (me != null && C42666c.m75550pY(me.type)) {
                                            String a = C42666c.m75548a(c7620bi, C1855t.m3896kH(str), str);
                                            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(a);
                                            String str2 = "";
                                            if (oa != null) {
                                                str2 = oa.mo16807mJ(a);
                                            }
                                            C38494e c38494e = new C38494e(c7620bi.field_createTime, me.type, me.title, c7620bi.field_msgId, aoO.field_username, aoO.mo16706Oi(), aoO.field_conRemark, str2, C5046bo.m7532bc(me.fiQ, me.appId), me, c7620bi.field_msgSvrId);
                                            c38494e.desc = me.title;
                                            WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(c38494e.cJM.fiP);
                                            c38494e.title = zb != null ? zb.field_nickname : c38494e.cJM.cMh;
                                            if (zb != null) {
                                                str = zb.field_brandIconURL;
                                            } else {
                                                str = c38494e.cJM.fjb;
                                            }
                                            c38494e.imagePath = str;
                                            if (me.fiR != 1) {
                                                str = C32291o.ahl().mo73108c(c7620bi.field_imgPath, false, true);
                                                if (!C5046bo.isNullOrNil(str)) {
                                                    c38494e.iQW = "file://".concat(String.valueOf(str));
                                                }
                                            }
                                            C42666c.eow.add(c38494e);
                                        }
                                    }
                                }
                                if (cv != null) {
                                    cv.close();
                                }
                                i = i3 + i2;
                            } else {
                                C4990ab.m7417i("MicroMsg.AppBrandHistoryListLogic", "[loadData] data:%s", Integer.valueOf(C42666c.eow.size()));
                                C5004al.m7441d(new C24391());
                                AppMethodBeat.m2505o(93771);
                                return;
                            }
                        }
                    }
                });
                AppMethodBeat.m2505o(93773);
            }
        }
    }

    private static synchronized void done() {
        synchronized (C42666c.class) {
            AppMethodBeat.m2504i(93774);
            C4990ab.m7416i("MicroMsg.AppBrandHistoryListLogic", "done");
            iQT = true;
            iQS = false;
            Iterator it = iQR.iterator();
            while (it.hasNext()) {
                C38493a c38493a = (C38493a) it.next();
                if (c38493a != null) {
                    c38493a.mo22471z(eow);
                }
            }
            iQR.clear();
            AppMethodBeat.m2505o(93774);
        }
    }

    /* renamed from: pY */
    public static boolean m75550pY(int i) {
        return 33 == i || 36 == i;
    }

    /* renamed from: a */
    protected static String m75548a(C7620bi c7620bi, boolean z, String str) {
        AppMethodBeat.m2504i(93775);
        if (c7620bi.field_isSend == 1) {
            str = C1853r.m3846Yz();
            AppMethodBeat.m2505o(93775);
            return str;
        }
        String str2 = null;
        if (z) {
            str2 = C1829bf.m3762oy(c7620bi.field_content);
        }
        if (!C5046bo.isNullOrNil(str2)) {
            str = str2;
        }
        AppMethodBeat.m2505o(93775);
        return str;
    }
}
