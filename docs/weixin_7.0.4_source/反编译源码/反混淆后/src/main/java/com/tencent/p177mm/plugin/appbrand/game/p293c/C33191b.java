package com.tencent.p177mm.plugin.appbrand.game.p293c;

import android.graphics.Bitmap.Config;
import com.github.henryye.nativeiv.C0820b;
import com.github.henryye.nativeiv.C32016a;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.C25505d;
import com.github.henryye.nativeiv.bitmap.C37223c;
import com.github.henryye.nativeiv.bitmap.C45014b;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.comm.C0823a;
import com.github.henryye.nativeiv.p098a.C0819a;
import com.github.henryye.nativeiv.p794b.C37222c;
import com.tencent.luggage.p147g.C37399a;
import com.tencent.magicbrush.C37414c;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.image.C44679a;
import com.tencent.magicbrush.handler.image.C44679a.C32204a;
import com.tencent.magicbrush.handler.image.C44679a.C32205d;
import com.tencent.magicbrush.handler.image.IMBImageHandler;
import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.game.p1223f.C38226a;
import com.tencent.p177mm.plugin.appbrand.game.p1223f.C38226a.C268894;
import com.tencent.p177mm.plugin.appbrand.game.p294d.C45558d;
import com.tencent.p177mm.plugin.appbrand.game.p294d.C45558d.C10236a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.game.c.b */
public final class C33191b {

    /* renamed from: com.tencent.mm.plugin.appbrand.game.c.b$a */
    static class C26884a implements C0819a, C32204a {
        private final int hrp = 2048;
        private final int hrq = 2048;
        private C32016a hrr = new C32016a();
        private boolean hrs;

        public C26884a(boolean z) {
            AppMethodBeat.m2504i(130129);
            C32016a c32016a = this.hrr;
            c32016a.aLP.put(BitmapType.Native, new C0823a());
            this.hrs = z;
            AppMethodBeat.m2505o(130129);
        }

