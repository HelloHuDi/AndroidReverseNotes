package com.tencent.mm.plugin.brandservice.a;

import android.content.Context;
import android.content.Intent;
import java.util.List;

public interface b extends com.tencent.mm.kernel.c.a {

    public static class a {
        public String message;
        public boolean success = false;
    }

    boolean FC(String str);

    void a(String str, int i, int i2, Object... objArr);

    boolean a(Context context, String str, int i, int i2, int i3, Intent intent);

    boolean a(Context context, String str, int i, int i2, int i3, a aVar);

    void aU(List<String[]> list);

    boolean aVO();

    boolean aVP();

    String aVQ();

    void aVR();

    void i(List<List<String>> list, int i);

    boolean rW(int i);

    void rX(int i);
}
