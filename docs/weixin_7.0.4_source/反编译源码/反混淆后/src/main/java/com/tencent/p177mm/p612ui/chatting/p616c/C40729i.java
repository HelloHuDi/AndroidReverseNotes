package com.tencent.p177mm.p612ui.chatting.p616c;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32794m;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.ui.chatting.c.i */
public final class C40729i {
    /* renamed from: a */
    public static void m70425a(C46650a c46650a, C7620bi c7620bi, Intent intent) {
        AppMethodBeat.m2504i(31299);
        if (c46650a == null || c7620bi == null) {
            AppMethodBeat.m2505o(31299);
            return;
        }
        String str;
        int i;
        Bundle bundle;
        String talkerUserName = c46650a.getTalkerUserName();
        String b = C40729i.m70427b(c46650a, c7620bi);
        Bundle bundle2 = new Bundle();
        if (c46650a.dFw()) {
            str = "stat_scene";
            i = 2;
            bundle = bundle2;
        } else {
            str = "stat_scene";
            if (C1855t.m3913mZ(talkerUserName)) {
                i = 7;
                bundle = bundle2;
            } else {
                i = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str, i);
        bundle2.putString("stat_msg_id", "msg_" + Long.toString(c7620bi.field_msgSvrId));
        bundle2.putString("stat_chat_talker_username", talkerUserName);
        bundle2.putString("stat_send_msg_user", b);
        intent.putExtra("_stat_obj", bundle2);
        AppMethodBeat.m2505o(31299);
    }

    /* renamed from: e */
    public static boolean m70428e(C7620bi c7620bi, String str) {
        AppMethodBeat.m2504i(31301);
        if (System.currentTimeMillis() - c7620bi.field_createTime <= 259200000 || (!C5046bo.isNullOrNil(str) && C5730e.m8628ct(str))) {
            AppMethodBeat.m2505o(31301);
            return false;
        }
        AppMethodBeat.m2505o(31301);
        return true;
    }

    /* renamed from: a */
    public static ViewStub m70424a(MMFragment mMFragment, int i) {
        AppMethodBeat.m2504i(31303);
        ViewStub viewStub = (ViewStub) mMFragment.findViewById(i);
        if (viewStub != null) {
            viewStub.inflate();
        }
        AppMethodBeat.m2505o(31303);
        return viewStub;
    }

    public static String ark(String str) {
        AppMethodBeat.m2504i(31304);
        C9638aw.m17190ZK();
        C7577u oa = C18628c.m29087XV().mo14885oa(str);
        if (oa != null && oa.afg().size() == 2) {
            int size = oa.afg().size();
            for (int i = 0; i < size; i++) {
                String str2 = (String) oa.afg().get(i);
                if (C40729i.arl(str2)) {
                    AppMethodBeat.m2505o(31304);
                    return str2;
                }
            }
        }
        AppMethodBeat.m2505o(31304);
        return null;
    }

    public static boolean arl(String str) {
        AppMethodBeat.m2504i(31305);
        if (C1855t.m3912mY(str) || !C32794m.m53575mo(str) || C1853r.m3858mG(str)) {
            AppMethodBeat.m2505o(31305);
            return false;
        }
        int i;
        int i2;
        C9638aw.m17190ZK();
        C7616ad aoO = C18628c.m29078XM().aoO(str);
        if (aoO != null) {
            i = aoO.field_type;
            C9638aw.m17190ZK();
            aoO = C18628c.m29078XM().aoO(aoO.field_encryptUsername);
            i2 = aoO != null ? aoO.field_type : -1;
        } else {
            i2 = -1;
            i = -1;
        }
        C4990ab.m7417i("MicroMsg.ChattingUI.ChattingLogic", "isStranger:%s type:%d etype:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(31305);
        return true;
    }

    /* JADX WARNING: Missing block: B:10:0x0035, code skipped:
            if (r0.length() > 0) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static String m70427b(C46650a c46650a, C7620bi c7620bi) {
        AppMethodBeat.m2504i(31300);
        String str = c46650a.sRl.field_username;
        boolean dDm = ((C36135d) c46650a.mo74857aF(C36135d.class)).dDm();
        if (c46650a.dFw() || dDm) {
            String oy;
            if (c46650a.dFw()) {
                oy = C1829bf.m3762oy(c7620bi.field_content);
                if (str != null) {
                    if (oy != null) {
                    }
                }
                oy = str;
            } else {
                if (c7620bi != null) {
                    oy = c7620bi.field_bizChatUserId;
                }
                oy = str;
            }
            AppMethodBeat.m2505o(31300);
            return oy;
        }
        AppMethodBeat.m2505o(31300);
        return str;
    }

    /* renamed from: ad */
    public static boolean m70426ad(C7616ad c7616ad) {
        AppMethodBeat.m2504i(31302);
        if (c7616ad.field_username.equals("medianote") && (C1853r.m3822YD() & 16384) == 0) {
            AppMethodBeat.m2505o(31302);
            return true;
        }
        AppMethodBeat.m2505o(31302);
        return false;
    }
}