        public final void destroy() {
            AppMethodBeat.m2504i(130130);
            C32016a c32016a = this.hrr;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < c32016a.aLQ.size()) {
                    C32016a.m51988b((Map) c32016a.aLQ.get(c32016a.aLQ.keyAt(i2)));
                    i = i2 + 1;
                } else {
                    C32016a.m51988b(c32016a.aLP);
                    AppMethodBeat.m2505o(130130);
                    return;
                }
            }
        }

        /* renamed from: a */
        public final IBitmap mo44642a(String str, InputStream inputStream) {
            int i;
            AppMethodBeat.m2504i(130131);
            if (inputStream == null) {
                m42822a(str, C10236a.ERROR, C4996ah.getContext().getString(C25738R.string.f9273v5));
                C19690c.m30507pI(7);
                AppMethodBeat.m2505o(130131);
                return null;
            }
            C25505d g;
            C0820b c0820b = new C0820b(this.hrr);
            c0820b.aLV = this;
            if (c0820b.aLU != null) {
                c0820b.aLU.recycle();
            }
            if (inputStream != null) {
                g = C37222c.m62374g(inputStream);
            } else {
                g = null;
            }
            if (g == null) {
                m42822a(str, C10236a.ERROR, C4996ah.getContext().getString(C25738R.string.f9274v6));
                C19690c.m30507pI(5);
                AppMethodBeat.m2505o(130131);
                return null;
            } else if (g.aMl == C37223c.UNKNOWN) {
                m42822a(str, C10236a.ERROR, C4996ah.getContext().getString(C25738R.string.f9270v1));
                C19690c.m30507pI(0);
                AppMethodBeat.m2505o(130131);
                return null;
            } else if (g.aMm > 2048 || g.aMn > 2048) {
                m42822a(str, C10236a.ERROR, String.format(C4996ah.getContext().getString(C25738R.string.f9275v7), new Object[]{Integer.valueOf(2048), Integer.valueOf(2048), Long.valueOf(g.aMm), Long.valueOf(g.aMn)}));
                C19690c.m30507pI(3);
                AppMethodBeat.m2505o(130131);
                return null;
            } else {
                IBitmap pz;
                if (str == null || !(str.startsWith("http://") || str.startsWith("https://"))) {
                    C4990ab.m7417i("MicroMsg.MBImageHandlerRegistry", "hy: decode path:%.100s", str);
                } else {
                    C4990ab.m7417i("MicroMsg.MBImageHandlerRegistry", "hy: decode path:%s", str);
                }
                Config config = Config.ARGB_8888;
                C37223c c37223c = g.aMl;
                if (inputStream != null) {
                    Object obj;
                    Map map;
                    if (c0820b.aLT != null) {
                        C32016a c32016a = c0820b.aLW;
                        int hashCode = c0820b.hashCode();
                        BitmapType bitmapType = c0820b.aLT;
                        map = (Map) c32016a.aLQ.get(hashCode);
                        if (map != null && map.get(bitmapType) != null) {
                            pz = ((C45014b) map.get(bitmapType)).mo2519pz();
                        } else if (c32016a.aLP.get(bitmapType) != null) {
                            pz = ((C45014b) c32016a.aLP.get(bitmapType)).mo2519pz();
                        } else {
                            pz = null;
                        }
                        c0820b.aLU = pz;
                    } else {
                        C32016a c32016a2 = c0820b.aLW;
                        map = (Map) c32016a2.aLQ.get(c0820b.hashCode());
                        if (map != null) {
                            pz = C32016a.m51987a(c37223c, map);
                        } else {
                            pz = null;
                        }
                        if (pz == null) {
                            pz = C32016a.m51987a(c37223c, c32016a2.aLP);
                        }
                        c0820b.aLU = pz;
                    }
                    Object i2 = null;
                    try {
                        Object obj2;
                        c0820b.aLU.decodeInputStream(inputStream, config, c37223c);
                        if (c0820b.aLU.provide() != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        obj = obj2;
                    } catch (IOException e) {
                        C17837c.m27913a("Ni.BitmapWrapper", e, "hy: decodeInputStream", new Object[0]);
                        c0820b.aLV.mo2510i(str, 1);
                        i2 = 1;
                        obj = null;
                    } catch (OutOfMemoryError e2) {
                        C17837c.m27913a("Ni.BitmapWrapper", e2, "hy: decodeInputStream", new Object[0]);
                        c0820b.aLV.mo2510i(str, 2);
                        i2 = 1;
                        obj = null;
                    } catch (Throwable th) {
                        C17837c.m27913a("Ni.BitmapWrapper", th, "hy: decode image exception", new Object[0]);
                        c0820b.aLV.mo2510i(str, 3);
                        obj = null;
                    }
                    if (i2 != null) {
                        C37414c.m63042b(inputStream);
                    } else {
                        long available;
                        long j = 0;
                        try {
                            available = (long) inputStream.available();
                        } catch (IOException e3) {
                            C17837c.m27913a("Ni.BitmapWrapper", e3, "", new Object[0]);
                            available = j;
                        }
                        if (obj == null && c0820b.aLU.getType() == BitmapType.Native) {
                            C17837c.m27916i("Ni.BitmapWrapper", "hy: decode switch to legacy mode!", new Object[0]);
                            c0820b.aLU = ((C45014b) c0820b.aLW.aLP.get(BitmapType.Legacy)).mo2519pz();
                            try {
                                c0820b.aLU.decodeInputStream(inputStream, config, c37223c);
                            } catch (IOException e4) {
                                C17837c.m27913a("Ni.BitmapWrapper", e4, "hy: IOException when use legacy", new Object[0]);
                                c0820b.aLV.mo2510i(str, 1);
                            } catch (OutOfMemoryError e22) {
                                C17837c.m27913a("Ni.BitmapWrapper", e22, "hy: decodeInputStream", new Object[0]);
                                c0820b.aLV.mo2510i(str, 2);
                            } catch (Throwable th2) {
                                C17837c.m27913a("Ni.BitmapWrapper", th2, "hy: decode image exception", new Object[0]);
                                c0820b.aLV.mo2510i(str, 3);
                            }
                        }
                        c0820b.aLV.mo2509d(available, c0820b.aLU.getDecodeTime());
                        if (c0820b.aLU.getType() == BitmapType.Legacy) {
                            c0820b.aLV.mo2510i(str, 4);
                        }
                        if (c0820b.aLU.provide() == null) {
                            c0820b.aLU.recycle();
                            c0820b.aLU = null;
                        }
                        C37414c.m63042b(inputStream);
                    }
                }
                pz = c0820b.aLU;
                AppMethodBeat.m2505o(130131);
                return pz;
            }
        }

        /* renamed from: i */
        public final void mo2510i(String str, int i) {
            AppMethodBeat.m2504i(130132);
            if (i == 1) {
                C4990ab.m7413e("MicroMsg.MBImageHandlerRegistry", "IOEXCEPTION path:%s", str);
                m42822a(str, C10236a.ERROR, C4996ah.getContext().getString(C25738R.string.f9271v2));
                C19690c.m30507pI(4);
                AppMethodBeat.m2505o(130132);
            } else if (i == 2) {
                C4990ab.m7413e("MicroMsg.MBImageHandlerRegistry", "OUTOFMEMORY path:%s", str);
                m42822a(str, C10236a.ERROR, C4996ah.getContext().getString(C25738R.string.f9272v3));
                C19690c.m30507pI(1);
                AppMethodBeat.m2505o(130132);
            } else if (i == 3) {
                C4990ab.m7413e("MicroMsg.MBImageHandlerRegistry", "NATIVE_DECODE_ERROR path:%s", str);
                m42822a(str, C10236a.ERROR, C4996ah.getContext().getString(C25738R.string.f9269uy));
                C19690c.m30507pI(5);
                AppMethodBeat.m2505o(130132);
            } else {
                if (i == 4) {
                    C4990ab.m7417i("MicroMsg.MBImageHandlerRegistry", "USE_LEGACY path:%s", str);
                    C19690c.m30507pI(8);
                }
                AppMethodBeat.m2505o(130132);
            }
        }

        /* renamed from: d */
        public final void mo2509d(long j, long j2) {
            AppMethodBeat.m2504i(130133);
            C38226a aBG = C38226a.aBG();
            C4990ab.m7417i("MicroMsg.MBNiReporter", "hy: size:%d,cost:%d", Long.valueOf(j), Long.valueOf(j2));
            C26006a.post(new C268894(j));
            aBG.hug.add(Long.valueOf(j2));
            if (j2 >= 1000) {
                C19690c.m30507pI(11);
            }
            AppMethodBeat.m2505o(130133);
        }

        /* renamed from: a */
        private void m42822a(String str, C10236a c10236a, String str2) {
            AppMethodBeat.m2504i(130134);
            if (this.hrs) {
                C45558d.aAI().mo73367b(c10236a, str + ": " + str2);
            }
            AppMethodBeat.m2505o(130134);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.c.b$c */
    static final class C33190c {
        private int hro;

        public C33190c() {
            this.hro = -1;
            this.hro = 14883;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.c.b$b */
    static final class C33192b extends C32205d {
        private final C6750i hrt;

        /* synthetic */ C33192b(C6750i c6750i, IMBImageHandler iMBImageHandler, byte b) {
            this(c6750i, iMBImageHandler);
        }

        private C33192b(C6750i c6750i, IMBImageHandler iMBImageHandler) {
            super(iMBImageHandler);
            this.hrt = c6750i;
        }

        /* renamed from: ca */
        public final boolean mo4024ca(String str) {
            return true;
        }

        /* renamed from: cb */
        public final InputStream mo4025cb(String str) {
            AppMethodBeat.m2504i(130135);
            if (this.hrt == null) {
                C4990ab.m7413e("MicroMsg.WAGameRuntimeFileSystemDecoder", "fetch %s, runtime NULL", str);
                AppMethodBeat.m2505o(130135);
                return null;
            }
            C19681j c19681j = new C19681j();
            if (this.hrt.asE().mo5843b(str, c19681j) != C45518j.OK || c19681j.value == null) {
                C4990ab.m7413e("MicroMsg.WAGameRuntimeFileSystemDecoder", "fetch %s, ret %s", str, r1.name());
                AppMethodBeat.m2505o(130135);
                return null;
            }
            InputStream c37399a = new C37399a((ByteBuffer) c19681j.value);
            AppMethodBeat.m2505o(130135);
            return c37399a;
        }
    }

    /* renamed from: a */
    public static void m54293a(MBRuntime mBRuntime, C6750i c6750i, boolean z) {
        AppMethodBeat.m2504i(130136);
        C44679a c44679a = (C44679a) mBRuntime.getImageHandler();
        c44679a.mo71705a(new C33192b(c6750i, c44679a, (byte) 0), true);
        C33190c c33190c = new C33190c();
        c44679a.bUf = new C26884a(z);
        AppMethodBeat.m2505o(130136);
    }
}
