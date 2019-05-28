package com.tencent.p177mm.plugin.appbrand.luggage.p1227a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37924e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5061l;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.a.a */
public final class C27184a implements C37924e {
    private int height;
    private int left;
    private int top;
    private int width;

    public C27184a(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.width = i3;
        this.height = i4;
    }

    /* renamed from: v */
    public final Bitmap mo34970v(InputStream inputStream) {
        AppMethodBeat.m2504i(86977);
        try {
            if (this.width < 0 || this.height < 0) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.m2505o(86977);
                return null;
            }
            if (!inputStream.markSupported()) {
                if (inputStream instanceof FileInputStream) {
                    inputStream = new C5061l((FileInputStream) inputStream);
                } else if (!inputStream.markSupported()) {
                    inputStream = new BufferedInputStream(inputStream);
                }
            }
            Options options = new Options();
            options.inMutable = true;
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(inputStream, false);
            Bitmap decodeRegion = newInstance.decodeRegion(new Rect(this.left, this.top, this.left + this.width, this.top + this.height), options);
            newInstance.recycle();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.m2505o(86977);
            return decodeRegion;
        } catch (IOException e3) {
            C4990ab.m7413e("MicroMsg.AppBrand.BitmapRegionDecoderImpl", "%s", Log.getStackTraceString(e3));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
        } catch (IllegalArgumentException e5) {
            C4990ab.m7413e("MicroMsg.AppBrand.BitmapRegionDecoderImpl", "%s", Log.getStackTraceString(e5));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
        } catch (OutOfMemoryError e7) {
            C4990ab.m7413e("MicroMsg.AppBrand.BitmapRegionDecoderImpl", "%s", Log.getStackTraceString(e7));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e9) {
                }
            }
            AppMethodBeat.m2505o(86977);
        }
        AppMethodBeat.m2505o(86977);
        return null;
    }

    /* renamed from: wP */
    public final String mo6523wP() {
        AppMethodBeat.m2504i(86978);
        String format = String.format("Decoder_x%s_y%s_w%s_h%s", new Object[]{Integer.valueOf(this.left), Integer.valueOf(this.top), Integer.valueOf(this.width), Integer.valueOf(this.height)});
        AppMethodBeat.m2505o(86978);
        return format;
    }
}
