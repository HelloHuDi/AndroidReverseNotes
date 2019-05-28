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
    private final ThreadFactory a = new ThreadFactory() {
        private final AtomicInteger b = new AtomicInteger(1);

        {
            AppMethodBeat.i(98177);
            AppMethodBeat.o(98177);
        }

        public Thread newThread(Runnable runnable) {
            AppMethodBeat.i(98178);
            Thread thread = new Thread(runnable, "AsyncTask High #" + this.b.getAndIncrement());
            thread.setPriority(6);
            AppMethodBeat.o(98178);
            return thread;
        }
    };
    private final BlockingQueue<Runnable> b = new a(5);
    private final Executor c = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, this.b, this.a, new DiscardOldestPolicy());

    class a<E> extends AbstractQueue<E> implements Serializable, BlockingQueue<E> {
        transient b<E> a;
        private int c;
        private final AtomicInteger d = new AtomicInteger();
        private final ReentrantLock e = new ReentrantLock();
        private final Condition f = this.e.newCondition();
        private final ReentrantLock g = new ReentrantLock();
        private final Condition h = this.g.newCondition();

        class b<E> {
            E a;
            b<E> b;

            b(E e) {
                this.a = e;
            }
        }

        public class a implements Iterator<E> {
            private b<E> b;
            private b<E> c;
            private E d;

            a() {
                AppMethodBeat.i(98179);
                a.a((a) a.this);
                try {
                    this.b = a.this.a.b;
                    if (this.b != null) {
                        this.d = this.b.a;
                    }
                    a.this.a();
                    AppMethodBeat.o(98179);
                } catch (Throwable th) {
                    a.this.a();
                    AppMethodBeat.o(98179);
                }
            }

            public boolean hasNext() {
                return this.b != null;
            }

            private b<E> a(b<E> bVar) {
                b bVar2;
                do {
                    bVar2 = bVar2.b;
                    if (bVar2 == null) {
                        break;
                    }
                } while (bVar2.a == null);
                return bVar2;
            }

            public E next() {
                AppMethodBeat.i(98180);
                a.a(a.this);
                E e;
                try {
                    if (this.b == null) {
                        NoSuchElementException noSuchElementException = new NoSuchElementException();
                        AppMethodBeat.o(98180);
                        throw noSuchElementException;
                    }
                    e = this.d;
                    this.c = this.b;
                    this.b = a(this.b);
                    this.d = this.b == null ? null : this.b.a;
                    return e;
                } finally {
                    e = a.this;
                    e.a();
                    AppMethodBeat.o(98180);
                }
            }

            public void remove() {
                AppMethodBeat.i(98181);
                a.a(a.this);
                try {
                    b bVar = this.c;
                    this.c = null;
                    b bVar2 = a.this.a;
                    b bVar3 = bVar2.b;
                    b bVar4 = bVar2;
                    while (bVar3 != null) {
                        if (bVar3 == bVar) {
                            a.this.a(bVar3, bVar4);
                            break;
                        } else {
                            bVar4 = bVar3;
                            bVar3 = bVar3.b;
                        }
                    }
                    a.this.a();
                    AppMethodBeat.o(98181);
                } catch (Throwable th) {
                    a.this.a();
                    AppMethodBeat.o(98181);
                }
            }
        }

        public a(int i) {
            AppMethodBeat.i(98182);
            this.c = i;
            this.a = new b(null);
            AppMethodBeat.o(98182);
        }

        public Iterator<E> iterator() {
            AppMethodBeat.i(98183);
            a aVar = new a();
            AppMethodBeat.o(98183);
            return aVar;
        }

        public int size() {
            AppMethodBeat.i(98184);
            int i = this.d.get();
            AppMethodBeat.o(98184);
            return i;
        }

        public int drainTo(Collection<? super E> collection) {
            AppMethodBeat.i(98185);
            int drainTo = drainTo(collection, BaseClientBuilder.API_PRIORITY_OTHER);
            AppMethodBeat.o(98185);
            return drainTo;
        }

        public int drainTo(Collection<? super E> collection, int i) {
            int i2 = 1;
            AppMethodBeat.i(98186);
            if (collection == null) {
                NullPointerException nullPointerException = new NullPointerException();
                AppMethodBeat.o(98186);
                throw nullPointerException;
            } else if (collection == this) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                AppMethodBeat.o(98186);
                throw illegalArgumentException;
            } else if (i <= 0) {
                AppMethodBeat.o(98186);
                return 0;
            } else {
                ReentrantLock reentrantLock = this.e;
                reentrantLock.lock();
                b bVar;
                int i3;
                try {
                    int min = Math.min(i, this.d.get());
                    bVar = this.a;
                    i3 = 0;
                    while (i3 < min) {
                        b bVar2 = bVar.b;
                        collection.add(bVar2.a);
                        bVar2.a = null;
                        bVar.b = bVar;
                        i3++;
                        bVar = bVar2;
                    }
                    if (i3 > 0) {
                        this.a = bVar;
                        if (this.d.getAndAdd(-i3) != this.c) {
                            i2 = 0;
                        }
                    } else {
                        i2 = 0;
                    }
                    reentrantLock.unlock();
                    if (i2 != 0) {
                        d();
                    }
                    AppMethodBeat.o(98186);
                    return min;
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    if (null != null) {
                        d();
                    }
                    AppMethodBeat.o(98186);
                }
            }
        }

        public boolean offer(E e) {
            AppMethodBeat.i(98187);
            if (e == null) {
                NullPointerException nullPointerException = new NullPointerException();
                AppMethodBeat.o(98187);
                throw nullPointerException;
            }
            AtomicInteger atomicInteger = this.d;
            if (atomicInteger.get() == this.c) {
                AppMethodBeat.o(98187);
                return false;
            }
            int i = -1;
            b bVar = new b(e);
            ReentrantLock reentrantLock = this.g;
            reentrantLock.lock();
            try {
                if (atomicInteger.get() < this.c) {
                    a(bVar);
                    i = atomicInteger.getAndIncrement();
                    if (i + 1 < this.c) {
                        this.h.signal();
                    }
                }
                reentrantLock.unlock();
                if (i == 0) {
                    e();
                }
                if (i >= 0) {
                    AppMethodBeat.o(98187);
                    return true;
                }
                AppMethodBeat.o(98187);
                return false;
            } catch (Throwable th) {
                reentrantLock.unlock();
                AppMethodBeat.o(98187);
            }
        }

        public boolean offer(E e, long j, TimeUnit timeUnit) {
            AppMethodBeat.i(98188);
            if (e == null) {
                NullPointerException nullPointerException = new NullPointerException();
                AppMethodBeat.o(98188);
                throw nullPointerException;
            }
            long toNanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.g;
            AtomicInteger atomicInteger = this.d;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == this.c) {
                try {
                    if (toNanos <= 0) {
                        reentrantLock.unlock();
                        AppMethodBeat.o(98188);
                        return false;
                    }
                    toNanos = this.h.awaitNanos(toNanos);
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    AppMethodBeat.o(98188);
                }
            }
            a(new b(e));
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement + 1 < this.c) {
                this.h.signal();
            }
            reentrantLock.unlock();
            if (andIncrement == 0) {
                e();
            }
            AppMethodBeat.o(98188);
            return true;
        }

        public E poll(long j, TimeUnit timeUnit) {
            AppMethodBeat.i(98189);
            long toNanos = timeUnit.toNanos(j);
            AtomicInteger atomicInteger = this.d;
            ReentrantLock reentrantLock = this.e;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == 0) {
                try {
                    if (toNanos <= 0) {
                        reentrantLock.unlock();
                        AppMethodBeat.o(98189);
                        return null;
                    }
                    toNanos = this.f.awaitNanos(toNanos);
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    AppMethodBeat.o(98189);
                }
            }
            E b = b();
            int andDecrement = atomicInteger.getAndDecrement();
            if (andDecrement > 1) {
                this.f.signal();
            }
            reentrantLock.unlock();
            if (andDecrement == this.c) {
                d();
            }
            AppMethodBeat.o(98189);
            return b;
        }

        public void put(E e) {
            AppMethodBeat.i(98190);
            if (e == null) {
                NullPointerException nullPointerException = new NullPointerException();
                AppMethodBeat.o(98190);
                throw nullPointerException;
            }
            b bVar = new b(e);
            ReentrantLock reentrantLock = this.g;
            AtomicInteger atomicInteger = this.d;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == this.c) {
                try {
                    this.h.await();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    AppMethodBeat.o(98190);
                }
            }
            a(bVar);
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement + 1 < this.c) {
                this.h.signal();
            }
            reentrantLock.unlock();
            if (andIncrement == 0) {
                e();
            }
            AppMethodBeat.o(98190);
        }

        public int remainingCapacity() {
            AppMethodBeat.i(98191);
            int i = this.c - this.d.get();
            AppMethodBeat.o(98191);
            return i;
        }

        public E take() {
            AppMethodBeat.i(98192);
            AtomicInteger atomicInteger = this.d;
            ReentrantLock reentrantLock = this.e;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == 0) {
                try {
                    this.f.await();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    AppMethodBeat.o(98192);
                }
            }
            Object b = b();
            int andDecrement = atomicInteger.getAndDecrement();
            if (andDecrement > 1) {
                this.f.signal();
            }
            reentrantLock.unlock();
            if (andDecrement == this.c) {
                d();
            }
            AppMethodBeat.o(98192);
            return b;
        }

        public E peek() {
            E e = null;
            AppMethodBeat.i(98193);
            if (this.d.get() == 0) {
                AppMethodBeat.o(98193);
            } else {
                ReentrantLock reentrantLock = this.e;
                reentrantLock.lock();
                try {
                    b bVar = this.a.b;
                    if (bVar != null) {
                        e = bVar.a;
                        reentrantLock.unlock();
                        AppMethodBeat.o(98193);
                    }
                } finally {
                    reentrantLock.unlock();
                    AppMethodBeat.o(98193);
                }
            }
            return e;
        }

        public E poll() {
            E e = null;
            AppMethodBeat.i(98194);
            AtomicInteger atomicInteger = this.d;
            if (atomicInteger.get() == 0) {
                AppMethodBeat.o(98194);
            } else {
                int i = -1;
                ReentrantLock reentrantLock = this.e;
                reentrantLock.lock();
                try {
                    if (atomicInteger.get() > 0) {
                        e = b();
                        i = atomicInteger.getAndDecrement();
                        if (i > 1) {
                            this.f.signal();
                        }
                    }
                    reentrantLock.unlock();
                    if (i == this.c) {
                        d();
                    }
                    AppMethodBeat.o(98194);
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    AppMethodBeat.o(98194);
                }
            }
            return e;
        }

        private void a(b<E> bVar) {
            bVar.b = this.a.b;
            this.a.b = bVar;
        }

        private E b() {
            b bVar = this.a.b;
            if (bVar == null) {
                return null;
            }
            this.a.b = bVar.b;
            bVar.b = null;
            Object obj = bVar.a;
            bVar.a = null;
            return obj;
        }

        private void c() {
            AppMethodBeat.i(98195);
            this.g.lock();
            this.e.lock();
            AppMethodBeat.o(98195);
        }

        /* Access modifiers changed, original: 0000 */
        public void a() {
            AppMethodBeat.i(98196);
            this.e.unlock();
            this.g.unlock();
            AppMethodBeat.o(98196);
        }

        /* Access modifiers changed, original: 0000 */
        public void a(b<E> bVar, b<E> bVar2) {
            AppMethodBeat.i(98197);
            bVar.a = null;
            bVar2.b = bVar.b;
            if (this.d.getAndDecrement() == this.c) {
                this.h.signal();
            }
            AppMethodBeat.o(98197);
        }

        private void d() {
            AppMethodBeat.i(98198);
            ReentrantLock reentrantLock = this.g;
            reentrantLock.lock();
            try {
                this.h.signal();
            } finally {
                reentrantLock.unlock();
                AppMethodBeat.o(98198);
            }
        }

        private void e() {
            AppMethodBeat.i(98199);
            ReentrantLock reentrantLock = this.e;
            reentrantLock.lock();
            try {
                this.f.signal();
            } finally {
                reentrantLock.unlock();
                AppMethodBeat.o(98199);
            }
        }
    }

    public HighThreadExecutor() {
        AppMethodBeat.i(98201);
        AppMethodBeat.o(98201);
    }

    public void execute(Runnable runnable) {
        AppMethodBeat.i(98202);
        this.c.execute(runnable);
        AppMethodBeat.o(98202);
    }
}
