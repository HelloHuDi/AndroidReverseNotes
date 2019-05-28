package com.tencent.qqmusic.mediaplayer.seektable.flac;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class BytesUtil {
    public static int from(byte[] bArr) {
        AppMethodBeat.m2504i(128530);
        RuntimeException runtimeException;
        int i;
        if (bArr.length > 4) {
            runtimeException = new RuntimeException("bytes can't be greater than 32 bit!");
            AppMethodBeat.m2505o(128530);
            throw runtimeException;
        } else if (bArr.length == 3) {
            i = (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255);
            AppMethodBeat.m2505o(128530);
            return i;
        } else if (bArr.length == 2) {
            i = ((bArr[0] & 255) << 8) | (bArr[1] & 15);
            AppMethodBeat.m2505o(128530);
            return i;
        } else if (bArr.length == 1) {
            i = bArr[0] & 255;
            AppMethodBeat.m2505o(128530);
            return i;
        } else {
            runtimeException = new RuntimeException("bytes must be greater than 8 bit!");
            AppMethodBeat.m2505o(128530);
            throw runtimeException;
        }
    }
}
