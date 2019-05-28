package com.tencent.p177mm.plugin.appbrand.p332t.p1232d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C33533d.C33534a;
import com.tencent.p177mm.plugin.appbrand.p332t.p1539f.C42690b;
import com.tencent.p177mm.plugin.appbrand.p332t.p335c.C2462c;
import com.tencent.p177mm.plugin.appbrand.p332t.p335c.C27301b;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.plugin.appbrand.t.d.b */
public final class C27302b extends C41253e implements C19741a {
    static final ByteBuffer iTq = ByteBuffer.allocate(0);
    private int code;
    private String hTq;

    static {
        AppMethodBeat.m2504i(73258);
        AppMethodBeat.m2505o(73258);
    }

    public C27302b() {
        super(C33534a.CLOSING);
        AppMethodBeat.m2504i(73251);
        mo61235eM(true);
        AppMethodBeat.m2505o(73251);
    }

    public C27302b(int i, String str) {
        String str2;
        super(C33534a.CLOSING);
        AppMethodBeat.m2504i(73252);
        mo61235eM(true);
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
            byte[] Es = C42690b.m75608Es(str2);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(i);
            allocate.position(2);
            ByteBuffer allocate2 = ByteBuffer.allocate(Es.length + 2);
            allocate2.put(allocate);
            allocate2.put(Es);
            allocate2.rewind();
            mo44991A(allocate2);
            AppMethodBeat.m2505o(73252);
        } else if (str2.length() > 0) {
            C27301b c27301b = new C27301b("A close frame must have a closecode if it has a reason");
            AppMethodBeat.m2505o(73252);
            throw c27301b;
        } else {
            AppMethodBeat.m2505o(73252);
        }
    }

    private void aOo() {
        AppMethodBeat.m2504i(73253);
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
                C2462c c2462c = new C2462c("closecode must not be sent over the wire: " + this.code);
                AppMethodBeat.m2505o(73253);
                throw c2462c;
            }
        }
        aOq.reset();
        AppMethodBeat.m2505o(73253);
    }

    public final int aOn() {
        return this.code;
    }

    private void aOp() {
        AppMethodBeat.m2504i(73254);
        if (this.code == 1005) {
            this.hTq = C42690b.m75607B(super.aOq());
            AppMethodBeat.m2505o(73254);
            return;
        }
        ByteBuffer aOq = super.aOq();
        int position = aOq.position();
        try {
            aOq.position(aOq.position() + 2);
            this.hTq = C42690b.m75607B(aOq);
            aOq.position(position);
            AppMethodBeat.m2505o(73254);
        } catch (IllegalArgumentException e) {
            C2462c c2462c = new C2462c(e);
            AppMethodBeat.m2505o(73254);
            throw c2462c;
        } catch (Throwable th) {
            aOq.position(position);
            AppMethodBeat.m2505o(73254);
        }
    }

    public final String getMessage() {
        return this.hTq;
    }

    public final String toString() {
        AppMethodBeat.m2504i(73255);
        String str = super.toString() + "code: " + this.code;
        AppMethodBeat.m2505o(73255);
        return str;
    }

    /* renamed from: A */
    public final void mo44991A(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(73256);
        super.mo44991A(byteBuffer);
        aOo();
        aOp();
        AppMethodBeat.m2505o(73256);
    }

    public final ByteBuffer aOq() {
        AppMethodBeat.m2504i(73257);
        ByteBuffer byteBuffer;
        if (this.code == 1005) {
            byteBuffer = iTq;
            AppMethodBeat.m2505o(73257);
            return byteBuffer;
        }
        byteBuffer = super.aOq();
        AppMethodBeat.m2505o(73257);
        return byteBuffer;
    }
}
