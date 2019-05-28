package com.tencent.p177mm.plugin.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.api.bucket.C18523a;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.model.C6663ag;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7624v;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.chatroom.a */
public final class C38785a implements C18523a, C1671c, C1694a, C6822c {
    private C7624v ktJ;
    private boolean ktK;
    private HashMap<String, Boolean> ktL = new HashMap();

    /* renamed from: com.tencent.mm.plugin.chatroom.a$1 */
    class C387861 implements C1366d {
        C387861() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C7624v.fnj;
        }
    }

    public C38785a() {
        AppMethodBeat.m2504i(1011);
        AppMethodBeat.m2505o(1011);
    }

    /* renamed from: c */
    public final C6663ag mo15091c(C7480h c7480h) {
        AppMethodBeat.m2504i(1012);
        C7624v c7624v = new C7624v(c7480h);
        AppMethodBeat.m2505o(1012);
        return c7624v;
    }

    /* renamed from: HH */
    public final boolean mo15089HH(String str) {
        AppMethodBeat.m2504i(1013);
        if (this.ktK) {
            AppMethodBeat.m2505o(1013);
            return false;
        }
        try {
            boolean booleanValue;
            if (this.ktL.containsKey(str)) {
                booleanValue = ((Boolean) this.ktL.get(str)).booleanValue();
                AppMethodBeat.m2505o(1013);
                return booleanValue;
            }
            C7577u oa = this.ktJ.mo14885oa(str);
            C4990ab.m7417i("MicroMsg.ChatroomService", "[isEnableRoomManager] chatroomName:%s isStatusEnable:%s switchFlag:%s minCount:%d memberCount:%d", str, Boolean.valueOf((((long) oa.field_chatroomStatus) & 16384) != 0), Integer.valueOf(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("ChatRoomAdminSwitch", -1)), Integer.valueOf(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("ChatRoomAdminMinMemberCount", -1)), Integer.valueOf(oa.afg().size()));
            if (((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("ChatRoomAdminSwitch", -1) <= 0 || (!r3 && r0 > oa.afg().size())) {
                booleanValue = false;
            } else {
                booleanValue = true;
            }
            this.ktL.put(str, Boolean.valueOf(booleanValue));
            AppMethodBeat.m2505o(1013);
            return booleanValue;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ChatroomService", e, "[isEnableRoomManager]", new Object[0]);
            AppMethodBeat.m2505o(1013);
            return false;
        }
    }

    /* renamed from: fN */
    public final void mo15092fN(boolean z) {
        this.ktK = z;
    }

    public final HashMap<Integer, C1366d> collectDatabaseFactory() {
        AppMethodBeat.m2504i(1014);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("CHATROOM_MEMBERS_TABLE".hashCode()), new C387861());
        AppMethodBeat.m2505o(1014);
        return hashMap;
    }

    public final void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(1015);
        this.ktJ = new C7624v(C1720g.m3536RP().eJN);
        AppMethodBeat.m2505o(1015);
    }

    public final void onAccountRelease() {
    }

    /* renamed from: XV */
    public final /* bridge */ /* synthetic */ C6663ag mo15090XV() {
        return this.ktJ;
    }
}
