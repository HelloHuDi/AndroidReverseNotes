package com.tencent.mm.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bm;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public static final HashSet<b> ggH = new HashSet();
    private static final b ggI = new b() {
        public final void cN(boolean z) {
            AppMethodBeat.i(124504);
            ab.i("MicroMsg.AddrBookSyncHelper", "syncAddrBookAndUpload onSyncEnd suc:%b", Boolean.valueOf(z));
            if (z) {
                System.currentTimeMillis();
                l.apX();
                g.Rg().a(new al(l.aqb(), l.aqa()), 0);
                AppMethodBeat.o(124504);
                return;
            }
            AppMethodBeat.o(124504);
        }
    };
    private static Thread thread = null;

    static class a implements Runnable {
        private static byte[] eMl = new byte[0];
        public static boolean fAV = false;
        private static final ak ggQ = new ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(124506);
                if (g.RK()) {
                    com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                    int size = a.ggH.size();
                    boolean parseBoolean = Boolean.parseBoolean(message.obj.toString());
                    Iterator it = a.ggH.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).cN(parseBoolean);
                    }
                    a.ggH.clear();
                    ab.i("MicroMsg.AddrBookSyncHelper", "callBackHandler setSize:%d time:%d", Integer.valueOf(size), Long.valueOf(aVar.Mr()));
                    AppMethodBeat.o(124506);
                    return;
                }
                AppMethodBeat.o(124506);
            }
        };
        private List<String[]> ggL;
        private List<String[]> ggM;
        private List<com.tencent.mm.plugin.account.friend.a.a> ggN;
        private List<com.tencent.mm.plugin.account.friend.a.a> ggO;
        private bm ggP;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        static {
            AppMethodBeat.i(124511);
            AppMethodBeat.o(124511);
        }

        private static List<com.tencent.mm.plugin.account.friend.a.a> c(List<com.tencent.mm.plugin.account.friend.a.a> list, int i, int i2) {
            AppMethodBeat.i(124507);
            LinkedList linkedList = new LinkedList();
            while (i < i2) {
                linkedList.add(list.get(i));
                i++;
            }
            AppMethodBeat.o(124507);
            return linkedList;
        }

        public final void run() {
            AppMethodBeat.i(124508);
            synchronized (eMl) {
                try {
                    this.ggP = new bm("MicroMsg.AddrBookSyncHelper", "sync addrBook");
                    this.ggP.addSplit("sync begin");
                    ab.d("MicroMsg.AddrBookSyncHelper", "reading email info");
                    this.ggL = com.tencent.mm.pluginsdk.a.fA(ah.getContext());
                    if (this.ggL != null) {
                        ab.i("MicroMsg.AddrBookSyncHelper", "sync address book email size: " + this.ggL.size());
                    }
                    this.ggO = c(1, this.ggL);
                    ab.d("MicroMsg.AddrBookSyncHelper", "reading mobile info");
                    this.ggM = com.tencent.mm.pluginsdk.a.fz(ah.getContext());
                    if (this.ggM != null) {
                        ab.i("MicroMsg.AddrBookSyncHelper", "sync address book mobile size: " + this.ggM.size());
                    }
                    this.ggN = c(0, this.ggM);
                    ab.d("MicroMsg.AddrBookSyncHelper", "reading done, begin sync to addr_upload");
                    if (this.ggL != null && this.ggO.size() > 0) {
                        for (int i = 0; i < this.ggO.size(); i += 100) {
                            List c;
                            ab.i("MicroMsg.AddrBookSyncHelper", "sync email index: ".concat(String.valueOf(i)));
                            if (i + 100 < this.ggO.size()) {
                                c = c(this.ggO, i, i + 100);
                            } else {
                                c = this.ggO;
                                c = c(c, i, c.size());
                            }
                            ab.i("MicroMsg.AddrBookSyncHelper", "sync email listToSync size: " + c.size());
                            l.as(c);
                        }
                    }
                    Message obtainMessage;
                    if (this.ggN == null || this.ggN.size() == 0) {
                        ab.i("MicroMsg.AddrBookSyncHelper", "mobile list null stop service");
                        obtainMessage = ggQ.obtainMessage();
                        obtainMessage.obj = Boolean.FALSE;
                        ggQ.sendMessage(obtainMessage);
                    } else {
                        int i2 = 0;
                        while (i2 < this.ggN.size()) {
                            ab.i("MicroMsg.AddrBookSyncHelper", "sync mobile index: ".concat(String.valueOf(i2)));
                            if (g.RK()) {
                                List c2;
                                if (i2 + 100 < this.ggN.size()) {
                                    c2 = c(this.ggN, i2, i2 + 100);
                                } else {
                                    c2 = this.ggN;
                                    c2 = c(c2, i2, c2.size());
                                }
                                ab.i("MicroMsg.AddrBookSyncHelper", "sync mobile listToSync size: " + c2.size());
                                l.as(c2);
                                i2 += 100;
                            } else {
                                ab.i("MicroMsg.AddrBookSyncHelper", "account not ready, stop sync");
                                obtainMessage = ggQ.obtainMessage();
                                obtainMessage.obj = Boolean.FALSE;
                                ggQ.sendMessage(obtainMessage);
                                AppMethodBeat.o(124508);
                                return;
                            }
                        }
                        ab.i("MicroMsg.AddrBookSyncHelper", "sync ok");
                        if (g.RK()) {
                            anF();
                            System.currentTimeMillis();
                            l.apX();
                            this.ggP.addSplit("sync ok");
                            this.ggP.dumpToLog();
                            obtainMessage = ggQ.obtainMessage();
                            obtainMessage.obj = Boolean.TRUE;
                            ggQ.sendMessage(obtainMessage);
                            AppMethodBeat.o(124508);
                            return;
                        }
                        ab.i("MicroMsg.AddrBookSyncHelper", "account not ready, exit");
                        obtainMessage = ggQ.obtainMessage();
                        obtainMessage.obj = Boolean.FALSE;
                        ggQ.sendMessage(obtainMessage);
                        AppMethodBeat.o(124508);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(124508);
                }
            }
        }

        private static void anF() {
            AppMethodBeat.i(124509);
            bm bmVar = new bm("MicroMsg.AddrBookSyncHelper", "delete");
            ArrayList arrayList = new ArrayList();
            List fB = com.tencent.mm.pluginsdk.a.fB(ah.getContext());
            for (String[] strArr : ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).apJ()) {
                String nullAsNil = bo.nullAsNil(strArr[0]);
                String nullAsNil2 = bo.nullAsNil(strArr[1]);
                if (!(nullAsNil.equals("") || fB.contains(nullAsNil))) {
                    arrayList.add(nullAsNil2);
                }
            }
            if (arrayList.size() > 0) {
                ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).ap(arrayList);
                l.ar(arrayList);
            }
            bmVar.addSplit("end");
            bmVar.dumpToLog();
            AppMethodBeat.o(124509);
        }

        private static List<com.tencent.mm.plugin.account.friend.a.a> c(int i, List<String[]> list) {
            AppMethodBeat.i(124510);
            if (list == null) {
                ab.e("MicroMsg.AddrBookSyncHelper", "sync address book failed, null info list");
                LinkedList linkedList = new LinkedList();
                AppMethodBeat.o(124510);
                return linkedList;
            }
            ArrayList arrayList = new ArrayList();
            for (String[] strArr : list) {
                if (strArr != null) {
                    String str = strArr[0];
                    String str2 = strArr[1];
                    String str3 = strArr[2];
                    String str4 = strArr[3];
                    long anl = bo.anl(strArr[4]);
                    if (!(str3 == null || str3.equals(""))) {
                        String str5 = "";
                        if (i == 1) {
                            str5 = com.tencent.mm.a.g.x(str3.getBytes());
                        }
                        if (i == 0) {
                            str5 = com.tencent.mm.pluginsdk.a.ws(str3);
                            if (bo.isNullOrNil(str5)) {
                                ab.d("MicroMsg.AddrBookSyncHelper", "formatted mobile null, continue");
                            } else {
                                str5 = com.tencent.mm.a.g.x(str5.getBytes());
                            }
                        }
                        com.tencent.mm.plugin.account.friend.a.a aVar = new com.tencent.mm.plugin.account.friend.a.a();
                        aVar.eBb = str2;
                        aVar.guE = g.vp(str2);
                        aVar.guF = g.vo(str2);
                        aVar.guC = str;
                        aVar.frQ = str4;
                        aVar.vS(str5);
                        aVar.gvf = anl;
                        aVar.guL = aVar.Ny();
                        if (i == 1) {
                            aVar.dtV = str3;
                        }
                        if (i == 0) {
                            aVar.guI = str3;
                        }
                        aVar.type = i;
                        aVar.bJt = 1095798;
                        arrayList.add(aVar);
                    }
                }
            }
            AppMethodBeat.o(124510);
            return arrayList;
        }
    }

    static {
        AppMethodBeat.i(124514);
        AppMethodBeat.o(124514);
    }

    public static boolean anC() {
        AppMethodBeat.i(124512);
        boolean syncAddrBook = syncAddrBook(ggI);
        AppMethodBeat.o(124512);
        return syncAddrBook;
    }

    public static boolean syncAddrBook(final b bVar) {
        AppMethodBeat.i(124513);
        final long id = Thread.currentThread().getId();
        if (l.apV()) {
            com.tencent.mm.sdk.platformtools.al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(124505);
                    boolean z = a.thread != null && a.thread.isAlive();
                    ab.i("MicroMsg.AddrBookSyncHelper", "syncAddrBook running:%b setSize:%d call:%d callback:%s", Boolean.valueOf(z), Integer.valueOf(a.ggH.size()), Long.valueOf(id), bVar);
                    a.ggH.add(bVar);
                    if (z) {
                        AppMethodBeat.o(124505);
                        return;
                    }
                    a.thread = d.a(new a(), "AddrBookSyncHelper_addrBookRead", 1);
                    l.apP();
                    a.thread.start();
                    AppMethodBeat.o(124505);
                }
            });
            AppMethodBeat.o(124513);
            return true;
        }
        ab.e("MicroMsg.AddrBookSyncHelper", "canSync:%b, skip", Boolean.valueOf(l.apV()));
        AppMethodBeat.o(124513);
        return false;
    }

    public static boolean anD() {
        return a.fAV;
    }
}
