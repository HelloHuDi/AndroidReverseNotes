package android.support.v7.view;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mm.R;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.wxmm.v2helper;

public final class a {
    public Context mContext;

    public static a X(Context context) {
        return new a(context);
    }

    private a(Context context) {
        this.mContext = context;
    }

    public final int fY() {
        Configuration configuration = this.mContext.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600 || ((i > VideoFilterUtil.IMAGE_HEIGHT && i2 > 720) || (i > 720 && i2 > VideoFilterUtil.IMAGE_HEIGHT))) {
            return 5;
        }
        if (i >= 500 || ((i > 640 && i2 > 480) || (i > 480 && i2 > 640))) {
            return 4;
        }
        if (i >= v2helper.VOIP_ENC_HEIGHT_LV1) {
            return 3;
        }
        return 2;
    }

    public final boolean fZ() {
        return this.mContext.getResources().getBoolean(R.bool.a);
    }

    public final boolean ga() {
        return this.mContext.getApplicationInfo().targetSdkVersion < 14;
    }
}
