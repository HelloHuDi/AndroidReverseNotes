package com.tencent.p177mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p203bg.C1308b;
import com.tencent.p177mm.p203bg.C32335a;
import com.tencent.p177mm.plugin.talkroom.p1307a.C22377a;
import com.tencent.p177mm.plugin.talkroom.p1307a.C29414b;
import com.tencent.p177mm.protocal.protobuf.cgm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.talkroom.model.e */
public final class C29419e implements C1308b {
    private C7306ak handler;
    private HashSet<C32335a> listeners = new HashSet();
    private final String path;
    private C29414b sxS;

    public C29419e() {
        AppMethodBeat.m2504i(25779);
        C5728b c5728b = new C5728b(C39952b.cEj());
        if (!c5728b.exists()) {
            c5728b.mkdirs();
        }
        this.path = C39952b.cEj() + "talkroomMemberList.info";
        this.handler = new C7306ak(Looper.getMainLooper());
        if (this.sxS == null) {
            if (C5730e.m8628ct(this.path)) {
                try {
                    this.sxS = (C29414b) new C29414b().parseFrom(C5730e.m8632e(this.path, 0, -1));
                    AppMethodBeat.m2505o(25779);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", e, "", new Object[0]);
                    this.sxS = new C29414b();
                }
            } else {
                this.sxS = new C29414b();
                AppMethodBeat.m2505o(25779);
                return;
            }
        }
        AppMethodBeat.m2505o(25779);
    }

    /* renamed from: a */
    public final synchronized void mo4620a(C32335a c32335a) {
        AppMethodBeat.m2504i(25780);
        this.listeners.add(c32335a);
        AppMethodBeat.m2505o(25780);
    }

    /* renamed from: b */
    public final synchronized void mo4623b(C32335a c32335a) {
        AppMethodBeat.m2504i(25781);
        this.listeners.remove(c32335a);
        AppMethodBeat.m2505o(25781);
    }

    /* renamed from: tN */
    public final synchronized boolean mo4625tN(String str) {
        boolean z;
        AppMethodBeat.m2504i(25782);
        Iterator it = this.sxS.sxH.iterator();
        while (it.hasNext()) {
            C22377a c22377a = (C22377a) it.next();
            if (c22377a.username.equals(str) && c22377a.sceneType == 0) {
                z = true;
                AppMethodBeat.m2505o(25782);
                break;
            }
        }
        z = false;
        AppMethodBeat.m2505o(25782);
        return z;
    }

    public final synchronized boolean akv() {
        boolean z;
        AppMethodBeat.m2504i(25783);
        Iterator it = this.sxS.sxH.iterator();
        loop0:
        while (it.hasNext()) {
            C22377a c22377a = (C22377a) it.next();
            if (c22377a.sceneType == 0) {
                Iterator it2 = c22377a.cGh.iterator();
                while (it2.hasNext()) {
                    if (C1853r.m3846Yz().equals(((cgm) it2.next()).jBB)) {
                        z = true;
                        AppMethodBeat.m2505o(25783);
                        break loop0;
                    }
                }
                continue;
            }
        }
        z = false;
        AppMethodBeat.m2505o(25783);
        return z;
    }

    /* renamed from: tM */
    public final synchronized LinkedList<cgm> mo4624tM(String str) {
        LinkedList<cgm> linkedList;
        AppMethodBeat.m2504i(25784);
        Iterator it = this.sxS.sxH.iterator();
        while (it.hasNext()) {
            C22377a c22377a = (C22377a) it.next();
            if (c22377a.username.equals(str)) {
                linkedList = (LinkedList) c22377a.cGh.clone();
                AppMethodBeat.m2505o(25784);
                break;
            }
        }
        linkedList = new LinkedList();
        AppMethodBeat.m2505o(25784);
        return linkedList;
    }

    /* renamed from: a */
    public final synchronized void mo4621a(String str, LinkedList<cgm> linkedList, String str2, String str3, int i) {
        LinkedList linkedList2;
        C22377a c22377a;
        AppMethodBeat.m2504i(25785);
        if (linkedList2 == null) {
            linkedList2 = new LinkedList();
        }
        C4990ab.m7417i("MicroMsg.TalkRoomInfoListMgr", "updateList talk: %s,  size: %d", str, Integer.valueOf(linkedList2.size()));
        LinkedList linkedList3 = (LinkedList) linkedList2.clone();
        boolean isEmpty = linkedList3.isEmpty();
        Iterator it = this.sxS.sxH.iterator();
        while (it.hasNext()) {
            c22377a = (C22377a) it.next();
            if (c22377a.username.equals(str)) {
                if (isEmpty) {
                    this.sxS.sxH.remove(c22377a);
                } else {
                    c22377a.cGh = linkedList3;
                    c22377a.sceneType = i;
                }
                bJL();
                m46690W(str, str2, str3);
                AppMethodBeat.m2505o(25785);
            }
        }
        if (!isEmpty) {
            c22377a = new C22377a();
            c22377a.username = str;
            c22377a.cGh = linkedList3;
            c22377a.sceneType = i;
            this.sxS.sxH.add(c22377a);
        }
        bJL();
        m46690W(str, str2, str3);
        AppMethodBeat.m2505o(25785);
    }

    /* renamed from: W */
    private void m46690W(String str, String str2, String str3) {
        AppMethodBeat.m2504i(25786);
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            final C32335a c32335a = (C32335a) it.next();
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(25778);
                    c32335a.mo14628k(str4, str5, str6);
                    AppMethodBeat.m2505o(25778);
                }
            });
        }
        AppMethodBeat.m2505o(25786);
    }

    private boolean bJL() {
        AppMethodBeat.m2504i(25787);
        if (this.sxS.sxH.isEmpty()) {
            C5730e.deleteFile(this.path);
            AppMethodBeat.m2505o(25787);
            return true;
        }
        try {
            byte[] toByteArray = this.sxS.toByteArray();
            C5730e.m8624b(this.path, toByteArray, toByteArray.length);
            AppMethodBeat.m2505o(25787);
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", e, "", new Object[0]);
            AppMethodBeat.m2505o(25787);
            return false;
        }
    }
}
