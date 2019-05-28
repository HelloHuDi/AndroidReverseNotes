package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.h;
import java.util.List;

public interface bd extends h {

    public interface a {
        void a(bd bdVar, ad adVar);
    }

    int F(String str, byte[] bArr);

    void W(ad adVar);

    boolean X(ad adVar);

    boolean Y(ad adVar);

    boolean Z(ad adVar);

    Cursor a(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2);

    Cursor a(List<String> list, String str, List<String> list2);

    Cursor a(String[] strArr, String str, String str2, List<String> list, List<String> list2);

    Cursor a(String[] strArr, String str, List<String> list);

    void a(a aVar);

    int aa(ad adVar);

    String aet();

    ad aoI(String str);

    boolean aoJ(String str);

    ad aoK(String str);

    Cursor aoL(String str);

    ad aoM(String str);

    ad aoN(String str);

    ad aoO(String str);

    long aoP(String str);

    boolean aoQ(String str);

    boolean aoR(String str);

    byte[] aoS(String str);

    int aoT(String str);

    int aoU(String str);

    String aoV(String str);

    int b(String str, ad adVar);

    int b(String[] strArr, String... strArr2);

    Cursor b(String str, String str2, List<String> list);

    Cursor b(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2);

    Cursor b(List<String> list, String str, List<String> list2);

    void b(a aVar);

    int[] b(String str, String str2, String str3, List<String> list);

    int[] b(String str, String str2, String[] strArr, List<String> list);

    int c(String str, ad adVar);

    int c(String[] strArr, String... strArr2);

    Cursor c(String str, String str2, List<String> list);

    Cursor c(List<String> list, String str, List<String> list2);

    int[] c(String str, String str2, String str3, List<String> list);

    int[] c(String str, String str2, String[] strArr, List<String> list);

    Cursor d(String str, String str2, List<String> list);

    void d(String str, ad adVar);

    Cursor dsF();

    Cursor dsG();

    Cursor dsH();

    List<String> dsq();

    List<String> dsr();

    Cursor dss();

    Cursor dst();

    Cursor dsu();

    Cursor dsv();

    int dsw();

    String e(String str, String str2, List<String> list);

    Cursor eA(List<String> list);

    Cursor eB(List<String> list);

    Cursor eC(List<String> list);

    Cursor eD(List<String> list);

    List<String> eE(List<String> list);

    int[] eF(List<String> list);

    int[] eG(List<String> list);

    Cursor eu(List<String> list);

    Cursor ev(List<String> list);

    Cursor ew(List<String> list);

    Cursor ex(List<String> list);

    Cursor k(List<String> list, boolean z);

    ad mQ(long j);
}
