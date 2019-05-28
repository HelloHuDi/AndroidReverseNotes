package com.tencent.mm.plugin.s.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import java.util.LinkedList;

public interface a {

    public static class a {
        private static a pbA = null;

        public static void a(a aVar) {
            pbA = aVar;
        }

        public static a bYQ() {
            return pbA;
        }
    }

    f Uq(String str);

    f Ur(String str);

    void Us(String str);

    Bitmap a(String str, int i, float f);

    void ah(LinkedList<String> linkedList);

    Cursor bYN();

    i bYO();

    Cursor bYP();

    void c(f fVar);

    void cN(String str, int i);

    void d(f fVar);

    void e(f fVar);

    Cursor eQ(int i, int i2);

    Cursor x(int[] iArr);
}
