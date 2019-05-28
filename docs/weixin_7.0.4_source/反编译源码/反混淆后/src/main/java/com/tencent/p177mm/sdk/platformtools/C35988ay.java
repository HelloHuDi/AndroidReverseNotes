package com.tencent.p177mm.sdk.platformtools;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import java.io.IOException;

/* renamed from: com.tencent.mm.sdk.platformtools.ay */
public final class C35988ay {

    /* renamed from: com.tencent.mm.sdk.platformtools.ay$b */
    public enum C23497b {
        NOTSET,
        ON,
        OFF;

        static {
            AppMethodBeat.m2505o(52225);
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.ay$a */
    public interface C30291a {
        /* renamed from: EA */
        void mo7762EA();
    }

    /* renamed from: a */
    public static MediaPlayer m59198a(Context context, int i, C23497b c23497b, C30291a c30291a) {
        AppMethodBeat.m2504i(52226);
        MediaPlayer a = C35988ay.m59197a(context, i, c23497b, -1, false, c30291a);
        AppMethodBeat.m2505o(52226);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0157 A:{SYNTHETIC, Splitter:B:47:0x0157} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0157 A:{SYNTHETIC, Splitter:B:47:0x0157} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static MediaPlayer m59197a(Context context, int i, C23497b c23497b, int i2, boolean z, final C30291a c30291a) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(52227);
        if (context == null || c23497b == null) {
            C4990ab.m7413e("MicroMsg.PlaySound", "play Err context:%s pathId:%d speekeron:%s looping:%b listener:%s", context, Integer.valueOf(i), c23497b, Boolean.valueOf(z), c30291a);
            AppMethodBeat.m2505o(52227);
            return null;
        }
        final String string = context.getString(i);
        final MediaPlayer mediaPlayer = new MediaPlayer();
        if (c23497b != C23497b.NOTSET && -1 == i2) {
            mediaPlayer.setAudioStreamType(c23497b == C23497b.ON ? 3 : 8);
        } else if (i2 != -1) {
            mediaPlayer.setAudioStreamType(i2);
        }
        C4990ab.m7417i("MicroMsg.PlaySound", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b listener:%s ", Integer.valueOf(mediaPlayer.hashCode()), string, context, Integer.valueOf(i), c23497b, Boolean.valueOf(z), c30291a);
        AssetFileDescriptor assetFileDescriptor = null;
        AssetFileDescriptor openFd;
        try {
            openFd = context.getAssets().openFd(string);
            try {
                boolean z2;
                mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                mediaPlayer.setLooping(z);
                mediaPlayer.setOnErrorListener(new OnErrorListener() {
                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        AppMethodBeat.m2504i(52221);
                        C4990ab.m7417i("MicroMsg.PlaySound", "onError, what: %d, extra: %d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (mediaPlayer != null) {
                            try {
                                mediaPlayer.release();
                            } catch (Exception e) {
                            }
                        }
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        AppMethodBeat.m2505o(52221);
                        return false;
                    }
                });
                mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        AppMethodBeat.m2504i(52222);
                        String str = "MicroMsg.PlaySound";
                        String str2 = "play completion mp:%d  path:%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
                        objArr[1] = string;
                        C4990ab.m7417i(str, str2, objArr);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        if (c30291a != null) {
                            c30291a.mo7762EA();
                        }
                        AppMethodBeat.m2505o(52222);
                    }
                });
                mediaPlayer.prepare();
                mediaPlayer.start();
                String str = "MicroMsg.PlaySound";
                String str2 = "play start mp finish [%d], myLooper[%b] mainLooper[%b]";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(mediaPlayer.hashCode());
                objArr[1] = Boolean.valueOf(Looper.myLooper() != null);
                if (Looper.getMainLooper() != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[2] = Boolean.valueOf(z2);
                C4990ab.m7417i(str, str2, objArr);
                if (openFd != null) {
                    try {
                        openFd.close();
                    } catch (IOException e2) {
                        C4990ab.printErrStackTrace("MicroMsg.PlaySound", e2, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(52227);
                return mediaPlayer;
            } catch (Exception e3) {
                e = e3;
                assetFileDescriptor = openFd;
                try {
                    C4990ab.m7413e("MicroMsg.PlaySound", "play failed pathId:%d e:%s", Integer.valueOf(i), e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.PlaySound", e, "", new Object[0]);
                    mediaPlayer.release();
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException e4) {
                            C4990ab.printErrStackTrace("MicroMsg.PlaySound", e4, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(52227);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    openFd = assetFileDescriptor;
                    if (openFd != null) {
                        try {
                            openFd.close();
                        } catch (IOException e22) {
                            C4990ab.printErrStackTrace("MicroMsg.PlaySound", e22, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(52227);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (openFd != null) {
                }
                AppMethodBeat.m2505o(52227);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
        } catch (Throwable th4) {
            th = th4;
            openFd = null;
            if (openFd != null) {
            }
            AppMethodBeat.m2505o(52227);
            throw th;
        }
    }

    /* renamed from: a */
    public static void m59200a(Context context, C30291a c30291a) {
        AppMethodBeat.m2504i(52228);
        C35988ay.m59198a(context, C25738R.string.ev6, C23497b.ON, c30291a);
        AppMethodBeat.m2505o(52228);
    }

    /* renamed from: a */
    public static void m59199a(Context context, int i, C30291a c30291a) {
        AppMethodBeat.m2504i(52229);
        C35988ay.m59198a(context, i, C23497b.NOTSET, c30291a);
        AppMethodBeat.m2505o(52229);
    }

    /* renamed from: au */
    public static void m59201au(Context context, int i) {
        AppMethodBeat.m2504i(52230);
        C35988ay.m59198a(context, i, C23497b.NOTSET, null);
        AppMethodBeat.m2505o(52230);
    }

    /* renamed from: gL */
    public static void m59202gL(Context context) {
        AppMethodBeat.m2504i(52231);
        C35988ay.m59197a(context, C25738R.string.f9029mz, C23497b.NOTSET, 3, false, null);
        AppMethodBeat.m2505o(52231);
    }
}
