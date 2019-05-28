package com.tencent.mm.ah;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cla;
import com.tencent.mm.protocal.protobuf.clb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.IOException;
import java.io.OutputStream;

public final class l extends m implements k {
    private int coc;
    private f ehi;
    private int frO;
    private int frP;
    private String fse;
    private String fsf;
    private String fsg = r.Yz();
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
    private static int aw(String str, String str2) {
        AppMethodBeat.i(77940);
        Options amj = d.amj(str);
        if (amj.outHeight >= 640 || amj.outWidth >= 640) {
            int indexOf;
            int intValue;
            int i;
            Options options;
            Bitmap decodeFile;
            int i2 = 50;
            try {
                if (at.isWifi(ah.getContext())) {
                    i2 = bo.getInt(((a) g.K(a.class)).Nu().getValue("HeadImageCompressPicLevelForWifi"), 50);
                } else if (at.is2G(ah.getContext())) {
                    i2 = bo.getInt(((a) g.K(a.class)).Nu().getValue("HeadImageCompressPicLevelFor2G"), 50);
                } else if (at.is3G(ah.getContext())) {
                    i2 = bo.getInt(((a) g.K(a.class)).Nu().getValue("HeadImageCompressPicLevelFor3G"), 50);
                } else {
                    i2 = bo.getInt(((a) g.K(a.class)).Nu().getValue("HeadImageCompressPicLevelFor4G"), 50);
                }
            } catch (Exception e) {
            }
            int i3 = 0;
            try {
                String value;
                if (at.isWifi(ah.getContext())) {
                    value = ((a) g.K(a.class)).Nu().getValue("HeadImageCompressResolutionForWifi");
                } else if (at.is2G(ah.getContext())) {
                    value = ((a) g.K(a.class)).Nu().getValue("HeadImageCompressResolutionFor2G");
                } else if (at.is3G(ah.getContext())) {
                    value = ((a) g.K(a.class)).Nu().getValue("HeadImageCompressResolutionFor3G");
                } else {
                    value = ((a) g.K(a.class)).Nu().getValue("HeadImageCompressResolutionFor4G");
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
                    ab.i("MicroMsg.NetSceneUploadHDHeadImg", "compressBG configLong:%d configShort:%d, CompressPicLevel-level:%d, srcW:%d, srcH:%d", Integer.valueOf(i), Integer.valueOf(intValue), Integer.valueOf(i2), Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
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
                    decodeFile = d.decodeFile(str, options);
                    if (decodeFile != null) {
                        ab.e("MicroMsg.NetSceneUploadHDHeadImg", "decode file fail %d", Integer.valueOf(options.inSampleSize));
                        intValue = 0 - com.tencent.mm.compatible.util.g.getLine();
                        AppMethodBeat.o(77940);
                        return intValue;
                    }
                    Bitmap createScaledBitmap;
                    ab.d("MicroMsg.NetSceneUploadHDHeadImg", "dest:w:%d h:%d", Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight()));
                    if (indexOf > 1) {
                        createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, i, intValue, true);
                        if (decodeFile != createScaledBitmap) {
                            ab.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", decodeFile.toString());
                            decodeFile.recycle();
                        }
                        if (createScaledBitmap == null) {
                            ab.e("MicroMsg.NetSceneUploadHDHeadImg", "Scale file fail");
                            intValue = 0 - com.tencent.mm.compatible.util.g.getLine();
                            AppMethodBeat.o(77940);
                            return intValue;
                        }
                    }
                    createScaledBitmap = decodeFile;
                    OutputStream outputStream = null;
                    try {
                        outputStream = e.L(str2, false);
                        createScaledBitmap.compress(CompressFormat.JPEG, i2, outputStream);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        ab.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s, fileSize:%d -> %d", createScaledBitmap.toString(), Long.valueOf(e.asZ(str)), Long.valueOf(e.asZ(str2)));
                        createScaledBitmap.recycle();
                        AppMethodBeat.o(77940);
                        return 0;
                    } catch (Exception e3) {
                        ab.e("MicroMsg.NetSceneUploadHDHeadImg", "open FileOutputStream fail");
                        ab.e("MicroMsg.NetSceneUploadHDHeadImg", "exception:%s", bo.l(e3));
                        ab.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", createScaledBitmap.toString());
                        createScaledBitmap.recycle();
                        intValue = 0 - com.tencent.mm.compatible.util.g.getLine();
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        AppMethodBeat.o(77940);
                        return intValue;
                    } catch (Throwable th) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        AppMethodBeat.o(77940);
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
            ab.i("MicroMsg.NetSceneUploadHDHeadImg", "compressBG configLong:%d configShort:%d, CompressPicLevel-level:%d, srcW:%d, srcH:%d", Integer.valueOf(i), Integer.valueOf(intValue), Integer.valueOf(i2), Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
            if (intValue <= 0) {
            }
            if (intValue * i > 10240000) {
            }
            options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            if (indexOf >= 2) {
            }
            decodeFile = d.decodeFile(str, options);
            if (decodeFile != null) {
            }
        } else {
            e.y(str, str2);
            ab.i("MicroMsg.NetSceneUploadHDHeadImg", "compressBG copySrc outHeight and outWidth: %d,%d , do not scale.", Integer.valueOf(amj.outHeight), Integer.valueOf(amj.outWidth));
            AppMethodBeat.o(77940);
            return 0;
        }
    }

    public l(String str) {
        AppMethodBeat.i(77941);
        o.acd();
        this.fse = d.D(this.fsg, true);
        String str2 = this.fse + ".tmp";
        if (aw(str, str2) == 0) {
            this.imgPath = str2;
            this.frP = 1;
            o.acd();
            this.fsf = com.tencent.mm.a.g.x(e.e(d.C(this.fsg, true), 0, -1));
            this.frO = 0;
            this.coc = 0;
        }
        AppMethodBeat.o(77941);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(77942);
        this.ehi = fVar;
        if (this.imgPath == null || this.imgPath.length() == 0) {
            ab.e("MicroMsg.NetSceneUploadHDHeadImg", "imgPath is null or length = 0");
            AppMethodBeat.o(77942);
            return -1;
        } else if (e.ct(this.imgPath)) {
            if (this.frO == 0) {
                this.frO = (int) e.asZ(this.imgPath);
            }
            byte[] e = e.e(this.imgPath, this.coc, Math.min(this.frO - this.coc, Utility.DEFAULT_STREAM_BUFFER_SIZE));
            if (e == null) {
                ab.e("MicroMsg.NetSceneUploadHDHeadImg", "readFromFile error");
                AppMethodBeat.o(77942);
                return -1;
            }
            ab.i("MicroMsg.NetSceneUploadHDHeadImg", "doScene uploadLen:%d, total: %d", Integer.valueOf(e.length), Integer.valueOf(this.frO));
            b.a aVar = new b.a();
            aVar.fsJ = new cla();
            aVar.fsK = new clb();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadhdheadimg";
            aVar.fsI = 157;
            aVar.fsL = 46;
            aVar.fsM = 1000000046;
            b acD = aVar.acD();
            cla cla = (cla) acD.fsG.fsP;
            cla.ptw = this.frO;
            cla.ptx = this.coc;
            cla.wpi = this.frP;
            cla.ptz = new SKBuiltinBuffer_t().setBuffer(e);
            cla.xiK = this.fsf;
            int a = a(eVar, acD, this);
            AppMethodBeat.o(77942);
            return a;
        } else {
            ab.e("MicroMsg.NetSceneUploadHDHeadImg", "The img does not exist, imgPath = " + this.imgPath);
            AppMethodBeat.o(77942);
            return -1;
        }
    }

    public final m.b b(q qVar) {
        AppMethodBeat.i(77943);
        m.b bVar;
        if (this.imgPath == null || this.imgPath.length() == 0) {
            bVar = m.b.EFailed;
            AppMethodBeat.o(77943);
            return bVar;
        }
        bVar = m.b.EOk;
        AppMethodBeat.o(77943);
        return bVar;
    }

    public final int acn() {
        return 200;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(77944);
        clb clb = (clb) ((b) qVar).fsH.fsP;
        ab.d("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + i2 + " errCode:" + i3);
        if (i2 != 4 && i3 != 0) {
            ab.e("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + i2 + " errCode:" + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(77944);
        } else if (i2 == 4 || i2 == 5) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            ab.e("MicroMsg.NetSceneUploadHDHeadImg", "ErrType:".concat(String.valueOf(i2)));
            AppMethodBeat.o(77944);
        } else {
            Object obj;
            if (qVar.ZS().vyl == -4) {
                ab.e("MicroMsg.NetSceneUploadHDHeadImg", "retcode == %d", Integer.valueOf(qVar.ZS().vyl));
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                ab.e("MicroMsg.NetSceneUploadHDHeadImg", "handleCertainError");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(77944);
                return;
            }
            this.coc = clb.ptx;
            if (this.coc < this.frO) {
                if (a(this.ftf, this.ehi) < 0) {
                    ab.e("MicroMsg.NetSceneUploadHDHeadImg", "doScene again failed");
                    this.ehi.onSceneEnd(3, -1, "", this);
                }
                ab.d("MicroMsg.NetSceneUploadHDHeadImg", "doScene again");
                AppMethodBeat.o(77944);
                return;
            }
            try {
                e.aQ(this.imgPath, this.fse);
                g.RP().Ry().set(12297, clb.xiL);
                o.acd().f(this.fsg, d.aml(this.fse));
                String Yz = r.Yz();
                if (!bo.isNullOrNil(Yz)) {
                    h hVar = new h();
                    hVar.username = Yz;
                    hVar.cB(true);
                    hVar.bJt = 32;
                    hVar.dtR = 3;
                    hVar.bJt = 34;
                    o.act().b(hVar);
                }
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(77944);
            } catch (Exception e) {
                ab.e("MicroMsg.NetSceneUploadHDHeadImg", "rename temp file failed :" + e.getMessage());
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(77944);
            }
        }
    }

    public final void cancel() {
        AppMethodBeat.i(77945);
        super.cancel();
        AppMethodBeat.o(77945);
    }

    public final int getType() {
        return 157;
    }
}
