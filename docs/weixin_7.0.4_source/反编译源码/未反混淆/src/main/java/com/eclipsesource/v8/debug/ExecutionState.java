package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.debug.mirror.Frame;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ExecutionState implements Releasable {
    private static final String FRAME = "frame";
    private static final String FRAME_COUNT = "frameCount";
    private static final String PREPARE_STEP = "prepareStep";
    private V8Object v8Object;

    ExecutionState(V8Object v8Object) {
        AppMethodBeat.i(74851);
        this.v8Object = v8Object.twin();
        AppMethodBeat.o(74851);
    }

    public int getFrameCount() {
        AppMethodBeat.i(74852);
        int executeIntegerFunction = this.v8Object.executeIntegerFunction(FRAME_COUNT, null);
        AppMethodBeat.o(74852);
        return executeIntegerFunction;
    }

    public void prepareStep(StepAction stepAction) {
        AppMethodBeat.i(74853);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(stepAction.index);
        try {
            this.v8Object.executeVoidFunction(PREPARE_STEP, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(74853);
        }
    }

    public Frame getFrame(int i) {
        AppMethodBeat.i(74854);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i);
        V8Object v8Object = null;
        try {
            v8Object = this.v8Object.executeObjectFunction(FRAME, v8Array);
            Frame frame = new Frame(v8Object);
            return frame;
        } finally {
            v8Array.release();
            if (v8Object != null) {
                v8Object.release();
            }
            AppMethodBeat.o(74854);
        }
    }

    public void release() {
        AppMethodBeat.i(74855);
        if (!(this.v8Object == null || this.v8Object.isReleased())) {
            this.v8Object.release();
            this.v8Object = null;
        }
        AppMethodBeat.o(74855);
    }
}
