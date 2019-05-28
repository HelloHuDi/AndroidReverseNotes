package com.tencent.p177mm.plugin.messenger.p453b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.messenger.b.b */
public final class C3451b {

    /* renamed from: com.tencent.mm.plugin.messenger.b.b$a */
    public static class C3452a {
        public String content;
        public int type;

        public C3452a(int i, String str) {
            this.type = i;
            this.content = str;
        }
    }

    /* renamed from: RF */
    public static ArrayList<C3452a> m5734RF(String str) {
        AppMethodBeat.m2504i(136941);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.SysMsgTemplateParser", "hy: null text!!");
            AppMethodBeat.m2505o(136941);
            return null;
        }
        ArrayList<C3452a> arrayList = new ArrayList();
        String[] split = str.split("\\$");
        for (int i = 0; i < split.length; i++) {
            Object c3452a;
            if (i % 2 == 0) {
                c3452a = new C3452a(0, split[i]);
            } else {
                c3452a = new C3452a(1, split[i]);
            }
            arrayList.add(c3452a);
        }
        AppMethodBeat.m2505o(136941);
        return arrayList;
    }
}
