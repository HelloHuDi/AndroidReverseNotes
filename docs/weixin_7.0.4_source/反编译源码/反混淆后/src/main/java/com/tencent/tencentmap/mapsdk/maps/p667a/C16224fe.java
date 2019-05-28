package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16222fd.C16223b;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16222fd.C5871a;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fe */
public class C16224fe {
    /* renamed from: a */
    int f3211a;
    /* renamed from: b */
    C16222fd f3212b;
    /* renamed from: c */
    C16222fd f3213c;
    /* renamed from: d */
    Interpolator f3214d;
    /* renamed from: e */
    ArrayList<C16222fd> f3215e = new ArrayList();
    /* renamed from: f */
    C36503fi f3216f;

    public /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(98874);
        C16224fe b = mo29280b();
        AppMethodBeat.m2505o(98874);
        return b;
    }

    public C16224fe(C16222fd... c16222fdArr) {
        AppMethodBeat.m2504i(98869);
        this.f3211a = c16222fdArr.length;
        this.f3215e.addAll(Arrays.asList(c16222fdArr));
        this.f3212b = (C16222fd) this.f3215e.get(0);
        this.f3213c = (C16222fd) this.f3215e.get(this.f3211a - 1);
        this.f3214d = this.f3213c.mo29277c();
        AppMethodBeat.m2505o(98869);
    }

    /* renamed from: a */
    public static C16224fe m24746a(double... dArr) {
        int i = 1;
        AppMethodBeat.m2504i(98870);
        int length = dArr.length;
        C5871a[] c5871aArr = new C5871a[Math.max(length, 2)];
        if (length == 1) {
            c5871aArr[0] = (C5871a) C16222fd.m24734a(0.0f);
            c5871aArr[1] = (C5871a) C16222fd.m24735a(1.0f, dArr[0]);
        } else {
            c5871aArr[0] = (C5871a) C16222fd.m24735a(0.0f, dArr[0]);
            while (i < length) {
                c5871aArr[i] = (C5871a) C16222fd.m24735a(((float) i) / ((float) (length - 1)), dArr[i]);
                i++;
            }
        }
        C46783fa c46783fa = new C46783fa(c5871aArr);
        AppMethodBeat.m2505o(98870);
        return c46783fa;
    }

    /* renamed from: a */
    public static C16224fe m24747a(Object... objArr) {
        int i = 1;
        AppMethodBeat.m2504i(98871);
        int length = objArr.length;
        C16223b[] c16223bArr = new C16223b[Math.max(length, 2)];
        if (length == 1) {
            c16223bArr[0] = (C16223b) C16222fd.m24737b(0.0f);
            c16223bArr[1] = (C16223b) C16222fd.m24736a(1.0f, objArr[0]);
        } else {
            c16223bArr[0] = (C16223b) C16222fd.m24736a(0.0f, objArr[0]);
            while (i < length) {
                c16223bArr[i] = (C16223b) C16222fd.m24736a(((float) i) / ((float) (length - 1)), objArr[i]);
                i++;
            }
        }
        C16224fe c16224fe = new C16224fe(c16223bArr);
        AppMethodBeat.m2505o(98871);
        return c16224fe;
    }

    /* renamed from: a */
    public void mo29279a(C36503fi c36503fi) {
        this.f3216f = c36503fi;
    }

    /* renamed from: b */
    public C16224fe mo29280b() {
        AppMethodBeat.m2504i(98872);
        ArrayList arrayList = this.f3215e;
        int size = this.f3215e.size();
        C16222fd[] c16222fdArr = new C16222fd[size];
        for (int i = 0; i < size; i++) {
            c16222fdArr[i] = ((C16222fd) arrayList.get(i)).clone();
        }
        C16224fe c16224fe = new C16224fe(c16222fdArr);
        AppMethodBeat.m2505o(98872);
        return c16224fe;
    }

    public String toString() {
        AppMethodBeat.m2504i(98873);
        String str = " ";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f3211a) {
                str = str + ((C16222fd) this.f3215e.get(i2)).mo12426a() + "  ";
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(98873);
                return str;
            }
        }
    }
}
