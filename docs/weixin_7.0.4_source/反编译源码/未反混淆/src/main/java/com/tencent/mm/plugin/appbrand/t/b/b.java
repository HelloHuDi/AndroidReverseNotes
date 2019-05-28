package com.tencent.mm.plugin.appbrand.t.b;

import com.google.android.gms.common.util.AndroidUtilsLight;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.d.d;
import com.tencent.mm.plugin.appbrand.t.d.e;
import com.tencent.mm.plugin.appbrand.t.e.c;
import com.tencent.mm.plugin.appbrand.t.e.f;
import com.tencent.mm.plugin.appbrand.t.e.h;
import com.tencent.mm.plugin.appbrand.t.e.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class b extends a {
    private ByteBuffer iTj;
    private d iTk = null;
    private final Random iTl = new Random();

    class a extends Throwable {
        int iTm;

        public a(int i) {
            this.iTm = i;
        }
    }

    public b() {
        AppMethodBeat.i(73233);
        AppMethodBeat.o(73233);
    }

    public static int g(f fVar) {
        int i = -1;
        AppMethodBeat.i(73234);
        String Eq = fVar.Eq("Sec-WebSocket-Version");
        if (Eq.length() > 0) {
            try {
                i = new Integer(Eq.trim()).intValue();
                AppMethodBeat.o(73234);
            } catch (NumberFormatException e) {
                AppMethodBeat.o(73234);
            }
        } else {
            AppMethodBeat.o(73234);
        }
        return i;
    }

    public final com.tencent.mm.plugin.appbrand.t.b.a.b a(com.tencent.mm.plugin.appbrand.t.e.a aVar, h hVar) {
        com.tencent.mm.plugin.appbrand.t.b.a.b bVar;
        int i = 1;
        AppMethodBeat.i(73235);
        String Eq = aVar.Eq("Sec-WebSocket-Protocol");
        String Eq2 = hVar.Eq("Sec-WebSocket-Protocol");
        if (!(bo.isNullOrNil(Eq) || bo.isNullOrNil(Eq2))) {
            ab.d("MicroMsg.AppBrandNetWork.Draft_10", "respProtocol is %s", Eq2);
            for (Object equals : Eq.split(", ")) {
                if (Eq2.equals(equals)) {
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                bVar = com.tencent.mm.plugin.appbrand.t.b.a.b.NOT_MATCHED;
                AppMethodBeat.o(73235);
                return bVar;
            }
        }
        if (aVar.Er("Sec-WebSocket-Key") && hVar.Er("Sec-WebSocket-Accept")) {
            if (En(aVar.Eq("Sec-WebSocket-Key")).equals(hVar.Eq("Sec-WebSocket-Accept"))) {
                bVar = com.tencent.mm.plugin.appbrand.t.b.a.b.MATCHED;
                AppMethodBeat.o(73235);
                return bVar;
            }
            bVar = com.tencent.mm.plugin.appbrand.t.b.a.b.NOT_MATCHED;
            AppMethodBeat.o(73235);
            return bVar;
        }
        bVar = com.tencent.mm.plugin.appbrand.t.b.a.b.NOT_MATCHED;
        AppMethodBeat.o(73235);
        return bVar;
    }

    public com.tencent.mm.plugin.appbrand.t.b.a.b c(com.tencent.mm.plugin.appbrand.t.e.a aVar) {
        AppMethodBeat.i(73236);
        int g = g(aVar);
        com.tencent.mm.plugin.appbrand.t.b.a.b bVar;
        if (g == 7 || g == 8) {
            Object obj;
            if (aVar.Eq("Upgrade").equalsIgnoreCase("websocket") && aVar.Eq("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade")) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                bVar = com.tencent.mm.plugin.appbrand.t.b.a.b.MATCHED;
                AppMethodBeat.o(73236);
                return bVar;
            }
            bVar = com.tencent.mm.plugin.appbrand.t.b.a.b.NOT_MATCHED;
            AppMethodBeat.o(73236);
            return bVar;
        }
        bVar = com.tencent.mm.plugin.appbrand.t.b.a.b.NOT_MATCHED;
        AppMethodBeat.o(73236);
        return bVar;
    }

    public final ByteBuffer d(d dVar) {
        int i;
        int i2 = -128;
        int i3 = 0;
        AppMethodBeat.i(73237);
        ByteBuffer aOq = dVar.aOq();
        int i4 = this.iSF == com.tencent.mm.plugin.appbrand.t.a.b.CLIENT ? 1 : 0;
        int i5 = aOq.remaining() <= 125 ? 1 : aOq.remaining() <= CdnLogic.kBizGeneric ? 2 : 8;
        if (i5 > 1) {
            i = i5 + 1;
        } else {
            i = i5;
        }
        int i6 = i + 1;
        if (i4 != 0) {
            i = 4;
        } else {
            i = 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate((i + i6) + aOq.remaining());
        com.tencent.mm.plugin.appbrand.t.d.d.a aOt = dVar.aOt();
        if (aOt == com.tencent.mm.plugin.appbrand.t.d.d.a.CONTINUOUS) {
            i = 0;
        } else if (aOt == com.tencent.mm.plugin.appbrand.t.d.d.a.TEXT) {
            i = 1;
        } else if (aOt == com.tencent.mm.plugin.appbrand.t.d.d.a.BINARY) {
            i = 2;
        } else if (aOt == com.tencent.mm.plugin.appbrand.t.d.d.a.CLOSING) {
            i = 8;
        } else if (aOt == com.tencent.mm.plugin.appbrand.t.d.d.a.PING) {
            i = 9;
        } else if (aOt == com.tencent.mm.plugin.appbrand.t.d.d.a.PONG) {
            i = 10;
        } else {
            ab.e("MicroMsg.AppBrandNetWork.Draft_10", "Don't know how to handle force close" + aOt.toString());
            i = 8;
        }
        allocate.put((byte) (i | ((byte) (dVar.aOr() ? -128 : 0))));
        byte[] i7 = i((long) aOq.remaining(), i5);
        if (i5 == 1) {
            byte b = i7[0];
            if (i4 == 0) {
                i2 = 0;
            }
            allocate.put((byte) (b | i2));
        } else if (i5 == 2) {
            if (i4 == 0) {
                i2 = 0;
            }
            allocate.put((byte) (i2 | 126));
            allocate.put(i7);
        } else if (i5 == 8) {
            if (i4 == 0) {
                i2 = 0;
            }
            allocate.put((byte) (i2 | com.tencent.view.d.MIC_SketchMark));
            allocate.put(i7);
        } else {
            ab.e("MicroMsg.AppBrandNetWork.Draft_10", "Size representation not supported/specified");
        }
        if (i4 != 0) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.iTl.nextInt());
            allocate.put(allocate2.array());
            while (aOq.hasRemaining()) {
                allocate.put((byte) (aOq.get() ^ allocate2.get(i3 % 4)));
                i3++;
            }
        } else {
            allocate.put(aOq);
        }
        allocate.flip();
        AppMethodBeat.o(73237);
        return allocate;
    }

    public final List<d> a(ByteBuffer byteBuffer, boolean z) {
        AppMethodBeat.i(73238);
        e eVar = new e();
        try {
            eVar.A(byteBuffer);
        } catch (com.tencent.mm.plugin.appbrand.t.c.b e) {
            ab.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e.toString());
        }
        eVar.eM(true);
        eVar.a(com.tencent.mm.plugin.appbrand.t.d.d.a.BINARY);
        eVar.eN(z);
        List singletonList = Collections.singletonList(eVar);
        AppMethodBeat.o(73238);
        return singletonList;
    }

    public final List<d> ar(String str, boolean z) {
        AppMethodBeat.i(73239);
        e eVar = new e();
        try {
            eVar.A(ByteBuffer.wrap(com.tencent.mm.plugin.appbrand.t.f.b.Es(str)));
        } catch (com.tencent.mm.plugin.appbrand.t.c.b e) {
            ab.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e.toString());
        }
        eVar.eM(true);
        eVar.a(com.tencent.mm.plugin.appbrand.t.d.d.a.TEXT);
        eVar.eN(z);
        List singletonList = Collections.singletonList(eVar);
        AppMethodBeat.o(73239);
        return singletonList;
    }

    private static String En(String str) {
        AppMethodBeat.i(73240);
        String str2 = str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
        try {
            str2 = com.tencent.mm.plugin.appbrand.t.f.a.an(MessageDigest.getInstance(AndroidUtilsLight.DIGEST_ALGORITHM_SHA1).digest(str2.getBytes()));
            AppMethodBeat.o(73240);
            return str2;
        } catch (NoSuchAlgorithmException e) {
            ab.e("MicroMsg.AppBrandNetWork.Draft_10", "not such algorithm " + e.toString());
            str2 = "";
            AppMethodBeat.o(73240);
            return str2;
        }
    }

    public com.tencent.mm.plugin.appbrand.t.e.b a(com.tencent.mm.plugin.appbrand.t.e.b bVar) {
        AppMethodBeat.i(73241);
        bVar.put("Upgrade", "websocket");
        bVar.put("Connection", "Upgrade");
        bVar.put("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.iTl.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", com.tencent.mm.plugin.appbrand.t.f.a.an(bArr));
        AppMethodBeat.o(73241);
        return bVar;
    }

    public c a(com.tencent.mm.plugin.appbrand.t.e.a aVar, i iVar) {
        AppMethodBeat.i(73242);
        iVar.put("Upgrade", "websocket");
        iVar.put("Connection", aVar.Eq("Connection"));
        iVar.Ep("Switching Protocols");
        String Eq = aVar.Eq("Sec-WebSocket-Key");
        if (Eq == null) {
            com.tencent.mm.plugin.appbrand.t.c.d dVar = new com.tencent.mm.plugin.appbrand.t.c.d("missing Sec-WebSocket-Key");
            AppMethodBeat.o(73242);
            throw dVar;
        }
        iVar.put("Sec-WebSocket-Accept", En(Eq));
        AppMethodBeat.o(73242);
        return iVar;
    }

    private static byte[] i(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((int) (j >>> (i2 - (i3 * 8))));
        }
        return bArr;
    }

    public final List<d> x(ByteBuffer byteBuffer) {
        LinkedList linkedList;
        AppMethodBeat.i(73243);
        while (true) {
            linkedList = new LinkedList();
            if (this.iTj == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.iTj.remaining();
                if (remaining2 <= remaining) {
                    this.iTj.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                    byteBuffer.position(byteBuffer.position() + remaining2);
                    linkedList.add(z((ByteBuffer) this.iTj.duplicate().position(0)));
                    this.iTj = null;
                    break;
                }
                this.iTj.put(byteBuffer.array(), byteBuffer.position(), remaining);
                byteBuffer.position(remaining + byteBuffer.position());
                List emptyList = Collections.emptyList();
                AppMethodBeat.o(73243);
                return emptyList;
            } catch (a e) {
                this.iTj.limit();
                ByteBuffer allocate = ByteBuffer.allocate(a.qe(e.iTm));
                this.iTj.rewind();
                allocate.put(this.iTj);
                this.iTj = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(z(byteBuffer));
            } catch (a e2) {
                byteBuffer.reset();
                this.iTj = ByteBuffer.allocate(a.qe(e2.iTm));
                this.iTj.put(byteBuffer);
            }
        }
        AppMethodBeat.o(73243);
        return linkedList;
    }

    private d z(ByteBuffer byteBuffer) {
        AppMethodBeat.i(73244);
        int remaining = byteBuffer.remaining();
        int i = 2;
        a aVar;
        if (remaining < 2) {
            aVar = new a(2);
            AppMethodBeat.o(73244);
            throw aVar;
        }
        byte b = byteBuffer.get();
        boolean z = (b >> 8) != 0;
        byte b2 = (byte) ((b & com.tencent.view.d.MIC_SketchMark) >> 4);
        if (b2 != (byte) 0) {
            com.tencent.mm.plugin.appbrand.t.c.c cVar = new com.tencent.mm.plugin.appbrand.t.c.c("bad rsv ".concat(String.valueOf(b2)));
            AppMethodBeat.o(73244);
            throw cVar;
        }
        Object obj;
        com.tencent.mm.plugin.appbrand.t.d.d.a aVar2;
        com.tencent.mm.plugin.appbrand.t.c.c cVar2;
        byte b3 = byteBuffer.get();
        if ((b3 & -128) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        b2 = (byte) (b3 & com.tencent.view.d.MIC_SketchMark);
        b = (byte) (b & 15);
        switch (b) {
            case (byte) 0:
                aVar2 = com.tencent.mm.plugin.appbrand.t.d.d.a.CONTINUOUS;
                break;
            case (byte) 1:
                aVar2 = com.tencent.mm.plugin.appbrand.t.d.d.a.TEXT;
                break;
            case (byte) 2:
                aVar2 = com.tencent.mm.plugin.appbrand.t.d.d.a.BINARY;
                break;
            case (byte) 8:
                aVar2 = com.tencent.mm.plugin.appbrand.t.d.d.a.CLOSING;
                break;
            case (byte) 9:
                aVar2 = com.tencent.mm.plugin.appbrand.t.d.d.a.PING;
                break;
            case (byte) 10:
                aVar2 = com.tencent.mm.plugin.appbrand.t.d.d.a.PONG;
                break;
            default:
                cVar2 = new com.tencent.mm.plugin.appbrand.t.c.c("unknow optcode " + ((short) b));
                AppMethodBeat.o(73244);
                throw cVar2;
        }
        if (z || !(aVar2 == com.tencent.mm.plugin.appbrand.t.d.d.a.PING || aVar2 == com.tencent.mm.plugin.appbrand.t.d.d.a.PONG || aVar2 == com.tencent.mm.plugin.appbrand.t.d.d.a.CLOSING)) {
            int intValue;
            if (b2 >= (byte) 0 && b2 <= (byte) 125) {
                b = b2;
            } else if (aVar2 == com.tencent.mm.plugin.appbrand.t.d.d.a.PING || aVar2 == com.tencent.mm.plugin.appbrand.t.d.d.a.PONG || aVar2 == com.tencent.mm.plugin.appbrand.t.d.d.a.CLOSING) {
                cVar2 = new com.tencent.mm.plugin.appbrand.t.c.c("more than 125 octets");
                AppMethodBeat.o(73244);
                throw cVar2;
            } else if (b2 == (byte) 126) {
                i = 4;
                if (remaining < 4) {
                    aVar = new a(4);
                    AppMethodBeat.o(73244);
                    throw aVar;
                }
                byte[] bArr = new byte[3];
                bArr[1] = byteBuffer.get();
                bArr[2] = byteBuffer.get();
                intValue = new BigInteger(bArr).intValue();
            } else {
                i = 10;
                if (remaining < 10) {
                    aVar = new a(10);
                    AppMethodBeat.o(73244);
                    throw aVar;
                }
                byte[] bArr2 = new byte[8];
                for (intValue = 0; intValue < 8; intValue++) {
                    bArr2[intValue] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr2).longValue();
                if (longValue > 2147483647L) {
                    ab.e("MicroMsg.AppBrandNetWork.Draft_10", "Payloadsize is to big...");
                    b = b2;
                } else {
                    intValue = (int) longValue;
                }
            }
            int i2 = ((obj != null ? 4 : 0) + i) + intValue;
            if (remaining < i2) {
                a aVar3 = new a(i2);
                AppMethodBeat.o(73244);
                throw aVar3;
            }
            com.tencent.mm.plugin.appbrand.t.d.c bVar;
            ByteBuffer allocate = ByteBuffer.allocate(a.qe(intValue));
            if (obj != null) {
                byte[] bArr3 = new byte[4];
                byteBuffer.get(bArr3);
                for (i2 = 0; i2 < intValue; i2++) {
                    allocate.put((byte) (byteBuffer.get() ^ bArr3[i2 % 4]));
                }
            } else {
                allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                byteBuffer.position(byteBuffer.position() + allocate.limit());
            }
            if (aVar2 == com.tencent.mm.plugin.appbrand.t.d.d.a.CLOSING) {
                bVar = new com.tencent.mm.plugin.appbrand.t.d.b();
            } else {
                bVar = new e();
                bVar.eM(z);
                bVar.a(aVar2);
            }
            allocate.flip();
            bVar.A(allocate);
            AppMethodBeat.o(73244);
            return bVar;
        }
        cVar2 = new com.tencent.mm.plugin.appbrand.t.c.c("control frames may no be fragmented");
        AppMethodBeat.o(73244);
        throw cVar2;
    }

    public final void reset() {
        this.iTj = null;
    }

    public a aOm() {
        AppMethodBeat.i(73245);
        b bVar = new b();
        AppMethodBeat.o(73245);
        return bVar;
    }

    public final com.tencent.mm.plugin.appbrand.t.b.a.a aOl() {
        return com.tencent.mm.plugin.appbrand.t.b.a.a.TWOWAY;
    }
}
