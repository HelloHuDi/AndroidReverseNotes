package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.p057v4.view.p067a.C0445b;
import android.support.p057v4.widget.C8415j;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.map.lib.element.MapPoi;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jc */
public class C17083jc extends C8415j implements C31044fv {
    /* renamed from: a */
    private List<C16285jb> f3585a = new ArrayList();
    /* renamed from: b */
    private List<C16285jb> f3586b = new ArrayList();
    /* renamed from: c */
    private List<C16285jb> f3587c = new ArrayList();
    /* renamed from: d */
    private C31061iz f3588d;
    /* renamed from: e */
    private Handler f3589e = new Handler();

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jc$1 */
    class C58951 implements Runnable {
        C58951() {
        }

        public void run() {
            AppMethodBeat.m2504i(100008);
            C17083jc.this.f3585a.clear();
            C17083jc.this.f3586b.clear();
            C17083jc.this.f3587c.clear();
            if (C17083jc.this.f3588d != null) {
                C36899hx c36899hx;
                List<C36899hx> S = C17083jc.this.f3588d.mo50426S();
                List<MapPoi> T = C17083jc.this.f3588d.mo50427T();
                if (S != null) {
                    c36899hx = null;
                    for (C36899hx c36899hx2 : S) {
                        String m = c36899hx2.mo58891m();
                        if (!StringUtil.isEmpty(m)) {
                            if (m.startsWith("我的位置")) {
                                c36899hx = c36899hx2;
                            } else {
                                C17083jc.this.f3586b.add(new C5896jd(C17083jc.this.f3588d, c36899hx2));
                            }
                        }
                    }
                    Collections.sort(C17083jc.this.f3586b);
                    C17083jc.this.f3585a.addAll(C17083jc.this.f3586b);
                } else {
                    c36899hx = null;
                }
                if (T != null) {
                    for (MapPoi mapPoi : T) {
                        if (!StringUtil.isEmpty(mapPoi.getPoiName())) {
                            C17083jc.this.f3587c.add(new C36522je(C17083jc.this.f3588d, mapPoi));
                        }
                    }
                    Collections.sort(C17083jc.this.f3587c);
                    C17083jc.this.f3585a.addAll(C17083jc.this.f3587c);
                }
                if (c36899hx != null) {
                    C17083jc.this.f3585a.add(new C5896jd(C17083jc.this.f3588d, c36899hx));
                }
            }
            AppMethodBeat.m2505o(100008);
        }
    }

    public C17083jc(View view, C31061iz c31061iz) {
        super(view);
        AppMethodBeat.m2504i(100009);
        this.f3588d = c31061iz;
        this.f3588d.mo75386b().mo20175a((C31044fv) this);
        AppMethodBeat.m2505o(100009);
    }

    public int getVirtualViewAt(float f, float f2) {
        AppMethodBeat.m2504i(100010);
        int a = mo31148a(f, f2);
        if (a == -1) {
            AppMethodBeat.m2505o(100010);
            return C8415j.INVALID_ID;
        }
        AppMethodBeat.m2505o(100010);
        return a;
    }

    public void getVisibleVirtualViews(List<Integer> list) {
        AppMethodBeat.m2504i(100011);
        for (int i = 0; i < this.f3585a.size(); i++) {
            list.add(Integer.valueOf(i));
        }
        AppMethodBeat.m2505o(100011);
    }

