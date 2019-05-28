package com.tencent.mm.plugin.sns.data;

public final class h {
    public int cNE;
    public String desc = "";
    public int fileSize = 0;
    public int filterId = 0;
    public int height = -1;
    public String path = "";
    public int qFX;
    public int qFY;
    public String qFZ = "";
    public String qGa = "";
    public String qGb = "";
    public boolean qGc = false;
    public String thumbPath = "";
    public int type;
    public int width = -1;

    public h(String str, int i) {
        this.path = str;
        this.type = i;
        this.cNE = -1;
    }

    public h(int i, int i2) {
        this.cNE = i;
        this.type = i2;
        this.path = "";
    }
}
