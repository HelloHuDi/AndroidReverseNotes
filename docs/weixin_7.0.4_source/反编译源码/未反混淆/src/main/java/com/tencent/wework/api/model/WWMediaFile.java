package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;

public class WWMediaFile extends WWMediaObject {
    public int contentLengthLimit = 104857600;
    public byte[] fileData;
    public String fileName;
    public String filePath;

    public final boolean checkArgs() {
        AppMethodBeat.i(80499);
        if (!super.checkArgs()) {
            AppMethodBeat.o(80499);
            return false;
        } else if ((this.fileData == null || this.fileData.length == 0) && (this.filePath == null || this.filePath.length() == 0)) {
            AppMethodBeat.o(80499);
            return false;
        } else if (this.fileData != null && this.fileData.length > this.contentLengthLimit) {
            AppMethodBeat.o(80499);
            return false;
        } else if (this.filePath == null || WWMediaObject.getFileSize(this.filePath) <= this.contentLengthLimit) {
            AppMethodBeat.o(80499);
            return true;
        } else {
            AppMethodBeat.o(80499);
            return false;
        }
    }

    public final void toBundle(Bundle bundle) {
        AppMethodBeat.i(80500);
        bundle.putByteArray("_wwfileobject_fileData", this.fileData);
        bundle.putString("_wwfileobject_filePath", this.filePath);
        bundle.putString("_wwfileobject_fileName", this.fileName);
        super.toBundle(bundle);
        AppMethodBeat.o(80500);
    }
}
