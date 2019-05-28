package com.tencent.p177mm.plugin.appbrand.p332t.p334b;

import com.google.android.gms.common.util.AndroidUtilsLight;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p332t.C33526a.C19740b;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C27302b;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C33533d;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C33533d.C33534a;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C38513c;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C41253e;
import com.tencent.p177mm.plugin.appbrand.p332t.p1539f.C38516a;
import com.tencent.p177mm.plugin.appbrand.p332t.p1539f.C42690b;
import com.tencent.p177mm.plugin.appbrand.p332t.p334b.C38512a.C33527b;
import com.tencent.p177mm.plugin.appbrand.p332t.p334b.C38512a.C38511a;
import com.tencent.p177mm.plugin.appbrand.p332t.p335c.C2462c;
import com.tencent.p177mm.plugin.appbrand.p332t.p335c.C2463d;
import com.tencent.p177mm.plugin.appbrand.p332t.p335c.C27301b;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C10742f;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C16696h;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C33535i;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C38514a;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C38515c;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C45692b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* renamed from: com.tencent.mm.plugin.appbrand.t.b.b */
public class C33528b extends C38512a {
    private ByteBuffer iTj;
    private C33533d iTk = null;
    private final Random iTl = new Random();

    /* renamed from: com.tencent.mm.plugin.appbrand.t.b.b$a */
    class C33529a extends Throwable {
        int iTm;

        public C33529a(int i) {
            this.iTm = i;
        }
    }

    public C33528b() {
        AppMethodBeat.m2504i(73233);
        AppMethodBeat.m2505o(73233);
    }

    /* renamed from: g */
    public static int m54752g(C10742f c10742f) {
        int i = -1;
        AppMethodBeat.m2504i(73234);
        String Eq = c10742f.mo22296Eq("Sec-WebSocket-Version");
        if (Eq.length() > 0) {
            try {
                i = new Integer(Eq.trim()).intValue();
                AppMethodBeat.m2505o(73234);
            } catch (NumberFormatException e) {
                AppMethodBeat.m2505o(73234);
            }
        } else {
            AppMethodBeat.m2505o(73234);
        }
        return i;
    }

    /* renamed from: a */
    public final C33527b mo54003a(C38514a c38514a, C16696h c16696h) {
        C33527b c33527b;
        int i = 1;
        AppMethodBeat.m2504i(73235);
        String Eq = c38514a.mo22296Eq("Sec-WebSocket-Protocol");
        String Eq2 = c16696h.mo22296Eq("Sec-WebSocket-Protocol");
        if (!(C5046bo.isNullOrNil(Eq) || C5046bo.isNullOrNil(Eq2))) {
            C4990ab.m7411d("MicroMsg.AppBrandNetWork.Draft_10", "respProtocol is %s", Eq2);
            for (Object equals : Eq.split(", ")) {
                if (Eq2.equals(equals)) {
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                c33527b = C33527b.NOT_MATCHED;
                AppMethodBeat.m2505o(73235);
                return c33527b;
            }
        }
        if (c38514a.mo22297Er("Sec-WebSocket-Key") && c16696h.mo22297Er("Sec-WebSocket-Accept")) {
            if (C33528b.m54751En(c38514a.mo22296Eq("Sec-WebSocket-Key")).equals(c16696h.mo22296Eq("Sec-WebSocket-Accept"))) {
                c33527b = C33527b.MATCHED;
                AppMethodBeat.m2505o(73235);
                return c33527b;
            }
            c33527b = C33527b.NOT_MATCHED;
            AppMethodBeat.m2505o(73235);
            return c33527b;
        }
        c33527b = C33527b.NOT_MATCHED;
        AppMethodBeat.m2505o(73235);
        return c33527b;
    }

    /* renamed from: c */
    public C33527b mo6382c(C38514a c38514a) {
        AppMethodBeat.m2504i(73236);
        int g = C33528b.m54752g(c38514a);
        C33527b c33527b;
        if (g == 7 || g == 8) {
            Object obj;
            if (c38514a.mo22296Eq("Upgrade").equalsIgnoreCase("websocket") && c38514a.mo22296Eq("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade")) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                c33527b = C33527b.MATCHED;
                AppMethodBeat.m2505o(73236);
                return c33527b;
            }
            c33527b = C33527b.NOT_MATCHED;
            AppMethodBeat.m2505o(73236);
            return c33527b;
        }
        c33527b = C33527b.NOT_MATCHED;
        AppMethodBeat.m2505o(73236);
        return c33527b;
    }

