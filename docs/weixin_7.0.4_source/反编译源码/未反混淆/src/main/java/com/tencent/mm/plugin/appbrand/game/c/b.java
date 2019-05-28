package com.tencent.mm.plugin.appbrand.game.c;

import android.graphics.Bitmap.Config;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.d;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.image.IMBImageHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.game.f.a.AnonymousClass4;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

public final class b {

    static class a implements com.github.henryye.nativeiv.a.a, com.tencent.magicbrush.handler.image.a.a {
        private final int hrp = 2048;
        private final int hrq = 2048;
        private com.github.henryye.nativeiv.a hrr = new com.github.henryye.nativeiv.a();
        private boolean hrs;

        public a(boolean z) {
            AppMethodBeat.i(130129);
            com.github.henryye.nativeiv.a aVar = this.hrr;
            aVar.aLP.put(BitmapType.Native, new com.github.henryye.nativeiv.comm.a());
            this.hrs = z;
            AppMethodBeat.o(130129);
        }

        public final void destroy() {
            AppMethodBeat.i(130130);
            com.github.henryye.nativeiv.a aVar = this.hrr;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < aVar.aLQ.size()) {
                    com.github.henryye.nativeiv.a.b((Map) aVar.aLQ.get(aVar.aLQ.keyAt(i2)));
                    i = i2 + 1;
                } else {
                    com.github.henryye.nativeiv.a.b(aVar.aLP);
                    AppMethodBeat.o(130130);
                    return;
                }
            }
        }

        public final IBitmap a(String str, InputStream inputStream) {
            int i;
            AppMethodBeat.i(130131);
            if (inputStream == null) {
                a(str, com.tencent.mm.plugin.appbrand.game.d.d.a.ERROR, ah.getContext().getString(R.string.v5));
                com.tencent.mm.plugin.appbrand.report.c.pI(7);
                AppMethodBeat.o(130131);
                return null;
            }
            d g;
            com.github.henryye.nativeiv.b bVar = new com.github.henryye.nativeiv.b(this.hrr);
            bVar.aLV = this;
            if (bVar.aLU != null) {
                bVar.aLU.recycle();
            }
            if (inputStream != null) {
                g = com.github.henryye.nativeiv.b.c.g(inputStream);
            } else {
                g = null;
            }
            if (g == null) {
                a(str, com.tencent.mm.plugin.appbrand.game.d.d.a.ERROR, ah.getContext().getString(R.string.v6));
                com.tencent.mm.plugin.appbrand.report.c.pI(5);
                AppMethodBeat.o(130131);
                return null;
            } else if (g.aMl == com.github.henryye.nativeiv.bitmap.c.UNKNOWN) {
                a(str, com.tencent.mm.plugin.appbrand.game.d.d.a.ERROR, ah.getContext().getString(R.string.v1));
                com.tencent.mm.plugin.appbrand.report.c.pI(0);
                AppMethodBeat.o(130131);
                return null;
            } else if (g.aMm > 2048 || g.aMn > 2048) {
                a(str, com.tencent.mm.plugin.appbrand.game.d.d.a.ERROR, String.format(ah.getContext().getString(R.string.v7), new Object[]{Integer.valueOf(2048), Integer.valueOf(2048), Long.valueOf(g.aMm), Long.valueOf(g.aMn)}));
                com.tencent.mm.plugin.appbrand.report.c.pI(3);
                AppMethodBeat.o(130131);
                return null;
            } else {
                IBitmap pz;
                if (str == null || !(str.startsWith("http://") || str.startsWith("https://"))) {
                    ab.i("MicroMsg.MBImageHandlerRegistry", "hy: decode path:%.100s", str);
                } else {
                    ab.i("MicroMsg.MBImageHandlerRegistry", "hy: decode path:%s", str);
                }
                Config config = Config.ARGB_8888;
                com.github.henryye.nativeiv.bitmap.c cVar = g.aMl;
                if (inputStream != null) {
                    Object obj;
                    Map map;
                    if (bVar.aLT != null) {
                        com.github.henryye.nativeiv.a aVar = bVar.aLW;
                        int hashCode = bVar.hashCode();
                        BitmapType bitmapType = bVar.aLT;
                        map = (Map) aVar.aLQ.get(hashCode);
                        if (map != null && map.get(bitmapType) != null) {
                            pz = ((com.github.henryye.nativeiv.bitmap.b) map.get(bitmapType)).pz();
                        } else if (aVar.aLP.get(bitmapType) != null) {
                            pz = ((com.github.henryye.nativeiv.bitmap.b) aVar.aLP.get(bitmapType)).pz();
                        } else {
                            pz = null;
                        }
                        bVar.aLU = pz;
                    } else {
                        com.github.henryye.nativeiv.a aVar2 = bVar.aLW;
                        map = (Map) aVar2.aLQ.get(bVar.hashCode());
                        if (map != null) {
                            pz = com.github.henryye.nativeiv.a.a(cVar, map);
                        } else {
                            pz = null;
                        }
                        if (pz == null) {
                            pz = com.github.henryye.nativeiv.a.a(cVar, aVar2.aLP);
                        }
                        bVar.aLU = pz;
                    }
                    Object i2 = null;
                    try {
                        Object obj2;
                        bVar.aLU.decodeInputStream(inputStream, config, cVar);
                        if (bVar.aLU.provide() != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        obj = obj2;
                    } catch (IOException e) {
                        com.tencent.magicbrush.a.c.c.a("Ni.BitmapWrapper", e, "hy: decodeInputStream", new Object[0]);
                        bVar.aLV.i(str, 1);
                        i2 = 1;
                        obj = null;
                    } catch (OutOfMemoryError e2) {
                        com.tencent.magicbrush.a.c.c.a("Ni.BitmapWrapper", e2, "hy: decodeInputStream", new Object[0]);
                        bVar.aLV.i(str, 2);
                        i2 = 1;
                        obj = null;
                    } catch (Throwable th) {
                        com.tencent.magicbrush.a.c.c.a("Ni.BitmapWrapper", th, "hy: decode image exception", new Object[0]);
                        bVar.aLV.i(str, 3);
                        obj = null;
                    }
                    if (i2 != null) {
                        com.tencent.magicbrush.c.b(inputStream);
                    } else {
                        long available;
                        long j = 0;
                        try {
                            available = (long) inputStream.available();
                        } catch (IOException e3) {
                            com.tencent.magicbrush.a.c.c.a("Ni.BitmapWrapper", e3, "", new Object[0]);
                            available = j;
                        }
                        if (obj == null && bVar.aLU.getType() == BitmapType.Native) {
                            com.tencent.magicbrush.a.c.c.i("Ni.BitmapWrapper", "hy: decode switch to legacy mode!", new Object[0]);
                            bVar.aLU = ((com.github.henryye.nativeiv.bitmap.b) bVar.aLW.aLP.get(BitmapType.Legacy)).pz();
                            try {
                                bVar.aLU.decodeInputStream(inputStream, config, cVar);
                            } catch (IOException e4) {
                                com.tencent.magicbrush.a.c.c.a("Ni.BitmapWrapper", e4, "hy: IOException when use legacy", new Object[0]);
                                bVar.aLV.i(str, 1);
                            } catch (OutOfMemoryError e22) {
                                com.tencent.magicbrush.a.c.c.a("Ni.BitmapWrapper", e22, "hy: decodeInputStream", new Object[0]);
                                bVar.aLV.i(str, 2);
                            } catch (Throwable th2) {
                                com.tencent.magicbrush.a.c.c.a("Ni.BitmapWrapper", th2, "hy: decode image exception", new Object[0]);
                                bVar.aLV.i(str, 3);
                            }
                        }
                        bVar.aLV.d(available, bVar.aLU.getDecodeTime());
                        if (bVar.aLU.getType() == BitmapType.Legacy) {
                            bVar.aLV.i(str, 4);
                        }
                        if (bVar.aLU.provide() == null) {
                            bVar.aLU.recycle();
                            bVar.aLU = null;
                        }
                        com.tencent.magicbrush.c.b(inputStream);
                    }
                }
                pz = bVar.aLU;
                AppMethodBeat.o(130131);
                return pz;
            }
        }

        public final void i(String str, int i) {
            AppMethodBeat.i(130132);
            if (i == 1) {
                ab.e("MicroMsg.MBImageHandlerRegistry", "IOEXCEPTION path:%s", str);
                a(str, com.tencent.mm.plugin.appbrand.game.d.d.a.ERROR, ah.getContext().getString(R.string.v2));
                com.tencent.mm.plugin.appbrand.report.c.pI(4);
                AppMethodBeat.o(130132);
            } else if (i == 2) {
                ab.e("MicroMsg.MBImageHandlerRegistry", "OUTOFMEMORY path:%s", str);
                a(str, com.tencent.mm.plugin.appbrand.game.d.d.a.ERROR, ah.getContext().getString(R.string.v3));
                com.tencent.mm.plugin.appbrand.report.c.pI(1);
                AppMethodBeat.o(130132);
            } else if (i == 3) {
                ab.e("MicroMsg.MBImageHandlerRegistry", "NATIVE_DECODE_ERROR path:%s", str);
                a(str, com.tencent.mm.plugin.appbrand.game.d.d.a.ERROR, ah.getContext().getString(R.string.uy));
                com.tencent.mm.plugin.appbrand.report.c.pI(5);
                AppMethodBeat.o(130132);
            } else {
                if (i == 4) {
                    ab.i("MicroMsg.MBImageHandlerRegistry", "USE_LEGACY path:%s", str);
                    com.tencent.mm.plugin.appbrand.report.c.pI(8);
                }
                AppMethodBeat.o(130132);
            }
        }

        public final void d(long j, long j2) {
            AppMethodBeat.i(130133);
            com.tencent.mm.plugin.appbrand.game.f.a aBG = com.tencent.mm.plugin.appbrand.game.f.a.aBG();
            ab.i("MicroMsg.MBNiReporter", "hy: size:%d,cost:%d", Long.valueOf(j), Long.valueOf(j2));
            com.tencent.mm.ce.a.post(new AnonymousClass4(j));
            aBG.hug.add(Long.valueOf(j2));
            if (j2 >= 1000) {
                com.tencent.mm.plugin.appbrand.report.c.pI(11);
            }
            AppMethodBeat.o(130133);
        }

        private void a(String str, com.tencent.mm.plugin.appbrand.game.d.d.a aVar, String str2) {
            AppMethodBeat.i(130134);
            if (this.hrs) {
                com.tencent.mm.plugin.appbrand.game.d.d.aAI().b(aVar, str + ": " + str2);
            }
            AppMethodBeat.o(130134);
        }
    }

    static final class c {
        private int hro;

        public c() {
            this.hro = -1;
            this.hro = 14883;
        }
    }

    static final class b extends com.tencent.magicbrush.handler.image.a.d {
        private final i hrt;

        /* synthetic */ b(i iVar, IMBImageHandler iMBImageHandler, byte b) {
            this(iVar, iMBImageHandler);
        }

        private b(i iVar, IMBImageHandler iMBImageHandler) {
            super(iMBImageHandler);
            this.hrt = iVar;
        }

        public final boolean ca(String str) {
            return true;
        }

        public final InputStream cb(String str) {
            AppMethodBeat.i(130135);
            if (this.hrt == null) {
                ab.e("MicroMsg.WAGameRuntimeFileSystemDecoder", "fetch %s, runtime NULL", str);
                AppMethodBeat.o(130135);
                return null;
            }
            j jVar = new j();
            if (this.hrt.asE().b(str, jVar) != com.tencent.mm.plugin.appbrand.appstorage.j.OK || jVar.value == null) {
                ab.e("MicroMsg.WAGameRuntimeFileSystemDecoder", "fetch %s, ret %s", str, r1.name());
                AppMethodBeat.o(130135);
                return null;
            }
            InputStream aVar = new com.tencent.luggage.g.a((ByteBuffer) jVar.value);
            AppMethodBeat.o(130135);
            return aVar;
        }
    }

    public static void a(MBRuntime mBRuntime, i iVar, boolean z) {
        AppMethodBeat.i(130136);
        com.tencent.magicbrush.handler.image.a aVar = (com.tencent.magicbrush.handler.image.a) mBRuntime.getImageHandler();
        aVar.a(new b(iVar, aVar, (byte) 0), true);
        c cVar = new c();
        aVar.bUf = new a(z);
        AppMethodBeat.o(130136);
    }
}
