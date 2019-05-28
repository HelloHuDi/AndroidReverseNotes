package android.support.transition;

import android.graphics.Rect;
import android.support.p057v4.app.C0352p;
import android.support.transition.Transition.C31851b;
import android.support.transition.Transition.C31852c;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.transition.g */
public class C25328g extends C0352p {
    /* renamed from: j */
    public final boolean mo601j(Object obj) {
        return obj instanceof Transition;
    }

    /* renamed from: k */
    public final Object mo602k(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    /* renamed from: l */
    public final Object mo603l(Object obj) {
        if (obj == null) {
            return null;
        }
        Object transitionSet = new TransitionSet();
        transitionSet.mo42282d((Transition) obj);
        return transitionSet;
    }

    /* renamed from: a */
    public final void mo590a(Object obj, View view, ArrayList<View> arrayList) {
        obj = (TransitionSet) obj;
        ArrayList arrayList2 = obj.f15712zM;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C0352p.m557a((List) arrayList2, (View) arrayList.get(i));
        }
        arrayList2.add(view);
        arrayList.add(view);
        mo592a(obj, (ArrayList) arrayList);
    }

    /* renamed from: a */
    public final void mo589a(Object obj, View view) {
        if (view != null) {
            Transition transition = (Transition) obj;
            final Rect rect = new Rect();
            C0352p.m559b(view, rect);
            transition.mo42272a(new C31851b() {
                /* renamed from: cS */
                public final Rect mo18301cS() {
                    return rect;
                }
            });
        }
    }

    /* renamed from: a */
    public final void mo592a(Object obj, ArrayList<View> arrayList) {
        int i = 0;
        Transition transition = (Transition) obj;
        if (transition != null) {
            int size;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                size = transitionSet.f5121Av.size();
                while (i < size) {
                    mo592a(transitionSet.mo42276ap(i), (ArrayList) arrayList);
                    i++;
                }
            } else if (!C25328g.m39956b(transition) && C0352p.m561h(transition.f15712zM)) {
                int size2 = arrayList.size();
                for (size = 0; size < size2; size++) {
                    transition.mo42266D((View) arrayList.get(size));
                }
            }
        }
    }

    /* renamed from: a */
    public final Object mo585a(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.mo42282d((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.mo42282d((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.mo42282d((Transition) obj3);
        }
        return transitionSet;
    }

    /* renamed from: b */
    public final void mo598b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).mo42271a(new C31852c() {
            /* renamed from: cT */
            public final void mo31631cT() {
            }

            /* renamed from: a */
            public final void mo452a(Transition transition) {
                transition.mo42277b((C31852c) this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }

            /* renamed from: cO */
            public final void mo18279cO() {
            }

            /* renamed from: cP */
            public final void mo18280cP() {
            }
        });
    }

    /* renamed from: b */
    public final Object mo596b(Object obj, Object obj2, Object obj3) {
        Transition transition = null;
        Transition transition2 = (Transition) obj;
        Transition transition3 = (Transition) obj2;
        Transition transition4 = (Transition) obj3;
        if (transition2 != null && transition3 != null) {
            transition = new TransitionSet().mo42282d(transition2).mo42282d(transition3).mo42275ao(1);
        } else if (transition2 != null) {
            transition = transition2;
        } else if (transition3 != null) {
            transition = transition3;
        }
        if (transition4 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.mo42282d(transition);
        }
        transitionSet.mo42282d(transition4);
        return transitionSet;
    }

    /* renamed from: a */
    public final void mo587a(ViewGroup viewGroup, Object obj) {
        C44947ae.m82221a(viewGroup, (Transition) obj);
    }

    /* renamed from: a */
    public final void mo591a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((Transition) obj).mo42271a(new C31852c() {
            /* renamed from: cT */
            public final void mo31631cT() {
                if (obj5 != null) {
                    C25328g.this.mo599b(obj5, arrayList4, null);
                }
                if (obj6 != null) {
                    C25328g.this.mo599b(obj6, arrayList5, null);
                }
                if (obj7 != null) {
                    C25328g.this.mo599b(obj7, arrayList6, null);
                }
            }

            /* renamed from: a */
            public final void mo452a(Transition transition) {
            }

            /* renamed from: cO */
            public final void mo18279cO() {
            }

            /* renamed from: cP */
            public final void mo18280cP() {
            }
        });
    }

    /* renamed from: a */
    public final void mo593a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        obj = (TransitionSet) obj;
        if (obj != null) {
            obj.f15712zM.clear();
            obj.f15712zM.addAll(arrayList2);
            mo599b(obj, (ArrayList) arrayList, (ArrayList) arrayList2);
        }
    }

    /* renamed from: b */
    public final void mo599b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i = 0;
        Transition transition = (Transition) obj;
        int size;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            size = transitionSet.f5121Av.size();
            while (i < size) {
                mo599b(transitionSet.mo42276ap(i), (ArrayList) arrayList, (ArrayList) arrayList2);
                i++;
            }
        } else if (!C25328g.m39956b(transition)) {
            ArrayList arrayList3 = transition.f15712zM;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                size = arrayList2 == null ? 0 : arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    transition.mo42266D((View) arrayList2.get(i2));
                }
                for (size = arrayList.size() - 1; size >= 0; size--) {
                    transition.mo42267E((View) arrayList.get(size));
                }
            }
        }
    }

    /* renamed from: b */
    public final void mo597b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).mo42266D(view);
        }
    }

    /* renamed from: c */
    public final void mo600c(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).mo42267E(view);
        }
    }

    /* renamed from: a */
    public final void mo588a(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).mo42272a(new C31851b() {
                /* renamed from: cS */
                public final Rect mo18301cS() {
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }

    /* renamed from: b */
    private static boolean m39956b(Transition transition) {
        return (C0352p.m561h(transition.f15711zL) && C0352p.m561h(transition.f15713zN) && C0352p.m561h(transition.f15714zO)) ? false : true;
    }
}
