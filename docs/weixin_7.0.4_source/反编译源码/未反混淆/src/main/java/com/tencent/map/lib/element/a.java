package com.tencent.map.lib.element;

import android.graphics.Rect;
import com.tencent.tencentmap.mapsdk.maps.a.fw;
import com.tencent.tencentmap.mapsdk.maps.a.gj;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T extends o<E>, E extends j> implements j {
    private T a;
    private ArrayList<E> b;
    private a<E> c;
    private int d = -1;
    private int e = -1;

    public interface a<T extends j> {
        void a(o<T> oVar, T t, int i);
    }

    public synchronized void a(gj gjVar, fw fwVar) {
        int a = a();
        int c = c();
        for (int i = 0; i < c; i++) {
            if (a != i) {
                j a2 = a(i);
                if (a2 != null && (a2 instanceof d)) {
                    a2.b(gjVar, fwVar);
                }
            }
        }
        j b = b();
        if (b != null && (b instanceof d)) {
            b.b(gjVar, fwVar);
        }
    }

    public synchronized void b(gj gjVar, fw fwVar) {
        int a = a();
        int c = c();
        for (int i = 0; i < c; i++) {
            if (a != i) {
                j a2 = a(i);
                if (!(a2 == null || (a2 instanceof d))) {
                    a2.b(gjVar, fwVar);
                }
            }
        }
        j b = b();
        if (!(b == null || (b instanceof d))) {
            b.b(gjVar, fwVar);
        }
    }

    public boolean a(fw fwVar, float f, float f2) {
        if (this.b == null) {
            return false;
        }
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.b.size());
            arrayList.addAll(this.b);
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            int i2 = ((this.d + i) + 1) % size;
            j jVar = (j) arrayList.get(i2);
            if (jVar.a(fwVar, f, f2)) {
                this.d = i2;
                if (this.c != null) {
                    this.c.a(this.a, jVar, i2);
                }
                return true;
            }
        }
        return false;
    }

    public synchronized Rect a(fw fwVar) {
        Rect rect = null;
        synchronized (this) {
            if (!(this.b == null || this.b.size() == 0)) {
                int size = this.b.size();
                int i = 0;
                while (i < size) {
                    Rect a = ((j) this.b.get(i)).a(fwVar);
                    if (a != null) {
                        if (rect == null) {
                            i++;
                            rect = a;
                        } else {
                            rect.left = Math.min(rect.left, a.left);
                            rect.top = Math.max(rect.top, a.top);
                            rect.right = Math.max(rect.right, a.right);
                            rect.bottom = Math.min(rect.bottom, a.bottom);
                        }
                    }
                    a = rect;
                    i++;
                    rect = a;
                }
            }
        }
        return rect;
    }

    public int a() {
        return this.e;
    }

    public synchronized E b() {
        E e;
        if (this.b == null || this.e < 0 || this.b.size() <= this.e) {
            e = null;
        } else {
            e = (j) this.b.get(this.e);
        }
        return e;
    }

    public synchronized int c() {
        int i;
        if (this.b == null) {
            i = 0;
        } else {
            i = this.b.size();
        }
        return i;
    }

    public synchronized E a(int i) {
        E e;
        if (this.b == null || i < 0 || this.b.size() <= i) {
            e = null;
        } else {
            j e2 = (j) this.b.get(i);
        }
        return e2;
    }

    public synchronized void a(List<E> list) {
        if (list != null) {
            if (list.size() > 0) {
                if (this.b == null) {
                    this.b = new ArrayList(list.size());
                } else {
                    this.b.clear();
                }
                this.b.addAll(list);
            }
        }
        this.b = null;
    }

    public synchronized void a(E e) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(e);
    }

    public synchronized boolean b(E e) {
        boolean remove;
        if (this.b != null) {
            remove = this.b.remove(e);
        } else {
            remove = false;
        }
        return remove;
    }

    public synchronized void d() {
        if (this.b != null) {
            this.b.clear();
        }
    }
}
