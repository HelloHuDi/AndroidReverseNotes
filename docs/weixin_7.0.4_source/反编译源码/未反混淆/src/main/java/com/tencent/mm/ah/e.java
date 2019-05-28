package com.tencent.mm.ah;

import android.annotation.SuppressLint;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.ad;
import java.io.InputStream;
import java.io.OutputStream;
import junit.framework.Assert;
import org.xwalk.core.XWalkUpdater;

public final class e implements f {
    c frD = null;
    k frE = null;
    boolean frF = false;
    az frG = null;
    h fro = null;

    class a implements com.tencent.mm.sdk.platformtools.az.a {
        boolean aAR = true;
        String frH;
        String frI;
        h fro;
        boolean frq;

        public a(h hVar, String str, String str2) {
            this.fro = hVar;
            this.frH = str;
            this.frI = str2;
            this.frq = false;
        }

        public final boolean acf() {
            AppMethodBeat.i(77905);
            if (this.frq) {
                h.pYm.k(138, 61, 1);
                ab.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt %s", this.frI);
                byte[] DecryptAvatar = UtilsJni.DecryptAvatar(com.tencent.mm.vfs.e.e(this.frI, 0, -1));
                if (DecryptAvatar == null || DecryptAvatar.length <= 0) {
                    h.pYm.k(138, 62, 1);
                    ab.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt failed");
                    AppMethodBeat.o(77905);
                    return true;
                }
                com.tencent.mm.vfs.e.deleteFile(this.frI);
                com.tencent.mm.vfs.e.b(this.frI, DecryptAvatar, DecryptAvatar.length);
            }
            if (r.amp(this.frI)) {
                ab.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic start");
                h.pYm.k(138, 63, 1);
                String str = this.frI + "_hevc";
                com.tencent.mm.vfs.e.aQ(this.frI, str);
                com.tencent.mm.vfs.e.atc(this.frI);
                Uri asY = com.tencent.mm.vfs.e.asY(this.frI);
                Uri asY2 = com.tencent.mm.vfs.e.asY(str);
                if (asY == null || asY2 == null) {
                    ab.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: uri is null %s, %s", asY, asY2);
                    AppMethodBeat.o(77905);
                    return true;
                }
                String path = asY.getPath();
                int nativeWxam2Pic = ((com.tencent.mm.plugin.emoji.b.c) g.K(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(asY2.getPath(), path);
                com.tencent.mm.vfs.e.deleteFile(str);
                if (nativeWxam2Pic != 0) {
                    h.pYm.k(138, 64, 1);
                    ab.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic failed");
                    AppMethodBeat.o(77905);
                    return true;
                }
            }
            this.aAR = false;
            AppMethodBeat.o(77905);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.i(77906);
            if (e.this.frF) {
                AppMethodBeat.o(77906);
                return false;
            } else if (this.aAR) {
                e.this.frD.cr(3, -1);
                AppMethodBeat.o(77906);
                return false;
            } else {
                com.tencent.mm.vfs.e.deleteFile(this.frH);
                com.tencent.mm.vfs.e.aQ(this.frI, this.frH);
                k.av(this.frH, this.fro.getUsername());
                e.this.frD.cr(0, 0);
                AppMethodBeat.o(77906);
                return true;
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    class b implements com.tencent.mm.sdk.platformtools.az.a {
        public boolean aAR = true;
        public String frH = null;
        String frI;
        private com.tencent.mm.compatible.util.g.a frK;
        boolean frq = false;
        public h frs = null;

        public b(h hVar) {
            AppMethodBeat.i(77907);
            this.frs = hVar;
            o.acd();
            this.frH = d.C(hVar.getUsername(), true);
            this.frI = this.frH + ".tmp";
            this.frK = new com.tencent.mm.compatible.util.g.a();
            AppMethodBeat.o(77907);
        }

        /* JADX WARNING: Removed duplicated region for block: B:80:0x0279 A:{SYNTHETIC, Splitter:B:80:0x0279} */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0280 A:{Catch:{ Exception -> 0x028c }} */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0285 A:{Catch:{ Exception -> 0x028c }} */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x0279 A:{SYNTHETIC, Splitter:B:80:0x0279} */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0280 A:{Catch:{ Exception -> 0x028c }} */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0285 A:{Catch:{ Exception -> 0x028c }} */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x0279 A:{SYNTHETIC, Splitter:B:80:0x0279} */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0280 A:{Catch:{ Exception -> 0x028c }} */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0285 A:{Catch:{ Exception -> 0x028c }} */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x021a A:{SYNTHETIC, Splitter:B:67:0x021a} */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0221 A:{Catch:{ Exception -> 0x022a }} */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0226 A:{Catch:{ Exception -> 0x022a }} */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x0279 A:{SYNTHETIC, Splitter:B:80:0x0279} */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0280 A:{Catch:{ Exception -> 0x028c }} */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0285 A:{Catch:{ Exception -> 0x028c }} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean acf() {
            Throwable e;
            Object obj;
            OutputStream outputStream;
            InputStream inputStream = null;
            AppMethodBeat.i(77908);
            if (this.frs == null) {
                AppMethodBeat.o(77908);
                return false;
            }
            String str;
            String ack = this.frs.ack();
            boolean biY = ((com.tencent.mm.plugin.emoji.b.c) g.K(com.tencent.mm.plugin.emoji.b.c.class)).biY();
            boolean a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_avatar_download_big_hevc, false);
            if (biY && a) {
                ab.i("MicroMsg.GetHDHeadImgHelper", "GetHeadImgObj: get hevc");
                if (ack.contains("?")) {
                    str = ack + "&tp=wxpic";
                } else {
                    str = ack + "?tp=wxpic";
                }
                h.pYm.k(138, 60, 1);
            } else {
                str = ack;
            }
            ack = "";
            if (g.RN().QY()) {
                r2 = new Object[4];
                g.RN();
                r2[1] = p.getString(com.tencent.mm.kernel.a.QF());
                r2[2] = Integer.valueOf(at.getNetTypeForStat(ah.getContext()));
                r2[3] = Integer.valueOf(at.getStrength(ah.getContext()));
                ack = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r2);
            }
            ab.d("MicroMsg.GetHDHeadImgHelper", "dkreferer dkavatar user: %s referer: %s  url:%s", this.frs.getUsername(), ack, str);
            this.aAR = true;
            u a2;
            InputStream inputStream2;
            try {
                a2 = com.tencent.mm.network.b.a(str, null);
                try {
                    a2.setRequestMethod("GET");
                    a2.setRequestProperty("referer", ack);
                    a2.setConnectTimeout(5000);
                    a2.setReadTimeout(5000);
                    if (com.tencent.mm.network.b.a(a2) != 0) {
                        ab.e("MicroMsg.GetHDHeadImgHelper", "checkHttpConnection failed! url:%s", str);
                        try {
                            a2.connection.disconnect();
                        } catch (Exception e2) {
                            ab.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bo.l(e2));
                            ab.e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e2.getMessage());
                        }
                        AppMethodBeat.o(77908);
                        return true;
                    }
                    boolean z;
                    if (a2.getHeaderFieldInt("X-Enc", 0) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.frq = z;
                    inputStream2 = a2.getInputStream();
                    if (inputStream2 == null) {
                        try {
                            ab.d("MicroMsg.GetHDHeadImgHelper", "getInputStream failed. url:%s", str);
                            try {
                                a2.connection.disconnect();
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                            } catch (Exception e22) {
                                ab.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bo.l(e22));
                                ab.e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e22.getMessage());
                            }
                            AppMethodBeat.o(77908);
                            return true;
                        } catch (Exception e3) {
                            e = e3;
                            obj = inputStream;
                            try {
                                ab.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bo.l(e));
                                if (a2 != null) {
                                    try {
                                        a2.connection.disconnect();
                                    } catch (Exception e222) {
                                        ab.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bo.l(e222));
                                        ab.e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e222.getMessage());
                                    }
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                AppMethodBeat.o(77908);
                                return true;
                            } catch (Throwable th) {
                                e = th;
                                if (a2 != null) {
                                }
                                if (inputStream2 != null) {
                                }
                                if (outputStream != null) {
                                }
                                AppMethodBeat.o(77908);
                                throw e;
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            obj = inputStream;
                            if (a2 != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            if (outputStream != null) {
                            }
                            AppMethodBeat.o(77908);
                            throw e;
                        }
                    }
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    OutputStream L = com.tencent.mm.vfs.e.L(this.frI, false);
                    int i = 0;
                    while (true) {
                        try {
                            int read = inputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            L.write(bArr, 0, read);
                            i += read;
                        } catch (Exception e4) {
                            e = e4;
                            outputStream = L;
                        } catch (Throwable th3) {
                            e = th3;
                            outputStream = L;
                            if (a2 != null) {
                                try {
                                    a2.connection.disconnect();
                                } catch (Exception e5) {
                                    ab.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bo.l(e5));
                                    ab.e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e5.getMessage());
                                    AppMethodBeat.o(77908);
                                    throw e;
                                }
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            AppMethodBeat.o(77908);
                            throw e;
                        }
                    }
                    if (i == a2.getHeaderFieldInt("Size", a2.connection.getContentLength())) {
                        this.aAR = false;
                    } else {
                        ab.e("MicroMsg.GetHDHeadImgHelper", "download size error. %d, %s, %d", Integer.valueOf(i), a2.getHeaderField("Size"), Integer.valueOf(a2.connection.getContentLength()));
                    }
                    try {
                        a2.connection.disconnect();
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (L != null) {
                            L.close();
                        }
                    } catch (Exception e2222) {
                        ab.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bo.l(e2222));
                        ab.e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e2222.getMessage());
                    }
                    AppMethodBeat.o(77908);
                    return true;
                } catch (Exception e6) {
                    e = e6;
                    inputStream2 = inputStream;
                    obj = inputStream;
                    ab.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bo.l(e));
                    if (a2 != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.o(77908);
                    return true;
                } catch (Throwable th4) {
                    e = th4;
                    inputStream2 = inputStream;
                    obj = inputStream;
                    if (a2 != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.o(77908);
                    throw e;
                }
            } catch (Exception e7) {
                e = e7;
                inputStream2 = inputStream;
                obj = inputStream;
                Object obj2 = inputStream;
            } catch (Throwable th5) {
                e = th5;
                inputStream2 = inputStream;
                outputStream = inputStream;
                a2 = inputStream;
                if (a2 != null) {
                }
                if (inputStream2 != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.o(77908);
                throw e;
            }
        }

