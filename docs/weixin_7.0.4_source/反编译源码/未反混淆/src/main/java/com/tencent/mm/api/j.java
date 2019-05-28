package com.tencent.mm.api;

import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.buv;
import java.util.ArrayList;

public interface j extends a {
    void a(Intent intent, but but, int i);

    void a(Intent intent, buv buv, int i);

    boolean cJ(String str);

    ArrayList<String> cK(String str);
}