    public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.m2504i(100012);
        if (i >= this.f3585a.size()) {
            accessibilityEvent.getText().add("");
            AppMethodBeat.m2505o(100012);
            return;
        }
        C16285jb c16285jb = (C16285jb) this.f3585a.get(i);
        if (c16285jb == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid virtual view id");
            AppMethodBeat.m2505o(100012);
            throw illegalArgumentException;
        }
        accessibilityEvent.getText().add(c16285jb.mo12519b());
        AppMethodBeat.m2505o(100012);
    }

    public void onPopulateNodeForVirtualView(int i, C0445b c0445b) {
        AppMethodBeat.m2504i(100013);
        if (i >= this.f3585a.size()) {
            c0445b.setText("");
            c0445b.setBoundsInParent(new Rect());
            AppMethodBeat.m2505o(100013);
            return;
        }
        C16285jb c16285jb = (C16285jb) this.f3585a.get(i);
        if (c16285jb == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid virtual view id");
            AppMethodBeat.m2505o(100013);
            throw illegalArgumentException;
        }
        c0445b.setText(c16285jb.mo12519b());
        c0445b.setBoundsInParent(c16285jb.mo12518a());
        c0445b.addAction(16);
        AppMethodBeat.m2505o(100013);
    }

    public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
        AppMethodBeat.m2504i(100014);
        if (i2 == 16) {
            boolean a = mo31150a(i);
            AppMethodBeat.m2505o(100014);
            return a;
        }
        AppMethodBeat.m2505o(100014);
        return false;
    }

    /* renamed from: a */
    public boolean mo31150a(int i) {
        AppMethodBeat.m2504i(100015);
        if (i >= this.f3585a.size()) {
            AppMethodBeat.m2505o(100015);
            return false;
        }
        C16285jb c16285jb = (C16285jb) this.f3585a.get(i);
        if (c16285jb == null) {
            AppMethodBeat.m2505o(100015);
            return false;
        }
        invalidateVirtualView(i);
        sendEventForVirtualView(i, 1);
        c16285jb.mo12520c();
        AppMethodBeat.m2505o(100015);
        return true;
    }

    /* renamed from: a */
    public int mo31148a(float f, float f2) {
        AppMethodBeat.m2504i(100016);
        if (this.f3585a != null && this.f3585a.size() > 0) {
            int b = m26430b(f, f2);
            if (b == -1) {
                int i = 0;
                while (true) {
                    b = i;
                    if (b >= this.f3585a.size()) {
                        break;
                    } else if (((C16285jb) this.f3585a.get(b)).mo12518a().contains((int) f, (int) f2)) {
                        AppMethodBeat.m2505o(100016);
                        return b;
                    } else {
                        i = b + 1;
                    }
                }
            } else {
                AppMethodBeat.m2505o(100016);
                return b;
            }
        }
        AppMethodBeat.m2505o(100016);
        return -1;
    }

    /* renamed from: a */
    public void mo29059a() {
        AppMethodBeat.m2504i(100017);
        this.f3589e.post(new C58951());
        AppMethodBeat.m2505o(100017);
    }

    /* renamed from: b */
    private int m26430b(float f, float f2) {
        AppMethodBeat.m2504i(100018);
        if (this.f3585a != null && this.f3585a.size() > 0) {
            int size = this.f3585a.size() - 1;
            C16285jb c16285jb = (C16285jb) this.f3585a.get(size);
            if ((c16285jb instanceof C5896jd) && c16285jb.mo12518a().contains((int) f, (int) f2)) {
                AppMethodBeat.m2505o(100018);
                return size;
            }
        }
        AppMethodBeat.m2505o(100018);
        return -1;
    }

    /* JADX WARNING: Missing block: B:14:0x004a, code skipped:
            if ((r0 instanceof com.tencent.tencentmap.mapsdk.maps.p667a.C5896jd) != false) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo31149a(C36899hx c36899hx) {
        AppMethodBeat.m2504i(100019);
        if (c36899hx == null) {
            AppMethodBeat.m2505o(100019);
            return;
        }
        String u = c36899hx.f15581y.mo70763u();
        if (StringUtil.isEmpty(u)) {
            AppMethodBeat.m2505o(100019);
        } else if (c36899hx.mo58901x()) {
            Object obj;
            C5896jd c5896jd = new C5896jd(this.f3588d, c36899hx);
            if (this.f3585a.size() > 0) {
                obj = (C16285jb) this.f3585a.get(this.f3585a.size() - 1);
                if (obj != null) {
                }
            }
            obj = null;
            if (u.startsWith("我的位置")) {
                this.f3585a.add(c5896jd);
                AppMethodBeat.m2505o(100019);
                return;
            }
            this.f3585a.clear();
            this.f3586b.add(c5896jd);
            Collections.sort(this.f3586b);
            this.f3585a.addAll(this.f3586b);
            this.f3585a.addAll(this.f3587c);
            if (obj != null) {
                this.f3585a.add(obj);
            }
            AppMethodBeat.m2505o(100019);
        } else {
            AppMethodBeat.m2505o(100019);
        }
    }

    /* renamed from: b */
    public void mo31151b() {
        AppMethodBeat.m2504i(100020);
        this.f3588d.mo75386b().mo20175a((C31044fv) this);
        mo29059a();
        AppMethodBeat.m2505o(100020);
    }

    /* renamed from: c */
    public void mo31152c() {
        AppMethodBeat.m2504i(100021);
        this.f3588d.mo75386b().mo20198b((C31044fv) this);
        AppMethodBeat.m2505o(100021);
    }

    /* renamed from: d */
    public void mo31153d() {
        AppMethodBeat.m2504i(100022);
        this.f3588d.mo75386b().mo20198b((C31044fv) this);
        this.f3585a.clear();
        this.f3586b.clear();
        this.f3587c.clear();
        AppMethodBeat.m2505o(100022);
    }
}
