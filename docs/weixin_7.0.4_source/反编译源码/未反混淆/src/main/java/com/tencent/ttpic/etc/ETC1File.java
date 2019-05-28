package com.tencent.ttpic.etc;

import android.opengl.ETC1Util.ETC1Texture;

public class ETC1File {
    private String name;
    private ETC1Texture texutre;

    public ETC1File(String str, ETC1Texture eTC1Texture) {
        this.name = str;
        this.texutre = eTC1Texture;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public ETC1Texture getTexutre() {
        return this.texutre;
    }

    public void setTexutre(ETC1Texture eTC1Texture) {
        this.texutre = eTC1Texture;
    }
}
