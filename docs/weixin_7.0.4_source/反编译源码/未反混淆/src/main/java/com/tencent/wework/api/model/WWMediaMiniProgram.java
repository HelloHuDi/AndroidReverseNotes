package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;

public class WWMediaMiniProgram extends WWMediaObject {
    public byte[] ALI;
    public String iconUrl;
    public String name;
    public String path;
    public String title;
    public String username;

    public final boolean checkArgs() {
        AppMethodBeat.i(80511);
        if (!super.checkArgs()) {
            AppMethodBeat.o(80511);
            return false;
        } else if (this.username == null || this.username.length() <= 0) {
            AppMethodBeat.o(80511);
            return false;
        } else if (this.ALI == null || this.ALI.length <= 0 || this.ALI.length > 1048576) {
            AppMethodBeat.o(80511);
            return false;
        } else {
            AppMethodBeat.o(80511);
            return true;
        }
    }

    public final void toBundle(Bundle bundle) {
        AppMethodBeat.i(80512);
        bundle.putString("_wwwxaobject_userName", this.username);
        bundle.putString("_wwwxaobject_path", this.path == null ? "" : this.path);
        bundle.putString("_wwwxaobject_iconUrl", this.iconUrl == null ? "" : this.iconUrl);
        bundle.putString("_wwwxaobject_name", this.name == null ? "" : this.name);
        bundle.putString("_wwwxaobject_title", this.title == null ? "" : this.title);
        bundle.putByteArray("_wwwxaobject_hdImageData", this.ALI);
        super.toBundle(bundle);
        AppMethodBeat.o(80512);
    }
}
