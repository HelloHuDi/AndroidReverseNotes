package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.Lifecycle.State;
import android.arch.p1150a.p1152b.C17362a;
import android.arch.p1150a.p1152b.C41468b.C17363b;
import android.arch.p1150a.p1152b.C41468b.C25283c;
import android.arch.p1150a.p1152b.C41468b.C37092d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map.Entry;

public class LifecycleRegistry extends Lifecycle {
    /* renamed from: cm */
    private C17362a<LifecycleObserver, ObserverWithState> f1696cm = new C17362a();
    /* renamed from: cn */
    private State f1697cn;
    /* renamed from: co */
    private final WeakReference<LifecycleOwner> f1698co;
    /* renamed from: cp */
    private int f1699cp = 0;
    /* renamed from: cq */
    private boolean f1700cq = false;
    /* renamed from: cs */
    private boolean f1701cs = false;
    /* renamed from: ct */
    private ArrayList<State> f1702ct = new ArrayList();

    static class ObserverWithState {
        /* renamed from: cn */
        State f10cn;
        /* renamed from: cv */
        GenericLifecycleObserver f11cv;

        ObserverWithState(LifecycleObserver lifecycleObserver, State state) {
            this.f11cv = Lifecycling.m319e(lifecycleObserver);
            this.f10cn = state;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo292a(LifecycleOwner lifecycleOwner, Event event) {
            State a = LifecycleRegistry.m9842a(event);
            this.f10cn = LifecycleRegistry.m9843a(this.f10cn, a);
            this.f11cv.onStateChanged(lifecycleOwner, event);
            this.f10cn = a;
        }
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        this.f1698co = new WeakReference(lifecycleOwner);
        this.f1697cn = State.INITIALIZED;
    }

    public void markState(State state) {
        m9845a(state);
    }

    public void handleLifecycleEvent(Event event) {
        m9845a(m9842a(event));
    }

    /* renamed from: a */
    private void m9845a(State state) {
        if (this.f1697cn != state) {
            this.f1697cn = state;
            if (this.f1700cq || this.f1699cp != 0) {
                this.f1701cs = true;
                return;
            }
            this.f1700cq = true;
            sync();
            this.f1700cq = false;
        }
    }

    /* renamed from: ad */
    private boolean m9847ad() {
        if (this.f1696cm.mSize == 0) {
            return true;
        }
        State state = ((ObserverWithState) this.f1696cm.f16596bS.getValue()).f10cn;
        State state2 = ((ObserverWithState) this.f1696cm.f16597bT.getValue()).f10cn;
        return state == state2 && this.f1697cn == state2;
    }

    /* renamed from: a */
    private State m9844a(LifecycleObserver lifecycleObserver) {
        Entry entry;
        State state;
        C17362a c17362a = this.f1696cm;
        if (c17362a.contains(lifecycleObserver)) {
            entry = ((C25283c) c17362a.f3605bR.get(lifecycleObserver)).f5023bX;
        } else {
            entry = null;
        }
        State state2 = entry != null ? ((ObserverWithState) entry.getValue()).f10cn : null;
        if (this.f1702ct.isEmpty()) {
            state = null;
        } else {
            state = (State) this.f1702ct.get(this.f1702ct.size() - 1);
        }
        return m9843a(m9843a(this.f1697cn, state2), state);
    }

    public void addObserver(LifecycleObserver lifecycleObserver) {
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, this.f1697cn == State.DESTROYED ? State.DESTROYED : State.INITIALIZED);
        if (((ObserverWithState) this.f1696cm.putIfAbsent(lifecycleObserver, observerWithState)) == null) {
            LifecycleOwner lifecycleOwner = (LifecycleOwner) this.f1698co.get();
            if (lifecycleOwner != null) {
                Object obj = (this.f1699cp != 0 || this.f1700cq) ? 1 : null;
                Enum a = m9844a(lifecycleObserver);
                this.f1699cp++;
                while (observerWithState.f10cn.compareTo(a) < 0 && this.f1696cm.contains(lifecycleObserver)) {
                    m9849b(observerWithState.f10cn);
                    observerWithState.mo292a(lifecycleOwner, m9851c(observerWithState.f10cn));
                    m9848af();
                    a = m9844a(lifecycleObserver);
                }
                if (obj == null) {
                    sync();
                }
                this.f1699cp--;
            }
        }
    }

