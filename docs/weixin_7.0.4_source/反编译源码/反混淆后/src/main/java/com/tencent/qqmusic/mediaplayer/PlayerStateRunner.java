package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class PlayerStateRunner {
    private static final String TAG = "StateRunner";
    private WeakReference<AudioTrack> mAudioTrack = new WeakReference(null);
    private final ReadWriteLock mLock = new ReentrantReadWriteLock();
    private Integer mState;

    PlayerStateRunner(Integer num) {
        AppMethodBeat.m2504i(104781);
        this.mState = num;
        AppMethodBeat.m2505o(104781);
    }

    /* Access modifiers changed, original: 0000 */
    public Integer transfer(Integer num) {
        AppMethodBeat.m2504i(104782);
        this.mLock.writeLock().lock();
        try {
            Integer num2 = this.mState;
            this.mState = num;
            Logger.m71025i(TAG, num2.toString() + " -> " + this.mState.toString());
            return num2;
        } finally {
            this.mLock.writeLock().unlock();
            AppMethodBeat.m2505o(104782);
        }
    }

    /* Access modifiers changed, original: varargs */
    public boolean transfer(Integer num, Integer... numArr) {
        AppMethodBeat.m2504i(104783);
        this.mLock.writeLock().lock();
        try {
            if (isEqual(numArr)) {
                transfer(num);
                this.mLock.writeLock().unlock();
                AppMethodBeat.m2505o(104783);
                return true;
            }
            this.mLock.writeLock().unlock();
            AppMethodBeat.m2505o(104783);
            return false;
        } catch (Throwable th) {
            this.mLock.writeLock().unlock();
            AppMethodBeat.m2505o(104783);
        }
    }

    /* Access modifiers changed, original: varargs */
    public boolean isEqual(Integer... numArr) {
        AppMethodBeat.m2504i(104784);
        this.mLock.readLock().lock();
        try {
            for (Object equals : numArr) {
                if (this.mState.equals(equals)) {
                    this.mLock.readLock().unlock();
                    AppMethodBeat.m2505o(104784);
                    return true;
                }
            }
            return false;
        } finally {
            this.mLock.readLock().unlock();
            AppMethodBeat.m2505o(104784);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public Integer get() {
        AppMethodBeat.m2504i(104785);
        this.mLock.readLock().lock();
        try {
            int i;
            int intValue = this.mState.intValue();
            AudioTrack audioTrack = (AudioTrack) this.mAudioTrack.get();
            if (audioTrack != null) {
                switch (audioTrack.getPlayState()) {
                    case 2:
                        i = 5;
                        break;
                    case 3:
                        i = 4;
                        break;
                    default:
                        i = intValue;
                        break;
                }
                if (!this.mState.equals(Integer.valueOf(i))) {
                    Logger.m71021e(TAG, "!mState.equals(state), mstate = " + this.mState.toString() + "   state = " + i);
                }
            } else {
                i = intValue;
            }
            Integer valueOf = Integer.valueOf(i);
            return valueOf;
        } finally {
            this.mLock.readLock().unlock();
            AppMethodBeat.m2505o(104785);
        }
    }

    public void setAudioTrack(AudioTrack audioTrack) {
        AppMethodBeat.m2504i(104786);
        this.mAudioTrack = new WeakReference(audioTrack);
        AppMethodBeat.m2505o(104786);
    }
}
