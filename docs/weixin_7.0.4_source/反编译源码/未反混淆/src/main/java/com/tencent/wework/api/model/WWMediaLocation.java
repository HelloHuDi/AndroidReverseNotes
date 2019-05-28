package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;

public class WWMediaLocation extends WWMediaObject {
    public double ALG;
    public String fBg;
    public double latitude;
    public double longitude;

    public final boolean checkArgs() {
        AppMethodBeat.i(80503);
        if (!super.checkArgs()) {
            AppMethodBeat.o(80503);
            return false;
        } else if (this.fBg == null || this.fBg.length() == 0 || this.fBg.length() > 10240) {
            AppMethodBeat.o(80503);
            return false;
        } else {
            AppMethodBeat.o(80503);
            return true;
        }
    }

    public final void toBundle(Bundle bundle) {
        AppMethodBeat.i(80504);
        bundle.putString("_wwlocobject_address", this.fBg);
        bundle.putDouble("_wwlocobject_longitude", this.longitude);
        bundle.putDouble("_wwlocobject_latitude", this.latitude);
        bundle.putDouble("_wwlocobject_zoom", this.ALG);
        super.toBundle(bundle);
        AppMethodBeat.o(80504);
    }
}
