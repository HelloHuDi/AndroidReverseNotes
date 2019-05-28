package com.tencent.mm.plugin.appbrand.share;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.l;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class a implements e {
    public com.tencent.mm.modelappbrand.i.a iDJ = com.tencent.mm.modelappbrand.i.a.DECODE_TYPE_DEFAULT;
    private int mHeight;
    private int mWidth;

    public a(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public final Bitmap v(InputStream inputStream) {
        AppMethodBeat.i(132734);
        ab.d("MicroMsg.AppBrand.BitmapDecoderImpl", "decode type: %d.", Integer.valueOf(this.iDJ.ordinal()));
        try {
            if (!inputStream.markSupported()) {
                if (inputStream instanceof FileInputStream) {
                    inputStream = new l((FileInputStream) inputStream);
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
                ab.i("MicroMsg.AppBrand.BitmapDecoderImpl", "bitmap recycle %s", decodeStream);
                decodeStream.recycle();
            }
            if (options.outHeight <= 0 || options.outWidth <= 0) {
                ab.e("MicroMsg.AppBrand.BitmapDecoderImpl", "decode[%s] error, outHeight[%d] outWidth[%d]", inputStream, Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.o(132734);
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
                        ab.e("MicroMsg.AppBrand.BitmapDecoderImpl", "get null result using RegionDecoder, origin[%dx%d], desire[%dx%d]", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i), Integer.valueOf(i2));
                        try {
                            inputStream.reset();
                            decodeStream = com.tencent.mm.compatible.g.a.decodeStream(inputStream, null, options);
                            break;
                        } catch (IOException | OutOfMemoryError e2) {
                            ab.printErrStackTrace("MicroMsg.AppBrand.BitmapDecoderImpl", e2, "fallback using BitmapFactory", new Object[0]);
                            break;
                        }
                    }
                    break;
                case DECODE_TYPE_ORIGIN:
                    decodeStream = com.tencent.mm.compatible.g.a.decodeStream(inputStream, null, options);
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
            AppMethodBeat.o(132734);
            return decodeStream;
        } catch (IOException e4) {
            ab.e("MicroMsg.AppBrand.BitmapDecoderImpl", "%s", e4);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.o(132734);
            return null;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.o(132734);
        }
    }

    public final String wP() {
        AppMethodBeat.i(132735);
        String format = String.format("Decoder_w%s_h%s", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)});
        AppMethodBeat.o(132735);
        return format;
    }
}
