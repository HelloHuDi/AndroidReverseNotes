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
        AppMethodBeat.m2504i(104566);
        AppMethodBeat.m2505o(104566);
    }

    public synchronized void add(PlayerListenerCallback playerListenerCallback) {
        AppMethodBeat.m2504i(104567);
        this.mCallbacks.add(playerListenerCallback);
        AppMethodBeat.m2505o(104567);
    }

    public synchronized void add(ListPlayerListenerCallback listPlayerListenerCallback) {
        AppMethodBeat.m2504i(104568);
        this.mCallbacks.addAll(listPlayerListenerCallback.toCollection());
        AppMethodBeat.m2505o(104568);
    }

    public synchronized void addAll(List<PlayerListenerCallback> list) {
        AppMethodBeat.m2504i(104569);
        this.mCallbacks.addAll(list);
        AppMethodBeat.m2505o(104569);
    }

    public synchronized List<PlayerListenerCallback> toCollection() {
        ArrayList arrayList;
        AppMethodBeat.m2504i(104570);
        arrayList = new ArrayList();
        arrayList.addAll(this.mCallbacks);
        AppMethodBeat.m2505o(104570);
        return arrayList;
    }

    public synchronized void remove(PlayerListenerCallback playerListenerCallback) {
        AppMethodBeat.m2504i(104571);
        this.mCallbacks.remove(playerListenerCallback);
        AppMethodBeat.m2505o(104571);
    }

    public synchronized void clear() {
        AppMethodBeat.m2504i(104572);
        this.mCallbacks.clear();
        AppMethodBeat.m2505o(104572);
    }

    public void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i) {
        AppMethodBeat.m2504i(104573);
        Iterator it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            ((PlayerListenerCallback) it.next()).onBufferingUpdate(baseMediaPlayer, i);
        }
        AppMethodBeat.m2505o(104573);
    }

    public void onCompletion(BaseMediaPlayer baseMediaPlayer) {
        AppMethodBeat.m2504i(104574);
        Iterator it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            ((PlayerListenerCallback) it.next()).onCompletion(baseMediaPlayer);
        }
        AppMethodBeat.m2505o(104574);
    }

    public void onSeekComplete(BaseMediaPlayer baseMediaPlayer, int i) {
        AppMethodBeat.m2504i(104575);
        Iterator it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            ((PlayerListenerCallback) it.next()).onSeekComplete(baseMediaPlayer, i);
        }
        AppMethodBeat.m2505o(104575);
    }

    public void onError(BaseMediaPlayer baseMediaPlayer, int i, int i2, int i3) {
        AppMethodBeat.m2504i(104576);
        Iterator it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            ((PlayerListenerCallback) it.next()).onError(baseMediaPlayer, i, i2, i3);
        }
        AppMethodBeat.m2505o(104576);
    }

    public void onPrepared(BaseMediaPlayer baseMediaPlayer) {
        AppMethodBeat.m2504i(104577);
        Iterator it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            ((PlayerListenerCallback) it.next()).onPrepared(baseMediaPlayer);
        }
        AppMethodBeat.m2505o(104577);
    }

    public void onStarted(BaseMediaPlayer baseMediaPlayer) {
        AppMethodBeat.m2504i(104578);
        Iterator it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            ((PlayerListenerCallback) it.next()).onStarted(baseMediaPlayer);
        }
        AppMethodBeat.m2505o(104578);
    }

    public void onStateChanged(BaseMediaPlayer baseMediaPlayer, int i) {
        AppMethodBeat.m2504i(104579);
        Iterator it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            ((PlayerListenerCallback) it.next()).onStateChanged(baseMediaPlayer, i);
        }
        AppMethodBeat.m2505o(104579);
    }
}
