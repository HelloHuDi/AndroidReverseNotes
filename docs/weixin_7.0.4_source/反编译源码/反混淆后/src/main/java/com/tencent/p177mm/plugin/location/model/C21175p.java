package com.tencent.p177mm.plugin.location.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p837bh.C17983c;
import com.tencent.p177mm.p837bh.C9081a;
import com.tencent.p177mm.plugin.location.p734a.C6958a;
import com.tencent.p177mm.plugin.location.p734a.C6959b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.location.model.p */
public final class C21175p implements C9081a {
    private List<C17983c> bkF = new LinkedList();
    private C7306ak handler;
    private C6959b nKW;
    private final String path;

    public C21175p() {
        AppMethodBeat.m2504i(113397);
        C5728b c5728b = new C5728b(C39287l.bJB());
        if (!c5728b.exists()) {
            c5728b.mkdirs();
        }
        this.path = C39287l.bJB() + "trackroominfolist.info";
        this.handler = new C7306ak(Looper.getMainLooper());
        if (this.nKW == null) {
            if (C5730e.m8628ct(this.path)) {
                try {
                    this.nKW = (C6959b) new C6959b().parseFrom(C5730e.m8632e(this.path, 0, -1));
                    AppMethodBeat.m2505o(113397);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.TrackRoomListMgr", e, "", new Object[0]);
                    this.nKW = new C6959b();
                }
            } else {
                this.nKW = new C6959b();
                AppMethodBeat.m2505o(113397);
                return;
            }
        }
        AppMethodBeat.m2505o(113397);
    }

    /* renamed from: a */
    public final synchronized void mo20558a(C17983c c17983c) {
        AppMethodBeat.m2504i(113398);
        this.bkF.add(c17983c);
        AppMethodBeat.m2505o(113398);
    }

    /* renamed from: b */
    public final synchronized void mo20563b(C17983c c17983c) {
        AppMethodBeat.m2504i(113399);
        this.bkF.remove(c17983c);
        AppMethodBeat.m2505o(113399);
    }

    /* renamed from: tP */
    public final synchronized LinkedList<String> mo20564tP(String str) {
        LinkedList<String> linkedList;
        AppMethodBeat.m2504i(113400);
        Iterator it = this.nKW.nJr.iterator();
        while (it.hasNext()) {
            C6958a c6958a = (C6958a) it.next();
            if (c6958a.username.equals(str)) {
                linkedList = (LinkedList) c6958a.cGh.clone();
                AppMethodBeat.m2505o(113400);
                break;
            }
        }
        linkedList = new LinkedList();
        AppMethodBeat.m2505o(113400);
        return linkedList;
    }

    /* renamed from: PQ */
    public final synchronized C6958a mo36494PQ(String str) {
        C6958a c6958a;
        AppMethodBeat.m2504i(113401);
        Iterator it = this.nKW.nJr.iterator();
        while (it.hasNext()) {
            c6958a = (C6958a) it.next();
            if (c6958a.username.equals(str)) {
                AppMethodBeat.m2505o(113401);
                break;
            }
        }
        c6958a = null;
        AppMethodBeat.m2505o(113401);
        return c6958a;
    }

    /* renamed from: a */
    public final synchronized void mo20559a(String str, LinkedList<String> linkedList, double d, double d2, String str2, String str3, String str4) {
        LinkedList linkedList2;
        C6958a c6958a;
        AppMethodBeat.m2504i(113402);
        if (linkedList2 == null) {
            linkedList2 = new LinkedList();
        }
        C4990ab.m7417i("MicroMsg.TrackRoomListMgr", "updateList talk: %s,  size: %d %f %f", str, Integer.valueOf(linkedList2.size()), Double.valueOf(d), Double.valueOf(d2));
        LinkedList linkedList3 = (LinkedList) linkedList2.clone();
        boolean isEmpty = linkedList3.isEmpty();
        Iterator it = this.nKW.nJr.iterator();
        while (it.hasNext()) {
            c6958a = (C6958a) it.next();
            if (c6958a.username.equals(str)) {
                if (isEmpty) {
                    this.nKW.nJr.remove(c6958a);
                } else {
                    c6958a.cGh = linkedList3;
                    c6958a.nJq = str2;
                    c6958a.latitude = d;
                    c6958a.longitude = d2;
                }
                bJL();
                m32517W(str, str3, str4);
                AppMethodBeat.m2505o(113402);
            }
        }
        if (!isEmpty) {
            c6958a = new C6958a();
            c6958a.username = str;
            c6958a.cGh = linkedList3;
            c6958a.nJq = str2;
            c6958a.latitude = d;
            c6958a.longitude = d2;
            this.nKW.nJr.add(c6958a);
        }
        bJL();
        m32517W(str, str3, str4);
        AppMethodBeat.m2505o(113402);
    }

    /* renamed from: W */
    private void m32517W(String str, String str2, String str3) {
        AppMethodBeat.m2504i(113403);
        for (final C17983c c17983c : this.bkF) {
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(113396);
                    c17983c.mo33527tR(str4);
                    AppMethodBeat.m2505o(113396);
                }
            });
        }
        AppMethodBeat.m2505o(113403);
    }

    private boolean bJL() {
        AppMethodBeat.m2504i(113404);
        C4990ab.m7411d("MicroMsg.TrackRoomListMgr", "infoFile infolist size %d", Integer.valueOf(this.nKW.nJr.size()));
        if (this.nKW.nJr.isEmpty()) {
            C5730e.deleteFile(this.path);
            AppMethodBeat.m2505o(113404);
            return true;
        }
        try {
            byte[] toByteArray = this.nKW.toByteArray();
            C5730e.m8624b(this.path, toByteArray, toByteArray.length);
            AppMethodBeat.m2505o(113404);
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TrackRoomListMgr", e, "", new Object[0]);
            AppMethodBeat.m2505o(113404);
            return false;
        }
    }

    /* renamed from: tQ */
    public final boolean mo20565tQ(String str) {
        AppMethodBeat.m2504i(113405);
        if (mo20564tP(str).size() > 0) {
            AppMethodBeat.m2505o(113405);
            return true;
        }
        AppMethodBeat.m2505o(113405);
        return false;
    }

    public final boolean akL() {
        AppMethodBeat.m2504i(113406);
        Iterator it = this.nKW.nJr.iterator();
        while (it.hasNext()) {
            C6958a c6958a = (C6958a) it.next();
            C4990ab.m7410d("MicroMsg.TrackRoomListMgr", "info :" + c6958a.cGh.size());
            Iterator it2 = c6958a.cGh.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                C4990ab.m7410d("MicroMsg.TrackRoomListMgr", "member :".concat(String.valueOf(str)));
                if (str.equals(C1853r.m3846Yz())) {
                    C4990ab.m7416i("MicroMsg.TrackRoomListMgr", "now is sharing location..");
                    AppMethodBeat.m2505o(113406);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(113406);
        return false;
    }

    /* renamed from: aV */
    public final boolean mo20560aV(String str, String str2) {
        AppMethodBeat.m2504i(113407);
        boolean contains = mo20564tP(str).contains(str2);
        AppMethodBeat.m2505o(113407);
        return contains;
    }

    public final String akM() {
        if (this.nKW != null) {
            return this.nKW.nJs;
        }
        return "";
    }

    /* renamed from: PR */
    public final void mo36495PR(String str) {
        AppMethodBeat.m2504i(113408);
        if (this.nKW != null) {
            this.nKW.nJs = str;
        }
        bJL();
        AppMethodBeat.m2505o(113408);
    }
}
