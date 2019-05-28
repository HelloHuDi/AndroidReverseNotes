package com.tencent.mm.plugin.normsg.a;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.b.b;

public interface a {
    byte[] Am(int i);

    String An(int i);

    void Ao(int i);

    void TI(String str);

    void TJ(String str);

    void TK(String str);

    boolean TL(String str);

    byte[] TM(String str);

    void TN(String str);

    boolean TO(String str);

    byte[] TP(String str);

    String TQ(String str);

    void a(View view, Class<? extends b> cls);

    void a(String str, MotionEvent motionEvent);

    boolean a(int i, byte[] bArr, int i2, int i3, PInt pInt, PInt pInt2, PByteArray pByteArray);

    void ae(int i, int i2, int i3);

    boolean bVI();

    boolean bVL();

    boolean bVM();

    boolean bVN();

    String bVQ();

    boolean bVR();

    byte[] bVS();

    boolean c(Object obj, Class cls);

    boolean cg(Object obj);

    void fu(String str, String str2);

    String jE(boolean z);
}
