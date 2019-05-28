package com.tencent.recovery.log;

import java.util.ArrayList;

public class RecoveryLog {
    private static RecoveryLogImpl fMG = new RecoveryCacheLog();

    public interface RecoveryLogImpl {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        if (fMG != null) {
            fMG.i(str, str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (fMG != null) {
            fMG.e(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (fMG != null) {
            fMG.printErrStackTrace(str, th, str2, objArr);
        }
    }

    public static void a(RecoveryLogImpl recoveryLogImpl) {
        if (fMG instanceof RecoveryCacheLog) {
            RecoveryCacheLog recoveryCacheLog = (RecoveryCacheLog) fMG;
            int size = recoveryCacheLog.Are.size();
            for (int i = 0; i < size; i++) {
                LogItem logItem = (LogItem) recoveryCacheLog.Are.get(i);
                switch (logItem.level) {
                    case 1:
                        recoveryLogImpl.v(logItem.tag, logItem.Arf, logItem.Arg);
                        break;
                    case 2:
                        recoveryLogImpl.d(logItem.tag, logItem.Arf, logItem.Arg);
                        break;
                    case 3:
                        recoveryLogImpl.i(logItem.tag, logItem.Arf, logItem.Arg);
                        break;
                    case 4:
                        recoveryLogImpl.w(logItem.tag, logItem.Arf, logItem.Arg);
                        break;
                    case 5:
                        if (logItem.Arh == null) {
                            recoveryLogImpl.e(logItem.tag, logItem.Arf, logItem.Arg);
                            break;
                        } else {
                            recoveryLogImpl.printErrStackTrace(logItem.tag, logItem.Arh, logItem.Arf, logItem.Arg);
                            break;
                        }
                    default:
                        break;
                }
            }
            recoveryCacheLog.Are = new ArrayList();
        }
        fMG = recoveryLogImpl;
    }

    public static void dQd() {
        if (fMG instanceof RecoveryFileLog) {
            ((RecoveryFileLog) fMG).cm("", true);
        }
    }

    public static RecoveryLogImpl dQe() {
        return fMG;
    }
}
