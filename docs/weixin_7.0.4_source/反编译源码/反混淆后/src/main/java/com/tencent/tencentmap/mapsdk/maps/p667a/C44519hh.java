package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hh */
public class C44519hh {
    /* renamed from: a */
    private ExecutorService f17427a;
    /* renamed from: b */
    private ExecutorService f17428b;
    /* renamed from: c */
    private C24386hf f17429c;
    /* renamed from: d */
    private C44517hg f17430d;

    /* renamed from: a */
    public void mo70896a(C24386hf c24386hf) {
        this.f17429c = c24386hf;
    }

    /* renamed from: a */
    public void mo70897a(C44517hg c44517hg) {
        this.f17430d = c44517hg;
    }

    /* renamed from: a */
    public void mo70895a() {
        AppMethodBeat.m2504i(99533);
        mo70898a(null);
        AppMethodBeat.m2505o(99533);
    }

    /* renamed from: a */
    public void mo70898a(Runnable runnable) {
        AppMethodBeat.m2504i(99534);
        this.f17429c = null;
        if (this.f17427a != null) {
            this.f17427a.shutdown();
            this.f17427a = null;
        }
        if (this.f17428b != null) {
            this.f17428b.shutdown();
            this.f17428b = null;
        }
        if (runnable != null) {
            runnable.run();
        }
        AppMethodBeat.m2505o(99534);
    }

    /* renamed from: a */
    public void mo70899a(final String str) {
        AppMethodBeat.m2504i(99535);
        if (this.f17429c == null) {
            AppMethodBeat.m2505o(99535);
            return;
        }
        if (this.f17427a == null) {
            this.f17427a = Executors.newFixedThreadPool(5);
        }
        try {
            if (!this.f17427a.isShutdown()) {
                this.f17427a.execute(new Runnable() {
                    public void run() {
                        AppMethodBeat.m2504i(99531);
                        C44519hh.m80772a(C44519hh.this, str);
                        AppMethodBeat.m2505o(99531);
                    }
                });
            }
            AppMethodBeat.m2505o(99535);
        } catch (IllegalMonitorStateException e) {
            AppMethodBeat.m2505o(99535);
        }
    }

    /* renamed from: b */
    private void m80774b(String str) {
        AppMethodBeat.m2504i(99536);
        try {
            byte[] a = this.f17429c.mo40646a(str);
            if (a != null && a.length == 0) {
                a = null;
            }
            m80773a(str, a);
            AppMethodBeat.m2505o(99536);
        } catch (Exception e) {
            m80773a(str, null);
            AppMethodBeat.m2505o(99536);
        }
    }

    /* renamed from: a */
    private void m80773a(final String str, final byte[] bArr) {
        AppMethodBeat.m2504i(99537);
        if (this.f17430d == null) {
            AppMethodBeat.m2505o(99537);
            return;
        }
        if (this.f17428b == null) {
            this.f17428b = Executors.newSingleThreadExecutor();
        }
        if (!this.f17428b.isShutdown()) {
            this.f17428b.execute(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(99532);
                    try {
                        if (bArr == null) {
                            C44519hh.this.f17430d.mo29366c(str);
                        }
                        C44519hh.this.f17430d.mo29342a(str, bArr);
                        AppMethodBeat.m2505o(99532);
                    } catch (Exception e) {
                        AppMethodBeat.m2505o(99532);
                    }
                }
            });
        }
        AppMethodBeat.m2505o(99537);
    }
}
