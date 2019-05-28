package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class zze implements Runnable {
    private static final Logger zzer = new Logger("RevokeAccessOperation", new String[0]);
    private final StatusPendingResult zzes = new StatusPendingResult(null);
    private final String zzz;

    static {
        AppMethodBeat.m2504i(50420);
        AppMethodBeat.m2505o(50420);
    }

    private zze(String str) {
        AppMethodBeat.m2504i(50417);
        Preconditions.checkNotEmpty(str);
        this.zzz = str;
        AppMethodBeat.m2505o(50417);
    }

    public static PendingResult<Status> zzg(String str) {
        AppMethodBeat.m2504i(50419);
        if (str == null) {
            PendingResult immediateFailedResult = PendingResults.immediateFailedResult(new Status(4), null);
            AppMethodBeat.m2505o(50419);
            return immediateFailedResult;
        }
        zze zze = new zze(str);
        new Thread(zze).start();
        StatusPendingResult statusPendingResult = zze.zzes;
        AppMethodBeat.m2505o(50419);
        return statusPendingResult;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        Result result;
        IOException e;
        Result result2;
        Logger logger;
        String str;
        Exception e2;
        AppMethodBeat.m2504i(50418);
        Status status = Status.RESULT_INTERNAL_ERROR;
        String valueOf;
        Object result3;
        try {
            String valueOf2 = String.valueOf("https://accounts.google.com/o/oauth2/revoke?token=");
            valueOf = String.valueOf(this.zzz);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2)).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                result3 = Status.RESULT_SUCCESS;
            } else {
                zzer.mo59627e("Unable to revoke access!", new Object[0]);
                result3 = status;
            }
            try {
                zzer.mo59625d("Response Code: " + responseCode, new Object[0]);
            } catch (IOException e3) {
                e = e3;
                result2 = result3;
                logger = zzer;
                str = "IOException when revoking access: ";
                valueOf = String.valueOf(e.toString());
                logger.mo59627e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
                result3 = status;
                this.zzes.setResult(result3);
                AppMethodBeat.m2505o(50418);
            } catch (Exception e4) {
                e2 = e4;
                result2 = result3;
                logger = zzer;
                str = "Exception when revoking access: ";
                valueOf = String.valueOf(e2.toString());
                if (valueOf.length() == 0) {
                }
                logger.mo59627e(valueOf.length() == 0 ? str.concat(valueOf) : new String(str), new Object[0]);
                result3 = status;
                this.zzes.setResult(result3);
                AppMethodBeat.m2505o(50418);
            }
        } catch (IOException e5) {
            e = e5;
        } catch (Exception e6) {
            e2 = e6;
            logger = zzer;
            str = "Exception when revoking access: ";
            valueOf = String.valueOf(e2.toString());
            logger.mo59627e(valueOf.length() == 0 ? str.concat(valueOf) : new String(str), new Object[0]);
            result3 = status;
            this.zzes.setResult(result3);
            AppMethodBeat.m2505o(50418);
        }
        this.zzes.setResult(result3);
        AppMethodBeat.m2505o(50418);
    }
}
