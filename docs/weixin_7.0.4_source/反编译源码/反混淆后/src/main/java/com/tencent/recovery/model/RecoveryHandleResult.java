package com.tencent.recovery.model;

public class RecoveryHandleResult {
    public boolean csN;
    public boolean retry;

    public String toString() {
        return "RecoveryHandleResult{result=" + this.csN + ", retry=" + this.retry + '}';
    }
}
