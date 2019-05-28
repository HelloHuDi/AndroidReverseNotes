package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.mm.protocal.protobuf.biv;
import java.util.Map;

public interface b extends com.tencent.mm.kernel.c.a {

    public interface a {
        void BD(String str);

        void onSuccess(String str);
    }

    void a(Map<String, Object> map, String str, String str2, int i, a aVar);

    biv bQO();

    void eA(int i, int i2);

    Typeface ex(Context context);
}
