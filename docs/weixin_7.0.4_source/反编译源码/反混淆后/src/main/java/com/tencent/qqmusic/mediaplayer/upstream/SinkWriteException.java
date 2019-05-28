package com.tencent.qqmusic.mediaplayer.upstream;

import java.io.IOException;

public class SinkWriteException extends Exception {
    public SinkWriteException(String str) {
        super(str);
    }

    public SinkWriteException(IOException iOException) {
        super(iOException);
    }
}
