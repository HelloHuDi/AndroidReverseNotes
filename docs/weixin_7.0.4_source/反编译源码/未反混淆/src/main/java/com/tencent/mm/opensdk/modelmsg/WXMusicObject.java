package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.utils.Log;

public class WXMusicObject implements IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXMusicObject";
    public String musicDataUrl;
    public String musicLowBandDataUrl;
    public String musicLowBandUrl;
    public String musicUrl;

    public boolean checkArgs() {
        AppMethodBeat.i(128279);
        if ((this.musicUrl == null || this.musicUrl.length() == 0) && (this.musicLowBandUrl == null || this.musicLowBandUrl.length() == 0)) {
            Log.e(TAG, "both arguments are null");
            AppMethodBeat.o(128279);
            return false;
        } else if (this.musicUrl != null && this.musicUrl.length() > 10240) {
            Log.e(TAG, "checkArgs fail, musicUrl is too long");
            AppMethodBeat.o(128279);
            return false;
        } else if (this.musicLowBandUrl == null || this.musicLowBandUrl.length() <= 10240) {
            AppMethodBeat.o(128279);
            return true;
        } else {
            Log.e(TAG, "checkArgs fail, musicLowBandUrl is too long");
            AppMethodBeat.o(128279);
            return false;
        }
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.i(128277);
        bundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
        bundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
        bundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
        bundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
        AppMethodBeat.o(128277);
    }

    public int type() {
        return 3;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(128278);
        this.musicUrl = bundle.getString("_wxmusicobject_musicUrl");
        this.musicLowBandUrl = bundle.getString("_wxmusicobject_musicLowBandUrl");
        this.musicDataUrl = bundle.getString("_wxmusicobject_musicDataUrl");
        this.musicLowBandDataUrl = bundle.getString("_wxmusicobject_musicLowBandDataUrl");
        AppMethodBeat.o(128278);
    }
}
