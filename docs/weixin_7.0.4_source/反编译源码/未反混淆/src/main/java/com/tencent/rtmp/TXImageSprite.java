package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.a.a;
import com.tencent.rtmp.a.b;
import java.util.List;

public class TXImageSprite implements a {
    private Context mContext;
    private a mImageSprite;

    public TXImageSprite(Context context) {
        AppMethodBeat.i(65934);
        this.mContext = context.getApplicationContext();
        TXCDRApi.initCrashReport(context);
        AppMethodBeat.o(65934);
    }

    public void setVTTUrlAndImageUrls(String str, List<String> list) {
        AppMethodBeat.i(65935);
        if (this.mImageSprite != null) {
            release();
        }
        if (!(str == null || list == null || list.size() == 0)) {
            TXCDRApi.txReportDAU(this.mContext, com.tencent.liteav.basic.datareport.a.bE);
            this.mImageSprite = new b();
            this.mImageSprite.setVTTUrlAndImageUrls(str, list);
        }
        AppMethodBeat.o(65935);
    }

    public Bitmap getThumbnail(float f) {
        AppMethodBeat.i(65936);
        if (this.mImageSprite != null) {
            Bitmap thumbnail = this.mImageSprite.getThumbnail(f);
            AppMethodBeat.o(65936);
            return thumbnail;
        }
        AppMethodBeat.o(65936);
        return null;
    }

    public void release() {
        AppMethodBeat.i(65937);
        if (this.mImageSprite != null) {
            this.mImageSprite.release();
            this.mImageSprite = null;
        }
        AppMethodBeat.o(65937);
    }
}
