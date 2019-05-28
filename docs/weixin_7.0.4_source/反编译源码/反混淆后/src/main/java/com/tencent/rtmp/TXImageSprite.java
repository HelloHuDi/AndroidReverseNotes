package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.liteav.basic.datareport.C8795a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.p1422a.C30922b;
import com.tencent.rtmp.p1422a.C44447a;
import java.util.List;

public class TXImageSprite implements C44447a {
    private Context mContext;
    private C44447a mImageSprite;

    public TXImageSprite(Context context) {
        AppMethodBeat.m2504i(65934);
        this.mContext = context.getApplicationContext();
        TXCDRApi.initCrashReport(context);
        AppMethodBeat.m2505o(65934);
    }

    public void setVTTUrlAndImageUrls(String str, List<String> list) {
        AppMethodBeat.m2504i(65935);
        if (this.mImageSprite != null) {
            release();
        }
        if (!(str == null || list == null || list.size() == 0)) {
            TXCDRApi.txReportDAU(this.mContext, C8795a.f2559bE);
            this.mImageSprite = new C30922b();
            this.mImageSprite.setVTTUrlAndImageUrls(str, list);
        }
        AppMethodBeat.m2505o(65935);
    }

    public Bitmap getThumbnail(float f) {
        AppMethodBeat.m2504i(65936);
        if (this.mImageSprite != null) {
            Bitmap thumbnail = this.mImageSprite.getThumbnail(f);
            AppMethodBeat.m2505o(65936);
            return thumbnail;
        }
        AppMethodBeat.m2505o(65936);
        return null;
    }

    public void release() {
        AppMethodBeat.m2504i(65937);
        if (this.mImageSprite != null) {
            this.mImageSprite.release();
            this.mImageSprite = null;
        }
        AppMethodBeat.m2505o(65937);
    }
}
