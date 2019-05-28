package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;

public class WWMediaLink extends WWMediaObject {
    public String thumbUrl;
    public String webpageUrl;

    public final boolean checkArgs() {
        AppMethodBeat.m2504i(80501);
        if (!super.checkArgs()) {
            AppMethodBeat.m2505o(80501);
            return false;
        } else if (this.webpageUrl == null || this.webpageUrl.length() == 0 || this.webpageUrl.length() > 10240) {
            AppMethodBeat.m2505o(80501);
            return false;
        } else {
            AppMethodBeat.m2505o(80501);
            return true;
        }
    }

    public final void toBundle(Bundle bundle) {
        AppMethodBeat.m2504i(80502);
        bundle.putString("_wwwebpageobject_thumbUrl", this.thumbUrl);
        bundle.putString("_wwwebpageobject_webpageUrl", this.webpageUrl);
        super.toBundle(bundle);
        AppMethodBeat.m2505o(80502);
    }
}
