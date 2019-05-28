package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.a.b;
import android.support.v4.widget.j;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.map.lib.element.MapPoi;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class jc extends j implements fv {
    private List<jb> a = new ArrayList();
    private List<jb> b = new ArrayList();
    private List<jb> c = new ArrayList();
    private iz d;
    private Handler e = new Handler();

    public jc(View view, iz izVar) {
        super(view);
        AppMethodBeat.i(100009);
        this.d = izVar;
        this.d.b().a((fv) this);
        AppMethodBeat.o(100009);
    }

    public int getVirtualViewAt(float f, float f2) {
        AppMethodBeat.i(100010);
        int a = a(f, f2);
        if (a == -1) {
            AppMethodBeat.o(100010);
            return j.INVALID_ID;
        }
        AppMethodBeat.o(100010);
        return a;
    }

    public void getVisibleVirtualViews(List<Integer> list) {
        AppMethodBeat.i(100011);
        for (int i = 0; i < this.a.size(); i++) {
            list.add(Integer.valueOf(i));
        }
        AppMethodBeat.o(100011);
    }

    public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(100012);
        if (i >= this.a.size()) {
            accessibilityEvent.getText().add("");
            AppMethodBeat.o(100012);
            return;
        }
        jb jbVar = (jb) this.a.get(i);
        if (jbVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid virtual view id");
            AppMethodBeat.o(100012);
            throw illegalArgumentException;
        }
        accessibilityEvent.getText().add(jbVar.b());
        AppMethodBeat.o(100012);
    }

    public void onPopulateNodeForVirtualView(int i, b bVar) {
        AppMethodBeat.i(100013);
        if (i >= this.a.size()) {
            bVar.setText("");
            bVar.setBoundsInParent(new Rect());
            AppMethodBeat.o(100013);
            return;
        }
        jb jbVar = (jb) this.a.get(i);
        if (jbVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid virtual view id");
            AppMethodBeat.o(100013);
            throw illegalArgumentException;
        }
        bVar.setText(jbVar.b());
        bVar.setBoundsInParent(jbVar.a());
        bVar.addAction(16);
        AppMethodBeat.o(100013);
    }

    public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
        AppMethodBeat.i(100014);
        if (i2 == 16) {
            boolean a = a(i);
            AppMethodBeat.o(100014);
            return a;
        }
        AppMethodBeat.o(100014);
        return false;
    }

    public boolean a(int i) {
        AppMethodBeat.i(100015);
        if (i >= this.a.size()) {
            AppMethodBeat.o(100015);
            return false;
        }
        jb jbVar = (jb) this.a.get(i);
        if (jbVar == null) {
            AppMethodBeat.o(100015);
            return false;
        }
        invalidateVirtualView(i);
        sendEventForVirtualView(i, 1);
        jbVar.c();
        AppMethodBeat.o(100015);
        return true;
    }

    public int a(float f, float f2) {
        AppMethodBeat.i(100016);
        if (this.a != null && this.a.size() > 0) {
            int b = b(f, f2);
            if (b == -1) {
                int i = 0;
                while (true) {
                    b = i;
                    if (b >= this.a.size()) {
                        break;
                    } else if (((jb) this.a.get(b)).a().contains((int) f, (int) f2)) {
                        AppMethodBeat.o(100016);
                        return b;
                    } else {
                        i = b + 1;
                    }
                }
            } else {
                AppMethodBeat.o(100016);
                return b;
            }
        }
        AppMethodBeat.o(100016);
        return -1;
    }

    public void a() {
        AppMethodBeat.i(100017);
        this.e.post(new Runnable() {
            public void run() {
                AppMethodBeat.i(100008);
                jc.this.a.clear();
                jc.this.b.clear();
                jc.this.c.clear();
                if (jc.this.d != null) {
                    hx hxVar;
                    List<hx> S = jc.this.d.S();
                    List<MapPoi> T = jc.this.d.T();
                    if (S != null) {
                        hxVar = null;
                        for (hx hxVar2 : S) {
                            String m = hxVar2.m();
                            if (!StringUtil.isEmpty(m)) {
                                if (m.startsWith("我的位置")) {
                                    hxVar = hxVar2;
                                } else {
                                    jc.this.b.add(new jd(jc.this.d, hxVar2));
                                }
                            }
                        }
                        Collections.sort(jc.this.b);
                        jc.this.a.addAll(jc.this.b);
                    } else {
                        hxVar = null;
                    }
                    if (T != null) {
                        for (MapPoi mapPoi : T) {
                            if (!StringUtil.isEmpty(mapPoi.getPoiName())) {
                                jc.this.c.add(new je(jc.this.d, mapPoi));
                            }
                        }
                        Collections.sort(jc.this.c);
                        jc.this.a.addAll(jc.this.c);
                    }
                    if (hxVar != null) {
                        jc.this.a.add(new jd(jc.this.d, hxVar));
                    }
                }
                AppMethodBeat.o(100008);
            }
        });
        AppMethodBeat.o(100017);
    }

    private int b(float f, float f2) {
        AppMethodBeat.i(100018);
        if (this.a != null && this.a.size() > 0) {
            int size = this.a.size() - 1;
            jb jbVar = (jb) this.a.get(size);
            if ((jbVar instanceof jd) && jbVar.a().contains((int) f, (int) f2)) {
                AppMethodBeat.o(100018);
                return size;
            }
        }
        AppMethodBeat.o(100018);
        return -1;
    }

    /* JADX WARNING: Missing block: B:14:0x004a, code skipped:
            if ((r0 instanceof com.tencent.tencentmap.mapsdk.maps.a.jd) != false) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(hx hxVar) {
        AppMethodBeat.i(100019);
        if (hxVar == null) {
            AppMethodBeat.o(100019);
            return;
        }
        String u = hxVar.y.u();
        if (StringUtil.isEmpty(u)) {
            AppMethodBeat.o(100019);
        } else if (hxVar.x()) {
            Object obj;
            jd jdVar = new jd(this.d, hxVar);
            if (this.a.size() > 0) {
                obj = (jb) this.a.get(this.a.size() - 1);
                if (obj != null) {
                }
            }
            obj = null;
            if (u.startsWith("我的位置")) {
                this.a.add(jdVar);
                AppMethodBeat.o(100019);
                return;
            }
            this.a.clear();
            this.b.add(jdVar);
            Collections.sort(this.b);
            this.a.addAll(this.b);
            this.a.addAll(this.c);
            if (obj != null) {
                this.a.add(obj);
            }
            AppMethodBeat.o(100019);
        } else {
            AppMethodBeat.o(100019);
        }
    }

    public void b() {
        AppMethodBeat.i(100020);
        this.d.b().a((fv) this);
        a();
        AppMethodBeat.o(100020);
    }

    public void c() {
        AppMethodBeat.i(100021);
        this.d.b().b((fv) this);
        AppMethodBeat.o(100021);
    }

    public void d() {
        AppMethodBeat.i(100022);
        this.d.b().b((fv) this);
        this.a.clear();
        this.b.clear();
        this.c.clear();
        AppMethodBeat.o(100022);
    }
}
