package android.arch.lifecycle;

import android.arch.a.a.a;
import android.arch.a.b.b;
import android.arch.a.b.b.d;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.Lifecycle.State;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData<T> {
    private static final Object cz = new Object();
    private b<Observer<T>, ObserverWrapper> cA = new b();
    private int cB = 0;
    private volatile Object cC = cz;
    private int cD = -1;
    private boolean cE;
    private boolean cF;
    private final Runnable cG = new Runnable() {
        public void run() {
            Object b;
            synchronized (LiveData.this.cy) {
                b = LiveData.this.cC;
                LiveData.this.cC = LiveData.cz;
            }
            LiveData.this.setValue(b);
        }
    };
    private final Object cy = new Object();
    private volatile Object mData = cz;

    abstract class ObserverWrapper {
        final Observer<T> cJ;
        int cK = -1;
        boolean mActive;

        public abstract boolean am();

        ObserverWrapper(Observer<T> observer) {
            this.cJ = observer;
        }

        /* Access modifiers changed, original: 0000 */
        public boolean c(LifecycleOwner lifecycleOwner) {
            return false;
        }

        /* Access modifiers changed, original: 0000 */
        public void an() {
        }

        /* Access modifiers changed, original: final */
        public final void m(boolean z) {
            int i = 1;
            if (z != this.mActive) {
                this.mActive = z;
                int i2 = LiveData.this.cB == 0 ? 1 : 0;
                LiveData liveData = LiveData.this;
                int c = liveData.cB;
                if (!this.mActive) {
                    i = -1;
                }
                liveData.cB = i + c;
                if (i2 != 0 && this.mActive) {
                    LiveData.this.onActive();
                }
                if (LiveData.this.cB == 0 && !this.mActive) {
                    LiveData.this.ag();
                }
                if (this.mActive) {
                    LiveData.this.b(this);
                }
            }
        }
    }

    class AlwaysActiveObserver extends ObserverWrapper {
        AlwaysActiveObserver(Observer<T> observer) {
            super(observer);
        }

        /* Access modifiers changed, original: final */
        public final boolean am() {
            return true;
        }
    }

    class LifecycleBoundObserver extends ObserverWrapper implements GenericLifecycleObserver {
        final LifecycleOwner cI;

        LifecycleBoundObserver(LifecycleOwner lifecycleOwner, Observer<T> observer) {
            super(observer);
            this.cI = lifecycleOwner;
        }

        /* Access modifiers changed, original: final */
        public final boolean am() {
            return this.cI.getLifecycle().getCurrentState().isAtLeast(State.STARTED);
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
            if (this.cI.getLifecycle().getCurrentState() == State.DESTROYED) {
                LiveData.this.removeObserver(this.cJ);
            } else {
                m(am());
            }
        }

        /* Access modifiers changed, original: final */
        public final boolean c(LifecycleOwner lifecycleOwner) {
            return this.cI == lifecycleOwner;
        }

        /* Access modifiers changed, original: final */
        public final void an() {
            this.cI.getLifecycle().removeObserver(this);
        }
    }

    private void a(ObserverWrapper observerWrapper) {
        if (!observerWrapper.mActive) {
            return;
        }
        if (!observerWrapper.am()) {
            observerWrapper.m(false);
        } else if (observerWrapper.cK < this.cD) {
            observerWrapper.cK = this.cD;
            observerWrapper.cJ.onChanged(this.mData);
        }
    }

    private void b(ObserverWrapper observerWrapper) {
        if (this.cE) {
            this.cF = true;
            return;
        }
        this.cE = true;
        do {
            this.cF = false;
            ObserverWrapper observerWrapper2;
            if (observerWrapper2 == null) {
                d Z = this.cA.Z();
                while (Z.hasNext()) {
                    a((ObserverWrapper) ((Entry) Z.next()).getValue());
                    if (this.cF) {
                        break;
                    }
                }
            }
            a(observerWrapper2);
            observerWrapper2 = null;
        } while (this.cF);
        this.cE = false;
    }

    public void observe(LifecycleOwner lifecycleOwner, Observer<T> observer) {
        if (lifecycleOwner.getLifecycle().getCurrentState() != State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
            ObserverWrapper observerWrapper = (ObserverWrapper) this.cA.putIfAbsent(observer, lifecycleBoundObserver);
            if (observerWrapper != null && !observerWrapper.c(lifecycleOwner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (observerWrapper == null) {
                lifecycleOwner.getLifecycle().addObserver(lifecycleBoundObserver);
            }
        }
    }

    public void observeForever(Observer<T> observer) {
        AlwaysActiveObserver alwaysActiveObserver = new AlwaysActiveObserver(observer);
        ObserverWrapper observerWrapper = (ObserverWrapper) this.cA.putIfAbsent(observer, alwaysActiveObserver);
        if (observerWrapper != null && (observerWrapper instanceof LifecycleBoundObserver)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (observerWrapper == null) {
            alwaysActiveObserver.m(true);
        }
    }

    public void removeObserver(Observer<T> observer) {
        z("removeObserver");
        ObserverWrapper observerWrapper = (ObserverWrapper) this.cA.remove(observer);
        if (observerWrapper != null) {
            observerWrapper.an();
            observerWrapper.m(false);
        }
    }

    public void removeObservers(LifecycleOwner lifecycleOwner) {
        z("removeObservers");
        Iterator it = this.cA.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (((ObserverWrapper) entry.getValue()).c(lifecycleOwner)) {
                removeObserver((Observer) entry.getKey());
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void postValue(T t) {
        Object obj;
        synchronized (this.cy) {
            obj = this.cC == cz ? 1 : null;
            this.cC = t;
        }
        if (obj != null) {
            a.Y().d(this.cG);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setValue(T t) {
        z("setValue");
        this.cD++;
        this.mData = t;
        b(null);
    }

    public T getValue() {
        Object obj = this.mData;
        return obj != cz ? obj : null;
    }

    /* Access modifiers changed, original: protected */
    public void onActive() {
    }

    /* Access modifiers changed, original: protected */
    public void ag() {
    }

    public boolean hasObservers() {
        return this.cA.mSize > 0;
    }

    public boolean hasActiveObservers() {
        return this.cB > 0;
    }

    private static void z(String str) {
        if (!a.Y().bM.isMainThread()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }
}
