package com.eclipsesource.p097v8.utils;

import com.eclipsesource.p097v8.C45010V8;
import com.eclipsesource.p097v8.ReferenceHandler;
import com.eclipsesource.p097v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.eclipsesource.v8.utils.MemoryManager */
public class MemoryManager {
    private MemoryManagerReferenceHandler memoryManagerReferenceHandler;
    private ArrayList<V8Value> references = new ArrayList();
    private boolean released = false;
    private boolean releasing = false;
    /* renamed from: v8 */
    private C45010V8 f14673v8;

    /* renamed from: com.eclipsesource.v8.utils.MemoryManager$MemoryManagerReferenceHandler */
    class MemoryManagerReferenceHandler implements ReferenceHandler {
        private MemoryManagerReferenceHandler() {
        }

        public void v8HandleCreated(V8Value v8Value) {
            AppMethodBeat.m2504i(75033);
            MemoryManager.this.references.add(v8Value);
            AppMethodBeat.m2505o(75033);
        }

        public void v8HandleDisposed(V8Value v8Value) {
            AppMethodBeat.m2504i(75034);
            if (!MemoryManager.this.releasing) {
                Iterator it = MemoryManager.this.references.iterator();
                while (it.hasNext()) {
                    if (it.next() == v8Value) {
                        it.remove();
                        AppMethodBeat.m2505o(75034);
                        return;
                    }
                }
            }
            AppMethodBeat.m2505o(75034);
        }
    }

    public MemoryManager(C45010V8 c45010v8) {
        AppMethodBeat.m2504i(75035);
        this.f14673v8 = c45010v8;
        this.memoryManagerReferenceHandler = new MemoryManagerReferenceHandler();
        c45010v8.addReferenceHandler(this.memoryManagerReferenceHandler);
        AppMethodBeat.m2505o(75035);
    }

    public int getObjectReferenceCount() {
        AppMethodBeat.m2504i(75036);
        checkReleased();
        int size = this.references.size();
        AppMethodBeat.m2505o(75036);
        return size;
    }

    public void persist(V8Value v8Value) {
        AppMethodBeat.m2504i(75037);
        this.f14673v8.getLocker().checkThread();
        checkReleased();
        this.references.remove(v8Value);
        AppMethodBeat.m2505o(75037);
    }

    public boolean isReleased() {
        return this.released;
    }

    public void release() {
        AppMethodBeat.m2504i(75038);
        this.f14673v8.getLocker().checkThread();
        if (this.released) {
            AppMethodBeat.m2505o(75038);
            return;
        }
        this.releasing = true;
        try {
            Iterator it = this.references.iterator();
            while (it.hasNext()) {
                ((V8Value) it.next()).release();
            }
            this.f14673v8.removeReferenceHandler(this.memoryManagerReferenceHandler);
            this.references.clear();
            this.releasing = false;
            this.released = true;
            AppMethodBeat.m2505o(75038);
        } catch (Throwable th) {
            this.releasing = false;
            AppMethodBeat.m2505o(75038);
        }
    }

    private void checkReleased() {
        AppMethodBeat.m2504i(75039);
        if (this.released) {
            IllegalStateException illegalStateException = new IllegalStateException("Memory manager released");
            AppMethodBeat.m2505o(75039);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(75039);
    }
}
