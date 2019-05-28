package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p219b.C45289k;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.k */
public final class C43285k {

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.k$1 */
    static class C124731 implements OnErrorListener {
        C124731() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(43070);
            C4990ab.m7417i("MicroMsg.LuckySoundUtil", "onError, what: %d, extra: %d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(43070);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.k$a */
    enum C28461a {
        NOTSET,
        ON,
        OFF;

        static {
            AppMethodBeat.m2505o(43074);
        }
    }

    /* renamed from: a */
    static void m77151a(Context context, C28461a c28461a) {
        AppMethodBeat.m2504i(43075);
        if (context == null || c28461a == null) {
            C4990ab.m7413e("MicroMsg.LuckySoundUtil", "play Err context:%s pathId:%d speekeron:%s looping:%b", context, Integer.valueOf(C25738R.string.cpw), c28461a, Boolean.FALSE);
            AppMethodBeat.m2505o(43075);
        } else if (!C37885a.m63950MC()) {
            AppMethodBeat.m2505o(43075);
        } else if (C37885a.m63954MG()) {
            final String string = context.getString(C25738R.string.cpw);
            C45289k c45289k = new C45289k();
            if (c28461a != C28461a.NOTSET) {
                c45289k.setAudioStreamType(c28461a == C28461a.ON ? 5 : 0);
            }
            C4990ab.m7417i("MicroMsg.LuckySoundUtil", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b ", Integer.valueOf(c45289k.hashCode()), string, context, Integer.valueOf(C25738R.string.cpw), c28461a, Boolean.FALSE);
            try {
                AssetFileDescriptor openFd = context.getAssets().openFd(string);
                c45289k.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                openFd.close();
                c45289k.setLooping(false);
                c45289k.prepare();
                c45289k.start();
                c45289k.setOnErrorListener(new C124731());
                c45289k.setOnCompletionListener(new OnCompletionListener() {
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        AppMethodBeat.m2504i(43071);
                        String str = "MicroMsg.LuckySoundUtil";
                        String str2 = "play completion mp:%d  path:%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
                        objArr[1] = string;
                        C4990ab.m7417i(str, str2, objArr);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        AppMethodBeat.m2505o(43071);
                    }
                });
                AppMethodBeat.m2505o(43075);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.LuckySoundUtil", "play failed pathId:%d e:%s", Integer.valueOf(C25738R.string.cpw), e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.LuckySoundUtil", e, "", new Object[0]);
                AppMethodBeat.m2505o(43075);
            }
        } else {
            AppMethodBeat.m2505o(43075);
        }
    }
}
