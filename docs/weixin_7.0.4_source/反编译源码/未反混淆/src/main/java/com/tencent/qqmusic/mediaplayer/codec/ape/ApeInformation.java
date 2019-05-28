package com.tencent.qqmusic.mediaplayer.codec.ape;

import com.tencent.qqmusic.mediaplayer.AudioInformation;

public class ApeInformation extends AudioInformation {
    private String album;
    private int apeFileVersion;
    private String artist;
    private long blocks;
    private int compressionLevel;
    private int frames;
    private String title;
    private String writer;

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public long getBlocks() {
        return this.blocks;
    }

    public void setBlocks(long j) {
        this.blocks = j;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String str) {
        this.artist = str;
    }

    public String getWriter() {
        return this.writer;
    }

    public void setWriter(String str) {
        this.writer = str;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String str) {
        this.album = str;
    }
}
