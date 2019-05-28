package com.tencent.p177mm.pluginsdk.wallet;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.protocal.protobuf.biv;
import java.util.Map;

/* renamed from: com.tencent.mm.pluginsdk.wallet.b */
public interface C30158b extends C1694a {

    /* renamed from: com.tencent.mm.pluginsdk.wallet.b$a */
    public interface C30159a {
        /* renamed from: BD */
        void mo34551BD(String str);

        void onSuccess(String str);
    }

    /* renamed from: a */
    void mo48435a(Map<String, Object> map, String str, String str2, int i, C30159a c30159a);

    biv bQO();

    /* renamed from: eA */
    void mo48437eA(int i, int i2);

    /* renamed from: ex */
    Typeface mo48438ex(Context context);
}
