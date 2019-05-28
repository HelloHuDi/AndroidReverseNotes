package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.ReferenceHandler;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public class MemoryManager {
    private MemoryManagerReferenceHandler memoryManagerReferenceHandler;
    private ArrayList<V8Value> references = new ArrayList();
    private boolean released = false;
    private boolean releasing = false;
    private V8 v8;

    class MemoryManagerReferenceHandler implements ReferenceHandler {
        private MemoryManagerReferenceHandler() {
        }

        public void v8HandleCreated(V8Value v8Value) {
            AppMethodBeat.i(75033);
            MemoryManager.this.references.add(v8Value);
            AppMethodBeat.o(75033);
        }

        public void v8HandleDisposed(V8Value v8Value) {
            AppMethodBeat.i(75034);
            if (!MemoryManager.this.releasing) {
                Iterator it = MemoryManager.this.references.iterator();
                while (it.hasNext()) {
                    if (it.next() == v8Value) {
                        it.remove();
                        AppMethodBeat.o(75034);
                        return;
                    }
                }
            }
            AppMethodBeat.o(75034);
        }
    }

    public MemoryManager(V8 v8) {
        AppMethodBeat.i(75035);
        this.v8 = v8;
        this.memoryManagerReferenceHandler = new MemoryManagerReferenceHandler();
        v8.addReferenceHandler(this.memoryManagerReferenceHandler);
        AppMethodBeat.o(75035);
    }

    public int getObjectReferenceCount() {
        AppMethodBeat.i(75036);
        checkReleased();
        int size = this.references.size();
        AppMethodBeat.o(75036);
        return size;
    }

    public void persist(V8Value v8Value) {
        AppMethodBeat.i(75037);
        this.v8.getLocker().checkThread();
        checkReleased();
        this.references.remove(v8Value);
        AppMethodBeat.o(75037);
    }

    public boolean isReleased() {
        return this.released;
    }

    public void release() {
        AppMethodBeat.i(75038);
        this.v8.getLocker().checkThread();
        if (this.released) {
            AppMethodBeat.o(75038);
            return;
        }
        this.releasing = true;
        try {
            Iterator it = this.references.iterator();
            while (it.hasNext()) {
                ((V8Value) it.next()).release();
            }
            this.v8.removeReferenceHandler(this.memoryManagerReferenceHandler);
            this.references.clear();
            this.releasing = false;
            this.released = true;
            AppMethodBeat.o(75038);
        } catch (Throwable th) {
            this.releasing = false;
            AppMethodBeat.o(75038);
        }
    }

    private void checkReleased() {
        AppMethodBeat.i(75039);
        if (this.released) {
            IllegalStateException illegalStateException = new IllegalStateException("Memory manager released");
            AppMethodBeat.o(75039);
            throw illegalStateException;
        }
        AppMethodBeat.o(75039);
    }
}
