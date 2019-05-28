package com.tencent.p177mm.p182ah;

import android.annotation.SuppressLint;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.jni.utils.UtilsJni;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.network.C1936u;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.emoji.p725b.C27730c;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C23498az;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vfs.C5730e;
import java.io.InputStream;
import java.io.OutputStream;
import junit.framework.Assert;
import org.xwalk.core.XWalkUpdater;

/* renamed from: com.tencent.mm.ah.e */
public final class C41733e implements C1202f {
    C25750c frD = null;
    C41734k frE = null;
    boolean frF = false;
    C23498az frG = null;
    C17880h fro = null;

    /* renamed from: com.tencent.mm.ah.e$a */
    class C8916a implements C23499a {
        boolean aAR = true;
        String frH;
        String frI;
        C17880h fro;
        boolean frq;

        public C8916a(C17880h c17880h, String str, String str2) {
            this.fro = c17880h;
            this.frH = str;
            this.frI = str2;
            this.frq = false;
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(77905);
            if (this.frq) {
                C7060h.pYm.mo15419k(138, 61, 1);
                C4990ab.m7417i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt %s", this.frI);
                byte[] DecryptAvatar = UtilsJni.DecryptAvatar(C5730e.m8632e(this.frI, 0, -1));
                if (DecryptAvatar == null || DecryptAvatar.length <= 0) {
                    C7060h.pYm.mo15419k(138, 62, 1);
                    C4990ab.m7416i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt failed");
                    AppMethodBeat.m2505o(77905);
                    return true;
                }
                C5730e.deleteFile(this.frI);
                C5730e.m8624b(this.frI, DecryptAvatar, DecryptAvatar.length);
            }
            if (C5063r.amp(this.frI)) {
                C4990ab.m7416i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic start");
                C7060h.pYm.mo15419k(138, 63, 1);
                String str = this.frI + "_hevc";
                C5730e.m8623aQ(this.frI, str);
                C5730e.atc(this.frI);
                Uri asY = C5730e.asY(this.frI);
                Uri asY2 = C5730e.asY(str);
                if (asY == null || asY2 == null) {
                    C4990ab.m7417i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: uri is null %s, %s", asY, asY2);
                    AppMethodBeat.m2505o(77905);
                    return true;
                }
                String path = asY.getPath();
                int nativeWxam2Pic = ((C27730c) C1720g.m3528K(C27730c.class)).nativeWxam2Pic(asY2.getPath(), path);
                C5730e.deleteFile(str);
                if (nativeWxam2Pic != 0) {
                    C7060h.pYm.mo15419k(138, 64, 1);
                    C4990ab.m7416i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic failed");
                    AppMethodBeat.m2505o(77905);
                    return true;
                }
            }
            this.aAR = false;
            AppMethodBeat.m2505o(77905);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(77906);
            if (C41733e.this.frF) {
                AppMethodBeat.m2505o(77906);
                return false;
            } else if (this.aAR) {
                C41733e.this.frD.mo4442cr(3, -1);
                AppMethodBeat.m2505o(77906);
                return false;
            } else {
                C5730e.deleteFile(this.frH);
                C5730e.m8623aQ(this.frI, this.frH);
                C41734k.m73541av(this.frH, this.fro.getUsername());
                C41733e.this.frD.mo4442cr(0, 0);
                AppMethodBeat.m2505o(77906);
                return true;
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: com.tencent.mm.ah.e$b */
    class C8917b implements C23499a {
        public boolean aAR = true;
        public String frH = null;
        String frI;
        private C1446a frK;
        boolean frq = false;
        public C17880h frs = null;

        public C8917b(C17880h c17880h) {
            AppMethodBeat.m2504i(77907);
            this.frs = c17880h;
            C17884o.acd();
            this.frH = C41732d.m73514C(c17880h.getUsername(), true);
            this.frI = this.frH + ".tmp";
            this.frK = new C1446a();
            AppMethodBeat.m2505o(77907);
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
            AppMethodBeat.m2504i(77908);
            if (this.frs == null) {
                AppMethodBeat.m2505o(77908);
                return false;
            }
            String str;
            String ack = this.frs.ack();
            boolean biY = ((C27730c) C1720g.m3528K(C27730c.class)).biY();
            boolean a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_avatar_download_big_hevc, false);
            if (biY && a) {
                C4990ab.m7416i("MicroMsg.GetHDHeadImgHelper", "GetHeadImgObj: get hevc");
                if (ack.contains("?")) {
                    str = ack + "&tp=wxpic";
                } else {
                    str = ack + "?tp=wxpic";
                }
                C7060h.pYm.mo15419k(138, 60, 1);
            } else {
                str = ack;
            }
            ack = "";
            if (C1720g.m3534RN().mo5161QY()) {
                r2 = new Object[4];
                C1720g.m3534RN();
                r2[1] = C1183p.getString(C1668a.m3383QF());
                r2[2] = Integer.valueOf(C5023at.getNetTypeForStat(C4996ah.getContext()));
                r2[3] = Integer.valueOf(C5023at.getStrength(C4996ah.getContext()));
                ack = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r2);
            }
            C4990ab.m7411d("MicroMsg.GetHDHeadImgHelper", "dkreferer dkavatar user: %s referer: %s  url:%s", this.frs.getUsername(), ack, str);
            this.aAR = true;
            C1936u a2;
            InputStream inputStream2;
            try {
                a2 = C1897b.m4020a(str, null);
                try {
                    a2.setRequestMethod("GET");
                    a2.setRequestProperty("referer", ack);
                    a2.setConnectTimeout(5000);
                    a2.setReadTimeout(5000);
                    if (C1897b.m4017a(a2) != 0) {
                        C4990ab.m7413e("MicroMsg.GetHDHeadImgHelper", "checkHttpConnection failed! url:%s", str);
                        try {
                            a2.connection.disconnect();
                        } catch (Exception e2) {
                            C4990ab.m7413e("MicroMsg.GetHDHeadImgHelper", "exception:%s", C5046bo.m7574l(e2));
                            C4990ab.m7413e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e2.getMessage());
                        }
                        AppMethodBeat.m2505o(77908);
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
                            C4990ab.m7411d("MicroMsg.GetHDHeadImgHelper", "getInputStream failed. url:%s", str);
                            try {
                                a2.connection.disconnect();
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                            } catch (Exception e22) {
                                C4990ab.m7413e("MicroMsg.GetHDHeadImgHelper", "exception:%s", C5046bo.m7574l(e22));
                                C4990ab.m7413e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e22.getMessage());
                            }
                            AppMethodBeat.m2505o(77908);
                            return true;
                        } catch (Exception e3) {
                            e = e3;
                            obj = inputStream;
                            try {
                                C4990ab.m7413e("MicroMsg.GetHDHeadImgHelper", "exception:%s", C5046bo.m7574l(e));
                                if (a2 != null) {
                                    try {
                                        a2.connection.disconnect();
                                    } catch (Exception e222) {
                                        C4990ab.m7413e("MicroMsg.GetHDHeadImgHelper", "exception:%s", C5046bo.m7574l(e222));
                                        C4990ab.m7413e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e222.getMessage());
                                    }
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                AppMethodBeat.m2505o(77908);
                                return true;
                            } catch (Throwable th) {
                                e = th;
                                if (a2 != null) {
                                }
                                if (inputStream2 != null) {
                                }
                                if (outputStream != null) {
                                }
                                AppMethodBeat.m2505o(77908);
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
                            AppMethodBeat.m2505o(77908);
                            throw e;
                        }
                    }
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    OutputStream L = C5730e.m8617L(this.frI, false);
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
                                    C4990ab.m7413e("MicroMsg.GetHDHeadImgHelper", "exception:%s", C5046bo.m7574l(e5));
                                    C4990ab.m7413e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e5.getMessage());
                                    AppMethodBeat.m2505o(77908);
                                    throw e;
                                }
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            AppMethodBeat.m2505o(77908);
                            throw e;
                        }
                    }
                    if (i == a2.getHeaderFieldInt("Size", a2.connection.getContentLength())) {
                        this.aAR = false;
                    } else {
                        C4990ab.m7413e("MicroMsg.GetHDHeadImgHelper", "download size error. %d, %s, %d", Integer.valueOf(i), a2.getHeaderField("Size"), Integer.valueOf(a2.connection.getContentLength()));
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
                        C4990ab.m7413e("MicroMsg.GetHDHeadImgHelper", "exception:%s", C5046bo.m7574l(e2222));
                        C4990ab.m7413e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e2222.getMessage());
                    }
                    AppMethodBeat.m2505o(77908);
                    return true;
                } catch (Exception e6) {
                    e = e6;
                    inputStream2 = inputStream;
                    obj = inputStream;
                    C4990ab.m7413e("MicroMsg.GetHDHeadImgHelper", "exception:%s", C5046bo.m7574l(e));
                    if (a2 != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(77908);
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
                    AppMethodBeat.m2505o(77908);
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
                AppMethodBeat.m2505o(77908);
                throw e;
            }
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(77909);
            if (C41733e.this.frF) {
                AppMethodBeat.m2505o(77909);
                return false;
            } else if (this.aAR || C5046bo.isNullOrNil(this.frH)) {
                C41733e.this.frD.mo4442cr(4, -1);
                AppMethodBeat.m2505o(77909);
                return false;
            } else {
                C4990ab.m7410d("MicroMsg.GetHDHeadImgHelper", "dkavatar user:" + this.frs.getUsername() + " urltime:" + this.frK.mo4908Mr());
                if (C26417a.flv != null) {
                    C26417a.flv.mo44184cm((int) C5730e.asZ(this.frI), 0);
                }
                C41733e.this.frG.mo39163e(new C8916a(C41733e.this.fro, this.frH, this.frI));
                AppMethodBeat.m2505o(77909);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.ah.e$c */
    public interface C25750c {
        /* renamed from: cr */
        int mo4442cr(int i, int i2);
    }

    public C41733e() {
        AppMethodBeat.m2504i(77910);
        C1720g.m3540Rg().mo14539a(158, (C1202f) this);
        AppMethodBeat.m2505o(77910);
    }

    public final void ach() {
        AppMethodBeat.m2504i(77911);
        C1720g.m3540Rg().mo14546b(158, (C1202f) this);
        AppMethodBeat.m2505o(77911);
    }

    /* renamed from: a */
    public final int mo67507a(String str, C25750c c25750c) {
        AppMethodBeat.m2504i(77912);
        Assert.assertTrue("GetHDHeadImg must set callback", true);
        if (C5046bo.isNullOrNil(str)) {
            c25750c.mo4442cr(3, XWalkUpdater.ERROR_SET_VERNUM);
            AppMethodBeat.m2505o(77912);
            return XWalkUpdater.ERROR_SET_VERNUM;
        }
        String aoC;
        this.frD = c25750c;
        if (C7616ad.m13548mR(str)) {
            aoC = C7616ad.aoC(str);
        } else {
            aoC = str;
        }
        this.fro = C17884o.act().mo33392qo(aoC);
        C4990ab.m7411d("MicroMsg.GetHDHeadImgHelper", "GetHDHeadImg: %s", aoC);
        if (this.fro == null || !this.fro.getUsername().equals(aoC)) {
            this.fro = new C17880h();
            this.fro.username = aoC;
        }
        if (C5046bo.isNullOrNil(this.fro.ack())) {
            C4990ab.m7421w("MicroMsg.GetHDHeadImgHelper", "dkhurl [%s] has NO URL flag:%d !", str, Integer.valueOf(this.fro.dtR));
            this.frE = new C41734k(aoC);
            if (C1720g.m3540Rg().mo14541a(this.frE, 0)) {
                AppMethodBeat.m2505o(77912);
                return 0;
            }
            c25750c.mo4442cr(3, ZipJNI.UNZ_PARAMERROR);
            AppMethodBeat.m2505o(77912);
            return ZipJNI.UNZ_PARAMERROR;
        } else if (m73538a(this.fro) == 0) {
            AppMethodBeat.m2505o(77912);
            return 0;
        } else {
            c25750c.mo4442cr(3, ZipJNI.UNZ_BADZIPFILE);
            AppMethodBeat.m2505o(77912);
            return ZipJNI.UNZ_BADZIPFILE;
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(77913);
        this.frD.mo4442cr(i, i2);
        AppMethodBeat.m2505o(77913);
    }

    /* renamed from: a */
    private int m73538a(C17880h c17880h) {
        AppMethodBeat.m2504i(77914);
        if (this.frG == null || this.frG.dpg()) {
            this.frG = new C23498az(1, "get-hd-headimg", 1);
        }
        int e = this.frG.mo39163e(new C8917b(c17880h));
        AppMethodBeat.m2505o(77914);
        return e;
    }
}
