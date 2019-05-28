package com.tencent.p177mm.plugin.avatar;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.jni.utils.UtilsJni;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.avatar.a */
public final class C27440a implements C44041a {
    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(79052);
        if (strArr.length <= 1) {
            AppMethodBeat.m2505o(79052);
            return false;
        }
        C4990ab.m7417i("MicroMsg.AvatarCommand", "processCommand: %s", TextUtils.join(" ", strArr));
        String str2;
        if (strArr[1].equals("pull")) {
            if (strArr.length <= 2) {
                AppMethodBeat.m2505o(79052);
                return false;
            }
            String str3 = strArr[2];
            str2 = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoK(str3).field_username;
            String str4 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/avatar/";
            C5730e.m8643tf(str4);
            C17884o.acd();
            String D = C41732d.m73515D(str2, false);
            C5730e.m8644y(D, str4 + str3 + "-s." + C5730e.m8630cv(D));
            C17884o.acd();
            str2 = C41732d.m73515D(str2, true);
            C5730e.m8644y(str2, str4 + str3 + "-b." + C5730e.m8630cv(str2));
            Toast.makeText(C4996ah.getContext(), "pull to ".concat(String.valueOf(str4)), 0).show();
            AppMethodBeat.m2505o(79052);
            return true;
        } else if (strArr[1].equals("dump")) {
            if (strArr.length <= 2) {
                AppMethodBeat.m2505o(79052);
                return false;
            }
            C17880h qo = C17884o.act().mo33392qo(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoK(strArr[2]).field_username);
            C4990ab.m7417i("MicroMsg.AvatarCommand", "dump: %s, %s, %s, %s", qo.ack(), qo.acl(), Integer.valueOf(qo.frU), Integer.valueOf(qo.dtR));
            AppMethodBeat.m2505o(79052);
            return true;
        } else if (strArr[1].equals("clean")) {
            if (strArr.length <= 2) {
                AppMethodBeat.m2505o(79052);
                return false;
            }
            str2 = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoK(strArr[2]).field_username;
            C17884o.acd();
            C41732d.m73516E(str2, false);
            C17884o.acd();
            C41732d.m73516E(str2, true);
            AppMethodBeat.m2505o(79052);
            return true;
        } else if (strArr[1].equals("cleanAll")) {
            C5730e.m8618N("wcf://avatar/", true);
            AppMethodBeat.m2505o(79052);
            return true;
        } else if (!strArr[1].equals("decrypt")) {
            AppMethodBeat.m2505o(79052);
            return false;
        } else if (strArr.length <= 2) {
            AppMethodBeat.m2505o(79052);
            return false;
        } else {
            str2 = strArr[2];
            byte[] DecryptAvatar = UtilsJni.DecryptAvatar(C5730e.m8632e(str2, 0, -1));
            if (DecryptAvatar == null) {
                Toast.makeText(C4996ah.getContext(), "error", 0).show();
            } else {
                C5730e.m8624b(str2 + ".d", DecryptAvatar, DecryptAvatar.length);
            }
            AppMethodBeat.m2505o(79052);
            return true;
        }
    }
}
