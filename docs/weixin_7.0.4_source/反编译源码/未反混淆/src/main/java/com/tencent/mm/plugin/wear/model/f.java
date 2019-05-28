package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public String cvZ = "";
    public int id = 0;
    public int tYc = 0;
    a tYd;
    public String talker = "";

    public enum a {
        INIT,
        SHOWING,
        IGNORE,
        REPLY;

        static {
            AppMethodBeat.o(26329);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final Object clone() {
        AppMethodBeat.i(26330);
        f fVar = new f();
        fVar.id = this.id;
        fVar.talker = this.talker;
        fVar.cvZ = this.cvZ;
        fVar.tYc = this.tYc;
        fVar.tYd = this.tYd;
        AppMethodBeat.o(26330);
        return fVar;
    }

    public final String toString() {
        AppMethodBeat.i(26331);
        String str = "WearNotification [talker=" + this.talker + ", id=" + this.id + ", md5=" + this.cvZ + ", ignoreInWatch=" + this.tYc + ", status=" + this.tYd + "]";
        AppMethodBeat.o(26331);
        return str;
    }
}
