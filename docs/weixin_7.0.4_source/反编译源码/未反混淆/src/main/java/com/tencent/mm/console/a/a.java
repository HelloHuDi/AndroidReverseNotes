package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.j;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(16124);
        j.getEmojiStorageMgr().xYy.axQ();
        AppMethodBeat.o(16124);
        return true;
    }
}
