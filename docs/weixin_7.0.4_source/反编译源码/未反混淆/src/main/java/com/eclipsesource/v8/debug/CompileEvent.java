package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.V8Object;

public class CompileEvent extends EventData {
    CompileEvent(V8Object v8Object) {
        super(v8Object);
    }
}
