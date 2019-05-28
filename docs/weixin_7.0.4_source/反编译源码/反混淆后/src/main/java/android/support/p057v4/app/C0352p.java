package android.support.p057v4.app;

import android.graphics.Rect;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.C0488u;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: android.support.v4.app.p */
public abstract class C0352p {

    /* renamed from: android.support.v4.app.p$2 */
    class C03502 implements Runnable {
        /* renamed from: Ec */
        final /* synthetic */ Map f351Ec;
        /* renamed from: yD */
        final /* synthetic */ ArrayList f352yD;

        C03502(ArrayList arrayList, Map map) {
            this.f352yD = arrayList;
            this.f351Ec = map;
        }

        public final void run() {
            int size = this.f352yD.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.f352yD.get(i);
                String ai = C0477s.m917ai(view);
                if (ai != null) {
                    String str;
                    for (Entry entry : this.f351Ec.entrySet()) {
                        if (ai.equals(entry.getValue())) {
                            str = (String) entry.getKey();
                            break;
                        }
                    }
                    str = null;
                    C0477s.m935b(view, str);
                }
            }
        }
    }

    /* renamed from: android.support.v4.app.p$3 */
    class C03513 implements Runnable {
        /* renamed from: Ec */
        final /* synthetic */ Map f354Ec;
        /* renamed from: yD */
        final /* synthetic */ ArrayList f355yD;

        C03513(ArrayList arrayList, Map map) {
            this.f355yD = arrayList;
            this.f354Ec = map;
        }

        public final void run() {
            int size = this.f355yD.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.f355yD.get(i);
                C0477s.m935b(view, (String) this.f354Ec.get(C0477s.m917ai(view)));
            }
        }
    }

    /* renamed from: a */
    public abstract Object mo585a(Object obj, Object obj2, Object obj3);

    /* renamed from: a */
    public abstract void mo587a(ViewGroup viewGroup, Object obj);

    /* renamed from: a */
    public abstract void mo588a(Object obj, Rect rect);

    /* renamed from: a */
    public abstract void mo589a(Object obj, View view);

    /* renamed from: a */
    public abstract void mo590a(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: a */
    public abstract void mo591a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    /* renamed from: a */
    public abstract void mo592a(Object obj, ArrayList<View> arrayList);

    /* renamed from: a */
    public abstract void mo593a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: b */
    public abstract Object mo596b(Object obj, Object obj2, Object obj3);

    /* renamed from: b */
    public abstract void mo597b(Object obj, View view);

    /* renamed from: b */
    public abstract void mo598b(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: b */
    public abstract void mo599b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: c */
    public abstract void mo600c(Object obj, View view);

    /* renamed from: j */
    public abstract boolean mo601j(Object obj);

    /* renamed from: k */
    public abstract Object mo602k(Object obj);

    /* renamed from: l */
    public abstract Object mo603l(Object obj);

    /* renamed from: b */
    protected static void m559b(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    /* renamed from: c */
    static ArrayList<String> m560c(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayList.get(i);
            arrayList2.add(C0477s.m917ai(view));
            C0477s.m935b(view, null);
        }
        return arrayList2;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo586a(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        final int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = (View) arrayList.get(i);
            String ai = C0477s.m917ai(view2);
            arrayList4.add(ai);
            if (ai != null) {
                C0477s.m935b(view2, null);
                String str = (String) map.get(ai);
                for (int i2 = 0; i2 < size; i2++) {
                    if (str.equals(arrayList3.get(i2))) {
                        C0477s.m935b((View) arrayList2.get(i2), ai);
                        break;
                    }
                }
            }
        }
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<String> arrayList6 = arrayList3;
        final ArrayList<View> arrayList7 = arrayList;
        C0367z.m618a(view, new Runnable() {
            public final void run() {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < size) {
                        C0477s.m935b((View) arrayList5.get(i2), (String) arrayList6.get(i2));
                        C0477s.m935b((View) arrayList7.get(i2), (String) arrayList4.get(i2));
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        });
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo594a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (C0488u.m1011e(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                mo594a((ArrayList) arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo595a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String ai = C0477s.m917ai(view);
            if (ai != null) {
                map.put(ai, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    mo595a((Map) map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* renamed from: a */
    protected static void m557a(List<View> list, View view) {
        int size = list.size();
        if (!C0352p.m558a((List) list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = (View) list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!C0352p.m558a((List) list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m558a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    public static boolean m561h(List list) {
        return list == null || list.isEmpty();
    }
}
