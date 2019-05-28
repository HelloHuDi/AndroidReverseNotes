package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public class WorkQueue {
    static final /* synthetic */ boolean $assertionsDisabled = (!WorkQueue.class.desiredAssertionStatus());
    public static final int DEFAULT_MAX_CONCURRENT = 8;
    private final Executor executor;
    private final int maxConcurrent;
    private WorkNode pendingJobs;
    private int runningCount;
    private WorkNode runningJobs;
    private final Object workLock;

    public interface WorkItem {
        boolean cancel();

        boolean isRunning();

        void moveToFront();
    }

    class WorkNode implements WorkItem {
        static final /* synthetic */ boolean $assertionsDisabled = (!WorkQueue.class.desiredAssertionStatus());
        private final Runnable callback;
        private boolean isRunning;
        private WorkNode next;
        private WorkNode prev;

        static {
            AppMethodBeat.i(72600);
            AppMethodBeat.o(72600);
        }

        WorkNode(Runnable runnable) {
            this.callback = runnable;
        }

        public boolean cancel() {
            AppMethodBeat.i(72595);
            synchronized (WorkQueue.this.workLock) {
                try {
                    if (isRunning()) {
                        AppMethodBeat.o(72595);
                        return false;
                    }
                    WorkQueue.this.pendingJobs = removeFromList(WorkQueue.this.pendingJobs);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(72595);
                }
            }
            return true;
        }

        public void moveToFront() {
            AppMethodBeat.i(72596);
            synchronized (WorkQueue.this.workLock) {
                try {
                    if (!isRunning()) {
                        WorkQueue.this.pendingJobs = removeFromList(WorkQueue.this.pendingJobs);
                        WorkQueue.this.pendingJobs = addToList(WorkQueue.this.pendingJobs, true);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(72596);
                }
            }
        }

        public boolean isRunning() {
            return this.isRunning;
        }

        /* Access modifiers changed, original: 0000 */
        public Runnable getCallback() {
            return this.callback;
        }

        /* Access modifiers changed, original: 0000 */
        public WorkNode getNext() {
            return this.next;
        }

        /* Access modifiers changed, original: 0000 */
        public void setIsRunning(boolean z) {
            this.isRunning = z;
        }

        /* Access modifiers changed, original: 0000 */
        public WorkNode addToList(WorkNode workNode, boolean z) {
            AppMethodBeat.i(72597);
            AssertionError assertionError;
            if (!$assertionsDisabled && this.next != null) {
                assertionError = new AssertionError();
                AppMethodBeat.o(72597);
                throw assertionError;
            } else if ($assertionsDisabled || this.prev == null) {
                WorkNode workNode2;
                if (workNode == null) {
                    this.prev = this;
                    this.next = this;
                    workNode2 = this;
                } else {
                    this.next = workNode;
                    this.prev = workNode.prev;
                    workNode2 = this.next;
                    this.prev.next = this;
                    workNode2.prev = this;
                    workNode2 = workNode;
                }
                if (z) {
                    AppMethodBeat.o(72597);
                    return this;
                }
                AppMethodBeat.o(72597);
                return workNode2;
            } else {
                assertionError = new AssertionError();
                AppMethodBeat.o(72597);
                throw assertionError;
            }
        }

        /* Access modifiers changed, original: 0000 */
        public WorkNode removeFromList(WorkNode workNode) {
            AppMethodBeat.i(72598);
            AssertionError assertionError;
            if (!$assertionsDisabled && this.next == null) {
                assertionError = new AssertionError();
                AppMethodBeat.o(72598);
                throw assertionError;
            } else if ($assertionsDisabled || this.prev != null) {
                if (workNode == this) {
                    if (this.next == this) {
                        workNode = null;
                    } else {
                        workNode = this.next;
                    }
                }
                this.next.prev = this.prev;
                this.prev.next = this.next;
                this.prev = null;
                this.next = null;
                AppMethodBeat.o(72598);
                return workNode;
            } else {
                assertionError = new AssertionError();
                AppMethodBeat.o(72598);
                throw assertionError;
            }
        }

        /* Access modifiers changed, original: 0000 */
        public void verify(boolean z) {
            AppMethodBeat.i(72599);
            AssertionError assertionError;
            if (!$assertionsDisabled && this.prev.next != this) {
                assertionError = new AssertionError();
                AppMethodBeat.o(72599);
                throw assertionError;
            } else if (!$assertionsDisabled && this.next.prev != this) {
                assertionError = new AssertionError();
                AppMethodBeat.o(72599);
                throw assertionError;
            } else if ($assertionsDisabled || isRunning() == z) {
                AppMethodBeat.o(72599);
            } else {
                assertionError = new AssertionError();
                AppMethodBeat.o(72599);
                throw assertionError;
            }
        }
    }

    static {
        AppMethodBeat.i(72610);
        AppMethodBeat.o(72610);
    }

    static /* synthetic */ void access$000(WorkQueue workQueue, WorkNode workNode) {
        AppMethodBeat.i(72609);
        workQueue.finishItemAndStartNew(workNode);
        AppMethodBeat.o(72609);
    }

    public WorkQueue() {
        this(8);
    }

    public WorkQueue(int i) {
        this(i, FacebookSdk.getExecutor());
        AppMethodBeat.i(72601);
        AppMethodBeat.o(72601);
    }

    public WorkQueue(int i, Executor executor) {
        AppMethodBeat.i(72602);
        this.workLock = new Object();
        this.runningJobs = null;
        this.runningCount = 0;
        this.maxConcurrent = i;
        this.executor = executor;
        AppMethodBeat.o(72602);
    }

    public WorkItem addActiveWorkItem(Runnable runnable) {
        AppMethodBeat.i(72603);
        WorkItem addActiveWorkItem = addActiveWorkItem(runnable, true);
        AppMethodBeat.o(72603);
        return addActiveWorkItem;
    }

    public WorkItem addActiveWorkItem(Runnable runnable, boolean z) {
        AppMethodBeat.i(72604);
        WorkItem workNode = new WorkNode(runnable);
        synchronized (this.workLock) {
            try {
                this.pendingJobs = workNode.addToList(this.pendingJobs, z);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(72604);
            }
        }
        startItem();
        return workNode;
    }

    public void validate() {
        AppMethodBeat.i(72605);
        synchronized (this.workLock) {
            int i = 0;
            try {
                if (this.runningJobs != null) {
                    WorkNode workNode = this.runningJobs;
                    while (true) {
                        workNode.verify(true);
                        i++;
                        workNode = workNode.getNext();
                        if (workNode == this.runningJobs) {
                            break;
                        }
                    }
                }
                if ($assertionsDisabled || this.runningCount == i) {
                } else {
                    Object assertionError = new AssertionError();
                    throw assertionError;
                }
            } finally {
                AppMethodBeat.o(72605);
            }
        }
        AppMethodBeat.o(72605);
    }

    private void startItem() {
        AppMethodBeat.i(72606);
        finishItemAndStartNew(null);
        AppMethodBeat.o(72606);
    }

    private void finishItemAndStartNew(WorkNode workNode) {
        AppMethodBeat.i(72607);
        WorkNode workNode2 = null;
        synchronized (this.workLock) {
            if (workNode != null) {
                try {
                    this.runningJobs = workNode.removeFromList(this.runningJobs);
                    this.runningCount--;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(72607);
                    }
                }
            }
            if (this.runningCount < this.maxConcurrent) {
                workNode2 = this.pendingJobs;
                if (workNode2 != null) {
                    this.pendingJobs = workNode2.removeFromList(this.pendingJobs);
                    this.runningJobs = workNode2.addToList(this.runningJobs, false);
                    this.runningCount++;
                    workNode2.setIsRunning(true);
                }
            }
        }
        if (workNode2 != null) {
            execute(workNode2);
        }
        AppMethodBeat.o(72607);
    }

    private void execute(final WorkNode workNode) {
        AppMethodBeat.i(72608);
        this.executor.execute(new Runnable() {
            public void run() {
                AppMethodBeat.i(72594);
                try {
                    workNode.getCallback().run();
                } finally {
                    WorkQueue.access$000(WorkQueue.this, workNode);
                    AppMethodBeat.o(72594);
                }
            }
        });
        AppMethodBeat.o(72608);
    }
}
