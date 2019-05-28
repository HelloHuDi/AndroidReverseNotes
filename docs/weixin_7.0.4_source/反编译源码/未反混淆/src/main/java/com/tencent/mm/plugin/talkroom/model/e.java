package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.a;
import com.tencent.mm.bg.b;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class e implements b {
    private ak handler;
    private HashSet<a> listeners = new HashSet();
    private final String path;
    private com.tencent.mm.plugin.talkroom.a.b sxS;

    public e() {
        AppMethodBeat.i(25779);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(b.cEj());
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        this.path = b.cEj() + "talkroomMemberList.info";
        this.handler = new ak(Looper.getMainLooper());
        if (this.sxS == null) {
            if (com.tencent.mm.vfs.e.ct(this.path)) {
                try {
                    this.sxS = (com.tencent.mm.plugin.talkroom.a.b) new com.tencent.mm.plugin.talkroom.a.b().parseFrom(com.tencent.mm.vfs.e.e(this.path, 0, -1));
                    AppMethodBeat.o(25779);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", e, "", new Object[0]);
                    this.sxS = new com.tencent.mm.plugin.talkroom.a.b();
                }
            } else {
                this.sxS = new com.tencent.mm.plugin.talkroom.a.b();
                AppMethodBeat.o(25779);
                return;
            }
        }
        AppMethodBeat.o(25779);
    }

    public final synchronized void a(a aVar) {
        AppMethodBeat.i(25780);
        this.listeners.add(aVar);
        AppMethodBeat.o(25780);
    }

    public final synchronized void b(a aVar) {
        AppMethodBeat.i(25781);
        this.listeners.remove(aVar);
        AppMethodBeat.o(25781);
    }

    public final synchronized boolean tN(String str) {
        boolean z;
        AppMethodBeat.i(25782);
        Iterator it = this.sxS.sxH.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.talkroom.a.a aVar = (com.tencent.mm.plugin.talkroom.a.a) it.next();
            if (aVar.username.equals(str) && aVar.sceneType == 0) {
                z = true;
                AppMethodBeat.o(25782);
                break;
            }
        }
        z = false;
        AppMethodBeat.o(25782);
        return z;
    }

    public final synchronized boolean akv() {
        boolean z;
        AppMethodBeat.i(25783);
        Iterator it = this.sxS.sxH.iterator();
        loop0:
        while (it.hasNext()) {
            com.tencent.mm.plugin.talkroom.a.a aVar = (com.tencent.mm.plugin.talkroom.a.a) it.next();
            if (aVar.sceneType == 0) {
                Iterator it2 = aVar.cGh.iterator();
                while (it2.hasNext()) {
                    if (r.Yz().equals(((cgm) it2.next()).jBB)) {
                        z = true;
                        AppMethodBeat.o(25783);
                        break loop0;
                    }
                }
                continue;
            }
        }
        z = false;
        AppMethodBeat.o(25783);
        return z;
    }

    public final synchronized LinkedList<cgm> tM(String str) {
        LinkedList<cgm> linkedList;
        AppMethodBeat.i(25784);
        Iterator it = this.sxS.sxH.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.talkroom.a.a aVar = (com.tencent.mm.plugin.talkroom.a.a) it.next();
            if (aVar.username.equals(str)) {
                linkedList = (LinkedList) aVar.cGh.clone();
                AppMethodBeat.o(25784);
                break;
            }
        }
        linkedList = new LinkedList();
        AppMethodBeat.o(25784);
        return linkedList;
    }

    public final synchronized void a(String str, LinkedList<cgm> linkedList, String str2, String str3, int i) {
        LinkedList linkedList2;
        com.tencent.mm.plugin.talkroom.a.a aVar;
        AppMethodBeat.i(25785);
        if (linkedList2 == null) {
            linkedList2 = new LinkedList();
        }
        ab.i("MicroMsg.TalkRoomInfoListMgr", "updateList talk: %s,  size: %d", str, Integer.valueOf(linkedList2.size()));
        LinkedList linkedList3 = (LinkedList) linkedList2.clone();
        boolean isEmpty = linkedList3.isEmpty();
        Iterator it = this.sxS.sxH.iterator();
        while (it.hasNext()) {
            aVar = (com.tencent.mm.plugin.talkroom.a.a) it.next();
            if (aVar.username.equals(str)) {
                if (isEmpty) {
                    this.sxS.sxH.remove(aVar);
                } else {
                    aVar.cGh = linkedList3;
                    aVar.sceneType = i;
                }
                bJL();
                W(str, str2, str3);
                AppMethodBeat.o(25785);
            }
        }
        if (!isEmpty) {
            aVar = new com.tencent.mm.plugin.talkroom.a.a();
            aVar.username = str;
            aVar.cGh = linkedList3;
            aVar.sceneType = i;
            this.sxS.sxH.add(aVar);
        }
        bJL();
        W(str, str2, str3);
        AppMethodBeat.o(25785);
    }

    private void W(String str, String str2, String str3) {
        AppMethodBeat.i(25786);
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            final a aVar = (a) it.next();
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(25778);
                    aVar.k(str4, str5, str6);
                    AppMethodBeat.o(25778);
                }
            });
        }
        AppMethodBeat.o(25786);
    }

    private boolean bJL() {
        AppMethodBeat.i(25787);
        if (this.sxS.sxH.isEmpty()) {
            com.tencent.mm.vfs.e.deleteFile(this.path);
            AppMethodBeat.o(25787);
            return true;
        }
        try {
            byte[] toByteArray = this.sxS.toByteArray();
            com.tencent.mm.vfs.e.b(this.path, toByteArray, toByteArray.length);
            AppMethodBeat.o(25787);
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", e, "", new Object[0]);
            AppMethodBeat.o(25787);
            return false;
        }
    }
}
