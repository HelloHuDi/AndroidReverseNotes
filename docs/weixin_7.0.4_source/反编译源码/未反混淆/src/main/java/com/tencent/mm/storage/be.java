package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface be extends h {

    public interface a {
        void a(ak akVar, be beVar);
    }

    public interface b {
        String a(int i, String str, String str2, int i2, Context context);

        void a(bi biVar, PString pString, PString pString2, PInt pInt, boolean z);
    }

    Cursor A(String str, List<String> list);

    b Cb();

    boolean MV(String str);

    int a(ak akVar, String str);

    int a(ak akVar, String str, boolean z);

    Cursor a(String str, List<String> list, String str2, boolean z);

    Cursor a(String str, List<String> list, boolean z, String str2);

    Cursor a(ArrayList<String> arrayList, String str, List<String> list, String str2);

    com.tencent.mm.vending.b.b a(f fVar);

    void a(e eVar);

    void a(ak akVar, int i, int i2);

    void a(a aVar);

    void a(b bVar);

    boolean a(String str, int i, boolean z, int i2);

    void aF(LinkedList<String> linkedList);

    String ac(int i, String str);

    void aoX(String str);

    boolean aoY(String str);

    ak aoZ(String str);

    void apa(String str);

    boolean apb(String str);

    boolean apc(String str);

    boolean apd(String str);

    boolean ape(String str);

    boolean apf(String str);

    boolean apg(String str);

    boolean aph(String str);

    Cursor api(String str);

    Cursor apj(String str);

    Cursor apk(String str);

    int apl(String str);

    String apm(String str);

    ak apn(String str);

    int apo(String str);

    void app(String str);

    void apq(String str);

    int apr(String str);

    void aq(bi biVar);

    void b(com.tencent.mm.plugin.messenger.foundation.a.a.h hVar, c cVar);

    void b(a aVar);

    Cursor c(String str, List<String> list, String str2);

    void c(a aVar);

    void c(String[] strArr, String str);

    long d(ak akVar);

    void d(a aVar);

    boolean dsJ();

    HashMap<String, Long> dsK();

    void dsL();

    List<String> dsN();

    List<String> dsO();

    Cursor dsP();

    int dsQ();

    String dsR();

    Cursor dsS();

    ak dsT();

    Cursor dsU();

    Cursor eo(String str, int i);

    boolean f(ak akVar);

    boolean g(ak akVar);

    Cursor ic(String str, String str2);

    int nR(String str);

    Cursor t(List<String> list, int i);
}
