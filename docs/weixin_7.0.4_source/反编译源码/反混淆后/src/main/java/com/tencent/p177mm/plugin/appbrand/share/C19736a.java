package com.tencent.p177mm.plugin.appbrand.share;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p222g.C1434a;
import com.tencent.p177mm.modelappbrand.C32809i.C32807a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37924e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5061l;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.appbrand.share.a */
public final class C19736a implements C37924e {
    public C32807a iDJ = C32807a.DECODE_TYPE_DEFAULT;
    private int mHeight;
    private int mWidth;

    public C19736a(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    /* renamed from: v */
    public final Bitmap mo34970v(InputStream inputStream) {
        AppMethodBeat.m2504i(132734);
        C4990ab.m7411d("MicroMsg.AppBrand.BitmapDecoderImpl", "decode type: %d.", Integer.valueOf(this.iDJ.ordinal()));
        try {
            if (!inputStream.markSupported()) {
                if (inputStream instanceof FileInputStream) {
                    inputStream = new C5061l((FileInputStream) inputStream);
                } else if (!inputStream.markSupported()) {
                    inputStream = new BufferedInputStream(inputStream);
                }
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            inputStream.mark(8388608);
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            inputStream.reset();
            if (decodeStream != null) {
                C4990ab.m7417i("MicroMsg.AppBrand.BitmapDecoderImpl", "bitmap recycle %s", decodeStream);
                decodeStream.recycle();
            }
            if (options.outHeight <= 0 || options.outWidth <= 0) {
                C4990ab.m7413e("MicroMsg.AppBrand.BitmapDecoderImpl", "decode[%s] error, outHeight[%d] outWidth[%d]", inputStream, Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.m2505o(132734);
                return null;
            }
            options.inSampleSize = (int) ((((double) options.outWidth) * 1.0d) / ((double) this.mWidth));
            if (options.inSampleSize <= 1) {
                options.inSampleSize = 1;
            }
            while (((options.outHeight * options.outWidth) / options.inSampleSize) / options.inSampleSize > 2764800) {
                options.inSampleSize++;
            }
            options.inJustDecodeBounds = false;
            options.inMutable = true;
            float f = ((float) options.outWidth) / ((float) options.outHeight);
            float f2 = ((float) this.mWidth) / ((float) this.mHeight);
            switch (this.iDJ) {
                case DECODE_TYPE_DEFAULT:
                    int i;
                    int i2;
                    if (f > f2) {
                        i = (int) (((((float) options.outHeight) * 1.0f) * ((float) this.mWidth)) / ((float) this.mHeight));
                        i2 = options.outHeight;
                    } else {
                        i = options.outWidth;
                        i2 = (int) (((((float) options.outWidth) * 1.0f) * ((float) this.mHeight)) / ((float) this.mWidth));
                    }
                    decodeStream = BitmapRegionDecoder.newInstance(inputStream, false).decodeRegion(new Rect(0, 0, i, i2), options);
                    if (decodeStream == null) {
                        C4990ab.m7413e("MicroMsg.AppBrand.BitmapDecoderImpl", "get null result using RegionDecoder, origin[%dx%d], desire[%dx%d]", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i), Integer.valueOf(i2));
                        try {
                            inputStream.reset();
                            decodeStream = C1434a.decodeStream(inputStream, null, options);
                            break;
                        } catch (IOException | OutOfMemoryError e2) {
                            C4990ab.printErrStackTrace("MicroMsg.AppBrand.BitmapDecoderImpl", e2, "fallback using BitmapFactory", new Object[0]);
                            break;
                        }
                    }
                    break;
                case DECODE_TYPE_ORIGIN:
                    decodeStream = C1434a.decodeStream(inputStream, null, options);
                    break;
                default:
                    decodeStream = null;
                    break;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
            AppMethodBeat.m2505o(132734);
            return decodeStream;
        } catch (IOException e4) {
            C4990ab.m7413e("MicroMsg.AppBrand.BitmapDecoderImpl", "%s", e4);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.m2505o(132734);
            return null;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.m2505o(132734);
        }
    }

    /* renamed from: wP */
    public final String mo6523wP() {
        AppMethodBeat.m2504i(132735);
        String format = String.format("Decoder_w%s_h%s", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)});
        AppMethodBeat.m2505o(132735);
        return format;
    }
}
