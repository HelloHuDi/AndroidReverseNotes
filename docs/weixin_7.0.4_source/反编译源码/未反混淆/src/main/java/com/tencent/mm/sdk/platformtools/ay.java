package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.io.IOException;

public final class ay {

    public enum b {
        NOTSET,
        ON,
        OFF;

        static {
            AppMethodBeat.o(52225);
        }
    }

    public interface a {
        void EA();
    }

    public static MediaPlayer a(Context context, int i, b bVar, a aVar) {
        AppMethodBeat.i(52226);
        MediaPlayer a = a(context, i, bVar, -1, false, aVar);
        AppMethodBeat.o(52226);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0157 A:{SYNTHETIC, Splitter:B:47:0x0157} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0157 A:{SYNTHETIC, Splitter:B:47:0x0157} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static MediaPlayer a(Context context, int i, b bVar, int i2, boolean z, final a aVar) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(52227);
        if (context == null || bVar == null) {
            ab.e("MicroMsg.PlaySound", "play Err context:%s pathId:%d speekeron:%s looping:%b listener:%s", context, Integer.valueOf(i), bVar, Boolean.valueOf(z), aVar);
            AppMethodBeat.o(52227);
            return null;
        }
        final String string = context.getString(i);
        final MediaPlayer mediaPlayer = new MediaPlayer();
        if (bVar != b.NOTSET && -1 == i2) {
            mediaPlayer.setAudioStreamType(bVar == b.ON ? 3 : 8);
        } else if (i2 != -1) {
            mediaPlayer.setAudioStreamType(i2);
        }
        ab.i("MicroMsg.PlaySound", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b listener:%s ", Integer.valueOf(mediaPlayer.hashCode()), string, context, Integer.valueOf(i), bVar, Boolean.valueOf(z), aVar);
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
                        AppMethodBeat.i(52221);
                        ab.i("MicroMsg.PlaySound", "onError, what: %d, extra: %d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (mediaPlayer != null) {
                            try {
                                mediaPlayer.release();
                            } catch (Exception e) {
                            }
                        }
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        AppMethodBeat.o(52221);
                        return false;
                    }
                });
                mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        AppMethodBeat.i(52222);
                        String str = "MicroMsg.PlaySound";
                        String str2 = "play completion mp:%d  path:%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
                        objArr[1] = string;
                        ab.i(str, str2, objArr);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        if (aVar != null) {
                            aVar.EA();
                        }
                        AppMethodBeat.o(52222);
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
                ab.i(str, str2, objArr);
                if (openFd != null) {
                    try {
                        openFd.close();
                    } catch (IOException e2) {
                        ab.printErrStackTrace("MicroMsg.PlaySound", e2, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(52227);
                return mediaPlayer;
            } catch (Exception e3) {
                e = e3;
                assetFileDescriptor = openFd;
                try {
                    ab.e("MicroMsg.PlaySound", "play failed pathId:%d e:%s", Integer.valueOf(i), e.getMessage());
                    ab.printErrStackTrace("MicroMsg.PlaySound", e, "", new Object[0]);
                    mediaPlayer.release();
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException e4) {
                            ab.printErrStackTrace("MicroMsg.PlaySound", e4, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(52227);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    openFd = assetFileDescriptor;
                    if (openFd != null) {
                        try {
                            openFd.close();
                        } catch (IOException e22) {
                            ab.printErrStackTrace("MicroMsg.PlaySound", e22, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(52227);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (openFd != null) {
                }
                AppMethodBeat.o(52227);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
        } catch (Throwable th4) {
            th = th4;
            openFd = null;
            if (openFd != null) {
            }
            AppMethodBeat.o(52227);
            throw th;
        }
    }

    public static void a(Context context, a aVar) {
        AppMethodBeat.i(52228);
        a(context, R.string.ev6, b.ON, aVar);
        AppMethodBeat.o(52228);
    }

    public static void a(Context context, int i, a aVar) {
        AppMethodBeat.i(52229);
        a(context, i, b.NOTSET, aVar);
        AppMethodBeat.o(52229);
    }

    public static void au(Context context, int i) {
        AppMethodBeat.i(52230);
        a(context, i, b.NOTSET, null);
        AppMethodBeat.o(52230);
    }

    public static void gL(Context context) {
        AppMethodBeat.i(52231);
        a(context, R.string.mz, b.NOTSET, 3, false, null);
        AppMethodBeat.o(52231);
    }
}
