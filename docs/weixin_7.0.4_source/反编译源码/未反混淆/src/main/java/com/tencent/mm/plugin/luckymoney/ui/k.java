package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;

public final class k {

    enum a {
        NOTSET,
        ON,
        OFF;

        static {
            AppMethodBeat.o(43074);
        }
    }

    static void a(Context context, a aVar) {
        AppMethodBeat.i(43075);
        if (context == null || aVar == null) {
            ab.e("MicroMsg.LuckySoundUtil", "play Err context:%s pathId:%d speekeron:%s looping:%b", context, Integer.valueOf(R.string.cpw), aVar, Boolean.FALSE);
            AppMethodBeat.o(43075);
        } else if (!com.tencent.mm.m.a.MC()) {
            AppMethodBeat.o(43075);
        } else if (com.tencent.mm.m.a.MG()) {
            final String string = context.getString(R.string.cpw);
            com.tencent.mm.compatible.b.k kVar = new com.tencent.mm.compatible.b.k();
            if (aVar != a.NOTSET) {
                kVar.setAudioStreamType(aVar == a.ON ? 5 : 0);
            }
            ab.i("MicroMsg.LuckySoundUtil", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b ", Integer.valueOf(kVar.hashCode()), string, context, Integer.valueOf(R.string.cpw), aVar, Boolean.FALSE);
            try {
                AssetFileDescriptor openFd = context.getAssets().openFd(string);
                kVar.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                openFd.close();
                kVar.setLooping(false);
                kVar.prepare();
                kVar.start();
                kVar.setOnErrorListener(new OnErrorListener() {
                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        AppMethodBeat.i(43070);
                        ab.i("MicroMsg.LuckySoundUtil", "onError, what: %d, extra: %d", Integer.valueOf(i), Integer.valueOf(i2));
                        AppMethodBeat.o(43070);
                        return false;
                    }
                });
                kVar.setOnCompletionListener(new OnCompletionListener() {
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        AppMethodBeat.i(43071);
                        String str = "MicroMsg.LuckySoundUtil";
                        String str2 = "play completion mp:%d  path:%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
                        objArr[1] = string;
                        ab.i(str, str2, objArr);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        AppMethodBeat.o(43071);
                    }
                });
                AppMethodBeat.o(43075);
            } catch (Exception e) {
                ab.e("MicroMsg.LuckySoundUtil", "play failed pathId:%d e:%s", Integer.valueOf(R.string.cpw), e.getMessage());
                ab.printErrStackTrace("MicroMsg.LuckySoundUtil", e, "", new Object[0]);
                AppMethodBeat.o(43075);
            }
        } else {
            AppMethodBeat.o(43075);
        }
    }
}
