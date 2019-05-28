package com.tencent.ttpic.util;

import android.graphics.Bitmap;
import com.tencent.filter.FilterAlgorithm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.view.raw.FilterRawGet;
import com.tencent.view.raw.FilterRawGet.GetInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FilterUtils {
    private static final String TAG = FilterUtils.class.getSimpleName();
    public static boolean loadLibSuccessed = false;

    public static class FiltersGetInputStream implements GetInputStream {
        public InputStream getInputStream(String str) {
            InputStream open;
            AppMethodBeat.i(83911);
            String filterResPath = ResourcePathMapper.getFilterResPath(str);
            if (filterResPath == null) {
                try {
                    open = VideoGlobalContext.getContext().getAssets().open("raw" + File.separator + str);
                } catch (IOException e) {
                    AppMethodBeat.o(83911);
                    return null;
                } catch (Throwable th) {
                    AppMethodBeat.o(83911);
                }
            } else if (filterResPath.startsWith("assets://")) {
                open = VideoGlobalContext.getContext().getAssets().open(filterResPath.substring(filterResPath.lastIndexOf("assets://") + 9));
            } else {
                open = new FileInputStream(new File(filterResPath));
            }
            AppMethodBeat.o(83911);
            return open;
        }
    }

    static {
        AppMethodBeat.i(83914);
        checkLibraryInit();
        AppMethodBeat.o(83914);
    }

    public static void checkLibraryInit() {
        AppMethodBeat.i(83912);
        LogUtils.d(TAG, "[checkLibraryInit] + BEGIN");
        long currentTimeMillis = System.currentTimeMillis();
        if (!loadLibSuccessed) {
            try {
                System.loadLibrary("YTCommon");
                System.loadLibrary("image_filter_common");
                System.loadLibrary("image_filter_gpu");
                System.loadLibrary("format_convert");
                if (NativeProperty.hasNeonFeature()) {
                    System.loadLibrary("nnpack");
                    System.loadLibrary("YTFaceTrackPro");
                    System.loadLibrary("algo_youtu_jni");
                }
                loadLibSuccessed = true;
            } catch (UnsatisfiedLinkError e) {
                LogUtils.e(e);
                loadLibSuccessed = false;
            } catch (RuntimeException e2) {
                loadLibSuccessed = false;
                LogUtils.e(e2);
            } catch (Exception e3) {
                loadLibSuccessed = false;
                LogUtils.e(e3);
            }
        }
        FilterRawGet.setGetInputStream(new FiltersGetInputStream());
        LogUtils.d(TAG, "[checkLibraryInit] + END, time cost = " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(83912);
    }

    public static void drawBitmapWithBlendmode(Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i3) {
        AppMethodBeat.i(83913);
        FilterAlgorithm.nativeDrawBitmapWithBlendmode(bitmap, bitmap2, i, i2, i3);
        AppMethodBeat.o(83913);
    }
}