    /* renamed from: d */
    public final ByteBuffer mo54007d(C33533d c33533d) {
        int i;
        int i2 = -128;
        int i3 = 0;
        AppMethodBeat.m2504i(73237);
        ByteBuffer aOq = c33533d.aOq();
        int i4 = this.iSF == C19740b.CLIENT ? 1 : 0;
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
        C33534a aOt = c33533d.aOt();
        if (aOt == C33534a.CONTINUOUS) {
            i = 0;
        } else if (aOt == C33534a.TEXT) {
            i = 1;
        } else if (aOt == C33534a.BINARY) {
            i = 2;
        } else if (aOt == C33534a.CLOSING) {
            i = 8;
        } else if (aOt == C33534a.PING) {
            i = 9;
        } else if (aOt == C33534a.PONG) {
            i = 10;
        } else {
            C4990ab.m7412e("MicroMsg.AppBrandNetWork.Draft_10", "Don't know how to handle force close" + aOt.toString());
            i = 8;
        }
        allocate.put((byte) (i | ((byte) (c33533d.aOr() ? -128 : 0))));
        byte[] i7 = C33528b.m54753i((long) aOq.remaining(), i5);
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
            allocate.put((byte) (i2 | C31128d.MIC_SketchMark));
            allocate.put(i7);
        } else {
            C4990ab.m7412e("MicroMsg.AppBrandNetWork.Draft_10", "Size representation not supported/specified");
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
        AppMethodBeat.m2505o(73237);
        return allocate;
    }

