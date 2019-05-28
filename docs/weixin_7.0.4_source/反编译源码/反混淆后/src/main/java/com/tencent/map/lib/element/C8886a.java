package com.tencent.map.lib.element;

import android.graphics.Rect;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16263gj;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24374fw;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.map.lib.element.a */
public abstract class C8886a<T extends C17845o<E>, E extends C41717j> implements C41717j {
    /* renamed from: a */
    private T f2805a;
    /* renamed from: b */
    private ArrayList<E> f2806b;
    /* renamed from: c */
    private C8887a<E> f2807c;
    /* renamed from: d */
    private int f2808d = -1;
    /* renamed from: e */
    private int f2809e = -1;

    /* renamed from: com.tencent.map.lib.element.a$a */
    public interface C8887a<T extends C41717j> {
        /* renamed from: a */
        void mo20136a(C17845o<T> c17845o, T t, int i);
    }

    /* renamed from: a */
    public synchronized void mo20128a(C16263gj c16263gj, C24374fw c24374fw) {
        int a = mo20124a();
        int c = mo20134c();
        for (int i = 0; i < c; i++) {
            if (a != i) {
                C41717j a2 = mo20126a(i);
                if (a2 != null && (a2 instanceof C45135d)) {
                    a2.mo20132b(c16263gj, c24374fw);
                }
            }
        }
        C41717j b = mo20131b();
        if (b != null && (b instanceof C45135d)) {
            b.mo20132b(c16263gj, c24374fw);
        }
    }

    /* renamed from: b */
    public synchronized void mo20132b(C16263gj c16263gj, C24374fw c24374fw) {
        int a = mo20124a();
        int c = mo20134c();
        for (int i = 0; i < c; i++) {
            if (a != i) {
                C41717j a2 = mo20126a(i);
                if (!(a2 == null || (a2 instanceof C45135d))) {
                    a2.mo20132b(c16263gj, c24374fw);
                }
            }
        }
        C41717j b = mo20131b();
        if (!(b == null || (b instanceof C45135d))) {
            b.mo20132b(c16263gj, c24374fw);
        }
    }

    /* renamed from: a */
    public boolean mo20130a(C24374fw c24374fw, float f, float f2) {
        if (this.f2806b == null) {
            return false;
        }
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f2806b.size());
            arrayList.addAll(this.f2806b);
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            int i2 = ((this.f2808d + i) + 1) % size;
            C41717j c41717j = (C41717j) arrayList.get(i2);
            if (c41717j.mo20130a(c24374fw, f, f2)) {
                this.f2808d = i2;
                if (this.f2807c != null) {
                    this.f2807c.mo20136a(this.f2805a, c41717j, i2);
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public synchronized Rect mo20125a(C24374fw c24374fw) {
        Rect rect = null;
        synchronized (this) {
            if (!(this.f2806b == null || this.f2806b.size() == 0)) {
                int size = this.f2806b.size();
                int i = 0;
                while (i < size) {
                    Rect a = ((C41717j) this.f2806b.get(i)).mo20125a(c24374fw);
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

    /* renamed from: a */
    public int mo20124a() {
        return this.f2809e;
    }

    /* renamed from: b */
    public synchronized E mo20131b() {
        E e;
        if (this.f2806b == null || this.f2809e < 0 || this.f2806b.size() <= this.f2809e) {
            e = null;
        } else {
            e = (C41717j) this.f2806b.get(this.f2809e);
        }
        return e;
    }

    /* renamed from: c */
    public synchronized int mo20134c() {
        int i;
        if (this.f2806b == null) {
            i = 0;
        } else {
            i = this.f2806b.size();
        }
        return i;
    }

    /* renamed from: a */
    public synchronized E mo20126a(int i) {
        E e;
        if (this.f2806b == null || i < 0 || this.f2806b.size() <= i) {
            e = null;
        } else {
            C41717j e2 = (C41717j) this.f2806b.get(i);
        }
        return e2;
    }

    /* renamed from: a */
    public synchronized void mo20129a(List<E> list) {
        if (list != null) {
            if (list.size() > 0) {
                if (this.f2806b == null) {
                    this.f2806b = new ArrayList(list.size());
                } else {
                    this.f2806b.clear();
                }
                this.f2806b.addAll(list);
            }
        }
        this.f2806b = null;
    }

    /* renamed from: a */
    public synchronized void mo20127a(E e) {
        if (this.f2806b == null) {
            this.f2806b = new ArrayList();
        }
        this.f2806b.add(e);
    }

    /* renamed from: b */
    public synchronized boolean mo20133b(E e) {
        boolean remove;
        if (this.f2806b != null) {
            remove = this.f2806b.remove(e);
        } else {
            remove = false;
        }
        return remove;
    }

    /* renamed from: d */
    public synchronized void mo20135d() {
        if (this.f2806b != null) {
            this.f2806b.clear();
        }
    }
}
