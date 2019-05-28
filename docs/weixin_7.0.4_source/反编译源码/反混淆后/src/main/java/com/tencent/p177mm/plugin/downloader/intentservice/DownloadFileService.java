package com.tencent.p177mm.plugin.downloader.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.ResultReceiver;
import android.support.p057v4.app.C0363v.C0358c;
import com.facebook.internal.Utility;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/* renamed from: com.tencent.mm.plugin.downloader.intentservice.DownloadFileService */
public class DownloadFileService extends IntentService {
    private static final String TAG = DownloadFileService.class.getSimpleName();
    private ResultReceiver kMh;
    private int kMi;
    private int kMj;

    static {
        AppMethodBeat.m2504i(2337);
        AppMethodBeat.m2505o(2337);
    }

    public DownloadFileService() {
        super("com.tencent.mm.plugin.downloader.intentservice.DownloadFileService");
    }

    public void onCreate() {
        AppMethodBeat.m2504i(2334);
        super.onCreate();
        C0358c bt = C45186a.m83262bt(this, "reminder_channel_id");
        bt.mo621d("Something Download").mo623e("Download in progress").mo616as(C25738R.drawable.icon);
        startForeground(4657, bt.build());
        AppMethodBeat.m2505o(2334);
    }

    /* Access modifiers changed, original: protected */
    public void onHandleIntent(Intent intent) {
        AppMethodBeat.m2504i(2335);
        String string = intent.getExtras().getString("url");
        this.kMh = (ResultReceiver) intent.getParcelableExtra("receiver");
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download");
        if (!file.exists()) {
            file.mkdirs();
        }
        m31424d(string, new File(file, "file11.apk"));
        AppMethodBeat.m2505o(2335);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ca A:{Catch:{ IOException -> 0x00d1 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    private void m31424d(String str, File file) {
        AppMethodBeat.m2504i(2336);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            InputStream inputStream = null;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(Downloads.MIN_WAIT_FOR_NETWORK);
                httpURLConnection.setConnectTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                int intValue = Integer.valueOf(httpURLConnection.getHeaderField("Content-Length")).intValue();
                inputStream = httpURLConnection.getInputStream();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                            this.kMi = read + this.kMi;
                            Bundle bundle = new Bundle();
                            int i = (int) ((((long) this.kMi) * 100) / ((long) intValue));
                            if (i > this.kMj) {
                                bundle.putInt("progress", i);
                                this.kMh.send(4657, bundle);
                                this.kMj = i;
                            }
                        }
                    }
                    fileOutputStream.getFD().sync();
                    fileOutputStream.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    AppMethodBeat.m2505o(2336);
                }
                C4990ab.m7412e(TAG, "Server return code:".concat(String.valueOf(responseCode)));
                try {
                    fileOutputStream.getFD().sync();
                } catch (Exception e) {
                }
                try {
                    fileOutputStream.close();
                    if (inputStream != null) {
                    }
                    AppMethodBeat.m2505o(2336);
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace(TAG, e2, "", new Object[0]);
                    AppMethodBeat.m2505o(2336);
                }
            } catch (ProtocolException e3) {
                C4990ab.printErrStackTrace(TAG, e3, "", new Object[0]);
                try {
                    fileOutputStream.getFD().sync();
                } catch (Exception e4) {
                }
                try {
                    fileOutputStream.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    AppMethodBeat.m2505o(2336);
                } catch (IOException e22) {
                    C4990ab.printErrStackTrace(TAG, e22, "", new Object[0]);
                    AppMethodBeat.m2505o(2336);
                }
            } catch (MalformedURLException e5) {
                C4990ab.printErrStackTrace(TAG, e5, "", new Object[0]);
                try {
                    fileOutputStream.getFD().sync();
                } catch (Exception e6) {
                }
                try {
                    fileOutputStream.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    AppMethodBeat.m2505o(2336);
                } catch (IOException e222) {
                    C4990ab.printErrStackTrace(TAG, e222, "", new Object[0]);
                    AppMethodBeat.m2505o(2336);
                }
            } catch (IOException e2222) {
                C4990ab.printErrStackTrace(TAG, e2222, "", new Object[0]);
                try {
                    fileOutputStream.getFD().sync();
                } catch (Exception e7) {
                }
                try {
                    fileOutputStream.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    AppMethodBeat.m2505o(2336);
                } catch (IOException e22222) {
                    C4990ab.printErrStackTrace(TAG, e22222, "", new Object[0]);
                    AppMethodBeat.m2505o(2336);
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.getFD().sync();
                } catch (Exception e8) {
                }
                try {
                    fileOutputStream.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e9) {
                    C4990ab.printErrStackTrace(TAG, e9, "", new Object[0]);
                }
                AppMethodBeat.m2505o(2336);
                throw th;
            }
        } catch (FileNotFoundException e10) {
            C4990ab.m7412e(TAG, "can not fond output folder");
            C4990ab.printErrStackTrace(TAG, e10, "", new Object[0]);
            AppMethodBeat.m2505o(2336);
        }
    }
}
