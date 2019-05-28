package android.support.p069v7.view;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.p177mm.C25738R;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.wxmm.v2helper;

/* renamed from: android.support.v7.view.a */
public final class C0602a {
    public Context mContext;

    /* renamed from: X */
    public static C0602a m1303X(Context context) {
        return new C0602a(context);
    }

    private C0602a(Context context) {
        this.mContext = context;
    }

    /* renamed from: fY */
    public final int mo1481fY() {
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

    /* renamed from: fZ */
    public final boolean mo1482fZ() {
        return this.mContext.getResources().getBoolean(C25738R.bool.f11600a);
    }

    /* renamed from: ga */
    public final boolean mo1483ga() {
        return this.mContext.getApplicationInfo().targetSdkVersion < 14;
    }
}
