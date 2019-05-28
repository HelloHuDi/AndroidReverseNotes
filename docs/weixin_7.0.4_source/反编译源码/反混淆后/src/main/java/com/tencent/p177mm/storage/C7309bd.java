package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4929h;
import java.util.List;

/* renamed from: com.tencent.mm.storage.bd */
public interface C7309bd extends C4929h {

    /* renamed from: com.tencent.mm.storage.bd$a */
    public interface C5131a {
        /* renamed from: a */
        void mo10530a(C7309bd c7309bd, C7616ad c7616ad);
    }

    /* renamed from: F */
    int mo15698F(String str, byte[] bArr);

    /* renamed from: W */
    void mo15699W(C7616ad c7616ad);

    /* renamed from: X */
    boolean mo15700X(C7616ad c7616ad);

    /* renamed from: Y */
    boolean mo15701Y(C7616ad c7616ad);

    /* renamed from: Z */
    boolean mo15702Z(C7616ad c7616ad);

    /* renamed from: a */
    Cursor mo15703a(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2);

    /* renamed from: a */
    Cursor mo15704a(List<String> list, String str, List<String> list2);

    /* renamed from: a */
    Cursor mo15705a(String[] strArr, String str, String str2, List<String> list, List<String> list2);

    /* renamed from: a */
    Cursor mo15706a(String[] strArr, String str, List<String> list);

    /* renamed from: a */
    void mo15707a(C5131a c5131a);

    /* renamed from: aa */
    int mo15708aa(C7616ad c7616ad);

    String aet();

    C7616ad aoI(String str);

    boolean aoJ(String str);

    C7616ad aoK(String str);

    Cursor aoL(String str);

    C7616ad aoM(String str);

    C7616ad aoN(String str);

    C7616ad aoO(String str);

    long aoP(String str);

    boolean aoQ(String str);

    boolean aoR(String str);

    byte[] aoS(String str);

    int aoT(String str);

    int aoU(String str);

    String aoV(String str);

    /* renamed from: b */
    int mo15724b(String str, C7616ad c7616ad);

    /* renamed from: b */
    int mo15725b(String[] strArr, String... strArr2);

    /* renamed from: b */
    Cursor mo15726b(String str, String str2, List<String> list);

    /* renamed from: b */
    Cursor mo15727b(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2);

    /* renamed from: b */
    Cursor mo15728b(List<String> list, String str, List<String> list2);

    /* renamed from: b */
    void mo15729b(C5131a c5131a);

    /* renamed from: b */
    int[] mo15730b(String str, String str2, String str3, List<String> list);

    /* renamed from: b */
    int[] mo15731b(String str, String str2, String[] strArr, List<String> list);

    /* renamed from: c */
    int mo15732c(String str, C7616ad c7616ad);

    /* renamed from: c */
    int mo15733c(String[] strArr, String... strArr2);

    /* renamed from: c */
    Cursor mo15734c(String str, String str2, List<String> list);

    /* renamed from: c */
    Cursor mo15735c(List<String> list, String str, List<String> list2);

    /* renamed from: c */
    int[] mo15736c(String str, String str2, String str3, List<String> list);

    /* renamed from: c */
    int[] mo15737c(String str, String str2, String[] strArr, List<String> list);

    /* renamed from: d */
    Cursor mo15738d(String str, String str2, List<String> list);

    /* renamed from: d */
    void mo15739d(String str, C7616ad c7616ad);

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

    /* renamed from: e */
    String mo15750e(String str, String str2, List<String> list);

    /* renamed from: eA */
    Cursor mo15751eA(List<String> list);

    /* renamed from: eB */
    Cursor mo15752eB(List<String> list);

    /* renamed from: eC */
    Cursor mo15753eC(List<String> list);

    /* renamed from: eD */
    Cursor mo15754eD(List<String> list);

    /* renamed from: eE */
    List<String> mo15755eE(List<String> list);

    /* renamed from: eF */
    int[] mo15756eF(List<String> list);

    /* renamed from: eG */
    int[] mo15757eG(List<String> list);

    /* renamed from: eu */
    Cursor mo15758eu(List<String> list);

    /* renamed from: ev */
    Cursor mo15759ev(List<String> list);

    /* renamed from: ew */
    Cursor mo15760ew(List<String> list);

    /* renamed from: ex */
    Cursor mo15761ex(List<String> list);

    /* renamed from: k */
    Cursor mo15762k(List<String> list, boolean z);

    /* renamed from: mQ */
    C7616ad mo15763mQ(long j);
}
