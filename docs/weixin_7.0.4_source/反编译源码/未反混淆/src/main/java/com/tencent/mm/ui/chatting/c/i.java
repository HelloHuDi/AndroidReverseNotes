package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.vfs.e;

public final class i {
    public static void a(a aVar, bi biVar, Intent intent) {
        AppMethodBeat.i(31299);
        if (aVar == null || biVar == null) {
            AppMethodBeat.o(31299);
            return;
        }
        String str;
        int i;
        Bundle bundle;
        String talkerUserName = aVar.getTalkerUserName();
        String b = b(aVar, biVar);
        Bundle bundle2 = new Bundle();
        if (aVar.dFw()) {
            str = "stat_scene";
            i = 2;
            bundle = bundle2;
        } else {
            str = "stat_scene";
            if (t.mZ(talkerUserName)) {
                i = 7;
                bundle = bundle2;
            } else {
                i = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str, i);
        bundle2.putString("stat_msg_id", "msg_" + Long.toString(biVar.field_msgSvrId));
        bundle2.putString("stat_chat_talker_username", talkerUserName);
        bundle2.putString("stat_send_msg_user", b);
        intent.putExtra("_stat_obj", bundle2);
        AppMethodBeat.o(31299);
    }

    public static boolean e(bi biVar, String str) {
        AppMethodBeat.i(31301);
        if (System.currentTimeMillis() - biVar.field_createTime <= 259200000 || (!bo.isNullOrNil(str) && e.ct(str))) {
            AppMethodBeat.o(31301);
            return false;
        }
        AppMethodBeat.o(31301);
        return true;
    }

    public static ViewStub a(MMFragment mMFragment, int i) {
        AppMethodBeat.i(31303);
        ViewStub viewStub = (ViewStub) mMFragment.findViewById(i);
        if (viewStub != null) {
            viewStub.inflate();
        }
        AppMethodBeat.o(31303);
        return viewStub;
    }

    public static String ark(String str) {
        AppMethodBeat.i(31304);
        aw.ZK();
        u oa = c.XV().oa(str);
        if (oa != null && oa.afg().size() == 2) {
            int size = oa.afg().size();
            for (int i = 0; i < size; i++) {
                String str2 = (String) oa.afg().get(i);
                if (arl(str2)) {
                    AppMethodBeat.o(31304);
                    return str2;
                }
            }
        }
        AppMethodBeat.o(31304);
        return null;
    }

    public static boolean arl(String str) {
        AppMethodBeat.i(31305);
        if (t.mY(str) || !m.mo(str) || r.mG(str)) {
            AppMethodBeat.o(31305);
            return false;
        }
        int i;
        int i2;
        aw.ZK();
        ad aoO = c.XM().aoO(str);
        if (aoO != null) {
            i = aoO.field_type;
            aw.ZK();
            aoO = c.XM().aoO(aoO.field_encryptUsername);
            i2 = aoO != null ? aoO.field_type : -1;
        } else {
            i2 = -1;
            i = -1;
        }
        ab.i("MicroMsg.ChattingUI.ChattingLogic", "isStranger:%s type:%d etype:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(31305);
        return true;
    }

    /* JADX WARNING: Missing block: B:10:0x0035, code skipped:
            if (r0.length() > 0) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String b(a aVar, bi biVar) {
        AppMethodBeat.i(31300);
        String str = aVar.sRl.field_username;
        boolean dDm = ((d) aVar.aF(d.class)).dDm();
        if (aVar.dFw() || dDm) {
            String oy;
            if (aVar.dFw()) {
                oy = bf.oy(biVar.field_content);
                if (str != null) {
                    if (oy != null) {
                    }
                }
                oy = str;
            } else {
                if (biVar != null) {
                    oy = biVar.field_bizChatUserId;
                }
                oy = str;
            }
            AppMethodBeat.o(31300);
            return oy;
        }
        AppMethodBeat.o(31300);
        return str;
    }

    public static boolean ad(ad adVar) {
        AppMethodBeat.i(31302);
        if (adVar.field_username.equals("medianote") && (r.YD() & 16384) == 0) {
            AppMethodBeat.o(31302);
            return true;
        }
        AppMethodBeat.o(31302);
        return false;
    }
}
