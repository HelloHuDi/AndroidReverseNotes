package com.tencent.sqlitelint;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLint.InstallEnv;
import com.tencent.sqlitelint.SQLiteLint.Options;
import com.tencent.sqlitelint.behaviour.BaseBehaviour;
import com.tencent.sqlitelint.util.SLog;
import java.util.concurrent.ConcurrentHashMap;

public enum SQLiteLintAndroidCoreManager {
    INSTANCE;
    
    private static final String TAG = "SQLiteLint.SQLiteLintAndroidCoreManager";
    private ConcurrentHashMap<String, SQLiteLintAndroidCore> mCoresMap;

    static {
        AppMethodBeat.m2505o(94009);
    }

    public final void install(Context context, InstallEnv installEnv, Options options) {
        AppMethodBeat.m2504i(94004);
        String concernedDbPath = installEnv.getConcernedDbPath();
        if (this.mCoresMap.containsKey(concernedDbPath)) {
            SLog.m8895w(TAG, "install twice!! ignore", new Object[0]);
            AppMethodBeat.m2505o(94004);
            return;
        }
        this.mCoresMap.put(concernedDbPath, new SQLiteLintAndroidCore(context, installEnv, options));
        AppMethodBeat.m2505o(94004);
    }

    public final void addBehavior(BaseBehaviour baseBehaviour, String str) {
        AppMethodBeat.m2504i(94005);
        if (get(str) == null) {
            AppMethodBeat.m2505o(94005);
            return;
        }
        get(str).addBehavior(baseBehaviour);
        AppMethodBeat.m2505o(94005);
    }

    public final void removeBehavior(BaseBehaviour baseBehaviour, String str) {
        AppMethodBeat.m2504i(94006);
        if (get(str) == null) {
            AppMethodBeat.m2505o(94006);
            return;
        }
        get(str).removeBehavior(baseBehaviour);
        AppMethodBeat.m2505o(94006);
    }

    public final SQLiteLintAndroidCore get(String str) {
        AppMethodBeat.m2504i(94007);
        SQLiteLintAndroidCore sQLiteLintAndroidCore = (SQLiteLintAndroidCore) this.mCoresMap.get(str);
        AppMethodBeat.m2505o(94007);
        return sQLiteLintAndroidCore;
    }

    public final void remove(String str) {
        AppMethodBeat.m2504i(94008);
        this.mCoresMap.remove(str);
        AppMethodBeat.m2505o(94008);
    }
}
