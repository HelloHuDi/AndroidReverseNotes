package android.arch.lifecycle;

import android.arch.a.b.a;
import android.arch.a.b.b.b;
import android.arch.a.b.b.c;
import android.arch.a.b.b.d;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.Lifecycle.State;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map.Entry;

public class LifecycleRegistry extends Lifecycle {
    private a<LifecycleObserver, ObserverWithState> cm = new a();
    private State cn;
    private final WeakReference<LifecycleOwner> co;
    private int cp = 0;
    private boolean cq = false;
    private boolean cs = false;
    private ArrayList<State> ct = new ArrayList();

    static class ObserverWithState {
        State cn;
        GenericLifecycleObserver cv;

        ObserverWithState(LifecycleObserver lifecycleObserver, State state) {
            this.cv = Lifecycling.e(lifecycleObserver);
            this.cn = state;
        }

        /* Access modifiers changed, original: final */
        public final void a(LifecycleOwner lifecycleOwner, Event event) {
            State a = LifecycleRegistry.a(event);
            this.cn = LifecycleRegistry.a(this.cn, a);
            this.cv.onStateChanged(lifecycleOwner, event);
            this.cn = a;
        }
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        this.co = new WeakReference(lifecycleOwner);
        this.cn = State.INITIALIZED;
    }

    public void markState(State state) {
        a(state);
    }

    public void handleLifecycleEvent(Event event) {
        a(a(event));
    }

    private void a(State state) {
        if (this.cn != state) {
            this.cn = state;
            if (this.cq || this.cp != 0) {
                this.cs = true;
                return;
            }
            this.cq = true;
            sync();
            this.cq = false;
        }
    }

    private boolean ad() {
        if (this.cm.mSize == 0) {
            return true;
        }
        State state = ((ObserverWithState) this.cm.bS.getValue()).cn;
        State state2 = ((ObserverWithState) this.cm.bT.getValue()).cn;
        return state == state2 && this.cn == state2;
    }

    private State a(LifecycleObserver lifecycleObserver) {
        Entry entry;
        State state;
        a aVar = this.cm;
        if (aVar.contains(lifecycleObserver)) {
            entry = ((c) aVar.bR.get(lifecycleObserver)).bX;
        } else {
            entry = null;
        }
        State state2 = entry != null ? ((ObserverWithState) entry.getValue()).cn : null;
        if (this.ct.isEmpty()) {
            state = null;
        } else {
            state = (State) this.ct.get(this.ct.size() - 1);
        }
        return a(a(this.cn, state2), state);
    }

    public void addObserver(LifecycleObserver lifecycleObserver) {
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, this.cn == State.DESTROYED ? State.DESTROYED : State.INITIALIZED);
        if (((ObserverWithState) this.cm.putIfAbsent(lifecycleObserver, observerWithState)) == null) {
            LifecycleOwner lifecycleOwner = (LifecycleOwner) this.co.get();
            if (lifecycleOwner != null) {
                Object obj = (this.cp != 0 || this.cq) ? 1 : null;
                Enum a = a(lifecycleObserver);
                this.cp++;
                while (observerWithState.cn.compareTo(a) < 0 && this.cm.contains(lifecycleObserver)) {
                    b(observerWithState.cn);
                    observerWithState.a(lifecycleOwner, c(observerWithState.cn));
                    af();
                    a = a(lifecycleObserver);
                }
                if (obj == null) {
                    sync();
                }
                this.cp--;
            }
        }
    }

    private void af() {
        this.ct.remove(this.ct.size() - 1);
    }

    private void b(State state) {
        this.ct.add(state);
    }

    public void removeObserver(LifecycleObserver lifecycleObserver) {
        this.cm.remove(lifecycleObserver);
    }

    public int getObserverCount() {
        return this.cm.mSize;
    }

    public State getCurrentState() {
        return this.cn;
    }

    static State a(Event event) {
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

    private static Event c(State state) {
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

    private void a(LifecycleOwner lifecycleOwner) {
        d Z = this.cm.Z();
        while (Z.hasNext() && !this.cs) {
            Entry entry = (Entry) Z.next();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.cn.compareTo(this.cn) < 0 && !this.cs && this.cm.contains(entry.getKey())) {
                b(observerWithState.cn);
                observerWithState.a(lifecycleOwner, c(observerWithState.cn));
                af();
            }
        }
    }

    private void b(LifecycleOwner lifecycleOwner) {
        a aVar = this.cm;
        b bVar = new b(aVar.bT, aVar.bS);
        aVar.bU.put(bVar, Boolean.FALSE);
        while (bVar.hasNext() && !this.cs) {
            Entry entry = (Entry) bVar.next();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.cn.compareTo(this.cn) > 0 && !this.cs && this.cm.contains(entry.getKey())) {
                Event event;
                State state = observerWithState.cn;
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
                b(a(event));
                observerWithState.a(lifecycleOwner, event);
                af();
            }
        }
    }

    private void sync() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.co.get();
        if (lifecycleOwner != null) {
            while (!ad()) {
                this.cs = false;
                if (this.cn.compareTo(((ObserverWithState) this.cm.bS.getValue()).cn) < 0) {
                    b(lifecycleOwner);
                }
                c cVar = this.cm.bT;
                if (!(this.cs || cVar == null || this.cn.compareTo(((ObserverWithState) cVar.getValue()).cn) <= 0)) {
                    a(lifecycleOwner);
                }
            }
            this.cs = false;
        }
    }

    static State a(State state, State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }
}