    /* renamed from: af */
    private void m9848af() {
        this.f1702ct.remove(this.f1702ct.size() - 1);
    }

    /* renamed from: b */
    private void m9849b(State state) {
        this.f1702ct.add(state);
    }

    public void removeObserver(LifecycleObserver lifecycleObserver) {
        this.f1696cm.remove(lifecycleObserver);
    }

    public int getObserverCount() {
        return this.f1696cm.mSize;
    }

    public State getCurrentState() {
        return this.f1697cn;
    }

    /* renamed from: a */
    static State m9842a(Event event) {
        switch (event) {
            case ON_CREATE:
            case ON_STOP:
                return State.CREATED;
            case ON_START:
            case ON_PAUSE:
                return State.STARTED;
            case ON_RESUME:
                return State.RESUMED;
            case ON_DESTROY:
                return State.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value ".concat(String.valueOf(event)));
        }
    }

    /* renamed from: c */
    private static Event m9851c(State state) {
        switch (state) {
            case INITIALIZED:
            case DESTROYED:
                return Event.ON_CREATE;
            case CREATED:
                return Event.ON_START;
            case STARTED:
                return Event.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(state)));
        }
    }

    /* renamed from: a */
    private void m9846a(LifecycleOwner lifecycleOwner) {
        C37092d Z = this.f1696cm.mo66100Z();
        while (Z.hasNext() && !this.f1701cs) {
            Entry entry = (Entry) Z.next();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.f10cn.compareTo(this.f1697cn) < 0 && !this.f1701cs && this.f1696cm.contains(entry.getKey())) {
                m9849b(observerWithState.f10cn);
                observerWithState.mo292a(lifecycleOwner, m9851c(observerWithState.f10cn));
                m9848af();
            }
        }
    }

    /* renamed from: b */
    private void m9850b(LifecycleOwner lifecycleOwner) {
        C17362a c17362a = this.f1696cm;
        C17363b c17363b = new C17363b(c17362a.f16597bT, c17362a.f16596bS);
        c17362a.f16598bU.put(c17363b, Boolean.FALSE);
        while (c17363b.hasNext() && !this.f1701cs) {
            Entry entry = (Entry) c17363b.next();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.f10cn.compareTo(this.f1697cn) > 0 && !this.f1701cs && this.f1696cm.contains(entry.getKey())) {
                Event event;
                State state = observerWithState.f10cn;
                switch (state) {
                    case INITIALIZED:
                        throw new IllegalArgumentException();
                    case CREATED:
                        event = Event.ON_DESTROY;
                        break;
                    case STARTED:
                        event = Event.ON_STOP;
                        break;
                    case RESUMED:
                        event = Event.ON_PAUSE;
                        break;
                    case DESTROYED:
                        throw new IllegalArgumentException();
                    default:
                        throw new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(state)));
                }
                m9849b(m9842a(event));
                observerWithState.mo292a(lifecycleOwner, event);
                m9848af();
            }
        }
    }

    private void sync() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.f1698co.get();
        if (lifecycleOwner != null) {
            while (!m9847ad()) {
                this.f1701cs = false;
                if (this.f1697cn.compareTo(((ObserverWithState) this.f1696cm.f16596bS.getValue()).f10cn) < 0) {
                    m9850b(lifecycleOwner);
                }
                C25283c c25283c = this.f1696cm.f16597bT;
                if (!(this.f1701cs || c25283c == null || this.f1697cn.compareTo(((ObserverWithState) c25283c.getValue()).f10cn) <= 0)) {
                    m9846a(lifecycleOwner);
                }
            }
            this.f1701cs = false;
        }
    }

    /* renamed from: a */
    static State m9843a(State state, State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }
}
