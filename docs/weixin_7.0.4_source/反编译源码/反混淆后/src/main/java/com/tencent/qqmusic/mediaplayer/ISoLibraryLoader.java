package com.tencent.qqmusic.mediaplayer;

public interface ISoLibraryLoader {
    String findLibPath(String str);

    boolean load(String str);
}
