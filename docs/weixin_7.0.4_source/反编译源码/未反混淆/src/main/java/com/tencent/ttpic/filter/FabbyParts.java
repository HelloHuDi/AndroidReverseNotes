package com.tencent.ttpic.filter;

import java.util.List;

public class FabbyParts {
    private String audioFile;
    private List<FabbyMvPart> parts;

    public FabbyParts(List<FabbyMvPart> list, String str) {
        this.parts = list;
        this.audioFile = str;
    }

    public List<FabbyMvPart> getParts() {
        return this.parts;
    }

    public void setParts(List<FabbyMvPart> list) {
        this.parts = list;
    }

    public String getAudioFile() {
        return this.audioFile;
    }

    public void setAudioFile(String str) {
        this.audioFile = str;
    }
}
