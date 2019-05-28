package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DataRangeTracker {
    private static final long LOCK_INTERVAL = 2000;
    private static final String TAG = "DataRangeTracker";
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Comparator<Range> mComparator = new C161241();
    private final ArrayList<Range> mDownloadDataList = new ArrayList();
    private long mFileTotalSize = 0;
    private long waitingPosition;
    private int waitingSize;

    static class Range {
        private final long first;
        private final long second;

        /* synthetic */ Range(long j, long j2, C161241 c161241) {
            this(j, j2);
        }

        private Range(long j, long j2) {
            this.first = j;
            this.second = j2;
        }

        public String toString() {
            AppMethodBeat.m2504i(104787);
            String str = "[" + this.first + ", " + this.second + ']';
            AppMethodBeat.m2505o(104787);
            return str;
        }
    }

    /* renamed from: com.tencent.qqmusic.mediaplayer.DataRangeTracker$1 */
    class C161241 implements Comparator<Range> {
        C161241() {
        }

        public int compare(Range range, Range range2) {
            AppMethodBeat.m2504i(104779);
            int access$200 = (int) (range.first - range2.first);
            AppMethodBeat.m2505o(104779);
            return access$200;
        }
    }

    public DataRangeTracker() {
        AppMethodBeat.m2504i(104672);
        AppMethodBeat.m2505o(104672);
    }

    public void addRange(long j, long j2) {
        AppMethodBeat.m2504i(104673);
        if (j > j2) {
            Logger.m71023e(TAG, "[addRange] illegal arguments! beginPos(%s) > endPos(%s)", Long.valueOf(j), Long.valueOf(j2));
            AppMethodBeat.m2505o(104673);
            return;
        }
        this.lock.writeLock().lock();
        try {
            ArrayList arrayList = new ArrayList();
            this.mDownloadDataList.add(new Range(j, j2, null));
            Collections.sort(this.mDownloadDataList, this.mComparator);
            int size = this.mDownloadDataList.size() - 1;
            Range range = (Range) this.mDownloadDataList.get(0);
            if (size > 0) {
                int i = 1;
                Range range2 = range;
                while (i <= size) {
                    Range range3;
                    range = (Range) this.mDownloadDataList.get(i);
                    if (range2.second + 1 < range.first) {
                        arrayList.add(new Range(range2.first, range2.second, null));
                        range3 = new Range(range.first, range.second, null);
                    } else {
                        range3 = new Range(range2.first, range2.second > range.second ? range2.second : range.second, null);
                    }
                    if (i >= size) {
                        arrayList.add(range3);
                    }
                    i++;
                    range2 = range3;
                }
                this.mDownloadDataList.clear();
                this.mDownloadDataList.addAll(arrayList);
            }
            Object obj = (this.waitingPosition < 0 || this.waitingSize <= 0 || !isCached(this.waitingPosition, this.waitingSize)) ? null : 1;
            this.lock.writeLock().unlock();
            if (obj != null) {
                Logger.m71025i(TAG, "[addRange] notify position: " + this.waitingPosition + ", size: " + this.waitingSize);
                synchronized (this) {
                    try {
                        unlock();
                        this.waitingPosition = 0;
                        this.waitingSize = 0;
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(104673);
                    }
                }
                return;
            }
            AppMethodBeat.m2505o(104673);
        } catch (Throwable th) {
            this.lock.writeLock().unlock();
            AppMethodBeat.m2505o(104673);
        }
    }

    public void setFileTotalSize(long j) {
        this.mFileTotalSize = j;
    }

    public long findStart(long j) {
        AppMethodBeat.m2504i(104674);
        lockRead();
        try {
            int size = this.mDownloadDataList.size();
            if (size == 0) {
                unlockRead();
                AppMethodBeat.m2505o(104674);
                return -1;
            }
            long access$100;
            long access$1002 = ((Range) this.mDownloadDataList.get(0)).second + 1;
            for (int i = 0; i < size; i++) {
                if (j < ((Range) this.mDownloadDataList.get(i)).first) {
                    unlockRead();
                    AppMethodBeat.m2505o(104674);
                    return access$1002;
                }
                access$1002 = ((Range) this.mDownloadDataList.get(i)).second + 1;
                if (j <= ((Range) this.mDownloadDataList.get(i)).second) {
                    access$100 = ((Range) this.mDownloadDataList.get(i)).second + 1;
                    return access$100;
                }
            }
            access$100 = ((Range) this.mDownloadDataList.get(this.mDownloadDataList.size() - 1)).second + 1;
            unlockRead();
            AppMethodBeat.m2505o(104674);
            return access$100;
        } finally {
            unlockRead();
            AppMethodBeat.m2505o(104674);
        }
    }

    public long findEnd(long j) {
        AppMethodBeat.m2504i(104675);
        lockRead();
        try {
            int size = this.mDownloadDataList.size();
            if (size == 0) {
                unlockRead();
                AppMethodBeat.m2505o(104675);
                return -1;
            }
            int i = 0;
            while (i < size) {
                long access$200;
                if (j < ((Range) this.mDownloadDataList.get(i)).first) {
                    access$200 = ((Range) this.mDownloadDataList.get(i)).first - 1;
                    unlockRead();
                    AppMethodBeat.m2505o(104675);
                    return access$200;
                } else if (j > ((Range) this.mDownloadDataList.get(i)).second || i + 1 >= size) {
                    i++;
                } else {
                    access$200 = ((Range) this.mDownloadDataList.get(i + 1)).first - 1;
                    return access$200;
                }
            }
            unlockRead();
            AppMethodBeat.m2505o(104675);
            return 0;
        } finally {
            unlockRead();
            AppMethodBeat.m2505o(104675);
        }
    }

    public boolean isCached(long j, int i) {
        boolean z = false;
        AppMethodBeat.m2504i(104676);
        lockRead();
        try {
            long findStart = findStart(j);
            long findStart2 = findStart(((long) i) + j);
            long findEnd = findEnd(j);
            long findEnd2 = findEnd(((long) i) + j);
            if (findStart != findStart2 || findEnd != findEnd2) {
                unlockRead();
                AppMethodBeat.m2505o(104676);
            } else if (findEnd == -1) {
                unlockRead();
                AppMethodBeat.m2505o(104676);
            } else {
                findStart2 = ((long) i) + j;
                if (this.mFileTotalSize > 0 && findStart2 > this.mFileTotalSize) {
                    findStart2 = this.mFileTotalSize;
                }
                if (findStart2 <= findStart) {
                    z = true;
                }
                unlockRead();
                AppMethodBeat.m2505o(104676);
            }
            return z;
        } catch (Throwable th) {
            unlockRead();
            AppMethodBeat.m2505o(104676);
        }
    }

    public long getContinuousEnd() {
        AppMethodBeat.m2504i(104677);
        lockRead();
        try {
            if (this.mDownloadDataList.size() == 0) {
                unlockRead();
                AppMethodBeat.m2505o(104677);
                return -1;
            }
            long access$100 = ((Range) this.mDownloadDataList.get(0)).second;
            return access$100;
        } finally {
            unlockRead();
            AppMethodBeat.m2505o(104677);
        }
    }

    public synchronized boolean lock(long j, int i, long j2) {
        AppMethodBeat.m2504i(104678);
        Logger.m71025i(TAG, "[lock] position = [" + j + "]. size = [" + i + "]. timeout = [" + j2 + "].");
        this.waitingPosition = j;
        this.waitingSize = i;
        int i2 = (int) (j2 / 2000);
        if (i2 <= 0) {
            i2 = 1;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            wait(2000);
            if (isCached(this.waitingPosition, this.waitingSize)) {
                break;
            }
        }
        AppMethodBeat.m2505o(104678);
        return true;
    }

    public void block() {
        AppMethodBeat.m2504i(104679);
        Logger.m71025i(TAG, "[block]");
        AppMethodBeat.m2505o(104679);
    }

    public void unblock() {
        AppMethodBeat.m2504i(104680);
        Logger.m71025i(TAG, "[unblock]");
        AppMethodBeat.m2505o(104680);
    }

    public void abandonLock() {
        AppMethodBeat.m2504i(104681);
        Logger.m71025i(TAG, "[abandonLock]");
        unblock();
        unlock();
        AppMethodBeat.m2505o(104681);
    }

    public synchronized String print() {
        String stringBuilder;
        AppMethodBeat.m2504i(104682);
        this.lock.readLock().lock();
        try {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (int i = 0; i < this.mDownloadDataList.size(); i++) {
                stringBuilder2.append(((Range) this.mDownloadDataList.get(i)).toString());
            }
            stringBuilder = stringBuilder2.toString();
            this.lock.readLock().unlock();
            AppMethodBeat.m2505o(104682);
        } catch (Throwable th) {
            this.lock.readLock().unlock();
            AppMethodBeat.m2505o(104682);
        }
        return stringBuilder;
    }

    private void lockRead() {
        AppMethodBeat.m2504i(104683);
        this.lock.readLock().lock();
        AppMethodBeat.m2505o(104683);
    }

    private void unlockRead() {
        AppMethodBeat.m2504i(104684);
        this.lock.readLock().unlock();
        AppMethodBeat.m2505o(104684);
    }

    private synchronized void unlock() {
        AppMethodBeat.m2504i(104685);
        Logger.m71025i(TAG, "[unlock].");
        notifyAll();
        AppMethodBeat.m2505o(104685);
    }

    /* Access modifiers changed, original: 0000 */
    public List<Range> getEmptyContentPairList(long j) {
        AppMethodBeat.m2504i(104686);
        ArrayList arrayList = new ArrayList();
        long j2 = 0;
        synchronized (this.mDownloadDataList) {
            try {
                Iterator it = this.mDownloadDataList.iterator();
                while (it.hasNext()) {
                    Range range = (Range) it.next();
                    if (j2 < range.first) {
                        arrayList.add(new Range(j2, range.first - 1, null));
                    }
                    j2 = 1 + range.second;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(104686);
                }
            }
        }
        if (j2 < j) {
            arrayList.add(new Range(j2, j - 1, null));
        }
        AppMethodBeat.m2505o(104686);
        return arrayList;
    }
}
