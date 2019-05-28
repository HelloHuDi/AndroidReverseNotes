package com.tencent.p177mm.p182ah;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cla;
import com.tencent.p177mm.protocal.protobuf.clb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.ah.l */
public final class C41735l extends C1207m implements C1918k {
    private int coc;
    private C1202f ehi;
    private int frO;
    private int frP;
    private String fse;
    private String fsf;
    private String fsg = C1853r.m3846Yz();
    private String imgPath;

    /* JADX WARNING: Removed duplicated region for block: B:62:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0132  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: aw */
    private static int m73545aw(String str, String str2) {
        AppMethodBeat.m2504i(77940);
        Options amj = C5056d.amj(str);
        if (amj.outHeight >= 640 || amj.outWidth >= 640) {
            int indexOf;
            int intValue;
            int i;
            Options options;
            Bitmap decodeFile;
            int i2 = 50;
            try {
                if (C5023at.isWifi(C4996ah.getContext())) {
                    i2 = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("HeadImageCompressPicLevelForWifi"), 50);
                } else if (C5023at.is2G(C4996ah.getContext())) {
                    i2 = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("HeadImageCompressPicLevelFor2G"), 50);
                } else if (C5023at.is3G(C4996ah.getContext())) {
                    i2 = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("HeadImageCompressPicLevelFor3G"), 50);
                } else {
                    i2 = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("HeadImageCompressPicLevelFor4G"), 50);
                }
            } catch (Exception e) {
            }
            int i3 = 0;
            try {
                String value;
                if (C5023at.isWifi(C4996ah.getContext())) {
                    value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("HeadImageCompressResolutionForWifi");
                } else if (C5023at.is2G(C4996ah.getContext())) {
                    value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("HeadImageCompressResolutionFor2G");
                } else if (C5023at.is3G(C4996ah.getContext())) {
                    value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("HeadImageCompressResolutionFor3G");
                } else {
                    value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("HeadImageCompressResolutionFor4G");
                }
                indexOf = value.indexOf("*");
                if (-1 != indexOf) {
                    i3 = Integer.valueOf(value.substring(0, indexOf)).intValue();
                    intValue = Integer.valueOf(value.substring(indexOf + 1)).intValue();
                    if (i3 > 0 && intValue <= 0) {
                        i = 0;
                        intValue = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
                    } else if (intValue < 2160) {
                        i = 0;
                        intValue = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
                    } else if (intValue > 0 || i3 <= 3240) {
                        i = i3;
                    } else {
                        i = 1620;
                        intValue = 0;
                    }
                    i3 = amj.outWidth <= amj.outHeight ? amj.outWidth : amj.outHeight;
                    indexOf = amj.outWidth >= amj.outHeight ? amj.outWidth : amj.outHeight;
                    C4990ab.m7417i("MicroMsg.NetSceneUploadHDHeadImg", "compressBG configLong:%d configShort:%d, CompressPicLevel-level:%d, srcW:%d, srcH:%d", Integer.valueOf(i), Integer.valueOf(intValue), Integer.valueOf(i2), Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                    if (intValue <= 0) {
                        int i4 = indexOf / intValue;
                        i = (intValue * amj.outWidth) / indexOf;
                        intValue = (amj.outHeight * intValue) / indexOf;
                        indexOf = i4;
                    } else {
                        indexOf = i3 / i;
                        intValue = (amj.outHeight * i) / i3;
                        i = (i * amj.outWidth) / i3;
                    }
                    if (intValue * i > 10240000) {
                        double sqrt = Math.sqrt(1.024E7d / ((double) (intValue * i)));
                        intValue = (int) (((double) intValue) / sqrt);
                        i = (int) (((double) i) / sqrt);
                    }
                    options = new Options();
                    options.inPreferredConfig = Config.ARGB_8888;
                    if (indexOf >= 2) {
                        options.inSampleSize = indexOf;
                    }
                    decodeFile = C5056d.decodeFile(str, options);
                    if (decodeFile != null) {
                        C4990ab.m7413e("MicroMsg.NetSceneUploadHDHeadImg", "decode file fail %d", Integer.valueOf(options.inSampleSize));
                        intValue = 0 - C1447g.getLine();
                        AppMethodBeat.m2505o(77940);
                        return intValue;
                    }
                    Bitmap createScaledBitmap;
                    C4990ab.m7411d("MicroMsg.NetSceneUploadHDHeadImg", "dest:w:%d h:%d", Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight()));
                    if (indexOf > 1) {
                        createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, i, intValue, true);
                        if (decodeFile != createScaledBitmap) {
                            C4990ab.m7417i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", decodeFile.toString());
                            decodeFile.recycle();
                        }
                        if (createScaledBitmap == null) {
                            C4990ab.m7412e("MicroMsg.NetSceneUploadHDHeadImg", "Scale file fail");
                            intValue = 0 - C1447g.getLine();
                            AppMethodBeat.m2505o(77940);
                            return intValue;
                        }
                    }
                    createScaledBitmap = decodeFile;
                    OutputStream outputStream = null;
                    try {
                        outputStream = C5730e.m8617L(str2, false);
                        createScaledBitmap.compress(CompressFormat.JPEG, i2, outputStream);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        C4990ab.m7417i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s, fileSize:%d -> %d", createScaledBitmap.toString(), Long.valueOf(C5730e.asZ(str)), Long.valueOf(C5730e.asZ(str2)));
                        createScaledBitmap.recycle();
                        AppMethodBeat.m2505o(77940);
                        return 0;
                    } catch (Exception e3) {
                        C4990ab.m7412e("MicroMsg.NetSceneUploadHDHeadImg", "open FileOutputStream fail");
                        C4990ab.m7413e("MicroMsg.NetSceneUploadHDHeadImg", "exception:%s", C5046bo.m7574l(e3));
                        C4990ab.m7417i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", createScaledBitmap.toString());
                        createScaledBitmap.recycle();
                        intValue = 0 - C1447g.getLine();
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        AppMethodBeat.m2505o(77940);
                        return intValue;
                    } catch (Throwable th) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        AppMethodBeat.m2505o(77940);
                    }
                }
            } catch (Exception e6) {
            }
            intValue = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
            if (i3 > 0) {
            }
            if (intValue < 2160) {
            }
            if (amj.outWidth <= amj.outHeight) {
            }
            if (amj.outWidth >= amj.outHeight) {
            }
            C4990ab.m7417i("MicroMsg.NetSceneUploadHDHeadImg", "compressBG configLong:%d configShort:%d, CompressPicLevel-level:%d, srcW:%d, srcH:%d", Integer.valueOf(i), Integer.valueOf(intValue), Integer.valueOf(i2), Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
            if (intValue <= 0) {
            }
            if (intValue * i > 10240000) {
            }
            options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            if (indexOf >= 2) {
            }
            decodeFile = C5056d.decodeFile(str, options);
            if (decodeFile != null) {
            }
        } else {
            C5730e.m8644y(str, str2);
            C4990ab.m7417i("MicroMsg.NetSceneUploadHDHeadImg", "compressBG copySrc outHeight and outWidth: %d,%d , do not scale.", Integer.valueOf(amj.outHeight), Integer.valueOf(amj.outWidth));
            AppMethodBeat.m2505o(77940);
            return 0;
        }
    }

    public C41735l(String str) {
        AppMethodBeat.m2504i(77941);
        C17884o.acd();
        this.fse = C41732d.m73515D(this.fsg, true);
        String str2 = this.fse + ".tmp";
        if (C41735l.m73545aw(str, str2) == 0) {
            this.imgPath = str2;
            this.frP = 1;
            C17884o.acd();
            this.fsf = C1178g.m2591x(C5730e.m8632e(C41732d.m73514C(this.fsg, true), 0, -1));
            this.frO = 0;
            this.coc = 0;
        }
        AppMethodBeat.m2505o(77941);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(77942);
        this.ehi = c1202f;
        if (this.imgPath == null || this.imgPath.length() == 0) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadHDHeadImg", "imgPath is null or length = 0");
            AppMethodBeat.m2505o(77942);
            return -1;
        } else if (C5730e.m8628ct(this.imgPath)) {
            if (this.frO == 0) {
                this.frO = (int) C5730e.asZ(this.imgPath);
            }
            byte[] e = C5730e.m8632e(this.imgPath, this.coc, Math.min(this.frO - this.coc, Utility.DEFAULT_STREAM_BUFFER_SIZE));
            if (e == null) {
                C4990ab.m7412e("MicroMsg.NetSceneUploadHDHeadImg", "readFromFile error");
                AppMethodBeat.m2505o(77942);
                return -1;
            }
            C4990ab.m7417i("MicroMsg.NetSceneUploadHDHeadImg", "doScene uploadLen:%d, total: %d", Integer.valueOf(e.length), Integer.valueOf(this.frO));
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new cla();
            c1196a.fsK = new clb();
            c1196a.uri = "/cgi-bin/micromsg-bin/uploadhdheadimg";
            c1196a.fsI = 157;
            c1196a.fsL = 46;
            c1196a.fsM = 1000000046;
            C7472b acD = c1196a.acD();
            cla cla = (cla) acD.fsG.fsP;
            cla.ptw = this.frO;
            cla.ptx = this.coc;
            cla.wpi = this.frP;
            cla.ptz = new SKBuiltinBuffer_t().setBuffer(e);
            cla.xiK = this.fsf;
            int a = mo4457a(c1902e, acD, this);
            AppMethodBeat.m2505o(77942);
            return a;
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneUploadHDHeadImg", "The img does not exist, imgPath = " + this.imgPath);
            AppMethodBeat.m2505o(77942);
            return -1;
        }
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(77943);
        C1206b c1206b;
        if (this.imgPath == null || this.imgPath.length() == 0) {
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(77943);
            return c1206b;
        }
        c1206b = C1206b.EOk;
        AppMethodBeat.m2505o(77943);
        return c1206b;
    }

    public final int acn() {
        return 200;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(77944);
        clb clb = (clb) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7410d("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + i2 + " errCode:" + i3);
        if (i2 != 4 && i3 != 0) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + i2 + " errCode:" + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(77944);
        } else if (i2 == 4 || i2 == 5) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            C4990ab.m7412e("MicroMsg.NetSceneUploadHDHeadImg", "ErrType:".concat(String.valueOf(i2)));
            AppMethodBeat.m2505o(77944);
        } else {
            Object obj;
            if (c1929q.mo5618ZS().vyl == -4) {
                C4990ab.m7413e("MicroMsg.NetSceneUploadHDHeadImg", "retcode == %d", Integer.valueOf(c1929q.mo5618ZS().vyl));
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                C4990ab.m7412e("MicroMsg.NetSceneUploadHDHeadImg", "handleCertainError");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(77944);
                return;
            }
            this.coc = clb.ptx;
            if (this.coc < this.frO) {
                if (mo4456a(this.ftf, this.ehi) < 0) {
                    C4990ab.m7412e("MicroMsg.NetSceneUploadHDHeadImg", "doScene again failed");
                    this.ehi.onSceneEnd(3, -1, "", this);
                }
                C4990ab.m7410d("MicroMsg.NetSceneUploadHDHeadImg", "doScene again");
                AppMethodBeat.m2505o(77944);
                return;
            }
            try {
                C5730e.m8623aQ(this.imgPath, this.fse);
                C1720g.m3536RP().mo5239Ry().set(12297, clb.xiL);
                C17884o.acd().mo67505f(this.fsg, C5056d.aml(this.fse));
                String Yz = C1853r.m3846Yz();
                if (!C5046bo.isNullOrNil(Yz)) {
                    C17880h c17880h = new C17880h();
                    c17880h.username = Yz;
                    c17880h.mo33385cB(true);
                    c17880h.bJt = 32;
                    c17880h.dtR = 3;
                    c17880h.bJt = 34;
                    C17884o.act().mo33391b(c17880h);
                }
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(77944);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.NetSceneUploadHDHeadImg", "rename temp file failed :" + e.getMessage());
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(77944);
            }
        }
    }

    public final void cancel() {
        AppMethodBeat.m2504i(77945);
        super.cancel();
        AppMethodBeat.m2505o(77945);
    }

    public final int getType() {
        return 157;
    }
}
