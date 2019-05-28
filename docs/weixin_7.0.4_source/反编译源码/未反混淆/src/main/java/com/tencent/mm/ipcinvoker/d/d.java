package com.tencent.mm.ipcinvoker.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public class d {
    public String ctq;
    public com.tencent.mm.ipcinvoker.d eGv;
    private String process;

    public <T extends b> d(String str, Class<T> cls) {
        AppMethodBeat.i(114078);
        Assert.assertNotNull(str);
        Assert.assertNotNull(cls);
        this.process = str;
        this.ctq = cls.getName();
        this.eGv = new com.tencent.mm.ipcinvoker.d(str);
        AppMethodBeat.o(114078);
    }
}
