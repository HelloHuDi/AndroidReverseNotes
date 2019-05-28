package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.utils.Log;

public class WXVideoObject implements IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXVideoObject";
    public String videoLowBandUrl;
    public String videoUrl;

    public boolean checkArgs() {
        AppMethodBeat.i(128269);
        if ((this.videoUrl == null || this.videoUrl.length() == 0) && (this.videoLowBandUrl == null || this.videoLowBandUrl.length() == 0)) {
            Log.e(TAG, "both arguments are null");
            AppMethodBeat.o(128269);
            return false;
        } else if (this.videoUrl != null && this.videoUrl.length() > 10240) {
            Log.e(TAG, "checkArgs fail, videoUrl is too long");
            AppMethodBeat.o(128269);
            return false;
        } else if (this.videoLowBandUrl == null || this.videoLowBandUrl.length() <= 10240) {
            AppMethodBeat.o(128269);
            return true;
        } else {
            Log.e(TAG, "checkArgs fail, videoLowBandUrl is too long");
            AppMethodBeat.o(128269);
            return false;
        }
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.i(128267);
        bundle.putString("_wxvideoobject_videoUrl", this.videoUrl);
        bundle.putString("_wxvideoobject_videoLowBandUrl", this.videoLowBandUrl);
        AppMethodBeat.o(128267);
    }

    public int type() {
        return 4;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(128268);
        this.videoUrl = bundle.getString("_wxvideoobject_videoUrl");
        this.videoLowBandUrl = bundle.getString("_wxvideoobject_videoLowBandUrl");
        AppMethodBeat.o(128268);
    }
}
