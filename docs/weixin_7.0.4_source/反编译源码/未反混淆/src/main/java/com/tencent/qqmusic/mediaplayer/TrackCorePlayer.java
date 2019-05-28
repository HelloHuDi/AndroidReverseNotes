package com.tencent.qqmusic.mediaplayer;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource.TrackStateCallback;
import com.tencent.qqmusic.mediaplayer.util.Logger;

class TrackCorePlayer extends CorePlayer implements TrackStateCallback {
    private static final String TAG = "TrackCorePlayer";
    private long mStartPosition = 0;

    TrackCorePlayer(IDataSource iDataSource, PlayerCallback playerCallback, Looper looper) {
        super(iDataSource, null, playerCallback, looper, new NativeDecoder());
        AppMethodBeat.i(104592);
        AppMethodBeat.o(104592);
    }

    /* Access modifiers changed, original: 0000 */
    public long getCurPosition() {
        AppMethodBeat.i(104593);
        long curPosition = super.getCurPosition() - this.mStartPosition;
        AppMethodBeat.o(104593);
        return curPosition;
    }

    public void seek(int i) {
        AppMethodBeat.i(104594);
        int i2 = (int) (((long) i) + this.mStartPosition);
        Logger.i(TAG, "seek, position: " + i + " ,realseek: " + i2);
        super.seek(i2);
        AppMethodBeat.o(104594);
    }

    public void onTrackPrepared(TrackInfo trackInfo) {
        AppMethodBeat.i(104595);
        this.mStartPosition = ((Long) trackInfo.getRange().first).longValue();
        long longValue = ((Long) trackInfo.getRange().second).longValue();
        long longValue2 = ((Long) trackInfo.getRange().first).longValue();
        Logger.i(TAG, "onTrackPrepared, start byte: " + longValue2 + ", end byte: " + longValue);
        this.mInformation.setDuration(longValue - longValue2);
        AppMethodBeat.o(104595);
    }
}
