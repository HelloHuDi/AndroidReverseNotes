package com.tencent.recovery.log;

import java.util.ArrayList;

public class RecoveryLog {
    private static RecoveryLogImpl fMG = new RecoveryCacheLog();

    public interface RecoveryLogImpl {
        /* renamed from: d */
        void mo11994d(String str, String str2, Object... objArr);

        /* renamed from: e */
        void mo11995e(String str, String str2, Object... objArr);

        /* renamed from: i */
        void mo11996i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        /* renamed from: v */
        void mo11998v(String str, String str2, Object... objArr);

        /* renamed from: w */
        void mo11999w(String str, String str2, Object... objArr);
    }

    /* renamed from: i */
    public static void m8712i(String str, String str2, Object... objArr) {
        if (fMG != null) {
            fMG.mo11996i(str, str2, objArr);
        }
    }

    /* renamed from: e */
    public static void m8711e(String str, String str2, Object... objArr) {
        if (fMG != null) {
            fMG.mo11995e(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (fMG != null) {
            fMG.printErrStackTrace(str, th, str2, objArr);
        }
    }

    /* renamed from: a */
    public static void m8710a(RecoveryLogImpl recoveryLogImpl) {
        if (fMG instanceof RecoveryCacheLog) {
            RecoveryCacheLog recoveryCacheLog = (RecoveryCacheLog) fMG;
            int size = recoveryCacheLog.Are.size();
            for (int i = 0; i < size; i++) {
                LogItem logItem = (LogItem) recoveryCacheLog.Are.get(i);
                switch (logItem.level) {
                    case 1:
                        recoveryLogImpl.mo11998v(logItem.tag, logItem.Arf, logItem.Arg);
                        break;
                    case 2:
                        recoveryLogImpl.mo11994d(logItem.tag, logItem.Arf, logItem.Arg);
                        break;
                    case 3:
                        recoveryLogImpl.mo11996i(logItem.tag, logItem.Arf, logItem.Arg);
                        break;
                    case 4:
                        recoveryLogImpl.mo11999w(logItem.tag, logItem.Arf, logItem.Arg);
                        break;
                    case 5:
                        if (logItem.Arh == null) {
                            recoveryLogImpl.mo11995e(logItem.tag, logItem.Arf, logItem.Arg);
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
            ((RecoveryFileLog) fMG).mo15972cm("", true);
        }
    }

    public static RecoveryLogImpl dQe() {
        return fMG;
    }
}