        public final boolean acg() {
            AppMethodBeat.i(77909);
            if (e.this.frF) {
                AppMethodBeat.o(77909);
                return false;
            } else if (this.aAR || bo.isNullOrNil(this.frH)) {
                e.this.frD.cr(4, -1);
                AppMethodBeat.o(77909);
                return false;
            } else {
                ab.d("MicroMsg.GetHDHeadImgHelper", "dkavatar user:" + this.frs.getUsername() + " urltime:" + this.frK.Mr());
                if (com.tencent.mm.model.ao.a.flv != null) {
                    com.tencent.mm.model.ao.a.flv.cm((int) com.tencent.mm.vfs.e.asZ(this.frI), 0);
                }
                e.this.frG.e(new a(e.this.fro, this.frH, this.frI));
                AppMethodBeat.o(77909);
                return true;
            }
        }
    }

    public interface c {
        int cr(int i, int i2);
    }

    public e() {
        AppMethodBeat.i(77910);
        g.Rg().a(158, (f) this);
        AppMethodBeat.o(77910);
    }

    public final void ach() {
        AppMethodBeat.i(77911);
        g.Rg().b(158, (f) this);
        AppMethodBeat.o(77911);
    }

    public final int a(String str, c cVar) {
        AppMethodBeat.i(77912);
        Assert.assertTrue("GetHDHeadImg must set callback", true);
        if (bo.isNullOrNil(str)) {
            cVar.cr(3, XWalkUpdater.ERROR_SET_VERNUM);
            AppMethodBeat.o(77912);
            return XWalkUpdater.ERROR_SET_VERNUM;
        }
        String aoC;
        this.frD = cVar;
        if (ad.mR(str)) {
            aoC = ad.aoC(str);
        } else {
            aoC = str;
        }
        this.fro = o.act().qo(aoC);
        ab.d("MicroMsg.GetHDHeadImgHelper", "GetHDHeadImg: %s", aoC);
        if (this.fro == null || !this.fro.getUsername().equals(aoC)) {
            this.fro = new h();
            this.fro.username = aoC;
        }
        if (bo.isNullOrNil(this.fro.ack())) {
            ab.w("MicroMsg.GetHDHeadImgHelper", "dkhurl [%s] has NO URL flag:%d !", str, Integer.valueOf(this.fro.dtR));
            this.frE = new k(aoC);
            if (g.Rg().a(this.frE, 0)) {
                AppMethodBeat.o(77912);
                return 0;
            }
            cVar.cr(3, ZipJNI.UNZ_PARAMERROR);
            AppMethodBeat.o(77912);
            return ZipJNI.UNZ_PARAMERROR;
        } else if (a(this.fro) == 0) {
            AppMethodBeat.o(77912);
            return 0;
        } else {
            cVar.cr(3, ZipJNI.UNZ_BADZIPFILE);
            AppMethodBeat.o(77912);
            return ZipJNI.UNZ_BADZIPFILE;
        }
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(77913);
        this.frD.cr(i, i2);
        AppMethodBeat.o(77913);
    }

    private int a(h hVar) {
        AppMethodBeat.i(77914);
        if (this.frG == null || this.frG.dpg()) {
            this.frG = new az(1, "get-hd-headimg", 1);
        }
        int e = this.frG.e(new b(hVar));
        AppMethodBeat.o(77914);
        return e;
    }
}
