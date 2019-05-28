package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;

public class fe {
    int a;
    fd b;
    fd c;
    Interpolator d;
    ArrayList<fd> e = new ArrayList();
    fi f;

    public /* synthetic */ Object clone() {
        AppMethodBeat.i(98874);
        fe b = b();
        AppMethodBeat.o(98874);
        return b;
    }

    public fe(fd... fdVarArr) {
        AppMethodBeat.i(98869);
        this.a = fdVarArr.length;
        this.e.addAll(Arrays.asList(fdVarArr));
        this.b = (fd) this.e.get(0);
        this.c = (fd) this.e.get(this.a - 1);
        this.d = this.c.c();
        AppMethodBeat.o(98869);
    }

    public static fe a(double... dArr) {
        int i = 1;
        AppMethodBeat.i(98870);
        int length = dArr.length;
        a[] aVarArr = new a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (a) fd.a(0.0f);
            aVarArr[1] = (a) fd.a(1.0f, dArr[0]);
        } else {
            aVarArr[0] = (a) fd.a(0.0f, dArr[0]);
            while (i < length) {
                aVarArr[i] = (a) fd.a(((float) i) / ((float) (length - 1)), dArr[i]);
                i++;
            }
        }
        fa faVar = new fa(aVarArr);
        AppMethodBeat.o(98870);
        return faVar;
    }

    public static fe a(Object... objArr) {
        int i = 1;
        AppMethodBeat.i(98871);
        int length = objArr.length;
        b[] bVarArr = new b[Math.max(length, 2)];
        if (length == 1) {
            bVarArr[0] = (b) fd.b(0.0f);
            bVarArr[1] = (b) fd.a(1.0f, objArr[0]);
        } else {
            bVarArr[0] = (b) fd.a(0.0f, objArr[0]);
            while (i < length) {
                bVarArr[i] = (b) fd.a(((float) i) / ((float) (length - 1)), objArr[i]);
                i++;
            }
        }
        fe feVar = new fe(bVarArr);
        AppMethodBeat.o(98871);
        return feVar;
    }

    public void a(fi fiVar) {
        this.f = fiVar;
    }

    public fe b() {
        AppMethodBeat.i(98872);
        ArrayList arrayList = this.e;
        int size = this.e.size();
        fd[] fdVarArr = new fd[size];
        for (int i = 0; i < size; i++) {
            fdVarArr[i] = ((fd) arrayList.get(i)).clone();
        }
        fe feVar = new fe(fdVarArr);
        AppMethodBeat.o(98872);
        return feVar;
    }

    public String toString() {
        AppMethodBeat.i(98873);
        String str = " ";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.a) {
                str = str + ((fd) this.e.get(i2)).a() + "  ";
                i = i2 + 1;
            } else {
                AppMethodBeat.o(98873);
                return str;
            }
        }
    }
}