    /* renamed from: a */
    public final List<C33533d> mo54004a(ByteBuffer byteBuffer, boolean z) {
        AppMethodBeat.m2504i(73238);
        C41253e c41253e = new C41253e();
        try {
            c41253e.mo44991A(byteBuffer);
        } catch (C27301b e) {
            C4990ab.m7412e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e.toString());
        }
        c41253e.mo61235eM(true);
        c41253e.mo61234a(C33534a.BINARY);
        c41253e.mo61236eN(z);
        List singletonList = Collections.singletonList(c41253e);
        AppMethodBeat.m2505o(73238);
        return singletonList;
    }

    /* renamed from: ar */
    public final List<C33533d> mo54006ar(String str, boolean z) {
        AppMethodBeat.m2504i(73239);
        C41253e c41253e = new C41253e();
        try {
            c41253e.mo44991A(ByteBuffer.wrap(C42690b.m75608Es(str)));
        } catch (C27301b e) {
            C4990ab.m7412e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e.toString());
        }
        c41253e.mo61235eM(true);
        c41253e.mo61234a(C33534a.TEXT);
        c41253e.mo61236eN(z);
        List singletonList = Collections.singletonList(c41253e);
        AppMethodBeat.m2505o(73239);
        return singletonList;
    }

    /* renamed from: En */
    private static String m54751En(String str) {
        AppMethodBeat.m2504i(73240);
        String str2 = str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
        try {
            str2 = C38516a.m65219an(MessageDigest.getInstance(AndroidUtilsLight.DIGEST_ALGORITHM_SHA1).digest(str2.getBytes()));
            AppMethodBeat.m2505o(73240);
            return str2;
        } catch (NoSuchAlgorithmException e) {
            C4990ab.m7412e("MicroMsg.AppBrandNetWork.Draft_10", "not such algorithm " + e.toString());
            str2 = "";
            AppMethodBeat.m2505o(73240);
            return str2;
        }
    }

    /* renamed from: a */
    public C45692b mo6380a(C45692b c45692b) {
        AppMethodBeat.m2504i(73241);
        c45692b.put("Upgrade", "websocket");
        c45692b.put("Connection", "Upgrade");
        c45692b.put("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.iTl.nextBytes(bArr);
        c45692b.put("Sec-WebSocket-Key", C38516a.m65219an(bArr));
        AppMethodBeat.m2505o(73241);
        return c45692b;
    }

    /* renamed from: a */
    public C38515c mo15057a(C38514a c38514a, C33535i c33535i) {
        AppMethodBeat.m2504i(73242);
        c33535i.put("Upgrade", "websocket");
        c33535i.put("Connection", c38514a.mo22296Eq("Connection"));
        c33535i.mo54015Ep("Switching Protocols");
        String Eq = c38514a.mo22296Eq("Sec-WebSocket-Key");
        if (Eq == null) {
            C2463d c2463d = new C2463d("missing Sec-WebSocket-Key");
            AppMethodBeat.m2505o(73242);
            throw c2463d;
        }
        c33535i.put("Sec-WebSocket-Accept", C33528b.m54751En(Eq));
        AppMethodBeat.m2505o(73242);
        return c33535i;
    }

    /* renamed from: i */
    private static byte[] m54753i(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((int) (j >>> (i2 - (i3 * 8))));
        }
        return bArr;
    }

    /* renamed from: x */
    public final List<C33533d> mo54009x(ByteBuffer byteBuffer) {
        LinkedList linkedList;
        AppMethodBeat.m2504i(73243);
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
                    linkedList.add(m54754z((ByteBuffer) this.iTj.duplicate().position(0)));
                    this.iTj = null;
                    break;
                }
                this.iTj.put(byteBuffer.array(), byteBuffer.position(), remaining);
                byteBuffer.position(remaining + byteBuffer.position());
                List emptyList = Collections.emptyList();
                AppMethodBeat.m2505o(73243);
                return emptyList;
            } catch (C33529a e) {
                this.iTj.limit();
                ByteBuffer allocate = ByteBuffer.allocate(C38512a.m65201qe(e.iTm));
                this.iTj.rewind();
                allocate.put(this.iTj);
                this.iTj = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(m54754z(byteBuffer));
            } catch (C33529a e2) {
                byteBuffer.reset();
                this.iTj = ByteBuffer.allocate(C38512a.m65201qe(e2.iTm));
                this.iTj.put(byteBuffer);
            }
        }
        AppMethodBeat.m2505o(73243);
        return linkedList;
    }

    /* renamed from: z */
    private C33533d m54754z(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(73244);
        int remaining = byteBuffer.remaining();
        int i = 2;
        C33529a c33529a;
        if (remaining < 2) {
            c33529a = new C33529a(2);
            AppMethodBeat.m2505o(73244);
            throw c33529a;
        }
        byte b = byteBuffer.get();
        boolean z = (b >> 8) != 0;
        byte b2 = (byte) ((b & C31128d.MIC_SketchMark) >> 4);
        if (b2 != (byte) 0) {
            C2462c c2462c = new C2462c("bad rsv ".concat(String.valueOf(b2)));
            AppMethodBeat.m2505o(73244);
            throw c2462c;
        }
        Object obj;
        C33534a c33534a;
        C2462c c2462c2;
        byte b3 = byteBuffer.get();
        if ((b3 & -128) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        b2 = (byte) (b3 & C31128d.MIC_SketchMark);
        b = (byte) (b & 15);
        switch (b) {
            case (byte) 0:
                c33534a = C33534a.CONTINUOUS;
                break;
            case (byte) 1:
                c33534a = C33534a.TEXT;
                break;
            case (byte) 2:
                c33534a = C33534a.BINARY;
                break;
            case (byte) 8:
                c33534a = C33534a.CLOSING;
                break;
            case (byte) 9:
                c33534a = C33534a.PING;
                break;
            case (byte) 10:
                c33534a = C33534a.PONG;
                break;
            default:
                c2462c2 = new C2462c("unknow optcode " + ((short) b));
                AppMethodBeat.m2505o(73244);
                throw c2462c2;
        }
        if (z || !(c33534a == C33534a.PING || c33534a == C33534a.PONG || c33534a == C33534a.CLOSING)) {
            int intValue;
            if (b2 >= (byte) 0 && b2 <= (byte) 125) {
                b = b2;
            } else if (c33534a == C33534a.PING || c33534a == C33534a.PONG || c33534a == C33534a.CLOSING) {
                c2462c2 = new C2462c("more than 125 octets");
                AppMethodBeat.m2505o(73244);
                throw c2462c2;
            } else if (b2 == (byte) 126) {
                i = 4;
                if (remaining < 4) {
                    c33529a = new C33529a(4);
                    AppMethodBeat.m2505o(73244);
                    throw c33529a;
                }
                byte[] bArr = new byte[3];
                bArr[1] = byteBuffer.get();
                bArr[2] = byteBuffer.get();
                intValue = new BigInteger(bArr).intValue();
            } else {
                i = 10;
                if (remaining < 10) {
                    c33529a = new C33529a(10);
                    AppMethodBeat.m2505o(73244);
                    throw c33529a;
                }
                byte[] bArr2 = new byte[8];
                for (intValue = 0; intValue < 8; intValue++) {
                    bArr2[intValue] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr2).longValue();
                if (longValue > 2147483647L) {
                    C4990ab.m7412e("MicroMsg.AppBrandNetWork.Draft_10", "Payloadsize is to big...");
                    b = b2;
                } else {
                    intValue = (int) longValue;
                }
            }
            int i2 = ((obj != null ? 4 : 0) + i) + intValue;
            if (remaining < i2) {
                C33529a c33529a2 = new C33529a(i2);
                AppMethodBeat.m2505o(73244);
                throw c33529a2;
            }
            C38513c c27302b;
            ByteBuffer allocate = ByteBuffer.allocate(C38512a.m65201qe(intValue));
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
            if (c33534a == C33534a.CLOSING) {
                c27302b = new C27302b();
            } else {
                c27302b = new C41253e();
                c27302b.mo61235eM(z);
                c27302b.mo61234a(c33534a);
            }
            allocate.flip();
            c27302b.mo44991A(allocate);
            AppMethodBeat.m2505o(73244);
            return c27302b;
        }
        c2462c2 = new C2462c("control frames may no be fragmented");
        AppMethodBeat.m2505o(73244);
        throw c2462c2;
    }

    public final void reset() {
        this.iTj = null;
    }

    public C38512a aOm() {
        AppMethodBeat.m2504i(73245);
        C33528b c33528b = new C33528b();
        AppMethodBeat.m2505o(73245);
        return c33528b;
    }

    public final C38511a aOl() {
        return C38511a.TWOWAY;
    }
}
