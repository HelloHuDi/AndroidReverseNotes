package com.tencent.p177mm.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18818b;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C9877al;
import com.tencent.p177mm.plugin.account.p765a.p766a.C45491b;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5042bm;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.platformtools.a */
public final class C45474a {
    public static final HashSet<C45491b> ggH = new HashSet();
    private static final C45491b ggI = new C97831();
    private static Thread thread = null;

    /* renamed from: com.tencent.mm.platformtools.a$1 */
    static class C97831 implements C45491b {
        C97831() {
        }

        /* renamed from: cN */
        public final void mo14963cN(boolean z) {
            AppMethodBeat.m2504i(124504);
            C4990ab.m7417i("MicroMsg.AddrBookSyncHelper", "syncAddrBookAndUpload onSyncEnd suc:%b", Boolean.valueOf(z));
            if (z) {
                System.currentTimeMillis();
                C38033l.apX();
                C1720g.m3540Rg().mo14541a(new C9877al(C38033l.aqb(), C38033l.aqa()), 0);
                AppMethodBeat.m2505o(124504);
                return;
            }
            AppMethodBeat.m2505o(124504);
        }
    }

    /* renamed from: com.tencent.mm.platformtools.a$a */
    static class C26522a implements Runnable {
        private static byte[] eMl = new byte[0];
        public static boolean fAV = false;
        private static final C7306ak ggQ = new C7306ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(124506);
                if (C1720g.m3531RK()) {
                    C1446a c1446a = new C1446a();
                    int size = C45474a.ggH.size();
                    boolean parseBoolean = Boolean.parseBoolean(message.obj.toString());
                    Iterator it = C45474a.ggH.iterator();
                    while (it.hasNext()) {
                        ((C45491b) it.next()).mo14963cN(parseBoolean);
                    }
                    C45474a.ggH.clear();
                    C4990ab.m7417i("MicroMsg.AddrBookSyncHelper", "callBackHandler setSize:%d time:%d", Integer.valueOf(size), Long.valueOf(c1446a.mo4908Mr()));
                    AppMethodBeat.m2505o(124506);
                    return;
                }
                AppMethodBeat.m2505o(124506);
            }
        };
        private List<String[]> ggL;
        private List<String[]> ggM;
        private List<C18817a> ggN;
        private List<C18817a> ggO;
        private C5042bm ggP;

        private C26522a() {
        }

        /* synthetic */ C26522a(byte b) {
            this();
        }

        static {
            AppMethodBeat.m2504i(124511);
            AppMethodBeat.m2505o(124511);
        }

        /* renamed from: c */
        private static List<C18817a> m42345c(List<C18817a> list, int i, int i2) {
            AppMethodBeat.m2504i(124507);
            LinkedList linkedList = new LinkedList();
            while (i < i2) {
                linkedList.add(list.get(i));
                i++;
            }
            AppMethodBeat.m2505o(124507);
            return linkedList;
        }

        public final void run() {
            AppMethodBeat.m2504i(124508);
            synchronized (eMl) {
                try {
                    this.ggP = new C5042bm("MicroMsg.AddrBookSyncHelper", "sync addrBook");
                    this.ggP.addSplit("sync begin");
                    C4990ab.m7410d("MicroMsg.AddrBookSyncHelper", "reading email info");
                    this.ggL = C46482a.m87694fA(C4996ah.getContext());
                    if (this.ggL != null) {
                        C4990ab.m7416i("MicroMsg.AddrBookSyncHelper", "sync address book email size: " + this.ggL.size());
                    }
                    this.ggO = C26522a.m42344c(1, this.ggL);
                    C4990ab.m7410d("MicroMsg.AddrBookSyncHelper", "reading mobile info");
                    this.ggM = C46482a.m87696fz(C4996ah.getContext());
                    if (this.ggM != null) {
                        C4990ab.m7416i("MicroMsg.AddrBookSyncHelper", "sync address book mobile size: " + this.ggM.size());
                    }
                    this.ggN = C26522a.m42344c(0, this.ggM);
                    C4990ab.m7410d("MicroMsg.AddrBookSyncHelper", "reading done, begin sync to addr_upload");
                    if (this.ggL != null && this.ggO.size() > 0) {
                        for (int i = 0; i < this.ggO.size(); i += 100) {
                            List c;
                            C4990ab.m7416i("MicroMsg.AddrBookSyncHelper", "sync email index: ".concat(String.valueOf(i)));
                            if (i + 100 < this.ggO.size()) {
                                c = C26522a.m42345c(this.ggO, i, i + 100);
                            } else {
                                c = this.ggO;
                                c = C26522a.m42345c(c, i, c.size());
                            }
                            C4990ab.m7416i("MicroMsg.AddrBookSyncHelper", "sync email listToSync size: " + c.size());
                            C38033l.m64346as(c);
                        }
                    }
                    Message obtainMessage;
                    if (this.ggN == null || this.ggN.size() == 0) {
                        C4990ab.m7416i("MicroMsg.AddrBookSyncHelper", "mobile list null stop service");
                        obtainMessage = ggQ.obtainMessage();
                        obtainMessage.obj = Boolean.FALSE;
                        ggQ.sendMessage(obtainMessage);
                    } else {
                        int i2 = 0;
                        while (i2 < this.ggN.size()) {
                            C4990ab.m7416i("MicroMsg.AddrBookSyncHelper", "sync mobile index: ".concat(String.valueOf(i2)));
                            if (C1720g.m3531RK()) {
                                List c2;
                                if (i2 + 100 < this.ggN.size()) {
                                    c2 = C26522a.m42345c(this.ggN, i2, i2 + 100);
                                } else {
                                    c2 = this.ggN;
                                    c2 = C26522a.m42345c(c2, i2, c2.size());
                                }
                                C4990ab.m7416i("MicroMsg.AddrBookSyncHelper", "sync mobile listToSync size: " + c2.size());
                                C38033l.m64346as(c2);
                                i2 += 100;
                            } else {
                                C4990ab.m7416i("MicroMsg.AddrBookSyncHelper", "account not ready, stop sync");
                                obtainMessage = ggQ.obtainMessage();
                                obtainMessage.obj = Boolean.FALSE;
                                ggQ.sendMessage(obtainMessage);
                                AppMethodBeat.m2505o(124508);
                                return;
                            }
                        }
                        C4990ab.m7416i("MicroMsg.AddrBookSyncHelper", "sync ok");
                        if (C1720g.m3531RK()) {
                            C26522a.anF();
                            System.currentTimeMillis();
                            C38033l.apX();
                            this.ggP.addSplit("sync ok");
                            this.ggP.dumpToLog();
                            obtainMessage = ggQ.obtainMessage();
                            obtainMessage.obj = Boolean.TRUE;
                            ggQ.sendMessage(obtainMessage);
                            AppMethodBeat.m2505o(124508);
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.AddrBookSyncHelper", "account not ready, exit");
                        obtainMessage = ggQ.obtainMessage();
                        obtainMessage.obj = Boolean.FALSE;
                        ggQ.sendMessage(obtainMessage);
                        AppMethodBeat.m2505o(124508);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(124508);
                }
            }
        }

        private static void anF() {
            AppMethodBeat.m2504i(124509);
            C5042bm c5042bm = new C5042bm("MicroMsg.AddrBookSyncHelper", "delete");
            ArrayList arrayList = new ArrayList();
            List fB = C46482a.m87695fB(C4996ah.getContext());
            for (String[] strArr : ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).apJ()) {
                String nullAsNil = C5046bo.nullAsNil(strArr[0]);
                String nullAsNil2 = C5046bo.nullAsNil(strArr[1]);
                if (!(nullAsNil.equals("") || fB.contains(nullAsNil))) {
                    arrayList.add(nullAsNil2);
                }
            }
            if (arrayList.size() > 0) {
                ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34086ap(arrayList);
                C38033l.m64345ar(arrayList);
            }
            c5042bm.addSplit("end");
            c5042bm.dumpToLog();
            AppMethodBeat.m2505o(124509);
        }

        /* renamed from: c */
        private static List<C18817a> m42344c(int i, List<String[]> list) {
            AppMethodBeat.m2504i(124510);
            if (list == null) {
                C4990ab.m7412e("MicroMsg.AddrBookSyncHelper", "sync address book failed, null info list");
                LinkedList linkedList = new LinkedList();
                AppMethodBeat.m2505o(124510);
                return linkedList;
            }
            ArrayList arrayList = new ArrayList();
            for (String[] strArr : list) {
                if (strArr != null) {
                    String str = strArr[0];
                    String str2 = strArr[1];
                    String str3 = strArr[2];
                    String str4 = strArr[3];
                    long anl = C5046bo.anl(strArr[4]);
                    if (!(str3 == null || str3.equals(""))) {
                        String str5 = "";
                        if (i == 1) {
                            str5 = C1178g.m2591x(str3.getBytes());
                        }
                        if (i == 0) {
                            str5 = C46482a.m87698ws(str3);
                            if (C5046bo.isNullOrNil(str5)) {
                                C4990ab.m7410d("MicroMsg.AddrBookSyncHelper", "formatted mobile null, continue");
                            } else {
                                str5 = C1178g.m2591x(str5.getBytes());
                            }
                        }
                        C18817a c18817a = new C18817a();
                        c18817a.eBb = str2;
                        c18817a.guE = C9790g.m17433vp(str2);
                        c18817a.guF = C9790g.m17432vo(str2);
                        c18817a.guC = str;
                        c18817a.frQ = str4;
                        c18817a.mo34083vS(str5);
                        c18817a.gvf = anl;
                        c18817a.guL = c18817a.mo34069Ny();
                        if (i == 1) {
                            c18817a.dtV = str3;
                        }
                        if (i == 0) {
                            c18817a.guI = str3;
                        }
                        c18817a.type = i;
                        c18817a.bJt = 1095798;
                        arrayList.add(c18817a);
                    }
                }
            }
            AppMethodBeat.m2505o(124510);
            return arrayList;
        }
    }

    static {
        AppMethodBeat.m2504i(124514);
        AppMethodBeat.m2505o(124514);
    }

    public static boolean anC() {
        AppMethodBeat.m2504i(124512);
        boolean syncAddrBook = C45474a.syncAddrBook(ggI);
        AppMethodBeat.m2505o(124512);
        return syncAddrBook;
    }

    public static boolean syncAddrBook(final C45491b c45491b) {
        AppMethodBeat.m2504i(124513);
        final long id = Thread.currentThread().getId();
        if (C38033l.apV()) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(124505);
                    boolean z = C45474a.thread != null && C45474a.thread.isAlive();
                    C4990ab.m7417i("MicroMsg.AddrBookSyncHelper", "syncAddrBook running:%b setSize:%d call:%d callback:%s", Boolean.valueOf(z), Integer.valueOf(C45474a.ggH.size()), Long.valueOf(id), c45491b);
                    C45474a.ggH.add(c45491b);
                    if (z) {
                        AppMethodBeat.m2505o(124505);
                        return;
                    }
                    C45474a.thread = C7305d.m12285a(new C26522a(), "AddrBookSyncHelper_addrBookRead", 1);
                    C38033l.apP();
                    C45474a.thread.start();
                    AppMethodBeat.m2505o(124505);
                }
            });
            AppMethodBeat.m2505o(124513);
            return true;
        }
        C4990ab.m7413e("MicroMsg.AddrBookSyncHelper", "canSync:%b, skip", Boolean.valueOf(C38033l.apV()));
        AppMethodBeat.m2505o(124513);
        return false;
    }

    public static boolean anD() {
        return C26522a.fAV;
    }
}
