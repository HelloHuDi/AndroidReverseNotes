package com.tencent.mm.udp.libmmudp;

import com.tencent.matrix.trace.core.AppMethodBeat;

enum b {
    enmMBUdpSocketStatuslistening,
    enmMBUdpSocketStatusclose,
    enmMBUdpSocketStatusmessage,
    enmMBUdpSocketStatusError;

    static {
        AppMethodBeat.o(96574);
    }
}
