package com.tencent.p177mm.plugin.p500s.p501a;

import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.p177mm.pluginsdk.model.app.C35796i;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.s.a.a */
public interface C13114a {

    /* renamed from: com.tencent.mm.plugin.s.a.a$a */
    public static class C3753a {
        private static C13114a pbA = null;

        /* renamed from: a */
        public static void m6068a(C13114a c13114a) {
            pbA = c13114a;
        }

        public static C13114a bYQ() {
            return pbA;
        }
    }

    /* renamed from: Uq */
    C40439f mo25133Uq(String str);

    /* renamed from: Ur */
    C40439f mo25134Ur(String str);

    /* renamed from: Us */
    void mo25135Us(String str);

    /* renamed from: a */
    Bitmap mo25136a(String str, int i, float f);

    /* renamed from: ah */
    void mo25137ah(LinkedList<String> linkedList);

    Cursor bYN();

    C35796i bYO();

    Cursor bYP();

    /* renamed from: c */
    void mo25141c(C40439f c40439f);

    /* renamed from: cN */
    void mo25142cN(String str, int i);

    /* renamed from: d */
    void mo25143d(C40439f c40439f);

    /* renamed from: e */
    void mo25144e(C40439f c40439f);

    /* renamed from: eQ */
    Cursor mo25145eQ(int i, int i2);

    /* renamed from: x */
    Cursor mo25146x(int[] iArr);
}
