package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.a;
import com.tencent.mm.bh.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.location.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p implements a {
    private List<c> bkF = new LinkedList();
    private ak handler;
    private b nKW;
    private final String path;

    public p() {
        AppMethodBeat.i(113397);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(l.bJB());
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        this.path = l.bJB() + "trackroominfolist.info";
        this.handler = new ak(Looper.getMainLooper());
        if (this.nKW == null) {
            if (e.ct(this.path)) {
                try {
                    this.nKW = (b) new b().parseFrom(e.e(this.path, 0, -1));
                    AppMethodBeat.o(113397);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.TrackRoomListMgr", e, "", new Object[0]);
                    this.nKW = new b();
                }
            } else {
                this.nKW = new b();
                AppMethodBeat.o(113397);
                return;
            }
        }
        AppMethodBeat.o(113397);
    }

    public final synchronized void a(c cVar) {
        AppMethodBeat.i(113398);
        this.bkF.add(cVar);
        AppMethodBeat.o(113398);
    }

    public final synchronized void b(c cVar) {
        AppMethodBeat.i(113399);
        this.bkF.remove(cVar);
        AppMethodBeat.o(113399);
    }

    public final synchronized LinkedList<String> tP(String str) {
        LinkedList<String> linkedList;
        AppMethodBeat.i(113400);
        Iterator it = this.nKW.nJr.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.location.a.a aVar = (com.tencent.mm.plugin.location.a.a) it.next();
            if (aVar.username.equals(str)) {
                linkedList = (LinkedList) aVar.cGh.clone();
                AppMethodBeat.o(113400);
                break;
            }
        }
        linkedList = new LinkedList();
        AppMethodBeat.o(113400);
        return linkedList;
    }

    public final synchronized com.tencent.mm.plugin.location.a.a PQ(String str) {
        com.tencent.mm.plugin.location.a.a aVar;
        AppMethodBeat.i(113401);
        Iterator it = this.nKW.nJr.iterator();
        while (it.hasNext()) {
            aVar = (com.tencent.mm.plugin.location.a.a) it.next();
            if (aVar.username.equals(str)) {
                AppMethodBeat.o(113401);
                break;
            }
        }
        aVar = null;
        AppMethodBeat.o(113401);
        return aVar;
    }

    public final synchronized void a(String str, LinkedList<String> linkedList, double d, double d2, String str2, String str3, String str4) {
        LinkedList linkedList2;
        com.tencent.mm.plugin.location.a.a aVar;
        AppMethodBeat.i(113402);
        if (linkedList2 == null) {
            linkedList2 = new LinkedList();
        }
        ab.i("MicroMsg.TrackRoomListMgr", "updateList talk: %s,  size: %d %f %f", str, Integer.valueOf(linkedList2.size()), Double.valueOf(d), Double.valueOf(d2));
        LinkedList linkedList3 = (LinkedList) linkedList2.clone();
        boolean isEmpty = linkedList3.isEmpty();
        Iterator it = this.nKW.nJr.iterator();
        while (it.hasNext()) {
            aVar = (com.tencent.mm.plugin.location.a.a) it.next();
            if (aVar.username.equals(str)) {
                if (isEmpty) {
                    this.nKW.nJr.remove(aVar);
                } else {
                    aVar.cGh = linkedList3;
                    aVar.nJq = str2;
                    aVar.latitude = d;
                    aVar.longitude = d2;
                }
                bJL();
                W(str, str3, str4);
                AppMethodBeat.o(113402);
            }
        }
        if (!isEmpty) {
            aVar = new com.tencent.mm.plugin.location.a.a();
            aVar.username = str;
            aVar.cGh = linkedList3;
            aVar.nJq = str2;
            aVar.latitude = d;
            aVar.longitude = d2;
            this.nKW.nJr.add(aVar);
        }
        bJL();
        W(str, str3, str4);
        AppMethodBeat.o(113402);
    }

    private void W(String str, String str2, String str3) {
        AppMethodBeat.i(113403);
        for (final c cVar : this.bkF) {
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(113396);
                    cVar.tR(str4);
                    AppMethodBeat.o(113396);
                }
            });
        }
        AppMethodBeat.o(113403);
    }

    private boolean bJL() {
        AppMethodBeat.i(113404);
        ab.d("MicroMsg.TrackRoomListMgr", "infoFile infolist size %d", Integer.valueOf(this.nKW.nJr.size()));
        if (this.nKW.nJr.isEmpty()) {
            e.deleteFile(this.path);
            AppMethodBeat.o(113404);
            return true;
        }
        try {
            byte[] toByteArray = this.nKW.toByteArray();
            e.b(this.path, toByteArray, toByteArray.length);
            AppMethodBeat.o(113404);
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TrackRoomListMgr", e, "", new Object[0]);
            AppMethodBeat.o(113404);
            return false;
        }
    }

    public final boolean tQ(String str) {
        AppMethodBeat.i(113405);
        if (tP(str).size() > 0) {
            AppMethodBeat.o(113405);
            return true;
        }
        AppMethodBeat.o(113405);
        return false;
    }

    public final boolean akL() {
        AppMethodBeat.i(113406);
        Iterator it = this.nKW.nJr.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.location.a.a aVar = (com.tencent.mm.plugin.location.a.a) it.next();
            ab.d("MicroMsg.TrackRoomListMgr", "info :" + aVar.cGh.size());
            Iterator it2 = aVar.cGh.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                ab.d("MicroMsg.TrackRoomListMgr", "member :".concat(String.valueOf(str)));
                if (str.equals(r.Yz())) {
                    ab.i("MicroMsg.TrackRoomListMgr", "now is sharing location..");
                    AppMethodBeat.o(113406);
                    return true;
                }
            }
        }
        AppMethodBeat.o(113406);
        return false;
    }

    public final boolean aV(String str, String str2) {
        AppMethodBeat.i(113407);
        boolean contains = tP(str).contains(str2);
        AppMethodBeat.o(113407);
        return contains;
    }

    public final String akM() {
        if (this.nKW != null) {
            return this.nKW.nJs;
        }
        return "";
    }

    public final void PR(String str) {
        AppMethodBeat.i(113408);
        if (this.nKW != null) {
            this.nKW.nJs = str;
        }
        bJL();
        AppMethodBeat.o(113408);
    }
}
