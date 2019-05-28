package com.tencent.p177mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3469e;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3470f;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.p603e.C4929h;
import com.tencent.p177mm.vending.p636b.C7358b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.storage.be */
public interface C7310be extends C4929h {

    /* renamed from: com.tencent.mm.storage.be$a */
    public interface C5132a {
        /* renamed from: a */
        void mo10531a(C7617ak c7617ak, C7310be c7310be);
    }

    /* renamed from: com.tencent.mm.storage.be$b */
    public interface C5133b {
        /* renamed from: a */
        String mo10532a(int i, String str, String str2, int i2, Context context);

        /* renamed from: a */
        void mo10533a(C7620bi c7620bi, PString pString, PString pString2, PInt pInt, boolean z);
    }

    /* renamed from: A */
    Cursor mo15764A(String str, List<String> list);

    /* renamed from: Cb */
    C5133b mo15765Cb();

    /* renamed from: MV */
    boolean mo15766MV(String str);

    /* renamed from: a */
    int mo15767a(C7617ak c7617ak, String str);

    /* renamed from: a */
    int mo15768a(C7617ak c7617ak, String str, boolean z);

    /* renamed from: a */
    Cursor mo15769a(String str, List<String> list, String str2, boolean z);

    /* renamed from: a */
    Cursor mo15770a(String str, List<String> list, boolean z, String str2);

    /* renamed from: a */
    Cursor mo15771a(ArrayList<String> arrayList, String str, List<String> list, String str2);

    /* renamed from: a */
    C7358b mo15772a(C3470f c3470f);

    /* renamed from: a */
    void mo15773a(C3469e c3469e);

    /* renamed from: a */
    void mo15774a(C7617ak c7617ak, int i, int i2);

    /* renamed from: a */
    void mo15775a(C5132a c5132a);

    /* renamed from: a */
    void mo15776a(C5133b c5133b);

    /* renamed from: a */
    boolean mo15777a(String str, int i, boolean z, int i2);

    /* renamed from: aF */
    void mo15778aF(LinkedList<String> linkedList);

    /* renamed from: ac */
    String mo15779ac(int i, String str);

    void aoX(String str);

    boolean aoY(String str);

    C7617ak aoZ(String str);

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

    C7617ak apn(String str);

    int apo(String str);

    void app(String str);

    void apq(String str);

    int apr(String str);

    /* renamed from: aq */
    void mo15801aq(C7620bi c7620bi);

    /* renamed from: b */
    void mo15802b(C6977h c6977h, C3460c c3460c);

    /* renamed from: b */
    void mo15803b(C5132a c5132a);

    /* renamed from: c */
    Cursor mo15804c(String str, List<String> list, String str2);

    /* renamed from: c */
    void mo15805c(C5132a c5132a);

    /* renamed from: c */
    void mo15806c(String[] strArr, String str);

    /* renamed from: d */
    long mo15807d(C7617ak c7617ak);

    /* renamed from: d */
    void mo15808d(C5132a c5132a);

    boolean dsJ();

    HashMap<String, Long> dsK();

    void dsL();

    List<String> dsN();

    List<String> dsO();

    Cursor dsP();

    int dsQ();

    String dsR();

    Cursor dsS();

    C7617ak dsT();

    Cursor dsU();

    /* renamed from: eo */
    Cursor mo15820eo(String str, int i);

    /* renamed from: f */
    boolean mo15821f(C7617ak c7617ak);

    /* renamed from: g */
    boolean mo15822g(C7617ak c7617ak);

    /* renamed from: ic */
    Cursor mo15823ic(String str, String str2);

    /* renamed from: nR */
    int mo15824nR(String str);

    /* renamed from: t */
    Cursor mo15825t(List<String> list, int i);
}
