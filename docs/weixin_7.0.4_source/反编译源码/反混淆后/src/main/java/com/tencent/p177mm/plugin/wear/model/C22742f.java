package com.tencent.p177mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.wear.model.f */
public final class C22742f {
    public String cvZ = "";
    /* renamed from: id */
    public int f4403id = 0;
    public int tYc = 0;
    C22743a tYd;
    public String talker = "";

    /* renamed from: com.tencent.mm.plugin.wear.model.f$a */
    public enum C22743a {
        INIT,
        SHOWING,
        IGNORE,
        REPLY;

        static {
            AppMethodBeat.m2505o(26329);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final Object clone() {
        AppMethodBeat.m2504i(26330);
        C22742f c22742f = new C22742f();
        c22742f.f4403id = this.f4403id;
        c22742f.talker = this.talker;
        c22742f.cvZ = this.cvZ;
        c22742f.tYc = this.tYc;
        c22742f.tYd = this.tYd;
        AppMethodBeat.m2505o(26330);
        return c22742f;
    }

    public final String toString() {
        AppMethodBeat.m2504i(26331);
        String str = "WearNotification [talker=" + this.talker + ", id=" + this.f4403id + ", md5=" + this.cvZ + ", ignoreInWatch=" + this.tYc + ", status=" + this.tYd + "]";
        AppMethodBeat.m2505o(26331);
        return str;
    }
}
