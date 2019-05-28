package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class GmsClientSupervisor {
    public static final int DEFAULT_BIND_FLAGS = 129;
    private static final Object zztm = new Object();
    private static GmsClientSupervisor zztn;

    protected static final class ConnectionStatusConfig {
        private final ComponentName mComponentName;
        private final String zzto;
        private final String zztp;
        private final int zztq;

        public ConnectionStatusConfig(ComponentName componentName, int i) {
            AppMethodBeat.m2504i(89616);
            this.zzto = null;
            this.zztp = null;
            this.mComponentName = (ComponentName) Preconditions.checkNotNull(componentName);
            this.zztq = i;
            AppMethodBeat.m2505o(89616);
        }

        public ConnectionStatusConfig(String str, int i) {
            AppMethodBeat.m2504i(89614);
            this.zzto = Preconditions.checkNotEmpty(str);
            this.zztp = "com.google.android.gms";
            this.mComponentName = null;
            this.zztq = i;
            AppMethodBeat.m2505o(89614);
        }

        public ConnectionStatusConfig(String str, String str2, int i) {
            AppMethodBeat.m2504i(89615);
            this.zzto = Preconditions.checkNotEmpty(str);
            this.zztp = Preconditions.checkNotEmpty(str2);
            this.mComponentName = null;
            this.zztq = i;
            AppMethodBeat.m2505o(89615);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(89620);
            if (this == obj) {
                AppMethodBeat.m2505o(89620);
                return true;
            } else if (obj instanceof ConnectionStatusConfig) {
                ConnectionStatusConfig connectionStatusConfig = (ConnectionStatusConfig) obj;
                if (Objects.equal(this.zzto, connectionStatusConfig.zzto) && Objects.equal(this.zztp, connectionStatusConfig.zztp) && Objects.equal(this.mComponentName, connectionStatusConfig.mComponentName) && this.zztq == connectionStatusConfig.zztq) {
                    AppMethodBeat.m2505o(89620);
                    return true;
                }
                AppMethodBeat.m2505o(89620);
                return false;
            } else {
                AppMethodBeat.m2505o(89620);
                return false;
            }
        }

        public final String getAction() {
            return this.zzto;
        }

        public final int getBindFlags() {
            return this.zztq;
        }

        public final ComponentName getComponentName() {
            return this.mComponentName;
        }

        public final String getPackage() {
            return this.zztp;
        }

        public final Intent getStartServiceIntent(Context context) {
            AppMethodBeat.m2504i(89618);
            Intent intent = this.zzto != null ? new Intent(this.zzto).setPackage(this.zztp) : new Intent().setComponent(this.mComponentName);
            AppMethodBeat.m2505o(89618);
            return intent;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(89619);
            int hashCode = Objects.hashCode(this.zzto, this.zztp, this.mComponentName, Integer.valueOf(this.zztq));
            AppMethodBeat.m2505o(89619);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.m2504i(89617);
            String flattenToString;
            if (this.zzto == null) {
                flattenToString = this.mComponentName.flattenToString();
                AppMethodBeat.m2505o(89617);
                return flattenToString;
            }
            flattenToString = this.zzto;
            AppMethodBeat.m2505o(89617);
            return flattenToString;
        }
    }

    public static GmsClientSupervisor getInstance(Context context) {
        synchronized (zztm) {
            if (zztn == null) {
                zztn = new zzh(context.getApplicationContext());
            }
        }
        return zztn;
    }

    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return bindService(new ConnectionStatusConfig(componentName, (int) DEFAULT_BIND_FLAGS), serviceConnection, str);
    }

    public abstract boolean bindService(ConnectionStatusConfig connectionStatusConfig, ServiceConnection serviceConnection, String str);

    public boolean bindService(String str, ServiceConnection serviceConnection, String str2) {
        return bindService(new ConnectionStatusConfig(str, (int) DEFAULT_BIND_FLAGS), serviceConnection, str2);
    }

    public boolean bindService(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        return bindService(new ConnectionStatusConfig(str, str2, i), serviceConnection, str3);
    }

    public boolean bindService(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return bindService(str, str2, DEFAULT_BIND_FLAGS, serviceConnection, str3);
    }

    @VisibleForTesting
    public abstract void resetForTesting();

    public void unbindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        unbindService(new ConnectionStatusConfig(componentName, (int) DEFAULT_BIND_FLAGS), serviceConnection, str);
    }

    public abstract void unbindService(ConnectionStatusConfig connectionStatusConfig, ServiceConnection serviceConnection, String str);

    public void unbindService(String str, ServiceConnection serviceConnection, String str2) {
        unbindService(new ConnectionStatusConfig(str, (int) DEFAULT_BIND_FLAGS), serviceConnection, str2);
    }

    public void unbindService(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        unbindService(new ConnectionStatusConfig(str, str2, i), serviceConnection, str3);
    }

    public void unbindService(String str, String str2, ServiceConnection serviceConnection, String str3) {
        unbindService(str, str2, DEFAULT_BIND_FLAGS, serviceConnection, str3);
    }
}
