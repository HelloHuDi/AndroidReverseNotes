package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.File;

public class WWMediaMessage extends WWBaseMessage {
    public String description;
    public byte[] thumbData;
    public String title;

    public static abstract class WWMediaObject extends WWMediaMessage {
        protected static int getFileSize(String str) {
            if (!(str == null || str.length() == 0)) {
                File file = new File(str);
                if (file.exists()) {
                    return (int) file.length();
                }
            }
            return 0;
        }
    }

    public void toBundle(Bundle bundle) {
        AppMethodBeat.i(80509);
        super.toBundle(bundle);
        bundle.putString("_wwobject_title", this.title);
        bundle.putString("_wwobject_description", this.description);
        bundle.putByteArray("_wwobject_thumbdata", this.thumbData);
        AppMethodBeat.o(80509);
    }

    public boolean checkArgs() {
        AppMethodBeat.i(80510);
        if (this.thumbData != null && this.thumbData.length > 32768) {
            AppMethodBeat.o(80510);
            return false;
        } else if (this.title != null && this.title.length() > 512) {
            AppMethodBeat.o(80510);
            return false;
        } else if (this.description == null || this.description.length() <= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            AppMethodBeat.o(80510);
            return true;
        } else {
            AppMethodBeat.o(80510);
            return false;
        }
    }
}
