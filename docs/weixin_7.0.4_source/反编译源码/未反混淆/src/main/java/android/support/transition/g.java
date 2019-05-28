package android.support.transition;

import android.graphics.Rect;
import android.support.transition.Transition.b;
import android.support.transition.Transition.c;
import android.support.v4.app.p;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class g extends p {
    public final boolean j(Object obj) {
        return obj instanceof Transition;
    }

    public final Object k(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    public final Object l(Object obj) {
        if (obj == null) {
            return null;
        }
        Object transitionSet = new TransitionSet();
        transitionSet.d((Transition) obj);
        return transitionSet;
    }

    public final void a(Object obj, View view, ArrayList<View> arrayList) {
        obj = (TransitionSet) obj;
        ArrayList arrayList2 = obj.zM;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            p.a((List) arrayList2, (View) arrayList.get(i));
        }
        arrayList2.add(view);
        arrayList.add(view);
        a(obj, (ArrayList) arrayList);
    }

    public final void a(Object obj, View view) {
        if (view != null) {
            Transition transition = (Transition) obj;
            final Rect rect = new Rect();
            p.b(view, rect);
            transition.a(new b() {
                public final Rect cS() {
                    return rect;
                }
            });
        }
    }

    public final void a(Object obj, ArrayList<View> arrayList) {
        int i = 0;
        Transition transition = (Transition) obj;
        if (transition != null) {
            int size;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                size = transitionSet.Av.size();
                while (i < size) {
                    a(transitionSet.ap(i), (ArrayList) arrayList);
                    i++;
                }
            } else if (!b(transition) && p.h(transition.zM)) {
                int size2 = arrayList.size();
                for (size = 0; size < size2; size++) {
                    transition.D((View) arrayList.get(size));
                }
            }
        }
    }

    public final Object a(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.d((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.d((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.d((Transition) obj3);
        }
        return transitionSet;
    }

    public final void b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).a(new c() {
            public final void cT() {
            }

            public final void a(Transition transition) {
                transition.b((c) this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }

            public final void cO() {
            }

            public final void cP() {
            }
        });
    }

    public final Object b(Object obj, Object obj2, Object obj3) {
        Transition transition = null;
        Transition transition2 = (Transition) obj;
        Transition transition3 = (Transition) obj2;
        Transition transition4 = (Transition) obj3;
        if (transition2 != null && transition3 != null) {
            transition = new TransitionSet().d(transition2).d(transition3).ao(1);
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
            transitionSet.d(transition);
        }
        transitionSet.d(transition4);
        return transitionSet;
    }

    public final void a(ViewGroup viewGroup, Object obj) {
        ae.a(viewGroup, (Transition) obj);
    }

    public final void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((Transition) obj).a(new c() {
            public final void cT() {
                if (obj5 != null) {
                    g.this.b(obj5, arrayList4, null);
                }
                if (obj6 != null) {
                    g.this.b(obj6, arrayList5, null);
                }
                if (obj7 != null) {
                    g.this.b(obj7, arrayList6, null);
                }
            }

            public final void a(Transition transition) {
            }

            public final void cO() {
            }

            public final void cP() {
            }
        });
    }

    public final void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        obj = (TransitionSet) obj;
        if (obj != null) {
            obj.zM.clear();
            obj.zM.addAll(arrayList2);
            b(obj, (ArrayList) arrayList, (ArrayList) arrayList2);
        }
    }

    public final void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i = 0;
        Transition transition = (Transition) obj;
        int size;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            size = transitionSet.Av.size();
            while (i < size) {
                b(transitionSet.ap(i), (ArrayList) arrayList, (ArrayList) arrayList2);
                i++;
            }
        } else if (!b(transition)) {
            ArrayList arrayList3 = transition.zM;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                size = arrayList2 == null ? 0 : arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    transition.D((View) arrayList2.get(i2));
                }
                for (size = arrayList.size() - 1; size >= 0; size--) {
                    transition.E((View) arrayList.get(size));
                }
            }
        }
    }

    public final void b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).D(view);
        }
    }

    public final void c(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).E(view);
        }
    }

    public final void a(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).a(new b() {
                public final Rect cS() {
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }

    private static boolean b(Transition transition) {
        return (p.h(transition.zL) && p.h(transition.zN) && p.h(transition.zO)) ? false : true;
    }
}
