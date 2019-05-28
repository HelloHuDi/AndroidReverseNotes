package com.tencent.recovery.log;

import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import java.util.ArrayList;
import java.util.List;

public class RecoveryCacheLog implements RecoveryLogImpl {
    List<LogItem> Are = new ArrayList(100);

    class LogItem {
        String Arf;
        Object[] Arg;
        Throwable Arh;
        int level;
        String tag;

        private LogItem() {
        }

        /* synthetic */ LogItem(RecoveryCacheLog recoveryCacheLog, byte b) {
            this();
        }
    }

    public final void v(String str, String str2, Object... objArr) {
        if (this.Are.size() < 100) {
            LogItem logItem = new LogItem(this, (byte) 0);
            logItem.level = 1;
            logItem.tag = str;
            logItem.Arf = str2;
            logItem.Arg = objArr;
            this.Are.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void d(String str, String str2, Object... objArr) {
        if (this.Are.size() < 100) {
            LogItem logItem = new LogItem(this, (byte) 0);
            logItem.level = 2;
            logItem.tag = str;
            logItem.Arf = str2;
            logItem.Arg = objArr;
            this.Are.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void i(String str, String str2, Object... objArr) {
        if (this.Are.size() < 100) {
            LogItem logItem = new LogItem(this, (byte) 0);
            logItem.level = 3;
            logItem.tag = str;
            logItem.Arf = str2;
            logItem.Arg = objArr;
            this.Are.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void w(String str, String str2, Object... objArr) {
        if (this.Are.size() < 100) {
            LogItem logItem = new LogItem(this, (byte) 0);
            logItem.level = 4;
            logItem.tag = str;
            logItem.Arf = str2;
            logItem.Arg = objArr;
            this.Are.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void e(String str, String str2, Object... objArr) {
        if (this.Are.size() < 100) {
            LogItem logItem = new LogItem(this, (byte) 0);
            logItem.level = 5;
            logItem.tag = str;
            logItem.Arf = str2;
            logItem.Arg = objArr;
            this.Are.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (this.Are.size() < 100) {
            LogItem logItem = new LogItem(this, (byte) 0);
            logItem.level = 5;
            logItem.tag = str;
            logItem.Arf = str2;
            logItem.Arg = objArr;
            logItem.Arh = th;
            this.Are.add(logItem);
        }
        String.format(str2, objArr);
    }
}
