package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioSessionHost {
    private ArrayList<C36422a> _sessionInfoList = new ArrayList();
    private ReentrantLock mLock = new ReentrantLock();

    /* renamed from: com.tencent.rtmp.sharp.jni.TraeAudioSessionHost$a */
    public class C36422a {
        /* renamed from: a */
        public long f15111a;
    }

    public TraeAudioSessionHost() {
        AppMethodBeat.m2504i(65669);
        AppMethodBeat.m2505o(65669);
    }

    public C36422a find(long j) {
        C36422a c36422a;
        AppMethodBeat.m2504i(65670);
        this.mLock.lock();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this._sessionInfoList.size()) {
                c36422a = null;
                break;
            }
            c36422a = (C36422a) this._sessionInfoList.get(i2);
            if (c36422a.f15111a == j) {
                break;
            }
            i = i2 + 1;
        }
        this.mLock.unlock();
        AppMethodBeat.m2505o(65670);
        return c36422a;
    }

    public void add(long j, Context context) {
        AppMethodBeat.m2504i(65671);
        if (find(j) != null) {
            AppMethodBeat.m2505o(65671);
            return;
        }
        C36422a c36422a = new C36422a();
        c36422a.f15111a = j;
        this.mLock.lock();
        this._sessionInfoList.add(c36422a);
        this.mLock.unlock();
        AppMethodBeat.m2505o(65671);
    }

    public void remove(long j) {
        AppMethodBeat.m2504i(65672);
        this.mLock.lock();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this._sessionInfoList.size()) {
                break;
            } else if (((C36422a) this._sessionInfoList.get(i2)).f15111a == j) {
                this._sessionInfoList.remove(i2);
                break;
            } else {
                i = i2 + 1;
            }
        }
        this.mLock.unlock();
        AppMethodBeat.m2505o(65672);
    }
}
