package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.mh */
public class C44538mh<T> extends C5908ly<T> {
    /* renamed from: a */
    boolean f17493a = false;
    /* renamed from: b */
    private final C5908ly<? super T> f17494b;

    public C44538mh(C5908ly<? super T> c5908ly) {
        super(c5908ly);
        this.f17494b = c5908ly;
    }

    /* renamed from: a */
    public void mo57772a() {
        AppMethodBeat.m2504i(100508);
        if (this.f17493a) {
            AppMethodBeat.m2505o(100508);
            return;
        }
        this.f17493a = true;
        try {
            this.f17494b.mo57772a();
        } catch (Throwable th) {
            C41077mb.m71478a(th);
            mo70932b(th);
        } finally {
            mo12543b();
            AppMethodBeat.m2505o(100508);
        }
    }

    /* renamed from: a */
    public void mo57774a(Throwable th) {
        AppMethodBeat.m2504i(100509);
        C41077mb.m71478a(th);
        if (!this.f17493a) {
            this.f17493a = true;
            mo70932b(th);
        }
        AppMethodBeat.m2505o(100509);
    }

    /* renamed from: a */
    public void mo57773a(T t) {
        AppMethodBeat.m2504i(100510);
        try {
            if (!this.f17493a) {
                this.f17494b.mo57773a((Object) t);
            }
            AppMethodBeat.m2505o(100510);
        } catch (Throwable th) {
            C41077mb.m71478a(th);
            mo57774a(th);
            AppMethodBeat.m2505o(100510);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo70932b(Throwable th) {
        AppMethodBeat.m2504i(100511);
        try {
            C24418ml.m38014a().mo40747b().mo65174a(th);
        } catch (Throwable th2) {
            m80844c(th2);
        }
        C36539mc c36539mc;
        try {
            this.f17494b.mo57774a(th);
            try {
                mo12543b();
                AppMethodBeat.m2505o(100511);
                return;
            } catch (RuntimeException e) {
                C24418ml.m38014a().mo40747b().mo65174a(e);
            } catch (Throwable th22) {
                m80844c(th22);
            }
            C36539mc c36539mc2 = new C36539mc(e);
            AppMethodBeat.m2505o(100511);
            throw c36539mc2;
            mo12543b();
            c36539mc = new C36539mc("Error occurred when trying to propagate error to Observer.onError", new C46805ma(Arrays.asList(new Throwable[]{th, th22})));
            AppMethodBeat.m2505o(100511);
        } catch (Throwable th3) {
            try {
                C24418ml.m38014a().mo40747b().mo65174a(th3);
            } catch (Throwable th4) {
                m80844c(th4);
            }
            c36539mc = new C36539mc("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new C46805ma(Arrays.asList(new Throwable[]{th, th22, th3})));
            AppMethodBeat.m2505o(100511);
        }
    }

    /* renamed from: c */
    private void m80844c(Throwable th) {
        AppMethodBeat.m2504i(100512);
        System.err.println("RxJavaErrorHandler threw an Exception. It shouldn't. => " + th.getMessage());
        AppMethodBeat.m2505o(100512);
    }
}
