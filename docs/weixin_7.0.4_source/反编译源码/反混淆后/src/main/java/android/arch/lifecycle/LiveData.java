package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.Lifecycle.State;
import android.arch.p1150a.p1151a.C24631a;
import android.arch.p1150a.p1152b.C41468b;
import android.arch.p1150a.p1152b.C41468b.C37092d;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData<T> {
    /* renamed from: cz */
    private static final Object f18cz = new Object();
    /* renamed from: cA */
    private C41468b<Observer<T>, ObserverWrapper> f19cA = new C41468b();
    /* renamed from: cB */
    private int f20cB = 0;
    /* renamed from: cC */
    private volatile Object f21cC = f18cz;
    /* renamed from: cD */
    private int f22cD = -1;
    /* renamed from: cE */
    private boolean f23cE;
    /* renamed from: cF */
    private boolean f24cF;
    /* renamed from: cG */
    private final Runnable f25cG = new C02241();
    /* renamed from: cy */
    private final Object f26cy = new Object();
    private volatile Object mData = f18cz;

    /* renamed from: android.arch.lifecycle.LiveData$1 */
    class C02241 implements Runnable {
        C02241() {
        }

        public void run() {
            Object b;
            synchronized (LiveData.this.f26cy) {
                b = LiveData.this.f21cC;
                LiveData.this.f21cC = LiveData.f18cz;
            }
            LiveData.this.setValue(b);
        }
    }

    abstract class ObserverWrapper {
        /* renamed from: cJ */
        final Observer<T> f16cJ;
        /* renamed from: cK */
        int f17cK = -1;
        boolean mActive;

        /* renamed from: am */
        public abstract boolean mo294am();

        ObserverWrapper(Observer<T> observer) {
            this.f16cJ = observer;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: c */
        public boolean mo296c(LifecycleOwner lifecycleOwner) {
            return false;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: an */
        public void mo295an() {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: m */
        public final void mo297m(boolean z) {
            int i = 1;
            if (z != this.mActive) {
                this.mActive = z;
                int i2 = LiveData.this.f20cB == 0 ? 1 : 0;
                LiveData liveData = LiveData.this;
                int c = liveData.f20cB;
                if (!this.mActive) {
                    i = -1;
                }
                liveData.f20cB = i + c;
                if (i2 != 0 && this.mActive) {
                    LiveData.this.onActive();
                }
                if (LiveData.this.f20cB == 0 && !this.mActive) {
                    LiveData.this.mo298ag();
                }
                if (this.mActive) {
                    LiveData.this.m335b(this);
                }
            }
        }
    }

    class AlwaysActiveObserver extends ObserverWrapper {
        AlwaysActiveObserver(Observer<T> observer) {
            super(observer);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: am */
        public final boolean mo294am() {
            return true;
        }
    }

    class LifecycleBoundObserver extends ObserverWrapper implements GenericLifecycleObserver {
        /* renamed from: cI */
        final LifecycleOwner f29cI;

        LifecycleBoundObserver(LifecycleOwner lifecycleOwner, Observer<T> observer) {
            super(observer);
            this.f29cI = lifecycleOwner;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: am */
        public final boolean mo294am() {
            return this.f29cI.getLifecycle().getCurrentState().isAtLeast(State.STARTED);
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
            if (this.f29cI.getLifecycle().getCurrentState() == State.DESTROYED) {
                LiveData.this.removeObserver(this.f16cJ);
            } else {
                mo297m(mo294am());
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: c */
        public final boolean mo296c(LifecycleOwner lifecycleOwner) {
            return this.f29cI == lifecycleOwner;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: an */
        public final void mo295an() {
            this.f29cI.getLifecycle().removeObserver(this);
        }
    }

    /* renamed from: a */
    private void m331a(ObserverWrapper observerWrapper) {
        if (!observerWrapper.mActive) {
            return;
        }
        if (!observerWrapper.mo294am()) {
            observerWrapper.mo297m(false);
        } else if (observerWrapper.f17cK < this.f22cD) {
            observerWrapper.f17cK = this.f22cD;
            observerWrapper.f16cJ.onChanged(this.mData);
        }
    }

    /* renamed from: b */
    private void m335b(ObserverWrapper observerWrapper) {
        if (this.f23cE) {
            this.f24cF = true;
            return;
        }
        this.f23cE = true;
        do {
            this.f24cF = false;
            ObserverWrapper observerWrapper2;
            if (observerWrapper2 == null) {
                C37092d Z = this.f19cA.mo66100Z();
                while (Z.hasNext()) {
                    m331a((ObserverWrapper) ((Entry) Z.next()).getValue());
                    if (this.f24cF) {
                        break;
                    }
                }
            }
            m331a(observerWrapper2);
            observerWrapper2 = null;
        } while (this.f24cF);
        this.f23cE = false;
    }

    public void observe(LifecycleOwner lifecycleOwner, Observer<T> observer) {
        if (lifecycleOwner.getLifecycle().getCurrentState() != State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
            ObserverWrapper observerWrapper = (ObserverWrapper) this.f19cA.putIfAbsent(observer, lifecycleBoundObserver);
            if (observerWrapper != null && !observerWrapper.mo296c(lifecycleOwner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (observerWrapper == null) {
                lifecycleOwner.getLifecycle().addObserver(lifecycleBoundObserver);
            }
        }
    }

    public void observeForever(Observer<T> observer) {
        AlwaysActiveObserver alwaysActiveObserver = new AlwaysActiveObserver(observer);
        ObserverWrapper observerWrapper = (ObserverWrapper) this.f19cA.putIfAbsent(observer, alwaysActiveObserver);
        if (observerWrapper != null && (observerWrapper instanceof LifecycleBoundObserver)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (observerWrapper == null) {
            alwaysActiveObserver.mo297m(true);
        }
    }

    public void removeObserver(Observer<T> observer) {
        m337z("removeObserver");
        ObserverWrapper observerWrapper = (ObserverWrapper) this.f19cA.remove(observer);
        if (observerWrapper != null) {
            observerWrapper.mo295an();
            observerWrapper.mo297m(false);
        }
    }

    public void removeObservers(LifecycleOwner lifecycleOwner) {
        m337z("removeObservers");
        Iterator it = this.f19cA.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (((ObserverWrapper) entry.getValue()).mo296c(lifecycleOwner)) {
                removeObserver((Observer) entry.getKey());
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void postValue(T t) {
        Object obj;
        synchronized (this.f26cy) {
            obj = this.f21cC == f18cz ? 1 : null;
            this.f21cC = t;
        }
        if (obj != null) {
            C24631a.m38318Y().mo31436d(this.f25cG);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setValue(T t) {
        m337z("setValue");
        this.f22cD++;
        this.mData = t;
        m335b(null);
    }

    public T getValue() {
        Object obj = this.mData;
        return obj != f18cz ? obj : null;
    }

    /* Access modifiers changed, original: protected */
    public void onActive() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: ag */
    public void mo298ag() {
    }

    public boolean hasObservers() {
        return this.f19cA.mSize > 0;
    }

    public boolean hasActiveObservers() {
        return this.f20cB > 0;
    }

    /* renamed from: z */
    private static void m337z(String str) {
        if (!C24631a.m38318Y().f4905bM.isMainThread()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }
}
