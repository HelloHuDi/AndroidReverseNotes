package com.tencent.mm.plugin.appbrand.t.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.c.c;
import com.tencent.mm.plugin.appbrand.t.d.d.a;
import java.nio.ByteBuffer;

public final class b extends e implements a {
    static final ByteBuffer iTq = ByteBuffer.allocate(0);
    private int code;
    private String hTq;

    static {
        AppMethodBeat.i(73258);
        AppMethodBeat.o(73258);
    }

    public b() {
        super(a.CLOSING);
        AppMethodBeat.i(73251);
        eM(true);
        AppMethodBeat.o(73251);
    }

    public b(int i, String str) {
        String str2;
        super(a.CLOSING);
        AppMethodBeat.i(73252);
        eM(true);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (i == 1015) {
            str2 = "";
            i = 1005;
        }
        if (i != 1005) {
            byte[] Es = com.tencent.mm.plugin.appbrand.t.f.b.Es(str2);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(i);
            allocate.position(2);
            ByteBuffer allocate2 = ByteBuffer.allocate(Es.length + 2);
            allocate2.put(allocate);
            allocate2.put(Es);
            allocate2.rewind();
            A(allocate2);
            AppMethodBeat.o(73252);
        } else if (str2.length() > 0) {
            com.tencent.mm.plugin.appbrand.t.c.b bVar = new com.tencent.mm.plugin.appbrand.t.c.b("A close frame must have a closecode if it has a reason");
            AppMethodBeat.o(73252);
            throw bVar;
        } else {
            AppMethodBeat.o(73252);
        }
    }

    private void aOo() {
        AppMethodBeat.i(73253);
        this.code = 1005;
        ByteBuffer aOq = super.aOq();
        aOq.mark();
        if (aOq.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(aOq.getShort());
            allocate.position(0);
            this.code = allocate.getInt();
            if (this.code == 1006 || this.code == 1015 || this.code == 1005 || this.code > 4999 || this.code < 1000 || this.code == 1004) {
                c cVar = new c("closecode must not be sent over the wire: " + this.code);
                AppMethodBeat.o(73253);
                throw cVar;
            }
        }
        aOq.reset();
        AppMethodBeat.o(73253);
    }

    public final int aOn() {
        return this.code;
    }

    private void aOp() {
        AppMethodBeat.i(73254);
        if (this.code == 1005) {
            this.hTq = com.tencent.mm.plugin.appbrand.t.f.b.B(super.aOq());
            AppMethodBeat.o(73254);
            return;
        }
        ByteBuffer aOq = super.aOq();
        int position = aOq.position();
        try {
            aOq.position(aOq.position() + 2);
            this.hTq = com.tencent.mm.plugin.appbrand.t.f.b.B(aOq);
            aOq.position(position);
            AppMethodBeat.o(73254);
        } catch (IllegalArgumentException e) {
            c cVar = new c(e);
            AppMethodBeat.o(73254);
            throw cVar;
        } catch (Throwable th) {
            aOq.position(position);
            AppMethodBeat.o(73254);
        }
    }

    public final String getMessage() {
        return this.hTq;
    }

    public final String toString() {
        AppMethodBeat.i(73255);
        String str = super.toString() + "code: " + this.code;
        AppMethodBeat.o(73255);
        return str;
    }

    public final void A(ByteBuffer byteBuffer) {
        AppMethodBeat.i(73256);
        super.A(byteBuffer);
        aOo();
        aOp();
        AppMethodBeat.o(73256);
    }

    public final ByteBuffer aOq() {
        AppMethodBeat.i(73257);
        ByteBuffer byteBuffer;
        if (this.code == 1005) {
            byteBuffer = iTq;
            AppMethodBeat.o(73257);
            return byteBuffer;
        }
        byteBuffer = super.aOq();
        AppMethodBeat.o(73257);
        return byteBuffer;
    }
}
