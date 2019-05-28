package com.tencent.matrix.p156c;

import com.tencent.matrix.p155b.C6283b;
import org.json.JSONObject;

/* renamed from: com.tencent.matrix.c.b */
public final class C1062b {
    public Integer bWu;
    public JSONObject bWv;
    public C6283b bWw;
    public String key;
    public String tag;

    public C1062b(int i) {
        this.bWu = Integer.valueOf(i);
    }

    public C1062b(JSONObject jSONObject) {
        this.bWv = jSONObject;
    }

    public final String toString() {
        return String.format("tag[%s]type[%d];key[%s];content[%s]", new Object[]{this.tag, this.bWu, this.key, this.bWv});
    }
}
