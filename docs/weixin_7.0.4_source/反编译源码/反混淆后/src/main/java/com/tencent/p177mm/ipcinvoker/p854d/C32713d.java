package com.tencent.p177mm.ipcinvoker.p854d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C26330d;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ipcinvoker.d.d */
public class C32713d {
    public String ctq;
    public C26330d eGv;
    private String process;

    public <T extends C26329b> C32713d(String str, Class<T> cls) {
        AppMethodBeat.m2504i(114078);
        Assert.assertNotNull(str);
        Assert.assertNotNull(cls);
        this.process = str;
        this.ctq = cls.getName();
        this.eGv = new C26330d(str);
        AppMethodBeat.m2505o(114078);
    }
}
