package com.tencent.p177mm.modelvideo;

import android.media.MediaExtractor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.modelvideo.r */
public final class C26492r {
    private static String bytesToHexString(byte[] bArr) {
        AppMethodBeat.m2504i(117280);
        StringBuilder stringBuilder = new StringBuilder();
        if (bArr.length <= 0) {
            AppMethodBeat.m2505o(117280);
            return null;
        }
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(toHexString);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(117280);
        return stringBuilder2;
    }

    /* renamed from: ua */
    public static boolean m42228ua(String str) {
        AppMethodBeat.m2504i(117281);
        C4990ab.m7410d("MicroMsg.VideoFile", " filepath ".concat(String.valueOf(str)));
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(117281);
            return false;
        }
        InputStream inputStream = null;
        try {
            inputStream = C5730e.openRead(str);
            byte[] bArr = new byte[10];
            inputStream.read(bArr, 0, 10);
            String bytesToHexString = C26492r.bytesToHexString(bArr);
            if (!C5046bo.isNullOrNil(bytesToHexString)) {
                bytesToHexString = bytesToHexString.toUpperCase();
                C4990ab.m7410d("MicroMsg.VideoFile", "file type ".concat(String.valueOf(bytesToHexString)));
                if (bytesToHexString.contains("00000014667479707174")) {
                    C4990ab.m7410d("MicroMsg.VideoFile", "file type qt ");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                        }
                    }
                    AppMethodBeat.m2505o(117281);
                    return true;
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
        } catch (Exception e3) {
            C4990ab.m7413e("MicroMsg.VideoFile", "exception:%s", C5046bo.m7574l(e3));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.m2505o(117281);
        }
        AppMethodBeat.m2505o(117281);
        return false;
    }

    /* renamed from: ub */
    public static boolean m42229ub(String str) {
        AppMethodBeat.m2504i(117282);
        if (C5730e.m8628ct(str)) {
            InputStream inputStream = null;
            try {
                inputStream = C5730e.openRead(str);
                byte[] bArr = new byte[32];
                inputStream.read(bArr, 0, 32);
                String bytesToHexString = C26492r.bytesToHexString(bArr);
                if (C5046bo.isNullOrNil(bytesToHexString) || !bytesToHexString.toUpperCase().contains("68766331")) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                        }
                    }
                    AppMethodBeat.m2505o(117282);
                    return false;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                    }
                }
                AppMethodBeat.m2505o(117282);
                return true;
            } catch (Exception e3) {
                C4990ab.m7413e("MicroMsg.VideoFile", "exception:%s", C5046bo.m7574l(e3));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                    }
                }
                AppMethodBeat.m2505o(117282);
            }
        } else {
            AppMethodBeat.m2505o(117282);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0099 A:{Splitter:B:6:0x0025, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0099 A:{Splitter:B:6:0x0025, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d A:{LOOP_END, LOOP:0: B:9:0x002d->B:23:0x006d} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0065 A:{SYNTHETIC} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:16:0x004b, code skipped:
            r2 = th;
     */
    /* JADX WARNING: Missing block: B:17:0x004c, code skipped:
            r3 = null;
     */
    /* JADX WARNING: Missing block: B:30:0x008a, code skipped:
            r4.release();
     */
    /* JADX WARNING: Missing block: B:34:0x0092, code skipped:
            r5.release();
     */
    /* JADX WARNING: Missing block: B:37:0x0099, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:40:0x009e, code skipped:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:41:0x009f, code skipped:
            r4 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: uc */
    public static boolean m42230uc(String str) {
        String string;
        Throwable th;
        Throwable th2;
        MediaExtractor mediaExtractor = null;
        AppMethodBeat.m2504i(117283);
        if (C5730e.m8628ct(str)) {
            C4990ab.m7411d("MicroMsg.VideoFile", "check is h265 video %s", str);
            MediaExtractor mediaExtractor2;
            try {
                mediaExtractor2 = new MediaExtractor();
                try {
                    mediaExtractor2.setDataSource(str);
                    int trackCount = mediaExtractor2.getTrackCount();
                    int i = 0;
                    while (i < trackCount) {
                        string = mediaExtractor2.getTrackFormat(i).getString("mime");
                        if ("video/hevc".equalsIgnoreCase(string)) {
                            mediaExtractor2.release();
                            AppMethodBeat.m2505o(117283);
                            return true;
                        }
                        if ("video/hevc".equalsIgnoreCase(string)) {
                            i++;
                        } else {
                            mediaExtractor2.release();
                            AppMethodBeat.m2505o(117283);
                            return true;
                        }
                    }
                    mediaExtractor2.release();
                } catch (Throwable th3) {
                }
            } catch (Throwable th4) {
                th2 = th4;
                mediaExtractor2 = null;
                if (mediaExtractor2 != null) {
                }
                AppMethodBeat.m2505o(117283);
                throw th2;
            }
            AppMethodBeat.m2505o(117283);
            return false;
        }
        AppMethodBeat.m2505o(117283);
        return false;
        C4990ab.printErrStackTrace("MicroMsg.VideoFile", th, "check is h265 video %s", str);
        if ("video/hevc".equalsIgnoreCase(string)) {
        }
    }

    /* renamed from: ud */
    public static boolean m42231ud(String str) {
        AppMethodBeat.m2504i(117284);
        C4990ab.m7410d("MicroMsg.VideoFile", " filepath ".concat(String.valueOf(str)));
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(117284);
            return false;
        }
        InputStream inputStream = null;
        try {
            inputStream = C5730e.openRead(str);
            byte[] bArr = new byte[7];
            inputStream.read(bArr, 0, 7);
            String bytesToHexString = C26492r.bytesToHexString(bArr);
            if (!C5046bo.isNullOrNil(bytesToHexString)) {
                bytesToHexString = bytesToHexString.toUpperCase();
                C4990ab.m7410d("MicroMsg.VideoFile", "file type ".concat(String.valueOf(bytesToHexString)));
                if (bytesToHexString.contains("234558544D3355")) {
                    C4990ab.m7410d("MicroMsg.VideoFile", "it is m3u8 file");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                        }
                    }
                    AppMethodBeat.m2505o(117284);
                    return true;
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
        } catch (Exception e3) {
            C4990ab.m7413e("MicroMsg.VideoFile", "exception:%s", C5046bo.m7574l(e3));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.m2505o(117284);
        }
        AppMethodBeat.m2505o(117284);
        return false;
    }
}
