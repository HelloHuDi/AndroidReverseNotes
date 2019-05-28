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
        AppMethodBeat.m2504i(80499);
        if (!super.checkArgs()) {
            AppMethodBeat.m2505o(80499);
            return false;
        } else if ((this.fileData == null || this.fileData.length == 0) && (this.filePath == null || this.filePath.length() == 0)) {
            AppMethodBeat.m2505o(80499);
            return false;
        } else if (this.fileData != null && this.fileData.length > this.contentLengthLimit) {
            AppMethodBeat.m2505o(80499);
            return false;
        } else if (this.filePath == null || WWMediaObject.getFileSize(this.filePath) <= this.contentLengthLimit) {
            AppMethodBeat.m2505o(80499);
            return true;
        } else {
            AppMethodBeat.m2505o(80499);
            return false;
        }
    }

    public final void toBundle(Bundle bundle) {
        AppMethodBeat.m2504i(80500);
        bundle.putByteArray("_wwfileobject_fileData", this.fileData);
        bundle.putString("_wwfileobject_filePath", this.filePath);
        bundle.putString("_wwfileobject_fileName", this.fileName);
        super.toBundle(bundle);
        AppMethodBeat.m2505o(80500);
    }
}
