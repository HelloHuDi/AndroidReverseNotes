package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListPlayerListenerCallback implements PlayerListenerCallback {
    private final CopyOnWriteArrayList<PlayerListenerCallback> mCallbacks = new CopyOnWriteArrayList();

    public ListPlayerListenerCallback() {
        AppMethodBeat.i(104566);
        AppMethodBeat.o(104566);
    }

    public synchronized void add(PlayerListenerCallback playerListenerCallback) {
        AppMethodBeat.i(104567);
        this.mCallbacks.add(playerListenerCallback);
        AppMethodBeat.o(104567);
    }

    public synchronized void add(ListPlayerListenerCallback listPlayerListenerCallback) {
        AppMethodBeat.i(104568);
        this.mCallbacks.addAll(listPlayerListenerCallback.toCollection());
        AppMethodBeat.o(104568);
    }

    public synchronized void addAll(List<PlayerListenerCallback> list) {
        AppMethodBeat.i(104569);
        this.mCallbacks.addAll(list);
        AppMethodBeat.o(104569);
    }

    public synchronized List<PlayerListenerCallback> toCollection() {
        ArrayList arrayList;
        AppMethodBeat.i(104570);
        arrayList = new ArrayList();
        arrayList.addAll(this.mCallbacks);
        AppMethodBeat.o(104570);
        return arrayList;
    }

    public synchronized void remove(PlayerListenerCallback playerListenerCallback) {
        AppMethodBeat.i(104571);
        this.mCallbacks.remove(playerListenerCallback);
        AppMethodBeat.o(104571);
    }

    public synchronized void clear() {
        AppMethodBeat.i(104572);
        this.mCallbacks.clear();
        AppMethodBeat.o(104572);
    }

    public void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i) {
        AppMethodBeat.i(104573);
        Iterator it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            ((PlayerListenerCallback) it.next()).onBufferingUpdate(baseMediaPlayer, i);
        }
        AppMethodBeat.o(104573);
    }

    public void onCompletion(BaseMediaPlayer baseMediaPlayer) {
        AppMethodBeat.i(104574);
        Iterator it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            ((PlayerListenerCallback) it.next()).onCompletion(baseMediaPlayer);
        }
        AppMethodBeat.o(104574);
    }

    public void onSeekComplete(BaseMediaPlayer baseMediaPlayer, int i) {
        AppMethodBeat.i(104575);
        Iterator it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            ((PlayerListenerCallback) it.next()).onSeekComplete(baseMediaPlayer, i);
        }
        AppMethodBeat.o(104575);
    }

    public void onError(BaseMediaPlayer baseMediaPlayer, int i, int i2, int i3) {
        AppMethodBeat.i(104576);
        Iterator it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            ((PlayerListenerCallback) it.next()).onError(baseMediaPlayer, i, i2, i3);
        }
        AppMethodBeat.o(104576);
    }

    public void onPrepared(BaseMediaPlayer baseMediaPlayer) {
        AppMethodBeat.i(104577);
        Iterator it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            ((PlayerListenerCallback) it.next()).onPrepared(baseMediaPlayer);
        }
        AppMethodBeat.o(104577);
    }

    public void onStarted(BaseMediaPlayer baseMediaPlayer) {
        AppMethodBeat.i(104578);
        Iterator it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            ((PlayerListenerCallback) it.next()).onStarted(baseMediaPlayer);
        }
        AppMethodBeat.o(104578);
    }

    public void onStateChanged(BaseMediaPlayer baseMediaPlayer, int i) {
        AppMethodBeat.i(104579);
        Iterator it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            ((PlayerListenerCallback) it.next()).onStateChanged(baseMediaPlayer, i);
        }
        AppMethodBeat.o(104579);
    }
}
