package com.tencent.p177mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.sport.PluginSport;
import com.tencent.p177mm.plugin.sport.p1302a.C39857a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.sport.model.k */
public final class C43623k {
    public static C43622j cwx() {
        AppMethodBeat.m2504i(93688);
        C43622j c43622j;
        if (C4996ah.bqo()) {
            c43622j = new C43622j(C39857a.rOY);
            AppMethodBeat.m2505o(93688);
            return c43622j;
        } else if (C4996ah.doE()) {
            c43622j = new C43622j(C39857a.rOZ);
            AppMethodBeat.m2505o(93688);
            return c43622j;
        } else {
            AppMethodBeat.m2505o(93688);
            return null;
        }
    }

    public static String cwy() {
        AppMethodBeat.m2504i(93689);
        String string;
        if (C4996ah.doE()) {
            string = ((PluginSport) C1720g.m3530M(PluginSport.class)).getSportFileStorage().getString(301, "");
            AppMethodBeat.m2505o(93689);
            return string;
        }
        string = new C43622j(C39857a.rOZ).getString(301, "");
        AppMethodBeat.m2505o(93689);
        return string;
    }

    /* renamed from: aa */
    public static long m78065aa(int i, long j) {
        AppMethodBeat.m2504i(93690);
        long j2;
        if (C4996ah.bqo()) {
            j2 = ((PluginSport) C1720g.m3530M(PluginSport.class)).getSportFileStorage().getLong(i, j);
            AppMethodBeat.m2505o(93690);
            return j2;
        }
        j2 = new C43622j(C39857a.rOY).getLong(i, j);
        AppMethodBeat.m2505o(93690);
        return j2;
    }

    /* renamed from: ab */
    public static void m78066ab(int i, long j) {
        AppMethodBeat.m2504i(93691);
        if (C4996ah.bqo()) {
            ((PluginSport) C1720g.m3530M(PluginSport.class)).getSportFileStorage().setLong(i, j);
            AppMethodBeat.m2505o(93691);
            return;
        }
        RuntimeException runtimeException = new RuntimeException(String.format("not support set value in %s process", new Object[]{C4996ah.getProcessName()}));
        AppMethodBeat.m2505o(93691);
        throw runtimeException;
    }

    /* renamed from: ZT */
    public static void m78063ZT(String str) {
        AppMethodBeat.m2504i(93692);
        if (C4996ah.bqo()) {
            ((PluginSport) C1720g.m3530M(PluginSport.class)).getSportFileStorage().setString(2, str);
            AppMethodBeat.m2505o(93692);
            return;
        }
        RuntimeException runtimeException = new RuntimeException(String.format("not support set value in %s process", new Object[]{C4996ah.getProcessName()}));
        AppMethodBeat.m2505o(93692);
        throw runtimeException;
    }

    /* renamed from: ZU */
    public static void m78064ZU(String str) {
        AppMethodBeat.m2504i(93693);
        if (C4996ah.doE()) {
            ((PluginSport) C1720g.m3530M(PluginSport.class)).getSportFileStorage().setString(301, str);
            AppMethodBeat.m2505o(93693);
            return;
        }
        RuntimeException runtimeException = new RuntimeException(String.format("not support set value in %s process", new Object[]{C4996ah.getProcessName()}));
        AppMethodBeat.m2505o(93693);
        throw runtimeException;
    }
}
