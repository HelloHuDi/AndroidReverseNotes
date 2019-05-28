package com.tencent.ttpic.factory;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C25624m.C25628k;
import com.tencent.filter.C41672h;
import com.tencent.filter.p138a.C44654ab;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p1137a.C16516a;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.filter.ChannelSplitFilter;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.util.C36570e;
import com.tencent.util.C5989g;
import com.tencent.view.C16373c;
import com.tencent.view.C31128d;
import com.tencent.view.C41106g;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class TTPicFilterFactoryLocal {
    public static String LUT_DIR_ROOT = null;
    private static final String TAG = TTPicFilterFactoryLocal.class.getSimpleName();

    static {
        AppMethodBeat.m2504i(81933);
        AppMethodBeat.m2505o(81933);
    }

    public static void saveLutOrg() {
        AppMethodBeat.m2504i(81925);
        if (LUT_DIR_ROOT == null) {
            AppMethodBeat.m2505o(81925);
            return;
        }
        Bitmap preloadBaseLUTImage = preloadBaseLUTImage();
        if (preloadBaseLUTImage == null) {
            AppMethodBeat.m2505o(81925);
            return;
        }
        BitmapUtils.saveBitmap2PNG(preloadBaseLUTImage, LUT_DIR_ROOT + File.separator + "LUT_ORG.png");
        AppMethodBeat.m2505o(81925);
    }

    public static Bitmap preloadBaseLUTImage() {
        Bitmap createBitmap;
        AppMethodBeat.m2504i(81926);
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
        AppMethodBeat.m2505o(81926);
        return createBitmap;
    }

    public static BaseFilter lutFilterWithBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(81927);
        if (bitmap == null) {
            AppMethodBeat.m2505o(81927);
            return null;
        }
        BaseFilter c44654ab = new C44654ab();
        c44654ab.addParam(new C25628k("inputImageTexture2", bitmap, 33986, true));
        AppMethodBeat.m2505o(81927);
        return c44654ab;
    }

    public static BaseFilter lutFilterWithID(String str) {
        AppMethodBeat.m2504i(81928);
        if (LUT_DIR_ROOT == null) {
            AppMethodBeat.m2505o(81928);
            return null;
        }
        Bitmap bitmapFromEncryptedFile = getBitmapFromEncryptedFile(LUT_DIR_ROOT + File.separator + str + ".png2");
        if (bitmapFromEncryptedFile == null) {
            AppMethodBeat.m2505o(81928);
            return null;
        }
        BaseFilter c44654ab = new C44654ab();
        c44654ab.addParam(new C25628k("inputImageTexture2", bitmapFromEncryptedFile, 33986, true));
        AppMethodBeat.m2505o(81928);
        return c44654ab;
    }

    public static void filter2Image(final int i, final String str) {
        AppMethodBeat.m2504i(81929);
        if (LUT_DIR_ROOT == null) {
            AppMethodBeat.m2505o(81929);
            return;
        }
        C16373c.dSN().queue(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(81924);
                try {
                    Bitmap preloadBaseLUTImage = TTPicFilterFactoryLocal.preloadBaseLUTImage();
                    if (preloadBaseLUTImage == null) {
                        AppMethodBeat.m2505o(81924);
                        return;
                    }
                    int at = C41106g.m71543at(preloadBaseLUTImage);
                    C41672h c41672h = new C41672h();
                    BaseFilter createFilter = C16516a.createFilter(i);
                    createFilter.ApplyGLSLFilter(true, (float) preloadBaseLUTImage.getWidth(), (float) preloadBaseLUTImage.getHeight());
                    createFilter.RenderProcess(at, preloadBaseLUTImage.getWidth(), preloadBaseLUTImage.getHeight(), -1, 0.0d, c41672h);
                    C41672h c41672h2 = c41672h;
                    while (c41672h2.bJA != null && c41672h2.bJA.texture[0] != 0) {
                        c41672h2 = c41672h2.bJA;
                    }
                    BitmapUtils.saveBitmap2PNG(C41106g.m71541aK(c41672h2.texture[0], preloadBaseLUTImage.getWidth(), preloadBaseLUTImage.getHeight()), TTPicFilterFactoryLocal.LUT_DIR_ROOT + File.separator + str + ".png");
                    C36570e.m60597iF(TTPicFilterFactoryLocal.LUT_DIR_ROOT + File.separator + str + ".png", TTPicFilterFactoryLocal.LUT_DIR_ROOT + File.separator + str + ".png2");
                    new File(TTPicFilterFactoryLocal.LUT_DIR_ROOT + File.separator + str + ".png").delete();
                    C41106g.m71538Sk(at);
                    c41672h.clear();
                    createFilter.ClearGLSL();
                    AppMethodBeat.m2505o(81924);
                } catch (OutOfMemoryError e) {
                    AppMethodBeat.m2505o(81924);
                }
            }
        });
        AppMethodBeat.m2505o(81929);
    }

    public static BaseFilter creatFilterById(int i) {
        AppMethodBeat.m2504i(81930);
        if (LUT_DIR_ROOT == null) {
            AppMethodBeat.m2505o(81930);
            return null;
        }
        BaseFilter c44654ab;
        String str;
        switch (i) {
            case 215:
                c44654ab = new C44654ab();
                c44654ab.addParam(new C0936o("inputImageTexture2", "sh/fennen_lf.png", 33986));
                str = null;
                break;
            case 244:
                str = "MIC_PTU_ZIPAI_RICHRED";
                c44654ab = null;
                break;
            case C31128d.MIC_PTU_ZIPAI_LIGHTWHITE /*245*/:
                str = "MIC_PTU_ZIPAI_LIGHTWHITE";
                c44654ab = null;
                break;
            case C31128d.MIC_PTU_ZIPAI_FAIRYTALE /*246*/:
                str = "MIC_PTU_ZIPAI_FAIRYTALE";
                c44654ab = null;
                break;
            case 249:
                str = "MIC_PTU_ZIPAI_RICHBLUE";
                c44654ab = null;
                break;
            case 250:
                str = "MIC_PTU_ZIPAI_RICHYELLOW";
                c44654ab = null;
                break;
            case 252:
                c44654ab = new C44654ab();
                c44654ab.addParam(new C0936o("inputImageTexture2", "sh/tianbohe_lf.png", 33986));
                str = null;
                break;
            case C31128d.MIC_PTU_ZIPAI_OKINAWA /*253*/:
                c44654ab = new C44654ab();
                c44654ab.addParam(new C0936o("inputImageTexture2", "sh/fenbi_lf.png", 33986));
                str = null;
                break;
            case C31128d.MIC_PTU_ZIPAI_LIGHTRED /*254*/:
                str = "MIC_PTU_ZIPAI_LIGHTRED";
                c44654ab = null;
                break;
            case 255:
                c44654ab = new C44654ab();
                c44654ab.addParam(new C0936o("inputImageTexture2", "sh/chongsheng_lf.png", 33986));
                str = null;
                break;
            case 256:
                str = "MIC_PTU_ZIPAI_YOUNG";
                c44654ab = null;
                break;
            case C31128d.MIC_PTU_ZIPAI_TOKYO /*257*/:
                c44654ab = new C44654ab();
                c44654ab.addParam(new C0936o("inputImageTexture2", "sh/dongjing_lf.png", 33986));
                str = null;
                break;
            case C31128d.MIC_PTU_ZIPAI_SAPPORO /*258*/:
                c44654ab = new C44654ab();
                c44654ab.addParam(new C0936o("inputImageTexture2", "sh/zhahuang_lf.png", 33986));
                str = null;
                break;
            case C31128d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW /*267*/:
                str = "MIC_PTU_ZIPAI_GRADIENT_LIPNEW";
                c44654ab = null;
                break;
            case C31128d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI /*268*/:
                str = "MIC_PTU_ZIPAI_BLACKWHITEZIPAI";
                c44654ab = null;
                break;
            case 270:
                str = "MIC_PTU_ZIPAI_TEAMILK";
                c44654ab = null;
                break;
            case 271:
                str = "MIC_PTU_ZIPAI_LIGHT";
                c44654ab = null;
                break;
            case 273:
                str = "MIC_PTU_ZIPAI_MAPLERED";
                c44654ab = null;
                break;
            case 283:
                c44654ab = new C44654ab();
                c44654ab.addParam(new C0936o("inputImageTexture2", "sh/qiangwei_lf.png", 33986));
                str = null;
                break;
            case 285:
                c44654ab = new C44654ab();
                c44654ab.addParam(new C0936o("inputImageTexture2", "sh/xinye_lf.png", 33986));
                str = null;
                break;
            case 286:
                c44654ab = new C44654ab();
                c44654ab.addParam(new C0936o("inputImageTexture2", "sh/tangguomeigui_lf.png", 33986));
                str = null;
                break;
            case C31128d.MIC_PTU_SHUILIAN /*287*/:
                c44654ab = new C44654ab();
                c44654ab.addParam(new C0936o("inputImageTexture2", "sh/shuilian_lf.png", 33986));
                str = null;
                break;
            case C31128d.MIC_PTU_YOUJIALI /*288*/:
                c44654ab = new C44654ab();
                c44654ab.addParam(new C0936o("inputImageTexture2", "sh/youjiali_lf.png", 33986));
                str = null;
                break;
            case C31128d.MIC_PTU_ZIRAN /*289*/:
                c44654ab = new C44654ab();
                c44654ab.addParam(new C0936o("inputImageTexture2", "sh/ziran_lf.png", 33986));
                str = null;
                break;
            case 292:
                c44654ab = new C44654ab();
                c44654ab.addParam(new C0936o("inputImageTexture2", "sh/nuanyang_lf.png", 33986));
                str = null;
                break;
            case 293:
                str = "MIC_PTU_FBBS_LANGMAN";
                c44654ab = null;
                break;
            case 297:
                c44654ab = new C44654ab();
                c44654ab.addParam(new C0936o("inputImageTexture2", "sh/wuxia_lf.png", 33986));
                str = null;
                break;
            case 1000:
                c44654ab = new ChannelSplitFilter();
                str = null;
                break;
            default:
                str = null;
                c44654ab = null;
                break;
        }
        BaseFilter createFilter;
        if (c44654ab != null) {
            AppMethodBeat.m2505o(81930);
            return c44654ab;
        } else if (str == null) {
            createFilter = C16516a.createFilter(i);
            AppMethodBeat.m2505o(81930);
            return createFilter;
        } else {
            createFilter = lutFilterWithID(str);
            if (createFilter == null) {
                filter2Image(i, str);
                createFilter = C16516a.createFilter(i);
                AppMethodBeat.m2505o(81930);
                return createFilter;
            }
            AppMethodBeat.m2505o(81930);
            return createFilter;
        }
    }

    public static void clearLutFiles() {
        AppMethodBeat.m2504i(81931);
        if (LUT_DIR_ROOT == null) {
            AppMethodBeat.m2505o(81931);
            return;
        }
        FileUtils.delete(new File(LUT_DIR_ROOT));
        AppMethodBeat.m2505o(81931);
    }

    public static Bitmap getBitmapFromEncryptedFile(String str) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(81932);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(81932);
        } else {
            byte[] O;
            try {
                InputStream open;
                if (str.startsWith("assets://")) {
                    open = VideoGlobalContext.getContext().getAssets().open(FileUtils.getRealPath(str));
                } else {
                    open = new FileInputStream(str);
                }
                O = C36570e.m60594O(open);
                try {
                    C5989g.closeQuietly(open);
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                O = bitmap;
            }
            if (O == null) {
                AppMethodBeat.m2505o(81932);
            } else {
                Options options = new Options();
                options.inPreferredConfig = Config.ARGB_8888;
                try {
                    bitmap = BitmapFactory.decodeByteArray(O, 0, O.length, options);
                } catch (OutOfMemoryError e3) {
                }
                AppMethodBeat.m2505o(81932);
            }
        }
        return bitmap;
    }
}
