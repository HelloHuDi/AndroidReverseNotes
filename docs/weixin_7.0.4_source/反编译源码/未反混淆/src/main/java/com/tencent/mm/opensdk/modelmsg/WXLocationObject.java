package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;

public class WXLocationObject implements IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXLocationObject";
    public double lat;
    public double lng;

    public WXLocationObject() {
        this(0.0d, 0.0d);
    }

    public WXLocationObject(double d, double d2) {
        this.lat = d;
        this.lng = d2;
    }

    public boolean checkArgs() {
        return true;
    }

    public void serialize(Bundle bundle) {
        AppMethodBeat.i(128338);
        bundle.putDouble("_wxlocationobject_lat", this.lat);
        bundle.putDouble("_wxlocationobject_lng", this.lng);
        AppMethodBeat.o(128338);
    }

    public int type() {
        return 30;
    }

    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(128339);
        this.lat = bundle.getDouble("_wxlocationobject_lat");
        this.lng = bundle.getDouble("_wxlocationobject_lng");
        AppMethodBeat.o(128339);
    }
}
