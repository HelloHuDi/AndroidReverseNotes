package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class DebugHandler implements Releasable {
    private static final String CHANGE_BREAK_POINT_CONDITION = "changeBreakPointCondition";
    private static final String CLEAR_BREAK_POINT = "clearBreakPoint";
    private static final String DEBUG_BREAK_HANDLER = "__j2v8_debug_handler";
    public static String DEBUG_OBJECT_NAME = "__j2v8_Debug";
    private static final String DISABLE_ALL_BREAK_POINTS = "disableAllBreakPoints";
    private static final String DISABLE_SCRIPT_BREAK_POINT = "disableScriptBreakPoint";
    private static final String ENABLE_SCRIPT_BREAK_POINT = "enableScriptBreakPoint";
    private static final String FIND_SCRIPT_BREAK_POINT = "findScriptBreakPoint";
    private static final String NUMBER = "number";
    private static final String SCRIPT_BREAK_POINTS = "scriptBreakPoints";
    private static final String SET_BREAK_POINT = "setBreakPoint";
    private static final String SET_LISTENER = "setListener";
    private static final String SET_SCRIPT_BREAK_POINT_BY_NAME = "setScriptBreakPointByName";
    private static final String V8_DEBUG_OBJECT = "Debug";
    private List<BreakHandler> breakHandlers = new ArrayList();
    private V8Object debugObject;
    private V8 runtime;

    class BreakpointHandler implements JavaVoidCallback {
        private BreakpointHandler() {
        }

        public void invoke(V8Object v8Object, V8Array v8Array) {
            AppMethodBeat.i(74826);
            if (v8Array == null || v8Array.isUndefined()) {
                AppMethodBeat.o(74826);
                return;
            }
            int integer = v8Array.getInteger(0);
            for (BreakHandler invokeHandler : DebugHandler.this.breakHandlers) {
                invokeHandler(v8Array, integer, invokeHandler);
            }
            AppMethodBeat.o(74826);
        }

        private void invokeHandler(V8Array v8Array, int i, BreakHandler breakHandler) {
            Throwable th;
            AppMethodBeat.i(74827);
            Releasable object;
            Releasable object2;
            Releasable object3;
            Releasable executionState;
            Releasable createDebugEvent;
            try {
                object = v8Array.getObject(1);
                try {
                    object2 = v8Array.getObject(2);
                    try {
                        object3 = v8Array.getObject(3);
                        try {
                            executionState = new ExecutionState(object);
                            try {
                                DebugEvent debugEvent = DebugEvent.values()[i];
                                createDebugEvent = createDebugEvent(debugEvent, object2);
                                try {
                                    breakHandler.onBreak(debugEvent, executionState, createDebugEvent, object3);
                                    safeRelease(object);
                                    safeRelease(object2);
                                    safeRelease(object3);
                                    safeRelease(executionState);
                                    safeRelease(createDebugEvent);
                                    AppMethodBeat.o(74827);
                                } catch (Throwable th2) {
                                    th = th2;
                                    safeRelease(object);
                                    safeRelease(object2);
                                    safeRelease(object3);
                                    safeRelease(executionState);
                                    safeRelease(createDebugEvent);
                                    AppMethodBeat.o(74827);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                createDebugEvent = null;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            createDebugEvent = null;
                            executionState = null;
                            safeRelease(object);
                            safeRelease(object2);
                            safeRelease(object3);
                            safeRelease(executionState);
                            safeRelease(createDebugEvent);
                            AppMethodBeat.o(74827);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        createDebugEvent = null;
                        executionState = null;
                        object3 = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    createDebugEvent = null;
                    executionState = null;
                    object3 = null;
                    object2 = null;
                    safeRelease(object);
                    safeRelease(object2);
                    safeRelease(object3);
                    safeRelease(executionState);
                    safeRelease(createDebugEvent);
                    AppMethodBeat.o(74827);
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                createDebugEvent = null;
                executionState = null;
                object3 = null;
                object2 = null;
                object = null;
                safeRelease(object);
                safeRelease(object2);
                safeRelease(object3);
                safeRelease(executionState);
                safeRelease(createDebugEvent);
                AppMethodBeat.o(74827);
                throw th;
            }
        }

        private EventData createDebugEvent(DebugEvent debugEvent, V8Object v8Object) {
            AppMethodBeat.i(74828);
            EventData breakEvent;
            switch (debugEvent) {
                case Break:
                    breakEvent = new BreakEvent(v8Object);
                    AppMethodBeat.o(74828);
                    return breakEvent;
                case BeforeCompile:
                    breakEvent = new CompileEvent(v8Object);
                    AppMethodBeat.o(74828);
                    return breakEvent;
                case AfterCompile:
                    breakEvent = new CompileEvent(v8Object);
                    AppMethodBeat.o(74828);
                    return breakEvent;
                case Exception:
                    breakEvent = new ExceptionEvent(v8Object);
                    AppMethodBeat.o(74828);
                    return breakEvent;
                default:
                    breakEvent = new EventData(v8Object);
                    AppMethodBeat.o(74828);
                    return breakEvent;
            }
        }

        private void safeRelease(Releasable releasable) {
            AppMethodBeat.i(74829);
            if (releasable != null) {
                releasable.release();
            }
            AppMethodBeat.o(74829);
        }
    }

    public enum DebugEvent {
        Undefined(0),
        Break(1),
        Exception(2),
        NewFunction(3),
        BeforeCompile(4),
        AfterCompile(5),
        CompileError(6),
        PromiseError(7),
        AsyncTaskEvent(8);
        
        int index;

        static {
            AppMethodBeat.o(74832);
        }

        private DebugEvent(int i) {
            this.index = i;
        }
    }

    public DebugHandler(V8 v8) {
        AppMethodBeat.i(74833);
        this.runtime = v8;
        setupDebugObject(v8);
        setupBreakpointHandler();
        AppMethodBeat.o(74833);
    }

    public void addBreakHandler(BreakHandler breakHandler) {
        AppMethodBeat.i(74834);
        this.runtime.getLocker().checkThread();
        this.breakHandlers.add(breakHandler);
        AppMethodBeat.o(74834);
    }

    public void removeBreakHandler(BreakHandler breakHandler) {
        AppMethodBeat.i(74835);
        this.runtime.getLocker().checkThread();
        this.breakHandlers.remove(breakHandler);
        AppMethodBeat.o(74835);
    }

    public int setBreakpoint(V8Function v8Function) {
        AppMethodBeat.i(74836);
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push((V8Value) v8Function);
        try {
            int executeIntegerFunction = this.debugObject.executeIntegerFunction(SET_BREAK_POINT, v8Array);
            return executeIntegerFunction;
        } finally {
            v8Array.release();
            AppMethodBeat.o(74836);
        }
    }

    public int setScriptBreakpoint(String str, int i) {
        AppMethodBeat.i(74837);
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(str);
        v8Array.push(i);
        try {
            int executeIntegerFunction = this.debugObject.executeIntegerFunction(SET_SCRIPT_BREAK_POINT_BY_NAME, v8Array);
            return executeIntegerFunction;
        } finally {
            v8Array.release();
            AppMethodBeat.o(74837);
        }
    }

    public void enableScriptBreakPoint(int i) {
        AppMethodBeat.i(74838);
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        try {
            this.debugObject.executeVoidFunction(ENABLE_SCRIPT_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(74838);
        }
    }

    public void disableScriptBreakPoint(int i) {
        AppMethodBeat.i(74839);
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        try {
            this.debugObject.executeVoidFunction(DISABLE_SCRIPT_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(74839);
        }
    }

    public void clearBreakPoint(int i) {
        AppMethodBeat.i(74840);
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        try {
            this.debugObject.executeVoidFunction(CLEAR_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(74840);
        }
    }

    public void disableAllBreakPoints() {
        AppMethodBeat.i(74841);
        this.debugObject.executeVoidFunction(DISABLE_ALL_BREAK_POINTS, null);
        AppMethodBeat.o(74841);
    }

    public int getScriptBreakPointCount() {
        AppMethodBeat.i(74842);
        V8Array executeArrayFunction = this.debugObject.executeArrayFunction(SCRIPT_BREAK_POINTS, null);
        try {
            int length = executeArrayFunction.length();
            return length;
        } finally {
            executeArrayFunction.release();
            AppMethodBeat.o(74842);
        }
    }

    public int[] getScriptBreakPointIDs() {
        AppMethodBeat.i(74843);
        V8Array executeArrayFunction = this.debugObject.executeArrayFunction(SCRIPT_BREAK_POINTS, null);
        V8Object object;
        try {
            int[] iArr = new int[executeArrayFunction.length()];
            for (int i = 0; i < executeArrayFunction.length(); i++) {
                object = executeArrayFunction.getObject(i);
                iArr[i] = object.executeIntegerFunction(NUMBER, null);
                object.release();
            }
            executeArrayFunction.release();
            AppMethodBeat.o(74843);
            return iArr;
        } catch (Throwable th) {
            executeArrayFunction.release();
            AppMethodBeat.o(74843);
        }
    }

    public ScriptBreakPoint getScriptBreakPoint(int i) {
        AppMethodBeat.i(74844);
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        v8Array.push(false);
        V8Object v8Object = null;
        try {
            v8Object = this.debugObject.executeObjectFunction(FIND_SCRIPT_BREAK_POINT, v8Array);
            ScriptBreakPoint scriptBreakPoint = new ScriptBreakPoint(v8Object);
            return scriptBreakPoint;
        } finally {
            v8Array.release();
            if (v8Object != null) {
                v8Object.release();
            }
            AppMethodBeat.o(74844);
        }
    }

    public void changeBreakPointCondition(int i, String str) {
        AppMethodBeat.i(74845);
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        v8Array.push(str);
        try {
            this.debugObject.executeVoidFunction(CHANGE_BREAK_POINT_CONDITION, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(74845);
        }
    }

    public void release() {
        AppMethodBeat.i(74846);
        this.debugObject.release();
        AppMethodBeat.o(74846);
    }

    private void setupDebugObject(V8 v8) {
        AppMethodBeat.i(74847);
        V8Object object = v8.getObject(DEBUG_OBJECT_NAME);
        try {
            this.debugObject = object.getObject(V8_DEBUG_OBJECT);
        } finally {
            object.release();
            AppMethodBeat.o(74847);
        }
    }

    private void setupBreakpointHandler() {
        Throwable th;
        V8Value v8Value;
        V8Function v8Value2;
        AppMethodBeat.i(74848);
        this.debugObject.registerJavaMethod(new BreakpointHandler(), DEBUG_BREAK_HANDLER);
        V8Array push;
        try {
            V8Value v8Value3 = (V8Function) this.debugObject.getObject(DEBUG_BREAK_HANDLER);
            try {
                push = new V8Array(this.runtime).push(v8Value3);
            } catch (Throwable th2) {
                th = th2;
                push = null;
                v8Value2 = v8Value3;
            }
            try {
                this.debugObject.executeFunction(SET_LISTENER, push);
                if (!(v8Value3 == null || v8Value3.isReleased())) {
                    v8Value3.release();
                }
                if (push == null || push.isReleased()) {
                    AppMethodBeat.o(74848);
                    return;
                }
                push.release();
                AppMethodBeat.o(74848);
            } catch (Throwable th3) {
                th = th3;
                v8Value2 = v8Value3;
                if (!(v8Value2 == null || v8Value2.isReleased())) {
                    v8Value2.release();
                }
                if (!(push == null || push.isReleased())) {
                    push.release();
                }
                AppMethodBeat.o(74848);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            push = null;
            v8Value2 = null;
            v8Value2.release();
            push.release();
            AppMethodBeat.o(74848);
            throw th;
        }
    }
}
