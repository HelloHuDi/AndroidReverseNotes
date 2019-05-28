package com.tencent.ttpic.factory;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.a.a;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.a.ab;
import com.tencent.filter.h;
import com.tencent.filter.m.k;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.filter.ChannelSplitFilter;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.util.e;
import com.tencent.view.c;
import com.tencent.view.d;
import com.tencent.view.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class TTPicFilterFactoryLocal {
    public static String LUT_DIR_ROOT = null;
    private static final String TAG = TTPicFilterFactoryLocal.class.getSimpleName();

    static {
        AppMethodBeat.i(81933);
        AppMethodBeat.o(81933);
    }

    public static void saveLutOrg() {
        AppMethodBeat.i(81925);
        if (LUT_DIR_ROOT == null) {
            AppMethodBeat.o(81925);
            return;
        }
        Bitmap preloadBaseLUTImage = preloadBaseLUTImage();
        if (preloadBaseLUTImage == null) {
            AppMethodBeat.o(81925);
            return;
        }
        BitmapUtils.saveBitmap2PNG(preloadBaseLUTImage, LUT_DIR_ROOT + File.separator + "LUT_ORG.png");
        AppMethodBeat.o(81925);
    }

    public static Bitmap preloadBaseLUTImage() {
        Bitmap createBitmap;
        AppMethodBeat.i(81926);
        try {
            int i;
            byte[] bArr = new byte[1048576];
            byte[] bArr2 = new byte[64];
            for (i = 0; i < 64; i++) {
                bArr2[i] = (byte) Math.round(((float) i) * 4.047619f);
            }
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = i2 / 8;
                int i4 = i2 % 8;
                for (int i5 = 0; i5 < 64; i5++) {
                    int i6 = ((i4 * 64) * 4) + ((((i3 * 64) + i5) * 512) * 4);
                    for (i = 0; i < 64; i++) {
                        int i7 = i6 + 1;
                        bArr[i6] = bArr2[i];
                        i6 = i7 + 1;
                        bArr[i7] = bArr2[i5];
                        i7 = i6 + 1;
                        bArr[i6] = bArr2[i2];
                        i6 = i7 + 1;
                        bArr[i7] = (byte) -1;
                    }
                }
            }
            createBitmap = Bitmap.createBitmap(512, 512, Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        } catch (OutOfMemoryError e) {
            createBitmap = null;
        }
        AppMethodBeat.o(81926);
        return createBitmap;
    }

    public static BaseFilter lutFilterWithBitmap(Bitmap bitmap) {
        AppMethodBeat.i(81927);
        if (bitmap == null) {
            AppMethodBeat.o(81927);
            return null;
        }
        BaseFilter abVar = new ab();
        abVar.addParam(new k("inputImageTexture2", bitmap, 33986, true));
        AppMethodBeat.o(81927);
        return abVar;
    }

    public static BaseFilter lutFilterWithID(String str) {
        AppMethodBeat.i(81928);
        if (LUT_DIR_ROOT == null) {
            AppMethodBeat.o(81928);
            return null;
        }
        Bitmap bitmapFromEncryptedFile = getBitmapFromEncryptedFile(LUT_DIR_ROOT + File.separator + str + ".png2");
        if (bitmapFromEncryptedFile == null) {
            AppMethodBeat.o(81928);
            return null;
        }
        BaseFilter abVar = new ab();
        abVar.addParam(new k("inputImageTexture2", bitmapFromEncryptedFile, 33986, true));
        AppMethodBeat.o(81928);
        return abVar;
    }

    public static void filter2Image(final int i, final String str) {
        AppMethodBeat.i(81929);
        if (LUT_DIR_ROOT == null) {
            AppMethodBeat.o(81929);
            return;
        }
        c.dSN().queue(new Runnable() {
            public final void run() {
                AppMethodBeat.i(81924);
                try {
                    Bitmap preloadBaseLUTImage = TTPicFilterFactoryLocal.preloadBaseLUTImage();
                    if (preloadBaseLUTImage == null) {
                        AppMethodBeat.o(81924);
                        return;
                    }
                    int at = g.at(preloadBaseLUTImage);
                    h hVar = new h();
                    BaseFilter createFilter = a.createFilter(i);
                    createFilter.ApplyGLSLFilter(true, (float) preloadBaseLUTImage.getWidth(), (float) preloadBaseLUTImage.getHeight());
                    createFilter.RenderProcess(at, preloadBaseLUTImage.getWidth(), preloadBaseLUTImage.getHeight(), -1, 0.0d, hVar);
                    h hVar2 = hVar;
                    while (hVar2.bJA != null && hVar2.bJA.texture[0] != 0) {
                        hVar2 = hVar2.bJA;
                    }
                    BitmapUtils.saveBitmap2PNG(g.aK(hVar2.texture[0], preloadBaseLUTImage.getWidth(), preloadBaseLUTImage.getHeight()), TTPicFilterFactoryLocal.LUT_DIR_ROOT + File.separator + str + ".png");
                    e.iF(TTPicFilterFactoryLocal.LUT_DIR_ROOT + File.separator + str + ".png", TTPicFilterFactoryLocal.LUT_DIR_ROOT + File.separator + str + ".png2");
                    new File(TTPicFilterFactoryLocal.LUT_DIR_ROOT + File.separator + str + ".png").delete();
                    g.Sk(at);
                    hVar.clear();
                    createFilter.ClearGLSL();
                    AppMethodBeat.o(81924);
                } catch (OutOfMemoryError e) {
                    AppMethodBeat.o(81924);
                }
            }
        });
        AppMethodBeat.o(81929);
    }

    public static BaseFilter creatFilterById(int i) {
        AppMethodBeat.i(81930);
        if (LUT_DIR_ROOT == null) {
            AppMethodBeat.o(81930);
            return null;
        }
        BaseFilter abVar;
        String str;
        switch (i) {
            case 215:
                abVar = new ab();
                abVar.addParam(new o("inputImageTexture2", "sh/fennen_lf.png", 33986));
                str = null;
                break;
            case 244:
                str = "MIC_PTU_ZIPAI_RICHRED";
                abVar = null;
                break;
            case d.MIC_PTU_ZIPAI_LIGHTWHITE /*245*/:
                str = "MIC_PTU_ZIPAI_LIGHTWHITE";
                abVar = null;
                break;
            case d.MIC_PTU_ZIPAI_FAIRYTALE /*246*/:
                str = "MIC_PTU_ZIPAI_FAIRYTALE";
                abVar = null;
                break;
            case 249:
                str = "MIC_PTU_ZIPAI_RICHBLUE";
                abVar = null;
                break;
            case 250:
                str = "MIC_PTU_ZIPAI_RICHYELLOW";
                abVar = null;
                break;
            case 252:
                abVar = new ab();
                abVar.addParam(new o("inputImageTexture2", "sh/tianbohe_lf.png", 33986));
                str = null;
                break;
            case d.MIC_PTU_ZIPAI_OKINAWA /*253*/:
                abVar = new ab();
                abVar.addParam(new o("inputImageTexture2", "sh/fenbi_lf.png", 33986));
                str = null;
                break;
            case d.MIC_PTU_ZIPAI_LIGHTRED /*254*/:
                str = "MIC_PTU_ZIPAI_LIGHTRED";
                abVar = null;
                break;
            case 255:
                abVar = new ab();
                abVar.addParam(new o("inputImageTexture2", "sh/chongsheng_lf.png", 33986));
                str = null;
                break;
            case 256:
                str = "MIC_PTU_ZIPAI_YOUNG";
                abVar = null;
                break;
            case d.MIC_PTU_ZIPAI_TOKYO /*257*/:
                abVar = new ab();
                abVar.addParam(new o("inputImageTexture2", "sh/dongjing_lf.png", 33986));
                str = null;
                break;
            case d.MIC_PTU_ZIPAI_SAPPORO /*258*/:
                abVar = new ab();
                abVar.addParam(new o("inputImageTexture2", "sh/zhahuang_lf.png", 33986));
                str = null;
                break;
            case d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW /*267*/:
                str = "MIC_PTU_ZIPAI_GRADIENT_LIPNEW";
                abVar = null;
                break;
            case d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI /*268*/:
                str = "MIC_PTU_ZIPAI_BLACKWHITEZIPAI";
                abVar = null;
                break;
            case 270:
                str = "MIC_PTU_ZIPAI_TEAMILK";
                abVar = null;
                break;
            case 271:
                str = "MIC_PTU_ZIPAI_LIGHT";
                abVar = null;
                break;
            case 273:
                str = "MIC_PTU_ZIPAI_MAPLERED";
                abVar = null;
                break;
            case 283:
                abVar = new ab();
                abVar.addParam(new o("inputImageTexture2", "sh/qiangwei_lf.png", 33986));
                str = null;
                break;
            case 285:
                abVar = new ab();
                abVar.addParam(new o("inputImageTexture2", "sh/xinye_lf.png", 33986));
                str = null;
                break;
            case 286:
                abVar = new ab();
                abVar.addParam(new o("inputImageTexture2", "sh/tangguomeigui_lf.png", 33986));
                str = null;
                break;
            case d.MIC_PTU_SHUILIAN /*287*/:
                abVar = new ab();
                abVar.addParam(new o("inputImageTexture2", "sh/shuilian_lf.png", 33986));
                str = null;
                break;
            case d.MIC_PTU_YOUJIALI /*288*/:
                abVar = new ab();
                abVar.addParam(new o("inputImageTexture2", "sh/youjiali_lf.png", 33986));
                str = null;
                break;
            case d.MIC_PTU_ZIRAN /*289*/:
                abVar = new ab();
                abVar.addParam(new o("inputImageTexture2", "sh/ziran_lf.png", 33986));
                str = null;
                break;
            case 292:
                abVar = new ab();
                abVar.addParam(new o("inputImageTexture2", "sh/nuanyang_lf.png", 33986));
                str = null;
                break;
            case 293:
                str = "MIC_PTU_FBBS_LANGMAN";
                abVar = null;
                break;
            case 297:
                abVar = new ab();
                abVar.addParam(new o("inputImageTexture2", "sh/wuxia_lf.png", 33986));
                str = null;
                break;
            case 1000:
                abVar = new ChannelSplitFilter();
                str = null;
                break;
            default:
                str = null;
                abVar = null;
                break;
        }
        BaseFilter createFilter;
        if (abVar != null) {
            AppMethodBeat.o(81930);
            return abVar;
        } else if (str == null) {
            createFilter = a.createFilter(i);
            AppMethodBeat.o(81930);
            return createFilter;
        } else {
            createFilter = lutFilterWithID(str);
            if (createFilter == null) {
                filter2Image(i, str);
                createFilter = a.createFilter(i);
                AppMethodBeat.o(81930);
                return createFilter;
            }
            AppMethodBeat.o(81930);
            return createFilter;
        }
    }

    public static void clearLutFiles() {
        AppMethodBeat.i(81931);
        if (LUT_DIR_ROOT == null) {
            AppMethodBeat.o(81931);
            return;
        }
        FileUtils.delete(new File(LUT_DIR_ROOT));
        AppMethodBeat.o(81931);
    }

    public static Bitmap getBitmapFromEncryptedFile(String str) {
        Bitmap bitmap = null;
        AppMethodBeat.i(81932);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(81932);
        } else {
            byte[] O;
            try {
                InputStream open;
                if (str.startsWith("assets://")) {
                    open = VideoGlobalContext.getContext().getAssets().open(FileUtils.getRealPath(str));
                } else {
                    open = new FileInputStream(str);
                }
                O = e.O(open);
                try {
                    com.tencent.util.g.closeQuietly(open);
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                O = bitmap;
            }
            if (O == null) {
                AppMethodBeat.o(81932);
            } else {
                Options options = new Options();
                options.inPreferredConfig = Config.ARGB_8888;
                try {
                    bitmap = BitmapFactory.decodeByteArray(O, 0, O.length, options);
                } catch (OutOfMemoryError e3) {
                }
                AppMethodBeat.o(81932);
            }
        }
        return bitmap;
    }
}
