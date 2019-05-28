package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.f.h;
import android.support.v4.view.s;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class n {
    private static final int[] DC = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8};
    private static final p DD = (VERSION.SDK_INT >= 21 ? new o() : null);
    private static final p DE = dp();

    static class a {
        public Fragment DR;
        public boolean DS;
        public b DT;
        public Fragment DU;
        public boolean DV;
        public b DW;

        a() {
        }
    }

    private static p dp() {
        try {
            return (p) Class.forName("android.support.transition.g").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    static void a(FragmentManagerImpl fragmentManagerImpl, ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (fragmentManagerImpl.mCurState > 0) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                b bVar = (b) arrayList.get(i3);
                if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                    b(bVar, sparseArray, z);
                } else {
                    a(bVar, sparseArray, z);
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
                        final android.support.v4.f.a a = a(keyAt, (ArrayList) arrayList, (ArrayList) arrayList2, i, i2);
                        final a aVar = (a) sparseArray.valueAt(i5);
                        p a2;
                        boolean z2;
                        Object b;
                        Object obj;
                        android.support.v4.f.a a3;
                        View a4;
                        if (z) {
                            View view2;
                            if (fragmentManagerImpl.mContainer.onHasView()) {
                                view2 = (ViewGroup) fragmentManagerImpl.mContainer.onFindViewById(keyAt);
                            } else {
                                view2 = null;
                            }
                            if (view2 != null) {
                                Fragment fragment = aVar.DR;
                                Fragment fragment2 = aVar.DU;
                                a2 = a(fragment2, fragment);
                                if (a2 != null) {
                                    Object obj2;
                                    boolean z3 = aVar.DS;
                                    z2 = aVar.DV;
                                    ArrayList arrayList3 = new ArrayList();
                                    ArrayList arrayList4 = new ArrayList();
                                    Object a5 = a(a2, fragment, z3);
                                    b = b(a2, fragment2, z2);
                                    Fragment fragment3 = aVar.DR;
                                    Fragment fragment4 = aVar.DU;
                                    if (fragment3 != null) {
                                        fragment3.getView().setVisibility(0);
                                    }
                                    if (fragment3 == null || fragment4 == null) {
                                        obj2 = null;
                                    } else {
                                        final boolean z4 = aVar.DS;
                                        if (a.isEmpty()) {
                                            obj = null;
                                        } else {
                                            obj = a(a2, fragment3, fragment4, z4);
                                        }
                                        a3 = a(a2, a, obj, aVar);
                                        final android.support.v4.f.a b2 = b(a2, a, obj, aVar);
                                        if (a.isEmpty()) {
                                            obj = null;
                                            if (a3 != null) {
                                                a3.clear();
                                            }
                                            if (b2 != null) {
                                                b2.clear();
                                            }
                                        } else {
                                            a(arrayList4, a3, a.keySet());
                                            a(arrayList3, b2, a.values());
                                        }
                                        if (a5 == null && b == null && obj == null) {
                                            obj2 = null;
                                        } else {
                                            Rect rect;
                                            a(fragment3, fragment4, z4, a3);
                                            if (obj != null) {
                                                arrayList3.add(view);
                                                a2.a(obj, view, arrayList4);
                                                a(a2, obj, b, a3, aVar.DV, aVar.DW);
                                                rect = new Rect();
                                                a4 = a(b2, aVar, a5, z4);
                                                if (a4 != null) {
                                                    a2.a(a5, rect);
                                                }
                                            } else {
                                                rect = null;
                                                a4 = null;
                                            }
                                            final Fragment fragment5 = fragment3;
                                            final Fragment fragment6 = fragment4;
                                            final p pVar = a2;
                                            z.a(view2, new Runnable() {
                                                public final void run() {
                                                    n.a(fragment5, fragment6, z4, b2);
                                                    if (a4 != null) {
                                                        p.b(a4, rect);
                                                    }
                                                }
                                            });
                                            obj2 = obj;
                                        }
                                    }
                                    if (a5 != null || obj2 != null || b != null) {
                                        final ArrayList a6 = a(a2, b, fragment2, arrayList4, view);
                                        ArrayList a7 = a(a2, a5, fragment, arrayList3, view);
                                        a(a7, 4);
                                        Object a8 = a(a2, a5, b, obj2, fragment, z3);
                                        if (a8 != null) {
                                            if (fragment2 != null && b != null && fragment2.mAdded && fragment2.mHidden && fragment2.mHiddenChanged) {
                                                fragment2.setHideReplaced(true);
                                                a2.b(b, fragment2.getView(), a6);
                                                z.a(fragment2.mContainer, new Runnable() {
                                                    public final void run() {
                                                        n.a(a6, 4);
                                                    }
                                                });
                                            }
                                            ArrayList c = p.c(arrayList3);
                                            a2.a(a8, a5, a7, b, a6, obj2, arrayList3);
                                            a2.a((ViewGroup) view2, a8);
                                            a2.a(view2, arrayList4, arrayList3, c, a);
                                            a(a7, 0);
                                            a2.a(obj2, arrayList4, arrayList3);
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
                                Fragment fragment7 = aVar.DR;
                                Fragment fragment8 = aVar.DU;
                                a2 = a(fragment8, fragment7);
                                if (a2 != null) {
                                    Object obj3;
                                    z2 = aVar.DS;
                                    boolean z5 = aVar.DV;
                                    final Object a9 = a(a2, fragment7, z2);
                                    b = b(a2, fragment8, z5);
                                    final ArrayList arrayList5 = new ArrayList();
                                    final ArrayList arrayList6 = new ArrayList();
                                    final Fragment fragment9 = aVar.DR;
                                    final Fragment fragment10 = aVar.DU;
                                    if (fragment9 == null || fragment10 == null) {
                                        obj3 = null;
                                    } else {
                                        final boolean z6 = aVar.DS;
                                        if (a.isEmpty()) {
                                            obj = null;
                                        } else {
                                            obj = a(a2, fragment9, fragment10, z6);
                                        }
                                        a3 = a(a2, a, obj, aVar);
                                        if (a.isEmpty()) {
                                            obj = null;
                                        } else {
                                            arrayList5.addAll(a3.values());
                                        }
                                        if (a9 == null && b == null && obj == null) {
                                            obj3 = null;
                                        } else {
                                            Rect rect2;
                                            a(fragment9, fragment10, z6, a3);
                                            if (obj != null) {
                                                rect2 = new Rect();
                                                a2.a(obj, view, arrayList5);
                                                a(a2, obj, b, a3, aVar.DV, aVar.DW);
                                                if (a9 != null) {
                                                    a2.a(a9, rect2);
                                                }
                                            } else {
                                                rect2 = null;
                                            }
                                            final p pVar2 = a2;
                                            final Object obj4 = obj;
                                            z.a(viewGroup, new Runnable() {
                                                public final void run() {
                                                    android.support.v4.f.a c = n.b(pVar2, a, obj4, aVar);
                                                    if (c != null) {
                                                        arrayList6.addAll(c.values());
                                                        arrayList6.add(view);
                                                    }
                                                    n.a(fragment9, fragment10, z6, c);
                                                    if (obj4 != null) {
                                                        pVar2.a(obj4, arrayList5, arrayList6);
                                                        View b = n.a(c, aVar, a9, z6);
                                                        if (b != null) {
                                                            p.b(b, rect2);
                                                        }
                                                    }
                                                }
                                            });
                                            obj3 = obj;
                                        }
                                    }
                                    if (a9 != null || obj3 != null || b != null) {
                                        Object obj5;
                                        ArrayList a10 = a(a2, b, fragment8, arrayList5, view);
                                        if (a10 == null || a10.isEmpty()) {
                                            obj5 = null;
                                        } else {
                                            obj5 = b;
                                        }
                                        a2.b(a9, view);
                                        obj = a(a2, a9, obj5, obj3, fragment7, aVar.DS);
                                        if (obj != null) {
                                            ArrayList arrayList7 = new ArrayList();
                                            a2.a(obj, a9, arrayList7, obj5, a10, obj3, arrayList6);
                                            final Object obj6 = a9;
                                            final p pVar3 = a2;
                                            final View view3 = view;
                                            final Fragment fragment11 = fragment7;
                                            final ArrayList arrayList8 = arrayList6;
                                            final ArrayList arrayList9 = arrayList7;
                                            final ArrayList arrayList10 = a10;
                                            final Object obj7 = obj5;
                                            z.a(viewGroup, new Runnable() {
                                                public final void run() {
                                                    if (obj6 != null) {
                                                        pVar3.c(obj6, view3);
                                                        arrayList9.addAll(n.a(pVar3, obj6, fragment11, arrayList8, view3));
                                                    }
                                                    if (arrayList10 != null) {
                                                        if (obj7 != null) {
                                                            ArrayList arrayList = new ArrayList();
                                                            arrayList.add(view3);
                                                            pVar3.b(obj7, arrayList10, arrayList);
                                                        }
                                                        arrayList10.clear();
                                                        arrayList10.add(view3);
                                                    }
                                                }
                                            });
                                            z.a(viewGroup, new android.support.v4.app.p.AnonymousClass2(arrayList6, a));
                                            a2.a(viewGroup, obj);
                                            z.a(viewGroup, new android.support.v4.app.p.AnonymousClass3(arrayList6, a));
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

    private static android.support.v4.f.a<String, String> a(int i, ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        android.support.v4.f.a aVar = new android.support.v4.f.a();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            b bVar = (b) arrayList.get(i4);
            if (bVar.ar(i)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
                if (bVar.Cj != null) {
                    ArrayList arrayList3;
                    ArrayList arrayList4;
                    int size = bVar.Cj.size();
                    if (booleanValue) {
                        arrayList3 = bVar.Cj;
                        arrayList4 = bVar.Ck;
                    } else {
                        ArrayList arrayList5 = bVar.Cj;
                        arrayList3 = bVar.Ck;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList4.get(i5);
                        String str2 = (String) arrayList3.get(i5);
                        String str3 = (String) aVar.remove(str2);
                        if (str3 != null) {
                            aVar.put(str, str3);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private static p a(Fragment fragment, Fragment fragment2) {
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
        if (DD != null && a(DD, arrayList)) {
            return DD;
        }
        if (DE != null && a(DE, arrayList)) {
            return DE;
        }
        if (DD == null && DE == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static boolean a(p pVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!pVar.j(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static Object a(p pVar, Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        Object sharedElementReturnTransition;
        if (z) {
            sharedElementReturnTransition = fragment2.getSharedElementReturnTransition();
        } else {
            sharedElementReturnTransition = fragment.getSharedElementEnterTransition();
        }
        return pVar.l(pVar.k(sharedElementReturnTransition));
    }

    private static Object a(p pVar, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        Object reenterTransition;
        if (z) {
            reenterTransition = fragment.getReenterTransition();
        } else {
            reenterTransition = fragment.getEnterTransition();
        }
        return pVar.k(reenterTransition);
    }

    private static Object b(p pVar, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        Object returnTransition;
        if (z) {
            returnTransition = fragment.getReturnTransition();
        } else {
            returnTransition = fragment.getExitTransition();
        }
        return pVar.k(returnTransition);
    }

    private static void a(ArrayList<View> arrayList, android.support.v4.f.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.valueAt(size);
            if (collection.contains(s.ai(view))) {
                arrayList.add(view);
            }
        }
    }

    private static android.support.v4.f.a<String, View> a(p pVar, android.support.v4.f.a<String, String> aVar, Object obj, a aVar2) {
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        ac enterTransitionCallback;
        Collection collection;
        Fragment fragment = aVar2.DU;
        Map aVar3 = new android.support.v4.f.a();
        pVar.a(aVar3, fragment.getView());
        b bVar = aVar2.DW;
        if (aVar2.DV) {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
            collection = bVar.Ck;
        } else {
            enterTransitionCallback = fragment.getExitTransitionCallback();
            Object collection2 = bVar.Cj;
        }
        h.a(aVar3, collection2);
        if (enterTransitionCallback != null) {
            for (int size = collection2.size() - 1; size >= 0; size--) {
                String str = (String) collection2.get(size);
                View view = (View) aVar3.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(s.ai(view))) {
                    aVar.put(s.ai(view), (String) aVar.remove(str));
                }
            }
        } else {
            h.a((Map) aVar, aVar3.keySet());
        }
        return aVar3;
    }

    private static android.support.v4.f.a<String, View> b(p pVar, android.support.v4.f.a<String, String> aVar, Object obj, a aVar2) {
        Fragment fragment = aVar2.DR;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        ac exitTransitionCallback;
        Collection collection;
        Map aVar3 = new android.support.v4.f.a();
        pVar.a(aVar3, view);
        b bVar = aVar2.DT;
        if (aVar2.DS) {
            exitTransitionCallback = fragment.getExitTransitionCallback();
            collection = bVar.Cj;
        } else {
            exitTransitionCallback = fragment.getEnterTransitionCallback();
            Object collection2 = bVar.Ck;
        }
        if (collection2 != null) {
            h.a(aVar3, collection2);
            h.a(aVar3, aVar.values());
        }
        if (exitTransitionCallback != null) {
            for (int size = collection2.size() - 1; size >= 0; size--) {
                String str = (String) collection2.get(size);
                view = (View) aVar3.get(str);
                if (view == null) {
                    str = a((android.support.v4.f.a) aVar, str);
                    if (str != null) {
                        aVar.remove(str);
                    }
                } else if (!str.equals(s.ai(view))) {
                    str = a((android.support.v4.f.a) aVar, str);
                    if (str != null) {
                        aVar.put(str, s.ai(view));
                    }
                }
            }
        } else {
            for (int size2 = aVar.size() - 1; size2 >= 0; size2--) {
                if (!aVar3.containsKey((String) aVar.valueAt(size2))) {
                    aVar.removeAt(size2);
                }
            }
        }
        return aVar3;
    }

    private static String a(android.support.v4.f.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.valueAt(i))) {
                return (String) aVar.keyAt(i);
            }
        }
        return null;
    }

    private static View a(android.support.v4.f.a<String, View> aVar, a aVar2, Object obj, boolean z) {
        b bVar = aVar2.DT;
        if (obj == null || aVar == null || bVar.Cj == null || bVar.Cj.isEmpty()) {
            return null;
        }
        Object obj2;
        if (z) {
            obj2 = (String) bVar.Cj.get(0);
        } else {
            String obj22 = (String) bVar.Ck.get(0);
        }
        return (View) aVar.get(obj22);
    }

    private static void a(p pVar, Object obj, Object obj2, android.support.v4.f.a<String, View> aVar, boolean z, b bVar) {
        if (bVar.Cj != null && !bVar.Cj.isEmpty()) {
            Object obj3;
            if (z) {
                obj3 = (String) bVar.Ck.get(0);
            } else {
                String obj32 = (String) bVar.Cj.get(0);
            }
            View view = (View) aVar.get(obj32);
            pVar.a(obj, view);
            if (obj2 != null) {
                pVar.a(obj2, view);
            }
        }
    }

    private static void a(Fragment fragment, Fragment fragment2, boolean z, android.support.v4.f.a<String, View> aVar) {
        ac enterTransitionCallback;
        int i = 0;
        if (z) {
            enterTransitionCallback = fragment2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            while (i < size) {
                arrayList2.add(aVar.keyAt(i));
                arrayList.add(aVar.valueAt(i));
                i++;
            }
        }
    }

    private static ArrayList<View> a(p pVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        ArrayList<View> arrayList2 = null;
        if (obj != null) {
            arrayList2 = new ArrayList();
            View view2 = fragment.getView();
            if (view2 != null) {
                pVar.a((ArrayList) arrayList2, view2);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                pVar.a(obj, (ArrayList) arrayList2);
            }
        }
        return arrayList2;
    }

    private static void a(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i);
            }
        }
    }

    private static Object a(p pVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2 = true;
        if (!(obj == null || obj2 == null || fragment == null)) {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return pVar.a(obj2, obj, obj3);
        }
        return pVar.b(obj2, obj, obj3);
    }

    private static void a(b bVar, SparseArray<a> sparseArray, boolean z) {
        int size = bVar.BV.size();
        for (int i = 0; i < size; i++) {
            a(bVar, (a) bVar.BV.get(i), (SparseArray) sparseArray, false, z);
        }
    }

    private static void b(b bVar, SparseArray<a> sparseArray, boolean z) {
        if (bVar.BU.mContainer.onHasView()) {
            for (int size = bVar.BV.size() - 1; size >= 0; size--) {
                a(bVar, (a) bVar.BV.get(size), (SparseArray) sparseArray, true, z);
            }
        }
    }

    private static void a(b bVar, a aVar, SparseArray<a> sparseArray, boolean z, boolean z2) {
        Fragment fragment = aVar.fragment;
        if (fragment != null) {
            int i = fragment.mContainerId;
            if (i != 0) {
                int i2;
                int i3;
                a a;
                boolean z3;
                int i4;
                int i5;
                boolean i32;
                int i6;
                switch (z ? DC[aVar.Cn] : aVar.Cn) {
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
                a aVar2 = (a) sparseArray.get(i);
                if (i32 != 0) {
                    a = a(aVar2, (SparseArray) sparseArray, i);
                    a.DR = fragment;
                    a.DS = z;
                    a.DT = bVar;
                } else {
                    a = aVar2;
                }
                if (!(z2 || i4 == 0)) {
                    if (a != null && a.DU == fragment) {
                        a.DU = null;
                    }
                    FragmentManagerImpl fragmentManagerImpl = bVar.BU;
                    if (fragment.mState <= 0 && fragmentManagerImpl.mCurState > 0 && !bVar.Cl) {
                        fragmentManagerImpl.makeActive(fragment);
                        fragmentManagerImpl.moveToState(fragment, 1, 0, 0, false);
                    }
                }
                if (i2 == 0 || !(a == null || a.DU == null)) {
                    aVar2 = a;
                } else {
                    aVar2 = a(a, (SparseArray) sparseArray, i);
                    aVar2.DU = fragment;
                    aVar2.DV = z;
                    aVar2.DW = bVar;
                }
                if (!z2 && i5 != 0 && aVar2 != null && aVar2.DR == fragment) {
                    aVar2.DR = null;
                }
            }
        }
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar != null) {
            return aVar;
        }
        aVar = new a();
        sparseArray.put(i, aVar);
        return aVar;
    }
}
