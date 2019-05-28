package com.tencent.p177mm.plugin.appbrand.p332t.p334b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C33535i;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C38514a;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C38515c;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.tencent.mm.plugin.appbrand.t.b.d */
public final class C6787d extends C2461c {
    /* renamed from: a */
    public final C38515c mo15057a(C38514a c38514a, C33535i c33535i) {
        AppMethodBeat.m2504i(73249);
        super.mo15057a(c38514a, c33535i);
        c33535i.mo54015Ep("WebSocket Protocol Handshake");
        c33535i.put("Server", "Java-WebSocket");
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        c33535i.put("Date", simpleDateFormat.format(instance.getTime()));
        AppMethodBeat.m2505o(73249);
        return c33535i;
    }

    public final C38512a aOm() {
        AppMethodBeat.m2504i(73250);
        C6787d c6787d = new C6787d();
        AppMethodBeat.m2505o(73250);
        return c6787d;
    }
}
