package com.tencent.map.lib.thread;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class HighThreadExecutor implements Executor {
    /* renamed from: a */
    private final ThreadFactory f17868a = new C417221();
    /* renamed from: b */
    private final BlockingQueue<Runnable> f17869b = new C8895a(5);
    /* renamed from: c */
    private final Executor f17870c = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, this.f17869b, this.f17868a, new DiscardOldestPolicy());

    /* renamed from: com.tencent.map.lib.thread.HighThreadExecutor$a */
    class C8895a<E> extends AbstractQueue<E> implements Serializable, BlockingQueue<E> {
        /* renamed from: a */
        transient C8894b<E> f2840a;
        /* renamed from: c */
        private int f2842c;
        /* renamed from: d */
        private final AtomicInteger f2843d = new AtomicInteger();
        /* renamed from: e */
        private final ReentrantLock f2844e = new ReentrantLock();
        /* renamed from: f */
        private final Condition f2845f = this.f2844e.newCondition();
        /* renamed from: g */
        private final ReentrantLock f2846g = new ReentrantLock();
        /* renamed from: h */
        private final Condition f2847h = this.f2846g.newCondition();

        /* renamed from: com.tencent.map.lib.thread.HighThreadExecutor$a$b */
        class C8894b<E> {
            /* renamed from: a */
            E f2837a;
            /* renamed from: b */
            C8894b<E> f2838b;

            C8894b(E e) {
                this.f2837a = e;
            }
        }

        /* renamed from: com.tencent.map.lib.thread.HighThreadExecutor$a$a */
        public class C8896a implements Iterator<E> {
            /* renamed from: b */
            private C8894b<E> f2849b;
            /* renamed from: c */
            private C8894b<E> f2850c;
            /* renamed from: d */
            private E f2851d;

            C8896a() {
                AppMethodBeat.m2504i(98179);
                C8895a.m16028a((C8895a) C8895a.this);
                try {
                    this.f2849b = C8895a.this.f2840a.f2838b;
                    if (this.f2849b != null) {
                        this.f2851d = this.f2849b.f2837a;
                    }
                    C8895a.this.mo20268a();
                    AppMethodBeat.m2505o(98179);
                } catch (Throwable th) {
                    C8895a.this.mo20268a();
                    AppMethodBeat.m2505o(98179);
                }
            }

            public boolean hasNext() {
                return this.f2849b != null;
            }

            /* renamed from: a */
            private C8894b<E> m16035a(C8894b<E> c8894b) {
                C8894b c8894b2;
                do {
                    c8894b2 = c8894b2.f2838b;
                    if (c8894b2 == null) {
                        break;
                    }
                } while (c8894b2.f2837a == null);
                return c8894b2;
            }

            public E next() {
                AppMethodBeat.m2504i(98180);
                C8895a.m16028a(C8895a.this);
                E e;
                try {
                    if (this.f2849b == null) {
                        NoSuchElementException noSuchElementException = new NoSuchElementException();
                        AppMethodBeat.m2505o(98180);
                        throw noSuchElementException;
                    }
                    e = this.f2851d;
                    this.f2850c = this.f2849b;
                    this.f2849b = m16035a(this.f2849b);
                    this.f2851d = this.f2849b == null ? null : this.f2849b.f2837a;
                    return e;
                } finally {
                    e = C8895a.this;
                    e.mo20268a();
                    AppMethodBeat.m2505o(98180);
                }
            }

            public void remove() {
                AppMethodBeat.m2504i(98181);
                C8895a.m16028a(C8895a.this);
                try {
                    C8894b c8894b = this.f2850c;
                    this.f2850c = null;
                    C8894b c8894b2 = C8895a.this.f2840a;
                    C8894b c8894b3 = c8894b2.f2838b;
                    C8894b c8894b4 = c8894b2;
                    while (c8894b3 != null) {
                        if (c8894b3 == c8894b) {
                            C8895a.this.mo20269a(c8894b3, c8894b4);
                            break;
                        } else {
                            c8894b4 = c8894b3;
                            c8894b3 = c8894b3.f2838b;
                        }
                    }
                    C8895a.this.mo20268a();
                    AppMethodBeat.m2505o(98181);
                } catch (Throwable th) {
                    C8895a.this.mo20268a();
                    AppMethodBeat.m2505o(98181);
                }
            }
        }

        public C8895a(int i) {
            AppMethodBeat.m2504i(98182);
            this.f2842c = i;
            this.f2840a = new C8894b(null);
            AppMethodBeat.m2505o(98182);
        }

        public Iterator<E> iterator() {
            AppMethodBeat.m2504i(98183);
            C8896a c8896a = new C8896a();
            AppMethodBeat.m2505o(98183);
            return c8896a;
        }

        public int size() {
            AppMethodBeat.m2504i(98184);
            int i = this.f2843d.get();
            AppMethodBeat.m2505o(98184);
            return i;
        }

        public int drainTo(Collection<? super E> collection) {
            AppMethodBeat.m2504i(98185);
            int drainTo = drainTo(collection, BaseClientBuilder.API_PRIORITY_OTHER);
            AppMethodBeat.m2505o(98185);
            return drainTo;
        }

        public int drainTo(Collection<? super E> collection, int i) {
            int i2 = 1;
            AppMethodBeat.m2504i(98186);
            if (collection == null) {
                NullPointerException nullPointerException = new NullPointerException();
                AppMethodBeat.m2505o(98186);
                throw nullPointerException;
            } else if (collection == this) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                AppMethodBeat.m2505o(98186);
                throw illegalArgumentException;
            } else if (i <= 0) {
                AppMethodBeat.m2505o(98186);
                return 0;
            } else {
                ReentrantLock reentrantLock = this.f2844e;
                reentrantLock.lock();
                C8894b c8894b;
                int i3;
                try {
                    int min = Math.min(i, this.f2843d.get());
                    c8894b = this.f2840a;
                    i3 = 0;
                    while (i3 < min) {
                        C8894b c8894b2 = c8894b.f2838b;
                        collection.add(c8894b2.f2837a);
                        c8894b2.f2837a = null;
                        c8894b.f2838b = c8894b;
                        i3++;
                        c8894b = c8894b2;
                    }
                    if (i3 > 0) {
                        this.f2840a = c8894b;
                        if (this.f2843d.getAndAdd(-i3) != this.f2842c) {
                            i2 = 0;
                        }
                    } else {
                        i2 = 0;
                    }
                    reentrantLock.unlock();
                    if (i2 != 0) {
                        m16031d();
                    }
                    AppMethodBeat.m2505o(98186);
                    return min;
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    if (null != null) {
                        m16031d();
                    }
                    AppMethodBeat.m2505o(98186);
                }
            }
        }

        public boolean offer(E e) {
            AppMethodBeat.m2504i(98187);
            if (e == null) {
                NullPointerException nullPointerException = new NullPointerException();
                AppMethodBeat.m2505o(98187);
                throw nullPointerException;
            }
            AtomicInteger atomicInteger = this.f2843d;
            if (atomicInteger.get() == this.f2842c) {
                AppMethodBeat.m2505o(98187);
                return false;
            }
            int i = -1;
            C8894b c8894b = new C8894b(e);
            ReentrantLock reentrantLock = this.f2846g;
            reentrantLock.lock();
            try {
                if (atomicInteger.get() < this.f2842c) {
                    m16027a(c8894b);
                    i = atomicInteger.getAndIncrement();
                    if (i + 1 < this.f2842c) {
                        this.f2847h.signal();
                    }
                }
                reentrantLock.unlock();
                if (i == 0) {
                    m16032e();
                }
                if (i >= 0) {
                    AppMethodBeat.m2505o(98187);
                    return true;
                }
                AppMethodBeat.m2505o(98187);
                return false;
            } catch (Throwable th) {
                reentrantLock.unlock();
                AppMethodBeat.m2505o(98187);
            }
        }

        public boolean offer(E e, long j, TimeUnit timeUnit) {
            AppMethodBeat.m2504i(98188);
            if (e == null) {
                NullPointerException nullPointerException = new NullPointerException();
                AppMethodBeat.m2505o(98188);
                throw nullPointerException;
            }
            long toNanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.f2846g;
            AtomicInteger atomicInteger = this.f2843d;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == this.f2842c) {
                try {
                    if (toNanos <= 0) {
                        reentrantLock.unlock();
                        AppMethodBeat.m2505o(98188);
                        return false;
                    }
                    toNanos = this.f2847h.awaitNanos(toNanos);
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    AppMethodBeat.m2505o(98188);
                }
            }
            m16027a(new C8894b(e));
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement + 1 < this.f2842c) {
                this.f2847h.signal();
            }
            reentrantLock.unlock();
            if (andIncrement == 0) {
                m16032e();
            }
            AppMethodBeat.m2505o(98188);
            return true;
        }

        public E poll(long j, TimeUnit timeUnit) {
            AppMethodBeat.m2504i(98189);
            long toNanos = timeUnit.toNanos(j);
            AtomicInteger atomicInteger = this.f2843d;
            ReentrantLock reentrantLock = this.f2844e;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == 0) {
                try {
                    if (toNanos <= 0) {
                        reentrantLock.unlock();
                        AppMethodBeat.m2505o(98189);
                        return null;
                    }
                    toNanos = this.f2845f.awaitNanos(toNanos);
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    AppMethodBeat.m2505o(98189);
                }
            }
            E b = m16029b();
            int andDecrement = atomicInteger.getAndDecrement();
            if (andDecrement > 1) {
                this.f2845f.signal();
            }
            reentrantLock.unlock();
            if (andDecrement == this.f2842c) {
                m16031d();
            }
            AppMethodBeat.m2505o(98189);
            return b;
        }

        public void put(E e) {
            AppMethodBeat.m2504i(98190);
            if (e == null) {
                NullPointerException nullPointerException = new NullPointerException();
                AppMethodBeat.m2505o(98190);
                throw nullPointerException;
            }
            C8894b c8894b = new C8894b(e);
            ReentrantLock reentrantLock = this.f2846g;
            AtomicInteger atomicInteger = this.f2843d;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == this.f2842c) {
                try {
                    this.f2847h.await();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    AppMethodBeat.m2505o(98190);
                }
            }
            m16027a(c8894b);
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement + 1 < this.f2842c) {
                this.f2847h.signal();
            }
            reentrantLock.unlock();
            if (andIncrement == 0) {
                m16032e();
            }
            AppMethodBeat.m2505o(98190);
        }

        public int remainingCapacity() {
            AppMethodBeat.m2504i(98191);
            int i = this.f2842c - this.f2843d.get();
            AppMethodBeat.m2505o(98191);
            return i;
        }

        public E take() {
            AppMethodBeat.m2504i(98192);
            AtomicInteger atomicInteger = this.f2843d;
            ReentrantLock reentrantLock = this.f2844e;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == 0) {
                try {
                    this.f2845f.await();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    AppMethodBeat.m2505o(98192);
                }
            }
            Object b = m16029b();
            int andDecrement = atomicInteger.getAndDecrement();
            if (andDecrement > 1) {
                this.f2845f.signal();
            }
            reentrantLock.unlock();
            if (andDecrement == this.f2842c) {
                m16031d();
            }
            AppMethodBeat.m2505o(98192);
            return b;
        }

        public E peek() {
            E e = null;
            AppMethodBeat.m2504i(98193);
            if (this.f2843d.get() == 0) {
                AppMethodBeat.m2505o(98193);
            } else {
                ReentrantLock reentrantLock = this.f2844e;
                reentrantLock.lock();
                try {
                    C8894b c8894b = this.f2840a.f2838b;
                    if (c8894b != null) {
                        e = c8894b.f2837a;
                        reentrantLock.unlock();
                        AppMethodBeat.m2505o(98193);
                    }
                } finally {
                    reentrantLock.unlock();
                    AppMethodBeat.m2505o(98193);
                }
            }
            return e;
        }

        public E poll() {
            E e = null;
            AppMethodBeat.m2504i(98194);
            AtomicInteger atomicInteger = this.f2843d;
            if (atomicInteger.get() == 0) {
                AppMethodBeat.m2505o(98194);
            } else {
                int i = -1;
                ReentrantLock reentrantLock = this.f2844e;
                reentrantLock.lock();
                try {
                    if (atomicInteger.get() > 0) {
                        e = m16029b();
                        i = atomicInteger.getAndDecrement();
                        if (i > 1) {
                            this.f2845f.signal();
                        }
                    }
                    reentrantLock.unlock();
                    if (i == this.f2842c) {
                        m16031d();
                    }
                    AppMethodBeat.m2505o(98194);
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    AppMethodBeat.m2505o(98194);
                }
            }
            return e;
        }

        /* renamed from: a */
        private void m16027a(C8894b<E> c8894b) {
            c8894b.f2838b = this.f2840a.f2838b;
            this.f2840a.f2838b = c8894b;
        }

        /* renamed from: b */
        private E m16029b() {
            C8894b c8894b = this.f2840a.f2838b;
            if (c8894b == null) {
                return null;
            }
            this.f2840a.f2838b = c8894b.f2838b;
            c8894b.f2838b = null;
            Object obj = c8894b.f2837a;
            c8894b.f2837a = null;
            return obj;
        }

        /* renamed from: c */
        private void m16030c() {
            AppMethodBeat.m2504i(98195);
            this.f2846g.lock();
            this.f2844e.lock();
            AppMethodBeat.m2505o(98195);
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public void mo20268a() {
            AppMethodBeat.m2504i(98196);
            this.f2844e.unlock();
            this.f2846g.unlock();
            AppMethodBeat.m2505o(98196);
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public void mo20269a(C8894b<E> c8894b, C8894b<E> c8894b2) {
            AppMethodBeat.m2504i(98197);
            c8894b.f2837a = null;
            c8894b2.f2838b = c8894b.f2838b;
            if (this.f2843d.getAndDecrement() == this.f2842c) {
                this.f2847h.signal();
            }
            AppMethodBeat.m2505o(98197);
        }

        /* renamed from: d */
        private void m16031d() {
            AppMethodBeat.m2504i(98198);
            ReentrantLock reentrantLock = this.f2846g;
            reentrantLock.lock();
            try {
                this.f2847h.signal();
            } finally {
                reentrantLock.unlock();
                AppMethodBeat.m2505o(98198);
            }
        }

        /* renamed from: e */
        private void m16032e() {
            AppMethodBeat.m2504i(98199);
            ReentrantLock reentrantLock = this.f2844e;
            reentrantLock.lock();
            try {
                this.f2845f.signal();
            } finally {
                reentrantLock.unlock();
                AppMethodBeat.m2505o(98199);
            }
        }
    }

    /* renamed from: com.tencent.map.lib.thread.HighThreadExecutor$1 */
    class C417221 implements ThreadFactory {
        /* renamed from: b */
        private final AtomicInteger f17162b = new AtomicInteger(1);

        C417221() {
            AppMethodBeat.m2504i(98177);
            AppMethodBeat.m2505o(98177);
        }

        public Thread newThread(Runnable runnable) {
            AppMethodBeat.m2504i(98178);
            Thread thread = new Thread(runnable, "AsyncTask High #" + this.f17162b.getAndIncrement());
            thread.setPriority(6);
            AppMethodBeat.m2505o(98178);
            return thread;
        }
    }

    public HighThreadExecutor() {
        AppMethodBeat.m2504i(98201);
        AppMethodBeat.m2505o(98201);
    }

    public void execute(Runnable runnable) {
        AppMethodBeat.m2504i(98202);
        this.f17870c.execute(runnable);
        AppMethodBeat.m2505o(98202);
    }
}
