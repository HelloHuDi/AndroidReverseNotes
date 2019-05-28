package com.tencent.p177mm.plugin.traceroute.p1043b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.traceroute.b.c */
public final class C46314c extends ThreadPoolExecutor {
    public C46314c() {
        super(10, 20, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(200), new CallerRunsPolicy());
        AppMethodBeat.m2504i(25990);
        AppMethodBeat.m2505o(25990);
    }
}
