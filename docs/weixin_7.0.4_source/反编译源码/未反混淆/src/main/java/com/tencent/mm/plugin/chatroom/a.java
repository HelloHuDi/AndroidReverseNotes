package com.tencent.mm.plugin.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.v;
import java.util.HashMap;

public final class a implements com.tencent.mm.kernel.api.bucket.a, c, com.tencent.mm.kernel.c.a, com.tencent.mm.plugin.chatroom.a.c {
    private v ktJ;
    private boolean ktK;
    private HashMap<String, Boolean> ktL = new HashMap();

    public a() {
        AppMethodBeat.i(1011);
        AppMethodBeat.o(1011);
    }

    public final ag c(h hVar) {
        AppMethodBeat.i(1012);
        v vVar = new v(hVar);
        AppMethodBeat.o(1012);
        return vVar;
    }

    public final boolean HH(String str) {
        AppMethodBeat.i(1013);
        if (this.ktK) {
            AppMethodBeat.o(1013);
            return false;
        }
        try {
            boolean booleanValue;
            if (this.ktL.containsKey(str)) {
                booleanValue = ((Boolean) this.ktL.get(str)).booleanValue();
                AppMethodBeat.o(1013);
                return booleanValue;
            }
            u oa = this.ktJ.oa(str);
            ab.i("MicroMsg.ChatroomService", "[isEnableRoomManager] chatroomName:%s isStatusEnable:%s switchFlag:%s minCount:%d memberCount:%d", str, Boolean.valueOf((((long) oa.field_chatroomStatus) & 16384) != 0), Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("ChatRoomAdminSwitch", -1)), Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("ChatRoomAdminMinMemberCount", -1)), Integer.valueOf(oa.afg().size()));
            if (((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("ChatRoomAdminSwitch", -1) <= 0 || (!r3 && r0 > oa.afg().size())) {
                booleanValue = false;
            } else {
                booleanValue = true;
            }
            this.ktL.put(str, Boolean.valueOf(booleanValue));
            AppMethodBeat.o(1013);
            return booleanValue;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ChatroomService", e, "[isEnableRoomManager]", new Object[0]);
            AppMethodBeat.o(1013);
            return false;
        }
    }

    public final void fN(boolean z) {
        this.ktK = z;
    }

    public final HashMap<Integer, d> collectDatabaseFactory() {
        AppMethodBeat.i(1014);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("CHATROOM_MEMBERS_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return v.fnj;
            }
        });
        AppMethodBeat.o(1014);
        return hashMap;
    }

    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(1015);
        this.ktJ = new v(g.RP().eJN);
        AppMethodBeat.o(1015);
    }

    public final void onAccountRelease() {
    }

    public final /* bridge */ /* synthetic */ ag XV() {
        return this.ktJ;
    }
}
