package com.tencent.mm.plugin.messenger.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class b {

    public static class a {
        public String content;
        public int type;

        public a(int i, String str) {
            this.type = i;
            this.content = str;
        }
    }

    public static ArrayList<a> RF(String str) {
        AppMethodBeat.i(136941);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.SysMsgTemplateParser", "hy: null text!!");
            AppMethodBeat.o(136941);
            return null;
        }
        ArrayList<a> arrayList = new ArrayList();
        String[] split = str.split("\\$");
        for (int i = 0; i < split.length; i++) {
            Object aVar;
            if (i % 2 == 0) {
                aVar = new a(0, split[i]);
            } else {
                aVar = new a(1, split[i]);
            }
            arrayList.add(aVar);
        }
        AppMethodBeat.o(136941);
        return arrayList;
    }
}
