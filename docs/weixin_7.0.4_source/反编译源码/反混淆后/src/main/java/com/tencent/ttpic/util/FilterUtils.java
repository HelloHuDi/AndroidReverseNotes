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
            AppMethodBeat.m2504i(83911);
            String filterResPath = ResourcePathMapper.getFilterResPath(str);
            if (filterResPath == null) {
                try {
                    open = VideoGlobalContext.getContext().getAssets().open("raw" + File.separator + str);
                } catch (IOException e) {
                    AppMethodBeat.m2505o(83911);
                    return null;
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(83911);
                }
            } else if (filterResPath.startsWith("assets://")) {
                open = VideoGlobalContext.getContext().getAssets().open(filterResPath.substring(filterResPath.lastIndexOf("assets://") + 9));
            } else {
                open = new FileInputStream(new File(filterResPath));
            }
            AppMethodBeat.m2505o(83911);
            return open;
        }
    }

    static {
        AppMethodBeat.m2504i(83914);
        checkLibraryInit();
        AppMethodBeat.m2505o(83914);
    }

    public static void checkLibraryInit() {
        AppMethodBeat.m2504i(83912);
        LogUtils.m50199d(TAG, "[checkLibraryInit] + BEGIN");
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
                LogUtils.m50206e(e);
                loadLibSuccessed = false;
            } catch (RuntimeException e2) {
                loadLibSuccessed = false;
                LogUtils.m50206e(e2);
            } catch (Exception e3) {
                loadLibSuccessed = false;
                LogUtils.m50206e(e3);
            }
        }
        FilterRawGet.setGetInputStream(new FiltersGetInputStream());
        LogUtils.m50199d(TAG, "[checkLibraryInit] + END, time cost = " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(83912);
    }

    public static void drawBitmapWithBlendmode(Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i3) {
        AppMethodBeat.m2504i(83913);
        FilterAlgorithm.nativeDrawBitmapWithBlendmode(bitmap, bitmap2, i, i2, i3);
        AppMethodBeat.m2505o(83913);
    }
}
