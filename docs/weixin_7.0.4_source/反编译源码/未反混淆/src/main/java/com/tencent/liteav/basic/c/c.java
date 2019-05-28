package com.tencent.liteav.basic.c;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.tencent.liteav.basic.util.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class c extends a {
    private Context b;
    private String c;
    private String d;
    private String e;
    private b f;
    private long g;
    private long h;
    private boolean i;

    public c(Context context, String str, String str2, String str3, b bVar, boolean z) {
        this.b = context;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = bVar;
        this.i = z;
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
        AppMethodBeat.i(66093);
        if (!a.a(this.b) || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e) || !this.c.startsWith("http")) {
            a(null, 0);
            AppMethodBeat.o(66093);
            return;
        }
        File file = new File(this.d);
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.isFile() && this.f != null) {
            this.f.a(file, null);
            AppMethodBeat.o(66093);
            return;
        }
        File file2 = new File(this.d + File.separator + this.e);
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        try {
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(this.c).openConnection();
            d dVar;
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
                    if (this.i) {
                        this.g = (long) httpURLConnection3.getContentLength();
                        if (this.g <= 0) {
                            if (this.f != null) {
                                this.f.a(file2, null);
                            }
                            if (httpURLConnection3 != null) {
                                try {
                                    httpURLConnection3.disconnect();
                                } catch (IOException e) {
                                    AppMethodBeat.o(66093);
                                    return;
                                }
                            }
                            if (this.f != null) {
                                this.f.a();
                            }
                            AppMethodBeat.o(66093);
                            return;
                        } else if (!a.a(this.g)) {
                            if (this.f != null) {
                                this.f.a(file2, null);
                            }
                            if (httpURLConnection3 != null) {
                                try {
                                    httpURLConnection3.disconnect();
                                } catch (IOException e2) {
                                    AppMethodBeat.o(66093);
                                    return;
                                }
                            }
                            if (this.f != null) {
                                this.f.a();
                            }
                            AppMethodBeat.o(66093);
                            return;
                        }
                    }
                    inputStream = httpURLConnection3.getInputStream();
                    try {
                        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            this.h = 0;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                                if (this.i) {
                                    int i2 = (int) ((this.h * 100) / this.g);
                                    this.h += (long) read;
                                    read = (int) ((this.h * 100) / this.g);
                                    if (!(i2 == read || this.f == null)) {
                                        this.f.a(read);
                                    }
                                }
                            }
                            fileOutputStream.flush();
                            if (this.f != null) {
                                this.f.a(100);
                                this.f.a(file2);
                            }
                            dVar = null;
                        } catch (Exception e3) {
                            dVar = e3;
                            httpURLConnection = httpURLConnection3;
                            if (fileOutputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (this.f != null) {
                            }
                            this.f.a(file2, null);
                            AppMethodBeat.o(66093);
                        } catch (Throwable th2) {
                            th = th2;
                            httpURLConnection2 = httpURLConnection3;
                            if (fileOutputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (httpURLConnection2 != null) {
                            }
                            if (this.f != null) {
                            }
                            AppMethodBeat.o(66093);
                            throw th;
                        }
                    } catch (Exception e4) {
                        dVar = e4;
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
                        if (this.f != null) {
                            this.f.a();
                        }
                        this.f.a(file2, null);
                        AppMethodBeat.o(66093);
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                        httpURLConnection2 = httpURLConnection3;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e6) {
                                AppMethodBeat.o(66093);
                                throw th;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        if (this.f != null) {
                            this.f.a();
                        }
                        AppMethodBeat.o(66093);
                        throw th;
                    }
                }
                dVar = new d("http status got exception. code = ".concat(String.valueOf(responseCode)));
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
                if (this.f != null) {
                    this.f.a();
                }
            } catch (Exception e8) {
                dVar = e8;
                fileOutputStream = null;
                inputStream = null;
                httpURLConnection = httpURLConnection3;
                if (fileOutputStream != null) {
                }
                if (inputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                if (this.f != null) {
                }
                this.f.a(file2, null);
                AppMethodBeat.o(66093);
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
                if (this.f != null) {
                }
                AppMethodBeat.o(66093);
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
            if (this.f != null) {
            }
            this.f.a(file2, null);
            AppMethodBeat.o(66093);
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
            if (this.f != null) {
            }
            AppMethodBeat.o(66093);
            throw th;
        }
        if ((i == 0 || dVar != null) && this.f != null) {
            this.f.a(file2, null);
        }
        AppMethodBeat.o(66093);
    }

    private void a(Exception exception, int i) {
        AppMethodBeat.i(66094);
        if (this.f != null) {
            this.f.a(null, exception);
        }
        this.f = null;
        AppMethodBeat.o(66094);
    }
}
