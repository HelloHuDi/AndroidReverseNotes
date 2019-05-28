package com.tencent.p177mm.plugin.brandservice.p1241a;

import android.content.Context;
import android.content.Intent;
import com.tencent.p177mm.kernel.p242c.C1694a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.a.b */
public interface C20023b extends C1694a {

    /* renamed from: com.tencent.mm.plugin.brandservice.a.b$a */
    public static class C20024a {
        public String message;
        public boolean success = false;
    }

    /* renamed from: FC */
    boolean mo6748FC(String str);

    /* renamed from: a */
    void mo6749a(String str, int i, int i2, Object... objArr);

    /* renamed from: a */
    boolean mo6750a(Context context, String str, int i, int i2, int i3, Intent intent);

    /* renamed from: a */
    boolean mo6751a(Context context, String str, int i, int i2, int i3, C20024a c20024a);

    /* renamed from: aU */
    void mo6752aU(List<String[]> list);

    boolean aVO();

    boolean aVP();

    String aVQ();

    void aVR();

    /* renamed from: i */
    void mo6757i(List<List<String>> list, int i);

    /* renamed from: rW */
    boolean mo6758rW(int i);

    /* renamed from: rX */
    void mo6759rX(int i);
}
