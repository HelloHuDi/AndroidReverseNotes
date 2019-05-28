package com.tencent.mm.plugin.appbrand.t.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.e.a;
import com.tencent.mm.plugin.appbrand.t.e.c;
import com.tencent.mm.plugin.appbrand.t.e.i;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public final class d extends c {
    public final c a(a aVar, i iVar) {
        AppMethodBeat.i(73249);
        super.a(aVar, iVar);
        iVar.Ep("WebSocket Protocol Handshake");
        iVar.put("Server", "Java-WebSocket");
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        iVar.put("Date", simpleDateFormat.format(instance.getTime()));
        AppMethodBeat.o(73249);
        return iVar;
    }

    public final a aOm() {
        AppMethodBeat.i(73250);
        d dVar = new d();
        AppMethodBeat.o(73250);
        return dVar;
    }
}
