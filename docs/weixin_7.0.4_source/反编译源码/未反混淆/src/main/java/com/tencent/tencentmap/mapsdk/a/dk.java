package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Typeface;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tencentmap.mapsdk.maps.a.ic;
import java.util.ArrayList;
import java.util.List;

public class dk {
    private final List<db> a = new ArrayList();
    private float b = 1.0f;
    private int c = WebView.NIGHT_MODE_COLOR;
    private int d = ic.k;
    private int e = 0;
    private boolean f = true;
    private boolean g = false;
    private String h = "";
    private int i = WebView.NIGHT_MODE_COLOR;
    private Typeface j = Typeface.DEFAULT;
    private int k = BaseClientBuilder.API_PRIORITY_OTHER;
    private int l = 1;
    private int m = -1;
    private int n = di.c;

    public dk() {
        AppMethodBeat.i(101056);
        AppMethodBeat.o(101056);
    }

    public void a(Iterable<db> iterable) {
        AppMethodBeat.i(101057);
        if (this.a == null) {
            AppMethodBeat.o(101057);
            return;
        }
        this.a.clear();
        if (iterable == null) {
            AppMethodBeat.o(101057);
            return;
        }
        b((Iterable) iterable);
        AppMethodBeat.o(101057);
    }

    public dk b(Iterable<db> iterable) {
        AppMethodBeat.i(101058);
        if (iterable != null) {
            for (db add : iterable) {
                this.a.add(add);
            }
        }
        AppMethodBeat.o(101058);
        return this;
    }

    public dk a(float f) {
        if (f < 0.0f) {
            this.b = 1.0f;
        } else {
            this.b = f;
        }
        return this;
    }

    public dk a(int i) {
        this.c = i;
        return this;
    }

    public dk b(int i) {
        this.d = i;
        return this;
    }

    public dk c(int i) {
        this.e = i;
        return this;
    }

    public dk a(boolean z) {
        this.f = z;
        return this;
    }

    public List<db> a() {
        return this.a;
    }

    public float b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public float e() {
        return (float) this.e;
    }

    public boolean f() {
        return this.f;
    }

    public String g() {
        return this.h;
    }

    public dk d(int i) {
        if (i >= di.a && i <= di.c) {
            this.n = i;
        }
        return this;
    }

    public int h() {
        return this.n;
    }
}
