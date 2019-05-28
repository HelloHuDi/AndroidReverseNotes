package com.tencent.liteav.basic.p810c;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.tencent.liteav.basic.util.C37356a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.tencent.liteav.basic.c.c */
public class C17776c extends C8794a {
    /* renamed from: b */
    private Context f4117b;
    /* renamed from: c */
    private String f4118c;
    /* renamed from: d */
    private String f4119d;
    /* renamed from: e */
    private String f4120e;
    /* renamed from: f */
    private C25646b f4121f;
    /* renamed from: g */
    private long f4122g;
    /* renamed from: h */
    private long f4123h;
    /* renamed from: i */
    private boolean f4124i;

    public C17776c(Context context, String str, String str2, String str3, C25646b c25646b, boolean z) {
        this.f4117b = context;
        this.f4118c = str;
        this.f4119d = str2;
        this.f4120e = str3;
        this.f4121f = c25646b;
        this.f4124i = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x0164 A:{SYNTHETIC, Splitter:B:83:0x0164} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0169 A:{Catch:{ IOException -> 0x01fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x016e A:{Catch:{ IOException -> 0x01fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0175 A:{Catch:{ IOException -> 0x01fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01d5 A:{SYNTHETIC, Splitter:B:120:0x01d5} */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01da A:{Catch:{ IOException -> 0x01ef }} */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01df A:{Catch:{ IOException -> 0x01ef }} */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01e6 A:{Catch:{ IOException -> 0x01ef }} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0164 A:{SYNTHETIC, Splitter:B:83:0x0164} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0169 A:{Catch:{ IOException -> 0x01fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x016e A:{Catch:{ IOException -> 0x01fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0175 A:{Catch:{ IOException -> 0x01fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01d5 A:{SYNTHETIC, Splitter:B:120:0x01d5} */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01da A:{Catch:{ IOException -> 0x01ef }} */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01df A:{Catch:{ IOException -> 0x01ef }} */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01e6 A:{Catch:{ IOException -> 0x01ef }} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0164 A:{SYNTHETIC, Splitter:B:83:0x0164} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0169 A:{Catch:{ IOException -> 0x01fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x016e A:{Catch:{ IOException -> 0x01fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0175 A:{Catch:{ IOException -> 0x01fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01d5 A:{SYNTHETIC, Splitter:B:120:0x01d5} */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01da A:{Catch:{ IOException -> 0x01ef }} */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01df A:{Catch:{ IOException -> 0x01ef }} */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01e6 A:{Catch:{ IOException -> 0x01ef }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        HttpURLConnection httpURLConnection;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        int i = 0;
        AppMethodBeat.m2504i(66093);
        if (!C37356a.m62791a(this.f4117b) || TextUtils.isEmpty(this.f4118c) || TextUtils.isEmpty(this.f4119d) || TextUtils.isEmpty(this.f4120e) || !this.f4118c.startsWith("http")) {
            m27734a(null, 0);
            AppMethodBeat.m2505o(66093);
            return;
        }
        File file = new File(this.f4119d);
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.isFile() && this.f4121f != null) {
            this.f4121f.mo43374a(file, null);
            AppMethodBeat.m2505o(66093);
            return;
        }
        File file2 = new File(this.f4119d + File.separator + this.f4120e);
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        try {
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(this.f4118c).openConnection();
            C45102d c45102d;
            try {
                httpURLConnection3.setConnectTimeout(30000);
                httpURLConnection3.setReadTimeout(30000);
                httpURLConnection3.setDoInput(true);
                httpURLConnection3.setRequestMethod("GET");
                int responseCode = httpURLConnection3.getResponseCode();
                if (httpURLConnection3.getResponseCode() == 200) {
                    i = 1;
                }
                if (i != 0) {
                    if (this.f4124i) {
                        this.f4122g = (long) httpURLConnection3.getContentLength();
                        if (this.f4122g <= 0) {
                            if (this.f4121f != null) {
                                this.f4121f.mo43374a(file2, null);
                            }
                            if (httpURLConnection3 != null) {
                                try {
                                    httpURLConnection3.disconnect();
                                } catch (IOException e) {
                                    AppMethodBeat.m2505o(66093);
                                    return;
                                }
                            }
                            if (this.f4121f != null) {
                                this.f4121f.mo43371a();
                            }
                            AppMethodBeat.m2505o(66093);
                            return;
                        } else if (!C37356a.m62790a(this.f4122g)) {
                            if (this.f4121f != null) {
                                this.f4121f.mo43374a(file2, null);
                            }
                            if (httpURLConnection3 != null) {
                                try {
                                    httpURLConnection3.disconnect();
                                } catch (IOException e2) {
                                    AppMethodBeat.m2505o(66093);
                                    return;
                                }
                            }
                            if (this.f4121f != null) {
                                this.f4121f.mo43371a();
                            }
                            AppMethodBeat.m2505o(66093);
                            return;
                        }
                    }
                    inputStream = httpURLConnection3.getInputStream();
                    try {
                        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            this.f4123h = 0;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                                if (this.f4124i) {
                                    int i2 = (int) ((this.f4123h * 100) / this.f4122g);
                                    this.f4123h += (long) read;
                                    read = (int) ((this.f4123h * 100) / this.f4122g);
                                    if (!(i2 == read || this.f4121f == null)) {
                                        this.f4121f.mo43372a(read);
                                    }
                                }
                            }
                            fileOutputStream.flush();
                            if (this.f4121f != null) {
                                this.f4121f.mo43372a(100);
                                this.f4121f.mo43373a(file2);
                            }
                            c45102d = null;
                        } catch (Exception e3) {
                            c45102d = e3;
                            httpURLConnection = httpURLConnection3;
                            if (fileOutputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (this.f4121f != null) {
                            }
                            this.f4121f.mo43374a(file2, null);
                            AppMethodBeat.m2505o(66093);
                        } catch (Throwable th2) {
                            th = th2;
                            httpURLConnection2 = httpURLConnection3;
                            if (fileOutputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (httpURLConnection2 != null) {
                            }
                            if (this.f4121f != null) {
                            }
                            AppMethodBeat.m2505o(66093);
                            throw th;
                        }
                    } catch (Exception e4) {
                        c45102d = e4;
                        fileOutputStream = null;
                        httpURLConnection = httpURLConnection3;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (this.f4121f != null) {
                            this.f4121f.mo43371a();
                        }
                        this.f4121f.mo43374a(file2, null);
                        AppMethodBeat.m2505o(66093);
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                        httpURLConnection2 = httpURLConnection3;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e6) {
                                AppMethodBeat.m2505o(66093);
                                throw th;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        if (this.f4121f != null) {
                            this.f4121f.mo43371a();
                        }
                        AppMethodBeat.m2505o(66093);
                        throw th;
                    }
                }
                c45102d = new C45102d("http status got exception. code = ".concat(String.valueOf(responseCode)));
                fileOutputStream = null;
                inputStream = null;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e7) {
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                if (this.f4121f != null) {
                    this.f4121f.mo43371a();
                }
            } catch (Exception e8) {
                c45102d = e8;
                fileOutputStream = null;
                inputStream = null;
                httpURLConnection = httpURLConnection3;
                if (fileOutputStream != null) {
                }
                if (inputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                if (this.f4121f != null) {
                }
                this.f4121f.mo43374a(file2, null);
                AppMethodBeat.m2505o(66093);
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                inputStream = null;
                httpURLConnection2 = httpURLConnection3;
                if (fileOutputStream != null) {
                }
                if (inputStream != null) {
                }
                if (httpURLConnection2 != null) {
                }
                if (this.f4121f != null) {
                }
                AppMethodBeat.m2505o(66093);
                throw th;
            }
        } catch (Exception e9) {
            Exception e10 = e9;
            fileOutputStream = null;
            inputStream = null;
            httpURLConnection = null;
            if (fileOutputStream != null) {
            }
            if (inputStream != null) {
            }
            if (httpURLConnection != null) {
            }
            if (this.f4121f != null) {
            }
            this.f4121f.mo43374a(file2, null);
            AppMethodBeat.m2505o(66093);
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            inputStream = null;
            httpURLConnection2 = null;
            if (fileOutputStream != null) {
            }
            if (inputStream != null) {
            }
            if (httpURLConnection2 != null) {
            }
            if (this.f4121f != null) {
            }
            AppMethodBeat.m2505o(66093);
            throw th;
        }
        if ((i == 0 || c45102d != null) && this.f4121f != null) {
            this.f4121f.mo43374a(file2, null);
        }
        AppMethodBeat.m2505o(66093);
    }

    /* renamed from: a */
    private void m27734a(Exception exception, int i) {
        AppMethodBeat.m2504i(66094);
        if (this.f4121f != null) {
            this.f4121f.mo43374a(null, exception);
        }
        this.f4121f = null;
        AppMethodBeat.m2505o(66094);
    }
}
