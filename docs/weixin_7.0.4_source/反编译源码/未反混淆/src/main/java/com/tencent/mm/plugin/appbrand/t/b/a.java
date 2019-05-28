package com.tencent.mm.plugin.appbrand.t.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.d.d;
import com.tencent.mm.plugin.appbrand.t.e.c;
import com.tencent.mm.plugin.appbrand.t.e.e;
import com.tencent.mm.plugin.appbrand.t.e.f;
import com.tencent.mm.plugin.appbrand.t.e.h;
import com.tencent.mm.plugin.appbrand.t.e.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class a {
    public static int iSY = 1000;
    public static int iSZ = 64;
    public static final byte[] iTa = com.tencent.mm.plugin.appbrand.t.f.b.Es("<policy-file-request/>\u0000");
    protected com.tencent.mm.plugin.appbrand.t.a.b iSF = null;
    protected com.tencent.mm.plugin.appbrand.t.d.d.a iTb = null;

    public enum b {
        MATCHED,
        NOT_MATCHED;

        static {
            AppMethodBeat.o(73232);
        }
    }

    public enum a {
        NONE,
        ONEWAY,
        TWOWAY;

        static {
            AppMethodBeat.o(73229);
        }
    }

    public abstract b a(com.tencent.mm.plugin.appbrand.t.e.a aVar, h hVar);

    public abstract com.tencent.mm.plugin.appbrand.t.e.b a(com.tencent.mm.plugin.appbrand.t.e.b bVar);

    public abstract c a(com.tencent.mm.plugin.appbrand.t.e.a aVar, i iVar);

    public abstract List<d> a(ByteBuffer byteBuffer, boolean z);

    public abstract a aOl();

    public abstract a aOm();

    public abstract List<d> ar(String str, boolean z);

    public abstract b c(com.tencent.mm.plugin.appbrand.t.e.a aVar);

    public abstract ByteBuffer d(d dVar);

    public abstract void reset();

    public abstract List<d> x(ByteBuffer byteBuffer);

    private static String w(ByteBuffer byteBuffer) {
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
        return com.tencent.mm.plugin.appbrand.t.f.b.H(byteBuffer2.array(), byteBuffer2.limit());
    }

    public static List<ByteBuffer> e(f fVar) {
        return f(fVar);
    }

    public static List<ByteBuffer> f(f fVar) {
        StringBuilder stringBuilder = new StringBuilder(100);
        if (fVar instanceof com.tencent.mm.plugin.appbrand.t.e.a) {
            stringBuilder.append("GET ");
            stringBuilder.append(((com.tencent.mm.plugin.appbrand.t.e.a) fVar).aOu());
            stringBuilder.append(" HTTP/1.1");
        } else if (fVar instanceof h) {
            stringBuilder.append("HTTP/1.1 101 " + ((h) fVar).aOv());
        } else {
            stringBuilder.append("GET ");
            stringBuilder.append(((com.tencent.mm.plugin.appbrand.t.e.a) fVar).aOu());
            stringBuilder.append(" HTTP/1.1");
            ab.e("MicroMsg.AppBrandNetWork.Draft", "unknow role");
        }
        stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        Iterator aOx = fVar.aOx();
        while (aOx.hasNext()) {
            String str = (String) aOx.next();
            String Eq = fVar.Eq(str);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(Eq);
            stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        byte[] Et = com.tencent.mm.plugin.appbrand.t.f.b.Et(stringBuilder.toString());
        byte[] aOy = fVar.aOy();
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
    public final f y(ByteBuffer byteBuffer) {
        com.tencent.mm.plugin.appbrand.t.a.b bVar = this.iSF;
        String w = w(byteBuffer);
        if (w == null) {
            throw new com.tencent.mm.plugin.appbrand.t.c.a(byteBuffer.capacity() + 128);
        }
        String[] split = w.split(" ", 3);
        if (split.length != 3) {
            throw new com.tencent.mm.plugin.appbrand.t.c.d();
        }
        c eVar;
        String w2;
        if (bVar == com.tencent.mm.plugin.appbrand.t.a.b.CLIENT) {
            eVar = new e();
            i iVar = (i) eVar;
            iVar.a(Short.parseShort(split[1]));
            iVar.Ep(split[2]);
        } else {
            eVar = new com.tencent.mm.plugin.appbrand.t.e.d();
            eVar.Eo(split[1]);
        }
        while (true) {
            w2 = w(byteBuffer);
            if (w2 != null && w2.length() > 0) {
                String[] split2 = w2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, 2);
                if (split2.length != 2) {
                    throw new com.tencent.mm.plugin.appbrand.t.c.d("not an http header");
                }
                eVar.put(split2[0], split2[1].replaceFirst("^ +", ""));
            } else if (w2 == null) {
                return eVar;
            } else {
                throw new com.tencent.mm.plugin.appbrand.t.c.a();
            }
        }
        if (w2 == null) {
        }
    }

    public static int qe(int i) {
        if (i >= 0) {
            return i;
        }
        throw new com.tencent.mm.plugin.appbrand.t.c.b("Negative count");
    }

    public final void a(com.tencent.mm.plugin.appbrand.t.a.b bVar) {
        this.iSF = bVar;
    }
}
