package android.support.p057v4.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.p057v4.app.C0352p.C03502;
import android.support.p057v4.app.C0352p.C03513;
import android.support.p057v4.app.C6185b.C0330a;
import android.support.p057v4.p065f.C0414h;
import android.support.p057v4.p065f.C6197a;
import android.support.p057v4.view.C0477s;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v4.app.n */
final class C0344n {
    /* renamed from: DC */
    private static final int[] f327DC = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8};
    /* renamed from: DD */
    private static final C0352p f328DD = (VERSION.SDK_INT >= 21 ? new C6187o() : null);
    /* renamed from: DE */
    private static final C0352p f329DE = C0344n.m556dp();

    /* renamed from: android.support.v4.app.n$a */
    static class C0343a {
        /* renamed from: DR */
        public Fragment f321DR;
        /* renamed from: DS */
        public boolean f322DS;
        /* renamed from: DT */
        public C6185b f323DT;
        /* renamed from: DU */
        public Fragment f324DU;
        /* renamed from: DV */
        public boolean f325DV;
        /* renamed from: DW */
        public C6185b f326DW;

        C0343a() {
        }
    }

    /* renamed from: dp */
    private static C0352p m556dp() {
        try {
            return (C0352p) Class.forName("android.support.transition.g").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    static void m541a(FragmentManagerImpl fragmentManagerImpl, ArrayList<C6185b> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (fragmentManagerImpl.mCurState > 0) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                C6185b c6185b = (C6185b) arrayList.get(i3);
                if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                    C0344n.m553b(c6185b, sparseArray, z);
                } else {
                    C0344n.m543a(c6185b, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                final View view = new View(fragmentManagerImpl.mHost.mContext);
                int size = sparseArray.size();
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 < size) {
                        int keyAt = sparseArray.keyAt(i5);
                        final C6197a a = C0344n.m532a(keyAt, (ArrayList) arrayList, (ArrayList) arrayList2, i, i2);
                        final C0343a c0343a = (C0343a) sparseArray.valueAt(i5);
                        C0352p a2;
                        boolean z2;
                        Object b;
                        Object obj;
                        C6197a a3;
                        View a4;
                        if (z) {
                            View view2;
                            if (fragmentManagerImpl.mContainer.onHasView()) {
                                view2 = (ViewGroup) fragmentManagerImpl.mContainer.onFindViewById(keyAt);
                            } else {
                                view2 = null;
                            }
                            if (view2 != null) {
                                Fragment fragment = c0343a.f321DR;
                                Fragment fragment2 = c0343a.f324DU;
                                a2 = C0344n.m531a(fragment2, fragment);
                                if (a2 != null) {
                                    Object obj2;
                                    boolean z3 = c0343a.f322DS;
                                    z2 = c0343a.f325DV;
                                    ArrayList arrayList3 = new ArrayList();
                                    ArrayList arrayList4 = new ArrayList();
                                    Object a5 = C0344n.m536a(a2, fragment, z3);
                                    b = C0344n.m550b(a2, fragment2, z2);
                                    Fragment fragment3 = c0343a.f321DR;
                                    Fragment fragment4 = c0343a.f324DU;
                                    if (fragment3 != null) {
                                        fragment3.getView().setVisibility(0);
                                    }
                                    if (fragment3 == null || fragment4 == null) {
                                        obj2 = null;
                                    } else {
                                        final boolean z4 = c0343a.f322DS;
                                        if (a.isEmpty()) {
                                            obj = null;
                                        } else {
                                            obj = C0344n.m535a(a2, fragment3, fragment4, z4);
                                        }
                                        a3 = C0344n.m533a(a2, a, obj, c0343a);
                                        final C6197a b2 = C0344n.m548b(a2, a, obj, c0343a);
                                        if (a.isEmpty()) {
                                            obj = null;
                                            if (a3 != null) {
                                                a3.clear();
                                            }
                                            if (b2 != null) {
                                                b2.clear();
                                            }
                                        } else {
                                            C0344n.m546a(arrayList4, a3, a.keySet());
                                            C0344n.m546a(arrayList3, b2, a.values());
                                        }
                                        if (a5 == null && b == null && obj == null) {
                                            obj2 = null;
                                        } else {
                                            Rect rect;
                                            C0344n.m540a(fragment3, fragment4, z4, a3);
                                            if (obj != null) {
                                                arrayList3.add(view);
                                                a2.mo590a(obj, view, arrayList4);
                                                C0344n.m544a(a2, obj, b, a3, c0343a.f325DV, c0343a.f326DW);
                                                rect = new Rect();
                                                a4 = C0344n.m534a(b2, c0343a, a5, z4);
                                                if (a4 != null) {
                                                    a2.mo588a(a5, rect);
                                                }
                                            } else {
                                                rect = null;
                                                a4 = null;
                                            }
                                            final Fragment fragment5 = fragment3;
                                            final Fragment fragment6 = fragment4;
                                            final C0352p c0352p = a2;
                                            C0367z.m618a(view2, new Runnable() {
                                                public final void run() {
                                                    C0344n.m540a(fragment5, fragment6, z4, b2);
                                                    if (a4 != null) {
                                                        C0352p.m559b(a4, rect);
                                                    }
                                                }
                                            });
                                            obj2 = obj;
                                        }
                                    }
                                    if (a5 != null || obj2 != null || b != null) {
                                        final ArrayList a6 = C0344n.m539a(a2, b, fragment2, arrayList4, view);
                                        ArrayList a7 = C0344n.m539a(a2, a5, fragment, arrayList3, view);
                                        C0344n.m545a(a7, 4);
                                        Object a8 = C0344n.m537a(a2, a5, b, obj2, fragment, z3);
                                        if (a8 != null) {
                                            if (fragment2 != null && b != null && fragment2.mAdded && fragment2.mHidden && fragment2.mHiddenChanged) {
                                                fragment2.setHideReplaced(true);
                                                a2.mo598b(b, fragment2.getView(), a6);
                                                C0367z.m618a(fragment2.mContainer, new Runnable() {
                                                    public final void run() {
                                                        C0344n.m545a(a6, 4);
                                                    }
                                                });
                                            }
                                            ArrayList c = C0352p.m560c(arrayList3);
                                            a2.mo591a(a8, a5, a7, b, a6, obj2, arrayList3);
                                            a2.mo587a((ViewGroup) view2, a8);
                                            a2.mo586a(view2, arrayList4, arrayList3, c, a);
                                            C0344n.m545a(a7, 0);
                                            a2.mo593a(obj2, arrayList4, arrayList3);
                                        }
                                    }
                                }
                            }
                        } else {
                            ViewGroup viewGroup;
                            if (fragmentManagerImpl.mContainer.onHasView()) {
                                viewGroup = (ViewGroup) fragmentManagerImpl.mContainer.onFindViewById(keyAt);
                            } else {
                                a4 = null;
                            }
                            if (viewGroup != null) {
                                Fragment fragment7 = c0343a.f321DR;
                                Fragment fragment8 = c0343a.f324DU;
                                a2 = C0344n.m531a(fragment8, fragment7);
                                if (a2 != null) {
                                    Object obj3;
                                    z2 = c0343a.f322DS;
                                    boolean z5 = c0343a.f325DV;
                                    final Object a9 = C0344n.m536a(a2, fragment7, z2);
                                    b = C0344n.m550b(a2, fragment8, z5);
                                    final ArrayList arrayList5 = new ArrayList();
                                    final ArrayList arrayList6 = new ArrayList();
                                    final Fragment fragment9 = c0343a.f321DR;
                                    final Fragment fragment10 = c0343a.f324DU;
                                    if (fragment9 == null || fragment10 == null) {
                                        obj3 = null;
                                    } else {
                                        final boolean z6 = c0343a.f322DS;
                                        if (a.isEmpty()) {
                                            obj = null;
                                        } else {
                                            obj = C0344n.m535a(a2, fragment9, fragment10, z6);
                                        }
                                        a3 = C0344n.m533a(a2, a, obj, c0343a);
                                        if (a.isEmpty()) {
                                            obj = null;
                                        } else {
                                            arrayList5.addAll(a3.values());
                                        }
                                        if (a9 == null && b == null && obj == null) {
                                            obj3 = null;
                                        } else {
                                            Rect rect2;
                                            C0344n.m540a(fragment9, fragment10, z6, a3);
                                            if (obj != null) {
                                                rect2 = new Rect();
                                                a2.mo590a(obj, view, arrayList5);
                                                C0344n.m544a(a2, obj, b, a3, c0343a.f325DV, c0343a.f326DW);
                                                if (a9 != null) {
                                                    a2.mo588a(a9, rect2);
                                                }
                                            } else {
                                                rect2 = null;
                                            }
                                            final C0352p c0352p2 = a2;
                                            final Object obj4 = obj;
                                            C0367z.m618a(viewGroup, new Runnable() {
                                                public final void run() {
                                                    C6197a c = C0344n.m548b(c0352p2, a, obj4, c0343a);
                                                    if (c != null) {
                                                        arrayList6.addAll(c.values());
                                                        arrayList6.add(view);
                                                    }
                                                    C0344n.m540a(fragment9, fragment10, z6, c);
                                                    if (obj4 != null) {
                                                        c0352p2.mo593a(obj4, arrayList5, arrayList6);
                                                        View b = C0344n.m534a(c, c0343a, a9, z6);
                                                        if (b != null) {
                                                            C0352p.m559b(b, rect2);
                                                        }
                                                    }
                                                }
                                            });
                                            obj3 = obj;
                                        }
                                    }
                                    if (a9 != null || obj3 != null || b != null) {
                                        Object obj5;
                                        ArrayList a10 = C0344n.m539a(a2, b, fragment8, arrayList5, view);
                                        if (a10 == null || a10.isEmpty()) {
                                            obj5 = null;
                                        } else {
                                            obj5 = b;
                                        }
                                        a2.mo597b(a9, view);
                                        obj = C0344n.m537a(a2, a9, obj5, obj3, fragment7, c0343a.f322DS);
                                        if (obj != null) {
                                            ArrayList arrayList7 = new ArrayList();
                                            a2.mo591a(obj, a9, arrayList7, obj5, a10, obj3, arrayList6);
                                            final Object obj6 = a9;
                                            final C0352p c0352p3 = a2;
                                            final View view3 = view;
                                            final Fragment fragment11 = fragment7;
                                            final ArrayList arrayList8 = arrayList6;
                                            final ArrayList arrayList9 = arrayList7;
                                            final ArrayList arrayList10 = a10;
                                            final Object obj7 = obj5;
                                            C0367z.m618a(viewGroup, new Runnable() {
                                                public final void run() {
                                                    if (obj6 != null) {
                                                        c0352p3.mo600c(obj6, view3);
                                                        arrayList9.addAll(C0344n.m539a(c0352p3, obj6, fragment11, arrayList8, view3));
                                                    }
                                                    if (arrayList10 != null) {
                                                        if (obj7 != null) {
                                                            ArrayList arrayList = new ArrayList();
                                                            arrayList.add(view3);
                                                            c0352p3.mo599b(obj7, arrayList10, arrayList);
                                                        }
                                                        arrayList10.clear();
                                                        arrayList10.add(view3);
                                                    }
                                                }
                                            });
                                            C0367z.m618a(viewGroup, new C03502(arrayList6, a));
                                            a2.mo587a(viewGroup, obj);
                                            C0367z.m618a(viewGroup, new C03513(arrayList6, a));
                                        }
                                    }
                                }
                            }
                        }
                        i4 = i5 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static C6197a<String, String> m532a(int i, ArrayList<C6185b> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        C6197a c6197a = new C6197a();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            C6185b c6185b = (C6185b) arrayList.get(i4);
            if (c6185b.mo13993ar(i)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
                if (c6185b.f1764Cj != null) {
                    ArrayList arrayList3;
                    ArrayList arrayList4;
                    int size = c6185b.f1764Cj.size();
                    if (booleanValue) {
                        arrayList3 = c6185b.f1764Cj;
                        arrayList4 = c6185b.f1765Ck;
                    } else {
                        ArrayList arrayList5 = c6185b.f1764Cj;
                        arrayList3 = c6185b.f1765Ck;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList4.get(i5);
                        String str2 = (String) arrayList3.get(i5);
                        String str3 = (String) c6197a.remove(str2);
                        if (str3 != null) {
                            c6197a.put(str, str3);
                        } else {
                            c6197a.put(str, str2);
                        }
                    }
                }
            }
        }
        return c6197a;
    }

    /* renamed from: a */
    private static C0352p m531a(Fragment fragment, Fragment fragment2) {
        Object exitTransition;
        List arrayList = new ArrayList();
        if (fragment != null) {
            exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            exitTransition = fragment.getReturnTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            exitTransition = fragment.getSharedElementReturnTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
        }
        if (fragment2 != null) {
            exitTransition = fragment2.getEnterTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            exitTransition = fragment2.getReenterTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            exitTransition = fragment2.getSharedElementEnterTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (f328DD != null && C0344n.m547a(f328DD, arrayList)) {
            return f328DD;
        }
        if (f329DE != null && C0344n.m547a(f329DE, arrayList)) {
            return f329DE;
        }
        if (f328DD == null && f329DE == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    /* renamed from: a */
    private static boolean m547a(C0352p c0352p, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!c0352p.mo601j(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static Object m535a(C0352p c0352p, Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        Object sharedElementReturnTransition;
        if (z) {
            sharedElementReturnTransition = fragment2.getSharedElementReturnTransition();
        } else {
            sharedElementReturnTransition = fragment.getSharedElementEnterTransition();
        }
        return c0352p.mo603l(c0352p.mo602k(sharedElementReturnTransition));
    }

    /* renamed from: a */
    private static Object m536a(C0352p c0352p, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        Object reenterTransition;
        if (z) {
            reenterTransition = fragment.getReenterTransition();
        } else {
            reenterTransition = fragment.getEnterTransition();
        }
        return c0352p.mo602k(reenterTransition);
    }

    /* renamed from: b */
    private static Object m550b(C0352p c0352p, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        Object returnTransition;
        if (z) {
            returnTransition = fragment.getReturnTransition();
        } else {
            returnTransition = fragment.getExitTransition();
        }
        return c0352p.mo602k(returnTransition);
    }

    /* renamed from: a */
    private static void m546a(ArrayList<View> arrayList, C6197a<String, View> c6197a, Collection<String> collection) {
        for (int size = c6197a.size() - 1; size >= 0; size--) {
            View view = (View) c6197a.valueAt(size);
            if (collection.contains(C0477s.m917ai(view))) {
                arrayList.add(view);
            }
        }
    }

    /* renamed from: a */
    private static C6197a<String, View> m533a(C0352p c0352p, C6197a<String, String> c6197a, Object obj, C0343a c0343a) {
        if (c6197a.isEmpty() || obj == null) {
            c6197a.clear();
            return null;
        }
        C0324ac enterTransitionCallback;
        Collection collection;
        Fragment fragment = c0343a.f324DU;
        Map c6197a2 = new C6197a();
        c0352p.mo595a(c6197a2, fragment.getView());
        C6185b c6185b = c0343a.f326DW;
        if (c0343a.f325DV) {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
            collection = c6185b.f1765Ck;
        } else {
            enterTransitionCallback = fragment.getExitTransitionCallback();
            Object collection2 = c6185b.f1764Cj;
        }
        C0414h.m696a(c6197a2, collection2);
        if (enterTransitionCallback != null) {
            for (int size = collection2.size() - 1; size >= 0; size--) {
                String str = (String) collection2.get(size);
                View view = (View) c6197a2.get(str);
                if (view == null) {
                    c6197a.remove(str);
                } else if (!str.equals(C0477s.m917ai(view))) {
                    c6197a.put(C0477s.m917ai(view), (String) c6197a.remove(str));
                }
            }
        } else {
            C0414h.m696a((Map) c6197a, c6197a2.keySet());
        }
        return c6197a2;
    }

    /* renamed from: b */
    private static C6197a<String, View> m548b(C0352p c0352p, C6197a<String, String> c6197a, Object obj, C0343a c0343a) {
        Fragment fragment = c0343a.f321DR;
        View view = fragment.getView();
        if (c6197a.isEmpty() || obj == null || view == null) {
            c6197a.clear();
            return null;
        }
        C0324ac exitTransitionCallback;
        Collection collection;
        Map c6197a2 = new C6197a();
        c0352p.mo595a(c6197a2, view);
        C6185b c6185b = c0343a.f323DT;
        if (c0343a.f322DS) {
            exitTransitionCallback = fragment.getExitTransitionCallback();
            collection = c6185b.f1764Cj;
        } else {
            exitTransitionCallback = fragment.getEnterTransitionCallback();
            Object collection2 = c6185b.f1765Ck;
        }
        if (collection2 != null) {
            C0414h.m696a(c6197a2, collection2);
            C0414h.m696a(c6197a2, c6197a.values());
        }
        if (exitTransitionCallback != null) {
            for (int size = collection2.size() - 1; size >= 0; size--) {
                String str = (String) collection2.get(size);
                view = (View) c6197a2.get(str);
                if (view == null) {
                    str = C0344n.m538a((C6197a) c6197a, str);
                    if (str != null) {
                        c6197a.remove(str);
                    }
                } else if (!str.equals(C0477s.m917ai(view))) {
                    str = C0344n.m538a((C6197a) c6197a, str);
                    if (str != null) {
                        c6197a.put(str, C0477s.m917ai(view));
                    }
                }
            }
        } else {
            for (int size2 = c6197a.size() - 1; size2 >= 0; size2--) {
                if (!c6197a2.containsKey((String) c6197a.valueAt(size2))) {
                    c6197a.removeAt(size2);
                }
            }
        }
        return c6197a2;
    }

    /* renamed from: a */
    private static String m538a(C6197a<String, String> c6197a, String str) {
        int size = c6197a.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(c6197a.valueAt(i))) {
                return (String) c6197a.keyAt(i);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static View m534a(C6197a<String, View> c6197a, C0343a c0343a, Object obj, boolean z) {
        C6185b c6185b = c0343a.f323DT;
        if (obj == null || c6197a == null || c6185b.f1764Cj == null || c6185b.f1764Cj.isEmpty()) {
            return null;
        }
        Object obj2;
        if (z) {
            obj2 = (String) c6185b.f1764Cj.get(0);
        } else {
            String obj22 = (String) c6185b.f1765Ck.get(0);
        }
        return (View) c6197a.get(obj22);
    }

    /* renamed from: a */
    private static void m544a(C0352p c0352p, Object obj, Object obj2, C6197a<String, View> c6197a, boolean z, C6185b c6185b) {
        if (c6185b.f1764Cj != null && !c6185b.f1764Cj.isEmpty()) {
            Object obj3;
            if (z) {
                obj3 = (String) c6185b.f1765Ck.get(0);
            } else {
                String obj32 = (String) c6185b.f1764Cj.get(0);
            }
            View view = (View) c6197a.get(obj32);
            c0352p.mo589a(obj, view);
            if (obj2 != null) {
                c0352p.mo589a(obj2, view);
            }
        }
    }

    /* renamed from: a */
    private static void m540a(Fragment fragment, Fragment fragment2, boolean z, C6197a<String, View> c6197a) {
        C0324ac enterTransitionCallback;
        int i = 0;
        if (z) {
            enterTransitionCallback = fragment2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = c6197a == null ? 0 : c6197a.size();
            while (i < size) {
                arrayList2.add(c6197a.keyAt(i));
                arrayList.add(c6197a.valueAt(i));
                i++;
            }
        }
    }

    /* renamed from: a */
    private static ArrayList<View> m539a(C0352p c0352p, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        ArrayList<View> arrayList2 = null;
        if (obj != null) {
            arrayList2 = new ArrayList();
            View view2 = fragment.getView();
            if (view2 != null) {
                c0352p.mo594a((ArrayList) arrayList2, view2);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                c0352p.mo592a(obj, (ArrayList) arrayList2);
            }
        }
        return arrayList2;
    }

    /* renamed from: a */
    private static void m545a(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i);
            }
        }
    }

    /* renamed from: a */
    private static Object m537a(C0352p c0352p, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2 = true;
        if (!(obj == null || obj2 == null || fragment == null)) {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return c0352p.mo585a(obj2, obj, obj3);
        }
        return c0352p.mo596b(obj2, obj, obj3);
    }

    /* renamed from: a */
    private static void m543a(C6185b c6185b, SparseArray<C0343a> sparseArray, boolean z) {
        int size = c6185b.f1750BV.size();
        for (int i = 0; i < size; i++) {
            C0344n.m542a(c6185b, (C0330a) c6185b.f1750BV.get(i), (SparseArray) sparseArray, false, z);
        }
    }

    /* renamed from: b */
    private static void m553b(C6185b c6185b, SparseArray<C0343a> sparseArray, boolean z) {
        if (c6185b.f1749BU.mContainer.onHasView()) {
            for (int size = c6185b.f1750BV.size() - 1; size >= 0; size--) {
                C0344n.m542a(c6185b, (C0330a) c6185b.f1750BV.get(size), (SparseArray) sparseArray, true, z);
            }
        }
    }

    /* renamed from: a */
    private static void m542a(C6185b c6185b, C0330a c0330a, SparseArray<C0343a> sparseArray, boolean z, boolean z2) {
        Fragment fragment = c0330a.fragment;
        if (fragment != null) {
            int i = fragment.mContainerId;
            if (i != 0) {
                int i2;
                int i3;
                C0343a a;
                boolean z3;
                int i4;
                int i5;
                boolean i32;
                int i6;
                switch (z ? f327DC[c0330a.f285Cn] : c0330a.f285Cn) {
                    case 1:
                    case 7:
                        z3 = z2 ? fragment.mIsNewlyAdded : (fragment.mAdded || fragment.mHidden) ? false : true;
                        i4 = 1;
                        i2 = 0;
                        i5 = 0;
                        i32 = z3;
                        break;
                    case 3:
                    case 6:
                        i6 = z2 ? (fragment.mAdded || fragment.mView == null || fragment.mView.getVisibility() != 0 || fragment.mPostponedAlpha < 0.0f) ? 0 : 1 : (!fragment.mAdded || fragment.mHidden) ? 0 : 1;
                        i4 = 0;
                        i2 = i6;
                        i5 = 1;
                        i32 = 0;
                        break;
                    case 4:
                        i6 = z2 ? (fragment.mHiddenChanged && fragment.mAdded && fragment.mHidden) ? 1 : 0 : (!fragment.mAdded || fragment.mHidden) ? 0 : 1;
                        i4 = 0;
                        i2 = i6;
                        i5 = 1;
                        i32 = 0;
                        break;
                    case 5:
                        z3 = z2 ? fragment.mHiddenChanged && !fragment.mHidden && fragment.mAdded : fragment.mHidden;
                        i4 = 1;
                        i2 = 0;
                        i5 = 0;
                        i32 = z3;
                        break;
                    default:
                        i4 = 0;
                        i2 = 0;
                        i5 = 0;
                        i32 = 0;
                        break;
                }
                C0343a c0343a = (C0343a) sparseArray.get(i);
                if (i32 != 0) {
                    a = C0344n.m530a(c0343a, (SparseArray) sparseArray, i);
                    a.f321DR = fragment;
                    a.f322DS = z;
                    a.f323DT = c6185b;
                } else {
                    a = c0343a;
                }
                if (!(z2 || i4 == 0)) {
                    if (a != null && a.f324DU == fragment) {
                        a.f324DU = null;
                    }
                    FragmentManagerImpl fragmentManagerImpl = c6185b.f1749BU;
                    if (fragment.mState <= 0 && fragmentManagerImpl.mCurState > 0 && !c6185b.f1766Cl) {
                        fragmentManagerImpl.makeActive(fragment);
                        fragmentManagerImpl.moveToState(fragment, 1, 0, 0, false);
                    }
                }
                if (i2 == 0 || !(a == null || a.f324DU == null)) {
                    c0343a = a;
                } else {
                    c0343a = C0344n.m530a(a, (SparseArray) sparseArray, i);
                    c0343a.f324DU = fragment;
                    c0343a.f325DV = z;
                    c0343a.f326DW = c6185b;
                }
                if (!z2 && i5 != 0 && c0343a != null && c0343a.f321DR == fragment) {
                    c0343a.f321DR = null;
                }
            }
        }
    }

    /* renamed from: a */
    private static C0343a m530a(C0343a c0343a, SparseArray<C0343a> sparseArray, int i) {
        if (c0343a != null) {
            return c0343a;
        }
        c0343a = new C0343a();
        sparseArray.put(i, c0343a);
        return c0343a;
    }
}
