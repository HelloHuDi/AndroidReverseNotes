package com.tencent.p177mm.plugin.appbrand.p332t.p334b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p332t.C33526a.C19740b;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C33533d;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C33533d.C33534a;
import com.tencent.p177mm.plugin.appbrand.p332t.p1539f.C42690b;
import com.tencent.p177mm.plugin.appbrand.p332t.p335c.C10741a;
import com.tencent.p177mm.plugin.appbrand.p332t.p335c.C2463d;
import com.tencent.p177mm.plugin.appbrand.p332t.p335c.C27301b;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C10742f;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C16696h;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C33535i;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C38514a;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C38515c;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C42688d;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C42689e;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C45692b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.t.b.a */
public abstract class C38512a {
    public static int iSY = 1000;
    public static int iSZ = 64;
    public static final byte[] iTa = C42690b.m75608Es("<policy-file-request/>\u0000");
    protected C19740b iSF = null;
    protected C33534a iTb = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.t.b.a$b */
    public enum C33527b {
        MATCHED,
        NOT_MATCHED;

        static {
            AppMethodBeat.m2505o(73232);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.t.b.a$a */
    public enum C38511a {
        NONE,
        ONEWAY,
        TWOWAY;

        static {
            AppMethodBeat.m2505o(73229);
        }
    }

    /* renamed from: a */
    public abstract C33527b mo54003a(C38514a c38514a, C16696h c16696h);

    /* renamed from: a */
    public abstract C45692b mo6380a(C45692b c45692b);

    /* renamed from: a */
    public abstract C38515c mo15057a(C38514a c38514a, C33535i c33535i);

    /* renamed from: a */
    public abstract List<C33533d> mo54004a(ByteBuffer byteBuffer, boolean z);

    public abstract C38511a aOl();

    public abstract C38512a aOm();

    /* renamed from: ar */
    public abstract List<C33533d> mo54006ar(String str, boolean z);

    /* renamed from: c */
    public abstract C33527b mo6382c(C38514a c38514a);

    /* renamed from: d */
    public abstract ByteBuffer mo54007d(C33533d c33533d);

    public abstract void reset();

    /* renamed from: x */
    public abstract List<C33533d> mo54009x(ByteBuffer byteBuffer);

    /* renamed from: w */
    private static String m65202w(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b = (byte) 48;
        while (byteBuffer.hasRemaining()) {
            byte b2 = byteBuffer.get();
            allocate.put(b2);
            if (b == (byte) 13 && b2 == (byte) 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                byteBuffer2 = allocate;
                break;
            }
            b = b2;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        byteBuffer2 = null;
        if (byteBuffer2 == null) {
            return null;
        }
        return C42690b.m75610H(byteBuffer2.array(), byteBuffer2.limit());
    }

    /* renamed from: e */
    public static List<ByteBuffer> m65199e(C10742f c10742f) {
        return C38512a.m65200f(c10742f);
    }

    /* renamed from: f */
    public static List<ByteBuffer> m65200f(C10742f c10742f) {
        StringBuilder stringBuilder = new StringBuilder(100);
        if (c10742f instanceof C38514a) {
            stringBuilder.append("GET ");
            stringBuilder.append(((C38514a) c10742f).aOu());
            stringBuilder.append(" HTTP/1.1");
        } else if (c10742f instanceof C16696h) {
            stringBuilder.append("HTTP/1.1 101 " + ((C16696h) c10742f).aOv());
        } else {
            stringBuilder.append("GET ");
            stringBuilder.append(((C38514a) c10742f).aOu());
            stringBuilder.append(" HTTP/1.1");
            C4990ab.m7412e("MicroMsg.AppBrandNetWork.Draft", "unknow role");
        }
        stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        Iterator aOx = c10742f.aOx();
        while (aOx.hasNext()) {
            String str = (String) aOx.next();
            String Eq = c10742f.mo22296Eq(str);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(Eq);
            stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        byte[] Et = C42690b.m75609Et(stringBuilder.toString());
        byte[] aOy = c10742f.aOy();
        ByteBuffer allocate = ByteBuffer.allocate((aOy == null ? 0 : aOy.length) + Et.length);
        allocate.put(Et);
        if (aOy != null) {
            allocate.put(aOy);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0086 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: y */
    public final C10742f mo61233y(ByteBuffer byteBuffer) {
        C19740b c19740b = this.iSF;
        String w = C38512a.m65202w(byteBuffer);
        if (w == null) {
            throw new C10741a(byteBuffer.capacity() + 128);
        }
        String[] split = w.split(" ", 3);
        if (split.length != 3) {
            throw new C2463d();
        }
        C38515c c42689e;
        String w2;
        if (c19740b == C19740b.CLIENT) {
            c42689e = new C42689e();
            C33535i c33535i = (C33535i) c42689e;
            c33535i.mo54016a(Short.parseShort(split[1]));
            c33535i.mo54015Ep(split[2]);
        } else {
            c42689e = new C42688d();
            c42689e.mo68091Eo(split[1]);
        }
        while (true) {
            w2 = C38512a.m65202w(byteBuffer);
            if (w2 != null && w2.length() > 0) {
                String[] split2 = w2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, 2);
                if (split2.length != 2) {
                    throw new C2463d("not an http header");
                }
                c42689e.put(split2[0], split2[1].replaceFirst("^ +", ""));
            } else if (w2 == null) {
                return c42689e;
            } else {
                throw new C10741a();
            }
        }
        if (w2 == null) {
        }
    }

    /* renamed from: qe */
    public static int m65201qe(int i) {
        if (i >= 0) {
            return i;
        }
        throw new C27301b("Negative count");
    }

    /* renamed from: a */
    public final void mo61232a(C19740b c19740b) {
        this.iSF = c19740b;
    }
}
