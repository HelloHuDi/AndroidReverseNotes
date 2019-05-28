package com.tencent.mm.plugin.avatar;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.e;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(79052);
        if (strArr.length <= 1) {
            AppMethodBeat.o(79052);
            return false;
        }
        ab.i("MicroMsg.AvatarCommand", "processCommand: %s", TextUtils.join(" ", strArr));
        String str2;
        if (strArr[1].equals("pull")) {
            if (strArr.length <= 2) {
                AppMethodBeat.o(79052);
                return false;
            }
            String str3 = strArr[2];
            str2 = ((j) g.K(j.class)).XM().aoK(str3).field_username;
            String str4 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/avatar/";
            e.tf(str4);
            o.acd();
            String D = d.D(str2, false);
            e.y(D, str4 + str3 + "-s." + e.cv(D));
            o.acd();
            str2 = d.D(str2, true);
            e.y(str2, str4 + str3 + "-b." + e.cv(str2));
            Toast.makeText(ah.getContext(), "pull to ".concat(String.valueOf(str4)), 0).show();
            AppMethodBeat.o(79052);
            return true;
        } else if (strArr[1].equals("dump")) {
            if (strArr.length <= 2) {
                AppMethodBeat.o(79052);
                return false;
            }
            h qo = o.act().qo(((j) g.K(j.class)).XM().aoK(strArr[2]).field_username);
            ab.i("MicroMsg.AvatarCommand", "dump: %s, %s, %s, %s", qo.ack(), qo.acl(), Integer.valueOf(qo.frU), Integer.valueOf(qo.dtR));
            AppMethodBeat.o(79052);
            return true;
        } else if (strArr[1].equals("clean")) {
            if (strArr.length <= 2) {
                AppMethodBeat.o(79052);
                return false;
            }
            str2 = ((j) g.K(j.class)).XM().aoK(strArr[2]).field_username;
            o.acd();
            d.E(str2, false);
            o.acd();
            d.E(str2, true);
            AppMethodBeat.o(79052);
            return true;
        } else if (strArr[1].equals("cleanAll")) {
            e.N("wcf://avatar/", true);
            AppMethodBeat.o(79052);
            return true;
        } else if (!strArr[1].equals("decrypt")) {
            AppMethodBeat.o(79052);
            return false;
        } else if (strArr.length <= 2) {
            AppMethodBeat.o(79052);
            return false;
        } else {
            str2 = strArr[2];
            byte[] DecryptAvatar = UtilsJni.DecryptAvatar(e.e(str2, 0, -1));
            if (DecryptAvatar == null) {
                Toast.makeText(ah.getContext(), "error", 0).show();
            } else {
                e.b(str2 + ".d", DecryptAvatar, DecryptAvatar.length);
            }
            AppMethodBeat.o(79052);
            return true;
        }
    }
}
