package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fd */
public abstract class C16222fd implements Cloneable {
    /* renamed from: a */
    float f3206a;
    /* renamed from: b */
    Class<?> f3207b;
    /* renamed from: c */
    boolean f3208c = false;
    /* renamed from: d */
    private Interpolator f3209d = null;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fd$a */
    static class C5871a extends C16222fd {
        /* renamed from: d */
        double f1590d;

        public /* synthetic */ Object clone() {
            AppMethodBeat.m2504i(98864);
            C5871a e = mo12429e();
            AppMethodBeat.m2505o(98864);
            return e;
        }

        /* renamed from: d */
        public /* synthetic */ C16222fd mo12428d() {
            AppMethodBeat.m2504i(98863);
            C5871a e = mo12429e();
            AppMethodBeat.m2505o(98863);
            return e;
        }

        C5871a(float f, double d) {
            this.f3206a = f;
            this.f1590d = d;
            this.f3207b = Double.TYPE;
            this.f3208c = true;
        }

        C5871a(float f) {
            this.f3206a = f;
            this.f3207b = Double.TYPE;
        }

        /* renamed from: a */
        public Object mo12426a() {
            AppMethodBeat.m2504i(98861);
            Double valueOf = Double.valueOf(this.f1590d);
            AppMethodBeat.m2505o(98861);
            return valueOf;
        }

        /* renamed from: e */
        public C5871a mo12429e() {
            AppMethodBeat.m2504i(98862);
            C5871a c5871a = new C5871a(mo29276b(), this.f1590d);
            c5871a.mo29275a(mo29277c());
            AppMethodBeat.m2505o(98862);
            return c5871a;
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fd$b */
    static class C16223b extends C16222fd {
        /* renamed from: d */
        Object f3210d;

        public /* synthetic */ Object clone() {
            AppMethodBeat.m2504i(98868);
            C16223b e = mo29278e();
            AppMethodBeat.m2505o(98868);
            return e;
        }

        /* renamed from: d */
        public /* synthetic */ C16222fd mo12428d() {
            AppMethodBeat.m2504i(98867);
            C16223b e = mo29278e();
            AppMethodBeat.m2505o(98867);
            return e;
        }

        C16223b(float f, Object obj) {
            AppMethodBeat.m2504i(98865);
            this.f3206a = f;
            this.f3210d = obj;
            this.f3208c = obj != null;
            this.f3207b = this.f3208c ? obj.getClass() : Object.class;
            AppMethodBeat.m2505o(98865);
        }

        /* renamed from: a */
        public Object mo12426a() {
            return this.f3210d;
        }

        /* renamed from: e */
        public C16223b mo29278e() {
            AppMethodBeat.m2504i(98866);
            C16223b c16223b = new C16223b(mo29276b(), this.f3210d);
            c16223b.mo29275a(mo29277c());
            AppMethodBeat.m2505o(98866);
            return c16223b;
        }
    }

    /* renamed from: a */
    public abstract Object mo12426a();

    /* renamed from: d */
    public abstract C16222fd clone();

    /* renamed from: a */
    public static C16222fd m24735a(float f, double d) {
        return new C5871a(f, d);
    }

    /* renamed from: a */
    public static C16222fd m24734a(float f) {
        return new C5871a(f);
    }

    /* renamed from: a */
    public static C16222fd m24736a(float f, Object obj) {
        return new C16223b(f, obj);
    }

    /* renamed from: b */
    public static C16222fd m24737b(float f) {
        return new C16223b(f, null);
    }

    /* renamed from: b */
    public float mo29276b() {
        return this.f3206a;
    }

    /* renamed from: c */
    public Interpolator mo29277c() {
        return this.f3209d;
    }

    /* renamed from: a */
    public void mo29275a(Interpolator interpolator) {
        this.f3209d = interpolator;
    }
}
