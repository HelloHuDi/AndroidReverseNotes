package com.tencent.matrix.c;

import org.json.JSONObject;

public final class b {
    public Integer bWu;
    public JSONObject bWv;
    public com.tencent.matrix.b.b bWw;
    public String key;
    public String tag;

    public b(int i) {
        this.bWu = Integer.valueOf(i);
    }

    public b(JSONObject jSONObject) {
        this.bWv = jSONObject;
    }

    public final String toString() {
        return String.format("tag[%s]type[%d];key[%s];content[%s]", new Object[]{this.tag, this.bWu, this.key, this.bWv});
    }
}
