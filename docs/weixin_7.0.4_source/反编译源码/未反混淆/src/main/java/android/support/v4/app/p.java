package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.view.s;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class p {

    /* renamed from: android.support.v4.app.p$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Map Ec;
        final /* synthetic */ ArrayList yD;

        AnonymousClass2(ArrayList arrayList, Map map) {
            this.yD = arrayList;
            this.Ec = map;
        }

        public final void run() {
            int size = this.yD.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.yD.get(i);
                String ai = s.ai(view);
                if (ai != null) {
                    String str;
                    for (Entry entry : this.Ec.entrySet()) {
                        if (ai.equals(entry.getValue())) {
                            str = (String) entry.getKey();
                            break;
                        }
                    }
                    str = null;
                    s.b(view, str);
                }
            }
        }
    }

    /* renamed from: android.support.v4.app.p$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ Map Ec;
        final /* synthetic */ ArrayList yD;

        AnonymousClass3(ArrayList arrayList, Map map) {
            this.yD = arrayList;
            this.Ec = map;
        }

        public final void run() {
            int size = this.yD.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.yD.get(i);
                s.b(view, (String) this.Ec.get(s.ai(view)));
            }
        }
    }

    public abstract Object a(Object obj, Object obj2, Object obj3);

    public abstract void a(ViewGroup viewGroup, Object obj);

    public abstract void a(Object obj, Rect rect);

    public abstract void a(Object obj, View view);

    public abstract void a(Object obj, View view, ArrayList<View> arrayList);

    public abstract void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void a(Object obj, ArrayList<View> arrayList);

    public abstract void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object b(Object obj, Object obj2, Object obj3);

    public abstract void b(Object obj, View view);

    public abstract void b(Object obj, View view, ArrayList<View> arrayList);

    public abstract void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void c(Object obj, View view);

    public abstract boolean j(Object obj);

    public abstract Object k(Object obj);

    public abstract Object l(Object obj);

    protected static void b(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    static ArrayList<String> c(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayList.get(i);
            arrayList2.add(s.ai(view));
            s.b(view, null);
        }
        return arrayList2;
    }

    /* Access modifiers changed, original: final */
    public final void a(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        final int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = (View) arrayList.get(i);
            String ai = s.ai(view2);
            arrayList4.add(ai);
            if (ai != null) {
                s.b(view2, null);
                String str = (String) map.get(ai);
                for (int i2 = 0; i2 < size; i2++) {
                    if (str.equals(arrayList3.get(i2))) {
                        s.b((View) arrayList2.get(i2), ai);
                        break;
                    }
                }
            }
        }
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<String> arrayList6 = arrayList3;
        final ArrayList<View> arrayList7 = arrayList;
        z.a(view, new Runnable() {
            public final void run() {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < size) {
                        s.b((View) arrayList5.get(i2), (String) arrayList6.get(i2));
                        s.b((View) arrayList7.get(i2), (String) arrayList4.get(i2));
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        });
    }

    /* Access modifiers changed, original: final */
    public final void a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (u.e(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a((ArrayList) arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    /* Access modifiers changed, original: final */
    public final void a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String ai = s.ai(view);
            if (ai != null) {
                map.put(ai, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a((Map) map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    protected static void a(List<View> list, View view) {
        int size = list.size();
        if (!a((List) list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = (View) list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!a((List) list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    private static boolean a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public static boolean h(List list) {
        return list == null || list.isEmpty();
    }
}
