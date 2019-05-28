package com.tencent.qqmusic.mediaplayer.upstream;

import java.io.IOException;

public class SourceReadException extends Exception {
    private final String source;

    public SourceReadException(String str, String str2) {
        super(str);
        this.source = str2;
    }

    public SourceReadException(IOException iOException, String str) {
        super(iOException);
        this.source = str;
    }

    public String getSource() {
        return this.source;
    }
}
