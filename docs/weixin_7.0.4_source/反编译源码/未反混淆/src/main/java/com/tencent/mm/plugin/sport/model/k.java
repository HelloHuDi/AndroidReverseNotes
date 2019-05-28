package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.a.a;
import com.tencent.mm.sdk.platformtools.ah;

public final class k {
    public static j cwx() {
        AppMethodBeat.i(93688);
        j jVar;
        if (ah.bqo()) {
            jVar = new j(a.rOY);
            AppMethodBeat.o(93688);
            return jVar;
        } else if (ah.doE()) {
            jVar = new j(a.rOZ);
            AppMethodBeat.o(93688);
            return jVar;
        } else {
            AppMethodBeat.o(93688);
            return null;
        }
    }

    public static String cwy() {
        AppMethodBeat.i(93689);
        String string;
        if (ah.doE()) {
            string = ((PluginSport) g.M(PluginSport.class)).getSportFileStorage().getString(301, "");
            AppMethodBeat.o(93689);
            return string;
        }
        string = new j(a.rOZ).getString(301, "");
        AppMethodBeat.o(93689);
        return string;
    }

    public static long aa(int i, long j) {
        AppMethodBeat.i(93690);
        long j2;
        if (ah.bqo()) {
            j2 = ((PluginSport) g.M(PluginSport.class)).getSportFileStorage().getLong(i, j);
            AppMethodBeat.o(93690);
            return j2;
        }
        j2 = new j(a.rOY).getLong(i, j);
        AppMethodBeat.o(93690);
        return j2;
    }

    public static void ab(int i, long j) {
        AppMethodBeat.i(93691);
        if (ah.bqo()) {
            ((PluginSport) g.M(PluginSport.class)).getSportFileStorage().setLong(i, j);
            AppMethodBeat.o(93691);
            return;
        }
        RuntimeException runtimeException = new RuntimeException(String.format("not support set value in %s process", new Object[]{ah.getProcessName()}));
        AppMethodBeat.o(93691);
        throw runtimeException;
    }

    public static void ZT(String str) {
        AppMethodBeat.i(93692);
        if (ah.bqo()) {
            ((PluginSport) g.M(PluginSport.class)).getSportFileStorage().setString(2, str);
            AppMethodBeat.o(93692);
            return;
        }
        RuntimeException runtimeException = new RuntimeException(String.format("not support set value in %s process", new Object[]{ah.getProcessName()}));
        AppMethodBeat.o(93692);
        throw runtimeException;
    }

    public static void ZU(String str) {
        AppMethodBeat.i(93693);
        if (ah.doE()) {
            ((PluginSport) g.M(PluginSport.class)).getSportFileStorage().setString(301, str);
            AppMethodBeat.o(93693);
            return;
        }
        RuntimeException runtimeException = new RuntimeException(String.format("not support set value in %s process", new Object[]{ah.getProcessName()}));
        AppMethodBeat.o(93693);
        throw runtimeException;
    }
}
